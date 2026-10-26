/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.OapSurveyAttachment;

import com.bul.zydex.dao.OapSurveyAttachment.OapSurveyAttachmentDao;
import com.bul.zydex.model.OapSurveyAttachment;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class OapSurveyAttachmentServiceImpl<T> extends GenericsServiceImpl<T> implements OapSurveyAttachmentService<T> {
    
    private OapSurveyAttachmentDao<T> oapSurveyAttachmentDao;

    public OapSurveyAttachmentDao<T> getOapSurveyAttachmentDao() {
        return oapSurveyAttachmentDao;
    }

    public void setOapSurveyAttachmentDao(OapSurveyAttachmentDao<T> oapSurveyAttachmentDao) {
        this.oapSurveyAttachmentDao = oapSurveyAttachmentDao;
        setGenericsDAO(oapSurveyAttachmentDao);
        
    }

    @Override
    public List readByoapId(String id) {
       	return oapSurveyAttachmentDao.readByoapId(id);
 
        
        
    }

    @Override
    public OapSurveyAttachment readByoapFormId(String OapId) {
       	return oapSurveyAttachmentDao.readByoapFormId(OapId);
    }
    
    
    
}
