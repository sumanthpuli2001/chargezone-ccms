/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.shift;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.ShiftGenerateMonthlySchedule;
import com.bul.zydex.model.ShiftMaster;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
                + " and a.shiftMonth="+shiftGenerateMonthlySchedule.getShiftMonth()
                + " and a.shiftYear="+shiftGenerateMonthlySchedule.getShiftYear();

            return getHibernateTemplate().find(query);
    }
    @Override
    public List<?> readByDayWiseEmployeeShiftData(T object,int day) {
        ShiftGenerateMonthlySchedule shiftGenerateMonthlySchedule = (ShiftGenerateMonthlySchedule) object;
         String query = "";
       
        query += "SELECT day"+day+" FROM ShiftGenerateMonthlySchedule a"
                + " Where a.employeeMaster=" + shiftGenerateMonthlySchedule.getEmployeeMaster().getId()
                + " and a.shiftMonth="+shiftGenerateMonthlySchedule.getShiftMonth()
                + " and a.shiftYear="+shiftGenerateMonthlySchedule.getShiftYear();

        return getHibernateTemplate().find(query);
    }

}
