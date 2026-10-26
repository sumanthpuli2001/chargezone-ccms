/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.dao.Tender.TechnicalTenderPriceApprovalUserDao;
import com.bul.zydex.dao.Tender.TenderCommitteeDao;
import com.bul.zydex.dao.Tender.TenderPriceApprovalDao;
import com.bul.zydex.dao.Tender.TenderPriceApprovalUserDao;
import com.bul.zydex.model.TechnicalTenderPriceApprovalUser;
import com.bul.zydex.model.TenderCommittee;
import com.bul.zydex.model.TenderPriceApprovalUser;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;
/**
 *
 * @author admin
 */
public class TechnicalTenderPriceApprovalUserServiceImpl<T> extends GenericsServiceImpl<T> implements TechnicalTenderPriceApprovalUserService<T> {
    
    private TechnicalTenderPriceApprovalUserDao<T> technicalTenderPriceApprovalUserDao;

    public TechnicalTenderPriceApprovalUserDao<T> getTechnicalTenderPriceApprovalUserDao() {
        return technicalTenderPriceApprovalUserDao;
    }

    public void setTechnicalTenderPriceApprovalUserDao(TechnicalTenderPriceApprovalUserDao<T> technicalTenderPriceApprovalUserDao) {
        this.technicalTenderPriceApprovalUserDao = technicalTenderPriceApprovalUserDao;
         setGenericsDAO(technicalTenderPriceApprovalUserDao);
    }

    @Override
    public List readByRefNo(int approveId) {
        return technicalTenderPriceApprovalUserDao.readByRefNo(approveId);
    }

    @Override
    public TechnicalTenderPriceApprovalUser approvaList2(int id) {
        return technicalTenderPriceApprovalUserDao.approvaList2(id);
    }

    @Override
    public TechnicalTenderPriceApprovalUser readByLevel(String tender_no, int level) {
        return technicalTenderPriceApprovalUserDao.readByLevel(tender_no,level);
    }

   

    
    
   
       
    

   

}
