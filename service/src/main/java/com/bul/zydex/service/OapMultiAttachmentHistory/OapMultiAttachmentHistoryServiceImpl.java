/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.OapMultiAttachmentHistory;

import com.bul.zydex.dao.OapFormMultiAttachementHistory.OapFormMultiAttachementHistoryDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Admin
 */
public class OapMultiAttachmentHistoryServiceImpl<T> extends GenericsServiceImpl<T> implements OapMultiAttachmentHistoryService<T> {

    private OapFormMultiAttachementHistoryDao<T> oapFormMultiAttachementHistoryDao;

    public OapFormMultiAttachementHistoryDao<T> getOapFormMultiAttachementHistoryDao() {
	return oapFormMultiAttachementHistoryDao;
    }

    public void setOapFormMultiAttachementHistoryDao(OapFormMultiAttachementHistoryDao<T> oapFormMultiAttachementHistoryDao) {
	this.oapFormMultiAttachementHistoryDao = oapFormMultiAttachementHistoryDao;
	setGenericsDAO(oapFormMultiAttachementHistoryDao);
    }

    @Override
    public List readByMulti(int oaphistoryid) {

	return oapFormMultiAttachementHistoryDao.readByMulti(oaphistoryid);
    }

    @Override
    public List readByMulti1(String id) {
	return oapFormMultiAttachementHistoryDao.readByMulti1(id);
    }

}
