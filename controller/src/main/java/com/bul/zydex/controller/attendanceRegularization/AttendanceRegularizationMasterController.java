package com.bul.zydex.controller.attendanceRegularization;

import com.bul.zydex.model.AttendanceRegularization;
import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.model.EmailAddMaster;
import com.bul.zydex.model.EmailTemplate;
import com.bul.zydex.model.EmployeeAdvanceSearch;
import com.bul.zydex.model.EmployeeDatetimeData;
import com.bul.zydex.model.EmployeeLeaveBalance;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.EmployeeShiftData;
import com.bul.zydex.model.LeaveEmployeeDetail;
import com.bul.zydex.model.LeaveTypeMaster;
import com.bul.zydex.model.LevelMaster;
import com.bul.zydex.model.OverTimeMaster;
import com.bul.zydex.model.PayrollProfessionalTax;
import com.bul.zydex.model.TimeAttandanceFlaxibleMaster;
import com.bul.zydex.model.UserMaster;
import com.bul.zydex.model.UserRightMaster;
import com.bul.zydex.model.ZydexLocationMaster;
import com.bul.zydex.util.ActionType;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static org.apache.commons.lang3.time.DateUtils.addDays;
import org.springframework.validation.BindException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

public class AttendanceRegularizationMasterController extends AttendanceRegularizationMasterAbstract {

    public ModelAndView createClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AttendanceRegularization attendanceRegularization = new AttendanceRegularization();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        UserMaster user = (UserMaster) request.getSession().getAttribute("user");
        UserRightMaster user1 = (UserRightMaster) request.getSession().getAttribute("userRight");
        int reportingId = 0;
        user.getId();
        employeeMaster.setUserMaster(user);
        List<?> empDetailList = employeeMasterService.readEmployeeDetailUserIdWise(employeeMaster);
        if (!empDetailList.isEmpty()) {
            request.setAttribute("employeeMaster", empDetailList.get(0));
            Object[] arrayOfObject = (Object[]) empDetailList.get(0);
            String reportmanager = (String) arrayOfObject[6];
            if (!reportmanager.equals("")) {
                reportingId = Integer.parseInt(reportmanager);
            }

            employeeMaster1.setId(reportingId);
        }
        List<?> reportmanager1 = employeeMasterService.readByReportManager(employeeMaster1);
        if (!reportmanager1.isEmpty()) {
            employeeMaster1 = (EmployeeMaster) reportmanager1.get(0);
            request.setAttribute("reportingManager", employeeMaster1.getEmployeeName());
        }

        mv.getModelMap().put("attendanceRegularization", attendanceRegularization);
        mv.setViewName("AttendanceRegularization/attendanceRegularizationFormForEmployee");
        return mv;
    }

    public ModelAndView createSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AttendanceRegularization attendanceRegularization = new AttendanceRegularization();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        int reportingId = 0;
        UserMaster user = (UserMaster) request.getSession().getAttribute("user");
        int userMasterId = user.getId();
        employeeMaster.setUserMaster(user);
        BindException errors = new BindException(attendanceRegularization, "attendanceRegularization");
        bind(request, attendanceRegularization);
        attendanceRegularizationValidator.validate(attendanceRegularization, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv.addAllObjects(errors.getModel());
            List<?> empDetailList = employeeMasterService.readEmployeeDetailUserIdWise(employeeMaster);
            if (!empDetailList.isEmpty()) {
                request.setAttribute("employeeMaster", empDetailList.get(0));
                Object[] arrayOfObject = (Object[]) empDetailList.get(0);
                String reportmanager = (String) arrayOfObject[6];
                if (!reportmanager.equals("")) {
                    reportingId = Integer.parseInt(reportmanager);
                }

                employeeMaster1.setId(reportingId);
            }
            List<?> reportmanager1 = employeeMasterService.readByReportManager(employeeMaster1);
            if (!reportmanager1.isEmpty()) {
                employeeMaster1 = (EmployeeMaster) reportmanager1.get(0);
                request.setAttribute("reportingManager", employeeMaster1.getEmployeeName());
            }
            request.setAttribute("employeeMaster", empDetailList.get(0));
            request.setAttribute("reportingManager", employeeMaster1.getEmployeeName());

            mv.getModelMap().put("attendanceRegularization", attendanceRegularization);
            mv.setViewName("AttendanceRegularization/attendanceRegularizationFormForEmployee");
        } else {

            if (attendanceRegularization.getArType().equals("Compassion")) {
                attendanceRegularization.setUserMasterId(userMasterId);
                attendanceRegularization.setStatus(18);
                SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                String currentDate = dateFormat1.format(new Date());
                attendanceRegularization.setDateOfSubmit(currentDate);
                attendanceRegularizationMasterService.createOrUpdate(attendanceRegularization);

                request.setAttribute("successMessage",
                        "Information : The Information is saved Successfully.");

                mv.setViewName("redirect:attendanceRegularizationMaster.htm?act=searchSubmit");
            }
            if (attendanceRegularization.getArType().equals("Official")) {
                attendanceRegularization.setUserMasterId(userMasterId);
                attendanceRegularization.setStatus(0);
                SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                String currentDate = dateFormat1.format(new Date());
                attendanceRegularization.setDateOfSubmit(currentDate);
                attendanceRegularizationMasterService.createOrUpdate(attendanceRegularization);

                request.setAttribute("successMessage",
                        "Information : The Information is saved Successfully.");

                mv.setViewName("redirect:attendanceRegularizationMaster.htm?act=searchSubmit");
            }

            try {
                mailSendArApply(request);
                EmailTemplate emailTemplate = new EmailTemplate();
                EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                DesignationMaster designationMaster = new DesignationMaster();
                designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                EmployeeMaster employeeMasterHr = new EmployeeMaster();
                employeeMasterHr = employeeMasterService.readById(Integer.parseInt(employeeMasterModel.getReportingManagerLevel1()));
                // id 14 is for Attendence regularization apply....
                emailTemplate = emailTemplateService.readById(14);
                String To = employeeMasterHr.getOfficeEmailId();
                String from = employeeMasterModel.getOfficeEmailId();
                String Subject = emailTemplate.getSubject();
                Subject = Subject.replaceAll("\\{user\\}", employeeMasterModel.getEmployeeName());
                String msg = emailTemplate.getBodytext();
                msg = msg.replaceAll("\\{to_user\\}", employeeMasterHr.getEmployeeName());
                msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                sendMail.sendMail(from, To, Subject, msg);
            } catch (Exception e) {
            }
        }
        return mv;
    }

    public ModelAndView searchSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AttendanceRegularization attendanceRegularization = new AttendanceRegularization();
        UserMaster user = (UserMaster) request.getSession().getAttribute("user");
        int id = user.getId();
        List<?> list = attendanceRegularizationMasterService.userWiseAttendanceRegularizationList(id);
        List<?> list1 = attendanceRegularizationMasterService.userReportingManager(id);
        EmployeeMaster employeeMaster = new EmployeeMaster();
        String managerName = "";
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        if (!list1.isEmpty()) {
            employeeMaster = (EmployeeMaster) list1.get(0);
//            List<?> reportingmanagerNameList = employeeMasterService.readByEmployeeLevel1Id(employeeMaster);

            employeeMaster1 = employeeMasterService.readById(Integer.parseInt(employeeMaster.getReportingManagerLevel1()));
//            if (!reportingmanagerNameList.isEmpty()) {
//                Object[] o = (Object[]) reportingmanagerNameList.get(0);
//                managerName = (String) o[2];
//            }
        }
        mv.getModelMap().put("managerName", employeeMaster1.getEmployeeName());
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("attendanceRegularization", attendanceRegularization);
        mv.setViewName("AttendanceRegularization/attendanceRegularizationResult");
        return mv;
    }

    public ModelAndView editClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AttendanceRegularization attendanceRegularization = new AttendanceRegularization();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        String id = request.getParameter("id");
        UserMaster user = (UserMaster) request.getSession().getAttribute("user");
        UserRightMaster user1 = (UserRightMaster) request.getSession().getAttribute("userRight");
        int reportingId = 0;
        user.getId();
        employeeMaster.setUserMaster(user);
        List<?> empDetailList = employeeMasterService.readEmployeeDetailUserIdWise(employeeMaster);
        if (!empDetailList.isEmpty()) {
            request.setAttribute("employeeMaster", empDetailList.get(0));
            Object[] arrayOfObject = (Object[]) empDetailList.get(0);
            String reportmanager = (String) arrayOfObject[6];
            if (!reportmanager.equals("")) {
                reportingId = Integer.parseInt(reportmanager);
            }

            employeeMaster1.setId(reportingId);
        }
        List<?> reportmanager1 = employeeMasterService.readByReportManager(employeeMaster1);
        if (!reportmanager1.isEmpty()) {
            employeeMaster1 = (EmployeeMaster) reportmanager1.get(0);
            request.setAttribute("reportingManager", employeeMaster1.getEmployeeName());
        }

        attendanceRegularization = attendanceRegularizationMasterService.readById(Integer.parseInt(id));
        int status1 = attendanceRegularization.getStatus();
        String status = Integer.toString(status1);
        String remark = attendanceRegularization.getManagerRemark();
        request.setAttribute("remark", remark);
        request.setAttribute("status", status);
        mv.getModelMap().put("attendanceRegularization", attendanceRegularization);
        mv.setViewName("AttendanceRegularization/attendanceRegularizationFormForEmployeeEdit");
        return mv;
    }

    public ModelAndView editSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AttendanceRegularization attendanceRegularization = new AttendanceRegularization();
        AttendanceRegularization attendanceRegularization1 = new AttendanceRegularization();
        bind(request, attendanceRegularization);
        UserMaster user = (UserMaster) request.getSession().getAttribute("user");
        String id = request.getParameter("id");
        String btnSubmit = request.getParameter("btnSubmit");
        attendanceRegularization1 = attendanceRegularizationMasterService.readById(Integer.parseInt(id));
        if (btnSubmit.equals("Submit")) {

            if (attendanceRegularization1.getStatus() == 7) {
                attendanceRegularization.setStatus(0);
                attendanceRegularization.setManagerRemark(attendanceRegularization1.getManagerRemark());
                attendanceRegularization.setUserMasterId(attendanceRegularization1.getUserMasterId());
            }
//        else {
//            attendanceRegularization.setStatus(2);
//            attendanceRegularization.setManagerRemark(attendanceRegularization1.getManagerRemark());
//            attendanceRegularization.setUserMasterId(attendanceRegularization1.getUserMasterId());
//        }
            request.setAttribute("successMessage",
                    "Information : The Information is saved Successfully.");
            try {

                EmailTemplate emailTemplate = new EmailTemplate();
                EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                DesignationMaster designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                EmployeeMaster employeeMaster1 = new EmployeeMaster();
                EmployeeMaster EmployeeHR = new EmployeeMaster();
                EmployeeHR = employeeMasterService.readById(Integer.parseInt(employeeMasterModel.getReportingManagerLevel1()));
                //id=14 is for attandence regularization Apply...
                emailTemplate = emailTemplateService.readById(14);
                String EmpStr = request.getParameter("empid");
                if (null != EmpStr && !"".equals(EmpStr)) {
                    int Empid = Integer.parseInt(EmpStr);
                    List list = employeeMasterService.readByEmployeeNo(Empid);
                    if (!list.isEmpty()) {
                        employeeMaster1 = (EmployeeMaster) list.get(0);
                        String To = EmployeeHR.getOfficeEmailId();
                        String from = employeeMasterModel.getOfficeEmailId();
                        String Subject = emailTemplate.getSubject();
                        Subject = Subject.replaceAll("\\{user\\}", employeeMasterModel.getEmployeeName());
                        String msg = emailTemplate.getBodytext();
                        msg = msg.replaceAll("\\{to_user\\}", EmployeeHR.getEmployeeName());
                        msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                        msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                        sendMail.sendMail(from, To, Subject, msg);

                        String name = "Attendance";
                        EmailAddMaster emailAddMaster = new EmailAddMaster();
                        emailAddMaster.setModuleName(name);
                        emailAddMaster.setDepartmentMaster(employeeMasterModel.getDepartmentMaster());
                        List<?> emailSendList = emailAddMasterService.readByName(emailAddMaster);
                        if (!emailSendList.isEmpty()) {
                            EmailAddMaster emailAddMaster1 = (EmailAddMaster) emailSendList.get(0);
                            String emailId = emailAddMaster1.getEmailId();
                            for (String emailId1 : emailId.split(",")) {
                                if (!emailId1.equals("")) {
                                    String To1 = emailId1;
                                    String from1 = employeeMasterModel.getOfficeEmailId();
                                    String subject1 = emailTemplate.getSubject();
                                    subject1 = subject1.replaceAll("\\{user\\}", employeeMasterModel.getEmployeeName());
                                    String msg1 = emailTemplate.getBodytext();
                                    msg1 = msg1.replaceAll("\\{to_user\\}", EmployeeHR.getEmployeeName());
                                    msg1 = msg1.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                                    msg1 = msg1.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                                    sendMail.sendMail(from1, To1, subject1, msg1);

                                }

                            }
                        }
                        List<?> allDeptmailList = emailAddMasterService.readAllDept(name);
                        if (!allDeptmailList.isEmpty()) {
                            EmailAddMaster emailAddMaster1 = (EmailAddMaster) allDeptmailList.get(0);
                            String emailId = emailAddMaster1.getEmailId();
                            for (String emailId1 : emailId.split(",")) {
                                if (!emailId1.equals("")) {
                                    String To1 = emailId1;
                                    String from1 = employeeMasterModel.getOfficeEmailId();
                                    String subject1 = emailTemplate.getSubject();
                                    subject1 = subject1.replaceAll("\\{user\\}", employeeMaster1.getEmployeeName());
                                    String msg1 = emailTemplate.getBodytext();
                                    msg1 = msg1.replaceAll("\\{to_user\\}", employeeMaster1.getEmployeeName());
                                    msg1 = msg1.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                                    msg1 = msg1.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                                    sendMail.sendMail(from1, To1, subject1, msg1);
                                }
                            }
                        }

                    }

                }

            } catch (Exception e) {
            }

        } else if (btnSubmit.equals("Withdraw")) {
            attendanceRegularization.setStatus(2);
            try {

                EmailTemplate emailTemplate = new EmailTemplate();
                EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                DesignationMaster designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                EmployeeMaster employeeMaster1 = new EmployeeMaster();
                EmployeeMaster EmployeeHR = new EmployeeMaster();
                EmployeeHR = employeeMasterService.readById(Integer.parseInt(employeeMasterModel.getReportingManagerLevel1()));
                //id=18 is for attandence regularization withdrow...
                emailTemplate = emailTemplateService.readById(18);
                String EmpStr = request.getParameter("empid");
                if (null != EmpStr && !"".equals(EmpStr)) {
                    int Empid = Integer.parseInt(EmpStr);
                    List list = employeeMasterService.readByEmployeeNo(Empid);
                    if (!list.isEmpty()) {
                        employeeMaster1 = (EmployeeMaster) list.get(0);
                        String To = EmployeeHR.getOfficeEmailId();
                        String from = employeeMasterModel.getOfficeEmailId();
                        String Subject = emailTemplate.getSubject();
                        Subject = Subject.replaceAll("\\{user\\}", employeeMasterModel.getEmployeeName());
                        String msg = emailTemplate.getBodytext();
                        msg = msg.replaceAll("\\{to_user\\}", EmployeeHR.getEmployeeName());
                        msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                        msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                        sendMail.sendMail(from, To, Subject, msg);

                    }

                }

            } catch (Exception e) {
            }

        }
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String currentDate = dateFormat1.format(new Date());
        attendanceRegularization.setDateOfSubmit(currentDate);
        attendanceRegularizationMasterService.createOrUpdate(attendanceRegularization);
//        mv = searchSubmit(request, response);
        mv.setViewName("redirect:attendanceRegularizationMaster.htm?act=searchSubmit");
        return mv;
    }

    public ModelAndView approvalSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AttendanceRegularization attendanceRegularization = new AttendanceRegularization();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        int id = employeeMaster.getId();
        List<?> list = attendanceRegularizationMasterService.approvalLeval1WiseAttendanceRegularizationList(id);
        List<?> list1 = attendanceRegularizationMasterService.userReportingManager(id);
        String managerName = "";
        if (!list1.isEmpty()) {
            employeeMaster = (EmployeeMaster) list1.get(0);
            if (!employeeMaster.getReportingManagerLevel1().equals("")) {
                List<?> reportingmanagerNameList = employeeMasterService.readByEmployeeLevel1Id(employeeMaster);
                if (!reportingmanagerNameList.isEmpty()) {
                    Object[] o = (Object[]) reportingmanagerNameList.get(0);
                    managerName = (String) o[2];
                }
            }
        }
        mv.getModelMap().put("managerName", managerName);
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("attendanceRegularization", attendanceRegularization);
        mv.setViewName("AttendanceRegularization/attendanceRegularizationApprovalResult");
        return mv;
    }

    public ModelAndView approvalEditClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AttendanceRegularization attendanceRegularization = new AttendanceRegularization();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        String id = request.getParameter("id");
        attendanceRegularization = attendanceRegularizationMasterService.readById(Integer.parseInt(id));
        int status1 = attendanceRegularization.getStatus();
        String status = Integer.toString(status1);
        request.setAttribute("status", status);
        String remarkNmame = attendanceRegularization.getManagerRemark();
        request.setAttribute("remarkNmame", remarkNmame);
        int userId = attendanceRegularization.getUserMasterId();
        UserMaster user = new UserMaster();
        user.setId(userId);
        employeeMaster.setUserMaster(user);
        List<?> empDetailList = employeeMasterService.readEmployeeDetailUserIdWise(employeeMaster);
        if (!empDetailList.isEmpty()) {
            request.setAttribute("employeeMaster", empDetailList.get(0));
            Object[] arrayOfObject = (Object[]) empDetailList.get(0);
            String reportmanager = (String) arrayOfObject[6];
        }

        mv.getModelMap().put("attendanceRegularization", attendanceRegularization);
        mv.setViewName("AttendanceRegularization/attendanceRegularizationApproval");
        return mv;
    }

    public ModelAndView approvalEditSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AttendanceRegularization attendanceRegularization = new AttendanceRegularization();
        String id = "" + request.getParameter("id");
        String remark = "" + request.getParameter("remark");
        attendanceRegularization = attendanceRegularizationMasterService.readById(Integer.parseInt(id));
        attendanceRegularization.setStatus(1);
        attendanceRegularization.setManagerRemark(remark);

//        EmployeeMaster approverName = new EmployeeMaster();
        EmployeeMaster approverName = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String requestdate = sdf.format(new Date());
        attendanceRegularization.setApprovedDate(requestdate);
        attendanceRegularization.setEmployeeMaster(approverName);

        attendanceRegularizationMasterService.createOrUpdate(attendanceRegularization);
//        Employee Date Time Data
        if (attendanceRegularization.getStatus() == 1) {
            int userId = attendanceRegularization.getUserMasterId();
            UserMaster userMaster = new UserMaster();
            userMaster.setId(userId);
            EmployeeMaster employeeMaster = new EmployeeMaster();
            employeeMaster.setUserMaster(userMaster);
            List<?> l = employeeMasterService.readByEmployeeUserId(employeeMaster);
            employeeMaster = (EmployeeMaster) l.get(0);
            String startDate = attendanceRegularization.getStartDateTime();
            String endDate = attendanceRegularization.getEndDateTime();
            EmployeeDatetimeData employeeDatetimeData = new EmployeeDatetimeData();
            EmployeeDatetimeData employeeDatetimeData1 = new EmployeeDatetimeData();
            employeeDatetimeData.setEmployeeMaster(employeeMaster);
            employeeDatetimeData.setDateTime(startDate);
            employeeDatetimeData1.setEmployeeMaster(employeeMaster);
            employeeDatetimeData1.setDateTime(endDate);
//            employeeDatetimeDataService.createOrUpdate(employeeDatetimeData);
//            employeeDatetimeDataService.createOrUpdate(employeeDatetimeData1);

            EmployeeShiftData employeeShiftData = new EmployeeShiftData();
            EmployeeShiftData employeeShiftData1 = new EmployeeShiftData();
            employeeShiftData.setInDateTime(startDate);
            employeeShiftData.setEmployeeMaster(employeeMaster);
            List<?> shift = employeeShiftDataService.attendanceRegularizationEntry(employeeShiftData);
            if (!shift.isEmpty()) {
                employeeShiftData1 = (EmployeeShiftData) shift.get(0);
                employeeShiftData1.setInDateTime(startDate);
                employeeShiftData1.setOutDateTime(endDate);
                employeeShiftData1.setEmployeeMaster(employeeMaster);
                employeeShiftData1.setShiftMaster(employeeShiftData1.getShiftMaster());
//                employeeShiftDataService.update(employeeShiftData1);
            }
//            try {
//                EmailTemplate emailTemplate = new EmailTemplate();
//                EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
//                DesignationMaster designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
//                EmployeeMaster EmployeeHR = employeeMasterService.readById(Integer.parseInt(employeeMasterModel.getReportingManagerLevel1()));
//                //id=15 is for attendence regularization approve......
//                emailTemplate = emailTemplateService.readById(15);
//                String EmpStr = request.getParameter("empid");
//                EmployeeMaster employeeMaster1 = new EmployeeMaster();
//                if (null != EmpStr && !"".equals(EmpStr)) {
//                    int Empid = Integer.parseInt(EmpStr);
//                    List list = employeeMasterService.readByEmployeeNo(Empid);
//                    if (!list.isEmpty()) {
//
//                        employeeMaster1 = (EmployeeMaster) list.get(0);
//
//                    }
//                }
//                String To = EmployeeHR.getOfficeEmailId();
//                String from = employeeMasterModel.getOfficeEmailId();
//                String Subject = emailTemplate.getSubject();
//                Subject = Subject.replaceAll("\\{user\\}", employeeMaster1.getEmployeeName());
//                String msg = emailTemplate.getBodytext();
//                msg = msg.replaceAll("\\{to_user\\}", EmployeeHR.getEmployeeName());
//                msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
//                msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
//                sendMail.sendMail(from, To, Subject, msg);
//
//            } catch (Exception e) {
//            }
            try {
                EmailTemplate emailTemplate = new EmailTemplate();
                EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                DesignationMaster designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                EmployeeMaster employeeMaster1 = new EmployeeMaster();
                //id=69 is for attandence regularization approve to employee...
                emailTemplate = emailTemplateService.readById(69);
                String EmpStr = request.getParameter("empid");
                if (null != EmpStr && !"".equals(EmpStr)) {
                    int Empid = Integer.parseInt(EmpStr);
                    List list = employeeMasterService.readByEmployeeNo(Empid);
                    if (!list.isEmpty()) {
                        employeeMaster1 = (EmployeeMaster) list.get(0);
                        String To = employeeMaster1.getOfficeEmailId();
                        String from = employeeMasterModel.getOfficeEmailId();
                        String Subject = emailTemplate.getSubject();
                        Subject = Subject.replaceAll("\\{user\\}", employeeMaster1.getEmployeeName());
                        String msg = emailTemplate.getBodytext();
                        msg = msg.replaceAll("\\{to_user\\}", employeeMaster1.getEmployeeName());
                        msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                        msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                        sendMail.sendMail(from, To, Subject, msg);

                    }

                }

            } catch (Exception e) {
            }

        }
//        Employee Date Time Data

        mv = approvalSubmit(request, response);
        return mv;
    }

    public ModelAndView rejectSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AttendanceRegularization attendanceRegularization = new AttendanceRegularization();
        String id = request.getParameter("id");
        String remark = "" + request.getParameter("remark");
        attendanceRegularization = attendanceRegularizationMasterService.readById(Integer.parseInt(id));
        attendanceRegularization.setStatus(3);
        attendanceRegularization.setManagerRemark(remark);
        EmployeeMaster approverName = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String requestdate = sdf.format(new Date());
        attendanceRegularization.setApprovedDate(requestdate);
        attendanceRegularization.setEmployeeMaster(approverName);
        attendanceRegularizationMasterService.createOrUpdate(attendanceRegularization);

        try {

            EmailTemplate emailTemplate = new EmailTemplate();
            EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
            DesignationMaster designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
            UserMaster userMaster = new UserMaster();
            userMaster.setId(attendanceRegularization.getUserMasterId());
            EmployeeMaster employeeMaster1 = new EmployeeMaster();
            employeeMaster1.setUserMaster(userMaster);
            List list = employeeMasterService.readByUserName(employeeMaster1);
            //id=17 is for attandence regularization reject...
            emailTemplate = emailTemplateService.readById(17);
//            String EmpStr = request.getParameter("empid");
//            if (null != EmpStr && !"".equals(EmpStr)) {
//                int Empid = Integer.parseInt(EmpStr);
//                List list = employeeMasterService.readByEmployeeNo(Empid);
            if (!list.isEmpty()) {
                employeeMaster1 = (EmployeeMaster) list.get(0);
                String To = employeeMaster1.getOfficeEmailId();
                String from = employeeMasterModel.getOfficeEmailId();
                String Subject = emailTemplate.getSubject();
                Subject = Subject.replaceAll("\\{user\\}", employeeMaster1.getEmployeeName());
                String msg = emailTemplate.getBodytext();
                msg = msg.replaceAll("\\{to_user\\}", employeeMaster1.getEmployeeName());
                msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                sendMail.sendMail(from, To, Subject, msg);

//                }
            }

        } catch (Exception e) {
        }

        mv = approvalSubmit(request, response);
        return mv;
    }

    public ModelAndView reworkSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AttendanceRegularization attendanceRegularization = new AttendanceRegularization();
        String id = request.getParameter("id");
        String remark = "" + request.getParameter("remark");
        attendanceRegularization = attendanceRegularizationMasterService.readById(Integer.parseInt(id));
        attendanceRegularization.setStatus(7);
        attendanceRegularization.setManagerRemark(remark);
        EmployeeMaster approverName = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String requestdate = sdf.format(new Date());
        attendanceRegularization.setApprovedDate(requestdate);
        attendanceRegularization.setEmployeeMaster(approverName);
        attendanceRegularizationMasterService.createOrUpdate(attendanceRegularization);
        try {

            EmailTemplate emailTemplate = new EmailTemplate();
            EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
            DesignationMaster designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
            EmployeeMaster employeeMaster1 = new EmployeeMaster();
            //id=16 is for attandence regularization rework...
            emailTemplate = emailTemplateService.readById(16);
            UserMaster userMaster = new UserMaster();
            userMaster.setId(attendanceRegularization.getUserMasterId());
            employeeMaster1.setUserMaster(userMaster);
            List<?> list = employeeMasterService.readByUserName(employeeMaster1);
//            String EmpStr = request.getParameter("empid");
//            if (null != EmpStr && !"".equals(EmpStr)) {
//                int Empid = Integer.parseInt(EmpStr);
//                List list = employeeMasterService.readByEmployeeNo(Empid);
            if (!list.isEmpty()) {
                employeeMaster1 = (EmployeeMaster) list.get(0);
                String To = employeeMaster1.getOfficeEmailId();
                String from = employeeMasterModel.getOfficeEmailId();
                String Subject = emailTemplate.getSubject();
                Subject = Subject.replaceAll("\\{user\\}", employeeMaster1.getEmployeeName());
                String msg = emailTemplate.getBodytext();
                msg = msg.replaceAll("\\{to_user\\}", employeeMaster1.getEmployeeName());
                msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                sendMail.sendMail(from, To, Subject, msg);

            }

        } catch (Exception e) {
        }

        mv = approvalSubmit(request, response);
        return mv;
    }

    public ModelAndView approvedList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AttendanceRegularization attendanceRegularization = new AttendanceRegularization();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        int id = employeeMaster.getId();
        List<?> list = attendanceRegularizationMasterService.attendanceRegularizationApprivedList(id);
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("attendanceRegularization", attendanceRegularization);
        mv.setViewName("AttendanceRegularization/attendanceRegularizationApproedList");
        return mv;
    }

    public ModelAndView employyeAttendanceApproeList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AttendanceRegularization attendanceRegularization = new AttendanceRegularization();
        UserMaster user = (UserMaster) request.getSession().getAttribute("user");
        int id = user.getId();
        List<?> list = attendanceRegularizationMasterService.userWiseAttendanceRegularizationApproveList(id);
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("attendanceRegularization", attendanceRegularization);
        mv.setViewName("AttendanceRegularization/attendanceRegularizationResult");
        return mv;
    }

    public ModelAndView userDashboardAttendanceRegularizationPendingRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AttendanceRegularization attendanceRegularization = new AttendanceRegularization();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        int empId = employeeMaster.getId();
        attendanceRegularization.setId(empId);
        UserMaster user = (UserMaster) request.getSession().getAttribute("user");
        int id = user.getId();
        //-------------comment and update by  uday-------from------//
