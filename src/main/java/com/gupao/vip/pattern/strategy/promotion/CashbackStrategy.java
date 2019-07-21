package com.gupao.vip.pattern.strategy.promotion;

/**
 * CashbackStrategy类
 *
 * @author wangjixue
 * @date 2019-07-13 15:35
 */
public class CashbackStrategy implements PromotionStrategy {

    @Override
    public void doPromotion() {
        System.err.println("返现金优惠");
    }
}
