/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.leave;

import com.bul.zydex.model.COffLeaveMaster;
import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.model.EmailTemplate;
import com.bul.zydex.model.EmployeeLeaveBalance;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.EmployeeShiftData;
import com.bul.zydex.model.HolidayMaster;
import com.bul.zydex.model.HoursBasis;
import com.bul.zydex.model.LeaveEmployeeDetail;
import com.bul.zydex.model.LeaveTypeMaster;
import com.bul.zydex.model.ShiftMaster;
import com.bul.zydex.model.ShiftRotationInfo;
import com.bul.zydex.model.ShiftRotationMaster;
import com.bul.zydex.model.ShortLeave;
import com.bul.zydex.model.UserMaster;
import com.bul.zydex.model.ZydexLocationMaster;
import com.bul.zydex.service.shift.EmployeeShiftDataService;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static org.apache.commons.lang3.time.DateUtils.addDays;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author AJAY
 */
public class LeaveEmployeeDetailController extends LeaveEmployeeDetailAbstract {

    public ModelAndView applyClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        LeaveEmployeeDetail leaveEmployeeDetail1 = new LeaveEmployeeDetail();
        LeaveEmployeeDetail leaveEmployeeDetail = new LeaveEmployeeDetail();
        leaveEmployeeDetail1.setLeaveTypeMaster(new LeaveTypeMaster());
        if (request.getAttribute("leaveEmployeeDetail") != null) {
            leaveEmployeeDetail1 = (LeaveEmployeeDetail) request.getAttribute("leaveEmployeeDetail");
        }
        LeaveTypeMaster leaveTypeMaster = new LeaveTypeMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        EmployeeLeaveBalance employeeLeaveBalance = new EmployeeLeaveBalance();
        addleaveType(request);
        UserMaster user = (UserMaster) request.getSession().getAttribute("user");
        EmployeeMaster employeeSession = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        ShortLeave shortLeave = new ShortLeave();
        shortLeave.setZydexLocationMaster(employeeSession.getZydexLocationMaster());
        List list = shortLeaveService.readByDept(shortLeave);
        try {
            shortLeave = (ShortLeave) list.get(0);
            request.setAttribute("shortLeaveHoursNo", shortLeave.getHoursNo());
        } catch (Exception e) {
        }
        COffLeaveMaster cOffLeaveMaster = new COffLeaveMaster();
        cOffLeaveMaster.setZydexLocationMaster(employeeSession.getZydexLocationMaster());
        List list1 = cOffLeaveMasterService.readByDept(cOffLeaveMaster);
        try {
            cOffLeaveMaster = (COffLeaveMaster) list1.get(0);
            request.setAttribute("coffLeaveHoursNo", cOffLeaveMaster.getHoursNo());
        } catch (Exception e) {
        }
        user.getId();
        int reportingId = 0;
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

        List<?> empId = employeeMasterService.readByUserName(employeeMaster);
        if (!empId.isEmpty()) {
            employeeMaster = (EmployeeMaster) empId.get(0);
        }
        employeeLeaveBalance.setEmployeeMaster(employeeMaster);
        leaveEmployeeDetail.setEmployeeMaster(employeeMaster);
        List<?> empLeaveBalanceList = employeeLeaveBalanceService.readByEmpId(employeeLeaveBalance);
        Map<String, Float> listRemain = new LinkedHashMap<>();
        Map<String, Float> empReqMap = new LinkedHashMap<>();
        Map<String, Float> totalDaysMap = new LinkedHashMap<>();
        if (!empLeaveBalanceList.isEmpty()) {
            Iterator it = empLeaveBalanceList.iterator();
            while (it.hasNext()) {
                Object[] next = (Object[]) it.next();
                Float noOfDay = null;
                Float totalMap = null;
                Double zz = null;
                String name = "" + next[0];
                Float days = (float) next[1];
                if (employeeSession.getGender() && name.equals("Paternity Leave")) {
                    continue;
                }
                if (!employeeSession.getGender() && name.equals("Maternity Leave")) {
                    continue;
                }
                String leave1 = "" + next[2];
                leaveTypeMaster.setId(Integer.parseInt(leave1));
                leaveEmployeeDetail.setLeaveTypeMaster(leaveTypeMaster);
                List<?> listFirst = leaveEmployeeDetailService.readLeaveDays(leaveEmployeeDetail);
                if (!listFirst.isEmpty()) {
                    if (listFirst.get(0) != null) {
                        Object xx = (Object) listFirst.get(0);
                        zz = (double) xx;
                        noOfDay = (float) zz.floatValue();
                    }
                }
                //                Iterator it1 = listFirst.iterator();
                //                if (it1.hasNext()) {
                //                }
                if (noOfDay == null) {
                    noOfDay = (float) 0;
                }
                totalMap = days + noOfDay;
                if ("Short Leave".equals(name) || "Paternity Leave".equals(name) || "Maternity Leave".equals(name) || "Leave Without Pay".equals(name)) {
                    continue;
                } else {
                    listRemain.put(name, days);
                    empReqMap.put(name, noOfDay);
                    totalDaysMap.put(name, totalMap);
                }

            }

        }
        request.setAttribute("listRemain", listRemain);
        request.setAttribute("empReqMap", empReqMap);
        request.setAttribute("totalDaysMap", totalDaysMap);
        mv.getModelMap().put("leaveEmployeeDetail", leaveEmployeeDetail1);
        mv.setViewName("Leave/LeaveApplicatioFormForEmployee");
        return mv;
    }

    public ModelAndView applySubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        LeaveEmployeeDetail leaveEmployeeDetail = new LeaveEmployeeDetail();
        LeaveTypeMaster leaveTypeMaster = new LeaveTypeMaster();
        BindException errors = new BindException(leaveEmployeeDetail, "leaveEmployeeDetail");
        bind(request, leaveEmployeeDetail);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        UserMaster user = (UserMaster) request.getSession().getAttribute("user");
        EmployeeMaster employeeMaster = new EmployeeMaster();
        employeeMaster.setUserMaster(user);
        EmployeeLeaveBalance employeeLeaveBalance = new EmployeeLeaveBalance();
        EmployeeLeaveBalance employeeLeaveBalance1 = new EmployeeLeaveBalance();
        Float balanceDay;
        Float noOfDay;
        List<?> empId = employeeMasterService.readByUserName(employeeMaster);
        if (!empId.isEmpty()) {
            employeeMaster = (EmployeeMaster) empId.get(0);
        }

