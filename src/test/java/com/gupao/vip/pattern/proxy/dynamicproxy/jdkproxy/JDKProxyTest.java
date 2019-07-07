package com.gupao.vip.pattern.proxy.dynamicproxy.jdkproxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * JDKProxyTest类
 *
 * @author wangjixue
 * @date 2019-07-07 14:37
 */
public class JDKProxyTest {
    public static void main(String[] args) {
        Object obj = new JDKMeiPo().getInstance(new Girl());
        try {
            Method method = obj.getClass().getMethod("findLove", null);

            method.invoke(obj);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
