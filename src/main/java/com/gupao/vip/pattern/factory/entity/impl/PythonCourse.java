package com.gupao.vip.pattern.factory.entity.impl;

import com.gupao.vip.pattern.factory.entity.ICourse;

/**
 * @author wangjixue
 * @date 2019-05-19 16:35
 */
public class PythonCourse implements ICourse {
    @Override
    public void record() {
        System.err.println("录制Python视频");
    }
}
