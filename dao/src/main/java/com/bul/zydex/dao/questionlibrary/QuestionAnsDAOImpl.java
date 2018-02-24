/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.questionlibrary;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.QuestionAns;
import com.bul.zydex.model.QuestionLibrary;
import java.util.List;

/**
 *
 * @author Rishi
 */
public class QuestionAnsDAOImpl<T> extends GenericsDAOImpl<T> implements QuestionAnsDAO<T> {

    @Override
    protected Class getDomainClass() {
        return QuestionAns.class;
    }

    @Override
    public List<?> readByQLId(int qlId) {
        String query = "";

        query += " select a "
                + " From QuestionAns a "
                + " Left Join a.questionLibrary b"
                + " Where b.id =" + qlId
                + " ORDER BY a.id desc";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void deleteByQlId(T object) {
        QuestionLibrary questionLibrary = (QuestionLibrary) object;
        boolean flag = false;
        String query = "Delete"
                + " From QuestionAns a"
                + " Where a.questionLibrary =" + questionLibrary.getId();

        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            flag = true;
        }

    }

}
