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

    @Override
    public int countVisitorManagementPendingRequest(T object) {
        return visitorManagementDAO.countVisitorManagementPendingRequest(object);
    }

    @Override
    public int countVisitorManagementApproverPendingRequest(T object) {
        return visitorManagementDAO.countVisitorManagementApproverPendingRequest(object);
    }

    @Override
    public List<?> readSearchEmpRequestForSessionEmployee(Integer id, String startDate, String endDate, String status) {
        return visitorManagementDAO.readSearchEmpRequestForSessionEmployee(id, startDate, endDate, status);
    }

    @Override
    public List<?> readByapproverId(String employeeId, String designationId, String departmentId, String startDate, String endDate, String status) {
        return visitorManagementDAO.readByapproverId(employeeId, designationId, departmentId, startDate, endDate, status);
    }
    

}
