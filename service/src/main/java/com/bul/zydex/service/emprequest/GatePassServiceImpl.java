/*
 * 
 * Author Vinita
 */

package com.bul.zydex.service.emprequest;

import com.bul.zydex.dao.emprequest.GatePassDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Vinita
 */
public class GatePassServiceImpl<T> extends GenericsServiceImpl<T> implements GatePassService<T>{

    private GatePassDAO gatePassDAO;

    public GatePassDAO getGatePassDAO() {
        return gatePassDAO;
    }

    public void setGatePassDAO(GatePassDAO gatePassDAO) {
        this.gatePassDAO = gatePassDAO;
        setGenericsDAO(gatePassDAO);
    }

    @Override
    public List<?> readByEmpId(T object) {
        return gatePassDAO.readByEmpId(object);
    }

    @Override
    public List<?> readByrequesteeId(T object) {
        return gatePassDAO.readByrequesteeId(object);
    }

    @Override
    public List<?> readByapproverId(T object) {
         return gatePassDAO.readByapproverId(object);
    }

    @Override
    public List<?> readforReturn(T object) {
          return gatePassDAO.readforReturn(object);
    }

    @Override
    public List<?> readSearchEmpRequest(T object) {
        return gatePassDAO.readSearchEmpRequest(object);
    }

    @Override
    public List<?> readSearchRequest(T object) {
        return gatePassDAO.readSearchRequest(object);
    }

    @Override
    public boolean isExist(T object) {
         return gatePassDAO.isExist(object);
    }
    @Override
    public List<?> readByGatePassPendingRequest(T object) {
        return gatePassDAO.readByGatePassPendingRequest(object);
    }
    @Override
    public List<?> readByGatePassApproverPendingRequest(T object) {
        return gatePassDAO.readByGatePassApproverPendingRequest(object);
    }

    @Override
    public List<?> readEmpIdFromTabId(int id) {
        return gatePassDAO.readEmpIdFromTabId(id);
    }

    @Override
    public int countByGatePassPendingRequest(T object) {
        return gatePassDAO.countByGatePassPendingRequest(object);
    }

    @Override
    public int countByGatePassApproverPendingRequest(T object) {
        return gatePassDAO.countByGatePassApproverPendingRequest(object);
    }
    
    
    
}
