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

}
