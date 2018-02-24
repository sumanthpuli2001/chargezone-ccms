/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Approval;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.ApprovalMaster;

/**
 *
 * @author Vikas
 */
public class ApprovalMasterDAOImpl<T> extends GenericsDAOImpl<T> implements ApprovalMasterDAO<T>{

    @Override
    protected Class getDomainClass() {
        return ApprovalMaster.class;
    }
    
}
