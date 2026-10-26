/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.DocumentMasterId;

import com.bul.zydex.dao.DocumentMasterId.DocumentMasterIdDao;
import com.bul.zydex.model.DocumentMasterId;
import com.bul.zydex.service.GenericsServiceImpl;

/**
 *
 * @author Sumanth
 */
public class DocumentMasterIdServiceImpl<T> extends GenericsServiceImpl<T> implements DocumentMasterIdService<T> {
    private DocumentMasterIdDao<T> documentMasterIdDao; 

    public DocumentMasterIdDao<T> getDocumentMasterIdDao() {
	return documentMasterIdDao;
    }

    public void setDocumentMasterIdDao(DocumentMasterIdDao<T> documentMasterIdDao) {
	this.documentMasterIdDao = documentMasterIdDao;
	setGenericsDAO(documentMasterIdDao);
	
    }

    @Override
    public DocumentMasterId readByDocumentNo() {
	return documentMasterIdDao.readByDocumentNo();
    }
    
    
}
