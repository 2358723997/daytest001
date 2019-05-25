package com.gupao.vip.pattern.factory.entity.impl;

import com.gupao.vip.pattern.factory.entity.ICourse;

/**
 * @author wangjixue
 * @date 2019-05-19 16:35
 */
public class JavaCourse implements ICourse {
    @Override
    public void record() {
        System.err.println("录制Java视频");
    }

    public void study() {
        System.err.println("学习Java视频");
    }
}
