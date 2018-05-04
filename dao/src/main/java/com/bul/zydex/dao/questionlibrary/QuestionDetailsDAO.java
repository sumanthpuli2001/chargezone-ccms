/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.questionlibrary;

import com.bul.zydex.dao.GenericsDAO;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface QuestionDetailsDAO<T> extends GenericsDAO<T> {

    public List<?> readByQuePaperId(int qpId);

    public boolean isExistQuestion(int QlId, int QpId);

    public void deleteByQPaperId(T object);

    public List<?> getTotalMarksAndNoOfQueByQuePaperId(int qpId);

    public List<?> takeTestOnlineAssementCandidate(int questionpaperID);
    
    public List<?> deletelibraryid(String libraryId);

}
