/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.CrcFormHistory;

import com.bul.zydex.dao.CrcFormHistory.CrcFormHistoryDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Admin
 */
public class CrcFormHistoryServiceImpl<T> extends GenericsServiceImpl<T> implements CrcFormHistoryService<T> {

    private CrcFormHistoryDao<T> crcFormHistoryDao;

    public CrcFormHistoryDao<T> getCrcFormHistoryDao() {
	return crcFormHistoryDao;
    }

    public void setCrcFormHistoryDao(CrcFormHistoryDao<T> crcFormHistoryDao) {
	this.crcFormHistoryDao = crcFormHistoryDao;
	setGenericsDAO(crcFormHistoryDao);
    }

    @Override
    public List readBylasttimestatus(String id) {
	return crcFormHistoryDao.readBylasttimestatus(id);

    }

   
}
