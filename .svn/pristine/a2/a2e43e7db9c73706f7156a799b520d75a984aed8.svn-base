/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.empreferral;

import com.bul.zydex.dao.empreferral.EmployeeReferralDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Irfan
 */
public class EmployeeReferralServiceImpl<T> extends GenericsServiceImpl<T> implements EmployeeReferralService<T> {

    private EmployeeReferralDAO<T> employeeReferralDAO;

    public EmployeeReferralDAO<T> getEmployeeReferralDAO() {
        return employeeReferralDAO;
    }

    public void setEmployeeReferralDAO(EmployeeReferralDAO<T> employeeReferralDAO) {
        this.employeeReferralDAO = employeeReferralDAO;
        setGenericsDAO(employeeReferralDAO);
    }

    @Override
    public boolean isExist(T object) {
        return employeeReferralDAO.isExist(object);
    }

    @Override
    public List<?> readEmpForReferral(T object) {
        return employeeReferralDAO.readEmpForReferral(object);
    }

    @Override
    public int updateEmployeeReferralById(final T object) {
        return employeeReferralDAO.updateEmployeeReferralById(object);
    }

    @Override
    public List<?> getReportingManagerOfEmpRefAdmin() {

        return employeeReferralDAO.getReportingManagerOfEmpRefAdmin();
    }

}
