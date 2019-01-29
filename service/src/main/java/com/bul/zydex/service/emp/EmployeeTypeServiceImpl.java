/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.emp;

import com.bul.zydex.dao.emp.EmployeeTypeDAO;
import com.bul.zydex.model.EmployeeTypeMaster;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Nishant
 */
public class EmployeeTypeServiceImpl<T> extends GenericsServiceImpl<T> implements EmployeeTypeService<T>{
    private EmployeeTypeDAO<T>employeeTypeDAO;

    public EmployeeTypeDAO<T> getEmployeeTypeDAO() {
        return employeeTypeDAO;
    }

    public void setEmployeeTypeDAO(EmployeeTypeDAO<T> employeeTypeDAO) {
        this.employeeTypeDAO = employeeTypeDAO;
        setGenericsDAO(employeeTypeDAO);
    }

    @Override
    public boolean isExist(EmployeeTypeMaster employeeTypeMaster) {
          
        EmployeeTypeMaster employeeTypeMaster2 = (EmployeeTypeMaster) employeeTypeMaster;

        List<?> list = employeeTypeDAO.read();
        Iterator i = list.iterator();
        while (i.hasNext()) {
            employeeTypeMaster = (EmployeeTypeMaster) i.next();
            if (employeeTypeMaster.getTypeOfEmployee().equalsIgnoreCase(employeeTypeMaster2.getTypeOfEmployee())) {
                return true;
            }
        }

        return false;
}

    @Override
    public List<?> readByName(String name) {
       return employeeTypeDAO.readByName(name);
    }

    @Override
    public List<?> readByID(int readByID) {
        return employeeTypeDAO.readByID(readByID);
    }
    }

   

