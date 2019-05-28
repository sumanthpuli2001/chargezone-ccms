/*
 * 
 * Author Vinita
 */
package com.bul.zydex.controller.emprequest;

import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.model.EmailTemplate;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.LocationMaster;
import com.bul.zydex.model.UserMaster;
import com.bul.zydex.model.UserRightMaster;
import com.bul.zydex.model.VisitorManagement;
import com.bul.zydex.model.VisitorVisitedLocation;
import com.bul.zydex.model.ZydexLocationMaster;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Vinita
 */
public class VisitorManagementController extends VisitorManagementAbstract {

//    public ModelAndView searchSubmit(HttpServletRequest request,
//            HttpServletResponse response) throws Exception {
//        ModelAndView mv = new ModelAndView();
//        VisitorManagement visitorManagement = new VisitorManagement();
//        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
//        visitorManagement.setEmployeeMasterByEmployeeMasterId(employeeMaster);
//        List<?> visitorlist = visitorManagementService.readByEmpId(visitorManagement);
//        mv.getModelMap().put("visitorlist", visitorlist);
//        mv.getModelMap().put("visitorManagement", visitorManagement);
//        mv.getModelMap().put("employeeMaster", employeeMaster);
//        mv.setViewName("VisitorManagement/VisitorResult");
//        return mv;
//    }
    public ModelAndView searchSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        VisitorManagement visitorManagement = new VisitorManagement();
        mv.getModelMap().put("visitorlist", null);
        mv.getModelMap().put("visitorManagement", visitorManagement);
        mv.setViewName("VisitorManagement/VisitorResult");
        return mv;
    }

    public ModelAndView searchEmpResult(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        VisitorManagement visitorManagement = new VisitorManagement();
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String status = request.getParameter("status");
        List<?> visitorlist = visitorManagementService.readSearchEmpRequestForSessionEmployee(employeeMaster.getId(), startDate, endDate, status);
        mv.getModelMap().put("visitorManagement", visitorManagement);
        mv.addObject("visitorlist", visitorlist);
        if (visitorlist.size() > 0) {
            request.setAttribute("startDate", startDate);
            request.setAttribute("endDate", endDate);
            request.setAttribute("status", status);
        }
        mv.setViewName("VisitorManagement/VisitorResult");
        return mv;
    }

    public ModelAndView createClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        VisitorManagement visitorManagement = new VisitorManagement();
        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
        String type = request.getParameter("get");
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        EmployeeMaster employeeMaster2 = new EmployeeMaster();
        UserMaster user = (UserMaster) request.getSession().getAttribute("user");
        UserRightMaster user1 = (UserRightMaster) request.getSession().getAttribute("userRight");
        int reportingId = 0;
        user.getId();
        employeeMaster1.setUserMaster(user);
        List<?> empDetailList = employeeMasterService.readEmployeeDetailUserIdWise(employeeMaster1);
        if (!empDetailList.isEmpty()) {
            request.setAttribute("employeeMaster", empDetailList.get(0));
            Object[] arrayOfObject = (Object[]) empDetailList.get(0);
            String reportmanager = (String) arrayOfObject[6];
            if (!reportmanager.equals("")) {
                reportingId = Integer.parseInt(reportmanager);
            }

            employeeMaster2.setId(reportingId);
        }
        List<?> reportmanager1 = employeeMasterService.readByReportManager(employeeMaster2);
        if (!reportmanager1.isEmpty()) {
            employeeMaster2 = (EmployeeMaster) reportmanager1.get(0);
            request.setAttribute("reportingManager", employeeMaster2.getEmployeeName());
        }

        if (employeeMaster.getEmployeeId().equals("admin")) {
            request.setAttribute("failureMessage",
                    "Error : Access Denied, Please Contact To Administrator");
            if (type == null) {
                mv.setViewName("VisitorManagement/VisitorResult");
            } else {
                mv.setViewName("VisitorManagement/SecurityResult");
            }
        } else {
            employeeMaster.getReportingManagerLevel1();
            List<?> list = employeeMasterService.readManagerLevel1(employeeMaster);
            if (!list.isEmpty()) {
                request.setAttribute("reportingLevel1", list.get(0));
//                mv.setViewName("VisitorManagement/VisitorManagementCreate");
            }
            employeeMaster.setDepartmentMaster(departmentMasterService.readById(employeeMaster.getDepartmentMaster().getId()));
            employeeMaster.setDesignationMaster(designationMasterService.readById(employeeMaster.getDesignationMaster().getId()));
            employeeMaster.setLevelMaster(levelMasterService.readById(employeeMaster.getLevelMaster().getId()));
            employeeMaster.setLocationMaster(locationMasterService.readById(employeeMaster.getLocationMaster().getId()));
            employeeMaster.setZydexLocationMaster(zydexLocationMasterService.readById(employeeMaster.getZydexLocationMaster().getId()));
            visitorManagement.setEmployeeMasterByEmployeeMasterId(employeeMaster);
            if (type == null) {
                mv.setViewName("VisitorManagement/VisitorManagementCreate");
            } else {
                mv.setViewName("VisitorManagement/VisitorCreateBySecurity");
            }
        }
        visitorManagement.setVisitorVisitsToEmployeeId(new EmployeeMaster());
        visitorManagement.setZydexLocationMaster(new ZydexLocationMaster());
        zydexLocationList(request);
        selectEmployee(request, response);
