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
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.ehcache.util.counter.Counter;
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
import org.springframework.core.task.TaskExecutor;
import org.springframework.validation.BindException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Dhaval
 */
public class ShiftRotationMasterController1 extends ShiftRotationMasterAbstract {

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
                double clCurrent = 0;
                double clLast = 0;
                double slCurrent = 0;
                double slLast = 0;
                double mtl = 0;
                double ptl = 0;
                double coff = 0;
                double plCurrent = 0;
                double plLast = 0;
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
                List empMonthWiseCurrentLeave = null;
                for (Object o1 : empMonthWiseLeave) {
                    Object[] oArray = (Object[]) o1;
                    String leaveStr = "" + oArray[1];
                    empMonthWiseCurrentLeave.add(oArray[1]);
                    //                                    2nd Sat Week Off Codding
                    Calendar cal = Calendar.getInstance();
                    Date date = sdf.parse("" + oArray[0]);
                    cal.setTime(date);
                    SimpleDateFormat format = new SimpleDateFormat("EEEE");
                    String dayName = format.format(date);
                    int dayOfWeek = cal.get(Calendar.WEEK_OF_MONTH);
                    if (dayName.equals("Saturday") && (zydexLocationId.equals("6") || zydexLocationId.equals("1"))) {
                        if (dayOfWeek == 2) {
                            Calendar c1 = Calendar.getInstance();
                            c1.setTime(date);
                            c1.add(Calendar.DATE, +1);
                            SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy");
                            leaveEmployeeDetail.setStartDate("" + sdf3.format(c1.getTime()));
                            leaveEmployeeDetail.setEndDate("" + sdf3.format(c1.getTime()));
                            leaveEmployeeDetail.setEmployeeMaster(employeeMaster1);
                            leaveEmployeeDetail.setStatus(3);
                            List firstLeave = leaveEmployeeDetailService.readLeaveDetails(leaveEmployeeDetail);
                            if (firstLeave.isEmpty()) {
                                wo = wo + 1;
                            }
                            if (leaveStr.contains("Casual Leave")) {
                                clCurrent = clCurrent - 0.5;
                            }
                            if (leaveStr.contains("Privilege Leave")) {
                                plCurrent = plCurrent - 0.5;
                            }
                            if (leaveStr.contains("Sick Leave")) {
                                slCurrent = slCurrent - 0.5;
                            }
                            if (leaveStr.contains("Maternity Leave")) {
                                mtl = mtl - 0.5;
                            }
                            if (leaveStr.contains("Paternity Leave")) {
                                ptl = ptl - 0.5;
                            }
                            if (leaveStr.contains("C Off Leave")) {
                                coff = coff - 0.5;
                            }

                        }

                    }
                    //                                    2nd Sat Week Off Codding

                }
                List<?> empLastMonthWiseLeave = leaveEmployeeDetailService.searchLeaveApproveOfEmployeeByPreviousMonthWise(leaveEmployeeDetail);
                List empMonthWiseLastLeave = null;
                for (Object o1 : empLastMonthWiseLeave) {
                    Object[] oArray = (Object[]) o1;
                    String leaveStr = "" + oArray[1];
                    empMonthWiseLastLeave.add(oArray[1]);
                    //                                    2nd Sat Week Off Codding
                    Calendar cal = Calendar.getInstance();
                    Date date = sdf.parse("" + oArray[0]);
                    cal.setTime(date);
                    SimpleDateFormat format = new SimpleDateFormat("EEEE");
                    String dayName = format.format(date);
                    int dayOfWeek = cal.get(Calendar.WEEK_OF_MONTH);
                    if (dayName.equals("Saturday") && (zydexLocationId.equals("6") || zydexLocationId.equals("1"))) {
                        if (dayOfWeek == 2) {
                            Calendar c1 = Calendar.getInstance();
                            c1.setTime(date);
                            c1.add(Calendar.DATE, +1);
                            SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy");
                            leaveEmployeeDetail.setStartDate("" + sdf3.format(c1.getTime()));
                            leaveEmployeeDetail.setEndDate("" + sdf3.format(c1.getTime()));
                            leaveEmployeeDetail.setEmployeeMaster(employeeMaster1);
                            leaveEmployeeDetail.setStatus(3);
                            List firstLeave = leaveEmployeeDetailService.readLeaveDetails(leaveEmployeeDetail);
                            if (firstLeave.isEmpty()) {
                                wo = wo + 1;
                            }
                            if (leaveStr.contains("Casual Leave")) {
                                clLast = clLast - 0.5;
                            }
                            if (leaveStr.contains("Privilege Leave")) {
                                plLast = plLast - 0.5;
                            }
                            if (leaveStr.contains("Sick Leave")) {
                                slLast = slLast - 0.5;
                            }
                            if (leaveStr.contains("Maternity Leave")) {
                                mtl = mtl - 0.5;
                            }
                            if (leaveStr.contains("Paternity Leave")) {
                                ptl = ptl - 0.5;
                            }
                            if (leaveStr.contains("C Off Leave")) {
                                coff = coff - 0.5;
                            }

                        }

                    }
                    //                                    2nd Sat Week Off Codding

                }
                List<?> attendanceRegularizationCurMonth = attendanceRegularizationMasterService.searchLeaveApproveOfEmployeeByMonthWise(attendanceRegularization);
                List<?> attendanceRegularizationPreMonth = attendanceRegularizationMasterService.searchLeaveApproveOfEmployeeByPreviousMonthWise(attendanceRegularization);
                List<?> travelCurrentMonthList = travelRequestMasterService.searchTravelApproveOfEmployeeByCurrentMonthWise(travelRequestMaster);
                List<?> travelPreviousMonthList = travelRequestMasterService.searchTravelApproveOfEmployeeByPreviousMonthWise(travelRequestMaster);
                holidayList.add("" + holidayCount);
                li.add(holidayList);
                li.add(empMonthWiseCurrentLeave);
                li.add(empMonthWiseLastLeave);
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
                                } else if (userTimeOut.before(userTimeIn)) {
                                    diff1 = userTimeOut1.getTime() - flexibleInTime.getTime();
                                } else {
                                    diff1 = userTimeOut.getTime() - flexibleInTime.getTime();
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
                double cOff = coff;
                double casualLastCount = clLast;
                double casualCurrentCount = clCurrent;
                double sickLastCount = slLast;
                double sickCurrentCount = slCurrent;
                double privilegeLastCount = plLast;
                double privilegeCurrentCount = plCurrent;
                double paternityCount = ptl;
                double maternityCount = mtl;
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
    
    
      public ModelAndView employeeMonthlyPayrollReport123(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
                double clCurrent = 0;
                double clLast = 0;
                double slCurrent = 0;
                double slLast = 0;
                double mtl = 0;
                double ptl = 0;
                double coff = 0;
                double plCurrent = 0;
                double plLast = 0;
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
                List empMonthWiseCurrentLeave = new ArrayList();
                for (Object o1 : empMonthWiseLeave) {
                    Object[] oArray = (Object[]) o1;
                    String leaveStr = "" + oArray[1];
                    empMonthWiseCurrentLeave.add(oArray[1]);
                    //                                    2nd Sat Week Off Codding
                    Calendar cal = Calendar.getInstance();
                    Date date = sdf.parse("" + oArray[0]);
                    cal.setTime(date);
                    SimpleDateFormat format = new SimpleDateFormat("EEEE");
                    String dayName = format.format(date);
                    int dayOfWeek = cal.get(Calendar.WEEK_OF_MONTH);
                    if (dayName.equals("Saturday") && (zydexLocationId.equals("6") || zydexLocationId.equals("1"))) {
                        if (dayOfWeek == 2) {
                            Calendar c1 = Calendar.getInstance();
                            c1.setTime(date);
                            c1.add(Calendar.DATE, +1);
                            SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy");
                            leaveEmployeeDetail.setStartDate("" + sdf3.format(c1.getTime()));
                            leaveEmployeeDetail.setEndDate("" + sdf3.format(c1.getTime()));
                            leaveEmployeeDetail.setEmployeeMaster(employeeMaster1);
                            leaveEmployeeDetail.setStatus(3);
                            List firstLeave = leaveEmployeeDetailService.readLeaveDetails(leaveEmployeeDetail);
                            if (firstLeave.isEmpty()) {
                                wo = wo + 1;
                            }
                            if (leaveStr.contains("Casual Leave")) {
                                clCurrent = clCurrent - 0.5;
                            }
                            if (leaveStr.contains("Privilege Leave")) {
                                plCurrent = plCurrent - 0.5;
                            }
                            if (leaveStr.contains("Sick Leave")) {
                                slCurrent = slCurrent - 0.5;
                            }
                            if (leaveStr.contains("Maternity Leave")) {
                                mtl = mtl - 0.5;
                            }
                            if (leaveStr.contains("Paternity Leave")) {
                                ptl = ptl - 0.5;
                            }
                            if (leaveStr.contains("C Off Leave")) {
                                coff = coff - 0.5;
                            }

                        }

                    }
                    //                                    2nd Sat Week Off Codding

                }
                List<?> empLastMonthWiseLeave = leaveEmployeeDetailService.searchLeaveApproveOfEmployeeByPreviousMonthWise(leaveEmployeeDetail);
                List empMonthWiseLastLeave = new ArrayList();
                for (Object o1 : empLastMonthWiseLeave) {
                    Object[] oArray = (Object[]) o1;
                    String leaveStr = "" + oArray[1];
                    empMonthWiseLastLeave.add(oArray[1]);
                    //                                    2nd Sat Week Off Codding
                    Calendar cal = Calendar.getInstance();
                    Date date = sdf.parse("" + oArray[0]);
                    cal.setTime(date);
                    SimpleDateFormat format = new SimpleDateFormat("EEEE");
                    String dayName = format.format(date);
                    int dayOfWeek = cal.get(Calendar.WEEK_OF_MONTH);
                    if (dayName.equals("Saturday") && (zydexLocationId.equals("6") || zydexLocationId.equals("1"))) {
                        if (dayOfWeek == 2) {
                            Calendar c1 = Calendar.getInstance();
                            c1.setTime(date);
                            c1.add(Calendar.DATE, +1);
                            SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy");
                            leaveEmployeeDetail.setStartDate("" + sdf3.format(c1.getTime()));
                            leaveEmployeeDetail.setEndDate("" + sdf3.format(c1.getTime()));
                            leaveEmployeeDetail.setEmployeeMaster(employeeMaster1);
                            leaveEmployeeDetail.setStatus(3);
                            List firstLeave = leaveEmployeeDetailService.readLeaveDetails(leaveEmployeeDetail);
                            if (firstLeave.isEmpty()) {
                                wo = wo + 1;
                            }
                            if (leaveStr.contains("Casual Leave")) {
                                clLast = clLast - 0.5;
                            }
                            if (leaveStr.contains("Privilege Leave")) {
                                plLast = plLast - 0.5;
                            }
                            if (leaveStr.contains("Sick Leave")) {
                                slLast = slLast - 0.5;
                            }
                            if (leaveStr.contains("Maternity Leave")) {
                                mtl = mtl - 0.5;
                            }
                            if (leaveStr.contains("Paternity Leave")) {
                                ptl = ptl - 0.5;
                            }
                            if (leaveStr.contains("C Off Leave")) {
                                coff = coff - 0.5;
                            }

                        }

                    }
                    //                                    2nd Sat Week Off Codding

                }
                List<?> attendanceRegularizationCurMonth = attendanceRegularizationMasterService.searchLeaveApproveOfEmployeeByMonthWise(attendanceRegularization);
                List<?> attendanceRegularizationPreMonth = attendanceRegularizationMasterService.searchLeaveApproveOfEmployeeByPreviousMonthWise(attendanceRegularization);
                List<?> travelCurrentMonthList = travelRequestMasterService.searchTravelApproveOfEmployeeByCurrentMonthWise(travelRequestMaster);
                List<?> travelPreviousMonthList = travelRequestMasterService.searchTravelApproveOfEmployeeByPreviousMonthWise(travelRequestMaster);
                holidayList.add("" + holidayCount);
                li.add(holidayList);
                li.add(empMonthWiseCurrentLeave);
                li.add(empMonthWiseLastLeave);
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
                                } else if (userTimeOut.before(userTimeIn)) {
                                    diff1 = userTimeOut1.getTime() - flexibleInTime.getTime();
                                } else {
                                    diff1 = userTimeOut.getTime() - flexibleInTime.getTime();
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
                double cOff = coff;
                double casualLastCount = clLast;
                double casualCurrentCount = clCurrent;
                double sickLastCount = slLast;
                double sickCurrentCount = slCurrent;
                double privilegeLastCount = plLast;
                double privilegeCurrentCount = plCurrent;
                double paternityCount = ptl;
                double maternityCount = mtl;
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


}
