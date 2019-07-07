package com.gupao.vip.pattern.proxy.dbroute;

/**
 * OrderService接口
 *
 * @author wangjixue
 * @date 2019-07-07 13:10
 */
public interface OrderService {
    /**
     * 生成订单
     * @param entity
     * @return
     */
   public int createOrder(OrderEntity entity);
}