//        leaveEmployeeDetail.setLeaveTypeMaster(leaveTypeMaster);
        String strDateStatus = request.getParameter("leaveStartDate_SelectFullOrHalfId");
        String endDateStatus = request.getParameter("leaveEndDate_SelectFullOrHalfId");
        leaveEmployeeDetail.setStartDateStatus(strDateStatus);
        leaveEmployeeDetail.setEndDateStatus(endDateStatus);
        leaveEmployeeDetail.setEmployeeMaster(employeeMaster);
        leaveEmployeeDetail.setLeaveTypeMaster(leaveTypeMaster);

        leaveEmployeeDetailValidator.validate(mv, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            /// Because for Short Leave
//            leaveEmployeeDetail.setStartDate("");
//            leaveEmployeeDetail.setEndDate("");
            /// Because for Short Leave
//            mv.getModelMap().put("leaveEmployeeDetail", leaveEmployeeDetail);
            request.setAttribute("leaveEmployeeDetail", leaveEmployeeDetail);
            mv.addAllObjects(errors.getModel());
            mv = applyClick(request, response);
//            mv.setViewName("Leave/LeaveApplicatioFormForEmployee");
//        }
//        else if (leaveEmployeeDetail.getNoOfDays() == 0) {             // Condition Added By Vinita (To validate Zero Days Leave)
//            request.setAttribute("failureMessage",
//                    "Error :You Cannot Apply Leave on Holiday or Week Off");
//            request.setAttribute("leaveEmployeeDetail", leaveEmployeeDetail);
//            mv.addAllObjects(errors.getModel());
//            mv = applyClick(request, response);
        } else {
            String leaveTypeMasterId = request.getParameter("leaveTypeMaster.id");
            if (!"".equals(leaveTypeMasterId)) {
                leaveTypeMaster.setId(Integer.parseInt(leaveTypeMasterId));
                leaveTypeMaster = leaveTypeMasterService.readById(leaveTypeMaster.getId());
                if (leaveTypeMaster.getLeaveType().contains("Short Leave")) {
                    leaveEmployeeDetail.setStartDate(request.getParameter("startDateShort"));
                    leaveEmployeeDetail.setEndDate(request.getParameter("endDateShort"));
                }
                employeeLeaveBalance.setLeaveTypeMaster(leaveTypeMaster);
            }
            employeeLeaveBalance1.setEmployeeMaster(employeeMaster);
            employeeLeaveBalance1.setLeaveTypeMaster(leaveTypeMaster);
            List<?> balanceList = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance1);
            if (!balanceList.isEmpty()) {
                employeeLeaveBalance1 = (EmployeeLeaveBalance) balanceList.get(0);
            }
            boolean balance = false;
            employeeLeaveBalance.setEmployeeMaster(employeeMaster);
            List<?> empLeaveBalanceList = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance);
            if (!empLeaveBalanceList.isEmpty()) {
                employeeLeaveBalance = (EmployeeLeaveBalance) empLeaveBalanceList.get(0);
                if (!leaveTypeMaster.getLeaveType().contains("Short Leave") && !leaveTypeMaster.getLeaveType().contains("C Off Leave")) {
                    if (leaveEmployeeDetail.getNoOfDays().floatValue() > employeeLeaveBalance.getNoOfLeaveRemain()) {
                        balance = true;
                    }
                } else {
                    balance = true;

                }
            }
            try {
                leaveTypeMaster = leaveTypeMasterService.readById(Integer.parseInt(leaveTypeMasterId));
                leaveTypeMaster.getMaxDayAllowedLeave();
                Date startDate = sdf.parse(leaveEmployeeDetail.getStartDate());
                Date endDate = sdf.parse(leaveEmployeeDetail.getEndDate());
                long diffDays1 = 0;
                List<?> list = new ArrayList();
//                if (leaveTypeMaster.getLeaveType().equals("Casual Leave")) {
//                    getNoOfDays(leaveEmployeeDetail, startDate, endDate);
//                }

                if (!startDate.after(endDate)) {
                    LeaveEmployeeDetail leaveEmployeeDetail1 = new LeaveEmployeeDetail();
                    leaveEmployeeDetail1.setEmployeeMaster(employeeMaster);
                    List<?> l1 = leaveEmployeeDetailService.readByEmployeeId(leaveEmployeeDetail1);
                    boolean flag = false;
                    for (Object leave1 : l1) {

                        leaveEmployeeDetail1 = (LeaveEmployeeDetail) leave1;
                        Date strDate1 = sdf.parse(leaveEmployeeDetail1.getStartDate());
                        Date endDate1 = sdf.parse(leaveEmployeeDetail1.getEndDate());
                        Integer id1 = leaveEmployeeDetail1.getLeaveTypeMaster().getId();

                        if (leaveEmployeeDetail1.getStatus() != 5 && (startDate.equals(strDate1) || startDate.after(strDate1) && startDate.before(endDate1) || (endDate.after(strDate1) && endDate.before(endDate1)))) {
                            flag = true;
                            break;
                        } else {
                            flag = false;
                        }
                    }
                    if (leaveTypeMaster.getLeaveType().contains("Short Leave")) {
                        if (flag) {
                            request.setAttribute("failureMessage",
                                    "Error :You Have Already apply Leave On that Day...");
                            request.setAttribute("leaveEmployeeDetail", leaveEmployeeDetail);
                            mv = applyClick(request, response);
                        } else {
                            leaveEmployeeDetail.setNoOfDays(Float.parseFloat("1"));
                            leaveEmployeeDetailService.create(leaveEmployeeDetail);
                            balanceDay = employeeLeaveBalance1.getNoOfLeaveRemain();
                            noOfDay = leaveEmployeeDetail.getNoOfDays();
                            balanceDay = balanceDay - noOfDay;
                            employeeLeaveBalance1.setNoOfLeaveRemain(balanceDay);
                            employeeLeaveBalanceService.update(employeeLeaveBalance1);

                            request.setAttribute("successMessage",
                                    "Information : The Information is saved Successfully.");
                            mv = searchOwnLeaveDetail(request, response);
                            //Emailtemplate for submit click .....
                            try {
                                EmailTemplate emailTemplate = new EmailTemplate();
                                EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                                DesignationMaster designationMaster = new DesignationMaster();
                                designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                                EmployeeMaster employeeMasterHr = new EmployeeMaster();
                                employeeMasterHr = employeeMasterService.readById(Integer.parseInt(employeeMasterModel.getReportingManagerLevel1()));
                                // id six is apply status
                                emailTemplate = emailTemplateService.readById(6);
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
//                        mv.setViewName("redirect:leaveEmployeeDetail.htm?act=searchOwnLeaveDetail");
                    } else if (leaveEmployeeDetail.getNoOfDays() > Float.parseFloat(leaveTypeMaster.getMaxDayAllowedLeave()) && !leaveTypeMaster.getLeaveType().contains("Maternity Leave") && !leaveTypeMaster.getLeaveType().contains("C Off Leave")
                            && !leaveTypeMaster.getLeaveType().contains("Sick Leave")) {
                        request.setAttribute("failureMessage",
                                "Error :No Of Days is Greater than maximum allowed Days...");
                        request.setAttribute("leaveEmployeeDetail", leaveEmployeeDetail);
                        mv = applyClick(request, response);
                    } else if (flag) {
                        request.setAttribute("failureMessage",
                                "Error :You Have Already apply Leave On that Day...");
                        request.setAttribute("leaveEmployeeDetail", leaveEmployeeDetail);
                        mv = applyClick(request, response);

                    } else if (leaveTypeMaster.getLeaveType().equals("Paternity Leave")) {

                        list = leaveEmployeeDetailService.readEmployeeWiseMaternity(leaveEmployeeDetail);
                        if (employeeMaster.getMaritalStatus().equals("UnMarried")) {
                            request.setAttribute("failureMessage",
                                    "Error :UnMarried Employee Should Not Apply Paternity Leave...");
                            request.setAttribute("leaveEmployeeDetail", leaveEmployeeDetail);
                            mv = applyClick(request, response);
                        } else if (employeeMaster.getGender()) {
                            request.setAttribute("failureMessage",
                                    "Error :Female Employee Should Not Apply Paternity Leave...");
                            request.setAttribute("leaveEmployeeDetail", leaveEmployeeDetail);
                            mv = applyClick(request, response);
                        } else if (list.size() >= 2) {
                            request.setAttribute("failureMessage",
                                    "Error :You have Only Apply 2 Time Paternity Leave Days...");
                            request.setAttribute("leaveEmployeeDetail", leaveEmployeeDetail);
                            mv = applyClick(request, response);

                        } else if (balance) {
                            request.setAttribute("failureMessage",
                                    "Error :No Of Days is Greater than Leave Balance Days...");
                            request.setAttribute("leaveEmployeeDetail", leaveEmployeeDetail);
                            mv = applyClick(request, response);

                        } else {
                            leaveEmployeeDetailService.create(leaveEmployeeDetail);
                            int leaveTypeId = leaveEmployeeDetail.getLeaveTypeMaster().getId();
                            LeaveTypeMaster leaveTypeMaster1 = leaveTypeMasterService.readById(leaveTypeId);
                            if (leaveTypeMaster1.getLeaveType().equals("Paternity Leave")) {
                                noOfDay = (float) 3.0;
                            }
                            balanceDay = employeeLeaveBalance1.getNoOfLeaveRemain();
                            noOfDay = leaveEmployeeDetail.getNoOfDays();
                            balanceDay = balanceDay - noOfDay;
                            employeeLeaveBalance1.setNoOfLeaveRemain(balanceDay);
                            employeeLeaveBalanceService.update(employeeLeaveBalance1);
                            request.setAttribute("successMessage",
                                    "Information : The Information is saved Successfully.");
                            mv = searchOwnLeaveDetail(request, response);
                        }
                    } else if (!leaveTypeMaster.getLeaveType().contains("Maternity Leave") && !leaveTypeMaster.getLeaveType().contains("Leave Without Pay") && leaveEmployeeDetail.getNoOfDays() > employeeLeaveBalance.getNoOfLeaveRemain()) {
                        request.setAttribute("failureMessage",
                                "Error :No Of Days is Greater than Leave Balance Days...");
                        request.setAttribute("leaveEmployeeDetail", leaveEmployeeDetail);
                        mv = applyClick(request, response);

                    } else {
                        leaveEmployeeDetailService.create(leaveEmployeeDetail);
                        balanceDay = employeeLeaveBalance1.getNoOfLeaveRemain();
                        noOfDay = leaveEmployeeDetail.getNoOfDays();
                        balanceDay = balanceDay - noOfDay;
                        employeeLeaveBalance1.setNoOfLeaveRemain(balanceDay);
                        employeeLeaveBalanceService.update(employeeLeaveBalance1);
                        request.setAttribute("successMessage",
                                "Information : The Information is saved Successfully.");

                        //Emailtemplate for submit click .....
                        try {
                            EmailTemplate emailTemplate = new EmailTemplate();
                            EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                            DesignationMaster designationMaster = new DesignationMaster();
                            designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                            EmployeeMaster employeeMasterHr = new EmployeeMaster();
                            employeeMasterHr = employeeMasterService.readById(Integer.parseInt(employeeMasterModel.getReportingManagerLevel1()));
                            // id six is apply status
                            emailTemplate = emailTemplateService.readById(6);
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

                        request.setAttribute("successMessage",
                                "Information : The Information is saved Successfully.");
                        mv = searchOwnLeaveDetail(request, response);
//                        mv.setViewName("redirect:leaveEmployeeDetail.htm?act=searchOwnLeaveDetail");

                    }
                } else {
                    request.setAttribute("failureMessage",
                            "Error : Please Insert start date before end date.");
                    request.setAttribute("leaveEmployeeDetail", leaveEmployeeDetail);
                    mv = applyClick(request, response);
                }
            } catch (Exception e) {
                request.setAttribute("failureMessage",
                        "Error : Please Insert Valid Data.");
                request.setAttribute("leaveEmployeeDetail", leaveEmployeeDetail);
                mv = applyClick(request, response);
            }
        }

//        mv.getModelMap().put("leaveEmployeeDetail", leaveEmployeeDetail);
        return mv;
    }

    public ModelAndView searchSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        LeaveEmployeeDetail leaveEmployeeDetail = new LeaveEmployeeDetail();
        UserMaster user = (UserMaster) request.getSession().getAttribute("user");
        EmployeeMaster employeeMaster = new EmployeeMaster();
        employeeMaster.setUserMaster(user);
        List<?> empId = employeeMasterService.readByUserName(employeeMaster);
        if (!empId.isEmpty()) {
            employeeMaster = (EmployeeMaster) empId.get(0);
        }
        leaveEmployeeDetail.setEmployeeMaster(employeeMaster);
        List<?> empLeaveList = leaveEmployeeDetailService.readEmpLeaveDetail(leaveEmployeeDetail);
        request.setAttribute("list", empLeaveList);
        mv.getModelMap().put("leaveEmployeeDetail", leaveEmployeeDetail);
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.setViewName("Leave/LeaveApplicationResult");
        return mv;
    }

    public ModelAndView searchOwnLeaveRequestResultOfEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        LeaveEmployeeDetail leaveEmployeeDetail = new LeaveEmployeeDetail();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        LeaveTypeMaster leaveTypeMaster = new LeaveTypeMaster();

        String leaveTypeId = request.getParameter("leaveType");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");

        UserMaster user = (UserMaster) request.getSession().getAttribute("user");
        employeeMaster.setUserMaster(user);
        List<?> empId = employeeMasterService.readByUserName(employeeMaster);
        if (!empId.isEmpty()) {
            employeeMaster = (EmployeeMaster) empId.get(0);
        }
        leaveEmployeeDetail.setEmployeeMaster(employeeMaster);

        if (!startDate.equals("")) {
            leaveEmployeeDetail.setStartDate(startDate);
        }
        if (!endDate.equals("")) {
            leaveEmployeeDetail.setEndDate(endDate);
        }
        if (!leaveTypeId.equals("")) {
            leaveTypeMaster.setId(Integer.parseInt(leaveTypeId));
        }
        leaveEmployeeDetail.setLeaveTypeMaster(leaveTypeMaster);

        List<?> list = leaveEmployeeDetailService.readOwnLeave(leaveEmployeeDetail);
        request.setAttribute("list", list);
        mv = searchSubmit(request, response);
        return mv;
    }

    public ModelAndView viewLeaveRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        LeaveEmployeeDetail leaveEmployeeDetail = new LeaveEmployeeDetail();
        String id = request.getParameter("id");
        LeaveTypeMaster leaveTypeMaster = new LeaveTypeMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        EmployeeLeaveBalance employeeLeaveBalance = new EmployeeLeaveBalance();
        addleaveType(request);
        UserMaster user = (UserMaster) request.getSession().getAttribute("user");
        EmployeeMaster employeeSession = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        ShortLeave shortLeave = new ShortLeave();
        shortLeave.setZydexLocationMaster(employeeSession.getZydexLocationMaster());
        List list = shortLeaveService.readByDept(shortLeave);
        try {
            shortLeave = (ShortLeave) list.get(0);
            request.setAttribute("shortLeaveHoursNo", shortLeave.getHoursNo());
        } catch (Exception e) {

        }

        user.getId();
        int reportingId = 0;
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

        List<?> empId = employeeMasterService.readByUserName(employeeMaster);
        if (!empId.isEmpty()) {
            employeeMaster = (EmployeeMaster) empId.get(0);
        }
        employeeLeaveBalance.setEmployeeMaster(employeeMaster);
        leaveEmployeeDetail.setEmployeeMaster(employeeMaster);
        List<?> empLeaveBalanceList = employeeLeaveBalanceService.readByEmpId(employeeLeaveBalance);
        Map<String, Float> listRemain = new LinkedHashMap<>();
        Map<String, Float> empReqMap = new LinkedHashMap<>();
        Map<String, Float> totalDaysMap = new LinkedHashMap<>();
        if (!empLeaveBalanceList.isEmpty()) {
            Iterator it = empLeaveBalanceList.iterator();
            while (it.hasNext()) {
                Object[] next = (Object[]) it.next();
                Float noOfDay = null;
                Float totalMap = null;
                Double zz = null;
                String name = "" + next[0];
                Float days = (float) next[1];
                String leave1 = "" + next[2];
                if (employeeSession.getGender() && name.equals("Paternity Leave")) {
                    continue;
                }
                if (!employeeSession.getGender() && name.equals("Maternity Leave")) {
                    continue;
                }
                leaveTypeMaster.setId(Integer.parseInt(leave1));
                leaveEmployeeDetail.setLeaveTypeMaster(leaveTypeMaster);
                List<?> listFirst = leaveEmployeeDetailService.readLeaveDays(leaveEmployeeDetail);
                if (!listFirst.isEmpty()) {
                    if (listFirst.get(0) != null) {
                        Object xx = (Object) listFirst.get(0);
                        zz = (double) xx;
                        noOfDay = (float) zz.floatValue();
                    }
                }
                //                Iterator it1 = listFirst.iterator();
                //                if (it1.hasNext()) {
                //                }
                if (noOfDay == null) {
                    noOfDay = (float) 0;
                }
                totalMap = days + noOfDay;
                if ("Short Leave".equals(name) || "Paternity Leave".equals(name) || "Maternity Leave".equals(name) || "Leave Without Pay".equals(name)) {
                    continue;
                } else {
                    listRemain.put(name, days);
                    empReqMap.put(name, noOfDay);
                    totalDaysMap.put(name, totalMap);
                }
            }

        }
        request.setAttribute("listRemain", listRemain);
        request.setAttribute("empReqMap", empReqMap);
        request.setAttribute("totalDaysMap", totalDaysMap);
        leaveEmployeeDetail = leaveEmployeeDetailService.readById(Integer.parseInt(id));
        request.setAttribute("strDateStatus", leaveEmployeeDetail.getStartDateStatus());
        request.setAttribute("endDateStatus", leaveEmployeeDetail.getEndDateStatus());
        leaveTypeMaster = leaveTypeMasterService.readById(leaveEmployeeDetail.getLeaveTypeMaster().getId());
        request.setAttribute("leaveType", leaveTypeMaster.getLeaveType());
        if (leaveTypeMaster.getLeaveType().equals("Short Leave")) {
            request.setAttribute("startDateStr", leaveEmployeeDetail.getStartDate());
            request.setAttribute("endDateStr", leaveEmployeeDetail.getEndDate());
            leaveEmployeeDetail.setStartDate("");
            leaveEmployeeDetail.setEndDate("");
        }
        request.setAttribute("flag", leaveEmployeeDetail.getStatus());
        mv.getModelMap().put("leaveEmployeeDetail", leaveEmployeeDetail);
        mv.setViewName("Leave/LeaveApplicationFormEdit");
        return mv;
    }

    public ModelAndView viewWithDrawLeaveRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        LeaveEmployeeDetail leaveEmployeeDetail = new LeaveEmployeeDetail();
        String id = request.getParameter("id");
        LeaveTypeMaster leaveTypeMaster = new LeaveTypeMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        EmployeeLeaveBalance employeeLeaveBalance = new EmployeeLeaveBalance();
        addleaveType(request);
        UserMaster user = (UserMaster) request.getSession().getAttribute("user");
        EmployeeMaster employeeSession = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        ShortLeave shortLeave = new ShortLeave();
        shortLeave.setZydexLocationMaster(employeeSession.getZydexLocationMaster());
        List list = shortLeaveService.readByDept(shortLeave);
        try {
            shortLeave = (ShortLeave) list.get(0);
            request.setAttribute("shortLeaveHoursNo", shortLeave.getHoursNo());
        } catch (Exception e) {

        }

        user.getId();
        int reportingId = 0;
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

        List<?> empId = employeeMasterService.readByUserName(employeeMaster);
        if (!empId.isEmpty()) {
            employeeMaster = (EmployeeMaster) empId.get(0);
        }
        employeeLeaveBalance.setEmployeeMaster(employeeMaster);
        leaveEmployeeDetail.setEmployeeMaster(employeeMaster);
        List<?> empLeaveBalanceList = employeeLeaveBalanceService.readByEmpId(employeeLeaveBalance);
        Map<String, Float> listRemain = new LinkedHashMap<>();
        Map<String, Float> empReqMap = new LinkedHashMap<>();
        Map<String, Float> totalDaysMap = new LinkedHashMap<>();
        if (!empLeaveBalanceList.isEmpty()) {
            Iterator it = empLeaveBalanceList.iterator();
            while (it.hasNext()) {
                Object[] next = (Object[]) it.next();
                Float noOfDay = null;
                Float totalMap = null;
                Double zz = null;
                String name = "" + next[0];
                Float days = (float) next[1];
                String leave1 = "" + next[2];
                if (employeeSession.getGender() && name.equals("Paternity Leave")) {
                    continue;
                }
                if (!employeeSession.getGender() && name.equals("Maternity Leave")) {
                    continue;
                }
                leaveTypeMaster.setId(Integer.parseInt(leave1));
                leaveEmployeeDetail.setLeaveTypeMaster(leaveTypeMaster);
                List<?> listFirst = leaveEmployeeDetailService.readLeaveDays(leaveEmployeeDetail);
                if (!listFirst.isEmpty()) {
                    if (listFirst.get(0) != null) {
                        Object xx = (Object) listFirst.get(0);
                        zz = (double) xx;
                        noOfDay = (float) zz.floatValue();
                    }
                }
                //                Iterator it1 = listFirst.iterator();
                //                if (it1.hasNext()) {
                //                }
                if (noOfDay == null) {
                    noOfDay = (float) 0;
                }
                totalMap = days + noOfDay;
                if ("Short Leave".equals(name) || "Paternity Leave".equals(name) || "Maternity Leave".equals(name) || "Leave Without Pay".equals(name)) {
                    continue;
                } else {
                    listRemain.put(name, days);
                    empReqMap.put(name, noOfDay);
                    totalDaysMap.put(name, totalMap);
                }
            }

        }
        request.setAttribute("listRemain", listRemain);
        request.setAttribute("empReqMap", empReqMap);
        request.setAttribute("totalDaysMap", totalDaysMap);
        leaveEmployeeDetail = leaveEmployeeDetailService.readById(Integer.parseInt(id));
        request.setAttribute("strDateStatus", leaveEmployeeDetail.getStartDateStatus());
        request.setAttribute("endDateStatus", leaveEmployeeDetail.getEndDateStatus());
        leaveTypeMaster = leaveTypeMasterService.readById(leaveEmployeeDetail.getLeaveTypeMaster().getId());
        request.setAttribute("leaveType", leaveTypeMaster.getLeaveType());
        if (leaveTypeMaster.getLeaveType().equals("Short Leave")) {
            request.setAttribute("startDateStr", leaveEmployeeDetail.getStartDate());
            request.setAttribute("endDateStr", leaveEmployeeDetail.getEndDate());
            leaveEmployeeDetail.setStartDate("");
            leaveEmployeeDetail.setEndDate("");
        }
        request.setAttribute("flag", leaveEmployeeDetail.getStatus());
        mv.getModelMap().put("leaveEmployeeDetail", leaveEmployeeDetail);
        mv.setViewName("Leave/LeaveApplicationFormWithDraw");
        return mv;
    }

    public ModelAndView editLeaveRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        LeaveEmployeeDetail leaveEmployeeDetail = new LeaveEmployeeDetail();
        LeaveTypeMaster leaveTypeMaster = new LeaveTypeMaster();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        EmployeeLeaveBalance employeeLeaveBalance = new EmployeeLeaveBalance();
        BindException errors = new BindException(leaveEmployeeDetail, "leaveEmployeeDetail");
        bind(request, leaveEmployeeDetail);
        String id = request.getParameter("id");
        leaveEmployeeDetail.setId(Integer.parseInt(id));
        UserMaster user = (UserMaster) request.getSession().getAttribute("user");
        EmployeeMaster employeeMaster = new EmployeeMaster();
        employeeMaster.setUserMaster(user);
        List<?> empId = employeeMasterService.readByUserName(employeeMaster);
        if (!empId.isEmpty()) {
            employeeMaster = (EmployeeMaster) empId.get(0);
        }

        String btnSubmit = request.getParameter("btnSubmit");
        String leaveTypeMasterId = request.getParameter("leaveTypeMaster.id");
        if (!"".equals(leaveTypeMasterId)) {
            leaveTypeMaster.setId(Integer.parseInt(leaveTypeMasterId));
        }
        leaveEmployeeDetail.setLeaveTypeMaster(leaveTypeMaster);
        String strDateStatus = request.getParameter("leaveStartDate_SelectFullOrHalfId");
        String endDateStatus = request.getParameter("leaveEndDate_SelectFullOrHalfId");
        leaveEmployeeDetail.setStartDateStatus(strDateStatus);
        leaveEmployeeDetail.setEndDateStatus(endDateStatus);
        leaveEmployeeDetail.setEmployeeMaster(employeeMaster);
        leaveEmployeeDetail.setLeaveTypeMaster(leaveTypeMaster);
        Date startDate = new Date();
        Date endDate = new Date();
        if (!"".equals(leaveEmployeeDetail.getStartDate()) && !"".equals(leaveEmployeeDetail.getStartDate())) {

            startDate = sdf.parse(leaveEmployeeDetail.getStartDate());
            endDate = sdf.parse(leaveEmployeeDetail.getEndDate());
        }

        float balanceDay;
        float noOfDay;
        EmployeeLeaveBalance employeeLeaveBalance1 = new EmployeeLeaveBalance();
        employeeLeaveBalance1.setEmployeeMaster(employeeMaster);
        employeeLeaveBalance1.setLeaveTypeMaster(leaveTypeMaster);
        List<?> balanceList = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance1);
        if (!balanceList.isEmpty()) {
            employeeLeaveBalance1 = (EmployeeLeaveBalance) balanceList.get(0);
        }

        if (btnSubmit.equals("submit")) {
            try {
                leaveTypeMaster = leaveTypeMasterService.readById(Integer.parseInt(leaveTypeMasterId));
                if (leaveTypeMaster.getLeaveType().contains("Short Leave")) {
                    leaveEmployeeDetail.setStartDate(request.getParameter("startDateShort"));
                    leaveEmployeeDetail.setEndDate(request.getParameter("endDateShort"));
                    leaveEmployeeDetail.setHrRemark(null);
                    leaveEmployeeDetail.setStartDateStatus("");
                    leaveEmployeeDetail.setEndDateStatus("");
                    leaveEmployeeDetail.setNoOfDays(Float.parseFloat("1"));
                    leaveEmployeeDetail.setStatus(0);
                }
                Date startDate1 = sdf.parse(leaveEmployeeDetail.getStartDate());
                Date endDate1 = sdf.parse(leaveEmployeeDetail.getEndDate());
                long diffDays1 = 0;
                if (leaveTypeMaster.getLeaveType().equals("Casual Leave")) {
                    getNoOfDays(leaveEmployeeDetail, startDate, endDate);
                }

            } catch (Exception e) {

            }
            leaveEmployeeDetailValidator.validate(mv, errors);
            if (errors.hasErrors()) {
                request.setAttribute("failureMessage",
                        "Error : The Entered Information is not valid.");
                mv.addAllObjects(errors.getModel());
                mv = viewLeaveRequest(request, response);
//            mv.setViewName("Leave/LeaveApplicatioFormForEmployee");
            } else {
                try {
                    leaveTypeMaster = leaveTypeMasterService.readById(Integer.parseInt(leaveTypeMasterId));
                    leaveTypeMaster.getMaxDayAllowedLeave();
                    if (leaveTypeMaster.getLeaveType().contains("Short Leave")) {
                        leaveEmployeeDetail.setStartDate(request.getParameter("startDateShort"));
                        leaveEmployeeDetail.setEndDate(request.getParameter("endDateShort"));
                        leaveEmployeeDetail.setHrRemark(null);
                        leaveEmployeeDetail.setStartDateStatus("");
                        leaveEmployeeDetail.setEndDateStatus("");
                        leaveEmployeeDetail.setNoOfDays(Float.parseFloat("1"));
                        leaveEmployeeDetail.setStatus(0);
                    }

                    if (null != leaveEmployeeDetail.getNoOfDays() && leaveEmployeeDetail.getNoOfDays() > Float.parseFloat(leaveTypeMaster.getMaxDayAllowedLeave())) {
                        System.out.println("aa");
                        request.setAttribute("failureMessage",
                                "Error :No Of Days is Grater than maximum allowed Days...");
                        mv = viewLeaveRequest(request, response);
                    } else if (startDate.after(endDate)) {
                        request.setAttribute("failureMessage",
                                "Error : Please Insert start date before end date.");
                        mv = viewLeaveRequest(request, response);

                    } else {
                        leaveEmployeeDetail.setStatus(0);
                        leaveEmployeeDetailService.update(leaveEmployeeDetail);

                        balanceDay = employeeLeaveBalance1.getNoOfLeaveRemain();
                        noOfDay = leaveEmployeeDetail.getNoOfDays();
                        balanceDay = balanceDay - noOfDay;
                        employeeLeaveBalance1.setNoOfLeaveRemain(balanceDay);
                        employeeLeaveBalanceService.update(employeeLeaveBalance1);
                        request.setAttribute("successMessage",
                                "Information : The Information is Updated Successfully.");
                        //emailtemplate for leave request edit click
                        try {
                            EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                            DesignationMaster designationMaster = new DesignationMaster();
                            designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                            EmailTemplate emailTemplate = new EmailTemplate();
                            EmployeeMaster EmployeeHR = new EmployeeMaster();
                            EmployeeHR = employeeMasterService.readById(Integer.parseInt(employeeMasterModel.getReportingManagerLevel1()));

                            //id=58 for apply leave request edited...
                            emailTemplate = emailTemplateService.readById(58);
                            String To = EmployeeHR.getOfficeEmailId();
                            String from = employeeMasterModel.getOfficeEmailId();
                            String Subject = emailTemplate.getSubject();
                            Subject = Subject.replaceAll("\\{user\\}", employeeMasterModel.getEmployeeName());
                            String msg = emailTemplate.getBodytext();
                            msg = msg.replaceAll("\\{to_user\\}", EmployeeHR.getEmployeeName());
                            msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                            msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                            sendMail.sendMail(from, To, Subject, msg);

                        } catch (Exception e) {
                        }

                        mv = searchOwnLeaveDetail(request, response);
//                        mv = searchSubmit(request, response);
                    }
                } catch (Exception e) {
                    request.setAttribute("failureMessage",
                            "Error : The Entered Information is not valid.");
                    mv.addAllObjects(errors.getModel());
                    mv = viewLeaveRequest(request, response);
                }

            }
        } else if (btnSubmit.equals("Withdraw")) {
            leaveTypeMaster = leaveTypeMasterService.readById(Integer.parseInt(leaveTypeMasterId));

            if (leaveEmployeeDetail.getStatus() == 0 || leaveEmployeeDetail.getStatus() == 2 || leaveEmployeeDetail.getStatus() == 1) {

                balanceDay = employeeLeaveBalance1.getNoOfLeaveRemain();
                noOfDay = leaveEmployeeDetail.getNoOfDays();
                balanceDay = balanceDay + noOfDay;
                employeeLeaveBalance1.setNoOfLeaveRemain(balanceDay);
                employeeLeaveBalanceService.update(employeeLeaveBalance1);
                leaveEmployeeDetailService.delete(Integer.parseInt(id));
                request.setAttribute("successMessage",
                        "Information : Leave Withdrawn Successfully.");
                try {
                    EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                    DesignationMaster designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                    EmployeeMaster EmployeeHR = employeeMasterService.readById(Integer.parseInt(employeeMasterModel.getReportingManagerLevel1()));
                    EmailTemplate emailTemplate = new EmailTemplate();
                    //id= 10 for leave withdraw request......
                    emailTemplate = emailTemplateService.readById(10);
                    String To = EmployeeHR.getOfficeEmailId();
                    String from = employeeMasterModel.getOfficeEmailId();
                    String Subject = emailTemplate.getSubject();
                    Subject = Subject.replaceAll("\\{user\\}", employeeMasterModel.getEmployeeName());
                    String msg = emailTemplate.getBodytext();
                    msg = msg.replaceAll("\\{to_user\\}", EmployeeHR.getEmployeeName());
                    msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                    msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                    sendMail.sendMail(from, To, Subject, msg);

                } catch (Exception e) {
                }
                mv = searchOwnLeaveDetail(request, response);
//                mv = searchSubmit(request, response);
            } else if (leaveEmployeeDetail.getStatus() == 3) {
                if (leaveTypeMaster.getLeaveType().contains("Short Leave")) {
                    leaveEmployeeDetail.setStartDate(request.getParameter("startDateShort"));
                    leaveEmployeeDetail.setEndDate(request.getParameter("endDateShort"));
                    leaveEmployeeDetail.setHrRemark(null);
                    leaveEmployeeDetail.setStartDateStatus("");
                    leaveEmployeeDetail.setEndDateStatus("");
                    leaveEmployeeDetail.setNoOfDays(Float.parseFloat("1"));
                }

                leaveEmployeeDetail.setStatus(4);
//                balanceDay = employeeLeaveBalance1.getNoOfLeaveRemain();
//                noOfDay = leaveEmployeeDetail.getNoOfDays();
//                balanceDay = balanceDay + noOfDay;
//                employeeLeaveBalance1.setNoOfLeaveRemain(balanceDay);
//                employeeLeaveBalanceService.update(employeeLeaveBalance1);
                leaveEmployeeDetailService.update(leaveEmployeeDetail);
                request.setAttribute("successMessage",
                        "Information : Withdraw Leave Request sent Successfully.");
                try {
                    EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                    DesignationMaster designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                    EmployeeMaster EmployeeHR = employeeMasterService.readById(Integer.parseInt(employeeMasterModel.getReportingManagerLevel1()));
                    EmailTemplate emailTemplate = new EmailTemplate();
                    //id= 10 for leave withdraw approve request......
                    emailTemplate = emailTemplateService.readById(10);
                    String To = EmployeeHR.getOfficeEmailId();
                    String from = employeeMasterModel.getOfficeEmailId();
                    String Subject = emailTemplate.getSubject();
                    Subject = Subject.replaceAll("\\{user\\}", employeeMasterModel.getEmployeeName());
                    String msg = emailTemplate.getBodytext();
                    msg = msg.replaceAll("\\{to_user\\}", EmployeeHR.getEmployeeName());
                    msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                    msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                    sendMail.sendMail(from, To, Subject, msg);

                } catch (Exception e) {
                }

                mv = viewLeaveRequest(request, response);
            }
        }

        return mv;
    }

    public ModelAndView deleteLeaveRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        LeaveEmployeeDetail leaveEmployeeDetail = new LeaveEmployeeDetail();
        String empLeaveId[] = request.getParameterValues("checkId");
        for (String xx : empLeaveId) {
            try {
                leaveEmployeeDetailService.delete(Integer.parseInt(xx));
                request.setAttribute("successMessage",
                        "Info : One or more records are deleted successfully.");
            } catch (Exception e) {
                request.setAttribute("failureMessage",
                        "Error : One or more records are Already deleted.");

            }
        }
        mv = searchSubmit(request, response);
        return mv;
    }

    public ModelAndView viewRequestAdminClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        LeaveEmployeeDetail leaveEmployeeDetail = new LeaveEmployeeDetail();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        leaveEmployeeDetail.setEmployeeMaster(employeeMaster);
        List<?> list = new ArrayList();
        Object flag = request.getAttribute("flag");
        String flag1 = "";
        if (flag != null) {
            flag1 = flag.toString();
        }
        if (!flag1.equals("1")) {
            list = leaveEmployeeDetailService.viewEmpLeaveRequest(leaveEmployeeDetail);
        } else {
            list = (List<?>) request.getAttribute("list1");
        }
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        List<?> empId = employeeMasterService.readByUserName(employeeMaster);
        if (!empId.isEmpty()) {
            employeeMaster = (EmployeeMaster) empId.get(0);
        }
        request.setAttribute("list1", list);
        selectEmployeeForParticularManager(request, response);
        readleaveType(request);
        mv.getModelMap().put("employeeMaster", employeeMaster1);
        mv.setViewName("Leave/LeaveApprovalRequest");
        return mv;
    }

    public ModelAndView searchOwnLeaveRequestResult(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        LeaveEmployeeDetail leaveEmployeeDetail = new LeaveEmployeeDetail();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        String leaveType = request.getParameter("leaveType");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String employeeName = request.getParameter("employeeName");
        UserMaster user = (UserMaster) request.getSession().getAttribute("user");
        employeeMaster.setUserMaster(user);
        List<?> empId = employeeMasterService.readByUserName(employeeMaster);

        if (!empId.isEmpty()) {
            employeeMaster = (EmployeeMaster) empId.get(0);
        }
        if (!employeeName.equals("")) {
            EmployeeMaster employeeMaster1 = new EmployeeMaster();
            employeeMaster1 = employeeMasterService.readById(Integer.parseInt(employeeName));
            leaveEmployeeDetail.setEmployeeMaster(employeeMaster1);
        } else {
            leaveEmployeeDetail.setEmployeeMaster(null);
        }
        if (!leaveType.equals("")) {
            LeaveTypeMaster leaveTypeMaster = new LeaveTypeMaster();
            leaveTypeMaster = leaveTypeMasterService.readById(Integer.parseInt(leaveType));
            leaveEmployeeDetail.setLeaveTypeMaster(leaveTypeMaster);
        } else {
            leaveEmployeeDetail.setLeaveTypeMaster(null);
        }
        if (!startDate.equals("")) {
            leaveEmployeeDetail.setStartDate(startDate);

        }
        if (!endDate.equals("")) {
            leaveEmployeeDetail.setEndDate(endDate);

        }
        EmployeeMaster employeeMaster1 = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        leaveEmployeeDetail.setApproverId(employeeMaster1.getId());
        leaveEmployeeDetail.setApproverId(employeeMaster.getId());
        List<?> list1 = leaveEmployeeDetailService.searchLeaveDetailByEmployee(leaveEmployeeDetail);
        request.setAttribute("list1", list1);
        request.setAttribute("flag", 1);
        mv = viewRequestAdminClick(request, response);
        return mv;
    }

    public ModelAndView viewReqDetailByAdmin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        LeaveEmployeeDetail leaveEmployeeDetail = new LeaveEmployeeDetail();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        UserMaster user = new UserMaster();
        EmployeeLeaveBalance employeeLeaveBalance = new EmployeeLeaveBalance();
        LeaveTypeMaster leaveTypeMaster = new LeaveTypeMaster();
        addleaveType(request);
        String id = request.getParameter("id");
        String userId = request.getParameter("userId");
        leaveEmployeeDetail.setId(Integer.parseInt(id));
        user.setId(Integer.parseInt(userId));
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
        List<?> empId = employeeMasterService.readByUserName(employeeMaster);
        if (!empId.isEmpty()) {
            employeeMaster = (EmployeeMaster) empId.get(0);
        }
        employeeLeaveBalance.setEmployeeMaster(employeeMaster);
        leaveEmployeeDetail.setEmployeeMaster(employeeMaster);
        List<?> empLeaveBalanceList = employeeLeaveBalanceService.readByEmpId(employeeLeaveBalance);
        Map<String, Float> listRemain = new LinkedHashMap<>();
        Map<String, Float> empReqMap = new LinkedHashMap<>();
        Map<String, Float> totalDaysMap = new LinkedHashMap<>();
        if (!empLeaveBalanceList.isEmpty()) {
            Iterator it = empLeaveBalanceList.iterator();
            while (it.hasNext()) {
                Object[] next = (Object[]) it.next();
                Float noOfDay = null;
                Float totalMap = null;
                Double zz = null;
                String name = "" + next[0];
                Float days = (float) next[1];
//                if (employeeSession.getGender() && name.equals("Paternity Leave")) {
//                    continue;
//                }
//                if (!employeeSession.getGender() && name.equals("Maternity Leave")) {
//                    continue;
//                }
                String leave1 = "" + next[2];
                leaveTypeMaster.setId(Integer.parseInt(leave1));
                leaveEmployeeDetail.setLeaveTypeMaster(leaveTypeMaster);
                List<?> listFirst = leaveEmployeeDetailService.readLeaveDays(leaveEmployeeDetail);
                if (!listFirst.isEmpty()) {
                    if (listFirst.get(0) != null) {
                        Object xx = (Object) listFirst.get(0);
                        zz = (double) xx;
                        noOfDay = (float) zz.floatValue();
                    }
                }
                //                Iterator it1 = listFirst.iterator();
                //                if (it1.hasNext()) {
                //                }
                if (noOfDay == null) {
                    noOfDay = (float) 0;
                }
                totalMap = days + noOfDay;
                if ("Short Leave".equals(name) || "Paternity Leave".equals(name) || "Maternity Leave".equals(name) || "Leave Without Pay".equals(name)) {
                    continue;
                } else {
                    listRemain.put(name, days);
                    empReqMap.put(name, noOfDay);
                    totalDaysMap.put(name, totalMap);
                }

            }

        }
        request.setAttribute("listRemain", listRemain);
        request.setAttribute("empReqMap", empReqMap);
        request.setAttribute("totalDaysMap", totalDaysMap);

        leaveEmployeeDetail.setEmployeeMaster(employeeMaster);
        List<?> list = leaveEmployeeDetailService.empLeaveRequestDetail(leaveEmployeeDetail);
        request.setAttribute("list", list);
        mv.getModelMap().put("leaveEmployeeDetail", leaveEmployeeDetail);
        mv.setViewName("Leave/LeaveRequestApprove");
        return mv;
    }

    public ModelAndView approveRequestAdminClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        LeaveEmployeeDetail leaveEmployeeDetail = new LeaveEmployeeDetail();
        EmployeeLeaveBalance employeeLeaveBalance = new EmployeeLeaveBalance();
        LeaveTypeMaster leaveTypeMaster = new LeaveTypeMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        Float balanceDay;
        Float noOfDay;
        String id = request.getParameter("id");
        String hrRemark = request.getParameter("hrRemark");
        String btnSubmit = request.getParameter("btnSubmit");
        leaveEmployeeDetail = leaveEmployeeDetailService.readById(Integer.parseInt(id));
        leaveEmployeeDetail.setHrRemark(hrRemark);
        EmployeeMaster employeeMaster1 = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        leaveEmployeeDetail.setApproverId(employeeMaster1.getId());
        leaveTypeMaster.setId(leaveEmployeeDetail.getLeaveTypeMaster().getId());
        employeeMaster.setId(leaveEmployeeDetail.getEmployeeMaster().getId());
        employeeLeaveBalance.setEmployeeMaster(employeeMaster);
        employeeLeaveBalance.setLeaveTypeMaster(leaveTypeMaster);

        List<?> balanceList = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance);
        if (!balanceList.isEmpty()) {
            employeeLeaveBalance = (EmployeeLeaveBalance) balanceList.get(0);
        }

        if (btnSubmit.equals("approve")) {

            if (leaveEmployeeDetail.getStatus() == 4) {
                balanceDay = employeeLeaveBalance.getNoOfLeaveRemain();
                noOfDay = leaveEmployeeDetail.getNoOfDays();
                balanceDay = balanceDay + noOfDay;
                employeeLeaveBalance.setNoOfLeaveRemain(balanceDay);
                employeeLeaveBalanceService.update(employeeLeaveBalance);
                leaveEmployeeDetail.setStatus(5);
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String approveDate = sdf.format(date);
                leaveEmployeeDetail.setApproveDate(approveDate);
                leaveEmployeeDetailService.update(leaveEmployeeDetail);
                request.setAttribute("successMessage",
                        "Information : The Leave is Withdrawn successfully.");//enter approve witdrw template..
                try {
                    EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                    DesignationMaster designationMaster = new DesignationMaster();
                    designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                    String EmpIdStr = request.getParameter("empid");
                    EmployeeMaster employeeMaster2 = new EmployeeMaster();
                    EmailTemplate emailTemplate1 = new EmailTemplate();
                    // id =11 for approve leave withdraw request...
                    emailTemplate1 = emailTemplateService.readById(11);
                    if (null != EmpIdStr && !"".equals(EmpIdStr)) {
                        int empID = Integer.parseInt(EmpIdStr);
                        List list = employeeMasterService.readByEmployeeNo(empID);
                        if (!list.isEmpty()) {
                            employeeMaster2 = (EmployeeMaster) list.get(0);
                            String To = employeeMaster2.getOfficeEmailId();
                            String from = employeeMasterModel.getOfficeEmailId();
                            String subject = emailTemplate1.getSubject();

                            subject = subject.replaceAll("\\{user\\}", employeeMaster2.getEmployeeName());
                            String msg = emailTemplate1.getBodytext();
                            msg = msg.replaceAll("\\{to_user\\}", employeeMaster2.getEmployeeName());
                            msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                            msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                            sendMail.sendMail(from, To, subject, msg);

                        }
                    }
                } catch (Exception e) {
                }

            } else {

//                balanceDay = employeeLeaveBalance.getNoOfLeaveRemain();
//                noOfDay = leaveEmployeeDetail.getNoOfDays();
//                if (noOfDay <= balanceDay) {
                int leaveTypeId = leaveEmployeeDetail.getLeaveTypeMaster().getId();
                leaveEmployeeDetail.setStatus(3);
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String approveDate = sdf.format(date);
                leaveEmployeeDetail.setApproveDate(approveDate);
                leaveEmployeeDetailService.update(leaveEmployeeDetail);
                request.setAttribute("successMessage",
                        "Information : The Leave Approved successfully.");
                try {
                    EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                    DesignationMaster designationMaster = new DesignationMaster();
                    designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                    String EmpIdStr = request.getParameter("empid");
                    EmployeeMaster employeeMaster2 = new EmployeeMaster();
                    EmailTemplate emailTemplate1 = new EmailTemplate();
                    // id =7 for approve leave request...
                    emailTemplate1 = emailTemplateService.readById(7);
                    if (null != EmpIdStr && !"".equals(EmpIdStr)) {
                        int empID = Integer.parseInt(EmpIdStr);
                        List list = employeeMasterService.readByEmployeeNo(empID);
                        if (!list.isEmpty()) {
                            employeeMaster2 = (EmployeeMaster) list.get(0);
                            String To = employeeMaster2.getOfficeEmailId();
                            String from = employeeMasterModel.getOfficeEmailId();
                            String subject = emailTemplate1.getSubject();
                            subject = subject.replaceAll("\\{user\\}", employeeMaster2.getEmployeeName());
                            String msg = emailTemplate1.getBodytext();
                            msg = msg.replaceAll("\\{to_user\\}", employeeMaster2.getEmployeeName());
                            msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                            msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                            sendMail.sendMail(from, To, subject, msg);

                        }
                    }
                } catch (Exception e) {
                }
//                } else {
//                    request.setAttribute("failureMessage",
//                            "Error : Employee Leave Balance is Less Than Applied Days. So Please Reject/Rework a Leave Request");
//                }
            }

        }
        if (btnSubmit.equals("reject")) {

            if (leaveEmployeeDetail.getStatus() == 4) {
                request.setAttribute("successMessage",
                        "Information : The Withdraw Request Rejected successfully.");
                try {
                    EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                    DesignationMaster designationMaster = new DesignationMaster();
                    designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                    String EmpIdStr = request.getParameter("empid");
                    EmployeeMaster employeeMaster2 = new EmployeeMaster();
                    EmailTemplate emailTemplate1 = new EmailTemplate();
                    // id =9 for reject leave request...
                    emailTemplate1 = emailTemplateService.readById(9);
                    if (null != EmpIdStr && !"".equals(EmpIdStr)) {
                        int empID = Integer.parseInt(EmpIdStr);
                        List list = employeeMasterService.readByEmployeeNo(empID);
                        if (!list.isEmpty()) {
                            employeeMaster2 = (EmployeeMaster) list.get(0);
                            String To = employeeMaster2.getOfficeEmailId();
                            String from = employeeMasterModel.getOfficeEmailId();
                            String subject = emailTemplate1.getSubject();
                            subject = subject.replaceAll("\\{user\\}", employeeMaster2.getEmployeeName());
                            String msg = emailTemplate1.getBodytext();
                            msg = msg.replaceAll("\\{to_user\\}", employeeMaster2.getEmployeeName());
                            msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                            msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                            sendMail.sendMail(from, To, subject, msg);

                        }
                    }
                } catch (Exception e) {
                }

            } else {
                balanceDay = employeeLeaveBalance.getNoOfLeaveRemain();
                noOfDay = leaveEmployeeDetail.getNoOfDays();
                balanceDay = balanceDay + noOfDay;
                employeeLeaveBalance.setNoOfLeaveRemain(balanceDay);
                employeeLeaveBalanceService.update(employeeLeaveBalance);
                request.setAttribute("successMessage",
                        "Information : The Leave Rejected successfully.");
                try {
                    EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                    DesignationMaster designationMaster = new DesignationMaster();
                    designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                    String EmpIdStr = request.getParameter("empid");
                    EmployeeMaster employeeMaster2 = new EmployeeMaster();
                    EmailTemplate emailTemplate1 = new EmailTemplate();
                    // id =9 for reject leave request...
                    emailTemplate1 = emailTemplateService.readById(9);
                    if (null != EmpIdStr && !"".equals(EmpIdStr)) {
                        int empID = Integer.parseInt(EmpIdStr);
                        List list = employeeMasterService.readByEmployeeNo(empID);
                        if (!list.isEmpty()) {
                            employeeMaster2 = (EmployeeMaster) list.get(0);
                            String To = employeeMaster2.getOfficeEmailId();
                            String from = employeeMasterModel.getOfficeEmailId();
                            String subject = emailTemplate1.getSubject();
                            subject = subject.replaceAll("\\{user\\}", employeeMaster2.getEmployeeName());
                            String msg = emailTemplate1.getBodytext();
                            msg = msg.replaceAll("\\{to_user\\}", employeeMaster2.getEmployeeName());
                            msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                            msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                            sendMail.sendMail(from, To, subject, msg);

                        }
                    }
                } catch (Exception e) {
                }
            }
            leaveEmployeeDetail.setStatus(2);
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String approveDate = sdf.format(date);
            leaveEmployeeDetail.setApproveDate(approveDate);
            leaveEmployeeDetailService.update(leaveEmployeeDetail);

        }
        if (btnSubmit.equals("rework")) {

            if (leaveEmployeeDetail.getStatus() == 4) {

            } else {
                balanceDay = employeeLeaveBalance.getNoOfLeaveRemain();
                noOfDay = leaveEmployeeDetail.getNoOfDays();
                balanceDay = balanceDay + noOfDay;
                employeeLeaveBalance.setNoOfLeaveRemain(balanceDay);
                employeeLeaveBalanceService.update(employeeLeaveBalance);
            }
            leaveEmployeeDetail.setStatus(1);
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String approveDate = sdf.format(date);
            leaveEmployeeDetail.setApproveDate(approveDate);
            leaveEmployeeDetailService.update(leaveEmployeeDetail);

            request.setAttribute("successMessage",
                    "Information : The Leave Reworked successfully.");
            try {
                EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                DesignationMaster designationMaster = new DesignationMaster();
                designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                String EmpIdStr = request.getParameter("empid");
                EmployeeMaster employeeMaster2 = new EmployeeMaster();
                EmailTemplate emailTemplate1 = new EmailTemplate();
                // id =8 for rework leave request...
                emailTemplate1 = emailTemplateService.readById(8);
                if (null != EmpIdStr && !"".equals(EmpIdStr)) {
                    int empID = Integer.parseInt(EmpIdStr);
                    List list = employeeMasterService.readByEmployeeNo(empID);
                    if (!list.isEmpty()) {
                        employeeMaster2 = (EmployeeMaster) list.get(0);
                        String To = employeeMaster2.getOfficeEmailId();
                        String from = employeeMasterModel.getOfficeEmailId();
                        String subject = emailTemplate1.getSubject();
                        subject = subject.replaceAll("\\{user\\}", employeeMaster2.getEmployeeName());
                        String msg = emailTemplate1.getBodytext();
                        msg = msg.replaceAll("\\{to_user\\}", employeeMaster2.getEmployeeName());
                        msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                        msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                        sendMail.sendMail(from, To, subject, msg);

                    }
                }
            } catch (Exception e) {
            }

        }

        mv = viewRequestAdminClick(request, response);
        return mv;
    }

    public ModelAndView searchEmpLeaveDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        LeaveEmployeeDetail leaveEmployeeDetail = new LeaveEmployeeDetail();
        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        selectEmployee(request, response);
        departmentList(request);
        designationList(request);
        readleaveType(request);
        List<?> list = (List<?>) request.getAttribute("leavelist");

        mv.getModelMap().put("employeeMaster", employeeMaster);
        request.setAttribute("list11", list);
        session.setAttribute("leaveListExcel", list);
        mv.setViewName("Leave/LeaveEmployeeDetailSearch");
        return mv;
    }

    public ModelAndView searchEmpLeaveDetailSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        LeaveEmployeeDetail leaveEmployeeDetail = new LeaveEmployeeDetail();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        LeaveTypeMaster leaveTypeMaster = new LeaveTypeMaster();
        String empId = request.getParameter("employeeName");
        String leaveTypeId = request.getParameter("leaveType");
        String departmentId = request.getParameter("departmentMaster");
        String designationId = request.getParameter("designationMaster");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");

        if (!empId.equals("")) {
            employeeMaster.setId(Integer.parseInt(empId));
        }
        leaveEmployeeDetail.setEmployeeMaster(employeeMaster);
        if (!leaveTypeId.equals("")) {
            leaveTypeMaster.setId(Integer.parseInt(leaveTypeId));
        }
        leaveEmployeeDetail.setLeaveTypeMaster(leaveTypeMaster);
        if (!departmentId.equals("")) {
            leaveEmployeeDetail.setStartDateStatus(departmentId);

        }
        if (!designationId.equals("")) {
            leaveEmployeeDetail.setEndDateStatus(designationId);

        }
        if (!startDate.equals("")) {
            leaveEmployeeDetail.setStartDate(startDate);
        }
        if (!endDate.equals("")) {
            leaveEmployeeDetail.setEndDate(endDate);
        }

        List<?> list = leaveEmployeeDetailService.readEmpLeave(leaveEmployeeDetail);
