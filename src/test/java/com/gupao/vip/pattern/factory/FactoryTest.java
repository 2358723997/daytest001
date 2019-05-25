package com.gupao.vip.pattern.factory;

import com.gupao.vip.pattern.factory.entity.ICourse;
import com.gupao.vip.pattern.factory.entity.impl.JavaCourse;
import com.gupao.vip.pattern.factory.impl.JavaCourseFactory;
import com.gupao.vip.pattern.factory.impl.PythonCourseFactory;

/**
 * @author wangjixue
 * @date 2019-05-19 16:41
 */
public class FactoryTest {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        ICourseFactory javaFactory = new JavaCourseFactory();
        JavaCourse javaCourse = (JavaCourse) javaFactory.create();
        javaCourse.record();
        javaCourse.study();
        ICourseFactory pythonCourseFactory = new PythonCourseFactory();
        ICourse pythonCourse = pythonCourseFactory.create();
        pythonCourse.record();

    }
}
