/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.travel;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.TravelDetail;
import com.bul.zydex.model.TravelRequestMaster;
import java.util.List;

/**
 *
 * @author AJAY
 */
public class TravelDetailDAOImpl<T> extends GenericsDAOImpl<T> implements TravelDetailDAO<T> {

    @Override
    protected Class getDomainClass() {
        return TravelDetail.class;
    }

    @Override
    public List<?> readTravelDetail(T object) {
        TravelDetail travelDetail = (TravelDetail) object;
        String query = "";

        query += ""
                + " FROM TravelDetail a"
                + " WHERE a.travelRequestMaster=" + travelDetail.getTravelRequestMaster().getId(); //                + " Where a.employeeMaster=" + travelRequestMaster.getEmployeeMaster().getId();

        return getHibernateTemplate().find(query);
    }

}
