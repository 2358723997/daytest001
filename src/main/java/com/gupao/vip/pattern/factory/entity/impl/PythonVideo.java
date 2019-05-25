package com.gupao.vip.pattern.factory.entity.impl;

import com.gupao.vip.pattern.factory.entity.IVideo;

/**
 * @author wangjixue
 * @date 2019-05-19 16:24
 */
public class PythonVideo implements IVideo {


    @Override
    public void record() {
        System.err.println("Python课程的录播视频");
    }
}
