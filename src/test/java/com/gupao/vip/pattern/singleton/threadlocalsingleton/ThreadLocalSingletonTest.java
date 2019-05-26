package com.gupao.vip.pattern.singleton.threadlocalsingleton;

import com.gupao.vip.pattern.singleton.LazySimpleSingleton;

/**
 * ThreadLocalSingleton类
 * ThreadLocal 不能保证其创建的对象是全局唯一，但是能保证在单个线程中是唯一的
 * @author wangjixue
 * @date 2019-05-26 00:52
 */
public class ThreadLocalSingletonTest {

    public static void main(String[] args) {
        System.err.println(ThreadLocalSingleton.getInstance());
        System.err.println(ThreadLocalSingleton.getInstance());
        System.err.println(ThreadLocalSingleton.getInstance());
        System.err.println(ThreadLocalSingleton.getInstance()==ThreadLocalSingleton.getInstance());
        System.out.println("========多线程调用=======");

        Thread t1 = new Thread(new ThreadLocalExectorThread());
        Thread t2 = new Thread(new ThreadLocalExectorThread());
        t1.start();
        t2.start();
    }
}

class  ThreadLocalExectorThread implements Runnable{

    @Override
    public void run() {
        ThreadLocalSingleton lazy = ThreadLocalSingleton.getInstance();
        System.err.println(Thread.currentThread().getName()+"---"+lazy);
    }
}