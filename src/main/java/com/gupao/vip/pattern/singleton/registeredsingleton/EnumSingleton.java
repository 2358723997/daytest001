package com.gupao.vip.pattern.singleton.registeredsingleton;

/**
 * EnumSingleton类
 * 枚举注册式单例
 * 《Effective Java》推荐的一种单例实现写法
 *
 * @author wangjixue
 * @date 2019-05-26 00:17
 */
public enum  EnumSingleton {

    INSTANCE;

    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static EnumSingleton getInstance(){
        return INSTANCE;
    }
}
