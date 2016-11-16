/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.travel;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.HotelAccommodation;
import java.util.List;

/**
 *
 * @author AJAY
 */
public class HotelAccommodationDAOImpl<T> extends GenericsDAOImpl<T> implements HotelAccommodationDAO<T> {

    @Override
    protected Class getDomainClass() {
        return HotelAccommodation.class;
    }

    @Override
    public List<?> readAccommodationDetail(T object) {
        HotelAccommodation hotelAccommodation = (HotelAccommodation) object;
        String query = "";

        query += ""
                + " FROM HotelAccommodation a"
                + " WHERE a.travelRequestMaster=" + hotelAccommodation.getTravelRequestMaster().getId();

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readByTravelId(int id) {

        String query = "";

        query += ""
                + " FROM HotelAccommodation a"
                + " WHERE a.travelRequestMaster.id=" + id;

        return getHibernateTemplate().find(query);
    }
}
