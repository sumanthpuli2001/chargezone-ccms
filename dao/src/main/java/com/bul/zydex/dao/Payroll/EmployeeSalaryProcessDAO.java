/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Payroll;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.EmployeeMaster;
import java.util.List;

/**
 *
 * @author Irfan <irfanbhindawala@gmail.com>
 * @param <T>
 */
public interface EmployeeSalaryProcessDAO<T> extends GenericsDAO<T> {

    public List<?> readEmployeeForSalary(EmployeeMaster object);

    public List<?> readsal(EmployeeMaster object);

    public List<?> readdaywise(int empId, String Date);

    public List<?> readEmployeeForFormSixteen(EmployeeMaster object);

    public List<?> readEmployeeForPf(EmployeeMaster object);

    public List<?> readEmployeeForPt(EmployeeMaster object);

    public List<?> readEmployeeForSlip(EmployeeMaster object);

    public List<?> readEmployeeForSalaryinfo(T object);

    public List<?> readsalDeduction(EmployeeMaster object);

    public List<?> readEmpSalary(EmployeeMaster employeeMaster);

    public List<?> readEmpsal(EmployeeMaster object);

    public List<?> readByEmployeeSalaryProcess(T object);

    public List<?> readEmpSalaryReport(EmployeeMaster employeeMaster);

    public List<?> readMasterEmpsal(EmployeeMaster object);

    public List<?> readMasterEmpsalarySearch(EmployeeMaster object);

    public List<?> readEmpMasterSalary(EmployeeMaster employeeMaster);

//    public List<?> readCompanyAccountWiseDetail(T object);
    public List<?> readOTAmountAndSalary(T object);

    public List<?> readAdditionalSalary(T object);

    public List<?> readDeductionAmounts(T object);

    public List<?> readEmployeePolicyAmounts(T object);

    public List<?> readProfessionalTaxes(EmployeeMaster employeeMaster);

    public List<?> readEmployeeForBankStatement(EmployeeMaster object);

    public List<?> readEmployeeForEsicStatement(EmployeeMaster object);

    public List<?> readEmployeeForOTStatement(EmployeeMaster object);

    public List<?> readOTAmounts(int employeeSalaryProcessId);

    public List<?> readEmployeeYearlySalary(EmployeeMaster object);

    public List<?> readsalyearly(int empID);

    public List<?> readsalDeductionYearly(int empID);

    public List<?> readEmpSalaryReportyearly(int empID);

    public List<?> readEmployeebyEmpolyeeSalary(int EmpId, String month, String year);

    public List<?> readEmployeeMasterID(int employeeSalaryProcessId);

    public List<?> readsalSearch(EmployeeMaster object);

    public List<?> readsalDeductionSearch(EmployeeMaster object);

    public List<?> readEmployeeForPfGov(EmployeeMaster object);

}
