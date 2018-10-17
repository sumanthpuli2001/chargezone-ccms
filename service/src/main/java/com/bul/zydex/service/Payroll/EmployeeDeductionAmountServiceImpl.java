/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Payroll;

import com.bul.zydex.dao.Payroll.EmployeeDeductionAmountDAO;
import com.bul.zydex.model.EmployeeSalaryProcess;
import com.bul.zydex.model.PayrollFinancialYear;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Irfan <irfanbhindawala@gmail.com>
 */
public class EmployeeDeductionAmountServiceImpl<T> extends GenericsServiceImpl<T> implements EmployeeDeductionAmountService<T> {

    private EmployeeDeductionAmountDAO<T> employeeDeductionAmountDAO;

    public EmployeeDeductionAmountDAO<T> getEmployeeDeductionAmountDAO() {
        return employeeDeductionAmountDAO;
    }

    public void setEmployeeDeductionAmountDAO(EmployeeDeductionAmountDAO<T> employeeDeductionAmountDAO) {
        this.employeeDeductionAmountDAO = employeeDeductionAmountDAO;
        setGenericsDAO(employeeDeductionAmountDAO);
    }

    @Override
    public List<?> readDeductionAmount(int employeeSalaryProcessId) {
        return employeeDeductionAmountDAO.readDeductionAmount(employeeSalaryProcessId);
    }

    @Override
    public List<?> readCheckDeductionAmount(int empId, PayrollFinancialYear payrollFinancialYear) {
        return employeeDeductionAmountDAO.readCheckDeductionAmount(empId, payrollFinancialYear);
    }

    @Override
    public List<?> readEmployeeForSalaryDeductioninfo(EmployeeSalaryProcess employeeSalaryProcess) {
        return employeeDeductionAmountDAO.readEmployeeForSalaryDeductioninfo(employeeSalaryProcess);
    }

    @Override
    public List<?> readEmployeeForSalaryAddDeductioninfo(EmployeeSalaryProcess employeeSalaryProcess) {
        return employeeDeductionAmountDAO.readEmployeeForSalaryAddDeductioninfo(employeeSalaryProcess);
    }

    @Override
    public List<?> readCheckDeductionPtAmount(int empId, PayrollFinancialYear payrollFinancialYear) {
        return employeeDeductionAmountDAO.readCheckDeductionPtAmount(empId, payrollFinancialYear);
    }

    @Override
    public List<?> readByDedutionSalaryAmount(EmployeeSalaryProcess employeeSalaryProcess) {
        return employeeDeductionAmountDAO.readByDedutionSalaryAmount(employeeSalaryProcess);
    }

    @Override
    public List<?> readEmployeeForloanEditinfo(EmployeeSalaryProcess employeeSalaryProcess) {
        return employeeDeductionAmountDAO.readEmployeeForloanEditinfo(employeeSalaryProcess);
    }

    @Override
    public void delete1(int empSalaryProcessid, String payrollLoanType) {
        employeeDeductionAmountDAO.delete1(empSalaryProcessid, payrollLoanType);
    }

    @Override
    public List<?> readEmployeeloandelete(int empSalaryProcessid, String payrollLoanType) {
        return employeeDeductionAmountDAO.readEmployeeloandelete(empSalaryProcessid, payrollLoanType);
    }

    @Override
    public List<?> readEmployeeForSalaryDeductioninfoSearch(EmployeeSalaryProcess employeeSalaryProcess) {
        return employeeDeductionAmountDAO.readEmployeeForSalaryDeductioninfoSearch(employeeSalaryProcess);
    }

    @Override
    public List<?> readByedaId(int edaId, String eftDate, String relivDate) {
        return employeeDeductionAmountDAO.readByedaId(edaId, eftDate, relivDate);
    }

    @Override
    public List<?> readEmployeeTdsAmount(int employeeMasterID, String startDate, String endate) {
        return employeeDeductionAmountDAO.readEmployeeTdsAmount(employeeMasterID, startDate, endate);
    }

    @Override
    public List<?> fetchsalary(int edaId, String eftDate, String relivDate) {
          return employeeDeductionAmountDAO.fetchsalary(edaId, eftDate, relivDate);
    }

    @Override
    public List<?> readEmployeeTdsAmountWithMonth(int employeeMasterID, String startDate, String endate) {
        return employeeDeductionAmountDAO.readEmployeeTdsAmountWithMonth(employeeMasterID, startDate, endate);
    }

    @Override
    public List<?> readadditionalAllownaceName(String month, String year) {
      return employeeDeductionAmountDAO.readadditionalAllownaceName(month, year);
    }

    @Override
    public List<?> readadditionalAMountSalaryRegister(String allowanceName, String month, String year) {
      return employeeDeductionAmountDAO.readadditionalAMountSalaryRegister(allowanceName, month, year);
    }

}
