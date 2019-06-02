package com.gupao.vip.pattern.singleton.registersingleton;

import com.gupao.vip.pattern.singleton.registeredsingleton.EnumSingleton;

import java.io.*;

/**
 * EnumSingletonTest类
 *
 * @author wangjixue
 * @date 2019-05-26 00:36
 */
public class EnumSingletonTest {
    public static void main(String[] args) {
        // 通过反序列化得到的实例对象
        EnumSingleton es01 = null ;
        // 内存中的实例对象
        EnumSingleton es02 = EnumSingleton.getInstance();
        es02.setData(new Object());

        try {
            //序列化到IO设备中
            FileOutputStream fos = new FileOutputStream("EnumSingleton.seri");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(es02);
            oos.flush();
            oos.close();

            //反序列化为Java对象
            FileInputStream fis = new FileInputStream("EnumSingleton.seri");
            ObjectInputStream ois = new ObjectInputStream(fis);
            es01 = (EnumSingleton) ois.readObject();
            ois.close();

            System.err.println("EnumSingleton01 = "+es01.getData());
            System.err.println("EnumSingleton02 = "+es02.getData());
            System.out.println("======验证========");
            System.err.println(es01==es02);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
