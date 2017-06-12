/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.shift;

import com.bul.zydex.dao.shift.EmployeeShiftDataDAO;
import com.bul.zydex.dao.shift.TemporaryShiftAssignDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Dhaval Patel
 */
public class EmployeeShiftDataServiceImpl<T> extends GenericsServiceImpl<T> implements EmployeeShiftDataService<T> {

    private EmployeeShiftDataDAO<T> employeeShiftDataDAO;

    public EmployeeShiftDataDAO<T> getEmployeeShiftDataDAO() {
        return employeeShiftDataDAO;
    }

    public void setEmployeeShiftDataDAO(EmployeeShiftDataDAO<T> employeeShiftDataDAO) {
        this.employeeShiftDataDAO = employeeShiftDataDAO;
        setGenericsDAO(employeeShiftDataDAO);
    }

    @Override
    public List<?> dailyTimeEntry(T object) {
        return employeeShiftDataDAO.dailyTimeEntry(object);
    }

    @Override
    public List<?> attendanceRegularizationEntry(T object) {
        return employeeShiftDataDAO.attendanceRegularizationEntry(object);
    }

    @Override
    public List<?> todaysData() {
        return employeeShiftDataDAO.todaysData();
    }

    @Override
    public List<?> poolcarApproiveAttendenceRegularization(T object) {
        return employeeShiftDataDAO.poolcarApproiveAttendenceRegularization(object);
    }

    @Override
    public List<?> empOrDateWiseSearch(T object) {
        return employeeShiftDataDAO.empOrDateWiseSearch(object);
    }

    @Override
    public List<?> empOrMonthlySearch(T object) {
        return employeeShiftDataDAO.empOrMonthlySearch(object);
    }

    @Override
    public List<?> getPastAndCurrentPunch(T object, String endShiftTime) {
        return employeeShiftDataDAO.getPastAndCurrentPunch(object, endShiftTime);
    }

    @Override
    public List<?> checkTodayPresent(T object) {
        return employeeShiftDataDAO.checkTodayPresent(object);
    }

    @Override
    public List<?> checkTodayFirstHalfDayPresent(T object) {
        return employeeShiftDataDAO.checkTodayFirstHalfDayPresent(object);
    }

    @Override
    public List<?> checkTodaySecondHalfDayPresent(T object) {
        return employeeShiftDataDAO.checkTodaySecondHalfDayPresent(object);
    }

    @Override
    public List<?> getPastAndCurrentPunchForSelectedDate(T object, String endShiftTime, String selectDate, String PreviousDate) {
        return employeeShiftDataDAO.getPastAndCurrentPunchForSelectedDate(object, endShiftTime, selectDate, PreviousDate);
    }

    @Override
    public List<?> dailyTimeEntryForSelectedDate(T object, String date) {
        return employeeShiftDataDAO.dailyTimeEntryForSelectedDate(object, date);
    }

    @Override
    public List<?> readByEmployeeId(T object, String date) {
        return employeeShiftDataDAO.readByEmployeeId(object, date);
    }

    @Override
    public List<?> checkEmpDailyData() {
        return employeeShiftDataDAO.checkEmpDailyData();
    }

    @Override
    public List<?> checkEmpDateWiseInOutData(String date) {
        return employeeShiftDataDAO.checkEmpDateWiseInOutData(date);
    }
}
