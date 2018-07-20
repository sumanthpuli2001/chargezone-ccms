/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Approval;

import com.bul.zydex.model.Company;
import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.model.DynamicApprovalSetting;
import com.bul.zydex.model.DynamicApprovalSettingApprover;
import com.bul.zydex.model.DynamicApprovalSettingEmail;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.Modules;
import com.bul.zydex.model.ProjectManagementMaster;
import com.bul.zydex.model.ZydexLocationMaster;
import com.bul.zydex.model.support.DynamicApprovalSettingSupport;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.json.Json;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Admin
 */
public class DynamicApprovalSettingController extends DynamicApprovalSettingAbstract {

    public ModelAndView viewDynamicCycle(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        Company company = new Company();
        ZydexLocationMaster zydexLocationMaster = new ZydexLocationMaster();
        DesignationMaster designationMaster = new DesignationMaster();
        Modules modules = new Modules();
        List al = new ArrayList();
        List<DynamicApprovalSetting> dynamicCycleList = (List<DynamicApprovalSetting>) dynamicApprovalSettingService.read();
        for (DynamicApprovalSetting approvalSetting : dynamicCycleList) {
            DynamicApprovalSetting dynamicApprovalSetting = new DynamicApprovalSetting();
            List<DynamicApprovalSetting> arrayList = new ArrayList<DynamicApprovalSetting>();
            company = companyMasterService.readById(approvalSetting.getCompany().getCompanyId());
            zydexLocationMaster = zydexLocationMasterService.readById(approvalSetting.getZydexLocationMaster().getId());
            modules = modulesService.readById(approvalSetting.getModules().getId());
            designationMaster = designationMasterService.readById(approvalSetting.getDesignationMaster().getId());
            dynamicApprovalSetting.setCompany(company);
            dynamicApprovalSetting.setModules(modules);
            dynamicApprovalSetting.setDesignationMaster(designationMaster);
            dynamicApprovalSetting.setZydexLocationMaster(zydexLocationMaster);
            dynamicApprovalSetting.setId(approvalSetting.getId());
//            arrayList.add(dynamicApprovalSetting);
            al.add(dynamicApprovalSetting);

        }
        request.setAttribute("list", al);
        mv.setViewName("Approval/ViewDynamicCycle");
        return mv;
    }

