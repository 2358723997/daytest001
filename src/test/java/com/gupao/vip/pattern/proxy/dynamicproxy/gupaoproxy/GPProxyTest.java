package com.gupao.vip.pattern.proxy.dynamicproxy.gupaoproxy;

import com.gupao.vip.pattern.proxy.Person;
import com.gupao.vip.pattern.proxy.dynamicproxy.gpproxy.GPMeipo;
import com.gupao.vip.pattern.proxy.dynamicproxy.gpproxy.GPProxy;
import com.gupao.vip.pattern.proxy.dynamicproxy.jdkproxy.Girl;

/**
 * GPProxyTest类
 *
 * @author wangjixue
 * @date 2019-07-07 23:03
 */
public class GPProxyTest {
    public static void main(String[] args) {
        //JDK实现原理
        Person girl = (Person) new GPMeipo().getInstance(new Girl());
        System.err.println(girl.getClass());
        girl.findLove();
    }
}