//        List<?> list = attendanceRegularizationMasterService.readByAttendanceRegularizationPendingList(id);
//        int attendaceRegularizationPending = list.size();
        int attendaceRegularizationPending = attendanceRegularizationMasterService.countByAttendanceRegularizationPendingList(id);
        //---------------------to-----------------------//
        request.setAttribute("attendaceRegularizationPending", attendaceRegularizationPending);
        List<?> list1 = attendanceRegularizationMasterService.readByAttendanceRegularizationApproverPendingList(attendanceRegularization);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date currentDate = new Date();
        for (Iterator<? extends Object> iterator = list1.iterator(); iterator.hasNext();) {
            Object[] next = (Object[]) iterator.next();
            String strdate = "" + next[2];
            sdf.parse(strdate);
            Calendar cal = Calendar.getInstance();
            cal.setTime(sdf.parse(strdate));
            Date dd = cal.getTime();
            Date addedDate = addDays(dd, 15);
            if (currentDate.equals(addedDate) || currentDate.before(addedDate)) {
                int attendaceRegularizationApproverPending = list1.size();
                request.setAttribute("attendaceRegularizationApproverPending", attendaceRegularizationApproverPending);
            } else {
                List<?> list2 = attendanceRegularizationMasterService.readByAttendanceRegularizationApprover2PendingList(attendanceRegularization);
                int attendaceRegularizationApprover1Pending = list2.size();
//                request.setAttribute("attendaceRegularizationApprover1Pending", attendaceRegularizationApprover1Pending);
            }
        }
        mv.setViewName("forward:visitorManagement.htm?act=userDashboardVisitorManagementPendingRequest");
        return mv;
    }

    public ModelAndView searchAttendanceRegularizationPendingSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AttendanceRegularization attendanceRegularization = new AttendanceRegularization();
        UserMaster user = (UserMaster) request.getSession().getAttribute("user");
        int id = user.getId();
        List<?> list = attendanceRegularizationMasterService.userWiseAttendanceRegularizationList(id);
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("attendanceRegularization", attendanceRegularization);
        mv.setViewName("AttendanceRegularization/attendanceRegularizationResult");
        return mv;
    }

    public ModelAndView showOwnAttandance(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeAdvanceSearch employeeAdvanceSearch = new EmployeeAdvanceSearch();
        EmployeeShiftData employeeShiftData = new EmployeeShiftData();
        String startDate = request.getParameter("inDateTime");
        String endDate = request.getParameter("outDateTime");
        bind(request, employeeAdvanceSearch);
        String searchval = request.getParameter("vallist");
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        int id = employeeMaster.getId();
        employeeAdvanceSearch.setId("" + employeeMaster.getId());
        employeeAdvanceSearch.setZydexLocationId(null);
        employeeAdvanceSearch.setLevelID(null);
        employeeAdvanceSearch.setDepartmentId(null);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Map<String, String> woMap = new HashMap<String, String>();
        Map<String, String> satMap = new HashMap<String, String>();
        Map<String, String> halfDayMap = new HashMap<String, String>();
        if (null != employeeMaster.getId() && !employeeMaster.getId().equals("")) {
            employeeShiftData.setId(employeeMaster.getId());
        }
        employeeAdvanceSearch.setEmployeeId(Boolean.FALSE);
        employeeAdvanceSearch.setEmployeeName(Boolean.FALSE);
        employeeAdvanceSearch.setFatherName(Boolean.FALSE);
        employeeAdvanceSearch.setMotherName(Boolean.FALSE);
        employeeAdvanceSearch.setGender(Boolean.FALSE);
        employeeAdvanceSearch.setMaritalStatus(Boolean.FALSE);
        employeeAdvanceSearch.setSpouseName(Boolean.FALSE);
        employeeAdvanceSearch.setDateOfBirth(Boolean.FALSE);
        employeeAdvanceSearch.setPresentAddress(Boolean.FALSE);
        employeeAdvanceSearch.setPermanentAddress(Boolean.FALSE);
        employeeAdvanceSearch.setBloodGroups(Boolean.FALSE);
        employeeAdvanceSearch.setEmailAddress(Boolean.FALSE);
        employeeAdvanceSearch.setContactNo1(Boolean.FALSE);
        employeeAdvanceSearch.setContactNo2(Boolean.FALSE);
        employeeAdvanceSearch.setEmergencyContactPerson(Boolean.FALSE);
        employeeAdvanceSearch.setEmergencyContactNo(Boolean.FALSE);
        employeeAdvanceSearch.setPanCard(Boolean.FALSE);
        employeeAdvanceSearch.setPassportNo(Boolean.FALSE);
        employeeAdvanceSearch.setPassportIssueDate(Boolean.FALSE);
        employeeAdvanceSearch.setPassportExpiryDate(Boolean.FALSE);
        employeeAdvanceSearch.setAdharCard(Boolean.FALSE);
        employeeAdvanceSearch.setOfficeEmailId(Boolean.FALSE);
        employeeAdvanceSearch.setHighestEducationDetails(Boolean.FALSE);
        employeeAdvanceSearch.setExperienceYearOnDoj(Boolean.FALSE);
        employeeAdvanceSearch.setExperienceMonthOnDoj(Boolean.FALSE);
        employeeAdvanceSearch.setCompany(Boolean.FALSE);
        employeeAdvanceSearch.setZydexLocation(Boolean.FALSE);
        employeeAdvanceSearch.setWorkLocation(Boolean.FALSE);
        employeeAdvanceSearch.setLevel(Boolean.FALSE);
        employeeAdvanceSearch.setDepartment(Boolean.FALSE);
        employeeAdvanceSearch.setDesignation(Boolean.FALSE);
        employeeAdvanceSearch.setRole(Boolean.FALSE);
        employeeAdvanceSearch.setDateOfJoining(Boolean.FALSE);
        employeeAdvanceSearch.setEmployeeType(Boolean.FALSE);
        employeeAdvanceSearch.setBankName(Boolean.FALSE);
        employeeAdvanceSearch.setBankAccountNo(Boolean.FALSE);
        employeeAdvanceSearch.setBankIfscCode(Boolean.FALSE);
        employeeAdvanceSearch.setReportingManager(Boolean.FALSE);
        employeeAdvanceSearch.setCityOfEmployee(Boolean.FALSE);
        employeeAdvanceSearch.setChild1(Boolean.FALSE);
        employeeAdvanceSearch.setChild2(Boolean.FALSE);
        employeeAdvanceSearch.setDateOfBirthOfEmpFather(Boolean.FALSE);
        employeeAdvanceSearch.setDateOfBirthOfEmpMother(Boolean.FALSE);
        employeeAdvanceSearch.setDateOfBirthOfEmpSpous(Boolean.FALSE);
        employeeAdvanceSearch.setDateOfBirthOfEmpChilld1(Boolean.FALSE);
        employeeAdvanceSearch.setDateOfBirthOfEmpChild2(Boolean.FALSE);
        employeeAdvanceSearch.setDateOfTransferOfEntity(Boolean.FALSE);

        if ((!"".equals(startDate) && null != startDate) && (!"".equals(endDate) && null != endDate)) {
            if (!"".equals(startDate) && null != startDate) {
                Date sDate = sdf.parse(startDate);
//            "2012-01-01"
                employeeShiftData.setInDateTime(new SimpleDateFormat("yyyy-MM-dd").format(sDate));

            }
            if (!"".equals(endDate) && null != endDate) {
                Date eDate = sdf.parse(endDate);
                employeeShiftData.setOutDateTime(new SimpleDateFormat("yyyy-MM-dd").format(eDate));
            }
        } else {
            Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int day = c.get(Calendar.DAY_OF_MONTH);
            int month = c.get(Calendar.MONTH) + 1;

            startDate = year + "-" + (month < 10 ? ("0" + month) : (month)) + "-01";
            Date sDate = sdf1.parse(startDate);
            endDate = year + "-" + (month < 10 ? ("0" + month) : (month)) + "-" + day;
            Date eDate = sdf1.parse(endDate);
            employeeShiftData.setInDateTime(sdf1.format(sDate));
            employeeShiftData.setOutDateTime(sdf1.format(eDate));
        }

        List<?> empDetail = employeeMasterService.empOrDateWiseSearch(employeeAdvanceSearch);
        Map<Integer, List<?>> map = new LinkedHashMap<Integer, List<?>>();
        for (Object o1 : empDetail) {
            Object[] o = (Object[]) o1;
            int id1 = (Integer) o[48];
            employeeShiftData.setId(id1);
            List list = employeeShiftDataService.empOrDateWiseSearch(employeeShiftData);
            int i = 0;
            for (Iterator<? extends Object> iterator = list.iterator(); iterator.hasNext();) {
                Object[] next = (Object[]) iterator.next();

                String firstHalf = "" + next[1];
                if (!firstHalf.contains("fullday") && !firstHalf.equals("WO") && !firstHalf.equals("TR") && !firstHalf.equals("AR") && !firstHalf.equals("AB") && !firstHalf.contains("?")
                        && !firstHalf.equals("Casual Leave") && !firstHalf.equals("Short Leave") && !firstHalf.equals("C Off Leave") && !firstHalf.equals("Privilege Leave") && !firstHalf.equals("Sick Leave")
                        && !firstHalf.equals("Paternity Leave") && !firstHalf.equals("Maternity Leave") && !firstHalf.equals("Leave Without Pay")) {
                    Date date1 = sdf.parse("" + next[0]);
                    Calendar c2 = Calendar.getInstance();
                    c2.setTime(date1);
                    SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");
                    String[] userTimeInStr = firstHalf.split("`");
                    String[] userTimeInStr1 = userTimeInStr[1].split("!");
                    String[] userTimeOutStr = firstHalf.split("!");
                    String[] userTimeOutStr1 = userTimeOutStr[1].split("@");
                    Date userTimeIn = sdf2.parse(userTimeInStr1[0]);
                    Date userTimeOut = sdf2.parse(userTimeOutStr1[0]);
                    if (userTimeOut.before(userTimeIn)) {
                        next[1] = ("" + next[1]).replace("AB", "fullday");
//                        tempList.add(""+next[0]);
//                        tempList.add(("" + next[1]).replace("AB", "PR"));
                        list.set(i, next);
                    }
                }
                i++;
            }

            map.put(id, list);
            request.setAttribute("attendanceDateList", list);
        }

        boolean flexible = false;
        int earlyMinute = 0;
        int lateMinute = 0;
        List<?> timeAttFlexibleList = timeAttandanceFlaxibleMasterService.read();
        if (!timeAttFlexibleList.isEmpty()) {
            for (Object flexiObject : timeAttFlexibleList) {
                TimeAttandanceFlaxibleMaster timeAttandanceFlaxibleMaster = (TimeAttandanceFlaxibleMaster) flexiObject;
                int zydexLocId = timeAttandanceFlaxibleMaster.getZydexLocationMaster().getId();
                EmployeeMaster employeeMaster1 = employeeMasterService.readById(id);
                int zydexLocId2 = employeeMaster1.getZydexLocationMaster().getId();
                if (zydexLocId == zydexLocId2) {
                    flexible = true;
                    earlyMinute = Integer.parseInt(timeAttandanceFlaxibleMaster.getEarlyFlexibleTime());
                    lateMinute = Integer.parseInt(timeAttandanceFlaxibleMaster.getLateFlexibleTime());
                    break;
                }
            }
        }
        SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");
        List newList = new ArrayList();
        List secondHalfList = new ArrayList();
        List workingHour = new ArrayList();
        for (Map.Entry<Integer, List<?>> entry : map.entrySet()) {
            Iterator itr5 = entry.getValue().iterator();
            while (itr5.hasNext()) {
                try {
                    Object[] next = (Object[]) itr5.next();
                    String firstHalf = "" + next[1];

                    Date date = sdf.parse("" + next[0]);
                    Calendar c = Calendar.getInstance();
//                    c.setTime(date);
                    // week off code start
                    Calendar c1 = Calendar.getInstance();
                    c1.setTime(date);
                    if (firstHalf.contains("WO")) {
                        LeaveEmployeeDetail leaveEmployeeDetail = new LeaveEmployeeDetail();
                        c1.add(Calendar.DATE, -1);
                        SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy");
                        SimpleDateFormat format = new SimpleDateFormat("EEEE");
                        String dayName = format.format(c1.getTime());
                        int dayOfWeek = c1.get(Calendar.WEEK_OF_MONTH);
                        if (dayName.equals("Saturday") && dayOfWeek != 2) {

                            leaveEmployeeDetail.setStartDate("" + sdf3.format(c1.getTime()));
                            leaveEmployeeDetail.setEndDate("" + sdf3.format(c1.getTime()));
                            leaveEmployeeDetail.setEmployeeMaster(employeeMaster);
                            leaveEmployeeDetail.setStatus(3);
                            List firstLeaveEmployeeDetail = leaveEmployeeDetailService.readLeaveDetails(leaveEmployeeDetail);
                            if (!firstLeaveEmployeeDetail.isEmpty()) {
                                c1.add(Calendar.DATE, 2);
                                leaveEmployeeDetail.setStartDate("" + sdf3.format(c1.getTime()));
                                leaveEmployeeDetail.setEndDate("" + sdf3.format(c1.getTime()));
                                leaveEmployeeDetail.setEmployeeMaster(employeeMaster);
                                leaveEmployeeDetail.setStatus(3);
                                List secondLeaveEmployeeDetail = leaveEmployeeDetailService.readLeaveDetails(leaveEmployeeDetail);

                                // saturday sandwich Leave code start
                                Object[] oSatArray = (Object[]) firstLeaveEmployeeDetail.get(0);
                                String woSatType = "" + oSatArray[0];
                                Date sSatDate = sdf.parse("" + oSatArray[1]);
                                Date eSatDate = sdf.parse("" + oSatArray[2]);
                                String sSatDateStr = "" + oSatArray[6];
                                String eSatDateStr = "" + oSatArray[7];
                                float noOfSatDays = (float) oSatArray[3];
                                float diffInSatDays = 0;
                                if ((sSatDateStr.equals("Fullday") && eSatDateStr.equals("Fullday"))
                                        || (sSatDateStr.equals("Fullday") && sSatDate.equals(eSatDate))) {
                                    diffInSatDays = (float) ((eSatDate.getTime() - sSatDate.getTime())
                                            / (1000 * 60 * 60 * 24)) + 1;
                                } else if ((sSatDateStr.equals("SecondHalf") && eSatDateStr.equals("Fullday"))
                                        || (sSatDateStr.equals("Fullday") && eSatDateStr.equals("FirstHalf"))) {
                                    diffInSatDays = (float) ((eSatDate.getTime() - sSatDate.getTime())
                                            / (1000 * 60 * 60 * 24)) + 1;
                                    diffInSatDays = diffInSatDays - (float) 0.5;
                                } else if (sSatDateStr.equals("SecondHalf") && eSatDateStr.equals("FirstHalf")) {
                                    diffInSatDays = (float) ((eSatDate.getTime() - sSatDate.getTime())
                                            / (1000 * 60 * 60 * 24)) + 1;
                                    diffInSatDays = diffInSatDays - 1;
                                }
                                // saturday sandwich Leave code End

                                // Monday sandwich Leave code start
                                float noOfMonDays = 0;
                                float diffInMonDays = -1;
                                String woMonType = "";
                                if (!secondLeaveEmployeeDetail.isEmpty()) {
                                    Object[] oMonArray = (Object[]) secondLeaveEmployeeDetail.get(0);
                                    woMonType = "" + oMonArray[0];
                                    Date sMonDate = sdf.parse("" + oMonArray[1]);
                                    Date eMonDate = sdf.parse("" + oMonArray[2]);
                                    String sMonDateStr = "" + oMonArray[6];
                                    String eMonDateStr = "" + oMonArray[7];
                                    noOfMonDays = (float) oMonArray[3];
                                    if ((sMonDateStr.equals("Fullday") && eMonDateStr.equals("Fullday"))
                                            || (sMonDateStr.equals("Fullday") && sMonDate.equals(eMonDate))) {
                                        diffInMonDays = (float) ((eMonDate.getTime() - sMonDate.getTime())
                                                / (1000 * 60 * 60 * 24)) + 1;
                                    } else if ((sMonDateStr.equals("SecondHalf") && eMonDateStr.equals("Fullday"))
                                            || (sMonDateStr.equals("Fullday") && eMonDateStr.equals("FirstHalf"))) {
                                        diffInMonDays = (float) ((eMonDate.getTime() - sMonDate.getTime())
                                                / (1000 * 60 * 60 * 24)) + 1;
                                        diffInMonDays = diffInMonDays - (float) 0.5;
                                    } else if (sMonDateStr.equals("SecondHalf") && eMonDateStr.equals("FirstHalf")) {
                                        diffInMonDays = (float) ((eMonDate.getTime() - sMonDate.getTime())
                                                / (1000 * 60 * 60 * 24)) + 1;
                                        diffInMonDays = diffInMonDays - 1;
                                    }
                                }
                                // Monday sandwich Leave code end

//                            if (diffInSatDays != noOfSatDays || (!date.equals(sSatDate) && !date.equals(eSatDate))) {
                                if (diffInSatDays != noOfSatDays || (date.before(eSatDate)
                                        && date.after(sSatDate) && diffInSatDays == noOfSatDays)) {
                                    woMap.put("" + next[0], woSatType);
                                } else if (diffInMonDays != -1 && diffInMonDays != noOfMonDays) {
                                    woMap.put("" + next[0], woMonType);
                                } else if ((diffInSatDays % 1 == 0 && diffInSatDays == noOfSatDays) && diffInMonDays == noOfMonDays) {
                                    woMap.put("" + next[0], "LWP");
                                } else {
                                    woMap.put("" + next[0], "WO");
                                }
                            } else {
                                woMap.put("" + next[0], "WO");
                            }
                        } else {
                            woMap.put("" + next[0], "WO");
                        }

                    }
                    // week off code End

//         1st Half:             Half day absent Code when start date is full and end date is first half start Code
                    Date date1 = sdf.parse("" + next[0]);
                    Calendar c2 = Calendar.getInstance();
                    c2.setTime(date1);
                    LeaveEmployeeDetail leaveEmployeeDetail = new LeaveEmployeeDetail();
                    SimpleDateFormat sdfAb = new SimpleDateFormat("dd/MM/yyyy");
                    leaveEmployeeDetail.setStartDate("" + sdfAb.format(c2.getTime()));
                    leaveEmployeeDetail.setEndDate("" + sdfAb.format(c2.getTime()));
                    leaveEmployeeDetail.setEmployeeMaster(employeeMaster);
                    leaveEmployeeDetail.setStatus(3);
                    List absentEmployeeDetail = leaveEmployeeDetailService.readLeaveDetails(leaveEmployeeDetail);
                    float diffInDays = 0;
                    String woType = "";
                    if (!absentEmployeeDetail.isEmpty()) {
                        Object[] oSatArray = (Object[]) absentEmployeeDetail.get(0);
                        woType = "" + oSatArray[0];
                        Date sDate = sdf.parse("" + oSatArray[1]);
                        Date eDate = sdf.parse("" + oSatArray[2]);
                        String sDateStr = "" + oSatArray[6];
                        String eDateStr = "" + oSatArray[7];
                        float noOfDays = (float) oSatArray[3];
                        if ((sDateStr.equals("Fullday") && eDateStr.equals("FirstHalf"))) {
                            diffInDays = (float) ((eDate.getTime() - sDate.getTime())
                                    / (1000 * 60 * 60 * 24)) + 1;
                            if (date1.equals(eDate)) {
                                diffInDays = diffInDays - (float) 0.5;
                            }
                        }
                    }
//        1st Half:              Half day absent Code when start date is full and end date is first half  End code

                    int dayOfWeek = c.get(Calendar.WEEK_OF_MONTH);
                    SimpleDateFormat format = new SimpleDateFormat("EEEE");
                    String dayName = format.format(date);

                    if (firstHalf.contains("fullday")) {
                        newList.add("PR");
                    } else if (!firstHalf.contains("fullday") && !firstHalf.equals("WO") && !firstHalf.equals("TR") && !firstHalf.equals("AR") && !firstHalf.equals("AB") && !firstHalf.contains("?")
                            && !firstHalf.equals("Casual Leave") && !firstHalf.equals("Short Leave") && !firstHalf.equals("C Off Leave") && !firstHalf.equals("Privilege Leave") && !firstHalf.equals("Sick Leave")
                            && !firstHalf.equals("Paternity Leave") && !firstHalf.equals("Maternity Leave") && !firstHalf.equals("Leave Without Pay")) {
                        String[] userTimeInStr = firstHalf.split("`");
                        String[] userTimeInStr1 = userTimeInStr[1].split("!");
                        String[] userTimeOutStr = firstHalf.split("!");
                        String[] userTimeOutStr1 = userTimeOutStr[1].split("@");
                        String[] leave = firstHalf.split("@");
                        String[] leave1 = leave[1].split("#");
                        String[] LateHoursStr = firstHalf.split("\\$");
                        String[] LateHoursStr1 = LateHoursStr[1].split("%");
                        String[] endHoursStr = firstHalf.split("%");
                        String[] endHoursStr1 = endHoursStr[1].split("\\^");
                        String[] firstStartHoursStr = endHoursStr[1].split("\\+");
                        Date userTimeIn = sdf2.parse(userTimeInStr1[0]);
                        Date userTimeOut = sdf2.parse(userTimeOutStr1[0]);
                        Date endHours = sdf2.parse(endHoursStr1[0]);
                        Date firstStartHours = sdf2.parse(firstStartHoursStr[1]);
                        Calendar cal = Calendar.getInstance();
                        Calendar cal1 = Calendar.getInstance();
                        cal.setTime(firstStartHours);
                        cal1.setTime(firstStartHours);
                        cal1.add(Calendar.MINUTE, -earlyMinute);
                        cal.add(Calendar.MINUTE, lateMinute);
                        String newTime = sdf2.format(cal.getTime());
                        Date flexibleEndTime = sdf2.parse(newTime);
                        Date LateHours = sdf2.parse(LateHoursStr1[0]);
                        String newTime1 = sdf2.format(cal1.getTime());
                        Date flexibleStartTime = sdf2.parse(newTime1);
                        long diff = endHours.getTime() - firstStartHours.getTime();
                        long diffMinutes = diff / (60 * 1000);
                        long diff1 = 0;
                        if (userTimeIn.after(flexibleStartTime) || userTimeIn.equals(flexibleStartTime)) {
                            diff1 = endHours.getTime() - userTimeIn.getTime();
                        } else {
                            diff1 = endHours.getTime() - flexibleStartTime.getTime();
                        }
                        long diffMinutes1 = diff1 / (60 * 1000);
                        if (dayName.equals("Saturday") && dayOfWeek == 2 && diffMinutes1 >= 240) {
                            newList.add("PR");
                        } else if (diffMinutes1 >= diffMinutes) {
                            newList.add("PR");
                        } else if (userTimeIn != null) {
                            if ((userTimeIn.before(flexibleEndTime) || userTimeIn.equals(flexibleEndTime)) && (userTimeOut.after(endHours) || userTimeOut.equals(endHours))) {
                                newList.add("PR");
                            } else if (userTimeOut.before(userTimeIn)) {
                                newList.add("PR");
                            } else if (leave1[0] != null && !leave1[0].contains("Short Leave")) {
                                if ((userTimeIn.before(flexibleEndTime) || userTimeIn.equals(flexibleEndTime)) && (userTimeOut.after(endHours) || userTimeOut.equals(endHours))) {
                                    newList.add("PR");
                                } else if (leave1[0].contains("AB")) {
                                    newList.add("AB");
                                } else if (leave1[0].contains("AR")) {
                                    newList.add("AR/P");
                                } else {
                                    if (leave1[0].contains("Casual Leave")) {
                                        newList.add("Casual Leave");
                                    }
                                    if (leave1[0].contains("Privilege Leave")) {
                                        newList.add("Privilege Leave");
                                    }
                                    if (leave1[0].contains("Sick Leave")) {
                                        newList.add("Sick Leave");
                                    }
                                    if (leave1[0].contains("Maternity Leave")) {
                                        newList.add("Maternity Leave");
                                    }
                                    if (leave1[0].contains("Paternity Leave")) {
                                        newList.add("Paternity Leave");
                                    }
                                    if (leave1[0].contains("C Off Leave")) {
                                        newList.add("C Off Leave");
                                    }
                                    if (leave1[0].contains("Leave Without Pay")) {
                                        newList.add("Leave Without Pay");
                                    }
                                }

                            } else if (null != leave1[0] && leave1[0].contains("Short Leave")) {
                                if (firstHalf.contains("*")) {
                                    String[] shortArray = firstHalf.split("\\*");
                                    String[] endArray = shortArray[1].split("\\-");
                                    String[] startTime = endArray[1].split("\\+");
                                    Date shortIn = sdf2.parse(shortArray[1]);
                                    Date shortend = sdf2.parse(endArray[1]);
                                    Date startTime1 = sdf2.parse(startTime[1]);
                                    if (shortIn.before(endHours)) {
                                        newList.add("SHL/P");
                                    } else if (leave1[0].contains("~ AR")) {
                                        newList.add("AR/P");
                                    } else if (userTimeIn.after(endHours)) {
                                        newList.add("SHL/A");
                                    } else if ((userTimeIn.before(flexibleEndTime) || userTimeIn.equals(flexibleEndTime)) && (userTimeOut.after(endHours) || userTimeOut.equals(endHours))) {
                                        newList.add("PR");
                                    } else {
                                        newList.add("AB");
                                    }
                                } else {
                                    newList.add("AB");
                                }
                            } else if (null != leave1[0] && !leave1[0].contains("AB")) {
                                if (leave1[0].contains("Casual Leave")) {
                                    newList.add("Casual Leave");
                                }
                                if (leave1[0].contains("Privilege Leave")) {
                                    newList.add("Privilege Leave");
                                }
                                if (leave1[0].contains("Sick Leave")) {
                                    newList.add("Sick Leave");
                                }
                                if (leave1[0].contains("Maternity Leave")) {
                                    newList.add("Maternity Leave");
                                }
                                if (leave1[0].contains("Paternity Leave")) {
                                    newList.add("Paternity Leave");
                                }
                                if (leave1[0].contains("C Off Leave")) {
                                    newList.add("C Off Leave");
                                }
                                if (leave1[0].contains("Leave Without Pay")) {
                                    newList.add("Leave Without Pay");
                                }

                            } else if (leave1[0].contains("AB")) {
                                newList.add("-");

                            } else {
                                newList.add("AB");
                            }

                        } else if (userTimeIn != null && !firstHalf.contains("WO") && !firstHalf.contains("?")) {
                            newList.add("AB");
                        } else if (firstHalf.contains("WO") || firstHalf.contains("?")) {
                            newList.add("-");
                        }

                    } else if (firstHalf.equals("WO")) {
                        newList.add("-");
                    } else if (firstHalf.contains("AR")) {
                        newList.add("AR/P");
                    } else if (firstHalf.equals("AB")) {
                        newList.add("AB");
                    } else if (firstHalf.equals("TR")) {
                        newList.add("-");
                    } else if (firstHalf.contains("?")) {
                        newList.add("-");
                    } else if (firstHalf.equals("Casual Leave") || firstHalf.equals("Privilege Leave") || firstHalf.equals("Sick Leave")
                            || firstHalf.equals("Maternity Leave") || firstHalf.equals("Paternity Leave") || firstHalf.equals("C Off Leave")
                            || firstHalf.equals("Leave Without Pay")) {
//       1st Half:                 Half day absent Code  start date is full and end date is First Half start code
                        if (diffInDays % 1 == 0) {
                            newList.add("-");
                        } else {
                            newList.add(firstHalf);
                            halfDayMap.put("" + next[0], woType);
                        }
//       1st Half:                 Half day absent Code  start date is full and end date is First Half End code
//                            newList.add("-");
                    } else if (firstHalf.equals("Short Leave")) {
                        newList.add("AB");
                    }
                } catch (Exception e) {

                }
            }

            Iterator itr6 = entry.getValue().iterator();
            int weekNameCounter = 0;
            boolean satWeekOff = false;
            while (itr6.hasNext()) {
                try {
                    Object[] next = (Object[]) itr6.next();

                    String secondHalf = "" + next[1];
                    int firstHalfVal = 0;

//       2nd Half:              Half day absent Code when start date is full and end date is first half  start Code
                    Date date1 = sdf.parse("" + next[0]);
                    Calendar c1 = Calendar.getInstance();
                    c1.setTime(date1);
                    LeaveEmployeeDetail leaveEmployeeDetail = new LeaveEmployeeDetail();
                    SimpleDateFormat sdfAb = new SimpleDateFormat("dd/MM/yyyy");
                    leaveEmployeeDetail.setStartDate("" + sdfAb.format(c1.getTime()));
                    leaveEmployeeDetail.setEndDate("" + sdfAb.format(c1.getTime()));
                    leaveEmployeeDetail.setEmployeeMaster(employeeMaster);
                    leaveEmployeeDetail.setStatus(3);
                    List absentEmployeeDetail = leaveEmployeeDetailService.readLeaveDetails(leaveEmployeeDetail);
                    float diffInDays = 0;
                    String woType = "";
                    if (!absentEmployeeDetail.isEmpty()) {
                        Object[] oSatArray = (Object[]) absentEmployeeDetail.get(0);
                        woType = "" + oSatArray[0];
                        Date sDate = sdf.parse("" + oSatArray[1]);
                        Date eDate = sdf.parse("" + oSatArray[2]);
                        String sDateStr = "" + oSatArray[6];
                        String eDateStr = "" + oSatArray[7];
                        float noOfDays = (float) oSatArray[3];
                        if ((sDateStr.equals("Fullday") && eDateStr.equals("FirstHalf"))) {
                            diffInDays = (float) ((eDate.getTime() - sDate.getTime())
                                    / (1000 * 60 * 60 * 24)) + 1;
                            if (date1.equals(eDate)) {
                                diffInDays = diffInDays - (float) 0.5;
                            }
                        }
                    }
//       2nd Half:              Half day absent Code when start date is full and end date is first half  end Code
                    int counter = 0;
                    String shiftName = "";
//                                    2nd Sat Week Off Codding
                    Calendar cal = Calendar.getInstance();
                    Date date = sdf.parse("" + next[0]);
                    cal.setTime(date);
                    SimpleDateFormat format = new SimpleDateFormat("EEEE");
                    String dayName = format.format(date);
                    int dayOfWeek = cal.get(Calendar.WEEK_OF_MONTH);
                    EmployeeMaster employeeMaster1 = employeeMasterService.readById(id);
                    ZydexLocationMaster zydexLocationMaster = zydexLocationMasterService.readById(employeeMaster1.getZydexLocationMaster().getId());

                    if (dayName.equals("Saturday")) {
                        if (dayOfWeek == 2) {
                            satWeekOff = true;
                            satMap.put("" + next[0], "AB");
                        } else {
                            satWeekOff = false;
                        }

                    } else {
                        satWeekOff = false;
                    }
//                                    2nd Sat Week Off Codding

//                                    Lunch Breck Cut Off
                    List listPunch = employeeDatetimeDataService.readPuchDataDateWise("" + next[0], id);
                    long lunchTime = 0;
                    long totalDayTime = 0;
                    long totalDayTime1 = 0;
                    long totalTime = 0;
                    long shiftdiffMinutes = 0;
                    String startTime = "";
                    String endTime = "";
                    SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                    long outTime = 0;
                    int d = 1;
                    int s = 2;
                    boolean checkLunchTime = false;
                    try {
                        if (zydexLocationMaster.getId() == 1 || zydexLocationMaster.getId() == 6) {
                            if (listPunch.size() > 2) {
                                while (listPunch.size() > d && listPunch.size() > s) {
                                    Object[] startLunchTime = (Object[]) listPunch.get(d);
                                    Object[] endLunchTime = (Object[]) listPunch.get(s);
                                    startTime = (String) startLunchTime[0];
                                    endTime = (String) endLunchTime[0];
                                    Date launchStrTime = sdf3.parse(startTime);
                                    Date launchEndTime = sdf3.parse(endTime);
                                    long diff = launchEndTime.getTime() - launchStrTime.getTime();
                                    lunchTime = diff / (60 * 1000);
                                    outTime = outTime + lunchTime;
                                    d = d + 2;
                                    s = s + 2;
                                }
                                String[] userTimeInStr = secondHalf.split("`");
                                String[] userTimeInStr1 = userTimeInStr[1].split("!");
                                String[] userTimeOutStr = secondHalf.split("!");
                                String[] userTimeOutStr1 = userTimeOutStr[1].split("@");
                                Date userTimeIn = sdf2.parse(userTimeInStr1[0]);
                                Date userTimeOut = sdf2.parse(userTimeOutStr1[0]);
                                String[] startHoursStr = secondHalf.split("%");
                                String[] firstStartHoursStr = startHoursStr[1].split("\\+");
                                String[] endHoursStr = secondHalf.split("&");
                                Date firstStartHours = sdf2.parse(firstStartHoursStr[1]);
                                Calendar cal1 = Calendar.getInstance();
                                cal1.setTime(firstStartHours);
                                cal1.add(Calendar.MINUTE, -earlyMinute);

                                String newTime1 = sdf2.format(cal1.getTime());
                                Date flexibleInTime = sdf2.parse(newTime1);
                                Date endHours = sdf2.parse(endHoursStr[1]);
                                long shiftTotalTime = endHours.getTime() - firstStartHours.getTime();
                                shiftdiffMinutes = shiftTotalTime / (60 * 1000);
                                long diff1 = 0;
                                long diff2 = 0;
                                if (userTimeIn.after(flexibleInTime) || userTimeIn.equals(flexibleInTime)) {
                                    diff1 = userTimeOut.getTime() - userTimeIn.getTime();

                                } else {
                                    diff1 = userTimeOut.getTime() - flexibleInTime.getTime();
                                }
                                totalDayTime = diff1 / (60 * 1000);

                                diff2 = userTimeOut.getTime() - userTimeIn.getTime();
                                totalDayTime1 = diff2 / (60 * 1000);

//                                        ===============30 minute lunch time 4 all employeee so who goes out side cut 30 min from their lunch time===============
//                                        =========================For who goes out side 4 lunch they have max 60 min time for lunch=======================
//                                        =========================For who goes out side 4 lunch they have max 60 min time for lunch=======================
                                long outTime1 = outTime;
                                outTime = outTime - 30;
//                                        ===============30 minute lunch time 4 all employeee so who goes out side cut 30 min from their lunch time===============
                                if (outTime1 == totalDayTime1) {
                                    totalTime = totalDayTime;
                                } else if (outTime > 0) {
                                    totalTime = totalDayTime - outTime;
                                    checkLunchTime = true;
                                }

                            }
                        } else {
//                            if (listPunch.size() > 2) {
//                                    Object[] startTimeO = (Object[]) listPunch.get(0);
//                                    Object[] endTimeO = (Object[]) listPunch.get(listPunch.size()-1);
//                                    startTime = (String) startTimeO[0];
//                                    endTime = (String) endTimeO[0];

                            String[] userTimeInStr = secondHalf.split("`");
                            String[] userTimeInStr1 = userTimeInStr[1].split("!");
                            String[] userTimeOutStr = secondHalf.split("!");
                            String[] userTimeOutStr1 = userTimeOutStr[1].split("@");
                            Date userTimeIn = sdf2.parse(userTimeInStr1[0]);
                            Date userTimeOut = sdf2.parse(userTimeOutStr1[0]);
                            String[] startHoursStr = secondHalf.split("%");
                            String[] firstStartHoursStr = startHoursStr[1].split("\\+");
                            String[] endHoursStr = secondHalf.split("&");
                            Date firstStartHours = sdf2.parse(firstStartHoursStr[1]);
                            Calendar cal1 = Calendar.getInstance();
                            cal1.setTime(firstStartHours);
                            cal1.add(Calendar.MINUTE, -earlyMinute);

                            String newTime1 = sdf2.format(cal1.getTime());
                            Date flexibleInTime = sdf2.parse(newTime1);
                            Date endHours = sdf2.parse(endHoursStr[1]);
                            long shiftTotalTime = endHours.getTime() - firstStartHours.getTime();
                            shiftdiffMinutes = shiftTotalTime / (60 * 1000);
                            long diff1 = 0;
                            long diff2 = 0;
                            if (userTimeIn.after(flexibleInTime) || userTimeIn.equals(flexibleInTime)) {
                                diff1 = userTimeOut.getTime() - userTimeIn.getTime();

                            } else {
                                diff1 = userTimeOut.getTime() - flexibleInTime.getTime();
                            }
                            totalDayTime = diff1 / (60 * 1000);

                            diff2 = userTimeOut.getTime() - userTimeIn.getTime();
                            totalDayTime1 = diff2 / (60 * 1000);
                            totalTime = totalDayTime;
//                            }

                        }

                    } catch (Exception e) {

                    }

//                                    Lunch Breck Cut Off
                    if (secondHalf.contains(" # ")) {
                        String[] string1 = secondHalf.split("#");
                        String[] string2 = string1[1].split("\\$");
                        shiftName = string2[0].trim();

                    }
                    if (satWeekOff == true && (zydexLocationMaster.getZydexLocation().equals("HO") || zydexLocationMaster.getZydexLocation().equals("R&D"))) {
                        secondHalfList.add("WO");
                    } else if (secondHalf.equals("AR")) {
                        secondHalfList.add("AR/P");
                    } else if (checkLunchTime == true && totalTime < shiftdiffMinutes && !secondHalf.contains("AR") && !secondHalf.contains("Short Leave")) {
                        secondHalfList.add("AB");
                    } else if (secondHalf.contains("fullday")) {
                        secondHalfList.add("PR");;

                    } else if (!secondHalf.contains("fullday") && !secondHalf.equals("WO") && !secondHalf.equals("TR") && !secondHalf.equals("AR") && !secondHalf.equals("AB") && !secondHalf.contains("?")
                            && !secondHalf.equals("Casual Leave") && !secondHalf.equals("Short Leave") && !secondHalf.equals("C Off Leave") && !secondHalf.equals("Privilege Leave") && !secondHalf.equals("Sick Leave")
                            && !secondHalf.equals("Paternity Leave") && !secondHalf.equals("Maternity Leave") && !secondHalf.equals("Leave Without Pay")) {
                        String[] leave = secondHalf.split("@");
                        String[] leave1 = leave[1].split("#");
                        String[] userTimeInStr = secondHalf.split("`");
                        String[] userTimeInStr1 = userTimeInStr[1].split("!");
                        String[] userTimeOutStr = secondHalf.split("!");
                        String[] userTimeOutStr1 = userTimeOutStr[1].split("@");
                        String[] secondHalfTimeStr = secondHalf.split("\\^");
                        String[] secondHalfTimeStr1 = secondHalfTimeStr[1].split("&");
                        String[] endHoursStr = secondHalf.split("&");
                        String[] startHoursStr = secondHalf.split("%");
                        String[] firstStartHoursStr = startHoursStr[1].split("\\+");

                        Date userTimeIn = sdf2.parse(userTimeInStr1[0]);
                        Date userTimeOut = sdf2.parse(userTimeOutStr1[0]);
                        Date userTimeOut1 = sdf2.parse("23:59");
                        Date firstStartHours = sdf2.parse(firstStartHoursStr[1]);
                        String[] getInHours = userTimeInStr1[0].split(":");
                        String[] getOutHours = userTimeOutStr1[0].split(":");
                        String abc = getInHours[0].trim();
                        String xyz = getOutHours[0].trim();
                        int i11 = Integer.parseInt(abc) - Integer.parseInt(xyz);
                        int totalDuration = 24 - i11;
                        String totalDuration2 = getOutHours[0];
                        Date endHours = sdf2.parse(endHoursStr[1]);
                        Date secondHalfTimeStr2 = sdf2.parse(secondHalfTimeStr1[0]);

                        Calendar cal1 = Calendar.getInstance();
                        Calendar cal2 = Calendar.getInstance();
                        cal1.setTime(firstStartHours);
                        cal1.add(Calendar.MINUTE, -earlyMinute);
                        cal2.setTime(firstStartHours);
                        cal2.add(Calendar.MINUTE, lateMinute);
                        String newTime = sdf2.format(cal2.getTime());
                        Date flexibleEndTime = sdf2.parse(newTime);

                        String newTime1 = sdf2.format(cal1.getTime());
                        Date flexibleInTime = sdf2.parse(newTime1);
                        long diff = endHours.getTime() - firstStartHours.getTime();
                        long diffMinutes = diff / (60 * 1000);
                        long diff1 = 0;
                        if (userTimeIn.after(flexibleInTime) || userTimeIn.equals(flexibleInTime)) {
                            if (userTimeOut.before(userTimeIn)) {
                                diff1 = userTimeOut1.getTime() - userTimeIn.getTime();
                            } else {
                                diff1 = userTimeOut.getTime() - userTimeIn.getTime();
                            }

                        } else if (userTimeOut.before(userTimeIn)) {
                            diff1 = userTimeOut1.getTime() - flexibleInTime.getTime();
                        } else {
                            diff1 = userTimeOut.getTime() - flexibleInTime.getTime();
                        }
                        long diffMinutes1 = diff1 / (60 * 1000);

                        if (userTimeIn != null) {
                            if (leave1[0].contains("AR")) {
                                secondHalfList.add("AR/P");

                            } else if (null != leave1[0] && leave1[0].contains("Short Leave")) {
                                if (secondHalf.contains("*")) {
                                    String[] shortArray = secondHalf.split("\\*");
                                    String[] endArray = secondHalf.split("\\^");
                                    String[] secondhalfstartTime = endArray[1].split("&");
                                    Date shortIn = sdf2.parse(shortArray[1]);
                                    Date shortend = sdf2.parse(endArray[1]);
                                    Date secondhalfstartTime1 = sdf2.parse(secondhalfstartTime[0]);
                                    if ((secondhalfstartTime1.before(shortIn) || secondhalfstartTime1.equals(shortIn)) && (shortIn.before(endHours) || shortIn.equals(endHours))) {
                                        if (userTimeOut.after(secondHalfTimeStr2)) {
                                            secondHalfList.add("SHL/P");
                                        } else if (leave1[0].contains("~ AR")) {
                                            secondHalfList.add("AR/P");
                                        } else if (userTimeOut.before(secondHalfTimeStr2) || userTimeOut.equals(secondHalfTimeStr2)) {
                                            secondHalfList.add("SHL/A");
                                        } else {
                                            secondHalfList.add("AB");
                                        }
                                    } else if (diffMinutes1 >= 240 && userTimeIn.before(secondHalfTimeStr2)) {
                                        secondHalfList.add("PR");
                                    }
                                } else if (diffMinutes1 >= 240 && userTimeIn.before(secondHalfTimeStr2)) {
                                    secondHalfList.add("PR");
                                } else {
                                    secondHalfList.add("AB");
                                }
                            } else if (diffMinutes1 >= diffMinutes && userTimeIn.before(flexibleEndTime)) {
                                secondHalfList.add("PR");
                            } else if (diffMinutes1 <= diffMinutes && userTimeIn.before(flexibleEndTime) && !secondHalf.contains("WO") && !secondHalf.contains("TR") && !secondHalf.contains("AR") && !secondHalf.contains("?")
                                    && !secondHalf.contains("Casual Leave") && !secondHalf.contains("Short Leave") && !secondHalf.equals("C Off Leave") && !secondHalf.contains("Privilege Leave") && !secondHalf.contains("Sick Leave")
                                    && !secondHalf.contains("Paternity Leave") && !secondHalf.contains("Maternity Leave") && !secondHalf.contains("Leave Without Pay")) {
                                secondHalfList.add("AB");
                            } else if (diffMinutes1 >= 240 && userTimeIn.after(secondHalfTimeStr2)) {
                                secondHalfList.add("PR");
                            } else if ((userTimeIn.before(secondHalfTimeStr2) || userTimeIn.equals(secondHalfTimeStr2)) && (userTimeOut.after(endHours) || userTimeOut.equals(endHours))) {
                                secondHalfList.add("PR");
                            } else if (shiftName.contains("Night") && (userTimeOut.after(endHours) || userTimeOut.equals(endHours))) {
                                secondHalfList.add("PR");
                            } else if (null != leave1[0] && !leave1[0].contains("AB") && !leave1[0].contains("AR")) {
                                if (leave1[0].contains("Casual Leave")) {
                                    secondHalfList.add("Casual Leave");
                                }
                                if (leave1[0].contains("Privilege Leave")) {
                                    secondHalfList.add("Privilege Leave");
                                }
                                if (leave1[0].contains("Sick Leave")) {
                                    secondHalfList.add("Sick Leave");
                                }
                                if (leave1[0].contains("Maternity Leave")) {
                                    secondHalfList.add("Maternity Leave");
                                }
                                if (leave1[0].contains("Paternity Leave")) {
                                    secondHalfList.add("Paternity Leave");
                                }
                                if (leave1[0].contains("C Off Leave")) {
                                    secondHalfList.add("C Off Leave");
                                }
                                if (leave1[0].contains("Leave Without Pay")) {
                                    secondHalfList.add("Leave Without Pay");
                                }

                            } else if (leave1[0].contains("AB")) {
                                secondHalfList.add("AB");
                            } else {
                                secondHalfList.add("AB");
                            }

                        } else if (userTimeIn != null && !secondHalf.contains("WO") && !secondHalf.contains("?")) {
                            secondHalfList.add("AB");
                        } else if (secondHalf.contains("WO") || secondHalf.contains("?")) {
                            secondHalfList.add("-");
                        }

                    } else if (secondHalf.equals("WO")) {
                        secondHalfList.add("-");
                    } else if (secondHalf.equals("AB")) {
                        secondHalfList.add("AB");
                    } else if (secondHalf.equals("TR")) {
                        secondHalfList.add("-");
                    } else if (secondHalf.contains("?")) {
                        secondHalfList.add("-");
                    } else if (secondHalf.equals("Casual Leave") || secondHalf.equals("Privilege Leave") || secondHalf.equals("Sick Leave")
                            || secondHalf.equals("Maternity Leave") || secondHalf.equals("Paternity Leave") || secondHalf.equals("C Off Leave")
                            || secondHalf.equals("Leave Without Pay")) {
//2nd Half:              Half day absent Code when start date is full and end date is first half  start Code
                        if (diffInDays % 1 == 0) {
                            secondHalfList.add("-");
                        } else {
                            secondHalfList.add("AB");
                        }
// 2nd Half:              Half day absent Code when start date is full and end date is first half  end Code
//                            secondHalfList.add("-");
                    } else if (secondHalf.equals("Short Leave")) {
                        secondHalfList.add("AB");
                    }
                } catch (Exception e) {

                }
            }

            Iterator itr7 = entry.getValue().iterator();
            while (itr7.hasNext()) {
                try {
                    Object[] next = (Object[]) itr7.next();
                    String secondHalf = "" + next[1];
                    int firstHalfVal = 0;
                    int counter = 0;
                    String shiftName = "";
                    if (("" + next[0]).contains("17/")) {
                        System.out.println("hiii" + shiftName);
                    }
                    List listPunch = employeeDatetimeDataService.readPuchDataDateWise("" + next[0], id);
//                    List mobPunchlist = employeePunchForMobileAppService.readPuchDataDateWise("" + next[0], id);
                    List mobPunchlist = null;
                    long lunchTime = 0;
                    long outTime = 0;
                    long totalDayTime = 0;
                    long totalDayTime1 = 0;
                    long totalTime = 0;
                    long shiftdiffMinutes = 0;
                    boolean checkLunchTime = false;
                    int i = 1;
                    int j = 2;
                    String startTime = "";
                    String endTime = "";
                    SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                    if (listPunch.size() > 0 && !secondHalf.equals("WO") && !secondHalf.equals("AB") && !secondHalf.equals("TR") && !secondHalf.equals("AR")) {
                        EmployeeMaster employeeMaster1 = employeeMasterService.readById(id);
                        ZydexLocationMaster zydexLocationMaster = zydexLocationMasterService.readById(employeeMaster1.getZydexLocationMaster().getId());
                        if (zydexLocationMaster.getId() == 1 || zydexLocationMaster.getId() == 6) {
                            if (listPunch.size() > 2) {
                                while (listPunch.size() > i && listPunch.size() > j) {

                                    Object[] startLunchTime = (Object[]) listPunch.get(i);
                                    Object[] endLunchTime = (Object[]) listPunch.get(j);
                                    startTime = (String) startLunchTime[0];
                                    endTime = (String) endLunchTime[0];
                                    Date launchStrTime = sdf3.parse(startTime);
                                    Date launchEndTime = sdf3.parse(endTime);
                                    long diff = launchEndTime.getTime() - launchStrTime.getTime();
                                    lunchTime = diff / (60 * 1000);
                                    outTime = outTime + lunchTime;
                                    i = i + 2;
                                    j = j + 2;
                                }
                            }
                        }

                        String[] userTimeInStr = secondHalf.split("`");
                        String[] userTimeInStr1 = userTimeInStr[1].split("!");
                        String[] userTimeOutStr = secondHalf.split("!");
                        String[] userTimeOutStr1 = userTimeOutStr[1].split("@");
                        Date userTimeIn = sdf2.parse(userTimeInStr1[0]);
                        Date userTimeOut = sdf2.parse(userTimeOutStr1[0]);
                        Date userTimeOut1 = sdf2.parse("24:00");
                        Date userTimeon12 = sdf2.parse("00:00");
                        String[] startHoursStr = secondHalf.split("%");
                        String[] firstStartHoursStr = startHoursStr[1].split("\\+");
                        String[] endHoursStr = secondHalf.split("&");
                        Date firstStartHours = sdf2.parse(firstStartHoursStr[1]);
                        Calendar cal1 = Calendar.getInstance();
                        cal1.setTime(firstStartHours);
                        cal1.add(Calendar.MINUTE, -earlyMinute);
                        String newTime1 = sdf2.format(cal1.getTime());
                        Date flexibleInTime = sdf2.parse(newTime1);
                        Date endHours = sdf2.parse(endHoursStr[1]);
                        long shiftTotalTime = endHours.getTime() - firstStartHours.getTime();
                        shiftdiffMinutes = shiftTotalTime / (60 * 1000);
                        long diff1 = 0;
                        long diff2 = 0;

                        if (zydexLocationMaster.getId() == 1 || zydexLocationMaster.getId() == 6) {
                            if (userTimeIn.after(flexibleInTime) || userTimeIn.equals(flexibleInTime)) {
                                if (userTimeOut.before(userTimeIn)) {
                                    diff1 = userTimeOut1.getTime() - userTimeIn.getTime();
                                } else {
                                    diff1 = userTimeOut.getTime() - userTimeIn.getTime();
                                }

                            } else if (userTimeOut.before(userTimeIn)) {
                                diff1 = userTimeOut1.getTime() - flexibleInTime.getTime();
                            } else {
                                diff1 = userTimeOut.getTime() - flexibleInTime.getTime();
                            }

                            totalDayTime = diff1 / (60 * 1000);

                            if (userTimeOut.before(userTimeIn)) {
                                diff2 = userTimeOut1.getTime() - userTimeIn.getTime();
                            } else {
                                diff2 = userTimeOut.getTime() - userTimeIn.getTime();
                            }

                            totalDayTime1 = diff2 / (60 * 1000);
//                                        ===============30 minute lunch time 4 all employeee so who goes out side cut 30 min from their lunch time===============
//                                        =========================For who goes out side 4 lunch they have max 60 min time for lunch=======================
//                                        =========================For who goes out side 4 lunch they have max 60 min time for lunch=======================
                            long outTime1 = outTime;
                            outTime = outTime - 30;
//                                        ===============30 minute lunch time 4 all employeee so who goes out side cut 30 min from their lunch time===============
                            ///////////////AR code Start///////////////////////////////////////////////////
                            AttendanceRegularization attendanceRegularization = new AttendanceRegularization();
                            attendanceRegularization.setStartDateTime("" + next[0]);
                            attendanceRegularization.setUserMasterId(employeeMaster.getUserMaster().getId());
                            long ARdiff = 0;
                            long ARTime = 0;
                            SimpleDateFormat sdf4 = new SimpleDateFormat("dd/mm/yyyy HH:mm");
                            List list = attendanceRegularizationMasterService.readArCountList(attendanceRegularization);
                            if (!list.isEmpty()) {
                                Object[] arm = (Object[]) list.get(0);
                                Date InTimeAR = sdf4.parse(arm[1].toString());
                                Date OutTimeAR = sdf4.parse(arm[2].toString());

                                ARdiff = OutTimeAR.getTime() - InTimeAR.getTime();
                                ARTime = ARdiff / (60 * 1000);

                            }
                            ///////////////AR code End////////////////////////////////////////
                            totalDayTime = totalDayTime + ARTime;
                            if (outTime > 0 && outTime1 != totalDayTime1) {
                                totalTime = totalDayTime - outTime;
                                double empHour = (double) totalTime / 60;
                                int hours = (int) empHour;
                                int minutes = (int) (empHour * 60) % 60;
                                String hour = "" + hours;
                                String minute = "" + minutes;
                                if (minutes < 10 && minutes > 0) {
                                    minute = "0" + minute;
                                } else if (minutes < 0) {
                                    minute = "00";
                                }
                                String workingHours = hour + ":" + minute;
                                workingHour.add(workingHours);

                            } else {
                                double empHour = (double) totalDayTime / 60;
                                int hours = (int) empHour;
                                int minutes = (int) (empHour * 60) % 60;
                                String hour = "" + hours;
                                String minute = "" + minutes;
                                if (minutes < 10 && minutes > 0) {
                                    minute = "0" + minute;
                                } else if (minutes < 0) {
                                    minute = "00";
                                }
                                String workingHours = hour + ":" + minute;
                                workingHour.add(workingHours);
                            }
                        } else {

                            if (userTimeIn.after(flexibleInTime) || userTimeIn.equals(flexibleInTime)) {
                                if (userTimeOut.before(userTimeIn)) {
                                    diff1 = userTimeOut1.getTime() - userTimeIn.getTime();
                                } else {
                                    diff1 = userTimeOut.getTime() - userTimeIn.getTime();
                                }

                            } else if (userTimeOut.before(userTimeIn)) {
                                diff1 = userTimeOut1.getTime() - flexibleInTime.getTime();
                            } else {
                                diff1 = userTimeOut.getTime() - flexibleInTime.getTime();
                            }

                            totalDayTime = diff1 / (60 * 1000);

                            if (userTimeOut.before(userTimeIn)) {

                                diff2 = userTimeOut.getTime() - userTimeon12.getTime();
//                                diff2 = userTimeOut1.getTime() - userTimeIn.getTime();
                            } else {
//                                diff2 = userTimeOut.getTime() - userTimeIn.getTime();
                            }
                            ///////////////AR code Start///////////////////////////////////////////////////
                            AttendanceRegularization attendanceRegularization = new AttendanceRegularization();
                            attendanceRegularization.setStartDateTime("" + next[0]);
                            attendanceRegularization.setUserMasterId(employeeMaster.getUserMaster().getId());
                            long ARdiff = 0;
                            long ARTime = 0;
                            SimpleDateFormat sdf4 = new SimpleDateFormat("dd/mm/yyyy HH:mm");
                            List list = attendanceRegularizationMasterService.readArCountList(attendanceRegularization);
                            if (!list.isEmpty()) {
                                Object[] arm = (Object[]) list.get(0);
                                Date InTimeAR = sdf4.parse(arm[1].toString());
                                Date OutTimeAR = sdf4.parse(arm[2].toString());

                                ARdiff = OutTimeAR.getTime() - InTimeAR.getTime();
                                ARTime = ARdiff / (60 * 1000);

                            }
                            ///////////////AR code End////////////////////////////////////////
                            totalDayTime1 = diff2 / (60 * 1000);

                            totalDayTime = totalDayTime + totalDayTime1 + ARTime;

                            double empHour = (double) totalDayTime / 60;
                            int hours = (int) empHour;
                            int minutes = (int) (empHour * 60) % 60;
                            String hour = "" + hours;
                            String minute = "" + minutes;
                            if (minutes < 10 && minutes > 0) {
                                minute = "0" + minute;
                            } else if (minutes < 0) {
                                minute = "00";
                            }

                            String workingHours = hour + ":" + minute;
                            workingHour.add(workingHours);

                        }

                    } else if (null != mobPunchlist && mobPunchlist.size() > 0 && !secondHalf.equals("WO") && !secondHalf.equals("AB") && !secondHalf.equals("TR") && !secondHalf.equals("AR")) {
                        if (mobPunchlist.size() > 2) {
                            while (mobPunchlist.size() > i && mobPunchlist.size() > j) {

                                Object[] startLunchTime = (Object[]) mobPunchlist.get(i);
                                Object[] endLunchTime = (Object[]) mobPunchlist.get(j);
                                startTime = (String) startLunchTime[0];
                                endTime = (String) endLunchTime[0];
                                Date launchStrTime = sdf3.parse(startTime);
                                Date launchEndTime = sdf3.parse(endTime);
                                long diff = launchEndTime.getTime() - launchStrTime.getTime();
                                lunchTime = diff / (60 * 1000);
                                outTime = outTime + lunchTime;
                                i = i + 2;
                                j = j + 2;
                            }
                        }

                        String[] userTimeInStr = secondHalf.split("`");
                        String[] userTimeInStr1 = userTimeInStr[1].split("!");
                        String[] userTimeOutStr = secondHalf.split("!");
                        String[] userTimeOutStr1 = userTimeOutStr[1].split("@");
                        Date userTimeIn = sdf2.parse(userTimeInStr1[0]);
                        Date userTimeOut = sdf2.parse(userTimeOutStr1[0]);
                        Date userTimeOut1 = sdf2.parse("23:59");
                        String[] startHoursStr = secondHalf.split("%");
                        String[] firstStartHoursStr = startHoursStr[1].split("\\+");
                        String[] endHoursStr = secondHalf.split("&");
                        Date firstStartHours = sdf2.parse(firstStartHoursStr[1]);
                        Calendar cal1 = Calendar.getInstance();
                        cal1.setTime(firstStartHours);
                        cal1.add(Calendar.MINUTE, -earlyMinute);
                        String newTime1 = sdf2.format(cal1.getTime());
                        Date flexibleInTime = sdf2.parse(newTime1);
                        Date endHours = sdf2.parse(endHoursStr[1]);
                        long shiftTotalTime = endHours.getTime() - firstStartHours.getTime();
                        shiftdiffMinutes = shiftTotalTime / (60 * 1000);
                        long diff1 = 0;
                        long diff2 = 0;
                        if (userTimeIn.after(flexibleInTime) || userTimeIn.equals(flexibleInTime)) {
                            if (userTimeOut.before(userTimeIn)) {
                                diff1 = userTimeOut1.getTime() - userTimeIn.getTime();
                            } else {
                                diff1 = userTimeOut.getTime() - userTimeIn.getTime();
                            }

                        } else if (userTimeOut.before(userTimeIn)) {
                            diff1 = userTimeOut1.getTime() - flexibleInTime.getTime();
                        } else {
                            diff1 = userTimeOut.getTime() - flexibleInTime.getTime();
                        }

                        totalDayTime = diff1 / (60 * 1000);

                        if (userTimeOut.before(userTimeIn)) {
                            diff2 = userTimeOut1.getTime() - userTimeIn.getTime();
                        } else {
                            diff2 = userTimeOut.getTime() - userTimeIn.getTime();
                        }

                        totalDayTime1 = diff2 / (60 * 1000);

//                                        ===============30 minute lunch time 4 all employeee so who goes out side cut 30 min from their lunch time===============
//                                        =========================For who goes out side 4 lunch they have max 60 min time for lunch=======================
//                                        =========================For who goes out side 4 lunch they have max 60 min time for lunch=======================
                        long outTime1 = outTime;
                        outTime = outTime - 30;
//                                        ===============30 minute lunch time 4 all employeee so who goes out side cut 30 min from their lunch time===============
                        if (outTime > 0 && outTime1 != totalDayTime1) {
                            totalTime = totalDayTime - outTime;
                            double empHour = (double) totalTime / 60;
                            int hours = (int) empHour;
                            int minutes = (int) (empHour * 60) % 60;
                            String hour = "" + hours;
                            String minute = "" + minutes;
                            if (minutes < 10 && minutes > 0) {
                                minute = "0" + minute;
                            } else if (minutes < 0) {
                                minute = "00";
                            }
                            String workingHours = hour + ":" + minute;
                            workingHour.add(workingHours);

                        } else {
                            double empHour = (double) totalDayTime / 60;
                            int hours = (int) empHour;
                            int minutes = (int) (empHour * 60) % 60;
                            String hour = "" + hours;
                            String minute = "" + minutes;
                            if (minutes < 10 && minutes > 0) {
                                minute = "0" + minute;
                            } else if (minutes < 0) {
                                minute = "00";
                            }
                            String workingHours = hour + ":" + minute;
                            workingHour.add(workingHours);
                        }
                    } else {
                        workingHour.add("-");
                    }
                } catch (Exception e) {
                    workingHour.add("-");

                }

            }

        }

//        List<?> attendanceDateList =
//        List<?> l1 = null;
//        if (("".equals(startDate) || null == startDate) || ("".equals(endDate) || null == endDate)) {
//            empDetail = l1;
//        }
        mv.getModelMap()
                .put("firstHalfList", newList);
        mv.getModelMap()
                .put("secondHalfList", secondHalfList);
        mv.getModelMap()
                .put("workingHour", workingHour);
        mv.getModelMap()
                .put("empDetail", empDetail);
        mv.getModelMap()
                .put("map", map);
        mv.getModelMap()
                .put("woMap", woMap);
        mv.getModelMap()
                .put("satMap", satMap);
        mv.getModelMap()
                .put("halfDayMap", halfDayMap);
        mv.getModelMap()
                .put("employeeAdvanceSearch", employeeAdvanceSearch);
        Date notflexibleSupportDate;

        if (startDate.contains("-")) {
            notflexibleSupportDate = sdf1.parse(startDate);
        } else {
            notflexibleSupportDate = sdf.parse(startDate);
        }
        String FixedFlexibleDate = "01/04/2016";
        Date notflexibleSupportDate1 = sdf.parse(FixedFlexibleDate);
        Calendar calForFlexiNotSupport1 = Calendar.getInstance();
        Calendar calForFlexiNotSupport2 = Calendar.getInstance();

        calForFlexiNotSupport1.setTime(notflexibleSupportDate);

        calForFlexiNotSupport2.setTime(notflexibleSupportDate1);

        if (flexible == true) {
            mv.setViewName("Shift/EmployeeFlexibleDayWisePunchDataReport");
        } else {
            mv.setViewName("Shift/EmployeeIndividualOrDateWiseShiftSearch");
        }

        return mv;
    }

    public ModelAndView employeeDataSearchSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeShiftData employeeShiftData = new EmployeeShiftData();
        EmployeeAdvanceSearch employeeAdvanceSearch = new EmployeeAdvanceSearch();
        String startDate = request.getParameter("inDateTime");
        String endDate = request.getParameter("outDateTime");
        bind(request, employeeAdvanceSearch);
        String searchval = request.getParameter("vallist");
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");

        employeeAdvanceSearch.setId("" + employeeMaster.getId());
        employeeAdvanceSearch.setZydexLocationId(null);
        employeeAdvanceSearch.setLevelID(null);
        employeeAdvanceSearch.setDepartmentId(null);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        if (null != employeeMaster.getId() && !employeeMaster.getId().equals("")) {
            employeeShiftData.setId(employeeMaster.getId());
        }
        employeeAdvanceSearch.setEmployeeId(Boolean.FALSE);
        employeeAdvanceSearch.setEmployeeName(Boolean.FALSE);
        employeeAdvanceSearch.setFatherName(Boolean.FALSE);
        employeeAdvanceSearch.setMotherName(Boolean.FALSE);
        employeeAdvanceSearch.setGender(Boolean.FALSE);
        employeeAdvanceSearch.setMaritalStatus(Boolean.FALSE);
        employeeAdvanceSearch.setSpouseName(Boolean.FALSE);
        employeeAdvanceSearch.setDateOfBirth(Boolean.FALSE);
        employeeAdvanceSearch.setPresentAddress(Boolean.FALSE);
        employeeAdvanceSearch.setPermanentAddress(Boolean.FALSE);
        employeeAdvanceSearch.setBloodGroups(Boolean.FALSE);
        employeeAdvanceSearch.setEmailAddress(Boolean.FALSE);
        employeeAdvanceSearch.setContactNo1(Boolean.FALSE);
        employeeAdvanceSearch.setContactNo2(Boolean.FALSE);
        employeeAdvanceSearch.setEmergencyContactPerson(Boolean.FALSE);
        employeeAdvanceSearch.setEmergencyContactNo(Boolean.FALSE);
        employeeAdvanceSearch.setPanCard(Boolean.FALSE);
        employeeAdvanceSearch.setPassportNo(Boolean.FALSE);
        employeeAdvanceSearch.setPassportIssueDate(Boolean.FALSE);
        employeeAdvanceSearch.setPassportExpiryDate(Boolean.FALSE);
        employeeAdvanceSearch.setAdharCard(Boolean.FALSE);
        employeeAdvanceSearch.setOfficeEmailId(Boolean.FALSE);
        employeeAdvanceSearch.setHighestEducationDetails(Boolean.FALSE);
        employeeAdvanceSearch.setExperienceYearOnDoj(Boolean.FALSE);
        employeeAdvanceSearch.setExperienceMonthOnDoj(Boolean.FALSE);
        employeeAdvanceSearch.setCompany(Boolean.FALSE);
        employeeAdvanceSearch.setZydexLocation(Boolean.FALSE);
        employeeAdvanceSearch.setWorkLocation(Boolean.FALSE);
        employeeAdvanceSearch.setLevel(Boolean.FALSE);
        employeeAdvanceSearch.setDepartment(Boolean.FALSE);
        employeeAdvanceSearch.setDesignation(Boolean.FALSE);
        employeeAdvanceSearch.setRole(Boolean.FALSE);
        employeeAdvanceSearch.setDateOfJoining(Boolean.FALSE);
        employeeAdvanceSearch.setEmployeeType(Boolean.FALSE);
        employeeAdvanceSearch.setBankName(Boolean.FALSE);
        employeeAdvanceSearch.setBankAccountNo(Boolean.FALSE);
        employeeAdvanceSearch.setBankIfscCode(Boolean.FALSE);
        employeeAdvanceSearch.setReportingManager(Boolean.FALSE);
        employeeAdvanceSearch.setCityOfEmployee(Boolean.FALSE);
        employeeAdvanceSearch.setChild1(Boolean.FALSE);
        employeeAdvanceSearch.setChild2(Boolean.FALSE);
        employeeAdvanceSearch.setDateOfBirthOfEmpFather(Boolean.FALSE);
        employeeAdvanceSearch.setDateOfBirthOfEmpMother(Boolean.FALSE);
        employeeAdvanceSearch.setDateOfBirthOfEmpSpous(Boolean.FALSE);
        employeeAdvanceSearch.setDateOfBirthOfEmpChilld1(Boolean.FALSE);
        employeeAdvanceSearch.setDateOfBirthOfEmpChild2(Boolean.FALSE);
        employeeAdvanceSearch.setDateOfTransferOfEntity(Boolean.FALSE);

        if (!startDate.equals("")) {
            Date sDate = sdf.parse(startDate);
//            "2012-01-01"
            employeeShiftData.setInDateTime(new SimpleDateFormat("yyyy-MM-dd").format(sDate));

        }
        if (!endDate.equals("")) {
            Date eDate = sdf.parse(endDate);
            employeeShiftData.setOutDateTime(new SimpleDateFormat("yyyy-MM-dd").format(eDate));
        }

        List<?> empDetail = employeeMasterService.empOrDateWiseSearch(employeeAdvanceSearch);
        Map<Integer, List<?>> map = new LinkedHashMap<Integer, List<?>>();
        for (Object o1 : empDetail) {
            Object[] o = (Object[]) o1;
            int id = (Integer) o[48];
            employeeShiftData.setId(id);
            List<?> list = employeeShiftDataService.empOrDateWiseSearch(employeeShiftData);
            map.put(id, list);
        }

