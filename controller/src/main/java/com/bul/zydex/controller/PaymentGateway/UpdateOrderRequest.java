package com.bul.zydex.controller.PaymentGateway;

public class UpdateOrderRequest {

    private Double amount;
    private String orderId;
    private String billingAddressFirstName;
    private String billingAddressLastName;
    private String billingAddressLine1;
    private String billingAddressLine2;
    private String billingAddressLine3;
    private String billingAddressCity;
    private String billingAddressState;
    private String billingAddressCountry;
    private String billingAddressPostalCode;
    private String billingAddressPhone;
    private String billingAddressCountryCodeIso;
    private String shippingAddressFirstName;
    private String shippingAddressLastName;
    private String shippingAddressLine1;
    private String shippingAddressLine2;
    private String shippingAddressLine3;
    private String shippingAddressCity;
    private String shippingAddressState;
    private String shippingAddressPostalCode;
    private String shippingAddressPhone;
    private String shippingAddressCountryCodeIso;
    private String shippingAddressCountry;

    /**
     * UDF fields
     */
    private String udf1;
    private String udf2;
    private String udf3;
    private String udf4;
    private String udf5;
    private String udf6;
    private String udf7;
    private String udf8;
    private String udf9;
    private String udf10;

    public UpdateOrderRequest withAmount(Double amount) {
        this.amount = amount;
        return this;
    }

    public UpdateOrderRequest withOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    public String getBillingAddressFirstName() {
        return billingAddressFirstName;
    }

    public void setBillingAddressFirstName(String billingAddressFirstName) {
        this.billingAddressFirstName = billingAddressFirstName;
    }

    public String getBillingAddressLastName() {
        return billingAddressLastName;
    }

    public void setBillingAddressLastName(String billingAddressLastName) {
        this.billingAddressLastName = billingAddressLastName;
    }

    public String getBillingAddressLine1() {
        return billingAddressLine1;
    }

    public void setBillingAddressLine1(String billingAddressLine1) {
        this.billingAddressLine1 = billingAddressLine1;
    }

    public String getBillingAddressLine2() {
        return billingAddressLine2;
    }

    public void setBillingAddressLine2(String billingAddressLine2) {
        this.billingAddressLine2 = billingAddressLine2;
    }

    public String getBillingAddressLine3() {
        return billingAddressLine3;
    }

    public void setBillingAddressLine3(String billingAddressLine3) {
        this.billingAddressLine3 = billingAddressLine3;
    }

    public String getBillingAddressCity() {
        return billingAddressCity;
    }

    public void setBillingAddressCity(String billingAddressCity) {
        this.billingAddressCity = billingAddressCity;
    }

    public String getBillingAddressState() {
        return billingAddressState;
    }

    public void setBillingAddressState(String billingAddressState) {
        this.billingAddressState = billingAddressState;
    }

    public String getBillingAddressCountry() {
        return billingAddressCountry;
    }

    public void setBillingAddressCountry(String billingAddressCountry) {
        this.billingAddressCountry = billingAddressCountry;
    }

    public String getBillingAddressPostalCode() {
        return billingAddressPostalCode;
    }

    public void setBillingAddressPostalCode(String billingAddressPostalCode) {
        this.billingAddressPostalCode = billingAddressPostalCode;
    }

    public String getBillingAddressPhone() {
        return billingAddressPhone;
    }

    public void setBillingAddressPhone(String billingAddressPhone) {
        this.billingAddressPhone = billingAddressPhone;
    }

    public String getBillingAddressCountryCodeIso() {
        return billingAddressCountryCodeIso;
    }

    public void setBillingAddressCountryCodeIso(String billingAddressCountryCodeIso) {
        this.billingAddressCountryCodeIso = billingAddressCountryCodeIso;
    }

    public String getShippingAddressFirstName() {
        return shippingAddressFirstName;
    }

    public void setShippingAddressFirstName(String shippingAddressFirstName) {
        this.shippingAddressFirstName = shippingAddressFirstName;
    }

    public String getShippingAddressLastName() {
        return shippingAddressLastName;
    }

    public void setShippingAddressLastName(String shippingAddressLastName) {
        this.shippingAddressLastName = shippingAddressLastName;
    }

    public String getShippingAddressLine1() {
        return shippingAddressLine1;
    }

    public void setShippingAddressLine1(String shippingAddressLine1) {
        this.shippingAddressLine1 = shippingAddressLine1;
    }

    public String getShippingAddressLine2() {
        return shippingAddressLine2;
    }

    public void setShippingAddressLine2(String shippingAddressLine2) {
        this.shippingAddressLine2 = shippingAddressLine2;
    }

    public String getShippingAddressLine3() {
        return shippingAddressLine3;
    }

    public void setShippingAddressLine3(String shippingAddressLine3) {
        this.shippingAddressLine3 = shippingAddressLine3;
    }

    public String getShippingAddressCity() {
        return shippingAddressCity;
    }

