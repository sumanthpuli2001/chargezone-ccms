package com.bul.zydex.webservice;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.EmployeeLeaveBalance;
import com.bul.zydex.model.EmployeePunchForMobileApp;
import com.bul.zydex.model.RegisterMobForPunch;
import com.bul.zydex.model.UserRightMaster;
import com.bul.zydex.service.RegisterMobForPunch.RegisterMobForPunchService;
import com.bul.zydex.service.UserRight.UserRightMasterService;
import com.bul.zydex.service.leave.EmployeeLeaveBalanceService;
import com.bul.zydex.service.mobileapp.EmployeePunchForMobileAppService;
import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import org.json.JSONException;
import org.json.JSONObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author admin
 */
public abstract class EmployeePunchAbstract extends CustomAbstract {

    protected EmployeePunchForMobileAppService<EmployeePunchForMobileApp> employeePunchForMobileAppService;
    protected RegisterMobForPunchService<RegisterMobForPunch> registerMobForPunchService;

    public EmployeePunchForMobileAppService<EmployeePunchForMobileApp> getEmployeePunchForMobileAppService() {
        return employeePunchForMobileAppService;
    }

    public void setEmployeePunchForMobileAppService(EmployeePunchForMobileAppService<EmployeePunchForMobileApp> employeePunchForMobileAppService) {
        this.employeePunchForMobileAppService = employeePunchForMobileAppService;
        
    }

    public RegisterMobForPunchService<RegisterMobForPunch> getRegisterMobForPunchService() {
        return registerMobForPunchService;
    }

    public void setRegisterMobForPunchService(RegisterMobForPunchService<RegisterMobForPunch> registerMobForPunchService) {
        this.registerMobForPunchService = registerMobForPunchService;
    }
    

     public JSONObject doPost(HttpServletRequest request)
            throws ServletException, IOException, JSONException {
        StringBuffer jb = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                jb.append(line);
            }
        } catch (Exception e) { /*report an error*/ }
         JSONObject jsonObject = new JSONObject(jb.toString());

        return jsonObject;
  
    }

}
