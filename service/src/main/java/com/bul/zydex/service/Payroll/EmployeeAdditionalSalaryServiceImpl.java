/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Payroll;

import com.bul.zydex.dao.Payroll.EmployeeAdditionalSalaryDAO;
import com.bul.zydex.model.EmployeeSalaryProcess;
import com.bul.zydex.model.PayrollFinancialYear;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Irfan <irfanbhindawala@gmail.com>
 */
public class EmployeeAdditionalSalaryServiceImpl<T> extends GenericsServiceImpl<T> implements EmployeeAdditionalSalaryService<T> {

    private EmployeeAdditionalSalaryDAO<T> employeeAdditionalSalaryDAO;

    public EmployeeAdditionalSalaryDAO<T> getEmployeeAdditionalSalaryDAO() {
        return employeeAdditionalSalaryDAO;
    }

    public void setEmployeeAdditionalSalaryDAO(EmployeeAdditionalSalaryDAO<T> employeeAdditionalSalaryDAO) {
        this.employeeAdditionalSalaryDAO = employeeAdditionalSalaryDAO;
        setGenericsDAO(employeeAdditionalSalaryDAO);
    }

    @Override
    public List<?> readAdditionalAmount(int employeeSalaryProcessId) {
        return employeeAdditionalSalaryDAO.readAdditionalAmount(employeeSalaryProcessId);
    }

    @Override
    public List<?> readEmployeeForSalaryAdditionalinfo(EmployeeSalaryProcess employeeSalaryProcess) {
        return employeeAdditionalSalaryDAO.readEmployeeForSalaryAdditionalinfo(employeeSalaryProcess);
    }

    @Override
    public List<?> readEmployeeForSalaryAddAdditionalinfo(EmployeeSalaryProcess employeeSalaryProcess) {
        return employeeAdditionalSalaryDAO.readEmployeeForSalaryAddAdditionalinfo(employeeSalaryProcess);
    }

    @Override
    public List<?> readCheckAdditionalAmount(int empId, PayrollFinancialYear payrollFinancialYear) {
        return employeeAdditionalSalaryDAO.readCheckAdditionalAmount(empId, payrollFinancialYear);
    }

    @Override
    public List<?> readByAdditionalSalaryAmount(EmployeeSalaryProcess employeeSalaryProcess) {
        return employeeAdditionalSalaryDAO.readByAdditionalSalaryAmount(employeeSalaryProcess);
    }

    @Override
    public List<?> readNotOTamountAdditionalAmount(int employeeSalaryProcessId) {
        return employeeAdditionalSalaryDAO.readNotOTamountAdditionalAmount(employeeSalaryProcessId);
    }

    @Override
    public List<?> readEmployeeForSalaryAdditionalinfoSearch(EmployeeSalaryProcess employeeSalaryProcess) {
        return employeeAdditionalSalaryDAO.readEmployeeForSalaryAdditionalinfoSearch(employeeSalaryProcess);
    }

    @Override
    public List<?> readEmployeeAllowanceGrossTotalTaxable(int EmpSalaryProcessId) {
        return employeeAdditionalSalaryDAO.readEmployeeAllowanceGrossTotalTaxable(EmpSalaryProcessId);
    }

    @Override
    public List<?> readNotOTamountAdditionalAmountSPC(int employeeSalaryProcessId) {
        return employeeAdditionalSalaryDAO.readNotOTamountAdditionalAmountSPC(employeeSalaryProcessId);
    }

    @Override
    public List<?> readadditionalAllownaceName(String month, String year) {
        return employeeAdditionalSalaryDAO.readadditionalAllownaceName(month, year);
    }

    @Override
    public List<?> readadditionalAMountSalaryRegister(String allowanceName, String month, String year) {
        return employeeAdditionalSalaryDAO.readadditionalAMountSalaryRegister(allowanceName, month, year);
    }

}
