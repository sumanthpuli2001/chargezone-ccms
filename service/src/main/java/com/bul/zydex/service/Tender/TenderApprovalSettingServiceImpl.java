/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.dao.Tender.TenderApprovalSettingDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Bulwark-4
 */
public class TenderApprovalSettingServiceImpl<T> extends GenericsServiceImpl<T> implements TenderApprovalSettingService<T> {
    
    private TenderApprovalSettingDao<T> tenderApprovalSettingDao;

    public TenderApprovalSettingDao<T> getTenderApprovalSettingDao() {
        return tenderApprovalSettingDao;
    }

    public void setTenderApprovalSettingDao(TenderApprovalSettingDao<T> tenderApprovalSettingDao) {
        this.tenderApprovalSettingDao = tenderApprovalSettingDao;
        setGenericsDAO(tenderApprovalSettingDao);
    }

    @Override
    public List getTenderPagination(int start, int length, String searchValue, String orderColumn, String orderDir) {
        return tenderApprovalSettingDao.getTenderPagination(start, length, searchValue, orderColumn, orderDir);
    }

    @Override
    public int getTotalTenderCount() {
        return tenderApprovalSettingDao.getTotalTenderCount();
    }

    @Override
    public int getFilteredTenderCount(String search) {
        return tenderApprovalSettingDao.getFilteredTenderCount(search);
    }

    
    
}
