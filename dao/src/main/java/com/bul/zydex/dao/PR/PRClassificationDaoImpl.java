/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.PR;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.PRClassification;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.hibernate.Query;
/**
 *
 * @author Bulwark-5
 */
public class PRClassificationDaoImpl<T> extends GenericsDAOImpl<T> implements PRClassificationDao<T> {
   
    @Override
    protected Class getDomainClass() {
        return PRClassification.class;
    }

    @Override
    public List readByGroup() {
        String query = "";
        query += " FROM PRClassification a"
                + " group by classificationName order by a.id";
        return getHibernateTemplate().find(query);
    }
}
