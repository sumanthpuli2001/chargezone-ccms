/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.ConnectionType;

import com.bul.zydex.dao.GenericsDAO;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public interface ConnectionTypeDao<T> extends GenericsDAO<T> {

    public boolean isExist(T object);

    public List getConnectionTypePagination(int start, int length, String searchValue, String orderColumn, String orderDir);

    public int getConnectionTypeCount();

    public int getFilteredConnectionTypeCount(String searchValue);

}
