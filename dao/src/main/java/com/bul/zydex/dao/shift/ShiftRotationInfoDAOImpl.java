/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.shift;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.ShiftRotationInfo;
import java.util.List;

/**
 *
 * @author AJAY
 */
public class ShiftRotationInfoDAOImpl<T> extends GenericsDAOImpl<T> implements ShiftRotationInfoDAO<T> {

    @Override
    protected Class getDomainClass() {
        return ShiftRotationInfo.class;
    }

    @Override
    public List<?> readRotaionDetail(T object) {
        ShiftRotationInfo shiftRotationInfo = (ShiftRotationInfo) object;
        String query = "";

        query += ""
                + " FROM ShiftRotationInfo a"
                + " WHERE a.userMaster.id=" + shiftRotationInfo.getUserMaster().getId();

        return getHibernateTemplate().find(query);
    }

    @Override
    public String readFirstShfitId(String userId, String roationId) {
//        ShiftRotationInfo shiftRotationInfo = (ShiftRotationInfo) object;
        String query = "";

        query += "Select a.firstShiftId"
                + " FROM ShiftRotationInfo a"
                + " WHERE a.userMaster=" + userId
                + " AND a.shiftRotationMaster=" + roationId;
        if (getHibernateTemplate().find(query).size() != 0) {
            return "" + getHibernateTemplate().find(query).get(0);

        } else {
            return "";
        }
    }

    @Override
    public List<?> readByUserId(int usermasterid) {
        String query = "";
        query += "From ShiftRotationInfo a "
              + " Where a.userMaster.id =" + usermasterid ;
        return getHibernateTemplate().find(query);
    }
    
    @Override
    public List<?> readShiftRotationMaster() {
        String query = "";
        query += "From ShiftRotationMaster a ";
        
        return getHibernateTemplate().find(query);
    }
    
}
