/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.appraisal;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.AppraisalFeedback360;
import com.bul.zydex.model.DepartmentMaster;
import com.bul.zydex.model.LevelMaster;
import com.bul.zydex.model.LocationMaster;
import com.bul.zydex.model.UserRightMaster;
import com.bul.zydex.service.UserRight.UserRightMasterService;
import com.bul.zydex.service.appraisal.Appraisal360Service;
import com.bul.zydex.service.level.LevelMasterService;
import com.bul.zydex.service.location.LocationMasterService;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.Validator;

/**
 *
 * @author dhruv
 */
public class Appraisal360Abstract extends CustomAbstract {

    protected Appraisal360Service<AppraisalFeedback360> appraisal360Service;
    protected Validator appraisal360Validator;
    protected LevelMasterService<LevelMaster> levelMasterService;
    protected LocationMasterService<LocationMaster> locationMasterService;
    protected UserRightMasterService<UserRightMaster> userRightMasterService;

    public LevelMasterService<LevelMaster> getLevelMasterService() {
        return levelMasterService;
    }

    public void setLevelMasterService(LevelMasterService<LevelMaster> levelMasterService) {
        this.levelMasterService = levelMasterService;
    }

    public Appraisal360Service<AppraisalFeedback360> getAppraisal360Service() {
        return appraisal360Service;
    }

    public void setAppraisal360Service(Appraisal360Service<AppraisalFeedback360> appraisal360Service) {
        this.appraisal360Service = appraisal360Service;
    }

    public Validator getAppraisal360Validator() {
        return appraisal360Validator;
    }

    public void setAppraisal360Validator(Validator appraisal360Validator) {
        this.appraisal360Validator = appraisal360Validator;
    }

    public LocationMasterService<LocationMaster> getLocationMasterService() {
        return locationMasterService;
    }

    public void setLocationMasterService(LocationMasterService<LocationMaster> locationMasterService) {
        this.locationMasterService = locationMasterService;
    }

    public UserRightMasterService<UserRightMaster> getUserRightMasterService() {
        return userRightMasterService;
    }

    public void setUserRightMasterService(UserRightMasterService<UserRightMaster> userRightMasterService) {
        this.userRightMasterService = userRightMasterService;
    }
    public void department(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        List<?> deptList = departmentMasterService.read();
        String tempStr = "[";
        boolean flag = false;
        for (Iterator<? extends Object> it = deptList.iterator(); it.hasNext();) {
            DepartmentMaster departmentMaster = (DepartmentMaster) it.next();

            if (flag) {
                tempStr += ", ";
            }
            flag = true;
            tempStr += "{id: \"" + departmentMaster.getId()
                    + "\", name: \"" + departmentMaster.getDepartmentName()
                    + "\"}";

        }
        tempStr += "]";

        request.setAttribute("departmentList", tempStr);
    }
    
    public void level(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        List<?> levelList = levelMasterService.read();
        String tempStr = "[";
        boolean flag = false;
        for (Iterator<? extends Object> it = levelList.iterator(); it.hasNext();) {
            LevelMaster levelMaster = (LevelMaster) it.next();

            if (flag) {
                tempStr += ", ";
            }
            flag = true;
            tempStr += "{id: \"" + levelMaster.getId()
                    + "\", name: \"" + levelMaster.getLevel()
                    + "\"}";

        }
        tempStr += "]";

        request.setAttribute("levelList", tempStr);
    }  

}
