/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.webservice;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.ItRequestType;
import com.bul.zydex.model.ItServiceRequest;
import com.bul.zydex.model.LevelMaster;
import com.bul.zydex.model.LocationMaster;
import com.bul.zydex.service.emprequest.ItRequestTypeService;
import com.bul.zydex.service.emprequest.ItServiceRequestService;
import com.bul.zydex.service.level.LevelMasterService;
import com.bul.zydex.service.location.LocationMasterService;
import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author <Jay>
 */
public class ItWebServiceAbstract extends CustomAbstract {

    protected ItRequestTypeService<ItRequestType> itRequestTypeService;
    protected ItServiceRequestService<ItServiceRequest> itServiceRequestService;
     protected LevelMasterService<LevelMaster> levelMasterService;
    protected LocationMasterService<LocationMaster> locationMasterService;

    public LevelMasterService<LevelMaster> getLevelMasterService() {
        return levelMasterService;
    }

    public void setLevelMasterService(LevelMasterService<LevelMaster> levelMasterService) {
        this.levelMasterService = levelMasterService;
    }

    public LocationMasterService<LocationMaster> getLocationMasterService() {
        return locationMasterService;
    }

    public void setLocationMasterService(LocationMasterService<LocationMaster> locationMasterService) {
        this.locationMasterService = locationMasterService;
    }

    public ItRequestTypeService<ItRequestType> getItRequestTypeService() {
        return itRequestTypeService;
    }

    public void setItRequestTypeService(ItRequestTypeService<ItRequestType> itRequestTypeService) {
        this.itRequestTypeService = itRequestTypeService;
    }

    public ItServiceRequestService<ItServiceRequest> getItServiceRequestService() {
        return itServiceRequestService;
    }

    public void setItServiceRequestService(ItServiceRequestService<ItServiceRequest> itServiceRequestService) {
        this.itServiceRequestService = itServiceRequestService;
    }
    

    public JSONObject doConvert(HttpServletRequest request) throws IOException, JSONException {

        StringBuffer buffer = new StringBuffer();
        String line = null;
        try {
            BufferedReader bufferedReader = request.getReader();
            while ((line = bufferedReader.readLine()) != null) {
                buffer.append(line);
            }
        } catch (Exception e) {
        }
        JSONObject jSONObject = new JSONObject(buffer.toString());

        return jSONObject;
    }

}
