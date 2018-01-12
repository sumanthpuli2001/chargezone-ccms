/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Payroll;


import com.bul.zydex.dao.Payroll.PayrollSalaryTypeDAO;
import com.bul.zydex.model.PayrollSalaryType;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Nishant
 */
public class PayrollSalaryTypeServiceImpl<T> extends GenericsServiceImpl<T> implements PayrollSalaryTypeService<T> {
   private PayrollSalaryTypeDAO<T> payrollSalaryTypeDAO;

    public PayrollSalaryTypeDAO<T> getPayrollSalaryTypeDAO() {
        return payrollSalaryTypeDAO;
    }

    public void setPayrollSalaryTypeDAO(PayrollSalaryTypeDAO<T> payrollSalaryTypeDAO) {
        this.payrollSalaryTypeDAO = payrollSalaryTypeDAO;
        setGenericsDAO(payrollSalaryTypeDAO);
    }

    @Override
    public boolean isExist(PayrollSalaryType payrollSalaryType) {
      PayrollSalaryType payrollSalaryType2 = (PayrollSalaryType) payrollSalaryType;

        List<?> list = payrollSalaryTypeDAO.read();
        Iterator i = list.iterator();
        while (i.hasNext()) {
            payrollSalaryType = (PayrollSalaryType) i.next();
            if (payrollSalaryType.getText().equalsIgnoreCase(payrollSalaryType2.getText())) {
                return true;
            }
        }

        return false;
}
}
