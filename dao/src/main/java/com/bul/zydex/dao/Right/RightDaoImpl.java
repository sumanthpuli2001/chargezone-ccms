/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Right;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.RightMaster;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Aman Bahukhandi
 */
public class RightDaoImpl<T> extends GenericsDAOImpl<T> implements RightDao<T> {

    @Override
    protected Class getDomainClass() {
        return RightMaster.class;
    }

    @Override
    public RightMaster read(String rightName) {
        String query = " Select a "
                + " from RightMaster a "
                + " where a.rightName='" + rightName + "'";
        return (RightMaster) getHibernateTemplate().find(query).get(0);
    }

    @Override
    public void deleteByRightName(String checkedValues) {
        String query = "";
        query = " delete FROM RightMaster a"
                + " WHERE a.rightName = '" + checkedValues + "'";

        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();

    }

    @Override
    public List readByDrow() {
        String query = " Select a "
                + " from RightMaster a "
                + " where a.dRow='N'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByDrowDisable() {
        String query = " Select a "
                + " from RightMaster a "
                + " where a.dRow='Y'";
        return getHibernateTemplate().find(query);
    }

}
