/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.PayrollESIC;

import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Dell-1
 */
public interface ESICMasterService<T> extends GenericsService<T> {

    public boolean isExist(T object);

    public List<?> readEsic();

    public List<?> esicChalanSearch(EmployeeMaster object);

    public List<?> esicChalanemCount(EmployeeMaster object);

}
