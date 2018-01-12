/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Payroll;

import com.bul.zydex.model.EmployeeIncentiveMonthwise;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Hussain
 */
public interface EmployeePayrollIncentiveService<T> extends GenericsService<T> {

    public List<?> readByEmployeePayrollIncentive(String month, String Year);

    public List<?> readByEmployeePayrollIncentivelistAmount(EmployeeIncentiveMonthwise employeeIncentiveMonthwise);

    public List<?> readByEmployeePayrollIncentivelistAmountEdit(int id);

    public List<?> readByEmployeePayrollIncentiveReport(String month, String Year);

    public List<?> readByEmployeePayrollIncentiveReportnew(String month, String Year);
}
