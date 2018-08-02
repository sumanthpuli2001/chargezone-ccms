/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Payroll;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.EmployeeDeductionAmount;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.EmployeeSalaryProcess;
import com.bul.zydex.model.PayrollFinancialYear;
import java.util.List;

/**
 *
 * @author Irfan <irfanbhindawala@gmail.com>
 */
public interface EmployeeDeductionAmountDAO<T> extends GenericsDAO<T> {

    public List<?> readDeductionAmount(int employeeSalaryProcessId);

    public List<?> readCheckDeductionAmount(int empId, PayrollFinancialYear payrollFinancialYear);

    public List<?> readEmployeeForSalaryDeductioninfo(EmployeeSalaryProcess employeeSalaryProcess);

    public List<?> readEmployeeForSalaryAddDeductioninfo(EmployeeSalaryProcess employeeSalaryProcess);

    public List<?> readCheckDeductionPtAmount(int empId, PayrollFinancialYear payrollFinancialYear);

    public List<?> readByDedutionSalaryAmount(EmployeeSalaryProcess employeeSalaryProcess);

    public List<?> readEmployeeForloanEditinfo(EmployeeSalaryProcess employeeSalaryProcess);

    public void delete1(int empSalaryProcessid, String payrollLoanType);

    public List<?> readEmployeeloandelete(int empSalaryProcessid, String payrollLoanType);

    public List<?> readEmployeeForSalaryDeductioninfoSearch(EmployeeSalaryProcess employeeSalaryProcess);
    
    public List<?> readByedaId(int edaId, String eftDate, String relivDate);

    public List<?> readEmployeeTdsAmount(int employeeMasterID, String startDate, String endate);
    
    public List<?> readEmployeeTdsAmountWithMonth(int employeeMasterID, String startDate, String endate);
    
    public List<?> fetchsalary(int edaId, String eftDate, String relivDate);
}
