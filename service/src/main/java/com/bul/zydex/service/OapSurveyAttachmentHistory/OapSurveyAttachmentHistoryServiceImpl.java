/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.OapSurveyAttachmentHistory;

import com.bul.zydex.dao.OapSurveyAttachmentHistory.OapSurveyAttachmentHistoryDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class OapSurveyAttachmentHistoryServiceImpl<T> extends GenericsServiceImpl<T> implements OapSurveyAttachmentHistoryService<T> {
        private OapSurveyAttachmentHistoryDao<T> oapSurveyAttachmentHistoryDao;

    public OapSurveyAttachmentHistoryDao<T> getOapSurveyAttachmentHistoryDao() {
        return oapSurveyAttachmentHistoryDao;
    }

    public void setOapSurveyAttachmentHistoryDao(OapSurveyAttachmentHistoryDao<T> oapSurveyAttachmentHistoryDao) {
        this.oapSurveyAttachmentHistoryDao = oapSurveyAttachmentHistoryDao;
        setGenericsDAO(oapSurveyAttachmentHistoryDao);
        
    }

    @Override
    public List readByoaphistryid(String id) {
        return oapSurveyAttachmentHistoryDao.readByoaphistryid(id);
    }

}
