/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Training;

import com.bul.zydex.dao.GenericsDAOImpl;
import java.util.List;
import com.bul.zydex.model.TrainingMaster;
import java.util.LinkedList;

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
        String query = ""
                + " delete FROM TrainingSubMaster b"
                + " where b.id=" + id;
        getHibernateTemplate().bulkUpdate(query);
    }

    @Override
    public List<?> readTrainingMasterList() {
        String query = " "
                + " select a.id, a.trainingTitle, a.trainingDescription, b.trainerName,c.training, a.status "
                + " FROM TrainingMaster a "
                + " left join a.trainer b "
                + " left join a.trainingType c"
                + " order by a.id desc";
        List finallist = new LinkedList();
        List<?> list = getHibernateTemplate().find(query);
        for (Object list1 : list) {
            List slist = new LinkedList();
            Object[] o = (Object[]) list1;
            slist.add(o[0]);
            slist.add(o[1]);
            slist.add(o[2]);
            slist.add(o[3]);
            slist.add(o[4]);
            slist.add(o[5]);
            finallist.add(slist);
        }
        return finallist;

    }

}
