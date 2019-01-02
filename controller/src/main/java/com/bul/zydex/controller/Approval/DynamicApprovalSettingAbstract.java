/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Approval;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.Company;
import com.bul.zydex.model.DepartmentMaster;
import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.model.DynamicApprovalSetting;
import com.bul.zydex.model.DynamicApprovalSettingApprover;
import com.bul.zydex.model.DynamicApprovalSettingEmail;
import com.bul.zydex.model.LocationMaster;
import com.bul.zydex.model.Modules;
import com.bul.zydex.model.ProjectManagementMaster;
import com.bul.zydex.model.ZydexLocationMaster;
import com.bul.zydex.service.Approval.DynamicApprovalSettingApproverService;
import com.bul.zydex.service.Approval.DynamicApprovalSettingEmailService;
import com.bul.zydex.service.Approval.DynamicApprovalSettingService;
import com.bul.zydex.service.ModulesService;
import com.bul.zydex.service.ProjectManagement.ProjectManagementService;
import com.bul.zydex.service.company.CompanyMasterService;
import com.bul.zydex.service.emp.DepartmentMasterService;
import com.bul.zydex.service.emp.DesignationMasterService;
import com.bul.zydex.service.location.LocationMasterService;
import com.bul.zydex.service.zydexLocation.ZydexLocationMasterService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpRequest;

/**
 *
 * @author Admin
 */
public class DynamicApprovalSettingAbstract extends CustomAbstract {

    protected DynamicApprovalSettingService<DynamicApprovalSetting> dynamicApprovalSettingService;
    protected DynamicApprovalSettingApproverService<DynamicApprovalSettingApprover> dynamicApprovalSettingApproverService;
    protected DynamicApprovalSettingEmailService<DynamicApprovalSettingEmail> dynamicApprovalSettingEmailService;
    protected ModulesService<Modules> modulesService;
    protected CompanyMasterService<Company> companyMasterService;
    protected ZydexLocationMasterService<ZydexLocationMaster> zydexLocationMasterService;
    protected DesignationMasterService<DesignationMaster> designationMasterService;
    protected ProjectManagementService<ProjectManagementMaster> projectManagementService;
//    protected DepartmentMasterService<DepartmentMaster> departmentMasterService;
    protected LocationMasterService<LocationMaster> locationMasterService;

    public DynamicApprovalSettingService<DynamicApprovalSetting> getDynamicApprovalSettingService() {
        return dynamicApprovalSettingService;
    }

    public void setDynamicApprovalSettingService(DynamicApprovalSettingService<DynamicApprovalSetting> dynamicApprovalSettingService) {
        this.dynamicApprovalSettingService = dynamicApprovalSettingService;
    }

    public DynamicApprovalSettingApproverService<DynamicApprovalSettingApprover> getDynamicApprovalSettingApproverService() {
        return dynamicApprovalSettingApproverService;
    }

    public void setDynamicApprovalSettingApproverService(DynamicApprovalSettingApproverService<DynamicApprovalSettingApprover> dynamicApprovalSettingApproverService) {
        this.dynamicApprovalSettingApproverService = dynamicApprovalSettingApproverService;
    }

    public DynamicApprovalSettingEmailService<DynamicApprovalSettingEmail> getDynamicApprovalSettingEmailService() {
        return dynamicApprovalSettingEmailService;
    }

    public void setDynamicApprovalSettingEmailService(DynamicApprovalSettingEmailService<DynamicApprovalSettingEmail> dynamicApprovalSettingEmailService) {
        this.dynamicApprovalSettingEmailService = dynamicApprovalSettingEmailService;
    }

    public ModulesService<Modules> getModulesService() {
        return modulesService;
    }

    public void setModulesService(ModulesService<Modules> modulesService) {
        this.modulesService = modulesService;
    }

    public CompanyMasterService<Company> getCompanyMasterService() {
        return companyMasterService;
    }

    public void setCompanyMasterService(CompanyMasterService<Company> companyMasterService) {
        this.companyMasterService = companyMasterService;
    }

    public ZydexLocationMasterService<ZydexLocationMaster> getZydexLocationMasterService() {
        return zydexLocationMasterService;
    }

    public void setZydexLocationMasterService(ZydexLocationMasterService<ZydexLocationMaster> zydexLocationMasterService) {
        this.zydexLocationMasterService = zydexLocationMasterService;
    }

    public DesignationMasterService<DesignationMaster> getDesignationMasterService() {
        return designationMasterService;
    }

    public void setDesignationMasterService(DesignationMasterService<DesignationMaster> designationMasterService) {
        this.designationMasterService = designationMasterService;
    }

    public ProjectManagementService<ProjectManagementMaster> getProjectManagementService() {
        return projectManagementService;
    }

    public void setProjectManagementService(ProjectManagementService<ProjectManagementMaster> projectManagementService) {
        this.projectManagementService = projectManagementService;
    }

    public LocationMasterService<LocationMaster> getLocationMasterService() {
        return locationMasterService;
    }

    public void setLocationMasterService(LocationMasterService<LocationMaster> locationMasterService) {
        this.locationMasterService = locationMasterService;
    }

    protected void mouleList(HttpServletRequest request) {

        Modules module = new Modules();
        List<?> moduleList = modulesService.read();
        Map<Integer, String> dm = new HashMap<>();
        for (Object o : moduleList) {
            module = (Modules) o;
            dm.put(module.getId(), module.getModuleName());
        }

        request.setAttribute("mouleList", dm);
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

//    protected void locationList(HttpServletRequest request) {
//
//        ZydexLocationMaster zydexLocationMaster = new ZydexLocationMaster();
//        List<?> locationList = zydexLocationMasterService.read();
//        Map<Integer, String> zl = new HashMap<>();
//        for (Object o : locationList) {
//            zydexLocationMaster = (ZydexLocationMaster) o;
//            zl.put(zydexLocationMaster.getId(), zydexLocationMaster.getZydexLocation());
//        }
//
//        request.setAttribute("locationList", zl);
//    }
    protected void designationList(HttpServletRequest request) {

        DesignationMaster designationMaster = new DesignationMaster();
        List<?> designationList = designationMasterService.read();
        Map<Integer, String> dl = new HashMap<>();
        for (Object o : designationList) {
            designationMaster = (DesignationMaster) o;
            dl.put(designationMaster.getId(), designationMaster.getDesignationName());
        }

        request.setAttribute("designationList", dl);
    }

    protected void locationList(HttpServletRequest request) {
        LocationMaster locationMaster = new LocationMaster();
        List<?> location = locationMasterService.read();

        Map<Integer, String> location1 = new HashMap<>();
        for (Object o : location) {
            locationMaster = (LocationMaster) o;
            location1.put(locationMaster.getId(), locationMaster.getLocation());
        }
        request.setAttribute("locationList", location1);
    }

    protected void departmentList(HttpServletRequest request) {
        DepartmentMaster departmentMaster = new DepartmentMaster();
        List<?> depttList = departmentMasterService.read();
        Map<Integer, String> dm = new HashMap<>();
        for (Object o : depttList) {
            departmentMaster = (DepartmentMaster) o;
            dm.put(departmentMaster.getId(), departmentMaster.getDepartmentName());
        }

        request.setAttribute("designationList", dm);
    }
}
