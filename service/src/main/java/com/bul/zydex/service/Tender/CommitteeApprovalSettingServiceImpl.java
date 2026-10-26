/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.dao.Tender.CommitteeApprovalSettingDao;
import com.bul.zydex.model.CommitteeApprovalSetting;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Bulwark-4
 */
public class CommitteeApprovalSettingServiceImpl<T> extends GenericsServiceImpl<T> implements CommitteeApprovalSettingService<T> {
    
    private CommitteeApprovalSettingDao<T> committeeApprovalSettingDao ;

    public CommitteeApprovalSettingDao<T> getCommitteeApprovalSettingDao() {
        return committeeApprovalSettingDao;
    }

    public void setCommitteeApprovalSettingDao(CommitteeApprovalSettingDao<T> committeeApprovalSettingDao) {
        this.committeeApprovalSettingDao = committeeApprovalSettingDao;
        setGenericsDAO(committeeApprovalSettingDao);
    }

    @Override
    public CommitteeApprovalSetting readByName(String technical_committee) {
        return committeeApprovalSettingDao.readByName(technical_committee);
    }

    @Override
    public List getCommitteePagination(int start, int length, String searchValue, String orderColumn, String orderDir) {
        return committeeApprovalSettingDao.getCommitteePagination(start, length, searchValue, orderColumn, orderDir);
    }

    @Override
    public int getTotalCommitteeCount() {
        return committeeApprovalSettingDao.getTotalCommitteeCount();
    }

    @Override
    public int getFilteredCommitteeCount(String search) {
        return committeeApprovalSettingDao.getFilteredCommitteeCount(search);
    }
    
    
    
    
}
