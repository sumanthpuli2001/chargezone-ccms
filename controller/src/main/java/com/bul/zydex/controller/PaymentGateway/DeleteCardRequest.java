package com.bul.zydex.controller.PaymentGateway;

public class DeleteCardRequest {

    public String cardToken;

    public void setCardToken(String cardToken) {
        this.cardToken = cardToken;
    }

    public DeleteCardRequest withCardToken(String cardToken) {
        this.cardToken = cardToken;
        return this;
    }

}