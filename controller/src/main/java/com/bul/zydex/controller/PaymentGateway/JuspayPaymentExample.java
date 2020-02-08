/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.PaymentGateway;

import org.apache.log4j.Logger;

/**
 *
 * @author hp
 */
public class JuspayPaymentExample {

    private static final String TEST_KEY = "7F3282CC43004D5A818E781F39440442";
    private static Logger log = Logger.getLogger(JuspayPaymentExample.class);

    public static void main(String[] args) {

        PaymentService juspayService = new PaymentService().withEnvironment(Environment.PRODUCTION)
                .withKey(TEST_KEY).withMerchantId("juspay_test");

        //CreateOrder example calls
        String randomOrderId = "" + System.currentTimeMillis();
        CreateOrderRequest createOrderRequest = new CreateOrderRequest().withOrderId(randomOrderId)
                .withAmount(100.0)
                .withCustomerId("customer_id").withEmail("customer@shop.in");
        CreateOrderResponse createOrderResponse = juspayService.createOrder(createOrderRequest);
        log.info("Create order response:  " + createOrderResponse);

        //Update Order example call
        UpdateOrderRequest updateOrderRequest = new UpdateOrderRequest().withOrderId(randomOrderId)
                .withAmount(200.0);
        GetOrderStatusResponse updateOrderResponse = juspayService.updateOrder(updateOrderRequest);
        log.info("Update order response:  " + updateOrderResponse);

        //AddCard example call
        AddCardRequest addCardRequest = new AddCardRequest().withNameOnCard("Customer Name")
                .withCardExpMonth("05").withCardExpYear("2021")
                .withCardNumber("5577810000000004").withCustomerEmail("customer@shop.in")
                .withCustomerId("customer_id");
        AddCardResponse addCardResponse = juspayService.addCard(addCardRequest);
        log.info("Add card response: " + addCardResponse);

        //ListCard example call
        ListCardsRequest listCardsRequest = new ListCardsRequest().withCustomerId("customer_id");
        ListCardsResponse listCardsResponse = juspayService.listCards(listCardsRequest);
        log.info("List card response: " + listCardsResponse);

        // OrderStatus example call
        GetOrderStatusRequest orderStatusRequest = new GetOrderStatusRequest();
        orderStatusRequest.withOrderId(randomOrderId);
        GetOrderStatusResponse orderStatusResponse = juspayService.getOrderStatus(orderStatusRequest);
        log.info("Order status response: " + orderStatusResponse);

        // PaymentStatus example call
        PaymentRequest paymentRequest = new PaymentRequest();

        // Regular card transaction
        paymentRequest.withMerchantId("juspay_test").withOrderId(randomOrderId).withCardNumber("4242424242424242").
                 withCardExpYear("2020").withCardExpMonth("05").withCardSecurityCode("111");
        // PaymentResponse paymentResponse = juspayService.makePayment(paymentRequest);

        // Using stored card
        // paymentRequest.withMerchantId("juspay_test").withOrderId(randomOrderId).
        //        withCardToken("02c15b6c-8f8c-42c2-af39");

        // Using EMI
        // paymentRequest.withEmi("HDFC", 3);

        // Netbanking
        // paymentRequest.withMerchantId("juspay_test").withOrderId(randomOrderId).withNetBanking("HDFC");


        PaymentResponse paymentResponse = juspayService.makePayment(paymentRequest);
        log.info("Payment Response is:" + paymentResponse);


       
        String specialTestKey = "enter-the-special-key";
        PaymentService juspayExtendedService = new PaymentService().withEnvironment(Environment.PRODUCTION)
                .withKey(specialTestKey);
        GetCardRequest getCardRequest = new GetCardRequest();
        getCardRequest.setCardToken("d52fe2d2-83b3-4513-a46a-7b7dbdbc4cf0");
        GetCardResponse getCardResponse = juspayExtendedService.getCard(getCardRequest);
        System.out.println(getCardResponse);
        


    }
}
