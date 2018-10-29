/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.policy;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.EmployeeCtcDetail;
import com.bul.zydex.model.EmployeeMaster;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

/**
 *
 * @author Hussain
 */
public class EmployeeCtcDetailDAOImpl<T> extends GenericsDAOImpl<T> implements EmployeeCtcDetailDAO<T> {

    @Override
    protected Class getDomainClass() {
        return EmployeeCtcDetail.class;
    }

    @Override
    public List<?> fetchctcData(int empId) {
        String query = "";
        query += " select b.id,b.ctcName,a.amount,a.status,a.month,a.year,a.id"
                + " FROM EmployeeCtcDetail a "
                + " left join a.ctcAllowance b"
                + " left join a.employeeMaster c"
                + " where c.id=" + empId;

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readctc(int employeeid) {
        String query = "";
        query += "select a.amount,b.ctcName"
                + " FROM EmployeeCtcDetail a "
                + " left join a.ctcAllowance b"
                + " where a.employeeMaster.id=" + employeeid;

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readEmployeeCtcDetail(int employeeid) {
        String query = "";
        query += "select a.amount,b.ctcName,b.id,a.month,a.year"
                + " FROM EmployeeCtcDetail a "
                + " left join a.ctcAllowance b"
                + " where a.employeeMaster.id=" + employeeid;

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readByEmployeCtcReport(int employeeid, String month, String year) {
        String query = "";
        query += "select a"
                + " FROM EmployeeCtcDetail a "
                + " left join a.ctcAllowance b"
                + " where a.employeeMaster.id=" + employeeid
                + " and a.year = '" + year + "'"
                + " and a.month = '" + month + "'";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> empid(int employeeid) {

//        String query = "SELECT b.id, b.ctcAllowance, b.employeeMaster, b.amount, b.monthly, b.yearly"
//                + " FROM EmployeeCtcDetail a "
//                + " INNER JOIN EmployeeCtcDetailSalary b ON  b.monthly = a.month "
//                + " WHERE b.employeeMaster=" + employeeid 
//                + " group by b.ctcAllowance";
        Session s = getSessionFactory().openSession();
        String sqlString = "SELECT"
                + "  b.id, b.ctc_allowance_id, b.employee_master_id, b.amount, b.month , b.year"
                + " FROM"
                + " hr_power_astral.employee_ctc_detail a"
                + " INNER JOIN"
                + " hr_power_astral.employee_ctc_detail_salary b"
                + " ON b.monthly  = a.month"
                + " WHERE  b.employee_master_id =" + employeeid
                + " and  a.ctc_master_id!=3"
                + " group by b.ctc_allowance_id";
        SQLQuery query = s.createSQLQuery(sqlString);
        List<?> list = query.list();
        s.close();
//        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> CtcDetailempid(int employeeid) {
        String query = "SELECT a"
                + " FROM EmployeeCtcDetail a "
                + " WHERE a.employeeMaster=" + employeeid;

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readctcRegistration(int employeeid) {
        String query = "";
        query += "select a"
                + " FROM EmployeeCtcDetail a "
                + " left join a.ctcAllowance b"
                + " where a.employeeMaster.id=" + employeeid;

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> CtcDetailempidMasterSalary(int employeeid, int ctcAllowanceId) {
        String query = " Select c.ctcName,a.amount"
                + " From EmployeeCtcDetail a"
                + " left join a.ctcAllowance c"
                + " where a.employeeMaster.id=" + employeeid
                + " and c.id=" + ctcAllowanceId;

        return getHibernateTemplate().find(query);
    }

    public List<?> GratuietyFiveYrFetch(int employeeid) {
//        String query = " Select b.id, a.ctcAllowance, a.amount, a.month, a.year, b.dateOfJoining"
//                + " FROM EmployeeCtcDetail a"
//                + " left join a.employeeMaster b"
//                + " WHERE b.id =" + employeeid
////                + " and FLOOR(datediff(CURDATE(),STR_TO_DATE(b.dateOfJoining, '%d/%m/%Y')) / 1825)"
//                + " and a.ctcAllowance = 3";
//
//        return getHibernateTemplate().find(query);

        Session s = getSessionFactory().openSession();
        String sqlString = "SELECT"
                + "  b.id, a.ctc_master_id, a.amount, a.month, a.year"
                + " FROM"
                + " hr_power_astral.employee_ctc_detail a"
                + " left join"
                + " hr_power_astral.employee_master b"
                + " ON a.employee_master_id = b.id"
                + " WHERE b.id =" + employeeid
                + " and FLOOR(datediff(CURDATE(),STR_TO_DATE(b.date_of_joining, '%d/%m/%Y')) / 1825)"
                + " and a.ctc_master_id = 3";
        SQLQuery query = s.createSQLQuery(sqlString);
        List<?> list = query.list();
        s.close();
//        List<?> list = getHibernateTemplate().find(query);
        return list;

    }

    @Override
    public List<?> bonusFetch(int employeeid) {
        String query = "SELECT a.id, a.amount, a.month, a.year"
                + " FROM EmployeeCtcDetailSalary a "
                + " WHERE a.employeeMaster=" + employeeid
                + " AND a.ctcAllowance = 2";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }
}
