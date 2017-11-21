/*
 *
 * Author Dhaval
 */
package com.bul.zydex.dao.pip;

import com.bul.zydex.dao.GenericsDAO;
import java.util.List;

/**
 *
 * @author Dhaval
 */
public interface PerformanceImprovementPlanMasterDAO<T> extends GenericsDAO<T> {

    public List<?> readPipByEmployeeMaster(T object);

    public List<?> viewPipListByManager(String managerId);

    public List<?> viewPipListByAdmin();

    public List<?> readOwnPipPending(T object);

    public List<?> readEmployeePipPending(String managerId);
    
    public int countOwnPipPending(T object);
    
    public int countEmployeePipPending(String managerId);
}
