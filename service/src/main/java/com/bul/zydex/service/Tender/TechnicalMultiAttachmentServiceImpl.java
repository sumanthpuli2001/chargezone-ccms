/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.dao.Tender.TechnicalMultiAttachmentDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class TechnicalMultiAttachmentServiceImpl<T> extends GenericsServiceImpl<T> implements TechnicalMultiAttachmentService<T> {

    private TechnicalMultiAttachmentDao<T> technicalMultiAttachmentDao;

    public TechnicalMultiAttachmentDao<T> getTechnicalMultiAttachmentDao() {
        return technicalMultiAttachmentDao;
    }

    public void setTechnicalMultiAttachmentDao(TechnicalMultiAttachmentDao<T> technicalMultiAttachmentDao) {
        this.technicalMultiAttachmentDao = technicalMultiAttachmentDao;
        setGenericsDAO(technicalMultiAttachmentDao);
    }

    @Override
    public List readByRefNoVendorCode(String ref_no, String vendorCode) {
        return technicalMultiAttachmentDao.readByRefNoVendorCode(ref_no, vendorCode);
    }

}
