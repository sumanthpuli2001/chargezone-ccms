/*
 * 
 * Author Vinita
 */

package com.bul.zydex.service.emprequest;

import com.bul.zydex.dao.emprequest.VisitorManagementDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Vinita
 */
public class VisitorManagementServiceImpl<T> extends GenericsServiceImpl<T> implements VisitorManagementService<T>{
    
    private VisitorManagementDAO visitorManagementDAO;

    public VisitorManagementDAO getVisitorManagementDAO() {
        return visitorManagementDAO;
    }

    public void setVisitorManagementDAO(VisitorManagementDAO visitorManagementDAO) {
        this.visitorManagementDAO = visitorManagementDAO;
        setGenericsDAO(visitorManagementDAO);
    }

    @Override
    public List<?> readByrequesteeId(T object) {
        return visitorManagementDAO.readByrequesteeId(object);
    }

    @Override
    public List<?> readByapproverId(T object) {
        return visitorManagementDAO.readByapproverId(object);
    }

    @Override
    public List<?> readByEmpId(T object) {
        return visitorManagementDAO.readByEmpId(object);
    }

    @Override
    public List<?> readSearchEmpRequest(T object) {
        return visitorManagementDAO.readSearchEmpRequest(object);
    }

    @Override
    public List<?> readSearchRequest(T object) {
         return visitorManagementDAO.readSearchRequest(object);
    }
    @Override
    public List<?> readVisitorManagementPendingRequest(T object) {
         return visitorManagementDAO.readVisitorManagementPendingRequest(object);
    }
    @Override
    public List<?> readVisitorManagementApproverPendingRequest(T object) {
         return visitorManagementDAO.readVisitorManagementApproverPendingRequest(object);
    }

    @Override
    public List<?> readEmpIdFromTabId(int id) {
         return visitorManagementDAO.readEmpIdFromTabId(id);
    }
    

}
