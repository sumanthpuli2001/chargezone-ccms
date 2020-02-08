package com.bul.zydex.controller.PaymentGateway;

public class DeleteCardResponse {

    public String cardToken;
    public boolean deleted;
    public String cardReference;

    public void setCardToken(String cardToken) {
        this.cardToken = cardToken;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public DeleteCardResponse withCardToken(String cardToken) {
        this.cardToken = cardToken;
        return this;
    }

    public DeleteCardResponse withDeleted(boolean deleted) {
        this.deleted = deleted;
        return this;
    }

    public DeleteCardResponse withCardReference(String cardReference) {
        this.cardReference = cardReference;
        return this;
    }
    
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append("{ ");
        buffer.append("card_token: ");
        buffer.append(this.cardToken + " , ");
        buffer.append("deleted: ");
        buffer.append(this.deleted);
        buffer.append(" }");

        return buffer.toString();
    }
}
