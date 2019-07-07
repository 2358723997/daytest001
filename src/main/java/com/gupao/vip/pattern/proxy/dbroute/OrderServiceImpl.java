package com.gupao.vip.pattern.proxy.dbroute;

/**
 * OrderServiceImpl类
 *
 * @author wangjixue
 * @date 2019-07-07 13:15
 */
public class OrderServiceImpl implements OrderService{

    private OrderDao orderDao;

    public OrderServiceImpl() {
        this.orderDao = new OrderDao();
    }

    @Override
    public int createOrder(OrderEntity entity) {
        System.err.println("OrderService调用orderDao，来生成订单");
        orderDao.insert(entity);
        return 1;
    }
}
