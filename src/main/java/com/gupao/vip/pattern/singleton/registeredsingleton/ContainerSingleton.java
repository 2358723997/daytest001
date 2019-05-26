package com.gupao.vip.pattern.singleton.registeredsingleton;

import lombok.Data;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ContainerSingleton类
 * 容器缓存式单例
 * 优点：容器式写法适用于创建实例非常多的情况，便于管理。
 * 缺点：非线程安全
 *
 * @author wangjixue
 * @date 2019-05-26 00:19
 */

public class ContainerSingleton {

    private ContainerSingleton() {}

    private static  Map<String ,Object> container = new ConcurrentHashMap<String ,Object>();

    public Object getBean(String className){

        synchronized (container){
            Object instance = null;
            if(!container.containsKey(className)){
                try {
                    instance = Class.forName(className).newInstance();
                    container.put(className,instance);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }else{
               instance= container.get(className);
            }
            return instance;
        }
    }
}
