/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.ProjectManagement;

import com.bul.zydex.dao.ProjectManagement.ClientMasterDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Aman
 */
public class ClientMasterServiceImpl<T> extends GenericsServiceImpl<T> implements ClientMasterService<T>{
    
    private ClientMasterDAO<T> clientMasterDAO;

    public ClientMasterDAO<T> getClientMasterDAO() {
        return clientMasterDAO;
    }

    public void setClientMasterDAO(ClientMasterDAO<T> clientMasterDAO) {
        this.clientMasterDAO = clientMasterDAO;
        setGenericsDAO(clientMasterDAO);
    }

    @Override
    public List<?> readClientMaster() {
        return clientMasterDAO.readClientMaster();
    }

    @Override
    public List<?> deleteClientMaster(String clientMasterId) {
        return  clientMasterDAO.deleteClientMaster(clientMasterId);
    }
    
    
    
}
