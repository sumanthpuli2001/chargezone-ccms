/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller;

import com.bul.zydex.model.AppraisalFeedback360;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.ExitInterviewMaster;
import com.bul.zydex.model.LevelMaster;
import com.bul.zydex.model.NoDueMaster;
import com.bul.zydex.model.ProbationToConfirmation;
import com.bul.zydex.model.ResignationMaster;
import com.bul.zydex.model.UserMaster;
import com.bul.zydex.model.UserRightMaster;
import com.bul.zydex.service.UserRight.UserRightMasterService;
import com.bul.zydex.service.appraisal.Appraisal360Service;
import com.bul.zydex.service.exitInterview.ExitInterviewMasterService;
import com.bul.zydex.service.level.LevelMasterService;
import com.bul.zydex.service.nodue.NoDueMasterService;
import com.bul.zydex.service.probation.ProbationToConfirmationService;
import com.bul.zydex.service.resignation.ResignationMasterService;
import java.io.File;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.validation.Validator;

/**
 *
 * @author Administrator
 */
public abstract class UserMasterAbstract extends CustomAbstract {

    protected UserRightMasterService<UserRightMaster> userRightMasterService;
    protected LevelMasterService<LevelMaster> levelMasterService;
    protected Validator userInitPwdValidator;
//    protected static final Logger logger = Logger.getLogger(UserMasterAbstract.class);
    protected static final String PATH = "User" + File.separator;
    protected static final String HOME_PAGE = PATH + "Dashboard";
    protected static final String Direectory = "Dashboard" + File.separator;
    protected static final String HOME_PAGE_2 = Direectory + "HrDashBoard";
    protected Appraisal360Service<AppraisalFeedback360> appraisal360Service;
    protected ResignationMasterService<ResignationMaster> resignationMasterService;
    protected ExitInterviewMasterService<ExitInterviewMaster> exitInterviewMasterService;
    protected NoDueMasterService<NoDueMaster> noDueMasterService;
    protected ProbationToConfirmationService<ProbationToConfirmation> probationToConfirmationService;

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

    public NoDueMasterService<NoDueMaster> getNoDueMasterService() {
        return noDueMasterService;
    }

    public void setNoDueMasterService(NoDueMasterService<NoDueMaster> noDueMasterService) {
        this.noDueMasterService = noDueMasterService;
    }

    public ExitInterviewMasterService<ExitInterviewMaster> getExitInterviewMasterService() {
        return exitInterviewMasterService;
    }

    public void setExitInterviewMasterService(ExitInterviewMasterService<ExitInterviewMaster> exitInterviewMasterService) {
        this.exitInterviewMasterService = exitInterviewMasterService;
    }

    public ResignationMasterService<ResignationMaster> getResignationMasterService() {
        return resignationMasterService;
    }

    public void setResignationMasterService(ResignationMasterService<ResignationMaster> resignationMasterService) {
        this.resignationMasterService = resignationMasterService;
    }

    public Appraisal360Service<AppraisalFeedback360> getAppraisal360Service() {
        return appraisal360Service;
    }

    public void setAppraisal360Service(Appraisal360Service<AppraisalFeedback360> appraisal360Service) {
        this.appraisal360Service = appraisal360Service;
    }

    public UserRightMasterService<UserRightMaster> getUserRightMasterService() {
        return userRightMasterService;
    }

    public void setUserRightMasterService(UserRightMasterService<UserRightMaster> userRightMasterService) {
        this.userRightMasterService = userRightMasterService;
    }

    public Validator getUserInitPwdValidator() {
        return userInitPwdValidator;
    }

    public void setUserInitPwdValidator(Validator userInitPwdValidator) {
        this.userInitPwdValidator = userInitPwdValidator;
    }

    protected void addUserPersonals(HttpServletRequest request, UserMaster user) {
        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        employeeMaster.setUserMaster(user);
        List<?> list = employeeMasterService.readByUserName(employeeMaster);
        if (!list.isEmpty()) {
            session.setAttribute("employeeInfo", list.get(0));
        }
    }

    protected void addUserRight(HttpServletRequest request, UserMaster user) {
        HttpSession session = request.getSession();
        UserRightMaster userRightMaster = new UserRightMaster();
        userRightMaster.setUserMaster(user);
        List<?> list = userRightMasterService.readByUserRight(userRightMaster);
        if (!list.isEmpty()) {
            session.setAttribute("userRight", list.get(0));
        }
    }

    protected void addemployeeExit(HttpServletRequest request, UserMaster user) {
        HttpSession session = request.getSession(false);
        ResignationMaster resignationMaster = new ResignationMaster();
        ExitInterviewMaster exitInterviewMaster = new ExitInterviewMaster();
        NoDueMaster noDueMaster = new NoDueMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        employeeMaster.setUserMaster(user);
        List<?> empList = employeeMasterService.readByUserName(employeeMaster);
        if (!empList.isEmpty()) {
            employeeMaster = (EmployeeMaster) empList.get(0);
        }
        resignationMaster.setEmployeeMaster(employeeMaster);
        exitInterviewMaster.setEmployeeMasterByEmpId(employeeMaster);
        noDueMaster.setEmployeeMasterByEmpId(employeeMaster);
        List<?> resignationlist = resignationMasterService.readRegStatusList(resignationMaster);
        List<?> exitlist = exitInterviewMasterService.readExitStatusList(exitInterviewMaster);
//        List<?> noDuelist = noDueMasterService.readNoDueStatusList(noDueMaster);
        if (!resignationlist.isEmpty()) {
            session.setAttribute("resignationStatus", resignationlist.get(0));
        } else {
            session.setAttribute("resignationStatus", 5);
        }
        if (!exitlist.isEmpty()) {
            session.setAttribute("exitStatus", exitlist.get(0));
        } else {
            session.setAttribute("exitStatus", 5);
        }
//        if (!noDuelist.isEmpty()) {
//            session.setAttribute("noDueStatus", noDuelist.get(0));
//        }else{
//         session.setAttribute("noDueStatus", "noDueListEmpty");
//        }
    }

    protected void showUserImage(HttpServletRequest request, HttpSession session, UserMaster user) {

        String userName = user.getUserName();//user name for get userDirectory.
        String profilePicturePath = "";
        String fileLocationURL = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "UserProfile"
                + File.separator + userName + File.separator;
        File profilePicture = new File(fileLocationURL);
        if (profilePicture.exists() && profilePicture.listFiles().length > 0) {
            File[] file = profilePicture.listFiles();
            profilePicturePath = "StorageYard" + File.separator + "UserProfile" + File.separator + userName + File.separator + file[0].getName();
        } else {
            profilePicturePath = "StorageYard" + File.separator + "UserProfile" + File.separator + "User" + File.separator + "default.png";
        }
        session.setAttribute("profilePicturePath", profilePicturePath);

    }

}
