/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Payroll;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.PayrollFormSixteenMaster;
import java.util.List;

/**
 *
 * @author Irfan <irfanbhindawala@gmail.com>
 */
public class PayrollFormSixteenMasterDAOImpl<T> extends GenericsDAOImpl<T> implements PayrollFormSixteenMasterDAO<T>{

    @Override
    protected Class getDomainClass() {
        return PayrollFormSixteenMaster.class;
    }

    @Override
    public List<?> payRollSearchIdCheck(T object) {
      PayrollFormSixteenMaster payrollFormSixteenMaster = (PayrollFormSixteenMaster) object;

        String query = "";
        query += "select a from PayrollFormSixteenMaster a where "
                + "a.payrollFinancialYear.id  = " + payrollFormSixteenMaster.getPayrollFinancialYear().getId()
                + " and a.zydexLocationMaster.id  = " + payrollFormSixteenMaster.getZydexLocationMaster().getId();
                

        List<?> list = getHibernateTemplate().find(query);
        return list;

    }

    @Override
    public List<?> read( PayrollFormSixteenMaster  PayrollFormSixteenMaster) {
       PayrollFormSixteenMaster payrollFormSixteenMaster = (PayrollFormSixteenMaster) PayrollFormSixteenMaster;

        String query = "";
        query += " from PayrollFormSixteenMaster ";
       
              
                

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }
    
}
