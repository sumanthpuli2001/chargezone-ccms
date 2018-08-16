/*
 * 
 * Author Vinita
 */
package com.bul.zydex.controller.emprequest;

import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.model.EmailTemplate;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.HrServiceRequest;
import com.bul.zydex.model.QueryType;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Vinita
 */
public class HrServiceRequestController extends HrServiceRequestAbstract {

    public ModelAndView searchSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HrServiceRequest hrServiceRequest = new HrServiceRequest();
//         HttpSession session = request.getSession();
//        EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
//        hrServiceRequest.setEmployeeMasterByEmployeeMasterId(employeeMaster);
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");

        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
        String empId = employeeMaster.getId().toString();
        if (!empId.equals("")) {
            employeeMaster.setId(Integer.parseInt(empId));
        }
        hrServiceRequest.setEmployeeMasterByEmployeeMasterId(employeeMaster);
        if (!"".equals(startDate) && null != startDate) {
            hrServiceRequest.setRequestDate(startDate);
        }
        if (!"".equals(endDate) && null != endDate) {
            hrServiceRequest.setHrApproveDate(endDate);
        }
        List<?> list = hrServiceRequestService.readByEmpId(hrServiceRequest);
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("hrServiceRequest", hrServiceRequest);
        mv.setViewName("HrService/HrServiceResult");
        return mv;
    }

    public ModelAndView createClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HrServiceRequest hrServiceRequest = new HrServiceRequest();
        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
        employeeMaster.getReportingManagerLevel1();
        if (employeeMaster.getReportingManagerLevel1() != "") {
            List<?> list = employeeMasterService.readManagerLevel1(employeeMaster);
            if (!list.isEmpty()) {
                request.setAttribute("reportingLevel1", list.get(0));
            }
            employeeMaster.setDepartmentMaster(departmentMasterService.readById(employeeMaster.getDepartmentMaster().getId()));
            employeeMaster.setDesignationMaster(designationMasterService.readById(employeeMaster.getDesignationMaster().getId()));
            employeeMaster.setLevelMaster(levelMasterService.readById(employeeMaster.getLevelMaster().getId()));
            employeeMaster.setLocationMaster(locationMasterService.readById(employeeMaster.getLocationMaster().getId()));
            hrServiceRequest.setEmployeeMasterByEmployeeMasterId(employeeMaster);
            QueryType queryType = new QueryType();
            hrServiceRequest.setQueryType(queryType);
            readquerytype(request, response);
            mv.getModelMap().put("employeeMaster", employeeMaster);
            mv.getModelMap().put("hrServiceRequest", hrServiceRequest);
            mv.setViewName("HrService/HrServiceCreate");
            return mv;
        } else {
            mv = searchSubmit(request, response);
            request.setAttribute("failureMessage",
                    "Error : Access Denied, Please Contact To Administrator");
            return mv;
        }
    }

    public ModelAndView createSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HrServiceRequest hrServiceRequest = new HrServiceRequest();
        BindException errors = new BindException(hrServiceRequest, "hrServiceRequest");
        bind(request, hrServiceRequest);
        Integer empid = hrServiceRequest.getEmployeeMasterByEmployeeMasterId().getId();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        employeeMaster = employeeMasterService.readById(empid);
        List<?> list = employeeMasterService.readManagerLevel1(employeeMaster);
        if (!list.isEmpty()) {
            request.setAttribute("reportingLevel1", list.get(0));
        }
        boolean flag = false;
        hrServiceRequestValidator.validate(hrServiceRequest, errors);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        readquerytype(request, response);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : Mandatory Fields should not be blank.");
            mv.addAllObjects(errors.getModel());
            mv.getModelMap().put("hrServiceRequest", hrServiceRequest);
            mv.setViewName("HrService/HrServiceCreate");
        } else {
            String requestdate = sdf.format(new Date());
            hrServiceRequest.setRequestDate(requestdate);
            hrServiceRequest.setStatus(1);
            QueryType queryType = new QueryType();
            String query = request.getParameter("queryType.id");
            if (queryType.getId() == null && query == "") {
                request.setAttribute("failureMessage", "Error :Select Query Type");
                mv.getModelMap().put("hrServiceRequest", hrServiceRequest);
                mv.setViewName("HrService/HrServiceCreate");
            } else {
                queryType = queryTypeService.readById(Integer.parseInt(query));
                hrServiceRequest.setQueryType(queryType);
                if (!hrServiceRequestService.isExist(hrServiceRequest)) {
                    hrServiceRequestService.create(hrServiceRequest);
                    request.setAttribute("successMessage",
                            "Information : Request Sent Successfully.");
                    request.setAttribute("hrServiceRequest", hrServiceRequest);
                    //    Email Sent to HR
                    List<?> HRList = userRightMasterService.readHRList();
                    for (Object o : HRList) {
                        Object[] o1 = (Object[]) o;
                        int HRId = (int) o1[0];
                        try {
                            EmailTemplate emailTemplate = new EmailTemplate();
                            EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                            DesignationMaster designationMaster = new DesignationMaster();
                            designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                            EmployeeMaster employeeMasterHr = new EmployeeMaster();
                            employeeMasterHr = employeeMasterService.readById(HRId);
                            // id 49 is for status HR Service Request Apply
                            emailTemplate = emailTemplateService.readById(49);
                            String To = employeeMasterHr.getOfficeEmailId();
                            String from = employeeMasterModel.getOfficeEmailId();
                            String Subject = emailTemplate.getSubject();
                            Subject = Subject.replaceAll("\\{user\\}", employeeMasterModel.getEmployeeName());
                            String msg = emailTemplate.getBodytext();
                            msg = msg.replaceAll("\\{to_user\\}", employeeMasterHr.getEmployeeName());
                            msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                            msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                            sendMail.sendMail(from, To, Subject, msg);
                        } catch (Exception e) {

                        }
                    }
                } else {
                    flag = true;
                    request.setAttribute("failureMessage",
                            "Error : Request Already Exists");
                }
                mv = searchSubmit(request, response);
            }
        }
        return mv;
    }

    public ModelAndView approverClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HrServiceRequest hrServiceRequest = new HrServiceRequest();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        selectEmployee(request, response);
        departmentList(request);
        designationList(request);
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        String empId = request.getParameter("employeeName");
        String departmentId = request.getParameter("departmentMaster");
        String designationId = request.getParameter("designationMaster");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");

        if (!"".equals(empId) && null != empId) {
            employeeMaster1.setId(Integer.parseInt(empId));
        }
        hrServiceRequest.setEmployeeMasterByEmployeeMasterId(employeeMaster1);
        if (!"".equals(departmentId) && null != departmentId) {
            hrServiceRequest.setDetails(departmentId);
        }
        if (!"".equals(designationId) && null != designationId) {
            hrServiceRequest.setHrApproveDate(designationId);
        }
