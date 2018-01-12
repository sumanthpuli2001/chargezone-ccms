/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Payroll;

import com.bul.zydex.dao.Payroll.PayrollLoanTypeDAO;
import com.bul.zydex.model.PayrollLoanType;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Nishant
 */
public class PayrollLoanTypeServiceImpl<T> extends GenericsServiceImpl<T> implements PayrollLoanTypeService<T> {

    private PayrollLoanTypeDAO<T> payrollLoanTypeDAO;

    public PayrollLoanTypeDAO<T> getPayrollLoanTypeDAO() {
        return payrollLoanTypeDAO;
    }

    public void setPayrollLoanTypeDAO(PayrollLoanTypeDAO<T> payrollLoanTypeDAO) {
        this.payrollLoanTypeDAO = payrollLoanTypeDAO;
        setGenericsDAO(payrollLoanTypeDAO);
    }

    @Override
    public boolean isExist(PayrollLoanType payrollLoanType) {

        PayrollLoanType payrollLoanType2 = (PayrollLoanType) payrollLoanType;

        List<?> list = payrollLoanTypeDAO.read();
        Iterator i = list.iterator();
        while (i.hasNext()) {
            payrollLoanType = (PayrollLoanType) i.next();
            if (payrollLoanType.getText().equalsIgnoreCase(payrollLoanType2.getText())) {
                return true;
            }
        }

        return false;
    }

    @Override
    public List<?> readPayrollLoanName(PayrollLoanType payrollLoanType) {
        return payrollLoanTypeDAO.readPayrollLoanName(payrollLoanType);
    }
}
