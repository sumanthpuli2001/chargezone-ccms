/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.QuestionAnswerSubmit;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.QuestionAnswerSubmit;
import java.util.List;

/**
 *
 * @author Hussain
 */
public class QuestionAnswerSubmitDAOImpl<T> extends GenericsDAOImpl<T> implements QuestionAnswerSubmitDAO<T> {

    @Override
    protected Class getDomainClass() {
        return QuestionAnswerSubmit.class;
    }

    @Override
    public List<?> readByCandidateApplicationId(int appId) {
        String query = "";
//                          0   1   2       3               4       5               6
        query += "Select a.id,b.id,c.id,a.questionAnsId.id,c.ansId,a.description,c.marks"
                + " From QuestionAnswerSubmit a"
                + " LEFT JOIN a.candidateJobApplicationid b"
                + " LEFT JOIN a.questionLibraryId c"
                + " Where b.id=" + appId;

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> deletelibryId(String libraryId) {
        String query = "";

        query += "  "
                + " select a"
                + " FROM QuestionAnswerSubmit a "
                + " WHERE a.questionLibraryId.id = " + libraryId;
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

}
