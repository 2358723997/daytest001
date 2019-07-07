package com.gupao.vip.pattern.proxy.staticproxy;

import com.gupao.vip.pattern.proxy.Person;

/**
 * Son类
 *
 * @author wangjixue
 * @date 2019-07-07 12:48
 */
public class Son implements Person {
    @Override
    public void findLove() {
        System.err.println("儿子要求：肤白貌美大白腿");
    }

    public void findJob(){

    }

    public void eat(){

    }
}
