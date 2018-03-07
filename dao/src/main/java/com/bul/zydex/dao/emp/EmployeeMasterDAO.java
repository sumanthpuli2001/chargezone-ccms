/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.emp;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.EmployeeAdvanceSearch;
import java.util.List;

/**
 *
 * @author Administrator
 * @param <T>
 */
public interface EmployeeMasterDAO<T> extends GenericsDAO<T> {

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

    public List<?> readEmployeeSearch();

    public List<?> readEmployeeAjax(int id);

//    Employee Request
    public List<?> readByReportManager(T object);

    public List<?> readManagerLevel1(T object);

    public List<?> readForAprove(int id);
//    Probation TO Confirmation

    public List<?> readForEmployeeType(int id);

    public List<?> readForProbation(T object);

    public List<?> readForProbationForManager(String reportingManagerId, String employeeId);

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

    public List<?> isEmailExist(String email);

    public List<?> readAllEmail();

    public List<?> updatePwdBeforeSubmit(int id);

    public List<?> updatePwdAfterSubmit(int id, String Email);

    public List<?> readByReportingManager(final String oldReportingManagerId);

    public List<?> readByEmployeeNo(int employeeNo);

    public List<?> getLastYearPerformanceRatingOfEmployee(final int EmployeePrimaryId);

    public List<?> readEmployeeDataForexportToExcel(final String searchEmployeeString);

    public List<?> readForCommonList();

    public List<?> readEmployeeId(final String employeeId);

    public List<?> empOrDateWiseSearch(EmployeeAdvanceSearch employeeAdvanceSearch);

    public List<?> empOrDateWiseSearchforActive(EmployeeAdvanceSearch employeeAdvanceSearch);

    public List<?> empOrDateWiseSearchforInActive(EmployeeAdvanceSearch employeeAdvanceSearch);

    public List<?> empAttendanceDataSearch(EmployeeAdvanceSearch employeeAdvanceSearch);

    public List<?> pswdExist(String password, String id);

    public List<?> readDateOfLeaving(int id);

    public List<?> readEmployeesDetail1();

    public List<?> readFormerEmployeeDataForexportToExcel();

    public List<?> readByEmployeeReportingManagerId(T object);

    public List<?> getEmployeeDetatilByEmp_Id(final int id);

    public List<?> readProbationByAdmin();

    public List<?> readForProbationToConfirmation();

    public List<?> readEmployeeForLeaveBalance(T object);

    public List<?> readEmployeeForLeaveBalanceForActiveUser(T object);

    public List<?> readEmployeeForLeaveBalanceForInActiveUser(T object);

    public List<?> listOfCEO();

    public List<?> readEmployeeForPlant();

    public List<?> readEmpUserIdWise(T object);

    public List<?> readAllSubordinate(T object);

    public List<?> readForSendMailToAll(T object);

    public List<?> readDepartmentWiseEmployee(T object);

    public List<?> readByJoinDate(String date);

    public List<?> readByEmployeeId(String empid);

    public Boolean checkLevel1AndLevel6FunctionheadByEmployeeMasterId(int empId);

    public Boolean checkLevel1AndLevel5FunctionheadByEmployeeMasterId(int empId);

    public List<?> readLevel1AndLevel5FunctionheadByEmployeeMasterId(int id);

    public List<?> readEmployeeByBirthday(String date);

    public List<?> newJoiningEmployee(String date);

    public List<?> searchEmployeeDetailForContactInfo(final String searchString);

}
