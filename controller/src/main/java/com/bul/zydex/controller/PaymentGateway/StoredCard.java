package com.bul.zydex.controller.PaymentGateway;

public class StoredCard {

    private String cardToken;
    private String cardReference;
    private String cardNumber;
    private String cardIsin;
    private String cardExpYear;
    private String cardExpMonth;
    private String nameOnCard;
    private String nickname;
    private String cardBrand;
    private String cardType;
    private String cardIssuer;

    public String getCardReference() {
        return cardReference;
    }

    public void setCardReference(String cardReference) {
        this.cardReference = cardReference;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardIsin() {
        return cardIsin;
    }

    public void setCardIsin(String cardIsin) {
        this.cardIsin = cardIsin;
    }

    public String getCardExpYear() {
        return cardExpYear;
    }

    public void setCardExpYear(String cardExpYear) {
        this.cardExpYear = cardExpYear;
    }

    public String getCardExpMonth() {
        return cardExpMonth;
    }

    public void setCardExpMonth(String cardExpMonth) {
        this.cardExpMonth = cardExpMonth;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    public String getCardToken() {
        return cardToken;
    }

    public void setCardToken(String cardToken) {
        this.cardToken = cardToken;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getCardBrand() {
        return cardBrand;
    }

    public void setCardBrand(String cardBrand) {
        this.cardBrand = cardBrand;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardIssuer() {
        return cardIssuer;
    }

    public void setCardIssuer(String cardIssuer) {
        this.cardIssuer = cardIssuer;
    }

    //Setters for chaining the method call.
    public StoredCard withCardExpMonth(String cardExpMonth) {
        this.cardExpMonth = cardExpMonth;
        return this;
    }

    public StoredCard withCardExpYear(String cardExpYear) {
        this.cardExpYear = cardExpYear;
        return this;
    }

    public StoredCard withCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
        return this;
    }

    public StoredCard withCardToken(String cardToken) {
        this.cardToken = cardToken;
        return this;
    }

    public StoredCard withCardReference(String cardReference) {
        this.cardReference = cardReference;
        return this;
    }

    public StoredCard withCardIsin(String cardIsin) {
        this.cardIsin = cardIsin;
        return this;
    }

    public StoredCard withCardBrand(String cardBrand) {
        this.cardBrand = cardBrand;
        return this;
    }

    public StoredCard withCardType(String cardType) {
        this.cardType = cardType;
        return this;
    }

    public StoredCard withCardIssuer(String cardIssuer) {
        this.cardIssuer = cardIssuer;
        return this;
    }

    public StoredCard withNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public StoredCard withNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
        return this;
    }

    @Override
    public String toString() {
        return "StoredCard{" +
                "cardToken='" + cardToken + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", cardIsin='" + cardIsin + '\'' +
                ", cardExpYear='" + cardExpYear + '\'' +
                ", cardExpMonth='" + cardExpMonth + '\'' +
                ", nameOnCard='" + nameOnCard + '\'' +
                ", nickname='" + nickname + '\'' +
                ", cardBrand='" + cardBrand + '\'' +
                ", cardType='" + cardType + '\'' +
                ", cardIssuer='" + cardIssuer + '\'' +
                '}';
    }
}