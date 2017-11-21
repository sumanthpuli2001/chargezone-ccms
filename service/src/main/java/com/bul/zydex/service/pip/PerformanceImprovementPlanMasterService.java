/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.pip;

import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author AJAY
 */
public interface PerformanceImprovementPlanMasterService<T> extends GenericsService<T> {

    public List<?> readPipByEmployeeMaster(T object);

    public List<?> viewPipListByManager(String managerId);

    public List<?> viewPipListByAdmin();

    public List<?> readOwnPipPending(T object);

    public List<?> readEmployeePipPending(String managerId);
    
    public int countOwnPipPending(T object);
    
    public int countEmployeePipPending(String managerId);
}
