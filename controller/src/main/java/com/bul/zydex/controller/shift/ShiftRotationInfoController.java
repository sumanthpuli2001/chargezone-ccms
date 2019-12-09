/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.shift;

import com.bul.zydex.controller.emp.EmployeeMasterAbstract;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.RotationMaster;
import com.bul.zydex.model.ShiftGenerateMonthlySchedule;
import com.bul.zydex.model.ShiftMaster;
import com.bul.zydex.model.ShiftRotationInfo;
import com.bul.zydex.model.ShiftRotationMaster;
import com.bul.zydex.model.UserMaster;
import com.bul.zydex.service.shift.ShiftRotationMasterService;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author AJAY
 */
public class ShiftRotationInfoController extends ShiftRotationInfoAbstract {

    public ModelAndView createSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ShiftRotationInfo shiftRotationInfo = new ShiftRotationInfo();
        ShiftRotationInfo shiftRotationInfo1 = new ShiftRotationInfo();
        ShiftRotationMaster shiftRotationMaster = new ShiftRotationMaster();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getAttribute("employeeMaster");
        UserMaster userMaster = (UserMaster) request.getAttribute("userMaster");
        String shiftMasterId = request.getAttribute("shiftMasterId").toString();
        if (!"".equals(shiftMasterId)) {

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
                mv.setViewName("Employee/EmployeeRegistrationForm");
            } else {
                shiftRotationInfo.setFirstShiftId(Integer.parseInt(shiftMasterId));
                request.setAttribute("successMessage",
                        "Information : The Information is updated Successfully.");
                shiftRotationInfoService.update(shiftRotationInfo);
                mv.setViewName("Employee/EditUserProfile");
            }
        } else {
            request.setAttribute("failureMessage",
                    "Error : Please Select First Shift Name.");
            mv.setViewName("Employee/EditUserProfile");

        }

        return mv;
    }
    
    public ModelAndView viewRotationClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        //---------------
        shiftRotaionList(request);
        //List<?> shift1 = shiftRotationInfoService.read();
        ShiftRotationMaster shiftRotationMaster = new ShiftRotationMaster();
        
        //--------------------
        EmployeeMaster employeeMaster = new EmployeeMaster();
        String id = request.getParameter("id");
        if (null == id || id == "") {
            id = "" + employeeMaster.getId();
        }
        try {
            List<?> employeeMasterList = employeeMasterService.readByUserId(Integer.parseInt(id));//readById(Integer.parseInt(id));
            employeeMaster = (EmployeeMaster) employeeMasterList.get(0);
        } catch (Exception e) {
            
            
        }
        
        //hoursBasisList(request);
        //shiftList(request);
        
        //ShiftRotationInfo shiftRotationInfo = new ShiftRotationInfo();
        
        //List<?> shiftRotationInfoList = shiftRotationInfoService.readByUserId(employeeMaster.getUserMaster().getId());
        
        //if(!shiftRotationInfoList.isEmpty())
        //{
        //    shiftRotationInfo = (ShiftRotationInfo)shiftRotationInfoList.get(0);
        //    request.setAttribute("rotationDate",shiftRotationInfo.getRotationDate());
        //}
        //request.setAttribute("shiftType", employeeMaster.getShiftType());
        mv.getModelMap().put("employeeMaster", employeeMaster);
        //--------------------
        ShiftRotationInfo shiftRotationInfo = new ShiftRotationInfo();
        UserMaster userMaster = new UserMaster();
        //String id = request.getParameter("id");
        userMaster.setId(Integer.parseInt(id));
        shiftRotationInfo.setUserMaster(userMaster);
        List<?> list = shiftRotationInfoService.readRotaionDetail(shiftRotationInfo);
        if (!list.isEmpty()) {

            shiftRotationInfo = (ShiftRotationInfo) list.get(0);
            shiftRotationInfo = shiftRotationInfoService.readById(shiftRotationInfo.getId());
        }
        mv.getModelMap().put("shiftRotationInfo", shiftRotationInfo);
        mv.setViewName("Shift/ShiftRotationInfoView");
        return mv;
    }

    public ModelAndView editRotationSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        ModelAndView mv = new ModelAndView();
