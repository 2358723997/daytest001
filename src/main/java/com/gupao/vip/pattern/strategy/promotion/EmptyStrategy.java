package com.gupao.vip.pattern.strategy.promotion;

/**
 * EmptyStrategy类
 *
 * @author wangjixue
 * @date 2019-07-13 15:35
 */
public class EmptyStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.err.println("无优惠");
    }
}
