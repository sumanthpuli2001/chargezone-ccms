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

}
