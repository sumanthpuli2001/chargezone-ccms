/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.leave;

import com.bul.zydex.model.COffLeaveMaster;
import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.model.EmailAddMaster;
import com.bul.zydex.model.EmailTemplate;
import com.bul.zydex.model.EmployeeLeaveBalance;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.EmployeeShiftData;
import com.bul.zydex.model.HolidayMaster;
import com.bul.zydex.model.HoursBasis;
import com.bul.zydex.model.LeaveEmployeeDetail;
import com.bul.zydex.model.LeaveEmployeeDetailsApprovalHistory;
import com.bul.zydex.model.LeaveTypeMaster;
import com.bul.zydex.model.ShiftMaster;
import com.bul.zydex.model.ShiftRotationInfo;
import com.bul.zydex.model.ShiftRotationMaster;
import com.bul.zydex.model.ShortLeave;
import com.bul.zydex.model.UserMaster;
import com.bul.zydex.model.UserRightMaster;
import com.bul.zydex.model.ZydexLocationMaster;
import com.bul.zydex.service.shift.EmployeeShiftDataService;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
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
import org.exolab.castor.types.DateTime;
import org.json.JSONObject;
import org.springframework.aop.IntroductionAdvisor;
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
        float clBal = 0;
        float slBal = 0;
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
                Float zz = null;
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
                        zz = (float) xx;
                        noOfDay = zz;
                    }
                }
                if (name.equals("Casual Leave")) {
                    clBal = days;
                }
                if (name.equals("Sick Leave")) {
                    slBal = days;
                }
                //                Iterator it1 = listFirst.iterator();
                //                if (it1.hasNext()) {
                //                }
                if (noOfDay == null) {
                    noOfDay = (float) 0;
                }
                totalMap = days + noOfDay;
                if ("C Off Leave".equals(name) || "Short Leave".equals(name) || "Paternity Leave".equals(name) || "Maternity Leave".equals(name) || "Leave Without Pay".equals(name)) {
                    continue;
                } else {
                    listRemain.put(name, days);
                    empReqMap.put(name, noOfDay);
                    totalDaysMap.put(name, totalMap);
                }

            }

        }
        boolean plBalCheck = false;
        List<?> plCheck = leaveEmployeeDetailService.plLeaveCheck(employeeMaster.getId());
        if (plCheck.size() <= 3) {
            plBalCheck = true;
        }

        request.setAttribute("plBalCheck", plBalCheck);
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
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
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

        leaveEmployeeDetailValidator.validate(mv, errors);
        if (leaveEmployeeDetail.getLeaveTypeMaster().getId() == (11)) {
            if (leaveEmployeeDetail.getNoOfDays() == 0.8) {
                leaveEmployeeDetail.setNoOfDays(Float.parseFloat("" + 1));
            }
        }

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

        } else {
            boolean leaveCkeck = true;
            SimpleDateFormat format2 = new SimpleDateFormat("EEEE");
            try {
                Calendar cal6 = Calendar.getInstance();
                Calendar cal7 = Calendar.getInstance();
                Date satdateOfLeave = sdf.parse(leaveEmployeeDetail.getStartDate());
                cal6.setTime(satdateOfLeave);
                cal7.setTime(satdateOfLeave);

                LeaveTypeMaster leaveTypeMaster25 = new LeaveTypeMaster();
                leaveTypeMaster25 = leaveTypeMasterService.readById(leaveEmployeeDetail.getLeaveTypeMaster().getId());
                if (leaveTypeMaster25.isSandwichLeave() == false) {

                    String dayNameOfLeave = format2.format(satdateOfLeave);
                    if (dayNameOfLeave.equals("Monday") && leaveEmployeeDetail.getStartDateStatus().equals("Fullday")) {
                        LeaveEmployeeDetail leaveEmployeeDetail1 = new LeaveEmployeeDetail();
                        leaveEmployeeDetail1.setEmployeeMaster(employeeMaster);
                        cal6.add(Calendar.DAY_OF_MONTH, -2);
                        Date dateSet = cal6.getTime();
                        String dayName = format2.format(dateSet);
                        String finalDateSet = sdf.format(dateSet);
                        leaveEmployeeDetail1.setStartDate(finalDateSet);
                        int dayOfWeek = cal6.get(Calendar.WEEK_OF_MONTH);
                        boolean secondSatCheck = false;
                        if (employeeMaster.getZydexLocationMaster().getId() == 1 || employeeMaster.getZydexLocationMaster().getId() == 6) {
                            if (dayOfWeek == 2) {
                                secondSatCheck = true;
                            }
                        }
                        if (!secondSatCheck) {
                            List<?> satLeaveListCheck = leaveEmployeeDetailService.leaveCheck(leaveEmployeeDetail1);
                            if (!satLeaveListCheck.isEmpty()) {
                                LeaveEmployeeDetail leaveEmployeeDetail2 = (LeaveEmployeeDetail) satLeaveListCheck.get(0);
                                if ((leaveEmployeeDetail2.getStartDate()).equals(leaveEmployeeDetail2.getEndDate())
                                        && !leaveEmployeeDetail2.getStartDateStatus().contains("FirstHalf")
                                        && !leaveEmployeeDetail2.getStartDateStatus().contains("SecondHalf")) {
                                    LeaveTypeMaster leaveTypeMaster1 = new LeaveTypeMaster();
                                    leaveTypeMaster1.setId(leaveEmployeeDetail2.getLeaveTypeMaster().getId());
                                    leaveTypeMaster1 = leaveTypeMasterService.readById(leaveTypeMaster1.getId());
                                    if (leaveTypeMaster1.getLeaveType().contains("Casual Leave") && (leaveEmployeeDetail2.getLeaveTypeMaster().getId().equals(leaveEmployeeDetail.getLeaveTypeMaster().getId()))) {
                                        LeaveTypeMaster leaveTypeMaster2 = new LeaveTypeMaster();
                                        leaveTypeMaster2.setId(7);
                                        employeeLeaveBalance1.setEmployeeMaster(employeeMaster);
                                        employeeLeaveBalance1.setLeaveTypeMaster(leaveTypeMaster2);
                                        List<?> balanceList = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance1);
                                        if (!balanceList.isEmpty()) {
                                            employeeLeaveBalance1 = (EmployeeLeaveBalance) balanceList.get(0);
                                        }
                                        float noOfDays = 1 + leaveEmployeeDetail2.getNoOfDays() + leaveEmployeeDetail.getNoOfDays();
                                        if (employeeLeaveBalance1.getNoOfLeaveRemain() >= noOfDays) {
                                            leaveCkeck = true;
                                            leaveEmployeeDetail.setNoOfDays(noOfDays);
                                            leaveEmployeeDetail.setLeaveTypeMaster(leaveTypeMaster2);
                                            leaveEmployeeDetail.setStartDate(leaveEmployeeDetail2.getStartDate());
                                            EmployeeLeaveBalance employeeLeaveBalance2 = new EmployeeLeaveBalance();
                                            employeeLeaveBalance2.setEmployeeMaster(employeeMaster);
                                            employeeLeaveBalance2.setLeaveTypeMaster(leaveEmployeeDetail2.getLeaveTypeMaster());
                                            List<?> addBalanceList = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance2);
                                            employeeLeaveBalance2 = (EmployeeLeaveBalance) addBalanceList.get(0);
                                            float days = employeeLeaveBalance2.getNoOfLeaveRemain() + leaveEmployeeDetail2.getNoOfDays();
                                            employeeLeaveBalance2.setNoOfLeaveRemain(days);
                                            employeeLeaveBalanceService.update(employeeLeaveBalance2);
                                            leaveEmployeeDetailService.delete(leaveEmployeeDetail2.getId());

                                        } else {
                                            leaveCkeck = true;
                                            LeaveEmployeeDetail leaveEmployeeDetail3 = new LeaveEmployeeDetail();
                                            cal7.add(Calendar.DAY_OF_MONTH, -1);
                                            Date dateSet1 = cal7.getTime();
                                            String finalDateSet1 = sdf.format(dateSet1);
                                            leaveEmployeeDetail1.setStartDate(finalDateSet);
                                            leaveEmployeeDetail3.setEmployeeMaster(employeeMaster);
                                            leaveEmployeeDetail3.setStartDate(finalDateSet1);
                                            leaveEmployeeDetail3.setEndDate(finalDateSet1);
                                            LeaveTypeMaster leaveTypeMaster3 = new LeaveTypeMaster();
                                            leaveTypeMaster3.setId(12);
                                            leaveEmployeeDetail3.setLeaveTypeMaster(leaveTypeMaster3);
                                            leaveEmployeeDetail3.setStartDateStatus("Fullday");
                                            leaveEmployeeDetail3.setEndDateStatus("Fullday");
                                            leaveEmployeeDetail3.setNoOfDays(1.0f);
                                            leaveEmployeeDetail3.setStatus(0);
                                            SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                                            String currentDate = dateFormat1.format(new Date());
                                            leaveEmployeeDetail.setDateOfSubmit(currentDate);
                                            leaveEmployeeDetailService.create(leaveEmployeeDetail3);
                                        }

                                    } else if (!leaveTypeMaster1.getLeaveType().contains("Casual Leave") && (leaveEmployeeDetail2.getLeaveTypeMaster().getId().equals(leaveEmployeeDetail.getLeaveTypeMaster().getId()))) {
                                        employeeLeaveBalance1.setEmployeeMaster(employeeMaster);
                                        employeeLeaveBalance1.setLeaveTypeMaster(leaveEmployeeDetail.getLeaveTypeMaster());
                                        List<?> balanceList = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance1);
                                        if (!balanceList.isEmpty()) {
                                            employeeLeaveBalance1 = (EmployeeLeaveBalance) balanceList.get(0);
                                        }
                                        EmployeeLeaveBalance employeeLeaveBalance2 = new EmployeeLeaveBalance();
                                        employeeLeaveBalance2.setEmployeeMaster(employeeMaster);
                                        employeeLeaveBalance2.setLeaveTypeMaster(leaveEmployeeDetail2.getLeaveTypeMaster());
                                        List<?> addBalanceList = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance2);
                                        if (!addBalanceList.isEmpty()) {
                                            employeeLeaveBalance2 = (EmployeeLeaveBalance) addBalanceList.get(0);
                                        }
                                        float noOfDays = 1 + leaveEmployeeDetail2.getNoOfDays() + leaveEmployeeDetail.getNoOfDays();

                                        if (employeeLeaveBalance1.getNoOfLeaveRemain() >= noOfDays) {
                                            leaveCkeck = true;
                                            float days = employeeLeaveBalance1.getNoOfLeaveRemain() - 1;
                                            employeeLeaveBalance1.setNoOfLeaveRemain(days);
                                            employeeLeaveBalanceService.update(employeeLeaveBalance1);
                                            float addDays = leaveEmployeeDetail2.getNoOfDays() + 1.0f;
                                            leaveEmployeeDetail2.setNoOfDays(addDays);
                                            SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                                            String currentDate = dateFormat1.format(new Date());
                                            leaveEmployeeDetail.setDateOfSubmit(currentDate);
                                            leaveEmployeeDetailService.update(leaveEmployeeDetail2);
                                        } else {
                                            leaveCkeck = true;
                                            LeaveEmployeeDetail leaveEmployeeDetail3 = new LeaveEmployeeDetail();
                                            cal7.add(Calendar.DAY_OF_MONTH, -1);
                                            Date dateSet1 = cal7.getTime();
                                            String finalDateSet1 = sdf.format(dateSet1);
                                            leaveEmployeeDetail1.setStartDate(finalDateSet);
                                            leaveEmployeeDetail3.setEmployeeMaster(employeeMaster);
                                            leaveEmployeeDetail3.setStartDate(finalDateSet1);
                                            leaveEmployeeDetail3.setEndDate(finalDateSet1);
                                            LeaveTypeMaster leaveTypeMaster3 = new LeaveTypeMaster();
                                            leaveTypeMaster3.setId(12);
                                            leaveEmployeeDetail3.setLeaveTypeMaster(leaveTypeMaster3);
                                            leaveEmployeeDetail3.setStartDateStatus("Fullday");
                                            leaveEmployeeDetail3.setEndDateStatus("Fullday");
                                            leaveEmployeeDetail3.setNoOfDays(1.0f);
                                            leaveEmployeeDetail3.setStatus(0);
                                            SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                                            String currentDate = dateFormat1.format(new Date());
                                            leaveEmployeeDetail.setDateOfSubmit(currentDate);
                                            leaveEmployeeDetailService.create(leaveEmployeeDetail3);
                                        }
                                    } else if ((!leaveEmployeeDetail2.getLeaveTypeMaster().getId().equals(leaveEmployeeDetail.getLeaveTypeMaster().getId()))) {
                                        employeeLeaveBalance1.setEmployeeMaster(employeeMaster);
                                        employeeLeaveBalance1.setLeaveTypeMaster(leaveEmployeeDetail.getLeaveTypeMaster());
                                        List<?> balanceList = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance1);
                                        if (!balanceList.isEmpty()) {
                                            employeeLeaveBalance1 = (EmployeeLeaveBalance) balanceList.get(0);
                                        }
                                        EmployeeLeaveBalance employeeLeaveBalance2 = new EmployeeLeaveBalance();
                                        employeeLeaveBalance2.setEmployeeMaster(employeeMaster);
                                        employeeLeaveBalance2.setLeaveTypeMaster(leaveEmployeeDetail2.getLeaveTypeMaster());
                                        List<?> addBalanceList = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance2);
                                        if (!addBalanceList.isEmpty()) {
                                            employeeLeaveBalance2 = (EmployeeLeaveBalance) addBalanceList.get(0);
                                        }
                                        float noOfDays = 1;
                                        float noOfDays1 = 1 + leaveEmployeeDetail.getNoOfDays();
                                        if (employeeLeaveBalance1.getNoOfLeaveRemain() >= noOfDays1 && leaveEmployeeDetail.getNoOfDays() > Float.parseFloat(leaveTypeMaster1.getMaxDayAllowedLeave())) {
                                            leaveCkeck = true;
                                            leaveEmployeeDetail.setNoOfDays(noOfDays1);

                                        } else if (employeeLeaveBalance2.getNoOfLeaveRemain() >= noOfDays) {
                                            leaveCkeck = true;
                                            float days = employeeLeaveBalance2.getNoOfLeaveRemain() - 1.0f;
                                            employeeLeaveBalance2.setNoOfLeaveRemain(days);
                                            employeeLeaveBalanceService.update(employeeLeaveBalance2);
                                            float addDays = leaveEmployeeDetail2.getNoOfDays() + 1;
                                            leaveEmployeeDetail2.setNoOfDays(addDays);
                                            SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                                            String currentDate = dateFormat1.format(new Date());
                                            leaveEmployeeDetail2.setDateOfSubmit(currentDate);
                                            leaveEmployeeDetailService.update(leaveEmployeeDetail2);

                                        } else {
                                            leaveCkeck = true;
                                            LeaveEmployeeDetail leaveEmployeeDetail3 = new LeaveEmployeeDetail();
                                            cal7.add(Calendar.DAY_OF_MONTH, -1);
                                            Date dateSet1 = cal7.getTime();
                                            String finalDateSet1 = sdf.format(dateSet1);
                                            leaveEmployeeDetail1.setStartDate(finalDateSet);
                                            leaveEmployeeDetail3.setEmployeeMaster(employeeMaster);
                                            leaveEmployeeDetail3.setStartDate(finalDateSet1);
                                            leaveEmployeeDetail3.setEndDate(finalDateSet1);
                                            LeaveTypeMaster leaveTypeMaster3 = new LeaveTypeMaster();
                                            leaveTypeMaster3.setId(12);
                                            leaveEmployeeDetail3.setLeaveTypeMaster(leaveTypeMaster3);
                                            leaveEmployeeDetail3.setStartDateStatus("Fullday");
                                            leaveEmployeeDetail3.setEndDateStatus("Fullday");
                                            leaveEmployeeDetail3.setNoOfDays(1.0f);
                                            leaveEmployeeDetail3.setStatus(0);
                                            SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                                            String currentDate = dateFormat1.format(new Date());
                                            leaveEmployeeDetail.setDateOfSubmit(currentDate);
                                            leaveEmployeeDetailService.create(leaveEmployeeDetail3);
                                        }
                                    }
                                } else if (!(leaveEmployeeDetail2.getStartDate()).equals(leaveEmployeeDetail2.getEndDate())
                                        && !leaveEmployeeDetail2.getEndDateStatus().contains("FirstHalf")
                                        && !leaveEmployeeDetail2.getEndDateStatus().contains("SecondHalf")) {
                                    LeaveTypeMaster leaveTypeMaster1 = new LeaveTypeMaster();
                                    leaveTypeMaster1.setId(leaveEmployeeDetail2.getLeaveTypeMaster().getId());
                                    leaveTypeMaster1 = leaveTypeMasterService.readById(leaveTypeMaster1.getId());
                                    if (leaveTypeMaster1.getLeaveType().contains("Casual Leave") && (leaveEmployeeDetail2.getLeaveTypeMaster().getId().equals(leaveEmployeeDetail.getLeaveTypeMaster().getId()))) {
                                        LeaveTypeMaster leaveTypeMaster2 = new LeaveTypeMaster();
                                        leaveTypeMaster2.setId(7);
                                        employeeLeaveBalance1.setEmployeeMaster(employeeMaster);
                                        employeeLeaveBalance1.setLeaveTypeMaster(leaveTypeMaster2);
                                        List<?> balanceList = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance1);
                                        if (!balanceList.isEmpty()) {
                                            employeeLeaveBalance1 = (EmployeeLeaveBalance) balanceList.get(0);
                                        }
                                        float noOfDays = 1 + leaveEmployeeDetail2.getNoOfDays() + leaveEmployeeDetail.getNoOfDays();
                                        if (employeeLeaveBalance1.getNoOfLeaveRemain() >= noOfDays) {
                                            leaveCkeck = true;
                                            leaveEmployeeDetail.setNoOfDays(noOfDays);
                                            leaveEmployeeDetail.setLeaveTypeMaster(leaveTypeMaster2);
                                            leaveEmployeeDetail.setStartDate(leaveEmployeeDetail2.getStartDate());
                                            EmployeeLeaveBalance employeeLeaveBalance2 = new EmployeeLeaveBalance();
                                            employeeLeaveBalance2.setEmployeeMaster(employeeMaster);
                                            employeeLeaveBalance2.setLeaveTypeMaster(leaveEmployeeDetail2.getLeaveTypeMaster());
                                            List<?> addBalanceList = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance2);
                                            employeeLeaveBalance2 = (EmployeeLeaveBalance) addBalanceList.get(0);
                                            float days = employeeLeaveBalance2.getNoOfLeaveRemain() + leaveEmployeeDetail2.getNoOfDays();
                                            employeeLeaveBalance2.setNoOfLeaveRemain(days);
                                            employeeLeaveBalanceService.update(employeeLeaveBalance2);
                                            leaveEmployeeDetailService.delete(leaveEmployeeDetail2.getId());

                                        } else {
                                            leaveCkeck = true;
                                            LeaveEmployeeDetail leaveEmployeeDetail3 = new LeaveEmployeeDetail();
                                            cal7.add(Calendar.DAY_OF_MONTH, -1);
                                            Date dateSet1 = cal7.getTime();
                                            String finalDateSet1 = sdf.format(dateSet1);
                                            leaveEmployeeDetail1.setStartDate(finalDateSet);
                                            leaveEmployeeDetail3.setEmployeeMaster(employeeMaster);
                                            leaveEmployeeDetail3.setStartDate(finalDateSet1);
                                            leaveEmployeeDetail3.setEndDate(finalDateSet1);
                                            LeaveTypeMaster leaveTypeMaster3 = new LeaveTypeMaster();
                                            leaveTypeMaster3.setId(12);
                                            leaveEmployeeDetail3.setLeaveTypeMaster(leaveTypeMaster3);
                                            leaveEmployeeDetail3.setStartDateStatus("Fullday");
                                            leaveEmployeeDetail3.setEndDateStatus("Fullday");
                                            leaveEmployeeDetail3.setNoOfDays(1.0f);
                                            leaveEmployeeDetail3.setStatus(0);
                                            SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                                            String currentDate = dateFormat1.format(new Date());
                                            leaveEmployeeDetail.setDateOfSubmit(currentDate);
                                            leaveEmployeeDetailService.create(leaveEmployeeDetail3);
                                        }

                                    } else if (!leaveTypeMaster1.getLeaveType().contains("Casual Leave") && (leaveEmployeeDetail2.getLeaveTypeMaster().getId().equals(leaveEmployeeDetail.getLeaveTypeMaster().getId()))) {
                                        employeeLeaveBalance1.setEmployeeMaster(employeeMaster);
                                        employeeLeaveBalance1.setLeaveTypeMaster(leaveEmployeeDetail.getLeaveTypeMaster());
                                        List<?> balanceList = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance1);
                                        if (!balanceList.isEmpty()) {
                                            employeeLeaveBalance1 = (EmployeeLeaveBalance) balanceList.get(0);
                                        }
                                        EmployeeLeaveBalance employeeLeaveBalance2 = new EmployeeLeaveBalance();
                                        employeeLeaveBalance2.setEmployeeMaster(employeeMaster);
                                        employeeLeaveBalance2.setLeaveTypeMaster(leaveEmployeeDetail2.getLeaveTypeMaster());
                                        List<?> addBalanceList = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance2);
                                        if (!addBalanceList.isEmpty()) {
                                            employeeLeaveBalance2 = (EmployeeLeaveBalance) addBalanceList.get(0);
                                        }
                                        float noOfDays = 1 + leaveEmployeeDetail2.getNoOfDays() + leaveEmployeeDetail.getNoOfDays();

                                        if (employeeLeaveBalance1.getNoOfLeaveRemain() >= noOfDays) {
                                            leaveCkeck = true;
                                            float days = employeeLeaveBalance1.getNoOfLeaveRemain() - 1;
                                            employeeLeaveBalance1.setNoOfLeaveRemain(days);
                                            employeeLeaveBalanceService.update(employeeLeaveBalance1);
                                            float addDays = leaveEmployeeDetail2.getNoOfDays() + 1.0f;
                                            leaveEmployeeDetail2.setNoOfDays(addDays);
                                            SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                                            String currentDate = dateFormat1.format(new Date());
                                            leaveEmployeeDetail2.setDateOfSubmit(currentDate);
                                            leaveEmployeeDetailService.update(leaveEmployeeDetail2);
                                        } else {
                                            leaveCkeck = true;
                                            LeaveEmployeeDetail leaveEmployeeDetail3 = new LeaveEmployeeDetail();
                                            cal7.add(Calendar.DAY_OF_MONTH, -1);
                                            Date dateSet1 = cal7.getTime();
                                            String finalDateSet1 = sdf.format(dateSet1);
                                            leaveEmployeeDetail1.setStartDate(finalDateSet);
                                            leaveEmployeeDetail3.setEmployeeMaster(employeeMaster);
                                            leaveEmployeeDetail3.setStartDate(finalDateSet1);
                                            leaveEmployeeDetail3.setEndDate(finalDateSet1);
                                            LeaveTypeMaster leaveTypeMaster3 = new LeaveTypeMaster();
                                            leaveTypeMaster3.setId(12);
                                            leaveEmployeeDetail3.setLeaveTypeMaster(leaveTypeMaster3);
                                            leaveEmployeeDetail3.setStartDateStatus("Fullday");
                                            leaveEmployeeDetail3.setEndDateStatus("Fullday");
                                            leaveEmployeeDetail3.setNoOfDays(1.0f);
                                            leaveEmployeeDetail3.setStatus(0);
                                            SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                                            String currentDate = dateFormat1.format(new Date());
                                            leaveEmployeeDetail.setDateOfSubmit(currentDate);
                                            leaveEmployeeDetailService.create(leaveEmployeeDetail3);
                                        }
                                    } else if ((!leaveEmployeeDetail2.getLeaveTypeMaster().getId().equals(leaveEmployeeDetail.getLeaveTypeMaster().getId()))) {
                                        employeeLeaveBalance1.setEmployeeMaster(employeeMaster);
                                        employeeLeaveBalance1.setLeaveTypeMaster(leaveEmployeeDetail.getLeaveTypeMaster());
                                        List<?> balanceList = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance1);
                                        if (!balanceList.isEmpty()) {
                                            employeeLeaveBalance1 = (EmployeeLeaveBalance) balanceList.get(0);
                                        }
                                        EmployeeLeaveBalance employeeLeaveBalance2 = new EmployeeLeaveBalance();
                                        employeeLeaveBalance2.setEmployeeMaster(employeeMaster);
                                        employeeLeaveBalance2.setLeaveTypeMaster(leaveEmployeeDetail2.getLeaveTypeMaster());
                                        List<?> addBalanceList = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance2);
                                        if (!addBalanceList.isEmpty()) {
                                            employeeLeaveBalance2 = (EmployeeLeaveBalance) addBalanceList.get(0);
                                        }
                                        float noOfDays = 1;
                                        float noOfDays1 = 1 + leaveEmployeeDetail.getNoOfDays();
                                        if (employeeLeaveBalance1.getNoOfLeaveRemain() >= noOfDays1 && leaveEmployeeDetail.getNoOfDays() > Float.parseFloat(leaveTypeMaster1.getMaxDayAllowedLeave())) {
                                            leaveCkeck = true;
                                            leaveEmployeeDetail.setNoOfDays(noOfDays1);

                                        } else if (employeeLeaveBalance2.getNoOfLeaveRemain() >= noOfDays) {
                                            leaveCkeck = true;
                                            float days = employeeLeaveBalance2.getNoOfLeaveRemain() - 1.0f;
                                            employeeLeaveBalance2.setNoOfLeaveRemain(days);
                                            employeeLeaveBalanceService.update(employeeLeaveBalance2);
                                            float addDays = leaveEmployeeDetail2.getNoOfDays() + 1;
                                            leaveEmployeeDetail2.setNoOfDays(addDays);
                                            SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                                            String currentDate = dateFormat1.format(new Date());
                                            leaveEmployeeDetail2.setDateOfSubmit(currentDate);
                                            leaveEmployeeDetailService.update(leaveEmployeeDetail2);

                                        } else {
                                            leaveCkeck = true;
                                            LeaveEmployeeDetail leaveEmployeeDetail3 = new LeaveEmployeeDetail();
                                            cal7.add(Calendar.DAY_OF_MONTH, -1);
                                            Date dateSet1 = cal7.getTime();
                                            String finalDateSet1 = sdf.format(dateSet1);
                                            leaveEmployeeDetail1.setStartDate(finalDateSet);
                                            leaveEmployeeDetail3.setEmployeeMaster(employeeMaster);
                                            leaveEmployeeDetail3.setStartDate(finalDateSet1);
                                            leaveEmployeeDetail3.setEndDate(finalDateSet1);
                                            LeaveTypeMaster leaveTypeMaster3 = new LeaveTypeMaster();
                                            leaveTypeMaster3.setId(12);
                                            leaveEmployeeDetail3.setLeaveTypeMaster(leaveTypeMaster3);
                                            leaveEmployeeDetail3.setStartDateStatus("Fullday");
                                            leaveEmployeeDetail3.setEndDateStatus("Fullday");
                                            leaveEmployeeDetail3.setNoOfDays(1.0f);
                                            leaveEmployeeDetail3.setStatus(0);
                                            SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                                            String currentDate = dateFormat1.format(new Date());
                                            leaveEmployeeDetail.setDateOfSubmit(currentDate);
                                            leaveEmployeeDetailService.create(leaveEmployeeDetail3);
                                        }
                                    }
                                }

                            }
                        }
                    }
                }
            } catch (Exception e) {

            }

            String leaveTypeMasterId = request.getParameter("leaveTypeMaster.id");
            if (!"".equals(leaveTypeMasterId) && leaveTypeMasterId.equals("12")) {

                SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                String currentDate = dateFormat1.format(new Date());
                leaveEmployeeDetail.setDateOfSubmit(currentDate);
                leaveEmployeeDetailService.create(leaveEmployeeDetail);

//            
                request.setAttribute("successMessage",
                        "Information : The Information is saved Successfully.");
                mv = searchOwnLeaveDetail(request, response);
                //Emailtemplate for submit click .....
                try {
                    Mailsend(request);
                    String startdate = leaveEmployeeDetail.getStartDate();
                    String enddate = leaveEmployeeDetail.getEndDate();
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
                    msg = msg.replaceAll("\\{start_date\\}", startdate);
                    msg = msg.replaceAll("\\{end_date\\}", enddate);
                    msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                    msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                    sendMail.sendMail(from, To, Subject, msg);
                } catch (Exception e) {

                }

            } else {
                if (!"".equals(leaveTypeMasterId)) {
                    leaveTypeMaster.setId(Integer.parseInt(leaveTypeMasterId));
                    if (leaveCkeck) {
                        leaveTypeMaster = leaveTypeMasterService.readById(leaveEmployeeDetail.getLeaveTypeMaster().getId());
                    } else {
                        leaveTypeMaster = leaveTypeMasterService.readById(leaveTypeMaster.getId());
                    }
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
                Float shortLeaveCount = 0.0f;
                List<?> empLeaveBalanceList = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance);
                if (!empLeaveBalanceList.isEmpty()) {
                    employeeLeaveBalance = (EmployeeLeaveBalance) empLeaveBalanceList.get(0);
                    shortLeaveCount = employeeLeaveBalance.getNoOfLeaveRemain();
                    if (!leaveTypeMaster.getLeaveType().contains("Short Leave") && !leaveTypeMaster.getLeaveType().contains("C Off Leave")) {
                        if (leaveEmployeeDetail.getNoOfDays().floatValue() > employeeLeaveBalance.getNoOfLeaveRemain()) {
                            balance = true;
                        }
                    } else {
                        balance = true;

                    }
                }
                try {
                    if (leaveCkeck) {
                        leaveTypeMaster = leaveTypeMasterService.readById(leaveEmployeeDetail.getLeaveTypeMaster().getId());
                    } else {
                        leaveTypeMaster = leaveTypeMasterService.readById(Integer.parseInt(leaveTypeMasterId));
                    }
                    leaveTypeMaster.getMaxDayAllowedLeave();
                    Date startDate = sdf.parse(leaveEmployeeDetail.getStartDate());
                    Date endDate = sdf.parse(leaveEmployeeDetail.getEndDate());
                    long diffDays1 = 0;
                    List<?> list = new ArrayList();
//                if (leaveTypeMaster.getLeaveType().equals("Casual Leave")) {
//                    getNoOfDays(leaveEmployeeDetail, startDate, endDate);
//                }
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/YYYY");
                    Calendar cal5 = Calendar.getInstance();
                    Date satdate = sdf.parse(leaveEmployeeDetail.getStartDate());
                    cal5.setTime(satdate);
                    String dayName = format2.format(satdate);
                    int dayOfWeek = cal5.get(Calendar.WEEK_OF_MONTH);
                    int locationId = employeeMaster.getZydexLocationMaster().getId();

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
                        boolean plBalCheck = false;
                        List<?> plCheck = leaveEmployeeDetailService.plLeaveCheck(employeeMaster.getId());
                        if (plCheck.size() >= 3) {
                            plBalCheck = true;
                        }

                        if (leaveTypeMaster.getLeaveType().contains("Short Leave")) {

                            flag = false;

                            if (dayName.equals("Saturday") && dayOfWeek == 2 && (locationId == 1 || locationId == 6)) {
                                request.setAttribute("failureMessage",
                                        "Error :On Second Saturday You can Not Apply Short Leave");
                                request.setAttribute("leaveEmployeeDetail", leaveEmployeeDetail);
                                mv = applyClick(request, response);
                            } else if (flag) {
                                request.setAttribute("failureMessage",
                                        "Error :You Have Already apply Leave On that Day...");
                                request.setAttribute("leaveEmployeeDetail", leaveEmployeeDetail);
                                mv = applyClick(request, response);
                            } else if (shortLeaveCount > 0) {
                                String shrLeave = request.getParameter("noOfDayLeave");
                                int srtLeave1 = Integer.parseInt(shrLeave);

                                SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                                String currentDate = dateFormat1.format(new Date());
                                leaveEmployeeDetail.setDateOfSubmit(currentDate);
                                leaveEmployeeDetailService.create(leaveEmployeeDetail);

                                balanceDay = employeeLeaveBalance1.getNoOfLeaveRemain();

                                if (srtLeave1 == 1 && balanceDay >= 1) {

                                    leaveEmployeeDetail.setNoOfDays(Float.parseFloat("1"));
                                    noOfDay = leaveEmployeeDetail.getNoOfDays();
                                    balanceDay = balanceDay - noOfDay;
                                    employeeLeaveBalance1.setNoOfLeaveRemain(balanceDay);
                                    employeeLeaveBalanceService.update(employeeLeaveBalance1);

                                    request.setAttribute("successMessage",
                                            "Information : The Information is saved Successfully.");
                                    mv = searchOwnLeaveDetail(request, response);

                                    //Emailtemplate for submit click .....
                                    try {
                                        Mailsend(request);
                                        String startdate = leaveEmployeeDetail.getStartDate();
                                        String enddate = leaveEmployeeDetail.getEndDate();
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
                                        msg = msg.replaceAll("\\{start_date\\}", startdate);
                                        msg = msg.replaceAll("\\{end_date\\}", enddate);
                                        msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                                        msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                                        sendMail.sendMail(from, To, Subject, msg);
                                    } catch (Exception e) {

                                    }
                                } else if (srtLeave1 == 2 && balanceDay >= 2) {

                                    leaveEmployeeDetail.setNoOfDays(Float.parseFloat("2"));
                                    noOfDay = leaveEmployeeDetail.getNoOfDays();
                                    balanceDay = balanceDay - noOfDay;
                                    employeeLeaveBalance1.setNoOfLeaveRemain(balanceDay);
                                    employeeLeaveBalanceService.update(employeeLeaveBalance1);

                                    request.setAttribute("successMessage",
                                            "Information : The Information is saved Successfully.");
                                    mv = searchOwnLeaveDetail(request, response);

                                    //Emailtemplate for submit click .....
                                    try {
                                        Mailsend(request);
                                        String startdate = leaveEmployeeDetail.getStartDate();
                                        String enddate = leaveEmployeeDetail.getEndDate();
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
                                        msg = msg.replaceAll("\\{start_date\\}", startdate);
                                        msg = msg.replaceAll("\\{end_date\\}", enddate);
                                        msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                                        msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                                        sendMail.sendMail(from, To, Subject, msg);
                                    } catch (Exception e) {

                                    }

                                } else if (srtLeave1 == 3 && balanceDay == 3) {
                                    leaveEmployeeDetail.setNoOfDays(Float.parseFloat("3"));
                                    noOfDay = leaveEmployeeDetail.getNoOfDays();
                                    balanceDay = balanceDay - noOfDay;
                                    employeeLeaveBalance1.setNoOfLeaveRemain(balanceDay);
                                    employeeLeaveBalanceService.update(employeeLeaveBalance1);

                                    request.setAttribute("successMessage",
                                            "Information : The Information is saved Successfully.");
                                    mv = searchOwnLeaveDetail(request, response);

                                    //Emailtemplate for submit click .....
                                    try {
                                        Mailsend(request);
                                        String startdate = leaveEmployeeDetail.getStartDate();
                                        String enddate = leaveEmployeeDetail.getEndDate();
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
                                        msg = msg.replaceAll("\\{start_date\\}", startdate);
                                        msg = msg.replaceAll("\\{end_date\\}", enddate);
                                        msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                                        msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                                        sendMail.sendMail(from, To, Subject, msg);
                                    } catch (Exception e) {

                                    }
                                } else {
                                    request.setAttribute("failureMessage",
                                            "Error :Your Short Leave limit is over so you can't apply.");
                                    mv = searchOwnLeaveDetail(request, response);
                                }

                            } else {
                                request.setAttribute("failureMessage",
                                        "Error :Your Short Leave limit is over so you can't apply.");
                                mv = searchOwnLeaveDetail(request, response);
                            }
//                        mv.setViewName("redirect:leaveEmployeeDetail.htm?act=searchOwnLeaveDetail");
                        } else if (dayName.equals("Saturday") && dayOfWeek == 2 && (locationId == 1 || locationId == 6) && leaveEmployeeDetail.getStartDateStatus().equals("Fullday")) {
                            request.setAttribute("failureMessage",
                                    "Error :On Second Saturday You can Not Apply Full Day Of Leave");
                            request.setAttribute("leaveEmployeeDetail", leaveEmployeeDetail);
                            mv = applyClick(request, response);
                        } else if (plBalCheck && leaveTypeMaster.getLeaveType().contains("Privilege Leave") && leaveEmployeeDetail.getNoOfDays() < 3) {
                            request.setAttribute("failureMessage",
                                    "Error :Your Pl Limit for less dhen 3 is over so you can't apply less than 3 days pl leave.");
                            request.setAttribute("leaveEmployeeDetail", leaveEmployeeDetail);
                            mv = applyClick(request, response);
                        } else if (leaveEmployeeDetail.getNoOfDays() > Float.parseFloat(leaveTypeMaster.getMaxDayAllowedLeave()) && !leaveTypeMaster.getLeaveType().contains("Privilege Leave") && !leaveTypeMaster.getLeaveType().contains("Maternity Leave") && !leaveTypeMaster.getLeaveType().contains("C Off Leave")
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
                        } else if (!leaveCkeck) {
                            request.setAttribute("failureMessage",
                                    "Error :Your Balance Is Less then Your apply Leave Days.");
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
                                SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                                String currentDate = dateFormat1.format(new Date());
                                leaveEmployeeDetail.setDateOfSubmit(currentDate);
                                leaveEmployeeDetailService.create(leaveEmployeeDetail);
                                try {
                                    Mailsend(request);
                                } catch (Exception e) {
                                }
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

                        } else if (leaveTypeMaster.getLeaveType().contains("Sick Leave")) {
                            ////////////// code to check continue 3days

                            Calendar calenderSick = Calendar.getInstance();
                            Date dateOfSickLeave = sdf.parse(leaveEmployeeDetail.getStartDate());
                            calenderSick.setTime(dateOfSickLeave);
                            String dayNameOfLeave = format2.format(dateOfSickLeave);

                            ///////////2day         
                            LeaveEmployeeDetail LED = new LeaveEmployeeDetail();
                            LED.setEmployeeMaster(employeeMaster);
                            calenderSick.add(Calendar.DAY_OF_MONTH, -2);
                            Date dateSet = calenderSick.getTime();
                            String finalDateSet = sdf.format(dateSet);
                            LED.setStartDate(finalDateSet);
                            List<?> TwodayBeforeLeaveCheckList = leaveEmployeeDetailService.sickleaveCheck(LED);
                            //////1day
                            LeaveEmployeeDetail led1dayBefore = new LeaveEmployeeDetail();
                            led1dayBefore.setEmployeeMaster(employeeMaster);
                            calenderSick.add(Calendar.DAY_OF_MONTH, +1);
                            Date day1before = calenderSick.getTime();
                            String finalday1before = sdf.format(day1before);
                            led1dayBefore.setStartDate(finalday1before);
                            List<?> OnedayBeforeLeaveCheckList = leaveEmployeeDetailService.sickleaveCheck(led1dayBefore);

                            ///////////////////////////////////////////////////
                            Calendar calenderSickAfter = Calendar.getInstance();
                            calenderSickAfter.setTime(dateOfSickLeave);

                            ///////////2day         
                            LeaveEmployeeDetail TwodayAfter = new LeaveEmployeeDetail();
                            TwodayAfter.setEmployeeMaster(employeeMaster);
                            calenderSickAfter.add(Calendar.DAY_OF_MONTH, +2);
                            Date dateSetSickAfter = calenderSickAfter.getTime();
                            String finalDateSetSickAfter = sdf.format(dateSetSickAfter);
                            TwodayAfter.setStartDate(finalDateSetSickAfter);
                            List<?> TwodayAfterLeaveCheckList = leaveEmployeeDetailService.sickleaveCheck(TwodayAfter);
                            //////1day
                            LeaveEmployeeDetail led1dayAfter = new LeaveEmployeeDetail();
                            led1dayAfter.setEmployeeMaster(employeeMaster);
                            calenderSickAfter.add(Calendar.DAY_OF_MONTH, -1);
                            Date day1After = calenderSickAfter.getTime();
                            String finalday1After = sdf.format(day1After);
                            led1dayAfter.setStartDate(finalday1After);
                            List<?> OnedayAfterLeaveCheckList = leaveEmployeeDetailService.sickleaveCheck(led1dayAfter);

                            if (!TwodayBeforeLeaveCheckList.isEmpty() && !OnedayBeforeLeaveCheckList.isEmpty()) {

                                request.setAttribute("failureMessage",
                                        "Error : Sick Leave Can Not Be Apply Continue 3 days");
                                request.setAttribute("leaveEmployeeDetail", leaveEmployeeDetail);
                                mv = applyClick(request, response);

                            } else if (!TwodayAfterLeaveCheckList.isEmpty() && !OnedayAfterLeaveCheckList.isEmpty()) {
                                request.setAttribute("failureMessage",
                                        "Error : Sick Leave Can Not Be Apply Continue 3 days");
                                request.setAttribute("leaveEmployeeDetail", leaveEmployeeDetail);
                                mv = applyClick(request, response);
                            } else {
                                String leaveDate = leaveEmployeeDetail.getStartDate();
                                Date checkLeaveDate = sdf.parse(leaveDate);
                                Date checkLeaveDate2 = new Date();
                                if (checkLeaveDate.after(checkLeaveDate2)) {
                                    request.setAttribute("failureMessage",
                                            "Error : Sick Leave Can Not Be Apply In Advance");
                                    request.setAttribute("leaveEmployeeDetail", leaveEmployeeDetail);
                                    mv = applyClick(request, response);
                                } else {
                                    SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                                    String currentDate = dateFormat1.format(new Date());
                                    leaveEmployeeDetail.setDateOfSubmit(currentDate);
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
                                        Mailsend(request);
                                        String startdate = leaveEmployeeDetail.getStartDate();
                                        String enddate = leaveEmployeeDetail.getEndDate();
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
                                        msg = msg.replaceAll("\\{start_date\\}", startdate);
                                        msg = msg.replaceAll("\\{end_date\\}", enddate);
                                        msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                                        msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                                        sendMail.sendMail(from, To, Subject, msg);

                                        if (noOfDay > 3) {
                                            List<UserRightMaster> userlist = (List<UserRightMaster>) userRightMasterService.readByleaveRight();
                                            for (UserRightMaster emplist : userlist) {
                                                EmailTemplate emailTemplate1 = new EmailTemplate();
                                                int id = emplist.getUserMaster().getId();
                                                EmployeeMaster employeeMail = employeeMasterService.readById(id);
                                                emailTemplate1 = emailTemplateService.readById(140);

                                                String To1 = employeeMail.getEmailAddress();
                                                String from1 = employeeMasterModel.getOfficeEmailId();
                                                String Subject1 = emailTemplate1.getSubject();
                                                Subject1 = Subject1.replaceAll("\\{user\\}", employeeMasterModel.getEmployeeName());
                                                String msg1 = emailTemplate1.getBodytext();
                                                msg1 = msg1.replaceAll("\\{to_user\\}", employeeMasterHr.getEmployeeName());
                                                msg1 = msg1.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                                                msg1 = msg1.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                                                sendMail.sendMail(from1, To1, Subject1, msg1);

                                            }

                                        }
                                    } catch (Exception e) {

                                    }

                                    request.setAttribute("successMessage",
                                            "Information : The Information is saved Successfully.");
                                    mv = searchOwnLeaveDetail(request, response);
                                }
                            }
                        } else if (leaveTypeMaster.getLeaveType().contains("Casual Leave")) {
                            ////////////// code to check continue 3days

                            Calendar calenderSick = Calendar.getInstance();
                            Date dateOfSickLeave = sdf.parse(leaveEmployeeDetail.getStartDate());
                            calenderSick.setTime(dateOfSickLeave);
                            String dayNameOfLeave = format2.format(dateOfSickLeave);

                            ///////////2day         
                            LeaveEmployeeDetail LED = new LeaveEmployeeDetail();
                            LED.setEmployeeMaster(employeeMaster);
                            calenderSick.add(Calendar.DAY_OF_MONTH, -2);
                            Date dateSet = calenderSick.getTime();
                            String finalDateSet = sdf.format(dateSet);
                            LED.setStartDate(finalDateSet);
                            List<?> TwodayBeforeLeaveCheckList = leaveEmployeeDetailService.casualleaveCheck(LED);
                            //////1day
                            LeaveEmployeeDetail led1dayBefore = new LeaveEmployeeDetail();
                            led1dayBefore.setEmployeeMaster(employeeMaster);
                            calenderSick.add(Calendar.DAY_OF_MONTH, +1);
                            Date day1before = calenderSick.getTime();
                            String finalday1before = sdf.format(day1before);
                            led1dayBefore.setStartDate(finalday1before);
                            List<?> OnedayBeforeLeaveCheckList = leaveEmployeeDetailService.casualleaveCheck(led1dayBefore);

                            ///////////////////////////////////////////////////
                            Calendar calenderSickAfter = Calendar.getInstance();
                            calenderSickAfter.setTime(dateOfSickLeave);

                            ///////////2day         
                            LeaveEmployeeDetail TwodayAfter = new LeaveEmployeeDetail();
                            TwodayAfter.setEmployeeMaster(employeeMaster);
                            calenderSickAfter.add(Calendar.DAY_OF_MONTH, +2);
                            Date dateSetSickAfter = calenderSickAfter.getTime();
                            String finalDateSetSickAfter = sdf.format(dateSetSickAfter);
                            TwodayAfter.setStartDate(finalDateSetSickAfter);
                            List<?> TwodayAfterLeaveCheckList = leaveEmployeeDetailService.casualleaveCheck(TwodayAfter);
                            //////1day
                            LeaveEmployeeDetail led1dayAfter = new LeaveEmployeeDetail();
                            led1dayAfter.setEmployeeMaster(employeeMaster);
                            calenderSickAfter.add(Calendar.DAY_OF_MONTH, -1);
                            Date day1After = calenderSickAfter.getTime();
                            String finalday1After = sdf.format(day1After);
                            led1dayAfter.setStartDate(finalday1After);
                            List<?> OnedayAfterLeaveCheckList = leaveEmployeeDetailService.casualleaveCheck(led1dayAfter);

                            if (!TwodayBeforeLeaveCheckList.isEmpty() && !OnedayBeforeLeaveCheckList.isEmpty()) {

                                request.setAttribute("failureMessage",
                                        "Error : Casual Leave Can Not Be Apply Continue 3 days");
                                request.setAttribute("leaveEmployeeDetail", leaveEmployeeDetail);
                                mv = applyClick(request, response);

                            } else if (!TwodayAfterLeaveCheckList.isEmpty() && !OnedayAfterLeaveCheckList.isEmpty()) {
                                request.setAttribute("failureMessage",
                                        "Error : Casual Leave Can Not Be Apply Continue 3 days");
                                request.setAttribute("leaveEmployeeDetail", leaveEmployeeDetail);
                                mv = applyClick(request, response);
                            } else {
                                SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                                String currentDate = dateFormat1.format(new Date());
                                leaveEmployeeDetail.setDateOfSubmit(currentDate);
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
                                    Mailsend(request);
                                    String startdate = leaveEmployeeDetail.getStartDate();
                                    String enddate = leaveEmployeeDetail.getEndDate();
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
                                    msg = msg.replaceAll("\\{start_date\\}", startdate);
                                    msg = msg.replaceAll("\\{end_date\\}", enddate);
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
                            SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                            String currentDate = dateFormat1.format(new Date());
                            leaveEmployeeDetail.setDateOfSubmit(currentDate);
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
                                Mailsend(request);
                                String startdate = leaveEmployeeDetail.getStartDate();
                                String enddate = leaveEmployeeDetail.getEndDate();
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
                                msg = msg.replaceAll("\\{start_date\\}", startdate);
                                msg = msg.replaceAll("\\{end_date\\}", enddate);
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
                Float zz = null;
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
                        zz = (float) xx;
                        noOfDay = zz;
                    }
                }
                //                Iterator it1 = listFirst.iterator();
                //                if (it1.hasNext()) {
                //                }
                if (noOfDay == null) {
                    noOfDay = (float) 0;
                }
                totalMap = days + noOfDay;
                if ("Short Leave".equals(name) || "Paternity Leave".equals(name) || "C Off Leave".equals(name) || "Maternity Leave".equals(name) || "Leave Without Pay".equals(name)) {
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
        request.setAttribute("oldLeaveId", leaveEmployeeDetail.getLeaveTypeMaster().getId());
        request.setAttribute("oldLeaveDays", leaveEmployeeDetail.getNoOfDays());
        request.setAttribute("flag", leaveEmployeeDetail.getStatus());
        request.setAttribute("currentdate", leaveEmployeeDetail.getDateOfSubmit());
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
                Float zz = null;
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
                        zz = (float) xx;
                        noOfDay = zz;
                    }
                }
                //                Iterator it1 = listFirst.iterator();
                //                if (it1.hasNext()) {
                //                }
                if (noOfDay == null) {
                    noOfDay = (float) 0;
                }
                totalMap = days + noOfDay;
                if ("Short Leave".equals(name) || "Paternity Leave".equals(name) || "C Off Leave".equals(name) || "Maternity Leave".equals(name) || "Leave Without Pay".equals(name)) {
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
        request.setAttribute("oldLeaveId", leaveEmployeeDetail.getLeaveTypeMaster().getId());
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
                if (leaveTypeMaster.getLeaveType().contains("Short Leave") || leaveTypeMaster.getLeaveType().contains("C Off Leave")) {
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

                    if (!leaveTypeMaster.getLeaveType().contains("Short Leave")) {
                        if (null != leaveEmployeeDetail.getNoOfDays() && leaveEmployeeDetail.getNoOfDays() > Float.parseFloat(leaveTypeMaster.getMaxDayAllowedLeave())
                                && !leaveTypeMaster.getLeaveType().contains("Maternity Leave") && !leaveTypeMaster.getLeaveType().contains("C Off Leave")) {
                            request.setAttribute("failureMessage",
                                    "Error :No Of Days is Grater than maximum allowed Days...");
                            mv = viewLeaveRequest(request, response);
                        } else if (startDate.after(endDate)) {
                            request.setAttribute("failureMessage",
                                    "Error : Please Insert start date before end date.");
                            mv = viewLeaveRequest(request, response);

                        } else {
                            leaveEmployeeDetail.setStatus(0);
                            SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                            String currentDate = dateFormat1.format(new Date());
                            leaveEmployeeDetail.setDateOfSubmit(currentDate);
                            leaveEmployeeDetailService.update(leaveEmployeeDetail);
                            String oldLeaveId = request.getParameter("oldLeaveId");
                            String oldLeaveDays = request.getParameter("oldLeaveDays");
                            float editBalance = 0;
                            EmployeeLeaveBalance employeeLeaveBalance2 = new EmployeeLeaveBalance();
                            LeaveTypeMaster leaveTypeMaster2 = new LeaveTypeMaster();
                            leaveTypeMaster2.setId(Integer.parseInt(oldLeaveId));
                            employeeLeaveBalance2.setEmployeeMaster(employeeMaster);
                            employeeLeaveBalance2.setLeaveTypeMaster(leaveTypeMaster2);
                            List<?> changeBalanceList = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance2);
                            if (!changeBalanceList.isEmpty()) {
                                employeeLeaveBalance2 = (EmployeeLeaveBalance) balanceList.get(0);
                                editBalance = employeeLeaveBalance2.getNoOfLeaveRemain();
                                editBalance = editBalance + Float.parseFloat(oldLeaveDays);
                                employeeLeaveBalance2.setNoOfLeaveRemain(editBalance);
                                if (employeeLeaveBalance2.getLeaveTypeMaster().getId() != 9) {
                                    employeeLeaveBalanceService.update(employeeLeaveBalance2);
                                }
                            }

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

                            mv.setViewName("forward:leaveEmployeeDetail.htm?act=searchOwnLeaveDetail");

                        }
                    } else {
                        leaveEmployeeDetail.setStatus(0);
                        SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                        String currentDate = dateFormat1.format(new Date());
                        leaveEmployeeDetail.setDateOfSubmit(currentDate);
                        leaveEmployeeDetailService.update(leaveEmployeeDetail);

                        balanceDay = employeeLeaveBalance1.getNoOfLeaveRemain();
                        noOfDay = leaveEmployeeDetail.getNoOfDays();
                        String noOfHour = "";
                        EmployeeMaster employeeMasterModel1 = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                        COffLeaveMaster cOffLeaveMaster = new COffLeaveMaster();
                        cOffLeaveMaster.setZydexLocationMaster(employeeMasterModel1.getZydexLocationMaster());
                        List list1 = cOffLeaveMasterService.readByDept(cOffLeaveMaster);
                        try {
                            cOffLeaveMaster = (COffLeaveMaster) list1.get(0);
                            noOfHour = "0." + cOffLeaveMaster.getHoursNo();
                        } catch (Exception e) {
                        }
                        // 11 No Id Is C-Off Id*****************
                        if (leaveEmployeeDetail.getLeaveTypeMaster().getId().equals(11)) {
                            noOfDay = Float.parseFloat(noOfHour);
                        }
                        // 11 No Id Is C-Off Id*****************
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
                        mv.setViewName("forward:leaveEmployeeDetail.htm?act=searchOwnLeaveDetail");
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
            leaveTypeMaster = leaveEmployeeDetail.getLeaveTypeMaster();
            int leaveid = leaveTypeMaster.getId();

            if (leaveid != 10) {
                SimpleDateFormat format2 = new SimpleDateFormat("EEEE");

                Calendar cal6 = Calendar.getInstance();
                Calendar cal7 = Calendar.getInstance();
                SimpleDateFormat newsdf = new SimpleDateFormat("dd/MM/yyyy");
                Date satdateOfLeave = newsdf.parse(leaveEmployeeDetail.getStartDate());
                cal6.setTime(satdateOfLeave);
                cal7.setTime(satdateOfLeave);

                String dayNameOfLeave = format2.format(satdateOfLeave);
                if (dayNameOfLeave.equals("Saturday")) {
                    LeaveEmployeeDetail leaveEmployeeDetail1 = new LeaveEmployeeDetail();
                    leaveEmployeeDetail1.setEmployeeMaster(employeeMaster);
                    cal6.add(Calendar.DAY_OF_MONTH, +2);
                    Date dateSet = cal6.getTime();
                    String finalDateSet = sdf.format(dateSet);
                    leaveEmployeeDetail1.setStartDate(finalDateSet);
                    List<?> monLeaveListCheck = leaveEmployeeDetailService.leaveCheckStartDate(leaveEmployeeDetail1);
                    leaveTypeMaster = leaveTypeMasterService.readById(Integer.parseInt(leaveTypeMasterId));
                    if (!monLeaveListCheck.isEmpty()) {
                        LeaveEmployeeDetail leaveEmployeeDetail2 = (LeaveEmployeeDetail) monLeaveListCheck.get(0);
                        LeaveTypeMaster leaveTypeMaster1 = new LeaveTypeMaster();
                        leaveTypeMaster1.setId(leaveEmployeeDetail2.getLeaveTypeMaster().getId());
                        leaveTypeMaster1 = leaveTypeMasterService.readById(leaveTypeMaster1.getId());
                        String startday = leaveEmployeeDetail2.getStartDate();
                        String endday = leaveEmployeeDetail2.getEndDate();
                        EmployeeLeaveBalance employeeLeaveBalance2 = new EmployeeLeaveBalance();
                        employeeLeaveBalance2.setEmployeeMaster(employeeMaster);
                        employeeLeaveBalance2.setLeaveTypeMaster(leaveTypeMaster1);
                        List<?> balanceMonleave = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance2);
                        if (!balanceList.isEmpty()) {
                            employeeLeaveBalance2 = (EmployeeLeaveBalance) balanceMonleave.get(0);
                        }

                        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
                        Date startdate = sdf1.parse(startday);
                        Date enddate = sdf1.parse(endday);
                        float noOfdays = leaveEmployeeDetail2.getNoOfDays();
                        float diffInDays = (float) (((enddate.getTime() - startdate.getTime()) / (1000 * 60 * 60 * 24)) + 1.0);
                        if (diffInDays != noOfdays) {
                            balanceDay = employeeLeaveBalance2.getNoOfLeaveRemain();
                            balanceDay = balanceDay + 1;
                            employeeLeaveBalance2.setNoOfLeaveRemain(balanceDay);
                            employeeLeaveBalanceService.update(employeeLeaveBalance2);
                            noOfdays = noOfdays - 1;
                            leaveEmployeeDetail2.setNoOfDays(noOfdays);
                            SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                            String currentDate = dateFormat1.format(new Date());
                            leaveEmployeeDetail2.setDateOfSubmit(currentDate);
                            leaveEmployeeDetailService.update(leaveEmployeeDetail2);

                        }
                    }
                }
                if (dayNameOfLeave.equals("Monday")) {
                    LeaveEmployeeDetail leaveEmployeeDetail1 = new LeaveEmployeeDetail();
                    leaveEmployeeDetail1.setEmployeeMaster(employeeMaster);
                    cal6.add(Calendar.DAY_OF_MONTH, -2);
                    Date dateSet = cal6.getTime();
                    String finalDateSet = sdf.format(dateSet);
                    leaveEmployeeDetail1.setStartDate(finalDateSet);
                    List<?> monLeaveListCheck = leaveEmployeeDetailService.leaveCheck(leaveEmployeeDetail1);
                    leaveTypeMaster = leaveTypeMasterService.readById(Integer.parseInt(leaveTypeMasterId));
                    if (!monLeaveListCheck.isEmpty()) {
                        LeaveEmployeeDetail leaveEmployeeDetail2 = (LeaveEmployeeDetail) monLeaveListCheck.get(0);
                        LeaveTypeMaster leaveTypeMaster1 = new LeaveTypeMaster();
                        leaveTypeMaster1.setId(leaveEmployeeDetail2.getLeaveTypeMaster().getId());
                        leaveTypeMaster1 = leaveTypeMasterService.readById(leaveTypeMaster1.getId());
                        String startday = leaveEmployeeDetail2.getStartDate();
                        String endday = leaveEmployeeDetail2.getEndDate();
                        EmployeeLeaveBalance employeeLeaveBalance2 = new EmployeeLeaveBalance();
                        employeeLeaveBalance2.setEmployeeMaster(employeeMaster);
                        employeeLeaveBalance2.setLeaveTypeMaster(leaveTypeMaster1);
                        List<?> balanceMonleave = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance2);
                        if (!balanceList.isEmpty()) {
                            employeeLeaveBalance2 = (EmployeeLeaveBalance) balanceMonleave.get(0);
                        }

                        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
                        Date startdate = sdf1.parse(startday);
                        Date enddate = sdf1.parse(endday);
                        float noOfdays = leaveEmployeeDetail2.getNoOfDays();
                        String startStatus = leaveEmployeeDetail2.getStartDateStatus();
                        String endStatus = leaveEmployeeDetail2.getEndDateStatus();
                        float diffInDays = 0;
                        if (startday.equals(endday)) {
                            if (startStatus.equals("Fullday")) {
                                diffInDays = (float) (((enddate.getTime() - startdate.getTime()) / (1000 * 60 * 60 * 24)) + 1.0);
                            } else {
                                diffInDays = (float) (((enddate.getTime() - startdate.getTime()) / (1000 * 60 * 60 * 24)) + 0.5);
                            }
                        } else if (startStatus.equals("Fullday") && endStatus.equals("Fullday")) {
                            diffInDays = (float) (((enddate.getTime() - startdate.getTime()) / (1000 * 60 * 60 * 24)) + 1.0);
                        } else if (!startStatus.equals("Fullday") && !endStatus.equals("Fullday")) {
                            diffInDays = (float) (((enddate.getTime() - startdate.getTime()) / (1000 * 60 * 60 * 24)));
                        } else {
                            diffInDays = (float) (((enddate.getTime() - startdate.getTime()) / (1000 * 60 * 60 * 24)) + 0.5);
                        }

                        if (diffInDays != noOfdays) {
                            balanceDay = employeeLeaveBalance2.getNoOfLeaveRemain();
                            balanceDay = balanceDay + 1;
                            employeeLeaveBalance2.setNoOfLeaveRemain(balanceDay);
                            employeeLeaveBalanceService.update(employeeLeaveBalance2);
                            noOfdays = noOfdays - 1;
                            leaveEmployeeDetail2.setNoOfDays(noOfdays);
                            SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                            String currentDate = dateFormat1.format(new Date());
                            leaveEmployeeDetail2.setDateOfSubmit(currentDate);
                            leaveEmployeeDetailService.update(leaveEmployeeDetail2);

                        }
                    }
                }
            }

            if (leaveEmployeeDetail.getStatus() == 0 || leaveEmployeeDetail.getStatus() == 2 || leaveEmployeeDetail.getStatus() == 1) {

                balanceDay = employeeLeaveBalance1.getNoOfLeaveRemain();
                noOfDay = leaveEmployeeDetail.getNoOfDays();

                balanceDay = balanceDay + noOfDay;
                String oldLeaveId = request.getParameter("oldLeaveId");
                if (Integer.parseInt(oldLeaveId) != 9 && Integer.parseInt(oldLeaveId) != 12) {
                    employeeLeaveBalance1.setNoOfLeaveRemain(balanceDay);
                    employeeLeaveBalanceService.update(employeeLeaveBalance1);
                }
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
                mv.setViewName("forward:leaveEmployeeDetail.htm?act=searchOwnLeaveDetail");

//                mv = searchSubmit(request, response);
            } else if (leaveEmployeeDetail.getStatus() == 3 || leaveEmployeeDetail.getStatus() == 6) {
                int leaveTypeid = leaveEmployeeDetail.getLeaveTypeMaster().getId();
                LeaveTypeMaster leaveTypeMaster1 = leaveTypeMasterService.readById(leaveTypeid);
                if (leaveTypeMaster1.getLeaveType().contains("Short Leave")) {
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
                SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                String currentDate = dateFormat1.format(new Date());
                leaveEmployeeDetail.setDateOfSubmit(currentDate);
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
                Float zz = null;
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
                List<?> listFirst = leaveEmployeeDetailService.readLeaveDaysAsApproved(leaveEmployeeDetail);

                if (!listFirst.isEmpty()) {
                    if (listFirst.get(0) != null) {
                        Object xx = (Object) listFirst.get(0);
                        zz = (float) xx;
                        noOfDay = zz;
                    }
                }
                //                Iterator it1 = listFirst.iterator();
                //                if (it1.hasNext()) {
                //                }
                if (noOfDay == null) {
                    noOfDay = (float) 0;
                }
                totalMap = days + noOfDay;
                if ("C Off Leave".equals(name) || "Short Leave".equals(name) || "Paternity Leave".equals(name) || "Maternity Leave".equals(name) || "Leave Without Pay".equals(name)) {
                    continue;
                } else {
                    listRemain.put(name, days);
                    empReqMap.put(name, noOfDay);
                    totalDaysMap.put(name, totalMap);
                }

            }

        }
        leaveEmployeeDetail.setEmployeeMaster(employeeMaster);
        List<?> list = leaveEmployeeDetailService.empLeaveRequestDetail(leaveEmployeeDetail);
        request.setAttribute("list", list);
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
        String currentDate = dateFormat1.format(new Date());
        String startDate = "";
        String endDate = "";
        for (Object o : list) {
            Object[] obj = (Object[]) o;
            startDate = (String) obj[1];
            endDate = (String) obj[3];
        }

        EmployeeMaster employeeMasterFromSession = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        List<?> sameDateCheck = leaveEmployeeDetailService.getEmployeeLeaveDetailByDate(startDate, endDate, reportingId);
        List<?> approvalHistoryList = leaveEmployeeDetailsApprovalHistoryService.getByLeaveEmpDetailId(Integer.parseInt(id));
        Boolean hrrit = userRightMasterService.readEmployeeIfHR(employeeMasterFromSession.getUserMaster().getId());
        request.setAttribute("sameDateCheck", sameDateCheck);
        request.setAttribute("approvalHistoryList", approvalHistoryList);
        request.setAttribute("listRemain", listRemain);
        request.setAttribute("empReqMap", empReqMap);
        request.setAttribute("totalDaysMap", totalDaysMap);

        mv.getModelMap().put("leaveEmployeeDetail", leaveEmployeeDetail);
        if (hrrit == true) {
            mv.setViewName("Leave/HRLeaveRequestApprove");
        } else {
            mv.setViewName("Leave/LeaveRequestApprove");
        }

        return mv;
    }

    public ModelAndView approveRequestAdminClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        LeaveEmployeeDetail leaveEmployeeDetail = new LeaveEmployeeDetail();
        EmployeeLeaveBalance employeeLeaveBalance = new EmployeeLeaveBalance();
        LeaveTypeMaster leaveTypeMaster = new LeaveTypeMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        LeaveEmployeeDetailsApprovalHistory leaveEmployeeDetailsApprovalHistory = new LeaveEmployeeDetailsApprovalHistory();
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
        Date date1 = new Date();
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        String submitDate = sdf1.format(date1);

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
                leaveEmployeeDetailsApprovalHistory.setApprovalId(employeeMaster1.getId());
                leaveEmployeeDetailsApprovalHistory.setApprovalName(employeeMaster1.getEmployeeName());
                leaveEmployeeDetailsApprovalHistory.setComment(hrRemark);
                leaveEmployeeDetailsApprovalHistory.setCreatedBy(employeeMaster1.getId());
                leaveEmployeeDetailsApprovalHistory.setCreatedDate(approveDate);
                leaveEmployeeDetailsApprovalHistory.setLeaveEmployeeDetail(leaveEmployeeDetail);
                leaveEmployeeDetailsApprovalHistory.setStatusMessage("Withdraw Approved");
                leaveEmployeeDetailsApprovalHistory.setStatus(4); //Withdraw Approved
                leaveEmployeeDetailsApprovalHistoryService.create(leaveEmployeeDetailsApprovalHistory);
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
                leaveEmployeeDetailsApprovalHistory.setApprovalId(employeeMaster1.getId());
                leaveEmployeeDetailsApprovalHistory.setApprovalName(employeeMaster1.getEmployeeName());
                leaveEmployeeDetailsApprovalHistory.setComment(hrRemark);
                leaveEmployeeDetailsApprovalHistory.setCreatedBy(employeeMaster1.getId());
                leaveEmployeeDetailsApprovalHistory.setCreatedDate(approveDate);
                leaveEmployeeDetailsApprovalHistory.setLeaveEmployeeDetail(leaveEmployeeDetail);
                leaveEmployeeDetailsApprovalHistory.setStatusMessage("Approved");
                leaveEmployeeDetailsApprovalHistory.setStatus(1); //Approved
                leaveEmployeeDetailsApprovalHistoryService.create(leaveEmployeeDetailsApprovalHistory);
                request.setAttribute("successMessage",
                        "Information : The Leave Approved successfully.");
                try {
                    String startdate = leaveEmployeeDetail.getStartDate();
                    String enddate = leaveEmployeeDetail.getEndDate();
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
                            msg = msg.replaceAll("\\{start_date\\}", startdate);
                            msg = msg.replaceAll("\\{end_date\\}", enddate);
                            msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                            msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                            sendMail.sendMail(from, To, subject, msg);

                            String name = "Leave";
                            EmailAddMaster emailAddMaster = new EmailAddMaster();
                            emailAddMaster.setModuleName(name);
                            emailAddMaster.setDepartmentMaster(employeeMaster2.getDepartmentMaster());
                            List<?> emailSendList = emailAddMasterService.readByName(emailAddMaster);
                            if (!emailSendList.isEmpty()) {
                                EmailAddMaster emailAddMaster1 = (EmailAddMaster) emailSendList.get(0);
                                String emailId = emailAddMaster1.getEmailId();
                                for (String emailId1 : emailId.split(",")) {
                                    if (!emailId1.equals("")) {
                                        String To1 = emailId1;
                                        String from1 = employeeMasterModel.getOfficeEmailId();
                                        String subject1 = emailTemplate1.getSubject();
                                        subject1 = subject1.replaceAll("\\{user\\}", employeeMaster2.getEmployeeName());
                                        String msg1 = emailTemplate1.getBodytext();
                                        msg1 = msg1.replaceAll("\\{to_user\\}", employeeMaster2.getEmployeeName());
                                        msg1 = msg1.replaceAll("\\{start_date\\}", startdate);
                                        msg1 = msg1.replaceAll("\\{end_date\\}", enddate);
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
                                        String subject1 = emailTemplate1.getSubject();
                                        subject1 = subject1.replaceAll("\\{user\\}", employeeMaster2.getEmployeeName());
                                        String msg1 = emailTemplate1.getBodytext();
                                        msg1 = msg1.replaceAll("\\{to_user\\}", employeeMaster2.getEmployeeName());
                                        msg1 = msg1.replaceAll("\\{start_date\\}", startdate);
                                        msg1 = msg1.replaceAll("\\{end_date\\}", enddate);
                                        msg1 = msg1.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                                        msg1 = msg1.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                                        sendMail.sendMail(from1, To1, subject1, msg1);
                                    }
                                }
                            }

                            List<?> gmOrStateHeadMailSend = employeeMasterService.readForSendMailToAll(employeeMaster2);
                            if (!gmOrStateHeadMailSend.isEmpty()) {

                                Object[] emaillist = (Object[]) gmOrStateHeadMailSend.get(0);
                                for (int i = 0; i <= emaillist.length; i++) {
                                    if (null != emaillist[i] && "" != emaillist[i]) {
                                        String emailid = emaillist[i].toString();

                                        String To3 = emailid;
                                        String from3 = employeeMasterModel.getOfficeEmailId();
                                        String subject3 = emailTemplate1.getSubject();

                                        subject3 = subject3.replaceAll("\\{user\\}", employeeMaster2.getEmployeeName());
                                        String msg3 = emailTemplate1.getBodytext();
                                        msg3 = msg3.replaceAll("\\{to_user\\}", employeeMaster2.getEmployeeName());
                                        msg3 = msg3.replaceAll("\\{start_date\\}", startdate);
                                        msg3 = msg3.replaceAll("\\{end_date\\}", enddate);
                                        msg3 = msg3.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                                        msg3 = msg3.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                                        sendMail.sendMail(from3, To3, subject3, msg3);
                                    }
                                }
                            }
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
                leaveEmployeeDetailsApprovalHistory.setApprovalId(employeeMaster1.getId());
                leaveEmployeeDetailsApprovalHistory.setApprovalName(employeeMaster1.getEmployeeName());
                leaveEmployeeDetailsApprovalHistory.setComment(hrRemark);
                leaveEmployeeDetailsApprovalHistory.setCreatedBy(employeeMaster1.getId());
                leaveEmployeeDetailsApprovalHistory.setCreatedDate(submitDate);
                leaveEmployeeDetailsApprovalHistory.setLeaveEmployeeDetail(leaveEmployeeDetail);
                leaveEmployeeDetailsApprovalHistory.setStatusMessage("Withdraw Rejected");
                leaveEmployeeDetailsApprovalHistory.setStatus(4); //Withdraw Rejected
                leaveEmployeeDetailsApprovalHistoryService.create(leaveEmployeeDetailsApprovalHistory);
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
                String noOfHour = "";
                EmployeeMaster employeeMasterModel1 = new EmployeeMaster();
                employeeMasterModel1 = employeeMasterService.readById(leaveEmployeeDetail.getEmployeeMaster().getId());
                COffLeaveMaster cOffLeaveMaster = new COffLeaveMaster();
                cOffLeaveMaster.setZydexLocationMaster(employeeMasterModel1.getZydexLocationMaster());
                List list1 = cOffLeaveMasterService.readByDept(cOffLeaveMaster);
                try {
                    cOffLeaveMaster = (COffLeaveMaster) list1.get(0);
                    noOfHour = "0." + cOffLeaveMaster.getHoursNo();
                } catch (Exception e) {
                }
                // 11 No Id Is C-Off Id*****************
                if (leaveEmployeeDetail.getLeaveTypeMaster().getId().equals(11)) {
                    noOfDay = Float.parseFloat(noOfHour);
                }
                // 11 No Id Is C-Off Id*****************
                balanceDay = balanceDay + noOfDay;
                employeeLeaveBalance.setNoOfLeaveRemain(balanceDay);
                employeeLeaveBalanceService.update(employeeLeaveBalance);
                leaveEmployeeDetailsApprovalHistory.setApprovalId(employeeMaster1.getId());
                leaveEmployeeDetailsApprovalHistory.setApprovalName(employeeMaster1.getEmployeeName());
                leaveEmployeeDetailsApprovalHistory.setComment(hrRemark);
                leaveEmployeeDetailsApprovalHistory.setCreatedBy(employeeMaster1.getId());
                leaveEmployeeDetailsApprovalHistory.setCreatedDate(submitDate);
                leaveEmployeeDetailsApprovalHistory.setLeaveEmployeeDetail(leaveEmployeeDetail);
                leaveEmployeeDetailsApprovalHistory.setStatusMessage("Rejected");
                leaveEmployeeDetailsApprovalHistory.setStatus(2); //Rejected
                leaveEmployeeDetailsApprovalHistoryService.create(leaveEmployeeDetailsApprovalHistory);
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
            leaveEmployeeDetailsApprovalHistory.setApprovalId(employeeMaster1.getId());
            leaveEmployeeDetailsApprovalHistory.setApprovalName(employeeMaster1.getEmployeeName());
            leaveEmployeeDetailsApprovalHistory.setComment(hrRemark);
            leaveEmployeeDetailsApprovalHistory.setCreatedBy(employeeMaster1.getId());
            leaveEmployeeDetailsApprovalHistory.setCreatedDate(submitDate);
            leaveEmployeeDetailsApprovalHistory.setLeaveEmployeeDetail(leaveEmployeeDetail);
            leaveEmployeeDetailsApprovalHistory.setStatusMessage("Reworked");
            leaveEmployeeDetailsApprovalHistory.setStatus(3); //Reworked
            leaveEmployeeDetailsApprovalHistoryService.create(leaveEmployeeDetailsApprovalHistory);
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
//
//                if ((zydexLocationMaster.getZydexLocation().equals("HO") || zydexLocationMaster.getZydexLocation().equals("R&D")) && leaveType.equals("Short Leave")) {
//                } else {
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
//                }
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
        int pendingLeave = leaveEmployeeDetailService.readPendingLeaveRequestForDashboard(leaveEmployeeDetail);
        request.setAttribute("pendingLeave", pendingLeave);

        int pendingApproverLeave = leaveEmployeeDetailService.readPendingApproverLeaveRequestForDashboard(leaveEmployeeDetail);
        request.setAttribute("pendingApproverLeave", pendingApproverLeave);

        int withdrawPendingList = leaveEmployeeDetailService.readWithdrawPendingApproverLeaveRequestForDashboard(leaveEmployeeDetail);
        request.setAttribute("withdrawPendingList", withdrawPendingList);

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
        String leavetype = request.getParameter("leaveType");
        String useSickLeave = request.getParameter("useSickLeave");
        strDate = strDate.replaceAll(",", "/");
        enDate = enDate.replaceAll(",", "/");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date sDate = sdf.parse(strDate);
        Date eDate = sdf.parse(enDate);
        Date today = new Date();

        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster1 = (EmployeeMaster) session.getAttribute("employeeInfo");
        ShiftMaster shiftMaster = new ShiftMaster();
        HoursBasis hoursBasis = new HoursBasis();
        ShiftRotationMaster shiftRotationMaster = new ShiftRotationMaster();
        ShiftRotationInfo shiftRotationInfo = new ShiftRotationInfo();
        int appId = employeeMaster1.getId();
        String shiftType = employeeMaster1.getShiftType();
        int ZydexLocId = employeeMaster1.getZydexLocationMaster().getId();
        String weekOffDay = "";
//        if (shiftType.contains("ShiftBase")) {
//            shiftRotationMaster = shiftRotationMasterService.readById(employeeMaster1.getShiftHoursId());
//            String shiftId = shiftRotationInfoService.readFirstShfitId("" + employeeMaster1.getUserMaster().getId(), "" + shiftRotationMaster.getId());
//            shiftMaster = shiftMasterService.readById(Integer.parseInt(shiftId));
//            weekOffDay = shiftMaster.getWeekof();
//
//        } else if (shiftType.contains("HourlyBase")) {
//            hoursBasis = hoursBasisService.readById(employeeMaster1.getShiftHoursId());
//            weekOffDay = hoursBasis.getWeekof();
//
//        }
        List<?> listShiftGenerateMonthy = shiftGenerateMonthlyScheduleService.readByEmpMonthYear(employeeMaster1.getId());
        SimpleDateFormat sm = new SimpleDateFormat("dd/MM/yyyy");;
        Date dt1 = null, dt2 = null, dt3 = null, dt4 = null;
        if (listShiftGenerateMonthy.size() > 0) {
            Date d = new Date();
            LocalDate localDate = d.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            String wdate1 = (String) listShiftGenerateMonthy.get(0) + "/" + localDate.getMonthValue() + "/" + localDate.getYear();
            String wdate2 = (String) listShiftGenerateMonthy.get(1) + "/" + localDate.getMonthValue() + "/" + localDate.getYear();
            String wdate3 = (String) listShiftGenerateMonthy.get(2) + "/" + localDate.getMonthValue() + "/" + localDate.getYear();
            String wdate4 = (String) listShiftGenerateMonthy.get(3) + "/" + localDate.getMonthValue() + "/" + localDate.getYear();
            dt1 = sm.parse(wdate1);
            dt2 = sm.parse(wdate2);
            dt3 = sm.parse(wdate3);
            dt4 = sm.parse(wdate4);
            sm = new SimpleDateFormat("EEEE"); // the day of the week spelled out completely
            if (sm.format(dt1).equals(sm.format(dt3)) && sm.format(dt2).equals(sm.format(dt4))) {
                weekOffDay = sm.format(dt1) + "," + sm.format(dt2);
            }

        }

        int coutnter = 0;
        boolean sundayCheck = false;
        Calendar c = Calendar.getInstance();
        c.setTime(sDate);
        List<String> list1 = new ArrayList<String>();
        float days = 0;
        if (Boolean.parseBoolean(useSickLeave) == false && sDate.after(today) && leavetype.equals("7")) {
            while (c.getTime().before(eDate) || c.getTime().equals(eDate)) {

                Calendar calForEnddate = Calendar.getInstance();
                calForEnddate.setTime(eDate);
                int dayEnd = calForEnddate.get(Calendar.DAY_OF_WEEK);

//              
////                    if (c.get(Calendar.DAY_OF_WEEK) != weekOff) {
                int dayOfWeek = c.get(Calendar.WEEK_OF_MONTH);
                Date nDate = c.getTime();
                String daString = sdf.format(nDate);
                HolidayMaster holidayMaster = new HolidayMaster();
                holidayMaster.setHolidayFromDate(daString);
                List list = holidayMasterService.checkHoliday(daString, "" + employeeMaster1.getLocationMaster().getId());
                if (list.size() == 0) {
                    days++;
                }
                //-------------------Code for Saturaday and Sunday List Check Starts Here-------------
                if (sm.format(dt1).equals("Saturday") && sm.format(dt2).equals("Sunday")) {
                    for (String z : weekOffDay.split(",")) {
                        int weekOff = 0;
                        if (!z.equals("")) {
                            if (z.equals("Sunday")) {
                                weekOff = 1;
                                sundayCheck = true;
                            } else if (z.equals("Monday")) {
                                weekOff = 2;
                            } else if (z.equals("Tuesday")) {
                                weekOff = 3;
                            } else if (z.equals("Wednesday")) {
                                weekOff = 4;
                            } else if (z.equals("Thursday")) {
                                weekOff = 5;
                            } else if (z.equals("Friday")) {
                                weekOff = 6;
                            } else if (z.equals("Saturday")) {
                                weekOff = 7;
                            }
                        }
                        if (c.get(Calendar.DAY_OF_WEEK) != weekOff) {
                            if (c.get(Calendar.DAY_OF_WEEK) == 7 && coutnter == 0) {
                                if (sDateStatus.contains("SecondHalf")) {
                                    if (!strDate.equals(enDate)) {
                                        days--;
                                    }
                                }
                            }
                        }
                        if (!leavetype.equals("6") && !leavetype.equals("7") && !leavetype.equals("16") && !leavetype.equals("12")) {
                            if (c.get(Calendar.DAY_OF_WEEK) == 7 && !sDateStatus.contains("SecondHalf")) {
                                if (!strDate.equals(enDate)) {
                                    days--;
                                }
                            }
                        }
                        if (leavetype.equals("7")) {
                            if (c.get(Calendar.DAY_OF_WEEK) == weekOff && c.get(Calendar.DAY_OF_WEEK) != 1) {
                                days--;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 6 && sDateStatus.contains("SecondHalf") && eDateStatus != "" && weekOff != 1) {
                                days = days - (float) 1;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 6 && sDateStatus.contains("FirstHalf") && eDateStatus != "" && weekOff != 1) {
                                days = days - (float) 1;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 2 && eDateStatus.contains("Fullday") && weekOff != 1 && weekOff != 7) {
                                days = days - (float) 0.5;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 2 && sDateStatus.contains("Fullday")) {
                                Calendar c12 = Calendar.getInstance();
                                c12.setTime(sDate);
                                c12.add(Calendar.WEEK_OF_YEAR, -1);
                                c12.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
                                int d = c.get(Calendar.MONTH);
                                String fdate = c12.get(Calendar.DATE) + "/" + (d + 1) + "/" + c12.get(Calendar.YEAR);
                                Boolean empPreviousLeavebal = leaveEmployeeDetailService.readPreviousLeaveFriday(fdate, employeeMaster1.getId());
                                if (empPreviousLeavebal) {
                                    days++;
                                }
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 3 && sDateStatus.contains("Fullday")) {
                                Calendar c123 = Calendar.getInstance();
                                c123.setTime(sDate);
                                c123.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
                                int d1 = c.get(Calendar.MONTH);
                                String fdate1 = c123.get(Calendar.DATE) + "/" + (d1 + 1) + "/" + c123.get(Calendar.YEAR);
                                List list12 = holidayMasterService.checkHoliday(fdate1, "" + employeeMaster1.getLocationMaster().getId());
                                if (list12.size() == 1) {
                                    Calendar c12 = Calendar.getInstance();
                                    c12.setTime(sDate);
                                    c12.add(Calendar.WEEK_OF_YEAR, -1);
                                    c12.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
                                    int d = c.get(Calendar.MONTH);
                                    String fdate = c12.get(Calendar.DATE) + "/" + (d + 1) + "/" + c12.get(Calendar.YEAR);
                                    Boolean empPreviousLeavebal = leaveEmployeeDetailService.readPreviousLeaveFriday(fdate, employeeMaster1.getId());
                                    if (empPreviousLeavebal) {
                                        days++;
                                    }
                                    break;
                                }
                                break;
                            }
                        }

                        coutnter++;
                    }
                } //-------------------Code for Saturaday and Sunday List Check Ends Here-------------
                //-------------------Code for Sunday and Monday List Check Starts Here-------------
                else if (sm.format(dt1).equals("Sunday") && sm.format(dt2).equals("Monday")) {
                    for (String z : weekOffDay.split(",")) {
                        int weekOff = 0;
                        if (!z.equals("")) {
                            if (z.equals("Sunday")) {
                                weekOff = 1;
                                sundayCheck = true;
                            } else if (z.equals("Monday")) {
                                weekOff = 2;
                            } else if (z.equals("Tuesday")) {
                                weekOff = 3;
                            } else if (z.equals("Wednesday")) {
                                weekOff = 4;
                            } else if (z.equals("Thursday")) {
                                weekOff = 5;
                            } else if (z.equals("Friday")) {
                                weekOff = 6;
                            } else if (z.equals("Saturday")) {
                                weekOff = 7;
                            }
                        }
                        if (c.get(Calendar.DAY_OF_WEEK) != weekOff) {
                            if (c.get(Calendar.DAY_OF_WEEK) == 7 && coutnter == 0) {
                                if (sDateStatus.contains("SecondHalf")) {
                                    if (!strDate.equals(enDate)) {
                                        days--;
                                    }
                                }
                            }
                        }
                        if (!leavetype.equals("6") && !leavetype.equals("7") && !leavetype.equals("16") && !leavetype.equals("12")) {
                            if (c.get(Calendar.DAY_OF_WEEK) == 7 && !sDateStatus.contains("SecondHalf")) {
                                if (!strDate.equals(enDate)) {
                                    days--;
                                }
                            }
                        }
                        if (leavetype.equals("7")) {
                            if (c.get(Calendar.DAY_OF_WEEK) == weekOff && c.get(Calendar.DAY_OF_WEEK) != 2) {
                                days--;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 7 && sDateStatus.contains("SecondHalf") && eDateStatus != "" && weekOff != 2) {
                                days = days - (float) 1;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 7 && sDateStatus.contains("FirstHalf") && eDateStatus != "" && weekOff != 2) {
                                days = days - (float) 1;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 3 && eDateStatus.contains("Fullday") && weekOff != 1 && weekOff != 2) {
                                days = days - (float) 0.5;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 3 && sDateStatus.contains("Fullday")) {
                                Calendar c12 = Calendar.getInstance();
                                c12.setTime(sDate);
                                c12.add(Calendar.WEEK_OF_YEAR, -1);
                                c12.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
                                int d = c.get(Calendar.MONTH);
                                String fdate = c12.get(Calendar.DATE) + "/" + (d + 1) + "/" + c12.get(Calendar.YEAR);
                                Boolean empPreviousLeavebal = leaveEmployeeDetailService.readPreviousLeaveFriday(fdate, employeeMaster1.getId());
                                if (empPreviousLeavebal) {
                                    days++;
                                }
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 4 && sDateStatus.contains("Fullday")) {
                                Calendar c123 = Calendar.getInstance();
                                c123.setTime(sDate);
                                c123.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
                                int d1 = c.get(Calendar.MONTH);
                                String fdate1 = c123.get(Calendar.DATE) + "/" + (d1 + 1) + "/" + c123.get(Calendar.YEAR);
                                List list12 = holidayMasterService.checkHoliday(fdate1, "" + employeeMaster1.getLocationMaster().getId());
                                if (list12.size() == 1) {
                                    Calendar c12 = Calendar.getInstance();
                                    c12.setTime(sDate);
                                    c12.add(Calendar.WEEK_OF_YEAR, -1);
                                    c12.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
                                    int d = c.get(Calendar.MONTH);
                                    String fdate = c12.get(Calendar.DATE) + "/" + (d + 1) + "/" + c12.get(Calendar.YEAR);
                                    Boolean empPreviousLeavebal = leaveEmployeeDetailService.readPreviousLeaveFriday(fdate, employeeMaster1.getId());
                                    if (empPreviousLeavebal) {
                                        days++;
                                    }
                                    break;
                                }
                                break;
                            }
                        }
                        coutnter++;
                    }
                } //-------------------Code for Sunday and Monday List Check Ends Here-------------
                //-------------------Code for Monday and Tuesday List Check Starts Here-------------
                else if (sm.format(dt1).equals("Monday") && sm.format(dt2).equals("Tuesday")) {
                    for (String z : weekOffDay.split(",")) {
                        int weekOff = 0;
                        if (!z.equals("")) {
                            if (z.equals("Sunday")) {
                                weekOff = 1;
                                sundayCheck = true;
                            } else if (z.equals("Monday")) {
                                weekOff = 2;
                            } else if (z.equals("Tuesday")) {
                                weekOff = 3;
                            } else if (z.equals("Wednesday")) {
                                weekOff = 4;
                            } else if (z.equals("Thursday")) {
                                weekOff = 5;
                            } else if (z.equals("Friday")) {
                                weekOff = 6;
                            } else if (z.equals("Saturday")) {
                                weekOff = 7;
                            }
                        }
                        if (c.get(Calendar.DAY_OF_WEEK) != weekOff) {
                            if (c.get(Calendar.DAY_OF_WEEK) == 7 && coutnter == 0) {
                                if (sDateStatus.contains("SecondHalf")) {
                                    if (!strDate.equals(enDate)) {
                                        days--;
                                    }
                                }
                            }
                        }
                        if (!leavetype.equals("6") && !leavetype.equals("7") && !leavetype.equals("16") && !leavetype.equals("12")) {
                            if (c.get(Calendar.DAY_OF_WEEK) == 7 && !sDateStatus.contains("SecondHalf")) {
                                if (!strDate.equals(enDate)) {
                                    days--;
                                }
                            }
                        }
                        if (leavetype.equals("7")) {
                            if (c.get(Calendar.DAY_OF_WEEK) == weekOff && c.get(Calendar.DAY_OF_WEEK) != 3) {
                                days--;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 1 && sDateStatus.contains("SecondHalf") && eDateStatus != "" && weekOff != 3) {
                                days = days - (float) 1;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 1 && sDateStatus.contains("FirstHalf") && eDateStatus != "" && weekOff != 3) {
                                days = days - (float) 1;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 4 && eDateStatus.contains("Fullday") && weekOff != 3 && weekOff != 2) {
                                days = days - (float) 0.5;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 4 && sDateStatus.contains("Fullday")) {
                                Calendar c12 = Calendar.getInstance();
                                c12.setTime(sDate);
                                c12.add(Calendar.WEEK_OF_YEAR, -1);
                                c12.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
                                int d = c.get(Calendar.MONTH);
                                String fdate = c12.get(Calendar.DATE) + "/" + (d + 1) + "/" + c12.get(Calendar.YEAR);
                                Boolean empPreviousLeavebal = leaveEmployeeDetailService.readPreviousLeaveFriday(fdate, employeeMaster1.getId());
                                if (empPreviousLeavebal) {
                                    days++;
                                }
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 5 && sDateStatus.contains("Fullday")) {
                                Calendar c123 = Calendar.getInstance();
                                c123.setTime(sDate);
                                c123.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
                                int d1 = c.get(Calendar.MONTH);
                                String fdate1 = c123.get(Calendar.DATE) + "/" + (d1 + 1) + "/" + c123.get(Calendar.YEAR);
                                List list12 = holidayMasterService.checkHoliday(fdate1, "" + employeeMaster1.getLocationMaster().getId());
                                if (list12.size() == 1) {
                                    Calendar c12 = Calendar.getInstance();
                                    c12.setTime(sDate);
                                    c12.add(Calendar.WEEK_OF_YEAR, -1);
                                    c12.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
                                    int d = c.get(Calendar.MONTH);
                                    String fdate = c12.get(Calendar.DATE) + "/" + (d + 1) + "/" + c12.get(Calendar.YEAR);
                                    Boolean empPreviousLeavebal = leaveEmployeeDetailService.readPreviousLeaveFriday(fdate, employeeMaster1.getId());
                                    if (empPreviousLeavebal) {
                                        days++;
                                    }
                                    break;
                                }
                                break;
                            }
                        }
                        coutnter++;
                    }
                } //-------------------Code for Monday and Tuesday List Check Ends Here-------------
                //-------------------Code for Tuesday And Wednesday List Check Starts Here-------------
                else if (sm.format(dt1).equals("Tuesday") && sm.format(dt2).equals("Wednesday")) {
                    for (String z : weekOffDay.split(",")) {
                        int weekOff = 0;
                        if (!z.equals("")) {
                            if (z.equals("Sunday")) {
                                weekOff = 1;
                                sundayCheck = true;
                            } else if (z.equals("Monday")) {
                                weekOff = 2;
                            } else if (z.equals("Tuesday")) {
                                weekOff = 3;
                            } else if (z.equals("Wednesday")) {
                                weekOff = 4;
                            } else if (z.equals("Thursday")) {
                                weekOff = 5;
                            } else if (z.equals("Friday")) {
                                weekOff = 6;
                            } else if (z.equals("Saturday")) {
                                weekOff = 7;
                            }
                        }
                        if (c.get(Calendar.DAY_OF_WEEK) != weekOff) {
                            if (c.get(Calendar.DAY_OF_WEEK) == 7 && coutnter == 0) {
                                if (sDateStatus.contains("SecondHalf")) {
                                    if (!strDate.equals(enDate)) {
                                        days--;
                                    }
                                }
                            }
                        }
                        if (!leavetype.equals("6") && !leavetype.equals("7") && !leavetype.equals("16") && !leavetype.equals("12")) {
                            if (c.get(Calendar.DAY_OF_WEEK) == 7 && !sDateStatus.contains("SecondHalf")) {
                                if (!strDate.equals(enDate)) {
                                    days--;
                                }
                            }
                        }
                        if (leavetype.equals("7")) {
                            if (c.get(Calendar.DAY_OF_WEEK) == weekOff && c.get(Calendar.DAY_OF_WEEK) != 4) {
                                days--;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 2 && sDateStatus.contains("SecondHalf") && eDateStatus != "" && weekOff != 4) {
                                days = days - (float) 1;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 2 && sDateStatus.contains("FirstHalf") && eDateStatus != "" && weekOff != 4) {
                                days = days - (float) 1;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 5 && eDateStatus.contains("Fullday") && weekOff != 3 && weekOff != 4) {
                                days = days - (float) 0.5;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 5 && sDateStatus.contains("Fullday")) {
                                Calendar c12 = Calendar.getInstance();
                                c12.setTime(sDate);
                                c12.add(Calendar.WEEK_OF_YEAR, -1);
                                c12.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
                                int d = c.get(Calendar.MONTH);
                                String fdate = c12.get(Calendar.DATE) + "/" + (d + 1) + "/" + c12.get(Calendar.YEAR);
                                Boolean empPreviousLeavebal = leaveEmployeeDetailService.readPreviousLeaveFriday(fdate, employeeMaster1.getId());
                                if (empPreviousLeavebal) {
                                    days++;
                                }
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 6 && sDateStatus.contains("Fullday")) {
                                Calendar c123 = Calendar.getInstance();
                                c123.setTime(sDate);
                                c123.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
                                int d1 = c.get(Calendar.MONTH);
                                String fdate1 = c123.get(Calendar.DATE) + "/" + (d1 + 1) + "/" + c123.get(Calendar.YEAR);
                                List list12 = holidayMasterService.checkHoliday(fdate1, "" + employeeMaster1.getLocationMaster().getId());
                                if (list12.size() == 1) {
                                    Calendar c12 = Calendar.getInstance();
                                    c12.setTime(sDate);
                                    c12.add(Calendar.WEEK_OF_YEAR, -1);
                                    c12.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
                                    int d = c.get(Calendar.MONTH);
                                    String fdate = c12.get(Calendar.DATE) + "/" + (d + 1) + "/" + c12.get(Calendar.YEAR);
                                    Boolean empPreviousLeavebal = leaveEmployeeDetailService.readPreviousLeaveFriday(fdate, employeeMaster1.getId());
                                    if (empPreviousLeavebal) {
                                        days++;
                                    }
                                    break;
                                }
                                break;
                            }
                        }
                        coutnter++;
                    }
                } //-------------------Code for Tuesday And Wednesday List Check Ends Here-------------
                //-------------------Code for Wednesday and Thursday List Check Starts Here-------------
                else if (sm.format(dt1).equals("Wednesday") && sm.format(dt2).equals("Thursday")) {
                    for (String z : weekOffDay.split(",")) {
                        int weekOff = 0;
                        if (!z.equals("")) {
                            if (z.equals("Sunday")) {
                                weekOff = 1;
                                sundayCheck = true;
                            } else if (z.equals("Monday")) {
                                weekOff = 2;
                            } else if (z.equals("Tuesday")) {
                                weekOff = 3;
                            } else if (z.equals("Wednesday")) {
                                weekOff = 4;
                            } else if (z.equals("Thursday")) {
                                weekOff = 5;
                            } else if (z.equals("Friday")) {
                                weekOff = 6;
                            } else if (z.equals("Saturday")) {
                                weekOff = 7;
                            }
                        }
                        if (c.get(Calendar.DAY_OF_WEEK) != weekOff) {
                            if (c.get(Calendar.DAY_OF_WEEK) == 7 && coutnter == 0) {
                                if (sDateStatus.contains("SecondHalf")) {
                                    if (!strDate.equals(enDate)) {
                                        days--;
                                    }
                                }
                            }
                        }
                        if (!leavetype.equals("6") && !leavetype.equals("7") && !leavetype.equals("16") && !leavetype.equals("12")) {
                            if (c.get(Calendar.DAY_OF_WEEK) == 7 && !sDateStatus.contains("SecondHalf")) {
                                if (!strDate.equals(enDate)) {
                                    days--;
                                }
                            }
                        }
                        if (leavetype.equals("7")) {
                            if (c.get(Calendar.DAY_OF_WEEK) == weekOff && c.get(Calendar.DAY_OF_WEEK) != 5) {
                                days--;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 3 && sDateStatus.contains("SecondHalf") && eDateStatus != "" && weekOff != 5) {
                                days = days - (float) 1;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 3 && sDateStatus.contains("FirstHalf") && eDateStatus != "" && weekOff != 5) {
                                days = days - (float) 1;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 6 && eDateStatus.contains("Fullday") && weekOff != 4 && weekOff != 5) {
                                days = days - (float) 0.5;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 6 && sDateStatus.contains("Fullday")) {
                                Calendar c12 = Calendar.getInstance();
                                c12.setTime(sDate);
                                c12.add(Calendar.WEEK_OF_YEAR, -1);
                                c12.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
                                int d = c.get(Calendar.MONTH);
                                String fdate = c12.get(Calendar.DATE) + "/" + (d + 1) + "/" + c12.get(Calendar.YEAR);
                                Boolean empPreviousLeavebal = leaveEmployeeDetailService.readPreviousLeaveFriday(fdate, employeeMaster1.getId());
                                if (empPreviousLeavebal) {
                                    days++;
                                }
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 7 && sDateStatus.contains("Fullday")) {
                                Calendar c123 = Calendar.getInstance();
                                c123.setTime(sDate);
                                c123.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
                                int d1 = c.get(Calendar.MONTH);
                                String fdate1 = c123.get(Calendar.DATE) + "/" + (d1 + 1) + "/" + c123.get(Calendar.YEAR);
                                List list12 = holidayMasterService.checkHoliday(fdate1, "" + employeeMaster1.getLocationMaster().getId());
                                if (list12.size() == 1) {
                                    Calendar c12 = Calendar.getInstance();
                                    c12.setTime(sDate);
                                    c12.add(Calendar.WEEK_OF_YEAR, -1);
                                    c12.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
                                    int d = c.get(Calendar.MONTH);
                                    String fdate = c12.get(Calendar.DATE) + "/" + (d + 1) + "/" + c12.get(Calendar.YEAR);
                                    Boolean empPreviousLeavebal = leaveEmployeeDetailService.readPreviousLeaveFriday(fdate, employeeMaster1.getId());
                                    if (empPreviousLeavebal) {
                                        days++;
                                    }
                                    break;
                                }
                                break;
                            }
                        }
                        coutnter++;
                    }
                } //-------------------Code for Wednesday and Thursday List Check Ends Here-------------
                //-------------------Code for Thursday and Friday List Check Starts Here-------------
                else if (sm.format(dt1).equals("Thursday") && sm.format(dt2).equals("Friday")) {
                    for (String z : weekOffDay.split(",")) {
                        int weekOff = 0;
                        if (!z.equals("")) {
                            if (z.equals("Sunday")) {
                                weekOff = 1;
                                sundayCheck = true;
                            } else if (z.equals("Monday")) {
                                weekOff = 2;
                            } else if (z.equals("Tuesday")) {
                                weekOff = 3;
                            } else if (z.equals("Wednesday")) {
                                weekOff = 4;
                            } else if (z.equals("Thursday")) {
                                weekOff = 5;
                            } else if (z.equals("Friday")) {
                                weekOff = 6;
                            } else if (z.equals("Saturday")) {
                                weekOff = 7;
                            }
                        }
                        if (c.get(Calendar.DAY_OF_WEEK) != weekOff) {
                            if (c.get(Calendar.DAY_OF_WEEK) == 7 && coutnter == 0) {
                                if (sDateStatus.contains("SecondHalf")) {
                                    if (!strDate.equals(enDate)) {
                                        days--;
                                    }
                                }
                            }
                        }
                        if (!leavetype.equals("6") && !leavetype.equals("7") && !leavetype.equals("16") && !leavetype.equals("12")) {
                            if (c.get(Calendar.DAY_OF_WEEK) == 7 && !sDateStatus.contains("SecondHalf")) {
                                if (!strDate.equals(enDate)) {
                                    days--;
                                }
                            }
                        }
                        if (leavetype.equals("7")) {
                            if (c.get(Calendar.DAY_OF_WEEK) == weekOff && c.get(Calendar.DAY_OF_WEEK) != 6) {
                                days--;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 4 && sDateStatus.contains("SecondHalf") && eDateStatus != "" && weekOff != 6) {
                                days = days - (float) 1;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 4 && sDateStatus.contains("FirstHalf") && eDateStatus != "" && weekOff != 6) {
                                days = days - (float) 1;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 7 && eDateStatus.contains("Fullday") && weekOff != 5 && weekOff != 6) {
                                days = days - (float) 0.5;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 7 && sDateStatus.contains("Fullday")) {
                                Calendar c12 = Calendar.getInstance();
                                c12.setTime(sDate);
                                c12.add(Calendar.WEEK_OF_YEAR, -1);
                                c12.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
                                int d = c.get(Calendar.MONTH);
                                String fdate = c12.get(Calendar.DATE) + "/" + (d + 1) + "/" + c12.get(Calendar.YEAR);
                                Boolean empPreviousLeavebal = leaveEmployeeDetailService.readPreviousLeaveFriday(fdate, employeeMaster1.getId());
                                if (empPreviousLeavebal) {
                                    days++;
                                }
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 1 && sDateStatus.contains("Fullday")) {
                                Calendar c123 = Calendar.getInstance();
                                c123.setTime(sDate);
                                c123.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
                                int d1 = c.get(Calendar.MONTH);
                                String fdate1 = c123.get(Calendar.DATE) + "/" + (d1 + 1) + "/" + c123.get(Calendar.YEAR);
                                List list12 = holidayMasterService.checkHoliday(fdate1, "" + employeeMaster1.getLocationMaster().getId());
                                if (list12.size() == 1) {
                                    Calendar c12 = Calendar.getInstance();
                                    c12.setTime(sDate);
                                    c12.add(Calendar.WEEK_OF_YEAR, -1);
                                    c12.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
                                    int d = c.get(Calendar.MONTH);
                                    String fdate = c12.get(Calendar.DATE) + "/" + (d + 1) + "/" + c12.get(Calendar.YEAR);
                                    Boolean empPreviousLeavebal = leaveEmployeeDetailService.readPreviousLeaveFriday(fdate, employeeMaster1.getId());
                                    if (empPreviousLeavebal) {
                                        days++;
                                    }
                                    break;
                                }
                                break;
                            }
                        }
                        coutnter++;
                    }
                } //-------------------Code for Thursday and Friday List Check Ends Here-------------
                //-------------------Code for Friday & Saturday List Check Starts Here-------------
                else if (sm.format(dt1).equals("Friday") && sm.format(dt2).equals("Saturday")) {
                    for (String z : weekOffDay.split(",")) {
                        int weekOff = 0;
                        if (!z.equals("")) {
                            if (z.equals("Sunday")) {
                                weekOff = 1;
                                sundayCheck = true;
                            } else if (z.equals("Monday")) {
                                weekOff = 2;
                            } else if (z.equals("Tuesday")) {
                                weekOff = 3;
                            } else if (z.equals("Wednesday")) {
                                weekOff = 4;
                            } else if (z.equals("Thursday")) {
                                weekOff = 5;
                            } else if (z.equals("Friday")) {
                                weekOff = 6;
                            } else if (z.equals("Saturday")) {
                                weekOff = 7;
                            }
                        }
                        if (c.get(Calendar.DAY_OF_WEEK) != weekOff) {
                            if (c.get(Calendar.DAY_OF_WEEK) == 7 && coutnter == 0) {
                                if (sDateStatus.contains("SecondHalf")) {
                                    if (!strDate.equals(enDate)) {
                                        days--;
                                    }
                                }
                            }
                        }
                        if (!leavetype.equals("6") && !leavetype.equals("7") && !leavetype.equals("16") && !leavetype.equals("12")) {
                            if (c.get(Calendar.DAY_OF_WEEK) == 7 && !sDateStatus.contains("SecondHalf")) {
                                if (!strDate.equals(enDate)) {
                                    days--;
                                }
                            }
                        }
                        if (leavetype.equals("7")) {
                            if (c.get(Calendar.DAY_OF_WEEK) == weekOff && c.get(Calendar.DAY_OF_WEEK) != 7) {
                                days--;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 5 && sDateStatus.contains("SecondHalf") && eDateStatus != "" && weekOff != 7) {
                                days = days - (float) 1;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 5 && sDateStatus.contains("FirstHalf") && eDateStatus != "" && weekOff != 7) {
                                days = days - (float) 1;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 1 && eDateStatus.contains("Fullday") && weekOff != 6 && weekOff != 7) {
                                days = days - (float) 0.5;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 1 && sDateStatus.contains("Fullday")) {
                                Calendar c12 = Calendar.getInstance();
                                c12.setTime(sDate);
                                c12.add(Calendar.WEEK_OF_YEAR, -1);
                                c12.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
                                int d = c.get(Calendar.MONTH);
                                String fdate = c12.get(Calendar.DATE) + "/" + (d + 1) + "/" + c12.get(Calendar.YEAR);
                                Boolean empPreviousLeavebal = leaveEmployeeDetailService.readPreviousLeaveFriday(fdate, employeeMaster1.getId());
                                if (empPreviousLeavebal) {
                                    days++;
                                }
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 2 && sDateStatus.contains("Fullday")) {
                                Calendar c123 = Calendar.getInstance();
                                c123.setTime(sDate);
                                c123.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
                                int d1 = c.get(Calendar.MONTH);
                                String fdate1 = c123.get(Calendar.DATE) + "/" + (d1 + 1) + "/" + c123.get(Calendar.YEAR);
                                List list12 = holidayMasterService.checkHoliday(fdate1, "" + employeeMaster1.getLocationMaster().getId());
                                if (list12.size() == 1) {
                                    Calendar c12 = Calendar.getInstance();
                                    c12.setTime(sDate);
                                    c12.add(Calendar.WEEK_OF_YEAR, -1);
                                    c12.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
                                    int d = c.get(Calendar.MONTH);
                                    String fdate = c12.get(Calendar.DATE) + "/" + (d + 1) + "/" + c12.get(Calendar.YEAR);
                                    Boolean empPreviousLeavebal = leaveEmployeeDetailService.readPreviousLeaveFriday(fdate, employeeMaster1.getId());
                                    if (empPreviousLeavebal) {
                                        days++;
                                    }
                                    break;
                                }
                                break;
                            }
                        }
                        coutnter++;
                    }
                }
                //-------------------Code for Friday & Saturday List Check Ends Here-------------
                c.add(Calendar.DATE, 1);
            }
        } else if (Boolean.parseBoolean(useSickLeave) == false && !leavetype.equals("7")) {
            while (c.getTime().before(eDate) || c.getTime().equals(eDate)) {

                Calendar calForEnddate = Calendar.getInstance();
                calForEnddate.setTime(eDate);
                int dayEnd = calForEnddate.get(Calendar.DAY_OF_WEEK);

//              
////                    if (c.get(Calendar.DAY_OF_WEEK) != weekOff) {
                int dayOfWeek = c.get(Calendar.WEEK_OF_MONTH);
                Date nDate = c.getTime();
                String daString = sdf.format(nDate);
                HolidayMaster holidayMaster = new HolidayMaster();
                holidayMaster.setHolidayFromDate(daString);
                List list = holidayMasterService.checkHoliday(daString, "" + employeeMaster1.getLocationMaster().getId());
                if (list.size() == 0) {
                    days++;
                }
                //-------------------Code for Saturday & Sunday Starts Here-------------
                if (sm.format(dt1).equals("Saturday") && sm.format(dt2).equals("Sunday")) {
                    for (String z : weekOffDay.split(",")) {
                        int weekOff = 0;
                        if (!z.equals("")) {
                            if (z.equals("Sunday")) {
                                weekOff = 1;
                                sundayCheck = true;
                            } else if (z.equals("Monday")) {
                                weekOff = 2;
                            } else if (z.equals("Tuesday")) {
                                weekOff = 3;
                            } else if (z.equals("Wednesday")) {
                                weekOff = 4;
                            } else if (z.equals("Thursday")) {
                                weekOff = 5;
                            } else if (z.equals("Friday")) {
                                weekOff = 6;
                            } else if (z.equals("Saturday")) {
                                weekOff = 7;
                            }
                        }
                        if (c.get(Calendar.DAY_OF_WEEK) != weekOff) {
                            if (c.get(Calendar.DAY_OF_WEEK) == 7 && coutnter == 0) {
                                if (sDateStatus.contains("SecondHalf")) {
                                    if (!strDate.equals(enDate)) {
                                        days--;
                                    }
                                }
                            }
                        }
                        if (!leavetype.equals("6") && !leavetype.equals("7") && !leavetype.equals("16") && !leavetype.equals("12")) {
                            if (c.get(Calendar.DAY_OF_WEEK) == 7 && !sDateStatus.contains("SecondHalf")) {
                                if (!strDate.equals(enDate)) {
                                    days--;
                                }
                            }
                        }
                        if (leavetype.equals("7")) {
                            if (c.get(Calendar.DAY_OF_WEEK) == weekOff && c.get(Calendar.DAY_OF_WEEK) != 1) {
                                days--;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 6 && sDateStatus.contains("SecondHalf") && eDateStatus != "" && weekOff != 1) {
                                days = days - (float) 1;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 6 && sDateStatus.contains("FirstHalf") && eDateStatus != "" && weekOff != 1) {
                                days = days - (float) 1;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 2 && eDateStatus.contains("Fullday") && weekOff != 1 && weekOff != 7) {
                                days = days - (float) 0.5;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 2 && sDateStatus.contains("Fullday")) {
                                Calendar c12 = Calendar.getInstance();
                                c12.setTime(sDate);
                                c12.add(Calendar.WEEK_OF_YEAR, -1);
                                c12.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
                                int d = c.get(Calendar.MONTH);
                                String fdate = c12.get(Calendar.DATE) + "/" + (d + 1) + "/" + c12.get(Calendar.YEAR);
                                Boolean empPreviousLeavebal = leaveEmployeeDetailService.readPreviousLeaveFriday(fdate, employeeMaster1.getId());
                                if (empPreviousLeavebal) {
                                    days++;
                                }
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 3 && sDateStatus.contains("Fullday")) {
                                Calendar c123 = Calendar.getInstance();
                                c123.setTime(sDate);
                                c123.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
                                int d1 = c.get(Calendar.MONTH);
                                String fdate1 = c123.get(Calendar.DATE) + "/" + (d1 + 1) + "/" + c123.get(Calendar.YEAR);
                                List list12 = holidayMasterService.checkHoliday(fdate1, "" + employeeMaster1.getLocationMaster().getId());
                                if (list12.size() == 1) {
                                    Calendar c12 = Calendar.getInstance();
                                    c12.setTime(sDate);
                                    c12.add(Calendar.WEEK_OF_YEAR, -1);
                                    c12.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
                                    int d = c.get(Calendar.MONTH);
                                    String fdate = c12.get(Calendar.DATE) + "/" + (d + 1) + "/" + c12.get(Calendar.YEAR);
                                    Boolean empPreviousLeavebal = leaveEmployeeDetailService.readPreviousLeaveFriday(fdate, employeeMaster1.getId());
                                    if (empPreviousLeavebal) {
                                        days++;
                                    }
                                    break;
                                }
                                break;
                            }
                        }

                        coutnter++;
                    }
                } //-------------------Code for Saturday & Sunday List Check Ends Here-------------
                //-------------------Code for Sunday & Monday Starts Here-------------
                else if (sm.format(dt1).equals("Sunday") && sm.format(dt2).equals("Monday")) {
                    for (String z : weekOffDay.split(",")) {
                        int weekOff = 0;
                        if (!z.equals("")) {
                            if (z.equals("Sunday")) {
                                weekOff = 1;
                                sundayCheck = true;
                            } else if (z.equals("Monday")) {
                                weekOff = 2;
                            } else if (z.equals("Tuesday")) {
                                weekOff = 3;
                            } else if (z.equals("Wednesday")) {
                                weekOff = 4;
                            } else if (z.equals("Thursday")) {
                                weekOff = 5;
                            } else if (z.equals("Friday")) {
                                weekOff = 6;
                            } else if (z.equals("Saturday")) {
                                weekOff = 7;
                            }
                        }
                        if (c.get(Calendar.DAY_OF_WEEK) != weekOff) {
                            if (c.get(Calendar.DAY_OF_WEEK) == 7 && coutnter == 0) {
                                if (sDateStatus.contains("SecondHalf")) {
                                    if (!strDate.equals(enDate)) {
                                        days--;
                                    }
                                }
                            }
                        }
                        if (!leavetype.equals("6") && !leavetype.equals("7") && !leavetype.equals("16") && !leavetype.equals("12")) {
                            if (c.get(Calendar.DAY_OF_WEEK) == 7 && !sDateStatus.contains("SecondHalf")) {
                                if (!strDate.equals(enDate)) {
                                    days--;
                                }
                            }
                        }
                        if (leavetype.equals("7")) {
                            if (c.get(Calendar.DAY_OF_WEEK) == weekOff && c.get(Calendar.DAY_OF_WEEK) != 2) {
                                days--;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 7 && sDateStatus.contains("SecondHalf") && eDateStatus != "" && weekOff != 2) {
                                days = days - (float) 1;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 7 && sDateStatus.contains("FirstHalf") && eDateStatus != "" && weekOff != 2) {
                                days = days - (float) 1;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 3 && eDateStatus.contains("Fullday") && weekOff != 1 && weekOff != 2) {
                                days = days - (float) 0.5;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 3 && sDateStatus.contains("Fullday")) {
                                Calendar c12 = Calendar.getInstance();
                                c12.setTime(sDate);
                                c12.add(Calendar.WEEK_OF_YEAR, -1);
                                c12.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
                                int d = c.get(Calendar.MONTH);
                                String fdate = c12.get(Calendar.DATE) + "/" + (d + 1) + "/" + c12.get(Calendar.YEAR);
                                Boolean empPreviousLeavebal = leaveEmployeeDetailService.readPreviousLeaveFriday(fdate, employeeMaster1.getId());
                                if (empPreviousLeavebal) {
                                    days++;
                                }
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 4 && sDateStatus.contains("Fullday")) {
                                Calendar c123 = Calendar.getInstance();
                                c123.setTime(sDate);
                                c123.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
                                int d1 = c.get(Calendar.MONTH);
                                String fdate1 = c123.get(Calendar.DATE) + "/" + (d1 + 1) + "/" + c123.get(Calendar.YEAR);
                                List list12 = holidayMasterService.checkHoliday(fdate1, "" + employeeMaster1.getLocationMaster().getId());
                                if (list12.size() == 1) {
                                    Calendar c12 = Calendar.getInstance();
                                    c12.setTime(sDate);
                                    c12.add(Calendar.WEEK_OF_YEAR, -1);
                                    c12.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
                                    int d = c.get(Calendar.MONTH);
                                    String fdate = c12.get(Calendar.DATE) + "/" + (d + 1) + "/" + c12.get(Calendar.YEAR);
                                    Boolean empPreviousLeavebal = leaveEmployeeDetailService.readPreviousLeaveFriday(fdate, employeeMaster1.getId());
                                    if (empPreviousLeavebal) {
                                        days++;
                                    }
                                    break;
                                }
                                break;
                            }
                        }

                        coutnter++;
                    }
                } //-------------------Code for Sunday & Monday List Check Ends Here-------------
                //-------------------Code for Monday & Tuesday Starts Here-------------
                else if (sm.format(dt1).equals("Monday") && sm.format(dt2).equals("Tuesday")) {
                    for (String z : weekOffDay.split(",")) {
                        int weekOff = 0;
                        if (!z.equals("")) {
                            if (z.equals("Sunday")) {
                                weekOff = 1;
                                sundayCheck = true;
                            } else if (z.equals("Monday")) {
                                weekOff = 2;
                            } else if (z.equals("Tuesday")) {
                                weekOff = 3;
                            } else if (z.equals("Wednesday")) {
                                weekOff = 4;
                            } else if (z.equals("Thursday")) {
                                weekOff = 5;
                            } else if (z.equals("Friday")) {
                                weekOff = 6;
                            } else if (z.equals("Saturday")) {
                                weekOff = 7;
                            }
                        }
                        if (c.get(Calendar.DAY_OF_WEEK) != weekOff) {
                            if (c.get(Calendar.DAY_OF_WEEK) == 7 && coutnter == 0) {
                                if (sDateStatus.contains("SecondHalf")) {
                                    if (!strDate.equals(enDate)) {
                                        days--;
                                    }
                                }
                            }
                        }
                        if (!leavetype.equals("6") && !leavetype.equals("7") && !leavetype.equals("16") && !leavetype.equals("12")) {
                            if (c.get(Calendar.DAY_OF_WEEK) == 7 && !sDateStatus.contains("SecondHalf")) {
                                if (!strDate.equals(enDate)) {
                                    days--;
                                }
                            }
                        }
                        if (leavetype.equals("7")) {
                            if (c.get(Calendar.DAY_OF_WEEK) == weekOff && c.get(Calendar.DAY_OF_WEEK) != 3) {
                                days--;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 1 && sDateStatus.contains("SecondHalf") && eDateStatus != "" && weekOff != 3) {
                                days = days - (float) 1;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 1 && sDateStatus.contains("FirstHalf") && eDateStatus != "" && weekOff != 3) {
                                days = days - (float) 1;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 4 && eDateStatus.contains("Fullday") && weekOff != 2 && weekOff != 3) {
                                days = days - (float) 0.5;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 4 && sDateStatus.contains("Fullday")) {
                                Calendar c12 = Calendar.getInstance();
                                c12.setTime(sDate);
                                c12.add(Calendar.WEEK_OF_YEAR, -1);
                                c12.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
                                int d = c.get(Calendar.MONTH);
                                String fdate = c12.get(Calendar.DATE) + "/" + (d + 1) + "/" + c12.get(Calendar.YEAR);
                                Boolean empPreviousLeavebal = leaveEmployeeDetailService.readPreviousLeaveFriday(fdate, employeeMaster1.getId());
                                if (empPreviousLeavebal) {
                                    days++;
                                }
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 5 && sDateStatus.contains("Fullday")) {
                                Calendar c123 = Calendar.getInstance();
                                c123.setTime(sDate);
                                c123.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
                                int d1 = c.get(Calendar.MONTH);
                                String fdate1 = c123.get(Calendar.DATE) + "/" + (d1 + 1) + "/" + c123.get(Calendar.YEAR);
                                List list12 = holidayMasterService.checkHoliday(fdate1, "" + employeeMaster1.getLocationMaster().getId());
                                if (list12.size() == 1) {
                                    Calendar c12 = Calendar.getInstance();
                                    c12.setTime(sDate);
                                    c12.add(Calendar.WEEK_OF_YEAR, -1);
                                    c12.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
                                    int d = c.get(Calendar.MONTH);
                                    String fdate = c12.get(Calendar.DATE) + "/" + (d + 1) + "/" + c12.get(Calendar.YEAR);
                                    Boolean empPreviousLeavebal = leaveEmployeeDetailService.readPreviousLeaveFriday(fdate, employeeMaster1.getId());
                                    if (empPreviousLeavebal) {
                                        days++;
                                    }
                                    break;
                                }
                                break;
                            }
                        }

                        coutnter++;
                    }
                } //-------------------Code for Monday & Tuesday List Check Ends Here-------------
                //-------------------Code for Tuesday & Wednesday Starts Here-------------
                else if (sm.format(dt1).equals("Tuesday") && sm.format(dt2).equals("Wednesday")) {
                    for (String z : weekOffDay.split(",")) {
                        int weekOff = 0;
                        if (!z.equals("")) {
                            if (z.equals("Sunday")) {
                                weekOff = 1;
                                sundayCheck = true;
                            } else if (z.equals("Monday")) {
                                weekOff = 2;
                            } else if (z.equals("Tuesday")) {
                                weekOff = 3;
                            } else if (z.equals("Wednesday")) {
                                weekOff = 4;
                            } else if (z.equals("Thursday")) {
                                weekOff = 5;
                            } else if (z.equals("Friday")) {
                                weekOff = 6;
                            } else if (z.equals("Saturday")) {
                                weekOff = 7;
                            }
                        }
                        if (c.get(Calendar.DAY_OF_WEEK) != weekOff) {
                            if (c.get(Calendar.DAY_OF_WEEK) == 7 && coutnter == 0) {
                                if (sDateStatus.contains("SecondHalf")) {
                                    if (!strDate.equals(enDate)) {
                                        days--;
                                    }
                                }
                            }
                        }
                        if (!leavetype.equals("6") && !leavetype.equals("7") && !leavetype.equals("16") && !leavetype.equals("12")) {
                            if (c.get(Calendar.DAY_OF_WEEK) == 7 && !sDateStatus.contains("SecondHalf")) {
                                if (!strDate.equals(enDate)) {
                                    days--;
                                }
                            }
                        }
                        if (leavetype.equals("7")) {
                            if (c.get(Calendar.DAY_OF_WEEK) == weekOff && c.get(Calendar.DAY_OF_WEEK) != 4) {
                                days--;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 2 && sDateStatus.contains("SecondHalf") && eDateStatus != "" && weekOff != 4) {
                                days = days - (float) 1;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 2 && sDateStatus.contains("FirstHalf") && eDateStatus != "" && weekOff != 4) {
                                days = days - (float) 1;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 5 && eDateStatus.contains("Fullday") && weekOff != 3 && weekOff != 4) {
                                days = days - (float) 0.5;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 5 && sDateStatus.contains("Fullday")) {
                                Calendar c12 = Calendar.getInstance();
                                c12.setTime(sDate);
                                c12.add(Calendar.WEEK_OF_YEAR, -1);
                                c12.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
                                int d = c.get(Calendar.MONTH);
                                String fdate = c12.get(Calendar.DATE) + "/" + (d + 1) + "/" + c12.get(Calendar.YEAR);
                                Boolean empPreviousLeavebal = leaveEmployeeDetailService.readPreviousLeaveFriday(fdate, employeeMaster1.getId());
                                if (empPreviousLeavebal) {
                                    days++;
                                }
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 6 && sDateStatus.contains("Fullday")) {
                                Calendar c123 = Calendar.getInstance();
                                c123.setTime(sDate);
                                c123.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
                                int d1 = c.get(Calendar.MONTH);
                                String fdate1 = c123.get(Calendar.DATE) + "/" + (d1 + 1) + "/" + c123.get(Calendar.YEAR);
                                List list12 = holidayMasterService.checkHoliday(fdate1, "" + employeeMaster1.getLocationMaster().getId());
                                if (list12.size() == 1) {
                                    Calendar c12 = Calendar.getInstance();
                                    c12.setTime(sDate);
                                    c12.add(Calendar.WEEK_OF_YEAR, -1);
                                    c12.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
                                    int d = c.get(Calendar.MONTH);
                                    String fdate = c12.get(Calendar.DATE) + "/" + (d + 1) + "/" + c12.get(Calendar.YEAR);
                                    Boolean empPreviousLeavebal = leaveEmployeeDetailService.readPreviousLeaveFriday(fdate, employeeMaster1.getId());
                                    if (empPreviousLeavebal) {
                                        days++;
                                    }
                                    break;
                                }
                                break;
                            }
                        }

                        coutnter++;
                    }
                } //-------------------Code for Tuesday & Wednesday List Check Ends Here-------------
                //-------------------Code for Wednesday & Thursday Starts Here-------------
                else if (sm.format(dt1).equals("Wednesday") && sm.format(dt2).equals("Thursday")) {
                    for (String z : weekOffDay.split(",")) {
                        int weekOff = 0;
                        if (!z.equals("")) {
                            if (z.equals("Sunday")) {
                                weekOff = 1;
                                sundayCheck = true;
                            } else if (z.equals("Monday")) {
                                weekOff = 2;
                            } else if (z.equals("Tuesday")) {
                                weekOff = 3;
                            } else if (z.equals("Wednesday")) {
                                weekOff = 4;
                            } else if (z.equals("Thursday")) {
                                weekOff = 5;
                            } else if (z.equals("Friday")) {
                                weekOff = 6;
                            } else if (z.equals("Saturday")) {
                                weekOff = 7;
                            }
                        }
                        if (c.get(Calendar.DAY_OF_WEEK) != weekOff) {
                            if (c.get(Calendar.DAY_OF_WEEK) == 7 && coutnter == 0) {
                                if (sDateStatus.contains("SecondHalf")) {
                                    if (!strDate.equals(enDate)) {
                                        days--;
                                    }
                                }
                            }
                        }
                        if (!leavetype.equals("6") && !leavetype.equals("7") && !leavetype.equals("16") && !leavetype.equals("12")) {
                            if (c.get(Calendar.DAY_OF_WEEK) == 7 && !sDateStatus.contains("SecondHalf")) {
                                if (!strDate.equals(enDate)) {
                                    days--;
                                }
                            }
                        }
                        if (leavetype.equals("7")) {
                            if (c.get(Calendar.DAY_OF_WEEK) == weekOff && c.get(Calendar.DAY_OF_WEEK) != 5) {
                                days--;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 3 && sDateStatus.contains("SecondHalf") && eDateStatus != "" && weekOff != 5) {
                                days = days - (float) 1;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 3 && sDateStatus.contains("FirstHalf") && eDateStatus != "" && weekOff != 5) {
                                days = days - (float) 1;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 6 && eDateStatus.contains("Fullday") && weekOff != 4 && weekOff != 5) {
                                days = days - (float) 0.5;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 6 && sDateStatus.contains("Fullday")) {
                                Calendar c12 = Calendar.getInstance();
                                c12.setTime(sDate);
                                c12.add(Calendar.WEEK_OF_YEAR, -1);
                                c12.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
                                int d = c.get(Calendar.MONTH);
                                String fdate = c12.get(Calendar.DATE) + "/" + (d + 1) + "/" + c12.get(Calendar.YEAR);
                                Boolean empPreviousLeavebal = leaveEmployeeDetailService.readPreviousLeaveFriday(fdate, employeeMaster1.getId());
                                if (empPreviousLeavebal) {
                                    days++;
                                }
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 7 && sDateStatus.contains("Fullday")) {
                                Calendar c123 = Calendar.getInstance();
                                c123.setTime(sDate);
                                c123.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
                                int d1 = c.get(Calendar.MONTH);
                                String fdate1 = c123.get(Calendar.DATE) + "/" + (d1 + 1) + "/" + c123.get(Calendar.YEAR);
                                List list12 = holidayMasterService.checkHoliday(fdate1, "" + employeeMaster1.getLocationMaster().getId());
                                if (list12.size() == 1) {
                                    Calendar c12 = Calendar.getInstance();
                                    c12.setTime(sDate);
                                    c12.add(Calendar.WEEK_OF_YEAR, -1);
                                    c12.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
                                    int d = c.get(Calendar.MONTH);
                                    String fdate = c12.get(Calendar.DATE) + "/" + (d + 1) + "/" + c12.get(Calendar.YEAR);
                                    Boolean empPreviousLeavebal = leaveEmployeeDetailService.readPreviousLeaveFriday(fdate, employeeMaster1.getId());
                                    if (empPreviousLeavebal) {
                                        days++;
                                    }
                                    break;
                                }
                                break;
                            }
                        }

                        coutnter++;
                    }
                } //-------------------Code for Wednesday & Thursday List Check Ends Here-------------
                //-------------------Code for Thursday & Friday Starts Here-------------
                else if (sm.format(dt1).equals("Thursday") && sm.format(dt2).equals("Friday")) {
                    for (String z : weekOffDay.split(",")) {
                        int weekOff = 0;
                        if (!z.equals("")) {
                            if (z.equals("Sunday")) {
                                weekOff = 1;
                                sundayCheck = true;
                            } else if (z.equals("Monday")) {
                                weekOff = 2;
                            } else if (z.equals("Tuesday")) {
                                weekOff = 3;
                            } else if (z.equals("Wednesday")) {
                                weekOff = 4;
                            } else if (z.equals("Thursday")) {
                                weekOff = 5;
                            } else if (z.equals("Friday")) {
                                weekOff = 6;
                            } else if (z.equals("Saturday")) {
                                weekOff = 7;
                            }
                        }
                        if (c.get(Calendar.DAY_OF_WEEK) != weekOff) {
                            if (c.get(Calendar.DAY_OF_WEEK) == 7 && coutnter == 0) {
                                if (sDateStatus.contains("SecondHalf")) {
                                    if (!strDate.equals(enDate)) {
                                        days--;
                                    }
                                }
                            }
                        }
                        if (!leavetype.equals("6") && !leavetype.equals("7") && !leavetype.equals("16") && !leavetype.equals("12")) {
                            if (c.get(Calendar.DAY_OF_WEEK) == 7 && !sDateStatus.contains("SecondHalf")) {
                                if (!strDate.equals(enDate)) {
                                    days--;
                                }
                            }
                        }
                        if (leavetype.equals("7")) {
                            if (c.get(Calendar.DAY_OF_WEEK) == weekOff && c.get(Calendar.DAY_OF_WEEK) != 6) {
                                days--;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 4 && sDateStatus.contains("SecondHalf") && eDateStatus != "" && weekOff != 6) {
                                days = days - (float) 1;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 4 && sDateStatus.contains("FirstHalf") && eDateStatus != "" && weekOff != 6) {
                                days = days - (float) 1;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 7 && eDateStatus.contains("Fullday") && weekOff != 5 && weekOff != 6) {
                                days = days - (float) 0.5;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 7 && sDateStatus.contains("Fullday")) {
                                Calendar c12 = Calendar.getInstance();
                                c12.setTime(sDate);
                                c12.add(Calendar.WEEK_OF_YEAR, -1);
                                c12.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
                                int d = c.get(Calendar.MONTH);
                                String fdate = c12.get(Calendar.DATE) + "/" + (d + 1) + "/" + c12.get(Calendar.YEAR);
                                Boolean empPreviousLeavebal = leaveEmployeeDetailService.readPreviousLeaveFriday(fdate, employeeMaster1.getId());
                                if (empPreviousLeavebal) {
                                    days++;
                                }
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 1 && sDateStatus.contains("Fullday")) {
                                Calendar c123 = Calendar.getInstance();
                                c123.setTime(sDate);
                                c123.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
                                int d1 = c.get(Calendar.MONTH);
                                String fdate1 = c123.get(Calendar.DATE) + "/" + (d1 + 1) + "/" + c123.get(Calendar.YEAR);
                                List list12 = holidayMasterService.checkHoliday(fdate1, "" + employeeMaster1.getLocationMaster().getId());
                                if (list12.size() == 1) {
                                    Calendar c12 = Calendar.getInstance();
                                    c12.setTime(sDate);
                                    c12.add(Calendar.WEEK_OF_YEAR, -1);
                                    c12.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
                                    int d = c.get(Calendar.MONTH);
                                    String fdate = c12.get(Calendar.DATE) + "/" + (d + 1) + "/" + c12.get(Calendar.YEAR);
                                    Boolean empPreviousLeavebal = leaveEmployeeDetailService.readPreviousLeaveFriday(fdate, employeeMaster1.getId());
                                    if (empPreviousLeavebal) {
                                        days++;
                                    }
                                    break;
                                }
                                break;
                            }
                        }

                        coutnter++;
                    }
                } //-------------------Code for Thursday & Friday  Ends Here-------------
                //-------------------Code for Friday & Saturday Starts Here-------------
                else if (sm.format(dt1).equals("Friday") && sm.format(dt2).equals("Saturday")) {
                    for (String z : weekOffDay.split(",")) {
                        int weekOff = 0;
                        if (!z.equals("")) {
                            if (z.equals("Sunday")) {
                                weekOff = 1;
                                sundayCheck = true;
                            } else if (z.equals("Monday")) {
                                weekOff = 2;
                            } else if (z.equals("Tuesday")) {
                                weekOff = 3;
                            } else if (z.equals("Wednesday")) {
                                weekOff = 4;
                            } else if (z.equals("Thursday")) {
                                weekOff = 5;
                            } else if (z.equals("Friday")) {
                                weekOff = 6;
                            } else if (z.equals("Saturday")) {
                                weekOff = 7;
                            }
                        }
                        if (c.get(Calendar.DAY_OF_WEEK) != weekOff) {
                            if (c.get(Calendar.DAY_OF_WEEK) == 7 && coutnter == 0) {
                                if (sDateStatus.contains("SecondHalf")) {
                                    if (!strDate.equals(enDate)) {
                                        days--;
                                    }
                                }
                            }
                        }
                        if (!leavetype.equals("6") && !leavetype.equals("7") && !leavetype.equals("16") && !leavetype.equals("12")) {
                            if (c.get(Calendar.DAY_OF_WEEK) == 7 && !sDateStatus.contains("SecondHalf")) {
                                if (!strDate.equals(enDate)) {
                                    days--;
                                }
                            }
                        }
                        if (leavetype.equals("7")) {
                            if (c.get(Calendar.DAY_OF_WEEK) == weekOff && c.get(Calendar.DAY_OF_WEEK) != 7) {
                                days--;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 5 && sDateStatus.contains("SecondHalf") && eDateStatus != "" && weekOff != 7) {
                                days = days - (float) 1;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 5 && sDateStatus.contains("FirstHalf") && eDateStatus != "" && weekOff != 7) {
                                days = days - (float) 1;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 1 && eDateStatus.contains("Fullday") && weekOff != 6 && weekOff != 7) {
                                days = days - (float) 0.5;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 1 && sDateStatus.contains("Fullday")) {
                                Calendar c12 = Calendar.getInstance();
                                c12.setTime(sDate);
                                c12.add(Calendar.WEEK_OF_YEAR, -1);
                                c12.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
                                int d = c.get(Calendar.MONTH);
                                String fdate = c12.get(Calendar.DATE) + "/" + (d + 1) + "/" + c12.get(Calendar.YEAR);
                                Boolean empPreviousLeavebal = leaveEmployeeDetailService.readPreviousLeaveFriday(fdate, employeeMaster1.getId());
                                if (empPreviousLeavebal) {
                                    days++;
                                }
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 2 && sDateStatus.contains("Fullday")) {
                                Calendar c123 = Calendar.getInstance();
                                c123.setTime(sDate);
                                c123.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
                                int d1 = c.get(Calendar.MONTH);
                                String fdate1 = c123.get(Calendar.DATE) + "/" + (d1 + 1) + "/" + c123.get(Calendar.YEAR);
                                List list12 = holidayMasterService.checkHoliday(fdate1, "" + employeeMaster1.getLocationMaster().getId());
                                if (list12.size() == 1) {
                                    Calendar c12 = Calendar.getInstance();
                                    c12.setTime(sDate);
                                    c12.add(Calendar.WEEK_OF_YEAR, -1);
                                    c12.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
                                    int d = c.get(Calendar.MONTH);
                                    String fdate = c12.get(Calendar.DATE) + "/" + (d + 1) + "/" + c12.get(Calendar.YEAR);
                                    Boolean empPreviousLeavebal = leaveEmployeeDetailService.readPreviousLeaveFriday(fdate, employeeMaster1.getId());
                                    if (empPreviousLeavebal) {
                                        days++;
                                    }
                                    break;
                                }
                                break;
                            }
                        }

                        coutnter++;
                    }
                }
                //-------------------Code for Friday & Saturday  Ends Here-------------
                c.add(Calendar.DATE, 1);

            }
        } else if (Boolean.parseBoolean(useSickLeave) == true && (leavetype.equals("6") || leavetype.equals("7"))) {
            while (c.getTime().before(eDate) || c.getTime().equals(eDate)) {

                Calendar calForEnddate = Calendar.getInstance();
                calForEnddate.setTime(eDate);
                int dayEnd = calForEnddate.get(Calendar.DAY_OF_WEEK);

//              
////                    if (c.get(Calendar.DAY_OF_WEEK) != weekOff) {
                int dayOfWeek = c.get(Calendar.WEEK_OF_MONTH);
                Date nDate = c.getTime();
                String daString = sdf.format(nDate);
                HolidayMaster holidayMaster = new HolidayMaster();
                holidayMaster.setHolidayFromDate(daString);
                List list = holidayMasterService.checkHoliday(daString, "" + employeeMaster1.getLocationMaster().getId());
                if (list.size() == 0) {
                    days++;
                }
                //-------------------Code for Saturday & Sunday Starts Here-------------
                if (sm.format(dt1).equals("Saturday") && sm.format(dt2).equals("Sunday")) {
                    for (String z : weekOffDay.split(",")) {
                        int weekOff = 0;
                        if (!z.equals("")) {
                            if (z.equals("Sunday")) {
                                weekOff = 1;
                                sundayCheck = true;
                            } else if (z.equals("Monday")) {
                                weekOff = 2;
                            } else if (z.equals("Tuesday")) {
                                weekOff = 3;
                            } else if (z.equals("Wednesday")) {
                                weekOff = 4;
                            } else if (z.equals("Thursday")) {
                                weekOff = 5;
                            } else if (z.equals("Friday")) {
                                weekOff = 6;
                            } else if (z.equals("Saturday")) {
                                weekOff = 7;
                            }
                        }
                        if (c.get(Calendar.DAY_OF_WEEK) != weekOff) {
                            if (c.get(Calendar.DAY_OF_WEEK) == 7 && coutnter == 0) {
                                if (sDateStatus.contains("SecondHalf")) {
                                    if (!strDate.equals(enDate)) {
                                        days--;
                                    }
                                }
                            }
                        }
                        if (!leavetype.equals("6") && !leavetype.equals("7") && !leavetype.equals("16") && !leavetype.equals("12")) {
                            if (c.get(Calendar.DAY_OF_WEEK) == 7 && !sDateStatus.contains("SecondHalf")) {
                                if (!strDate.equals(enDate)) {
                                    days--;
                                }
                            }
                        }
                        if (leavetype.equals("7")) {
                            if (c.get(Calendar.DAY_OF_WEEK) == weekOff && c.get(Calendar.DAY_OF_WEEK) != 1) {
                                days--;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 6 && sDateStatus.contains("SecondHalf") && eDateStatus != "" && weekOff != 1) {
                                days = days - (float) 1;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 6 && sDateStatus.contains("FirstHalf") && eDateStatus != "" && weekOff != 1) {
                                days = days - (float) 1;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 2 && eDateStatus.contains("Fullday") && weekOff != 1 && weekOff != 7) {
                                days = days - (float) 0.5;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 2 && sDateStatus.contains("Fullday")) {
                                Calendar c12 = Calendar.getInstance();
                                c12.setTime(sDate);
                                c12.add(Calendar.WEEK_OF_YEAR, -1);
                                c12.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
                                int d = c.get(Calendar.MONTH);
                                String fdate = c12.get(Calendar.DATE) + "/" + (d + 1) + "/" + c12.get(Calendar.YEAR);
                                Boolean empPreviousLeavebal = leaveEmployeeDetailService.readPreviousLeaveFriday(fdate, employeeMaster1.getId());
                                if (empPreviousLeavebal) {
                                    days++;
                                }
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 3 && sDateStatus.contains("Fullday")) {
                                Calendar c123 = Calendar.getInstance();
                                c123.setTime(sDate);
                                c123.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
                                int d1 = c.get(Calendar.MONTH);
                                String fdate1 = c123.get(Calendar.DATE) + "/" + (d1 + 1) + "/" + c123.get(Calendar.YEAR);
                                List list12 = holidayMasterService.checkHoliday(fdate1, "" + employeeMaster1.getLocationMaster().getId());
                                if (list12.size() == 1) {
                                    Calendar c12 = Calendar.getInstance();
                                    c12.setTime(sDate);
                                    c12.add(Calendar.WEEK_OF_YEAR, -1);
                                    c12.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
                                    int d = c.get(Calendar.MONTH);
                                    String fdate = c12.get(Calendar.DATE) + "/" + (d + 1) + "/" + c12.get(Calendar.YEAR);
                                    Boolean empPreviousLeavebal = leaveEmployeeDetailService.readPreviousLeaveFriday(fdate, employeeMaster1.getId());
                                    if (empPreviousLeavebal) {
                                        days++;
                                    }
                                    break;
                                }
                                break;
                            }
                        }

                        coutnter++;
                    }
                } //-------------------Code for Saturday & Sunday List Check Ends Here-------------
                //-------------------Code for Sunday & Monday Starts Here-------------
                else if (sm.format(dt1).equals("Sunday") && sm.format(dt2).equals("Monday")) {
                    for (String z : weekOffDay.split(",")) {
                        int weekOff = 0;
                        if (!z.equals("")) {
                            if (z.equals("Sunday")) {
                                weekOff = 1;
                                sundayCheck = true;
                            } else if (z.equals("Monday")) {
                                weekOff = 2;
                            } else if (z.equals("Tuesday")) {
                                weekOff = 3;
                            } else if (z.equals("Wednesday")) {
                                weekOff = 4;
                            } else if (z.equals("Thursday")) {
                                weekOff = 5;
                            } else if (z.equals("Friday")) {
                                weekOff = 6;
                            } else if (z.equals("Saturday")) {
                                weekOff = 7;
                            }
                        }
                        if (c.get(Calendar.DAY_OF_WEEK) != weekOff) {
                            if (c.get(Calendar.DAY_OF_WEEK) == 7 && coutnter == 0) {
                                if (sDateStatus.contains("SecondHalf")) {
                                    if (!strDate.equals(enDate)) {
                                        days--;
                                    }
                                }
                            }
                        }
                        if (!leavetype.equals("6") && !leavetype.equals("7") && !leavetype.equals("16") && !leavetype.equals("12")) {
                            if (c.get(Calendar.DAY_OF_WEEK) == 7 && !sDateStatus.contains("SecondHalf")) {
                                if (!strDate.equals(enDate)) {
                                    days--;
                                }
                            }
                        }
                        if (leavetype.equals("7")) {
                            if (c.get(Calendar.DAY_OF_WEEK) == weekOff && c.get(Calendar.DAY_OF_WEEK) != 2) {
                                days--;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 7 && sDateStatus.contains("SecondHalf") && eDateStatus != "" && weekOff != 2) {
                                days = days - (float) 1;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 7 && sDateStatus.contains("FirstHalf") && eDateStatus != "" && weekOff != 2) {
                                days = days - (float) 1;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 3 && eDateStatus.contains("Fullday") && weekOff != 1 && weekOff != 2) {
                                days = days - (float) 0.5;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 3 && sDateStatus.contains("Fullday")) {
                                Calendar c12 = Calendar.getInstance();
                                c12.setTime(sDate);
                                c12.add(Calendar.WEEK_OF_YEAR, -1);
                                c12.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
                                int d = c.get(Calendar.MONTH);
                                String fdate = c12.get(Calendar.DATE) + "/" + (d + 1) + "/" + c12.get(Calendar.YEAR);
                                Boolean empPreviousLeavebal = leaveEmployeeDetailService.readPreviousLeaveFriday(fdate, employeeMaster1.getId());
                                if (empPreviousLeavebal) {
                                    days++;
                                }
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 4 && sDateStatus.contains("Fullday")) {
                                Calendar c123 = Calendar.getInstance();
                                c123.setTime(sDate);
                                c123.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
                                int d1 = c.get(Calendar.MONTH);
                                String fdate1 = c123.get(Calendar.DATE) + "/" + (d1 + 1) + "/" + c123.get(Calendar.YEAR);
                                List list12 = holidayMasterService.checkHoliday(fdate1, "" + employeeMaster1.getLocationMaster().getId());
                                if (list12.size() == 1) {
                                    Calendar c12 = Calendar.getInstance();
                                    c12.setTime(sDate);
                                    c12.add(Calendar.WEEK_OF_YEAR, -1);
                                    c12.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
                                    int d = c.get(Calendar.MONTH);
                                    String fdate = c12.get(Calendar.DATE) + "/" + (d + 1) + "/" + c12.get(Calendar.YEAR);
                                    Boolean empPreviousLeavebal = leaveEmployeeDetailService.readPreviousLeaveFriday(fdate, employeeMaster1.getId());
                                    if (empPreviousLeavebal) {
                                        days++;
                                    }
                                    break;
                                }
                                break;
                            }
                        }

                        coutnter++;
                    }
                } //-------------------Code for Sunday & Monday List Check Ends Here-------------
                //-------------------Code for Monday & Tuesday Starts Here-------------
                else if (sm.format(dt1).equals("Monday") && sm.format(dt2).equals("Tuesday")) {
                    for (String z : weekOffDay.split(",")) {
                        int weekOff = 0;
                        if (!z.equals("")) {
                            if (z.equals("Sunday")) {
                                weekOff = 1;
                                sundayCheck = true;
                            } else if (z.equals("Monday")) {
                                weekOff = 2;
                            } else if (z.equals("Tuesday")) {
                                weekOff = 3;
                            } else if (z.equals("Wednesday")) {
                                weekOff = 4;
                            } else if (z.equals("Thursday")) {
                                weekOff = 5;
                            } else if (z.equals("Friday")) {
                                weekOff = 6;
                            } else if (z.equals("Saturday")) {
                                weekOff = 7;
                            }
                        }
                        if (c.get(Calendar.DAY_OF_WEEK) != weekOff) {
                            if (c.get(Calendar.DAY_OF_WEEK) == 7 && coutnter == 0) {
                                if (sDateStatus.contains("SecondHalf")) {
                                    if (!strDate.equals(enDate)) {
                                        days--;
                                    }
                                }
                            }
                        }
                        if (!leavetype.equals("6") && !leavetype.equals("7") && !leavetype.equals("16") && !leavetype.equals("12")) {
                            if (c.get(Calendar.DAY_OF_WEEK) == 7 && !sDateStatus.contains("SecondHalf")) {
                                if (!strDate.equals(enDate)) {
                                    days--;
                                }
                            }
                        }
                        if (leavetype.equals("7")) {
                            if (c.get(Calendar.DAY_OF_WEEK) == weekOff && c.get(Calendar.DAY_OF_WEEK) != 3) {
                                days--;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 1 && sDateStatus.contains("SecondHalf") && eDateStatus != "" && weekOff != 3) {
                                days = days - (float) 1;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 1 && sDateStatus.contains("FirstHalf") && eDateStatus != "" && weekOff != 3) {
                                days = days - (float) 1;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 4 && eDateStatus.contains("Fullday") && weekOff != 2 && weekOff != 3) {
                                days = days - (float) 0.5;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 4 && sDateStatus.contains("Fullday")) {
                                Calendar c12 = Calendar.getInstance();
                                c12.setTime(sDate);
                                c12.add(Calendar.WEEK_OF_YEAR, -1);
                                c12.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
                                int d = c.get(Calendar.MONTH);
                                String fdate = c12.get(Calendar.DATE) + "/" + (d + 1) + "/" + c12.get(Calendar.YEAR);
                                Boolean empPreviousLeavebal = leaveEmployeeDetailService.readPreviousLeaveFriday(fdate, employeeMaster1.getId());
                                if (empPreviousLeavebal) {
                                    days++;
                                }
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 5 && sDateStatus.contains("Fullday")) {
                                Calendar c123 = Calendar.getInstance();
                                c123.setTime(sDate);
                                c123.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
                                int d1 = c.get(Calendar.MONTH);
                                String fdate1 = c123.get(Calendar.DATE) + "/" + (d1 + 1) + "/" + c123.get(Calendar.YEAR);
                                List list12 = holidayMasterService.checkHoliday(fdate1, "" + employeeMaster1.getLocationMaster().getId());
                                if (list12.size() == 1) {
                                    Calendar c12 = Calendar.getInstance();
                                    c12.setTime(sDate);
                                    c12.add(Calendar.WEEK_OF_YEAR, -1);
                                    c12.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
                                    int d = c.get(Calendar.MONTH);
                                    String fdate = c12.get(Calendar.DATE) + "/" + (d + 1) + "/" + c12.get(Calendar.YEAR);
                                    Boolean empPreviousLeavebal = leaveEmployeeDetailService.readPreviousLeaveFriday(fdate, employeeMaster1.getId());
                                    if (empPreviousLeavebal) {
                                        days++;
                                    }
                                    break;
                                }
                                break;
                            }
                        }

                        coutnter++;
                    }
                } //-------------------Code for Monday & Tuesday List Check Ends Here-------------
                //-------------------Code for Tuesday & Wednesday Starts Here-------------
                else if (sm.format(dt1).equals("Tuesday") && sm.format(dt2).equals("Wednesday")) {
                    for (String z : weekOffDay.split(",")) {
                        int weekOff = 0;
                        if (!z.equals("")) {
                            if (z.equals("Sunday")) {
                                weekOff = 1;
                                sundayCheck = true;
                            } else if (z.equals("Monday")) {
                                weekOff = 2;
                            } else if (z.equals("Tuesday")) {
                                weekOff = 3;
                            } else if (z.equals("Wednesday")) {
                                weekOff = 4;
                            } else if (z.equals("Thursday")) {
                                weekOff = 5;
                            } else if (z.equals("Friday")) {
                                weekOff = 6;
                            } else if (z.equals("Saturday")) {
                                weekOff = 7;
                            }
                        }
                        if (c.get(Calendar.DAY_OF_WEEK) != weekOff) {
                            if (c.get(Calendar.DAY_OF_WEEK) == 7 && coutnter == 0) {
                                if (sDateStatus.contains("SecondHalf")) {
                                    if (!strDate.equals(enDate)) {
                                        days--;
                                    }
                                }
                            }
                        }
                        if (!leavetype.equals("6") && !leavetype.equals("7") && !leavetype.equals("16") && !leavetype.equals("12")) {
                            if (c.get(Calendar.DAY_OF_WEEK) == 7 && !sDateStatus.contains("SecondHalf")) {
                                if (!strDate.equals(enDate)) {
                                    days--;
                                }
                            }
                        }
                        if (leavetype.equals("7")) {
                            if (c.get(Calendar.DAY_OF_WEEK) == weekOff && c.get(Calendar.DAY_OF_WEEK) != 4) {
                                days--;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 2 && sDateStatus.contains("SecondHalf") && eDateStatus != "" && weekOff != 4) {
                                days = days - (float) 1;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 2 && sDateStatus.contains("FirstHalf") && eDateStatus != "" && weekOff != 4) {
                                days = days - (float) 1;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 5 && eDateStatus.contains("Fullday") && weekOff != 3 && weekOff != 4) {
                                days = days - (float) 0.5;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 5 && sDateStatus.contains("Fullday")) {
                                Calendar c12 = Calendar.getInstance();
                                c12.setTime(sDate);
                                c12.add(Calendar.WEEK_OF_YEAR, -1);
                                c12.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
                                int d = c.get(Calendar.MONTH);
                                String fdate = c12.get(Calendar.DATE) + "/" + (d + 1) + "/" + c12.get(Calendar.YEAR);
                                Boolean empPreviousLeavebal = leaveEmployeeDetailService.readPreviousLeaveFriday(fdate, employeeMaster1.getId());
                                if (empPreviousLeavebal) {
                                    days++;
                                }
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 6 && sDateStatus.contains("Fullday")) {
                                Calendar c123 = Calendar.getInstance();
                                c123.setTime(sDate);
                                c123.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
                                int d1 = c.get(Calendar.MONTH);
                                String fdate1 = c123.get(Calendar.DATE) + "/" + (d1 + 1) + "/" + c123.get(Calendar.YEAR);
                                List list12 = holidayMasterService.checkHoliday(fdate1, "" + employeeMaster1.getLocationMaster().getId());
                                if (list12.size() == 1) {
                                    Calendar c12 = Calendar.getInstance();
                                    c12.setTime(sDate);
                                    c12.add(Calendar.WEEK_OF_YEAR, -1);
                                    c12.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
                                    int d = c.get(Calendar.MONTH);
                                    String fdate = c12.get(Calendar.DATE) + "/" + (d + 1) + "/" + c12.get(Calendar.YEAR);
                                    Boolean empPreviousLeavebal = leaveEmployeeDetailService.readPreviousLeaveFriday(fdate, employeeMaster1.getId());
                                    if (empPreviousLeavebal) {
                                        days++;
                                    }
                                    break;
                                }
                                break;
                            }
                        }

                        coutnter++;
                    }
                } //-------------------Code for Tuesday & Wednesday List Check Ends Here-------------
                //-------------------Code for Wednesday & Thursday Starts Here-------------
                else if (sm.format(dt1).equals("Wednesday") && sm.format(dt2).equals("Thursday")) {
                    for (String z : weekOffDay.split(",")) {
                        int weekOff = 0;
                        if (!z.equals("")) {
                            if (z.equals("Sunday")) {
                                weekOff = 1;
                                sundayCheck = true;
                            } else if (z.equals("Monday")) {
                                weekOff = 2;
                            } else if (z.equals("Tuesday")) {
                                weekOff = 3;
                            } else if (z.equals("Wednesday")) {
                                weekOff = 4;
                            } else if (z.equals("Thursday")) {
                                weekOff = 5;
                            } else if (z.equals("Friday")) {
                                weekOff = 6;
                            } else if (z.equals("Saturday")) {
                                weekOff = 7;
                            }
                        }
                        if (c.get(Calendar.DAY_OF_WEEK) != weekOff) {
                            if (c.get(Calendar.DAY_OF_WEEK) == 7 && coutnter == 0) {
                                if (sDateStatus.contains("SecondHalf")) {
                                    if (!strDate.equals(enDate)) {
                                        days--;
                                    }
                                }
                            }
                        }
                        if (!leavetype.equals("6") && !leavetype.equals("7") && !leavetype.equals("16") && !leavetype.equals("12")) {
                            if (c.get(Calendar.DAY_OF_WEEK) == 7 && !sDateStatus.contains("SecondHalf")) {
                                if (!strDate.equals(enDate)) {
                                    days--;
                                }
                            }
                        }
                        if (leavetype.equals("7")) {
                            if (c.get(Calendar.DAY_OF_WEEK) == weekOff && c.get(Calendar.DAY_OF_WEEK) != 5) {
                                days--;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 3 && sDateStatus.contains("SecondHalf") && eDateStatus != "" && weekOff != 5) {
                                days = days - (float) 1;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 3 && sDateStatus.contains("FirstHalf") && eDateStatus != "" && weekOff != 5) {
                                days = days - (float) 1;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 6 && eDateStatus.contains("Fullday") && weekOff != 4 && weekOff != 5) {
                                days = days - (float) 0.5;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 6 && sDateStatus.contains("Fullday")) {
                                Calendar c12 = Calendar.getInstance();
                                c12.setTime(sDate);
                                c12.add(Calendar.WEEK_OF_YEAR, -1);
                                c12.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
                                int d = c.get(Calendar.MONTH);
                                String fdate = c12.get(Calendar.DATE) + "/" + (d + 1) + "/" + c12.get(Calendar.YEAR);
                                Boolean empPreviousLeavebal = leaveEmployeeDetailService.readPreviousLeaveFriday(fdate, employeeMaster1.getId());
                                if (empPreviousLeavebal) {
                                    days++;
                                }
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 7 && sDateStatus.contains("Fullday")) {
                                Calendar c123 = Calendar.getInstance();
                                c123.setTime(sDate);
                                c123.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
                                int d1 = c.get(Calendar.MONTH);
                                String fdate1 = c123.get(Calendar.DATE) + "/" + (d1 + 1) + "/" + c123.get(Calendar.YEAR);
                                List list12 = holidayMasterService.checkHoliday(fdate1, "" + employeeMaster1.getLocationMaster().getId());
                                if (list12.size() == 1) {
                                    Calendar c12 = Calendar.getInstance();
                                    c12.setTime(sDate);
                                    c12.add(Calendar.WEEK_OF_YEAR, -1);
                                    c12.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
                                    int d = c.get(Calendar.MONTH);
                                    String fdate = c12.get(Calendar.DATE) + "/" + (d + 1) + "/" + c12.get(Calendar.YEAR);
                                    Boolean empPreviousLeavebal = leaveEmployeeDetailService.readPreviousLeaveFriday(fdate, employeeMaster1.getId());
                                    if (empPreviousLeavebal) {
                                        days++;
                                    }
                                    break;
                                }
                                break;
                            }
                        }

                        coutnter++;
                    }
                } //-------------------Code for Wednesday & Thursday List Check Ends Here-------------
                //-------------------Code for Thursday & Friday Starts Here-------------
                else if (sm.format(dt1).equals("Thursday") && sm.format(dt2).equals("Friday")) {
                    for (String z : weekOffDay.split(",")) {
                        int weekOff = 0;
                        if (!z.equals("")) {
                            if (z.equals("Sunday")) {
                                weekOff = 1;
                                sundayCheck = true;
                            } else if (z.equals("Monday")) {
                                weekOff = 2;
                            } else if (z.equals("Tuesday")) {
                                weekOff = 3;
                            } else if (z.equals("Wednesday")) {
                                weekOff = 4;
                            } else if (z.equals("Thursday")) {
                                weekOff = 5;
                            } else if (z.equals("Friday")) {
                                weekOff = 6;
                            } else if (z.equals("Saturday")) {
                                weekOff = 7;
                            }
                        }
                        if (c.get(Calendar.DAY_OF_WEEK) != weekOff) {
                            if (c.get(Calendar.DAY_OF_WEEK) == 7 && coutnter == 0) {
                                if (sDateStatus.contains("SecondHalf")) {
                                    if (!strDate.equals(enDate)) {
                                        days--;
                                    }
                                }
                            }
                        }
                        if (!leavetype.equals("6") && !leavetype.equals("7") && !leavetype.equals("16") && !leavetype.equals("12")) {
                            if (c.get(Calendar.DAY_OF_WEEK) == 7 && !sDateStatus.contains("SecondHalf")) {
                                if (!strDate.equals(enDate)) {
                                    days--;
                                }
                            }
                        }
                        if (leavetype.equals("7")) {
                            if (c.get(Calendar.DAY_OF_WEEK) == weekOff && c.get(Calendar.DAY_OF_WEEK) != 6) {
                                days--;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 4 && sDateStatus.contains("SecondHalf") && eDateStatus != "" && weekOff != 6) {
                                days = days - (float) 1;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 4 && sDateStatus.contains("FirstHalf") && eDateStatus != "" && weekOff != 6) {
                                days = days - (float) 1;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 7 && eDateStatus.contains("Fullday") && weekOff != 5 && weekOff != 6) {
                                days = days - (float) 0.5;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 7 && sDateStatus.contains("Fullday")) {
                                Calendar c12 = Calendar.getInstance();
                                c12.setTime(sDate);
                                c12.add(Calendar.WEEK_OF_YEAR, -1);
                                c12.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
                                int d = c.get(Calendar.MONTH);
                                String fdate = c12.get(Calendar.DATE) + "/" + (d + 1) + "/" + c12.get(Calendar.YEAR);
                                Boolean empPreviousLeavebal = leaveEmployeeDetailService.readPreviousLeaveFriday(fdate, employeeMaster1.getId());
                                if (empPreviousLeavebal) {
                                    days++;
                                }
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 1 && sDateStatus.contains("Fullday")) {
                                Calendar c123 = Calendar.getInstance();
                                c123.setTime(sDate);
                                c123.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
                                int d1 = c.get(Calendar.MONTH);
                                String fdate1 = c123.get(Calendar.DATE) + "/" + (d1 + 1) + "/" + c123.get(Calendar.YEAR);
                                List list12 = holidayMasterService.checkHoliday(fdate1, "" + employeeMaster1.getLocationMaster().getId());
                                if (list12.size() == 1) {
                                    Calendar c12 = Calendar.getInstance();
                                    c12.setTime(sDate);
                                    c12.add(Calendar.WEEK_OF_YEAR, -1);
                                    c12.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
                                    int d = c.get(Calendar.MONTH);
                                    String fdate = c12.get(Calendar.DATE) + "/" + (d + 1) + "/" + c12.get(Calendar.YEAR);
                                    Boolean empPreviousLeavebal = leaveEmployeeDetailService.readPreviousLeaveFriday(fdate, employeeMaster1.getId());
                                    if (empPreviousLeavebal) {
                                        days++;
                                    }
                                    break;
                                }
                                break;
                            }
                        }

                        coutnter++;
                    }
                } //-------------------Code for Thursday & Friday  Ends Here-------------
                //-------------------Code for Friday & Saturday Starts Here-------------
                else if (sm.format(dt1).equals("Friday") && sm.format(dt2).equals("Saturday")) {
                    for (String z : weekOffDay.split(",")) {
                        int weekOff = 0;
                        if (!z.equals("")) {
                            if (z.equals("Sunday")) {
                                weekOff = 1;
                                sundayCheck = true;
                            } else if (z.equals("Monday")) {
                                weekOff = 2;
                            } else if (z.equals("Tuesday")) {
                                weekOff = 3;
                            } else if (z.equals("Wednesday")) {
                                weekOff = 4;
                            } else if (z.equals("Thursday")) {
                                weekOff = 5;
                            } else if (z.equals("Friday")) {
                                weekOff = 6;
                            } else if (z.equals("Saturday")) {
                                weekOff = 7;
                            }
                        }
                        if (c.get(Calendar.DAY_OF_WEEK) != weekOff) {
                            if (c.get(Calendar.DAY_OF_WEEK) == 7 && coutnter == 0) {
                                if (sDateStatus.contains("SecondHalf")) {
                                    if (!strDate.equals(enDate)) {
                                        days--;
                                    }
                                }
                            }
                        }
                        if (!leavetype.equals("6") && !leavetype.equals("7") && !leavetype.equals("16") && !leavetype.equals("12")) {
                            if (c.get(Calendar.DAY_OF_WEEK) == 7 && !sDateStatus.contains("SecondHalf")) {
                                if (!strDate.equals(enDate)) {
                                    days--;
                                }
                            }
                        }
                        if (leavetype.equals("7")) {
                            if (c.get(Calendar.DAY_OF_WEEK) == weekOff && c.get(Calendar.DAY_OF_WEEK) != 7) {
                                days--;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 5 && sDateStatus.contains("SecondHalf") && eDateStatus != "" && weekOff != 7) {
                                days = days - (float) 1;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 5 && sDateStatus.contains("FirstHalf") && eDateStatus != "" && weekOff != 7) {
                                days = days - (float) 1;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 1 && eDateStatus.contains("Fullday") && weekOff != 6 && weekOff != 7) {
                                days = days - (float) 0.5;
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 1 && sDateStatus.contains("Fullday")) {
                                Calendar c12 = Calendar.getInstance();
                                c12.setTime(sDate);
                                c12.add(Calendar.WEEK_OF_YEAR, -1);
                                c12.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
                                int d = c.get(Calendar.MONTH);
                                String fdate = c12.get(Calendar.DATE) + "/" + (d + 1) + "/" + c12.get(Calendar.YEAR);
                                Boolean empPreviousLeavebal = leaveEmployeeDetailService.readPreviousLeaveFriday(fdate, employeeMaster1.getId());
                                if (empPreviousLeavebal) {
                                    days++;
                                }
                                break;
                            }
                            if (c.get(Calendar.DAY_OF_WEEK) == 2 && sDateStatus.contains("Fullday")) {
                                Calendar c123 = Calendar.getInstance();
                                c123.setTime(sDate);
                                c123.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
                                int d1 = c.get(Calendar.MONTH);
                                String fdate1 = c123.get(Calendar.DATE) + "/" + (d1 + 1) + "/" + c123.get(Calendar.YEAR);
                                List list12 = holidayMasterService.checkHoliday(fdate1, "" + employeeMaster1.getLocationMaster().getId());
                                if (list12.size() == 1) {
                                    Calendar c12 = Calendar.getInstance();
                                    c12.setTime(sDate);
                                    c12.add(Calendar.WEEK_OF_YEAR, -1);
                                    c12.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
                                    int d = c.get(Calendar.MONTH);
                                    String fdate = c12.get(Calendar.DATE) + "/" + (d + 1) + "/" + c12.get(Calendar.YEAR);
                                    Boolean empPreviousLeavebal = leaveEmployeeDetailService.readPreviousLeaveFriday(fdate, employeeMaster1.getId());
                                    if (empPreviousLeavebal) {
                                        days++;
                                    }
                                    break;
                                }
                                break;
                            }
                        }

                        coutnter++;
                    }
                }
                //-------------------Code for Friday & Saturday  Ends Here-------------
                c.add(Calendar.DATE, 1);

            }
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
                int empId = employeeLeaveBalance.getEmployeeMaster().getId();
                EmployeeMaster employeeMaster1 = employeeMasterService.readById(empId);
                int locationId = employeeMaster1.getZydexLocationMaster().getId();
                if (locationId == 1 || locationId == 6) {
                    employeeLeaveBalance.setNoOfLeaveRemain(1);
                } else {
                    employeeLeaveBalance.setNoOfLeaveRemain(3);
                }
                employeeLeaveBalanceService.update(employeeLeaveBalance);
//            System.out.println("Ajay");
            }
        } else {
            EmployeeMaster employeeMaster1 = new EmployeeMaster();
            List<?> empList = employeeMasterService.read();
            for (Object oo : empList) {
                employeeMaster1 = (EmployeeMaster) oo;
                int locationId = employeeMaster1.getZydexLocationMaster().getId();
                if (locationId == 1 || locationId == 6) {
                    employeeLeaveBalance.setNoOfLeaveRemain(1);
                } else {
                    employeeLeaveBalance.setNoOfLeaveRemain(3);
                }
                employeeLeaveBalance.setEmployeeMaster(employeeMaster1);
                employeeLeaveBalance.setLeaveTypeMaster(leaveTypeMaster);
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
//        if (!weekOffDay.equals("sunday")) {

        for (String z : weekOffDay.split(",")) {
            int weekOff = 0;
            if (!z.equals("")) {
//                if (z.equals("sunday")) {
//                    weekOff = 1;
//                } else 
                if (z.equals("monday")) {
                    weekOff = 2;
                } else if (z.equals("tuesday")) {
                    weekOff = 3;
                } else if (z.equals("wednesday")) {
                    weekOff = 4;
                } else if (z.equals("thursday")) {
                    weekOff = 5;
                } else if (z.equals("friday")) {
                    weekOff = 6;
                } else if (z.equals("saturday")) {
                    weekOff = 7;
                }
                Date nDate = c.getTime();
                String daString = sdf.format(nDate);
                HolidayMaster holidayMaster = new HolidayMaster();
                holidayMaster.setHolidayFromDate(daString);
//                List list = holidayMasterService.checkHoliday(strDate, "" + employeeMaster1.getLocationMaster().getId());

//                if (c.get(Calendar.DAY_OF_WEEK) == weekOff || list.size() > 0) {
//                    message = "Selected Date is Holiday/WeekOff.So You can't Apply Leave on this Day.";
//                }
            }
        }
//        }
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
//                if (z.equals("sunday")) {
//                    weekOff = 1;
//                } else 
                if (z.equals("monday")) {
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
//                List list = holidayMasterService.checkHoliday(enDate, "" + employeeMaster1.getLocationMaster().getId());

//                if (c.get(Calendar.DAY_OF_WEEK) == weekOff || list.size() > 0) {
//                    message = "Selected Date is Holiday/WeekOff.So You can't Apply Leave on this Day.";
//                }
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
            EmployeeShiftData employeeShiftData1 = new EmployeeShiftData();
            if (!list.isEmpty()) {
                employeeShiftData1 = (EmployeeShiftData) list.get(0);

                String sDate = employeeShiftData1.getInDateTime();
                String eDate = employeeShiftData1.getOutDateTime();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

                Date iDate = sdf.parse(sDate);
                Date oDate = sdf.parse(eDate);
                long diff = oDate.getTime() - iDate.getTime();

                long diffHours = diff / (60 * 60 * 1000) % 24;

//                if (list.size() > 0 && employeeShiftData1.getShiftMaster().getId() != 5) {
                if (diffHours > 4 && employeeShiftData1.getShiftMaster().getId() != 5) {
                    message = "On This Day You Are Present";
                }
            }
        }
//        if (sDateStatus.equals("FirstHalf")) {
//            employeeShiftData.setOutDateTime(strDate);
//            employeeShiftData.setEmployeeMaster(employeeMaster1);
//            List<?> list = employeeShiftDataService.checkTodayFirstHalfDayPresent(employeeShiftData);
//            EmployeeShiftData employeeShiftData1 = new EmployeeShiftData();
//            if (!list.isEmpty()) {
//                employeeShiftData1 = (EmployeeShiftData) list.get(0);
//                if (list.size() > 0 && employeeShiftData1.getShiftMaster().getId() != 5) {
//                    message = "On This Day You Are Present";
//                }
//            }
//        }
//        if (sDateStatus.equals("SecondHalf")) {
//            employeeShiftData.setOutDateTime(strDate);
//            employeeShiftData.setEmployeeMaster(employeeMaster1);
//            List<?> list = employeeShiftDataService.checkTodaySecondHalfDayPresent(employeeShiftData);
//            EmployeeShiftData employeeShiftData1 = new EmployeeShiftData();
//            if (!list.isEmpty()) {
//                employeeShiftData1 = (EmployeeShiftData) list.get(0);
//                if (list.size() > 0 && employeeShiftData1.getShiftMaster().getId() != 5) {
//                    message = "On This Day You Are Present";
//                }
//            }
//        }

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
            EmployeeShiftData employeeShiftData1 = new EmployeeShiftData();
            if (!list.isEmpty()) {
                employeeShiftData1 = (EmployeeShiftData) list.get(0);

                String sDate = employeeShiftData1.getInDateTime();
                String eDate = employeeShiftData1.getOutDateTime();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

                Date iDate = sdf.parse(sDate);
                Date oDate = sdf.parse(eDate);
                long diff = oDate.getTime() - iDate.getTime();

                long diffHours = diff / (60 * 60 * 1000) % 24;

//                if (list.size() > 0 && employeeShiftData1.getShiftMaster().getId() != 5) {
                if (diffHours > 4 && employeeShiftData1.getShiftMaster().getId() != 5) {
                    message = "On This Day You Are Present";
                }
            }
        }
//        if (eDateStatus.equals("FirstHalf")) {
//            employeeShiftData.setOutDateTime(enDate);
//            employeeShiftData.setEmployeeMaster(employeeMaster1);
//            List<?> list = employeeShiftDataService.checkTodayFirstHalfDayPresent(employeeShiftData);
//            EmployeeShiftData employeeShiftData1 = new EmployeeShiftData();
//            if (!list.isEmpty()) {
//                employeeShiftData1 = (EmployeeShiftData) list.get(0);
//                if (list.size() > 0 && employeeShiftData1.getShiftMaster().getId() != 5) {
//                    message = "On This Day You Are Present";
//                }
//            }
//        }
//        if (eDateStatus.equals("SecondHalf")) {
//            employeeShiftData.setOutDateTime(enDate);
//            employeeShiftData.setEmployeeMaster(employeeMaster1);
//            List<?> list = employeeShiftDataService.checkTodaySecondHalfDayPresent(employeeShiftData);
//            EmployeeShiftData employeeShiftData1 = new EmployeeShiftData();
//            if (!list.isEmpty()) {
//                employeeShiftData1 = (EmployeeShiftData) list.get(0);
//                if (list.size() > 0 && employeeShiftData1.getShiftMaster().getId() != 5) {
//                    message = "On This Day You Are Present";
//                }
//            }
//        }

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
        Map<String, Float> listRemain = new LinkedHashMap<>();
        Map<String, Float> empReqMap = new LinkedHashMap<>();
        Map<String, Float> totalDaysMap = new LinkedHashMap<>();
        LeaveTypeMaster leaveTypeMaster = new LeaveTypeMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        EmployeeMaster employeeMaster2 = new EmployeeMaster();
        EmployeeLeaveBalance employeeLeaveBalance = new EmployeeLeaveBalance();

        String empId = request.getParameter("employeeMasterId");
        if (empId != "") {
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
        } else {
            request.setAttribute("failureMessage",
                    "Information: Select Employee ");
            mv = employeeLeaveApplication(request, response);
        }

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
                            SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                            String currentDate = dateFormat1.format(new Date());
                            leaveEmployeeDetail.setDateOfSubmit(currentDate);
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
                            SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                            String currentDate = dateFormat1.format(new Date());
                            leaveEmployeeDetail.setDateOfSubmit(currentDate);
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
                        SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                        String currentDate = dateFormat1.format(new Date());
                        leaveEmployeeDetail.setDateOfSubmit(currentDate);
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
        String active = request.getParameter("active");
        String inactive = request.getParameter("inactive");
        if (null == inactive) {
            inactive = "";
        }
        if (null == active) {
            active = "";
        }
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
        List<?> empList = new ArrayList<>();
        if (active.equals("on") && inactive.equals("on")) {
            empList = employeeMasterService.readEmployeeForLeaveBalance(employeeMaster);
        } else if (active.equals("on") && inactive.equals("")) {
            empList = employeeMasterService.readEmployeeForLeaveBalanceForActiveUser(employeeMaster);
        } else if (active.equals("") && inactive.equals("on")) {
            empList = employeeMasterService.readEmployeeForLeaveBalanceForInActiveUser(employeeMaster);
        }

        Iterator itr = empList.iterator();
        while (itr.hasNext()) {
            LeaveTypeMaster leaveTypeMaster = new LeaveTypeMaster();
            LeaveTypeMaster leaveTypeMaster1 = new LeaveTypeMaster();
            LeaveTypeMaster leaveTypeMaster2 = new LeaveTypeMaster();
            LeaveTypeMaster leaveTypeMaster3 = new LeaveTypeMaster();
            LeaveTypeMaster leaveTypeMaster4 = new LeaveTypeMaster();
            LeaveTypeMaster leaveTypeMaster5 = new LeaveTypeMaster();
            EmployeeLeaveBalance employeeLeaveBalance = new EmployeeLeaveBalance();
            EmployeeLeaveBalance employeeLeaveBalance1 = new EmployeeLeaveBalance();
            EmployeeLeaveBalance employeeLeaveBalance2 = new EmployeeLeaveBalance();
            EmployeeLeaveBalance employeeLeaveBalance3 = new EmployeeLeaveBalance();
            EmployeeLeaveBalance employeeLeaveBalance4 = new EmployeeLeaveBalance();
            EmployeeLeaveBalance employeeLeaveBalance5 = new EmployeeLeaveBalance();
            try {
                String clId = "";
                String slId = "";
                String plId = "";
                String pTlId = "";
                String srtlId = "";
                String coffId = "";

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
                    clId = "" + leaveTypeMaster.getId();
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
                if (!leaveTypeList1.isEmpty()) {
                    leaveTypeMaster1 = (LeaveTypeMaster) leaveTypeList1.get(0);
                    slId = "" + leaveTypeMaster1.getId();
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
                if (!leaveTypeList2.isEmpty()) {
                    leaveTypeMaster2 = (LeaveTypeMaster) leaveTypeList2.get(0);
                    plId = "" + leaveTypeMaster2.getId();
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
                if (!leaveTypeList3.isEmpty()) {
                    leaveTypeMaster3 = (LeaveTypeMaster) leaveTypeList3.get(0);
                    pTlId = "" + leaveTypeMaster3.getId();
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
//                Short Leave
                List leaveTypeList4 = leaveTypeMasterService.readLeaveType("Short Leave");
                if (!leaveTypeList4.isEmpty()) {
                    leaveTypeMaster4 = (LeaveTypeMaster) leaveTypeList4.get(0);
                    srtlId = "" + leaveTypeMaster4.getId();
                }
                employeeLeaveBalance4.setEmployeeMaster(employeeMaster);
                employeeLeaveBalance4.setLeaveTypeMaster(leaveTypeMaster4);
                List balanceList4 = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance4);
                if (!balanceList4.isEmpty()) {
                    employeeLeaveBalance4 = (EmployeeLeaveBalance) balanceList4.get(0);
                    empInfoList.add("" + employeeLeaveBalance4.getNoOfLeaveRemain());
                } else {
                    empInfoList.add("");
                }
                //                c.off
                List leaveTypeList5 = leaveTypeMasterService.readLeaveType("Lieu Day Leave");
                if (!leaveTypeList5.isEmpty()) {
                    leaveTypeMaster5 = (LeaveTypeMaster) leaveTypeList5.get(0);
                    coffId = "" + leaveTypeMaster5.getId();
                }
                employeeLeaveBalance5.setEmployeeMaster(employeeMaster);
                employeeLeaveBalance5.setLeaveTypeMaster(leaveTypeMaster5);
                List balanceList5 = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance5);
                if (!balanceList5.isEmpty()) {
                    employeeLeaveBalance5 = (EmployeeLeaveBalance) balanceList5.get(0);
                    empInfoList.add("" + employeeLeaveBalance5.getNoOfLeaveRemain());
                } else {
                    empInfoList.add("");
                }

                String casualLeaveBalId = "" + employeeLeaveBalance.getId();
                String sickLeaveBalId = "" + employeeLeaveBalance1.getId();
                String privilegeLeaveBalId = "" + employeeLeaveBalance2.getId();
                String paternityLeaveBalId = "";
                String shortLeaveBalId = "";
                String coffLeaveBalId = "";
                if (employeeLeaveBalance3.getId() == null) {
                    paternityLeaveBalId = "0";
                } else {
                    paternityLeaveBalId = "" + employeeLeaveBalance3.getId();
                }

                if (employeeLeaveBalance4.getId() == null) {
                    shortLeaveBalId = "0";
                } else {
                    shortLeaveBalId = "" + employeeLeaveBalance4.getId();
                }
                if (employeeLeaveBalance5.getId() == null) {
                    coffLeaveBalId = "0";
                } else {
                    coffLeaveBalId = "" + employeeLeaveBalance5.getId();
                }

                empInfoList.add(clId + "_" + slId + "_" + plId + "_" + pTlId + "_" + srtlId + "_" + coffId);
//                empInfoList.add(casualLeaveBalId + "_" + sickLeaveBalId + "_" + privilegeLeaveBalId + "_" + paternityLeaveBalId + "_" + shortLeaveBalId);

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
        String empId = request.getParameter("empId");
        String leaveTypId = request.getParameter("leaveTypId");
        EmployeeLeaveBalance employeeLeaveBalance = new EmployeeLeaveBalance();
        LeaveTypeMaster leaveTypeMaster = new LeaveTypeMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();

        employeeMaster = employeeMasterService.readById(Integer.parseInt(empId));
        leaveTypeMaster = leaveTypeMasterService.readById(Integer.parseInt(leaveTypId));
        List<EmployeeLeaveBalance> empList = (List<EmployeeLeaveBalance>) employeeLeaveBalanceService.readByEmpIdAndLeaveTypeId(Integer.parseInt(empId), Integer.parseInt(leaveTypId));
        if (!empList.isEmpty()) {

            employeeLeaveBalance = empList.get(0);
        } else {
            employeeLeaveBalance.setEmployeeMaster(employeeMaster);
            employeeLeaveBalance.setLeaveTypeMaster(leaveTypeMaster);
            employeeLeaveBalance.setNoOfLeaveRemain(0);
        }
//        employeeLeaveBalance = employeeLeaveBalanceService.readById(Integer.parseInt(leaveBalId));
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
        String EmpId = request.getParameter("EmpId");
        String leavetypeId = request.getParameter("leavetypeId");
        EmployeeMaster employeeMaster = employeeMasterService.readById(Integer.parseInt(EmpId));
        LeaveTypeMaster leaveTypeMaster = leaveTypeMasterService.readById(Integer.parseInt(leavetypeId));
        EmployeeLeaveBalance employeeLeaveBalance = new EmployeeLeaveBalance();
        if ("" != empLeaveBalId) {

            employeeLeaveBalance = employeeLeaveBalanceService.readById(Integer.parseInt(empLeaveBalId));
            employeeLeaveBalance.setNoOfLeaveRemain(Float.parseFloat(leaveBalance));
            employeeLeaveBalanceService.update(employeeLeaveBalance);
        } else {
            employeeLeaveBalance.setEmployeeMaster(employeeMaster);
            employeeLeaveBalance.setLeaveTypeMaster(leaveTypeMaster);
            employeeLeaveBalance.setNoOfLeaveRemain(Float.parseFloat(leaveBalance));
            employeeLeaveBalanceService.create(employeeLeaveBalance);
        }

        PrintWriter out = response.getWriter();
        out.print("Information : The Information is Updated Successfully. Please hit Resend...");

    }

    public void getSecondSatDayByAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String strDate = request.getParameter("strDate");
        String enDate = request.getParameter("enDate");
        String sDateStatus = request.getParameter("sDateStatus");
        String eDateStatus = request.getParameter("eDateStatus");
//        String leavetype = request.getParameter("leaveType");
        strDate = strDate.replaceAll(",", "/");
        enDate = enDate.replaceAll(",", "/");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date sDate = sdf.parse(strDate);
        Date eDate = sdf.parse(enDate);

        SimpleDateFormat format2 = new SimpleDateFormat("EEEE");
        Calendar calStartLeave = Calendar.getInstance();
        Calendar calEndLeave = Calendar.getInstance();
        Date startDateOfLeave = sdf.parse(strDate);
        Date endDateOfLeave = sdf.parse(enDate);
        calStartLeave.setTime(startDateOfLeave);
        calEndLeave.setTime(endDateOfLeave);

        String startDayNameOfLeave = format2.format(startDateOfLeave);
        String endDayNameOfLeave = format2.format(endDateOfLeave);
        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster1 = (EmployeeMaster) session.getAttribute("employeeInfo");
        int zydexLocId = employeeMaster1.getZydexLocationMaster().getId();
        String message = "";

        if (startDayNameOfLeave.equals("Saturday") && sDate.equals(eDate) && zydexLocId == 1) {
            int dayOfWeek = calStartLeave.get(Calendar.WEEK_OF_MONTH);
            if (dayOfWeek == 2) {
                message = "0";
                //////////// message 0 for set start date status fullday and secondhalf disabled
            }

        } else if (startDayNameOfLeave.equals("Saturday") && !sDate.equals(eDate) && zydexLocId == 1) {
            int dayOfWeek = calStartLeave.get(Calendar.WEEK_OF_MONTH);
            if (dayOfWeek == 2) {
                message = "0";
                //////////// message 0 for set start date status fullday and secondhalf disabled
            }

        } else if (endDayNameOfLeave.equals("Saturday") && !sDate.equals(eDate) && zydexLocId == 1) {
            int dayOfWeek = calEndLeave.get(Calendar.WEEK_OF_MONTH);
            if (dayOfWeek == 2) {
                message = "1";
                //////////// message 1 for set end date status fullday and secondhalf disabled
            }
        } else {
            message = "2";
            //////////// message 2 for set end date status fullday and secondhalf disabled
        }

        PrintWriter out = response.getWriter();
        out.print(message);
    }

    public ModelAndView hremployeeleaveManagement(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
            list = leaveEmployeeDetailService.viewEmpLeaveRequestForHR();
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
        mv.setViewName("Leave/HRLeaveEmployeeManagement");
        return mv;
    }

    public ModelAndView HRapproveRequestAdminClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        LeaveEmployeeDetail leaveEmployeeDetail = new LeaveEmployeeDetail();
        EmployeeLeaveBalance employeeLeaveBalance = new EmployeeLeaveBalance();
        LeaveTypeMaster leaveTypeMaster = new LeaveTypeMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        LeaveEmployeeDetailsApprovalHistory leaveEmployeeDetailsApprovalHistory = new LeaveEmployeeDetailsApprovalHistory();
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
        Date date1 = new Date();
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        String submitDate = sdf1.format(date1);

        List<?> balanceList = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance);
        if (!balanceList.isEmpty()) {
            employeeLeaveBalance = (EmployeeLeaveBalance) balanceList.get(0);
        }

        if (btnSubmit.equals("approve")) {

//            if (leaveEmployeeDetail.getStatus() == 4) {
//                balanceDay = employeeLeaveBalance.getNoOfLeaveRemain();
//                noOfDay = leaveEmployeeDetail.getNoOfDays();
//                balanceDay = balanceDay + noOfDay;
//                employeeLeaveBalance.setNoOfLeaveRemain(balanceDay);
//                employeeLeaveBalanceService.update(employeeLeaveBalance);
//                leaveEmployeeDetail.setStatus(5);
//                Date date = new Date();
//                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//                String approveDate = sdf.format(date);
//                leaveEmployeeDetail.setApproveDate(approveDate);
//                leaveEmployeeDetailService.update(leaveEmployeeDetail);
//                leaveEmployeeDetailsApprovalHistory.setApprovalId(employeeMaster1.getId());
//                leaveEmployeeDetailsApprovalHistory.setApprovalName(employeeMaster1.getEmployeeName());
//                leaveEmployeeDetailsApprovalHistory.setComment(hrRemark);
//                leaveEmployeeDetailsApprovalHistory.setCreatedBy(employeeMaster1.getId());
//                leaveEmployeeDetailsApprovalHistory.setCreatedDate(approveDate);
//                leaveEmployeeDetailsApprovalHistory.setLeaveEmployeeDetail(leaveEmployeeDetail);
//                leaveEmployeeDetailsApprovalHistory.setStatusMessage("Withdraw Approved");
//                leaveEmployeeDetailsApprovalHistory.setStatus(4); //Withdraw Approved
//                leaveEmployeeDetailsApprovalHistoryService.create(leaveEmployeeDetailsApprovalHistory);
//                request.setAttribute("successMessage",
//                        "Information : The Leave is Withdrawn successfully.");//enter approve witdrw template..
//                try {
//                    EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
//                    DesignationMaster designationMaster = new DesignationMaster();
//                    designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
//                    String EmpIdStr = request.getParameter("empid");
//                    EmployeeMaster employeeMaster2 = new EmployeeMaster();
//                    EmailTemplate emailTemplate1 = new EmailTemplate();
//                    // id =11 for approve leave withdraw request...
//                    emailTemplate1 = emailTemplateService.readById(11);
//                    if (null != EmpIdStr && !"".equals(EmpIdStr)) {
//                        int empID = Integer.parseInt(EmpIdStr);
//                        List list = employeeMasterService.readByEmployeeNo(empID);
//                        if (!list.isEmpty()) {
//                            employeeMaster2 = (EmployeeMaster) list.get(0);
//                            String To = employeeMaster2.getOfficeEmailId();
//                            String from = employeeMasterModel.getOfficeEmailId();
//                            String subject = emailTemplate1.getSubject();
//
//                            subject = subject.replaceAll("\\{user\\}", employeeMaster2.getEmployeeName());
//                            String msg = emailTemplate1.getBodytext();
//                            msg = msg.replaceAll("\\{to_user\\}", employeeMaster2.getEmployeeName());
//                            msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
//                            msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
//                            sendMail.sendMail(from, To, subject, msg);
//
//                        }
//                    }
//                } catch (Exception e) {
//                }
//
//            } else {
//                balanceDay = employeeLeaveBalance.getNoOfLeaveRemain();
//                noOfDay = leaveEmployeeDetail.getNoOfDays();
//                if (noOfDay <= balanceDay) {
            int leaveTypeId = leaveEmployeeDetail.getLeaveTypeMaster().getId();
            leaveEmployeeDetail.setStatus(6);
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String approveDate = sdf.format(date);
            leaveEmployeeDetail.setApproveDate(approveDate);
            leaveEmployeeDetailService.update(leaveEmployeeDetail);
            leaveEmployeeDetailsApprovalHistory.setApprovalId(employeeMaster1.getId());
            leaveEmployeeDetailsApprovalHistory.setApprovalName(employeeMaster1.getEmployeeName());
            leaveEmployeeDetailsApprovalHistory.setComment(hrRemark);
            leaveEmployeeDetailsApprovalHistory.setCreatedBy(employeeMaster1.getId());
            leaveEmployeeDetailsApprovalHistory.setCreatedDate(approveDate);
            leaveEmployeeDetailsApprovalHistory.setLeaveEmployeeDetail(leaveEmployeeDetail);
            leaveEmployeeDetailsApprovalHistory.setStatusMessage("Approved By HR");
            leaveEmployeeDetailsApprovalHistory.setStatus(6); //Approved
            leaveEmployeeDetailsApprovalHistoryService.create(leaveEmployeeDetailsApprovalHistory);
            request.setAttribute("successMessage",
                    "Information : The Leave Approved successfully.");
            try {
                String startdate = leaveEmployeeDetail.getStartDate();
                String enddate = leaveEmployeeDetail.getEndDate();
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
                        msg = msg.replaceAll("\\{start_date\\}", startdate);
                        msg = msg.replaceAll("\\{end_date\\}", enddate);
                        msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                        msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                        sendMail.sendMail(from, To, subject, msg);

                        String name = "Leave";
                        EmailAddMaster emailAddMaster = new EmailAddMaster();
                        emailAddMaster.setModuleName(name);
                        emailAddMaster.setDepartmentMaster(employeeMaster2.getDepartmentMaster());
                        List<?> emailSendList = emailAddMasterService.readByName(emailAddMaster);
                        if (!emailSendList.isEmpty()) {
                            EmailAddMaster emailAddMaster1 = (EmailAddMaster) emailSendList.get(0);
                            String emailId = emailAddMaster1.getEmailId();
                            for (String emailId1 : emailId.split(",")) {
                                if (!emailId1.equals("")) {
                                    String To1 = emailId1;
                                    String from1 = employeeMasterModel.getOfficeEmailId();
                                    String subject1 = emailTemplate1.getSubject();
                                    subject1 = subject1.replaceAll("\\{user\\}", employeeMaster2.getEmployeeName());
                                    String msg1 = emailTemplate1.getBodytext();
                                    msg1 = msg1.replaceAll("\\{to_user\\}", employeeMaster2.getEmployeeName());
                                    msg1 = msg1.replaceAll("\\{start_date\\}", startdate);
                                    msg1 = msg1.replaceAll("\\{end_date\\}", enddate);
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
                                    String subject1 = emailTemplate1.getSubject();
                                    subject1 = subject1.replaceAll("\\{user\\}", employeeMaster2.getEmployeeName());
                                    String msg1 = emailTemplate1.getBodytext();
                                    msg1 = msg1.replaceAll("\\{to_user\\}", employeeMaster2.getEmployeeName());
                                    msg1 = msg1.replaceAll("\\{start_date\\}", startdate);
                                    msg1 = msg1.replaceAll("\\{end_date\\}", enddate);
                                    msg1 = msg1.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                                    msg1 = msg1.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                                    sendMail.sendMail(from1, To1, subject1, msg1);
                                }
                            }
                        }

                        List<?> gmOrStateHeadMailSend = employeeMasterService.readForSendMailToAll(employeeMaster2);
                        if (!gmOrStateHeadMailSend.isEmpty()) {

                            Object[] emaillist = (Object[]) gmOrStateHeadMailSend.get(0);
                            for (int i = 0; i <= emaillist.length; i++) {
                                if (null != emaillist[i] && "" != emaillist[i]) {
                                    String emailid = emaillist[i].toString();

                                    String To3 = emailid;
                                    String from3 = employeeMasterModel.getOfficeEmailId();
                                    String subject3 = emailTemplate1.getSubject();

                                    subject3 = subject3.replaceAll("\\{user\\}", employeeMaster2.getEmployeeName());
                                    String msg3 = emailTemplate1.getBodytext();
                                    msg3 = msg3.replaceAll("\\{to_user\\}", employeeMaster2.getEmployeeName());
                                    msg3 = msg3.replaceAll("\\{start_date\\}", startdate);
                                    msg3 = msg3.replaceAll("\\{end_date\\}", enddate);
                                    msg3 = msg3.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                                    msg3 = msg3.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                                    sendMail.sendMail(from3, To3, subject3, msg3);
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
            }

//                } else {
//                    request.setAttribute("failureMessage",
//                            "Error : Employee Leave Balance is Less Than Applied Days. So Please Reject/Rework a Leave Request");
//                }
        }
        if (btnSubmit.equals("reject")) {

//            if (leaveEmployeeDetail.getStatus() == 4) {
//                leaveEmployeeDetailsApprovalHistory.setApprovalId(employeeMaster1.getId());
//                leaveEmployeeDetailsApprovalHistory.setApprovalName(employeeMaster1.getEmployeeName());
//                leaveEmployeeDetailsApprovalHistory.setComment(hrRemark);
//                leaveEmployeeDetailsApprovalHistory.setCreatedBy(employeeMaster1.getId());
//                leaveEmployeeDetailsApprovalHistory.setCreatedDate(submitDate);
//                leaveEmployeeDetailsApprovalHistory.setLeaveEmployeeDetail(leaveEmployeeDetail);
//                leaveEmployeeDetailsApprovalHistory.setStatusMessage("Withdraw Rejected");
//                leaveEmployeeDetailsApprovalHistory.setStatus(4); //Withdraw Rejected
//                leaveEmployeeDetailsApprovalHistoryService.create(leaveEmployeeDetailsApprovalHistory);
//                request.setAttribute("successMessage",
//                        "Information : The Withdraw Request Rejected successfully.");
//                try {
//                    EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
//                    DesignationMaster designationMaster = new DesignationMaster();
//                    designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
//                    String EmpIdStr = request.getParameter("empid");
//                    EmployeeMaster employeeMaster2 = new EmployeeMaster();
//                    EmailTemplate emailTemplate1 = new EmailTemplate();
//                    // id =9 for reject leave request...
//                    emailTemplate1 = emailTemplateService.readById(9);
//                    if (null != EmpIdStr && !"".equals(EmpIdStr)) {
//                        int empID = Integer.parseInt(EmpIdStr);
//                        List list = employeeMasterService.readByEmployeeNo(empID);
//                        if (!list.isEmpty()) {
//                            employeeMaster2 = (EmployeeMaster) list.get(0);
//                            String To = employeeMaster2.getOfficeEmailId();
//                            String from = employeeMasterModel.getOfficeEmailId();
//                            String subject = emailTemplate1.getSubject();
//                            subject = subject.replaceAll("\\{user\\}", employeeMaster2.getEmployeeName());
//                            String msg = emailTemplate1.getBodytext();
//                            msg = msg.replaceAll("\\{to_user\\}", employeeMaster2.getEmployeeName());
//                            msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
//                            msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
//                            sendMail.sendMail(from, To, subject, msg);
//
//                        }
//                    }
//                } catch (Exception e) {
//                }
//
//            } else {
            balanceDay = employeeLeaveBalance.getNoOfLeaveRemain();
            noOfDay = leaveEmployeeDetail.getNoOfDays();
            String noOfHour = "";
            EmployeeMaster employeeMasterModel1 = new EmployeeMaster();
            employeeMasterModel1 = employeeMasterService.readById(leaveEmployeeDetail.getEmployeeMaster().getId());
            COffLeaveMaster cOffLeaveMaster = new COffLeaveMaster();
            cOffLeaveMaster.setZydexLocationMaster(employeeMasterModel1.getZydexLocationMaster());
            List list1 = cOffLeaveMasterService.readByDept(cOffLeaveMaster);
            try {
                cOffLeaveMaster = (COffLeaveMaster) list1.get(0);
                noOfHour = "0." + cOffLeaveMaster.getHoursNo();
            } catch (Exception e) {
            }
            // 11 No Id Is C-Off Id*****************
            if (leaveEmployeeDetail.getLeaveTypeMaster().getId().equals(11)) {
                noOfDay = Float.parseFloat(noOfHour);
            }
            // 11 No Id Is C-Off Id*****************
            balanceDay = balanceDay + noOfDay;
            employeeLeaveBalance.setNoOfLeaveRemain(balanceDay);
            employeeLeaveBalanceService.update(employeeLeaveBalance);
            leaveEmployeeDetailsApprovalHistory.setApprovalId(employeeMaster1.getId());
            leaveEmployeeDetailsApprovalHistory.setApprovalName(employeeMaster1.getEmployeeName());
            leaveEmployeeDetailsApprovalHistory.setComment(hrRemark);
            leaveEmployeeDetailsApprovalHistory.setCreatedBy(employeeMaster1.getId());
            leaveEmployeeDetailsApprovalHistory.setCreatedDate(submitDate);
            leaveEmployeeDetailsApprovalHistory.setLeaveEmployeeDetail(leaveEmployeeDetail);
            leaveEmployeeDetailsApprovalHistory.setStatusMessage("Rejected By HR");
            leaveEmployeeDetailsApprovalHistory.setStatus(7); //Rejected
            leaveEmployeeDetailsApprovalHistoryService.create(leaveEmployeeDetailsApprovalHistory);
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

            leaveEmployeeDetail.setStatus(7);
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String approveDate = sdf.format(date);
            leaveEmployeeDetail.setApproveDate(approveDate);
            leaveEmployeeDetailService.update(leaveEmployeeDetail);

        }
        if (btnSubmit.equals("rework")) {

//            if (leaveEmployeeDetail.getStatus() == 4) {
//
//            } else {
            balanceDay = employeeLeaveBalance.getNoOfLeaveRemain();
            noOfDay = leaveEmployeeDetail.getNoOfDays();
            balanceDay = balanceDay + noOfDay;
            employeeLeaveBalance.setNoOfLeaveRemain(balanceDay);
            employeeLeaveBalanceService.update(employeeLeaveBalance);
//            }
            leaveEmployeeDetail.setStatus(8);
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String approveDate = sdf.format(date);
            leaveEmployeeDetail.setApproveDate(approveDate);
            leaveEmployeeDetailService.update(leaveEmployeeDetail);
            leaveEmployeeDetailsApprovalHistory.setApprovalId(employeeMaster1.getId());
            leaveEmployeeDetailsApprovalHistory.setApprovalName(employeeMaster1.getEmployeeName());
            leaveEmployeeDetailsApprovalHistory.setComment(hrRemark);
            leaveEmployeeDetailsApprovalHistory.setCreatedBy(employeeMaster1.getId());
            leaveEmployeeDetailsApprovalHistory.setCreatedDate(submitDate);
            leaveEmployeeDetailsApprovalHistory.setLeaveEmployeeDetail(leaveEmployeeDetail);
            leaveEmployeeDetailsApprovalHistory.setStatusMessage("Reworked By HR");
            leaveEmployeeDetailsApprovalHistory.setStatus(8); //Reworked
            leaveEmployeeDetailsApprovalHistoryService.create(leaveEmployeeDetailsApprovalHistory);
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

        mv = hremployeeleaveManagement(request, response);
        return mv;
    }

    public void getActualDayByAjax1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String strDate = request.getParameter("strDate");
        String enDate = request.getParameter("enDate");
        String sDateStatus = request.getParameter("sDateStatus");
        String eDateStatus = request.getParameter("eDateStatus");
        String leavetype = request.getParameter("leaveType");
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
        int ZydexLocId = employeeMaster1.getZydexLocationMaster().getId();
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
        int coutnter = 0;
        boolean sundayCheck = false;
        Calendar c = Calendar.getInstance();
        c.setTime(sDate);
        List<String> list1 = new ArrayList<String>();
        float days = 0;
        while (c.getTime().before(eDate) || c.getTime().equals(eDate)) {

            Calendar calForEnddate = Calendar.getInstance();
            calForEnddate.setTime(eDate);
            int dayEnd = calForEnddate.get(Calendar.DAY_OF_WEEK);

//              
////                    if (c.get(Calendar.DAY_OF_WEEK) != weekOff) {
            int dayOfWeek = c.get(Calendar.WEEK_OF_MONTH);
            Date nDate = c.getTime();
            String daString = sdf.format(nDate);
            HolidayMaster holidayMaster = new HolidayMaster();
            holidayMaster.setHolidayFromDate(daString);
            List list = holidayMasterService.checkHoliday(daString, "" + employeeMaster1.getLocationMaster().getId());
            if (list.size() == 0) {
                days++;
            }
            for (String z : weekOffDay.split(",")) {
                int weekOff = 0;
                if (!z.equals("")) {
                    if (z.equals("sunday")) {
                        weekOff = 1;
                        sundayCheck = true;
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
                    } else if (z.equals("saturday")) {
                        weekOff = 7;
                    }
                }
                if (c.get(Calendar.DAY_OF_WEEK) != weekOff) {
                    if (c.get(Calendar.DAY_OF_WEEK) == 7 && coutnter == 0) {
                        if (sDateStatus.contains("SecondHalf")) {
                            if (!strDate.equals(enDate)) {
                                days--;
                            }
                        }
                    }
                }
                if (!leavetype.equals("6") && !leavetype.equals("7") && !leavetype.equals("16") && !leavetype.equals("12")) {
                    if (c.get(Calendar.DAY_OF_WEEK) == 7 && !sDateStatus.contains("SecondHalf")) {
                        if (!strDate.equals(enDate)) {
                            days--;
                        }
                    }
                }
                coutnter++;
            }
            c.add(Calendar.DATE, 1);

        }

        PrintWriter out = response.getWriter();
        out.print(days);
    }

    public void checkWeekOffOrHolidayForEDate1(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
//                if (z.equals("sunday")) {
//                    weekOff = 1;
//                } else 
                if (z.equals("monday")) {
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
//                List list = holidayMasterService.checkHoliday(enDate, "" + employeeMaster1.getLocationMaster().getId());

//                if (c.get(Calendar.DAY_OF_WEEK) == weekOff || list.size() > 0) {
//                    message = "Selected Date is Holiday/WeekOff.So You can't Apply Leave on this Day.";
//                }
            }
        }
        PrintWriter out = response.getWriter();
        out.print(message);
    }

    public void checkWeekOffOrHolidayForSDate1(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
//        if (!weekOffDay.equals("sunday")) {

        for (String z : weekOffDay.split(",")) {
            int weekOff = 0;
            if (!z.equals("")) {
//                if (z.equals("sunday")) {
//                    weekOff = 1;
//                } else 
                if (z.equals("monday")) {
                    weekOff = 2;
                } else if (z.equals("tuesday")) {
                    weekOff = 3;
                } else if (z.equals("wednesday")) {
                    weekOff = 4;
                } else if (z.equals("thursday")) {
                    weekOff = 5;
                } else if (z.equals("friday")) {
                    weekOff = 6;
                } else if (z.equals("saturday")) {
                    weekOff = 7;
                }
                Date nDate = c.getTime();
                String daString = sdf.format(nDate);
                HolidayMaster holidayMaster = new HolidayMaster();
                holidayMaster.setHolidayFromDate(daString);
//                List list = holidayMasterService.checkHoliday(strDate, "" + employeeMaster1.getLocationMaster().getId());

//                if (c.get(Calendar.DAY_OF_WEEK) == weekOff || list.size() > 0) {
//                    message = "Selected Date is Holiday/WeekOff.So You can't Apply Leave on this Day.";
//                }
            }
        }
//        }
        PrintWriter out = response.getWriter();
        out.print(message);
    }

    public void readleaveTypeMaster(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();
        if (!request.getParameter("id").equals("")) {
            int id = Integer.parseInt(request.getParameter("id"));
            EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
            LeaveTypeMaster leaveTypeMaster1 = leaveTypeMasterService.readById(id);
            if (leaveTypeMaster1.getLeaveType().equals("Privilege Leave") || leaveTypeMaster1.getLeaveType().equals("Casual Leave")) {
                List<?> list = leaveTypeMasterService.readByUsBySickLeave(id, employeeMaster.getId());
                if (list.size() != 0) {
                    EmployeeLeaveBalance employeeLeaveBalance = new EmployeeLeaveBalance();
                    employeeLeaveBalance = (EmployeeLeaveBalance) list.get(0);
                    int id12 = employeeLeaveBalance.getId();
                    json.put("useSickLeave", 0);
                    out.println(json.toString());
                }
            } else {
                if (leaveTypeMaster1.isUseAsSickLeave()) {
                    json.put("useSickLeave", 1);
                    out.println(json.toString());
                } else {
                    json.put("useSickLeave", 2);
                    out.println(json.toString());
                }
            }
        }
    }
}
