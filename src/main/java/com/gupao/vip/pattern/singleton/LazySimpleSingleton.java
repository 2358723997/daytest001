package com.gupao.vip.pattern.singleton;

/**
 * LazySimpleSingleton类
 * 懒汉式单例
 * 在外部需要使用的时候才进行实例化
 *
 * @author wangjixue
 * @date 2019-05-25 16:46
 */

public class LazySimpleSingleton {
    private LazySimpleSingleton() {
    }

    //静态块，公共内存区域
    private static LazySimpleSingleton lazySimpleSingleton;

    //第一种无法保证现场安全，多线程调用存在多次实例化问题，即使得到的地址值相同也可能是多次实例化后的数据，可通过debug的Thead模式进行测试
    public static LazySimpleSingleton getInstance() {
        if(lazySimpleSingleton==null){
            lazySimpleSingleton = new LazySimpleSingleton();
        }
        return lazySimpleSingleton;
    }

    public static LazySimpleSingleton getInstanceSycn() {
        if (lazySimpleSingleton == null) {
            // 互斥锁 锁级别为类锁，多线程只能串行访问该资源
            synchronized (LazySimpleSingleton.class) {
                if (lazySimpleSingleton == null) {
                    lazySimpleSingleton = new LazySimpleSingleton();
                }
            }

        }
        return lazySimpleSingleton;
    }
}
