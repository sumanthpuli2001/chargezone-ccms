package com.bul.zydex.controller.PaymentGateway;

/**
 * Represents the response received when a promotion is applied against an order.
 */
public class CreatePromotionResponse {
    boolean success;
    Promotion promotion;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }
}
