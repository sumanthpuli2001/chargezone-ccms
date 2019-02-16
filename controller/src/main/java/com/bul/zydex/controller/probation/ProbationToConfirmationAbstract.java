/*
 *
 * Author Vinita
 */
package com.bul.zydex.controller.probation;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.EmployeeSubType;
import com.bul.zydex.model.LevelMaster;
import com.bul.zydex.model.LocationMaster;
import com.bul.zydex.model.ProbationPeriod;
import com.bul.zydex.model.ProbationToConfirmation;
import com.bul.zydex.model.UserRightMaster;
import com.bul.zydex.service.UserRight.UserRightMasterService;
import com.bul.zydex.service.emp.EmployeeSubTypeService;
import com.bul.zydex.service.level.LevelMasterService;
import com.bul.zydex.service.location.LocationMasterService;
import com.bul.zydex.service.probation.ProbationPeriodService;
import com.bul.zydex.service.probation.ProbationToConfirmationService;
import org.springframework.validation.Validator;

/**
 *
 * @author Vinita
 */
public abstract class ProbationToConfirmationAbstract extends CustomAbstract {

    public ProbationToConfirmationService<ProbationToConfirmation> probationToConfirmationService;
    public LevelMasterService<LevelMaster> levelMasterService;
    public LocationMasterService<LocationMaster> locationMasterService;
    public EmployeeSubTypeService<EmployeeSubType> employeeSubTypeService;
    public Validator probationtoConfirmationValidator;
    protected UserRightMasterService<UserRightMaster> userRightMasterService;
    protected ProbationPeriodService<ProbationPeriod> probationPeriodService;

    public UserRightMasterService<UserRightMaster> getUserRightMasterService() {
        return userRightMasterService;
    }

    public void setUserRightMasterService(UserRightMasterService<UserRightMaster> userRightMasterService) {
        this.userRightMasterService = userRightMasterService;
    }

    public ProbationToConfirmationService<ProbationToConfirmation> getProbationToConfirmationService() {
        return probationToConfirmationService;
    }

    public void setProbationToConfirmationService(ProbationToConfirmationService<ProbationToConfirmation> probationToConfirmationService) {
        this.probationToConfirmationService = probationToConfirmationService;
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

    public Validator getProbationtoConfirmationValidator() {
        return probationtoConfirmationValidator;
    }

    public void setProbationtoConfirmationValidator(Validator probationtoConfirmationValidator) {
        this.probationtoConfirmationValidator = probationtoConfirmationValidator;
    }

    public ProbationPeriodService<ProbationPeriod> getProbationPeriodService() {
        return probationPeriodService;
    }

    public void setProbationPeriodService(ProbationPeriodService<ProbationPeriod> probationPeriodService) {
        this.probationPeriodService = probationPeriodService;
    }

    public EmployeeSubTypeService<EmployeeSubType> getEmployeeSubTypeService() {
        return employeeSubTypeService;
    }

    public void setEmployeeSubTypeService(EmployeeSubTypeService<EmployeeSubType> employeeSubTypeService) {
        this.employeeSubTypeService = employeeSubTypeService;
    }
        
}
