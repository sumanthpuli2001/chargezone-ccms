/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.emp;

import com.bul.zydex.service.*;
import java.util.List;

/**
 *
 * @author Administrator
 * @param <T>
 */
public interface DepartmentMasterService<T> extends GenericsService<T> {

    public boolean isExist(T object);

    public List<?> countEmpByDepartmentList();

    public List<?> countResignedEmpOfDept();

    public List<?> countEmpByDepartmentList2();

    public List<?> countEmpByDepartmentList3();

    public List<?> readByName(String departmentName);

}
