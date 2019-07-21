package com.gupao.vip.pattern.strategy.promotion;

/**
 * CouponStrategy类
 *
 * @author wangjixue
 * @date 2019-07-13 15:35
 */
public class CouponStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.err.println("优惠券优惠");
    }
}
