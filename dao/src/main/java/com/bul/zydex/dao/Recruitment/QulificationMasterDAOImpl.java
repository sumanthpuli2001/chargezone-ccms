/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Recruitment;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.QulificationMaster;

/**
 *
 * @author Vikas
 */
public class QulificationMasterDAOImpl<T> extends GenericsDAOImpl<T> implements QulificationMasterDAO<T>{

    @Override
    protected Class getDomainClass() {
        return QulificationMaster.class;
    }
    
}
