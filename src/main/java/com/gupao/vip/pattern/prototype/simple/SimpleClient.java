package com.gupao.vip.pattern.prototype.simple;

/**
 * SimpleClient类
 *
 * @author wangjixue
 * @date 2019-06-02 11:46
 */
public class SimpleClient {
    private Prototype prototype;

    public SimpleClient(Prototype prototype) {
        this.prototype = prototype;
    }

    public Prototype startClone(Prototype prototype) {
        return prototype.clone();
    }

}
