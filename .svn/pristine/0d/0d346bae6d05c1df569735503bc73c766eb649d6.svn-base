/*
 * 
 * Author Vinita
 */

package com.bul.zydex.controller.emprequest;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.ItRequestType;
import com.bul.zydex.model.ItServiceRequest;
import com.bul.zydex.model.LevelMaster;
import com.bul.zydex.model.LocationMaster;
import com.bul.zydex.model.UserRightMaster;
import com.bul.zydex.service.UserRight.UserRightMasterService;
import com.bul.zydex.service.emprequest.ItRequestTypeService;
import com.bul.zydex.service.emprequest.ItServiceRequestService;
import com.bul.zydex.service.level.LevelMasterService;
import com.bul.zydex.service.location.LocationMasterService;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.Validator;

/**
 *
 * @author Vinita
 */
public abstract class ItServiceRequestAbstract extends CustomAbstract{
    
    public ItServiceRequestService<ItServiceRequest> itServiceRequestService;
    public ItRequestTypeService<ItRequestType> itRequestTypeService;
    public LevelMasterService<LevelMaster> levelMasterService;
    public LocationMasterService<LocationMaster> locationMasterService;
    public Validator itServiceValidator;
    protected UserRightMasterService<UserRightMaster> userRightMasterService;

    public UserRightMasterService<UserRightMaster> getUserRightMasterService() {
        return userRightMasterService;
    }

    public void setUserRightMasterService(UserRightMasterService<UserRightMaster> userRightMasterService) {
        this.userRightMasterService = userRightMasterService;
    }

    
    public ItServiceRequestService<ItServiceRequest> getItServiceRequestService() {
        return itServiceRequestService;
    }

    public void setItServiceRequestService(ItServiceRequestService<ItServiceRequest> itServiceRequestService) {
        this.itServiceRequestService = itServiceRequestService;
    }

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

    public Validator getItServiceValidator() {
        return itServiceValidator;
    }

    public void setItServiceValidator(Validator itServiceValidator) {
        this.itServiceValidator = itServiceValidator;
    }
    
     public void readrequesttype(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        List<?> list = itRequestTypeService.read();
        Map<Integer, String> requesttypeMap = new LinkedHashMap<Integer, String>();

        for (Iterator<?> iterator = list.iterator(); iterator.hasNext();) {
            ItRequestType itRequestType = (ItRequestType) iterator.next();
            requesttypeMap.put(itRequestType.getId(), itRequestType.getText());
        }
        request.setAttribute("requesttypeMap", requesttypeMap);
    }

}
