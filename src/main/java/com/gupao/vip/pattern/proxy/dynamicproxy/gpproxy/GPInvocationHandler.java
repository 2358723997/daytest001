package com.gupao.vip.pattern.proxy.dynamicproxy.gpproxy;

import java.lang.reflect.Method;

/**
 * GPInvocationHandler接口
 *
 * @author wangjixue
 * @date 2019-07-07 20:31
 */
public interface GPInvocationHandler {

    public Object invoke(Object proxy, Method method,Object[] args)throws Throwable;
}
