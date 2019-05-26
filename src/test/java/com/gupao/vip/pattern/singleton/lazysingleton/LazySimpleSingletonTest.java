package com.gupao.vip.pattern.singleton.lazysingleton;

import com.gupao.vip.pattern.singleton.LazySimpleSingleton;

/**
 * LazySimpleSingleton类
 * 懒汉式单例
 * 在外部需要使用的时候才进行实例化
 *
 * @author wangjixue
 * @date 2019-05-25 16:46
 */
public class LazySimpleSingletonTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(new ExectorThread());
        Thread t2 = new Thread(new ExectorThread());
        t1.start();
        t2.start();

        System.err.println("end");
    }

}

class  ExectorThread implements Runnable{

    @Override
    public void run() {
        LazySimpleSingleton lazy = LazySimpleSingleton.getInstance();
        LazySimpleSingleton lazySycn = LazySimpleSingleton.getInstanceSycn();
        System.err.println(Thread.currentThread().getName()+"---"+lazy);
        System.err.println(Thread.currentThread().getName()+"---"+lazySycn);
    }
}
