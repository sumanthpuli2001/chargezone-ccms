/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.questionlibrary;

import com.bul.zydex.dao.questionlibrary.QuestionDetailsDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Admin
 */
public class QuestionDetailsServiceImpl<T> extends GenericsServiceImpl<T> implements QuestionDetailsService<T> {

    private QuestionDetailsDAO<T> questionDetailsDAO;

    public QuestionDetailsDAO<T> getQuestionDetailsDAO() {
        return questionDetailsDAO;
    }

    public void setQuestionDetailsDAO(QuestionDetailsDAO<T> questionDetailsDAO) {
        this.questionDetailsDAO = questionDetailsDAO;
        setGenericsDAO(questionDetailsDAO);
    }

    @Override
    public List<?> readByQuePaperId(int qpId) {
        return questionDetailsDAO.readByQuePaperId(qpId);
    }

    @Override
    public boolean isExistQuestion(int QlId, int QpId) {
        return questionDetailsDAO.isExistQuestion(QlId, QpId);
    }

    @Override
    public void deleteByQPaperId(T object) {
        questionDetailsDAO.deleteByQPaperId(object);
    }

    @Override
    public List<?> takeTestOnlineAssementCandidate(int questionpaperID) {
      return questionDetailsDAO.takeTestOnlineAssementCandidate(questionpaperID);
    }

}
