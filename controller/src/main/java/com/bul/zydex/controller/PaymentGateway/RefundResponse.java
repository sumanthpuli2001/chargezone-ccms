package com.bul.zydex.controller.PaymentGateway;

public class RefundResponse extends GetOrderStatusResponse {
    private boolean success;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
