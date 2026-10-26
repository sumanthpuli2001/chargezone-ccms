/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.dao.Tender.CommitteeApprovalUserDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Bulwark-4
 */
public class CommitteeApprovalUserServiceImpl<T> extends GenericsServiceImpl<T> implements CommitteeApprovalUserService<T>  {
    
    private CommitteeApprovalUserDao<T> committeeApprovalUserDao ;

    public CommitteeApprovalUserDao<T> getCommitteeApprovalUserDao() {
        return committeeApprovalUserDao;
    }

    public void setCommitteeApprovalUserDao(CommitteeApprovalUserDao<T> committeeApprovalUserDao) {
        this.committeeApprovalUserDao = committeeApprovalUserDao;
        setGenericsDAO(committeeApprovalUserDao);
        
    }
   
    @Override
    public List<?> readByIdToList1(String id) {
        return committeeApprovalUserDao.readByIdToList1(id);
        
    }
    
}
