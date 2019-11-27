/*
 * To change this license header, choose License Headers in Project Properties.changePassWordClick
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.emp;

import com.bul.zydex.model.ApplayJobUserMaster;
import com.bul.zydex.model.CandidateApplyJob;
import com.bul.zydex.model.CandidateJobApplication;
import com.bul.zydex.model.CompetencyEvaluationMaster;
import com.bul.zydex.model.CtcAllowance;
import com.bul.zydex.model.DepartmentMaster;
import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.model.EmailTemplate;
import com.bul.zydex.model.EmployeeCtcDetail;
import com.bul.zydex.model.EmployeeLeaveBalance;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.EmployeeMasterExtension;
import com.bul.zydex.model.EmployeePolicyDetail;
import com.bul.zydex.model.EmployeeSubType;
import com.bul.zydex.model.EmployeeTypeMaster;
import com.bul.zydex.model.EmployeeVisaDetails;
import com.bul.zydex.model.HoursBasis;
import com.bul.zydex.model.LeaveTypeMaster;
import com.bul.zydex.model.LevelMaster;
import com.bul.zydex.model.LocationMaster;
import com.bul.zydex.model.MprApprovalHistory;
import com.bul.zydex.model.PayrollPfCheck;
import com.bul.zydex.model.PayrollPtCheck;
import com.bul.zydex.model.PmpFormStatusMaster;
import com.bul.zydex.model.PolicyMaster;
import com.bul.zydex.model.ResignationMaster;
import com.bul.zydex.model.RotationMaster;
import com.bul.zydex.model.ShiftGenerateMonthlySchedule;
import com.bul.zydex.model.ShiftMaster;
import com.bul.zydex.model.ShiftRotationInfo;
import com.bul.zydex.model.ShiftRotationMaster;
import com.bul.zydex.model.UserMaster;
import com.bul.zydex.model.UserRightMaster;
import com.bul.zydex.model.ZydexLocationMaster;
import com.bul.zydex.service.emp.EmployeeVisaDetailsService;
import com.bul.zydex.service.resignation.ResignationMasterService;
import com.bul.zydex.util.DownloadFile;
import com.bul.zydex.validator.PasswordValidator;
import com.bul.zydex.validator.emp.EmployeeMasterExtensionValidator;
import com.google.gson.Gson;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.stream.Collectors;
import javafx.scene.control.Cell;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Administrator
 */
public class EmployeeMasterController extends EmployeeMasterAbstract {

    public ModelAndView createClick(HttpServletRequest request, HttpServletResponse response, EmployeeMaster employeeMaster) throws Exception {
        ModelAndView mv = new ModelAndView();
//        EmployeeMaster employeeMaster = new EmployeeMaster();
        DepartmentMaster departmentMaster = new DepartmentMaster();
        DesignationMaster designationMaster = new DesignationMaster();
        LevelMaster levelMaster = new LevelMaster();
        LocationMaster locationMaster = new LocationMaster();
        UserMaster userMaster = new UserMaster();
        EmployeeTypeMaster employeeTypeMaster = new EmployeeTypeMaster();
        EmployeeSubType employeeSubType = new EmployeeSubType();
        ZydexLocationMaster zydexLocationMaster = new ZydexLocationMaster();
//        ShiftMaster shiftMaster = new ShiftMaster();
        selectEmployee(request, response);
        selectedEmployeeLevel1(request, employeeMaster);
        departmentList(request);
        designationList(request);
        levelList(request);
        locationList(request);
        shiftRotaionList(request);
        setZydexLocationList(request);
        competencyList(request);
        EmployeeTypeList(request);
        EmployeeSubTypeList(request);
        companyList(request);
        policyList(request);
        ctcList(request);
        //master's data setting completed on request
//        shiftList(request);
        //-----------------------------------
        
        request.setAttribute("imgFile", "StorageYard" + File.separator + "UserProfile" + File.separator + "User" + File.separator + "default.png");
        
        //------------------------
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date cDate = new Date();
//        approvalMaster.setCreatedBy(approvalMaster1);
        String CureentDate = sdf.format(cDate);
        String[] endDateSplited = CureentDate.split("/");

        hoursBasisList(request);
        employeeMaster.setUserMaster(userMaster);
        employeeMaster.setLevelMaster(levelMaster);
        employeeMaster.setLocationMaster(locationMaster);
        employeeMaster.setDepartmentMaster(departmentMaster);
        employeeMaster.setDesignationMaster(designationMaster);
        employeeMaster.setZydexLocationMaster(zydexLocationMaster);
        employeeMaster.setEmployeeTypeMaster(employeeTypeMaster);
        employeeMaster.setEmployeeSubType(employeeSubType);
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.setViewName("Employee/EmployeeRegistrationForm");
        return mv;
    }

    public ModelAndView createSubmit(HttpServletRequest request, HttpServletResponse response, EmployeeMaster employeeMaster) throws Exception {
        ModelAndView mv = new ModelAndView();
//        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeLeaveBalance employeeLeaveBalance;
//        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        EmployeeSubType employeeSubType = new EmployeeSubType();
        BindException errors = new BindException(employeeMaster, "employeeMaster");
        UserMaster userMaster = new UserMaster();
        EmployeeMasterExtension employeeMasterExtension = new EmployeeMasterExtension();
        StringBuffer employeeMasterErrorStrBuf = new StringBuffer();
        //int indexCount = 1;
        
        //*************employee extension**************//
        String presentAddress2 = request.getParameter("presentAddress2");
        String presentCity = request.getParameter("presentCity");
        String presentState = request.getParameter("presentState");
        String presentPostalCode = request.getParameter("presentPostalCode");
        String presentCountry = request.getParameter("presentCountry");
        String permanentAddress2 = request.getParameter("permanentAddress2");
        String permanentCity = request.getParameter("permanentCity");
        String permanentState = request.getParameter("permanentState");
        String permanentPostalCode = request.getParameter("permanentPostalCode");
        String permanentCountry = request.getParameter("permanentCountry");
//         String religion=request.getParameter("religion");
        String disclosedHealthConcerns = request.getParameter("disclosedHealthConcerns");
        String languagesKnown = request.getParameter("languagesKnown");
        String hobbies = request.getParameter("hobbies");
        String childOneGender = request.getParameter("childOneGender");
        String childTwoGender = request.getParameter("childTwoGender");
        String flyDocsEmailId = request.getParameter("flyDocsEmailId");
        String emergencyContactAddress = request.getParameter("emergencyContactAddress");
        String RelationShip = request.getParameter("RelationShip");
        String otherImpInfo = request.getParameter("otherImpInfo");
        String nationality = request.getParameter("nationality");
        String firstName = request.getParameter("firstName");
        String middleName = request.getParameter("middleName");
        String lastName = request.getParameter("lastName");
//         String countryOfIssue=request.getParameter("countryOfIssue");

        String drivingLicenceType = request.getParameter("drivingLicenceType");
//         String electionCard=request.getParameter("electionCard");
        String pfNoFlydocs = request.getParameter("pfNoFlydocs");
        String withdrawalDate = request.getParameter("withdrawalDate");
        String nameOfPreviousCompany = request.getParameter("nameOfPreviousCompany");
        String previousCompanyLocation = request.getParameter("previousCompanyLocation");
//         String namestatus = request.getParameter("nameStatus");
        String spousegender = request.getParameter("SpouseGender");
//         String documentIdNo = request.getParameter("documentIdNo");
        String subteamTransferDate = request.getParameter("subteamTransferDate");
        String designationMasterByLevelId = request.getParameter("designationMasterByLevelId");
//         String officialContactNumber = request.getParameter("officialContactNumber");
        // ----------------------------------------------------
        employeeMasterExtension.setNationality(nationality);
        employeeMasterExtension.setFirstName(firstName);
        employeeMasterExtension.setMiddleName(middleName);
        employeeMasterExtension.setLastName(lastName);
        employeeMasterExtension.setPresentAddress2(presentAddress2);
        employeeMasterExtension.setPermanentAddress2(permanentAddress2);
        BindException errors2 = new BindException(employeeMasterExtension, "employeeMasterExtension");
        //----------------------------------------------------
        bind(request, employeeMaster);
        //Deopdown List//
        departmentList(request);
        designationList(request);
        levelList(request);
        locationList(request);
        shiftRotaionList(request);
        hoursBasisList(request);
        setZydexLocationList(request);
        competencyList(request);
        EmployeeTypeList(request);
        EmployeeSubTypeList(request);
        companyList(request);
        policyList(request);
        ctcList(request);

        //DeowpDown list//
//        String reasonForLeaving = request.getParameter("password");
        String userName = request.getParameter("userName");
//        String password = reasonForLeaving;
        String password = "";
        String employeeSubTypeId = request.getParameter("subTypeId");
//        String gender = request.getParameter("gender");
//        String reportingManagerLevel1 = request.getParameter("reportingManagerLevel1");
//        String reportingManagerLevel2 = request.getParameter("reportingManagerLevel2");
//        String reportingManagerLevel3 = request.getParameter("reportingManagerLevel3");
//        String reportingManagerLevel4 = request.getParameter("reportingManagerLevel4");
//        String reportingManagerLevel5 = request.getParameter("reportingManagerLevel5");
//        String reportingManagerLevel6 = request.getParameter("reportingManagerLevel6");
        String dateOfJoining = request.getParameter("dateOfJoining");
        String dateOfBirth = request.getParameter("dateOfBirth");
        String shiftMasterId = request.getParameter("shiftMasterId");
//        String competencyEvaluationId = request.getParameter("competencyEvaluationId");
        userMaster.setUserName(userName);
        if (employeeMaster.getUserMaster() != null) {
            if (employeeMaster.getUserMaster().getPassword() != null) {
                password = password + employeeMaster.getUserMaster().getPassword();
                //if we directly gettting 'employeeMaster.getUserMaster().getPassword()' its possibility for nullpointer exception.
            }
        }

        userMaster.setPassword(password);
        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
        Date DOB = new Date();
        Date DOJ = new Date();
        Date DOB1 = new Date();
        if (!"".equals(dateOfJoining)) {
            DOJ = sd.parse(dateOfJoining);

        }
        if (!"".equals(dateOfBirth)) {
            DOB = sd.parse(dateOfBirth);
            Calendar c1 = Calendar.getInstance();
            c1.setTime(DOB);
            c1.add(Calendar.YEAR, 18);
            DOB1 = c1.getTime();
        }
        if (null != employeeSubTypeId && !employeeSubTypeId.equals("")) {
            employeeSubType.setId(Integer.parseInt(employeeSubTypeId));
        }
        employeeMaster.setEmployeeSubType(employeeSubType);
        //-----------
//        DesignationMaster designationMaster = new DesignationMaster();
//        designationMaster.setId(231);
//        employeeMaster.setDesignationMaster(designationMaster);
        employeeMaster.setUserMaster(userMaster);
        
        //------------------------
//        if (!userMasterService.isExist(userName) && !userName.equals("") && !password.equals("")) {
//
//            userMasterService.create(userMaster);
//        } else {
//            request.setAttribute("failureMessage",
//                    "Error : User isExist.");
//            mv.addAllObjects(errors.getModel());
//            mv.setViewName("Employee/EmployeeRegistrationForm");
//        }
        
         
        EmployeeMasterExtensionValidator employeeExtensionValidator = new EmployeeMasterExtensionValidator();
        
        employeeMasterValidator.validate(employeeMaster, errors);
        employeeExtensionValidator.validate(employeeMasterExtension, errors2);
        
        if (errors.hasErrors() || errors2.hasErrors() || userMasterService.isExist(userName)) {
            //------------------ Get Policy detail data and display in jsp -----------------
             //Code to fetch policy details IN VIEW CLICK
            List finalPolicyList = new ArrayList();
  
            //Code for Employee Policy Detail
            //EmployeePolicyDetail employeePolicyDetail = new EmployeePolicyDetail();
            int otherDetailCount = Integer.parseInt(request.getParameter("policyCount"));
            for (int i = 1; i <= otherDetailCount; i++) {
                PolicyMaster policyMaster2 = new PolicyMaster();
                if (null != request.getParameter("policyId" + i) && null != request.getParameter("amount" + i)) {
                    if (!request.getParameter("policyId" + i).equals("") && !request.getParameter("amount" + i).equals("")) {
                        int policyId = Integer.parseInt(request.getParameter("policyId" + i));
                        policyMaster2 = policyMasterService.readById(policyId);
                        
                        List policyList = new ArrayList();
                        Double amount = Double.valueOf(request.getParameter("amount" + i));
                        
                        policyList.add(policyId);
                        policyList.add(policyMaster2.getPolicyName());
                        policyList.add(null);
                        policyList.add(amount);
                        if (null != request.getParameter("taxable" + i)) {
                            policyList.add(1);
                        } else {
                            policyList.add(0);
                        }
                        policyList.add(0);
                        finalPolicyList.add(policyList);
                   }
                }
            }
        
            request.setAttribute("finalPolicyList",finalPolicyList);  
            //------------------- End of Section policy ID --------------------
            //------------------ Start of total ctc section -------------------
            List finalctcList = new ArrayList();
            
             //Code for Employee ctc Detail
            EmployeeCtcDetail employeeCtcDetail = new EmployeeCtcDetail();
            int otherDetailCount1 = Integer.parseInt(request.getParameter("ctcCount"));
            for (int i = 1; i <= otherDetailCount1; i++) {
                CtcAllowance ctcAllowance2 = new CtcAllowance();
                if (null != request.getParameter("ctcId" + i) && null != request.getParameter("ctcamount" + i)) {
                    if (!request.getParameter("ctcId" + i).equals("") && !request.getParameter("ctcamount" + i).equals("")) {
                        int ctcId = Integer.parseInt(request.getParameter("ctcId" + i));
                        Double amount = Double.valueOf(request.getParameter("ctcamount" + i));
                        String month = request.getParameter("month" + i);
                        String year = request.getParameter("year" + i);
//                        String policyNumber = request.getParameter("policyNumber" + i);
                        
                        /*employeeCtcDetail.setEmployeeMaster(employeeMaster);
                        employeeCtcDetail.setAmount(amount);
                        employeeCtcDetail.setCtcAllowance(ctcAllowance);
                        if (null != request.getParameter("taxable" + i)) {
                            employeeCtcDetail.setStatus(1);
                        } else {
                            employeeCtcDetail.setStatus(0);
                        }
                        employeeCtcDetail.setMonth(month);
                        employeeCtcDetail.setYear(year);*/
                        
                        List ctcList = new ArrayList();
                        ctcList.add(ctcId);
                        ctcAllowance2 = ctcAllowanceService.readById(ctcId);
                        
                        ctcList.add(ctcAllowance2.getCtcName());
                        ctcList.add(amount);
                        if (null != request.getParameter("taxablectc" + i)) {
                            ctcList.add(1);
                        } else {
                            ctcList.add(0);
                        }
                        ctcList.add(month);
                        ctcList.add(year);
                        
                        ctcList.add(0);
                        finalctcList.add(ctcList);
                    }
                }
            }
            request.setAttribute("finalctcList",finalctcList);  
            //----------------- End of total ctc function ---------------------
            String shiftId = request.getParameter("shiftId");
            String shiftMasterId1 = request.getParameter("shiftMasterId");
            String HoursTitle = request.getParameter("shiftHoursId");
            //-------------------------------
            for (ObjectError individualError : errors2.getAllErrors()) {  
                String errorMsg = individualError.getCode();
                //request.setAttribute("failureMessage", " <br/> Employee No:"+ employeeNo + " Error Description : " + errorMsg );
                employeeMasterErrorStrBuf.append("<br/> - " + errorMsg);
                
                request.setAttribute(errorMsg.substring(0, 4), " - " + errorMsg);
            }
            //-------------------------------
//            *********************************************************************************
            if (!"".equals(shiftId) && shiftId != null) {
                employeeMaster.setShiftHoursId(Integer.parseInt(shiftId));
            } else if (!"".equals(HoursTitle) && HoursTitle != null) {
                employeeMaster.setShiftHoursId(Integer.parseInt(HoursTitle));
            }

//            employeeMaster.setShiftHoursId(Integer.parseInt(shiftId));
//           above line is commented because it produces "NumberFormatException" while we submits blank page
//            By Irfan
            
//         **********************************************************************************
            // Image presistance code -----------------
            /*String fileLocationURL = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "UserProfile"
                + File.separator + userMaster.getUserName() + File.separator;
            File photoFile = new File(fileLocationURL);
            //only single file always in it and all others will be deleted
            if (photoFile.exists() && photoFile.listFiles().length > 0) {
                File[] allPhotoes = photoFile.listFiles();
                if (allPhotoes.length == 1) {
                    allPhotoes[0].delete();
                }
            }
            //if no any directory with url available so new directory is created \\
            //But it will not happen because directory is created when user created First time time.
            if (!photoFile.exists()) {
                photoFile.mkdir();
            }
            MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
            MultipartFile multipartFile = multipartHttpServletRequest.getFile("photograph");
      
            //HttpSession session = request.getSession();
            File updatedPicture = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", ""));
            */
            
             String fileLocationURL = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "UserProfile"
                + File.separator + userName + File.separator;
             
                File photoFile = new File(fileLocationURL);
                //only single file always in it and all others will be deleted
                if (photoFile.exists() && photoFile.listFiles().length > 0) {
                    File[] allPhotoes = photoFile.listFiles();
                    if (allPhotoes.length == 1) {
                       // allPhotoes[0].delete();
                    }
                }
                //if no any directory with url available so new directory is created \\
                //But it will not happen because directory is created when user created First time time.
                if (!photoFile.exists()) {
                    photoFile.mkdir();
                }
                //MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
//                MultipartFile multipartFile = multipartHttpServletRequest.getFile("photographUpdate");
//
//                //HttpSession session = request.getSession();
//                File updatedPicture = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", ""));
//                multipartFile.transferTo(updatedPicture);

                if (photoFile.exists() && photoFile.listFiles().length > 0) {
                    File[] updatedPictureFiles = photoFile.listFiles();
                
                    request.setAttribute("imgFile", "StorageYard" + File.separator + "UserProfile" + File.separator + userName + File.separator + updatedPictureFiles[0].getName());
                }
            //----------------------------------------
            //--------------------
            request.setAttribute("presentAddress2",presentAddress2);  
            request.setAttribute("presentCity",presentCity); 
            request.setAttribute("presentState",presentCity); 
            request.setAttribute("presentPostalCode",presentCity); 
            request.setAttribute("presentCountry",presentCity); 
            request.setAttribute("permanentAddress2",permanentAddress2);
            request.setAttribute("permanentCity",presentCity); 
            request.setAttribute("permanentState",presentCity); 
            request.setAttribute("permanentPostalCode",presentCity); 
            request.setAttribute("permanentCountry",permanentCountry);
            request.setAttribute("disclosedHealthConcerns",disclosedHealthConcerns);
            request.setAttribute("languagesKnown",languagesKnown);
            request.setAttribute("hobbies",hobbies);
            request.setAttribute("flyDocsEmailId",flyDocsEmailId);  
            request.setAttribute("emergencyContactAddress",emergencyContactAddress);        
            request.setAttribute("RelationShip",RelationShip);      
            request.setAttribute("otherImpInfo",otherImpInfo);      
            request.setAttribute("previousCompanyLocation",previousCompanyLocation);        
            request.setAttribute("SpouseGender",spousegender);      
            request.setAttribute("subteamTransferDate",subteamTransferDate);        
            request.setAttribute("nationality",nationality);
            request.setAttribute("firstName",firstName);
            request.setAttribute("middleName",middleName);
            request.setAttribute("lastName",lastName);
            request.setAttribute("pfNoFlydocs",pfNoFlydocs);
            request.setAttribute("withdrawalDate",withdrawalDate);
            request.setAttribute("nameOfPreviousCompany",nameOfPreviousCompany);
            
            request.setAttribute("failureMessageExtension", employeeMasterErrorStrBuf);
            request.setAttribute("shiftName", shiftMasterId1);
            request.setAttribute("designationMasterByLevelId",designationMasterByLevelId);
            //----------
            //request.setAttribute("photographpresist",updatedPicture);
             //-----------
//            request.setAttribute("competencyEvaluationId", competencyEvaluationId);
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            if(userMasterService.isExist(userName))
            {
                request.setAttribute("failureMessage",
                    "Error : User is Exist!");
            }
                    
            mv.addAllObjects(errors.getModel());
            //mv.addAllObjects(errors2.getModel());
            selectEmployee(request, response);
            
            designationList(request);
            selectedEmployeeLevel1(request, employeeMaster);
//            request.setAttribute("employeeMaster", employeeMaster);
            mv.getModelMap().put("employeeMaster", employeeMaster);
            mv.setViewName("Employee/EmployeeRegistrationForm");
        } //        else if (DOJ.before(DOB1)) {
        //            request.setAttribute("failureMessage",
        //                    "Error : Enter Valid Date of Joining");
        //
        //            selectEmployee(request, response);
        //            selectedEmployeeLevel1(request, employeeMaster);
        //            request.setAttribute("employeeMaster", employeeMaster);
        //            mv.setViewName("Employee/EmployeeRegistrationForm");
        //        }
        else if (!userMasterService.isExist(userName) && !userName.equals("") && !"".equals(password)) {
            
            // Shifted following code from above error validation to after validation
            if (!userName.isEmpty()) {
                if (!employeeMasterService.isExistUSername(userName)) {
                    if (userMasterService.isExist(userName)) {
                        userMaster.setUserName(userName);
                        List<?> tempList = userMasterService.read(userMaster);
                        UserMaster user2;
                        user2 = (UserMaster) tempList.get(0);
                        userMasterService.delete(user2.getId());
                    }
                }
            }
            
            
//            if (!password.equals("")) {
//                if (employeeMaster.getShiftType().equals("HourlyBase")) {
            if ("HourlyBase".equals(employeeMaster.getShiftType())) {
                String hoursId = request.getParameter("shiftHoursId");
                if (null != hoursId && !hoursId.equals("")) {
                    employeeMaster.setShiftHoursId(Integer.parseInt(hoursId));
                }
            }
//                if (employeeMaster.getShiftType().equals("ShiftBase")) {
            if ("ShiftBase".equals(employeeMaster.getShiftType())) {
                String shfitId = request.getParameter("shiftId");
                if (null != shfitId && !shfitId.equals("")) {
                    employeeMaster.setShiftHoursId(Integer.parseInt(shfitId));
                }
            }

            // employee Code automically Generate 
            int employeeLoactionCode = employeeMaster.getLocationMaster().getId();
            LocationMaster ltm = locationMasterService.readById(employeeLoactionCode);
            String locationCode = ltm.getLocationCode();
            String empCodeString = "";
            SimpleDateFormat sdf11 = new SimpleDateFormat("dd/MM/yyyy");
            Date cDate = new Date();
//        approvalMaster.setCreatedBy(approvalMaster1);
            String CureentDate = sdf11.format(cDate);
            String[] endDateSplited = CureentDate.split("/");
            String empFormat = "";
            String month122 = endDateSplited[1];
            String year122 = endDateSplited[2];

//            List<?> empCodeList = employeeMasterService.readEmployeeCodeAutoGenerate();
//            Object[] codeList = (Object[]) empCodeList.get(0);
//            String oldempCode = codeList[1].toString();
//            String[] oldempCodeSplited = oldempCode.split("/");
//            String oldempcodesplit = oldempCodeSplited[4];
//            empCodeString = "SPCLS" + "/" + year122 + "/" + month122 + "/" + locationCode + "/" + (Integer.parseInt(oldempcodesplit) + 1);
//
//            employeeMaster.setAutoGenerationCode(empCodeString);
//            employeeMaster.setCompetencyEvaluationId(Integer.parseInt(competencyEvaluationId));
            // employeeMaster.setId(userMaster.getId());
            employeeMaster.setUserMaster(userMaster);
//                employeeMaster.setReportingManagerLevel1(reportingManagerLevel1);
//                employeeMaster.setReportingManagerLevel2(reportingManagerLevel2);
//                employeeMaster.setReportingManagerLevel3(reportingManagerLevel3);
//                employeeMaster.setReportingManagerLevel4(reportingManagerLevel4);
//                employeeMaster.setReportingManagerLevel5(reportingManagerLevel5);
//                employeeMaster.setReportingManagerLevel6(reportingManagerLevel6);
            employeeMaster.setPanCard(String.valueOf(employeeMaster.getPanCard()).toUpperCase());//this is for store pan card in uppercase in database.
            userMaster.setFirstTime(true);
//set firstTime is true for compulsory password change on first time login
            userMasterService.create(userMaster);
            String companyId = "4";

            employeeMaster.setCompany(companyId);
            
            String zid = "10";
            ZydexLocationMaster zydexLocationMaster = new ZydexLocationMaster();
            zydexLocationMaster.setId(Integer.parseInt(zid));
            employeeMaster.setZydexLocationMaster(zydexLocationMaster);
            employeeMasterService.create(employeeMaster);

            //***********employeeextension create*****************//
            employeeMasterExtension.setChildOneGender(Boolean.valueOf(childOneGender));
            employeeMasterExtension.setChildTwoGender(Boolean.valueOf(childTwoGender));
//            employeeMasterExtension.setNameStatus(Boolean.valueOf(namestatus));
            employeeMasterExtension.setSpouseGender(Boolean.valueOf(spousegender));
            employeeMasterExtension.setPresentAddress2(presentAddress2);
            employeeMasterExtension.setPresentCity(presentCity);
            employeeMasterExtension.setPresentState(presentState);
            employeeMasterExtension.setPresentPostalCode(presentPostalCode);
            employeeMasterExtension.setPresentCountry(presentCountry);
            employeeMasterExtension.setPermanentAddress2(permanentAddress2);
            employeeMasterExtension.setPermanentCity(permanentCity);
            employeeMasterExtension.setPermanentCountry(permanentCountry);
            employeeMasterExtension.setPermanentPostalCode(permanentPostalCode);
            employeeMasterExtension.setPermanentState(permanentState);
//            employeeMasterExtension.setReligion(religion);
            employeeMasterExtension.setDisclosedHealthConcerns(disclosedHealthConcerns);
            employeeMasterExtension.setLanguagesKnown(languagesKnown);
            employeeMasterExtension.setHobbies(hobbies);
            employeeMasterExtension.setFlyDocsEmailId(flyDocsEmailId);
            employeeMasterExtension.setEmergencyContactAddress(emergencyContactAddress);
            employeeMasterExtension.setOtherImpInfo(otherImpInfo);
            employeeMasterExtension.setRelationShip(RelationShip);
            employeeMasterExtension.setNationality(nationality);
            employeeMasterExtension.setFirstName(firstName);
            employeeMasterExtension.setMiddleName(middleName);
            employeeMasterExtension.setLastName(lastName);
//            employeeMasterExtension.setCountryOfIssue(countryOfIssue);
//                employeeMasterExtension.setVisaIssueCountry(visaIssueCountry);
//                employeeMasterExtension.setVisaIssueDate(visaIssueDate);
//                employeeMasterExtension.setVisaValidTillDate(visaValidTillDate);
            employeeMasterExtension.setDrivingLicenceType(drivingLicenceType);
//                employeeMasterExtension.setElectionCard(electionCard);
            employeeMasterExtension.setPfNoFlydocs(pfNoFlydocs);
            employeeMasterExtension.setWithdrawalDate(withdrawalDate);
            employeeMasterExtension.setNameOfPreviousCompany(nameOfPreviousCompany);
            employeeMasterExtension.setPreviousCompanyLocation(previousCompanyLocation);
//                employeeMasterExtension.setDocumentIdNo(documentIdNo);
//                employeeMasterExtension.setOfficialContactNumber(officialContactNumber);
            employeeMasterExtension.setSubteamTransferDate(subteamTransferDate);
            employeeMasterExtension.setEmployeeMaster(employeeMaster);
            employeeMasterServiceExtension.create(employeeMasterExtension);

            //***********employee visa doc create*****************//
//                int visaCount=Integer.parseInt(request.getParameter("visaCount"));
//                EmployeeVisaDetails employeeVisaDetails = new EmployeeVisaDetails();
//                for(int i = 1;i<=visaCount;i++){
//                    String visaIssueCountry=request.getParameter("visaIssueCountry"+i);
//                    String visaIssueDate=request.getParameter("visaIssueDate"+i);
//                    String visaValidTillDate=request.getParameter("visaValidTillDate"+i);
//                    employeeVisaDetails.setVisaIssueCountry(visaIssueCountry);
//                    employeeVisaDetails.setVisaIssueDate(visaIssueDate);
//                    employeeVisaDetails.setVisaValidTillDate(visaValidTillDate);
//                    employeeVisaDetails.setEmployeeMaster(employeeMaster);
//                    employeeVisaDetailsService.create(employeeVisaDetails);
//                }
            //Code for Employee Policy Detail
            EmployeePolicyDetail employeePolicyDetail = new EmployeePolicyDetail();
            int otherDetailCount = Integer.parseInt(request.getParameter("policyCount"));
            for (int i = 1; i <= otherDetailCount; i++) {
                PolicyMaster policyMaster = new PolicyMaster();
                if (null != request.getParameter("policyId" + i) && null != request.getParameter("amount" + i)) {
                    if (!request.getParameter("policyId" + i).equals("") && !request.getParameter("amount" + i).equals("")) {
                        int policyId = Integer.parseInt(request.getParameter("policyId" + i));
                        policyMaster.setId(policyId);
                        Double amount = Double.valueOf(request.getParameter("amount" + i));
                        String policyNumber = request.getParameter("policyNumber" + i);
                        employeePolicyDetail.setEmployeeMaster(employeeMaster);
                        employeePolicyDetail.setAmount(amount);
                        employeePolicyDetail.setPolicyMaster(policyMaster);
                        employeePolicyDetail.setPolicyNum(policyNumber);
                        if (null != request.getParameter("taxable" + i)) {
                            employeePolicyDetail.setStatus(1);
                        } else {
                            employeePolicyDetail.setStatus(0);
                        }
                        employeePolicyDetailService.create(employeePolicyDetail);
                    }
                }
            }
            //End
            //Code for Employee ctc Detail
            EmployeeCtcDetail employeeCtcDetail = new EmployeeCtcDetail();
            int otherDetailCount1 = Integer.parseInt(request.getParameter("ctcCount"));
            for (int i = 1; i <= otherDetailCount1; i++) {
                CtcAllowance ctcAllowance = new CtcAllowance();
                if (null != request.getParameter("ctcId" + i) && null != request.getParameter("ctcamount" + i)) {
                    if (!request.getParameter("ctcId" + i).equals("") && !request.getParameter("ctcamount" + i).equals("")) {
                        int ctcId = Integer.parseInt(request.getParameter("ctcId" + i));
                        ctcAllowance.setId(ctcId);
                        Double amount = Double.valueOf(request.getParameter("ctcamount" + i));
                        String month = request.getParameter("month" + i);
                        String year = request.getParameter("year" + i);
//                        String policyNumber = request.getParameter("policyNumber" + i);
                        employeeCtcDetail.setEmployeeMaster(employeeMaster);
                        employeeCtcDetail.setAmount(amount);
                        employeeCtcDetail.setCtcAllowance(ctcAllowance);
                        if (null != request.getParameter("taxablectc" + i)) {
                            employeeCtcDetail.setStatus(1);
                        } else {
                            employeeCtcDetail.setStatus(0);
                        }
                        employeeCtcDetail.setMonth(month);
                        employeeCtcDetail.setYear(year);
                        employeeCtcDetailService.create(employeeCtcDetail);
                    }
                }
            }
            //End

//            //Code for Payroll Provident
//            int empId = employeeMaster.getEmployeeTypeMaster().getId();
//            int empSubId = employeeMaster.getEmployeeSubType().getId();
//            EmployeeTypeMaster employeeTypeMaster = new EmployeeTypeMaster();
//            employeeTypeMaster.setId(empId);
//            EmployeeSubType employeeSubTypeMaster = new EmployeeSubType();
//            employeeSubTypeMaster.setId(empSubId);
//            Boolean pfCheck = payrollPfCheckService.isExistPF(empId, empSubId);
//            if (!pfCheck) {
//                PayrollPfCheck payrollPfCheck = new PayrollPfCheck();
//                payrollPfCheck.setEmployeeSubType(employeeSubTypeMaster);
//                payrollPfCheck.setEmployeeTypeMaster(employeeTypeMaster);
//                if (null != request.getParameter("pf")) {
//                    if (!request.getParameter("pf").equals("")) {
//                        if (request.getParameter("pf").equals("true")) {
//                            payrollPfCheck.setPfCheck(true);
//                        } else {
//                            payrollPfCheck.setPfCheck(false);
//                        }
//                        payrollPfCheckService.create(payrollPfCheck);
//                    }
//                }
//            }
//            Boolean ptCheck = payrollPtCheckService.isExistPT(empId, empSubId);
//            if (!ptCheck) {
//                PayrollPtCheck payrollPtCheck = new PayrollPtCheck();
//                payrollPtCheck.setEmployeeSubType(employeeSubTypeMaster);
//                payrollPtCheck.setEmployeeTypeMaster(employeeTypeMaster);
//                if (null != request.getParameter("pt")) {
//                    if (!request.getParameter("pt").equals("")) {
//                        if (request.getParameter("pt").equals("true")) {
//                            payrollPtCheck.setPtCheck(true);
//                        } else {
//                            payrollPtCheck.setPtCheck(false);
//                        }
//                        payrollPtCheckService.create(payrollPtCheck);
//                    }
//                }
//            }
            //End
            PmpFormStatusMaster pmpFormStatusMaster = new PmpFormStatusMaster();
            pmpFormStatusMaster.setEmployeeMaster(employeeMaster);
            pmpFormStatusMaster.setStartYearStatus(false);
            pmpFormStatusMaster.setMidYearStatus(false);
            pmpFormStatusMaster.setEndYearStatus(false);
            pmpFormStatusMaster.setManagerSide(false);
            pmpFormStatusMaster.setEmployeeSide(false);
            pmpFormStatusMaster.setCompentencyEmployeeSide(false);
            pmpFormStatusMaster.setCompentencyEndYearStatus(false);
            pmpFormStatusMaster.setCompentencyManagerSide(false);
            pmpFormStatusMaster.setCompentencyMidYearStatus(false);
            pmpFormStatusMaster.setCompentencyStartYearStatus(false);
            pmpFormStatusMasterService.create(pmpFormStatusMaster);

            //employeeMaster.setEmployeeId("" + employeeMaster1);
            boolean isLeapYear = false;
            //---------- Start of Leave Section ----------------------
//            LeaveTypeMaster leaveTypeMaster = new LeaveTypeMaster();
//            List<?> leaveType = leaveTypeMasterService.read();
//            final boolean gender_Female = employeeMaster.getGender();
//            String marital_status = employeeMaster.getMaritalStatus();
//            for (Object o : leaveType) {
//                employeeLeaveBalance = new EmployeeLeaveBalance();
//                leaveTypeMaster = (LeaveTypeMaster) o;
//                employeeLeaveBalance.setLeaveTypeMaster(leaveTypeMaster);
//                employeeLeaveBalance.setEmployeeMaster(employeeMaster);
//                String noOfLeave = "" + leaveTypeMaster.getNoOfLeave();
//                String leave = "" + leaveTypeMaster.getLeaveType();
//                Calendar cal1 = new GregorianCalendar();
//                Calendar cal2 = new GregorianCalendar();
//                Calendar gc = new GregorianCalendar();
//                int year = gc.get(Calendar.YEAR);
//                String cyear = "" + year;
//                String dateOfEndMonth = "31/12/";
//                String dateOfEnd = dateOfEndMonth + cyear;
//                if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
//                    isLeapYear = true;
//                }
//                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//
//                Date date1 = sdf.parse(dateOfJoining);
//                Date date3 = new Date();
//                cal1.setTime(date1);
//                Date date2 = sdf.parse(dateOfEnd);
//                cal2.setTime(date2);
//                int y = Integer.parseInt(noOfLeave);
//                long days = 0;
//                if (date1.before(date3)) {
//                    days = date2.getTime() - date3.getTime();
//                } else {
//                    days = date2.getTime() - date1.getTime();
//                }
//                long diffDays = days / (24 * 60 * 60 * 1000) + 1;
//                if (leave.equals("Sick Leave")) {
//                    if (isLeapYear == true) {
//                        long SL = (diffDays * y / 366) + 1;
//                        employeeLeaveBalance.setNoOfLeaveRemain(SL);
//                    } else {
//                        long SL = (diffDays * y / 365) + 1;
//                        employeeLeaveBalance.setNoOfLeaveRemain(SL);
//                    }
//                } else if (leave.equals("Casual Leave")) {
//                    if (isLeapYear == true) {
//                        long CL = (diffDays * y / 366) + 1;
//                        employeeLeaveBalance.setNoOfLeaveRemain(CL);
//                    } else {
//                        long CL = (diffDays * y / 365) + 1;
//                        employeeLeaveBalance.setNoOfLeaveRemain(CL);
//                    }
//                } //                else if (leave.equals("Privilege Leave")) {
//                //                    if (isLeapYear == true) {
//                //                        long PL = (diffDays * y / 366) + 1;
//                //                        employeeLeaveBalance.setNoOfLeaveRemain(PL);
//                //                    } else {
//                //                        long PL = (diffDays * y / 365) + 1;
//                //                        employeeLeaveBalance.setNoOfLeaveRemain(PL);
//                //                    }
//                //                }
//                else if (leave.equals("Paternity Leave") && !gender_Female && marital_status.equals("Married")) {
//                    if (isLeapYear == true) {
////                        long PAT = (diffDays * y / 366) + 1;
//                        long PAT = 6;
//                        employeeLeaveBalance.setNoOfLeaveRemain(PAT);
//                    } else {
//                        long PAT = 6;
//                        employeeLeaveBalance.setNoOfLeaveRemain(PAT);
//                    }
//                } else if (leave.equals("Maternity Leave")) {
//                    if (gender_Female) {
//                        long ML = 0;
//                        employeeLeaveBalance.setNoOfLeaveRemain(ML);
//                    }
//                } else if (leave.equals("Short Leave")) {
//                    if (isLeapYear == true) {
//                        long SHL = (diffDays * y / 366) + 1;
//                        employeeLeaveBalance.setNoOfLeaveRemain(SHL);
//                    } else {
//                        long SHL = (diffDays * y / 365) + 1;
//                        employeeLeaveBalance.setNoOfLeaveRemain(SHL);
//                    }
//                } else if (leave.equals("Leave Without Pay")) {
//                    if (isLeapYear == true) {
//                        long LWP = (diffDays * y / 366) + 1;
//                        employeeLeaveBalance.setNoOfLeaveRemain(LWP);
//                    } else {
//                        long LWP = (diffDays * y / 365) + 1;
//                        employeeLeaveBalance.setNoOfLeaveRemain(LWP);
//                    }
//                }
//
//                employeeLeaveBalanceService.create(employeeLeaveBalance);
//
//            }
            //--------------------- End of Leave Section -----------------
            ShiftRotationInfo shiftRotationInfo = new ShiftRotationInfo();
            ShiftRotationInfo shiftRotationInfo1 = new ShiftRotationInfo();
            ShiftRotationMaster shiftRotationMaster = new ShiftRotationMaster();
//                EmployeeMaster employeeMaster = (EmployeeMaster) request.getAttribute("employeeMaster");
//                UserMaster userMaster = (UserMaster) request.getAttribute("userMaster");
//                String shiftMasterId = request.getAttribute("shiftMasterId").toString();
            if (null != shiftMasterId && !"".equals(shiftMasterId)) {

                shiftRotationInfo.setFirstShiftId(Integer.parseInt(shiftMasterId));
                shiftRotationInfo.setUserMaster(userMaster);

                List<?> list = shiftRotationInfoService.readRotaionDetail(shiftRotationInfo);
                if (!list.isEmpty()) {

                    shiftRotationInfo = (ShiftRotationInfo) list.get(0);
                }
                if (shiftRotationInfo.getId() == null) {
                    shiftRotationMaster.setId(employeeMaster.getShiftHoursId());
                    shiftRotationInfo.setShiftRotationMaster(shiftRotationMaster);
                    shiftRotationInfo.setRotationDate(employeeMaster.getShiftRotationDate());

                    shiftRotationInfoService.create(shiftRotationInfo);
                }

            }
//        Code for Shift generate monthly Schedule(Start)
//                if (employeeMaster.getShiftType().equals("ShiftBase")) {
            if ("ShiftBase".equals(employeeMaster.getShiftType())) {
                ShiftGenerateMonthlySchedule shiftGenerateMonthlySchedule = new ShiftGenerateMonthlySchedule();
                shiftGenerateMonthlySchedule.setEmployeeMaster(employeeMaster);
//                     shiftMasterId
                String shfitId = "" + request.getParameter("shiftId");
                String shiftRotationDate = "" + request.getParameter("shiftRotationDate");
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date rd = sdf.parse(shiftRotationDate);
                LocalDate localDate = rd.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                int year = localDate.getYear();
                String cyear = "" + year;
                int month = localDate.getMonthValue();
                String cmonth = "" + month;
                int dayofmonth = localDate.getDayOfMonth();
                String cdayofmonth = "" + dayofmonth;
//                     shiftGenerateMonthlySchedule.setShiftMonth(cmonth);
//                     shiftGenerateMonthlySchedule.setShiftYear(cyear);
                Calendar c = Calendar.getInstance();
                Date newDate = c.getTime();
                int tday = c.get(Calendar.DATE);
                shiftRotationMaster = shiftRotationMasterService.readById(Integer.parseInt(shfitId));
                String duration = "" + shiftRotationMaster.getDuration();
                int day = c.getActualMaximum(Calendar.DAY_OF_MONTH);
                RotationMaster rotationMaster = new RotationMaster();
                rotationMaster.setShiftRotationMaster(shiftRotationMaster);

                if ("monthly".equals(duration) && day == 30) {
                    weeklyGenerate(rotationMaster, rd, shiftRotationMaster, 30, employeeMaster, shiftMasterId);
                } else if ("weekly".equals(duration)) {
                    weeklyGenerateShift(rotationMaster, rd, shiftRotationMaster, 7, employeeMaster, shiftMasterId);
                } else if ("fortNightly".equals(duration)) {
                    weeklyGenerate(rotationMaster, rd, shiftRotationMaster, 14, employeeMaster, shiftMasterId);
                } else {
                    weeklyGenerate(rotationMaster, rd, shiftRotationMaster, day, employeeMaster, shiftMasterId);
                }
            }
//        Code for Shift generate monthly Schedule(End)

//////Make Dir///////
//            String userName = (String) request.getSession().getAttribute("userName");
            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "UserProfile"
                    + File.separator + userName + File.separator;
            //String basePath = getServletContext().getRealPath("/") + "StorageYard" + File.separator + "DigitalSignature" + File.separator + userName + File.separator;
            File profilePictureFile = new File(fileLocationURL);//file directory
//                File profilePicture = profilePictureFile.listFiles()[0];//First File Of Directory.
            if (profilePictureFile.exists() && profilePictureFile.listFiles().length > 0) {
                File[] profilePictureArray = profilePictureFile.listFiles();
                try {
                    request.setAttribute("imageFile", "StodirageYard" + File.separator + "UserProfile" + File.separator + userName + File.separator + profilePictureArray[0].getName().replaceAll(" ", ""));
                } catch (Exception e) {
                }
            }
//                String fileLocationURL1 = getServletContext().getRealPath("")
//                        + File.separator + "StorageYard" + File.separator + "DigitalSignature"
//                        + File.separator + userName + File.separator;
            // Commented later on
//            if (profilePictureFile.exists() && profilePictureFile.listFiles().length > 0) {
//                File[] profilePictureArray = profilePictureFile.listFiles();
//                profilePictureArray[0].delete();//if file exist then delete it.
//            }

            if (!profilePictureFile.exists()) {
                profilePictureFile.mkdir();//make directory for first time user creation.
            }
            //File Photo Uploard///
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            ////this code is using loop but there is actually only one image so changed for only single file
//                String url = "";
//                List<MultipartFile> multipartFile2 = multipartRequest.getFiles("photograph");
//                for (MultipartFile multipartFile1 : multipartFile2) {
//                    if (multipartFile1.getSize() > 0) {
//                        File file2 = new File(fileLocationURL + File.separator
//                                + multipartFile1.getOriginalFilename());
//                        url = fileLocationURL + File.separator + multipartFile1.getOriginalFilename();
//                        multipartFile1.transferTo(file2);
//                    }
//                }
            ////this is changed code for only one file.
            /*MultipartFile multipartFile = multipartRequest.getFile("photograph");
            if (multipartFile != null && multipartFile.getSize() > 0) {
                //null if there is no photograph in form.
                //this condition checking not required if photograph field is compulsary in form.
                try {

                    File file2 = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", ""));
                    multipartFile.transferTo(file2);
                } catch (Exception e) {

                }
            }*/
            //---------------------------
            
            //---------------------------
//            Certificate attach code
            String certificateFileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "UserCertificate"
                    + File.separator + userName + File.separator;
            File certificateListFile = new File(certificateFileLocationURL);
            if (certificateListFile.exists() && certificateListFile.listFiles().length > 0) {
                File[] certificateListFileArray = certificateListFile.listFiles();
                try {
                    request.setAttribute("imageFile", "StorageYard" + File.separator + "UserCertificate" + File.separator + userName + File.separator + certificateListFileArray[0].getName().replaceAll(" ", ""));
                } catch (Exception e) {
                }
            }
            if (!certificateListFile.exists()) {
                certificateListFile.mkdirs();
            }
            String firstStepCount = request.getParameter("firstStepCount");
            for (int i = 1; i <= Integer.parseInt(firstStepCount); i++) {

//                String certificateId = request.getParameter("certificateId" + i);
                MultipartFile multipartFile1 = multipartRequest.getFile("certificateId" + i);
                if (multipartFile1 != null && multipartFile1.getSize() > 0) {
                    try {
                        File file3 = new File(certificateFileLocationURL + multipartFile1.getOriginalFilename().replaceAll(" ", ""));
                        multipartFile1.transferTo(file3);
                    } catch (Exception e) {

                    }
                }

            }

//            Certificate attach code
            //now setting default right as employee.
            setDefaultUserRights(request, employeeMaster);

            request.setAttribute("successMessage",
                    "Information : The Information Is Saved Successfully."
                    + "<br/>"
                    + "You Must Provide UserRights For Allow Successfull Login Of Newly Registered User.");
//            } else {
//                request.setAttribute("failureMessage",
//                        "Error : The Entered Information is not valid.");
//
//            }
            int userMasterId = 0;
            if (employeeMaster.getUserMaster() != null) {
                userMasterId = employeeMaster.getUserMaster().getId();
            }
            try {
                EmailTemplate emailTemplate = new EmailTemplate();
                // id 138 is for Newly Registered User....
                emailTemplate = emailTemplateService.readById(138);
                String To = employeeMaster.getOfficeEmailId();
                String from = "";
                String Subject = emailTemplate.getSubject();
//                Subject = Subject.replaceAll("\\{user\\}", employeeMasterModel.getEmployeeName());
                String msg = emailTemplate.getBodytext();
                msg = msg.replaceAll("\\{user\\}", employeeMaster.getEmployeeName());
                msg = msg.replaceAll("\\{user_id\\}", userMaster.getUserName());
                msg = msg.replaceAll("\\{user_pwd\\}", userMaster.getPassword());
//                msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
//                msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                sendMail.sendMail(from, To, Subject, msg);
            } catch (Exception e) {
            }
            mv.setViewName("forward:userRightMaster.htm?act=createClick&id=" + String.valueOf(userMasterId));
        } else {
            
            //=============================================================================
            
            //------------------ Get Policy detail data and display in jsp -----------------
             //Code to fetch policy details IN VIEW CLICK
            List finalPolicyList = new ArrayList();
  
            //Code for Employee Policy Detail
            //EmployeePolicyDetail employeePolicyDetail = new EmployeePolicyDetail();
            int otherDetailCount = Integer.parseInt(request.getParameter("policyCount"));
            for (int i = 1; i <= otherDetailCount; i++) {
                PolicyMaster policyMaster2 = new PolicyMaster();
                if (null != request.getParameter("policyId" + i) && null != request.getParameter("amount" + i)) {
                    if (!request.getParameter("policyId" + i).equals("") && !request.getParameter("amount" + i).equals("")) {
                        int policyId = Integer.parseInt(request.getParameter("policyId" + i));
                        policyMaster2 = policyMasterService.readById(policyId);
                        
                        List policyList = new ArrayList();
                        Double amount = Double.valueOf(request.getParameter("amount" + i));
                        
                        policyList.add(policyId);
                        policyList.add(policyMaster2.getPolicyName());
                        policyList.add(null);
                        policyList.add(amount);
                        if (null != request.getParameter("taxable" + i)) {
                            policyList.add(1);
                        } else {
                            policyList.add(0);
                        }
                        policyList.add(0);
                        finalPolicyList.add(policyList);
                   }
                }
            }
        
            request.setAttribute("finalPolicyList",finalPolicyList);  
            //------------------- End of Section policy ID --------------------
            //------------------ Start of total ctc section -------------------
            List finalctcList = new ArrayList();
            
             //Code for Employee ctc Detail
            EmployeeCtcDetail employeeCtcDetail = new EmployeeCtcDetail();
            int otherDetailCount1 = Integer.parseInt(request.getParameter("ctcCount"));
            for (int i = 1; i <= otherDetailCount1; i++) {
                CtcAllowance ctcAllowance2 = new CtcAllowance();
                if (null != request.getParameter("ctcId" + i) && null != request.getParameter("ctcamount" + i)) {
                    if (!request.getParameter("ctcId" + i).equals("") && !request.getParameter("ctcamount" + i).equals("")) {
                        int ctcId = Integer.parseInt(request.getParameter("ctcId" + i));
                        Double amount = Double.valueOf(request.getParameter("ctcamount" + i));
                        String month = request.getParameter("month" + i);
                        String year = request.getParameter("year" + i);
//                        String policyNumber = request.getParameter("policyNumber" + i);
                                                                       
                        List ctcList = new ArrayList();
                        ctcList.add(ctcId);
                        ctcAllowance2 = ctcAllowanceService.readById(ctcId);
                        
                        ctcList.add(ctcAllowance2.getCtcName());
                        ctcList.add(amount);
                        if (null != request.getParameter("taxablectc" + i)) {
                            ctcList.add(1);
                        } else {
                            ctcList.add(0);
                        }
                        ctcList.add(month);
                        ctcList.add(year);
                        
                        ctcList.add(0);
                        finalctcList.add(ctcList);
                    }
                }
            }
            request.setAttribute("finalctcList",finalctcList);  
            //----------------- End of total ctc function ---------------------
            String shiftId = request.getParameter("shiftId");
            String shiftMasterId1 = request.getParameter("shiftMasterId");
            String HoursTitle = request.getParameter("shiftHoursId");
            //-------------------------------
            for (ObjectError individualError : errors2.getAllErrors()) {  
                String errorMsg = individualError.getCode();
                //request.setAttribute("failureMessage", " <br/> Employee No:"+ employeeNo + " Error Description : " + errorMsg );
                employeeMasterErrorStrBuf.append("<br/> - " + errorMsg);
                
                request.setAttribute(errorMsg.substring(0, 4), " - " + errorMsg);
            }
            //-------------------------------
//            *********************************************************************************
            if (!"".equals(shiftId) && shiftId != null) {
                employeeMaster.setShiftHoursId(Integer.parseInt(shiftId));
            } else if (!"".equals(HoursTitle) && HoursTitle != null) {
                employeeMaster.setShiftHoursId(Integer.parseInt(HoursTitle));
            }

//            employeeMaster.setShiftHoursId(Integer.parseInt(shiftId));
//           above line is commented because it produces "NumberFormatException" while we submits blank page
//            By Irfan
            
//         **********************************************************************************
            //--------------------
            request.setAttribute("presentAddress2",presentAddress2);  
            request.setAttribute("presentCity",presentCity); 
            request.setAttribute("presentState",presentCity); 
            request.setAttribute("presentPostalCode",presentCity); 
            request.setAttribute("presentCountry",presentCity); 
            request.setAttribute("permanentAddress2",permanentAddress2);
            request.setAttribute("permanentCity",presentCity); 
            request.setAttribute("permanentState",presentCity); 
            request.setAttribute("permanentPostalCode",presentCity); 
            request.setAttribute("permanentCountry",permanentCountry);
            request.setAttribute("disclosedHealthConcerns",disclosedHealthConcerns);
            request.setAttribute("languagesKnown",languagesKnown);
            request.setAttribute("hobbies",hobbies);
            request.setAttribute("flyDocsEmailId",flyDocsEmailId);  
            request.setAttribute("emergencyContactAddress",emergencyContactAddress);        
            request.setAttribute("RelationShip",RelationShip);      
            request.setAttribute("otherImpInfo",otherImpInfo);      
            request.setAttribute("previousCompanyLocation",previousCompanyLocation);        
            request.setAttribute("SpouseGender",spousegender);      
            request.setAttribute("subteamTransferDate",subteamTransferDate);        
            request.setAttribute("nationality",nationality);
            request.setAttribute("firstName",firstName);
            request.setAttribute("middleName",middleName);
            request.setAttribute("lastName",lastName);
            request.setAttribute("pfNoFlydocs",pfNoFlydocs);
            request.setAttribute("withdrawalDate",withdrawalDate);
            request.setAttribute("nameOfPreviousCompany",nameOfPreviousCompany);
            
            request.setAttribute("failureMessageExtension", employeeMasterErrorStrBuf);
            request.setAttribute("shiftName", shiftMasterId1);
            request.setAttribute("designationMasterByLevelId",designationMasterByLevelId);
            
//            request.setAttribute("competencyEvaluationId", competencyEvaluationId);
            
            designationList(request);
            //-----------------------------------------------------------------------------
            request.setAttribute("failureMessage",
                    "Error : User isExist.");
            
            selectEmployee(request, response);
            selectedEmployeeLevel1(request, employeeMaster);
            mv.getModelMap().put("employeeMaster", employeeMaster);
            mv.addAllObjects(errors.getModel());
            mv.setViewName("Employee/EmployeeRegistrationForm");

        }
//            mv.getModelMap().put("userMaster", userMaster);
//            mv.getModelMap().put("shiftMasterId", shiftMasterId);
//            if (employeeMaster.getShiftType().equals("ShiftBase")) {
//
//                mv.setViewName("forward:shiftRotationInfo.htm?act=createSubmit");
//            } else {
//
//                mv.setViewName("Employee/EmployeeRegistrationForm");
//            }
        mv.getModelMap().put("employeeMaster", employeeMaster);
         // Employee master extension starts here

        //Employee master extension ends here
        return mv;

    }

    public ModelAndView searchSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = new EmployeeMaster();
//        List<?> employeeMasterList = employeeMasterService.read();

        EmployeeTypeList(request);
        EmployeeSubTypeOnlyUniqueList(request);
        List<?> employeeMasterList = employeeMasterService.readEmployeesDetail();
        mv.getModelMap().put("list", employeeMasterList);
        //dont rename "list" because same used on getEmployeeDetailsBySearchString method and employeeRegistrationResult.jsp
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.setViewName("Employee/EmployeeRegistrationResult");

        return mv;
    }

    public ModelAndView viewClick(HttpServletRequest request, HttpServletResponse response, EmployeeMaster employeeMaster) throws Exception {
        ModelAndView mv = new ModelAndView();
        String lastYearPerformanceRatingsOfEmployee = "";
//        EmployeeMaster employeeMaster = new EmployeeMaster();
        UserRightMaster user = (UserRightMaster) request.getSession().getAttribute("userRight");
        //set Employee master id//
        int id = Integer.parseInt(request.getParameter("id"));
//        employeeMaster.setId(Integer.parseInt(id));
//        employeeMaster.setEmployeeId(id);
        //set Employee master id//
        EmployeeTypeMaster employeeTypeMaster = new EmployeeTypeMaster();
//        EmployeeMasterExtension employeeMasterExtension = new EmployeeMasterExtension();
        EmployeeSubType employeeSubType = new EmployeeSubType();
        UserMaster userMaster = new UserMaster();
        // Employee Extension
        employeeMaster = employeeMasterService.readById(id);
        List<?> employeeMasterExtensionList = employeeMasterServiceExtension.readByemployeeId(employeeMaster.getId());
//        List<?> employeeVisaDetailsList = employeeVisaDetailsService.readByemployeeId(employeeMaster.getId());

        ///this code is for read file name and display it
        String userName = readUserName(request);
        //String userName = request.getParameter("userid");
        request.setAttribute("userName", userName);//this attribute is for use name and read form directory structure.s
        String fileLocationURL = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "UserProfile"
                + File.separator + userName + File.separator;
        File pictureFile = new File(fileLocationURL);
        if (pictureFile.exists() && pictureFile.listFiles().length > 0) {
            File[] file = pictureFile.listFiles();
            request.setAttribute("imgFile", "StorageYard" + File.separator + "UserProfile" + File.separator + userName + File.separator + file[0].getName());
        } else {
            request.setAttribute("imgFile", "StorageYard" + File.separator + "UserProfile" + File.separator + "User" + File.separator + "default.png");
        }
        DepartmentMaster departmentMaster = new DepartmentMaster();
        DesignationMaster designationMaster = new DesignationMaster();
        LevelMaster levelMaster = new LevelMaster();
        LocationMaster locationMaster = new LocationMaster();
        ShiftMaster shiftMaster = new ShiftMaster();
        ZydexLocationMaster zydexLocationMaster = new ZydexLocationMaster();
        bind(request, userMaster);
        selectEmployee(request, response);
        departmentList(request);
        designationList(request);
        levelList(request);
        locationList(request);
        shiftRotaionList(request);
        setZydexLocationList(request);
        competencyList(request);
        EmployeeTypeList(request);
        EmployeeSubTypeList(request);
        policyList(request);
        ctcList(request);
        companyList(request);

//        shiftList(request);
        hoursBasisList(request);
        //getLastYearPerformance Ratings Of Employee For ReadOnly.s
        List<?> lastYearPerformanceRatingsOfEmployeeList = employeeMasterService.getLastYearPerformanceRatingOfEmployee(id);

        lastYearPerformanceRatingsOfEmployee = (lastYearPerformanceRatingsOfEmployeeList.isEmpty()) ? lastYearPerformanceRatingsOfEmployee : String.valueOf(lastYearPerformanceRatingsOfEmployeeList.get(0));
        //set user master id//
        String userid = request.getParameter("userid");
        userMaster.setId(Integer.parseInt(userid));
        employeeMaster.setUserMaster(userMaster);
        //set Employee master id//
        selectedEmployeeLevel1(request, employeeMaster);
        List<String> certificatesList = new ArrayList();
        UserMaster userMaster1 = new UserMaster();
        userMaster1 = userMasterService.readById(Integer.parseInt(userid));
        String certificateFileLocationURL = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "UserCertificate"
                + File.separator + userMaster1.getUserName() + File.separator;
        File certificateListFile = new File(certificateFileLocationURL);
        if (certificateListFile.listFiles() != null) {

            for (File sss : certificateListFile.listFiles()) {
                String aa = sss.getName();
                certificatesList.add(aa);

            }
            if (certificateListFile.exists() && certificateListFile.listFiles().length > 0) {
                File[] certificateListFileArray = certificateListFile.listFiles();
                try {
                    request.setAttribute("imageFile", "StorageYard" + File.separator + "UserCertificate" + File.separator + userName + File.separator + certificateListFileArray[0].getName().replaceAll(" ", ""));
                } catch (Exception e) {
                }
            }
        }
        //Code to fetch policy details IN VIEW CLICK
        List finalPolicyList = new ArrayList();
        PolicyMaster policyMaster = new PolicyMaster();
        List<?> policyData = (List<?>) employeePolicyDetailService.fetchPolicyData(employeeMaster.getId());
        for (Object policyDataObject : policyData) {
            List policyList = new ArrayList();
            Object[] policyDetail = (Object[]) policyDataObject;
            policyList.add(policyDetail[0]);
            policyList.add(policyDetail[1]);
            policyList.add(policyDetail[2]);
            policyList.add(policyDetail[3]);
            policyList.add(policyDetail[4]);
            policyList.add(policyDetail[5]);
            finalPolicyList.add(policyList);
        }
        List finalctcList = new ArrayList();
        CtcAllowance ctcAllowance = new CtcAllowance();
        List<?> ctcData = (List<?>) employeeCtcDetailService.fetchctcData(employeeMaster.getId());
        for (Object ctcDataObject : ctcData) {
            List ctcList = new ArrayList();
            Object[] policyDetail1 = (Object[]) ctcDataObject;
            ctcList.add(policyDetail1[0]);
            ctcList.add(policyDetail1[1]);
            ctcList.add(policyDetail1[2]);
            ctcList.add(policyDetail1[3]);
            ctcList.add(policyDetail1[4]);
            ctcList.add(policyDetail1[5]);
            ctcList.add(policyDetail1[6]);

//            ctcList.add(policyDetail1[3]);
            finalctcList.add(ctcList);
        }
        int empId = employeeMaster.getEmployeeTypeMaster().getId();
        if (employeeMaster.getEmployeeSubType() != null) {
            int empSubId = employeeMaster.getEmployeeSubType().getId();
            Boolean checkPf = payrollPfCheckService.getPFCheckValue(empId, empSubId);
            Boolean checkPt = payrollPtCheckService.getPTCheckValue(empId, empSubId);

//        selectedEmployeeLevel2(request, employeeMaster);
//        selectedEmployeeLevel3(request, employeeMaster);
//        selectedEmployeeLevel4(request, employeeMaster);
//        selectedEmployeeLevel5(request, employeeMaster);
//        selectedEmployeeLevel6(request, employeeMaster);
            request.setAttribute("checkPf", checkPf);
            request.setAttribute("checkPt", checkPt);
        }
        request.setAttribute("lastYearPerformanceRatingsOfEmployee", lastYearPerformanceRatingsOfEmployee);
//        request.setAttribute("company", employeeMaster.getCompany());

//        request.setAttribute("employeeVisaDetailsList", employeeVisaDetailsList);
        request.setAttribute("employeeType", employeeMaster.getEmployeeType());
        request.setAttribute("shiftType", employeeMaster.getShiftType());
        request.setAttribute("certificatesList", certificatesList);
        request.setAttribute("finalPolicyList", finalPolicyList);
        request.setAttribute("finalctcList", finalctcList);
        //Employee Master Extension
        request.setAttribute("employeeMasterExtensionList", employeeMasterExtensionList);

        mv.getModelMap().put("employeeMaster", employeeMaster);
        request.setAttribute("mriStatus", employeeMaster.getMaritalStatus());
        mv.setViewName("Employee/EditUserProfile");
        return mv;

    }

    public ModelAndView editSubmit(HttpServletRequest request, HttpServletResponse response, EmployeeMaster employeeMaster) throws Exception {
        ModelAndView mv = new ModelAndView();
        String lastYearPerformanceRatingsOfEmployee = "";
        EmployeeSubType employeeSubType = new EmployeeSubType();
        EmployeeMaster employeeMasterForReportingManagerUpdateWherRequired = new EmployeeMaster();
        employeeMasterForReportingManagerUpdateWherRequired = employeeMasterService.readById(employeeMaster.getId());
        String reportingManagerBeforeUpdate = "" + employeeMasterForReportingManagerUpdateWherRequired.getReportingManagerLevel1();
        String reportingManagerForChange = employeeMaster.getReportingManagerLevel1();
        UserMaster userMaster = new UserMaster();
        UserMaster userMaster1 = new UserMaster();
        EmployeeMasterExtension employeeMasterExtension = new EmployeeMasterExtension();
        StringBuffer employeeMasterErrorStrBuf = new StringBuffer();
        
        //Boolean userExistFlag = false;
        //*************employee extension**************//
        String userName = employeeMaster.getEmployeeId();
        
        String presentAddress2 = request.getParameter("presentAddress2");
        String presentCity = request.getParameter("presentCity");
        String presentState = request.getParameter("presentState");
        String presentPostalCode = request.getParameter("presentPostalCode");
        String presentCountry = request.getParameter("presentCountry");
        String permanentAddress2 = request.getParameter("permanentAddress2");
        String permanentCity = request.getParameter("permanentCity");
        String permanentState = request.getParameter("permanentState");
        String permanentPostalCode = request.getParameter("permanentPostalCode");
        String permanentCountry = request.getParameter("permanentCountry");
//         String religion=request.getParameter("religion");
        String disclosedHealthConcerns = request.getParameter("disclosedHealthConcerns");
        String languagesKnown = request.getParameter("languagesKnown");
        String hobbies = request.getParameter("hobbies");
        String childOneGender = request.getParameter("childOneGender");
        String childTwoGender = request.getParameter("childTwoGender");
        String flyDocsEmailId = request.getParameter("flyDocsEmailId");
        String emergencyContactAddress = request.getParameter("emergencyContactAddress");
        String RelationShip = request.getParameter("RelationShip");
        String otherImpInfo = request.getParameter("otherImpInfo");
        String nationality = request.getParameter("nationality");
        String firstName = request.getParameter("firstName");
        String middleName = request.getParameter("middleName");
        String lastName = request.getParameter("lastName");
//         String countryOfIssue=request.getParameter("countryOfIssue");

//         String drivingLicenceType=request.g/etParameter("drivingLicenceType");
//         String electionCard=request.getParameter("electionCard");
        String pfNoFlydocs = request.getParameter("pfNoFlydocs");
        String withdrawalDate = request.getParameter("withdrawalDate");
        String nameOfPreviousCompany = request.getParameter("nameOfPreviousCompany");
        String previousCompanyLocation = request.getParameter("previousCompanyLocation");

//         String namestatus=request.getParameter("nameStatus");  
        String spousegender = request.getParameter("spouseGender");
//         String documentIdNo = request.getParameter("documentIdNo");
        String subteamTransferDate = request.getParameter("subteamTransferDate");
//         String officialContactNumber = request.getParameter("officialContactNumber");
        String designationMasterByLevelId = request.getParameter("designationMasterByLevelId");
        
        // ----------------------------------------------------
        employeeMasterExtension.setNationality(nationality);
        employeeMasterExtension.setFirstName(firstName);
        employeeMasterExtension.setMiddleName(middleName);
        employeeMasterExtension.setLastName(lastName);
        employeeMasterExtension.setPresentAddress2(presentAddress2);
        employeeMasterExtension.setPermanentAddress2(permanentAddress2);
        BindException errors2 = new BindException(employeeMasterExtension, "employeeMasterExtension");
        //----------------------------------------------------
        
        bind(request, employeeMaster);
        selectEmployee(request, response);
        departmentList(request);
        designationList(request);
        levelList(request);
        locationList(request);
        shiftRotaionList(request);
        setZydexLocationList(request);
//        shiftList(request);
        hoursBasisList(request);
        //user levels //

        selectedEmployeeLevel1(request, employeeMaster);
        
         //---------------------------
        List<EmployeeMasterExtension> employeeMasterExtensionList = new ArrayList();
        employeeMasterExtensionList.add(employeeMasterExtension);
        //;//employeeMasterServiceExtension.readByemployeeId(employeeMaster.getId());

        competencyList(request);
        EmployeeTypeList(request);
        EmployeeSubTypeList(request);

        ctcList(request);
        companyList(request);

        //salarySlabList(request);
        //gradeList(request);
        //classList(request);
        //divisionList(request);
        //subjectList(request);
        policyList(request);

        //-----------------------------------
        
//        selectedEmployeeLevel2(request, employeeMaster);
//        selectedEmployeeLevel3(request, employeeMaster);
//        selectedEmployeeLevel4(request, employeeMaster);
//        selectedEmployeeLevel5(request, employeeMaster);
//        selectedEmployeeLevel6(request, employeeMaster);
        BindException errors = new BindException(employeeMaster, "employeeMaster");
        employeeMaster.setJobDescription(employeeMaster.getJobDescription().replaceAll("&Acirc;", ""));

        //getLastYearPerformance Ratings Of Employee For ReadOnly.s
        List<?> lastYearPerformanceRatingsOfEmployeeList = employeeMasterService.getLastYearPerformanceRatingOfEmployee(employeeMaster.getId());

        lastYearPerformanceRatingsOfEmployee = (lastYearPerformanceRatingsOfEmployeeList.isEmpty()) ? lastYearPerformanceRatingsOfEmployee : String.valueOf(lastYearPerformanceRatingsOfEmployeeList.get(0));
        request.setAttribute("lastYearPerformanceRatingsOfEmployee", lastYearPerformanceRatingsOfEmployee);
//        String companyId = request.getParameter("company");
        String companyId = "4";
        String employeeType = request.getParameter("employeeType");
        employeeMaster.setCompany(companyId);
        employeeMaster.setEmployeeType(employeeType);
        String userId = "" + request.getParameter("userMaster.id");
        String id = request.getParameter("id");
        int firstStepCount = Integer.parseInt(request.getParameter("firstStepCount"));
//        String zid = request.getParameter("zydexLocationMaster.id");
        String zid = "10";
        String employeeSubTypeId = request.getParameter("subTypeId");
        if (null != zid && !zid.equals("")) {
            ZydexLocationMaster zydexLocationMaster = new ZydexLocationMaster();
            zydexLocationMaster.setId(Integer.parseInt(zid));
            employeeMaster.setZydexLocationMaster(zydexLocationMaster);
        }
        if (null != employeeSubTypeId && !employeeSubTypeId.equals("")) {
            employeeSubType.setId(Integer.parseInt(employeeSubTypeId));
        }
        employeeMaster.setEmployeeSubType(employeeSubType);
        //--------- Added on 14/11/2019------------- 
        //String shiftType = request.getParameter("shiftType");
        //employeeMaster.setShiftType(shiftType);
        //------------------------------------------
//        employeeMaster.setEmployeeId(id);
//        String reportingManagerLevel1 = request.getParameter("reportingManagerLevel1");
//        String reportingManagerLevel2 = request.getParameter("reportingManagerLevel2");
//        String reportingManagerLevel3 = request.getParameter("reportingManagerLevel3");
//        String reportingManagerLevel4 = request.getParameter("reportingManagerLevel4");
//        String reportingManagerLevel5 = request.getParameter("reportingManagerLevel5");
//        String reportingManagerLevel6 = request.getParameter("reportingManagerLevel6");
        String shiftMasterId = request.getParameter("shiftMasterId");
        
        EmployeeMasterExtensionValidator employeeExtensionValidator = new EmployeeMasterExtensionValidator();
        
        //EmployeeMaster employeeMasterTemp = new EmployeeMaster();
        //employeeMasterTemp = employeeMasterService.readById(id);
        //------------------------
        //EmployeeMaster employeeMasterTemp = new EmployeeMaster();
        //employeeMasterTemp = employeeMasterService.readById(employeeMaster.getId());
        
        //-------------------------
        
        employeeMasterValidator.validate(employeeMaster, errors);
        employeeExtensionValidator.validate(employeeMasterExtension, errors2);
        // || userMasterService.isExist(userName)
        //UserMaster userMaster3 = new UserMaster();
        boolean isOtherUserExist = userMasterService.isOtherUserExist(employeeMaster.getUserMaster().getId(), userName);
        //userMaster3 = userMasterService.readById(employeeMaster.getUserMaster().getId());
        //userMaster3.setUserName(userName);
        //List<?> userMatserList = userMasterService.readByUserName(userMaster3);
       
        if (errors.hasErrors() || errors2.hasErrors() || isOtherUserExist) {
       
//            request.setAttribute("failureMessage",
//                    "Error : The Entered Information is not valid.");
//            mv.addAllObjects(errors.getModel());
//        } else {
        //            if ("HourlyBase".equals(employeeMaster.getShiftType())) {
        //                String hoursId = request.getParameter("shiftHoursId");
        //                employeeMaster.setShiftHoursId(Integer.parseInt(hoursId));
        //            }
        //            if ("ShiftBase".equals(employeeMaster.getShiftType())) {
        //                String shfitId = request.getParameter("shiftId");
        //                employeeMaster.setShiftHoursId(Integer.parseInt(shfitId));
        //            }
        //            employeeMaster.setReportingManagerLevel1(reportingManagerLevel1);
        //            employeeMaster.setReportingManagerLevel2(reportingManagerLevel2);
        //            employeeMaster.setReportingManagerLevel3(reportingManagerLevel3);
        //            employeeMaster.setReportingManagerLevel4(reportingManagerLevel4);
        //            employeeMaster.setReportingManagerLevel5(reportingManagerLevel5);
        //            employeeMaster.setReportingManagerLevel6(reportingManagerLevel6);
//        if (null != employeeMaster.getGender() && !employeeMaster.getGender() && null != employeeMaster.getMaritalStatus() && employeeMaster.getMaritalStatus().equals("Married")) {
//            LeaveTypeMaster leaveTypeMaster = new LeaveTypeMaster();
//            EmployeeLeaveBalance employeeLeaveBalance = new EmployeeLeaveBalance();
//            EmployeeLeaveBalance employeeLeaveBalance1 = new EmployeeLeaveBalance();
//            String ptl = "Paternity Leave";
//            List<?> ptlList = leaveTypeMasterService.readLeaveTypeEditRegistration(ptl);
//            leaveTypeMaster.setId((Integer) ptlList.get(0));
//            employeeLeaveBalance.setLeaveTypeMaster(leaveTypeMaster);
//            employeeLeaveBalance.setEmployeeMaster(employeeMaster);
//            List<?> empLeaveBalList = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance);
//            if (empLeaveBalList.size() > 0) {
//
//            } else {
//                employeeLeaveBalance1.setEmployeeMaster(employeeMaster);
//                employeeLeaveBalance1.setNoOfLeaveRemain(6);
//                employeeLeaveBalance1.setLeaveTypeMaster(leaveTypeMaster);
//                employeeLeaveBalanceService.create(employeeLeaveBalance1);
//            }
            //---------- New Addition of code at 14/11/2019 -----------
           // request.setAttribute("shiftName", shiftMasterId1);
            //request.setAttribute("competencyEvaluationId", competencyEvaluationId);
            /*if ("HourlyBase".equals(employeeMaster.getShiftType())) {
                String hoursId = request.getParameter("shiftHoursId");
                employeeMaster.setShiftHoursId(Integer.parseInt(hoursId));
            }
            if ("ShiftBase".equals(employeeMaster.getShiftType())) {
                String shfitId = request.getParameter("shiftId");
                employeeMaster.setShiftHoursId(Integer.parseInt(shfitId));
            }*/
            
            //--------------- Added on 18-11-2019 -------------------
            //--------- Get Policy detail data and display in jsp
             //Code to fetch policy details IN VIEW CLICK
            List finalPolicyList = new ArrayList();
  
            //Code for Employee Policy Detail
            //EmployeePolicyDetail employeePolicyDetail = new EmployeePolicyDetail();
            int otherDetailCount = Integer.parseInt(request.getParameter("policyCount"));
            for (int i = 1; i <= otherDetailCount; i++) {
                PolicyMaster policyMaster2 = new PolicyMaster();
                if (null != request.getParameter("policyId" + i) && null != request.getParameter("amount" + i)) {
                    if (!request.getParameter("policyId" + i).equals("") && !request.getParameter("amount" + i).equals("")) {
                        int policyId = Integer.parseInt(request.getParameter("policyId" + i));
                        policyMaster2 = policyMasterService.readById(policyId);
                        
                        List policyList = new ArrayList();
                        Double amount = Double.valueOf(request.getParameter("amount" + i));
                        
                        policyList.add(policyId);
                        policyList.add(policyMaster2.getPolicyName());
                        policyList.add(null);
                        policyList.add(amount);
                        if (null != request.getParameter("taxable" + i)) {
                            policyList.add(1);
                        } else {
                            policyList.add(0);
                        }
                        policyList.add(0);
                        finalPolicyList.add(policyList);
                   }
                }
            }
        
            request.setAttribute("finalPolicyList",finalPolicyList);  
            //------------------- End of Section policy ID --------------------
            //------------------ Start of total ctc section -------------------
            List finalctcList = new ArrayList();
            
             //Code for Employee ctc Detail
            EmployeeCtcDetail employeeCtcDetail = new EmployeeCtcDetail();
            int otherDetailCount1 = Integer.parseInt(request.getParameter("ctcCount"));
            for (int i = 1; i <= otherDetailCount1; i++) {
                CtcAllowance ctcAllowance2 = new CtcAllowance();
                if (null != request.getParameter("ctcId" + i) && null != request.getParameter("ctcamount" + i)) {
                    if (!request.getParameter("ctcId" + i).equals("") && !request.getParameter("ctcamount" + i).equals("")) {
                        int ctcId = Integer.parseInt(request.getParameter("ctcId" + i));
                        Double amount = Double.valueOf(request.getParameter("ctcamount" + i));
                        String month = request.getParameter("month" + i);
                        String year = request.getParameter("year" + i);
//                        String policyNumber = request.getParameter("policyNumber" + i);
                        
                        /*employeeCtcDetail.setEmployeeMaster(employeeMaster);
                        employeeCtcDetail.setAmount(amount);
                        employeeCtcDetail.setCtcAllowance(ctcAllowance);
                        if (null != request.getParameter("taxable" + i)) {
                            employeeCtcDetail.setStatus(1);
                        } else {
                            employeeCtcDetail.setStatus(0);
                        }
                        employeeCtcDetail.setMonth(month);
                        employeeCtcDetail.setYear(year);*/
                        
                        List ctcList = new ArrayList();
                        ctcList.add(ctcId);
                        ctcAllowance2 = ctcAllowanceService.readById(ctcId);
                        
                        ctcList.add(ctcAllowance2.getCtcName());
                        ctcList.add(amount);
                        if (null != request.getParameter("taxablectc" + i)) {
                            ctcList.add(1);
                        } else {
                            ctcList.add(0);
                        }
                        ctcList.add(month);
                        ctcList.add(year);
                        
                        ctcList.add(0);
                        finalctcList.add(ctcList);
                    }
                }
            }
            request.setAttribute("finalctcList",finalctcList);  
            //----------------- End of total ctc function ---------------------
            //----------------- Add all the field to set attributes --------------
            String shiftId = request.getParameter("shiftId");
            String shiftMasterId1 = request.getParameter("shiftMasterId");
            String HoursTitle = request.getParameter("shiftHoursId");
            
//--------------------
            request.setAttribute("presentAddress2",presentAddress2);  
            request.setAttribute("presentCity",presentCity); 
            request.setAttribute("presentState",presentCity); 
            request.setAttribute("presentPostalCode",presentCity); 
            request.setAttribute("presentCountry",presentCity); 
            request.setAttribute("permanentAddress2",permanentAddress2);
            request.setAttribute("permanentCity",presentCity); 
            request.setAttribute("permanentState",presentCity); 
            request.setAttribute("permanentPostalCode",presentCity); 
            request.setAttribute("permanentCountry",permanentCountry);
            request.setAttribute("disclosedHealthConcerns",disclosedHealthConcerns);
            request.setAttribute("languagesKnown",languagesKnown);
            request.setAttribute("hobbies",hobbies);
            request.setAttribute("flyDocsEmailId",flyDocsEmailId);  
            request.setAttribute("emergencyContactAddress",emergencyContactAddress);        
            request.setAttribute("RelationShip",RelationShip);      
            request.setAttribute("otherImpInfo",otherImpInfo);      
            request.setAttribute("previousCompanyLocation",previousCompanyLocation);        
            request.setAttribute("SpouseGender",spousegender);      
            request.setAttribute("subteamTransferDate",subteamTransferDate);        
            request.setAttribute("nationality",nationality);
            request.setAttribute("firstName",firstName);
            request.setAttribute("middleName",middleName);
            request.setAttribute("lastName",lastName);
            request.setAttribute("pfNoFlydocs",pfNoFlydocs);
            request.setAttribute("withdrawalDate",withdrawalDate);
            request.setAttribute("nameOfPreviousCompany",nameOfPreviousCompany);
            
            request.setAttribute("failureMessageExtension", employeeMasterErrorStrBuf);
            request.setAttribute("shiftName", shiftMasterId1);
            request.setAttribute("designationMasterByLevelId",designationMasterByLevelId);
            //---- Certificate atteche ---------------
            List<String> certificatesList = new ArrayList();
            UserMaster userMaster2 = new UserMaster();
            userMaster2 = userMasterService.readById(employeeMaster.getUserMaster().getId());
            String certificateFileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "UserCertificate"
                    + File.separator + userMaster2.getUserName() + File.separator;
            File certificateListFile = new File(certificateFileLocationURL);
            if (certificateListFile.listFiles() != null) {

                for (File sss : certificateListFile.listFiles()) {
                    String aa = sss.getName();
                    certificatesList.add(aa);

                }
                if (certificateListFile.exists() && certificateListFile.listFiles().length > 0) {
                    File[] certificateListFileArray = certificateListFile.listFiles();
                    try {
                        request.setAttribute("imageFile", "StorageYard" + File.separator + "UserCertificate" + File.separator + userName + File.separator + certificateListFileArray[0].getName().replaceAll(" ", ""));
                    } catch (Exception e) {
                    }
                }
            }
            request.setAttribute("certificatesList", certificatesList);
            //--------------------------------------------------------------------
            //String userName = String.valueOf(employeeMaster.getUserMaster().getId()); 
            String fileLocationURL = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "UserProfile"
                + File.separator + userMaster2.getUserName() + File.separator;
             
                File photoFile = new File(fileLocationURL);
                //only single file always in it and all others will be deleted
                if (photoFile.exists() && photoFile.listFiles().length > 0) {
                    File[] allPhotoes = photoFile.listFiles();
                    if (allPhotoes.length == 1) {
                       // allPhotoes[0].delete();
                    }
                }
                //if no any directory with url available so new directory is created \\
                //But it will not happen because directory is created when user created First time time.
                if (!photoFile.exists()) {
                    photoFile.mkdir();
                }
                //MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
//                MultipartFile multipartFile = multipartHttpServletRequest.getFile("photographUpdate");
//
//                //HttpSession session = request.getSession();
//                File updatedPicture = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", ""));
//                multipartFile.transferTo(updatedPicture);

                if (photoFile.exists() && photoFile.listFiles().length > 0) {
                    File[] updatedPictureFiles = photoFile.listFiles();
                
                    request.setAttribute("imgFile", "StorageYard" + File.separator + "UserProfile" + File.separator + userName + File.separator + updatedPictureFiles[0].getName());
                }
            //-------------------------------
            for (ObjectError individualError : errors2.getAllErrors()) {  
                String errorMsg = individualError.getCode();
                //request.setAttribute("failureMessage", " <br/> Employee No:"+ employeeNo + " Error Description : " + errorMsg );
                employeeMasterErrorStrBuf.append("<br/> - " + errorMsg);
                
                request.setAttribute(errorMsg.substring(0, 4), " - " + errorMsg);
            }
            //--------------------------------------------------------
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            if(isOtherUserExist)
            {
                request.setAttribute("failureMessage",
                    "Error : User is Exist!");    
            }
//            if(userMasterService.isExist(userName))
//            {
//                request.setAttribute("failureMessage",
//                    "Error : User is Exist!");
//            }
            request.setAttribute("employeeMasterExtensionList", employeeMasterExtensionList);

            mv.addAllObjects(errors.getModel());
            selectEmployee(request, response);
            selectedEmployeeLevel1(request, employeeMaster);
//            request.setAttribute("employeeMaster", employeeMaster);
            mv.getModelMap().put("employeeMaster", employeeMaster);
            mv.setViewName("Employee/EditUserProfile");
            //---------------------------------------------------------
        }
        else
        {

        employeeMaster.setPanCard(String.valueOf(employeeMaster.getPanCard()).toUpperCase());//this is for store pan card in uppercase in database.
        userMaster1 = userMasterService.readById(employeeMaster.getUserMaster().getId());
        userMaster1.setUserName(employeeMaster.getEmployeeId());
        userMasterService.update(userMaster1);
//        String competencyEvaluationId = request.getParameter("competencyEvaluationId");
//        if (!competencyEvaluationId.equals("")) {
//            employeeMaster.setCompetencyEvaluationId(Integer.parseInt(competencyEvaluationId));
//        }

        employeeMasterService.update(employeeMaster);
        EmployeeMasterExtension employeeMasterExtension1 = new EmployeeMasterExtension();
        List<?> employeeMasterExtensionlis = employeeMasterServiceExtension.readByemployeeId(employeeMaster.getId());
        employeeMasterExtension1 = (EmployeeMasterExtension) employeeMasterExtensionlis.get(0);;

//***********employeeextension create*****************//
        //EmployeeMasterExtension employeeMasterExtension = new EmployeeMasterExtension();
        employeeMasterExtension.setId(employeeMasterExtension1.getId());
        employeeMasterExtension.setChildOneGender(Boolean.valueOf(childOneGender));
        employeeMasterExtension.setChildTwoGender(Boolean.valueOf(childTwoGender));
//        employeeMasterExtension.setNameStatus(Boolean.valueOf(namestatus));
        employeeMasterExtension.setSpouseGender(Boolean.valueOf(spousegender));
        employeeMasterExtension.setPresentAddress2(presentAddress2);
        employeeMasterExtension.setPresentCity(presentCity);
        employeeMasterExtension.setPresentState(presentState);
        employeeMasterExtension.setPresentPostalCode(presentPostalCode);
        employeeMasterExtension.setPresentCountry(presentCountry);
        employeeMasterExtension.setPermanentAddress2(permanentAddress2);
        employeeMasterExtension.setPermanentCity(permanentCity);
        employeeMasterExtension.setPermanentCountry(permanentCountry);
        employeeMasterExtension.setPermanentPostalCode(permanentPostalCode);
        employeeMasterExtension.setPermanentState(permanentState);
//        employeeMasterExtension.setReligion(religion);
        employeeMasterExtension.setDisclosedHealthConcerns(disclosedHealthConcerns);
        employeeMasterExtension.setLanguagesKnown(languagesKnown);
        employeeMasterExtension.setHobbies(hobbies);
        employeeMasterExtension.setFlyDocsEmailId(flyDocsEmailId);
        employeeMasterExtension.setEmergencyContactAddress(emergencyContactAddress);
        employeeMasterExtension.setOtherImpInfo(otherImpInfo);
        employeeMasterExtension.setRelationShip(RelationShip);
        employeeMasterExtension.setNationality(nationality);
        employeeMasterExtension.setFirstName(firstName);
        employeeMasterExtension.setMiddleName(middleName);
        employeeMasterExtension.setLastName(lastName);
//        employeeMasterExtension.setCountryOfIssue(countryOfIssue);
//                employeeMasterExtension.setVisaIssueCountry(visaIssueCountry);
//                employeeMasterExtension.setVisaIssueDate(visaIssueDate);
//                employeeMasterExtension.setVisaValidTillDate(visaValidTillDate);
//                employeeMasterExtension.setDrivingLicenceType(drivingLicenceType);
//                employeeMasterExtension.setElectionCard(electionCard);
        employeeMasterExtension.setPfNoFlydocs(pfNoFlydocs);
        employeeMasterExtension.setWithdrawalDate(withdrawalDate);
        employeeMasterExtension.setNameOfPreviousCompany(nameOfPreviousCompany);
        employeeMasterExtension.setPreviousCompanyLocation(previousCompanyLocation);
//                employeeMasterExtension.setDocumentIdNo(documentIdNo);
//                employeeMasterExtension.setOfficialContactNumber(officialContactNumber);
        employeeMasterExtension.setSubteamTransferDate(subteamTransferDate);
        employeeMasterExtension.setEmployeeMaster(employeeMaster);
        employeeMasterServiceExtension.update(employeeMasterExtension);

        //*******employee visa details ********// 
//                EmployeeVisaDetails employeeVisaDetails = new EmployeeVisaDetails();
//                boolean employeeexist = employeeVisaDetailsService.employeeVisadetailsexist(employeeMaster.getId());
//                if(employeeexist){
//                    employeeVisaDetailsService.deleteByemployeeId(employeeMaster.getId());
//                    int visaCount1 = Integer.parseInt(request.getParameter("visaCount1"));
//                    for(int i = 1;i<=visaCount1;i++){
//                        String visaIssueCountry=request.getParameter("visaIssueCountry"+i);
//                        String visaIssueDate=request.getParameter("visaIssueDate"+i);
//                        String visaValidTillDate=request.getParameter("visaValidTillDate"+i);
//                        employeeVisaDetails.setVisaIssueCountry(visaIssueCountry);
//                        employeeVisaDetails.setVisaIssueDate(visaIssueDate);
//                        employeeVisaDetails.setVisaValidTillDate(visaValidTillDate);
//                        employeeVisaDetails.setEmployeeMaster(employeeMaster);
//                        employeeVisaDetailsService.create(employeeVisaDetails);
//                    }
//                }else{
//                        String visaIssueCountry="";
//                        String visaIssueDate="";
//                        String visaValidTillDate="";
//                        employeeVisaDetails.setVisaIssueCountry(visaIssueCountry);
//                        employeeVisaDetails.setVisaIssueDate(visaIssueDate);
//                        employeeVisaDetails.setVisaValidTillDate(visaValidTillDate);
//                        employeeVisaDetails.setEmployeeMaster(employeeMaster);
//                        employeeVisaDetailsService.create(employeeVisaDetails);
//                }
//        if (!reportingManagerBeforeUpdate.equals(reportingManagerForChange)) {
        //code will execute only if reporting manager changed then it will reflect in all sub-ordinate.
        List employeeContainsOldReportingManagerList = employeeMasterService.readByReportingManager("" + employeeMaster.getId());
        for (Object object : employeeContainsOldReportingManagerList) {
            EmployeeMaster employeeContainsOldReportingManager = (EmployeeMaster) object;
            String oldReportingManagerName = "" + employeeContainsOldReportingManager.getReportingManagerLevel1();
            List<?> reportingHierarchyList = employeeMasterService.readReportingHierarchyList(Integer.parseInt(employeeContainsOldReportingManager.getReportingManagerLevel1()));
            Object[] reportingHierarchyArray;
            if (!reportingHierarchyList.isEmpty()) {
                reportingHierarchyArray = (Object[]) reportingHierarchyList.get(0);
                String reportingHierarchyString = "";
                for (int i = 0; i < reportingHierarchyArray.length; i++) {
                    reportingHierarchyString = reportingHierarchyString + ((reportingHierarchyArray[i] == null) ? "" : reportingHierarchyArray[i]) + "~";
                }
                String[] reportingHierarchyStringSplitArray = reportingHierarchyString.split("~");
                if (reportingHierarchyStringSplitArray.length > 0) {
                    employeeContainsOldReportingManager.setReportingManagerLevel2("");
                    employeeContainsOldReportingManager.setReportingManagerLevel3("");
                    employeeContainsOldReportingManager.setReportingManagerLevel4("");
                    employeeContainsOldReportingManager.setReportingManagerLevel5("");
                    employeeContainsOldReportingManager.setReportingManagerLevel6("");
                    employeeContainsOldReportingManager.setReportingManagerLevel2(reportingHierarchyStringSplitArray[0]);
                    employeeContainsOldReportingManager.setReportingManagerLevel3(reportingHierarchyStringSplitArray[1]);
                    employeeContainsOldReportingManager.setReportingManagerLevel4(reportingHierarchyStringSplitArray[2]);
                    if (("".equals(reportingHierarchyStringSplitArray[4]) || reportingHierarchyStringSplitArray[4] == null) && ("".equals(reportingHierarchyStringSplitArray[5]) || reportingHierarchyStringSplitArray[5] == null)) {
                        if ("".equals(reportingHierarchyStringSplitArray[2]) || reportingHierarchyStringSplitArray[2] == null) {
                            employeeContainsOldReportingManager.setReportingManagerLevel6("" + oldReportingManagerName);
                        } else {
                            employeeContainsOldReportingManager.setReportingManagerLevel5("" + oldReportingManagerName);
                            employeeContainsOldReportingManager.setReportingManagerLevel6(reportingHierarchyStringSplitArray[2]);
                        }
                    } else {
                        if ("".equals(reportingHierarchyStringSplitArray[4]) || reportingHierarchyStringSplitArray[4] == null) {
                            employeeContainsOldReportingManager.setReportingManagerLevel5("" + oldReportingManagerName);
                        } else {
                            employeeContainsOldReportingManager.setReportingManagerLevel5(reportingHierarchyStringSplitArray[4]);
                        }
                        employeeContainsOldReportingManager.setReportingManagerLevel6(reportingHierarchyStringSplitArray[5]);
                    }
                }
            }
            try {
                userMaster1 = userMasterService.readById(employeeMaster.getUserMaster().getId());
                userMaster1.setUserName(employeeMaster.getEmployeeId());
                userMasterService.update(userMaster1);
                employeeMasterService.update(employeeContainsOldReportingManager);
            } catch (Exception e) {
            }
        }
//        }
        request.setAttribute("successMessage",
                "Information : The Information is saved Successfully.");
        selectEmployee(request, response);
//        }
        //String userName = String.valueOf(employeeMaster.getUserMaster().getId());//getEmployeeId();//employeeId and userName are equal.
        request.setAttribute("userName", userName);//this attribute is for use name and read form directory structure.
        String fileLocationURL = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "UserProfile"
                + File.separator + userName + File.separator;
        File pictureFile = new File(fileLocationURL);
        if (pictureFile.exists() && pictureFile.listFiles().length > 0) {
            File[] file = pictureFile.listFiles();
            request.setAttribute("imgFile", "StorageYard" + File.separator + "UserProfile" + File.separator + userName + File.separator + file[0].getName());
        } else {
            request.setAttribute("imgFile", "StorageYard" + File.separator + "UserProfile" + File.separator + "User" + File.separator + "default.png");
        }

        //            Certificate attach code
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        for (int i = 1; i < firstStepCount + 1; i++) {
            MultipartFile multipartFile = multipartRequest.getFile("certificateId" + i);
            if (multipartFile != null && multipartFile.getSize() > 0) {
                String certificateFileLocationURL = getServletContext().getRealPath("/")
                        + File.separator + "StorageYard" + File.separator + "UserCertificate"
                        + File.separator + userName + File.separator;
                File Folder1 = new File(certificateFileLocationURL);
                if (!Folder1.exists()) {
                    Folder1.mkdirs();
                }
                try {
                    File file2 = new File(certificateFileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", "_"));
                    File file = new File(certificateFileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", "_"));
                    multipartFile.transferTo(file2);
                } catch (Exception e) {

                }
            }
        }
//        File certificateListFile = new File(certificateFileLocationURL);
//        if (certificateListFile.exists() && certificateListFile.listFiles().length > 0) {
//            File[] certificateListFileArray = certificateListFile.listFiles();
//            try {
//                request.setAttribute("imageFile", "StorageYard" + File.separator + "UserCertificate" + File.separator + userName + File.separator + certificateListFileArray[0].getName().replaceAll(" ", ""));
//            } catch (Exception e) {
//            }
//        }
//        if (!certificateListFile.exists()) {
//            certificateListFile.mkdir();
//        }
        //Code for Employee Policy Detail
        EmployeePolicyDetail employeePolicyDetail = new EmployeePolicyDetail();
//       Boolean check =  employeePolicyDetailService.deleteByEmployeeId(employeeMaster.getId());
        List<?> policyDetail = employeePolicyDetailService.readPolicyId(employeeMaster.getId());
        for (Object policyObject : policyDetail) {
            employeePolicyDetail = (EmployeePolicyDetail) policyObject;
            employeePolicyDetailService.delete(employeePolicyDetail.getId());
        }

        EmployeePolicyDetail employeePolicyDetailObject = new EmployeePolicyDetail();
//        EmployeePolicyDetail employeePolicyDetail = new EmployeePolicyDetail();
        int otherDetailCount = Integer.parseInt(request.getParameter("policyCount"));
        for (int i = 1; i <= otherDetailCount; i++) {
            PolicyMaster policyMaster = new PolicyMaster();
            if (null != request.getParameter("policyId" + i) && null != request.getParameter("amount" + i)) {
                if (!request.getParameter("policyId" + i).equals("") && !request.getParameter("amount" + i).equals("")) {
                    int policyId = Integer.parseInt(request.getParameter("policyId" + i));
                    policyMaster.setId(policyId);
                    Double amount = Double.valueOf(request.getParameter("amount" + i));
                    String policyNumber = request.getParameter("policyNumber" + i);
                    employeePolicyDetail.setEmployeeMaster(employeeMaster);
                    employeePolicyDetail.setAmount(amount);
                    employeePolicyDetail.setPolicyMaster(policyMaster);
                    employeePolicyDetail.setPolicyNum(policyNumber);
                    if (null != request.getParameter("taxable" + i)) {
                        employeePolicyDetail.setStatus(1);
                    } else {
                        employeePolicyDetail.setStatus(0);
                    }
                    employeePolicyDetailService.create(employeePolicyDetail);
                }
            }
        }

        EmployeeCtcDetail employeeCtcDetail = new EmployeeCtcDetail();
//       Boolean check =  employeePolicyDetailService.deleteByEmployeeId(employeeMaster.getId());
        List<?> ctcDetail = employeeCtcDetailService.readctcRegistration(employeeMaster.getId());
        for (Object policyObject1 : ctcDetail) {
            employeeCtcDetail = (EmployeeCtcDetail) policyObject1;
            employeeCtcDetailService.delete(employeeCtcDetail.getId());
        }
//        EmployeeCtcDetail employeeCtcDetail = new EmployeeCtcDetail();
//                EmployeeCtcDetail employeeCtcDetail = new EmployeeCtcDetail();
        int otherDetailCount1 = Integer.parseInt(request.getParameter("ctcCount"));
        for (int i = 1; i <= otherDetailCount1; i++) {
            CtcAllowance ctcAllowance = new CtcAllowance();
            if (null != request.getParameter("ctcId" + i) && null != request.getParameter("ctcamount" + i)) {
                if (!request.getParameter("ctcId" + i).equals("") && !request.getParameter("ctcamount" + i).equals("")) {
                    int ctcId = Integer.parseInt(request.getParameter("ctcId" + i));
                    ctcAllowance.setId(ctcId);
                    Double amount = Double.valueOf(request.getParameter("ctcamount" + i));
                    String month = request.getParameter("month" + i);
                    String year = request.getParameter("year" + i);
//                        String policyNumber = request.getParameter("policyNumber" + i);
                    employeeCtcDetail.setEmployeeMaster(employeeMaster);
                    employeeCtcDetail.setAmount(amount);
                    employeeCtcDetail.setCtcAllowance(ctcAllowance);
                    if (null != request.getParameter("taxablectc" + i)) {
                        employeeCtcDetail.setStatus(1);
                    } else {
                        employeeCtcDetail.setStatus(0);
                    }
                    employeeCtcDetail.setMonth(month);
                    employeeCtcDetail.setYear(year);
                    employeeCtcDetailService.create(employeeCtcDetail);
                }
            }
        }
        //End
//        String firstStepCount = request.getParameter("firstStepCount");
//        for (int i = 1; i <= Integer.parseInt(firstStepCount); i++) {
//
////                String certificateId = request.getParameter("certificateId" + i);
//            MultipartFile multipartFile1 = multipartRequest.getFile("certificateId" + i);
//            if (multipartFile1 != null && multipartFile1.getSize() > 0) {
//                try {
//                    File file3 = new File(certificateFileLocationURL + multipartFile1.getOriginalFilename().replaceAll(" ", ""));
//                    multipartFile1.transferTo(file3);
//                } catch (Exception e) {
//
//                }
//            }
//
//        }

        userMaster.setId(Integer.parseInt(userId));
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.getModelMap().put("userMaster", userMaster);
        request.setAttribute("shiftMasterId", shiftMasterId);
        request.setAttribute("company", employeeMaster.getCompany());
        request.setAttribute("employeeType", employeeMaster.getEmployeeType());

//        if ("ShiftBase".equals(employeeMaster.getShiftType())) {
//            mv.setViewName("forward:shiftRotationInfo.htm?act=createSubmit");
//        } else {
        mv.getModelMap().put("employeeMaster", employeeMaster);
//                editSubmit(request, response);
//        mv.setViewName("Employee/EditUserProfile");
        String empOwnProfile = request.getParameter("empOwnProfile");
        if (null != empOwnProfile && !"".equals(empOwnProfile)) {
            mv.setViewName("forward:userMaster.htm?act=goToDashboard");
        } else {
            mv = searchSubmit(request, response);
        }
//        }
        // }
        }
//        mv.setViewName("Employee/EditUserProfile");
        return mv;
    }

    public ModelAndView deleteSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String empId[] = request.getParameterValues("checkId");
        for (String z : empId) {
            try {
//                employeeMasterServiceExtension.deleteByemployeeId(Integer.parseInt(z));
//                employeeCtcDetailService.deleteByemployeeId(Integer.parseInt(z));
//                employeePolicyDetailService.deleteByemployeeId(Integer.parseInt(z));
//                      
//                employeeMasterService.delete(Integer.parseInt(z));

//                PmpFormStatusMaster pmpFormStatusMaster = new PmpFormStatusMaster();
//                List<?> list11 = pmpFormStatusMasterService.delete1(z);
//                for (Object pdf1 : list11) {
//                    pmpFormStatusMaster = (PmpFormStatusMaster) pdf1;
////                 Object[] o1=(Object[]) pdf;
//
//                    pmpFormStatusMasterService.delete(pmpFormStatusMaster.getId());
//                }
                //userMasterService.delete (Integer.parseInt(z));
                //userRightMasterService.delete(Integer.parseInt(z));
                request.setAttribute("successMessage",
                        "Info : One or more records are deleted successfully.");
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
        mv = searchSubmit(request, response);

        return mv;
    }

    public ModelAndView userDashboard(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
//        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        DepartmentMaster departmentMaster = new DepartmentMaster();
        DesignationMaster designationMaster = new DesignationMaster();
        LevelMaster levelMaster = new LevelMaster();
        LocationMaster locationMaster = new LocationMaster();

        departmentMaster = departmentMasterService.readById(employeeMaster.getDepartmentMaster().getId());
        designationMaster = designationMasterService.readById(employeeMaster.getDesignationMaster().getId());
        levelMaster = levelMasterService.readById(employeeMaster.getLevelMaster().getId());
        locationMaster = locationMasterService.readById(employeeMaster.getLocationMaster().getId());
        EmployeeMaster employeeMasterReportManager = new EmployeeMaster();
        try {
            employeeMasterReportManager = employeeMasterService.readById(Integer.parseInt(employeeMaster.getReportingManagerLevel1()));
        } catch (Exception e) {

        }
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        employeeMaster1 = employeeMasterService.readById(employeeMaster.getId());
        employeeMaster1.setDepartmentMaster(departmentMaster);
        employeeMaster1.setDesignationMaster(designationMaster);
        employeeMaster1.setLevelMaster(levelMaster);
        employeeMaster1.setLocationMaster(locationMaster);
        try {
            employeeMaster1.setReportingManagerLevel1(employeeMasterReportManager.getEmployeeName());
        } catch (NullPointerException ne) {
        }
        request.setAttribute("employeeMaster", employeeMaster1);
        empChart(request, response);
        empOwnChart(request, response);
        mv.setViewName("forward:appraisalPerformance.htm?act=userDashboard");
        return mv;
    }

    private void weeklyGenerate(RotationMaster rotationMaster, Date rd, ShiftRotationMaster shiftRotationMaster, int days, EmployeeMaster employeeMaster, String shiftMasterId) throws Exception {
        ShiftMaster shiftMaster = new ShiftMaster();
        ShiftGenerateMonthlySchedule shiftGenerateMonthlySchedule = new ShiftGenerateMonthlySchedule();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = Calendar.getInstance();
        Calendar c1 = Calendar.getInstance();
        c.setTime(rd);
        int day = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        List<Integer> rotationArray = new ArrayList<Integer>(day);

        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        LocalDate localDate = rd.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int year = localDate.getYear();
        int month = localDate.getMonthValue();
        int dayofmonth = localDate.getDayOfMonth();
//
        String cdayofmonth = "" + dayofmonth;
        String cmonth = "" + month;
        String cyear = "" + year;
        int currentDay = Integer.parseInt(cdayofmonth);
        for (int i1 = 1; i1 < currentDay; i1++) {
            rotationArray.add(0);
        }
        List sunday = new ArrayList();
        for (int day1 = 1; day1 <= day; day1++) {
            c1.set(year, month - 1, day1);
            int dayOfWeek1 = c1.get(Calendar.DAY_OF_WEEK);
            if (dayOfWeek1 == Calendar.SUNDAY) {
                sunday.add(day1);
            }
        }
        int flag1 = 0;
        int count = dayOfWeek;
        int noOfDay = 0;
        int i = 1;
        for (int j = 1; j <= 5; j++) {
            List<?> rotationList = rotationMasterService.readFromRotation(rotationMaster);
            Iterator it = rotationList.iterator();
            if (i > day) {
                break;
            }
            while (it.hasNext()) {
                rotationMaster = (RotationMaster) it.next();
                if (flag1 != 1) {
                    if (shiftMasterId.equals(rotationMaster.getShiftMaster().getId().toString())) {
                        flag1 = 1;
                    }
                }
                if (flag1 == 1) {
                    for (i = currentDay; i <= day; i++) {

                        shiftMaster = shiftMasterService.readById(rotationMaster.getShiftMaster().getId());
                        try {
                            if (rotationArray.size() != day) {
                                if (!sunday.contains(i)) {
                                    rotationArray.add(shiftMaster.getId());
                                } else {
                                    rotationArray.add(-1);
                                }
                            }
                        } catch (Exception ex) {
                            System.out.println("Array Size Exception" + ex);
                        }
                        if (count == days) {
                            count = 1;
                            i++;
                            currentDay = i;
                            noOfDay = days;
                            break;
                        }
                        noOfDay = count;
                        count++;

                    }
                }

            }

        }
        int totalNoOfDay = days - noOfDay;
        shiftGenerateMonthlySchedule.setNoOfDays(totalNoOfDay);
        shiftGenerateMonthlySchedule.setShiftMonth(cmonth);
        shiftGenerateMonthlySchedule.setShiftYear(cyear);
        shiftGenerateMonthlySchedule.setNextShiftId(shiftMaster.getId());
        shiftGenerateMonthlySchedule.setShiftRotationMaster(shiftRotationMaster);
        shiftGenerateMonthlySchedule.setEmployeeMaster(employeeMaster);

        try {
            shiftGenerateMonthlySchedule.setDay1(rotationArray.get(0));
            shiftGenerateMonthlySchedule.setDay2(rotationArray.get(1));
            shiftGenerateMonthlySchedule.setDay3(rotationArray.get(2));
            shiftGenerateMonthlySchedule.setDay4(rotationArray.get(3));
            shiftGenerateMonthlySchedule.setDay5(rotationArray.get(4));
            shiftGenerateMonthlySchedule.setDay6(rotationArray.get(5));
            shiftGenerateMonthlySchedule.setDay7(rotationArray.get(6));
            shiftGenerateMonthlySchedule.setDay8(rotationArray.get(7));
            shiftGenerateMonthlySchedule.setDay9(rotationArray.get(8));
            shiftGenerateMonthlySchedule.setDay10(rotationArray.get(9));
            shiftGenerateMonthlySchedule.setDay11(rotationArray.get(10));
            shiftGenerateMonthlySchedule.setDay12(rotationArray.get(11));
            shiftGenerateMonthlySchedule.setDay13(rotationArray.get(12));
            shiftGenerateMonthlySchedule.setDay14(rotationArray.get(13));
            shiftGenerateMonthlySchedule.setDay15(rotationArray.get(14));
            shiftGenerateMonthlySchedule.setDay16(rotationArray.get(15));
            shiftGenerateMonthlySchedule.setDay17(rotationArray.get(16));
            shiftGenerateMonthlySchedule.setDay18(rotationArray.get(17));
            shiftGenerateMonthlySchedule.setDay19(rotationArray.get(18));
            shiftGenerateMonthlySchedule.setDay20(rotationArray.get(19));
            shiftGenerateMonthlySchedule.setDay21(rotationArray.get(20));
            shiftGenerateMonthlySchedule.setDay22(rotationArray.get(21));
            shiftGenerateMonthlySchedule.setDay23(rotationArray.get(22));
            shiftGenerateMonthlySchedule.setDay24(rotationArray.get(23));
            shiftGenerateMonthlySchedule.setDay25(rotationArray.get(24));
            shiftGenerateMonthlySchedule.setDay26(rotationArray.get(25));
            shiftGenerateMonthlySchedule.setDay27(rotationArray.get(26));
            shiftGenerateMonthlySchedule.setDay28(rotationArray.get(27));
            if (day == 29) {
                shiftGenerateMonthlySchedule.setDay29(rotationArray.get(28));
            }
            if (day == 30) {
                shiftGenerateMonthlySchedule.setDay29(rotationArray.get(28));
                shiftGenerateMonthlySchedule.setDay30(rotationArray.get(29));
            }
            if (day == 31) {
                shiftGenerateMonthlySchedule.setDay29(rotationArray.get(28));
                shiftGenerateMonthlySchedule.setDay30(rotationArray.get(29));
                shiftGenerateMonthlySchedule.setDay31(rotationArray.get(30));
            }

            shiftGenerateMonthlyScheduleService.create(shiftGenerateMonthlySchedule);

        } catch (Exception e) {
            System.out.println("Exception" + e);
        }

//        System.out.println("lol");
//    }
    }

    public ModelAndView empChart(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMasterId = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");

        EmployeeMaster employeeMaster = (EmployeeMaster) request.getAttribute("employeeMaster");
        EmployeeMaster employeeMasterManager = null;
        EmployeeMaster employeeMasterSubordinate = new EmployeeMaster();
        int subordinateCount = 0;
        int subordinateAddiCount = 0;
        String imageManager = "";
        String imageUser = "";
        List<?> ceoList = employeeMasterService.listOfCEO();
        Map<Integer, List> map = new HashMap();
        try {
            employeeMaster.setReportingManagerLevel1("" + employeeMasterId.getId());
            List subordinateList = employeeMasterService.readByEmployeeLevelId(employeeMaster);
            for (Object o : subordinateList) {
                Object[] o1 = (Object[]) o;
                String employeeId = (String) o1[1];

                o1[5] = getServletContext().getRealPath("/") + File.separator + "StorageYard" + File.separator + "UserProfile" + File.separator + employeeId;
//                o1[5] = "StorageYard" + File.separator + "UserProfile" + File.separator + employeeId;

                if (new File((String) o1[5]).exists()) {
                    for (File imgFilePath : new File((String) o1[5]).listFiles()) {
                        o1[5] = "StorageYard" + File.separator + "UserProfile" + File.separator + employeeId + File.separator + imgFilePath.getName();
                        break;
                    }
                } else {
                    o1[5] = "StorageYard" + File.separator + "UserProfile" + File.separator + "User" + File.separator + "default.png";
                }
            }
            subordinateCount = subordinateList.size();
            if (subordinateCount >= 4) {
                subordinateAddiCount = subordinateCount - 4;
                subordinateCount = 4;
            }
            request.setAttribute("subordinateList", subordinateList);
            request.setAttribute("subordinateCount", subordinateCount);
            request.setAttribute("totalSubordinates", subordinateList.size());
            request.setAttribute("subordinateAddiCount", subordinateAddiCount);
            request.setAttribute("logedInEmpId", employeeMasterId.getId());
            if (null != employeeMasterId.getReportingManagerLevel1() && !employeeMasterId.getReportingManagerLevel1().equals("")) {
                for (Object obj : ceoList) {
                    employeeMasterManager = (EmployeeMaster) obj;
                    List innerList = new ArrayList();
//                employeeMasterManager = employeeMasterService.readById(Integer.parseInt(employeeMasterId.getReportingManagerLevel1()));
                    DepartmentMaster departmentMaster = new DepartmentMaster();
                    DesignationMaster designationMaster = new DesignationMaster();

                    departmentMaster = departmentMasterService.readById(employeeMasterManager.getDepartmentMaster().getId());
                    designationMaster = designationMasterService.readById(employeeMasterManager.getDesignationMaster().getId());

                    employeeMasterManager.setDepartmentMaster(departmentMaster);
                    employeeMasterManager.setDesignationMaster(designationMaster);

                    imageManager = getServletContext().getRealPath("/") + File.separator + "StorageYard" + File.separator + "UserProfile" + File.separator + employeeMasterManager.getEmployeeId();

                    if (new File(imageManager).exists()) {
                        for (File imgFilePath : new File(imageManager).listFiles()) {
                            imageManager = "StorageYard" + File.separator + "UserProfile" + File.separator + employeeMasterManager.getEmployeeId() + File.separator + imgFilePath.getName();
                            break;

                        }
                    } else {
                        imageManager = "StorageYard" + File.separator + "UserProfile" + File.separator + "User" + File.separator + "default.png";
                    }

                    innerList.add(employeeMasterManager.getEmployeeId());
                    innerList.add(employeeMasterManager.getEmployeeName());
                    innerList.add(employeeMasterManager.getDepartmentMaster().getDepartmentName());
                    innerList.add(employeeMasterManager.getDesignationMaster().getDesignationName());
                    innerList.add(imageManager);
                    map.put(employeeMasterManager.getId(), innerList);

                }
            }
            imageUser = getServletContext().getRealPath("/") + File.separator + "StorageYard" + File.separator + "UserProfile" + File.separator + employeeMaster.getEmployeeId();

            if (new File(imageUser).exists()) {
                for (File imgFilePath : new File(imageUser).listFiles()) {
                    imageUser = "StorageYard" + File.separator + "UserProfile" + File.separator + employeeMaster.getEmployeeId() + File.separator + imgFilePath.getName();
                    break;
                }
            } else {
                imageUser = "StorageYard" + File.separator + "UserProfile" + File.separator + "User" + File.separator + "default.png";
            }
        } catch (Exception e) {
        }

        request.setAttribute("ceoMap", map);
        request.setAttribute("imageManager", imageManager);
        request.setAttribute("imageUser", imageUser);
        request.setAttribute("employeeMasterManager", employeeMasterManager);
        return mv;
    }

    public ModelAndView empOwnChart(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMasterId = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");

        EmployeeMaster employeeMaster = (EmployeeMaster) request.getAttribute("employeeMaster");
        EmployeeMaster employeeMasterManager1 = null;
        EmployeeMaster employeeMasterSubordinate = new EmployeeMaster();
        int subordinateCount = 0;
        int subordinateAddiCount = 0;
        String imageManager = "";
        String imageUser = "";
        try {
            employeeMaster.setReportingManagerLevel1("" + employeeMasterId.getId());
            List subordinateList = employeeMasterService.readByEmployeeLevelId(employeeMaster);
            for (Object o : subordinateList) {
                Object[] o1 = (Object[]) o;
                String employeeId = (String) o1[1];

                o1[5] = getServletContext().getRealPath("/") + File.separator + "StorageYard" + File.separator + "UserProfile" + File.separator + employeeId;
//                o1[5] = "StorageYard" + File.separator + "UserProfile" + File.separator + employeeId;

                if (new File((String) o1[5]).exists()) {
                    for (File imgFilePath : new File((String) o1[5]).listFiles()) {
                        o1[5] = "StorageYard" + File.separator + "UserProfile" + File.separator + employeeId + File.separator + imgFilePath.getName();
                        break;
                    }
                } else {
                    o1[5] = "StorageYard" + File.separator + "UserProfile" + File.separator + "User" + File.separator + "default.png";
                }
            }
            subordinateCount = subordinateList.size();
            if (subordinateCount >= 4) {
                subordinateAddiCount = subordinateCount - 4;
                subordinateCount = 4;
            }
            request.setAttribute("subordinateList", subordinateList);
            request.setAttribute("subordinateCount", subordinateCount);
            request.setAttribute("totalSubordinates", subordinateList.size());
            request.setAttribute("subordinateAddiCount", subordinateAddiCount);
            request.setAttribute("logedInEmpId", employeeMasterId.getId());
            if (null != employeeMasterId.getReportingManagerLevel1() && !employeeMasterId.getReportingManagerLevel1().equals("")) {

                employeeMasterManager1 = employeeMasterService.readById(Integer.parseInt(employeeMasterId.getReportingManagerLevel1()));
                DepartmentMaster departmentMaster = new DepartmentMaster();
                DesignationMaster designationMaster = new DesignationMaster();

                departmentMaster = departmentMasterService.readById(employeeMasterManager1.getDepartmentMaster().getId());
                designationMaster = designationMasterService.readById(employeeMasterManager1.getDesignationMaster().getId());

                employeeMasterManager1.setDepartmentMaster(departmentMaster);
                employeeMasterManager1.setDesignationMaster(designationMaster);

                imageManager = getServletContext().getRealPath("/") + File.separator + "StorageYard" + File.separator + "UserProfile" + File.separator + employeeMasterManager1.getEmployeeId();

                if (new File(imageManager).exists()) {
                    for (File imgFilePath : new File(imageManager).listFiles()) {
                        imageManager = "StorageYard" + File.separator + "UserProfile" + File.separator + employeeMasterManager1.getEmployeeId() + File.separator + imgFilePath.getName();
                        break;

                    }
                } else {
                    imageManager = "StorageYard" + File.separator + "UserProfile" + File.separator + "User" + File.separator + "default.png";
                }

            }
            imageUser = getServletContext().getRealPath("/") + File.separator + "StorageYard" + File.separator + "UserProfile" + File.separator + employeeMaster.getEmployeeId();

            if (new File(imageUser).exists()) {
                for (File imgFilePath : new File(imageUser).listFiles()) {
                    imageUser = "StorageYard" + File.separator + "UserProfile" + File.separator + employeeMaster.getEmployeeId() + File.separator + imgFilePath.getName();
                    break;
                }
            } else {
                imageUser = "StorageYard" + File.separator + "UserProfile" + File.separator + "User" + File.separator + "default.png";
            }
        } catch (Exception e) {
        }

        request.setAttribute("imageManager", imageManager);
        request.setAttribute("imageUser", imageUser);
        request.setAttribute("employeeMasterManager1", employeeMasterManager1);
        return mv;
    }

    public ModelAndView hrDashboard(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        Date today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YY");

        List attendanceList = employeeMasterService.readAttendanceData(sdf.format(today));
        Object[] attendanceData;
        StringBuilder sb = new StringBuilder();
        sb.append("");
        if (!attendanceList.isEmpty()) {
            attendanceData = (Object[]) attendanceList.get(0);
            int absence = ((int) (long) attendanceData[2] - (int) (long) attendanceData[0] - (int) (long) attendanceData[1]);
            sb.append("['Presence', ").append(attendanceData[0])
                    .append("],['Absence', ").append(absence)
                    .append("],['Approved Leave', ").append(attendanceData[1]).append("]");
        }
        mv.addObject("dailyAttendanceResult", sb.toString());
        //this code is copied from userDashboard Method of this page,
        // for set employeeMaster with some required data and show employee hierarcy.
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
//        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        DepartmentMaster departmentMaster = new DepartmentMaster();
        DesignationMaster designationMaster = new DesignationMaster();
        LevelMaster levelMaster = new LevelMaster();
        EmployeeMaster employeeMasterReportManager = new EmployeeMaster();
        if (employeeMaster != null) {
            try {
                departmentMaster = departmentMasterService.readById(employeeMaster.getDepartmentMaster().getId());
                designationMaster = designationMasterService.readById(employeeMaster.getDesignationMaster().getId());
                levelMaster = levelMasterService.readById(employeeMaster.getLevelMaster().getId());
                employeeMasterReportManager = employeeMasterService.readById(Integer.parseInt(employeeMaster.getReportingManagerLevel1()));
            } catch (Exception e) {

            }
        }
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        if (employeeMaster != null) {
            employeeMaster1 = employeeMasterService.readById(employeeMaster.getId());
        }
        employeeMaster1.setDepartmentMaster(departmentMaster);
        employeeMaster1.setDesignationMaster(designationMaster);
        employeeMaster1.setLevelMaster(levelMaster);
        if (employeeMasterReportManager != null) {
            employeeMaster1.setReportingManagerLevel1(employeeMasterReportManager.getEmployeeName());
        }
        List l1 = employeeMasterService.getGenderDetails();
        StringBuilder sb11 = new StringBuilder();
        sb11.append("['").append("Male").append("',").append(l1.get(0)).append("],");
        sb11.append("['").append("Female").append("',").append(l1.get(1)).append("]");
        request.setAttribute("employeeMaster", employeeMaster1);
        request.setAttribute("genderWiseEmployee", sb11);
        empChart(request, response);
        mv.setViewName("forward:locationMaster.htm?act=hrDashboard");
        return mv;
    }

    public ModelAndView viewAllSubordinate(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        EmployeeMaster employeeMasterMd = new EmployeeMaster();
        EmployeeMaster employeeMasterSubordinate = new EmployeeMaster();
        try {
            employeeMasterMd.setReportingManagerLevel1("");
            List mdValList = employeeMasterService.readByEmployeeLevelId(employeeMasterMd);
            int id = 0;
            for (Object o : mdValList) {
                Object[] o1 = (Object[]) o;
                id = (int) o1[0];
                String employeeId = (String) o1[1];

                o1[5] = getServletContext().getRealPath("/") + File.separator + "StorageYard" + File.separator + "UserProfile" + File.separator + employeeId;
//                o1[5] = "StorageYard" + File.separator + "UserProfile" + File.separator + employeeId;

                if (new File((String) o1[5]).exists()) {
                    for (File imgFilePath : new File((String) o1[5]).listFiles()) {
                        o1[5] = "StorageYard" + File.separator + "UserProfile" + File.separator + employeeId + File.separator + imgFilePath.getName();
                        break;
                    }
                } else {
                    o1[5] = "StorageYard" + File.separator + "UserProfile" + File.separator + "User" + File.separator + "default.png";
                }
//                break;
            }
            employeeMasterSubordinate.setReportingManagerLevel1("" + id);
            List subordinateValList = employeeMasterService.readByEmployeeLevelId(employeeMasterSubordinate);
//            for (Object o : subordinateValList) {
//                Object[] o1 = (Object[]) o;
//                id = (int) o1[0];
//                String employeeId = (String) o1[1];
//
//                o1[5] = getServletContext().getRealPath("/") + File.separator + "StorageYard" + File.separator + "UserProfile" + File.separator + employeeId;
////                o1[5] = "StorageYard" + File.separator + "UserProfileselectEmployee" + File.separator + employeeId;
//
//                if (new File((String) o1[5]).exists()) {
//                    for (File imgFilePath : new File((String) o1[5]).listFiles()) {
//                        o1[5] = "StorageYard" + File.separator + "UserProfile" + File.separator + employeeId + File.separator + imgFilePath.getName();
//                        break;
//                    }
//                } else {
//                    o1[5] = "StorageYard" + File.separator + "UserProfile" + File.separator + "User" + File.separator + "default.png";
//                }
//            }
//            if (!mdValList.isEmpty() && mdValList.size() != 0) {
//                request.setAttribute("mdValList", mdValList.get(0));
//            }

//            double count = subordinateValList.size();
//            count = count / 10;
//            if ((count - (int) count) != 0) {
//                count++;
//            }
//            List<List<Object>> list = new ArrayList<List<Object>>();
//            for (int i = 1; i <= ((int) count); i++) {
//                List<Object> list1 = new ArrayList<Object>();
//                if (i == 1) {
//                    list1 = new ArrayList<Object>();
//                    int coun = 0;
//                    boolean flag = false;
//                    try {
//                        list1.add("0");
//                        list1.add("10");
//                        list1.add(subordinateValList.subList(0, i * 10));
//                        list1.add("10");
//                    } catch (Exception e) {
//                        flag = true;
//                    }
//                    if (flag) {
//
//                        list1 = new ArrayList<Object>();
//                        coun = subordinateValList.size();
//                        list1.add("0");
////                            if (coun >= 2) {
////                                list1.add(coun - 2);
////                            } else {
//                        list1.add(coun);
////                            }
//
//                        list1.add(subordinateValList.subList(0, coun));
//                        list1.add(coun - 0);
//                    }
//                } else {
//                    list1 = new ArrayList<Object>();
//                    boolean flag = false;
//                    try {
//                        list1.add("" + ((i * 10) - 10));
//                        list1.add(i * 10);
//                        list1.add(subordinateValList.subList((i * 10) - 10, i * 10));
//                        list1.add((i * 10) - ((i * 10) - 10));
//                    } catch (Exception e) {
//                        flag = true;
//                    }
//                    if (flag) {
//                        list1 = new ArrayList<Object>();
//                        int coun = subordinateValList.size() - ((i * 10) - 10);
//                        list1.add("" + ((i * 10) - 10));
//                        list1.add(subordinateValList.size());
//                        list1.add(subordinateValList.subList((i * 10) - 10, subordinateValList.size()));
//                        list1.add(subordinateValList.size() - ((i * 10) - 10));
//                    }
//                }
//                list.add(list1);
//
//            }
//            request.setAttribute("subordinateValList", subordinateValList);
//            request.setAttribute("subordinateValListofList", list);
//            request.setAttribute("mdValList", mdValList.get(0));
            request.setAttribute("mdValList", mdValList);
//            request.setAttribute("subordinateValcount", subordinateValList.size() - 2);

        } catch (Exception e) {
        }

        mv.setViewName("Dashboard/OrganogramForAllSubordinates");
        return mv;
    }

    public ModelAndView viewEmployeeSubordinate(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMasterSubordinate = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        try {
            String idStr = request.getParameter("id");
            if (null != idStr && !idStr.equals("")) {
                employeeMaster.setId(Integer.parseInt(idStr));
                employeeMaster = employeeMasterService.readById(employeeMaster.getId());
                int id = 0;

                DepartmentMaster departmentMaster = new DepartmentMaster();
                DesignationMaster designationMaster = new DesignationMaster();

                DepartmentMaster departmentMaster1 = new DepartmentMaster();
                DesignationMaster designationMaster1 = new DesignationMaster();

                employeeMaster1 = employeeMasterService.readById(Integer.parseInt(idStr));
//                employeeMaster1 = employeeMasterService.readById(Integer.parseInt(employeeMaster.getReportingManagerLevel1()));
                departmentMaster = departmentMasterService.readById(employeeMaster.getDepartmentMaster().getId());
                designationMaster = designationMasterService.readById(employeeMaster.getDesignationMaster().getId());

                departmentMaster1 = departmentMasterService.readById(employeeMaster1.getDepartmentMaster().getId());
                designationMaster1 = designationMasterService.readById(employeeMaster1.getDesignationMaster().getId());

                employeeMaster.setDepartmentMaster(departmentMaster);
                employeeMaster.setDesignationMaster(designationMaster);

                employeeMaster1.setDepartmentMaster(departmentMaster1);
                employeeMaster1.setDesignationMaster(designationMaster1);
                String employeeStr = "";
                employeeStr = getServletContext().getRealPath("/") + File.separator + "StorageYard" + File.separator + "UserProfile" + File.separator + employeeMaster.getEmployeeId();
//                o1[5] = "StorageYard" + File.separator + "UserProfile" + File.separator + employeeId;

                if (new File((String) employeeStr).exists()) {
                    for (File imgFilePath : new File((String) employeeStr).listFiles()) {
                        employeeStr = "StorageYard" + File.separator + "UserProfile" + File.separator + employeeMaster.getEmployeeId() + File.separator + imgFilePath.getName();
                        break;
                    }
                } else {
                    employeeStr = "StorageYard" + File.separator + "UserProfile" + File.separator + "User" + File.separator + "default.png";
                }
                String employeeStr1 = "";
                employeeStr1 = getServletContext().getRealPath("/") + File.separator + "StorageYard" + File.separator + "UserProfile" + File.separator + employeeMaster1.getEmployeeId();
//                o1[5] = "StorageYard" + File.separator + "UserProfile" + File.separator + employeeId;

                if (new File((String) employeeStr1).exists()) {
                    for (File imgFilePath1 : new File((String) employeeStr1).listFiles()) {
                        employeeStr1 = "StorageYard" + File.separator + "UserProfile" + File.separator + employeeMaster1.getEmployeeId() + File.separator + imgFilePath1.getName();
                        break;
                    }
                } else {
                    employeeStr1 = "StorageYard" + File.separator + "UserProfile" + File.separator + "User" + File.separator + "default.png";
                }
                employeeMasterSubordinate.setReportingManagerLevel1("" + employeeMaster.getId());
                List subordinateValList = employeeMasterService.readByEmployeeLevelId(employeeMasterSubordinate);
                for (Object o : subordinateValList) {
                    Object[] o1 = (Object[]) o;
                    id = (int) o1[0];
                    String employeeId = (String) o1[1];

                    o1[5] = getServletContext().getRealPath("/") + File.separator + "StorageYard" + File.separator + "UserProfile" + File.separator + employeeId;
//                o1[5] = "StorageYard" + File.separator + "UserProfile" + File.separator + employeeId;

                    if (new File((String) o1[5]).exists()) {
                        for (File imgFilePath : new File((String) o1[5]).listFiles()) {
                            o1[5] = "StorageYard" + File.separator + "UserProfile" + File.separator + employeeId + File.separator + imgFilePath.getName();
                            break;
                        }
                    } else {
                        o1[5] = "StorageYard" + File.separator + "UserProfile" + File.separator + "User" + File.separator + "default.png";
                    }
                }

                double count = subordinateValList.size();
                count = count / 10;
                if ((count - (int) count) != 0) {
                    count++;
                }
                List<List<Object>> list = new ArrayList<List<Object>>();
                for (int i = 1; i <= ((int) count); i++) {
                    List<Object> list1 = new ArrayList<Object>();
                    if (i == 1) {
                        list1 = new ArrayList<Object>();
                        int coun = 0;
                        boolean flag = false;
                        try {
                            list1 = new ArrayList<Object>();
                            list1.add("0");
                            list1.add("10");
                            list1.add(subordinateValList.subList(0, i * 10));
                            list1.add("10");
                        } catch (Exception e) {
                            flag = true;
                        }
                        if (flag) {
                            list1 = new ArrayList<Object>();
                            coun = subordinateValList.size();
                            list1.add("0");
//                            if (coun >= 2) {
//                                list1.add(coun - 2);
//                            } else {
                            list1.add(coun);
//                            }

                            list1.add(subordinateValList.subList(0, coun));
                            list1.add(coun);
                        }
                    } else {
                        list1 = new ArrayList<Object>();
                        boolean flag = false;
                        try {
                            list1.add("" + ((i * 10) - 10));
                            list1.add((i * 10));
                            list1.add(subordinateValList.subList((i * 10) - 10, i * 10));
                            list1.add((i * 10) - ((i * 10) - 10));
                        } catch (Exception e) {
                            flag = true;
                        }
                        if (flag) {
                            list1 = new ArrayList<Object>();
                            int coun = subordinateValList.size() - ((i * 10) - 10);
                            list1.add("" + ((i * 10) - 10));
                            list1.add(subordinateValList.size());
                            list1.add(subordinateValList.subList((i * 10) - 10, subordinateValList.size()));
                            list1.add(subordinateValList.size() - ((i * 10) - 10));
                        }
                    }
                    list.add(list1);

                }

//            request.setAttribute("subordinateValList", subordinateValList);
                request.setAttribute("subordinateValListofList", list);
                request.setAttribute("employeeImage", employeeStr);
                request.setAttribute("employeeMaster", employeeMaster);
                request.setAttribute("employeeImage1", employeeStr1);
                request.setAttribute("employeeMaster1", employeeMaster1);
                request.setAttribute("reportingManager1", employeeMaster.getReportingManagerLevel1());
            }
            mv.setViewName("Dashboard/OrganogramForSubordinateWise");
        } catch (Exception e) {
            mv = viewAllSubordinate(request, response);
        }

        return mv;
    }

    public String displayPicture(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String imgFile = "";
        String userName = request.getParameter("userName");
//        HttpSession session = request.getSession(false);
        UserMaster userMaster = new UserMaster();
        userMaster = userMasterService.readById(Integer.parseInt(userName));
        String fileLocationURL = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "UserProfile"
                + File.separator + userMaster.getUserName() + File.separator;
        File photoFile = new File(fileLocationURL);
        //only single file always in it and all others will be deleted
        if (photoFile.exists() && photoFile.listFiles().length > 0) {
            File[] allPhotoes = photoFile.listFiles();
            if (allPhotoes.length == 1) {
                allPhotoes[0].delete();
            }
        }
        //if no any directory with url available so new directory is created \\
        //But it will not happen because directory is created when user created First time time.
        if (!photoFile.exists()) {
            photoFile.mkdir();
        }
        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile = multipartHttpServletRequest.getFile("photographUpdate");
        try {
            HttpSession session = request.getSession();
            File updatedPicture = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", ""));
            multipartFile.transferTo(updatedPicture);

            if (photoFile.exists() && photoFile.listFiles().length > 0) {
                File[] updatedPictureFiles = photoFile.listFiles();
                imgFile = "StorageYard" + File.separator + "UserProfile" + File.separator + userMaster.getUserName() + File.separator + updatedPictureFiles[0].getName().replaceAll(" ", "");
                //imgFile = "StorageYard" + File.separator + "UserProfile" + File.separator + userName + File.separator + updatedPictureFiles[0].getName().replaceAll(" ", "");
                        
//------- following 2 line are commented
            //session.setAttribute("profilePicturePath", imgFile);
            request.setAttribute("imgFile", "StorageYard" + File.separator + "UserProfile" + File.separator + userName + File.separator + updatedPictureFiles[0].getName());
            //-----------------------------------------
            }
            PrintWriter out = null;
            try {
                out = response.getWriter();
                out.print(imgFile);
            } finally {
                out.close();
            }
            //HttpSession session = request.getSession();
            EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
            if (employeeMaster.getEmployeeId().equals(userMaster.getUserName())) {
                session.setAttribute("profilePicturePath", imgFile);
            }

        } catch (Exception e) {

        }

        return imgFile;
    }

    
    public String displayPictureCreateForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String imgFile = "";
        String userName = request.getParameter("userName");
//        HttpSession session = request.getSession(false);
        //UserMaster userMaster = new UserMaster();
        //userMaster = userMasterService.readById(Integer.parseInt(userName));
        String fileLocationURL = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "UserProfile"
                + File.separator + userName + File.separator;
        File photoFile = new File(fileLocationURL);
        //only single file always in it and all others will be deleted
        if (photoFile.exists() && photoFile.listFiles().length > 0) {
            File[] allPhotoes = photoFile.listFiles();
            if (allPhotoes.length == 1) {
                allPhotoes[0].delete();
            }
        }
        
        //if no any directory with url available so new directory is created \\
        //But it will not happen because directory is created when user created First time time.
        if (!photoFile.exists()) {
            photoFile.mkdir();
        }
        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile = multipartHttpServletRequest.getFile("photographUpdate");
        try {
            HttpSession session = request.getSession();
            File updatedPicture = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", ""));
            multipartFile.transferTo(updatedPicture);

            if (photoFile.exists() && photoFile.listFiles().length > 0) {
                File[] updatedPictureFiles = photoFile.listFiles();
                imgFile = "StorageYard" + File.separator + "UserProfile" + File.separator + userName + File.separator + updatedPictureFiles[0].getName().replaceAll(" ", "");
                //imgFile = "StorageYard" + File.separator + "UserProfile" + File.separator + userName + File.separator + updatedPictureFiles[0].getName().replaceAll(" ", "");
                        
//------- following 2 line are commented
            //session.setAttribute("profilePicturePath", imgFile);
            request.setAttribute("imgFile", "StorageYard" + File.separator + "UserProfile" + File.separator + userName + File.separator + updatedPictureFiles[0].getName());
            //-----------------------------------------
            }
            PrintWriter out = null;
            try {
                out = response.getWriter();
                out.print(imgFile);
            } finally {
                out.close();
            }
            //HttpSession session = request.getSession();
            EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
            if (employeeMaster.getEmployeeId().equals(userName)) {
                session.setAttribute("profilePicturePath", imgFile);
            }

        } catch (Exception e) {

        }

        return imgFile;
    }
    
    public void readReportingHierarchy(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String reportingManagerId = request.getParameter("id");
        PrintWriter out = null;
        List<?> reportingHierarchyList = employeeMasterService.readReportingHierarchyList(Integer.parseInt(reportingManagerId));
        Object[] reportingHierarchyArray;
        if (!reportingHierarchyList.isEmpty()) {
            reportingHierarchyArray = (Object[]) reportingHierarchyList.get(0);
            String reportingHierarchyString = "";
            for (int i = 0; i < reportingHierarchyArray.length; i++) {
                reportingHierarchyString = reportingHierarchyString + ((reportingHierarchyArray[i] == null) ? "" : reportingHierarchyArray[i]) + "~";
            }

            try {
                out = response.getWriter();
                out.print(reportingHierarchyString.substring(0, reportingHierarchyString.length() - 1));
            } finally {
                out.close();
            }
        } else {
            try {
                out = response.getWriter();
                out.print("");
            } finally {
                out.close();
            }
        }

    }

    public ModelAndView changeEmployeeShift(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        String id = request.getParameter("id");
        if (null == id || id == "") {
            id = "" + employeeMaster.getId();
        }
        try {
            employeeMaster = employeeMasterService.readById(Integer.parseInt(id));
        } catch (Exception e) {
        }
        shiftRotaionList(request);
        hoursBasisList(request);
        shiftList(request);
        request.setAttribute("shiftType", employeeMaster.getShiftType());
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.setViewName("Employee/EmployeeShiftChange");
        return mv;
    }

    public ModelAndView changeEmployeeShiftSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        ShiftRotationInfo shiftRotationInfo = new ShiftRotationInfo();
        ShiftRotationInfo shiftRotationInfo1 = new ShiftRotationInfo();
        ShiftRotationMaster shiftRotationMaster = new ShiftRotationMaster();
        UserMaster userMaster = new UserMaster();
        bind(request, employeeMaster);
        int id = employeeMaster.getId();

        employeeMaster1 = employeeMasterService.readById(id);
        userMaster.setId(employeeMaster1.getUserMaster().getId());
        shiftRotationInfo.setUserMaster(userMaster);
        String firstShiftId = request.getParameter("shiftMasterId");
        employeeMaster1.setShiftRotationDate(employeeMaster.getShiftRotationDate());
        employeeMaster1.setShiftType(employeeMaster.getShiftType());
        if (employeeMaster.getShiftType().equals("HourlyBase")) {
            String hoursId = request.getParameter("shiftHoursId");
            employeeMaster1.setShiftHoursId(Integer.parseInt(hoursId));
            employeeMasterService.update(employeeMaster1);
            request.setAttribute("successMessage", "Information Saved Successfully.");
            mv = searchSubmit(request, response);
        }
        if (employeeMaster.getShiftType().equals("ShiftBase")) {
            String shfitId = request.getParameter("shiftId");
            if (shfitId.equals("") || request.getParameter("shiftRotationDate").equals("") || request.getParameter("shiftMasterId").equals("")) {
                request.setAttribute("failureMessage",
                        "Error : Please Select Rotation name,Shift name and rotation date.");
                mv.getModelMap().put("employeeMaster", employeeMaster);
                mv = changeEmployeeShift(request, response);
            } else {

                employeeMaster1.setShiftHoursId(Integer.parseInt(shfitId));
                shiftRotationMaster.setId(Integer.parseInt(shfitId));
                List<?> list = shiftRotationInfoService.readRotaionDetail(shiftRotationInfo);
                if (!list.isEmpty()) {
                    shiftRotationInfo = (ShiftRotationInfo) list.get(0);
                    shiftRotationInfo1.setId(shiftRotationInfo.getId());
                    shiftRotationInfo1.setUserMaster(userMaster);
                    shiftRotationInfo1.setShiftRotationMaster(shiftRotationMaster);
                    shiftRotationInfo1.setFirstShiftId(Integer.parseInt(firstShiftId));
                    shiftRotationInfo1.setRotationDate(employeeMaster.getShiftRotationDate());
                    shiftRotationInfoService.update(shiftRotationInfo1);
                } else {
                    shiftRotationInfo1.setUserMaster(userMaster);
                    shiftRotationInfo1.setShiftRotationMaster(shiftRotationMaster);
                    shiftRotationInfo1.setFirstShiftId(Integer.parseInt(firstShiftId));
                    shiftRotationInfo1.setRotationDate(employeeMaster.getShiftRotationDate());
                    shiftRotationInfoService.create(shiftRotationInfo1);
                }

                ShiftGenerateMonthlySchedule shiftGenerateMonthlySchedule = new ShiftGenerateMonthlySchedule();
                shiftGenerateMonthlySchedule.setEmployeeMaster(employeeMaster);
                String shiftRotationDate = request.getParameter("shiftRotationDate");
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date rd = sdf.parse(shiftRotationDate);
                LocalDate localDate = rd.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                int year = localDate.getYear();
                String cyear = "" + year;
                int month = localDate.getMonthValue();
                String cmonth = "" + month;
                int dayofmonth = localDate.getDayOfMonth();
                String cdayofmonth = "" + dayofmonth;
                Calendar c = Calendar.getInstance();
                Date newDate = c.getTime();
                int tday = c.get(Calendar.DATE);
                shiftRotationMaster = shiftRotationMasterService.readById(Integer.parseInt(shfitId));
                String duration = shiftRotationMaster.getDuration();
                int day = c.getActualMaximum(Calendar.DAY_OF_MONTH);
                RotationMaster rotationMaster = new RotationMaster();
                rotationMaster.setShiftRotationMaster(shiftRotationMaster);
                if (duration.equals("monthly") && day == 30) {
                    shiftGenerateEdit(rotationMaster, rd, shiftRotationMaster, 30, employeeMaster1, firstShiftId);
                } else if (duration.equals("weekly")) {
                    shiftGenerateEditWeekly(rotationMaster, rd, shiftRotationMaster, 7, employeeMaster1, firstShiftId);
                } else if (duration.equals("fortNightly")) {
                    shiftGenerateEdit(rotationMaster, rd, shiftRotationMaster, 14, employeeMaster1, firstShiftId);
                } else {
                    shiftGenerateEdit(rotationMaster, rd, shiftRotationMaster, day, employeeMaster1, firstShiftId);
                }
                employeeMasterService.update(employeeMaster1);
                request.setAttribute("successMessage", "Information Saved Successfully.");
//                mv = searchSubmit(request, response);
                mv.setViewName("redirect:employeeMaster.htm?act=searchSubmit");
            }
        }

        return mv;

    }

    private void shiftGenerateEdit(RotationMaster rotationMaster, Date rd, ShiftRotationMaster shiftRotationMaster, int days, EmployeeMaster employeeMaster, String firstShiftId) throws Exception {
        ShiftMaster shiftMaster = new ShiftMaster();
        ShiftGenerateMonthlySchedule shiftGenerateMonthlySchedule = new ShiftGenerateMonthlySchedule();
        ShiftGenerateMonthlySchedule shiftGenerateMonthlySchedule1 = new ShiftGenerateMonthlySchedule();
        List<List<Object>> finalList = new ArrayList<List<Object>>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = Calendar.getInstance();
        Calendar c1 = Calendar.getInstance();
        c.setTime(rd);
        int day = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        List<Integer> rotationArray = new ArrayList<Integer>(day);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        LocalDate localDate = rd.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int year = localDate.getYear();
        int month = localDate.getMonthValue();
        int dayofmonth = localDate.getDayOfMonth();
        String cdayofmonth = "" + dayofmonth;
        String cmonth = "" + month;
        String cyear = "" + year;
        shiftGenerateMonthlySchedule.setEmployeeMaster(employeeMaster);
        shiftGenerateMonthlySchedule.setShiftMonth(cmonth);
        shiftGenerateMonthlySchedule.setShiftYear(cyear);

        List<?> list = shiftGenerateMonthlyScheduleService.readByCurrentDateWiseEmployeeShift(shiftGenerateMonthlySchedule);
        if (!list.isEmpty()) {
            shiftGenerateMonthlySchedule = (ShiftGenerateMonthlySchedule) list.get(0);
        }
        int currentDay = Integer.parseInt(cdayofmonth);
        for (int i1 = 1; i1 < currentDay; i1++) {
            rotationArray.add(0);
        }

        int count1 = 0;
        List sunday = new ArrayList();
        for (int day1 = 1; day1 <= day; day1++) {
            c1.set(year, month - 1, day1);
            int dayOfWeek1 = c1.get(Calendar.DAY_OF_WEEK);
            if (dayOfWeek1 == Calendar.SUNDAY) {
                sunday.add(day1);
            }
        }
        int count = 1;
        int noOfDay = 0;
        int i = 1;

        int flag = 0;
        for (int j = 1; j <= 5; j++) {
            List<?> rotationList = rotationMasterService.readFromRotation(rotationMaster);
            Iterator it = rotationList.iterator();
            if (i >= day) {
                break;
            }
            while (it.hasNext()) {
                rotationMaster = (RotationMaster) it.next();
                if (flag != 1) {
                    if (firstShiftId.equals(rotationMaster.getShiftMaster().getId().toString())) {
                        flag = 1;
                    }
                }

                if (flag == 1) {
                    for (i = currentDay; i <= day; i++) {

                        shiftMaster = shiftMasterService.readById(rotationMaster.getShiftMaster().getId());
                        try {
                            if (rotationArray.size() != day) {
                                if (!sunday.contains(i)) {
                                    rotationArray.add(shiftMaster.getId());
                                } else {
                                    rotationArray.add(-1);
                                }
                            }

                        } catch (Exception ex) {
                            System.out.println("Array Size Exception" + ex);
                        }
                        if (count == days) {
                            count = 1;
                            noOfDay = days;
                            i++;
                            currentDay = i;
                            break;
                        }
                        noOfDay = count;
                        count++;

                    }
                }
            }

        }
        int totalNoOfDay = days - noOfDay;
        if (null != shiftGenerateMonthlySchedule.getId()) {
            shiftGenerateMonthlySchedule1.setId(shiftGenerateMonthlySchedule.getId());
        }
        shiftGenerateMonthlySchedule1.setNoOfDays(totalNoOfDay);
        shiftGenerateMonthlySchedule1.setShiftMonth(cmonth);
        shiftGenerateMonthlySchedule1.setShiftYear(cyear);
        shiftGenerateMonthlySchedule1.setShiftRotationMaster(shiftRotationMaster);
        shiftGenerateMonthlySchedule1.setEmployeeMaster(employeeMaster);

        try {
            int i1 = 1;
            if (i1 >= dayofmonth) {
                shiftGenerateMonthlySchedule1.setDay1(rotationArray.get(0));
            } else {
                shiftGenerateMonthlySchedule1.setDay1(shiftGenerateMonthlySchedule.getDay1());
            }
            i1++;
            if (i1 >= dayofmonth) {
                shiftGenerateMonthlySchedule1.setDay2(rotationArray.get(1));
            } else {
                shiftGenerateMonthlySchedule1.setDay2(shiftGenerateMonthlySchedule.getDay2());
            }
            i1++;
            if (i1 >= dayofmonth) {
                shiftGenerateMonthlySchedule1.setDay3(rotationArray.get(2));
            } else {
                shiftGenerateMonthlySchedule1.setDay3(shiftGenerateMonthlySchedule.getDay3());
            }
            i1++;
            if (i1 >= dayofmonth) {
                shiftGenerateMonthlySchedule1.setDay4(rotationArray.get(3));
            } else {
                shiftGenerateMonthlySchedule1.setDay4(shiftGenerateMonthlySchedule.getDay4());
            }
            i1++;
            if (i1 >= dayofmonth) {
                shiftGenerateMonthlySchedule1.setDay5(rotationArray.get(4));
            } else {
                shiftGenerateMonthlySchedule1.setDay5(shiftGenerateMonthlySchedule.getDay5());
            }
            i1++;
            if (i1 >= dayofmonth) {
                shiftGenerateMonthlySchedule1.setDay6(rotationArray.get(5));
            } else {
                shiftGenerateMonthlySchedule1.setDay6(shiftGenerateMonthlySchedule.getDay6());
            }
            i1++;
            if (i1 >= dayofmonth) {
                shiftGenerateMonthlySchedule1.setDay7(rotationArray.get(6));
            } else {
                shiftGenerateMonthlySchedule1.setDay7(shiftGenerateMonthlySchedule.getDay7());
            }
            i1++;
            if (i1 >= dayofmonth) {
                shiftGenerateMonthlySchedule1.setDay8(rotationArray.get(7));
            } else {
                shiftGenerateMonthlySchedule1.setDay8(shiftGenerateMonthlySchedule.getDay8());
            }
            i1++;
            if (i1 >= dayofmonth) {
                shiftGenerateMonthlySchedule1.setDay9(rotationArray.get(8));
            } else {
                shiftGenerateMonthlySchedule1.setDay9(shiftGenerateMonthlySchedule.getDay9());
            }
            i1++;
            if (i1 >= dayofmonth) {
                shiftGenerateMonthlySchedule1.setDay10(rotationArray.get(9));
            } else {
                shiftGenerateMonthlySchedule1.setDay10(shiftGenerateMonthlySchedule.getDay10());
            }
            i1++;
            if (i1 >= dayofmonth) {
                shiftGenerateMonthlySchedule1.setDay11(rotationArray.get(10));
            } else {
                shiftGenerateMonthlySchedule1.setDay11(shiftGenerateMonthlySchedule.getDay11());
            }
            i1++;
            if (i1 >= dayofmonth) {
                shiftGenerateMonthlySchedule1.setDay12(rotationArray.get(11));
            } else {
                shiftGenerateMonthlySchedule1.setDay12(shiftGenerateMonthlySchedule.getDay12());
            }
            i1++;
            if (i1 >= dayofmonth) {
                shiftGenerateMonthlySchedule1.setDay13(rotationArray.get(12));
            } else {
                shiftGenerateMonthlySchedule1.setDay13(shiftGenerateMonthlySchedule.getDay13());
            }
            i1++;
            if (i1 >= dayofmonth) {
                shiftGenerateMonthlySchedule1.setDay14(rotationArray.get(13));
            } else {
                shiftGenerateMonthlySchedule1.setDay14(shiftGenerateMonthlySchedule.getDay14());
            }
            i1++;
            if (i1 >= dayofmonth) {
                shiftGenerateMonthlySchedule1.setDay15(rotationArray.get(14));
            } else {
                shiftGenerateMonthlySchedule1.setDay15(shiftGenerateMonthlySchedule.getDay15());
            }
            i1++;
            if (i1 >= dayofmonth) {
                shiftGenerateMonthlySchedule1.setDay16(rotationArray.get(15));
            } else {
                shiftGenerateMonthlySchedule1.setDay16(shiftGenerateMonthlySchedule.getDay16());
            }
            i1++;
            if (i1 >= dayofmonth) {
                shiftGenerateMonthlySchedule1.setDay17(rotationArray.get(16));
            } else {
                shiftGenerateMonthlySchedule1.setDay17(shiftGenerateMonthlySchedule.getDay17());
            }
            i1++;
            if (i1 >= dayofmonth) {
                shiftGenerateMonthlySchedule1.setDay18(rotationArray.get(17));
            } else {
                shiftGenerateMonthlySchedule1.setDay18(shiftGenerateMonthlySchedule.getDay18());
            }
            i1++;
            if (i1 >= dayofmonth) {
                shiftGenerateMonthlySchedule1.setDay19(rotationArray.get(18));
            } else {
                shiftGenerateMonthlySchedule1.setDay19(shiftGenerateMonthlySchedule.getDay19());
            }
            i1++;
            if (i1 >= dayofmonth) {
                shiftGenerateMonthlySchedule1.setDay20(rotationArray.get(19));
            } else {
                shiftGenerateMonthlySchedule1.setDay20(shiftGenerateMonthlySchedule.getDay20());
            }
            i1++;
            if (i1 >= dayofmonth) {
                shiftGenerateMonthlySchedule1.setDay21(rotationArray.get(20));
            } else {
                shiftGenerateMonthlySchedule1.setDay21(shiftGenerateMonthlySchedule.getDay21());
            }
            i1++;
            if (i1 >= dayofmonth) {
                shiftGenerateMonthlySchedule1.setDay22(rotationArray.get(21));
            } else {
                shiftGenerateMonthlySchedule1.setDay22(shiftGenerateMonthlySchedule.getDay22());
            }
            i1++;
            if (i1 >= dayofmonth) {
                shiftGenerateMonthlySchedule1.setDay23(rotationArray.get(22));
            } else {
                shiftGenerateMonthlySchedule1.setDay23(shiftGenerateMonthlySchedule.getDay23());
            }
            i1++;
            if (i1 >= dayofmonth) {
                shiftGenerateMonthlySchedule1.setDay24(rotationArray.get(23));
            } else {
                shiftGenerateMonthlySchedule1.setDay24(shiftGenerateMonthlySchedule.getDay24());
            }
            i1++;
            if (i1 >= dayofmonth) {
                shiftGenerateMonthlySchedule1.setDay25(rotationArray.get(24));
            } else {
                shiftGenerateMonthlySchedule1.setDay25(shiftGenerateMonthlySchedule.getDay25());
            }
            i1++;
            if (i1 >= dayofmonth) {
                shiftGenerateMonthlySchedule1.setDay26(rotationArray.get(25));
            } else {
                shiftGenerateMonthlySchedule1.setDay26(shiftGenerateMonthlySchedule.getDay26());
            }
            i1++;
            if (i1 >= dayofmonth) {
                shiftGenerateMonthlySchedule1.setDay27(rotationArray.get(26));
            } else {
                shiftGenerateMonthlySchedule1.setDay27(shiftGenerateMonthlySchedule.getDay27());
            }
            i1++;
            if (i1 >= dayofmonth) {
                shiftGenerateMonthlySchedule1.setDay28(rotationArray.get(27));
            } else {
                shiftGenerateMonthlySchedule1.setDay28(shiftGenerateMonthlySchedule.getDay28());
            }
            i1++;
            if (i1 >= dayofmonth) {
                shiftGenerateMonthlySchedule1.setDay29(rotationArray.get(28));
            } else {
                shiftGenerateMonthlySchedule1.setDay29(shiftGenerateMonthlySchedule.getDay29());
            }
            i1++;
            if (i1 >= dayofmonth) {
                shiftGenerateMonthlySchedule1.setDay30(rotationArray.get(29));
            } else {
                shiftGenerateMonthlySchedule1.setDay30(shiftGenerateMonthlySchedule.getDay30());
            }
            i1++;
            if (i1 >= dayofmonth) {
                shiftGenerateMonthlySchedule1.setDay31(rotationArray.get(30));
            } else {
                shiftGenerateMonthlySchedule1.setDay31(shiftGenerateMonthlySchedule.getDay31());
            }
            shiftGenerateMonthlyScheduleService.createOrUpdate(shiftGenerateMonthlySchedule1);
        } catch (Exception e) {
            System.out.println("Exception" + e);
        }

        System.out.println("lol");

//    }
    }

    public ModelAndView getUserDetail(HttpServletRequest request, HttpServletResponse response, EmployeeMaster employeeMaster) throws Exception {
        ModelAndView mv = new ModelAndView();
        String lastYearPerformanceRatingsOfEmployee = "";
//        EmployeeMaster employeeMaster = new EmployeeMaster();
        UserRightMaster user = (UserRightMaster) request.getSession().getAttribute("userRight");
        //set Employee master id//
        int id = Integer.parseInt(request.getParameter("id"));
//        employeeMaster.setId(Integer.parseInt(id));
//        employeeMaster.setEmployeeId(id);
        //set Employee master id//
        EmployeeTypeMaster employeeTypeMaster = new EmployeeTypeMaster();
//        EmployeeMasterExtension employeeMasterExtension = new EmployeeMasterExtension();
        EmployeeSubType employeeSubType = new EmployeeSubType();
        UserMaster userMaster = new UserMaster();
        // Employee Extension
        employeeMaster = employeeMasterService.readById(id);
        List<?> employeeMasterExtensionList = employeeMasterServiceExtension.readByemployeeId(employeeMaster.getId());
        List<?> employeeVisaDetailsList = employeeVisaDetailsService.readByemployeeId(employeeMaster.getId());
        List<?> employeeresignationdetail = resignationMasterService.readByApprovedEmpID(employeeMaster.getId());

        ///this code is for read file name and display it
//        String userName = readUserName(request);
        String userName = request.getParameter("userid");
        request.setAttribute("userName", userName);//this attribute is for use name and read form directory structure.s
        String fileLocationURL = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "UserProfile"
                + File.separator + userName + File.separator;
        File pictureFile = new File(fileLocationURL);
        if (pictureFile.exists() && pictureFile.listFiles().length > 0) {
            File[] file = pictureFile.listFiles();
            request.setAttribute("imgFile", "StorageYard" + File.separator + "UserProfile" + File.separator + userName + File.separator + file[0].getName());
        } else {
            request.setAttribute("imgFile", "StorageYard" + File.separator + "UserProfile" + File.separator + "User" + File.separator + "default.png");
        }
        DepartmentMaster departmentMaster = new DepartmentMaster();
        DesignationMaster designationMaster = new DesignationMaster();
        LevelMaster levelMaster = new LevelMaster();
        LocationMaster locationMaster = new LocationMaster();
        ShiftMaster shiftMaster = new ShiftMaster();
        ZydexLocationMaster zydexLocationMaster = new ZydexLocationMaster();
        bind(request, userMaster);
        selectEmployee(request, response);
        departmentList(request);
        designationList(request);
        levelList(request);
        locationList(request);
        shiftRotaionList(request);
        setZydexLocationList(request);
        competencyList(request);
        EmployeeTypeList(request);
        EmployeeSubTypeList(request);
        policyList(request);
        ctcList(request);
        companyList(request);

//        shiftList(request);
        hoursBasisList(request);
        //getLastYearPerformance Ratings Of Employee For ReadOnly.s
        List<?> lastYearPerformanceRatingsOfEmployeeList = employeeMasterService.getLastYearPerformanceRatingOfEmployee(id);

        lastYearPerformanceRatingsOfEmployee = (lastYearPerformanceRatingsOfEmployeeList.isEmpty()) ? lastYearPerformanceRatingsOfEmployee : String.valueOf(lastYearPerformanceRatingsOfEmployeeList.get(0));
        //set user master id//
        String userid = request.getParameter("userid");
        userMaster.setId(Integer.parseInt(userid));
        employeeMaster.setUserMaster(userMaster);
        //set Employee master id//
        selectedEmployeeLevel1(request, employeeMaster);
        List<String> certificatesList = new ArrayList();
        UserMaster userMaster1 = new UserMaster();
        userMaster1 = userMasterService.readById(Integer.parseInt(userid));
        String certificateFileLocationURL = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "UserCertificate"
                + File.separator + userMaster1.getUserName() + File.separator;
        File certificateListFile = new File(certificateFileLocationURL);
        if (certificateListFile.listFiles() != null) {

            for (File sss : certificateListFile.listFiles()) {
                String aa = sss.getName();
                certificatesList.add(aa);

            }
            if (certificateListFile.exists() && certificateListFile.listFiles().length > 0) {
                File[] certificateListFileArray = certificateListFile.listFiles();
                try {
                    request.setAttribute("imageFile", "StorageYard" + File.separator + "UserCertificate" + File.separator + userName + File.separator + certificateListFileArray[0].getName().replaceAll(" ", ""));
                } catch (Exception e) {
                }
            }
        }
        //Code to fetch policy details IN VIEW CLICK
        List finalPolicyList = new ArrayList();
        PolicyMaster policyMaster = new PolicyMaster();
        List<?> policyData = (List<?>) employeePolicyDetailService.fetchPolicyData(employeeMaster.getId());
        for (Object policyDataObject : policyData) {
            List policyList = new ArrayList();
            Object[] policyDetail = (Object[]) policyDataObject;
            policyList.add(policyDetail[0]);
            policyList.add(policyDetail[1]);
            policyList.add(policyDetail[2]);
            policyList.add(policyDetail[3]);
            policyList.add(policyDetail[4]);
            policyList.add(policyDetail[5]);
            finalPolicyList.add(policyList);
        }
        List finalctcList = new ArrayList();
        CtcAllowance ctcAllowance = new CtcAllowance();
        List<?> ctcData = (List<?>) employeeCtcDetailService.fetchctcData(employeeMaster.getId());
        for (Object ctcDataObject : ctcData) {
            List ctcList = new ArrayList();
            Object[] policyDetail1 = (Object[]) ctcDataObject;
            ctcList.add(policyDetail1[0]);
            ctcList.add(policyDetail1[1]);
            ctcList.add(policyDetail1[2]);
            ctcList.add(policyDetail1[3]);
            ctcList.add(policyDetail1[4]);
            ctcList.add(policyDetail1[5]);
            ctcList.add(policyDetail1[6]);

//            ctcList.add(policyDetail1[3]);
            finalctcList.add(ctcList);
        }
        int empId = employeeMaster.getEmployeeTypeMaster().getId();
        if (employeeMaster.getEmployeeSubType() != null) {
            int empSubId = employeeMaster.getEmployeeSubType().getId();
            Boolean checkPf = payrollPfCheckService.getPFCheckValue(empId, empSubId);
            Boolean checkPt = payrollPtCheckService.getPTCheckValue(empId, empSubId);

//        selectedEmployeeLevel2(request, employeeMaster);
//        selectedEmployeeLevel3(request, employeeMaster);
//        selectedEmployeeLevel4(request, employeeMaster);
//        selectedEmployeeLevel5(request, employeeMaster);
//        selectedEmployeeLevel6(request, employeeMaster);
            request.setAttribute("checkPf", checkPf);
            request.setAttribute("checkPt", checkPt);
        }
        String officialdate = "";
        String physicaldate = "";
        if (!employeeresignationdetail.isEmpty()) {
            ResignationMaster resignationMaster = (ResignationMaster) employeeresignationdetail.get(0);
            officialdate = resignationMaster.getRelievingDate();
            physicaldate = resignationMaster.getRelievingDatephysical();
        }

        String rmName2 = "";
        String rmName3 = "";
        String rmName4 = "";
        String rmName5 = "";
        String rmName6 = "";
        String rm2 = employeeMaster.getReportingManagerLevel2();
        String rm3 = employeeMaster.getReportingManagerLevel3();
        String rm4 = employeeMaster.getReportingManagerLevel4();
        String rm5 = employeeMaster.getReportingManagerLevel5();
        String rm6 = employeeMaster.getReportingManagerLevel6();
        if (!rm2.isEmpty()) {
            rmName2 = employeeMasterService.getNameById(Integer.parseInt(rm2));
        }
        if (!rm3.isEmpty()) {
            rmName3 = employeeMasterService.getNameById(Integer.parseInt(rm3));
        }
        if (!rm4.isEmpty()) {
            rmName4 = employeeMasterService.getNameById(Integer.parseInt(rm4));
        }
        if (!rm5.isEmpty()) {
            rmName5 = employeeMasterService.getNameById(Integer.parseInt(rm5));
        }
        if (!rm6.isEmpty()) {
            rmName6 = employeeMasterService.getNameById(Integer.parseInt(rm6));
        }
        request.setAttribute("rmName2", rmName2);
        request.setAttribute("rmName3", rmName3);
        request.setAttribute("rmName4", rmName4);
        request.setAttribute("rmName5", rmName5);
        request.setAttribute("rmName6", rmName6);

        request.setAttribute("officialdate", officialdate);
        request.setAttribute("physicaldate", physicaldate);

        request.setAttribute("lastYearPerformanceRatingsOfEmployee", lastYearPerformanceRatingsOfEmployee);
//        request.setAttribute("company", employeeMaster.getCompany());

        request.setAttribute("employeeVisaDetailsList", employeeVisaDetailsList);
        request.setAttribute("employeeType", employeeMaster.getEmployeeType());
        request.setAttribute("shiftType", employeeMaster.getShiftType());
        request.setAttribute("certificatesList", certificatesList);
        request.setAttribute("finalPolicyList", finalPolicyList);
        request.setAttribute("finalctcList", finalctcList);
        //Employee Master Extension
        request.setAttribute("employeeMasterExtensionList", employeeMasterExtensionList);

        mv.getModelMap().put("employeeMaster", employeeMaster);
        request.setAttribute("mriStatus", employeeMaster.getMaritalStatus());
        mv.setViewName("Employee/UserDetail");
        return mv;

    }

    //this method is created for search employee from searchbox given in header bar and shows result same as searchSubmit method of this controller.
    public ModelAndView getEmployeeDetailsBySearchString(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        String searchString = request.getParameter("searchString");
//        List<?> employeeMasterList = employeeMasterService.read();
//        List<?> employeeMasterList = employeeMasterService.searchEmployeeDetail(searchString);
        List<?> employeeMasterList = employeeMasterService.searchEmployeeDetailForContactInfo(searchString);
        mv.getModelMap().put("list", employeeMasterList);
        //dont rename "list" because same used on searchSubmit method and employeeRegistrationResult.jsp
        mv.getModelMap().put("employeeMaster", employeeMaster);

//        mv.setViewName("Employee/EmployeeRegistrationResult");
        mv.setViewName("Employee/EmployeeContactDetailResult");
        return mv;
    }

    public ModelAndView excelUploadRegistration(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Employee/EmployeeRegistrationThroughUpload");
        return mv;
    }

    public ModelAndView excelUploadAllowance(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Employee/EmployeeAllowanceUpload");
        return mv;
    }

    public void readEmployeeFile(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        String fileName = request.getParameter("fileName");

        String filePath = File.separator + "StorageYard" + File.separator
                + "Other" + File.separator + "UserDoc" + File.separator
                + "Payroll" + File.separator + fileName;

        String appPath = request.getServletContext().getRealPath("");

        String fullPath = appPath + filePath;

        request.setAttribute("filePath", fullPath);

        DownloadFile downloadFile = new DownloadFile();
        downloadFile.doDownload(request, response);
    }

//    public ModelAndView excelUploadRegistrationSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        ModelAndView mv = new ModelAndView();
//        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
//        MultipartFile multipartFile = multipartRequest.getFile("file1");
//        EmployeeMaster employeeMaster = new EmployeeMaster();
//        LevelMaster levelMaster = new LevelMaster();
//        EmployeeTypeMaster employeeType1 = new EmployeeTypeMaster();
//        EmployeeSubType employeeSubType = new EmployeeSubType();
//        DepartmentMaster departmentMaster = new DepartmentMaster();
//        DesignationMaster designationMaster = new DesignationMaster();
//        ZydexLocationMaster zydexLocationMaster = new ZydexLocationMaster();
//        LocationMaster locationMaster = new LocationMaster();
//        ShiftRotationMaster shiftRotationMaster = new ShiftRotationMaster();
//        ShiftRotationInfo shiftRotationInfo = new ShiftRotationInfo();
//        ShiftMaster shiftMaster = new ShiftMaster();
//        HoursBasis hoursBasis = new HoursBasis();
//        RotationMaster rotationMaster = new RotationMaster();
//        int counter = 0;
//        int counterOfException = 0;
//        String employeeNo = "";
//        String employeeFirstName = "";
//        String employeeLastName = "";
//        String dateOfJoiningNonFormated = "";
//        String gender = "";
//        String dobNonFormated = "";
//        String employeeType = "";
//        String employeeSubtype = ""; // employee sub type
//        String designation = "";
//        String typeofemployee = ""; // employee Type
//        String reportingManager = "";
//        String level = "";
//        String workLocation = "";
//        String role = "";
//        //***employee extension****//
//        String FirstName = "";
//        String MiddleName = "";
//        String LastName = "";
//        //***employee extension END****//
//
////        String passportNo = "";
//        //***employee extension****//
//        String nationality = "";
////        String countryOfIssue = "";
//        //***employee extension END****//
//
////        String passportDateOfIssue = "";
////        String passportExpiryDate = "";
//        //***employee extension****//
////        String visaIssueCountry = "";
////        String visaIssueDate = "";
////        String visaValidTillDate = "";
//        //***employee extension END****//
//        String presentAddress1 = "";
//        //***employee extension****//
//        String presentAddress2 = "";
//        String presentCity = "";
//        String presentState = "";
//        String presentPostalCode = "";
//        String presentCountry = "";
//        //***employee extension END****//
//
//        String permanentAddress1 = "";
//        //***employee extension****//
//        String permanentAddress2 = "";
//        String permanentCity = "";
//        String permanentState = "";
//        String permanentPostalCode = "";
//        String permanentCountry = "";
//        //***employee extension END****//
//
//        String contactNo1resident = "";
//        String contactNo2mobile = "";
//        //***employee extension****//
////        String flyDocsEmailId = "";
//        //***employee extension END****//
//
//        String personalEmailId = "";
//        String bankAccountNo = "";
//        String bankName = "";
//        String ifscCode = "";
//        //***employee extension****//
//        String pfwithdrawalDate = "";
//        //***employee extension END****//
//
//        String pfNo = ""; //pf 
//        //***employee extension****//
//        String pfNoFlydocs = "";
////        String electionCard = "";
//        //***employee extension END****//
//
//        String pan = "";
//        String aadharCard = "";
//        String esicNo = ""; //esic no
//        String uanNo = ""; //uano
//        String maritalStatus = "";
//        //***employee extension****//
////        String religion = "";
//        //***employee extension END****//
//
//        String bloodGroup = "";
//        //***employee extension****//
//        String disclosedHealthConcerns = "";
//        //***employee extension END****//
//
//        String drivinglicenceNo = "";
//        //***employee extension****//
//        String drivingLicenceType = "";
//        //***employee extension END****//
//
//        String fatherNamed1 = "";
//        String fatherdob = "";
//        String motherNamed2 = "";
//        String motherdob = "";
//        String spouseNamed3 = "";
//        String spouseGender3 = "";
//        String spousedob = "";
//        String childname1 = "";
//        //***employee extension****//
//        String childOneGender = "";
//        //***employee extension END****//
//
//        String childdob1 = "";
//        String childname2 = "";
//        //***employee extension****//
//        String childTwoGender = "";
//        //***employee extension END****//
//
//        String childdob2 = "";
//        String emergencyContactPerson = "";
//        //***employee extension****//
//        String RelationShip = "";
//        //***employee extension END****//
//
//        String emergencyContactNo = "";
//        //***employee extension****//
//        String emergencyContactAddress = "";
//        String otherImpInfo = "";
//        String previouscompanyname = "";
//        String previouscompanylocation = "";
//        //***employee extension END****//
//
//        String companylocationCity = "";
//        String employeeeEXPonJoiningYears = "";
//        String employeeeEXPonJoiningMonths = "";
//        String highestEducation = "";
//        //***employee extension****//
//        String languagesKnown = "";
//        String hobbies = "";
//        //***employee extension END****// 
//
//        String workType = "";//shift(base) or hours(base).
//        String hours = "";//(eg...9Hours , 10Hours).
//        String shiftName = "";//shift Name.
//        String shiftRotation = "";//shift Rotation Name.
//        String shiftRotationDate = "";//shift Rotation Name.
//        String paymentType = "";
//        String basicSalary = "";
//        String company = "";
//        String department = "";
//        String nameper = "";
//        String pfconbyemployee = "";
//        String pfconbyemployer = "";
//        String pfcheck = "";
//        String ptcheck = "";
//        String esiccheck = "";
//        String salarybase = "";
//        String ot = "";
//        String oddpunchreq = "";
//        String payroll = "";
//
//        boolean isShiftRotationCreated = false;//if new created then enter information in RotationMaster table.
//        boolean isShiftMasterCreated = false;//if new created RotationMaster table with ShiftRotationMaster.
//        ShiftMaster shiftMasteDefault = new ShiftMaster();
//
//        boolean gender1 = false;
//        StringBuffer stringBuffer = new StringBuffer();
//        StringBuffer stringBufferOfExceptions = new StringBuffer();
//        stringBufferOfExceptions.append("");
//        try {
//            if (multipartFile.getSize() > 0) {
//                InputStream file = multipartFile.getInputStream();
//                Workbook workbook = WorkbookFactory.create(file);
//                Sheet sheet = workbook.getSheetAt(0);
//                for (Row row : sheet) {
//                    try {
//                        if (row.getRowNum() != 0 && row.getRowNum() != 1 && row.getRowNum() != 2) {
//                            if (row.getCell(1) != null) {
//                                try {
//                                    employeeNo = "" + (null == row.getCell((short) 1) ? "" : row.getCell((short) 1));
//                                    employeeNo = employeeNo.split("\\.", 2)[0];
//                                } catch (Exception e) {
//                                    employeeNo = "" + (null == row.getCell((short) 1) ? "" : row.getCell((short) 1));
//                                }
//
//                                employeeFirstName = "" + (null == row.getCell((short) 2) ? "" : row.getCell((short) 2));
//                                employeeLastName = "" + (null == row.getCell((short) 3) ? "" : row.getCell((short) 3));
//                                String employeefullname = employeeFirstName + " " + employeeLastName;
//                                dateOfJoiningNonFormated = "" + (null == row.getCell((short) 4) ? "" : row.getCell((short) 4));
////                            SimpleDateFormat sdfSource = new SimpleDateFormat("dd/MM/yy");
////                            Date date = sdfSource.parse(dateOfJoiningNonFormated);
////                            String dateOfJoiningformated = String.valueOf(date);
//
//                                SimpleDateFormat sdfDOJ = new SimpleDateFormat("dd-MMM-yyyy");
//                                SimpleDateFormat sdfDOJ2 = new SimpleDateFormat("dd/MM/yyyy");
//
//                                Date dateDOJ = sdfDOJ.parse(dateOfJoiningNonFormated);
//                                String nDate = sdfDOJ.format(dateDOJ);
//                                String dateOfJoining = sdfDOJ2.format(dateDOJ);
//
//                                gender = "" + (null == row.getCell((short) 5) ? "" : row.getCell((short) 5));
//                                dobNonFormated = "" + (null == row.getCell((short) 6) ? "" : row.getCell((short) 6));
//                                String dobformated;
//                                if (!dobNonFormated.contains("N/A")) {
//                                    SimpleDateFormat sdfpDOb = new SimpleDateFormat("dd-MMM-yyyy");
//                                    SimpleDateFormat sdfpDOb2 = new SimpleDateFormat("dd/MM/yyyy");
//
//                                    Date datepDOb = sdfpDOb.parse(dobNonFormated);
//                                    String nDate8 = sdfpDOb.format(datepDOb);
//                                    dobformated = sdfpDOb2.format(datepDOb);
//                                } else {
//                                    dobformated = "N/A";
//                                }
//                                employeeType = "" + (null == row.getCell((short) 7) ? "" : row.getCell((short) 7));
//                                employeeSubtype = "" + (null == row.getCell((short) 8) ? "" : row.getCell((short) 8));
//                                designation = "" + (null == row.getCell((short) 9) ? "" : row.getCell((short) 9));
//                                typeofemployee = "" + (null == row.getCell((short) 10) ? "" : row.getCell((short) 10));
//                                reportingManager = "" + (null == row.getCell((short) 11) ? "" : row.getCell((short) 11));
//                                level = "" + (null == row.getCell((short) 12) ? "" : row.getCell((short) 12));
//                                workLocation = "" + (null == row.getCell((short) 13) ? "" : row.getCell((short) 13));
//                                role = "" + (null == row.getCell((short) 14) ? "" : row.getCell((short) 14));
//
//                                nameper = "" + (null == row.getCell((short) 15) ? "" : row.getCell((short) 15));
//
//                                FirstName = "" + (null == row.getCell((short) 16) ? "" : row.getCell((short) 16));
//                                MiddleName = "" + (null == row.getCell((short) 17) ? "" : row.getCell((short) 17));
//                                LastName = "" + (null == row.getCell((short) 18) ? "" : row.getCell((short) 18));
////                            passportNo = "" + (null == row.getCell((short) 19) ? "" : row.getCell((short) 19));
//                                nationality = "" + (null == row.getCell((short) 19) ? "" : row.getCell((short) 19));
////                            countryOfIssue = "" + (null == row.getCell((short) 21) ? "" : row.getCell((short) 21));
////                            passportDateOfIssue = "" + (null == row.getCell((short) 22) ? "" : row.getCell((short) 22));
////                            String passportDateOfIssueformated;
////                            if (!passportDateOfIssue.contains("N/A")) {
////                                SimpleDateFormat sdfpDOJ = new SimpleDateFormat("dd-MMM-yyyy");
////                                SimpleDateFormat sdfpDOJ2 = new SimpleDateFormat("dd/MM/yyyy");
////
////                                Date datepDOJ = sdfpDOJ.parse(passportDateOfIssue);
////                                String nDate8 = sdfpDOJ.format(datepDOJ);
////                                passportDateOfIssueformated = sdfpDOJ2.format(datepDOJ);
////                            } else {
////                                passportDateOfIssueformated = "N/A";
////                            }
////                            passportExpiryDate = "" + (null == row.getCell((short) 23) ? "" : row.getCell((short) 23));
////                            String passportExpiryDateformated;
////                            if (!passportExpiryDate.contains("N/A")) {
////                                SimpleDateFormat sdfpeDOJ = new SimpleDateFormat("dd-MMM-yyyy");
////                                SimpleDateFormat sdfpeDOJ2 = new SimpleDateFormat("dd/MM/yyyy");
////
////                                Date datepeDOJ = sdfpeDOJ.parse(passportExpiryDate);
////                                String nDate9 = sdfpeDOJ.format(datepeDOJ);
////                                passportExpiryDateformated = sdfpeDOJ2.format(datepeDOJ);
////                            } else {
////                                passportExpiryDateformated = "N/A";
////                            }
////                            visaIssueCountry = "" + (null == row.getCell((short) 24) ? "" : row.getCell((short) 24));
////                            visaIssueDate = "" + (null == row.getCell((short) 25) ? "" : row.getCell((short) 25));
////                            visaValidTillDate = "" + (null == row.getCell((short) 26) ? "" : row.getCell((short) 26));
//                                presentAddress1 = "" + (null == row.getCell((short) 20) ? "" : row.getCell((short) 20));
//                                presentAddress2 = "" + (null == row.getCell((short) 21) ? "" : row.getCell((short) 21));
//                                presentCity = "" + (null == row.getCell((short) 22) ? "" : row.getCell((short) 22));
//                                presentState = "" + (null == row.getCell((short) 23) ? "" : row.getCell((short) 23));
//                                presentPostalCode = "" + (null == row.getCell((short) 24) ? "" : row.getCell((short) 24));
//                                presentPostalCode = presentPostalCode.split("\\.", 2)[0];
//                                presentCountry = "" + (null == row.getCell((short) 25) ? "" : row.getCell((short) 25));
//                                permanentAddress1 = "" + (null == row.getCell((short) 27) ? "" : row.getCell((short) 27));
//                                permanentAddress2 = "" + (null == row.getCell((short) 28) ? "" : row.getCell((short) 28));
//                                permanentCity = "" + (null == row.getCell((short) 29) ? "" : row.getCell((short) 29));
//                                permanentState = "" + (null == row.getCell((short) 30) ? "" : row.getCell((short) 30));
//                                permanentPostalCode = "" + (null == row.getCell((short) 31) ? "" : row.getCell((short) 31));
//                                permanentPostalCode = permanentPostalCode.split("\\.", 2)[0];
//                                permanentCountry = "" + (null == row.getCell((short) 32) ? "" : row.getCell((short) 32));
//                                contactNo1resident = "" + (null == row.getCell((short) 34) ? "" : row.getCell((short) 34));
//                                String contactNo = "";
//                                if (!contactNo1resident.equals("")) {
//                                    BigDecimal bdContactNo = new BigDecimal(contactNo1resident);
//                                    contactNo = "" + bdContactNo.longValue();
//                                } else {
//                                    contactNo = "";
//                                }
//                                contactNo2mobile = "" + (null == row.getCell((short) 35) ? "" : row.getCell((short) 35));
//                                String contactNo2 = "";
//                                if (!contactNo2mobile.equals("")) {
//                                    BigDecimal bdContactNo2 = new BigDecimal(contactNo2mobile);
//                                    contactNo2 = "" + bdContactNo2.longValue();
//                                } else {
//                                    contactNo2 = "";
//                                }
////                            flyDocsEmailId = "" + (null == row.getCell((short) 36) ? "" : row.getCell((short) 36));
//                                personalEmailId = "" + (null == row.getCell((short) 36) ? "" : row.getCell((short) 36));
//                                bankAccountNo = "" + (null == row.getCell((short) 38) ? "" : row.getCell((short) 38));
//                                String bNo = "";
//                                if (!bankAccountNo.equals("")) {
//                                    BigDecimal bdbNo = new BigDecimal(bankAccountNo);
//                                    bNo = "" + bdbNo.longValue();
//                                } else {
//                                    bNo = "";
//                                }
//                                bankName = "" + (null == row.getCell((short) 39) ? "" : row.getCell((short) 39));
//                                ifscCode = "" + (null == row.getCell((short) 40) ? "" : row.getCell((short) 40));
//                                pfwithdrawalDate = "" + (null == row.getCell((short) 41) ? "" : row.getCell((short) 41));
//                                pfNo = "" + (null == row.getCell((short) 42) ? "" : row.getCell((short) 42));
//                                pfNoFlydocs = "" + (null == row.getCell((short) 43) ? "" : row.getCell((short) 43));
////                            electionCard = "" + (null == row.getCell((short) 53) ? "" : row.getCell((short) 53));
//                                pan = "" + (null == row.getCell((short) 44) ? "" : row.getCell((short) 44));
//                                aadharCard = "" + (null == row.getCell((short) 45) ? "" : row.getCell((short) 45));
//                                String aNo = "";
//                                if (!aadharCard.equals("")) {
//                                    BigDecimal bdaNo = new BigDecimal(aadharCard);
//                                    aNo = "" + bdaNo.longValue();
//                                } else {
//                                    aNo = "";
//                                }
//                                esicNo = "" + (null == row.getCell((short) 46) ? "" : row.getCell((short) 46));
//                                uanNo = "" + (null == row.getCell((short) 47) ? "" : row.getCell((short) 47));
//                                String uannNo = "";
//                                if (!uanNo.equals("")) {
//                                    BigDecimal bduNo = new BigDecimal(uanNo);
//                                    uannNo = "" + bduNo.longValue();
//                                } else {
//                                    uannNo = "";
//                                }
//                                maritalStatus = "" + (null == row.getCell((short) 49) ? "" : row.getCell((short) 49));
////                            religion = "" + (null == row.getCell((short) 60) ? "" : row.getCell((short) 60));
//                                bloodGroup = "" + (null == row.getCell((short) 50) ? "" : row.getCell((short) 50));
//                                disclosedHealthConcerns = "" + (null == row.getCell((short) 51) ? "" : row.getCell((short) 51));
//                                drivinglicenceNo = "" + (null == row.getCell((short) 53) ? "" : row.getCell((short) 53));
////                            String drilicNo = "";
////                            if (!drivinglicenceNo.equals("")) {
////                                BigDecimal bddrilicNo = new BigDecimal(drivinglicenceNo);
////                                drilicNo = "" + bddrilicNo.longValue();
////                            } else {
////                                drilicNo = "";
////                            }
//                                drivingLicenceType = "" + (null == row.getCell((short) 54) ? "" : row.getCell((short) 54));
//                                fatherNamed1 = "" + (null == row.getCell((short) 57) ? "" : row.getCell((short) 57));
//                                fatherdob = "" + (null == row.getCell((short) 59) ? "" : row.getCell((short) 59));
//                                String fatherdobformated;
//                                if (!fatherdob.contains("N/A")) {
//                                    SimpleDateFormat sdfdDOJ = new SimpleDateFormat("dd-MMM-yyyy");
//                                    SimpleDateFormat sdfdDOJ2 = new SimpleDateFormat("dd/MM/yyyy");
//
//                                    Date datesDOJ = sdfdDOJ.parse(fatherdob);
//                                    String nDate3 = sdfdDOJ.format(datesDOJ);
//                                    fatherdobformated = sdfdDOJ2.format(datesDOJ);
//                                } else {
//                                    fatherdobformated = "N/A";
//                                }
//                                motherNamed2 = "" + (null == row.getCell((short) 60) ? "" : row.getCell((short) 60));
//                                motherdob = "" + (null == row.getCell((short) 62) ? "" : row.getCell((short) 62));
//                                String motherdobformated;
//                                if (!motherdob.contains("N/A")) {
//                                    SimpleDateFormat sdfmDOJ = new SimpleDateFormat("dd-MMM-yyyy");
//                                    SimpleDateFormat sdfmDOJ2 = new SimpleDateFormat("dd/MM/yyyy");
//
//                                    Date datemDOJ = sdfmDOJ.parse(motherdob);
//                                    String nDate3 = sdfmDOJ.format(datemDOJ);
//                                    motherdobformated = sdfmDOJ2.format(datemDOJ);
//                                } else {
//                                    motherdobformated = "N/A";
//                                }
//                                spouseNamed3 = "" + (null == row.getCell((short) 63) ? "" : row.getCell((short) 63));
//                                spouseGender3 = "" + (null == row.getCell((short) 64) ? "" : row.getCell((short) 64));
//                                spousedob = "" + (null == row.getCell((short) 65) ? "" : row.getCell((short) 65));
//                                String spousedobformated;
//                                if (!spousedob.contains("N/A")) {
//                                    SimpleDateFormat sdfsDOJ = new SimpleDateFormat("dd-MMM-yyyy");
//                                    SimpleDateFormat sdfsDOJ2 = new SimpleDateFormat("dd/MM/yyyy");
//
//                                    Date datesDOJ = sdfsDOJ.parse(spousedob);
//                                    String nDate3 = sdfsDOJ.format(datesDOJ);
//                                    spousedobformated = sdfsDOJ2.format(datesDOJ);
//                                } else {
//                                    spousedobformated = "N/A";
//                                }
//
//                                childname1 = "" + (null == row.getCell((short) 66) ? "" : row.getCell((short) 66));
//                                childOneGender = "" + (null == row.getCell((short) 67) ? "" : row.getCell((short) 67));
//                                childdob1 = "" + (null == row.getCell((short) 68) ? "" : row.getCell((short) 68));
//                                String childdob1formated;
//                                if (!childdob1.contains("N/A")) {
//                                    SimpleDateFormat sdfcDOJ = new SimpleDateFormat("dd-MMM-yyyy");
//                                    SimpleDateFormat sdfcDOJ2 = new SimpleDateFormat("dd/MM/yyyy");
//
//                                    Date datecDOJ = sdfcDOJ.parse(childdob1);
//                                    String nDate4 = sdfcDOJ.format(datecDOJ);
//                                    childdob1formated = sdfcDOJ2.format(datecDOJ);
//                                } else {
//                                    childdob1formated = "N/A";
//                                }
//                                childname2 = "" + (null == row.getCell((short) 69) ? "" : row.getCell((short) 69));
//                                childTwoGender = "" + (null == row.getCell((short) 70) ? "" : row.getCell((short) 70));
//                                childdob2 = "" + (null == row.getCell((short) 71) ? "" : row.getCell((short) 71));
//                                String childdob2formated;
//                                if (!childdob2.contains("N/A")) {
//                                    SimpleDateFormat sdfc2DOJ = new SimpleDateFormat("dd-MMM-yyyy");
//                                    SimpleDateFormat sdfc2DOJ2 = new SimpleDateFormat("dd/MM/yyyy");
//
//                                    Date datec2DOJ = sdfc2DOJ.parse(childdob2);
//                                    String nDate5 = sdfc2DOJ.format(datec2DOJ);
//                                    childdob2formated = sdfc2DOJ2.format(datec2DOJ);
//                                } else {
//                                    childdob2formated = "N/A";
//                                }
//                                emergencyContactPerson = "" + (null == row.getCell((short) 73) ? "" : row.getCell((short) 73));
//                                RelationShip = "" + (null == row.getCell((short) 74) ? "" : row.getCell((short) 74));
//                                emergencyContactNo = "" + (null == row.getCell((short) 75) ? "" : row.getCell((short) 75));
//                                String econtactNo = "";
//                                if (!emergencyContactNo.equals("")) {
//                                    BigDecimal bdeContactNo = new BigDecimal(emergencyContactNo);
//                                    econtactNo = "" + bdeContactNo.longValue();
//                                } else {
//                                    econtactNo = "";
//                                }
//                                emergencyContactAddress = "" + (null == row.getCell((short) 76) ? "" : row.getCell((short) 76));
//                                otherImpInfo = "" + (null == row.getCell((short) 77) ? "" : row.getCell((short) 77));
//                                previouscompanyname = "" + (null == row.getCell((short) 83) ? "" : row.getCell((short) 83));
//                                previouscompanylocation = "" + (null == row.getCell((short) 84) ? "" : row.getCell((short) 84));
//                                companylocationCity = "" + (null == row.getCell((short) 85) ? "" : row.getCell((short) 85));
////                            employeeeEXPonJoiningYears = "" + (null == row.getCell((short) 96) ? "" : row.getCell((short) 96));
//                                try {
//                                    employeeeEXPonJoiningYears = new BigDecimal("" + (null == row.getCell((short) 86) ? "" : row.getCell((short) 86))).toPlainString();
//                                    employeeeEXPonJoiningYears = employeeeEXPonJoiningYears.split("\\.", 2)[0];
//                                } catch (Exception e) {
//                                    employeeeEXPonJoiningYears = "" + (null == row.getCell((short) 86) ? "" : row.getCell((short) 86));
//                                }
////                            String employeeeEXPYear = "";
////                            if (!employeeeEXPonJoiningYears.equals("")) {
////                                BigDecimal empEXPYear = new BigDecimal(employeeeEXPonJoiningYears);
////                                employeeeEXPYear = "" + empEXPYear.longValue();
////                            } else {
////                                employeeeEXPYear = "";
////                            }
////                            employeeeEXPonJoiningMonths = "" + (null == row.getCell((short) 97) ? "" : row.getCell((short) 97));
//                                try {
//                                    employeeeEXPonJoiningMonths = new BigDecimal("" + (null == row.getCell((short) 87) ? "" : row.getCell((short) 87))).toPlainString();
//                                    employeeeEXPonJoiningMonths = employeeeEXPonJoiningMonths.split("\\.", 2)[0];
//                                } catch (Exception e) {
//                                    employeeeEXPonJoiningMonths = "" + (null == row.getCell((short) 87) ? "" : row.getCell((short) 87));
//                                }
////                            String employeeeEXPMonth = "";
////                            if (!employeeeEXPonJoiningMonths.equals("")) {
////                                BigDecimal empEXPMonth = new BigDecimal(employeeeEXPonJoiningMonths);
////                                employeeeEXPMonth = "" + empEXPMonth.longValue();
////                            } else {
////                                employeeeEXPMonth = "";
////                            }
//                                highestEducation = "" + (null == row.getCell((short) 88) ? "" : row.getCell((short) 88));
//                                languagesKnown = "" + (null == row.getCell((short) 89) ? "" : row.getCell((short) 89));
//                                hobbies = "" + (null == row.getCell((short) 90) ? "" : row.getCell((short) 90));
//                                workType = "" + (null == row.getCell((short) 92) ? "" : row.getCell((short) 92));
//                                hours = "" + (null == row.getCell((short) 93) ? "" : row.getCell((short) 93));
//                                shiftName = "" + (null == row.getCell((short) 94) ? "" : row.getCell((short) 94));
//                                shiftRotation = "" + (null == row.getCell((short) 95) ? "" : row.getCell((short) 95));
//                                shiftRotationDate = "" + (null == row.getCell((short) 96) ? "" : row.getCell((short) 96));
//                                paymentType = "" + (null == row.getCell((short) 97) ? "" : row.getCell((short) 97));
//                                basicSalary = "" + (null == row.getCell((short) 98) ? "" : row.getCell((short) 98));
//                                basicSalary = basicSalary.split("\\.", 2)[0];
//                                company = "" + (null == row.getCell((short) 99) ? "" : row.getCell((short) 99));
//                                department = "" + (null == row.getCell((short) 100) ? "" : row.getCell((short) 100));
//
//                                pfconbyemployee = "" + (null == row.getCell((short) 101) ? "" : row.getCell((short) 101));
//                                pfconbyemployer = "" + (null == row.getCell((short) 102) ? "" : row.getCell((short) 102));
//                                pfcheck = "" + (null == row.getCell((short) 103) ? "" : row.getCell((short) 103));
//                                ptcheck = "" + (null == row.getCell((short) 104) ? "" : row.getCell((short) 104));
//                                esiccheck = "" + (null == row.getCell((short) 105) ? "" : row.getCell((short) 105));
//                                salarybase = "" + (null == row.getCell((short) 106) ? "" : row.getCell((short) 106));
//                                ot = "" + (null == row.getCell((short) 107) ? "" : row.getCell((short) 107));
//                                oddpunchreq = "" + (null == row.getCell((short) 108) ? "" : row.getCell((short) 108));
//                                payroll = "" + (null == row.getCell((short) 109) ? "" : row.getCell((short) 109));
//
//                                employeeMaster.setEmployeeType(typeofemployee);
//                                employeeMaster.setPfAmount(pfconbyemployee);
//                                employeeMaster.setPfAmountEmployer(pfconbyemployer);
//
//                                Boolean flag = false;
//                                if (pfcheck.contains("No")) {
//                                    employeeMaster.setPf(flag);
//                                } else if (pfcheck.contains("Yes")) {
//                                    flag = true;
//                                    employeeMaster.setPf(flag);
//                                } else {
//                                    employeeMaster.setPf(null);
//                                }
//                                Boolean flag1 = false;
//                                if (ptcheck.contains("No")) {
//                                    employeeMaster.setPt(flag1);
//                                } else if (ptcheck.contains("Yes")) {
//                                    flag1 = true;
//                                    employeeMaster.setPt(flag1);
//                                } else {
//                                    employeeMaster.setPt(null);
//                                }
//                                Boolean flag2 = false;
//                                if (esiccheck.contains("No")) {
//                                    employeeMaster.setEsic(flag2);
//                                } else if (esiccheck.contains("Yes")) {
//                                    flag2 = true;
//                                    employeeMaster.setEsic(flag2);
//                                } else {
//                                    employeeMaster.setEsic(null);
//                                }
//                                Boolean flag3 = false;
//                                if (salarybase.contains("Day")) {
//                                    employeeMaster.setSalaryBase(flag3);
//                                } else if (salarybase.contains("Month")) {
//                                    flag3 = true;
//                                    employeeMaster.setSalaryBase(flag3);
//                                } else {
//                                    employeeMaster.setSalaryBase(null);
//                                }
//                                Boolean flag4 = false;
//                                if (ot.contains("Yes")) {
//                                    employeeMaster.setOt(flag4);
//                                } else if (ot.contains("No")) {
//                                    flag4 = true;
//                                    employeeMaster.setOt(flag4);
//                                } else {
//                                    employeeMaster.setOt(null);
//                                }
//                                Boolean flag5 = false;
//                                if (oddpunchreq.contains("No")) {
//                                    employeeMaster.setOddPunch(flag5);
//                                } else if (oddpunchreq.contains("Yes")) {
//                                    flag5 = true;
//                                    employeeMaster.setOddPunch(flag5);
//                                } else {
//                                    employeeMaster.setOddPunch(null);
//                                }
//                                Boolean flag6 = false;
//                                if (payroll.contains("No")) {
//                                    employeeMaster.setPayroll(flag6);
//                                } else if (payroll.contains("Yes")) {
//                                    flag6 = true;
//                                    employeeMaster.setPayroll(flag6);
//                                } else {
//                                    employeeMaster.setPayroll(null);
//                                }
////                            employeeMaster.setPassportNo(passportNo);
////                            employeeMaster.setPassportIssueDate(passportDateOfIssueformated);
////                            employeeMaster.setPassportExpiryDate(passportExpiryDateformated);
//                                employeeMaster.setPresentAddress(presentAddress1);
//                                employeeMaster.setDateOfBirthOfEmpFather(fatherdobformated);
//                                employeeMaster.setDateOfBirthOfEmpMother(motherdobformated);
//                                employeeMaster.setDateOfBirthOfEmpSpous(spousedobformated);
//                                employeeMaster.setChild1(childname1);
//                                employeeMaster.setChild2(childname2);
//                                employeeMaster.setDateOfBirthOfEmpChilld1(childdob1formated);
//                                employeeMaster.setDateOfBirthOfEmpChild2(childdob2formated);
//                                employeeMaster.setCityOfEmployee(companylocationCity);
//                                employeeMaster.setDrivingLicence(drivinglicenceNo);
//
////                            EmployeeVisaDetails employeeVisaDetails = new EmployeeVisaDetails();
////                            employeeVisaDetails.setVisaIssueCountry(visaIssueCountry);
////                            employeeVisaDetails.setVisaIssueDate(visaIssueDate);
////                            employeeVisaDetails.setVisaValidTillDate(visaValidTillDate);
//                                EmployeeMasterExtension employeeMasterExtension = new EmployeeMasterExtension();
////                            if (nameper.equalsIgnoreCase("Passport")){
////                                employeeMasterExtension.setNameStatus(false);
////                            }else if(nameper.equalsIgnoreCase("AadharCard")){
////                                employeeMasterExtension.setNameStatus(true);
////                            }else{
////                                employeeMasterExtension.setNameStatus(false);
////                            }
//                                employeeMasterExtension.setFirstName(FirstName);
//                                employeeMasterExtension.setMiddleName(MiddleName);
//                                employeeMasterExtension.setLastName(LastName);
//                                employeeMasterExtension.setNationality(nationality);
////                            employeeMasterExtension.setCountryOfIssue(countryOfIssue);
////                            employeeMasterExtension.setVisaIssueCountry(visaIssueCountry);
////                            employeeMasterExtension.setVisaIssueDate(visaIssueDate);
////                            employeeMasterExtension.setVisaValidTillDate(visaValidTillDate);
//                                employeeMasterExtension.setPresentAddress2(presentAddress2);
//                                employeeMasterExtension.setPresentCity(presentCity);
//                                employeeMasterExtension.setPresentCountry(presentCountry);
//                                employeeMasterExtension.setPresentPostalCode(presentPostalCode);
//                                employeeMasterExtension.setPresentState(presentState);
//
//                                employeeMasterExtension.setPermanentAddress2(permanentAddress2);
//                                employeeMasterExtension.setPermanentCity(permanentCity);
//                                employeeMasterExtension.setPermanentCountry(permanentCountry);
//                                employeeMasterExtension.setPermanentPostalCode(permanentPostalCode);
//                                employeeMasterExtension.setPermanentState(permanentState);
////                            employeeMasterExtension.setFlyDocsEmailId(flyDocsEmailId);
//                                employeeMasterExtension.setWithdrawalDate(pfwithdrawalDate);
//                                employeeMasterExtension.setPfNoFlydocs(pfNoFlydocs);
////                            employeeMasterExtension.setElectionCard(electionCard);
////                            employeeMasterExtension.setReligion(religion);
//                                employeeMasterExtension.setDisclosedHealthConcerns(disclosedHealthConcerns);
//                                employeeMasterExtension.setDrivingLicenceType(drivingLicenceType);
//                                employeeMasterExtension.setPreviousCompanyLocation(previouscompanylocation);
//                                employeeMasterExtension.setNameOfPreviousCompany(previouscompanyname);
//
//                                Boolean g = false;
////                            employeeMasterExtension.setNameStatus(g);
//                                if (childOneGender.contains("M")) {
//                                    employeeMasterExtension.setChildOneGender(g);
//                                } else if (childOneGender.contains("F")) {
//                                    g = true;
//                                    employeeMasterExtension.setChildOneGender(g);
//                                } else {
//
//                                    employeeMasterExtension.setChildOneGender(g);
//                                }
//
//                                if (childTwoGender.contains("M")) {
//                                    employeeMasterExtension.setChildTwoGender(g);
//                                } else if (childTwoGender.contains("F")) {
//                                    g = true;
//                                    employeeMasterExtension.setChildTwoGender(g);
//                                } else {
//                                    employeeMasterExtension.setChildTwoGender(g);
//                                }
//
//                                if (spouseGender3.contains("M")) {
//                                    employeeMasterExtension.setSpouseGender(g);
//                                } else if (spouseGender3.contains("F")) {
//                                    g = true;
//                                    employeeMasterExtension.setSpouseGender(g);
//                                } else {
//                                    employeeMasterExtension.setSpouseGender(g);
//                                }
//                                employeeMasterExtension.setRelationShip(RelationShip);
//                                employeeMasterExtension.setEmergencyContactAddress(emergencyContactAddress);
//                                employeeMasterExtension.setOtherImpInfo(otherImpInfo);
//                                employeeMasterExtension.setHobbies(hobbies);
//                                employeeMasterExtension.setLanguagesKnown(languagesKnown);
//
//                                employeeMaster.setEmployeeId(employeeNo);
//                                employeeMaster.setEmployeeName(employeefullname);
////                            employeeMaster.setDateOfJoining(dateOfJoiningNonFormated);
//                                employeeMaster.setDateOfJoining(dateOfJoining);
//                                employeeMaster.setBasicSalary(basicSalary);
////                            employeeMaster.setConveysAmount(conveysAmount);
//                                employeeMaster.setEsicNo(esicNo);
////                            employeeMaster.setTdsAmount(tdsAmount);
//                                employeeMaster.setPaymentType(paymentType);
//                                employeeMaster.setPfNo(pfNo);
//                                employeeMaster.setUanNo(uannNo);
//
//                                if (!employeeType.equals("")) {
//                                    List<?> levelList11 = employeeTypeService.readByName(employeeType.trim());
//                                    if (!levelList11.isEmpty()) {
//                                        employeeType1 = (EmployeeTypeMaster) levelList11.get(0);
//                                        employeeMaster.setEmployeeTypeMaster(employeeType1);
//                                    } else {
//                                        String val = employeeType;
//                                        employeeType1.setTypeOfEmployee(val);
//                                        employeeTypeService.create(employeeType1);
//                                        employeeMaster.setEmployeeTypeMaster(employeeType1);
//
//                                    }
//                                } else {
//                                    employeeMaster.setEmployeeTypeMaster(null);
//                                }
//                                if (!employeeSubtype.equals("")) {
//                                    int emptypid = employeeMaster.getEmployeeTypeMaster().getId();
//
//                                    List<?> levelList2 = employeeSubTypeService.readByEmployeeTypeIdANDSubTypeName(emptypid, employeeSubtype.trim());
//                                    if (!levelList2.isEmpty()) {
//                                        employeeSubType = (EmployeeSubType) levelList2.get(0);
//                                        employeeMaster.setEmployeeSubType(employeeSubType);
//                                    } else {
//                                        employeeSubType.setSubType(employeeSubtype);
//                                        employeeSubType.setEmployeeTypeMaster(employeeType1);
//                                        employeeSubTypeService.create(employeeSubType);
//                                        employeeMaster.setEmployeeSubType(employeeSubType);
//
//                                    }
//                                } else {
//                                    employeeMaster.setEmployeeSubType(null);
//                                }
//                                if (!level.equals("")) {
//                                    List<?> levelList = levelMasterService.readByName(level.trim().toLowerCase());
//                                    if (!levelList.isEmpty()) {
//                                        levelMaster = (LevelMaster) levelList.get(0);
//                                        employeeMaster.setLevelMaster(levelMaster);
//                                    } else {
//                                        levelMaster.setLevel(level);
//                                        levelMasterService.create(levelMaster);
//                                        employeeMaster.setLevelMaster(levelMaster);
//
//                                    }
//                                } else {
//                                    employeeMaster.setLevelMaster(null);
//                                }
//
//                                if (!designation.equals("")) {
//                                    List<?> departmentList = designationMasterService.readByName(designation.trim().toLowerCase());
//                                    if (!departmentList.isEmpty()) {
//                                        designationMaster = (DesignationMaster) departmentList.get(0);
//                                        employeeMaster.setDesignationMaster(designationMaster);
//                                    } else {
//                                        designationMaster.setLevelMaster(levelMaster);
//                                        designationMaster.setDesignationName(designation);
//                                        designationMasterService.create(designationMaster);
//                                        employeeMaster.setDesignationMaster(designationMaster);
//                                    }
//                                } else {
//                                    employeeMaster.setDesignationMaster(null);
//                                }
//
//                                if (!department.equals("")) {
//                                    List<?> departmentList = departmentMasterService.readByName(department.trim().toLowerCase());
//                                    if (!departmentList.isEmpty()) {
//                                        departmentMaster = (DepartmentMaster) departmentList.get(0);
//                                        employeeMaster.setDepartmentMaster(departmentMaster);
//                                    } else {
//                                        departmentMaster.setDepartmentName(department);
//                                        departmentMasterService.create(departmentMaster);
//                                        employeeMaster.setDepartmentMaster(departmentMaster);
//                                    }
//                                } else {
//                                    employeeMaster.setDepartmentMaster(null);
//                                }
////
//                                if (!workLocation.equals("")) {
//                                    List<?> zydexLocationList = zydexLocationMasterService.readByName(workLocation.trim().toLowerCase());
//                                    if (!zydexLocationList.isEmpty()) {
//                                        zydexLocationMaster = (ZydexLocationMaster) zydexLocationList.get(0);
//                                        employeeMaster.setZydexLocationMaster(zydexLocationMaster);
//                                    } else {
//                                        zydexLocationMaster.setZydexLocation(workLocation);
//                                        zydexLocationMasterService.create(zydexLocationMaster);
//                                        employeeMaster.setZydexLocationMaster(zydexLocationMaster);
//                                    }
//                                } else {
//                                    employeeMaster.setZydexLocationMaster(null);
//                                }
//
//                                if (!workLocation.equals("")) {
//                                    List<?> workLocationList = locationMasterService.readByName(workLocation.trim().toLowerCase());
//                                    if (!workLocationList.isEmpty()) {
//                                        locationMaster = (LocationMaster) workLocationList.get(0);
//                                        employeeMaster.setLocationMaster(locationMaster);
//                                    } else {
//                                        locationMaster.setLocation(workLocation);
//                                        locationMasterService.create(locationMaster);
//                                        employeeMaster.setLocationMaster(locationMaster);
//                                    }
//                                } else {
//                                    employeeMaster.setLocationMaster(null);
//                                }
//
//                                employeeMaster.setCompany(company);
////                            employeeMaster.setOfficeEmailId(flyDocsEmailId);
//                                employeeMaster.setContactNo1(contactNo);
//                                employeeMaster.setContactNo2(contactNo2);
//                                employeeMaster.setFatherName(fatherNamed1);
//                                employeeMaster.setMotherName(motherNamed2);
//                                employeeMaster.setDateOfBirth(dobformated);
//                                if (gender.contains("M")) {
//                                    gender1 = false;
//                                } else {
//                                    gender1 = true;
//                                }
//                                employeeMaster.setGender(gender1);
//                                if (maritalStatus.contains("Unmarried")) {
//                                    String marstatus = "UnMarried";
//                                    employeeMaster.setMaritalStatus(marstatus);
//                                } else if (maritalStatus.contains("unmarried")) {
//                                    String marstatus = "UnMarried";
//                                    employeeMaster.setMaritalStatus(marstatus);
//                                } else if (maritalStatus.contains("married")) {
//                                    String marstatus = "Married";
//                                    employeeMaster.setMaritalStatus(marstatus);
//                                } else {
//                                    employeeMaster.setMaritalStatus(maritalStatus);
//                                }
//
//                                employeeMaster.setSpouseName(spouseNamed3);
//                                employeeMaster.setPanCard(pan.toUpperCase());
//                                employeeMaster.setPermanentAddress(permanentAddress1);
//                                employeeMaster.setBloodGroups(bloodGroup);
//                                employeeMaster.setEmailAddress(personalEmailId);
//                                employeeMaster.setEmergencyContactPerson(emergencyContactPerson);
//                                employeeMaster.setEmergencyContactNo(econtactNo);
//                                employeeMaster.setAdharCard(aNo);
//                                employeeMaster.setHighestEducationDetails(highestEducation);
//                                employeeMaster.setExperienceYearOnDoj(employeeeEXPonJoiningYears);
//                                employeeMaster.setExperienceMonthOnDoj(employeeeEXPonJoiningMonths);
//                                employeeMaster.setRole(role);
//                                employeeMaster.setBankName(bankName);
//                                employeeMaster.setBankAccountNo(bNo);
//                                employeeMaster.setBankIfscCode(ifscCode);
//
//                                if (!reportingManager.equals("")) {
//                                    List<?> reportingManagerList = employeeMasterService.readByName(reportingManager);
//                                    EmployeeMaster employeeMaster1 = new EmployeeMaster();
//                                    int reportingManagerLevel1 = 0;
//                                    if (!reportingManagerList.isEmpty()) {
//                                        employeeMaster1 = (EmployeeMaster) reportingManagerList.get(0);
//                                        reportingManagerLevel1 = employeeMaster1.getId();
//                                        employeeMaster.setReportingManagerLevel1("" + reportingManagerLevel1);
//
//                                    }
//                                    List<?> reportingHierarchyList = employeeMasterService.readReportingHierarchyList(employeeMaster1.getId());
//                                    Object[] reportingHierarchyArray;
//                                    if (!reportingHierarchyList.isEmpty()) {
//                                        reportingHierarchyArray = (Object[]) reportingHierarchyList.get(0);
//                                        String reportingHierarchyString = "";
//                                        for (int i = 0; i < reportingHierarchyArray.length; i++) {
//                                            reportingHierarchyString = reportingHierarchyString + ((reportingHierarchyArray[i] == null) ? "" : reportingHierarchyArray[i]) + "~";
//                                        }
//                                        String[] reportingHierarchyStringSplitArray = reportingHierarchyString.split("~");
//                                        //blank whole fields before put new data
//                                        employeeMaster.setReportingManagerLevel2("");
//                                        employeeMaster.setReportingManagerLevel3("");
//                                        employeeMaster.setReportingManagerLevel4("");
//                                        employeeMaster.setReportingManagerLevel5("");
//                                        employeeMaster.setReportingManagerLevel6("");
//                                        if (reportingHierarchyStringSplitArray.length > 0) {
//                                            employeeMaster.setReportingManagerLevel2(reportingHierarchyStringSplitArray[0]);
//                                            employeeMaster.setReportingManagerLevel3(reportingHierarchyStringSplitArray[1]);
//                                            employeeMaster.setReportingManagerLevel4(reportingHierarchyStringSplitArray[2]);
//                                            if (("".equals(reportingHierarchyStringSplitArray[4]) || reportingHierarchyStringSplitArray[4] == null) && ("".equals(reportingHierarchyStringSplitArray[5]) || reportingHierarchyStringSplitArray[5] == null)) {
//                                                if ("".equals(reportingHierarchyStringSplitArray[2]) || reportingHierarchyStringSplitArray[2] == null) {
//                                                    employeeMaster.setReportingManagerLevel6("" + reportingManagerLevel1);
//                                                } else {
//                                                    employeeMaster.setReportingManagerLevel5("" + reportingManagerLevel1);
//                                                    employeeMaster.setReportingManagerLevel6(reportingHierarchyStringSplitArray[2]);
//                                                }
//                                            } else {
//                                                if ("".equals(reportingHierarchyStringSplitArray[4]) || reportingHierarchyStringSplitArray[4] == null) {
//                                                    employeeMaster.setReportingManagerLevel5("" + reportingManagerLevel1);
//                                                } else {
//                                                    employeeMaster.setReportingManagerLevel5(reportingHierarchyStringSplitArray[4]);
//                                                }
//                                                employeeMaster.setReportingManagerLevel6(reportingHierarchyStringSplitArray[5]);
//                                            }
//                                        }
//
//                                    }
//                                }
//                                UserMaster userMaster = new UserMaster();
//                                userMaster.setUserName(employeeNo);
//                                userMaster.setPassword("Admin@123");
//                                String workTypeTemp = "";
//                                String shiftRotationTemp = "";
//                                String shiftTemp = "";
//
//                                if (!userMasterService.isExist(employeeNo)) {
//                                    userMaster.setFirstTime(true);//this is for change password forcibly when user first time logsIn.
//                                    userMasterService.create(userMaster);
//                                    employeeMaster.setUserMaster(userMaster);
//
////                            employeeMaster.setShiftType("");
////                    ***************************************Shift Create Starts Here.*******************************
//                                    if (!workType.equals("")) {
//                                        workTypeTemp = workType.trim().toLowerCase();
//                                        //removes spaces (+ for more than one spaces).
//                                        //set work type is shiftBase or HoursBase in EmployeeMaster.
////                                employeeMaster.setShiftType(workType.trim());
//                                        if (workTypeTemp.contains("shift")) {
//                                            //set work type is shiftBase or HoursBase in EmployeeMaster.
//                                            employeeMaster.setShiftType("ShiftBase");
//                                            //shift rotation and its implementation.
//                                            if (!shiftRotation.equals("")) {
//                                                shiftRotationTemp = shiftRotation.trim().toLowerCase();
//                                                //removes spaces (+ for more than one spaces).
////                                        shiftRotationMaster.setTitle(shiftRotationTemp);
//                                                List<?> shiftRotationMasterList = shiftRotationMasterService.readByShiftRotationName(shiftRotationTemp);
//                                                if (!shiftRotationMasterList.isEmpty()) {
//                                                    shiftRotationMaster = (ShiftRotationMaster) shiftRotationMasterList.get(0);
//                                                    shiftRotationInfo.setShiftRotationMaster(shiftRotationMaster);
//                                                    //get shiftrotation masterdata.....
//                                                } else {
//                                                    shiftRotationMaster.setTitle(shiftRotation.trim());
//                                                    shiftRotationMaster.setDuration("weekly");
//                                                    shiftRotationMaster.setRemark("Generated By Excell Upload.");
//                                                    shiftRotationMasterService.create(shiftRotationMaster);
//                                                    shiftRotationInfo.setShiftRotationMaster(shiftRotationMaster);
//                                                    isShiftRotationCreated = true;//new record inserted in ShiftRotationMaster.
//                                                    //then Enter Records(shiftRotationMasterId,ShiftMasterId) In RotationMaster Table.
//                                                }
//                                                //set shift rotation master data to EmployeeMaster.....
//                                                employeeMaster.setShiftHoursId(shiftRotationMaster.getId());
//                                            } else {
////                                employeeMaster.setshift(workType);
//                                            }
//                                            //shift name and its implementation.
//                                            if (!shiftName.equals("")) {
//                                                shiftTemp = shiftName.trim().toLowerCase();
//                                                //removes spaces (+ for more than one spaces).
////                                        shiftRotationMaster.setTitle(shiftRotationTemp);
//                                                List<?> getByShiftNameList = shiftMasterService.getByShiftName(shiftTemp);
//                                                if (!getByShiftNameList.isEmpty()) {
//                                                    shiftMaster = (ShiftMaster) getByShiftNameList.get(0);
//                                                    shiftRotationInfo.setFirstShiftId(shiftMaster.getId());
//                                                } else {
//                                                    List<?> shiftMasteDefaultList = shiftMasterService.read();
//                                                    if (!shiftMasteDefaultList.isEmpty()) {
//                                                        shiftMasteDefault = (ShiftMaster) shiftMasteDefaultList.get(0);
//                                                        shiftRotationInfo.setFirstShiftId(shiftMasteDefault.getId());
//                                                        isShiftMasterCreated = true;
////                                                //set shift master data to EmployeeMaster.....
////                                                employeeMaster.setShiftHoursId(shiftMasteDefault.getId());
//                                                    }
//                                                }
//                                            } else {
////                                employeeMaster.setshift(workType);
//                                            }
//                                            //enter data in rotation master table if shiftRotationMaster new Created
//                                            if (isShiftRotationCreated) {
//                                                rotationMaster.setShiftRotationMaster(shiftRotationMaster);
//                                                if (isShiftMasterCreated) {
//                                                    rotationMaster.setShiftMaster(shiftMasteDefault);
//                                                    isShiftMasterCreated = false;//reset it again because instance member.
//                                                } else {
//                                                    rotationMaster.setShiftMaster(shiftMaster);
//                                                }
//                                                rotationMasterService.createOrUpdate(rotationMaster);
//                                                isShiftRotationCreated = false;//reset it again because instance member.
//                                            }
////                                            else {
////                                            rotationMaster.setShiftRotationMaster(shiftRotationMaster);
////                                            if (isShiftMasterCreated) {
////                                                rotationMaster.setShiftMaster(shiftMasteDefault);
////                                                isShiftMasterCreated = false;//reset it again because instance member.
////                                            } else {
////                                                rotationMaster.setShiftMaster(shiftMaster);
////                                            }
////                                            List isRotaionExistList = rotationMasterService.isRotationExist(rotationMaster);
////                                            if (isRotaionExistList.isEmpty()) {//if no roatation exist then create one.
////                                            rotationMasterService.createOrUpdate(rotationMaster);
////                                            }
////                                        }
//                                            //setting shift rotation date.
//                                            LocalDate today = LocalDate.now(ZoneId.of("Asia/Kolkata"));
//                                            LocalDate firstOfCurrentMonth = today.with(ChronoField.DAY_OF_MONTH, 1);
//                                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//                                            shiftRotationDate = firstOfCurrentMonth.format(formatter);
//                                            shiftRotationInfo.setRotationDate(shiftRotationDate);
//                                            //set usermaster data for creation in database entry
//                                            shiftRotationInfo.setUserMaster(userMaster);
//                                            //check data for user name is exist or not In shiftRotationInfo.
//                                            List<?> getShiftRotationInfoByUsernameList = shiftRotationInfoService.readRotaionDetail(shiftRotationInfo);
//                                            if (!getShiftRotationInfoByUsernameList.isEmpty()) {
//                                                //update that field
//                                                ShiftRotationInfo shiftRotationInfo2 = new ShiftRotationInfo();
//                                                shiftRotationInfo2 = (ShiftRotationInfo) getShiftRotationInfoByUsernameList.get(0);
//                                                shiftRotationInfo.setId(shiftRotationInfo2.getId());
//                                                shiftRotationInfoService.update(shiftRotationInfo);
//                                            } else {
//                                                //create new entry in shift RotationInfo.
//                                                shiftRotationInfoService.create(shiftRotationInfo);
//                                            }
//                                            //shift Rotation date in employeeMaster if shiftBase workType.
//                                            employeeMaster.setShiftRotationDate(shiftRotationDate);
//                                            //Shift Hours Id (shiftMasterId or HoursBaseId).
////                                    employeeMaster.setShiftHoursId(shiftMaster.getId());
//                                        }
//                                        if (workTypeTemp.contains("hour")) {
//                                            //set work type is shiftBase or HoursBase in EmployeeMaster.
//                                            employeeMaster.setShiftType("HourlyBase");
//                                            //shift name and its implementation.
//                                            if (!hours.equals("")) {
//                                                //removes spaces (+ for more than one spaces).
////                                        shiftRotationMaster.setTitle(shiftRotationTemp);
//                                                List<?> hoursBasisList = hoursBasisService.checkByTitleOfHourBasis(hours.trim().toLowerCase());
//                                                if (!hoursBasisList.isEmpty()) {
//                                                    hoursBasis = (HoursBasis) hoursBasisList.get(0);
//                                                    //set shift master data to EmployeeMaster.....
//                                                    employeeMaster.setShiftHoursId(hoursBasis.getId());
//                                                } else {
//                                                    HoursBasis hoursBasisDefault = new HoursBasis();
//                                                    List<?> hoursBasisDefaultList = hoursBasisService.read();
//                                                    if (!hoursBasisDefaultList.isEmpty()) {
//                                                        hoursBasisDefault = (HoursBasis) hoursBasisDefaultList.get(0);
//                                                        //set shift master data to EmployeeMaster.....
//                                                        employeeMaster.setShiftHoursId(hoursBasisDefault.getId());
//                                                    }
//                                                }
//                                            } else {
////                                employeeMaster.setshift(workType);
//                                            }
//                                        }
//                                    }
////                    ***************************************Shift Create Ends Here.*******************************
//
//                                    employeeMasterService.create(employeeMaster);
//                                    employeeMasterExtension.setEmployeeMaster(employeeMaster);
//                                    employeeMasterServiceExtension.create(employeeMasterExtension);
////                                employeeVisaDetails.setEmployeeMaster(employeeMaster);
////                                employeeVisaDetailsService.create(employeeVisaDetails);
//
//                                    //        Code for Shift generate monthly Schedule(Start)
////                if (employeeMaster.getShiftType().equals("ShiftBase")) {
//                                    if ("ShiftBase".equals(employeeMaster.getShiftType())) {
//                                        ShiftGenerateMonthlySchedule shiftGenerateMonthlySchedule = new ShiftGenerateMonthlySchedule();
//                                        shiftGenerateMonthlySchedule.setEmployeeMaster(employeeMaster);
//                                        //already shiftRotationMaster implemented in above code for shift and co-related data generation.
//                                        //String shfitId = "" + request.getParameter("shiftId");
////                                String shiftRotationDate = "" + request.getParameter("shiftRotationDate");
//                                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//                                        Date rd = sdf.parse(shiftRotationDate);//if shift based then it(shiftRotationDate) canbe get from above shiftbase conditional coda
//                                        LocalDate localDate = rd.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//                                        int year = localDate.getYear();
//                                        String cyear = "" + year;
//                                        int month = localDate.getMonthValue();
//                                        String cmonth = "" + month;
//                                        int dayofmonth = localDate.getDayOfMonth();
//                                        String cdayofmonth = "" + dayofmonth;
////                     shiftGenerateMonthlySchedule.setShiftMonth(cmonth);
////                     shiftGenerateMonthlySchedule.setShiftYear(cyear);
//                                        Calendar c = Calendar.getInstance();
//                                        Date newDate = c.getTime();
//                                        int tday = c.get(Calendar.DATE);
////                                shiftRotationMaster = shiftRotationMasterService.readById(Integer.parseInt(shfitId));
//                                        //already shiftRotationMaster implemented in above code for shift and co-related data generation.
//                                        String duration = "" + shiftRotationMaster.getDuration();
//                                        int day = c.getActualMaximum(Calendar.DAY_OF_MONTH);
//                                        RotationMaster rotationMasterForFirstShiftCheck = new RotationMaster();
//                                        rotationMasterForFirstShiftCheck.setShiftRotationMaster(shiftRotationMaster);
//                                        String shiftMasterId = "";
//                                        if (isShiftMasterCreated) {
//                                            shiftMasterId = "" + shiftMasteDefault.getId();
//                                        } else {
//                                            shiftMasterId = "" + shiftMaster.getId();
//                                        }
//                                        if ("monthly".equals(duration) && day == 30) {
//                                            weeklyGenerate(rotationMasterForFirstShiftCheck, rd, shiftRotationMaster, 30, employeeMaster, shiftMasterId);
//                                        } else if ("weekly".equals(duration)) {
//                                            weeklyGenerateShift(rotationMasterForFirstShiftCheck, rd, shiftRotationMaster, 7, employeeMaster, shiftMasterId);
//                                        } else if ("fortNightly".equals(duration)) {
//                                            weeklyGenerate(rotationMasterForFirstShiftCheck, rd, shiftRotationMaster, 14, employeeMaster, shiftMasterId);
//                                        } else {
//                                            weeklyGenerate(rotationMasterForFirstShiftCheck, rd, shiftRotationMaster, day, employeeMaster, shiftMasterId);
//                                        }
//                                    }
////        Code for Shift generate monthly Schedule(End)
//
////                    ****************************************User Rights Creation Starts*******************************
//                                    UserRightMaster userRightMaster = new UserRightMaster();
//                                    userRightMaster.setEmployee(true);//By default employee right for allows logsIn successfully without Exception.
//                                    userRightMaster.setUserMaster(userMaster);
//                                    userRightMasterService.create(userRightMaster);
////                    ***************************************User Rights Creation End.*******************************
//
////                    ***************************************Leave Balance Create*******************************
//////                            EmployeeLeaveBalance employeeLeaveBalance = new EmployeeLeaveBalance();
//////                            boolean isLeapYear = false;
//////                            LeaveTypeMaster leaveTypeMaster = new LeaveTypeMaster();
//////                            List<?> leaveType = leaveTypeMasterService.read();
//////                            final boolean gender_Female = employeeMaster.getGender();
//////                            for (Object o : leaveType) {
//////                                employeeLeaveBalance = new EmployeeLeaveBalance();
//////                                leaveTypeMaster = (LeaveTypeMaster) o;
//////                                employeeLeaveBalance.setLeaveTypeMaster(leaveTypeMaster);
//////                                employeeLeaveBalance.setEmployeeMaster(employeeMaster);
//////                                String noOfLeave = "" + leaveTypeMaster.getNoOfLeave();
//////                                String leave = "" + leaveTypeMaster.getLeaveType();
//////                                Calendar cal1 = new GregorianCalendar();
//////                                Calendar cal2 = new GregorianCalendar();
//////                                Calendar gc = new GregorianCalendar();
//////                                int year = gc.get(Calendar.YEAR);
//////                                String cyear = "" + year;
//////                                String dateOfEndMonth = "31/12/";
//////                                String dateOfEnd = dateOfEndMonth + cyear;
//////                                if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
//////                                    isLeapYear = true;
//////                                }
//////                                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//////
//////                                Date date1 = sdf.parse(dateOfJoining);
//////                                cal1.setTime(date1);
//////                                Date date2 = sdf.parse(dateOfEnd);
//////                                cal2.setTime(date2);
//////                                int y = Integer.parseInt(noOfLeave);
//////                                long days = date2.getTime() - date1.getTime();
//////                                long diffDays = days / (24 * 60 * 60 * 1000) + 1;
//////                                if (leave.equals("Sick Leave")) {
//////                                    if (isLeapYear == true) {
//////                                        long SL = (diffDays * y / 366) + 1;
//////                                        employeeLeaveBalance.setNoOfLeaveRemain(SL);
//////                                    } else {
//////                                        long SL = (diffDays * y / 365) + 1;
//////                                        employeeLeaveBalance.setNoOfLeaveRemain(SL);
//////                                    }
//////                                } else if (leave.equals("Casual Leave")) {
//////                                    if (isLeapYear == true) {
//////                                        long CL = (diffDays * y / 366) + 1;
//////                                        employeeLeaveBalance.setNoOfLeaveRemain(CL);
//////                                    } else {
//////                                        long CL = (diffDays * y / 365) + 1;
//////                                        employeeLeaveBalance.setNoOfLeaveRemain(CL);
//////                                    }
//////                                } else if (leave.equals("Privilege Leave")) {
//////                                    if (isLeapYear == true) {
//////                                        long PL = (diffDays * y / 366) + 1;
//////                                        employeeLeaveBalance.setNoOfLeaveRemain(PL);
//////                                    } else {
//////                                        long PL = (diffDays * y / 365) + 1;
//////                                        employeeLeaveBalance.setNoOfLeaveRemain(PL);
//////                                    }
//////                                } else if (leave.equals("Paternity Leave") && !gender_Female) {
//////                                    if (isLeapYear == true) {
//////                                        long PAT = (diffDays * y / 366) + 1;
//////                                        employeeLeaveBalance.setNoOfLeaveRemain(PAT);
//////                                    } else {
//////                                        long PAT = (diffDays * y / 365) + 1;
//////                                        employeeLeaveBalance.setNoOfLeaveRemain(PAT);
//////                                    }
//////                                } else if (leave.equals("Maternity Leave")) {
//////                                    if (gender_Female) {
//////                                        long ML = 0;
//////                                        employeeLeaveBalance.setNoOfLeaveRemain(ML);
//////                                    }
//////                                } else if (leave.equals("Short Leave")) {
//////                                    if (isLeapYear == true) {
//////                                        long SHL = (diffDays * y / 366) + 1;
//////                                        employeeLeaveBalance.setNoOfLeaveRemain(SHL);
//////                                    } else {
//////                                        long SHL = (diffDays * y / 365) + 1;
//////                                        employeeLeaveBalance.setNoOfLeaveRemain(SHL);
//////                                    }
//////                                } else if (leave.equals("Leave Without Pay")) {
//////                                    if (isLeapYear == true) {
//////                                        long LWP = (diffDays * y / 366) + 1;
//////                                        employeeLeaveBalance.setNoOfLeaveRemain(LWP);
//////                                    } else {
//////                                        long LWP = (diffDays * y / 365) + 1;
//////                                        employeeLeaveBalance.setNoOfLeaveRemain(LWP);
//////                                    }
//////                                }
//////
//////                                employeeLeaveBalanceService.create(employeeLeaveBalance);
////
////                            }
////                    ***************************************Leave Balance Create*******************************
//// code by yoo.........................from......................
//                                    boolean isLeapYear = false;
//                                    LeaveTypeMaster leaveTypeMaster = new LeaveTypeMaster();
//                                    EmployeeLeaveBalance employeeLeaveBalance = new EmployeeLeaveBalance();
//                                    List<?> leaveType = leaveTypeMasterService.read();
//                                    final boolean gender_Female = employeeMaster.getGender();
//                                    String marital_status = employeeMaster.getMaritalStatus();
//                                    for (Object o : leaveType) {
//                                        employeeLeaveBalance = new EmployeeLeaveBalance();
//                                        leaveTypeMaster = (LeaveTypeMaster) o;
//                                        employeeLeaveBalance.setLeaveTypeMaster(leaveTypeMaster);
//                                        employeeLeaveBalance.setEmployeeMaster(employeeMaster);
//                                        String noOfLeave = "" + leaveTypeMaster.getNoOfLeave();
//                                        String leave = "" + leaveTypeMaster.getLeaveType();
//                                        Calendar cal1 = new GregorianCalendar();
//                                        Calendar cal2 = new GregorianCalendar();
//                                        Calendar gc = new GregorianCalendar();
//                                        int year = gc.get(Calendar.YEAR);
//                                        String cyear = "" + year;
//                                        String dateOfEndMonth = "31/12/";
//                                        String dateOfEnd = dateOfEndMonth + cyear;
//                                        if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
//                                            isLeapYear = true;
//                                        }
//                                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//
////                                    Date date1 = sdf.parse(dateOfJoiningNonFormated);
//                                        SimpleDateFormat sdfDOJ3 = new SimpleDateFormat("dd-MMM-yyyy");
//                                        SimpleDateFormat sdfDOJ4 = new SimpleDateFormat("dd/MM/yyyy");
//
//                                        Date dateDOJ1 = sdfDOJ3.parse(dateOfJoiningNonFormated);
//                                        String dateOfJoining1 = sdfDOJ4.format(dateDOJ1);
//                                        Date date1 = sdf.parse(dateOfJoining1);
//                                        Date date3 = new Date();
//                                        cal1.setTime(date1);
//                                        Date date2 = sdf.parse(dateOfEnd);
//                                        cal2.setTime(date2);
//                                        int y = Integer.parseInt(noOfLeave);
//                                        long days = 0;
//                                        if (date1.before(date3)) {
//                                            days = date2.getTime() - date3.getTime();
//                                        } else {
//                                            days = date2.getTime() - date1.getTime();
//                                        }
//                                        long diffDays = days / (24 * 60 * 60 * 1000) + 1;
//                                        if (leave.equals("Sick Leave")) {
//                                            if (isLeapYear == true) {
//                                                long SL = (diffDays * y / 366) + 1;
//                                                employeeLeaveBalance.setNoOfLeaveRemain(SL);
//                                            } else {
//                                                long SL = (diffDays * y / 365) + 1;
//                                                employeeLeaveBalance.setNoOfLeaveRemain(SL);
//                                            }
//                                        } else if (leave.equals("Casual Leave")) {
//                                            if (isLeapYear == true) {
//                                                long CL = (diffDays * y / 366) + 1;
//                                                employeeLeaveBalance.setNoOfLeaveRemain(CL);
//                                            } else {
//                                                long CL = (diffDays * y / 365) + 1;
//                                                employeeLeaveBalance.setNoOfLeaveRemain(CL);
//                                            }
//                                        } //                else if (leave.equals("Privilege Leave")) {
//                                        //                    if (isLeapYear == true) {
//                                        //                        long PL = (diffDays * y / 366) + 1;
//                                        //                        employeeLeaveBalance.setNoOfLeaveRemain(PL);
//                                        //                    } else {
//                                        //                        long PL = (diffDays * y / 365) + 1;
//                                        //                        employeeLeaveBalance.setNoOfLeaveRemain(PL);
//                                        //                    }
//                                        //                }
//                                        else if (leave.equals("Paternity Leave") && !gender_Female && marital_status.equals("Married")) {
//                                            if (isLeapYear == true) {
////                        long PAT = (diffDays * y / 366) + 1;
//                                                long PAT = 6;
//                                                employeeLeaveBalance.setNoOfLeaveRemain(PAT);
//                                            } else {
//                                                long PAT = 6;
//                                                employeeLeaveBalance.setNoOfLeaveRemain(PAT);
//                                            }
//                                        } else if (leave.equals("Maternity Leave")) {
//                                            if (gender_Female) {
//                                                long ML = 0;
//                                                employeeLeaveBalance.setNoOfLeaveRemain(ML);
//                                            }
//                                        } else if (leave.equals("Short Leave")) {
//                                            if (isLeapYear == true) {
//                                                long SHL = (diffDays * y / 366) + 1;
//                                                employeeLeaveBalance.setNoOfLeaveRemain(SHL);
//                                            } else {
//                                                long SHL = (diffDays * y / 365) + 1;
//                                                employeeLeaveBalance.setNoOfLeaveRemain(SHL);
//                                            }
//                                        } else if (leave.equals("Leave Without Pay")) {
//                                            if (isLeapYear == true) {
//                                                long LWP = (diffDays * y / 366) + 1;
//                                                employeeLeaveBalance.setNoOfLeaveRemain(LWP);
//                                            } else {
//                                                long LWP = (diffDays * y / 365) + 1;
//                                                employeeLeaveBalance.setNoOfLeaveRemain(LWP);
//                                            }
//                                        }
//
//                                        employeeLeaveBalanceService.create(employeeLeaveBalance);
//
//                                    }
//
//                                    // ..............................to......................
//                                } else {
//                                    EmployeeMaster employeeMaster1 = new EmployeeMaster();
//                                    List<?> list1 = employeeMasterService.readEmployeeId(employeeMaster.getEmployeeId());
//                                    employeeMaster1 = (EmployeeMaster) list1.get(0);
//                                    employeeMaster.setId(employeeMaster1.getId());
//                                    UserMaster userMaster1 = new UserMaster();
//                                    userMaster1.setId(employeeMaster1.getUserMaster().getId());
//                                    employeeMaster.setUserMaster(userMaster1);
//                                    employeeMaster.setShiftType(employeeMaster1.getShiftType());
//                                    shiftRotationTemp = shiftRotation.trim().toLowerCase();
//                                    List<?> shiftRotationMasterList = shiftRotationMasterService.readByShiftRotationName(shiftRotationTemp);
//                                    if (!shiftRotationMasterList.isEmpty()) {
//                                        shiftRotationMaster = (ShiftRotationMaster) shiftRotationMasterList.get(0);
//                                        shiftRotationInfo.setShiftRotationMaster(shiftRotationMaster);
//                                    }
//                                    employeeMaster.setShiftHoursId(shiftRotationMaster.getId());
//                                    employeeMasterService.update(employeeMaster);
//                                    List<?> empextlist = employeeMasterServiceExtension.readByemployeeId(employeeMaster.getId());
//                                    EmployeeMasterExtension employeeMasterExtension1 = (EmployeeMasterExtension) empextlist.get(0);
//                                    if (!empextlist.isEmpty()) {
//                                        employeeMasterExtension.setId(employeeMasterExtension1.getId());
//                                        employeeMasterExtension.setEmployeeMaster(employeeMaster);
//                                        employeeMasterServiceExtension.update(employeeMasterExtension);
//                                    }
//                                    List<?> empvisalist = employeeVisaDetailsService.readByemployeeId(employeeMaster.getId());
//                                    EmployeeVisaDetails employeeVisaDetails1 = (EmployeeVisaDetails) empvisalist.get(0);
////                                if (!empvisalist.isEmpty()) {
////                                    employeeVisaDetails.setId(employeeVisaDetails1.getId());
////                                    employeeVisaDetails.setEmployeeMaster(employeeMaster);
////                                    employeeVisaDetailsService.update(employeeVisaDetails);
////                                }
//                                    stringBuffer.append(employeeNo);
//                                    stringBuffer.append(" , ");
//                                    counter++;
//                                }
//
//                            }
//                        }
////                        System.out.println("this is an error in excel upload......................................................................" + employeeNo);
////                        System.out.println("this is an error in excel upload......................................................................" + employeeNo);
//
//                    } catch (Exception e) {
//                        stringBufferOfExceptions.append(employeeNo);
//                        stringBufferOfExceptions.append(" , ");
//                        counterOfException++;
//                    }
//                }
//            }
//            if ((counter == 0) && (counterOfException == 0)) {
//                request.setAttribute("successMessage", "Information : The Excel Uploaded Successfully.");
//            }
//
//            //if user already exist then this failure messge will be printed.
//            if (counter > 0) {
//                request.setAttribute("failureMessage", "Information : " + stringBuffer + " Records not inserted because the user is already existed");
//            }
//            if (counterOfException > 0) {
//                request.setAttribute("failureMessage", " " + stringBufferOfExceptions + " Records not inserted due to invalid data");
//                System.out.println("failureMessage," + stringBufferOfExceptions + " Records not inserted due to invalid data");
//            }
//            mv = searchSubmit(request, response);
//        } catch (Exception e) {
//            request.setAttribute("failureMessage", "Information : The Excel Not Upload Successfully. Please Check Excel Data.");
//            mv = excelUploadRegistration(request, response);
//        }
//        return mv;
//    }

    public void getDesignationByLevel(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int levelMasterId = Integer.valueOf(request.getParameter("levelMasterId"));
        Map<Integer, String> desigNationByLevelMap = new HashMap<Integer, String>();
        List designationsAtLevelList = designationMasterService.readDesignationsOfLevel(levelMasterId);
        DesignationMaster designationMaster = new DesignationMaster();
        for (Object o : designationsAtLevelList) {
            designationMaster = (DesignationMaster) o;
            desigNationByLevelMap.put(designationMaster.getId(), designationMaster.getDesignationName());
        }
        String jsonOfdesigNationByLevelMap = new Gson().toJson(desigNationByLevelMap);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.write(jsonOfdesigNationByLevelMap);

        } finally {
            out.close();
        }
    }

    public void exportToExcel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        EmployeeTypeMaster employeeTypeMaster = new EmployeeTypeMaster();
        EmployeeSubType employeeSubType = new EmployeeSubType();
        DesignationMaster designationMaster = new DesignationMaster();
        LevelMaster levelMaster = new LevelMaster();
        ZydexLocationMaster zydexLocationMaster = new ZydexLocationMaster();
        ShiftRotationInfo shiftRotationInfo = new ShiftRotationInfo();
        String searchEmployeeString = "";
        String searchString = request.getParameter("searchString");
        searchEmployeeString = (searchString == null || searchString == "") ? searchEmployeeString : (searchEmployeeString + searchString);
        String[] columns = {"Sr No", "Employee ID", "Employee Name", "Date of Joining", "Gender", "Date Of Birth", "Department", "Division", "Designation", "Employee Type", "Line Manager", "Level", "Work Location", "Role", "First Name", "Middle Name", "Last Name", "Nationality", "Local Address1", "Local Address2", "City/Town", "State", "Post Code", "Country", "Permanent Address1", "Permanent Address2", "City/Town", "State", "Post Code", "Country", "Resident Contact", "Mobile No", "Official Email Address", "Personal Email Address", "Bank A/c No", "Bank Name", "IFSC Code", "PF withdrawal Date", "PF No (Previous)", "PF No.(VNC)", "PAN Card", "Aadhar Card", "ESI No", "UAN", "Marital Status", "Blood Group", "Disclosed Health Concerns", "Driving Licence No", "2 wheeler / 4 wheeler / Both", "Dependent 1 Name", "Dependent 1 DOB", "Dependent 2 Name", "Dependent 2 DOB", "Dependent 3 Name", "Dependent 3 Gender", "Dependent 3 DOB", "Dependent 4 Name", "Dependent 4 Gender", "Dependent 4 DOB", "Dependent 5 Name", "Dependent 5 Gender", "Dependent 5 DOB", "Emergency Contact Name", "Relationship", "Contact Number", "Emergency Contact Address", "Other important information relating to your emergency contact", "Name of Previous company", "Company Location", "Employees Exp. on date of Joining FIPL (Year)", "Employees Exp. on date of Joining FIPL (Month)", "Highest Education Details", "Language known", "Hobbies", "Work Type", "Payment Type", "Basic Salary", "Company", "Business Unit"};

        Workbook workbook = new XSSFWorkbook();

        CreationHelper createHelper = workbook.getCreationHelper();
        Sheet sheet = workbook.createSheet("EmployeeData");
        Font headerFont = workbook.createFont();
        headerFont.setBoldweight((short) 5);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.BLACK.getIndex());

        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        Row headerRow = sheet.createRow(0);

        for (int i = 0; i < columns.length; i++) {
            org.apache.poi.ss.usermodel.Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }

        CellStyle dateCellStyle = workbook.createCellStyle();
        dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));

        int rowNum = 1;
        List<?> employeeMasterList = employeeMasterService.readEmployeeDataForexportToExcelFlyDoc(searchEmployeeString);
        int count = 0;
        for (Object empDataObject : employeeMasterList) {
            EmployeeMaster employeeMaster1 = (EmployeeMaster) empDataObject;
            Row row = sheet.createRow(rowNum++);
            count++;
            row.createCell(0).setCellValue(count);
            row.createCell(1).setCellValue(employeeMaster1.getEmployeeId());
            row.createCell(2).setCellValue(employeeMaster1.getEmployeeName());
            org.apache.poi.ss.usermodel.Cell dateOfjoining = row.createCell(3);
            dateOfjoining.setCellValue(employeeMaster1.getDateOfJoining());
            dateOfjoining.setCellStyle(dateCellStyle);
            Boolean gen = employeeMaster1.getGender();
            String gender;
            if (gen == false) {
                gender = "Male";
            } else if (gen == true) {
                gender = "Female";
            } else {
                gender = "";
            }
            row.createCell(4).setCellValue(gender);
            org.apache.poi.ss.usermodel.Cell dateOfbirth = row.createCell(5);
            dateOfbirth.setCellValue(employeeMaster1.getDateOfBirth());
            dateOfbirth.setCellStyle(dateCellStyle);
            int emptypid = employeeMaster1.getEmployeeTypeMaster().getId();
            List<?> employeeTypeMasterList = employeeTypeService.readByID(emptypid);
            employeeTypeMaster = (EmployeeTypeMaster) employeeTypeMasterList.get(0);
            String employeetypename = employeeTypeMaster.getTypeOfEmployee();
            row.createCell(6).setCellValue(employeetypename);
            int empsubtypid = employeeMaster1.getEmployeeSubType().getId();
            List<?> employeeSubTypeMasterList = employeeSubTypeService.readByID(empsubtypid);
            employeeSubType = (EmployeeSubType) employeeSubTypeMasterList.get(0);
            String employeesubtypename = employeeSubType.getSubType();
            row.createCell(7).setCellValue(employeesubtypename);
            int empdesig = employeeMaster1.getDesignationMaster().getId();
            List<?> employeedesigList = designationMasterService.readByID(empdesig);
            designationMaster = (DesignationMaster) employeedesigList.get(0);
            String designationname = designationMaster.getDesignationName();
            row.createCell(8).setCellValue(designationname);
            row.createCell(9).setCellValue(employeeMaster1.getEmployeeType());
            String repId = employeeMaster1.getReportingManagerLevel1();
            if (!repId.isEmpty()) {
                EmployeeMaster employeerepMaster = new EmployeeMaster();
                employeerepMaster = employeeMasterService.readById(Integer.parseInt(repId));
                row.createCell(10).setCellValue(employeerepMaster.getEmployeeName());
            } else {
                row.createCell(10).setCellValue(" ");
            }
            int emplevel = employeeMaster1.getLevelMaster().getId();
            List<?> employeelevelList = levelMasterService.readByID(emplevel);
            levelMaster = (LevelMaster) employeelevelList.get(0);
            String levelMastername = levelMaster.getLevel();
            row.createCell(11).setCellValue(levelMastername);
            int empzyxlocation = employeeMaster1.getZydexLocationMaster().getId();
            List<?> employeezydxlocationList = zydexLocationMasterService.readByID(empzyxlocation);
            zydexLocationMaster = (ZydexLocationMaster) employeezydxlocationList.get(0);
            String zydxlocationname = zydexLocationMaster.getZydexLocation();
            row.createCell(12).setCellValue(zydxlocationname);
            row.createCell(13).setCellValue(employeeMaster1.getRole());
            row.createCell(18).setCellValue(employeeMaster1.getPresentAddress());
            row.createCell(24).setCellValue(employeeMaster1.getPermanentAddress());
            row.createCell(30).setCellValue(employeeMaster1.getContactNo1());
            row.createCell(31).setCellValue(employeeMaster1.getContactNo2());
            row.createCell(32).setCellValue(employeeMaster1.getOfficeEmailId());
            row.createCell(33).setCellValue(employeeMaster1.getEmailAddress());
            row.createCell(34).setCellValue(employeeMaster1.getBankAccountNo());
            row.createCell(35).setCellValue(employeeMaster1.getBankName());
            row.createCell(36).setCellValue(employeeMaster1.getBankIfscCode());
            row.createCell(38).setCellValue(employeeMaster1.getPfNo());
            row.createCell(40).setCellValue(employeeMaster1.getPanCard());
            row.createCell(41).setCellValue(employeeMaster1.getAdharCard());
            row.createCell(42).setCellValue(employeeMaster1.getEsicNo());
            row.createCell(43).setCellValue(employeeMaster1.getUanNo());
            row.createCell(44).setCellValue(employeeMaster1.getMaritalStatus());
            row.createCell(45).setCellValue(employeeMaster1.getBloodGroups());
            row.createCell(47).setCellValue(employeeMaster1.getDrivingLicence());
            row.createCell(49).setCellValue(employeeMaster1.getFatherName());
            org.apache.poi.ss.usermodel.Cell dateOfbirthfather = row.createCell(50);
            dateOfbirthfather.setCellValue(employeeMaster1.getDateOfBirthOfEmpFather());
            dateOfbirthfather.setCellStyle(dateCellStyle);
            row.createCell(51).setCellValue(employeeMaster1.getMotherName());
            org.apache.poi.ss.usermodel.Cell dateOfbirthmother = row.createCell(52);
            dateOfbirthmother.setCellValue(employeeMaster1.getDateOfBirthOfEmpMother());
            dateOfbirthmother.setCellStyle(dateCellStyle);
            row.createCell(53).setCellValue(employeeMaster1.getSpouseName());
            org.apache.poi.ss.usermodel.Cell dateOfbirthspous = row.createCell(55);
            dateOfbirthspous.setCellValue(employeeMaster1.getDateOfBirthOfEmpSpous());
            dateOfbirthspous.setCellStyle(dateCellStyle);
            row.createCell(56).setCellValue(employeeMaster1.getChild1());
            org.apache.poi.ss.usermodel.Cell dateOfbirthchild1 = row.createCell(58);
            dateOfbirthchild1.setCellValue(employeeMaster1.getDateOfBirthOfEmpChilld1());
            dateOfbirthchild1.setCellStyle(dateCellStyle);
            row.createCell(59).setCellValue(employeeMaster1.getChild2());
            org.apache.poi.ss.usermodel.Cell dateOfbirthchild2 = row.createCell(61);
            dateOfbirthchild2.setCellValue(employeeMaster1.getDateOfBirthOfEmpChild2());
            dateOfbirthchild2.setCellStyle(dateCellStyle);
            row.createCell(62).setCellValue(employeeMaster1.getEmergencyContactPerson());
            row.createCell(64).setCellValue(employeeMaster1.getEmergencyContactNo());
            row.createCell(69).setCellValue(employeeMaster1.getExperienceYearOnDoj());
            row.createCell(70).setCellValue(employeeMaster1.getExperienceMonthOnDoj());
            row.createCell(71).setCellValue(employeeMaster1.getHighestEducationDetails());
            row.createCell(74).setCellValue(employeeMaster1.getShiftType());
            row.createCell(75).setCellValue(employeeMaster1.getPaymentType());
            row.createCell(76).setCellValue(employeeMaster1.getBasicSalary());
            row.createCell(77).setCellValue(employeeMaster1.getCompany());
            int empdept = employeeMaster1.getDepartmentMaster().getId();
            DepartmentMaster departmentMaster = (DepartmentMaster) departmentMasterService.readById(empdept);
            String departmentMastername = departmentMaster.getDepartmentName();
            row.createCell(78).setCellValue(departmentMastername);

            List<?> employeeMasterextensionList = employeeMasterServiceExtension.readByemployeeId(employeeMaster1.getId());
            for (Object empextDataObject : employeeMasterextensionList) {
                EmployeeMasterExtension employeeMasterext1 = (EmployeeMasterExtension) empextDataObject;

                row.createCell(14).setCellValue(employeeMasterext1.getFirstName());
                row.createCell(15).setCellValue(employeeMasterext1.getMiddleName());
                row.createCell(16).setCellValue(employeeMasterext1.getLastName());
                row.createCell(17).setCellValue(employeeMasterext1.getNationality());
                row.createCell(19).setCellValue(employeeMasterext1.getPresentAddress2());
                row.createCell(20).setCellValue(employeeMasterext1.getPresentCity());
                row.createCell(21).setCellValue(employeeMasterext1.getPresentState());
                row.createCell(22).setCellValue(employeeMasterext1.getPresentPostalCode());
                row.createCell(23).setCellValue(employeeMasterext1.getPresentCountry());
                row.createCell(25).setCellValue(employeeMasterext1.getPermanentAddress2());
                row.createCell(26).setCellValue(employeeMasterext1.getPermanentCity());
                row.createCell(27).setCellValue(employeeMasterext1.getPermanentState());
                row.createCell(28).setCellValue(employeeMasterext1.getPermanentPostalCode());
                row.createCell(29).setCellValue(employeeMasterext1.getPermanentCountry());
                row.createCell(37).setCellValue(employeeMasterext1.getWithdrawalDate());
                row.createCell(39).setCellValue(employeeMasterext1.getPfNoFlydocs());
                row.createCell(46).setCellValue(employeeMasterext1.getDisclosedHealthConcerns());
                row.createCell(48).setCellValue(employeeMasterext1.getDrivingLicenceType());
                Boolean sgen = employeeMasterext1.getSpouseGender();
                if (sgen != null) {
                    String spousgen = "";
                    if (sgen == false) {
                        spousgen = "Male";
                    } else if (sgen == true) {
                        spousgen = "Female";
                    } else if (sgen == null) {
                        spousgen = "N/A";
                    }
                    row.createCell(54).setCellValue(spousgen);
                } else {
                    row.createCell(54).setCellValue("N/A");
                }

                Boolean cgen = employeeMasterext1.getChildOneGender();
                if (cgen != null) {
                    String chilgen = "";
                    if (cgen == false) {
                        chilgen = "Male";
                    } else if (cgen == true) {
                        chilgen = "Female";
                    } else if (cgen == null) {
                        chilgen = "N/A";
                    }
                    row.createCell(57).setCellValue(chilgen);
                } else {
                    row.createCell(57).setCellValue("N/A");
                }

                Boolean c2gen = employeeMasterext1.getChildTwoGender();
                if (c2gen != null) {
                    String chil2gen = "";
                    if (c2gen == false) {
                        chil2gen = "Male";
                    } else if (c2gen == true) {
                        chil2gen = "Female";
                    } else if (c2gen == null) {
                        chil2gen = "N/A";
                    }
                    row.createCell(60).setCellValue(chil2gen);
                } else {
                    row.createCell(60).setCellValue("N/A");
                }

                row.createCell(63).setCellValue(employeeMasterext1.getRelationShip());
                row.createCell(65).setCellValue(employeeMasterext1.getEmergencyContactAddress());
                row.createCell(66).setCellValue(employeeMasterext1.getOtherImpInfo());
                row.createCell(67).setCellValue(employeeMasterext1.getNameOfPreviousCompany());
                row.createCell(68).setCellValue(employeeMasterext1.getPreviousCompanyLocation());
                row.createCell(72).setCellValue(employeeMasterext1.getLanguagesKnown());
                row.createCell(73).setCellValue(employeeMasterext1.getHobbies());

            }

//            int preid = 0;
//            List<?> employeeMastervisaList = employeeVisaDetailsService.readByemployeeId(employeeMaster1.getId());
//            for (Object empvisaDataObject : employeeMastervisaList) {
//                EmployeeVisaDetails employeeVisaDetails = (EmployeeVisaDetails) empvisaDataObject;
//                int newid = employeeVisaDetails.getEmployeeMaster().getId();
//                if (preid != newid) {
//                    preid = newid;
//                    row.createCell(23).setCellValue(employeeVisaDetails.getVisaIssueCountry());
//                    row.createCell(24).setCellValue(employeeVisaDetails.getVisaIssueDate());
//                    row.createCell(25).setCellValue(employeeVisaDetails.getVisaValidTillDate());
//                } 
//            }
        }

        for (int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            workbook.write(bos);
        } finally {
            bos.close();
        }
        String fileName = "EmployeeData.xlsx";
        String contentType = null;

        if (fileName.endsWith("xlsx")) {
            contentType = "application/octet-stream";
        } else if (fileName.endsWith("pdf")) {
            contentType = "application/pdf";
        } else {
            throw new RuntimeException("File type not found");
        }

        byte[] file = bos.toByteArray();

        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        response.setHeader("charset", "iso-8859-1");
        response.setContentType(contentType);
        response.setContentLength(file.length);
        response.setStatus(HttpServletResponse.SC_OK);
        OutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            outputStream.write(file, 0, file.length);
            outputStream.flush();
            outputStream.close();
            response.flushBuffer();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ModelAndView exportToExcel1(HttpServletRequest request, HttpServletResponse response, EmployeeMaster employeeMaster) throws Exception {
        ModelAndView mv = new ModelAndView();
        String searchEmployeeString = "";
        String searchString = request.getParameter("searchString");
        searchEmployeeString = (searchString == null || searchString == "") ? searchEmployeeString : (searchEmployeeString + searchString);
        List allList = new ArrayList();
        List<?> employeeMasterList = employeeMasterService.readEmployeeDataForexportToExcelFlyDoc(searchEmployeeString);
        EmployeeTypeMaster employeeTypeMaster = new EmployeeTypeMaster();
        EmployeeSubType employeeSubType = new EmployeeSubType();
        DesignationMaster designationMaster = new DesignationMaster();
        LevelMaster levelMaster = new LevelMaster();
        ZydexLocationMaster zydexLocationMaster = new ZydexLocationMaster();
//            LocationMaster locationMaster = new LocationMaster();
//            DepartmentMaster departmentMaster = new DepartmentMaster();
        ShiftRotationInfo shiftRotationInfo = new ShiftRotationInfo();

        for (Object empDataObject : employeeMasterList) {
            List empList = new ArrayList();
            EmployeeMaster employeeMaster1 = (EmployeeMaster) empDataObject;
            empList.add(employeeMaster1.getEmployeeId());
            empList.add(employeeMaster1.getEmployeeName());
            empList.add(employeeMaster1.getDateOfJoining());
            empList.add(employeeMaster1.getGender());
            empList.add(employeeMaster1.getDateOfBirth());
            int emptypid = employeeMaster1.getEmployeeTypeMaster().getId();
            List<?> employeeTypeMasterList = employeeTypeService.readByID(emptypid);
            employeeTypeMaster = (EmployeeTypeMaster) employeeTypeMasterList.get(0);
            String employeetypename = employeeTypeMaster.getTypeOfEmployee();
            empList.add(employeetypename);
            int empsubtypid = employeeMaster1.getEmployeeSubType().getId();
            List<?> employeeSubTypeMasterList = employeeSubTypeService.readByID(empsubtypid);
            employeeSubType = (EmployeeSubType) employeeSubTypeMasterList.get(0);
            String employeesubtypename = employeeSubType.getSubType();
            empList.add(employeesubtypename);
            int empdesig = employeeMaster1.getDesignationMaster().getId();
            List<?> employeedesigList = designationMasterService.readByID(empdesig);
            designationMaster = (DesignationMaster) employeedesigList.get(0);
            String designationname = designationMaster.getDesignationName();
            empList.add(designationname);
            empList.add(employeeMaster1.getEmployeeType());
            String repId = employeeMaster1.getReportingManagerLevel1();
            if (!repId.isEmpty()) {
                EmployeeMaster employeerepMaster = new EmployeeMaster();
                employeerepMaster = employeeMasterService.readById(Integer.parseInt(repId));
                empList.add(employeerepMaster.getEmployeeName());//9//
            } else {
                empList.add(" ");//9//
            }

            int emplevel = employeeMaster1.getLevelMaster().getId();
            List<?> employeelevelList = levelMasterService.readByID(emplevel);
            levelMaster = (LevelMaster) employeelevelList.get(0);
            String levelMastername = levelMaster.getLevel();
            empList.add(levelMastername);
            int empzyxlocation = employeeMaster1.getZydexLocationMaster().getId();
            List<?> employeezydxlocationList = zydexLocationMasterService.readByID(empzyxlocation);
            zydexLocationMaster = (ZydexLocationMaster) employeezydxlocationList.get(0);
            String zydxlocationname = zydexLocationMaster.getZydexLocation();
            empList.add(zydxlocationname);
            empList.add(employeeMaster1.getRole());//12//

//            empList.add(employeeMaster1.getPassportNo());//13//
//            empList.add(employeeMaster1.getPassportIssueDate());
//            empList.add(employeeMaster1.getPassportExpiryDate());//15//
            empList.add(employeeMaster1.getPresentAddress());

            empList.add(employeeMaster1.getPermanentAddress());

            empList.add(employeeMaster1.getContactNo1());
            empList.add(employeeMaster1.getContactNo2());
            empList.add(employeeMaster1.getOfficeEmailId());
            empList.add(employeeMaster1.getEmailAddress());
            empList.add(employeeMaster1.getBankAccountNo());
            empList.add(employeeMaster1.getBankName());
            empList.add(employeeMaster1.getBankIfscCode());

            empList.add(employeeMaster1.getPfNo());//25//

            empList.add(employeeMaster1.getPanCard());
            empList.add(employeeMaster1.getAdharCard());
            empList.add(employeeMaster1.getEsicNo());
            empList.add(employeeMaster1.getUanNo());
            empList.add(employeeMaster1.getMaritalStatus());

            empList.add(employeeMaster1.getBloodGroups());

            empList.add(employeeMaster1.getDrivingLicence());

            empList.add(employeeMaster1.getFatherName());
            empList.add(employeeMaster1.getDateOfBirthOfEmpFather());
            empList.add(employeeMaster1.getMotherName());
            empList.add(employeeMaster1.getDateOfBirthOfEmpMother());
            empList.add(employeeMaster1.getSpouseName());
            empList.add(employeeMaster1.getDateOfBirthOfEmpSpous());
            empList.add(employeeMaster1.getChild1());//39//

            empList.add(employeeMaster1.getDateOfBirthOfEmpChilld1());
            empList.add(employeeMaster1.getChild2());

            empList.add(employeeMaster1.getDateOfBirthOfEmpChild2());

            empList.add(employeeMaster1.getEmergencyContactPerson());

            empList.add(employeeMaster1.getEmergencyContactNo());

            empList.add(employeeMaster1.getExperienceYearOnDoj());
            empList.add(employeeMaster1.getExperienceMonthOnDoj());
            empList.add(employeeMaster1.getHighestEducationDetails());

            empList.add(employeeMaster1.getShiftType());
//                if(employeeMaster1.getShiftType().contains("ShiftBase")){
//                    int usermasterid = employeeMaster1.getUserMaster().getId();
//                    List<?> shiftRotationInfolist  = shiftRotationInfoService.readByUserId(usermasterid);
//                    shiftRotationInfo = (ShiftRotationInfo) shiftRotationInfolist.get(0);
//                    int shiftinfomasterid = shiftRotationInfo.getShiftRotationMaster().getId();
//                        ShiftRotationMaster shiftRotationMaster = (ShiftRotationMaster) shiftRotationMasterService.readById(shiftinfomasterid);
//                        String ShiftRotationMastertitle = shiftRotationMaster.getTitle();
//                    empList.add(ShiftRotationMastertitle);
//                    int firstshiftuserid = shiftRotationInfo.getFirstShiftId();
//                    ShiftMaster shiftMaster = (ShiftMaster) shiftMasterService.readById(firstshiftuserid);
//                        String shiftMastertitle = shiftMaster.getShiftName();
//                    empList.add(shiftMastertitle);
//                }else{
//                    int hourid = employeeMaster1.getShiftHoursId();
//                        HoursBasis hoursBasis = (HoursBasis) hoursBasisService.readById(hourid);
//                        String hourbasetitle = hoursBasis.getTitle();
//                    empList.add(hourbasetitle);
//                }
//                empList.add(employeeMaster1.getShiftHoursId());
//                
//                empList.add(employeeMaster1.getShiftRotationDate());
            empList.add(employeeMaster1.getPaymentType());
            empList.add(employeeMaster1.getBasicSalary());

            int comlocation = employeeMaster1.getLocationMaster().getId();
            LocationMaster locationMaster = (LocationMaster) locationMasterService.readById(comlocation);
            String locationMastername = locationMaster.getLocation();
            empList.add(locationMastername);
            int empdept = employeeMaster1.getDepartmentMaster().getId();
            DepartmentMaster departmentMaster = (DepartmentMaster) departmentMasterService.readById(empdept);
            String departmentMastername = departmentMaster.getDepartmentName();
            empList.add(departmentMastername);//52//

            List<?> employeeMasterextensionList = employeeMasterServiceExtension.readByemployeeId(employeeMaster1.getId());
            for (Object empextDataObject : employeeMasterextensionList) {
                EmployeeMasterExtension employeeMasterext1 = (EmployeeMasterExtension) empextDataObject;
                empList.add(employeeMasterext1.getFirstName());//53//
                empList.add(employeeMasterext1.getMiddleName());
                empList.add(employeeMasterext1.getLastName());

                empList.add(employeeMasterext1.getNationality());//19//
//                empList.add(employeeMasterext1.getCountryOfIssue());

                empList.add(employeeMasterext1.getPresentAddress2());
                empList.add(employeeMasterext1.getPresentCity());
                empList.add(employeeMasterext1.getPresentState());
                empList.add(employeeMasterext1.getPresentPostalCode());
                empList.add(employeeMasterext1.getPresentCountry());

                empList.add(employeeMasterext1.getPermanentAddress2());
                empList.add(employeeMasterext1.getPermanentCity());
                empList.add(employeeMasterext1.getPermanentState());
                empList.add(employeeMasterext1.getPermanentPostalCode());
                empList.add(employeeMasterext1.getPermanentCountry());

                empList.add(employeeMasterext1.getWithdrawalDate());

                empList.add(employeeMasterext1.getPfNoFlydocs());
//                empList.add(employeeMasterext1.getElectionCard());

//                empList.add(employeeMasterext1.getReligion());
                empList.add(employeeMasterext1.getDisclosedHealthConcerns());

                empList.add(employeeMasterext1.getDrivingLicenceType());

                empList.add(employeeMasterext1.getChildOneGender());

                empList.add(employeeMasterext1.getChildTwoGender());

                empList.add(employeeMasterext1.getRelationShip());

                empList.add(employeeMasterext1.getEmergencyContactAddress());
                empList.add(employeeMasterext1.getOtherImpInfo());
                empList.add(employeeMasterext1.getNameOfPreviousCompany());
                empList.add(employeeMasterext1.getPreviousCompanyLocation());

                empList.add(employeeMasterext1.getHobbies());
                empList.add(employeeMasterext1.getLanguagesKnown());//82//
//                empList.add(employeeMasterext1.getNameStatus());//83//
                empList.add(employeeMasterext1.getSpouseGender());//84//

            }
            int preid = 0;
            List<?> employeeMastervisaList = employeeVisaDetailsService.readByemployeeId(employeeMaster1.getId());

            for (Object empvisaDataObject : employeeMastervisaList) {
                EmployeeVisaDetails employeeVisaDetails = (EmployeeVisaDetails) empvisaDataObject;
                int newid = employeeVisaDetails.getEmployeeMaster().getId();
                if (preid != newid) {
                    preid = newid;
                    empList.add(employeeVisaDetails.getVisaIssueCountry());
                    empList.add(employeeVisaDetails.getVisaIssueDate());
                    empList.add(employeeVisaDetails.getVisaValidTillDate());
                }
            }

            allList.add(empList);
        }
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=EmployeeDataSheet.xls");
        request.setAttribute("employeeMasterList", allList);
        mv.addObject("employeeMasterList1", employeeMasterList);
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.setViewName("DocumentView/EmployeeDataToExcel");
        return mv;
    }

    public ModelAndView changePassWordClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        UserMaster userMaster = new UserMaster();
//        bind(request, userMaster);
//        EmployeeMaster employeeMaster = new EmployeeMaster();
        String id = "" + request.getParameter("userid");
        userMaster.setId(Integer.parseInt(id));
        mv.getModelMap().put("userMaster", userMaster);
        mv.setViewName("User/NewPassword");
        return mv;
    }

    public ModelAndView changePassWordSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        UserMaster userMaster = new UserMaster();
        BindException errors = new BindException(userMaster, "UserMaster");
        bind(request, userMaster);
        EmployeeMaster employeeMaster = new EmployeeMaster();
        PasswordValidator passwordValidator = new PasswordValidator();
        userMaster.getId();
        String curPas = "";
        String newPas = request.getParameter("new_password");
        curPas = userMaster.getPassword();
        userMaster = userMasterService.readById(userMaster.getId());

        List list = employeeMasterService.pswdExist(curPas, userMaster.getId().toString());
        if (!list.isEmpty()) {
            userMaster.setPassword(newPas);
            userMasterService.createOrUpdate(userMaster);
            request.setAttribute("successmessage", "Password Changed Successfully");
            mv.getModelMap().put("userMaster", userMaster);
            mv.setViewName("User/NewPassword");
            mv = userDashboard(request, response);
        } else {
            request.setAttribute("failuremessage", "Password Does Not Exist ");
            mv.getModelMap().put("userMaster", userMaster);
            mv.setViewName("User/NewPassword");
//            mv = changePassWordClick(request, response);
        }

        return mv;
    }

    private void weeklyGenerateShift(RotationMaster rotationMaster, Date rd, ShiftRotationMaster shiftRotationMaster, int days, EmployeeMaster employeeMaster, String shiftMasterId) throws Exception {
        ShiftMaster shiftMaster = new ShiftMaster();
        ShiftMaster shiftMasterForLastDayOfMonth = new ShiftMaster();

        ShiftGenerateMonthlySchedule shiftGenerateMonthlySchedule = new ShiftGenerateMonthlySchedule();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = Calendar.getInstance();
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c.setTime(rd);
        int day = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        List<Integer> rotationArray = new ArrayList<Integer>(day);

        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        LocalDate localDate = rd.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int year = localDate.getYear();
        int month = localDate.getMonthValue();
        int dayofmonth = localDate.getDayOfMonth();

        Date today = new Date();
        String newDate = sdf.format(today);
        Date ss = sdf.parse(newDate);
        c2.setTime(ss);
        int currentMonth = (c.get(Calendar.MONTH)) + 1;
        int daysOfCuurentMOnth = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        int currentYear = c.get(Calendar.YEAR);

//
        String cdayofmonth = "" + dayofmonth;
        String cmonth = "" + month;
        String cyear = "" + year;
        int currentDay = Integer.parseInt(cdayofmonth);
//        for (int i1 = 1; i1 < currentDay; i1++) {
//            rotationArray.add(0);
//        }
//        List sunday = new ArrayList();
//        for (int day1 = 1; day1 <= day; day1++) {
//            c1.set(year, month - 1, day1);
//            int dayOfWeek1 = c1.get(Calendar.DAY_OF_WEEK);
//            if (dayOfWeek1 == Calendar.SUNDAY) {
//                sunday.add(day1);
//            }
//        }
        int flag1 = 0;
        int count = dayOfWeek;
        int noOfDay = 0;
        int i = 1;
        int shiftMasterIdCheckCounter = 0;
        int shiftMasterIdCheckTemp = 0;
        int lastDayOfCurrentMonth = daysOfCuurentMOnth;
        boolean isLastDayOfMonthIsWeekOff = false;
        List<?> rotationList = rotationMasterService.readFromRotation(rotationMaster);
        List<Integer> shiftMasterIdList = new ArrayList<Integer>();
        if (!rotationList.isEmpty()) {
            for (Object rotationMasterObject : rotationList) {
                rotationMaster = (RotationMaster) rotationMasterObject;
                shiftMasterIdList.add(rotationMaster.getShiftMaster().getId());
                if ((rotationMaster.getShiftMaster().getId().toString()).equals(shiftMasterId)) {
                    shiftMasterIdCheckCounter = shiftMasterIdCheckTemp;
                }
                shiftMasterIdCheckTemp++;
            }

            for (i = 1; i <= daysOfCuurentMOnth; i++) {
                shiftMaster = shiftMasterService.readById(shiftMasterIdList.get(shiftMasterIdCheckCounter));
                try {
                    if (rotationArray.size() != daysOfCuurentMOnth) {

                        Calendar cal = Calendar.getInstance();
                        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
                        String newdate = i + "/" + currentMonth + "/" + currentYear;
                        Date ddd = sdf1.parse(newdate);
                        cal.setTime(ddd);
                        String weekOff11 = shiftMaster.getWeekof();
                        ArrayList<Integer> daylist = new ArrayList<Integer>();
                        for (String z : weekOff11.split(",")) {
                            int weekOff = 0;
                            if (!z.equals("")) {
                                if (z.equalsIgnoreCase("sunday")) {
                                    weekOff = 1;
                                } else if (z.equalsIgnoreCase("monday")) {
                                    weekOff = 2;
                                } else if (z.equalsIgnoreCase("tuesday")) {
                                    weekOff = 3;
                                } else if (z.equalsIgnoreCase("wednesday")) {
                                    weekOff = 4;
                                } else if (z.equalsIgnoreCase("thursday")) {
                                    weekOff = 5;
                                } else if (z.equalsIgnoreCase("friday")) {
                                    weekOff = 6;
                                } else if (z.equalsIgnoreCase("saturdady")) {
                                    weekOff = 7;
                                }
                            }
                            daylist.add(weekOff);

//                             if (cal.get(Calendar.DAY_OF_WEEK) != weekOff) {
//                             }else{
//                                    rotationArray.add(-1);
//                             }
                        }
                        if (daylist.contains(cal.get(Calendar.DAY_OF_WEEK))) {
                            rotationArray.add(-1);
                            shiftMasterIdCheckCounter = shiftMasterIdCheckCounter + 1;
                            try {
                                shiftMasterIdList.get(shiftMasterIdCheckCounter);
                            } catch (Exception e) {
                                shiftMasterIdCheckCounter = 0;
                            }
                            if (lastDayOfCurrentMonth == i) {
                                isLastDayOfMonthIsWeekOff = true;
                                shiftMasterForLastDayOfMonth = shiftMasterService.readById(shiftMasterIdList.get(shiftMasterIdCheckCounter));
                            }

                        } else {
                            rotationArray.add(shiftMaster.getId());
                        }

//                                if (!sunday.contains(i)) {
//                                    rotationArray.add(shiftMaster.getId());
//                                } else {
//                                    rotationArray.add(-1);
//                                }
                    }
                } catch (Exception ex) {
                    System.out.println("Array Size Exception" + ex);
                }
//                if (count == days) {
//                    count = 1;
//                    i++;
//                    currentDay = i;
//                    noOfDay = days;
////                    break;
//                }
//                noOfDay = count;
//                count++;

            }

        }

//        int totalNoOfDay = days - noOfDay;
//        shiftGenerateMonthlySchedule.setNoOfDays(totalNoOfDay);
        shiftGenerateMonthlySchedule.setShiftMonth(cmonth);
        shiftGenerateMonthlySchedule.setShiftYear(cyear);
        if (isLastDayOfMonthIsWeekOff) {
            shiftGenerateMonthlySchedule.setNextShiftId(shiftMasterForLastDayOfMonth.getId());
        } else {
            shiftGenerateMonthlySchedule.setNextShiftId(shiftMaster.getId());
        }
        shiftGenerateMonthlySchedule.setShiftRotationMaster(shiftRotationMaster);
        shiftGenerateMonthlySchedule.setEmployeeMaster(employeeMaster);

        try {
            shiftGenerateMonthlySchedule.setDay1(rotationArray.get(0));
            shiftGenerateMonthlySchedule.setDay2(rotationArray.get(1));
            shiftGenerateMonthlySchedule.setDay3(rotationArray.get(2));
            shiftGenerateMonthlySchedule.setDay4(rotationArray.get(3));
            shiftGenerateMonthlySchedule.setDay5(rotationArray.get(4));
            shiftGenerateMonthlySchedule.setDay6(rotationArray.get(5));
            shiftGenerateMonthlySchedule.setDay7(rotationArray.get(6));
            shiftGenerateMonthlySchedule.setDay8(rotationArray.get(7));
            shiftGenerateMonthlySchedule.setDay9(rotationArray.get(8));
            shiftGenerateMonthlySchedule.setDay10(rotationArray.get(9));
            shiftGenerateMonthlySchedule.setDay11(rotationArray.get(10));
            shiftGenerateMonthlySchedule.setDay12(rotationArray.get(11));
            shiftGenerateMonthlySchedule.setDay13(rotationArray.get(12));
            shiftGenerateMonthlySchedule.setDay14(rotationArray.get(13));
            shiftGenerateMonthlySchedule.setDay15(rotationArray.get(14));
            shiftGenerateMonthlySchedule.setDay16(rotationArray.get(15));
            shiftGenerateMonthlySchedule.setDay17(rotationArray.get(16));
            shiftGenerateMonthlySchedule.setDay18(rotationArray.get(17));
            shiftGenerateMonthlySchedule.setDay19(rotationArray.get(18));
            shiftGenerateMonthlySchedule.setDay20(rotationArray.get(19));
            shiftGenerateMonthlySchedule.setDay21(rotationArray.get(20));
            shiftGenerateMonthlySchedule.setDay22(rotationArray.get(21));
            shiftGenerateMonthlySchedule.setDay23(rotationArray.get(22));
            shiftGenerateMonthlySchedule.setDay24(rotationArray.get(23));
            shiftGenerateMonthlySchedule.setDay25(rotationArray.get(24));
            shiftGenerateMonthlySchedule.setDay26(rotationArray.get(25));
            shiftGenerateMonthlySchedule.setDay27(rotationArray.get(26));
            shiftGenerateMonthlySchedule.setDay28(rotationArray.get(27));
            if (day == 29) {
                shiftGenerateMonthlySchedule.setDay29(rotationArray.get(28));
            }
            if (day == 30) {
                shiftGenerateMonthlySchedule.setDay29(rotationArray.get(28));
                shiftGenerateMonthlySchedule.setDay30(rotationArray.get(29));
            }
            if (day == 31) {
                shiftGenerateMonthlySchedule.setDay29(rotationArray.get(28));
                shiftGenerateMonthlySchedule.setDay30(rotationArray.get(29));
                shiftGenerateMonthlySchedule.setDay31(rotationArray.get(30));
            }

            shiftGenerateMonthlyScheduleService.create(shiftGenerateMonthlySchedule);

        } catch (Exception e) {
            System.out.println("Exception" + e);
        }

//        System.out.println("lol");
//    }
    }

    private void shiftGenerateEditWeekly(RotationMaster rotationMaster, Date rd, ShiftRotationMaster shiftRotationMaster, int days, EmployeeMaster employeeMaster, String firstShiftId) throws Exception {
        ShiftMaster shiftMaster = new ShiftMaster();
        ShiftMaster shiftMasterForLastDayOfMonth = new ShiftMaster();
        ShiftGenerateMonthlySchedule shiftGenerateMonthlySchedule = new ShiftGenerateMonthlySchedule();
        ShiftGenerateMonthlySchedule shiftGenerateMonthlySchedule1 = new ShiftGenerateMonthlySchedule();
        List<List<Object>> finalList = new ArrayList<List<Object>>();
        List<Integer> rotationArray = new ArrayList<Integer>(days);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = Calendar.getInstance();
        Calendar c1 = Calendar.getInstance();
        c.setTime(rd);
        int day = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        LocalDate localDate = rd.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int year = localDate.getYear();
        int month = localDate.getMonthValue();
        int dayofmonth = localDate.getDayOfMonth();
        String cdayofmonth = "";
        String cmonth = "";
        String cyear = "";

        cdayofmonth = "" + c.get(Calendar.DAY_OF_MONTH);
        cmonth = "" + (c.get(Calendar.MONTH) + 1);
        cyear = "" + c.get(Calendar.YEAR);
//
//        cdayofmonth = "" + dayofmonth;
//        cmonth = "" + month;
//        cyear = "" + year;
        shiftGenerateMonthlySchedule.setEmployeeMaster(employeeMaster);
        shiftGenerateMonthlySchedule.setShiftMonth(cmonth);
        shiftGenerateMonthlySchedule.setShiftYear(cyear);
        List<?> list = shiftGenerateMonthlyScheduleService.readByCurrentDateWiseEmployeeShift(shiftGenerateMonthlySchedule);
        if (!list.isEmpty()) {
            shiftGenerateMonthlySchedule = (ShiftGenerateMonthlySchedule) list.get(0);

        }
        int currentDay = Integer.parseInt(cdayofmonth);
        for (int i1 = 1; i1 < currentDay; i1++) {
            rotationArray.add(0);
        }

//        int count1 = 0;
//        List sunday = new ArrayList();
//        for (int day1 = 1; day1 <= day; day1++) {
//            c1.set(year, month - 1, day1);
//            int dayOfWeek1 = c1.get(Calendar.DAY_OF_WEEK);
//            if (dayOfWeek1 == Calendar.SUNDAY) {
//                sunday.add(day1);
//            }
//        }
        int count = 1;
        int noOfDay = 0;
//        int i = 1;

        int flag = 0;
        int shiftMasterIdCheckCounter = 0;
        int shiftMasterIdCheckTemp = 0;
        int lastDayOfCurrentMonth = day;
        boolean isLastDayOfMonthIsWeekOff = false;
        List<?> rotationList = rotationMasterService.readFromRotation(rotationMaster);
        List<Integer> shiftMasterIdList = new ArrayList<Integer>();
        if (!rotationList.isEmpty()) {
            for (Object rotationMasterObject : rotationList) {
                rotationMaster = (RotationMaster) rotationMasterObject;
                shiftMasterIdList.add(rotationMaster.getShiftMaster().getId());
                if ((rotationMaster.getShiftMaster().getId().toString()).equals(firstShiftId)) {
                    shiftMasterIdCheckCounter = shiftMasterIdCheckTemp;
                }
                shiftMasterIdCheckTemp++;
            }

            for (int i = currentDay; i <= day; i++) {

                shiftMaster = shiftMasterService.readById(shiftMasterIdList.get(shiftMasterIdCheckCounter));
                try {
                    if (rotationArray.size() != day) {

                        Calendar cal = Calendar.getInstance();
                        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
                        String newdate = i + "/" + cmonth + "/" + cyear;
                        Date ddd = sdf1.parse(newdate);
                        cal.setTime(ddd);
                        String weekOff11 = shiftMaster.getWeekof();
                        ArrayList<Integer> daylist = new ArrayList<Integer>();
                        for (String z : weekOff11.split(",")) {
                            int weekOff = 0;
                            if (!z.equals("")) {
                                if (z.equalsIgnoreCase("sunday")) {
                                    weekOff = 1;
                                } else if (z.equalsIgnoreCase("monday")) {
                                    weekOff = 2;
                                } else if (z.equalsIgnoreCase("tuesday")) {
                                    weekOff = 3;
                                } else if (z.equalsIgnoreCase("wednesday")) {
                                    weekOff = 4;
                                } else if (z.equalsIgnoreCase("thursday")) {
                                    weekOff = 5;
                                } else if (z.equalsIgnoreCase("friday")) {
                                    weekOff = 6;
                                } else if (z.equalsIgnoreCase("saturdady")) {
                                    weekOff = 7;
                                }
                            }
                            daylist.add(weekOff);

//                             if (cal.get(Calendar.DAY_OF_WEEK) != weekOff) {
//                             }else{
//                                    rotationArray.add(-1);
//                             }
                        }
                        if (daylist.contains(cal.get(Calendar.DAY_OF_WEEK))) {
                            rotationArray.add(-1);
                            shiftMasterIdCheckCounter = shiftMasterIdCheckCounter + 1;
                            try {
                                shiftMasterIdList.get(shiftMasterIdCheckCounter);
                            } catch (Exception e) {
                                shiftMasterIdCheckCounter = 0;
                            }
                            if (lastDayOfCurrentMonth == i) {
                                isLastDayOfMonthIsWeekOff = true;
                                shiftMasterForLastDayOfMonth = shiftMasterService.readById(shiftMasterIdList.get(shiftMasterIdCheckCounter));
                            }

                        } else {
                            rotationArray.add(shiftMaster.getId());
                        }

//                                if (!sunday.contains(i)) {
//                                    rotationArray.add(shiftMaster.getId());
//                                } else {
//                                    rotationArray.add(-1);
//                                }
                    }
                } catch (Exception ex) {
                    System.out.println("Array Size Exception" + ex);
                }
//                        if (count == days) {
//                            count = 1;
//                            noOfDay = days;
//                            i++;
//                            currentDay = i;
//                            break;
//                        }
//                        noOfDay = count;
//                        count++;

            }
//                }
//            }

//        }
            int totalNoOfDay = days - noOfDay;
            if (null != shiftGenerateMonthlySchedule.getId()) {
                shiftGenerateMonthlySchedule1.setId(shiftGenerateMonthlySchedule.getId());
            }
//            shiftGenerateMonthlySchedule1.setNoOfDays(totalNoOfDay);
            shiftGenerateMonthlySchedule1.setShiftMonth(cmonth);
            shiftGenerateMonthlySchedule1.setShiftYear(cyear);
            if (isLastDayOfMonthIsWeekOff) {
                shiftGenerateMonthlySchedule1.setNextShiftId(shiftMasterForLastDayOfMonth.getId());
            } else {
                shiftGenerateMonthlySchedule1.setNextShiftId(shiftMaster.getId());
            }
            shiftGenerateMonthlySchedule1.setShiftRotationMaster(shiftRotationMaster);
            shiftGenerateMonthlySchedule1.setEmployeeMaster(employeeMaster);

            try {
                int i1 = 1;

                if (i1 >= dayofmonth) {
                    shiftGenerateMonthlySchedule1.setDay1(rotationArray.get(0));
                } else {
                    shiftGenerateMonthlySchedule1.setDay1(shiftGenerateMonthlySchedule.getDay1());
                }
                i1++;
                if (i1 >= dayofmonth) {
                    shiftGenerateMonthlySchedule1.setDay2(rotationArray.get(1));
                } else {
                    shiftGenerateMonthlySchedule1.setDay2(shiftGenerateMonthlySchedule.getDay2());
                }
                i1++;
                if (i1 >= dayofmonth) {
                    shiftGenerateMonthlySchedule1.setDay3(rotationArray.get(2));
                } else {
                    shiftGenerateMonthlySchedule1.setDay3(shiftGenerateMonthlySchedule.getDay3());
                }
                i1++;
                if (i1 >= dayofmonth) {
                    shiftGenerateMonthlySchedule1.setDay4(rotationArray.get(3));
                } else {
                    shiftGenerateMonthlySchedule1.setDay4(shiftGenerateMonthlySchedule.getDay4());
                }
                i1++;
                if (i1 >= dayofmonth) {
                    shiftGenerateMonthlySchedule1.setDay5(rotationArray.get(4));
                } else {
                    shiftGenerateMonthlySchedule1.setDay5(shiftGenerateMonthlySchedule.getDay5());
                }
                i1++;
                if (i1 >= dayofmonth) {
                    shiftGenerateMonthlySchedule1.setDay6(rotationArray.get(5));
                } else {
                    shiftGenerateMonthlySchedule1.setDay6(shiftGenerateMonthlySchedule.getDay6());
                }
                i1++;
                if (i1 >= dayofmonth) {
                    shiftGenerateMonthlySchedule1.setDay7(rotationArray.get(6));
                } else {
                    shiftGenerateMonthlySchedule1.setDay7(shiftGenerateMonthlySchedule.getDay7());
                }
                i1++;
                if (i1 >= dayofmonth) {
                    shiftGenerateMonthlySchedule1.setDay8(rotationArray.get(7));
                } else {
                    shiftGenerateMonthlySchedule1.setDay8(shiftGenerateMonthlySchedule.getDay8());
                }
                i1++;
                if (i1 >= dayofmonth) {
                    shiftGenerateMonthlySchedule1.setDay9(rotationArray.get(8));
                } else {
                    shiftGenerateMonthlySchedule1.setDay9(shiftGenerateMonthlySchedule.getDay9());
                }
                i1++;
                if (i1 >= dayofmonth) {
                    shiftGenerateMonthlySchedule1.setDay10(rotationArray.get(9));
                } else {
                    shiftGenerateMonthlySchedule1.setDay10(shiftGenerateMonthlySchedule.getDay10());
                }
                i1++;
                if (i1 >= dayofmonth) {
                    shiftGenerateMonthlySchedule1.setDay11(rotationArray.get(10));
                } else {
                    shiftGenerateMonthlySchedule1.setDay11(shiftGenerateMonthlySchedule.getDay11());
                }
                i1++;
                if (i1 >= dayofmonth) {
                    shiftGenerateMonthlySchedule1.setDay12(rotationArray.get(11));
                } else {
                    shiftGenerateMonthlySchedule1.setDay12(shiftGenerateMonthlySchedule.getDay12());
                }
                i1++;
                if (i1 >= dayofmonth) {
                    shiftGenerateMonthlySchedule1.setDay13(rotationArray.get(12));
                } else {
                    shiftGenerateMonthlySchedule1.setDay13(shiftGenerateMonthlySchedule.getDay13());
                }
                i1++;
                if (i1 >= dayofmonth) {
                    shiftGenerateMonthlySchedule1.setDay14(rotationArray.get(13));
                } else {
                    shiftGenerateMonthlySchedule1.setDay14(shiftGenerateMonthlySchedule.getDay14());
                }
                i1++;
                if (i1 >= dayofmonth) {
                    shiftGenerateMonthlySchedule1.setDay15(rotationArray.get(14));
                } else {
                    shiftGenerateMonthlySchedule1.setDay15(shiftGenerateMonthlySchedule.getDay15());
                }
                i1++;
                if (i1 >= dayofmonth) {
                    shiftGenerateMonthlySchedule1.setDay16(rotationArray.get(15));
                } else {
                    shiftGenerateMonthlySchedule1.setDay16(shiftGenerateMonthlySchedule.getDay16());
                }
                i1++;
                if (i1 >= dayofmonth) {
                    shiftGenerateMonthlySchedule1.setDay17(rotationArray.get(16));
                } else {
                    shiftGenerateMonthlySchedule1.setDay17(shiftGenerateMonthlySchedule.getDay17());
                }
                i1++;
                if (i1 >= dayofmonth) {
                    shiftGenerateMonthlySchedule1.setDay18(rotationArray.get(17));
                } else {
                    shiftGenerateMonthlySchedule1.setDay18(shiftGenerateMonthlySchedule.getDay18());
                }
                i1++;
                if (i1 >= dayofmonth) {
                    shiftGenerateMonthlySchedule1.setDay19(rotationArray.get(18));
                } else {
                    shiftGenerateMonthlySchedule1.setDay19(shiftGenerateMonthlySchedule.getDay19());
                }
                i1++;
                if (i1 >= dayofmonth) {
                    shiftGenerateMonthlySchedule1.setDay20(rotationArray.get(19));
                } else {
                    shiftGenerateMonthlySchedule1.setDay20(shiftGenerateMonthlySchedule.getDay20());
                }
                i1++;
                if (i1 >= dayofmonth) {
                    shiftGenerateMonthlySchedule1.setDay21(rotationArray.get(20));
                } else {
                    shiftGenerateMonthlySchedule1.setDay21(shiftGenerateMonthlySchedule.getDay21());
                }
                i1++;
                if (i1 >= dayofmonth) {
                    shiftGenerateMonthlySchedule1.setDay22(rotationArray.get(21));
                } else {
                    shiftGenerateMonthlySchedule1.setDay22(shiftGenerateMonthlySchedule.getDay22());
                }
                i1++;
                if (i1 >= dayofmonth) {
                    shiftGenerateMonthlySchedule1.setDay23(rotationArray.get(22));
                } else {
                    shiftGenerateMonthlySchedule1.setDay23(shiftGenerateMonthlySchedule.getDay23());
                }
                i1++;
                if (i1 >= dayofmonth) {
                    shiftGenerateMonthlySchedule1.setDay24(rotationArray.get(23));
                } else {
                    shiftGenerateMonthlySchedule1.setDay24(shiftGenerateMonthlySchedule.getDay24());
                }
                i1++;
                if (i1 >= dayofmonth) {
                    shiftGenerateMonthlySchedule1.setDay25(rotationArray.get(24));
                } else {
                    shiftGenerateMonthlySchedule1.setDay25(shiftGenerateMonthlySchedule.getDay25());
                }
                i1++;
                if (i1 >= dayofmonth) {
                    shiftGenerateMonthlySchedule1.setDay26(rotationArray.get(25));
                } else {
                    shiftGenerateMonthlySchedule1.setDay26(shiftGenerateMonthlySchedule.getDay26());
                }
                i1++;
                if (i1 >= dayofmonth) {
                    shiftGenerateMonthlySchedule1.setDay27(rotationArray.get(26));
                } else {
                    shiftGenerateMonthlySchedule1.setDay27(shiftGenerateMonthlySchedule.getDay27());
                }
                i1++;
                if (i1 >= dayofmonth) {
                    shiftGenerateMonthlySchedule1.setDay28(rotationArray.get(27));
                } else {
                    shiftGenerateMonthlySchedule1.setDay28(shiftGenerateMonthlySchedule.getDay28());
                }
                if (day == 29) {
                    i1++;
                    if (i1 >= dayofmonth) {
                        shiftGenerateMonthlySchedule1.setDay29(rotationArray.get(28));
                    } else {
                        shiftGenerateMonthlySchedule1.setDay29(shiftGenerateMonthlySchedule.getDay29());
                    }
                }

                if (day == 30) {
                    i1++;
                    if (i1 >= dayofmonth) {
                        shiftGenerateMonthlySchedule1.setDay29(rotationArray.get(28));
                    } else {
                        shiftGenerateMonthlySchedule1.setDay29(shiftGenerateMonthlySchedule.getDay29());
                    }
                    i1++;
                    if (i1 >= dayofmonth) {
                        shiftGenerateMonthlySchedule1.setDay30(rotationArray.get(29));
                    } else {
                        shiftGenerateMonthlySchedule1.setDay30(shiftGenerateMonthlySchedule.getDay30());
                    }
                }
                if (day == 31) {
                    i1++;
                    if (i1 >= dayofmonth) {
                        shiftGenerateMonthlySchedule1.setDay29(rotationArray.get(28));
                    } else {
                        shiftGenerateMonthlySchedule1.setDay29(shiftGenerateMonthlySchedule.getDay29());
                    }
                    i1++;
                    if (i1 >= dayofmonth) {
                        shiftGenerateMonthlySchedule1.setDay30(rotationArray.get(29));
                    } else {
                        shiftGenerateMonthlySchedule1.setDay30(shiftGenerateMonthlySchedule.getDay30());
                    }
                    i1++;
                    if (i1 >= dayofmonth) {
                        shiftGenerateMonthlySchedule1.setDay31(rotationArray.get(30));
                    } else {
                        shiftGenerateMonthlySchedule1.setDay31(shiftGenerateMonthlySchedule.getDay31());
                    }
                }

                shiftGenerateMonthlyScheduleService.createOrUpdate(shiftGenerateMonthlySchedule1);
            } catch (Exception e) {
                System.out.println("Exception" + e);
            }

            System.out.println("lol");

//    }
        }

    }

    public ModelAndView formerEmployeeRecords(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = new EmployeeMaster();
//        List<?> employeeMasterList = employeeMasterService.read();
        List<?> employeeMasterList = employeeMasterService.readEmployeesDetail1();
        mv.getModelMap().put("list", employeeMasterList);
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.setViewName("Employee/PastEmployeeRecords");

        return mv;
    }

    public ModelAndView formalEmployeeExportToExcel(HttpServletRequest request, HttpServletResponse response, EmployeeMaster employeeMaster) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<?> employeeMasterList = employeeMasterService.readFormerEmployeeDataForexportToExcel();
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=FormerEmployeeDataSheet.xls");
        mv.addObject("employeeMasterList", employeeMasterList);
        mv.setViewName("DocumentView/FormerEmployeeDataToExcel");
        return mv;
    }

    public ModelAndView viewOwnProfile(HttpServletRequest request, HttpServletResponse response, EmployeeMaster employeeMaster) throws Exception {
        ModelAndView mv = new ModelAndView();
        String lastYearPerformanceRatingsOfEmployee = "";
//        EmployeeMaster employeeMaster = new EmployeeMaster();
        UserRightMaster user = (UserRightMaster) request.getSession().getAttribute("userRight");
        //set Employee master id//
        int id = Integer.parseInt(request.getParameter("id"));
//        employeeMaster.setId(Integer.parseInt(id));
//        employeeMaster.setEmployeeId(id);
        //set Employee master id//
        UserMaster userMaster = new UserMaster();
        employeeMaster = employeeMasterService.readById(id);
        ///this code is for read file name and display it
//        String userName = readUserName(request);
        String userName = request.getParameter("userid");
        request.setAttribute("userName", userName);//this attribute is for use name and read form directory structure.s
        UserMaster userMaster2 = userMasterService.readById(Integer.parseInt(userName));
        String fileLocationURL = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "UserProfile"
                + File.separator + userMaster2.getUserName() + File.separator;
        File pictureFile = new File(fileLocationURL);
        if (pictureFile.exists() && pictureFile.listFiles().length > 0) {
            File[] file = pictureFile.listFiles();
            request.setAttribute("imgFile", "StorageYard" + File.separator + "UserProfile" + File.separator + userMaster2.getUserName() + File.separator + file[0].getName());
        } else {
            request.setAttribute("imgFile", "StorageYard" + File.separator + "UserProfile" + File.separator + "User" + File.separator + "default.png");
        }
        DepartmentMaster departmentMaster = new DepartmentMaster();
        DesignationMaster designationMaster = new DesignationMaster();
        LevelMaster levelMaster = new LevelMaster();
        LocationMaster locationMaster = new LocationMaster();
        ShiftMaster shiftMaster = new ShiftMaster();
        ZydexLocationMaster zydexLocationMaster = new ZydexLocationMaster();
        bind(request, userMaster);
        selectEmployee(request, response);
        departmentList(request);
        designationList(request);
        levelList(request);
        locationList(request);
        shiftRotaionList(request);
        setZydexLocationList(request);
        companyList(request);
//        shiftList(request);
        hoursBasisList(request);
        competencyList(request);
        EmployeeTypeList(request);
        EmployeeSubTypeList(request);
        policyList(request);
        ctcList(request);
        //getLastYearPerformance Ratings Of Employee For ReadOnly.s
        List<?> lastYearPerformanceRatingsOfEmployeeList = employeeMasterService.getLastYearPerformanceRatingOfEmployee(id);

        lastYearPerformanceRatingsOfEmployee = (lastYearPerformanceRatingsOfEmployeeList.isEmpty()) ? lastYearPerformanceRatingsOfEmployee : String.valueOf(lastYearPerformanceRatingsOfEmployeeList.get(0));
        List<?> employeeMasterExtensionList = employeeMasterServiceExtension.readByemployeeId(employeeMaster.getId());
        //set user master id//
        String userid = request.getParameter("userid");
        userMaster.setId(Integer.parseInt(userid));
        employeeMaster.setUserMaster(userMaster);
        //set Employee master id//
        selectedEmployeeLevel1(request, employeeMaster);
//        selectedEmployeeLevel2(request, employeeMaster);
//        selectedEmployeeLevel3(request, employeeMaster);
//        selectedEmployeeLevel4(request, employeeMaster);
//        selectedEmployeeLevel5(request, employeeMaster);
//        selectedEmployeeLevel6(request, employeeMaster);

        List<String> certificatesList = new ArrayList();
        UserMaster userMaster1 = new UserMaster();
        userMaster1 = userMasterService.readById(Integer.parseInt(userid));
        String certificateFileLocationURL = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "UserCertificate"
                + File.separator + userMaster1.getUserName() + File.separator;
        File certificateListFile = new File(certificateFileLocationURL);
        if (certificateListFile.listFiles() != null) {

            for (File sss : certificateListFile.listFiles()) {
                String aa = sss.getName();
                certificatesList.add(aa);

            }
            if (certificateListFile.exists() && certificateListFile.listFiles().length > 0) {
                File[] certificateListFileArray = certificateListFile.listFiles();
                try {
                    request.setAttribute("imageFile", "StorageYard" + File.separator + "UserCertificate" + File.separator + userName + File.separator + certificateListFileArray[0].getName().replaceAll(" ", ""));
                } catch (Exception e) {
                }
            }
        }
        String rmName2 = "";
        String rmName3 = "";
        String rmName4 = "";
        String rmName5 = "";
        String rmName6 = "";
        String rm2 = employeeMaster.getReportingManagerLevel2();
        String rm3 = employeeMaster.getReportingManagerLevel3();
        String rm4 = employeeMaster.getReportingManagerLevel4();
        String rm5 = employeeMaster.getReportingManagerLevel5();
        String rm6 = employeeMaster.getReportingManagerLevel6();
        if (!rm2.isEmpty()) {
            rmName2 = employeeMasterService.getNameById(Integer.parseInt(rm2));
        }
        if (!rm3.isEmpty()) {
            rmName3 = employeeMasterService.getNameById(Integer.parseInt(rm3));
        }
        if (!rm4.isEmpty()) {
            rmName4 = employeeMasterService.getNameById(Integer.parseInt(rm4));
        }
        if (!rm5.isEmpty()) {
            rmName5 = employeeMasterService.getNameById(Integer.parseInt(rm5));
        }
        if (!rm6.isEmpty()) {
            rmName6 = employeeMasterService.getNameById(Integer.parseInt(rm6));
        }
        request.setAttribute("maritalStatus", employeeMaster.getMaritalStatus());
        request.setAttribute("lastYearPerformanceRatingsOfEmployee", lastYearPerformanceRatingsOfEmployee);
        request.setAttribute("company", employeeMaster.getCompany());
        request.setAttribute("employeeType", employeeMaster.getEmployeeType());
        request.setAttribute("shiftType", employeeMaster.getShiftType());
        request.setAttribute("certificatesList", certificatesList);
        request.setAttribute("employeeMasterExtensionList", employeeMasterExtensionList);
        request.setAttribute("rmName2", rmName2);
        request.setAttribute("rmName3", rmName3);
        request.setAttribute("rmName4", rmName4);
        request.setAttribute("rmName5", rmName5);
        request.setAttribute("rmName6", rmName6);

        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.setViewName("Employee/EmployeesOwnProfile");
        return mv;

    }

    public void downloadEmployeeCertificates(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        String fileName = request.getParameter("fileName");
        String userId = request.getParameter("userId");

        UserMaster userMaster = userMasterService.readById(Integer.parseInt(userId));

        String certificateFileLocationURL = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "UserCertificate"
                + File.separator + userMaster.getUserName() + File.separator + fileName;

        request.setAttribute("filePath", certificateFileLocationURL);

        DownloadFile downloadFile = new DownloadFile();
        downloadFile.doDownload(request, response);
    }

    public ModelAndView adminChangePassWordClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        String id = request.getParameter("id");
        employeeMaster = employeeMasterService.readById(Integer.parseInt(id));
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.setViewName("Employee/EmployeePasswordChange");
        return mv;
    }

    public ModelAndView adminChangePassWordSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        UserMaster userMaster = new UserMaster();
        String userId = request.getParameter("userId");
        userMaster = userMasterService.readById(Integer.parseInt(userId));
        String password = request.getParameter("password");
        userMaster.setPassword(password);
        userMasterService.update(userMaster);
        mv.setViewName("redirect:employeeMaster.htm?act=searchSubmit");
        return mv;
    }

    public ModelAndView inActiveEmployeeClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        String empId = request.getParameter("id");
        employeeMaster = employeeMasterService.readById(Integer.parseInt(empId));
        request.setAttribute("empId", empId);
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.setViewName("Employee/EmployeeInActivePage");

        return mv;
    }

    public ModelAndView inActiveEmployeeSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        bind(request, employeeMaster);
        String empId = request.getParameter("empId");
        employeeMaster1 = employeeMasterService.readById(Integer.parseInt(empId));
        employeeMaster1.setDateOfLeaving(employeeMaster.getDateOfLeaving());
        employeeMaster1.setReasonForLeaving(employeeMaster.getReasonForLeaving());
        employeeMasterService.update(employeeMaster1);
        mv.setViewName("redirect:employeeMaster.htm?act=searchSubmit");
        return mv;
    }

    public ModelAndView readEmpTypeAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeTypeMaster employeeTypeMaster = new EmployeeTypeMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        String typeId = request.getParameter("typeId");
        String employeeId = request.getParameter("employeeId");
        String val = "";
        String empSubTypeId = request.getParameter("empSubTypeId");

        if (null == employeeId) {
        } else {
            employeeMaster = employeeMasterService.readById(Integer.parseInt(employeeId));
            request.setAttribute("employeeSubTypeId", employeeMaster.getEmployeeSubType().getId());
        }
        if (null == empSubTypeId) {
        } else {
            request.setAttribute("employeeSubTypeId", empSubTypeId);
        }
        ArrayList<EmployeeSubType> employeeSubTypeList = new ArrayList<EmployeeSubType>();
        if (!"None".equals(typeId)) {
            employeeSubTypeList = (ArrayList<EmployeeSubType>) employeeSubTypeService.readByEmployeeTypeId(typeId);

            if (employeeSubTypeList.size() > 0) {
                Collections.sort(employeeSubTypeList, new Comparator<EmployeeSubType>() {

                    public int compare(final EmployeeSubType object1, final EmployeeSubType object2) {
                        return object1.getSubType().compareTo(object2.getSubType());
                    }
                });
            }
        } else {
            val = "None";
        }
        request.setAttribute("val", val);
        request.setAttribute("employeeSubTypeList", employeeSubTypeList);
        mv.setViewName("Employee/EmployeeSubTypeAjax");
        return mv;
    }

    public ModelAndView printemployeedescription(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        DesignationMaster designationMaster = new DesignationMaster();
        DepartmentMaster departmentMaster = new DepartmentMaster();
        LevelMaster levelMaster = new LevelMaster();
        String empId = request.getParameter("id");
        employeeMaster = employeeMasterService.readById(Integer.parseInt(empId));
        designationMaster = designationMasterService.readById(employeeMaster.getDesignationMaster().getId());
        departmentMaster = departmentMasterService.readById(employeeMaster.getDepartmentMaster().getId());
        levelMaster = levelMasterService.readById(employeeMaster.getLevelMaster().getId());
        request.setAttribute("empId", empId);
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.getModelMap().put("designationMaster", designationMaster);
        mv.getModelMap().put("departmentMaster", departmentMaster);
        mv.getModelMap().put("departmentMaster", departmentMaster);
        mv.getModelMap().put("levelMaster", levelMaster);
        mv.setViewName("Employee/printemployeedescription");

        return mv;
    }

    public ModelAndView inductionCreateClick(HttpServletRequest request, HttpServletResponse response, EmployeeMaster employeeMaster) throws Exception {
        ModelAndView mv = new ModelAndView();
//        EmployeeMaster employeeMaster = new EmployeeMaster();
        DepartmentMaster departmentMaster = new DepartmentMaster();
        DesignationMaster designationMaster = new DesignationMaster();
        LevelMaster levelMaster = new LevelMaster();
        LocationMaster locationMaster = new LocationMaster();
        UserMaster userMaster = new UserMaster();
        EmployeeTypeMaster employeeTypeMaster = new EmployeeTypeMaster();
        EmployeeSubType employeeSubType = new EmployeeSubType();
        ZydexLocationMaster zydexLocationMaster = new ZydexLocationMaster();
        MprApprovalHistory mprApprovalHistory = new MprApprovalHistory();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        //-----------------------
        //List<?> employeeMasterExtensionList = employeeMasterServiceExtension.readByemployeeId(employeeMaster.getId());
        request.setAttribute("imgFile", "StorageYard" + File.separator + "UserProfile" + File.separator + "User" + File.separator + "default.png");
        
        //------------------------
        Date cDate = new Date();
//        ShiftMaster shiftMaster = new ShiftMaster();
        selectEmployee(request, response);
        selectedEmployeeLevel1(request, employeeMaster);
        departmentList(request);
        designationList(request);
        levelList(request);
        locationList(request);
        shiftRotaionList(request);
        setZydexLocationList(request);
        competencyList(request);
        EmployeeTypeList(request);
        EmployeeSubTypeList(request);
        companyList(request);
        policyList(request);
        ctcList(request);
        //master's data setting completed on request
//        shiftList(request);
        hoursBasisList(request);
        employeeMaster.setUserMaster(userMaster);
        employeeMaster.setLevelMaster(levelMaster);
        employeeMaster.setLocationMaster(locationMaster);
        employeeMaster.setDepartmentMaster(departmentMaster);
        employeeMaster.setDesignationMaster(designationMaster);
        employeeMaster.setZydexLocationMaster(zydexLocationMaster);
        employeeMaster.setEmployeeTypeMaster(employeeTypeMaster);
        employeeMaster.setEmployeeSubType(employeeSubType);

        //////////////////set the employee basic detail
        String applicationId = request.getParameter("id");
        String candidateId = request.getParameter("candidateId");

        CandidateJobApplication cja = candidateJobApplicationService.readById(Integer.parseInt(applicationId));
        CandidateApplyJob candidateApplyJob = candidateJobApplyService.readById(Integer.parseInt(candidateId));

        employeeMaster.setEmployeeName(candidateApplyJob.getName());
        employeeMaster.setFatherName(candidateApplyJob.getFatherName());
        employeeMaster.setMotherName(candidateApplyJob.getMotherName());
        employeeMaster.setDateOfBirthOfEmpFather(candidateApplyJob.getFatherDob());
        employeeMaster.setDateOfBirthOfEmpMother(candidateApplyJob.getMotherDob());

        Boolean Gender = true;
        if ((candidateApplyJob.getSex()).equals("false")) {
            Gender = false;
        }
        employeeMaster.setGender(Gender);

        employeeMaster.setMaritalStatus(candidateApplyJob.getMartialStatus());
        employeeMaster.setDateOfBirth(candidateApplyJob.getDob());

        employeeMaster.setPresentAddress(candidateApplyJob.getPresentAddress());
        employeeMaster.setPermanentAddress(candidateApplyJob.getPermanentAddress());
        employeeMaster.setCityOfEmployee(candidateApplyJob.getCity());
        employeeMaster.setBloodGroups(candidateApplyJob.getBloodGroup());
        employeeMaster.setEmailAddress(candidateApplyJob.getEmailId());
        employeeMaster.setContactNo1(candidateApplyJob.getContactNo());
        employeeMaster.setEmergencyContactPerson(candidateApplyJob.getEmergencyContactPerson());
        employeeMaster.setEmergencyContactNo(candidateApplyJob.getEmergencyContactNo());
        employeeMaster.setPermanentAddress(candidateApplyJob.getPermanentAddress());
        employeeMaster.setHighestEducationDetails(candidateApplyJob.getHighestEducationQualification());

//        mprApprovalHistory.setApprovalUserId(employeeMaster.getId());
//        mprApprovalHistory.setApprovalUserName(employeeMaster.getEmployeeName());
//        mprApprovalHistory.setStatus(11);
//        mprApprovalHistory.setComment("Induction");
//        mprApprovalHistory.setStatusMessage("Induction");
//        mprApprovalHistory.setCreateDate(sdf.format(cDate));
//        mprApprovalHistory.setCreatedBy(employeeMaster.getId());
//        mprApprovalHistory.setApplicationId(Integer.parseInt(applicationId));
//        mprApprovalHistoryService.create(mprApprovalHistory);
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.getModelMap().put("applicationId", applicationId);
        mv.getModelMap().put("candidateId", candidateId);
        //request.setAttribute("employeeMasterExtensionList", employeeMasterExtensionList);

        mv.setViewName("Employee/EmployeeInductionForm");
//        request.setAttribute("successMessage",
//                "Information : The Induction successfully.");
        return mv;
    }

    public ModelAndView inductionSubmit(HttpServletRequest request, HttpServletResponse response, EmployeeMaster employeeMaster) throws Exception {
        /*ModelAndView mv = new ModelAndView();
//        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeLeaveBalance employeeLeaveBalance;
        String applicationId = request.getParameter("applicationId");
        String candidateId = request.getParameter("candidateId");
//        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        EmployeeSubType employeeSubType = new EmployeeSubType();
        BindException errors = new BindException(employeeMaster, "employeeMaster");
        UserMaster userMaster = new UserMaster();

        bind(request, employeeMaster);
        //Deopdown List//
        departmentList(request);
        designationList(request);
        levelList(request);
        locationList(request);
        shiftRotaionList(request);
        hoursBasisList(request);
        setZydexLocationList(request);
        competencyList(request);
        EmployeeTypeList(request);
        EmployeeSubTypeList(request);
        companyList(request);
        policyList(request);
        //DeowpDown list//
//        String reasonForLeaving = request.getParameter("password");
        String userName = request.getParameter("userName");
//        String password = reasonForLeaving;
        String password = "";
        String employeeSubTypeId = request.getParameter("subTypeId");
//        String gender = request.getParameter("gender");
//        String reportingManagerLevel1 = request.getParameter("reportingManagerLevel1");
//        String reportingManagerLevel2 = request.getParameter("reportingManagerLevel2");
//        String reportingManagerLevel3 = request.getParameter("reportingManagerLevel3");
//        String reportingManagerLevel4 = request.getParameter("reportingManagerLevel4");
//        String reportingManagerLevel5 = request.getParameter("reportingManagerLevel5");
//        String reportingManagerLevel6 = request.getParameter("reportingManagerLevel6");
        String dateOfJoining = request.getParameter("dateOfJoining");
        String dateOfBirth = request.getParameter("dateOfBirth");
        String shiftMasterId = request.getParameter("shiftMasterId");
//        String competencyEvaluationId = request.getParameter("competencyEvaluationId");
        userMaster.setUserName(userName);
        if (employeeMaster.getUserMaster() != null) {
            if (employeeMaster.getUserMaster().getPassword() != null) {
                password = password + employeeMaster.getUserMaster().getPassword();
                //if we directly gettting 'employeeMaster.getUserMaster().getPassword()' its possibility for nullpointer exception.
            }
        }

        userMaster.setPassword(password);
        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
        Date DOB = new Date();
        Date DOJ = new Date();
        Date DOB1 = new Date();
        if (!"".equals(dateOfJoining)) {
            DOJ = sd.parse(dateOfJoining);

        }
        if (!"".equals(dateOfBirth)) {
            DOB = sd.parse(dateOfBirth);
            Calendar c1 = Calendar.getInstance();
            c1.setTime(DOB);
            c1.add(Calendar.YEAR, 18);
            DOB1 = c1.getTime();
        }
        if (null != employeeSubTypeId && !employeeSubTypeId.equals("")) {
            employeeSubType.setId(Integer.parseInt(employeeSubTypeId));
        }
        employeeMaster.setEmployeeSubType(employeeSubType);
//        if (!userMasterService.isExist(userName) && !userName.equals("") && !password.equals("")) {
//
//            userMasterService.create(userMaster);
//        } else {
//            request.setAttribute("failureMessage",
//                    "Error : User isExist.");
//            mv.addAllObjects(errors.getModel());
//            mv.setViewName("Employee/EmployeeRegistrationForm");
//        }

        if (!employeeMasterService.isExistUSername(userName)) {
            if (userMasterService.isExist(userName)) {
                userMaster.setUserName(userName);
                List<?> tempList = userMasterService.read(userMaster);
                UserMaster user2;
                user2 = (UserMaster) tempList.get(0);
                userMasterService.delete(user2.getId());

            }
        }

        // employee Code automically Generate 
        int employeeLoactionCode = employeeMaster.getLocationMaster().getId();
        LocationMaster ltm = locationMasterService.readById(employeeLoactionCode);
        String locationCode = ltm.getLocationCode();
        String empCodeString = "";
        SimpleDateFormat sdf11 = new SimpleDateFormat("dd/MM/yyyy");
        Date cDate11 = new Date();
//        approvalMaster.setCreatedBy(approvalMaster1);
        String CureentDate = sdf11.format(cDate11);
        String[] endDateSplited = CureentDate.split("/");
        String empFormat = "";
        String month122 = endDateSplited[1];
        String year122 = endDateSplited[2];

        List<?> empCodeList = employeeMasterService.readEmployeeCodeAutoGenerate();
        Object[] codeList = (Object[]) empCodeList.get(0);
        String oldempCode = codeList[1].toString();
        String[] oldempCodeSplited = oldempCode.split("/");
        String oldempcodesplit = oldempCodeSplited[4];
        empCodeString = "SPCLS" + "/" + year122 + "/" + month122 + "/" + locationCode + "/" + (Integer.parseInt(oldempcodesplit) + 1);

        employeeMaster.setAutoGenerationCode(empCodeString);
        if (employeeMaster.getPfAmount().equals("")) {
            employeeMaster.setPfAmount("0");
        }

        if (employeeMaster.getPfAmount().equals("")) {
            employeeMaster.setPfAmount("0");
        }
        employeeMasterValidator.validate(employeeMaster, errors);
        if (errors.hasErrors()) {

            String shiftId = request.getParameter("shiftId");
            String shiftMasterId1 = request.getParameter("shiftMasterId");
            String HoursTitle = request.getParameter("shiftHoursId");
//            *********************************************************************************
            if (!"".equals(shiftId) && shiftId != null) {
                employeeMaster.setShiftHoursId(Integer.parseInt(shiftId));
            } else if (!"".equals(HoursTitle) && HoursTitle != null) {
                employeeMaster.setShiftHoursId(Integer.parseInt(HoursTitle));
            }

//            employeeMaster.setShiftHoursId(Integer.parseInt(shiftId));
//           above line is commented because it produces "NumberFormatException" while we submits blank page
//            By Irfan
//            **********************************************************************************
            request.setAttribute("shiftName", shiftMasterId1);
//            request.setAttribute("competencyEvaluationId", competencyEvaluationId);
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv.addAllObjects(errors.getModel());
            selectEmployee(request, response);
            selectedEmployeeLevel1(request, employeeMaster);
//            request.setAttribute("employeeMaster", employeeMaster);
            mv.getModelMap().put("employeeMaster", employeeMaster);
            mv.setViewName("Employee/EmployeeInductionForm");
        } else if (DOJ.before(DOB1)) {
            request.setAttribute("failureMessage",
                    "Error : Enter Valid Date of Joining");

            selectEmployee(request, response);
            selectedEmployeeLevel1(request, employeeMaster);
            request.setAttribute("employeeMaster", employeeMaster);
            mv.setViewName("Employee/EmployeeInductionForm");
        } else if (!userMasterService.isExist(userName) && !userName.equals("") && !"".equals(password)) {

//            if (!password.equals("")) {
//                if (employeeMaster.getShiftType().equals("HourlyBase")) {
            if ("HourlyBase".equals(employeeMaster.getShiftType())) {
                String hoursId = request.getParameter("shiftHoursId");
                if (null != hoursId && !hoursId.equals("")) {
                    employeeMaster.setShiftHoursId(Integer.parseInt(hoursId));
                }
            }
//                if (employeeMaster.getShiftType().equals("ShiftBase")) {
            if ("ShiftBase".equals(employeeMaster.getShiftType())) {
                String shfitId = request.getParameter("shiftId");
                if (null != shfitId && !shfitId.equals("")) {
                    employeeMaster.setShiftHoursId(Integer.parseInt(shfitId));
                }
            }
//            employeeMaster.setCompetencyEvaluationId(Integer.parseInt(competencyEvaluationId));
            // employeeMaster.setId(userMaster.getId());
            employeeMaster.setUserMaster(userMaster);
//                employeeMaster.setReportingManagerLevel1(reportingManagerLevel1);
//                employeeMaster.setReportingManagerLevel2(reportingManagerLevel2);
//                employeeMaster.setReportingManagerLevel3(reportingManagerLevel3);
//                employeeMaster.setReportingManagerLevel4(reportingManagerLevel4);
//                employeeMaster.setReportingManagerLevel5(reportingManagerLevel5);
//                employeeMaster.setReportingManagerLevel6(reportingManagerLevel6);
            employeeMaster.setPanCard(String.valueOf(employeeMaster.getPanCard()).toUpperCase());//this is for store pan card in uppercase in database.
            userMaster.setFirstTime(true);
//set firstTime is true for compulsory password change on first time login

            userMasterService.create(userMaster);

            CandidateJobApplication cja = candidateJobApplicationService.readById(Integer.parseInt(applicationId));
//            ApplayJobUserMaster ajum = applayJobUserMasterService.readById(cja.getApplayJobUserMaster().getId());
//            ajum.setFirstTime(5);
            cja.setStatus(13);
            candidateJobApplicationService.update(cja);

            employeeMasterService.create(employeeMaster);
            //Code for Employee Policy Detail
//            userMasterService.create(userMaster);

//            employeeMasterService.create(employeeMaster);
            //Code for Employee Policy Detail
            EmployeePolicyDetail employeePolicyDetail = new EmployeePolicyDetail();
            int otherDetailCount = Integer.parseInt(request.getParameter("policyCount"));
            for (int i = 1; i <= otherDetailCount; i++) {
                PolicyMaster policyMaster = new PolicyMaster();
                if (null != request.getParameter("policyId" + i) && null != request.getParameter("amount" + i)) {
                    if (!request.getParameter("policyId" + i).equals("") && !request.getParameter("amount" + i).equals("")) {
                        int policyId = Integer.parseInt(request.getParameter("policyId" + i));
                        policyMaster.setId(policyId);
                        Double amount = Double.valueOf(request.getParameter("amount" + i));
                        String policyNumber = request.getParameter("policyNumber" + i);
                        employeePolicyDetail.setEmployeeMaster(employeeMaster);
                        employeePolicyDetail.setAmount(amount);
                        employeePolicyDetail.setPolicyMaster(policyMaster);
                        employeePolicyDetail.setPolicyNum(policyNumber);
                        if (null != request.getParameter("taxable" + i)) {
                            employeePolicyDetail.setStatus(1);
                        } else {
                            employeePolicyDetail.setStatus(0);
                        }
                        employeePolicyDetailService.create(employeePolicyDetail);
                    }
                }
            }

            //Code for Employee ctc Detail
            EmployeeCtcDetail employeeCtcDetail = new EmployeeCtcDetail();
            int otherDetailCount1 = Integer.parseInt(request.getParameter("ctcCount"));
            for (int i = 1; i <= otherDetailCount1; i++) {
                CtcAllowance ctcAllowance = new CtcAllowance();
                if (null != request.getParameter("ctcId" + i) && null != request.getParameter("ctcamount" + i)) {
                    if (!request.getParameter("ctcId" + i).equals("") && !request.getParameter("ctcamount" + i).equals("")) {
                        int ctcId = Integer.parseInt(request.getParameter("ctcId" + i));
                        ctcAllowance.setId(ctcId);
                        Double amount = Double.valueOf(request.getParameter("ctcamount" + i));
                        String month = request.getParameter("month" + i);
                        String year = request.getParameter("year" + i);
//                        String policyNumber = request.getParameter("policyNumber" + i);
                        employeeCtcDetail.setEmployeeMaster(employeeMaster);
                        employeeCtcDetail.setAmount(amount);
                        employeeCtcDetail.setCtcAllowance(ctcAllowance);
                        if (null != request.getParameter("ctctaxable" + i)) {
                            employeeCtcDetail.setStatus(1);
                        } else {
                            employeeCtcDetail.setStatus(0);
                        }
                        employeeCtcDetail.setMonth(month);
                        employeeCtcDetail.setYear(year);
                        employeeCtcDetailService.create(employeeCtcDetail);
                    }
                }
            }
            //End
            //Code for Payroll Provident
            int empId = employeeMaster.getEmployeeTypeMaster().getId();
            int empSubId = employeeMaster.getEmployeeSubType().getId();
            EmployeeTypeMaster employeeTypeMaster = new EmployeeTypeMaster();
            employeeTypeMaster.setId(empId);
            EmployeeSubType employeeSubTypeMaster = new EmployeeSubType();
            employeeSubTypeMaster.setId(empSubId);
            Boolean pfCheck = payrollPfCheckService.isExistPF(empId, empSubId);
            if (!pfCheck) {
                PayrollPfCheck payrollPfCheck = new PayrollPfCheck();
                payrollPfCheck.setEmployeeSubType(employeeSubTypeMaster);
                payrollPfCheck.setEmployeeTypeMaster(employeeTypeMaster);
                if (null != request.getParameter("pf")) {
                    if (!request.getParameter("pf").equals("")) {
                        if (request.getParameter("pf").equals("true")) {
                            payrollPfCheck.setPfCheck(true);
                        } else {
                            payrollPfCheck.setPfCheck(false);
                        }
                        payrollPfCheckService.create(payrollPfCheck);
                    }
                }
            }
            Boolean ptCheck = payrollPtCheckService.isExistPT(empId, empSubId);
            if (!ptCheck) {
                PayrollPtCheck payrollPtCheck = new PayrollPtCheck();
                payrollPtCheck.setEmployeeSubType(employeeSubTypeMaster);
                payrollPtCheck.setEmployeeTypeMaster(employeeTypeMaster);
                if (null != request.getParameter("pt")) {
                    if (!request.getParameter("pt").equals("")) {
                        if (request.getParameter("pt").equals("true")) {
                            payrollPtCheck.setPtCheck(true);
                        } else {
                            payrollPtCheck.setPtCheck(false);
                        }
                        payrollPtCheckService.create(payrollPtCheck);
                    }
                }
            }
            //End

            MprApprovalHistory mprApprovalHistory = new MprApprovalHistory();
            SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
            Date cDate = new Date();
            EmployeeMaster employeeMaster5225 = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
            mprApprovalHistory.setApprovalUserId(employeeMaster5225.getId());
            mprApprovalHistory.setApprovalUserName(employeeMaster5225.getEmployeeName());
            mprApprovalHistory.setStatus(11);
            mprApprovalHistory.setComment("Induction");
            mprApprovalHistory.setStatusMessage("Induction");
            mprApprovalHistory.setCreateDate(sdf2.format(cDate));
            mprApprovalHistory.setCreatedBy(employeeMaster.getId());
            mprApprovalHistory.setApplicationId(Integer.parseInt(applicationId));
            mprApprovalHistoryService.create(mprApprovalHistory);

            PmpFormStatusMaster pmpFormStatusMaster = new PmpFormStatusMaster();
            pmpFormStatusMaster.setEmployeeMaster(employeeMaster);
            pmpFormStatusMaster.setStartYearStatus(false);
            pmpFormStatusMaster.setMidYearStatus(false);
            pmpFormStatusMaster.setEndYearStatus(false);
            pmpFormStatusMaster.setManagerSide(false);
            pmpFormStatusMaster.setEmployeeSide(false);
            pmpFormStatusMaster.setCompentencyEmployeeSide(false);
            pmpFormStatusMaster.setCompentencyEndYearStatus(false);
            pmpFormStatusMaster.setCompentencyManagerSide(false);
            pmpFormStatusMaster.setCompentencyMidYearStatus(false);
            pmpFormStatusMaster.setCompentencyStartYearStatus(false);
            pmpFormStatusMasterService.create(pmpFormStatusMaster);

            //employeeMaster.setEmployeeId("" + employeeMaster1);
            boolean isLeapYear = false;
            LeaveTypeMaster leaveTypeMaster = new LeaveTypeMaster();
            List<?> leaveType = leaveTypeMasterService.read();
            final boolean gender_Female = employeeMaster.getGender();
            String marital_status = employeeMaster.getMaritalStatus();
            for (Object o : leaveType) {
                employeeLeaveBalance = new EmployeeLeaveBalance();
                leaveTypeMaster = (LeaveTypeMaster) o;
                employeeLeaveBalance.setLeaveTypeMaster(leaveTypeMaster);
                employeeLeaveBalance.setEmployeeMaster(employeeMaster);
                String noOfLeave = "" + leaveTypeMaster.getNoOfLeave();
                String leave = "" + leaveTypeMaster.getLeaveType();
                Calendar cal1 = new GregorianCalendar();
                Calendar cal2 = new GregorianCalendar();
                Calendar gc = new GregorianCalendar();
                int year = gc.get(Calendar.YEAR);
                String cyear = "" + year;
                String dateOfEndMonth = "31/12/";
                String dateOfEnd = dateOfEndMonth + cyear;
                if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
                    isLeapYear = true;
                }
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

                Date date1 = sdf.parse(dateOfJoining);
                Date date3 = new Date();
                cal1.setTime(date1);
                Date date2 = sdf.parse(dateOfEnd);
                cal2.setTime(date2);
                int y = Integer.parseInt(noOfLeave);
                long days = 0;
                if (date1.before(date3)) {
                    days = date2.getTime() - date3.getTime();
                } else {
                    days = date2.getTime() - date1.getTime();
                }
                long diffDays = days / (24 * 60 * 60 * 1000) + 1;
                if (leave.equals("Sick Leave")) {
                    if (isLeapYear == true) {
                        long SL = (diffDays * y / 366) + 1;
                        employeeLeaveBalance.setNoOfLeaveRemain(SL);
                    } else {
                        long SL = (diffDays * y / 365) + 1;
                        employeeLeaveBalance.setNoOfLeaveRemain(SL);
                    }
                } else if (leave.equals("Casual Leave")) {
                    if (isLeapYear == true) {
                        long CL = (diffDays * y / 366) + 1;
                        employeeLeaveBalance.setNoOfLeaveRemain(CL);
                    } else {
                        long CL = (diffDays * y / 365) + 1;
                        employeeLeaveBalance.setNoOfLeaveRemain(CL);
                    }
                } //                else if (leave.equals("Privilege Leave")) {
                //                    if (isLeapYear == true) {
                //                        long PL = (diffDays * y / 366) + 1;
                //                        employeeLeaveBalance.setNoOfLeaveRemain(PL);
                //                    } else {
                //                        long PL = (diffDays * y / 365) + 1;
                //                        employeeLeaveBalance.setNoOfLeaveRemain(PL);
                //                    }
                //                }
                else if (leave.equals("Paternity Leave") && !gender_Female && marital_status.equals("Married")) {
                    if (isLeapYear == true) {
//                        long PAT = (diffDays * y / 366) + 1;
                        long PAT = 6;
                        employeeLeaveBalance.setNoOfLeaveRemain(PAT);
                    } else {
                        long PAT = 6;
                        employeeLeaveBalance.setNoOfLeaveRemain(PAT);
                    }
                } else if (leave.equals("Maternity Leave")) {
                    if (gender_Female) {
                        long ML = 0;
                        employeeLeaveBalance.setNoOfLeaveRemain(ML);
                    }
                } else if (leave.equals("Short Leave")) {
                    if (isLeapYear == true) {
                        long SHL = (diffDays * y / 366) + 1;
                        employeeLeaveBalance.setNoOfLeaveRemain(SHL);
                    } else {
                        long SHL = (diffDays * y / 365) + 1;
                        employeeLeaveBalance.setNoOfLeaveRemain(SHL);
                    }
                } else if (leave.equals("Leave Without Pay")) {
                    if (isLeapYear == true) {
                        long LWP = (diffDays * y / 366) + 1;
                        employeeLeaveBalance.setNoOfLeaveRemain(LWP);
                    } else {
                        long LWP = (diffDays * y / 365) + 1;
                        employeeLeaveBalance.setNoOfLeaveRemain(LWP);
                    }
                }

                employeeLeaveBalanceService.create(employeeLeaveBalance);

            }
            ShiftRotationInfo shiftRotationInfo = new ShiftRotationInfo();
            ShiftRotationInfo shiftRotationInfo1 = new ShiftRotationInfo();
            ShiftRotationMaster shiftRotationMaster = new ShiftRotationMaster();
//                EmployeeMaster employeeMaster = (EmployeeMaster) request.getAttribute("employeeMaster");
//                UserMaster userMaster = (UserMaster) request.getAttribute("userMaster");
//                String shiftMasterId = request.getAttribute("shiftMasterId").toString();
            if (null != shiftMasterId && !"".equals(shiftMasterId)) {

                shiftRotationInfo.setFirstShiftId(Integer.parseInt(shiftMasterId));
                shiftRotationInfo.setUserMaster(userMaster);

                List<?> list = shiftRotationInfoService.readRotaionDetail(shiftRotationInfo);
                if (!list.isEmpty()) {

                    shiftRotationInfo = (ShiftRotationInfo) list.get(0);
                }
                if (shiftRotationInfo.getId() == null) {
                    shiftRotationMaster.setId(employeeMaster.getShiftHoursId());
                    shiftRotationInfo.setShiftRotationMaster(shiftRotationMaster);
                    shiftRotationInfo.setRotationDate(employeeMaster.getShiftRotationDate());

                    shiftRotationInfoService.create(shiftRotationInfo);
                }

            }
//        Code for Shift generate monthly Schedule(Start)
//                if (employeeMaster.getShiftType().equals("ShiftBase")) {
            if ("ShiftBase".equals(employeeMaster.getShiftType())) {
                ShiftGenerateMonthlySchedule shiftGenerateMonthlySchedule = new ShiftGenerateMonthlySchedule();
                shiftGenerateMonthlySchedule.setEmployeeMaster(employeeMaster);
//                     shiftMasterId
                String shfitId = "" + request.getParameter("shiftId");
                String shiftRotationDate = "" + request.getParameter("shiftRotationDate");
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date rd = sdf.parse(shiftRotationDate);
                LocalDate localDate = rd.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                int year = localDate.getYear();
                String cyear = "" + year;
                int month = localDate.getMonthValue();
                String cmonth = "" + month;
                int dayofmonth = localDate.getDayOfMonth();
                String cdayofmonth = "" + dayofmonth;
//                     shiftGenerateMonthlySchedule.setShiftMonth(cmonth);
//                     shiftGenerateMonthlySchedule.setShiftYear(cyear);
                Calendar c = Calendar.getInstance();
                Date newDate = c.getTime();
                int tday = c.get(Calendar.DATE);
                shiftRotationMaster = shiftRotationMasterService.readById(Integer.parseInt(shfitId));
                String duration = "" + shiftRotationMaster.getDuration();
                int day = c.getActualMaximum(Calendar.DAY_OF_MONTH);
                RotationMaster rotationMaster = new RotationMaster();
                rotationMaster.setShiftRotationMaster(shiftRotationMaster);

                if ("monthly".equals(duration) && day == 30) {
                    weeklyGenerate(rotationMaster, rd, shiftRotationMaster, 30, employeeMaster, shiftMasterId);
                } else if ("weekly".equals(duration)) {
                    weeklyGenerateShift(rotationMaster, rd, shiftRotationMaster, 7, employeeMaster, shiftMasterId);
                } else if ("fortNightly".equals(duration)) {
                    weeklyGenerate(rotationMaster, rd, shiftRotationMaster, 14, employeeMaster, shiftMasterId);
                } else {
                    weeklyGenerate(rotationMaster, rd, shiftRotationMaster, day, employeeMaster, shiftMasterId);
                }
            }
//        Code for Shift generate monthly Schedule(End)

//////Make Dir///////
//            String userName = (String) request.getSession().getAttribute("userName");
            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "UserProfile"
                    + File.separator + userName + File.separator;
            //String basePath = getServletContext().getRealPath("/") + "StorageYard" + File.separator + "DigitalSignature" + File.separator + userName + File.separator;
            File profilePictureFile = new File(fileLocationURL);//file directory
//                File profilePicture = profilePictureFile.listFiles()[0];//First File Of Directory.
            if (profilePictureFile.exists() && profilePictureFile.listFiles().length > 0) {
                File[] profilePictureArray = profilePictureFile.listFiles();
                try {
                    request.setAttribute("imageFile", "StorageYard" + File.separator + "UserProfile" + File.separator + userName + File.separator + profilePictureArray[0].getName().replaceAll(" ", ""));
                } catch (Exception e) {
                }
            }
//                String fileLocationURL1 = getServletContext().getRealPath("")
//                        + File.separator + "StorageYard" + File.separator + "DigitalSignature"
//                        + File.separator + userName + File.separator;
            if (profilePictureFile.exists() && profilePictureFile.listFiles().length > 0) {
                File[] profilePictureArray = profilePictureFile.listFiles();
                profilePictureArray[0].delete();//if file exist then delete it.
            }

            if (!profilePictureFile.exists()) {
                profilePictureFile.mkdir();//make directory for first time user creation.
            }
            //File Photo Uploard///
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            ////this code is using loop but there is actually only one image so changed for only single file
//                String url = "";
//                List<MultipartFile> multipartFile2 = multipartRequest.getFiles("photograph");
//                for (MultipartFile multipartFile1 : multipartFile2) {
//                    if (multipartFile1.getSize() > 0) {
//                        File file2 = new File(fileLocationURL + File.separator
//                                + multipartFile1.getOriginalFilename());
//                        url = fileLocationURL + File.separator + multipartFile1.getOriginalFilename();
//                        multipartFile1.transferTo(file2);
//                    }
//                }
            ////this is changed code for only one file.
            MultipartFile multipartFile = multipartRequest.getFile("photograph");
            if (multipartFile != null && multipartFile.getSize() > 0) {
                //null if there is no photograph in form.
                //this condition checking not required if photograph field is compulsary in form.
                try {

                    File file2 = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", ""));
                    multipartFile.transferTo(file2);
                } catch (Exception e) {

                }
            }

//            Certificate attach code
            String certificateFileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "UserCertificate"
                    + File.separator + userName + File.separator;
            File certificateListFile = new File(certificateFileLocationURL);
            if (certificateListFile.exists() && certificateListFile.listFiles().length > 0) {
                File[] certificateListFileArray = certificateListFile.listFiles();
                try {
                    request.setAttribute("imageFile", "StorageYard" + File.separator + "UserCertificate" + File.separator + userName + File.separator + certificateListFileArray[0].getName().replaceAll(" ", ""));
                } catch (Exception e) {
                }
            }
            if (!certificateListFile.exists()) {
                certificateListFile.mkdir();
            }
            String firstStepCount = request.getParameter("firstStepCount");
            for (int i = 1; i <= Integer.parseInt(firstStepCount); i++) {

//                String certificateId = request.getParameter("certificateId" + i);
                MultipartFile multipartFile1 = multipartRequest.getFile("certificateId" + i);
                if (multipartFile1 != null && multipartFile1.getSize() > 0) {
                    try {
                        File file3 = new File(certificateFileLocationURL + multipartFile1.getOriginalFilename().replaceAll(" ", ""));
                        multipartFile1.transferTo(file3);
                    } catch (Exception e) {

                    }
                }

            }

//            Certificate attach code
            //now setting default right as employee.
            setDefaultUserRights(request, employeeMaster);

            request.setAttribute("successMessage",
                    "Information : The Information Is Saved Successfully."
                    + "<br/>"
                    + "You Must Provide UserRights For Allow Successfull Login Of Newly Registered User.");
//            } else {
//                request.setAttribute("failureMessage",
//                        "Error : The Entered Information is not valid.");
//
//            }
            int userMasterId = 0;
            if (employeeMaster.getUserMaster() != null) {
                userMasterId = employeeMaster.getUserMaster().getId();
            }
            try {
                EmailTemplate emailTemplate = new EmailTemplate();
                // id 138 is for Newly Registered User....
                emailTemplate = emailTemplateService.readById(138);
                String To = employeeMaster.getOfficeEmailId();
                String from = "";
                String Subject = emailTemplate.getSubject();
//                Subject = Subject.replaceAll("\\{user\\}", employeeMasterModel.getEmployeeName());
                String msg = emailTemplate.getBodytext();
                msg = msg.replaceAll("\\{user\\}", employeeMaster.getEmployeeName());
                msg = msg.replaceAll("\\{user_id\\}", userMaster.getUserName());
                msg = msg.replaceAll("\\{user_pwd\\}", userMaster.getPassword());
//                msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
//                msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                sendMail.sendMail(from, To, Subject, msg);
            } catch (Exception e) {
            }
            mv.setViewName("forward:userRightMaster.htm?act=createClickInduction&id=" + String.valueOf(userMasterId));
        } else {
            request.setAttribute("failureMessage",
                    "Error : User isExist.");
            mv.addAllObjects(errors.getModel());
            mv.setViewName("Employee/EmployeeInductionForm");

        }
//            mv.getModelMap().put("userMaster", userMaster);
//            mv.getModelMap().put("shiftMasterId", shiftMasterId);
//            if (employeeMaster.getShiftType().equals("ShiftBase")) {
//
//                mv.setViewName("forward:shiftRotationInfo.htm?act=createSubmit");
//            } else {
//
//                mv.setViewName("Employee/EmployeeRegistrationForm");
//            }
        mv.getModelMap().put("employeeMaster", employeeMaster);
        return mv;*/
    
        ModelAndView mv = new ModelAndView();
//        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeLeaveBalance employeeLeaveBalance;
//        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        EmployeeSubType employeeSubType = new EmployeeSubType();
        BindException errors = new BindException(employeeMaster, "employeeMaster");
        UserMaster userMaster = new UserMaster();
        EmployeeMasterExtension employeeMasterExtension = new EmployeeMasterExtension();
        StringBuffer employeeMasterErrorStrBuf = new StringBuffer();
        //int indexCount = 1;
        
        //*************employee extension**************//
        String presentAddress2 = request.getParameter("presentAddress2");
        String presentCity = request.getParameter("presentCity");
        String presentState = request.getParameter("presentState");
        String presentPostalCode = request.getParameter("presentPostalCode");
        String presentCountry = request.getParameter("presentCountry");
        String permanentAddress2 = request.getParameter("permanentAddress2");
        String permanentCity = request.getParameter("permanentCity");
        String permanentState = request.getParameter("permanentState");
        String permanentPostalCode = request.getParameter("permanentPostalCode");
        String permanentCountry = request.getParameter("permanentCountry");
//         String religion=request.getParameter("religion");
        String disclosedHealthConcerns = request.getParameter("disclosedHealthConcerns");
        String languagesKnown = request.getParameter("languagesKnown");
        String hobbies = request.getParameter("hobbies");
        String childOneGender = request.getParameter("childOneGender");
        String childTwoGender = request.getParameter("childTwoGender");
        String flyDocsEmailId = request.getParameter("flyDocsEmailId");
        String emergencyContactAddress = request.getParameter("emergencyContactAddress");
        String RelationShip = request.getParameter("RelationShip");
        String otherImpInfo = request.getParameter("otherImpInfo");
        String nationality = request.getParameter("nationality");
        String firstName = request.getParameter("firstName");
        String middleName = request.getParameter("middleName");
        String lastName = request.getParameter("lastName");
//         String countryOfIssue=request.getParameter("countryOfIssue");

        String drivingLicenceType = request.getParameter("drivingLicenceType");
//         String electionCard=request.getParameter("electionCard");
        String pfNoFlydocs = request.getParameter("pfNoFlydocs");
        String withdrawalDate = request.getParameter("withdrawalDate");
        String nameOfPreviousCompany = request.getParameter("nameOfPreviousCompany");
        String previousCompanyLocation = request.getParameter("previousCompanyLocation");
//         String namestatus = request.getParameter("nameStatus");
        String spousegender = request.getParameter("SpouseGender");
//         String documentIdNo = request.getParameter("documentIdNo");
        String subteamTransferDate = request.getParameter("subteamTransferDate");
        String designationMasterByLevelId = request.getParameter("designationMasterByLevelId");
//         String officialContactNumber = request.getParameter("officialContactNumber");
        // ----------------------------------------------------
        employeeMasterExtension.setNationality(nationality);
        employeeMasterExtension.setFirstName(firstName);
        employeeMasterExtension.setMiddleName(middleName);
        employeeMasterExtension.setLastName(lastName);
        employeeMasterExtension.setPresentAddress2(presentAddress2);
        employeeMasterExtension.setPermanentAddress2(permanentAddress2);
        BindException errors2 = new BindException(employeeMasterExtension, "employeeMasterExtension");
        //----------------------------------------------------
        bind(request, employeeMaster);
        //Deopdown List//
        departmentList(request);
        designationList(request);
        levelList(request);
        locationList(request);
        shiftRotaionList(request);
        hoursBasisList(request);
        setZydexLocationList(request);
        competencyList(request);
        EmployeeTypeList(request);
        EmployeeSubTypeList(request);
        companyList(request);
        policyList(request);
        ctcList(request);

        //DeowpDown list//
//        String reasonForLeaving = request.getParameter("password");
        String userName = request.getParameter("userName");
//        String password = reasonForLeaving;
        String password = "";
        String employeeSubTypeId = request.getParameter("subTypeId");
//        String gender = request.getParameter("gender");
//        String reportingManagerLevel1 = request.getParameter("reportingManagerLevel1");
//        String reportingManagerLevel2 = request.getParameter("reportingManagerLevel2");
//        String reportingManagerLevel3 = request.getParameter("reportingManagerLevel3");
//        String reportingManagerLevel4 = request.getParameter("reportingManagerLevel4");
//        String reportingManagerLevel5 = request.getParameter("reportingManagerLevel5");
//        String reportingManagerLevel6 = request.getParameter("reportingManagerLevel6");
        String dateOfJoining = request.getParameter("dateOfJoining");
        String dateOfBirth = request.getParameter("dateOfBirth");
        String shiftMasterId = request.getParameter("shiftMasterId");
//        String competencyEvaluationId = request.getParameter("competencyEvaluationId");
        userMaster.setUserName(userName);
        if (employeeMaster.getUserMaster() != null) {
            if (employeeMaster.getUserMaster().getPassword() != null) {
                password = password + employeeMaster.getUserMaster().getPassword();
                //if we directly gettting 'employeeMaster.getUserMaster().getPassword()' its possibility for nullpointer exception.
            }
        }

        userMaster.setPassword(password);
        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
        Date DOB = new Date();
        Date DOJ = new Date();
        Date DOB1 = new Date();
        if (!"".equals(dateOfJoining)) {
            DOJ = sd.parse(dateOfJoining);

        }
        if (!"".equals(dateOfBirth)) {
            DOB = sd.parse(dateOfBirth);
            Calendar c1 = Calendar.getInstance();
            c1.setTime(DOB);
            c1.add(Calendar.YEAR, 18);
            DOB1 = c1.getTime();
        }
        if (null != employeeSubTypeId && !employeeSubTypeId.equals("")) {
            employeeSubType.setId(Integer.parseInt(employeeSubTypeId));
        }
        employeeMaster.setEmployeeSubType(employeeSubType);
        //-----------
//        DesignationMaster designationMaster = new DesignationMaster();
//        designationMaster.setId(231);
//        employeeMaster.setDesignationMaster(designationMaster);
        employeeMaster.setUserMaster(userMaster);
        
        //------------------------
//        if (!userMasterService.isExist(userName) && !userName.equals("") && !password.equals("")) {
//
//            userMasterService.create(userMaster);
//        } else {
//            request.setAttribute("failureMessage",
//                    "Error : User isExist.");
//            mv.addAllObjects(errors.getModel());
//            mv.setViewName("Employee/EmployeeRegistrationForm");
//        }
        
         
        EmployeeMasterExtensionValidator employeeExtensionValidator = new EmployeeMasterExtensionValidator();
        
        employeeMasterValidator.validate(employeeMaster, errors);
        employeeExtensionValidator.validate(employeeMasterExtension, errors2);
        
        if (errors.hasErrors() || errors2.hasErrors() || userMasterService.isExist(userName)) {
            //------------------ Get Policy detail data and display in jsp -----------------
             //Code to fetch policy details IN VIEW CLICK
            List finalPolicyList = new ArrayList();
  
            //Code for Employee Policy Detail
            //EmployeePolicyDetail employeePolicyDetail = new EmployeePolicyDetail();
            int otherDetailCount = Integer.parseInt(request.getParameter("policyCount"));
            for (int i = 1; i <= otherDetailCount; i++) {
                PolicyMaster policyMaster2 = new PolicyMaster();
                if (null != request.getParameter("policyId" + i) && null != request.getParameter("amount" + i)) {
                    if (!request.getParameter("policyId" + i).equals("") && !request.getParameter("amount" + i).equals("")) {
                        int policyId = Integer.parseInt(request.getParameter("policyId" + i));
                        policyMaster2 = policyMasterService.readById(policyId);
                        
                        List policyList = new ArrayList();
                        Double amount = Double.valueOf(request.getParameter("amount" + i));
                        
                        policyList.add(policyId);
                        policyList.add(policyMaster2.getPolicyName());
                        policyList.add(null);
                        policyList.add(amount);
                        if (null != request.getParameter("taxable" + i)) {
                            policyList.add(1);
                        } else {
                            policyList.add(0);
                        }
                        policyList.add(0);
                        finalPolicyList.add(policyList);
                   }
                }
            }
        
            request.setAttribute("finalPolicyList",finalPolicyList);  
            //------------------- End of Section policy ID --------------------
            //------------------ Start of total ctc section -------------------
            List finalctcList = new ArrayList();
            
             //Code for Employee ctc Detail
            EmployeeCtcDetail employeeCtcDetail = new EmployeeCtcDetail();
            int otherDetailCount1 = Integer.parseInt(request.getParameter("ctcCount"));
            for (int i = 1; i <= otherDetailCount1; i++) {
                CtcAllowance ctcAllowance2 = new CtcAllowance();
                if (null != request.getParameter("ctcId" + i) && null != request.getParameter("ctcamount" + i)) {
                    if (!request.getParameter("ctcId" + i).equals("") && !request.getParameter("ctcamount" + i).equals("")) {
                        int ctcId = Integer.parseInt(request.getParameter("ctcId" + i));
                        Double amount = Double.valueOf(request.getParameter("ctcamount" + i));
                        String month = request.getParameter("month" + i);
                        String year = request.getParameter("year" + i);
//                        String policyNumber = request.getParameter("policyNumber" + i);
                        
                        /*employeeCtcDetail.setEmployeeMaster(employeeMaster);
                        employeeCtcDetail.setAmount(amount);
                        employeeCtcDetail.setCtcAllowance(ctcAllowance);
                        if (null != request.getParameter("taxable" + i)) {
                            employeeCtcDetail.setStatus(1);
                        } else {
                            employeeCtcDetail.setStatus(0);
                        }
                        employeeCtcDetail.setMonth(month);
                        employeeCtcDetail.setYear(year);*/
                        
                        List ctcList = new ArrayList();
                        ctcList.add(ctcId);
                        ctcAllowance2 = ctcAllowanceService.readById(ctcId);
                        
                        ctcList.add(ctcAllowance2.getCtcName());
                        ctcList.add(amount);
                        if (null != request.getParameter("taxablectc" + i)) {
                            ctcList.add(1);
                        } else {
                            ctcList.add(0);
                        }
                        ctcList.add(month);
                        ctcList.add(year);
                        
                        ctcList.add(0);
                        finalctcList.add(ctcList);
                    }
                }
            }
            request.setAttribute("finalctcList",finalctcList);  
            //----------------- End of total ctc function ---------------------
            String shiftId = request.getParameter("shiftId");
            String shiftMasterId1 = request.getParameter("shiftMasterId");
            String HoursTitle = request.getParameter("shiftHoursId");
            //-------------------------------
            for (ObjectError individualError : errors2.getAllErrors()) {  
                String errorMsg = individualError.getCode();
                //request.setAttribute("failureMessage", " <br/> Employee No:"+ employeeNo + " Error Description : " + errorMsg );
                employeeMasterErrorStrBuf.append("<br/> - " + errorMsg);
                
                request.setAttribute(errorMsg.substring(0, 4), " - " + errorMsg);
            }
            //-------------------------------
//            *********************************************************************************
            if (!"".equals(shiftId) && shiftId != null) {
                employeeMaster.setShiftHoursId(Integer.parseInt(shiftId));
            } else if (!"".equals(HoursTitle) && HoursTitle != null) {
                employeeMaster.setShiftHoursId(Integer.parseInt(HoursTitle));
            }

//            employeeMaster.setShiftHoursId(Integer.parseInt(shiftId));
//           above line is commented because it produces "NumberFormatException" while we submits blank page
//            By Irfan
            
//         **********************************************************************************
            // Image presistance code -----------------
            /*String fileLocationURL = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "UserProfile"
                + File.separator + userMaster.getUserName() + File.separator;
            File photoFile = new File(fileLocationURL);
            //only single file always in it and all others will be deleted
            if (photoFile.exists() && photoFile.listFiles().length > 0) {
                File[] allPhotoes = photoFile.listFiles();
                if (allPhotoes.length == 1) {
                    allPhotoes[0].delete();
                }
            }
            //if no any directory with url available so new directory is created \\
            //But it will not happen because directory is created when user created First time time.
            if (!photoFile.exists()) {
                photoFile.mkdir();
            }
            MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
            MultipartFile multipartFile = multipartHttpServletRequest.getFile("photograph");
      
            //HttpSession session = request.getSession();
            File updatedPicture = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", ""));
            */
            
             String fileLocationURL = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "UserProfile"
                + File.separator + userName + File.separator;
             
                File photoFile = new File(fileLocationURL);
                //only single file always in it and all others will be deleted
                if (photoFile.exists() && photoFile.listFiles().length > 0) {
                    File[] allPhotoes = photoFile.listFiles();
                    if (allPhotoes.length == 1) {
                       // allPhotoes[0].delete();
                    }
                }
                //if no any directory with url available so new directory is created \\
                //But it will not happen because directory is created when user created First time time.
                if (!photoFile.exists()) {
                    photoFile.mkdir();
                }
                //MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
//                MultipartFile multipartFile = multipartHttpServletRequest.getFile("photographUpdate");
//
//                //HttpSession session = request.getSession();
//                File updatedPicture = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", ""));
//                multipartFile.transferTo(updatedPicture);

                if (photoFile.exists() && photoFile.listFiles().length > 0) {
                    File[] updatedPictureFiles = photoFile.listFiles();
                
                    request.setAttribute("imgFile", "StorageYard" + File.separator + "UserProfile" + File.separator + userName + File.separator + updatedPictureFiles[0].getName());
                }
            //----------------------------------------
            //--------------------
            request.setAttribute("presentAddress2",presentAddress2);  
            request.setAttribute("presentCity",presentCity); 
            request.setAttribute("presentState",presentCity); 
            request.setAttribute("presentPostalCode",presentCity); 
            request.setAttribute("presentCountry",presentCity); 
            request.setAttribute("permanentAddress2",permanentAddress2);
            request.setAttribute("permanentCity",presentCity); 
            request.setAttribute("permanentState",presentCity); 
            request.setAttribute("permanentPostalCode",presentCity); 
            request.setAttribute("permanentCountry",permanentCountry);
            request.setAttribute("disclosedHealthConcerns",disclosedHealthConcerns);
            request.setAttribute("languagesKnown",languagesKnown);
            request.setAttribute("hobbies",hobbies);
            request.setAttribute("flyDocsEmailId",flyDocsEmailId);  
            request.setAttribute("emergencyContactAddress",emergencyContactAddress);        
            request.setAttribute("RelationShip",RelationShip);      
            request.setAttribute("otherImpInfo",otherImpInfo);      
            request.setAttribute("previousCompanyLocation",previousCompanyLocation);        
            request.setAttribute("SpouseGender",spousegender);      
            request.setAttribute("subteamTransferDate",subteamTransferDate);        
            request.setAttribute("nationality",nationality);
            request.setAttribute("firstName",firstName);
            request.setAttribute("middleName",middleName);
            request.setAttribute("lastName",lastName);
            request.setAttribute("pfNoFlydocs",pfNoFlydocs);
            request.setAttribute("withdrawalDate",withdrawalDate);
            request.setAttribute("nameOfPreviousCompany",nameOfPreviousCompany);
            
            request.setAttribute("failureMessageExtension", employeeMasterErrorStrBuf);
            request.setAttribute("shiftName", shiftMasterId1);
            request.setAttribute("designationMasterByLevelId",designationMasterByLevelId);
            //----------
            //request.setAttribute("photographpresist",updatedPicture);
             //-----------
//            request.setAttribute("competencyEvaluationId", competencyEvaluationId);
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            if(userMasterService.isExist(userName))
            {
                request.setAttribute("failureMessage",
                    "Error : User is Exist!");
            }
                    
            mv.addAllObjects(errors.getModel());
            //mv.addAllObjects(errors2.getModel());
            selectEmployee(request, response);
            
            designationList(request);
            selectedEmployeeLevel1(request, employeeMaster);
//            request.setAttribute("employeeMaster", employeeMaster);
            mv.getModelMap().put("employeeMaster", employeeMaster);
            mv.setViewName("Employee/EmployeeRegistrationForm");
        } //        else if (DOJ.before(DOB1)) {
        //            request.setAttribute("failureMessage",
        //                    "Error : Enter Valid Date of Joining");
        //
        //            selectEmployee(request, response);
        //            selectedEmployeeLevel1(request, employeeMaster);
        //            request.setAttribute("employeeMaster", employeeMaster);
        //            mv.setViewName("Employee/EmployeeRegistrationForm");
        //        }
        else if (!userMasterService.isExist(userName) && !userName.equals("") && !"".equals(password)) {
            
            // Shifted following code from above error validation to after validation
            if (!userName.isEmpty()) {
                if (!employeeMasterService.isExistUSername(userName)) {
                    if (userMasterService.isExist(userName)) {
                        userMaster.setUserName(userName);
                        List<?> tempList = userMasterService.read(userMaster);
                        UserMaster user2;
                        user2 = (UserMaster) tempList.get(0);
                        userMasterService.delete(user2.getId());
                    }
                }
            }
            
            
//            if (!password.equals("")) {
//                if (employeeMaster.getShiftType().equals("HourlyBase")) {
            if ("HourlyBase".equals(employeeMaster.getShiftType())) {
                String hoursId = request.getParameter("shiftHoursId");
                if (null != hoursId && !hoursId.equals("")) {
                    employeeMaster.setShiftHoursId(Integer.parseInt(hoursId));
                }
            }
//                if (employeeMaster.getShiftType().equals("ShiftBase")) {
            if ("ShiftBase".equals(employeeMaster.getShiftType())) {
                String shfitId = request.getParameter("shiftId");
                if (null != shfitId && !shfitId.equals("")) {
                    employeeMaster.setShiftHoursId(Integer.parseInt(shfitId));
                }
            }

            // employee Code automically Generate 
            int employeeLoactionCode = employeeMaster.getLocationMaster().getId();
            LocationMaster ltm = locationMasterService.readById(employeeLoactionCode);
            String locationCode = ltm.getLocationCode();
            String empCodeString = "";
            SimpleDateFormat sdf11 = new SimpleDateFormat("dd/MM/yyyy");
            Date cDate = new Date();
//        approvalMaster.setCreatedBy(approvalMaster1);
            String CureentDate = sdf11.format(cDate);
            String[] endDateSplited = CureentDate.split("/");
            String empFormat = "";
            String month122 = endDateSplited[1];
            String year122 = endDateSplited[2];

//            List<?> empCodeList = employeeMasterService.readEmployeeCodeAutoGenerate();
//            Object[] codeList = (Object[]) empCodeList.get(0);
//            String oldempCode = codeList[1].toString();
//            String[] oldempCodeSplited = oldempCode.split("/");
//            String oldempcodesplit = oldempCodeSplited[4];
//            empCodeString = "SPCLS" + "/" + year122 + "/" + month122 + "/" + locationCode + "/" + (Integer.parseInt(oldempcodesplit) + 1);
//
//            employeeMaster.setAutoGenerationCode(empCodeString);
//            employeeMaster.setCompetencyEvaluationId(Integer.parseInt(competencyEvaluationId));
            // employeeMaster.setId(userMaster.getId());
            employeeMaster.setUserMaster(userMaster);
//                employeeMaster.setReportingManagerLevel1(reportingManagerLevel1);
//                employeeMaster.setReportingManagerLevel2(reportingManagerLevel2);
//                employeeMaster.setReportingManagerLevel3(reportingManagerLevel3);
//                employeeMaster.setReportingManagerLevel4(reportingManagerLevel4);
//                employeeMaster.setReportingManagerLevel5(reportingManagerLevel5);
//                employeeMaster.setReportingManagerLevel6(reportingManagerLevel6);
            employeeMaster.setPanCard(String.valueOf(employeeMaster.getPanCard()).toUpperCase());//this is for store pan card in uppercase in database.
            userMaster.setFirstTime(true);
//set firstTime is true for compulsory password change on first time login
            userMasterService.create(userMaster);
            String companyId = "4";

            employeeMaster.setCompany(companyId);
            
            String zid = "10";
            ZydexLocationMaster zydexLocationMaster = new ZydexLocationMaster();
            zydexLocationMaster.setId(Integer.parseInt(zid));
            employeeMaster.setZydexLocationMaster(zydexLocationMaster);
            employeeMasterService.create(employeeMaster);

            //***********employeeextension create*****************//
            employeeMasterExtension.setChildOneGender(Boolean.valueOf(childOneGender));
            employeeMasterExtension.setChildTwoGender(Boolean.valueOf(childTwoGender));
//            employeeMasterExtension.setNameStatus(Boolean.valueOf(namestatus));
            employeeMasterExtension.setSpouseGender(Boolean.valueOf(spousegender));
            employeeMasterExtension.setPresentAddress2(presentAddress2);
            employeeMasterExtension.setPresentCity(presentCity);
            employeeMasterExtension.setPresentState(presentState);
            employeeMasterExtension.setPresentPostalCode(presentPostalCode);
            employeeMasterExtension.setPresentCountry(presentCountry);
            employeeMasterExtension.setPermanentAddress2(permanentAddress2);
            employeeMasterExtension.setPermanentCity(permanentCity);
            employeeMasterExtension.setPermanentCountry(permanentCountry);
            employeeMasterExtension.setPermanentPostalCode(permanentPostalCode);
            employeeMasterExtension.setPermanentState(permanentState);
//            employeeMasterExtension.setReligion(religion);
            employeeMasterExtension.setDisclosedHealthConcerns(disclosedHealthConcerns);
            employeeMasterExtension.setLanguagesKnown(languagesKnown);
            employeeMasterExtension.setHobbies(hobbies);
            employeeMasterExtension.setFlyDocsEmailId(flyDocsEmailId);
            employeeMasterExtension.setEmergencyContactAddress(emergencyContactAddress);
            employeeMasterExtension.setOtherImpInfo(otherImpInfo);
            employeeMasterExtension.setRelationShip(RelationShip);
            employeeMasterExtension.setNationality(nationality);
            employeeMasterExtension.setFirstName(firstName);
            employeeMasterExtension.setMiddleName(middleName);
            employeeMasterExtension.setLastName(lastName);
//            employeeMasterExtension.setCountryOfIssue(countryOfIssue);
//                employeeMasterExtension.setVisaIssueCountry(visaIssueCountry);
//                employeeMasterExtension.setVisaIssueDate(visaIssueDate);
//                employeeMasterExtension.setVisaValidTillDate(visaValidTillDate);
            employeeMasterExtension.setDrivingLicenceType(drivingLicenceType);
//                employeeMasterExtension.setElectionCard(electionCard);
            employeeMasterExtension.setPfNoFlydocs(pfNoFlydocs);
            employeeMasterExtension.setWithdrawalDate(withdrawalDate);
            employeeMasterExtension.setNameOfPreviousCompany(nameOfPreviousCompany);
            employeeMasterExtension.setPreviousCompanyLocation(previousCompanyLocation);
//                employeeMasterExtension.setDocumentIdNo(documentIdNo);
//                employeeMasterExtension.setOfficialContactNumber(officialContactNumber);
            employeeMasterExtension.setSubteamTransferDate(subteamTransferDate);
            employeeMasterExtension.setEmployeeMaster(employeeMaster);
            employeeMasterServiceExtension.create(employeeMasterExtension);

            //***********employee visa doc create*****************//
//                int visaCount=Integer.parseInt(request.getParameter("visaCount"));
//                EmployeeVisaDetails employeeVisaDetails = new EmployeeVisaDetails();
//                for(int i = 1;i<=visaCount;i++){
//                    String visaIssueCountry=request.getParameter("visaIssueCountry"+i);
//                    String visaIssueDate=request.getParameter("visaIssueDate"+i);
//                    String visaValidTillDate=request.getParameter("visaValidTillDate"+i);
//                    employeeVisaDetails.setVisaIssueCountry(visaIssueCountry);
//                    employeeVisaDetails.setVisaIssueDate(visaIssueDate);
//                    employeeVisaDetails.setVisaValidTillDate(visaValidTillDate);
//                    employeeVisaDetails.setEmployeeMaster(employeeMaster);
//                    employeeVisaDetailsService.create(employeeVisaDetails);
//                }
            //Code for Employee Policy Detail
            EmployeePolicyDetail employeePolicyDetail = new EmployeePolicyDetail();
            int otherDetailCount = Integer.parseInt(request.getParameter("policyCount"));
            for (int i = 1; i <= otherDetailCount; i++) {
                PolicyMaster policyMaster = new PolicyMaster();
                if (null != request.getParameter("policyId" + i) && null != request.getParameter("amount" + i)) {
                    if (!request.getParameter("policyId" + i).equals("") && !request.getParameter("amount" + i).equals("")) {
                        int policyId = Integer.parseInt(request.getParameter("policyId" + i));
                        policyMaster.setId(policyId);
                        Double amount = Double.valueOf(request.getParameter("amount" + i));
                        String policyNumber = request.getParameter("policyNumber" + i);
                        employeePolicyDetail.setEmployeeMaster(employeeMaster);
                        employeePolicyDetail.setAmount(amount);
                        employeePolicyDetail.setPolicyMaster(policyMaster);
                        employeePolicyDetail.setPolicyNum(policyNumber);
                        if (null != request.getParameter("taxable" + i)) {
                            employeePolicyDetail.setStatus(1);
                        } else {
                            employeePolicyDetail.setStatus(0);
                        }
                        employeePolicyDetailService.create(employeePolicyDetail);
                    }
                }
            }
            //End
            //Code for Employee ctc Detail
            EmployeeCtcDetail employeeCtcDetail = new EmployeeCtcDetail();
            int otherDetailCount1 = Integer.parseInt(request.getParameter("ctcCount"));
            for (int i = 1; i <= otherDetailCount1; i++) {
                CtcAllowance ctcAllowance = new CtcAllowance();
                if (null != request.getParameter("ctcId" + i) && null != request.getParameter("ctcamount" + i)) {
                    if (!request.getParameter("ctcId" + i).equals("") && !request.getParameter("ctcamount" + i).equals("")) {
                        int ctcId = Integer.parseInt(request.getParameter("ctcId" + i));
                        ctcAllowance.setId(ctcId);
                        Double amount = Double.valueOf(request.getParameter("ctcamount" + i));
                        String month = request.getParameter("month" + i);
                        String year = request.getParameter("year" + i);
//                        String policyNumber = request.getParameter("policyNumber" + i);
                        employeeCtcDetail.setEmployeeMaster(employeeMaster);
                        employeeCtcDetail.setAmount(amount);
                        employeeCtcDetail.setCtcAllowance(ctcAllowance);
                        if (null != request.getParameter("taxablectc" + i)) {
                            employeeCtcDetail.setStatus(1);
                        } else {
                            employeeCtcDetail.setStatus(0);
                        }
                        employeeCtcDetail.setMonth(month);
                        employeeCtcDetail.setYear(year);
                        employeeCtcDetailService.create(employeeCtcDetail);
                    }
                }
            }
            //End

//            //Code for Payroll Provident
//            int empId = employeeMaster.getEmployeeTypeMaster().getId();
//            int empSubId = employeeMaster.getEmployeeSubType().getId();
//            EmployeeTypeMaster employeeTypeMaster = new EmployeeTypeMaster();
//            employeeTypeMaster.setId(empId);
//            EmployeeSubType employeeSubTypeMaster = new EmployeeSubType();
//            employeeSubTypeMaster.setId(empSubId);
//            Boolean pfCheck = payrollPfCheckService.isExistPF(empId, empSubId);
//            if (!pfCheck) {
//                PayrollPfCheck payrollPfCheck = new PayrollPfCheck();
//                payrollPfCheck.setEmployeeSubType(employeeSubTypeMaster);
//                payrollPfCheck.setEmployeeTypeMaster(employeeTypeMaster);
//                if (null != request.getParameter("pf")) {
//                    if (!request.getParameter("pf").equals("")) {
//                        if (request.getParameter("pf").equals("true")) {
//                            payrollPfCheck.setPfCheck(true);
//                        } else {
//                            payrollPfCheck.setPfCheck(false);
//                        }
//                        payrollPfCheckService.create(payrollPfCheck);
//                    }
//                }
//            }
//            Boolean ptCheck = payrollPtCheckService.isExistPT(empId, empSubId);
//            if (!ptCheck) {
//                PayrollPtCheck payrollPtCheck = new PayrollPtCheck();
//                payrollPtCheck.setEmployeeSubType(employeeSubTypeMaster);
//                payrollPtCheck.setEmployeeTypeMaster(employeeTypeMaster);
//                if (null != request.getParameter("pt")) {
//                    if (!request.getParameter("pt").equals("")) {
//                        if (request.getParameter("pt").equals("true")) {
//                            payrollPtCheck.setPtCheck(true);
//                        } else {
//                            payrollPtCheck.setPtCheck(false);
//                        }
//                        payrollPtCheckService.create(payrollPtCheck);
//                    }
//                }
//            }
            //End
            PmpFormStatusMaster pmpFormStatusMaster = new PmpFormStatusMaster();
            pmpFormStatusMaster.setEmployeeMaster(employeeMaster);
            pmpFormStatusMaster.setStartYearStatus(false);
            pmpFormStatusMaster.setMidYearStatus(false);
            pmpFormStatusMaster.setEndYearStatus(false);
            pmpFormStatusMaster.setManagerSide(false);
            pmpFormStatusMaster.setEmployeeSide(false);
            pmpFormStatusMaster.setCompentencyEmployeeSide(false);
            pmpFormStatusMaster.setCompentencyEndYearStatus(false);
            pmpFormStatusMaster.setCompentencyManagerSide(false);
            pmpFormStatusMaster.setCompentencyMidYearStatus(false);
            pmpFormStatusMaster.setCompentencyStartYearStatus(false);
            pmpFormStatusMasterService.create(pmpFormStatusMaster);

            //employeeMaster.setEmployeeId("" + employeeMaster1);
            boolean isLeapYear = false;
            LeaveTypeMaster leaveTypeMaster = new LeaveTypeMaster();
            List<?> leaveType = leaveTypeMasterService.read();
            final boolean gender_Female = employeeMaster.getGender();
            String marital_status = employeeMaster.getMaritalStatus();
            for (Object o : leaveType) {
                employeeLeaveBalance = new EmployeeLeaveBalance();
                leaveTypeMaster = (LeaveTypeMaster) o;
                employeeLeaveBalance.setLeaveTypeMaster(leaveTypeMaster);
                employeeLeaveBalance.setEmployeeMaster(employeeMaster);
                String noOfLeave = "" + leaveTypeMaster.getNoOfLeave();
                String leave = "" + leaveTypeMaster.getLeaveType();
                Calendar cal1 = new GregorianCalendar();
                Calendar cal2 = new GregorianCalendar();
                Calendar gc = new GregorianCalendar();
                int year = gc.get(Calendar.YEAR);
                String cyear = "" + year;
                String dateOfEndMonth = "31/12/";
                String dateOfEnd = dateOfEndMonth + cyear;
                if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
                    isLeapYear = true;
                }
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

                Date date1 = sdf.parse(dateOfJoining);
                Date date3 = new Date();
                cal1.setTime(date1);
                Date date2 = sdf.parse(dateOfEnd);
                cal2.setTime(date2);
                int y = Integer.parseInt(noOfLeave);
                long days = 0;
                if (date1.before(date3)) {
                    days = date2.getTime() - date3.getTime();
                } else {
                    days = date2.getTime() - date1.getTime();
                }
                long diffDays = days / (24 * 60 * 60 * 1000) + 1;
                if (leave.equals("Sick Leave")) {
                    if (isLeapYear == true) {
                        long SL = (diffDays * y / 366) + 1;
                        employeeLeaveBalance.setNoOfLeaveRemain(SL);
                    } else {
                        long SL = (diffDays * y / 365) + 1;
                        employeeLeaveBalance.setNoOfLeaveRemain(SL);
                    }
                } else if (leave.equals("Casual Leave")) {
                    if (isLeapYear == true) {
                        long CL = (diffDays * y / 366) + 1;
                        employeeLeaveBalance.setNoOfLeaveRemain(CL);
                    } else {
                        long CL = (diffDays * y / 365) + 1;
                        employeeLeaveBalance.setNoOfLeaveRemain(CL);
                    }
                } //                else if (leave.equals("Privilege Leave")) {
                //                    if (isLeapYear == true) {
                //                        long PL = (diffDays * y / 366) + 1;
                //                        employeeLeaveBalance.setNoOfLeaveRemain(PL);
                //                    } else {
                //                        long PL = (diffDays * y / 365) + 1;
                //                        employeeLeaveBalance.setNoOfLeaveRemain(PL);
                //                    }
                //                }
                else if (leave.equals("Paternity Leave") && !gender_Female && marital_status.equals("Married")) {
                    if (isLeapYear == true) {
//                        long PAT = (diffDays * y / 366) + 1;
                        long PAT = 6;
                        employeeLeaveBalance.setNoOfLeaveRemain(PAT);
                    } else {
                        long PAT = 6;
                        employeeLeaveBalance.setNoOfLeaveRemain(PAT);
                    }
                } else if (leave.equals("Maternity Leave")) {
                    if (gender_Female) {
                        long ML = 0;
                        employeeLeaveBalance.setNoOfLeaveRemain(ML);
                    }
                } else if (leave.equals("Short Leave")) {
                    if (isLeapYear == true) {
                        long SHL = (diffDays * y / 366) + 1;
                        employeeLeaveBalance.setNoOfLeaveRemain(SHL);
                    } else {
                        long SHL = (diffDays * y / 365) + 1;
                        employeeLeaveBalance.setNoOfLeaveRemain(SHL);
                    }
                } else if (leave.equals("Leave Without Pay")) {
                    if (isLeapYear == true) {
                        long LWP = (diffDays * y / 366) + 1;
                        employeeLeaveBalance.setNoOfLeaveRemain(LWP);
                    } else {
                        long LWP = (diffDays * y / 365) + 1;
                        employeeLeaveBalance.setNoOfLeaveRemain(LWP);
                    }
                }

                employeeLeaveBalanceService.create(employeeLeaveBalance);

            }
            ShiftRotationInfo shiftRotationInfo = new ShiftRotationInfo();
            ShiftRotationInfo shiftRotationInfo1 = new ShiftRotationInfo();
            ShiftRotationMaster shiftRotationMaster = new ShiftRotationMaster();
//                EmployeeMaster employeeMaster = (EmployeeMaster) request.getAttribute("employeeMaster");
//                UserMaster userMaster = (UserMaster) request.getAttribute("userMaster");
//                String shiftMasterId = request.getAttribute("shiftMasterId").toString();
            if (null != shiftMasterId && !"".equals(shiftMasterId)) {

                shiftRotationInfo.setFirstShiftId(Integer.parseInt(shiftMasterId));
                shiftRotationInfo.setUserMaster(userMaster);

                List<?> list = shiftRotationInfoService.readRotaionDetail(shiftRotationInfo);
                if (!list.isEmpty()) {

                    shiftRotationInfo = (ShiftRotationInfo) list.get(0);
                }
                if (shiftRotationInfo.getId() == null) {
                    shiftRotationMaster.setId(employeeMaster.getShiftHoursId());
                    shiftRotationInfo.setShiftRotationMaster(shiftRotationMaster);
                    shiftRotationInfo.setRotationDate(employeeMaster.getShiftRotationDate());

                    shiftRotationInfoService.create(shiftRotationInfo);
                }

            }
//        Code for Shift generate monthly Schedule(Start)
//                if (employeeMaster.getShiftType().equals("ShiftBase")) {
            if ("ShiftBase".equals(employeeMaster.getShiftType())) {
                ShiftGenerateMonthlySchedule shiftGenerateMonthlySchedule = new ShiftGenerateMonthlySchedule();
                shiftGenerateMonthlySchedule.setEmployeeMaster(employeeMaster);
//                     shiftMasterId
                String shfitId = "" + request.getParameter("shiftId");
                String shiftRotationDate = "" + request.getParameter("shiftRotationDate");
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date rd = sdf.parse(shiftRotationDate);
                LocalDate localDate = rd.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                int year = localDate.getYear();
                String cyear = "" + year;
                int month = localDate.getMonthValue();
                String cmonth = "" + month;
                int dayofmonth = localDate.getDayOfMonth();
                String cdayofmonth = "" + dayofmonth;
//                     shiftGenerateMonthlySchedule.setShiftMonth(cmonth);
//                     shiftGenerateMonthlySchedule.setShiftYear(cyear);
                Calendar c = Calendar.getInstance();
                Date newDate = c.getTime();
                int tday = c.get(Calendar.DATE);
                shiftRotationMaster = shiftRotationMasterService.readById(Integer.parseInt(shfitId));
                String duration = "" + shiftRotationMaster.getDuration();
                int day = c.getActualMaximum(Calendar.DAY_OF_MONTH);
                RotationMaster rotationMaster = new RotationMaster();
                rotationMaster.setShiftRotationMaster(shiftRotationMaster);

                if ("monthly".equals(duration) && day == 30) {
                    weeklyGenerate(rotationMaster, rd, shiftRotationMaster, 30, employeeMaster, shiftMasterId);
                } else if ("weekly".equals(duration)) {
                    weeklyGenerateShift(rotationMaster, rd, shiftRotationMaster, 7, employeeMaster, shiftMasterId);
                } else if ("fortNightly".equals(duration)) {
                    weeklyGenerate(rotationMaster, rd, shiftRotationMaster, 14, employeeMaster, shiftMasterId);
                } else {
                    weeklyGenerate(rotationMaster, rd, shiftRotationMaster, day, employeeMaster, shiftMasterId);
                }
            }
//        Code for Shift generate monthly Schedule(End)

//////Make Dir///////
//            String userName = (String) request.getSession().getAttribute("userName");
            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "UserProfile"
                    + File.separator + userName + File.separator;
            //String basePath = getServletContext().getRealPath("/") + "StorageYard" + File.separator + "DigitalSignature" + File.separator + userName + File.separator;
            File profilePictureFile = new File(fileLocationURL);//file directory
//                File profilePicture = profilePictureFile.listFiles()[0];//First File Of Directory.
            if (profilePictureFile.exists() && profilePictureFile.listFiles().length > 0) {
                File[] profilePictureArray = profilePictureFile.listFiles();
                try {
                    request.setAttribute("imageFile", "StodirageYard" + File.separator + "UserProfile" + File.separator + userName + File.separator + profilePictureArray[0].getName().replaceAll(" ", ""));
                } catch (Exception e) {
                }
            }
//                String fileLocationURL1 = getServletContext().getRealPath("")
//                        + File.separator + "StorageYard" + File.separator + "DigitalSignature"
//                        + File.separator + userName + File.separator;
            // Commented later on
//            if (profilePictureFile.exists() && profilePictureFile.listFiles().length > 0) {
//                File[] profilePictureArray = profilePictureFile.listFiles();
//                profilePictureArray[0].delete();//if file exist then delete it.
//            }

            if (!profilePictureFile.exists()) {
                profilePictureFile.mkdir();//make directory for first time user creation.
            }
            //File Photo Uploard///
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            ////this code is using loop but there is actually only one image so changed for only single file
//                String url = "";
//                List<MultipartFile> multipartFile2 = multipartRequest.getFiles("photograph");
//                for (MultipartFile multipartFile1 : multipartFile2) {
//                    if (multipartFile1.getSize() > 0) {
//                        File file2 = new File(fileLocationURL + File.separator
//                                + multipartFile1.getOriginalFilename());
//                        url = fileLocationURL + File.separator + multipartFile1.getOriginalFilename();
//                        multipartFile1.transferTo(file2);
//                    }
//                }
            ////this is changed code for only one file.
            /*MultipartFile multipartFile = multipartRequest.getFile("photograph");
            if (multipartFile != null && multipartFile.getSize() > 0) {
                //null if there is no photograph in form.
                //this condition checking not required if photograph field is compulsary in form.
                try {

                    File file2 = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", ""));
                    multipartFile.transferTo(file2);
                } catch (Exception e) {

                }
            }*/
            //---------------------------
            
            //---------------------------
//            Certificate attach code
            String certificateFileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "UserCertificate"
                    + File.separator + userName + File.separator;
            File certificateListFile = new File(certificateFileLocationURL);
            if (certificateListFile.exists() && certificateListFile.listFiles().length > 0) {
                File[] certificateListFileArray = certificateListFile.listFiles();
                try {
                    request.setAttribute("imageFile", "StorageYard" + File.separator + "UserCertificate" + File.separator + userName + File.separator + certificateListFileArray[0].getName().replaceAll(" ", ""));
                } catch (Exception e) {
                }
            }
            if (!certificateListFile.exists()) {
                certificateListFile.mkdirs();
            }
            String firstStepCount = request.getParameter("firstStepCount");
            for (int i = 1; i <= Integer.parseInt(firstStepCount); i++) {

//                String certificateId = request.getParameter("certificateId" + i);
                MultipartFile multipartFile1 = multipartRequest.getFile("certificateId" + i);
                if (multipartFile1 != null && multipartFile1.getSize() > 0) {
                    try {
                        File file3 = new File(certificateFileLocationURL + multipartFile1.getOriginalFilename().replaceAll(" ", ""));
                        multipartFile1.transferTo(file3);
                    } catch (Exception e) {

                    }
                }

            }

//            Certificate attach code
            //now setting default right as employee.
            setDefaultUserRights(request, employeeMaster);

            request.setAttribute("successMessage",
                    "Information : The Information Is Saved Successfully."
                    + "<br/>"
                    + "You Must Provide UserRights For Allow Successfull Login Of Newly Registered User.");
//            } else {
//                request.setAttribute("failureMessage",
//                        "Error : The Entered Information is not valid.");
//
//            }
            int userMasterId = 0;
            if (employeeMaster.getUserMaster() != null) {
                userMasterId = employeeMaster.getUserMaster().getId();
            }
            try {
                EmailTemplate emailTemplate = new EmailTemplate();
                // id 138 is for Newly Registered User....
                emailTemplate = emailTemplateService.readById(138);
                String To = employeeMaster.getOfficeEmailId();
                String from = "";
                String Subject = emailTemplate.getSubject();
//                Subject = Subject.replaceAll("\\{user\\}", employeeMasterModel.getEmployeeName());
                String msg = emailTemplate.getBodytext();
                msg = msg.replaceAll("\\{user\\}", employeeMaster.getEmployeeName());
                msg = msg.replaceAll("\\{user_id\\}", userMaster.getUserName());
                msg = msg.replaceAll("\\{user_pwd\\}", userMaster.getPassword());
//                msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
//                msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                sendMail.sendMail(from, To, Subject, msg);
            } catch (Exception e) {
            }
            mv.setViewName("forward:userRightMaster.htm?act=createClick&id=" + String.valueOf(userMasterId));
        } else {
            
            //=============================================================================
            
            //------------------ Get Policy detail data and display in jsp -----------------
             //Code to fetch policy details IN VIEW CLICK
            List finalPolicyList = new ArrayList();
  
            //Code for Employee Policy Detail
            //EmployeePolicyDetail employeePolicyDetail = new EmployeePolicyDetail();
            int otherDetailCount = Integer.parseInt(request.getParameter("policyCount"));
            for (int i = 1; i <= otherDetailCount; i++) {
                PolicyMaster policyMaster2 = new PolicyMaster();
                if (null != request.getParameter("policyId" + i) && null != request.getParameter("amount" + i)) {
                    if (!request.getParameter("policyId" + i).equals("") && !request.getParameter("amount" + i).equals("")) {
                        int policyId = Integer.parseInt(request.getParameter("policyId" + i));
                        policyMaster2 = policyMasterService.readById(policyId);
                        
                        List policyList = new ArrayList();
                        Double amount = Double.valueOf(request.getParameter("amount" + i));
                        
                        policyList.add(policyId);
                        policyList.add(policyMaster2.getPolicyName());
                        policyList.add(null);
                        policyList.add(amount);
                        if (null != request.getParameter("taxable" + i)) {
                            policyList.add(1);
                        } else {
                            policyList.add(0);
                        }
                        policyList.add(0);
                        finalPolicyList.add(policyList);
                   }
                }
            }
        
            request.setAttribute("finalPolicyList",finalPolicyList);  
            //------------------- End of Section policy ID --------------------
            //------------------ Start of total ctc section -------------------
            List finalctcList = new ArrayList();
            
             //Code for Employee ctc Detail
            EmployeeCtcDetail employeeCtcDetail = new EmployeeCtcDetail();
            int otherDetailCount1 = Integer.parseInt(request.getParameter("ctcCount"));
            for (int i = 1; i <= otherDetailCount1; i++) {
                CtcAllowance ctcAllowance2 = new CtcAllowance();
                if (null != request.getParameter("ctcId" + i) && null != request.getParameter("ctcamount" + i)) {
                    if (!request.getParameter("ctcId" + i).equals("") && !request.getParameter("ctcamount" + i).equals("")) {
                        int ctcId = Integer.parseInt(request.getParameter("ctcId" + i));
                        Double amount = Double.valueOf(request.getParameter("ctcamount" + i));
                        String month = request.getParameter("month" + i);
                        String year = request.getParameter("year" + i);
//                        String policyNumber = request.getParameter("policyNumber" + i);
                                                                       
                        List ctcList = new ArrayList();
                        ctcList.add(ctcId);
                        ctcAllowance2 = ctcAllowanceService.readById(ctcId);
                        
                        ctcList.add(ctcAllowance2.getCtcName());
                        ctcList.add(amount);
                        if (null != request.getParameter("taxablectc" + i)) {
                            ctcList.add(1);
                        } else {
                            ctcList.add(0);
                        }
                        ctcList.add(month);
                        ctcList.add(year);
                        
                        ctcList.add(0);
                        finalctcList.add(ctcList);
                    }
                }
            }
            request.setAttribute("finalctcList",finalctcList);  
            //----------------- End of total ctc function ---------------------
            String shiftId = request.getParameter("shiftId");
            String shiftMasterId1 = request.getParameter("shiftMasterId");
            String HoursTitle = request.getParameter("shiftHoursId");
            //-------------------------------
            for (ObjectError individualError : errors2.getAllErrors()) {  
                String errorMsg = individualError.getCode();
                //request.setAttribute("failureMessage", " <br/> Employee No:"+ employeeNo + " Error Description : " + errorMsg );
                employeeMasterErrorStrBuf.append("<br/> - " + errorMsg);
                
                request.setAttribute(errorMsg.substring(0, 4), " - " + errorMsg);
            }
            //-------------------------------
//            *********************************************************************************
            if (!"".equals(shiftId) && shiftId != null) {
                employeeMaster.setShiftHoursId(Integer.parseInt(shiftId));
            } else if (!"".equals(HoursTitle) && HoursTitle != null) {
                employeeMaster.setShiftHoursId(Integer.parseInt(HoursTitle));
            }

//            employeeMaster.setShiftHoursId(Integer.parseInt(shiftId));
//           above line is commented because it produces "NumberFormatException" while we submits blank page
//            By Irfan
            
//         **********************************************************************************
            //--------------------
            request.setAttribute("presentAddress2",presentAddress2);  
            request.setAttribute("presentCity",presentCity); 
            request.setAttribute("presentState",presentCity); 
            request.setAttribute("presentPostalCode",presentCity); 
            request.setAttribute("presentCountry",presentCity); 
            request.setAttribute("permanentAddress2",permanentAddress2);
            request.setAttribute("permanentCity",presentCity); 
            request.setAttribute("permanentState",presentCity); 
            request.setAttribute("permanentPostalCode",presentCity); 
            request.setAttribute("permanentCountry",permanentCountry);
            request.setAttribute("disclosedHealthConcerns",disclosedHealthConcerns);
            request.setAttribute("languagesKnown",languagesKnown);
            request.setAttribute("hobbies",hobbies);
            request.setAttribute("flyDocsEmailId",flyDocsEmailId);  
            request.setAttribute("emergencyContactAddress",emergencyContactAddress);        
            request.setAttribute("RelationShip",RelationShip);      
            request.setAttribute("otherImpInfo",otherImpInfo);      
            request.setAttribute("previousCompanyLocation",previousCompanyLocation);        
            request.setAttribute("SpouseGender",spousegender);      
            request.setAttribute("subteamTransferDate",subteamTransferDate);        
            request.setAttribute("nationality",nationality);
            request.setAttribute("firstName",firstName);
            request.setAttribute("middleName",middleName);
            request.setAttribute("lastName",lastName);
            request.setAttribute("pfNoFlydocs",pfNoFlydocs);
            request.setAttribute("withdrawalDate",withdrawalDate);
            request.setAttribute("nameOfPreviousCompany",nameOfPreviousCompany);
            
            request.setAttribute("failureMessageExtension", employeeMasterErrorStrBuf);
            request.setAttribute("shiftName", shiftMasterId1);
            request.setAttribute("designationMasterByLevelId",designationMasterByLevelId);
            
//            request.setAttribute("competencyEvaluationId", competencyEvaluationId);
            
            designationList(request);
            //-----------------------------------------------------------------------------
            request.setAttribute("failureMessage",
                    "Error : User isExist.");
            
            selectEmployee(request, response);
            selectedEmployeeLevel1(request, employeeMaster);
            mv.getModelMap().put("employeeMaster", employeeMaster);
            mv.addAllObjects(errors.getModel());
            mv.setViewName("Employee/EmployeeRegistrationForm");

        }
//            mv.getModelMap().put("userMaster", userMaster);
//            mv.getModelMap().put("shiftMasterId", shiftMasterId);
//            if (employeeMaster.getShiftType().equals("ShiftBase")) {
//
//                mv.setViewName("forward:shiftRotationInfo.htm?act=createSubmit");
//            } else {
//
//                mv.setViewName("Employee/EmployeeRegistrationForm");
//            }
        mv.getModelMap().put("employeeMaster", employeeMaster);
         // Employee master extension starts here
        //Employee master extension ends here
        return mv;        
    }

    public ModelAndView excelUploadAllowanceSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile = multipartRequest.getFile("file1");
        PolicyMaster policyMaster = new PolicyMaster();

        String employeeNo = "";
        String employeeName = "";

        List<String> list = (List<String>) policyMasterService.readPolicyName();

        if (multipartFile.getSize() > 0) {
            InputStream file = multipartFile.getInputStream();
            Workbook workbook = WorkbookFactory.create(file);
            Sheet sheet = workbook.getSheetAt(0);
            int totalCol = 2;
            for (Row row : sheet) {

                int i = 2;
                if (row.getRowNum() == 0) {
                    try {
                        employeeNo = new BigDecimal("" + (null == row.getCell((short) 0) ? "" : row.getCell((short) 0))).toPlainString();
                        employeeNo = employeeNo.split("\\.", 2)[0];
                    } catch (Exception e) {
                        employeeNo = "" + (null == row.getCell((short) 0) ? "" : row.getCell((short) 0));
                    }
                    employeeName = "" + (null == row.getCell((short) 1) ? "" : row.getCell((short) 1));

                    while (null != row.getCell(i) && " " != row.getCell(i).toString() && !row.getCell(i).toString().replace(" ", "").isEmpty()) {
                        XSSFCell cell = (XSSFCell) row.getCell(i);
                        XSSFCell cell1 = (XSSFCell) row.getCell(i + 1);
                        if (!list.stream().anyMatch(cell.toString()::equalsIgnoreCase)) {
                            policyMaster.setPolicyName(cell.toString());
                            policyMasterService.create(policyMaster);
                        }
                        i += 2;
                        totalCol += 2;
                    }
                } else {

                    List<PolicyMaster> list1 = (List<PolicyMaster>) policyMasterService.read();
                    Map<String, Integer> result = list1.stream().collect(Collectors.toMap(PolicyMaster::getPolicyName, PolicyMaster::getId));
                    Map<String, Integer> result1 = result.entrySet().stream()
                            .collect(Collectors.toMap(entry -> entry.getKey().toUpperCase(), entry -> entry.getValue()));
                    Row firstHeaderRow = sheet.getRow(0);

                    EmployeeMaster empMaster = new EmployeeMaster();

                    if (null != row.getCell(0) && " " != row.getCell(0).toString() && !row.getCell(0).toString().replace(" ", "").isEmpty()) {

                        String empNo = row.getCell(0).toString();

                        XSSFCell empName = (XSSFCell) row.getCell(1);

                        UserMaster um = new UserMaster();
                        String[] abc = empNo.split("\\.");
                        um.setUserName(abc[0]);

                        List<?> empId = userMasterService.readByUserName(um);

                        if (!empId.isEmpty() && 0 != empId.size() && null != empId) {

                            um = (UserMaster) empId.get(0);
                            empMaster.setUserMaster(um);
                            List<?> emp = employeeMasterService.readByUserName(empMaster);
                            if (!emp.isEmpty() && 0 != emp.size() && null != emp) {
                                empMaster = (EmployeeMaster) emp.get(0);
                            }

                        }

                        for (int y = 2; y < totalCol; y += 2) {

//                        while (null != row.getCell(y) && " " != row.getCell(y).toString() && !row.getCell(y).toString().replace(" ", "").isEmpty()) {
                            EmployeePolicyDetail employeePolicyDetail = new EmployeePolicyDetail();

                            XSSFCell cell = (XSSFCell) row.getCell(y); // amount
                            XSSFCell cell1 = (XSSFCell) row.getCell(y + 1); // yes or no

                            if (null != row.getCell(y) && " " != row.getCell(y).toString() && !row.getCell(y).toString().replace(" ", "").isEmpty()) {
                                employeePolicyDetail.setAmount(Double.parseDouble(cell.toString().replaceAll(",", "")));

                                if (cell1.toString().equalsIgnoreCase("yes")) {
                                    employeePolicyDetail.setStatus(1);
                                } else if (cell1.toString().equalsIgnoreCase("no")) {
                                    employeePolicyDetail.setStatus(0);
                                } else {

                                }
                                String policyName = (String) firstHeaderRow.getCell(y).toString();
                                policyMaster.setId(result1.get(policyName.toUpperCase()));
                                employeePolicyDetail.setPolicyMaster(policyMaster);
                                employeePolicyDetail.setEmployeeMaster(empMaster);

                                List<?> l = employeePolicyDetailService.readForMasterAdditionalAmount(empMaster.getId(), policyMaster.getId());
                                Integer id = 0;
                                if (!l.isEmpty() && 0 != l.size() && null != l) {
                                    Object[] a = (Object[]) l.get(0);
                                    id = (Integer) a[2];
                                }
                                if (id != 0) {
                                    employeePolicyDetail.setId(id);
                                }
                                employeePolicyDetailService.createOrUpdate(employeePolicyDetail);
//                                y += 2;
//                        }
                            } else {
                                String policyName = (String) firstHeaderRow.getCell(y).toString();
                                policyMaster.setId(result1.get(policyName.toUpperCase()));
                                employeePolicyDetail.setPolicyMaster(policyMaster);
                                employeePolicyDetail.setEmployeeMaster(empMaster);

                                List<?> l = employeePolicyDetailService.readForMasterAdditionalAmount(empMaster.getId(), policyMaster.getId());
                                Integer id = 0;
                                if (!l.isEmpty() && 0 != l.size() && null != l) {
                                    Object[] a = (Object[]) l.get(0);
                                    id = (Integer) a[2];
                                    if (id != 0) {
                                        employeePolicyDetailService.delete(id);
                                    }
                                }
                            }
                        }
//                        }
                    }
                }

            }
        }
        request.setAttribute(
                "successMessage",
                "Information : The Information is saved Successfully.");
        mv = excelUploadAllowance(request, response);

        return mv;
    }

    public void deletePolicy(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            int policyId = Integer.parseInt(request.getParameter("policyId"));
            employeePolicyDetailService.delete(policyId);
        } catch (Exception e) {
            System.out.println("error");
        }
    }

    public void deleteCtcId(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            int empCtcId = Integer.parseInt(request.getParameter("empCtcId"));
            employeeCtcDetailService.delete(empCtcId);
        } catch (Exception e) {
            System.out.println("error");
        }
    }

    public void readFormerEmployeeDetailsByAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String empId = request.getParameter("empId");
        String officialdate = request.getParameter("officialdate");
        String physicaldate = request.getParameter("physicaldate");
        String reason = request.getParameter("reason");

        EmployeeMaster employeeMaster = new EmployeeMaster();

        employeeMaster = employeeMasterService.readById(Integer.parseInt(empId));
        if (employeeMaster != null) {
            employeeMaster.setDateOfLeaving(officialdate);
            employeeMaster.setReasonForLeaving(reason);
            employeeMasterService.update(employeeMaster);
        }

        ResignationMaster resignationMaster = new ResignationMaster();
        List<?> resignationdetails = resignationMasterService.readByApprovedEmpID(Integer.parseInt(empId));
        if (resignationdetails.size() > 0) {
            resignationMaster = (ResignationMaster) resignationdetails.get(0);
            resignationMaster.setRelievingDate(officialdate);
            resignationMaster.setRelievingDatephysical(physicaldate);
            resignationMasterService.update(resignationMaster);
        }

        PrintWriter out = response.getWriter();
        out.print(employeeMaster.getDateOfLeaving() + "~" + employeeMaster.getReasonForLeaving() + "~" + resignationMaster.getRelievingDatephysical());

    }

    public ModelAndView readEmployeeDetailsTeamAndSubTeamWise(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String type = request.getParameter("type");
        String id = request.getParameter("id");
        EmployeeTypeList(request);
        EmployeeSubTypeOnlyUniqueList(request);
        EmployeeMaster employeeMaster = new EmployeeMaster();
        List<EmployeeMaster> employeemasterlist = new ArrayList<EmployeeMaster>();
        if (type.equals("Team")) {
            employeemasterlist = (List<EmployeeMaster>) employeeMasterService.readByTeamId(Integer.parseInt(id));
            request.setAttribute("typeid", id);
        } else if (type.equals("SubTeam")) {
            employeemasterlist = (List<EmployeeMaster>) employeeMasterService.readBySubTeamId(Integer.parseInt(id));
            request.setAttribute("subtypeid", id);
        }
        mv.getModelMap().put("list", employeemasterlist);

        //dont rename "list" because same used on getEmployeeDetailsBySearchString method and employeeRegistrationResult.jsp
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.setViewName("Employee/EmployeeRegistrationResult");

        return mv;

    }
    
    public ModelAndView excelUploadRegistrationSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile = multipartRequest.getFile("file1");
        EmployeeMaster employeeMaster = new EmployeeMaster();
        LevelMaster levelMaster = new LevelMaster();
        EmployeeTypeMaster employeeType1 = new EmployeeTypeMaster();
        EmployeeSubType employeeSubType = new EmployeeSubType();
        DepartmentMaster departmentMaster = new DepartmentMaster();
        DesignationMaster designationMaster = new DesignationMaster();
        ZydexLocationMaster zydexLocationMaster = new ZydexLocationMaster();
        LocationMaster locationMaster = new LocationMaster();
        ShiftRotationMaster shiftRotationMaster = new ShiftRotationMaster();
        ShiftRotationInfo shiftRotationInfo = new ShiftRotationInfo();
        ShiftMaster shiftMaster = new ShiftMaster();
        HoursBasis hoursBasis = new HoursBasis();
        RotationMaster rotationMaster = new RotationMaster();
        EmployeeMasterExtension employeeMasterExtension;
        int counter = 0;
        int counterOfException = 0;
        String employeeNo = "";
        String employeeFirstName = "";
        String employeeLastName = "";
        String dateOfJoiningNonFormated = "";
        String gender = "";
        String dobNonFormated = "";
        String employeeType = "";
        String employeeSubtype = ""; // employee sub type
        String designation = "";
        String typeofemployee = ""; // employee Type
        String reportingManager = "";
        String level = "";
        String workLocation = "";
        String role = "";
        //***employee extension****//
        String FirstName = "";
        String MiddleName = "";
        String LastName = "";
        //***employee extension END****//

        String passportNo = "";
        //***employee extension****//
        String nationality = "";
        String countryOfIssue = "";
        //***employee extension END****//

        String passportDateOfIssue = "";
        String passportExpiryDate = "";
        //***employee extension****//
        String visaIssueCountry = "";
        String visaIssueDate = "";
        String visaValidTillDate = "";
        //***employee extension END****//

        String presentAddress1 = "";
        //***employee extension****//
        String presentAddress2 = "";
        String presentCity = "";
        String presentState = "";
        String presentPostalCode = "";
        String presentCountry = "";
        //***employee extension END****//

        String permanentAddress1 = "";
        //***employee extension****//
        String permanentAddress2 = "";
        String permanentCity = "";
        String permanentState = "";
        String permanentPostalCode = "";
        String permanentCountry = "";
        //***employee extension END****//

        String contactNo1resident = "";
        String contactNo2mobile = "";
        //***employee extension****//
        String flyDocsEmailId = "";
        //***employee extension END****//

        String personalEmailId = "";
        String bankAccountNo = "";
        String bankName = "";
        String ifscCode = "";
        //***employee extension****//
        String pfwithdrawalDate = "";
        //***employee extension END****//

        String pfNo = ""; //pf 
        //***employee extension****//
        String pfNoFlydocs = "";
        String electionCard = "";
        //***employee extension END****//

        String pan = "";
        String aadharCard = "";
        String esicNo = ""; //esic no
        String uanNo = ""; //uano
        String maritalStatus = "";
        //***employee extension****//
        String religion = "";
        //***employee extension END****//

        String bloodGroup = "";
        //***employee extension****//
        String disclosedHealthConcerns = "";
        //***employee extension END****//

        String drivinglicenceNo = "";
        //***employee extension****//
        String drivingLicenceType = "";
        //***employee extension END****//

        String fatherNamed1 = "";
        String fatherdob = "";
        String motherNamed2 = "";
        String motherdob = "";
        String spouseNamed3 = "";
        String spouseGender3 = "";
        String spousedob = "";
        String childname1 = "";
        //***employee extension****//
        String childOneGender = "";
        //***employee extension END****//

        String childdob1 = "";
        String childname2 = "";
        //***employee extension****//
        String childTwoGender = "";
        //***employee extension END****//

        String childdob2 = "";
        String emergencyContactPerson = "";
        //***employee extension****//
        String RelationShip = "";
        //***employee extension END****//

        String emergencyContactNo = "";
        //***employee extension****//
        String emergencyContactAddress = "";
        String otherImpInfo = "";
        String previouscompanyname = "";
        String previouscompanylocation = "";
        //***employee extension END****//

        String companylocationCity = "";
        String employeeeEXPonJoiningYears = "";
        String employeeeEXPonJoiningMonths = "";
        String highestEducation = "";
        //***employee extension****//
        String languagesKnown = "";
        String hobbies = "";
        //***employee extension END****// 

        String workType = "";//shift(base) or hours(base).
        String hours = "";//(eg...9Hours , 10Hours).
        String shiftName = "";//shift Name.
        String shiftRotation = "";//Shift Change Name.
        String shiftRotationDate = "";//Shift Change Name.
        String paymentType = "";
        String basicSalary = "";
        String company = "";
        String department = "";
        String nameper = "";
        String pfconbyemployee = "";
        String pfconbyemployer = "";
        String pfcheck = "";
        String ptcheck = "";
        String esiccheck = "";
        String salarybase = "";
        String ot = "";
        String oddpunchreq = "";
        String payroll = "";
        String LineManager2 = "";
        
        boolean isShiftRotationCreated = false;//if new created then enter information in RotationMaster table.
        boolean isShiftMasterCreated = false;//if new created RotationMaster table with ShiftRotationMaster.
        ShiftMaster shiftMasteDefault = new ShiftMaster();


        boolean gender1 = false;
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBufferOfExceptions = new StringBuffer();
        stringBufferOfExceptions.append("");
        
        StringBuffer strBuffFailer = new StringBuffer();
        StringBuffer stringBuffError = new StringBuffer();
        StringBuffer stringBuffSuccess = new StringBuffer();
        
        //----------------
        BindException errors, errors2;
        //---------------
        try {
            if (multipartFile.getSize() > 0) {
                InputStream file = multipartFile.getInputStream();
                Workbook workbook = WorkbookFactory.create(file);
                Sheet sheet = workbook.getSheetAt(0);
                for (Row row : sheet) {
                    //--------------------------------------------
                    boolean createCheckFlags[] = new boolean[15];
                    boolean updateCheckFlags[] = new boolean[5];
                    employeeMaster = new EmployeeMaster();
                    employeeMasterExtension = new EmployeeMasterExtension();
                            
                    errors = new BindException(employeeMaster, "employeeMaster");
                    errors2 = new BindException(employeeMasterExtension, "employeeMasterExtension");
                    //--------------------------------------------
                    try {
                        if (row.getRowNum() != 0 && row.getRowNum() != 1 && row.getRowNum() != 2) {
                            if(row.getCell(1) != null){
                            try {
                                employeeNo = "" + (null == row.getCell((short) 1) ? "" : row.getCell((short) 1));
                                employeeNo = employeeNo.split("\\.", 2)[0];
                            } catch (Exception e) {
                                employeeNo = "" + (null == row.getCell((short) 1) ? "" : row.getCell((short) 1));
                            }

                            employeeFirstName = "" + (null == row.getCell((short) 2) ? "" : row.getCell((short) 2));
                            employeeLastName = "" + (null == row.getCell((short) 3) ? "" : row.getCell((short) 3));
                            String employeefullname = employeeFirstName + " " + employeeLastName;
                            dateOfJoiningNonFormated = "" + (null == row.getCell((short) 4) ? "" : row.getCell((short) 4));
//                            SimpleDateFormat sdfSource = new SimpleDateFormat("dd/MM/yy");
//                            Date date = sdfSource.parse(dateOfJoiningNonFormated);
//                            String dateOfJoiningformated = String.valueOf(date);

                            SimpleDateFormat sdfDOJ = new SimpleDateFormat("dd-MMM-yy");
                            SimpleDateFormat sdfDOJ2 = new SimpleDateFormat("dd/MM/yyyy");

                            Date dateDOJ = sdfDOJ.parse(dateOfJoiningNonFormated);
                            String dateOfJoining = sdfDOJ.format(dateDOJ);
//                            String dateOfJoining = sdfDOJ2.format(dateDOJ);

                            gender = "" + (null == row.getCell((short) 5) ? "" : row.getCell((short) 5));
                            dobNonFormated = "" + (null == row.getCell((short) 6) ? "" : row.getCell((short) 6));
                            String dobformated;
                            if (!dobNonFormated.contains("N/A")) {
                                SimpleDateFormat sdfpDOb = new SimpleDateFormat("dd-MMM-yyyy");
                                SimpleDateFormat sdfpDOb2 = new SimpleDateFormat("dd/MM/yyyy");

                                Date datepDOb = sdfpDOb.parse(dobNonFormated);
                                String nDate8 = sdfpDOb.format(datepDOb);
                                dobformated = sdfpDOb2.format(datepDOb);
                            } else {
                                dobformated = "N/A";
                            }
                            employeeType = "" + (null == row.getCell((short) 7) ? "" : row.getCell((short) 7));
                            employeeSubtype = "" + (null == row.getCell((short) 8) ? "" : row.getCell((short) 8));
                            designation = "" + (null == row.getCell((short) 9) ? "" : row.getCell((short) 9));
                            typeofemployee = "" + (null == row.getCell((short) 10) ? "" : row.getCell((short) 10));
                            reportingManager = "" + (null == row.getCell((short) 11) ? "" : row.getCell((short) 11));
                            level = "" + (null == row.getCell((short) 12) ? "" : row.getCell((short) 12));
                            workLocation = "" + (null == row.getCell((short) 13) ? "" : row.getCell((short) 13));
                            role = "" + (null == row.getCell((short) 14) ? "" : row.getCell((short) 14));
                            
                            nameper = "" + (null == row.getCell((short) 15) ? "" : row.getCell((short) 15));
                            
                            FirstName = "" + (null == row.getCell((short) 16) ? "" : row.getCell((short) 16));
                            MiddleName = "" + (null == row.getCell((short) 17) ? "" : row.getCell((short) 17));
                            LastName = "" + (null == row.getCell((short) 18) ? "" : row.getCell((short) 18));
                            passportNo = "" + (null == row.getCell((short) 19) ? "" : row.getCell((short) 19));
                            nationality = "" + (null == row.getCell((short) 20) ? "" : row.getCell((short) 20));
                            countryOfIssue = "" + (null == row.getCell((short) 21) ? "" : row.getCell((short) 21));
                            passportDateOfIssue = "" + (null == row.getCell((short) 22) ? "" : row.getCell((short) 22));
                            String passportDateOfIssueformated;
                            if (!passportDateOfIssue.contains("N/A")) {
                                SimpleDateFormat sdfpDOJ = new SimpleDateFormat("dd-MMM-yyyy");
                                SimpleDateFormat sdfpDOJ2 = new SimpleDateFormat("dd/MM/yyyy");

                                Date datepDOJ = sdfpDOJ.parse(passportDateOfIssue);
                                String nDate8 = sdfpDOJ.format(datepDOJ);
                                passportDateOfIssueformated = sdfpDOJ2.format(datepDOJ);
                            } else {
                                passportDateOfIssueformated = "N/A";
                            }
                            passportExpiryDate = "" + (null == row.getCell((short) 23) ? "" : row.getCell((short) 23));
                            String passportExpiryDateformated;
                            if (!passportExpiryDate.contains("N/A")) {
                                SimpleDateFormat sdfpeDOJ = new SimpleDateFormat("dd-MMM-yyyy");
                                SimpleDateFormat sdfpeDOJ2 = new SimpleDateFormat("dd/MM/yyyy");

                                Date datepeDOJ = sdfpeDOJ.parse(passportExpiryDate);
                                String nDate9 = sdfpeDOJ.format(datepeDOJ);
                                passportExpiryDateformated = sdfpeDOJ2.format(datepeDOJ);
                            } else {
                                passportExpiryDateformated = "N/A";
                            }
                            visaIssueCountry = "" + (null == row.getCell((short) 24) ? "" : row.getCell((short) 24));
                            visaIssueDate = "" + (null == row.getCell((short) 25) ? "" : row.getCell((short) 25));
                            visaValidTillDate = "" + (null == row.getCell((short) 26) ? "" : row.getCell((short) 26));
                            // Skip One column
                            presentAddress1 = "" + (null == row.getCell((short) 28) ? "" : row.getCell((short) 28));
                            presentAddress2 = "" + (null == row.getCell((short) 29) ? "" : row.getCell((short) 29));
                            presentCity = "" + (null == row.getCell((short) 30) ? "" : row.getCell((short) 30));
                            presentState = "" + (null == row.getCell((short) 31) ? "" : row.getCell((short) 31));
                            presentPostalCode = "" + (null == row.getCell((short) 32) ? "" : row.getCell((short) 32));
                            presentPostalCode = presentPostalCode.split("\\.", 2)[0];
                            presentCountry = "" + (null == row.getCell((short) 33) ? "" : row.getCell((short) 33));
                            // Skip One column
                            permanentAddress1 = "" + (null == row.getCell((short) 35) ? "" : row.getCell((short) 35));
                            permanentAddress2 = "" + (null == row.getCell((short) 36) ? "" : row.getCell((short) 36));
                            permanentCity = "" + (null == row.getCell((short) 37) ? "" : row.getCell((short) 37));
                            permanentState = "" + (null == row.getCell((short) 38) ? "" : row.getCell((short) 38));
                            permanentPostalCode = "" + (null == row.getCell((short) 39) ? "" : row.getCell((short) 39));
                            permanentPostalCode = permanentPostalCode.split("\\.", 2)[0];
                            permanentCountry = "" + (null == row.getCell((short) 40) ? "" : row.getCell((short) 40));
                            // Skip One column
                            contactNo1resident = "" + (null == row.getCell((short) 42) ? "" : row.getCell((short) 42));
                            String contactNo = "";
                            if (!contactNo1resident.equals("")) {
                                BigDecimal bdContactNo = new BigDecimal(contactNo1resident);
                                contactNo = "" + bdContactNo.longValue();
                            } else {
                                contactNo = "";
                            }
                            contactNo2mobile = "" + (null == row.getCell((short) 43) ? "" : row.getCell((short) 43));
                            String contactNo2 = "";
                            if (!contactNo2mobile.equals("")) {
                                BigDecimal bdContactNo2 = new BigDecimal(contactNo2mobile);
                                contactNo2 = "" + bdContactNo2.longValue();
                            } else {
                                contactNo2 = "";
                            }
                            
                            flyDocsEmailId = ""+ (null == row.getCell((short) 44) ? "" : row.getCell((short) 44));
                            personalEmailId = "" + (null == row.getCell((short) 45) ? "" : row.getCell((short) 45));
                            // Skip one column
                            bankAccountNo = "" + (null == row.getCell((short) 47) ? "" : row.getCell((short) 47));
                            String bNo = "";
                            if (!bankAccountNo.equals("")) {
                                BigDecimal bdbNo = new BigDecimal(bankAccountNo);
                                bNo = "" + bdbNo.longValue();
                            } else {
                                bNo = "";
                            }
                            bankName = "" + (null == row.getCell((short) 48) ? "" : row.getCell((short) 48));
                            ifscCode = "" + (null == row.getCell((short) 49) ? "" : row.getCell((short) 49));
                            pfwithdrawalDate = "" + (null == row.getCell((short) 50) ? "" : row.getCell((short) 50));
                            pfNo = "" + (null == row.getCell((short) 51) ? "" : row.getCell((short) 51));
                            pfNoFlydocs = "" + (null == row.getCell((short) 52) ? "" : row.getCell((short) 52));
                            electionCard = "" + (null == row.getCell((short) 53) ? "" : row.getCell((short) 53));
                            pan = "" + (null == row.getCell((short) 54) ? "" : row.getCell((short) 54));
                            aadharCard = "" + (null == row.getCell((short) 55) ? "" : row.getCell((short) 55));
                            String aNo = "";
                            if (!aadharCard.equals("")) {
                                BigDecimal bdaNo = new BigDecimal(aadharCard);
                                aNo = "" + bdaNo.longValue();
                            } else {
                                aNo = "";
                            }
                            esicNo = "" + (null == row.getCell((short) 56) ? "" : row.getCell((short) 56));
                            uanNo = "" + (null == row.getCell((short) 57) ? "" : row.getCell((short) 57));
                            String uannNo = "";
                            if (!uanNo.equals("")) {
                                BigDecimal bduNo = new BigDecimal(uanNo);
                                uannNo = "" + bduNo.longValue();
                            } else {
                                uannNo = "";
                            }
                            // Skip one column for Finance
                            maritalStatus = "" + (null == row.getCell((short) 59) ? "" : row.getCell((short) 59));
                            religion = "" + (null == row.getCell((short) 60) ? "" : row.getCell((short) 60));
                            bloodGroup = "" + (null == row.getCell((short) 61) ? "" : row.getCell((short) 61));
                            disclosedHealthConcerns = "" + (null == row.getCell((short) 62) ? "" : row.getCell((short) 62));
                            // Skip one column no over here
                            drivinglicenceNo = "" + (null == row.getCell((short) 64) ? "" : row.getCell((short) 64));
                            String drilicNo = "";
                            if (!drivinglicenceNo.equals("")) {
//                                BigDecimal bddrilicNo = new BigDecimal(drivinglicenceNo);
//                                drilicNo = "" + bddrilicNo.longValue();
                                drilicNo = drivinglicenceNo;
                            } else {
                                drilicNo = "";
                            }
                            drivingLicenceType = "" + (null == row.getCell((short) 65) ? "" : row.getCell((short) 65));
                            // Skip 1 column for driving 
                            // Skip 1 column for no of dependents
                            
                            //---------- Dependent 1 --------------------
                            fatherNamed1 = "" + (null == row.getCell((short) 68) ? "" : row.getCell((short) 68));
                            // Skip one column for Gender 
                            fatherdob = "" + (null == row.getCell((short) 70) ? "" : row.getCell((short) 70));
                            String fatherdobformated;
                            if (!fatherdob.contains("N/A")) {
                                SimpleDateFormat sdfdDOJ = new SimpleDateFormat("dd-MMM-yyyy");
                                SimpleDateFormat sdfdDOJ2 = new SimpleDateFormat("dd/MM/yyyy");

                                Date datesDOJ = sdfdDOJ.parse(fatherdob);
                                String nDate3 = sdfdDOJ.format(datesDOJ);
                                fatherdobformated = sdfdDOJ2.format(datesDOJ);
                            } else {
                                fatherdobformated = "N/A";
                            }
                            
                            
                            //---------- Dependent 2 --------------------
                            motherNamed2 = "" + (null == row.getCell((short) 71) ? "" : row.getCell((short) 71));
                            // Skip one column for Gender 
                            motherdob = "" + (null == row.getCell((short) 73) ? "" : row.getCell((short) 73));
                            String motherdobformated;
                            if (!motherdob.contains("N/A")) {
                                SimpleDateFormat sdfmDOJ = new SimpleDateFormat("dd-MMM-yyyy");
                                SimpleDateFormat sdfmDOJ2 = new SimpleDateFormat("dd/MM/yyyy");

                                Date datemDOJ = sdfmDOJ.parse(motherdob);
                                String nDate3 = sdfmDOJ.format(datemDOJ);
                                motherdobformated = sdfmDOJ2.format(datemDOJ);
                            } else {
                                motherdobformated = "N/A";
                            }
                            
                            
                            //---------- Dependent 3 --------------------
                            spouseNamed3 = "" + (null == row.getCell((short) 74) ? "" : row.getCell((short) 74));
                            spouseGender3 = "" + (null == row.getCell((short) 75) ? "" : row.getCell((short) 75));
                            spousedob = "" + (null == row.getCell((short) 76) ? "" : row.getCell((short) 76));
                            String spousedobformated;
                            if (!spousedob.contains("N/A")) {
                                SimpleDateFormat sdfsDOJ = new SimpleDateFormat("dd-MMM-yyyy");
                                SimpleDateFormat sdfsDOJ2 = new SimpleDateFormat("dd/MM/yyyy");

                                Date datesDOJ = sdfsDOJ.parse(spousedob);
                                String nDate3 = sdfsDOJ.format(datesDOJ);
                                spousedobformated = sdfsDOJ2.format(datesDOJ);
                            } else {
                                spousedobformated = "N/A";
                            }

                            //---------- Dependent 4 --------------------
                            childname1 = "" + (null == row.getCell((short) 77) ? "" : row.getCell((short) 77));
                            childOneGender = "" + (null == row.getCell((short) 78) ? "" : row.getCell((short) 78));
                            childdob1 = "" + (null == row.getCell((short) 79) ? "" : row.getCell((short) 79));
                            String childdob1formated;
                            if (!childdob1.contains("N/A")) {
                                SimpleDateFormat sdfcDOJ = new SimpleDateFormat("dd-MMM-yyyy");
                                SimpleDateFormat sdfcDOJ2 = new SimpleDateFormat("dd/MM/yyyy");

                                Date datecDOJ = sdfcDOJ.parse(childdob1);
                                String nDate4 = sdfcDOJ.format(datecDOJ);
                                childdob1formated = sdfcDOJ2.format(datecDOJ);
                            } else {
                                childdob1formated = "N/A";
                            }
                            
                            //---------- Dependent 5 --------------------
                            childname2 = "" + (null == row.getCell((short) 80) ? "" : row.getCell((short) 80));
                            childTwoGender = "" + (null == row.getCell((short) 81) ? "" : row.getCell((short) 81));
                            childdob2 = "" + (null == row.getCell((short) 82) ? "" : row.getCell((short) 82));
                            String childdob2formated;
                            if (!childdob2.contains("N/A")) {
                                SimpleDateFormat sdfc2DOJ = new SimpleDateFormat("dd-MMM-yyyy");
                                SimpleDateFormat sdfc2DOJ2 = new SimpleDateFormat("dd/MM/yyyy");

                                Date datec2DOJ = sdfc2DOJ.parse(childdob2);
                                String nDate5 = sdfc2DOJ.format(datec2DOJ);
                                childdob2formated = sdfc2DOJ2.format(datec2DOJ);
                            } else {
                                childdob2formated = "N/A";
                            }
                            
                            // Skip One column for dependents ---------------
                            emergencyContactPerson = "" + (null == row.getCell((short) 84) ? "" : row.getCell((short) 84));
                            RelationShip = "" + (null == row.getCell((short) 85) ? "" : row.getCell((short) 85));
                            emergencyContactNo = "" + (null == row.getCell((short) 86) ? "" : row.getCell((short) 86));
                            String econtactNo = "";
                            if (!emergencyContactNo.equals("")) {
                                BigDecimal bdeContactNo = new BigDecimal(emergencyContactNo);
                                econtactNo = "" + bdeContactNo.longValue();
                            } else {
                                econtactNo = "";
                            }
                            emergencyContactAddress = "" + (null == row.getCell((short) 87) ? "" : row.getCell((short) 87));
                            otherImpInfo = "" + (null == row.getCell((short) 88) ? "" : row.getCell((short) 88));
                            // Skip 1 for emergency Contact
                            // Skip 3 Column for rejoing, relive and final date
                            // Skip 1 column for exit info
                            previouscompanyname = "" + (null == row.getCell((short) 94) ? "" : row.getCell((short) 94));
                            previouscompanylocation = "" + (null == row.getCell((short) 95) ? "" : row.getCell((short) 95));
                            companylocationCity = "" + (null == row.getCell((short) 96) ? "" : row.getCell((short) 96));
//                            employeeeEXPonJoiningYears = "" + (null == row.getCell((short) 96) ? "" : row.getCell((short) 96));
                            try {
                                employeeeEXPonJoiningYears = new BigDecimal("" + (null == row.getCell((short) 97) ? "" : row.getCell((short) 97))).toPlainString();
                                employeeeEXPonJoiningYears = employeeeEXPonJoiningYears.split("\\.", 2)[0];
                            } catch (Exception e) {
                                employeeeEXPonJoiningYears = "" + (null == row.getCell((short) 97) ? "" : row.getCell((short) 97));
                            }
//                            String employeeeEXPYear = "";
//                            if (!employeeeEXPonJoiningYears.equals("")) {
//                                BigDecimal empEXPYear = new BigDecimal(employeeeEXPonJoiningYears);
//                                employeeeEXPYear = "" + empEXPYear.longValue();
//                            } else {
//                                employeeeEXPYear = "";
//                            }
//                            employeeeEXPonJoiningMonths = "" + (null == row.getCell((short) 97) ? "" : row.getCell((short) 97));
                            try {
                                employeeeEXPonJoiningMonths = new BigDecimal("" + (null == row.getCell((short) 98) ? "" : row.getCell((short) 98))).toPlainString();
                                employeeeEXPonJoiningMonths = employeeeEXPonJoiningMonths.split("\\.", 2)[0];
                            } catch (Exception e) {
                                employeeeEXPonJoiningMonths = "" + (null == row.getCell((short) 98) ? "" : row.getCell((short) 98));
                            }
//                            String employeeeEXPMonth = "";
//                            if (!employeeeEXPonJoiningMonths.equals("")) {
//                                BigDecimal empEXPMonth = new BigDecimal(employeeeEXPonJoiningMonths);
//                                employeeeEXPMonth = "" + empEXPMonth.longValue();
//                            } else {
//                                employeeeEXPMonth = "";
//                            }
                            highestEducation = "" + (null == row.getCell((short) 99) ? "" : row.getCell((short) 99));
                            languagesKnown = "" + (null == row.getCell((short) 100) ? "" : row.getCell((short) 100));
                            hobbies = "" + (null == row.getCell((short) 101) ? "" : row.getCell((short) 101));
                            // Skip 1 Column for other info
                            workType = "" + (null == row.getCell((short) 103) ? "" : row.getCell((short) 103));
                            hours = "" + (null == row.getCell((short) 104) ? "" : row.getCell((short) 104));
                            shiftName = "" + (null == row.getCell((short) 105) ? "" : row.getCell((short) 105));
                            shiftRotation = "" + (null == row.getCell((short) 106) ? "" : row.getCell((short) 106));
                            shiftRotationDate = "" + (null == row.getCell((short) 107) ? "" : row.getCell((short) 107));
                            paymentType = "" + (null == row.getCell((short) 108) ? "" : row.getCell((short) 108));
                            basicSalary = "" + (null == row.getCell((short) 109) ? "" : row.getCell((short) 109));
                            basicSalary = basicSalary.split("\\.", 2)[0];
                            company = "" + (null == row.getCell((short) 110) ? "" : row.getCell((short) 110));
                            department = "" + (null == row.getCell((short) 111) ? "" : row.getCell((short) 111));
                            
                            pfconbyemployee = "" + (null == row.getCell((short) 112) ? "" : row.getCell((short) 112));
                            pfconbyemployer = "" + (null == row.getCell((short) 113) ? "" : row.getCell((short) 113));
                            pfcheck = "" + (null == row.getCell((short) 114) ? "" : row.getCell((short) 114));
                            ptcheck = "" + (null == row.getCell((short) 115) ? "" : row.getCell((short) 115));
                            esiccheck = "" + (null == row.getCell((short) 116) ? "" : row.getCell((short) 116));
                            salarybase = "" + (null == row.getCell((short) 117) ? "" : row.getCell((short) 117));
                            ot = "" + (null == row.getCell((short) 118) ? "" : row.getCell((short) 118));
                            oddpunchreq = "" + (null == row.getCell((short) 119) ? "" : row.getCell((short) 119));
                            payroll = "" + (null == row.getCell((short) 120) ? "" : row.getCell((short) 120));
                            //LineManager2 = "" + (null == row.getCell((short) 121) ? "" : row.getCell((short) 121));
                            
                            
                            employeeMaster.setEmployeeType(typeofemployee);
                            employeeMaster.setPfAmount(pfconbyemployee);
                            employeeMaster.setPfAmountEmployer(pfconbyemployer);
                           
                            Boolean flag = false;
                            if (pfcheck.contains("No")) {
                                employeeMaster.setPf(flag);
                            }else if(pfcheck.contains("Yes")){ 
                                 flag = true;
                                    employeeMaster.setPf(flag);
                            }else {
                                employeeMaster.setPf(null);
                            }
                            Boolean flag1 = false;
                            if (ptcheck.contains("No")) {
                                employeeMaster.setPt(flag1);
                            }else if(ptcheck.contains("Yes")){ 
                                 flag1 = true;
                                    employeeMaster.setPt(flag1);
                            }else {
                                employeeMaster.setPt(null);
                            }
                            Boolean flag2 = false;
                            if (esiccheck.contains("No")) {
                                employeeMaster.setEsic(flag2);
                            }else if(esiccheck.contains("Yes")){ 
                                 flag2 = true;
                                    employeeMaster.setEsic(flag2);
                            }else {
                                employeeMaster.setEsic(null);
                            }
                            Boolean flag3 = false;
                            if (salarybase.contains("Day")) {
                                employeeMaster.setSalaryBase(flag3);
                            }else if(salarybase.contains("Month")){ 
                                 flag3 = true;
                                    employeeMaster.setSalaryBase(flag3);
                            }else {
                                employeeMaster.setSalaryBase(null);
                            }
                            Boolean flag4 = false;
                            if (ot.contains("Yes")) {
                                employeeMaster.setOt(flag4);
                            }else if(ot.contains("No")){ 
                                 flag4 = true;
                                    employeeMaster.setOt(flag4);
                            }else {
                                employeeMaster.setOt(null);
                            }
                            Boolean flag5 = false;
                            if (oddpunchreq.contains("No")) {
                                employeeMaster.setOddPunch(flag5);
                            }else if(oddpunchreq.contains("Yes")){ 
                                 flag5 = true;
                                    employeeMaster.setOddPunch(flag5);
                            }else {
                                employeeMaster.setOddPunch(null);
                            }
                             Boolean flag6 = false;
                            if (payroll.contains("No")) {
                                employeeMaster.setPayroll(flag6);
                            }else if(payroll.contains("Yes")){ 
                                 flag6 = true;
                                    employeeMaster.setPayroll(flag6);
                            }else {
                                employeeMaster.setPayroll(null);
                            }
//                            employeeMaster.setPassportNo(passportNo);
//                            employeeMaster.setPassportIssueDate(passportDateOfIssueformated);
//                            employeeMaster.setPassportExpiryDate(passportExpiryDateformated);
                            employeeMaster.setPresentAddress(presentAddress1);
                            employeeMaster.setDateOfBirthOfEmpFather(fatherdobformated);
                            employeeMaster.setDateOfBirthOfEmpMother(motherdobformated);
                            employeeMaster.setDateOfBirthOfEmpSpous(spousedobformated);
                            employeeMaster.setChild1(childname1);
                            employeeMaster.setChild2(childname2);
                            employeeMaster.setDateOfBirthOfEmpChilld1(childdob1formated);
                            employeeMaster.setDateOfBirthOfEmpChild2(childdob2formated);
                            employeeMaster.setCityOfEmployee(companylocationCity);
                            employeeMaster.setDrivingLicence(drivinglicenceNo);

                            EmployeeVisaDetails employeeVisaDetails = new EmployeeVisaDetails();
                            employeeVisaDetails.setVisaIssueCountry(visaIssueCountry);
                            employeeVisaDetails.setVisaIssueDate(visaIssueDate);
                            employeeVisaDetails.setVisaValidTillDate(visaValidTillDate);

                            if (nameper.equalsIgnoreCase("Passport")){
//                                employeeMasterExtension.setNameStatus(false);
                            }else if(nameper.equalsIgnoreCase("AadharCard")){
//                                employeeMasterExtension.setNameStatus(true);
                            }else{
//                                employeeMasterExtension.setNameStatus(false);
                            }
                            employeeMasterExtension.setFirstName(FirstName);
                            employeeMasterExtension.setMiddleName(MiddleName);
                            employeeMasterExtension.setLastName(LastName);
                            employeeMasterExtension.setNationality(nationality);
//                            employeeMasterExtension.setCountryOfIssue(countryOfIssue);
//                            employeeMasterExtension.setVisaIssueCountry(visaIssueCountry);
//                            employeeMasterExtension.setVisaIssueDate(visaIssueDate);
//                            employeeMasterExtension.setVisaValidTillDate(visaValidTillDate);
                            employeeMasterExtension.setPresentAddress2(presentAddress2);
                            employeeMasterExtension.setPresentCity(presentCity);
                            employeeMasterExtension.setPresentCountry(presentCountry);
                            employeeMasterExtension.setPresentPostalCode(presentPostalCode);
                            employeeMasterExtension.setPresentState(presentState);

                            employeeMasterExtension.setPermanentAddress2(permanentAddress2);
                            employeeMasterExtension.setPermanentCity(permanentCity);
                            employeeMasterExtension.setPermanentCountry(permanentCountry);
                            employeeMasterExtension.setPermanentPostalCode(permanentPostalCode);
                            employeeMasterExtension.setPermanentState(permanentState);
//                            employeeMasterExtension.setFlyDocsEmailId(flyDocsEmailId);
                            employeeMasterExtension.setWithdrawalDate(pfwithdrawalDate);
                            employeeMasterExtension.setPfNoFlydocs(pfNoFlydocs);
//                            employeeMasterExtension.setElectionCard(electionCard);
//                            employeeMasterExtension.setReligion(religion);
                            employeeMasterExtension.setDisclosedHealthConcerns(disclosedHealthConcerns);
                            employeeMasterExtension.setDrivingLicenceType(drivingLicenceType);
                            employeeMasterExtension.setPreviousCompanyLocation(previouscompanylocation);
                            employeeMasterExtension.setNameOfPreviousCompany(previouscompanyname);

                            Boolean g = false;
//                            employeeMasterExtension.setNameStatus(g);
                            if (childOneGender.contains("M")) {
                                employeeMasterExtension.setChildOneGender(g);
                            }else if(childOneGender.contains("F")){ 
                                 g = true;
                                employeeMasterExtension.setChildOneGender(g);
                            }else {
                                
                                employeeMasterExtension.setChildOneGender(g);
                            }
                            
                            if (childTwoGender.contains("M")) {
                                employeeMasterExtension.setChildTwoGender(g);
                            } else if(childTwoGender.contains("F")){ 
                                  g = true;
                                employeeMasterExtension.setChildTwoGender(g);
                            }else {
                               employeeMasterExtension.setChildTwoGender(g);
                            }
                            
                            if (spouseGender3.contains("M")) {
                                employeeMasterExtension.setSpouseGender(g);
                            } else if(spouseGender3.contains("F")){ 
                                  g = true;
                                employeeMasterExtension.setSpouseGender(g);
                            }else {
                                employeeMasterExtension.setSpouseGender(g);
                            }
                            employeeMasterExtension.setRelationShip(RelationShip);
                            employeeMasterExtension.setEmergencyContactAddress(emergencyContactAddress);
                            employeeMasterExtension.setOtherImpInfo(otherImpInfo);
                            employeeMasterExtension.setHobbies(hobbies);
                            employeeMasterExtension.setLanguagesKnown(languagesKnown);

                            employeeMaster.setEmployeeId(employeeNo);
                            employeeMaster.setEmployeeName(employeefullname);
//                            employeeMaster.setDateOfJoining(dateOfJoiningNonFormated);
                            employeeMaster.setDateOfJoining(dateOfJoining);
                            employeeMaster.setBasicSalary(basicSalary);
//                            employeeMaster.setConveysAmount(conveysAmount);
                            employeeMaster.setEsicNo(esicNo);
//                            employeeMaster.setTdsAmount(tdsAmount);
                            employeeMaster.setPaymentType(paymentType);
                            employeeMaster.setPfNo(pfNo);
                            employeeMaster.setUanNo(uannNo);
                            
                            if (!employeeType.equals("")) {
                                List<?> levelList11 = employeeTypeService.readByName(employeeType.trim());
                                if (!levelList11.isEmpty()) {
                                    employeeType1 = (EmployeeTypeMaster) levelList11.get(0);
                                    employeeMaster.setEmployeeTypeMaster(employeeType1);
                                } else {
                                    String val = employeeType;
                                    employeeType1.setTypeOfEmployee(val);
                                    //employeeTypeService.create(employeeType1);
                                    createCheckFlags[0] = true;
                                    employeeMaster.setEmployeeTypeMaster(employeeType1);

                                }
                            } else {
                                employeeMaster.setEmployeeTypeMaster(null);
                            }
                            if (!employeeSubtype.equals("")) {
                                int emptypid = employeeMaster.getEmployeeTypeMaster().getId();
                                
                                List<?> levelList2 = employeeSubTypeService.readByEmployeeTypeIdANDSubTypeName(emptypid,employeeSubtype.trim());
                                if (!levelList2.isEmpty()) {
                                    employeeSubType = (EmployeeSubType) levelList2.get(0);
                                    employeeMaster.setEmployeeSubType(employeeSubType);
                                } else {
                                    employeeSubType.setSubType(employeeSubtype);
                                    employeeSubType.setEmployeeTypeMaster(employeeType1);
                                    //employeeSubTypeService.create(employeeSubType);
                                    createCheckFlags[1] = true;
                                    employeeMaster.setEmployeeSubType(employeeSubType);

                                }
                            } else {
                                employeeMaster.setEmployeeSubType(null);
                            }
                            if (!level.equals("")) {
                                List<?> levelList = levelMasterService.readByName(level.trim().toLowerCase());
                                if (!levelList.isEmpty()) {
                                    levelMaster = (LevelMaster) levelList.get(0);
                                    employeeMaster.setLevelMaster(levelMaster);
                                } else {
                                    levelMaster.setLevel(level);
                                    //levelMasterService.create(levelMaster);
                                    createCheckFlags[2] = true;
                                    employeeMaster.setLevelMaster(levelMaster);

                                }
                            } else {
                                employeeMaster.setLevelMaster(null);
                            }

                            if (!designation.equals("")) {
                                List<?> departmentList = designationMasterService.readByName(designation.trim().toLowerCase());
                                if (!departmentList.isEmpty()) {
                                    designationMaster = (DesignationMaster) departmentList.get(0);
                                    employeeMaster.setDesignationMaster(designationMaster);
                                } else {
                                    designationMaster.setLevelMaster(levelMaster);
                                    designationMaster.setDesignationName(designation);
                                    //designationMasterService.create(designationMaster);
                                    createCheckFlags[3] = true;
                                    employeeMaster.setDesignationMaster(designationMaster);
                                }
                            } else {
                                employeeMaster.setDesignationMaster(null);
                            }

                            if (!department.equals("")) {
                                List<?> departmentList = departmentMasterService.readByName(department.trim().toLowerCase());
                                if (!departmentList.isEmpty()) {
                                    departmentMaster = (DepartmentMaster) departmentList.get(0);
                                    employeeMaster.setDepartmentMaster(departmentMaster);
                                } else {
                                    departmentMaster.setDepartmentName(department);
                                    //departmentMasterService.create(departmentMaster);
                                    createCheckFlags[4] = true;
                                    employeeMaster.setDepartmentMaster(departmentMaster);
                                }
                            } else {
                                employeeMaster.setDepartmentMaster(null);
                            }
//
                            if (!workLocation.equals("")) {
                                List<?> zydexLocationList = zydexLocationMasterService.readByName(workLocation.trim().toLowerCase());
                                if (!zydexLocationList.isEmpty()) {
                                    zydexLocationMaster = (ZydexLocationMaster) zydexLocationList.get(0);
                                    employeeMaster.setZydexLocationMaster(zydexLocationMaster);
                                } else {
                                    zydexLocationMaster.setZydexLocation(workLocation);
                                    //zydexLocationMasterService.create(zydexLocationMaster);
                                    createCheckFlags[5] = true;
                                    employeeMaster.setZydexLocationMaster(zydexLocationMaster);
                                }
                            } else {
                                employeeMaster.setZydexLocationMaster(null);
                            }

                            if (!workLocation.equals("")) {
                                List<?> workLocationList = locationMasterService.readByName(workLocation.trim().toLowerCase());
                                if (!workLocationList.isEmpty()) {
                                    locationMaster = (LocationMaster) workLocationList.get(0);
                                    employeeMaster.setLocationMaster(locationMaster);
                                } else {
                                    locationMaster.setLocation(workLocation);
                                    //locationMasterService.create(locationMaster);
                                    createCheckFlags[6] = true;
                                    employeeMaster.setLocationMaster(locationMaster);
                                }
                            } else {
                                employeeMaster.setLocationMaster(null);
                            }

                            employeeMaster.setCompany(company);
                            employeeMaster.setOfficeEmailId(flyDocsEmailId);
                            employeeMaster.setContactNo1(contactNo);
                            employeeMaster.setContactNo2(contactNo2);
                            employeeMaster.setFatherName(fatherNamed1);
                            employeeMaster.setMotherName(motherNamed2);
                            employeeMaster.setDateOfBirth(dobformated);
                            if (gender.contains("M")) {
                                gender1 = false;
                            } else {
                                gender1 = true;
                            }
                            employeeMaster.setGender(gender1);
                            if(maritalStatus.contains("Unmarried")){
                                String marstatus = "UnMarried";
                                employeeMaster.setMaritalStatus(marstatus);
                            }else if(maritalStatus.contains("unmarried")){
                                String marstatus = "UnMarried";
                                employeeMaster.setMaritalStatus(marstatus);
                            }else if(maritalStatus.contains("married")){
                                String marstatus = "Married";
                                employeeMaster.setMaritalStatus(marstatus);
                            }else{
                                employeeMaster.setMaritalStatus(maritalStatus);
                            }
                            
                            employeeMaster.setSpouseName(spouseNamed3);
                            employeeMaster.setPanCard(pan.toUpperCase());
                            employeeMaster.setPermanentAddress(permanentAddress1);
                            employeeMaster.setBloodGroups(bloodGroup);
                            employeeMaster.setEmailAddress(personalEmailId);
                            employeeMaster.setEmergencyContactPerson(emergencyContactPerson);
                            employeeMaster.setEmergencyContactNo(econtactNo);
                            employeeMaster.setAdharCard(aNo);
                            employeeMaster.setHighestEducationDetails(highestEducation);
                            employeeMaster.setExperienceYearOnDoj(employeeeEXPonJoiningYears);
                            employeeMaster.setExperienceMonthOnDoj(employeeeEXPonJoiningMonths);
                            employeeMaster.setRole(role);
                            employeeMaster.setBankName(bankName);
                            employeeMaster.setBankAccountNo(bNo);
                            employeeMaster.setBankIfscCode(ifscCode);
                           

                            if (!reportingManager.equals("")) {
                                List<?> reportingManagerList = employeeMasterService.readByName(reportingManager);
                                EmployeeMaster employeeMaster1 = new EmployeeMaster();
                                int reportingManagerLevel1 = 0;
                                if (!reportingManagerList.isEmpty()) {
                                    employeeMaster1 = (EmployeeMaster) reportingManagerList.get(0);
                                    reportingManagerLevel1 = employeeMaster1.getId();
                                    employeeMaster.setReportingManagerLevel1("" + reportingManagerLevel1);

                                }
                                
                                
                                List<?> reportingHierarchyList = employeeMasterService.readReportingHierarchyList(employeeMaster1.getId());
                                Object[] reportingHierarchyArray;
                                if (!reportingHierarchyList.isEmpty()) {
                                    reportingHierarchyArray = (Object[]) reportingHierarchyList.get(0);
                                    String reportingHierarchyString = "";
                                    for (int i = 0; i < reportingHierarchyArray.length; i++) {
                                        reportingHierarchyString = reportingHierarchyString + ((reportingHierarchyArray[i] == null) ? "" : reportingHierarchyArray[i]) + "~";
                                    }
                                    String[] reportingHierarchyStringSplitArray = reportingHierarchyString.split("~");
                                    //blank whole fields before put new data
                                    employeeMaster.setReportingManagerLevel2("");
                                    employeeMaster.setReportingManagerLevel3("");
                                    employeeMaster.setReportingManagerLevel4("");
                                    employeeMaster.setReportingManagerLevel5("");
                                    employeeMaster.setReportingManagerLevel6("");
                                    if (reportingHierarchyStringSplitArray.length > 0) {
                                        employeeMaster.setReportingManagerLevel2(reportingHierarchyStringSplitArray[0]);
                                        employeeMaster.setReportingManagerLevel3(reportingHierarchyStringSplitArray[1]);
                                        employeeMaster.setReportingManagerLevel4(reportingHierarchyStringSplitArray[2]);
                                        if (("".equals(reportingHierarchyStringSplitArray[4]) || reportingHierarchyStringSplitArray[4] == null) && ("".equals(reportingHierarchyStringSplitArray[5]) || reportingHierarchyStringSplitArray[5] == null)) {
                                            if ("".equals(reportingHierarchyStringSplitArray[2]) || reportingHierarchyStringSplitArray[2] == null) {
                                                employeeMaster.setReportingManagerLevel6("" + reportingManagerLevel1);
                                            } else {
                                                employeeMaster.setReportingManagerLevel5("" + reportingManagerLevel1);
                                                employeeMaster.setReportingManagerLevel6(reportingHierarchyStringSplitArray[2]);
                                            }
                                        } else {
                                            if ("".equals(reportingHierarchyStringSplitArray[4]) || reportingHierarchyStringSplitArray[4] == null) {
                                                employeeMaster.setReportingManagerLevel5("" + reportingManagerLevel1);
                                            } else {
                                                employeeMaster.setReportingManagerLevel5(reportingHierarchyStringSplitArray[4]);
                                            }
                                            employeeMaster.setReportingManagerLevel6(reportingHierarchyStringSplitArray[5]);
                                        }
                                    }

                                }
                                
                                if (!LineManager2.equals("")) {
                                    List<?> reportingManager2List = employeeMasterService.readByName(LineManager2);
                                    EmployeeMaster employeeMaster2 = new EmployeeMaster();
                                    Integer reportingManagerLevel7 = 0;
                                    if (!reportingManager2List.isEmpty()) {
                                        employeeMaster2 = (EmployeeMaster) reportingManager2List.get(0);
                                        reportingManagerLevel7 = employeeMaster2.getId();
//                                        employeeMaster.setReportingManagerLevel7(reportingManagerLevel7);

                                    }
                                    
                                }
                                
                                
                                
                            }
                            UserMaster userMaster = new UserMaster();
                            userMaster.setUserName(employeeNo);
                            userMaster.setPassword("Admin@123");
                            String workTypeTemp = "";
                            String shiftRotationTemp = "";
                            String shiftTemp = "";
                            EmployeeMasterExtensionValidator employeeExtensionValidator = new EmployeeMasterExtensionValidator();
        
                            if (!userMasterService.isExist(employeeNo)) {
                                userMaster.setFirstTime(true);//this is for change password forcibly when user first time logsIn.
                                //userMasterService.create(userMaster);
                                createCheckFlags[7] = true;
                                employeeMaster.setUserMaster(userMaster);

//                            employeeMaster.setShiftType("");
//                    ***************************************Shift Create Starts Here.*******************************
                                if (!workType.equals("")) {
                                    workTypeTemp = workType.trim().toLowerCase();
                                    //removes spaces (+ for more than one spaces).
                                    //set work type is shiftBase or HoursBase in EmployeeMaster.
//                                employeeMaster.setShiftType(workType.trim());
                                    if (workTypeTemp.contains("shift")) {
                                        //set work type is shiftBase or HoursBase in EmployeeMaster.
                                        employeeMaster.setShiftType("ShiftBase");
                                        //Shift Change and its implementation.
                                        if (!shiftRotation.equals("")) {
                                            shiftRotationTemp = shiftRotation.trim().toLowerCase();
                                            //removes spaces (+ for more than one spaces).
//                                        shiftRotationMaster.setTitle(shiftRotationTemp);
                                            List<?> shiftRotationMasterList = shiftRotationMasterService.readByShiftRotationName(shiftRotationTemp);
                                            if (!shiftRotationMasterList.isEmpty()) {
                                                shiftRotationMaster = (ShiftRotationMaster) shiftRotationMasterList.get(0);
                                                shiftRotationInfo.setShiftRotationMaster(shiftRotationMaster);
                                                //get shiftrotation masterdata.....
                                            } else {
                                                shiftRotationMaster.setTitle(shiftRotation.trim());
                                                shiftRotationMaster.setDuration("weekly");
                                                shiftRotationMaster.setRemark("Generated By Excell Upload.");
                                                //shiftRotationMasterService.create(shiftRotationMaster);
                                                createCheckFlags[8] = true;
                                                shiftRotationInfo.setShiftRotationMaster(shiftRotationMaster);
                                                isShiftRotationCreated = true;//new record inserted in ShiftRotationMaster.
                                                //then Enter Records(shiftRotationMasterId,ShiftMasterId) In RotationMaster Table.
                                            }
                                            //set Shift Change master data to EmployeeMaster.....
                                            employeeMaster.setShiftHoursId(shiftRotationMaster.getId());
                                        } else {
//                                employeeMaster.setshift(workType);
                                        }
                                        //shift name and its implementation.
                                        if (!shiftName.equals("")) {
                                            shiftTemp = shiftName.trim().toLowerCase();
                                            //removes spaces (+ for more than one spaces).
//                                        shiftRotationMaster.setTitle(shiftRotationTemp);
                                            List<?> getByShiftNameList = shiftMasterService.getByShiftName(shiftTemp);
                                            if (!getByShiftNameList.isEmpty()) {
                                                shiftMaster = (ShiftMaster) getByShiftNameList.get(0);
                                                shiftRotationInfo.setFirstShiftId(shiftMaster.getId());
                                            } else {
                                                List<?> shiftMasteDefaultList = shiftMasterService.read();
                                                if (!shiftMasteDefaultList.isEmpty()) {
                                                    shiftMasteDefault = (ShiftMaster) shiftMasteDefaultList.get(0);
                                                    shiftRotationInfo.setFirstShiftId(shiftMasteDefault.getId());
                                                    isShiftMasterCreated = true;
//                                                //set shift master data to EmployeeMaster.....
//                                                employeeMaster.setShiftHoursId(shiftMasteDefault.getId());
                                                }
                                            }
                                        } else {
//                                employeeMaster.setshift(workType);
                                        }
                                        //enter data in rotation master table if shiftRotationMaster new Created
                                        if (isShiftRotationCreated) {
                                            rotationMaster.setShiftRotationMaster(shiftRotationMaster);
                                            if (isShiftMasterCreated) {
                                                rotationMaster.setShiftMaster(shiftMasteDefault);
                                                isShiftMasterCreated = false;//reset it again because instance member.
                                            } else {
                                                rotationMaster.setShiftMaster(shiftMaster);
                                            }
                                            //rotationMasterService.createOrUpdate(rotationMaster);
                                            createCheckFlags[9] = true;
                                            isShiftRotationCreated = false;//reset it again because instance member.
                                        }
//                                            else {
//                                            rotationMaster.setShiftRotationMaster(shiftRotationMaster);
//                                            if (isShiftMasterCreated) {
//                                                rotationMaster.setShiftMaster(shiftMasteDefault);
//                                                isShiftMasterCreated = false;//reset it again because instance member.
//                                            } else {
//                                                rotationMaster.setShiftMaster(shiftMaster);
//                                            }
//                                            List isRotaionExistList = rotationMasterService.isRotationExist(rotationMaster);
//                                            if (isRotaionExistList.isEmpty()) {//if no roatation exist then create one.
//                                            rotationMasterService.createOrUpdate(rotationMaster);
//                                            }
//                                        }
                                        //setting Shift Change date.
                                        LocalDate today = LocalDate.now(ZoneId.of("Asia/Kolkata"));
                                        LocalDate firstOfCurrentMonth = today.with(ChronoField.DAY_OF_MONTH, 1);
                                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                        shiftRotationDate = firstOfCurrentMonth.format(formatter);
                                        shiftRotationInfo.setRotationDate(shiftRotationDate);
                                        //set usermaster data for creation in database entry
                                        shiftRotationInfo.setUserMaster(userMaster);
                                        //check data for user name is exist or not In shiftRotationInfo.
                                        List<?> getShiftRotationInfoByUsernameList = shiftRotationInfoService.readRotaionDetail(shiftRotationInfo);
                                        if (!getShiftRotationInfoByUsernameList.isEmpty()) {
                                            //update that field
                                            ShiftRotationInfo shiftRotationInfo2 = new ShiftRotationInfo();
                                            shiftRotationInfo2 = (ShiftRotationInfo) getShiftRotationInfoByUsernameList.get(0);
                                            shiftRotationInfo.setId(shiftRotationInfo2.getId());
                                            updateCheckFlags[0] = true;
                                            //shiftRotationInfoService.update(shiftRotationInfo);
                                        } else {
                                            //create new entry in Shift ChangeInfo.
                                            //shiftRotationInfoService.create(shiftRotationInfo);
                                            createCheckFlags[10] = true;
                                        }
                                        //Shift Change date in employeeMaster if shiftBase workType.
                                        employeeMaster.setShiftRotationDate(shiftRotationDate);
                                        //Shift Hours Id (shiftMasterId or HoursBaseId).
//                                    employeeMaster.setShiftHoursId(shiftMaster.getId());
                                    }
                                    if (workTypeTemp.contains("hour")) {
                                        //set work type is shiftBase or HoursBase in EmployeeMaster.
                                        employeeMaster.setShiftType("HourlyBase");
                                        //shift name and its implementation.
                                        if (!hours.equals("")) {
                                            //removes spaces (+ for more than one spaces).
//                                        shiftRotationMaster.setTitle(shiftRotationTemp);
                                            List<?> hoursBasisList = hoursBasisService.checkByTitleOfHourBasis(hours.trim().toLowerCase());
                                            if (!hoursBasisList.isEmpty()) {
                                                hoursBasis = (HoursBasis) hoursBasisList.get(0);
                                                //set shift master data to EmployeeMaster.....
                                                employeeMaster.setShiftHoursId(hoursBasis.getId());
                                            } else {
                                                HoursBasis hoursBasisDefault = new HoursBasis();
                                                List<?> hoursBasisDefaultList = hoursBasisService.read();
                                                if (!hoursBasisDefaultList.isEmpty()) {
                                                    hoursBasisDefault = (HoursBasis) hoursBasisDefaultList.get(0);
                                                    //set shift master data to EmployeeMaster.....
                                                    employeeMaster.setShiftHoursId(hoursBasisDefault.getId());
                                                }
                                            }
                                        } else {
//                                employeeMaster.setshift(workType);
                                        }
                                    }
                                }
//                    ***************************************Shift Create Ends Here.*******************************

                                //employeeMasterService.create(employeeMaster);
                                createCheckFlags[11] = true;
                                employeeMasterExtension.setEmployeeMaster(employeeMaster);
                                //employeeMasterServiceExtension.create(employeeMasterExtension);
                                employeeVisaDetails.setEmployeeMaster(employeeMaster);
                                //employeeVisaDetailsService.create(employeeVisaDetails);

                                //        Code for Shift generate monthly Schedule(Start)
//                if (employeeMaster.getShiftType().equals("ShiftBase")) {
                                if ("ShiftBase".equals(employeeMaster.getShiftType())) {
                                    ShiftGenerateMonthlySchedule shiftGenerateMonthlySchedule = new ShiftGenerateMonthlySchedule();
                                    shiftGenerateMonthlySchedule.setEmployeeMaster(employeeMaster);
                                    //already shiftRotationMaster implemented in above code for shift and co-related data generation.
                                    //String shfitId = "" + request.getParameter("shiftId");
//                                String shiftRotationDate = "" + request.getParameter("shiftRotationDate");
                                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                                    Date rd = sdf.parse(shiftRotationDate);//if shift based then it(shiftRotationDate) canbe get from above shiftbase conditional coda
                                    LocalDate localDate = rd.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                                    int year = localDate.getYear();
                                    String cyear = "" + year;
                                    int month = localDate.getMonthValue();
                                    String cmonth = "" + month;
                                    int dayofmonth = localDate.getDayOfMonth();
                                    String cdayofmonth = "" + dayofmonth;
//                     shiftGenerateMonthlySchedule.setShiftMonth(cmonth);
//                     shiftGenerateMonthlySchedule.setShiftYear(cyear);
                                    Calendar c = Calendar.getInstance();
                                    Date newDate = c.getTime();
                                    int tday = c.get(Calendar.DATE);
//                                shiftRotationMaster = shiftRotationMasterService.readById(Integer.parseInt(shfitId));
                                    //already shiftRotationMaster implemented in above code for shift and co-related data generation.
                                    String duration = "" + shiftRotationMaster.getDuration();
                                    int day = c.getActualMaximum(Calendar.DAY_OF_MONTH);
                                    RotationMaster rotationMasterForFirstShiftCheck = new RotationMaster();
                                    rotationMasterForFirstShiftCheck.setShiftRotationMaster(shiftRotationMaster);
                                    String shiftMasterId = "";
                                    if (isShiftMasterCreated) {
                                        shiftMasterId = "" + shiftMasteDefault.getId();
                                    } else {
                                        shiftMasterId = "" + shiftMaster.getId();
                                    }
                                    if ("monthly".equals(duration) && day == 30) {
                                        weeklyGenerate(rotationMasterForFirstShiftCheck, rd, shiftRotationMaster, 30, employeeMaster, shiftMasterId);
                                    } else if ("weekly".equals(duration)) {
                                        weeklyGenerateShift(rotationMasterForFirstShiftCheck, rd, shiftRotationMaster, 7, employeeMaster, shiftMasterId);
                                    } else if ("fortNightly".equals(duration)) {
                                        weeklyGenerate(rotationMasterForFirstShiftCheck, rd, shiftRotationMaster, 14, employeeMaster, shiftMasterId);
                                    } else {
                                        weeklyGenerate(rotationMasterForFirstShiftCheck, rd, shiftRotationMaster, day, employeeMaster, shiftMasterId);
                                    }
                                }
//        Code for Shift generate monthly Schedule(End)

//                    ****************************************User Rights Creation Starts*******************************
                                UserRightMaster userRightMaster = new UserRightMaster();
                                userRightMaster.setEmployee(true);//By default employee right for allows logsIn successfully without Exception.
                                userRightMaster.setUserMaster(userMaster);
                                //userRightMasterService.create(userRightMaster);
                                //createCheckFlags[12] = true;
//                    ***************************************User Rights Creation End.*******************************

//                    ***************************************Leave Balance Create*******************************
////                            EmployeeLeaveBalance employeeLeaveBalance = new EmployeeLeaveBalance();
////                            boolean isLeapYear = false;
////                            LeaveTypeMaster leaveTypeMaster = new LeaveTypeMaster();
////                            List<?> leaveType = leaveTypeMasterService.read();
////                            final boolean gender_Female = employeeMaster.getGender();
////                            for (Object o : leaveType) {
////                                employeeLeaveBalance = new EmployeeLeaveBalance();
////                                leaveTypeMaster = (LeaveTypeMaster) o;
////                                employeeLeaveBalance.setLeaveTypeMaster(leaveTypeMaster);
////                                employeeLeaveBalance.setEmployeeMaster(employeeMaster);
////                                String noOfLeave = "" + leaveTypeMaster.getNoOfLeave();
////                                String leave = "" + leaveTypeMaster.getLeaveType();
////                                Calendar cal1 = new GregorianCalendar();
////                                Calendar cal2 = new GregorianCalendar();
////                                Calendar gc = new GregorianCalendar();
////                                int year = gc.get(Calendar.YEAR);
////                                String cyear = "" + year;
////                                String dateOfEndMonth = "31/12/";
////                                String dateOfEnd = dateOfEndMonth + cyear;
////                                if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
////                                    isLeapYear = true;
////                                }
////                                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
////
////                                Date date1 = sdf.parse(dateOfJoining);
////                                cal1.setTime(date1);
////                                Date date2 = sdf.parse(dateOfEnd);
////                                cal2.setTime(date2);
////                                int y = Integer.parseInt(noOfLeave);
////                                long days = date2.getTime() - date1.getTime();
////                                long diffDays = days / (24 * 60 * 60 * 1000) + 1;
////                                if (leave.equals("Sick Leave")) {
////                                    if (isLeapYear == true) {
////                                        long SL = (diffDays * y / 366) + 1;
////                                        employeeLeaveBalance.setNoOfLeaveRemain(SL);
////                                    } else {
////                                        long SL = (diffDays * y / 365) + 1;
////                                        employeeLeaveBalance.setNoOfLeaveRemain(SL);
////                                    }
////                                } else if (leave.equals("Casual Leave")) {
////                                    if (isLeapYear == true) {
////                                        long CL = (diffDays * y / 366) + 1;
////                                        employeeLeaveBalance.setNoOfLeaveRemain(CL);
////                                    } else {
////                                        long CL = (diffDays * y / 365) + 1;
////                                        employeeLeaveBalance.setNoOfLeaveRemain(CL);
////                                    }
////                                } else if (leave.equals("Privilege Leave")) {
////                                    if (isLeapYear == true) {
////                                        long PL = (diffDays * y / 366) + 1;
////                                        employeeLeaveBalance.setNoOfLeaveRemain(PL);
////                                    } else {
////                                        long PL = (diffDays * y / 365) + 1;
////                                        employeeLeaveBalance.setNoOfLeaveRemain(PL);
////                                    }
////                                } else if (leave.equals("Paternity Leave") && !gender_Female) {
////                                    if (isLeapYear == true) {
////                                        long PAT = (diffDays * y / 366) + 1;
////                                        employeeLeaveBalance.setNoOfLeaveRemain(PAT);
////                                    } else {
////                                        long PAT = (diffDays * y / 365) + 1;
////                                        employeeLeaveBalance.setNoOfLeaveRemain(PAT);
////                                    }
////                                } else if (leave.equals("Maternity Leave")) {
////                                    if (gender_Female) {
////                                        long ML = 0;
////                                        employeeLeaveBalance.setNoOfLeaveRemain(ML);
////                                    }
////                                } else if (leave.equals("Short Leave")) {
////                                    if (isLeapYear == true) {
////                                        long SHL = (diffDays * y / 366) + 1;
////                                        employeeLeaveBalance.setNoOfLeaveRemain(SHL);
////                                    } else {
////                                        long SHL = (diffDays * y / 365) + 1;
////                                        employeeLeaveBalance.setNoOfLeaveRemain(SHL);
////                                    }
////                                } else if (leave.equals("Leave Without Pay")) {
////                                    if (isLeapYear == true) {
////                                        long LWP = (diffDays * y / 366) + 1;
////                                        employeeLeaveBalance.setNoOfLeaveRemain(LWP);
////                                    } else {
////                                        long LWP = (diffDays * y / 365) + 1;
////                                        employeeLeaveBalance.setNoOfLeaveRemain(LWP);
////                                    }
////                                }
////
////                                employeeLeaveBalanceService.create(employeeLeaveBalance);
//
//                            }
//                    ***************************************Leave Balance Create*******************************
// code by yoo.........................from......................
                                boolean isLeapYear = false;
                                //-------- Leave Section -----------------------
                                
//                                LeaveTypeMaster leaveTypeMaster = new LeaveTypeMaster();
//                                EmployeeLeaveBalance employeeLeaveBalance = new EmployeeLeaveBalance();
//                                List<?> leaveType = leaveTypeMasterService.read();
//                                final boolean gender_Female = employeeMaster.getGender();
//                                String marital_status = employeeMaster.getMaritalStatus();
//                                
//                                List<EmployeeLeaveBalance> employeeLeaveBalanceList = new ArrayList();
//        
//                                for (Object o : leaveType) {
//                                    employeeLeaveBalance = new EmployeeLeaveBalance();
//                                    leaveTypeMaster = (LeaveTypeMaster) o;
//                                    employeeLeaveBalance.setLeaveTypeMaster(leaveTypeMaster);
//                                    employeeLeaveBalance.setEmployeeMaster(employeeMaster);
//                                    String noOfLeave = "" + leaveTypeMaster.getNoOfLeave();
//                                    String leave = "" + leaveTypeMaster.getLeaveType();
//                                    Calendar cal1 = new GregorianCalendar();
//                                    Calendar cal2 = new GregorianCalendar();
//                                    Calendar gc = new GregorianCalendar();
//                                    int year = gc.get(Calendar.YEAR);
//                                    String cyear = "" + year;
//                                    String dateOfEndMonth = "31/12/";
//                                    String dateOfEnd = dateOfEndMonth + cyear;
//                                    if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
//                                        isLeapYear = true;
//                                    }
//                                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//
//                                     SimpleDateFormat sdfDOJ3 = new SimpleDateFormat("dd-MMM-yyyy");
//                                    SimpleDateFormat sdfDOJ4 = new SimpleDateFormat("dd/MM/yyyy");
//
//                                    Date dateDOJ1 = sdfDOJ3.parse(dateOfJoiningNonFormated);
//                                    String dateOfJoining1 = sdfDOJ4.format(dateDOJ1);
//                                    Date date1 = sdf.parse(dateOfJoining1);
//                                    Date date3 = new Date();
//                                    cal1.setTime(date1);
//                                    Date date2 = sdf.parse(dateOfEnd);
//                                    cal2.setTime(date2);
//                                    int y = Integer.parseInt(noOfLeave);
//                                    long days = 0;
//                                    if (date1.before(date3)) {
//                                        days = date2.getTime() - date3.getTime();
//                                    } else {
//                                        days = date2.getTime() - date1.getTime();
//                                    }
//                                    long diffDays = days / (24 * 60 * 60 * 1000) + 1;
//                                    if (leave.equals("Sick Leave")) {
//                                        if (isLeapYear == true) {
//                                            long SL = (diffDays * y / 366) + 1;
//                                            employeeLeaveBalance.setNoOfLeaveRemain(SL);
//                                        } else {
//                                            long SL = (diffDays * y / 365) + 1;
//                                            employeeLeaveBalance.setNoOfLeaveRemain(SL);
//                                        }
//                                    } else if (leave.equals("Casual Leave")) {
//                                        if (isLeapYear == true) {
//                                            long CL = (diffDays * y / 366) + 1;
//                                            employeeLeaveBalance.setNoOfLeaveRemain(CL);
//                                        } else {
//                                            long CL = (diffDays * y / 365) + 1;
//                                            employeeLeaveBalance.setNoOfLeaveRemain(CL);
//                                        }
//                                    } //                else if (leave.equals("Privilege Leave")) {
//                                    //                    if (isLeapYear == true) {
//                                    //                        long PL = (diffDays * y / 366) + 1;
//                                    //                        employeeLeaveBalance.setNoOfLeaveRemain(PL);
//                                    //                    } else {
//                                    //                        long PL = (diffDays * y / 365) + 1;
//                                    //                        employeeLeaveBalance.setNoOfLeaveRemain(PL);
//                                    //                    }
//                                    //                }
//                                    else if (leave.equals("Paternity Leave") && !gender_Female && marital_status.equals("Married")) {
//                                        if (isLeapYear == true) {
////                        long PAT = (diffDays * y / 366) + 1;
//                                            long PAT = 6;
//                                            employeeLeaveBalance.setNoOfLeaveRemain(PAT);
//                                        } else {
//                                            long PAT = 6;
//                                            employeeLeaveBalance.setNoOfLeaveRemain(PAT);
//                                        }
//                                    } else if (leave.equals("Maternity Leave")) {
//                                        if (gender_Female) {
//                                            long ML = 0;
//                                            employeeLeaveBalance.setNoOfLeaveRemain(ML);
//                                        }
//                                    } else if (leave.equals("Short Leave")) {
//                                        if (isLeapYear == true) {
//                                            long SHL = (diffDays * y / 366) + 1;
//                                            employeeLeaveBalance.setNoOfLeaveRemain(SHL);
//                                        } else {
//                                            long SHL = (diffDays * y / 365) + 1;
//                                            employeeLeaveBalance.setNoOfLeaveRemain(SHL);
//                                        }
//                                    } else if (leave.equals("Leave Without Pay")) {
//                                        if (isLeapYear == true) {
//                                            long LWP = (diffDays * y / 366) + 1;
//                                            employeeLeaveBalance.setNoOfLeaveRemain(LWP);
//                                        } else {
//                                            long LWP = (diffDays * y / 365) + 1;
//                                            employeeLeaveBalance.setNoOfLeaveRemain(LWP);
//                                        }
//                                    }
//                                    
//                                    employeeLeaveBalanceList.add(employeeLeaveBalance);
//                                    // Iterator array list store data
//                                }
                                //--------------------- End of leave balance --------------
                                
                                // ----------------------------------------------------
                                employeeMaster.setJobDescription("Write Job Description over here");
                                employeeMaster.setUserMaster(userMaster);
                                employeeMasterExtension.setNationality(nationality);
                                //---------------
                                employeeMasterValidator.validate(employeeMaster, errors);
                                
                                employeeExtensionValidator.validate(employeeMasterExtension, errors2);
                                if (errors.hasErrors() || errors2.hasErrors()) {
                                    //errorFlag = true;
                                    //errorCounter++;
                                    //request.setAttribute("failureMessage",
                                    //        "Error : The Entered Information is not valid.");
                                    
                                    //request.setAttribute("failureMessage",
                                    //   "<br/>Error : Employee No:"+ employeeNo + " - Unable to Insert employee due to Information is not valid.");
                                    //request.setAttribute("failureMessage", " <br/> Employee No:"+ employeeNo + " Error Description : " + errorMessage );
                                    strBuffFailer.append("<br/>Error : Employee No:"+ employeeNo + " - Unable to Insert employee due to Information is not valid." );
                                   
                                    for (ObjectError individualError : errors.getAllErrors()) {
                                        //individualError.getDefaultMessage();
                                        String errorMsg = individualError.getCode();
                                        //request.setAttribute("failureMessage", " <br/> Employee No:"+ employeeNo + " Error Description : " + individualError.getDefaultMessage() );
                                        strBuffFailer.append(" <br/> Insert Employee No:"+ employeeNo + " Error Description : " +errorMsg );
                                    }
                                    for (ObjectError individualError : errors2.getAllErrors()) {
                                        //individualError.getDefaultMessage();
                                        String errorMsg = individualError.getCode();
                                        //request.setAttribute("failureMessage", " <br/> Employee No:"+ employeeNo + " Error Description : " + individualError.getDefaultMessage() );
                                        strBuffFailer.append(" <br/> Insert Employee No:"+ employeeNo + " Error Description : " +errorMsg );
                                    }
                                    
                                    stringBuffError.append(employeeNo);
                                    stringBuffError.append(" , ");
                                    
                                    //mv.addAllObjects(errors.getModel());
                                }
                                else
                                {
                                    //------- Iterator array list store data ------------
//                                    ListIterator<EmployeeLeaveBalance> iteratorList = employeeLeaveBalanceList.listIterator(); 
//                                    while (iteratorList.hasNext()) {
//                                         employeeLeaveBalanceService.create(iteratorList.next());
//                                    }
                                    //---------------------------------------------

                                    userRightMasterService.create(userRightMaster);
                                    userMaster.setFirstTime(true);//this is for change password forcibly when user first time logsIn.
                                    userMasterService.create(userMaster);
                                    
                                    employeeMasterService.create(employeeMaster);
                                    employeeMasterServiceExtension.create(employeeMasterExtension);
                                    employeeVisaDetailsService.create(employeeVisaDetails);

                                    if(createCheckFlags[0] == true)
                                    {
                                        employeeTypeService.create(employeeType1);            
                                    }
                                    if(createCheckFlags[1] == true)
                                    {
                                        employeeSubTypeService.create(employeeSubType);         
                                    }
                                    if(createCheckFlags[2] == true)
                                    {
                                        levelMasterService.create(levelMaster);         
                                    }
                                    if(createCheckFlags[3] == true)
                                    {
                                        designationMasterService.create(designationMaster);           
                                    }
                                    if(createCheckFlags[4] == true)
                                    {
                                        departmentMasterService.create(departmentMaster);            
                                    }
                                    if(createCheckFlags[5] == true)
                                    {
                                        zydexLocationMasterService.create(zydexLocationMaster);           
                                    }
                                    if(createCheckFlags[6] == true)
                                    {
                                        locationMasterService.create(locationMaster);            
                                    }
                                    if(createCheckFlags[7] == true)
                                    {
                                        //userMasterService.create(userMaster);           
                                    }
                                    if(createCheckFlags[8] == true)
                                    {
                                        shiftRotationMasterService.create(shiftRotationMaster);           
                                    }
                                    if(createCheckFlags[9] == true)
                                    {
                                        rotationMasterService.createOrUpdate(rotationMaster);
                                    }
                                    if(createCheckFlags[10] == true)
                                    {
                                        shiftRotationInfoService.create(shiftRotationInfo);            
                                    }          
                                    if(updateCheckFlags[0] == true)
                                    {
                                        shiftRotationInfoService.update(shiftRotationInfo);
                                    }
                                    //request.setAttribute("successMessage", "<br/>Success : Employee No: "+ employeeNo + " -  The Employee information is Intserted Successfully.");
                                    
                                    //stringBuffSuccessInsert.append(employeeNo);
                                    //stringBuffSuccessInsert.append(" , ");
                                    stringBuffSuccess.append("<br/>Success : Employee No:"+ employeeNo + " - The Employee Information is Inserted Sucessfully.");
                                }
                                //-----------------------------------------------------
                                // ..............................to......................
                            } else {
                                    //------------------------------------------------------
                                    if(createCheckFlags[0] == true)
                                    {
                                        employeeTypeService.create(employeeType1);            
                                    }
                                    if(createCheckFlags[1] == true)
                                    {
                                        employeeSubTypeService.create(employeeSubType);         
                                    }
                                    if(createCheckFlags[2] == true)
                                    {
                                        levelMasterService.create(levelMaster);         
                                    }
                                    if(createCheckFlags[3] == true)
                                    {
                                        designationMasterService.create(designationMaster);           
                                    }
                                    if(createCheckFlags[4] == true)
                                    {
                                        departmentMasterService.create(departmentMaster);            
                                    }
                                    if(createCheckFlags[5] == true)
                                    {
                                        zydexLocationMasterService.create(zydexLocationMaster);           
                                    }
                                    if(createCheckFlags[6] == true)
                                    {
                                        locationMasterService.create(locationMaster);            
                                    }
                                    if(createCheckFlags[7] == true)
                                    {
                                        userMasterService.create(userMaster);           
                                    }
                                    if(createCheckFlags[8] == true)
                                    {
                                        shiftRotationMasterService.create(shiftRotationMaster);           
                                    }
                                    if(createCheckFlags[9] == true)
                                    {
                                        rotationMasterService.createOrUpdate(rotationMaster);
                                    }
                                    if(createCheckFlags[10] == true)
                                    {
                                        shiftRotationInfoService.create(shiftRotationInfo);            
                                    }         
                                    if(updateCheckFlags[0] == true)
                                    {
                                        shiftRotationInfoService.update(shiftRotationInfo);
                                    }
                                    //request.setAttribute("successMessage", "<br/>Success : Employee No: "+ employeeNo + " -  The Employee information is Intserted Successfully.");

                                    //stringBuffSuccessInsert.append(employeeNo);
                                    //stringBuffSuccessInsert.append(" , ");
                                    
                                    EmployeeMaster employeeMaster1 = new EmployeeMaster();
                                    List<?> list1 = employeeMasterService.readEmployeeId(employeeMaster.getEmployeeId());
                                    employeeMaster1 = (EmployeeMaster) list1.get(0);
                                    employeeMaster.setId(employeeMaster1.getId());
                                    UserMaster userMaster1 = new UserMaster();
                                    userMaster1.setId(employeeMaster1.getUserMaster().getId());
                                    employeeMaster.setUserMaster(userMaster1);
                                    employeeMaster.setShiftType(employeeMaster1.getShiftType());
                                    shiftRotationTemp = shiftRotation.trim().toLowerCase();
                                    List<?> shiftRotationMasterList = shiftRotationMasterService.readByShiftRotationName(shiftRotationTemp);
                                    if (!shiftRotationMasterList.isEmpty()) {
                                        shiftRotationMaster = (ShiftRotationMaster) shiftRotationMasterList.get(0);
                                        shiftRotationInfo.setShiftRotationMaster(shiftRotationMaster);
                                    }
                                    employeeMaster.setShiftHoursId(shiftRotationMaster.getId());

                                    stringBuffer.append(employeeNo);
                                    stringBuffer.append(" , ");
                                    counter++;
                                    
                                    //------------------------------
                                    employeeMaster.setJobDescription("Write Job Description over here");
                                    
                                    employeeMasterValidator.validate(employeeMaster, errors);
                                    
                                    employeeMasterExtension.setEmployeeMaster(employeeMaster);
                                    employeeExtensionValidator.validate(employeeMasterExtension, errors2);
                                    if (errors.hasErrors() || errors2.hasErrors()) {
                                        //errorFlag = true;
                                        //errorCounter++;
                                        //request.setAttribute("failureMessage",
                                        //        "Error : The Entered Information is not valid.");

                                        //request.setAttribute("failureMessage",
                                        //   "<br/>Error : Employee No:"+ employeeNo + " - Unable to Insert employee due to Information is not valid.");
                                        //request.setAttribute("failureMessage", " <br/> Employee No:"+ employeeNo + " Error Description : " + errorMessage );
                                        strBuffFailer.append("<br/>Error : Employee No:"+ employeeNo + " - Unable to Update employee due to Information is not valid." );

                                        for (ObjectError individualError : errors.getAllErrors()) {
                                            //individualError.getDefaultMessage();
                                            String errorMsg = individualError.getCode();
                                            //request.setAttribute("failureMessage", " <br/> Employee No:"+ employeeNo + " Error Description : " + individualError.getDefaultMessage() );
                                            strBuffFailer.append(" <br/> Update Employee No:"+ employeeNo + " Error Description : " +errorMsg );
                                        }
                                        for (ObjectError individualError : errors2.getAllErrors()) {
                                            //individualError.getDefaultMessage();
                                            String errorMsg = individualError.getCode();
                                            //request.setAttribute("failureMessage", " <br/> Employee No:"+ employeeNo + " Error Description : " + individualError.getDefaultMessage() );
                                            strBuffFailer.append(" <br/> Update Employee No:"+ employeeNo + " Error Description : " +errorMsg );
                                        }

                                        stringBuffError.append(employeeNo);
                                        stringBuffError.append(" , ");

                                        //mv.addAllObjects(errors.getModel());
                                    }
                                    else
                                    {
                                        employeeMasterService.update(employeeMaster);
                                        
                                        List<?> employeeMasterExtensionList = employeeMasterServiceExtension.readByemployeeId(employeeMasterExtension.getEmployeeMaster().getId());
                                        EmployeeMasterExtension employeeMasterExtension2 = (EmployeeMasterExtension)employeeMasterExtensionList.get(0);                         
                                        employeeMasterExtension.setId(employeeMasterExtension2.getId());
                                        
                                        employeeMasterServiceExtension.update(employeeMasterExtension);
                                        //request.setAttribute("successMessage",
                                        //    "<br/>Success : Employee No:"+ employeeNo + " - The Employee Information is Updated Sucessfully.");
                                        stringBuffSuccess.append("<br/>Success : Employee No:"+ employeeNo + " - The Employee Information is Updated Sucessfully.");
                                    }
                                }
                          //  }

                        }
                    }
//                        System.out.println("this is an error in excel upload......................................................................" + employeeNo);
//                        System.out.println("this is an error in excel upload......................................................................" + employeeNo);

                    } catch (Exception e) {
                        stringBufferOfExceptions.append(employeeNo);
                        stringBufferOfExceptions.append(" , ");
                        counterOfException++;
                    }
                }
            }
            
//             if ((counter == 0) && (counterOfException==0)) {
//               request.setAttribute("successMessage", "Information : The Excel Uploaded Successfully."); 
//            }
//            
//            //if user already exist then this failure messge will be printed.
//            if (counter > 0) {
//                request.setAttribute("failureMessage", "Information : " + stringBuffer + " Rcecords Not Inserted Due To Existsing Data");
//            }
//            if (counterOfException > 0) {
//                request.setAttribute("failureMessage", " " + stringBufferOfExceptions + " Rcecords Not Inserted Due To Invalid Data");
//                System.out.println("failureMessage," + stringBufferOfExceptions + " Rcecords Not Inserted Due To Invalid Data");
//            }
//            mv = searchSubmit(request, response);
            //---------------------------------------------
            if (counterOfException > 0) {
                request.setAttribute("failureMessage", " " + stringBufferOfExceptions + " Records Not Inserted Due To Invalid Data");
                //System.out.println("failureMessage," + stringBufferOfExceptions + " Rcecords Not Inserted Due To Invalid Data");
            }
            if(stringBuffError.length() > 0)
            {
                request.setAttribute("failureMessage", "<br/> Information :  " + stringBuffError + " Errror in Employee informatation " + strBuffFailer);
            }
            if(stringBuffSuccess.length() > 0)
            {
                request.setAttribute("successMessage", stringBuffSuccess );
            }         
            List<?> employeeMasterList = employeeMasterService.readEmployeesDetail();
            mv.getModelMap().put("list", employeeMasterList);
            //dont rename "list" because same used on getEmployeeDetailsBySearchString method and employeeRegistrationResult.jsp
            mv.getModelMap().put("employeeMaster", employeeMaster);
            mv.setViewName("Employee/EmployeeRegistrationResult");
            //----------------------------------------------
        } catch (Exception e) {
            request.setAttribute("failureMessage", "Information : The Excel Not Upload Successfully. Please Check Excel Data.");
            mv = excelUploadRegistration(request, response);
        }
        return mv;
       
        
      
    }


}
