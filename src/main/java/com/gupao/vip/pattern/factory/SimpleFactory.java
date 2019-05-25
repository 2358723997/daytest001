package com.gupao.vip.pattern.factory;

import com.gupao.vip.pattern.factory.entity.ICourse;

/**
 * @author wangjixue
 * @date 2019-05-19 16:16
 */
public class SimpleFactory {

    public ICourse getInstance(Class<? extends ICourse> clazz) throws IllegalAccessException, InstantiationException {

        return clazz.newInstance();
    }
}