//        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.getModelMap().put("visitorManagement", visitorManagement);
        return mv;
    }

    public ModelAndView createSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        VisitorManagement visitorManagement = new VisitorManagement();
        bind(request, visitorManagement);
        String type = request.getParameter("get");
        try {
            BindException errors = new BindException(visitorManagement, "visitorManagement");
            List<?> list = employeeMasterService.readManagerLevel1(employeeMaster);
            if (!list.isEmpty()) {
                request.setAttribute("reportingLevel1", list.get(0));
            }
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            
            visitorManagementValidator.validate(visitorManagement, errors);
            if (errors.hasErrors()) {
                request.setAttribute("failureMessage",
                        "Error : Mandatory Fields should not be blank.");
                mv.addAllObjects(errors.getModel());
                zydexLocationList(request);
                selectEmployee(request, response);
                if (type == null) {
                    mv.setViewName("VisitorManagement/VisitorManagementCreate");
                } else {
                    mv.setViewName("VisitorManagement/VisitorCreateBySecurity");
                }
            } else {
                if (type == null) {
                    visitorManagement.setStatus(1);
                    visitorManagement.setRequestDate(visitorManagement.getRequestDate());
                    visitorManagementService.create(visitorManagement);
                    mv = searchSubmit(request, response);
                } else {
                    visitorManagement.setStatus(2);
                    visitorManagement.setRequestDate(sdf.format(new Date()));
                    visitorManagement.setApproverDate(sdf.format(new Date()));
                    visitorManagement.setEmployeeMasterBySecurityApproveId(employeeMaster);
                    visitorManagementService.create(visitorManagement);
                    mv.setViewName("forward:visitorManagement.htm?act=viewSecurityClick&id=" + visitorManagement.getId() + "&empId=" + employeeMaster.getId() + "&for=view");
                }
                request.setAttribute("successMessage",
                        "Information : Request Successfully generated.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.getModelMap().put("visitorManagement", visitorManagement);
        return mv;
    }

    public ModelAndView viewClickByEmployee(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        String id = request.getParameter("id");
        VisitorManagement visitorManagement = visitorManagementService.readById(Integer.parseInt(id));
        employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
        List<?> list = employeeMasterService.readManagerLevel1(employeeMaster);
        if (!list.isEmpty()) {
            request.setAttribute("reportingLevel1", list.get(0));
        }
        try {
            employeeMaster.setDepartmentMaster(departmentMasterService.readById(employeeMaster.getDepartmentMaster().getId()));
            employeeMaster.setDesignationMaster(designationMasterService.readById(employeeMaster.getDesignationMaster().getId()));
            employeeMaster.setLevelMaster(levelMasterService.readById(employeeMaster.getLevelMaster().getId()));
            employeeMaster.setLocationMaster(locationMasterService.readById(employeeMaster.getLocationMaster().getId()));
            employeeMaster.setZydexLocationMaster(zydexLocationMasterService.readById(employeeMaster.getZydexLocationMaster().getId()));
            visitorManagement.setEmployeeMasterByEmployeeMasterId(employeeMaster);
            ZydexLocationMaster zydexLocationMaster = zydexLocationMasterService.readById(visitorManagement.getZydexLocationMaster().getId());
            request.setAttribute("zydexLocation", zydexLocationMaster.getZydexLocation());
            EmployeeMaster empMasterVisitsTo = employeeMasterService.readById(visitorManagement.getVisitorVisitsToEmployeeId().getId());
            DesignationMaster desigVisitsTo = designationMasterService.readById(empMasterVisitsTo.getDesignationMaster().getId());
            String empVisitsToString = "" + empMasterVisitsTo.getEmployeeId().toString() + " /" + empMasterVisitsTo.getEmployeeName().toString() + " /" + desigVisitsTo.getDesignationName().toString();
            request.setAttribute("empVisitsToString", empVisitsToString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.getModelMap().put("visitorManagement", visitorManagement);
        mv.setViewName("VisitorManagement/VisitorView");
        return mv;
    }

    public ModelAndView adminAprrovewithdrawClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        VisitorManagement visitorManagement = new VisitorManagement();
        bind(request, visitorManagement);
        String get = request.getParameter("get");
        try {
            visitorManagement = visitorManagementService.readById(visitorManagement.getId());
            visitorManagement.setStatus(8);
            request.setAttribute("successMessage",
                    "Information :Withdraw Request Successfully Submited !");
            visitorManagementService.update(visitorManagement);
        } catch (Exception e) {
            e.printStackTrace();
        }
        mv.getModelMap().put("visitorManagement", visitorManagement);
        if(null == get){
            mv = searchSubmit(request, response);
        } else{
            mv = securityApprove(request, response);
        }
        return mv;
    }

    public ModelAndView securityApprove(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        VisitorManagement visitorManagement = new VisitorManagement();
        selectEmployee(request, response);
        departmentList(request);
        designationList(request);
        mv.getModelMap().put("Approverlist", null);
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.getModelMap().put("visitorManagement", visitorManagement);
        mv.setViewName("VisitorManagement/SecurityResult");
        return mv;
    }

    public ModelAndView securityApproveSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession();
        VisitorManagement visitorManagement = new VisitorManagement();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");

        List<?> Approverlist = null;
        String employeeId = request.getParameter("employeeId");
        String departmentId = request.getParameter("departmentMaster");
        String designationId = request.getParameter("designationMaster");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String status = request.getParameter("status");

        Object object = (Object) request.getAttribute("flag");
        if (object == null) {
            Approverlist = visitorManagementService.readByapproverId(employeeId, designationId, departmentId, startDate, endDate, status);
        } else {
            Approverlist = (List<?>) request.getAttribute("Approverlist");
        }

        selectEmployee(request, response);
        departmentList(request);
        designationList(request);

        if (departmentId != null) {
            request.setAttribute("dept", departmentId);
        }

        if (startDate != null && endDate != null) {
            request.setAttribute("sd", startDate);
            request.setAttribute("ed", endDate);
        }

        if (status != null) {
            request.setAttribute("status", status);
        }

        mv.getModelMap().put("Approverlist", Approverlist);
        session.setAttribute("ApproverListForSession", Approverlist);

        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.getModelMap().put("visitorManagement", visitorManagement);
        mv.setViewName("VisitorManagement/SecurityResult");
        return mv;
    }

    public ModelAndView viewSecurityClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        String empId = request.getParameter("empId");
        String type = request.getParameter("for");
        EmployeeMaster empMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        EmployeeMaster employeeMaster = employeeMasterService.readById(Integer.parseInt(empId));
//        employeeMaster.getReportingManagerLevel1();
        VisitorManagement visitorManagement = visitorManagementService.readById(Integer.parseInt(id));
        List<?> list = employeeMasterService.readManagerLevel1(employeeMaster);
        if (!list.isEmpty()) {
            request.setAttribute("reportingLevel1", list.get(0));
        }
        try {
            if (type.equals("view")) {
                employeeMaster.setDepartmentMaster(departmentMasterService.readById(employeeMaster.getDepartmentMaster().getId()));
                employeeMaster.setDesignationMaster(designationMasterService.readById(employeeMaster.getDesignationMaster().getId()));
                employeeMaster.setLevelMaster(levelMasterService.readById(employeeMaster.getLevelMaster().getId()));
                employeeMaster.setLocationMaster(locationMasterService.readById(employeeMaster.getLocationMaster().getId()));
                employeeMaster.setZydexLocationMaster(zydexLocationMasterService.readById(employeeMaster.getZydexLocationMaster().getId()));
                visitorManagement.setEmployeeMasterByEmployeeMasterId(employeeMaster);
                ZydexLocationMaster zydexLocationMaster = zydexLocationMasterService.readById(visitorManagement.getZydexLocationMaster().getId());
                request.setAttribute("zydexLocation", zydexLocationMaster.getZydexLocation());
                EmployeeMaster empMasterRequest = employeeMasterService.readById(visitorManagement.getEmployeeMasterByEmployeeMasterId().getId());
                DesignationMaster desigRequest = designationMasterService.readById(empMasterRequest.getDesignationMaster().getId());
                String empRequestString = "" + empMasterRequest.getEmployeeId().toString() + " /" + empMasterRequest.getEmployeeName().toString() + " /" + desigRequest.getDesignationName().toString();
                EmployeeMaster empMasterVisitsTo = employeeMasterService.readById(visitorManagement.getVisitorVisitsToEmployeeId().getId());
                DesignationMaster desigVisitsTo = designationMasterService.readById(empMasterVisitsTo.getDesignationMaster().getId());
                String empVisitsToString = "" + empMasterVisitsTo.getEmployeeId().toString() + " /" + empMasterVisitsTo.getEmployeeName().toString() + " /" + desigVisitsTo.getDesignationName().toString();
                request.setAttribute("empRequestString", empRequestString);
                request.setAttribute("empVisitsToString", empVisitsToString);
                mv.setViewName("VisitorManagement/VisitorRequestSecurityView");
            } else {
                VisitorManagement vm = visitorManagementService.readById(Integer.parseInt(id));
                if (vm.getIncomingDateTime() == null || vm.getIncomingDateTime().equals("")) {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY HH:mm");
                    Date date = new Date();
                    vm.setIncomingDateTime(sdf.format(date));
                    vm.setApproverDate(sdf.format(new Date()));
                    vm.setStatus(2);
                    vm.setEmployeeMasterBySecurityApproveId(empMaster);
                    visitorManagementService.update(vm);
                }
                EmployeeMaster emp = employeeMasterService.readById(visitorManagement.getVisitorVisitsToEmployeeId().getId());
                DesignationMaster design = designationMasterService.readById(emp.getDesignationMaster().getId());
                ZydexLocationMaster zydexLocationMaster = zydexLocationMasterService.readById(vm.getZydexLocationMaster().getId());
                mv.getModelMap().put("designation", design);
                request.setAttribute("zlm", zydexLocationMaster);
                request.setAttribute("incomingTime", vm.getIncomingDateTime());
                request.setAttribute("employeeVisitsTo", emp);
                mv.setViewName("VisitorManagement/VisitorRequestSecurityViewPrint");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.getModelMap().put("visitorManagement", visitorManagement);
        return mv;
    }

    public void setOutMeet(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        String id = request.getParameter("id");
        String mod = request.getParameter("mod");
        VisitorManagement visitorManagement = visitorManagementService.readById(Integer.parseInt(id));
        if ((visitorManagement.getMeetingOffDate() == null || visitorManagement.getMeetingOffDate().equals("")) && (visitorManagement.getOutgoingDateTime() == null || visitorManagement.getOutgoingDateTime().equals(""))) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY HH:mm");
            visitorManagement.setMeetingOffDate(mod);
            Date date = new Date();
            visitorManagement.setOutgoingDateTime(sdf.format(date));
            visitorManagementService.update(visitorManagement);
        }
    }
        //    public ModelAndView createSubmit(HttpServletRequest request,
    //            HttpServletResponse response) throws Exception {
    //        ModelAndView mv = new ModelAndView();
    //        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
    //        VisitorManagement visitorManagement = new VisitorManagement();
    //        bind(request, visitorManagement);
    //        String type = request.getParameter("get");
    //        try {
    //            List<?> list = employeeMasterService.readManagerLevel1(employeeMaster);
    //            if (!list.isEmpty()) {
    //                request.setAttribute("reportingLevel1", list.get(0));
    //            }
    //
    //            if (visitorManagement.getVisitorVisitsToEmployeeId() == null || visitorManagement.getVisitorVisitedLocation() == null) {
    //                request.setAttribute("failureMessage",
    //                        "Error : Mendatory fields must be selected.");
    //                zydexLocationList(request);
    //                selectEmployee(request, response);
    //                if (type == null) {
    //                    mv.setViewName("VisitorManagement/VisitorManagementCreate");
    //                } else {
    //                    mv.setViewName("VisitorManagement/VisitorCreateBySecurity");
    //                }
    //            } else {
    //                BindException errors = new BindException(visitorManagement, "visitorManagement");
    //                visitorManagementValidator.validate(visitorManagement, errors);
    //                if (errors.hasErrors()) {
    //                    request.setAttribute("failureMessage",
    //                            "Error : Mandatory Fields should not be blank.");
    //                    mv.addAllObjects(errors.getModel());
    //                    zydexLocationList(request);
    //                    selectEmployee(request, response);
    //                    if (type == null) {
    //                        mv.setViewName("VisitorManagement/VisitorManagementCreate");
    //                    } else {
    //                        mv.setViewName("VisitorManagement/VisitorCreateBySecurity");
    //                    }
    //                } else {
    //                    if (type == null) {
    //                        visitorManagement.setCompany(new Company());
    //                        visitorManagement.setStatus(1);
    //                        visitorManagement.setRequestDate(visitorManagement.getRequestDate());
    //                        visitorManagementService.create(visitorManagement);
    //                        request.setAttribute("successMessage",
    //                                "Information : Request Successfully generated.");
    //                        mv = searchSubmit(request, response);
    //                    } else {
    //                        visitorManagement.setCompany(new Company());
    //                        visitorManagement.setStatus(2);
    //                        visitorManagement.setRequestDate(visitorManagement.getRequestDate());
    //                        visitorManagementService.create(visitorManagement);
    //                        request.setAttribute("successMessage",
    //                                "Information : Request Successfully generated.");
    //                        mv.setViewName("forward:visitorManagement.htm?act=viewSecurityClick&id=" + visitorManagement.getId() + "&empId=" + employeeMaster.getId() + "&for=view");
    //                    }
    //                }
    //            }
    //        } catch (Exception e) {
    //            e.printStackTrace();
    //        }
    ////         
    //        mv.getModelMap().put("employeeMaster", employeeMaster);
    //        mv.getModelMap().put("visitorManagement", visitorManagement);
    //        return mv;
    //    }
    //    public ModelAndView createClick(HttpServletRequest request,
    //            HttpServletResponse response) throws Exception {
    //        ModelAndView mv = new ModelAndView();
    //        VisitorManagement visitorManagement = new VisitorManagement();
    //        VisitorVisitedLocation visitorVisitedLocation = new VisitorVisitedLocation();
    //        HolidayMaster hm = new HolidayMaster();
    //        HttpSession session = request.getSession();
    //        EmployeeMaster employeeMaster = new EmployeeMaster();
    //        employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
    //        employeeMaster.getReportingManagerLevel1();
    //        List<?> list = employeeMasterService.readManagerLevel1(employeeMaster);
    //        if (!list.isEmpty()) {
    //            request.setAttribute("reportingLevel1", list.get(0));
    //        }
    //        employeeMaster.setDepartmentMaster(departmentMasterService.readById(employeeMaster.getDepartmentMaster().getId()));
    //        employeeMaster.setDesignationMaster(designationMasterService.readById(employeeMaster.getDesignationMaster().getId()));
    //        employeeMaster.setLevelMaster(levelMasterService.readById(employeeMaster.getLevelMaster().getId()));
    //        employeeMaster.setLocationMaster(locationMasterService.readById(employeeMaster.getLocationMaster().getId()));
    //        visitorManagement.setEmployeeMasterByEmployeeMasterId(employeeMaster);
    //        visitorManagement.setVisitorVisitedLocation(visitorVisitedLocation);
    //        readVisitedlocation(request, response);
    //        mv.getModelMap().put("employeeMaster", employeeMaster);
    //        mv.getModelMap().put("visitorManagement", visitorManagement);
    //        mv.setViewName("VisitorManagement/VisitorManagementCreate");
    //        return mv;
    //    }
    //    public ModelAndView createSubmit(HttpServletRequest request,
    //            HttpServletResponse response) throws Exception {
    //        ModelAndView mv = new ModelAndView();
    //        VisitorManagement visitorManagement = new VisitorManagement();
    //        VisitorVisitedLocation visitorVisitedLocation = new VisitorVisitedLocation();
    //
    //        LocationMaster locationMaster = new LocationMaster();
    //        String location = request.getParameter("visitorVisitedLocation.id");
    //        BindException errors = new BindException(visitorManagement, "visitorManagement");
    ////        readlocation(request, response);
    //        readVisitedlocation(request, response);
    //        bind(request, visitorManagement);
    //        Integer empid = visitorManagement.getEmployeeMasterByEmployeeMasterId().getId();
    //        EmployeeMaster employeeMaster = new EmployeeMaster();
    //        employeeMaster = employeeMasterService.readById(empid);
    //        List<?> list = employeeMasterService.readManagerLevel1(employeeMaster);
    //        if (!list.isEmpty()) {
    //            request.setAttribute("reportingLevel1", list.get(0));
    //        }
    //
    //        visitorManagementValidator.validate(visitorManagement, errors);
    //        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    //        if (errors.hasErrors()) {
    //            request.setAttribute("failureMessage",
    //                    "Error : Mandatory Fields should not be blank.");
    //            mv.addAllObjects(errors.getModel());
    //            mv.setViewName("VisitorManagement/VisitorManagementCreate");
    //        } else {
    //            String requestdate = sdf.format(new Date());
    //            visitorManagement.setRequestDate(requestdate);
    //            visitorManagement.setStatus(1);
    //            if (locationMaster.getId() == null && location == "") {
    //                request.setAttribute("failureMessage", "Error :Select Visitor Visits To Location");
    //                mv.getModelMap().put("visitorManagement", visitorManagement);
    //                mv.setViewName("VisitorManagement/VisitorManagementCreate");
    //            } else {
    //                visitorVisitedLocation = visitorVisitedLocationService.readById(Integer.parseInt(location));
    //                visitorManagement.setVisitorVisitedLocation(visitorVisitedLocation);
    //                visitorManagementService.create(visitorManagement);
    //                request.setAttribute("successMessage",
    //                        "Information : Request Sent Successfully.");
    //                //    Email Sent to Security
    //                List<?> SecurityList = userRightMasterService.readSecurityList();
    //                for (Object o : SecurityList) {
    //                    Object[] o1 = (Object[]) o;
    //                    int SecurityId = (int) o1[0];
    //                    try {
    //                        EmailTemplate emailTemplate = new EmailTemplate();
    //                        EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
    //                        DesignationMaster designationMaster = new DesignationMaster();
    //                        designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
    //                        EmployeeMaster employeeMasterHr = new EmployeeMaster();
    //                        employeeMasterHr = employeeMasterService.readById(SecurityId);
    //                        // id 34 is for Visitor Management Apply
    //                        emailTemplate = emailTemplateService.readById(34);
    //                        String To = employeeMasterHr.getOfficeEmailId();
    //                        String from = employeeMasterModel.getOfficeEmailId();
    //                        String Subject = emailTemplate.getSubject();
    //                        Subject = Subject.replaceAll("\\{user\\}", employeeMasterModel.getEmployeeName());
    //                        String msg = emailTemplate.getBodytext();
    //                        msg = msg.replaceAll("\\{to_user\\}", employeeMasterHr.getEmployeeName());
    //                        msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
    //                        msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
    //                        sendMail.sendMail(from, To, Subject, msg);
    //                    } catch (Exception e) {
    //
    //                    }
    //                }
    //                mv.getModelMap().put("visitorManagement", visitorManagement);
    //                mv = searchSubmit(request, response);
    //            }
    //        }
    //        return mv;
    //    }
    //    <---------Admin Approver---------->

//    public ModelAndView securityApproveSubmit(HttpServletRequest request,
//            HttpServletResponse response) throws Exception {
//        ModelAndView mv = new ModelAndView();
//        HttpSession session = request.getSession();
//        VisitorManagement visitorManagement = new VisitorManagement();
//        EmployeeMaster employeeMaster = new EmployeeMaster();
//        String id = request.getParameter("id");
//        List<?> Approverlist = null;
//        Object object = (Object) request.getAttribute("flag");
//        if (object == null) {
//
//            Approverlist = visitorManagementService.readByapproverId(visitorManagement);
//        } else {
//            Approverlist = (List<?>) request.getAttribute("Approverlist");
//        }
//        selectEmployee(request, response);
//        departmentList(request);
//        designationList(request);
//        mv.getModelMap().put("Approverlist", Approverlist);
//        mv.getModelMap().put("employeeMaster", employeeMaster);
//        mv.getModelMap().put("visitorManagement", visitorManagement);
//        session.setAttribute("Approverlist11", Approverlist);
//        mv.setViewName("VisitorManagement/SecurityResult");
//        return mv;
//    }
//    public ModelAndView viewSecurityClick(HttpServletRequest request,
//            HttpServletResponse response) throws Exception {
//        ModelAndView mv = new ModelAndView();
//        VisitorManagement visitorManagement = new VisitorManagement();
//        EmployeeMaster employeeMaster = new EmployeeMaster();
//        String id = request.getParameter("id");
//        String empId = request.getParameter("empId");
//        readVisitedlocation(request, response);
//        employeeMaster = employeeMasterService.readById(Integer.parseInt(empId));
//        employeeMaster.getReportingManagerLevel1();
//        List<?> list = employeeMasterService.readManagerLevel1(employeeMaster);
//        if (!list.isEmpty()) {
//            request.setAttribute("reportingLevel1", list.get(0));
//        }
//        bind(request, visitorManagement);
//        visitorManagement = visitorManagementService.readById(Integer.parseInt(id));
//        employeeMaster.setDepartmentMaster(departmentMasterService.readById(employeeMaster.getDepartmentMaster().getId()));
//        employeeMaster.setDesignationMaster(designationMasterService.readById(employeeMaster.getDesignationMaster().getId()));
//        employeeMaster.setLevelMaster(levelMasterService.readById(employeeMaster.getLevelMaster().getId()));
//        employeeMaster.setLocationMaster(locationMasterService.readById(employeeMaster.getLocationMaster().getId()));
//        visitorManagement.setVisitorVisitedLocation(visitorVisitedLocationService.readById(visitorManagement.getVisitorVisitedLocation().getId()));
//        mv.getModelMap().put("visitorManagement", visitorManagement);
//        request.setAttribute("employeeMaster", employeeMaster);
//        mv.setViewName("VisitorManagement/VisitorRequestSecurityView");
//        return mv;
//    }
    public ModelAndView securityAprroveClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        VisitorManagement visitorManagement = new VisitorManagement();
        String id = request.getParameter("id");
        String statusType = request.getParameter("statusType");
        String remark = request.getParameter("securityRemark");
        bind(request, visitorManagement);
        visitorManagement = visitorManagementService.readById(Integer.parseInt(id));
        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
        employeeMaster.setDepartmentMaster(departmentMasterService.readById(employeeMaster.getDepartmentMaster().getId()));
        employeeMaster.setDesignationMaster(designationMasterService.readById(employeeMaster.getDesignationMaster().getId()));
        employeeMaster.setLevelMaster(levelMasterService.readById(employeeMaster.getLevelMaster().getId()));
//        visitorManagement.setVisitorVisitedLocation(visitorVisitedLocationService.readById(visitorManagement.getVisitorVisitedLocation().getId()));
        employeeMaster.setLocationMaster(locationMasterService.readById(employeeMaster.getLocationMaster().getId()));
        visitorManagement.setEmployeeMasterBySecurityApproveId(employeeMaster);
        if (null != statusType) {
            if (statusType.equals("3")) {
                visitorManagement.setStatus(3);
                visitorManagement.setSecurityRemark(remark);
                request.setAttribute("successMessage",
                        "Information : Request Rejected Successfully.");
            } else if (statusType.equals("4")) {
                visitorManagement.setStatus(4);
                visitorManagement.setSecurityRemark(remark);
                request.setAttribute("successMessage",
                        "Information : Request Returned Successfully.");
            }
        } else {
            visitorManagement.setStatus(2);
            visitorManagementService.update(visitorManagement);
            request.setAttribute("successMessage",
                    "Information : Request Approved Successfully.");
            //    Email Sent to Employee
            try {
                EmailTemplate emailTemplate = new EmailTemplate();
                EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                DesignationMaster designationMaster = new DesignationMaster();
                designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                List l1 = visitorManagementService.readEmpIdFromTabId(Integer.parseInt(id));
                EmployeeMaster employeeRequestee = (EmployeeMaster) l1.get(0);
                // id 35 is for status Visitor Confirm
                emailTemplate = emailTemplateService.readById(35);
                String To = employeeRequestee.getOfficeEmailId();
                String from = employeeMasterModel.getOfficeEmailId();
                String Subject = emailTemplate.getSubject();
                Subject = Subject.replaceAll("\\{user\\}", employeeRequestee.getEmployeeName());
                String msg = emailTemplate.getBodytext();
                msg = msg.replaceAll("\\{to_user\\}", employeeRequestee.getEmployeeName());
                msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                sendMail.sendMail(from, To, Subject, msg);
            } catch (Exception e) {

            }
        }
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.getModelMap().put("visitorManagement", visitorManagement);
        mv = securityApproveSubmit(request, response);
        return mv;
    }

    // <---------Return Cycle---------->
    public ModelAndView EmpviewClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        VisitorManagement visitorManagement = new VisitorManagement();
        EmployeeMaster employeeMaster = new EmployeeMaster();
//        readlocation(request, response);
        readVisitedlocation(request, response);
        String id = request.getParameter("id");
        HttpSession session = request.getSession();
        EmployeeMaster employee = (EmployeeMaster) session.getAttribute("employeeInfo");
        employeeMaster = employeeMasterService.readById(employee.getId());
        employeeMaster.getReportingManagerLevel1();
        List<?> list = employeeMasterService.readManagerLevel1(employeeMaster);
        if (!list.isEmpty()) {
            request.setAttribute("reportingLevel1", list.get(0));
        }
        employeeMaster.setDepartmentMaster(departmentMasterService.readById(employeeMaster.getDepartmentMaster().getId()));
        employeeMaster.setDesignationMaster(designationMasterService.readById(employeeMaster.getDesignationMaster().getId()));
        employeeMaster.setLevelMaster(levelMasterService.readById(employeeMaster.getLevelMaster().getId()));
        employeeMaster.setLocationMaster(locationMasterService.readById(employeeMaster.getLocationMaster().getId()));
        bind(request, visitorManagement);
        visitorManagement = visitorManagementService.readById(Integer.parseInt(id));
        visitorManagement.setVisitorVisitedLocation(visitorVisitedLocationService.readById(visitorManagement.getVisitorVisitedLocation().getId()));
//        visitorManagement.setLocationMaster(locationMasterService.readById(visitorManagement.getLocationMaster().getId()));
        visitorManagement.setRejectRemark(visitorManagement.getRejectRemark());
        mv.getModelMap().put("visitorManagement", visitorManagement);
        request.setAttribute("employeeMaster", employeeMaster);
        mv.setViewName("VisitorManagement/EmpView");
        return mv;
    }

    public ModelAndView returnCreateSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        VisitorManagement visitorManagement = new VisitorManagement();
        VisitorManagement visitorManagement1 = new VisitorManagement();
        LocationMaster locationMaster = new LocationMaster();
        VisitorVisitedLocation visitorVisitedLocation = new VisitorVisitedLocation();
        String location = request.getParameter("visitorVisitedLocation.id");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        BindException errors = new BindException(visitorManagement, "visitorManagement");
        bind(request, visitorManagement1);
