/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.CrcFormApprovalComment;

import com.bul.zydex.model.CrcFormApprovalComment;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public interface CrcFormApprovalCommentService<T> extends GenericsService<T> {

    public CrcFormApprovalComment readByApproveId(int approvalid);

    public List readBycrcformid(int crcformid);

    public List readBycrcFormApprovalid(int crcFormApprovalid);
    
}
