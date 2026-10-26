/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Employee;

import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.LogsMaster;
import com.bul.zydex.model.UserMaster;
import com.bul.zydex.model.UserRights;
import com.bul.zydex.model.RightMaster;
import com.bul.zydex.model.CompanyLocation;
import com.bul.zydex.model.DepartmentMaster;
import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.model.EmailTemplate;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Aman Bahukhandi
 */
public class EmployeeMasterController extends EmployeeMasterAbstract {

    public ModelAndView showList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);

        if (session != null) {
            String successMessage = (String) session.getAttribute("successMessage");
            if (successMessage != null) {
                mv.addObject("successMessage", successMessage);
                session.removeAttribute("successMessage");
            }

            String failureMessage = (String) session.getAttribute("failureMessage");
            if (failureMessage != null) {
                mv.addObject("failureMessage", failureMessage);
                session.removeAttribute("failureMessage");
            }
        }

        mv.setViewName("Employee/EmployeeListList");
        return mv;
    }

    public ModelAndView employeeMasterAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().equals("")) {
            orderDir = "desc";
        }

        String orderColumn = "id";
        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "2":
                    orderColumn = "employeeCode";
                    break;
                case "3":
                    orderColumn = "name";
                    break;
                case "4":
                    orderColumn = "emailId";
                    break;
                case "5":
                    orderColumn = "department";
                    break;
                case "6":
                    orderColumn = "designation";
                    break;
                case "7":
                    orderColumn = "rightsName";
                    break;
                default:
                    orderColumn = "id";
                    break;
            }
        }

        List list = employeeMasterService.getEmployeeMasterPagination(start, length, searchValue, orderColumn, orderDir);
        int totalRecords = employeeMasterService.getTotalEmployeeMasterCount();
        int filteredRecords = employeeMasterService.getFilteredEmployeeMasterCount(searchValue);
        JSONArray dataArray = new JSONArray();

        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo;

        if (isDesc) {
            srNo = filteredRecords - start;
        } else {
            srNo = start + 1;
        }

        for (Object obj : list) {

            EmployeeMaster employeeMaster = (EmployeeMaster) obj;
            JSONObject json = new JSONObject();

            json.put("checkbox", "<input type='checkbox' " + "class='rowCheckbox' " + "value='" + employeeMaster.getEmployeeCode() + "'>");

            if (isDesc) {
                json.put("srNo", srNo--);
            } else {
                json.put("srNo", srNo++);
            }

            json.put("employeeCode", employeeMaster.getEmployeeCode());
            json.put("name", employeeMaster.getName());
            json.put("emailId", employeeMaster.getEmailId());
            json.put("department", employeeMaster.getDepartment());
            json.put("designation", employeeMaster.getDesignation());
            json.put("rightsName", employeeMaster.getRightsName());
            json.put("action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + "<a href='employeeMaster.htm?act=viewClick&id="
                    + employeeMaster.getEmployeeCode()
                    + "' class='d-block text-info p-1 mx-1'>"
                    + "<img src=\"StorageYard/assets/images/edit-icon.svg\" "
                    + "style='width:18px;height:18px;'>"
                    + "</a>"
                    + "<a href='javascript:void(0);' "
                    + "class='delete-btn1 d-block text-danger p-1 mx-1' "
                    + "data-id='" + employeeMaster.getEmployeeCode() + "'>"
                    + "<img src=\"StorageYard/assets/images/delete-icon.svg\" "
                    + "style='width:18px;height:18px;'>"
                    + "</a>"
                    + "</div>"
            );
            dataArray.put(json);
        }

        JSONObject responseJson = new JSONObject();
        responseJson.put("draw", draw);
        responseJson.put("recordsTotal", totalRecords);
        responseJson.put("recordsFiltered", filteredRecords);
        responseJson.put("data", dataArray);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(responseJson.toString());

        return null;
    }

    public ModelAndView showBackupList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        List list = employeeMasterService.readByDrowDisable();
        request.setAttribute("list", list);
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.setViewName("Employee/EmployeeDisableList");
        return mv;
    }

    public ModelAndView createEmployeeMaster(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = new EmployeeMaster();

        List companyLocation = companyLocationService.read();
        List departmentMaster = departmentMasterService.read();
        List designationMaster = designationMasterService.read();

        mv.getModelMap().put("companyLocation", companyLocation);
        mv.getModelMap().put("departmentMaster", departmentMaster);
        mv.getModelMap().put("designationMaster", designationMaster);

        readRights(request, response);
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.setViewName("Employee/EmployeeCreate");
        return mv;
    }

    public ModelAndView submitEmployeeMaster(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        bind(request, employeeMaster);
        String emailId = request.getParameter("emailId");
        String employeeCode = request.getParameter("employeeCode");
        String issueDept = "Y";
        String issueGuest = "Y";
        employeeMaster.setEmailId(emailId);
        employeeMaster.setdRow("N");

        List list = userMasterService.readUser(employeeCode);

        if (!list.isEmpty()) {
            request.setAttribute("failureMessage", "Information: User already exist");
            mv.setViewName("forward:employeeMaster.htm?act=createEmployeeMaster");
        } else {
            employeeMasterService.create(employeeMaster);
            UserMaster um = new UserMaster();
            um.setLoginName(employeeMaster.getEmployeeCode());
            um.setPassword(employeeMaster.getEmployeeCode());
            um.setUserFullName(employeeMaster.getName());
            um.setUserType(0);
            um.setPwdChange(0);
            um.setUserTry(0);
            um.setLock1(0);
            userMasterService.create(um);

            String rightsName = request.getParameter("rightsName");
            RightMaster rightMaster = rightService.read(rightsName);

            int empMgt = rightMaster.getEmpMgt();
            int vendorMgt = rightMaster.getVendorMgt();
            int rightMgt = rightMaster.getRightMgt();
            int createTender = rightMaster.getCreateTender();
            int authorizeTender = rightMaster.getAuthorizeTender();
            int tenderBidOpen = rightMaster.getTenderBidOpen();
            int userReport = rightMaster.getUserReport();
            int tenderReport = rightMaster.getTenderReport();
            int prManagement = rightMaster.getPrManagement();
            int omsCreator = rightMaster.getOmsCreator();

            int oapCreater = rightMaster.getOapCreater();
            int oapApproval = rightMaster.getOapApproval();
            int aocCreater = rightMaster.getAocCreater();
            int aocApproval = rightMaster.getAocApproval();
            int oapApprovalCreater = rightMaster.getOapApprovalCreater();
            int aocApprovalCreater = rightMaster.getAocApprovalCreater();
            int projectManager = rightMaster.getProjectManager();
            int networkTeam = rightMaster.getNetworkTeam();
            int financeTeam = rightMaster.getFinanceTeam();
            int oapaocReport = rightMaster.getOapaocReport();
            int excecutiveHead = rightMaster.getExecutiveHead();
            int projectcoordinator = rightMaster.getProjectCordinator();
            int sitesurvey = rightMaster.getSiteSurvey();

            int vendorRequest = rightMaster.getVenderRequest();
            int vendorInvite = rightMaster.getVenderInvite();
            int vendorInformation = rightMaster.getVenderInformation();
            int buyerApproval = rightMaster.getBuyerApproval();
            int financialApproval = rightMaster.getFinancialApproval();
            int technicalApproval = rightMaster.getTechnicalApproval();
            int hrApproval = rightMaster.getHrApproval();
            int safetyApproval = rightMaster.getSafetyApproval();
            int activeVendor = rightMaster.getActiveVendor();
            int allVendor = rightMaster.getAllVendor();
            int vendorTechnicalCriteriaMaster = rightMaster.getAllVendor();
            int hrCriteriaMaster = rightMaster.getHrCriteriaMaster();
            int safetyCriteriaMaster = rightMaster.getSafetyApproval();

            int itApproval = rightMaster.getItApproval();
            int complianceOfficer = rightMaster.getComplianceOfficer();
            int procurementHead = rightMaster.getProcurementHead();
            int grnExecutive = rightMaster.getGrnExecutive();

            UserRights ur = new UserRights();
            ur.setUsername(employeeCode);
            ur.setEmployeeMgt(empMgt);
            ur.setVendorMgt(vendorMgt);
            ur.setRightMgt(rightMgt);
            ur.setCreateTender(createTender);
            ur.setAuthorizeTender(authorizeTender);
            ur.setTenderBidOpen(tenderBidOpen);
            ur.setUserReport(userReport);
            ur.setTenderReport(tenderReport);
            ur.setPrManagement(prManagement);
            ur.setOmsCreator(omsCreator);

            ur.setOapCreater(oapCreater);
            ur.setOapApproval(oapApproval);
            ur.setAocCreater(aocCreater);
            ur.setAocApproval(aocApproval);
            ur.setOapApprovalCreater(oapApprovalCreater);
            ur.setAocApprovalCreater(aocApprovalCreater);
            ur.setProjectManager(projectManager);
            ur.setNetworkTeam(networkTeam);
            ur.setFinanceTeam(financeTeam);
            ur.setOapaocReport(oapaocReport);
            ur.setExecutiveHead(excecutiveHead);
            ur.setProjectCordinator(projectcoordinator);
            ur.setSiteSurvey(sitesurvey);

            ur.setVenderRequest(vendorRequest);
            ur.setVenderInvite(vendorInvite);
            ur.setVenderInformation(vendorInformation);

            ur.setBuyerApproval(buyerApproval);
            ur.setFinancialApproval(financialApproval);
            ur.setTechnicalApproval(technicalApproval);
            ur.setHrApproval(hrApproval);
            ur.setSafetyApproval(safetyApproval);
            ur.setActiveVendor(activeVendor);
            ur.setAllVendor(allVendor);
            ur.setVendorTechnicalCriteriaMaster(vendorTechnicalCriteriaMaster);
            ur.setHrCriteriaMaster(hrCriteriaMaster);
            ur.setSafetyCriteriaMaster(safetyCriteriaMaster);

            ur.setItApproval(itApproval);
            ur.setComplianceOfficer(complianceOfficer);
            ur.setProcurementHead(procurementHead);
            ur.setGrnExecutive(grnExecutive);
            userRightsService.create(ur);

            //------for Log entry---------
            HttpSession session = request.getSession(false);
            UserMaster user = (UserMaster) session.getAttribute("user");
            LogsMaster lm = new LogsMaster();
            Date date = new Date();
            lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("Employee Created").setDrow("Y");
            logService.create(lm);

            session.setAttribute("successMessage", "Information: Employee Created successfully");
            mv.setViewName("redirect:employeeMaster.htm?act=showList");

        }
//        } else {
//            request.setAttribute("failureMessage",
//                    "Information: Employee code duplicated found.");
//            request.setAttribute("employeeMaster", employeeMaster);
//            mv.setViewName("Employee/EmployeeCreate");
//        }
        return mv;

    }

    public ModelAndView editEmployeeMasterSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        bind(request, employeeMaster);

        employeeMaster.setdRow("N");
        employeeMasterService.update(employeeMaster);
        UserMaster um = userMasterService.read(employeeMaster.getEmployeeCode());
        um.setLoginName(employeeMaster.getEmployeeCode()).setUserFullName(employeeMaster.getName());
        //    um.setLoginName(employeeMaster.getEmployeeCode()).setPassword(employeeMaster.getEmployeeCode()).setUserFullName(employeeMaster.getName()).setRights(employeeMaster.getRightsName()).setDepartment(employeeMaster.getDepartment()).setDesignation(employeeMaster.getDesignation()).setdRow("N");
        userMasterService.updateuser(employeeMaster.getEmployeeCode(), employeeMaster.getName());

        //user rights
        String rightsName = request.getParameter("rightsName");

        RightMaster rightMaster = rightService.read(rightsName);

        int empMgt = rightMaster.getEmpMgt();
        int vendorMgt = rightMaster.getVendorMgt();
        int rightMgt = rightMaster.getRightMgt();
        int createTender = rightMaster.getCreateTender();
        int authorizeTender = rightMaster.getAuthorizeTender();
        int tenderBidOpen = rightMaster.getTenderBidOpen();
        int userReport = rightMaster.getUserReport();
        int tenderReport = rightMaster.getTenderReport();

        int oapCreater = rightMaster.getOapCreater();
        int oapApproval = rightMaster.getOapApproval();
        int aocCreater = rightMaster.getAocCreater();
        int aocApproval = rightMaster.getAocApproval();

        int oapApprovalCreater = rightMaster.getOapApprovalCreater();
        int aocApprovalCreater = rightMaster.getAocApprovalCreater();
        int projectManager = rightMaster.getProjectManager();

        int networkTeam = rightMaster.getNetworkTeam();
        int financeTeam = rightMaster.getFinanceTeam();
        int oapaocReport = rightMaster.getOapaocReport();
        int executiveHead = rightMaster.getExecutiveHead();
        int projectcordinator = rightMaster.getProjectCordinator();
        int sitesurvey = rightMaster.getSiteSurvey();

        int vendorRequest = rightMaster.getVenderRequest();
        int vendorInvite = rightMaster.getVenderInvite();
        int vendorInformation = rightMaster.getVenderInformation();
        int buyerApproval = rightMaster.getBuyerApproval();
        int financialApproval = rightMaster.getFinancialApproval();
        int technicalApproval = rightMaster.getTechnicalApproval();
        int hrApproval = rightMaster.getHrApproval();
        int safetyApproval = rightMaster.getSafetyApproval();
        int activeVendor = rightMaster.getActiveVendor();
        int allVendor = rightMaster.getAllVendor();
        int vendorTechnicalCriteriaMaster = rightMaster.getAllVendor();
        int hrCriteriaMaster = rightMaster.getHrCriteriaMaster();
        int safetyCriteriaMaster = rightMaster.getSafetyApproval();

        int itApproval = rightMaster.getItApproval();
        int procurementHead = rightMaster.getProcurementHead();
        int complianceOfficer = rightMaster.getComplianceOfficer();
        int prManagement = rightMaster.getPrManagement();
        int omsCreator = rightMaster.getOmsCreator();
        int grnExecutive = rightMaster.getGrnExecutive();
        
        userRightsService.updateRight(employeeMaster.getEmployeeCode(), empMgt, vendorMgt, rightMgt, createTender, authorizeTender, tenderBidOpen, userReport, tenderReport, oapCreater, oapApproval, aocCreater, aocApproval, oapApprovalCreater, aocApprovalCreater, projectManager, networkTeam, financeTeam, oapaocReport, executiveHead, projectcordinator, vendorRequest, vendorInvite, vendorInformation, buyerApproval, financialApproval, technicalApproval, hrApproval, safetyApproval, activeVendor, allVendor, vendorTechnicalCriteriaMaster, hrCriteriaMaster, safetyCriteriaMaster, sitesurvey, procurementHead, complianceOfficer, itApproval, prManagement, omsCreator,grnExecutive);

        HttpSession session = request.getSession(false);
        session.setAttribute("successMessage", "Information: Employee Updated successfully");
        //------for Log entry---------
        UserMaster user = (UserMaster) session.getAttribute("user");
        LogsMaster lm = new LogsMaster();
        Date date = new Date();
        lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("Employee edited").setDrow("Y");
        logService.create(lm);
        mv.setViewName("redirect:employeeMaster.htm?act=showList");
        return mv;
    }

    public ModelAndView viewClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String empCode = request.getParameter("id");
        EmployeeMaster employeeMaster = employeeMasterService.read(empCode);
        readRights(request, response);

        List companyLocation = companyLocationService.read();
        List departmentMaster = departmentMasterService.read();
        List designationMaster = designationMasterService.read();

        mv.getModelMap().put("companyLocation", companyLocation);
        mv.getModelMap().put("departmentMaster", departmentMaster);
        mv.getModelMap().put("designationMaster", designationMaster);

        mv.getModelMap().put("employeeMaster", employeeMaster);
        //------for Log entry---------
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        LogsMaster lm = new LogsMaster();
        Date date = new Date();
        lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("Employee view").setDrow("Y");
        logService.create(lm);
        mv.setViewName("Employee/EmployeeEdit");
        return mv;
    }

    public ModelAndView disableEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String[] checkId = request.getParameterValues("checkId");
        for (String checkedValues : checkId) {
            EmployeeMaster employeeMaster = employeeMasterService.read(checkedValues);
            employeeMaster.setdRow("Y");
            employeeMasterService.update(employeeMaster);
            UserMaster um = userMasterService.read(employeeMaster.getEmployeeCode());
            //um.setdRow("Y");
            userMasterService.update(um);
//            employeeMasterService.deleteByEmpCode(checkedValues);
//            userMasterService.deleteByLoginName(checkedValues);
        }
        HttpSession session = request.getSession(false);
        session.setAttribute("successMessage", "Information: One or more Employee deleted successfully");

        //------for Log entry---------
        UserMaster user = (UserMaster) session.getAttribute("user");
        LogsMaster lm = new LogsMaster();
        Date date = new Date();
        lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("Employee Deleted").setDrow("Y");
        logService.create(lm);
        mv.setViewName("redirect:employeeMaster.htm?act=showList");
        return mv;
    }

    public ModelAndView deleteEmployeeMaster(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String value = request.getParameter("delete");
        String[] checkId = request.getParameterValues("checkId");
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        LogsMaster lm = new LogsMaster();
        Date date = new Date();
        if (value.equals("D")) {
            for (String checkedValues : checkId) {
                employeeMasterService.deleteByEmpCode(checkedValues);
                userMasterService.deleteByLoginName(checkedValues);
            }
            request.setAttribute("successMessage",
                    "Information: One or more Employee deleted successfully");

            //------for Log entry---------
            lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("Employee Deleted permanent").setDrow("Y");
            logService.create(lm);
        } else if (value.equals("R")) {
            for (String checkedValues : checkId) {
                EmployeeMaster employeeMaster = employeeMasterService.read(checkedValues);
                //    employeeMaster.setdRow("N");
                employeeMasterService.update(employeeMaster);
                UserMaster um = userMasterService.read(employeeMaster.getEmployeeCode());
                //    um.setdRow("N");
                userMasterService.update(um);
            }
            request.setAttribute("successMessage",
                    "Information: One or more Employee deleted successfully");
            lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("Employee enable").setDrow("Y");
            logService.create(lm);
        }

        mv = showBackupList(request, response);
        return mv;
    }

    public ModelAndView showCompanyLocationList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);

        if (session != null) {
            String successMessage = (String) session.getAttribute("successMessage");
            if (successMessage != null) {
                mv.addObject("successMessage", successMessage);
                session.removeAttribute("successMessage");
            }

            String failureMessage = (String) session.getAttribute("failureMessage");
            if (failureMessage != null) {
                mv.addObject("failureMessage", failureMessage);
                session.removeAttribute("failureMessage");
            }
        }
        mv.setViewName("Employee/CompanyLocationList");
        return mv;
    }

    public ModelAndView showDesignationList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);

        if (session != null) {
            String successMessage = (String) session.getAttribute("successMessage");
            if (successMessage != null) {
                mv.addObject("successMessage", successMessage);
                session.removeAttribute("successMessage");
            }

            String failureMessage = (String) session.getAttribute("failureMessage");
            if (failureMessage != null) {
                mv.addObject("failureMessage", failureMessage);
                session.removeAttribute("failureMessage");
            }
        }
        mv.setViewName("Employee/DesignationList");
        return mv;
    }

    public ModelAndView createCompanyLocation(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);

        CompanyLocation companyLocation = new CompanyLocation();

        mv.getModelMap().put("companyLocation", companyLocation);

        if (session != null) {

            String successMessage = (String) session.getAttribute("successMessage");
            if (successMessage != null) {
                mv.addObject("successMessage", successMessage);
                session.removeAttribute("successMessage");
            }

            String failureMessage = (String) session.getAttribute("failureMessage");
            if (failureMessage != null) {
                mv.addObject("failureMessage", failureMessage);
                session.removeAttribute("failureMessage");
            }
        }
        mv.setViewName("Employee/CreateCompanyLocation");
        return mv;
    }

    public ModelAndView createDesignation(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);

        if (session != null) {

            String successMessage = (String) session.getAttribute("successMessage");
            if (successMessage != null) {
                mv.addObject("successMessage", successMessage);
                session.removeAttribute("successMessage");
            }

            String failureMessage = (String) session.getAttribute("failureMessage");
            if (failureMessage != null) {
                mv.addObject("failureMessage", failureMessage);
                session.removeAttribute("failureMessage");
            }
        }

        mv.setViewName("Employee/CreateDesignation");
        return mv;
    }

    public ModelAndView submitCompanyLocation(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);

        String locationName = request.getParameter("locationName");
        CompanyLocation companyLocation = new CompanyLocation();
        companyLocation.setLocationName(locationName);

        if (!companyLocationService.isExist(companyLocation)) {
            companyLocationService.create(companyLocation);

            session.setAttribute("successMessage", "Company Location Created Successfully");
            mv.setViewName("redirect:employeeMaster.htm?act=showCompanyLocationList");

        } else {

            session.setAttribute("failureMessage", "Company Location Already Exist. Please Enter Company Location");
            mv.setViewName("redirect:employeeMaster.htm?act=createCompanyLocation");
        }

        return mv;
    }

    public ModelAndView submitDesignation(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        String designationName = request.getParameter("designationName");

        DesignationMaster designationMaster = new DesignationMaster();
        designationMaster.setDesignationName(designationName);

        if (!designationMasterService.isExist(designationMaster)) {
            designationMasterService.create(designationMaster);

            session.setAttribute("successMessage", "Designation Created Successfully");
            mv.setViewName("redirect:employeeMaster.htm?act=showDesignationList");

        } else {

            session.setAttribute("failureMessage", "Designation Already Exist. Please Enter Designation");
            mv.setViewName("redirect:employeeMaster.htm?act=createDesignation");
        }

        return mv;
    }

    public ModelAndView deleteCompanyLocation(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String ids = request.getParameter("ids");

        String[] idArray = ids.split(",");
        for (String checkedValues : idArray) {
            companyLocationService.delete(Integer.parseInt(checkedValues));
        }
        request.setAttribute("successMessage",
                "Information: One or more data deleted successfully");
        mv.setViewName("forward:employeeMaster.htm?act=showCompanyLocationList");
        return mv;
    }

    public ModelAndView deleteDepartment(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String ids = request.getParameter("ids");

        String[] idArray = ids.split(",");
        for (String checkedValues : idArray) {
            departmentMasterService.delete(Integer.parseInt(checkedValues));
        }

        mv.setViewName("redirect:employeeMaster.htm?act=showDepartmentList");
        return mv;
    }

    public ModelAndView deleteDesignation(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String ids = request.getParameter("ids");

        String[] idArray = ids.split(",");
        for (String checkedValues : idArray) {
            designationMasterService.delete(Integer.parseInt(checkedValues));
        }
        request.setAttribute("successMessage",
                "Information: One or more data deleted successfully");
        mv.setViewName("forward:employeeMaster.htm?act=showDesignationList");

        return mv;
    }

    public ModelAndView editCompanyLocation(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");
        CompanyLocation companyLocation = companyLocationService.readById(Integer.parseInt(id));

        mv.getModelMap().put("companyLocation", companyLocation);
        mv.setViewName("Employee/EditCompanyLocation");
        return mv;
    }

    public ModelAndView editDesignation(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");
        DesignationMaster designationMaster = designationMasterService.readById(Integer.parseInt(id));

        mv.getModelMap().put("designationMaster", designationMaster);
        mv.setViewName("Employee/EditDesignation");
        return mv;
    }

    public ModelAndView editCompanyLocationSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        String id = request.getParameter("id");
        String locationName = request.getParameter("locationName");

        CompanyLocation companyLocation = companyLocationService.readById(Integer.parseInt(id));
        companyLocation.setLocationName(locationName);
        companyLocationService.update(companyLocation);

        mv.getModelMap().put("companyLocation", companyLocation);
        session.setAttribute("successMessage",
                "Company Location edit successfully");
        mv.setViewName("redirect:employeeMaster.htm?act=showCompanyLocationList");
        return mv;
    }

    public ModelAndView editDesignationSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");
        String designationName = request.getParameter("designationName");

        HttpSession session = request.getSession(false);

        DesignationMaster designationMaster = designationMasterService.readById(Integer.parseInt(id));
        designationMaster.setDesignationName(designationName);
        designationMasterService.update(designationMaster);

        mv.getModelMap().put("designationMaster", designationMaster);
        session.setAttribute("successMessage",
                "Designation edit successfully");
        mv.setViewName("redirect:employeeMaster.htm?act=showDesignationList");
        return mv;
    }

    public ModelAndView emailMasterList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        List list = emailTemplateService.read();
        mv.getModelMap().put("list", list);

        mv.setViewName("EmailMaster/EmailList");

        return mv;
    }

    public ModelAndView emailEditPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");

        EmailTemplate emailTemplate = emailTemplateService.readById(Integer.parseInt(id));
        mv.getModelMap().put("email", emailTemplate);

        mv.setViewName("EmailMaster/EmailEdit");

        return mv;
    }

    public ModelAndView emailEditPageSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");

        String subject = request.getParameter("subject");
        String bodyText = request.getParameter("bodyText");

        EmailTemplate emailTemplate = emailTemplateService.readById(Integer.parseInt(id));
        emailTemplate.setSubject(subject);
        emailTemplate.setBodytext(bodyText);
        emailTemplateService.update(emailTemplate);

        mv.setViewName("forward:employeeMaster.htm?act=emailMasterList");

        return mv;
    }

    public ModelAndView deleteDesignationById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id = request.getParameter("id");
        ModelAndView mv = new ModelAndView();
        try {
            designationMasterService.delete(Integer.parseInt(id));
        } catch (Exception e) {

        }
