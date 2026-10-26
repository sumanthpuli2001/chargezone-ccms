/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.ConnectorType;

import com.bul.zydex.dao.ConnectorType.ConnectorTypeDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class ConnectorTypeServiceImpl<T> extends GenericsServiceImpl<T> implements ConnectorTypeService<T> {

    private ConnectorTypeDao<T> connectorTypeDao;

    public ConnectorTypeDao<T> getConnectorTypeDao() {
        return connectorTypeDao;
    }

    public void setConnectorTypeDao(ConnectorTypeDao<T> connectorTypeDao) {
        this.connectorTypeDao = connectorTypeDao;
        setGenericsDAO(connectorTypeDao);
    }

    @Override
    public List getConnectorTypePagination(int start, int length, String searchValue, String orderColumn, String orderDir) {
        return connectorTypeDao.getConnectorTypePagination(start, length, searchValue, orderColumn, orderDir);
    }

    @Override
    public int getTotalConnectorTypeCount() {
        return connectorTypeDao.getTotalConnectorTypeCount();
    }

    @Override
    public int getFilteredConnectorTypeCount(String searchValue) {
        return connectorTypeDao.getFilteredConnectorTypeCount(searchValue);
    }
}
