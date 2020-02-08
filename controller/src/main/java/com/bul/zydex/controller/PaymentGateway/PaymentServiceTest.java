package com.bul.zydex.controller.PaymentGateway;


import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PaymentServiceTest {

    private String testKey = "7F3282CC43004D5A818E781F39440442";

    String testCustomerId = "customerId";
    String testNameOnCard = "John Smith";
    String testNickname = "HDFC Credit Card";
    String testOrderId = "" + System.currentTimeMillis();
    
    private static PaymentServiceTest paymentServiceTest=new PaymentServiceTest();


    String testCardNumberOne = "4242424242424242";
    String testCardNumberTwo = "5264190200963394";
    private static final Logger log = Logger.getLogger(PaymentServiceTest.class);

    @Test
    public void testGetOrderStatus() {
        String orderId = "1438352361";
        PaymentService juspayService = new PaymentService().withEnvironment(Environment.DEVELOPMENT)
                .withKey(testKey);

        GetOrderStatusRequest request = new GetOrderStatusRequest().withOrderId(orderId);
       GetOrderStatusResponse getOrderStatusResponse= juspayService.getOrderStatus(request);
       System.out.print(log);
    }
    
    public static void main(String[] args) {
         
        paymentServiceTest.testGetOrderStatus();
    }

    @Test
    public void testOrderCreation() {

        PaymentService juspayService = new PaymentService().withEnvironment(Environment.PRODUCTION)
                .withKey(testKey).withMerchantId("juspay_test");

        CreateOrderRequest request = new CreateOrderRequest()
                .withOrderId(testOrderId)
                .withAmount(400.00)
                .withCustomerId("customer_id").withEmail("customer@shop.in");
        request.setUdf1("udf1");
        request.setUdf2("udf2");
        request.setUdf3("udf3");
        request.setUdf4("udf4");
        request.setUdf5("udf5");
        request.setReturnUrl("http://google.co.in");
        CreateOrderResponse response = juspayService.createOrder(request);

        assertEquals("CREATED", response.status);

        GetOrderStatusRequest orderStatusRequest = new GetOrderStatusRequest();
        orderStatusRequest.setOrderId(testOrderId);
        GetOrderStatusResponse orderResponse = juspayService.getOrderStatus(orderStatusRequest);
        assertEquals(orderResponse.getUdf1(), "udf1");
        assertEquals(orderResponse.getUdf2(), "udf2");
        assertEquals(orderResponse.getUdf3(), "udf3");
        assertEquals(orderResponse.getUdf4(), "udf4");
        assertEquals(orderResponse.getUdf5(), "udf5");

    }

    @Test
    public void testAddCardSuccess() {
        AddCardResponse addCardResponse = addTestCard(testCustomerId, testCardNumberOne);
        assertNotNull(addCardResponse.getCardToken());
        assertNotNull(addCardResponse.getCardReference());
    }

    private AddCardResponse addTestCard(String customerId, String cardNumber) {
        PaymentService juspayService = new PaymentService().withEnvironment(Environment.PRODUCTION)
                .withKey(testKey);

        AddCardRequest addCardRequest = new AddCardRequest().withNameOnCard("tester")
                .withCardNumber(cardNumber).withCustomerEmail("customer@gmail.com")
                .withCardExpMonth("11").withCardExpYear("2020")
                .withNameOnCard(testNameOnCard)
                .withNickname(testNickname)
                .withCustomerId(testCustomerId);
        return juspayService.addCard(addCardRequest);
    }

    private void clearAllCards(String customerId) {
        PaymentService juspayService = new PaymentService().withEnvironment(Environment.PRODUCTION)
                .withKey(testKey);
        ListCardsRequest listCardsRequest = new ListCardsRequest().withCustomerId(customerId);
        ListCardsResponse listCardsResponse = juspayService.listCards(listCardsRequest);
        for (StoredCard card : listCardsResponse.cards) {
            DeleteCardRequest request = new DeleteCardRequest();
            request.withCardToken(card.getCardToken());
            juspayService.deleteCard(request);
        }
    }

    @Test
    public void testListCardSuccess() {

        PaymentService juspayService = new PaymentService().withEnvironment(Environment.PRODUCTION)
                .withKey(testKey);

        // lets delete all the existing cards
        clearAllCards(testCustomerId);

        // lets add the card first
        addTestCard(testCustomerId, testCardNumberOne);
        addTestCard(testCustomerId, testCardNumberTwo);

        ListCardsRequest listCardsRequest = new ListCardsRequest().withCustomerId(testCustomerId);
        ListCardsResponse listCardsResponse = juspayService.listCards(listCardsRequest);

        assertNotNull(listCardsResponse.cards);
        // assert that the card just added is present
        boolean cardIsPresent = false;
        for (StoredCard card : listCardsResponse.cards) {
            assertNotNull(card.getCardNumber());
            String expectedPrefix = testCardNumberOne.substring(0, 4);
            String expectedSuffix = testCardNumberOne.substring(testCardNumberOne.length() - 4,
                    testCardNumberOne.length());
            if (card.getCardNumber().startsWith(expectedPrefix)
                    && card.getCardNumber().endsWith(expectedSuffix)) {
                cardIsPresent = true;
                assertEquals(card.getNickname(), testNickname);
                assertNotNull(card.getCardReference());
            }
        }
        assertTrue(cardIsPresent);
    }

    @Test
    public void testUnsuccessfulListCard() {

        PaymentService juspayService = new PaymentService().withEnvironment(Environment.PRODUCTION)
                .withKey(testKey);

        ListCardsRequest listCardsRequest = new ListCardsRequest().withCustomerId("unknown");
        ListCardsResponse listCardsResponse = juspayService.listCards(listCardsRequest);

        assertEquals(listCardsResponse.cards.size(), 0);
    }

    @Test
    public void testSuccessfulCardDelete() {

        PaymentService juspayService = new PaymentService().withEnvironment(Environment.PRODUCTION)
                .withKey(testKey);

        //Add card before deleting. Making sure that there is atleast a card present.
        AddCardRequest addCardRequest = new AddCardRequest().withNameOnCard("tester")
                .withCardExpMonth("11").withCardExpYear("2020")
                .withCardNumber("4111222233334444").withCustomerEmail("asd@gmail.com")
                .withCustomerId("unknown");
        AddCardResponse addCardResponse = juspayService.addCard(addCardRequest);

        assertNotNull(addCardResponse.getCardToken());

        //Get the added card response.
        String cardToken = addCardResponse.getCardToken();
        String cardReference = addCardResponse.getCardReference();
        assertNotNull(cardReference);
        //Trigger a delete-card call
        DeleteCardRequest deleteCardRequest = new DeleteCardRequest().withCardToken(cardToken);
        DeleteCardResponse deleteCardResponse = juspayService.deleteCard(deleteCardRequest);

        //Make sure that card is deleted.
        assertEquals(true, deleteCardResponse.deleted);
        assertEquals(cardToken, deleteCardResponse.cardToken);
        assertEquals(cardReference, deleteCardResponse.cardReference);

    }

    @Test
    public void testNonExistingCardCardDelete() {

        PaymentService juspayService = new PaymentService().withEnvironment(Environment.PRODUCTION)
                .withKey(testKey);

        //Add card before deleting. Making sure that there is atleast a card present.
        AddCardRequest addCardRequest = new AddCardRequest().withNameOnCard("tester")
                .withCardExpMonth("11").withCardExpYear("2020")
                .withCardNumber("4111222233334444").withCustomerEmail("asd@gmail.com")
                .withCustomerId("unknown");
        AddCardResponse addCardResponse = juspayService.addCard(addCardRequest);

        assertNotNull(addCardResponse.getCardToken());

        //Get the added card response.
        String cardToken = addCardResponse.getCardToken();
        String cardReference = addCardResponse.getCardReference();
        assertNotNull(cardReference);
        //Trigger a delete-card call
        DeleteCardRequest deleteCardRequest = new DeleteCardRequest().withCardToken(cardToken);
        DeleteCardResponse deleteCardResponse = juspayService.deleteCard(deleteCardRequest);

        //Make sure that card is deleted.
        assertEquals(true, deleteCardResponse.deleted);
        assertEquals(cardToken, deleteCardResponse.cardToken);
        assertEquals(cardReference, deleteCardResponse.cardReference);

        // Trigger a delete again
        deleteCardRequest = new DeleteCardRequest().withCardToken(cardToken);
        deleteCardResponse = juspayService.deleteCard(deleteCardRequest);

        //Make sure that card is deleted already. This time reference should be null
        assertEquals(true, deleteCardResponse.deleted);
        assertEquals(cardToken, deleteCardResponse.cardToken);
        assertEquals(null, deleteCardResponse.cardReference);

    }


    @Test
    public void testVbvUrl() {

        PaymentService juspayService = new PaymentService().withEnvironment(Environment.PRODUCTION)
                .withKey(testKey);

        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.withMerchantId("juspay_test").withOrderId("1438867844630").withCardNumber("4242424242424242").
                withCardExpYear("2020").withCardExpMonth("05").withCardSecurityCode("111");
        PaymentResponse paymentResponse = juspayService.makePayment(paymentRequest);

        //make sure url is present
        assertNotNull(paymentResponse.getAuthentication().getUrl());
        //check status as PENDIND_VBV
        assertEquals(paymentResponse.getStatus(), "PENDING_VBV");
    }

    @Test
    public void testCreatePromotion() {
        String orderId = Long.valueOf(System.currentTimeMillis()).toString();
        CreateOrderRequest request = new CreateOrderRequest()
                .withOrderId(orderId)
                .withAmount(400.00)
                .withCustomerId("customer_id").withEmail("customer@shop.in");
        PaymentService juspayService = new PaymentService().withEnvironment(Environment.PRODUCTION)
                .withKey(testKey);
        juspayService.createOrder(request);

        CreatePromotionRequest promotionRequest = new CreatePromotionRequest();
        promotionRequest.setOrderId(orderId);

        promotionRequest.setDiscountAmount(1.00);
        List<PromotionCondition> promotionConditions = new ArrayList<PromotionCondition>();
        PromotionCondition promotionCondition = new PromotionCondition();
        promotionCondition.setDimension("card_number");
        promotionCondition.setValue("4242424242424242");
        promotionConditions.add(promotionCondition);
        promotionRequest.setPromotionConditions(promotionConditions);

        CreatePromotionResponse promotionResponse = juspayService.createPromotion(promotionRequest);
        assertTrue(promotionResponse.isSuccess());
        assertNotNull(promotionResponse.getPromotion());

        Promotion promotion = promotionResponse.getPromotion();
        assertEquals(orderId, promotion.getOrderId());
        assertEquals(PromotionStatus.ACTIVE, promotion.getStatus());
        assertEquals(new Double(1.00), promotion.getDiscountAmount());

        // test /order/status API as well

        GetOrderStatusRequest orderStatusRequest = new GetOrderStatusRequest();
        orderStatusRequest.setOrderId(orderId);
        GetOrderStatusResponse orderStatusResponse = juspayService.getOrderStatus(orderStatusRequest);
        assertNotNull(orderStatusResponse.getPromotion());
        assertEquals(new Double(1.00), orderStatusResponse.getPromotion().getDiscountAmount());

    }

    @Test
    public void testDeactivatePromotion() {
        // lets create an order
        String orderId = Long.valueOf(System.currentTimeMillis()).toString();
        CreateOrderRequest request = new CreateOrderRequest()
                .withOrderId(orderId)
                .withAmount(400.00)
                .withCustomerId("customer_id").withEmail("customer@shop.in");
        PaymentService juspayService = new PaymentService().withEnvironment(Environment.PRODUCTION)
                .withKey(testKey);
        juspayService.createOrder(request);

        // lets activate a promotion for this order
        CreatePromotionRequest promotionRequest = new CreatePromotionRequest();
        promotionRequest.setOrderId(orderId);

        promotionRequest.setDiscountAmount(1.00);
        List<PromotionCondition> promotionConditions = new ArrayList<PromotionCondition>();
        PromotionCondition promotionCondition = new PromotionCondition();
        promotionCondition.setDimension("card_number");
        promotionCondition.setValue("4242424242424242");
        promotionConditions.add(promotionCondition);
        promotionRequest.setPromotionConditions(promotionConditions);

        CreatePromotionResponse promotionResponse = juspayService.createPromotion(promotionRequest);
        assertTrue(promotionResponse.isSuccess());
        assertNotNull(promotionResponse.getPromotion());

        GetOrderStatusRequest orderStatusRequest = new GetOrderStatusRequest();
        orderStatusRequest.setOrderId(orderId);
        GetOrderStatusResponse orderStatusResponse = juspayService.getOrderStatus(orderStatusRequest);
        assertNotNull(orderStatusResponse.getPromotion());

        DeactivatePromotionRequest deactivatePromotionRequest = new DeactivatePromotionRequest();
        deactivatePromotionRequest.setPromotionId(promotionResponse.getPromotion().getId());
        DeactivatePromotionResponse deactivatePromotionResponse = juspayService.deactivatePromotion(deactivatePromotionRequest);
        assertEquals(PromotionStatus.INACTIVE, deactivatePromotionResponse.getPromotion().getStatus());

        // read order status again to confirm that the promotion is deactivated
        GetOrderStatusResponse updatedOrderStatusResponse = juspayService.getOrderStatus(orderStatusRequest);
        assertNotNull(orderStatusResponse.getPromotion());
    }
}



