package com.bul.zydex.controller.PaymentGateway;

import in.juspay.util.ISO8601DateParser;
import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.net.URLEncoder;
import java.text.ParseException;
import java.util.*;


public class PaymentService {

    private static final Logger LOG = Logger.getLogger(PaymentService.class);

    private int connectionTimeout = 5 * 1000;
    private int readTimeout = 5 * 1000;
    //private static final Logger log = Logger.getLogger(PaymentService.class);
    private String baseUrl;
    private String key;
    private String merchantId;
    private Environment environment;

    public void setKey(String key) {
        this.key = key;
    }

    public PaymentService withKey(String key) {
        this.key = key;
        return this;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public PaymentService withMerchantId(String merchantId) {
        this.merchantId = merchantId;
        return this;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
        this.baseUrl = environment.getBaseUrl();
    }

    public PaymentService withEnvironment(Environment environment) {
        this.environment = environment;
        this.baseUrl = environment.getBaseUrl();
        return this;
    }

    private String serializeParams(Map<String, String> parameters) {

        StringBuilder bufferUrl = new StringBuilder();
        try {
            for (Map.Entry<String, String> entry : parameters.entrySet()) {
                bufferUrl.append(entry.getKey());
                bufferUrl.append("=");
                bufferUrl.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                bufferUrl.append("&");
            }
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Encoding exception while trying to construct payload", e);
        }
        return bufferUrl.toString();
    }

    /**
     * It opens the connection to the given endPoint and
     * returns the http response as String.
     *
     * @param endPoint - The HTTP URL of the request
     * @return HTTP response as string
     */
    private String makeServiceCall(String endPoint, String encodedParams) {

        HttpsURLConnection connection = null;
        StringBuilder buffer = new StringBuilder();

        try {
            URL url = new URL(endPoint);
            connection = (HttpsURLConnection) url.openConnection();

            String encodedKey = new String(Base64.encodeBase64(this.key.getBytes()));
            encodedKey = encodedKey.replaceAll("\n", "");
            connection.setRequestProperty("Authorization", "Basic " + encodedKey);
            connection.setRequestProperty("version", "2015-08-18");

            connection.setConnectTimeout(connectionTimeout);
            connection.setReadTimeout(readTimeout);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("Content-Length", "" + Integer.toString(encodedParams.getBytes().length));
            connection.setRequestProperty("Content-Language", "en-US");
            connection.setUseCaches(false);
            connection.setDoInput(true);
            connection.setDoOutput(true);

            // Setup the POST payload
            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.writeBytes(encodedParams);
            wr.flush();
            wr.close();

            // Read the response
            InputStream inputStream = connection.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            String line;
            while ((line = in.readLine()) != null)
                buffer.append(line);
            return buffer.toString();
        } catch (IOException e) {
            // lets read error stream and print out the reason for failure
            InputStream errorStream = connection.getErrorStream();
            BufferedReader in = null;
            String line;
            StringBuffer errorBuffer = new StringBuffer();
            try {
                if(errorStream != null) {
                    in = new BufferedReader(new InputStreamReader(errorStream, "UTF-8"));
                    while ((line = in.readLine()) != null)
                        errorBuffer.append(line);
                    System.out.println(errorBuffer.toString());
                }
            } catch (Exception readException) {
                throw new RuntimeException("Exception while trying to make service call to Juspay", e);
            }
            throw new RuntimeException("Exception while trying to make service call to Juspay", e);
        }
        catch (Exception e) {
            //log.warn("Exception while trying to make service call to Juspay", e);
            throw new RuntimeException("Exception while trying to make service call to Juspay", e);
        }
    }

    /**
     * Creates a new order and returns the CreateOrderResponse associated with
     * that.
     *
     * @param createOrderRequest - CreateOrderRequest with all required params
     * @return CreateOrderResponse for the given request
     */
    public CreateOrderResponse createOrder(CreateOrderRequest createOrderRequest) {
        LinkedHashMap<String, String> params = new LinkedHashMap<String, String>();
        params.put("order_id", createOrderRequest.getOrderId());
        params.put("amount", String.valueOf(createOrderRequest.getAmount()));
        params.put("customer_id", createOrderRequest.getCustomerId());
        params.put("customer_email", createOrderRequest.getCustomerEmail());
        params.put("customer_phone", createOrderRequest.getCustomerPhone() == null ? "" : createOrderRequest.getCustomerPhone());
        if(createOrderRequest.getGatewayId() != 0) {
            params.put("gateway_id", Integer.toString(createOrderRequest.getGatewayId()));
        }
        params.put("currency", createOrderRequest.getCurrency() == null ? "" : createOrderRequest.getCurrency());
        params.put("product_id", createOrderRequest.getProductId() == null ? "" : createOrderRequest.getProductId());
        params.put("description", createOrderRequest.getDescription() == null ? "" : createOrderRequest.getDescription());

        // Billing and shipping addresses
        params.put("billing_address_first_name", createOrderRequest.getBillingAddressFirstName() == null ? "" : createOrderRequest.getBillingAddressFirstName());
        params.put("billing_address_last_name", createOrderRequest.getBillingAddressLastName() == null ? "" : createOrderRequest.getBillingAddressLastName());
        params.put("billing_address_line1", createOrderRequest.getBillingAddressLine1() == null ? "" : createOrderRequest.getBillingAddressLine1());
        params.put("billing_address_line2", createOrderRequest.getBillingAddressLine2() == null ? "" : createOrderRequest.getBillingAddressLine2());
        params.put("billing_address_line3", createOrderRequest.getBillingAddressLine3() == null ? "" : createOrderRequest.getBillingAddressLine3());
        params.put("billing_address_city", createOrderRequest.getBillingAddressCity() == null ? "" : createOrderRequest.getBillingAddressCity());
        params.put("billing_address_state", createOrderRequest.getBillingAddressState() == null ? "" : createOrderRequest.getBillingAddressState());
        params.put("billing_address_postal_code", createOrderRequest.getBillingAddressPostalCode() == null ? "" : createOrderRequest.getBillingAddressPostalCode());
        params.put("billing_address_phone", createOrderRequest.getBillingAddressPhone() == null ? "" : createOrderRequest.getBillingAddressPhone());
        params.put("billing_address_country_code_iso", createOrderRequest.getBillingAddressCountryCodeIso() == null ? "" : createOrderRequest.getBillingAddressCountryCodeIso());
        params.put("billing_address_country", createOrderRequest.getBillingAddressCountry() == null ? "" :createOrderRequest.getBillingAddressCountry());
        params.put("shipping_address_first_name", createOrderRequest.getShippingAddressFirstName() == null ? "" : createOrderRequest.getShippingAddressFirstName());
        params.put("shipping_address_last_name", createOrderRequest.getShippingAddressLastName() == null ? "" : createOrderRequest.getShippingAddressLastName());
        params.put("shipping_address_line1", createOrderRequest.getShippingAddressLine1() == null ? "" : createOrderRequest.getShippingAddressLine1());
        params.put("shipping_address_line2", createOrderRequest.getShippingAddressLine2() == null ? "" : createOrderRequest.getShippingAddressLine2());
        params.put("shipping_address_line3", createOrderRequest.getShippingAddressLine3() == null ? "" : createOrderRequest.getShippingAddressLine3());
        params.put("shipping_address_city", createOrderRequest.getShippingAddressCity() == null ? "" : createOrderRequest.getShippingAddressCity());
        params.put("shipping_address_state", createOrderRequest.getShippingAddressState() == null ? "" : createOrderRequest.getShippingAddressState());
        params.put("shipping_address_postal_code", createOrderRequest.getShippingAddressPostalCode() == null ? "" : createOrderRequest.getShippingAddressPostalCode());
        params.put("shipping_address_phone", createOrderRequest.getShippingAddressPhone() == null ? "" : createOrderRequest.getShippingAddressPhone());
        params.put("shipping_address_country_code_iso", createOrderRequest.getShippingAddressCountryCodeIso() == null ? "" : createOrderRequest.getShippingAddressCountryCodeIso());
        params.put("shipping_address_country", createOrderRequest.getShippingAddressCountry() == null ? "" : createOrderRequest.getShippingAddressCountry());

        // Optional parameters
        params.put("udf1", createOrderRequest.getUdf1() == null ? "" : createOrderRequest.getUdf1());
        params.put("udf2", createOrderRequest.getUdf2() == null ? "" : createOrderRequest.getUdf2());
        params.put("udf3", createOrderRequest.getUdf3() == null ? "" : createOrderRequest.getUdf3());
        params.put("udf4", createOrderRequest.getUdf4() == null ? "" : createOrderRequest.getUdf4());
        params.put("udf5", createOrderRequest.getUdf5() == null ? "" : createOrderRequest.getUdf5());
        params.put("udf6", createOrderRequest.getUdf6() == null ? "" : createOrderRequest.getUdf6());
        params.put("udf7", createOrderRequest.getUdf7() == null ? "" : createOrderRequest.getUdf7());
        params.put("udf8", createOrderRequest.getUdf8() == null ? "" : createOrderRequest.getUdf8());
        params.put("udf9", createOrderRequest.getUdf9() == null ? "" : createOrderRequest.getUdf9());
        params.put("udf10", createOrderRequest.getUdf10() == null ? "" : createOrderRequest.getUdf10());
        params.put("return_url", createOrderRequest.getReturnUrl() == null ? "" : createOrderRequest.getReturnUrl());
        String serializedParams = serializeParams(params);

        String url = baseUrl + "/order/create";

//        LOG.debug("Payload (createOrder): " + serializedParams);
//        LOG.info("Sending create order request to " + url);

        String response = makeServiceCall(url, serializedParams);

//        LOG.debug("Create order response received: " + response);
        JSONObject jsonResponse = (JSONObject) JSONValue.parse(response);

        String merchantId = (String) jsonResponse.get("merchant_id");
        Long statusId = (Long) jsonResponse.get("status_id");
        String status = (String) jsonResponse.get("status");
        String orderId = (String) jsonResponse.get("order_id");

        CreateOrderResponse createOrderResponse = new CreateOrderResponse();
        createOrderResponse.setStatus(status);
        createOrderResponse.setOrderId(orderId);
        createOrderResponse.setStatusId(statusId);

        return createOrderResponse;
    }

    /**
     * Returns the card details associated with a token. The token information is encapsulated in the
     * GetCardRequest instance. This method will throw an Exception if the call is made with an API Key
     * that does not have the required privileges. If the token is invalid and the API Key is privileged,
     * then the card related fields in the response would be null.
     */
    public GetCardResponse getCard(GetCardRequest getCardRequest) {
        LinkedHashMap<String, String> params = new LinkedHashMap<String, String>();
        params.put("card_token", getCardRequest.getCardToken());

        String serializedParams = serializeParams(params);
        String url = baseUrl + "/card/get";

        String response = makeServiceCall(url, serializedParams);
        JSONObject jsonResponse = (JSONObject) JSONValue.parse(response);

        GetCardResponse cardResponse = new GetCardResponse();
        StoredCard card = new StoredCard();
        if (null != jsonResponse.get("card_number")) {
            card.withCardToken((String) jsonResponse.get("card_token"))
                    .withCardReference((String) jsonResponse.get("card_reference"))
                    .withCardNumber((String) jsonResponse.get("card_number"))
                    .withCardExpYear((String) jsonResponse.get("card_exp_year"))
                    .withCardExpMonth((String) jsonResponse.get("card_exp_month"))
                    .withCardIsin((String) jsonResponse.get("card_isin"))
                    .withCardBrand((String) jsonResponse.get("card_brand"))
                    .withCardIssuer((String) jsonResponse.get("card_issuer"))
                    .withCardType((String) jsonResponse.get("card_type"))
                    .withNickname((String) jsonResponse.get("nickname"))
                    .withNameOnCard((String) jsonResponse.get("name_on_card"));
            cardResponse.setCard(card);
        }
        cardResponse.setCardToken((String) jsonResponse.get("card_token"));
        cardResponse.setMerchantId((String) jsonResponse.get("merchantId"));
        return cardResponse;
    }

    public GetOrderStatusResponse updateOrder(UpdateOrderRequest updateOrderRequest) {
        LinkedHashMap<String, String> params = new LinkedHashMap<String, String>();
        params.put("order_id", updateOrderRequest.getOrderId());
        params.put("amount", String.valueOf(updateOrderRequest.getAmount()));
        // Billing and shipping addresses
        params.put("billing_address_first_name", updateOrderRequest.getBillingAddressFirstName() == null ? "" : updateOrderRequest.getBillingAddressFirstName());
        params.put("billing_address_last_name", updateOrderRequest.getBillingAddressLastName() == null ? "" : updateOrderRequest.getBillingAddressLastName());
        params.put("billing_address_line1", updateOrderRequest.getBillingAddressLine1() == null ? "" : updateOrderRequest.getBillingAddressLine1());
        params.put("billing_address_line2", updateOrderRequest.getBillingAddressLine2() == null ? "" : updateOrderRequest.getBillingAddressLine2());
        params.put("billing_address_line3", updateOrderRequest.getBillingAddressLine3() == null ? "" : updateOrderRequest.getBillingAddressLine3());
        params.put("billing_address_city", updateOrderRequest.getBillingAddressCity() == null ? "" : updateOrderRequest.getBillingAddressCity());
        params.put("billing_address_state", updateOrderRequest.getBillingAddressState() == null ? "" : updateOrderRequest.getBillingAddressState());
        params.put("billing_address_postal_code", updateOrderRequest.getBillingAddressPostalCode() == null ? "" : updateOrderRequest.getBillingAddressPostalCode());
        params.put("billing_address_phone", updateOrderRequest.getBillingAddressPhone() == null ? "" : updateOrderRequest.getBillingAddressPhone());
        params.put("billing_address_country_code_iso", updateOrderRequest.getBillingAddressCountryCodeIso() == null ? "" : updateOrderRequest.getBillingAddressCountryCodeIso());
        params.put("billing_address_country", updateOrderRequest.getBillingAddressCountry() == null ? "" :updateOrderRequest.getBillingAddressCountry());
        params.put("shipping_address_first_name", updateOrderRequest.getShippingAddressFirstName() == null ? "" : updateOrderRequest.getShippingAddressFirstName());
        params.put("shipping_address_last_name", updateOrderRequest.getShippingAddressLastName() == null ? "" : updateOrderRequest.getShippingAddressLastName());
        params.put("shipping_address_line1", updateOrderRequest.getShippingAddressLine1() == null ? "" : updateOrderRequest.getShippingAddressLine1());
        params.put("shipping_address_line2", updateOrderRequest.getShippingAddressLine2() == null ? "" : updateOrderRequest.getShippingAddressLine2());
        params.put("shipping_address_line3", updateOrderRequest.getShippingAddressLine3() == null ? "" : updateOrderRequest.getShippingAddressLine3());
        params.put("shipping_address_city", updateOrderRequest.getShippingAddressCity() == null ? "" : updateOrderRequest.getShippingAddressCity());
        params.put("shipping_address_state", updateOrderRequest.getShippingAddressState() == null ? "" : updateOrderRequest.getShippingAddressState());
        params.put("shipping_address_postal_code", updateOrderRequest.getShippingAddressPostalCode() == null ? "" : updateOrderRequest.getShippingAddressPostalCode());
        params.put("shipping_address_phone", updateOrderRequest.getShippingAddressPhone() == null ? "" : updateOrderRequest.getShippingAddressPhone());
        params.put("shipping_address_country_code_iso", updateOrderRequest.getShippingAddressCountryCodeIso() == null ? "" : updateOrderRequest.getShippingAddressCountryCodeIso());
        params.put("shipping_address_country", updateOrderRequest.getShippingAddressCountry() == null ? "" : updateOrderRequest.getShippingAddressCountry());

        // Optional parameters
        params.put("udf1", updateOrderRequest.getUdf1() == null ? "" : updateOrderRequest.getUdf1());
        params.put("udf2", updateOrderRequest.getUdf2() == null ? "" : updateOrderRequest.getUdf2());
        params.put("udf3", updateOrderRequest.getUdf3() == null ? "" : updateOrderRequest.getUdf3());
        params.put("udf4", updateOrderRequest.getUdf4() == null ? "" : updateOrderRequest.getUdf4());
        params.put("udf5", updateOrderRequest.getUdf5() == null ? "" : updateOrderRequest.getUdf5());
        params.put("udf6", updateOrderRequest.getUdf6() == null ? "" : updateOrderRequest.getUdf6());
        params.put("udf7", updateOrderRequest.getUdf7() == null ? "" : updateOrderRequest.getUdf7());
        params.put("udf8", updateOrderRequest.getUdf8() == null ? "" : updateOrderRequest.getUdf8());
        params.put("udf9", updateOrderRequest.getUdf9() == null ? "" : updateOrderRequest.getUdf9());
        params.put("udf10", updateOrderRequest.getUdf10() == null ? "" : updateOrderRequest.getUdf10());
        String serializedParams = serializeParams(params);

        String url = baseUrl + "/order/update";

        String response = makeServiceCall(url, serializedParams);

        JSONObject jsonResponse = (JSONObject) JSONValue.parse(response);

        return assembleOrderStatusResponse(jsonResponse, new GetOrderStatusResponse());
    }


    public GetOrderStatusResponse getOrderStatus(GetOrderStatusRequest orderStatusRequest) {
        LinkedHashMap<String, String> params = new LinkedHashMap<String, String>();
        params.put("order_id", orderStatusRequest.getOrderId());
        if(orderStatusRequest.getForce() != null && orderStatusRequest.getForce()) {
            params.put("force", orderStatusRequest.getForce().toString());
        }
        String serializedParams = serializeParams(params);
        String url = baseUrl + "/order_status";

        String response = makeServiceCall(url, serializedParams);
        JSONObject jsonResponse = (JSONObject) JSONValue.parse(response);

        return assembleOrderStatusResponse(jsonResponse, new GetOrderStatusResponse());
    }

    protected Double getDoubleValue(Object inputObject) {
        if(inputObject instanceof Long) {
            return ((Long) inputObject).doubleValue();
        }
        else if(inputObject instanceof Double) {
            return ((Double) inputObject);
        }
        else {
            LOG.warn("Can't seem to understand the input");
            return null;
        }
    }

    protected GetOrderStatusResponse assembleOrderStatusResponse(JSONObject jsonResponse,
                                                                 GetOrderStatusResponse target) {
        GetOrderStatusResponse orderStatusResponse = target;
        orderStatusResponse.setMerchantId((String) jsonResponse.get("merchant_id"));
        orderStatusResponse.setOrderId((String) jsonResponse.get("order_id"));
        orderStatusResponse.setStatus((String) jsonResponse.get("status"));
        orderStatusResponse.setStatusId((Long) jsonResponse.get("status_id"));
        orderStatusResponse.setTxnId((String) jsonResponse.get("txn_id"));
        orderStatusResponse.setGatewayId((Long) jsonResponse.get("gateway_id"));

        orderStatusResponse.setAmount(getDoubleValue(jsonResponse.get("amount")));
        orderStatusResponse.setBankErrorCode((String) jsonResponse.get("bank_error_code"));
        orderStatusResponse.setBankErrorMessage((String) jsonResponse.get("bank_error_message"));

        orderStatusResponse.setUdf1((String) jsonResponse.get("udf1"));
        orderStatusResponse.setUdf2((String) jsonResponse.get("udf2"));
        orderStatusResponse.setUdf3((String) jsonResponse.get("udf3"));
        orderStatusResponse.setUdf4((String) jsonResponse.get("udf4"));
        orderStatusResponse.setUdf5((String) jsonResponse.get("udf5"));
        orderStatusResponse.setUdf6((String) jsonResponse.get("udf6"));
        orderStatusResponse.setUdf7((String) jsonResponse.get("udf7"));
        orderStatusResponse.setUdf8((String) jsonResponse.get("udf8"));
        orderStatusResponse.setUdf9((String) jsonResponse.get("udf9"));
        orderStatusResponse.setUdf10((String) jsonResponse.get("udf10"));

        orderStatusResponse.setAmountRefunded(getDoubleValue(jsonResponse.get("amount_refunded")));
        orderStatusResponse.setRefunded((Boolean) jsonResponse.get("refunded"));

        JSONObject gatewayResponse = (JSONObject) jsonResponse.get("payment_gateway_response");

        JSONObject cardResponse = (JSONObject) jsonResponse.get("card");

        if (cardResponse != null) {
            PaymentCardResponse paymentCardResponse = new PaymentCardResponse();
            paymentCardResponse.setLastFourDigits((String) cardResponse.get("last_four_digits"));
            paymentCardResponse.setCardIsin((String) cardResponse.get("card_isin"));
            paymentCardResponse.setExpiryMonth((String) cardResponse.get("expiry_month"));
            paymentCardResponse.setExpiryYear((String) cardResponse.get("expiry_year"));
            paymentCardResponse.setNameOnCard((String) cardResponse.get("name_on_card"));
            paymentCardResponse.setCardType((String) cardResponse.get("card_type"));
            paymentCardResponse.setCardIssuer((String) cardResponse.get("card_issuer"));
            paymentCardResponse.setCardBrand((String) cardResponse.get("card_brand"));
            orderStatusResponse.setPaymentCardResponse(paymentCardResponse);
        }

        if (gatewayResponse != null) {
            PaymentGatewayResponse paymentGatewayResponse = new PaymentGatewayResponse();
            paymentGatewayResponse.setRootReferenceNumber((String) gatewayResponse.get("rrn"));
            paymentGatewayResponse.setResponseCode((String) gatewayResponse.get("resp_code"));
            paymentGatewayResponse.setResponseMessage((String) gatewayResponse.get("resp_message"));
            paymentGatewayResponse.setTxnId((String) gatewayResponse.get("txn_id"));
            paymentGatewayResponse.setExternalGatewayTxnId((String) gatewayResponse.get("epg_txn_id"));
            paymentGatewayResponse.setAuthIdCode((String) gatewayResponse.get("auth_id_code"));
            orderStatusResponse.setPaymentGatewayResponse(paymentGatewayResponse);
        }

        JSONObject promotionResponse = (JSONObject) jsonResponse.get("promotion");
        if(promotionResponse != null) {
            Promotion promotion = assemblePromotionObjectFromJSON(promotionResponse);
            orderStatusResponse.setPromotion(promotion);
        }

        JSONArray refunds = (JSONArray) jsonResponse.get("refunds");
        if(refunds != null && refunds.size() > 0) {
            List<Refund> refundList = new ArrayList<Refund>(refunds.size());
            for(Iterator refundIter = refunds.iterator();refundIter.hasNext();) {
                JSONObject refundEntry = (JSONObject) refundIter.next();
                Refund refund = new Refund();
                refund.setId((String) refundEntry.get("id"));
                refund.setReference((String) refundEntry.get("ref"));
                refund.setAmount(getDoubleValue(refundEntry.get("amount")));
                refund.setUniqueRequestId((String) refundEntry.get("unique_request_id"));
                refund.setStatus((String) refundEntry.get("status"));
                try {
                    refund.setCreated(ISO8601DateParser.parse((String) refundEntry.get("created")));
                } catch (ParseException e) {
                    LOG.error("Exception while trying to parse date created. Skipping the field", e);
                }
                refundList.add(refund);
            }
          //  orderStatusResponse.setRefunds(refundList);
        }
        return orderStatusResponse;
    }

    /**
     * Creates a new card
     *
     * @param addCardRequest - AddCardRequest with all the required params
     * @return AddCardResponse for the given request.
     */
    public AddCardResponse addCard(AddCardRequest addCardRequest) {
        //Get the required params
        LinkedHashMap<String, String> params = new LinkedHashMap<String, String>();
        params.put("customer_id", addCardRequest.customerId);
        params.put("customer_email", addCardRequest.customerEmail);
        params.put("card_number", String.valueOf(addCardRequest.cardNumber));
        params.put("card_exp_year", String.valueOf(addCardRequest.cardExpYear));
        params.put("card_exp_month", String.valueOf(addCardRequest.cardExpMonth));
        params.put("name_on_card", addCardRequest.nameOnCard != null ? addCardRequest.nameOnCard : "");
        params.put("nickname", addCardRequest.nickname != null ? addCardRequest.nickname : "");

        String serializedParams = serializeParams(params);
        String url = baseUrl + "/card/add";

        String response = makeServiceCall(url, serializedParams);
        JSONObject json = (JSONObject) JSONValue.parse(response);

        String cardToken = (String) json.get("card_token");
        String cardReference = (String) json.get("card_reference");

        AddCardResponse addCardResponse = new AddCardResponse();
        addCardResponse.setCardToken(cardToken);
        addCardResponse.setCardReference(cardReference);

        return addCardResponse;

    }

    /**
     * Deletes the card (if present) and returns the DeleteCardResponse associated with the request
     *
     * @param deleteCardRequest - DeleteCardRequest request with all required params.
     * @return DeleteCardResponse for the given request.
     */
    public DeleteCardResponse deleteCard(DeleteCardRequest deleteCardRequest) {
        LinkedHashMap<String, String> params = new LinkedHashMap<String, String>();
        params.put("card_token", deleteCardRequest.cardToken);

        String serializedParams = serializeParams(params);
        String url = baseUrl + "/card/delete";

        String response = makeServiceCall(url, serializedParams);
        JSONObject jsonResponse = (JSONObject) JSONValue.parse(response);

        String card_token = (String) jsonResponse.get("card_token");
        Boolean deleted = (Boolean) jsonResponse.get("deleted");
        String card_reference = null;
        if (null != jsonResponse.get("card_reference")) {
            card_reference = (String) jsonResponse.get("card_reference");
        }

        return new DeleteCardResponse().withCardToken(card_token).
                withDeleted(deleted).
                withCardReference(card_reference);
    }

    /**
     * Initiates the payment call and returns the response of Payment
     *
     * @param paymentRequest - PaymentRequest with all required params
     * @return PaymentResponse for the given request
     */
    public PaymentResponse makePayment(PaymentRequest paymentRequest) {
        LinkedHashMap<String, String> params = new LinkedHashMap<String, String>();
        //String merchantId, String orderId,String cardNumber,String cardExpYear,String cardExpMonth,String cardSecurityCode
        params.put("merchant_id", paymentRequest.getMerchantId());
        params.put("order_id", paymentRequest.getOrderId());
        String paymentMethodType = paymentRequest.getPaymentMethodType();
        if (paymentMethodType == "NB") {
            params.put("payment_method_type", paymentMethodType);
            params.put("payment_method", paymentRequest.getPaymentMethod());
        } else {
            String cardToken = paymentRequest.getCardToken();
            if(cardToken != null) {
                params.put("card_token", cardToken);

            } else {
                params.put("card_number", paymentRequest.getCardNumber());
                params.put("card_exp_year", paymentRequest.getCardExpYear());
                params.put("card_exp_month", paymentRequest.getCardExpMonth());
                params.put("name_on_card", paymentRequest.getNameOnCard() == null ? "" : paymentRequest.getNameOnCard());
                params.put("save_to_locker", paymentRequest.getSaveToLocker() == null ? "false" : paymentRequest.getSaveToLocker().toString());
            }
            params.put("payment_method_type", "CARD");
            params.put("card_security_code", paymentRequest.getCardSecurityCode());

            if(paymentRequest.getIsEmi() != null && paymentRequest.getIsEmi() == true) {
                params.put("is_emi", "true");
                params.put("emi_bank", paymentRequest.getEmiBank());
                params.put("emi_tenure", "" + paymentRequest.getEmiTenure());
            }

        }
        params.put("redirect_after_payment", paymentRequest.getRedirectAfterPayment() == null ? "false" : paymentRequest.getRedirectAfterPayment().toString());
        params.put("format", paymentRequest.getFormat() == null ? "json" : paymentRequest.getFormat());


        String serializedParams = serializeParams(params);
        String url = baseUrl + "/txns";

        String response = makeServiceCall(url, serializedParams);
        JSONObject jsonResponse = (JSONObject) JSONValue.parse(response);
        String status = (String) jsonResponse.get("status");
        String txnId = (String) jsonResponse.get("txn_id");
        String orderId = (String) jsonResponse.get("order_id");
        JSONObject authentication = (JSONObject) ((JSONObject) jsonResponse.get("payment")).get("authentication");
        String authUrl = (String) authentication.get("url");
        String authMethod = (String) authentication.get("method");
        JSONObject postParams = (JSONObject) authentication.get("params");

        PaymentResponse paymentResponse = new PaymentResponse();
        paymentResponse.setStatus(status);
        paymentResponse.setTxnId(txnId);
        paymentResponse.setOrderId(orderId);
        PaymentAuthenticationResponse authenticationResponse = new PaymentAuthenticationResponse();
        authenticationResponse.setUrl(authUrl);
        authenticationResponse.setMethod(authMethod);

        if(postParams != null) {
            authenticationResponse.setPostParams(postParams);
            authenticationResponse.setSerializedPostParams(serializeParams(postParams));
        }

        paymentResponse.setAuthentication(authenticationResponse);
        return paymentResponse;
    }

    /**
     * List the cards for the user (if already present) for the given request
     *
     * @param listCardsRequest - 	ListCardsRequest with all required params.
     * @return ListCardsResponse for the given request.
     */
    public ListCardsResponse listCards(ListCardsRequest listCardsRequest) {
        LinkedHashMap<String, String> params = new LinkedHashMap<String, String>();
        params.put("customer_id", listCardsRequest.customerId);

        String serializedParams = serializeParams(params);
        String url = baseUrl + "/card/list";

        String response = makeServiceCall(url, serializedParams);
        JSONObject jsonResponse = (JSONObject) JSONValue.parse(response);

        String customerId = (String) jsonResponse.get("customer_id");
        String merchantId = (String) jsonResponse.get("merchantId");
        ArrayList<JSONObject> tempCards = (ArrayList<JSONObject>) jsonResponse.get("cards");

        ListCardsResponse listCardsResponse = new ListCardsResponse();
        listCardsResponse.customerId = customerId;
        listCardsResponse.merchantId = merchantId;

        ArrayList<StoredCard> cards = new ArrayList<StoredCard>();

        if (tempCards != null) {
            for (JSONObject cardObject : tempCards) {

                StoredCard card = new StoredCard();

                card.withCardToken((String) cardObject.get("card_token"))
                        .withCardReference((String) cardObject.get("card_reference"))
                        .withCardNumber((String) cardObject.get("card_number"))
                        .withCardExpYear((String) cardObject.get("card_exp_year"))
                        .withCardExpMonth((String) cardObject.get("card_exp_month"))
                        .withCardIsin((String) cardObject.get("card_isin"))
                        .withNameOnCard(cardObject.get("name_on_card") != null ?
                                cardObject.get("name_on_card").toString() : "")
                        .withCardToken((String) cardObject.get("card_token"))
                        .withCardBrand((String) cardObject.get("card_brand"))
                        .withCardIssuer((String) cardObject.get("card_issuer"))
                        .withCardType((String) cardObject.get("card_type"))
                        .withNickname((String) cardObject.get("nickname"));

                cards.add(card);
            }
        }

        listCardsResponse.cards = cards;
        return listCardsResponse;
    }

    public RefundResponse refund(RefundRequest refundRequest) {
        LinkedHashMap<String, String> params = new LinkedHashMap<String, String>();

        params.put("order_id", refundRequest.getOrderId());
        params.put("amount", refundRequest.getAmount().toString());

        String serializedParams = serializeParams(params);
        String url = baseUrl + "/order/refund";

        String response = makeServiceCall(url, serializedParams);
        JSONObject jsonResponse = (JSONObject) JSONValue.parse(response);

        RefundResponse refundResponse = (RefundResponse) assembleOrderStatusResponse(jsonResponse, new RefundResponse());
        refundResponse.setSuccess(true);
        return refundResponse;

    }

    /**
     * Assembles a complete Promotion object from the given JSONObject.
     * @param jsonObject
     *  - An instance of JSONObject that contains promotion information.
     * @return
     *  - Promotion object that corresponds to the json input.
     */
    private Promotion assemblePromotionObjectFromJSON(JSONObject jsonObject) {
        Promotion promotion = new Promotion();
        promotion.setId((String) jsonObject.get("id"));
        promotion.setOrderId((String) jsonObject.get("order_id"));
        promotion.setDiscountAmount(Double.valueOf(jsonObject.get("discount_amount").toString()));
        String status = (String) jsonObject.get("status");
        promotion.setStatus(PromotionStatus.valueOf(status));

        ArrayList<JSONObject> conditions = (ArrayList<JSONObject>) jsonObject.get("conditions");
        ArrayList<JSONObject> rules = (ArrayList<JSONObject>) jsonObject.get("rules");

        List<PromotionCondition> promotionConditions = new ArrayList<PromotionCondition>();
        for(JSONObject jsonCondition : (conditions != null ? conditions : rules)) {
            PromotionCondition promotionCondition = new PromotionCondition();
            promotionCondition.setDimension((String) jsonCondition.get("dimension"));
            promotionCondition.setValue((String) jsonCondition.get("value"));
            promotionConditions.add(promotionCondition);
        }
        promotion.setPromotionConditions(promotionConditions);
        return promotion;
    }


    /**
     * Create a promotion for an order given all the inputs.
     * @param createPromotionRequest
     *  - An instance of CreatePromotionRequest that encapsulates all the information pertaining to the promotion.
     * @return
     *  - An instance of CreatePromotionResponse that contains the response status of the API call and the Promotion
     *  object itself.
     */
    public CreatePromotionResponse createPromotion(CreatePromotionRequest createPromotionRequest) {
        LinkedHashMap<String, String> params = new LinkedHashMap<String, String>();
        params.put("order_id", createPromotionRequest.getOrderId());
        params.put("discount_amount", Double.valueOf(createPromotionRequest.getDiscountAmount()).toString());
        for(int i=0; i < createPromotionRequest.getPromotionConditions().size(); i++) {
            PromotionCondition condition = createPromotionRequest.getPromotionConditions().get(i);
            params.put("dimensions[" + i + "]", condition.getDimension());
            params.put("values[" + i + "]", condition.getValue());
        }
        String serializedParams = serializeParams(params);
        String url = baseUrl + "/promotions";

        String response = makeServiceCall(url, serializedParams);
        JSONObject jsonResponse = (JSONObject) JSONValue.parse(response);

        CreatePromotionResponse promotionResponse = new CreatePromotionResponse();
        promotionResponse.setSuccess(true);
        Promotion promotion = assemblePromotionObjectFromJSON(jsonResponse);
        promotionResponse.setPromotion(promotion);
        return promotionResponse;
    }

    /**
     * Deactivates a promotion.
     * @param deactivatePromotionRequest
     *  - request object representing the promotion using the id.
     * @return
     *  - returns an object containing the status and the promotion object itself.
     */
    public DeactivatePromotionResponse deactivatePromotion(DeactivatePromotionRequest deactivatePromotionRequest) {
        LinkedHashMap<String, String> params = new LinkedHashMap<String, String>();
        params.put("promotion_id", deactivatePromotionRequest.getPromotionId());
        String serializedParams = serializeParams(params);
        String url = baseUrl + "/promotions/" + deactivatePromotionRequest.getPromotionId() + "/deactivate";

        String response = makeServiceCall(url, serializedParams);
        JSONObject jsonResponse = (JSONObject) JSONValue.parse(response);

        DeactivatePromotionResponse deactivatePromotionResponse = new DeactivatePromotionResponse();
        deactivatePromotionResponse.setSuccess(true);
        Promotion promotion = assemblePromotionObjectFromJSON(jsonResponse);
        deactivatePromotionResponse.setPromotion(promotion);
        return deactivatePromotionResponse;
    }

    public void setConnectionTimeout(int connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    public void setReadTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
    }

}
