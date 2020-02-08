package com.bul.zydex.controller.PaymentGateway;

import java.util.ArrayList;

public class ListCardsResponse {

    public String customerId;
    public String merchantId;
    public ArrayList<StoredCard> cards;

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public void setCards(ArrayList<StoredCard> cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        return "ListCardsResponse{" +
                "customerId='" + customerId + '\'' +
                ", merchantId='" + merchantId + '\'' +
                ", cards=" + cards +
                '}';
    }
}



