/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Payroll;

import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.EmployeeSalaryProcess;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Hussain
 */
public interface PayrollPfRecordService<T> extends GenericsService<T> {

    public List<?> readByEmployePfReport(EmployeeSalaryProcess employeeSalaryProcess);

    public List<?> readEmployeePayrolllPfRecord(int employeeSalaryProcessId);

    public List<?> readEmployeeForPf(EmployeeMaster object);
}