//        visitorManagementValidator.validate(visitorManagement, errors);
//        readlocation(request, response);
        String incomingDateTime = visitorManagement1.getIncomingDateTime();
        Date iDate = sdf.parse(incomingDateTime);
        Date tDate = new Date();
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : Mandatory Fields should not be blank.");
            mv.addAllObjects(errors.getModel());
            mv.setViewName("VisitorManagement/EmpView");
        } else {
            String id = request.getParameter("id");
            if (visitorManagement1.getId() == null) {
                visitorManagement = visitorManagementService.readById(Integer.parseInt(id));
            }
            if (visitorManagement.getStatus() == 4) {
                String requestdate = sdf.format(new Date());
                visitorManagement.setRequestDate(requestdate);
                visitorManagement.setStatus(5);
                visitorManagement.setVisitorOrganization(visitorManagement1.getVisitorOrganization());
                visitorManagement.setVisitorName(visitorManagement1.getVisitorName());
                visitorManagement.setVisitorContactDetail(visitorManagement1.getVisitorContactDetail());
                visitorManagement.setVisitorComingFrom(visitorManagement1.getVisitorComingFrom());
                visitorManagement.setReason(visitorManagement1.getReason());
                visitorManagement.setIncomingDateTime(visitorManagement1.getIncomingDateTime());
                visitorManagement.setAccesories(visitorManagement1.getAccesories());
                if (location.equals("")) {
                    visitorVisitedLocation = visitorManagement.getVisitorVisitedLocation();
                    visitorManagement.setVisitorVisitedLocation(visitorVisitedLocation);
                } else {
                    visitorVisitedLocation = visitorVisitedLocationService.readById(Integer.parseInt(location));
                    visitorManagement.setVisitorVisitedLocation(visitorVisitedLocation);
                }
                visitorManagementService.update(visitorManagement);
                request.setAttribute("successMessage",
                        "Information :Return Request Sent Successfully.");
                mv.getModelMap().put("visitorManagement", visitorManagement);
                mv = searchSubmit(request, response);
            }
//   empwithdraw
            if (visitorManagement.getStatus() == 1 || visitorManagement.getStatus() == 2) {
                if (visitorManagement.getStatus() == 1) {
                    visitorManagementService.delete(Integer.parseInt(id));
                    request.setAttribute("successMessage",
                            "Information : Request Withdrawed Successfully.");
                    mv = searchSubmit(request, response);
                } else if (visitorManagement.getStatus() == 2) {
                    visitorManagement.setStatus(8);
                    visitorManagement.setReason(visitorManagement1.getReason());
                    visitorManagementService.update(visitorManagement);
                    request.setAttribute("successMessage",
                            "Information : Withdraw Request Sent Successfully.");
                    mv.getModelMap().put("visitorManagement", visitorManagement);
                    mv = searchSubmit(request, response);
                }
            }
//  withdrawreturnSubmit
//            if (visitorManagement.getStatus() == 9) {
//                visitorManagement = visitorManagementService.readById(Integer.parseInt(id));
//                visitorManagement.setStatus(10);
//                visitorManagement.setReason(visitorManagement1.getReason());
//                visitorManagementService.update(visitorManagement);
//                request.setAttribute("successMessage",
//                        "Information : Withdraw Return Request Sent Successfully.");
//                mv.getModelMap().put("visitorManagement", visitorManagement);
//                mv = searchSubmit(request, response);
//            }
        }
        return mv;
    }

    //    <---------Withdraw Cycle---------->
