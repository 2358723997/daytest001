package com.gupao.vip.pattern.singleton.lazysingleton;


import com.gupao.vip.pattern.singleton.LazyInnerClassSingleton;
import com.gupao.vip.pattern.singleton.SeriableLazyInnerClassSingleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class LazyInnerClassSingletonTest {

    public static void main(String[] args) {
        Thread t1 = new Thread(new InnerExectorThread());
        Thread t2 = new Thread(new InnerExectorThread());
        t1.start();
        t2.start();
        System.err.println("end");
    }


}

class InnerExectorThread implements Runnable {

    @Override
    public void run() {
        LazyInnerClassSingleton lazy = LazyInnerClassSingleton.getInstance();
        System.err.println(Thread.currentThread().getName() + "---" + lazy);
    }

}

/**
 * 通过反射方式获取懒汉式内部类单例对象
 */
class ReflectLazyInnerClassSingletonTest{

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        ////通过反射获取私有的构造方法
        Constructor<LazyInnerClassSingleton> constructor = LazyInnerClassSingleton.class.getDeclaredConstructor();
        // 强制访问
        constructor.setAccessible(true);

        // 初始化，此次通过私有构造方法new了两次
        LazyInnerClassSingleton obj01 = constructor.newInstance();
        LazyInnerClassSingleton obj02 = constructor.newInstance();

        System.err.println(obj01);
        System.err.println(obj02);
        System.out.println("=========equal===========");
        System.err.println(obj02==obj01);

    }
}

/**
 * 通过反序列获取单例
 */
class SerializableLazyInnerClassSingletonTest {
    public static void main(String[] args) {
        // 通过反序列化得到的实例对象
        SeriableLazyInnerClassSingleton singleton01 = null;
        // 内存中的实例对象
        SeriableLazyInnerClassSingleton singleton02 = SeriableLazyInnerClassSingleton.getInstance();

        try {
            //序列化到IO设备中
            FileOutputStream fos = new FileOutputStream("SeriableLazyInnerClassSingleton.class");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(singleton02);
            oos.flush();
            oos.close();

            //反序列化为Java对象
            FileInputStream fis = new FileInputStream("SeriableLazyInnerClassSingleton.class");
            ObjectInputStream ois = new ObjectInputStream(fis);
            singleton01 = (SeriableLazyInnerClassSingleton) ois.readObject();
            ois.close();

            System.err.println("singleton01 = "+singleton01);
            System.err.println("singleton02 = "+singleton02);
            System.out.println("======验证========");
            System.err.println(singleton01==singleton02);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}



















