package com.gupao.vip.pattern.proxy.dbroute.proxy;

import com.gupao.vip.pattern.proxy.dbroute.db.DynamicDataSourceEntity;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * OrderServiceDynamicProxy类
 *
 * @author wangjixue
 * @date 2019-07-07 14:46
 */
public class OrderServiceDynamicProxy implements InvocationHandler {
    private Object target;

    public Object getInstance(Object target){
        this.target = target;
        Class<?> clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);

    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before(args[0]);
        Object obj = method.invoke(target, args);
        after();
        return obj;
    }

    private void after() {
        System.err.println("Proxy after method.");
        //还原成默认的数据源
        DynamicDataSourceEntity.restore();
    }

    /**
     * 配置数据源
     * @param target
     */
    private void before(Object target) {
        System.err.println("Proxy before method.");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");

        String yearTime = null;
        try {
            Timestamp time = (Timestamp) target.getClass().getMethod("getCreateTime").invoke(target);
            yearTime = sdf.format(new Date(time.getTime()));
            int year= Integer.valueOf(yearTime);
            System.err.println("静态代理自动分配到数据源为：DB_"+year+"的数据源处理数据");
            DynamicDataSourceEntity.set(year);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
