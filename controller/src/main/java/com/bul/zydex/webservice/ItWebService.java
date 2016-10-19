/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.webservice;

import com.bul.zydex.webservice.ItWebServiceAbstract;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.ItRequestType;
import com.bul.zydex.model.ItServiceRequest;
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
}
