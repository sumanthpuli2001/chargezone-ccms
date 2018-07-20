/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Training;

import com.bul.zydex.dao.GenericsDAOImpl;
import java.util.List;
import com.bul.zydex.model.TrainingSubMaster;
import java.util.ArrayList;
import java.util.LinkedList;

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
        String query = "select b.trainingMasterid,b.title,b.trainingdate"
                + " FROM TrainingSubMaster b"
                + " where STR_TO_DATE(b.trainingdate, '%d/%m/%Y')=STR_TO_DATE('" + eventDate + "', '%d/%m/%Y')";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            List finallist = new LinkedList();
            for (Object list1 : list) {
                Object Objectarr[] = (Object[]) list1;
                List semifinallist = new LinkedList();
                semifinallist.add(Objectarr[0]);
                semifinallist.add(Objectarr[1]);
                semifinallist.add(Objectarr[2]);
                finallist.add(semifinallist);
            }

            return finallist;
        }
        return list;
    }

    @Override
    public List<?> deletetrainingId(String trainingId) {
        String query = "";
        query += " "
                + " SELECT  a "
                + " FROM TrainingSubMaster a "
                + " WHERE a.trainingMasterid=" + trainingId;

        List<?> list = getHibernateTemplate().find(query);
        return list;

    }

}
