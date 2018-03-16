/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bul.zydex.dao.Training;

import com.bul.zydex.dao.GenericsDAOImpl;
import java.util.List;
import com.bul.zydex.model.TrainingMaster;

/**
 *
 * @author Rishi
 */
public class TrainingMasterDAOImpl<T> extends GenericsDAOImpl<T> implements TrainingMasterDAO<T> {

    @Override
    protected Class getDomainClass() {
        return TrainingMaster.class;
    }

  @Override
    public void deletetrainingSubMaster(final Integer id) {
       String query=""
                + " delete FROM TrainingSubMaster b"
                + " where b.id="+id;
         getHibernateTemplate().find(query);
    }  

}
