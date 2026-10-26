/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.ProjectNameMaster;

import com.bul.zydex.model.ProjectNameMaster;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface ProjectNameMasterService<T> extends GenericsService<T> {

    public boolean isExist(T object);

    public List getProjectNameMasterPagination(int start, int length, String searchValue, String orderColumn, String orderDir);

    public int getProjectNameMasterCount();

    public int getFilteredProjectNameMasterCount(String searchValue);

}
