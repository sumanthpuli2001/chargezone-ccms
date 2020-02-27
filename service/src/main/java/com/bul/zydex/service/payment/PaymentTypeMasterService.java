/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.payment;

import com.bul.zydex.model.PaymentTypeMaster;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author admin
 */
public interface PaymentTypeMasterService<T> extends GenericsService<T> {

    public Integer paymentCountByDate(String date);

    public PaymentTypeMaster getPaymentTypeMasterByOrderId(String orderid);

    public List<?> getPaymentByVendorCode(String vendorCode);
    
    public List<?> getpaymentSearchByDate(String startDate,String endDate);
}
