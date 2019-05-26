package com.gupao.vip.pattern.singleton;

import java.io.Serializable;

/**
 * SeriableLazyInnerClassSingleton类
 * 可序列化静态内部类
 * 兼顾饿汉式的内存浪费，也兼顾 synchronized 性能问题
 * 但是反序列化会new出不同的对象实例。
 *
 * @author wangjixue
 * @date 2019-05-25 16:46
 */

public class SeriableLazyInnerClassSingleton implements Serializable {

    //序列化：将内存中的数据写入其他地方（硬盘，网络IO）；
    //具体来说：序列化就是说把内存中的状态转换成字节码以I/O流的形式写入硬盘等IO设备中永久的保存起来。



    //反序列化：将其他地方的数据写入内存
    //具体来说：将IO设备中保存的字节码通过I/O流的形式读取到内存，并转换成Java对象的过程就是反序列化。
    //注意：转换成Java对象过程中会重新new对象实例；


    //防止反序列化new新的实例对象
    private Object readResolve(){
        return getInstance();
    }


    private SeriableLazyInnerClassSingleton() {
        //防止通过反射的方式获取
        if(LazyHodler.LAZY!=null){
            throw new RuntimeException("禁止通过单例的私有构造方法创建多个实例，因为违反了\"一个类在任何情况下都绝对只有一个实例\"的设计的初衷");
        }
    }

    //static:是为了使单例的空间在多个线程间共享
    //final : 保证这个方法不会被重写，重载
    public static final SeriableLazyInnerClassSingleton getInstance() {
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
        private static final SeriableLazyInnerClassSingleton LAZY = new SeriableLazyInnerClassSingleton();
    }

}
