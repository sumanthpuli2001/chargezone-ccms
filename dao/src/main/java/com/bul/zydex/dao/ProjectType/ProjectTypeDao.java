/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.ProjectType;

import com.bul.zydex.dao.GenericsDAO;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public interface ProjectTypeDao<T> extends GenericsDAO<T> {

    public List getProTypePagination(int start, int length, String searchValue, String orderColumn, String orderDir);

    public int getTotalProTypeCount();

    public int getFilteredProTypeCount(String searchValue);
}
