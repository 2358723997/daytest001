package com.gupao.vip.pattern.factory;

import com.gupao.vip.pattern.factory.entity.ICourse;
import com.gupao.vip.pattern.factory.entity.INote;
import com.gupao.vip.pattern.factory.entity.IVideo;

/**
 * 抽象工厂是用户的主入口
 * 在 Spring 中应用得最为广泛的一种设计模式
 * 易于扩展
 * @author wangjixue
 * @date 2019-05-19 16:16
 */
public interface AbstractFactory {
    INote createNote();
    IVideo createVideo();

}
