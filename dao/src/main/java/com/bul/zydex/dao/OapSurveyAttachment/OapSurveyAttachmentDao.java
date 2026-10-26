/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.OapSurveyAttachment;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.OapSurveyAttachment;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public interface OapSurveyAttachmentDao<T> extends GenericsDAO<T> {

    public List readByoapId(String id);

    public OapSurveyAttachment readByoapFormId(String OapId);
    
}
