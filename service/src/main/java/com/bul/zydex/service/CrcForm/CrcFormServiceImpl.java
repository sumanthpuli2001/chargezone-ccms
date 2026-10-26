/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.CrcForm;

import com.bul.zydex.dao.CrcForm.CrcFormDao;
import com.bul.zydex.model.CrcForm;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class CrcFormServiceImpl<T> extends GenericsServiceImpl<T> implements CrcFormService<T> {

    private CrcFormDao<T> crcFormDao;

    public CrcFormDao<T> getCrcFormDao() {
        return crcFormDao;
    }

    public void setCrcFormDao(CrcFormDao<T> crcFormDao) {
        this.crcFormDao = crcFormDao;
        setGenericsDAO(crcFormDao);
    }

    @Override
    public List readByusername(String username) {

        return crcFormDao.readByusername(username);

    }

    @Override
    public CrcForm readByoapId(String id) {
        return crcFormDao.readByoapId(id);
    }

    @Override
    public List readByoapid(String id) {
        return crcFormDao.readByoapid(id);
    }

    @Override
    public List ApprovalStatus() {
        return crcFormDao.ApprovalStatus();
    }

    @Override
    public CrcForm readByoapIds(int oapformid) {
        return crcFormDao.readByoapIds(oapformid);
    }

    @Override
    public List readDeliverableList(String username) {
        return crcFormDao.readDeliverableList(username);
    }

    @Override
    public List readByFlagTwoDashBoard() {
        return crcFormDao.readByFlagTwoDashBoard();
    }

    @Override
    public List readByFlagThreeDashBoard() {
        return crcFormDao.readByFlagThreeDashBoard();
    }

    @Override
    public List readByPendingCRC() {

        return crcFormDao.readByPendingCRC();

    }

    @Override
    public List readByrevisionCrcDashBorad() {
        return crcFormDao.readByrevisionCrcDashBorad();
    }

    @Override
    public CrcForm readByoapdDocumentNo(String oapDocumentNo) {
        return crcFormDao.readByoapdDocumentNo(oapDocumentNo);

    }

    @Override
    public List getusernamePagination(int start, int length, String searchValue, String username, String orderColumn, String orderDir) {

        return crcFormDao.getusernamePagination(start, length, searchValue, username, orderColumn, orderDir);

    }

    @Override
    public int getTotalusernameCount(String username) {

        return crcFormDao.getTotalusernameCount(username);

    }

    @Override
    public int getFilteredusernameCount(String username, String searchValue) {

        return crcFormDao.getFilteredusernameCount(username, searchValue);
    }

    @Override
    public List getoapDeliverableViewPagination(int start, int length, String searchValue, String username, String orderColumn, String orderDir) {
        return crcFormDao.getoapDeliverableViewPagination(start, length, searchValue, username, orderColumn, orderDir);

    }

    @Override
    public int getTotaloapDeliverableViewCount(String username) {
        return crcFormDao.getTotaloapDeliverableViewCount(username);
    }

    @Override
    public int getFilteredoapDeliverableViewCount(String username, String searchValue) {
        return crcFormDao.getFilteredoapDeliverableViewCount(username, searchValue);
    }

    @Override
    public int countAllCrc() {
        return crcFormDao.countAllCrc();
    }

    @Override
    public int countAllCrcDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return crcFormDao.countAllCrcDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public List getTotalCrcPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return crcFormDao.getTotalCrcPagination(start, length, searchValue, orderColumn, orderDir, Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int getTotalCrcCount(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return crcFormDao.getTotalCrcCount(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int getFilteredTotalCrcCount(String searchValue, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return crcFormDao.getFilteredTotalCrcCount(searchValue, Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int readByFlagFour() {
        return crcFormDao.readByFlagFour();
    }

    @Override
    public int readByFlagFourDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return crcFormDao.readByFlagFourDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public List getTotalApprovedCrcPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return crcFormDao.getTotalApprovedCrcPagination(start, length, searchValue, orderColumn, orderDir, Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int getTotalApprovedCrcCount(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return crcFormDao.getTotalApprovedCrcCount(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int getFilteredTotalApprovedCrcCount(String search, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return crcFormDao.getFilteredTotalApprovedCrcCount(search, Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int readBypendingCrc() {
        return crcFormDao.readBypendingCrc();
    }

    @Override
    public int readBypendingCrcDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return crcFormDao.readBypendingCrcDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public List getPendingCRCPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return crcFormDao.getPendingCRCPagination(start, length, searchValue, orderColumn, orderDir, Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int getPendingCRCCount(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return crcFormDao.getPendingCRCCount(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int getFilteredPendingCRCCount(String searchValue, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return crcFormDao.getFilteredPendingCRCCount(searchValue, Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int readByrevisionCrc() {
        return crcFormDao.readByrevisionCrc();
    }

    @Override
    public int readByrevisionCrcDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return crcFormDao.readByrevisionCrcDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public List getRevisionCRCPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return crcFormDao.getRevisionCRCPagination(start, length, searchValue, orderColumn, orderDir, Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int getTotalRevisionCRCCount(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return crcFormDao.getTotalRevisionCRCCount(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int getFilterdRevisionCRCCount(String search, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return crcFormDao.getFilterdRevisionCRCCount(search, Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int readByFlagTwo() {
        return crcFormDao.readByFlagTwo();
    }

    @Override
    public int readByFlagTwoDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return crcFormDao.readByFlagTwoDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public List getParticiallyPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return crcFormDao.getParticiallyPagination(start, length, searchValue, orderColumn, orderDir, Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int getParticiallyCount(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return crcFormDao.getParticiallyCount(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int getFilteredParticiallyCount(String search, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return crcFormDao.getFilteredParticiallyCount(search, Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int readByFlagThree() {
        return crcFormDao.readByFlagThree();
    }

    @Override
    public int readByFlagThreeDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return crcFormDao.readByFlagThreeDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public List getRejectedPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return crcFormDao.getRejectedPagination(start, length, searchValue, orderColumn, orderDir, Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int getRejectedCount(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return crcFormDao.getRejectedCount(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }

    @Override
    public int getFilteredRejectedCount(String search, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate) {
        return crcFormDao.getFilteredRejectedCount(search, Fromdate, Todate, Filter, formattedDate, formattedStartDate);
    }
}
