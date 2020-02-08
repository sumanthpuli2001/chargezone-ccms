package com.bul.zydex.controller.PaymentGateway;

public class DeactivatePromotionResponse {
    private boolean success;
    private Promotion promotion;

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
