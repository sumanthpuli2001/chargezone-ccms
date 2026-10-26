/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.PR;

import com.bul.zydex.dao.PR.PRPriceApprovalUserDao;
import com.bul.zydex.service.Tender.*;
import com.bul.zydex.dao.Tender.TenderCommitteeDao;
import com.bul.zydex.dao.Tender.TenderPriceApprovalDao;
import com.bul.zydex.dao.Tender.TenderPriceApprovalUserDao;
import com.bul.zydex.model.PRPriceApprovalUser;
import com.bul.zydex.model.TenderCommittee;
import com.bul.zydex.model.TenderPriceApprovalUser;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;
/**
 *
 * @author admin
 */
public class PRPriceApprovalUserServiceImpl<T> extends GenericsServiceImpl<T> implements PRPriceApprovalUserService<T> {
    
    private PRPriceApprovalUserDao<T> prPriceApprovalUserDao;

    public PRPriceApprovalUserDao<T> getPrPriceApprovalUserDao() {
        return prPriceApprovalUserDao;
    }

    public void setPrPriceApprovalUserDao(PRPriceApprovalUserDao<T> prPriceApprovalUserDao) {
        this.prPriceApprovalUserDao = prPriceApprovalUserDao;
         setGenericsDAO(prPriceApprovalUserDao);
    }

    @Override
    public PRPriceApprovalUser approvaList1(String username , String pr_no) {
         return prPriceApprovalUserDao.approvaList1(username, pr_no);
    }

    @Override
    public List readByRefNo(int approveId) {
        return prPriceApprovalUserDao.readByRefNo(approveId);
    }

    @Override
    public void deletePr(String refNo) {
        prPriceApprovalUserDao.deletePr(refNo);
    }

    @Override
    public List readByPRNumber(String prNumber) {
        return prPriceApprovalUserDao.readByPRNumber(prNumber);
    }


    
   
       
    

   

}
