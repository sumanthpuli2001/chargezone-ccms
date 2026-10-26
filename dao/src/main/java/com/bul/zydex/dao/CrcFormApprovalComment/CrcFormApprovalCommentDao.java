/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.CrcFormApprovalComment;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.CrcFormApprovalComment;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public interface CrcFormApprovalCommentDao<T> extends GenericsDAO<T> {

    public CrcFormApprovalComment readByApproveId(int approvalid);

    public List readBycrcformid(int crcformid);

    public List readBycrcFormApprovalid(int crcFormApprovalid);
    
}
