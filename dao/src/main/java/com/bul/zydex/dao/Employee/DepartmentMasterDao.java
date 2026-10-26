/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Employee;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.DepartmentMaster;
import java.util.List;

/**
 *
 * @author Bulwark-5
 */
public interface DepartmentMasterDao<T> extends GenericsDAO<T> {

    public List getDepartmentPagination(int start, int length, String search, String orderColumn, String orderDir);

    public int getTotalDepartmentCount();

    public int getFilteredDepartmentCount(String search);
}
