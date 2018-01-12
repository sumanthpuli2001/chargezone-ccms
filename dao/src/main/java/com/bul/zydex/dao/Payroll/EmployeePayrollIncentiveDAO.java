/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Payroll;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.EmployeeIncentiveMonthwise;
import java.util.List;

/**
 *
 * @author Hussain
 */
public interface EmployeePayrollIncentiveDAO<T> extends GenericsDAO<T> {

    public List<?> readByEmployeePayrollIncentive(String month, String Year);

    public List<?> readByEmployeePayrollIncentivelistAmount(EmployeeIncentiveMonthwise employeeIncentiveMonthwise);

    public List<?> readByEmployeePayrollIncentivelistAmountEdit(int id);

    public List<?> readByEmployeePayrollIncentiveReport(String month, String Year);

    public List<?> readByEmployeePayrollIncentiveReportnew(String month, String Year);

}
