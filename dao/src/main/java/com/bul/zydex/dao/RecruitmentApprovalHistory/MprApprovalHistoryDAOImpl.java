/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bul.zydex.dao.RecruitmentApprovalHistory;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.MprApprovalHistory;

/**
 *
 * @author Rishi
 */
public class MprApprovalHistoryDAOImpl<T> extends GenericsDAOImpl<T> implements MprApprovalHistoryDAO<T>{

    @Override
    protected Class getDomainClass() {
        return MprApprovalHistory.class;
    }

}
