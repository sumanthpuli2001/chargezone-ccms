/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.location;

import com.bul.zydex.dao.location.VisitorVisitedLocationDAO;
import com.bul.zydex.model.VisitorVisitedLocation;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author BlackBull
 */
public class VisitorVisitedLocationServiceImpl<T> extends GenericsServiceImpl<T> implements VisitorVisitedLocationService<T> {

    private VisitorVisitedLocationDAO<T> visitorVisitedLocationDAO;

    public VisitorVisitedLocationDAO<T> getVisitorVisitedLocationDAO() {
        return visitorVisitedLocationDAO;
    }

    public void setVisitorVisitedLocationDAO(VisitorVisitedLocationDAO<T> visitorVisitedLocationDAO) {
        this.visitorVisitedLocationDAO = visitorVisitedLocationDAO;
        setGenericsDAO(visitorVisitedLocationDAO);
    }

    @Override
    public List<?> isExist(String location) {
        return visitorVisitedLocationDAO.isExist(location);
    }

    
}
