package com.bul.zydex.controller.PaymentGateway;

public class GetCardRequest {

    public String cardToken;

    public String getCardToken() {
        return cardToken;
    }

    public void setCardToken(String cardToken) {
        this.cardToken = cardToken;
    }

    public GetCardRequest withCardToken(String cardToken) {
        this.cardToken = cardToken;
        return this;
    }
}