    public void setShippingAddressCity(String shippingAddressCity) {
        this.shippingAddressCity = shippingAddressCity;
    }

    public String getShippingAddressState() {
        return shippingAddressState;
    }

    public void setShippingAddressState(String shippingAddressState) {
        this.shippingAddressState = shippingAddressState;
    }

    public String getShippingAddressPostalCode() {
        return shippingAddressPostalCode;
    }

    public void setShippingAddressPostalCode(String shippingAddressPostalCode) {
        this.shippingAddressPostalCode = shippingAddressPostalCode;
    }

    public String getShippingAddressPhone() {
        return shippingAddressPhone;
    }

    public void setShippingAddressPhone(String shippingAddressPhone) {
        this.shippingAddressPhone = shippingAddressPhone;
    }

    public String getShippingAddressCountryCodeIso() {
        return shippingAddressCountryCodeIso;
    }

    public void setShippingAddressCountryCodeIso(String shippingAddressCountryCodeIso) {
        this.shippingAddressCountryCodeIso = shippingAddressCountryCodeIso;
    }

    public String getShippingAddressCountry() {
        return shippingAddressCountry;
    }

    public void setShippingAddressCountry(String shippingAddressCountry) {
        this.shippingAddressCountry = shippingAddressCountry;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUdf1() {
        return udf1;
    }

    public void setUdf1(String udf1) {
        this.udf1 = udf1;
    }

    public String getUdf2() {
        return udf2;
    }

    public void setUdf2(String udf2) {
        this.udf2 = udf2;
    }

    public String getUdf3() {
        return udf3;
    }

    public void setUdf3(String udf3) {
        this.udf3 = udf3;
    }

    public String getUdf4() {
        return udf4;
    }

    public void setUdf4(String udf4) {
        this.udf4 = udf4;
    }

    public String getUdf5() {
        return udf5;
    }

    public void setUdf5(String udf5) {
        this.udf5 = udf5;
    }

    public String getUdf6() {
        return udf6;
    }

    public void setUdf6(String udf6) {
        this.udf6 = udf6;
    }

    public String getUdf7() {
        return udf7;
    }

    public void setUdf7(String udf7) {
        this.udf7 = udf7;
    }

    public String getUdf8() {
        return udf8;
    }

    public void setUdf8(String udf8) {
        this.udf8 = udf8;
    }

    public String getUdf9() {
        return udf9;
    }

    public void setUdf9(String udf9) {
        this.udf9 = udf9;
    }

    public String getUdf10() {
        return udf10;
    }

    public void setUdf10(String udf10) {
        this.udf10 = udf10;
    }

    @Override
    public String toString() {
        return "UpdateOrderRequest{" +
                "amount=" + amount +
                ", orderId='" + orderId + '\'' +
                ", billingAddressFirstName='" + billingAddressFirstName + '\'' +
                ", billingAddressLastName='" + billingAddressLastName + '\'' +
                ", billingAddressLine1='" + billingAddressLine1 + '\'' +
                ", billingAddressLine2='" + billingAddressLine2 + '\'' +
                ", billingAddressLine3='" + billingAddressLine3 + '\'' +
                ", billingAddressCity='" + billingAddressCity + '\'' +
                ", billingAddressState='" + billingAddressState + '\'' +
                ", billingAddressCountry='" + billingAddressCountry + '\'' +
                ", billingAddressPostalCode='" + billingAddressPostalCode + '\'' +
                ", billingAddressPhone='" + billingAddressPhone + '\'' +
                ", billingAddressCountryCodeIso='" + billingAddressCountryCodeIso + '\'' +
                ", shippingAddressFirstName='" + shippingAddressFirstName + '\'' +
                ", shippingAddressLastName='" + shippingAddressLastName + '\'' +
                ", shippingAddressLine1='" + shippingAddressLine1 + '\'' +
                ", shippingAddressLine2='" + shippingAddressLine2 + '\'' +
                ", shippingAddressLine3='" + shippingAddressLine3 + '\'' +
                ", shippingAddressCity='" + shippingAddressCity + '\'' +
                ", shippingAddressState='" + shippingAddressState + '\'' +
                ", shippingAddressPostalCode='" + shippingAddressPostalCode + '\'' +
                ", shippingAddressPhone='" + shippingAddressPhone + '\'' +
                ", shippingAddressCountryCodeIso='" + shippingAddressCountryCodeIso + '\'' +
                ", shippingAddressCountry='" + shippingAddressCountry + '\'' +
                ", udf1='" + udf1 + '\'' +
                ", udf2='" + udf2 + '\'' +
                ", udf3='" + udf3 + '\'' +
                ", udf4='" + udf4 + '\'' +
                ", udf5='" + udf5 + '\'' +
                ", udf6='" + udf6 + '\'' +
                ", udf7='" + udf7 + '\'' +
                ", udf8='" + udf8 + '\'' +
                ", udf9='" + udf9 + '\'' +
                ", udf10='" + udf10 + '\'' +
                '}';
    }

}
