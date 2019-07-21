package com.gupao.vip.pattern.delegate.dispatch;

import lombok.Data;

import java.lang.reflect.Method;

/**
 * Handler类
 *
 * @author wangjixue
 * @date 2019-07-21 15:09
 */
@Data
public class Handler {

    private Object controller;

    private Method method;

    private String url;

    public Handler() {
    }

    public Handler(Object controller, Method method, String url) {
        this.controller = controller;
        this.method = method;
        this.url = url;
    }
}
