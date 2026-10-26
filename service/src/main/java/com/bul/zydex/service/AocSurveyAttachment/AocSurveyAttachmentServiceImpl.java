/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.AocSurveyAttachment;

import com.bul.zydex.dao.AocSurveyAttachment.AocSurveyAttachmentDao;
import com.bul.zydex.model.AocSurveyAttachment;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class AocSurveyAttachmentServiceImpl<T> extends GenericsServiceImpl<T> implements AocSurveyAttachmentService<T> {
   
     private AocSurveyAttachmentDao<T> aocSurveyAttachmentDao;

    public AocSurveyAttachmentDao<T> getAocSurveyAttachmentDao() {
        return aocSurveyAttachmentDao;
    }

    public void setAocSurveyAttachmentDao(AocSurveyAttachmentDao<T> aocSurveyAttachmentDao) {
        this.aocSurveyAttachmentDao = aocSurveyAttachmentDao;
        setGenericsDAO(aocSurveyAttachmentDao);
        
    }

    @Override
    public List readByaocId(String aocformid) {
        return aocSurveyAttachmentDao.readByaocId(aocformid);
    }

    @Override
    public AocSurveyAttachment readByaocFormId(String aocId) {
        return aocSurveyAttachmentDao.readByaocFormId(aocId);
    }
     
}
