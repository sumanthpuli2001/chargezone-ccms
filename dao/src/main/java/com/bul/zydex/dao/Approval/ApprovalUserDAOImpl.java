/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Approval;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.ApprovalUser;

/**
 *
 * @author Vikas
 */
public class ApprovalUserDAOImpl<T> extends GenericsDAOImpl<T> implements ApprovalUserDAO<T> {

    @Override
    protected Class getDomainClass() {
        return ApprovalUser.class;
    }

}
