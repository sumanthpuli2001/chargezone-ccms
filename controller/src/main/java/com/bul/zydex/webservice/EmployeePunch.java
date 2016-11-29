/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.webservice;

import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.EmployeePunchForMobileApp;
import com.bul.zydex.model.EmployeeShiftData;
import com.bul.zydex.model.RegisterMobForPunch;
import com.bul.zydex.model.ShiftGenerateMonthlySchedule;
import com.bul.zydex.model.ShiftMaster;
import com.bul.zydex.model.TempShiftAssignMaster;
import com.bul.zydex.model.UserMaster;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author admin
 */
public class EmployeePunch extends EmployeePunchAbstract {

    public void submitPunchRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, JSONException, ParseException {
        PrintWriter out = null;
        out = response.getWriter();
        String rcode = "";
        String message = "";
        String empid = "";
        UserMaster user = new UserMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        RegisterMobForPunch registerMobForPunch = new RegisterMobForPunch();
        JSONObject userData = new JSONObject();
        try {
            JSONObject data = doPost(request);
            String id = request.getParameter("id");
            int userid = Integer.parseInt(id);
            user.setId(userid);
            employeeMaster.setUserMaster(user);
            List<?> empDetailList = employeeMasterService.readByEmployeeUserId(employeeMaster);
            if (!empDetailList.isEmpty()) {
                employeeMaster1 = (EmployeeMaster) empDetailList.get(0);
                String date = data.get("punchTime").toString();
                String punchTime = date;
                

                EmployeePunchForMobileApp employeePunchForMobileApp = new EmployeePunchForMobileApp();
                employeePunchForMobileApp.setEmployeeMaster(employeeMaster1);
                employeePunchForMobileApp.setPunchTime(punchTime);
                employeePunchForMobileApp.setPunchLocation(data.get("punchLocation").toString());

                String imeiNO = data.get("imeiNo").toString();

                List<?> empMobRegList = registerMobForPunchService.readByEmpId(employeeMaster1.getId());
                if (empMobRegList.isEmpty()) {
                    registerMobForPunch.setEmployeeMaster(employeeMaster1);
                    registerMobForPunch.setImeiNo(imeiNO);
                    registerMobForPunchService.create(registerMobForPunch);
                    employeePunchForMobileAppService.create(employeePunchForMobileApp);
                    rcode = "1";
                    message = "Success";
                } else {
                    registerMobForPunch = (RegisterMobForPunch) empMobRegList.get(0);
                    String imeiNum = registerMobForPunch.getImeiNo();
                    if (imeiNum.equals(imeiNO)) {
                        employeePunchForMobileAppService.create(employeePunchForMobileApp);
                        rcode = "1";
                        message = "Success";
                    } else {
                        rcode = "2";
                        message = "Your device Not Register";
                    }
                }
            } else {
                rcode = "0";
                message = "No Record Found";
            }
        } catch (Exception exception) {
            rcode = "0";
            message = "Something Wrong";
        }

        userData.put("responseMessage", message);
        userData.put("responseCode", rcode);
        out.print(userData);

    }

    
    private synchronized void mobPunchEntryDaily() throws Exception {

        EmployeeShiftData employeeShiftData = new EmployeeShiftData();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        UserMaster userMaster = new UserMaster();
//        EmployeeDatetimeData employeeDatetimeData1 = new EmployeeDatetimeData();
        EmployeePunchForMobileApp employeePunchForMobileApp=new EmployeePunchForMobileApp();
//        userMaster.setId(1614);
//        employeeMaster.setUserMaster(userMaster);
//        List<?> empList = employeeMasterService.readByEmployeeUserId(employeeMaster);

//        List<?> empList = employeeMasterService.read();
        List<?> empList =employeePunchForMobileAppService.readEmpByCurrentDate();
        for (Object zz : empList) {
            try {
//                employeeMaster = (EmployeeMaster) zz;
                employeePunchForMobileApp = (EmployeePunchForMobileApp) zz;
                employeeMaster.setId(employeePunchForMobileApp.getEmployeeMaster().getId());

                ShiftGenerateMonthlySchedule shiftGenerateMonthlySchedule = new ShiftGenerateMonthlySchedule();
                Date date = new Date();
                Format formatter = new SimpleDateFormat("dd/MM/YYYY");

                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                String s = formatter.format(date);
                String[] s1 = s.split("/");
                String currentDays = s1[0];
//                String currentDays = "02";
                String currentMonth = s1[1];
                String currentyear = s1[2];
                shiftGenerateMonthlySchedule.setEmployeeMaster(employeeMaster);
                shiftGenerateMonthlySchedule.setShiftMonth(currentMonth);
                shiftGenerateMonthlySchedule.setShiftYear(currentyear);
                String shiftId = "";
                List<?> empShiftList = shiftGenerateMonthlyScheduleService.readByDayWiseEmployeeShiftData(shiftGenerateMonthlySchedule, Integer.parseInt(currentDays));
                if (!empShiftList.isEmpty()) {
                    shiftId = "" + empShiftList.get(0);
                }
                TempShiftAssignMaster tempShiftAssignMaster = new TempShiftAssignMaster();
                TempShiftAssignMaster tempShiftAssignMaster1 = new TempShiftAssignMaster();
                tempShiftAssignMaster.setEmployeeMaster(employeeMaster);
                tempShiftAssignMaster1 = temporaryShiftAssignService.temporaryShiftAssignResultByDaysWise(tempShiftAssignMaster);
                ShiftMaster shiftMaster = new ShiftMaster();
                ShiftMaster shiftMaster1 = new ShiftMaster();
                String shiftName = "";
                String daynamicShiftName = "";
                String shiftTime = "";
                if (null != tempShiftAssignMaster1) {
                    shiftMaster.setId(tempShiftAssignMaster1.getShiftMaster().getId());
                    shiftMaster1 = shiftMasterService.readById(shiftMaster.getId());
                    shiftName = shiftMaster1.getShiftName();
                    shiftTime = shiftMaster1.getEndTime();
                } else if (empShiftList.size() > 0) {
                    shiftMaster.setId(Integer.parseInt(shiftId));
                    shiftMaster1 = shiftMasterService.readById(shiftMaster.getId());
                    shiftName = shiftMaster1.getShiftName();
                    shiftTime = shiftMaster1.getEndTime();

                }
//                =========================== Auto Capture Shift========================
                EmployeeMaster employeeMaster1 = employeeMasterService.readById(employeeMaster.getId());
                if (!employeeMaster1.getZydexLocationMaster().getId().equals(1) && !employeeMaster1.getZydexLocationMaster().getId().equals(6)) {

                    SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                    SimpleDateFormat timeFormat1 = new SimpleDateFormat("HH:mm");
                    String dynamicShiftDateTime = employeePunchForMobileApp.getPunchTime();
                    Date dynamicTime = sdf3.parse(dynamicShiftDateTime);

                    Date date1 = new Date();
                    Date dateBefore = new Date(date1.getTime() - 24 * 60 * 60 * 1000);
                    String yesterdayDate = formatter.format(dateBefore);
                    ShiftMaster generalShift = new ShiftMaster();
                    if (employeeMaster1.getZydexLocationMaster().getId().equals(1) && employeeMaster1.getZydexLocationMaster().getId().equals(6)) {
                        generalShift = shiftMasterService.readById(1);
                    } else {
                        generalShift = shiftMasterService.readById(6);
                    }
                    ShiftMaster firstShift = shiftMasterService.readById(3);
                    ShiftMaster secondShift = shiftMasterService.readById(4);
                    ShiftMaster nightShift = shiftMasterService.readById(5);

//                String generalShiftStartTime = "02/07/2016" + " " + generalShift.getStartTime();
//                String firstShiftStartTime = "02/07/2016" + " " + firstShift.getStartTime();
//                String secondShiftStartTime = "02/07/2016" + " " + secondShift.getStartTime();
//                String nightShiftStartTime = "02/07/2016" + " " + nightShift.getStartTime();
//                String yesterdatSecondShiftStartTime = "01/07/2016" + " " + secondShift.getStartTime();
                    String generalShiftStartTime = s + " " + generalShift.getStartTime();
                    String firstShiftStartTime = s + " " + firstShift.getStartTime();
                    String secondShiftStartTime = s + " " + secondShift.getStartTime();
                    String nightShiftStartTime = s + " " + nightShift.getStartTime();
                    String yesterdatSecondShiftStartTime = yesterdayDate + " " + secondShift.getStartTime();

                    Date dategeneralShiftStartTime = sdf3.parse(generalShiftStartTime);
                    Date dateFirstShiftStartTime = sdf3.parse(firstShiftStartTime);
                    Date dateSecondShiftStartTime = sdf3.parse(secondShiftStartTime);
                    Date dateNightShiftStartTime = sdf3.parse(nightShiftStartTime);
                    Date dateyesterdatSecondShiftStartTime = sdf3.parse(yesterdatSecondShiftStartTime);

                    Calendar calGeneralShiftBefore = Calendar.getInstance();
                    Calendar calGeneralShiftAfter = Calendar.getInstance();
                    Calendar calFirstShiftBefore = Calendar.getInstance();
                    Calendar calFirstShiftAfter = Calendar.getInstance();
                    Calendar calSecondShiftBefore = Calendar.getInstance();
                    Calendar calSecondShiftAfter = Calendar.getInstance();
                    Calendar calNightShiftBefore = Calendar.getInstance();
                    Calendar calNightShiftAfter = Calendar.getInstance();
                    Calendar calYesterSecondShiftBefore = Calendar.getInstance();
                    Calendar calYesterSecondShiftAfter = Calendar.getInstance();

                    calGeneralShiftBefore.setTime(dategeneralShiftStartTime);
                    calGeneralShiftBefore.add(Calendar.MINUTE, -90);

                    calGeneralShiftAfter.setTime(dategeneralShiftStartTime);
                    calGeneralShiftAfter.add(Calendar.HOUR, 2);

                    calFirstShiftBefore.setTime(dateFirstShiftStartTime);
                    calFirstShiftBefore.add(Calendar.HOUR, -2);

                    calFirstShiftAfter.setTime(dateFirstShiftStartTime);
                    calFirstShiftAfter.add(Calendar.HOUR, 2);

                    calSecondShiftBefore.setTime(dateSecondShiftStartTime);
                    calSecondShiftBefore.add(Calendar.HOUR, -2);

                    calSecondShiftAfter.setTime(dateSecondShiftStartTime);
                    calSecondShiftAfter.add(Calendar.HOUR, 2);

                    calNightShiftBefore.setTime(dateNightShiftStartTime);
                    calNightShiftBefore.add(Calendar.HOUR, -2);

                    calNightShiftAfter.setTime(dateNightShiftStartTime);
                    calNightShiftAfter.add(Calendar.HOUR, 2);

                    calYesterSecondShiftBefore.setTime(dateyesterdatSecondShiftStartTime);
                    calYesterSecondShiftBefore.add(Calendar.HOUR, -2);

                    calYesterSecondShiftAfter.setTime(dateyesterdatSecondShiftStartTime);
                    calYesterSecondShiftAfter.add(Calendar.HOUR, 2);

                    if ((dynamicTime.after(calGeneralShiftBefore.getTime()) || dynamicTime.equals(calGeneralShiftBefore.getTime()))
                            && (dynamicTime.before(calGeneralShiftAfter.getTime()) || dynamicTime.equals(calGeneralShiftAfter.getTime()))) {
                        daynamicShiftName = generalShift.getShiftName();
                        if (daynamicShiftName.equals("General")) {
                            shiftMaster1 = shiftMasterService.readById(1);
                        } else {
                            shiftMaster1 = shiftMasterService.readById(6);
                        }
                    } else if ((dynamicTime.after(calFirstShiftBefore.getTime()) || dynamicTime.equals(calFirstShiftBefore.getTime()))
                            && (dynamicTime.before(calFirstShiftAfter.getTime()) || dynamicTime.equals(calFirstShiftAfter.getTime()))) {
                        List<?> employeeYesterdayPunchData = employeePunchForMobileAppService.readYesterdayEmployeeData("" + employeeMaster.getId());

                        if (!employeeYesterdayPunchData.isEmpty()) {
                            EmployeePunchForMobileApp employeePunchForMobileApp1 = (EmployeePunchForMobileApp) employeeYesterdayPunchData.get(0);
                            EmployeePunchForMobileApp employeePunchForMobileApp2 = (EmployeePunchForMobileApp) employeeYesterdayPunchData.get(employeeYesterdayPunchData.size() - 1);
                            String startPunchTime = employeePunchForMobileApp1.getPunchTime();
                            String endPunchTime = employeePunchForMobileApp2.getPunchTime();
                            Date punchTime1 = sdf3.parse(startPunchTime);
                            Date punchTime2 = sdf3.parse(endPunchTime);
                            if ((punchTime1.after(calYesterSecondShiftBefore.getTime()) || punchTime1.equals(calYesterSecondShiftBefore.getTime()))
                                    && (punchTime1.before(calYesterSecondShiftAfter.getTime()) || punchTime1.equals(calYesterSecondShiftAfter.getTime()))) {
                                daynamicShiftName = firstShift.getShiftName();
                                shiftMaster1 = shiftMasterService.readById(3);
                            } else if ((punchTime2.after(calYesterSecondShiftBefore.getTime()) || punchTime2.equals(calYesterSecondShiftBefore.getTime()))
                                    && (punchTime2.before(calYesterSecondShiftAfter.getTime()) || punchTime2.equals(calYesterSecondShiftAfter.getTime()))) {
                                daynamicShiftName = firstShift.getShiftName();
                                shiftMaster1 = shiftMasterService.readById(3);
                            } else {
                                daynamicShiftName = nightShift.getShiftName();
                                shiftMaster1 = shiftMasterService.readById(5);
                                shiftTime = shiftMaster1.getEndTime();
                            }
                        } else {
                            daynamicShiftName = firstShift.getShiftName();
                            shiftMaster1 = shiftMasterService.readById(3);
                        }

                    } else if ((dynamicTime.after(calSecondShiftBefore.getTime()) || dynamicTime.equals(calSecondShiftBefore.getTime()))
                            && (dynamicTime.before(calSecondShiftAfter.getTime()) || dynamicTime.equals(calSecondShiftAfter.getTime()))) {
                        daynamicShiftName = secondShift.getShiftName();
                        shiftMaster1 = shiftMasterService.readById(4);
                    } else if ((dynamicTime.after(calNightShiftBefore.getTime()) || dynamicTime.equals(calNightShiftBefore.getTime()))
                            && (dynamicTime.before(calNightShiftAfter.getTime()) || dynamicTime.equals(calNightShiftAfter.getTime()))) {
                        daynamicShiftName = nightShift.getShiftName();
                        shiftMaster1 = shiftMasterService.readById(5);
                        shiftTime = shiftMaster1.getEndTime();
                    } else if (empShiftList.size() > 0) {
                        shiftMaster.setId(Integer.parseInt(shiftId));
                        shiftMaster1 = shiftMasterService.readById(shiftMaster.getId());
                        daynamicShiftName = shiftMaster1.getShiftName();
                        if (daynamicShiftName.equals("General")) {
                            if (employeeMaster1.getZydexLocationMaster().getId().equals(1) || employeeMaster1.getZydexLocationMaster().getId().equals(6)) {
                                shiftMaster1 = shiftMasterService.readById(1);
                            } else {
                                shiftMaster1 = shiftMasterService.readById(6);
                            }
                        }
                        shiftTime = shiftMaster1.getEndTime();

                    }

                } else {
                    shiftMaster1 = shiftMasterService.readById(1);
                }
//                =========================== Auto Capture Shift========================
                List< ?> employeeShiftPunchList = new ArrayList<Object>();
                String newShiftTime = "";
                if (daynamicShiftName.contains("Night")) {
                    SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

                    Date time = timeFormat.parse(shiftTime);
//            Date
                    Calendar cal22 = Calendar.getInstance();
                    cal22.setTime(time);
                    cal22.add(Calendar.HOUR_OF_DAY, 8);
                    time = cal22.getTime();
                    newShiftTime = timeFormat.format(time);

                    employeeShiftPunchList = employeePunchForMobileAppService.readTodaysAndPreviousData("" + employeeMaster.getId(), newShiftTime);

                    for (Object o : employeeShiftPunchList) {
                        EmployeePunchForMobileApp employeePunchForMobileApp3 = (EmployeePunchForMobileApp) o;
                        EmployeeShiftData employeeShiftData1 = new EmployeeShiftData();
                        List dayWiseShiftList = new ArrayList();
                        employeeShiftData.setEmployeeMaster(employeeMaster);
                        employeeShiftData1.setEmployeeMaster(employeeMaster);
                        employeeShiftData1.setShiftMaster(shiftMaster1);

                        String newShiftTimeSplit = "";

                        cal22.setTime(time);
                        cal22.add(Calendar.HOUR_OF_DAY, 8);
                        time = cal22.getTime();
                        newShiftTime = timeFormat.format(time);
                        newShiftTimeSplit = newShiftTime.split(":")[0];
                        dayWiseShiftList = employeeShiftDataService.getPastAndCurrentPunch(employeeShiftData, newShiftTime);

                        if (!dayWiseShiftList.isEmpty()) {
//                    if (size % 2 == 0) {
                            SimpleDateFormat sdf111 = new SimpleDateFormat("dd/MM/yyyy");
                            employeeShiftData1 = (EmployeeShiftData) dayWiseShiftList.get(0);
                            employeeShiftData.setInDateTime(employeeShiftData1.getInDateTime());
                            String[] splited = employeeShiftData1.getOutDateTime().split(" ");
                            String[] splited1 = employeePunchForMobileApp3.getPunchTime().split(" ");
                            String spDate = splited[0];
                            Date currentDate = new Date();
//                            String punDate = "01/07/2016";
                            String punDate = sdf111.format(currentDate);
                            Date inDate = sdf111.parse(spDate);
                            Date pDate = sdf111.parse(punDate);
                            String timeSplit = splited1[1].split(":")[0];

                            if (inDate.equals(pDate) && Integer.parseInt(timeSplit) > Integer.parseInt(newShiftTimeSplit)) {
                                if (dayWiseShiftList.size() > 1) {
                                    employeeShiftData1 = (EmployeeShiftData) dayWiseShiftList.get(1);
                                    employeeShiftData1.setInDateTime(employeeShiftData1.getInDateTime());
                                    employeeShiftData1.setOutDateTime(employeePunchForMobileApp3.getPunchTime());
                                    employeeShiftDataService.createOrUpdate(employeeShiftData1);
                                } else {
                                    employeeShiftData1.setInDateTime(employeePunchForMobileApp3.getPunchTime());
                                    employeeShiftData1.setOutDateTime(employeePunchForMobileApp3.getPunchTime());
                                    employeeShiftDataService.create(employeeShiftData1);
                                }
                            } else {
                                employeeShiftData1.setOutDateTime(employeePunchForMobileApp3.getPunchTime());
                                employeeShiftDataService.createOrUpdate(employeeShiftData1);
                            }
                        } else {
                            employeeShiftData1.setInDateTime(employeePunchForMobileApp3.getPunchTime());
                            employeeShiftData1.setOutDateTime(employeePunchForMobileApp3.getPunchTime());
                            employeeShiftDataService.createOrUpdate(employeeShiftData1);
                        }

                    }

                } else {
                    employeeShiftPunchList = employeePunchForMobileAppService.readTodaysEmployeeData("" + employeeMaster.getId());
                    for (Object o : employeeShiftPunchList) {
                      EmployeePunchForMobileApp employeePunchForMobileApp4 = (EmployeePunchForMobileApp) o;
                        EmployeeShiftData employeeShiftData1 = new EmployeeShiftData();
                        List dayWiseShiftList = new ArrayList();
                        employeeShiftData.setEmployeeMaster(employeeMaster);
                        employeeShiftData1.setEmployeeMaster(employeeMaster);
                        employeeShiftData1.setShiftMaster(shiftMaster1);
                        dayWiseShiftList = employeeShiftDataService.dailyTimeEntry(employeeShiftData);
                        if (!dayWiseShiftList.isEmpty()) {
                            employeeShiftData1 = (EmployeeShiftData) dayWiseShiftList.get(0);
                            employeeShiftData.setInDateTime(employeeShiftData1.getInDateTime());
                            employeeShiftData1.setOutDateTime(employeePunchForMobileApp4.getPunchTime());
                            employeeShiftDataService.createOrUpdate(employeeShiftData1);
                        } else {
                            employeeShiftData1.setInDateTime(employeePunchForMobileApp4.getPunchTime());
                            employeeShiftData1.setOutDateTime(employeePunchForMobileApp4.getPunchTime());
                            employeeShiftDataService.createOrUpdate(employeeShiftData1);
                        }

                    }

                }
            } catch (Exception e) {
                System.out.println("Exception" + e.getMessage());
            }
        }

    }

}
