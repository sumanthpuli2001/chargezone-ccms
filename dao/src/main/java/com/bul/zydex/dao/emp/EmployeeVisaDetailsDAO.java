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
 * @author admin
 */
public interface EmployeeVisaDetailsDAO<T> extends GenericsDAO<T> {
     public List<?> readByemployeeId(Integer id);
     
     public void deleteByemployeeId(Integer id);

    public boolean employeeVisadetailsexist(Integer id);

    public List<?> readBySingleemployeeId(Integer id);
}
