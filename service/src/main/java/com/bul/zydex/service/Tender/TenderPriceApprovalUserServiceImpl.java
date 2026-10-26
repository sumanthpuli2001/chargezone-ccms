/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.dao.Tender.TenderCommitteeDao;
import com.bul.zydex.dao.Tender.TenderPriceApprovalDao;
import com.bul.zydex.dao.Tender.TenderPriceApprovalUserDao;
import com.bul.zydex.model.TenderCommittee;
import com.bul.zydex.model.TenderPriceApprovalUser;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;
/**
 *
 * @author admin
 */
public class TenderPriceApprovalUserServiceImpl<T> extends GenericsServiceImpl<T> implements TenderPriceApprovalUserService<T> {
    
    private TenderPriceApprovalUserDao<T> tenderPriceApprovalUserDao;

    public TenderPriceApprovalUserDao<T> getTenderPriceApprovalUserDao() {
        return tenderPriceApprovalUserDao;
    }

    public void setTenderPriceApprovalUserDao(TenderPriceApprovalUserDao<T> tenderPriceApprovalUserDao) {
        this.tenderPriceApprovalUserDao = tenderPriceApprovalUserDao;
        setGenericsDAO(tenderPriceApprovalUserDao);
    }

    @Override
    public TenderPriceApprovalUser approvaList1(String username) {
       return tenderPriceApprovalUserDao.approvaList1(username);
    }

    @Override
    public List readByRefNo(int approveId) {
        return tenderPriceApprovalUserDao.readByRefNo(approveId);
    }

    @Override
    public List approvedTenderList(String username) {
       return tenderPriceApprovalUserDao.approvedTenderList(username); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List holdTenderList(String username) {
        return tenderPriceApprovalUserDao.holdTenderList(username);
    }

    @Override
    public TenderPriceApprovalUser readByLevel(String tender_no, int level) {
        return tenderPriceApprovalUserDao.readByLevel(tender_no, level);
    }

    @Override
    public List auditorReworkTenderList(String username) {
        return tenderPriceApprovalUserDao.auditorReworkTenderList(username);
    }

    @Override
    public TenderPriceApprovalUser approvaList2(int parseInt) {
        return tenderPriceApprovalUserDao.approvaList2(parseInt);
    }

}
