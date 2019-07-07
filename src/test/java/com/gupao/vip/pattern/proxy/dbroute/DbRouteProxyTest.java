package com.gupao.vip.pattern.proxy.dbroute;

import com.gupao.vip.pattern.proxy.dbroute.proxy.OrderServiceStaticProxy;

import java.util.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * DbRouteProxyTest类
 *
 * @author wangjixue
 * @date 2019-07-07 14:00
 */
public class DbRouteProxyTest {
    public static void main(String[] args) throws ParseException {
        OrderService service = new OrderServiceStaticProxy(new OrderServiceImpl());
        OrderEntity entity = new OrderEntity();
        SimpleDateFormat sdf = new SimpleDateFormat("yyy/MM/dd");
        Date date = sdf.parse("2017/02/14");
        Timestamp current = new Timestamp(date.getTime());
        entity.setCreateTime(current);
        int i = service.createOrder(entity);
    }
}
