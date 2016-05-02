/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.shift;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.HoursBasis;
import java.util.List;

/**
 *
 * @author AJAY
 */
public class HoursBasisDAOImpl<T> extends GenericsDAOImpl<T> implements HoursBasisDAO<T> {

    @Override
    protected Class getDomainClass() {
        return HoursBasis.class;
    }

    @Override
    public List<?> checkByTitleOfHourBasis(final String title) {
        String hqlString = "";
        hqlString += " FROM HoursBasis a"
                + " Where lower(trim(a.title)) like'%" + title + "%'";
        List<?> list = getHibernateTemplate().find(hqlString);
        return list;
    }

}
