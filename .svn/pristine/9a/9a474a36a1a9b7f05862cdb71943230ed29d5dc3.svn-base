/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.attendanceRegularization;

import com.bul.zydex.dao.attendanceRegularization.TimeAttandanceFlaxibleMasterDAO;
import com.bul.zydex.service.*;
import java.util.List;

/**
 *
 * @author Dhaval Patel
 */
public class TimeAttandanceFlaxibleMasterServiceImpl<T> extends GenericsServiceImpl<T> implements TimeAttandanceFlaxibleMasterService<T> {

    protected TimeAttandanceFlaxibleMasterDAO<T> timeAttandanceFlaxibleMasterDAO;

    public TimeAttandanceFlaxibleMasterDAO<T> getTimeAttandanceFlaxibleMasterDAO() {
        return timeAttandanceFlaxibleMasterDAO;
    }

    public void setTimeAttandanceFlaxibleMasterDAO(TimeAttandanceFlaxibleMasterDAO<T> timeAttandanceFlaxibleMasterDAO) {
        this.timeAttandanceFlaxibleMasterDAO = timeAttandanceFlaxibleMasterDAO;
        setGenericsDAO(timeAttandanceFlaxibleMasterDAO);
    }

    @Override
    public boolean isExist(T object) {
        return timeAttandanceFlaxibleMasterDAO.isExist(object);
    }

    @Override
    public List<?> readFlexibleTimeList() {
        return timeAttandanceFlaxibleMasterDAO.readFlexibleTimeList();
    }

}