//        mv.getModelMap().put("leavelist", list);
        request.setAttribute("leavelist", list);
        mv = searchEmpLeaveDetail(request, response);
//        mv.setViewName("Leave/LeaveEmployeeDetailResult");
        return mv;
    }

    public ModelAndView searchOwnLeaveDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        LeaveEmployeeDetail leaveEmployeeDetail = new LeaveEmployeeDetail();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        UserMaster user = (UserMaster) request.getSession().getAttribute("user");
        employeeMaster.setUserMaster(user);
        List<?> empId = employeeMasterService.readByUserName(employeeMaster);
        if (!empId.isEmpty()) {
            employeeMaster = (EmployeeMaster) empId.get(0);
        }
        leaveEmployeeDetail.setEmployeeMaster(employeeMaster);
        List<?> empLeaveList = null;
        Object flag = request.getAttribute("flag");
        String flag1 = "";
        if (flag != null) {
            flag1 = flag.toString();
        }
        if (!flag1.equals("1")) {
            empLeaveList = leaveEmployeeDetailService.readEmpLeaveDetail(leaveEmployeeDetail);
        } else {
            empLeaveList = (List<?>) request.getAttribute("list11");
        }
        request.setAttribute("list", empLeaveList);

        addleaveType(request);
        request.setAttribute("empName", employeeMaster.getEmployeeName());
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.setViewName("Leave/LeaveOwnDetailSearch");
        return mv;
    }

    public ModelAndView searchOwnLeaveDetailSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        LeaveEmployeeDetail leaveEmployeeDetail = new LeaveEmployeeDetail();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        String leaveTypeId = request.getParameter("leaveType");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");

        UserMaster user = (UserMaster) request.getSession().getAttribute("user");
        employeeMaster.setUserMaster(user);
        List<?> empId = employeeMasterService.readByUserName(employeeMaster);
        if (!empId.isEmpty()) {
            employeeMaster = (EmployeeMaster) empId.get(0);
        }
        leaveEmployeeDetail.setEmployeeMaster(employeeMaster);

        if (!startDate.equals("")) {
            leaveEmployeeDetail.setStartDate(startDate);
        }
        if (!endDate.equals("")) {
            leaveEmployeeDetail.setEndDate(endDate);
        }
        if (!leaveTypeId.equals("")) {
            LeaveTypeMaster leaveTypeMaster = new LeaveTypeMaster();
            leaveTypeMaster = leaveTypeMasterService.readById(Integer.parseInt(leaveTypeId));
            leaveEmployeeDetail.setLeaveTypeMaster(leaveTypeMaster);
        } else {
            leaveEmployeeDetail.setLeaveTypeMaster(null);
        }

        List<?> list = leaveEmployeeDetailService.readEmpLeaveDetail(leaveEmployeeDetail);
