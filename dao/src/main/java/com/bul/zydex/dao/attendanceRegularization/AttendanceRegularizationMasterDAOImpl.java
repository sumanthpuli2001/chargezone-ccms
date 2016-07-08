/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.attendanceRegularization;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.AttendanceRegularization;
import com.bul.zydex.model.EmployeeMaster;
import java.util.List;

/**
 *
 * @author Dhaval Patel
 */
public class AttendanceRegularizationMasterDAOImpl<T> extends GenericsDAOImpl<T> implements AttendanceRegularizationMasterDAO<T> {

    @Override
    protected Class getDomainClass() {
        return AttendanceRegularization.class;
    }

    @Override
    public List<?> userWiseAttendanceRegularizationList(int id) {
        String query = "";
        query += " FROM AttendanceRegularization a"
                + " Where a.userMasterId=" + id
                + " ORDER BY a.id desc";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> userWiseAttendanceRegularizationApproveList(int id) {
        String query = "";
        query += " FROM AttendanceRegularization a"
                + " Where a.userMasterId=" + id
                + " and a.status In(1,3)";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> userReportingManager(int id) {
        String query = "";
        query += " FROM EmployeeMaster a"
                + " Where a.userMaster.id=" + id;
        List list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> approvalLeval1WiseAttendanceRegularizationList(int id) {
        String query = "";
        query += " SELECT a.id,b.employeeName,a.startDateTime,a.endDateTime,a.reason,a.status"
                + " FROM AttendanceRegularization a,"
                + " EmployeeMaster b"
                + " Where a.userMasterId=b.userMaster.id"
                + " and b.reportingManagerLevel1=" + id
                + "Order by a.id Desc";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> attendanceRegularizationApprivedList(int id) {
        String query = "";
        query += " SELECT a.id,b.employeeName,a.startDateTime,a.endDateTime,a.reason,a.status"
                + " FROM AttendanceRegularization a,"
                + " EmployeeMaster b"
                + " Where a.userMasterId=b.userMaster.id"
                + " and a.status In(1,3,5)"
                + " and b.reportingManagerLevel1=" + id;

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readByAttendanceRegularizationPendingList(int id) {
        String query = "";
        query += " FROM AttendanceRegularization a"
                + " Where a.userMasterId=" + id
                + " and a.status=0";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readByAttendanceRegularizationApproverPendingList(T object) {
        AttendanceRegularization attendanceRegularization = (AttendanceRegularization) object;
        String query = "";
        query += " SELECT a.id,b.employeeName,a.startDateTime"
                + " FROM AttendanceRegularization a,"
                + " EmployeeMaster b"
                + " Where a.userMasterId=b.userMaster.id"
                + " and b.reportingManagerLevel1=" + attendanceRegularization.getId()
                + " and a.status=0";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readByAttendanceRegularizationApprover2PendingList(T object) {
        AttendanceRegularization attendanceRegularization = (AttendanceRegularization) object;
        String query = "";
        query += " SELECT a.id,b.employeeName,a.startDateTime"
                + " FROM AttendanceRegularization a,"
                + " EmployeeMaster b"
                + " Where a.userMasterId=b.userMaster.id"
                + " and b.reportingManagerLevel2=" + attendanceRegularization.getId()
                + " and a.status=0";
        return getHibernateTemplate().find(query);
    }

    public List<?> searchLeaveApproveOfEmployeeByMonthWise(T object) {
        AttendanceRegularization attendanceRegularization = (AttendanceRegularization) object;
        String hqlQuery = "SELECT  count(a.status) as total"
                + "  From AttendanceRegularization a,"
                + " EmployeeMaster b"
                + " where a.userMasterId=b.userMaster.id"
                + " and b.id=" + attendanceRegularization.getUserMasterId()
                + " and a.status=1"
                + " and DATE_FORMAT(STR_TO_DATE('" + attendanceRegularization.getApprovedDate() + "','%d/%m/%Y'),'%m') = DATE_FORMAT(STR_TO_DATE(a.startDateTime,'%d/%m/%Y'),'%m')"
                + " and DATE_FORMAT(STR_TO_DATE(a.approvedDate,'%d/%m/%Y'),'%m')= DATE_FORMAT(STR_TO_DATE('" + attendanceRegularization.getApprovedDate() + "','%d/%m/%Y'),'%m')";

        return getHibernateTemplate().find(hqlQuery);
    }

    public List<?> searchLeaveApproveOfEmployeeByPreviousMonthWise(T object) {
        AttendanceRegularization attendanceRegularization = (AttendanceRegularization) object;

        String hqlQuery = "SELECT  count(a.status) as total"
                + "  From AttendanceRegularization a,"
                + " EmployeeMaster b"
                + " where a.userMasterId=b.userMaster.id"
                + " and b.id=" + attendanceRegularization.getUserMasterId()
                + " and a.status=1"
                + " and DATE_FORMAT(STR_TO_DATE('" + attendanceRegularization.getEndDateTime() + "','%d/%m/%Y'),'%m') = DATE_FORMAT(STR_TO_DATE(a.startDateTime,'%d/%m/%Y'),'%m')"
                + " and DATE_FORMAT(STR_TO_DATE(a.approvedDate,'%d/%m/%Y'),'%m')= DATE_FORMAT(STR_TO_DATE('" + attendanceRegularization.getApprovedDate() + "','%d/%m/%Y'),'%m')";
        return getHibernateTemplate().find(hqlQuery);
    }

    @Override
    public List<?> powerAdminAttendanceRegularizationList() {
        String query = "";
        query += " SELECT a.id,b.employeeName,a.startDateTime,a.endDateTime,a.reason,a.status,b.employeeId"
                + " FROM AttendanceRegularization a,"
                + " EmployeeMaster b"
                + " Where a.userMasterId=b.userMaster.id";
        return getHibernateTemplate().find(query);
    }
}
