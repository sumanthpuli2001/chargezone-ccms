/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Payroll;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.EmployeeSalaryProcess;
import com.bul.zydex.model.PayrollFinancialYear;
import java.util.List;

/**
 *
 * @author Irfan <irfanbhindawala@gmail.com>
 */
public interface EmployeeAdditionalSalaryDAO<T> extends GenericsDAO<T> {

    public List<?> readAdditionalAmount(int employeeSalaryProcessId);

    public List<?> readEmployeeForSalaryAdditionalinfo(EmployeeSalaryProcess employeeSalaryProcess);

    public List<?> readEmployeeForSalaryAddAdditionalinfo(EmployeeSalaryProcess employeeSalaryProcess);

    public List<?> readCheckAdditionalAmount(int empId, PayrollFinancialYear payrollFinancialYear);

    public List<?> readByAdditionalSalaryAmount(EmployeeSalaryProcess employeeSalaryProcess);

    public List<?> readNotOTamountAdditionalAmount(int employeeSalaryProcessId);

    public List<?> readEmployeeForSalaryAdditionalinfoSearch(EmployeeSalaryProcess employeeSalaryProcess);

    public List<?> readEmployeeAllowanceGrossTotalTaxable(int EmpSalaryProcessId);

    public List<?> readNotOTamountAdditionalAmountSPC(int employeeSalaryProcessId);

    public List<?> readadditionalAllownaceName(String month, String year);

    public List<?> readadditionalAMountSalaryRegister(String allowanceName, String month, String year);

}
