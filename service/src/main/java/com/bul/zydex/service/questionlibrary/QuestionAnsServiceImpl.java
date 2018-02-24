/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.questionlibrary;

import com.bul.zydex.dao.questionlibrary.QuestionAnsDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Rishi
 */
public class QuestionAnsServiceImpl<T> extends GenericsServiceImpl<T>
        implements QuestionAnsService<T> {

    protected QuestionAnsDAO<T> questionAnsDAO;

    public QuestionAnsDAO<T> getQuestionAnsDAO() {
        return questionAnsDAO;
    }

    public void setQuestionAnsDAO(QuestionAnsDAO<T> questionAnsDAO) {
        this.questionAnsDAO = questionAnsDAO;
        setGenericsDAO(questionAnsDAO);
    }

    @Override
    public List<?> readByQLId(int qlId) {
        return questionAnsDAO.readByQLId(qlId);
    }

    @Override
    public void deleteByQlId(T object) {
       questionAnsDAO.deleteByQlId(object);
    }

}