//        response.setContentType("application/vnd.ms-excel");
//        response.setHeader("Content-Disposition", "attachment; filename=EmployeeAdvanceSearch.xls");
        mv.getModelMap().put("empDetail", empDetail);
        mv.getModelMap().put("map", map);
        mv.getModelMap().put("employeeAdvanceSearch", employeeAdvanceSearch);
        mv.setViewName("Shift/EmployeeShiftResult");
        return mv;
    }

    public ModelAndView showDateWisePunchData(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String date = request.getParameter("date");
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date datecoverted = sdf.parse(date1);
//        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/YYYY");
//        String date = sdf1.format(datecoverted);
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        int empId = employeeMaster.getId();

        List<?> punchList = employeeDatetimeDataService.readPuchDataDateWise(date, empId);
        if (punchList.isEmpty()) {
            List<?> MobPunchList = employeePunchForMobileAppService.readPuchDataDateWise(date, empId);
            mv.getModelMap().put("punchList", MobPunchList);
        } else {
            mv.getModelMap().put("punchList", punchList);

        }
        mv.setViewName("Shift/ShowIndividualPuchData");

        return mv;
    }

    public ModelAndView powerAdminApprovalList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AttendanceRegularization attendanceRegularization = new AttendanceRegularization();
        List<?> list = attendanceRegularizationMasterService.powerAdminAttendanceRegularizationList();
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("attendanceRegularization", attendanceRegularization);
        mv.setViewName("AttendanceRegularization/attendanceRegularizationViewResult");
        return mv;
    }

    public ModelAndView approvalEditClickByAdmin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AttendanceRegularization attendanceRegularization = new AttendanceRegularization();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        String id = request.getParameter("id");
        attendanceRegularization = attendanceRegularizationMasterService.readById(Integer.parseInt(id));
        int status1 = attendanceRegularization.getStatus();
        String status = Integer.toString(status1);
        request.setAttribute("status", status);
        String remarkNmame = attendanceRegularization.getManagerRemark();
        request.setAttribute("remarkNmame", remarkNmame);
        int userId = attendanceRegularization.getUserMasterId();
        UserMaster user = new UserMaster();
        user.setId(userId);
        employeeMaster.setUserMaster(user);
        int reportingId = 0;
        List<?> empDetailList = employeeMasterService.readEmployeeDetailUserIdWise(employeeMaster);
        if (!empDetailList.isEmpty()) {
            request.setAttribute("employeeMaster", empDetailList.get(0));
            Object[] arrayOfObject = (Object[]) empDetailList.get(0);
            String reportmanager = (String) arrayOfObject[6];
            if (!reportmanager.equals("")) {
                reportingId = Integer.parseInt(reportmanager);
            }

            employeeMaster1.setId(reportingId);
        }
        List<?> reportmanager1 = employeeMasterService.readByReportManager(employeeMaster1);
        if (!reportmanager1.isEmpty()) {
            employeeMaster1 = (EmployeeMaster) reportmanager1.get(0);
            request.setAttribute("reportingManager", employeeMaster1.getEmployeeName());

        }
        mv.getModelMap().put("attendanceRegularization", attendanceRegularization);
        mv.setViewName("AttendanceRegularization/attendanceRegularizationApprovalAdmin");
        return mv;
    }

    public ModelAndView approvalEditSubmitByAdmin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AttendanceRegularization attendanceRegularization = new AttendanceRegularization();
        String id = "" + request.getParameter("id");
