package com.gupao.vip.pattern.strategy.promotion;

/**
 * PromotionActivity类
 *
 * @author wangjixue
 * @date 2019-07-13 15:46
 */
public class PromotionActivity {
    private PromotionStrategy promotion;

    public PromotionActivity(PromotionStrategy promotion) {
        this.promotion = promotion;
    }

    public void excute(){
        promotion.doPromotion();
    }
}
