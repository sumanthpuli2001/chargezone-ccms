/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Employee;

import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Aman Bahukhandi
 */
public interface EmployeeMasterService<T> extends GenericsService<T> {

    Boolean readByRifId(String rfId);

    public EmployeeMaster read(String empCode);

    public void deleteByEmpCode(String checkedValues);

    public List readShift(String code);

    public EmployeeMaster readByRfIdValue(String empCode);

    public List readByDrow();

    public List readByDrowDisable();

    public List readByRfId(String rfId);
    public List readByRFid(String rfId);

}
