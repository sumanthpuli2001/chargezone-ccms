/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.shift;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.ShiftRotationMaster;
import java.util.List;

/**
 *
 * @author AJAY
 */
public class ShiftRotationMasterDAOImpl<T> extends GenericsDAOImpl<T> implements ShiftRotationMasterDAO<T> {

    @Override
    protected Class getDomainClass() {
        return ShiftRotationMaster.class;
    }

    @Override
    public List<?> readRotation(T object) {
        ShiftRotationMaster shiftRotationMaster = (ShiftRotationMaster) object;
        String query = "";
        query += " Select a.title, a.duration, a.id "
                + "From ShiftRotationMaster a ";

        return getHibernateTemplate().find(query);

    }

    @Override
    public List<?> readByDuration(T object) {
        ShiftRotationMaster shiftRotationMaster = (ShiftRotationMaster) object;
        String query = "";
        query += " Select a.title, b.shiftName, b.id, a.duration,"
                + "From ShiftRotationMaster a "
                + " Left Join a.shiftMaster b "
                + " Where a.title = '" + shiftRotationMaster.getTitle() + "'";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> checkByShiftRotationName(T object) {
        ShiftRotationMaster shiftRotationMaster = (ShiftRotationMaster) object;
        String query = "";
        query += "From ShiftRotationMaster a "
                + " Where a.title = '" + shiftRotationMaster.getTitle() + "'";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readByShiftRotationName(String shiftRotationTemp) {
        String hqlString = "";
        hqlString += "From ShiftRotationMaster a "
                + " Where lower(trim(a.title))= '" + shiftRotationTemp + "'";

        return getHibernateTemplate().find(hqlString);
    }

}
