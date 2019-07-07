package com.gupao.vip.pattern.proxy.staticproxy;

/**
 * FatherProxyTest类
 *
 * @author wangjixue
 * @date 2019-07-07 12:58
 */
public class FatherProxyTest {
    public static void main(String[] args) {

        Father father = new Father(new Son());
        father.findLove();
    }
}
