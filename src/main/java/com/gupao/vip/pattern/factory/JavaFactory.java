package com.gupao.vip.pattern.factory;

import com.gupao.vip.pattern.factory.entity.INote;
import com.gupao.vip.pattern.factory.entity.IVideo;
import com.gupao.vip.pattern.factory.entity.impl.JavaNote;
import com.gupao.vip.pattern.factory.entity.impl.JavaVideo;

/**
 * 抽象工厂是用户的主入口
 * 在 Spring 中应用得最为广泛的一种设计模式
 * 易于扩展
 * @author wangjixue
 * @date 2019-05-19 16:16
 */
public class JavaFactory implements AbstractFactory{
    public INote createNote(){
        return new JavaNote();
    }
    public IVideo createVideo(){
        return new JavaVideo();
    }

}
