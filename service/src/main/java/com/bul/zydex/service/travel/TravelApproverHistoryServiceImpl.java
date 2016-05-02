/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.travel;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.dao.travel.TravelApproverHistoryDAO;
import com.bul.zydex.model.TravelApproverHistory;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Irfan
 */
public class TravelApproverHistoryServiceImpl<T> extends GenericsServiceImpl<T> implements TravelApproverHistoryService<T> {

    protected TravelApproverHistoryDAO<T> travelApproverHistoryDAO;

    public TravelApproverHistoryDAO<T> getTravelApproverHistoryDAO() {
        return travelApproverHistoryDAO;
    }

    public void setTravelApproverHistoryDAO(TravelApproverHistoryDAO<T> travelApproverHistoryDAO) {
        this.travelApproverHistoryDAO = travelApproverHistoryDAO;
        setGenericsDAO(travelApproverHistoryDAO);
    }

    @Override
    public List<?> readapproverlist(int TabId, String loginId) {
        return travelApproverHistoryDAO.readapproverlist(TabId, loginId);
    }

    @Override
    public List<?> readpreviousmanagerdata(int TabId, String prevManagerId) {
        return travelApproverHistoryDAO.readpreviousmanagerdata(TabId, prevManagerId);
    }

    @Override
    public List<?> readlastapprove(int TabId, String loginId) {
        return travelApproverHistoryDAO.readlastapprove(TabId, loginId);
    }

    @Override
    public List<?> readSameTravelId(T object) {
        return travelApproverHistoryDAO.readSameTravelId(object);
    }

    @Override
    public List<?> readApproverStatusList(T object) {
        return travelApproverHistoryDAO.readApproverStatusList(object);
    }

}
