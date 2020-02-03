/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.payment;

import com.bul.zydex.dao.Payment.PaymentModeDAO;
import com.bul.zydex.dao.Payment.PaymentTypeDAO;
import com.bul.zydex.service.GenericsServiceImpl;

/**
 *
 * @author admin
 */
public class PaymentModeServiceImpl<T> extends GenericsServiceImpl<T> implements PaymentModeService<T>{
    
    private PaymentModeDAO<T> paymentModeDAO;

    public PaymentModeDAO<T> getEmployeeModeDAO() {
        return paymentModeDAO;
    }

    public void setPaymentModeDAO(PaymentModeDAO<T> paymentModeDAO) {
        this.paymentModeDAO = paymentModeDAO;
        setGenericsDAO(paymentModeDAO);
    }
    
}
