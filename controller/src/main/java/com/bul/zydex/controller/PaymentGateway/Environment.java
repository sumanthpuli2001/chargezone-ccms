package com.bul.zydex.controller.PaymentGateway;

public enum Environment {

    DEVELOPMENT("http://local.api.juspay.in"),
    PRODUCTION("https://api.juspay.in"),
    AXIS_ORDER("https://axisbank.juspay.in/orders"),
    AXIS("https://axisbank.juspay.in"),
     AXIS_STAGE("https://sandbox.juspay.in"),
    RUSPAY("https://api.juspay.in"),
    SANDBOX("https://sandbox.juspay.in");

    private final String baseUrl;
    
    private Environment(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

}

