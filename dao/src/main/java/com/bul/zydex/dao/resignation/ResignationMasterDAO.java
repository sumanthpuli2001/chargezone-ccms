/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.resignation;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.ResignationMaster;
import java.util.List;

/**
 *
 * @author dhruv
 */
public interface ResignationMasterDAO<T> extends GenericsDAO<T> {

    public List<?> readByEmpID(int id);

    public List<?> readRegStatusList(T object);

    public List<?> readApprovedList(int id);

    public List<?> readByResignationPendingRequest(T object);

    public List<?> readforapprover(T object);

    public List<?> readforHR(T object);

    public List<?> readExistingList(int id);

    public List<?> readmanager1(int id);

    public List<?> readSearchRequest(T object);

    public List<?> readmanagerSearchRequest(T object);

    public List<?> readresignationApproverPendingRequest(T object);

    public List<?> readEmpIdFromTabId(int id);

    public List<?> readResignedEmployees();

    public List<?> getFinallyResignedEmployees();

    public List<?> getFinallyResignedEmployeesForDashBoard(String employeeId, boolean employeeExit, boolean itAdmin, boolean travelAdmin);

    public ResignationMaster readByEmpId(int EmpId);
    
    public List<?> fetchBWdate(int emp, String eftDate, String relivDate);

}
