/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.PayrollESIC;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.EmployeeMaster;
import java.util.List;

/**
 *
 * @author Dell-1
 */
public interface ESICMasterDAO<T> extends GenericsDAO<T>{
    
    public boolean isExist(T object);

    public List<?> readEsic();
    
    public List<?> esicChalanSearch(EmployeeMaster object);
    
     public List<?> esicChalanemCount(EmployeeMaster object);
    
}