//        List<?> list = leaveEmployeeDetailService.readOwnLeave(leaveEmployeeDetail);
        request.setAttribute("list11", list);
        request.setAttribute("flag", 1);
        mv = searchOwnLeaveDetail(request, response);
        return mv;
    }

    private void getNoOfDays(LeaveEmployeeDetail leaveEmployeeDetail, Date sDate, Date eDate) {

        EmployeeMaster employeeMaster = new EmployeeMaster();
        employeeMaster = employeeMasterService.readById(leaveEmployeeDetail.getEmployeeMaster().getId());

        Calendar c = Calendar.getInstance();
        c.setTime(sDate);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        List<String> list1 = new ArrayList<String>();
        float days = 0;
        while (c.getTime().before(eDate)) {
            if (c.get(Calendar.DAY_OF_WEEK) != c.get(Calendar.SUNDAY)) {
                Date nDate = c.getTime();
                String daString = sdf.format(nDate);
                HolidayMaster holidayMaster = new HolidayMaster();
                holidayMaster.setHolidayFromDate(daString);
                List list = holidayMasterService.checkHoliday(daString, "" + employeeMaster.getLocationMaster().getId());
                if (list.size() == 0) {
                    days++;
                }

            }
            c.add(Calendar.DATE, 1);

        }
        if (leaveEmployeeDetail.getStartDateStatus().equals("Fullday") && leaveEmployeeDetail.getEndDateStatus().equals("Fullday")) {
            leaveEmployeeDetail.setNoOfDays(days);
        } else if (leaveEmployeeDetail.getStartDateStatus().equals("Fullday") && leaveEmployeeDetail.getEndDateStatus() == "FirstHalf") {
            days = (float) (days - 0.5);
            leaveEmployeeDetail.setNoOfDays(days);
        } else if (leaveEmployeeDetail.getStartDateStatus().equals("SecondHalf") && leaveEmployeeDetail.getEndDateStatus().equals("FirstHalf")) {
            days = days - 1;
            leaveEmployeeDetail.setNoOfDays(days);
        } else if (leaveEmployeeDetail.getStartDateStatus().equals("SecondHalf") && leaveEmployeeDetail.getEndDateStatus().equals("Fullday")) {
            days = (float) (days - 0.5);
            leaveEmployeeDetail.setNoOfDays(days);
        }

    }

    public ModelAndView userDashboard(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        ZydexLocationMaster zydexLocationMaster = new ZydexLocationMaster();
        zydexLocationMaster = zydexLocationMasterService.readById(employeeMaster.getZydexLocationMaster().getId());
        EmployeeLeaveBalance employeeLeaveBalance = new EmployeeLeaveBalance();
        employeeLeaveBalance.setEmployeeMaster(employeeMaster);
        List totalLeaveList = employeeLeaveBalanceService.readByEmpId(employeeLeaveBalance);
        List<List> finalLeaveList = new ArrayList<List>();
        int count = 0;
        for (Iterator iterator = totalLeaveList.iterator(); iterator.hasNext();) {

            String[] colorStr = {"aqua", "red", "green", "yellow", "blue", "darkViolet", "lightCoral", "sienna"};
            List finalList = new ArrayList();
            try {
                double totalLeave = 0;
                double totalLeave1 = 0;
                double percantage = 0;
                double totalAppliedLeave = 0;
                Object[] o = (Object[]) iterator.next();
                String leaveType = (String) o[0];

                if ((zydexLocationMaster.getZydexLocation().equals("HO") || zydexLocationMaster.getZydexLocation().equals("R&D")) && leaveType.equals("Short Leave")) {
                } else {
                    if (leaveType.equals("Paternity Leave") && !employeeMaster.getGender()) {
                        iterator.remove();
                        continue;
                    } else if (leaveType.equals("Maternity Leave") && employeeMaster.getGender()) {
                        iterator.remove();
                        continue;
                    }
                    totalAppliedLeave = (Float) o[1];
                    int leaveId = (Integer) o[2];
                    LeaveEmployeeDetail leaveEmployeeDetail = new LeaveEmployeeDetail();
                    leaveEmployeeDetail.setEmployeeMaster(employeeMaster);
                    LeaveTypeMaster leaveTypeMaster = new LeaveTypeMaster();
                    leaveTypeMaster.setId(leaveId);
                    leaveEmployeeDetail.setLeaveTypeMaster(leaveTypeMaster);
                    List leaveWiseCountList = new ArrayList();
                    if (leaveType.equals("Short Leave")) {
                        leaveWiseCountList = leaveEmployeeDetailService.readApprovedShortLeaveDays(leaveEmployeeDetail);
                    } else {

                        leaveWiseCountList = leaveEmployeeDetailService.readApprovedLeaveDays(leaveEmployeeDetail);
                    }
                    double leaveCount = 0;
                    if (null != leaveWiseCountList.get(0)) {
                        leaveCount = (Double) leaveWiseCountList.get(0);
                    }
//                totalLeave = totalAppliedLeave;
                    totalLeave1 = leaveCount + totalAppliedLeave;
                    finalList.add(o[0]);
                    finalList.add(leaveCount);
                    finalList.add(totalLeave1);
                    percantage = (leaveCount * 100) / totalLeave1;
                    if (String.valueOf(percantage).equalsIgnoreCase("NaN")) {
                        percantage = 0;
                    }
                    finalList.add(percantage);
                    finalList.add(colorStr[count]);
                    finalLeaveList.add(finalList);
                    if (count > 8) {
                        count = 0;
                    }
                }
            } catch (Exception e) {

            }
            count++;
        }
        request.setAttribute("finalLeaveList", finalLeaveList);
        mv.setViewName("forward:employeeMaster.htm?act=userDashboard");
        return mv;
    }

    public ModelAndView userDashboardLeavePendingRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        LeaveEmployeeDetail leaveEmployeeDetail = new LeaveEmployeeDetail();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        EmployeeLeaveBalance employeeLeaveBalance = new EmployeeLeaveBalance();
        employeeLeaveBalance.setEmployeeMaster(employeeMaster);
        leaveEmployeeDetail.setEmployeeMaster(employeeMaster);
        List<?> list = leaveEmployeeDetailService.readPendingLeaveRequest(leaveEmployeeDetail);
        int pendingLeave = list.size();
        request.setAttribute("pendingLeave", pendingLeave);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date currentDate = new Date();
        int pendingApproverLeave = 0;
        List<?> list1 = leaveEmployeeDetailService.readPendingApproverLeaveRequest(leaveEmployeeDetail);
        for (Iterator<? extends Object> iterator = list1.iterator(); iterator.hasNext();) {
            Object[] next = (Object[]) iterator.next();
            try {

                String strdate = "" + next[2];
                String status = "" + next[3];
                sdf.parse(strdate);
                Calendar cal = Calendar.getInstance();
                cal.setTime(sdf.parse(strdate));
                Date dd = cal.getTime();
                Date addedDate = addDays(dd, 15);
                if (currentDate.equals(addedDate) || currentDate.before(addedDate)) {
                    if (Integer.parseInt(status) == 4) {
                        iterator.remove();
                    } else {
                        pendingApproverLeave = list1.size();
                    }
                    request.setAttribute("pendingApproverLeave", pendingApproverLeave);
                } else {
                    List<?> list2 = leaveEmployeeDetailService.readPendingApprover2LeaveRequest(leaveEmployeeDetail);
                    int pendingApprover2Leave = list2.size();
//                request.setAttribute("pendingApprover2Leave", pendingApprover2Leave);
                }
            } catch (Exception e) {

            }
        }
        List<?> withdrawlist = leaveEmployeeDetailService.readPendingLeaveRequest(leaveEmployeeDetail);
