/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Vendor;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.VendorRequestApprovalComment;

/**
 *
 * @author bulwarks-2
 */
public interface VendorRequestApprovalCommentDao<T> extends GenericsDAO<T> {

    public VendorRequestApprovalComment readByApproveId(int approvalid);
    
}
