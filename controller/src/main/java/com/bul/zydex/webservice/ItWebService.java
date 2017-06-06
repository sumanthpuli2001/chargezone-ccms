/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.webservice;

import com.bul.zydex.model.DepartmentMaster;
import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.model.EmailAddMaster;
import com.bul.zydex.model.EmailTemplate;
import com.bul.zydex.webservice.ItWebServiceAbstract;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.ItRequestType;
import com.bul.zydex.model.ItServiceRequest;
import com.bul.zydex.model.LevelMaster;
import com.bul.zydex.model.LocationMaster;
import com.bul.zydex.model.UserMaster;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author <Jay>
 */
public class ItWebService extends ItWebServiceAbstract {

    public void itServiceList(HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException {
        PrintWriter out = null;
        out = response.getWriter();
        String rcode = "";
        String message = "";
        UserMaster userMaster = new UserMaster();
        JSONObject userData = new JSONObject();
        JSONObject data = new JSONObject();
        try {
            String id = request.getParameter("id");
            int userId = Integer.parseInt(id);
            userMaster.setId(userId);
            EmployeeMaster employeeMaster = new EmployeeMaster();
            employeeMaster.setUserMaster(userMaster);
            List<EmployeeMaster> empList = (List<EmployeeMaster>) employeeMasterService.readByEmployeeUserId(employeeMaster);
            if (!empList.isEmpty()) {
                EmployeeMaster employeeMaster1 = (EmployeeMaster) empList.get(0);
                ItServiceRequest itServiceRequest = new ItServiceRequest();
                itServiceRequest.setEmployeeMasterByEmployeeMasterId(employeeMaster1);
                List<?> itList = itServiceRequestService.readByEmpId(itServiceRequest);
                if (!itList.isEmpty()) {
                    rcode = "1";
                    message = "Success";
                    JSONArray jSONArray = new JSONArray();
                    for (int i = 0; i < itList.size(); i++) {
                        ItServiceRequest obj1 = new ItServiceRequest();
                        JSONObject itDetail = new JSONObject();
                        Object[] it = (Object[]) itList.get(i);
                        itDetail.put("requestId", it[0]);
                        itDetail.put("requestTypeId", ((ItRequestType) it[1]).getId());
                        itDetail.put("requestType", ((ItRequestType) it[1]).getText());
                        itDetail.put("problemDetails", it[3]);
                        jSONArray.put(itDetail);
                    }
                    data.put("itDetails", jSONArray);
                } else {
                    rcode = "0";
                    message = "Error";
                }
            } else {
                rcode = "0";
                message = "Error";
            }
        } catch (Exception e) {
            rcode = "0";
            message = "Id not found";
        }
        userData.put("data", data);
        userData.put("responseMessage", message);
        userData.put("responseCode", rcode);
        out.print(userData);
    }

    public void getITRequestTypes(HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException {
        PrintWriter out = null;
        out = response.getWriter();
        String rcode = "";
        String message = "";
        JSONObject userData = new JSONObject();
        JSONObject data = new JSONObject();
        try {
            List<?> itRequestType = itRequestTypeService.read();
            if (!itRequestType.isEmpty()) {
                rcode = "1";
                message = "Sucess";
                JSONArray itRequestTypeDetails = new JSONArray();
                for (Object o : itRequestType) {
                    ItRequestType itRequestType1 = (ItRequestType) o;
                    JSONObject itRequestTypes = new JSONObject();
                    itRequestTypes.put("requestTypeId", itRequestType1.getId());
                    itRequestTypes.put("requestType", itRequestType1.getText());
                    itRequestTypeDetails.put(itRequestTypes);
                }
                data.put("itRequestTypes", itRequestTypeDetails);
            } else {
                rcode = "0";
                message = "Error : No request found.";
            }
        } catch (Exception e) {
            rcode = "0";
            message = "Error : something wrong";
        }
        userData.put("data", data);
        userData.put("responseMessage", message);
        userData.put("responseCode", rcode);
        out.print(userData);
    }

    public void createITServiceRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException {
        PrintWriter out = null;
        out = response.getWriter();
        String rcode = "";
        String message = "";
        UserMaster userMaster = new UserMaster();
        JSONObject userData = new JSONObject();
        JSONObject data = doConvert(request);
        try {
            String id = request.getParameter("id");
            int userId = Integer.parseInt(id);
            userMaster.setId(userId);
            EmployeeMaster employeeMaster = new EmployeeMaster();
            EmployeeMaster employeeMaster1 = new EmployeeMaster();
            employeeMaster.setUserMaster(userMaster);
            List<EmployeeMaster> empList = (List<EmployeeMaster>) employeeMasterService.readByEmployeeUserId(employeeMaster);
            if (!empList.isEmpty()) {
                employeeMaster1 = (EmployeeMaster) empList.get(0);
            }
            ItServiceRequest itServiceRequest = new ItServiceRequest();
            itServiceRequest.setEmployeeMasterByEmployeeMasterId(employeeMaster1);

            ItRequestType itRequestType = new ItRequestType();
            String requestTypeId = data.getString("requestTypeId");
            itRequestType.setId(Integer.parseInt(requestTypeId));
            itServiceRequest.setItRequestType(itRequestType);
            itServiceRequest.setProblemDetail(data.getString("problemDetails"));
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            String requestDate = dateFormat.format(new Date());
            itServiceRequest.setRequestDate(requestDate);
            itServiceRequest.setStatus(1);
            if (!itServiceRequestService.isExist(itServiceRequest)) {
                rcode = "1";
                message = "Sucess.";
                itServiceRequestService.create(itServiceRequest);
            } else {
                rcode = "0";
                message = "Error : Your request is already exist.";
            }
        } catch (Exception e) {
            rcode = "0";
            message = "ERROR : Your id not found.";
        }
        userData.put("responseMessage", message);
        userData.put("responseCode", rcode);
        out.print(userData);
    }

    public void ITview(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PrintWriter out = null;
        out = response.getWriter();
        String rcode = "";
        String message = "";
        UserMaster userMaster = new UserMaster();
        JSONObject userData = new JSONObject();
        JSONArray ItwiewDetail = new JSONArray();
        JSONArray jSONArray = new JSONArray();
        JSONObject data = doConvert(request);
        try {
            String id = request.getParameter("id");
            int userId = Integer.parseInt(id);
            userMaster.setId(userId);
            ItRequestType itRequestType = new ItRequestType();
            ItServiceRequest itServiceRequest = new ItServiceRequest();
            EmployeeMaster employeeMaster = new EmployeeMaster();
            EmployeeMaster employeeMaster1 = new EmployeeMaster();
            employeeMaster.setUserMaster(userMaster);
            String requestTypeId = data.getString("requestId");
            itRequestType.setId(Integer.parseInt(requestTypeId));

            List<EmployeeMaster> empList = (List<EmployeeMaster>) employeeMasterService.readByEmployeeUserId(employeeMaster);
            if (!empList.isEmpty()) {
                employeeMaster1 = (EmployeeMaster) empList.get(0);

                DepartmentMaster departmentMaster = departmentMasterService.readById(employeeMaster1.getDepartmentMaster().getId());
                DesignationMaster designationMaster = designationMasterService.readById(employeeMaster1.getDesignationMaster().getId());
                LocationMaster locationMaster = locationMasterService.readById(employeeMaster1.getLocationMaster().getId());
                LevelMaster levelMaster = levelMasterService.readById(employeeMaster1.getLevelMaster().getId());

                JSONObject Obj = new JSONObject();

                Obj.put("Department", departmentMaster.getDepartmentName());
                Obj.put("Designation", designationMaster.getDesignationName());
                Obj.put("Work Location", levelMaster.getLevel());
                Obj.put("EmployeeNo", employeeMaster1.getEmployeeId());
                Obj.put("EmployeeName", employeeMaster1.getEmployeeName());
                Obj.put("reportingManager", employeeMaster1.getReportingManagerLevel1());
                ItwiewDetail.put(Obj);
            }

          
            rcode = "1";
            message = "Success";

            userData.put("EmployeeDetail", ItwiewDetail);
            userData.put("RequestTypeAndDescription", jSONArray);

            userData.put("responseMessage", message);
            userData.put("responseCode", rcode);

        } catch (Exception e) {
            rcode = "2";
            message = "Failure";
        }
        out.print(userData);
    }

    public void displayList(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        try {

            ItServiceRequest itServiceRequest = new ItServiceRequest();
            EmployeeMaster employeeMaster = new EmployeeMaster();
            selectEmployee(request, response);
            departmentList(request);
            designationList(request);
            String empId = request.getParameter("employeeName");
            String departmentId = request.getParameter("departmentMaster");
            String designationId = request.getParameter("designationMaster");
            String startDate = request.getParameter("startDate");
            String endDate = request.getParameter("endDate");
            String status = request.getParameter("status");

            if (!"".equals(empId) && null != empId) {
                employeeMaster.setId(Integer.parseInt(empId));
            }
            if (!"".equals(departmentId) && null != departmentId) {
                itServiceRequest.setProblemDetail(departmentId);
            }
            if (!"".equals(designationId) && null != designationId) {
                itServiceRequest.setItApproverDate(designationId);
            }
            if (!"".equals(status) && null != status) {
                itServiceRequest.setRejectRemark(status);
            }
            if (!"".equals(startDate) && null != startDate) {
                itServiceRequest.setRequestDate(startDate);
            }
            if (!"".equals(endDate) && null != endDate) {
                employeeMaster.setAdharCard(endDate);
            }
            // HttpSession session = request.getSession();

            itServiceRequest.setEmployeeMasterByEmployeeMasterId(employeeMaster);
            PrintWriter out = null;
            out = response.getWriter();
            String rcode = "";
            String message = "";

            JSONObject userData = new JSONObject();
            JSONObject data = new JSONObject();
            List<?> list = itServiceRequestService.readByrequesteeId(itServiceRequest);
            if (!list.isEmpty()) {
                rcode = "1";
                message = "Sucess";
                JSONArray listsType = new JSONArray();

                for (Object o : list) {
                    Object[] ob = (Object[]) o;
                    JSONObject listType = new JSONObject();
                    listType.put("ITServiceId", ob[0].toString());
                    listType.put("EmpId", ob[4].toString());
                    listType.put("LoginId", ob[1].toString());
                    listType.put("EmpName", ob[2].toString());
                    ItRequestType qt = (ItRequestType) ob[3];
                    String ls = qt.getText();
                    listType.put("IT Service", ls);

                    listType.put("RequestDate", ob[6].toString());
                    if (null == ob[7]) {
                        listType.put("ApproveDate", "");
                    } else {
                        listType.put("ApproveDate", ob[7].toString());
                    }
                    listType.put("Status", ob[5].toString());
                    String statusMsg = "";
                    if (ob[5].toString().equals("1")) {
                        statusMsg = "Requested";
                    } else {
                        statusMsg = "Closed";
                    }
                    listType.put("Status Msg", statusMsg);

                    listsType.put(listType);
                }
                data.put("listsType", listsType);
            } else {
                rcode = "2";
                message = "No request found.";
            }
            userData.put("data", data);
            userData.put("responseMessage", message);
            userData.put("responseCode", rcode);
            out.print(userData);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

//      /////////////////////
    public void viewInformatoin(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        PrintWriter out = null;
        out = response.getWriter();
        String rcode = "";
        String message = "";
        JSONArray viewType = new JSONArray();
        JSONObject userData = new JSONObject();
        try {
            ItServiceRequest itServiceRequest = new ItServiceRequest();
            ItRequestType itRequestType = new ItRequestType();
            EmployeeMaster employeeMaster = new EmployeeMaster();
            String id = request.getParameter("id");

            JSONObject data = doConvert(request);

            String empId = data.getString("EmpId");
            String itid = data.getString("IT_Service_Id");

            employeeMaster = employeeMasterService.readById(Integer.parseInt(empId));
            itServiceRequest = itServiceRequestService.readById(Integer.parseInt(itid));
            employeeMaster.getReportingManagerLevel1();
            bind(request, itServiceRequest);
            itServiceRequest = itServiceRequestService.readById(Integer.parseInt(itid));
            employeeMaster.setDepartmentMaster(departmentMasterService.readById(employeeMaster.getDepartmentMaster().getId()));
            employeeMaster.setDesignationMaster(designationMasterService.readById(employeeMaster.getDesignationMaster().getId()));
            employeeMaster.setLevelMaster(levelMasterService.readById(employeeMaster.getLevelMaster().getId()));
            employeeMaster.setLocationMaster(locationMasterService.readById(employeeMaster.getLocationMaster().getId()));
            itServiceRequest.setItRequestType(itRequestTypeService.readById(itServiceRequest.getItRequestType().getId()));

            List<?> list = employeeMasterService.readManagerLevel1(employeeMaster);
            if (!list.isEmpty()) {
                request.setAttribute("reportingLevel1", list.get(0));
            }

            JSONObject views = new JSONObject();
            views.put("Employee No.", employeeMaster.getEmployeeId());
            views.put("Employee Name", employeeMaster.getEmployeeName());
            views.put("DeptName", employeeMaster.getDepartmentMaster().getDepartmentName());
            views.put("DesgName", employeeMaster.getDesignationMaster().getDesignationName());

            views.put("RequestType", itServiceRequest.getItRequestType().getText());
            views.put("Details", itServiceRequest.getProblemDetail());
            views.put("Work_location", employeeMaster.getLocationMaster().getLocation());

            views.put("Level", employeeMaster.getLevelMaster().getLevel());
            String status_Messsage = "";
            if (itServiceRequest.getStatus() == 1) {
                status_Messsage = "Requested";
            } else {
                status_Messsage = "Closed";
            }
            views.put("Status Msg", status_Messsage);

            viewType.put(views);

            rcode = "1";
            message = "Sucess";

        } catch (Exception e) {
            rcode = "2";
            message = "Failure";
            e.printStackTrace();
        }
        userData.put("data", viewType);
        userData.put("responseMessage", message);
        userData.put("responseCode", rcode);
        out.print(userData);

    }

//       ////////////
    public void onClose(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        String rcode = "";
        String message = "";
        PrintWriter out = null;
        out = response.getWriter();
        JSONObject userData = new JSONObject();

        try {
            ItServiceRequest itServiceRequest = new ItServiceRequest();
            JSONObject data = doConvert(request);
            String id = request.getParameter("id");
            String itid = data.getString("IT_Service_Id");
            String empId = data.getString("EmpId");

//        ItServiceRequest itServiceRequest = new ItServiceRequest();
//        String id = request.getParameter("id");
            String statusType = request.getParameter("statusType");
            String remark = request.getParameter("rejectRemark");
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            bind(request, itServiceRequest);
            itServiceRequest = itServiceRequestService.readById(Integer.parseInt(itid));
            String approvedate = sdf.format(new Date());
            itServiceRequest.setItApproverDate(approvedate);

//        HttpSession session = request.getSession();
//        EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
//        
            EmployeeMaster employeeMaster = employeeMasterService.readById(Integer.parseInt(id));
//            EmployeeMaster employeeMaster1 = employeeMasterService.readById(Integer.parseInt(empId));

            employeeMaster.setDepartmentMaster(departmentMasterService.readById(employeeMaster.getDepartmentMaster().getId()));
            employeeMaster.setDesignationMaster(designationMasterService.readById(employeeMaster.getDesignationMaster().getId()));
            employeeMaster.setLevelMaster(levelMasterService.readById(employeeMaster.getLevelMaster().getId()));
            employeeMaster.setLocationMaster(locationMasterService.readById(employeeMaster.getLocationMaster().getId()));
            itServiceRequest.setEmployeeMasterByItApproverId(employeeMaster);
            itServiceRequest.setStatus(2);
            itServiceRequestService.update(itServiceRequest);

            EmailTemplate emailTemplate = new EmailTemplate();
//        EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
//        EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("empId");
            EmployeeMaster employeeMaster2 = employeeMasterService.readById(Integer.parseInt(empId));
            DesignationMaster designationMaster = new DesignationMaster();
            designationMaster = designationMasterService.readById(employeeMaster2.getDesignationMaster().getId());
            EmployeeMaster employeeMaster1 = new EmployeeMaster();
            employeeMaster1 = employeeMasterService.readById(itServiceRequest.getEmployeeMasterByEmployeeMasterId().getId());
            // id 48 is for status IT Service Request Apply
            emailTemplate = emailTemplateService.readById(127);
            String To = employeeMaster1.getOfficeEmailId();
            String from = employeeMaster2.getOfficeEmailId();
            String Subject = emailTemplate.getSubject();
            Subject = Subject.replaceAll("\\{user\\}", employeeMaster1.getEmployeeName());
            String msg = emailTemplate.getBodytext();
            msg = msg.replaceAll("\\{to_user\\}", employeeMaster1.getEmployeeName());
            msg = msg.replaceAll("\\{from_user\\}", employeeMaster2.getEmployeeName());
            msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
            sendMail.sendMail(from, To, Subject, msg);

            request.setAttribute("successMessage",
                    "Information : Request Closed Successfully.");

            String name = "IT Service";
            EmailAddMaster emailAddMaster = new EmailAddMaster();
            emailAddMaster.setModuleName(name);
            emailAddMaster.setDepartmentMaster(employeeMaster1.getDepartmentMaster());
            List<?> emailSendList = emailAddMasterService.readByName(emailAddMaster);
            if (!emailSendList.isEmpty()) {
                EmailAddMaster emailAddMaster1 = (EmailAddMaster) emailSendList.get(0);
                String emailId = emailAddMaster1.getEmailId();
                for (String emailId1 : emailId.split(",")) {
                    if (!emailId1.equals("")) {
                        String To1 = emailId1;
                        String from1 = employeeMaster2.getOfficeEmailId();
                        String subject1 = emailTemplate.getSubject();
                        subject1 = subject1.replaceAll("\\{user\\}", employeeMaster1.getEmployeeName());
                        String msg1 = emailTemplate.getBodytext();
                        msg1 = msg1.replaceAll("\\{to_user\\}", employeeMaster1.getEmployeeName());
                        msg1 = msg1.replaceAll("\\{from_user\\}", employeeMaster2.getEmployeeName());
                        msg1 = msg1.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                        sendMail.sendMail(from1, To1, subject1, msg1);

                    }
                }
            }
            rcode = "1";
            message = "Sucess";
        } catch (Exception e) {
            rcode = "2";
            message = "Failure";

            e.printStackTrace();
        }
        userData.put("responseMessage", message);
        userData.put("responseCode", rcode);
        out.print(userData);
    }
}