//        int pendingLeave = withdrawlist.size();
        request.setAttribute("pendingLeave", pendingLeave);
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        Date currentDate1 = new Date();
        List<?> withdrawlist1 = leaveEmployeeDetailService.readPendingApproverLeaveRequest(leaveEmployeeDetail);

        for (Iterator<? extends Object> iterator = withdrawlist1.iterator(); iterator.hasNext();) {
            int withdrawPendingList = 0;
            try {

                Object[] next = (Object[]) iterator.next();
                String strdate = "" + next[2];
                String status = "" + next[3];
                sdf.parse(strdate);
                Calendar cal = Calendar.getInstance();
                cal.setTime(sdf1.parse(strdate));
                Date dd = cal.getTime();
                Date addedDate = addDays(dd, 15);
                if (currentDate1.equals(addedDate) || currentDate.before(addedDate)) {
                    if (Integer.parseInt(status) == 0) {
                        iterator.remove();
                        withdrawPendingList = withdrawlist1.size();
                    } else {

                        withdrawPendingList = withdrawlist1.size();
                    }
                    request.setAttribute("withdrawPendingList", withdrawPendingList);
                }
            } catch (Exception e) {

            }
//            else {
//                int withdrawPendingList1 = 0;
//                List<?> withdrawlist2 = leaveEmployeeDetailService.readPendingApprover2LeaveRequest(leaveEmployeeDetail);
//                if (currentDate1.equals(addedDate) || currentDate.before(addedDate)) {
//                    if (Integer.parseInt(status) == 0) {
//                        iterator.remove();
//                    } else {
//
//                        withdrawPendingList1 = withdrawlist2.size();
//                    }
//                    request.setAttribute("withdrawPendingList", withdrawPendingList1);
//                }
//            }
        }

        mv.setViewName("forward:travelRequestMaster.htm?act=userDashboardTravelPendingRequest");
        return mv;
    }

    public ModelAndView searchPendingSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        LeaveEmployeeDetail leaveEmployeeDetail = new LeaveEmployeeDetail();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        leaveEmployeeDetail.setEmployeeMaster(employeeMaster);
        List<?> empLeaveList = leaveEmployeeDetailService.readPendingLeaveRequest(leaveEmployeeDetail);
        request.setAttribute("list", empLeaveList);
        mv.getModelMap().put("leaveEmployeeDetail", leaveEmployeeDetail);
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.setViewName("Leave/LeaveApplicationResult");
        return mv;
    }

    public void yearlyLeaveCountScheduler() {
        try {
            List leaveList = leaveTypeMasterService.readCarriedForwardLeave();
            float noOfLeave = 0;
            for (Object o : leaveList) {
                LeaveTypeMaster leaveTypeMaster = (LeaveTypeMaster) o;
                EmployeeLeaveBalance employeeLeaveBalance = new EmployeeLeaveBalance();
                employeeLeaveBalance.setLeaveTypeMaster(leaveTypeMaster);
                List list = employeeLeaveBalanceService.readByleaveTypeId(employeeLeaveBalance);
                for (Object o1 : list) {
                    employeeLeaveBalance = new EmployeeLeaveBalance();
                    employeeLeaveBalance = (EmployeeLeaveBalance) o1;
                    noOfLeave = Float.parseFloat(leaveTypeMaster.getNoOfLeave()) + employeeLeaveBalance.getNoOfLeaveRemain();

                    if (Float.parseFloat(leaveTypeMaster.getNoOfCarriedForwardLeave()) >= noOfLeave) {
                        employeeLeaveBalance.setNoOfLeaveRemain(noOfLeave);
                        employeeLeaveBalanceService.update(employeeLeaveBalance);
                    } else {
                        employeeLeaveBalance.setNoOfLeaveRemain(Float.parseFloat(leaveTypeMaster.getNoOfCarriedForwardLeave()));
                        employeeLeaveBalanceService.update(employeeLeaveBalance);
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    public ModelAndView approverSearch(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        LeaveEmployeeDetail leaveEmployeeDetail = new LeaveEmployeeDetail();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        selectEmployeeForParticularManager(request, response);
        readleaveType(request);
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.setViewName("Leave/LeaveManagerSearch");
        return mv;
    }

    public ModelAndView approverSearchResult(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        LeaveEmployeeDetail leaveEmployeeDetail = new LeaveEmployeeDetail();
        LeaveTypeMaster leaveTypeMaster = new LeaveTypeMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster1 = (EmployeeMaster) session.getAttribute("employeeInfo");
        int appId = employeeMaster1.getId();
        leaveEmployeeDetail.setApproverId(appId);
        String leaveTypeId = request.getParameter("leaveType");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String empId = request.getParameter("employeeName");

        if (!empId.equals("")) {
            employeeMaster.setId(Integer.parseInt(empId));
        }
        leaveEmployeeDetail.setEmployeeMaster(employeeMaster);
        if (!startDate.equals("")) {
            leaveEmployeeDetail.setStartDate(startDate);
        }
        if (!endDate.equals("")) {
            leaveEmployeeDetail.setEndDate(endDate);
        }
        if (!leaveTypeId.equals("")) {
            leaveTypeMaster.setId(Integer.parseInt(leaveTypeId));
        }
        leaveEmployeeDetail.setLeaveTypeMaster(leaveTypeMaster);

        List<?> list = leaveEmployeeDetailService.readapproverSearch(leaveEmployeeDetail);
        request.setAttribute("list", list);
        mv.setViewName("Leave/LeaveManagerSearchResult");
        return mv;
    }

    public void getActualDayByAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String strDate = request.getParameter("strDate");
        String enDate = request.getParameter("enDate");
        String sDateStatus = request.getParameter("sDateStatus");
        String eDateStatus = request.getParameter("eDateStatus");
        strDate = strDate.replaceAll(",", "/");
        enDate = enDate.replaceAll(",", "/");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date sDate = sdf.parse(strDate);
        Date eDate = sdf.parse(enDate);

        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster1 = (EmployeeMaster) session.getAttribute("employeeInfo");
        ShiftMaster shiftMaster = new ShiftMaster();
        HoursBasis hoursBasis = new HoursBasis();
        ShiftRotationMaster shiftRotationMaster = new ShiftRotationMaster();
        ShiftRotationInfo shiftRotationInfo = new ShiftRotationInfo();
        int appId = employeeMaster1.getId();
        String shiftType = employeeMaster1.getShiftType();
        String weekOffDay = "";
        if (shiftType.contains("ShiftBase")) {
            shiftRotationMaster = shiftRotationMasterService.readById(employeeMaster1.getShiftHoursId());
            String shiftId = shiftRotationInfoService.readFirstShfitId("" + employeeMaster1.getUserMaster().getId(), "" + shiftRotationMaster.getId());
            shiftMaster = shiftMasterService.readById(Integer.parseInt(shiftId));
            weekOffDay = shiftMaster.getWeekof();

        } else if (shiftType.contains("HourlyBase")) {
            hoursBasis = hoursBasisService.readById(employeeMaster1.getShiftHoursId());
            weekOffDay = hoursBasis.getWeekof();

        }

        Calendar c = Calendar.getInstance();
        c.setTime(sDate);
        List<String> list1 = new ArrayList<String>();
        float days = 0;
        while (c.getTime().before(eDate) || c.getTime().equals(eDate)) {
            for (String z : weekOffDay.split(",")) {
                int weekOff = 0;
                if (!z.equals("")) {
                    if (z.equals("sunday")) {
                        weekOff = 1;
                    } else if (z.equals("monday")) {
                        weekOff = 2;
                    } else if (z.equals("tuesday")) {
                        weekOff = 3;
                    } else if (z.equals("wednesday")) {
                        weekOff = 4;
                    } else if (z.equals("thursday")) {
                        weekOff = 5;
                    } else if (z.equals("friday")) {
                        weekOff = 6;
                    } else if (z.equals("saturdady")) {
                        weekOff = 7;
                    }

                    if (c.get(Calendar.DAY_OF_WEEK) != weekOff) {
                        Date nDate = c.getTime();
                        String daString = sdf.format(nDate);
                        HolidayMaster holidayMaster = new HolidayMaster();
                        holidayMaster.setHolidayFromDate(daString);
                        List list = holidayMasterService.checkHoliday(daString, "" + employeeMaster1.getLocationMaster().getId());
                        if (list.size() == 0) {
                            days++;
                        }
                    }
                }

            }
            c.add(Calendar.DATE, 1);

        }

        PrintWriter out = response.getWriter();
        out.print(days);
    }

    public synchronized void shortLeaveMonthWiseScheduler() {

        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeLeaveBalance employeeLeaveBalance = new EmployeeLeaveBalance();
        LeaveTypeMaster leaveTypeMaster = new LeaveTypeMaster();

        List<?> leaveType = leaveTypeMasterService.readLeaveType("Short Leave");
        if (!leaveType.isEmpty()) {
            leaveTypeMaster = (LeaveTypeMaster) leaveType.get(0);
            leaveTypeMaster.getId();
        }
        employeeLeaveBalance.setLeaveTypeMaster(leaveTypeMaster);
        List empBalancelist = employeeLeaveBalanceService.readByleaveTypeId(employeeLeaveBalance);
        if (!empBalancelist.isEmpty()) {

            for (Object zz : empBalancelist) {
                employeeLeaveBalance = (EmployeeLeaveBalance) zz;
                employeeLeaveBalance.setNoOfLeaveRemain(2);
                employeeLeaveBalanceService.update(employeeLeaveBalance);
//            System.out.println("Ajay");
            }
        } else {
            EmployeeMaster employeeMaster1 = new EmployeeMaster();
            List<?> empList = employeeMasterService.read();
            for (Object oo : empList) {
                employeeMaster1 = (EmployeeMaster) oo;
                employeeLeaveBalance.setEmployeeMaster(employeeMaster1);
                employeeLeaveBalance.setLeaveTypeMaster(leaveTypeMaster);
                employeeLeaveBalance.setNoOfLeaveRemain(2);
                employeeLeaveBalanceService.create(employeeLeaveBalance);
            }
        }
    }

    public ModelAndView exportToExcelForLeaveRequest(HttpServletRequest request, HttpServletResponse response, EmployeeMaster employeeMaster) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<?> leaveListExcel = (List<?>) request.getSession().getAttribute("leaveListExcel");
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=LeaveRequest.xls");
        mv.addObject("leaveListExcel", leaveListExcel);
        mv.setViewName("Leave/LeaveRequestExcelData");
        return mv;
    }

    public void checkWeekOffOrHolidayForSDate(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String strDate = request.getParameter("strDate");
//        String enDate = request.getParameter("enDate");

        strDate = strDate.replaceAll(",", "/");
//        enDate = enDate.replaceAll(",", "/");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date sDate = sdf.parse(strDate);
//        Date eDate = sdf.parse(enDate);

        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster1 = (EmployeeMaster) session.getAttribute("employeeInfo");
        ShiftMaster shiftMaster = new ShiftMaster();
        HoursBasis hoursBasis = new HoursBasis();
        ShiftRotationMaster shiftRotationMaster = new ShiftRotationMaster();
        ShiftRotationInfo shiftRotationInfo = new ShiftRotationInfo();
        int appId = employeeMaster1.getId();
        String shiftType = employeeMaster1.getShiftType();
        String weekOffDay = "";
        if (shiftType.contains("ShiftBase")) {
            shiftRotationMaster = shiftRotationMasterService.readById(employeeMaster1.getShiftHoursId());
            String shiftId = shiftRotationInfoService.readFirstShfitId("" + employeeMaster1.getUserMaster().getId(), "" + shiftRotationMaster.getId());
            shiftMaster = shiftMasterService.readById(Integer.parseInt(shiftId));
            weekOffDay = shiftMaster.getWeekof();

        } else if (shiftType.contains("HourlyBase")) {
            hoursBasis = hoursBasisService.readById(employeeMaster1.getShiftHoursId());
            weekOffDay = hoursBasis.getWeekof();
        }

        Calendar c = Calendar.getInstance();
        c.setTime(sDate);
        List<String> list1 = new ArrayList<String>();
        String message = "";

        for (String z : weekOffDay.split(",")) {
            int weekOff = 0;
            if (!z.equals("")) {
                if (z.equals("sunday")) {
                    weekOff = 1;
                } else if (z.equals("monday")) {
                    weekOff = 2;
                } else if (z.equals("tuesday")) {
                    weekOff = 3;
                } else if (z.equals("wednesday")) {
                    weekOff = 4;
                } else if (z.equals("thursday")) {
                    weekOff = 5;
                } else if (z.equals("friday")) {
                    weekOff = 6;
                } else if (z.equals("saturdady")) {
                    weekOff = 7;
                }
                Date nDate = c.getTime();
                String daString = sdf.format(nDate);
                HolidayMaster holidayMaster = new HolidayMaster();
                holidayMaster.setHolidayFromDate(daString);
                List list = holidayMasterService.checkHoliday(strDate, "" + employeeMaster1.getLocationMaster().getId());

                if (c.get(Calendar.DAY_OF_WEEK) == weekOff || list.size() > 0) {
                    message = "Selected Date is Holiday/WeekOff.So You can't Apply Leave on this Day.";
                }
            }
        }
        PrintWriter out = response.getWriter();
        out.print(message);
    }

    public void checkWeekOffOrHolidayForEDate(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String enDate = request.getParameter("enDate");
        enDate = enDate.replaceAll(",", "/");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date eDate = sdf.parse(enDate);

        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster1 = (EmployeeMaster) session.getAttribute("employeeInfo");
        ShiftMaster shiftMaster = new ShiftMaster();
        HoursBasis hoursBasis = new HoursBasis();
        ShiftRotationMaster shiftRotationMaster = new ShiftRotationMaster();
        ShiftRotationInfo shiftRotationInfo = new ShiftRotationInfo();
        int appId = employeeMaster1.getId();
        String shiftType = employeeMaster1.getShiftType();
        String weekOffDay = "";
        if (shiftType.contains("ShiftBase")) {
            shiftRotationMaster = shiftRotationMasterService.readById(employeeMaster1.getShiftHoursId());
            String shiftId = shiftRotationInfoService.readFirstShfitId("" + employeeMaster1.getUserMaster().getId(), "" + shiftRotationMaster.getId());
            shiftMaster = shiftMasterService.readById(Integer.parseInt(shiftId));
            weekOffDay = shiftMaster.getWeekof();

        }

        Calendar c = Calendar.getInstance();
        c.setTime(eDate);
        List<String> list1 = new ArrayList<String>();
        String message = "";

        for (String z : weekOffDay.split(",")) {
            int weekOff = 0;
            if (!z.equals("")) {
                if (z.equals("sunday")) {
                    weekOff = 1;
                } else if (z.equals("monday")) {
                    weekOff = 2;
                } else if (z.equals("tuesday")) {
                    weekOff = 3;
                } else if (z.equals("wednesday")) {
                    weekOff = 4;
                } else if (z.equals("thursday")) {
                    weekOff = 5;
                } else if (z.equals("friday")) {
                    weekOff = 6;
                } else if (z.equals("saturdady")) {
                    weekOff = 7;
                }
                Date nDate = c.getTime();
                String daString = sdf.format(nDate);
                HolidayMaster holidayMaster = new HolidayMaster();
                holidayMaster.setHolidayFromDate(daString);
                List list = holidayMasterService.checkHoliday(enDate, "" + employeeMaster1.getLocationMaster().getId());

                if (c.get(Calendar.DAY_OF_WEEK) == weekOff || list.size() > 0) {
                    message = "Selected Date is Holiday/WeekOff.So You can't Apply Leave on this Day.";
                }

            }
        }
        PrintWriter out = response.getWriter();
        out.print(message);
    }

    public void checkPresentOnSDate(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String strDate = request.getParameter("strDate");
        String sDateStatus = request.getParameter("sDateStatus");
        strDate = strDate.replaceAll(",", "/");
        EmployeeShiftData employeeShiftData = new EmployeeShiftData();
        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster1 = (EmployeeMaster) session.getAttribute("employeeInfo");

        String message = "";
        if (sDateStatus.equals("Fullday")) {
            employeeShiftData.setOutDateTime(strDate);
            employeeShiftData.setEmployeeMaster(employeeMaster1);
            List<?> list = employeeShiftDataService.checkTodayPresent(employeeShiftData);
            if (list.size() > 0) {
                message = "On This Day You Are Present";
            }
        }
        if (sDateStatus.equals("FirstHalf")) {
            employeeShiftData.setOutDateTime(strDate);
            employeeShiftData.setEmployeeMaster(employeeMaster1);
            List<?> list = employeeShiftDataService.checkTodayFirstHalfDayPresent(employeeShiftData);
            if (list.size() > 0) {
                message = "On This Day You Are Present";
            }
        }
        if (sDateStatus.equals("SecondHalf")) {
            employeeShiftData.setOutDateTime(strDate);
            employeeShiftData.setEmployeeMaster(employeeMaster1);
            List<?> list = employeeShiftDataService.checkTodaySecondHalfDayPresent(employeeShiftData);
            if (list.size() > 0) {
                message = "On This Day You Are Present";
            }
        }

        PrintWriter out = response.getWriter();
        out.print(message);
    }

    public void checkPresentOneDate(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String enDate = request.getParameter("enDate");
        String eDateStatus = request.getParameter("eDateStatus");
        enDate = enDate.replaceAll(",", "/");
        EmployeeShiftData employeeShiftData = new EmployeeShiftData();
        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster1 = (EmployeeMaster) session.getAttribute("employeeInfo");

        String message = "";
        if (eDateStatus.equals("Fullday")) {
            employeeShiftData.setOutDateTime(enDate);
            employeeShiftData.setEmployeeMaster(employeeMaster1);
            List<?> list = employeeShiftDataService.checkTodayPresent(employeeShiftData);
            if (list.size() > 0) {
                message = "On This Day You Are Present";
            }
        }
        if (eDateStatus.equals("FirstHalf")) {
            employeeShiftData.setOutDateTime(enDate);
            employeeShiftData.setEmployeeMaster(employeeMaster1);
            List<?> list = employeeShiftDataService.checkTodayFirstHalfDayPresent(employeeShiftData);
            if (list.size() > 0) {
                message = "On This Day You Are Present";
            }
        }
        if (eDateStatus.equals("SecondHalf")) {
            employeeShiftData.setOutDateTime(enDate);
            employeeShiftData.setEmployeeMaster(employeeMaster1);
            List<?> list = employeeShiftDataService.checkTodaySecondHalfDayPresent(employeeShiftData);
            if (list.size() > 0) {
                message = "On This Day You Are Present";
            }
        }

        PrintWriter out = response.getWriter();
        out.print(message);
    }

    public ModelAndView employeeLeaveApplication(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        LeaveEmployeeDetail leaveEmployeeDetail = new LeaveEmployeeDetail();
        selectEmployee(request, response);
        mv.getModelMap().put("leaveEmployeeDetail", leaveEmployeeDetail);
        mv.setViewName("Leave/LeaveApplicatioEmployeeSearch");
        return mv;
    }

    public ModelAndView employeeLeaveApplicationClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        LeaveEmployeeDetail leaveEmployeeDetail1 = new LeaveEmployeeDetail();
        LeaveEmployeeDetail leaveEmployeeDetail = new LeaveEmployeeDetail();
        leaveEmployeeDetail1.setLeaveTypeMaster(new LeaveTypeMaster());
        if (request.getAttribute("leaveEmployeeDetail") != null) {
            leaveEmployeeDetail1 = (LeaveEmployeeDetail) request.getAttribute("leaveEmployeeDetail");
        }
        LeaveTypeMaster leaveTypeMaster = new LeaveTypeMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        EmployeeMaster employeeMaster2 = new EmployeeMaster();
        EmployeeLeaveBalance employeeLeaveBalance = new EmployeeLeaveBalance();

        String empId = request.getParameter("employeeMasterId");
        employeeMaster2 = employeeMasterService.readById(Integer.parseInt(empId));

        addEmployeeLeave(request, employeeMaster2);

        ShortLeave shortLeave = new ShortLeave();
        shortLeave.setZydexLocationMaster(employeeMaster2.getZydexLocationMaster());
        List list = shortLeaveService.readByDept(shortLeave);
        try {
            shortLeave = (ShortLeave) list.get(0);
            request.setAttribute("shortLeaveHoursNo", shortLeave.getHoursNo());
        } catch (Exception e) {
        }
        COffLeaveMaster cOffLeaveMaster = new COffLeaveMaster();
        cOffLeaveMaster.setZydexLocationMaster(employeeMaster2.getZydexLocationMaster());
        List list1 = cOffLeaveMasterService.readByDept(cOffLeaveMaster);
        try {
            cOffLeaveMaster = (COffLeaveMaster) list1.get(0);
            request.setAttribute("coffLeaveHoursNo", cOffLeaveMaster.getHoursNo());
        } catch (Exception e) {
        }

        int reportingId = 0;
        employeeMaster.setUserMaster(employeeMaster2.getUserMaster());
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

        List<?> empId1 = employeeMasterService.readByUserName(employeeMaster2);
        if (!empId1.isEmpty()) {
            employeeMaster = (EmployeeMaster) empId1.get(0);
        }
        employeeLeaveBalance.setEmployeeMaster(employeeMaster);
        leaveEmployeeDetail.setEmployeeMaster(employeeMaster);
        List<?> empLeaveBalanceList = employeeLeaveBalanceService.readByEmpId(employeeLeaveBalance);
        Map<String, Float> listRemain = new LinkedHashMap<>();
        Map<String, Float> empReqMap = new LinkedHashMap<>();
        Map<String, Float> totalDaysMap = new LinkedHashMap<>();
        if (!empLeaveBalanceList.isEmpty()) {
            Iterator it = empLeaveBalanceList.iterator();
            while (it.hasNext()) {
                Object[] next = (Object[]) it.next();
                Float noOfDay = null;
                Float totalMap = null;
                Double zz = null;
                String name = "" + next[0];
                Float days = (float) next[1];
                if (employeeMaster2.getGender() && name.equals("Paternity Leave")) {
                    continue;
                }
                if (!employeeMaster2.getGender() && name.equals("Maternity Leave")) {
                    continue;
                }
                String leave1 = "" + next[2];
                leaveTypeMaster.setId(Integer.parseInt(leave1));
                leaveEmployeeDetail.setLeaveTypeMaster(leaveTypeMaster);
                List<?> listFirst = leaveEmployeeDetailService.readLeaveDays(leaveEmployeeDetail);
                if (!listFirst.isEmpty()) {
                    if (listFirst.get(0) != null) {
                        Object xx = (Object) listFirst.get(0);
                        zz = (double) xx;
                        noOfDay = (float) zz.floatValue();
                    }
                }
                //                Iterator it1 = listFirst.iterator();
                //                if (it1.hasNext()) {
                //                }
                if (noOfDay == null) {
                    noOfDay = (float) 0;
                }
                totalMap = days + noOfDay;
                if ("Short Leave".equals(name) || "Paternity Leave".equals(name) || "Maternity Leave".equals(name) || "Leave Without Pay".equals(name)) {
                    continue;
                } else {
                    listRemain.put(name, days);
                    empReqMap.put(name, noOfDay);
                    totalDaysMap.put(name, totalMap);
                }

            }

        }
        request.setAttribute("listRemain", listRemain);
        request.setAttribute("empReqMap", empReqMap);
        request.setAttribute("totalDaysMap", totalDaysMap);
        mv.getModelMap().put("leaveEmployeeDetail", leaveEmployeeDetail1);
        mv.setViewName("Leave/EmployeeLeaveApplicatioForm");
        return mv;
    }

    public ModelAndView employeeLeaveApplicationSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        LeaveEmployeeDetail leaveEmployeeDetail = new LeaveEmployeeDetail();
        LeaveTypeMaster leaveTypeMaster = new LeaveTypeMaster();
        BindException errors = new BindException(leaveEmployeeDetail, "leaveEmployeeDetail");
        bind(request, leaveEmployeeDetail);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster1 = (EmployeeMaster) session.getAttribute("employeeInfo");
        Date date = new Date();
        String approveDate = sdf.format(date);

        EmployeeMaster employeeMaster = new EmployeeMaster();

        String employeeId = request.getParameter("employeeId");
        EmployeeLeaveBalance employeeLeaveBalance = new EmployeeLeaveBalance();
        EmployeeLeaveBalance employeeLeaveBalance1 = new EmployeeLeaveBalance();
        Float balanceDay;
        Float noOfDay;

        List<?> empId = employeeMasterService.readEmployeeId(employeeId);
        if (!empId.isEmpty()) {
            employeeMaster = (EmployeeMaster) empId.get(0);
        }

        String strDateStatus = request.getParameter("leaveStartDate_SelectFullOrHalfId");
        String endDateStatus = request.getParameter("leaveEndDate_SelectFullOrHalfId");
        leaveEmployeeDetail.setStartDateStatus(strDateStatus);
        leaveEmployeeDetail.setEndDateStatus(endDateStatus);
        leaveEmployeeDetail.setEmployeeMaster(employeeMaster);
        leaveEmployeeDetail.setLeaveTypeMaster(leaveTypeMaster);
        leaveEmployeeDetail.setStatus(3);
        leaveEmployeeDetail.setApproveDate(approveDate);
        leaveEmployeeDetail.setApproverId(employeeMaster1.getId());

        leaveEmployeeDetailValidator.validate(mv, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            /// Because for Short Leave
//            leaveEmployeeDetail.setStartDate("");
//            leaveEmployeeDetail.setEndDate("");
            /// Because for Short Leave
//            mv.getModelMap().put("leaveEmployeeDetail", leaveEmployeeDetail);
            request.setAttribute("leaveEmployeeDetail", leaveEmployeeDetail);
            mv.addAllObjects(errors.getModel());
            mv = employeeLeaveApplicationClick(request, response);
//            mv.setViewName("Leave/LeaveApplicatioFormForEmployee");
//        }
//        else if (leaveEmployeeDetail.getNoOfDays() == 0) {             // Condition Added By Vinita (To validate Zero Days Leave)
//            request.setAttribute("failureMessage",
//                    "Error :You Cannot Apply Leave on Holiday or Week Off");
//            request.setAttribute("leaveEmployeeDetail", leaveEmployeeDetail);
//            mv.addAllObjects(errors.getModel());
//            mv = applyClick(request, response);
        } else {
            String leaveTypeMasterId = request.getParameter("leaveTypeMaster.id");
            if (!"".equals(leaveTypeMasterId)) {
                leaveTypeMaster.setId(Integer.parseInt(leaveTypeMasterId));
                leaveTypeMaster = leaveTypeMasterService.readById(leaveTypeMaster.getId());
                if (leaveTypeMaster.getLeaveType().contains("Short Leave")) {
                    leaveEmployeeDetail.setStartDate(request.getParameter("startDateShort"));
                    leaveEmployeeDetail.setEndDate(request.getParameter("endDateShort"));
                }
                employeeLeaveBalance.setLeaveTypeMaster(leaveTypeMaster);
            }
            employeeLeaveBalance1.setEmployeeMaster(employeeMaster);
            employeeLeaveBalance1.setLeaveTypeMaster(leaveTypeMaster);
            List<?> balanceList = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance1);
            if (!balanceList.isEmpty()) {
                employeeLeaveBalance1 = (EmployeeLeaveBalance) balanceList.get(0);
            }
            boolean balance = false;
            employeeLeaveBalance.setEmployeeMaster(employeeMaster);
            List<?> empLeaveBalanceList = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance);
            if (!empLeaveBalanceList.isEmpty()) {
                employeeLeaveBalance = (EmployeeLeaveBalance) empLeaveBalanceList.get(0);
                if (!leaveTypeMaster.getLeaveType().contains("Short Leave") && !leaveTypeMaster.getLeaveType().contains("C Off Leave")) {
                    if (leaveEmployeeDetail.getNoOfDays().floatValue() > employeeLeaveBalance.getNoOfLeaveRemain()) {
                        balance = true;
                    }
                } else {
                    balance = true;

                }
            }
            try {
                leaveTypeMaster = leaveTypeMasterService.readById(Integer.parseInt(leaveTypeMasterId));
                leaveTypeMaster.getMaxDayAllowedLeave();
                Date startDate = sdf.parse(leaveEmployeeDetail.getStartDate());
                Date endDate = sdf.parse(leaveEmployeeDetail.getEndDate());
                long diffDays1 = 0;
                List<?> list = new ArrayList();
//                if (leaveTypeMaster.getLeaveType().equals("Casual Leave")) {
//                    getNoOfDays(leaveEmployeeDetail, startDate, endDate);
//                }

                if (!startDate.after(endDate)) {
                    LeaveEmployeeDetail leaveEmployeeDetail1 = new LeaveEmployeeDetail();
                    leaveEmployeeDetail1.setEmployeeMaster(employeeMaster);
                    List<?> l1 = leaveEmployeeDetailService.readByEmployeeId(leaveEmployeeDetail1);
                    boolean flag = false;
                    for (Object leave1 : l1) {

                        leaveEmployeeDetail1 = (LeaveEmployeeDetail) leave1;
                        Date strDate1 = sdf.parse(leaveEmployeeDetail1.getStartDate());
                        Date endDate1 = sdf.parse(leaveEmployeeDetail1.getEndDate());
                        Integer id1 = leaveEmployeeDetail1.getLeaveTypeMaster().getId();

                        if ((startDate.equals(strDate1) || startDate.after(strDate1) && startDate.before(endDate1) || (endDate.after(strDate1) && endDate.before(endDate1)))) {
                            flag = true;
                            break;
                        } else {
                            flag = false;
                        }
                    }
                    if (leaveTypeMaster.getLeaveType().contains("Short Leave")) {
                        if (flag) {
                            request.setAttribute("failureMessage",
                                    "Error :You Have Already apply Leave On that Day...");
                            request.setAttribute("leaveEmployeeDetail", leaveEmployeeDetail);
                            mv = employeeLeaveApplicationClick(request, response);
                        } else {
                            leaveEmployeeDetail.setNoOfDays(Float.parseFloat("1"));
                            leaveEmployeeDetailService.create(leaveEmployeeDetail);
                            balanceDay = employeeLeaveBalance1.getNoOfLeaveRemain();
                            noOfDay = leaveEmployeeDetail.getNoOfDays();
                            balanceDay = balanceDay - noOfDay;
                            employeeLeaveBalance1.setNoOfLeaveRemain(balanceDay);
                            employeeLeaveBalanceService.update(employeeLeaveBalance1);

                            request.setAttribute("successMessage",
                                    "Information : The Information is saved Successfully.");
                            mv = employeeLeaveApplication(request, response);

                        }
//                        mv.setViewName("redirect:leaveEmployeeDetail.htm?act=searchOwnLeaveDetail");
                    } else if (leaveEmployeeDetail.getNoOfDays() > Float.parseFloat(leaveTypeMaster.getMaxDayAllowedLeave()) && !leaveTypeMaster.getLeaveType().contains("Maternity Leave") && !leaveTypeMaster.getLeaveType().contains("C Off Leave")
                            && !leaveTypeMaster.getLeaveType().contains("Sick Leave")) {
                        request.setAttribute("failureMessage",
                                "Error :No Of Days is Greater than maximum allowed Days...");
                        request.setAttribute("leaveEmployeeDetail", leaveEmployeeDetail);
                        mv = employeeLeaveApplicationClick(request, response);
                    } else if (flag) {
                        request.setAttribute("failureMessage",
                                "Error :You Have Already apply Leave On that Day...");
                        request.setAttribute("leaveEmployeeDetail", leaveEmployeeDetail);
                        mv = employeeLeaveApplicationClick(request, response);

                    } else if (leaveTypeMaster.getLeaveType().equals("Paternity Leave")) {

                        list = leaveEmployeeDetailService.readEmployeeWiseMaternity(leaveEmployeeDetail);
                        if (employeeMaster.getMaritalStatus().equals("UnMarried")) {
                            request.setAttribute("failureMessage",
                                    "Error :UnMarried Employee Should Not Apply Paternity Leave...");
                            request.setAttribute("leaveEmployeeDetail", leaveEmployeeDetail);
                            mv = employeeLeaveApplicationClick(request, response);
                        } else if (employeeMaster.getGender()) {
                            request.setAttribute("failureMessage",
                                    "Error :Female Employee Should Not Apply Paternity Leave...");
                            request.setAttribute("leaveEmployeeDetail", leaveEmployeeDetail);
                            mv = employeeLeaveApplicationClick(request, response);
                        } else if (list.size() >= 2) {
                            request.setAttribute("failureMessage",
                                    "Error :You have Only Apply 2 Time Paternity Leave Days...");
                            request.setAttribute("leaveEmployeeDetail", leaveEmployeeDetail);
                            mv = employeeLeaveApplicationClick(request, response);

                        } else if (balance) {
                            request.setAttribute("failureMessage",
                                    "Error :No Of Days is Greater than Leave Balance Days...");
                            request.setAttribute("leaveEmployeeDetail", leaveEmployeeDetail);
                            mv = employeeLeaveApplicationClick(request, response);

                        } else {
                            leaveEmployeeDetailService.create(leaveEmployeeDetail);
                            int leaveTypeId = leaveEmployeeDetail.getLeaveTypeMaster().getId();
                            LeaveTypeMaster leaveTypeMaster1 = leaveTypeMasterService.readById(leaveTypeId);
                            if (leaveTypeMaster1.getLeaveType().equals("Paternity Leave")) {
                                noOfDay = (float) 3.0;
                            }
                            balanceDay = employeeLeaveBalance1.getNoOfLeaveRemain();
                            noOfDay = leaveEmployeeDetail.getNoOfDays();
                            balanceDay = balanceDay - noOfDay;
                            employeeLeaveBalance1.setNoOfLeaveRemain(balanceDay);
                            employeeLeaveBalanceService.update(employeeLeaveBalance1);
                            request.setAttribute("successMessage",
                                    "Information : The Information is saved Successfully.");
                            mv = employeeLeaveApplication(request, response);
                        }
                    } else if (!leaveTypeMaster.getLeaveType().contains("Maternity Leave") && !leaveTypeMaster.getLeaveType().contains("Leave Without Pay") && leaveEmployeeDetail.getNoOfDays() > employeeLeaveBalance.getNoOfLeaveRemain()) {
                        request.setAttribute("failureMessage",
                                "Error :No Of Days is Greater than Leave Balance Days...");
                        request.setAttribute("leaveEmployeeDetail", leaveEmployeeDetail);
                        mv = employeeLeaveApplicationClick(request, response);

                    } else {
                        leaveEmployeeDetailService.create(leaveEmployeeDetail);
                        balanceDay = employeeLeaveBalance1.getNoOfLeaveRemain();
                        noOfDay = leaveEmployeeDetail.getNoOfDays();
                        balanceDay = balanceDay - noOfDay;
                        employeeLeaveBalance1.setNoOfLeaveRemain(balanceDay);
                        employeeLeaveBalanceService.update(employeeLeaveBalance1);
                        request.setAttribute("successMessage",
                                "Information : The Information is saved Successfully.");

                        mv = employeeLeaveApplication(request, response);
                    }
                } else {
                    request.setAttribute("failureMessage",
                            "Error : Please Insert start date before end date.");
                    request.setAttribute("leaveEmployeeDetail", leaveEmployeeDetail);
                    mv = employeeLeaveApplicationClick(request, response);
                }
            } catch (Exception e) {
                request.setAttribute("failureMessage",
                        "Error : Please Insert Valid Data.");
                request.setAttribute("leaveEmployeeDetail", leaveEmployeeDetail);
                mv = employeeLeaveApplicationClick(request, response);
            }
        }

        return mv;
    }

    public ModelAndView searchEmployeeLeaveBalance(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        LeaveEmployeeDetail leaveEmployeeDetail = new LeaveEmployeeDetail();
        EmployeeLeaveBalance employeeLeaveBalance = new EmployeeLeaveBalance();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        selectEmployee(request, response);
        departmentList(request);
        designationList(request);
        readleaveType(request);
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.setViewName("Leave/LeaveBalanceEmployeeWise");
        return mv;
    }

    public ModelAndView showEmployeeLeaveBalance(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        LeaveEmployeeDetail leaveEmployeeDetail = new LeaveEmployeeDetail();
        EmployeeMaster employeeMaster = new EmployeeMaster();

        Map<Integer, List<?>> map = new LinkedHashMap<Integer, List<?>>();
        String empId = request.getParameter("employeeName");
        String deptId = request.getParameter("departmentMaster");
        String desId = request.getParameter("designationMaster");
        HttpSession session = request.getSession();
        if (!"".equals(empId)) {
            employeeMaster.setId(Integer.parseInt(empId));
        }
        if (!"".equals(deptId)) {
            employeeMaster.setChild1(deptId);
        }
        if (!"".equals(desId)) {
            employeeMaster.setChild2(desId);
        }
        List<?> empList = employeeMasterService.readEmployeeForLeaveBalance(employeeMaster);
        Iterator itr = empList.iterator();
        while (itr.hasNext()) {
            LeaveTypeMaster leaveTypeMaster = new LeaveTypeMaster();
            LeaveTypeMaster leaveTypeMaster1 = new LeaveTypeMaster();
            LeaveTypeMaster leaveTypeMaster2 = new LeaveTypeMaster();
            LeaveTypeMaster leaveTypeMaster3 = new LeaveTypeMaster();
            EmployeeLeaveBalance employeeLeaveBalance = new EmployeeLeaveBalance();
            EmployeeLeaveBalance employeeLeaveBalance1 = new EmployeeLeaveBalance();
            EmployeeLeaveBalance employeeLeaveBalance2 = new EmployeeLeaveBalance();
            EmployeeLeaveBalance employeeLeaveBalance3 = new EmployeeLeaveBalance();
            try {

                Object[] next = (Object[]) itr.next();
                String employeeId = "" + next[0];
                employeeMaster = employeeMasterService.readById(Integer.parseInt(employeeId));

                List<String> empInfoList = new ArrayList();
                List<String> emplLeaveList = new ArrayList();
                empInfoList.add(employeeMaster.getEmployeeId());
                empInfoList.add(employeeMaster.getEmployeeName());
//            Casual Leave
                List leaveTypeList = leaveTypeMasterService.readLeaveType("Casual Leave");
                if (!leaveTypeList.isEmpty()) {
                    leaveTypeMaster = (LeaveTypeMaster) leaveTypeList.get(0);
                }
                employeeLeaveBalance.setEmployeeMaster(employeeMaster);
                employeeLeaveBalance.setLeaveTypeMaster(leaveTypeMaster);
                List balanceList = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance);
                if (!balanceList.isEmpty()) {
                    employeeLeaveBalance = (EmployeeLeaveBalance) balanceList.get(0);
                    empInfoList.add("" + employeeLeaveBalance.getNoOfLeaveRemain());

                } else {
                    empInfoList.add("");
                }
//            Sick Leave
                List leaveTypeList1 = leaveTypeMasterService.readLeaveType("Sick Leave");
                if (!leaveTypeList.isEmpty()) {
                    leaveTypeMaster1 = (LeaveTypeMaster) leaveTypeList1.get(0);
                }
                employeeLeaveBalance1.setEmployeeMaster(employeeMaster);
                employeeLeaveBalance1.setLeaveTypeMaster(leaveTypeMaster1);
                List balanceList1 = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance1);
                if (!balanceList1.isEmpty()) {
                    employeeLeaveBalance1 = (EmployeeLeaveBalance) balanceList1.get(0);
                    empInfoList.add("" + employeeLeaveBalance1.getNoOfLeaveRemain());
                } else {
                    empInfoList.add("");
                }
//            Privilege Leave
                List leaveTypeList2 = leaveTypeMasterService.readLeaveType("Privilege Leave");
                if (!leaveTypeList.isEmpty()) {
                    leaveTypeMaster2 = (LeaveTypeMaster) leaveTypeList2.get(0);
                }
                employeeLeaveBalance2.setEmployeeMaster(employeeMaster);
                employeeLeaveBalance2.setLeaveTypeMaster(leaveTypeMaster2);
                List balanceList2 = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance2);
                if (!balanceList2.isEmpty()) {
                    employeeLeaveBalance2 = (EmployeeLeaveBalance) balanceList2.get(0);
                    empInfoList.add("" + employeeLeaveBalance2.getNoOfLeaveRemain());
                } else {
                    empInfoList.add("");
                }
