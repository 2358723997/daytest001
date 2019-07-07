package com.gupao.vip.pattern.proxy.staticproxy;

import com.gupao.vip.pattern.proxy.Person;

/**
 * Father类
 *
 * @author wangjixue
 * @date 2019-07-07 12:53
 */
public class Father implements Person {

    private Son son;

    public Father(Son son) {
        this.son = son;
    }

    @Override
    public void findLove() {
        System.err.println("开始给儿子物色对象");
        this.son.findLove();
        System.err.println("双方父母见面");
    }
}
