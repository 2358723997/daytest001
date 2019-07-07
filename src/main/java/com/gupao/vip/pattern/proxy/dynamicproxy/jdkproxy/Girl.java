package com.gupao.vip.pattern.proxy.dynamicproxy.jdkproxy;

import com.gupao.vip.pattern.proxy.Person;

/**
 * Girl类
 *
 * @author wangjixue
 * @date 2019-07-07 14:22
 */
public class Girl implements Person {
    @Override
    public void findLove() {
        System.err.println("高富帅\n身高180CM\n有6块腹肌");
    }
}