//        if (!status.equals("")) {
//           hrServiceRequest.setRejectRemark(status);
//        }
        if (!"".equals(startDate) && null != startDate) {
            hrServiceRequest.setRequestDate(startDate);
        }
        if (!"".equals(endDate) && null != endDate) {
            hrServiceRequest.setRejectRemark(endDate);
        }
        List<?> hrlist = hrServiceRequestService.readByrequesteeId(hrServiceRequest);
        mv.getModelMap().put("hrlist", hrlist);
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.getModelMap().put("hrServiceRequest", hrServiceRequest);
        HttpSession session = request.getSession();
        session.setAttribute("hrApprovelist", hrlist);
        mv.setViewName("HrService/HrApproveResult");
        return mv;
    }

    public ModelAndView viewClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HrServiceRequest hrServiceRequest = new HrServiceRequest();
        QueryType queryType = new QueryType();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        String id = request.getParameter("id");
        String empId = request.getParameter("empId");
        employeeMaster = employeeMasterService.readById(Integer.parseInt(empId));
        employeeMaster.getReportingManagerLevel1();
        List<?> list = employeeMasterService.readManagerLevel1(employeeMaster);
        if (!list.isEmpty()) {
            request.setAttribute("reportingLevel1", list.get(0));
        }
        bind(request, hrServiceRequest);
        hrServiceRequest = hrServiceRequestService.readById(Integer.parseInt(id));
        employeeMaster.setDepartmentMaster(departmentMasterService.readById(employeeMaster.getDepartmentMaster().getId()));
        employeeMaster.setDesignationMaster(designationMasterService.readById(employeeMaster.getDesignationMaster().getId()));
        employeeMaster.setLevelMaster(levelMasterService.readById(employeeMaster.getLevelMaster().getId()));
        employeeMaster.setLocationMaster(locationMasterService.readById(employeeMaster.getLocationMaster().getId()));
        hrServiceRequest.setQueryType(queryTypeService.readById(hrServiceRequest.getQueryType().getId()));
        mv.getModelMap().put("hrServiceRequest", hrServiceRequest);
        request.setAttribute("employeeMaster", employeeMaster);
        mv.setViewName("HrService/HrView");
        return mv;
    }

    public ModelAndView approveSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HrServiceRequest hrServiceRequest = new HrServiceRequest();
        String id = request.getParameter("id");
        String statusType = request.getParameter("statusType");
        String remark = request.getParameter("rejectRemark");
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        bind(request, hrServiceRequest);
        hrServiceRequest = hrServiceRequestService.readById(Integer.parseInt(id));
        String approvedate = sdf.format(new Date());
        hrServiceRequest.setHrApproveDate(approvedate);

        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
        employeeMaster.setDepartmentMaster(departmentMasterService.readById(employeeMaster.getDepartmentMaster().getId()));
        employeeMaster.setDesignationMaster(designationMasterService.readById(employeeMaster.getDesignationMaster().getId()));
        employeeMaster.setLevelMaster(levelMasterService.readById(employeeMaster.getLevelMaster().getId()));
        employeeMaster.setLocationMaster(locationMasterService.readById(employeeMaster.getLocationMaster().getId()));
        hrServiceRequest.setEmployeeMasterByHrApproveId(employeeMaster);
