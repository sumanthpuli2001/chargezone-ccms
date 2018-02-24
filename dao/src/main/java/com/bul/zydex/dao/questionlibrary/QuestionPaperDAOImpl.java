/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.questionlibrary;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.QuestionPaper;
import java.util.List;

/**
 *
 * @author Admin
 */
public class QuestionPaperDAOImpl<T> extends GenericsDAOImpl<T> implements QuestionPaperDAO<T> {

    @Override
    protected Class getDomainClass() {
        return QuestionPaper.class;
    }

    @Override
    public List<?> readAllQuestionPaper() {
         String query = "";
//                            0   1           2       
        query += " select a.id,a.paperName,a.totalMarks "
                + " From QuestionPaper a "
                + " ORDER BY a.id desc";
        return getHibernateTemplate().find(query);
    }

}
