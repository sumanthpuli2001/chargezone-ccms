/*
 * 
 * Author Vinita
 */

package com.bul.zydex.controller.emprequest;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.CafeteriaRequest;
import com.bul.zydex.model.LevelMaster;
import com.bul.zydex.model.LocationMaster;
import com.bul.zydex.model.UserRightMaster;
import com.bul.zydex.service.UserRight.UserRightMasterService;
import com.bul.zydex.service.emprequest.CafeteriaRequestService;
import com.bul.zydex.service.level.LevelMasterService;
import com.bul.zydex.service.location.LocationMasterService;
import org.springframework.validation.Validator;

/**
 *
 * @author Vinita
 */
public abstract class CafeteriaRequestAbstract extends CustomAbstract{
    
    public CafeteriaRequestService<CafeteriaRequest> cafeteriaRequestService;
    public LevelMasterService<LevelMaster> levelMasterService;
    public LocationMasterService<LocationMaster> locationMasterService;
    public Validator cafeteriaRequestValidator;
    protected UserRightMasterService<UserRightMaster> userRightMasterService;

    public UserRightMasterService<UserRightMaster> getUserRightMasterService() {
        return userRightMasterService;
    }

    public void setUserRightMasterService(UserRightMasterService<UserRightMaster> userRightMasterService) {
        this.userRightMasterService = userRightMasterService;
    }

    public CafeteriaRequestService<CafeteriaRequest> getCafeteriaRequestService() {
        return cafeteriaRequestService;
    }

    public void setCafeteriaRequestService(CafeteriaRequestService<CafeteriaRequest> cafeteriaRequestService) {
        this.cafeteriaRequestService = cafeteriaRequestService;
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

    public Validator getCafeteriaRequestValidator() {
        return cafeteriaRequestValidator;
    }

    public void setCafeteriaRequestValidator(Validator cafeteriaRequestValidator) {
        this.cafeteriaRequestValidator = cafeteriaRequestValidator;
    }
    

}
