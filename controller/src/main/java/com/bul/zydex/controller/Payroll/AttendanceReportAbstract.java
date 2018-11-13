/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.Company;
import com.bul.zydex.model.EmployeeExcelRecord;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.EmployeeSalaryProcess;
import com.bul.zydex.model.EmployeeSubType;
import com.bul.zydex.model.EmployeeType;
import com.bul.zydex.model.EmployeeTypeMaster;
import com.bul.zydex.model.LocationMaster;
import com.bul.zydex.service.Payroll.EmployeeExcelRecordService;
import com.bul.zydex.service.Payroll.EmployeeSalaryProcessService;
import com.bul.zydex.service.company.CompanyMasterService;
import com.bul.zydex.service.emp.EmployeeMasterService;
import com.bul.zydex.service.emp.EmployeeSubTypeService;
import com.bul.zydex.service.emp.EmployeeTypeService;
import com.bul.zydex.service.location.LocationMasterService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author OptiPlex
 */
public abstract class AttendanceReportAbstract extends CustomAbstract {

    protected EmployeeMasterService<EmployeeMaster> employeeMasterService;

    protected EmployeeSalaryProcessService<EmployeeSalaryProcess> employeeSalaryProcessService;

    protected EmployeeSubTypeService<EmployeeSubType> employeeSubTypeService;

    protected EmployeeTypeService<EmployeeTypeMaster> employeeTypeService;

    protected EmployeeExcelRecordService<EmployeeExcelRecord> employeeExcelRecordService;
    protected CompanyMasterService<Company> companyMasterService;
    protected LocationMasterService<LocationMaster> locationMasterService;

    public EmployeeMasterService<EmployeeMaster> getEmployeeMasterService() {
        return employeeMasterService;
    }

    public void setEmployeeMasterService(EmployeeMasterService<EmployeeMaster> employeeMasterService) {
        this.employeeMasterService = employeeMasterService;
    }

    public EmployeeTypeService<EmployeeTypeMaster> getEmployeeTypeService() {
        return employeeTypeService;
    }

    public void setEmployeeTypeService(EmployeeTypeService<EmployeeTypeMaster> employeeTypeService) {
        this.employeeTypeService = employeeTypeService;
    }

    public EmployeeSubTypeService<EmployeeSubType> getEmployeeSubTypeService() {
        return employeeSubTypeService;
    }

    public void setEmployeeSubTypeService(EmployeeSubTypeService<EmployeeSubType> employeeSubTypeService) {
        this.employeeSubTypeService = employeeSubTypeService;
    }

    public EmployeeSalaryProcessService<EmployeeSalaryProcess> getEmployeeSalaryProcessService() {
        return employeeSalaryProcessService;
    }

    public void setEmployeeSalaryProcessService(EmployeeSalaryProcessService<EmployeeSalaryProcess> employeeSalaryProcessService) {
        this.employeeSalaryProcessService = employeeSalaryProcessService;
    }

    public EmployeeExcelRecordService<EmployeeExcelRecord> getEmployeeExcelRecordService() {
        return employeeExcelRecordService;
    }

    public void setEmployeeExcelRecordService(EmployeeExcelRecordService<EmployeeExcelRecord> employeeExcelRecordService) {
        this.employeeExcelRecordService = employeeExcelRecordService;
    }

    protected void EmployeeTypeList(HttpServletRequest request) {
        List<?> EmployeeTypeList = employeeTypeService.read();
        Map<Integer, String> map = new HashMap();
        for (Object obj : EmployeeTypeList) {
            EmployeeTypeMaster employeeTypeMaster = (EmployeeTypeMaster) obj;
            map.put(employeeTypeMaster.getId(), employeeTypeMaster.getTypeOfEmployee());
        }
        request.setAttribute("EmployeeTypeList", map);
    }

    protected void EmployeeSubTypeList(HttpServletRequest request) {
        List<?> EmployeeSubTypeList = employeeSubTypeService.read();
        Map<Integer, String> map = new HashMap();
        for (Object obj : EmployeeSubTypeList) {
            EmployeeSubType employeeSubType = (EmployeeSubType) obj;
            map.put(employeeSubType.getId(), employeeSubType.getSubType());
        }
        request.setAttribute("EmployeeSubTypeList", map);
    }

    protected void companyList(HttpServletRequest request) {

        Company company = new Company();
        List<?> companyList = companyMasterService.read();
        Map<Integer, String> dm = new HashMap<>();
        for (Object o : companyList) {
            company = (Company) o;
            dm.put(company.getCompanyId(), company.getCompanyName());
        }

        request.setAttribute("companyList", dm);
    }

    protected void locationList(HttpServletRequest request) {
        LocationMaster locationMaster = new LocationMaster();
        List<?> location = locationMasterService.read();

        Map<Integer, String> location1 = new HashMap<>();
        for (Object o : location) {
            locationMaster = (LocationMaster) o;
            location1.put(locationMaster.getId(), locationMaster.getLocation());
        }
        request.setAttribute("location", location1);
    }

    public CompanyMasterService<Company> getCompanyMasterService() {
        return companyMasterService;
    }

    public void setCompanyMasterService(CompanyMasterService<Company> companyMasterService) {
        this.companyMasterService = companyMasterService;
    }

    public LocationMasterService<LocationMaster> getLocationMasterService() {
        return locationMasterService;
    }

    public void setLocationMasterService(LocationMasterService<LocationMaster> locationMasterService) {
        this.locationMasterService = locationMasterService;
    }
    

}
