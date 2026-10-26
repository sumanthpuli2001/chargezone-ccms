/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.SiteSurveyAttachment;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.SiteSurveyAttachment;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class SiteSurveyAttachmentDaoImpl<T> extends GenericsDAOImpl<T> implements SiteSurveyAttachmentDao<T> {

    @Override
    protected Class getDomainClass() {
        return SiteSurveyAttachment.class;
    }

    @Override
    public List readBysiteSurveyId(String id) {

        String query = ""
                + " from SiteSurveyAttachment a "
                + " where  a.siteSurveyId=" + id;
        List list = getHibernateTemplate().find(query);
        return list;

    }

}
