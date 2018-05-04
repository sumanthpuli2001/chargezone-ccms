/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao;

import com.bul.zydex.model.EmergencyContact;
import java.util.List;

/**
 *
 * @author DELL3
 */
public class EmergencyContactDAOImpl<T> extends GenericsDAOImpl<T> implements EmergencyContactDAO<T> {

    @Override
    protected Class getDomainClass() {
        return EmergencyContact.class;
    }

    @Override
    public EmergencyContact readEmergencyContact() {

        EmergencyContact emergencyContact = new EmergencyContact();

        String query = " SELECT a"
                + " FROM EmergencyContact a";

        List<?> list = getHibernateTemplate().find(query);

        if (!list.isEmpty()) {
            emergencyContact = (EmergencyContact) list.get(0);
        }
        return emergencyContact;
    }

}
