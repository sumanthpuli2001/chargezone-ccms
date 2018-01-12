/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Payroll;

import com.bul.zydex.dao.Payroll.PayrollSavingTypeDAO;
import com.bul.zydex.model.PayrollSavingType;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Nishant
 */
public class PayrollSavingTypeServiceImpl<T> extends GenericsServiceImpl<T> implements PayrollSavingTypeService<T> {

    private PayrollSavingTypeDAO<T> payrollSavingTypeDAO;

    public PayrollSavingTypeDAO<T> getPayrollSavingTypeDAO() {
        return payrollSavingTypeDAO;
    }

    public void setPayrollSavingTypeDAO(PayrollSavingTypeDAO<T> payrollSavingTypeDAO) {
        this.payrollSavingTypeDAO = payrollSavingTypeDAO;
        setGenericsDAO(payrollSavingTypeDAO);
    }

    @Override
    public boolean isExist(PayrollSavingType payrollSavingType) {
         
        PayrollSavingType payrollSavingType2 = (PayrollSavingType) payrollSavingType;

        List<?> list = payrollSavingTypeDAO.read();
        Iterator i = list.iterator();
        while (i.hasNext()) {
            payrollSavingType = (PayrollSavingType) i.next();
            if (payrollSavingType.getText().equalsIgnoreCase(payrollSavingType2.getText())) {
                return true;
            }
        }

        return false;
}
}
