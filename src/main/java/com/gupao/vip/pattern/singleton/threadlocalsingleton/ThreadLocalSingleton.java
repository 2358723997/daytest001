package com.gupao.vip.pattern.singleton.threadlocalsingleton;

/**
 * ThreadLocalSingleton类
 * ThreadLocal 不能保证其创建的对象是全局唯一，但是能保证在单个线程中是唯一的
 * @author wangjixue
 * @date 2019-05-26 00:52
 */
public class ThreadLocalSingleton {

    private ThreadLocalSingleton() {}

    // TODO: 2019-05-26 此处可与懒汉内部类式单例进行比较 
    private static final ThreadLocal<ThreadLocalSingleton> threadLocalInstance = new ThreadLocal<ThreadLocalSingleton>(){
        @Override
        protected ThreadLocalSingleton initialValue() {
            return new ThreadLocalSingleton();
        }
    };

    public static ThreadLocalSingleton getInstance(){
        return threadLocalInstance.get();
    }
}
