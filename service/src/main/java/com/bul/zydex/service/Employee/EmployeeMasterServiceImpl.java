/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Employee;

import com.bul.zydex.dao.Employee.EmployeeMasterDao;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Aman Bahukhandi
 */
public class EmployeeMasterServiceImpl<T> extends GenericsServiceImpl<T> implements EmployeeMasterService<T> {

    private EmployeeMasterDao<T> employeeMasterDao;

    public EmployeeMasterDao<T> getEmployeeMasterDao() {
        return employeeMasterDao;
    }

    public void setEmployeeMasterDao(EmployeeMasterDao<T> employeeMasterDao) {
        this.employeeMasterDao = employeeMasterDao;
        setGenericsDAO(employeeMasterDao);
    }

    @Override
    public Boolean readByRifId(String rfId) {
        return employeeMasterDao.readByRifId(rfId);
    }

    @Override
    public EmployeeMaster read(String empCode) {
        return employeeMasterDao.read(empCode);
    }

    @Override
    public void deleteByEmpCode(String checkedValues) {
        employeeMasterDao.deleteByEmpCode(checkedValues);
    }

    @Override
    public List readShift(String code) {
        return employeeMasterDao.readShift(code);
    }

    @Override
    public EmployeeMaster readByRfIdValue(String empCode) {
        return employeeMasterDao.readByRfIdValue(empCode);
    }

    @Override
    public List readByDrow() {
        return employeeMasterDao.readByDrow();
    }

    @Override
    public List readByDrowDisable() {
        return employeeMasterDao.readByDrowDisable();
    }

    @Override
    public List readByRfId(String rfId) {
        return employeeMasterDao.readByRfId(rfId);
    }

    @Override
    public List readByRFid(String rfId) {
        return employeeMasterDao.readByRFid(rfId);
    }

    @Override
    public List readByEmailMobile(String emailid, String mobileNo) {
        return employeeMasterDao.readByEmailMobile(emailid, mobileNo);
    }

    @Override
    public EmployeeMaster readUser(String username) {
        return employeeMasterDao.readUser(username);
    }

    @Override
    public List readAuthorizserUser(String location, String department) {
        return employeeMasterDao.readAuthorizserUser(location, department);
    }

    @Override
    public List readByEmployeeId(String user_id, String full_name) {
        return employeeMasterDao.readByEmployeeId(user_id, full_name);
    }

    @Override
    public List readTenderEmployee() {
        return employeeMasterDao.readTenderEmployee();
    }

    @Override
    public List radByUserName(String username1) {
        return employeeMasterDao.radByUserName(username1);
    }

    @Override
    public EmployeeMaster readByfullname(String employee_code) {
        return employeeMasterDao.readByfullname(employee_code);
    }

    @Override
    public EmployeeMaster readByEmployeeName(String user1) {
        return employeeMasterDao.readByEmployeeName(user1);
    }

    @Override
    public List readByDepartName(String departName) {
        return employeeMasterDao.readByDepartName(departName);
    }

    @Override
    public List readByRightsName(String rigName) {
        return employeeMasterDao.readByRightsName(rigName);
    }

    @Override
    public List getEmployeeMasterPagination(int start, int length, String searchValue, String orderColumn, String orderDir) {
        return employeeMasterDao.getEmployeeMasterPagination(start, length, searchValue, orderColumn, orderDir);
    }

    @Override
    public int getTotalEmployeeMasterCount() {
        return employeeMasterDao.getTotalEmployeeMasterCount();
    }

    @Override
    public int getFilteredEmployeeMasterCount(String searchValue) {
        return employeeMasterDao.getFilteredEmployeeMasterCount(searchValue);
    }

   

}
