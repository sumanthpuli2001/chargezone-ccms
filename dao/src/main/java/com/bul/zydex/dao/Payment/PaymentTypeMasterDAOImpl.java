/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Payment;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.PaymentTypeMaster;
import java.util.List;

/**
 *
 * @author admin
 */
public class PaymentTypeMasterDAOImpl<T> extends GenericsDAOImpl<T> implements PaymentTypeMasterDAO<T> {

    @Override
    protected Class getDomainClass() {
        return PaymentTypeMaster.class;
    }

    @Override
    public Integer paymentCountByDate(String date) {

        String query = "";

        query += "  "
                + " select a"
                + " FROM PaymentTypeMaster a "
                + " WHERE a.createdDate=" + "'" + date + "'";
        List list = getHibernateTemplate().find(query);
        Integer count = (Integer) list.size();

        return count;

    }

    @Override
    public PaymentTypeMaster getPaymentTypeMasterByOrderId(String orderid) {

        String query = "";

        query += "  "
                + " select a"
                + " FROM PaymentTypeMaster a "
                + " WHERE a.orderid=" + "'" + orderid + "'";

        List list = getHibernateTemplate().find(query);
        PaymentTypeMaster count = null;
        if (list != null && !list.isEmpty()) {

            count = (PaymentTypeMaster) list.get(0);
        }

        return count;
    }

    @Override
    public List<?> getPaymentByVendorCode(String vendorCode) {

        String query = "";

        query += "  "
                + " select a"
                + " FROM PaymentTypeMaster a "
                + " WHERE a.partyCode=" + "'" + vendorCode + "'";

        List<?> list = getHibernateTemplate().find(query);
       

        return list;
    }
    
      @Override
    public List<?> getpaymentSearchByDate(String startDate,String endDate) {

        String query = "";

        query += "  "
                + " select a"
                + " FROM PaymentTypeMaster a "
                +"where (STR_TO_DATE(a.createdDate, '%Y-%m-%d') >= STR_TO_DATE('" + startDate + "', '%Y-%m-%d') AND (STR_TO_DATE(a.createdDate, '%Y-%m-%d') <= STR_TO_DATE('" + endDate + "', '%Y-%m-%d')))";
        List list = getHibernateTemplate().find(query);
       
        return list;
    }
}
