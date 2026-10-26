/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.DocumentForNewElectricityConnection;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.DocumentForNewElectricityConnection;

/**
 *
 * @author Sumanth
 */
public class DocumentForNewElectricityConnectionDaoImpl<T> extends GenericsDAOImpl<T> implements DocumentForNewElectricityConnectionDao<T>  {

    @Override
    protected Class getDomainClass() {
        return DocumentForNewElectricityConnection.class;
    }
    
}