//         if(null != statusType){
//        if(statusType.equals("3")){
//        hrServiceRequest.setStatus(3);
//        hrServiceRequest.setRejectRemark(remark);
//        request.setAttribute("successMessage",
//                    "Information : Request Rejected Successfully.");
//        }   
//        else if(statusType.equals("4")){
//        hrServiceRequest.setStatus(4);
//        hrServiceRequest.setRejectRemark(remark);
//        request.setAttribute("successMessage",
//                    "Information : Request Returned Successfully.");
//        
//        }
//          }
//        else{
        hrServiceRequest.setStatus(2);
        request.setAttribute("successMessage",
                "Information : Request Closed Successfully.");
//        }
        hrServiceRequestService.update(hrServiceRequest);
        mv.getModelMap().put("hrServiceRequest", hrServiceRequest);
        mv = approverClick(request, response);
        return mv;
    }

//         <---------Return Cycle---------->
    public ModelAndView EmpviewClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HrServiceRequest hrServiceRequest = new HrServiceRequest();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        String id = request.getParameter("id");
        readquerytype(request, response);
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
        bind(request, hrServiceRequest);
        hrServiceRequest = hrServiceRequestService.readById(Integer.parseInt(id));
        hrServiceRequest.setQueryType(queryTypeService.readById(hrServiceRequest.getQueryType().getId()));
        mv.getModelMap().put("hrServiceRequest", hrServiceRequest);
        request.setAttribute("employeeMaster", employeeMaster);
        mv.setViewName("HrService/EmpView");
        return mv;
    }

    public ModelAndView returnCreateSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HrServiceRequest hrServiceRequest = new HrServiceRequest();
        HrServiceRequest hrServiceRequest1 = new HrServiceRequest();
        String id = request.getParameter("id");
        BindException errors = new BindException(hrServiceRequest, "hrServiceRequest");
        bind(request, hrServiceRequest1);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : Mandatory Fields should not be blank.");
            mv.addAllObjects(errors.getModel());
            mv.setViewName("HrService/EmpView");
        } else {
            if (hrServiceRequest1.getId() == null) {
                hrServiceRequest = hrServiceRequestService.readById(Integer.parseInt(id));
            }
            if (hrServiceRequest.getStatus() == 4) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                String requestdate = sdf.format(new Date());
                hrServiceRequest.setRequestDate(requestdate);
                hrServiceRequest.setStatus(5);
                hrServiceRequest.setDetails(hrServiceRequest1.getDetails());
                QueryType queryType = new QueryType();
                String query = request.getParameter("queryType");
                queryType = queryTypeService.readById(Integer.parseInt(query));
                hrServiceRequest.setQueryType(queryType);
                hrServiceRequestService.update(hrServiceRequest);
                request.setAttribute("successMessage",
                        "Information : Request Sent Successfully.");
                mv.getModelMap().put("hrServiceRequest", hrServiceRequest);
                mv = searchSubmit(request, response);
            }
