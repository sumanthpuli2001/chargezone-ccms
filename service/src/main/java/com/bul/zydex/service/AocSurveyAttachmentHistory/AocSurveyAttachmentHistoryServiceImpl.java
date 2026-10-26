/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.AocSurveyAttachmentHistory;

import com.bul.zydex.dao.AocSurveyAttachmentHistory.AocSurveyAttachmentHistoryDao;
import com.bul.zydex.model.AocSurveyAttachment;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class AocSurveyAttachmentHistoryServiceImpl<T> extends GenericsServiceImpl<T> implements AocSurveyAttachmentHistoryService<T> {

    private AocSurveyAttachmentHistoryDao<T> aocSurveyAttachmentHistoryDao;

    public AocSurveyAttachmentHistoryDao<T> getAocSurveyAttachmentHistoryDao() {
        return aocSurveyAttachmentHistoryDao;
    }

    public void setAocSurveyAttachmentHistoryDao(AocSurveyAttachmentHistoryDao<T> aocSurveyAttachmentHistoryDao) {
        this.aocSurveyAttachmentHistoryDao = aocSurveyAttachmentHistoryDao;
        setGenericsDAO(aocSurveyAttachmentHistoryDao);

    }

    @Override
    public List readByaocHistroyid(int oaphistoryid) {
        return aocSurveyAttachmentHistoryDao.readByaocHistroyid(oaphistoryid);

    }

   

}
