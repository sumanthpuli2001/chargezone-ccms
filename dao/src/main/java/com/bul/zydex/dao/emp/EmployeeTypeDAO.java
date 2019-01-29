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
public interface EmployeeTypeDAO<T> extends GenericsDAO<T> {

    public List<?> readByName(String name);

    public List<?> readByID(int readByID);
}
