/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.MprApproval;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.MprApproval;
import java.util.List;

/**
 *
 * @author Vikas
 */
public class MprApprovalDAOImpl<T> extends GenericsDAOImpl<T> implements MprApprovalDAO<T> {

    @Override
    protected Class getDomainClass() {
       return MprApproval.class;
    }

    }