//   empwithdraw
            if (hrServiceRequest.getStatus() == 1 || hrServiceRequest.getStatus() == 2) {
                if (hrServiceRequest.getStatus() == 1) {
                    hrServiceRequestService.delete(Integer.parseInt(id));
                    request.setAttribute("successMessage",
                            "Information : Request Withdrawed Successfully.");
                    mv = searchSubmit(request, response);
                } else if (hrServiceRequest.getStatus() == 2) {
                    hrServiceRequest.setStatus(6);
                    hrServiceRequest.setDetails(hrServiceRequest1.getDetails());
                    hrServiceRequestService.update(hrServiceRequest);
                    request.setAttribute("successMessage",
                            "Information : Withdraw Request Sent Successfully.");
                    mv = searchSubmit(request, response);
                }
            }
//    withdrawreturnSubmit  
            if (hrServiceRequest.getStatus() == 9) {
                hrServiceRequest.setStatus(10);
                hrServiceRequest.setDetails(hrServiceRequest1.getDetails());
                hrServiceRequestService.update(hrServiceRequest);
                request.setAttribute("successMessage",
                        "Information : Request Sent Successfully.");
                mv.getModelMap().put("hrServiceRequest", hrServiceRequest);
                mv = searchSubmit(request, response);
            }
        }
        return mv;
    }

    //    <---------Withdraw Cycle---------->
    public ModelAndView approverwithdraw(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HrServiceRequest hrServiceRequest = new HrServiceRequest();
        String id = request.getParameter("id");
        String statusType = request.getParameter("statusType");
        String remark = request.getParameter("rejectRemark");
        bind(request, hrServiceRequest);
        hrServiceRequest = hrServiceRequestService.readById(Integer.parseInt(id));
        if (null != statusType) {
            if (statusType.equals("7")) {
                hrServiceRequest.setStatus(7);
                hrServiceRequest.setRejectRemark(remark);
                request.setAttribute("successMessage",
                        "Information :Withdraw Request Rejected Successfully.");
            } else if (statusType.equals("9")) {
                hrServiceRequest.setStatus(9);
                hrServiceRequest.setRejectRemark(remark);
                request.setAttribute("successMessage",
                        "Information :Withdraw Request Returned Successfully.");

            }
        } else {
            hrServiceRequest.setStatus(8);
            request.setAttribute("successMessage",
                    "Information :Withdraw Request Approved Successfully.");
        }
        hrServiceRequestService.update(hrServiceRequest);
        mv.getModelMap().put("hrServiceRequest", hrServiceRequest);
        mv = approverClick(request, response);
        return mv;
    }

    //    <---------Search---------->
    public ModelAndView searchEmpClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HrServiceRequest hrServiceRequest = new HrServiceRequest();
        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
        mv.getModelMap().put("hrServiceRequest", hrServiceRequest);
        request.setAttribute("empName", employeeMaster.getEmployeeName());
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.setViewName("HrService/EmpSearch");
        return mv;
    }

    public ModelAndView searchEmpResult(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HrServiceRequest hrServiceRequest = new HrServiceRequest();
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String status = request.getParameter("status");

        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
        String empId = employeeMaster.getId().toString();
        if (!empId.equals("")) {
            employeeMaster.setId(Integer.parseInt(empId));
        }
        hrServiceRequest.setEmployeeMasterByEmployeeMasterId(employeeMaster);
        if (!status.equals("")) {
            hrServiceRequest.setRejectRemark(status);
        }
        if (!startDate.equals("")) {
            hrServiceRequest.setRequestDate(startDate);
        }
        if (!endDate.equals("")) {
            hrServiceRequest.setHrApproveDate(endDate);
        }
        List<?> list = hrServiceRequestService.readSearchEmpRequest(hrServiceRequest);
        mv.getModelMap().put("hrServiceRequest", hrServiceRequest);
        mv.getModelMap().put("list", list);
        mv.setViewName("HrService/EmpSearchResult");
        return mv;
    }

    public ModelAndView searchHrClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HrServiceRequest hrServiceRequest = new HrServiceRequest();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        selectEmployee(request, response);
        departmentList(request);
        designationList(request);
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.getModelMap().put("hrServiceRequest", hrServiceRequest);
        mv.setViewName("HrService/HrSearch");
        return mv;
    }

    public ModelAndView searchHrResult(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HrServiceRequest hrServiceRequest = new HrServiceRequest();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        String empId = request.getParameter("employeeName");
        String departmentId = request.getParameter("departmentMaster");
        String designationId = request.getParameter("designationMaster");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String status = request.getParameter("status");

        if (!empId.equals("")) {
            employeeMaster.setId(Integer.parseInt(empId));
        }
        if (!departmentId.equals("")) {
            hrServiceRequest.setDetails(departmentId);
        }
        if (!designationId.equals("")) {
            hrServiceRequest.setHrApproveDate(designationId);
        }
        if (!status.equals("")) {
            hrServiceRequest.setRejectRemark(status);
        }
        if (!startDate.equals("")) {
            hrServiceRequest.setRequestDate(startDate);
        }
        if (!endDate.equals("")) {
            employeeMaster.setAdharCard(endDate);
        }
        hrServiceRequest.setEmployeeMasterByEmployeeMasterId(employeeMaster);
        List<?> list = hrServiceRequestService.readSearchRequest(hrServiceRequest);
        mv.getModelMap().put("hrServiceRequest", hrServiceRequest);
        mv.getModelMap().put("list", list);
        mv.setViewName("HrService/HrSearchResult");
        return mv;
    }

    public ModelAndView userDashboardHrServicePendingRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HrServiceRequest hrServiceRequest = new HrServiceRequest();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        hrServiceRequest.setEmployeeMasterByEmployeeMasterId(employeeMaster);

        //----------comment and update by uday-----------from--------//
