/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.QuestionAnswerSubmit;

import com.bul.zydex.dao.QuestionAnswerSubmit.QuestionAnswerSubmitDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Hussain
 */
public class QuestionAnswerSubmitServiceImpl<T> extends GenericsServiceImpl<T> implements QuestionAnswerSubmitService<T> {
    
    private QuestionAnswerSubmitDAO<T> questionAnswerSubmitDAO;
    
    public QuestionAnswerSubmitDAO<T> getQuestionAnswerSubmitDAO() {
        return questionAnswerSubmitDAO;
    }
    
    public void setQuestionAnswerSubmitDAO(QuestionAnswerSubmitDAO<T> questionAnswerSubmitDAO) {
        this.questionAnswerSubmitDAO = questionAnswerSubmitDAO;
        setGenericsDAO(questionAnswerSubmitDAO);
    }

    @Override
    public List<?> readByCandidateApplicationId(int appId) {
       return questionAnswerSubmitDAO.readByCandidateApplicationId(appId);
    }

    @Override
    public List<?> deletelibryId(String libraryId) {
         return questionAnswerSubmitDAO.deletelibryId(libraryId);
    }
    
}
