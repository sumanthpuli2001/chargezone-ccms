/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.dao.Tender.AuthTenderItemAttachmentDao;
import com.bul.zydex.model.AuthTenderItemAttachment;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class AuthTenderItemAttachmentServiceImpl<T> extends GenericsServiceImpl<T> implements AuthTenderItemAttachmentService<T> {

    private AuthTenderItemAttachmentDao<T> authTenderItemAttachmentDao;
    
    public AuthTenderItemAttachmentDao<T> getAuthTenderItemAttachmentDao() {
        return authTenderItemAttachmentDao;
    }

    public void setAuthTenderItemAttachmentDao(AuthTenderItemAttachmentDao<T> authTenderItemAttachmentDao) {
        this.authTenderItemAttachmentDao = authTenderItemAttachmentDao;
        setGenericsDAO(authTenderItemAttachmentDao);
    }

    @Override
    public List readByRefNo(String refNo, String pur_no, String item_no) {
        return authTenderItemAttachmentDao.readByRefNo(refNo,pur_no,item_no);
    }

    @Override
    public List readByDocRefNo(String refNo, String pur_no, String item_no, String attachment) {
        return authTenderItemAttachmentDao.readByDocRefNo(refNo,pur_no,item_no,attachment);
    }

    @Override
    public void deleteRefNo(String refNo) {
        authTenderItemAttachmentDao.deleteRefNo(refNo);
    }
}
