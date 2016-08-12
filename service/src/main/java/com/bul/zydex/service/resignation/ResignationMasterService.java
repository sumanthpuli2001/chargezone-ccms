/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.resignation;

import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author dhruv
 */
public interface ResignationMasterService<T> extends GenericsService<T> {

    public List<?> readByEmpID(int id);

    public List<?> readApprovedList(int id);

    public List<?> readRegStatusList(T object);

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

    public List<?> getFinallyResignedEmployeesForDashBoard(String employeeId,boolean  employeeExit,boolean  itAdmin,boolean  travelAdmin);

}