    public ModelAndView createClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        DynamicApprovalSetting dynamicApprovalSetting = new DynamicApprovalSetting();
        DynamicApprovalSettingSupport dynamicApprovalSettingSupport = new DynamicApprovalSettingSupport();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        BindException errors = new BindException(dynamicApprovalSettingSupport, "dynamicApprovalSettingSupport");
        bind(request, dynamicApprovalSettingSupport);
        mouleList(request);
        locationList(request);
        designationList(request);
        companyList(request);
        selectEmployee(request, response);
        selectedEmployeeFor360Feedback(request, employeeMaster);
        mv.getModelMap().put("dynamicApprovalSettingSupport", dynamicApprovalSettingSupport);
        mv.setViewName("Approval/CreateDynamicApprovalCycle");
        return mv;

    }

    public void selectProjectName(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer projectId = Integer.parseInt(request.getParameter("moduleID"));
        ProjectManagementMaster projectManagementMaster = new ProjectManagementMaster();
        if (projectId == 11) {
            List<?> list = projectManagementService.read();
            Map<Integer, String> pm = new HashMap<>();
            for (Object o : list) {
                projectManagementMaster = (ProjectManagementMaster) o;
                pm.put(projectManagementMaster.getId(), projectManagementMaster.getName());
            }
            JSONObject jObject = new JSONObject();
            jObject.put("projectNameKey", pm);
            PrintWriter out = response.getWriter();
            out.println(jObject.toString());

        }
    }

    public ModelAndView submitDynamicApproval(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        DynamicApprovalSetting dynamicApprovalSetting = new DynamicApprovalSetting();
        EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        int id = Integer.parseInt(request.getParameter("id"));
        int projectName;
        int moduleId = Integer.parseInt(request.getParameter("moduleId"));
        int companyId = Integer.parseInt(request.getParameter("companyId"));
        int locationId = Integer.parseInt(request.getParameter("zydexLocationMasterId"));
        int designationMasterId = Integer.parseInt(request.getParameter("designationMasterId"));
        if (request.getParameter("projectName") == null) {
            projectName = 0;
        } else {
            projectName = Integer.parseInt(request.getParameter("projectName"));
        }
        String[] approverId1 = request.getParameterValues("approverId");
        String[] approverId = approverId1[0].split(",");

        String[] emailerId1 = request.getParameterValues("emailUserId");
        String[] emailerId = emailerId1[0].split(",");

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();

        Company company = companyMasterService.readById(companyId);
        ZydexLocationMaster zydexLocationMaster = zydexLocationMasterService.readById(locationId);
        Modules modules = modulesService.readById(moduleId);
        DesignationMaster designationMaster = designationMasterService.readById(designationMasterId);

        if (0 != id) {
            dynamicApprovalSetting = dynamicApprovalSettingService.readById(id);
            dynamicApprovalSetting.setCompany(company);
            dynamicApprovalSetting.setDesignationMaster(designationMaster);
            dynamicApprovalSetting.setModules(modules);
            dynamicApprovalSetting.setZydexLocationMaster(zydexLocationMaster);
            dynamicApprovalSetting.setUpdatedBy(employeeMasterModel.getId());
            dynamicApprovalSetting.setUpdatedDate(sdf.format(date));
            dynamicApprovalSetting.setProjectName(projectName);
            dynamicApprovalSettingService.update(dynamicApprovalSetting);
        } else {
            dynamicApprovalSetting.setCompany(company);
            dynamicApprovalSetting.setDesignationMaster(designationMaster);
            dynamicApprovalSetting.setModules(modules);
            dynamicApprovalSetting.setZydexLocationMaster(zydexLocationMaster);
            dynamicApprovalSetting.setCreatedBy(employeeMasterModel.getId());
            dynamicApprovalSetting.setCreatedDate(sdf.format(date));
            dynamicApprovalSetting.setProjectName(projectName);
            dynamicApprovalSettingService.create(dynamicApprovalSetting);
        }

        for (int i = 0; i < approverId.length; i++) {
            DynamicApprovalSettingApprover dynamicApprovalSettingApprover = new DynamicApprovalSettingApprover();
            if (!approverId[i].equals("")) {
                EmployeeMaster em = employeeMasterService.readById(Integer.parseInt(approverId[i]));
                dynamicApprovalSettingApprover.setApproverName(em.getEmployeeName());
                dynamicApprovalSettingApprover.setDynamicApprovalSettingId(dynamicApprovalSetting);
                dynamicApprovalSettingApprover.setEmployeeMaster(em);
                dynamicApprovalSettingApproverService.create(dynamicApprovalSettingApprover);
            }
        }
        for (int i = 0; i < emailerId.length; i++) {
            DynamicApprovalSettingEmail dynamicApprovalSettingEmail = new DynamicApprovalSettingEmail();
            if (!emailerId[i].equals("")) {
                EmployeeMaster employeeMaster1 = employeeMasterService.readById(Integer.parseInt(emailerId[i]));
                dynamicApprovalSettingEmail.setApproverName(employeeMaster1.getEmployeeName());
                dynamicApprovalSettingEmail.setEmailId(employeeMaster1.getEmailAddress());
                dynamicApprovalSettingEmail.setEmployeeMaster(employeeMaster1);
                dynamicApprovalSettingEmail.setDynamicApprovalSettingId(dynamicApprovalSetting);

                dynamicApprovalSettingEmailService.create(dynamicApprovalSettingEmail);
            }

            request.setAttribute("successMessage",
                    "Information : The Information is saved Successfully.");

        }
        mv.setViewName("forward:dynamicApprovalSetting.htm?act=viewDynamicCycle");

        return mv;

    }

    public ModelAndView deleteDynamicCycleSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String tabId[] = request.getParameterValues("checkId");
        for (String z : tabId) {
            try {

                List<DynamicApprovalSettingApprover> approversList = (List<DynamicApprovalSettingApprover>) dynamicApprovalSettingApproverService.readByDnamicApprovalSettingId(Integer.parseInt(z));
                for (DynamicApprovalSettingApprover approver : approversList) {
                    dynamicApprovalSettingApproverService.delete(approver.getId());
                }

                List<DynamicApprovalSettingEmail> dases = (List<DynamicApprovalSettingEmail>) dynamicApprovalSettingEmailService.readByDnamicApprovalSettingId(Integer.parseInt(z));
                for (DynamicApprovalSettingEmail dase : dases) {
                    dynamicApprovalSettingEmailService.delete(dase.getId());
                }

                dynamicApprovalSettingService.delete(Integer.parseInt(z));
                request.setAttribute("successMessage",
                        "Info : One or more records are deleted successfully.");
            } catch (Exception e) {

            }
        }
        mv = viewDynamicCycle(request, response);

        return mv;
    }

    public ModelAndView viewClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        int id = Integer.parseInt(request.getParameter("id"));
        DynamicApprovalSettingSupport dass = new DynamicApprovalSettingSupport();
        DynamicApprovalSetting dynamicApprovalSetting = dynamicApprovalSettingService.readById(id);
        DynamicApprovalSettingApprover dynamicApprovalSettingApprover = new DynamicApprovalSettingApprover();
        DynamicApprovalSettingEmail dynamicApprovalSettingEmail = new DynamicApprovalSettingEmail();
        List approverList = new ArrayList();
        List emailList = new ArrayList();
        dass.setId(id);
        dass.setCompanyId(dynamicApprovalSetting.getCompany().getCompanyId());
        EmployeeMaster employeeMaster = new EmployeeMaster();
        dass.setDesignationMasterId(dynamicApprovalSetting.getDesignationMaster().getId());
        dass.setZydexLocationMasterId(dynamicApprovalSetting.getZydexLocationMaster().getId());
        dass.setModuleId(dynamicApprovalSetting.getModules().getId());
        dass.setProjectId(dynamicApprovalSetting.getProjectName());
        List<?> projectList = projectManagementService.read();
        List<DynamicApprovalSettingApprover> list = (List<DynamicApprovalSettingApprover>) dynamicApprovalSettingApproverService.readByDnamicApprovalSettingId(id);
        for (DynamicApprovalSettingApprover settingApprover : list) {
            List appList = new ArrayList();
            appList.add(settingApprover.getId());
            appList.add(settingApprover.getApproverName());
            approverList.add(appList);

        }
        List<DynamicApprovalSettingEmail> emails = (List<DynamicApprovalSettingEmail>) dynamicApprovalSettingEmailService.readByDnamicApprovalSettingId(id);

        for (DynamicApprovalSettingEmail eml : emails) {
            List emlList = new ArrayList();
            emlList.add(eml.getId());
            emlList.add(eml.getApproverName());
            emailList.add(emlList);
        }

        mouleList(request);
        locationList(request);
        designationList(request);
        companyList(request);
        selectEmployee(request, response);
        selectedEmployeeFor360Feedback(request, employeeMaster);
        request.setAttribute("approverList", approverList);
        request.setAttribute("emailList", emailList);
        request.setAttribute("projectList", projectList);
        mv.getModelMap().put("dynamicApprovalSettingSupport", dass);
        mv.setViewName("Approval/editDynamicApprovalCycle");
