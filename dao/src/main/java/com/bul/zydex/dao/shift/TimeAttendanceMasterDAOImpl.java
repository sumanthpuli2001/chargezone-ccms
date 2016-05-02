/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.shift;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.Punch;
import com.bul.zydex.model.TimeAttendanceMaster;
import java.util.List;

/**
 *
 * @author AJAY
 */
public class TimeAttendanceMasterDAOImpl<T> extends GenericsDAOImpl<T> implements TimeAttendanceMasterDAO<T> {

    @Override
    protected Class getDomainClass() {
        return TimeAttendanceMaster.class;
    }

    @Override
    public List<?> readByUserId(T object) {
        TimeAttendanceMaster timeAttendanceMaster = (TimeAttendanceMaster) object;
        String query = "";

        query += " Select MIN(a.dateTime), MAX(a.dateTime) FROM TimeAttendanceMaster a"
                + " Where a.userMaster=" + timeAttendanceMaster.getUserMaster().getId()
                + " Group By a.userMaster.id";

        return getHibernateTemplate().find(query);
    }

}
