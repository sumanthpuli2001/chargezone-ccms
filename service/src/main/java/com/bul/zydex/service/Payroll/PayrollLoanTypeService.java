/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Payroll;

import com.bul.zydex.model.PayrollLoanType;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Nishant
 */
public interface PayrollLoanTypeService<T> extends GenericsService<T> {

    public boolean isExist(PayrollLoanType payrollLoanType);

    public List<?> readPayrollLoanName(PayrollLoanType payrollLoanType);
}
