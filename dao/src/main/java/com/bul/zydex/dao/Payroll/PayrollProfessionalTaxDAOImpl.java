/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Payroll;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.PayrollProfessionalTax;
import java.util.List;

/**
 *
 * @author AJAY <ajay@bulwarks.com>
 */
public class PayrollProfessionalTaxDAOImpl<T> extends GenericsDAOImpl<T> implements PayrollProfessionalTaxDAO<T> {

    @Override
    protected Class getDomainClass() {
        return PayrollProfessionalTax.class;
    }

    @Override
    public List<?> readPT(double netSalary) {
        String query = "";
        query += "Select a.amount"
                + " FROM PayrollProfessionalTax a "
                + " WHERE CAST(a.salaryFrom, Double) >=  " + netSalary
                + " AND CAST(a.salaryTo, Double) <= " + netSalary;

        return getHibernateTemplate().find(query);
    }
    
        @Override
    public List<?> readAmount(String basicSalary) {
        String query = "";
        query += "Select ppt.amount"
                + " FROM PayrollProfessionalTax ppt "
                + " WHERE CAST(ppt.salaryFrom, Double) >=  " + basicSalary
                + " AND CAST(ppt.salaryTo, Double) <= " + basicSalary;

        return getHibernateTemplate().find(query);
    }

    

}
