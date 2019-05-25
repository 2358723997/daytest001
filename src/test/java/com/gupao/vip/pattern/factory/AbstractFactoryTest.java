package com.gupao.vip.pattern.factory;

import com.gupao.vip.pattern.factory.entity.ICourse;
import com.gupao.vip.pattern.factory.entity.INote;
import com.gupao.vip.pattern.factory.entity.IVideo;
import com.gupao.vip.pattern.factory.entity.impl.JavaCourse;

/**
 * @author wangjixue
 * @date 2019-05-19 16:41
 */
public class AbstractFactoryTest {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        System.err.println("=========JavaFactory=======");
        AbstractFactory javaFactory = new JavaFactory();
        INote javaNote = javaFactory.createNote();
        IVideo javaVideo = javaFactory.createVideo();
        javaNote.note();
        javaVideo.record();
        System.err.println("=========PythonFactory=======");
        AbstractFactory pythonFactory = new PythonFactory();
        INote pythonNote = pythonFactory.createNote();
        IVideo pythonVideo = pythonFactory.createVideo();
        pythonNote.note();
        pythonVideo.record();

    }
}
