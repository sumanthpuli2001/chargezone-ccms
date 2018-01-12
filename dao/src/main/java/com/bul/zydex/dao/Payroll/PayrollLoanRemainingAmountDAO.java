/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Payroll;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.EmployeeSalaryProcess;
import java.util.List;

/**
 *
 * @author Hussain
 */
public interface PayrollLoanRemainingAmountDAO<T> extends GenericsDAO<T> {

    public List<?> readByLoanReaminingAmount(EmployeeSalaryProcess employeeSalaryProcess);

    public List<?> readByloanRemainingAmountslip(int id, String month, String year);

    public List<?> getPayrollLoanDetails(EmployeeMaster employeeMaster);

    public void delete1(T object);
    
     public List<?> readByloanDepartment(String month, String year);

}