//    public ModelAndView adminAprrovewithdrawClick(HttpServletRequest request,
//            HttpServletResponse response) throws Exception {
//        ModelAndView mv = new ModelAndView();
//        VisitorManagement visitorManagement = new VisitorManagement();
//        String id = request.getParameter("id");
//        String statusType = request.getParameter("statusType");
//        String remark = request.getParameter("securityRemark");
//        bind(request, visitorManagement);
//        visitorManagement = visitorManagementService.readById(Integer.parseInt(id));
//        if (null != statusType) {
//            if (statusType.equals("7")) {
//                visitorManagement.setStatus(7);
//                visitorManagement.setSecurityRemark(remark);
//                request.setAttribute("successMessage",
//                        "Information :Withdraw Request Rejected Successfully.");
//            } else if (statusType.equals("9")) {
//                visitorManagement.setStatus(9);
//                visitorManagement.setSecurityRemark(remark);
//                request.setAttribute("successMessage",
//                        "Information :Withdraw Request Returned Successfully.");
//            }
//        } else {
//            visitorManagement.setStatus(8);
//            request.setAttribute("successMessage",
//                    "Information :Withdraw Request Approved Successfully.");
//        }
//        visitorManagementService.update(visitorManagement);
//        mv.getModelMap().put("visitorManagement", visitorManagement);
//        mv = securityApproveSubmit(request, response);
//        return mv;
//    }
    //    <---------Search---------->
    public ModelAndView searchEmpClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        VisitorManagement visitorManagement = new VisitorManagement();
        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
        mv.getModelMap().put("visitorManagement", visitorManagement);
        request.setAttribute("empName", employeeMaster.getEmployeeName());
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.setViewName("VisitorManagement/VisitorSearch");
        return mv;
    }

