/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Approval;

import com.bul.zydex.model.ApprovalMaster;
import com.bul.zydex.service.GenericsService;

/**
 *
 * @author Vikas
 */
public interface ApprovalMasterService<T> extends GenericsService<T>{
    
    public ApprovalMaster approvalId(int aprId);
    
}
