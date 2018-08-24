/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.shift;

import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author AJAY
 */
public interface ShiftGenerateMonthlyScheduleService<T> extends GenericsService<T> {

    public List<?> readByEmployeeShift(T object);

    public List<?> readByCurrentDateWiseEmployeeShift(T object);

    public List<?> readByDayWiseEmployeeShiftData(T object, int day);

    public List<?> employeeListReadByMonth(int month, int year);

    public List<?> employeeMonthlyShiftDetail(int id);

    public List<?> readDayWiseShift(int id, int dayNo);

    public void updateDayWiseShift(int id, int dayNo, int shiftId);

    public List<?> ReadEmployeeShiftByMonthYear(int empId, int month, int year);

    public void updateDayWiseShiftReguration(int id, int dayNo);
}
