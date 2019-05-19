package com.gupao.vip.pattern.factory.entity.impl;

import com.gupao.vip.pattern.factory.entity.INote;

/**
 * @author wangjixue
 * @date 2019-05-19 16:24
 */
public class PythonNote implements INote {

    /**
     * 记录笔记
     */
    public void note(){
        System.err.println("Python的笔记");
    };
}
