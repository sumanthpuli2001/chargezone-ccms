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
    public List<?> readByDayWiseEmployeeShiftData(T object,int day) {
        return shiftGenerateMonthlyScheduleDAO.readByDayWiseEmployeeShiftData(object,day);
    }

}