//            Privilege Leave
                List leaveTypeList3 = leaveTypeMasterService.readLeaveType("Paternity Leave");
                if (!leaveTypeList.isEmpty()) {
                    leaveTypeMaster3 = (LeaveTypeMaster) leaveTypeList3.get(0);
                }
                employeeLeaveBalance3.setEmployeeMaster(employeeMaster);
                employeeLeaveBalance3.setLeaveTypeMaster(leaveTypeMaster3);
                List balanceList3 = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance3);
                if (!balanceList3.isEmpty()) {
                    employeeLeaveBalance3 = (EmployeeLeaveBalance) balanceList3.get(0);
                    empInfoList.add("" + employeeLeaveBalance3.getNoOfLeaveRemain());
                } else {
                    empInfoList.add("");
                }
                String casualLeaveBalId = "" + employeeLeaveBalance.getId();
                String sickLeaveBalId = "" + employeeLeaveBalance1.getId();
                String privilegeLeaveBalId = "" + employeeLeaveBalance2.getId();
                String paternityLeaveBalId = "";
                if (employeeLeaveBalance3.getId() == null) {
                    paternityLeaveBalId = "0";
                } else {
                    paternityLeaveBalId = "" + employeeLeaveBalance3.getId();
                }
                empInfoList.add(casualLeaveBalId + "_" + sickLeaveBalId + "_" + privilegeLeaveBalId + "_" + paternityLeaveBalId);

                map.put(employeeMaster.getId(), empInfoList);
            } catch (Exception e) {

            }
        }

        request.setAttribute("employeeBalanceMap", map);
        session.setAttribute("sessionMapOfLeaveBalance", map);
        mv = searchEmployeeLeaveBalance(request, response);
        return mv;
    }

    public ModelAndView exportToExcelLeaveBalance(HttpServletRequest request, HttpServletResponse response, EmployeeMaster employeeMaster) throws Exception {
        ModelAndView mv = new ModelAndView();
        Map<Integer, List<?>> sessionMapOfLeaveBalance = (Map<Integer, List<?>>) request.getSession().getAttribute("sessionMapOfLeaveBalance");
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=EmployeeLeaveBalanceData.xls");
        mv.addObject("sessionMapOfLeaveBalance", sessionMapOfLeaveBalance);
        mv.setViewName("Leave/LeaveBalanceEmployeeWiseExportToExcel");
        return mv;
    }

    public ModelAndView readLeaveBalAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String leaveBalId = request.getParameter("leaveBalId");
        EmployeeLeaveBalance employeeLeaveBalance = new EmployeeLeaveBalance();
        LeaveTypeMaster leaveTypeMaster = new LeaveTypeMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();

        employeeLeaveBalance = employeeLeaveBalanceService.readById(Integer.parseInt(leaveBalId));
        leaveTypeMaster = leaveTypeMasterService.readById(employeeLeaveBalance.getLeaveTypeMaster().getId());
        employeeMaster = employeeMasterService.readById(employeeLeaveBalance.getEmployeeMaster().getId());
        request.setAttribute("employeeLeaveBalance", employeeLeaveBalance);
        request.setAttribute("employeeMaster", employeeMaster);
        request.setAttribute("leaveTypeMaster", leaveTypeMaster);
        mv.setViewName("Leave/LeaveEmployeeBalanceUpdate");

        return mv;
    }

    public void leaveBalUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String empLeaveBalId = request.getParameter("empLeaveBalId");
        String leaveBalance = request.getParameter("leaveBalance");

        EmployeeLeaveBalance employeeLeaveBalance = new EmployeeLeaveBalance();
        employeeLeaveBalance = employeeLeaveBalanceService.readById(Integer.parseInt(empLeaveBalId));
        employeeLeaveBalance.setNoOfLeaveRemain(Float.parseFloat(leaveBalance));
        employeeLeaveBalanceService.update(employeeLeaveBalance);

        PrintWriter out = response.getWriter();
        out.print("Information : The Information is Updated Successfully.");

    }

}
