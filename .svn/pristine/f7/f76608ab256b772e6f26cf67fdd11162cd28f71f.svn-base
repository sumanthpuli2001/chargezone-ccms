/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.shift;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.ShiftMaster;
import java.util.List;

/**
 *
 * @author AJAY
 */
public class ShiftMasterDAOImpl<T> extends GenericsDAOImpl<T> implements ShiftMasterDAO<T> {

    @Override
    protected Class getDomainClass() {
        return ShiftMaster.class;
    }

    @Override
    public List<?> readByShiftId(T object) {
        ShiftMaster shiftMaster = (ShiftMaster) object;
        String query = "";

        query += " FROM ShiftMaster a"
                + " Where a.id=" + shiftMaster.getId();

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readByShiftName() {
        String query = "";
        query += " "
                + " SELECT a.id, a.shiftName"
                + " FROM ShiftMaster a ";

        List<?> list = getHibernateTemplate().find(query);
        return list;

    }

    @Override
    public List<?> checkExistingShift(T object) {
        ShiftMaster shiftMaster = (ShiftMaster) object;
        String query = "";

        query += " FROM ShiftMaster a"
                + " Where a.shiftName='" + shiftMaster.getShiftName() + "'";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> getByShiftName(final String shiftTempString) {
        String hqlString = "";
        hqlString += " FROM ShiftMaster a"
                + " Where lower(trim(a.shiftName))='" + shiftTempString + "'";

        List<?> list = getHibernateTemplate().find(hqlString);
        return list;
    }

}
