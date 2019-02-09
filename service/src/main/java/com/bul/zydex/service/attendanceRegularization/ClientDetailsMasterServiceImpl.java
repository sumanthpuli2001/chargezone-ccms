/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.attendanceRegularization;

import com.bul.zydex.dao.attendanceRegularization.ClientDetailsMasterDAO;
import com.bul.zydex.service.GenericsServiceImpl;

/**
 *
 * @author Success
 */
public class ClientDetailsMasterServiceImpl<T> extends GenericsServiceImpl<T> implements ClientDetailsMasterService<T> {
    
    protected ClientDetailsMasterDAO<T> clientDetailsMasterDAO;    
    
    public ClientDetailsMasterDAO<T> getClientDetailsMasterDAO() {
        return clientDetailsMasterDAO;
    }
    
    public void setClientDetailsMasterDAO(ClientDetailsMasterDAO<T> clientDetailsMasterDAO) {
        this.clientDetailsMasterDAO = clientDetailsMasterDAO;
        setGenericsDAO(clientDetailsMasterDAO);
    }

    @Override
    public boolean isExist(T object) {
        return clientDetailsMasterDAO.isExist(object);
    }
    
}
