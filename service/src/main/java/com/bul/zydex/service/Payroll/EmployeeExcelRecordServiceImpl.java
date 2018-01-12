/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Payroll;

import com.bul.zydex.dao.Payroll.EmployeeExcelRecordDAO;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.EmployeeSalaryProcess;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Hussain
 */
public class EmployeeExcelRecordServiceImpl<T> extends GenericsServiceImpl<T> implements EmployeeExcelRecordService<T> {

    private EmployeeExcelRecordDAO<T> employeeExcelRecordDAO;

    public EmployeeExcelRecordDAO<T> getEmployeeExcelRecordDAO() {
        return employeeExcelRecordDAO;
    }

    public void setEmployeeExcelRecordDAO(EmployeeExcelRecordDAO<T> employeeExcelRecordDAO) {
        this.employeeExcelRecordDAO = employeeExcelRecordDAO;
        setGenericsDAO(employeeExcelRecordDAO);
    }

    @Override
    public List<?> readByEmployeExcelReport(EmployeeSalaryProcess employeeSalaryProcess) {
        return employeeExcelRecordDAO.readByEmployeExcelReport(employeeSalaryProcess);
    }

    @Override
    public List<?> readAttendanceRecord(EmployeeMaster employeeMaster) {
        return employeeExcelRecordDAO.readAttendanceRecord(employeeMaster);
    }

    @Override
    public void delete1(T object) {
        employeeExcelRecordDAO.delete1(object);
    }

    @Override
    public List<?> readEmployeeForIncentive(String pincentive, String aincentive, String month1, String year11) {
        return employeeExcelRecordDAO.readEmployeeForIncentive(pincentive, aincentive, month1, year11);
    }

    @Override
    public List<?> readByEmployeExcelReportSearch(EmployeeSalaryProcess employeeSalaryProcess) {
    return employeeExcelRecordDAO.readByEmployeExcelReportSearch(employeeSalaryProcess);
    }

}
