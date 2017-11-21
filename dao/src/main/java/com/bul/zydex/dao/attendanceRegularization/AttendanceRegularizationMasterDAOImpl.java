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
        query += " SELECT a.id,b.employeeName,a.startDateTime,a.endDateTime,a.reason,a.status,a.dateOfSubmit"
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
        query += " SELECT a.id,b.employeeName,a.startDateTime,a.endDateTime,a.reason,a.status,a.dateOfSubmit"
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
    public int countByAttendanceRegularizationPendingList(int id) {
        String query = "";
        int i = 0;
        query += "select count(a.id)"
                + "FROM AttendanceRegularization a"
                + " Where a.userMasterId=" + id
                + " and a.status=0";

        List list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            long l = (long) list.get(0);
            i = (int) l;
        }
        return i;
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
        query += " SELECT a.id,b.employeeName,a.startDateTime,a.endDateTime,a.reason,a.status,b.employeeId,a.dateOfSubmit"
                + " FROM AttendanceRegularization a,"
                + " EmployeeMaster b"
                + " Where a.userMasterId=b.userMaster.id"
                + " order by a.id desc";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readArCountList(T object) {
        AttendanceRegularization attendanceRegularization = (AttendanceRegularization) object;
        String query = "SELECT a.id,a.start_date_time,a.end_date_time "
                + " FROM attendance_regularization a"
                + " inner join employee_master b on b.user_master_id = a.user_master_id"
                + " WHERE b.user_master_id =" + attendanceRegularization.getUserMasterId()
                + " AND a.status = 1"
                + " AND DATE_FORMAT(STR_TO_DATE('" + attendanceRegularization.getStartDateTime() + "', '%d/%m/%Y'),'%Y-%m-%d') "
                + " BETWEEN DATE_FORMAT(STR_TO_DATE(a.start_date_time, '%d/%m/%Y'),'%Y-%m-%d') "
                + " AND DATE_FORMAT(STR_TO_DATE(a.end_date_time, '%d/%m/%Y'),'%Y-%m-%d')";
//        String query = "SELECT a.id,a.startDateTime,a.endDateTime"
//                + " FROM AttendanceRegularization a"
//                + " LEFT JOIN a.employeeMaster b"
//                + " WHERE b.userMaster.id =" + attendanceRegularization.getUserMasterId()
//                + " AND a.status = 1"
//                + " AND DATE_FORMAT(STR_TO_DATE('" + attendanceRegularization.getStartDateTime() + "', '%Y-%m-%d'),'%Y-%m-%d') "
//                + " BETWEEN DATE_FORMAT(STR_TO_DATE(a.startDateTime, '%d/%m/%Y %H:%i:%s'),'%Y-%m-%d') "
//                + " AND DATE_FORMAT(STR_TO_DATE(a.endDateTime, '%d/%m/%Y %H:%i:%s'),'%Y-%m-%d')";
        return getSession().createSQLQuery(query).list();
    }
}
