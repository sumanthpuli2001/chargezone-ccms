/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Invoice;

import com.bul.zydex.dao.Invoice.DocumentTypeDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Admin
 */
public class DocumentTypeServiceImpl<T> extends GenericsServiceImpl<T> implements DocumentTypeService<T> {

    private DocumentTypeDao<T> documentTypeDao;

    public DocumentTypeDao<T> getDocumentTypeDao() {
        return documentTypeDao;
    }

    public void setDocumentTypeDao(DocumentTypeDao<T> documentTypeDao) {
        this.documentTypeDao = documentTypeDao;
        setGenericsDAO(documentTypeDao);
    }

    @Override
    public List getDocumentPagination(int start, int length, String searchValue, String orderColumn, String orderDir) {
        return documentTypeDao.getDocumentPagination(start, length, searchValue, orderColumn, orderDir);
    }

    @Override
    public int getTotalChargerCount() {
        return documentTypeDao.getTotalChargerCount();
    }

    @Override
    public int getFilteredChargerCount(String searchValue) {
        return documentTypeDao.getFilteredChargerCount(searchValue);
    }

}
