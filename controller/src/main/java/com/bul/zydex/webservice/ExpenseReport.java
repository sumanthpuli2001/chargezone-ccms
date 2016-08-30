/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.webservice;

import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.TravelRequestMaster;
import com.bul.zydex.model.UserMaster;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author admin
 */
public class ExpenseReport extends ExpenseReportAbstarct {

    public void TravelAppNoRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, JSONException {
        PrintWriter out = null;
        out = response.getWriter();
        String rcode = "";
        String message = "";
        String empid = "";
        UserMaster user = new UserMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        JSONObject userData = new JSONObject();
        JSONObject data = doPost(request);
        String id = request.getParameter("id");
        int userid = Integer.parseInt(id);
        user.setId(userid);
        employeeMaster.setUserMaster(user);
        List<?> empDetailList = employeeMasterService.readByEmployeeUserId(employeeMaster);
        if (!empDetailList.isEmpty()) {
            employeeMaster1 = (EmployeeMaster) empDetailList.get(0);
        }
        TravelRequestMaster travelRequestMaster = new TravelRequestMaster();
        travelRequestMaster.setEmployeeMasterByEmployeeMasterId(employeeMaster);
        List<?> travelList = travelRequestMasterService.readTotalRequest(travelRequestMaster);
        Map<Integer, String> travelNo = new HashMap<>();
        for (Object o : travelList) {
            travelRequestMaster = (TravelRequestMaster) o;
            if (!travelRequestMaster.getTravelType().equals("Local")) {
                travelNo.put(travelRequestMaster.getId(), travelRequestMaster.getTravelRequestNo());
            }
        }
    }
}
