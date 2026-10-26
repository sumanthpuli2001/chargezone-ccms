/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.DeliverableMulti;

import com.bul.zydex.dao.DeliverableMulti.DeliverableMultiDao;
import com.bul.zydex.model.DeliverableMulti;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class DeliverableMultiServiceImpl<T> extends GenericsServiceImpl<T> implements DeliverableMultiService<T> {

    private DeliverableMultiDao<T> deliverableMultiDao;

    public DeliverableMultiDao<T> getDeliverableMultiDao() {
        return deliverableMultiDao;
    }

    public void setDeliverableMultiDao(DeliverableMultiDao<T> deliverableMultiDao) {
        this.deliverableMultiDao = deliverableMultiDao;
        setGenericsDAO(deliverableMultiDao);

    }

    @Override
    public List readByDeliveryId(String id) {
        return deliverableMultiDao.readByDeliveryId(id);
    }

    @Override
    public List readBydesignCoordinator(String username) {
        return deliverableMultiDao.readBydesignCoordinator(username);
    }

    @Override
    public List readByDesignAssign(String username) {
        return deliverableMultiDao.readByDesignAssign(username);
    }

    @Override
    public List readByAocId(String aocid) {
        return deliverableMultiDao.readByAocId(aocid);
    }

    @Override
    public List readByOapid(String oapid) {
        return deliverableMultiDao.readByOapid(oapid);
    }

    @Override
    public List readByDeliveryId(int deliverableid) {
        return deliverableMultiDao.readByDeliveryId(deliverableid);
    }

    @Override
    public List readByoapid(int oapformid) {
        return deliverableMultiDao.readByoapid(oapformid);
    }

    @Override
    public List readByaocId(int aocformid) {
        return deliverableMultiDao.readByaocId(aocformid);
    }

    @Override
    public List readByoapidflag(int oapformid) {
        return deliverableMultiDao.readByoapidflag(oapformid);
    }

    @Override
    public int countAllDesignCoorOap() {
        return deliverableMultiDao.countAllDesignCoorOap();

    }

    @Override
    public int readByFlagOneOap() {
        return deliverableMultiDao.readByFlagOneOap();
    }

    @Override
    public int countAllDesignCoorAoc() {
        return deliverableMultiDao.countAllDesignCoorAoc();
    }

    @Override
    public int readByFlagOneAoc() {
        return deliverableMultiDao.readByFlagOneAoc();
    }

    @Override
    public int countAllDesignCoorOapDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        return deliverableMultiDao.countAllDesignCoorOapDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate);

    }

    @Override
    public int readByFlagOneOapDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return deliverableMultiDao.readByFlagOneOapDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int countAllDesignCoorAocDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {

        return deliverableMultiDao.countAllDesignCoorAocDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate);

    }

    @Override
    public int readByFlagOneAocDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return deliverableMultiDao.readByFlagOneAocDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public List readByOapIdAndZeroFlag(int oapformid) {
        return deliverableMultiDao.readByOapIdAndZeroFlag(oapformid);

    }

    @Override
    public List readByAocIdAndZeroFlag(int aocFormid) {
        return deliverableMultiDao.readByAocIdAndZeroFlag(aocFormid);
    }

    @Override
    public List getDesignCoordinatorPagination(int start, int length, String searchValue, String username, String orderColumn, String orderDir) {
        return deliverableMultiDao.getDesignCoordinatorPagination(start, length, searchValue, username, orderColumn, orderDir);

    }

    @Override
    public int getTotalDesignCoordinatorCount(String username) {
        return deliverableMultiDao.getTotalDesignCoordinatorCount(username);
    }

    @Override
    public int getFilteredDesignCoordinatorCount(String username, String searchValue) {
        return deliverableMultiDao.getFilteredDesignCoordinatorCount(username, searchValue);
    }

    @Override
    public List getDesignAssignPagination(int start, int length, String searchValue, String username, String orderColumn, String orderDir) {
        return deliverableMultiDao.getDesignAssignPagination(start, length, searchValue, username, orderColumn, orderDir);

    }

    @Override
    public int getTotalDesignAssignCount(String username) {
        return deliverableMultiDao.getTotalDesignAssignCount(username);
    }

    @Override
    public int getFilteredDesignAssignCount(String username, String searchValue) {
        return deliverableMultiDao.getFilteredDesignAssignCount(username, searchValue);
    }

}
