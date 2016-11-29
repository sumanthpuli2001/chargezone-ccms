/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.mobileapp;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.EmployeePunchForMobileApp;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author admin
 */
public class EmployeePunchForMobileAppDAOImpl<T> extends GenericsDAOImpl<T> implements EmployeePunchForMobileAppDAO<T> {

    @Override
    protected Class getDomainClass() {
        return EmployeePunchForMobileApp.class;
    }

    @Override
    public List<?> readEmpByCurrentDate() {
        String query = "";
        Date date = new Date();
        Format formatter = new SimpleDateFormat("dd/MM/YYYY");
        String s = formatter.format(date);
//        String s = "02/07/2016";
        query += " From EmployeePunchForMobileApp a "
                + " Where STR_TO_DATE(a.punchTime,'%d/%m/%Y') IN (STR_TO_DATE('" + s + "','%d/%m/%Y'))"
                + " GROUP BY a.employeeMaster.id";

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
        query += " From EmployeePunchForMobileApp a "
                + " Where STR_TO_DATE(a.punchTime,'%d/%m/%Y') IN (STR_TO_DATE('" + s1 + "','%d/%m/%Y'),STR_TO_DATE('" + s1 + "','%d/%m/%Y'))"
                + " And a.employeeMaster.id=" + empId
                + " GROUP BY a.punchTime"
                + " ORDER BY STR_TO_DATE(a.punchTime,'%d/%m/%Y %H:%i:%s') ASC";

        return getHibernateTemplate().find(query);
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
        query += " From EmployeePunchForMobileApp a "
                + " Where STR_TO_DATE(a.punchTime,'%d/%m/%Y %H:%i:%s') BETWEEN STR_TO_DATE('" + s1 + " " + endShiftTime + ":00','%d/%m/%Y %H:%i:%s') AND (STR_TO_DATE('" + s + " 23:59:00','%d/%m/%Y %H:%i:%s'))"
                + " And a.employeeMaster.id=" + empId
                + " GROUP BY STR_TO_DATE(a.punchTime,'%d/%m/%Y %H:%i')"
                + " ORDER BY STR_TO_DATE(a.punchTime,'%d/%m/%Y %H:%i:%s') ASC";

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
        query += " From EmployeePunchForMobileApp a "
                + " Where STR_TO_DATE(a.punchTime,'%d/%m/%Y') IN (STR_TO_DATE('" + s + "','%d/%m/%Y'),STR_TO_DATE('" + s + "','%d/%m/%Y'))"
                + " And a.employeeMaster.id=" + empId
                + " GROUP BY a.punchTime"
                + " ORDER BY STR_TO_DATE(a.punchTime,'%d/%m/%Y %H:%i:%s') ASC";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readPuchDataDateWise(String date, int empId) {
         String query = "";
        query += " select a.punchTime,a.punchLocation"
                + " From EmployeePunchForMobileApp a "
                + " where a.employeeMaster.id = " + empId
                + " and DATE_FORMAT(STR_TO_DATE(a.punchTime,'%d/%m/%Y'),'%d/%m/%Y') = DATE_FORMAT(STR_TO_DATE('" + date + "','%d/%m/%Y'),'%d/%m/%Y') "
                + " GROUP BY STR_TO_DATE(a.punchTime,'%d/%m/%Y %H:%i')"
                + " ORDER BY STR_TO_DATE(a.punchTime,'%d/%m/%Y %H:%i:%s') ASC";
        return getHibernateTemplate().find(query);
        
    }

}