//        List<DynamicApprovalSettingApprover>  approvers = (List<DynamicApprovalSettingApprover>) dynamicApprovalSettingApproverService.readByApproverId(id);
//        for(DynamicApprovalSettingApprover dasa : approvers){
//        }

        return mv;
    }

    public ModelAndView deleteApproverClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        int id = Integer.parseInt(request.getParameter("id"));
        try {
            int ApproverId = Integer.parseInt(request.getParameter("ApproverId"));
            dynamicApprovalSettingApproverService.delete(ApproverId);
            request.setAttribute("successMessage",
                    "Info : One or more records are deleted successfully.");
        } catch (Exception e) {

        }
        mv.setViewName("forward:dynamicApprovalSetting.htm?act=viewClick&id=" + id);

        return mv;
    }

    public ModelAndView deleteEmilClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        int id = Integer.parseInt(request.getParameter("id"));

        try {
            int emailId = Integer.parseInt(request.getParameter("emailID"));

            dynamicApprovalSettingEmailService.delete(emailId);
            request.setAttribute("successMessage",
                    "Info : One or more records are deleted successfully.");
        } catch (Exception e) {

        }
        mv.setViewName("forward:dynamicApprovalSetting.htm?act=viewClick&id=" + id);

        return mv;
    }

}
