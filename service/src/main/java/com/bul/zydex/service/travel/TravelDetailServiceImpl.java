/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.travel;

import com.bul.zydex.dao.travel.TravelDetailDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author AJAY
 */
public class TravelDetailServiceImpl<T> extends GenericsServiceImpl<T> implements TravelDetailService<T> {

    protected TravelDetailDAO<T> travelDetailDAO;

    public TravelDetailDAO<T> getTravelDetailDAO() {
        return travelDetailDAO;
    }

    public void setTravelDetailDAO(TravelDetailDAO<T> travelDetailDAO) {
        this.travelDetailDAO = travelDetailDAO;
        setGenericsDAO(travelDetailDAO);
    }

    @Override
    public List<?> readTravelDetail(T object) {
        return travelDetailDAO.readTravelDetail(object);
    }

    @Override
    public List<?> readByTravelId(int id) {
        return travelDetailDAO.readByTravelId(id);
    }

}
