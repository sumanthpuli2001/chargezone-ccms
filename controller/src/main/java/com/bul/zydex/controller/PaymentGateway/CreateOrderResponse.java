package com.bul.zydex.controller.PaymentGateway;

public class CreateOrderResponse {

    public String status;
    public long statusId;
    public String orderId;
     public String payment_links;

    public String getPayment_links() {
        return payment_links;
    }

    public void setPayment_links(String payment_links) {
        this.payment_links = payment_links;
    }

    //Setters
    public void setStatus(String status) {
        this.status = status;
    }

    public void setStatusId(long statusId) {
        this.statusId = statusId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }


    //Setters for method chaining
    public CreateOrderResponse withStatus(String status) {
        this.status = status;
        return this;
    }

    public CreateOrderResponse withStatusId(int statusId) {
        this.statusId = statusId;
        return this;
    }

    public CreateOrderResponse withOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append("{ ");
        buffer.append("payment_links: ");
        buffer.append(this.payment_links);
        buffer.append("status: ");
        buffer.append(this.status);
        buffer.append(" , ");
        buffer.append("status_id: ");
        buffer.append(this.statusId);
        buffer.append(" , ");
        buffer.append("order_id: ");
        buffer.append(this.orderId);
        buffer.append(" }");

        return buffer.toString();
    }

}
