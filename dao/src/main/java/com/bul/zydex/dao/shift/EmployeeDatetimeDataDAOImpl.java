/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.shift;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.EmployeeDatetimeData;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.exolab.castor.types.DateTime;

/**
 *
 * @author AJAY
 */
public class EmployeeDatetimeDataDAOImpl<T> extends GenericsDAOImpl<T> implements EmployeeDatetimeDataDAO<T> {

    @Override
    protected Class getDomainClass() {
        return EmployeeDatetimeData.class;
    }

    @Override
    public List<?> readTodaysAndPreviousData(String empId, String endShiftTime) {
        String query = "";
        Date date = new Date();
        Date dateBefore = new Date(date.getTime() - 24 * 60 * 60 * 1000);
        Format formatter = new SimpleDateFormat("dd/MM/YYYY");
        String s = formatter.format(date);
//          String s = "01/07/2016";
//          String s1 = "30/06/2016";
        String s1 = formatter.format(dateBefore);
        query += " From EmployeeDatetimeData a "
                + " Where STR_TO_DATE(a.dateTime,'%d/%m/%Y %H:%i:%s') BETWEEN STR_TO_DATE('" + s1 + " " + endShiftTime + ":00','%d/%m/%Y %H:%i:%s') AND (STR_TO_DATE('" + s + " 23:59:00','%d/%m/%Y %H:%i:%s'))"
                + " And a.employeeMaster.id=" + empId
                + " GROUP BY STR_TO_DATE(a.dateTime,'%d/%m/%Y %H:%i')"
                + " ORDER BY STR_TO_DATE(a.dateTime,'%d/%m/%Y %H:%i:%s') ASC";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readPuchDataDateWise(String date, int empId) {
        String query = "";
        query += " select a.dateTime,c.zydexLocation"
                + " From EmployeeDatetimeData a "
                + " left join a.deviceMaster b"
                + " left join b.zydexLocationMaster c"
                + " where a.employeeMaster.id = " + empId
                + " and DATE_FORMAT(STR_TO_DATE(a.dateTime,'%d/%m/%Y'),'%d/%m/%Y') = DATE_FORMAT(STR_TO_DATE('" + date + "','%d/%m/%Y'),'%d/%m/%Y') "
                + " GROUP BY STR_TO_DATE(a.dateTime,'%d/%m/%Y %H:%i')"
                + " ORDER BY STR_TO_DATE(a.dateTime,'%d/%m/%Y %H:%i:%s') ASC";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readPuchDataEmpIdWise(int empId) {
        String query = "";
        query += " "
                + " From EmployeeDatetimeData a "
                + " where a.employeeMaster.id = " + empId + " order by STR_TO_DATE(a.dateTime,'%d/%m/%Y %H:%i:%s') asc"
                + " GROUP BY STR_TO_DATE(a.dateTime,'%d/%m/%Y %H:%i')";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readTodaysEmployeeData(String empId) {
        String query = "";
        Date date = new Date();
        Date dateBefore = new Date(date.getTime() - 24 * 60 * 60 * 1000);
        Format formatter = new SimpleDateFormat("dd/MM/YYYY");
        String s = formatter.format(date);
//        String s = "02/07/2016";
//        String s1 = formatter.format(dateBefore);
        query += " From EmployeeDatetimeData a "
                + " Where STR_TO_DATE(a.dateTime,'%d/%m/%Y') IN (STR_TO_DATE('" + s + "','%d/%m/%Y'),STR_TO_DATE('" + s + "','%d/%m/%Y'))"
                + " And a.employeeMaster.id=" + empId
                + " GROUP BY a.dateTime"
                + " ORDER BY STR_TO_DATE(a.dateTime,'%d/%m/%Y %H:%i:%s') ASC";

        return getHibernateTemplate().find(query);
    }

//    Ajay Start
    @Override
    public List<?> readEmployeeByCurrentDate() {
        String query = "";
        Date date = new Date();
        Format formatter = new SimpleDateFormat("dd/MM/YYYY");
        String s = formatter.format(date);
//        String s = "02/07/2016";
        query += " From EmployeeDatetimeData a "
                + " Where STR_TO_DATE(a.dateTime,'%d/%m/%Y') IN (STR_TO_DATE('" + s + "','%d/%m/%Y'))"
                + " GROUP BY a.employeeMaster.id";

        return getHibernateTemplate().find(query);
    }
//    Ajay End

    @Override
    public List<?> todaysData(int id) {
        String query = "";
        Date date = new Date();
        Format formatter = new SimpleDateFormat("dd/MM/YYYY");
        Date dateBefore = new Date(date.getTime() - 24 * 60 * 60 * 1000);
        String s1 = formatter.format(dateBefore);
        query += " From EmployeeDatetimeData a "
                + "Where STR_TO_DATE(a.dateTime,'%d/%m/%Y') = STR_TO_DATE('" + s1 + "','%d/%m/%Y')"
                + " And a.employeeMaster.id=" + id;

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readYesterdayEmployeeData(String empId) {
        String query = "";
        Date date = new Date();
        Date dateBefore = new Date(date.getTime() - 24 * 60 * 60 * 1000);
        Format formatter = new SimpleDateFormat("dd/MM/YYYY");
        String s1 = formatter.format(dateBefore);
//        String s1 = "01/07/2016";
        query += " From EmployeeDatetimeData a "
                + " Where STR_TO_DATE(a.dateTime,'%d/%m/%Y') IN (STR_TO_DATE('" + s1 + "','%d/%m/%Y'),STR_TO_DATE('" + s1 + "','%d/%m/%Y'))"
                + " And a.employeeMaster.id=" + empId
                + " GROUP BY a.dateTime"
                + " ORDER BY STR_TO_DATE(a.dateTime,'%d/%m/%Y %H:%i:%s') ASC";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readEmployeeBySelectedDate(String date) {
        String query = "";
        query += " From EmployeeDatetimeData a "
                + " Where STR_TO_DATE(a.dateTime,'%d/%m/%Y') IN (STR_TO_DATE('" + date + "','%d/%m/%Y'))"
                + " GROUP BY a.employeeMaster.id";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readYesterdayEmployeeDataBySelectedDate(String empId, String date) {
        String query = " From EmployeeDatetimeData a "
                + " Where STR_TO_DATE(a.dateTime,'%d/%m/%Y') IN (STR_TO_DATE('" + date + "','%d/%m/%Y'),STR_TO_DATE('" + date + "','%d/%m/%Y'))"
                + " And a.employeeMaster.id=" + empId
                + " GROUP BY a.dateTime"
                + " ORDER BY STR_TO_DATE(a.dateTime,'%d/%m/%Y %H:%i:%s') ASC";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readTodaysAndPreviousDataOnSelectedDate(String empId, String endShiftTime, String selectDate, String PreviousDate) {
        String query = " From EmployeeDatetimeData a "
                + " Where STR_TO_DATE(a.dateTime,'%d/%m/%Y %H:%i:%s') BETWEEN STR_TO_DATE('" + PreviousDate + " " + endShiftTime + ":00','%d/%m/%Y %H:%i:%s') AND (STR_TO_DATE('" + selectDate + " 23:59:00','%d/%m/%Y %H:%i:%s'))"
                + " And a.employeeMaster.id=" + empId
                + " GROUP BY STR_TO_DATE(a.dateTime,'%d/%m/%Y %H:%i')"
                + " ORDER BY STR_TO_DATE(a.dateTime,'%d/%m/%Y %H:%i:%s') ASC";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readSelectedDateEmployeeData(String empId, String date) {
        String query = " From EmployeeDatetimeData a "
                + " Where STR_TO_DATE(a.dateTime,'%d/%m/%Y') IN (STR_TO_DATE('" + date + "','%d/%m/%Y'),STR_TO_DATE('" + date + "','%d/%m/%Y'))"
                + " And a.employeeMaster.id=" + empId
                + " GROUP BY a.dateTime"
                + " ORDER BY STR_TO_DATE(a.dateTime,'%d/%m/%Y %H:%i:%s') ASC";

        return getHibernateTemplate().find(query);
    }
//    Rishi Start

    @Override
    public List<?> readEmployeeByDatevise(String date) {
        String query = "";
//        String s = "02/07/2016";
        query += " From EmployeeDatetimeData a "
                + " Where STR_TO_DATE(a.dateTime,'%d/%m/%Y') IN (STR_TO_DATE('" + date + "','%d/%m/%Y'))"
                + " GROUP BY a.employeeMaster.id";

        return getHibernateTemplate().find(query);
    }
//    Rishi End

//    Rishi End
    @Override
    public List<?> readEmployeePunchDateWise(int empId, String Date) {
        String query = "";

//        String s = "02/07/2016";
        query += " From EmployeeDatetimeData a "
                + " Where STR_TO_DATE(a.dateTime,'%d/%m/%Y') IN (STR_TO_DATE('" + Date + "','%d/%m/%Y'),STR_TO_DATE('" + Date + "','%d/%m/%Y'))"
                + " And a.employeeMaster.id=" + empId
                + " GROUP BY a.employeeMaster.id"
                + " ORDER BY STR_TO_DATE(a.dateTime,'%d/%m/%Y %H:%i:%s') ASC";

        return getHibernateTemplate().find(query);

    }

    @Override
    public List<?> readOddPunchedEmployeeData(String Date) {
        String query = "";

        query += " Select b.employeeId,b.employeeName,b.id,count(b.id) From EmployeeDatetimeData a "
                + " left join a.employeeMaster b "
                + " Where STR_TO_DATE(a.dateTime,'%d/%m/%Y') = STR_TO_DATE('" + Date + "','%d/%m/%Y')"
                + " group by b.id ";

        return getHibernateTemplate().find(query);

    }


}
