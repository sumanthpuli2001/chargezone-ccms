/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.emp;

import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author admin
 */
public interface EmployeeVisaDetailsService<T> extends GenericsService<T> {

    public List<?> readByemployeeId(Integer id);

    public void deleteByemployeeId(Integer id);

    public boolean employeeVisadetailsexist(Integer id);
    
}
