/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Training;

import com.bul.zydex.dao.Training.*;
import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.TrainingFeedback;
import java.util.List;

/**
 *
 * @author Administrator
 * @param <T>
 */
public class TrainingFeedbackDAOImpl<T> extends GenericsDAOImpl<T> implements TrainingFeedbackDAO<T> {

    @Override
    protected Class getDomainClass() {
        return TrainingFeedback.class;
    }

    @Override
    public boolean isExist(T t) {
        boolean flag = false;
        TrainingFeedback trainingFeedback = (TrainingFeedback) t;
        String query = "";
        query += " select a.id"
                + " From TrainingFeedback a "
                + " where a.feedaback ='" + trainingFeedback.getFeedaback() + "'";
        List<?> list = getHibernateTemplate().find(query);
        if (list.size() > 0) {
            flag = true;
        }

        return flag;
    }

    @Override
    public List<?> read() {
        return getHibernateTemplate().find("select a from TrainingFeedback a");
    }
}
