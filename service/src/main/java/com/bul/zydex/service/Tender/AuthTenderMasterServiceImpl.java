/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.dao.Tender.AuthTenderMasterDao;
import com.bul.zydex.model.AuthTenderMaster;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;


/**
 *
 * @author admin
 */
public class AuthTenderMasterServiceImpl<T> extends GenericsServiceImpl<T> implements AuthTenderMasterService<T> {
    
    private AuthTenderMasterDao<T> authTenderMasterDao;

    public AuthTenderMasterDao<T> getAuthTenderMasterDao() {
        return authTenderMasterDao;
    }

    public void setAuthTenderMasterDao(AuthTenderMasterDao<T> authTenderMasterDao) {
        this.authTenderMasterDao = authTenderMasterDao;
        setGenericsDAO(authTenderMasterDao);
    }

    @Override
    public List readByRefNo(String refNo) {
        return authTenderMasterDao.readByRefNo(refNo);
    }

    @Override
    public List vendorLiveTender(String username) {
        return authTenderMasterDao.vendorLiveTender(username);
    }

    @Override
    public AuthTenderMaster readByVendorRefNo(String refNo, String username) {
        return authTenderMasterDao.readByVendorRefNo(refNo,username);
    }
    
    @Override
    public AuthTenderMaster readByRefNo1(String refNo) {
        return authTenderMasterDao.readByRefNo1(refNo);
    }

    @Override
    public List unauthorizeTender(String username, String location, String department) {
        return authTenderMasterDao.unauthorizeTender(username, location, department);
    }

    @Override
    public void authorizeTender(String refNo, String username, String full_name, String contact_no, String title, String value, String categoryId, String docCost, String emd, String submitLastdate, String workDesc, String prNo, String remark) {
        authTenderMasterDao.authorizeTender(refNo, username, full_name, contact_no, title, value, categoryId, docCost, emd, submitLastdate, workDesc, prNo, remark);
    }

    @Override
    public void recycleTender(String refNo, String username, String full_name, String contact_no, String title, String value, String categoryId, String docCost, String emd, String submitLastdate, String workDesc, String prNo, String remark) {
        authTenderMasterDao.recycleTender(refNo, username, full_name, contact_no, title, value, categoryId, docCost, emd, submitLastdate, workDesc, prNo, remark);
    }

    @Override
    public void rejectTender(String refNo, String username, String full_name, String contact_no, String title, String value, String categoryId, String docCost, String emd, String submitLastdate, String workDesc, String prNo, String remark) {
        authTenderMasterDao.rejectTender(refNo, username, full_name, contact_no, title, value, categoryId, docCost, emd, submitLastdate, workDesc, prNo, remark);
    }

    @Override
    public void updateTender(String refNo, String username, String full_name, String contact_no, String title, String value, String categoryId, String docCost, String emd, String submitLastdate, String workDesc, String prNo, String remark) {
        authTenderMasterDao.updateTender(refNo, username, full_name, contact_no, title, value, categoryId, docCost, emd, submitLastdate, workDesc, prNo, remark);
    }

    @Override
    public List recycleTenderList(String username, String location, String department) {
        return authTenderMasterDao.recycleTenderList(username, location, department);
    }

    @Override
    public List rejectTenderList(String username, String location, String department) {
        return authTenderMasterDao.rejectTenderList(username, location, department);
    }

    @Override
    public void recycleTenderSubmit(String refNo, String username, String full_name, String contact_no, String title, String value, String categoryId, String docCost, String emd, String submitLastdate, String workDesc, String prNo, String remark) {
        authTenderMasterDao.recycleTenderSubmit(refNo, username, full_name, contact_no, title, value, categoryId, docCost, emd, submitLastdate, workDesc, prNo, remark);
    }

    @Override
    public void updateTenderData(String refNo, String title1, String category_id1, String value1, String emd1, String doc_cost1, String type1, String contact_person1, String location1, String announce_date1, String collection_lastdate1, String submit_lastdate1, String work_desc1, String tender_remark1, String tender_admin1, String tender_admin_contact_number1, String tender_authorize_person1, String tender_authorize_contact_no1, int authorize_flag1, String tender_authorize_user_name1, int re_autho_flag1, int is_in_autho_table1, int vendor_flag1, int item_flag1, int email_flag1, String authorize_date1, int return_flag1, int delete_flag1, int tender_phase1, int open_bid_flag1, String department1, String pr_no1) {
        authTenderMasterDao.updateTenderData(refNo, title1, category_id1, value1, emd1, doc_cost1, type1, contact_person1, location1, announce_date1, collection_lastdate1, submit_lastdate1, work_desc1, tender_remark1, tender_admin1, tender_admin_contact_number1, tender_authorize_person1, tender_authorize_contact_no1, authorize_flag1, tender_authorize_user_name1, re_autho_flag1, is_in_autho_table1, vendor_flag1, item_flag1, email_flag1, authorize_date1, return_flag1, delete_flag1, tender_phase1, open_bid_flag1, department1, pr_no1);
    }

    @Override
    public void authTenderSubmit(String refNo, String username, String full_name, String contact_no, String title, String value, String categoryId, String docCost, String emd, String submitLastdate, String workDesc, String prNo, String remark) {
        authTenderMasterDao.authTenderSubmit(refNo, username, full_name, contact_no, title, value, categoryId, docCost, emd, submitLastdate, workDesc, prNo, remark);
    }

    @Override
    public void deleteRefNo(String refNo) {
        authTenderMasterDao.deleteRefNo(refNo);
    }

    @Override
    public void authTenderSave(String refNo, String username, String full_name, String contact_no, String title, String value, String categoryId, String docCost, String emd, String submitLastdate, String workDesc, String prNo, String remark) {
        authTenderMasterDao.authTenderSave(refNo, username, full_name, contact_no, title, value, categoryId, docCost, emd, submitLastdate, workDesc, prNo, remark);
    }
}
