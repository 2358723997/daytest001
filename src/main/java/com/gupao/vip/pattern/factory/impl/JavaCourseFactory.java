package com.gupao.vip.pattern.factory.impl;

import com.gupao.vip.pattern.factory.ICourseFactory;
import com.gupao.vip.pattern.factory.entity.ICourse;
import com.gupao.vip.pattern.factory.entity.impl.JavaCourse;

/**
 * @author wangjixue
 * @date 2019-05-19 16:35
 */
public class JavaCourseFactory implements ICourseFactory {

    @Override
    public ICourse create() {
        return new JavaCourse();
    }
}
