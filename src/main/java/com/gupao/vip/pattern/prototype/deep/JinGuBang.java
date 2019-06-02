package com.gupao.vip.pattern.prototype.deep;

import java.io.Serializable;

/**
 * JinGuBang类
 *
 * @author wangjixue
 * @date 2019-06-02 12:58
 */
public class JinGuBang implements Serializable {
    public Double h =100.0;
    public Double w =10.0;

    public void big(){
        this.h = h*2;
        this.w = w*2;
    }

    public void small(){
        this.h = h/2;
        this.w = w/2;
    }
}
