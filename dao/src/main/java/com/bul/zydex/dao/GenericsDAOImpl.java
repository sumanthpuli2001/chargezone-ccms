/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao;

import java.util.List;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author Pankaj
 */
public abstract class GenericsDAOImpl<T> extends HibernateDaoSupport implements
        GenericsDAO<T> {
//    protected SessionFactory sessionFactory;

    protected Class domainClass = getDomainClass();

    @Override
    public int count() {
        List list = getHibernateTemplate().find(
                "select count(*) from " + domainClass.getName() + " x ");
        Integer count = (Integer) list.get(0);
        return count.intValue();
//        return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from " + domainClass.getName()));
    }

    @Override
    public void create(T object) {
        try {
            getHibernateTemplate().save(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createOrUpdate(T object) {
        getHibernateTemplate().saveOrUpdate(object);
    }

    @Override
    public void delete(final Integer id) {
        getHibernateTemplate().delete(readById(id));
    }

    /**
     * Method to return the class of the domain object
     */
    protected abstract Class getDomainClass();

    @Override
    public List<?> read() {
        return getHibernateTemplate().loadAll(domainClass);
    }

    @Override
    public T readById(final Integer id) {
        return (T) getHibernateTemplate().get(domainClass.getName(), id);
    }

    @Override
    public void update(T object) {
        getHibernateTemplate().update(object);

    }
}
