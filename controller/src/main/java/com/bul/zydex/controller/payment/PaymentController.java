/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.payment;

import com.bul.zydex.controller.PaymentGateway.CreateOrderRequest;
import com.bul.zydex.controller.PaymentGateway.CreateOrderResponse;
import com.bul.zydex.controller.PaymentGateway.Environment;
import com.bul.zydex.controller.PaymentGateway.GetOrderStatusRequest;
import com.bul.zydex.controller.PaymentGateway.GetOrderStatusResponse;
import com.bul.zydex.controller.PaymentGateway.PaymentService;
import com.bul.zydex.model.LocationMaster;
import com.bul.zydex.model.PaymentMode;
import com.bul.zydex.model.PaymentStatus;
import com.bul.zydex.model.PaymentTypeMaster;
import com.bul.zydex.model.TypeOfPayment;
import com.bul.zydex.model.Vendors;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author admin
 */
public class PaymentController extends PaymentAbstract {

    private String testKey = "2E4C02A94F314D31BEC0D8C093DA94D7";
    private static final String TEST_KEY = "7F3282CC43004D5A818E781F39440442";
    private static final String AXIS_KEY = "782CB4B3F5B84BDDB3C9EAFA6A134DC3";
    private static final String AXIS_KEY_TEST = "2E4C02A94F314D31BEC0D8C093DA94D7";
    private static final String AXIS_KEY_PRODUCTION = "F57C7F540A7437A9C0831770B41EE1";
    private String testOrderId = "" + System.currentTimeMillis();

    private static Logger log = Logger.getLogger(PaymentController.class);

    public ModelAndView showTypeOfPayment(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        List<?> list1 = paymentTypeService.read();
        request.setAttribute("list", list1);
        mv.setViewName("Payment/PaymentTypeShow");

        return mv;
    }

