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
public interface EmployeeExcelRecordService<T> extends GenericsService<T> {

    public List<?> readByEmployeExcelReport(EmployeeSalaryProcess employeeSalaryProcess);

    public List<?> readAttendanceRecord(EmployeeMaster employeeMaster);

    public void delete1(T object);

    public List<?> readEmployeeForIncentive(String pincentive, String aincentive, String month1, String year11);

    public List<?> readByEmployeExcelReportSearch(EmployeeSalaryProcess employeeSalaryProcess);
}
