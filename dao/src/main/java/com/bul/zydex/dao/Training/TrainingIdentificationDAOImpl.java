/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Training;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.TrainingIdentification;
import java.util.List;

/**
 *
 * @author Aman
 */
public class TrainingIdentificationDAOImpl<T> extends GenericsDAOImpl<T> implements TrainingIdentificationDAO<T> {

    @Override
    protected Class getDomainClass() {
        return TrainingIdentification.class;
    }

    @Override
    public List<?> readTrainingIdentificationList() {
        String query = "";

        query += " "
                + " SELECT a.id, b.employeeName, c.trainingTitle, a.description "
                + " FROM TrainingIdentification a "
                + " left join a.employeeMaster b "
                + " left join a.trainingMaster c "
                + " order by a.id desc";

        List<?> list = getHibernateTemplate().find(query);
        return list;

    }


    @Override
    public List<?> readTrainingList(int userid) {
        String query = "";
         query += " "
                + " SELECT a.id, a.trainingMaster.trainingTitle,a.trainingMaster.id "
                + " FROM TrainingIdentification a "
                + " where a.employeeMaster.id="+userid;

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readTraingFeedback() {
        String query = "";
        query += " "
                + " SELECT  a "
                + "FROM TrainingFeedback a ";
        
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

}
