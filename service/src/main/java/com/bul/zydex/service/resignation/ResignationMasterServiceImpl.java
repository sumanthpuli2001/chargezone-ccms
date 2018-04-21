/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.resignation;

import com.bul.zydex.dao.resignation.ResignationMasterDAO;
import com.bul.zydex.model.ResignationMaster;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author dhruv
 */
public class ResignationMasterServiceImpl<T> extends GenericsServiceImpl<T> implements ResignationMasterService<T> {

    private ResignationMasterDAO<T> resignationMasterDAO;

    public ResignationMasterDAO<T> getResignationMasterDAO() {
        return resignationMasterDAO;
    }

    public void setResignationMasterDAO(ResignationMasterDAO<T> resignationMasterDAO) {
        this.resignationMasterDAO = resignationMasterDAO;
        setGenericsDAO(resignationMasterDAO);
    }

    @Override
    public List<?> readByEmpID(int id) {
        return resignationMasterDAO.readByEmpID(id);
    }

    @Override
    public List<?> readRegStatusList(T object) {
        return resignationMasterDAO.readRegStatusList(object);
    }

    @Override
    public List<?> readApprovedList(int id) {
        return resignationMasterDAO.readApprovedList(id);
    }

    @Override
    public List<?> readByResignationPendingRequest(T object) {
        return resignationMasterDAO.readByResignationPendingRequest(object);
    }

    @Override
    public List<?> readforapprover(T object) {
        return resignationMasterDAO.readforapprover(object);
    }

    @Override
    public List<?> readforHR(T object) {
        return resignationMasterDAO.readforHR(object);
    }

    @Override
    public List<?> readExistingList(int id) {
        return resignationMasterDAO.readExistingList(id);
    }

    @Override
    public List<?> readmanager1(int id) {
        return resignationMasterDAO.readmanager1(id);
    }

    @Override
    public List<?> readSearchRequest(T object) {
        return resignationMasterDAO.readSearchRequest(object);
    }

    @Override
    public List<?> readmanagerSearchRequest(T object) {
        return resignationMasterDAO.readmanagerSearchRequest(object);
    }

    @Override
    public List<?> readresignationApproverPendingRequest(T object) {
        return resignationMasterDAO.readresignationApproverPendingRequest(object);
    }

    @Override
    public List<?> readEmpIdFromTabId(int id) {
        return resignationMasterDAO.readEmpIdFromTabId(id);
    }

    @Override
    public List<?> readResignedEmployees() {
        return resignationMasterDAO.readResignedEmployees();
    }

    @Override
    public List<?> getFinallyResignedEmployees() {
        return resignationMasterDAO.getFinallyResignedEmployees();
    }

    @Override
     public List<?> getFinallyResignedEmployeesForDashBoard(String employeeId,boolean  employeeExit,boolean  itAdmin,boolean  travelAdmin) {
        return resignationMasterDAO.getFinallyResignedEmployeesForDashBoard(employeeId,employeeExit,itAdmin,travelAdmin);
    }

    @Override
    public ResignationMaster readByEmpId(int EmpId) {
          return resignationMasterDAO.readByEmpId(EmpId);
    }
}
