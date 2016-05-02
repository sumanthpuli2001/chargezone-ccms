/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.exitInterview;

import com.bul.zydex.dao.exitInterview.ExitInterviewMasterDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.text.ParseException;
import java.util.List;

/**
 *
 * @author dhruv
 */
public class ExitInterviewMasterServiceImpl<T> extends GenericsServiceImpl<T> implements ExitInterviewMasterService<T> {

    private ExitInterviewMasterDAO<T> exitInterviewMasterDAO;

    public ExitInterviewMasterDAO<T> getExitInterviewMasterDAO() {
        return exitInterviewMasterDAO;
    }

    public void setExitInterviewMasterDAO(ExitInterviewMasterDAO<T> exitInterviewMasterDAO) {
        this.exitInterviewMasterDAO = exitInterviewMasterDAO;
        setGenericsDAO(exitInterviewMasterDAO);
    }

    @Override
    public List<?> readExitApprovalList(int appId, int tabId) {
        return exitInterviewMasterDAO.readExitApprovalList(appId, tabId);
    }

    @Override
    public List<?> readExitReturnList(int empId) {
        return exitInterviewMasterDAO.readExitReturnList(empId);
    }

    @Override
    public List<?> readByEmployeeId(int empId) {
        return exitInterviewMasterDAO.readByEmployeeId(empId);
    }

    @Override
    public List<?> readExitApproval2List(int appId, int tabId) {
        return exitInterviewMasterDAO.readExitApproval2List(appId, tabId);
    }

    @Override
    public List<?> readExitStatusList(T object) {
        return exitInterviewMasterDAO.readExitStatusList(object);
    }

    @Override
    public List<?> readApprovedList(int empId) {
        return exitInterviewMasterDAO.readApprovedList(empId);
    }

    @Override
    public List<?> readApproveList(T object) {
         return exitInterviewMasterDAO.readApproveList(object);
    }

    @Override
    public List<?> readforHR(T object) {
        return exitInterviewMasterDAO.readforHR(object);
    }

    @Override
    public List<?> readExistingEmp(int empId) {
         return exitInterviewMasterDAO.readExistingEmp(empId);
    }

    @Override
    public List<?> reademp(T object) {
        return exitInterviewMasterDAO.reademp(object);
        }

    @Override
    public List<?> readEmpIdFromTabId(int id) {
        return exitInterviewMasterDAO.readEmpIdFromTabId(id);
    }

    @Override
    public List<?> readlist() {
         return exitInterviewMasterDAO.readlist();
    }

   
}
