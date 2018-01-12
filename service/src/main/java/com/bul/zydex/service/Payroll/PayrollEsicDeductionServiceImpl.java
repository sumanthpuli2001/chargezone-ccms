/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Payroll;

import com.bul.zydex.dao.Payroll.PayrollEsicDeductionDAO;
import com.bul.zydex.model.EmployeeSalaryProcess;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Hussain
 */
public class PayrollEsicDeductionServiceImpl<T> extends GenericsServiceImpl<T> implements PayrollEsicDeductionService<T> {

    private PayrollEsicDeductionDAO<T> payrollEsicDeductionDAO;

    public PayrollEsicDeductionDAO<T> getPayrollEsicDeductionDAO() {
        return payrollEsicDeductionDAO;
    }

    public void setPayrollEsicDeductionDAO(PayrollEsicDeductionDAO<T> payrollEsicDeductionDAO) {
        this.payrollEsicDeductionDAO = payrollEsicDeductionDAO;
        setGenericsDAO(payrollEsicDeductionDAO);
    }

    @Override
    public List<?> readByEmployeEsicReport(EmployeeSalaryProcess employeeSalaryProcess) {
        return payrollEsicDeductionDAO.readByEmployeEsicReport(employeeSalaryProcess);
    }

}
