/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Payment;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.dao.emp.EmployeeTypeDAO;
import com.bul.zydex.model.EmployeeTypeMaster;
import com.bul.zydex.model.TypeOfPayment;

/**
 *
 * @author admin
 */
public class PaymentTypeDAOImpl<T> extends GenericsDAOImpl<T> implements PaymentTypeDAO<T> {

    @Override
    protected Class getDomainClass() {
        return TypeOfPayment.class;
    }
    
}
