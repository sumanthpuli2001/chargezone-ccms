/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Payment;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.PaymentTypeMaster;
import com.bul.zydex.model.TypeOfPayment;
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
    public Integer paymentCountByDate() {
     //   return 0;
           List list = getHibernateTemplate().find(
                "select count(*) from " + domainClass.getName() + " x ");
        Integer count = (Integer) list.get(0);
        
        return count.intValue();
//        return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from " + domainClass.getName()));
    }
        
    }


