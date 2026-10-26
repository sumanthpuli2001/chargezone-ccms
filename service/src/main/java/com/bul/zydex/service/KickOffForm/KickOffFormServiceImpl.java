/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.KickOffForm;

import com.bul.zydex.dao.KickOffForm.KickOffFormDao;
import com.bul.zydex.model.KickOffForm;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class KickOffFormServiceImpl<T> extends GenericsServiceImpl<T> implements KickOffFormService<T> {

    private KickOffFormDao<T> kickOffFormDao;

    public KickOffFormDao<T> getKickOffFormDao() {
        return kickOffFormDao;
    }

    public void setKickOffFormDao(KickOffFormDao<T> kickOffFormDao) {
        this.kickOffFormDao = kickOffFormDao;
        setGenericsDAO(kickOffFormDao);

    }

    @Override
    public List readbyApprove(String username) {
        return kickOffFormDao.readbyApprove(username);
    }

    @Override
    public KickOffForm readByaocId(String id) {
        return kickOffFormDao.readByaocId(id);

    }

    @Override
    public KickOffForm readByaocIds(int aocformid) {
        return kickOffFormDao.readByaocIds(aocformid);
    }

    @Override
    public List readDeliverableList(String username) {
        return kickOffFormDao.readDeliverableList(username);
    }

    @Override
    public List readByFlagoneDashBoard() {
        return kickOffFormDao.readByFlagoneDashBoard();
    }

    @Override
    public List readByPendingKom() {
        return kickOffFormDao.readByPendingKom();
    }

    @Override
    public List readByFlagThreeDashBoard() {
        return kickOffFormDao.readByFlagThreeDashBoard();
    }

    @Override
    public List getusernamePagination(int start, int length, String searchValue, String username, String orderColumn, String orderDir) {

        return kickOffFormDao.getusernamePagination(start, length, searchValue, username, orderColumn, orderDir);

    }

    @Override
    public int getTotalusernameCount(String username) {
        return kickOffFormDao.getTotalusernameCount(username);

    }

    @Override
    public int getFilteredusernameCount(String username, String searchValue) {

        return kickOffFormDao.getFilteredusernameCount(username, searchValue);

    }

    @Override
    public List getkomDeliverableViewPagination(int start, int length, String searchValue, String username, String orderColumn, String orderDir) {
        return kickOffFormDao.getkomDeliverableViewPagination(start, length, searchValue, username, orderColumn, orderDir);

    }

    @Override
    public int getTotalkomDeliverableViewCount(String username) {
        return kickOffFormDao.getTotalkomDeliverableViewCount(username);
    }

    @Override
    public int getFilteredkomDeliverableViewCount(String username, String searchValue) {
        return kickOffFormDao.getFilteredkomDeliverableViewCount(username, searchValue);
    }

    @Override
    public int countAllKom() {
        return kickOffFormDao.countAllKom();
    }

    @Override
    public int countAllKomDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return kickOffFormDao.countAllKomDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public List getTotalKOMPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return kickOffFormDao.getTotalKOMPagination(start, length, searchValue, orderColumn, orderDir, Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int getTotalKOMCount(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return kickOffFormDao.getTotalKOMCount(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int getFilteredTotalKOMCount(String searchValue, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return kickOffFormDao.getFilteredTotalKOMCount(searchValue, Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int readByFlagone() {
        return kickOffFormDao.readByFlagone();
    }

    @Override
    public int readByFlagoneDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return kickOffFormDao.readByFlagoneDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public List getTotalApproveKOMPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return kickOffFormDao.getTotalApproveKOMPagination(start, length, searchValue, orderColumn, orderDir, Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int getTotalApproveKOMCount(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return kickOffFormDao.getTotalApproveKOMCount(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int getFilteredTotalApproveKOMCount(String searchValue, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return kickOffFormDao.getFilteredTotalApproveKOMCount(searchValue, Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int readByPendingKOM() {
        return kickOffFormDao.readByPendingKOM();
    }

    @Override
    public int readByPendingKOMDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return kickOffFormDao.readByPendingKOMDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public List getPendingKOMPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return kickOffFormDao.getPendingKOMPagination(start, length, searchValue, orderColumn, orderDir, Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int getPendingKOMCount(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return kickOffFormDao.getPendingKOMCount(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int getFilteredPendingKOMCount(String searchValue, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return kickOffFormDao.getFilteredPendingKOMCount(searchValue, Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int readByFlagThree() {
        return kickOffFormDao.readByFlagThree();
    }

    @Override
    public int readByFlagThreeDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return kickOffFormDao.readByFlagThreeDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public List getRejectedKOMPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return kickOffFormDao.getRejectedKOMPagination(start, length, searchValue, orderColumn, orderDir, Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int getRejectedKOMCount(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return kickOffFormDao.getRejectedKOMCount(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int getFilteredRejectedKOMCount(String searchValue, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return kickOffFormDao.getFilteredRejectedKOMCount(searchValue, Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

}
