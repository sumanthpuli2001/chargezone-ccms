/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.payment;

import com.bul.zydex.dao.Payment.PaymentTypeDAO;
import com.bul.zydex.dao.Payment.PaymentTypeMasterDAO;
import com.bul.zydex.model.PaymentTypeMaster;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class PaymentTypeMasterServiceImpl<T> extends GenericsServiceImpl<T> implements PaymentTypeMasterService<T> {

    private PaymentTypeMasterDAO<T> paymentTypeMasterDAO;

    public PaymentTypeMasterDAO<T> getPaymentTypeMasterDAO() {
        return paymentTypeMasterDAO;
    }

    public void setPaymentTypeMasterDAO(PaymentTypeMasterDAO<T> paymentTypeMasterDAO) {
        this.paymentTypeMasterDAO = paymentTypeMasterDAO;
        setGenericsDAO(paymentTypeMasterDAO);
    }

    @Override
    public Integer paymentCountByDate(String date) {
        return paymentTypeMasterDAO.paymentCountByDate(date);
    }

    @Override
    public PaymentTypeMaster getPaymentTypeMasterByOrderId(String orderid) {
        return paymentTypeMasterDAO.getPaymentTypeMasterByOrderId(orderid);
    }

    @Override
    public List<?> getPaymentByVendorCode(String vendorCode) {
        return paymentTypeMasterDAO.getPaymentByVendorCode(vendorCode);
    }

    @Override
    public List<?> getpaymentSearchByDate(String startDate,String endDate) {
       return paymentTypeMasterDAO.getpaymentSearchByDate(startDate,endDate);
    }
}
