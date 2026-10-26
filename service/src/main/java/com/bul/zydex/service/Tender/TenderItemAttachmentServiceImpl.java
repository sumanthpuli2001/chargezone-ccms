/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.dao.Tender.TenderItemAttachmentDao;
import com.bul.zydex.model.TenderItemAttachment;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class TenderItemAttachmentServiceImpl<T> extends GenericsServiceImpl<T> implements TenderItemAttachmentService<T> {

    private TenderItemAttachmentDao<T> tenderItemAttachmentDao;
    
    public TenderItemAttachmentDao<T> getTenderItemAttachmentDao() {
        return tenderItemAttachmentDao;
    }

    public void setTenderItemAttachmentDao(TenderItemAttachmentDao<T> tenderItemAttachmentDao) {
        this.tenderItemAttachmentDao = tenderItemAttachmentDao;
        setGenericsDAO(tenderItemAttachmentDao);
    }

    @Override
    public List readByRefNo(String refNo, String pur_no, String item_no) {
        return tenderItemAttachmentDao.readByRefNo(refNo,pur_no,item_no);
    }

    @Override
    public List readByDocRefNo(String refNo, String pur_no, String item_no, String attachment) {
        return tenderItemAttachmentDao.readByDocRefNo(refNo,pur_no,item_no, attachment);
    }

    @Override
    public void deleteByRefNo(String refNo, String pur_no, String item_no) {
        tenderItemAttachmentDao.deleteByRefNo(refNo, pur_no, item_no);
    }

    @Override
    public List readByRefNo1(String refNo) {
        return tenderItemAttachmentDao.readByRefNo1(refNo);
    }
}
