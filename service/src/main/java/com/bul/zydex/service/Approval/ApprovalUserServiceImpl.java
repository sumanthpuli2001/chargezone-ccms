/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Approval;

import com.bul.zydex.dao.Approval.ApprovalUserDAO;
import com.bul.zydex.service.GenericsServiceImpl;

/**
 *
 * @author Vikas
 */
public class ApprovalUserServiceImpl<T> extends GenericsServiceImpl<T> implements ApprovalUserService<T>{
    
    private ApprovalUserDAO<T> approvalUserDAO;

    public ApprovalUserDAO<T> getApprovalUserDAO() {
        return approvalUserDAO;
    }

    public void setApprovalUserDAO(ApprovalUserDAO<T> approvalUserDAO) {
        this.approvalUserDAO = approvalUserDAO;
        setGenericsDAO(approvalUserDAO);
    }
    
    
    
}
