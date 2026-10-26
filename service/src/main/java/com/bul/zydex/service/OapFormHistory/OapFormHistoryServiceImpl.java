/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.OapFormHistory;

import com.bul.zydex.dao.OapFormHistory.OapFormHistoryDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Admin
 */
public class OapFormHistoryServiceImpl<T> extends GenericsServiceImpl<T> implements OapFormHistoryService<T> {

    private OapFormHistoryDao<T> oapFormHistoryDao;

    public OapFormHistoryDao<T> getOapFormHistoryDao() {
        return oapFormHistoryDao;
    }

    public void setOapFormHistoryDao(OapFormHistoryDao<T> oapFormHistoryDao) {
        this.oapFormHistoryDao = oapFormHistoryDao;
        setGenericsDAO(oapFormHistoryDao);
    }

    @Override
    public List readBylasttimestatus(int id1) {

        return oapFormHistoryDao.readBylasttimestatus(id1);
    }

    @Override
    public List readByoapid(String id) {
        return oapFormHistoryDao.readByoapid(id);

    }

    @Override
    public List readBydocumentno(String documentNo) {
        return oapFormHistoryDao.readBydocumentno(documentNo);

    }
}
