/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.ChargerInstallationDetailsHistory;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.ChargerInstallationDetailsHistory;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class ChargerInstallationDetailsHistoryDaoImpl<T> extends GenericsDAOImpl<T> implements ChargerInstallationDetailsHistoryDao<T> {

    @Override
    protected Class getDomainClass() {
        return ChargerInstallationDetailsHistory.class;

    }

    @Override
    public List readByoapId(int oapid) {

        String query = "";
        query += " FROM ChargerInstallationDetailsHistory a"
                + " WHERE a.oapId = '" + oapid + "'";

        return getHibernateTemplate().find(query);

    }

}
