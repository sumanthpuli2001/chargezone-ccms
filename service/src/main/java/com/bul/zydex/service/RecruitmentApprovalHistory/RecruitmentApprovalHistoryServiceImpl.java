/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.RecruitmentApprovalHistory;

import com.bul.zydex.dao.RecruitmentApprovalHistory.RecruitmentApprovalHistoryDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Rishi
 */
public class RecruitmentApprovalHistoryServiceImpl<T> extends GenericsServiceImpl<T> implements RecruitmentApprovalHistoryService<T> {

    private RecruitmentApprovalHistoryDAO<T> recruitmentApprovalHistoryDAO;

    public RecruitmentApprovalHistoryDAO<T> getRecruitmentApprovalHistoryDAO() {
        return recruitmentApprovalHistoryDAO;
    }

    public void setRecruitmentApprovalHistoryDAO(RecruitmentApprovalHistoryDAO<T> recruitmentApprovalHistoryDAO) {
        this.recruitmentApprovalHistoryDAO = recruitmentApprovalHistoryDAO;
        setGenericsDAO(recruitmentApprovalHistoryDAO);
    }

    @Override
    public List<?> getByRecruitementMasterId(int mppId) {
        return recruitmentApprovalHistoryDAO.getByRecruitementMasterId(mppId);
    }

    @Override
    public List<?> AppMppdelete(String APmppId) {
        return recruitmentApprovalHistoryDAO.AppMppdelete(APmppId);
    }

}
