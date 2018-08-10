/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Approval;

import com.bul.zydex.dao.Approval.ApprovalUserDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Vikas
 */
public class ApprovalUserServiceImpl<T> extends GenericsServiceImpl<T> implements ApprovalUserService<T> {

    private ApprovalUserDAO<T> approvalUserDAO;

    public ApprovalUserDAO<T> getApprovalUserDAO() {
        return approvalUserDAO;
    }

    public void setApprovalUserDAO(ApprovalUserDAO<T> approvalUserDAO) {
        this.approvalUserDAO = approvalUserDAO;
        setGenericsDAO(approvalUserDAO);
    }

    @Override
    public List<?> readByApprovalId(int id) {
        return approvalUserDAO.readByApprovalId(id);
    }

    @Override
    public List<?> readapprovalempId() {
        return approvalUserDAO.readapprovalempId();
    }

    @Override
    public List<?> reademyId(int emid) {
        return approvalUserDAO.reademyId(emid);
    }

    @Override
    public List<?> readByApprovalFetch(int apid) {
         return approvalUserDAO.readByApprovalFetch(apid);
    }

    @Override
    public List<?> approvaldelete(String apid) {
        return approvalUserDAO.approvaldelete(apid);
    }

    @Override
    public List<?> readByApId(int id) {
        return approvalUserDAO.readByApId(id);
    }

    @Override
    public List<?> readApprovalUser(String approvalMasterId) {
        return approvalUserDAO.readApprovalUser(approvalMasterId);
    }

    @Override
    public List<?> readByapprovalId(int id) {
        return approvalUserDAO.readByapprovalId(id);
    }

    }
