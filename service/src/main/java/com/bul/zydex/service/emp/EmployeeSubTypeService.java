/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.emp;

import com.bul.zydex.model.EmployeeSubType;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Nishant
 */
public interface EmployeeSubTypeService<T> extends GenericsService<T> {

    public List<?> readByEmployeeTypeId(String typeId);

    public boolean isExist(EmployeeSubType employeeSubType);

    public List<?> readByName(String name);

    public List<?> readByID(int empsubtypid);

    public List<?> readByEmployeeTypeIdANDSubTypeName(int emptypid, String employeeSubtype);

}
