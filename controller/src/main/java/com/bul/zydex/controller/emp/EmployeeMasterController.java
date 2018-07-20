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
import com.bul.zydex.model.EmployeePolicyDetail;
import com.bul.zydex.model.EmployeeSubType;
import com.bul.zydex.model.EmployeeTypeMaster;
import com.bul.zydex.model.HoursBasis;
import com.bul.zydex.model.LeaveTypeMaster;
import com.bul.zydex.model.LevelMaster;
import com.bul.zydex.model.LocationMaster;
import com.bul.zydex.model.PayrollPfCheck;
import com.bul.zydex.model.PayrollPtCheck;
import com.bul.zydex.model.PmpFormStatusMaster;
import com.bul.zydex.model.PolicyMaster;
import com.bul.zydex.model.RotationMaster;
import com.bul.zydex.model.ShiftGenerateMonthlySchedule;
import com.bul.zydex.model.ShiftMaster;
import com.bul.zydex.model.ShiftRotationInfo;
import com.bul.zydex.model.ShiftRotationMaster;
import com.bul.zydex.model.UserMaster;
import com.bul.zydex.model.UserRightMaster;
import com.bul.zydex.model.ZydexLocationMaster;
import com.bul.zydex.util.DownloadFile;
import com.bul.zydex.validator.PasswordValidator;
import com.google.gson.Gson;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.io.File;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javafx.scene.control.Cell;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.springframework.validation.BindException;
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
        String competencyEvaluationId = request.getParameter("competencyEvaluationId");
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
            request.setAttribute("competencyEvaluationId", competencyEvaluationId);
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv.addAllObjects(errors.getModel());
            selectEmployee(request, response);
            selectedEmployeeLevel1(request, employeeMaster);
