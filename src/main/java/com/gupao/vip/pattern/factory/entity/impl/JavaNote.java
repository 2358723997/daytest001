package com.gupao.vip.pattern.factory.entity.impl;

import com.gupao.vip.pattern.factory.entity.INote;

/**
 * @author wangjixue
 * @date 2019-05-19 16:24
 */
public class JavaNote implements INote {

    /**
     * 记录笔记
     */
    public void note(){
        System.err.println("Java的笔记");
    };
}
