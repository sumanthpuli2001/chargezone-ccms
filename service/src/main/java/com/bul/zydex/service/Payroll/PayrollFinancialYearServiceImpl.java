/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Payroll;

import com.bul.zydex.dao.Payroll.PayrollFinancialYearDAO;
import com.bul.zydex.model.PayrollFinancialYear;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Irfan <irfanbhindawala@gmail.com>
 */
public class PayrollFinancialYearServiceImpl<T> extends GenericsServiceImpl<T> implements PayrollFinancialYearService<T>{
     private PayrollFinancialYearDAO<T> payrollFinancialYearDAO;

    public PayrollFinancialYearDAO<T> getPayrollFinancialYearDAO() {
        return payrollFinancialYearDAO;
    }

    public void setPayrollFinancialYearDAO(PayrollFinancialYearDAO<T> payrollFinancialYearDAO) {
        this.payrollFinancialYearDAO = payrollFinancialYearDAO;
         setGenericsDAO(payrollFinancialYearDAO);
    }

    @Override
    public boolean isExist(PayrollFinancialYear payrollFinancialYear) {
      
   PayrollFinancialYear payrollFinancialYear2 = (PayrollFinancialYear) payrollFinancialYear;

        List<?> list = payrollFinancialYearDAO.read();
        Iterator i = list.iterator();
        while (i.hasNext()) {
            payrollFinancialYear = (PayrollFinancialYear) i.next();
            if (payrollFinancialYear.getZydexLocationMaster().getId().intValue() 
                    == payrollFinancialYear2.getZydexLocationMaster().getId().intValue() )
            {
                return true;
            }
        }

        return false;
}
}
