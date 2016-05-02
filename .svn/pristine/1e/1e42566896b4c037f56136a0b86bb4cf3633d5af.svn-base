/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.travel;

import com.bul.zydex.dao.travel.HotelAccommodationDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author AJAY
 */
public class HotelAccommodationServiceImpl<T> extends GenericsServiceImpl<T> implements HotelAccommodationService<T> {

    protected HotelAccommodationDAO<T> hotelAccommodationDAO;

    public HotelAccommodationDAO<T> getHotelAccommodationDAO() {
        return hotelAccommodationDAO;
    }

    public void setHotelAccommodationDAO(HotelAccommodationDAO<T> hotelAccommodationDAO) {
        this.hotelAccommodationDAO = hotelAccommodationDAO;
        setGenericsDAO(hotelAccommodationDAO);
    }

    @Override
    public List<?> readAccommodationDetail(T object) {
        return hotelAccommodationDAO.readAccommodationDetail(object);
    }

}
