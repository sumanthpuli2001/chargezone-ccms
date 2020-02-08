package com.bul.zydex.controller.PaymentGateway;


import java.util.List;

/**
 * Represents a promotion and applies the discount amount conditionally on the order.
 */
public class CreatePromotionRequest {
    private String orderId;
    private double discountAmount;

    List<PromotionCondition> promotionConditions;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public List<PromotionCondition> getPromotionConditions() {
        return promotionConditions;
    }

    public void setPromotionConditions(List<PromotionCondition> promotionConditions) {
        this.promotionConditions = promotionConditions;
    }

    public CreatePromotionRequest withOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    public CreatePromotionRequest withDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
        return this;
    }

    public CreatePromotionRequest withDimensions(List<PromotionCondition> promotionConditions) {
        this.promotionConditions = promotionConditions;
        return this;
    }
}
