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

    public List<?> gettrainingattendance(int id) {
        String query = "select b.id,c.employeeName"
                + " FROM TrainingIdentification b"
                + " left join b.employeeMaster c"
                + " where b.trainingMaster.id=" + id;
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }
}
