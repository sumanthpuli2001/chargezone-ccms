package com.bul.zydex.controller.PaymentGateway;


public class ListCardsRequest {

    public String customerId;

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public ListCardsRequest withCustomerId(String customerId) {
        this.customerId = customerId;
        return this;
    }
}
