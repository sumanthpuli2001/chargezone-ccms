/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.exitInterview;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.ExitInterviewMaster;
import com.bul.zydex.model.LevelMaster;
import com.bul.zydex.model.LocationMaster;
import com.bul.zydex.model.UserRightMaster;
import com.bul.zydex.model.ZydexLocationMaster;
import com.bul.zydex.service.UserRight.UserRightMasterService;
import com.bul.zydex.service.exitInterview.ExitInterviewMasterService;
import com.bul.zydex.service.level.LevelMasterService;
import com.bul.zydex.service.location.LocationMasterService;
import com.bul.zydex.service.zydexLocation.ZydexLocationMasterService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.validation.Validator;

/**
 *
 * @author dhruv
 */
public abstract class ExitInterviewMasterAbstract extends CustomAbstract {

    protected ExitInterviewMasterService<ExitInterviewMaster> exitInterviewMasterService;
    protected LevelMasterService<LevelMaster> levelMasterService;
    public LocationMasterService<LocationMaster> locationMasterService;
    public ZydexLocationMasterService<ZydexLocationMaster> zydexLocationMasterService;
    protected Validator exitInterviewMasterValidator;
    protected UserRightMasterService<UserRightMaster> userRightMasterService;

    public UserRightMasterService<UserRightMaster> getUserRightMasterService() {
        return userRightMasterService;
    }

    public void setUserRightMasterService(UserRightMasterService<UserRightMaster> userRightMasterService) {
        this.userRightMasterService = userRightMasterService;
    }

    public Validator getExitInterviewMasterValidator() {
        return exitInterviewMasterValidator;
    }

    public void setExitInterviewMasterValidator(Validator exitInterviewMasterValidator) {
        this.exitInterviewMasterValidator = exitInterviewMasterValidator;
    }

    public LevelMasterService<LevelMaster> getLevelMasterService() {
        return levelMasterService;
    }

    public void setLevelMasterService(LevelMasterService<LevelMaster> levelMasterService) {
        this.levelMasterService = levelMasterService;
    }

    public ExitInterviewMasterService<ExitInterviewMaster> getExitInterviewMasterService() {
        return exitInterviewMasterService;
    }

    public void setExitInterviewMasterService(ExitInterviewMasterService<ExitInterviewMaster> exitInterviewMasterService) {
        this.exitInterviewMasterService = exitInterviewMasterService;
    }

    public LocationMasterService<LocationMaster> getLocationMasterService() {
        return locationMasterService;
    }

    public void setLocationMasterService(LocationMasterService<LocationMaster> locationMasterService) {
        this.locationMasterService = locationMasterService;
    }

    public ZydexLocationMasterService<ZydexLocationMaster> getZydexLocationMasterService() {
        return zydexLocationMasterService;
    }

    public void setZydexLocationMasterService(ZydexLocationMasterService<ZydexLocationMaster> zydexLocationMasterService) {
        this.zydexLocationMasterService = zydexLocationMasterService;
    }

    public void setStatus(HttpServletRequest request) {
        Map<String, String> m1 = new HashMap();
        m1.put("Average", "Average");
        m1.put("Very Good", "Very Good");
        m1.put("Good", "Good");
        m1.put("Poor", "Poor");
//        m1.put("Excellent", "Excellent");
        request.setAttribute("status", m1);
    }

    public void setStatus1(HttpServletRequest request) {
        Map<String, String> m1 = new HashMap();
        m1.put("1", "1");
        m1.put("2", "2");
        m1.put("3", "3");
        m1.put("4", "4");
        m1.put("5", "5");
        m1.put("6", "6");

        request.setAttribute("status1", m1);
    }

    public void setStatus2(HttpServletRequest request) {
        Map<String, String> m1 = new HashMap();
        m1.put("true", "Yes");
        m1.put("false", "No");

        request.setAttribute("status2", m1);
    }

    public void setStatus3(HttpServletRequest request) {
        Map<String, String> m1 = new HashMap();
        m1.put("Never", "Never");
        m1.put("Seldom", "Seldom");
        m1.put("Often", "Often");
        m1.put("Regular", "Regular");
//        m1.put("Excellent", "Excellent");
        request.setAttribute("status3", m1);
    }
}