//            request.setAttribute("employeeMaster", employeeMaster);
            mv.getModelMap().put("employeeMaster", employeeMaster);
            mv.setViewName("Employee/EmployeeRegistrationForm");
        } else if (DOJ.before(DOB1)) {
            request.setAttribute("failureMessage",
                    "Error : Enter Valid Date of Joining");

            selectEmployee(request, response);
            selectedEmployeeLevel1(request, employeeMaster);
            request.setAttribute("employeeMaster", employeeMaster);
            mv.setViewName("Employee/EmployeeRegistrationForm");
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
            employeeMaster.setCompetencyEvaluationId(Integer.parseInt(competencyEvaluationId));
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
            if (employeeMaster.getPfAmount().equals("")) {
                employeeMaster.setPfAmount("0");
            }
            employeeMasterService.create(employeeMaster);
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
                        if (null != request.getParameter("taxable" + i)) {
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
            request.setAttribute("failureMessage",
                    "Error : User isExist.");
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
        return mv;

    }

    public ModelAndView searchSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = new EmployeeMaster();
//        List<?> employeeMasterList = employeeMasterService.read();
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
        EmployeeSubType employeeSubType = new EmployeeSubType();
        UserMaster userMaster = new UserMaster();
        employeeMaster = employeeMasterService.readById(id);
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
        request.setAttribute("employeeType", employeeMaster.getEmployeeType());
        request.setAttribute("shiftType", employeeMaster.getShiftType());
        request.setAttribute("certificatesList", certificatesList);
        request.setAttribute("finalPolicyList", finalPolicyList);
        request.setAttribute("finalctcList", finalctcList);
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
//        selectedEmployeeLevel2(request, employeeMaster);
//        selectedEmployeeLevel3(request, employeeMaster);
//        selectedEmployeeLevel4(request, employeeMaster);
//        selectedEmployeeLevel5(request, employeeMaster);
//        selectedEmployeeLevel6(request, employeeMaster);
        BindException errors = new BindException(employeeMaster, "employeeMaster");

        //getLastYearPerformance Ratings Of Employee For ReadOnly.s
        List<?> lastYearPerformanceRatingsOfEmployeeList = employeeMasterService.getLastYearPerformanceRatingOfEmployee(employeeMaster.getId());

        lastYearPerformanceRatingsOfEmployee = (lastYearPerformanceRatingsOfEmployeeList.isEmpty()) ? lastYearPerformanceRatingsOfEmployee : String.valueOf(lastYearPerformanceRatingsOfEmployeeList.get(0));
        request.setAttribute("lastYearPerformanceRatingsOfEmployee", lastYearPerformanceRatingsOfEmployee);
        String companyId = request.getParameter("companyId");
        String employeeType = request.getParameter("employeeType");
        employeeMaster.setCompany(companyId);
        employeeMaster.setEmployeeType(employeeType);
        String userId = "" + request.getParameter("userMaster.id");
        String id = request.getParameter("id");
        String zid = request.getParameter("zydexLocationMaster.id");
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
//        employeeMaster.setEmployeeId(id);
//        String reportingManagerLevel1 = request.getParameter("reportingManagerLevel1");
//        String reportingManagerLevel2 = request.getParameter("reportingManagerLevel2");
//        String reportingManagerLevel3 = request.getParameter("reportingManagerLevel3");
//        String reportingManagerLevel4 = request.getParameter("reportingManagerLevel4");
//        String reportingManagerLevel5 = request.getParameter("reportingManagerLevel5");
//        String reportingManagerLevel6 = request.getParameter("reportingManagerLevel6");
        String shiftMasterId = request.getParameter("shiftMasterId");
//        employeeMasterValidator.validate(employeeMaster, errors);
//        if (errors.hasErrors()) {
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
        if (null != employeeMaster.getGender() && !employeeMaster.getGender() && null != employeeMaster.getMaritalStatus() && employeeMaster.getMaritalStatus().equals("Married")) {
            LeaveTypeMaster leaveTypeMaster = new LeaveTypeMaster();
            EmployeeLeaveBalance employeeLeaveBalance = new EmployeeLeaveBalance();
            EmployeeLeaveBalance employeeLeaveBalance1 = new EmployeeLeaveBalance();
            String ptl = "Paternity Leave";
            List<?> ptlList = leaveTypeMasterService.readLeaveTypeEditRegistration(ptl);
            leaveTypeMaster.setId((Integer) ptlList.get(0));
            employeeLeaveBalance.setLeaveTypeMaster(leaveTypeMaster);
            employeeLeaveBalance.setEmployeeMaster(employeeMaster);
            List<?> empLeaveBalList = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance);
            if (empLeaveBalList.size() > 0) {

            } else {
                employeeLeaveBalance1.setEmployeeMaster(employeeMaster);
                employeeLeaveBalance1.setNoOfLeaveRemain(6);
                employeeLeaveBalance1.setLeaveTypeMaster(leaveTypeMaster);
                employeeLeaveBalanceService.create(employeeLeaveBalance1);
            }
        }

        employeeMaster.setPanCard(String.valueOf(employeeMaster.getPanCard()).toUpperCase());//this is for store pan card in uppercase in database.
        userMaster1 = userMasterService.readById(employeeMaster.getUserMaster().getId());
        userMaster1.setUserName(employeeMaster.getEmployeeId());
        userMasterService.update(userMaster1);
        String competencyEvaluationId = request.getParameter("competencyEvaluationId");
        if (!competencyEvaluationId.equals("")) {
            employeeMaster.setCompetencyEvaluationId(Integer.parseInt(competencyEvaluationId));
        }
        employeeMasterService.update(employeeMaster);

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
        String userName = employeeMaster.getEmployeeId();//employeeId and userName are equal.
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
                    if (null != request.getParameter("taxable" + i)) {
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

//        mv.setViewName("Employee/EditUserProfile");
        return mv;
    }

    public ModelAndView deleteSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String empId[] = request.getParameterValues("checkId");
        for (String z : empId) {
            try {
                PmpFormStatusMaster pmpFormStatusMaster = new PmpFormStatusMaster();
                List<?> list11 = pmpFormStatusMasterService.delete1(z);
                for (Object pdf1 : list11) {
                    pmpFormStatusMaster = (PmpFormStatusMaster) pdf1;
//                 Object[] o1=(Object[]) pdf;

                    pmpFormStatusMasterService.delete(pmpFormStatusMaster.getId());
                }

//                pmpFormStatusMasterService.delete1(z);
                employeeMasterService.delete(Integer.parseInt(z));
                //userMasterService.delete (Integer.parseInt(z));
                //userRightMasterService.delete(Integer.parseInt(z));
                request.setAttribute("successMessage",
                        "Info : One or more records are deleted successfully.");
            } catch (Exception e) {

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

            File updatedPicture = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", ""));
            multipartFile.transferTo(updatedPicture);

            if (photoFile.exists() && photoFile.listFiles().length > 0) {
                File[] updatedPictureFiles = photoFile.listFiles();
                imgFile = "StorageYard" + File.separator + "UserProfile" + File.separator + userMaster.getUserName() + File.separator + updatedPictureFiles[0].getName().replaceAll(" ", "");
//            session.setAttribute("profilePicturePath", imgFile);
//            request.setAttribute("imgFile", "StorageYard" + File.separator + "UserProfile" + File.separator + userName + File.separator + updatedPictureFiles[0].getName());
            }
            PrintWriter out = null;
            try {
                out = response.getWriter();
                out.print(imgFile);
            } finally {
                out.close();
            }
            HttpSession session = request.getSession();
            EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
            if (employeeMaster.getEmployeeId().equals(userMaster.getUserName())) {
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
//        EmployeeMaster employeeMaster = new EmployeeMaster();
        UserRightMaster user = (UserRightMaster) request.getSession().getAttribute("userRight");

        //set Employee master id//
        try {
            int id = employeeMaster.getId();//this is employeeMaster's id.
//        employeeMaster.setId(Integer.parseInt(id));
//        employeeMaster.setEmployeeId(id);
            //set Employee master id//
            UserMaster userMaster = new UserMaster();
            employeeMaster = employeeMasterService.readById(id);
            ///this code is for read file name and display it
//        String userName = readUserName(request);
//        String userName = request.getParameter("userid");
            String userName = employeeMaster.getEmployeeId();
            request.setAttribute("userName", userName);//this attribute is for use name and read form directory structure.s
            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "UserProfile"
                    + File.separator + userName + File.separator;
            File pictureFile = new File(fileLocationURL);
            if (pictureFile.exists()) {
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
            selectEmployee(request, response);
            departmentList(request);
            designationList(request);
            levelList(request);
            locationList(request);
            shiftRotaionList(request);
            setZydexLocationList(request);
            policyList(request);
            ctcList(request);
//        shiftList(request);
            hoursBasisList(request);
            //set user master id//
            String userid = request.getParameter("userid");
            userMaster.setId(Integer.parseInt(userid));
            employeeMaster.setUserMaster(userMaster);
            //set Employee master id//
            selectedEmployeeLevel1(request, employeeMaster);
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
//            ctcList.add(policyDetail1[3]);
                finalctcList.add(ctcList);
            }
//        selectedEmployeeLevel2(request, employeeMaster);
//        selectedEmployeeLevel3(request, employeeMaster);
//        selectedEmployeeLevel4(request, employeeMaster);
//        selectedEmployeeLevel5(request, employeeMaster);
//        selectedEmployeeLevel6(request, employeeMaster);

            request.setAttribute("company", employeeMaster.getCompany());
            request.setAttribute("employeeType", employeeMaster.getEmployeeType());
            request.setAttribute("shiftType", employeeMaster.getShiftType());
            request.setAttribute("finalPolicyList", finalPolicyList);
            request.setAttribute("finalctcList", finalctcList);
        } catch (Exception e) {
        }
        mv.getModelMap().put("employeeMaster", employeeMaster);
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
        int counter = 0;
        int counterOfException = 0;
        String employeeNo = "";
        String employeeName = "";
        String dateOfJoiningNonFormated = "";
        String dateOfJoining = "";
        String level = "";
        String designation = "";
        String department = "";
        String zydexLocation = "";
        String workLocation = "";
        String company = "";
        String officialEmailId = "";
        String contactNo = "";
        String contactNoExpo = "";
        String reportingManager = "";
        String fatherName = "";
        String motherName = "";
        String dob = "";
        String dobNonFormated = "";
        String sex = "";
        String maritalStatus = "";
        String spouseName = "";
        String pan = "";
        String permenantAddress = "";
        String bloodGroup = "";
        String personalEmailId = "";
        String emergencyContactPerson = "";
        String emergencyContactNo = "";
        String emergencyContactNoExpo = "";
        String aadharCard = "";
        String aadharCardExpo = "";
        String highestEducation = "";
        String experienceOnDateOfJoiningYear = "";
        String experienceOnDateOfJoiningMonth = "";
        String role = "";
        String bankName = "";
        String bankAccountNo = "";
        String bankAccountNoExpo = "";
        String ifscCode = "";
        String workType = "";//shift(base) or hours(base).
        String hours = "";//(eg...9Hours , 10Hours).
        String shiftRotation = "";//shift Rotation Name.
        String shift = "";//shift Name.
        String shiftRotationDate = "";//this field is filled as 1st date of month of DateOfJoining Date.
        boolean isShiftRotationCreated = false;//if new created then enter information in RotationMaster table.
        boolean isShiftMasterCreated = false;//if new created RotationMaster table with ShiftRotationMaster.
        ShiftMaster shiftMasteDefault = new ShiftMaster();
        String employeeType = "";
        String basicSalary = "";  //basic Salary
        String conveysAmount = ""; //conveysAmount
        String esicNo = ""; //esic no
        String tdsAmount = ""; //tds
        String paymentType = ""; //payment type
        String pfNo = ""; //pf 
        String uanNo = ""; //uano
        String typeofemployee = ""; // employee Type
        String employeeSubtype = ""; // employee sub type
        boolean gender = false;
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBufferOfExceptions = new StringBuffer();
        stringBufferOfExceptions.append("");
        try {
            if (multipartFile.getSize() > 0) {
                InputStream file = multipartFile.getInputStream();
                Workbook workbook = WorkbookFactory.create(file);
                Sheet sheet = workbook.getSheetAt(0);
                for (Row row : sheet) {
                    try {
                        if (row.getRowNum() != 0) {
                            try {
                                employeeNo = new BigDecimal("" + (null == row.getCell((short) 0) ? "" : row.getCell((short) 0))).toPlainString();
                                employeeNo = employeeNo.split("\\.", 2)[0];
                            } catch (Exception e) {
                                employeeNo = "" + (null == row.getCell((short) 0) ? "" : row.getCell((short) 0));
                            }
                            employeeName = "" + (null == row.getCell((short) 1) ? "" : row.getCell((short) 1));
                            dateOfJoiningNonFormated = "" + (null == row.getCell((short) 2) ? "" : row.getCell((short) 2));

                            SimpleDateFormat sdfDOJ = new SimpleDateFormat("dd-MMM-yyyy");
                            SimpleDateFormat sdfDOJ2 = new SimpleDateFormat("dd/MM/yyyy");
////here excell uploa
                            Date dateDOJ = sdfDOJ.parse(dateOfJoiningNonFormated);
//                            String nDate = sdfDOJ.format(dateDOJ);
                            dateOfJoining = sdfDOJ2.format(dateDOJ);

//                            String dateOfJoiningNonFormatedToString = dateDOJ.toString();
//                            Date dateDOJ2 = sdfDOJ2.parse(dateOfJoiningNonFormatedToString);
////                        dateOfJoining = dateDOJ2.toString();
//                            dateOfJoining = "" + sdfDOJ.format(dateOfJoiningNonFormated);
                            company = "" + (null == row.getCell((short) 3) ? "" : row.getCell((short) 3));
                            zydexLocation = "" + (null == row.getCell((short) 4) ? "" : row.getCell((short) 4));
                            workLocation = "" + (null == row.getCell((short) 5) ? "" : row.getCell((short) 5));
                            level = "" + (null == row.getCell((int) 6) ? "" : row.getCell((int) 6));
                            designation = "" + (null == row.getCell((short) 7) ? "" : row.getCell((short) 7));
                            role = "" + (null == row.getCell((short) 8) ? "" : row.getCell((short) 8));
                            employeeType = "" + (null == row.getCell((short) 9) ? "" : row.getCell((short) 9));
                            typeofemployee = "" + (null == row.getCell((short) 10) ? "" : row.getCell((short) 10));
                            employeeSubtype = "" + (null == row.getCell((short) 11) ? "" : row.getCell((short) 11));
                            department = "" + (null == row.getCell((short) 12) ? "" : row.getCell((short) 12));
                            officialEmailId = "" + (null == row.getCell((short) 13) ? "" : row.getCell((short) 13));
                            contactNoExpo = "" + (null == row.getCell((short) 14) ? "" : row.getCell((short) 14));
                            if (!contactNoExpo.equals("")) {
                                BigDecimal bdContactNo = new BigDecimal(contactNoExpo);
                                contactNo = "" + bdContactNo.longValue();
                            } else {
                                contactNo = "";
                            }
                            reportingManager = "" + (null == row.getCell((short) 15) ? "" : row.getCell((short) 15));
                            fatherName = "" + (null == row.getCell((short) 16) ? "" : row.getCell((short) 16));
                            motherName = "" + (null == row.getCell((short) 17) ? "" : row.getCell((short) 17));
                            dobNonFormated = "" + (null == row.getCell((short) 18) ? "" : row.getCell((short) 18));

//DOB formatting before employee creation.
//                        Date dateDOB = sdfDOJ.parse(dobNonFormated);
//                        dob = "" + sdfDOJ2.format(dateDOB);
                            sex = "" + (null == row.getCell((short) 19) ? "" : row.getCell((short) 19));
                            maritalStatus = "" + (null == row.getCell((short) 20) ? "" : row.getCell((short) 20));
                            spouseName = "" + (null == row.getCell((short) 21) ? "" : row.getCell((short) 21));
                            permenantAddress = "" + (null == row.getCell((short) 22) ? "" : row.getCell((short) 22));
                            bloodGroup = "" + (null == row.getCell((short) 23) ? "" : row.getCell((short) 23));
                            personalEmailId = "" + (null == row.getCell((short) 24) ? "" : row.getCell((short) 24));
                            emergencyContactPerson = "" + (null == row.getCell((short) 25) ? "" : row.getCell((short) 25));
                            emergencyContactNoExpo = "" + (null == row.getCell((short) 26) ? "" : row.getCell((short) 26));
                            if (!emergencyContactNoExpo.equals("")) {

                                BigDecimal bdEmergencyContactNo = new BigDecimal(emergencyContactNoExpo);
                                emergencyContactNo = "" + bdEmergencyContactNo.longValue();
                            } else {
                                emergencyContactNo = "";
                            }
                            pan = "" + (null == row.getCell((short) 27) ? "" : row.getCell((short) 27));
                            aadharCardExpo = "" + (null == row.getCell((short) 28) ? "" : row.getCell((short) 28));
                            if (!aadharCardExpo.equals("")) {

                                BigDecimal bdAadharCard = new BigDecimal(aadharCardExpo);
                                aadharCard = "" + bdAadharCard.longValue();
                            } else {
                                aadharCard = "";
                            }
                            highestEducation = "" + (null == row.getCell((short) 29) ? "" : row.getCell((short) 29));
                            experienceOnDateOfJoiningYear = "" + (null == row.getCell((short) 30) ? "" : row.getCell((short) 30));
                            experienceOnDateOfJoiningMonth = "" + (null == row.getCell((short) 31) ? "" : row.getCell((short) 31));
                            bankName = "" + (null == row.getCell((short) 32) ? "" : row.getCell((short) 32));
                            bankAccountNoExpo = "" + (null == row.getCell((short) 33) ? "" : row.getCell((short) 33));
                            if (!bankAccountNoExpo.equals("")) {
                                BigDecimal bdBankAccountNo = new BigDecimal(bankAccountNoExpo);
                                bankAccountNo = "" + bdBankAccountNo.longValue();
                            } else {
                                bankAccountNo = "";
                            }
                            ifscCode = "" + (null == row.getCell((short) 34) ? "" : row.getCell((short) 34));

                            workType = "" + (null == row.getCell((short) 35) ? "" : row.getCell((short) 35));
                            hours = "" + (null == row.getCell((short) 36) ? "" : row.getCell((short) 36));
                            shiftRotation = "" + (null == row.getCell((short) 37) ? "" : row.getCell((short) 37));
                            shift = "" + (null == row.getCell((short) 38) ? "" : row.getCell((short) 38));

                            basicSalary = "" + (null == row.getCell((short) 39) ? "" : row.getCell((short) 39));

                            paymentType = "" + (null == row.getCell((short) 40) ? "" : row.getCell((short) 40));
                            esicNo = "" + (null == row.getCell((short) 41) ? "" : row.getCell((short) 41));
                            pfNo = "" + (null == row.getCell((short) 42) ? "" : row.getCell((short) 42));
                            uanNo = "" + (null == row.getCell((short) 43) ? "" : row.getCell((short) 43));

                            conveysAmount = "" + (null == row.getCell((short) 44) ? "" : row.getCell((short) 44)); // Field Not Available
                            tdsAmount = "" + (null == row.getCell((short) 45) ? "" : row.getCell((short) 45));  // Field Not Available

                            employeeMaster.setEmployeeId(employeeNo);
                            employeeMaster.setEmployeeName(employeeName);
//                            employeeMaster.setDateOfJoining(dateOfJoiningNonFormated);
                            employeeMaster.setDateOfJoining(dateOfJoining);
                            employeeMaster.setBasicSalary(basicSalary);
                            employeeMaster.setConveysAmount(conveysAmount);
                            employeeMaster.setEsicNo(esicNo);
                            employeeMaster.setTdsAmount(tdsAmount);
                            employeeMaster.setPaymentType(paymentType);
                            employeeMaster.setPfNo(pfNo);
                            employeeMaster.setUanNo(uanNo);

                            if (!typeofemployee.equals("")) {
                                List<?> levelList11 = employeeTypeService.readByName(typeofemployee);
                                if (!levelList11.isEmpty()) {
                                    employeeType1 = (EmployeeTypeMaster) levelList11.get(0);
                                    employeeMaster.setEmployeeTypeMaster(employeeType1);
                                } else {
                                    employeeType1.setTypeOfEmployee(employeeType1.toString());
                                    employeeTypeService.create(employeeType1);
                                    employeeMaster.setEmployeeTypeMaster(employeeType1);

                                }
                            } else {
                                employeeMaster.setEmployeeTypeMaster(null);
                            }
                            if (!employeeSubtype.equals("")) {
                                List<?> levelList2 = employeeSubTypeService.readByName(employeeSubtype);
                                if (!levelList2.isEmpty()) {
                                    employeeSubType = (EmployeeSubType) levelList2.get(0);
                                    employeeMaster.setEmployeeSubType(employeeSubType);
                                } else {
                                    employeeSubType.setSubType(employeeSubType.toString());
                                    employeeSubTypeService.create(employeeSubType);
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
                                    levelMasterService.create(levelMaster);
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
                                    designationMasterService.create(designationMaster);
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
                                    departmentMasterService.create(departmentMaster);
                                    employeeMaster.setDepartmentMaster(departmentMaster);
                                }
                            } else {
                                employeeMaster.setDepartmentMaster(null);
                            }

                            if (!zydexLocation.equals("")) {
                                List<?> zydexLocationList = zydexLocationMasterService.readByName(zydexLocation.trim().toLowerCase());
                                if (!zydexLocationList.isEmpty()) {
                                    zydexLocationMaster = (ZydexLocationMaster) zydexLocationList.get(0);
                                    employeeMaster.setZydexLocationMaster(zydexLocationMaster);
                                } else {
                                    zydexLocationMaster.setZydexLocation(zydexLocation);
                                    zydexLocationMasterService.create(zydexLocationMaster);
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
                                    locationMasterService.create(locationMaster);
                                    employeeMaster.setLocationMaster(locationMaster);
                                }
                            } else {
                                employeeMaster.setLocationMaster(null);
                            }

                            employeeMaster.setCompany(company);
                            employeeMaster.setOfficeEmailId(officialEmailId);
                            employeeMaster.setContactNo1(contactNo);
                            employeeMaster.setFatherName(fatherName);
                            employeeMaster.setMotherName(motherName);
                            employeeMaster.setDateOfBirth(dobNonFormated);
                            if (sex.contains("Male")) {
                                gender = false;
                            } else {
                                gender = true;
                            }
                            employeeMaster.setGender(gender);
                            employeeMaster.setMaritalStatus(maritalStatus);
                            employeeMaster.setSpouseName(spouseName);
                            employeeMaster.setPanCard(pan.toUpperCase());
                            employeeMaster.setPermanentAddress(permenantAddress);
                            employeeMaster.setBloodGroups(bloodGroup);
                            employeeMaster.setEmailAddress(personalEmailId);
                            employeeMaster.setEmergencyContactPerson(emergencyContactPerson);
                            employeeMaster.setEmergencyContactNo(emergencyContactNo);
                            employeeMaster.setAdharCard(aadharCard);
                            employeeMaster.setHighestEducationDetails(highestEducation);
                            employeeMaster.setExperienceYearOnDoj(experienceOnDateOfJoiningYear);
                            employeeMaster.setExperienceMonthOnDoj(experienceOnDateOfJoiningMonth);
                            employeeMaster.setRole(role);
                            employeeMaster.setBankName(bankName);
                            employeeMaster.setBankAccountNo(bankAccountNo);
                            employeeMaster.setBankIfscCode(ifscCode);
                            employeeMaster.setEmployeeType(employeeType);

                            if (!reportingManager.equals("")) {
                                List<?> reportingManagerList = employeeMasterService.readByName(reportingManager);
                                EmployeeMaster employeeMaster1 = new EmployeeMaster();
                                if (!reportingManagerList.isEmpty()) {
                                    employeeMaster1 = (EmployeeMaster) reportingManagerList.get(0);

                                }
                                int reportingManagerLevel1 = employeeMaster1.getId();
                                employeeMaster.setReportingManagerLevel1("" + reportingManagerLevel1);
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
                            }
                            UserMaster userMaster = new UserMaster();
                            userMaster.setUserName(employeeNo);
                            userMaster.setPassword("Admin@123");
                            String workTypeTemp = "";
                            String shiftRotationTemp = "";
                            String shiftTemp = "";

                            if (!userMasterService.isExist(employeeNo)) {
                                userMaster.setFirstTime(true);//this is for change password forcibly when user first time logsIn.
                                userMasterService.create(userMaster);
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
                                        //shift rotation and its implementation.
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
                                                shiftRotationMasterService.create(shiftRotationMaster);
                                                shiftRotationInfo.setShiftRotationMaster(shiftRotationMaster);
                                                isShiftRotationCreated = true;//new record inserted in ShiftRotationMaster.
                                                //then Enter Records(shiftRotationMasterId,ShiftMasterId) In RotationMaster Table.
                                            }
                                            //set shift rotation master data to EmployeeMaster.....
                                            employeeMaster.setShiftHoursId(shiftRotationMaster.getId());
                                        } else {
//                                employeeMaster.setshift(workType);
                                        }
                                        //shift name and its implementation.
                                        if (!shift.equals("")) {
                                            shiftTemp = shift.trim().toLowerCase();
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
                                            rotationMasterService.createOrUpdate(rotationMaster);
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
                                        //setting shift rotation date.
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
                                            shiftRotationInfoService.update(shiftRotationInfo);
                                        } else {
                                            //create new entry in shift RotationInfo.
                                            shiftRotationInfoService.create(shiftRotationInfo);
                                        }
                                        //shift Rotation date in employeeMaster if shiftBase workType.
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

                                employeeMasterService.create(employeeMaster);

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
                                userRightMasterService.create(userRightMaster);
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
                                LeaveTypeMaster leaveTypeMaster = new LeaveTypeMaster();
                                EmployeeLeaveBalance employeeLeaveBalance = new EmployeeLeaveBalance();
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

                                // ..............................to......................
                            } else {
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
                                employeeMasterService.update(employeeMaster);
                                stringBuffer.append(employeeNo);
                                stringBuffer.append(" , ");
                                counter++;
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
            request.setAttribute("successMessage", "Information : The Excel Uploaded Successfully.");
            //if user already exist then this failure messge will be printed.
            if (counter > 0) {
                request.setAttribute("failureMessage", "Information : " + stringBuffer + " Rcecords Not Inserted Due To Existsing Data");
            }
            if (counterOfException > 0) {
                request.setAttribute("failureMessage", " " + stringBufferOfExceptions + " Rcecords Not Inserted Due To Invalid Data");
                System.out.println("failureMessage," + stringBufferOfExceptions + " Rcecords Not Inserted Due To Invalid Data");
            }
            mv = searchSubmit(request, response);
        } catch (Exception e) {
            request.setAttribute("failureMessage", "Information : The Excel Not Upload Successfully. Please Check Excel Data.");
            mv = excelUploadRegistration(request, response);
        }
        return mv;
    }

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

    public ModelAndView exportToExcel(HttpServletRequest request, HttpServletResponse response, EmployeeMaster employeeMaster) throws Exception {
        ModelAndView mv = new ModelAndView();
        String searchEmployeeString = "";
        String searchString = request.getParameter("searchString");
        searchEmployeeString = (searchString == null || searchString == "") ? searchEmployeeString : (searchEmployeeString + searchString);
        List<?> employeeMasterList = employeeMasterService.readEmployeeDataForexportToExcel(searchEmployeeString);
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=EmployeeDataSheet.xls");
        mv.addObject("employeeMasterList", employeeMasterList);
//        mv.getModelMap().put("employeeMaster", employeeMaster);
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
        //getLastYearPerformance Ratings Of Employee For ReadOnly.s
        List<?> lastYearPerformanceRatingsOfEmployeeList = employeeMasterService.getLastYearPerformanceRatingOfEmployee(id);

        lastYearPerformanceRatingsOfEmployee = (lastYearPerformanceRatingsOfEmployeeList.isEmpty()) ? lastYearPerformanceRatingsOfEmployee : String.valueOf(lastYearPerformanceRatingsOfEmployeeList.get(0));
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
        request.setAttribute("maritalStatus", employeeMaster.getMaritalStatus());
        request.setAttribute("lastYearPerformanceRatingsOfEmployee", lastYearPerformanceRatingsOfEmployee);
        request.setAttribute("company", employeeMaster.getCompany());
        request.setAttribute("employeeType", employeeMaster.getEmployeeType());
        request.setAttribute("shiftType", employeeMaster.getShiftType());
        request.setAttribute("certificatesList", certificatesList);

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
        List<?> employeeSubTypeList = employeeSubTypeService.readByEmployeeTypeId(typeId);
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

        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.getModelMap().put("applicationId", applicationId);
        mv.getModelMap().put("candidateId", candidateId);
        mv.setViewName("Employee/EmployeeInductionForm");
        request.setAttribute("successMessage",
                "Information : The Induction successfully.");
        return mv;
    }

    public ModelAndView inductionSubmit(HttpServletRequest request, HttpServletResponse response, EmployeeMaster employeeMaster) throws Exception {
        ModelAndView mv = new ModelAndView();
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
        String competencyEvaluationId = request.getParameter("competencyEvaluationId");
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
            request.setAttribute("competencyEvaluationId", competencyEvaluationId);
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv.addAllObjects(errors.getModel());
            selectEmployee(request, response);
            selectedEmployeeLevel1(request, employeeMaster);
//            request.setAttribute("employeeMaster", employeeMaster);
            mv.getModelMap().put("employeeMaster", employeeMaster);
            mv.setViewName("Employee/EmployeeRegistrationForm");
        } else if (DOJ.before(DOB1)) {
            request.setAttribute("failureMessage",
                    "Error : Enter Valid Date of Joining");

            selectEmployee(request, response);
            selectedEmployeeLevel1(request, employeeMaster);
            request.setAttribute("employeeMaster", employeeMaster);
            mv.setViewName("Employee/EmployeeRegistrationForm");
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
            employeeMaster.setCompetencyEvaluationId(Integer.parseInt(competencyEvaluationId));
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
            if (employeeMaster.getPfAmount().equals("")) {
                employeeMaster.setPfAmount("0");
            }
            CandidateJobApplication cja = candidateJobApplicationService.readById(Integer.parseInt(applicationId));
            ApplayJobUserMaster ajum = applayJobUserMasterService.readById(cja.getApplayJobUserMaster().getId());
            ajum.setFirstTime(5);
            cja.setStatus(13);
            candidateJobApplicationService.create(cja);
            employeeMasterService.create(employeeMaster);
            //Code for Employee Policy Detail
            EmployeePolicyDetail employeePolicyDetail = new EmployeePolicyDetail();
            int otherDetailCount = Integer.parseInt(request.getParameter("policyCount"));
            for (int i = 1; i <= otherDetailCount; i++) {
                PolicyMaster policyMaster = new PolicyMaster();
                if (null != request.getParameter("policyId" + i) && null != request.getParameter("amount" + i) && null != request.getParameter("policyNumber" + i)) {
                    if (!request.getParameter("policyId" + i).equals("") && !request.getParameter("amount" + i).equals("") && !request.getParameter("policyNumber" + i).equals("")) {
                        int policyId = Integer.parseInt(request.getParameter("policyId" + i));
                        policyMaster.setId(policyId);
                        Double amount = Double.valueOf(request.getParameter("amount" + i));
                        String policyNumber = request.getParameter("policyNumber" + i);
                        employeePolicyDetail.setEmployeeMaster(employeeMaster);
                        employeePolicyDetail.setAmount(amount);
                        employeePolicyDetail.setPolicyMaster(policyMaster);
                        employeePolicyDetail.setPolicyNum(policyNumber);
                        employeePolicyDetailService.create(employeePolicyDetail);
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
            mv.setViewName("forward:userRightMaster.htm?act=createClick&id=" + String.valueOf(userMasterId));
        } else {
            request.setAttribute("failureMessage",
                    "Error : User isExist.");
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
}
