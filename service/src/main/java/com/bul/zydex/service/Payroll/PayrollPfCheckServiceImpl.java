/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Payroll;

import com.bul.zydex.dao.Payroll.PayrollPfCheckDAO;
import com.bul.zydex.model.PayrollPfCheck;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Nishant
 */
public class PayrollPfCheckServiceImpl<T> extends GenericsServiceImpl<T> implements PayrollPfCheckService<T> {

    private PayrollPfCheckDAO<T> payrollPfCheckDAO;

    public PayrollPfCheckDAO<T> getPayrollPfCheckDAO() {
        return payrollPfCheckDAO;
    }

    public void setPayrollPfCheckDAO(PayrollPfCheckDAO<T> payrollPfCheckDAO) {
        this.payrollPfCheckDAO = payrollPfCheckDAO;
        setGenericsDAO(payrollPfCheckDAO);
    }

    @Override
    public boolean isExist(PayrollPfCheck payrollPfCheck) {

        boolean flag = false;
        List<?> list = payrollPfCheckDAO.read();
        Iterator i = list.iterator();
        while (i.hasNext()) {
            PayrollPfCheck payrollPfCheck1 = (PayrollPfCheck) i.next();
            if (payrollPfCheck1.getEmployeeTypeMaster().getId().intValue()
                    == payrollPfCheck.getEmployeeTypeMaster().getId() && payrollPfCheck1.getEmployeeSubType().getId().intValue() == payrollPfCheck.getEmployeeSubType().getId().intValue()) {

                flag = true;
                break;
            }

        }

        return flag;
    }

    @Override
    public boolean readForPfCheck(int empTypeId, int empSubTypeId) {
        return payrollPfCheckDAO.readForPfCheck(empTypeId, empSubTypeId);
    }

    @Override
    public boolean isExistPF(int empTypeId, int empSubTypeId) {
        return payrollPfCheckDAO.isExistPF(empTypeId, empSubTypeId);
    }

    @Override
    public int getPFId(int empTypeId, int empSubTypeId) {
      return payrollPfCheckDAO.getPFId(empTypeId, empSubTypeId);
    }

    @Override
    public Boolean getPFCheckValue(int empTypeId, int empSubTypeId) {
        return payrollPfCheckDAO.getPFCheckValue(empTypeId, empSubTypeId);
    }

}
