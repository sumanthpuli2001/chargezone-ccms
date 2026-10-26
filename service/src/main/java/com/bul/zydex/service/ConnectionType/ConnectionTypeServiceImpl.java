/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.ConnectionType;

import com.bul.zydex.dao.ConnectionType.ConnectionTypeDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class ConnectionTypeServiceImpl<T> extends GenericsServiceImpl<T> implements ConnectionTypeService<T> {

    private ConnectionTypeDao<T> connectionTypeDao;

    public ConnectionTypeDao<T> getConnectionTypeDao() {
        return connectionTypeDao;
    }

    public void setConnectionTypeDao(ConnectionTypeDao<T> connectionTypeDao) {
        this.connectionTypeDao = connectionTypeDao;
        setGenericsDAO(connectionTypeDao);

    }

    @Override
    public boolean isExist(T object) {
        return connectionTypeDao.isExist(object);
    }

    @Override
    public List getConnectionTypePagination(int start, int length, String searchValue, String orderColumn, String orderDir) {
        return connectionTypeDao.getConnectionTypePagination(start, length, searchValue, orderColumn, orderDir);
    }

    @Override
    public int getConnectionTypeCount() {
        return connectionTypeDao.getConnectionTypeCount();
    }

    @Override
    public int getFilteredConnectionTypeCount(String searchValue) {
        return connectionTypeDao.getFilteredConnectionTypeCount(searchValue);
    }

}
