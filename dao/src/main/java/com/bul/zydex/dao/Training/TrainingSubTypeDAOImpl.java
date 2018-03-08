/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bul.zydex.dao.Training;

import com.bul.zydex.dao.GenericsDAOImpl;
import java.util.List;
import com.bul.zydex.model.TrainingSubType;

/**
 *
 * @author Rishi
 */
public class TrainingSubTypeDAOImpl<T> extends GenericsDAOImpl<T> implements TrainingSubTypeDAO<T> {

    @Override
    protected Class getDomainClass() {
        return TrainingSubType.class;
    }

    @Override
    public List<?> readtrainingSubTypeDetail() {
        String query = "Select a.id,a.trainingsubtype,a.createddate";
        query += " FROM TrainingSubType a";
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

}
