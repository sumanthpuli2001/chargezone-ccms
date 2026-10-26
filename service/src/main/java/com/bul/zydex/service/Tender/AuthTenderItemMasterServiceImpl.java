/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.dao.Tender.AuthTenderItemMasterDao;
import com.bul.zydex.model.AuthTenderItemMaster;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class AuthTenderItemMasterServiceImpl<T> extends GenericsServiceImpl<T> implements AuthTenderItemMasterService<T> {
    
    private AuthTenderItemMasterDao<T> authTenderItemMasterDao;

    public AuthTenderItemMasterDao<T> getAuthTenderItemMasterDao() {
        return authTenderItemMasterDao;
    }

    public void setAuthTenderItemMasterDao(AuthTenderItemMasterDao<T> authTenderItemMasterDao) {
        this.authTenderItemMasterDao = authTenderItemMasterDao;
        setGenericsDAO(authTenderItemMasterDao);
    }

    @Override
    public List readByItemNo(String refNo, String pur_no, String item_no) {
        return authTenderItemMasterDao.readByItemNo(refNo, pur_no, item_no);
    }

    @Override
    public List readByRefNo(String refNo) {
        return authTenderItemMasterDao.readByRefNo(refNo);
    }

    @Override
    public void updateByItemNo(String refNo, String pur_no, String item_no, String item_remark, String qty, String checkId) {
        authTenderItemMasterDao.updateByItemNo(refNo, pur_no, item_no, item_remark, qty, checkId);
    }

    @Override
    public void deleteRefNo(String refNo) {
        authTenderItemMasterDao.deleteRefNo(refNo);
    }
}
