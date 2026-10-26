/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.dao.Tender.LiveTenderDao;
import com.bul.zydex.model.LiveTender;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class LiveTenderServiceImpl<T> extends GenericsServiceImpl<T> implements LiveTenderService<T> {
    
    private LiveTenderDao<T> liveTenderDao;

    public LiveTenderDao<T> getLiveTenderDao() {
        return liveTenderDao;
    }

    public void setLiveTenderDao(LiveTenderDao<T> liveTenderDao) {
        this.liveTenderDao = liveTenderDao;
        setGenericsDAO(liveTenderDao);
    }

    @Override
    public List readByTender(String tenderno) {
        return liveTenderDao.readByTender(tenderno);
    }

    @Override
    public List readBySerch(String tender_no, String description) {
        return liveTenderDao.readBySerch(tender_no, description);
    }

    @Override
    public void updateTender(String tenderno, String description, String technicalfile) {
        liveTenderDao.updateTender(tenderno, description, technicalfile);
    }
}
