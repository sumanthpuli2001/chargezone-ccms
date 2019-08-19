/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.leave;

import com.bul.zydex.dao.leave.EmployeeLeaveBalanceDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author AJAY
 */
public class EmployeeLeaveBalanceServiceImpl<T> extends GenericsServiceImpl<T> implements EmployeeLeaveBalanceService<T> {

    protected EmployeeLeaveBalanceDAO<T> employeeLeaveBalanceDAO;

    public EmployeeLeaveBalanceDAO<T> getEmployeeLeaveBalanceDAO() {
        return employeeLeaveBalanceDAO;
    }

    public void setEmployeeLeaveBalanceDAO(EmployeeLeaveBalanceDAO<T> employeeLeaveBalanceDAO) {
        this.employeeLeaveBalanceDAO = employeeLeaveBalanceDAO;
        setGenericsDAO(employeeLeaveBalanceDAO);
    }

    @Override
    public List<?> readByEmpId(T object) {
        return employeeLeaveBalanceDAO.readByEmpId(object);
    }

    @Override
    public List<?> readleaveWiseBalance(T object) {
        return employeeLeaveBalanceDAO.readleaveWiseBalance(object);
    }

    @Override
    public List<?> readByleaveTypeId(T object) {
        return employeeLeaveBalanceDAO.readByleaveTypeId(object);
    }

    @Override
    public List<?> readByEmpIdAndLeaveTypeId(int empId, int levtyId) {
        return employeeLeaveBalanceDAO.readByEmpIdAndLeaveTypeId(empId, levtyId);
    }

    @Override
    public List<?> readEmpId(int empId) {
        return employeeLeaveBalanceDAO.readEmpId(empId);
    }

    @Override
    public List<?> readByLeave(Integer empId, int leaveId) {
        return employeeLeaveBalanceDAO.readByLeave(empId, leaveId);
    }

    @Override
    public boolean readByEmpeIdAndLeaveTypeId(int empid, int leaveid) {
        return employeeLeaveBalanceDAO.readByEmpeIdAndLeaveTypeId(empid, leaveid);
    }

    @Override
    public List<?> readByEmpId1(Integer id, Float empNoOfDays,Integer leaveType) {
        return employeeLeaveBalanceDAO.readByEmpId1(id, empNoOfDays,leaveType);
    }

    @Override
    public List<?> readleavebalance(int empid) {
      return employeeLeaveBalanceDAO.readleavebalance(empid);
    }

}
