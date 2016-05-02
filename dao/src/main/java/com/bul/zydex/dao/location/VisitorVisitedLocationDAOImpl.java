/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.location;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.VisitorVisitedLocation;
import java.util.List;

/**
 *
 * @author BlackBull
 */
public class VisitorVisitedLocationDAOImpl<T> extends GenericsDAOImpl<T> implements VisitorVisitedLocationDAO<T> {

    @Override
    protected Class getDomainClass() {
        return VisitorVisitedLocation.class;
    }

    @Override
    public List<?> isExist(String location) {
        String query = "SELECT v.location FROM VisitorVisitedLocation v where v.location='" + location+"'";
        List list=getHibernateTemplate().find(query);
        return list;
        
    }
}
