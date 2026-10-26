/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.AocFormMultiAttachment;

import com.bul.zydex.dao.AocFormMultiAttachment.AocFormMultiAttachmentDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class AocFormMultiAttachmentServiceImpl<T> extends GenericsServiceImpl<T> implements AocFormMultiAttachmentService<T> {

    private AocFormMultiAttachmentDao<T> aocFormMultiAttachmentDao;

    public AocFormMultiAttachmentDao<T> getAocFormMultiAttachmentDao() {
	return aocFormMultiAttachmentDao;
    }

    public void setAocFormMultiAttachmentDao(AocFormMultiAttachmentDao<T> aocFormMultiAttachmentDao) {
	this.aocFormMultiAttachmentDao = aocFormMultiAttachmentDao;
	setGenericsDAO(aocFormMultiAttachmentDao);
    }

    @Override
    public List readByMulti(String aocFormmulti) {
	return aocFormMultiAttachmentDao.readByMulti(aocFormmulti);
    }

    @Override
    public List readByattachzip(String id1) {
	return aocFormMultiAttachmentDao.readByattachzip(id1);

    }

}
