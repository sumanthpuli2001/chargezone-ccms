/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.ChargerInstallationDetails;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.ChargerInstallationDetails;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class ChargerInstallationDetailsDaoImpl<T> extends GenericsDAOImpl<T> implements ChargerInstallationDetailsDao<T> {

    @Override
    protected Class getDomainClass() {

        return ChargerInstallationDetails.class;
    }

    @Override
    public List readByoapId(String id) {

        String query = "";
        query += " FROM ChargerInstallationDetails a"
                + " WHERE a.oapId = '" + id + "'";

        return getHibernateTemplate().find(query);

    }

}