//        List<?> list = hrServiceRequestService.readHrServicePendingRequest(hrServiceRequest);
//        int hrServicePending=list.size();
//        request.setAttribute("hrServicePending", hrServicePending);
//        List<?> list1 = hrServiceRequestService.readHrServiceApproverPendingRequest(hrServiceRequest);
//        int heServiceApproverPending=list1.size();
//        request.setAttribute("heServiceApproverPending", heServiceApproverPending);
        int hrServicePending = hrServiceRequestService.countHrServicePendingRequest(hrServiceRequest);
        request.setAttribute("hrServicePending", hrServicePending);
        int heServiceApproverPending = hrServiceRequestService.countHrServiceApproverPendingRequest(hrServiceRequest);
        request.setAttribute("heServiceApproverPending", heServiceApproverPending);
        //--------------to---------------------//
        mv.setViewName("forward:resignationMaster.htm?act=userDashboardResignationPendingRequest");
        return mv;
    }

    public ModelAndView searchHrServicePendingSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HrServiceRequest hrServiceRequest = new HrServiceRequest();
        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
        hrServiceRequest.setEmployeeMasterByEmployeeMasterId(employeeMaster);
        List<?> list = hrServiceRequestService.readHrServicePendingRequest(hrServiceRequest);
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("hrServiceRequest", hrServiceRequest);
        mv.setViewName("HrService/HrServiceResult");
        return mv;
    }

    public ModelAndView exportToExcel(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HrServiceRequest hrServiceRequest = new HrServiceRequest();
        List<?> hrApprovelist = (List<?>) request.getSession().getAttribute("hrApprovelist");
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=HRService.xls");
        mv.addObject("hrApprovelist", hrApprovelist);
        mv.setViewName("HrService/ExportHRServiceResult");
        return mv;
    }

    public ModelAndView approverClickHRDesktop(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HrServiceRequest hrServiceRequest = new HrServiceRequest();
        EmployeeMaster employeeMaster = new EmployeeMaster();

        List<?> hrlist = hrServiceRequestService.readByrequesteeIdHrDesktop();
        mv.getModelMap().put("hrlist", hrlist);
//        mv.getModelMap().put("employeeMaster", employeeMaster);
//        mv.getModelMap().put("hrServiceRequest", hrServiceRequest);
        HttpSession session = request.getSession();
        session.setAttribute("hrApprovelist", hrlist);
        mv.setViewName("forward:userMaster.htm?act=hrDashboardShow");
        return mv;
    }
}
