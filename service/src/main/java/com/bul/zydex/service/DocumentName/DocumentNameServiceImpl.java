/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.DocumentName;

import com.bul.zydex.dao.DocumentName.DocumentNameDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class DocumentNameServiceImpl<T> extends GenericsServiceImpl<T> implements DocumentNameService<T> {

    private DocumentNameDao<T> documentNameDao;

    public DocumentNameDao<T> getDocumentNameDao() {
	return documentNameDao;
    }

    public void setDocumentNameDao(DocumentNameDao<T> documentNameDao) {
	this.documentNameDao = documentNameDao;
	setGenericsDAO(documentNameDao);
    }

    @Override
    public List readAll() {
	return documentNameDao.readAll();
    }

    @Override
    public List readBystate(String state) {
	return documentNameDao.readBystate(state);
    }

    @Override
    public List readByStateName(String state) {
	return documentNameDao.readByStateName(state);
    }

    @Override
    public List readyBydisconn(int discom, int connection) {
	return documentNameDao.readyBydisconn(discom, connection);

    }

    @Override
    public List readByall() {
	return documentNameDao.readByall();

    }

}
