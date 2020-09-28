/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Apprentices;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.ApprenticesMaster;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Aman Bahukhandi
 */
public class ApprenticesDaoImpl<T> extends GenericsDAOImpl<T> implements ApprenticesDao<T> {

    @Override
    protected Class getDomainClass() {
        return ApprenticesMaster.class;
    }

    @Override
    public Boolean readByApprenticesCode(String apprenticesCode) {
        String query = "";
        query += " FROM ApprenticesMaster a"
                    + " WHERE a.apprenticeCode = '" + apprenticesCode + "'";
        List list = getHibernateTemplate().find(query);
        if (list.isEmpty()) {
            return false;
        }
        return true;
    }

    @Override
    public ApprenticesMaster read(String apprenticeCode) {
        ApprenticesMaster apprenticesMaster = new ApprenticesMaster();
        String query = "";
        query += " FROM ApprenticesMaster a"
                    + " WHERE a.apprenticeCode = '" + apprenticeCode + "'";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            apprenticesMaster = (ApprenticesMaster) list.get(0);
        }
        return apprenticesMaster;
    }

    @Override
    public void deleteByApprenticeCode(String checkedValues) {

        String query = " delete FROM ApprenticesMaster a"
                    + " WHERE a.apprenticeCode = '" + checkedValues + "'";

        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public List readShift(String code) {
        String query = " Select a.shiftType from ApprenticesMaster a where a.apprenticeCode='" + code + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public ApprenticesMaster readByRfIdValue(String empCode) {

        String query = "";
        query += " FROM ApprenticesMaster a"
                    + " WHERE a.rfId = '" + empCode + "'";
        return (ApprenticesMaster) getHibernateTemplate().find(query).get(0);
    }

}
