/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Payroll;

import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.PayrollLoanDetail;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Hussain
 */
public interface PayrollLoanDetailService<T> extends GenericsService<T> {

    public boolean isExist(T object);

    public List<?> readLoanDetails(int employeeid, String month, String year);

    public List<?> readByloanDeatils(int id);

    public List<?> readByloanRemainingAmount(int id, String month, String year);

    public List<?> getLoanDetails(EmployeeMaster employeeMaster);

    public List<?> getLoanName(String loanId);

    public List<?> readByLoanEdit(int id, int payrollTypeid);

    public List<?> readByloanRemainingAmountslip(int id, String month, String year);

    public List<?> readLoanDetailsUpdate(int employeeid, String month, String year);
}
