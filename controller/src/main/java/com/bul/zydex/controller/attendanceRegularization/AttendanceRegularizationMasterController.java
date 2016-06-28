package com.bul.zydex.controller.attendanceRegularization;

import com.bul.zydex.model.AttendanceRegularization;
import com.bul.zydex.model.AttendanceRegularizationMaster;
import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.model.EmailTemplate;
import com.bul.zydex.model.EmployeeAdvanceSearch;
import com.bul.zydex.model.EmployeeDatetimeData;
import com.bul.zydex.model.EmployeeLeaveBalance;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.EmployeeShiftData;
import com.bul.zydex.model.LeaveTypeMaster;
import com.bul.zydex.model.LevelMaster;
import com.bul.zydex.model.OverTimeMaster;
import com.bul.zydex.model.TimeAttandanceFlaxibleMaster;
import com.bul.zydex.model.UserMaster;
import com.bul.zydex.model.UserRightMaster;
import com.bul.zydex.model.ZydexLocationMaster;
import com.bul.zydex.model.support.User;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static org.apache.commons.lang3.time.DateUtils.addDays;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.util.CellUtil;
import org.springframework.validation.BindException;
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
            attendanceRegularization.setUserMasterId(userMasterId);
            attendanceRegularization.setStatus(0);
            attendanceRegularizationMasterService.createOrUpdate(attendanceRegularization);
            request.setAttribute("successMessage",
                    "Information : The Information is saved Successfully.");

            mv.setViewName("redirect:attendanceRegularizationMaster.htm?act=searchSubmit");
            try {
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
        List<?> list = attendanceRegularizationMasterService.readByAttendanceRegularizationPendingList(id);
        int attendaceRegularizationPending = list.size();
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
        if (null != employeeMaster.getId() && !employeeMaster.getId().equals("")) {
            employeeShiftData.setId(employeeMaster.getId());
        }
        employeeAdvanceSearch.setEmployeeId(Boolean.FALSE);
        employeeAdvanceSearch.setEmployeeName(Boolean.FALSE);
        employeeAdvanceSearch.setFatherName(Boolean.FALSE);
        employeeAdvanceSearch.setMotherName(Boolean.FALSE);

        employeeAdvanceSearch.setGender(Boolean.FALSE);
        employeeAdvanceSearch.setMaritalStatus(Boolean.FALSE);
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
            int id1 = (Integer) o[47];
            employeeShiftData.setId(id1);
            List<?> list = employeeShiftDataService.empOrDateWiseSearch(employeeShiftData);
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
            int firstCounter = 0;

            while (itr5.hasNext()) {
                Object[] next = (Object[]) itr5.next();
                String firstHalf = "" + next[1];
                int firstHalfVal = 0;
                int counter = 0;

                if (firstHalf.contains("fullday")) {
                    newList.add("PR");

                } else if (!firstHalf.contains("fullday") && !firstHalf.equals("WO") && !firstHalf.equals("TR") && !firstHalf.equals("AR") && !firstHalf.equals("AB") && !firstHalf.contains("?")
                        && !firstHalf.equals("Casual Leave") && !firstHalf.equals("Privilege Leave") && !firstHalf.equals("Sick Leave")
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
                    cal.add(Calendar.MINUTE, lateMinute);
                    cal1.add(Calendar.MINUTE, -earlyMinute);

                    String newTime = sdf2.format(cal.getTime());
                    String newTime1 = sdf2.format(cal1.getTime());
                    Date flexibleEndTime = sdf2.parse(newTime);
                    Date flexibleStartTime = sdf2.parse(newTime1);
                    Date LateHours = sdf2.parse(LateHoursStr1[0]);
                    long diff = endHours.getTime() - firstStartHours.getTime();
                    long diffMinutes = diff / (60 * 1000);
                    long diff1 = 0;
                    if (userTimeIn.after(flexibleStartTime) || userTimeIn.equals(flexibleStartTime)) {
                        diff1 = endHours.getTime() - userTimeIn.getTime();
                    } else {
                        diff1 = endHours.getTime() - flexibleStartTime.getTime();
                    }
                    long diffMinutes1 = diff1 / (60 * 1000);

                    if (userTimeIn != null) {
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
                            } else if (leave1[0].contains("Casual Leave")) {
                                newList.add("Casual Leave");
                            } else if (leave1[0].contains("Privilege Leave")) {
                                newList.add("Privilege Leave");
                            } else if (leave1[0].contains("Sick Leave")) {
                                newList.add("Sick Leave");
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
                                    secondHalfList.add("AR/P");
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
                            }
                            if (leave1[0].contains("Privilege Leave")) {
                            }
                            if (leave1[0].contains("Sick Leave")) {
                                newList.add(" " + leave1[0]);

                            } else if (leave1[0].contains("AB")) {
                                newList.add(" " + leave1[0]);
                            }
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
                } else if (firstHalf.equals("Casual Leave") || firstHalf.equals("Privilege Leave") || firstHalf.equals("Sick Leave")
                        || firstHalf.equals("Paternity Leave") || firstHalf.equals("Maternity Leave") || firstHalf.equals("Leave Without Pay") || firstHalf.contains("TR")) {
                    newList.add("-");
                }
            }

            Iterator itr6 = entry.getValue().iterator();
            int weekNameCounter = 0;
            while (itr6.hasNext()) {
                Object[] next = (Object[]) itr6.next();
                String secondHalf = "" + next[1];
                int firstHalfVal = 0;
                int counter = 0;
                String shiftName = "";

                boolean satWeekOff = false;
                //                                    2nd Sat Week Off Codding
                Calendar cal = Calendar.getInstance();
                Date date = sdf.parse("" + next[0]);
                cal.setTime(date);
                SimpleDateFormat format = new SimpleDateFormat("EEEE");
                String dayName = format.format(date);
                EmployeeMaster employeeMaster1 = employeeMasterService.readById(id);
                ZydexLocationMaster zydexLocationMaster = zydexLocationMasterService.readById(employeeMaster1.getZydexLocationMaster().getId());

                if (dayName.equals("Saturday")) {
                    weekNameCounter++;
                    if (weekNameCounter == 2) {
                        satWeekOff = true;
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
                } else if (checkLunchTime == true && totalTime < shiftdiffMinutes && !secondHalf.contains("AR")) {
                    secondHalfList.add("AB");
                } else if (secondHalf.contains("fullday")) {
                    secondHalfList.add("PR");

                } else if (!secondHalf.contains("fullday") && !secondHalf.equals("WO") && !secondHalf.equals("TR") && !secondHalf.equals("AR") && !secondHalf.equals("AB") && !secondHalf.contains("?")
                        && !secondHalf.equals("Casual Leave") && !secondHalf.equals("Privilege Leave") && !secondHalf.equals("Sick Leave")
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

                    Date userTimeIn = sdf2.parse(userTimeInStr1[0].trim());
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
                    String newTime1 = sdf2.format(cal1.getTime());

                    Date flexibleInTime = sdf2.parse(newTime1);
                    cal2.setTime(firstStartHours);
                    cal2.add(Calendar.MINUTE, lateMinute);
                    String newTime = sdf2.format(cal2.getTime());
                    Date flexibleEndTime = sdf2.parse(newTime);

                    long diff = endHours.getTime() - firstStartHours.getTime();
                    long diffMinutes = diff / (60 * 1000);
                    long diff1 = 0;
                    if (userTimeIn.after(flexibleInTime) || userTimeIn.equals(flexibleInTime)) {
                        if (userTimeOut.before(userTimeIn)) {
                            diff1 = userTimeOut1.getTime() - userTimeIn.getTime();
                        } else {
                            diff1 = userTimeOut.getTime() - userTimeIn.getTime();
                        }
                    } else {
                        if (userTimeOut.before(userTimeIn)) {
                            diff1 = userTimeOut1.getTime() - flexibleInTime.getTime();
                        } else {
                            diff1 = userTimeOut.getTime() - flexibleInTime.getTime();
                        }

                    }
                    long diffMinutes1 = diff1 / (60 * 1000);

                    if (userTimeIn != null) {
                        if (leave1[0].contains("AR")) {
                            secondHalfList.add("AR/P");

                        } else if (diffMinutes1 >= diffMinutes && userTimeIn.before(flexibleEndTime)) {
                            secondHalfList.add("PR");
                        } else if (diffMinutes1 <= diffMinutes && userTimeIn.before(flexibleEndTime) && !secondHalf.contains("WO") && !secondHalf.contains("TR") && !secondHalf.contains("AR") && !secondHalf.contains("?")
                                && !secondHalf.contains("Casual Leave") && !secondHalf.contains("Privilege Leave") && !secondHalf.contains("Sick Leave")
                                && !secondHalf.contains("Paternity Leave") && !secondHalf.contains("Maternity Leave") && !secondHalf.contains("Leave Without Pay")) {
                            secondHalfList.add("AB");
                        } else if (diffMinutes1 >= 240 && userTimeIn.after(secondHalfTimeStr2)) {
                            secondHalfList.add("PR");
                        } else if ((userTimeIn.before(secondHalfTimeStr2) || userTimeIn.equals(secondHalfTimeStr2)) && (userTimeOut.after(endHours) || userTimeOut.equals(endHours))) {
                            secondHalfList.add("PR");
                        } else if (shiftName.contains("Night") && (userTimeOut.after(endHours) || userTimeOut.equals(endHours))) {
                            secondHalfList.add("PR");
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
                                }
                            } else {
                                secondHalfList.add("AB");
                            }
                        } else if (null != leave1[0] && !leave1[0].contains("AB") && !leave1[0].contains("AR")) {
                            if (leave1[0].contains("Casual Leave")) {
                            }
                            if (leave1[0].contains("Privilege Leave")) {
                            }
                            if (leave1[0].contains("Sick Leave")) {
                            }
                            secondHalfList.add(" " + leave1[0].trim());

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
                } else if (secondHalf.equals("Casual Leave") || secondHalf.equals("Privilege Leave") || secondHalf.equals("Sick Leave")
                        || secondHalf.equals("Paternity Leave") || secondHalf.equals("Maternity Leave") || secondHalf.equals("Leave Without Pay") || secondHalf.contains("TR")) {
                    secondHalfList.add("-");
                }
            }

            Iterator itr7 = entry.getValue().iterator();
            while (itr7.hasNext()) {
                Object[] next = (Object[]) itr7.next();
                String secondHalf = "" + next[1];
                int firstHalfVal = 0;
                int counter = 0;
                String shiftName = "";

                List listPunch = employeeDatetimeDataService.readPuchDataDateWise("" + next[0], id);
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

                    } else {
                        if (userTimeOut.before(userTimeIn)) {
                            diff1 = userTimeOut1.getTime() - flexibleInTime.getTime();
                        } else {
                            diff1 = userTimeOut.getTime() - flexibleInTime.getTime();
                        }

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

            }

        }

//        List<?> attendanceDateList =
//        List<?> l1 = null;
//        if (("".equals(startDate) || null == startDate) || ("".equals(endDate) || null == endDate)) {
//            empDetail = l1;
//        }
        mv.getModelMap().put("firstHalfList", newList);
        mv.getModelMap().put("secondHalfList", secondHalfList);
        mv.getModelMap().put("workingHour", workingHour);
        mv.getModelMap().put("empDetail", empDetail);
        mv.getModelMap().put("map", map);
        mv.getModelMap().put("employeeAdvanceSearch", employeeAdvanceSearch);
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

        if (flexible == true && calForFlexiNotSupport2.get(Calendar.MONTH) != calForFlexiNotSupport1.get(Calendar.MONTH)) {
//        if (flexible == true) {
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
            int id = (Integer) o[38];
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
        mv.getModelMap().put("punchList", punchList);
        mv.setViewName("Shift/ShowIndividualPuchData");

        return mv;
    }

    public ModelAndView powerAdminApprovalList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AttendanceRegularization attendanceRegularization = new AttendanceRegularization();
        List<?> list = attendanceRegularizationMasterService.powerAdminAttendanceRegularizationList();
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("attendanceRegularization", attendanceRegularization);
        mv.setViewName("AttendanceRegularization/attendanceRegularizationApprovalResult");
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
        List<?> empDetailList = employeeMasterService.readEmployeeDetailUserIdWise(employeeMaster);
        if (!empDetailList.isEmpty()) {
            request.setAttribute("employeeMaster", empDetailList.get(0));
            Object[] arrayOfObject = (Object[]) empDetailList.get(0);
            String reportmanager = (String) arrayOfObject[6];
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

            // add c-off balance in employee leave balance when day is sunday
            SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
            Date startDate1 = sdf1.parse(startDate);
            Date endDate1 = sdf1.parse(endDate);
            long diff = endDate1.getTime() - startDate1.getTime();
            int days = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
            for (int i = 0; i <= days + 1; i++) {
                String dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(startDate1);
                if (dayOfWeek.equals("Sunday")) {
                    String time = "0.8";

                    OverTimeMaster overTimeMaster = new OverTimeMaster();
                    String overTimeDate = sdf1.format(startDate1);
                    overTimeMaster.setDate(overTimeDate);
                    overTimeMaster.setTime(time);

                    overTimeMaster.setEmployeeMaster(employeeMaster);

                    EmployeeLeaveBalance employeeLeaveBalance = new EmployeeLeaveBalance();
                    EmployeeLeaveBalance employeeLeaveBalance1 = new EmployeeLeaveBalance();
                    LeaveTypeMaster leaveTypeMaster = new LeaveTypeMaster();
                    leaveTypeMaster.setId(11);
                    employeeLeaveBalance.setLeaveTypeMaster(leaveTypeMaster);
                    employeeLeaveBalance.setEmployeeMaster(employeeMaster);
                    EmployeeMaster employeeMaster2 = new EmployeeMaster();
                    employeeMaster2 = employeeMasterService.readById(employeeMaster.getId());
                    int levelId = employeeMaster.getLevelMaster().getId();
                    LevelMaster levelMaster1 = new LevelMaster();
                    levelMaster1 = levelMasterService.readById(levelId);
                    if (employeeMaster.getZydexLocationMaster().getId().equals(5) && levelMaster1.getLevel().contains("Level 4") || levelMaster1.getLevel().contains("Level 5")) {
                        List<?> empBalList = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance);
                        if (!empBalList.isEmpty()) {
                            employeeLeaveBalance1 = (EmployeeLeaveBalance) empBalList.get(0);
                            float time1 = employeeLeaveBalance1.getNoOfLeaveRemain();
                            time1 = time1 + Float.parseFloat(time);
                            employeeLeaveBalance1.setNoOfLeaveRemain(time1);
                            employeeLeaveBalanceService.update(employeeLeaveBalance1);
                        } else {
                            employeeLeaveBalance1.setLeaveTypeMaster(leaveTypeMaster);
                            employeeLeaveBalance1.setEmployeeMaster(employeeMaster);
                            employeeLeaveBalance1.setNoOfLeaveRemain(Float.parseFloat(time));
                            employeeLeaveBalanceService.create(employeeLeaveBalance1);
                        }
                        overTimeMasterService.create(overTimeMaster);
                    }

                }
                Calendar c = Calendar.getInstance();
                c.setTime(startDate1);
                c.add(Calendar.DATE, 1);
                startDate1 = c.getTime();
            }
            // add c-off balance in employee leave balance when day is sunday

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

}
