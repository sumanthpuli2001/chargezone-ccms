/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.PR;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.MultipleAddress;
import java.util.List;

/**
 *
 * @author admin
 */
public class MultipleAddressDaoImpl<T> extends GenericsDAOImpl<T> implements MultipleAddressDao<T> {

    @Override
    protected Class getDomainClass() {
        return MultipleAddress.class;
    }

    @Override
    public List readByPrNumber(String prNo) {
        String query = "";
        query += " FROM MultipleAddress a"
                + " WHERE a.prNumber = '" + prNo + "'";
        return getHibernateTemplate().find(query);
    }

}
