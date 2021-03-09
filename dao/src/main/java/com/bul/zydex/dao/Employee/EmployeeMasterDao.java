/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Employee;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.EmployeeMaster;
import java.util.List;

/**
 *
 * @author Aman Bahukhandi
 */
public interface EmployeeMasterDao<T> extends GenericsDAO<T> {

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
