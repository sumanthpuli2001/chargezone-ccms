/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.pip;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.GoalResourceManagement;
import com.bul.zydex.model.PipMeeting;
import java.util.List;

/**
 *
 * @author AJAY
 */
public class PipMeetingDAOImpl<T> extends GenericsDAOImpl<T> implements PipMeetingDAO<T> {

    @Override
    protected Class getDomainClass() {
        return PipMeeting.class;
    }

    @Override
    public List<?> readPipMeetingByPipMaster(T object) {
        PipMeeting pipMeeting = (PipMeeting) object;
        String query = "";

        query += ""
                + " FROM PipMeeting a"
                + " Where a.performanceImprovementPlanMaster=" + pipMeeting.getPerformanceImprovementPlanMaster().getId();

        return getHibernateTemplate().find(query);
    }

}