//    public ModelAndView searchEmpResult(HttpServletRequest request,
//            HttpServletResponse response) throws Exception {
//        ModelAndView mv = new ModelAndView();
//        VisitorManagement visitorManagement = new VisitorManagement();
//
//        String startDate = request.getParameter("startDate");
//        String endDate = request.getParameter("endDate");
//        String status = request.getParameter("status");
//
//        HttpSession session = request.getSession();
//        EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
//        String empId = employeeMaster.getId().toString();
//        if (!"".equals(empId)) {
//            employeeMaster.setId(Integer.parseInt(empId));
//        }
//        visitorManagement.setEmployeeMasterByEmployeeMasterId(employeeMaster);
//        if (!"".equals(status)) {
//            visitorManagement.setSecurityRemark(status);
//        }
//        if (!"".equals(startDate)) {
//            visitorManagement.setApproverDate(startDate);
//        }
//        if (!"".equals(endDate)) {
//            visitorManagement.setRequestDate(endDate);
//        }
//        List<?> visitorlist = visitorManagementService.readSearchEmpRequest(visitorManagement);
//        mv.getModelMap().put("visitorManagement", visitorManagement);
//        mv.addObject("visitorlist", visitorlist);
//        mv.setViewName("VisitorManagement/VisitorResult");
//        return mv;
//    }
    public ModelAndView searchAdminClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        VisitorManagement visitorManagement = new VisitorManagement();
        mv.getModelMap().put("visitorManagement", visitorManagement);
        EmployeeMaster employeeMaster = new EmployeeMaster();
        selectEmployee(request, response);
        departmentList(request);
        designationList(request);
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.setViewName("VisitorManagement/SecurityVisitorSearch");
        return mv;
    }

    public ModelAndView searchAdminResult(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        VisitorManagement visitorManagement = new VisitorManagement();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        String empId = request.getParameter("employeeName");
        String departmentId = request.getParameter("departmentMaster");
        String designationId = request.getParameter("designationMaster");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String status = request.getParameter("status");
        List<?> Approverlist1 = visitorManagementService.readByapproverId(visitorManagement);
        selectEmployee(request, response);
        departmentList(request);
        designationList(request);

        if (!empId.equals("")) {
            employeeMaster.setId(Integer.parseInt(empId));
        }
        visitorManagement.setEmployeeMasterByEmployeeMasterId(employeeMaster);
        if (!departmentId.equals("")) {
            visitorManagement.setReason(departmentId);
        }
        if (!designationId.equals("")) {
            visitorManagement.setRejectRemark(designationId);
        }
        if (!status.equals("")) {
            visitorManagement.setSecurityRemark(status);
        }
        if (!startDate.equals("")) {
            visitorManagement.setApproverDate(startDate);
        }
        if (!endDate.equals("")) {
            visitorManagement.setRequestDate(endDate);
        }
        List<?> Approverlist = visitorManagementService.readSearchRequest(visitorManagement);
        mv.getModelMap().put("visitorManagement", visitorManagement);
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.getModelMap().put("Approverlist1", Approverlist1);
        mv.addObject("Approverlist", Approverlist);
        request.setAttribute("flag", 1);
        request.setAttribute("Approverlist", Approverlist);
        mv = securityApproveSubmit(request, response);
//        mv.setViewName("VisitorManagement/SecurityResult");
        return mv;
    }

    public ModelAndView userDashboardVisitorManagementPendingRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        VisitorManagement visitorManagement = new VisitorManagement();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        visitorManagement.setEmployeeMasterByEmployeeMasterId(employeeMaster);

        //----------comment and update by uday----------from----//
