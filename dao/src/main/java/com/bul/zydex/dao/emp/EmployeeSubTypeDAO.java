/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.emp;

import com.bul.zydex.dao.GenericsDAO;
import java.util.List;

/**
 *
 * @author Nishant
 */
public interface EmployeeSubTypeDAO<T> extends GenericsDAO<T> {

    public List<?> readByEmployeeTypeId(String typeId);

    public List<?> readByName(String name);

    public List<?> readByID(int empsubtypid);

    public List<?> readByEmployeeTypeIdANDSubTypeName(int emptypid, String employeeSubtype);

    public List<?> readOrderNameWise();
}
