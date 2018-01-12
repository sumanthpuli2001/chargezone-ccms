/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Payroll;

import com.bul.zydex.dao.Payroll.PayrollPtCheckDAO;
import com.bul.zydex.model.PayrollPtCheck;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Irfan <irfanbhindawala@gmail.com>
 */
public class PayrollPtCheckServiceImpl<T> extends GenericsServiceImpl<T> implements PayrollPtCheckService<T>{
     private PayrollPtCheckDAO<T> payrollPtCheckDAO;

    public PayrollPtCheckDAO<T> getPayrollPtCheckDAO() {
        return payrollPtCheckDAO;
    }

    public void setPayrollPtCheckDAO(PayrollPtCheckDAO<T> payrollPtCheckDAO) {
        this.payrollPtCheckDAO = payrollPtCheckDAO;
        setGenericsDAO(payrollPtCheckDAO);
    }

    @Override
    public boolean isExist(PayrollPtCheck payrollPtCheck) {
  boolean flag = false;
        List<?> list = payrollPtCheckDAO.read();
        Iterator i = list.iterator();
        while (i.hasNext()) {
            PayrollPtCheck payrollPtCheck1 = (PayrollPtCheck) i.next();
            if (payrollPtCheck1.getEmployeeTypeMaster().getId().intValue()
                    == payrollPtCheck.getEmployeeTypeMaster().getId() && payrollPtCheck1.getEmployeeSubType().getId().intValue() == payrollPtCheck.getEmployeeSubType().getId().intValue()) {

                flag = true;
                break;
            }

        }

        return flag;
    }

    @Override
    public boolean readForPTCheck(int empTypeId, int empSubTypeId) {
      return payrollPtCheckDAO.readForPTCheck(empTypeId, empSubTypeId);
    }

    @Override
    public boolean isExistPT(int empTypeId, int empSubTypeId) {
        return payrollPtCheckDAO.isExistPT(empTypeId, empSubTypeId);
    }

    @Override
    public int getPTId(int empTypeId, int empSubTypeId) {
       return payrollPtCheckDAO.getPTId(empTypeId, empSubTypeId);
    }

    @Override
    public Boolean getPTCheckValue(int empTypeId, int empSubTypeId) {
       return payrollPtCheckDAO.getPTCheckValue(empTypeId, empSubTypeId);
    }

    
}