//        String remark = "" + request.getParameter("remark");
        String remark = "";
        attendanceRegularization = attendanceRegularizationMasterService.readById(Integer.parseInt(id));

        if (attendanceRegularization.getArType().equals("Official")) {
            attendanceRegularization.setStatus(1);
            attendanceRegularization.setManagerRemark(remark);

//        EmployeeMaster approverName = new EmployeeMaster();
            EmployeeMaster approverName = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String requestdate = sdf.format(new Date());
            attendanceRegularization.setApprovedDate(requestdate);
            attendanceRegularization.setEmployeeMaster(approverName);
            attendanceRegularizationMasterService.createOrUpdate(attendanceRegularization);

//        Employee Date Time Data
            if (attendanceRegularization.getStatus() == 1) {
                int userId = attendanceRegularization.getUserMasterId();
                UserMaster userMaster = new UserMaster();
                userMaster.setId(userId);
                EmployeeMaster employeeMaster = new EmployeeMaster();
                employeeMaster.setUserMaster(userMaster);
                List<?> l = employeeMasterService.readByEmployeeUserId(employeeMaster);
                employeeMaster = (EmployeeMaster) l.get(0);
                String startDate = attendanceRegularization.getStartDateTime();
                String endDate = attendanceRegularization.getEndDateTime();
                EmployeeDatetimeData employeeDatetimeData = new EmployeeDatetimeData();
                EmployeeDatetimeData employeeDatetimeData1 = new EmployeeDatetimeData();
                employeeDatetimeData.setEmployeeMaster(employeeMaster);
                employeeDatetimeData.setDateTime(startDate);
                employeeDatetimeData1.setEmployeeMaster(employeeMaster);
                employeeDatetimeData1.setDateTime(endDate);
                employeeDatetimeDataService.createOrUpdate(employeeDatetimeData);
                employeeDatetimeDataService.createOrUpdate(employeeDatetimeData1);

                EmployeeShiftData employeeShiftData = new EmployeeShiftData();
                EmployeeShiftData employeeShiftData1 = new EmployeeShiftData();
                employeeShiftData.setInDateTime(startDate);
                employeeShiftData.setEmployeeMaster(employeeMaster);
                List<?> shift = employeeShiftDataService.attendanceRegularizationEntry(employeeShiftData);
                if (!shift.isEmpty()) {
                    employeeShiftData1 = (EmployeeShiftData) shift.get(0);
                    employeeShiftData1.setInDateTime(startDate);
                    employeeShiftData1.setOutDateTime(endDate);
                    employeeShiftData1.setEmployeeMaster(employeeMaster);
                    employeeShiftData1.setShiftMaster(employeeShiftData1.getShiftMaster());
                    employeeShiftDataService.update(employeeShiftData1);
                }

                // add c-off balance in employee leave balance when day is sunday
//                    SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
//                    Date startDate1 = sdf1.parse(startDate);
//                    Date endDate1 = sdf1.parse(endDate);
//                    long diff = endDate1.getTime() - startDate1.getTime();
//                    int days = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
//                    for (int i = 0; i <= days + 1; i++) {
//                        String dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(startDate1);
//                        if (dayOfWeek.equals("Sunday")) {
//                            String time = "0.8";
//
//                            OverTimeMaster overTimeMaster = new OverTimeMaster();
//                            String overTimeDate = sdf1.format(startDate1);
//                            overTimeMaster.setDate(overTimeDate);
//                            overTimeMaster.setTime(time);
//
//                            overTimeMaster.setEmployeeMaster(employeeMaster);
//
//                            EmployeeLeaveBalance employeeLeaveBalance = new EmployeeLeaveBalance();
//                            EmployeeLeaveBalance employeeLeaveBalance1 = new EmployeeLeaveBalance();
//                            LeaveTypeMaster leaveTypeMaster = new LeaveTypeMaster();
//                            leaveTypeMaster.setId(11);
//                            employeeLeaveBalance.setLeaveTypeMaster(leaveTypeMaster);
//                            employeeLeaveBalance.setEmployeeMaster(employeeMaster);
//                            EmployeeMaster employeeMaster2 = new EmployeeMaster();
//                            employeeMaster2 = employeeMasterService.readById(employeeMaster.getId());
//                            int levelId = employeeMaster.getLevelMaster().getId();
//                            LevelMaster levelMaster1 = new LevelMaster();
//                            levelMaster1 = levelMasterService.readById(levelId);
//                            if (employeeMaster.getZydexLocationMaster().getId().equals(5) && levelMaster1.getLevel().contains("Level 4") || levelMaster1.getLevel().contains("Level 5")) {
//                                List<?> empBalList = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance);
//                                if (!empBalList.isEmpty()) {
//                                    employeeLeaveBalance1 = (EmployeeLeaveBalance) empBalList.get(0);
//                                    float time1 = employeeLeaveBalance1.getNoOfLeaveRemain();
//                                    time1 = time1 + Float.parseFloat(time);
//                                    employeeLeaveBalance1.setNoOfLeaveRemain(time1);
//                                    employeeLeaveBalanceService.update(employeeLeaveBalance1);
//                                } else {
//                                    employeeLeaveBalance1.setLeaveTypeMaster(leaveTypeMaster);
//                                    employeeLeaveBalance1.setEmployeeMaster(employeeMaster);
//                                    employeeLeaveBalance1.setNoOfLeaveRemain(Float.parseFloat(time));
//                                    employeeLeaveBalanceService.create(employeeLeaveBalance1);
//                                }
//                                overTimeMasterService.create(overTimeMaster);
//                            }
//
//                        }
//                        Calendar c = Calendar.getInstance();
//                        c.setTime(startDate1);
//                        c.add(Calendar.DATE, 1);
//                        startDate1 = c.getTime();
//                    }
                // add c-off balance in employee leave balance when day is sunday
                try {
                    EmailTemplate emailTemplate = new EmailTemplate();
                    EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                    DesignationMaster designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                    EmployeeMaster employeeMaster1 = new EmployeeMaster();
                    //id=69 is for attandence regularization approve to employee...
                    emailTemplate = emailTemplateService.readById(69);
                    EmployeeMaster employeeMaster2 = new EmployeeMaster();
                    UserMaster userMaster1 = new UserMaster();
                    userMaster1.setId(attendanceRegularization.getUserMasterId());
                    employeeMaster2.setUserMaster(userMaster1);
                    List list1 = employeeMasterService.readByUserName(employeeMaster2);
                    if (!list1.isEmpty()) {
                        employeeMaster1 = (EmployeeMaster) list1.get(0);
                        String To = employeeMaster1.getOfficeEmailId();
                        String from = employeeMasterModel.getOfficeEmailId();
                        String Subject = emailTemplate.getSubject();
                        Subject = Subject.replaceAll("\\{user\\}", employeeMaster1.getEmployeeName());
                        String msg = emailTemplate.getBodytext();
                        msg = msg.replaceAll("\\{to_user\\}", employeeMaster1.getEmployeeName());
                        msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                        msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                        sendMail.sendMail(from, To, Subject, msg);

                        String name = "Attendance";
                        EmailAddMaster emailAddMaster = new EmailAddMaster();
                        emailAddMaster.setModuleName(name);
                        emailAddMaster.setDepartmentMaster(employeeMaster1.getDepartmentMaster());
                        List<?> emailSendList = emailAddMasterService.readByName(emailAddMaster);
                        if (!emailSendList.isEmpty()) {
                            EmailAddMaster emailAddMaster1 = (EmailAddMaster) emailSendList.get(0);
                            String emailId = emailAddMaster1.getEmailId();
                            for (String emailId1 : emailId.split(",")) {
                                if (!emailId1.equals("")) {
                                    String To1 = emailId1;
                                    String from1 = employeeMasterModel.getOfficeEmailId();
                                    String subject1 = emailTemplate.getSubject();
                                    subject1 = subject1.replaceAll("\\{user\\}", employeeMaster1.getEmployeeName());
                                    String msg1 = emailTemplate.getBodytext();
                                    msg1 = msg1.replaceAll("\\{to_user\\}", employeeMaster1.getEmployeeName());
                                    msg1 = msg1.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                                    msg1 = msg1.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                                    sendMail.sendMail(from1, To1, subject1, msg1);

                                }
                            }
                        }
                    }
                } catch (Exception e) {
                }

            }

        }
        if (attendanceRegularization.getArType().equals("Compassion")) {
            if (attendanceRegularization.getStatus() == 11) {

                attendanceRegularization.setStatus(1);
                attendanceRegularization.setManagerRemark(remark);

//        EmployeeMaster approverName = new EmployeeMaster();
                EmployeeMaster approverName = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String requestdate = sdf.format(new Date());
                attendanceRegularization.setApprovedDate(requestdate);
                attendanceRegularization.setEmployeeMaster(approverName);
                attendanceRegularizationMasterService.createOrUpdate(attendanceRegularization);

//        Employee Date Time Data
                if (attendanceRegularization.getStatus() == 1) {
                    int userId = attendanceRegularization.getUserMasterId();
                    UserMaster userMaster = new UserMaster();
                    userMaster.setId(userId);
                    EmployeeMaster employeeMaster = new EmployeeMaster();
                    employeeMaster.setUserMaster(userMaster);
                    List<?> l = employeeMasterService.readByEmployeeUserId(employeeMaster);
                    employeeMaster = (EmployeeMaster) l.get(0);
                    String startDate = attendanceRegularization.getStartDateTime();
                    String endDate = attendanceRegularization.getEndDateTime();
                    EmployeeDatetimeData employeeDatetimeData = new EmployeeDatetimeData();
                    EmployeeDatetimeData employeeDatetimeData1 = new EmployeeDatetimeData();
                    employeeDatetimeData.setEmployeeMaster(employeeMaster);
                    employeeDatetimeData.setDateTime(startDate);
                    employeeDatetimeData1.setEmployeeMaster(employeeMaster);
                    employeeDatetimeData1.setDateTime(endDate);
                    employeeDatetimeDataService.createOrUpdate(employeeDatetimeData);
                    employeeDatetimeDataService.createOrUpdate(employeeDatetimeData1);

                    EmployeeShiftData employeeShiftData = new EmployeeShiftData();
                    EmployeeShiftData employeeShiftData1 = new EmployeeShiftData();
                    employeeShiftData.setInDateTime(startDate);
                    employeeShiftData.setEmployeeMaster(employeeMaster);
                    List<?> shift = employeeShiftDataService.attendanceRegularizationEntry(employeeShiftData);
                    if (!shift.isEmpty()) {
                        employeeShiftData1 = (EmployeeShiftData) shift.get(0);
                        employeeShiftData1.setInDateTime(startDate);
                        employeeShiftData1.setOutDateTime(endDate);
                        employeeShiftData1.setEmployeeMaster(employeeMaster);
                        employeeShiftData1.setShiftMaster(employeeShiftData1.getShiftMaster());
                        employeeShiftDataService.update(employeeShiftData1);
                    }

            // add c-off balance in employee leave balance when day is sunday
//                    SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
//                    Date startDate1 = sdf1.parse(startDate);
//                    Date endDate1 = sdf1.parse(endDate);
//                    long diff = endDate1.getTime() - startDate1.getTime();
//                    int days = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
//                    for (int i = 0; i <= days + 1; i++) {
//                        String dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(startDate1);
//                        if (dayOfWeek.equals("Sunday")) {
//                            String time = "0.8";
//
//                            OverTimeMaster overTimeMaster = new OverTimeMaster();
//                            String overTimeDate = sdf1.format(startDate1);
//                            overTimeMaster.setDate(overTimeDate);
//                            overTimeMaster.setTime(time);
//
//                            overTimeMaster.setEmployeeMaster(employeeMaster);
//
//                            EmployeeLeaveBalance employeeLeaveBalance = new EmployeeLeaveBalance();
//                            EmployeeLeaveBalance employeeLeaveBalance1 = new EmployeeLeaveBalance();
//                            LeaveTypeMaster leaveTypeMaster = new LeaveTypeMaster();
//                            leaveTypeMaster.setId(11);
//                            employeeLeaveBalance.setLeaveTypeMaster(leaveTypeMaster);
//                            employeeLeaveBalance.setEmployeeMaster(employeeMaster);
//                            EmployeeMaster employeeMaster2 = new EmployeeMaster();
//                            employeeMaster2 = employeeMasterService.readById(employeeMaster.getId());
//                            int levelId = employeeMaster.getLevelMaster().getId();
//                            LevelMaster levelMaster1 = new LevelMaster();
//                            levelMaster1 = levelMasterService.readById(levelId);
//                            if (employeeMaster.getZydexLocationMaster().getId().equals(5) && levelMaster1.getLevel().contains("Level 4") || levelMaster1.getLevel().contains("Level 5")) {
//                                List<?> empBalList = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance);
//                                if (!empBalList.isEmpty()) {
//                                    employeeLeaveBalance1 = (EmployeeLeaveBalance) empBalList.get(0);
//                                    float time1 = employeeLeaveBalance1.getNoOfLeaveRemain();
//                                    time1 = time1 + Float.parseFloat(time);
//                                    employeeLeaveBalance1.setNoOfLeaveRemain(time1);
//                                    employeeLeaveBalanceService.update(employeeLeaveBalance1);
//                                } else {
//                                    employeeLeaveBalance1.setLeaveTypeMaster(leaveTypeMaster);
//                                    employeeLeaveBalance1.setEmployeeMaster(employeeMaster);
//                                    employeeLeaveBalance1.setNoOfLeaveRemain(Float.parseFloat(time));
//                                    employeeLeaveBalanceService.create(employeeLeaveBalance1);
//                                }
//                                overTimeMasterService.create(overTimeMaster);
//                            }
//
//                        }
//                        Calendar c = Calendar.getInstance();
//                        c.setTime(startDate1);
//                        c.add(Calendar.DATE, 1);
//                        startDate1 = c.getTime();
//                    }
                    // add c-off balance in employee leave balance when day is sunday
                    try {
                        EmailTemplate emailTemplate = new EmailTemplate();
                        EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                        DesignationMaster designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                        EmployeeMaster employeeMaster1 = new EmployeeMaster();
                        //id=69 is for attandence regularization approve to employee...
                        emailTemplate = emailTemplateService.readById(69);
                        EmployeeMaster employeeMaster2 = new EmployeeMaster();
                        UserMaster userMaster1 = new UserMaster();
                        userMaster1.setId(attendanceRegularization.getUserMasterId());
                        employeeMaster2.setUserMaster(userMaster1);
                        List list1 = employeeMasterService.readByUserName(employeeMaster2);
                        if (!list1.isEmpty()) {
                            employeeMaster1 = (EmployeeMaster) list1.get(0);
                            String To = employeeMaster1.getOfficeEmailId();
                            String from = employeeMasterModel.getOfficeEmailId();
                            String Subject = emailTemplate.getSubject();
                            Subject = Subject.replaceAll("\\{user\\}", employeeMaster1.getEmployeeName());
                            String msg = emailTemplate.getBodytext();
                            msg = msg.replaceAll("\\{to_user\\}", employeeMaster1.getEmployeeName());
                            msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                            msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                            sendMail.sendMail(from, To, Subject, msg);

                            String name = "Attendance";
                            EmailAddMaster emailAddMaster = new EmailAddMaster();
                            emailAddMaster.setModuleName(name);
                            emailAddMaster.setDepartmentMaster(employeeMaster1.getDepartmentMaster());
                            List<?> emailSendList = emailAddMasterService.readByName(emailAddMaster);
                            if (!emailSendList.isEmpty()) {
                                EmailAddMaster emailAddMaster1 = (EmailAddMaster) emailSendList.get(0);
                                String emailId = emailAddMaster1.getEmailId();
                                for (String emailId1 : emailId.split(",")) {
                                    if (!emailId1.equals("")) {
                                        String To1 = emailId1;
                                        String from1 = employeeMasterModel.getOfficeEmailId();
                                        String subject1 = emailTemplate.getSubject();
                                        subject1 = subject1.replaceAll("\\{user\\}", employeeMaster1.getEmployeeName());
                                        String msg1 = emailTemplate.getBodytext();
                                        msg1 = msg1.replaceAll("\\{to_user\\}", employeeMaster1.getEmployeeName());
                                        msg1 = msg1.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                                        msg1 = msg1.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                                        sendMail.sendMail(from1, To1, subject1, msg1);

                                    }
                                }
                            }
                        }
                    } catch (Exception e) {
                    }

                }

            } else {

                attendanceRegularization.setStatus(11);
                attendanceRegularization.setManagerRemark(remark);

//        EmployeeMaster approverName = new EmployeeMaster();
                EmployeeMaster approverName = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String requestdate = sdf.format(new Date());
                attendanceRegularization.setApprovedDate(requestdate);
                attendanceRegularization.setEmployeeMaster(approverName);
                attendanceRegularizationMasterService.createOrUpdate(attendanceRegularization);

//        Employee Date Time Data
                if (attendanceRegularization.getStatus() == 11) {
                    int userId = attendanceRegularization.getUserMasterId();
                    UserMaster userMaster = new UserMaster();
                    userMaster.setId(userId);
                    EmployeeMaster employeeMaster = new EmployeeMaster();
                    employeeMaster.setUserMaster(userMaster);
                    List<?> l = employeeMasterService.readByEmployeeUserId(employeeMaster);
                    employeeMaster = (EmployeeMaster) l.get(0);
                    String startDate = attendanceRegularization.getStartDateTime();
                    String endDate = attendanceRegularization.getEndDateTime();
                    EmployeeDatetimeData employeeDatetimeData = new EmployeeDatetimeData();
                    EmployeeDatetimeData employeeDatetimeData1 = new EmployeeDatetimeData();
                    employeeDatetimeData.setEmployeeMaster(employeeMaster);
                    employeeDatetimeData.setDateTime(startDate);
                    employeeDatetimeData1.setEmployeeMaster(employeeMaster);
                    employeeDatetimeData1.setDateTime(endDate);
                    employeeDatetimeDataService.createOrUpdate(employeeDatetimeData);
                    employeeDatetimeDataService.createOrUpdate(employeeDatetimeData1);

                    EmployeeShiftData employeeShiftData = new EmployeeShiftData();
                    EmployeeShiftData employeeShiftData1 = new EmployeeShiftData();
                    employeeShiftData.setInDateTime(startDate);
                    employeeShiftData.setEmployeeMaster(employeeMaster);
                    List<?> shift = employeeShiftDataService.attendanceRegularizationEntry(employeeShiftData);
                    if (!shift.isEmpty()) {
                        employeeShiftData1 = (EmployeeShiftData) shift.get(0);
                        employeeShiftData1.setInDateTime(startDate);
                        employeeShiftData1.setOutDateTime(endDate);
                        employeeShiftData1.setEmployeeMaster(employeeMaster);
                        employeeShiftData1.setShiftMaster(employeeShiftData1.getShiftMaster());
                        employeeShiftDataService.update(employeeShiftData1);
                    }

                    // add c-off balance in employee leave balance when day is sunday
//                    SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
//                    Date startDate1 = sdf1.parse(startDate);
//                    Date endDate1 = sdf1.parse(endDate);
//                    long diff = endDate1.getTime() - startDate1.getTime();
//                    int days = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
//                    for (int i = 0; i <= days + 1; i++) {
//                        String dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(startDate1);
//                        if (dayOfWeek.equals("Sunday")) {
//                            String time = "0.8";
//
//                            OverTimeMaster overTimeMaster = new OverTimeMaster();
//                            String overTimeDate = sdf1.format(startDate1);
//                            overTimeMaster.setDate(overTimeDate);
//                            overTimeMaster.setTime(time);
//
//                            overTimeMaster.setEmployeeMaster(employeeMaster);
//
//                            EmployeeLeaveBalance employeeLeaveBalance = new EmployeeLeaveBalance();
//                            EmployeeLeaveBalance employeeLeaveBalance1 = new EmployeeLeaveBalance();
//                            LeaveTypeMaster leaveTypeMaster = new LeaveTypeMaster();
//                            leaveTypeMaster.setId(11);
//                            employeeLeaveBalance.setLeaveTypeMaster(leaveTypeMaster);
//                            employeeLeaveBalance.setEmployeeMaster(employeeMaster);
//                            EmployeeMaster employeeMaster2 = new EmployeeMaster();
//                            employeeMaster2 = employeeMasterService.readById(employeeMaster.getId());
//                            int levelId = employeeMaster.getLevelMaster().getId();
//                            LevelMaster levelMaster1 = new LevelMaster();
//                            levelMaster1 = levelMasterService.readById(levelId);
//                            if (employeeMaster.getZydexLocationMaster().getId().equals(5) && levelMaster1.getLevel().contains("Level 4") || levelMaster1.getLevel().contains("Level 5")) {
//                                List<?> empBalList = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance);
//                                if (!empBalList.isEmpty()) {
//                                    employeeLeaveBalance1 = (EmployeeLeaveBalance) empBalList.get(0);
//                                    float time1 = employeeLeaveBalance1.getNoOfLeaveRemain();
//                                    time1 = time1 + Float.parseFloat(time);
//                                    employeeLeaveBalance1.setNoOfLeaveRemain(time1);
//                                    employeeLeaveBalanceService.update(employeeLeaveBalance1);
//                                } else {
//                                    employeeLeaveBalance1.setLeaveTypeMaster(leaveTypeMaster);
//                                    employeeLeaveBalance1.setEmployeeMaster(employeeMaster);
//                                    employeeLeaveBalance1.setNoOfLeaveRemain(Float.parseFloat(time));
//                                    employeeLeaveBalanceService.create(employeeLeaveBalance1);
//                                }
//                                overTimeMasterService.create(overTimeMaster);
//                            }
//
//                        }
//                        Calendar c = Calendar.getInstance();
//                        c.setTime(startDate1);
//                        c.add(Calendar.DATE, 1);
//                        startDate1 = c.getTime();
//                    }
                    // add c-off balance in employee leave balance when day is sunday
                    try {
                    EmailTemplate emailTemplate = new EmailTemplate();
                    EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                    DesignationMaster designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                    EmployeeMaster employeeMaster1 = new EmployeeMaster();

                    List<?> allhrlist = userRightMasterService.readallHRList();

                    if (!allhrlist.isEmpty()) {

                        for (Object obj : allhrlist) {
                            UserRightMaster userRightMaster = new UserRightMaster();
                            EmployeeMaster employeeMaster2 = new EmployeeMaster();
                            userRightMaster = (UserRightMaster) obj;
                            List list = employeeMasterService.readByUserId(userRightMaster.getUserMaster().getId());
                            if (!list.isEmpty()) {

                                for (Object obj1 : list) {
                                    employeeMaster2 = (EmployeeMaster) obj1;
                                    emailTemplate = emailTemplateService.readById(69);

                                    String To = employeeMaster2.getOfficeEmailId();
                                    String from = employeeMasterModel.getOfficeEmailId();
                                    String Subject = emailTemplate.getSubject();
                                    Subject = Subject.replaceAll("\\{user\\}", employeeMaster2.getEmployeeName());
                                    String msg = emailTemplate.getBodytext();
                                    msg = msg.replaceAll("\\{to_user\\}", employeeMaster2.getEmployeeName());
                                    msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                                    msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                                    sendMail.sendMail(from, To, Subject, msg);
                                }

                            }

                        }
                    }
                    //id=69 is for attandence regularization approve to employee...
                    emailTemplate = emailTemplateService.readById(69);
                    String EmpStr = request.getParameter("empid");
                    if (null != EmpStr && !"".equals(EmpStr)) {
                        int Empid = Integer.parseInt(EmpStr);
                        List list = employeeMasterService.readByEmployeeNo(Empid);
                        if (!list.isEmpty()) {
                            employeeMaster1 = (EmployeeMaster) list.get(0);
                            String To = employeeMaster1.getOfficeEmailId();
                            String from = employeeMasterModel.getOfficeEmailId();
                            String Subject = emailTemplate.getSubject();
                            Subject = Subject.replaceAll("\\{user\\}", employeeMaster1.getEmployeeName());
                            String msg = emailTemplate.getBodytext();
                            msg = msg.replaceAll("\\{to_user\\}", employeeMaster1.getEmployeeName());
                            msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                            msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                            sendMail.sendMail(from, To, Subject, msg);

                        }

                    }

                } catch (Exception e) {
                    System.out.println(e);
                }

                }

            }

        }

//        mv.setViewName("redirect:attendanceRegularizationMaster.htm?act=powerAdminApprovalList");
        mv.setViewName("redirect:attendanceRegularizationMaster.htm?act=approvalSubmit");
        return mv;
    }

    public ModelAndView rejectSubmitByAdmin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AttendanceRegularization attendanceRegularization = new AttendanceRegularization();
        String id = request.getParameter("id");
        String remark = "";
        attendanceRegularization = attendanceRegularizationMasterService.readById(Integer.parseInt(id));
        attendanceRegularization.setStatus(3);
        attendanceRegularization.setManagerRemark(remark);
        EmployeeMaster approverName = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String requestdate = sdf.format(new Date());
        attendanceRegularization.setApprovedDate(requestdate);
        attendanceRegularization.setEmployeeMaster(approverName);
        attendanceRegularizationMasterService.createOrUpdate(attendanceRegularization);

        try {

            EmailTemplate emailTemplate = new EmailTemplate();
            EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
            DesignationMaster designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
            UserMaster userMaster = new UserMaster();
            userMaster.setId(attendanceRegularization.getUserMasterId());
            EmployeeMaster employeeMaster1 = new EmployeeMaster();
            employeeMaster1.setUserMaster(userMaster);
            List list = employeeMasterService.readByUserName(employeeMaster1);
            //id=17 is for attandence regularization reject...
            emailTemplate = emailTemplateService.readById(17);
//            String EmpStr = request.getParameter("empid");
//            if (null != EmpStr && !"".equals(EmpStr)) {
//                int Empid = Integer.parseInt(EmpStr);
//                List list = employeeMasterService.readByEmployeeNo(Empid);
            if (!list.isEmpty()) {
                employeeMaster1 = (EmployeeMaster) list.get(0);
                String To = employeeMaster1.getOfficeEmailId();
                String from = employeeMasterModel.getOfficeEmailId();
                String Subject = emailTemplate.getSubject();
                Subject = Subject.replaceAll("\\{user\\}", employeeMaster1.getEmployeeName());
                String msg = emailTemplate.getBodytext();
                msg = msg.replaceAll("\\{to_user\\}", employeeMaster1.getEmployeeName());
                msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                sendMail.sendMail(from, To, Subject, msg);

//                }
            }

        } catch (Exception e) {
        }

        mv.setViewName("redirect:attendanceRegularizationMaster.htm?act=approvalSubmit");
//        mv.setViewName("redirect:attendanceRegularizationMaster.htm?act=powerAdminApprovalList");
        return mv;
    }

    public ModelAndView reworkSubmitByAdmin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AttendanceRegularization attendanceRegularization = new AttendanceRegularization();
        String id = request.getParameter("id");
        String remark = "";
        attendanceRegularization = attendanceRegularizationMasterService.readById(Integer.parseInt(id));
        attendanceRegularization.setStatus(7);
        attendanceRegularization.setManagerRemark(remark);
        EmployeeMaster approverName = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String requestdate = sdf.format(new Date());
        attendanceRegularization.setApprovedDate(requestdate);
        attendanceRegularization.setEmployeeMaster(approverName);
        attendanceRegularizationMasterService.createOrUpdate(attendanceRegularization);
        try {

            EmailTemplate emailTemplate = new EmailTemplate();
            EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
            DesignationMaster designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
            EmployeeMaster employeeMaster1 = new EmployeeMaster();
            //id=16 is for attandence regularization rework...
            emailTemplate = emailTemplateService.readById(16);
            UserMaster userMaster = new UserMaster();
            userMaster.setId(attendanceRegularization.getUserMasterId());
            employeeMaster1.setUserMaster(userMaster);
            List<?> list = employeeMasterService.readByUserName(employeeMaster1);
//            String EmpStr = request.getParameter("empid");
//            if (null != EmpStr && !"".equals(EmpStr)) {
//                int Empid = Integer.parseInt(EmpStr);
//                List list = employeeMasterService.readByEmployeeNo(Empid);
            if (!list.isEmpty()) {
                employeeMaster1 = (EmployeeMaster) list.get(0);
                String To = employeeMaster1.getOfficeEmailId();
                String from = employeeMasterModel.getOfficeEmailId();
                String Subject = emailTemplate.getSubject();
                Subject = Subject.replaceAll("\\{user\\}", employeeMaster1.getEmployeeName());
                String msg = emailTemplate.getBodytext();
                msg = msg.replaceAll("\\{to_user\\}", employeeMaster1.getEmployeeName());
                msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                sendMail.sendMail(from, To, Subject, msg);

            }

        } catch (Exception e) {
        }

        mv.setViewName("redirect:attendanceRegularizationMaster.htm?act=approvalSubmit");
