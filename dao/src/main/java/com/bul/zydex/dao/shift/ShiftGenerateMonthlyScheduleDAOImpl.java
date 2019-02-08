/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.shift;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.ShiftGenerateMonthlySchedule;
import java.text.ParseException;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

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
    public List<?> readByDayWiseEmployeeShiftData1(int day,int month1,int year1,int id2) {
        String query = "";

        query += "SELECT concat(day_" + day + ") FROM ShiftGenerateMonthlySchedule a"
                + " Where a.employeeMaster=" + id2
                + " and a.shiftMonth=" + month1
                + " and a.shiftYear=" + year1;

        return getHibernateTemplate().find(query);
    }
    
    @Override
    public List<?> readDayShiftValue(T object, int day) {
        ShiftGenerateMonthlySchedule shiftGenerateMonthlySchedule = (ShiftGenerateMonthlySchedule) object;
        String query = "";

        query += "SELECT a.shiftName FROM ShiftMaster a Where a.id=("
                +"SELECT concat(day_" + day + ") FROM ShiftGenerateMonthlySchedule a"
                + " Where a.employeeMaster=" + shiftGenerateMonthlySchedule.getEmployeeMaster().getId()
                + " and a.shiftMonth=" + Integer.parseInt(shiftGenerateMonthlySchedule.getShiftMonth())
                + " and a.shiftYear=" + Integer.parseInt(shiftGenerateMonthlySchedule.getShiftYear())
                + ")";

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
    public List readByDayWiseEmployeeShiftDataForDayNo(int monthNo, int yearNo,int id2,int dayNo) {
        
        String query = "";

        query += "SELECT concat(day_" + dayNo + ") FROM ShiftGenerateMonthlySchedule a"
                + " Where a.employeeMaster=" + id2
                + " and a.shiftMonth=" + monthNo
                + " and a.shiftYear=" + yearNo;

        return getHibernateTemplate().find(query);
    }

    @Override
    public void updateDays(String data) {
        String a[] = data.split(":");
        String query = "";
        Session s = getSessionFactory().openSession();

        query += "UPDATE hr_power_astral.shift_generate_monthly_schedule a"
                + " Set a.day_"+a[0]+"="+a[2]+","
                + " a.day_"+a[6]+"="+a[8]+","
                + " a.day_"+a[1]+"="+a[3]+","
                + " a.day_"+a[5]+"="+a[3]
                + " Where a.id="+a[4];

        SQLQuery sqlQuery = s.createSQLQuery(query);
        sqlQuery.executeUpdate();
        s.close();
    }

    @Override
    public String readShiftData(int monthValue, int year,int id2) {
        String query = "";

        query += "SELECT a.id FROM ShiftGenerateMonthlySchedule a"
                + " Where a.shiftMonth="+monthValue
                + " And a.shiftYear="+year
                + " And a.employeeMaster.id="+id2;
    List<?> list = getHibernateTemplate().find(query);
            String list1 = list.get(0).toString();
            return list1;

}

    @Override
    public String readThreeDaysList(String data1) {
        String a[] = data1.split(":");
        String query = "";
        query += " Select a.day"+a[2]
                + " FROM ShiftGenerateMonthlySchedule a"
                + " Where a.id="+a[3];
        List<?> list = getHibernateTemplate().find(query);
        String beforeDate = ((Integer)list.get(0)).toString();
        query = "";
        query += " Select a.day"+a[0]
                + " FROM ShiftGenerateMonthlySchedule a"
                + " Where a.id="+a[3];
        list = getHibernateTemplate().find(query);
        String presentDate = ((Integer)list.get(0)).toString();
        query = "";
        query += " Select a.day"+a[1]
                + " FROM ShiftGenerateMonthlySchedule a"
                + " Where a.id="+a[3];
        list = getHibernateTemplate().find(query);
        String afterDate = ((Integer)list.get(0)).toString();
        return beforeDate+"&"+presentDate+"&"+afterDate;
    }

    @Override
    public void updateDaysCase(String data) {
        String a[] = data.split(":");
        String query = "";
        Session s = getSessionFactory().openSession();

        query += "UPDATE hr_power_astral.shift_generate_monthly_schedule a"
                + " Set a.day_"+a[0]+"="+a[2]+","
                + " a.day_"+a[7]+"="+a[8]+","
                + " a.day_"+a[1]+"="+a[3]+","
                + " a.day_"+a[5]+"="+a[3]
                + " Where a.id="+a[4];

        SQLQuery sqlQuery = s.createSQLQuery(query);
        sqlQuery.executeUpdate();
        s.close();
    }

    @Override
    public List readByDayWiseEmployeeShiftDataForDayNext(int dayNext,int id2,int month1,int year1) {
        String query = "";

        query += "SELECT concat(day_" + dayNext + ") FROM ShiftGenerateMonthlySchedule a"
                + " Where a.employeeMaster=" + id2
                + " and a.shiftMonth=" + month1
                + " and a.shiftYear=" + year1;

        return getHibernateTemplate().find(query);
    }

    @Override
    public List readShiftMonths(int id2, int year, int month) {
        String query = "";
        HashMap<Integer,List<Integer>> hm = new HashMap<>();
        query += "From ShiftGenerateMonthlySchedule a "
                + "Where a.employeeMaster.id=" + id2
                + " and a.shiftYear='" + year
                + "' a.shiftMonth >='"+ month+"'";
        List<?> list = getHibernateTemplate().find(query);
        Iterator<?> itr = list.iterator();
        while(itr.hasNext()){
            List<?> l = (List) itr.next();
            List<Integer> lis = new ArrayList<>();
            lis.add((Integer)l.get(0));
            for(int i=4;i<l.size()-2;i++){
                lis.add((Integer)l.get(i));
            }
            hm.put((Integer)l.get(3) , lis);
        }
        List<HashMap> l = new ArrayList<>();
        l.add(hm);
        return l;
    }
    
    @Override
    public void updateNewShift(String data) {
        String query = "";
        HashMap<Integer,List<Integer>> hm = new HashMap<>();
        query +="update hr_power_astral.shift_generate_monthly_schedule a set a.day_"+data.split(",")[0]
                +" ="+data.split(",")[1]
                +" , a.day_"+data.split(",")[2]
                +" where id = "+data.split(",")[3];
        Session s = getSessionFactory().openSession();
        SQLQuery sqlQuery = s.createSQLQuery(query);
        sqlQuery.executeUpdate();
        s.close();
    }

    @Override
    public List readNoOfMonths(int id2, int yearNo,int monthNo) {
        String query = "";

        query += "SELECT a.shiftMonth FROM ShiftGenerateMonthlySchedule a"
                + " Where a.employeeMaster=" + id2
                + " and a.shiftYear=" + yearNo
                + " and a.shiftMonth>="+monthNo;
        return getHibernateTemplate().find(query);
    }

    @Override
    public void updateDays1(String data) {
        String a[] = data.split(":");
        String query = "";
        Session s = getSessionFactory().openSession();

        query += "UPDATE hr_power_astral.shift_generate_monthly_schedule a"
                + " Set a.day_"+a[0]+"="+a[2]+","
                + " a.day_"+a[6]+"="+a[8]
                + " Where a.shift_month="+a[15]
                + " and a.shift_year="+a[16]
                + " and a.employee_master_id="+a[12];
                
        SQLQuery sqlQuery = s.createSQLQuery(query);
        sqlQuery.executeUpdate();
        s.close();
    }

    @Override
    public void updateDays2(String data) {
        String a[] = data.split(":");
        String query = "";
        Session s = getSessionFactory().openSession();

        query += "UPDATE hr_power_astral.shift_generate_monthly_schedule a"
                + " Set a.day_"+a[1]+"="+a[3]+","
                + " a.day_"+a[5]+"="+a[3]
                + " Where a.shift_month="+a[9]
                + " and a.shift_year="+a[10]
                + " and a.employee_master_id="+a[12];
        
        SQLQuery sqlQuery = s.createSQLQuery(query);
        sqlQuery.executeUpdate();
        s.close();
    }

    @Override
    public void updateDaysCase1(String data) {
        String a[] = data.split(":");
        String query = "";
        Session s = getSessionFactory().openSession();

        query += "UPDATE hr_power_astral.shift_generate_monthly_schedule a"
                + " Set a.day_"+a[0]+"="+a[2]+","
                + " a.day_"+a[7]+"="+a[8]
                + " Where a.shift_month="+a[15]
                + " and a.shift_year="+a[16]
                + " and a.employee_master_id="+a[12];

        SQLQuery sqlQuery = s.createSQLQuery(query);
        sqlQuery.executeUpdate();
        s.close();
    }

    @Override
    public void updateDaysCase2(String data) {
        String a[] = data.split(":");
        String query = "";
        Session s = getSessionFactory().openSession();

        query += "UPDATE hr_power_astral.shift_generate_monthly_schedule a"
                + " Set a.day_"+a[1]+"="+a[3]+","
                + " a.day_"+a[5]+"="+a[3]
                + " Where a.shift_month="+a[9]
                + " and a.shift_year="+a[10]
                + " and a.employee_master_id="+a[12];

        SQLQuery sqlQuery = s.createSQLQuery(query);
        sqlQuery.executeUpdate();
        s.close();
    }

    @Override
    public List readByDayWiseEmployeeShiftDataForDayNextMonthEnd(int id2,int monthNoNext, int yearNo) {
        String query = "";

        query += "SELECT a.day1 FROM ShiftGenerateMonthlySchedule a"
                + " Where a.employeeMaster=" + id2
                + " and a.shiftMonth=" + monthNoNext
                + " and a.shiftYear=" + yearNo;

        return getHibernateTemplate().find(query);
    }

    @Override
    public void updateDaysMonthEnd(String data) {
        String a[] = data.split(":");
        String query = "";
        Session s = getSessionFactory().openSession();

        query += "UPDATE hr_power_astral.shift_generate_monthly_schedule a"
                + " Set a.day_"+a[0]+"="+a[2]+","
                + " a.day_"+a[6]+"="+a[13]+","
                + " a.day_"+a[1]+"="+a[3]
                + " Where a.shift_month="+a[15]
                + " and a.shift_year="+a[16]
                + " and a.employee_master_id="+a[12];

        SQLQuery sqlQuery = s.createSQLQuery(query);
        sqlQuery.executeUpdate();
        s.close();
    }
    @Override
    public void updateDaysMonthEnd1(String data) {
        String a[] = data.split(":");
        String query = "";
        Session s = getSessionFactory().openSession();

        query += "UPDATE hr_power_astral.shift_generate_monthly_schedule a"
                + " Set a.day_1="+a[3]
                + " Where a.shift_month="+a[17]
                + " and a.shift_year="+a[10]
                + " and a.employee_master_id="+a[12];

        SQLQuery sqlQuery = s.createSQLQuery(query);
        sqlQuery.executeUpdate();
        s.close();
    }

    @Override
    public void updateDaysCaseMonthEnd(String data) {
        String a[] = data.split(":");
        String query = "";
        Session s = getSessionFactory().openSession();

        query += "UPDATE hr_power_astral.shift_generate_monthly_schedule a"
                + " Set a.day_"+a[0]+"="+a[2]+","
                + " a.day_"+a[7]+"="+a[13]+","
                + " a.day_"+a[1]+"="+a[3]
                + " Where a.shift_month="+a[15]
                + " and a.shift_year="+a[16]
                + " and a.employee_master_id="+a[12];

        SQLQuery sqlQuery = s.createSQLQuery(query);
        sqlQuery.executeUpdate();
        s.close();
    }

    @Override
    public void updateDaysCaseMonthEnd1(String data) {
        String a[] = data.split(":");
        String query = "";
        Session s = getSessionFactory().openSession();

        query += "UPDATE hr_power_astral.shift_generate_monthly_schedule a"
                + " Set a.day_1="+a[3]
                + " Where a.shift_month="+a[17]
                + " and a.shift_year="+a[10]
                + " and a.employee_master_id="+a[12];

        SQLQuery sqlQuery = s.createSQLQuery(query);
        sqlQuery.executeUpdate();
        s.close();
    }

    @Override
    public String readEmployeeId(int userId) {
        String query = "";
        query += " Select a.id"
                + " FROM EmployeeMaster a"
                + " Where a.userMaster="+userId;
        List<?> list = getHibernateTemplate().find(query);
        String list1 = ((Integer)list.get(0)).toString();
        return list1;
    }

    @Override
    public List readNoOfMonthsSubmit(int id2, int year, int monthValue) {
        String query = "";

        query += "SELECT a.shiftMonth FROM ShiftGenerateMonthlySchedule a"
                + " Where a.employeeMaster=" + id2
                + " and a.shiftYear=" + year
                + " and a.shiftMonth>="+monthValue;
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readRotationDate(int id3) {
        String query = "";

        query += "SELECT a.rotationDate FROM WoffRegularization a"
                + " Where a.userMasterId=" + id3
                + " and a.status=1";
        return getHibernateTemplate().find(query);
    }
}
