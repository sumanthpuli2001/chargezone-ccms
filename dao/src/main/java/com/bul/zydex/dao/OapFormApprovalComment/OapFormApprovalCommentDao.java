/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.OapFormApprovalComment;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.OapFormApprovalComment;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public interface OapFormApprovalCommentDao<T> extends GenericsDAO<T> {

    public OapFormApprovalComment readByApproveId(int approvalid);

    public List readByIds(String id);

    
    
}
