/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.emp;

import com.bul.zydex.dao.emp.EmployeeSubTypeDAO;
import com.bul.zydex.model.EmployeeSubType;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Nishant
 */
public class EmployeeSubTypeServiceImpl<T> extends GenericsServiceImpl<T> implements EmployeeSubTypeService<T>{
    private EmployeeSubTypeDAO<T>employeeSubTypeDAO;

    public EmployeeSubTypeDAO<T> getEmployeeSubTypeDAO() {
        return employeeSubTypeDAO;
    }

    public void setEmployeeSubTypeDAO(EmployeeSubTypeDAO<T> employeeSubTypeDAO) {
        this.employeeSubTypeDAO = employeeSubTypeDAO;
          setGenericsDAO(employeeSubTypeDAO);
    }

    @Override
    public List<?> readByEmployeeTypeId(String typeId) {
return employeeSubTypeDAO.readByEmployeeTypeId(typeId);
    }

    @Override
    public boolean isExist(EmployeeSubType employeeSubType) {
                  boolean flag = false;
        List<?> list = employeeSubTypeDAO.read();
        Iterator i = list.iterator();
        while (i.hasNext()) {
            EmployeeSubType employeeSubType1 = (EmployeeSubType) i.next();
            if (employeeSubType1.getEmployeeTypeMaster().getId().intValue() 
                    == employeeSubType.getEmployeeTypeMaster().getId() && employeeSubType1.getSubType().equals(employeeSubType.getSubType())) {

                flag = true;
                break;
            }

        }

        return flag;
    }

    @Override
    public List<?> readByName(String name) {
        return employeeSubTypeDAO.readByName(name);
    }

    @Override
    public List<?> readByID(int empsubtypid) {
       return employeeSubTypeDAO.readByID(empsubtypid);
    }
    }
    
   

