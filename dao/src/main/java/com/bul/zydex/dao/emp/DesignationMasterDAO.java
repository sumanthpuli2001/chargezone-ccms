/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.emp;

import com.bul.zydex.dao.*;
import java.util.List;

/**
  *
 * @author Administrator
 * @param <T>
 */
public interface DesignationMasterDAO<T> extends GenericsDAO<T> {
    
    public boolean isExist(T t);
    
    public List<?> readByName(String designation);
    
    public List<?> readDesignationAndLevel();
    
    public List<?> readDesignationsOfLevel(final int levelMasterId);

    public List<?> readByID(int empdesig);

}
