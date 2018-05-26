/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.emp;

import com.bul.zydex.dao.emp.DepartmentMasterDAO;
import com.bul.zydex.service.*;
import java.util.List;

/**
 *
 * @author Administrator
 * @param <T>
 */
public class DepartmentMasterServiceImpl<T> extends GenericsServiceImpl<T>
        implements DepartmentMasterService<T> {

    private DepartmentMasterDAO<T> departmentMasterDAO;

    public DepartmentMasterDAO<T> getDepartmentMasterDAO() {
        return departmentMasterDAO;
    }

    public void setDepartmentMasterDAO(DepartmentMasterDAO<T> departmentMasterDAO) {
        this.departmentMasterDAO = departmentMasterDAO;
        setGenericsDAO(departmentMasterDAO);
    }

    @Override
    public boolean isExist(T object) {
        return departmentMasterDAO.isExist(object);
    }

    @Override
    public List<?> countEmpByDepartmentList() {
        return departmentMasterDAO.countEmpByDepartmentList();
    }

    @Override
    public List<?> countResignedEmpOfDept() {
        return departmentMasterDAO.countResignedEmpOfDept();
    }

    @Override
    public List<?> countEmpByDepartmentList2() {
        return departmentMasterDAO.countEmpByDepartmentList2();
    }

    @Override
    public List<?> countEmpByDepartmentList3() {
        return departmentMasterDAO.countEmpByDepartmentList3();
    }

    @Override
    public List<?> readByName(String departmentName) {
        return departmentMasterDAO.readByName(departmentName);
    }

}
