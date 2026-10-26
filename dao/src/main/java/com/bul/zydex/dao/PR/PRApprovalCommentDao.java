/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.PR;

import com.bul.zydex.dao.Tender.*;
import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.PRApprovalComment;
import java.util.List;
/**
 *
 * @author tailo
 */
public interface PRApprovalCommentDao<T> extends GenericsDAO<T> {

    public List readByPrNumber(String prNo);
    
}
