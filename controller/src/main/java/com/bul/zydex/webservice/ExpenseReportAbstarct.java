/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.webservice;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.TravelRequestMaster;
import com.bul.zydex.model.UserMaster;
import com.bul.zydex.model.UserRightMaster;
import com.bul.zydex.service.UserMasterService;
import com.bul.zydex.service.UserRight.UserRightMasterService;
import com.bul.zydex.service.emp.EmployeeMasterService;
import com.bul.zydex.service.travel.TravelRequestMasterService;
import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author admin
 */
public abstract class ExpenseReportAbstarct extends CustomAbstract{

    protected TravelRequestMasterService<TravelRequestMaster>travelRequestMasterService;

    public TravelRequestMasterService<TravelRequestMaster> getTravelRequestMasterService() {
        return travelRequestMasterService;
    }

    public void setTravelRequestMasterService(TravelRequestMasterService<TravelRequestMaster> travelRequestMasterService) {
        this.travelRequestMasterService = travelRequestMasterService;
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