    public ModelAndView createClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        TypeOfPayment employeeTypeMaster = new TypeOfPayment();
        mv.getModelMap().put("employeeTypeMaster", employeeTypeMaster);
        mv.setViewName("Payment/PaymentTypeCreate");
        return mv;
    }

    public ModelAndView PaymentConfirmation(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PaymentStatus paymentStatus = new PaymentStatus();

        String url = request.getRequestURL().toString();

        // Getting servlet request query string.
        String queryString = request.getQueryString();

        String orderId = "";
        String requestOrderId = (String) request.getParameter("orderId");
        if (queryString != null && queryString.length() > 30) {

            String tempString[] = queryString.split("&");
            String[] temp = tempString[0].split("=");
            orderId = temp[1];
        }

        if ((orderId == null || orderId.isEmpty()) && (requestOrderId != null && !requestOrderId.isEmpty())) {

            bind(request, paymentStatus);

            PaymentService juspayService = new PaymentService().withEnvironment(Environment.AXIS)
                    .withKey(AXIS_KEY_PRODUCTION).withMerchantId("GIPC_TEST");

            GetOrderStatusRequest orderStatusRequest = new GetOrderStatusRequest();
            orderStatusRequest.withOrderId(paymentStatus.getOrderId());

            GetOrderStatusResponse orderStatusResponse = juspayService.getOrderStatus(orderStatusRequest);
            orderId = orderStatusResponse.getOrderId();
            queryString = orderStatusResponse.getStatus();

            if (queryString != null && queryString.contains("NOT_FOUND")) {

                paymentStatus.setOrderId(orderId);
                paymentStatus.setStatus("Order is not available");

            } else if (queryString != null && queryString.contains("NEW")) {

                paymentStatus.setOrderId(orderId);
                paymentStatus.setStatus("Newly created order");

            } else if (queryString != null && queryString.contains("CREATED")) {

                paymentStatus.setOrderId(orderId);
                paymentStatus.setStatus("Order is in transistion state");

            } else if (queryString != null && queryString.contains("PENDING_VBV")) {

                paymentStatus.setOrderId(orderId);
                paymentStatus.setStatus("Authentication is in progress");

            } else if (queryString != null && queryString.contains("CHARGED")) {

                paymentStatus.setOrderId(orderId);
                paymentStatus.setStatus("Successful transaction");

            } else if (queryString != null && queryString.contains("AUTHENTICATION_FAILED")) {

                paymentStatus.setOrderId(orderId);
                paymentStatus.setStatus("User did not complete authentication");

            } else if (queryString != null && queryString.contains("AUTHORIZATION_FAILED")) {

                paymentStatus.setOrderId(orderId);
                paymentStatus.setStatus("User completed authentication, but bank refused the transaction");

            } else if (queryString != null && queryString.contains("JUSPAY_DECLINED")) {

                paymentStatus.setOrderId(orderId);
                paymentStatus.setStatus("User input is not accepted by the underlying PG");

            } else if (queryString != null && queryString.contains("AUTHORIZING")) {

                paymentStatus.setOrderId(orderId);
                paymentStatus.setStatus("Transaction status is pending from bank");

            }

            log.info("Order status response: " + orderStatusResponse);
        } else {

            if (queryString != null && queryString.contains("NEW")) {

                paymentStatus.setOrderId(orderId);
                paymentStatus.setStatus("Newly created order");

            } else if (queryString != null && queryString.contains("CREATED")) {

                paymentStatus.setOrderId(orderId);
                paymentStatus.setStatus("Order is in transistion state");

            } else if (queryString != null && queryString.contains("PENDING_VBV")) {

                paymentStatus.setOrderId(orderId);
                paymentStatus.setStatus("Authentication is in progress");

            } else if (queryString != null && queryString.contains("CHARGED")) {

                paymentStatus.setOrderId(orderId);
                paymentStatus.setStatus("Successful transaction");

            } else if (queryString != null && queryString.contains("AUTHENTICATION_FAILED")) {

                paymentStatus.setOrderId(orderId);
                paymentStatus.setStatus("User did not complete authentication");

            } else if (queryString != null && queryString.contains("AUTHORIZATION_FAILED")) {

                paymentStatus.setOrderId(orderId);
                paymentStatus.setStatus("User completed authentication, but bank refused the transaction");

            } else if (queryString != null && queryString.contains("JUSPAY_DECLINED")) {

                paymentStatus.setOrderId(orderId);
                paymentStatus.setStatus("User input is not accepted by the underlying PG");

            } else if (queryString != null && queryString.contains("AUTHORIZING")) {

                paymentStatus.setOrderId(orderId);
                paymentStatus.setStatus("Transaction status is pending from bank");

            }
        }
        //bind(request, paymentStatus);

        PaymentTypeMaster paymentTypeMaster = paymentTypeMasterService.getPaymentTypeMasterByOrderId(orderId);

        TypeOfPayment typeOfPayment=paymentTypeService.readById(paymentTypeMaster.getTypeOfPayment());
        
        mv.getModelMap().put("paymentStatus", paymentStatus);
        request.setAttribute("orderId", orderId);
        request.setAttribute("status", paymentStatus.getStatus());
        request.setAttribute("createdDate", paymentTypeMaster.getCreatedDate());
        request.setAttribute("Amount", paymentTypeMaster.getPaymentAmount());
        request.setAttribute("vendorName", paymentTypeMaster.getNameOfParty());
        request.setAttribute("paymentType", typeOfPayment.getTypeOfEmployee());
        request.setAttribute("paymentStatus", paymentStatus);
        mv.setViewName("Payment/PaymentSlip");

        return mv;
    }

//    public ModelAndView gotoHome(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("User/Login");
//        return mv;
//    }
    public ModelAndView gotoHome(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        session.invalidate();
        mv.setViewName("redirect:logIn.html?act=loginClick");
        return mv;
    }

    public ModelAndView PaymentConfirmationCallBack(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Payment/PaymentStatusPage");

        return mv;
    }

