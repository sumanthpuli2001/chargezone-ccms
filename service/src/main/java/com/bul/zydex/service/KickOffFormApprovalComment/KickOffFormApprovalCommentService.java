/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.KickOffFormApprovalComment;

import com.bul.zydex.model.KickOffFormApprovalComment;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public interface KickOffFormApprovalCommentService<T> extends GenericsService<T> {

    public KickOffFormApprovalComment readByApproveId(int approvalid);

    public List readByapproveId(int approvalid);
    
}
