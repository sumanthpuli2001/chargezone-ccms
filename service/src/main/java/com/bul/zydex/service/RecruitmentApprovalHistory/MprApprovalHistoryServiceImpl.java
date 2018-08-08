/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bul.zydex.service.RecruitmentApprovalHistory;

import com.bul.zydex.dao.RecruitmentApprovalHistory.MprApprovalHistoryDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Rishi
 */
public class MprApprovalHistoryServiceImpl<T> extends GenericsServiceImpl<T> implements MprApprovalHistoryService<T>{
    
    private MprApprovalHistoryDAO<T> mprApprovalHistoryDAO;

    public MprApprovalHistoryDAO<T> getMprApprovalHistoryDAO() {
        return mprApprovalHistoryDAO;
    }

    public void setMprApprovalHistoryDAO(MprApprovalHistoryDAO<T> mprApprovalHistoryDAO) {
        this.mprApprovalHistoryDAO = mprApprovalHistoryDAO;
        setGenericsDAO(mprApprovalHistoryDAO);
    }

    @Override
    public List<?> getByMprId(int mprId) {
       return mprApprovalHistoryDAO.getByMprId(mprId);
    }

    @Override
    public List<?> gethistory(int appId) {
        return mprApprovalHistoryDAO.gethistory(appId);
    }
    
    

}
