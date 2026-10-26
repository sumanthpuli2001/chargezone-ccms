/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.AocFormApprovalComment;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.AocFormApprovalComment;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public interface AocFormApprovalCommentDao<T> extends GenericsDAO<T> {

    public AocFormApprovalComment readByApproveId(int approvalid);

    public List readByIds(String id);
    
}
