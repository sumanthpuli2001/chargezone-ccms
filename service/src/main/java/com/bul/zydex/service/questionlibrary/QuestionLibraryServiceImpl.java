/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.questionlibrary;

import com.bul.zydex.dao.questionlibrary.QuestionLibraryDAO;
import com.bul.zydex.service.GenericsServiceImpl;

/**
 *
 * @author Rishi
 */
public class QuestionLibraryServiceImpl<T> extends GenericsServiceImpl<T>
        implements QuestionLibraryService<T> {

    protected QuestionLibraryDAO<T> questionLibraryDAO;

    public QuestionLibraryDAO<T> getQuestionLibraryDAO() {
        return questionLibraryDAO;
    }

    public void setQuestionLibraryDAO(QuestionLibraryDAO<T> questionLibraryDAO) {
        this.questionLibraryDAO = questionLibraryDAO;
        setGenericsDAO(questionLibraryDAO);
    }

    
}
