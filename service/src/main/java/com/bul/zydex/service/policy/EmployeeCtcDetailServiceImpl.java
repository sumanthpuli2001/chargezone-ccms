/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.policy;

import com.bul.zydex.dao.policy.EmployeeCtcDetailDAO;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Hussain
 */
public class EmployeeCtcDetailServiceImpl<T> extends GenericsServiceImpl<T> implements EmployeeCtcDetailService<T> {

    private EmployeeCtcDetailDAO<T> employeeCtcDetailDAO;

    public EmployeeCtcDetailDAO<T> getEmployeeCtcDetailDAO() {
        return employeeCtcDetailDAO;
    }

    public void setEmployeeCtcDetailDAO(EmployeeCtcDetailDAO<T> employeeCtcDetailDAO) {
        this.employeeCtcDetailDAO = employeeCtcDetailDAO;
        setGenericsDAO(employeeCtcDetailDAO);
    }

    @Override
    public List<?> fetchctcData(int empId) {
        return employeeCtcDetailDAO.fetchctcData(empId);
    }

    @Override
    public List<?> readctc(int employeeid) {
        return employeeCtcDetailDAO.readctc(employeeid);
    }

    @Override
    public List<?> readEmployeeCtcDetail(int employeeid) {
        return employeeCtcDetailDAO.readEmployeeCtcDetail(employeeid);
    }

    @Override
    public List<?> readByEmployeCtcReport(int employeeid, String month, String year) {
        return employeeCtcDetailDAO.readByEmployeCtcReport(employeeid, month, year);
    }

    @Override
    public List<?> empid(int employeeid) {
        return employeeCtcDetailDAO.empid(employeeid);
    }

    @Override
    public List<?> CtcDetailempid(int employeeid) {
         return employeeCtcDetailDAO.CtcDetailempid(employeeid);
    }

    @Override
    public List<?> readctcRegistration(int employeeid) {
       return employeeCtcDetailDAO.readctcRegistration(employeeid);
    }

    @Override
    public List<?> CtcDetailempidMasterSalary(int employeeid, int ctcAllowanceId) {
     return employeeCtcDetailDAO.CtcDetailempidMasterSalary(employeeid, ctcAllowanceId);
    }

    @Override
    public List<?> GratuietyFiveYrFetch(int employeeid) {
        return employeeCtcDetailDAO.GratuietyFiveYrFetch(employeeid);
    }

    @Override
    public List<?> bonusFetch(int employeeid) {
          return employeeCtcDetailDAO.bonusFetch(employeeid);
    }

    @Override
    public void deleteByemployeeId(int id) {
        employeeCtcDetailDAO.deleteByemployeeId(id);
    }

}
