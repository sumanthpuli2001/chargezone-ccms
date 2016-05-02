/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.emprequest;

import com.bul.zydex.dao.emprequest.PoolCarRequestDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Vinita
 */
public class PoolCarRequestServiceImpl<T> extends GenericsServiceImpl<T> implements PoolCarRequestService<T>{
    
    private PoolCarRequestDAO poolCarRequestDAO;

    public PoolCarRequestDAO getPoolCarRequestDAO() {
        return poolCarRequestDAO;
    }

    public void setPoolCarRequestDAO(PoolCarRequestDAO poolCarRequestDAO) {
        this.poolCarRequestDAO = poolCarRequestDAO;
         setGenericsDAO(poolCarRequestDAO);
    }
//
//    @Override
//    public List<?> readByUserMasterId(T object) {
//        return poolCarRequestDAO.readByUserMasterId(object);
//    }
    @Override
    public List<?> readByrequesteeId(T object) {
        return poolCarRequestDAO.readByrequesteeId(object);
    }

    @Override
    public List<?> readByapproverId(T object) {
         return poolCarRequestDAO.readByapproverId(object);
    }

    @Override
    public List<?> readByEmpId(T object) {
         return poolCarRequestDAO.readByEmpId(object);
    }
//    

    @Override
    public List<?> readSearchRequest(T object) {
        return poolCarRequestDAO.readSearchRequest(object);
    }

    @Override
    public List<?> readSearchEmpRequest(T object) {
        return poolCarRequestDAO.readSearchEmpRequest(object);

    }
    @Override
     public List<?> readByPoolCarPendingRequest(T object) {
        return poolCarRequestDAO.readByPoolCarPendingRequest(object);
    }

    @Override
    public boolean isExist(T object) {
        return poolCarRequestDAO.isExist(object);
    }
    @Override
     public List<?> readByApproverWisePoolCarPendingRequest(T object) {
        return poolCarRequestDAO.readByApproverWisePoolCarPendingRequest(object);
    }

    @Override
    public List<?> readEmpIdFromTabId(int id) {
        return poolCarRequestDAO.readEmpIdFromTabId(id);
    }
}
