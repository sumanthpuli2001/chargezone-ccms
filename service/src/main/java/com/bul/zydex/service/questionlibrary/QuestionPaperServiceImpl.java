/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.questionlibrary;

import com.bul.zydex.dao.questionlibrary.QuestionPaperDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Admin
 */
public class QuestionPaperServiceImpl<T> extends GenericsServiceImpl<T> implements QuestionPaperService<T>{
    
    protected QuestionPaperDAO<T> questionPaperDAO;

    public QuestionPaperDAO<T> getQuestionPaperDAO() {
        return questionPaperDAO;
    }

    public void setQuestionPaperDAO(QuestionPaperDAO<T> questionPaperDAO) {
        this.questionPaperDAO = questionPaperDAO;
        setGenericsDAO(questionPaperDAO);
    }
    
    

    @Override
    public List<?> readAllQuestionPaper() {
        return questionPaperDAO.readAllQuestionPaper();
    }
    
    
    
}
