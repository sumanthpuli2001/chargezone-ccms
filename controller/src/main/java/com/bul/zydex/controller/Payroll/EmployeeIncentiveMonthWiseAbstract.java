/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.EmployeeExcelRecord;
import com.bul.zydex.model.EmployeeIncentiveMonthwise;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.EmployeePayrollIncentive;
import com.bul.zydex.model.EmployeeSalaryProcess;
import com.bul.zydex.model.EmployeeSubType;
import com.bul.zydex.model.EmployeeTypeMaster;
import com.bul.zydex.service.Payroll.EmployeeExcelRecordService;
import com.bul.zydex.service.Payroll.EmployeeIncentiveMonthwiseService;
import com.bul.zydex.service.Payroll.EmployeePayrollIncentiveService;
import com.bul.zydex.service.Payroll.EmployeeSalaryProcessService;
import com.bul.zydex.service.emp.EmployeeMasterService;
import com.bul.zydex.service.emp.EmployeeSubTypeService;
import com.bul.zydex.service.emp.EmployeeTypeService;

/**
 *
 * @author Hussain
 */
public class EmployeeIncentiveMonthWiseAbstract extends CustomAbstract {

    protected EmployeeMasterService<EmployeeMaster> employeeMasterService;

    protected EmployeeSalaryProcessService<EmployeeSalaryProcess> employeeSalaryProcessService;

    protected EmployeeSubTypeService<EmployeeSubType> employeeSubTypeService;

    protected EmployeeTypeService<EmployeeTypeMaster> employeeTypeService;

    protected EmployeeExcelRecordService<EmployeeExcelRecord> employeeExcelRecordService;
    protected EmployeePayrollIncentiveService<EmployeePayrollIncentive> employeePayrollIncentiveService;
    protected EmployeeIncentiveMonthwiseService<EmployeeIncentiveMonthwise> employeeIncentiveMonthwiseService;

    public EmployeeSalaryProcessService<EmployeeSalaryProcess> getEmployeeSalaryProcessService() {
        return employeeSalaryProcessService;
    }

    public void setEmployeeSalaryProcessService(EmployeeSalaryProcessService<EmployeeSalaryProcess> employeeSalaryProcessService) {
        this.employeeSalaryProcessService = employeeSalaryProcessService;
    }

    public EmployeeSubTypeService<EmployeeSubType> getEmployeeSubTypeService() {
        return employeeSubTypeService;
    }

    public void setEmployeeSubTypeService(EmployeeSubTypeService<EmployeeSubType> employeeSubTypeService) {
        this.employeeSubTypeService = employeeSubTypeService;
    }

    public EmployeeTypeService<EmployeeTypeMaster> getEmployeeTypeService() {
        return employeeTypeService;
    }

    public void setEmployeeTypeService(EmployeeTypeService<EmployeeTypeMaster> employeeTypeService) {
        this.employeeTypeService = employeeTypeService;
    }

    public EmployeeExcelRecordService<EmployeeExcelRecord> getEmployeeExcelRecordService() {
        return employeeExcelRecordService;
    }

    public void setEmployeeExcelRecordService(EmployeeExcelRecordService<EmployeeExcelRecord> employeeExcelRecordService) {
        this.employeeExcelRecordService = employeeExcelRecordService;
    }

    public EmployeePayrollIncentiveService<EmployeePayrollIncentive> getEmployeePayrollIncentiveService() {
        return employeePayrollIncentiveService;
    }

    public void setEmployeePayrollIncentiveService(EmployeePayrollIncentiveService<EmployeePayrollIncentive> employeePayrollIncentiveService) {
        this.employeePayrollIncentiveService = employeePayrollIncentiveService;
    }

    public EmployeeIncentiveMonthwiseService<EmployeeIncentiveMonthwise> getEmployeeIncentiveMonthwiseService() {
        return employeeIncentiveMonthwiseService;
    }

    public void setEmployeeIncentiveMonthwiseService(EmployeeIncentiveMonthwiseService<EmployeeIncentiveMonthwise> employeeIncentiveMonthwiseService) {
        this.employeeIncentiveMonthwiseService = employeeIncentiveMonthwiseService;
    }
    

}
