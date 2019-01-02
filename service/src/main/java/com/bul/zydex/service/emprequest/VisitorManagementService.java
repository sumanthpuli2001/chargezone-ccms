/*
 * 
 * Author Vinita
 */
package com.bul.zydex.service.emprequest;

import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Vinita
 */
public interface VisitorManagementService<T> extends GenericsService<T> {

    public List<?> readByEmpId(T object);

    public List<?> readByrequesteeId(T object);

    public List<?> readByapproverId(T object);

    public List<?> readSearchEmpRequest(T object);

    public List<?> readSearchRequest(T object);

    public List<?> readVisitorManagementPendingRequest(T object);

    public List<?> readVisitorManagementApproverPendingRequest(T object);

    public List<?> readEmpIdFromTabId(int id);

    public int countVisitorManagementPendingRequest(T object);

    public int countVisitorManagementApproverPendingRequest(T object);

    public List<?> readSearchEmpRequestForSessionEmployee(Integer id, String startDate, String endDate, String status);

    public List<?> readByapproverId(String employeeId, String designationId, String departmentId, String startDate, String endDate, String status);

    public List<?> getDetailsByContactNo(String contactNo);
}
