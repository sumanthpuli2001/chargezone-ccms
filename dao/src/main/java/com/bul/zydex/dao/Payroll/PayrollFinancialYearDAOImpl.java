/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Payroll;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.PayrollFinancialYear;

/**
 *
 * @author Irfan <irfanbhindawala@gmail.com>
 */
public class PayrollFinancialYearDAOImpl<T> extends GenericsDAOImpl<T> implements PayrollFinancialYearDAO<T>{

    @Override
    protected Class getDomainClass() {
        return PayrollFinancialYear.class;
    }

//    public PayrollFinancialYear readByFinancialId(int parseInt) {
//        String query = "SELECT a from "
//                + " PayrollFinancialYear a "
//                + " WHERE a.id = "+parseInt;
//        return (PayrollFinancialYear) getHibernateTemplate().find(query);
//    }
    
}
