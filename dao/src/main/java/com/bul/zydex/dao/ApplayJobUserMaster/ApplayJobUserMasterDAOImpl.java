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

}
