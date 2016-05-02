/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.attendanceRegularization;

import com.bul.zydex.dao.attendanceRegularization.AttendanceRegularizationMasterDAO;
import com.bul.zydex.service.*;
import java.util.List;

/**
 *
 * @author Dhaval Patel
 */
public class AttendanceRegularizationMasterServiceImpl<T> extends GenericsServiceImpl<T> implements AttendanceRegularizationMasterService<T> {

    protected AttendanceRegularizationMasterDAO<T> attendanceRegularizationMasterDAO;

    public AttendanceRegularizationMasterDAO<T> getAttendanceRegularizationMasterDAO() {
        return attendanceRegularizationMasterDAO;
    }

    public void setAttendanceRegularizationMasterDAO(AttendanceRegularizationMasterDAO<T> attendanceRegularizationMasterDAO) {
        this.attendanceRegularizationMasterDAO = attendanceRegularizationMasterDAO;
        setGenericsDAO(attendanceRegularizationMasterDAO);
    }

    @Override
    public List<?> userWiseAttendanceRegularizationList(int id) {
        return attendanceRegularizationMasterDAO.userWiseAttendanceRegularizationList(id);
    }

    @Override
    public List<?> approvalLeval1WiseAttendanceRegularizationList(int id) {
        return attendanceRegularizationMasterDAO.approvalLeval1WiseAttendanceRegularizationList(id);
    }

    @Override
    public List<?> attendanceRegularizationApprivedList(int id) {
        return attendanceRegularizationMasterDAO.attendanceRegularizationApprivedList(id);
    }

    @Override
    public List<?> userWiseAttendanceRegularizationApproveList(int id) {
        return attendanceRegularizationMasterDAO.userWiseAttendanceRegularizationApproveList(id);
    }

    @Override
    public List<?> readByAttendanceRegularizationPendingList(int id) {
        return attendanceRegularizationMasterDAO.readByAttendanceRegularizationPendingList(id);
    }

    @Override
    public List<?> userReportingManager(int id) {
        return attendanceRegularizationMasterDAO.userReportingManager(id);
    }

    @Override
    public List<?> readByAttendanceRegularizationApproverPendingList(T object) {
        return attendanceRegularizationMasterDAO.readByAttendanceRegularizationApproverPendingList(object);
    }

    @Override
    public List<?> readByAttendanceRegularizationApprover2PendingList(T object) {
        return attendanceRegularizationMasterDAO.readByAttendanceRegularizationApprover2PendingList(object);
    }

    @Override
    public List<?> searchLeaveApproveOfEmployeeByMonthWise(T object) {
        return attendanceRegularizationMasterDAO.searchLeaveApproveOfEmployeeByMonthWise(object);
    }

    @Override
    public List<?> searchLeaveApproveOfEmployeeByPreviousMonthWise(T object) {
        return attendanceRegularizationMasterDAO.searchLeaveApproveOfEmployeeByPreviousMonthWise(object);
    }

    @Override
    public List<?> powerAdminAttendanceRegularizationList() {
        return attendanceRegularizationMasterDAO.powerAdminAttendanceRegularizationList();
    }

}
