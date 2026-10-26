/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Vendor;

import com.bul.zydex.dao.Vendor.CommMasterAttachmentDao;
import com.bul.zydex.model.CommMasterAttachment;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;
/**
 *
 * @author admin
 */
public class CommMasterAttachmentServiceImpl<T> extends GenericsServiceImpl<T> implements CommMasterAttachmentService<T> {
    
    private CommMasterAttachmentDao<T> commMasterAttachmentDao;

    public CommMasterAttachmentDao<T> getCommMasterAttachmentDao() {
        return commMasterAttachmentDao;
    }

    public void setCommMasterAttachmentDao(CommMasterAttachmentDao<T> commMasterAttachmentDao) {
        this.commMasterAttachmentDao = commMasterAttachmentDao;
        setGenericsDAO(commMasterAttachmentDao);
    }

    @Override
    public List readByCommId(String tender_no, String username, String subject) {
        return commMasterAttachmentDao.readByCommId(tender_no, username, subject);
    }
}
