/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.AocFormAttachment;

import com.bul.zydex.dao.AocFormAttachment.AocFormAttachmentDao;
import com.bul.zydex.model.AocFormAttachment;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class AocFormAttachmentServiceImpl<T> extends GenericsServiceImpl<T> implements AocFormAttachmentService<T> {

    private AocFormAttachmentDao<T> aocFormAttachmentDao;

    public AocFormAttachmentDao<T> getAocFormAttachmentDao() {
	return aocFormAttachmentDao;
    }

    public void setAocFormAttachmentDao(AocFormAttachmentDao<T> aocFormAttachmentDao) {
	this.aocFormAttachmentDao = aocFormAttachmentDao;
	setGenericsDAO(aocFormAttachmentDao);

    }

    @Override
    public List readByattach(String aocFormattach) {

	return aocFormAttachmentDao.readByattach(aocFormattach);

    }

    @Override
    public List readByattachzip(String id1) {
	return aocFormAttachmentDao.readByattachzip(id1);

    }

    @Override
    public void deleteByid(int id1) {
         aocFormAttachmentDao.deleteByid(id1);
        
    }

}
