/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.AuditorMaster;

import com.bul.zydex.dao.AuditorMaster.AuditorMasterDao;
import com.bul.zydex.model.AuditorMaster;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bulwarks-2
 */
public class AuditorMasterServiceImpl<T> extends GenericsServiceImpl<T> implements AuditorMasterService<T> {

    private AuditorMasterDao<T> auditorMasterDao;

    public AuditorMasterDao<T> getAuditorMasterDao() {
        return auditorMasterDao;
    }

    public void setAuditorMasterDao(AuditorMasterDao<T> auditorMasterDao) {
        this.auditorMasterDao = auditorMasterDao;
        setGenericsDAO(auditorMasterDao);
    }

    @Override
    public List readByCategoryHigh() {
        return auditorMasterDao.readByCategoryHigh();
    }

    @Override
    public List readByCategoryMedium() {
        return auditorMasterDao.readByCategoryMedium();
    }

    @Override
    public AuditorMaster readByAuditorCode(String auditor) {
        return auditorMasterDao.readByAuditorCode(auditor);
    }

    @Override
    public List getAuditorPagination(int start, int length, String searchValue, String orderColumn, String orderDir) {

        return auditorMasterDao.getAuditorPagination(start, length, searchValue, orderColumn, orderDir);

    }

    @Override
    public int getTotalAuditorCount() {
        return auditorMasterDao.getTotalAuditorCount();
    }

    @Override
    public int getFilteredAuditorCount(String search) {
        return auditorMasterDao.getFilteredAuditorCount(search);

    }

}
