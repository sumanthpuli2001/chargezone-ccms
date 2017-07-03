/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.shift;

import com.bul.zydex.dao.shift.ShiftGenerateMonthlyScheduleDAO;
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
    public List<?> employeeListReadByMonth(int month, int year) {
        return shiftGenerateMonthlyScheduleDAO.employeeListReadByMonth(month, year);
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

}
