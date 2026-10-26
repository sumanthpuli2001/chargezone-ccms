/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.DocumentForNewElectricityConnection;

import com.bul.zydex.dao.DocumentForNewElectricityConnection.DocumentForNewElectricityConnectionDao;
import com.bul.zydex.service.GenericsServiceImpl;

/**
 *
 * @author Sumanth
 */
public class DocumentForNewElectricityConnectionServiceImpl<T> extends GenericsServiceImpl<T> implements DocumentForNewElectricityConnectionService<T> {
 
    private DocumentForNewElectricityConnectionDao<T> documentForNewElectricityConnectionDao;

    public DocumentForNewElectricityConnectionDao<T> getDocumentForNewElectricityConnectionDao() {
        return documentForNewElectricityConnectionDao;
    }

    public void setDocumentForNewElectricityConnectionDao(DocumentForNewElectricityConnectionDao<T> documentForNewElectricityConnectionDao) {
        this.documentForNewElectricityConnectionDao = documentForNewElectricityConnectionDao;
        setGenericsDAO(documentForNewElectricityConnectionDao);
        
    }
    
}
