package com.gupao.vip.pattern.strategy.promotion;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * PromotionActivity类
 *
 * @author wangjixue
 * @date 2019-07-13 15:46
 */
public class PromotionActivityFactory {

    private static Map<String, PromotionStrategy> PROMOTION_STRATEGY_MAP = new ConcurrentHashMap<String, PromotionStrategy>();

    static {
        PROMOTION_STRATEGY_MAP.put(PromotionKey.CASH.getValue(), new CashbackStrategy());
        PROMOTION_STRATEGY_MAP.put(PromotionKey.COUPON.getValue(), new CouponStrategy());
        PROMOTION_STRATEGY_MAP.put(PromotionKey.GROUPBUY.getValue(), new GroupbuyStrategy());
    }

    private static final PromotionStrategy DEFAULT_PROMOTION = new EmptyStrategy();

    public static PromotionStrategy getPromotionStrategy(String promotionKey) {
        return PROMOTION_STRATEGY_MAP.containsKey(promotionKey) ? PROMOTION_STRATEGY_MAP.get(promotionKey) : DEFAULT_PROMOTION;
    }

    enum PromotionKey {
        CASH("CASH"),
        COUPON("COUPON"),
        GROUPBUY("GROUPBUY");
        private String value;

        PromotionKey(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

}

