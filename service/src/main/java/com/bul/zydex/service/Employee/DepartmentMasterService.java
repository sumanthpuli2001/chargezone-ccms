/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Employee;

import com.bul.zydex.model.DepartmentMaster;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Bulwark-5
 */
public interface DepartmentMasterService<T> extends GenericsService<T> {

    public List getDepartmentPagination(int start, int length, String search, String orderColumn, String orderDir);

    public int getTotalDepartmentCount();

    public int getFilteredDepartmentCount(String search);
}
