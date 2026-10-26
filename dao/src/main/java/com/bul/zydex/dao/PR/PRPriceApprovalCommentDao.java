/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.PR;

import com.bul.zydex.dao.Tender.*;
import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.PRPriceApprovalComment;
import com.bul.zydex.model.TenderCommittee;
import com.bul.zydex.model.TenderPriceApprovalComment;
import java.util.List;

/**
 *
 * @author admin
 */
public interface PRPriceApprovalCommentDao<T> extends GenericsDAO<T> {

    public PRPriceApprovalComment readByApproveId(int approveId);

   

   
    
}
