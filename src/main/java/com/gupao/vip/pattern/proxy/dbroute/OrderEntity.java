package com.gupao.vip.pattern.proxy.dbroute;

import lombok.Data;

import java.sql.Timestamp;

/**
 * OrderEntity类
 *
 * @author wangjixue
 * @date 2019-07-07 13:04
 */
public class OrderEntity {
    private Long id;
    private Object orderInfo;
    private Timestamp createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Object getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(Object orderInfo) {
        this.orderInfo = orderInfo;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