//        List<?> list = visitorManagementService.readVisitorManagementPendingRequest(visitorManagement);
//        int visitorPendingRequest = list.size();
//        List<?> list1 = visitorManagementService.readVisitorManagementApproverPendingRequest(visitorManagement);
//        int visitorApproverPendingRequest = list1.size();
        int visitorPendingRequest = visitorManagementService.countVisitorManagementPendingRequest(visitorManagement);
        int visitorApproverPendingRequest = visitorManagementService.countVisitorManagementApproverPendingRequest(visitorManagement);
        //----------------to-------------------//
        request.setAttribute("visitorPendingRequest", visitorPendingRequest);
        request.setAttribute("visitorApproverPendingRequest", visitorApproverPendingRequest);
        mv.setViewName("forward:gatePass.htm?act=userDashboardGetPassPendingRequest");
        return mv;
    }

    public ModelAndView searchVisitorPendingSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        VisitorManagement visitorManagement = new VisitorManagement();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        visitorManagement.setEmployeeMasterByEmployeeMasterId(employeeMaster);
        List<?> visitorlist = visitorManagementService.readVisitorManagementPendingRequest(visitorManagement);
        visitorManagement.setEmployeeMasterByEmployeeMasterId(employeeMaster);

        mv.getModelMap().put("visitorlist", visitorlist);
        mv.getModelMap().put("visitorManagement", visitorManagement);
        mv.setViewName("VisitorManagement/VisitorResultDashboard");
        return mv;
    }

    public ModelAndView exportToExcel(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
//        VisitorManagement visitorManagement = new VisitorManagement();
//        EmployeeMaster employeeMaster = new EmployeeMaster();
//        String id = request.getParameter("id");
//        List<?> Approverlist = visitorManagementService.readByapproverId(visitorManagement);
//        selectEmployee(request, response);
//        departmentList(request);
//        designationList(request);
//        searchAdminResult(request, response);
//        List<?> Approverlist = (List<?>) request.getSession().getAttribute("Approverlist11");
        List<?> Approverlist = (List<?>) request.getSession().getAttribute("ApproverListForSession");
        response.setContentType("application/vnd.ms-excel");
//        response.setHeader("Content-Disposition", "attachment; filename=LeaveRequest.xls");
        response.setHeader("Content-Disposition", "attachment; filename=VisitorDetails.xls");
        response.setContentType("application/vnd.ms-excel");
        mv.addObject("Approverlist", Approverlist);
//        mv.getModelMap().put("Approverlist", Approverlist);
//        mv.getModelMap().put("employeeMaster", employeeMaster);
//        mv.getModelMap().put("visitorManagement", visitorManagement);
        mv.setViewName("VisitorManagement/ExportSecurityResult");
        return mv;
    }
     public void getAutoCompleteDataByContact(HttpServletRequest request, HttpServletResponse response) throws JSONException, IOException {
        String contactNo = request.getParameter("contact");
        Boolean gotError = true;
        try {
            BigInteger number = new BigInteger(contactNo);
            gotError = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (gotError.equals(false)) {
            PrintWriter out = response.getWriter();
            List<VisitorManagement> vm = (List<VisitorManagement>) visitorManagementService.getDetailsByContactNo(contactNo);
            JSONObject jObject = new JSONObject();
            jObject.put("name", vm.get(0).getVisitorName());
            jObject.put("visitorFrom", vm.get(0).getVisitorComingFrom());
            jObject.put("organization", vm.get(0).getVisitorOrganization());
            
            
            out.println(jObject.toString());
        }
    }

}
//
//   //    <--------- Approver---------->
//
//    public ModelAndView searchApproverSubmit(HttpServletRequest request,
//            HttpServletResponse response) throws Exception{
//        ModelAndView mv = new ModelAndView();
//        VisitorManagement visitorManagement = new VisitorManagement();
//        String id = request.getParameter("id");
//        HttpSession session = request.getSession();
//        EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
//        visitorManagement.setEmployeeMasterByApproverId(employeeMaster);
//        List<?> Approverlist = visitorManagementService.readByrequesteeId(visitorManagement);
//        mv.getModelMap().put("Approverlist",Approverlist );
//        mv.getModelMap().put("visitorManagement",visitorManagement );
//        mv.setViewName("VisitorManagement/VisitorApproverResult");
//        return mv;
//    }
//    
//      public ModelAndView viewClick(HttpServletRequest request,
//            HttpServletResponse response) throws Exception{
//        ModelAndView mv = new ModelAndView();
//        VisitorManagement visitorManagement = new VisitorManagement();
//        EmployeeMaster employeeMaster = new EmployeeMaster();
//        String id = request.getParameter("id");
//        String empId = request.getParameter("empId");
//        readlocation(request, response);
//        employeeMaster = employeeMasterService.readById(Integer.parseInt(empId));
//          employeeMaster.getReportingManagerLevel1();
//        List<?> list = employeeMasterService.readManagerLevel1(employeeMaster);
//        if(!list.isEmpty()){
//            request.setAttribute("reportingLevel1", list.get(0));
//        }
//        bind(request, visitorManagement);
//        visitorManagement = visitorManagementService.readById(Integer.parseInt(id));
//        employeeMaster.setDepartmentMaster(departmentMasterService.readById(employeeMaster.getDepartmentMaster().getId()));
//        employeeMaster.setDesignationMaster(designationMasterService.readById(employeeMaster.getDesignationMaster().getId()));
//        employeeMaster.setLevelMaster(levelMasterService.readById(employeeMaster.getLevelMaster().getId()));
//        employeeMaster.setLocationMaster(locationMasterService.readById(employeeMaster.getLocationMaster().getId()));
//        visitorManagement.setLocationMaster(locationMasterService.readById(visitorManagement.getLocationMaster().getId()));
//        mv.getModelMap().put("visitorManagement",visitorManagement);
//        request.setAttribute("employeeMaster", employeeMaster);
//        mv.setViewName("VisitorManagement/ViewVisitorRequest");
//        return mv;  
//      }
//    
//       public ModelAndView aprroveClick(HttpServletRequest request,
//            HttpServletResponse response) throws Exception {
//        ModelAndView mv = new ModelAndView();
//       VisitorManagement visitorManagement  = new VisitorManagement();
//       String id = request.getParameter("id");
//        String statusType = request.getParameter("statusType");
//        String remark = request.getParameter("rejectRemark");
//        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
//        bind(request, visitorManagement);
//        visitorManagement = visitorManagementService.readById(Integer.parseInt(id));
//        String approveDate = sdf.format(new Date());
//        visitorManagement.setApproverDate(approveDate);
//        HttpSession session = request.getSession();
//        EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
//        employeeMaster.setDepartmentMaster(departmentMasterService.readById(employeeMaster.getDepartmentMaster().getId()));
//        employeeMaster.setDesignationMaster(designationMasterService.readById(employeeMaster.getDesignationMaster().getId()));
//        employeeMaster.setLevelMaster(levelMasterService.readById(employeeMaster.getLevelMaster().getId()));
//        employeeMaster.setLocationMaster(locationMasterService.readById(employeeMaster.getLocationMaster().getId()));
//        visitorManagement.setEmployeeMasterByApproverId(employeeMaster);
//         if(null != statusType){
//        if(statusType.equals("3")){
//        visitorManagement.setStatus(3);
//        visitorManagement.setRejectRemark(remark);
//        request.setAttribute("successMessage",
//                    "Information : Request Rejected Successfully.");
//        }else if(statusType.equals("6")){
//        visitorManagement.setStatus(6);
//        visitorManagement.setRejectRemark(remark);
//        request.setAttribute("successMessage",
//                    "Information : Request Returned Successfully.");
//        }   
//         }
//        else{
//        visitorManagement.setStatus(2);
//        request.setAttribute("successMessage",
//                    "Information : Request Approved Successfully.");
//        }
//         visitorManagementService.createOrUpdate(visitorManagement);
//        mv.getModelMap().put("employeeMaster",employeeMaster );  
//         mv.getModelMap().put("visitorManagement",visitorManagement);
//         mv = searchApproverSubmit(request, response);
//        return mv;
//       }
//<--------- ApproverReturnCycle---------->
//        public ModelAndView aprroveReturnClick(HttpServletRequest request,
//            HttpServletResponse response) throws Exception {
//        ModelAndView mv = new ModelAndView();
//        VisitorManagement visitorManagement  = new VisitorManagement();
//        String id = request.getParameter("id");
//        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
//        bind(request, visitorManagement);
//        visitorManagement = visitorManagementService.readById(Integer.parseInt(id));
//        String approvedate = sdf.format(new Date());
//        visitorManagement.setApproverDate(approvedate);
//        HttpSession session = request.getSession();
//        EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
//        employeeMaster.setDepartmentMaster(departmentMasterService.readById(employeeMaster.getDepartmentMaster().getId()));
//        employeeMaster.setDesignationMaster(designationMasterService.readById(employeeMaster.getDesignationMaster().getId()));
//        employeeMaster.setLevelMaster(levelMasterService.readById(employeeMaster.getLevelMaster().getId()));
//        employeeMaster.setLocationMaster(locationMasterService.readById(employeeMaster.getLocationMaster().getId()));
//        visitorManagement.setEmployeeMasterByApproverId(employeeMaster);
//        visitorManagement.setStatus(9);
//        request.setAttribute("successMessage",
//                    "Information : Request Approved Successfully.");
//        visitorManagementService.createOrUpdate(visitorManagement);
//        mv.getModelMap().put("visitorManagement",visitorManagement);
//        mv = searchApproverSubmit(request, response);
//        return mv;
//         }
//<--------- ApproverWithdrawCycle---------->

