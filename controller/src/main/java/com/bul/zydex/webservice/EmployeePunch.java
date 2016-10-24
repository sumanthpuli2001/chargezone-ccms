/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.webservice;

import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.EmployeePunchForMobileApp;
import com.bul.zydex.model.RegisterMobForPunch;
import com.bul.zydex.model.UserMaster;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author admin
 */
public class EmployeePunch extends EmployeePunchAbstract {

    public void submitPunchRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, JSONException, ParseException {
        PrintWriter out = null;
        out = response.getWriter();
        String rcode = "";
        String message = "";
        String empid = "";
        UserMaster user = new UserMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        RegisterMobForPunch registerMobForPunch = new RegisterMobForPunch();
        JSONObject userData = new JSONObject();
        try {
            JSONObject data = doPost(request);
            String id = request.getParameter("id");
            int userid = Integer.parseInt(id);
            user.setId(userid);
            employeeMaster.setUserMaster(user);
            List<?> empDetailList = employeeMasterService.readByEmployeeUserId(employeeMaster);
            if (!empDetailList.isEmpty()) {
                employeeMaster1 = (EmployeeMaster) empDetailList.get(0);
                String date = data.get("punchTime").toString();

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                Date punchTime = sdf.parse(date);

                EmployeePunchForMobileApp employeePunchForMobileApp = new EmployeePunchForMobileApp();
                employeePunchForMobileApp.setEmployeeMaster(employeeMaster1);
                employeePunchForMobileApp.setPunchTime(punchTime.toString());
                employeePunchForMobileApp.setPunchLocation(data.get("punchLocation").toString());

                String imeiNO = data.get("imeiNo").toString();

                List<?> empMobRegList = registerMobForPunchService.readByEmpId(employeeMaster1.getId());
                if (empMobRegList.isEmpty()) {
                    registerMobForPunch.setEmployeeMaster(employeeMaster1);
                    registerMobForPunch.setImeiNo(imeiNO);
                    registerMobForPunchService.create(registerMobForPunch);
                    employeePunchForMobileAppService.create(employeePunchForMobileApp);
                    rcode = "1";
                    message = "Success";
                } else {
                    registerMobForPunch = (RegisterMobForPunch) empMobRegList.get(0);
                    String imeiNum = registerMobForPunch.getImeiNo();
                    if (imeiNum.equals(imeiNO)) {
                        employeePunchForMobileAppService.create(employeePunchForMobileApp);
                        rcode = "1";
                        message = "Success";
                    } else {
                        rcode = "2";
                        message = "Your device Not Register";
                    }
                }
            } else {
                rcode = "0";
                message = "No Record Found";
            }
        } catch (Exception exception) {
            rcode = "0";
            message = "Something Wrong";
        }

        userData.put("responseMessage", message);
        userData.put("responseCode", rcode);
        out.print(userData);

    }

}