//        mv.setViewName("redirect:attendanceRegularizationMaster.htm?act=powerAdminApprovalList");
        return mv;
    }

    public ModelAndView exportToExcelAttendenceRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AttendanceRegularization attendanceRegularization = new AttendanceRegularization();
        List<?> list = attendanceRegularizationMasterService.powerAdminAttendanceRegularizationList();
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=ARList.xls");
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("attendanceRegularization", attendanceRegularization);
        mv.setViewName("AttendanceRegularization/attendanceRegularizationViewResultExport");
        return mv;
    }

    public ModelAndView subOrdinateAttendanceView(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        List<?> list = employeeMasterService.readAllSubordinate(employeeMaster);
        mv.getModelMap().put("list", list);
        mv.setViewName("AttendanceRegularization/SubOrdinateAttendanceView");
        return mv;
    }

    public ModelAndView allEmployeeAttendanceView(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        List<?> list = employeeMasterService.readAllEmployee(employeeMaster);
        mv.getModelMap().put("list", list);
        mv.setViewName("AttendanceRegularization/AllEmployeeAttendanceView");
        return mv;
    }

    public ModelAndView showOwnAttandanceOfSubordinate(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeAdvanceSearch employeeAdvanceSearch = new EmployeeAdvanceSearch();
        EmployeeShiftData employeeShiftData = new EmployeeShiftData();
        String startDate = request.getParameter("inDateTime");
        String endDate = request.getParameter("outDateTime");
        bind(request, employeeAdvanceSearch);

        String id = request.getParameter("id");
        employeeAdvanceSearch.setId(id);
        employeeAdvanceSearch.setZydexLocationId(null);
        employeeAdvanceSearch.setLevelID(null);
        employeeAdvanceSearch.setDepartmentId(null);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Map<String, String> woMap = new HashMap<String, String>();
        Map<String, String> satMap = new HashMap<String, String>();
        Map<String, String> halfDayMap = new HashMap<String, String>();
        if (null != id && !id.equals("")) {
            employeeShiftData.setId(Integer.parseInt(id));
        }
        employeeAdvanceSearch.setEmployeeId(Boolean.FALSE);
        employeeAdvanceSearch.setEmployeeName(Boolean.FALSE);
        employeeAdvanceSearch.setFatherName(Boolean.FALSE);
        employeeAdvanceSearch.setMotherName(Boolean.FALSE);
        employeeAdvanceSearch.setGender(Boolean.FALSE);
        employeeAdvanceSearch.setMaritalStatus(Boolean.FALSE);
        employeeAdvanceSearch.setSpouseName(Boolean.FALSE);
        employeeAdvanceSearch.setDateOfBirth(Boolean.FALSE);
        employeeAdvanceSearch.setPresentAddress(Boolean.FALSE);
        employeeAdvanceSearch.setPermanentAddress(Boolean.FALSE);
        employeeAdvanceSearch.setBloodGroups(Boolean.FALSE);
        employeeAdvanceSearch.setEmailAddress(Boolean.FALSE);
        employeeAdvanceSearch.setContactNo1(Boolean.FALSE);
        employeeAdvanceSearch.setContactNo2(Boolean.FALSE);
        employeeAdvanceSearch.setEmergencyContactPerson(Boolean.FALSE);
        employeeAdvanceSearch.setEmergencyContactNo(Boolean.FALSE);
        employeeAdvanceSearch.setPanCard(Boolean.FALSE);
        employeeAdvanceSearch.setPassportNo(Boolean.FALSE);
        employeeAdvanceSearch.setPassportIssueDate(Boolean.FALSE);
        employeeAdvanceSearch.setPassportExpiryDate(Boolean.FALSE);
        employeeAdvanceSearch.setAdharCard(Boolean.FALSE);
        employeeAdvanceSearch.setOfficeEmailId(Boolean.FALSE);
        employeeAdvanceSearch.setHighestEducationDetails(Boolean.FALSE);
        employeeAdvanceSearch.setExperienceYearOnDoj(Boolean.FALSE);
        employeeAdvanceSearch.setExperienceMonthOnDoj(Boolean.FALSE);
        employeeAdvanceSearch.setCompany(Boolean.FALSE);
        employeeAdvanceSearch.setZydexLocation(Boolean.FALSE);
        employeeAdvanceSearch.setWorkLocation(Boolean.FALSE);
        employeeAdvanceSearch.setLevel(Boolean.FALSE);
        employeeAdvanceSearch.setDepartment(Boolean.FALSE);
        employeeAdvanceSearch.setDesignation(Boolean.FALSE);
        employeeAdvanceSearch.setRole(Boolean.FALSE);
        employeeAdvanceSearch.setDateOfJoining(Boolean.FALSE);
        employeeAdvanceSearch.setEmployeeType(Boolean.FALSE);
        employeeAdvanceSearch.setBankName(Boolean.FALSE);
        employeeAdvanceSearch.setBankAccountNo(Boolean.FALSE);
        employeeAdvanceSearch.setBankIfscCode(Boolean.FALSE);
        employeeAdvanceSearch.setReportingManager(Boolean.FALSE);
        employeeAdvanceSearch.setCityOfEmployee(Boolean.FALSE);
        employeeAdvanceSearch.setChild1(Boolean.FALSE);
        employeeAdvanceSearch.setChild2(Boolean.FALSE);
        employeeAdvanceSearch.setDateOfBirthOfEmpFather(Boolean.FALSE);
        employeeAdvanceSearch.setDateOfBirthOfEmpMother(Boolean.FALSE);
        employeeAdvanceSearch.setDateOfBirthOfEmpSpous(Boolean.FALSE);
        employeeAdvanceSearch.setDateOfBirthOfEmpChilld1(Boolean.FALSE);
        employeeAdvanceSearch.setDateOfBirthOfEmpChild2(Boolean.FALSE);
        employeeAdvanceSearch.setDateOfTransferOfEntity(Boolean.FALSE);

        if ((!"".equals(startDate) && null != startDate) && (!"".equals(endDate) && null != endDate)) {
            if (!"".equals(startDate) && null != startDate) {
                Date sDate = sdf.parse(startDate);
//            "2012-01-01"
                employeeShiftData.setInDateTime(new SimpleDateFormat("yyyy-MM-dd").format(sDate));

            }
            if (!"".equals(endDate) && null != endDate) {
                Date eDate = sdf.parse(endDate);
                employeeShiftData.setOutDateTime(new SimpleDateFormat("yyyy-MM-dd").format(eDate));
            }
        } else {
            Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int day = c.get(Calendar.DAY_OF_MONTH);
            int month = c.get(Calendar.MONTH) + 1;

            startDate = year + "-" + (month < 10 ? ("0" + month) : (month)) + "-01";
            Date sDate = sdf1.parse(startDate);
            endDate = year + "-" + (month < 10 ? ("0" + month) : (month)) + "-" + day;
            Date eDate = sdf1.parse(endDate);
            employeeShiftData.setInDateTime(sdf1.format(sDate));
            employeeShiftData.setOutDateTime(sdf1.format(eDate));
        }

        List<?> empDetail = employeeMasterService.empOrDateWiseSearch(employeeAdvanceSearch);
        Map<Integer, List<?>> map = new LinkedHashMap<Integer, List<?>>();
        for (Object o1 : empDetail) {
            Object[] o = (Object[]) o1;
            int id1 = (Integer) o[48];
            employeeShiftData.setId(id1);

            List list = employeeShiftDataService.empOrDateWiseSearch(employeeShiftData);
            int i = 0;
            for (Iterator<? extends Object> iterator = list.iterator(); iterator.hasNext();) {
                Object[] next = (Object[]) iterator.next();

                String firstHalf = "" + next[1];
                if (!firstHalf.contains("fullday") && !firstHalf.equals("WO") && !firstHalf.equals("TR") && !firstHalf.equals("AR") && !firstHalf.equals("AB") && !firstHalf.contains("?")
                        && !firstHalf.equals("Casual Leave") && !firstHalf.equals("Short Leave") && !firstHalf.equals("C Off Leave") && !firstHalf.equals("Privilege Leave") && !firstHalf.equals("Sick Leave")
                        && !firstHalf.equals("Paternity Leave") && !firstHalf.equals("Maternity Leave") && !firstHalf.equals("Leave Without Pay")) {
                    Date date1 = sdf.parse("" + next[0]);
                    Calendar c2 = Calendar.getInstance();
                    c2.setTime(date1);
                    SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");
                    String[] userTimeInStr = firstHalf.split("`");
                    String[] userTimeInStr1 = userTimeInStr[1].split("!");
                    String[] userTimeOutStr = firstHalf.split("!");
                    String[] userTimeOutStr1 = userTimeOutStr[1].split("@");
                    Date userTimeIn = sdf2.parse(userTimeInStr1[0]);
                    Date userTimeOut = sdf2.parse(userTimeOutStr1[0]);
                    if (userTimeOut.before(userTimeIn)) {
                        next[1] = ("" + next[1]).replace("AB", "fullday");
//                        tempList.add(""+next[0]);
//                        tempList.add(("" + next[1]).replace("AB", "PR"));
                        list.set(i, next);
                    }
                }
                i++;
            }
            map.put(Integer.parseInt(id), list);
            request.setAttribute("attendanceDateList", list);
        }

        EmployeeMaster employeeMaster1 = employeeMasterService.readById(Integer.parseInt(id));
        boolean flexible = false;
        int earlyMinute = 0;
        int lateMinute = 0;
        List<?> timeAttFlexibleList = timeAttandanceFlaxibleMasterService.read();
        if (!timeAttFlexibleList.isEmpty()) {
            for (Object flexiObject : timeAttFlexibleList) {
                TimeAttandanceFlaxibleMaster timeAttandanceFlaxibleMaster = (TimeAttandanceFlaxibleMaster) flexiObject;
                int zydexLocId = timeAttandanceFlaxibleMaster.getZydexLocationMaster().getId();
                int zydexLocId2 = employeeMaster1.getZydexLocationMaster().getId();
                if (zydexLocId == zydexLocId2) {
                    flexible = true;
                    earlyMinute = Integer.parseInt(timeAttandanceFlaxibleMaster.getEarlyFlexibleTime());
                    lateMinute = Integer.parseInt(timeAttandanceFlaxibleMaster.getLateFlexibleTime());
                    break;
                }
            }
        }
        SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");
        List newList = new ArrayList();
        List secondHalfList = new ArrayList();
        List workingHour = new ArrayList();
        for (Map.Entry<Integer, List<?>> entry : map.entrySet()) {
            Iterator itr5 = entry.getValue().iterator();
            while (itr5.hasNext()) {
                try {
                    Object[] next = (Object[]) itr5.next();
                    String firstHalf = "" + next[1];

                    Date date = sdf.parse("" + next[0]);
                    Calendar c = Calendar.getInstance();
                    //                    c.setTime(date);
                    // week off code start
                    Calendar c1 = Calendar.getInstance();
                    c1.setTime(date);
                    if (firstHalf.contains("WO")) {
                        LeaveEmployeeDetail leaveEmployeeDetail = new LeaveEmployeeDetail();
                        c1.add(Calendar.DATE, -1);
                        SimpleDateFormat format = new SimpleDateFormat("EEEE");
                        String dayName = format.format(c1.getTime());
                        int dayOfWeek = c1.get(Calendar.WEEK_OF_MONTH);
                        if (dayName.equals("Saturday") && dayOfWeek != 2) {
                            SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy");
                            leaveEmployeeDetail.setStartDate("" + sdf3.format(c1.getTime()));
                            leaveEmployeeDetail.setEndDate("" + sdf3.format(c1.getTime()));
                            leaveEmployeeDetail.setEmployeeMaster(employeeMaster1);
                            leaveEmployeeDetail.setStatus(3);
                            List firstLeaveEmployeeDetail = leaveEmployeeDetailService.readLeaveDetails(leaveEmployeeDetail);
                            if (!firstLeaveEmployeeDetail.isEmpty()) {
                                c1.add(Calendar.DATE, 2);
                                leaveEmployeeDetail.setStartDate("" + sdf3.format(c1.getTime()));
                                leaveEmployeeDetail.setEndDate("" + sdf3.format(c1.getTime()));
                                leaveEmployeeDetail.setEmployeeMaster(employeeMaster1);
                                leaveEmployeeDetail.setStatus(3);
                                List secondLeaveEmployeeDetail = leaveEmployeeDetailService.readLeaveDetails(leaveEmployeeDetail);

                                // saturday sandwich Leave code start
                                Object[] oSatArray = (Object[]) firstLeaveEmployeeDetail.get(0);
                                String woSatType = "" + oSatArray[0];
                                Date sSatDate = sdf.parse("" + oSatArray[1]);
                                Date eSatDate = sdf.parse("" + oSatArray[2]);
                                String sSatDateStr = "" + oSatArray[6];
                                String eSatDateStr = "" + oSatArray[7];
                                float noOfSatDays = (float) oSatArray[3];
                                float diffInSatDays = 0;
                                if ((sSatDateStr.equals("Fullday") && eSatDateStr.equals("Fullday"))
                                        || (sSatDateStr.equals("Fullday") && sSatDate.equals(eSatDate))) {
                                    diffInSatDays = (float) ((eSatDate.getTime() - sSatDate.getTime())
                                            / (1000 * 60 * 60 * 24)) + 1;
                                } else if ((sSatDateStr.equals("SecondHalf") && eSatDateStr.equals("Fullday"))
                                        || (sSatDateStr.equals("Fullday") && eSatDateStr.equals("FirstHalf"))) {
                                    diffInSatDays = (float) ((eSatDate.getTime() - sSatDate.getTime())
                                            / (1000 * 60 * 60 * 24)) + 1;
                                    diffInSatDays = diffInSatDays - (float) 0.5;
                                } else if (sSatDateStr.equals("SecondHalf") && eSatDateStr.equals("FirstHalf")) {
                                    diffInSatDays = (float) ((eSatDate.getTime() - sSatDate.getTime())
                                            / (1000 * 60 * 60 * 24)) + 1;
                                    diffInSatDays = diffInSatDays - 1;
                                }
                                // saturday sandwich Leave code End

                                // Monday sandwich Leave code start
                                float noOfMonDays = 0;
                                float diffInMonDays = -1;
                                String woMonType = "";
                                if (!secondLeaveEmployeeDetail.isEmpty()) {
                                    Object[] oMonArray = (Object[]) secondLeaveEmployeeDetail.get(0);
                                    woMonType = "" + oMonArray[0];
                                    Date sMonDate = sdf.parse("" + oMonArray[1]);
                                    Date eMonDate = sdf.parse("" + oMonArray[2]);
                                    String sMonDateStr = "" + oMonArray[6];
                                    String eMonDateStr = "" + oMonArray[7];
                                    noOfMonDays = (float) oMonArray[3];
                                    if ((sMonDateStr.equals("Fullday") && eMonDateStr.equals("Fullday"))
                                            || (sMonDateStr.equals("Fullday") && sMonDate.equals(eMonDate))) {
                                        diffInMonDays = (float) ((eMonDate.getTime() - sMonDate.getTime())
                                                / (1000 * 60 * 60 * 24)) + 1;
                                    } else if ((sMonDateStr.equals("SecondHalf") && eMonDateStr.equals("Fullday"))
                                            || (sMonDateStr.equals("Fullday") && eMonDateStr.equals("FirstHalf"))) {
                                        diffInMonDays = (float) ((eMonDate.getTime() - sMonDate.getTime())
                                                / (1000 * 60 * 60 * 24)) + 1;
                                        diffInMonDays = diffInMonDays - (float) 0.5;
                                    } else if (sMonDateStr.equals("SecondHalf") && eMonDateStr.equals("FirstHalf")) {
                                        diffInMonDays = (float) ((eMonDate.getTime() - sMonDate.getTime())
                                                / (1000 * 60 * 60 * 24)) + 1;
                                        diffInMonDays = diffInMonDays - 1;
                                    }
                                }
                                // Monday sandwich Leave code end

//                            if (diffInSatDays != noOfSatDays || (!date.equals(sSatDate) && !date.equals(eSatDate))) {
                                if (diffInSatDays != noOfSatDays || (date.before(eSatDate)
                                        && date.after(sSatDate) && diffInSatDays == noOfSatDays)) {
                                    woMap.put("" + next[0], woSatType);
                                } else if (diffInMonDays != -1 && diffInMonDays != noOfMonDays) {
                                    woMap.put("" + next[0], woMonType);
                                } else if ((diffInSatDays % 1 == 0 && diffInSatDays == noOfSatDays) && diffInMonDays == noOfMonDays) {
                                    woMap.put("" + next[0], "LWP");
                                } else {
                                    woMap.put("" + next[0], "WO");
                                }
                            } else {
                                woMap.put("" + next[0], "WO");
                            }
                        } else {
                            woMap.put("" + next[0], "WO");
                        }
                    }
                    // week off code End

//         1st Half:             Half day absent Code when start date is full and end date is first half start Code
                    Date date1 = sdf.parse("" + next[0]);
                    Calendar c2 = Calendar.getInstance();
                    c2.setTime(date1);
                    LeaveEmployeeDetail leaveEmployeeDetail = new LeaveEmployeeDetail();
                    SimpleDateFormat sdfAb = new SimpleDateFormat("dd/MM/yyyy");
                    leaveEmployeeDetail.setStartDate("" + sdfAb.format(c2.getTime()));
                    leaveEmployeeDetail.setEndDate("" + sdfAb.format(c2.getTime()));
                    leaveEmployeeDetail.setEmployeeMaster(employeeMaster1);
                    leaveEmployeeDetail.setStatus(3);
                    List absentEmployeeDetail = leaveEmployeeDetailService.readLeaveDetails(leaveEmployeeDetail);
                    float diffInDays = 0;
                    String woType = "";
                    if (!absentEmployeeDetail.isEmpty()) {
                        Object[] oSatArray = (Object[]) absentEmployeeDetail.get(0);
                        woType = "" + oSatArray[0];
                        Date sDate = sdf.parse("" + oSatArray[1]);
                        Date eDate = sdf.parse("" + oSatArray[2]);
                        String sDateStr = "" + oSatArray[6];
                        String eDateStr = "" + oSatArray[7];
                        float noOfDays = (float) oSatArray[3];
                        if ((sDateStr.equals("Fullday") && eDateStr.equals("FirstHalf"))) {
                            diffInDays = (float) ((eDate.getTime() - sDate.getTime())
                                    / (1000 * 60 * 60 * 24)) + 1;
                            if (date1.equals(eDate)) {
                                diffInDays = diffInDays - (float) 0.5;
                            }
                        }
                    }
//        1st Half:              Half day absent Code when start date is full and end date is first half  End code

                    int dayOfWeek = c.get(Calendar.WEEK_OF_MONTH);
                    SimpleDateFormat format = new SimpleDateFormat("EEEE");
                    String dayName = format.format(date);

                    
                    
                     List alllistPunch = employeeDatetimeDataService.readAllPuchDataDateWise("" + next[0], Integer.parseInt(id));
                            int listLen = alllistPunch.size();
                            boolean isMisPunch;
                            if(listLen % 2 == 0)
                                isMisPunch = false;
                            else
                                isMisPunch = true;
                            
                                boolean inBool = true;
                                boolean outBool = false;
                                String inTime1 = null;
                                String outTime1= null;
                                SimpleDateFormat format1 = new SimpleDateFormat("HH:mm:ss");  
                              
                                Date d1 = null;
                                Date d2 = null;
                                String []inTime1val;
                                String []outTime1val;
                                String outTime1val1;
                                String inTime1val1;
                                long timecount = 0;
                                int cnt =0;
                            for (Object o : alllistPunch) {
                                EmployeeDatetimeData employeeDatetimeData = (EmployeeDatetimeData) o;
                                cnt++;
                                if(isMisPunch && (listLen == cnt)){
                                    break;
                                }else if(inBool){
                                    inTime1 = employeeDatetimeData.getDateTime();                                    
                                    inTime1val = inTime1.split(" ");
                                    inTime1val1 = inTime1val[1];
                                    try {
                                        d1 = format1.parse(inTime1val1);
//                                        d2 = format.parse(dateStop);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }    
                                    inBool = false;
                                    outBool = true;
                                } else if(outBool){
                                    outTime1 = employeeDatetimeData.getDateTime();
                                    outTime1val = outTime1.split(" ");
                                    outTime1val1 = outTime1val[1];
                                    inBool = true;
                                    outBool = false;
                                     try {
                                        d2 = format1.parse(outTime1val1);
//                                        d2 = format.parse(dateStop);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }    
                                    long difff = d2.getTime() - d1.getTime();        
                                    long diffMinutes = difff / (60 * 1000);  
                                    timecount += diffMinutes;
                                    
                                }
                            }
                    if (firstHalf.contains("fullday")) {
                       
                            if(timecount > 270){
                                newList.add("PR");
                            }else{
                                newList.add("AB");
                            }
                        
                    } else if (!firstHalf.contains("fullday") && !firstHalf.equals("WO") && !firstHalf.equals("TR") && !firstHalf.equals("AR") && !firstHalf.equals("AB") && !firstHalf.contains("?")
                            && !firstHalf.equals("Casual Leave") && !firstHalf.equals("Short Leave") && !firstHalf.equals("C Off Leave") && !firstHalf.equals("Privilege Leave") && !firstHalf.equals("Sick Leave")
                            && !firstHalf.equals("Paternity Leave") && !firstHalf.equals("Maternity Leave") && !firstHalf.equals("Leave Without Pay")) {
                        String[] userTimeInStr = firstHalf.split("`");
                        String[] userTimeInStr1 = userTimeInStr[1].split("!");
                        String[] userTimeOutStr = firstHalf.split("!");
                        String[] userTimeOutStr1 = userTimeOutStr[1].split("@");
                        String[] leave = firstHalf.split("@");
                        String[] leave1 = leave[1].split("#");
                        String[] LateHoursStr = firstHalf.split("\\$");
                        String[] LateHoursStr1 = LateHoursStr[1].split("%");
                        String[] endHoursStr = firstHalf.split("%");
                        String[] endHoursStr1 = endHoursStr[1].split("\\^");
                        String[] firstStartHoursStr = endHoursStr[1].split("\\+");
                        Date userTimeIn = sdf2.parse(userTimeInStr1[0]);
                        Date userTimeOut = sdf2.parse(userTimeOutStr1[0]);
                        Date endHours = sdf2.parse(endHoursStr1[0]);
                        Date firstStartHours = sdf2.parse(firstStartHoursStr[1]);
                        Calendar cal = Calendar.getInstance();
                        Calendar cal1 = Calendar.getInstance();
                        cal.setTime(firstStartHours);
                        cal1.setTime(firstStartHours);
                        cal1.add(Calendar.MINUTE, -earlyMinute);
                        cal.add(Calendar.MINUTE, lateMinute);
                        String newTime = sdf2.format(cal.getTime());
                        Date flexibleEndTime = sdf2.parse(newTime);
                        Date LateHours = sdf2.parse(LateHoursStr1[0]);
                        String newTime1 = sdf2.format(cal1.getTime());
                        Date flexibleStartTime = sdf2.parse(newTime1);
                        long diff = endHours.getTime() - firstStartHours.getTime();
                        long diffMinutes = diff / (60 * 1000);
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        long diff1 = 0;
                        if (userTimeIn.after(flexibleStartTime) || userTimeIn.equals(flexibleStartTime)) {
                            diff1 = endHours.getTime() - userTimeIn.getTime();
                        } else {
                            diff1 = endHours.getTime() - flexibleStartTime.getTime();
                        }
                        long diffMinutes1 = diff1 / (60 * 1000);
                        if (dayName.equals("Saturday") && dayOfWeek == 2 && diffMinutes1 >= 240) {
                            newList.add("PR");
                        } else if (timecount < 270) {
                            newList.add("AB");
                        }
                        else if (diffMinutes1 >= diffMinutes) {
                            newList.add("PR");
                        } else if (userTimeIn != null) {
                            if ((userTimeIn.before(flexibleEndTime) || userTimeIn.equals(flexibleEndTime)) && (userTimeOut.after(endHours) || userTimeOut.equals(endHours))) {
                                newList.add("PR");
                            } else if (userTimeOut.before(userTimeIn)) {
                                newList.add("PR");
                            } else if (leave1[0] != null && !leave1[0].contains("Short Leave")) {
                                if ((userTimeIn.before(flexibleEndTime) || userTimeIn.equals(flexibleEndTime)) && (userTimeOut.after(endHours) || userTimeOut.equals(endHours))) {
                                    newList.add("PR");
                                } else if (leave1[0].contains("AB")) {
                                    newList.add("AB");
                                } else if (leave1[0].contains("AR")) {
                                    newList.add("AR/P");
                                } else {
                                    if (leave1[0].contains("Casual Leave")) {
                                        newList.add("Casual Leave");
                                    }
                                    if (leave1[0].contains("Privilege Leave")) {
                                        newList.add("Privilege Leave");
                                    }
                                    if (leave1[0].contains("Sick Leave")) {
                                        newList.add("Sick Leave");
                                    }
                                    if (leave1[0].contains("Maternity Leave")) {
                                        newList.add("Maternity Leave");
                                    }
                                    if (leave1[0].contains("Paternity Leave")) {
                                        newList.add("Paternity Leave");
                                    }
                                    if (leave1[0].contains("C Off Leave")) {
                                        newList.add("C Off Leave");
                                    }
                                    if (leave1[0].contains("Leave Without Pay")) {
                                        newList.add("Leave Without Pay");
                                    }
                                }

                            } else if (null != leave1[0] && leave1[0].contains("Short Leave")) {
                                if (firstHalf.contains("*")) {
                                    String[] shortArray = firstHalf.split("\\*");
                                    String[] endArray = shortArray[1].split("\\-");
                                    String[] startTime = endArray[1].split("\\+");
                                    Date shortIn = sdf2.parse(shortArray[1]);
                                    Date shortend = sdf2.parse(endArray[1]);
                                    Date startTime1 = sdf2.parse(startTime[1]);
                                    if (shortIn.before(endHours)) {
                                        newList.add("SHL/P");
                                    } else if (leave1[0].contains("~ AR")) {
                                        newList.add("AR/P");
                                    } else if (userTimeIn.after(endHours)) {
                                        newList.add("SHL/A");
                                    } else if ((userTimeIn.before(flexibleEndTime) || userTimeIn.equals(flexibleEndTime)) && (userTimeOut.after(endHours) || userTimeOut.equals(endHours))) {
                                        newList.add("PR");
                                    } else {
                                        newList.add("AB");
                                    }
                                } else {
                                    newList.add("AB");
                                }
                            } else if (null != leave1[0] && !leave1[0].contains("AB")) {
                                if (leave1[0].contains("Casual Leave")) {
                                    newList.add("Casual Leave");
                                }
                                if (leave1[0].contains("Privilege Leave")) {
                                    newList.add("Privilege Leave");
                                }
                                if (leave1[0].contains("Sick Leave")) {
                                    newList.add("Sick Leave");
                                }
                                if (leave1[0].contains("Maternity Leave")) {
                                    newList.add("Maternity Leave");
                                }
                                if (leave1[0].contains("Paternity Leave")) {
                                    newList.add("Paternity Leave");
                                }
                                if (leave1[0].contains("C Off Leave")) {
                                    newList.add("C Off Leave");
                                }
                                if (leave1[0].contains("Leave Without Pay")) {
                                    newList.add("Leave Without Pay");
                                }

                            } else if (leave1[0].contains("AB")) {
                                newList.add("-");

                            } else {
                                newList.add("AB");
                            }

                        } else if (userTimeIn != null && !firstHalf.contains("WO") && !firstHalf.contains("?")) {
                            newList.add("AB");
                        } else if (firstHalf.contains("WO") || firstHalf.contains("?")) {
                            newList.add("-");
                        }

                    } else if (firstHalf.equals("WO")) {
                        newList.add("-");
                    } else if (firstHalf.contains("AR")) {
                        newList.add("AR/P");
                    } else if (firstHalf.equals("AB")) {
                        newList.add("AB");
                    } else if (firstHalf.contains("?")) {
                        newList.add("-");
                    } else if (firstHalf.equals("Casual Leave") || firstHalf.equals("Privilege Leave") || firstHalf.equals("Sick Leave")
                            || firstHalf.equals("Maternity Leave") || firstHalf.equals("Paternity Leave") || firstHalf.equals("C Off Leave")
                            || firstHalf.equals("Leave Without Pay")) {
//       1st Half:                 Half day absent Code  start date is full and end date is First Half start code
                        if (diffInDays % 1 == 0) {
                            newList.add("-");
                        } else {
                            newList.add(firstHalf);
                            halfDayMap.put("" + next[0], woType);
                        }
//       1st Half:                 Half day absent Code  start date is full and end date is First Half End code
//                            newList.add("-");
                    }
                } catch (Exception e) {

                }
            }

            Iterator itr6 = entry.getValue().iterator();
            int weekNameCounter = 0;
            boolean satWeekOff = false;
            while (itr6.hasNext()) {
                try {
                    Object[] next = (Object[]) itr6.next();

                    String secondHalf = "" + next[1];
                    int firstHalfVal = 0;

//       2nd Half:              Half day absent Code when start date is full and end date is first half  start Code
                    Date date1 = sdf.parse("" + next[0]);
                    Calendar c1 = Calendar.getInstance();
                    c1.setTime(date1);
                    LeaveEmployeeDetail leaveEmployeeDetail = new LeaveEmployeeDetail();
                    SimpleDateFormat sdfAb = new SimpleDateFormat("dd/MM/yyyy");
                    leaveEmployeeDetail.setStartDate("" + sdfAb.format(c1.getTime()));
                    leaveEmployeeDetail.setEndDate("" + sdfAb.format(c1.getTime()));
                    leaveEmployeeDetail.setEmployeeMaster(employeeMaster1);
                    leaveEmployeeDetail.setStatus(3);
                    List absentEmployeeDetail = leaveEmployeeDetailService.readLeaveDetails(leaveEmployeeDetail);
                    float diffInDays = 0;
                    String woType = "";
                    if (!absentEmployeeDetail.isEmpty()) {
                        Object[] oSatArray = (Object[]) absentEmployeeDetail.get(0);
                        woType = "" + oSatArray[0];
                        Date sDate = sdf.parse("" + oSatArray[1]);
                        Date eDate = sdf.parse("" + oSatArray[2]);
                        String sDateStr = "" + oSatArray[6];
                        String eDateStr = "" + oSatArray[7];
                        float noOfDays = (float) oSatArray[3];
                        if ((sDateStr.equals("Fullday") && eDateStr.equals("FirstHalf"))) {
                            diffInDays = (float) ((eDate.getTime() - sDate.getTime())
                                    / (1000 * 60 * 60 * 24)) + 1;
                            if (date1.equals(eDate)) {
                                diffInDays = diffInDays - (float) 0.5;
                            }
                        }
                    }
//       2nd Half:              Half day absent Code when start date is full and end date is first half  end Code
                    int counter = 0;
                    String shiftName = "";
//                                    2nd Sat Week Off Codding
                    Calendar cal = Calendar.getInstance();
                    Date date = sdf.parse("" + next[0]);
                    cal.setTime(date);
                    SimpleDateFormat format = new SimpleDateFormat("EEEE");
                    String dayName = format.format(date);
                    int dayOfWeek = cal.get(Calendar.WEEK_OF_MONTH);
//                    EmployeeMaster employeeMaster1 = employeeMasterService.readById(Integer.parseInt(id));
                    ZydexLocationMaster zydexLocationMaster = zydexLocationMasterService.readById(employeeMaster1.getZydexLocationMaster().getId());

                    if (dayName.equals("Saturday")) {
                        if (dayOfWeek == 2) {
                            satWeekOff = true;
                            satMap.put("" + next[0], "AB");
                        } else {
                            satWeekOff = false;
                        }

                    } else {
                        satWeekOff = false;
                    }
//                                    2nd Sat Week Off Codding

//                                    Lunch Breck Cut Off
                    List listPunch = employeeDatetimeDataService.readPuchDataDateWise("" + next[0], Integer.parseInt(id));
                    long lunchTime = 0;
                    long totalDayTime = 0;
                    long totalDayTime1 = 0;
                    long totalTime = 0;
                    long shiftdiffMinutes = 0;
                    String startTime = "";
                    String endTime = "";
                    SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                    long outTime = 0;
                    int d = 1;
                    int s = 2;
                    boolean checkLunchTime = false;
                    try {
                        if (zydexLocationMaster.getId() == 1 || zydexLocationMaster.getId() == 6) {
                            if (listPunch.size() > 2) {
                                while (listPunch.size() > d && listPunch.size() > s) {
                                    Object[] startLunchTime = (Object[]) listPunch.get(d);
                                    Object[] endLunchTime = (Object[]) listPunch.get(s);
                                    startTime = (String) startLunchTime[0];
                                    endTime = (String) endLunchTime[0];
                                    Date launchStrTime = sdf3.parse(startTime);
                                    Date launchEndTime = sdf3.parse(endTime);
                                    long diff = launchEndTime.getTime() - launchStrTime.getTime();
                                    lunchTime = diff / (60 * 1000);
                                    outTime = outTime + lunchTime;
                                    d = d + 2;
                                    s = s + 2;
                                }
                                String[] userTimeInStr = secondHalf.split("`");
                                String[] userTimeInStr1 = userTimeInStr[1].split("!");
                                String[] userTimeOutStr = secondHalf.split("!");
                                String[] userTimeOutStr1 = userTimeOutStr[1].split("@");
                                Date userTimeIn = sdf2.parse(userTimeInStr1[0]);
                                Date userTimeOut = sdf2.parse(userTimeOutStr1[0]);
                                String[] startHoursStr = secondHalf.split("%");
                                String[] firstStartHoursStr = startHoursStr[1].split("\\+");
                                String[] endHoursStr = secondHalf.split("&");
                                Date firstStartHours = sdf2.parse(firstStartHoursStr[1]);
                                Calendar cal1 = Calendar.getInstance();
                                cal1.setTime(firstStartHours);
                                cal1.add(Calendar.MINUTE, -earlyMinute);

                                String newTime1 = sdf2.format(cal1.getTime());
                                Date flexibleInTime = sdf2.parse(newTime1);
                                Date endHours = sdf2.parse(endHoursStr[1]);
                                long shiftTotalTime = endHours.getTime() - firstStartHours.getTime();
                                shiftdiffMinutes = shiftTotalTime / (60 * 1000);
                                long diff1 = 0;
                                long diff2 = 0;
                                if (userTimeIn.after(flexibleInTime) || userTimeIn.equals(flexibleInTime)) {
                                    diff1 = userTimeOut.getTime() - userTimeIn.getTime();

                                } else {
                                    diff1 = userTimeOut.getTime() - flexibleInTime.getTime();
                                }
                                totalDayTime = diff1 / (60 * 1000);

                                diff2 = userTimeOut.getTime() - userTimeIn.getTime();
                                totalDayTime1 = diff2 / (60 * 1000);

//                                        ===============30 minute lunch time 4 all employeee so who goes out side cut 30 min from their lunch time===============
//                                        =========================For who goes out side 4 lunch they have max 60 min time for lunch=======================
//                                        =========================For who goes out side 4 lunch they have max 60 min time for lunch=======================
                                long outTime1 = outTime;
                                outTime = outTime - 30;
//                                        ===============30 minute lunch time 4 all employeee so who goes out side cut 30 min from their lunch time===============
                                if (outTime1 == totalDayTime1) {
                                    totalTime = totalDayTime;
                                } else if (outTime > 0) {
                                    totalTime = totalDayTime - outTime;
                                    checkLunchTime = true;
                                }

                            }
                        } else {
//                            if (listPunch.size() > 2) {
//                                    Object[] startTimeO = (Object[]) listPunch.get(0);
//                                    Object[] endTimeO = (Object[]) listPunch.get(listPunch.size()-1);
//                                    startTime = (String) startTimeO[0];
//                                    endTime = (String) endTimeO[0];

                            String[] userTimeInStr = secondHalf.split("`");
                            String[] userTimeInStr1 = userTimeInStr[1].split("!");
                            String[] userTimeOutStr = secondHalf.split("!");
                            String[] userTimeOutStr1 = userTimeOutStr[1].split("@");
                            Date userTimeIn = sdf2.parse(userTimeInStr1[0]);
                            Date userTimeOut = sdf2.parse(userTimeOutStr1[0]);
                            String[] startHoursStr = secondHalf.split("%");
                            String[] firstStartHoursStr = startHoursStr[1].split("\\+");
                            String[] endHoursStr = secondHalf.split("&");
                            Date firstStartHours = sdf2.parse(firstStartHoursStr[1]);
                            Calendar cal1 = Calendar.getInstance();
                            cal1.setTime(firstStartHours);
                            cal1.add(Calendar.MINUTE, -earlyMinute);

                            String newTime1 = sdf2.format(cal1.getTime());
                            Date flexibleInTime = sdf2.parse(newTime1);
                            Date endHours = sdf2.parse(endHoursStr[1]);
                            long shiftTotalTime = endHours.getTime() - firstStartHours.getTime();
                            shiftdiffMinutes = shiftTotalTime / (60 * 1000);
                            long diff1 = 0;
                            long diff2 = 0;
                            if (userTimeIn.after(flexibleInTime) || userTimeIn.equals(flexibleInTime)) {
                                diff1 = userTimeOut.getTime() - userTimeIn.getTime();

                            } else {
                                diff1 = userTimeOut.getTime() - flexibleInTime.getTime();
                            }
                            totalDayTime = diff1 / (60 * 1000);

                            diff2 = userTimeOut.getTime() - userTimeIn.getTime();
                            totalDayTime1 = diff2 / (60 * 1000);
                            totalTime = totalDayTime;
//                            }

                        }

                    } catch (Exception e) {

                    }

//                                    Lunch Breck Cut Off
                    if (secondHalf.contains(" # ")) {
                        String[] string1 = secondHalf.split("#");
                        String[] string2 = string1[1].split("\\$");
                        shiftName = string2[0].trim();

                    }
                    if (satWeekOff == true && (zydexLocationMaster.getZydexLocation().equals("HO") || zydexLocationMaster.getZydexLocation().equals("R&D"))) {
                        secondHalfList.add("WO");
                    } else if (secondHalf.equals("AR")) {
                        secondHalfList.add("AR/P");
                    } else if (checkLunchTime == true && totalTime < shiftdiffMinutes && !secondHalf.contains("AR") && !secondHalf.contains("Short Leave")) {
                        secondHalfList.add("AB");
                    } else if (secondHalf.contains("fullday")) {
                        
                         List alllistPunch = employeeDatetimeDataService.readAllPuchDataDateWise("" + next[0], Integer.parseInt(id));
                            int listLen = alllistPunch.size();
                            boolean isMisPunch;
                            if(listLen % 2 == 0)
                                isMisPunch = false;
                            else
                                isMisPunch = true;
                            
                                boolean inBool = true;
                                boolean outBool = false;
                                String inTime1 = null;
                                String outTime1= null;
                                SimpleDateFormat format1 = new SimpleDateFormat("HH:mm:ss");  
                              
                                Date d1 = null;
                                Date d2 = null;
                                String []inTime1val;
                                String []outTime1val;
                                String outTime1val1;
                                String inTime1val1;
                                long timecount = 0;
                                int cnt =0;
                            for (Object o : alllistPunch) {
                                EmployeeDatetimeData employeeDatetimeData = (EmployeeDatetimeData) o;
                                cnt++;
                                if(isMisPunch && (listLen == cnt)){
                                    break;
                                }else if(inBool){
                                    inTime1 = employeeDatetimeData.getDateTime();                                    
                                    inTime1val = inTime1.split(" ");
                                    inTime1val1 = inTime1val[1];
                                    try {
                                        d1 = format1.parse(inTime1val1);
//                                        d2 = format.parse(dateStop);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }    
                                    inBool = false;
                                    outBool = true;
                                } else if(outBool){
                                    outTime1 = employeeDatetimeData.getDateTime();
                                    outTime1val = outTime1.split(" ");
                                    outTime1val1 = outTime1val[1];
                                    inBool = true;
                                    outBool = false;
                                     try {
                                        d2 = format1.parse(outTime1val1);
//                                        d2 = format.parse(dateStop);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }    
                                    long difff = d2.getTime() - d1.getTime();        
                                    long diffMinutes = difff / (60 * 1000);  
                                    timecount += diffMinutes;
                                    
                                }
                            }
                            if(timecount > 270 && timecount >= 540){
                                secondHalfList.add("PR");
                            }else{
                                secondHalfList.add("AB");
                            }
                        
                        
                        
                        

                    } else if (!secondHalf.contains("fullday") && !secondHalf.equals("WO") && !secondHalf.equals("TR") && !secondHalf.equals("AR") && !secondHalf.equals("AB") && !secondHalf.contains("?")
                            && !secondHalf.equals("Casual Leave") && !secondHalf.equals("Short Leave") && !secondHalf.equals("C Off Leave") && !secondHalf.equals("Privilege Leave") && !secondHalf.equals("Sick Leave")
                            && !secondHalf.equals("Paternity Leave") && !secondHalf.equals("Maternity Leave") && !secondHalf.equals("Leave Without Pay")) {
                        String[] leave = secondHalf.split("@");
                        String[] leave1 = leave[1].split("#");
                        String[] userTimeInStr = secondHalf.split("`");
                        String[] userTimeInStr1 = userTimeInStr[1].split("!");
                        String[] userTimeOutStr = secondHalf.split("!");
                        String[] userTimeOutStr1 = userTimeOutStr[1].split("@");
                        String[] secondHalfTimeStr = secondHalf.split("\\^");
                        String[] secondHalfTimeStr1 = secondHalfTimeStr[1].split("&");
                        String[] endHoursStr = secondHalf.split("&");
                        String[] startHoursStr = secondHalf.split("%");
                        String[] firstStartHoursStr = startHoursStr[1].split("\\+");

                        Date userTimeIn = sdf2.parse(userTimeInStr1[0]);
                        Date userTimeOut = sdf2.parse(userTimeOutStr1[0]);
                        Date userTimeOut1 = sdf2.parse("23:59");
                        Date firstStartHours = sdf2.parse(firstStartHoursStr[1]);
                        String[] getInHours = userTimeInStr1[0].split(":");
                        String[] getOutHours = userTimeOutStr1[0].split(":");
                        String abc = getInHours[0].trim();
                        String xyz = getOutHours[0].trim();
                        int i11 = Integer.parseInt(abc) - Integer.parseInt(xyz);
                        int totalDuration = 24 - i11;
                        String totalDuration2 = getOutHours[0];
                        Date endHours = sdf2.parse(endHoursStr[1]);
                        Date secondHalfTimeStr2 = sdf2.parse(secondHalfTimeStr1[0]);

                        Calendar cal1 = Calendar.getInstance();
                        Calendar cal2 = Calendar.getInstance();
                        cal1.setTime(firstStartHours);
                        cal1.add(Calendar.MINUTE, -earlyMinute);
                        cal2.setTime(firstStartHours);
                        cal2.add(Calendar.MINUTE, lateMinute);
                        String newTime = sdf2.format(cal2.getTime());
                        Date flexibleEndTime = sdf2.parse(newTime);

                        String newTime1 = sdf2.format(cal1.getTime());
                        Date flexibleInTime = sdf2.parse(newTime1);
                        long diff = endHours.getTime() - firstStartHours.getTime();
                        long diffMinutes = diff / (60 * 1000);
                        long diff1 = 0;
                        if (userTimeIn.after(flexibleInTime) || userTimeIn.equals(flexibleInTime)) {
                            if (userTimeOut.before(userTimeIn)) {
                                diff1 = userTimeOut1.getTime() - userTimeIn.getTime();
                            } else {
                                diff1 = userTimeOut.getTime() - userTimeIn.getTime();
                            }

                        } else if (userTimeOut.before(userTimeIn)) {
                            diff1 = userTimeOut1.getTime() - flexibleInTime.getTime();
                        } else {
                            diff1 = userTimeOut.getTime() - flexibleInTime.getTime();
                        }
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        long diffMinutes1 = diff1 / (60 * 1000);

                        if (userTimeIn != null) {
                            if (leave1[0].contains("AR")) {
                                secondHalfList.add("AR/P");

                            } else if (null != leave1[0] && leave1[0].contains("Short Leave")) {
                                if (secondHalf.contains("*")) {
                                    String[] shortArray = secondHalf.split("\\*");
                                    String[] endArray = secondHalf.split("\\^");
                                    String[] secondhalfstartTime = endArray[1].split("&");
                                    Date shortIn = sdf2.parse(shortArray[1]);
                                    Date shortend = sdf2.parse(endArray[1]);
                                    Date secondhalfstartTime1 = sdf2.parse(secondhalfstartTime[0]);
                                    if ((secondhalfstartTime1.before(shortIn) || secondhalfstartTime1.equals(shortIn)) && (shortIn.before(endHours) || shortIn.equals(endHours))) {
                                        if (userTimeOut.after(secondHalfTimeStr2)) {
                                            secondHalfList.add("SHL/P");
                                        } else if (leave1[0].contains("~ AR")) {
                                            secondHalfList.add("AR/P");
                                        } else if (userTimeOut.before(secondHalfTimeStr2) || userTimeOut.equals(secondHalfTimeStr2)) {
                                            secondHalfList.add("SHL/A");
                                        } else {
                                            secondHalfList.add("AB");
                                        }
                                    } else if (diffMinutes1 >= 240 && userTimeIn.before(secondHalfTimeStr2)) {
                                        secondHalfList.add("PR");
                                    }
                                } else if (diffMinutes1 >= 240 && userTimeIn.before(secondHalfTimeStr2)) {
                                    secondHalfList.add("PR");
                                } else {
                                    secondHalfList.add("AB");
                                }
                            } else if (diffMinutes1 >= diffMinutes && userTimeIn.before(flexibleEndTime)) {
                                secondHalfList.add("PR");
                            } else if (diffMinutes1 <= diffMinutes && userTimeIn.before(flexibleEndTime) && !secondHalf.contains("WO") && !secondHalf.contains("TR") && !secondHalf.contains("AR") && !secondHalf.contains("?")
                                    && !secondHalf.contains("Casual Leave") && !secondHalf.contains("Short Leave") && !secondHalf.equals("C Off Leave") && !secondHalf.contains("Privilege Leave") && !secondHalf.contains("Sick Leave")
                                    && !secondHalf.contains("Paternity Leave") && !secondHalf.contains("Maternity Leave") && !secondHalf.contains("Leave Without Pay")) {
                                secondHalfList.add("AB");
                            } else if (diffMinutes1 >= 240 && userTimeIn.after(secondHalfTimeStr2)) {
                                secondHalfList.add("PR");
                            } else if ((userTimeIn.before(secondHalfTimeStr2) || userTimeIn.equals(secondHalfTimeStr2)) && (userTimeOut.after(endHours) || userTimeOut.equals(endHours))) {
                                secondHalfList.add("PR");
                            } else if (shiftName.contains("Night") && (userTimeOut.after(endHours) || userTimeOut.equals(endHours))) {
                                secondHalfList.add("PR");
                            } else if (null != leave1[0] && !leave1[0].contains("AB") && !leave1[0].contains("AR")) {
                                if (leave1[0].contains("Casual Leave")) {
                                    secondHalfList.add("Casual Leave");
                                }
                                if (leave1[0].contains("Privilege Leave")) {
                                    secondHalfList.add("Privilege Leave");
                                }
                                if (leave1[0].contains("Sick Leave")) {
                                    secondHalfList.add("Sick Leave");
                                }
                                if (leave1[0].contains("Maternity Leave")) {
                                    secondHalfList.add("Maternity Leave");
                                }
                                if (leave1[0].contains("Paternity Leave")) {
                                    secondHalfList.add("Paternity Leave");
                                }
                                if (leave1[0].contains("C Off Leave")) {
                                    secondHalfList.add("C Off Leave");
                                }
                                if (leave1[0].contains("Leave Without Pay")) {
                                    secondHalfList.add("Leave Without Pay");
                                }

                            } else if (leave1[0].contains("AB")) {
                                secondHalfList.add("AB");
                            } else {
                                secondHalfList.add("AB");
                            }

                        } else if (userTimeIn != null && !secondHalf.contains("WO") && !secondHalf.contains("?")) {
                            secondHalfList.add("AB");
                        } else if (secondHalf.contains("WO") || secondHalf.contains("?")) {
                            secondHalfList.add("-");
                        }

                    } else if (secondHalf.equals("WO")) {
                        secondHalfList.add("-");
                    } else if (secondHalf.equals("AB")) {
                        secondHalfList.add("AB");
                    } else if (secondHalf.contains("?")) {
                        secondHalfList.add("-");
                    } else if (secondHalf.equals("Casual Leave") || secondHalf.equals("Privilege Leave") || secondHalf.equals("Sick Leave")
                            || secondHalf.equals("Maternity Leave") || secondHalf.equals("Paternity Leave") || secondHalf.equals("C Off Leave")
                            || secondHalf.equals("Leave Without Pay")) {
                        //2nd Half:              Half day absent Code when start date is full and end date is first half  start Code
                        if (diffInDays % 1 == 0) {
                            secondHalfList.add("-");
                        } else {
                            secondHalfList.add("AB");
                        }
// 2nd Half:              Half day absent Code when start date is full and end date is first half  end Code
//                            secondHalfList.add("-");

                    }
                } catch (Exception e) {

                }
            }

            Iterator itr7 = entry.getValue().iterator();
            while (itr7.hasNext()) {
                try {
                    Object[] next = (Object[]) itr7.next();
                    String secondHalf = "" + next[1];
                    int firstHalfVal = 0;
                    int counter = 0;
                    String shiftName = "";

                    List listPunch = employeeDatetimeDataService.readPuchDataDateWise("" + next[0], Integer.parseInt(id));
                    List mobPunchlist = employeePunchForMobileAppService.readPuchDataDateWise("" + next[0], Integer.parseInt(id));
                    long lunchTime = 0;
                    long outTime = 0;
                    long totalDayTime = 0;
                    long totalDayTime1 = 0;
                    long totalTime = 0;
                    long shiftdiffMinutes = 0;
                    boolean checkLunchTime = false;
                    int i = 1;
                    int j = 2;
                    String startTime = "";
                    String endTime = "";
                    SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                    if (listPunch.size() > 0 && !secondHalf.equals("WO") && !secondHalf.equals("AB") && !secondHalf.equals("TR") && !secondHalf.equals("AR")) {
                        ZydexLocationMaster zydexLocationMaster = zydexLocationMasterService.readById(employeeMaster1.getZydexLocationMaster().getId());
                        if (zydexLocationMaster.getId() == 1 || zydexLocationMaster.getId() == 6) {
                            if (listPunch.size() > 2) {
                                while (listPunch.size() > i && listPunch.size() > j) {

                                    Object[] startLunchTime = (Object[]) listPunch.get(i);
                                    Object[] endLunchTime = (Object[]) listPunch.get(j);
                                    startTime = (String) startLunchTime[0];
                                    endTime = (String) endLunchTime[0];
                                    Date launchStrTime = sdf3.parse(startTime);
                                    Date launchEndTime = sdf3.parse(endTime);
                                    long diff = launchEndTime.getTime() - launchStrTime.getTime();
                                    lunchTime = diff / (60 * 1000);
                                    outTime = outTime + lunchTime;
                                    i = i + 2;
                                    j = j + 2;
                                }
                            }
                        }

                        String[] userTimeInStr = secondHalf.split("`");
                        String[] userTimeInStr1 = userTimeInStr[1].split("!");
                        String[] userTimeOutStr = secondHalf.split("!");
                        String[] userTimeOutStr1 = userTimeOutStr[1].split("@");
                        Date userTimeIn = sdf2.parse(userTimeInStr1[0]);
                        Date userTimeOut = sdf2.parse(userTimeOutStr1[0]);

                        Date userTimeOut1 = sdf2.parse("24:00");
                        Date userTimeon12 = sdf2.parse("00:00");
                        String[] startHoursStr = secondHalf.split("%");
                        String[] firstStartHoursStr = startHoursStr[1].split("\\+");
                        String[] endHoursStr = secondHalf.split("&");
                        Date firstStartHours = sdf2.parse(firstStartHoursStr[1]);
                        Calendar cal1 = Calendar.getInstance();
                        cal1.setTime(firstStartHours);
                        cal1.add(Calendar.MINUTE, -earlyMinute);
                        String newTime1 = sdf2.format(cal1.getTime());
                        Date flexibleInTime = sdf2.parse(newTime1);
                        Date endHours = sdf2.parse(endHoursStr[1]);
                        long shiftTotalTime = endHours.getTime() - firstStartHours.getTime();
                        shiftdiffMinutes = shiftTotalTime / (60 * 1000);
                        long diff1 = 0;
                        long diff2 = 0;
                        if (zydexLocationMaster.getId() == 1 || zydexLocationMaster.getId() == 6) {
                            if (userTimeIn.after(flexibleInTime) || userTimeIn.equals(flexibleInTime)) {
                                if (userTimeOut.before(userTimeIn)) {
                                    diff1 = userTimeOut1.getTime() - userTimeIn.getTime();
                                } else {
                                    diff1 = userTimeOut.getTime() - userTimeIn.getTime();
                                }

                            } else if (userTimeOut.before(userTimeIn)) {
                                diff1 = userTimeOut1.getTime() - flexibleInTime.getTime();
                            } else {
                                diff1 = userTimeOut.getTime() - flexibleInTime.getTime();
                            }

                            totalDayTime = diff1 / (60 * 1000);

                            if (userTimeOut.before(userTimeIn)) {
                                diff2 = userTimeOut1.getTime() - userTimeIn.getTime();
                            } else {
                                diff2 = userTimeOut.getTime() - userTimeIn.getTime();
                            }

                            totalDayTime1 = diff2 / (60 * 1000);

//                                        ===============30 minute lunch time 4 all employeee so who goes out side cut 30 min from their lunch time===============
//                                        =========================For who goes out side 4 lunch they have max 60 min time for lunch=======================
//                                        =========================For who goes out side 4 lunch they have max 60 min time for lunch=======================
                            long outTime1 = outTime;
                            outTime = outTime - 30;
//                                        ===============30 minute lunch time 4 all employeee so who goes out side cut 30 min from their lunch time===============
                            ///////////////AR code Start///////////////////////////////////////////////////
                            AttendanceRegularization attendanceRegularization = new AttendanceRegularization();
                            attendanceRegularization.setStartDateTime("" + next[0]);
                            attendanceRegularization.setUserMasterId(employeeMaster1.getUserMaster().getId());
                            long ARdiff = 0;
                            long ARTime = 0;
                            SimpleDateFormat sdf4 = new SimpleDateFormat("dd/mm/yyyy HH:mm");
                            List list = attendanceRegularizationMasterService.readArCountList(attendanceRegularization);
                            if (!list.isEmpty()) {
                                Object[] arm = (Object[]) list.get(0);
                                Date InTimeAR = sdf4.parse(arm[1].toString());
                                Date OutTimeAR = sdf4.parse(arm[2].toString());

                                ARdiff = OutTimeAR.getTime() - InTimeAR.getTime();
                                ARTime = ARdiff / (60 * 1000);

                            }
                            ///////////////AR code End////////////////////////////////////////
                            totalDayTime = totalDayTime + ARTime;
                            if (outTime > 0 && outTime1 != totalDayTime1) {
                                totalTime = totalDayTime - outTime;
                                double empHour = (double) totalTime / 60;
                                int hours = (int) empHour;
                                int minutes = (int) (empHour * 60) % 60;
                                String hour = "" + hours;
                                String minute = "" + minutes;
                                if (minutes < 10 && minutes > 0) {
                                    minute = "0" + minute;
                                } else if (minutes < 0) {
                                    minute = "00";
                                }
                                String workingHours = hour + ":" + minute;
                                workingHour.add(workingHours);

                            } else {
                                double empHour = (double) totalDayTime / 60;
                                int hours = (int) empHour;
                                int minutes = (int) (empHour * 60) % 60;
                                String hour = "" + hours;
                                String minute = "" + minutes;
                                if (minutes < 10 && minutes > 0) {
                                    minute = "0" + minute;
                                } else if (minutes < 0) {
                                    minute = "00";
                                }
                                String workingHours = hour + ":" + minute;
                                workingHour.add(workingHours);
                            }

                        } else {

                            if (userTimeIn.after(flexibleInTime) || userTimeIn.equals(flexibleInTime)) {
                                if (userTimeOut.before(userTimeIn)) {
                                    diff1 = userTimeOut1.getTime() - userTimeIn.getTime();
                                } else {
                                    diff1 = userTimeOut.getTime() - userTimeIn.getTime();
                                }

                            } else if (userTimeOut.before(userTimeIn)) {
                                diff1 = userTimeOut1.getTime() - flexibleInTime.getTime();
                            } else {
                                diff1 = userTimeOut.getTime() - flexibleInTime.getTime();
                            }

                            totalDayTime = diff1 / (60 * 1000);

                            if (userTimeOut.before(userTimeIn)) {

                                diff2 = userTimeOut.getTime() - userTimeon12.getTime();
//                                diff2 = userTimeOut1.getTime() - userTimeIn.getTime();
                            } else {
//                                diff2 = userTimeOut.getTime() - userTimeIn.getTime();
                            }
                            ///////////////AR code Start///////////////////////////////////////////////////
                            AttendanceRegularization attendanceRegularization = new AttendanceRegularization();
                            attendanceRegularization.setStartDateTime("" + next[0]);
                            attendanceRegularization.setUserMasterId(employeeMaster1.getUserMaster().getId());
                            long ARdiff = 0;
                            long ARTime = 0;
                            SimpleDateFormat sdf4 = new SimpleDateFormat("dd/mm/yyyy HH:mm");
                            List list = attendanceRegularizationMasterService.readArCountList(attendanceRegularization);
                            if (!list.isEmpty()) {
                                Object[] arm = (Object[]) list.get(0);
                                Date InTimeAR = sdf4.parse(arm[1].toString());
                                Date OutTimeAR = sdf4.parse(arm[2].toString());

                                ARdiff = OutTimeAR.getTime() - InTimeAR.getTime();
                                ARTime = ARdiff / (60 * 1000);

                            }
                            ///////////////AR code End////////////////////////////////////////
                            totalDayTime1 = diff2 / (60 * 1000);

                            totalDayTime = totalDayTime + totalDayTime1 + ARTime;
                            
                            List alllistPunch = employeeDatetimeDataService.readAllPuchDataDateWise("" + next[0], Integer.parseInt(id));
                            int listLen = alllistPunch.size();
                            boolean isMisPunch;
                            if(listLen % 2 == 0)
                                isMisPunch = false;
                            else
                                isMisPunch = true;
                            
                                boolean inBool = true;
                                boolean outBool = false;
                                String inTime1 = null;
                                String outTime1= null;
                                SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");  
                              
                                Date d1 = null;
                                Date d2 = null;
                                String []inTime1val;
                                String []outTime1val;
                                String outTime1val1;
                                String inTime1val1;
                                long timecount = 0;
                                int cnt =0;
                            for (Object o : alllistPunch) {
                                EmployeeDatetimeData employeeDatetimeData = (EmployeeDatetimeData) o;
                                cnt++;
                                if(isMisPunch && (listLen == cnt)){
                                    break;
                                }else if(inBool){
                                    inTime1 = employeeDatetimeData.getDateTime();                                    
                                    inTime1val = inTime1.split(" ");
                                    inTime1val1 = inTime1val[1];
                                    try {
                                        d1 = format.parse(inTime1val1);
//                                        d2 = format.parse(dateStop);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }    
                                    inBool = false;
                                    outBool = true;
                                } else if(outBool){
                                    outTime1 = employeeDatetimeData.getDateTime();
                                    outTime1val = outTime1.split(" ");
                                    outTime1val1 = outTime1val[1];
                                    inBool = true;
                                    outBool = false;
                                     try {
                                        d2 = format.parse(outTime1val1);
//                                        d2 = format.parse(dateStop);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }    
                                    long difff = d2.getTime() - d1.getTime();        
                                    long diffMinutes = difff / (60 * 1000);  
                                    timecount += diffMinutes;
                                    
                                }
                            }
                            double empHour = (double) timecount / 60;
                            int hours = (int) empHour;
                            int minutes = (int) (empHour * 60) % 60;
                            String hour = "" + hours;
                            String minute = "" + minutes;
                            if (minutes < 10 && minutes > 0) {
                                minute = "0" + minute;
                            } else if (minutes < 0) {
                                minute = "00";
                            }
                            String workingHours = hour + ":" + minute;
                            workingHour.add(workingHours);
                            
//                            double empHour = (double) totalDayTime / 60;
//                            int hours = (int) empHour;
//                            int minutes = (int) (empHour * 60) % 60;
//                            String hour = "" + hours;
//                            String minute = "" + minutes;
//                            if (minutes < 10 && minutes > 0) {
//                                minute = "0" + minute;
//                            } else if (minutes < 0) {
//                                minute = "00";
//                            }
//                            String workingHours = hour + ":" + minute;
//                            workingHour.add(workingHours);

                        }

                    } else if (null != mobPunchlist && mobPunchlist.size() > 0 && !secondHalf.equals("WO") && !secondHalf.equals("AB") && !secondHalf.equals("TR") && !secondHalf.equals("AR")) {
                        if (mobPunchlist.size() > 2) {
                            while (mobPunchlist.size() > i && mobPunchlist.size() > j) {

                                Object[] startLunchTime = (Object[]) mobPunchlist.get(i);
                                Object[] endLunchTime = (Object[]) mobPunchlist.get(j);
                                startTime = (String) startLunchTime[0];
                                endTime = (String) endLunchTime[0];
                                Date launchStrTime = sdf3.parse(startTime);
                                Date launchEndTime = sdf3.parse(endTime);
                                long diff = launchEndTime.getTime() - launchStrTime.getTime();
                                lunchTime = diff / (60 * 1000);
                                outTime = outTime + lunchTime;
                                i = i + 2;
                                j = j + 2;
                            }
                        }

                        String[] userTimeInStr = secondHalf.split("`");
                        String[] userTimeInStr1 = userTimeInStr[1].split("!");
                        String[] userTimeOutStr = secondHalf.split("!");
                        String[] userTimeOutStr1 = userTimeOutStr[1].split("@");
                        Date userTimeIn = sdf2.parse(userTimeInStr1[0]);
                        Date userTimeOut = sdf2.parse(userTimeOutStr1[0]);
                        Date userTimeOut1 = sdf2.parse("23:59");
                        String[] startHoursStr = secondHalf.split("%");
                        String[] firstStartHoursStr = startHoursStr[1].split("\\+");
                        String[] endHoursStr = secondHalf.split("&");
                        Date firstStartHours = sdf2.parse(firstStartHoursStr[1]);
                        Calendar cal1 = Calendar.getInstance();
                        cal1.setTime(firstStartHours);
                        cal1.add(Calendar.MINUTE, -earlyMinute);
                        String newTime1 = sdf2.format(cal1.getTime());
                        Date flexibleInTime = sdf2.parse(newTime1);
                        Date endHours = sdf2.parse(endHoursStr[1]);
                        long shiftTotalTime = endHours.getTime() - firstStartHours.getTime();
                        shiftdiffMinutes = shiftTotalTime / (60 * 1000);
                        long diff1 = 0;
                        long diff2 = 0;
                        if (userTimeIn.after(flexibleInTime) || userTimeIn.equals(flexibleInTime)) {
                            if (userTimeOut.before(userTimeIn)) {
                                diff1 = userTimeOut1.getTime() - userTimeIn.getTime();
                            } else {
                                diff1 = userTimeOut.getTime() - userTimeIn.getTime();
                            }

                        } else if (userTimeOut.before(userTimeIn)) {
                            diff1 = userTimeOut1.getTime() - flexibleInTime.getTime();
                        } else {
                            diff1 = userTimeOut.getTime() - flexibleInTime.getTime();
                        }

                        totalDayTime = diff1 / (60 * 1000);

                        if (userTimeOut.before(userTimeIn)) {
                            diff2 = userTimeOut1.getTime() - userTimeIn.getTime();
                        } else {
                            diff2 = userTimeOut.getTime() - userTimeIn.getTime();
                        }

                        totalDayTime1 = diff2 / (60 * 1000);

//                                        ===============30 minute lunch time 4 all employeee so who goes out side cut 30 min from their lunch time===============
//                                        =========================For who goes out side 4 lunch they have max 60 min time for lunch=======================
//                                        =========================For who goes out side 4 lunch they have max 60 min time for lunch=======================
                        long outTime1 = outTime;
                        outTime = outTime - 30;
//                                        ===============30 minute lunch time 4 all employeee so who goes out side cut 30 min from their lunch time===============
                        if (outTime > 0 && outTime1 != totalDayTime1) {
                            totalTime = totalDayTime - outTime;
                            double empHour = (double) totalTime / 60;
                            int hours = (int) empHour;
                            int minutes = (int) (empHour * 60) % 60;
                            String hour = "" + hours;
                            String minute = "" + minutes;
                            if (minutes < 10 && minutes > 0) {
                                minute = "0" + minute;
                            } else if (minutes < 0) {
                                minute = "00";
                            }
                            String workingHours = hour + ":" + minute;
                            workingHour.add(workingHours);

                        } else {
                            double empHour = (double) totalDayTime / 60;
                            int hours = (int) empHour;
                            int minutes = (int) (empHour * 60) % 60;
                            String hour = "" + hours;
                            String minute = "" + minutes;
                            if (minutes < 10 && minutes > 0) {
                                minute = "0" + minute;
                            } else if (minutes < 0) {
                                minute = "00";
                            }
                            String workingHours = hour + ":" + minute;
                            workingHour.add(workingHours);
                        }
                    } else {
                        workingHour.add("-");
                    }
                } catch (Exception e) {
                    workingHour.add("-");

                }

            }

        }

//        List<?> attendanceDateList =
//        List<?> l1 = null;
//        if (("".equals(startDate) || null == startDate) || ("".equals(endDate) || null == endDate)) {
//            empDetail = l1;
//        }
        mv.getModelMap()
                .put("firstHalfList", newList);
        mv.getModelMap()
                .put("secondHalfList", secondHalfList);
        mv.getModelMap()
                .put("workingHour", workingHour);
        mv.getModelMap()
                .put("empDetail", empDetail);
        mv.getModelMap()
                .put("map", map);
        mv.getModelMap()
                .put("woMap", woMap);
        mv.getModelMap()
                .put("satMap", satMap);
        mv.getModelMap()
                .put("halfDayMap", halfDayMap);
        mv.getModelMap()
                .put("employeeAdvanceSearch", employeeAdvanceSearch);
        Date notflexibleSupportDate;

        if (startDate.contains(
                "-")) {
            notflexibleSupportDate = sdf1.parse(startDate);
        } else {
            notflexibleSupportDate = sdf.parse(startDate);
        }
        String FixedFlexibleDate = "01/04/2016";
        Date notflexibleSupportDate1 = sdf.parse(FixedFlexibleDate);
        Calendar calForFlexiNotSupport1 = Calendar.getInstance();
        Calendar calForFlexiNotSupport2 = Calendar.getInstance();

        calForFlexiNotSupport1.setTime(notflexibleSupportDate);

        calForFlexiNotSupport2.setTime(notflexibleSupportDate1);
        request.setAttribute("id", id);
        if (flexible == true) {
//        if (flexible == true) {
            mv.setViewName("Shift/EmployeeFlexibleDayWisePunchDataReportOfSubordinate");

        } else {
            mv.setViewName("Shift/EmployeeIndividualOrDateWiseShiftSearchForSubordinate");
        }

        return mv;
    }

    public ModelAndView showOwnAttandanceOfAllEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeAdvanceSearch employeeAdvanceSearch = new EmployeeAdvanceSearch();
        EmployeeShiftData employeeShiftData = new EmployeeShiftData();
        String startDate = request.getParameter("inDateTime");
        String endDate = request.getParameter("outDateTime");
        bind(request, employeeAdvanceSearch);

        String id = request.getParameter("id");
        employeeAdvanceSearch.setId(id);
        employeeAdvanceSearch.setZydexLocationId(null);
        employeeAdvanceSearch.setLevelID(null);
        employeeAdvanceSearch.setDepartmentId(null);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Map<String, String> woMap = new HashMap<String, String>();
        Map<String, String> satMap = new HashMap<String, String>();
        Map<String, String> halfDayMap = new HashMap<String, String>();
        if (null != id && !id.equals("")) {
            employeeShiftData.setId(Integer.parseInt(id));
        }
        employeeAdvanceSearch.setEmployeeId(Boolean.FALSE);
        employeeAdvanceSearch.setEmployeeName(Boolean.FALSE);
        employeeAdvanceSearch.setFatherName(Boolean.FALSE);
        employeeAdvanceSearch.setMotherName(Boolean.FALSE);
        employeeAdvanceSearch.setGender(Boolean.FALSE);
        employeeAdvanceSearch.setMaritalStatus(Boolean.FALSE);
        employeeAdvanceSearch.setSpouseName(Boolean.FALSE);
        employeeAdvanceSearch.setDateOfBirth(Boolean.FALSE);
        employeeAdvanceSearch.setPresentAddress(Boolean.FALSE);
        employeeAdvanceSearch.setPermanentAddress(Boolean.FALSE);
        employeeAdvanceSearch.setBloodGroups(Boolean.FALSE);
        employeeAdvanceSearch.setEmailAddress(Boolean.FALSE);
        employeeAdvanceSearch.setContactNo1(Boolean.FALSE);
        employeeAdvanceSearch.setContactNo2(Boolean.FALSE);
        employeeAdvanceSearch.setEmergencyContactPerson(Boolean.FALSE);
        employeeAdvanceSearch.setEmergencyContactNo(Boolean.FALSE);
        employeeAdvanceSearch.setPanCard(Boolean.FALSE);
        employeeAdvanceSearch.setPassportNo(Boolean.FALSE);
        employeeAdvanceSearch.setPassportIssueDate(Boolean.FALSE);
        employeeAdvanceSearch.setPassportExpiryDate(Boolean.FALSE);
        employeeAdvanceSearch.setAdharCard(Boolean.FALSE);
        employeeAdvanceSearch.setOfficeEmailId(Boolean.FALSE);
        employeeAdvanceSearch.setHighestEducationDetails(Boolean.FALSE);
        employeeAdvanceSearch.setExperienceYearOnDoj(Boolean.FALSE);
        employeeAdvanceSearch.setExperienceMonthOnDoj(Boolean.FALSE);
        employeeAdvanceSearch.setCompany(Boolean.FALSE);
        employeeAdvanceSearch.setZydexLocation(Boolean.FALSE);
        employeeAdvanceSearch.setWorkLocation(Boolean.FALSE);
        employeeAdvanceSearch.setLevel(Boolean.FALSE);
        employeeAdvanceSearch.setDepartment(Boolean.FALSE);
        employeeAdvanceSearch.setDesignation(Boolean.FALSE);
        employeeAdvanceSearch.setRole(Boolean.FALSE);
        employeeAdvanceSearch.setDateOfJoining(Boolean.FALSE);
        employeeAdvanceSearch.setEmployeeType(Boolean.FALSE);
        employeeAdvanceSearch.setBankName(Boolean.FALSE);
        employeeAdvanceSearch.setBankAccountNo(Boolean.FALSE);
        employeeAdvanceSearch.setBankIfscCode(Boolean.FALSE);
        employeeAdvanceSearch.setReportingManager(Boolean.FALSE);
        employeeAdvanceSearch.setCityOfEmployee(Boolean.FALSE);
        employeeAdvanceSearch.setChild1(Boolean.FALSE);
        employeeAdvanceSearch.setChild2(Boolean.FALSE);
        employeeAdvanceSearch.setDateOfBirthOfEmpFather(Boolean.FALSE);
        employeeAdvanceSearch.setDateOfBirthOfEmpMother(Boolean.FALSE);
        employeeAdvanceSearch.setDateOfBirthOfEmpSpous(Boolean.FALSE);
        employeeAdvanceSearch.setDateOfBirthOfEmpChilld1(Boolean.FALSE);
        employeeAdvanceSearch.setDateOfBirthOfEmpChild2(Boolean.FALSE);
        employeeAdvanceSearch.setDateOfTransferOfEntity(Boolean.FALSE);

        if ((!"".equals(startDate) && null != startDate) && (!"".equals(endDate) && null != endDate)) {
            if (!"".equals(startDate) && null != startDate) {
                Date sDate = sdf.parse(startDate);
//            "2012-01-01"
                employeeShiftData.setInDateTime(new SimpleDateFormat("yyyy-MM-dd").format(sDate));

            }
            if (!"".equals(endDate) && null != endDate) {
                Date eDate = sdf.parse(endDate);
                employeeShiftData.setOutDateTime(new SimpleDateFormat("yyyy-MM-dd").format(eDate));
            }
        } else {
            Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int day = c.get(Calendar.DAY_OF_MONTH);
            int month = c.get(Calendar.MONTH) + 1;

            startDate = year + "-" + (month < 10 ? ("0" + month) : (month)) + "-01";
            Date sDate = sdf1.parse(startDate);
            endDate = year + "-" + (month < 10 ? ("0" + month) : (month)) + "-" + day;
            Date eDate = sdf1.parse(endDate);
            employeeShiftData.setInDateTime(sdf1.format(sDate));
            employeeShiftData.setOutDateTime(sdf1.format(eDate));
        }

        List<?> empDetail = employeeMasterService.empOrDateWiseSearch(employeeAdvanceSearch);
        Map<Integer, List<?>> map = new LinkedHashMap<Integer, List<?>>();
        for (Object o1 : empDetail) {
            Object[] o = (Object[]) o1;
            int id1 = (Integer) o[48];
            employeeShiftData.setId(id1);

            List list = employeeShiftDataService.empOrDateWiseSearch(employeeShiftData);
            int i = 0;
            for (Iterator<? extends Object> iterator = list.iterator(); iterator.hasNext();) {
                Object[] next = (Object[]) iterator.next();

                String firstHalf = "" + next[1];
                if (!firstHalf.contains("fullday") && !firstHalf.equals("WO") && !firstHalf.equals("TR") && !firstHalf.equals("AR") && !firstHalf.equals("AB") && !firstHalf.contains("?")
                        && !firstHalf.equals("Casual Leave") && !firstHalf.equals("Short Leave") && !firstHalf.equals("C Off Leave") && !firstHalf.equals("Privilege Leave") && !firstHalf.equals("Sick Leave")
                        && !firstHalf.equals("Paternity Leave") && !firstHalf.equals("Maternity Leave") && !firstHalf.equals("Leave Without Pay")) {
                    Date date1 = sdf.parse("" + next[0]);
                    Calendar c2 = Calendar.getInstance();
                    c2.setTime(date1);
                    SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");
                    String[] userTimeInStr = firstHalf.split("`");
                    String[] userTimeInStr1 = userTimeInStr[1].split("!");
                    String[] userTimeOutStr = firstHalf.split("!");
                    String[] userTimeOutStr1 = userTimeOutStr[1].split("@");
                    Date userTimeIn = sdf2.parse(userTimeInStr1[0]);
                    Date userTimeOut = sdf2.parse(userTimeOutStr1[0]);
                    if (userTimeOut.before(userTimeIn)) {
                        next[1] = ("" + next[1]).replace("AB", "fullday");
//                        tempList.add(""+next[0]);
//                        tempList.add(("" + next[1]).replace("AB", "PR"));
                        list.set(i, next);
                    }
                }
                i++;
            }
            map.put(Integer.parseInt(id), list);
            request.setAttribute("attendanceDateList", list);
        }

        EmployeeMaster employeeMaster1 = employeeMasterService.readById(Integer.parseInt(id));
        boolean flexible = false;
        int earlyMinute = 0;
        int lateMinute = 0;
        List<?> timeAttFlexibleList = timeAttandanceFlaxibleMasterService.read();
        if (!timeAttFlexibleList.isEmpty()) {
            for (Object flexiObject : timeAttFlexibleList) {
                TimeAttandanceFlaxibleMaster timeAttandanceFlaxibleMaster = (TimeAttandanceFlaxibleMaster) flexiObject;
                int zydexLocId = timeAttandanceFlaxibleMaster.getZydexLocationMaster().getId();
                int zydexLocId2 = employeeMaster1.getZydexLocationMaster().getId();
                if (zydexLocId == zydexLocId2) {
                    flexible = true;
                    earlyMinute = Integer.parseInt(timeAttandanceFlaxibleMaster.getEarlyFlexibleTime());
                    lateMinute = Integer.parseInt(timeAttandanceFlaxibleMaster.getLateFlexibleTime());
                    break;
                }
            }
        }
        SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");
        List newList = new ArrayList();
        List secondHalfList = new ArrayList();
        List workingHour = new ArrayList();
        for (Map.Entry<Integer, List<?>> entry : map.entrySet()) {
            Iterator itr5 = entry.getValue().iterator();
            while (itr5.hasNext()) {
                try {
                    Object[] next = (Object[]) itr5.next();
                    String firstHalf = "" + next[1];

                    Date date = sdf.parse("" + next[0]);
                    Calendar c = Calendar.getInstance();
                    //                    c.setTime(date);
                    // week off code start
                    Calendar c1 = Calendar.getInstance();
                    c1.setTime(date);
                    if (firstHalf.contains("WO")) {
                        LeaveEmployeeDetail leaveEmployeeDetail = new LeaveEmployeeDetail();
                        c1.add(Calendar.DATE, -1);
                        SimpleDateFormat format = new SimpleDateFormat("EEEE");
                        String dayName = format.format(c1.getTime());
                        int dayOfWeek = c1.get(Calendar.WEEK_OF_MONTH);
                        if (dayName.equals("Saturday") && dayOfWeek != 2) {
                            SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy");
                            leaveEmployeeDetail.setStartDate("" + sdf3.format(c1.getTime()));
                            leaveEmployeeDetail.setEndDate("" + sdf3.format(c1.getTime()));
                            leaveEmployeeDetail.setEmployeeMaster(employeeMaster1);
                            leaveEmployeeDetail.setStatus(3);
                            List firstLeaveEmployeeDetail = leaveEmployeeDetailService.readLeaveDetails(leaveEmployeeDetail);
                            if (!firstLeaveEmployeeDetail.isEmpty()) {
                                c1.add(Calendar.DATE, 2);
                                leaveEmployeeDetail.setStartDate("" + sdf3.format(c1.getTime()));
                                leaveEmployeeDetail.setEndDate("" + sdf3.format(c1.getTime()));
                                leaveEmployeeDetail.setEmployeeMaster(employeeMaster1);
                                leaveEmployeeDetail.setStatus(3);
                                List secondLeaveEmployeeDetail = leaveEmployeeDetailService.readLeaveDetails(leaveEmployeeDetail);

                                // saturday sandwich Leave code start
                                Object[] oSatArray = (Object[]) firstLeaveEmployeeDetail.get(0);
                                String woSatType = "" + oSatArray[0];
                                Date sSatDate = sdf.parse("" + oSatArray[1]);
                                Date eSatDate = sdf.parse("" + oSatArray[2]);
                                String sSatDateStr = "" + oSatArray[6];
                                String eSatDateStr = "" + oSatArray[7];
                                float noOfSatDays = (float) oSatArray[3];
                                float diffInSatDays = 0;
                                if ((sSatDateStr.equals("Fullday") && eSatDateStr.equals("Fullday"))
                                        || (sSatDateStr.equals("Fullday") && sSatDate.equals(eSatDate))) {
                                    diffInSatDays = (float) ((eSatDate.getTime() - sSatDate.getTime())
                                            / (1000 * 60 * 60 * 24)) + 1;
                                } else if ((sSatDateStr.equals("SecondHalf") && eSatDateStr.equals("Fullday"))
                                        || (sSatDateStr.equals("Fullday") && eSatDateStr.equals("FirstHalf"))) {
                                    diffInSatDays = (float) ((eSatDate.getTime() - sSatDate.getTime())
                                            / (1000 * 60 * 60 * 24)) + 1;
                                    diffInSatDays = diffInSatDays - (float) 0.5;
                                } else if (sSatDateStr.equals("SecondHalf") && eSatDateStr.equals("FirstHalf")) {
                                    diffInSatDays = (float) ((eSatDate.getTime() - sSatDate.getTime())
                                            / (1000 * 60 * 60 * 24)) + 1;
                                    diffInSatDays = diffInSatDays - 1;
                                }
                                // saturday sandwich Leave code End

                                // Monday sandwich Leave code start
                                float noOfMonDays = 0;
                                float diffInMonDays = -1;
                                String woMonType = "";
                                if (!secondLeaveEmployeeDetail.isEmpty()) {
                                    Object[] oMonArray = (Object[]) secondLeaveEmployeeDetail.get(0);
                                    woMonType = "" + oMonArray[0];
                                    Date sMonDate = sdf.parse("" + oMonArray[1]);
                                    Date eMonDate = sdf.parse("" + oMonArray[2]);
                                    String sMonDateStr = "" + oMonArray[6];
                                    String eMonDateStr = "" + oMonArray[7];
                                    noOfMonDays = (float) oMonArray[3];
                                    if ((sMonDateStr.equals("Fullday") && eMonDateStr.equals("Fullday"))
                                            || (sMonDateStr.equals("Fullday") && sMonDate.equals(eMonDate))) {
                                        diffInMonDays = (float) ((eMonDate.getTime() - sMonDate.getTime())
                                                / (1000 * 60 * 60 * 24)) + 1;
                                    } else if ((sMonDateStr.equals("SecondHalf") && eMonDateStr.equals("Fullday"))
                                            || (sMonDateStr.equals("Fullday") && eMonDateStr.equals("FirstHalf"))) {
                                        diffInMonDays = (float) ((eMonDate.getTime() - sMonDate.getTime())
                                                / (1000 * 60 * 60 * 24)) + 1;
                                        diffInMonDays = diffInMonDays - (float) 0.5;
                                    } else if (sMonDateStr.equals("SecondHalf") && eMonDateStr.equals("FirstHalf")) {
                                        diffInMonDays = (float) ((eMonDate.getTime() - sMonDate.getTime())
                                                / (1000 * 60 * 60 * 24)) + 1;
                                        diffInMonDays = diffInMonDays - 1;
                                    }
                                }
                                // Monday sandwich Leave code end

//                            if (diffInSatDays != noOfSatDays || (!date.equals(sSatDate) && !date.equals(eSatDate))) {
                                if (diffInSatDays != noOfSatDays || (date.before(eSatDate)
                                        && date.after(sSatDate) && diffInSatDays == noOfSatDays)) {
                                    woMap.put("" + next[0], woSatType);
                                } else if (diffInMonDays != -1 && diffInMonDays != noOfMonDays) {
                                    woMap.put("" + next[0], woMonType);
                                } else if ((diffInSatDays % 1 == 0 && diffInSatDays == noOfSatDays) && diffInMonDays == noOfMonDays) {
                                    woMap.put("" + next[0], "LWP");
                                } else {
                                    woMap.put("" + next[0], "WO");
                                }
                            } else {
                                woMap.put("" + next[0], "WO");
                            }
                        } else {
                            woMap.put("" + next[0], "WO");
                        }
                    }
                    // week off code End

//         1st Half:             Half day absent Code when start date is full and end date is first half start Code
                    Date date1 = sdf.parse("" + next[0]);
                    Calendar c2 = Calendar.getInstance();
                    c2.setTime(date1);
                    LeaveEmployeeDetail leaveEmployeeDetail = new LeaveEmployeeDetail();
                    SimpleDateFormat sdfAb = new SimpleDateFormat("dd/MM/yyyy");
                    leaveEmployeeDetail.setStartDate("" + sdfAb.format(c2.getTime()));
                    leaveEmployeeDetail.setEndDate("" + sdfAb.format(c2.getTime()));
                    leaveEmployeeDetail.setEmployeeMaster(employeeMaster1);
                    leaveEmployeeDetail.setStatus(3);
                    List absentEmployeeDetail = leaveEmployeeDetailService.readLeaveDetails(leaveEmployeeDetail);
                    float diffInDays = 0;
                    String woType = "";
                    if (!absentEmployeeDetail.isEmpty()) {
                        Object[] oSatArray = (Object[]) absentEmployeeDetail.get(0);
                        woType = "" + oSatArray[0];
                        Date sDate = sdf.parse("" + oSatArray[1]);
                        Date eDate = sdf.parse("" + oSatArray[2]);
                        String sDateStr = "" + oSatArray[6];
                        String eDateStr = "" + oSatArray[7];
                        float noOfDays = (float) oSatArray[3];
                        if ((sDateStr.equals("Fullday") && eDateStr.equals("FirstHalf"))) {
                            diffInDays = (float) ((eDate.getTime() - sDate.getTime())
                                    / (1000 * 60 * 60 * 24)) + 1;
                            if (date1.equals(eDate)) {
                                diffInDays = diffInDays - (float) 0.5;
                            }
                        }
                    }
//        1st Half:              Half day absent Code when start date is full and end date is first half  End code

                    int dayOfWeek = c.get(Calendar.WEEK_OF_MONTH);
                    SimpleDateFormat format = new SimpleDateFormat("EEEE");
                    String dayName = format.format(date);

                    if (firstHalf.contains("fullday")) {
                        newList.add("PR");
                    } else if (!firstHalf.contains("fullday") && !firstHalf.equals("WO") && !firstHalf.equals("TR") && !firstHalf.equals("AR") && !firstHalf.equals("AB") && !firstHalf.contains("?")
                            && !firstHalf.equals("Casual Leave") && !firstHalf.equals("Short Leave") && !firstHalf.equals("C Off Leave") && !firstHalf.equals("Privilege Leave") && !firstHalf.equals("Sick Leave")
                            && !firstHalf.equals("Paternity Leave") && !firstHalf.equals("Maternity Leave") && !firstHalf.equals("Leave Without Pay")) {
                        String[] userTimeInStr = firstHalf.split("`");
                        String[] userTimeInStr1 = userTimeInStr[1].split("!");
                        String[] userTimeOutStr = firstHalf.split("!");
                        String[] userTimeOutStr1 = userTimeOutStr[1].split("@");
                        String[] leave = firstHalf.split("@");
                        String[] leave1 = leave[1].split("#");
                        String[] LateHoursStr = firstHalf.split("\\$");
                        String[] LateHoursStr1 = LateHoursStr[1].split("%");
                        String[] endHoursStr = firstHalf.split("%");
                        String[] endHoursStr1 = endHoursStr[1].split("\\^");
                        String[] firstStartHoursStr = endHoursStr[1].split("\\+");
                        Date userTimeIn = sdf2.parse(userTimeInStr1[0]);
                        Date userTimeOut = sdf2.parse(userTimeOutStr1[0]);
                        Date endHours = sdf2.parse(endHoursStr1[0]);
                        Date firstStartHours = sdf2.parse(firstStartHoursStr[1]);
                        Calendar cal = Calendar.getInstance();
                        Calendar cal1 = Calendar.getInstance();
                        cal.setTime(firstStartHours);
                        cal1.setTime(firstStartHours);
                        cal1.add(Calendar.MINUTE, -earlyMinute);
                        cal.add(Calendar.MINUTE, lateMinute);
                        String newTime = sdf2.format(cal.getTime());
                        Date flexibleEndTime = sdf2.parse(newTime);
                        Date LateHours = sdf2.parse(LateHoursStr1[0]);
                        String newTime1 = sdf2.format(cal1.getTime());
                        Date flexibleStartTime = sdf2.parse(newTime1);
                        long diff = endHours.getTime() - firstStartHours.getTime();
                        long diffMinutes = diff / (60 * 1000);
                        long diff1 = 0;
                        if (userTimeIn.after(flexibleStartTime) || userTimeIn.equals(flexibleStartTime)) {
                            diff1 = endHours.getTime() - userTimeIn.getTime();
                        } else {
                            diff1 = endHours.getTime() - flexibleStartTime.getTime();
                        }
                        long diffMinutes1 = diff1 / (60 * 1000);
                        if (dayName.equals("Saturday") && dayOfWeek == 2 && diffMinutes1 >= 240) {
                            newList.add("PR");
                        } else if (diffMinutes1 >= diffMinutes) {
                            newList.add("PR");
                        } else if (userTimeIn != null) {
                            if ((userTimeIn.before(flexibleEndTime) || userTimeIn.equals(flexibleEndTime)) && (userTimeOut.after(endHours) || userTimeOut.equals(endHours))) {
                                newList.add("PR");
                            } else if (userTimeOut.before(userTimeIn)) {
                                newList.add("PR");
                            } else if (leave1[0] != null && !leave1[0].contains("Short Leave")) {
                                if ((userTimeIn.before(flexibleEndTime) || userTimeIn.equals(flexibleEndTime)) && (userTimeOut.after(endHours) || userTimeOut.equals(endHours))) {
                                    newList.add("PR");
                                } else if (leave1[0].contains("AB")) {
                                    newList.add("AB");
                                } else if (leave1[0].contains("AR")) {
                                    newList.add("AR/P");
                                } else {
                                    if (leave1[0].contains("Casual Leave")) {
                                        newList.add("Casual Leave");
                                    }
                                    if (leave1[0].contains("Privilege Leave")) {
                                        newList.add("Privilege Leave");
                                    }
                                    if (leave1[0].contains("Sick Leave")) {
                                        newList.add("Sick Leave");
                                    }
                                    if (leave1[0].contains("Maternity Leave")) {
                                        newList.add("Maternity Leave");
                                    }
                                    if (leave1[0].contains("Paternity Leave")) {
                                        newList.add("Paternity Leave");
                                    }
                                    if (leave1[0].contains("C Off Leave")) {
                                        newList.add("C Off Leave");
                                    }
                                    if (leave1[0].contains("Leave Without Pay")) {
                                        newList.add("Leave Without Pay");
                                    }
                                }

                            } else if (null != leave1[0] && leave1[0].contains("Short Leave")) {
                                if (firstHalf.contains("*")) {
                                    String[] shortArray = firstHalf.split("\\*");
                                    String[] endArray = shortArray[1].split("\\-");
                                    String[] startTime = endArray[1].split("\\+");
                                    Date shortIn = sdf2.parse(shortArray[1]);
                                    Date shortend = sdf2.parse(endArray[1]);
                                    Date startTime1 = sdf2.parse(startTime[1]);
                                    if (shortIn.before(endHours)) {
                                        newList.add("SHL/P");
                                    } else if (leave1[0].contains("~ AR")) {
                                        newList.add("AR/P");
                                    } else if (userTimeIn.after(endHours)) {
                                        newList.add("SHL/A");
                                    } else if ((userTimeIn.before(flexibleEndTime) || userTimeIn.equals(flexibleEndTime)) && (userTimeOut.after(endHours) || userTimeOut.equals(endHours))) {
                                        newList.add("PR");
                                    } else {
                                        newList.add("AB");
                                    }
                                } else {
                                    newList.add("AB");
                                }
                            } else if (null != leave1[0] && !leave1[0].contains("AB")) {
                                if (leave1[0].contains("Casual Leave")) {
                                    newList.add("Casual Leave");
                                }
                                if (leave1[0].contains("Privilege Leave")) {
                                    newList.add("Privilege Leave");
                                }
                                if (leave1[0].contains("Sick Leave")) {
                                    newList.add("Sick Leave");
                                }
                                if (leave1[0].contains("Maternity Leave")) {
                                    newList.add("Maternity Leave");
                                }
                                if (leave1[0].contains("Paternity Leave")) {
                                    newList.add("Paternity Leave");
                                }
                                if (leave1[0].contains("C Off Leave")) {
                                    newList.add("C Off Leave");
                                }
                                if (leave1[0].contains("Leave Without Pay")) {
                                    newList.add("Leave Without Pay");
                                }

                            } else if (leave1[0].contains("AB")) {
                                newList.add("-");

                            } else {
                                newList.add("AB");
                            }

                        } else if (userTimeIn != null && !firstHalf.contains("WO") && !firstHalf.contains("?")) {
                            newList.add("AB");
                        } else if (firstHalf.contains("WO") || firstHalf.contains("?")) {
                            newList.add("-");
                        }

                    } else if (firstHalf.equals("WO")) {
                        newList.add("-");
                    } else if (firstHalf.contains("AR")) {
                        newList.add("AR/P");
                    } else if (firstHalf.equals("AB")) {
                        newList.add("AB");
                    } else if (firstHalf.contains("?")) {
                        newList.add("-");
                    } else if (firstHalf.equals("Casual Leave") || firstHalf.equals("Privilege Leave") || firstHalf.equals("Sick Leave")
                            || firstHalf.equals("Maternity Leave") || firstHalf.equals("Paternity Leave") || firstHalf.equals("C Off Leave")
                            || firstHalf.equals("Leave Without Pay")) {
//       1st Half:                 Half day absent Code  start date is full and end date is First Half start code
                        if (diffInDays % 1 == 0) {
                            newList.add("-");
                        } else {
                            newList.add(firstHalf);
                            halfDayMap.put("" + next[0], woType);
                        }
//       1st Half:                 Half day absent Code  start date is full and end date is First Half End code
//                            newList.add("-");
                    }
                } catch (Exception e) {

                }
            }

            Iterator itr6 = entry.getValue().iterator();
            int weekNameCounter = 0;
            boolean satWeekOff = false;
            while (itr6.hasNext()) {
                try {
                    Object[] next = (Object[]) itr6.next();

                    String secondHalf = "" + next[1];
                    int firstHalfVal = 0;

//       2nd Half:              Half day absent Code when start date is full and end date is first half  start Code
                    Date date1 = sdf.parse("" + next[0]);
                    Calendar c1 = Calendar.getInstance();
                    c1.setTime(date1);
                    LeaveEmployeeDetail leaveEmployeeDetail = new LeaveEmployeeDetail();
                    SimpleDateFormat sdfAb = new SimpleDateFormat("dd/MM/yyyy");
                    leaveEmployeeDetail.setStartDate("" + sdfAb.format(c1.getTime()));
                    leaveEmployeeDetail.setEndDate("" + sdfAb.format(c1.getTime()));
                    leaveEmployeeDetail.setEmployeeMaster(employeeMaster1);
                    leaveEmployeeDetail.setStatus(3);
                    List absentEmployeeDetail = leaveEmployeeDetailService.readLeaveDetails(leaveEmployeeDetail);
                    float diffInDays = 0;
                    String woType = "";
                    if (!absentEmployeeDetail.isEmpty()) {
                        Object[] oSatArray = (Object[]) absentEmployeeDetail.get(0);
                        woType = "" + oSatArray[0];
                        Date sDate = sdf.parse("" + oSatArray[1]);
                        Date eDate = sdf.parse("" + oSatArray[2]);
                        String sDateStr = "" + oSatArray[6];
                        String eDateStr = "" + oSatArray[7];
                        float noOfDays = (float) oSatArray[3];
                        if ((sDateStr.equals("Fullday") && eDateStr.equals("FirstHalf"))) {
                            diffInDays = (float) ((eDate.getTime() - sDate.getTime())
                                    / (1000 * 60 * 60 * 24)) + 1;
                            if (date1.equals(eDate)) {
                                diffInDays = diffInDays - (float) 0.5;
                            }
                        }
                    }
//       2nd Half:              Half day absent Code when start date is full and end date is first half  end Code
                    int counter = 0;
                    String shiftName = "";
//                                    2nd Sat Week Off Codding
                    Calendar cal = Calendar.getInstance();
                    Date date = sdf.parse("" + next[0]);
                    cal.setTime(date);
                    SimpleDateFormat format = new SimpleDateFormat("EEEE");
                    String dayName = format.format(date);
                    int dayOfWeek = cal.get(Calendar.WEEK_OF_MONTH);
//                    EmployeeMaster employeeMaster1 = employeeMasterService.readById(Integer.parseInt(id));
                    ZydexLocationMaster zydexLocationMaster = zydexLocationMasterService.readById(employeeMaster1.getZydexLocationMaster().getId());

                    if (dayName.equals("Saturday")) {
                        if (dayOfWeek == 2) {
                            satWeekOff = true;
                            satMap.put("" + next[0], "AB");
                        } else {
                            satWeekOff = false;
                        }

                    } else {
                        satWeekOff = false;
                    }
//                                    2nd Sat Week Off Codding

//                                    Lunch Breck Cut Off
                    List listPunch = employeeDatetimeDataService.readPuchDataDateWise("" + next[0], Integer.parseInt(id));
                    long lunchTime = 0;
                    long totalDayTime = 0;
                    long totalDayTime1 = 0;
                    long totalTime = 0;
                    long shiftdiffMinutes = 0;
                    String startTime = "";
                    String endTime = "";
                    SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                    long outTime = 0;
                    int d = 1;
                    int s = 2;
                    boolean checkLunchTime = false;
                    try {
                        if (zydexLocationMaster.getId() == 1 || zydexLocationMaster.getId() == 6) {
                            if (listPunch.size() > 2) {
                                while (listPunch.size() > d && listPunch.size() > s) {
                                    Object[] startLunchTime = (Object[]) listPunch.get(d);
                                    Object[] endLunchTime = (Object[]) listPunch.get(s);
                                    startTime = (String) startLunchTime[0];
                                    endTime = (String) endLunchTime[0];
                                    Date launchStrTime = sdf3.parse(startTime);
                                    Date launchEndTime = sdf3.parse(endTime);
                                    long diff = launchEndTime.getTime() - launchStrTime.getTime();
                                    lunchTime = diff / (60 * 1000);
                                    outTime = outTime + lunchTime;
                                    d = d + 2;
                                    s = s + 2;
                                }
                                String[] userTimeInStr = secondHalf.split("`");
                                String[] userTimeInStr1 = userTimeInStr[1].split("!");
                                String[] userTimeOutStr = secondHalf.split("!");
                                String[] userTimeOutStr1 = userTimeOutStr[1].split("@");
                                Date userTimeIn = sdf2.parse(userTimeInStr1[0]);
                                Date userTimeOut = sdf2.parse(userTimeOutStr1[0]);
                                String[] startHoursStr = secondHalf.split("%");
                                String[] firstStartHoursStr = startHoursStr[1].split("\\+");
                                String[] endHoursStr = secondHalf.split("&");
                                Date firstStartHours = sdf2.parse(firstStartHoursStr[1]);
                                Calendar cal1 = Calendar.getInstance();
                                cal1.setTime(firstStartHours);
                                cal1.add(Calendar.MINUTE, -earlyMinute);

                                String newTime1 = sdf2.format(cal1.getTime());
                                Date flexibleInTime = sdf2.parse(newTime1);
                                Date endHours = sdf2.parse(endHoursStr[1]);
                                long shiftTotalTime = endHours.getTime() - firstStartHours.getTime();
                                shiftdiffMinutes = shiftTotalTime / (60 * 1000);
                                long diff1 = 0;
                                long diff2 = 0;
                                if (userTimeIn.after(flexibleInTime) || userTimeIn.equals(flexibleInTime)) {
                                    diff1 = userTimeOut.getTime() - userTimeIn.getTime();

                                } else {
                                    diff1 = userTimeOut.getTime() - flexibleInTime.getTime();
                                }
                                totalDayTime = diff1 / (60 * 1000);

                                diff2 = userTimeOut.getTime() - userTimeIn.getTime();
                                totalDayTime1 = diff2 / (60 * 1000);

//                                        ===============30 minute lunch time 4 all employeee so who goes out side cut 30 min from their lunch time===============
//                                        =========================For who goes out side 4 lunch they have max 60 min time for lunch=======================
//                                        =========================For who goes out side 4 lunch they have max 60 min time for lunch=======================
                                long outTime1 = outTime;
                                outTime = outTime - 30;
//                                        ===============30 minute lunch time 4 all employeee so who goes out side cut 30 min from their lunch time===============
                                if (outTime1 == totalDayTime1) {
                                    totalTime = totalDayTime;
                                } else if (outTime > 0) {
                                    totalTime = totalDayTime - outTime;
                                    checkLunchTime = true;
                                }

                            }
                        } else {
//                            if (listPunch.size() > 2) {
//                                    Object[] startTimeO = (Object[]) listPunch.get(0);
//                                    Object[] endTimeO = (Object[]) listPunch.get(listPunch.size()-1);
//                                    startTime = (String) startTimeO[0];
//                                    endTime = (String) endTimeO[0];

                            String[] userTimeInStr = secondHalf.split("`");
                            String[] userTimeInStr1 = userTimeInStr[1].split("!");
                            String[] userTimeOutStr = secondHalf.split("!");
                            String[] userTimeOutStr1 = userTimeOutStr[1].split("@");
                            Date userTimeIn = sdf2.parse(userTimeInStr1[0]);
                            Date userTimeOut = sdf2.parse(userTimeOutStr1[0]);
                            String[] startHoursStr = secondHalf.split("%");
                            String[] firstStartHoursStr = startHoursStr[1].split("\\+");
                            String[] endHoursStr = secondHalf.split("&");
                            Date firstStartHours = sdf2.parse(firstStartHoursStr[1]);
                            Calendar cal1 = Calendar.getInstance();
                            cal1.setTime(firstStartHours);
                            cal1.add(Calendar.MINUTE, -earlyMinute);

                            String newTime1 = sdf2.format(cal1.getTime());
                            Date flexibleInTime = sdf2.parse(newTime1);
                            Date endHours = sdf2.parse(endHoursStr[1]);
                            long shiftTotalTime = endHours.getTime() - firstStartHours.getTime();
                            shiftdiffMinutes = shiftTotalTime / (60 * 1000);
                            long diff1 = 0;
                            long diff2 = 0;
                            if (userTimeIn.after(flexibleInTime) || userTimeIn.equals(flexibleInTime)) {
                                diff1 = userTimeOut.getTime() - userTimeIn.getTime();

                            } else {
                                diff1 = userTimeOut.getTime() - flexibleInTime.getTime();
                            }
                            totalDayTime = diff1 / (60 * 1000);

                            diff2 = userTimeOut.getTime() - userTimeIn.getTime();
                            totalDayTime1 = diff2 / (60 * 1000);
                            totalTime = totalDayTime;
//                            }

                        }

                    } catch (Exception e) {

                    }

//                                    Lunch Breck Cut Off
                    if (secondHalf.contains(" # ")) {
                        String[] string1 = secondHalf.split("#");
                        String[] string2 = string1[1].split("\\$");
                        shiftName = string2[0].trim();

                    }
                    if (satWeekOff == true && (zydexLocationMaster.getZydexLocation().equals("HO") || zydexLocationMaster.getZydexLocation().equals("R&D"))) {
                        secondHalfList.add("WO");
                    } else if (secondHalf.equals("AR")) {
                        secondHalfList.add("AR/P");
                    } else if (checkLunchTime == true && totalTime < shiftdiffMinutes && !secondHalf.contains("AR") && !secondHalf.contains("Short Leave")) {
                        secondHalfList.add("AB");
                    } else if (secondHalf.contains("fullday")) {
                        secondHalfList.add("PR");;

                    } else if (!secondHalf.contains("fullday") && !secondHalf.equals("WO") && !secondHalf.equals("TR") && !secondHalf.equals("AR") && !secondHalf.equals("AB") && !secondHalf.contains("?")
                            && !secondHalf.equals("Casual Leave") && !secondHalf.equals("Short Leave") && !secondHalf.equals("C Off Leave") && !secondHalf.equals("Privilege Leave") && !secondHalf.equals("Sick Leave")
                            && !secondHalf.equals("Paternity Leave") && !secondHalf.equals("Maternity Leave") && !secondHalf.equals("Leave Without Pay")) {
                        String[] leave = secondHalf.split("@");
                        String[] leave1 = leave[1].split("#");
                        String[] userTimeInStr = secondHalf.split("`");
                        String[] userTimeInStr1 = userTimeInStr[1].split("!");
                        String[] userTimeOutStr = secondHalf.split("!");
                        String[] userTimeOutStr1 = userTimeOutStr[1].split("@");
                        String[] secondHalfTimeStr = secondHalf.split("\\^");
                        String[] secondHalfTimeStr1 = secondHalfTimeStr[1].split("&");
                        String[] endHoursStr = secondHalf.split("&");
                        String[] startHoursStr = secondHalf.split("%");
                        String[] firstStartHoursStr = startHoursStr[1].split("\\+");

                        Date userTimeIn = sdf2.parse(userTimeInStr1[0]);
                        Date userTimeOut = sdf2.parse(userTimeOutStr1[0]);
                        Date userTimeOut1 = sdf2.parse("23:59");
                        Date firstStartHours = sdf2.parse(firstStartHoursStr[1]);
                        String[] getInHours = userTimeInStr1[0].split(":");
                        String[] getOutHours = userTimeOutStr1[0].split(":");
                        String abc = getInHours[0].trim();
                        String xyz = getOutHours[0].trim();
                        int i11 = Integer.parseInt(abc) - Integer.parseInt(xyz);
                        int totalDuration = 24 - i11;
                        String totalDuration2 = getOutHours[0];
                        Date endHours = sdf2.parse(endHoursStr[1]);
                        Date secondHalfTimeStr2 = sdf2.parse(secondHalfTimeStr1[0]);

                        Calendar cal1 = Calendar.getInstance();
                        Calendar cal2 = Calendar.getInstance();
                        cal1.setTime(firstStartHours);
                        cal1.add(Calendar.MINUTE, -earlyMinute);
                        cal2.setTime(firstStartHours);
                        cal2.add(Calendar.MINUTE, lateMinute);
                        String newTime = sdf2.format(cal2.getTime());
                        Date flexibleEndTime = sdf2.parse(newTime);

                        String newTime1 = sdf2.format(cal1.getTime());
                        Date flexibleInTime = sdf2.parse(newTime1);
                        long diff = endHours.getTime() - firstStartHours.getTime();
                        long diffMinutes = diff / (60 * 1000);
                        long diff1 = 0;
                        if (userTimeIn.after(flexibleInTime) || userTimeIn.equals(flexibleInTime)) {
                            if (userTimeOut.before(userTimeIn)) {
                                diff1 = userTimeOut1.getTime() - userTimeIn.getTime();
                            } else {
                                diff1 = userTimeOut.getTime() - userTimeIn.getTime();
                            }

                        } else if (userTimeOut.before(userTimeIn)) {
                            diff1 = userTimeOut1.getTime() - flexibleInTime.getTime();
                        } else {
                            diff1 = userTimeOut.getTime() - flexibleInTime.getTime();
                        }
                        long diffMinutes1 = diff1 / (60 * 1000);

                        if (userTimeIn != null) {
                            if (leave1[0].contains("AR")) {
                                secondHalfList.add("AR/P");

                            } else if (null != leave1[0] && leave1[0].contains("Short Leave")) {
                                if (secondHalf.contains("*")) {
                                    String[] shortArray = secondHalf.split("\\*");
                                    String[] endArray = secondHalf.split("\\^");
                                    String[] secondhalfstartTime = endArray[1].split("&");
                                    Date shortIn = sdf2.parse(shortArray[1]);
                                    Date shortend = sdf2.parse(endArray[1]);
                                    Date secondhalfstartTime1 = sdf2.parse(secondhalfstartTime[0]);
                                    if ((secondhalfstartTime1.before(shortIn) || secondhalfstartTime1.equals(shortIn)) && (shortIn.before(endHours) || shortIn.equals(endHours))) {
                                        if (userTimeOut.after(secondHalfTimeStr2)) {
                                            secondHalfList.add("SHL/P");
                                        } else if (leave1[0].contains("~ AR")) {
                                            secondHalfList.add("AR/P");
                                        } else if (userTimeOut.before(secondHalfTimeStr2) || userTimeOut.equals(secondHalfTimeStr2)) {
                                            secondHalfList.add("SHL/A");
                                        } else {
                                            secondHalfList.add("AB");
                                        }
                                    } else if (diffMinutes1 >= 240 && userTimeIn.before(secondHalfTimeStr2)) {
                                        secondHalfList.add("PR");
                                    }
                                } else if (diffMinutes1 >= 240 && userTimeIn.before(secondHalfTimeStr2)) {
                                    secondHalfList.add("PR");
                                } else {
                                    secondHalfList.add("AB");
                                }
                            } else if (diffMinutes1 >= diffMinutes && userTimeIn.before(flexibleEndTime)) {
                                secondHalfList.add("PR");
                            } else if (diffMinutes1 <= diffMinutes && userTimeIn.before(flexibleEndTime) && !secondHalf.contains("WO") && !secondHalf.contains("TR") && !secondHalf.contains("AR") && !secondHalf.contains("?")
                                    && !secondHalf.contains("Casual Leave") && !secondHalf.contains("Short Leave") && !secondHalf.equals("C Off Leave") && !secondHalf.contains("Privilege Leave") && !secondHalf.contains("Sick Leave")
                                    && !secondHalf.contains("Paternity Leave") && !secondHalf.contains("Maternity Leave") && !secondHalf.contains("Leave Without Pay")) {
                                secondHalfList.add("AB");
                            } else if (diffMinutes1 >= 240 && userTimeIn.after(secondHalfTimeStr2)) {
                                secondHalfList.add("PR");
                            } else if ((userTimeIn.before(secondHalfTimeStr2) || userTimeIn.equals(secondHalfTimeStr2)) && (userTimeOut.after(endHours) || userTimeOut.equals(endHours))) {
                                secondHalfList.add("PR");
                            } else if (shiftName.contains("Night") && (userTimeOut.after(endHours) || userTimeOut.equals(endHours))) {
                                secondHalfList.add("PR");
                            } else if (null != leave1[0] && !leave1[0].contains("AB") && !leave1[0].contains("AR")) {
                                if (leave1[0].contains("Casual Leave")) {
                                    secondHalfList.add("Casual Leave");
                                }
                                if (leave1[0].contains("Privilege Leave")) {
                                    secondHalfList.add("Privilege Leave");
                                }
                                if (leave1[0].contains("Sick Leave")) {
                                    secondHalfList.add("Sick Leave");
                                }
                                if (leave1[0].contains("Maternity Leave")) {
                                    secondHalfList.add("Maternity Leave");
                                }
                                if (leave1[0].contains("Paternity Leave")) {
                                    secondHalfList.add("Paternity Leave");
                                }
                                if (leave1[0].contains("C Off Leave")) {
                                    secondHalfList.add("C Off Leave");
                                }
                                if (leave1[0].contains("Leave Without Pay")) {
                                    secondHalfList.add("Leave Without Pay");
                                }

                            } else if (leave1[0].contains("AB")) {
                                secondHalfList.add("AB");
                            } else {
                                secondHalfList.add("AB");
                            }

                        } else if (userTimeIn != null && !secondHalf.contains("WO") && !secondHalf.contains("?")) {
                            secondHalfList.add("AB");
                        } else if (secondHalf.contains("WO") || secondHalf.contains("?")) {
                            secondHalfList.add("-");
                        }

                    } else if (secondHalf.equals("WO")) {
                        secondHalfList.add("-");
                    } else if (secondHalf.equals("AB")) {
                        secondHalfList.add("AB");
                    } else if (secondHalf.contains("?")) {
                        secondHalfList.add("-");
                    } else if (secondHalf.equals("Casual Leave") || secondHalf.equals("Privilege Leave") || secondHalf.equals("Sick Leave")
                            || secondHalf.equals("Maternity Leave") || secondHalf.equals("Paternity Leave") || secondHalf.equals("C Off Leave")
                            || secondHalf.equals("Leave Without Pay")) {
                        //2nd Half:              Half day absent Code when start date is full and end date is first half  start Code
                        if (diffInDays % 1 == 0) {
                            secondHalfList.add("-");
                        } else {
                            secondHalfList.add("AB");
                        }
// 2nd Half:              Half day absent Code when start date is full and end date is first half  end Code
//                            secondHalfList.add("-");

                    }
                } catch (Exception e) {

                }
            }

            Iterator itr7 = entry.getValue().iterator();
            while (itr7.hasNext()) {
                try {
                    Object[] next = (Object[]) itr7.next();
                    String secondHalf = "" + next[1];
                    int firstHalfVal = 0;
                    int counter = 0;
                    String shiftName = "";

                    List listPunch = employeeDatetimeDataService.readPuchDataDateWise("" + next[0], Integer.parseInt(id));
                    List mobPunchlist = employeePunchForMobileAppService.readPuchDataDateWise("" + next[0], Integer.parseInt(id));
                    long lunchTime = 0;
                    long outTime = 0;
                    long totalDayTime = 0;
                    long totalDayTime1 = 0;
                    long totalTime = 0;
                    long shiftdiffMinutes = 0;
                    boolean checkLunchTime = false;
                    int i = 1;
                    int j = 2;
                    String startTime = "";
                    String endTime = "";
                    SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                    if (listPunch.size() > 0 && !secondHalf.equals("WO") && !secondHalf.equals("AB") && !secondHalf.equals("TR") && !secondHalf.equals("AR")) {
                        ZydexLocationMaster zydexLocationMaster = zydexLocationMasterService.readById(employeeMaster1.getZydexLocationMaster().getId());
                        if (zydexLocationMaster.getId() == 1 || zydexLocationMaster.getId() == 6) {
                            if (listPunch.size() > 2) {
                                while (listPunch.size() > i && listPunch.size() > j) {

                                    Object[] startLunchTime = (Object[]) listPunch.get(i);
                                    Object[] endLunchTime = (Object[]) listPunch.get(j);
                                    startTime = (String) startLunchTime[0];
                                    endTime = (String) endLunchTime[0];
                                    Date launchStrTime = sdf3.parse(startTime);
                                    Date launchEndTime = sdf3.parse(endTime);
                                    long diff = launchEndTime.getTime() - launchStrTime.getTime();
                                    lunchTime = diff / (60 * 1000);
                                    outTime = outTime + lunchTime;
                                    i = i + 2;
                                    j = j + 2;
                                }
                            }
                        }

                        String[] userTimeInStr = secondHalf.split("`");
                        String[] userTimeInStr1 = userTimeInStr[1].split("!");
                        String[] userTimeOutStr = secondHalf.split("!");
                        String[] userTimeOutStr1 = userTimeOutStr[1].split("@");
                        Date userTimeIn = sdf2.parse(userTimeInStr1[0]);
                        Date userTimeOut = sdf2.parse(userTimeOutStr1[0]);

                        Date userTimeOut1 = sdf2.parse("24:00");
                        Date userTimeon12 = sdf2.parse("00:00");
                        String[] startHoursStr = secondHalf.split("%");
                        String[] firstStartHoursStr = startHoursStr[1].split("\\+");
                        String[] endHoursStr = secondHalf.split("&");
                        Date firstStartHours = sdf2.parse(firstStartHoursStr[1]);
                        Calendar cal1 = Calendar.getInstance();
                        cal1.setTime(firstStartHours);
                        cal1.add(Calendar.MINUTE, -earlyMinute);
                        String newTime1 = sdf2.format(cal1.getTime());
                        Date flexibleInTime = sdf2.parse(newTime1);
                        Date endHours = sdf2.parse(endHoursStr[1]);
                        long shiftTotalTime = endHours.getTime() - firstStartHours.getTime();
                        shiftdiffMinutes = shiftTotalTime / (60 * 1000);
                        long diff1 = 0;
                        long diff2 = 0;
                        if (zydexLocationMaster.getId() == 1 || zydexLocationMaster.getId() == 6) {
                            if (userTimeIn.after(flexibleInTime) || userTimeIn.equals(flexibleInTime)) {
                                if (userTimeOut.before(userTimeIn)) {
                                    diff1 = userTimeOut1.getTime() - userTimeIn.getTime();
                                } else {
                                    diff1 = userTimeOut.getTime() - userTimeIn.getTime();
                                }

                            } else if (userTimeOut.before(userTimeIn)) {
                                diff1 = userTimeOut1.getTime() - flexibleInTime.getTime();
                            } else {
                                diff1 = userTimeOut.getTime() - flexibleInTime.getTime();
                            }

                            totalDayTime = diff1 / (60 * 1000);

                            if (userTimeOut.before(userTimeIn)) {
                                diff2 = userTimeOut1.getTime() - userTimeIn.getTime();
                            } else {
                                diff2 = userTimeOut.getTime() - userTimeIn.getTime();
                            }

                            totalDayTime1 = diff2 / (60 * 1000);

//                                        ===============30 minute lunch time 4 all employeee so who goes out side cut 30 min from their lunch time===============
//                                        =========================For who goes out side 4 lunch they have max 60 min time for lunch=======================
//                                        =========================For who goes out side 4 lunch they have max 60 min time for lunch=======================
                            long outTime1 = outTime;
                            outTime = outTime - 30;
//                                        ===============30 minute lunch time 4 all employeee so who goes out side cut 30 min from their lunch time===============
                            ///////////////AR code Start///////////////////////////////////////////////////
                            AttendanceRegularization attendanceRegularization = new AttendanceRegularization();
                            attendanceRegularization.setStartDateTime("" + next[0]);
                            attendanceRegularization.setUserMasterId(employeeMaster1.getUserMaster().getId());
                            long ARdiff = 0;
                            long ARTime = 0;
                            SimpleDateFormat sdf4 = new SimpleDateFormat("dd/mm/yyyy HH:mm");
                            List list = attendanceRegularizationMasterService.readArCountList(attendanceRegularization);
                            if (!list.isEmpty()) {
                                Object[] arm = (Object[]) list.get(0);
                                Date InTimeAR = sdf4.parse(arm[1].toString());
                                Date OutTimeAR = sdf4.parse(arm[2].toString());

                                ARdiff = OutTimeAR.getTime() - InTimeAR.getTime();
                                ARTime = ARdiff / (60 * 1000);

                            }
                            ///////////////AR code End////////////////////////////////////////
                            totalDayTime = totalDayTime + ARTime;
                            if (outTime > 0 && outTime1 != totalDayTime1) {
                                totalTime = totalDayTime - outTime;
                                double empHour = (double) totalTime / 60;
                                int hours = (int) empHour;
                                int minutes = (int) (empHour * 60) % 60;
                                String hour = "" + hours;
                                String minute = "" + minutes;
                                if (minutes < 10 && minutes > 0) {
                                    minute = "0" + minute;
                                } else if (minutes < 0) {
                                    minute = "00";
                                }
                                String workingHours = hour + ":" + minute;
                                workingHour.add(workingHours);

                            } else {
                                double empHour = (double) totalDayTime / 60;
                                int hours = (int) empHour;
                                int minutes = (int) (empHour * 60) % 60;
                                String hour = "" + hours;
                                String minute = "" + minutes;
                                if (minutes < 10 && minutes > 0) {
                                    minute = "0" + minute;
                                } else if (minutes < 0) {
                                    minute = "00";
                                }
                                String workingHours = hour + ":" + minute;
                                workingHour.add(workingHours);
                            }

                        } else {

                            if (userTimeIn.after(flexibleInTime) || userTimeIn.equals(flexibleInTime)) {
                                if (userTimeOut.before(userTimeIn)) {
                                    diff1 = userTimeOut1.getTime() - userTimeIn.getTime();
                                } else {
                                    diff1 = userTimeOut.getTime() - userTimeIn.getTime();
                                }

                            } else if (userTimeOut.before(userTimeIn)) {
                                diff1 = userTimeOut1.getTime() - flexibleInTime.getTime();
                            } else {
                                diff1 = userTimeOut.getTime() - flexibleInTime.getTime();
                            }

                            totalDayTime = diff1 / (60 * 1000);

                            if (userTimeOut.before(userTimeIn)) {

                                diff2 = userTimeOut.getTime() - userTimeon12.getTime();
//                                diff2 = userTimeOut1.getTime() - userTimeIn.getTime();
                            } else {
//                                diff2 = userTimeOut.getTime() - userTimeIn.getTime();
                            }
                            ///////////////AR code Start///////////////////////////////////////////////////
                            AttendanceRegularization attendanceRegularization = new AttendanceRegularization();
                            attendanceRegularization.setStartDateTime("" + next[0]);
                            attendanceRegularization.setUserMasterId(employeeMaster1.getUserMaster().getId());
                            long ARdiff = 0;
                            long ARTime = 0;
                            SimpleDateFormat sdf4 = new SimpleDateFormat("dd/mm/yyyy HH:mm");
                            List list = attendanceRegularizationMasterService.readArCountList(attendanceRegularization);
                            if (!list.isEmpty()) {
                                Object[] arm = (Object[]) list.get(0);
                                Date InTimeAR = sdf4.parse(arm[1].toString());
                                Date OutTimeAR = sdf4.parse(arm[2].toString());

                                ARdiff = OutTimeAR.getTime() - InTimeAR.getTime();
                                ARTime = ARdiff / (60 * 1000);

                            }
                            ///////////////AR code End////////////////////////////////////////
                            totalDayTime1 = diff2 / (60 * 1000);

                            totalDayTime = totalDayTime + totalDayTime1 + ARTime;

                            double empHour = (double) totalDayTime / 60;
                            int hours = (int) empHour;
                            int minutes = (int) (empHour * 60) % 60;
                            String hour = "" + hours;
                            String minute = "" + minutes;
                            if (minutes < 10 && minutes > 0) {
                                minute = "0" + minute;
                            } else if (minutes < 0) {
                                minute = "00";
                            }

                            String workingHours = hour + ":" + minute;
                            workingHour.add(workingHours);

                        }

                    } else if (null != mobPunchlist && mobPunchlist.size() > 0 && !secondHalf.equals("WO") && !secondHalf.equals("AB") && !secondHalf.equals("TR") && !secondHalf.equals("AR")) {
                        if (mobPunchlist.size() > 2) {
                            while (mobPunchlist.size() > i && mobPunchlist.size() > j) {

                                Object[] startLunchTime = (Object[]) mobPunchlist.get(i);
                                Object[] endLunchTime = (Object[]) mobPunchlist.get(j);
                                startTime = (String) startLunchTime[0];
                                endTime = (String) endLunchTime[0];
                                Date launchStrTime = sdf3.parse(startTime);
                                Date launchEndTime = sdf3.parse(endTime);
                                long diff = launchEndTime.getTime() - launchStrTime.getTime();
                                lunchTime = diff / (60 * 1000);
                                outTime = outTime + lunchTime;
                                i = i + 2;
                                j = j + 2;
                            }
                        }

                        String[] userTimeInStr = secondHalf.split("`");
                        String[] userTimeInStr1 = userTimeInStr[1].split("!");
                        String[] userTimeOutStr = secondHalf.split("!");
                        String[] userTimeOutStr1 = userTimeOutStr[1].split("@");
                        Date userTimeIn = sdf2.parse(userTimeInStr1[0]);
                        Date userTimeOut = sdf2.parse(userTimeOutStr1[0]);
                        Date userTimeOut1 = sdf2.parse("23:59");
                        String[] startHoursStr = secondHalf.split("%");
                        String[] firstStartHoursStr = startHoursStr[1].split("\\+");
                        String[] endHoursStr = secondHalf.split("&");
                        Date firstStartHours = sdf2.parse(firstStartHoursStr[1]);
                        Calendar cal1 = Calendar.getInstance();
                        cal1.setTime(firstStartHours);
                        cal1.add(Calendar.MINUTE, -earlyMinute);
                        String newTime1 = sdf2.format(cal1.getTime());
                        Date flexibleInTime = sdf2.parse(newTime1);
                        Date endHours = sdf2.parse(endHoursStr[1]);
                        long shiftTotalTime = endHours.getTime() - firstStartHours.getTime();
                        shiftdiffMinutes = shiftTotalTime / (60 * 1000);
                        long diff1 = 0;
                        long diff2 = 0;
                        if (userTimeIn.after(flexibleInTime) || userTimeIn.equals(flexibleInTime)) {
                            if (userTimeOut.before(userTimeIn)) {
                                diff1 = userTimeOut1.getTime() - userTimeIn.getTime();
                            } else {
                                diff1 = userTimeOut.getTime() - userTimeIn.getTime();
                            }

                        } else if (userTimeOut.before(userTimeIn)) {
                            diff1 = userTimeOut1.getTime() - flexibleInTime.getTime();
                        } else {
                            diff1 = userTimeOut.getTime() - flexibleInTime.getTime();
                        }

                        totalDayTime = diff1 / (60 * 1000);

                        if (userTimeOut.before(userTimeIn)) {
                            diff2 = userTimeOut1.getTime() - userTimeIn.getTime();
                        } else {
                            diff2 = userTimeOut.getTime() - userTimeIn.getTime();
                        }

                        totalDayTime1 = diff2 / (60 * 1000);

//                                        ===============30 minute lunch time 4 all employeee so who goes out side cut 30 min from their lunch time===============
//                                        =========================For who goes out side 4 lunch they have max 60 min time for lunch=======================
//                                        =========================For who goes out side 4 lunch they have max 60 min time for lunch=======================
                        long outTime1 = outTime;
                        outTime = outTime - 30;
//                                        ===============30 minute lunch time 4 all employeee so who goes out side cut 30 min from their lunch time===============
                        if (outTime > 0 && outTime1 != totalDayTime1) {
                            totalTime = totalDayTime - outTime;
                            double empHour = (double) totalTime / 60;
                            int hours = (int) empHour;
                            int minutes = (int) (empHour * 60) % 60;
                            String hour = "" + hours;
                            String minute = "" + minutes;
                            if (minutes < 10 && minutes > 0) {
                                minute = "0" + minute;
                            } else if (minutes < 0) {
                                minute = "00";
                            }
                            String workingHours = hour + ":" + minute;
                            workingHour.add(workingHours);

                        } else {
                            double empHour = (double) totalDayTime / 60;
                            int hours = (int) empHour;
                            int minutes = (int) (empHour * 60) % 60;
                            String hour = "" + hours;
                            String minute = "" + minutes;
                            if (minutes < 10 && minutes > 0) {
                                minute = "0" + minute;
                            } else if (minutes < 0) {
                                minute = "00";
                            }
                            String workingHours = hour + ":" + minute;
                            workingHour.add(workingHours);
                        }
                    } else {
                        workingHour.add("-");
                    }
                } catch (Exception e) {
                    workingHour.add("-");

                }

            }

        }

//        List<?> attendanceDateList =
//        List<?> l1 = null;
//        if (("".equals(startDate) || null == startDate) || ("".equals(endDate) || null == endDate)) {
//            empDetail = l1;
//        }
        mv.getModelMap()
                .put("firstHalfList", newList);
        mv.getModelMap()
                .put("secondHalfList", secondHalfList);
        mv.getModelMap()
                .put("workingHour", workingHour);
        mv.getModelMap()
                .put("empDetail", empDetail);
        mv.getModelMap()
                .put("map", map);
        mv.getModelMap()
                .put("woMap", woMap);
        mv.getModelMap()
                .put("satMap", satMap);
        mv.getModelMap()
                .put("halfDayMap", halfDayMap);
        mv.getModelMap()
                .put("employeeAdvanceSearch", employeeAdvanceSearch);
        Date notflexibleSupportDate;

        if (startDate.contains(
                "-")) {
            notflexibleSupportDate = sdf1.parse(startDate);
        } else {
            notflexibleSupportDate = sdf.parse(startDate);
        }
        String FixedFlexibleDate = "01/04/2016";
        Date notflexibleSupportDate1 = sdf.parse(FixedFlexibleDate);
        Calendar calForFlexiNotSupport1 = Calendar.getInstance();
        Calendar calForFlexiNotSupport2 = Calendar.getInstance();

        calForFlexiNotSupport1.setTime(notflexibleSupportDate);

        calForFlexiNotSupport2.setTime(notflexibleSupportDate1);
        request.setAttribute("id", id);
        if (flexible == true) {
//        if (flexible == true) {
            mv.setViewName("Shift/EmployeeFlexibleDayWisePunchDataReportOfAll");

        } else {
            mv.setViewName("Shift/EmployeeIndividualOrDateWiseShiftSearchForAll");
        }

        return mv;
    }

    public void checkPunchtime(HttpServletRequest request, HttpServletResponse response) throws ParseException, IOException {
        String strDate = request.getParameter("strDate");
        String message = "";
        strDate = strDate.replaceAll(",", "/");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date sDate = sdf.parse(strDate);
        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
        EmployeeShiftData employeeShiftData = new EmployeeShiftData();
        employeeShiftData.setEmployeeMaster(employeeMaster);
        List<?> timecheck = employeeShiftDataService.readByEmployeeId(employeeShiftData, strDate);
        if (timecheck.isEmpty()) {
            message = "Selected Date and Time is not valid.So You can't Apply AR";
        }
        PrintWriter out = response.getWriter();
        out.print(message);
    }

    public ModelAndView showDateWisePunchDataOfSubordinate(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String date = request.getParameter("date");
        String empId = request.getParameter("id");
        List<?> punchList = employeeDatetimeDataService.readPuchDataDateWise(date, Integer.parseInt(empId));
        if (punchList.isEmpty()) {
            List<?> MobPunchList = employeePunchForMobileAppService.readPuchDataDateWise(date, Integer.parseInt(empId));
            mv.getModelMap().put("punchList", MobPunchList);
        } else {
            mv.getModelMap().put("punchList", punchList);

        }
        mv.setViewName("Shift/ShowIndividualPuchData");

        return mv;
    }

    public ModelAndView showDateWisePunchDataOfAllEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String date = request.getParameter("date");
        String empId = request.getParameter("id");
        List<?> punchList = employeeDatetimeDataService.readPuchDataDateWiseAll(date, Integer.parseInt(empId));
        if (punchList.isEmpty()) {
            List<?> MobPunchList = employeePunchForMobileAppService.readPuchDataDateWise(date, Integer.parseInt(empId));
            mv.getModelMap().put("punchList", MobPunchList);
        } else {
            mv.getModelMap().put("punchList", punchList);

        }
        request.setAttribute("date1", date);
        request.setAttribute("empId1", empId);
        mv.setViewName("Shift/ShowAllEmployeePuchData");

        return mv;
    }

    public ModelAndView viewClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeDatetimeData employeeDatetimeData = new EmployeeDatetimeData();
        String id = request.getParameter("id");
        employeeDatetimeData = employeeDatetimeDataService.readById(Integer.parseInt(id));

        mv.getModelMap().put("employeeDatetimeData", employeeDatetimeData);
        mv.setViewName("AttendanceRegularization/AllPunchView");
        return mv;
    }

    public ModelAndView editSubmit1(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeDatetimeData employeeDatetimeData = new EmployeeDatetimeData();
        bind(request, employeeDatetimeData);

        employeeDatetimeDataService.update(employeeDatetimeData);
        log(request, ActionType.UPDATE.toString(),
                "Date time Updated -."
                + employeeDatetimeData.getId());
        request.setAttribute("successMessage",
                "Information: The Date and time is Updated successfully");

        mv.getModelMap().put("employeeDatetimeData", employeeDatetimeData);
        mv.setViewName("AttendanceRegularization/AllPunchView");
        return mv;
    }

    public ModelAndView deleteSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String leaveTypeId[] = request.getParameterValues("checkId");
        for (String z : leaveTypeId) {
            try {
                employeeDatetimeDataService.delete(Integer.parseInt(z));
                request.setAttribute("successMessage",
                        "Info : One or more records are deleted successfully.");
            } catch (Exception e) {

            }
        }
        mv = showDateWisePunchDataOfAllEmployee(request, response);
        return mv;
    }

    public ModelAndView departmentWiseAttendanceView(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        List<?> list = employeeMasterService.readDepartmentWiseEmployee(employeeMaster);
        mv.getModelMap().put("list", list);
        mv.setViewName("AttendanceRegularization/SubOrdinateAttendanceView");
        return mv;
    }

    public ModelAndView textReadModule(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("AttendanceRegularization/AttendanceReadTextFile");
        return mv;
    }

    public ModelAndView readTextFile(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile readTextFile = multipartRequest.getFile("file1");
        String readTextFile1 = readTextFile.getOriginalFilename();
//        String textfile;
//        File files = readTextFile.getInputStream();
        File dir = new File(readTextFile.toString());

        if (readTextFile.getSize() > 0) {
            int count = 0;
            BufferedReader inputStream = null;
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            List Finalarr = new ArrayList();
            String EmpId = "";
            String EmpId2 = "";
            String date = "";
            String dateTime = "";
            String punchDateTime = "";

            try {
                InputStream file = readTextFile.getInputStream();
                inputStream = new BufferedReader((new InputStreamReader(file, "UTF-8")));
                String line;
                String[] splitStr;
                while ((line = inputStream.readLine()) != null) {
                    if (count != 0) {
                        List arr = new ArrayList();
                        splitStr = line.split("\\s+");
//                        if (splitStr[3] == "" || splitStr[1] == null || splitStr[1] == "" || splitStr[2] == null || splitStr[2] == "" || splitStr[0] == "I") {
                        EmpId = splitStr[3];

                        date = splitStr[1];
                        String year = date.substring(0, 4);
                        String month = date.substring(4, 6);
                        String day = date.substring(6, 8);
                        String yearMonthDay = day + "/" + month + "/" + year;

                        dateTime = yearMonthDay + " " + splitStr[2];
//                        List<EmployeeMaster> emplist = (List<EmployeeMaster>) employeeMasterService.readByEmployeeId((EmpId.substring(4)));
                        List<EmployeeMaster> emplist = (List<EmployeeMaster>) employeeMasterService.readByEmployeeId((EmpId));
                        if (!emplist.isEmpty()) {
                            EmployeeMaster em = emplist.get(0);
                            int employeemasterId = em.getId();
                            EmployeeDatetimeData datetimeData = new EmployeeDatetimeData();
                            datetimeData.setEmployeeMaster(em);
                            datetimeData.setDateTime(dateTime);
                            employeeDatetimeDataService.create(datetimeData);

                        }

//                        }
                    }
                    count++;

                }
            } catch (Exception e) {
                request.setAttribute("failureMessage", "Information : The Excel Not Upload Successfully. Please Check Excel Data.");
                mv = textReadModule(request, response);
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }
            }
        }
        request.setAttribute("successMessage", "Information : The Excel Uploaded Successfully.");
        mv = textReadModule(request, response);
        return mv;
    }

    public void differentForSDate(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String strDate = request.getParameter("strDate");
        String enDate = request.getParameter("enDate");

//        strDate = strDate.replaceAll(",", "/");
////        enDate = enDate.replaceAll(",", "/");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
//        Date sDate = sdf.parse(strDate);
//        Date eDate = sdf.parse(enDate);
        String message = "";
        Date loginStartDate = sdf.parse(strDate);
        Date loginEndDate = sdf.parse(enDate);
        long diff = loginEndDate.getTime() - loginStartDate.getTime();
        long diffMinutes = diff / (60 * 1000);
        int minute = (int) (diffMinutes % 60);
        int hour = (int) (diffMinutes / 60);
        message = hour + ":" + minute;
//        HttpSession session = request.getSession();
//        EmployeeMaster employeeMaster1 = (EmployeeMaster) session.getAttribute("employeeInfo");

//        }
        PrintWriter out = response.getWriter();
        out.print(message);
    }

}
