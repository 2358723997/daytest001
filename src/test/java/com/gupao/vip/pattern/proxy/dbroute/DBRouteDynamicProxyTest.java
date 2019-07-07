package com.gupao.vip.pattern.proxy.dbroute;

import com.gupao.vip.pattern.proxy.dbroute.proxy.OrderServiceDynamicProxy;
import com.gupao.vip.pattern.proxy.dynamicproxy.jdkproxy.Girl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * DBRouteDynamicProxyTest类
 *
 * @author wangjixue
 * @date 2019-07-07 15:11
 */
public class DBRouteDynamicProxyTest {
    public static void main(String[] args) throws ParseException {
        OrderService service = (OrderService)new OrderServiceDynamicProxy().getInstance(new OrderServiceImpl());
        OrderEntity entity = new OrderEntity();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date date = sdf.parse("2018/08/19");

        entity.setCreateTime(new Timestamp(date.getTime()));
        int i = service.createOrder(entity);
    }
}
