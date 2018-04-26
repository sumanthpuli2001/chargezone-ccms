/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.policy;

import com.bul.zydex.dao.GenericsDAO;
import java.util.List;

/**
 *
 * @author Hussain
 */
public interface EmployeeCtcDetailDAO<T> extends GenericsDAO<T> {

    public List<?> fetchctcData(int empId);

    public List<?> readctc(int employeeid);

    public List<?> readEmployeeCtcDetail(int employeeid);

    public List<?> readByEmployeCtcReport(int employeeid, String month, String year);

    public List<?> readctcRegistration(int employeeid);

    public List<?> empid(int employeeid);

    public List<?> CtcDetailempid(int employeeid);
}
