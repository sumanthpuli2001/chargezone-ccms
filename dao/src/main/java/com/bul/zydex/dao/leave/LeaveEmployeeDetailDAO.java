/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.leave;

import com.bul.zydex.dao.GenericsDAO;
import java.util.List;

/**
 *
 * @author AJAY
 */
public interface LeaveEmployeeDetailDAO<T> extends GenericsDAO<T> {

    public List<?> readLeaveDays(T object);

    public List<?> readEmpLeaveDetail(T object);

    public List<?> viewEmpLeaveRequest(T object);

    public List<?> empLeaveRequestDetail(T object);

    public List<?> readByEmployeeId(T object);

    public List<?> readEmpLeave(T object);

    public List<?> readOwnLeave(T object);

    public List<?> readEmployeeWiseMaternity(T object);

    public List<?> readApprovedLeaveDays(T object);

    public List<?> readPendingLeaveRequest(T object);

    public List<?> readPendingApproverLeaveRequest(T object);

    public List<?> readPendingApprover2LeaveRequest(T object);

    public List<?> readapproverSearch(T object);

    public List<?> searchLeaveDetailByEmployee(T object);

    public List<?> searchLeaveApproveOfEmployeeByMonthWise(T object);

    public List<?> searchLeaveApproveOfEmployeeByPreviousMonthWise(T object);

    public List<?> dateWiseLeaveSelectionOfEmployee(T object);

    public List<?> viewEmpLeaveRequestForPowerAdmin();

    public List<?> readApprovedShortLeaveDays(T object);

    public int readPendingLeaveRequestForDashboard(T object);

    public int readPendingApproverLeaveRequestForDashboard(T object);

    public int readWithdrawPendingApproverLeaveRequestForDashboard(T object);

    public List<?> readEmpLeaveListDetail(T object);

    public List<?> readDate(T object);

    public List<?> leaveCheck(T object);

    public List<?> leaveCheckStartDate(T object);

    public List<?> plLeaveCheck(int empId);

    public List<?> leaveApplicationRequest(T object);

    public List<?> readLeaveDetails(T object);

    public List<?> sickleaveCheck(T object);

    public List<?> casualleaveCheck(T object);

    public List<?> getEmployeeLeaveDetail(int empId, String prevDate);

    public List<?> getEmployeeLeaveDetailByDate(String startDate,String endDate, int approverId);

    public List<?> viewEmpLeaveRequestForHR();
}
