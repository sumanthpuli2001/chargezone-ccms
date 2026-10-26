/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.ManagerialPerson;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.ManagerialPerson;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class ManagerialPersonDaoImpl<T> extends GenericsDAOImpl<T> implements ManagerialPersonDao<T> {

    @Override
    protected Class getDomainClass() {
        return ManagerialPerson.class;
    }

    @Override
    public List readInvitationId(int invitationId) {
        String query = "";
        query += " FROM ManagerialPerson a"
                + " WHERE a.vendorInvitationId = '" + invitationId + "'";
        return getHibernateTemplate().find(query);
    }

}
