/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.SqlDataConnect;

import com.bul.zydex.dao.SqlDataConnect.SqlDataConnectDao;
import com.bul.zydex.service.GenericsServiceImpl;

/**
 *
 * @author jaimini.parmar
 */
public class SqlDataConnectServiceImpl<T> extends GenericsServiceImpl<T> implements SqlDataConnectService<T> {
    private SqlDataConnectDao<T>sqlDataConnectDao;

    public SqlDataConnectDao<T> getSqlDataConnectDao() {
        return sqlDataConnectDao;
    }

    public void setSqlDataConnectDao(SqlDataConnectDao<T> sqlDataConnectDao) {
        this.sqlDataConnectDao = sqlDataConnectDao;
        setGenericsDAO(sqlDataConnectDao);
    }
}
