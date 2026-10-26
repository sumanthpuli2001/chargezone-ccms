/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Employee;

import com.bul.zydex.dao.Employee.DepartmentMasterDao;
import com.bul.zydex.model.DepartmentMaster;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Bulwark-5
 */
public class DepartmentMasterServiceImpl<T> extends GenericsServiceImpl<T> implements DepartmentMasterService<T> {

    private DepartmentMasterDao<T> departmentMasterDao;

    public DepartmentMasterDao<T> getDepartmentMasterDao() {
        return departmentMasterDao;
    }

    public void setDepartmentMasterDao(DepartmentMasterDao<T> departmentMasterDao) {
        this.departmentMasterDao = departmentMasterDao;
        setGenericsDAO(departmentMasterDao);
    }

    @Override
    public List getDepartmentPagination(int start, int length, String search, String orderColumn, String orderDir) {
        return departmentMasterDao.getDepartmentPagination(start, length, search, orderColumn, orderDir);
    }

    @Override
    public int getTotalDepartmentCount() {
        return departmentMasterDao.getTotalDepartmentCount();
    }

    @Override
    public int getFilteredDepartmentCount(String search) {
        return departmentMasterDao.getFilteredDepartmentCount(search);
    }
}
