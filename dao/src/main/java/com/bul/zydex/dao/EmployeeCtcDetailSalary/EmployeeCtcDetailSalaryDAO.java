/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.EmployeeCtcDetailSalary;

import com.bul.zydex.dao.GenericsDAO;
import java.util.List;

/**
 *
 * @author Hussain
 */
public interface EmployeeCtcDetailSalaryDAO<T> extends GenericsDAO<T> {

    public List<?> readEmployeeCtcDetailSalary(int employeeid, String month, String year, int ctcid);

     public List<?> readByEmployeCtcReport(int employeeid, String month, String year);
}
