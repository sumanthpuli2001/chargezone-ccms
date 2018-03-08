/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.emp;

import com.bul.zydex.dao.emp.EmployeeMasterDAO;
import com.bul.zydex.model.EmployeeAdvanceSearch;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Administrator
 * @param <T>
 */
public class EmployeeMasterServiceImpl<T> extends GenericsServiceImpl<T>
        implements EmployeeMasterService<T> {

    private EmployeeMasterDAO<T> employeeMasterDAO;

    public EmployeeMasterDAO<T> getEmployeeMasterDAO() {
        return employeeMasterDAO;
    }

    public void setEmployeeMasterDAO(EmployeeMasterDAO<T> employeeMasterDAO) {
        this.employeeMasterDAO = employeeMasterDAO;
        setGenericsDAO(employeeMasterDAO);
    }

    @Override
    public List<?> readByUserName(T object) {
        return employeeMasterDAO.readByUserName(object);
    }

    @Override
    public List<?> readByEmployeeUserId(T object) {
        return employeeMasterDAO.readByEmployeeUserId(object);
    }

    @Override
    public List<?> readEmployeeDetailUserIdWise(T object) {
        return employeeMasterDAO.readEmployeeDetailUserIdWise(object);
    }

    @Override
    public List<?> readForAliveEmployeesNew() {
        return employeeMasterDAO.readForAliveEmployeesNew();
    }

    @Override
    public List<?> readEmployeesDetail() {
        return employeeMasterDAO.readEmployeesDetail();
    }

    @Override
    public List<?> readByEmployeeLevelId(T object) {
        return employeeMasterDAO.readByEmployeeLevelId(object);
    }

    @Override
    public List<?> readByEmployeeLevel1Id(T object) {
        return employeeMasterDAO.readByEmployeeLevel1Id(object);
    }

    @Override
    public List<?> readByEmployeeLevel2Id(T object) {

        return employeeMasterDAO.readByEmployeeLevel2Id(object);
    }

    @Override
    public List<?> readByEmployeeLevel3Id(T object) {
        return employeeMasterDAO.readByEmployeeLevel3Id(object);
    }

    @Override
    public List<?> readByEmployeeLevel4Id(T object) {
        return employeeMasterDAO.readByEmployeeLevel4Id(object);
    }

    @Override
    public List<?> readByEmployeeLevel5Id(T object) {
        return employeeMasterDAO.readByEmployeeLevel5Id(object);
    }

    @Override
    public List<?> readByEmployeeLevel6Id(T object) {
        return employeeMasterDAO.readByEmployeeLevel6Id(object);
    }

    @Override
    public List<?> readEmployeeSearch() {
        return employeeMasterDAO.readEmployeeSearch();
    }

    @Override
    public List<?> readEmployeeAjax(int id) {
        return employeeMasterDAO.readEmployeeAjax(id);
    }

    @Override
    public List<?> readByReportManager(T object) {
        return employeeMasterDAO.readByReportManager(object);
    }

    @Override
    public List<?> readEmployeeDetail(T object) {
        return employeeMasterDAO.readEmployeeDetail(object);
    }

    @Override
    public List<?> readManagerLevel1(T object) {
        return employeeMasterDAO.readManagerLevel1(object);
    }

    @Override
    public List<?> readForAprove(int id) {
        return employeeMasterDAO.readForAprove(id);
    }

    @Override
    public List<?> readForEmployeeType(int id) {
        return employeeMasterDAO.readForEmployeeType(id);
    }

    @Override
    public List<?> readForProbation(T object) {
        return employeeMasterDAO.readForProbation(object);
    }

    @Override
    public List<?> readForProbationForManager(String object, String employeeId) {
        return employeeMasterDAO.readForProbationForManager(object, employeeId);
    }

    @Override
    public List<?> readForProbationlevel2(String reportingManagerId, String employeeId) {
        return employeeMasterDAO.readForProbationlevel2(reportingManagerId, employeeId);

    }

    @Override
    public List<?> readForProbationlevel3(String reportingManagerId, String employeeId) {
        return employeeMasterDAO.readForProbationlevel3(reportingManagerId, employeeId);

    }

    @Override
    public List<?> readForProbationlevel4(String reportingManagerId, String employeeId) {
        return employeeMasterDAO.readForProbationlevel4(reportingManagerId, employeeId);
    }

    @Override
    public List<?> readfunctionalhead(int id) {
        return employeeMasterDAO.readfunctionalhead(id);
    }

    @Override
    public List<?> readAttendanceData(final String today) {
        return employeeMasterDAO.readAttendanceData(today);
    }

    @Override
    public List<?> readReportingHierarchyList(final int reportingManagerId) {
        return employeeMasterDAO.readReportingHierarchyList(reportingManagerId);
    }

    @Override
    public List<?> readEmployeeForParticularManager(int id) {
        return employeeMasterDAO.readEmployeeForParticularManager(id);
    }

    @Override
    public List<?> searchEmployeeDetail(final String searchString) {
        return employeeMasterDAO.searchEmployeeDetail(searchString);
    }

    @Override
    public List<?> readByName(String empName) {
        return employeeMasterDAO.readByName(empName);
    }

    @Override
    public List<?> readByEmployeeNo(int employeeNo) {
        return employeeMasterDAO.readByEmployeeNo(employeeNo);
    }

    @Override
    public List<?> readByReportingManager(final String oldReportingManagerId) {
        return employeeMasterDAO.readByReportingManager(oldReportingManagerId);
    }

    @Override
    public List<?> getLastYearPerformanceRatingOfEmployee(final int EmployeePrimaryId) {
        return employeeMasterDAO.getLastYearPerformanceRatingOfEmployee(EmployeePrimaryId);
    }

    @Override
    public List<?> readEmployeeDataForexportToExcel(final String searchEmployeeString) {
        return employeeMasterDAO.readEmployeeDataForexportToExcel(searchEmployeeString);
    }

    @Override
    public List<?> isEmailExist(String email) {
        return employeeMasterDAO.isEmailExist(email);
    }

    @Override
    public List<?> readAllEmail() {
        return employeeMasterDAO.readAllEmail();
    }

    @Override
    public List<?> updatePwdBeforeSubmit(int id) {
        return employeeMasterDAO.updatePwdBeforeSubmit(id);
    }

    @Override
    public List<?> updateEmailAfterSubmit(int id, String Email) {
        return employeeMasterDAO.updatePwdAfterSubmit(id, Email);
    }

    @Override
    public List<?> readForCommonList() {
        return employeeMasterDAO.readForCommonList();
    }

    @Override
    public List<?> readEmployeeId(final String employeeId) {
        return employeeMasterDAO.readEmployeeId(employeeId);
    }

    @Override
    public List<?> empOrDateWiseSearch(EmployeeAdvanceSearch employeeAdvanceSearch) {
        return employeeMasterDAO.empOrDateWiseSearch(employeeAdvanceSearch);
    }

    @Override
    public List<?> empOrDateWiseSearchforActive(EmployeeAdvanceSearch employeeAdvanceSearch) {
        return employeeMasterDAO.empOrDateWiseSearchforActive(employeeAdvanceSearch);
    }

    @Override
    public List<?> empOrDateWiseSearchforInActive(EmployeeAdvanceSearch employeeAdvanceSearch) {
        return employeeMasterDAO.empOrDateWiseSearchforInActive(employeeAdvanceSearch);
    }

    @Override
    public List<?> empAttendanceDataSearch(EmployeeAdvanceSearch employeeAdvanceSearch) {
        return employeeMasterDAO.empAttendanceDataSearch(employeeAdvanceSearch);
    }

    @Override
    public List<?> pswdExist(String password, String id) {
        return employeeMasterDAO.pswdExist(password, id);
    }

    @Override
    public List<?> readDateOfLeaving(int id) {
        return employeeMasterDAO.readDateOfLeaving(id);
    }

    @Override
    public List<?> readEmployeesDetail1() {
        return employeeMasterDAO.readEmployeesDetail1();
    }

    @Override
    public List<?> readFormerEmployeeDataForexportToExcel() {
        return employeeMasterDAO.readFormerEmployeeDataForexportToExcel();
    }

    @Override
    public List<?> readByEmployeeReportingManagerId(T object) {
        return employeeMasterDAO.readByEmployeeReportingManagerId(object);
    }

    @Override
    public List<?> getEmployeeDetatilByEmp_Id(final int id) {
        return employeeMasterDAO.getEmployeeDetatilByEmp_Id(id);
    }

    @Override
    public List<?> readProbationByAdmin() {
        return employeeMasterDAO.readProbationByAdmin();
    }

    @Override
    public List<?> readForProbationToConfirmation() {
        return employeeMasterDAO.readForProbationToConfirmation();
    }

    @Override
    public List<?> readEmployeeForLeaveBalance(T object) {
        return employeeMasterDAO.readEmployeeForLeaveBalance(object);
    }

    @Override
    public List<?> readEmployeeForLeaveBalanceForActiveUser(T object) {
        return employeeMasterDAO.readEmployeeForLeaveBalanceForActiveUser(object);
    }

    @Override
    public List<?> readEmployeeForLeaveBalanceForInActiveUser(T object) {
        return employeeMasterDAO.readEmployeeForLeaveBalanceForInActiveUser(object);
    }

    @Override
    public List<?> listOfCEO() {
        return employeeMasterDAO.listOfCEO();
    }

    @Override
    public List<?> readEmployeeForPlant() {
        return employeeMasterDAO.readEmployeeForPlant();
    }

    @Override
    public List<?> readEmpUserIdWise(T object) {
        return employeeMasterDAO.readEmpUserIdWise(object);
    }

    @Override
    public List<?> readAllSubordinate(T object) {
        return employeeMasterDAO.readAllSubordinate(object);
    }

    @Override
    public List<?> readForSendMailToAll(T object) {
        return employeeMasterDAO.readForSendMailToAll(object);
    }

    @Override
    public List<?> readDepartmentWiseEmployee(T object) {
        return employeeMasterDAO.readDepartmentWiseEmployee(object);
    }

    @Override
    public List<?> readByJoinDate(String date) {
        return employeeMasterDAO.readByJoinDate(date);
    }

    @Override
    public List<?> readByEmployeeId(String empid) {
        return employeeMasterDAO.readByEmployeeId(empid);
    }

    @Override
    public Boolean checkLevel1AndLevel5FunctionheadByEmployeeMasterId(int empId) {
        return employeeMasterDAO.checkLevel1AndLevel5FunctionheadByEmployeeMasterId(empId);
    }

    @Override
    public Boolean checkLevel1AndLevel6FunctionheadByEmployeeMasterId(int empId) {
        return employeeMasterDAO.checkLevel1AndLevel5FunctionheadByEmployeeMasterId(empId);
    }

    @Override
    public List<?> readLevel1AndLevel5FunctionheadByEmployeeMasterId(int id) {
        return employeeMasterDAO.readLevel1AndLevel5FunctionheadByEmployeeMasterId(id);
    }

    @Override
    public List<?> readEmployeeByBirthday(String date) {
        return employeeMasterDAO.readEmployeeByBirthday(date);
    }

    @Override
    public List<?> newJoiningEmployee(String date) {
        return employeeMasterDAO.newJoiningEmployee(date);
    }

    @Override
    public List<?> searchEmployeeDetailForContactInfo(String searchString) {
          return employeeMasterDAO.searchEmployeeDetailForContactInfo(searchString);
    }
}
