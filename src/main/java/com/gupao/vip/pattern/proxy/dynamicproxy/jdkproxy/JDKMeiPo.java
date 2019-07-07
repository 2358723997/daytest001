package com.gupao.vip.pattern.proxy.dynamicproxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDKMeiPo类
 *
 * @author wangjixue
 * @date 2019-07-07 14:25
 */
public class JDKMeiPo implements InvocationHandler {

    //被代理对象
    private Object target;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object obj = method.invoke(this.target, args);
        after();
        return obj;
    }
    public Object getInstance(Object target){
        this.target = target;
        Class<?> clazz = target.getClass();

        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }


    private void after() {
        System.err.println("如果合适的话，就准备办事");
    }

    private void before() {
        System.err.println("我是媒婆:我要给你找对象，现在已经拿到你的需求");
        System.err.println("开始物色");    }
}
