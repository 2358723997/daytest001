package com.gupao.vip.pattern.delegate.dispatch;

import com.alibaba.fastjson.JSON;
import com.gupao.vip.pattern.delegate.dispatch.controller.MemberController;
import com.gupao.vip.pattern.delegate.dispatch.controller.OrderController;
import com.gupao.vip.pattern.delegate.dispatch.controller.SystemController;
import com.gupao.vip.pattern.delegate.dispatch.Handler;
import com.gupao.vip.pattern.proxy.dbroute.OrderService;
import com.sun.net.httpserver.HttpServer;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * DelegateDispatch类
 *
 * @author wangjixue
 * @date 2019-07-13 14:10
 */
public class DelegateDispatch extends HttpServlet {

    private static final String ERROR = "404 NOT FOUND.";

    private List<Handler> handlerMappering = new ArrayList<Handler>();

    public void init() {
        try {
            // TODO: 2019-07-21 此处可以优化问自动注入方式，通过扫描特定路径下的文件来实现 
            Class<OrderController> orderControllerClass = OrderController.class;
            handlerMappering.add(new Handler(orderControllerClass.newInstance(), orderControllerClass.getMethod("getOrderById", new Class[]{String.class}), "/web/getOrderById.json"));
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


    }

    public void service(HttpServletRequest request, HttpServletResponse response) {

        try {
            dispath(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void dispath(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 1.获取用户请求的URL
        String uri = request.getRequestURI();
        Handler handler = null;
        //2.servlet拿到URL做权衡（判断）；根据用户请求的URL，去找到这个url对应的某一个java类的方法
        for (Handler h : handlerMappering) {
            //3.通过拿到的URL去对应handlerMapping（我们把它认为是策略常量）
            if(handler.getUrl().equals(uri)){
                handler=h;
                break;
            }
        }
        if(handler==null){
            response.getWriter().write(ERROR);
        }

        Object responseData= null;
        try {
            //4.将具体的任务发个Method（通过反射调用）
            responseData = handler.getMethod().invoke(handler.getController(), request.getParameter("id"));

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //5.返回Method的执行结果
        response.getWriter().write(JSON.toJSONString(responseData));
    }

    private void oldDispath(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String uri = request.getRequestURI();
        System.err.println(uri);
        String id = request.getParameter("userId");
        if ("getMember".equals(uri)) {
            new MemberController().getMember(id);
        } else if ("getOrder".equals(uri)) {
            new OrderController().getOrder(id);
        } else if ("logout".equals(uri)) {
            new SystemController().logout();
        } else {
            response.getWriter().print("404 NOt Found.");
        }

    }

}