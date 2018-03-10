/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.ApplayJobUserMaster;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.ApplayJobUserMaster;
import java.util.List;

/**
 *
 * @author Vikas
 */
public class ApplayJobUserMasterDAOImpl<T> extends GenericsDAOImpl<T> implements ApplayJobUserMasterDAO<T> {

    @Override
    protected Class getDomainClass() {
        return ApplayJobUserMaster.class;
    }

    @Override
    public boolean isExist(T object) {
        ApplayJobUserMaster applayJobUserMaster = (ApplayJobUserMaster) object;
        String query = "";
        query += ""
                + " From ApplayJobUserMaster a "
                + " WHERE a.userName = '" + applayJobUserMaster.getUserName() + "'"
                + " And a.password = '" + applayJobUserMaster.getPassword() + "'";
        List list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            return true;
        }
        return false;
    }
    @Override
    public List<?> isExist1(T object) {
        ApplayJobUserMaster applayJobUserMaster = (ApplayJobUserMaster) object;
        String query = "";
        query += " Select a.id"
                + " From ApplayJobUserMaster a "
                + " WHERE a.userName = '" + applayJobUserMaster.getUserName() + "'"
                + " And a.password = '" + applayJobUserMaster.getPassword() + "'";
        List list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public boolean profileFilling(int userId) {
        int profileId = 0;

        String query = " Select a.profileSubmit "
                + " From ApplayJobUserMaster a "
                + " WHERE a.id = '" + userId;

        List list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {

        }
        return false;
    }

    @Override
    public ApplayJobUserMaster checkByUserNameandPass(T object) {
        ApplayJobUserMaster ajum = new ApplayJobUserMaster();
        ApplayJobUserMaster applayJobUserMaster = (ApplayJobUserMaster) object;
        String query = "";
        query += ""
                + " From ApplayJobUserMaster a "
                + " WHERE a.userName = '" + applayJobUserMaster.getUserName() + "'"
                + " And a.password = '" + applayJobUserMaster.getPassword() + "'";
        List list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
             ajum = (ApplayJobUserMaster) list.get(0);

        }else{
           ajum = null;
        }
        return ajum;
    }

}
