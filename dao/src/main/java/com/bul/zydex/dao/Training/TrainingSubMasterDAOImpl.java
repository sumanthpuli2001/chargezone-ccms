/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bul.zydex.dao.Training;

import com.bul.zydex.dao.GenericsDAOImpl;
import java.util.List;
import com.bul.zydex.model.TrainingSubMaster;

/**
 *
 * @author Rishi
 */
public class TrainingSubMasterDAOImpl<T> extends GenericsDAOImpl<T> implements TrainingSubMasterDAO<T> {

    @Override
    protected Class getDomainClass() {
        return TrainingSubMaster.class;
    }
    @Override
    public List<?> ListeventDates(String eventDate) {
        String query = "select b.trainingMasterid,b.title"
                    + " FROM TrainingSubMaster b"
                    + " where STR_TO_DATE(b.trainingdate, '%d/%m/%Y')=STR_TO_DATE('" + eventDate + "', '%d/%m/%Y')";
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

}
