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

    public List readByEmailMobile(String emailid, String mobileNo);

    public EmployeeMaster readUser(String username);

    public List readAuthorizserUser(String location, String department);

    public List readByEmployeeId(String user_id, String full_name);

    public List readTenderEmployee();

    public List radByUserName(String username1);

    public EmployeeMaster readByfullname(String employee_code);

    public EmployeeMaster readByEmployeeName(String user1);

    public List readByDepartName(String departName);

    public List readByRightsName(String rigName);

    public List getEmployeeMasterPagination(int start, int length, String searchValue, String orderColumn, String orderDir);

    public int getTotalEmployeeMasterCount();

    public int getFilteredEmployeeMasterCount(String searchValue);


    
}
