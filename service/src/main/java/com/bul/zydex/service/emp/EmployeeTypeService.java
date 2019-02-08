/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.emp;

import com.bul.zydex.model.EmployeeTypeMaster;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Nishant
 */
public interface EmployeeTypeService<T> extends GenericsService<T> {

    public boolean isExist(EmployeeTypeMaster employeeTypeMaster);

    public List<?> readByName(String name);

    public List<?> readByID(int emptypid);

}
