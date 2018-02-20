/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Approval;

import com.bul.zydex.dao.Approval.ApprovalMasterDAO;
import com.bul.zydex.service.GenericsServiceImpl;

/**
 *
 * @author Vikas
 */
public class ApprovalMasterServiceImpl<T> extends GenericsServiceImpl<T> implements ApprovalMasterService<T>{
    
    private ApprovalMasterDAO<T> approvalMasterDAO;

    public ApprovalMasterDAO<T> getApprovalMasterDAO() {
        return approvalMasterDAO;
    }

    public void setApprovalMasterDAO(ApprovalMasterDAO<T> approvalMasterDAO) {
        this.approvalMasterDAO = approvalMasterDAO;
        setGenericsDAO(approvalMasterDAO);
    }
    
    
    
}
