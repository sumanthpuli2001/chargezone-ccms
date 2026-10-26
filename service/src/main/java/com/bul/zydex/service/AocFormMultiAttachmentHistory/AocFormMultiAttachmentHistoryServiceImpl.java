/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.AocFormMultiAttachmentHistory;

import com.bul.zydex.dao.AocFormMultiAttachementHistory.AocFormMultiAttachementHistoryDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Admin
 */
public class AocFormMultiAttachmentHistoryServiceImpl<T> extends GenericsServiceImpl<T> implements AocFormMultiAttachmentHistoryService<T> {

    private AocFormMultiAttachementHistoryDao<T> aocFormMultiAttachementHistoryDao;

    public AocFormMultiAttachementHistoryDao<T> getAocFormMultiAttachementHistoryDao() {
	return aocFormMultiAttachementHistoryDao;
    }

    public void setAocFormMultiAttachementHistoryDao(AocFormMultiAttachementHistoryDao<T> aocFormMultiAttachementHistoryDao) {
	this.aocFormMultiAttachementHistoryDao = aocFormMultiAttachementHistoryDao;
	setGenericsDAO(aocFormMultiAttachementHistoryDao);
    }

    @Override
    public List readByMulti(int oaphistoryid) {

	return aocFormMultiAttachementHistoryDao.readByMulti(oaphistoryid);
    }

    @Override
    public List readByMulti1(String id) {
	return aocFormMultiAttachementHistoryDao.readByMulti1(id);

    }
}
