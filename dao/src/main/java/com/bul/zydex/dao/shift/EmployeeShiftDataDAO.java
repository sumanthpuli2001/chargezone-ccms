/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.shift;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.EmployeeShiftData;
import java.util.List;

/**
 *
 * @author Dhaval Patel
 */
public interface EmployeeShiftDataDAO<T> extends GenericsDAO<T> {

    public List<?> dailyTimeEntry(T object);

    public List<?> todaysData();

    public List<?> attendanceRegularizationEntry(T object);

    public List<?> poolcarApproiveAttendenceRegularization(T object);

    public List<?> empOrDateWiseSearch(T object);

    public List<?> empOrMonthlySearch(T object);

    public List<?> getPastAndCurrentPunch(T object, String endShiftTime);

    public List<?> checkTodayPresent(T object);

    public List<?> checkTodayFirstHalfDayPresent(T object);

    public List<?> checkTodaySecondHalfDayPresent(T object);

    public List<?> getPastAndCurrentPunchForSelectedDate(T object, String endShiftTime, String selectDate, String PreviousDate);

    public List<?> dailyTimeEntryForSelectedDate(T object, String date);

    public List<?> readByEmployeeId(T object, String date);

    public List<?> checkEmpDailyData();

    public List<?> checkEmpDateWiseInOutData(String date);
    
    public Boolean checkDailyEntry(T object);
    
    public List<?> getShiftDayOff(EmployeeShiftData employeeShiftData);
    
    public void updateNullShiftId();

}
