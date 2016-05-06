/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.emp;

import com.bul.zydex.model.EmployeeAdvanceSearch;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Administrator
 * @param <T>
 */
public interface EmployeeMasterService<T> extends GenericsService<T> {

    public List<?> readByUserName(T object);

    public List<?> readByEmployeeUserId(T object);

    public List<?> readEmployeeDetailUserIdWise(T object);

    public List<?> readForAliveEmployeesNew();

    public List<?> readEmployeesDetail();

    public List<?> readByEmployeeLevelId(T object);

    public List<?> readByEmployeeLevel1Id(T object);

    public List<?> readByEmployeeLevel2Id(T object);

    public List<?> readByEmployeeLevel3Id(T object);

    public List<?> readByEmployeeLevel4Id(T object);

    public List<?> readByEmployeeLevel5Id(T object);

    public List<?> readByEmployeeLevel6Id(T object);

    public List<?> readByReportManager(T object);

    public List<?> readEmployeeSearch();

    public List<?> readEmployeeAjax(int id);

    public List<?> readManagerLevel1(T Object);

    public List<?> readForAprove(int id);

    public List<?> readForEmployeeType(int id);

    public List<?> readForProbation(T object);

    public List<?> readForProbationForManager(String id, String employeeId);

    public List<?> readForProbationlevel2(String reportingManagerId, String employeeId);

    public List<?> readForProbationlevel3(String reportingManagerId, String employeeId);

    public List<?> readForProbationlevel4(String reportingManagerId, String employeeId);

    public List<?> readfunctionalhead(int id);

    public List<?> readEmployeeDetail(T object);

    public List<?> readAttendanceData(final String today);

    public List<?> readReportingHierarchyList(final int reportingManagerId);

    public List<?> readEmployeeForParticularManager(int id);

    public List<?> searchEmployeeDetail(final String searchString);

    public List<?> readByName(String empName);

    public List<?> readByReportingManager(final String oldReportingManagerId);

    public List<?> readByEmployeeNo(int employeeNo);

    public List<?> getLastYearPerformanceRatingOfEmployee(final int EmployeePrimaryId);

    public List<?> readEmployeeDataForexportToExcel(final String searchEmployeeString);

    public List<?> isEmailExist(String email);

    public List<?> readAllEmail();

    public List<?> updatePwdBeforeSubmit(int id);

    public List<?> updateEmailAfterSubmit(int id, String Email);

    public List<?> readForCommonList();

    public List<?> readEmployeeId(final String employeeId);

    public List<?> empOrDateWiseSearch(EmployeeAdvanceSearch employeeAdvanceSearch);

    public List<?> empAttendanceDataSearch(EmployeeAdvanceSearch employeeAdvanceSearch);

    public List<?> pswdExist(String password, String id);

    public List<?> readDateOfLeaving(int id);

    public List<?> readEmployeesDetail1();

    public List<?> readFormerEmployeeDataForexportToExcel();

    public List<?> readByEmployeeReportingManagerId(T object);

    public List<?> getEmployeeDetatilByEmp_Id(final int id);

    public List<?> empOrDateWiseSearchforActive(EmployeeAdvanceSearch employeeAdvanceSearch);

    public List<?> empOrDateWiseSearchforInActive(EmployeeAdvanceSearch employeeAdvanceSearch);

    public List<?> readProbationByAdmin();

    public List<?> readForProbationToConfirmation();

    public List<?> readEmployeeForLeaveBalance(T object);
}
