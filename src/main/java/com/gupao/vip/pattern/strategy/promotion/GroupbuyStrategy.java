package com.gupao.vip.pattern.strategy.promotion;

/**
 * GroupbuyStrategy类
 *
 * @author wangjixue
 * @date 2019-07-13 15:36
 */
public class GroupbuyStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.err.println("拼团购买");
    }
}
