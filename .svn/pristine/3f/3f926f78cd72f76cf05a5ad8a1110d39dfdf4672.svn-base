/*
 * 
 * Author Vinita
 */

package com.bul.zydex.service.emprequest;

import com.bul.zydex.dao.emprequest.CafeteriaRequestDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Vinita
 */
public class CafeteriaRequestServiceImpl<T> extends GenericsServiceImpl<T> implements CafeteriaRequestService<T>{
    
    private CafeteriaRequestDAO cafeteriaRequestDAO;

    public CafeteriaRequestDAO getCafeteriaRequestDAO() {
        return cafeteriaRequestDAO;
    }

    public void setCafeteriaRequestDAO(CafeteriaRequestDAO cafeteriaRequestDAO) {
        this.cafeteriaRequestDAO = cafeteriaRequestDAO;
        setGenericsDAO(cafeteriaRequestDAO);
    }

    @Override
    public List<?> readByEmpId(T object) {
        return cafeteriaRequestDAO.readByEmpId(object);
    }

    @Override
    public List<?> readByrequesteeId(T object) {
         return cafeteriaRequestDAO.readByrequesteeId(object);
    }

    @Override
    public List<?> readByapproverId(T object) {
        return cafeteriaRequestDAO.readByapproverId(object);
    }

    @Override
    public List<?> readSearchEmpRequest(T object) {
        return cafeteriaRequestDAO.readSearchEmpRequest(object);
    }

    @Override
    public List<?> readSearchRequest(T object) {
        return cafeteriaRequestDAO.readSearchRequest(object);

    }
    @Override
    public List<?> readByCafeTeriaPendingRequest(T object) {
        return cafeteriaRequestDAO.readByCafeTeriaPendingRequest(object);
    }
    @Override
    public List<?> readByCafeTeriaApproverPendingRequest(T object) {
        return cafeteriaRequestDAO.readByCafeTeriaApproverPendingRequest(object);
    }

    @Override
    public List<?> readEmpIdFromTabId(int id) {
        return cafeteriaRequestDAO.readEmpIdFromTabId(id);
    }
    
    

}
