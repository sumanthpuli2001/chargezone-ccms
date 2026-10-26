/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.AocFormHistory;

import com.bul.zydex.dao.AocFormHistory.AocFormHistoryDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Admin
 */
public class AocFormHistoryServiceImpl<T> extends GenericsServiceImpl<T> implements AocFormHistoryService<T> {

    private AocFormHistoryDao<T> aocFormHistoryDao;

    public AocFormHistoryDao<T> getAocFormHistoryDao() {
	return aocFormHistoryDao;
    }

    public void setAocFormHistoryDao(AocFormHistoryDao<T> aocFormHistoryDao) {
	this.aocFormHistoryDao = aocFormHistoryDao;
	setGenericsDAO(aocFormHistoryDao);
    }

    @Override
    public List readBylasttimestatus(int id1) {
	return aocFormHistoryDao.readBylasttimestatus(id1);
    }

    @Override
    public List readByaocid(String id) {
	return aocFormHistoryDao.readByaocid(id);
    }
}
