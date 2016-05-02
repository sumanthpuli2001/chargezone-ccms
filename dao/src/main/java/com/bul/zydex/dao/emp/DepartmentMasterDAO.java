/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.emp;

import com.bul.zydex.dao.*;
import java.util.List;

/**
 *
 * @author Administrator
 * @param <T>
 */
public interface DepartmentMasterDAO<T> extends GenericsDAO<T> {

    public boolean isExist(T object);

    public List<?> countEmpByDepartmentList();

    public List<?> countResignedEmpOfDept();

    public List<?> countEmpByDepartmentList2();
    
    public List<?> readByName(String departmentName);
}
