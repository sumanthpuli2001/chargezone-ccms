/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.OapDocumentAttachment;

import com.bul.zydex.dao.OapDocumentAttachment.OapDocumentAttachmentDao;
import com.bul.zydex.model.OapDocumentAttachment;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class OapDocumentAttachmentServiceImpl<T> extends GenericsServiceImpl<T> implements OapDocumentAttachmentService<T> {

    private OapDocumentAttachmentDao<T> oapDocumentAttachmentDao;

    public OapDocumentAttachmentDao<T> getOapDocumentAttachmentDao() {
	return oapDocumentAttachmentDao;
    }

    public void setOapDocumentAttachmentDao(OapDocumentAttachmentDao<T> oapDocumentAttachmentDao) {
	this.oapDocumentAttachmentDao = oapDocumentAttachmentDao;
	setGenericsDAO(oapDocumentAttachmentDao);
    }

    @Override
    public List readByattach(String oapFormattach) {
	return oapDocumentAttachmentDao.readByattach(oapFormattach);
    }

    @Override
    public OapDocumentAttachment readByattach1(String id1) {
	return oapDocumentAttachmentDao.readByattach1(id1);
    }

    @Override
    public List readByattachzip(String id1) {
	return oapDocumentAttachmentDao.readByattachzip(id1);
    }

    @Override
    public void deleteByid(String id) {
         oapDocumentAttachmentDao.deleteByid(id);
    }

}