//  public ModelAndView approverwithdraw(HttpServletRequest request,
//           HttpServletResponse response) throws Exception {
//        ModelAndView mv = new ModelAndView();
//        VisitorManagement visitorManagement = new VisitorManagement();
//        String id = request.getParameter("id");
//        String statusType = request.getParameter("statusType");
//        String remark = request.getParameter("rejectRemark");
//        bind(request, visitorManagement);
//        visitorManagement = visitorManagementService.readById(Integer.parseInt(id));
//        if(null != statusType){
//        if(statusType.equals("13")){
//        visitorManagement.setStatus(13);
//        visitorManagement.setRejectRemark(remark);
//        request.setAttribute("successMessage",
//                    "Information :Withdraw Request Rejected Successfully.");
//        }   
//        else if(statusType.equals("16")){
//        visitorManagement.setStatus(16);
//        visitorManagement.setRejectRemark(remark);
//        request.setAttribute("successMessage",
//                    "Information :Withdraw Request Returned Successfully.");
//        }
//          }
//        else{
//         visitorManagement.setStatus(12);
//        request.setAttribute("successMessage",
//                    "Information :Withdraw Request Approved Successfully.");
//        }
//        visitorManagementService.createOrUpdate(visitorManagement);
//        mv.getModelMap().put("visitorManagement",visitorManagement);
//        mv = searchApproverSubmit(request, response);
//        return mv;
//     }
//<--------- ApproverWithdrawReturnCycle---------->
//   public ModelAndView withdrawapprovereturn(HttpServletRequest request,
//           HttpServletResponse response) throws Exception {
//        ModelAndView mv = new ModelAndView();
//           VisitorManagement visitorManagement = new VisitorManagement();
//          String id = request.getParameter("id");
//          bind(request, visitorManagement);
//          visitorManagement = visitorManagementService.readById(Integer.parseInt(id));
//          visitorManagement.setStatus(19);
//          request.setAttribute("successMessage",
//                    "Information :Withdraw Request Approved Successfully.");
//        visitorManagementService.update(visitorManagement);
//        mv.getModelMap().put("visitorManagement",visitorManagement);
//        mv = searchApproverSubmit(request, response);
//        return mv;
////     }
