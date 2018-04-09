/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.EmployeeCtcDetailSalary;

import com.bul.zydex.dao.EmployeeCtcDetailSalary.EmployeeCtcDetailSalaryDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Hussain
 */
public class EmployeeCtcDetailSalaryServiceImpl<T> extends GenericsServiceImpl<T> implements EmployeeCtcDetailSalaryService<T> {

    private EmployeeCtcDetailSalaryDAO<T> employeeCtcDetailSalaryDAO;

    public EmployeeCtcDetailSalaryDAO<T> getEmployeeCtcDetailSalaryDAO() {
        return employeeCtcDetailSalaryDAO;
    }

    public void setEmployeeCtcDetailSalaryDAO(EmployeeCtcDetailSalaryDAO<T> employeeCtcDetailSalaryDAO) {
        this.employeeCtcDetailSalaryDAO = employeeCtcDetailSalaryDAO;
        setGenericsDAO(employeeCtcDetailSalaryDAO);
    }

    @Override
    public List<?> readEmployeeCtcDetailSalary(int employeeid, String month, String year,int ctcid) {
        return employeeCtcDetailSalaryDAO.readEmployeeCtcDetailSalary(employeeid, month, year,ctcid);
    }

    @Override
    public List<?> readByEmployeCtcReport(int employeeid, String month, String year) {
        return employeeCtcDetailSalaryDAO.readByEmployeCtcReport(employeeid, month, year);
    }

    

}
