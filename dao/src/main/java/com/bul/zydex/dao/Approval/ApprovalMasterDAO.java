/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Approval;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.ApprovalMaster;

/**
 *
 * @author Vikas
 */
public interface ApprovalMasterDAO<T> extends GenericsDAO<T>{
    
    public ApprovalMaster approvalId(int aprId);
    
    public ApprovalMaster readByapprovalname(String name);
    
}
