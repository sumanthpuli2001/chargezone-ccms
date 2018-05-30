/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Payroll;

import com.bul.zydex.dao.Payroll.PayrollPfRecordDAO;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.EmployeeSalaryProcess;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Hussain
 */
public class PayrollPfRecordServiceImpl<T> extends GenericsServiceImpl<T> implements PayrollPfRecordService<T> {
  private PayrollPfRecordDAO<T> payrollPfRecordDAO;   

    public PayrollPfRecordDAO<T> getPayrollPfRecordDAO() {
        return payrollPfRecordDAO;
    }

    public void setPayrollPfRecordDAO(PayrollPfRecordDAO<T> payrollPfRecordDAO) {
        this.payrollPfRecordDAO = payrollPfRecordDAO;
        setGenericsDAO(payrollPfRecordDAO);
    }

    @Override
    public List<?> readByEmployePfReport(EmployeeSalaryProcess employeeSalaryProcess) {
       return payrollPfRecordDAO.readByEmployePfReport(employeeSalaryProcess);
    }

    @Override
    public List<?> readEmployeePayrolllPfRecord(int employeeSalaryProcessId) {
      return payrollPfRecordDAO.readEmployeePayrolllPfRecord(employeeSalaryProcessId);
    }

    @Override
    public List<?> readEmployeeForPf(EmployeeMaster object) {
      return payrollPfRecordDAO.readEmployeeForPf(object);
    }
  
}
