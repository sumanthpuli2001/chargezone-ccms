/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.webservice;

import com.bul.zydex.webservice.HrWebServiceAbstract;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.HrServiceRequest;
import com.bul.zydex.model.QueryType;
import com.bul.zydex.model.UserMaster;
import com.bul.zydex.service.emprequest.HrServiceRequestService;
import com.bul.zydex.service.emprequest.QueryTypeService;
import com.google.gson.JsonArray;
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

/**
 *
 * @author <Jay>
 */
public class HrWebService extends HrWebServiceAbstract {

    public void hrServiceList(HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException {
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
                HrServiceRequest hrServiceRequest = new HrServiceRequest();
                hrServiceRequest.setEmployeeMasterByEmployeeMasterId(employeeMaster1);
                List<?> hrList = hrServiceRequestService.readByEmpId(hrServiceRequest);
                if (!hrList.isEmpty()) {
                    rcode = "1";
                    message = "Sucess.";
                    JSONArray jSONArray = new JSONArray();
                    for (int i = 0; i < hrList.size(); i++) {
                        HrServiceRequest hrServiceRequest1 = new HrServiceRequest();
                        JSONObject hrServiceDeta = new JSONObject();
                        Object[] hr = (Object[]) hrList.get(i);
                        hrServiceDeta.put("hrServiceId", hr[0]);
                        hrServiceDeta.put("details", hr[3]);
                        hrServiceDeta.put("queryTypeId", ((QueryType) hr[1]).getId());
                        hrServiceDeta.put("queryType", ((QueryType) hr[1]).getText());
                        jSONArray.put(hrServiceDeta);
                    }
                    data.put("hrServiceList", jSONArray);
                } else {
                    rcode = "0";
                    message = "Error: No request found.";
                }
            } else {
                rcode = "0";
                message = "Error";
            }
        } catch (Exception e) {
            rcode = "0";
            message = "Something wrong";
        }
        userData.put("data", data);
        userData.put("responseMessage", message);
        userData.put("responseCode", rcode);
        out.print(userData);
    }

    public void getHRRequestTypes(HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException {
        PrintWriter out = null;
        out = response.getWriter();
        String rcode = "";
        String message = "";
        JSONObject userData = new JSONObject();
        JSONObject data = new JSONObject();
        try {
            List<?> hrQueryType = queryTypeService.read();
            if (!hrQueryType.isEmpty()) {
                rcode = "1";
                message = "Sucess";
                JSONArray queryTypeList = new JSONArray();
                for (Object o : hrQueryType) {
                    QueryType queryType1 = (QueryType) o;
                    JSONObject hrQueryTypes = new JSONObject();
                    hrQueryTypes.put("queryTypeId", queryType1.getId());
                    hrQueryTypes.put("queryType", queryType1.getText());
                    queryTypeList.put(hrQueryTypes);
                }
                data.put("queryTypeList", queryTypeList);
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

    public void createHRServiceRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException {
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
            HrServiceRequest hrServiceRequest = new HrServiceRequest();
            hrServiceRequest.setEmployeeMasterByEmployeeMasterId(employeeMaster1);

            QueryType queryType = new QueryType();
            String requestTypeId = data.getString("queryTypeId");
            queryType.setId(Integer.parseInt(requestTypeId));
            hrServiceRequest.setQueryType(queryType);
            hrServiceRequest.setDetails(data.getString("details"));
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            String requestDate = dateFormat.format(new Date());
            hrServiceRequest.setRequestDate(requestDate);
            hrServiceRequest.setStatus(1);
            if (!hrServiceRequestService.isExist(hrServiceRequest)) {
                rcode = "1";
                message = "Sucess.";
                hrServiceRequestService.create(hrServiceRequest);
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

    public void subOrdinateapproverClick(HttpServletRequest request,
            HttpServletResponse response) {

        try {

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

            PrintWriter out = null;
            out = response.getWriter();
            String rcode = "";
            String message = "";

            JSONObject userData = new JSONObject();
            JSONObject data = new JSONObject();

            List<?> hrlist = hrServiceRequestService.readByrequesteeId(hrServiceRequest);

            if (!hrlist.isEmpty()) {
                rcode = "1";
                message = "Sucess";
                JSONArray hrlistType = new JSONArray();

                for (Object o : hrlist) {
                    Object[] ob = (Object[]) o;
                    JSONObject hrTypes = new JSONObject();
                    hrTypes.put("HRServiceId", ob[0].toString());
                    hrTypes.put("EmpId", ob[4].toString());
                    hrTypes.put("LoginId", ob[1].toString());
                    hrTypes.put("EmpName", ob[2].toString());
//                QueryType qt = (QueryType) o;
//                String hrService = qt.getText();
                    QueryType qt = (QueryType) ob[3];
                    String hr = qt.getText();
                    hrTypes.put("HRService", hr);

                    hrTypes.put("RequestDate", ob[6].toString());
                    if (null == ob[7]) {
                        hrTypes.put("ApproveDate", "");
                    } else {
                        hrTypes.put("ApproveDate", ob[7].toString());
                    }

                     hrTypes.put("Status", ob[5].toString());
                    String status_Messsage = "";
                    if (ob[5].toString().equals("1")) {
                        status_Messsage = "Pending";
                    } else {
                        status_Messsage = "Closed";
                    }
                    hrTypes.put("Status Msg", status_Messsage);

                    hrlistType.put(hrTypes);
                }
                data.put("hrlistType", hrlistType);
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

    ///////////////////////////////////////////////////////////////////////////////////////
    //view
    public void subOrdinateviewClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        String rcode = "";
        String message = "";
        JSONObject userData = new JSONObject();
        PrintWriter out = null;
        out = response.getWriter();

        try {

            HrServiceRequest hrServiceRequest = new HrServiceRequest();

            QueryType queryType = new QueryType();

            String id = request.getParameter("id");

            JSONObject data = doConvert(request);
            String empId = data.getString("EmpId");
            String hrId = data.getString("HRServiceId");

            EmployeeMaster employeeMaster = employeeMasterService.readById(Integer.parseInt(empId));
            hrServiceRequest = hrServiceRequestService.readById(Integer.parseInt(hrId));
//        

            employeeMaster.getReportingManagerLevel1();
            bind(request, hrServiceRequest);
            hrServiceRequest = hrServiceRequestService.readById(Integer.parseInt(hrId));
            employeeMaster.setDepartmentMaster(departmentMasterService.readById(employeeMaster.getDepartmentMaster().getId()));
            employeeMaster.setDesignationMaster(designationMasterService.readById(employeeMaster.getDesignationMaster().getId()));
            employeeMaster.setLevelMaster(levelMasterService.readById(employeeMaster.getLevelMaster().getId()));
            employeeMaster.setLocationMaster(locationMasterService.readById(employeeMaster.getLocationMaster().getId()));
            hrServiceRequest.setQueryType(queryTypeService.readById(hrServiceRequest.getQueryType().getId()));

            // PrintWriter out = null;
//             JSONObject userData = new JSONObject();
            List<?> list = employeeMasterService.readManagerLevel1(employeeMaster);
            if (!list.isEmpty()) {
                request.setAttribute("reportingLevel1", list.get(0));
            }

            rcode = "1";
            message = "Sucess";
            JSONArray viewType = new JSONArray();
            JSONObject views = new JSONObject();
            views.put("EmpNo", employeeMaster.getEmployeeId());
            views.put("EmpName", employeeMaster.getEmployeeName());
            views.put("DeptName", employeeMaster.getDepartmentMaster().getDepartmentName());
            views.put("DesgName", employeeMaster.getDesignationMaster().getDesignationName());
            views.put("Level", employeeMaster.getLevelMaster().getLevel());
            views.put("QueryTo", hrServiceRequest.getQueryType().getText());
            views.put("Details", hrServiceRequest.getDetails());
            views.put("Status", hrServiceRequest.getStatus());
            String status_Messsage = "";
            if (hrServiceRequest.getStatus() == 1) {
                status_Messsage = "Pending";
            } else {
                status_Messsage = "Approved";
            }
            views.put("Status Msg", status_Messsage);

            viewType.put(views);
            userData.put("data", viewType);
            userData.put("responseMessage", message);
            userData.put("responseCode", rcode);

        } catch (Exception e) {
            rcode = "2";
            message = "Failure";
            e.printStackTrace();
        }
        userData.put("responseMessage", message);
        userData.put("responseCode", rcode);
        out.print(userData);
//            
    }

/////after close
    public void subordinateapproveSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        String rcode = "";
        String message = "";
        PrintWriter out = null;
        out = response.getWriter();
        JSONObject userData = new JSONObject();
        try {
            HrServiceRequest hrServiceRequest = new HrServiceRequest();

//           String id = request.getParameter("id");
            JSONObject data = doConvert(request);
            String id = request.getParameter("id");
            String hrId = data.getString("HRServiceId");
            String empId = data.getString("EmpId");

//        
            String statusType = request.getParameter("statusType");
            String remark = request.getParameter("rejectRemark");
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            bind(request, hrServiceRequest);
            hrServiceRequest = hrServiceRequestService.readById(Integer.parseInt(hrId));
            String approvedate = sdf.format(new Date());
            hrServiceRequest.setHrApproveDate(approvedate);

            EmployeeMaster employeeMaster = employeeMasterService.readById(Integer.parseInt(id));
            EmployeeMaster employeeMaster1 = employeeMasterService.readById(Integer.parseInt(empId));
//          

            employeeMaster.setDepartmentMaster(departmentMasterService.readById(employeeMaster.getDepartmentMaster().getId()));
            employeeMaster.setDesignationMaster(designationMasterService.readById(employeeMaster.getDesignationMaster().getId()));
            employeeMaster.setLevelMaster(levelMasterService.readById(employeeMaster.getLevelMaster().getId()));
            employeeMaster.setLocationMaster(locationMasterService.readById(employeeMaster.getLocationMaster().getId()));
            hrServiceRequest.setEmployeeMasterByHrApproveId(employeeMaster);

            hrServiceRequest.setStatus(2);
            request.setAttribute("successMessage",
                    "Information : Request Closed Successfully.");

            hrServiceRequestService.update(hrServiceRequest);

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
