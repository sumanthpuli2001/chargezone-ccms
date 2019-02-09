/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.shift;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.RotationMaster;
import java.util.List;

/**
 *
 * @author AJAY
 */
public class RotationMasterDAOImpl<T> extends GenericsDAOImpl<T> implements RotationMasterDAO<T> {

    @Override
    protected Class getDomainClass() {
        return RotationMaster.class;

    }

    @Override
    public List<?> readFromRotation(T object) {
        RotationMaster rotationMaster = (RotationMaster) object;
        String query = "";
        query += " "
                + "From RotationMaster a "
                + " Where a.shiftRotationMaster =" + rotationMaster.getShiftRotationMaster().getId();

        return getHibernateTemplate().find(query);

    }

    @Override
    public List<?> readForShift(int rotationId) {
//        RotationMaster rotationMaster = (RotationMaster) object;
        String query = "";
        query += " Select b.id, b.shiftName "
                + "From RotationMaster a "
                + " LEFT JOIN a.shiftMaster b"
                + " Where a.shiftRotationMaster =" + rotationId;

        return getHibernateTemplate().find(query);

    }

    @Override
    public List<?> isRotationExist(T object) {
        RotationMaster rotationMaster = (RotationMaster) object;
//        return getHibernateTemplate().execute((Session session) -> {
//            Criteria criteria = session.createCriteria(domainClass);
//                criteria.add(Restrictions.eq(shiftRotationMaster, domainClass.getShiftRotationMaster.getId))
//        .add(Restrictions.eq(shiftMaster, domainClass.getShiftMaster.getId));
//            criteria.setMaxResults(6);
//            return criteria.list();
//        });
        String query = "";
        query += ""
                + "From RotationMaster a "
                + " Where a.shiftRotationMaster = " + rotationMaster.getShiftRotationMaster().getId()
                + " AND a.shiftMaster = " + rotationMaster.getShiftMaster().getId();
                

        return getHibernateTemplate().find(query);

    }

    @Override
    public List<?> readForShiftValue(int shiftId1) {
        String query = "";
        query += " Select a.id, a.shiftName "
                + "From ShiftMaster a "
                + " Where a.id =" + shiftId1;

        return getHibernateTemplate().find(query);
    }

}
