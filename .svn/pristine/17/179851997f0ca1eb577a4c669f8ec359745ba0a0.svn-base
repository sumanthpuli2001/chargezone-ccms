/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.travel;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.TravelApproverHistory;
import java.util.List;

/**
 *
 * @author Irfan
 */
public class TravelApproverHistoryDAOImpl<T> extends GenericsDAOImpl<T> implements TravelApproverHistoryDAO<T> {

    @Override
    protected Class getDomainClass() {
        return TravelApproverHistory.class;
    }

    @Override
    public List<?> readapproverlist(int TabId, String loginId) {
        String query = "";
        query += ""
                + " FROM TravelApproverHistory a"
                + " where a.travelRequestMaster = " + TabId
                + " and a.returnFlag = 0"
                + " and a.employeeMasterByTravelApproverId = " + loginId
                + " Order by a.travelApproveHistoryDate asc"
                + " GROUP BY a.travelRequestMaster, a.employeeMasterByTravelApproverId";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readpreviousmanagerdata(int TabId, String prevManagerId) {
        String query = "";
        query += " Select max(a.travelApproveHistoryDate)"
                + " FROM TravelApproverHistory a"
                + " where a.travelRequestMaster = " + TabId
                + " and a.employeeMasterByTravelApproverId = " + prevManagerId
                + " GROUP BY a.travelRequestMaster, a.employeeMasterByTravelApproverId";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readlastapprove(int TabId, String loginId) {
        String query = "";
        query += ""
                + " FROM TravelApproverHistory a "
                + " Right JOIN a.travelRequestMaster b"
                + " where a.travelRequestMaster = " + TabId
                + " and a.employeeMasterByTravelApproverId = " + loginId
                + " Order by a.travelApproveHistoryDate desc limit 1 ";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readSameTravelId(T object) {
        TravelApproverHistory travelApproverHistory = (TravelApproverHistory) object;
        String query = "";
        query += ""
                + " FROM TravelApproverHistory a "
                + " where a.travelRequestMaster = " + travelApproverHistory.getTravelRequestMaster().getId();

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readApproverStatusList(T object) {
        TravelApproverHistory travelApproverHistory = (TravelApproverHistory) object;
        String query = "";
        query += " Select a.id, b.employeeName, a.travelApproveStatus,a.travelApproveHistoryDate"
                + " FROM TravelApproverHistory a "
                + " Left Join a.employeeMasterByTravelApproverId b"
                + " where a.travelRequestMaster = " + travelApproverHistory.getTravelRequestMaster().getId()
                + " and b.id = " + travelApproverHistory.getEmployeeMasterByTravelApproverId().getId()
                + " and a.returnFlag=0 order By str_to_date(a.travelApproveHistoryDate,'%d/%m/%Y-%H:%i') asc ";

        return getHibernateTemplate().find(query);
    }
}
