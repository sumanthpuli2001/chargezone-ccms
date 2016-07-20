/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.shift;

import com.bul.zydex.model.AttendanceRegularization;
import com.bul.zydex.model.EmployeeAdvanceSearch;
import com.bul.zydex.model.EmployeeDatetimeData;
import com.bul.zydex.model.EmployeeLeaveBalance;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.EmployeeShiftData;
import com.bul.zydex.model.HolidayMaster;
import com.bul.zydex.model.LeaveEmployeeDetail;
import com.bul.zydex.model.LeaveTypeMaster;
import com.bul.zydex.model.LevelMaster;
import com.bul.zydex.model.OverTimeMaster;
import com.bul.zydex.model.RotationMaster;
import com.bul.zydex.model.ShiftGenerateMonthlySchedule;
import com.bul.zydex.model.ShiftMaster;
import com.bul.zydex.model.ShiftRotationInfo;
import com.bul.zydex.model.ShiftRotationMaster;
import com.bul.zydex.model.TempShiftAssignMaster;
import com.bul.zydex.model.TimeAttandanceFlaxibleMaster;
import com.bul.zydex.model.TravelRequestMaster;
import com.bul.zydex.model.UserMaster;
import com.bul.zydex.model.ZydexLocationMaster;
import com.bul.zydex.util.DownloadFile;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.DateFormatSymbols;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellUtil;
import org.springframework.validation.BindException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Dhaval
 */
public class ShiftRotationMasterController extends ShiftRotationMasterAbstract {

    public ModelAndView createClick(HttpServletRequest request, HttpServletResponse response, ShiftRotationMaster shiftRotationMaster) throws Exception {
        readShiftName(request);
        return new ModelAndView("Shift/ShiftRotationCreate", "shiftRotationMaster", shiftRotationMaster);
    }

    public ModelAndView createSubmit(HttpServletRequest request, HttpServletResponse response, ShiftRotationMaster shiftRotationMaster) throws Exception {
        ModelAndView mv = new ModelAndView("Shift/ShiftRotationCreate");
        ShiftMaster shiftMaster = new ShiftMaster();
        RotationMaster rotationMaster = new RotationMaster();
        BindException errors = new BindException(shiftRotationMaster, "shiftRotationMaster");
        bind(request, shiftRotationMaster);
        shiftRotationMasterValidator.validate(shiftRotationMaster, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            readShiftName(request);
            mv.addAllObjects(errors.getModel());
            mv.addObject("shiftRotationMaster", shiftRotationMaster);
//            mv.setViewName("Shift/ShiftRotationCreate");
        } else {
            try {
                shiftRotationMasterService.create(shiftRotationMaster);
                int countId = Integer.parseInt(request.getParameter("countId"));
                for (int i = 1; i <= countId; i++) {
                    String shiftMasterId = request.getParameter("shiftMaster" + i);
                    if (!"".equals(shiftMasterId) && null != shiftMasterId) {
                        shiftMaster.setId(Integer.parseInt(shiftMasterId));
                    }
                    rotationMaster.setShiftMaster(shiftMaster);
                    rotationMaster.setShiftRotationMaster(shiftRotationMaster);
                    rotationMasterService.create(rotationMaster);

//                shiftRotationMaster.setShiftMaster(shiftMaster);
                }
            } catch (NumberFormatException ne) {
            }
            request.setAttribute("successMessage",
                    "Information : The Information is saved Successfully.");
            mv.setViewName("redirect:shiftRotationMaster.htm?act=searchSubmit");
        }

        return mv;
    }

    public ModelAndView searchSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ShiftRotationMaster shiftRotationMaster = new ShiftRotationMaster();
        List<?> list = shiftRotationMasterService.read();
        request.setAttribute("list", list);

        Calendar c = Calendar.getInstance();
//        Date date = new Date();
//        c.setTime(date);
//        System.out.println(c.get(Calendar.DAY_OF_WEEK));
//        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yy");
//        Date date1 = df.parse("23/11/2015");
////change the pattern to output the day of week
//        df.applyPattern("EEE");
////print the formatted date out
//        System.out.println("Day of Week = " + df.format(date));
        Date date = new Date();
        c.setTime(date);
//c.setTime(now);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);

//        String[] days = new String[7];
//        int delta = -now.get(GregorianCalendar.DAY_OF_WEEK) + 1; //add 2 if your week start on monday
//        now.add(Calendar.DAY_OF_MONTH, delta);
//        for (int i = 0; i < 7; i++) {
//            days[i] = format.format(now.getTime());
//            now.add(Calendar.DAY_OF_MONTH, 1);
//        }
//        System.out.println(Arrays.toString(days));
        mv.setViewName("Shift/ShiftRotationResult");

        return mv;
    }

    public ModelAndView viewClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ShiftRotationMaster shiftRotationMaster = new ShiftRotationMaster();
        RotationMaster rotationMaster = new RotationMaster();
        String id = request.getParameter("id");
        readShiftName(request);
        shiftRotationMaster = shiftRotationMasterService.readById(Integer.parseInt(id));
        rotationMaster.setShiftRotationMaster(shiftRotationMaster);
        List<?> list = rotationMasterService.readFromRotation(rotationMaster);
        request.setAttribute("list", list);
        mv.getModelMap().put("shiftRotationMaster", shiftRotationMaster);
        mv.setViewName("Shift/ShiftRotationEdit");
        return mv;
    }

    public ModelAndView editSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ShiftRotationMaster shiftRotationMaster = new ShiftRotationMaster();
        ShiftMaster shiftMaster = new ShiftMaster();
        RotationMaster rotationMaster = new RotationMaster();
        BindException errors = new BindException(shiftRotationMaster, "shiftRotationMaster");
        bind(request, shiftRotationMaster);
        shiftRotationMaster.setId(Integer.parseInt(request.getParameter("id")));
        shiftRotationMasterValidator.validate(shiftRotationMaster, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv.addAllObjects(errors.getModel());
            mv.addObject("shiftRotationMaster", shiftRotationMaster);
//            mv.setViewName("Shift/ShiftRotationCreate");
        } else {
            shiftRotationMasterService.update(shiftRotationMaster);
            int countId = Integer.parseInt(request.getParameter("countId"));
            for (int i = 1; i <= countId; i++) {
                String rotationId = request.getParameter("shiftId" + i);
                String shiftMasterId = request.getParameter("shiftMaster" + i);
                if (!shiftMasterId.equals("") && null != shiftMasterId) {
                    shiftMaster.setId(Integer.parseInt(shiftMasterId));
                    rotationMaster.setShiftMaster(shiftMaster);

                }
                rotationMaster.setShiftRotationMaster(shiftRotationMaster);
                if (rotationId == null) {

                    rotationMasterService.create(rotationMaster);
                } else {
                    rotationMaster.setId(Integer.parseInt(rotationId));
                    rotationMasterService.update(rotationMaster);
                }

//                shiftRotationMaster.setShiftMaster(shiftMaster);
            }
            request.setAttribute("successMessage",
                    "Information : The Information is updated Successfully.");
            mv.setViewName("redirect:shiftRotationMaster.htm?act=searchSubmit");
        }
        return mv;
    }

    public ModelAndView deleteSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String checkId[] = request.getParameterValues("checkId");
        for (String xx : checkId) {
            try {
                shiftRotationMasterService.delete(Integer.parseInt(xx));
                request.setAttribute("successMessage",
                        "Info : One or more records are deleted successfully.");
            } catch (Exception e) {

            }
        }
        mv.setViewName("redirect:shiftRotationMaster.htm?act=searchSubmit");
        return mv;
    }

    public ModelAndView readRotationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ShiftRotationInfo shiftRotationInfo = new ShiftRotationInfo();
        String rotationId = request.getParameter("rotationId");
        String userId = request.getParameter("userId");
        shiftAjaxmap(request, rotationId);
        String shiftMasterId = request.getParameter("shiftMasterId");
        String firstShiftId = shiftRotationInfoService.readFirstShfitId(userId, rotationId);
        if (firstShiftId == "") {
            firstShiftId = shiftMasterId;
        }
        request.setAttribute("firstShiftId", firstShiftId);
        mv.setViewName("Shift/ShiftRotationAjax");

        return mv;
    }

    private synchronized void shiftGenerateMonthly() throws Exception {

        ShiftGenerateMonthlySchedule shiftGenerateMonthlySchedule = new ShiftGenerateMonthlySchedule();
        EmployeeMaster employeeMaster;
        ShiftRotationMaster shiftRotationMaster = new ShiftRotationMaster();
        RotationMaster rotationMaster = new RotationMaster();
        ShiftRotationInfo shiftRotationInfo = new ShiftRotationInfo();

        List<?> empList = employeeMasterService.read();
        for (Object o : empList) {
            employeeMaster = (EmployeeMaster) o;
            shiftRotationInfo.setUserMaster(employeeMaster.getUserMaster());
            if (employeeMaster.getShiftType().equals("ShiftBase")) {
                List<?> list = shiftRotationInfoService.readRotaionDetail(shiftRotationInfo);
                if (!list.isEmpty()) {
                    shiftRotationInfo = (ShiftRotationInfo) list.get(0);
                    Date date = new Date();
                    Calendar c = Calendar.getInstance();
                    c.setTime(date);
                    int day = c.getActualMaximum(Calendar.DAY_OF_MONTH);

                    shiftGenerateMonthlySchedule.setEmployeeMaster(employeeMaster);
                    List<?> empShiftList = shiftGenerateMonthlyScheduleService.readByEmployeeShift(shiftGenerateMonthlySchedule);

                    shiftRotationInfo.getFirstShiftId();
                    shiftRotationInfo.getShiftRotationMaster();
                    rotationMaster.setShiftRotationMaster(shiftRotationInfo.getShiftRotationMaster());
                    shiftRotationMaster = shiftRotationMasterService.readById(shiftRotationInfo.getShiftRotationMaster().getId());
                    if (shiftRotationMaster.getDuration().equals("weekly")) {
                        weeklyGenerateShift(rotationMaster, shiftRotationMaster, 7, employeeMaster);
                    } else if (shiftRotationMaster.getDuration().equals("FortNightly")) {
                        weeklyGenerate(rotationMaster, shiftRotationInfo, shiftRotationMaster, 14, employeeMaster);
                    } else if (shiftRotationMaster.getDuration().equals("Monthly") && day == 30) {
                        weeklyGenerate(rotationMaster, shiftRotationInfo, shiftRotationMaster, 30, employeeMaster);
                    } else {
                        weeklyGenerate(rotationMaster, shiftRotationInfo, shiftRotationMaster, day, employeeMaster);
                    }

                }
            }

        }

    }

    private synchronized void weeklyGenerate(RotationMaster rotationMaster, ShiftRotationInfo shiftRotationInfo, ShiftRotationMaster shiftRotationMaster, int days, EmployeeMaster employeeMaster) throws Exception {
        ShiftMaster shiftMaster = new ShiftMaster();
        ShiftGenerateMonthlySchedule shiftGenerateMonthlySchedule = new ShiftGenerateMonthlySchedule();
        ShiftGenerateMonthlySchedule shiftGenerateMonthlySchedule1 = new ShiftGenerateMonthlySchedule();

        List<List<Object>> finalList = new ArrayList<List<Object>>();
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c.setTime(date);
        c1.setTime(date);
        c1.add(Calendar.MONTH, -1);
        Date previousDate = c1.getTime();
        LocalDate localDate = previousDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int year2 = localDate.getYear();
        int month2 = localDate.getMonthValue();

        String lastMonthyear = "" + year2;
        String lastMonth = "" + month2;

        shiftGenerateMonthlySchedule1.setEmployeeMaster(employeeMaster);
        shiftGenerateMonthlySchedule1.setShiftMonth(lastMonth);
        shiftGenerateMonthlySchedule1.setShiftYear(lastMonthyear);
        List<?> empShiftList = shiftGenerateMonthlyScheduleService.readByCurrentDateWiseEmployeeShift(shiftGenerateMonthlySchedule1);
        int remainingDays = 0;
        String shiftId = "";
        int flag = 0;
        if (empShiftList.size() > 0) {
            shiftGenerateMonthlySchedule1 = (ShiftGenerateMonthlySchedule) empShiftList.get(0);
            remainingDays = shiftGenerateMonthlySchedule1.getNoOfDays();
            shiftId = "" + shiftGenerateMonthlySchedule1.getNextShiftId();
            flag = 1;
        }

        int day = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        int wk = c.get(Calendar.WEEK_OF_MONTH);
        List<Integer> rotationArray = new ArrayList<Integer>(day);

        LocalDate localDate1 = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int year1 = localDate1.getYear();
        int month1 = localDate1.getMonthValue();
        String month = "" + month1;
        String year = "" + year1;

        int currentDay = 1;
        for (int i1 = 1; i1 < currentDay; i1++) {
            rotationArray.add(0);
        }
        int count1 = 0;
        List sunday = new ArrayList();
        for (int day1 = 1; day1 <= day; day1++) {
            c2.set(year2, month2 - 1, day1);
            int dayOfWeek1 = c2.get(Calendar.DAY_OF_WEEK);
            if (dayOfWeek1 == Calendar.SUNDAY) {
                sunday.add(day1);

            }
        }
        int count = 1;
        int noOfDay = 0;
        int counter = 0;
        int i = 1;
        int flag1 = 0;
        for (int j = 1; j <= 5; j++) {
            List<?> rotationList = rotationMasterService.readFromRotation(rotationMaster);
            Iterator it = rotationList.iterator();
            while (it.hasNext()) {
                rotationMaster = (RotationMaster) it.next();
                if (flag1 != 1) {
                    if (shiftId.equals(rotationMaster.getShiftMaster().getId().toString())) {
                        if (remainingDays == 0) {
                            flag1 = 1;
                            continue;
                        }
                        flag1 = 1;
                    }

                }
                if (i > day) {
                    break;
                }
                if (flag1 == 1) {
                    for (i = currentDay; i <= day; i++) {
                        shiftMaster = shiftMasterService.readById(rotationMaster.getShiftMaster().getId());
                        if (remainingDays != counter) {
                            counter++;
                        }
                        try {
                            if (rotationArray.size() != day) {
                                Calendar cal = Calendar.getInstance();
                                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                                String newdate = i + "/" + month + "/" + year;
                                Date ddd = sdf.parse(newdate);
                                cal.setTime(ddd);
                                String weekOff11 = shiftMaster.getWeekof();
                                ArrayList<Integer> daylist = new ArrayList<Integer>();
                                for (String z : weekOff11.split(",")) {
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
                                    }
                                    daylist.add(weekOff);

//                             if (cal.get(Calendar.DAY_OF_WEEK) != weekOff) {
//                             }else{
//                                    rotationArray.add(-1);
//                             }
                                }
                                if (daylist.contains(cal.get(Calendar.DAY_OF_WEEK))) {
                                    rotationArray.add(-1);
                                } else {
                                    rotationArray.add(shiftMaster.getId());
                                }

//                                if (!sunday.contains(i)) {
//                                    rotationArray.add(shiftMaster.getId());
//                                } else {
//                                }
                            }
                        } catch (Exception ex) {
                            System.out.println("Array Size Exception" + ex);
                        }

                        if (remainingDays == counter) {
                            if (count == days) {
                                count = 1;
                                i++;
                                currentDay = i;
                                noOfDay = days;
                                break;
                            }

                            noOfDay = count;
                            count++;
                            if (flag == 1 & remainingDays != 0) {
                                count--;
                                flag = 0;
                            }
                        }
                    }
                }
            }

        }

//        }
//        Iterator it1 = finalList.iterator()
//        count = count + 1;
//        int noOfDay = count;
        int totalNoOfDay = days - noOfDay;
        shiftGenerateMonthlySchedule.setNoOfDays(totalNoOfDay);
        shiftGenerateMonthlySchedule.setNextShiftId(shiftMaster.getId());
        shiftGenerateMonthlySchedule.setShiftMonth(month);
        shiftGenerateMonthlySchedule.setShiftYear(year);
        shiftGenerateMonthlySchedule.setShiftRotationMaster(shiftRotationMaster);
        shiftGenerateMonthlySchedule.setEmployeeMaster(employeeMaster);

//        if (rotationArray.size() == 30) {
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
    }

    private synchronized void timeEntryDaily() throws Exception {

        EmployeeShiftData employeeShiftData = new EmployeeShiftData();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        UserMaster userMaster = new UserMaster();
        EmployeeDatetimeData employeeDatetimeData1 = new EmployeeDatetimeData();
//        userMaster.setId(1614);
//        employeeMaster.setUserMaster(userMaster);
//        List<?> empList = employeeMasterService.readByEmployeeUserId(employeeMaster);

//        List<?> empList = employeeMasterService.read();
        List<?> empList = employeeDatetimeDataService.readEmployeeByCurrentDate();
        for (Object zz : empList) {
            try {
//                employeeMaster = (EmployeeMaster) zz;
                employeeDatetimeData1 = (EmployeeDatetimeData) zz;
                employeeMaster.setId(employeeDatetimeData1.getEmployeeMaster().getId());

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
                    String dynamicShiftDateTime = employeeDatetimeData1.getDateTime();
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
                        List<?> employeeYesterdayPunchData = employeeDatetimeDataService.readYesterdayEmployeeData("" + employeeMaster.getId());

                        if (!employeeYesterdayPunchData.isEmpty()) {
                            EmployeeDatetimeData employeeDatetimeData = (EmployeeDatetimeData) employeeYesterdayPunchData.get(0);
                            EmployeeDatetimeData employeeDatetimeData2 = (EmployeeDatetimeData) employeeYesterdayPunchData.get(employeeYesterdayPunchData.size() - 1);
                            String startPunchTime = employeeDatetimeData.getDateTime();
                            String endPunchTime = employeeDatetimeData2.getDateTime();
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

                    employeeShiftPunchList = employeeDatetimeDataService.readTodaysAndPreviousData("" + employeeMaster.getId(), newShiftTime);

                    for (Object o : employeeShiftPunchList) {
                        EmployeeDatetimeData employeeDatetimeData = (EmployeeDatetimeData) o;
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
                            String[] splited1 = employeeDatetimeData.getDateTime().split(" ");
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
                                    employeeShiftData1.setOutDateTime(employeeDatetimeData.getDateTime());
                                    employeeShiftDataService.createOrUpdate(employeeShiftData1);
                                } else {
                                    employeeShiftData1.setInDateTime(employeeDatetimeData.getDateTime());
                                    employeeShiftData1.setOutDateTime(employeeDatetimeData.getDateTime());
                                    employeeShiftDataService.create(employeeShiftData1);
                                }
                            } else {
                                employeeShiftData1.setOutDateTime(employeeDatetimeData.getDateTime());
                                employeeShiftDataService.createOrUpdate(employeeShiftData1);
                            }
                        } else {
                            employeeShiftData1.setInDateTime(employeeDatetimeData.getDateTime());
                            employeeShiftData1.setOutDateTime(employeeDatetimeData.getDateTime());
                            employeeShiftDataService.createOrUpdate(employeeShiftData1);
                        }

                    }

                } else {
                    employeeShiftPunchList = employeeDatetimeDataService.readTodaysEmployeeData("" + employeeMaster.getId());
                    for (Object o : employeeShiftPunchList) {
                        EmployeeDatetimeData employeeDatetimeData = (EmployeeDatetimeData) o;
                        EmployeeShiftData employeeShiftData1 = new EmployeeShiftData();
                        List dayWiseShiftList = new ArrayList();
                        employeeShiftData.setEmployeeMaster(employeeMaster);
                        employeeShiftData1.setEmployeeMaster(employeeMaster);
                        employeeShiftData1.setShiftMaster(shiftMaster1);
                        dayWiseShiftList = employeeShiftDataService.dailyTimeEntry(employeeShiftData);
                        if (!dayWiseShiftList.isEmpty()) {
                            employeeShiftData1 = (EmployeeShiftData) dayWiseShiftList.get(0);
                            employeeShiftData.setInDateTime(employeeShiftData1.getInDateTime());
                            employeeShiftData1.setOutDateTime(employeeDatetimeData.getDateTime());
                            employeeShiftDataService.createOrUpdate(employeeShiftData1);
                        } else {
                            employeeShiftData1.setInDateTime(employeeDatetimeData.getDateTime());
                            employeeShiftData1.setOutDateTime(employeeDatetimeData.getDateTime());
                            employeeShiftDataService.createOrUpdate(employeeShiftData1);
                        }

                    }

                }
            } catch (Exception e) {
                System.out.println("Exception" + e.getMessage());
            }
        }

    }

    private synchronized void overTimeEntry() throws Exception {
        List<?> list = employeeShiftDataService.todaysData();
        if (!list.isEmpty()) {
            for (Object o : list) {

                EmployeeShiftData employeeShiftData = (EmployeeShiftData) o;
                ShiftMaster shiftMaster = new ShiftMaster();
                employeeShiftData.getEmployeeMaster();
                int id = employeeShiftData.getShiftMaster().getId();
                shiftMaster = shiftMasterService.readById(id);
                String shiftStartDate = shiftMaster.getStartTime().trim();
                String shiftEndDate = shiftMaster.getEndTime().trim();
                String firstHalfEndDate = shiftMaster.getHalfEndTime1().trim();
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/YYYY");
                Calendar cal1 = Calendar.getInstance();
                Calendar cal2 = Calendar.getInstance();
                Calendar cal7 = Calendar.getInstance();
                Date date1 = new Date();
                String s = formatter.format(date1);
                Date date = formatter.parse(s);
                int hour = Integer.parseInt(shiftStartDate.split(":")[0]);
                int minute = Integer.parseInt(shiftStartDate.split(":")[1]);
                int hour1 = Integer.parseInt(shiftEndDate.split(":")[0]);
                int minute1 = Integer.parseInt(shiftEndDate.split(":")[1]);
                int hour2 = Integer.parseInt(firstHalfEndDate.split(":")[0]);
                int minute2 = Integer.parseInt(firstHalfEndDate.split(":")[1]);
                cal1.setTime(date);
                cal2.setTime(date);
                cal7.setTime(date);

                cal1.set(Calendar.HOUR, hour);
                cal1.set(Calendar.MINUTE, minute);
                cal2.set(Calendar.HOUR, hour1);
                cal2.set(Calendar.MINUTE, minute1);

                cal7.set(Calendar.HOUR, hour2);
                cal7.set(Calendar.MINUTE, minute2);

                long difference = cal2.getTime().getTime() - cal1.getTime().getTime();
                String empStartTime = employeeShiftData.getInDateTime();
                String empEndTime = employeeShiftData.getOutDateTime();

                Date date3 = format.parse(empStartTime);
                Date date4 = format.parse(empEndTime);
                Calendar cal3 = Calendar.getInstance();
                Calendar cal4 = Calendar.getInstance();
                cal3.setTime(date3);
                cal4.setTime(date4);

                Calendar cal5 = Calendar.getInstance();
                Date satdate = formatter.parse(empStartTime);
                cal5.setTime(satdate);
                SimpleDateFormat format2 = new SimpleDateFormat("EEEE");
                String dayName = format2.format(date);
                int dayOfWeek = cal5.get(Calendar.WEEK_OF_MONTH);

                EmployeeLeaveBalance employeeLeaveBalance = new EmployeeLeaveBalance();
                EmployeeLeaveBalance employeeLeaveBalance1 = new EmployeeLeaveBalance();
                String coff = "C Off Leave";
                LeaveTypeMaster leaveTypeMaster = new LeaveTypeMaster();
                List<?> coffList = leaveTypeMasterService.readLeaveType(coff);
                if (!coffList.isEmpty()) {
                    leaveTypeMaster = (LeaveTypeMaster) coffList.get(0);
                }

                employeeLeaveBalance.setLeaveTypeMaster(leaveTypeMaster);
                employeeLeaveBalance.setEmployeeMaster(employeeShiftData.getEmployeeMaster());
                EmployeeMaster employeeMaster = new EmployeeMaster();
                employeeMaster = employeeMasterService.readById(employeeShiftData.getEmployeeMaster().getId());
                int levelId = employeeMaster.getLevelMaster().getId();
                LevelMaster levelMaster = new LevelMaster();
                levelMaster = levelMasterService.readById(levelId);

                int zydexLocationId = employeeMaster.getZydexLocationMaster().getId();
                ZydexLocationMaster zydexLocationMaster = new ZydexLocationMaster();
                zydexLocationMaster = zydexLocationMasterService.readById(zydexLocationId);
                String zydexLocationName = zydexLocationMaster.getZydexLocation();

                if (zydexLocationName.equals("HO") || zydexLocationName.equals("R&D")) {
                    if (dayName.equals("Saturday") && dayOfWeek == 2) {
                        difference = cal2.getTime().getTime() - cal7.getTime().getTime();
                    }
                }

                long difference2 = cal4.getTime().getTime() - cal3.getTime().getTime();
                long mainDiff = difference2 - difference;
                long diffMin1 = ((mainDiff / 1000) / 60) / 60;
                String time = "";
                String time2 = "";
                if (!zydexLocationName.equals("HO") && !zydexLocationName.equals("R&D")) {
                    if (diffMin1 >= 3 && diffMin1 <= 5.9) {
                        time = "0.3";
                    } else if (diffMin1 >= 6 && diffMin1 <= 8.9) {
                        time = "0.5";
                    } else if (diffMin1 >= 9) {
                        time = "0.8";
                    }
                } else {
                    if (diffMin1 >= 3.6 && diffMin1 <= 5.5) {
                        time2 = "0.4";
                    } else if (diffMin1 >= 8) {
                        time2 = "0.8";
                    }
                }

                if (!zydexLocationName.equals("HO") && !zydexLocationName.equals("R&D")) {
                    if (!time.equals("")) {
                        if (levelMaster.getLevel().contains("4") || levelMaster.getLevel().contains("5")) {
                            List<?> empBalList = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance);
                            if (!empBalList.isEmpty()) {
                                employeeLeaveBalance1 = (EmployeeLeaveBalance) empBalList.get(0);
                                float time1 = employeeLeaveBalance1.getNoOfLeaveRemain();
                                time1 = time1 + Float.parseFloat(time);
                                employeeLeaveBalance1.setNoOfLeaveRemain(time1);
                                employeeLeaveBalanceService.update(employeeLeaveBalance1);
                            } else {
                                employeeLeaveBalance1.setLeaveTypeMaster(leaveTypeMaster);
                                employeeLeaveBalance1.setEmployeeMaster(employeeShiftData.getEmployeeMaster());
                                employeeLeaveBalance1.setNoOfLeaveRemain(Float.parseFloat(time));
                                employeeLeaveBalanceService.create(employeeLeaveBalance1);
                            }
                            Date date5 = new Date();
                            String todayDate = formatter.format(date5);
                            OverTimeMaster overTimeMaster = new OverTimeMaster();
                            overTimeMaster.setEmployeeMaster(employeeShiftData.getEmployeeMaster());
                            overTimeMaster.setDate(todayDate);
                            overTimeMaster.setTime(time);
                            overTimeMasterService.create(overTimeMaster);
                        }

                    }
                } else if (levelMaster.getLevel().contains("4") || levelMaster.getLevel().contains("5")) {
                    if (!time2.equals("")) {
                        List<?> empBalList = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance);
                        if (!empBalList.isEmpty()) {
                            employeeLeaveBalance1 = (EmployeeLeaveBalance) empBalList.get(0);
                            float time1 = employeeLeaveBalance1.getNoOfLeaveRemain();
                            time1 = time1 + Float.parseFloat(time2);
                            employeeLeaveBalance1.setNoOfLeaveRemain(time1);
                            employeeLeaveBalanceService.update(employeeLeaveBalance1);
                        } else {
                            employeeLeaveBalance1.setLeaveTypeMaster(leaveTypeMaster);
                            employeeLeaveBalance1.setEmployeeMaster(employeeShiftData.getEmployeeMaster());
                            employeeLeaveBalance1.setNoOfLeaveRemain(Float.parseFloat(time2));
                            employeeLeaveBalanceService.create(employeeLeaveBalance1);
                        }

                        Date date5 = new Date();
                        String todayDate = formatter.format(date5);
                        OverTimeMaster overTimeMaster = new OverTimeMaster();
                        overTimeMaster.setEmployeeMaster(employeeShiftData.getEmployeeMaster());
                        overTimeMaster.setDate(todayDate);
                        overTimeMaster.setTime(time2);
                        overTimeMasterService.create(overTimeMaster);
                    }

                }

            }
        } else {
            List<?> empList = employeeMasterService.read();
            EmployeeMaster employeeMaster = new EmployeeMaster();
            for (Object zz : empList) {
                employeeMaster = (EmployeeMaster) zz;
                List<?> list1 = employeeDatetimeDataService.todaysData(employeeMaster.getId());
                SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                String startTime1 = "";
                String endTime1 = "";
                if (list1.size() > 2) {
                    Object[] startTime = (Object[]) list1.get(0);
                    Object[] endTime = (Object[]) list1.get(list1.size() - 1);
                    startTime1 = (String) startTime[0];
                    endTime1 = (String) endTime[0];
                    Date dateStrTime = sdf3.parse(startTime1);
                    Date dateEndTime = sdf3.parse(endTime1);
                    long diff = dateEndTime.getTime() - dateStrTime.getTime();
                    long mainDiff = diff / (60 * 1000);
                    long diffMin1 = ((mainDiff / 1000) / 60) / 60;
                    String time2 = "";
                    if (diffMin1 >= 3.6 && diffMin1 <= 5.5) {
                        time2 = "0.4";
                    } else if (diffMin1 >= 8) {
                        time2 = "0.8";
                    }
                    EmployeeLeaveBalance employeeLeaveBalance = new EmployeeLeaveBalance();
                    EmployeeLeaveBalance employeeLeaveBalance1 = new EmployeeLeaveBalance();
                    String coff = "C Off Leave";
                    LeaveTypeMaster leaveTypeMaster = new LeaveTypeMaster();
                    List<?> coffList = leaveTypeMasterService.readLeaveType(coff);
                    if (!coffList.isEmpty()) {
                        leaveTypeMaster = (LeaveTypeMaster) coffList.get(0);
                    }
                    employeeLeaveBalance.setLeaveTypeMaster(leaveTypeMaster);
                    employeeLeaveBalance.setEmployeeMaster(employeeMaster);
                    int levelId = employeeMaster.getLevelMaster().getId();
                    LevelMaster levelMaster = new LevelMaster();
                    levelMaster = levelMasterService.readById(levelId);

                    int zydexLocationId = employeeMaster.getZydexLocationMaster().getId();
                    ZydexLocationMaster zydexLocationMaster = new ZydexLocationMaster();
                    zydexLocationMaster = zydexLocationMasterService.readById(zydexLocationId);
                    String zydexLocationName = zydexLocationMaster.getZydexLocation();
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/YYYY");
                    if (zydexLocationName.equals("HO") || zydexLocationName.equals("R&D")) {
                        if (levelMaster.getLevel().contains("4") || levelMaster.getLevel().contains("5")) {
                            if (!time2.equals("")) {
                                List<?> empBalList = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance);
                                if (!empBalList.isEmpty()) {
                                    employeeLeaveBalance1 = (EmployeeLeaveBalance) empBalList.get(0);
                                    float time1 = employeeLeaveBalance1.getNoOfLeaveRemain();
                                    time1 = time1 + Float.parseFloat(time2);
                                    employeeLeaveBalance1.setNoOfLeaveRemain(time1);
                                    employeeLeaveBalanceService.update(employeeLeaveBalance1);
                                } else {
                                    employeeLeaveBalance1.setLeaveTypeMaster(leaveTypeMaster);
                                    employeeLeaveBalance1.setEmployeeMaster(employeeMaster);
                                    employeeLeaveBalance1.setNoOfLeaveRemain(Float.parseFloat(time2));
                                    employeeLeaveBalanceService.create(employeeLeaveBalance1);
                                }

                                Date date5 = new Date();
                                String todayDate = formatter.format(date5);
                                OverTimeMaster overTimeMaster = new OverTimeMaster();
                                overTimeMaster.setEmployeeMaster(employeeMaster);
                                overTimeMaster.setDate(todayDate);
                                overTimeMaster.setTime(time2);
                                overTimeMasterService.create(overTimeMaster);
                            }

                        }
                    }

                }
            }

        }

    }

    private synchronized void coffDelete() throws Exception {

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/YYYY");
        Calendar c = Calendar.getInstance();
        Date currentDate = new Date();
        String s = formatter.format(currentDate);
        Date curDate = formatter.parse(s);

        List<?> coffDeleteList = overTimeMasterService.read();
        for (Object o : coffDeleteList) {
            OverTimeMaster overTimeMaster = (OverTimeMaster) o;
            int empId = overTimeMaster.getEmployeeMaster().getId();
            EmployeeMaster employeeMaster = new EmployeeMaster();
            employeeMaster = employeeMasterService.readById(empId);
            int zydexLocationId = employeeMaster.getZydexLocationMaster().getId();
            ZydexLocationMaster zydexLocationMaster = new ZydexLocationMaster();
            zydexLocationMaster = zydexLocationMasterService.readById(zydexLocationId);
            String zydexLocationName = zydexLocationMaster.getZydexLocation();
            if (zydexLocationName.equals("HO") || zydexLocationName.equals("R&D")) {
                String coffDate = overTimeMaster.getDate();
                Date date1 = formatter.parse(coffDate);
                c.setTime(date1);
                c.add(Calendar.DATE, 30);
                Date coffAddDate = c.getTime();
                if (coffAddDate.after(curDate)) {
                    EmployeeLeaveBalance employeeLeaveBalance = new EmployeeLeaveBalance();
                    EmployeeLeaveBalance employeeLeaveBalance1 = new EmployeeLeaveBalance();
                    String time = overTimeMaster.getTime();
                    String coff = "C Off Leave";
                    LeaveTypeMaster leaveTypeMaster = new LeaveTypeMaster();
                    List<?> coffList = leaveTypeMasterService.readLeaveType(coff);
                    if (!coffList.isEmpty()) {
                        leaveTypeMaster = (LeaveTypeMaster) coffList.get(0);
                    }
                    employeeLeaveBalance.setLeaveTypeMaster(leaveTypeMaster);
                    employeeLeaveBalance.setEmployeeMaster(overTimeMaster.getEmployeeMaster());
                    List<?> empBalList = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance);
                    if (!empBalList.isEmpty()) {
                        employeeLeaveBalance1 = (EmployeeLeaveBalance) empBalList.get(0);
                        float time1 = employeeLeaveBalance1.getNoOfLeaveRemain();
                        float time2 = time1 - Float.parseFloat(time);
                        employeeLeaveBalance1.setNoOfLeaveRemain(time2);
                        employeeLeaveBalanceService.update(employeeLeaveBalance1);
                        overTimeMasterService.delete(overTimeMaster.getId());
                    }

                }
            }
            if (!zydexLocationName.equals("HO") && !zydexLocationName.equals("R&D")) {
                String coffDate = overTimeMaster.getDate();
                Date date1 = formatter.parse(coffDate);
                c.setTime(date1);
                c.add(Calendar.DATE, 90);
                Date coffAddDate = c.getTime();
                if (coffAddDate.after(curDate)) {
                    EmployeeLeaveBalance employeeLeaveBalance = new EmployeeLeaveBalance();
                    EmployeeLeaveBalance employeeLeaveBalance1 = new EmployeeLeaveBalance();
                    String time = overTimeMaster.getTime();
                    String coff = "C Off Leave";
                    LeaveTypeMaster leaveTypeMaster = new LeaveTypeMaster();
                    List<?> coffList = leaveTypeMasterService.readLeaveType(coff);
                    if (!coffList.isEmpty()) {
                        leaveTypeMaster = (LeaveTypeMaster) coffList.get(0);
                    }
                    employeeLeaveBalance.setLeaveTypeMaster(leaveTypeMaster);
                    employeeLeaveBalance.setEmployeeMaster(overTimeMaster.getEmployeeMaster());
                    List<?> empBalList = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance);
                    if (!empBalList.isEmpty()) {
                        employeeLeaveBalance1 = (EmployeeLeaveBalance) empBalList.get(0);
                        float time1 = employeeLeaveBalance1.getNoOfLeaveRemain();
                        time1 = time1 - Float.parseFloat(time);
                        employeeLeaveBalance1.setNoOfLeaveRemain(time1);
                        employeeLeaveBalanceService.update(employeeLeaveBalance1);
                    }

                }

            }
        }
    }

    public ModelAndView employeeDataSearch(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeShiftData employeeShiftData = new EmployeeShiftData();
        EmployeeAdvanceSearch employeeAdvanceSearch = new EmployeeAdvanceSearch();
        selectEmployee1(request, response);
        selectZydexLocation(request, response);
        selectLevel(request, response);
        department(request, response);
        mv.getModelMap().put("employeeAdvanceSearch", employeeAdvanceSearch);
        mv.setViewName("Shift/EmployeeOrDateWiseShiftSearch");

        return mv;
    }

    public ModelAndView employeeDataSearchSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeShiftData employeeShiftData = new EmployeeShiftData();
        EmployeeAdvanceSearch employeeAdvanceSearch = new EmployeeAdvanceSearch();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        String empId = request.getParameter("employeeMasterId");
        String zydexLocationId = request.getParameter("zydexLocationId");
        String levelId = request.getParameter("levelId");
        String departmentId = request.getParameter("departmentId");

        String dojStartDate = request.getParameter("dojStartDate");
        String dojEndDate = request.getParameter("dojEndDate");

        String startDate = request.getParameter("inDateTime");
        String endDate = request.getParameter("outDateTime");
        bind(request, employeeAdvanceSearch);
        String searchval = request.getParameter("vallist");
        if (null != searchval && request.getParameter("vallist").toString().equals("other")) {
            employeeAdvanceSearch.setId(null);
            employeeAdvanceSearch.setZydexLocationId(zydexLocationId);
            employeeAdvanceSearch.setLevelID(levelId);
            employeeAdvanceSearch.setDepartmentId(departmentId);
        } else {
            employeeAdvanceSearch.setId(empId);
            employeeAdvanceSearch.setZydexLocationId(null);
            employeeAdvanceSearch.setLevelID(null);
            employeeAdvanceSearch.setDepartmentId(null);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        if (null != empId && !empId.equals("")) {
            employeeShiftData.setId(Integer.parseInt(empId));
        }
        if (null != startDate && !startDate.equals("")) {
            Date sDate = sdf.parse(startDate);
//            "2012-01-01"
            employeeShiftData.setInDateTime(new SimpleDateFormat("yyyy-MM-dd").format(sDate));

        }
        if (null != endDate && !endDate.equals("")) {
            Date eDate = sdf.parse(endDate);
            employeeShiftData.setOutDateTime(new SimpleDateFormat("yyyy-MM-dd").format(eDate));
        }

        List<?> empDetail = employeeMasterService.empOrDateWiseSearch(employeeAdvanceSearch);
        Map<Integer, List<?>> map = new LinkedHashMap<Integer, List<?>>();
        Map<Integer, List<?>> map1 = new LinkedHashMap<Integer, List<?>>();
        for (Object o1 : empDetail) {
            Object[] o = (Object[]) o1;
            int id = (Integer) o[38];
            employeeShiftData.setId(id);
            List<?> list = employeeShiftDataService.empOrDateWiseSearch(employeeShiftData);
//            List listPunch = employeeDatetimeDataService.readPuchDataEmpIdWise(id);
            map.put(id, list);
//            map1.put(id, listPunch);
        }

        response.setContentType("application/vnd.ms-excel");
//        response.setHeader("Content-Transfer-Encoding", "7bit");
        response.setHeader("Content-Disposition", "attachment; filename=EmployeeAdvanceSearch.xls");
        mv.getModelMap().put("empDetail", empDetail);
        mv.getModelMap().put("map", map);
//        mv.getModelMap().put("map1", map1);
        mv.getModelMap().put("employeeAdvanceSearch", employeeAdvanceSearch);
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.setViewName("Shift/EmployeeOrDateShiftWiseResult");

        return mv;
    }

    public void readShiftRotationNameAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PrintWriter out = response.getWriter();
        ShiftRotationMaster shiftRotationMaster = new ShiftRotationMaster();
        String shiftRotationName = request.getParameter("shiftRotationName");
        shiftRotationMaster.setTitle(shiftRotationName);
        List<?> list = shiftRotationMasterService.checkByShiftRotationName(shiftRotationMaster);

        boolean flag = true;
        if (!list.isEmpty()) {
            flag = false;
        }
        out.print(flag);
    }

    public ModelAndView employeeAttandanceDataSearch(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeShiftData employeeShiftData = new EmployeeShiftData();
        EmployeeAdvanceSearch employeeAdvanceSearch = new EmployeeAdvanceSearch();
        selectEmployee1(request, response);
        selectZydexLocation(request, response);
        selectLevel(request, response);
        department(request, response);
        mv.getModelMap().put("employeeAdvanceSearch", employeeAdvanceSearch);
        mv.setViewName("Shift/EmployeeAttandanceDateWiseSearch");

        return mv;
    }

    public ModelAndView employeeAttandanceDataSearchSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeShiftData employeeShiftData = new EmployeeShiftData();
        LeaveEmployeeDetail leaveEmployeeDetail = new LeaveEmployeeDetail();
        EmployeeAdvanceSearch employeeAdvanceSearch = new EmployeeAdvanceSearch();
        AttendanceRegularization attendanceRegularization = new AttendanceRegularization();
        TravelRequestMaster travelRequestMaster = new TravelRequestMaster();

        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        HolidayMaster holidayMaster = new HolidayMaster();
        String empId = request.getParameter("employeeMasterId");
        String zydexLocationId = request.getParameter("zydexLocationId");
        String levelId = request.getParameter("levelId");
        String departmentId = request.getParameter("departmentId");
        String startDate = request.getParameter("inDateTime");
        String endDate = request.getParameter("outDateTime");
        bind(request, employeeAdvanceSearch);
        String searchval = request.getParameter("vallist");
        if (null != searchval && request.getParameter("vallist").toString().equals("other")) {
            employeeAdvanceSearch.setId(null);
            employeeAdvanceSearch.setZydexLocationId(zydexLocationId);
            employeeAdvanceSearch.setLevelID(levelId);
            employeeAdvanceSearch.setDepartmentId(departmentId);
        } else {
            employeeAdvanceSearch.setId(empId);
            employeeAdvanceSearch.setZydexLocationId(null);
            employeeAdvanceSearch.setLevelID(null);
            employeeAdvanceSearch.setDepartmentId(null);
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat tm = new SimpleDateFormat("HH:mm");
        if (!empId.equals("")) {
            employeeShiftData.setId(Integer.parseInt(empId));
        }
        if (!startDate.equals("")) {
            Date sDate = sdf.parse(startDate);
//            "2012-01-01"
            employeeShiftData.setInDateTime(new SimpleDateFormat("yyyy-MM-dd").format(sDate));
            leaveEmployeeDetail.setApproveDate(new SimpleDateFormat("yyyy-MM-dd").format(sDate));
            Calendar c = Calendar.getInstance();
            c.setTime(sDate);
            c.add(Calendar.MONTH, -1);
            Date previousDate = c.getTime();
            String previouSMonthdate = sdf.format(previousDate);

            leaveEmployeeDetail.setStartDate(new SimpleDateFormat("yyyy-MM-dd").format(previousDate));
            holidayMaster.setHolidayFromDate(new SimpleDateFormat("yyyy-MM-dd").format(sDate));
            attendanceRegularization.setApprovedDate(startDate);
            attendanceRegularization.setEndDateTime(previouSMonthdate);

            travelRequestMaster.setStartDateTime(new SimpleDateFormat("yyyy-MM-dd").format(sDate));
            travelRequestMaster.setAdminRemark(new SimpleDateFormat("yyyy-MM-dd").format(previousDate));

        }
        if (!endDate.equals("")) {
            Date eDate = sdf.parse(endDate);
            Calendar c = Calendar.getInstance();
            c.setTime(eDate);
            c.add(Calendar.MONTH, -1);
            c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
            Date previousDate = c.getTime();
            String previouSMonthdate = sdf.format(previousDate);

            employeeShiftData.setOutDateTime(new SimpleDateFormat("yyyy-MM-dd").format(eDate));
            holidayMaster.setHolidayToDate(new SimpleDateFormat("yyyy-MM-dd").format(eDate));

            leaveEmployeeDetail.setEndDate(new SimpleDateFormat("yyyy-MM-dd").format(eDate));
            leaveEmployeeDetail.setEndDateStatus(new SimpleDateFormat("yyyy-MM-dd").format(previousDate));

            travelRequestMaster.setEndDateTime(new SimpleDateFormat("yyyy-MM-dd").format(eDate));
            travelRequestMaster.setEmpRemark(new SimpleDateFormat("yyyy-MM-dd").format(previousDate));
        }

        List<?> empDetail = employeeMasterService.empAttendanceDataSearch(employeeAdvanceSearch);
        Map<Integer, List<?>> map = new LinkedHashMap<Integer, List<?>>();
        Map<Integer, List<?>> map1 = new LinkedHashMap<Integer, List<?>>();
        for (Object o1 : empDetail) {
            Object[] o = (Object[]) o1;
            List<List<?>> li = new LinkedList<List<?>>();
            List<String> holidayList = new LinkedList<String>();
            int id = (Integer) o[4];
            employeeShiftData.setId(id);
            employeeMaster1.setId(id);
            attendanceRegularization.setUserMasterId(id);
            holidayMaster.setId(id);
            travelRequestMaster.setEmployeeMasterByEmployeeMasterId(employeeMaster1);
            leaveEmployeeDetail.setEmployeeMaster(employeeMaster1);

            List<?> list = employeeShiftDataService.empOrDateWiseSearch(employeeShiftData);

//            int holidayCount = holidayMasterService.searchMonthWiseHoliday(holidayMaster);
            List<?> empMonthWiseLeave = leaveEmployeeDetailService.searchLeaveApproveOfEmployeeByMonthWise(leaveEmployeeDetail);
            List<?> empLastMonthWiseLeave = leaveEmployeeDetailService.searchLeaveApproveOfEmployeeByPreviousMonthWise(leaveEmployeeDetail);
            List<?> attendanceRegularizationCurMonth = attendanceRegularizationMasterService.searchLeaveApproveOfEmployeeByMonthWise(attendanceRegularization);
            List<?> attendanceRegularizationPreMonth = attendanceRegularizationMasterService.searchLeaveApproveOfEmployeeByPreviousMonthWise(attendanceRegularization);
            List<?> travelCurrentMonthList = travelRequestMasterService.searchTravelApproveOfEmployeeByCurrentMonthWise(travelRequestMaster);
            List<?> travelPreviousMonthList = travelRequestMasterService.searchTravelApproveOfEmployeeByPreviousMonthWise(travelRequestMaster);

//            holidayList.add("" + holidayCount);
            li.add(holidayList);
            li.add(empMonthWiseLeave);
            li.add(empLastMonthWiseLeave);
            li.add(attendanceRegularizationCurMonth);
            li.add(attendanceRegularizationPreMonth);
            li.add(travelPreviousMonthList);
            li.add(travelCurrentMonthList);

            map.put(id, list);
            map1.put(id, li);
        }
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=EmployeeAttendance.xls");
        mv.getModelMap().put("empDetail", empDetail);
        mv.getModelMap().put("map", map);
        mv.getModelMap().put("map1", map1);
        mv.getModelMap().put("employeeAdvanceSearch", employeeAdvanceSearch);
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.setViewName("Shift/EmployeeAttandanceDateWiseResult");
        return mv;
    }

    private void weeklyGenerateShift(RotationMaster rotationMaster, ShiftRotationMaster shiftRotationMaster, int days, EmployeeMaster employeeMaster) throws Exception {
        ShiftMaster shiftMaster = new ShiftMaster();
        ShiftMaster shiftMasterForLastDayOfMonth = new ShiftMaster();

        ShiftGenerateMonthlySchedule shiftGenerateMonthlySchedule = new ShiftGenerateMonthlySchedule();
        ShiftGenerateMonthlySchedule shiftGenerateMonthlyScheduleOfCurrentMonth = new ShiftGenerateMonthlySchedule();
        ShiftGenerateMonthlySchedule shiftGenerateMonthlyScheduleOfCurrentMonthRead = new ShiftGenerateMonthlySchedule();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = Calendar.getInstance();
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        Date rd = new Date();
        c.setTime(rd);
        int day = c.getActualMaximum(Calendar.DAY_OF_MONTH);

        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        LocalDate localDate = rd.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int year = localDate.getYear();
        int month = localDate.getMonthValue();
        int dayofmonth = localDate.getDayOfMonth();
        int nMonth = month;
        if (month == 12) {
            nMonth = 1;
        } else {
            nMonth = month + 1;
        }
        int nYear = year + 1;
        String nextMonth = "" + nMonth;
        String nextYear = "" + nYear;

        Date today = new Date();
        String newDate = sdf.format(today);
        Date ss = sdf.parse(newDate);
        c2.setTime(ss);
        int currentMonth = (c.get(Calendar.MONTH)) + 1;
        int daysOfCuurentMOnth = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        int currentYear = c.get(Calendar.YEAR);
        c.add(Calendar.MONTH, 1);//add one month to current month for next month;
        int daysOfNextMOnth = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        List<Integer> rotationArray = new ArrayList<Integer>(daysOfNextMOnth);
        String shiftMasterId = "";
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
        shiftGenerateMonthlyScheduleOfCurrentMonthRead.setEmployeeMaster(employeeMaster);
        shiftGenerateMonthlyScheduleOfCurrentMonthRead.setShiftMonth(cmonth);
        shiftGenerateMonthlyScheduleOfCurrentMonthRead.setShiftYear(cyear);
        List<?> list = shiftGenerateMonthlyScheduleService.readByCurrentDateWiseEmployeeShift(shiftGenerateMonthlyScheduleOfCurrentMonthRead);
        if (!list.isEmpty()) {
            shiftGenerateMonthlyScheduleOfCurrentMonth = (ShiftGenerateMonthlySchedule) list.get(0);
            shiftMasterId = "" + shiftGenerateMonthlyScheduleOfCurrentMonth.getNextShiftId();
        }
        int flag1 = 0;
        int count = dayOfWeek;
        int noOfDay = 0;
        int i = 1;
        int shiftMasterIdCheckCounter = 0;
        int shiftMasterIdCheckTemp = 0;
        int lastDayOfCurrentMonth = daysOfNextMOnth;
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

            for (i = 1; i <= daysOfNextMOnth; i++) {
                shiftMaster = shiftMasterService.readById(shiftMasterIdList.get(shiftMasterIdCheckCounter));
                try {
                    if (rotationArray.size() != daysOfNextMOnth) {
                        String newdate = "";
                        Calendar cal = Calendar.getInstance();
                        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
                        if ("12".equals(cmonth)) {//means its last month
                            newdate = i + "/" + nMonth + "/" + nYear;
                        } else {
                            newdate = i + "/" + nMonth + "/" + currentYear;
                        }
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
        shiftGenerateMonthlySchedule.setShiftMonth(nextMonth);
        if ("12".equals(cmonth)) {//means its last month
            shiftGenerateMonthlySchedule.setShiftYear(nextYear);
        } else {
            shiftGenerateMonthlySchedule.setShiftYear(cyear);
        }
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
            if (daysOfNextMOnth == 29) {
                shiftGenerateMonthlySchedule.setDay29(rotationArray.get(28));
            }
            if (daysOfNextMOnth == 30) {
                shiftGenerateMonthlySchedule.setDay29(rotationArray.get(28));
                shiftGenerateMonthlySchedule.setDay30(rotationArray.get(29));
            }
            if (daysOfNextMOnth == 31) {
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

    public ModelAndView employeeDataExcelSheet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = new EmployeeMaster();

        String empId = request.getParameter("employeeMasterId");
        String zydexLocationId = request.getParameter("zydexLocationId");
        String levelId = request.getParameter("levelId");
        String departmentId = request.getParameter("departmentId");
        String startDate = request.getParameter("inDateTime");
        String endDate = request.getParameter("outDateTime");
        String searchval = request.getParameter("vallist");

        EmployeeAdvanceSearch employeeAdvanceSearch = new EmployeeAdvanceSearch();
        bind(request, employeeAdvanceSearch);
        if (null != searchval && request.getParameter("vallist").toString().equals("other")) {
            employeeAdvanceSearch.setId(null);
            employeeAdvanceSearch.setZydexLocationId(zydexLocationId);
            employeeAdvanceSearch.setLevelID(levelId);
            employeeAdvanceSearch.setDepartmentId(departmentId);
        } else {
            employeeAdvanceSearch.setId(empId);
            employeeAdvanceSearch.setZydexLocationId(null);
            employeeAdvanceSearch.setLevelID(null);
            employeeAdvanceSearch.setDepartmentId(null);
        }

        int rownum = 0;
        HSSFWorkbook firstFWorkbook = new HSSFWorkbook();
        HSSFSheet firstSheet = firstFWorkbook.createSheet("FIRST SHEET");
        Row headerRow = firstSheet.createRow(rownum);
        headerRow.setHeightInPoints(40);
        HSSFFont redFont = firstFWorkbook.createFont();
        redFont.setColor(HSSFColor.RED.index);
        HSSFCellStyle stylered = firstFWorkbook.createCellStyle();
        stylered.setFont(redFont);

        HSSFFont greenFont = firstFWorkbook.createFont();
        greenFont.setColor(HSSFColor.GREEN.index);
        HSSFCellStyle stylegreen = firstFWorkbook.createCellStyle();
        stylegreen.setFont(greenFont);

        HSSFFont blueFont = firstFWorkbook.createFont();
        blueFont.setColor(HSSFColor.BLUE.index);
        HSSFCellStyle styleblue = firstFWorkbook.createCellStyle();
        styleblue.setFont(blueFont);

        HSSFFont boldFont = firstFWorkbook.createFont();
        boldFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
        HSSFCellStyle styleBold = firstFWorkbook.createCellStyle();
        styleBold.setFont(boldFont);

        List<String> headerRow1 = new ArrayList();
        if (employeeAdvanceSearch.getEmployeeId() == true) {
            headerRow1.add("Employee ID");

        }
        if (employeeAdvanceSearch.getEmployeeName() == true) {
            headerRow1.add("Employee Name");
        }
        if (employeeAdvanceSearch.getFatherName() == true) {
            headerRow1.add("Father Name");
        }
        if (employeeAdvanceSearch.getMotherName() == true) {
            headerRow1.add("Mother Name");
        }
        if (employeeAdvanceSearch.getGender() == true) {
            headerRow1.add("Gender");
        }
        if (employeeAdvanceSearch.getMaritalStatus() == true) {
            headerRow1.add("MaritalStatus");
        }
        if (employeeAdvanceSearch.getDateOfBirth() == true) {
            headerRow1.add("DateOfBirth");
        }
        if (employeeAdvanceSearch.getPresentAddress() == true) {
            headerRow1.add("PresentAddress");
        }
        if (employeeAdvanceSearch.getPermanentAddress() == true) {
            headerRow1.add("PermanentAddress");
        }
        if (employeeAdvanceSearch.getBloodGroups() == true) {
            headerRow1.add("BloodGroup");
        }
        if (employeeAdvanceSearch.getEmailAddress() == true) {
            headerRow1.add("EmailAddress");
        }
        if (employeeAdvanceSearch.getContactNo1() == true) {
            headerRow1.add("ContactNo1");
        }
        if (employeeAdvanceSearch.getContactNo2() == true) {
            headerRow1.add("ContactNo2");
        }
        if (employeeAdvanceSearch.getEmergencyContactPerson() == true) {
            headerRow1.add("Emergency Contact Person");
        }
        if (employeeAdvanceSearch.getEmergencyContactNo() == true) {
            headerRow1.add("Emergency Contact No");
        }
        if (employeeAdvanceSearch.getPanCard() == true) {
            headerRow1.add("PAN Card No");
        }
        if (employeeAdvanceSearch.getPassportNo() == true) {
            headerRow1.add("PassportNo");
        }
        if (employeeAdvanceSearch.getPassportIssueDate() == true) {
            headerRow1.add("PassportIssueDate");
        }
        if (employeeAdvanceSearch.getPassportExpiryDate() == true) {
            headerRow1.add("PassportExpiryDate");
        }
        if (employeeAdvanceSearch.getAdharCard() == true) {
            headerRow1.add("AdharCard");
        }
        if (employeeAdvanceSearch.getOfficeEmailId() == true) {
            headerRow1.add("Official E-Mail ID");
        }
        if (employeeAdvanceSearch.getHighestEducationDetails() == true) {
            headerRow1.add("Highest Education Details");
        }
        if (employeeAdvanceSearch.getExperienceYearOnDoj() == true) {
            headerRow1.add("Exp. On Date Of Joining Year");
        }
        if (employeeAdvanceSearch.getExperienceMonthOnDoj() == true) {
            headerRow1.add("Exp. On Date Of Joining Month");
        }
        if (employeeAdvanceSearch.getCompany() == true) {
            headerRow1.add("Company");
        }
        if (employeeAdvanceSearch.getZydexLocation() == true) {
            headerRow1.add("Zydex Location");
        }
        if (employeeAdvanceSearch.getWorkLocation() == true) {
            headerRow1.add("Work Location");
        }
        if (employeeAdvanceSearch.getLevel() == true) {
            headerRow1.add("Level");
        }
        if (employeeAdvanceSearch.getDepartment() == true) {
            headerRow1.add("Department");
        }
        if (employeeAdvanceSearch.getDesignation() == true) {
            headerRow1.add("Designation");
        }
        if (employeeAdvanceSearch.getRole() == true) {
            headerRow1.add("Role");
        }
        if (employeeAdvanceSearch.getDateOfJoining() == true) {
            headerRow1.add("DateOfJoining");
        }
        if (employeeAdvanceSearch.getEmployeeType() == true) {
            headerRow1.add("EmployeeType");
        }
        if (employeeAdvanceSearch.getBankName() == true) {
            headerRow1.add("BankName");
        }
        if (employeeAdvanceSearch.getBankAccountNo() == true) {
            headerRow1.add("BankAccountNo");
        }
        if (employeeAdvanceSearch.getBankIfscCode() == true) {
            headerRow1.add("IFSC Code");
        }
        if (employeeAdvanceSearch.getReportingManager() == true) {
            headerRow1.add("Reporting Manager");
        }
        if (employeeAdvanceSearch.getCityOfEmployee() == true) {
            headerRow1.add("City");
        }
        if (employeeAdvanceSearch.getChild1() == true) {
            headerRow1.add("Child1");
        }
        if (employeeAdvanceSearch.getChild2() == true) {
            headerRow1.add("Child2");
        }
        if (employeeAdvanceSearch.getDateOfBirthOfEmpFather() == true) {
            headerRow1.add("Father's Date Of Birth");
        }
        if (employeeAdvanceSearch.getDateOfBirthOfEmpMother() == true) {
            headerRow1.add("Mother's Date Of Birth");
        }
        if (employeeAdvanceSearch.getDateOfBirthOfEmpSpous() == true) {
            headerRow1.add("Spouse's Date Of Birth");
        }
        if (employeeAdvanceSearch.getDateOfBirthOfEmpChilld1() == true) {
            headerRow1.add("Child1's Date Of Birth");
        }
        if (employeeAdvanceSearch.getDateOfBirthOfEmpChild2() == true) {
            headerRow1.add("Date Of Transfer Of Entity");
        }

        List<List<String>> recordToAdd = new ArrayList();
        List<List<String>> recordToAdd1 = new ArrayList();
        EmployeeShiftData employeeShiftData = new EmployeeShiftData();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calForFlexiNotSupport1 = Calendar.getInstance();
        Calendar calForFlexiNotSupport2 = Calendar.getInstance();
        if (!startDate.equals("")) {
            Date notflexibleSupportDate = sdf.parse(startDate);
            String FixedFlexibleDate = "01/04/2016";
            Date notflexibleSupportDate1 = sdf.parse(FixedFlexibleDate);
            calForFlexiNotSupport1.setTime(notflexibleSupportDate);
            calForFlexiNotSupport2.setTime(notflexibleSupportDate1);
        }

        if (null != empId && !empId.equals("")) {
            employeeShiftData.setId(Integer.parseInt(empId));
        }
        if (null != startDate && !startDate.equals("")) {
            Date sDate = sdf.parse(startDate);
            employeeShiftData.setInDateTime(new SimpleDateFormat("yyyy-MM-dd").format(sDate));
        }
        if (null != endDate && !endDate.equals("")) {
            Date eDate = sdf.parse(endDate);
            employeeShiftData.setOutDateTime(new SimpleDateFormat("yyyy-MM-dd").format(eDate));
        }

        recordToAdd.add(headerRow1);

        String active = request.getParameter("active");
        String inactive = request.getParameter("inactive");
        if (null == inactive) {
            inactive = "";
        }
        if (null == active) {
            active = "";
        }
        List<?> empDetail = new ArrayList<>();
        if (active.equals("on") && inactive.equals("on")) {
            empDetail = employeeMasterService.empOrDateWiseSearch(employeeAdvanceSearch);
        } else if (active.equals("on") && inactive.equals("")) {
            empDetail = employeeMasterService.empOrDateWiseSearchforActive(employeeAdvanceSearch);
        } else if (active.equals("") && inactive.equals("on")) {
            empDetail = employeeMasterService.empOrDateWiseSearchforInActive(employeeAdvanceSearch);
        }

        Iterator it = empDetail.iterator();
        while (it.hasNext()) {

//            Row row = firstSheet.createRow(rownum);
            List<String> employeeInfoList = new ArrayList();
            List<String> employeeInfoList1 = new ArrayList();
            Object[] next = (Object[]) it.next();
            employeeInfoList1.add("" + next[47]);
            if (employeeAdvanceSearch.getEmployeeId() == true) {
                employeeInfoList.add("" + next[0]);
            }
            if (employeeAdvanceSearch.getEmployeeName() == true) {
                employeeInfoList.add("" + next[1]);
            }

            if (null == next[2]) {
                next[2] = "";
            }
            if (null == next[3]) {
                next[3] = "";
            }
            if (null == next[4]) {
                next[4] = "";
            }
            if (null == next[5]) {
                next[5] = "";
            }
            if (null == next[6]) {
                next[6] = "";
            }
            if (null == next[7]) {
                next[7] = "";
            }
            if (null == next[8]) {
                next[8] = "";
            }
            if (null == next[9]) {
                next[9] = "";
            }
            if (null == next[10]) {
                next[10] = "";
            }
            if (null == next[11]) {
                next[11] = "";
            }
            if (null == next[12]) {
                next[12] = "";
            }
            if (null == next[13]) {
                next[13] = "";
            }
            if (null == next[14]) {
                next[14] = "";
            }
            if (null == next[15]) {
                next[15] = "";
            }
            if (null == next[16]) {
                next[16] = "";
            }
            if (null == next[17]) {
                next[17] = "";
            }
            if (null == next[18]) {
                next[18] = "";
            }
            if (null == next[19]) {
                next[19] = "";
            }
            if (null == next[20]) {
                next[20] = "";
            }
            if (null == next[21]) {
                next[21] = "";
            }
            if (null == next[22]) {
                next[22] = "";
            }
            if (null == next[23]) {
                next[23] = "";
            }
            if (null == next[24]) {
                next[24] = "";
            }
            if (null == next[25]) {
                next[25] = "";
            }
            if (null == next[26]) {
                next[26] = "";
            }
            if (null == next[27]) {
                next[27] = "";
            }
            if (null == next[28]) {
                next[28] = "";
            }
            if (null == next[29]) {
                next[29] = "";
            }
            if (null == next[30]) {
                next[30] = "";
            }
            if (null == next[31]) {
                next[31] = "";
            }
            if (null == next[32]) {
                next[32] = "";
            }
            if (null == next[33]) {
                next[33] = "";
            }
            if (null == next[34]) {
                next[34] = "";
            }
            if (null == next[35]) {
                next[35] = "";
            }
            if (null == next[36]) {
                next[36] = "";
            }
            if (null == next[37]) {
                next[37] = "";
            }
            if (null == next[38]) {
                next[38] = "";
            }
            if (null == next[39]) {
                next[39] = "";
            }
            if (null == next[40]) {
                next[40] = "";
            }
            if (null == next[41]) {
                next[41] = "";
            }
            if (null == next[42]) {
                next[42] = "";
            }
            if (null == next[43]) {
                next[43] = "";
            }
            if (null == next[44]) {
                next[44] = "";
            }
            if (null == next[45]) {
                next[45] = "";
            }
            if (null == next[46]) {
                next[46] = "";
            }
            if (null == next[47]) {
                next[47] = "";
            }
            if (employeeAdvanceSearch.getFatherName() == true) {
                employeeInfoList.add("" + next[2]);
            }
            if (employeeAdvanceSearch.getMotherName() == true) {
                employeeInfoList.add("" + next[3]);
            }
            if (employeeAdvanceSearch.getGender() == true) {
                employeeInfoList.add("" + next[4]);
            }
            if (employeeAdvanceSearch.getMaritalStatus() == true) {
                employeeInfoList.add("" + next[5]);
            }
            if (employeeAdvanceSearch.getDateOfBirth() == true) {
                employeeInfoList.add("" + next[6]);
            }
            if (employeeAdvanceSearch.getPresentAddress() == true) {
                employeeInfoList.add("" + next[7]);
            }
            if (employeeAdvanceSearch.getPermanentAddress() == true) {
                employeeInfoList.add("" + next[8]);
            }
            if (employeeAdvanceSearch.getBloodGroups() == true) {
                employeeInfoList.add("" + next[9]);
            }
            if (employeeAdvanceSearch.getEmailAddress() == true) {
                employeeInfoList.add("" + next[10]);
            }
            if (employeeAdvanceSearch.getContactNo1() == true) {
                employeeInfoList.add("" + next[11]);
            }
            if (employeeAdvanceSearch.getContactNo2() == true) {
                employeeInfoList.add("" + next[12]);
            }
            if (employeeAdvanceSearch.getEmergencyContactPerson() == true) {
                employeeInfoList.add("" + next[13]);
            }
            if (employeeAdvanceSearch.getEmergencyContactNo() == true) {
                employeeInfoList.add("" + next[14]);
            }
            if (employeeAdvanceSearch.getPanCard() == true) {
                employeeInfoList.add("" + next[15]);
            }
            if (employeeAdvanceSearch.getPassportNo() == true) {
                employeeInfoList.add("" + next[16]);
            }
            if (employeeAdvanceSearch.getPassportIssueDate() == true) {
                employeeInfoList.add("" + next[17]);
            }
            if (employeeAdvanceSearch.getPassportExpiryDate() == true) {
                employeeInfoList.add("" + next[18]);
            }
            if (employeeAdvanceSearch.getAdharCard() == true) {
                employeeInfoList.add("" + next[19]);
            }
            if (employeeAdvanceSearch.getOfficeEmailId() == true) {
                employeeInfoList.add("" + next[20]);
            }
            if (employeeAdvanceSearch.getHighestEducationDetails() == true) {
                employeeInfoList.add("" + next[21]);
            }
            if (employeeAdvanceSearch.getExperienceYearOnDoj() == true) {
                employeeInfoList.add("" + next[22]);
            }
            if (employeeAdvanceSearch.getExperienceMonthOnDoj() == true) {
                employeeInfoList.add("" + next[23]);
            }
            if (employeeAdvanceSearch.getCompany() == true) {
                employeeInfoList.add("" + next[24]);
            }
            if (employeeAdvanceSearch.getZydexLocation() == true) {
                employeeInfoList.add("" + next[25]);
            }
            if (employeeAdvanceSearch.getWorkLocation() == true) {
                employeeInfoList.add("" + next[26]);
            }
            if (employeeAdvanceSearch.getLevel() == true) {
                employeeInfoList.add("" + next[27]);
            }
            if (employeeAdvanceSearch.getDepartment() == true) {
                employeeInfoList.add("" + next[28]);
            }
            if (employeeAdvanceSearch.getDesignation() == true) {
                employeeInfoList.add("" + next[29]);
            }
            if (employeeAdvanceSearch.getRole() == true) {
                employeeInfoList.add("" + next[30]);
            }
            if (employeeAdvanceSearch.getDateOfJoining() == true) {
                employeeInfoList.add("" + next[31]);
            }
            if (employeeAdvanceSearch.getEmployeeType() == true) {
                employeeInfoList.add("" + next[32]);
            }
            if (employeeAdvanceSearch.getBankName() == true) {
                employeeInfoList.add("" + next[33]);
            }
            if (employeeAdvanceSearch.getBankAccountNo() == true) {
                employeeInfoList.add("" + next[34]);
            }
            if (employeeAdvanceSearch.getBankIfscCode() == true) {
                employeeInfoList.add("" + next[35]);
            }
            if (employeeAdvanceSearch.getReportingManager() == true) {
                employeeInfoList.add("" + next[36]);
            }
            if (employeeAdvanceSearch.getCityOfEmployee() == true) {
                employeeInfoList.add("" + next[37]);
            }
            if (employeeAdvanceSearch.getChild1() == true) {
                employeeInfoList.add("" + next[38]);
            }
            if (employeeAdvanceSearch.getChild2() == true) {
                employeeInfoList.add("" + next[39]);
            }
            if (employeeAdvanceSearch.getDateOfBirthOfEmpFather() == true) {
                employeeInfoList.add("" + next[40]);
            }
            if (employeeAdvanceSearch.getDateOfBirthOfEmpMother() == true) {
                employeeInfoList.add("" + next[41]);
            }
            if (employeeAdvanceSearch.getDateOfBirthOfEmpSpous() == true) {
                employeeInfoList.add("" + next[42]);
            }
            if (employeeAdvanceSearch.getDateOfBirthOfEmpChilld1() == true) {
                employeeInfoList.add("" + next[43]);
            }
            if (employeeAdvanceSearch.getDateOfBirthOfEmpChild2() == true) {
                employeeInfoList.add("" + next[44]);
            }
            if (employeeAdvanceSearch.getDateOfTransferOfEntity() == true) {
                employeeInfoList.add("" + next[45]);
            }

            recordToAdd.add(employeeInfoList);
            recordToAdd1.add(employeeInfoList1);

        }

        try {

            String empId1 = "0";
            int z = 0;
            for (int j = 0; j < recordToAdd.size(); j++) {
                Map<Integer, List<?>> map = new LinkedHashMap<Integer, List<?>>();
                Map<Integer, List<?>> map1 = new LinkedHashMap<Integer, List<?>>();
                Row row = firstSheet.createRow(rownum);
                List<String> l2 = recordToAdd.get(j);

                boolean myFlage = false;
                int id = 0;
                int countK = 1;
                for (int k = 0; k < l2.size(); k++) {
                    Cell cell = row.createCell(k);

                    cell.setCellValue(l2.get(k));
                    if (j == 0) {
                        cell.setCellStyle(styleBold);
                    }
                }

                if (null != startDate && !startDate.equals("") && null != endDate && !endDate.equals("")) {

                    if (j != 0) {

                        List<String> l3 = new ArrayList<>();
                        try {
                            l3 = recordToAdd1.get(z);
                            empId1 = l3.get(0);
                            z++;
                        } catch (Exception e) {
                        }

                        id = Integer.parseInt(empId1);
                        employeeShiftData.setId(id);
                        List<?> list = employeeShiftDataService.empOrDateWiseSearch(employeeShiftData);
                        map.put(id, list);
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
                        if (flexible == true && calForFlexiNotSupport2.get(Calendar.MONTH) != calForFlexiNotSupport1.get(Calendar.MONTH)) {
                            rownum = rownum + 1;
                            Row row4 = firstSheet.createRow(rownum);
                            Cell cell4 = row4.createCell(0);
                            cell4.setCellValue("");
                            rownum = rownum + 1;

                            Row row1 = firstSheet.createRow(rownum);
                            Cell cell1 = row1.createCell(0);
                            cell1.setCellValue("Employee Daily Attendance Information");
                            cell1.setCellStyle(styleBold);
                            double prcounter = 0;
                            double abcounter = 0;
                            double wo = 0;
                            double shl = 0;
                            double shla = 0;
                            double cl = 0;
                            double sl = 0;
                            double pl = 0;
                            double holiday = 0;
                            double tr = 0;
                            double ar = 0;
                            //                int zz = 0;
                            for (Map.Entry<Integer, List<?>> entry : map.entrySet()) {
                                rownum = rownum + 1;
                                Row row33 = firstSheet.createRow(rownum);
                                rownum = rownum + 1;
                                Row row3 = firstSheet.createRow(rownum);

                                Iterator itr1 = entry.getValue().iterator();
                                int i = 1;
                                int k = 1;
                                int l = 1;
                                int m = 1;
                                int n = 1;
                                int o = 1;
                                int p = 1;
                                SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm");
                                Cell cellTitle = row3.createCell(0);
                                cellTitle.setCellValue("Date");
                                cellTitle.setCellStyle(styleBold);
                                while (itr1.hasNext()) {
                                    Object[] next = (Object[]) itr1.next();
                                    Cell cell3 = row3.createCell(i);
                                    cell3.setCellValue("" + next[0]);
                                    CellUtil.setAlignment(cell3, firstFWorkbook, CellStyle.ALIGN_CENTER);

                                    i++;
                                }
                                rownum = rownum + 1;
                                Row row5 = firstSheet.createRow(rownum);
                                Iterator itr2 = entry.getValue().iterator();
                                Cell cellTitle1 = row5.createCell(0);
                                cellTitle1.setCellValue("Shift Name");
                                cellTitle1.setCellStyle(styleBold);
                                while (itr2.hasNext()) {
                                    Object[] next = (Object[]) itr2.next();
                                    Cell cell5 = row5.createCell(l);
                                    String shiftName = "" + next[1];
                                    if (shiftName.contains("#")) {
                                        String[] shiftName1 = shiftName.split("#");
                                        String[] shiftName2 = shiftName1[1].split("\\$");
                                        cell5.setCellValue("" + shiftName2[0]);
                                    } else if (!shiftName.contains("`")) {
                                        cell5.setCellValue("-");
                                    }

                                    CellUtil.setAlignment(cell5, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    l++;

                                }
                                rownum = rownum + 1;
                                Row row6 = firstSheet.createRow(rownum);
                                Iterator itr3 = entry.getValue().iterator();
                                Cell cellTitle2 = row6.createCell(0);
                                cellTitle2.setCellValue("First In");
                                cellTitle2.setCellStyle(styleBold);
                                int weekNameCounter1 = 0;
                                while (itr3.hasNext()) {
                                    Object[] next = (Object[]) itr3.next();
                                    Cell cell6 = row6.createCell(k);
                                    String firstIn = "" + next[1];
                                    if (firstIn.contains("`") && !firstIn.contains("?")) {
                                        String[] firstIn1 = firstIn.split("`");
                                        String[] firstIn12 = firstIn1[1].split("!");
                                        cell6.setCellValue("" + firstIn12[0]);
                                    } else if (!firstIn.contains("`") && !firstIn.contains("?") && !firstIn.contains("AB") && !firstIn.equals("WO") && !firstIn.contains("TR") && !firstIn.contains("AR")) {
                                        if (firstIn.contains("Casual Leave")) {
                                            cl = cl + 1;
                                        }
                                        if (firstIn.contains("Privilege Leave")) {
                                            pl = pl + 1;
                                        }
                                        if (firstIn.contains("Sick Leave")) {
                                            sl = sl + 1;
                                        }
                                        cell6.setCellValue("" + next[1]);
                                    } else if (!firstIn.contains("`") && firstIn.contains("?") && !firstIn.contains("AB") && !firstIn.equals("WO") && !firstIn.contains("TR") && !firstIn.contains("AR")) {
                                        String[] hostring = firstIn.split("\\?");
                                        cell6.setCellValue("" + hostring[0]);
                                        holiday = holiday + 1;
                                    } else if (!firstIn.contains("`") && firstIn.contains("?") && firstIn.contains("AB") && !firstIn.equals("WO") && !firstIn.contains("TR") && !firstIn.contains("AR")) {
                                        cell6.setCellValue("-");
                                    } else if (firstIn.equals("WO")) {
                                        cell6.setCellValue(firstIn);
                                        wo = wo + 1;
                                    } else if (firstIn.equals("TR")) {
                                        cell6.setCellValue(firstIn);
                                        tr = tr + 1;
                                        cell6.setCellStyle(styleblue);
                                    }
                                    CellUtil.setAlignment(cell6, firstFWorkbook, CellStyle.ALIGN_CENTER);
//                                    2nd Sat Week Off Codding
                                    Calendar cal = Calendar.getInstance();
                                    Date date = sdf.parse("" + next[0]);
                                    cal.setTime(date);
                                    SimpleDateFormat format = new SimpleDateFormat("EEEE");
                                    String dayName = format.format(date);
                                    EmployeeMaster employeeMaster1 = employeeMasterService.readById(id);
                                    ZydexLocationMaster zydexLocationMaster = zydexLocationMasterService.readById(employeeMaster1.getZydexLocationMaster().getId());

                                    if (dayName.equals("Saturday")) {
                                        weekNameCounter1++;
                                        if (weekNameCounter1 == 2) {
                                            if (firstIn.contains("Casual Leave")) {
                                                cl = cl - 0.5;
                                            }
                                            if (firstIn.contains("Privilege Leave")) {
                                                pl = pl - 0.5;
                                            }
                                            if (firstIn.contains("Sick Leave")) {
                                                sl = sl - 0.5;
                                            }
                                        }

                                    }
//                                    2nd Sat Week Off Codding
                                    k++;
                                }

                                rownum = rownum + 1;
                                Row row7 = firstSheet.createRow(rownum);
                                Cell cellTitle3 = row7.createCell(0);
                                cellTitle3.setCellValue("Last Out");
                                cellTitle3.setCellStyle(styleBold);
                                Iterator itr4 = entry.getValue().iterator();
                                while (itr4.hasNext()) {
                                    Object[] next = (Object[]) itr4.next();
                                    Cell cell7 = row7.createCell(m);
                                    String lastOut = "" + next[1];
                                    if (lastOut.contains("!")) {
                                        String[] lastOut1 = lastOut.split("`");
                                        String[] lastOut2 = lastOut1[1].split("!");
                                        String[] lastOut3 = lastOut.split("!");
                                        String[] lastOut4 = lastOut3[1].split("@");
                                        Date lout = sdf1.parse(lastOut4[0]);
                                        Date fin = sdf1.parse(lastOut2[0]);
                                        if (lout.equals(fin)) {
                                            cell7.setCellValue("-");
                                        } else {
                                            cell7.setCellValue("" + lastOut4[0]);
                                        }

                                    } else if (lastOut.contains("@")) {
                                        cell7.setCellValue("-");
                                    }
                                    CellUtil.setAlignment(cell7, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    m++;
                                }
                                rownum = rownum + 1;
                                Row row8 = firstSheet.createRow(rownum);
                                Cell cellTitle4 = row8.createCell(0);
                                cellTitle4.setCellValue("First Half");
                                cellTitle4.setCellStyle(styleBold);
                                Iterator itr5 = entry.getValue().iterator();
                                int firstCounter = 0;

                                while (itr5.hasNext()) {
                                    Object[] next = (Object[]) itr5.next();
                                    Cell cell8 = row8.createCell(n);
                                    String firstHalf = "" + next[1];
                                    int firstHalfVal = 0;
                                    int counter = 0;

                                    Date date = sdf.parse("" + next[0]);
                                    Calendar c = Calendar.getInstance();
                                    c.setTime(date);
                                    int dayOfWeek = c.get(Calendar.WEEK_OF_MONTH);
                                    SimpleDateFormat format = new SimpleDateFormat("EEEE");
                                    String dayName = format.format(date);

                                    if (firstHalf.contains("fullday")) {
                                        cell8.setCellValue("PR");
                                        prcounter = prcounter + 0.5;
                                        cell8.setCellStyle(stylegreen);

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
                                        Date userTimeIn = sdf1.parse(userTimeInStr1[0]);
                                        Date userTimeOut = sdf1.parse(userTimeOutStr1[0]);
                                        Date endHours = sdf1.parse(endHoursStr1[0]);
                                        Date firstStartHours = sdf1.parse(firstStartHoursStr[1]);
                                        Calendar cal = Calendar.getInstance();
                                        Calendar cal1 = Calendar.getInstance();
                                        cal.setTime(firstStartHours);
                                        cal1.setTime(firstStartHours);
                                        cal1.add(Calendar.MINUTE, -earlyMinute);
                                        cal.add(Calendar.MINUTE, lateMinute);
                                        String newTime = sdf1.format(cal.getTime());
                                        Date flexibleEndTime = sdf1.parse(newTime);
                                        Date LateHours = sdf1.parse(LateHoursStr1[0]);
                                        String newTime1 = sdf1.format(cal1.getTime());
                                        Date flexibleStartTime = sdf1.parse(newTime1);
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
                                            cell8.setCellValue("PR");
                                            prcounter = prcounter + 0.5;
                                            cell8.setCellStyle(stylegreen);
                                        } else if (userTimeIn != null) {
                                            if ((userTimeIn.before(flexibleEndTime) || userTimeIn.equals(flexibleEndTime)) && (userTimeOut.after(endHours) || userTimeOut.equals(endHours))) {
                                                cell8.setCellValue("PR");
                                                prcounter = prcounter + 0.5;
                                                cell8.setCellStyle(stylegreen);
                                            } else if (userTimeOut.before(userTimeIn)) {
                                                cell8.setCellValue("PR");
                                                prcounter = prcounter + 0.5;
                                                cell8.setCellStyle(stylegreen);
                                            } else if (leave1[0] != null && !leave1[0].contains("Short Leave")) {
                                                if ((userTimeIn.before(flexibleEndTime) || userTimeIn.equals(flexibleEndTime)) && (userTimeOut.after(endHours) || userTimeOut.equals(endHours))) {
                                                    cell8.setCellValue("PR");
                                                    prcounter = prcounter + 0.5;
                                                    cell8.setCellStyle(stylegreen);
                                                } else if (leave1[0].contains("AB")) {
                                                    cell8.setCellValue("AB");
                                                    abcounter = abcounter + 0.5;
                                                    cell8.setCellStyle(stylered);
                                                } else if (leave1[0].contains("AR")) {
                                                    cell8.setCellValue("AR/P");
                                                    ar = ar + 0.5;
                                                    cell8.setCellStyle(styleblue);
                                                } else {
                                                    if (leave1[0].contains("Casual Leave")) {
                                                        cl = cl + 0.5;
                                                    }
                                                    if (leave1[0].contains("Privilege Leave")) {
                                                        pl = pl + 0.5;
                                                    }
                                                    if (leave1[0].contains("Sick Leave")) {
                                                        sl = sl + 0.5;
                                                    }
                                                    cell8.setCellValue(" " + leave1[0]);
                                                }

                                            } else if (null != leave1[0] && leave1[0].contains("Short Leave")) {
                                                if (firstHalf.contains("*")) {
                                                    String[] shortArray = firstHalf.split("\\*");
                                                    String[] endArray = shortArray[1].split("\\-");
                                                    String[] startTime = endArray[1].split("\\+");
                                                    Date shortIn = sdf1.parse(shortArray[1]);
                                                    Date shortend = sdf1.parse(endArray[1]);
                                                    Date startTime1 = sdf1.parse(startTime[1]);
                                                    if (shortIn.before(endHours)) {
                                                        cell8.setCellValue("SHL/P");
                                                        cell8.setCellStyle(stylegreen);
                                                        shl = shl + 1;
                                                    } else if (leave1[0].contains("~ AR")) {
                                                        cell8.setCellValue("AR/P");
                                                        ar = ar + 0.5;
                                                        cell8.setCellStyle(styleblue);
                                                    } else if (userTimeIn.after(endHours)) {
                                                        cell8.setCellValue("SHL/A");
                                                        shla = shla + 1;
                                                        cell8.setCellStyle(stylered);
                                                    } else if ((userTimeIn.before(flexibleEndTime) || userTimeIn.equals(flexibleEndTime)) && (userTimeOut.after(endHours) || userTimeOut.equals(endHours))) {
                                                        cell8.setCellValue("PR");
                                                        prcounter = prcounter + 0.5;
                                                        cell8.setCellStyle(stylegreen);
                                                    } else {
                                                        cell8.setCellValue("AB");
                                                        abcounter = abcounter + 0.5;
                                                        cell8.setCellStyle(stylered);
                                                    }
                                                } else {
                                                    cell8.setCellValue("AB");
                                                    abcounter = abcounter + 0.5;
                                                    cell8.setCellStyle(stylered);
                                                }
                                            } else if (null != leave1[0] && !leave1[0].contains("AB")) {
                                                if (leave1[0].contains("Casual Leave")) {
                                                    cl = cl + 0.5;
                                                }
                                                if (leave1[0].contains("Privilege Leave")) {
                                                    pl = pl + 0.5;
                                                }
                                                if (leave1[0].contains("Sick Leave")) {
                                                    sl = sl + 0.5;
                                                }
                                                cell8.setCellValue(" " + leave1[0]);

                                            } else if (leave1[0].contains("AB")) {
                                                cell8.setCellValue("-");
                                            } else {
                                                cell8.setCellValue("AB");
                                                abcounter = abcounter + 0.5;
                                                cell8.setCellStyle(stylered);
                                            }

                                        } else if (userTimeIn != null && !firstHalf.contains("WO") && !firstHalf.contains("?")) {
                                            cell8.setCellValue("AB");
                                            abcounter = abcounter + 0.5;
                                            cell8.setCellStyle(stylered);
                                        } else if (firstHalf.contains("WO") || firstHalf.contains("?")) {
                                            cell8.setCellValue("-");
                                        }

                                    } else if (firstHalf.equals("WO")) {
                                        cell8.setCellValue("");
                                    } else if (firstHalf.contains("AR")) {
                                        cell8.setCellValue("AR/P");
                                        ar = ar + 0.5;
                                        cell8.setCellStyle(styleblue);
                                    } else if (firstHalf.equals("AB")) {
                                        cell8.setCellValue("AB");
                                        abcounter = abcounter + 0.5;
                                        cell8.setCellStyle(stylered);
                                    }
                                    CellUtil.setAlignment(cell8, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    n++;
                                }

                                rownum = rownum + 1;
                                Row row9 = firstSheet.createRow(rownum);
                                Cell cellTitle5 = row9.createCell(0);
                                cellTitle5.setCellValue("Second Half");
                                cellTitle5.setCellStyle(styleBold);
                                Iterator itr6 = entry.getValue().iterator();
                                int weekNameCounter = 0;
                                boolean satWeekOff = false;
                                while (itr6.hasNext()) {
                                    Object[] next = (Object[]) itr6.next();
                                    Cell cell9 = row9.createCell(o);
                                    String secondHalf = "" + next[1];
                                    int firstHalfVal = 0;
                                    int counter = 0;
                                    String shiftName = "";
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
                                            Date userTimeIn = sdf1.parse(userTimeInStr1[0]);
                                            Date userTimeOut = sdf1.parse(userTimeOutStr1[0]);
                                            String[] startHoursStr = secondHalf.split("%");
                                            String[] firstStartHoursStr = startHoursStr[1].split("\\+");
                                            String[] endHoursStr = secondHalf.split("&");
                                            Date firstStartHours = sdf1.parse(firstStartHoursStr[1]);
                                            Calendar cal1 = Calendar.getInstance();
                                            cal1.setTime(firstStartHours);
                                            cal1.add(Calendar.MINUTE, -earlyMinute);

                                            String newTime1 = sdf1.format(cal1.getTime());
                                            Date flexibleInTime = sdf1.parse(newTime1);
                                            Date endHours = sdf1.parse(endHoursStr[1]);
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
                                    } catch (Exception e) {

                                    }

//                                    Lunch Breck Cut Off
                                    if (secondHalf.contains(" # ")) {
                                        String[] string1 = secondHalf.split("#");
                                        String[] string2 = string1[1].split("\\$");
                                        shiftName = string2[0].trim();

                                    }
                                    if (satWeekOff == true && (zydexLocationMaster.getZydexLocation().equals("HO") || zydexLocationMaster.getZydexLocation().equals("R&D"))) {
                                        cell9.setCellValue("WO");
                                        wo = wo + 0.5;
                                    } else if (secondHalf.equals("AR")) {
                                        cell9.setCellValue("AR/P");
                                        ar = ar + 0.5;
                                        cell9.setCellStyle(styleblue);
                                    } else if (checkLunchTime == true && totalTime < shiftdiffMinutes && !secondHalf.contains("AR")) {
                                        cell9.setCellValue("AB");
                                        abcounter = abcounter + 0.5;
                                        cell9.setCellStyle(stylered);
                                    } else if (secondHalf.contains("fullday")) {
                                        cell9.setCellValue("PR");
                                        prcounter = prcounter + 0.5;
                                        cell9.setCellStyle(stylegreen);

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

                                        Date userTimeIn = sdf1.parse(userTimeInStr1[0]);
                                        Date userTimeOut = sdf1.parse(userTimeOutStr1[0]);
                                        Date userTimeOut1 = sdf1.parse("23:59");
                                        Date firstStartHours = sdf1.parse(firstStartHoursStr[1]);
                                        String[] getInHours = userTimeInStr1[0].split(":");
                                        String[] getOutHours = userTimeOutStr1[0].split(":");
                                        String abc = getInHours[0].trim();
                                        String xyz = getOutHours[0].trim();
                                        int i11 = Integer.parseInt(abc) - Integer.parseInt(xyz);
                                        int totalDuration = 24 - i11;
                                        String totalDuration2 = getOutHours[0];
                                        Date endHours = sdf1.parse(endHoursStr[1]);
                                        Date secondHalfTimeStr2 = sdf1.parse(secondHalfTimeStr1[0]);

                                        Calendar cal1 = Calendar.getInstance();
                                        Calendar cal2 = Calendar.getInstance();
                                        cal1.setTime(firstStartHours);
                                        cal1.add(Calendar.MINUTE, -earlyMinute);
                                        cal2.setTime(firstStartHours);
                                        cal2.add(Calendar.MINUTE, lateMinute);
                                        String newTime = sdf1.format(cal2.getTime());
                                        Date flexibleEndTime = sdf1.parse(newTime);

                                        String newTime1 = sdf1.format(cal1.getTime());
                                        Date flexibleInTime = sdf1.parse(newTime1);
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
                                                cell9.setCellValue("AR/P");
                                                ar = ar + 0.5;
                                                cell9.setCellStyle(styleblue);
                                            } else if (diffMinutes1 >= diffMinutes && userTimeIn.before(flexibleEndTime)) {
                                                cell9.setCellValue("PR");
                                                prcounter = prcounter + 0.5;
                                                cell9.setCellStyle(stylegreen);
                                            } else if (diffMinutes1 <= diffMinutes && userTimeIn.before(flexibleEndTime) && !secondHalf.contains("WO") && !secondHalf.contains("TR") && !secondHalf.contains("AR") && !secondHalf.contains("?")
                                                    && !secondHalf.contains("Casual Leave") && !secondHalf.equals("C Off Leave") && !secondHalf.contains("Privilege Leave") && !secondHalf.contains("Sick Leave")
                                                    && !secondHalf.contains("Paternity Leave") && !secondHalf.contains("Maternity Leave") && !secondHalf.contains("Leave Without Pay")) {
                                                cell9.setCellValue("AB");
                                                abcounter = abcounter + 0.5;
                                                cell9.setCellStyle(stylered);
                                            } else if (diffMinutes1 >= 240 && userTimeIn.after(secondHalfTimeStr2)) {
                                                cell9.setCellValue("PR");
                                                prcounter = prcounter + 0.5;
                                                cell9.setCellStyle(stylegreen);
                                            } else if ((userTimeIn.before(secondHalfTimeStr2) || userTimeIn.equals(secondHalfTimeStr2)) && (userTimeOut.after(endHours) || userTimeOut.equals(endHours))) {
                                                cell9.setCellValue("PR");
                                                prcounter = prcounter + 0.5;
                                                cell9.setCellStyle(stylegreen);
                                            } else if (shiftName.contains("Night") && (userTimeOut.after(endHours) || userTimeOut.equals(endHours))) {
                                                cell9.setCellValue("PR");
                                                prcounter = prcounter + 0.5;
                                                cell9.setCellStyle(stylegreen);
                                            } else if (null != leave1[0] && leave1[0].contains("Short Leave")) {
                                                if (secondHalf.contains("*")) {
                                                    String[] shortArray = secondHalf.split("\\*");
                                                    String[] endArray = secondHalf.split("\\^");
                                                    String[] secondhalfstartTime = endArray[1].split("&");
                                                    Date shortIn = sdf1.parse(shortArray[1]);
                                                    Date shortend = sdf1.parse(endArray[1]);
                                                    Date secondhalfstartTime1 = sdf1.parse(secondhalfstartTime[0]);
                                                    if ((secondhalfstartTime1.before(shortIn) || secondhalfstartTime1.equals(shortIn)) && (shortIn.before(endHours) || shortIn.equals(endHours))) {
                                                        if (userTimeOut.after(secondHalfTimeStr2)) {
                                                            cell9.setCellValue("SHL/P");
                                                            shl = shl + 1;
                                                            cell9.setCellStyle(stylegreen);
                                                        } else if (leave1[0].contains("~ AR")) {
                                                            cell9.setCellValue("AR/P");
                                                            ar = ar + 0.5;
                                                            cell9.setCellStyle(styleblue);
                                                        } else if (userTimeOut.before(secondHalfTimeStr2) || userTimeOut.equals(secondHalfTimeStr2)) {
                                                            cell9.setCellValue("SHL/A");
                                                            shla = shla + 1;
                                                            cell9.setCellStyle(stylered);
                                                        } else {
                                                            cell9.setCellValue("AB");
                                                            abcounter = abcounter + 0.5;
                                                            cell9.setCellStyle(stylered);
                                                        }
                                                    }
                                                } else {
                                                    cell9.setCellValue("AB");
                                                    abcounter = abcounter + 0.5;
                                                    cell9.setCellStyle(stylered);
                                                }
                                            } else if (null != leave1[0] && !leave1[0].contains("AB") && !leave1[0].contains("AR")) {
                                                if (leave1[0].contains("Casual Leave")) {
                                                    cl = cl + 0.5;
                                                }
                                                if (leave1[0].contains("Privilege Leave")) {
                                                    pl = pl + 0.5;
                                                }
                                                if (leave1[0].contains("Sick Leave")) {
                                                    sl = sl + 0.5;
                                                }
                                                cell9.setCellValue(" " + leave1[0]);

                                            } else if (leave1[0].contains("AB")) {
                                                cell9.setCellValue("AB");
                                                abcounter = abcounter + 0.5;
                                                cell9.setCellStyle(stylered);
                                            } else {
                                                cell9.setCellValue("AB");
                                                abcounter = abcounter + 0.5;
                                                cell9.setCellStyle(stylered);
                                            }

                                        } else if (userTimeIn != null && !secondHalf.contains("WO") && !secondHalf.contains("?")) {
                                            cell9.setCellValue("AB");
                                            abcounter = abcounter + 0.5;
                                            cell9.setCellStyle(stylered);
                                        } else if (secondHalf.contains("WO") || secondHalf.contains("?")) {
                                            cell9.setCellValue("-");
                                        }

                                    } else if (secondHalf.equals("WO")) {
                                        cell9.setCellValue("-");
                                    } else if (secondHalf.equals("AB")) {
                                        cell9.setCellValue("AB");
                                        abcounter = abcounter + 0.5;
                                        cell9.setCellStyle(stylered);
                                    }
                                    CellUtil.setAlignment(cell9, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    o++;
                                }

                                rownum = rownum + 1;
                                Row row10 = firstSheet.createRow(rownum);
                                Cell cellTitle6 = row10.createCell(0);
                                cellTitle6.setCellValue("Working Hour");
                                cellTitle6.setCellStyle(styleBold);
                                Iterator itr7 = entry.getValue().iterator();
                                while (itr7.hasNext()) {
                                    Object[] next = (Object[]) itr7.next();
                                    Cell cell10 = row10.createCell(p);
                                    String secondHalf = "" + next[1];
                                    int firstHalfVal = 0;
                                    int counter = 0;
                                    String shiftName = "";

//                                    Lunch Breck Cut Off
                                    List listPunch = employeeDatetimeDataService.readPuchDataDateWise("" + next[0], id);
                                    long lunchTime = 0;
                                    long outTime = 0;
                                    long totalDayTime = 0;
                                    long totalDayTime1 = 0;
                                    long totalTime = 0;
                                    long shiftdiffMinutes = 0;
                                    String startTime = "";
                                    String endTime = "";
                                    int d = 1;
                                    int s = 2;
                                    boolean checkLunchTime = false;
                                    SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                                    if (listPunch.size() > 0 && !secondHalf.equals("WO") && !secondHalf.equals("AB") && !secondHalf.equals("TR") && !secondHalf.equals("AR")) {
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
                                        }

                                        String[] userTimeInStr = secondHalf.split("`");
                                        String[] userTimeInStr1 = userTimeInStr[1].split("!");
                                        String[] userTimeOutStr = secondHalf.split("!");
                                        String[] userTimeOutStr1 = userTimeOutStr[1].split("@");
                                        Date userTimeIn = sdf1.parse(userTimeInStr1[0]);
                                        Date userTimeOut = sdf1.parse(userTimeOutStr1[0]);
                                        Date userTimeOut1 = sdf1.parse("23:59");
                                        String[] startHoursStr = secondHalf.split("%");
                                        String[] firstStartHoursStr = startHoursStr[1].split("\\+");
                                        String[] endHoursStr = secondHalf.split("&");
                                        Date firstStartHours = sdf1.parse(firstStartHoursStr[1]);
                                        Calendar cal1 = Calendar.getInstance();
                                        cal1.setTime(firstStartHours);
                                        cal1.add(Calendar.MINUTE, -earlyMinute);
                                        String newTime1 = sdf1.format(cal1.getTime());
                                        Date flexibleInTime = sdf1.parse(newTime1);
                                        Date endHours = sdf1.parse(endHoursStr[1]);
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
                                            cell10.setCellValue(workingHours);

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
                                            cell10.setCellValue(workingHours);
                                        }

                                    } else {
                                        cell10.setCellValue("-");
                                    }

//                                    Lunch Breck Cut Off
                                    CellUtil.setAlignment(cell10, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    p++;
                                }

                            }
                            rownum = rownum + 1;
                            Row dayCount1 = firstSheet.createRow(rownum);
                            rownum = rownum + 1;
                            Row dayCount = firstSheet.createRow(rownum);
                            Cell dayCounrCell = dayCount.createCell(0);
                            dayCounrCell.setCellValue("Day Count");
                            dayCounrCell.setCellStyle(styleBold);

                            rownum = rownum + 1;
                            Row row13 = firstSheet.createRow(rownum);
                            for (int y = 1; y < 10;) {
                                if (prcounter != 0) {
                                    Cell cell12 = row13.createCell(y);
                                    cell12.setCellValue("PR");
                                    cell12.setCellStyle(stylegreen);
                                    CellUtil.setAlignment(cell12, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    y++;
                                }
                                if (abcounter != 0) {
                                    Cell cell13 = row13.createCell(y);
                                    cell13.setCellValue("AB");
                                    cell13.setCellStyle(stylered);
                                    CellUtil.setAlignment(cell13, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    y++;
                                }
                                if (shl != 0) {
                                    Cell cell14 = row13.createCell(y);
                                    cell14.setCellValue("SHL/P");
                                    cell14.setCellStyle(stylegreen);
                                    CellUtil.setAlignment(cell14, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    y++;
                                }
                                if (shla != 0) {
                                    Cell cell15 = row13.createCell(y);
                                    cell15.setCellValue("SHL/A");
                                    cell15.setCellStyle(stylered);
                                    CellUtil.setAlignment(cell15, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    y++;
                                }
                                if (cl != 0) {
                                    Cell cell16 = row13.createCell(y);
                                    cell16.setCellValue("CL");
                                    cell16.setCellStyle(styleBold);
                                    CellUtil.setAlignment(cell16, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    y++;
                                }
                                if (sl != 0) {
                                    Cell cell17 = row13.createCell(y);
                                    cell17.setCellValue("SL");
                                    cell17.setCellStyle(styleBold);
                                    CellUtil.setAlignment(cell17, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    y++;
                                }
                                if (pl != 0) {
                                    Cell cell18 = row13.createCell(y);
                                    cell18.setCellValue("PL");
                                    cell18.setCellStyle(styleBold);
                                    CellUtil.setAlignment(cell18, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    y++;
                                }
                                if (holiday != 0) {
                                    Cell cell19 = row13.createCell(y);
                                    cell19.setCellValue("HOLIDAY");
                                    cell19.setCellStyle(styleBold);
                                    CellUtil.setAlignment(cell19, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    y++;
                                }
                                if (ar != 0) {
                                    Cell cell20 = row13.createCell(y);
                                    cell20.setCellValue("AR/P");
                                    cell20.setCellStyle(styleblue);
                                    CellUtil.setAlignment(cell20, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    y++;
                                }
                                if (wo != 0) {
                                    Cell cell21 = row13.createCell(y);
                                    cell21.setCellValue("WO");
                                    cell21.setCellStyle(styleBold);
                                    CellUtil.setAlignment(cell21, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    y++;
                                }
                                if (tr != 0) {
                                    Cell cell22 = row13.createCell(y);
                                    cell22.setCellValue("TR");
                                    cell22.setCellStyle(styleblue);
                                    CellUtil.setAlignment(cell22, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                }
                                break;
                            }

                            rownum = rownum + 1;
                            Row row12 = firstSheet.createRow(rownum);
                            for (int x = 1; x < 10;) {
                                if (prcounter != 0) {
                                    Cell cell12 = row12.createCell(x);
                                    cell12.setCellType(Cell.CELL_TYPE_NUMERIC);
                                    double newshl = shl / 2;
                                    double nepr = prcounter - newshl;
                                    cell12.setCellValue(nepr);
                                    CellUtil.setAlignment(cell12, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    x++;
                                }
                                if (abcounter != 0) {
                                    Cell cell13 = row12.createCell(x);
                                    cell13.setCellType(Cell.CELL_TYPE_NUMERIC);
                                    cell13.setCellValue(abcounter);
                                    CellUtil.setAlignment(cell13, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    x++;
                                }
                                if (shl != 0) {
                                    Cell cell14 = row12.createCell(x);
                                    cell14.setCellType(Cell.CELL_TYPE_NUMERIC);
                                    cell14.setCellValue(shl);
                                    CellUtil.setAlignment(cell14, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    x++;
                                }
                                if (shla != 0) {
                                    Cell cell15 = row12.createCell(x);
                                    cell15.setCellType(Cell.CELL_TYPE_NUMERIC);
                                    cell15.setCellValue(shla);
                                    CellUtil.setAlignment(cell15, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    x++;
                                }
                                if (cl != 0) {
                                    Cell cell16 = row12.createCell(x);
                                    cell16.setCellType(Cell.CELL_TYPE_NUMERIC);
                                    cell16.setCellValue(cl);
                                    CellUtil.setAlignment(cell16, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    x++;
                                }
                                if (sl != 0) {
                                    Cell cell17 = row12.createCell(x);
                                    cell17.setCellType(Cell.CELL_TYPE_NUMERIC);
                                    cell17.setCellValue(sl);
                                    CellUtil.setAlignment(cell17, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    x++;
                                }
                                if (pl != 0) {
                                    Cell cell18 = row12.createCell(x);
                                    cell18.setCellType(Cell.CELL_TYPE_NUMERIC);
                                    cell18.setCellValue(pl);
                                    CellUtil.setAlignment(cell18, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    x++;
                                }
                                if (holiday != 0) {
                                    Cell cell19 = row12.createCell(x);
                                    cell19.setCellType(Cell.CELL_TYPE_NUMERIC);
                                    cell19.setCellValue(holiday);
                                    CellUtil.setAlignment(cell19, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    x++;
                                }
                                if (ar != 0) {
                                    Cell cell20 = row12.createCell(x);
                                    cell20.setCellType(Cell.CELL_TYPE_NUMERIC);
                                    cell20.setCellValue(ar);
                                    CellUtil.setAlignment(cell20, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    x++;
                                }
                                if (wo != 0) {
                                    Cell cell21 = row12.createCell(x);
                                    cell21.setCellType(Cell.CELL_TYPE_NUMERIC);
                                    cell21.setCellValue(wo);
                                    CellUtil.setAlignment(cell21, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    x++;
                                }
                                if (tr != 0) {
                                    Cell cell22 = row12.createCell(x);
                                    cell22.setCellType(Cell.CELL_TYPE_NUMERIC);
                                    cell22.setCellValue(tr);
                                    CellUtil.setAlignment(cell22, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                }
                                break;
                            }

                        } else {
                            rownum = rownum + 1;
                            Row row4 = firstSheet.createRow(rownum);
                            Cell cell4 = row4.createCell(0);
                            cell4.setCellValue("");
                            rownum = rownum + 1;

                            Row row1 = firstSheet.createRow(rownum);
                            Cell cell1 = row1.createCell(0);
                            cell1.setCellValue("Employee Daily Attendance Information");
                            cell1.setCellStyle(styleBold);
                            double prcounter = 0;
                            double abcounter = 0;
                            double wo = 0;
                            double shl = 0;
                            double shla = 0;
                            double cl = 0;
                            double sl = 0;
                            double pl = 0;
                            double holiday = 0;
                            double tr = 0;
                            double ar = 0;
                            //                int zz = 0;
                            for (Map.Entry<Integer, List<?>> entry : map.entrySet()) {
                                rownum = rownum + 1;
                                Row row33 = firstSheet.createRow(rownum);
                                rownum = rownum + 1;
                                Row row3 = firstSheet.createRow(rownum);

                                Iterator itr1 = entry.getValue().iterator();
                                int i = 1;
                                int k = 1;
                                int l = 1;
                                int m = 1;
                                int n = 1;
                                int o = 1;
                                SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm");
                                Cell cellTitle = row3.createCell(0);
                                cellTitle.setCellValue("Date");
                                cellTitle.setCellStyle(styleBold);

                                while (itr1.hasNext()) {
                                    Object[] next = (Object[]) itr1.next();
                                    Cell cell3 = row3.createCell(i);
                                    cell3.setCellValue("" + next[0]);
                                    CellUtil.setAlignment(cell3, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    i++;
                                }
                                rownum = rownum + 1;
                                Row row5 = firstSheet.createRow(rownum);
                                Iterator itr2 = entry.getValue().iterator();
                                Cell cellTitle1 = row5.createCell(0);
                                cellTitle1.setCellValue("Shift Name");
                                cellTitle1.setCellStyle(styleBold);
                                while (itr2.hasNext()) {
                                    Object[] next = (Object[]) itr2.next();
                                    Cell cell5 = row5.createCell(l);
                                    String shiftName = "" + next[1];
                                    if (shiftName.contains("#")) {
                                        String[] shiftName1 = shiftName.split("#");
                                        String[] shiftName2 = shiftName1[1].split("\\$");
                                        cell5.setCellValue("" + shiftName2[0]);
                                    } else if (!shiftName.contains("`")) {
                                        cell5.setCellValue("-");
                                    }

                                    CellUtil.setAlignment(cell5, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    l++;

                                }
                                rownum = rownum + 1;
                                Row row6 = firstSheet.createRow(rownum);
                                Iterator itr3 = entry.getValue().iterator();
                                Cell cellTitle2 = row6.createCell(0);
                                cellTitle2.setCellValue("First In");
                                cellTitle2.setCellStyle(styleBold);
                                while (itr3.hasNext()) {
                                    Object[] next = (Object[]) itr3.next();
                                    Cell cell6 = row6.createCell(k);
                                    String firstIn = "" + next[1];
                                    if (firstIn.contains("`") && !firstIn.contains("?")) {
                                        String[] firstIn1 = firstIn.split("`");
                                        String[] firstIn12 = firstIn1[1].split("!");
                                        cell6.setCellValue("" + firstIn12[0]);
                                    } else if (!firstIn.contains("`") && !firstIn.contains("?") && !firstIn.contains("AB") && !firstIn.equals("WO") && !firstIn.contains("TR") && !firstIn.contains("AR")) {
                                        if (firstIn.contains("Casual Leave")) {
                                            cl = cl + 1;
                                        }
                                        if (firstIn.contains("Privilege Leave")) {
                                            pl = pl + 1;
                                        }
                                        if (firstIn.contains("Sick Leave")) {
                                            sl = sl + 1;
                                        }
                                        cell6.setCellValue("" + next[1]);
                                    } else if (!firstIn.contains("`") && firstIn.contains("?") && !firstIn.contains("AB") && !firstIn.equals("WO") && !firstIn.contains("TR") && !firstIn.contains("AR")) {
                                        String[] hostring = firstIn.split("\\?");
                                        cell6.setCellValue("" + hostring[0]);
                                        holiday = holiday + 1;
                                    } else if (!firstIn.contains("`") && firstIn.contains("?") && firstIn.contains("AB") && !firstIn.equals("WO") && !firstIn.contains("TR") && !firstIn.contains("AR")) {
                                        cell6.setCellValue("-");
                                    } else if (firstIn.equals("WO")) {
                                        cell6.setCellValue(firstIn);
                                        wo = wo + 1;
                                    } else if (firstIn.equals("TR")) {
                                        cell6.setCellValue(firstIn);
                                        tr = tr + 1;
                                        cell6.setCellStyle(styleblue);
                                    }
                                    CellUtil.setAlignment(cell6, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    k++;
                                }

                                rownum = rownum + 1;
                                Row row7 = firstSheet.createRow(rownum);
                                Cell cellTitle3 = row7.createCell(0);
                                cellTitle3.setCellValue("Last Out");
                                cellTitle3.setCellStyle(styleBold);
                                Iterator itr4 = entry.getValue().iterator();
                                while (itr4.hasNext()) {
                                    Object[] next = (Object[]) itr4.next();
                                    Cell cell7 = row7.createCell(m);
                                    String lastOut = "" + next[1];
                                    if (lastOut.contains("!")) {
                                        String[] lastOut1 = lastOut.split("`");
                                        String[] lastOut2 = lastOut1[1].split("!");
                                        String[] lastOut3 = lastOut.split("!");
                                        String[] lastOut4 = lastOut3[1].split("@");
                                        Date lout = sdf1.parse(lastOut4[0]);
                                        Date fin = sdf1.parse(lastOut2[0]);
                                        if (lout.equals(fin)) {
                                            cell7.setCellValue("-");
                                        } else {
                                            cell7.setCellValue("" + lastOut4[0]);
                                        }

                                    } else if (lastOut.contains("@")) {
                                        cell7.setCellValue("-");
                                    }
                                    CellUtil.setAlignment(cell7, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    m++;
                                }
                                rownum = rownum + 1;
                                Row row8 = firstSheet.createRow(rownum);
                                Cell cellTitle4 = row8.createCell(0);
                                cellTitle4.setCellValue("First Half");
                                cellTitle4.setCellStyle(styleBold);
                                Iterator itr5 = entry.getValue().iterator();
                                int firstCounter = 0;
                                while (itr5.hasNext()) {
                                    Object[] next = (Object[]) itr5.next();
                                    Cell cell8 = row8.createCell(n);
                                    String firstHalf = "" + next[1];
                                    int firstHalfVal = 0;
                                    int counter = 0;

                                    if (firstHalf.contains("fullday")) {
                                        cell8.setCellValue("PR");
                                        prcounter = prcounter + 0.5;
                                        cell8.setCellStyle(stylegreen);

                                    } else if (!firstHalf.contains("fullday") && !firstHalf.equals("WO") && !firstHalf.equals("TR") && !firstHalf.equals("AR") && !firstHalf.equals("AB") && !firstHalf.contains("?")
                                            && !firstHalf.equals("Casual Leave") && !firstHalf.equals("Short Leave") && !firstHalf.equals("C Off Leave") && !firstHalf.equals("Privilege Leave") && !firstHalf.equals("Sick Leave")
                                            && !firstHalf.equals("Paternity Leave") && !firstHalf.equals("Maternity Leave") && !firstHalf.equals("Leave Without Pay")) {
                                        String[] leave = firstHalf.split("@");
                                        String[] leave1 = leave[1].split("#");
                                        String[] userTimeInStr = firstHalf.split("`");
                                        String[] userTimeInStr1 = userTimeInStr[1].split("!");
                                        String[] userTimeOutStr = firstHalf.split("!");
                                        String[] userTimeOutStr1 = userTimeOutStr[1].split("@");
                                        String[] LateHoursStr = firstHalf.split("\\$");
                                        String[] LateHoursStr1 = LateHoursStr[1].split("%");
                                        String[] endHoursStr = firstHalf.split("%");
                                        String[] endHoursStr1 = endHoursStr[1].split("\\^");
                                        String[] firstStartHoursStr = endHoursStr[1].split("\\+");
                                        Date userTimeIn = sdf1.parse(userTimeInStr1[0]);
                                        Date userTimeOut = sdf1.parse(userTimeOutStr1[0]);
                                        Date LateHours = sdf1.parse(LateHoursStr1[0]);
                                        Date endHours = sdf1.parse(endHoursStr1[0]);
                                        Date firstStartHours = sdf1.parse(firstStartHoursStr[1]);
                                        if (userTimeIn != null) {
                                            if ((userTimeIn.before(firstStartHours) || userTimeIn.equals(firstStartHours)) && (userTimeOut.after(endHours) || userTimeOut.equals(endHours))) {
                                                cell8.setCellValue("PR");
                                                prcounter = prcounter + 0.5;
                                                cell8.setCellStyle(stylegreen);
                                            } else if (leave1[0] != null && !leave1[0].contains("Short Leave")) {
                                                if ((userTimeIn.before(LateHours) || userTimeIn.equals(LateHours)) && (userTimeOut.after(endHours) || userTimeOut.equals(endHours)) && firstCounter <= 31) {
                                                    cell8.setCellValue("PR");
                                                    prcounter = prcounter + 0.5;
                                                    firstCounter = firstCounter + 1;
                                                    cell8.setCellStyle(stylegreen);
                                                } else if (leave1[0].contains("AB")) {
                                                    cell8.setCellValue("AB");
                                                    abcounter = abcounter + 0.5;
                                                    cell8.setCellStyle(stylered);
                                                } else if (leave1[0].contains("AR")) {
                                                    cell8.setCellValue("AR/P");
                                                    ar = ar + 0.5;
                                                    cell8.setCellStyle(styleblue);
                                                }

                                            } else if (null != leave1[0] && leave1[0].contains("Short Leave")) {
                                                if (firstHalf.contains("*")) {
                                                    String[] shortArray = firstHalf.split("\\*");
                                                    String[] endArray = shortArray[1].split("\\-");
                                                    String[] startTime = endArray[1].split("\\+");
                                                    Date shortIn = sdf1.parse(shortArray[1]);
                                                    Date shortend = sdf1.parse(endArray[1]);
                                                    Date startTime1 = sdf1.parse(startTime[1]);
                                                    if (shortIn.before(endHours)) {
                                                        cell8.setCellValue("SHL/P");
                                                        cell8.setCellStyle(stylegreen);
                                                        shl = shl + 1;
                                                    } else if (leave1[0].contains("~ AR")) {
                                                        cell8.setCellValue("AR/P");
                                                        ar = ar + 0.5;
                                                        cell8.setCellStyle(styleblue);
                                                    } else if (userTimeIn.after(endHours)) {
                                                        cell8.setCellValue("SHL/A");
                                                        shla = shla + 1;
                                                        cell8.setCellStyle(stylered);
                                                    } else if ((userTimeIn.before(LateHours) || userTimeIn.equals(LateHours)) && (userTimeOut.after(endHours) || userTimeOut.equals(endHours)) && firstCounter <= 31) {
                                                        cell8.setCellValue("PR");
                                                        prcounter = prcounter + 0.5;
                                                        firstCounter = firstCounter + 1;
                                                        cell8.setCellStyle(stylegreen);
                                                    } else {
                                                        cell8.setCellValue("AB");
                                                        abcounter = abcounter + 0.5;
                                                        cell8.setCellStyle(stylered);
                                                    }
                                                } else {
                                                    cell8.setCellValue("AB");
                                                    abcounter = abcounter + 0.5;
                                                    cell8.setCellStyle(stylered);
                                                }
                                            } else if (null != leave1[0] && !leave1[0].contains("AB")) {
                                                if (leave1[0].contains("Casual Leave")) {
                                                    cl = cl + 0.5;
                                                }
                                                if (leave1[0].contains("Privilege Leave")) {
                                                    pl = pl + 0.5;
                                                }
                                                if (leave1[0].contains("Sick Leave")) {
                                                    sl = sl + 0.5;
                                                }
                                                cell8.setCellValue(" " + leave1[0]);

                                            } else if (leave1[0].contains("AB")) {
                                                cell8.setCellValue("-");
                                            } else {
                                                cell8.setCellValue("AB");
                                                abcounter = abcounter + 0.5;
                                                cell8.setCellStyle(stylered);
                                            }

                                        } else if (userTimeIn != null && !firstHalf.contains("WO") && !firstHalf.contains("?")) {
                                            cell8.setCellValue("AB");
                                            abcounter = abcounter + 0.5;
                                            cell8.setCellStyle(stylered);
                                        } else if (firstHalf.contains("WO") || firstHalf.contains("?")) {
                                            cell8.setCellValue("-");
                                        }

                                    } else if (firstHalf.equals("WO")) {
                                        cell8.setCellValue("");
                                    } else if (firstHalf.contains("AR")) {
                                        cell8.setCellValue("AR/P");
                                        ar = ar + 0.5;
                                        cell8.setCellStyle(styleblue);
                                    } else if (firstHalf.equals("AB")) {
                                        cell8.setCellValue("AB");
                                        abcounter = abcounter + 0.5;
                                        cell8.setCellStyle(stylered);
                                    }
                                    CellUtil.setAlignment(cell8, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    n++;
                                }

                                rownum = rownum + 1;
                                Row row9 = firstSheet.createRow(rownum);
                                Cell cellTitle5 = row9.createCell(0);
                                cellTitle5.setCellValue("Second Half");
                                cellTitle5.setCellStyle(styleBold);
                                int weekNameCounter = 0;
                                boolean satWeekOff = false;
                                Iterator itr6 = entry.getValue().iterator();
                                while (itr6.hasNext()) {
                                    Object[] next = (Object[]) itr6.next();
                                    Cell cell9 = row9.createCell(o);
                                    String secondHalf = "" + next[1];
                                    int firstHalfVal = 0;
                                    int counter = 0;
                                    String shiftName = "";
                                    if (secondHalf.contains(" # ")) {
                                        String[] string1 = secondHalf.split("#");
                                        String[] string2 = string1[1].split("\\$");
                                        shiftName = string2[0].trim();

                                    }

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

                                    if (satWeekOff == true && (zydexLocationMaster.getZydexLocation().equals("HO") || zydexLocationMaster.getZydexLocation().equals("R&D"))) {
                                        cell9.setCellValue("WO");
                                        wo = wo + 0.5;
                                    } else if (secondHalf.contains("fullday")) {
                                        cell9.setCellValue("PR");
                                        prcounter = prcounter + 0.5;
                                        cell9.setCellStyle(stylegreen);

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

                                        Date userTimeIn = sdf1.parse(userTimeInStr1[0]);
                                        Date userTimeOut = sdf1.parse(userTimeOutStr1[0]);

                                        String[] getInHours = userTimeInStr1[0].split(":");
                                        String[] getOutHours = userTimeOutStr1[0].split(":");
                                        String abc = getInHours[0].trim();
                                        String xyz = getOutHours[0].trim();
                                        int i11 = Integer.parseInt(abc) - Integer.parseInt(xyz);
                                        int totalDuration = 24 - i11;
                                        String totalDuration2 = getOutHours[0];
                                        Date endHours = sdf1.parse(endHoursStr[1]);
                                        Date secondHalfTimeStr2 = sdf1.parse(secondHalfTimeStr1[0]);

                                        if (userTimeIn != null) {
                                            if ((userTimeIn.before(secondHalfTimeStr2) || userTimeIn.equals(secondHalfTimeStr2)) && (userTimeOut.after(endHours) || userTimeOut.equals(endHours))) {
                                                cell9.setCellValue("PR");
                                                prcounter = prcounter + 0.5;
                                                cell9.setCellStyle(stylegreen);
                                            } else if (shiftName.contains("Night") && (userTimeOut.after(endHours) || userTimeOut.equals(endHours))) {
                                                cell9.setCellValue("PR");
                                                prcounter = prcounter + 0.5;
                                                cell9.setCellStyle(stylegreen);
                                            } else if (null != leave1[0] && leave1[0].contains("Short Leave")) {
                                                if (secondHalf.contains("*")) {
                                                    String[] shortArray = secondHalf.split("\\*");
                                                    String[] endArray = secondHalf.split("\\^");
                                                    String[] secondhalfstartTime = endArray[1].split("&");
                                                    Date shortIn = sdf1.parse(shortArray[1]);
                                                    Date shortend = sdf1.parse(endArray[1]);
                                                    Date secondhalfstartTime1 = sdf1.parse(secondhalfstartTime[0]);
                                                    if ((secondhalfstartTime1.before(shortIn) || secondhalfstartTime1.equals(shortIn)) && (shortIn.before(endHours) || shortIn.equals(endHours))) {
                                                        if (userTimeOut.after(secondHalfTimeStr2)) {
                                                            cell9.setCellValue("SHL/P");
                                                            shl = shl + 1;
                                                            cell9.setCellStyle(stylegreen);
                                                        } else if (leave1[0].contains("~ AR")) {
                                                            cell9.setCellValue("AR/P");
                                                            ar = ar + 0.5;
                                                            cell9.setCellStyle(styleblue);
                                                        } else if (userTimeOut.before(secondHalfTimeStr2) || userTimeOut.equals(secondHalfTimeStr2)) {
                                                            cell9.setCellValue("SHL/A");
                                                            shla = shla + 1;
                                                            cell9.setCellStyle(stylered);
                                                        } else {
                                                            cell9.setCellValue("AB");
                                                            abcounter = abcounter + 0.5;
                                                            cell9.setCellStyle(stylered);
                                                        }
                                                    }
                                                } else {
                                                    cell9.setCellValue("AB");
                                                    abcounter = abcounter + 0.5;
                                                    cell9.setCellStyle(stylered);
                                                }
                                            } else if (null != leave1[0] && !leave1[0].contains("AB") && !leave1[0].contains("AR")) {
                                                if (leave1[0].contains("Casual Leave")) {
                                                    cl = cl + 0.5;
                                                }
                                                if (leave1[0].contains("Privilege Leave")) {
                                                    pl = pl + 0.5;
                                                }
                                                if (leave1[0].contains("Sick Leave")) {
                                                    sl = sl + 0.5;
                                                }
                                                cell9.setCellValue(" " + leave1[0]);

                                            } else if (leave1[0].contains("AR")) {
                                                cell9.setCellValue("AR/P");
                                                ar = ar + 0.5;
                                                cell9.setCellStyle(styleblue);
                                            } else if (leave1[0].contains("AB")) {
                                                cell9.setCellValue("AB");
                                                abcounter = abcounter + 0.5;
                                                cell9.setCellStyle(stylered);
                                            } else {
                                                cell9.setCellValue("AB");
                                                abcounter = abcounter + 0.5;
                                                cell9.setCellStyle(stylered);
                                            }

                                        } else if (userTimeIn != null && !secondHalf.contains("WO") && !secondHalf.contains("?")) {
                                            cell9.setCellValue("AB");
                                            abcounter = abcounter + 0.5;
                                            cell9.setCellStyle(stylered);
                                        } else if (secondHalf.contains("WO") || secondHalf.contains("?")) {
                                            cell9.setCellValue("-");
                                        }

                                    } else if (secondHalf.equals("WO")) {
                                        cell9.setCellValue("-");
                                    } else if (secondHalf.contains("AR")) {
                                        cell9.setCellValue("AR/P");
                                        ar = ar + 0.5;
                                        cell9.setCellStyle(styleblue);
                                    } else if (secondHalf.equals("AB")) {
                                        cell9.setCellValue("AB");
                                        abcounter = abcounter + 0.5;
                                        cell9.setCellStyle(stylered);
                                    }
                                    CellUtil.setAlignment(cell9, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    o++;
                                }

                            }
                            rownum = rownum + 1;
                            Row dayCount1 = firstSheet.createRow(rownum);
                            rownum = rownum + 1;
                            Row dayCount = firstSheet.createRow(rownum);
                            Cell dayCounrCell = dayCount.createCell(0);
                            dayCounrCell.setCellValue("Day Count");
                            dayCounrCell.setCellStyle(styleBold);

                            rownum = rownum + 1;
                            Row row13 = firstSheet.createRow(rownum);
                            for (int y = 1; y < 10;) {
                                if (prcounter != 0) {
                                    Cell cell12 = row13.createCell(y);
                                    cell12.setCellValue("PR");
                                    cell12.setCellStyle(stylegreen);
                                    CellUtil.setAlignment(cell12, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    y++;
                                }
                                if (abcounter != 0) {
                                    Cell cell13 = row13.createCell(y);
                                    cell13.setCellValue("AB");
                                    cell13.setCellStyle(stylered);
                                    CellUtil.setAlignment(cell13, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    y++;
                                }
                                if (shl != 0) {
                                    Cell cell14 = row13.createCell(y);
                                    cell14.setCellValue("SHL/P");
                                    cell14.setCellStyle(stylegreen);
                                    CellUtil.setAlignment(cell14, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    y++;
                                }
                                if (shla != 0) {
                                    Cell cell15 = row13.createCell(y);
                                    cell15.setCellValue("SHL/A");
                                    cell15.setCellStyle(stylered);
                                    CellUtil.setAlignment(cell15, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    y++;
                                }
                                if (cl != 0) {
                                    Cell cell16 = row13.createCell(y);
                                    cell16.setCellValue("CL");
                                    cell16.setCellStyle(styleBold);
                                    CellUtil.setAlignment(cell16, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    y++;
                                }
                                if (sl != 0) {
                                    Cell cell17 = row13.createCell(y);
                                    cell17.setCellValue("SL");
                                    cell17.setCellStyle(styleBold);
                                    CellUtil.setAlignment(cell17, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    y++;
                                }
                                if (pl != 0) {
                                    Cell cell18 = row13.createCell(y);
                                    cell18.setCellValue("PL");
                                    cell18.setCellStyle(styleBold);
                                    CellUtil.setAlignment(cell18, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    y++;
                                }
                                if (holiday != 0) {
                                    Cell cell19 = row13.createCell(y);
                                    cell19.setCellValue("HOLIDAY");
                                    cell19.setCellStyle(styleBold);
                                    CellUtil.setAlignment(cell19, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    y++;
                                }
                                if (ar != 0) {
                                    Cell cell20 = row13.createCell(y);
                                    cell20.setCellValue("AR/P");
                                    cell20.setCellStyle(styleblue);
                                    CellUtil.setAlignment(cell20, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    y++;
                                }
                                if (wo != 0) {
                                    Cell cell21 = row13.createCell(y);
                                    cell21.setCellValue("WO");
                                    cell21.setCellStyle(styleBold);
                                    CellUtil.setAlignment(cell21, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    y++;
                                }
                                if (tr != 0) {
                                    Cell cell22 = row13.createCell(y);
                                    cell22.setCellValue("TR");
                                    cell22.setCellStyle(styleblue);
                                    CellUtil.setAlignment(cell22, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                }
                                break;
                            }

                            rownum = rownum + 1;
                            Row row12 = firstSheet.createRow(rownum);
                            for (int x = 1; x < 10;) {
                                if (prcounter != 0) {
                                    Cell cell12 = row12.createCell(x);
                                    cell12.setCellType(Cell.CELL_TYPE_NUMERIC);
                                    double newshl = shl / 2;
                                    double nepr = prcounter - newshl;
                                    cell12.setCellValue(nepr);
                                    CellUtil.setAlignment(cell12, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    x++;
                                }
                                if (abcounter != 0) {
                                    Cell cell13 = row12.createCell(x);
                                    cell13.setCellType(Cell.CELL_TYPE_NUMERIC);
                                    cell13.setCellValue(abcounter);
                                    CellUtil.setAlignment(cell13, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    x++;
                                }
                                if (shl != 0) {
                                    Cell cell14 = row12.createCell(x);
                                    cell14.setCellType(Cell.CELL_TYPE_NUMERIC);
                                    cell14.setCellValue(shl);
                                    CellUtil.setAlignment(cell14, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    x++;
                                }
                                if (shla != 0) {
                                    Cell cell15 = row12.createCell(x);
                                    cell15.setCellType(Cell.CELL_TYPE_NUMERIC);
                                    cell15.setCellValue(shla);
                                    CellUtil.setAlignment(cell15, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    x++;
                                }
                                if (cl != 0) {
                                    Cell cell16 = row12.createCell(x);
                                    cell16.setCellType(Cell.CELL_TYPE_NUMERIC);
                                    cell16.setCellValue(cl);
                                    CellUtil.setAlignment(cell16, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    x++;
                                }
                                if (sl != 0) {
                                    Cell cell17 = row12.createCell(x);
                                    cell17.setCellType(Cell.CELL_TYPE_NUMERIC);
                                    cell17.setCellValue(sl);
                                    CellUtil.setAlignment(cell17, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    x++;
                                }
                                if (pl != 0) {
                                    Cell cell18 = row12.createCell(x);
                                    cell18.setCellType(Cell.CELL_TYPE_NUMERIC);
                                    cell18.setCellValue(pl);
                                    CellUtil.setAlignment(cell18, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    x++;
                                }
                                if (holiday != 0) {
                                    Cell cell19 = row12.createCell(x);
                                    cell19.setCellType(Cell.CELL_TYPE_NUMERIC);
                                    cell19.setCellValue(holiday);
                                    CellUtil.setAlignment(cell19, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    x++;
                                }
                                if (ar != 0) {
                                    Cell cell20 = row12.createCell(x);
                                    cell20.setCellType(Cell.CELL_TYPE_NUMERIC);
                                    cell20.setCellValue(ar);
                                    CellUtil.setAlignment(cell20, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    x++;
                                }
                                if (wo != 0) {
                                    Cell cell21 = row12.createCell(x);
                                    cell21.setCellType(Cell.CELL_TYPE_NUMERIC);
                                    cell21.setCellValue(wo);
                                    CellUtil.setAlignment(cell21, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    x++;
                                }
                                if (tr != 0) {
                                    Cell cell22 = row12.createCell(x);
                                    cell22.setCellType(Cell.CELL_TYPE_NUMERIC);
                                    cell22.setCellValue(tr);
                                    CellUtil.setAlignment(cell22, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                }
                                break;
                            }
                        }
                    }

                }

                rownum++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }

        String appPath = request.getServletContext().getRealPath("");
        try {
            String filePath = appPath + File.separator + "StorageYard" + File.separator
                    + "Other" + File.separator + "UserDoc" + File.separator
                    + "EmployeeShiftData" + File.separator + "EmployeeAdvanceSearch.xls";
            FileOutputStream fos = new FileOutputStream(new File(filePath));
            HSSFCellStyle hsfstyle = firstFWorkbook.createCellStyle();
            hsfstyle.setBorderBottom((short) 1);
            hsfstyle.setFillBackgroundColor((short) 245);
            firstFWorkbook.write(fos);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String filePath = File.separator + "StorageYard" + File.separator
                + "Other" + File.separator + "UserDoc" + File.separator
                + "EmployeeShiftData" + File.separator + "EmployeeAdvanceSearch.xls";

        appPath = request.getServletContext().getRealPath("");

        String fullPath = appPath + filePath;

        request.setAttribute("filePath", fullPath);

        DownloadFile downloadFile = new DownloadFile();
        downloadFile.doDownload(request, response);
        mv = employeeDataSearch(request, response);
        return mv;
    }

    public ModelAndView attendanceExcelUpload(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("AttendanceRegularization/attendanceExcelUpload");
        return mv;
    }

    public void readEmployeeFile(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        String fileName = request.getParameter("fileName");

        String filePath = File.separator + "StorageYard" + File.separator
                + "Other" + File.separator + "UserDoc" + File.separator
                + "AttandanceUpload" + File.separator + fileName;

        String appPath = request.getServletContext().getRealPath("");

        String fullPath = appPath + filePath;

        request.setAttribute("filePath", fullPath);

        DownloadFile downloadFile = new DownloadFile();
        downloadFile.doDownload(request, response);
    }

    public ModelAndView attendanceExcelUploadSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile = multipartRequest.getFile("file1");
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        ShiftGenerateMonthlySchedule shiftGenerateMonthlySchedule = new ShiftGenerateMonthlySchedule();
        EmployeeShiftData employeeShiftData = new EmployeeShiftData();
        EmployeeShiftData employeeShiftData1 = new EmployeeShiftData();
        LeaveTypeMaster leaveTypeMaster = new LeaveTypeMaster();
        ShiftMaster shiftMaster = new ShiftMaster();
        ShiftMaster shiftMaster1 = new ShiftMaster();
        EmployeeLeaveBalance employeeLeaveBalance = new EmployeeLeaveBalance();
        EmployeeLeaveBalance employeeLeaveBalance1 = new EmployeeLeaveBalance();
        LeaveEmployeeDetail leaveEmployeeDetail = new LeaveEmployeeDetail();
        LeaveEmployeeDetail leaveEmployeeDetail1 = new LeaveEmployeeDetail();

        String rowString = "";
        String employeeNo = "";
        String col1 = "";
        String month = "";
        String year = "";
        String cl = "Casual Leave";
        String pl = "Privilege Leave";
        String sl = "Sick Leave";
        String shl = "Short Leave";
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        try {
            if (multipartFile.getSize() > 0) {
                InputStream file = multipartFile.getInputStream();
                Workbook workbook = WorkbookFactory.create(file);
                Sheet sheet = workbook.getSheetAt(0);
                for (Row row : sheet) {
                    if (row.getRowNum() >= 0) {
                        rowString = "" + (null == row.getCell((short) 0) ? "" : row.getCell((short) 0));
                        if (rowString.equalsIgnoreCase("Employee ID")) {
                            try {
                                employeeNo = new BigDecimal("" + (null == row.getCell((short) 1) ? "" : row.getCell((short) 1))).toPlainString();
                                employeeNo = employeeNo.split("\\.", 2)[0];
                            } catch (Exception e) {
                                employeeNo = "" + (null == row.getCell((short) 0) ? "" : row.getCell((short) 0));
                            }
                            List<?> list = employeeMasterService.readEmployeeId(employeeNo);
                            employeeMaster = (EmployeeMaster) list.get(0);
                            continue;
                        }
                        if (rowString.equalsIgnoreCase("Date")) {
                            try {
                                for (int i = 1; i <= 1; i++) {
                                    col1 = "";
                                    col1 = "" + (null == row.getCell((short) i) ? "" : row.getCell((short) i));
                                    if (col1 != "") {
                                        Date date = sdf.parse(col1);
                                        col1 = sdf1.format(date);
                                        String[] s1 = col1.split("/");
                                        month = s1[1];
                                        year = s1[2];
                                    }
                                }
                            } catch (Exception e) {

                            }
                            continue;
                        }
                        if (rowString.equalsIgnoreCase("First Half")) {
                            try {
                                for (int i = 1; i <= 31; i++) {
                                    col1 = "";
                                    col1 = "" + (null == row.getCell((short) i) ? "" : row.getCell((short) i));
                                    if (col1 != "") {
                                        if (col1.equalsIgnoreCase("PR")) {
                                            String punchInDate = i + "/" + month + "/" + year;
                                            String punchoutDate = i + "/" + month + "/" + year;
                                            shiftGenerateMonthlySchedule.setEmployeeMaster(employeeMaster);
                                            shiftGenerateMonthlySchedule.setShiftMonth(month);
                                            shiftGenerateMonthlySchedule.setShiftYear(year);
                                            List<?> currentShift = shiftGenerateMonthlyScheduleService.readByDayWiseEmployeeShiftData(shiftGenerateMonthlySchedule, i);

                                            Object shiftId = (Object) currentShift.get(0);
                                            int shiftId1 = (int) shiftId;
                                            employeeShiftData1.setInDateTime(punchInDate);
                                            employeeShiftData1.setEmployeeMaster(employeeMaster);
                                            List<?> empShiftDataList = employeeShiftDataService.attendanceRegularizationEntry(employeeShiftData1);
                                            if (shiftId1 != -1) {
                                                if (empShiftDataList.size() != 0) {
                                                    shiftMaster.setId(shiftId1);
                                                    List<?> shift = shiftMasterService.readByShiftId(shiftMaster);
                                                    shiftMaster1 = (ShiftMaster) shift.get(0);
                                                    punchInDate = punchInDate + " " + shiftMaster1.getStartTime();
                                                    punchoutDate = punchoutDate + " " + shiftMaster1.getHalfEndTime1();
                                                    employeeShiftData.setEmployeeMaster(employeeMaster);
                                                    employeeShiftData.setInDateTime(punchInDate);
                                                    employeeShiftData.setOutDateTime(punchoutDate);
                                                    employeeShiftData.setShiftMaster(shiftMaster);
                                                    employeeShiftDataService.update(employeeShiftData);

                                                } else {
                                                    shiftMaster.setId(shiftId1);
                                                    List<?> shift = shiftMasterService.readByShiftId(shiftMaster);
                                                    shiftMaster1 = (ShiftMaster) shift.get(0);
                                                    punchInDate = punchInDate + " " + shiftMaster1.getStartTime();
                                                    punchoutDate = punchoutDate + " " + shiftMaster1.getHalfEndTime1();
                                                    employeeShiftData.setEmployeeMaster(employeeMaster);
                                                    employeeShiftData.setInDateTime(punchInDate);
                                                    employeeShiftData.setOutDateTime(punchoutDate);
                                                    employeeShiftData.setShiftMaster(shiftMaster);
                                                    employeeShiftDataService.create(employeeShiftData);

                                                }

                                            }
                                        }
                                        if (col1.equalsIgnoreCase("CL")) {
                                            String leaveStartDate = i + "/" + month + "/" + year;
                                            List<?> clList = leaveTypeMasterService.readLeaveType(cl);
                                            leaveTypeMaster = (LeaveTypeMaster) clList.get(0);
                                            employeeLeaveBalance.setLeaveTypeMaster(leaveTypeMaster);
                                            employeeLeaveBalance.setEmployeeMaster(employeeMaster);
                                            List<?> empLeaveBalList = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance);
                                            if (empLeaveBalList.size() > 0) {
                                                employeeLeaveBalance1 = (EmployeeLeaveBalance) empLeaveBalList.get(0);
                                                float noOfLeave = employeeLeaveBalance1.getNoOfLeaveRemain();
                                                float noOfdays = (float) 0.5;
                                                noOfLeave = noOfLeave - noOfdays;
                                                employeeLeaveBalance1.setNoOfLeaveRemain(noOfLeave);
                                                employeeLeaveBalanceService.update(employeeLeaveBalance1);

                                                leaveEmployeeDetail.setEmployeeMaster(employeeMaster);
                                                leaveEmployeeDetail.setLeaveTypeMaster(leaveTypeMaster);
                                                leaveEmployeeDetail.setStartDate(leaveStartDate);
                                                leaveEmployeeDetail.setStartDateStatus("FirstHalf");
                                                leaveEmployeeDetail.setEndDate(leaveStartDate);
                                                leaveEmployeeDetail.setNoOfDays(noOfdays);
                                                leaveEmployeeDetail.setStatus(3);
                                                leaveEmployeeDetail.setApproverId(employeeMaster1.getId());
                                                leaveEmployeeDetail.setApproveDate(leaveStartDate);
                                                leaveEmployeeDetailService.create(leaveEmployeeDetail);
                                            }
                                        }
                                        if (col1.equalsIgnoreCase("SL")) {
                                            String leaveStartDate = i + "/" + month + "/" + year;
                                            List<?> slList = leaveTypeMasterService.readLeaveType(sl);
                                            leaveTypeMaster = (LeaveTypeMaster) slList.get(0);
                                            employeeLeaveBalance.setLeaveTypeMaster(leaveTypeMaster);
                                            employeeLeaveBalance.setEmployeeMaster(employeeMaster);
                                            List<?> empLeaveBalList = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance);
                                            if (empLeaveBalList.size() > 0) {
                                                employeeLeaveBalance1 = (EmployeeLeaveBalance) empLeaveBalList.get(0);
                                                float noOfLeave = employeeLeaveBalance1.getNoOfLeaveRemain();
                                                float noOfdays = (float) 0.5;
                                                noOfLeave = noOfLeave - noOfdays;
                                                employeeLeaveBalance1.setNoOfLeaveRemain(noOfLeave);
                                                employeeLeaveBalanceService.update(employeeLeaveBalance1);

                                                leaveEmployeeDetail.setEmployeeMaster(employeeMaster);
                                                leaveEmployeeDetail.setLeaveTypeMaster(leaveTypeMaster);
                                                leaveEmployeeDetail.setStartDate(leaveStartDate);
                                                leaveEmployeeDetail.setStartDateStatus("FirstHalf");
                                                leaveEmployeeDetail.setEndDate(leaveStartDate);
                                                leaveEmployeeDetail.setNoOfDays(noOfdays);
                                                leaveEmployeeDetail.setStatus(3);
                                                leaveEmployeeDetail.setApproverId(employeeMaster1.getId());
                                                leaveEmployeeDetail.setApproveDate(leaveStartDate);
                                                leaveEmployeeDetailService.create(leaveEmployeeDetail);
                                            }

                                        }
                                        if (col1.equalsIgnoreCase("PL")) {
                                            String leaveStartDate = i + "/" + month + "/" + year;
                                            List<?> plList = leaveTypeMasterService.readLeaveType(pl);
                                            leaveTypeMaster = (LeaveTypeMaster) plList.get(0);
                                            employeeLeaveBalance.setLeaveTypeMaster(leaveTypeMaster);
                                            employeeLeaveBalance.setEmployeeMaster(employeeMaster);
                                            List<?> empLeaveBalList = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance);
                                            if (empLeaveBalList.size() > 0) {
                                                employeeLeaveBalance1 = (EmployeeLeaveBalance) empLeaveBalList.get(0);
                                                float noOfLeave = employeeLeaveBalance1.getNoOfLeaveRemain();
                                                float noOfdays = (float) 0.5;
                                                noOfLeave = noOfLeave - noOfdays;
                                                employeeLeaveBalance1.setNoOfLeaveRemain(noOfLeave);
                                                employeeLeaveBalanceService.update(employeeLeaveBalance1);

                                                leaveEmployeeDetail.setEmployeeMaster(employeeMaster);
                                                leaveEmployeeDetail.setLeaveTypeMaster(leaveTypeMaster);
                                                leaveEmployeeDetail.setStartDate(leaveStartDate);
                                                leaveEmployeeDetail.setStartDateStatus("FirstHalf");
                                                leaveEmployeeDetail.setEndDate(leaveStartDate);
                                                leaveEmployeeDetail.setNoOfDays(noOfdays);
                                                leaveEmployeeDetail.setStatus(3);
                                                leaveEmployeeDetail.setApproverId(employeeMaster1.getId());
                                                leaveEmployeeDetail.setApproveDate(leaveStartDate);
                                                leaveEmployeeDetailService.create(leaveEmployeeDetail);
                                            }

                                        }
                                        if (col1.equalsIgnoreCase("SHL/P")) {
                                            String leaveStartDate = i + "/" + month + "/" + year;
                                            String punchInDate = i + "/" + month + "/" + year;
                                            String punchoutDate = i + "/" + month + "/" + year;
                                            String approveDate = i + "/" + month + "/" + year;

                                            shiftGenerateMonthlySchedule.setEmployeeMaster(employeeMaster);
                                            shiftGenerateMonthlySchedule.setShiftMonth(month);
                                            shiftGenerateMonthlySchedule.setShiftYear(year);
                                            List<?> currentShift = shiftGenerateMonthlyScheduleService.readByDayWiseEmployeeShiftData(shiftGenerateMonthlySchedule, i);

                                            Object shiftId = (Object) currentShift.get(0);
                                            int shiftId1 = (int) shiftId;

                                            if (shiftId1 != -1) {
                                                shiftMaster.setId(shiftId1);
                                                List<?> shift = shiftMasterService.readByShiftId(shiftMaster);
                                                shiftMaster1 = (ShiftMaster) shift.get(0);
                                                punchInDate = punchInDate + " " + shiftMaster1.getStartTime();
                                                punchoutDate = punchoutDate + " " + shiftMaster1.getHalfEndTime1();
                                                leaveStartDate = leaveStartDate + " " + shiftMaster1.getStartTime();
                                                Date date = sdf2.parse(punchInDate);
                                                Calendar cal = Calendar.getInstance();
                                                cal.setTime(date);
                                                cal.add(Calendar.HOUR, +2);
                                                Date oneHourBack = cal.getTime();
                                                punchInDate = sdf2.format(oneHourBack);

                                                employeeShiftData.setEmployeeMaster(employeeMaster);
                                                employeeShiftData.setInDateTime(punchInDate);
                                                employeeShiftData.setOutDateTime(punchoutDate);
                                                employeeShiftData.setShiftMaster(shiftMaster);
                                                employeeShiftDataService.create(employeeShiftData);
                                            }

                                            List<?> shlList = leaveTypeMasterService.readLeaveType(shl);
                                            leaveTypeMaster = (LeaveTypeMaster) shlList.get(0);
                                            employeeLeaveBalance.setLeaveTypeMaster(leaveTypeMaster);
                                            employeeLeaveBalance.setEmployeeMaster(employeeMaster);
                                            List<?> empLeaveBalList = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance);
                                            if (empLeaveBalList.size() > 0) {
                                                employeeLeaveBalance1 = (EmployeeLeaveBalance) empLeaveBalList.get(0);
                                                float noOfLeave = employeeLeaveBalance1.getNoOfLeaveRemain();
                                                float noOfdays = (float) 1;
                                                noOfLeave = noOfLeave - noOfdays;
                                                employeeLeaveBalance1.setNoOfLeaveRemain(noOfLeave);
                                                employeeLeaveBalanceService.update(employeeLeaveBalance1);

                                                leaveEmployeeDetail.setEmployeeMaster(employeeMaster);
                                                leaveEmployeeDetail.setLeaveTypeMaster(leaveTypeMaster);
                                                leaveEmployeeDetail.setStartDate(leaveStartDate);
                                                leaveEmployeeDetail.setEndDate(punchInDate);
                                                leaveEmployeeDetail.setStatus(3);
                                                leaveEmployeeDetail.setApproverId(employeeMaster1.getId());
                                                leaveEmployeeDetail.setApproveDate(approveDate);
                                                leaveEmployeeDetailService.create(leaveEmployeeDetail);
                                            }

                                        }
                                        if (col1.equalsIgnoreCase("SHL/A")) {
                                            String leaveStartDate = i + "/" + month + "/" + year;
                                            String punchInDate = i + "/" + month + "/" + year;
                                            String punchoutDate = i + "/" + month + "/" + year;
                                            String approveDate = i + "/" + month + "/" + year;

                                            shiftGenerateMonthlySchedule.setEmployeeMaster(employeeMaster);
                                            shiftGenerateMonthlySchedule.setShiftMonth(month);
                                            shiftGenerateMonthlySchedule.setShiftYear(year);
                                            List<?> currentShift = shiftGenerateMonthlyScheduleService.readByDayWiseEmployeeShiftData(shiftGenerateMonthlySchedule, i);

                                            Object shiftId = (Object) currentShift.get(0);
                                            int shiftId1 = (int) shiftId;

                                            if (shiftId1 != -1) {
                                                shiftMaster.setId(shiftId1);
                                                List<?> shift = shiftMasterService.readByShiftId(shiftMaster);
                                                shiftMaster1 = (ShiftMaster) shift.get(0);
                                                punchInDate = punchInDate + " " + shiftMaster1.getStartTime();
                                                leaveStartDate = leaveStartDate + " " + shiftMaster1.getStartTime();
                                                Date date = sdf2.parse(punchInDate);
                                                Calendar cal = Calendar.getInstance();
                                                cal.setTime(date);
                                                cal.add(Calendar.HOUR, +2);
                                                Date oneHourBack = cal.getTime();
                                                punchInDate = sdf2.format(oneHourBack);
                                            }

                                            List<?> shlList = leaveTypeMasterService.readLeaveType(shl);
                                            leaveTypeMaster = (LeaveTypeMaster) shlList.get(0);
                                            employeeLeaveBalance.setLeaveTypeMaster(leaveTypeMaster);
                                            employeeLeaveBalance.setEmployeeMaster(employeeMaster);
                                            List<?> empLeaveBalList = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance);
                                            if (empLeaveBalList.size() > 0) {
                                                employeeLeaveBalance1 = (EmployeeLeaveBalance) empLeaveBalList.get(0);
                                                float noOfLeave = employeeLeaveBalance1.getNoOfLeaveRemain();
                                                float noOfdays = (float) 1;
                                                noOfLeave = noOfLeave - noOfdays;
                                                employeeLeaveBalance1.setNoOfLeaveRemain(noOfLeave);
                                                employeeLeaveBalanceService.update(employeeLeaveBalance1);

                                                leaveEmployeeDetail.setEmployeeMaster(employeeMaster);
                                                leaveEmployeeDetail.setLeaveTypeMaster(leaveTypeMaster);
                                                leaveEmployeeDetail.setStartDate(leaveStartDate);
                                                leaveEmployeeDetail.setEndDate(punchInDate);
                                                leaveEmployeeDetail.setStatus(3);
                                                leaveEmployeeDetail.setApproverId(employeeMaster1.getId());
                                                leaveEmployeeDetail.setApproveDate(approveDate);
                                                leaveEmployeeDetailService.create(leaveEmployeeDetail);
                                            }

                                        }

                                    }
                                }
                            } catch (Exception e) {

                            }

                            continue;
                        }
                        if (rowString.equalsIgnoreCase("Second Half")) {
                            try {
                                for (int i = 1; i <= 31; i++) {
                                    col1 = "";
                                    col1 = "" + (null == row.getCell((short) i) ? "" : row.getCell((short) i));
                                    if (col1 != "") {
                                        if (col1.equalsIgnoreCase("PR")) {
                                            String punchInDate = i + "/" + month + "/" + year;
                                            String punchInDate1 = i + "/" + month + "/" + year;
                                            String punchoutDate = i + "/" + month + "/" + year;
                                            employeeShiftData1.setInDateTime(punchInDate);
                                            employeeShiftData1.setEmployeeMaster(employeeMaster);
                                            List<?> empShiftDataList = employeeShiftDataService.attendanceRegularizationEntry(employeeShiftData1);
                                            if (empShiftDataList.size() != 0) {
                                                employeeShiftData = (EmployeeShiftData) empShiftDataList.get(0);
                                                shiftMaster1.setId(employeeShiftData.getShiftMaster().getId());
                                                List<?> shift = shiftMasterService.readByShiftId(shiftMaster);
                                                shiftMaster = (ShiftMaster) shift.get(0);
                                                punchoutDate = punchoutDate + " " + shiftMaster.getEndTime();
                                                employeeShiftData.setOutDateTime(punchoutDate);
                                                employeeShiftDataService.update(employeeShiftData);
                                            } else {
                                                shiftGenerateMonthlySchedule.setEmployeeMaster(employeeMaster);
                                                shiftGenerateMonthlySchedule.setShiftMonth(month);
                                                shiftGenerateMonthlySchedule.setShiftYear(year);
                                                List<?> currentShift = shiftGenerateMonthlyScheduleService.readByDayWiseEmployeeShiftData(shiftGenerateMonthlySchedule, i);

                                                Object shiftId = (Object) currentShift.get(0);
                                                int shiftId1 = (int) shiftId;

                                                if (shiftId1 != -1) {
                                                    shiftMaster.setId(shiftId1);
                                                    List<?> shift = shiftMasterService.readByShiftId(shiftMaster);
                                                    shiftMaster1 = (ShiftMaster) shift.get(0);
                                                    punchInDate = punchInDate + " " + shiftMaster1.getHalfStartTime2();
                                                    punchoutDate = punchoutDate + " " + shiftMaster1.getEndTime();
                                                    employeeShiftData.setEmployeeMaster(employeeMaster);
                                                    employeeShiftData.setInDateTime(punchInDate);
                                                    employeeShiftData.setOutDateTime(punchoutDate);
                                                    employeeShiftData.setShiftMaster(shiftMaster);
                                                    employeeShiftDataService.create(employeeShiftData);
                                                }
                                            }
                                        }
                                        if (col1.equalsIgnoreCase("CL")) {
                                            String leaveStartDate = i + "/" + month + "/" + year;
                                            List<?> clList = leaveTypeMasterService.readLeaveType(cl);
                                            leaveTypeMaster = (LeaveTypeMaster) clList.get(0);

                                            employeeLeaveBalance.setLeaveTypeMaster(leaveTypeMaster);
                                            employeeLeaveBalance.setEmployeeMaster(employeeMaster);
                                            List<?> empLeaveBalList = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance);
                                            if (empLeaveBalList.size() > 0) {
                                                employeeLeaveBalance1 = (EmployeeLeaveBalance) empLeaveBalList.get(0);
                                                float noOfLeave = employeeLeaveBalance1.getNoOfLeaveRemain();
                                                float noOfdays = (float) 0.5;
                                                noOfLeave = noOfLeave - noOfdays;
                                                employeeLeaveBalance1.setNoOfLeaveRemain(noOfLeave);
                                                employeeLeaveBalanceService.update(employeeLeaveBalance1);

                                                leaveEmployeeDetail1.setEmployeeMaster(employeeMaster);
                                                leaveEmployeeDetail1.setStartDate(leaveStartDate);
                                                List<?> list = leaveEmployeeDetailService.dateWiseLeaveSelectionOfEmployee(leaveEmployeeDetail1);
                                                if (list.size() != 0) {
                                                    leaveEmployeeDetail = (LeaveEmployeeDetail) list.get(0);
                                                    leaveEmployeeDetail.setNoOfDays((float) 1);
                                                    leaveEmployeeDetail.setStartDateStatus("Fullday");
                                                    leaveEmployeeDetailService.update(leaveEmployeeDetail);
                                                } else {
                                                    leaveEmployeeDetail.setEmployeeMaster(employeeMaster);
                                                    leaveEmployeeDetail.setLeaveTypeMaster(leaveTypeMaster);
                                                    leaveEmployeeDetail.setStartDate(leaveStartDate);
                                                    leaveEmployeeDetail.setStartDateStatus("FirstHalf");
                                                    leaveEmployeeDetail.setEndDate(leaveStartDate);
                                                    leaveEmployeeDetail.setNoOfDays(noOfdays);
                                                    leaveEmployeeDetail.setStatus(3);
                                                    leaveEmployeeDetail.setApproverId(employeeMaster1.getId());
                                                    leaveEmployeeDetail.setApproveDate(leaveStartDate);
                                                    leaveEmployeeDetailService.create(leaveEmployeeDetail);
                                                }
                                            }

                                        }
                                        if (col1.equalsIgnoreCase("SL")) {
                                            String leaveStartDate = i + "/" + month + "/" + year;
                                            List<?> slList = leaveTypeMasterService.readLeaveType(sl);
                                            leaveTypeMaster = (LeaveTypeMaster) slList.get(0);

                                            employeeLeaveBalance.setLeaveTypeMaster(leaveTypeMaster);
                                            employeeLeaveBalance.setEmployeeMaster(employeeMaster);
                                            List<?> empLeaveBalList = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance);
                                            if (empLeaveBalList.size() > 0) {
                                                employeeLeaveBalance1 = (EmployeeLeaveBalance) empLeaveBalList.get(0);
                                                float noOfLeave = employeeLeaveBalance1.getNoOfLeaveRemain();
                                                float noOfdays = (float) 0.5;
                                                noOfLeave = noOfLeave - noOfdays;
                                                employeeLeaveBalance1.setNoOfLeaveRemain(noOfLeave);
                                                employeeLeaveBalanceService.update(employeeLeaveBalance1);

                                                leaveEmployeeDetail1.setEmployeeMaster(employeeMaster);
                                                leaveEmployeeDetail1.setStartDate(leaveStartDate);
                                                List<?> list = leaveEmployeeDetailService.dateWiseLeaveSelectionOfEmployee(leaveEmployeeDetail1);
                                                if (list.size() != 0) {
                                                    leaveEmployeeDetail = (LeaveEmployeeDetail) list.get(0);
                                                    leaveEmployeeDetail.setNoOfDays((float) 1);
                                                    leaveEmployeeDetail.setStartDateStatus("Fullday");
                                                    leaveEmployeeDetailService.update(leaveEmployeeDetail);
                                                } else {
                                                    leaveEmployeeDetail.setEmployeeMaster(employeeMaster);
                                                    leaveEmployeeDetail.setLeaveTypeMaster(leaveTypeMaster);
                                                    leaveEmployeeDetail.setStartDate(leaveStartDate);
                                                    leaveEmployeeDetail.setStartDateStatus("FirstHalf");
                                                    leaveEmployeeDetail.setEndDate(leaveStartDate);
                                                    leaveEmployeeDetail.setNoOfDays(noOfdays);
                                                    leaveEmployeeDetail.setStatus(3);
                                                    leaveEmployeeDetail.setApproverId(employeeMaster1.getId());
                                                    leaveEmployeeDetail.setApproveDate(leaveStartDate);
                                                    leaveEmployeeDetailService.create(leaveEmployeeDetail);
                                                }
                                            }

                                        }
                                        if (col1.equalsIgnoreCase("PL")) {
                                            String leaveStartDate = i + "/" + month + "/" + year;
                                            List<?> plList = leaveTypeMasterService.readLeaveType(pl);
                                            leaveTypeMaster = (LeaveTypeMaster) plList.get(0);

                                            employeeLeaveBalance.setLeaveTypeMaster(leaveTypeMaster);
                                            employeeLeaveBalance.setEmployeeMaster(employeeMaster);
                                            List<?> empLeaveBalList = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance);
                                            if (empLeaveBalList.size() > 0) {
                                                employeeLeaveBalance1 = (EmployeeLeaveBalance) empLeaveBalList.get(0);
                                                float noOfLeave = employeeLeaveBalance1.getNoOfLeaveRemain();
                                                float noOfdays = (float) 0.5;
                                                noOfLeave = noOfLeave - noOfdays;
                                                employeeLeaveBalance1.setNoOfLeaveRemain(noOfLeave);
                                                employeeLeaveBalanceService.update(employeeLeaveBalance1);

                                                leaveEmployeeDetail1.setEmployeeMaster(employeeMaster);
                                                leaveEmployeeDetail1.setStartDate(leaveStartDate);
                                                List<?> list = leaveEmployeeDetailService.dateWiseLeaveSelectionOfEmployee(leaveEmployeeDetail1);
                                                if (list.size() != 0) {
                                                    leaveEmployeeDetail = (LeaveEmployeeDetail) list.get(0);
                                                    leaveEmployeeDetail.setNoOfDays((float) 1);
                                                    leaveEmployeeDetail.setStartDateStatus("Fullday");
                                                    leaveEmployeeDetailService.update(leaveEmployeeDetail);
                                                } else {
                                                    leaveEmployeeDetail.setEmployeeMaster(employeeMaster);
                                                    leaveEmployeeDetail.setLeaveTypeMaster(leaveTypeMaster);
                                                    leaveEmployeeDetail.setStartDate(leaveStartDate);
                                                    leaveEmployeeDetail.setStartDateStatus("FirstHalf");
                                                    leaveEmployeeDetail.setEndDate(leaveStartDate);
                                                    leaveEmployeeDetail.setNoOfDays(noOfdays);
                                                    leaveEmployeeDetail.setStatus(3);
                                                    leaveEmployeeDetail.setApproverId(employeeMaster1.getId());
                                                    leaveEmployeeDetail.setApproveDate(leaveStartDate);
                                                    leaveEmployeeDetailService.create(leaveEmployeeDetail);
                                                }
                                            }

                                        }

                                        if (col1.equalsIgnoreCase("SHL/P")) {
                                            String leaveStartDate = i + "/" + month + "/" + year;
                                            String punchInDate = i + "/" + month + "/" + year;
                                            String approveDate = i + "/" + month + "/" + year;
                                            String punchoutDate = i + "/" + month + "/" + year;
                                            employeeShiftData1.setInDateTime(punchInDate);
                                            employeeShiftData1.setEmployeeMaster(employeeMaster);
                                            List<?> empShiftDataList = employeeShiftDataService.attendanceRegularizationEntry(employeeShiftData1);
                                            if (empShiftDataList.size() != 0) {
                                                employeeShiftData = (EmployeeShiftData) empShiftDataList.get(0);
                                                shiftMaster1.setId(employeeShiftData.getShiftMaster().getId());
                                                List<?> shift = shiftMasterService.readByShiftId(shiftMaster);
                                                shiftMaster = (ShiftMaster) shift.get(0);
                                                punchoutDate = punchoutDate + " " + shiftMaster.getEndTime();
                                                Date date = sdf2.parse(punchoutDate);
                                                Calendar cal = Calendar.getInstance();
                                                cal.setTime(date);
                                                cal.add(Calendar.HOUR, -2);
                                                Date oneHourBack = cal.getTime();
                                                punchoutDate = sdf2.format(oneHourBack);
                                                employeeShiftData.setOutDateTime(punchoutDate);
                                                employeeShiftDataService.update(employeeShiftData);
                                            } else {
                                                shiftGenerateMonthlySchedule.setEmployeeMaster(employeeMaster);
                                                shiftGenerateMonthlySchedule.setShiftMonth(month);
                                                shiftGenerateMonthlySchedule.setShiftYear(year);
                                                List<?> currentShift = shiftGenerateMonthlyScheduleService.readByDayWiseEmployeeShiftData(shiftGenerateMonthlySchedule, i);
                                                Object shiftId = (Object) currentShift.get(0);
                                                int shiftId1 = (int) shiftId;
                                                if (shiftId1 != -1) {
                                                    shiftMaster.setId(shiftId1);
                                                    List<?> shift = shiftMasterService.readByShiftId(shiftMaster);
                                                    shiftMaster1 = (ShiftMaster) shift.get(0);
                                                    punchInDate = punchInDate + " " + shiftMaster1.getHalfStartTime1();
                                                    punchoutDate = punchoutDate + " " + shiftMaster1.getEndTime();
                                                    leaveStartDate = leaveStartDate + " " + shiftMaster1.getEndTime();
                                                    Date date = sdf2.parse(punchoutDate);
                                                    Calendar cal = Calendar.getInstance();
                                                    cal.setTime(date);
                                                    cal.add(Calendar.HOUR, -2);
                                                    Date oneHourBack = cal.getTime();
                                                    punchoutDate = sdf2.format(oneHourBack);

                                                    employeeShiftData.setEmployeeMaster(employeeMaster);
                                                    employeeShiftData.setInDateTime(punchInDate);
                                                    employeeShiftData.setOutDateTime(punchoutDate);
                                                    employeeShiftData.setShiftMaster(shiftMaster);
                                                    employeeShiftDataService.create(employeeShiftData);
                                                }

                                            }

                                            List<?> shlList = leaveTypeMasterService.readLeaveType(shl);
                                            leaveTypeMaster = (LeaveTypeMaster) shlList.get(0);
                                            employeeLeaveBalance.setLeaveTypeMaster(leaveTypeMaster);
                                            employeeLeaveBalance.setEmployeeMaster(employeeMaster);
                                            List<?> empLeaveBalList = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance);
                                            if (empLeaveBalList.size() > 0) {
                                                employeeLeaveBalance1 = (EmployeeLeaveBalance) empLeaveBalList.get(0);
                                                float noOfLeave = employeeLeaveBalance1.getNoOfLeaveRemain();
                                                float noOfdays = (float) 1;
                                                noOfLeave = noOfLeave - noOfdays;
                                                employeeLeaveBalance1.setNoOfLeaveRemain(noOfLeave);
                                                employeeLeaveBalanceService.update(employeeLeaveBalance1);

                                                leaveEmployeeDetail.setEmployeeMaster(employeeMaster);
                                                leaveEmployeeDetail.setLeaveTypeMaster(leaveTypeMaster);
                                                leaveEmployeeDetail.setStartDate(punchoutDate);
                                                leaveEmployeeDetail.setEndDate(leaveStartDate);
                                                leaveEmployeeDetail.setStatus(3);
                                                leaveEmployeeDetail.setApproverId(employeeMaster1.getId());
                                                leaveEmployeeDetail.setApproveDate(approveDate);
                                                leaveEmployeeDetailService.create(leaveEmployeeDetail);
                                            }

                                        }
                                        if (col1.equalsIgnoreCase("SHL/A")) {
                                            String leaveStartDate = i + "/" + month + "/" + year;
                                            String approveDate = i + "/" + month + "/" + year;
                                            String punchInDate = i + "/" + month + "/" + year;
                                            String punchoutDate = i + "/" + month + "/" + year;

                                            shiftGenerateMonthlySchedule.setEmployeeMaster(employeeMaster);
                                            shiftGenerateMonthlySchedule.setShiftMonth(month);
                                            shiftGenerateMonthlySchedule.setShiftYear(year);
                                            List<?> currentShift = shiftGenerateMonthlyScheduleService.readByDayWiseEmployeeShiftData(shiftGenerateMonthlySchedule, i);

                                            Object shiftId = (Object) currentShift.get(0);
                                            int shiftId1 = (int) shiftId;

                                            if (shiftId1 != -1) {
                                                shiftMaster.setId(shiftId1);
                                                List<?> shift = shiftMasterService.readByShiftId(shiftMaster);
                                                shiftMaster1 = (ShiftMaster) shift.get(0);
                                                punchInDate = punchInDate + " " + shiftMaster1.getHalfStartTime1();
                                                punchoutDate = punchoutDate + " " + shiftMaster1.getEndTime();
                                                leaveStartDate = leaveStartDate + " " + shiftMaster1.getEndTime();
                                                Date date = sdf2.parse(punchoutDate);
                                                Calendar cal = Calendar.getInstance();
                                                cal.setTime(date);
                                                cal.add(Calendar.HOUR, -2);
                                                Date oneHourBack = cal.getTime();
                                                punchoutDate = sdf2.format(oneHourBack);
                                            }

                                            List<?> shlList = leaveTypeMasterService.readLeaveType(shl);
                                            leaveTypeMaster = (LeaveTypeMaster) shlList.get(0);
                                            employeeLeaveBalance.setLeaveTypeMaster(leaveTypeMaster);
                                            employeeLeaveBalance.setEmployeeMaster(employeeMaster);
                                            List<?> empLeaveBalList = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance);
                                            if (empLeaveBalList.size() > 0) {
                                                employeeLeaveBalance1 = (EmployeeLeaveBalance) empLeaveBalList.get(0);
                                                float noOfLeave = employeeLeaveBalance1.getNoOfLeaveRemain();
                                                float noOfdays = (float) 1;
                                                noOfLeave = noOfLeave - noOfdays;
                                                employeeLeaveBalance1.setNoOfLeaveRemain(noOfLeave);
                                                employeeLeaveBalanceService.update(employeeLeaveBalance1);

                                                leaveEmployeeDetail.setEmployeeMaster(employeeMaster);
                                                leaveEmployeeDetail.setLeaveTypeMaster(leaveTypeMaster);
                                                leaveEmployeeDetail.setStartDate(punchoutDate);
                                                leaveEmployeeDetail.setEndDate(leaveStartDate);
                                                leaveEmployeeDetail.setStatus(3);
                                                leaveEmployeeDetail.setApproverId(employeeMaster1.getId());
                                                leaveEmployeeDetail.setApproveDate(approveDate);
                                                leaveEmployeeDetailService.create(leaveEmployeeDetail);
                                            }

                                        }

                                    }
                                }
                            } catch (Exception e) {

                            }
                            continue;
                        }
                    }

                }
            }
            request.setAttribute("successMessage", "Information : The Excel Uploaded Successfully.");
            mv = attendanceExcelUpload(request, response);

        } catch (Exception e) {
            request.setAttribute("failureMessage", "Information : The Excel Not Upload Successfully. Please Check Excel Data.");
            mv = attendanceExcelUpload(request, response);
        }
        return mv;
    }

    public ModelAndView employeePresentSearch(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeShiftData employeeShiftData = new EmployeeShiftData();
        EmployeeAdvanceSearch employeeAdvanceSearch = new EmployeeAdvanceSearch();
        selectEmployee(request, response);
        selectZydexLocation(request, response);
        selectLevel(request, response);
        department(request, response);
        mv.getModelMap().put("employeeAdvanceSearch", employeeAdvanceSearch);
        mv.setViewName("Shift/EmployeePresentSearchCreiteria");
        return mv;
    }

    public ModelAndView employeePresentSearchSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        String zydexLocationId = request.getParameter("zydexLocationId");
        String levelId = request.getParameter("levelId");
        String departmentId = request.getParameter("departmentId");
        String startDate = request.getParameter("inDateTime");

        EmployeeAdvanceSearch employeeAdvanceSearch = new EmployeeAdvanceSearch();
        employeeAdvanceSearch.setZydexLocationId(zydexLocationId);
        employeeAdvanceSearch.setLevelID(levelId);
        employeeAdvanceSearch.setDepartmentId(departmentId);

        employeeAdvanceSearch.setEmployeeId(Boolean.TRUE);
        employeeAdvanceSearch.setEmployeeName(Boolean.TRUE);
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

        int rownum = 0;
        HSSFWorkbook firstFWorkbook = new HSSFWorkbook();
        HSSFSheet firstSheet = firstFWorkbook.createSheet("FIRST SHEET");
        Row headerRow = firstSheet.createRow(rownum);
        headerRow.setHeightInPoints(40);
        HSSFFont redFont = firstFWorkbook.createFont();
        redFont.setColor(HSSFColor.RED.index);
        HSSFCellStyle stylered = firstFWorkbook.createCellStyle();
        stylered.setFont(redFont);

        HSSFFont greenFont = firstFWorkbook.createFont();
        greenFont.setColor(HSSFColor.GREEN.index);
        HSSFCellStyle stylegreen = firstFWorkbook.createCellStyle();
        stylegreen.setFont(greenFont);

        HSSFFont blueFont = firstFWorkbook.createFont();
        blueFont.setColor(HSSFColor.BLUE.index);
        HSSFCellStyle styleblue = firstFWorkbook.createCellStyle();
        styleblue.setFont(blueFont);

        HSSFFont boldFont = firstFWorkbook.createFont();
        boldFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
        HSSFCellStyle styleBold = firstFWorkbook.createCellStyle();
        styleBold.setFont(boldFont);
        List<List<String>> recordToAdd = new ArrayList();
        List<List<String>> recordToAdd1 = new ArrayList();
        List<String> headerRow1 = new ArrayList();
        List<String> headerRow2 = new ArrayList();
        headerRow1.add("Employee ID");
        headerRow1.add("Employee Name");
        headerRow1.add("Shift Name");
        headerRow1.add("In Punch");
        headerRow1.add("Out Punch");
        headerRow1.add("In Punch");
        headerRow1.add("Out Punch");
        headerRow1.add("First Half");
        headerRow1.add("Second Half");
        headerRow1.add("Working Hour");
        recordToAdd.add(headerRow1);
        List<?> empDetail = employeeMasterService.empOrDateWiseSearchforActive(employeeAdvanceSearch);
        Iterator it = empDetail.iterator();
        int presentCounter = 0;
        while (it.hasNext()) {
            EmployeeDatetimeData employeeDatetimeData = new EmployeeDatetimeData();
            List<String> employeeInfoList = new ArrayList();
            Object[] next = (Object[]) it.next();
            int id = (int) next[47];
            EmployeeMaster employeeMaster1 = new EmployeeMaster();
            employeeMaster1.setId(id);
            ShiftGenerateMonthlySchedule shiftGenerateMonthlySchedule = new ShiftGenerateMonthlySchedule();
            String[] s1 = startDate.split("/");
            String currentDays = s1[0];
            String currentMonth = s1[1];
            String currentyear = s1[2];
            shiftGenerateMonthlySchedule.setEmployeeMaster(employeeMaster1);
            shiftGenerateMonthlySchedule.setShiftMonth(currentMonth);
            shiftGenerateMonthlySchedule.setShiftYear(currentyear);
            String shiftId = "";
            List<?> empShiftList = shiftGenerateMonthlyScheduleService.readByDayWiseEmployeeShiftData(shiftGenerateMonthlySchedule, Integer.parseInt(currentDays));
            ShiftMaster shiftMaster = new ShiftMaster();
            ShiftMaster shiftMaster1 = new ShiftMaster();
            String shiftName = "";
            String shiftFirstHalfEndTime = "";
            String shiftEndTime = "";
            String empEndTime = "";
            String[] empEndTime1 = null;
            SimpleDateFormat sdf3 = new SimpleDateFormat("HH:mm");
            if (!empShiftList.isEmpty()) {
                shiftId = "" + empShiftList.get(0);
            }
            if (empShiftList.size() > 0) {
                shiftMaster.setId(Integer.parseInt(shiftId));
                shiftMaster1 = shiftMasterService.readById(shiftMaster.getId());
                shiftName = shiftMaster1.getShiftName();
                shiftFirstHalfEndTime = shiftMaster1.getHalfEndTime1();
                shiftEndTime = shiftMaster1.getEndTime();
            }
            employeeInfoList.add("" + next[0]);
            employeeInfoList.add("" + next[1]);
            employeeInfoList.add(shiftName);
            List listPunch = employeeDatetimeDataService.readPuchDataDateWise(startDate, id);
            Iterator it1 = listPunch.iterator();
            Iterator it2 = listPunch.iterator();
            int numAttempts = 0;
            while (it1.hasNext() && numAttempts < 4) {
                Object[] next1 = (Object[]) it1.next();
                String str = "" + next1[0];
                String[] str1 = str.split(" ");
                employeeInfoList.add("" + str1[1]);
                numAttempts++;
            }

            while (listPunch.size() >= 2) {

                Object[] startTimeListEnd = (Object[]) listPunch.get(listPunch.size() - 1);

                empEndTime = (String) startTimeListEnd[0];
                empEndTime1 = empEndTime.split(" ");
                break;

            }

            if (listPunch.isEmpty()) {
                employeeInfoList.add("");
                employeeInfoList.add("");
                employeeInfoList.add("");
                employeeInfoList.add("");
                employeeInfoList.add("AB");
                employeeInfoList.add("AB");
            }
            if (listPunch.size() == 1) {
                employeeInfoList.add("");
                employeeInfoList.add("");
                employeeInfoList.add("");
                employeeInfoList.add("PR");
                employeeInfoList.add("PR");
                presentCounter++;
            }
            if (listPunch.size() == 2) {
                employeeInfoList.add("");
                employeeInfoList.add("");
                employeeInfoList.add("PR");
                Date empEndDate = sdf3.parse(empEndTime1[1]);
                Date shiftEndDate = sdf3.parse(shiftEndTime);
                if (empEndDate.before(shiftEndDate)) {
                    employeeInfoList.add("AB");
                } else {
                    employeeInfoList.add("PR");
                    presentCounter++;
                }
            }
            if (listPunch.size() == 3) {
                employeeInfoList.add("");
                employeeInfoList.add("PR");
                Date empEndDate = sdf3.parse(empEndTime1[1]);
                Date shiftEndDate = sdf3.parse(shiftEndTime);
                if (empEndDate.before(shiftEndDate)) {
                    employeeInfoList.add("AB");
                } else {
                    employeeInfoList.add("PR");
                    presentCounter++;
                }
            }
            if (listPunch.size() > 3) {
                employeeInfoList.add("PR");
                Date empEndDate = sdf3.parse(empEndTime1[1]);
                Date shiftEndDate = sdf3.parse(shiftEndTime);
                if (empEndDate.before(shiftEndDate)) {
                    employeeInfoList.add("AB");
                } else {
                    employeeInfoList.add("PR");
                    presentCounter++;
                }
            }
            while (listPunch.size() >= 2) {
                Object[] startTimeListStart = (Object[]) listPunch.get(0);
                Object[] startTimeListEnd = (Object[]) listPunch.get(listPunch.size() - 1);
                String startTime = (String) startTimeListStart[0];
                String endTime = (String) startTimeListEnd[0];
                SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                Date strDate = sdf2.parse(startTime);
                Date endDate = sdf2.parse(endTime);
                long diff = endDate.getTime() - strDate.getTime();
                long diffHours = diff / (60 * 1000);
                double empHour = (double) diffHours / 60;
                employeeInfoList.add("" + new DecimalFormat("##.##").format(empHour));
                break;
            }

            recordToAdd.add(employeeInfoList);

        }

        headerRow2.add("Total Present");
        headerRow2.add("" + presentCounter);
        recordToAdd1.add(headerRow2);

        for (int j = 0; j < recordToAdd.size(); j++) {
            List<String> l2 = recordToAdd.get(j);
            Row row = firstSheet.createRow(rownum);
            for (int k = 0; k < l2.size(); k++) {
                Cell cell = row.createCell(k);
                cell.setCellValue(l2.get(k));
                if (j == 0) {
                    cell.setCellStyle(styleBold);
                }
            }
            rownum++;
        }
        List<String> l2 = recordToAdd1.get(0);
        rownum++;
        Row row = firstSheet.createRow(rownum);
        for (int l = 0; l < l2.size(); l++) {
            Cell cell = row.createCell(l);
            cell.setCellValue(l2.get(l));
            cell.setCellStyle(styleBold);
        }
        String appPath = request.getServletContext().getRealPath("");
        try {
            String filePath = appPath + File.separator + "StorageYard" + File.separator
                    + "Other" + File.separator + "UserDoc" + File.separator
                    + "EmployeeDailyPunch" + File.separator + "EmployeeDailyPunch.xls";
            FileOutputStream fos = new FileOutputStream(new File(filePath));
            HSSFCellStyle hsfstyle = firstFWorkbook.createCellStyle();
            hsfstyle.setBorderBottom((short) 1);
            hsfstyle.setFillBackgroundColor((short) 245);
            firstFWorkbook.write(fos);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String filePath = File.separator + "StorageYard" + File.separator
                + "Other" + File.separator + "UserDoc" + File.separator
                + "EmployeeDailyPunch" + File.separator + "EmployeeDailyPunch.xls";

        appPath = request.getServletContext().getRealPath("");

        String fullPath = appPath + filePath;

        request.setAttribute("filePath", fullPath);

        DownloadFile downloadFile = new DownloadFile();
        downloadFile.doDownload(request, response);
        return mv;
    }

    public ModelAndView employeeMonthlyPayrollReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeShiftData employeeShiftData = new EmployeeShiftData();
        LeaveEmployeeDetail leaveEmployeeDetail = new LeaveEmployeeDetail();
        EmployeeAdvanceSearch employeeAdvanceSearch = new EmployeeAdvanceSearch();
        AttendanceRegularization attendanceRegularization = new AttendanceRegularization();
        TravelRequestMaster travelRequestMaster = new TravelRequestMaster();

        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        HolidayMaster holidayMaster = new HolidayMaster();
        String empId = request.getParameter("employeeMasterId");
        String zydexLocationId = request.getParameter("zydexLocationId");
        String levelId = request.getParameter("levelId");
        String departmentId = request.getParameter("departmentId");
        String startDate = request.getParameter("inDateTime");
        String endDate = request.getParameter("outDateTime");
        bind(request, employeeAdvanceSearch);
        String searchval = request.getParameter("vallist");
        if (null != searchval && request.getParameter("vallist").toString().equals("other")) {
            employeeAdvanceSearch.setId(null);
            employeeAdvanceSearch.setZydexLocationId(zydexLocationId);
            employeeAdvanceSearch.setLevelID(levelId);
            employeeAdvanceSearch.setDepartmentId(departmentId);
        } else {
            employeeAdvanceSearch.setId(empId);
            employeeAdvanceSearch.setZydexLocationId(null);
            employeeAdvanceSearch.setLevelID(null);
            employeeAdvanceSearch.setDepartmentId(null);
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//        SimpleDateFormat tm = new SimpleDateFormat("HH:mm");
        SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm");
        if (!empId.equals("")) {
            employeeShiftData.setId(Integer.parseInt(empId));
        }
        if (!startDate.equals("")) {
            Date sDate = sdf.parse(startDate);
//            "2012-01-01"
            employeeShiftData.setInDateTime(new SimpleDateFormat("yyyy-MM-dd").format(sDate));
            leaveEmployeeDetail.setApproveDate(new SimpleDateFormat("yyyy-MM-dd").format(sDate));
            Calendar c = Calendar.getInstance();
            c.setTime(sDate);
            c.add(Calendar.MONTH, -1);
            Date previousDate = c.getTime();
            String previouSMonthdate = sdf.format(previousDate);

            leaveEmployeeDetail.setStartDate(new SimpleDateFormat("yyyy-MM-dd").format(previousDate));
            holidayMaster.setHolidayFromDate(new SimpleDateFormat("yyyy-MM-dd").format(sDate));
            attendanceRegularization.setApprovedDate(startDate);
            attendanceRegularization.setEndDateTime(previouSMonthdate);

            travelRequestMaster.setStartDateTime(new SimpleDateFormat("yyyy-MM-dd").format(sDate));
            travelRequestMaster.setAdminRemark(new SimpleDateFormat("yyyy-MM-dd").format(previousDate));

        }
        if (!endDate.equals("")) {
            Date eDate = sdf.parse(endDate);
            Calendar c = Calendar.getInstance();
            c.setTime(eDate);
            c.add(Calendar.MONTH, -1);
            c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
            Date previousDate = c.getTime();
            String previouSMonthdate = sdf.format(previousDate);

            employeeShiftData.setOutDateTime(new SimpleDateFormat("yyyy-MM-dd").format(eDate));
            holidayMaster.setHolidayToDate(new SimpleDateFormat("yyyy-MM-dd").format(eDate));

            leaveEmployeeDetail.setEndDate(new SimpleDateFormat("yyyy-MM-dd").format(eDate));
            leaveEmployeeDetail.setEndDateStatus(new SimpleDateFormat("yyyy-MM-dd").format(previousDate));

            travelRequestMaster.setEndDateTime(new SimpleDateFormat("yyyy-MM-dd").format(eDate));
            travelRequestMaster.setEmpRemark(new SimpleDateFormat("yyyy-MM-dd").format(previousDate));
        }

        Calendar calForFlexiNotSupport1 = Calendar.getInstance();
        Calendar calForFlexiNotSupport2 = Calendar.getInstance();
        if (!startDate.equals("")) {
            Date notflexibleSupportDate = sdf.parse(startDate);
            String FixedFlexibleDate = "01/04/2016";
            Date notflexibleSupportDate1 = sdf.parse(FixedFlexibleDate);
            calForFlexiNotSupport1.setTime(notflexibleSupportDate);
            calForFlexiNotSupport2.setTime(notflexibleSupportDate1);
        }

        int rownum = 2;
        HSSFWorkbook firstFWorkbook = new HSSFWorkbook();
        HSSFSheet firstSheet = firstFWorkbook.createSheet("FIRST SHEET");
        Row headerRow = firstSheet.createRow(0);
        headerRow.setHeightInPoints(40);

        HSSFFont boldFont = firstFWorkbook.createFont();
        boldFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
        HSSFCellStyle styleBold = firstFWorkbook.createCellStyle();
        styleBold.setFont(boldFont);

        List<?> empDetail = employeeMasterService.empAttendanceDataSearch(employeeAdvanceSearch);
        Map<Integer, List<?>> map = new LinkedHashMap<Integer, List<?>>();
        Map<Integer, List<?>> map1 = new LinkedHashMap<Integer, List<?>>();

        int headerCount = 0;

        Cell cell1 = headerRow.createCell(headerCount);
        cell1.setCellValue("Employee ID");
        cell1.setCellStyle(styleBold);
        headerCount = headerCount + 1;

        cell1 = headerRow.createCell(headerCount);
        cell1.setCellValue("Employee Name");
        cell1.setCellStyle(styleBold);
        headerCount = headerCount + 1;

        cell1 = headerRow.createCell(headerCount);
        cell1.setCellValue("Department");
        cell1.setCellStyle(styleBold);
        headerCount = headerCount + 1;

        cell1 = headerRow.createCell(headerCount);
        cell1.setCellValue("Date Of Joining");
        cell1.setCellStyle(styleBold);
        headerCount = headerCount + 1;

        cell1 = headerRow.createCell(headerCount);
        cell1.setCellValue("Present Day");
        cell1.setCellStyle(styleBold);
        headerCount = headerCount + 1;

        cell1 = headerRow.createCell(headerCount);
        cell1.setCellValue("Weekly Offs");
        cell1.setCellStyle(styleBold);
        headerCount = headerCount + 1;

        cell1 = headerRow.createCell(headerCount);
        cell1.setCellValue("Holidays");
        cell1.setCellStyle(styleBold);
        headerCount = headerCount + 1;

        cell1 = headerRow.createCell(headerCount);
        cell1.setCellValue("Short Leave");
        cell1.setCellStyle(styleBold);
        headerCount = headerCount + 1;

        cell1 = headerRow.createCell(headerCount);
        cell1.setCellValue("C-Off");
        cell1.setCellStyle(styleBold);
        headerCount = headerCount + 1;

        cell1 = headerRow.createCell(headerCount);
        cell1.setCellValue("CL");
        cell1.setCellStyle(styleBold);
        CellUtil.setAlignment(cell1, firstFWorkbook, CellStyle.ALIGN_CENTER);
        firstSheet.addMergedRegion(new CellRangeAddress(0, 0, 9, 10));
        headerCount = headerCount + 2;

        cell1 = headerRow.createCell(headerCount);
        cell1.setCellValue("SL");
        cell1.setCellStyle(styleBold);
        CellUtil.setAlignment(cell1, firstFWorkbook, CellStyle.ALIGN_CENTER);
        firstSheet.addMergedRegion(new CellRangeAddress(0, 0, 11, 12));
        headerCount = headerCount + 2;

        cell1 = headerRow.createCell(headerCount);
        cell1.setCellValue("PL");
        cell1.setCellStyle(styleBold);
        CellUtil.setAlignment(cell1, firstFWorkbook, CellStyle.ALIGN_CENTER);
        firstSheet.addMergedRegion(new CellRangeAddress(0, 0, 13, 14));
        headerCount = headerCount + 2;

        cell1 = headerRow.createCell(headerCount);
        cell1.setCellValue("PTL");
        cell1.setCellStyle(styleBold);
        headerCount = headerCount + 1;
        cell1 = headerRow.createCell(headerCount);
        cell1.setCellValue("ML");
        cell1.setCellStyle(styleBold);
        headerCount = headerCount + 1;

        cell1 = headerRow.createCell(headerCount);
        cell1.setCellValue("AR");
        cell1.setCellStyle(styleBold);
        CellUtil.setAlignment(cell1, firstFWorkbook, CellStyle.ALIGN_CENTER);
        firstSheet.addMergedRegion(new CellRangeAddress(0, 0, 17, 18));
        headerCount = headerCount + 2;

        cell1 = headerRow.createCell(headerCount);
        cell1.setCellValue("TR");
        cell1.setCellStyle(styleBold);
        CellUtil.setAlignment(cell1, firstFWorkbook, CellStyle.ALIGN_CENTER);
        firstSheet.addMergedRegion(new CellRangeAddress(0, 0, 19, 20));
        headerCount = headerCount + 2;

        cell1 = headerRow.createCell(headerCount);
        cell1.setCellValue("Arrears");
        cell1.setCellStyle(styleBold);
        headerCount = headerCount + 1;

        cell1 = headerRow.createCell(headerCount);
        cell1.setCellValue("Paid Days");
        cell1.setCellStyle(styleBold);
        headerCount = headerCount + 1;

        cell1 = headerRow.createCell(headerCount);
        cell1.setCellValue("LWP");
        cell1.setCellStyle(styleBold);
        headerCount = headerCount + 1;

        cell1 = headerRow.createCell(headerCount);
        cell1.setCellValue("Total Days");
        cell1.setCellStyle(styleBold);
        headerCount = headerCount + 1;
        int secondHeaderCount = 0;
        Row secondheaderRow = firstSheet.createRow(1);
        Cell cell2 = secondheaderRow.createCell(secondHeaderCount);
        cell2.setCellValue("");
        secondHeaderCount = secondHeaderCount + 1;
        cell2 = secondheaderRow.createCell(secondHeaderCount);
        cell2.setCellValue("");
        secondHeaderCount = secondHeaderCount + 1;
        cell2 = secondheaderRow.createCell(secondHeaderCount);
        cell2.setCellValue("");
        secondHeaderCount = secondHeaderCount + 1;
        cell2 = secondheaderRow.createCell(secondHeaderCount);
        cell2.setCellValue("");
        secondHeaderCount = secondHeaderCount + 1;
        cell2 = secondheaderRow.createCell(secondHeaderCount);
        cell2.setCellValue("");
        secondHeaderCount = secondHeaderCount + 1;
        cell2 = secondheaderRow.createCell(secondHeaderCount);
        cell2.setCellValue("");
        secondHeaderCount = secondHeaderCount + 1;
        cell2 = secondheaderRow.createCell(secondHeaderCount);
        cell2.setCellValue("");
        secondHeaderCount = secondHeaderCount + 1;
        cell2 = secondheaderRow.createCell(secondHeaderCount);
        cell2.setCellValue("");
        secondHeaderCount = secondHeaderCount + 1;
        cell2 = secondheaderRow.createCell(secondHeaderCount);
        cell2.setCellValue("");
        secondHeaderCount = secondHeaderCount + 1;
        cell2 = secondheaderRow.createCell(secondHeaderCount);
        cell2.setCellValue("Last Month");
        cell2.setCellStyle(styleBold);
        secondHeaderCount = secondHeaderCount + 1;
        cell2 = secondheaderRow.createCell(secondHeaderCount);
        cell2.setCellValue("Cur. Month");
        cell2.setCellStyle(styleBold);
        secondHeaderCount = secondHeaderCount + 1;
        cell2 = secondheaderRow.createCell(secondHeaderCount);
        cell2.setCellValue("Last Month");
        cell2.setCellStyle(styleBold);
        secondHeaderCount = secondHeaderCount + 1;
        cell2 = secondheaderRow.createCell(secondHeaderCount);
        cell2.setCellValue("Cur. Month");
        cell2.setCellStyle(styleBold);
        secondHeaderCount = secondHeaderCount + 1;
        cell2 = secondheaderRow.createCell(secondHeaderCount);
        cell2.setCellValue("Last Month");
        cell2.setCellStyle(styleBold);
        secondHeaderCount = secondHeaderCount + 1;
        cell2 = secondheaderRow.createCell(secondHeaderCount);
        cell2.setCellValue("Cur. Month");
        cell2.setCellStyle(styleBold);
        secondHeaderCount = secondHeaderCount + 1;
        cell2 = secondheaderRow.createCell(secondHeaderCount);
        cell2.setCellValue("");
        secondHeaderCount = secondHeaderCount + 1;
        cell2 = secondheaderRow.createCell(secondHeaderCount);
        cell2.setCellValue("");
        secondHeaderCount = secondHeaderCount + 1;
        cell2 = secondheaderRow.createCell(secondHeaderCount);
        cell2.setCellValue("Last Month");
        cell2.setCellStyle(styleBold);
        secondHeaderCount = secondHeaderCount + 1;
        cell2 = secondheaderRow.createCell(secondHeaderCount);
        cell2.setCellValue("Cur. Month");
        cell2.setCellStyle(styleBold);
        secondHeaderCount = secondHeaderCount + 1;
        cell2 = secondheaderRow.createCell(secondHeaderCount);
        cell2.setCellValue("Last Month");
        cell2.setCellStyle(styleBold);
        secondHeaderCount = secondHeaderCount + 1;
        cell2 = secondheaderRow.createCell(secondHeaderCount);
        cell2.setCellValue("Cur. Month");
        cell2.setCellStyle(styleBold);
        secondHeaderCount = secondHeaderCount + 1;
        cell2 = secondheaderRow.createCell(secondHeaderCount);
        cell2.setCellValue("");
        secondHeaderCount = secondHeaderCount + 1;
        cell2 = secondheaderRow.createCell(secondHeaderCount);
        cell2.setCellValue("");
        secondHeaderCount = secondHeaderCount + 1;
        cell2 = secondheaderRow.createCell(secondHeaderCount);
        cell2.setCellValue("");
        secondHeaderCount = secondHeaderCount + 1;
        cell2 = secondheaderRow.createCell(secondHeaderCount);
        cell2.setCellValue("");
        secondHeaderCount = secondHeaderCount + 1;

        List<List<String>> recordToAdd = new ArrayList();
        List<List<String>> recordToAdd3 = new ArrayList();
        for (Object o1 : empDetail) {
            Object[] o = (Object[]) o1;
//            List<List<?>> li = new LinkedList<List<?>>();
            List<String> employeeInfoList = new LinkedList();
//            List<String> holidayList = new LinkedList<String>();

            employeeInfoList.add("" + o[0]);
            employeeInfoList.add("" + o[1]);
            employeeInfoList.add("" + o[2]);
            employeeInfoList.add("" + o[3]);
            employeeInfoList.add("" + o[4]);
            recordToAdd.add(employeeInfoList);
            recordToAdd3.add(employeeInfoList);
        }
        for (int j = 0; j < recordToAdd.size(); j++) {

            try {

                Row row = firstSheet.createRow(rownum);
                List<String> l2 = recordToAdd.get(j);

                boolean myFlage = false;
                int id = 0;
                int countK = 1;
                for (int k = 0; k < l2.size(); k++) {
                    Cell cell = row.createCell(k);
                    if (k != l2.size() - 1) {

                        cell.setCellValue(l2.get(k));

                    }

                }

                double ar = 0;
                double holiday = 0;
                double prcounter = 0;
                double abcounter = 0;
                double wo = 0;
                double cl = 0;
                double sl = 0;
                double pl = 0;
                double totalDays = 0;
                double firstStartTime = 0;
                double firstHalfVal = 0;
                int counter = 0;
                int firstCounter = 0;
                List<List<?>> li = new LinkedList<List<?>>();
                List<String> holidayList = new LinkedList<String>();
                String userId = l2.get(l2.size() - 1);
                employeeShiftData.setId(Integer.parseInt(userId));
                employeeMaster1.setId(Integer.parseInt(userId));
                attendanceRegularization.setUserMasterId(Integer.parseInt(userId));
                holidayMaster.setId(Integer.parseInt(userId));
                travelRequestMaster.setEmployeeMasterByEmployeeMasterId(employeeMaster1);
                leaveEmployeeDetail.setEmployeeMaster(employeeMaster1);
                List<?> list = employeeShiftDataService.empOrDateWiseSearch(employeeShiftData);
                int holidayCount = holidayMasterService.searchMonthWiseHoliday(holidayMaster);
                List<?> empMonthWiseLeave = leaveEmployeeDetailService.searchLeaveApproveOfEmployeeByMonthWise(leaveEmployeeDetail);
                List<?> empLastMonthWiseLeave = leaveEmployeeDetailService.searchLeaveApproveOfEmployeeByPreviousMonthWise(leaveEmployeeDetail);
                List<?> attendanceRegularizationCurMonth = attendanceRegularizationMasterService.searchLeaveApproveOfEmployeeByMonthWise(attendanceRegularization);
                List<?> attendanceRegularizationPreMonth = attendanceRegularizationMasterService.searchLeaveApproveOfEmployeeByPreviousMonthWise(attendanceRegularization);
                List<?> travelCurrentMonthList = travelRequestMasterService.searchTravelApproveOfEmployeeByCurrentMonthWise(travelRequestMaster);
                List<?> travelPreviousMonthList = travelRequestMasterService.searchTravelApproveOfEmployeeByPreviousMonthWise(travelRequestMaster);
                holidayList.add("" + holidayCount);
                li.add(holidayList);
                li.add(empMonthWiseLeave);
                li.add(empLastMonthWiseLeave);
                li.add(attendanceRegularizationCurMonth);
                li.add(attendanceRegularizationPreMonth);
                li.add(travelPreviousMonthList);
                li.add(travelCurrentMonthList);

                map1.put(id, li);

                map.put(id, list);

                boolean flexible = false;
                int earlyMinute = 0;
                int lateMinute = 0;
                List<?> timeAttFlexibleList = timeAttandanceFlaxibleMasterService.read();
                if (!timeAttFlexibleList.isEmpty()) {
                    for (Object flexiObject : timeAttFlexibleList) {
                        TimeAttandanceFlaxibleMaster timeAttandanceFlaxibleMaster = (TimeAttandanceFlaxibleMaster) flexiObject;
                        int zydexLocId = timeAttandanceFlaxibleMaster.getZydexLocationMaster().getId();
                        EmployeeMaster employeeMaster2 = employeeMasterService.readById(Integer.parseInt(userId));
                        int zydexLocId2 = employeeMaster2.getZydexLocationMaster().getId();
                        if (zydexLocId == zydexLocId2) {
                            flexible = true;
                            earlyMinute = Integer.parseInt(timeAttandanceFlaxibleMaster.getEarlyFlexibleTime());
                            lateMinute = Integer.parseInt(timeAttandanceFlaxibleMaster.getLateFlexibleTime());
                            break;
                        }
                    }
                }

                for (Map.Entry<Integer, List<?>> entry : map.entrySet()) {

                    if (flexible == true && calForFlexiNotSupport2.get(Calendar.MONTH) != calForFlexiNotSupport1.get(Calendar.MONTH)) {
                        Iterator itr5 = entry.getValue().iterator();
                        while (itr5.hasNext()) {
                            Object[] next = (Object[]) itr5.next();
                            String firstHalf = "" + next[1];

                            if (firstHalf.contains("fullday")) {
                                prcounter = prcounter + 0.5;

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
                                Date userTimeIn = sdf1.parse(userTimeInStr1[0]);
                                Date userTimeOut = sdf1.parse(userTimeOutStr1[0]);
                                Date endHours = sdf1.parse(endHoursStr1[0]);
                                Date firstStartHours = sdf1.parse(firstStartHoursStr[1]);
                                Calendar cal = Calendar.getInstance();
                                Calendar cal1 = Calendar.getInstance();
                                cal.setTime(firstStartHours);
                                cal1.setTime(firstStartHours);
                                cal1.add(Calendar.MINUTE, -earlyMinute);
                                cal.add(Calendar.MINUTE, lateMinute);
                                String newTime = sdf1.format(cal.getTime());
                                Date flexibleEndTime = sdf1.parse(newTime);
                                Date LateHours = sdf1.parse(LateHoursStr1[0]);
                                String newTime1 = sdf1.format(cal1.getTime());
                                Date flexibleStartTime = sdf1.parse(newTime1);
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
                                        prcounter = prcounter + 0.5;

                                    } else if (userTimeOut.before(userTimeIn)) {
                                        prcounter = prcounter + 0.5;
                                    } else if (leave1[0] != null && !leave1[0].contains("Short Leave")) {
                                        if ((userTimeIn.before(flexibleEndTime) || userTimeIn.equals(flexibleEndTime)) && (userTimeOut.after(endHours) || userTimeOut.equals(endHours))) {
                                            prcounter = prcounter + 0.5;
                                        }

                                    }

                                }
                            }
                        }

                        Iterator itr6 = entry.getValue().iterator();
                        int weekNameCounter = 0;
                        boolean satWeekOff = false;
                        while (itr6.hasNext()) {
                            Object[] next = (Object[]) itr6.next();
                            String secondHalf = "" + next[1];
                            String shiftName = "";
//                                    2nd Sat Week Off Codding
                            Calendar cal = Calendar.getInstance();
                            Date date = sdf.parse("" + next[0]);
                            cal.setTime(date);
                            SimpleDateFormat format = new SimpleDateFormat("EEEE");
                            String dayName = format.format(date);
                            EmployeeMaster employeeMaster2 = employeeMasterService.readById(Integer.parseInt(userId));
                            ZydexLocationMaster zydexLocationMaster = zydexLocationMasterService.readById(employeeMaster2.getZydexLocationMaster().getId());

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
                            List listPunch = employeeDatetimeDataService.readPuchDataDateWise("" + next[0], Integer.parseInt(userId));
                            long lunchTime = 0;
                            long totalDayTime = 0;
                            long totalDayTime1 = 0;
                            long totalTime = 0;
                            long shiftdiffMinutes = 0;
                            boolean checkLunchTime = false;
                            int i = 1;
                            int m = 2;
                            long outTime = 0;
                            String startTime = "";
                            String endTime = "";
                            SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                            if (listPunch.size() > 2) {
                                while (listPunch.size() > i && listPunch.size() > m) {

                                    Object[] startLunchTime = (Object[]) listPunch.get(i);
                                    Object[] endLunchTime = (Object[]) listPunch.get(m);
                                    startTime = (String) startLunchTime[0];
                                    endTime = (String) endLunchTime[0];
                                    Date launchStrTime = sdf2.parse(startTime);
                                    Date launchEndTime = sdf2.parse(endTime);
                                    long diff = launchEndTime.getTime() - launchStrTime.getTime();
                                    lunchTime = diff / (60 * 1000);
                                    outTime = outTime + lunchTime;
                                    i = i + 2;
                                    m = m + 2;
                                }

                                String[] userTimeInStr = secondHalf.split("`");
                                String[] userTimeInStr1 = userTimeInStr[1].split("!");
                                String[] userTimeOutStr = secondHalf.split("!");
                                String[] userTimeOutStr1 = userTimeOutStr[1].split("@");
                                Date userTimeIn = sdf1.parse(userTimeInStr1[0]);
                                Date userTimeOut = sdf1.parse(userTimeOutStr1[0]);
                                String[] startHoursStr = secondHalf.split("%");
                                String[] firstStartHoursStr = startHoursStr[1].split("\\+");
                                String[] endHoursStr = secondHalf.split("&");
                                Date firstStartHours = sdf1.parse(firstStartHoursStr[1]);
                                Calendar cal1 = Calendar.getInstance();
                                cal1.setTime(firstStartHours);
                                cal1.add(Calendar.MINUTE, -earlyMinute);
                                String newTime1 = sdf1.format(cal1.getTime());
                                Date flexibleInTime = sdf1.parse(newTime1);
                                Date endHours = sdf1.parse(endHoursStr[1]);
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
                                wo = wo + 0.5;
                            } else if (checkLunchTime == true && totalTime < shiftdiffMinutes && !secondHalf.contains("AR")) {

                            } else if (secondHalf.contains("fullday")) {
                                prcounter = prcounter + 0.5;

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

                                Date userTimeIn = sdf1.parse(userTimeInStr1[0]);
                                Date userTimeOut = sdf1.parse(userTimeOutStr1[0]);
                                Date userTimeOut1 = sdf1.parse("23:59");
                                Date firstStartHours = sdf1.parse(firstStartHoursStr[1]);
                                String[] getInHours = userTimeInStr1[0].split(":");
                                String[] getOutHours = userTimeOutStr1[0].split(":");
                                String abc = getInHours[0].trim();
                                String xyz = getOutHours[0].trim();
                                int i11 = Integer.parseInt(abc) - Integer.parseInt(xyz);
                                int totalDuration = 24 - i11;
                                String totalDuration2 = getOutHours[0];
                                Date endHours = sdf1.parse(endHoursStr[1]);
                                Date secondHalfTimeStr2 = sdf1.parse(secondHalfTimeStr1[0]);

                                Calendar cal1 = Calendar.getInstance();
                                cal1.setTime(firstStartHours);
                                cal1.add(Calendar.MINUTE, -earlyMinute);
                                String newTime1 = sdf1.format(cal1.getTime());
                                Date flexibleInTime = sdf1.parse(newTime1);

                                Calendar cal2 = Calendar.getInstance();
                                cal2.setTime(firstStartHours);
                                cal2.add(Calendar.MINUTE, lateMinute);
                                String newTime = sdf1.format(cal2.getTime());
                                Date flexibleEndTime = sdf1.parse(newTime);

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
                                    if (diffMinutes1 >= diffMinutes && userTimeIn.before(flexibleEndTime)) {
                                        prcounter = prcounter + 0.5;
                                    } else if (diffMinutes1 <= diffMinutes && userTimeIn.before(flexibleEndTime)) {

                                    } else if ((userTimeIn.before(secondHalfTimeStr2) || userTimeIn.equals(secondHalfTimeStr2)) && (userTimeOut.after(endHours) || userTimeOut.equals(endHours))) {
                                        prcounter = prcounter + 0.5;
                                    } else if (diffMinutes1 >= 240 && userTimeIn.after(secondHalfTimeStr2)) {
                                        prcounter = prcounter + 0.5;
                                    } else if (shiftName.contains("Night") && (userTimeOut.after(endHours) || userTimeOut.equals(endHours))) {
                                        prcounter = prcounter + 0.5;
                                    }
                                }
                            }
                        }

                    } else {
                        Iterator itr1 = entry.getValue().iterator();

//                Cell cellTitle = row3.createCell(0);
                        int errorCount = 0;
                        while (itr1.hasNext()) {
                            Object[] next = (Object[]) itr1.next();
//                    Cell cell3 = row.createCell(i);
//                    cell3.setCellValue("" + next[0]);
                            String firstHalf = "" + next[1];

                            if (firstHalf.contains("fullday")) {
                                prcounter = prcounter + 0.5;
                                counter = counter + 1;
                            } else if (!firstHalf.contains("fullday") && !firstHalf.equals("WO")
                                    && !firstHalf.equals("AB") && !firstHalf.equals("Casual Leave") && !firstHalf.equals("Sick Leave") && !firstHalf.equals("Privilege Leave")
                                    && !firstHalf.equals("Paternity Leave") && !firstHalf.equals("Maternity Leave") && !firstHalf.equals("Leave Without Pay") && !firstHalf.equals("AR")
                                    && !firstHalf.equals("TR") && !firstHalf.contains("?")) {
                                firstHalfVal = 0;
                                String[] leave = firstHalf.split("@");
                                String[] leave1 = leave[1].split("#");

                                String[] userTimeInStr = firstHalf.split("`");
                                String[] userTimeInStr1 = userTimeInStr[1].split("!");

                                String[] userTimeOutStr = firstHalf.split("!");
                                String[] userTimeOutStr1 = userTimeOutStr[1].split("@");

                                String[] LateHoursStr = firstHalf.split("\\$");
                                String[] LateHoursStr1 = LateHoursStr[1].split("%");

                                String[] endHoursStr = firstHalf.split("%");
                                String[] endHoursStr1 = endHoursStr[1].split("\\^");

                                String[] firstStartHoursStr = endHoursStr[1].split("\\+");

                                Date userTimeIn = sdf1.parse(userTimeInStr1[0]);
                                Date userTimeOut = sdf1.parse(userTimeOutStr1[0]);

                                Date LateHours = sdf1.parse(LateHoursStr1[0]);
                                Date endHours = sdf1.parse(endHoursStr1[0]);

                                Date firstStartHours = sdf1.parse(firstStartHoursStr[1]);

                                if (userTimeIn != null) {
                                    if ((userTimeIn.before(firstStartHours) || userTimeIn.equals(firstStartHours))
                                            && (userTimeOut.after(endHours) || userTimeOut.equals(endHours))) {
                                        prcounter = prcounter + 0.5;

                                    } else if (leave1[0] != null && !leave1[0].contains("Short Leave")) {

                                        if ((userTimeIn.before(LateHours) || userTimeIn.equals(LateHours))
                                                && (userTimeOut.after(endHours) || userTimeOut.equals(endHours))
                                                && firstCounter <= 31) {
                                            if (leave1[0].contains("AB")) {
                                                prcounter = prcounter + 0.5;
                                            }
                                            firstCounter = firstCounter + 1;
                                        } else if (leave1[0].contains("AR")) {
                                            ar = ar + 0.5;
                                        }
                                    }
                                } else if (userTimeIn == null && !firstHalf.equals("TR") && firstHalf.equals("AR") && !firstHalf.equals("WO")
                                        && !firstHalf.contains("?") && !firstHalf.equals("Casual Leave")
                                        && !firstHalf.equals("Sick Leave") && !firstHalf.equals("Privilege Leave")
                                        && !firstHalf.equals("Paternity Leave") && !firstHalf.equals("Maternity Leave") && !firstHalf.equals("Leave Without Pay")) {

                                    ar = ar + 0.5;
                                }
                            } else if (firstHalf.equals("AR")) {
                                ar = ar + 0.5;
                            }
//                    CellUtil.setAlignment(cell3, firstFWorkbook, CellStyle.ALIGN_CENTER);

//                    i++;
                            errorCount++;
                        }
                        Iterator itr2 = entry.getValue().iterator();
                        while (itr2.hasNext()) {
                            Object[] next = (Object[]) itr2.next();
                            String firstHalf = "" + next[1];
                            String shiftName = "";

                            if (firstHalf.contains("#")) {
                                String[] string1 = firstHalf.split("#");
                                String[] string2 = string1[1].split("\\$");
                                shiftName = string2[0].trim();
                            }
                            if (firstHalf.contains("fullday")) {
                                prcounter = prcounter + 0.5;
                            } else if (!firstHalf.contains("fullday") && !firstHalf.equals("WO")
                                    && !firstHalf.equals("AB") && !firstHalf.equals("Casual Leave") && !firstHalf.equals("Sick Leave") && !firstHalf.equals("Privilege Leave")
                                    && !firstHalf.equals("Paternity Leave") && !firstHalf.equals("Maternity Leave") && !firstHalf.equals("Leave Without Pay") && !firstHalf.equals("AR")
                                    && !firstHalf.equals("TR") && !firstHalf.contains("?")) {

                                String[] leave = firstHalf.split("@");
                                String[] leave1 = leave[1].split("#");

                                String[] userTimeInStr = firstHalf.split("`");
                                String[] userTimeInStr1 = userTimeInStr[1].split("!");

                                String[] userTimeOutStr = firstHalf.split("!");
                                String[] userTimeOutStr1 = userTimeOutStr[1].split("@");

                                String[] secondHalfTimeStr = firstHalf.split("\\^");
                                String[] secondHalfTimeStr1 = secondHalfTimeStr[1].split("&");

                                String[] endHoursStr = firstHalf.split("&");

                                Date userTimeIn = sdf1.parse(userTimeInStr1[0]);
                                Date userTimeOut = sdf1.parse(userTimeOutStr1[0]);

                                String[] getInHours = userTimeInStr1[0].split(":");
                                String[] getOutHours = userTimeOutStr1[0].split(":");

                                String abc = getInHours[0].trim();
                                String xyz = getOutHours[0].trim();

                                int i11 = Integer.parseInt(abc) - Integer.parseInt(xyz);
                                int totalDuration = 24 - i11;

                                String totalDuration2 = getOutHours[0];
                                Date secondHalfTimeStr2 = sdf1.parse(secondHalfTimeStr1[0]);
                                Date endHours = sdf1.parse(endHoursStr[1]);

                                if (userTimeIn != null) {

                                    if ((userTimeIn.before(secondHalfTimeStr2) || userTimeIn.equals(secondHalfTimeStr2))
                                            && (userTimeOut.after(endHours) || userTimeOut.equals(endHours))) {
                                        prcounter = prcounter + 0.5;
                                    } else if (shiftName.contains("Night")
                                            && (userTimeOut.after(endHours) || userTimeOut.equals(endHours))) {
                                        prcounter = prcounter + 0.5;
                                    } else if (shiftName.contains("Second")
                                            && (userTimeOut.after(endHours) || userTimeOut.equals(endHours))) {
                                        prcounter = prcounter + 0.5;
                                    } else if (leave1[0].contains("AR")) {
                                        ar = ar + 0.5;
                                    }
                                } else if (userTimeIn == null && !firstHalf.equals("TR") && firstHalf.equals("AR") && !firstHalf.equals("WO")
                                        && !firstHalf.contains("?") && !firstHalf.equals("Casual Leave")
                                        && !firstHalf.equals("Sick Leave") && !firstHalf.equals("Privilege Leave")
                                        && !firstHalf.equals("Paternity Leave") && !firstHalf.equals("Maternity Leave") && !firstHalf.equals("Leave Without Pay")) {

                                    ar = ar + 0.5;
                                } else if (firstHalf.equals("AR")) {
                                    ar = ar + 0.5;
                                }
                            }
                        }
                    }
                    Iterator itr3 = entry.getValue().iterator();
                    while (itr3.hasNext()) {
                        Object[] next = (Object[]) itr3.next();
                        String firstHalf = "" + next[1];
                        if (firstHalf.equals("WO")) {
                            wo = wo + 1;
                        }
                    }
                    Iterator itr4 = entry.getValue().iterator();
                    while (itr4.hasNext()) {
                        Object[] next = (Object[]) itr4.next();
                        String firstHalf = "" + next[1];
                        if (!firstHalf.contains("?") && !firstHalf.contains("`") && !firstHalf.contains("AB")
                                && !firstHalf.contains("WO") && !firstHalf.equals("Casual Leave") && !firstHalf.equals("Sick Leave") && !firstHalf.equals("Privilege Leave")
                                && !firstHalf.equals("Paternity Leave") && !firstHalf.equals("Maternity Leave") && !firstHalf.equals("Leave Without Pay") && !firstHalf.equals("AR")) {
                            holiday = holiday + 1;
                        }
                    }

                }

                double shortCount = 0;
                double cOff = 0;
                double casualLastCount = 0;
                double casualCurrentCount = 0;
                double sickLastCount = 0;
                double sickCurrentCount = 0;
                double privilegeLastCount = 0;
                double privilegeCurrentCount = 0;
                double paternityCount = 0;
                double maternityCount = 0;
                double travelLastMonth = 0;
                double travelcurMonth = 0;

                for (Map.Entry<Integer, List<?>> entry : map1.entrySet()) {
                    List leaveList = (List) entry.getValue().get(1);
                    Iterator itr4 = leaveList.iterator();
                    while (itr4.hasNext()) {
                        String shortLeave = "" + itr4.next();
                        if (shortLeave.contains("Short Leave")) {
                            shortCount = shortCount + 1;
                        }
                    }
                    Iterator itr5 = leaveList.iterator();
                    while (itr5.hasNext()) {
                        String cOffLeave = "" + itr5.next();
                        if (cOffLeave.contains("C Off Leave")) {
                            cOff = cOff + 1;
                        }
                    }

                    List lastleaveList = (List) entry.getValue().get(2);
                    Iterator itr6 = lastleaveList.iterator();
                    while (itr6.hasNext()) {
                        String casualLastCountList = "" + itr6.next();
                        if (casualLastCountList.contains("1 Casual Leave")) {
                            casualLastCount = casualLastCount + 1;
                        }
                        if (casualLastCountList.contains("0.5 Casual Leave")) {
                            casualLastCount = casualLastCount + 0.5;
                        }
                    }
                    List currentleaveList = (List) entry.getValue().get(1);
                    Iterator itr7 = currentleaveList.iterator();
                    while (itr7.hasNext()) {
                        String casualCurrentCountList = "" + itr7.next();
                        if (casualCurrentCountList.contains("1 Casual Leave")) {
                            casualCurrentCount = casualCurrentCount + 1;
                        }
                        if (casualCurrentCountList.contains("0.5 Casual Leave")) {
                            casualCurrentCount = casualCurrentCount + 0.5;
                        }
                    }
                    Iterator itr8 = lastleaveList.iterator();
                    while (itr8.hasNext()) {
                        String sickLastCountList = "" + itr8.next();
                        if (sickLastCountList.contains("1 Sick Leave")) {
                            sickLastCount = sickLastCount + 1;
                        }
                        if (sickLastCountList.contains("0.5 Sick Leave")) {
                            sickLastCount = sickLastCount + 0.5;
                        }
                    }
                    Iterator itr9 = currentleaveList.iterator();
                    while (itr9.hasNext()) {
                        String sickCurrentCountList = "" + itr9.next();
                        if (sickCurrentCountList.contains("1 Sick Leave")) {
                            sickCurrentCount = sickCurrentCount + 1;
                        }
                        if (sickCurrentCountList.contains("0.5 Sick Leave")) {
                            sickCurrentCount = sickCurrentCount + 0.5;
                        }
                    }
                    Iterator itr10 = lastleaveList.iterator();
                    while (itr10.hasNext()) {
                        String privilegeLastCountList = "" + itr10.next();
                        if (privilegeLastCountList.contains("1 Privilege Leave")) {
                            privilegeLastCount = privilegeLastCount + 1;
                        }
                        if (privilegeLastCountList.contains("0.5 Privilege Leave")) {
                            privilegeLastCount = privilegeLastCount + 0.5;
                        }
                    }
                    Iterator itr11 = currentleaveList.iterator();
                    while (itr11.hasNext()) {
                        String privilegeCurrentCountList = "" + itr11.next();
                        if (privilegeCurrentCountList.contains("1 Privilege Leave")) {
                            privilegeCurrentCount = privilegeCurrentCount + 1;
                        }
                        if (privilegeCurrentCountList.contains("0.5 Privilege Leave")) {
                            privilegeCurrentCount = privilegeCurrentCount + 0.5;
                        }
                    }
                    Iterator itr12 = currentleaveList.iterator();
                    while (itr12.hasNext()) {
                        String paternityCountList = "" + itr12.next();
                        if (paternityCountList.contains("1 Paternity Leave")) {
                            paternityCount = paternityCount + 1;
                        }
                        if (paternityCountList.contains("0.5 Paternity Leave")) {
                            paternityCount = paternityCount + 0.5;
                        }
                    }
                    Iterator itr13 = currentleaveList.iterator();
                    while (itr13.hasNext()) {
                        String maternityCountList = "" + itr13.next();
                        if (maternityCountList.contains("1 Paternity Leave")) {
                            maternityCount = maternityCount + 1;
                        }
                        if (maternityCountList.contains("0.5 Paternity Leave")) {
                            maternityCount = maternityCount + 0.5;
                        }
                    }

                    List travelPreviousMonth = (List) entry.getValue().get(5);
                    Iterator itr14 = travelPreviousMonth.iterator();
                    while (itr7.hasNext()) {
                        String travelPreviousList = "" + itr14.next();
                        if (travelPreviousList.contains("1")) {
                            travelLastMonth = travelLastMonth + 1;
                        }
                    }
                    List travelCurrentMonth = (List) entry.getValue().get(6);
                    Iterator itr15 = travelCurrentMonth.iterator();
                    while (itr15.hasNext()) {
                        String travelCurrentList = "" + itr15.next();
                        if (travelCurrentList.contains("1")) {
                            travelcurMonth = travelcurMonth + 1;
                        }
                    }

                }
                double arPreMonth = Double.parseDouble("" + attendanceRegularizationPreMonth.get(0));
                double shortL = shortCount / 2;
                double presentLeave = prcounter - shortL;

                double arrearsCount = casualLastCount + sickLastCount + privilegeLastCount + travelLastMonth + arPreMonth;
                double paidDaysCount = holiday + presentLeave + wo + shortCount + cOff + casualCurrentCount + sickCurrentCount + privilegeCurrentCount
                        + paternityCount + maternityCount + ar + travelcurMonth;

                double lwpCount = (travelCurrentMonthList.size()) - (presentLeave + wo + holiday
                        + shortCount + cOff + casualLastCount + casualCurrentCount + sickLastCount + sickCurrentCount
                        + privilegeLastCount + privilegeCurrentCount + paternityCount + maternityCount + ar + travelLastMonth + travelcurMonth
                        + arPreMonth);
                double totalDaysCount = travelCurrentMonthList.size();

                int i = l2.size() - 1;
                Cell cell = row.createCell(i);
                cell.setCellValue(presentLeave);
                i = i + 1;
                cell = row.createCell(i);
                cell.setCellValue(wo);
                i = i + 1;
                cell = row.createCell(i);
                cell.setCellValue(holiday);
                i = i + 1;
                cell = row.createCell(i);
                cell.setCellValue(shortCount);
                i = i + 1;
                cell = row.createCell(i);
                cell.setCellValue(cOff);
                i = i + 1;
                cell = row.createCell(i);
                cell.setCellValue(casualLastCount);
                i = i + 1;
                cell = row.createCell(i);
                cell.setCellValue(casualCurrentCount);
                i = i + 1;
                cell = row.createCell(i);
                cell.setCellValue(sickLastCount);
                i = i + 1;
                cell = row.createCell(i);
                cell.setCellValue(sickCurrentCount);
                i = i + 1;
                cell = row.createCell(i);
                cell.setCellValue(privilegeLastCount);
                i = i + 1;
                cell = row.createCell(i);
                cell.setCellValue(privilegeCurrentCount);
                i = i + 1;
                cell = row.createCell(i);
                cell.setCellValue(paternityCount);
                i = i + 1;
                cell = row.createCell(i);
                cell.setCellValue(maternityCount);
                i = i + 1;
                cell = row.createCell(i);
                cell.setCellValue(arPreMonth);
                i = i + 1;
                cell = row.createCell(i);
                cell.setCellValue(ar);
                i = i + 1;
                cell = row.createCell(i);
                cell.setCellValue(travelLastMonth);
                i = i + 1;
                cell = row.createCell(i);
                cell.setCellValue(travelcurMonth);
                i = i + 1;
                cell = row.createCell(i);
                cell.setCellValue(arrearsCount);
                i = i + 1;
                cell = row.createCell(i);
                cell.setCellValue(paidDaysCount);
                i = i + 1;
                cell = row.createCell(i);
                cell.setCellValue(lwpCount);
                i = i + 1;
                cell = row.createCell(i);
                cell.setCellValue(totalDaysCount);

//            map1.put(id, li);
                rownum++;
            } catch (Exception ex) {
                System.out.println("Exception" + ex);

            }
        }
        String appPath = request.getServletContext().getRealPath("");

        try {
            String filePath = appPath + File.separator + "StorageYard" + File.separator
                    + "Other" + File.separator + "UserDoc" + File.separator
                    + "EmployeeMonthlyPayRollReport" + File.separator + "EmployeeMonthlyAttendance.xls";
            FileOutputStream fos = new FileOutputStream(new File(filePath));
//            HSSFCellStyle hsfstyle = firstFWorkbook.createCellStyle();
//            hsfstyle.setBorderBottom((short) 1);
//            hsfstyle.setFillBackgroundColor((short) 245);
            firstFWorkbook.write(fos);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String filePath = File.separator + "StorageYard" + File.separator
                + "Other" + File.separator + "UserDoc" + File.separator
                + "EmployeeMonthlyPayRollReport" + File.separator + "EmployeeMonthlyAttendance.xls";

        appPath = request.getServletContext().getRealPath("");

        String fullPath = appPath + filePath;

        request.setAttribute(
                "filePath", fullPath);

        DownloadFile downloadFile = new DownloadFile();

        downloadFile.doDownload(request, response);
        return mv;
    }

    public ModelAndView employeeAttendanceForLuna(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeShiftData employeeShiftData = new EmployeeShiftData();
        EmployeeAdvanceSearch employeeAdvanceSearch = new EmployeeAdvanceSearch();
        selectEmployeeForLuna(request, response);
        mv.getModelMap().put("employeeAdvanceSearch", employeeAdvanceSearch);
        mv.setViewName("Shift/EmployeeOrDateWiseShiftSearchForPlant");

        return mv;
    }

    public ModelAndView employeeAttendanceForLunaSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = new EmployeeMaster();

        String empId = request.getParameter("employeeMasterId");
        String startDate = request.getParameter("inDateTime");
        String endDate = request.getParameter("outDateTime");
//         == == == == == == == == == == = Luna Plant Id Is 7==============================
        String zydexLocationId = "7";
//        =====================Luna Plant Id Is 7==============================
        EmployeeAdvanceSearch employeeAdvanceSearch = new EmployeeAdvanceSearch();
        bind(request, employeeAdvanceSearch);
        if (null != empId && !empId.equals("")) {
            employeeAdvanceSearch.setId(empId);
        } else {
            employeeAdvanceSearch.setZydexLocationId(zydexLocationId);

        }

        int rownum = 0;
        HSSFWorkbook firstFWorkbook = new HSSFWorkbook();
        HSSFSheet firstSheet = firstFWorkbook.createSheet("FIRST SHEET");
        Row headerRow = firstSheet.createRow(rownum);
        headerRow.setHeightInPoints(40);
        HSSFFont redFont = firstFWorkbook.createFont();
        redFont.setColor(HSSFColor.RED.index);
        HSSFCellStyle stylered = firstFWorkbook.createCellStyle();
        stylered.setFont(redFont);

        HSSFFont greenFont = firstFWorkbook.createFont();
        greenFont.setColor(HSSFColor.GREEN.index);
        HSSFCellStyle stylegreen = firstFWorkbook.createCellStyle();
        stylegreen.setFont(greenFont);

        HSSFFont blueFont = firstFWorkbook.createFont();
        blueFont.setColor(HSSFColor.BLUE.index);
        HSSFCellStyle styleblue = firstFWorkbook.createCellStyle();
        styleblue.setFont(blueFont);

        HSSFFont boldFont = firstFWorkbook.createFont();
        boldFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
        HSSFCellStyle styleBold = firstFWorkbook.createCellStyle();
        styleBold.setFont(boldFont);
        employeeAdvanceSearch.setEmployeeId(Boolean.TRUE);
        employeeAdvanceSearch.setEmployeeName(Boolean.TRUE);
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

        List<String> headerRow1 = new ArrayList();
        if (employeeAdvanceSearch.getEmployeeId() == true) {
            headerRow1.add("Employee ID");

        }
        if (employeeAdvanceSearch.getEmployeeName() == true) {
            headerRow1.add("Employee Name");
        }

        List<List<String>> recordToAdd = new ArrayList();
        List<List<String>> recordToAdd1 = new ArrayList();
        EmployeeShiftData employeeShiftData = new EmployeeShiftData();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calForFlexiNotSupport1 = Calendar.getInstance();
        Calendar calForFlexiNotSupport2 = Calendar.getInstance();
        if (!startDate.equals("")) {
            Date notflexibleSupportDate = sdf.parse(startDate);
            String FixedFlexibleDate = "01/04/2016";
            Date notflexibleSupportDate1 = sdf.parse(FixedFlexibleDate);
            calForFlexiNotSupport1.setTime(notflexibleSupportDate);
            calForFlexiNotSupport2.setTime(notflexibleSupportDate1);
        }

        if (null != empId && !empId.equals("")) {
            employeeShiftData.setId(Integer.parseInt(empId));
        }
        if (null != startDate && !startDate.equals("")) {
            Date sDate = sdf.parse(startDate);
            employeeShiftData.setInDateTime(new SimpleDateFormat("yyyy-MM-dd").format(sDate));
        }
        if (null != endDate && !endDate.equals("")) {
            Date eDate = sdf.parse(endDate);
            employeeShiftData.setOutDateTime(new SimpleDateFormat("yyyy-MM-dd").format(eDate));
        }

        recordToAdd.add(headerRow1);

        List<?> empDetail = new ArrayList<>();

        empDetail = employeeMasterService.empOrDateWiseSearchforActive(employeeAdvanceSearch);

        Iterator it = empDetail.iterator();
        while (it.hasNext()) {

//            Row row = firstSheet.createRow(rownum);
            List<String> employeeInfoList = new ArrayList();
            List<String> employeeInfoList1 = new ArrayList();
            Object[] next = (Object[]) it.next();
            employeeInfoList1.add("" + next[47]);
            if (employeeAdvanceSearch.getEmployeeId() == true) {
                employeeInfoList.add("" + next[0]);
            }
            if (employeeAdvanceSearch.getEmployeeName() == true) {
                employeeInfoList.add("" + next[1]);
            }

            if (null == next[2]) {
                next[2] = "";
            }
            if (null == next[3]) {
                next[3] = "";
            }
            if (null == next[4]) {
                next[4] = "";
            }
            if (null == next[5]) {
                next[5] = "";
            }
            if (null == next[6]) {
                next[6] = "";
            }
            if (null == next[7]) {
                next[7] = "";
            }
            if (null == next[8]) {
                next[8] = "";
            }
            if (null == next[9]) {
                next[9] = "";
            }
            if (null == next[10]) {
                next[10] = "";
            }
            if (null == next[11]) {
                next[11] = "";
            }
            if (null == next[12]) {
                next[12] = "";
            }
            if (null == next[13]) {
                next[13] = "";
            }
            if (null == next[14]) {
                next[14] = "";
            }
            if (null == next[15]) {
                next[15] = "";
            }
            if (null == next[16]) {
                next[16] = "";
            }
            if (null == next[17]) {
                next[17] = "";
            }
            if (null == next[18]) {
                next[18] = "";
            }
            if (null == next[19]) {
                next[19] = "";
            }
            if (null == next[20]) {
                next[20] = "";
            }
            if (null == next[21]) {
                next[21] = "";
            }
            if (null == next[22]) {
                next[22] = "";
            }
            if (null == next[23]) {
                next[23] = "";
            }
            if (null == next[24]) {
                next[24] = "";
            }
            if (null == next[25]) {
                next[25] = "";
            }
            if (null == next[26]) {
                next[26] = "";
            }
            if (null == next[27]) {
                next[27] = "";
            }
            if (null == next[28]) {
                next[28] = "";
            }
            if (null == next[29]) {
                next[29] = "";
            }
            if (null == next[30]) {
                next[30] = "";
            }
            if (null == next[31]) {
                next[31] = "";
            }
            if (null == next[32]) {
                next[32] = "";
            }
            if (null == next[33]) {
                next[33] = "";
            }
            if (null == next[34]) {
                next[34] = "";
            }
            if (null == next[35]) {
                next[35] = "";
            }
            if (null == next[36]) {
                next[36] = "";
            }
            if (null == next[37]) {
                next[37] = "";
            }
            if (null == next[38]) {
                next[38] = "";
            }
            if (null == next[39]) {
                next[39] = "";
            }
            if (null == next[40]) {
                next[40] = "";
            }
            if (null == next[41]) {
                next[41] = "";
            }
            if (null == next[42]) {
                next[42] = "";
            }
            if (null == next[43]) {
                next[43] = "";
            }
            if (null == next[44]) {
                next[44] = "";
            }
            if (null == next[45]) {
                next[45] = "";
            }
            if (null == next[46]) {
                next[46] = "";
            }
            if (null == next[47]) {
                next[47] = "";
            }
            if (employeeAdvanceSearch.getFatherName() == true) {
                employeeInfoList.add("" + next[2]);
            }
            if (employeeAdvanceSearch.getMotherName() == true) {
                employeeInfoList.add("" + next[3]);
            }
            if (employeeAdvanceSearch.getGender() == true) {
                employeeInfoList.add("" + next[4]);
            }
            if (employeeAdvanceSearch.getMaritalStatus() == true) {
                employeeInfoList.add("" + next[5]);
            }
            if (employeeAdvanceSearch.getDateOfBirth() == true) {
                employeeInfoList.add("" + next[6]);
            }
            if (employeeAdvanceSearch.getPresentAddress() == true) {
                employeeInfoList.add("" + next[7]);
            }
            if (employeeAdvanceSearch.getPermanentAddress() == true) {
                employeeInfoList.add("" + next[8]);
            }
            if (employeeAdvanceSearch.getBloodGroups() == true) {
                employeeInfoList.add("" + next[9]);
            }
            if (employeeAdvanceSearch.getEmailAddress() == true) {
                employeeInfoList.add("" + next[10]);
            }
            if (employeeAdvanceSearch.getContactNo1() == true) {
                employeeInfoList.add("" + next[11]);
            }
            if (employeeAdvanceSearch.getContactNo2() == true) {
                employeeInfoList.add("" + next[12]);
            }
            if (employeeAdvanceSearch.getEmergencyContactPerson() == true) {
                employeeInfoList.add("" + next[13]);
            }
            if (employeeAdvanceSearch.getEmergencyContactNo() == true) {
                employeeInfoList.add("" + next[14]);
            }
            if (employeeAdvanceSearch.getPanCard() == true) {
                employeeInfoList.add("" + next[15]);
            }
            if (employeeAdvanceSearch.getPassportNo() == true) {
                employeeInfoList.add("" + next[16]);
            }
            if (employeeAdvanceSearch.getPassportIssueDate() == true) {
                employeeInfoList.add("" + next[17]);
            }
            if (employeeAdvanceSearch.getPassportExpiryDate() == true) {
                employeeInfoList.add("" + next[18]);
            }
            if (employeeAdvanceSearch.getAdharCard() == true) {
                employeeInfoList.add("" + next[19]);
            }
            if (employeeAdvanceSearch.getOfficeEmailId() == true) {
                employeeInfoList.add("" + next[20]);
            }
            if (employeeAdvanceSearch.getHighestEducationDetails() == true) {
                employeeInfoList.add("" + next[21]);
            }
            if (employeeAdvanceSearch.getExperienceYearOnDoj() == true) {
                employeeInfoList.add("" + next[22]);
            }
            if (employeeAdvanceSearch.getExperienceMonthOnDoj() == true) {
                employeeInfoList.add("" + next[23]);
            }
            if (employeeAdvanceSearch.getCompany() == true) {
                employeeInfoList.add("" + next[24]);
            }
            if (employeeAdvanceSearch.getZydexLocation() == true) {
                employeeInfoList.add("" + next[25]);
            }
            if (employeeAdvanceSearch.getWorkLocation() == true) {
                employeeInfoList.add("" + next[26]);
            }
            if (employeeAdvanceSearch.getLevel() == true) {
                employeeInfoList.add("" + next[27]);
            }
            if (employeeAdvanceSearch.getDepartment() == true) {
                employeeInfoList.add("" + next[28]);
            }
            if (employeeAdvanceSearch.getDesignation() == true) {
                employeeInfoList.add("" + next[29]);
            }
            if (employeeAdvanceSearch.getRole() == true) {
                employeeInfoList.add("" + next[30]);
            }
            if (employeeAdvanceSearch.getDateOfJoining() == true) {
                employeeInfoList.add("" + next[31]);
            }
            if (employeeAdvanceSearch.getEmployeeType() == true) {
                employeeInfoList.add("" + next[32]);
            }
            if (employeeAdvanceSearch.getBankName() == true) {
                employeeInfoList.add("" + next[33]);
            }
            if (employeeAdvanceSearch.getBankAccountNo() == true) {
                employeeInfoList.add("" + next[34]);
            }
            if (employeeAdvanceSearch.getBankIfscCode() == true) {
                employeeInfoList.add("" + next[35]);
            }
            if (employeeAdvanceSearch.getReportingManager() == true) {
                employeeInfoList.add("" + next[36]);
            }
            if (employeeAdvanceSearch.getCityOfEmployee() == true) {
                employeeInfoList.add("" + next[37]);
            }
            if (employeeAdvanceSearch.getChild1() == true) {
                employeeInfoList.add("" + next[38]);
            }
            if (employeeAdvanceSearch.getChild2() == true) {
                employeeInfoList.add("" + next[39]);
            }
            if (employeeAdvanceSearch.getDateOfBirthOfEmpFather() == true) {
                employeeInfoList.add("" + next[40]);
            }
            if (employeeAdvanceSearch.getDateOfBirthOfEmpMother() == true) {
                employeeInfoList.add("" + next[41]);
            }
            if (employeeAdvanceSearch.getDateOfBirthOfEmpSpous() == true) {
                employeeInfoList.add("" + next[42]);
            }
            if (employeeAdvanceSearch.getDateOfBirthOfEmpChilld1() == true) {
                employeeInfoList.add("" + next[43]);
            }
            if (employeeAdvanceSearch.getDateOfBirthOfEmpChild2() == true) {
                employeeInfoList.add("" + next[44]);
            }
            if (employeeAdvanceSearch.getDateOfTransferOfEntity() == true) {
                employeeInfoList.add("" + next[45]);
            }

            recordToAdd.add(employeeInfoList);
            recordToAdd1.add(employeeInfoList1);

        }

        try {

            String empId1 = "0";
            int z = 0;
            for (int j = 0; j < recordToAdd.size(); j++) {
                Map<Integer, List<?>> map = new LinkedHashMap<Integer, List<?>>();
                Map<Integer, List<?>> map1 = new LinkedHashMap<Integer, List<?>>();
                Row row = firstSheet.createRow(rownum);
                List<String> l2 = recordToAdd.get(j);

                boolean myFlage = false;
                int id = 0;
                int countK = 1;
                for (int k = 0; k < l2.size(); k++) {
                    Cell cell = row.createCell(k);

                    cell.setCellValue(l2.get(k));
                    if (j == 0) {
                        cell.setCellStyle(styleBold);
                    }
                }

                if (null != startDate && !startDate.equals("") && null != endDate && !endDate.equals("")) {

                    if (j != 0) {

                        List<String> l3 = new ArrayList<>();
                        try {
                            l3 = recordToAdd1.get(z);
                            empId1 = l3.get(0);
                            z++;
                        } catch (Exception e) {
                        }

                        id = Integer.parseInt(empId1);
                        employeeShiftData.setId(id);
                        List<?> list = employeeShiftDataService.empOrDateWiseSearch(employeeShiftData);
                        map.put(id, list);
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
                        if (flexible == true && calForFlexiNotSupport2.get(Calendar.MONTH) != calForFlexiNotSupport1.get(Calendar.MONTH)) {
                            rownum = rownum + 1;
                            Row row4 = firstSheet.createRow(rownum);
                            Cell cell4 = row4.createCell(0);
                            cell4.setCellValue("");
                            rownum = rownum + 1;

                            Row row1 = firstSheet.createRow(rownum);
                            Cell cell1 = row1.createCell(0);
                            cell1.setCellValue("Employee Daily Attendance Information");
                            cell1.setCellStyle(styleBold);
                            double prcounter = 0;
                            double abcounter = 0;
                            double wo = 0;
                            double shl = 0;
                            double shla = 0;
                            double cl = 0;
                            double sl = 0;
                            double pl = 0;
                            double holiday = 0;
                            double tr = 0;
                            double ar = 0;
                            //                int zz = 0;
                            for (Map.Entry<Integer, List<?>> entry : map.entrySet()) {
                                rownum = rownum + 1;
                                Row row33 = firstSheet.createRow(rownum);
                                rownum = rownum + 1;
                                Row row3 = firstSheet.createRow(rownum);

                                Iterator itr1 = entry.getValue().iterator();
                                int i = 1;
                                int k = 1;
                                int l = 1;
                                int m = 1;
                                int n = 1;
                                int o = 1;
                                int p = 1;
                                SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm");
                                Cell cellTitle = row3.createCell(0);
                                cellTitle.setCellValue("Date");
                                cellTitle.setCellStyle(styleBold);
                                while (itr1.hasNext()) {
                                    Object[] next = (Object[]) itr1.next();
                                    Cell cell3 = row3.createCell(i);
                                    cell3.setCellValue("" + next[0]);
                                    CellUtil.setAlignment(cell3, firstFWorkbook, CellStyle.ALIGN_CENTER);

                                    i++;
                                }
                                rownum = rownum + 1;
                                Row row5 = firstSheet.createRow(rownum);
                                Iterator itr2 = entry.getValue().iterator();
                                Cell cellTitle1 = row5.createCell(0);
                                cellTitle1.setCellValue("Shift Name");
                                cellTitle1.setCellStyle(styleBold);
                                while (itr2.hasNext()) {
                                    Object[] next = (Object[]) itr2.next();
                                    Cell cell5 = row5.createCell(l);
                                    String shiftName = "" + next[1];
                                    if (shiftName.contains("#")) {
                                        String[] shiftName1 = shiftName.split("#");
                                        String[] shiftName2 = shiftName1[1].split("\\$");
                                        cell5.setCellValue("" + shiftName2[0]);
                                    } else if (!shiftName.contains("`")) {
                                        cell5.setCellValue("-");
                                    }

                                    CellUtil.setAlignment(cell5, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    l++;

                                }
                                rownum = rownum + 1;
                                Row row6 = firstSheet.createRow(rownum);
                                Iterator itr3 = entry.getValue().iterator();
                                Cell cellTitle2 = row6.createCell(0);
                                cellTitle2.setCellValue("First In");
                                cellTitle2.setCellStyle(styleBold);
                                int weekNameCounter1 = 0;
                                while (itr3.hasNext()) {
                                    Object[] next = (Object[]) itr3.next();
                                    Cell cell6 = row6.createCell(k);
                                    String firstIn = "" + next[1];
                                    if (firstIn.contains("`") && !firstIn.contains("?")) {
                                        String[] firstIn1 = firstIn.split("`");
                                        String[] firstIn12 = firstIn1[1].split("!");
                                        cell6.setCellValue("" + firstIn12[0]);
                                    } else if (!firstIn.contains("`") && !firstIn.contains("?") && !firstIn.contains("AB") && !firstIn.equals("WO") && !firstIn.contains("TR") && !firstIn.contains("AR")) {
                                        if (firstIn.contains("Casual Leave")) {
                                            cl = cl + 1;
                                        }
                                        if (firstIn.contains("Privilege Leave")) {
                                            pl = pl + 1;
                                        }
                                        if (firstIn.contains("Sick Leave")) {
                                            sl = sl + 1;
                                        }
                                        cell6.setCellValue("" + next[1]);
                                    } else if (!firstIn.contains("`") && firstIn.contains("?") && !firstIn.contains("AB") && !firstIn.equals("WO") && !firstIn.contains("TR") && !firstIn.contains("AR")) {
                                        String[] hostring = firstIn.split("\\?");
                                        cell6.setCellValue("" + hostring[0]);
                                        holiday = holiday + 1;
                                    } else if (!firstIn.contains("`") && firstIn.contains("?") && firstIn.contains("AB") && !firstIn.equals("WO") && !firstIn.contains("TR") && !firstIn.contains("AR")) {
                                        cell6.setCellValue("-");
                                    } else if (firstIn.equals("WO")) {
                                        cell6.setCellValue(firstIn);
                                        wo = wo + 1;
                                    } else if (firstIn.equals("TR")) {
                                        cell6.setCellValue(firstIn);
                                        tr = tr + 1;
                                        cell6.setCellStyle(styleblue);
                                    }
                                    CellUtil.setAlignment(cell6, firstFWorkbook, CellStyle.ALIGN_CENTER);
//                                    2nd Sat Week Off Codding
                                    Calendar cal = Calendar.getInstance();
                                    Date date = sdf.parse("" + next[0]);
                                    cal.setTime(date);
                                    SimpleDateFormat format = new SimpleDateFormat("EEEE");
                                    String dayName = format.format(date);
                                    EmployeeMaster employeeMaster1 = employeeMasterService.readById(id);
                                    ZydexLocationMaster zydexLocationMaster = zydexLocationMasterService.readById(employeeMaster1.getZydexLocationMaster().getId());

                                    if (dayName.equals("Saturday")) {
                                        weekNameCounter1++;
                                        if (weekNameCounter1 == 2) {
                                            if (firstIn.contains("Casual Leave")) {
                                                cl = cl - 0.5;
                                            }
                                            if (firstIn.contains("Privilege Leave")) {
                                                pl = pl - 0.5;
                                            }
                                            if (firstIn.contains("Sick Leave")) {
                                                sl = sl - 0.5;
                                            }
                                        }

                                    }
//                                    2nd Sat Week Off Codding
                                    k++;
                                }

                                rownum = rownum + 1;
                                Row row7 = firstSheet.createRow(rownum);
                                Cell cellTitle3 = row7.createCell(0);
                                cellTitle3.setCellValue("Last Out");
                                cellTitle3.setCellStyle(styleBold);
                                Iterator itr4 = entry.getValue().iterator();
                                while (itr4.hasNext()) {
                                    Object[] next = (Object[]) itr4.next();
                                    Cell cell7 = row7.createCell(m);
                                    String lastOut = "" + next[1];
                                    if (lastOut.contains("!")) {
                                        String[] lastOut1 = lastOut.split("`");
                                        String[] lastOut2 = lastOut1[1].split("!");
                                        String[] lastOut3 = lastOut.split("!");
                                        String[] lastOut4 = lastOut3[1].split("@");
                                        Date lout = sdf1.parse(lastOut4[0]);
                                        Date fin = sdf1.parse(lastOut2[0]);
                                        if (lout.equals(fin)) {
                                            cell7.setCellValue("-");
                                        } else {
                                            cell7.setCellValue("" + lastOut4[0]);
                                        }

                                    } else if (lastOut.contains("@")) {
                                        cell7.setCellValue("-");
                                    }
                                    CellUtil.setAlignment(cell7, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    m++;
                                }
                                rownum = rownum + 1;
                                Row row8 = firstSheet.createRow(rownum);
                                Cell cellTitle4 = row8.createCell(0);
                                cellTitle4.setCellValue("First Half");
                                cellTitle4.setCellStyle(styleBold);
                                Iterator itr5 = entry.getValue().iterator();
                                int firstCounter = 0;

                                while (itr5.hasNext()) {
                                    Object[] next = (Object[]) itr5.next();
                                    Cell cell8 = row8.createCell(n);
                                    String firstHalf = "" + next[1];
                                    int firstHalfVal = 0;
                                    int counter = 0;

                                    if (firstHalf.contains("fullday")) {
                                        cell8.setCellValue("PR");
                                        prcounter = prcounter + 0.5;
                                        cell8.setCellStyle(stylegreen);

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
                                        Date userTimeIn = sdf1.parse(userTimeInStr1[0]);
                                        Date userTimeOut = sdf1.parse(userTimeOutStr1[0]);
                                        Date endHours = sdf1.parse(endHoursStr1[0]);
                                        Date firstStartHours = sdf1.parse(firstStartHoursStr[1]);
                                        Calendar cal = Calendar.getInstance();
                                        Calendar cal1 = Calendar.getInstance();
                                        cal.setTime(firstStartHours);
                                        cal1.setTime(firstStartHours);
                                        cal1.add(Calendar.MINUTE, -earlyMinute);
                                        cal.add(Calendar.MINUTE, lateMinute);
                                        String newTime = sdf1.format(cal.getTime());
                                        Date flexibleEndTime = sdf1.parse(newTime);
                                        Date LateHours = sdf1.parse(LateHoursStr1[0]);
                                        String newTime1 = sdf1.format(cal1.getTime());
                                        Date flexibleStartTime = sdf1.parse(newTime1);
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
                                                cell8.setCellValue("PR");
                                                prcounter = prcounter + 0.5;
                                                cell8.setCellStyle(stylegreen);
                                            } else if (userTimeOut.before(userTimeIn)) {
                                                cell8.setCellValue("PR");
                                                prcounter = prcounter + 0.5;
                                                cell8.setCellStyle(stylegreen);
                                            } else if (leave1[0] != null && !leave1[0].contains("Short Leave")) {
                                                if ((userTimeIn.before(flexibleEndTime) || userTimeIn.equals(flexibleEndTime)) && (userTimeOut.after(endHours) || userTimeOut.equals(endHours))) {
                                                    cell8.setCellValue("PR");
                                                    prcounter = prcounter + 0.5;
                                                    cell8.setCellStyle(stylegreen);
                                                } else if (leave1[0].contains("AB")) {
                                                    cell8.setCellValue("AB");
                                                    abcounter = abcounter + 0.5;
                                                    cell8.setCellStyle(stylered);
                                                } else if (leave1[0].contains("AR")) {
                                                    cell8.setCellValue("AR/P");
                                                    ar = ar + 0.5;
                                                    cell8.setCellStyle(styleblue);
                                                } else {
                                                    if (leave1[0].contains("Casual Leave")) {
                                                        cl = cl + 0.5;
                                                    }
                                                    if (leave1[0].contains("Privilege Leave")) {
                                                        pl = pl + 0.5;
                                                    }
                                                    if (leave1[0].contains("Sick Leave")) {
                                                        sl = sl + 0.5;
                                                    }
                                                    cell8.setCellValue(" " + leave1[0]);
                                                }

                                            } else if (null != leave1[0] && leave1[0].contains("Short Leave")) {
                                                if (firstHalf.contains("*")) {
                                                    String[] shortArray = firstHalf.split("\\*");
                                                    String[] endArray = shortArray[1].split("\\-");
                                                    String[] startTime = endArray[1].split("\\+");
                                                    Date shortIn = sdf1.parse(shortArray[1]);
                                                    Date shortend = sdf1.parse(endArray[1]);
                                                    Date startTime1 = sdf1.parse(startTime[1]);
                                                    if (shortIn.before(endHours)) {
                                                        cell8.setCellValue("SHL/P");
                                                        cell8.setCellStyle(stylegreen);
                                                        shl = shl + 1;
                                                    } else if (leave1[0].contains("~ AR")) {
                                                        cell8.setCellValue("AR/P");
                                                        ar = ar + 0.5;
                                                        cell8.setCellStyle(styleblue);
                                                    } else if (userTimeIn.after(endHours)) {
                                                        cell8.setCellValue("SHL/A");
                                                        shla = shla + 1;
                                                        cell8.setCellStyle(stylered);
                                                    } else if ((userTimeIn.before(flexibleEndTime) || userTimeIn.equals(flexibleEndTime)) && (userTimeOut.after(endHours) || userTimeOut.equals(endHours))) {
                                                        cell8.setCellValue("PR");
                                                        prcounter = prcounter + 0.5;
                                                        cell8.setCellStyle(stylegreen);
                                                    } else {
                                                        cell8.setCellValue("AB");
                                                        abcounter = abcounter + 0.5;
                                                        cell8.setCellStyle(stylered);
                                                    }
                                                } else {
                                                    cell8.setCellValue("AB");
                                                    abcounter = abcounter + 0.5;
                                                    cell8.setCellStyle(stylered);
                                                }
                                            } else if (null != leave1[0] && !leave1[0].contains("AB")) {
                                                if (leave1[0].contains("Casual Leave")) {
                                                    cl = cl + 0.5;
                                                }
                                                if (leave1[0].contains("Privilege Leave")) {
                                                    pl = pl + 0.5;
                                                }
                                                if (leave1[0].contains("Sick Leave")) {
                                                    sl = sl + 0.5;
                                                }
                                                cell8.setCellValue(" " + leave1[0]);

                                            } else if (leave1[0].contains("AB")) {
                                                cell8.setCellValue("-");
                                            } else {
                                                cell8.setCellValue("AB");
                                                abcounter = abcounter + 0.5;
                                                cell8.setCellStyle(stylered);
                                            }

                                        } else if (userTimeIn != null && !firstHalf.contains("WO") && !firstHalf.contains("?")) {
                                            cell8.setCellValue("AB");
                                            abcounter = abcounter + 0.5;
                                            cell8.setCellStyle(stylered);
                                        } else if (firstHalf.contains("WO") || firstHalf.contains("?")) {
                                            cell8.setCellValue("-");
                                        }

                                    } else if (firstHalf.equals("WO")) {
                                        cell8.setCellValue("");
                                    } else if (firstHalf.contains("AR")) {
                                        cell8.setCellValue("AR/P");
                                        ar = ar + 0.5;
                                        cell8.setCellStyle(styleblue);
                                    } else if (firstHalf.equals("AB")) {
                                        cell8.setCellValue("AB");
                                        abcounter = abcounter + 0.5;
                                        cell8.setCellStyle(stylered);
                                    }
                                    CellUtil.setAlignment(cell8, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    n++;
                                }

                                rownum = rownum + 1;
                                Row row9 = firstSheet.createRow(rownum);
                                Cell cellTitle5 = row9.createCell(0);
                                cellTitle5.setCellValue("Second Half");
                                cellTitle5.setCellStyle(styleBold);
                                Iterator itr6 = entry.getValue().iterator();
                                int weekNameCounter = 0;
                                boolean satWeekOff = false;
                                while (itr6.hasNext()) {
                                    Object[] next = (Object[]) itr6.next();
                                    Cell cell9 = row9.createCell(o);
                                    String secondHalf = "" + next[1];
                                    int firstHalfVal = 0;
                                    int counter = 0;
                                    String shiftName = "";
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
                                            Date userTimeIn = sdf1.parse(userTimeInStr1[0]);
                                            Date userTimeOut = sdf1.parse(userTimeOutStr1[0]);
                                            String[] startHoursStr = secondHalf.split("%");
                                            String[] firstStartHoursStr = startHoursStr[1].split("\\+");
                                            String[] endHoursStr = secondHalf.split("&");
                                            Date firstStartHours = sdf1.parse(firstStartHoursStr[1]);
                                            Calendar cal1 = Calendar.getInstance();
                                            cal1.setTime(firstStartHours);
                                            cal1.add(Calendar.MINUTE, -earlyMinute);

                                            String newTime1 = sdf1.format(cal1.getTime());
                                            Date flexibleInTime = sdf1.parse(newTime1);
                                            Date endHours = sdf1.parse(endHoursStr[1]);
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
                                    } catch (Exception e) {

                                    }

//                                    Lunch Breck Cut Off
                                    if (secondHalf.contains(" # ")) {
                                        String[] string1 = secondHalf.split("#");
                                        String[] string2 = string1[1].split("\\$");
                                        shiftName = string2[0].trim();

                                    }
                                    if (satWeekOff == true && (zydexLocationMaster.getZydexLocation().equals("HO") || zydexLocationMaster.getZydexLocation().equals("R&D"))) {
                                        cell9.setCellValue("WO");
                                        wo = wo + 0.5;
                                    } else if (secondHalf.equals("AR")) {
                                        cell9.setCellValue("AR/P");
                                        ar = ar + 0.5;
                                        cell9.setCellStyle(styleblue);
                                    } else if (checkLunchTime == true && totalTime < shiftdiffMinutes && !secondHalf.contains("AR")) {
                                        cell9.setCellValue("AB");
                                        abcounter = abcounter + 0.5;
                                        cell9.setCellStyle(stylered);
                                    } else if (secondHalf.contains("fullday")) {
                                        cell9.setCellValue("PR");
                                        prcounter = prcounter + 0.5;
                                        cell9.setCellStyle(stylegreen);

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

                                        Date userTimeIn = sdf1.parse(userTimeInStr1[0]);
                                        Date userTimeOut = sdf1.parse(userTimeOutStr1[0]);
                                        Date userTimeOut1 = sdf1.parse("23:59");
                                        Date firstStartHours = sdf1.parse(firstStartHoursStr[1]);
                                        String[] getInHours = userTimeInStr1[0].split(":");
                                        String[] getOutHours = userTimeOutStr1[0].split(":");
                                        String abc = getInHours[0].trim();
                                        String xyz = getOutHours[0].trim();
                                        int i11 = Integer.parseInt(abc) - Integer.parseInt(xyz);
                                        int totalDuration = 24 - i11;
                                        String totalDuration2 = getOutHours[0];
                                        Date endHours = sdf1.parse(endHoursStr[1]);
                                        Date secondHalfTimeStr2 = sdf1.parse(secondHalfTimeStr1[0]);

                                        Calendar cal1 = Calendar.getInstance();
                                        Calendar cal2 = Calendar.getInstance();
                                        cal1.setTime(firstStartHours);
                                        cal1.add(Calendar.MINUTE, -earlyMinute);
                                        cal2.setTime(firstStartHours);
                                        cal2.add(Calendar.MINUTE, lateMinute);
                                        String newTime = sdf1.format(cal2.getTime());
                                        Date flexibleEndTime = sdf1.parse(newTime);

                                        String newTime1 = sdf1.format(cal1.getTime());
                                        Date flexibleInTime = sdf1.parse(newTime1);
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
                                                cell9.setCellValue("AR/P");
                                                ar = ar + 0.5;
                                                cell9.setCellStyle(styleblue);
                                            } else if (diffMinutes1 >= diffMinutes && userTimeIn.before(flexibleEndTime)) {
                                                cell9.setCellValue("PR");
                                                prcounter = prcounter + 0.5;
                                                cell9.setCellStyle(stylegreen);
                                            } else if (diffMinutes1 <= diffMinutes && userTimeIn.before(flexibleEndTime) && !secondHalf.contains("WO") && !secondHalf.contains("TR") && !secondHalf.contains("AR") && !secondHalf.contains("?")
                                                    && !secondHalf.contains("Casual Leave") && !secondHalf.equals("C Off Leave") && !secondHalf.contains("Privilege Leave") && !secondHalf.contains("Sick Leave")
                                                    && !secondHalf.contains("Paternity Leave") && !secondHalf.contains("Maternity Leave") && !secondHalf.contains("Leave Without Pay")) {
                                                cell9.setCellValue("AB");
                                                abcounter = abcounter + 0.5;
                                                cell9.setCellStyle(stylered);
                                            } else if (diffMinutes1 >= 240 && userTimeIn.after(secondHalfTimeStr2)) {
                                                cell9.setCellValue("PR");
                                                prcounter = prcounter + 0.5;
                                                cell9.setCellStyle(stylegreen);
                                            } else if ((userTimeIn.before(secondHalfTimeStr2) || userTimeIn.equals(secondHalfTimeStr2)) && (userTimeOut.after(endHours) || userTimeOut.equals(endHours))) {
                                                cell9.setCellValue("PR");
                                                prcounter = prcounter + 0.5;
                                                cell9.setCellStyle(stylegreen);
                                            } else if (shiftName.contains("Night") && (userTimeOut.after(endHours) || userTimeOut.equals(endHours))) {
                                                cell9.setCellValue("PR");
                                                prcounter = prcounter + 0.5;
                                                cell9.setCellStyle(stylegreen);
                                            } else if (null != leave1[0] && leave1[0].contains("Short Leave")) {
                                                if (secondHalf.contains("*")) {
                                                    String[] shortArray = secondHalf.split("\\*");
                                                    String[] endArray = secondHalf.split("\\^");
                                                    String[] secondhalfstartTime = endArray[1].split("&");
                                                    Date shortIn = sdf1.parse(shortArray[1]);
                                                    Date shortend = sdf1.parse(endArray[1]);
                                                    Date secondhalfstartTime1 = sdf1.parse(secondhalfstartTime[0]);
                                                    if ((secondhalfstartTime1.before(shortIn) || secondhalfstartTime1.equals(shortIn)) && (shortIn.before(endHours) || shortIn.equals(endHours))) {
                                                        if (userTimeOut.after(secondHalfTimeStr2)) {
                                                            cell9.setCellValue("SHL/P");
                                                            shl = shl + 1;
                                                            cell9.setCellStyle(stylegreen);
                                                        } else if (leave1[0].contains("~ AR")) {
                                                            cell9.setCellValue("AR/P");
                                                            ar = ar + 0.5;
                                                            cell9.setCellStyle(styleblue);
                                                        } else if (userTimeOut.before(secondHalfTimeStr2) || userTimeOut.equals(secondHalfTimeStr2)) {
                                                            cell9.setCellValue("SHL/A");
                                                            shla = shla + 1;
                                                            cell9.setCellStyle(stylered);
                                                        } else {
                                                            cell9.setCellValue("AB");
                                                            abcounter = abcounter + 0.5;
                                                            cell9.setCellStyle(stylered);
                                                        }
                                                    }
                                                } else {
                                                    cell9.setCellValue("AB");
                                                    abcounter = abcounter + 0.5;
                                                    cell9.setCellStyle(stylered);
                                                }
                                            } else if (null != leave1[0] && !leave1[0].contains("AB") && !leave1[0].contains("AR")) {
                                                if (leave1[0].contains("Casual Leave")) {
                                                    cl = cl + 0.5;
                                                }
                                                if (leave1[0].contains("Privilege Leave")) {
                                                    pl = pl + 0.5;
                                                }
                                                if (leave1[0].contains("Sick Leave")) {
                                                    sl = sl + 0.5;
                                                }
                                                cell9.setCellValue(" " + leave1[0]);

                                            } else if (leave1[0].contains("AB")) {
                                                cell9.setCellValue("AB");
                                                abcounter = abcounter + 0.5;
                                                cell9.setCellStyle(stylered);
                                            } else {
                                                cell9.setCellValue("AB");
                                                abcounter = abcounter + 0.5;
                                                cell9.setCellStyle(stylered);
                                            }

                                        } else if (userTimeIn != null && !secondHalf.contains("WO") && !secondHalf.contains("?")) {
                                            cell9.setCellValue("AB");
                                            abcounter = abcounter + 0.5;
                                            cell9.setCellStyle(stylered);
                                        } else if (secondHalf.contains("WO") || secondHalf.contains("?")) {
                                            cell9.setCellValue("-");
                                        }

                                    } else if (secondHalf.equals("WO")) {
                                        cell9.setCellValue("-");
                                    } else if (secondHalf.equals("AB")) {
                                        cell9.setCellValue("AB");
                                        abcounter = abcounter + 0.5;
                                        cell9.setCellStyle(stylered);
                                    }
                                    CellUtil.setAlignment(cell9, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    o++;
                                }

                                rownum = rownum + 1;
                                Row row10 = firstSheet.createRow(rownum);
                                Cell cellTitle6 = row10.createCell(0);
                                cellTitle6.setCellValue("Working Hour");
                                cellTitle6.setCellStyle(styleBold);
                                Iterator itr7 = entry.getValue().iterator();
                                while (itr7.hasNext()) {
                                    Object[] next = (Object[]) itr7.next();
                                    Cell cell10 = row10.createCell(p);
                                    String secondHalf = "" + next[1];
                                    int firstHalfVal = 0;
                                    int counter = 0;
                                    String shiftName = "";

//                                    Lunch Breck Cut Off
                                    List listPunch = employeeDatetimeDataService.readPuchDataDateWise("" + next[0], id);
                                    long lunchTime = 0;
                                    long outTime = 0;
                                    long totalDayTime = 0;
                                    long totalDayTime1 = 0;
                                    long totalTime = 0;
                                    long shiftdiffMinutes = 0;
                                    String startTime = "";
                                    String endTime = "";
                                    int d = 1;
                                    int s = 2;
                                    boolean checkLunchTime = false;
                                    SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                                    if (listPunch.size() > 0 && !secondHalf.equals("WO") && !secondHalf.equals("AB") && !secondHalf.equals("TR") && !secondHalf.equals("AR")) {
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
                                        }

                                        String[] userTimeInStr = secondHalf.split("`");
                                        String[] userTimeInStr1 = userTimeInStr[1].split("!");
                                        String[] userTimeOutStr = secondHalf.split("!");
                                        String[] userTimeOutStr1 = userTimeOutStr[1].split("@");
                                        Date userTimeIn = sdf1.parse(userTimeInStr1[0]);
                                        Date userTimeOut = sdf1.parse(userTimeOutStr1[0]);
                                        Date userTimeOut1 = sdf1.parse("23:59");
                                        String[] startHoursStr = secondHalf.split("%");
                                        String[] firstStartHoursStr = startHoursStr[1].split("\\+");
                                        String[] endHoursStr = secondHalf.split("&");
                                        Date firstStartHours = sdf1.parse(firstStartHoursStr[1]);
                                        Calendar cal1 = Calendar.getInstance();
                                        cal1.setTime(firstStartHours);
                                        cal1.add(Calendar.MINUTE, -earlyMinute);
                                        String newTime1 = sdf1.format(cal1.getTime());
                                        Date flexibleInTime = sdf1.parse(newTime1);
                                        Date endHours = sdf1.parse(endHoursStr[1]);
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
                                            cell10.setCellValue(workingHours);

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
                                            cell10.setCellValue(workingHours);
                                        }

                                    } else {
                                        cell10.setCellValue("-");
                                    }

//                                    Lunch Breck Cut Off
                                    CellUtil.setAlignment(cell10, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    p++;
                                }

                            }
                            rownum = rownum + 1;
                            Row dayCount1 = firstSheet.createRow(rownum);
                            rownum = rownum + 1;
                            Row dayCount = firstSheet.createRow(rownum);
                            Cell dayCounrCell = dayCount.createCell(0);
                            dayCounrCell.setCellValue("Day Count");
                            dayCounrCell.setCellStyle(styleBold);

                            rownum = rownum + 1;
                            Row row13 = firstSheet.createRow(rownum);
                            for (int y = 1; y < 10;) {
                                if (prcounter != 0) {
                                    Cell cell12 = row13.createCell(y);
                                    cell12.setCellValue("PR");
                                    cell12.setCellStyle(stylegreen);
                                    CellUtil.setAlignment(cell12, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    y++;
                                }
                                if (abcounter != 0) {
                                    Cell cell13 = row13.createCell(y);
                                    cell13.setCellValue("AB");
                                    cell13.setCellStyle(stylered);
                                    CellUtil.setAlignment(cell13, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    y++;
                                }
                                if (shl != 0) {
                                    Cell cell14 = row13.createCell(y);
                                    cell14.setCellValue("SHL/P");
                                    cell14.setCellStyle(stylegreen);
                                    CellUtil.setAlignment(cell14, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    y++;
                                }
                                if (shla != 0) {
                                    Cell cell15 = row13.createCell(y);
                                    cell15.setCellValue("SHL/A");
                                    cell15.setCellStyle(stylered);
                                    CellUtil.setAlignment(cell15, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    y++;
                                }
                                if (cl != 0) {
                                    Cell cell16 = row13.createCell(y);
                                    cell16.setCellValue("CL");
                                    cell16.setCellStyle(styleBold);
                                    CellUtil.setAlignment(cell16, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    y++;
                                }
                                if (sl != 0) {
                                    Cell cell17 = row13.createCell(y);
                                    cell17.setCellValue("SL");
                                    cell17.setCellStyle(styleBold);
                                    CellUtil.setAlignment(cell17, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    y++;
                                }
                                if (pl != 0) {
                                    Cell cell18 = row13.createCell(y);
                                    cell18.setCellValue("PL");
                                    cell18.setCellStyle(styleBold);
                                    CellUtil.setAlignment(cell18, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    y++;
                                }
                                if (holiday != 0) {
                                    Cell cell19 = row13.createCell(y);
                                    cell19.setCellValue("HOLIDAY");
                                    cell19.setCellStyle(styleBold);
                                    CellUtil.setAlignment(cell19, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    y++;
                                }
                                if (ar != 0) {
                                    Cell cell20 = row13.createCell(y);
                                    cell20.setCellValue("AR/P");
                                    cell20.setCellStyle(styleblue);
                                    CellUtil.setAlignment(cell20, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    y++;
                                }
                                if (wo != 0) {
                                    Cell cell21 = row13.createCell(y);
                                    cell21.setCellValue("WO");
                                    cell21.setCellStyle(styleBold);
                                    CellUtil.setAlignment(cell21, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    y++;
                                }
                                if (tr != 0) {
                                    Cell cell22 = row13.createCell(y);
                                    cell22.setCellValue("TR");
                                    cell22.setCellStyle(styleblue);
                                    CellUtil.setAlignment(cell22, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                }
                                break;
                            }

                            rownum = rownum + 1;
                            Row row12 = firstSheet.createRow(rownum);
                            for (int x = 1; x < 10;) {
                                if (prcounter != 0) {
                                    Cell cell12 = row12.createCell(x);
                                    cell12.setCellType(Cell.CELL_TYPE_NUMERIC);
                                    double newshl = shl / 2;
                                    double nepr = prcounter - newshl;
                                    cell12.setCellValue(nepr);
                                    CellUtil.setAlignment(cell12, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    x++;
                                }
                                if (abcounter != 0) {
                                    Cell cell13 = row12.createCell(x);
                                    cell13.setCellType(Cell.CELL_TYPE_NUMERIC);
                                    cell13.setCellValue(abcounter);
                                    CellUtil.setAlignment(cell13, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    x++;
                                }
                                if (shl != 0) {
                                    Cell cell14 = row12.createCell(x);
                                    cell14.setCellType(Cell.CELL_TYPE_NUMERIC);
                                    cell14.setCellValue(shl);
                                    CellUtil.setAlignment(cell14, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    x++;
                                }
                                if (shla != 0) {
                                    Cell cell15 = row12.createCell(x);
                                    cell15.setCellType(Cell.CELL_TYPE_NUMERIC);
                                    cell15.setCellValue(shla);
                                    CellUtil.setAlignment(cell15, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    x++;
                                }
                                if (cl != 0) {
                                    Cell cell16 = row12.createCell(x);
                                    cell16.setCellType(Cell.CELL_TYPE_NUMERIC);
                                    cell16.setCellValue(cl);
                                    CellUtil.setAlignment(cell16, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    x++;
                                }
                                if (sl != 0) {
                                    Cell cell17 = row12.createCell(x);
                                    cell17.setCellType(Cell.CELL_TYPE_NUMERIC);
                                    cell17.setCellValue(sl);
                                    CellUtil.setAlignment(cell17, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    x++;
                                }
                                if (pl != 0) {
                                    Cell cell18 = row12.createCell(x);
                                    cell18.setCellType(Cell.CELL_TYPE_NUMERIC);
                                    cell18.setCellValue(pl);
                                    CellUtil.setAlignment(cell18, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    x++;
                                }
                                if (holiday != 0) {
                                    Cell cell19 = row12.createCell(x);
                                    cell19.setCellType(Cell.CELL_TYPE_NUMERIC);
                                    cell19.setCellValue(holiday);
                                    CellUtil.setAlignment(cell19, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    x++;
                                }
                                if (ar != 0) {
                                    Cell cell20 = row12.createCell(x);
                                    cell20.setCellType(Cell.CELL_TYPE_NUMERIC);
                                    cell20.setCellValue(ar);
                                    CellUtil.setAlignment(cell20, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    x++;
                                }
                                if (wo != 0) {
                                    Cell cell21 = row12.createCell(x);
                                    cell21.setCellType(Cell.CELL_TYPE_NUMERIC);
                                    cell21.setCellValue(wo);
                                    CellUtil.setAlignment(cell21, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    x++;
                                }
                                if (tr != 0) {
                                    Cell cell22 = row12.createCell(x);
                                    cell22.setCellType(Cell.CELL_TYPE_NUMERIC);
                                    cell22.setCellValue(tr);
                                    CellUtil.setAlignment(cell22, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                }
                                break;
                            }

                        } else {
                            rownum = rownum + 1;
                            Row row4 = firstSheet.createRow(rownum);
                            Cell cell4 = row4.createCell(0);
                            cell4.setCellValue("");
                            rownum = rownum + 1;

                            Row row1 = firstSheet.createRow(rownum);
                            Cell cell1 = row1.createCell(0);
                            cell1.setCellValue("Employee Daily Attendance Information");
                            cell1.setCellStyle(styleBold);
                            double prcounter = 0;
                            double abcounter = 0;
                            double wo = 0;
                            double shl = 0;
                            double shla = 0;
                            double cl = 0;
                            double sl = 0;
                            double pl = 0;
                            double holiday = 0;
                            double tr = 0;
                            double ar = 0;
                            //                int zz = 0;
                            for (Map.Entry<Integer, List<?>> entry : map.entrySet()) {
                                rownum = rownum + 1;
                                Row row33 = firstSheet.createRow(rownum);
                                rownum = rownum + 1;
                                Row row3 = firstSheet.createRow(rownum);

                                Iterator itr1 = entry.getValue().iterator();
                                int i = 1;
                                int k = 1;
                                int l = 1;
                                int m = 1;
                                int n = 1;
                                int o = 1;
                                SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm");
                                Cell cellTitle = row3.createCell(0);
                                cellTitle.setCellValue("Date");
                                cellTitle.setCellStyle(styleBold);

                                while (itr1.hasNext()) {
                                    Object[] next = (Object[]) itr1.next();
                                    Cell cell3 = row3.createCell(i);
                                    cell3.setCellValue("" + next[0]);
                                    CellUtil.setAlignment(cell3, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    i++;
                                }
                                rownum = rownum + 1;
                                Row row5 = firstSheet.createRow(rownum);
                                Iterator itr2 = entry.getValue().iterator();
                                Cell cellTitle1 = row5.createCell(0);
                                cellTitle1.setCellValue("Shift Name");
                                cellTitle1.setCellStyle(styleBold);
                                while (itr2.hasNext()) {
                                    Object[] next = (Object[]) itr2.next();
                                    Cell cell5 = row5.createCell(l);
                                    String shiftName = "" + next[1];
                                    if (shiftName.contains("#")) {
                                        String[] shiftName1 = shiftName.split("#");
                                        String[] shiftName2 = shiftName1[1].split("\\$");
                                        cell5.setCellValue("" + shiftName2[0]);
                                    } else if (!shiftName.contains("`")) {
                                        cell5.setCellValue("-");
                                    }

                                    CellUtil.setAlignment(cell5, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    l++;

                                }
                                rownum = rownum + 1;
                                Row row6 = firstSheet.createRow(rownum);
                                Iterator itr3 = entry.getValue().iterator();
                                Cell cellTitle2 = row6.createCell(0);
                                cellTitle2.setCellValue("First In");
                                cellTitle2.setCellStyle(styleBold);
                                while (itr3.hasNext()) {
                                    Object[] next = (Object[]) itr3.next();
                                    Cell cell6 = row6.createCell(k);
                                    String firstIn = "" + next[1];
                                    if (firstIn.contains("`") && !firstIn.contains("?")) {
                                        String[] firstIn1 = firstIn.split("`");
                                        String[] firstIn12 = firstIn1[1].split("!");
                                        cell6.setCellValue("" + firstIn12[0]);
                                    } else if (!firstIn.contains("`") && !firstIn.contains("?") && !firstIn.contains("AB") && !firstIn.equals("WO") && !firstIn.contains("TR") && !firstIn.contains("AR")) {
                                        if (firstIn.contains("Casual Leave")) {
                                            cl = cl + 1;
                                        }
                                        if (firstIn.contains("Privilege Leave")) {
                                            pl = pl + 1;
                                        }
                                        if (firstIn.contains("Sick Leave")) {
                                            sl = sl + 1;
                                        }
                                        cell6.setCellValue("" + next[1]);
                                    } else if (!firstIn.contains("`") && firstIn.contains("?") && !firstIn.contains("AB") && !firstIn.equals("WO") && !firstIn.contains("TR") && !firstIn.contains("AR")) {
                                        String[] hostring = firstIn.split("\\?");
                                        cell6.setCellValue("" + hostring[0]);
                                        holiday = holiday + 1;
                                    } else if (!firstIn.contains("`") && firstIn.contains("?") && firstIn.contains("AB") && !firstIn.equals("WO") && !firstIn.contains("TR") && !firstIn.contains("AR")) {
                                        cell6.setCellValue("-");
                                    } else if (firstIn.equals("WO")) {
                                        cell6.setCellValue(firstIn);
                                        wo = wo + 1;
                                    } else if (firstIn.equals("TR")) {
                                        cell6.setCellValue(firstIn);
                                        tr = tr + 1;
                                        cell6.setCellStyle(styleblue);
                                    }
                                    CellUtil.setAlignment(cell6, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    k++;
                                }

                                rownum = rownum + 1;
                                Row row7 = firstSheet.createRow(rownum);
                                Cell cellTitle3 = row7.createCell(0);
                                cellTitle3.setCellValue("Last Out");
                                cellTitle3.setCellStyle(styleBold);
                                Iterator itr4 = entry.getValue().iterator();
                                while (itr4.hasNext()) {
                                    Object[] next = (Object[]) itr4.next();
                                    Cell cell7 = row7.createCell(m);
                                    String lastOut = "" + next[1];
                                    if (lastOut.contains("!")) {
                                        String[] lastOut1 = lastOut.split("`");
                                        String[] lastOut2 = lastOut1[1].split("!");
                                        String[] lastOut3 = lastOut.split("!");
                                        String[] lastOut4 = lastOut3[1].split("@");
                                        Date lout = sdf1.parse(lastOut4[0]);
                                        Date fin = sdf1.parse(lastOut2[0]);
                                        if (lout.equals(fin)) {
                                            cell7.setCellValue("-");
                                        } else {
                                            cell7.setCellValue("" + lastOut4[0]);
                                        }

                                    } else if (lastOut.contains("@")) {
                                        cell7.setCellValue("-");
                                    }
                                    CellUtil.setAlignment(cell7, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    m++;
                                }
                                rownum = rownum + 1;
                                Row row8 = firstSheet.createRow(rownum);
                                Cell cellTitle4 = row8.createCell(0);
                                cellTitle4.setCellValue("First Half");
                                cellTitle4.setCellStyle(styleBold);
                                Iterator itr5 = entry.getValue().iterator();
                                int firstCounter = 0;
                                while (itr5.hasNext()) {
                                    Object[] next = (Object[]) itr5.next();
                                    Cell cell8 = row8.createCell(n);
                                    String firstHalf = "" + next[1];
                                    int firstHalfVal = 0;
                                    int counter = 0;

                                    if (firstHalf.contains("fullday")) {
                                        cell8.setCellValue("PR");
                                        prcounter = prcounter + 0.5;
                                        cell8.setCellStyle(stylegreen);

                                    } else if (!firstHalf.contains("fullday") && !firstHalf.equals("WO") && !firstHalf.equals("TR") && !firstHalf.equals("AR") && !firstHalf.equals("AB") && !firstHalf.contains("?")
                                            && !firstHalf.equals("Casual Leave") && !firstHalf.equals("Short Leave") && !firstHalf.equals("C Off Leave") && !firstHalf.equals("Short Leave") && !firstHalf.equals("Privilege Leave") && !firstHalf.equals("Sick Leave")
                                            && !firstHalf.equals("Paternity Leave") && !firstHalf.equals("Maternity Leave") && !firstHalf.equals("Leave Without Pay")) {
                                        String[] leave = firstHalf.split("@");
                                        String[] leave1 = leave[1].split("#");
                                        String[] userTimeInStr = firstHalf.split("`");
                                        String[] userTimeInStr1 = userTimeInStr[1].split("!");
                                        String[] userTimeOutStr = firstHalf.split("!");
                                        String[] userTimeOutStr1 = userTimeOutStr[1].split("@");
                                        String[] LateHoursStr = firstHalf.split("\\$");
                                        String[] LateHoursStr1 = LateHoursStr[1].split("%");
                                        String[] endHoursStr = firstHalf.split("%");
                                        String[] endHoursStr1 = endHoursStr[1].split("\\^");
                                        String[] firstStartHoursStr = endHoursStr[1].split("\\+");
                                        Date userTimeIn = sdf1.parse(userTimeInStr1[0]);
                                        Date userTimeOut = sdf1.parse(userTimeOutStr1[0]);
                                        Date LateHours = sdf1.parse(LateHoursStr1[0]);
                                        Date endHours = sdf1.parse(endHoursStr1[0]);
                                        Date firstStartHours = sdf1.parse(firstStartHoursStr[1]);
                                        if (userTimeIn != null) {
                                            if ((userTimeIn.before(firstStartHours) || userTimeIn.equals(firstStartHours)) && (userTimeOut.after(endHours) || userTimeOut.equals(endHours))) {
                                                cell8.setCellValue("PR");
                                                prcounter = prcounter + 0.5;
                                                cell8.setCellStyle(stylegreen);
                                            } else if (leave1[0] != null && !leave1[0].contains("Short Leave")) {
                                                if ((userTimeIn.before(LateHours) || userTimeIn.equals(LateHours)) && (userTimeOut.after(endHours) || userTimeOut.equals(endHours)) && firstCounter <= 31) {
                                                    cell8.setCellValue("PR");
                                                    prcounter = prcounter + 0.5;
                                                    firstCounter = firstCounter + 1;
                                                    cell8.setCellStyle(stylegreen);
                                                } else if (leave1[0].contains("AB")) {
                                                    cell8.setCellValue("AB");
                                                    abcounter = abcounter + 0.5;
                                                    cell8.setCellStyle(stylered);
                                                } else if (leave1[0].contains("AR")) {
                                                    cell8.setCellValue("AR/P");
                                                    ar = ar + 0.5;
                                                    cell8.setCellStyle(styleblue);
                                                }

                                            } else if (null != leave1[0] && leave1[0].contains("Short Leave")) {
                                                if (firstHalf.contains("*")) {
                                                    String[] shortArray = firstHalf.split("\\*");
                                                    String[] endArray = shortArray[1].split("\\-");
                                                    String[] startTime = endArray[1].split("\\+");
                                                    Date shortIn = sdf1.parse(shortArray[1]);
                                                    Date shortend = sdf1.parse(endArray[1]);
                                                    Date startTime1 = sdf1.parse(startTime[1]);
                                                    if (shortIn.before(endHours)) {
                                                        cell8.setCellValue("SHL/P");
                                                        cell8.setCellStyle(stylegreen);
                                                        shl = shl + 1;
                                                    } else if (leave1[0].contains("~ AR")) {
                                                        cell8.setCellValue("AR/P");
                                                        ar = ar + 0.5;
                                                        cell8.setCellStyle(styleblue);
                                                    } else if (userTimeIn.after(endHours)) {
                                                        cell8.setCellValue("SHL/A");
                                                        shla = shla + 1;
                                                        cell8.setCellStyle(stylered);
                                                    } else if ((userTimeIn.before(LateHours) || userTimeIn.equals(LateHours)) && (userTimeOut.after(endHours) || userTimeOut.equals(endHours)) && firstCounter <= 31) {
                                                        cell8.setCellValue("PR");
                                                        prcounter = prcounter + 0.5;
                                                        firstCounter = firstCounter + 1;
                                                        cell8.setCellStyle(stylegreen);
                                                    } else {
                                                        cell8.setCellValue("AB");
                                                        abcounter = abcounter + 0.5;
                                                        cell8.setCellStyle(stylered);
                                                    }
                                                } else {
                                                    cell8.setCellValue("AB");
                                                    abcounter = abcounter + 0.5;
                                                    cell8.setCellStyle(stylered);
                                                }
                                            } else if (null != leave1[0] && !leave1[0].contains("AB")) {
                                                if (leave1[0].contains("Casual Leave")) {
                                                    cl = cl + 0.5;
                                                }
                                                if (leave1[0].contains("Privilege Leave")) {
                                                    pl = pl + 0.5;
                                                }
                                                if (leave1[0].contains("Sick Leave")) {
                                                    sl = sl + 0.5;
                                                }
                                                cell8.setCellValue(" " + leave1[0]);

                                            } else if (leave1[0].contains("AB")) {
                                                cell8.setCellValue("-");
                                            } else {
                                                cell8.setCellValue("AB");
                                                abcounter = abcounter + 0.5;
                                                cell8.setCellStyle(stylered);
                                            }

                                        } else if (userTimeIn != null && !firstHalf.contains("WO") && !firstHalf.contains("?")) {
                                            cell8.setCellValue("AB");
                                            abcounter = abcounter + 0.5;
                                            cell8.setCellStyle(stylered);
                                        } else if (firstHalf.contains("WO") || firstHalf.contains("?")) {
                                            cell8.setCellValue("-");
                                        }

                                    } else if (firstHalf.equals("WO")) {
                                        cell8.setCellValue("");
                                    } else if (firstHalf.contains("AR")) {
                                        cell8.setCellValue("AR/P");
                                        ar = ar + 0.5;
                                        cell8.setCellStyle(styleblue);
                                    } else if (firstHalf.equals("AB")) {
                                        cell8.setCellValue("AB");
                                        abcounter = abcounter + 0.5;
                                        cell8.setCellStyle(stylered);
                                    } else if (firstHalf.equals("Short Leave")) {
                                        cell8.setCellValue("SHL/A");
                                        shla = shla + 1;
                                        cell8.setCellStyle(stylered);
                                    }
                                    CellUtil.setAlignment(cell8, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    n++;
                                }

                                rownum = rownum + 1;
                                Row row9 = firstSheet.createRow(rownum);
                                Cell cellTitle5 = row9.createCell(0);
                                cellTitle5.setCellValue("Second Half");
                                cellTitle5.setCellStyle(styleBold);
                                int weekNameCounter = 0;
                                boolean satWeekOff = false;
                                Iterator itr6 = entry.getValue().iterator();
                                while (itr6.hasNext()) {
                                    Object[] next = (Object[]) itr6.next();
                                    Cell cell9 = row9.createCell(o);
                                    String secondHalf = "" + next[1];
                                    int firstHalfVal = 0;
                                    int counter = 0;
                                    String shiftName = "";
                                    if (secondHalf.contains(" # ")) {
                                        String[] string1 = secondHalf.split("#");
                                        String[] string2 = string1[1].split("\\$");
                                        shiftName = string2[0].trim();

                                    }

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

                                    if (satWeekOff == true && (zydexLocationMaster.getZydexLocation().equals("HO") || zydexLocationMaster.getZydexLocation().equals("R&D"))) {
                                        cell9.setCellValue("WO");
                                        wo = wo + 0.5;
                                    } else if (secondHalf.contains("fullday")) {
                                        cell9.setCellValue("PR");
                                        prcounter = prcounter + 0.5;
                                        cell9.setCellStyle(stylegreen);

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

                                        Date userTimeIn = sdf1.parse(userTimeInStr1[0]);
                                        Date userTimeOut = sdf1.parse(userTimeOutStr1[0]);

                                        String[] getInHours = userTimeInStr1[0].split(":");
                                        String[] getOutHours = userTimeOutStr1[0].split(":");
                                        String abc = getInHours[0].trim();
                                        String xyz = getOutHours[0].trim();
                                        int i11 = Integer.parseInt(abc) - Integer.parseInt(xyz);
                                        int totalDuration = 24 - i11;
                                        String totalDuration2 = getOutHours[0];
                                        Date endHours = sdf1.parse(endHoursStr[1]);
                                        Date secondHalfTimeStr2 = sdf1.parse(secondHalfTimeStr1[0]);

                                        if (userTimeIn != null) {
                                            if ((userTimeIn.before(secondHalfTimeStr2) || userTimeIn.equals(secondHalfTimeStr2)) && (userTimeOut.after(endHours) || userTimeOut.equals(endHours))) {
                                                cell9.setCellValue("PR");
                                                prcounter = prcounter + 0.5;
                                                cell9.setCellStyle(stylegreen);
                                            } else if (shiftName.contains("Night") && (userTimeOut.after(endHours) || userTimeOut.equals(endHours))) {
                                                cell9.setCellValue("PR");
                                                prcounter = prcounter + 0.5;
                                                cell9.setCellStyle(stylegreen);
                                            } else if (null != leave1[0] && leave1[0].contains("Short Leave")) {
                                                if (secondHalf.contains("*")) {
                                                    String[] shortArray = secondHalf.split("\\*");
                                                    String[] endArray = secondHalf.split("\\^");
                                                    String[] secondhalfstartTime = endArray[1].split("&");
                                                    Date shortIn = sdf1.parse(shortArray[1]);
                                                    Date shortend = sdf1.parse(endArray[1]);
                                                    Date secondhalfstartTime1 = sdf1.parse(secondhalfstartTime[0]);
                                                    if ((secondhalfstartTime1.before(shortIn) || secondhalfstartTime1.equals(shortIn)) && (shortIn.before(endHours) || shortIn.equals(endHours))) {
                                                        if (userTimeOut.after(secondHalfTimeStr2)) {
                                                            cell9.setCellValue("SHL/P");
                                                            shl = shl + 1;
                                                            cell9.setCellStyle(stylegreen);
                                                        } else if (leave1[0].contains("~ AR")) {
                                                            cell9.setCellValue("AR/P");
                                                            ar = ar + 0.5;
                                                            cell9.setCellStyle(styleblue);
                                                        } else if (userTimeOut.before(secondHalfTimeStr2) || userTimeOut.equals(secondHalfTimeStr2)) {
                                                            cell9.setCellValue("SHL/A");
                                                            shla = shla + 1;
                                                            cell9.setCellStyle(stylered);
                                                        } else {
                                                            cell9.setCellValue("AB");
                                                            abcounter = abcounter + 0.5;
                                                            cell9.setCellStyle(stylered);
                                                        }
                                                    }
                                                } else {
                                                    cell9.setCellValue("AB");
                                                    abcounter = abcounter + 0.5;
                                                    cell9.setCellStyle(stylered);
                                                }
                                            } else if (null != leave1[0] && !leave1[0].contains("AB") && !leave1[0].contains("AR")) {
                                                if (leave1[0].contains("Casual Leave")) {
                                                    cl = cl + 0.5;
                                                }
                                                if (leave1[0].contains("Privilege Leave")) {
                                                    pl = pl + 0.5;
                                                }
                                                if (leave1[0].contains("Sick Leave")) {
                                                    sl = sl + 0.5;
                                                }
                                                cell9.setCellValue(" " + leave1[0]);

                                            } else if (leave1[0].contains("AR")) {
                                                cell9.setCellValue("AR/P");
                                                ar = ar + 0.5;
                                                cell9.setCellStyle(styleblue);
                                            } else if (leave1[0].contains("AB")) {
                                                cell9.setCellValue("AB");
                                                abcounter = abcounter + 0.5;
                                                cell9.setCellStyle(stylered);
                                            } else {
                                                cell9.setCellValue("AB");
                                                abcounter = abcounter + 0.5;
                                                cell9.setCellStyle(stylered);
                                            }

                                        } else if (userTimeIn != null && !secondHalf.contains("WO") && !secondHalf.contains("?")) {
                                            cell9.setCellValue("AB");
                                            abcounter = abcounter + 0.5;
                                            cell9.setCellStyle(stylered);
                                        } else if (secondHalf.contains("WO") || secondHalf.contains("?")) {
                                            cell9.setCellValue("-");
                                        }

                                    } else if (secondHalf.equals("WO")) {
                                        cell9.setCellValue("-");
                                    } else if (secondHalf.contains("AR")) {
                                        cell9.setCellValue("AR/P");
                                        ar = ar + 0.5;
                                        cell9.setCellStyle(styleblue);
                                    } else if (secondHalf.equals("AB")) {
                                        cell9.setCellValue("AB");
                                        abcounter = abcounter + 0.5;
                                        cell9.setCellStyle(stylered);
                                    }
                                    CellUtil.setAlignment(cell9, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    o++;
                                }

                            }
                            rownum = rownum + 1;
                            Row dayCount1 = firstSheet.createRow(rownum);
                            rownum = rownum + 1;
                            Row dayCount = firstSheet.createRow(rownum);
                            Cell dayCounrCell = dayCount.createCell(0);
                            dayCounrCell.setCellValue("Day Count");
                            dayCounrCell.setCellStyle(styleBold);

                            rownum = rownum + 1;
                            Row row13 = firstSheet.createRow(rownum);
                            for (int y = 1; y < 10;) {
                                if (prcounter != 0) {
                                    Cell cell12 = row13.createCell(y);
                                    cell12.setCellValue("PR");
                                    cell12.setCellStyle(stylegreen);
                                    CellUtil.setAlignment(cell12, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    y++;
                                }
                                if (abcounter != 0) {
                                    Cell cell13 = row13.createCell(y);
                                    cell13.setCellValue("AB");
                                    cell13.setCellStyle(stylered);
                                    CellUtil.setAlignment(cell13, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    y++;
                                }
                                if (shl != 0) {
                                    Cell cell14 = row13.createCell(y);
                                    cell14.setCellValue("SHL/P");
                                    cell14.setCellStyle(stylegreen);
                                    CellUtil.setAlignment(cell14, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    y++;
                                }
                                if (shla != 0) {
                                    Cell cell15 = row13.createCell(y);
                                    cell15.setCellValue("SHL/A");
                                    cell15.setCellStyle(stylered);
                                    CellUtil.setAlignment(cell15, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    y++;
                                }
                                if (cl != 0) {
                                    Cell cell16 = row13.createCell(y);
                                    cell16.setCellValue("CL");
                                    cell16.setCellStyle(styleBold);
                                    CellUtil.setAlignment(cell16, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    y++;
                                }
                                if (sl != 0) {
                                    Cell cell17 = row13.createCell(y);
                                    cell17.setCellValue("SL");
                                    cell17.setCellStyle(styleBold);
                                    CellUtil.setAlignment(cell17, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    y++;
                                }
                                if (pl != 0) {
                                    Cell cell18 = row13.createCell(y);
                                    cell18.setCellValue("PL");
                                    cell18.setCellStyle(styleBold);
                                    CellUtil.setAlignment(cell18, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    y++;
                                }
                                if (holiday != 0) {
                                    Cell cell19 = row13.createCell(y);
                                    cell19.setCellValue("HOLIDAY");
                                    cell19.setCellStyle(styleBold);
                                    CellUtil.setAlignment(cell19, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    y++;
                                }
                                if (ar != 0) {
                                    Cell cell20 = row13.createCell(y);
                                    cell20.setCellValue("AR/P");
                                    cell20.setCellStyle(styleblue);
                                    CellUtil.setAlignment(cell20, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    y++;
                                }
                                if (wo != 0) {
                                    Cell cell21 = row13.createCell(y);
                                    cell21.setCellValue("WO");
                                    cell21.setCellStyle(styleBold);
                                    CellUtil.setAlignment(cell21, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    y++;
                                }
                                if (tr != 0) {
                                    Cell cell22 = row13.createCell(y);
                                    cell22.setCellValue("TR");
                                    cell22.setCellStyle(styleblue);
                                    CellUtil.setAlignment(cell22, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                }
                                break;
                            }

                            rownum = rownum + 1;
                            Row row12 = firstSheet.createRow(rownum);
                            for (int x = 1; x < 10;) {
                                if (prcounter != 0) {
                                    Cell cell12 = row12.createCell(x);
                                    cell12.setCellType(Cell.CELL_TYPE_NUMERIC);
                                    double newshl = shl / 2;
                                    double nepr = prcounter - newshl;
                                    cell12.setCellValue(nepr);
                                    CellUtil.setAlignment(cell12, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    x++;
                                }
                                if (abcounter != 0) {
                                    Cell cell13 = row12.createCell(x);
                                    cell13.setCellType(Cell.CELL_TYPE_NUMERIC);
                                    cell13.setCellValue(abcounter);
                                    CellUtil.setAlignment(cell13, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    x++;
                                }
                                if (shl != 0) {
                                    Cell cell14 = row12.createCell(x);
                                    cell14.setCellType(Cell.CELL_TYPE_NUMERIC);
                                    cell14.setCellValue(shl);
                                    CellUtil.setAlignment(cell14, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    x++;
                                }
                                if (shla != 0) {
                                    Cell cell15 = row12.createCell(x);
                                    cell15.setCellType(Cell.CELL_TYPE_NUMERIC);
                                    cell15.setCellValue(shla);
                                    CellUtil.setAlignment(cell15, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    x++;
                                }
                                if (cl != 0) {
                                    Cell cell16 = row12.createCell(x);
                                    cell16.setCellType(Cell.CELL_TYPE_NUMERIC);
                                    cell16.setCellValue(cl);
                                    CellUtil.setAlignment(cell16, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    x++;
                                }
                                if (sl != 0) {
                                    Cell cell17 = row12.createCell(x);
                                    cell17.setCellType(Cell.CELL_TYPE_NUMERIC);
                                    cell17.setCellValue(sl);
                                    CellUtil.setAlignment(cell17, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    x++;
                                }
                                if (pl != 0) {
                                    Cell cell18 = row12.createCell(x);
                                    cell18.setCellType(Cell.CELL_TYPE_NUMERIC);
                                    cell18.setCellValue(pl);
                                    CellUtil.setAlignment(cell18, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    x++;
                                }
                                if (holiday != 0) {
                                    Cell cell19 = row12.createCell(x);
                                    cell19.setCellType(Cell.CELL_TYPE_NUMERIC);
                                    cell19.setCellValue(holiday);
                                    CellUtil.setAlignment(cell19, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    x++;
                                }
                                if (ar != 0) {
                                    Cell cell20 = row12.createCell(x);
                                    cell20.setCellType(Cell.CELL_TYPE_NUMERIC);
                                    cell20.setCellValue(ar);
                                    CellUtil.setAlignment(cell20, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    x++;
                                }
                                if (wo != 0) {
                                    Cell cell21 = row12.createCell(x);
                                    cell21.setCellType(Cell.CELL_TYPE_NUMERIC);
                                    cell21.setCellValue(wo);
                                    CellUtil.setAlignment(cell21, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    x++;
                                }
                                if (tr != 0) {
                                    Cell cell22 = row12.createCell(x);
                                    cell22.setCellType(Cell.CELL_TYPE_NUMERIC);
                                    cell22.setCellValue(tr);
                                    CellUtil.setAlignment(cell22, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                }
                                break;
                            }
                        }
                    }

                }

                rownum++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }

        String appPath = request.getServletContext().getRealPath("");
        try {
            String filePath = appPath + File.separator + "StorageYard" + File.separator
                    + "Other" + File.separator + "UserDoc" + File.separator
                    + "EmployeeShiftData" + File.separator + "EmployeeAdvanceSearch.xls";
            FileOutputStream fos = new FileOutputStream(new File(filePath));
            HSSFCellStyle hsfstyle = firstFWorkbook.createCellStyle();
            hsfstyle.setBorderBottom((short) 1);
            hsfstyle.setFillBackgroundColor((short) 245);
            firstFWorkbook.write(fos);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String filePath = File.separator + "StorageYard" + File.separator
                + "Other" + File.separator + "UserDoc" + File.separator
                + "EmployeeShiftData" + File.separator + "EmployeeAdvanceSearch.xls";

        appPath = request.getServletContext().getRealPath("");

        String fullPath = appPath + filePath;

        request.setAttribute("filePath", fullPath);

        DownloadFile downloadFile = new DownloadFile();
        downloadFile.doDownload(request, response);
        mv = employeeDataSearch(request, response);
        return mv;
    }

    public ModelAndView employeeAttendanceForGavasat(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeShiftData employeeShiftData = new EmployeeShiftData();
        EmployeeAdvanceSearch employeeAdvanceSearch = new EmployeeAdvanceSearch();
        selectEmployeeForGavasat(request, response);
        mv.getModelMap().put("employeeAdvanceSearch", employeeAdvanceSearch);
        mv.setViewName("Shift/EmployeeOrDateWiseShiftSearchForGavasatPlant");

        return mv;
    }

    public ModelAndView employeeAttendanceForGavasatSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = new EmployeeMaster();

        String empId = request.getParameter("employeeMasterId");
        String startDate = request.getParameter("inDateTime");
        String endDate = request.getParameter("outDateTime");
//         == == == == == == == == == == = Luna Plant Id Is 8==============================
        String zydexLocationId = "8";
//        =====================Luna Plant Id Is 8==============================
        EmployeeAdvanceSearch employeeAdvanceSearch = new EmployeeAdvanceSearch();
        bind(request, employeeAdvanceSearch);
        if (null != empId && !empId.equals("")) {
            employeeAdvanceSearch.setId(empId);
        } else {
            employeeAdvanceSearch.setZydexLocationId(zydexLocationId);

        }

        int rownum = 0;
        HSSFWorkbook firstFWorkbook = new HSSFWorkbook();
        HSSFSheet firstSheet = firstFWorkbook.createSheet("FIRST SHEET");
        Row headerRow = firstSheet.createRow(rownum);
        headerRow.setHeightInPoints(40);
        HSSFFont redFont = firstFWorkbook.createFont();
        redFont.setColor(HSSFColor.RED.index);
        HSSFCellStyle stylered = firstFWorkbook.createCellStyle();
        stylered.setFont(redFont);

        HSSFFont greenFont = firstFWorkbook.createFont();
        greenFont.setColor(HSSFColor.GREEN.index);
        HSSFCellStyle stylegreen = firstFWorkbook.createCellStyle();
        stylegreen.setFont(greenFont);

        HSSFFont blueFont = firstFWorkbook.createFont();
        blueFont.setColor(HSSFColor.BLUE.index);
        HSSFCellStyle styleblue = firstFWorkbook.createCellStyle();
        styleblue.setFont(blueFont);

        HSSFFont boldFont = firstFWorkbook.createFont();
        boldFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
        HSSFCellStyle styleBold = firstFWorkbook.createCellStyle();
        styleBold.setFont(boldFont);
        employeeAdvanceSearch.setEmployeeId(Boolean.TRUE);
        employeeAdvanceSearch.setEmployeeName(Boolean.TRUE);
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

        List<String> headerRow1 = new ArrayList();
        if (employeeAdvanceSearch.getEmployeeId() == true) {
            headerRow1.add("Employee ID");

        }
        if (employeeAdvanceSearch.getEmployeeName() == true) {
            headerRow1.add("Employee Name");
        }

        List<List<String>> recordToAdd = new ArrayList();
        List<List<String>> recordToAdd1 = new ArrayList();
        EmployeeShiftData employeeShiftData = new EmployeeShiftData();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calForFlexiNotSupport1 = Calendar.getInstance();
        Calendar calForFlexiNotSupport2 = Calendar.getInstance();
        if (!startDate.equals("")) {
            Date notflexibleSupportDate = sdf.parse(startDate);
            String FixedFlexibleDate = "01/04/2016";
            Date notflexibleSupportDate1 = sdf.parse(FixedFlexibleDate);
            calForFlexiNotSupport1.setTime(notflexibleSupportDate);
            calForFlexiNotSupport2.setTime(notflexibleSupportDate1);
        }

        if (null != empId && !empId.equals("")) {
            employeeShiftData.setId(Integer.parseInt(empId));
        }
        if (null != startDate && !startDate.equals("")) {
            Date sDate = sdf.parse(startDate);
            employeeShiftData.setInDateTime(new SimpleDateFormat("yyyy-MM-dd").format(sDate));
        }
        if (null != endDate && !endDate.equals("")) {
            Date eDate = sdf.parse(endDate);
            employeeShiftData.setOutDateTime(new SimpleDateFormat("yyyy-MM-dd").format(eDate));
        }

        recordToAdd.add(headerRow1);

        List<?> empDetail = new ArrayList<>();

        empDetail = employeeMasterService.empOrDateWiseSearchforActive(employeeAdvanceSearch);

        Iterator it = empDetail.iterator();
        while (it.hasNext()) {

//            Row row = firstSheet.createRow(rownum);
            List<String> employeeInfoList = new ArrayList();
            List<String> employeeInfoList1 = new ArrayList();
            Object[] next = (Object[]) it.next();
            employeeInfoList1.add("" + next[47]);
            if (employeeAdvanceSearch.getEmployeeId() == true) {
                employeeInfoList.add("" + next[0]);
            }
            if (employeeAdvanceSearch.getEmployeeName() == true) {
                employeeInfoList.add("" + next[1]);
            }

            if (null == next[2]) {
                next[2] = "";
            }
            if (null == next[3]) {
                next[3] = "";
            }
            if (null == next[4]) {
                next[4] = "";
            }
            if (null == next[5]) {
                next[5] = "";
            }
            if (null == next[6]) {
                next[6] = "";
            }
            if (null == next[7]) {
                next[7] = "";
            }
            if (null == next[8]) {
                next[8] = "";
            }
            if (null == next[9]) {
                next[9] = "";
            }
            if (null == next[10]) {
                next[10] = "";
            }
            if (null == next[11]) {
                next[11] = "";
            }
            if (null == next[12]) {
                next[12] = "";
            }
            if (null == next[13]) {
                next[13] = "";
            }
            if (null == next[14]) {
                next[14] = "";
            }
            if (null == next[15]) {
                next[15] = "";
            }
            if (null == next[16]) {
                next[16] = "";
            }
            if (null == next[17]) {
                next[17] = "";
            }
            if (null == next[18]) {
                next[18] = "";
            }
            if (null == next[19]) {
                next[19] = "";
            }
            if (null == next[20]) {
                next[20] = "";
            }
            if (null == next[21]) {
                next[21] = "";
            }
            if (null == next[22]) {
                next[22] = "";
            }
            if (null == next[23]) {
                next[23] = "";
            }
            if (null == next[24]) {
                next[24] = "";
            }
            if (null == next[25]) {
                next[25] = "";
            }
            if (null == next[26]) {
                next[26] = "";
            }
            if (null == next[27]) {
                next[27] = "";
            }
            if (null == next[28]) {
                next[28] = "";
            }
            if (null == next[29]) {
                next[29] = "";
            }
            if (null == next[30]) {
                next[30] = "";
            }
            if (null == next[31]) {
                next[31] = "";
            }
            if (null == next[32]) {
                next[32] = "";
            }
            if (null == next[33]) {
                next[33] = "";
            }
            if (null == next[34]) {
                next[34] = "";
            }
            if (null == next[35]) {
                next[35] = "";
            }
            if (null == next[36]) {
                next[36] = "";
            }
            if (null == next[37]) {
                next[37] = "";
            }
            if (null == next[38]) {
                next[38] = "";
            }
            if (null == next[39]) {
                next[39] = "";
            }
            if (null == next[40]) {
                next[40] = "";
            }
            if (null == next[41]) {
                next[41] = "";
            }
            if (null == next[42]) {
                next[42] = "";
            }
            if (null == next[43]) {
                next[43] = "";
            }
            if (null == next[44]) {
                next[44] = "";
            }
            if (null == next[45]) {
                next[45] = "";
            }
            if (null == next[46]) {
                next[46] = "";
            }
            if (null == next[47]) {
                next[47] = "";
            }
            if (employeeAdvanceSearch.getFatherName() == true) {
                employeeInfoList.add("" + next[2]);
            }
            if (employeeAdvanceSearch.getMotherName() == true) {
                employeeInfoList.add("" + next[3]);
            }
            if (employeeAdvanceSearch.getGender() == true) {
                employeeInfoList.add("" + next[4]);
            }
            if (employeeAdvanceSearch.getMaritalStatus() == true) {
                employeeInfoList.add("" + next[5]);
            }
            if (employeeAdvanceSearch.getDateOfBirth() == true) {
                employeeInfoList.add("" + next[6]);
            }
            if (employeeAdvanceSearch.getPresentAddress() == true) {
                employeeInfoList.add("" + next[7]);
            }
            if (employeeAdvanceSearch.getPermanentAddress() == true) {
                employeeInfoList.add("" + next[8]);
            }
            if (employeeAdvanceSearch.getBloodGroups() == true) {
                employeeInfoList.add("" + next[9]);
            }
            if (employeeAdvanceSearch.getEmailAddress() == true) {
                employeeInfoList.add("" + next[10]);
            }
            if (employeeAdvanceSearch.getContactNo1() == true) {
                employeeInfoList.add("" + next[11]);
            }
            if (employeeAdvanceSearch.getContactNo2() == true) {
                employeeInfoList.add("" + next[12]);
            }
            if (employeeAdvanceSearch.getEmergencyContactPerson() == true) {
                employeeInfoList.add("" + next[13]);
            }
            if (employeeAdvanceSearch.getEmergencyContactNo() == true) {
                employeeInfoList.add("" + next[14]);
            }
            if (employeeAdvanceSearch.getPanCard() == true) {
                employeeInfoList.add("" + next[15]);
            }
            if (employeeAdvanceSearch.getPassportNo() == true) {
                employeeInfoList.add("" + next[16]);
            }
            if (employeeAdvanceSearch.getPassportIssueDate() == true) {
                employeeInfoList.add("" + next[17]);
            }
            if (employeeAdvanceSearch.getPassportExpiryDate() == true) {
                employeeInfoList.add("" + next[18]);
            }
            if (employeeAdvanceSearch.getAdharCard() == true) {
                employeeInfoList.add("" + next[19]);
            }
            if (employeeAdvanceSearch.getOfficeEmailId() == true) {
                employeeInfoList.add("" + next[20]);
            }
            if (employeeAdvanceSearch.getHighestEducationDetails() == true) {
                employeeInfoList.add("" + next[21]);
            }
            if (employeeAdvanceSearch.getExperienceYearOnDoj() == true) {
                employeeInfoList.add("" + next[22]);
            }
            if (employeeAdvanceSearch.getExperienceMonthOnDoj() == true) {
                employeeInfoList.add("" + next[23]);
            }
            if (employeeAdvanceSearch.getCompany() == true) {
                employeeInfoList.add("" + next[24]);
            }
            if (employeeAdvanceSearch.getZydexLocation() == true) {
                employeeInfoList.add("" + next[25]);
            }
            if (employeeAdvanceSearch.getWorkLocation() == true) {
                employeeInfoList.add("" + next[26]);
            }
            if (employeeAdvanceSearch.getLevel() == true) {
                employeeInfoList.add("" + next[27]);
            }
            if (employeeAdvanceSearch.getDepartment() == true) {
                employeeInfoList.add("" + next[28]);
            }
            if (employeeAdvanceSearch.getDesignation() == true) {
                employeeInfoList.add("" + next[29]);
            }
            if (employeeAdvanceSearch.getRole() == true) {
                employeeInfoList.add("" + next[30]);
            }
            if (employeeAdvanceSearch.getDateOfJoining() == true) {
                employeeInfoList.add("" + next[31]);
            }
            if (employeeAdvanceSearch.getEmployeeType() == true) {
                employeeInfoList.add("" + next[32]);
            }
            if (employeeAdvanceSearch.getBankName() == true) {
                employeeInfoList.add("" + next[33]);
            }
            if (employeeAdvanceSearch.getBankAccountNo() == true) {
                employeeInfoList.add("" + next[34]);
            }
            if (employeeAdvanceSearch.getBankIfscCode() == true) {
                employeeInfoList.add("" + next[35]);
            }
            if (employeeAdvanceSearch.getReportingManager() == true) {
                employeeInfoList.add("" + next[36]);
            }
            if (employeeAdvanceSearch.getCityOfEmployee() == true) {
                employeeInfoList.add("" + next[37]);
            }
            if (employeeAdvanceSearch.getChild1() == true) {
                employeeInfoList.add("" + next[38]);
            }
            if (employeeAdvanceSearch.getChild2() == true) {
                employeeInfoList.add("" + next[39]);
            }
            if (employeeAdvanceSearch.getDateOfBirthOfEmpFather() == true) {
                employeeInfoList.add("" + next[40]);
            }
            if (employeeAdvanceSearch.getDateOfBirthOfEmpMother() == true) {
                employeeInfoList.add("" + next[41]);
            }
            if (employeeAdvanceSearch.getDateOfBirthOfEmpSpous() == true) {
                employeeInfoList.add("" + next[42]);
            }
            if (employeeAdvanceSearch.getDateOfBirthOfEmpChilld1() == true) {
                employeeInfoList.add("" + next[43]);
            }
            if (employeeAdvanceSearch.getDateOfBirthOfEmpChild2() == true) {
                employeeInfoList.add("" + next[44]);
            }
            if (employeeAdvanceSearch.getDateOfTransferOfEntity() == true) {
                employeeInfoList.add("" + next[45]);
            }

            recordToAdd.add(employeeInfoList);
            recordToAdd1.add(employeeInfoList1);

        }

        try {

            String empId1 = "0";
            int z = 0;
            for (int j = 0; j < recordToAdd.size(); j++) {
                Map<Integer, List<?>> map = new LinkedHashMap<Integer, List<?>>();
                Map<Integer, List<?>> map1 = new LinkedHashMap<Integer, List<?>>();
                Row row = firstSheet.createRow(rownum);
                List<String> l2 = recordToAdd.get(j);

                boolean myFlage = false;
                int id = 0;
                int countK = 1;
                for (int k = 0; k < l2.size(); k++) {
                    Cell cell = row.createCell(k);

                    cell.setCellValue(l2.get(k));
                    if (j == 0) {
                        cell.setCellStyle(styleBold);
                    }
                }

                if (null != startDate && !startDate.equals("") && null != endDate && !endDate.equals("")) {

                    if (j != 0) {

                        List<String> l3 = new ArrayList<>();
                        try {
                            l3 = recordToAdd1.get(z);
                            empId1 = l3.get(0);
                            z++;
                        } catch (Exception e) {
                        }

                        id = Integer.parseInt(empId1);
                        employeeShiftData.setId(id);
                        List<?> list = employeeShiftDataService.empOrDateWiseSearch(employeeShiftData);
                        map.put(id, list);
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
                        if (flexible == true && calForFlexiNotSupport2.get(Calendar.MONTH) != calForFlexiNotSupport1.get(Calendar.MONTH)) {
                            rownum = rownum + 1;
                            Row row4 = firstSheet.createRow(rownum);
                            Cell cell4 = row4.createCell(0);
                            cell4.setCellValue("");
                            rownum = rownum + 1;

                            Row row1 = firstSheet.createRow(rownum);
                            Cell cell1 = row1.createCell(0);
                            cell1.setCellValue("Employee Daily Attendance Information");
                            cell1.setCellStyle(styleBold);
                            double prcounter = 0;
                            double abcounter = 0;
                            double wo = 0;
                            double shl = 0;
                            double shla = 0;
                            double cl = 0;
                            double sl = 0;
                            double pl = 0;
                            double holiday = 0;
                            double tr = 0;
                            double ar = 0;
                            //                int zz = 0;
                            for (Map.Entry<Integer, List<?>> entry : map.entrySet()) {
                                rownum = rownum + 1;
                                Row row33 = firstSheet.createRow(rownum);
                                rownum = rownum + 1;
                                Row row3 = firstSheet.createRow(rownum);

                                Iterator itr1 = entry.getValue().iterator();
                                int i = 1;
                                int k = 1;
                                int l = 1;
                                int m = 1;
                                int n = 1;
                                int o = 1;
                                int p = 1;
                                SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm");
                                Cell cellTitle = row3.createCell(0);
                                cellTitle.setCellValue("Date");
                                cellTitle.setCellStyle(styleBold);
                                while (itr1.hasNext()) {
                                    Object[] next = (Object[]) itr1.next();
                                    Cell cell3 = row3.createCell(i);
                                    cell3.setCellValue("" + next[0]);
                                    CellUtil.setAlignment(cell3, firstFWorkbook, CellStyle.ALIGN_CENTER);

                                    i++;
                                }
                                rownum = rownum + 1;
                                Row row5 = firstSheet.createRow(rownum);
                                Iterator itr2 = entry.getValue().iterator();
                                Cell cellTitle1 = row5.createCell(0);
                                cellTitle1.setCellValue("Shift Name");
                                cellTitle1.setCellStyle(styleBold);
                                while (itr2.hasNext()) {
                                    Object[] next = (Object[]) itr2.next();
                                    Cell cell5 = row5.createCell(l);
                                    String shiftName = "" + next[1];
                                    if (shiftName.contains("#")) {
                                        String[] shiftName1 = shiftName.split("#");
                                        String[] shiftName2 = shiftName1[1].split("\\$");
                                        cell5.setCellValue("" + shiftName2[0]);
                                    } else if (!shiftName.contains("`")) {
                                        cell5.setCellValue("-");
                                    }

                                    CellUtil.setAlignment(cell5, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    l++;

                                }
                                rownum = rownum + 1;
                                Row row6 = firstSheet.createRow(rownum);
                                Iterator itr3 = entry.getValue().iterator();
                                Cell cellTitle2 = row6.createCell(0);
                                cellTitle2.setCellValue("First In");
                                cellTitle2.setCellStyle(styleBold);
                                int weekNameCounter1 = 0;
                                while (itr3.hasNext()) {
                                    Object[] next = (Object[]) itr3.next();
                                    Cell cell6 = row6.createCell(k);
                                    String firstIn = "" + next[1];
                                    if (firstIn.contains("`") && !firstIn.contains("?")) {
                                        String[] firstIn1 = firstIn.split("`");
                                        String[] firstIn12 = firstIn1[1].split("!");
                                        cell6.setCellValue("" + firstIn12[0]);
                                    } else if (!firstIn.contains("`") && !firstIn.contains("?") && !firstIn.contains("AB") && !firstIn.equals("WO") && !firstIn.contains("TR") && !firstIn.contains("AR")) {
                                        if (firstIn.contains("Casual Leave")) {
                                            cl = cl + 1;
                                        }
                                        if (firstIn.contains("Privilege Leave")) {
                                            pl = pl + 1;
                                        }
                                        if (firstIn.contains("Sick Leave")) {
                                            sl = sl + 1;
                                        }
                                        cell6.setCellValue("" + next[1]);
                                    } else if (!firstIn.contains("`") && firstIn.contains("?") && !firstIn.contains("AB") && !firstIn.equals("WO") && !firstIn.contains("TR") && !firstIn.contains("AR")) {
                                        String[] hostring = firstIn.split("\\?");
                                        cell6.setCellValue("" + hostring[0]);
                                        holiday = holiday + 1;
                                    } else if (!firstIn.contains("`") && firstIn.contains("?") && firstIn.contains("AB") && !firstIn.equals("WO") && !firstIn.contains("TR") && !firstIn.contains("AR")) {
                                        cell6.setCellValue("-");
                                    } else if (firstIn.equals("WO")) {
                                        cell6.setCellValue(firstIn);
                                        wo = wo + 1;
                                    } else if (firstIn.equals("TR")) {
                                        cell6.setCellValue(firstIn);
                                        tr = tr + 1;
                                        cell6.setCellStyle(styleblue);
                                    }
                                    CellUtil.setAlignment(cell6, firstFWorkbook, CellStyle.ALIGN_CENTER);
//                                    2nd Sat Week Off Codding
                                    Calendar cal = Calendar.getInstance();
                                    Date date = sdf.parse("" + next[0]);
                                    cal.setTime(date);
                                    SimpleDateFormat format = new SimpleDateFormat("EEEE");
                                    String dayName = format.format(date);
                                    EmployeeMaster employeeMaster1 = employeeMasterService.readById(id);
                                    ZydexLocationMaster zydexLocationMaster = zydexLocationMasterService.readById(employeeMaster1.getZydexLocationMaster().getId());

                                    if (dayName.equals("Saturday")) {
                                        weekNameCounter1++;
                                        if (weekNameCounter1 == 2) {
                                            if (firstIn.contains("Casual Leave")) {
                                                cl = cl - 0.5;
                                            }
                                            if (firstIn.contains("Privilege Leave")) {
                                                pl = pl - 0.5;
                                            }
                                            if (firstIn.contains("Sick Leave")) {
                                                sl = sl - 0.5;
                                            }
                                        }

                                    }
//                                    2nd Sat Week Off Codding
                                    k++;
                                }

                                rownum = rownum + 1;
                                Row row7 = firstSheet.createRow(rownum);
                                Cell cellTitle3 = row7.createCell(0);
                                cellTitle3.setCellValue("Last Out");
                                cellTitle3.setCellStyle(styleBold);
                                Iterator itr4 = entry.getValue().iterator();
                                while (itr4.hasNext()) {
                                    Object[] next = (Object[]) itr4.next();
                                    Cell cell7 = row7.createCell(m);
                                    String lastOut = "" + next[1];
                                    if (lastOut.contains("!")) {
                                        String[] lastOut1 = lastOut.split("`");
                                        String[] lastOut2 = lastOut1[1].split("!");
                                        String[] lastOut3 = lastOut.split("!");
                                        String[] lastOut4 = lastOut3[1].split("@");
                                        Date lout = sdf1.parse(lastOut4[0]);
                                        Date fin = sdf1.parse(lastOut2[0]);
                                        if (lout.equals(fin)) {
                                            cell7.setCellValue("-");
                                        } else {
                                            cell7.setCellValue("" + lastOut4[0]);
                                        }

                                    } else if (lastOut.contains("@")) {
                                        cell7.setCellValue("-");
                                    }
                                    CellUtil.setAlignment(cell7, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    m++;
                                }
                                rownum = rownum + 1;
                                Row row8 = firstSheet.createRow(rownum);
                                Cell cellTitle4 = row8.createCell(0);
                                cellTitle4.setCellValue("First Half");
                                cellTitle4.setCellStyle(styleBold);
                                Iterator itr5 = entry.getValue().iterator();
                                int firstCounter = 0;

                                while (itr5.hasNext()) {
                                    Object[] next = (Object[]) itr5.next();
                                    Cell cell8 = row8.createCell(n);
                                    String firstHalf = "" + next[1];
                                    int firstHalfVal = 0;
                                    int counter = 0;

                                    if (firstHalf.contains("fullday")) {
                                        cell8.setCellValue("PR");
                                        prcounter = prcounter + 0.5;
                                        cell8.setCellStyle(stylegreen);

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
                                        Date userTimeIn = sdf1.parse(userTimeInStr1[0]);
                                        Date userTimeOut = sdf1.parse(userTimeOutStr1[0]);
                                        Date endHours = sdf1.parse(endHoursStr1[0]);
                                        Date firstStartHours = sdf1.parse(firstStartHoursStr[1]);
                                        Calendar cal = Calendar.getInstance();
                                        Calendar cal1 = Calendar.getInstance();
                                        cal.setTime(firstStartHours);
                                        cal1.setTime(firstStartHours);
                                        cal1.add(Calendar.MINUTE, -earlyMinute);
                                        cal.add(Calendar.MINUTE, lateMinute);
                                        String newTime = sdf1.format(cal.getTime());
                                        Date flexibleEndTime = sdf1.parse(newTime);
                                        Date LateHours = sdf1.parse(LateHoursStr1[0]);
                                        String newTime1 = sdf1.format(cal1.getTime());
                                        Date flexibleStartTime = sdf1.parse(newTime1);
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
                                                cell8.setCellValue("PR");
                                                prcounter = prcounter + 0.5;
                                                cell8.setCellStyle(stylegreen);
                                            } else if (userTimeOut.before(userTimeIn)) {
                                                cell8.setCellValue("PR");
                                                prcounter = prcounter + 0.5;
                                                cell8.setCellStyle(stylegreen);
                                            } else if (leave1[0] != null && !leave1[0].contains("Short Leave")) {
                                                if ((userTimeIn.before(flexibleEndTime) || userTimeIn.equals(flexibleEndTime)) && (userTimeOut.after(endHours) || userTimeOut.equals(endHours))) {
                                                    cell8.setCellValue("PR");
                                                    prcounter = prcounter + 0.5;
                                                    cell8.setCellStyle(stylegreen);
                                                } else if (leave1[0].contains("AB")) {
                                                    cell8.setCellValue("AB");
                                                    abcounter = abcounter + 0.5;
                                                    cell8.setCellStyle(stylered);
                                                } else if (leave1[0].contains("AR")) {
                                                    cell8.setCellValue("AR/P");
                                                    ar = ar + 0.5;
                                                    cell8.setCellStyle(styleblue);
                                                } else {
                                                    if (leave1[0].contains("Casual Leave")) {
                                                        cl = cl + 0.5;
                                                    }
                                                    if (leave1[0].contains("Privilege Leave")) {
                                                        pl = pl + 0.5;
                                                    }
                                                    if (leave1[0].contains("Sick Leave")) {
                                                        sl = sl + 0.5;
                                                    }
                                                    cell8.setCellValue(" " + leave1[0]);
                                                }

                                            } else if (null != leave1[0] && leave1[0].contains("Short Leave")) {
                                                if (firstHalf.contains("*")) {
                                                    String[] shortArray = firstHalf.split("\\*");
                                                    String[] endArray = shortArray[1].split("\\-");
                                                    String[] startTime = endArray[1].split("\\+");
                                                    Date shortIn = sdf1.parse(shortArray[1]);
                                                    Date shortend = sdf1.parse(endArray[1]);
                                                    Date startTime1 = sdf1.parse(startTime[1]);
                                                    if (shortIn.before(endHours)) {
                                                        cell8.setCellValue("SHL/P");
                                                        cell8.setCellStyle(stylegreen);
                                                        shl = shl + 1;
                                                    } else if (leave1[0].contains("~ AR")) {
                                                        cell8.setCellValue("AR/P");
                                                        ar = ar + 0.5;
                                                        cell8.setCellStyle(styleblue);
                                                    } else if (userTimeIn.after(endHours)) {
                                                        cell8.setCellValue("SHL/A");
                                                        shla = shla + 1;
                                                        cell8.setCellStyle(stylered);
                                                    } else if ((userTimeIn.before(flexibleEndTime) || userTimeIn.equals(flexibleEndTime)) && (userTimeOut.after(endHours) || userTimeOut.equals(endHours))) {
                                                        cell8.setCellValue("PR");
                                                        prcounter = prcounter + 0.5;
                                                        cell8.setCellStyle(stylegreen);
                                                    } else {
                                                        cell8.setCellValue("AB");
                                                        abcounter = abcounter + 0.5;
                                                        cell8.setCellStyle(stylered);
                                                    }
                                                } else {
                                                    cell8.setCellValue("AB");
                                                    abcounter = abcounter + 0.5;
                                                    cell8.setCellStyle(stylered);
                                                }
                                            } else if (null != leave1[0] && !leave1[0].contains("AB")) {
                                                if (leave1[0].contains("Casual Leave")) {
                                                    cl = cl + 0.5;
                                                }
                                                if (leave1[0].contains("Privilege Leave")) {
                                                    pl = pl + 0.5;
                                                }
                                                if (leave1[0].contains("Sick Leave")) {
                                                    sl = sl + 0.5;
                                                }
                                                cell8.setCellValue(" " + leave1[0]);

                                            } else if (leave1[0].contains("AB")) {
                                                cell8.setCellValue("-");
                                            } else {
                                                cell8.setCellValue("AB");
                                                abcounter = abcounter + 0.5;
                                                cell8.setCellStyle(stylered);
                                            }

                                        } else if (userTimeIn != null && !firstHalf.contains("WO") && !firstHalf.contains("?")) {
                                            cell8.setCellValue("AB");
                                            abcounter = abcounter + 0.5;
                                            cell8.setCellStyle(stylered);
                                        } else if (firstHalf.contains("WO") || firstHalf.contains("?")) {
                                            cell8.setCellValue("-");
                                        }

                                    } else if (firstHalf.equals("WO")) {
                                        cell8.setCellValue("");
                                    } else if (firstHalf.contains("AR")) {
                                        cell8.setCellValue("AR/P");
                                        ar = ar + 0.5;
                                        cell8.setCellStyle(styleblue);
                                    } else if (firstHalf.equals("AB")) {
                                        cell8.setCellValue("AB");
                                        abcounter = abcounter + 0.5;
                                        cell8.setCellStyle(stylered);
                                    }
                                    CellUtil.setAlignment(cell8, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    n++;
                                }

                                rownum = rownum + 1;
                                Row row9 = firstSheet.createRow(rownum);
                                Cell cellTitle5 = row9.createCell(0);
                                cellTitle5.setCellValue("Second Half");
                                cellTitle5.setCellStyle(styleBold);
                                Iterator itr6 = entry.getValue().iterator();
                                int weekNameCounter = 0;
                                boolean satWeekOff = false;
                                while (itr6.hasNext()) {
                                    Object[] next = (Object[]) itr6.next();
                                    Cell cell9 = row9.createCell(o);
                                    String secondHalf = "" + next[1];
                                    int firstHalfVal = 0;
                                    int counter = 0;
                                    String shiftName = "";
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
                                            Date userTimeIn = sdf1.parse(userTimeInStr1[0]);
                                            Date userTimeOut = sdf1.parse(userTimeOutStr1[0]);
                                            String[] startHoursStr = secondHalf.split("%");
                                            String[] firstStartHoursStr = startHoursStr[1].split("\\+");
                                            String[] endHoursStr = secondHalf.split("&");
                                            Date firstStartHours = sdf1.parse(firstStartHoursStr[1]);
                                            Calendar cal1 = Calendar.getInstance();
                                            cal1.setTime(firstStartHours);
                                            cal1.add(Calendar.MINUTE, -earlyMinute);

                                            String newTime1 = sdf1.format(cal1.getTime());
                                            Date flexibleInTime = sdf1.parse(newTime1);
                                            Date endHours = sdf1.parse(endHoursStr[1]);
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
                                    } catch (Exception e) {

                                    }

//                                    Lunch Breck Cut Off
                                    if (secondHalf.contains(" # ")) {
                                        String[] string1 = secondHalf.split("#");
                                        String[] string2 = string1[1].split("\\$");
                                        shiftName = string2[0].trim();

                                    }
                                    if (satWeekOff == true && (zydexLocationMaster.getZydexLocation().equals("HO") || zydexLocationMaster.getZydexLocation().equals("R&D"))) {
                                        cell9.setCellValue("WO");
                                        wo = wo + 0.5;
                                    } else if (secondHalf.equals("AR")) {
                                        cell9.setCellValue("AR/P");
                                        ar = ar + 0.5;
                                        cell9.setCellStyle(styleblue);
                                    } else if (checkLunchTime == true && totalTime < shiftdiffMinutes && !secondHalf.contains("AR")) {
                                        cell9.setCellValue("AB");
                                        abcounter = abcounter + 0.5;
                                        cell9.setCellStyle(stylered);
                                    } else if (secondHalf.contains("fullday")) {
                                        cell9.setCellValue("PR");
                                        prcounter = prcounter + 0.5;
                                        cell9.setCellStyle(stylegreen);

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

                                        Date userTimeIn = sdf1.parse(userTimeInStr1[0]);
                                        Date userTimeOut = sdf1.parse(userTimeOutStr1[0]);
                                        Date userTimeOut1 = sdf1.parse("23:59");
                                        Date firstStartHours = sdf1.parse(firstStartHoursStr[1]);
                                        String[] getInHours = userTimeInStr1[0].split(":");
                                        String[] getOutHours = userTimeOutStr1[0].split(":");
                                        String abc = getInHours[0].trim();
                                        String xyz = getOutHours[0].trim();
                                        int i11 = Integer.parseInt(abc) - Integer.parseInt(xyz);
                                        int totalDuration = 24 - i11;
                                        String totalDuration2 = getOutHours[0];
                                        Date endHours = sdf1.parse(endHoursStr[1]);
                                        Date secondHalfTimeStr2 = sdf1.parse(secondHalfTimeStr1[0]);

                                        Calendar cal1 = Calendar.getInstance();
                                        Calendar cal2 = Calendar.getInstance();
                                        cal1.setTime(firstStartHours);
                                        cal1.add(Calendar.MINUTE, -earlyMinute);
                                        cal2.setTime(firstStartHours);
                                        cal2.add(Calendar.MINUTE, lateMinute);
                                        String newTime = sdf1.format(cal2.getTime());
                                        Date flexibleEndTime = sdf1.parse(newTime);

                                        String newTime1 = sdf1.format(cal1.getTime());
                                        Date flexibleInTime = sdf1.parse(newTime1);
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
                                                cell9.setCellValue("AR/P");
                                                ar = ar + 0.5;
                                                cell9.setCellStyle(styleblue);
                                            } else if (diffMinutes1 >= diffMinutes && userTimeIn.before(flexibleEndTime)) {
                                                cell9.setCellValue("PR");
                                                prcounter = prcounter + 0.5;
                                                cell9.setCellStyle(stylegreen);
                                            } else if (diffMinutes1 <= diffMinutes && userTimeIn.before(flexibleEndTime) && !secondHalf.contains("WO") && !secondHalf.contains("TR") && !secondHalf.contains("AR") && !secondHalf.contains("?")
                                                    && !secondHalf.contains("Casual Leave") && !secondHalf.equals("C Off Leave") && !secondHalf.contains("Privilege Leave") && !secondHalf.contains("Sick Leave")
                                                    && !secondHalf.contains("Paternity Leave") && !secondHalf.contains("Maternity Leave") && !secondHalf.contains("Leave Without Pay")) {
                                                cell9.setCellValue("AB");
                                                abcounter = abcounter + 0.5;
                                                cell9.setCellStyle(stylered);
                                            } else if (diffMinutes1 >= 240 && userTimeIn.after(secondHalfTimeStr2)) {
                                                cell9.setCellValue("PR");
                                                prcounter = prcounter + 0.5;
                                                cell9.setCellStyle(stylegreen);
                                            } else if ((userTimeIn.before(secondHalfTimeStr2) || userTimeIn.equals(secondHalfTimeStr2)) && (userTimeOut.after(endHours) || userTimeOut.equals(endHours))) {
                                                cell9.setCellValue("PR");
                                                prcounter = prcounter + 0.5;
                                                cell9.setCellStyle(stylegreen);
                                            } else if (shiftName.contains("Night") && (userTimeOut.after(endHours) || userTimeOut.equals(endHours))) {
                                                cell9.setCellValue("PR");
                                                prcounter = prcounter + 0.5;
                                                cell9.setCellStyle(stylegreen);
                                            } else if (null != leave1[0] && leave1[0].contains("Short Leave")) {
                                                if (secondHalf.contains("*")) {
                                                    String[] shortArray = secondHalf.split("\\*");
                                                    String[] endArray = secondHalf.split("\\^");
                                                    String[] secondhalfstartTime = endArray[1].split("&");
                                                    Date shortIn = sdf1.parse(shortArray[1]);
                                                    Date shortend = sdf1.parse(endArray[1]);
                                                    Date secondhalfstartTime1 = sdf1.parse(secondhalfstartTime[0]);
                                                    if ((secondhalfstartTime1.before(shortIn) || secondhalfstartTime1.equals(shortIn)) && (shortIn.before(endHours) || shortIn.equals(endHours))) {
                                                        if (userTimeOut.after(secondHalfTimeStr2)) {
                                                            cell9.setCellValue("SHL/P");
                                                            shl = shl + 1;
                                                            cell9.setCellStyle(stylegreen);
                                                        } else if (leave1[0].contains("~ AR")) {
                                                            cell9.setCellValue("AR/P");
                                                            ar = ar + 0.5;
                                                            cell9.setCellStyle(styleblue);
                                                        } else if (userTimeOut.before(secondHalfTimeStr2) || userTimeOut.equals(secondHalfTimeStr2)) {
                                                            cell9.setCellValue("SHL/A");
                                                            shla = shla + 1;
                                                            cell9.setCellStyle(stylered);
                                                        } else {
                                                            cell9.setCellValue("AB");
                                                            abcounter = abcounter + 0.5;
                                                            cell9.setCellStyle(stylered);
                                                        }
                                                    }
                                                } else {
                                                    cell9.setCellValue("AB");
                                                    abcounter = abcounter + 0.5;
                                                    cell9.setCellStyle(stylered);
                                                }
                                            } else if (null != leave1[0] && !leave1[0].contains("AB") && !leave1[0].contains("AR")) {
                                                if (leave1[0].contains("Casual Leave")) {
                                                    cl = cl + 0.5;
                                                }
                                                if (leave1[0].contains("Privilege Leave")) {
                                                    pl = pl + 0.5;
                                                }
                                                if (leave1[0].contains("Sick Leave")) {
                                                    sl = sl + 0.5;
                                                }
                                                cell9.setCellValue(" " + leave1[0]);

                                            } else if (leave1[0].contains("AB")) {
                                                cell9.setCellValue("AB");
                                                abcounter = abcounter + 0.5;
                                                cell9.setCellStyle(stylered);
                                            } else {
                                                cell9.setCellValue("AB");
                                                abcounter = abcounter + 0.5;
                                                cell9.setCellStyle(stylered);
                                            }

                                        } else if (userTimeIn != null && !secondHalf.contains("WO") && !secondHalf.contains("?")) {
                                            cell9.setCellValue("AB");
                                            abcounter = abcounter + 0.5;
                                            cell9.setCellStyle(stylered);
                                        } else if (secondHalf.contains("WO") || secondHalf.contains("?")) {
                                            cell9.setCellValue("-");
                                        }

                                    } else if (secondHalf.equals("WO")) {
                                        cell9.setCellValue("-");
                                    } else if (secondHalf.equals("AB")) {
                                        cell9.setCellValue("AB");
                                        abcounter = abcounter + 0.5;
                                        cell9.setCellStyle(stylered);
                                    }
                                    CellUtil.setAlignment(cell9, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    o++;
                                }

                                rownum = rownum + 1;
                                Row row10 = firstSheet.createRow(rownum);
                                Cell cellTitle6 = row10.createCell(0);
                                cellTitle6.setCellValue("Working Hour");
                                cellTitle6.setCellStyle(styleBold);
                                Iterator itr7 = entry.getValue().iterator();
                                while (itr7.hasNext()) {
                                    Object[] next = (Object[]) itr7.next();
                                    Cell cell10 = row10.createCell(p);
                                    String secondHalf = "" + next[1];
                                    int firstHalfVal = 0;
                                    int counter = 0;
                                    String shiftName = "";

//                                    Lunch Breck Cut Off
                                    List listPunch = employeeDatetimeDataService.readPuchDataDateWise("" + next[0], id);
                                    long lunchTime = 0;
                                    long outTime = 0;
                                    long totalDayTime = 0;
                                    long totalDayTime1 = 0;
                                    long totalTime = 0;
                                    long shiftdiffMinutes = 0;
                                    String startTime = "";
                                    String endTime = "";
                                    int d = 1;
                                    int s = 2;
                                    boolean checkLunchTime = false;
                                    SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                                    if (listPunch.size() > 0 && !secondHalf.equals("WO") && !secondHalf.equals("AB") && !secondHalf.equals("TR") && !secondHalf.equals("AR")) {
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
                                        }

                                        String[] userTimeInStr = secondHalf.split("`");
                                        String[] userTimeInStr1 = userTimeInStr[1].split("!");
                                        String[] userTimeOutStr = secondHalf.split("!");
                                        String[] userTimeOutStr1 = userTimeOutStr[1].split("@");
                                        Date userTimeIn = sdf1.parse(userTimeInStr1[0]);
                                        Date userTimeOut = sdf1.parse(userTimeOutStr1[0]);
                                        Date userTimeOut1 = sdf1.parse("23:59");
                                        String[] startHoursStr = secondHalf.split("%");
                                        String[] firstStartHoursStr = startHoursStr[1].split("\\+");
                                        String[] endHoursStr = secondHalf.split("&");
                                        Date firstStartHours = sdf1.parse(firstStartHoursStr[1]);
                                        Calendar cal1 = Calendar.getInstance();
                                        cal1.setTime(firstStartHours);
                                        cal1.add(Calendar.MINUTE, -earlyMinute);
                                        String newTime1 = sdf1.format(cal1.getTime());
                                        Date flexibleInTime = sdf1.parse(newTime1);
                                        Date endHours = sdf1.parse(endHoursStr[1]);
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
                                            cell10.setCellValue(workingHours);

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
                                            cell10.setCellValue(workingHours);
                                        }

                                    } else {
                                        cell10.setCellValue("-");
                                    }

//                                    Lunch Breck Cut Off
                                    CellUtil.setAlignment(cell10, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    p++;
                                }

                            }
                            rownum = rownum + 1;
                            Row dayCount1 = firstSheet.createRow(rownum);
                            rownum = rownum + 1;
                            Row dayCount = firstSheet.createRow(rownum);
                            Cell dayCounrCell = dayCount.createCell(0);
                            dayCounrCell.setCellValue("Day Count");
                            dayCounrCell.setCellStyle(styleBold);

                            rownum = rownum + 1;
                            Row row13 = firstSheet.createRow(rownum);
                            for (int y = 1; y < 10;) {
                                if (prcounter != 0) {
                                    Cell cell12 = row13.createCell(y);
                                    cell12.setCellValue("PR");
                                    cell12.setCellStyle(stylegreen);
                                    CellUtil.setAlignment(cell12, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    y++;
                                }
                                if (abcounter != 0) {
                                    Cell cell13 = row13.createCell(y);
                                    cell13.setCellValue("AB");
                                    cell13.setCellStyle(stylered);
                                    CellUtil.setAlignment(cell13, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    y++;
                                }
                                if (shl != 0) {
                                    Cell cell14 = row13.createCell(y);
                                    cell14.setCellValue("SHL/P");
                                    cell14.setCellStyle(stylegreen);
                                    CellUtil.setAlignment(cell14, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    y++;
                                }
                                if (shla != 0) {
                                    Cell cell15 = row13.createCell(y);
                                    cell15.setCellValue("SHL/A");
                                    cell15.setCellStyle(stylered);
                                    CellUtil.setAlignment(cell15, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    y++;
                                }
                                if (cl != 0) {
                                    Cell cell16 = row13.createCell(y);
                                    cell16.setCellValue("CL");
                                    cell16.setCellStyle(styleBold);
                                    CellUtil.setAlignment(cell16, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    y++;
                                }
                                if (sl != 0) {
                                    Cell cell17 = row13.createCell(y);
                                    cell17.setCellValue("SL");
                                    cell17.setCellStyle(styleBold);
                                    CellUtil.setAlignment(cell17, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    y++;
                                }
                                if (pl != 0) {
                                    Cell cell18 = row13.createCell(y);
                                    cell18.setCellValue("PL");
                                    cell18.setCellStyle(styleBold);
                                    CellUtil.setAlignment(cell18, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    y++;
                                }
                                if (holiday != 0) {
                                    Cell cell19 = row13.createCell(y);
                                    cell19.setCellValue("HOLIDAY");
                                    cell19.setCellStyle(styleBold);
                                    CellUtil.setAlignment(cell19, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    y++;
                                }
                                if (ar != 0) {
                                    Cell cell20 = row13.createCell(y);
                                    cell20.setCellValue("AR/P");
                                    cell20.setCellStyle(styleblue);
                                    CellUtil.setAlignment(cell20, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    y++;
                                }
                                if (wo != 0) {
                                    Cell cell21 = row13.createCell(y);
                                    cell21.setCellValue("WO");
                                    cell21.setCellStyle(styleBold);
                                    CellUtil.setAlignment(cell21, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    y++;
                                }
                                if (tr != 0) {
                                    Cell cell22 = row13.createCell(y);
                                    cell22.setCellValue("TR");
                                    cell22.setCellStyle(styleblue);
                                    CellUtil.setAlignment(cell22, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                }
                                break;
                            }

                            rownum = rownum + 1;
                            Row row12 = firstSheet.createRow(rownum);
                            for (int x = 1; x < 10;) {
                                if (prcounter != 0) {
                                    Cell cell12 = row12.createCell(x);
                                    cell12.setCellType(Cell.CELL_TYPE_NUMERIC);
                                    double newshl = shl / 2;
                                    double nepr = prcounter - newshl;
                                    cell12.setCellValue(nepr);
                                    CellUtil.setAlignment(cell12, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    x++;
                                }
                                if (abcounter != 0) {
                                    Cell cell13 = row12.createCell(x);
                                    cell13.setCellType(Cell.CELL_TYPE_NUMERIC);
                                    cell13.setCellValue(abcounter);
                                    CellUtil.setAlignment(cell13, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    x++;
                                }
                                if (shl != 0) {
                                    Cell cell14 = row12.createCell(x);
                                    cell14.setCellType(Cell.CELL_TYPE_NUMERIC);
                                    cell14.setCellValue(shl);
                                    CellUtil.setAlignment(cell14, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    x++;
                                }
                                if (shla != 0) {
                                    Cell cell15 = row12.createCell(x);
                                    cell15.setCellType(Cell.CELL_TYPE_NUMERIC);
                                    cell15.setCellValue(shla);
                                    CellUtil.setAlignment(cell15, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    x++;
                                }
                                if (cl != 0) {
                                    Cell cell16 = row12.createCell(x);
                                    cell16.setCellType(Cell.CELL_TYPE_NUMERIC);
                                    cell16.setCellValue(cl);
                                    CellUtil.setAlignment(cell16, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    x++;
                                }
                                if (sl != 0) {
                                    Cell cell17 = row12.createCell(x);
                                    cell17.setCellType(Cell.CELL_TYPE_NUMERIC);
                                    cell17.setCellValue(sl);
                                    CellUtil.setAlignment(cell17, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    x++;
                                }
                                if (pl != 0) {
                                    Cell cell18 = row12.createCell(x);
                                    cell18.setCellType(Cell.CELL_TYPE_NUMERIC);
                                    cell18.setCellValue(pl);
                                    CellUtil.setAlignment(cell18, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    x++;
                                }
                                if (holiday != 0) {
                                    Cell cell19 = row12.createCell(x);
                                    cell19.setCellType(Cell.CELL_TYPE_NUMERIC);
                                    cell19.setCellValue(holiday);
                                    CellUtil.setAlignment(cell19, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    x++;
                                }
                                if (ar != 0) {
                                    Cell cell20 = row12.createCell(x);
                                    cell20.setCellType(Cell.CELL_TYPE_NUMERIC);
                                    cell20.setCellValue(ar);
                                    CellUtil.setAlignment(cell20, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    x++;
                                }
                                if (wo != 0) {
                                    Cell cell21 = row12.createCell(x);
                                    cell21.setCellType(Cell.CELL_TYPE_NUMERIC);
                                    cell21.setCellValue(wo);
                                    CellUtil.setAlignment(cell21, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    x++;
                                }
                                if (tr != 0) {
                                    Cell cell22 = row12.createCell(x);
                                    cell22.setCellType(Cell.CELL_TYPE_NUMERIC);
                                    cell22.setCellValue(tr);
                                    CellUtil.setAlignment(cell22, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                }
                                break;
                            }

                        } else {
                            rownum = rownum + 1;
                            Row row4 = firstSheet.createRow(rownum);
                            Cell cell4 = row4.createCell(0);
                            cell4.setCellValue("");
                            rownum = rownum + 1;

                            Row row1 = firstSheet.createRow(rownum);
                            Cell cell1 = row1.createCell(0);
                            cell1.setCellValue("Employee Daily Attendance Information");
                            cell1.setCellStyle(styleBold);
                            double prcounter = 0;
                            double abcounter = 0;
                            double wo = 0;
                            double shl = 0;
                            double shla = 0;
                            double cl = 0;
                            double sl = 0;
                            double pl = 0;
                            double holiday = 0;
                            double tr = 0;
                            double ar = 0;
                            //                int zz = 0;
                            for (Map.Entry<Integer, List<?>> entry : map.entrySet()) {
                                rownum = rownum + 1;
                                Row row33 = firstSheet.createRow(rownum);
                                rownum = rownum + 1;
                                Row row3 = firstSheet.createRow(rownum);

                                Iterator itr1 = entry.getValue().iterator();
                                int i = 1;
                                int k = 1;
                                int l = 1;
                                int m = 1;
                                int n = 1;
                                int o = 1;
                                SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm");
                                Cell cellTitle = row3.createCell(0);
                                cellTitle.setCellValue("Date");
                                cellTitle.setCellStyle(styleBold);

                                while (itr1.hasNext()) {
                                    Object[] next = (Object[]) itr1.next();
                                    Cell cell3 = row3.createCell(i);
                                    cell3.setCellValue("" + next[0]);
                                    CellUtil.setAlignment(cell3, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    i++;
                                }
                                rownum = rownum + 1;
                                Row row5 = firstSheet.createRow(rownum);
                                Iterator itr2 = entry.getValue().iterator();
                                Cell cellTitle1 = row5.createCell(0);
                                cellTitle1.setCellValue("Shift Name");
                                cellTitle1.setCellStyle(styleBold);
                                while (itr2.hasNext()) {
                                    Object[] next = (Object[]) itr2.next();
                                    Cell cell5 = row5.createCell(l);
                                    String shiftName = "" + next[1];
                                    if (shiftName.contains("#")) {
                                        String[] shiftName1 = shiftName.split("#");
                                        String[] shiftName2 = shiftName1[1].split("\\$");
                                        cell5.setCellValue("" + shiftName2[0]);
                                    } else if (!shiftName.contains("`")) {
                                        cell5.setCellValue("-");
                                    }

                                    CellUtil.setAlignment(cell5, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    l++;

                                }
                                rownum = rownum + 1;
                                Row row6 = firstSheet.createRow(rownum);
                                Iterator itr3 = entry.getValue().iterator();
                                Cell cellTitle2 = row6.createCell(0);
                                cellTitle2.setCellValue("First In");
                                cellTitle2.setCellStyle(styleBold);
                                while (itr3.hasNext()) {
                                    Object[] next = (Object[]) itr3.next();
                                    Cell cell6 = row6.createCell(k);
                                    String firstIn = "" + next[1];
                                    if (firstIn.contains("`") && !firstIn.contains("?")) {
                                        String[] firstIn1 = firstIn.split("`");
                                        String[] firstIn12 = firstIn1[1].split("!");
                                        cell6.setCellValue("" + firstIn12[0]);
                                    } else if (!firstIn.contains("`") && !firstIn.contains("?") && !firstIn.contains("AB") && !firstIn.equals("WO") && !firstIn.contains("TR") && !firstIn.contains("AR")) {
                                        if (firstIn.contains("Casual Leave")) {
                                            cl = cl + 1;
                                        }
                                        if (firstIn.contains("Privilege Leave")) {
                                            pl = pl + 1;
                                        }
                                        if (firstIn.contains("Sick Leave")) {
                                            sl = sl + 1;
                                        }
                                        cell6.setCellValue("" + next[1]);
                                    } else if (!firstIn.contains("`") && firstIn.contains("?") && !firstIn.contains("AB") && !firstIn.equals("WO") && !firstIn.contains("TR") && !firstIn.contains("AR")) {
                                        String[] hostring = firstIn.split("\\?");
                                        cell6.setCellValue("" + hostring[0]);
                                        holiday = holiday + 1;
                                    } else if (!firstIn.contains("`") && firstIn.contains("?") && firstIn.contains("AB") && !firstIn.equals("WO") && !firstIn.contains("TR") && !firstIn.contains("AR")) {
                                        cell6.setCellValue("-");
                                    } else if (firstIn.equals("WO")) {
                                        cell6.setCellValue(firstIn);
                                        wo = wo + 1;
                                    } else if (firstIn.equals("TR")) {
                                        cell6.setCellValue(firstIn);
                                        tr = tr + 1;
                                        cell6.setCellStyle(styleblue);
                                    }
                                    CellUtil.setAlignment(cell6, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    k++;
                                }

                                rownum = rownum + 1;
                                Row row7 = firstSheet.createRow(rownum);
                                Cell cellTitle3 = row7.createCell(0);
                                cellTitle3.setCellValue("Last Out");
                                cellTitle3.setCellStyle(styleBold);
                                Iterator itr4 = entry.getValue().iterator();
                                while (itr4.hasNext()) {
                                    Object[] next = (Object[]) itr4.next();
                                    Cell cell7 = row7.createCell(m);
                                    String lastOut = "" + next[1];
                                    if (lastOut.contains("!")) {
                                        String[] lastOut1 = lastOut.split("`");
                                        String[] lastOut2 = lastOut1[1].split("!");
                                        String[] lastOut3 = lastOut.split("!");
                                        String[] lastOut4 = lastOut3[1].split("@");
                                        Date lout = sdf1.parse(lastOut4[0]);
                                        Date fin = sdf1.parse(lastOut2[0]);
                                        if (lout.equals(fin)) {
                                            cell7.setCellValue("-");
                                        } else {
                                            cell7.setCellValue("" + lastOut4[0]);
                                        }

                                    } else if (lastOut.contains("@")) {
                                        cell7.setCellValue("-");
                                    }
                                    CellUtil.setAlignment(cell7, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    m++;
                                }
                                rownum = rownum + 1;
                                Row row8 = firstSheet.createRow(rownum);
                                Cell cellTitle4 = row8.createCell(0);
                                cellTitle4.setCellValue("First Half");
                                cellTitle4.setCellStyle(styleBold);
                                Iterator itr5 = entry.getValue().iterator();
                                int firstCounter = 0;
                                while (itr5.hasNext()) {
                                    Object[] next = (Object[]) itr5.next();
                                    Cell cell8 = row8.createCell(n);
                                    String firstHalf = "" + next[1];
                                    int firstHalfVal = 0;
                                    int counter = 0;

                                    if (firstHalf.contains("fullday")) {
                                        cell8.setCellValue("PR");
                                        prcounter = prcounter + 0.5;
                                        cell8.setCellStyle(stylegreen);

                                    } else if (!firstHalf.contains("fullday") && !firstHalf.equals("WO") && !firstHalf.equals("TR") && !firstHalf.equals("AR") && !firstHalf.equals("AB") && !firstHalf.contains("?")
                                            && !firstHalf.equals("Casual Leave") && !firstHalf.equals("Short Leave") && !firstHalf.equals("C Off Leave") && !firstHalf.equals("Privilege Leave") && !firstHalf.equals("Sick Leave")
                                            && !firstHalf.equals("Paternity Leave") && !firstHalf.equals("Maternity Leave") && !firstHalf.equals("Leave Without Pay")) {
                                        String[] leave = firstHalf.split("@");
                                        String[] leave1 = leave[1].split("#");
                                        String[] userTimeInStr = firstHalf.split("`");
                                        String[] userTimeInStr1 = userTimeInStr[1].split("!");
                                        String[] userTimeOutStr = firstHalf.split("!");
                                        String[] userTimeOutStr1 = userTimeOutStr[1].split("@");
                                        String[] LateHoursStr = firstHalf.split("\\$");
                                        String[] LateHoursStr1 = LateHoursStr[1].split("%");
                                        String[] endHoursStr = firstHalf.split("%");
                                        String[] endHoursStr1 = endHoursStr[1].split("\\^");
                                        String[] firstStartHoursStr = endHoursStr[1].split("\\+");
                                        Date userTimeIn = sdf1.parse(userTimeInStr1[0]);
                                        Date userTimeOut = sdf1.parse(userTimeOutStr1[0]);
                                        Date LateHours = sdf1.parse(LateHoursStr1[0]);
                                        Date endHours = sdf1.parse(endHoursStr1[0]);
                                        Date firstStartHours = sdf1.parse(firstStartHoursStr[1]);
                                        if (userTimeIn != null) {
                                            if ((userTimeIn.before(firstStartHours) || userTimeIn.equals(firstStartHours)) && (userTimeOut.after(endHours) || userTimeOut.equals(endHours))) {
                                                cell8.setCellValue("PR");
                                                prcounter = prcounter + 0.5;
                                                cell8.setCellStyle(stylegreen);
                                            } else if (leave1[0] != null && !leave1[0].contains("Short Leave")) {
                                                if ((userTimeIn.before(LateHours) || userTimeIn.equals(LateHours)) && (userTimeOut.after(endHours) || userTimeOut.equals(endHours)) && firstCounter <= 31) {
                                                    cell8.setCellValue("PR");
                                                    prcounter = prcounter + 0.5;
                                                    firstCounter = firstCounter + 1;
                                                    cell8.setCellStyle(stylegreen);
                                                } else if (leave1[0].contains("AB")) {
                                                    cell8.setCellValue("AB");
                                                    abcounter = abcounter + 0.5;
                                                    cell8.setCellStyle(stylered);
                                                } else if (leave1[0].contains("AR")) {
                                                    cell8.setCellValue("AR/P");
                                                    ar = ar + 0.5;
                                                    cell8.setCellStyle(styleblue);
                                                }

                                            } else if (null != leave1[0] && leave1[0].contains("Short Leave")) {
                                                if (firstHalf.contains("*")) {
                                                    String[] shortArray = firstHalf.split("\\*");
                                                    String[] endArray = shortArray[1].split("\\-");
                                                    String[] startTime = endArray[1].split("\\+");
                                                    Date shortIn = sdf1.parse(shortArray[1]);
                                                    Date shortend = sdf1.parse(endArray[1]);
                                                    Date startTime1 = sdf1.parse(startTime[1]);
                                                    if (shortIn.before(endHours)) {
                                                        cell8.setCellValue("SHL/P");
                                                        cell8.setCellStyle(stylegreen);
                                                        shl = shl + 1;
                                                    } else if (leave1[0].contains("~ AR")) {
                                                        cell8.setCellValue("AR/P");
                                                        ar = ar + 0.5;
                                                        cell8.setCellStyle(styleblue);
                                                    } else if (userTimeIn.after(endHours)) {
                                                        cell8.setCellValue("SHL/A");
                                                        shla = shla + 1;
                                                        cell8.setCellStyle(stylered);
                                                    } else if ((userTimeIn.before(LateHours) || userTimeIn.equals(LateHours)) && (userTimeOut.after(endHours) || userTimeOut.equals(endHours)) && firstCounter <= 31) {
                                                        cell8.setCellValue("PR");
                                                        prcounter = prcounter + 0.5;
                                                        firstCounter = firstCounter + 1;
                                                        cell8.setCellStyle(stylegreen);
                                                    } else {
                                                        cell8.setCellValue("AB");
                                                        abcounter = abcounter + 0.5;
                                                        cell8.setCellStyle(stylered);
                                                    }
                                                } else {
                                                    cell8.setCellValue("AB");
                                                    abcounter = abcounter + 0.5;
                                                    cell8.setCellStyle(stylered);
                                                }
                                            } else if (null != leave1[0] && !leave1[0].contains("AB")) {
                                                if (leave1[0].contains("Casual Leave")) {
                                                    cl = cl + 0.5;
                                                }
                                                if (leave1[0].contains("Privilege Leave")) {
                                                    pl = pl + 0.5;
                                                }
                                                if (leave1[0].contains("Sick Leave")) {
                                                    sl = sl + 0.5;
                                                }
                                                cell8.setCellValue(" " + leave1[0]);

                                            } else if (leave1[0].contains("AB")) {
                                                cell8.setCellValue("-");
                                            } else {
                                                cell8.setCellValue("AB");
                                                abcounter = abcounter + 0.5;
                                                cell8.setCellStyle(stylered);
                                            }

                                        } else if (userTimeIn != null && !firstHalf.contains("WO") && !firstHalf.contains("?")) {
                                            cell8.setCellValue("AB");
                                            abcounter = abcounter + 0.5;
                                            cell8.setCellStyle(stylered);
                                        } else if (firstHalf.contains("WO") || firstHalf.contains("?")) {
                                            cell8.setCellValue("-");
                                        }

                                    } else if (firstHalf.equals("WO")) {
                                        cell8.setCellValue("");
                                    } else if (firstHalf.contains("AR")) {
                                        cell8.setCellValue("AR/P");
                                        ar = ar + 0.5;
                                        cell8.setCellStyle(styleblue);
                                    } else if (firstHalf.equals("AB")) {
                                        cell8.setCellValue("AB");
                                        abcounter = abcounter + 0.5;
                                        cell8.setCellStyle(stylered);
                                    }
                                    CellUtil.setAlignment(cell8, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    n++;
                                }

                                rownum = rownum + 1;
                                Row row9 = firstSheet.createRow(rownum);
                                Cell cellTitle5 = row9.createCell(0);
                                cellTitle5.setCellValue("Second Half");
                                cellTitle5.setCellStyle(styleBold);
                                int weekNameCounter = 0;
                                boolean satWeekOff = false;
                                Iterator itr6 = entry.getValue().iterator();
                                while (itr6.hasNext()) {
                                    Object[] next = (Object[]) itr6.next();
                                    Cell cell9 = row9.createCell(o);
                                    String secondHalf = "" + next[1];
                                    int firstHalfVal = 0;
                                    int counter = 0;
                                    String shiftName = "";
                                    if (secondHalf.contains(" # ")) {
                                        String[] string1 = secondHalf.split("#");
                                        String[] string2 = string1[1].split("\\$");
                                        shiftName = string2[0].trim();

                                    }

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

                                    if (satWeekOff == true && (zydexLocationMaster.getZydexLocation().equals("HO") || zydexLocationMaster.getZydexLocation().equals("R&D"))) {
                                        cell9.setCellValue("WO");
                                        wo = wo + 0.5;
                                    } else if (secondHalf.contains("fullday")) {
                                        cell9.setCellValue("PR");
                                        prcounter = prcounter + 0.5;
                                        cell9.setCellStyle(stylegreen);

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

                                        Date userTimeIn = sdf1.parse(userTimeInStr1[0]);
                                        Date userTimeOut = sdf1.parse(userTimeOutStr1[0]);

                                        String[] getInHours = userTimeInStr1[0].split(":");
                                        String[] getOutHours = userTimeOutStr1[0].split(":");
                                        String abc = getInHours[0].trim();
                                        String xyz = getOutHours[0].trim();
                                        int i11 = Integer.parseInt(abc) - Integer.parseInt(xyz);
                                        int totalDuration = 24 - i11;
                                        String totalDuration2 = getOutHours[0];
                                        Date endHours = sdf1.parse(endHoursStr[1]);
                                        Date secondHalfTimeStr2 = sdf1.parse(secondHalfTimeStr1[0]);

                                        if (userTimeIn != null) {
                                            if ((userTimeIn.before(secondHalfTimeStr2) || userTimeIn.equals(secondHalfTimeStr2)) && (userTimeOut.after(endHours) || userTimeOut.equals(endHours))) {
                                                cell9.setCellValue("PR");
                                                prcounter = prcounter + 0.5;
                                                cell9.setCellStyle(stylegreen);
                                            } else if (shiftName.contains("Night") && (userTimeOut.after(endHours) || userTimeOut.equals(endHours))) {
                                                cell9.setCellValue("PR");
                                                prcounter = prcounter + 0.5;
                                                cell9.setCellStyle(stylegreen);
                                            } else if (null != leave1[0] && leave1[0].contains("Short Leave")) {
                                                if (secondHalf.contains("*")) {
                                                    String[] shortArray = secondHalf.split("\\*");
                                                    String[] endArray = secondHalf.split("\\^");
                                                    String[] secondhalfstartTime = endArray[1].split("&");
                                                    Date shortIn = sdf1.parse(shortArray[1]);
                                                    Date shortend = sdf1.parse(endArray[1]);
                                                    Date secondhalfstartTime1 = sdf1.parse(secondhalfstartTime[0]);
                                                    if ((secondhalfstartTime1.before(shortIn) || secondhalfstartTime1.equals(shortIn)) && (shortIn.before(endHours) || shortIn.equals(endHours))) {
                                                        if (userTimeOut.after(secondHalfTimeStr2)) {
                                                            cell9.setCellValue("SHL/P");
                                                            shl = shl + 1;
                                                            cell9.setCellStyle(stylegreen);
                                                        } else if (leave1[0].contains("~ AR")) {
                                                            cell9.setCellValue("AR/P");
                                                            ar = ar + 0.5;
                                                            cell9.setCellStyle(styleblue);
                                                        } else if (userTimeOut.before(secondHalfTimeStr2) || userTimeOut.equals(secondHalfTimeStr2)) {
                                                            cell9.setCellValue("SHL/A");
                                                            shla = shla + 1;
                                                            cell9.setCellStyle(stylered);
                                                        } else {
                                                            cell9.setCellValue("AB");
                                                            abcounter = abcounter + 0.5;
                                                            cell9.setCellStyle(stylered);
                                                        }
                                                    }
                                                } else {
                                                    cell9.setCellValue("AB");
                                                    abcounter = abcounter + 0.5;
                                                    cell9.setCellStyle(stylered);
                                                }
                                            } else if (null != leave1[0] && !leave1[0].contains("AB") && !leave1[0].contains("AR")) {
                                                if (leave1[0].contains("Casual Leave")) {
                                                    cl = cl + 0.5;
                                                }
                                                if (leave1[0].contains("Privilege Leave")) {
                                                    pl = pl + 0.5;
                                                }
                                                if (leave1[0].contains("Sick Leave")) {
                                                    sl = sl + 0.5;
                                                }
                                                cell9.setCellValue(" " + leave1[0]);

                                            } else if (leave1[0].contains("AR")) {
                                                cell9.setCellValue("AR/P");
                                                ar = ar + 0.5;
                                                cell9.setCellStyle(styleblue);
                                            } else if (leave1[0].contains("AB")) {
                                                cell9.setCellValue("AB");
                                                abcounter = abcounter + 0.5;
                                                cell9.setCellStyle(stylered);
                                            } else {
                                                cell9.setCellValue("AB");
                                                abcounter = abcounter + 0.5;
                                                cell9.setCellStyle(stylered);
                                            }

                                        } else if (userTimeIn != null && !secondHalf.contains("WO") && !secondHalf.contains("?")) {
                                            cell9.setCellValue("AB");
                                            abcounter = abcounter + 0.5;
                                            cell9.setCellStyle(stylered);
                                        } else if (secondHalf.contains("WO") || secondHalf.contains("?")) {
                                            cell9.setCellValue("-");
                                        }

                                    } else if (secondHalf.equals("WO")) {
                                        cell9.setCellValue("-");
                                    } else if (secondHalf.contains("AR")) {
                                        cell9.setCellValue("AR/P");
                                        ar = ar + 0.5;
                                        cell9.setCellStyle(styleblue);
                                    } else if (secondHalf.equals("AB")) {
                                        cell9.setCellValue("AB");
                                        abcounter = abcounter + 0.5;
                                        cell9.setCellStyle(stylered);
                                    }
                                    CellUtil.setAlignment(cell9, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    o++;
                                }

                            }
                            rownum = rownum + 1;
                            Row dayCount1 = firstSheet.createRow(rownum);
                            rownum = rownum + 1;
                            Row dayCount = firstSheet.createRow(rownum);
                            Cell dayCounrCell = dayCount.createCell(0);
                            dayCounrCell.setCellValue("Day Count");
                            dayCounrCell.setCellStyle(styleBold);

                            rownum = rownum + 1;
                            Row row13 = firstSheet.createRow(rownum);
                            for (int y = 1; y < 10;) {
                                if (prcounter != 0) {
                                    Cell cell12 = row13.createCell(y);
                                    cell12.setCellValue("PR");
                                    cell12.setCellStyle(stylegreen);
                                    CellUtil.setAlignment(cell12, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    y++;
                                }
                                if (abcounter != 0) {
                                    Cell cell13 = row13.createCell(y);
                                    cell13.setCellValue("AB");
                                    cell13.setCellStyle(stylered);
                                    CellUtil.setAlignment(cell13, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    y++;
                                }
                                if (shl != 0) {
                                    Cell cell14 = row13.createCell(y);
                                    cell14.setCellValue("SHL/P");
                                    cell14.setCellStyle(stylegreen);
                                    CellUtil.setAlignment(cell14, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    y++;
                                }
                                if (shla != 0) {
                                    Cell cell15 = row13.createCell(y);
                                    cell15.setCellValue("SHL/A");
                                    cell15.setCellStyle(stylered);
                                    CellUtil.setAlignment(cell15, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    y++;
                                }
                                if (cl != 0) {
                                    Cell cell16 = row13.createCell(y);
                                    cell16.setCellValue("CL");
                                    cell16.setCellStyle(styleBold);
                                    CellUtil.setAlignment(cell16, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    y++;
                                }
                                if (sl != 0) {
                                    Cell cell17 = row13.createCell(y);
                                    cell17.setCellValue("SL");
                                    cell17.setCellStyle(styleBold);
                                    CellUtil.setAlignment(cell17, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    y++;
                                }
                                if (pl != 0) {
                                    Cell cell18 = row13.createCell(y);
                                    cell18.setCellValue("PL");
                                    cell18.setCellStyle(styleBold);
                                    CellUtil.setAlignment(cell18, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    y++;
                                }
                                if (holiday != 0) {
                                    Cell cell19 = row13.createCell(y);
                                    cell19.setCellValue("HOLIDAY");
                                    cell19.setCellStyle(styleBold);
                                    CellUtil.setAlignment(cell19, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    y++;
                                }
                                if (ar != 0) {
                                    Cell cell20 = row13.createCell(y);
                                    cell20.setCellValue("AR/P");
                                    cell20.setCellStyle(styleblue);
                                    CellUtil.setAlignment(cell20, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    y++;
                                }
                                if (wo != 0) {
                                    Cell cell21 = row13.createCell(y);
                                    cell21.setCellValue("WO");
                                    cell21.setCellStyle(styleBold);
                                    CellUtil.setAlignment(cell21, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    y++;
                                }
                                if (tr != 0) {
                                    Cell cell22 = row13.createCell(y);
                                    cell22.setCellValue("TR");
                                    cell22.setCellStyle(styleblue);
                                    CellUtil.setAlignment(cell22, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                }
                                break;
                            }

                            rownum = rownum + 1;
                            Row row12 = firstSheet.createRow(rownum);
                            for (int x = 1; x < 10;) {
                                if (prcounter != 0) {
                                    Cell cell12 = row12.createCell(x);
                                    cell12.setCellType(Cell.CELL_TYPE_NUMERIC);
                                    double newshl = shl / 2;
                                    double nepr = prcounter - newshl;
                                    cell12.setCellValue(nepr);
                                    CellUtil.setAlignment(cell12, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    x++;
                                }
                                if (abcounter != 0) {
                                    Cell cell13 = row12.createCell(x);
                                    cell13.setCellType(Cell.CELL_TYPE_NUMERIC);
                                    cell13.setCellValue(abcounter);
                                    CellUtil.setAlignment(cell13, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    x++;
                                }
                                if (shl != 0) {
                                    Cell cell14 = row12.createCell(x);
                                    cell14.setCellType(Cell.CELL_TYPE_NUMERIC);
                                    cell14.setCellValue(shl);
                                    CellUtil.setAlignment(cell14, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    x++;
                                }
                                if (shla != 0) {
                                    Cell cell15 = row12.createCell(x);
                                    cell15.setCellType(Cell.CELL_TYPE_NUMERIC);
                                    cell15.setCellValue(shla);
                                    CellUtil.setAlignment(cell15, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    x++;
                                }
                                if (cl != 0) {
                                    Cell cell16 = row12.createCell(x);
                                    cell16.setCellType(Cell.CELL_TYPE_NUMERIC);
                                    cell16.setCellValue(cl);
                                    CellUtil.setAlignment(cell16, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    x++;
                                }
                                if (sl != 0) {
                                    Cell cell17 = row12.createCell(x);
                                    cell17.setCellType(Cell.CELL_TYPE_NUMERIC);
                                    cell17.setCellValue(sl);
                                    CellUtil.setAlignment(cell17, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    x++;
                                }
                                if (pl != 0) {
                                    Cell cell18 = row12.createCell(x);
                                    cell18.setCellType(Cell.CELL_TYPE_NUMERIC);
                                    cell18.setCellValue(pl);
                                    CellUtil.setAlignment(cell18, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    x++;
                                }
                                if (holiday != 0) {
                                    Cell cell19 = row12.createCell(x);
                                    cell19.setCellType(Cell.CELL_TYPE_NUMERIC);
                                    cell19.setCellValue(holiday);
                                    CellUtil.setAlignment(cell19, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    x++;
                                }
                                if (ar != 0) {
                                    Cell cell20 = row12.createCell(x);
                                    cell20.setCellType(Cell.CELL_TYPE_NUMERIC);
                                    cell20.setCellValue(ar);
                                    CellUtil.setAlignment(cell20, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    x++;
                                }
                                if (wo != 0) {
                                    Cell cell21 = row12.createCell(x);
                                    cell21.setCellType(Cell.CELL_TYPE_NUMERIC);
                                    cell21.setCellValue(wo);
                                    CellUtil.setAlignment(cell21, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                    x++;
                                }
                                if (tr != 0) {
                                    Cell cell22 = row12.createCell(x);
                                    cell22.setCellType(Cell.CELL_TYPE_NUMERIC);
                                    cell22.setCellValue(tr);
                                    CellUtil.setAlignment(cell22, firstFWorkbook, CellStyle.ALIGN_CENTER);
                                }
                                break;
                            }
                        }
                    }

                }

                rownum++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }

        String appPath = request.getServletContext().getRealPath("");
        try {
            String filePath = appPath + File.separator + "StorageYard" + File.separator
                    + "Other" + File.separator + "UserDoc" + File.separator
                    + "EmployeeShiftData" + File.separator + "EmployeeAdvanceSearch.xls";
            FileOutputStream fos = new FileOutputStream(new File(filePath));
            HSSFCellStyle hsfstyle = firstFWorkbook.createCellStyle();
            hsfstyle.setBorderBottom((short) 1);
            hsfstyle.setFillBackgroundColor((short) 245);
            firstFWorkbook.write(fos);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String filePath = File.separator + "StorageYard" + File.separator
                + "Other" + File.separator + "UserDoc" + File.separator
                + "EmployeeShiftData" + File.separator + "EmployeeAdvanceSearch.xls";

        appPath = request.getServletContext().getRealPath("");

        String fullPath = appPath + filePath;

        request.setAttribute("filePath", fullPath);

        DownloadFile downloadFile = new DownloadFile();
        downloadFile.doDownload(request, response);
        mv = employeeDataSearch(request, response);
        return mv;
    }

    public ModelAndView employeeManualPunch(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Shift/EmployeeManualPunch");
        return mv;
    }

    public ModelAndView employeeManualPunchSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeShiftData employeeShiftData = new EmployeeShiftData();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeDatetimeData employeeDatetimeData1 = new EmployeeDatetimeData();

        String selectedDate = request.getParameter("punchDate");
        SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        SimpleDateFormat sdf4 = new SimpleDateFormat("dd/MM/yyyy");
        Format formatter = new SimpleDateFormat("dd/MM/YYYY");
        Date date1 = sdf4.parse(selectedDate);
        Date dateBefore = new Date(date1.getTime() - 24 * 60 * 60 * 1000);
        String yesterdayDate = formatter.format(dateBefore);

        List<?> empList = employeeDatetimeDataService.readEmployeeBySelectedDate(selectedDate);
        for (Object zz : empList) {
            try {

                employeeDatetimeData1 = (EmployeeDatetimeData) zz;
                employeeMaster.setId(employeeDatetimeData1.getEmployeeMaster().getId());

                ShiftGenerateMonthlySchedule shiftGenerateMonthlySchedule = new ShiftGenerateMonthlySchedule();

                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

                String[] s1 = selectedDate.split("/");
                String currentDays = s1[0];
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

                    String dynamicShiftDateTime = employeeDatetimeData1.getDateTime();
                    Date dynamicTime = sdf3.parse(dynamicShiftDateTime);

                    ShiftMaster generalShift = new ShiftMaster();
                    if (employeeMaster1.getZydexLocationMaster().getId().equals(1) && employeeMaster1.getZydexLocationMaster().getId().equals(6)) {
                        generalShift = shiftMasterService.readById(1);
                    } else {
                        generalShift = shiftMasterService.readById(6);
                    }
                    ShiftMaster firstShift = shiftMasterService.readById(3);
                    ShiftMaster secondShift = shiftMasterService.readById(4);
                    ShiftMaster nightShift = shiftMasterService.readById(5);

                    String generalShiftStartTime = selectedDate + " " + generalShift.getStartTime();
                    String firstShiftStartTime = selectedDate + " " + firstShift.getStartTime();
                    String secondShiftStartTime = selectedDate + " " + secondShift.getStartTime();
                    String nightShiftStartTime = selectedDate + " " + nightShift.getStartTime();
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
                        List<?> employeeYesterdayPunchData = employeeDatetimeDataService.readYesterdayEmployeeDataBySelectedDate("" + employeeMaster.getId(), yesterdayDate);

                        if (!employeeYesterdayPunchData.isEmpty()) {
                            EmployeeDatetimeData employeeDatetimeData = (EmployeeDatetimeData) employeeYesterdayPunchData.get(0);
                            EmployeeDatetimeData employeeDatetimeData2 = (EmployeeDatetimeData) employeeYesterdayPunchData.get(employeeYesterdayPunchData.size() - 1);
                            String startPunchTime = employeeDatetimeData.getDateTime();
                            String endPunchTime = employeeDatetimeData2.getDateTime();
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
                            if (employeeMaster1.getZydexLocationMaster().getId().equals(1) && employeeMaster1.getZydexLocationMaster().getId().equals(6)) {
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

                    employeeShiftPunchList = employeeDatetimeDataService.readTodaysAndPreviousDataOnSelectedDate("" + employeeMaster.getId(), newShiftTime, selectedDate, yesterdayDate);

                    for (Object o : employeeShiftPunchList) {
                        EmployeeDatetimeData employeeDatetimeData = (EmployeeDatetimeData) o;
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
                        dayWiseShiftList = employeeShiftDataService.getPastAndCurrentPunchForSelectedDate(employeeShiftData, newShiftTime, selectedDate, yesterdayDate);

                        if (!dayWiseShiftList.isEmpty()) {

                            SimpleDateFormat sdf111 = new SimpleDateFormat("dd/MM/yyyy");
                            employeeShiftData1 = (EmployeeShiftData) dayWiseShiftList.get(0);
                            employeeShiftData.setInDateTime(employeeShiftData1.getInDateTime());
                            String[] splited = employeeShiftData1.getOutDateTime().split(" ");
                            String[] splited1 = employeeDatetimeData.getDateTime().split(" ");
                            String spDate = splited[0];
                            Date inDate = sdf111.parse(spDate);
                            Date pDate = sdf111.parse(selectedDate);
                            String timeSplit = splited1[1].split(":")[0];

                            if (inDate.equals(pDate) && Integer.parseInt(timeSplit) > Integer.parseInt(newShiftTimeSplit)) {
                                if (dayWiseShiftList.size() > 1) {
                                    employeeShiftData1 = (EmployeeShiftData) dayWiseShiftList.get(1);
                                    employeeShiftData1.setInDateTime(employeeShiftData1.getInDateTime());
                                    employeeShiftData1.setOutDateTime(employeeDatetimeData.getDateTime());
                                    employeeShiftDataService.createOrUpdate(employeeShiftData1);
                                } else {
                                    employeeShiftData1.setInDateTime(employeeDatetimeData.getDateTime());
                                    employeeShiftData1.setOutDateTime(employeeDatetimeData.getDateTime());
                                    employeeShiftDataService.create(employeeShiftData1);
                                }
                            } else {
                                employeeShiftData1.setOutDateTime(employeeDatetimeData.getDateTime());
                                employeeShiftDataService.createOrUpdate(employeeShiftData1);
                            }
                        } else {
                            employeeShiftData1.setInDateTime(employeeDatetimeData.getDateTime());
                            employeeShiftData1.setOutDateTime(employeeDatetimeData.getDateTime());
                            employeeShiftDataService.createOrUpdate(employeeShiftData1);
                        }

                    }

                } else {
                    employeeShiftPunchList = employeeDatetimeDataService.readSelectedDateEmployeeData("" + employeeMaster.getId(), selectedDate);
                    for (Object o : employeeShiftPunchList) {
                        EmployeeDatetimeData employeeDatetimeData = (EmployeeDatetimeData) o;
                        EmployeeShiftData employeeShiftData1 = new EmployeeShiftData();
                        List dayWiseShiftList = new ArrayList();
                        employeeShiftData.setEmployeeMaster(employeeMaster);
                        employeeShiftData1.setEmployeeMaster(employeeMaster);
                        employeeShiftData1.setShiftMaster(shiftMaster1);
                        dayWiseShiftList = employeeShiftDataService.dailyTimeEntryForSelectedDate(employeeShiftData, selectedDate);
                        if (!dayWiseShiftList.isEmpty()) {
                            employeeShiftData1 = (EmployeeShiftData) dayWiseShiftList.get(0);
                            employeeShiftData.setInDateTime(employeeShiftData1.getInDateTime());
                            employeeShiftData1.setOutDateTime(employeeDatetimeData.getDateTime());
                            employeeShiftDataService.createOrUpdate(employeeShiftData1);
                        } else {
                            employeeShiftData1.setInDateTime(employeeDatetimeData.getDateTime());
                            employeeShiftData1.setOutDateTime(employeeDatetimeData.getDateTime());
                            employeeShiftDataService.createOrUpdate(employeeShiftData1);
                        }

                    }

                }
            } catch (Exception e) {
                System.out.println("Exception" + e.getMessage());
            }
        }
        request.setAttribute("successMessage",
                "Information : The Selected Date Punch is Updated Successfully.");
        mv.setViewName("Shift/EmployeeManualPunch");
        return mv;
    }

}
