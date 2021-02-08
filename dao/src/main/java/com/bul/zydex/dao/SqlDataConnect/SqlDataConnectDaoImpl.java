/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.SqlDataConnect;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.SqlDataConnect;

/**
 *
 * @author jaimini.parmar
 */
public class SqlDataConnectDaoImpl<T>extends GenericsDAOImpl<T> implements SqlDataConnectDao<T> {
     @Override
    protected Class getDomainClass() {
        return SqlDataConnect.class;
    }
}
