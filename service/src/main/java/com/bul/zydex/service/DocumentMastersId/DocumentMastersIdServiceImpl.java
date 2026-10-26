/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.DocumentMastersId;

import com.bul.zydex.dao.DocumentMastersId.DocumentMastersIdDao;
import com.bul.zydex.model.DocumentMastersId;
import com.bul.zydex.service.GenericsServiceImpl;

/**
 *
 * @author Sumanth
 */
public class DocumentMastersIdServiceImpl<T> extends GenericsServiceImpl<T> implements DocumentMastersIdService<T> {
        private DocumentMastersIdDao<T> documentMastersIdDao; 

    public DocumentMastersIdDao<T> getDocumentMastersIdDao() {
	return documentMastersIdDao;
    }

    public void setDocumentMastersIdDao(DocumentMastersIdDao<T> documentMastersIdDao) {
	this.documentMastersIdDao = documentMastersIdDao;
	setGenericsDAO(documentMastersIdDao);
	
    }

    @Override
    public DocumentMastersId readByDocumentNo() {
	return documentMastersIdDao.readByDocumentNo();
	
	
	
    }

	
}