//    public ModelAndView printPayment(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("Payment/PaymentSlip");
//
//        return mv;
//    }
    public ModelAndView SearchOrderId(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PaymentStatus paymentStatus = new PaymentStatus();
        String orderid = request.getParameter("orderId");
        String status = request.getParameter("status");
        paymentStatus.setOrderId(orderid);
        paymentStatus.setStatus(status);
        mv.setViewName("Payment/PaymentStatusResult");
        return mv;
    }

    public ModelAndView showPaymentMode(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        List<?> list1 = paymentModeService.read();
        request.setAttribute("list", list1);
        mv.setViewName("Payment/PaymentModeShow");

        return mv;
    }

    public ModelAndView createPaymentModeClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PaymentMode employeeTypeMaster = new PaymentMode();
        mv.getModelMap().put("employeeTypeMaster", employeeTypeMaster);
        mv.setViewName("Payment/PaymentModeCreate");
        return mv;
    }

    public ModelAndView createPaymentModeSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PaymentMode employeeTypeMaster = new PaymentMode();
        BindException errors = new BindException(employeeTypeMaster, "employeeTypeMaster");
        bind(request, employeeTypeMaster);

        String formatvalue = employeeTypeMaster.getAmountTo();
        employeeTypeMaster.setAmountTo(formatvalue.trim());

        //employeeTypeValidator.validate(employeeTypeMaster, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv.addAllObjects(errors.getModel());
            mv.getModelMap().put("employeeTypeMaster", employeeTypeMaster);
            mv.setViewName("Payment/PaymentModeCreate");

        } else {
            paymentModeService.create(employeeTypeMaster);
            request.setAttribute("successMessage",
                    "Information : The Information is saved Successfully.");
            mv = showPaymentMode(request, response);
        }
        return mv;
    }

    public ModelAndView createSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        TypeOfPayment employeeTypeMaster = new TypeOfPayment();
        BindException errors = new BindException(employeeTypeMaster, "employeeTypeMaster");
        bind(request, employeeTypeMaster);
        String formatvalue = employeeTypeMaster.getTypeOfEmployee();
        employeeTypeMaster.setTypeOfEmployee(formatvalue.trim());
        //employeeTypeValidator.validate(employeeTypeMaster, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv.addAllObjects(errors.getModel());
            mv.getModelMap().put("employeeTypeMaster", employeeTypeMaster);
            mv.setViewName("Payment/PaymentTypeCreate");

        } else {
            paymentTypeService.create(employeeTypeMaster);
            request.setAttribute("successMessage",
                    "Information : The Information is saved Successfully.");
            mv = showTypeOfPayment(request, response);
        }
        return mv;
    }

    public ModelAndView deleteSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String savingList[] = request.getParameterValues("checkId");
        for (String z : savingList) {
            try {
                paymentTypeService.delete(Integer.parseInt(z));
                request.setAttribute("successMessage",
                        "Info : One or more records are deleted successfully.");
            } catch (Exception e) {

            }
        }
        mv = showTypeOfPayment(request, response);
        return mv;
    }

    public ModelAndView deletePaymentModeSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String savingList[] = request.getParameterValues("checkId");
        for (String z : savingList) {
            try {
                paymentModeService.delete(Integer.parseInt(z));
                request.setAttribute("successMessage",
                        "Info : One or more records are deleted successfully.");
            } catch (Exception e) {

            }
        }
        mv = showPaymentMode(request, response);
        return mv;
    }

    public ModelAndView showPaymentMasterForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        List<?> list1 = paymentTypeMasterService.read();
        request.setAttribute("list", list1);
        mv.setViewName("Payment/PaymentTypeMasterShow");

        return mv;
    }

    public ModelAndView createPaymentTypeMasterClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PaymentTypeMaster employeeTypeMaster = new PaymentTypeMaster();

        //----- Get data of payment type
        TypeOfPayment typeOfPayment = new TypeOfPayment();
        List<?> level = paymentTypeService.read();
        Map<Integer, String> level1 = new HashMap<>();
        for (Object o : level) {
            typeOfPayment = (TypeOfPayment) o;
            level1.put(typeOfPayment.getId(), typeOfPayment.getTypeOfEmployee());
        }
        request.setAttribute("paymentTypeMap", level1);

        //---- Get data of location master
        LocationMaster locationMaster = new LocationMaster();
        List<?> level2 = locationMasterService.read();
        Map<Integer, String> level3 = new HashMap<>();
        for (Object o : level2) {
            locationMaster = (LocationMaster) o;
            level3.put(locationMaster.getId(), locationMaster.getLocation());
        }
        request.setAttribute("locationTypeMap", level3);

        mv.getModelMap().put("employeeTypeMaster", employeeTypeMaster);
        mv.setViewName("Payment/PaymentTypeMasterCreate");
        return mv;
    }

    public ModelAndView createPaymentTypeMasterSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PaymentTypeMaster employeeTypeMaster = new PaymentTypeMaster();
        BindException errors = new BindException(employeeTypeMaster, "employeeTypeMaster");
        bind(request, employeeTypeMaster);
        String formatvalue = employeeTypeMaster.getEmailId();
        employeeTypeMaster.setEmailId(formatvalue.trim());
        //employeeTypeValidator.validate(employeeTypeMaster, errors);
        paymentTypeMasterValidator.validate(employeeTypeMaster, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv.addAllObjects(errors.getModel());
            mv.getModelMap().put("employeeTypeMaster", employeeTypeMaster);
            mv.setViewName("Payment/PaymentTypeMasterCreate");

        } else {

            String date = LocalDate.now().toString();
            employeeTypeMaster.setCreatedDate(date);

            Integer paymentCount = paymentTypeMasterService.paymentCountByDate(date);

            String suffix = "0000";

            String months = "";
            if (LocalDate.now().getMonthValue() < 10) {
                months = "0" + LocalDate.now().getMonthValue();
            } else {

                months = "" + LocalDate.now().getMonthValue();
            }
            String referenceNo = "GIPCL" + LocalDate.now().getDayOfMonth() + "" + months + "" + "20";

            if (paymentCount < 10) {

                suffix = "000" + paymentCount;

            } else if (paymentCount < 100) {

                suffix = "00" + paymentCount;

            } else if (paymentCount < 1000) {

                suffix = "0" + paymentCount;

            } else {

                suffix = "" + paymentCount;
            }

            referenceNo = referenceNo + suffix;

            String api = referenceNo + "INR" + employeeTypeMaster.getPaymentAmount();

            employeeTypeMaster.setOrderid(api);
            paymentTypeMasterService.create(employeeTypeMaster);

            PaymentService juspayService = new PaymentService().withEnvironment(Environment.AXIS)
                    .withKey(AXIS_KEY_PRODUCTION).withMerchantId("GIPC_TEST");

            String randomOrderId = api;
            CreateOrderResponse createOrderResponse = null;

            try {

                CreateOrderRequest paymentRequest = new CreateOrderRequest()
                        .withOrderId(randomOrderId)
                        .withAmount(Double.valueOf(employeeTypeMaster.getPaymentAmount())).
                        withReturnUrl("http://192.168.0.29:8089/web/payment.html?act=PaymentConfirmation");

                paymentRequest.setCurrency("INR");

                createOrderResponse = juspayService.createOrder(paymentRequest);

                System.out.print("Hello Worlds");

            } catch (Exception e) {

                System.out.print("Hello Worlds " + e.getMessage());
            }

            //paymentRequest.setCustomerEmail("customer@gmail.com");
            //paymentRequest.setProductId("prod-141833");
            // paymentRequest.setReturnUrl("http://shop.merchant.com/payments/handleResponse");
            //paymentRequest.setDescription("Simple Test");
//            paymentRequest.setUdf1("udf1");
//            paymentRequest.setUdf2("udf2");
//            paymentRequest.setUdf3("udf3");
//            paymentRequest.setUdf4("udf4");
//            paymentRequest.setUdf5("udf5");
            // paymentRequest.setReturnUrl("https://www.google.com/");
            // CreateOrderResponse paymentResponse =juspayService.createOrder(paymentRequest);
//            PaymentService juspayService = new PaymentService().withEnvironment(Environment.PRODUCTION)
//                .withKey(TEST_KEY).withMerchantId("juspay_test");
//         //  String randomOrderId = "" + System.currentTimeMillis();
//        CreateOrderRequest createOrderRequest = new CreateOrderRequest().withOrderId(randomOrderId)
//                .withAmount(100.0)
//                .withCustomerId("guest_user_101").withEmail(employeeTypeMaster.getEmailId());
            //   log.info("Create order response:  " + createOrderResponse);
            //Update Order example call
//        UpdateOrderRequest updateOrderRequest = new UpdateOrderRequest().withOrderId(randomOrderId)
//                .withAmount(200.0);
            //  GetOrderStatusResponse updateOrderResponse = juspayService.updateOrder(updateOrderRequest);
            //  log.info("Update order response:  " + updateOrderResponse);
//        //AddCard example call
//        AddCardRequest addCardRequest = new AddCardRequest().withNameOnCard("Customer Name")
//                .withCardExpMonth("05").withCardExpYear("2020")
//                .withCardNumber("4242424242424242").withCustomerEmail("customer@shop.in")
//                .withCustomerId("customer_id");
//        AddCardResponse addCardResponse = juspayService.addCard(addCardRequest);
//        log.info("Add card response: " + addCardResponse);
//
//        //ListCard example call
//        ListCardsRequest listCardsRequest = new ListCardsRequest().withCustomerId("customer_id");
//        ListCardsResponse listCardsResponse = juspayService.listCards(listCardsRequest);
//        log.info("List card response: " + listCardsResponse);
            // OrderStatus example call
//            GetOrderStatusRequest orderStatusRequest = new GetOrderStatusRequest();
//            orderStatusRequest.withOrderId(randomOrderId);
//            GetOrderStatusResponse orderStatusResponse = juspayService.getOrderStatus(orderStatusRequest);
//            log.info("Order status response: " + orderStatusResponse);
//
//            // PaymentStatus example call
//            PaymentRequest payRequest = new PaymentRequest();
//
//            PaymentService paymentService;
//
//            PaymentService paymentService1 = new PaymentService();
//        //paymentService1.
//
//            // Regular card transaction
//            payRequest.withMerchantId("juspay_test").withOrderId(randomOrderId);//.withCardNumber("4242424242424242").
            //withCardExpYear("2020").withCardExpMonth("05").withCardSecurityCode("111");
            String test = "";

            //---- Get data of payment mode
//            PaymentMode locationMaster = new PaymentMode();
//            List<?> level2 = paymentModeService.read();
//            Map<Integer, String> level3 = new HashMap<>();
//            for (Object o : level2) {
//                locationMaster = (PaymentMode) o;
//                level3.put(locationMaster.getId(), locationMaster.getModeOfPayment());
//            }
//            request.setAttribute("paymentModeMap", level3);
//
//            request.setAttribute("successMessage",
//                    "Information : The Information is saved Successfully.");
            //  mv.getModelMap().put("employeeTypeMaster", employeeTypeMaster);
            //  mv.setViewName("Payment/paymentTypeMasterModeCreate");
            //  mv.addAttribute("attribute", "forwardWithForwardPrefix");
            //   PaymentResponse paymentResponse = juspayService.makePayment(payRequest);
            // log.info("Payment Response is:" + paymentResponse);
            ModelMap model = new ModelMap();
            model.addAttribute("attribute", "redirectWithRedirectPrefix");
            if (createOrderResponse.getPayment_links() != null) {

                mv = new ModelAndView("redirect:" + createOrderResponse.getPayment_links(), model);
            }
        }
        return mv;
    }

    public ModelAndView createPaymentTypeMasterModeSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PaymentTypeMaster employeeTypeMaster = new PaymentTypeMaster();
        BindException errors = new BindException(employeeTypeMaster, "employeeTypeMaster");
        bind(request, employeeTypeMaster);

        String paymentMode = request.getParameter("paymentMode");
        String totalPaymentAmount = request.getParameter("status");
        //int formatvalue = employeeTypeMaster.getPaymentMode();
        //employeeTypeMaster.setEmailId(formatvalue.trim());
        //employeeTypeValidator.validate(employeeTypeMaster, errors);
        if (null == paymentMode || paymentMode.equals("")) {

            PaymentMode locationMaster = new PaymentMode();
            List<?> level2 = paymentModeService.read();
            Map<Integer, String> level3 = new HashMap<>();
            for (Object o : level2) {
                locationMaster = (PaymentMode) o;
                level3.put(locationMaster.getId(), locationMaster.getModeOfPayment());
            }
            request.setAttribute("paymentModeMap", level3);

            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv.addAllObjects(errors.getModel());
            mv.getModelMap().put("employeeTypeMaster", employeeTypeMaster);
            mv.setViewName("Payment/paymentTypeMasterModeCreate");

        } else {
            PaymentTypeMaster paymentTypeMaster = new PaymentTypeMaster();

            paymentTypeMaster = paymentTypeMasterService.readById(employeeTypeMaster.getId());

            paymentTypeMaster.setPaymentMode(employeeTypeMaster.getPaymentMode());
            paymentTypeMaster.setStatus(totalPaymentAmount);

            paymentTypeMasterService.update(paymentTypeMaster);

            request.setAttribute("successMessage",
                    "Information : The Information is saved Successfully.");

            mv = createPaymentTypeMasterClick(request, response);
//                 //---- Get data of payment mode
//                PaymentMode locationMaster = new PaymentMode();
//                List<?> level2 = paymentModeService.read();
//                Map<Integer, String> level3 = new HashMap<>();
//                for (Object o : level2) {
//                    locationMaster = (PaymentMode) o;
//                    level3.put(locationMaster.getId(), locationMaster.getModeOfPayment());
//                }
//                request.setAttribute("paymentModeMap", level3);
//                
//                
//                
//                mv.getModelMap().put("employeeTypeMaster", employeeTypeMaster);
//                mv.setViewName("Payment/PaymentTypeMasterCreate");
        }
        return mv;
    }

    public String calculateAmountAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PaymentMode paymentMode = new PaymentMode();
        PaymentTypeMaster paymentTypeMaster = new PaymentTypeMaster();

        float totalPaymentAount = 0;

        String paymentModeId = request.getParameter("paymentModeId");
        String userId = request.getParameter("paymentTypeMasterId");

        if (null != paymentModeId && !paymentModeId.equals("")) {
            Integer paymedModeInt = Integer.valueOf(paymentModeId);
            paymentMode = paymentModeService.readById(paymedModeInt);
            paymentTypeMaster = paymentTypeMasterService.readById(Integer.valueOf(userId));
            if (Integer.valueOf(paymentTypeMaster.getPaymentAmount()) >= Integer.valueOf(paymentMode.getAmountFrom()) && Integer.valueOf(paymentTypeMaster.getPaymentAmount()) < Integer.valueOf(paymentMode.getAmountTo())) {
                totalPaymentAount = Float.valueOf(paymentTypeMaster.getPaymentAmount()) + Float.valueOf(paymentMode.getCharges()) + Float.valueOf(paymentMode.getApplicableTaxes());
            }
        }
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.print("" + totalPaymentAount);
        } finally {
            out.close();
        }
        return paymentModeId;
    }

    public ModelAndView VendorRegistration(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<?> list2 = vendorService.read();
        request.setAttribute("list", list2);
        mv.setViewName("Payment/VendorRegistrationResult");
        return mv;
    }

    public ModelAndView deleteSubmit1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String savingList1[] = request.getParameterValues("checkId");
        for (String v : savingList1) {
            try {
                vendorService.delete(Integer.parseInt(v));
                request.setAttribute("successMessage",
                        "Info : One or more records are deleted successfully.");
            } catch (Exception e) {

            }
        }
        mv = VendorRegistration(request, response);
        return mv;
    }

    public ModelAndView createClick1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        Vendors vendors = new Vendors();
        mv.getModelMap().put("vendors", vendors);
        mv.setViewName("Payment/VendorRegistrationForm");
        return mv;
    }

    public ModelAndView createSubmit1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        Vendors vendors = new Vendors();
        String vendorCode = request.getParameter("vendorId");
        String vendorName = request.getParameter("vendor");
        String gstno = request.getParameter("gstNo");
        String panno = request.getParameter("panNo");
        String emailid = request.getParameter("emailId");
        String phoneno = request.getParameter("phoneNo");
        String mobileno = request.getParameter("mobileNo");
        String address = request.getParameter("address");

        BindException errors = new BindException(vendors, "vendors");
        bind(request, vendors);
        vendorValidator.validate(vendors, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv.addAllObjects(errors.getModel());
            mv.getModelMap().put("vendors", vendors);
            mv.setViewName("Payment/VendorRegistrationForm");

        } else {
            vendors.setVendorId(Integer.parseInt(vendorCode));
            vendors.setVendor(vendorName);
            vendors.setGstNo(gstno);
            vendors.setPanNo(panno);
            vendors.setEmailId(emailid);
            vendors.setPhoneNo(phoneno);
            vendors.setMobileNo(mobileno);
            vendors.setAddress(address);
            vendorService.create(vendors);
            request.setAttribute("successMessage",
                    "Information : The Information is saved Successfully.");
            mv = VendorRegistration(request, response);

        }
        return mv;
    }

    public ModelAndView viewClick1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        int vendorId = Integer.parseInt(request.getParameter("vendorId"));
        Vendors vendors = vendorService.readById(vendorId);

