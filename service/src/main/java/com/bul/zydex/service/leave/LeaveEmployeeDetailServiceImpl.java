/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.leave;

import com.bul.zydex.dao.leave.LeaveEmployeeDetailDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author AJAY
 */
public class LeaveEmployeeDetailServiceImpl<T> extends GenericsServiceImpl<T> implements LeaveEmployeeDetailService<T> {

    protected LeaveEmployeeDetailDAO<T> leaveEmployeeDetailDAO;

    public LeaveEmployeeDetailDAO<T> getLeaveEmployeeDetailDAO() {
        return leaveEmployeeDetailDAO;
    }

    public void setLeaveEmployeeDetailDAO(LeaveEmployeeDetailDAO<T> leaveEmployeeDetailDAO) {
        this.leaveEmployeeDetailDAO = leaveEmployeeDetailDAO;
        setGenericsDAO(leaveEmployeeDetailDAO);
    }

    @Override
    public List<?> readLeaveDays(T object) {
        return leaveEmployeeDetailDAO.readLeaveDays(object);
    }

    @Override
    public List<?> readEmpLeaveDetail(T object) {
        return leaveEmployeeDetailDAO.readEmpLeaveDetail(object);
    }

    @Override
    public List<?> viewEmpLeaveRequest(T object) {
        return leaveEmployeeDetailDAO.viewEmpLeaveRequest(object);
    }

    @Override
    public List<?> empLeaveRequestDetail(T object) {
        return leaveEmployeeDetailDAO.empLeaveRequestDetail(object);
    }

    @Override
    public List<?> readByEmployeeId(T object) {
        return leaveEmployeeDetailDAO.readByEmployeeId(object);
    }

    @Override
    public List<?> readEmpLeave(T object) {
        return leaveEmployeeDetailDAO.readEmpLeave(object);
    }

    @Override
    public List<?> readOwnLeave(T object) {
        return leaveEmployeeDetailDAO.readOwnLeave(object);
    }

    @Override
    public List<?> readEmployeeWiseMaternity(T object) {
        return leaveEmployeeDetailDAO.readEmployeeWiseMaternity(object);
    }

    @Override
    public List<?> readApprovedLeaveDays(T object) {
        return leaveEmployeeDetailDAO.readApprovedLeaveDays(object);
    }

    @Override
    public List<?> readPendingLeaveRequest(T object) {
        return leaveEmployeeDetailDAO.readPendingLeaveRequest(object);
    }

    @Override
    public List<?> readPendingApproverLeaveRequest(T object) {
        return leaveEmployeeDetailDAO.readPendingApproverLeaveRequest(object);
    }

    @Override
    public List<?> readPendingApprover2LeaveRequest(T object) {
        return leaveEmployeeDetailDAO.readPendingApprover2LeaveRequest(object);
    }

    @Override
    public List<?> readapproverSearch(T object) {
        return leaveEmployeeDetailDAO.readapproverSearch(object);
    }

    @Override
    public List<?> searchLeaveDetailByEmployee(T object) {
        return leaveEmployeeDetailDAO.searchLeaveDetailByEmployee(object);
    }

    @Override
    public List<?> searchLeaveApproveOfEmployeeByMonthWise(T object) {
        return leaveEmployeeDetailDAO.searchLeaveApproveOfEmployeeByMonthWise(object);
    }

    @Override
    public List<?> searchLeaveApproveOfEmployeeByPreviousMonthWise(T object) {
        return leaveEmployeeDetailDAO.searchLeaveApproveOfEmployeeByPreviousMonthWise(object);
    }

    @Override
    public List<?> dateWiseLeaveSelectionOfEmployee(T object) {
        return leaveEmployeeDetailDAO.dateWiseLeaveSelectionOfEmployee(object);
    }

    @Override
    public List<?> viewEmpLeaveRequestForPowerAdmin() {
        return leaveEmployeeDetailDAO.viewEmpLeaveRequestForPowerAdmin();
    }
    @Override
    public List<?> readApprovedShortLeaveDays(T object) {
        return leaveEmployeeDetailDAO.readApprovedShortLeaveDays(object);
    }
    @Override
    public int readPendingLeaveRequestForDashboard(T object) {
        return leaveEmployeeDetailDAO.readPendingLeaveRequestForDashboard(object);
    }
    @Override
     public int readPendingApproverLeaveRequestForDashboard(T object) {
        return leaveEmployeeDetailDAO.readPendingApproverLeaveRequestForDashboard(object);
    }
    @Override
     public int readWithdrawPendingApproverLeaveRequestForDashboard(T object) {
        return leaveEmployeeDetailDAO.readWithdrawPendingApproverLeaveRequestForDashboard(object);
    }

    @Override
    public List<?> readEmpLeaveListDetail(T object) {
        return leaveEmployeeDetailDAO.readEmpLeaveListDetail(object);
    }

}
