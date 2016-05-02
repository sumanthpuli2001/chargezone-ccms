/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.pip;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.PipMeeting;
import com.bul.zydex.model.PipNextScheduledDate;
import java.util.List;

/**
 *
 * @author AJAY
 */
public class PipNextScheduledDateDAOImpl<T> extends GenericsDAOImpl<T> implements PipNextScheduledDateDAO<T> {

    @Override
    protected Class getDomainClass() {
        return PipNextScheduledDate.class;
    }

    @Override
    public List<?> readPipNextScheduledDateByPipMaster(T object) {
        PipNextScheduledDate pipNextScheduledDate = (PipNextScheduledDate) object;
        String query = "";

        query += ""
                + " FROM PipNextScheduledDate a"
                + " Where a.performanceImprovementPlanMaster=" + pipNextScheduledDate.getPerformanceImprovementPlanMaster().getId();

        return getHibernateTemplate().find(query);
    }

}
