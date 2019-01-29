/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.shift;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.ShiftGenerateMonthlySchedule;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author AJAY
 */
public class ShiftGenerateMonthlyScheduleDAOImpl<T> extends GenericsDAOImpl<T> implements ShiftGenerateMonthlyScheduleDAO<T> {

    @Override
    protected Class getDomainClass() {
        return ShiftGenerateMonthlySchedule.class;
    }

    @Override
    public List<?> readByEmployeeShift(T object) {
        ShiftGenerateMonthlySchedule shiftGenerateMonthlySchedule = (ShiftGenerateMonthlySchedule) object;
        String query = "";

        query += " FROM ShiftGenerateMonthlySchedule a"
                + " Where a.employeeMaster=" + shiftGenerateMonthlySchedule.getEmployeeMaster().getId();

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readByCurrentDateWiseEmployeeShift(T object) {
        ShiftGenerateMonthlySchedule shiftGenerateMonthlySchedule = (ShiftGenerateMonthlySchedule) object;
        String query = "";

        query += " FROM ShiftGenerateMonthlySchedule a"
                + " Where a.employeeMaster=" + shiftGenerateMonthlySchedule.getEmployeeMaster().getId()
                + " and a.shiftMonth=" + shiftGenerateMonthlySchedule.getShiftMonth()
                + " and a.shiftYear=" + shiftGenerateMonthlySchedule.getShiftYear();

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readByDayWiseEmployeeShiftData(T object, int day) {
        ShiftGenerateMonthlySchedule shiftGenerateMonthlySchedule = (ShiftGenerateMonthlySchedule) object;
        String query = "";

        query += "SELECT concat(day_" + day + ") FROM ShiftGenerateMonthlySchedule a"
                + " Where a.employeeMaster=" + shiftGenerateMonthlySchedule.getEmployeeMaster().getId()
                + " and a.shiftMonth=" + Integer.parseInt(shiftGenerateMonthlySchedule.getShiftMonth())
                + " and a.shiftYear=" + Integer.parseInt(shiftGenerateMonthlySchedule.getShiftYear());

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> employeeListReadByMonth(int month, int year) {
        String query = "";
        query += " Select a.id,b.employeeId,b.employeeName,b.id"
                + " FROM ShiftGenerateMonthlySchedule a"
                + " LEFT JOIN a.employeeMaster b"
                + " Where a.shiftMonth = " + month
                + " And a.shiftYear =" + year
                + " and b.employeeId != 'admin' and ((b.dateOfLeaving is null or b.dateOfLeaving = '') "
                + " or STR_TO_DATE(b.dateOfLeaving,'%d/%m/%Y - %H:%i') > now())";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> employeeMonthlyShiftDetail(int id) {
        String query = "";
        query += " Select"
                + "(Select shiftName From ShiftMaster b where b.id=a.day1) as day1 ,"
                + "(Select shiftName From ShiftMaster b where b.id=a.day2) as day2 ,"
                + "(Select shiftName From ShiftMaster b where b.id=a.day3) as day3 ,"
                + "(Select shiftName From ShiftMaster b where b.id=a.day4) as day4 ,"
                + "(Select shiftName From ShiftMaster b where b.id=a.day5) as day5 ,"
                + "(Select shiftName From ShiftMaster b where b.id=a.day6) as day6 ,"
                + "(Select shiftName From ShiftMaster b where b.id=a.day7) as day7 ,"
                + "(Select shiftName From ShiftMaster b where b.id=a.day8) as day8 ,"
                + "(Select shiftName From ShiftMaster b where b.id=a.day9) as day9 ,"
                + "(Select shiftName From ShiftMaster b where b.id=a.day10) as day10 ,"
                + "(Select shiftName From ShiftMaster b where b.id=a.day11) as day11 ,"
                + "(Select shiftName From ShiftMaster b where b.id=a.day12) as day12 ,"
                + "(Select shiftName From ShiftMaster b where b.id=a.day13) as day13 ,"
                + "(Select shiftName From ShiftMaster b where b.id=a.day14) as day14 ,"
                + "(Select shiftName From ShiftMaster b where b.id=a.day15) as day15 ,"
                + "(Select shiftName From ShiftMaster b where b.id=a.day16) as day16 ,"
                + "(Select shiftName From ShiftMaster b where b.id=a.day17) as day17 ,"
                + "(Select shiftName From ShiftMaster b where b.id=a.day18) as day18 ,"
                + "(Select shiftName From ShiftMaster b where b.id=a.day19) as day19 ,"
                + "(Select shiftName From ShiftMaster b where b.id=a.day20) as day20 ,"
                + "(Select shiftName From ShiftMaster b where b.id=a.day21) as day21 ,"
                + "(Select shiftName From ShiftMaster b where b.id=a.day22) as day22 ,"
                + "(Select shiftName From ShiftMaster b where b.id=a.day23) as day23 ,"
                + "(Select shiftName From ShiftMaster b where b.id=a.day24) as day24 ,"
                + "(Select shiftName From ShiftMaster b where b.id=a.day25) as day25 ,"
                + "(Select shiftName From ShiftMaster b where b.id=a.day26) as day26 ,"
                + "(Select shiftName From ShiftMaster b where b.id=a.day27) as day27 ,"
                + "(Select shiftName From ShiftMaster b where b.id=a.day28) as day28 ,"
                + "(Select shiftName From ShiftMaster b where b.id=a.day29) as day29 ,"
                + "(Select shiftName From ShiftMaster b where b.id=a.day30) as day30 ,"
                + "(Select shiftName From ShiftMaster b where b.id=a.day31) as day31 "
                + " FROM ShiftGenerateMonthlySchedule a"
                + " Where a.id = " + id;
        return getHibernateTemplate().find(query);

    }

    @Override
    public List<?> readDayWiseShift(int id, int dayNo) {
        String query = "";

        query += "SELECT concat(day_" + dayNo + ") FROM ShiftGenerateMonthlySchedule a"
                + " Where a.id=" + id;

        return getHibernateTemplate().find(query);

    }

    @Override
    public void updateDayWiseShift(int id, int dayNo, int shiftId) {

//       
        Session s = getSessionFactory().openSession();
        String sqlString = "update"
                + " hr_power_astral.shift_generate_monthly_schedule a"
                + " SET a.day_" + dayNo + " =" + shiftId
                + " where a.id =" + id;

        SQLQuery sqlQuery = s.createSQLQuery(sqlString);
        sqlQuery.executeUpdate();
        s.close();
//      

    }

    @Override
    public List<?> ReadEmployeeShiftByMonthYear(int empID, int month, int year) {
        String query = "";
        query += " Select a"
                + " FROM ShiftGenerateMonthlySchedule a"
                + " LEFT JOIN a.employeeMaster b"
                + " Where b.id=" + empID
                + " And a.shiftMonth = " + month
                + " And a.shiftYear =" + year;
        return getHibernateTemplate().find(query);
    }

    @Override
    public void updateDayWiseShiftReguration(int id, int dayNo) {
        String query = "";

        query += "UPDATE ShiftGenerateMonthlySchedule SET concat(day_" + dayNo + ")"
                + " Where a.id=" + id;
    }

    @Override
    public List<?> employeeListReadByMonthWoff(int month, int year, int empID) {
        String query = "";
        query += " Select a.id,b.employeeId,b.employeeName,b.id"
                + " FROM ShiftGenerateMonthlySchedule a"
                + " LEFT JOIN a.employeeMaster b"
                + " Where a.shiftMonth = " + month
                + " And a.shiftYear =" + year
                + " And b.id =" + empID;
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> ReadEmployeeShiftByDayMonthYear(Integer empID, String date) {

        String query = "";

        try {
            Date getDate = new SimpleDateFormat("dd/MM/yyyy").parse(date);
            Calendar cal = Calendar.getInstance();
            cal.setTime(getDate);
            int day = cal.get(Calendar.DAY_OF_MONTH);
            int month = cal.get(Calendar.MONTH);
            int year = cal.get(Calendar.YEAR);
            if (month != 12) {
                month++;
            }
            query += " Select "
                    + " (Select CASE WHEN a.day" + day + " > 0 THEN b.shiftName ELSE 'WO' END From ShiftMaster b where b.id = a.day" + day + ")"
                    + " FROM ShiftGenerateMonthlySchedule a"
                    + " LEFT JOIN a.employeeMaster b"
                    + " Where b.id=" + empID
                    + " And a.shiftMonth = " + month
                    + " And a.shiftYear =" + year;

        } catch (ParseException ex) {
            ex.getStackTrace();
        }
        return getHibernateTemplate().find(query);

    }

    @Override
    public List<?> readByEmpMonthYear(Integer id) {
        Date d = new Date();
        LocalDate localDate = d.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        String query = " Select a from ShiftGenerateMonthlySchedule a "
                + " Where a.employeeMaster=" + id
                + " And a.shiftMonth=" + localDate.getMonthValue()
                + " And a.shiftYear=" + localDate.getYear();
        ArrayList arrayList = new ArrayList();
        List<?> list = getHibernateTemplate().find(query);
        if (list.size() > 0) {
            for (Object o : list) {
                ShiftGenerateMonthlySchedule shiftGenerateMonthlySchedule = new ShiftGenerateMonthlySchedule();
                shiftGenerateMonthlySchedule = (ShiftGenerateMonthlySchedule) o;
                Field[] fields = shiftGenerateMonthlySchedule.getClass().getDeclaredFields();
                for (int j = 0; j < fields.length; j++) {
                    String s = fields[j].getName();
                    String s1 = fields[j].getName();
                    if (s.contains("day")) {
                        try {
                            s1 = s.substring(0, 1).toUpperCase() + s.substring(1);
                            Method m = shiftGenerateMonthlySchedule.getClass().getMethod("get" + s1);
                            String value = (String) ("" + m.invoke(shiftGenerateMonthlySchedule));
                            if (value.equals("-1")) {
                                arrayList.add(s1.substring(3));
                            }
                        } catch (Exception e) {
                            e.getMessage();
                        }
                    }
                }
            }
        }

        return arrayList;

    }

}
