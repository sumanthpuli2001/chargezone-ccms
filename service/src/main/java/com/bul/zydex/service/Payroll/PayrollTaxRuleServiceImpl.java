/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Payroll;

import com.bul.zydex.dao.Payroll.PayrollTaxRuleDAO;
import com.bul.zydex.model.PayrollTaxRule;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author AJAY <ajay@bulwarks.com>
 */
public class PayrollTaxRuleServiceImpl<T> extends GenericsServiceImpl<T> implements PayrollTaxRuleService<T> {

    private PayrollTaxRuleDAO<T> payrollTaxRuleDAO;

    public PayrollTaxRuleDAO<T> getPayrollTaxRuleDAO() {
        return payrollTaxRuleDAO;
    }

    public void setPayrollTaxRuleDAO(PayrollTaxRuleDAO<T> payrollTaxRuleDAO) {
        this.payrollTaxRuleDAO = payrollTaxRuleDAO;
        setGenericsDAO(payrollTaxRuleDAO);
    }

    @Override
    public boolean isExist(PayrollTaxRule payrollTaxRule) { 
        boolean flag = false;
        List<?> list = payrollTaxRuleDAO.read();
        Iterator i = list.iterator();
        while (i.hasNext()) {
            PayrollTaxRule payrollTaxRule1 = (PayrollTaxRule) i.next();
            if (payrollTaxRule1.getZydexLocationMaster().getId().intValue()
                    == payrollTaxRule.getZydexLocationMaster().getId().intValue() && payrollTaxRule1.getGender()
                    == payrollTaxRule.getGender()) {

                flag = true;
                break;
            }

        }

        return flag;
    }

}
