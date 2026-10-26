/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.KickOffFormApprovalComment;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.KickOffFormApprovalComment;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public interface KickOffFormApprovalCommentDao<T> extends GenericsDAO<T> {

    public KickOffFormApprovalComment readByApproveId(int approvalid);

    public List readByapproveId(int approvalid);
    
}
