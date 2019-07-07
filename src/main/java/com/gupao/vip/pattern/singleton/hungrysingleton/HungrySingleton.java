package com.gupao.vip.pattern.singleton.hungrysingleton;

/**
 * @author wangjixue
 * 饿汉式单例 :类加载的时候就立即初始化，并且创建单例对象。绝对线程安全。
 *
 * 优点:没有加任何的锁、执行效率比较高，在用户体验上来说，比懒汉式更好。
 * 缺点:类加载的时候就初始化，不管用与不用都占着空间，浪费了内存，有可能占着茅 坑不拉屎。
 * @date 2019-05-25 16:28
 */


/**
 * 写法一
 */
public class HungrySingleton {

    private static final HungrySingleton hungrySingleton = new HungrySingleton();

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance(){
        return hungrySingleton;
    }
}
/**
 * 写法二
 */
class HungrySingLeton2{

    private static HungrySingLeton2 hungrySingLeton2;
    static {
        hungrySingLeton2 = new HungrySingLeton2();
    }

    private HungrySingLeton2() {}

    public HungrySingLeton2 getInstance(){
        return hungrySingLeton2;
    }
}
