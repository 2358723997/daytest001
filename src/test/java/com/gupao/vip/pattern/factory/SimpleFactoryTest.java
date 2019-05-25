package com.gupao.vip.pattern.factory;

import com.gupao.vip.pattern.factory.entity.ICourse;
import com.gupao.vip.pattern.factory.entity.impl.JavaCourse;

/**
 * @author wangjixue
 * @date 2019-05-19 16:41
 */
public class SimpleFactoryTest {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        SimpleFactory factory = new SimpleFactory();
        ICourse instance = factory.getInstance(JavaCourse.class);
        instance.record();
    }
}
