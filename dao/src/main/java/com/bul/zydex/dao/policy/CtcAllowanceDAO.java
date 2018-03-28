/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.policy;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.EmployeeMaster;
import java.util.List;

/**
 *
 * @author Hussain
 */
public interface CtcAllowanceDAO<T> extends GenericsDAO<T> {

    public boolean isExist(T object);
    public List<?> readsalSearch();

}
