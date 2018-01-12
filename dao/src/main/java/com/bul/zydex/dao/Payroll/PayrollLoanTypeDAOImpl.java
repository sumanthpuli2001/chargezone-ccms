/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Payroll;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.PayrollLoanType;
import java.util.List;

/**
 *
 * @author Nishant
 */
public class PayrollLoanTypeDAOImpl<T> extends GenericsDAOImpl<T> implements PayrollLoanTypeDAO<T> {

    @Override
    protected Class getDomainClass() {
        return PayrollLoanType.class;
    }

    @Override
    public List<?> readPayrollLoanName(PayrollLoanType payrollLoanType) {
        String query = "";
        String condition = "";

        query += " Select a.text"
                + " From PayrollLoanType a"
                + " where a.id= " + payrollLoanType.getId();

        return getHibernateTemplate().find(query);
    }

}
