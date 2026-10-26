/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.SiteSurveyAttachment;

import com.bul.zydex.dao.SiteSurveyAttachment.SiteSurveyAttachmentDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class SiteSurveyAttachmentServiceImpl<T> extends GenericsServiceImpl<T> implements SiteSurveyAttachmentService<T> {

    private SiteSurveyAttachmentDao<T> siteSurveyAttachmentDao;

    public SiteSurveyAttachmentDao<T> getSiteSurveyAttachmentDao() {
        return siteSurveyAttachmentDao;
    }

    public void setSiteSurveyAttachmentDao(SiteSurveyAttachmentDao<T> siteSurveyAttachmentDao) {
        this.siteSurveyAttachmentDao = siteSurveyAttachmentDao;
        setGenericsDAO(siteSurveyAttachmentDao);

    }

    @Override
    public List readBysiteSurveyId(String id) {
        return siteSurveyAttachmentDao.readBysiteSurveyId(id);

    }

}
