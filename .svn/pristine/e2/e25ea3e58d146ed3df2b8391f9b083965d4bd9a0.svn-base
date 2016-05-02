/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.shift;

import com.bul.zydex.dao.shift.TimeAttendanceMasterDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author AJAY
 */
public class TimeAttendanceMasterServiceImpl<T> extends GenericsServiceImpl<T> implements TimeAttendanceMasterService<T> {

    protected TimeAttendanceMasterDAO<T> timeAttendanceMasterDAO;

    public TimeAttendanceMasterDAO<T> getTimeAttendanceMasterDAO() {
        return timeAttendanceMasterDAO;
    }

    public void setTimeAttendanceMasterDAO(TimeAttendanceMasterDAO<T> timeAttendanceMasterDAO) {
        this.timeAttendanceMasterDAO = timeAttendanceMasterDAO;
        setGenericsDAO(timeAttendanceMasterDAO);
    }

    @Override
    public List<?> readByUserId(T object) {
        return timeAttendanceMasterDAO.readByUserId(object);
    }

}
