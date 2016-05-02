/*
 * 
 * Author Vinita
 */

package com.bul.zydex.controller.emprequest;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.GatePass;
import com.bul.zydex.model.LevelMaster;
import com.bul.zydex.model.LocationMaster;
import com.bul.zydex.model.UserRightMaster;
import com.bul.zydex.service.UserRight.UserRightMasterService;
import com.bul.zydex.service.emprequest.GatePassService;
import com.bul.zydex.service.level.LevelMasterService;
import com.bul.zydex.service.location.LocationMasterService;
import org.springframework.validation.Validator;

/**
 *
 * @author Vinita
 */
public abstract class GatePassAbstract extends CustomAbstract{
    
    public GatePassService<GatePass> gatePassService;
    public LevelMasterService<LevelMaster> levelMasterService;
    public LocationMasterService<LocationMaster> locationMasterService;
    public Validator gatePassValidator;
    protected UserRightMasterService<UserRightMaster> userRightMasterService;

    public UserRightMasterService<UserRightMaster> getUserRightMasterService() {
        return userRightMasterService;
    }

    public void setUserRightMasterService(UserRightMasterService<UserRightMaster> userRightMasterService) {
        this.userRightMasterService = userRightMasterService;
    }
    

    public GatePassService<GatePass> getGatePassService() {
        return gatePassService;
    }

    public void setGatePassService(GatePassService<GatePass> gatePassService) {
        this.gatePassService = gatePassService;
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

    public Validator getGatePassValidator() {
        return gatePassValidator;
    }

    public void setGatePassValidator(Validator gatePassValidator) {
        this.gatePassValidator = gatePassValidator;
    }

    
}
