/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.shift;

import com.bul.zydex.dao.shift.ShiftGenerateMonthlyScheduleDAO;
import com.bul.zydex.model.ShiftGenerateMonthlySchedule;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author AJAY
 */
public class ShiftGenerateMonthlyScheduleServiceImpl<T> extends GenericsServiceImpl<T>
        implements ShiftGenerateMonthlyScheduleService<T> {

    protected ShiftGenerateMonthlyScheduleDAO<T> shiftGenerateMonthlyScheduleDAO;

    public ShiftGenerateMonthlyScheduleDAO<T> getShiftGenerateMonthlyScheduleDAO() {
        return shiftGenerateMonthlyScheduleDAO;
    }

    public void setShiftGenerateMonthlyScheduleDAO(ShiftGenerateMonthlyScheduleDAO<T> shiftGenerateMonthlyScheduleDAO) {
        this.shiftGenerateMonthlyScheduleDAO = shiftGenerateMonthlyScheduleDAO;
        setGenericsDAO(shiftGenerateMonthlyScheduleDAO);
    }

    @Override
    public List<?> readByEmployeeShift(T object) {
        return shiftGenerateMonthlyScheduleDAO.readByEmployeeShift(object);
    }

    @Override
    public List<?> readByCurrentDateWiseEmployeeShift(T object) {
        return shiftGenerateMonthlyScheduleDAO.readByCurrentDateWiseEmployeeShift(object);
    }

    @Override
    public List<?> readByDayWiseEmployeeShiftData(T object, int day) {
        return shiftGenerateMonthlyScheduleDAO.readByDayWiseEmployeeShiftData(object, day);
    }

    @Override
    public List<?> readByDayWiseEmployeeShiftData1(int day, int month1, int year1, int id2) {
        return shiftGenerateMonthlyScheduleDAO.readByDayWiseEmployeeShiftData1(day, month1, year1, id2);
    }

    @Override
    public List<?> employeeListReadByMonth(int month, int year) {
        return shiftGenerateMonthlyScheduleDAO.employeeListReadByMonth(month, year);
    }
    
    @Override
    public List<?> employeeListReadByMonth1(int month, int year,int empId) {
        return shiftGenerateMonthlyScheduleDAO.employeeListReadByMonth1(month, year,empId);
    }

    @Override
    public List<?> employeeMonthlyShiftDetail(int id) {
        return shiftGenerateMonthlyScheduleDAO.employeeMonthlyShiftDetail(id);
    }

    @Override
    public List<?> readDayWiseShift(int id, int dayNo) {
        return shiftGenerateMonthlyScheduleDAO.readDayWiseShift(id, dayNo);
    }

    @Override
    public void updateDayWiseShift(int id, int dayNo, int shiftId) {
        shiftGenerateMonthlyScheduleDAO.updateDayWiseShift(id, dayNo, shiftId);
    }

    @Override
    public List<?> ReadEmployeeShiftByMonthYear(int empId, int month, int year) {
        return shiftGenerateMonthlyScheduleDAO.ReadEmployeeShiftByMonthYear(empId, month, year);
    }

    @Override
    public void updateDayWiseShiftReguration(int id, int dayNo) {
        shiftGenerateMonthlyScheduleDAO.updateDayWiseShiftReguration(id, dayNo);
    }

    @Override
    public List<?> employeeListReadByMonthWoff(int month, int year, int empID) {
        return shiftGenerateMonthlyScheduleDAO.employeeListReadByMonthWoff(month, year, empID);
    }

    @Override
    public List<?> ReadEmployeeShiftByDayMonthYear(Integer empId, String date) {
        return shiftGenerateMonthlyScheduleDAO.ReadEmployeeShiftByDayMonthYear(empId, date);
    }

    @Override
    public List readByDayWiseEmployeeShiftDataForDayNo(int monthNo, int yearNo, int id2, int dayNo) {
        return shiftGenerateMonthlyScheduleDAO.readByDayWiseEmployeeShiftDataForDayNo(monthNo, yearNo, id2, dayNo);
    }

    @Override
    public void updateDays(String data) {
        shiftGenerateMonthlyScheduleDAO.updateDays(data);
    }

    @Override
    public String readShiftData(int monthValue, int year, int id2) {
        return shiftGenerateMonthlyScheduleDAO.readShiftData(monthValue, year, id2);
    }

    @Override
    public String readThreeDaysList(String data1) {
        return shiftGenerateMonthlyScheduleDAO.readThreeDaysList(data1);
    }

    @Override
    public void updateDaysCase(String data) {
        shiftGenerateMonthlyScheduleDAO.updateDaysCase(data);
    }

    @Override
    public List readByDayWiseEmployeeShiftDataForDayNext(int dayNext, int id2, int month1, int year1) {
        return shiftGenerateMonthlyScheduleDAO.readByDayWiseEmployeeShiftDataForDayNext(dayNext, id2, month1, year1);
    }

    @Override
    public List readShiftMonths(int id2, int year, int month) {
        return shiftGenerateMonthlyScheduleDAO.readShiftMonths(id2, year, month);
    }

    @Override
    public void updateNewShift(String data) {
        shiftGenerateMonthlyScheduleDAO.updateNewShift(data);
    }

    @Override
    public List readNoOfMonths(int id2, int yearNo, int monthNo) {
        return shiftGenerateMonthlyScheduleDAO.readNoOfMonths(id2, yearNo, monthNo);
    }

    @Override
    public void updateDays1(String data) {
        shiftGenerateMonthlyScheduleDAO.updateDays1(data);
    }

    @Override
    public void updateDays2(String data) {
        shiftGenerateMonthlyScheduleDAO.updateDays2(data);
    }

    @Override
    public void updateDaysCase1(String data) {
        shiftGenerateMonthlyScheduleDAO.updateDaysCase1(data);
    }

    @Override
    public void updateDaysCase2(String data) {
        shiftGenerateMonthlyScheduleDAO.updateDaysCase2(data);
    }

    @Override
    public List readByDayWiseEmployeeShiftDataForDayNextMonthEnd(int id2, int monthNoNext, int yearNo) {
        return shiftGenerateMonthlyScheduleDAO.readByDayWiseEmployeeShiftDataForDayNextMonthEnd(id2, monthNoNext, yearNo);
    }

    @Override
    public void updateDaysMonthEnd(String data) {
        shiftGenerateMonthlyScheduleDAO.updateDaysMonthEnd(data);
    }

    @Override
    public void updateDaysMonthEnd1(String data) {
        shiftGenerateMonthlyScheduleDAO.updateDaysMonthEnd1(data);
    }

    @Override
    public void updateDaysCaseMonthEnd(String data) {
        shiftGenerateMonthlyScheduleDAO.updateDaysCaseMonthEnd(data);
    }

    @Override
    public void updateDaysCaseMonthEnd1(String data) {
        shiftGenerateMonthlyScheduleDAO.updateDaysCaseMonthEnd1(data);
    }

    @Override
    public String readEmployeeId(int userId) {
        return shiftGenerateMonthlyScheduleDAO.readEmployeeId(userId);
    }

    @Override
    public List readNoOfMonthsSubmit(int id2, int year, int monthValue) {
        return shiftGenerateMonthlyScheduleDAO.readNoOfMonthsSubmit(id2, year, monthValue);
    }

    @Override
    public List readRotationDate(int id3) {
        return shiftGenerateMonthlyScheduleDAO.readRotationDate(id3);
    }

    @Override
    public List<?> readDayShiftValue(T object, int day) {
        return shiftGenerateMonthlyScheduleDAO.readDayShiftValue(object, day);
    }

    @Override
    public List<?> readByEmpMonthYear(Integer id) {
        return shiftGenerateMonthlyScheduleDAO.readByEmpMonthYear(id);
    }

}
