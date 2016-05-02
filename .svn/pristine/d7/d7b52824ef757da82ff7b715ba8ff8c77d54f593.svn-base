/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.nodue;

import com.bul.zydex.dao.nodue.NoDueMasterDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author dhruv
 */
public class NoDueMasterServiceImpl<T> extends GenericsServiceImpl<T> implements NoDueMasterService<T> {

    private NoDueMasterDAO<T> noDueMasterDAO;

    public NoDueMasterDAO<T> getNoDueMasterDAO() {
        return noDueMasterDAO;
    }

    public void setNoDueMasterDAO(NoDueMasterDAO<T> noDueMasterDAO) {
        this.noDueMasterDAO = noDueMasterDAO;
        setGenericsDAO(noDueMasterDAO);
    }

    @Override
    public List<?> readNoDueApprovalList() {
        return noDueMasterDAO.readNoDueApprovalList();
    }

    @Override
    public List<?> readNoDueReturnList(int id) {
        return noDueMasterDAO.readNoDueReturnList(id);
    }

    @Override
    public List<?> readNoDueStatusList(T object) {
        return noDueMasterDAO.readNoDueStatusList(object);
    }

    @Override
    public List<?> readApprovedList(int id) {
        return noDueMasterDAO.readApprovedList(id);
    }

    @Override
    public List<?> readExistingemployee(int id) {
        return noDueMasterDAO.readExistingemployee(id);
    }

    @Override
    public List<?> readforemp(T object) {
        return noDueMasterDAO.readforemp(object);
    }

    @Override
    public List<?> readSearchRequest(T object) {
        return noDueMasterDAO.readSearchRequest(object);
    }

    @Override
    public List<?> readEmpIdFromTabId(int id) {
        return noDueMasterDAO.readEmpIdFromTabId(id);
    }

    @Override
    public List<?> getNoDueByEmpId(final int empId) {
        return noDueMasterDAO.getNoDueByEmpId(empId);
    }
}
