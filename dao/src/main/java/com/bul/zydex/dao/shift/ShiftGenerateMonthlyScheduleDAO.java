/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.shift;

import com.bul.zydex.dao.GenericsDAO;
import java.util.List;

/**
 *
 * @author AJAY
 */
public interface ShiftGenerateMonthlyScheduleDAO<T> extends GenericsDAO<T> {

    public List<?> readByEmployeeShift(T object);

    public List<?> readByCurrentDateWiseEmployeeShift(T object);

    public List<?> readByDayWiseEmployeeShiftData(T object, int day);
    
    public List<?> readDayShiftValue(T object, int day);
    
    public List<?> readByDayWiseEmployeeShiftData1(int day,int month1,int year1,int id2);

    public List<?> employeeListReadByMonth(int month, int year);
    
    public List<?> employeeListReadByMonth1(int month, int year,int empId);

    public List<?> employeeMonthlyShiftDetail(int id);

    public List<?> readDayWiseShift(int id, int dayNo);

    public void updateDayWiseShift(int id, int dayNo, int shiftId);

    public List<?> ReadEmployeeShiftByMonthYear(int empId, int month, int year);

    public void updateDayWiseShiftReguration(int id, int dayNo);

    public List<?> employeeListReadByMonthWoff(int month, int year, int empID);

    public List<?> ReadEmployeeShiftByDayMonthYear(Integer empId, String date);
    
    public List readByDayWiseEmployeeShiftDataForDayNo(int monthNo, int yearNo,int id2,int dayNo);
    
    public void updateDays(String data);
    
    public String readShiftData(int monthValue, int year,int id2);
    
    public String readThreeDaysList(String data1);
    
    public void updateDaysCase(String data);
    
    public List readByDayWiseEmployeeShiftDataForDayNext(int dayNext,int id2,int month1,int year1);
    
    public List readShiftMonths(int id2, int year, int month);
    
    public void updateNewShift(String data);
    
    public List readNoOfMonths(int id2, int yearNo,int monthNo);
    
    public void updateDays1(String data);
    
    public void updateDays2(String data);
    
    public void updateDaysCase1(String data);
    
    public void updateDaysCase2(String data);
    
    public List readByDayWiseEmployeeShiftDataForDayNextMonthEnd(int id2,int monthNoNext, int yearNo);
    
    public void updateDaysMonthEnd(String data);
    
    public void updateDaysMonthEnd1(String data);
    
    public void updateDaysCaseMonthEnd(String data);
    
    public void updateDaysCaseMonthEnd1(String data);
    
    public String readEmployeeId(int userId);
    
    public List readNoOfMonthsSubmit(int id2, int year, int monthValue);
    
    public List readRotationDate(int id3);

    public List<?> readByEmpMonthYear(Integer id);
    
    public List<?> getShiftsBetween(String data);
    
    public List<?> getbeforesDate(String data);
    
    public List<?> getaftereDate(String data);
    
    public List<?> getbeforesDate1(String data);
    
    public List<?> getaftereDate1(String data);
    
    public List<?> getshiftsList(String data);
    
    public List<?> getshiftsList1(String data);
    
    public String getBeforeDayList(String data);
    
    public String getAfterDayList(String data);
    
    public List<?> getbeforeWoffDayList(String data1);
    
     public List<?> getafterWoffDayList(String data1);
     
     public List<?> getDayAfterOfstrDate(String data);
     
     public List<?> getDayBeforeOfenDate(String data);

}