//        ShiftRotationInfo shiftRotationInfo = new ShiftRotationInfo();
//
//        return mv;
        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        ShiftRotationInfo shiftRotationInfo = new ShiftRotationInfo();
        ShiftRotationInfo shiftRotationInfo2 = new ShiftRotationInfo();
        ShiftRotationInfo shiftRotationInfo1 = new ShiftRotationInfo();
        ShiftRotationMaster shiftRotationMaster = new ShiftRotationMaster();
        UserMaster userMaster = new UserMaster();
        bind(request, shiftRotationInfo2);//employeeMaster);
        int id = Integer.parseInt(request.getParameter("empId"));//employeeMaster.getId();

        employeeMaster1 = employeeMasterService.readById(id);
        userMaster.setId(employeeMaster1.getUserMaster().getId());
        shiftRotationInfo2.setUserMaster(userMaster);
        String firstShiftId = request.getParameter("shiftMasterId");
        employeeMaster1.setShiftRotationDate(shiftRotationInfo2.getRotationDate());
        //employeeMaster1.setShiftType(employeeMaster.getShiftType());
//        if (employeeMaster.getShiftType().equals("HourlyBase")) {
//            String hoursId = request.getParameter("shiftHoursId");
//            employeeMaster1.setShiftHoursId(Integer.parseInt(hoursId));
//            employeeMasterService.update(employeeMaster1);
//            request.setAttribute("successMessage", "Information Saved Successfully.");
//            mv = searchSubmit(request, response);
//        }
//        if (employeeMaster.getShiftType().equals("ShiftBase")) {
            String shfitId = request.getParameter("shiftId");
//            if (shfitId.equals("") || request.getParameter("shiftRotationDate").equals("") || request.getParameter("shiftMasterId").equals("")) {
////                request.setAttribute("failureMessage",
////                        "Error : Please Select Rotation name,Shift name and rotation date.");
////                mv.getModelMap().put("employeeMaster", employeeMaster);
////                mv = changeEmployeeShift(request, response);
//                mv.setViewName("redirect:employeeMaster.htm?act=searchSubmit");
//            } else {
                //int shiftIdInt = Integer.parseInt(shfitId);
                employeeMaster1.setShiftHoursId(Integer.valueOf(shfitId));
                shiftRotationMaster.setId(Integer.parseInt(shfitId));
                List<?> list = shiftRotationInfoService.readRotaionDetail(shiftRotationInfo2);
                if (!list.isEmpty()) {
                    shiftRotationInfo = (ShiftRotationInfo) list.get(0);
                    shiftRotationInfo1.setId(shiftRotationInfo.getId());
                    shiftRotationInfo1.setUserMaster(userMaster);
                    shiftRotationInfo1.setShiftRotationMaster(shiftRotationMaster);
                    shiftRotationInfo1.setFirstShiftId(Integer.parseInt(firstShiftId));
                    shiftRotationInfo1.setRotationDate(shiftRotationInfo2.getRotationDate());//employeeMaster.getShiftRotationDate());
                    shiftRotationInfoService.update(shiftRotationInfo1);
                } else {
                    shiftRotationInfo1.setUserMaster(userMaster);
                    shiftRotationInfo1.setShiftRotationMaster(shiftRotationMaster);
                    shiftRotationInfo1.setFirstShiftId(Integer.parseInt(firstShiftId));
                    shiftRotationInfo1.setRotationDate(shiftRotationInfo2.getRotationDate());//employeeMaster.getShiftRotationDate());
                    shiftRotationInfoService.create(shiftRotationInfo1);
                }

                ShiftGenerateMonthlySchedule shiftGenerateMonthlySchedule = new ShiftGenerateMonthlySchedule();
                shiftGenerateMonthlySchedule.setEmployeeMaster(employeeMaster);
                String shiftRotationDate = shiftRotationInfo2.getRotationDate();  //request.getParameter("shiftRotationDate");
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
                shiftRotationMaster = shiftRotationMasterService.readById(Integer.valueOf(shfitId));
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
         //   }
     //   }

        return mv;

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

}
