/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bul.zydex.dao.Training;

import com.bul.zydex.dao.GenericsDAOImpl;
import java.util.List;
import com.bul.zydex.model.TrainingType;

/**
 *
 * @author Rishi
 */
public class TrainingTypeDAOImpl<T> extends GenericsDAOImpl<T> implements TrainingTypeDAO<T> {

    @Override
    protected Class getDomainClass() {
        return TrainingType.class;
    }
    @Override
    public List<?> readtrainingTypeDetail() {
        String query = "Select a.id,a.training,a.createddate, a.status";
        query += " FROM TrainingType a"
                +" order by a.id desc";
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }
    
    @Override
    public List<?> trainingTypeBystatus() {
        String query = "Select a"
         + " FROM TrainingType a where a.status=1";
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

}
