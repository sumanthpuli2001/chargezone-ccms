/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.policy;

import com.bul.zydex.model.EmployeeCtcDetail;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Hussain
 */
public interface EmployeeCtcDetailService<T> extends GenericsService<T> {

    public List<?> fetchctcData(int empId);

    public List<?> readctc(int employeeid);

    public List<?> readEmployeeCtcDetail(int employeeid);

    public List<?> readByEmployeCtcReport(int employeeid, String month, String year);

    public List<?> empid(int employeeid);
    public List<?> CtcDetailempid(int employeeid);
    public List<?> readctcRegistration(int employeeid);

}
