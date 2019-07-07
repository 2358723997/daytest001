package com.gupao.vip.pattern.proxy.dynamicproxy.cglibproxy;

import com.gupao.vip.pattern.proxy.Person;
import com.gupao.vip.pattern.proxy.dynamicproxy.jdkproxy.Girl;
import net.sf.cglib.core.DebuggingClassWriter;

/**
 * CglibTest类
 *
 * @author wangjixue
 * @date 2019-07-07 23:39
 */
public class CglibTest {
    public static void main(String[] args) {
        //利用 cglib 的代理类可以将内存中的 class 文件写入本地磁盘
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "./cglib_proxy_class/");
        Person person = (Person)new CGlibMeipo().getInstance(Girl.class);
        System.err.println(person.getClass());
        person.findLove();

    }
}
