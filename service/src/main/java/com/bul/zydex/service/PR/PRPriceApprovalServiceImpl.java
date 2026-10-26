/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.PR;

import com.bul.zydex.dao.PR.PRPriceApprovalDao;
import com.bul.zydex.service.Tender.*;
import com.bul.zydex.dao.Tender.TenderCommitteeDao;
import com.bul.zydex.dao.Tender.TenderPriceApprovalDao;
import com.bul.zydex.model.PRPriceApproval;
import com.bul.zydex.model.TenderCommittee;
import com.bul.zydex.model.TenderPriceApproval;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;
/**
 *
 * @author admin
 */
public class PRPriceApprovalServiceImpl<T> extends GenericsServiceImpl<T> implements PRPriceApprovalService<T> {
    
    private PRPriceApprovalDao<T> prPriceApprovalDao;

    public PRPriceApprovalDao<T> getPrPriceApprovalDao() {
        return prPriceApprovalDao;
    }

    public void setPrPriceApprovalDao(PRPriceApprovalDao<T> prPriceApprovalDao) {
        this.prPriceApprovalDao = prPriceApprovalDao;
        setGenericsDAO(prPriceApprovalDao);
    }

    @Override
    public boolean isExist(String ref_no) {
        return prPriceApprovalDao.isExist(ref_no);
    }

    @Override
    public List approvaList(String username) {
        return prPriceApprovalDao.approvaList(username);
    }

    @Override
    public List readByIds(String id) {
        return prPriceApprovalDao.readByIds(id);
    }

    @Override
    public List readLog(String prNumber, String open_from_date, String open_to_date) {
        return prPriceApprovalDao.readLog(prNumber,open_from_date,open_to_date);
    }

    @Override
    public void deletePr(String refNo) {
        prPriceApprovalDao.deletePr(refNo);
    }

    @Override
    public List readByprNo(String prNo) {
        return prPriceApprovalDao.readByprNo(prNo);
    }

    @Override
    public PRPriceApproval readByPrNo(String prNo) {
        return prPriceApprovalDao.readByPrNo(prNo);
    }

  
    
        
    

    
    
    
}
