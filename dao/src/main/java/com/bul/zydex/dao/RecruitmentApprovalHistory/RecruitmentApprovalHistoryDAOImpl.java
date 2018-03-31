/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.RecruitmentApprovalHistory;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.RecruitmentApprovalHistory;

/**
 *
 * @author Rishi
 */
public class RecruitmentApprovalHistoryDAOImpl<T> extends GenericsDAOImpl<T> implements RecruitmentApprovalHistoryDAO<T> {

    @Override
    protected Class getDomainClass() {
        return RecruitmentApprovalHistory.class;
    }

}
