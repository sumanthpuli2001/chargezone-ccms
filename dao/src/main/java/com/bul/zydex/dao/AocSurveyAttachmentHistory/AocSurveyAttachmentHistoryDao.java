/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.AocSurveyAttachmentHistory;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.AocSurveyAttachment;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public interface AocSurveyAttachmentHistoryDao<T> extends GenericsDAO<T> {

    public List readByaocHistroyid(int oaphistoryid);

    
    
}
