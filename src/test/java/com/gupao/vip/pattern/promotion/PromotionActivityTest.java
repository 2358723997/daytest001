package com.gupao.vip.pattern.promotion;

import com.gupao.vip.pattern.strategy.promotion.CashbackStrategy;
import com.gupao.vip.pattern.strategy.promotion.EmptyStrategy;
import com.gupao.vip.pattern.strategy.promotion.PromotionActivity;

/**
 * PromotionActivityTest类
 *
 * @author wangjixue
 * @date 2019-07-13 15:48
 */
public class PromotionActivityTest {
    public static void main0(String[] args) {
        PromotionActivity activity0 = new PromotionActivity(new CashbackStrategy());
        PromotionActivity activity1 = new PromotionActivity(new EmptyStrategy());
        activity0.excute();
        activity1.excute();
    }

    public static void main(String[] args) {
        PromotionActivity activity =null;
        String promotionKey = "CASH";
        if(promotionKey.equals("CASH")){
            activity = new PromotionActivity(new CashbackStrategy());
            activity.excute();
        }else {
            activity = new PromotionActivity(new EmptyStrategy());
            activity.excute();
        }
    }
}
