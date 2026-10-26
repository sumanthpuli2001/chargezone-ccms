/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.OapMultiAttachment;

import com.bul.zydex.dao.OapMultiAttachment.OapMultiAttachmentDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class OapMultiAttachmentServiceImpl<T> extends GenericsServiceImpl<T> implements OapMultiAttachmentService<T> {

    private OapMultiAttachmentDao<T> oapMultiAttachmentDao;

    public OapMultiAttachmentDao<T> getOapMultiAttachmentDao() {
        return oapMultiAttachmentDao;
    }

    public void setOapMultiAttachmentDao(OapMultiAttachmentDao<T> oapMultiAttachmentDao) {
        this.oapMultiAttachmentDao = oapMultiAttachmentDao;
        setGenericsDAO(oapMultiAttachmentDao);
    }

    @Override
    public List readByMulti(String oapFormmulti) {
        return oapMultiAttachmentDao.readByMulti(oapFormmulti);

    }

    @Override
    public List readByattachzip(String id1) {
        return oapMultiAttachmentDao.readByattachzip(id1);

    }

    

}
