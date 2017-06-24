/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.leave;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.LeaveEmployeeDetail;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author AJAY
 */
public class LeaveEmployeeDetailDAOImpl<T> extends GenericsDAOImpl<T> implements LeaveEmployeeDetailDAO<T> {

    @Override
    protected Class getDomainClass() {
        return LeaveEmployeeDetail.class;
    }

    @Override
    public List<?> readLeaveDays(T object) {
        LeaveEmployeeDetail leaveEmployeeDetail = (LeaveEmployeeDetail) object;
        String query = "";
        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);

        query += " Select SUM(a.noOfDays)"
                + " FROM LeaveEmployeeDetail a"
                + " LEFT JOIN a.leaveTypeMaster b"
                + " WHERE a.employeeMaster = " + leaveEmployeeDetail.getEmployeeMaster().getId()
                + " AND a.leaveTypeMaster = " + leaveEmployeeDetail.getLeaveTypeMaster().getId()
                + " AND a.status=3"
                + " AND YEAR(STR_TO_DATE(a.startDate,'%d/%m/%Y'))=" + year;

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readEmpLeaveDetail(T object) {
        LeaveEmployeeDetail leaveEmployeeDetail = (LeaveEmployeeDetail) object;
        String query = "";
        String condition = "";

        if (!"".equals(leaveEmployeeDetail.getStartDate()) && null != leaveEmployeeDetail.getStartDate()
                && !"".equals(leaveEmployeeDetail.getEndDate()) && null != leaveEmployeeDetail.getEndDate()) {
            condition += " AND a.startDate BETWEEN '" + leaveEmployeeDetail.getStartDate() + "' AND '" + leaveEmployeeDetail.getEndDate() + "' ";
        }
        if (null != leaveEmployeeDetail.getLeaveTypeMaster() && !"".equals(leaveEmployeeDetail.getLeaveTypeMaster())) {
            condition += " AND b.id = '" + leaveEmployeeDetail.getLeaveTypeMaster().getId() + "'";
        }

        query += " Select b.leaveType, a.startDate, a.endDate, a.noOfDays, a.id, a.status,a.dateOfSubmit, (Select c.employeeName from EmployeeMaster c where c.id=a.approverId) as ApproveName  "
                + " FROM LeaveEmployeeDetail a"
                + " LEFT JOIN a.leaveTypeMaster b"
                + " WHERE a.employeeMaster = " + leaveEmployeeDetail.getEmployeeMaster().getId()
                + " AND a.status !=5" + condition
                + " ORDER BY a.id desc";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> viewEmpLeaveRequest(T object) {
        LeaveEmployeeDetail leaveEmployeeDetail = (LeaveEmployeeDetail) object;
        String query = "";

        query += " Select c.employeeName, b.leaveType, a.startDate, a.endDate, a.noOfDays, a.id, a.status, d.id, a.dateOfSubmit"
                + " FROM LeaveEmployeeDetail a"
                + " LEFT JOIN a.leaveTypeMaster b"
                + " LEFT JOIN a.employeeMaster c"
                + " LEFT JOIN c.userMaster d"
                + " WHERE c.reportingManagerLevel1='" + leaveEmployeeDetail.getEmployeeMaster().getId() + "'"
                + " ORDER BY a.id desc";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> empLeaveRequestDetail(T object) {
        LeaveEmployeeDetail leaveEmployeeDetail = (LeaveEmployeeDetail) object;
        String query = "";

        query += " Select b.leaveType, a.startDate, a.startDateStatus, a.endDate, a.endDateStatus, a.noOfDays, a.empRemark, a.status"
                + " FROM LeaveEmployeeDetail a"
                + " LEFT JOIN a.leaveTypeMaster b"
                + " LEFT JOIN a.employeeMaster c"
                + " LEFT JOIN c.userMaster d"
                + " WHERE c.id=" + leaveEmployeeDetail.getEmployeeMaster().getId()
                + " AND a.id=" + leaveEmployeeDetail.getId();

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readByEmployeeId(T object) {
        LeaveEmployeeDetail leaveEmployeeDetail = (LeaveEmployeeDetail) object;

        String query = "";
        query += ""
                + " From LeaveEmployeeDetail a "
                + " WHERE a.employeeMaster.id = " + leaveEmployeeDetail.getEmployeeMaster().getId()
                + " and a.status !=2";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readEmpLeave(T object) {
        LeaveEmployeeDetail leaveEmployeeDetail = (LeaveEmployeeDetail) object;

        String query = "";
        String condition = "";

        if (null != leaveEmployeeDetail.getEmployeeMaster().getId()) {
            condition += " AND  b.id = " + leaveEmployeeDetail.getEmployeeMaster().getId();
        }
        if (null != leaveEmployeeDetail.getStartDate() && !"".equals(leaveEmployeeDetail.getStartDate())) {
            condition += " AND STR_TO_DATE(a.startDate,'%d/%m/%Y') >= STR_TO_DATE('" + leaveEmployeeDetail.getStartDate() + "','%d/%m/%Y')";
        }
        if (null != leaveEmployeeDetail.getEndDate() && !"".equals(leaveEmployeeDetail.getEndDate())) {
            condition += " AND STR_TO_DATE(a.endDate,'%d/%m/%Y') <= STR_TO_DATE('" + leaveEmployeeDetail.getEndDate() + "','%d/%m/%Y')";
        }
        if (!"".equals(leaveEmployeeDetail.getLeaveTypeMaster().getId()) && null != leaveEmployeeDetail.getLeaveTypeMaster().getId()) {
            condition += " AND e.id = " + leaveEmployeeDetail.getLeaveTypeMaster().getId();
        }
        if (!"".equals(leaveEmployeeDetail.getStartDateStatus()) && null != leaveEmployeeDetail.getStartDateStatus()) {
            condition += " AND c.id = " + leaveEmployeeDetail.getStartDateStatus();
        }
        if (!"".equals(leaveEmployeeDetail.getEndDateStatus()) && null != leaveEmployeeDetail.getEndDateStatus()) {
            condition += " AND d.id = " + leaveEmployeeDetail.getEndDateStatus();
        }

        query += " Select b.employeeId, b.employeeName, c.departmentName, d.designationName, e.leaveType, a.startDate, a.endDate,a.status, a.noOfDays, a.dateOfSubmit "
                + " From LeaveEmployeeDetail a "
                + " LEFT JOIN a.employeeMaster b "
                + " LEFT JOIN b.departmentMaster c "
                + " LEFT JOIN b.designationMaster d "
                + " LEFT JOIN a.leaveTypeMaster e "
                + " Where 1=1" + condition
                + " Order By a.id desc";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readOwnLeave(T object) {
        LeaveEmployeeDetail leaveEmployeeDetail = (LeaveEmployeeDetail) object;

        String query = "";
        String condition = "";

        if (null != leaveEmployeeDetail.getStartDate() && !"".equals(leaveEmployeeDetail.getStartDate())) {
            condition += " AND STR_TO_DATE(a.startDate,'%d/%m/%Y') >= STR_TO_DATE('" + leaveEmployeeDetail.getStartDate() + "','%d/%m/%Y')";
        }
        if (null != leaveEmployeeDetail.getEndDate() && !"".equals(leaveEmployeeDetail.getEndDate())) {
            condition += " AND STR_TO_DATE(a.endDate,'%d/%m/%Y') <= STR_TO_DATE('" + leaveEmployeeDetail.getEndDate() + "','%d/%m/%Y')";
        }
        if (null != leaveEmployeeDetail.getLeaveTypeMaster() && !"".equals(leaveEmployeeDetail.getLeaveTypeMaster())) {
            condition += " AND b.id = '" + leaveEmployeeDetail.getLeaveTypeMaster().getId() + "'";
        }

        query += " Select b.leaveType, a.startDate, a.endDate, a.noOfDays, a.id, a.status"
                + " FROM LeaveEmployeeDetail a"
                + " LEFT JOIN a.leaveTypeMaster b"
                + " WHERE a.employeeMaster = " + leaveEmployeeDetail.getEmployeeMaster().getId()
                + " AND a.status !=5"
                + condition;

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readEmployeeWiseMaternity(T object) {
        LeaveEmployeeDetail leaveEmployeeDetail = (LeaveEmployeeDetail) object;

        String query = "";
        query += " From LeaveEmployeeDetail a"
                + " LEFT JOIN a.leaveTypeMaster b"
                + " WHERE a.employeeMaster.id = " + leaveEmployeeDetail.getEmployeeMaster().getId()
                + " AND b.leaveType='Paternity Leave'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readApprovedLeaveDays(T object) {
        LeaveEmployeeDetail leaveEmployeeDetail = (LeaveEmployeeDetail) object;
        String query = "";
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/YYYY");
        String s = formatter.format(date);

        query += " Select SUM(a.noOfDays)"
                + " FROM LeaveEmployeeDetail a"
                + " LEFT JOIN a.leaveTypeMaster b"
                + " WHERE a.employeeMaster = " + leaveEmployeeDetail.getEmployeeMaster().getId()
                + " AND a.leaveTypeMaster = " + leaveEmployeeDetail.getLeaveTypeMaster().getId()
                + " AND DATE_FORMAT(STR_TO_DATE(a.startDate,'%d/%m/%Y'),'%Y')= DATE_FORMAT(STR_TO_DATE('" + s + "','%d/%m/%Y'),'%Y')"
                + " AND a.status in (0,3)";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readPendingLeaveRequest(T object) {
        LeaveEmployeeDetail leaveEmployeeDetail = (LeaveEmployeeDetail) object;
        String query = "";

        query += " Select b.leaveType, a.startDate, a.endDate, a.noOfDays, a.id, a.status"
                + " FROM LeaveEmployeeDetail a"
                + " LEFT JOIN a.leaveTypeMaster b"
                + " WHERE a.employeeMaster = " + leaveEmployeeDetail.getEmployeeMaster().getId()
                + " AND a.status =0";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readPendingApproverLeaveRequest(T object) {
        LeaveEmployeeDetail leaveEmployeeDetail = (LeaveEmployeeDetail) object;
        String query = "";

        query += " Select a.id,b.employeeName,a.startDate, a.status"
                + " FROM LeaveEmployeeDetail a,"
                + " EmployeeMaster b"
                + " WHERE a.employeeMaster=b.id"
                + " and b.reportingManagerLevel1=" + leaveEmployeeDetail.getEmployeeMaster().getId()
                + " AND a.status IN(0,4)";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readPendingApprover2LeaveRequest(T object) {
        LeaveEmployeeDetail leaveEmployeeDetail = (LeaveEmployeeDetail) object;
        String query = "";
        query += " Select a.id,b.employeeName, a.status"
                + " FROM LeaveEmployeeDetail a,"
                + " EmployeeMaster b"
                + " WHERE a.employeeMaster=b.id"
                + " and b.reportingManagerLevel2=" + leaveEmployeeDetail.getEmployeeMaster().getId()
                + " AND a.status IN (0,4)";

        return getHibernateTemplate().find(query);
    }

    public List<?> readapproverSearch(T object) {
        LeaveEmployeeDetail leaveEmployeeDetail = (LeaveEmployeeDetail) object;

        String query = "";
        String condition = "";

        if (null != leaveEmployeeDetail.getEmployeeMaster().getId()) {
            condition += " AND  b.id = " + leaveEmployeeDetail.getEmployeeMaster().getId();
        }
        if (!"".equals(leaveEmployeeDetail.getStartDate())
                && null != leaveEmployeeDetail.getStartDate()
                && !"".equals(leaveEmployeeDetail.getEndDate()) && null != leaveEmployeeDetail.getEndDate()) {
            condition += " AND a.startDate BETWEEN '" + leaveEmployeeDetail.getStartDate() + "' AND '" + leaveEmployeeDetail.getEndDate() + "' ";
        }
        if (!"".equals(leaveEmployeeDetail.getLeaveTypeMaster().getId()) && null != leaveEmployeeDetail.getLeaveTypeMaster().getId()) {
            condition += " AND c.id = " + leaveEmployeeDetail.getLeaveTypeMaster().getId();
        }

        query += " Select b.employeeId, b.employeeName, c.leaveType, a.startDate, a.endDate,a.status, a.noOfDays "
                + " From LeaveEmployeeDetail a "
                + " LEFT JOIN a.employeeMaster b "
                + " LEFT JOIN a.leaveTypeMaster c "
                + " WHERE (b.reportingManagerLevel1= " + leaveEmployeeDetail.getApproverId()
                + " Or b.reportingManagerLevel2= " + leaveEmployeeDetail.getApproverId()
                + " Or b.reportingManagerLevel3= " + leaveEmployeeDetail.getApproverId()
                + " Or b.reportingManagerLevel4= " + leaveEmployeeDetail.getApproverId() + ")" + condition;

        return getHibernateTemplate().find(query);
    }

    public List<?> searchLeaveDetailByEmployee(T object) {
        LeaveEmployeeDetail leaveEmployeeDetail = (LeaveEmployeeDetail) object;

        String condition = "";
        if (null != leaveEmployeeDetail.getEmployeeMaster() && !"".equals(leaveEmployeeDetail.getEmployeeMaster())) {
            condition += " AND b.id = " + leaveEmployeeDetail.getEmployeeMaster().getId() + "";
        }
        if (null != leaveEmployeeDetail.getLeaveTypeMaster() && !"".equals(leaveEmployeeDetail.getLeaveTypeMaster())) {
            condition += " AND c.id = '" + leaveEmployeeDetail.getLeaveTypeMaster().getId() + "'";
        }
        if (null != leaveEmployeeDetail.getStartDate() && !"".equals(leaveEmployeeDetail.getStartDate())) {
            condition += " AND STR_TO_DATE(a.startDate,'%d/%m/%Y') >= STR_TO_DATE('" + leaveEmployeeDetail.getStartDate() + "','%d/%m/%Y')";
        }
        if (null != leaveEmployeeDetail.getEndDate() && !"".equals(leaveEmployeeDetail.getEndDate())) {
            condition += " AND STR_TO_DATE(a.endDate,'%d/%m/%Y') <= STR_TO_DATE('" + leaveEmployeeDetail.getEndDate() + "','%d/%m/%Y')";
        }

        String hqlQuery = "SELECT b.employeeName, c.leaveType, a.startDate, a.endDate, a.noOfDays, a.id, a.status, d.id"
                + "  From LeaveEmployeeDetail a"
                + " LEFT JOIN a.employeeMaster b "
                + " LEFT JOIN a.leaveTypeMaster c"
                + " LEFT JOIN b.userMaster d"
                + " where 1=1"
                + " and b.reportingManagerLevel1=" + leaveEmployeeDetail.getApproverId()
                + condition;
        return getHibernateTemplate().find(hqlQuery);
    }

    public List<?> searchLeaveApproveOfEmployeeByMonthWise(T object) {
        LeaveEmployeeDetail leaveEmployeeDetail = (LeaveEmployeeDetail) object;
        String query = "select DATE_FORMAT(STR_TO_DATE(selected_date, '%Y-%m-%d'),'%d/%m/%Y') As selecteddate ,"
                + "    case"
                + "                when"
                + "            (select"
                + "                    sm.weekof"
                + "                from"
                + "                    employee_shift_data a,"
                + "                    shift_master sm"
                + "                where"
                + "                    a.employee_master_id = " + leaveEmployeeDetail.getEmployeeMaster().getId() + " and sm.id = a.shift_master_id and sm.weekof like CONCAT('%',"
                + "                            DAYNAME(DATE_FORMAT(STR_TO_DATE(selected_date, '%Y-%m-%d'),"
                + "                                            '%Y-%m-%d')),"
                + "                            '%')"
                + "                limit 1) is not null"
                + "        then"
                + "            (select"
                + "                    'WO' as sunday"
                + "                from"
                + "                    employee_shift_data a,"
                + "                    shift_master sm"
                + "                where"
                + "                    a.employee_master_id = " + leaveEmployeeDetail.getEmployeeMaster().getId() + " and sm.id = a.shift_master_id and sm.weekof like CONCAT('%',"
                + "                            DAYNAME(DATE_FORMAT(STR_TO_DATE(selected_date, '%Y-%m-%d'),"
                + "                                            '%Y-%m-%d')),"
                + "                            '%')"
                + "                limit 1)"
                + "     when"
                + "             (select"
                + "                            concat('0.5',' ',d.leave_type) as leaveDay"
                + "                        from"
                + "                            employee_shift_data a,"
                + "                            shift_master sm,"
                + "                            leave_employee_detail c,"
                + "                            leave_type_master d"
                + "                        where"
                + "                                a.employee_master_id = " + leaveEmployeeDetail.getEmployeeMaster().getId() + " and a.employee_master_id = c.employee_master_id"
                + "                                and c.leave_type_id = d.id"
                + "                                and a.shift_master_id = sm.id"
                + "                                and c.status = 3"
                + "                        and DATE_FORMAT(STR_TO_DATE(c.approve_date,'%d/%m/%Y'),'%m')= DATE_FORMAT(STR_TO_DATE('" + leaveEmployeeDetail.getApproveDate() + "','%Y-%m-%d'),'%m')"
                + "                                and STR_TO_DATE(a.in_date_time, '%d/%m/%Y')= STR_TO_DATE(selected_date, '%Y-%m-%d')"
                + "                                and (((STR_TO_DATE(selected_date, '%Y-%m-%d')= STR_TO_DATE(c.start_date, '%d/%m/%Y'))"
                + "                                or STR_TO_DATE(selected_date, '%Y-%m-%d')= STR_TO_DATE(c.end_date, '%d/%m/%Y')))"
                + "                        limit 1) is not null"
                + "    then "
                + "             (select concat('0.5',' ',d.leave_type) as leaveDay"
                + "                        from"
                + "                            employee_shift_data a,"
                + "                            shift_master sm,"
                + "                            leave_employee_detail c,"
                + "                            leave_type_master d"
                + "                        where"
                + "                                 a.employee_master_id = " + leaveEmployeeDetail.getEmployeeMaster().getId() + " and a.employee_master_id = c.employee_master_id"
                + "                                and c.leave_type_id = d.id"
                + "                                and a.shift_master_id = sm.id"
                + "                                and c.status = 3"
                + "                        and DATE_FORMAT(STR_TO_DATE(c.approve_date,'%d/%m/%Y'),'%m')= DATE_FORMAT(STR_TO_DATE('" + leaveEmployeeDetail.getApproveDate() + "','%Y-%m-%d'),'%m')"
                + "                                and STR_TO_DATE(a.in_date_time, '%d/%m/%Y')= STR_TO_DATE(selected_date, '%Y-%m-%d')"
                + "                                and (((STR_TO_DATE(selected_date, '%Y-%m-%d') = STR_TO_DATE(c.start_date, '%d/%m/%Y'))"
                + "                                or STR_TO_DATE(selected_date, '%Y-%m-%d') = STR_TO_DATE(c.end_date, '%d/%m/%Y')))"
                + "       limit 1)"
                + " when"
                + " (select  concat('1',' ',d.leave_type) as leaveDay"
                + "                        from                 "
                + "                            leave_employee_detail c,"
                + "                             leave_type_master d"
                + "                        where c.employee_master_id = " + leaveEmployeeDetail.getEmployeeMaster().getId()
                + "                              and c.leave_type_id=d.id "
                + "                              and c.status = 3"
                + "                        and DATE_FORMAT(STR_TO_DATE(c.approve_date,'%d/%m/%Y'),'%m')= DATE_FORMAT(STR_TO_DATE('" + leaveEmployeeDetail.getApproveDate() + "','%Y-%m-%d'),'%m')"
                + "                             and STR_TO_DATE(selected_date, '%Y-%m-%d')    between"
                + "                             STR_TO_DATE(c.start_date, '%d/%m/%Y') and   STR_TO_DATE(c.end_date, '%d/%m/%Y') "
                + " limit 1)is not null"
                + " then"
                + " (select concat('1',' ',d.leave_type) as leaveDay"
                + "                        from"
                + "                            leave_employee_detail c,"
                + "                             leave_type_master d"
                + "                        where c.employee_master_id = " + leaveEmployeeDetail.getEmployeeMaster().getId()
                + "                                and c.leave_type_id=d.id "
                + "                               and c.status = 3"
                + "                        and DATE_FORMAT(STR_TO_DATE(c.approve_date,'%d/%m/%Y'),'%m')= DATE_FORMAT(STR_TO_DATE('" + leaveEmployeeDetail.getApproveDate() + "','%Y-%m-%d'),'%m')"
                + "                             and STR_TO_DATE(selected_date, '%Y-%m-%d')    between"
                + "                             STR_TO_DATE(c.start_date, '%d/%m/%Y') and STR_TO_DATE(c.end_date, '%d/%m/%Y'))"
                + " else 'AB'"
                + "    end"
                + " from"
                + "    (select"
                + "        adddate('1970-01-01', t4 * 10000 + t3 * 1000 + t2 * 100 + t1 * 10 + t0) selected_date"
                + "    from"
                + "        (select 0 t0 union select 1 union select 2 union select 3 union select 4 union select 5 union select 6 union select 7 union select 8 union select 9) t0, (select 0 t1 union select 1 union select 2 union select 3 union select 4 union select 5 union select 6 union select 7 union select 8 union select 9) t1, (select 0 t2 union select 1 union select 2 union select 3 union select 4 union select 5 union select 6 union select 7 union select 8 union select 9) t2, (select 0 t3 union select 1 union select 2 union select 3 union select 4 union select 5 union select 6 union select 7 union select 8 union select 9) t3, (select 0 t4 union select 1 union select 2 union select 3 union select 4 union select 5 union select 6 union select 7 union select 8 union select 9) t4) v"
                + " where selected_date between '" + leaveEmployeeDetail.getApproveDate() + "' and '" + leaveEmployeeDetail.getEndDate() + "'";

        Query query1 = getSession().createSQLQuery(query);
        List results = query1.list();

        Iterator iterator = results.iterator();
        while (iterator.hasNext()) {
            Object[] value = (Object[]) iterator.next();
            if ("AB".equals(value[1]) || "WO".equals(value[1])) {
                iterator.remove();
            }
        }

        return results;
    }

    public List<?> searchLeaveApproveOfEmployeeByPreviousMonthWise(T object) {
        LeaveEmployeeDetail leaveEmployeeDetail = (LeaveEmployeeDetail) object;

        String query = "select DATE_FORMAT(STR_TO_DATE(selected_date, '%Y-%m-%d'),'%d/%m/%Y') As selecteddate ,"
                + "    case"
                + "                when"
                + "            (select"
                + "                    sm.weekof"
                + "                from"
                + "                    employee_shift_data a,"
                + "                    shift_master sm"
                + "                where"
                + "                    a.employee_master_id = " + leaveEmployeeDetail.getEmployeeMaster().getId() + " and sm.id = a.shift_master_id and sm.weekof like CONCAT('%',"
                + "                            DAYNAME(DATE_FORMAT(STR_TO_DATE(selected_date, '%Y-%m-%d'),"
                + "                                            '%Y-%m-%d')),"
                + "                            '%')"
                + "                limit 1) is not null"
                + "        then"
                + "            (select"
                + "                    'WO' as sunday"
                + "                from"
                + "                    employee_shift_data a,"
                + "                    shift_master sm"
                + "                where"
                + "                    a.employee_master_id = " + leaveEmployeeDetail.getEmployeeMaster().getId() + " and sm.id = a.shift_master_id and sm.weekof like CONCAT('%',"
                + "                            DAYNAME(DATE_FORMAT(STR_TO_DATE(selected_date, '%Y-%m-%d'),"
                + "                                            '%Y-%m-%d')),"
                + "                            '%')"
                + "                limit 1)"
                + "     when"
                + "             (select"
                + "                            concat('0.5',' ',d.leave_type) as leaveDay"
                + "                        from"
                + "                            employee_shift_data a,"
                + "                            shift_master sm,"
                + "                            leave_employee_detail c,"
                + "                            leave_type_master d"
                + "                        where"
                + "                                a.employee_master_id = " + leaveEmployeeDetail.getEmployeeMaster().getId() + " and a.employee_master_id = c.employee_master_id"
                + "                                and c.leave_type_id = d.id"
                + "                                and a.shift_master_id = sm.id"
                + "                                and c.status = 3"
                + "                        and DATE_FORMAT(STR_TO_DATE(c.approve_date,'%d/%m/%Y'),'%m')= DATE_FORMAT(STR_TO_DATE('" + leaveEmployeeDetail.getApproveDate() + "','%Y-%m-%d'),'%m')"
                + "                                and STR_TO_DATE(a.in_date_time, '%d/%m/%Y')= STR_TO_DATE(selected_date, '%Y-%m-%d')"
                + "                                and (((STR_TO_DATE(selected_date, '%Y-%m-%d')= STR_TO_DATE(c.start_date, '%d/%m/%Y'))"
                + "                                or STR_TO_DATE(selected_date, '%Y-%m-%d')= STR_TO_DATE(c.end_date, '%d/%m/%Y')))"
                + "                        limit 1) is not null"
                + "    then "
                + "             (select concat('0.5',' ',d.leave_type) as leaveDay"
                + "                        from"
                + "                            employee_shift_data a,"
                + "                            shift_master sm,"
                + "                            leave_employee_detail c,"
                + "                            leave_type_master d"
                + "                        where"
                + "                                 a.employee_master_id = " + leaveEmployeeDetail.getEmployeeMaster().getId() + " and a.employee_master_id = c.employee_master_id"
                + "                                and c.leave_type_id = d.id"
                + "                                and a.shift_master_id = sm.id"
                + "                                and c.status = 3"
                + "                        and DATE_FORMAT(STR_TO_DATE(c.approve_date,'%d/%m/%Y'),'%m')= DATE_FORMAT(STR_TO_DATE('" + leaveEmployeeDetail.getApproveDate() + "','%Y-%m-%d'),'%m')"
                + "                                and STR_TO_DATE(a.in_date_time, '%d/%m/%Y')= STR_TO_DATE(selected_date, '%Y-%m-%d')"
                + "                                and (((STR_TO_DATE(selected_date, '%Y-%m-%d') = STR_TO_DATE(c.start_date, '%d/%m/%Y'))"
                + "                                or STR_TO_DATE(selected_date, '%Y-%m-%d') = STR_TO_DATE(c.end_date, '%d/%m/%Y')))"
                + "       limit 1)"
                + " when"
                + " (select  concat('1',' ',d.leave_type) as leaveDay"
                + "                        from                 "
                + "                            leave_employee_detail c,"
                + "                             leave_type_master d"
                + "                        where c.employee_master_id = " + leaveEmployeeDetail.getEmployeeMaster().getId()
                + "                              and c.leave_type_id=d.id "
                + "                              and c.status = 3"
                + "                        and DATE_FORMAT(STR_TO_DATE(c.approve_date,'%d/%m/%Y'),'%m')= DATE_FORMAT(STR_TO_DATE('" + leaveEmployeeDetail.getApproveDate() + "','%Y-%m-%d'),'%m')"
                + "                             and STR_TO_DATE(selected_date, '%Y-%m-%d')    between"
                + "                             STR_TO_DATE(c.start_date, '%d/%m/%Y') and   STR_TO_DATE(c.end_date, '%d/%m/%Y') "
                + " limit 1)is not null"
                + " then"
                + " (select concat('1',' ',d.leave_type) as leaveDay"
                + "                        from"
                + "                            leave_employee_detail c,"
                + "                             leave_type_master d"
                + "                        where c.employee_master_id = " + leaveEmployeeDetail.getEmployeeMaster().getId()
                + "                                and c.leave_type_id=d.id "
                + "                               and c.status = 3"
                + "                        and DATE_FORMAT(STR_TO_DATE(c.approve_date,'%d/%m/%Y'),'%m')= DATE_FORMAT(STR_TO_DATE('" + leaveEmployeeDetail.getApproveDate() + "','%d/%m/%Y'),'%m')"
                + "                             and STR_TO_DATE(selected_date, '%Y-%m-%d')    between"
                + "                             STR_TO_DATE(c.start_date, '%d/%m/%Y') and STR_TO_DATE(c.end_date, '%d/%m/%Y'))"
                + " else 'AB'"
                + "    end"
                + " from"
                + "    (select"
                + "        adddate('1970-01-01', t4 * 10000 + t3 * 1000 + t2 * 100 + t1 * 10 + t0) selected_date"
                + "    from"
                + "        (select 0 t0 union select 1 union select 2 union select 3 union select 4 union select 5 union select 6 union select 7 union select 8 union select 9) t0, (select 0 t1 union select 1 union select 2 union select 3 union select 4 union select 5 union select 6 union select 7 union select 8 union select 9) t1, (select 0 t2 union select 1 union select 2 union select 3 union select 4 union select 5 union select 6 union select 7 union select 8 union select 9) t2, (select 0 t3 union select 1 union select 2 union select 3 union select 4 union select 5 union select 6 union select 7 union select 8 union select 9) t3, (select 0 t4 union select 1 union select 2 union select 3 union select 4 union select 5 union select 6 union select 7 union select 8 union select 9) t4) v"
                + " where selected_date between '" + leaveEmployeeDetail.getStartDate() + "' and '" + leaveEmployeeDetail.getEndDateStatus() + "'";

        Query query1 = getSession().createSQLQuery(query);
        List results = query1.list();
        Iterator iterator = results.iterator();
        while (iterator.hasNext()) {
             Object[] value = (Object[]) iterator.next();
            if ("AB".equals(value[1]) || "WO".equals(value[1])) {
                iterator.remove();
            }
        }
        return results;
    }

    @Override
    public List<?> dateWiseLeaveSelectionOfEmployee(T object) {
        LeaveEmployeeDetail leaveEmployeeDetail = (LeaveEmployeeDetail) object;
        String query = "";
        query += " FROM LeaveEmployeeDetail a"
                + " WHERE a.employeeMaster = " + leaveEmployeeDetail.getEmployeeMaster().getId()
                + " AND STR_TO_DATE(a.startDate,'%d/%m/%Y') = STR_TO_DATE('" + leaveEmployeeDetail.getStartDate() + "','%d/%m/%Y')";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> viewEmpLeaveRequestForPowerAdmin() {
        String query = "";

        query += " Select c.employeeName, b.leaveType, a.startDate, a.endDate, a.noOfDays, a.id, a.status, d.id"
                + " FROM LeaveEmployeeDetail a"
                + " LEFT JOIN a.leaveTypeMaster b"
                + " LEFT JOIN a.employeeMaster c"
                + " LEFT JOIN c.userMaster d"
                + " WHERE a.status In (0,4)"
                + "Order by a.id Desc";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readApprovedShortLeaveDays(T object) {
        LeaveEmployeeDetail leaveEmployeeDetail = (LeaveEmployeeDetail) object;
        String query = "";
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/YYYY");
        String s = formatter.format(date);
        query += " Select SUM(a.noOfDays)"
                + " FROM LeaveEmployeeDetail a"
                + " LEFT JOIN a.leaveTypeMaster b"
                + " WHERE a.employeeMaster = " + leaveEmployeeDetail.getEmployeeMaster().getId()
                + " AND a.leaveTypeMaster = " + leaveEmployeeDetail.getLeaveTypeMaster().getId()
                + " AND DATE_FORMAT(STR_TO_DATE(a.startDate,'%d/%m/%Y'),'%m')= DATE_FORMAT(STR_TO_DATE('" + s + "','%d/%m/%Y'),'%m')"
                + " AND DATE_FORMAT(STR_TO_DATE(a.startDate,'%d/%m/%Y'),'%Y')= DATE_FORMAT(STR_TO_DATE('" + s + "','%d/%m/%Y'),'%Y')"
                + " AND a.status in (0,3)";

        return getHibernateTemplate().find(query);
    }

    @Override
    public int readPendingLeaveRequestForDashboard(T object) {
        LeaveEmployeeDetail leaveEmployeeDetail = (LeaveEmployeeDetail) object;
        String query = "";
        query += " Select count(a.id)"
                + " FROM LeaveEmployeeDetail a"
                + " LEFT JOIN a.leaveTypeMaster b"
                + " WHERE a.employeeMaster = " + leaveEmployeeDetail.getEmployeeMaster().getId()
                + " AND a.status =0";

        List<?> finalList = getHibernateTemplate().find(query);
        return Integer.parseInt("" + finalList.get(0));
    }

    @Override
    public int readPendingApproverLeaveRequestForDashboard(T object) {
        LeaveEmployeeDetail leaveEmployeeDetail = (LeaveEmployeeDetail) object;
        String query = "";

        query += " Select count(a.id)"
                + " FROM LeaveEmployeeDetail a,"
                + " EmployeeMaster b"
                + " WHERE a.employeeMaster=b.id"
                + " and b.reportingManagerLevel1=" + leaveEmployeeDetail.getEmployeeMaster().getId()
                + " AND a.status =0";

        List<?> finalList = getHibernateTemplate().find(query);
        return Integer.parseInt("" + finalList.get(0));
    }

    @Override
    public int readWithdrawPendingApproverLeaveRequestForDashboard(T object) {
        LeaveEmployeeDetail leaveEmployeeDetail = (LeaveEmployeeDetail) object;
        String query = "";
        query += " Select count(a.id)"
                + " FROM LeaveEmployeeDetail a,"
                + " EmployeeMaster b"
                + " WHERE a.employeeMaster=b.id"
                + " and b.reportingManagerLevel1=" + leaveEmployeeDetail.getEmployeeMaster().getId()
                + " AND a.status = 4";

        List<?> finalList = getHibernateTemplate().find(query);
        return Integer.parseInt("" + finalList.get(0));
    }

    @Override
    public List<?> readEmpLeaveListDetail(T object) {
        LeaveEmployeeDetail leaveEmployeeDetail = (LeaveEmployeeDetail) object;
        String query = "";
        String condition = "";

        if (!"".equals(leaveEmployeeDetail.getStartDate()) && null != leaveEmployeeDetail.getStartDate()
                && !"".equals(leaveEmployeeDetail.getEndDate()) && null != leaveEmployeeDetail.getEndDate()) {
            condition += " AND a.startDate BETWEEN '" + leaveEmployeeDetail.getStartDate() + "' AND '" + leaveEmployeeDetail.getEndDate() + "' ";
        }
        if (null != leaveEmployeeDetail.getLeaveTypeMaster() && !"".equals(leaveEmployeeDetail.getLeaveTypeMaster())) {
            condition += " AND b.id = '" + leaveEmployeeDetail.getLeaveTypeMaster().getId() + "'";
        }

        query += " Select b.leaveType, a.startDate, a.endDate, a.noOfDays, a.id, a.status, a.empRemark, (Select c.employeeName from EmployeeMaster c where c.id=a.approverId) as ApproveName  "
                + " FROM LeaveEmployeeDetail a"
                + " LEFT JOIN a.leaveTypeMaster b"
                + " WHERE a.employeeMaster = " + leaveEmployeeDetail.getEmployeeMaster().getId()
                + " AND a.status !=5" + condition
                + " ORDER BY a.id desc";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readDate(T object) {
        LeaveEmployeeDetail leaveEmployeeDetail = (LeaveEmployeeDetail) object;
        String query = "from LeaveEmployeeDetail a"
                + " WHERE a.status !=5"
                + " AND a.id !=" + leaveEmployeeDetail.getId()
                + " AND a.employeeMaster = " + leaveEmployeeDetail.getEmployeeMaster().getId()
                + " AND STR_TO_DATE(a.startDate,'%d/%m/%Y')>=STR_TO_DATE('" + leaveEmployeeDetail.getStartDate() + "','%d/%m/%Y')"
                + " AND STR_TO_DATE(a.startDate,'%d/%m/%Y')<=STR_TO_DATE('" + leaveEmployeeDetail.getEndDate() + "','%d/%m/%Y')"
                + " AND STR_TO_DATE(a.endDate,'%d/%m/%Y')>=STR_TO_DATE('" + leaveEmployeeDetail.getStartDate() + "','%d/%m/%Y')"
                + " AND STR_TO_DATE(a.endDate,'%d/%m/%Y')<=STR_TO_DATE('" + leaveEmployeeDetail.getEndDate() + "','%d/%m/%Y')";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> leaveCheck(T object) {
        LeaveEmployeeDetail leaveEmployeeDetail = (LeaveEmployeeDetail) object;
        String query = "from LeaveEmployeeDetail a"
                + " WHERE a.status !=5"
                + " AND a.employeeMaster = " + leaveEmployeeDetail.getEmployeeMaster().getId()
                + " AND STR_TO_DATE(a.endDate,'%d/%m/%Y')=STR_TO_DATE('" + leaveEmployeeDetail.getStartDate() + "','%d/%m/%Y')";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> leaveCheckStartDate(T object) {
        LeaveEmployeeDetail leaveEmployeeDetail = (LeaveEmployeeDetail) object;
        String query = "from LeaveEmployeeDetail a"
                + " WHERE a.status !=5"
                + " AND a.employeeMaster = " + leaveEmployeeDetail.getEmployeeMaster().getId()
                + " AND STR_TO_DATE(a.startDate,'%d/%m/%Y')=STR_TO_DATE('" + leaveEmployeeDetail.getStartDate() + "','%d/%m/%Y')";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> plLeaveCheck(int empId) {
        Date date1 = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/YYYY");
        String s = formatter.format(date1);
        String query = "from LeaveEmployeeDetail a"
                + " WHERE a.status !=5"
                + " AND a.employeeMaster.id = " + empId
                + " AND DATE_FORMAT(STR_TO_DATE(a.startDate,'%d/%m/%Y'),'%Y')= DATE_FORMAT(STR_TO_DATE('" + s + "','%d/%m/%Y'),'%Y')"
                + " AND a.leaveTypeMaster.id=" + 7
                + " AND a.noOfDays<3";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readLeaveDetails(T object) {
        LeaveEmployeeDetail leaveEmployeeDetail = (LeaveEmployeeDetail) object;
        String query = "";
        String condition = "";

        if (null != leaveEmployeeDetail.getStartDate() && !"".equals(leaveEmployeeDetail.getStartDate())) {
//            condition += " AND STR_TO_DATE(a.startDate,'%d/%m/%Y') >= STR_TO_DATE('" + leaveEmployeeDetail.getStartDate() + "','%d/%m/%Y')";
            condition += " and STR_TO_DATE('" + leaveEmployeeDetail.getStartDate() + "','%d/%m/%Y') "
                    + "  between STR_TO_DATE(a.startDate, '%d/%m/%Y') "
                    + "  and STR_TO_DATE(a.endDate, '%d/%m/%Y') ";
        }
//        if (null != leaveEmployeeDetail.getEndDate() && !"".equals(leaveEmployeeDetail.getEndDate())) {
//            condition += " AND STR_TO_DATE(a.endDate,'%d/%m/%Y') <= STR_TO_DATE('" + leaveEmployeeDetail.getEndDate() + "','%d/%m/%Y')";
//        }
        if (null != leaveEmployeeDetail.getLeaveTypeMaster() && !"".equals(leaveEmployeeDetail.getLeaveTypeMaster())) {
            condition += " AND b.id = '" + leaveEmployeeDetail.getLeaveTypeMaster().getId() + "'";
        }
        if (!"".equals(leaveEmployeeDetail.getStatus())) {
            condition += " AND a.status = " + leaveEmployeeDetail.getStatus();
        }

        query += " Select b.leaveType, a.startDate, a.endDate, a.noOfDays, a.id, a.status,a.startDateStatus, a.endDateStatus"
                + " FROM LeaveEmployeeDetail a"
                + " LEFT JOIN a.leaveTypeMaster b"
                + " WHERE a.employeeMaster = " + leaveEmployeeDetail.getEmployeeMaster().getId()
                + condition;

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> leaveApplicationRequest(T object) {
        LeaveEmployeeDetail leaveEmployeeDetail = (LeaveEmployeeDetail) object;
        String query = "";

        query += " Select b.leaveType, a.startDate, a.startDateStatus, a.endDate, a.endDateStatus, a.noOfDays, a.empRemark, a.status, a.hrRemark"
                + " FROM LeaveEmployeeDetail a"
                + " LEFT JOIN a.leaveTypeMaster b"
                + " LEFT JOIN a.employeeMaster c"
                + " LEFT JOIN c.userMaster d"
                + " WHERE c.id=" + leaveEmployeeDetail.getEmployeeMaster().getId()
                + " AND a.id=" + leaveEmployeeDetail.getId();

        return getHibernateTemplate().find(query);
    }

}