//        String vendorCode = request.getParameter("vendorId");
//        String vendorName = request.getParameter("vendor");
//        String address = request.getParameter("address");
        BindException errors = new BindException(vendors, "vendors");
        bind(request, vendors);
        vendorValidator.validate(vendors, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv.addAllObjects(errors.getModel());

            mv.setViewName("Payment/VendorRegistrationForm");

        } else {
            request.setAttribute("vendorId", vendorId);
            request.setAttribute("vendor", vendors.getVendor());
            request.setAttribute("address", vendors.getAddress());
            request.setAttribute("gstNo", vendors.getGstNo());
            request.setAttribute("mobileNo", vendors.getMobileNo());
            request.setAttribute("phoneNo", vendors.getPhoneNo());
            request.setAttribute("panNo", vendors.getPanNo());
            request.setAttribute("emailId", vendors.getEmailId());

//            vendorService.update(vendors);
//            request.setAttribute("successMessage",
//                    "Information : The Information is saved Successfully.");
//            mv = VendorRegistration(request, response);
            mv.getModelMap().put("vendors", vendors);
            mv.setViewName("Payment/EditVendorRegistrationForm");
        }
        return mv;
    }

    public ModelAndView editSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        int vendorId = Integer.parseInt(request.getParameter("vendorId"));
        Vendors vendors = vendorService.readById(vendorId);
        String vendorCode = request.getParameter("vendorId");
        String vendorName = request.getParameter("vendor");
        String gstno = request.getParameter("gstNo");
        String panno = request.getParameter("panNo");
        String emailid = request.getParameter("emailId");
        String phoneno = request.getParameter("phoneNo");
        String mobileno = request.getParameter("mobileNo");
        String address = request.getParameter("address");

        BindException errors = new BindException(vendors, "vendors");
        bind(request, vendors);
        vendorValidator.validate(vendors, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv.addAllObjects(errors.getModel());
            mv.getModelMap().put("vendors", vendors);
            mv.setViewName("Payment/VendorRegistrationForm");

        } else {
            vendors.setVendorId(Integer.parseInt(vendorCode));
            vendors.setVendor(vendorName);
            vendors.setGstNo(gstno);
            vendors.setPanNo(panno);
            vendors.setEmailId(emailid);
            vendors.setPhoneNo(phoneno);
            vendors.setMobileNo(mobileno);
            vendors.setAddress(address);
            vendorService.update(vendors);
            request.setAttribute("successMessage",
                    "Information : The Information is updated Successfully.");
            mv = VendorRegistration(request, response);

        }
        return mv;
    }
}
