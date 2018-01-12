/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Payroll;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.PayrollSavingAmount;
import java.util.List;

/**
 *
 * @author Irfan <irfanbhindawala@gmail.com>
 */
public class PayrollSavingAmountDAOImpl<T> extends GenericsDAOImpl<T> implements PayrollSavingAmountDAO<T>{

    @Override
    protected Class getDomainClass() {
        return PayrollSavingAmount.class;
    }

    @Override
    public List<?> readCheckEmployeeSaving(int empId, int yearid) {
        PayrollSavingAmount PayrollSavingAmount=new PayrollSavingAmount();
        String query = "";
        query += "select a.savingType,a.savingTypeAmount  from PayrollSavingAmount a "
                + " left join a.payrollFormSixteenMaster b where "
                + "a.employeeMaster.id  = " + empId
                + " and b.payrollFinancialYear.id  = " + yearid;
                

        List<?> list = getHibernateTemplate().find(query);
        return list;

    }
    
}
