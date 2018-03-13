/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bul.zydex.dao.Training;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.Trainer;
import java.util.List;

/**
 *
 * @author Rishi
 */
public class TrainerDAOImpl<T> extends GenericsDAOImpl<T> implements TrainerDAO<T> {

    @Override
    protected Class getDomainClass() {
        return Trainer.class;
    }

    @Override
    public List<?> readTrainerList() {
        String query = "";
         query += " "
                + " SELECT a.id, a.trainerName, a.userName, a.emailId, a.status"
                + " FROM Trainer a "
                + " order by a.id desc";
         
          List<?> list = getHibernateTemplate().find(query);
        return list;
         
    }

    @Override
    public List<?> read(T object) {
        Trainer trainer = (Trainer) object;
        String hqlString = "from Trainer tn where tn.userName='"
                + trainer.getUserName()
                + "'"
                + " AND tn.password='"
                + trainer.getPassword()
                + "'";
        return getHibernateTemplate().find(hqlString);
    }

    @Override
    public List<?> readByUserName(T object) {
        Trainer user = (Trainer) object;
        String query = "";
        query += " FROM Trainer a"
                + " WHERE a.userName = '" + user.getUserName() + "'";
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readByUser(String username) {
        String query = "";
        query += " FROM Trainer a"
                + " WHERE a.userName = '" + username + "'";
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

   

}
