package com.gupao.vip.pattern.proxy.dbroute;

import java.sql.Timestamp;

/**
 * OrderDao类
 *
 * @author wangjixue
 * @date 2019-07-07 13:06
 */
public class OrderDao {
    public int insert(OrderEntity entity){
        System.err.println("订单生成成功❗️\n创建时间为："+ new Timestamp(System.currentTimeMillis()));
        return 1;
    }
}
