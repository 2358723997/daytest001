package com.gupao.vip.pattern.proxy.dbroute.proxy;

import com.gupao.vip.pattern.proxy.dbroute.OrderEntity;
import com.gupao.vip.pattern.proxy.dbroute.OrderService;
import com.gupao.vip.pattern.proxy.dbroute.db.DynamicDataSourceEntity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * OrderServiceStaticProxy类
 *
 * @author wangjixue
 * @date 2019-07-07 13:46
 */
public class OrderServiceStaticProxy implements OrderService {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy");

    private OrderService orderService;

    public OrderServiceStaticProxy(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public int createOrder(OrderEntity entity) {
        String year= sdf.format(new Date(entity.getCreateTime().getTime()));
        int dbRouter = Integer.valueOf(year);
        System.err.println("静态代理自动分配到数据源为：DB_"+year+"的数据源处理数据");
        DynamicDataSourceEntity.set(dbRouter);
        orderService.createOrder(entity);
        return 1;
    }

    public void before(){
        System.err.println("Proxy method  is before invoke.");
    }

    public void after(){
        System.err.println("Proxy method  is after invoke.");
    }
}
