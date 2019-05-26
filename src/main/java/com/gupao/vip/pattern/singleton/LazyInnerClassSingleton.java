package com.gupao.vip.pattern.singleton;

/**
 * LazyInnerClassSingleton类
 * 静态内部类
 * 兼顾饿汉式的内存浪费，也兼顾 synchronized 性能问题
 *
 * @author wangjixue
 * @date 2019-05-25 16:46
 */

public class LazyInnerClassSingleton {

    private LazyInnerClassSingleton() {
        //防止通过反射的方式获取
        if(LazyHodler.LAZY!=null){
            throw new RuntimeException("禁止通过单例的私有构造方法创建多个实例，因为违反了\"一个类在任何情况下都绝对只有一个实例\"的设计的初衷");
        }
    }

    //static:是为了使单例的空间在多个线程间共享
    //final : 保证这个方法不会被重写，重载
    public static final LazyInnerClassSingleton getInstance() {
        //在返回结果以前，一定会先加载内部类
        return LazyHodler.LAZY;
    }

    //默认不加载
    private static class LazyHodler {
        //1.分配内存地址 addr01 给LazyInnerClassSingleton对象
        //2.初始化LazyInnerClassSingleton对象
        //3.设置LAZY执行该刚分配的地址addr01
        //因为 static：代表多个线程间访问的成员变量LAZY是同一个成员变量。
        // final：代表映射的地址不变，所以每个线程T的成员变量LAZY指向的都是addr01对应的实例。
        private static final LazyInnerClassSingleton LAZY = new LazyInnerClassSingleton();
    }

}
