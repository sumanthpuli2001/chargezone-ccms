/*
 * 
 * Author Vinita
 */
package com.bul.zydex.controller.emprequest;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.LevelMaster;
import com.bul.zydex.model.LocationMaster;
import com.bul.zydex.model.UserRightMaster;
import com.bul.zydex.model.VisitorManagement;
import com.bul.zydex.model.VisitorVisitedLocation;
import com.bul.zydex.service.UserRight.UserRightMasterService;
import com.bul.zydex.service.emprequest.VisitorManagementService;
import com.bul.zydex.service.level.LevelMasterService;
import com.bul.zydex.service.location.LocationMasterService;
import com.bul.zydex.service.location.VisitorVisitedLocationService;
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
public abstract class VisitorManagementAbstract extends CustomAbstract {

    public VisitorManagementService<VisitorManagement> visitorManagementService;
    public LevelMasterService<LevelMaster> levelMasterService;
    public LocationMasterService<LocationMaster> locationMasterService;
    public Validator visitorManagementValidator;
    public VisitorVisitedLocationService<VisitorVisitedLocation> visitorVisitedLocationService;
    protected UserRightMasterService<UserRightMaster> userRightMasterService;

    public UserRightMasterService<UserRightMaster> getUserRightMasterService() {
        return userRightMasterService;
    }

    public void setUserRightMasterService(UserRightMasterService<UserRightMaster> userRightMasterService) {
        this.userRightMasterService = userRightMasterService;
    }
     

    public VisitorVisitedLocationService<VisitorVisitedLocation> getVisitorVisitedLocationService() {
        return visitorVisitedLocationService;
    }

    public void setVisitorVisitedLocationService(VisitorVisitedLocationService<VisitorVisitedLocation> visitorVisitedLocationService) {
        this.visitorVisitedLocationService = visitorVisitedLocationService;
    }

    public VisitorManagementService<VisitorManagement> getVisitorManagementService() {
        return visitorManagementService;
    }

    public void setVisitorManagementService(VisitorManagementService<VisitorManagement> visitorManagementService) {
        this.visitorManagementService = visitorManagementService;
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

    public Validator getVisitorManagementValidator() {
        return visitorManagementValidator;
    }

    public void setVisitorManagementValidator(Validator visitorManagementValidator) {
        this.visitorManagementValidator = visitorManagementValidator;
    }

    public void readlocation(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        List<?> list = visitorVisitedLocationService.read();
        Map<Integer, String> locationMap = new LinkedHashMap<Integer, String>();

        for (Iterator<?> iterator = list.iterator(); iterator.hasNext();) {
            LocationMaster locationMaster = (LocationMaster) iterator.next();
            locationMap.put(locationMaster.getId(), locationMaster.getLocation());
        }
        request.setAttribute("locationMap", locationMap);

    }

    public void readVisitedlocation(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        List<?> list = visitorVisitedLocationService.read();
        VisitorVisitedLocation visitorVisitedLocation = new VisitorVisitedLocation();
        Map<Integer, String> visitedLocationMap = new LinkedHashMap<Integer, String>();

        for (Iterator<?> iterator = list.iterator(); iterator.hasNext();) {
            visitorVisitedLocation = (VisitorVisitedLocation) iterator.next();
            visitedLocationMap.put(visitorVisitedLocation.getId(), visitorVisitedLocation.getLocation());
        }
        request.setAttribute("visitedLocationMap", visitedLocationMap);

    }
}
