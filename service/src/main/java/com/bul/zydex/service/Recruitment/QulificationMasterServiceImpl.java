/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Recruitment;

import com.bul.zydex.dao.Recruitment.QulificationMasterDAO;
import com.bul.zydex.service.GenericsServiceImpl;

/**
 *
 * @author Vikas
 */
public class QulificationMasterServiceImpl<T> extends GenericsServiceImpl<T> implements QulificationMasterService<T>{
    
    private QulificationMasterDAO<T> QulificationMasterDAO; 

    public QulificationMasterDAO<T> getQulificationMasterDAO() {
        return QulificationMasterDAO;
    }

    public void setQulificationMasterDAO(QulificationMasterDAO<T> QulificationMasterDAO) {
        this.QulificationMasterDAO = QulificationMasterDAO;
    }
    
}
