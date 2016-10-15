/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.empreferral;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.DepartmentMaster;
import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.model.EmployeeReferral;
import com.bul.zydex.model.LocationMaster;
import com.bul.zydex.model.PositionReferMaster;
import com.bul.zydex.model.UserRightMaster;
import com.bul.zydex.service.Position.PositionReferMasterService;
import com.bul.zydex.service.UserRight.UserRightMasterService;
import com.bul.zydex.service.empreferral.EmployeeReferralService;
import com.bul.zydex.service.location.LocationMasterService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.validation.Validator;

/**
 *
 * @author Irfan
 */
public class EmployeeReferralAbstract extends CustomAbstract {

    protected EmployeeReferralService<EmployeeReferral> employeeReferralService;
    protected LocationMasterService<LocationMaster> locationMasterService;
    protected PositionReferMasterService<PositionReferMaster> positionReferMasterService;
    protected Validator employeeReferralValidator;
    protected UserRightMasterService<UserRightMaster> userRightMasterService;

    public EmployeeReferralService<EmployeeReferral> getEmployeeReferralService() {
        return employeeReferralService;
    }

    public void setEmployeeReferralService(EmployeeReferralService<EmployeeReferral> employeeReferralService) {
        this.employeeReferralService = employeeReferralService;
    }

    public Validator getEmployeeReferralValidator() {
        return employeeReferralValidator;
    }

    public void setEmployeeReferralValidator(Validator employeeReferralValidator) {
        this.employeeReferralValidator = employeeReferralValidator;
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

    public PositionReferMasterService<PositionReferMaster> getPositionReferMasterService() {
        return positionReferMasterService;
    }

    public void setPositionReferMasterService(PositionReferMasterService<PositionReferMaster> positionReferMasterService) {
        this.positionReferMasterService = positionReferMasterService;
    }

    protected Map<Integer, String> readLocations() {
        LocationMaster locationMaster = new LocationMaster();
        List locationList = locationMasterService.read();
        Map<Integer, String> locationMap = new HashMap<Integer, String>();
        for (Object o : locationList) {
            locationMaster = (LocationMaster) o;
            locationMap.put(locationMaster.getId(), locationMaster.getLocation());
        }
        return locationMap;
    }

    protected Map<Integer, String> readDepartments() {
        DepartmentMaster departmentMaster = new DepartmentMaster();
        List departmentList = departmentMasterService.read();
        Map<Integer, String> departmentMap = new HashMap<Integer, String>();
        for (Object o : departmentList) {
            departmentMaster = (DepartmentMaster) o;
            departmentMap.put(departmentMaster.getId(), departmentMaster.getDepartmentName());
        }
        return departmentMap;
    }

    protected Map<Integer, String> readDesignations() {
        DesignationMaster designationMaster = new DesignationMaster();
        List designationList = designationMasterService.read();
        Map<Integer, String> designationMap = new HashMap<Integer, String>();
        for (Object o : designationList) {
            designationMaster = (DesignationMaster) o;
            designationMap.put(designationMaster.getId(), designationMaster.getDesignationName());
        }
        return designationMap;
    }
//this is a HashMap for show positions referring for employee in Employee Referral form 

    protected Map<Integer, String> getPositionReferalMap() {
        PositionReferMaster positionReferMaster = new PositionReferMaster();
        List positionList = positionReferMasterService.readPositionData();
        Map<Integer, String> positionReferMasterMap = new HashMap<Integer, String>();
        for (Object o : positionList) {
            positionReferMaster = (PositionReferMaster) o;
            positionReferMasterMap.put(positionReferMaster.getId(), positionReferMaster.getPositionName() + " - " + positionReferMaster.getPositionCode());
        }
        return positionReferMasterMap;
    }
    protected Map<Integer, String> getPosition() {
        PositionReferMaster positionReferMaster = new PositionReferMaster();
        List positionList = positionReferMasterService.read();
        Map<Integer, String> positionReferMasterMap = new HashMap<Integer, String>();
        for (Object o : positionList) {
            positionReferMaster = (PositionReferMaster) o;
            positionReferMasterMap.put(positionReferMaster.getId(), positionReferMaster.getPositionName() + " - " + positionReferMaster.getPositionCode());
        }
        return positionReferMasterMap;
    }
}
