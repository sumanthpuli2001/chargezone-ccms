package com.bul.zydex.controller.PaymentGateway;


public class AddCardRequest {

    public String customerId;
    public String customerEmail;
    public String cardNumber;
    public String cardExpYear;
    public String cardExpMonth;
    public String nameOnCard;
    public String nickname;

    //Normal Setters
    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    public void setCardExpMonth(String cardExpMonth) {
        this.cardExpMonth = cardExpMonth;
    }

    public void setCardExpYear(String cardExpYear) {
        this.cardExpYear = cardExpYear;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    //Setters for method chaining calls
    public AddCardRequest withNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
        return this;
    }

    public AddCardRequest withCardExpMonth(String cardExpMonth) {
        this.cardExpMonth = cardExpMonth;
        return this;
    }

    public AddCardRequest withCardExpYear(String cardExpYear) {
        this.cardExpYear = cardExpYear;
        return this;
    }

    public AddCardRequest withCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
        return this;
    }

    public AddCardRequest withCustomerId(String customerId) {
        this.customerId = customerId;
        return this;
    }

    public AddCardRequest withCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
        return this;
    }

    public AddCardRequest withNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }
}
