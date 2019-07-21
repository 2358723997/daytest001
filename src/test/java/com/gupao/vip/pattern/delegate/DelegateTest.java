package com.gupao.vip.pattern.delegate;

/**
 * DelegateTest类
 *
 * @author wangjixue
 * @date 2019-07-13 12:37
 */
public class DelegateTest {
    public static void main(String[] args) {
        final  Leader leader = new Leader();
        Boss boss = new Boss();
        boss.command("鉴权",leader);
        boss.command("业务",leader);
    }
}
