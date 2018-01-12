/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Payroll;

import com.bul.zydex.dao.Payroll.PayrollLoanDetailDAO;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.PayrollLoanDetail;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Hussain
 */
public class PayrollLoanDetailServiceImpl<T> extends GenericsServiceImpl<T> implements PayrollLoanDetailService<T> {

    private PayrollLoanDetailDAO<T> payrollLoanDetailDAO;

    public PayrollLoanDetailDAO<T> getPayrollLoanDetailDAO() {
        return payrollLoanDetailDAO;
    }

    public void setPayrollLoanDetailDAO(PayrollLoanDetailDAO<T> payrollLoanDetailDAO) {
        this.payrollLoanDetailDAO = payrollLoanDetailDAO;
        setGenericsDAO(payrollLoanDetailDAO);
    }

    @Override
    public boolean isExist(T object) {
        return payrollLoanDetailDAO.isExist(object);
    }

//    @Override
//    public List<?> readLoanDetails(int employeeid, String month, String year) {
//        return payrollLoanDetailDAO.readLoanDetails(employeeid, month, year);
//    }
    @Override
    public List<?> readByloanDeatils(int id) {
        return payrollLoanDetailDAO.readByloanDeatils(id);
    }

    @Override
    public List<?> readLoanDetails(int employeeid, String month, String year) {
        return payrollLoanDetailDAO.readLoanDetails(employeeid, month, year);
    }

    @Override
    public List<?> readByloanRemainingAmount(int id, String month, String year) {
        return payrollLoanDetailDAO.readByloanRemainingAmount(id, month, year);
    }

    @Override
    public List<?> getLoanDetails(EmployeeMaster employeeMaster) {
        return payrollLoanDetailDAO.getLoanDetails(employeeMaster);
    }

    @Override
    public List<?> getLoanName(String loanId) {
      return payrollLoanDetailDAO.getLoanName(loanId);
    }

    @Override
    public List<?> readByLoanEdit(int id, int payrollTypeid) {
      return payrollLoanDetailDAO.readByLoanEdit(id, payrollTypeid);
    }

    @Override
    public List<?> readByloanRemainingAmountslip(int id, String month, String year) {
      return payrollLoanDetailDAO.readByloanRemainingAmountslip(id, month, year);
    }

    @Override
    public List<?> readLoanDetailsUpdate(int employeeid, String month, String year) {
       return payrollLoanDetailDAO.readLoanDetailsUpdate(employeeid, month, year);
    }

}
