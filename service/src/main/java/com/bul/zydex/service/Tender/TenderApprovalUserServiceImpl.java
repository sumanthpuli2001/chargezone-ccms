/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.dao.Tender.TenderApprovalUserDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Bulwark-4
 */
public class TenderApprovalUserServiceImpl<T> extends GenericsServiceImpl<T> implements TenderApprovalUserService<T>  {
    
    private TenderApprovalUserDao<T> tenderApprovalUserDao;

    public TenderApprovalUserDao<T> getTenderApprovalUserDao() {
        return tenderApprovalUserDao;
    }

    public void setTenderApprovalUserDao(TenderApprovalUserDao<T> tenderApprovalUserDao) {
        this.tenderApprovalUserDao = tenderApprovalUserDao;
        setGenericsDAO(tenderApprovalUserDao);
    }

    @Override
    public List<?> readByIdToList(String id) {
        return tenderApprovalUserDao.readByIdToList(id);
        
    }
    
    
    
}
