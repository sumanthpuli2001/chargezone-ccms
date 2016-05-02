/*
 * 
 * Author Vinita
 */

package com.bul.zydex.service.emprequest;

import com.bul.zydex.dao.emprequest.ItServiceRequestDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Vinita
 */
public class ItServiceRequestServiceImpl<T> extends GenericsServiceImpl<T> implements ItServiceRequestService<T>{
    
    
    private ItServiceRequestDAO itServiceRequestDAO;

    public ItServiceRequestDAO getItServiceRequestDAO() {
        return itServiceRequestDAO;
    }

    public void setItServiceRequestDAO(ItServiceRequestDAO itServiceRequestDAO) {
        this.itServiceRequestDAO = itServiceRequestDAO;
        setGenericsDAO(itServiceRequestDAO);
    }

    @Override
    public List<?> readByEmpId(T object) {
        return itServiceRequestDAO.readByEmpId(object);
    }

    @Override
    public List<?> readByrequesteeId(T object) {
         return itServiceRequestDAO.readByrequesteeId(object);
    }

    @Override
    public List<?> readSearchEmpRequest(T object) {
        return itServiceRequestDAO.readSearchEmpRequest(object);
    }

    @Override
    public List<?> readSearchRequest(T object) {
        return itServiceRequestDAO.readSearchRequest(object);
    }

    @Override
    public boolean isExist(T object) {
        return itServiceRequestDAO.isExist(object);
    }
    @Override
     public List<?> readByItServicePendingRequest(T object) {
        return itServiceRequestDAO.readByItServicePendingRequest(object);
    }
    @Override
     public List<?> readByItServiceApproverPendingRequest(T object) {
        return itServiceRequestDAO.readByItServiceApproverPendingRequest(object);
    }
    
    

}
