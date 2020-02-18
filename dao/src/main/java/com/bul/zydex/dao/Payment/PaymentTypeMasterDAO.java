/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Payment;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.PaymentTypeMaster;

/**
 *
 * @author admin
 */
public interface PaymentTypeMasterDAO<T> extends GenericsDAO<T>{
    
     public Integer paymentCountByDate(String date);

    public PaymentTypeMaster getPaymentTypeMasterByOrderId(String orderid);
}
