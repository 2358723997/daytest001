package com.gupao.vip.pattern.promotion;

import com.gupao.vip.pattern.strategy.promotion.PromotionActivity;
import com.gupao.vip.pattern.strategy.promotion.PromotionActivityFactory;

/**
 * PromotionActivityFactoryTest类
 *
 * @author wangjixue
 * @date 2019-07-13 16:46
 */
public class PromotionActivityFactoryTest {
    public static void main(String[] args) {
        PromotionActivity activity = new PromotionActivity(PromotionActivityFactory.getPromotionStrategy("CASH"));
        activity.excute();
    }
}