//        request.setAttribute("successMessage",
//                "Information: One or more data deleted successfully");
        mv.setViewName("forward:employeeMaster.htm?act=showDesignationList");

        return mv;

    }

    public ModelAndView deleteCompanyById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        try {
            companyLocationService.delete(Integer.parseInt(id));
        } catch (Exception e) {
        }
//        request.setAttribute("successMessage",
//                "Information: One or more data deleted successfully");
        mv.setViewName("forward:employeeMaster.htm?act=showCompanyLocationList");

        return mv;
    }

    public ModelAndView deleteEmpById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        try {
            EmployeeMaster employeeMaster = employeeMasterService.read(id);
            employeeMaster.setdRow("Y");
            employeeMasterService.update(employeeMaster);
        } catch (Exception e) {
            request.setAttribute("successMessage", "Information: One or more data deleted successfully");
        }
        mv.setViewName("redirect:employeeMaster.htm?act=showList");
        return mv;
    }

    public ModelAndView deleteEmp(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String ids = request.getParameter("ids");
        String[] idArray = ids.split(",");
        for (String checkedValues : idArray) {
            EmployeeMaster employeeMaster = employeeMasterService.read(checkedValues);
            employeeMaster.setdRow("Y");
            employeeMasterService.update(employeeMaster);
        }

        mv.setViewName("redirect:employeeMaster.htm?act=showList");
        return mv;
    }

    public ModelAndView showDepartmentList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);

        if (session != null) {

            String successMessage = (String) session.getAttribute("successMessage");
            if (successMessage != null) {
                mv.addObject("successMessage", successMessage);
                session.removeAttribute("successMessage");
            }

            String failureMessage = (String) session.getAttribute("failureMessage");
            if (failureMessage != null) {
                mv.addObject("failureMessage", failureMessage);
                session.removeAttribute("failureMessage");
            }
        }

        mv.setViewName("Employee/DepartmentList");
        return mv;
    }

    public ModelAndView departmentPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().equals("")) {
            orderDir = "asc";
        }

        String orderColumn = "departmentName";

        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "2":
                    orderColumn = "departmentName";
                    break;
                default:
                    orderColumn = "departmentName";
                    break;
            }
        }

        List list = departmentMasterService.getDepartmentPagination(start, length, searchValue, orderColumn, orderDir);

        int totalRecords = departmentMasterService.getTotalDepartmentCount();

        int filteredRecords = departmentMasterService.getFilteredDepartmentCount(searchValue);

        JSONArray dataArray = new JSONArray();

        boolean isDesc = "desc".equalsIgnoreCase(orderDir) && "2".equals(orderColumnIndex);

        int srNo;

        if (isDesc) {
            srNo = filteredRecords - start;
        } else {
            srNo = start + 1;
        }

        for (Object obj : list) {

            DepartmentMaster department = (DepartmentMaster) obj;

            JSONObject json = new JSONObject();

            json.put("checkbox", "<input type='checkbox' " + "class='rowCheckbox' " + "value='" + department.getId() + "'>");

            if (isDesc) {
                json.put("srNo", srNo--);
            } else {
                json.put("srNo", srNo++);
            }

            json.put("departmentName", department.getDepartmentName());

            json.put(
                    "action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + "<a href='employeeMaster.htm?act=editDepartment&id="
                    + department.getId()
                    + "' class='d-block text-info p-1 mx-1'>"
                    + "<img src=\"StorageYard/assets/images/edit-icon.svg\" "
                    + "style='width:18px;height:18px;'>"
                    + "</a>"
                    + "<a href='javascript:void(0);' "
                    + "class='delete-btn1 d-block text-danger p-1 mx-1' "
                    + "data-id='" + department.getId() + "'>"
                    + "<img src=\"StorageYard/assets/images/delete-icon.svg\" "
                    + "style='width:18px;height:18px;'>"
                    + "</a>"
                    + "</div>"
            );

            dataArray.put(json);

        }

        JSONObject responseJson = new JSONObject();
        responseJson.put("draw", draw);
        responseJson.put("recordsTotal", totalRecords);
        responseJson.put("recordsFiltered", filteredRecords);
        responseJson.put("data", dataArray);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(responseJson.toString());

        return null;
    }

    public ModelAndView deleteDepartmentById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");

        try {
            departmentMasterService.delete(Integer.parseInt(id));
            response.setContentType("text/plain");
            response.getWriter().write("success");
        } catch (Exception e) {
            response.setContentType("text/plain");
            response.getWriter().write("error");
        }

        mv.setViewName("redirect:employeeMaster.htm?act=showDepartmentList");
        return null;
    }

    public ModelAndView deleteDepartmentAll(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String ids = request.getParameter("ids");

        String[] idArray = ids.split(",");
        try {
            for (String checkedValues : idArray) {
                departmentMasterService.delete(Integer.parseInt(checkedValues));
            }
            response.setContentType("text/plain");

            response.getWriter().write("success");
        } catch (Exception e) {

            response.setContentType("text/plain");

            response.getWriter().write("error");

        }
        return null;
    }

    public ModelAndView createDepartment(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);
        DepartmentMaster departmentMaster = new DepartmentMaster();
        mv.getModelMap().put("departmentMaster", departmentMaster);
        if (session != null) {

            String successMessage = (String) session.getAttribute("successMessage");
            if (successMessage != null) {
                mv.addObject("successMessage", successMessage);
                session.removeAttribute("successMessage");
            }

            String failureMessage = (String) session.getAttribute("failureMessage");
            if (failureMessage != null) {
                mv.addObject("failureMessage", failureMessage);
                session.removeAttribute("failureMessage");
            }
        }

        mv.setViewName("Employee/CreateDepartment");
        return mv;
    }

    public ModelAndView submitDepartment(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);

        String departmentName = request.getParameter("departmentName");

        DepartmentMaster departmentMaster = new DepartmentMaster();
        departmentMaster.setDepartmentName(departmentName);

        if (!departmentMasterService.isExist(departmentMaster)) {
            departmentMasterService.create(departmentMaster);

            session.setAttribute("successMessage", "Department Created Successfully");
            mv.setViewName("redirect:employeeMaster.htm?act=showDepartmentList");

        } else {

            session.setAttribute("failureMessage", "Department Already Exist. Please Enter Department Name");
            mv.setViewName("redirect:employeeMaster.htm?act=createDepartment");
        }

        return mv;
    }

    public ModelAndView editDepartment(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");
        DepartmentMaster departmentMaster = departmentMasterService.readById(Integer.parseInt(id));
        mv.getModelMap().put("departmentMaster", departmentMaster);

        mv.setViewName("Employee/EditDepartment");
        return mv;
    }

    public ModelAndView editDepartmentSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);

        String id = request.getParameter("id");
        String departmentName = request.getParameter("departmentName");

        DepartmentMaster departmentMaster = departmentMasterService.readById(Integer.parseInt(id));
        departmentMaster.setDepartmentName(departmentName);
        departmentMasterService.update(departmentMaster);
        mv.getModelMap().put("departmentMaster", departmentMaster);

        session.setAttribute("successMessage", "Department Edited Successfully");
        mv.setViewName("redirect:employeeMaster.htm?act=showDepartmentList");
        return mv;
    }

    public ModelAndView designationPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().equals("")) {
            orderDir = "asc";
        }

        String orderColumn = "id";

        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "1":
                    orderColumn = "id";
                    break;
                case "2":
                    orderColumn = "designationName";
                    break;
                default:
                    orderColumn = "id";
                    break;
            }
        }

        List list = designationMasterService.getDesignationPagination(start, length, searchValue, orderColumn, orderDir);

        int totalRecords = designationMasterService.getTotalDesignationCount();

        int filteredRecords = designationMasterService.getFilteredDesignationCount(searchValue);

        JSONArray dataArray = new JSONArray();

        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo;

        if (isDesc) {
            srNo = filteredRecords - start;
        } else {
            srNo = start + 1;
        }

        for (Object obj : list) {

            DesignationMaster designationMaster = (DesignationMaster) obj;

            JSONObject json = new JSONObject();

            json.put("checkbox", "<input type='checkbox' " + "class='rowCheckbox' " + "value='" + designationMaster.getId() + "'>");

            if (isDesc) {
                json.put("srNo", srNo--);
            } else {
                json.put("srNo", srNo++);
            }

            json.put("name", designationMaster.getDesignationName());

            json.put("action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + "<a href='employeeMaster.htm?act=editDesignation&id="
                    + designationMaster.getId()
                    + "' class='d-block text-info p-1 mx-1'>"
                    + "<img src=\"StorageYard/assets/images/edit-icon.svg\" "
                    + "style='width:18px;height:18px;'>"
                    + "</a>"
                    + "<a href='javascript:void(0);' "
                    + "class='delete-btn1 d-block text-danger p-1 mx-1' "
                    + "data-id='" + designationMaster.getId() + "'>"
                    + "<img src=\"StorageYard/assets/images/delete-icon.svg\" "
                    + "style='width:18px;height:18px;'>"
                    + "</a>"
                    + "</div>"
            );

            dataArray.put(json);

        }

        JSONObject responseJson = new JSONObject();
        responseJson.put("draw", draw);
        responseJson.put("recordsTotal", totalRecords);
        responseJson.put("recordsFiltered", filteredRecords);
        responseJson.put("data", dataArray);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(responseJson.toString());

        return null;
    }

    public ModelAndView companyLocationPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().equals("")) {
            orderDir = "desc";
        }

        String orderColumn = "id";

        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "1":
                    orderColumn = "id";
                    break;
                case "2":
                    orderColumn = "locationName";
                    break;
                default:
                    orderColumn = "id";
                    break;
            }
        }

        List list = companyLocationService.getCompanyLocationPagination(start, length, searchValue, orderColumn, orderDir);

        int totalRecords = companyLocationService.getTotalCompanyLocationCount();

        int filteredRecords = companyLocationService.getFilteredCompanyLocationCount(searchValue);

        JSONArray dataArray = new JSONArray();

        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo;

        if (isDesc) {
            srNo = filteredRecords - start;
        } else {
            srNo = start + 1;
        }

        for (Object obj : list) {

            CompanyLocation companyLocation = (CompanyLocation) obj;

            JSONObject json = new JSONObject();

            json.put("checkbox", "<input type='checkbox' " + "class='rowCheckbox' " + "value='" + companyLocation.getId() + "'>");

            if (isDesc) {
                json.put("srNo", srNo--);
            } else {
                json.put("srNo", srNo++);
            }

            json.put("locationName", companyLocation.getLocationName());

            json.put("action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + "<a href='employeeMaster.htm?act=editCompanyLocation&id="
                    + companyLocation.getId()
                    + "' class='d-block text-info p-1 mx-1'>"
                    + "<img src=\"StorageYard/assets/images/edit-icon.svg\" "
                    + "style='width:18px;height:18px;'>"
                    + "</a>"
                    + "<a href='javascript:void(0);' "
                    + "class='delete-btn1 d-block text-danger p-1 mx-1' "
                    + "data-id='" + companyLocation.getId() + "'>"
                    + "<img src=\"StorageYard/assets/images/delete-icon.svg\" "
                    + "style='width:18px;height:18px;'>"
                    + "</a>"
                    + "</div>"
            );

            dataArray.put(json);
        }

        JSONObject responseJson = new JSONObject();
        responseJson.put("draw", draw);
        responseJson.put("recordsTotal", totalRecords);
        responseJson.put("recordsFiltered", filteredRecords);
        responseJson.put("data", dataArray);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(responseJson.toString());

        return null;
    }
}
