/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Payroll;

import com.bul.zydex.dao.Payroll.EmployeeSalaryProcessDAO;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Irfan <irfanbhindawala@gmail.com>
 */
public class EmployeeSalaryProcessServiceImpl<T> extends GenericsServiceImpl<T> implements EmployeeSalaryProcessService<T> {

    private EmployeeSalaryProcessDAO<T> employeeSalaryProcessDAO;

    public EmployeeSalaryProcessDAO<T> getEmployeeSalaryProcessDAO() {
        return employeeSalaryProcessDAO;
    }

    public void setEmployeeSalaryProcessDAO(EmployeeSalaryProcessDAO<T> employeeSalaryProcessDAO) {
        this.employeeSalaryProcessDAO = employeeSalaryProcessDAO;
        setGenericsDAO(employeeSalaryProcessDAO);
    }

    @Override
    public List<?> readEmployeeForSalary(EmployeeMaster object) {
        return employeeSalaryProcessDAO.readEmployeeForSalary(object);
    }

    @Override
    public List<?> readSal(EmployeeMaster object) {
        return employeeSalaryProcessDAO.readsal(object);
    }

    @Override
    public List<?> readdaywise(int empId, String Date) {
        return employeeSalaryProcessDAO.readdaywise(empId, Date);
    }

    @Override
    public List<?> readEmployeeForFormSixteen(EmployeeMaster object) {
        return employeeSalaryProcessDAO.readEmployeeForFormSixteen(object);
    }

    @Override
    public List<?> readEmployeeForPf(EmployeeMaster object) {
        return employeeSalaryProcessDAO.readEmployeeForPf(object);
    }

    @Override
    public List<?> readEmployeeForPt(EmployeeMaster object) {
        return employeeSalaryProcessDAO.readEmployeeForPt(object);
    }

    @Override
    public List<?> readEmployeeForSlip(EmployeeMaster object) {
        return employeeSalaryProcessDAO.readEmployeeForSlip(object);
    }

    @Override
    public List<?> readEmployeeForSalaryinfo(T object) {
        return employeeSalaryProcessDAO.readEmployeeForSalaryinfo(object);
    }

    @Override
    public List<?> readsalDeduction(EmployeeMaster object) {
        return employeeSalaryProcessDAO.readsalDeduction(object);
    }

    @Override
    public List<?> readEmpSalary(EmployeeMaster employeeMaster) {
        return employeeSalaryProcessDAO.readEmpSalary(employeeMaster);
    }

    @Override
    public List<?> readEmpsal(EmployeeMaster object) {
        return employeeSalaryProcessDAO.readEmpsal(object);
    }

    @Override
    public List<?> readByEmployeeSalaryProcess(T object) {
        return employeeSalaryProcessDAO.readByEmployeeSalaryProcess(object);
    }

    @Override
    public List<?> readEmpSalaryReport(EmployeeMaster employeeMaster) {

        return employeeSalaryProcessDAO.readEmpSalaryReport(employeeMaster);
    }

    @Override
    public List<?> readMasterEmpsal(EmployeeMaster object) {
        return employeeSalaryProcessDAO.readMasterEmpsal(object);
    }

    @Override
    public List<?> readMasterEmpsalarySearch(EmployeeMaster object) {
        return employeeSalaryProcessDAO.readMasterEmpsalarySearch(object);
    }

    @Override
    public List<?> readEmpMasterSalary(EmployeeMaster employeeMaster) {
        return employeeSalaryProcessDAO.readEmpMasterSalary(employeeMaster);
    }

//    @Override
//    public List<?> readCompanyAccountWiseDetail(T object) {
//        return employeeSalaryProcessDAO.readCompanyAccountWiseDetail(object);
//    }
    @Override
    public List<?> readOTAmountAndSalary(T object) {
        return employeeSalaryProcessDAO.readOTAmountAndSalary(object);
    }

    @Override
    public List<?> readAdditionalSalary(T object) {
        return employeeSalaryProcessDAO.readAdditionalSalary(object);
    }

    @Override
    public List<?> readDeductionAmounts(T object) {
        return employeeSalaryProcessDAO.readDeductionAmounts(object);
    }

    @Override
    public List<?> readEmployeePolicyAmounts(T object) {
        return employeeSalaryProcessDAO.readEmployeePolicyAmounts(object);
    }

    @Override
    public List<?> readProfessionalTaxes(EmployeeMaster employeeMaster) {
        return employeeSalaryProcessDAO.readProfessionalTaxes(employeeMaster);
    }

    @Override
    public List<?> readEmployeeForBankStatement(EmployeeMaster object) {
       return employeeSalaryProcessDAO.readEmployeeForBankStatement(object);
    }

    @Override
    public List<?> readEmployeeForEsicStatement(EmployeeMaster object) {
        return employeeSalaryProcessDAO.readEmployeeForEsicStatement(object);
    }

    @Override
    public List<?> readEmployeeForOTStatement(EmployeeMaster object) {
        return employeeSalaryProcessDAO.readEmployeeForOTStatement(object);
    }

    @Override
    public List<?> readOTAmounts(int employeeSalaryProcessId) {
        return employeeSalaryProcessDAO.readOTAmounts(employeeSalaryProcessId);
    }

    @Override
    public List<?> readEmployeeYearlySalary(EmployeeMaster object) {
       return employeeSalaryProcessDAO.readEmployeeYearlySalary(object);
    }

    @Override
    public List<?> readsalyearly(int empID) {
     return employeeSalaryProcessDAO.readsalyearly(empID);
    }

    @Override
    public List<?> readsalDeductionYearly(int empID) {
        return employeeSalaryProcessDAO.readsalDeductionYearly(empID);
    }

    @Override
    public List<?> readEmpSalaryReportyearly(int empID) {
         return employeeSalaryProcessDAO.readEmpSalaryReportyearly(empID);
    }

    @Override
    public List<?> readEmployeebyEmpolyeeSalary(int EmpId,String month,String year) {
       return employeeSalaryProcessDAO.readEmployeebyEmpolyeeSalary(EmpId, month, year);
    }

    @Override
    public List<?> readEmployeeMasterID(int employeeSalaryProcessId) {
      return employeeSalaryProcessDAO.readEmployeeMasterID(employeeSalaryProcessId);
    }

    @Override
    public List<?> readsalSearch(EmployeeMaster object) {
        return employeeSalaryProcessDAO.readsalSearch(object);
    }

    @Override
    public List<?> readsalDeductionSearch(EmployeeMaster object) {
        return employeeSalaryProcessDAO.readsalDeductionSearch(object);
    }

}
