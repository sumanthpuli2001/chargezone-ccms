/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Dashboard;

import com.bul.zydex.model.GroupCategory;
import com.bul.zydex.model.GroupMaster;
import com.bul.zydex.model.GroupSubCategory;
import com.bul.zydex.model.PRMaster;
import com.bul.zydex.model.TenderMaster;
import com.bul.zydex.model.UserMaster;
import com.bul.zydex.model.UserRights;
import com.bul.zydex.model.VendorInformation;
import com.bul.zydex.util.DownloadFile;
import com.google.gson.Gson;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Mayur Mishra
 */
public class DashboardController extends DashboardAbstract {

    public ModelAndView tenderDashboard(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String btn = request.getParameter("btn");

        if (btn == null || btn == "") {
            btn = "0";
        }

        String Fromdate = request.getParameter("Fromdate");
        String Todate = request.getParameter("Todate");
        String Filter = request.getParameter("Filter");
        String Department = request.getParameter("Department");
        List list0 = departmentMasterService.read();

        int prRaised = 0;
        int underApproval = 0;
        int livePr = 0;
        int prValue = 0;
        int tendercount = 0;
        int tenderclosed = 0;
        int tenderclosedByForce = 0;
        int totalClosePr = 0;
        int tenderLive = 0;
        int assignbuyer = 0;
        int pendassign = 0;
        int approve = 0;
        int rejectedPr = 0;

        if (btn.equals("1")) {

            String formattedDate = "";
            String formattedStartDate = "";
            try {
                if (Filter.equals("last-month")) {
                    LocalDateTime myDateObj = LocalDateTime.now();
                    LocalDateTime startDate = myDateObj.minusDays(30);

                    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                    formattedDate = myDateObj.format(myFormatObj);
                    formattedStartDate = startDate.format(myFormatObj);
                }
                if (Filter.equals("last-week")) {
                    LocalDateTime myDateObj = LocalDateTime.now();
                    LocalDateTime startDate = myDateObj.minusDays(7);

                    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                    formattedDate = myDateObj.format(myFormatObj);
                    formattedStartDate = startDate.format(myFormatObj);
                }
                if (Filter.equals("last-year")) {
                    LocalDateTime myDateObj = LocalDateTime.now();
                    LocalDateTime startDate = myDateObj.minusDays(365);

                    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                    formattedDate = myDateObj.format(myFormatObj);
                    formattedStartDate = startDate.format(myFormatObj);
                }
                if (Filter.equals("last-6-month")) {
                    LocalDateTime myDateObj = LocalDateTime.now();
                    LocalDateTime startDate = myDateObj.minusDays(183);

                    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                    formattedDate = myDateObj.format(myFormatObj);
                    formattedStartDate = startDate.format(myFormatObj);
                }
            } catch (Exception e) {

            }

            mv.getModelMap().put("Fromdate", Fromdate);
            mv.getModelMap().put("Todate", Todate);
            mv.getModelMap().put("Filter", Filter);
            mv.getModelMap().put("Department", Department);

//            Total Pr
            prRaised = prMasterService.readByDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);

//            flag == 0 ||  // Under Approval 
            underApproval = prMasterService.readByDateformate1(Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);

//            flag = 0,6 ||  Live PR
            livePr = prMasterService.readByDateformate2(Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);

            //flag = 3 ||  Rejected pr
            rejectedPr = prMasterService.countRejectedPrFilter(Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);

//            List list15 = prMasterService.readByDateformate3(Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
//             Assign Buyer || 
            assignbuyer = prMasterService.readByDateformate4(Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);

//            Pending to assign  
            pendassign = prMasterService.readByDateformate5(Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);

//            Tender Pending to Float
            approve = prMasterService.readByDateformate6(Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);

//            Tender created || total
            tendercount = tenderMasterService.readByDate(Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);

//            Tender closed
            tenderclosed = tenderMasterService.readByDate2(Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);

            // tender close by force
            tenderclosedByForce = tenderMasterService.readBydeleteFlagFilter(Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);

            //totalClosePr
            totalClosePr = prMasterService.totalClosePr(Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);

            // Live Tender
            tenderLive = tenderMasterService.readByDate1(Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);

            List monthWiseList1 = prMasterService.monthWiseListPrFilter(Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);

            String prmonthName1 = "";
            String prnumberOfValue1 = "";

            String prmonthName2 = "";
            String prnumberOfValue2 = "";

            String prmonthName3 = "";
            String prnumberOfValue3 = "";

            String prmonthName4 = "";
            String prnumberOfValue4 = "";

            String prmonthName5 = "";
            String prnumberOfValue5 = "";

            String prmonthName6 = "";
            String prnumberOfValue6 = "";

            String prmonthName7 = "";
            String prnumberOfValue7 = "";

            String prmonthName8 = "";
            String prnumberOfValue8 = "";

            String prmonthName9 = "";
            String prnumberOfValue9 = "";

            String prmonthName10 = "";
            String prnumberOfValue10 = "";

            String prmonthName11 = "";
            String prnumberOfValue11 = "";

            String prmonthName12 = "";
            String prnumberOfValue12 = "";

            int i3 = 0;

            for (Object empId2 : monthWiseList1) {
                i3++;

                Object[] obj = (Object[]) empId2;
                if (i3 == 1) {
                    prnumberOfValue1 = "" + obj[0];
                    prmonthName1 = "" + obj[1];
                }
                if (i3 == 2) {
                    prnumberOfValue2 = "" + obj[0];
                    prmonthName2 = "" + obj[1];
                }
                if (i3 == 3) {
                    prnumberOfValue3 = "" + obj[0];
                    prmonthName3 = "" + obj[1];
                }
                if (i3 == 4) {
                    prnumberOfValue4 = "" + obj[0];
                    prmonthName4 = "" + obj[1];
                }
                if (i3 == 5) {
                    prnumberOfValue5 = "" + obj[0];
                    prmonthName5 = "" + obj[1];

                }

                if (i3 == 6) {
                    prnumberOfValue6 = "" + obj[0];
                    prmonthName6 = "" + obj[1];
                }
                if (i3 == 7) {
                    prnumberOfValue7 = "" + obj[0];
                    prmonthName7 = "" + obj[1];
                }
                if (i3 == 8) {
                    prnumberOfValue8 = "" + obj[0];
                    prmonthName8 = "" + obj[1];
                }
                if (i3 == 9) {
                    prnumberOfValue9 = "" + obj[0];
                    prmonthName9 = "" + obj[1];
                }
                if (i3 == 10) {
                    prnumberOfValue10 = "" + obj[0];
                    prmonthName10 = "" + obj[1];
                }
                if (i3 == 11) {
                    prnumberOfValue11 = "" + obj[0];
                    prmonthName11 = "" + obj[1];
                }
                if (i3 == 12) {
                    prnumberOfValue12 = "" + obj[0];
                    prmonthName12 = "" + obj[1];
                    break;
                }

            }

//         List list4 = prMasterService.approvedPRListDashboad();
            mv.getModelMap().put("prmonthName1", prmonthName1);
            mv.getModelMap().put("prnumberOfValue1", prnumberOfValue1);
            mv.getModelMap().put("prmonthName2", prmonthName2);
            mv.getModelMap().put("prnumberOfValue2", prnumberOfValue2);
            mv.getModelMap().put("prmonthName3", prmonthName3);
            mv.getModelMap().put("prnumberOfValue3", prnumberOfValue3);
            mv.getModelMap().put("prmonthName4", prmonthName4);
            mv.getModelMap().put("prnumberOfValue4", prnumberOfValue4);
            mv.getModelMap().put("prmonthName5", prmonthName5);
            mv.getModelMap().put("prnumberOfValue5", prnumberOfValue5);
            mv.getModelMap().put("prmonthName6", prmonthName6);
            mv.getModelMap().put("prnumberOfValue6", prnumberOfValue6);
            mv.getModelMap().put("prmonthName7", prmonthName7);
            mv.getModelMap().put("prnumberOfValue7", prnumberOfValue7);
            mv.getModelMap().put("prmonthName8", prmonthName8);
            mv.getModelMap().put("prnumberOfValue8", prnumberOfValue8);
            mv.getModelMap().put("prmonthName9", prmonthName9);
            mv.getModelMap().put("prnumberOfValue9", prnumberOfValue9);
            mv.getModelMap().put("prmonthName10", prmonthName10);
            mv.getModelMap().put("prnumberOfValue10", prnumberOfValue10);
            mv.getModelMap().put("prmonthName11", prmonthName11);
            mv.getModelMap().put("prnumberOfValue11", prnumberOfValue11);
            mv.getModelMap().put("prmonthName12", prmonthName12);
            mv.getModelMap().put("prnumberOfValue12", prnumberOfValue12);

            // Month Wise Tender Data
            List monthWiseList = tenderMasterService.readByMonthFilter(Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);

            String monthName1 = "";
            String numberOfValue1 = "";

            String monthName2 = "";
            String numberOfValue2 = "";

            String monthName3 = "";
            String numberOfValue3 = "";

            String monthName4 = "";
            String numberOfValue4 = "";

            String monthName5 = "";
            String numberOfValue5 = "";

            String monthName6 = "";
            String numberOfValue6 = "";

            String monthName7 = "";
            String numberOfValue7 = "";

            String monthName8 = "";
            String numberOfValue8 = "";

            String monthName9 = "";
            String numberOfValue9 = "";

            String monthName10 = "";
            String numberOfValue10 = "";

            String monthName11 = "";
            String numberOfValue11 = "";

            String monthName12 = "";
            String numberOfValue12 = "";

            int i2 = 0;

            for (Object empId1 : monthWiseList) {
                i2++;

                Object[] obj = (Object[]) empId1;
                if (i2 == 1) {
                    numberOfValue1 = "" + obj[0];
                    monthName1 = "" + obj[1];
                }
                if (i2 == 2) {
                    numberOfValue2 = "" + obj[0];
                    monthName2 = "" + obj[1];
                }
                if (i2 == 3) {
                    numberOfValue3 = "" + obj[0];
                    monthName3 = "" + obj[1];
                }
                if (i2 == 4) {
                    numberOfValue4 = "" + obj[0];
                    monthName4 = "" + obj[1];
                }
                if (i2 == 5) {
                    numberOfValue5 = "" + obj[0];
                    monthName5 = "" + obj[1];
                }
                if (i2 == 6) {
                    numberOfValue6 = "" + obj[0];
                    monthName6 = "" + obj[1];
                }
                if (i2 == 7) {
                    numberOfValue7 = "" + obj[0];
                    monthName7 = "" + obj[1];
                }
                if (i2 == 8) {
                    numberOfValue8 = "" + obj[0];
                    monthName8 = "" + obj[1];
                }
                if (i2 == 9) {
                    numberOfValue9 = "" + obj[0];
                    monthName9 = "" + obj[1];
                }
                if (i2 == 10) {
                    numberOfValue10 = "" + obj[0];
                    monthName10 = "" + obj[1];

                }
                if (i2 == 11) {
                    numberOfValue11 = "" + obj[0];
                    monthName11 = "" + obj[1];
                }
                if (i2 == 12) {
                    numberOfValue12 = "" + obj[0];
                    monthName12 = "" + obj[1];
                    break;
                }

            }

            mv.getModelMap().put("monthName1", monthName1);
            mv.getModelMap().put("numberOfValue1", numberOfValue1);
            mv.getModelMap().put("monthName2", monthName2);
            mv.getModelMap().put("numberOfValue2", numberOfValue2);
            mv.getModelMap().put("monthName3", monthName3);
            mv.getModelMap().put("numberOfValue3", numberOfValue3);
            mv.getModelMap().put("monthName4", monthName4);
            mv.getModelMap().put("numberOfValue4", numberOfValue4);
            mv.getModelMap().put("monthName5", monthName5);
            mv.getModelMap().put("numberOfValue5", numberOfValue5);
            mv.getModelMap().put("monthName6", monthName6);
            mv.getModelMap().put("numberOfValue6", numberOfValue6);
            mv.getModelMap().put("monthName7", monthName7);
            mv.getModelMap().put("numberOfValue7", numberOfValue7);
            mv.getModelMap().put("monthName8", monthName8);
            mv.getModelMap().put("numberOfValue8", numberOfValue8);
            mv.getModelMap().put("monthName9", monthName9);
            mv.getModelMap().put("numberOfValue9", numberOfValue9);
            mv.getModelMap().put("monthName10", monthName10);
            mv.getModelMap().put("numberOfValue10", numberOfValue10);
            mv.getModelMap().put("monthName11", monthName11);
            mv.getModelMap().put("numberOfValue11", numberOfValue11);
            mv.getModelMap().put("monthName12", monthName12);
            mv.getModelMap().put("numberOfValue12", numberOfValue12);

            // Tender master data
            List contwise = tenderMasterService.readBycontactperFilter(Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);

            String firstElement1_1 = "", firstElement1_2 = "", firstElement1_3 = "", firstElement1_4 = "";
            String secondElement1_1 = "", secondElement1_2 = "", secondElement1_3 = "", secondElement1_4 = "";
            String thirdElement1_1 = "", thirdElement1_2 = "", thirdElement1_3 = "", thirdElement1_4 = "";
            String fourthElement1_1 = "", fourthElement1_2 = "", fourthElement1_3 = "", fourthElement1_4 = "";
            String fifthElement1_1 = "", fifthElement1_2 = "", fifthElement1_3 = "", fifthElement1_4 = "";
            String sixthElement1_1 = "", sixthElement1_2 = "", sixthElement1_3 = "", sixthElement1_4 = "";
            String seventhElement1_1 = "", seventhElement1_2 = "", seventhElement1_3 = "", seventhElement1_4 = "";
            String eighthElement1_1 = "", eighthElement1_2 = "", eighthElement1_3 = "", eighthElement1_4 = "";
            String ninthElement1_1 = "", ninthElement1_2 = "", ninthElement1_3 = "", ninthElement1_4 = "";
            String tenthElement1_1 = "", tenthElement1_2 = "", tenthElement1_3 = "", tenthElement1_4 = "";
            int count = 0;

            for (Object o1 : contwise) {
                Object[] o11 = (Object[]) o1;

                if (o11.length > 3) {  // Make sure we have all 4 columns
                    String elementValue1 = o11[0] != null ? o11[0].toString() : "";
                    String elementValue2 = o11[1] != null ? o11[1].toString() : "0";
                    String elementValue3 = o11[2] != null ? o11[2].toString() : "0";
                    String elementValue4 = o11[3] != null ? o11[3].toString() : "0";

                    if (count == 0) {
                        firstElement1_1 = elementValue1;
                        firstElement1_2 = elementValue2;
                        firstElement1_3 = elementValue3;
                        firstElement1_4 = elementValue4;

                    } else if (count == 1) {
                        secondElement1_1 = elementValue1;
                        secondElement1_2 = elementValue2;
                        secondElement1_3 = elementValue3;
                        secondElement1_4 = elementValue4;

                    } else if (count == 2) {
                        thirdElement1_1 = elementValue1;
                        thirdElement1_2 = elementValue2;
                        thirdElement1_3 = elementValue3;
                        thirdElement1_4 = elementValue4;

                    } else if (count == 3) {
                        fourthElement1_1 = elementValue1;
                        fourthElement1_2 = elementValue2;
                        fourthElement1_3 = elementValue3;
                        fourthElement1_4 = elementValue4;

                    } else if (count == 4) {
                        fifthElement1_1 = elementValue1;
                        fifthElement1_2 = elementValue2;
                        fifthElement1_3 = elementValue3;
                        fifthElement1_4 = elementValue4;

                    } else if (count == 5) {
                        sixthElement1_1 = elementValue1;
                        sixthElement1_2 = elementValue2;
                        sixthElement1_3 = elementValue3;
                        sixthElement1_4 = elementValue4;

                    } else if (count == 6) {
                        seventhElement1_1 = elementValue1;
                        seventhElement1_2 = elementValue2;
                        seventhElement1_3 = elementValue3;
                        seventhElement1_4 = elementValue4;

                    } else if (count == 7) {
                        eighthElement1_1 = elementValue1;
                        eighthElement1_2 = elementValue2;
                        eighthElement1_3 = elementValue3;
                        eighthElement1_4 = elementValue4;

                    } else if (count == 8) {
                        ninthElement1_1 = elementValue1;
                        ninthElement1_2 = elementValue2;
                        ninthElement1_3 = elementValue3;
                        ninthElement1_4 = elementValue4;

                    } else if (count == 9) {
                        tenthElement1_1 = elementValue1;
                        tenthElement1_2 = elementValue2;
                        tenthElement1_3 = elementValue3;
                        tenthElement1_4 = elementValue4;
                        break;
                    }
                }
                count++;
                System.out.println("Processing row: " + count);
            }

            mv.getModelMap().put("firstElement1_1", firstElement1_1);
            mv.getModelMap().put("firstElement1_2", firstElement1_2);
            mv.getModelMap().put("firstElement1_3", firstElement1_3);
            mv.getModelMap().put("firstElement1_4", firstElement1_4);

            mv.getModelMap().put("secondElement1_1", secondElement1_1);
            mv.getModelMap().put("secondElement1_2", secondElement1_2);
            mv.getModelMap().put("secondElement1_3", secondElement1_3);
            mv.getModelMap().put("secondElement1_4", secondElement1_4);

            mv.getModelMap().put("thirdElement1_1", thirdElement1_1);
            mv.getModelMap().put("thirdElement1_2", thirdElement1_2);
            mv.getModelMap().put("thirdElement1_3", thirdElement1_3);
            mv.getModelMap().put("thirdElement1_4", thirdElement1_4);

            mv.getModelMap().put("fourthElement1_1", fourthElement1_1);
            mv.getModelMap().put("fourthElement1_2", fourthElement1_2);
            mv.getModelMap().put("fourthElement1_3", fourthElement1_3);
            mv.getModelMap().put("fourthElement1_4", fourthElement1_4);

            mv.getModelMap().put("fifthElement1_1", fifthElement1_1);
            mv.getModelMap().put("fifthElement1_2", fifthElement1_2);
            mv.getModelMap().put("fifthElement1_3", fifthElement1_3);
            mv.getModelMap().put("fifthElement1_4", fifthElement1_4);

            mv.getModelMap().put("sixthElement1_1", sixthElement1_1);
            mv.getModelMap().put("sixthElement1_2", sixthElement1_2);
            mv.getModelMap().put("sixthElement1_3", sixthElement1_3);
            mv.getModelMap().put("sixthElement1_4", sixthElement1_4);

            mv.getModelMap().put("seventhElement1_1", seventhElement1_1);
            mv.getModelMap().put("seventhElement1_2", seventhElement1_2);
            mv.getModelMap().put("seventhElement1_3", seventhElement1_3);
            mv.getModelMap().put("seventhElement1_4", seventhElement1_4);

            mv.getModelMap().put("eighthElement1_1", eighthElement1_1);
            mv.getModelMap().put("eighthElement1_2", eighthElement1_2);
            mv.getModelMap().put("eighthElement1_3", eighthElement1_3);
            mv.getModelMap().put("eighthElement1_4", eighthElement1_4);

            mv.getModelMap().put("ninthElement1_1", ninthElement1_1);
            mv.getModelMap().put("ninthElement1_2", ninthElement1_2);
            mv.getModelMap().put("ninthElement1_3", ninthElement1_3);
            mv.getModelMap().put("ninthElement1_4", ninthElement1_4);

            mv.getModelMap().put("tenthElement1_1", tenthElement1_1);
            mv.getModelMap().put("tenthElement1_2", tenthElement1_2);
            mv.getModelMap().put("tenthElement1_3", tenthElement1_3);
            mv.getModelMap().put("tenthElement1_4", tenthElement1_4);

        } else {

            // without filteration
            //Total Pr
            prRaised = prMasterService.countAllPr();

            // Under Approval 
            underApproval = prMasterService.readyByflagzero();

//            Live PR
            livePr = prMasterService.readByflagonesix();

            //Rejected Pr
            rejectedPr = prMasterService.countRejectedPr();

            //Tender Created
            tendercount = tenderMasterService.countAllPr();

            //Tender closed
            tenderclosed = tenderMasterService.readyByopenfalg();

            // tender close by force
            tenderclosedByForce = tenderMasterService.readyBydeleteFlag();

            //totalClosePr
            totalClosePr = prMasterService.totalClosePrCount();

            // Live Tender
            tenderLive = tenderMasterService.readByflagzero();

            // Assign To buyer
            assignbuyer = prMasterService.readByprtenderFlagone();

//            Pending to assign 
            pendassign = prMasterService.readByprtenderFlagzero();

            //Tender pending to float
            approve = prMasterService.readbyflagone();

            // Monthe Wise PR Data
            DateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyy");
            Calendar cale = Calendar.getInstance();
            cale.add(Calendar.DATE, -365);
            Date todate2 = cale.getTime();
            String fromdate1 = dateFormat1.format(todate2);
            String from_date1 = fromdate1;

            List monthWiseList1 = prMasterService.readByMonthpr(from_date1);

            String prmonthName1 = "";
            String prnumberOfValue1 = "";

            String prmonthName2 = "";
            String prnumberOfValue2 = "";

            String prmonthName3 = "";
            String prnumberOfValue3 = "";

            String prmonthName4 = "";
            String prnumberOfValue4 = "";

            String prmonthName5 = "";
            String prnumberOfValue5 = "";

            String prmonthName6 = "";
            String prnumberOfValue6 = "";

            String prmonthName7 = "";
            String prnumberOfValue7 = "";

            String prmonthName8 = "";
            String prnumberOfValue8 = "";

            String prmonthName9 = "";
            String prnumberOfValue9 = "";

            String prmonthName10 = "";
            String prnumberOfValue10 = "";

            String prmonthName11 = "";
            String prnumberOfValue11 = "";

            String prmonthName12 = "";
            String prnumberOfValue12 = "";

            int i3 = 0;

            for (Object empId2 : monthWiseList1) {
                i3++;

                Object[] obj = (Object[]) empId2;
                if (i3 == 1) {
                    prnumberOfValue1 = "" + obj[0];
                    prmonthName1 = "" + obj[1];
                }
                if (i3 == 2) {
                    prnumberOfValue2 = "" + obj[0];
                    prmonthName2 = "" + obj[1];
                }
                if (i3 == 3) {
                    prnumberOfValue3 = "" + obj[0];
                    prmonthName3 = "" + obj[1];
                }
                if (i3 == 4) {
                    prnumberOfValue4 = "" + obj[0];
                    prmonthName4 = "" + obj[1];
                }
                if (i3 == 5) {
                    prnumberOfValue5 = "" + obj[0];
                    prmonthName5 = "" + obj[1];

                }

                if (i3 == 6) {
                    prnumberOfValue6 = "" + obj[0];
                    prmonthName6 = "" + obj[1];
                }
                if (i3 == 7) {
                    prnumberOfValue7 = "" + obj[0];
                    prmonthName7 = "" + obj[1];
                }
                if (i3 == 8) {
                    prnumberOfValue8 = "" + obj[0];
                    prmonthName8 = "" + obj[1];
                }
                if (i3 == 9) {
                    prnumberOfValue9 = "" + obj[0];
                    prmonthName9 = "" + obj[1];
                }
                if (i3 == 10) {
                    prnumberOfValue10 = "" + obj[0];
                    prmonthName10 = "" + obj[1];

                }
                if (i3 == 11) {
                    prnumberOfValue11 = "" + obj[0];
                    prmonthName11 = "" + obj[1];
                }
                if (i3 == 12) {
                    prnumberOfValue12 = "" + obj[0];
                    prmonthName12 = "" + obj[1];
                    break;
                }

            }

//         List list4 = prMasterService.approvedPRListDashboad();
            mv.getModelMap().put("prmonthName1", prmonthName1);
            mv.getModelMap().put("prnumberOfValue1", prnumberOfValue1);
            mv.getModelMap().put("prmonthName2", prmonthName2);
            mv.getModelMap().put("prnumberOfValue2", prnumberOfValue2);
            mv.getModelMap().put("prmonthName3", prmonthName3);
            mv.getModelMap().put("prnumberOfValue3", prnumberOfValue3);
            mv.getModelMap().put("prmonthName4", prmonthName4);
            mv.getModelMap().put("prnumberOfValue4", prnumberOfValue4);
            mv.getModelMap().put("prmonthName5", prmonthName5);
            mv.getModelMap().put("prnumberOfValue5", prnumberOfValue5);
            mv.getModelMap().put("prmonthName6", prmonthName6);
            mv.getModelMap().put("prnumberOfValue6", prnumberOfValue6);
            mv.getModelMap().put("prmonthName7", prmonthName7);
            mv.getModelMap().put("prnumberOfValue7", prnumberOfValue7);
            mv.getModelMap().put("prmonthName8", prmonthName8);
            mv.getModelMap().put("prnumberOfValue8", prnumberOfValue8);
            mv.getModelMap().put("prmonthName9", prmonthName9);
            mv.getModelMap().put("prnumberOfValue9", prnumberOfValue9);
            mv.getModelMap().put("prmonthName10", prmonthName10);
            mv.getModelMap().put("prnumberOfValue10", prnumberOfValue10);
            mv.getModelMap().put("prmonthName11", prmonthName11);
            mv.getModelMap().put("prnumberOfValue11", prnumberOfValue11);
            mv.getModelMap().put("prmonthName12", prmonthName12);
            mv.getModelMap().put("prnumberOfValue12", prnumberOfValue12);

            // Month Wise Tender Data
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, -365);
            Date todate1 = cal.getTime();
            String fromdate = dateFormat.format(todate1);
            String from_date = fromdate;

            List monthWiseList = tenderMasterService.readByMonth(from_date);

            String monthName1 = "";
            String numberOfValue1 = "";

            String monthName2 = "";
            String numberOfValue2 = "";

            String monthName3 = "";
            String numberOfValue3 = "";

            String monthName4 = "";
            String numberOfValue4 = "";

            String monthName5 = "";
            String numberOfValue5 = "";

            String monthName6 = "";
            String numberOfValue6 = "";

            String monthName7 = "";
            String numberOfValue7 = "";

            String monthName8 = "";
            String numberOfValue8 = "";

            String monthName9 = "";
            String numberOfValue9 = "";

            String monthName10 = "";
            String numberOfValue10 = "";

            String monthName11 = "";
            String numberOfValue11 = "";

            String monthName12 = "";
            String numberOfValue12 = "";

            int i2 = 0;

            for (Object empId1 : monthWiseList) {
                i2++;

                Object[] obj = (Object[]) empId1;
                if (i2 == 1) {
                    numberOfValue1 = "" + obj[0];
                    monthName1 = "" + obj[1];
                }
                if (i2 == 2) {
                    numberOfValue2 = "" + obj[0];
                    monthName2 = "" + obj[1];
                }
                if (i2 == 3) {
                    numberOfValue3 = "" + obj[0];
                    monthName3 = "" + obj[1];
                }
                if (i2 == 4) {
                    numberOfValue4 = "" + obj[0];
                    monthName4 = "" + obj[1];
                }
                if (i2 == 5) {
                    numberOfValue5 = "" + obj[0];
                    monthName5 = "" + obj[1];
                }

                if (i2 == 6) {
                    numberOfValue6 = "" + obj[0];
                    monthName6 = "" + obj[1];
                }
                if (i2 == 7) {
                    numberOfValue7 = "" + obj[0];
                    monthName7 = "" + obj[1];
                }
                if (i2 == 8) {
                    numberOfValue8 = "" + obj[0];
                    monthName8 = "" + obj[1];
                }
                if (i2 == 9) {
                    numberOfValue9 = "" + obj[0];
                    monthName9 = "" + obj[1];
                }
                if (i2 == 10) {
                    numberOfValue10 = "" + obj[0];
                    monthName10 = "" + obj[1];

                }
                if (i2 == 11) {
                    numberOfValue11 = "" + obj[0];
                    monthName11 = "" + obj[1];
                }
                if (i2 == 12) {
                    numberOfValue12 = "" + obj[0];
                    monthName12 = "" + obj[1];
                    break;
                }

            }

            mv.getModelMap().put("monthName1", monthName1);
            mv.getModelMap().put("numberOfValue1", numberOfValue1);
            mv.getModelMap().put("monthName2", monthName2);
            mv.getModelMap().put("numberOfValue2", numberOfValue2);
            mv.getModelMap().put("monthName3", monthName3);
            mv.getModelMap().put("numberOfValue3", numberOfValue3);
            mv.getModelMap().put("monthName4", monthName4);
            mv.getModelMap().put("numberOfValue4", numberOfValue4);
            mv.getModelMap().put("monthName5", monthName5);
            mv.getModelMap().put("numberOfValue5", numberOfValue5);
            mv.getModelMap().put("monthName6", monthName6);
            mv.getModelMap().put("numberOfValue6", numberOfValue6);
            mv.getModelMap().put("monthName7", monthName7);
            mv.getModelMap().put("numberOfValue7", numberOfValue7);
            mv.getModelMap().put("monthName8", monthName8);
            mv.getModelMap().put("numberOfValue8", numberOfValue8);
            mv.getModelMap().put("monthName9", monthName9);
            mv.getModelMap().put("numberOfValue9", numberOfValue9);
            mv.getModelMap().put("monthName10", monthName10);
            mv.getModelMap().put("numberOfValue10", numberOfValue10);
            mv.getModelMap().put("monthName11", monthName11);
            mv.getModelMap().put("numberOfValue11", numberOfValue11);
            mv.getModelMap().put("monthName12", monthName12);
            mv.getModelMap().put("numberOfValue12", numberOfValue12);

//        mv.getModelMap().put("list0", list0);
            // Tender master data
            List contwise = tenderMasterService.readBycontactper();

            String firstElement1_1 = "", firstElement1_2 = "", firstElement1_3 = "", firstElement1_4 = "";
            String secondElement1_1 = "", secondElement1_2 = "", secondElement1_3 = "", secondElement1_4 = "";
            String thirdElement1_1 = "", thirdElement1_2 = "", thirdElement1_3 = "", thirdElement1_4 = "";
            String fourthElement1_1 = "", fourthElement1_2 = "", fourthElement1_3 = "", fourthElement1_4 = "";
            String fifthElement1_1 = "", fifthElement1_2 = "", fifthElement1_3 = "", fifthElement1_4 = "";
            String sixthElement1_1 = "", sixthElement1_2 = "", sixthElement1_3 = "", sixthElement1_4 = "";
            String seventhElement1_1 = "", seventhElement1_2 = "", seventhElement1_3 = "", seventhElement1_4 = "";
            String eighthElement1_1 = "", eighthElement1_2 = "", eighthElement1_3 = "", eighthElement1_4 = "";
            String ninthElement1_1 = "", ninthElement1_2 = "", ninthElement1_3 = "", ninthElement1_4 = "";
            String tenthElement1_1 = "", tenthElement1_2 = "", tenthElement1_3 = "", tenthElement1_4 = "";
            int count = 0;

            for (Object o1 : contwise) {
                Object[] o11 = (Object[]) o1;

                if (o11.length > 3) {  // Make sure we have all 4 columns
                    String elementValue1 = o11[0] != null ? o11[0].toString() : "";
                    String elementValue2 = o11[1] != null ? o11[1].toString() : "0";
                    String elementValue3 = o11[2] != null ? o11[2].toString() : "0";
                    String elementValue4 = o11[3] != null ? o11[3].toString() : "0";

                    if (count == 0) {
                        firstElement1_1 = elementValue1;
                        firstElement1_2 = elementValue2;
                        firstElement1_3 = elementValue3;
                        firstElement1_4 = elementValue4;

                    } else if (count == 1) {
                        secondElement1_1 = elementValue1;
                        secondElement1_2 = elementValue2;
                        secondElement1_3 = elementValue3;
                        secondElement1_4 = elementValue4;

                    } else if (count == 2) {
                        thirdElement1_1 = elementValue1;
                        thirdElement1_2 = elementValue2;
                        thirdElement1_3 = elementValue3;
                        thirdElement1_4 = elementValue4;

                    } else if (count == 3) {
                        fourthElement1_1 = elementValue1;
                        fourthElement1_2 = elementValue2;
                        fourthElement1_3 = elementValue3;
                        fourthElement1_4 = elementValue4;

                    } else if (count == 4) {
                        fifthElement1_1 = elementValue1;
                        fifthElement1_2 = elementValue2;
                        fifthElement1_3 = elementValue3;
                        fifthElement1_4 = elementValue4;

                    } else if (count == 5) {
                        sixthElement1_1 = elementValue1;
                        sixthElement1_2 = elementValue2;
                        sixthElement1_3 = elementValue3;
                        sixthElement1_4 = elementValue4;

                    } else if (count == 6) {
                        seventhElement1_1 = elementValue1;
                        seventhElement1_2 = elementValue2;
                        seventhElement1_3 = elementValue3;
                        seventhElement1_4 = elementValue4;

                    } else if (count == 7) {
                        eighthElement1_1 = elementValue1;
                        eighthElement1_2 = elementValue2;
                        eighthElement1_3 = elementValue3;
                        eighthElement1_4 = elementValue4;

                    } else if (count == 8) {
                        ninthElement1_1 = elementValue1;
                        ninthElement1_2 = elementValue2;
                        ninthElement1_3 = elementValue3;
                        ninthElement1_4 = elementValue4;

                    } else if (count == 9) {
                        tenthElement1_1 = elementValue1;
                        tenthElement1_2 = elementValue2;
                        tenthElement1_3 = elementValue3;
                        tenthElement1_4 = elementValue4;
                        break;

                    }
                }

                count++;
                System.out.println("Processing row: " + count);
            }

// Pass everything to the model map
            mv.getModelMap().put("firstElement1_1", firstElement1_1);
            mv.getModelMap().put("firstElement1_2", firstElement1_2);
            mv.getModelMap().put("firstElement1_3", firstElement1_3);
            mv.getModelMap().put("firstElement1_4", firstElement1_4);

            mv.getModelMap().put("secondElement1_1", secondElement1_1);
            mv.getModelMap().put("secondElement1_2", secondElement1_2);
            mv.getModelMap().put("secondElement1_3", secondElement1_3);
            mv.getModelMap().put("secondElement1_4", secondElement1_4);

            mv.getModelMap().put("thirdElement1_1", thirdElement1_1);
            mv.getModelMap().put("thirdElement1_2", thirdElement1_2);
            mv.getModelMap().put("thirdElement1_3", thirdElement1_3);
            mv.getModelMap().put("thirdElement1_4", thirdElement1_4);

            mv.getModelMap().put("fourthElement1_1", fourthElement1_1);
            mv.getModelMap().put("fourthElement1_2", fourthElement1_2);
            mv.getModelMap().put("fourthElement1_3", fourthElement1_3);
            mv.getModelMap().put("fourthElement1_4", fourthElement1_4);

            mv.getModelMap().put("fifthElement1_1", fifthElement1_1);
            mv.getModelMap().put("fifthElement1_2", fifthElement1_2);
            mv.getModelMap().put("fifthElement1_3", fifthElement1_3);
            mv.getModelMap().put("fifthElement1_4", fifthElement1_4);

            mv.getModelMap().put("sixthElement1_1", sixthElement1_1);
            mv.getModelMap().put("sixthElement1_2", sixthElement1_2);
            mv.getModelMap().put("sixthElement1_3", sixthElement1_3);
            mv.getModelMap().put("sixthElement1_4", sixthElement1_4);

            mv.getModelMap().put("seventhElement1_1", seventhElement1_1);
            mv.getModelMap().put("seventhElement1_2", seventhElement1_2);
            mv.getModelMap().put("seventhElement1_3", seventhElement1_3);
            mv.getModelMap().put("seventhElement1_4", seventhElement1_4);

            mv.getModelMap().put("eighthElement1_1", eighthElement1_1);
            mv.getModelMap().put("eighthElement1_2", eighthElement1_2);
            mv.getModelMap().put("eighthElement1_3", eighthElement1_3);
            mv.getModelMap().put("eighthElement1_4", eighthElement1_4);

            mv.getModelMap().put("ninthElement1_1", ninthElement1_1);
            mv.getModelMap().put("ninthElement1_2", ninthElement1_2);
            mv.getModelMap().put("ninthElement1_3", ninthElement1_3);
            mv.getModelMap().put("ninthElement1_4", ninthElement1_4);

            mv.getModelMap().put("tenthElement1_1", tenthElement1_1);
            mv.getModelMap().put("tenthElement1_2", tenthElement1_2);
            mv.getModelMap().put("tenthElement1_3", tenthElement1_3);
            mv.getModelMap().put("tenthElement1_4", tenthElement1_4);

        }

        // All count
        mv.getModelMap().put("prRaised", prRaised);
        mv.getModelMap().put("livePr", livePr);
        mv.getModelMap().put("prValue", prValue);
        mv.getModelMap().put("tendercount", tendercount);
        mv.getModelMap().put("tenderclosed", tenderclosed);
        mv.getModelMap().put("tenderclosedByForce", tenderclosedByForce);
        mv.getModelMap().put("totalClosePr", totalClosePr);
        mv.getModelMap().put("tenderLive", tenderLive);
        mv.getModelMap().put("underApproval", underApproval);
        mv.getModelMap().put("assbuyer", assignbuyer);
        mv.getModelMap().put("pendassign", pendassign);
        mv.getModelMap().put("approve", approve);
        mv.getModelMap().put("rejectedPr", rejectedPr);
        mv.getModelMap().put("list0", list0);

        mv.setViewName("Dashboard/Dashboard");

        return mv;

    }

    public ModelAndView report(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";
        String userName = request.getParameter("prUser") != null ? request.getParameter("prUser") : "";

//        List list = prMasterService.readPrRegister(userName, Fromdate, Todate);
        List list0 = prMasterService.readByTenderCreater();
//        List list1 = prMasterService.readPrRegisterUnCommon(userName, Fromdate, Todate);
//        List list2 = prMasterService.readOnlyPr(userName, Fromdate, Todate);
        List list3 = prMasterService.readPrAdmin();

//        mv.getModelMap().put("list", list);
        mv.getModelMap().put("list0", list0);
//        mv.getModelMap().put("list1", list1);
//        mv.getModelMap().put("list2", list2);
        mv.getModelMap().put("list3", list3);
        mv.getModelMap().put("Fromdate", Fromdate);
        mv.getModelMap().put("Todate", Todate);
        mv.getModelMap().put("userName", userName);

        mv.setViewName("Dashboard/Report");

        return mv;

    }

    public ModelAndView reportPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));

        String searchValue = request.getParameter("searchValue");
        String id = request.getParameter("id");
        String prNo = request.getParameter("prNo");
        String prAdmin = request.getParameter("prAdmin");
        String announceDate = request.getParameter("announceDate");
        String prAuthorizeUser = request.getParameter("prAuthorizeUser");
        String prAuthorizeDate = request.getParameter("prAuthorizeDate");
        String tenderAssignDate = request.getParameter("tenderAssignDate");
        String statusFilter = request.getParameter("statusFilter");
        String tenderCreaterId = request.getParameter("tenderCreaterId");
        String tenderCreaterDate = request.getParameter("tenderCreaterDate");
        String prReworkDate = request.getParameter("prReworkDate");
        String title = request.getParameter("title");
        String prComment = request.getParameter("prComment");
        String finalCloseDate = request.getParameter("finalCloseDate");
        String businessType = request.getParameter("businessType");
        String announceApprovalDiff = request.getParameter("announceApprovalDiff");
        String prReworkDiff = request.getParameter("prReworkDiff");
        String submitLastdate = request.getParameter("submitLastdate");
        String value = request.getParameter("value");
        String poNo = request.getParameter("poNo");
        String poDate = request.getParameter("poDate");
        String poValue = request.getParameter("poValue");
        String vendorCode = request.getParameter("vendorCode");
        String fromDate = request.getParameter("fromdate");
        String toDate = request.getParameter("todate");

        boolean hasOtherFilter = (id != null && !id.trim().isEmpty())
                || (prNo != null && !prNo.trim().isEmpty())
                || (prAdmin != null && !prAdmin.trim().isEmpty())
                || (announceDate != null && !announceDate.trim().isEmpty())
                || (prAuthorizeUser != null && !prAuthorizeUser.trim().isEmpty())
                || (prAuthorizeDate != null && !prAuthorizeDate.trim().isEmpty())
                || (tenderAssignDate != null && !tenderAssignDate.trim().isEmpty())
                || (statusFilter != null && !statusFilter.trim().isEmpty())
                || (tenderCreaterId != null && !tenderCreaterId.trim().isEmpty())
                || (tenderCreaterDate != null && !tenderCreaterDate.trim().isEmpty())
                || (prReworkDate != null && !prReworkDate.trim().isEmpty())
                || (title != null && !title.trim().isEmpty())
                || (prComment != null && !prComment.trim().isEmpty())
                || (finalCloseDate != null && !finalCloseDate.trim().isEmpty())
                || (businessType != null && !businessType.trim().isEmpty())
                || (announceApprovalDiff != null && !announceApprovalDiff.trim().isEmpty())
                || (prReworkDiff != null && !prReworkDiff.trim().isEmpty())
                || (submitLastdate != null && !submitLastdate.trim().isEmpty())
                || (value != null && !value.trim().isEmpty())
                || (poNo != null && !poNo.trim().isEmpty())
                || (poDate != null && !poDate.trim().isEmpty())
                || (poValue != null && !poValue.trim().isEmpty())
                || (vendorCode != null && !vendorCode.trim().isEmpty())
                || (searchValue != null && !searchValue.trim().isEmpty());

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Calendar cal = Calendar.getInstance();

        if (!hasOtherFilter) {
            if ((fromDate == null || fromDate.trim().isEmpty()) && (toDate == null || toDate.trim().isEmpty())) {
                toDate = sdf.format(cal.getTime());
                cal.add(Calendar.MONTH, -3);
                fromDate = sdf.format(cal.getTime());
            } else if ((fromDate == null || fromDate.trim().isEmpty()) && (toDate != null && !toDate.trim().isEmpty())) {
                Date toDt = sdf.parse(toDate);
                cal.setTime(toDt);
                cal.add(Calendar.MONTH, -3);
                fromDate = sdf.format(cal.getTime());
            } else if ((fromDate != null && !fromDate.trim().isEmpty()) && (toDate == null || toDate.trim().isEmpty())) {
                toDate = sdf.format(cal.getTime());
            }
        }

        if ("Unapproved PR".equals(statusFilter)) {

            statusFilter = "0";

        } else if ("Unassigned PR".equals(statusFilter)) {

            statusFilter = "1";

        } else if ("Unapproved PR".equals(statusFilter)) {

            statusFilter = "2";

        } else if ("PR Cancelled".equals(statusFilter)) {

            statusFilter = "3";

        } else if ("Tender Created".equals(statusFilter)) {

            statusFilter = "6";

        }

        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.equals("")) {
            orderDir = "desc";
        }

        if (orderColumnIndex == null || orderColumnIndex.equals("")) {
            orderColumnIndex = "0";
        }

        String orderColumn = "b.id";

        if (orderColumnIndex != null) {

            switch (Integer.parseInt(orderColumnIndex)) {

                case 0:
                    orderColumn = "b.id";
                    break;
                case 1:
                    orderColumn = "b.pr_no";
                    break;
                case 2:
                    orderColumn = "b.pr_admin";
                    break;
                case 3:
                    orderColumn = "b.announce_date";
                    break;
                case 4:
                    orderColumn = "b.pr_authorize_user";
                    break;
                case 5:
                    orderColumn = "b.pr_authorize_date";
                    break;
                case 6:
                    orderColumn = "b.tender_assign_date";
                    break;
                case 7:
                    orderColumn = "b.authorize_flag";
                    break;
                case 8:
                    orderColumn = "b.tender_creater_id";
                    break;
                case 9:
                    orderColumn = "b.tender_creater_date";
                    break;
                case 10:
                    orderColumn = "b.pr_rework_date";
                    break;
                case 11:
                    orderColumn = "b.tender_creater_date";
                    break;
                case 12:
                    orderColumn = "b.title";
                    break;
                case 13:
                    orderColumn = "b.pr_comment";
                    break;
                case 14:
                    orderColumn = "b.final_close_date";
                    break;
                case 15:
                    orderColumn = "b.business_type";
                    break;
//                case 16:
//                    orderColumn = "daysLeft";
//                    break;
//                case 17:
//                    orderColumn = "announceApprovalDiff";
//                    break;
//                case 18:
//                    orderColumn = "announceApprovalDiff";
//                    break;
                case 19:
                    orderColumn = "a.submit_lastdate";
                    break;
                case 20:
                    orderColumn = "b.value";
                    break;
                case 21:
                    orderColumn = "c.po_no";
                    break;
                case 22:
                    orderColumn = "c.po_date";
                    break;
                case 23:
                    orderColumn = "c.po_value";
                    break;
                case 24:
                    orderColumn = "c.vendor_code";
                    break;
                default:
                    orderColumn = "b.id";
            }
        }

        List list = prMasterService.getPRRegisterPagination(start, length, searchValue, fromDate, toDate, id, prNo, prAdmin, announceDate, prAuthorizeUser, prAuthorizeDate, tenderAssignDate, statusFilter, tenderCreaterId, tenderCreaterDate, prReworkDate, title, prComment, finalCloseDate, businessType, announceApprovalDiff, prReworkDiff, submitLastdate, value, poNo, poDate, poValue, vendorCode, orderColumn, orderDir);

        int recordsTotal = prMasterService.getPRRegisterCount(fromDate, toDate);

        int recordsFiltered = prMasterService.getFilteredPRRegisterCount(searchValue, fromDate, toDate, id, prNo, prAdmin, announceDate, prAuthorizeUser, prAuthorizeDate, tenderAssignDate, statusFilter, tenderCreaterId, tenderCreaterDate, prReworkDate, title, prComment, finalCloseDate, businessType, announceApprovalDiff, prReworkDiff, submitLastdate, value, poNo, poDate, poValue, vendorCode);

        List data = new ArrayList();

        Object[] totals = prMasterService.getTotalPRAndPOValue(searchValue, fromDate, toDate, id, prNo, prAdmin, announceDate, prAuthorizeUser, prAuthorizeDate, tenderAssignDate, statusFilter, tenderCreaterId, tenderCreaterDate, prReworkDate, title, prComment, finalCloseDate, businessType, announceApprovalDiff, prReworkDiff, submitLastdate, value, poNo, poDate, poValue, vendorCode);

        double totalPRValue = 0.0;
        double totalPOValue = 0.0;

        if (totals != null) {

            totalPRValue = totals[0] != null
                    ? ((Number) totals[0]).doubleValue()
                    : 0.0;

            totalPOValue = totals[1] != null
                    ? ((Number) totals[1]).doubleValue()
                    : 0.0;
        }

        int srNo = start + 1;
        Set<String> processedPrNos = new HashSet<>();

        for (Iterator it = list.iterator(); it.hasNext();) {

            Object[] row = (Object[]) it.next();

            Map map = new HashMap();

            map.put("srNo", srNo++);
            String currentPrNo = row[0] == null ? "" : row[0].toString();

            map.put("prNo", currentPrNo);
            map.put("prAdmin", row[1] == null ? "" : row[1]);
            map.put("announceDate", row[2] == null ? "" : row[2]);
            map.put("prAuthorizeUser", row[3] == null ? "" : row[3]);
            map.put("prAuthorizeDate", row[4] == null ? "" : row[4]);
            map.put("tenderAssignDate", row[6] == null ? "" : row[6]);

            String status = "";

            if (row[7] != null) {

                int flag = Integer.parseInt(row[7].toString());

                switch (flag) {
                    case 0:
                        status = "Unapproved PR";
                        break;
                    case 1:
                        status = "Unassigned PR";
                        break;
                    case 2:
                        status = "Unapproved PR";
                        break;
                    case 3:
                        status = "PR Cancelled";
                        break;
                    case 6:
                        status = "Tender Created";
                        break;
                    default:
                        status = "Unknown Status";
                }
            }

            if (row[18] != null && !"".equals(row[18].toString().trim())) {
                status = "PO Issued";
            }

            map.put("status", status);

            map.put("assignedTo", row[8] == null ? "" : row[8]);
            map.put("dateOfEnquiryFloated", row[9] == null ? "" : row[9]);
            map.put("prReworkDate", row[10] == null ? "" : row[10]);
            map.put("title", row[11] == null ? "" : row[11]);
            map.put("prComment", row[12] == null ? "" : row[12]);
            map.put("finalCloseDate", row[13] == null ? "" : row[13]);
            map.put("businessType", row[14] == null ? "" : row[14]);
            map.put("daysLeft", row[15] == null ? "" : row[15]);
            map.put("announceApprovalDiff", row[16] == null ? "" : row[16]);
            map.put("submitLastdate", row[17] == null ? "" : row[17]);
            if (processedPrNos.add(currentPrNo)) {
                map.put("prValue", row[5] == null ? "" : row[5]);
            } else {
                map.put("prValue", "");
            }
            map.put("poNo", row[18] == null ? "" : row[18]);
            map.put("poDate", row[19] == null ? "" : row[19]);
            map.put("poValue", row[20] == null ? "" : row[20]);
            map.put("vendorCode", row[21] == null ? "" : row[21]);

            data.add(map);
        }

        JSONObject json = new JSONObject();

        json.put("draw", draw);
        json.put("recordsTotal", recordsTotal);
        json.put("recordsFiltered", recordsFiltered);

        json.put("totalPRValue", totalPRValue / 10000000.0);
        json.put("totalPOValue", totalPOValue / 10000000.0);

        json.put("data", data);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json.toString());

        return null;

    }

    public ModelAndView reportExcelAll(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";

        List list = prMasterService.readPrRegisterForAll();
        List list1 = prMasterService.readPrRegisterUnCommonForAll();
        List list2 = prMasterService.readOnlyPrForAll();

        int rownum = 0;

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("FIRST SHEET");

        XSSFFont boldFont = workbook.createFont();
        boldFont.setBold(true);
        XSSFCellStyle styleBold = workbook.createCellStyle();
        styleBold.setFont(boldFont);
        styleBold.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
        styleBold.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        Row itemHeaderRow = sheet.createRow(rownum++);
        itemHeaderRow.setHeightInPoints(40);
        String[] itemHeaders = {
            "PR No.",
            "PR Created By",
            "PR Date",
            "PR Approval By",
            "PR Approval Date",
            "PR Value in INR Taxes",
            "Tender Assign Date",
            "Status",
            "Assigned To",
            "Date Of Enquiry Floated",
            "PR Date of Reckoning by SCM Team",
            "Commercial RFQ Issued to Suppliers Date",
            "Site Name",
            "Reasons for difference between PR approval date and date of Reckoning",
            "Bid Evaluation Approved Date",
            "Segment",
            "Days Past from PR Approval",
            "Latency from PR Approval Date",
            "Latency from PR Reckoning Date",
            "Date of Pre-Bid/Review with Initiator and Supplier Completed Date",
            "PO No.",
            "PO Issued Date",
            "PO Value with Taxes",
            "Supplier Code"
        };

        for (int i = 0; i < itemHeaders.length; i++) {
            if (!itemHeaders[i].isEmpty()) {
                Cell cell = itemHeaderRow.createCell(i);
                cell.setCellValue(itemHeaders[i]);
                cell.setCellStyle(styleBold);
            }
        }

// ----- List 1 -----
        for (Object dataObj : list) {
            Row row = sheet.createRow(rownum++);
            if (dataObj instanceof Object[]) {
                Object[] dataArr = (Object[]) dataObj;
                for (int col = 0; col < dataArr.length; col++) {
                    Cell cell = row.createCell(col);

                    // Clean and parse numeric values for PR Value (col 5) and PO Value (col 22)
                    if ((col == 5 || col == 22) && dataArr[col] != null) {
                        String raw = dataArr[col].toString().replaceAll("[^\\d.]", "");
                        try {
                            double val = Double.parseDouble(raw);
                            cell.setCellValue(val);
                        } catch (NumberFormatException e) {
                            cell.setCellValue(dataArr[col].toString()); // fallback
                        }
                    } else if (col == 7 && dataArr[col] != null) { // Status column
                        try {
                            int status = Integer.parseInt(dataArr[col].toString().replaceAll("[^\\d]", ""));
                            String statusText;
                            switch (status) {
                                case 0:
                                    statusText = "Pending";
                                    break;
                                case 1:
                                    statusText = "Approve";
                                    break;
                                case 2:
                                    statusText = "Rework";
                                    break;
                                case 3:
                                    statusText = "Reject";
                                    break;
                                case 6:
                                    statusText = "Tender Created";
                                    break;
                                default:
                                    statusText = "Unknown";
                                    break;
                            }
                            cell.setCellValue(statusText);
                        } catch (NumberFormatException e) {
                            cell.setCellValue("Unknown");
                        }
                    } else {
                        cell.setCellValue(dataArr[col] != null ? dataArr[col].toString() : "");
                    }
                }
            } else {
                Cell cell = row.createCell(0);
                cell.setCellValue(dataObj != null ? dataObj.toString() : "");
            }
        }

// ----- List 2 -----
        for (Object dataObj : list1) {
            Row row = sheet.createRow(rownum++);
            if (dataObj instanceof Object[]) {
                Object[] dataArr = (Object[]) dataObj;
                for (int col = 0; col < dataArr.length; col++) {
                    Cell cell = row.createCell(col);

                    if ((col == 5 || col == 22) && dataArr[col] != null) {
                        String raw = dataArr[col].toString().replaceAll("[^\\d.]", "");
                        try {
                            double val = Double.parseDouble(raw);
                            cell.setCellValue(val);
                        } catch (NumberFormatException e) {
                            cell.setCellValue(dataArr[col].toString());
                        }
                    } else if (col == 7 && dataArr[col] != null) {
                        try {
                            int status = Integer.parseInt(dataArr[col].toString().replaceAll("[^\\d]", ""));
                            String statusText;
                            switch (status) {
                                case 0:
                                    statusText = "Pending";
                                    break;
                                case 1:
                                    statusText = "Approve";
                                    break;
                                case 2:
                                    statusText = "Rework";
                                    break;
                                case 3:
                                    statusText = "Reject";
                                    break;
                                case 6:
                                    statusText = "Tender Created";
                                    break;
                                default:
                                    statusText = "Unknown";
                                    break;
                            }
                            cell.setCellValue(statusText);
                        } catch (NumberFormatException e) {
                            cell.setCellValue("Unknown");
                        }
                    } else {
                        cell.setCellValue(dataArr[col] != null ? dataArr[col].toString() : "");
                    }
                }
            } else {
                Cell cell = row.createCell(0);
                cell.setCellValue(dataObj != null ? dataObj.toString() : "");
            }
        }

// ----- List 3 -----
        for (Object dataObj : list2) {
            Row row = sheet.createRow(rownum++);
            if (dataObj instanceof Object[]) {
                Object[] dataArr = (Object[]) dataObj;
                for (int col = 0; col < dataArr.length; col++) {
                    Cell cell = row.createCell(col);

                    if ((col == 5 || col == 22) && dataArr[col] != null) {
                        String raw = dataArr[col].toString().replaceAll("[^\\d.]", "");
                        try {
                            double val = Double.parseDouble(raw);
                            cell.setCellValue(val);
                        } catch (NumberFormatException e) {
                            cell.setCellValue(dataArr[col].toString());
                        }
                    } else if (col == 7 && dataArr[col] != null) {
                        try {
                            int status = Integer.parseInt(dataArr[col].toString().replaceAll("[^\\d]", ""));
                            String statusText;
                            switch (status) {
                                case 0:
                                    statusText = "Pending";
                                    break;
                                case 1:
                                    statusText = "Approve";
                                    break;
                                case 2:
                                    statusText = "Rework";
                                    break;
                                case 3:
                                    statusText = "Reject";
                                    break;
                                case 6:
                                    statusText = "Tender Created";
                                    break;
                                default:
                                    statusText = "Unknown";
                                    break;
                            }
                            cell.setCellValue(statusText);
                        } catch (NumberFormatException e) {
                            cell.setCellValue("Unknown");
                        }
                    } else {
                        cell.setCellValue(dataArr[col] != null ? dataArr[col].toString() : "");
                    }
                }
            } else {
                Cell cell = row.createCell(0);
                cell.setCellValue(dataObj != null ? dataObj.toString() : "");
            }
        }

        String appPath = request.getServletContext().getRealPath("");
        String filePath = appPath + File.separator + "StorageYard" + File.separator + "excel" + File.separator + "prexcel.xlsx";
        File file = new File(filePath);
        file.getParentFile().mkdirs();

        try (FileOutputStream fos = new FileOutputStream(file)) {
            workbook.write(fos);
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("filePath", filePath);
        DownloadFile downloadFile = new DownloadFile();
        downloadFile.doDownload(request, response);

        mv.setViewName("forward:dashboard.htm?act=report");
        return mv;
    }

    public ModelAndView reportExcel(HttpServletRequest request, HttpServletResponse response) throws Exception {

        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);

        String searchValue = request.getParameter("searchValue"); // fix: was search[value]
        String id = request.getParameter("id");
        String prNo = request.getParameter("prNo");
        String prAdmin = request.getParameter("prAdmin");
        String announceDate = request.getParameter("announceDate");
        String prAuthorizeUser = request.getParameter("prAuthorizeUser");
        String prAuthorizeDate = request.getParameter("prAuthorizeDate");
        String tenderAssignDate = request.getParameter("tenderAssignDate");
        String statusFilter = request.getParameter("statusFilter");
        String tenderCreaterId = request.getParameter("tenderCreaterId");
        String tenderCreaterDate = request.getParameter("tenderCreaterDate");
        String prReworkDate = request.getParameter("prReworkDate");
        String title = request.getParameter("title");
        String prComment = request.getParameter("prComment");
        String finalCloseDate = request.getParameter("finalCloseDate");
        String businessType = request.getParameter("businessType");
        String announceApprovalDiff = request.getParameter("announceApprovalDiff");
        String prReworkDiff = request.getParameter("prReworkDiff");
        String submitLastdate = request.getParameter("submitLastdate");
        String value = request.getParameter("value");
        String poNo = request.getParameter("poNo");
        String poDate = request.getParameter("poDate");
        String poValue = request.getParameter("poValue");
        String vendorCode = request.getParameter("vendorCode");
        String fromDate = request.getParameter("fromdate");
        String toDate = request.getParameter("todate");

        boolean hasOtherFilter = (id != null && !id.trim().isEmpty())
                || (prNo != null && !prNo.trim().isEmpty())
                || (prAdmin != null && !prAdmin.trim().isEmpty())
                || (announceDate != null && !announceDate.trim().isEmpty())
                || (prAuthorizeUser != null && !prAuthorizeUser.trim().isEmpty())
                || (prAuthorizeDate != null && !prAuthorizeDate.trim().isEmpty())
                || (tenderAssignDate != null && !tenderAssignDate.trim().isEmpty())
                || (statusFilter != null && !statusFilter.trim().isEmpty())
                || (tenderCreaterId != null && !tenderCreaterId.trim().isEmpty())
                || (tenderCreaterDate != null && !tenderCreaterDate.trim().isEmpty())
                || (prReworkDate != null && !prReworkDate.trim().isEmpty())
                || (title != null && !title.trim().isEmpty())
                || (prComment != null && !prComment.trim().isEmpty())
                || (finalCloseDate != null && !finalCloseDate.trim().isEmpty())
                || (businessType != null && !businessType.trim().isEmpty())
                || (announceApprovalDiff != null && !announceApprovalDiff.trim().isEmpty())
                || (prReworkDiff != null && !prReworkDiff.trim().isEmpty())
                || (submitLastdate != null && !submitLastdate.trim().isEmpty())
                || (value != null && !value.trim().isEmpty())
                || (poNo != null && !poNo.trim().isEmpty())
                || (poDate != null && !poDate.trim().isEmpty())
                || (poValue != null && !poValue.trim().isEmpty())
                || (vendorCode != null && !vendorCode.trim().isEmpty())
                || (searchValue != null && !searchValue.trim().isEmpty());

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Calendar cal = Calendar.getInstance();

        if (!hasOtherFilter) {
            if ((fromDate == null || fromDate.trim().isEmpty()) && (toDate == null || toDate.trim().isEmpty())) {
                toDate = sdf.format(cal.getTime());
                cal.add(Calendar.MONTH, -3);
                fromDate = sdf.format(cal.getTime());
            } else if ((fromDate == null || fromDate.trim().isEmpty()) && (toDate != null && !toDate.trim().isEmpty())) {
                Date toDt = sdf.parse(toDate);
                cal.setTime(toDt);
                cal.add(Calendar.MONTH, -3);
                fromDate = sdf.format(cal.getTime());
            } else if ((fromDate != null && !fromDate.trim().isEmpty()) && (toDate == null || toDate.trim().isEmpty())) {
                toDate = sdf.format(cal.getTime());
            }
        }

        String orderColumnIndex = request.getParameter("orderColumn");
        String orderDir = request.getParameter("orderDir");

        if (orderDir == null || orderDir.equals("")) {
            orderDir = "asc";
        }
        if (orderColumnIndex == null || orderColumnIndex.equals("")) {
            orderColumnIndex = "0";
        }

        String orderColumn = "b.id";

        if (orderColumnIndex != null) {

            switch (Integer.parseInt(orderColumnIndex)) {

                case 0:
                    orderColumn = "b.id";
                    break;
                case 1:
                    orderColumn = "b.pr_no";
                    break;
                case 2:
                    orderColumn = "b.pr_admin";
                    break;
                case 3:
                    orderColumn = "b.announce_date";
                    break;
                case 4:
                    orderColumn = "b.pr_authorize_user";
                    break;
                case 5:
                    orderColumn = "b.pr_authorize_date";
                    break;
                case 6:
                    orderColumn = "b.tender_assign_date";
                    break;
                case 7:
                    orderColumn = "b.authorize_flag";
                    break;
                case 8:
                    orderColumn = "b.tender_creater_id";
                    break;
                case 9:
                    orderColumn = "b.tender_creater_date";
                    break;
                case 10:
                    orderColumn = "b.pr_rework_date";
                    break;
                case 11:
                    orderColumn = "b.tender_creater_date";
                    break;
                case 12:
                    orderColumn = "b.title";
                    break;
                case 13:
                    orderColumn = "b.pr_comment";
                    break;
                case 14:
                    orderColumn = "b.final_close_date";
                    break;
                case 15:
                    orderColumn = "b.business_type";
                    break;
//                case 16:
//                    orderColumn = "daysLeft";
//                    break;
//                case 17:
//                    orderColumn = "announceApprovalDiff";
//                    break;
//                case 18:
//                    orderColumn = "announceApprovalDiff";
//                    break;
                case 19:
                    orderColumn = "a.submit_lastdate";
                    break;
                case 20:
                    orderColumn = "b.value";
                    break;
                case 21:
                    orderColumn = "c.po_no";
                    break;
                case 22:
                    orderColumn = "c.po_date";
                    break;
                case 23:
                    orderColumn = "c.po_value";
                    break;
                case 24:
                    orderColumn = "c.vendor_code";
                    break;
                default:
                    orderColumn = "b.id";
            }
        }

        if ("Unapproved PR".equals(statusFilter)) {
            statusFilter = "0";
        } else if ("Unassigned PR".equals(statusFilter)) {
            statusFilter = "1";
        } else if ("PR Rework".equals(statusFilter)) {
            statusFilter = "2";
        } else if ("PR Cancelled".equals(statusFilter)) {
            statusFilter = "3";
        } else if ("Tender Created".equals(statusFilter)) {
            statusFilter = "6";
        }

        int totalData = prMasterService.getPRRegisterExcelCount(searchValue, fromDate, toDate, id, prNo, prAdmin, announceDate, prAuthorizeUser, prAuthorizeDate, tenderAssignDate, statusFilter, tenderCreaterId, tenderCreaterDate, prReworkDate, title, prComment, finalCloseDate, businessType, announceApprovalDiff, prReworkDiff, submitLastdate, value, poNo, poDate, poValue, vendorCode);

        List list = prMasterService.getPRRegisterExcelData(0, totalData, searchValue, fromDate, toDate, id, prNo, prAdmin, announceDate, prAuthorizeUser, prAuthorizeDate, tenderAssignDate, statusFilter, tenderCreaterId, tenderCreaterDate, prReworkDate, title, prComment, finalCloseDate, businessType, announceApprovalDiff, prReworkDiff, submitLastdate, value, poNo, poDate, poValue, vendorCode, orderColumn, orderDir);

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("PR Register Report");

        XSSFFont boldFont = workbook.createFont();
        boldFont.setBold(true);

        XSSFCellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFont(boldFont);
        headerStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        int rownum = 0;

        String[] headers = {
            "PR No",
            "PR Created By",
            "PR Date",
            "PR Approval By",
            "PR Approval Date",
            "PR Value",
            "Tender Assign Date",
            "Status",
            "Assigned To",
            "Date Of Enquiry Floated",
            "PR Rework Date",
            "Title",
            "PR Comment",
            "Final Close Date",
            "Business Type",
            "Days Left",
            "Approval Latency",
            "Submit Last Date",
            "PO No",
            "PO Date",
            "PO Value",
            "Vendor Code"
        };

        Row headerRow = sheet.createRow(rownum++);
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(headerStyle);
        }

        for (Object obj : list) {

            Object[] rowData = (Object[]) obj;
            Row row = sheet.createRow(rownum++);

            row.createCell(0).setCellValue(rowData[0] == null ? "" : rowData[0].toString());
            row.createCell(1).setCellValue(rowData[1] == null ? "" : rowData[1].toString());
            row.createCell(2).setCellValue(rowData[2] == null ? "" : rowData[2].toString());
            row.createCell(3).setCellValue(rowData[3] == null ? "" : rowData[3].toString());
            row.createCell(4).setCellValue(rowData[4] == null ? "" : rowData[4].toString());

            if (rowData[5] != null) {
                row.createCell(5).setCellValue(Double.parseDouble(rowData[5].toString()));
            }

            row.createCell(6).setCellValue(rowData[6] == null ? "" : rowData[6].toString());

            String status = "";
            if (rowData[18] != null) {
                status = "PO Issued";
            } else if (rowData[7] != null) {
                int flag = Integer.parseInt(rowData[7].toString());
                switch (flag) {
                    case 0:
                        status = "Unapproved PR";
                        break;
                    case 1:
                        status = "Unassigned PR";
                        break;
                    case 2:
                        status = "PR Rework";
                        break;
                    case 3:
                        status = "PR Cancelled";
                        break;
                    case 6:
                        status = "Tender Created";
                        break;
                    default:
                        status = "Unknown";
                }
            }
            row.createCell(7).setCellValue(status);

            row.createCell(8).setCellValue(rowData[8] == null ? "" : rowData[8].toString());
            row.createCell(9).setCellValue(rowData[9] == null ? "" : rowData[9].toString());
            row.createCell(10).setCellValue(rowData[10] == null ? "" : rowData[10].toString());
            row.createCell(11).setCellValue(rowData[11] == null ? "" : rowData[11].toString());
            row.createCell(12).setCellValue(rowData[12] == null ? "" : rowData[12].toString());
            row.createCell(13).setCellValue(rowData[13] == null ? "" : rowData[13].toString());
            row.createCell(14).setCellValue(rowData[14] == null ? "" : rowData[14].toString());
            row.createCell(15).setCellValue(rowData[15] == null ? "" : rowData[15].toString());
            row.createCell(16).setCellValue(rowData[16] == null ? "" : rowData[16].toString());
            row.createCell(17).setCellValue(rowData[17] == null ? "" : rowData[17].toString());
            row.createCell(18).setCellValue(rowData[18] == null ? "" : rowData[18].toString());
            row.createCell(19).setCellValue(rowData[19] == null ? "" : rowData[19].toString());

            if (rowData[20] != null) {
                row.createCell(20).setCellValue(Double.parseDouble(rowData[20].toString()));
            }

            row.createCell(21).setCellValue(rowData[21] == null ? "" : rowData[21].toString());
        }

        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }

        String appPath = request.getServletContext().getRealPath("");
        String filePath = appPath + File.separator
                + "StorageYard"
                + File.separator
                + "Excel"
                + File.separator
                + "RegisterPRReport.xlsx";

        File file = new File(filePath);
        file.getParentFile().mkdirs();

        FileOutputStream fos = new FileOutputStream(file);
        workbook.write(fos);
        fos.close();

        request.setAttribute("filePath", filePath);

        DownloadFile downloadFile = new DownloadFile();
        downloadFile.doDownload(request, response);

        return null;
    }

    public ModelAndView tendernoRightsDashboard(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        UserRights userRights = userRightsService.readByUser(username);
        int createTender = userRights.getCreateTender();
        mv.getModelMap().put("createTender", createTender);

        List list0 = departmentMasterService.read();

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";
        String Filter = (request.getParameter("Filter") != null && !request.getParameter("Filter").trim().isEmpty())
                ? request.getParameter("Filter")
                : "--select--";
        String Department = request.getParameter("Department") != null ? request.getParameter("Department") : "";

        String formattedDate = "";
        String formattedStartDate = "";

        try {
            if (Filter.equals("last-month")) {
                LocalDateTime myDateObj = LocalDateTime.now();   // Current date and time
                LocalDateTime startDate = myDateObj.minusDays(30);  // Add 30 days

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                formattedDate = myDateObj.format(myFormatObj);   // Format current date
                formattedStartDate = startDate.format(myFormatObj);  // Format start date
            }
            if (Filter.equals("last-week")) {
                LocalDateTime myDateObj = LocalDateTime.now();   // Current date and time
                LocalDateTime startDate = myDateObj.minusDays(7);  // Add 1 week

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                formattedDate = myDateObj.format(myFormatObj);   // Format current date
                formattedStartDate = startDate.format(myFormatObj);  // Format start date   
            }
            if (Filter.equals("last-year")) {
                LocalDateTime myDateObj = LocalDateTime.now();   // Current date and time
                LocalDateTime startDate = myDateObj.minusDays(365);  // Add 1 year

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                formattedDate = myDateObj.format(myFormatObj);   // Format current date
                formattedStartDate = startDate.format(myFormatObj);  // Format start date   
            }
            if (Filter.equals("last-6-month")) {
                LocalDateTime myDateObj = LocalDateTime.now();   // Current date and time
                LocalDateTime startDate = myDateObj.minusDays(183);  // Add 6 months

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                formattedDate = myDateObj.format(myFormatObj);   // Format current date
                formattedStartDate = startDate.format(myFormatObj);  // Format start date   
            }
        } catch (Exception e) {

        }

        int prRaised = prMasterService.countAllPrFilterUser(username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);

        // Under Approval 
        int underApproval = prMasterService.readyByflagzeroFilterUser(username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);

        int livePr = prMasterService.readByflagonesixFilterUser(username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);

        //Rejected Pr
        int rejectedPr = prMasterService.countRejectedPrFilterUser(username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);

        //Tender Created
        int tendercount = tenderMasterService.countAllPrFilterUser(username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
//
//        //Tender closed
        int tenderclosed = tenderMasterService.readyByopenfalgFilterUser(username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
////Tender closed by force 
        int tenderclosedByForce = tenderMasterService.readytenderclosedByForce(username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);

//        // Live Tender
        int tenderLive = tenderMasterService.readByflagzeroFilterUser(username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);

// Assign To buyer
        int assignbuyer = prMasterService.readByprtenderFlagoneFilterUser(username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);

//            Pending to assign 
        int pendassign = prMasterService.readByprtenderFlagzeroFilterUser(username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);

        //Tender pending to float
        int approve = prMasterService.readbyflagoneFilterUser(username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);

        // Month Wise PR Data 
        List monthWiseList1 = prMasterService.monthWiseListPrFilterUser(username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);

        String prmonthName1 = "";
        String prnumberOfValue1 = "";

        String prmonthName2 = "";
        String prnumberOfValue2 = "";

        String prmonthName3 = "";
        String prnumberOfValue3 = "";

        String prmonthName4 = "";
        String prnumberOfValue4 = "";

        String prmonthName5 = "";
        String prnumberOfValue5 = "";

        String prmonthName6 = "";
        String prnumberOfValue6 = "";

        String prmonthName7 = "";
        String prnumberOfValue7 = "";

        String prmonthName8 = "";
        String prnumberOfValue8 = "";

        String prmonthName9 = "";
        String prnumberOfValue9 = "";

        String prmonthName10 = "";
        String prnumberOfValue10 = "";

        String prmonthName11 = "";
        String prnumberOfValue11 = "";

        String prmonthName12 = "";
        String prnumberOfValue12 = "";

        int i3 = 0;

        for (Object empId2 : monthWiseList1) {
            i3++;

            Object[] obj = (Object[]) empId2;
            if (i3 == 1) {
                prnumberOfValue1 = "" + obj[0];
                prmonthName1 = "" + obj[1];
            }
            if (i3 == 2) {
                prnumberOfValue2 = "" + obj[0];
                prmonthName2 = "" + obj[1];
            }
            if (i3 == 3) {
                prnumberOfValue3 = "" + obj[0];
                prmonthName3 = "" + obj[1];
            }
            if (i3 == 4) {
                prnumberOfValue4 = "" + obj[0];
                prmonthName4 = "" + obj[1];
            }
            if (i3 == 5) {
                prnumberOfValue5 = "" + obj[0];
                prmonthName5 = "" + obj[1];
            }

            if (i3 == 6) {
                prnumberOfValue6 = "" + obj[0];
                prmonthName6 = "" + obj[1];
            }
            if (i3 == 7) {
                prnumberOfValue7 = "" + obj[0];
                prmonthName7 = "" + obj[1];
            }
            if (i3 == 8) {
                prnumberOfValue8 = "" + obj[0];
                prmonthName8 = "" + obj[1];
            }
            if (i3 == 9) {
                prnumberOfValue9 = "" + obj[0];
                prmonthName9 = "" + obj[1];
            }
            if (i3 == 10) {
                prnumberOfValue10 = "" + obj[0];
                prmonthName10 = "" + obj[1];

            }
            if (i3 == 11) {
                prnumberOfValue11 = "" + obj[0];
                prmonthName11 = "" + obj[1];
            }
            if (i3 == 12) {
                prnumberOfValue12 = "" + obj[0];
                prmonthName12 = "" + obj[1];
                break;
            }

        }

//         List list4 = prMasterService.approvedPRListDashboad();
        mv.getModelMap().put("prmonthName1", prmonthName1); //month
        mv.getModelMap().put("prnumberOfValue1", prnumberOfValue1);//data
        mv.getModelMap().put("prmonthName2", prmonthName2);
        mv.getModelMap().put("prnumberOfValue2", prnumberOfValue2);
        mv.getModelMap().put("prmonthName3", prmonthName3);
        mv.getModelMap().put("prnumberOfValue3", prnumberOfValue3);
        mv.getModelMap().put("prmonthName4", prmonthName4);
        mv.getModelMap().put("prnumberOfValue4", prnumberOfValue4);
        mv.getModelMap().put("prmonthName5", prmonthName5);
        mv.getModelMap().put("prnumberOfValue5", prnumberOfValue5);
        mv.getModelMap().put("prmonthName6", prmonthName6);
        mv.getModelMap().put("prnumberOfValue6", prnumberOfValue6);
        mv.getModelMap().put("prmonthName7", prmonthName7);
        mv.getModelMap().put("prnumberOfValue7", prnumberOfValue7);
        mv.getModelMap().put("prmonthName8", prmonthName8);
        mv.getModelMap().put("prnumberOfValue8", prnumberOfValue8);
        mv.getModelMap().put("prmonthName9", prmonthName9);
        mv.getModelMap().put("prnumberOfValue9", prnumberOfValue9);
        mv.getModelMap().put("prmonthName10", prmonthName10);
        mv.getModelMap().put("prnumberOfValue10", prnumberOfValue10);
        mv.getModelMap().put("prmonthName11", prmonthName11);
        mv.getModelMap().put("prnumberOfValue11", prnumberOfValue11);
        mv.getModelMap().put("prmonthName12", prmonthName12);
        mv.getModelMap().put("prnumberOfValue12", prnumberOfValue12);

        // Month Wise Tender Data
        List monthWiseList = tenderMasterService.readByMonthFilterUser(username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);

        String monthName1 = "";
        String numberOfValue1 = "";

        String monthName2 = "";
        String numberOfValue2 = "";

        String monthName3 = "";
        String numberOfValue3 = "";

        String monthName4 = "";
        String numberOfValue4 = "";

        String monthName5 = "";
        String numberOfValue5 = "";

        String monthName6 = "";
        String numberOfValue6 = "";

        String monthName7 = "";
        String numberOfValue7 = "";

        String monthName8 = "";
        String numberOfValue8 = "";

        String monthName9 = "";
        String numberOfValue9 = "";

        String monthName10 = "";
        String numberOfValue10 = "";

        String monthName11 = "";
        String numberOfValue11 = "";

        String monthName12 = "";
        String numberOfValue12 = "";

        int i2 = 0;

        for (Object empId1 : monthWiseList) {
            i2++;

            Object[] obj = (Object[]) empId1;
            if (i2 == 1) {
                numberOfValue1 = "" + obj[0];
                monthName1 = "" + obj[1];
            }
            if (i2 == 2) {
                numberOfValue2 = "" + obj[0];
                monthName2 = "" + obj[1];
            }
            if (i2 == 3) {
                numberOfValue3 = "" + obj[0];
                monthName3 = "" + obj[1];
            }
            if (i2 == 4) {
                numberOfValue4 = "" + obj[0];
                monthName4 = "" + obj[1];
            }
            if (i2 == 5) {
                numberOfValue5 = "" + obj[0];
                monthName5 = "" + obj[1];
            }

            if (i2 == 6) {
                numberOfValue6 = "" + obj[0];
                monthName6 = "" + obj[1];
            }
            if (i2 == 7) {
                numberOfValue7 = "" + obj[0];
                monthName7 = "" + obj[1];
            }
            if (i2 == 8) {
                numberOfValue8 = "" + obj[0];
                monthName8 = "" + obj[1];
            }
            if (i2 == 9) {
                numberOfValue9 = "" + obj[0];
                monthName9 = "" + obj[1];
            }
            if (i2 == 10) {
                numberOfValue10 = "" + obj[0];
                monthName10 = "" + obj[1];
            }
            if (i2 == 11) {
                numberOfValue11 = "" + obj[0];
                monthName11 = "" + obj[1];
            }
            if (i2 == 12) {
                numberOfValue12 = "" + obj[0];
                monthName12 = "" + obj[1];
                break;
            }

        }

        mv.getModelMap().put("monthName1", monthName1);
        mv.getModelMap().put("numberOfValue1", numberOfValue1);
        mv.getModelMap().put("monthName2", monthName2);
        mv.getModelMap().put("numberOfValue2", numberOfValue2);
        mv.getModelMap().put("monthName3", monthName3);
        mv.getModelMap().put("numberOfValue3", numberOfValue3);
        mv.getModelMap().put("monthName4", monthName4);
        mv.getModelMap().put("numberOfValue4", numberOfValue4);
        mv.getModelMap().put("monthName5", monthName5);
        mv.getModelMap().put("numberOfValue5", numberOfValue5);
        mv.getModelMap().put("monthName6", monthName6);
        mv.getModelMap().put("numberOfValue6", numberOfValue6);
        mv.getModelMap().put("monthName7", monthName7);
        mv.getModelMap().put("numberOfValue7", numberOfValue7);
        mv.getModelMap().put("monthName8", monthName8);
        mv.getModelMap().put("numberOfValue8", numberOfValue8);
        mv.getModelMap().put("monthName9", monthName9);
        mv.getModelMap().put("numberOfValue9", numberOfValue9);
        mv.getModelMap().put("monthName10", monthName10);
        mv.getModelMap().put("numberOfValue10", numberOfValue10);
        mv.getModelMap().put("monthName11", monthName11);
        mv.getModelMap().put("numberOfValue11", numberOfValue11);
        mv.getModelMap().put("monthName12", monthName12);
        mv.getModelMap().put("numberOfValue12", numberOfValue12);

        List contwise = tenderMasterService.readBycontactperFilterUser(username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);

        List contwise1 = prMasterService.readBycontactperFilterUser(username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);

        String firstElement1_1 = "", firstElement1_2 = "", firstElement1_3 = "", firstElement1_4 = "";
        String secondElement1_1 = "", secondElement1_2 = "", secondElement1_3 = "", secondElement1_4 = "";
        String thirdElement1_1 = "", thirdElement1_2 = "", thirdElement1_3 = "", thirdElement1_4 = "";
        String fourthElement1_1 = "", fourthElement1_2 = "", fourthElement1_3 = "", fourthElement1_4 = "";
        String fifthElement1_1 = "", fifthElement1_2 = "", fifthElement1_3 = "", fifthElement1_4 = "";
        String sixthElement1_1 = "", sixthElement1_2 = "", sixthElement1_3 = "", sixthElement1_4 = "";
        String seventhElement1_1 = "", seventhElement1_2 = "", seventhElement1_3 = "", seventhElement1_4 = "";
        String eighthElement1_1 = "", eighthElement1_2 = "", eighthElement1_3 = "", eighthElement1_4 = "";
        String ninthElement1_1 = "", ninthElement1_2 = "", ninthElement1_3 = "", ninthElement1_4 = "";
        String tenthElement1_1 = "", tenthElement1_2 = "", tenthElement1_3 = "", tenthElement1_4 = "";
        int count = 0;

        for (Object o1 : contwise) {
            Object[] o11 = (Object[]) o1;

            if (o11.length > 3) {
                String elementValue1 = o11[0] != null ? o11[0].toString() : "";
                String elementValue2 = o11[1] != null ? o11[1].toString() : "0";
                String elementValue3 = o11[2] != null ? o11[2].toString() : "0";
                String elementValue4 = o11[3] != null ? o11[3].toString() : "0";

                if (count == 0) {
                    firstElement1_1 = elementValue1;
                    firstElement1_2 = elementValue2;
                    firstElement1_3 = elementValue3;
                    firstElement1_4 = elementValue4;

                } else if (count == 1) {
                    secondElement1_1 = elementValue1;
                    secondElement1_2 = elementValue2;
                    secondElement1_3 = elementValue3;
                    secondElement1_4 = elementValue4;

                } else if (count == 2) {
                    thirdElement1_1 = elementValue1;
                    thirdElement1_2 = elementValue2;
                    thirdElement1_3 = elementValue3;
                    thirdElement1_4 = elementValue4;

                } else if (count == 3) {
                    fourthElement1_1 = elementValue1;
                    fourthElement1_2 = elementValue2;
                    fourthElement1_3 = elementValue3;
                    fourthElement1_4 = elementValue4;

                } else if (count == 4) {
                    fifthElement1_1 = elementValue1;
                    fifthElement1_2 = elementValue2;
                    fifthElement1_3 = elementValue3;
                    fifthElement1_4 = elementValue4;

                } else if (count == 5) {
                    sixthElement1_1 = elementValue1;
                    sixthElement1_2 = elementValue2;
                    sixthElement1_3 = elementValue3;
                    sixthElement1_4 = elementValue4;

                } else if (count == 6) {
                    seventhElement1_1 = elementValue1;
                    seventhElement1_2 = elementValue2;
                    seventhElement1_3 = elementValue3;
                    seventhElement1_4 = elementValue4;

                } else if (count == 7) {
                    eighthElement1_1 = elementValue1;
                    eighthElement1_2 = elementValue2;
                    eighthElement1_3 = elementValue3;
                    eighthElement1_4 = elementValue4;

                } else if (count == 8) {
                    ninthElement1_1 = elementValue1;
                    ninthElement1_2 = elementValue2;
                    ninthElement1_3 = elementValue3;
                    ninthElement1_4 = elementValue4;

                } else if (count == 9) {
                    tenthElement1_1 = elementValue1;
                    tenthElement1_2 = elementValue2;
                    tenthElement1_3 = elementValue3;
                    tenthElement1_4 = elementValue4;
                    break;
                }
            }
            count++;
            System.out.println("Processing row: " + count);
        }

        mv.getModelMap().put("firstElement1_1", firstElement1_1);
        mv.getModelMap().put("firstElement1_2", firstElement1_2);
        mv.getModelMap().put("firstElement1_3", firstElement1_3);
        mv.getModelMap().put("firstElement1_4", firstElement1_4);

        mv.getModelMap().put("secondElement1_1", secondElement1_1);
        mv.getModelMap().put("secondElement1_2", secondElement1_2);
        mv.getModelMap().put("secondElement1_3", secondElement1_3);
        mv.getModelMap().put("secondElement1_4", secondElement1_4);

        mv.getModelMap().put("thirdElement1_1", thirdElement1_1);
        mv.getModelMap().put("thirdElement1_2", thirdElement1_2);
        mv.getModelMap().put("thirdElement1_3", thirdElement1_3);
        mv.getModelMap().put("thirdElement1_4", thirdElement1_4);

        mv.getModelMap().put("fourthElement1_1", fourthElement1_1);
        mv.getModelMap().put("fourthElement1_2", fourthElement1_2);
        mv.getModelMap().put("fourthElement1_3", fourthElement1_3);
        mv.getModelMap().put("fourthElement1_4", fourthElement1_4);

        mv.getModelMap().put("fifthElement1_1", fifthElement1_1);
        mv.getModelMap().put("fifthElement1_2", fifthElement1_2);
        mv.getModelMap().put("fifthElement1_3", fifthElement1_3);
        mv.getModelMap().put("fifthElement1_4", fifthElement1_4);

        mv.getModelMap().put("sixthElement1_1", sixthElement1_1);
        mv.getModelMap().put("sixthElement1_2", sixthElement1_2);
        mv.getModelMap().put("sixthElement1_3", sixthElement1_3);
        mv.getModelMap().put("sixthElement1_4", sixthElement1_4);

        mv.getModelMap().put("seventhElement1_1", seventhElement1_1);
        mv.getModelMap().put("seventhElement1_2", seventhElement1_2);
        mv.getModelMap().put("seventhElement1_3", seventhElement1_3);
        mv.getModelMap().put("seventhElement1_4", seventhElement1_4);

        mv.getModelMap().put("eighthElement1_1", eighthElement1_1);
        mv.getModelMap().put("eighthElement1_2", eighthElement1_2);
        mv.getModelMap().put("eighthElement1_3", eighthElement1_3);
        mv.getModelMap().put("eighthElement1_4", eighthElement1_4);

        mv.getModelMap().put("ninthElement1_1", ninthElement1_1);
        mv.getModelMap().put("ninthElement1_2", ninthElement1_2);
        mv.getModelMap().put("ninthElement1_3", ninthElement1_3);
        mv.getModelMap().put("ninthElement1_4", ninthElement1_4);

        mv.getModelMap().put("tenthElement1_1", tenthElement1_1);
        mv.getModelMap().put("tenthElement1_2", tenthElement1_2);
        mv.getModelMap().put("tenthElement1_3", tenthElement1_3);
        mv.getModelMap().put("tenthElement1_4", tenthElement1_4);

        mv.getModelMap().put("prRaised", prRaised);
        mv.getModelMap().put("livePr", livePr);
        mv.getModelMap().put("tendercount", tendercount);
        mv.getModelMap().put("tenderclosed", tenderclosed);
        mv.getModelMap().put("tenderclosedByForce", tenderclosedByForce);

        mv.getModelMap().put("tenderLive", tenderLive);
        mv.getModelMap().put("underApproval", underApproval);
        mv.getModelMap().put("assbuyer", assignbuyer);
        mv.getModelMap().put("pendassign", pendassign);
        mv.getModelMap().put("approve", approve);
        mv.getModelMap().put("rejectedPr", rejectedPr);
        mv.getModelMap().put("list0", list0);

        mv.setViewName("Dashboard/DashboardUser");

        return mv;

    }

    public ModelAndView totalPr(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        UserRights userRights = userRightsService.readByUser(username);
        int createTender = userRights.getCreateTender();
        mv.getModelMap().put("createTender", createTender);
//
//        if (createTender == 1) {
//            username = "";
//        }
//
        List list0 = departmentMasterService.read();
        mv.getModelMap().put("list0", list0);

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";

        SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");

        try {
            if (!Fromdate.isEmpty()) {
                Date fromDateObj = inputFormat.parse(Fromdate);
                Fromdate = outputFormat.format(fromDateObj);
            }

            if (!Todate.isEmpty()) {
                Date toDateObj = inputFormat.parse(Todate);
                Todate = outputFormat.format(toDateObj);
            }
        } catch (Exception e) {

        }

        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";
        String Department = request.getParameter("Department") != null ? request.getParameter("Department") : "";
        String formattedDate = request.getParameter("formattedDate") != null ? request.getParameter("formattedDate") : "";
        String formattedStartDate = request.getParameter("formattedStartDate") != null ? request.getParameter("formattedStartDate") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }
        if (Department.equals("--select--")) {
            Department = "";
        }

        try {
            if (Filter.equals("last-month")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(30);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-week")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(7);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-year")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(365);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-6-month")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(183);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
        } catch (Exception e) {

        }
        mv.getModelMap().put("Filter", Filter);
        mv.getModelMap().put("Department", Department);
        mv.getModelMap().put("Fromdate", Fromdate);
        mv.getModelMap().put("Todate", Todate);

//
//        List list = prMasterService.totalPrUser(username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
//        mv.getModelMap().put("list", list);
        mv.setViewName("Dashboard/TotalPr");
        return mv;

    }

    public ModelAndView underApproval(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        UserRights userRights = userRightsService.readByUser(username);
        int createTender = userRights.getCreateTender();
        mv.getModelMap().put("createTender", createTender);

        if (createTender == 1) {
            username = "";
        }
        List list0 = departmentMasterService.read();
        mv.getModelMap().put("list0", list0);

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";

        SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");

        try {
            if (!Fromdate.isEmpty()) {
                Date fromDateObj = inputFormat.parse(Fromdate);
                Fromdate = outputFormat.format(fromDateObj);
            }

            if (!Todate.isEmpty()) {
                Date toDateObj = inputFormat.parse(Todate);
                Todate = outputFormat.format(toDateObj);
            }
        } catch (Exception e) {

        }

        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";
        String Department = request.getParameter("Department") != null ? request.getParameter("Department") : "";
        String formattedDate = request.getParameter("formattedDate") != null ? request.getParameter("formattedDate") : "";
        String formattedStartDate = request.getParameter("formattedStartDate") != null ? request.getParameter("formattedStartDate") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }
        if (Department.equals("--select--")) {
            Department = "";
        }

        try {
            if (Filter.equals("last-month")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(30);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-week")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(7);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-year")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(365);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-6-month")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(183);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
        } catch (Exception e) {

        }

        mv.getModelMap().put("Filter", Filter);
        mv.getModelMap().put("Department", Department);
        mv.getModelMap().put("Fromdate", Fromdate);
        mv.getModelMap().put("Todate", Todate);

//        List list = prMasterService.totalUnderApproval(username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
//        mv.getModelMap().put("list", list);
        mv.setViewName("Dashboard/UnderApproval");

        return mv;

    }

    public ModelAndView livePr(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        UserRights userRights = userRightsService.readByUser(username);
        int createTender = userRights.getCreateTender();
        mv.getModelMap().put("createTender", createTender);

        if (createTender == 1) {
            username = "";
        }

        List list0 = departmentMasterService.read();
        mv.getModelMap().put("list0", list0);

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";

        SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");

        try {
            if (!Fromdate.isEmpty()) {
                Date fromDateObj = inputFormat.parse(Fromdate);
                Fromdate = outputFormat.format(fromDateObj);
            }

            if (!Todate.isEmpty()) {
                Date toDateObj = inputFormat.parse(Todate);
                Todate = outputFormat.format(toDateObj);
            }
        } catch (Exception e) {

        }

        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";
        String Department = request.getParameter("Department") != null ? request.getParameter("Department") : "";
        String formattedDate = request.getParameter("formattedDate") != null ? request.getParameter("formattedDate") : "";
        String formattedStartDate = request.getParameter("formattedStartDate") != null ? request.getParameter("formattedStartDate") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }
        if (Department.equals("--select--")) {
            Department = "";
        }

        try {
            if (Filter.equals("last-month")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(30);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-week")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(7);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-year")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(365);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-6-month")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(183);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
        } catch (Exception e) {

        }
        mv.getModelMap().put("Filter", Filter);
        mv.getModelMap().put("Department", Department);
        mv.getModelMap().put("Fromdate", Fromdate);
        mv.getModelMap().put("Todate", Todate);

//        List list = prMasterService.totalLivePr(username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
//        mv.getModelMap().put("list", list);
        mv.setViewName("Dashboard/LivePr");
        return mv;

    }

    public ModelAndView rejectedPr(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        UserRights userRights = userRightsService.readByUser(username);
        int createTender = userRights.getCreateTender();
        mv.getModelMap().put("createTender", createTender);

        if (createTender == 1) {
            username = "";
        }

        List list0 = departmentMasterService.read();
        mv.getModelMap().put("list0", list0);

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";

        SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");

        try {
            if (!Fromdate.isEmpty()) {
                Date fromDateObj = inputFormat.parse(Fromdate);
                Fromdate = outputFormat.format(fromDateObj);
            }

            if (!Todate.isEmpty()) {
                Date toDateObj = inputFormat.parse(Todate);
                Todate = outputFormat.format(toDateObj);
            }
        } catch (Exception e) {

        }

        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";
        String Department = request.getParameter("Department") != null ? request.getParameter("Department") : "";
        String formattedDate = request.getParameter("formattedDate") != null ? request.getParameter("formattedDate") : "";
        String formattedStartDate = request.getParameter("formattedStartDate") != null ? request.getParameter("formattedStartDate") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }
        if (Department.equals("--select--")) {
            Department = "";
        }

        try {
            if (Filter.equals("last-month")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(30);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-week")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(7);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-year")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(365);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-6-month")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(183);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
        } catch (Exception e) {

        }
        mv.getModelMap().put("Filter", Filter);
        mv.getModelMap().put("Department", Department);
        mv.getModelMap().put("Fromdate", Fromdate);
        mv.getModelMap().put("Todate", Todate);

        //Rejected Pr
//        List list = prMasterService.totalRejectedPr(username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
//        mv.getModelMap().put("list", list);
        mv.setViewName("Dashboard/RejectedPr");
        return mv;

    }

    public ModelAndView tenderCreated(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        UserRights userRights = userRightsService.readByUser(username);
        int createTender = userRights.getCreateTender();
        mv.getModelMap().put("createTender", createTender);

        if (createTender == 1) {
            username = "";
        }

        List list0 = departmentMasterService.read();
        mv.getModelMap().put("list0", list0);

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";

        SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");

        try {
            if (!Fromdate.isEmpty()) {
                Date fromDateObj = inputFormat.parse(Fromdate);
                Fromdate = outputFormat.format(fromDateObj);
            }

            if (!Todate.isEmpty()) {
                Date toDateObj = inputFormat.parse(Todate);
                Todate = outputFormat.format(toDateObj);
            }
        } catch (Exception e) {

        }

        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";
        String Department = request.getParameter("Department") != null ? request.getParameter("Department") : "";
        String formattedDate = request.getParameter("formattedDate") != null ? request.getParameter("formattedDate") : "";
        String formattedStartDate = request.getParameter("formattedStartDate") != null ? request.getParameter("formattedStartDate") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }
        if (Department.equals("--select--")) {
            Department = "";
        }

        try {
            if (Filter.equals("last-month")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(30);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-week")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(7);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-year")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(365);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-6-month")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(183);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
        } catch (Exception e) {

        }
        mv.getModelMap().put("Filter", Filter);
        mv.getModelMap().put("Department", Department);
        mv.getModelMap().put("Fromdate", Fromdate);
        mv.getModelMap().put("Todate", Todate);

        //Tender Created
//        List list = tenderMasterService.totalTender(username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
//        mv.getModelMap().put("list", list);
        mv.setViewName("Dashboard/TenderCreated");
        return mv;

    }

    public ModelAndView tenderClosed(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        UserRights userRights = userRightsService.readByUser(username);
        int createTender = userRights.getCreateTender();
        mv.getModelMap().put("createTender", createTender);

        if (createTender == 1) {
            username = "";
        }

        List list0 = departmentMasterService.read();
        mv.getModelMap().put("list0", list0);

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";

        SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");

        try {
            if (!Fromdate.isEmpty()) {
                Date fromDateObj = inputFormat.parse(Fromdate);
                Fromdate = outputFormat.format(fromDateObj);
            }

            if (!Todate.isEmpty()) {
                Date toDateObj = inputFormat.parse(Todate);
                Todate = outputFormat.format(toDateObj);
            }
        } catch (Exception e) {

        }

        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";
        String Department = request.getParameter("Department") != null ? request.getParameter("Department") : "";
        String formattedDate = request.getParameter("formattedDate") != null ? request.getParameter("formattedDate") : "";
        String formattedStartDate = request.getParameter("formattedStartDate") != null ? request.getParameter("formattedStartDate") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }
        if (Department.equals("--select--")) {
            Department = "";
        }

        try {
            if (Filter.equals("last-month")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(30);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-week")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(7);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-year")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(365);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-6-month")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(183);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
        } catch (Exception e) {

        }

        mv.getModelMap().put("Filter", Filter);
        mv.getModelMap().put("Department", Department);
        mv.getModelMap().put("Fromdate", Fromdate);
        mv.getModelMap().put("Todate", Todate);

//readyByopenfalgFilterUser
//        //Tender closed
//        List list = tenderMasterService.totalTenderClosed(username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
//        mv.getModelMap().put("list", list);
        mv.setViewName("Dashboard/TenderClosed");
        return mv;

    }

    public ModelAndView tenderClosedByForce(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        UserRights userRights = userRightsService.readByUser(username);
        int createTender = userRights.getCreateTender();
        mv.getModelMap().put("createTender", createTender);

        if (createTender == 1) {
            username = "";
        }

        List list0 = departmentMasterService.read();
        mv.getModelMap().put("list0", list0);

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";

        SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");

        try {
            if (!Fromdate.isEmpty()) {
                Date fromDateObj = inputFormat.parse(Fromdate);
                Fromdate = outputFormat.format(fromDateObj);
            }

            if (!Todate.isEmpty()) {
                Date toDateObj = inputFormat.parse(Todate);
                Todate = outputFormat.format(toDateObj);
            }
        } catch (Exception e) {

        }

        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";
        String Department = request.getParameter("Department") != null ? request.getParameter("Department") : "";
        String formattedDate = request.getParameter("formattedDate") != null ? request.getParameter("formattedDate") : "";
        String formattedStartDate = request.getParameter("formattedStartDate") != null ? request.getParameter("formattedStartDate") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }
        if (Department.equals("--select--")) {
            Department = "";
        }

        try {
            if (Filter.equals("last-month")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(30);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-week")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(7);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-year")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(365);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-6-month")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(183);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
        } catch (Exception e) {

        }
        mv.getModelMap().put("Filter", Filter);
        mv.getModelMap().put("Department", Department);
        mv.getModelMap().put("Fromdate", Fromdate);
        mv.getModelMap().put("Todate", Todate);

//readyByopenfalgFilterUser
//        //Tender closed
//        List list = tenderMasterService.totalTenderClosedByForce(username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
//        mv.getModelMap().put("list", list);
        mv.setViewName("Dashboard/TenderClosedByForce");
        return mv;

    }

    public ModelAndView liveTender(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        UserRights userRights = userRightsService.readByUser(username);
        int createTender = userRights.getCreateTender();
        mv.getModelMap().put("createTender", createTender);

        if (createTender == 1) {
            username = "";
        }

        List list0 = departmentMasterService.read();
        mv.getModelMap().put("list0", list0);

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";

        SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");

        try {
            if (!Fromdate.isEmpty()) {
                Date fromDateObj = inputFormat.parse(Fromdate);
                Fromdate = outputFormat.format(fromDateObj);
            }

            if (!Todate.isEmpty()) {
                Date toDateObj = inputFormat.parse(Todate);
                Todate = outputFormat.format(toDateObj);
            }
        } catch (Exception e) {

        }

        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";
        String Department = request.getParameter("Department") != null ? request.getParameter("Department") : "";
        String formattedDate = request.getParameter("formattedDate") != null ? request.getParameter("formattedDate") : "";
        String formattedStartDate = request.getParameter("formattedStartDate") != null ? request.getParameter("formattedStartDate") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }
        if (Department.equals("--select--")) {
            Department = "";
        }

        try {
            if (Filter.equals("last-month")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(30);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-week")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(7);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-year")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(365);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-6-month")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(183);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
        } catch (Exception e) {

        }

        mv.getModelMap().put("Filter", Filter);
        mv.getModelMap().put("Department", Department);
        mv.getModelMap().put("Fromdate", Fromdate);
        mv.getModelMap().put("Todate", Todate);

//        readByflagzeroFilterUser
        // Live Tender
//        List list = tenderMasterService.totalLiveTender(username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
//        mv.getModelMap().put("list", list);
        mv.setViewName("Dashboard/LiveTender");
        return mv;

    }

    public ModelAndView assginedToBuyer(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        UserRights userRights = userRightsService.readByUser(username);
        int createTender = userRights.getCreateTender();
        mv.getModelMap().put("createTender", createTender);

        if (createTender == 1) {
            username = "";
        }

        List list0 = departmentMasterService.read();
        mv.getModelMap().put("list0", list0);

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";

        SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");

        try {
            if (!Fromdate.isEmpty()) {
                Date fromDateObj = inputFormat.parse(Fromdate);
                Fromdate = outputFormat.format(fromDateObj);
            }

            if (!Todate.isEmpty()) {
                Date toDateObj = inputFormat.parse(Todate);
                Todate = outputFormat.format(toDateObj);
            }
        } catch (Exception e) {

        }

        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";
        String Department = request.getParameter("Department") != null ? request.getParameter("Department") : "";
        String formattedDate = request.getParameter("formattedDate") != null ? request.getParameter("formattedDate") : "";
        String formattedStartDate = request.getParameter("formattedStartDate") != null ? request.getParameter("formattedStartDate") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }
        if (Department.equals("--select--")) {
            Department = "";
        }

        try {
            if (Filter.equals("last-month")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(30);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-week")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(7);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-year")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(365);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-6-month")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(183);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
        } catch (Exception e) {

        }
        mv.getModelMap().put("Filter", Filter);
        mv.getModelMap().put("Department", Department);
        mv.getModelMap().put("Fromdate", Fromdate);
        mv.getModelMap().put("Todate", Todate);

// Assign To buyer
//        List list = prMasterService.totalAssignToBuyer(username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
//        mv.getModelMap().put("list", list);
        mv.setViewName("Dashboard/AssignedToBuyer");
        return mv;

    }

    public ModelAndView pendingToAssign(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        UserRights userRights = userRightsService.readByUser(username);
        int createTender = userRights.getCreateTender();
        mv.getModelMap().put("createTender", createTender);

        if (createTender == 1) {
            username = "";
        }

        List list0 = departmentMasterService.read();
        mv.getModelMap().put("list0", list0);

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";

        SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");

        try {
            if (!Fromdate.isEmpty()) {
                Date fromDateObj = inputFormat.parse(Fromdate);
                Fromdate = outputFormat.format(fromDateObj);
            }

            if (!Todate.isEmpty()) {
                Date toDateObj = inputFormat.parse(Todate);
                Todate = outputFormat.format(toDateObj);
            }
        } catch (Exception e) {

        }

        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";
        String Department = request.getParameter("Department") != null ? request.getParameter("Department") : "";
        String formattedDate = request.getParameter("formattedDate") != null ? request.getParameter("formattedDate") : "";
        String formattedStartDate = request.getParameter("formattedStartDate") != null ? request.getParameter("formattedStartDate") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }
        if (Department.equals("--select--")) {
            Department = "";
        }

        try {
            if (Filter.equals("last-month")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(30);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-week")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(7);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-year")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(365);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-6-month")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(183);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
        } catch (Exception e) {

        }

        mv.getModelMap().put("Filter", Filter);
        mv.getModelMap().put("Department", Department);
        mv.getModelMap().put("Fromdate", Fromdate);
        mv.getModelMap().put("Todate", Todate);

//            Pending to assign 
//        List list = prMasterService.totalPendingToAssign(username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
//        mv.getModelMap().put("list", list);
        mv.setViewName("Dashboard/PendingToAssign");
        return mv;

    }

    public ModelAndView tenderPendingToFloat(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        UserRights userRights = userRightsService.readByUser(username);
        int createTender = userRights.getCreateTender();
        mv.getModelMap().put("createTender", createTender);

        if (createTender == 1) {
            username = "";
        }

        List list0 = departmentMasterService.read();
        mv.getModelMap().put("list0", list0);

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";

        SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");

        try {
            if (!Fromdate.isEmpty()) {
                Date fromDateObj = inputFormat.parse(Fromdate);
                Fromdate = outputFormat.format(fromDateObj);
            }

            if (!Todate.isEmpty()) {
                Date toDateObj = inputFormat.parse(Todate);
                Todate = outputFormat.format(toDateObj);
            }
        } catch (Exception e) {

        }

        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";
        String Department = request.getParameter("Department") != null ? request.getParameter("Department") : "";
        String formattedDate = request.getParameter("formattedDate") != null ? request.getParameter("formattedDate") : "";
        String formattedStartDate = request.getParameter("formattedStartDate") != null ? request.getParameter("formattedStartDate") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }
        if (Department.equals("--select--")) {
            Department = "";
        }

        try {
            if (Filter.equals("last-month")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(30);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-week")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(7);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-year")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(365);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-6-month")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(183);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
        } catch (Exception e) {

        }

        mv.getModelMap().put("Filter", Filter);
        mv.getModelMap().put("Department", Department);
        mv.getModelMap().put("Fromdate", Fromdate);
        mv.getModelMap().put("Todate", Todate);
//        List list = prMasterService.totalPendingToFloat(username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
//        mv.getModelMap().put("list", list);

        mv.setViewName("Dashboard/TenderPendingToFloat");
        return mv;

    }

    public ModelAndView monthWisePr(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
//        HttpSession session = request.getSession(false);
//        UserMaster user = (UserMaster) session.getAttribute("user");
//        String username = user.getLoginName();
//        UserRights userRights = userRightsService.readByUser(username);
//        int createTender = userRights.getCreateTender();
//        mv.getModelMap().put("createTender", createTender);
//
//        if (createTender == 1) {
//            username = "";
//        }
//
//        List list0 = departmentMasterService.read();
//        mv.getModelMap().put("list0", list0);
//
//        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
//        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";
//
//        SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
//        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
//
//        try {
//            if (!Fromdate.isEmpty()) {
//                Date fromDateObj = inputFormat.parse(Fromdate);
//                Fromdate = outputFormat.format(fromDateObj);
//            }
//
//            if (!Todate.isEmpty()) {
//                Date toDateObj = inputFormat.parse(Todate);
//                Todate = outputFormat.format(toDateObj);
//            }
//        } catch (Exception e) {
//
//        }
//        String startDatee = "";
//        String endDatee = "";
////        String MonthName0 = request.getParameter("label");
//        String MonthName1 = request.getParameter("label");
//        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MMM-yy", Locale.ENGLISH);
//        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MMMM-yyyy", Locale.ENGLISH);
//
//        YearMonth yearMonth = YearMonth.parse(MonthName1, inputFormatter);
//        String MonthName = yearMonth.format(outputFormatter);
//
//        try {
//
//            SimpleDateFormat sdf = new SimpleDateFormat("MMMM-yyyy");
//            Date date = sdf.parse(MonthName);
//
//            Calendar startCalendar = Calendar.getInstance();
//            startCalendar.setTime(date);
//            startCalendar.set(Calendar.DAY_OF_MONTH, 1);
//            startDatee = new SimpleDateFormat("dd-MM-yyyy").format(startCalendar.getTime());
//
//            Calendar endCalendar = Calendar.getInstance();
//            endCalendar.setTime(date);
//            endCalendar.set(Calendar.DAY_OF_MONTH, endCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));
//            endDatee = new SimpleDateFormat("dd-MM-yyyy").format(endCalendar.getTime());
//
//        } catch (Exception e) {
//
//        }
//        String EndDate = endDatee;
//        String StartDate = startDatee;
//
//        List monthWiseList1 = prMasterService.monthWiseListPrGraphUser(username, StartDate, EndDate, Filter, formattedDate, formattedStartDate, Department);
//        mv.getModelMap().put("list", monthWiseList1);
//        mv.getModelMap().put("MonthName", MonthName);
//        mv.getModelMap().put("MonthName0", MonthName1);

        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";
        String Department = request.getParameter("Department") != null ? request.getParameter("Department") : "";
        String formattedDate = request.getParameter("formattedDate") != null ? request.getParameter("formattedDate") : "";
        String formattedStartDate = request.getParameter("formattedStartDate") != null ? request.getParameter("formattedStartDate") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }
        if (Department.equals("--select--")) {
            Department = "";
        }

        try {
            if (Filter.equals("last-month")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(30);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-week")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(7);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-year")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(365);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-6-month")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(183);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
        } catch (Exception e) {

        }

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        UserRights userRights = userRightsService.readByUser(username);
        int createTender = userRights.getCreateTender();
        mv.getModelMap().put("createTender", createTender);

        List list0 = departmentMasterService.read();
        mv.getModelMap().put("list0", list0);
        String MonthName1 = request.getParameter("label");
        String MonthName = "";

        if (MonthName1 != null && !MonthName1.trim().isEmpty()) {
            try {
                DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MMM-yy", Locale.ENGLISH);
                DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MMMM-yyyy", Locale.ENGLISH);
                YearMonth yearMonth = YearMonth.parse(MonthName1, inputFormatter);
                MonthName = yearMonth.format(outputFormatter);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        mv.getModelMap().put("MonthName", MonthName);
        mv.getModelMap().put("MonthName0", MonthName1);
        mv.getModelMap().put("Filter", Filter);
        mv.getModelMap().put("Department", Department);
        mv.setViewName("Dashboard/MonthWisePRGraph");
        return mv;
    }

    public ModelAndView monthWiseTender(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
//        HttpSession session = request.getSession(false);
//        UserMaster user = (UserMaster) session.getAttribute("user");
//        String username = user.getLoginName();
//        UserRights userRights = userRightsService.readByUser(username);
//        int createTender = userRights.getCreateTender();
//        mv.getModelMap().put("createTender", createTender);
//
//        if (createTender == 1) {
//            username = "";
//        }
//
//        List list0 = departmentMasterService.read();
//        mv.getModelMap().put("list0", list0);
//
//        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
//        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";
//
//        SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
//        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
//
//        try {
//            if (!Fromdate.isEmpty()) {
//                Date fromDateObj = inputFormat.parse(Fromdate);
//                Fromdate = outputFormat.format(fromDateObj);
//            }
//
//            if (!Todate.isEmpty()) {
//                Date toDateObj = inputFormat.parse(Todate);
//                Todate = outputFormat.format(toDateObj);
//            }
//        } catch (Exception e) {
//
//        }
//        String startDatee = "";
//        String endDatee = "";
//        String MonthName1 = request.getParameter("label");
//        String MonthName0 = request.getParameter("label");
//
//        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MMM-yy", Locale.ENGLISH);
//        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MMMM-yyyy", Locale.ENGLISH);
//
//        YearMonth yearMonth = YearMonth.parse(MonthName1, inputFormatter);
//        String MonthName = yearMonth.format(outputFormatter);
//
//        try {
//
//            SimpleDateFormat sdf = new SimpleDateFormat("MMMM-yyyy");
//            Date date = sdf.parse(MonthName);
//
//            Calendar startCalendar = Calendar.getInstance();
//            startCalendar.setTime(date);
//            startCalendar.set(Calendar.DAY_OF_MONTH, 1);
//            startDatee = new SimpleDateFormat("dd-MM-yyyy").format(startCalendar.getTime());
//
//            Calendar endCalendar = Calendar.getInstance();
//            endCalendar.setTime(date);
//            endCalendar.set(Calendar.DAY_OF_MONTH, endCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));
//            endDatee = new SimpleDateFormat("dd-MM-yyyy").format(endCalendar.getTime());
//
//        } catch (Exception e) {
//
//        }
//        String EndDate = endDatee;
//        String StartDate = startDatee;

        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";
        String Department = request.getParameter("Department") != null ? request.getParameter("Department") : "";
        String formattedDate = request.getParameter("formattedDate") != null ? request.getParameter("formattedDate") : "";
        String formattedStartDate = request.getParameter("formattedStartDate") != null ? request.getParameter("formattedStartDate") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }
        if (Department.equals("--select--")) {
            Department = "";
        }

        try {
            if (Filter.equals("last-month")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(30);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-week")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(7);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-year")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(365);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-6-month")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(183);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
        } catch (Exception e) {

        }

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        UserRights userRights = userRightsService.readByUser(username);
        int createTender = userRights.getCreateTender();
        mv.getModelMap().put("createTender", createTender);

        List list0 = departmentMasterService.read();
        mv.getModelMap().put("list0", list0);
        String MonthName1 = request.getParameter("label");
        String MonthName = "";

        if (MonthName1 != null && !MonthName1.trim().isEmpty()) {
            try {
                DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MMM-yy", Locale.ENGLISH);
                DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MMMM-yyyy", Locale.ENGLISH);
                YearMonth yearMonth = YearMonth.parse(MonthName1, inputFormatter);
                MonthName = yearMonth.format(outputFormatter);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

//        List monthWiseList = tenderMasterService.readByMonthGraphUser(username, StartDate, EndDate, Filter, formattedDate, formattedStartDate, Department);
//        mv.getModelMap().put("list", monthWiseList);
//        
        mv.getModelMap().put("MonthName", MonthName);
        mv.getModelMap().put("MonthName0", MonthName1);
        mv.getModelMap().put("Filter", Filter);
        mv.getModelMap().put("Department", Department);

        mv.setViewName("Dashboard/MonthWiseTenderGraph");
        return mv;
    }

    public ModelAndView contectPersonTender(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        UserRights userRights = userRightsService.readByUser(username);
        int createTender = userRights.getCreateTender();
        mv.getModelMap().put("createTender", createTender);

        if (createTender == 1) {
            username = "";
        }

        List list0 = departmentMasterService.read();
        mv.getModelMap().put("list0", list0);

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";

        SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");

        try {
            if (!Fromdate.isEmpty()) {
                Date fromDateObj = inputFormat.parse(Fromdate);
                Fromdate = outputFormat.format(fromDateObj);
            }

            if (!Todate.isEmpty()) {
                Date toDateObj = inputFormat.parse(Todate);
                Todate = outputFormat.format(toDateObj);
            }
        } catch (Exception e) {

        }

        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";
        String Department = request.getParameter("Department") != null ? request.getParameter("Department") : "";
        String formattedDate = request.getParameter("formattedDate") != null ? request.getParameter("formattedDate") : "";
        String formattedStartDate = request.getParameter("formattedStartDate") != null ? request.getParameter("formattedStartDate") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }
        if (Department.equals("--select--")) {
            Department = "";
        }

        try {
            if (Filter.equals("last-month")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(30);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-week")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(7);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-year")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(365);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-6-month")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(183);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
        } catch (Exception e) {

        }
        String Value = request.getParameter("Value");
        String ContactPerson = request.getParameter("contact");
//        String startDatee = "";
//        String endDatee = "";
//        try {
//
//            SimpleDateFormat sdf = new SimpleDateFormat("MMMM-yyyy");
//            Date date = sdf.parse(Label);
//
//            Calendar startCalendar = Calendar.getInstance();
//            startCalendar.setTime(date);
//            startCalendar.set(Calendar.DAY_OF_MONTH, 1);
//            startDatee = new SimpleDateFormat("dd-MM-yyyy").format(startCalendar.getTime());
//
//            Calendar endCalendar = Calendar.getInstance();
//            endCalendar.setTime(date);
//            endCalendar.set(Calendar.DAY_OF_MONTH, endCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));
//            endDatee = new SimpleDateFormat("dd-MM-yyyy").format(endCalendar.getTime());
//
//        } catch (Exception e) {
//
//        }
//        String EndDate = endDatee;
//        String StartDate = startDatee;

//        List contwise = tenderMasterService.readBycontactperGraphUser(ContactPerson, Value, username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
//        mv.getModelMap().put("list", contwise);
        mv.getModelMap().put("Value", Value);
        mv.getModelMap().put("ContactPerson", ContactPerson);
        mv.getModelMap().put("Filter", Filter);
        mv.getModelMap().put("Department", Department);
        mv.getModelMap().put("Fromdate", Fromdate);
        mv.getModelMap().put("Todate", Todate);
        mv.setViewName("Dashboard/ContactPersonGraph");
        return mv;
    }

    public ModelAndView practiceDashboard(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        List contwise = tenderMasterService.readBycontactper();

        String firstElement1_1 = "", firstElement1_2 = "", firstElement1_3 = "", firstElement1_4 = "";
        String secondElement1_1 = "", secondElement1_2 = "", secondElement1_3 = "", secondElement1_4 = "";
        String thirdElement1_1 = "", thirdElement1_2 = "", thirdElement1_3 = "", thirdElement1_4 = "";
        String fourthElement1_1 = "", fourthElement1_2 = "", fourthElement1_3 = "", fourthElement1_4 = "";
        String fifthElement1_1 = "", fifthElement1_2 = "", fifthElement1_3 = "", fifthElement1_4 = "";
        String sixthElement1_1 = "", sixthElement1_2 = "", sixthElement1_3 = "", sixthElement1_4 = "";
        String seventhElement1_1 = "", seventhElement1_2 = "", seventhElement1_3 = "", seventhElement1_4 = "";
        String eighthElement1_1 = "", eighthElement1_2 = "", eighthElement1_3 = "", eighthElement1_4 = "";
        String ninthElement1_1 = "", ninthElement1_2 = "", ninthElement1_3 = "", ninthElement1_4 = "";
        String tenthElement1_1 = "", tenthElement1_2 = "", tenthElement1_3 = "", tenthElement1_4 = "";
        int count = 0;

        for (Object o1 : contwise) {
            Object[] o11 = (Object[]) o1;

            if (o11.length > 3) {  // Make sure we have all 4 columns
                String elementValue1 = o11[0] != null ? o11[0].toString() : "";
                String elementValue2 = o11[1] != null ? o11[1].toString() : "0";
                String elementValue3 = o11[2] != null ? o11[2].toString() : "0";
                String elementValue4 = o11[3] != null ? o11[3].toString() : "0";

                if (count == 0) {
                    firstElement1_1 = elementValue1;
                    firstElement1_2 = elementValue2;
                    firstElement1_3 = elementValue3;
                    firstElement1_4 = elementValue4;

                } else if (count == 1) {
                    secondElement1_1 = elementValue1;
                    secondElement1_2 = elementValue2;
                    secondElement1_3 = elementValue3;
                    secondElement1_4 = elementValue4;

                } else if (count == 2) {
                    thirdElement1_1 = elementValue1;
                    thirdElement1_2 = elementValue2;
                    thirdElement1_3 = elementValue3;
                    thirdElement1_4 = elementValue4;

                } else if (count == 3) {
                    fourthElement1_1 = elementValue1;
                    fourthElement1_2 = elementValue2;
                    fourthElement1_3 = elementValue3;
                    fourthElement1_4 = elementValue4;

                } else if (count == 4) {
                    fifthElement1_1 = elementValue1;
                    fifthElement1_2 = elementValue2;
                    fifthElement1_3 = elementValue3;
                    fifthElement1_4 = elementValue4;

                } else if (count == 5) {
                    sixthElement1_1 = elementValue1;
                    sixthElement1_2 = elementValue2;
                    sixthElement1_3 = elementValue3;
                    sixthElement1_4 = elementValue4;

                } else if (count == 6) {
                    seventhElement1_1 = elementValue1;
                    seventhElement1_2 = elementValue2;
                    seventhElement1_3 = elementValue3;
                    seventhElement1_4 = elementValue4;

                } else if (count == 7) {
                    eighthElement1_1 = elementValue1;
                    eighthElement1_2 = elementValue2;
                    eighthElement1_3 = elementValue3;
                    eighthElement1_4 = elementValue4;

                } else if (count == 8) {
                    ninthElement1_1 = elementValue1;
                    ninthElement1_2 = elementValue2;
                    ninthElement1_3 = elementValue3;
                    ninthElement1_4 = elementValue4;

                } else if (count == 9) {
                    tenthElement1_1 = elementValue1;
                    tenthElement1_2 = elementValue2;
                    tenthElement1_3 = elementValue3;
                    tenthElement1_4 = elementValue4;
                    break;

                }
            }

            count++;
            System.out.println("Processing row: " + count);
        }

// Pass everything to the model map
        mv.getModelMap().put("firstElement1_1", firstElement1_1);
        mv.getModelMap().put("firstElement1_2", firstElement1_2);
        mv.getModelMap().put("firstElement1_3", firstElement1_3);
        mv.getModelMap().put("firstElement1_4", firstElement1_4);

        mv.getModelMap().put("secondElement1_1", secondElement1_1);
        mv.getModelMap().put("secondElement1_2", secondElement1_2);
        mv.getModelMap().put("secondElement1_3", secondElement1_3);
        mv.getModelMap().put("secondElement1_4", secondElement1_4);

        mv.getModelMap().put("thirdElement1_1", thirdElement1_1);
        mv.getModelMap().put("thirdElement1_2", thirdElement1_2);
        mv.getModelMap().put("thirdElement1_3", thirdElement1_3);
        mv.getModelMap().put("thirdElement1_4", thirdElement1_4);

        mv.getModelMap().put("fourthElement1_1", fourthElement1_1);
        mv.getModelMap().put("fourthElement1_2", fourthElement1_2);
        mv.getModelMap().put("fourthElement1_3", fourthElement1_3);
        mv.getModelMap().put("fourthElement1_4", fourthElement1_4);

        mv.getModelMap().put("fifthElement1_1", fifthElement1_1);
        mv.getModelMap().put("fifthElement1_2", fifthElement1_2);
        mv.getModelMap().put("fifthElement1_3", fifthElement1_3);
        mv.getModelMap().put("fifthElement1_4", fifthElement1_4);

        mv.getModelMap().put("sixthElement1_1", sixthElement1_1);
        mv.getModelMap().put("sixthElement1_2", sixthElement1_2);
        mv.getModelMap().put("sixthElement1_3", sixthElement1_3);
        mv.getModelMap().put("sixthElement1_4", sixthElement1_4);

        mv.getModelMap().put("seventhElement1_1", seventhElement1_1);
        mv.getModelMap().put("seventhElement1_2", seventhElement1_2);
        mv.getModelMap().put("seventhElement1_3", seventhElement1_3);
        mv.getModelMap().put("seventhElement1_4", seventhElement1_4);

        mv.getModelMap().put("eighthElement1_1", eighthElement1_1);
        mv.getModelMap().put("eighthElement1_2", eighthElement1_2);
        mv.getModelMap().put("eighthElement1_3", eighthElement1_3);
        mv.getModelMap().put("eighthElement1_4", eighthElement1_4);

        mv.getModelMap().put("ninthElement1_1", ninthElement1_1);
        mv.getModelMap().put("ninthElement1_2", ninthElement1_2);
        mv.getModelMap().put("ninthElement1_3", ninthElement1_3);
        mv.getModelMap().put("ninthElement1_4", ninthElement1_4);

        mv.getModelMap().put("tenthElement1_1", tenthElement1_1);
        mv.getModelMap().put("tenthElement1_2", tenthElement1_2);
        mv.getModelMap().put("tenthElement1_3", tenthElement1_3);
        mv.getModelMap().put("tenthElement1_4", tenthElement1_4);

        mv.setViewName("Dashboard/PracticeDashboard");

        return mv;
    }

    public ModelAndView oapTracker(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        UserRights userRights = userRightsService.readByUser(username);
        int createTender = userRights.getCreateTender();
        mv.getModelMap().put("flag", createTender);

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";

        List list = oapFormService.readOapForms(Fromdate, Todate);
        List list1 = oapFormService.readDeliverbleForms(Fromdate, Todate);
        mv.getModelMap().put("list1", list1);

        mv.getModelMap().put("list", list);
        mv.getModelMap().put("Fromdate", Fromdate);
        mv.getModelMap().put("Todate", Todate);

        mv.setViewName("Dashboard/OapTracker");

        return mv;

    }

    public ModelAndView aocTracker(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        UserRights userRights = userRightsService.readByUser(username);
        int createTender = userRights.getCreateTender();
        mv.getModelMap().put("flag", createTender);

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";

        List list = aocFormService.readAocForms(Fromdate, Todate);
        List list1 = aocFormService.readDeliverbleForms(Fromdate, Todate);
        mv.getModelMap().put("list1", list1);

        mv.getModelMap().put("list", list);
        mv.getModelMap().put("Fromdate", Fromdate);
        mv.getModelMap().put("Todate", Todate);

        mv.setViewName("Dashboard/AocTracker");

        return mv;

    }

    public ModelAndView oapTrackerExcel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";

        int rownum = 0;
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("FIRST SHEET");

        XSSFFont boldFont = workbook.createFont();
        boldFont.setBold(true);
        XSSFCellStyle styleBold = workbook.createCellStyle();
        styleBold.setFont(boldFont);
        styleBold.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
        styleBold.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        styleBold.setBorderTop(BorderStyle.THIN);
        styleBold.setBorderBottom(BorderStyle.THIN);
        styleBold.setBorderLeft(BorderStyle.THIN);
        styleBold.setBorderRight(BorderStyle.THIN);
        styleBold.setAlignment(HorizontalAlignment.CENTER);
        styleBold.setVerticalAlignment(VerticalAlignment.CENTER);

        Row itemHeaderRow = sheet.createRow(rownum++);
        itemHeaderRow.setHeightInPoints(40);
        String[] itemHeaders = {
            "DocumentNo", "PcsName", "ProjectName", "Department", "CreatedDate", "CreatedBy", "Status",
            "ApprovedBy", "ApprovedDate", "DaysToApproveOAP", "CRCAssignBy", "CRCAssignDate", "CRCAssignTo",
            "DaysToAssignCRCAfterOAPFormApproval", "CRCCreatedDate", "DaysToCreateCRCAfterAssign",
            "CRCApprovedBy", "CRCApprovedDate", "DaysToApproveCRCAfterCreatingCRC",
            "DesignDeliverablesAssignBy", "DesignDeliverablesAssignDate", "DesignCoordinator",
            "DeliverableCreatedDate", "DeliverableApprovedBy", "DeliverableApprovedDate",
            "ProjectManager", "ProjectManagerApprovedDate"
        };
        for (int i = 0; i < itemHeaders.length; i++) {
            sheet.setColumnWidth(i, 11000);
            Cell cell = itemHeaderRow.createCell(i);
            cell.setCellValue(itemHeaders[i]);
            cell.setCellStyle(styleBold);
        }

        List<Object[]> list = oapFormService.readOapForms(Fromdate, Todate);
        List<Object[]> list1 = oapFormService.readDeliverbleForms(Fromdate, Todate);

        for (Object[] data : list) {
            Row row = sheet.createRow(rownum++);
            row.createCell(0).setCellValue(getSafe(data[1]));
            row.createCell(1).setCellValue(getSafe(data[2]));
            row.createCell(2).setCellValue(getSafe(data[3]));
            row.createCell(3).setCellValue(getSafe(data[4]));
            row.createCell(4).setCellValue(getSafe(data[5]));
            row.createCell(5).setCellValue(getSafe(data[6]));
            row.createCell(6).setCellValue(data[7] != null && data[7].toString().equals("0") ? "Draft"
                    : data[7] != null && data[7].toString().equals("1") ? "Pending To Approve"
                            : data[7] != null && data[7].toString().equals("2") ? "Recycle"
                                    : data[7] != null && data[7].toString().equals("3") ? "Reject"
                                            : data[7] != null && data[7].toString().equals("4") ? "Approved"
                                                    : data[7] != null && data[7].toString().equals("5") ? "Rejected CRC"
                                                            : data[7] != null && data[7].toString().equals("6") ? "Approved"
                                                                    : data[7] != null && data[7].toString().equals("7") ? "Approved"
                                                                            : data[7] != null && data[7].toString().equals("8") ? "Cancel Project Manger"
                                                                                    : data[7] != null && data[7].toString().equals("9") ? "Rejected Project Manger"
                                                                                            : data[7] != null && data[7].toString().equals("10") ? "Closed Project Manger"
                                                                                                    : data[7] != null && data[7].toString().equals("11") ? "Approved"
                                                                                                            : data[7] != null && data[7].toString().equals("13") ? "Approved"
                                                                                                                    : data[7] != null && data[7].toString().equals("14") ? "Reverse Edit OAP"
                                                                                                                            : getSafe(data[7]));
            row.createCell(7).setCellValue(getSafe(data[8]));
            row.createCell(8).setCellValue(getSafe(data[9]));
            row.createCell(9).setCellValue(getSafe(data[10]));
            row.createCell(10).setCellValue(getSafe(data[11]));
            row.createCell(11).setCellValue(getSafe(data[12]));
            row.createCell(12).setCellValue(getSafe(data[13]));
            row.createCell(13).setCellValue(getSafe(data[14]));
            row.createCell(14).setCellValue(getSafe(data[15]));
            row.createCell(15).setCellValue(getSafe(data[16]));
            row.createCell(16).setCellValue(getSafe(data[17]));
            row.createCell(17).setCellValue(getSafe(data[18]));
            row.createCell(18).setCellValue(getSafe(data[19]));
        }

        for (Object[] data : list1) {
            Row row = sheet.createRow(rownum++);
            row.createCell(19).setCellValue(getSafe(data[1]));
            row.createCell(20).setCellValue(getSafe(data[2]));
            row.createCell(21).setCellValue(getSafe(data[3]));
            row.createCell(22).setCellValue(getSafe(data[4]));
            row.createCell(23).setCellValue(getSafe(data[5]));
            row.createCell(24).setCellValue(getSafe(data[6]));
            row.createCell(25).setCellValue(getSafe(data[7]));
            row.createCell(26).setCellValue(getSafe(data[8]));
        }

        String appPath = request.getServletContext().getRealPath("/");
        if (appPath == null) {
            appPath = System.getProperty("java.io.tmpdir"); // fallback
        }
        String filePath = appPath + File.separator + "StorageYard" + File.separator + "OAP" + File.separator + "oapTrackerExcel.xlsx";

        File file = new File(filePath);
        file.getParentFile().mkdirs();

        try (FileOutputStream fos = new FileOutputStream(file)) {
            workbook.write(fos);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Excel generation error: " + e.getMessage());
        }

        request.setAttribute("filePath", filePath);
        DownloadFile downloadFile = new DownloadFile();
        downloadFile.doDownload(request, response);

        return mv;
    }

    private String getSafe(Object obj) {
        return obj != null ? obj.toString() : "";
    }

    public ModelAndView aocTrackerExcel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";

        int rownum = 0;
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("FIRST SHEET");

// Header Style
        XSSFFont boldFont = workbook.createFont();
        boldFont.setBold(true);
        XSSFCellStyle styleBold = workbook.createCellStyle();
        styleBold.setFont(boldFont);
        styleBold.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
        styleBold.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        styleBold.setBorderTop(BorderStyle.THIN);
        styleBold.setBorderBottom(BorderStyle.THIN);
        styleBold.setBorderLeft(BorderStyle.THIN);
        styleBold.setBorderRight(BorderStyle.THIN);
        styleBold.setAlignment(HorizontalAlignment.CENTER);
        styleBold.setVerticalAlignment(VerticalAlignment.CENTER);

// Header Titles
        Row itemHeaderRow = sheet.createRow(rownum++);
        itemHeaderRow.setHeightInPoints(40);
        String[] itemHeaders = {
            "DocumentNo", "PcsName", "ProjectName", "Department", "CreatedDate", "CreatedBy", "Status",
            "ApprovedBy", "ApprovedDate", "DaysToApproveAOCForm", "KOMAssignBy", "KOMAssignDate", "KOMAssignTo",
            "DaysToAssignKOMForm", "KOMCreatedDate", "DaysToCreateKOM",
            "KOMApprovedBy", "KOMApprovedDate", "DaysToApproveKOM",
            "DesignDeliverablesAssignBy", "DesignDeliverablesAssignDate", "DesignCoordinator",
            "DeliverableCreatedDate", "DeliverableApprovedBy", "DeliverableApprovedDate",
            "ProjectManager", "ProjectManagerApprovedDate"
        };
        for (int i = 0; i < itemHeaders.length; i++) {
            sheet.setColumnWidth(i, 11000);
            Cell cell = itemHeaderRow.createCell(i);
            cell.setCellValue(itemHeaders[i]);
            cell.setCellStyle(styleBold);
        }

// Fetch data from service
        List<Object[]> list = aocFormService.readAocForms(Fromdate, Todate);
        List<Object[]> list1 = aocFormService.readDeliverbleForms(Fromdate, Todate);

// Fill rows with OAP form data (cols 0–18)
        // Fill rows with OAP form data (cols 0–18)
        for (Object[] data : list) {
            Row row = sheet.createRow(rownum++);
            row.createCell(0).setCellValue(getSafe(data[1]));
            row.createCell(1).setCellValue(getSafe(data[2]));
            row.createCell(2).setCellValue(getSafe(data[3]));
            row.createCell(3).setCellValue(getSafe(data[4]));
            row.createCell(4).setCellValue(getSafe(data[5]));
            row.createCell(5).setCellValue(getSafe(data[6]));
            row.createCell(6).setCellValue(data[7] != null && data[7].toString().equals("0") ? "Draft"
                    : data[7] != null && data[7].toString().equals("1") ? "Pending To Approve"
                            : data[7] != null && data[7].toString().equals("2") ? "Recycle"
                                    : data[7] != null && data[7].toString().equals("3") ? "Reject"
                                            : data[7] != null && data[7].toString().equals("4") ? "Approved"
                                                    : data[7] != null && data[7].toString().equals("5") ? "Rejected KOM"
                                                            : data[7] != null && data[7].toString().equals("6") ? "Approved"
                                                                    : data[7] != null && data[7].toString().equals("7") ? "Approved"
                                                                            : data[7] != null && data[7].toString().equals("8") ? "Cancel Project Manger"
                                                                                    : data[7] != null && data[7].toString().equals("9") ? "Rejected Project Manger"
                                                                                            : data[7] != null && data[7].toString().equals("10") ? "Closed Project Manger"
                                                                                                    : data[7] != null && data[7].toString().equals("11") ? "Approved"
                                                                                                            : data[7] != null && data[7].toString().equals("12") ? "Approved"
                                                                                                                    : data[7] != null && data[7].toString().equals("13") ? "Approved"
                                                                                                                            : getSafe(data[7]));
            row.createCell(7).setCellValue(getSafe(data[8]));
            row.createCell(8).setCellValue(getSafe(data[9]));
            row.createCell(9).setCellValue(getSafe(data[10]));
            row.createCell(10).setCellValue(getSafe(data[11]));
            row.createCell(11).setCellValue(getSafe(data[12]));
            row.createCell(12).setCellValue(getSafe(data[13]));
            row.createCell(13).setCellValue(getSafe(data[14]));
            row.createCell(14).setCellValue(getSafe(data[15]));
            row.createCell(15).setCellValue(getSafe(data[16]));
            row.createCell(16).setCellValue(getSafe(data[17]));
            row.createCell(17).setCellValue(getSafe(data[18]));
            row.createCell(18).setCellValue(getSafe(data[19]));
        }

        // Fill rows with Deliverable form data (cols 19–26)
        for (Object[] data : list1) {
            Row row = sheet.createRow(rownum++);
            row.createCell(19).setCellValue(getSafe(data[1]));
            row.createCell(20).setCellValue(getSafe(data[2]));
            row.createCell(21).setCellValue(getSafe(data[3]));
            row.createCell(22).setCellValue(getSafe(data[4]));
            row.createCell(23).setCellValue(getSafe(data[5]));
            row.createCell(24).setCellValue(getSafe(data[6]));
            row.createCell(25).setCellValue(getSafe(data[7]));
            row.createCell(26).setCellValue(getSafe(data[8]));
        }

// File path setup
        String appPath = request.getServletContext().getRealPath("/");
        if (appPath == null) {
            appPath = System.getProperty("java.io.tmpdir"); // fallback
        }
        String filePath = appPath + File.separator + "StorageYard" + File.separator + "Aoc" + File.separator + "aocTrackerExcel.xlsx";

        File file = new File(filePath);
        file.getParentFile().mkdirs();

        try (FileOutputStream fos = new FileOutputStream(file)) {
            workbook.write(fos);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Excel generation error: " + e.getMessage());
        }

        request.setAttribute("filePath", filePath);
        DownloadFile downloadFile = new DownloadFile();
        downloadFile.doDownload(request, response);

        return mv;

    }

    public ModelAndView closePr(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        UserRights userRights = userRightsService.readByUser(username);
        int createTender = userRights.getCreateTender();
        mv.getModelMap().put("createTender", createTender);

        if (createTender == 1) {
            username = "";
        }

        List list0 = departmentMasterService.read();
        mv.getModelMap().put("list0", list0);

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";

        SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");

        try {
            if (!Fromdate.isEmpty()) {
                Date fromDateObj = inputFormat.parse(Fromdate);
                Fromdate = outputFormat.format(fromDateObj);
            }

            if (!Todate.isEmpty()) {
                Date toDateObj = inputFormat.parse(Todate);
                Todate = outputFormat.format(toDateObj);
            }
        } catch (Exception e) {

        }

        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";
        String Department = request.getParameter("Department") != null ? request.getParameter("Department") : "";
        String formattedDate = request.getParameter("formattedDate") != null ? request.getParameter("formattedDate") : "";
        String formattedStartDate = request.getParameter("formattedStartDate") != null ? request.getParameter("formattedStartDate") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }
        if (Department.equals("--select--")) {
            Department = "";
        }

        try {
            if (Filter.equals("last-month")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(30);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-week")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(7);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-year")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(365);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-6-month")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(183);

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
        } catch (Exception e) {

        }

        mv.getModelMap().put("Filter", Filter);
        mv.getModelMap().put("Department", Department);
        mv.getModelMap().put("Fromdate", Fromdate);
        mv.getModelMap().put("Todate", Todate);

//        List list = prMasterService.closePrWithFilter(username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
//        mv.getModelMap().put("list", list);
        mv.setViewName("Dashboard/ClosePrDashboard");
        return mv;

    }

    public ModelAndView activeVendorDashboard(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String user11 = user.getLoginName();

        UserRights rights = userRightsService.readByUser(user11);
        String userName = "";
        if (rights.getAllVendor() != 1) {
            userName = user11;
        }
        request.setAttribute("userRights", rights);

        List<GroupMaster> list = (List<GroupMaster>) groupMasterService.read();
        List<GroupCategory> list1 = (List<GroupCategory>) groupCategoryService.read();
        List<GroupSubCategory> list2 = (List<GroupSubCategory>) groupSubCategoryService.read();

        Set<String> groupNaames = new HashSet<>();
        Set<String> groupeCategories = new HashSet<>();
        Set<String> groupeSubCategories = new HashSet<>();

        Map<String, Map<String, List<String>>> groupData = new HashMap<>();

        for (GroupMaster item : list) {
            String groupName = item.getGroupName();
            Map<String, List<String>> categoryMap = groupData.computeIfAbsent(groupName, k -> new HashMap<>());

            for (GroupCategory subItem : list1) {
                if (subItem.getGroupMasterId() == item.getId()) {
                    String categoryName = subItem.getGroupCatogryName();
                    List<String> subCategoryList = categoryMap.computeIfAbsent(categoryName, k -> new ArrayList<>());

                    for (GroupSubCategory subsub : list2) {
                        if (subsub.getGroupCategoryId() == subItem.getId()) {
                            subCategoryList.add(subsub.getSubCategoryName());
                        }
                    }
                }
            }
        }

        Gson gson = new Gson();
        String groupHierarchyJson = gson.toJson(groupData);
        request.setAttribute("groupHierarchyJson", groupHierarchyJson);

        int activeVendorCount = vendorInformationService.readActiveVendorCount();
        mv.getModelMap().put("activeVendorCount", activeVendorCount);

        int inprogressVendorCount = vendorInformationService.inprogressVendorCount();
        mv.getModelMap().put("inprogressVendorCount", inprogressVendorCount);

        int recordsTotalInvitedVendor = vendorInformationService.getInvitedVendorCount(userName);
        mv.getModelMap().put("invitedVendorCount", recordsTotalInvitedVendor);

        int rejectedVendorCount = vendorInformationService.rejectedVendorCount();
        mv.getModelMap().put("rejectedVendorCount", rejectedVendorCount);

        int vendorBlockCount = vendorInformationService.vendorBlockCount();
        mv.getModelMap().put("vendorBlockCount", vendorBlockCount);

        mv.setViewName("Dashboard/ActiveVendorDashboard");
        return mv;
    }

    public ModelAndView activeVendorDashBoardPagination(HttpServletRequest request, HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String user11 = user.getLoginName();
        String userName = user.getUserFullName();
        UserRights userRights = userRightsService.readByUser(user11);

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));

        String searchValue = request.getParameter("search[value]");

        String sapCodeFilter = request.getParameter("sapCodeFilter");
        String companyNameFilter = request.getParameter("companyNameFilter");
        String vendorEmailIdFilter = request.getParameter("vendorEmailIdFilter");
        String contactNoFilter = request.getParameter("contactNoFilter");
        String groupNameFilter = request.getParameter("groupNameFilter");
        String groupCategoryFilter = request.getParameter("groupCategoryFilter");
        String groupSubCategoryFilter = request.getParameter("groupSubCategoryFilter");
        String countryFilter = request.getParameter("countryFilter");
        String stateFilter = request.getParameter("stateFilter");
        String cityFilter = request.getParameter("cityFilter");
        String gstNoFilter = request.getParameter("gstNoFilter");
        String panNoFilter = request.getParameter("panNoFilter");
        String riskCategoryFilter = request.getParameter("riskCategoryFilter");
        String vendorInviteSourceFilter = request.getParameter("vendorInviteSourceFilter");
        String invitedByFilter = request.getParameter("invitedByFilter");
        String activatedDateFilter = request.getParameter("activatedDateFilter");

        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.equals("")) {
            orderDir = "desc";
        }

        if (orderColumnIndex == null || orderColumnIndex.equals("")) {
            orderColumnIndex = "0";
        }

        String orderColumn = "id";

        if (orderColumnIndex != null) {

            switch (Integer.parseInt(orderColumnIndex)) {

                case 0:
                    orderColumn = "a.id";
                    break;
                case 1:
                    orderColumn = "a.sapCode";
                    break;
                case 2:
                    orderColumn = "a.companyName";
                    break;
                case 3:
                    orderColumn = "a.vendorEmailId";
                    break;
                case 4:
                    orderColumn = "a.officeTelephone";
                    break;
                case 5:
                    orderColumn = "a.vendorTypes";
                    break;
                case 6:
                    orderColumn = "a.groupCategory";
                    break;

                case 7:
                    orderColumn = "a.groupSubCategory";
                    break;
                case 8:
                    orderColumn = "b.altCountry";
                    break;
                case 9:
                    orderColumn = "b.altState";
                    break;
                case 10:
                    orderColumn = "b.altCity";
                    break;
                case 11:
                    orderColumn = "a.gstinNo";
                    break;
                case 12:
                    orderColumn = "a.panNo";
                    break;
                case 13:
                    orderColumn = "a.riskCategory";
                    break;
                case 14:
                    orderColumn = "a.vendorInviteSource";
                    break;
                case 15:
                    orderColumn = "a.approvalOne";
                    break;
                case 16:
                    orderColumn = "a.vendorActivatedDate";
                    break;
                default:
                    orderColumn = "a.id";
            }
        }

        List activeVendorList = vendorInformationService.getActiveVendorPagination(start, length, searchValue, sapCodeFilter, companyNameFilter, vendorEmailIdFilter, contactNoFilter, groupNameFilter, groupCategoryFilter, groupSubCategoryFilter, countryFilter, stateFilter, cityFilter, gstNoFilter, panNoFilter, riskCategoryFilter, vendorInviteSourceFilter, invitedByFilter, activatedDateFilter, orderColumn, orderDir);

        int recordsTotalActiveVendor = vendorInformationService.getActiveVendorCount();

        int recordsFilteredActiveVendor = vendorInformationService.getFilteredActiveVendorCount(searchValue, sapCodeFilter, companyNameFilter, vendorEmailIdFilter, contactNoFilter, groupNameFilter, groupCategoryFilter, groupSubCategoryFilter, countryFilter, stateFilter, cityFilter, gstNoFilter, panNoFilter, riskCategoryFilter, vendorInviteSourceFilter, invitedByFilter, activatedDateFilter);

        List data = new ArrayList();

        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo;

        if (isDesc) {
            srNo = recordsFilteredActiveVendor - start;
        } else {
            srNo = start + 1;
        }

        for (Iterator it = activeVendorList.iterator(); it.hasNext();) {

            Object[] row = (Object[]) it.next();

            Map map = new HashMap();

            if (isDesc) {
                map.put("srNo", srNo--);
            } else {
                map.put("srNo", srNo++);
            }

            map.put("sapCode", row[2] != null ? row[2] : "");

            map.put("companyName", row[4] != null ? row[4] : "");

            map.put("vendorEmailId", row[1] != null ? row[1] : "");

            String countryCode = row[5] != null ? row[5].toString() : "";
            String mobileNo = row[6] != null ? row[6].toString() : "";

            map.put("contactNo", !mobileNo.trim().isEmpty() ? "+" + countryCode + " " + mobileNo : "");

//            map.put("groupName", row[7] != null ? row[7] : "");
//
//            map.put("groupCategoryName", row[8] != null ? row[8] : "");
//
//            map.put("groupSubCategoryName", row[9] != null ? row[9] : "");
            String groupNameStr = "";
            String groupCategoryNameStr = "";
            String groupSubCategoryNameStr = "";

            Integer vendorInvtId = (Integer) row[19];

            List list222 = vendorInvitationCategoryService.readIds(vendorInvtId);

            Set<String> groupNames = new LinkedHashSet<>();
            Set<String> groupCategoryNames = new LinkedHashSet<>();
            Set<String> groupSubCategoryNames = new LinkedHashSet<>();

            if (list222 != null) {
                for (Object o : list222) {
                    Object[] catRow = (Object[]) o;

                    String gName = catRow[2] != null ? catRow[2].toString().trim() : "";
                    String gCatName = catRow[3] != null ? catRow[3].toString().trim() : "";
                    String gSubCatName = catRow[4] != null ? catRow[4].toString().trim() : "";

                    if (!gName.isEmpty()) {
                        groupNames.add(gName);
                    }
                    if (!gCatName.isEmpty()) {
                        groupCategoryNames.add(gCatName);
                    }
                    if (!gSubCatName.isEmpty()) {
                        groupSubCategoryNames.add(gSubCatName);
                    }
                }
            }

            groupNameStr = String.join("<br>", groupNames);
            groupCategoryNameStr = String.join("<br>", groupCategoryNames);
            groupSubCategoryNameStr = String.join("<br>", groupSubCategoryNames);

            map.put("groupName", groupNameStr);
            map.put("groupCategoryName", groupCategoryNameStr);
            map.put("groupSubCategoryName", groupSubCategoryNameStr);

            map.put("countryName", row[10] != null ? row[10] : "");

            map.put("stateName", row[11] != null ? row[11] : "");

            map.put("cityName", row[12] != null ? row[12] : "");

            map.put("gstinNo", row[13] != null ? row[13] : "");

            map.put("panNo", row[14] != null ? row[14] : "");

            String riskCategory = row[15] != null ? row[15].toString() : "";

            if (!riskCategory.isEmpty()) {
                riskCategory = riskCategory.substring(0, 1).toUpperCase()
                        + riskCategory.substring(1).toLowerCase();
            }

            map.put("riskCategory", riskCategory);

            map.put("vendorInviteSource", row[16] != null ? row[16] : "");

            map.put("invitedBy", row[17] != null ? row[17] : "");

            map.put("vendorActivatedDate", row[18] != null ? row[18] : "");

            String vendorId = row[0] != null ? row[0].toString() : "";

            String sapCode = row[2] != null ? row[2].toString() : "";
            String assignedUser = row[3] != null ? row[3].toString() : "";
            String companyName = row[4] != null ? row[4].toString().replace("'", "\\'") : "";

            String view = "<div style='display:flex; gap:10px;'>"
                    + "<a href='vendorInformation.htm?act=activevendorviewClick&id=" + vendorId + "' class='btn theme-btn light-btn'>View</a>";

            view += "</div>";
            map.put("view", view);

//            if (assignedUser.equals(userName) && (sapCode == null || sapCode.trim().isEmpty())) {
//
//                map.put("sapCodeButton",
//                        "<button type='button' "
//                        + "class='fw-600 text-break gradient-text border-0 bg-transparent' "
//                        + "onclick=\"openSapPopup('"
//                        + vendorId + "','"
//                        + companyName + "','"
//                        + sapCode
//                        + "')\">Add SAP Code</button>");
//
//            } else {
            map.put("sapCodeButton", sapCode);
//            }

            data.add(map);
        }

        JSONObject json = new JSONObject();

        json.put("draw", draw);
        json.put("recordsTotal", recordsTotalActiveVendor);
        json.put("recordsFiltered", recordsFilteredActiveVendor);
        json.put("data", data);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        response.getWriter().write(json.toString());

        return null;

    }

    public void activeVendorReportExportExcel(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String searchValue = request.getParameter("searchValue");

        String sapCodeFilter = request.getParameter("sapCodeFilter");
        String companyNameFilter = request.getParameter("companyNameFilter");
        String vendorEmailIdFilter = request.getParameter("vendorEmailIdFilter");
        String contactNoFilter = request.getParameter("contactNoFilter");

        String groupNameFilter = request.getParameter("groupNameFilter");
        String groupCategoryFilter = request.getParameter("groupCategoryFilter");
        String groupSubCategoryFilter = request.getParameter("groupSubCategoryFilter");

        String countryFilter = request.getParameter("countryFilter");
        String stateFilter = request.getParameter("stateFilter");
        String cityFilter = request.getParameter("cityFilter");

        String gstNoFilter = request.getParameter("gstNoFilter");
        String panNoFilter = request.getParameter("panNoFilter");

        String riskCategoryFilter = request.getParameter("riskCategoryFilter");
        String vendorInviteSourceFilter = request.getParameter("vendorInviteSourceFilter");
        String invitedByFilter = request.getParameter("invitedByFilter");
        String activatedDateFilter = request.getParameter("activatedDateFilter");

        String orderColumn = "a.id";
        String orderDir = "asc";

        int start = 0;
        int filteredRecords = vendorInformationService.getFilteredActiveVendorCount(searchValue, sapCodeFilter, companyNameFilter, vendorEmailIdFilter, contactNoFilter, groupNameFilter, groupCategoryFilter, groupSubCategoryFilter, countryFilter, stateFilter, cityFilter, gstNoFilter, panNoFilter, riskCategoryFilter, vendorInviteSourceFilter, invitedByFilter, activatedDateFilter);

        List activeVendorReportList = vendorInformationService.getActiveVendorPagination(start, filteredRecords, searchValue, sapCodeFilter, companyNameFilter, vendorEmailIdFilter, contactNoFilter, groupNameFilter, groupCategoryFilter, groupSubCategoryFilter, countryFilter, stateFilter, cityFilter, gstNoFilter, panNoFilter, riskCategoryFilter, vendorInviteSourceFilter, invitedByFilter, activatedDateFilter, orderColumn, orderDir);

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Active Vendor Report");

        CellStyle headerStyle = workbook.createCellStyle();
        Font headerFont = workbook.createFont();
        headerFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
        headerFont.setColor(IndexedColors.WHITE.getIndex());
        headerStyle.setFont(headerFont);
        headerStyle.setFillForegroundColor(IndexedColors.DARK_BLUE.getIndex());
        headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        headerStyle.setAlignment(CellStyle.ALIGN_CENTER);
        headerStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);

        XSSFColor headerColor = new XSSFColor(new java.awt.Color(31, 78, 120));
        ((XSSFCellStyle) headerStyle).setFillForegroundColor(headerColor);
        headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);

        CellStyle wrapStyle = workbook.createCellStyle();
        wrapStyle.setWrapText(true);
        wrapStyle.setVerticalAlignment(CellStyle.VERTICAL_TOP);

        String[] headers = {
            "Sr.No.", "SAP Code", "Company Name", "Email Id", "Contact No",
            "Group Name", "Group Category", "Group Sub Category", "Country",
            "State", "City", "GST No.", "PAN No.", "Risk Category",
            "Vendor Invite Source", "Invited By", "Activated Date"
        };

        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(headerStyle);
        }

        sheet.createFreezePane(0, 1);

        int rowNum = 1;
        int srNo = 1;

        for (Iterator it = activeVendorReportList.iterator(); it.hasNext();) {
            Object[] row = (Object[]) it.next();
            Row excelRow = sheet.createRow(rowNum++);

            excelRow.createCell(0).setCellValue(srNo++);
            excelRow.createCell(1).setCellValue(row[2] != null ? row[2].toString() : "");
            excelRow.createCell(2).setCellValue(row[4] != null ? row[4].toString() : "");
            excelRow.createCell(3).setCellValue(row[1] != null ? row[1].toString() : "");

            String countryCode = row[5] != null ? row[5].toString() : "";
            String mobileNo = row[6] != null ? row[6].toString() : "";
            String contactNo = !mobileNo.trim().isEmpty() ? "+" + countryCode + " " + mobileNo : "";
            excelRow.createCell(4).setCellValue(contactNo);

            String groupNameStr = "";
            String groupCategoryNameStr = "";
            String groupSubCategoryNameStr = "";

            Integer vendorInvtId = (Integer) row[19];

            List list222 = vendorInvitationCategoryService.readIds(vendorInvtId);

            Set<String> groupNames = new LinkedHashSet<>();
            Set<String> groupCategoryNames = new LinkedHashSet<>();
            Set<String> groupSubCategoryNames = new LinkedHashSet<>();

            if (list222 != null) {
                for (Object o : list222) {
                    Object[] catRow = (Object[]) o;

                    String gName = catRow[2] != null ? catRow[2].toString().trim() : "";
                    String gCatName = catRow[3] != null ? catRow[3].toString().trim() : "";
                    String gSubCatName = catRow[4] != null ? catRow[4].toString().trim() : "";

                    if (!gName.isEmpty()) {
                        groupNames.add(gName);
                    }
                    if (!gCatName.isEmpty()) {
                        groupCategoryNames.add(gCatName);
                    }
                    if (!gSubCatName.isEmpty()) {
                        groupSubCategoryNames.add(gSubCatName);
                    }
                }
            }

            groupNameStr = String.join("\n", groupNames);
            groupCategoryNameStr = String.join("\n", groupCategoryNames);
            groupSubCategoryNameStr = String.join("\n", groupSubCategoryNames);

            Cell groupNameCell = excelRow.createCell(5);
            groupNameCell.setCellValue(groupNameStr);
            groupNameCell.setCellStyle(wrapStyle);

            Cell groupCategoryCell = excelRow.createCell(6);
            groupCategoryCell.setCellValue(groupCategoryNameStr);
            groupCategoryCell.setCellStyle(wrapStyle);

            Cell groupSubCategoryCell = excelRow.createCell(7);
            groupSubCategoryCell.setCellValue(groupSubCategoryNameStr);
            groupSubCategoryCell.setCellStyle(wrapStyle);

            excelRow.createCell(8).setCellValue(row[10] != null ? row[10].toString() : "");
            excelRow.createCell(9).setCellValue(row[11] != null ? row[11].toString() : "");
            excelRow.createCell(10).setCellValue(row[12] != null ? row[12].toString() : "");
            excelRow.createCell(11).setCellValue(row[13] != null ? row[13].toString() : "");
            excelRow.createCell(12).setCellValue(row[14] != null ? row[14].toString() : "");

            String riskCategory = row[15] != null ? row[15].toString() : "";
            if (!riskCategory.isEmpty()) {
                riskCategory = riskCategory.substring(0, 1).toUpperCase()
                        + riskCategory.substring(1).toLowerCase();
            }
            excelRow.createCell(13).setCellValue(riskCategory);

            excelRow.createCell(14).setCellValue(row[16] != null ? row[16].toString() : "");
            excelRow.createCell(15).setCellValue(row[17] != null ? row[17].toString() : "");
            excelRow.createCell(16).setCellValue(row[18] != null ? row[18].toString() : "");
        }

        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }

        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
        String currentDate = sdf.format(new Date());
        String fileName = "ActiveVendorReport_" + currentDate + ".xlsx";

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

        OutputStream outputStream = response.getOutputStream();
        try {
            workbook.write(outputStream);
        } finally {
            outputStream.flush();
            outputStream.close();
        }
    }

    public ModelAndView rejectVendorList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String user11 = user.getLoginName();

        UserRights rights = userRightsService.readByUser(user11);
        String userName = "";
        if (rights.getAllVendor() != 1) {
            userName = user11;
        }
        request.setAttribute("userRights", rights);

        int activeVendorCount = vendorInformationService.readActiveVendorCount();
        mv.getModelMap().put("activeVendorCount", activeVendorCount);

        int inprogressVendorCount = vendorInformationService.inprogressVendorCount();
        mv.getModelMap().put("inprogressVendorCount", inprogressVendorCount);

        int recordsTotalInvitedVendor = vendorInformationService.getInvitedVendorCount(userName);
        mv.getModelMap().put("invitedVendorCount", recordsTotalInvitedVendor);

        int rejectedVendorCount = vendorInformationService.rejectedVendorCount();
        mv.getModelMap().put("rejectedVendorCount", rejectedVendorCount);

        int vendorBlockCount = vendorInformationService.vendorBlockCount();
        mv.getModelMap().put("vendorBlockCount", vendorBlockCount);

        mv.setViewName("Dashboard/RejectedVendorDashboard");
        return mv;
    }

    public ModelAndView rejectVendorAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

//        HttpSession session = request.getSession(false);
//        UserMaster user = (UserMaster) session.getAttribute("user");
//        String user11 = user.getLoginName();
//        UserRights rights = userRightsService.readByUser(user11);
        String userName = "";
//        if (rights.getAllVendor() != 1) {
//            userName = user11;
//        }

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));

        String searchValue = request.getParameter("search[value]");

        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.equals("")) {
            orderDir = "desc";
        }

        if (orderColumnIndex == null || orderColumnIndex.equals("")) {
            orderColumnIndex = "0";
        }

        String orderColumn = "id";

        if (orderColumnIndex != null) {

            switch (Integer.parseInt(orderColumnIndex)) {

                case 0:
                    orderColumn = "id";
                    break;
                case 1:
                    orderColumn = "companyName";
                    break;
                case 2:
                    orderColumn = "vendorEmailId";
                    break;
                case 3:
                    orderColumn = "status1";
                    break;
                default:
                    orderColumn = "id";
            }
        }

        List rejectVendorList = vendorInformationService.getRejectVendorPagination(start, length, userName, searchValue, orderColumn, orderDir);

        int recordsTotalRejectVendor = vendorInformationService.getRejectVendorCount(userName);

        int recordsFilteredRejectVendor = vendorInformationService.getFilteredRejectVendorCount(userName, searchValue);

        List data = new ArrayList();

        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo;

        if (isDesc) {
            srNo = recordsFilteredRejectVendor - start;
        } else {
            srNo = start + 1;
        }

        for (Iterator it = rejectVendorList.iterator(); it.hasNext();) {

            Object[] row = (Object[]) it.next();

            Map map = new HashMap();

            if (isDesc) {
                map.put("srNo", srNo--);
            } else {
                map.put("srNo", srNo++);
            }

            map.put("companyName", row[1] != null ? row[1] : "");

            map.put("vendorEmailId", row[2] != null ? row[2] : "");

            String status = "";
            String statusCode = row[3].toString() != null ? row[3].toString() : "";

            if ("6".equals(statusCode)) {
                status = "Buyer";
            } else if ("7".equals(statusCode)) {
                status = "Procurement Head";
            } else if ("501".equals(statusCode)) {
                status = "Compliance Officer";
            }

            map.put("status", status);

            data.add(map);
        }

        JSONObject json = new JSONObject();

        json.put("draw", draw);
        json.put("recordsTotal", recordsTotalRejectVendor);
        json.put("recordsFiltered", recordsFilteredRejectVendor);
        json.put("data", data);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        response.getWriter().write(json.toString());

        return null;

    }

    public void rejectVendorReportExportExcel(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String searchValue = request.getParameter("searchValue");

        String userName = "";
        String orderColumn = "id";
        String orderDir = "asc";

        int start = 0;
        int filteredRecords = vendorInformationService.getFilteredRejectVendorCount(userName, searchValue);

        List rejectVendorReportList = vendorInformationService.getRejectVendorPagination(start, filteredRecords, userName, searchValue, orderColumn, orderDir);

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Rejected Vendor Report");

        CellStyle headerStyle = workbook.createCellStyle();
        Font headerFont = workbook.createFont();
        headerFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
        headerFont.setColor(IndexedColors.WHITE.getIndex());
        headerStyle.setFont(headerFont);
        headerStyle.setFillForegroundColor(IndexedColors.DARK_BLUE.getIndex());
        headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        headerStyle.setAlignment(CellStyle.ALIGN_CENTER);
        headerStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);

        XSSFColor headerColor = new XSSFColor(new java.awt.Color(31, 78, 120));
        ((XSSFCellStyle) headerStyle).setFillForegroundColor(headerColor);
        headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);

        CellStyle wrapStyle = workbook.createCellStyle();
        wrapStyle.setWrapText(true);
        wrapStyle.setVerticalAlignment(CellStyle.VERTICAL_TOP);

        String[] headers = {
            "Sr.No.", "Company Name", "Email Id", "Rejected By"
        };

        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(headerStyle);
        }

        sheet.createFreezePane(0, 1);

        int rowNum = 1;
        int srNo = 1;

        for (Iterator it = rejectVendorReportList.iterator(); it.hasNext();) {
            Object[] row = (Object[]) it.next();
            Row excelRow = sheet.createRow(rowNum++);

            excelRow.createCell(0).setCellValue(srNo++);
            excelRow.createCell(1).setCellValue(row[1] != null ? row[1].toString() : "");
            excelRow.createCell(2).setCellValue(row[2] != null ? row[2].toString() : "");

            String status = "";
            String statusCode = row[3].toString() != null ? row[3].toString() : "";

            if ("6".equals(statusCode)) {
                status = "Buyer";
            } else if ("7".equals(statusCode)) {
                status = "Procurement Head";
            } else if ("501".equals(statusCode)) {
                status = "Compliance Officer";
            }

            excelRow.createCell(3).setCellValue(status);

        }

        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }

        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
        String currentDate = sdf.format(new Date());
        String fileName = "RejectedVendorReport_" + currentDate + ".xlsx";

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

        OutputStream outputStream = response.getOutputStream();
        try {
            workbook.write(outputStream);
        } finally {
            outputStream.flush();
            outputStream.close();
        }
    }

    public ModelAndView inprogressVendorList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String user11 = user.getLoginName();

        UserRights rights = userRightsService.readByUser(user11);
        String userName = "";
        if (rights.getAllVendor() != 1) {
            userName = user11;
        }
        request.setAttribute("userRights", rights);

        int activeVendorCount = vendorInformationService.readActiveVendorCount();
        mv.getModelMap().put("activeVendorCount", activeVendorCount);

        int inprogressVendorCount = vendorInformationService.inprogressVendorCount();
        mv.getModelMap().put("inprogressVendorCount", inprogressVendorCount);

        int recordsTotalInvitedVendor = vendorInformationService.getInvitedVendorCount(userName);
        mv.getModelMap().put("invitedVendorCount", recordsTotalInvitedVendor);

        int rejectedVendorCount = vendorInformationService.rejectedVendorCount();
        mv.getModelMap().put("rejectedVendorCount", rejectedVendorCount);

        int vendorBlockCount = vendorInformationService.vendorBlockCount();
        mv.getModelMap().put("vendorBlockCount", vendorBlockCount);

        mv.setViewName("Dashboard/InprogressVendorDashboard");
        return mv;
    }

    public ModelAndView inprogressVendorAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

//        HttpSession session = request.getSession(false);
//        UserMaster user = (UserMaster) session.getAttribute("user");
//        String user11 = user.getLoginName();
//        UserRights rights = userRightsService.readByUser(user11);
        String userName = "";
//        if (rights.getAllVendor() != 1) {
//            userName = user11;
//        }

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));

        String searchValue = request.getParameter("search[value]");

        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.equals("")) {
            orderDir = "desc";
        }

        if (orderColumnIndex == null || orderColumnIndex.equals("")) {
            orderColumnIndex = "0";
        }

        String orderColumn = "id";

        if (orderColumnIndex != null) {

            switch (Integer.parseInt(orderColumnIndex)) {

                case 0:
                    orderColumn = "id";
                    break;
                case 1:
                    orderColumn = "companyName";
                    break;
                case 2:
                    orderColumn = "vendorEmailId";
                    break;
                default:
                    orderColumn = "id";
            }
        }

        List inprogressVendorList = vendorInformationService.getInprogressVendorPagination(start, length, userName, searchValue, orderColumn, orderDir);

        int recordsTotalInprogressVendor = vendorInformationService.getInprogressVendorCount(userName);

        int recordsFilteredInprogressVendor = vendorInformationService.getFilteredInprogressVendorCount(userName, searchValue);

        List data = new ArrayList();

        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo;

        if (isDesc) {
            srNo = recordsFilteredInprogressVendor - start;
        } else {
            srNo = start + 1;
        }

        for (Iterator it = inprogressVendorList.iterator(); it.hasNext();) {

            Object[] row = (Object[]) it.next();

            Map map = new HashMap();

            if (isDesc) {
                map.put("srNo", srNo--);
            } else {
                map.put("srNo", srNo++);
            }

            map.put("companyName", row[1] != null ? row[1] : "");

            map.put("vendorEmailId", row[2] != null ? row[2] : "");

            data.add(map);
        }

        JSONObject json = new JSONObject();

        json.put("draw", draw);
        json.put("recordsTotal", recordsTotalInprogressVendor);
        json.put("recordsFiltered", recordsFilteredInprogressVendor);
        json.put("data", data);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        response.getWriter().write(json.toString());

        return null;

    }

    public void inprogressVendorReportExportExcel(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String searchValue = request.getParameter("searchValue");

        String userName = "";
        String orderColumn = "id";
        String orderDir = "asc";

        int start = 0;
        int filteredRecords = vendorInformationService.getFilteredInprogressVendorCount(userName, searchValue);

        List inprogressVendorReportList = vendorInformationService.getInprogressVendorPagination(start, filteredRecords, userName, searchValue, orderColumn, orderDir);

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Inprogress Vendor Report");

        CellStyle headerStyle = workbook.createCellStyle();
        Font headerFont = workbook.createFont();
        headerFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
        headerFont.setColor(IndexedColors.WHITE.getIndex());
        headerStyle.setFont(headerFont);
        headerStyle.setFillForegroundColor(IndexedColors.DARK_BLUE.getIndex());
        headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        headerStyle.setAlignment(CellStyle.ALIGN_CENTER);
        headerStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);

        XSSFColor headerColor = new XSSFColor(new java.awt.Color(31, 78, 120));
        ((XSSFCellStyle) headerStyle).setFillForegroundColor(headerColor);
        headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);

        CellStyle wrapStyle = workbook.createCellStyle();
        wrapStyle.setWrapText(true);
        wrapStyle.setVerticalAlignment(CellStyle.VERTICAL_TOP);

        String[] headers = {
            "Sr.No.", "Company Name", "Email Id"
        };

        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(headerStyle);
        }

        sheet.createFreezePane(0, 1);

        int rowNum = 1;
        int srNo = 1;

        for (Iterator it = inprogressVendorReportList.iterator(); it.hasNext();) {
            Object[] row = (Object[]) it.next();
            Row excelRow = sheet.createRow(rowNum++);

            excelRow.createCell(0).setCellValue(srNo++);
            excelRow.createCell(1).setCellValue(row[1] != null ? row[1].toString() : "");
            excelRow.createCell(2).setCellValue(row[2] != null ? row[2].toString() : "");
        }

        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }

        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
        String currentDate = sdf.format(new Date());
        String fileName = "InprogressVendorReport_" + currentDate + ".xlsx";

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

        OutputStream outputStream = response.getOutputStream();
        try {
            workbook.write(outputStream);
        } finally {
            outputStream.flush();
            outputStream.close();
        }
    }

    public ModelAndView invitedVendorList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String user11 = user.getLoginName();

        UserRights rights = userRightsService.readByUser(user11);
        String userName = "";
        if (rights.getAllVendor() != 1) {
            userName = user11;
        }
        request.setAttribute("userRights", rights);

        int activeVendorCount = vendorInformationService.readActiveVendorCount();
        mv.getModelMap().put("activeVendorCount", activeVendorCount);

        int inprogressVendorCount = vendorInformationService.inprogressVendorCount();
        mv.getModelMap().put("inprogressVendorCount", inprogressVendorCount);

        int recordsTotalInvitedVendor = vendorInformationService.getInvitedVendorCount(userName);
        mv.getModelMap().put("invitedVendorCount", recordsTotalInvitedVendor);

        int rejectedVendorCount = vendorInformationService.rejectedVendorCount();
        mv.getModelMap().put("rejectedVendorCount", rejectedVendorCount);

        int vendorBlockCount = vendorInformationService.vendorBlockCount();
        mv.getModelMap().put("vendorBlockCount", vendorBlockCount);

        mv.setViewName("Dashboard/InvitedVendorDashboard");
        return mv;
    }

    public ModelAndView invitedVendorAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String user11 = user.getLoginName();

        UserRights rights = userRightsService.readByUser(user11);
        String userName = "";
        if (rights.getAllVendor() != 1) {
            userName = user11;
        }

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));

        String searchValue = request.getParameter("search[value]");

        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.equals("")) {
            orderDir = "desc";
        }

        if (orderColumnIndex == null || orderColumnIndex.equals("")) {
            orderColumnIndex = "0";
        }

        String orderColumn = "id";

        if (orderColumnIndex != null) {

            switch (Integer.parseInt(orderColumnIndex)) {

                case 0:
                    orderColumn = "id";
                    break;
                case 1:
                    orderColumn = "companyName";
                    break;
                case 2:
                    orderColumn = "vendorEmailId";
                    break;
                case 3:
                    orderColumn = "invitedBy";
                    break;
                default:
                    orderColumn = "id";
            }
        }

        List invitedVendorList = vendorInformationService.getInvitedVendorPagination(start, length, userName, searchValue, orderColumn, orderDir);

        int recordsTotalInvitedVendor = vendorInformationService.getInvitedVendorCount(userName);

        int recordsFilteredInvitedVendor = vendorInformationService.getFilteredInvitedVendorCount(userName, searchValue);

        List data = new ArrayList();

        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo;

        if (isDesc) {
            srNo = recordsFilteredInvitedVendor - start;
        } else {
            srNo = start + 1;
        }

        for (Iterator it = invitedVendorList.iterator(); it.hasNext();) {

            Object[] row = (Object[]) it.next();

            Map map = new HashMap();

            if (isDesc) {
                map.put("srNo", srNo--);
            } else {
                map.put("srNo", srNo++);
            }

            map.put("companyName", row[1] != null ? row[1] : "");

            map.put("vendorEmailId", row[2] != null ? row[2] : "");

            map.put("invitedBy", row[3] != null ? row[3] : "");

            map.put("invitedDateTime", row[4] != null ? row[4] : "");

            data.add(map);
        }

        JSONObject json = new JSONObject();

        json.put("draw", draw);
        json.put("recordsTotal", recordsTotalInvitedVendor);
        json.put("recordsFiltered", recordsFilteredInvitedVendor);
        json.put("data", data);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        response.getWriter().write(json.toString());

        return null;

    }

    public void invitedVendorReportExportExcel(HttpServletRequest request, HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String user11 = user.getLoginName();

        UserRights rights = userRightsService.readByUser(user11);
        String userName = "";
        if (rights.getAllVendor() != 1) {
            userName = user11;
        }

        String searchValue = request.getParameter("searchValue");

        String orderColumn = "id";
        String orderDir = "asc";

        int start = 0;
        int filteredRecords = vendorInformationService.getFilteredInvitedVendorCount(userName, searchValue);

        List InvitedVendorReportList = vendorInformationService.getInvitedVendorPagination(start, filteredRecords, userName, searchValue, orderColumn, orderDir);

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Invited Vendor Report");

        CellStyle headerStyle = workbook.createCellStyle();
        Font headerFont = workbook.createFont();
        headerFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
        headerFont.setColor(IndexedColors.WHITE.getIndex());
        headerStyle.setFont(headerFont);
        headerStyle.setFillForegroundColor(IndexedColors.DARK_BLUE.getIndex());
        headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        headerStyle.setAlignment(CellStyle.ALIGN_CENTER);
        headerStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);

        XSSFColor headerColor = new XSSFColor(new java.awt.Color(31, 78, 120));
        ((XSSFCellStyle) headerStyle).setFillForegroundColor(headerColor);
        headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);

        CellStyle wrapStyle = workbook.createCellStyle();
        wrapStyle.setWrapText(true);
        wrapStyle.setVerticalAlignment(CellStyle.VERTICAL_TOP);

        String[] headers = {
            "Sr.No.", "Company Name", "Email Id", "Invite By", "Invite Date & Time"
        };

        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(headerStyle);
        }

        sheet.createFreezePane(0, 1);

        int rowNum = 1;
        int srNo = 1;

        for (Iterator it = InvitedVendorReportList.iterator(); it.hasNext();) {
            Object[] row = (Object[]) it.next();
            Row excelRow = sheet.createRow(rowNum++);

            excelRow.createCell(0).setCellValue(srNo++);
            excelRow.createCell(1).setCellValue(row[1] != null ? row[1].toString() : "");
            excelRow.createCell(2).setCellValue(row[2] != null ? row[2].toString() : "");
            excelRow.createCell(3).setCellValue(row[3] != null ? row[3].toString() : "");
            excelRow.createCell(4).setCellValue(row[4] != null ? row[4].toString() : "");
        }

        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }

        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
        String currentDate = sdf.format(new Date());
        String fileName = "InvitedVendorReport_" + currentDate + ".xlsx";

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

        OutputStream outputStream = response.getOutputStream();
        try {
            workbook.write(outputStream);
        } finally {
            outputStream.flush();
            outputStream.close();
        }
    }

    public ModelAndView totalPrDashboadPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        UserRights userRights = userRightsService.readByUser(username);
        int createTender = userRights.getCreateTender();
        mv.getModelMap().put("createTender", createTender);

        if (createTender == 1) {
            username = "";
        }

        List list0 = departmentMasterService.read();
        mv.getModelMap().put("list0", list0);

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));

        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().isEmpty()) {
            orderDir = "desc";
        } else {
            orderDir = "desc".equalsIgnoreCase(orderDir) ? "desc" : "asc";
        }

        if (orderColumnIndex == null || orderColumnIndex.isEmpty()) {
            orderColumnIndex = "0";
        }

        String orderColumn = "id";
        switch (orderColumnIndex) {
            case "0":
                orderColumn = "id";
                break;
            case "1":
                orderColumn = "prNo";
                break;
            case "2":
                orderColumn = "title";
                break;
            case "3":
                orderColumn = "projectId";
                break;
            case "4":
                orderColumn = "contactPerson";
                break;
            case "5":
                orderColumn = "announceDate";
                break;
            default:
                orderColumn = "id";
                break;
        }

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate").trim() : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate").trim() : "";

        SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            if (!Fromdate.isEmpty()) {
                Date fromDateObj = inputFormat.parse(Fromdate);
                Fromdate = outputFormat.format(fromDateObj);
            }
            if (!Todate.isEmpty()) {
                Date toDateObj = inputFormat.parse(Todate);
                Todate = outputFormat.format(toDateObj);
            }
        } catch (Exception e) {
        }

        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter").trim() : "";
        String Department = request.getParameter("Department") != null ? request.getParameter("Department").trim() : "";

        if (Filter.equalsIgnoreCase("--select--") || Filter.equalsIgnoreCase("--SELECT--")) {
            Filter = "";
        }
        if (Department.equalsIgnoreCase("--select--")) {
            Department = "";
        }

        String formattedDate = "";
        String formattedStartDate = "";
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        try {
            if (!Filter.isEmpty()) {
                LocalDateTime now = LocalDateTime.now();
                LocalDateTime startDate;

                switch (Filter) {
                    case "last-week":
                        startDate = now.minusDays(7);
                        break;
                    case "last-month":
                        startDate = now.minusDays(30);
                        break;
                    case "last-6-month":
                        startDate = now.minusDays(183);
                        break;
                    case "last-year":
                        startDate = now.minusDays(365);
                        break;
                    default:
                        startDate = now;
                        break;
                }

                formattedDate = now.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
        } catch (Exception e) {
        }

        List list = prMasterService.gettotalPrUserPagination(start, length, searchValue, orderColumn, orderDir, username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
        int totalRecords = prMasterService.getMonthWiseGraphCount();
        int filteredRecords = prMasterService.getFilteredMonthWiseGraphCount(searchValue, username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);

        JSONArray dataArray = new JSONArray();

        boolean isDesc = "desc".equalsIgnoreCase(orderDir);
        int srNo = isDesc ? (start + 1) : (filteredRecords - start);

        for (Object obj : list) {
            Object[] row = (Object[]) obj;

            int id = row[0] != null ? ((Number) row[0]).intValue() : 0;
            String prNo = row[1] != null ? row[1].toString() : "";
            String title = row[2] != null ? row[2].toString() : "";
            String projectId = row[3] != null ? row[3].toString() : "";
            String contactPerson = row[4] != null ? row[4].toString() : "";
            String announceDate = row[5] != null ? row[5].toString() : "";
            int flagStatus = row[6] != null ? ((Number) row[6]).intValue() : -1;

            String statusLabel;
            if (flagStatus == 0) {
                statusLabel = "Pending";
            } else if (flagStatus == 1) {
                statusLabel = "Approve";
            } else if (flagStatus == 2) {
                statusLabel = "Rework";
            } else if (flagStatus == 3) {
                statusLabel = "Reject";
            } else if (flagStatus == 6) {
                statusLabel = "Tender Created";
            } else if (flagStatus == 7) {
                statusLabel = "Draft";
            } else {
                statusLabel = "";
            }

            JSONObject json = new JSONObject();
            json.put("srNo", isDesc ? srNo++ : srNo--);

            json.put(
                    "prNo",
                    "<a href='prMaster.htm?act=PRHistory&pr_no="
                    + (row[1] != null ? row[1] : "")
                    + "' class='fw-600 text-break gradient-text'>"
                    + (row[1] != null ? row[1] : "")
                    + "</a>"
            );

            json.put("title", title);
            json.put("projectId", projectId);
            json.put("contactPerson", contactPerson);
            json.put("announceDate", announceDate);
            json.put("authorizeFlag", statusLabel);

            dataArray.put(json);
        }

        JSONObject responseJson = new JSONObject();
        responseJson.put("draw", draw);
        responseJson.put("recordsTotal", totalRecords);
        responseJson.put("recordsFiltered", filteredRecords);
        responseJson.put("data", dataArray);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(responseJson.toString());
        return null;
    }

    public ModelAndView underApprovalDashboadPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        UserRights userRights = userRightsService.readByUser(username);
        int createTender = userRights.getCreateTender();
        mv.getModelMap().put("createTender", createTender);

        if (createTender == 1) {
            username = "";
        }

        List list0 = departmentMasterService.read();
        mv.getModelMap().put("list0", list0);

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));

        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().isEmpty()) {
            orderDir = "desc";
        } else {
            orderDir = "desc".equalsIgnoreCase(orderDir) ? "desc" : "asc";
        }

        if (orderColumnIndex == null || orderColumnIndex.isEmpty()) {
            orderColumnIndex = "0";
        }

        String orderColumn;
        switch (orderColumnIndex) {
            case "1":
                orderColumn = "prNo";
                break;
            case "2":
                orderColumn = "title";
                break;
            case "3":
                orderColumn = "projectId";
                break;
            case "4":
                orderColumn = "contactPerson";
                break;
            case "5":
                orderColumn = "announceDate";
                break;
            default:
                orderColumn = "id";
                break;
        }

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate").trim() : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate").trim() : "";

        SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            if (!Fromdate.isEmpty()) {
                Date fromDateObj = inputFormat.parse(Fromdate);
                Fromdate = outputFormat.format(fromDateObj);
            }
            if (!Todate.isEmpty()) {
                Date toDateObj = inputFormat.parse(Todate);
                Todate = outputFormat.format(toDateObj);
            }
        } catch (Exception e) {
        }

        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter").trim() : "";
        String Department = request.getParameter("Department") != null ? request.getParameter("Department").trim() : "";

        if (Filter.equalsIgnoreCase("--select--")) {
            Filter = "";
        }
        if (Department.equalsIgnoreCase("--select--")) {
            Department = "";
        }

        String formattedDate = "";
        String formattedStartDate = "";
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        try {
            if (!Filter.isEmpty()) {
                LocalDateTime now = LocalDateTime.now();
                LocalDateTime startDate;

                switch (Filter) {
                    case "last-week":
                        startDate = now.minusDays(7);
                        break;
                    case "last-month":
                        startDate = now.minusDays(30);
                        break;
                    case "last-6-month":
                        startDate = now.minusDays(183);
                        break;
                    case "last-year":
                        startDate = now.minusDays(365);
                        break;
                    default:
                        startDate = now;
                        break;
                }

                formattedDate = now.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
        } catch (Exception e) {
        }

        List list = prMasterService.getunderApprovalPagination(
                start, length, searchValue, orderColumn, orderDir,
                username, Fromdate, Todate, Filter,
                formattedDate, formattedStartDate, Department);

        int totalRecords = prMasterService.getunderApprovalCount();
        int filteredRecords = prMasterService.getFilteredunderApprovalCount(
                searchValue, username, Fromdate, Todate, Filter,
                formattedDate, formattedStartDate, Department);

        JSONArray dataArray = new JSONArray();

        int srNo = start + 1;

        for (Object obj : list) {
            Object[] row = (Object[]) obj;

            String prNo = row[1] != null ? row[1].toString() : "";
            String title = row[2] != null ? row[2].toString() : "";
            String projectId = row[3] != null ? row[3].toString() : "";
            String contactPerson = row[4] != null ? row[4].toString() : "";
            String announceDate = row[5] != null ? row[5].toString() : "";
            int flagStatus = row[6] != null ? ((Number) row[6]).intValue() : -1;

            String statusLabel;
            switch (flagStatus) {
                case 0:
                    statusLabel = "Pending";
                    break;
                case 1:
                    statusLabel = "Approve";
                    break;
                case 2:
                    statusLabel = "Rework";
                    break;
                case 3:
                    statusLabel = "Reject";
                    break;
                case 6:
                    statusLabel = "Tender Created";
                    break;
                case 7:
                    statusLabel = "Draft";
                    break;
                default:
                    statusLabel = "";
                    break;
            }

            JSONObject json = new JSONObject();
            json.put("srNo", srNo++);
            json.put("prNo",
                    "<a href='prMaster.htm?act=PRHistory&pr_no=" + prNo
                    + "' class='fw-600 text-break gradient-text'>" + prNo + "</a>");
            json.put("title", title);
            json.put("projectId", projectId);
            json.put("contactPerson", contactPerson);
            json.put("announceDate", announceDate);
            json.put("authorizeFlag", statusLabel);

            dataArray.put(json);
        }

        JSONObject responseJson = new JSONObject();
        responseJson.put("draw", draw);
        responseJson.put("recordsTotal", totalRecords);
        responseJson.put("recordsFiltered", filteredRecords);
        responseJson.put("data", dataArray);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(responseJson.toString());
        return null;
    }

    public ModelAndView rejectedPrDashboadPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        UserRights userRights = userRightsService.readByUser(username);
        int createTender = userRights.getCreateTender();
        mv.getModelMap().put("createTender", createTender);

        if (createTender == 1) {
            username = "";
        }

        List list0 = departmentMasterService.read();
        mv.getModelMap().put("list0", list0);

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));

        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().isEmpty()) {
            orderDir = "desc";
        } else {
            orderDir = "desc".equalsIgnoreCase(orderDir) ? "desc" : "asc";
        }

        if (orderColumnIndex == null || orderColumnIndex.isEmpty()) {
            orderColumnIndex = "0";
        }

        String orderColumn;
        switch (orderColumnIndex) {
            case "1":
                orderColumn = "prNo";
                break;
            case "2":
                orderColumn = "title";
                break;
            case "3":
                orderColumn = "projectId";
                break;
            case "4":
                orderColumn = "contactPerson";
                break;
            case "5":
                orderColumn = "announceDate";
                break;
            default:
                orderColumn = "id";
                break;
        }

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate").trim() : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate").trim() : "";

        SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            if (!Fromdate.isEmpty()) {
                Date fromDateObj = inputFormat.parse(Fromdate);
                Fromdate = outputFormat.format(fromDateObj);
            }
            if (!Todate.isEmpty()) {
                Date toDateObj = inputFormat.parse(Todate);
                Todate = outputFormat.format(toDateObj);
            }
        } catch (Exception e) {
        }

        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter").trim() : "";
        String Department = request.getParameter("Department") != null ? request.getParameter("Department").trim() : "";

        if (Filter.equalsIgnoreCase("--select--")) {
            Filter = "";
        }
        if (Department.equalsIgnoreCase("--select--")) {
            Department = "";
        }

        String formattedDate = "";
        String formattedStartDate = "";
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        try {
            if (!Filter.isEmpty()) {
                LocalDateTime now = LocalDateTime.now();
                LocalDateTime startDate;

                switch (Filter) {
                    case "last-week":
                        startDate = now.minusDays(7);
                        break;
                    case "last-month":
                        startDate = now.minusDays(30);
                        break;
                    case "last-6-month":
                        startDate = now.minusDays(183);
                        break;
                    case "last-year":
                        startDate = now.minusDays(365);
                        break;
                    default:
                        startDate = now;
                        break;
                }

                formattedDate = now.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
        } catch (Exception e) {
        }

        List list = prMasterService.getrejectedPrPagination(start, length, searchValue, orderColumn, orderDir, username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
        int totalRecords = prMasterService.getrejectedPrCount();
        int filteredRecords = prMasterService.getFilteredrejectedPrCount(searchValue, username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);

        JSONArray dataArray = new JSONArray();

        int srNo = start + 1;

        for (Object obj : list) {
            Object[] row = (Object[]) obj;

            String prNo = row[1] != null ? row[1].toString() : "";
            String title = row[2] != null ? row[2].toString() : "";
            String projectId = row[3] != null ? row[3].toString() : "";
            String contactPerson = row[4] != null ? row[4].toString() : "";
            String announceDate = row[5] != null ? row[5].toString() : "";
            int flagStatus = row[6] != null ? ((Number) row[6]).intValue() : -1;

            String statusLabel;
            switch (flagStatus) {
                case 0:
                    statusLabel = "Pending";
                    break;
                case 1:
                    statusLabel = "Approve";
                    break;
                case 2:
                    statusLabel = "Rework";
                    break;
                case 3:
                    statusLabel = "Reject";
                    break;
                case 6:
                    statusLabel = "Tender Created";
                    break;
                case 7:
                    statusLabel = "Draft";
                    break;
                default:
                    statusLabel = "";
                    break;
            }

            JSONObject json = new JSONObject();
            json.put("srNo", srNo++);
            json.put("prNo",
                    "<a href='prMaster.htm?act=PRHistory&pr_no=" + prNo
                    + "' class='fw-600 text-break gradient-text'>" + prNo + "</a>");
            json.put("title", title);
            json.put("projectId", projectId);
            json.put("contactPerson", contactPerson);
            json.put("announceDate", announceDate);
            json.put("authorizeFlag", statusLabel);

            dataArray.put(json);
        }

        JSONObject responseJson = new JSONObject();
        responseJson.put("draw", draw);
        responseJson.put("recordsTotal", totalRecords);
        responseJson.put("recordsFiltered", filteredRecords);
        responseJson.put("data", dataArray);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(responseJson.toString());
        return null;
    }

    public ModelAndView livePrDashboadPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        UserRights userRights = userRightsService.readByUser(username);
        int createTender = userRights.getCreateTender();
        mv.getModelMap().put("createTender", createTender);

        if (createTender == 1) {
            username = "";
        }

        List list0 = departmentMasterService.read();
        mv.getModelMap().put("list0", list0);

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));

        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().isEmpty()) {
            orderDir = "desc";
        } else {
            orderDir = "desc".equalsIgnoreCase(orderDir) ? "desc" : "asc";
        }

        if (orderColumnIndex == null || orderColumnIndex.isEmpty()) {
            orderColumnIndex = "0";
        }

        String orderColumn;
        switch (orderColumnIndex) {
            case "1":
                orderColumn = "prNo";
                break;
            case "2":
                orderColumn = "title";
                break;
            case "3":
                orderColumn = "projectId";
                break;
            case "4":
                orderColumn = "contactPerson";
                break;
            case "5":
                orderColumn = "announceDate";
                break;
            case "6":
                orderColumn = "prAuthorizeUser";
                break;
            case "7":
                orderColumn = "prAuthorizeDate";
                break;
            default:
                orderColumn = "id";
                break;
        }

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate").trim() : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate").trim() : "";

        SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            if (!Fromdate.isEmpty()) {
                Date fromDateObj = inputFormat.parse(Fromdate);
                Fromdate = outputFormat.format(fromDateObj);
            }
            if (!Todate.isEmpty()) {
                Date toDateObj = inputFormat.parse(Todate);
                Todate = outputFormat.format(toDateObj);
            }
        } catch (Exception e) {
        }

        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter").trim() : "";
        String Department = request.getParameter("Department") != null ? request.getParameter("Department").trim() : "";

        if (Filter.equalsIgnoreCase("--select--")) {
            Filter = "";
        }
        if (Department.equalsIgnoreCase("--select--")) {
            Department = "";
        }

        String formattedDate = "";
        String formattedStartDate = "";
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        try {
            if (!Filter.isEmpty()) {
                LocalDateTime now = LocalDateTime.now();
                LocalDateTime startDate;

                switch (Filter) {
                    case "last-week":
                        startDate = now.minusDays(7);
                        break;
                    case "last-month":
                        startDate = now.minusDays(30);
                        break;
                    case "last-6-month":
                        startDate = now.minusDays(183);
                        break;
                    case "last-year":
                        startDate = now.minusDays(365);
                        break;
                    default:
                        startDate = now;
                        break;
                }

                formattedDate = now.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
        } catch (Exception e) {
        }

        List list = prMasterService.getlivePrPagination(start, length, searchValue, orderColumn, orderDir, username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
        int totalRecords = prMasterService.getlivePrCount();
        int filteredRecords = prMasterService.getFilteredlivePrCount(searchValue, username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);

        JSONArray dataArray = new JSONArray();

        int srNo = start + 1;

        for (Object obj : list) {
            Object[] row = (Object[]) obj;

            String prNo = row[1] != null ? row[1].toString() : "";
            String title = row[2] != null ? row[2].toString() : "";
            String projectId = row[3] != null ? row[3].toString() : "";
            String contactPerson = row[4] != null ? row[4].toString() : "";
            String announceDate = row[5] != null ? row[5].toString() : "";
            String prAuthorizeUser = row[6] != null ? row[6].toString() : "";
            String prAuthorizeDate = row[7] != null ? row[7].toString() : "";
            int flagStatus = row[8] != null ? ((Number) row[8]).intValue() : -1;

            String statusLabel;
            switch (flagStatus) {
                case 0:
                    statusLabel = "Pending";
                    break;
                case 1:
                    statusLabel = "Approve";
                    break;
                case 2:
                    statusLabel = "Rework";
                    break;
                case 3:
                    statusLabel = "Reject";
                    break;
                case 6:
                    statusLabel = "Tender Created";
                    break;
                case 7:
                    statusLabel = "Draft";
                    break;
                default:
                    statusLabel = "";
                    break;
            }

            JSONObject json = new JSONObject();
            json.put("srNo", srNo++);
            json.put("prNo",
                    "<a href='prMaster.htm?act=PRHistory&pr_no=" + prNo
                    + "' class='fw-600 text-break gradient-text'>" + prNo + "</a>");
            json.put("title", title);
            json.put("projectId", projectId);
            json.put("contactPerson", contactPerson);
            json.put("announceDate", announceDate);
            json.put("prAuthorizeUser", prAuthorizeUser);
            json.put("prAuthorizeDate", prAuthorizeDate);
            json.put("authorizeFlag", statusLabel);

            dataArray.put(json);
        }

        JSONObject responseJson = new JSONObject();
        responseJson.put("draw", draw);
        responseJson.put("recordsTotal", totalRecords);
        responseJson.put("recordsFiltered", filteredRecords);
        responseJson.put("data", dataArray);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(responseJson.toString());
        return null;
    }

    public ModelAndView tenderPendingToFloatDashboadPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        UserRights userRights = userRightsService.readByUser(username);
        int createTender = userRights.getCreateTender();
        mv.getModelMap().put("createTender", createTender);

        if (createTender == 1) {
            username = "";
        }

        List list0 = departmentMasterService.read();
        mv.getModelMap().put("list0", list0);

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));

        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().isEmpty()) {
            orderDir = "desc";
        } else {
            orderDir = "desc".equalsIgnoreCase(orderDir) ? "desc" : "asc";
        }

        if (orderColumnIndex == null || orderColumnIndex.isEmpty()) {
            orderColumnIndex = "0";
        }

        String orderColumn;
        switch (orderColumnIndex) {
            case "1":
                orderColumn = "prNo";
                break;
            case "2":
                orderColumn = "title";
                break;
            case "3":
                orderColumn = "projectId";
                break;
            case "4":
                orderColumn = "contactPerson";
                break;
            case "5":
                orderColumn = "tenderAssignUser";
                break;
            case "6":
                orderColumn = "tenderAssignDate";
                break;
            case "7":
                orderColumn = "announceDate";
                break;
            default:
                orderColumn = "id";
                break;
        }

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate").trim() : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate").trim() : "";

        SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            if (!Fromdate.isEmpty()) {
                Date fromDateObj = inputFormat.parse(Fromdate);
                Fromdate = outputFormat.format(fromDateObj);
            }
            if (!Todate.isEmpty()) {
                Date toDateObj = inputFormat.parse(Todate);
                Todate = outputFormat.format(toDateObj);
            }
        } catch (Exception e) {
        }

        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter").trim() : "";
        String Department = request.getParameter("Department") != null ? request.getParameter("Department").trim() : "";

        if (Filter.equalsIgnoreCase("--select--")) {
            Filter = "";
        }
        if (Department.equalsIgnoreCase("--select--")) {
            Department = "";
        }

        String formattedDate = "";
        String formattedStartDate = "";
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        try {
            if (!Filter.isEmpty()) {
                LocalDateTime now = LocalDateTime.now();
                LocalDateTime startDate;

                switch (Filter) {
                    case "last-week":
                        startDate = now.minusDays(7);
                        break;
                    case "last-month":
                        startDate = now.minusDays(30);
                        break;
                    case "last-6-month":
                        startDate = now.minusDays(183);
                        break;
                    case "last-year":
                        startDate = now.minusDays(365);
                        break;
                    default:
                        startDate = now;
                        break;
                }

                formattedDate = now.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
        } catch (Exception e) {
        }

        List list = prMasterService.gettenderPendingToFloatPagination(start, length, searchValue, orderColumn, orderDir, username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
        int totalRecords = prMasterService.gettenderPendingToFloatCount();
        int filteredRecords = prMasterService.getFilteredtenderPendingToFloatCount(searchValue, username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);

        JSONArray dataArray = new JSONArray();

        int srNo = start + 1;

        for (Object obj : list) {
            Object[] row = (Object[]) obj;

            String prNo = row[1] != null ? row[1].toString() : "";
            String title = row[2] != null ? row[2].toString() : "";
            String projectId = row[3] != null ? row[3].toString() : "";
            String contactPerson = row[4] != null ? row[4].toString() : "";
            String tenderAssignUser = row[5] != null ? row[5].toString() : "";
            String tenderAssignDate = row[6] != null ? row[6].toString() : "";
            String announceDate = row[7] != null ? row[7].toString() : "";
            int flagStatus = row[8] != null ? ((Number) row[8]).intValue() : -1;

            String statusLabel;
            switch (flagStatus) {
                case 0:
                    statusLabel = "Pending";
                    break;
                case 1:
                    statusLabel = "Approve";
                    break;
                case 2:
                    statusLabel = "Rework";
                    break;
                case 3:
                    statusLabel = "Reject";
                    break;
                case 6:
                    statusLabel = "Tender Created";
                    break;
                case 7:
                    statusLabel = "Draft";
                    break;
                default:
                    statusLabel = "";
                    break;
            }

            JSONObject json = new JSONObject();
            json.put("srNo", srNo++);
            json.put("prNo",
                    "<a href='prMaster.htm?act=PRHistory&pr_no=" + prNo
                    + "' class='fw-600 text-break gradient-text'>" + prNo + "</a>");
            json.put("title", title);
            json.put("projectId", projectId);
            json.put("contactPerson", contactPerson);
            json.put("tenderAssignUser", tenderAssignUser);
            json.put("tenderAssignDate", tenderAssignDate);
            json.put("announceDate", announceDate);
            json.put("authorizeFlag", statusLabel);

            dataArray.put(json);
        }

        JSONObject responseJson = new JSONObject();
        responseJson.put("draw", draw);
        responseJson.put("recordsTotal", totalRecords);
        responseJson.put("recordsFiltered", filteredRecords);
        responseJson.put("data", dataArray);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(responseJson.toString());
        return null;
    }

    public ModelAndView pendingToAssignDashboadPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        UserRights userRights = userRightsService.readByUser(username);
        int createTender = userRights.getCreateTender();
        mv.getModelMap().put("createTender", createTender);

        if (createTender == 1) {
            username = "";
        }

        List list0 = departmentMasterService.read();
        mv.getModelMap().put("list0", list0);

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));

        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().isEmpty()) {
            orderDir = "desc";
        } else {
            orderDir = "desc".equalsIgnoreCase(orderDir) ? "desc" : "asc";
        }

        if (orderColumnIndex == null || orderColumnIndex.isEmpty()) {
            orderColumnIndex = "0";
        }

        String orderColumn;
        switch (orderColumnIndex) {
            case "1":
                orderColumn = "prNo";
                break;
            case "2":
                orderColumn = "title";
                break;
            case "3":
                orderColumn = "projectId";
                break;
            case "4":
                orderColumn = "prAuthorizeUser";
                break;
            case "5":
                orderColumn = "prAuthorizeDate";
                break;
            case "6":
                orderColumn = "contactPerson";
                break;
            case "7":
                orderColumn = "announceDate";
                break;
            default:
                orderColumn = "id";
                break;
        }

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate").trim() : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate").trim() : "";

        SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            if (!Fromdate.isEmpty()) {
                Date fromDateObj = inputFormat.parse(Fromdate);
                Fromdate = outputFormat.format(fromDateObj);
            }
            if (!Todate.isEmpty()) {
                Date toDateObj = inputFormat.parse(Todate);
                Todate = outputFormat.format(toDateObj);
            }
        } catch (Exception e) {
        }

        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter").trim() : "";
        String Department = request.getParameter("Department") != null ? request.getParameter("Department").trim() : "";

        if (Filter.equalsIgnoreCase("--select--")) {
            Filter = "";
        }
        if (Department.equalsIgnoreCase("--select--")) {
            Department = "";
        }

        String formattedDate = "";
        String formattedStartDate = "";
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        try {
            if (!Filter.isEmpty()) {
                LocalDateTime now = LocalDateTime.now();
                LocalDateTime startDate;

                switch (Filter) {
                    case "last-week":
                        startDate = now.minusDays(7);
                        break;
                    case "last-month":
                        startDate = now.minusDays(30);
                        break;
                    case "last-6-month":
                        startDate = now.minusDays(183);
                        break;
                    case "last-year":
                        startDate = now.minusDays(365);
                        break;
                    default:
                        startDate = now;
                        break;
                }

                formattedDate = now.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
        } catch (Exception e) {
        }

        List list = prMasterService.getPendingToAssignPagination(start, length, searchValue, orderColumn, orderDir, username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
        int totalRecords = prMasterService.getPendingToAssignFloatCount();
        int filteredRecords = prMasterService.getFilteredPendingToAssignCount(searchValue, username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);

        JSONArray dataArray = new JSONArray();

        int srNo = start + 1;

        for (Object obj : list) {
            Object[] row = (Object[]) obj;

            String prNo = row[1] != null ? row[1].toString() : "";
            String title = row[2] != null ? row[2].toString() : "";
            String projectId = row[3] != null ? row[3].toString() : "";
            String prAuthorizeUser = row[4] != null ? row[4].toString() : "";
            String prAuthorizeDate = row[5] != null ? row[5].toString() : "";
            String contactPerson = row[6] != null ? row[6].toString() : "";
            String announceDate = row[7] != null ? row[7].toString() : "";
            int flagStatus = row[8] != null ? ((Number) row[8]).intValue() : -1;

            String statusLabel;
            switch (flagStatus) {
                case 0:
                    statusLabel = "Pending";
                    break;
                case 1:
                    statusLabel = "Approve";
                    break;
                case 2:
                    statusLabel = "Rework";
                    break;
                case 3:
                    statusLabel = "Reject";
                    break;
                case 6:
                    statusLabel = "Tender Created";
                    break;
                case 7:
                    statusLabel = "Draft";
                    break;
                default:
                    statusLabel = "";
                    break;
            }

            JSONObject json = new JSONObject();
            json.put("srNo", srNo++);
            json.put("prNo",
                    "<a href='prMaster.htm?act=PRHistory&pr_no=" + prNo
                    + "' class='fw-600 text-break gradient-text'>" + prNo + "</a>");
            json.put("title", title);
            json.put("projectId", projectId);
            json.put("prAuthorizeUser", prAuthorizeUser);
            json.put("prAuthorizeDate", prAuthorizeDate);
            json.put("contactPerson", contactPerson);
            json.put("announceDate", announceDate);
            json.put("authorizeFlag", statusLabel);

            dataArray.put(json);
        }

        JSONObject responseJson = new JSONObject();
        responseJson.put("draw", draw);
        responseJson.put("recordsTotal", totalRecords);
        responseJson.put("recordsFiltered", filteredRecords);
        responseJson.put("data", dataArray);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(responseJson.toString());
        return null;
    }

    public ModelAndView assginedToBuyerDashboadPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        UserRights userRights = userRightsService.readByUser(username);
        int createTender = userRights.getCreateTender();
        mv.getModelMap().put("createTender", createTender);

        if (createTender == 1) {
            username = "";
        }

        List list0 = departmentMasterService.read();
        mv.getModelMap().put("list0", list0);

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));

        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().isEmpty()) {
            orderDir = "desc";
        } else {
            orderDir = "desc".equalsIgnoreCase(orderDir) ? "desc" : "asc";
        }

        if (orderColumnIndex == null || orderColumnIndex.isEmpty()) {
            orderColumnIndex = "0";
        }

        String orderColumn;
        switch (orderColumnIndex) {
            case "1":
                orderColumn = "prNo";
                break;
            case "2":
                orderColumn = "title";
                break;
            case "3":
                orderColumn = "projectId";
                break;
            case "4":
                orderColumn = "prAuthorizeUser";
                break;
            case "5":
                orderColumn = "prAuthorizeDate";
                break;
            case "6":
                orderColumn = "tenderAssignUser";
                break;
            case "7":
                orderColumn = "tenderAssignDate";
                break;
            case "8":
                orderColumn = "contactPerson";
                break;
            case "9":
                orderColumn = "announceDate";
                break;
            default:
                orderColumn = "id";
                break;
        }

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate").trim() : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate").trim() : "";

        SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            if (!Fromdate.isEmpty()) {
                Date fromDateObj = inputFormat.parse(Fromdate);
                Fromdate = outputFormat.format(fromDateObj);
            }
            if (!Todate.isEmpty()) {
                Date toDateObj = inputFormat.parse(Todate);
                Todate = outputFormat.format(toDateObj);
            }
        } catch (Exception e) {
        }

        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter").trim() : "";
        String Department = request.getParameter("Department") != null ? request.getParameter("Department").trim() : "";

        if (Filter.equalsIgnoreCase("--select--")) {
            Filter = "";
        }
        if (Department.equalsIgnoreCase("--select--")) {
            Department = "";
        }

        String formattedDate = "";
        String formattedStartDate = "";
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        try {
            if (!Filter.isEmpty()) {
                LocalDateTime now = LocalDateTime.now();
                LocalDateTime startDate;

                switch (Filter) {
                    case "last-week":
                        startDate = now.minusDays(7);
                        break;
                    case "last-month":
                        startDate = now.minusDays(30);
                        break;
                    case "last-6-month":
                        startDate = now.minusDays(183);
                        break;
                    case "last-year":
                        startDate = now.minusDays(365);
                        break;
                    default:
                        startDate = now;
                        break;
                }

                formattedDate = now.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
        } catch (Exception e) {
        }

        List list = prMasterService.getAssginedToBuyerPagination(start, length, searchValue, orderColumn, orderDir, username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
        int totalRecords = prMasterService.getAssginedToBuyerCount();
        int filteredRecords = prMasterService.getFilteredAssginedToBuyerCount(searchValue, username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);

        JSONArray dataArray = new JSONArray();

        int srNo = start + 1;

        for (Object obj : list) {
            Object[] row = (Object[]) obj;

            String prNo = row[1] != null ? row[1].toString() : "";
            String title = row[2] != null ? row[2].toString() : "";
            String projectId = row[3] != null ? row[3].toString() : "";
            String prAuthorizeUser = row[4] != null ? row[4].toString() : "";
            String prAuthorizeDate = row[5] != null ? row[5].toString() : "";
            String tenderAssignUser = row[6] != null ? row[6].toString() : "";
            String tenderAssignDate = row[7] != null ? row[7].toString() : "";
            String contactPerson = row[8] != null ? row[8].toString() : "";
            String announceDate = row[9] != null ? row[9].toString() : "";
            int flagStatus = row[10] != null ? ((Number) row[10]).intValue() : -1;

            String statusLabel;
            switch (flagStatus) {
                case 0:
                    statusLabel = "Pending";
                    break;
                case 1:
                    statusLabel = "Approve";
                    break;
                case 2:
                    statusLabel = "Rework";
                    break;
                case 3:
                    statusLabel = "Reject";
                    break;
                case 6:
                    statusLabel = "Tender Created";
                    break;
                case 7:
                    statusLabel = "Draft";
                    break;
                default:
                    statusLabel = "";
                    break;
            }

            JSONObject json = new JSONObject();
            json.put("srNo", srNo++);
            json.put("prNo",
                    "<a href='prMaster.htm?act=PRHistory&pr_no=" + prNo
                    + "' class='fw-600 text-break gradient-text'>" + prNo + "</a>");
            json.put("title", title);
            json.put("projectId", projectId);
            json.put("prAuthorizeUser", prAuthorizeUser);
            json.put("prAuthorizeDate", prAuthorizeDate);
            json.put("tenderAssignUser", tenderAssignUser);
            json.put("tenderAssignDate", tenderAssignDate);
            json.put("contactPerson", contactPerson);
            json.put("announceDate", announceDate);
            json.put("authorizeFlag", statusLabel);

            dataArray.put(json);
        }

        JSONObject responseJson = new JSONObject();
        responseJson.put("draw", draw);
        responseJson.put("recordsTotal", totalRecords);
        responseJson.put("recordsFiltered", filteredRecords);
        responseJson.put("data", dataArray);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(responseJson.toString());
        return null;
    }

    public ModelAndView tenderCreatedDashboadPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        UserRights userRights = userRightsService.readByUser(username);
        int createTender = userRights.getCreateTender();
        mv.getModelMap().put("createTender", createTender);

        if (createTender == 1) {
            username = "";
        }

        List list0 = departmentMasterService.read();
        mv.getModelMap().put("list0", list0);

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));

        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().isEmpty()) {
            orderDir = "desc";
        } else {
            orderDir = "desc".equalsIgnoreCase(orderDir) ? "desc" : "asc";
        }

        if (orderColumnIndex == null || orderColumnIndex.isEmpty()) {
            orderColumnIndex = "0";
        }

        String orderColumn;
        switch (orderColumnIndex) {
            case "1":
                orderColumn = "srNo";
                break;
            case "2":
                orderColumn = "refNo";
                break;
            case "3":
                orderColumn = "title";
                break;
            case "4":
                orderColumn = "categoryId";
                break;
            case "5":
                orderColumn = "type";
                break;
            case "6":
                orderColumn = "contactPerson";
                break;
            case "7":
                orderColumn = "announceDate";
                break;
            case "8":
                orderColumn = "prAdmin";
                break;
            case "9":
                orderColumn = "authorizeDate";
                break;
            case "10":
                orderColumn = "projectId";
                break;
            default:
                orderColumn = "id";
                break;
        }

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate").trim() : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate").trim() : "";

        SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            if (!Fromdate.isEmpty()) {
                Date fromDateObj = inputFormat.parse(Fromdate);
                Fromdate = outputFormat.format(fromDateObj);
            }
            if (!Todate.isEmpty()) {
                Date toDateObj = inputFormat.parse(Todate);
                Todate = outputFormat.format(toDateObj);
            }
        } catch (Exception e) {
        }

        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter").trim() : "";
        String Department = request.getParameter("Department") != null ? request.getParameter("Department").trim() : "";

        if (Filter.equalsIgnoreCase("--select--")) {
            Filter = "";
        }
        if (Department.equalsIgnoreCase("--select--")) {
            Department = "";
        }

        String formattedDate = "";
        String formattedStartDate = "";
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        try {
            if (!Filter.isEmpty()) {
                LocalDateTime now = LocalDateTime.now();
                LocalDateTime startDate;

                switch (Filter) {
                    case "last-week":
                        startDate = now.minusDays(7);
                        break;
                    case "last-month":
                        startDate = now.minusDays(30);
                        break;
                    case "last-6-month":
                        startDate = now.minusDays(183);
                        break;
                    case "last-year":
                        startDate = now.minusDays(365);
                        break;
                    default:
                        startDate = now;
                        break;
                }

                formattedDate = now.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
        } catch (Exception e) {
        }

        List list = tenderMasterService.gettenderCreatedPagination(start, length, searchValue, orderColumn, orderDir, username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
        int totalRecords = tenderMasterService.gettenderCreatedCount();
        int filteredRecords = tenderMasterService.getFilteredtenderCreatedCount(searchValue, username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);

        JSONArray dataArray = new JSONArray();

        int srNo = start + 1;

        for (Object obj : list) {
            Object[] row = (Object[]) obj;

            String refNo = row[1] != null ? row[1].toString() : "";
            String title = row[2] != null ? row[2].toString() : "";
            String projectId = row[9] != null ? row[9].toString() : "";
            String categoryId = row[3] != null ? row[3].toString() : "";
            String type = row[4] != null ? row[4].toString() : "";
            String contactPerson = row[5] != null ? row[5].toString() : "";
            String announceDate = row[6] != null ? row[6].toString() : "";
            String prAdmin = row[7] != null ? row[7].toString() : "";
            String authorizeDate = row[8] != null ? row[8].toString() : "";

            JSONObject json = new JSONObject();
            json.put("srNo", srNo++);
            json.put("refNo",
                    "<a href='prMaster.htm?act=PRHistory&pr_no=" + refNo
                    + "' class='fw-600 text-break gradient-text'>" + refNo + "</a>");
            json.put("title", title);
            json.put("categoryId", categoryId);
            json.put("type", type);
            json.put("contactPerson", contactPerson);
            json.put("announceDate", announceDate);
            json.put("prAdmin", prAdmin);
            json.put("authorizeDate", authorizeDate);
            json.put("projectId", projectId);

            dataArray.put(json);

        }
        JSONObject responseJson = new JSONObject();
        responseJson.put("draw", draw);
        responseJson.put("recordsTotal", totalRecords);
        responseJson.put("recordsFiltered", filteredRecords);
        responseJson.put("data", dataArray);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(responseJson.toString());
        return null;
    }

    public ModelAndView liveTenderDashboadPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        UserRights userRights = userRightsService.readByUser(username);
        int createTender = userRights.getCreateTender();
        mv.getModelMap().put("createTender", createTender);

        if (createTender == 1) {
            username = "";
        }

        List list0 = departmentMasterService.read();
        mv.getModelMap().put("list0", list0);

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));

        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().isEmpty()) {
            orderDir = "desc";
        } else {
            orderDir = "desc".equalsIgnoreCase(orderDir) ? "desc" : "asc";
        }

        if (orderColumnIndex == null || orderColumnIndex.isEmpty()) {
            orderColumnIndex = "0";
        }

        String orderColumn;
        switch (orderColumnIndex) {
            case "1":
                orderColumn = "srNo";
                break;
            case "2":
                orderColumn = "refNo";
                break;
            case "3":
                orderColumn = "title";
                break;
            case "4":
                orderColumn = "categoryId";
                break;
            case "5":
                orderColumn = "type";
                break;
            case "6":
                orderColumn = "contactPerson";
                break;
            case "7":
                orderColumn = "announceDate";
                break;
            case "8":
                orderColumn = "prAdmin";
                break;
            case "9":
                orderColumn = "authorizeDate";
                break;
            case "10":
                orderColumn = "projectId";
                break;
            default:
                orderColumn = "id";
                break;
        }

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate").trim() : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate").trim() : "";

        SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            if (!Fromdate.isEmpty()) {
                Date fromDateObj = inputFormat.parse(Fromdate);
                Fromdate = outputFormat.format(fromDateObj);
            }
            if (!Todate.isEmpty()) {
                Date toDateObj = inputFormat.parse(Todate);
                Todate = outputFormat.format(toDateObj);
            }
        } catch (Exception e) {
        }

        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter").trim() : "";
        String Department = request.getParameter("Department") != null ? request.getParameter("Department").trim() : "";

        if (Filter.equalsIgnoreCase("--select--")) {
            Filter = "";
        }
        if (Department.equalsIgnoreCase("--select--")) {
            Department = "";
        }

        String formattedDate = "";
        String formattedStartDate = "";
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        try {
            if (!Filter.isEmpty()) {
                LocalDateTime now = LocalDateTime.now();
                LocalDateTime startDate;

                switch (Filter) {
                    case "last-week":
                        startDate = now.minusDays(7);
                        break;
                    case "last-month":
                        startDate = now.minusDays(30);
                        break;
                    case "last-6-month":
                        startDate = now.minusDays(183);
                        break;
                    case "last-year":
                        startDate = now.minusDays(365);
                        break;
                    default:
                        startDate = now;
                        break;
                }

                formattedDate = now.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
        } catch (Exception e) {
        }

        List list = tenderMasterService.getliveTenderPagination(start, length, searchValue, orderColumn, orderDir, username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
        int totalRecords = tenderMasterService.getliveTenderCount();
        int filteredRecords = tenderMasterService.getFilteredliveTenderCount(searchValue, username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);

        JSONArray dataArray = new JSONArray();

        int srNo = start + 1;

        for (Object obj : list) {
            Object[] row = (Object[]) obj;

            String refNo = row[1] != null ? row[1].toString() : "";
            String title = row[2] != null ? row[2].toString() : "";
            String projectId = row[9] != null ? row[9].toString() : "";
            String categoryId = row[3] != null ? row[3].toString() : "";
            String type = row[4] != null ? row[4].toString() : "";
            String contactPerson = row[5] != null ? row[5].toString() : "";
            String announceDate = row[6] != null ? row[6].toString() : "";
            String prAdmin = row[7] != null ? row[7].toString() : "";
            String authorizeDate = row[8] != null ? row[8].toString() : "";

            JSONObject json = new JSONObject();
            json.put("srNo", srNo++);
            json.put("refNo",
                    "<a href='prMaster.htm?act=PRHistory&pr_no=" + refNo
                    + "' class='fw-600 text-break gradient-text'>" + refNo + "</a>");
            json.put("title", title);
            json.put("categoryId", categoryId);
            json.put("type", type);
            json.put("contactPerson", contactPerson);
            json.put("announceDate", announceDate);
            json.put("prAdmin", prAdmin);
            json.put("authorizeDate", authorizeDate);
            json.put("projectId", projectId);

            dataArray.put(json);

        }
        JSONObject responseJson = new JSONObject();
        responseJson.put("draw", draw);
        responseJson.put("recordsTotal", totalRecords);
        responseJson.put("recordsFiltered", filteredRecords);
        responseJson.put("data", dataArray);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(responseJson.toString());
        return null;
    }

    public ModelAndView tenderClosedDashboadPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        UserRights userRights = userRightsService.readByUser(username);
        int createTender = userRights.getCreateTender();
        mv.getModelMap().put("createTender", createTender);

        if (createTender == 1) {
            username = "";
        }

        List list0 = departmentMasterService.read();
        mv.getModelMap().put("list0", list0);

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));

        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().isEmpty()) {
            orderDir = "desc";
        } else {
            orderDir = "desc".equalsIgnoreCase(orderDir) ? "desc" : "asc";
        }

        if (orderColumnIndex == null || orderColumnIndex.isEmpty()) {
            orderColumnIndex = "0";
        }

        String orderColumn;
        switch (orderColumnIndex) {
            case "1":
                orderColumn = "refNo";
                break;
            case "2":
                orderColumn = "title";
                break;
            case "3":
                orderColumn = "categoryId";
                break;
            case "4":
                orderColumn = "type";
                break;
            case "5":
                orderColumn = "contactPerson";
                break;
            case "6":
                orderColumn = "announceDate";
                break;
            case "7":
                orderColumn = "prAdmin";
                break;
            case "8":
                orderColumn = "authorizeDate";
                break;
            case "9":
                orderColumn = "projectId";
                break;
            case "10":
                orderColumn = "lowestBid";
                break;
            case "11":
                orderColumn = "vendorCode";
                break;
            default:
                orderColumn = "id";
                break;
        }

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate").trim() : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate").trim() : "";

        SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            if (!Fromdate.isEmpty()) {
                Date fromDateObj = inputFormat.parse(Fromdate);
                Fromdate = outputFormat.format(fromDateObj);
            }
            if (!Todate.isEmpty()) {
                Date toDateObj = inputFormat.parse(Todate);
                Todate = outputFormat.format(toDateObj);
            }
        } catch (Exception e) {
        }

        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter").trim() : "";
        String Department = request.getParameter("Department") != null ? request.getParameter("Department").trim() : "";

        if (Filter.equalsIgnoreCase("--select--")) {
            Filter = "";
        }
        if (Department.equalsIgnoreCase("--select--")) {
            Department = "";
        }

        String formattedDate = "";
        String formattedStartDate = "";
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        try {
            if (!Filter.isEmpty()) {
                LocalDateTime now = LocalDateTime.now();
                LocalDateTime startDate;

                switch (Filter) {
                    case "last-week":
                        startDate = now.minusDays(7);
                        break;
                    case "last-month":
                        startDate = now.minusDays(30);
                        break;
                    case "last-6-month":
                        startDate = now.minusDays(183);
                        break;
                    case "last-year":
                        startDate = now.minusDays(365);
                        break;
                    default:
                        startDate = now;
                        break;
                }

                formattedDate = now.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
        } catch (Exception e) {
        }

        List list = tenderMasterService.gettenderClosedPagination(start, length, searchValue, orderColumn, orderDir, username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
        int totalRecords = tenderMasterService.gettenderClosedCount();
        int filteredRecords = tenderMasterService.getFilteredtenderClosedCount(searchValue, username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);

        JSONArray dataArray = new JSONArray();

        int srNo = start + 1;

        for (Object obj : list) {
            Object[] row = (Object[]) obj;

            String refNo = row[1] != null ? row[1].toString() : "";
            String title = row[2] != null ? row[2].toString() : "";
            String projectId = row[9] != null ? row[9].toString() : "";
            String categoryId = row[3] != null ? row[3].toString() : "";
            String type = row[4] != null ? row[4].toString() : "";
            String contactPerson = row[5] != null ? row[5].toString() : "";
            String announceDate = row[6] != null ? row[6].toString() : "";
            String prAdmin = row[7] != null ? row[7].toString() : "";
            String authorizeDate = row[8] != null ? row[8].toString() : "";
            String lowestBid = row[10] != null ? row[10].toString() : "";
            String vendorCode = row[11] != null ? row[11].toString() : "";

            JSONObject json = new JSONObject();
            json.put("srNo", srNo++);
            json.put("refNo",
                    "<a href='prMaster.htm?act=PRHistory&pr_no=" + refNo
                    + "' class='fw-600 text-break gradient-text'>" + refNo + "</a>");
            json.put("title", title);
            json.put("categoryId", categoryId);
            json.put("type", type);
            json.put("contactPerson", contactPerson);
            json.put("announceDate", announceDate);
            json.put("prAdmin", prAdmin);
            json.put("authorizeDate", authorizeDate);
            json.put("projectId", projectId);
            json.put("lowestBid", lowestBid);
            json.put("vendorCode", vendorCode);

            dataArray.put(json);

        }
        JSONObject responseJson = new JSONObject();
        responseJson.put("draw", draw);
        responseJson.put("recordsTotal", totalRecords);
        responseJson.put("recordsFiltered", filteredRecords);
        responseJson.put("data", dataArray);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(responseJson.toString());
        return null;
    }

    public ModelAndView totalTenderClosedByForceDashboadPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        UserRights userRights = userRightsService.readByUser(username);
        int createTender = userRights.getCreateTender();
        mv.getModelMap().put("createTender", createTender);

        if (createTender == 1) {
            username = "";
        }

        List list0 = departmentMasterService.read();
        mv.getModelMap().put("list0", list0);

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));

        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().isEmpty()) {
            orderDir = "desc";
        } else {
            orderDir = "desc".equalsIgnoreCase(orderDir) ? "desc" : "asc";
        }

        if (orderColumnIndex == null || orderColumnIndex.isEmpty()) {
            orderColumnIndex = "0";
        }

        String orderColumn;
        switch (orderColumnIndex) {
            case "1":
                orderColumn = "refNo";
                break;
            case "2":
                orderColumn = "title";
                break;
            case "3":
                orderColumn = "categoryId";
                break;
            case "4":
                orderColumn = "type";
                break;
            case "5":
                orderColumn = "contactPerson";
                break;
            case "6":
                orderColumn = "announceDate";
                break;
            case "7":
                orderColumn = "prAdmin";
                break;
            case "8":
                orderColumn = "authorizeDate";
                break;
            case "9":
                orderColumn = "projectId";
                break;
            case "10":
                orderColumn = "deleteRemark";
                break;

            default:
                orderColumn = "id";
                break;
        }

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate").trim() : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate").trim() : "";

        SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            if (!Fromdate.isEmpty()) {
                Date fromDateObj = inputFormat.parse(Fromdate);
                Fromdate = outputFormat.format(fromDateObj);
            }
            if (!Todate.isEmpty()) {
                Date toDateObj = inputFormat.parse(Todate);
                Todate = outputFormat.format(toDateObj);
            }
        } catch (Exception e) {
        }

        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter").trim() : "";
        String Department = request.getParameter("Department") != null ? request.getParameter("Department").trim() : "";

        if (Filter.equalsIgnoreCase("--select--")) {
            Filter = "";
        }
        if (Department.equalsIgnoreCase("--select--")) {
            Department = "";
        }

        String formattedDate = "";
        String formattedStartDate = "";
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        try {
            if (!Filter.isEmpty()) {
                LocalDateTime now = LocalDateTime.now();
                LocalDateTime startDate;

                switch (Filter) {
                    case "last-week":
                        startDate = now.minusDays(7);
                        break;
                    case "last-month":
                        startDate = now.minusDays(30);
                        break;
                    case "last-6-month":
                        startDate = now.minusDays(183);
                        break;
                    case "last-year":
                        startDate = now.minusDays(365);
                        break;
                    default:
                        startDate = now;
                        break;
                }

                formattedDate = now.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
        } catch (Exception e) {
        }

        List list = tenderMasterService.gettotalTenderClosedByForcePagination(start, length, searchValue, orderColumn, orderDir, username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);
        int totalRecords = tenderMasterService.gettotalTenderClosedByForceCount();
        int filteredRecords = tenderMasterService.getFilteredtotalTenderClosedByForceCount(searchValue, username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);

        JSONArray dataArray = new JSONArray();

        int srNo = start + 1;

        for (Object obj : list) {
            Object[] row = (Object[]) obj;

            String refNo = row[1] != null ? row[1].toString() : "";
            String title = row[2] != null ? row[2].toString() : "";
            String projectId = row[9] != null ? row[9].toString() : "";
            String categoryId = row[3] != null ? row[3].toString() : "";
            String type = row[4] != null ? row[4].toString() : "";
            String contactPerson = row[5] != null ? row[5].toString() : "";
            String announceDate = row[6] != null ? row[6].toString() : "";
            String prAdmin = row[7] != null ? row[7].toString() : "";
            String authorizeDate = row[8] != null ? row[8].toString() : "";
            String deleteRemark = row[10] != null ? row[10].toString() : "";

            JSONObject json = new JSONObject();
            json.put("srNo", srNo++);
            json.put("refNo",
                    "<a href='prMaster.htm?act=PRHistory&pr_no=" + refNo
                    + "' class='fw-600 text-break gradient-text'>" + refNo + "</a>");
            json.put("title", title);
            json.put("categoryId", categoryId);
            json.put("type", type);
            json.put("contactPerson", contactPerson);
            json.put("announceDate", announceDate);
            json.put("prAdmin", prAdmin);
            json.put("authorizeDate", authorizeDate);
            json.put("projectId", projectId);
            json.put("deleteRemark", deleteRemark);

            dataArray.put(json);

        }
        JSONObject responseJson = new JSONObject();
        responseJson.put("draw", draw);
        responseJson.put("recordsTotal", totalRecords);
        responseJson.put("recordsFiltered", filteredRecords);
        responseJson.put("data", dataArray);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(responseJson.toString());
        return null;
    }

    public ModelAndView closePrDashboadPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        UserRights userRights = userRightsService.readByUser(username);
        int createTender = userRights.getCreateTender();
        // FIXED: removed list0 and createTender from model — this method returns null
        //        (raw JSON), so anything put into ModelAndView is never used

        if (createTender == 1) {
            username = "";
        }

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));

        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().isEmpty()) {
            orderDir = "desc";
        } else {
            orderDir = "desc".equalsIgnoreCase(orderDir) ? "desc" : "asc";
        }

        if (orderColumnIndex == null || orderColumnIndex.isEmpty()) {
            orderColumnIndex = "0";
        }

        String orderColumn;
        switch (orderColumnIndex) {
            case "1":
                orderColumn = "prNo";
                break;
            case "2":
                orderColumn = "title";
                break;
            case "3":
                orderColumn = "projectId";
                break;
            case "4":
                orderColumn = "contactPerson";
                break;
            case "5":
                orderColumn = "announceDate";
                break;
            default:
                orderColumn = "id";
                break;
        }

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate").trim() : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate").trim() : "";
        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter").trim() : "";
        String Department = request.getParameter("Department") != null ? request.getParameter("Department").trim() : "";

        SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            if (!Fromdate.isEmpty()) {
                Date fromDateObj = inputFormat.parse(Fromdate);
                Fromdate = outputFormat.format(fromDateObj);
            }
            if (!Todate.isEmpty()) {
                Date toDateObj = inputFormat.parse(Todate);
                Todate = outputFormat.format(toDateObj);
            }
        } catch (Exception e) {
        }

        if (Filter.equalsIgnoreCase("--select--")) {
            Filter = "";
        }
        if (Department.equalsIgnoreCase("--select--")) {
            Department = "";
        }

        String formattedDate = "";
        String formattedStartDate = "";
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        try {
            if (!Filter.isEmpty()) {
                LocalDateTime now = LocalDateTime.now();
                LocalDateTime startDate;
                switch (Filter) {
                    case "last-week":
                        startDate = now.minusDays(7);
                        break;
                    case "last-month":
                        startDate = now.minusDays(30);
                        break;
                    case "last-6-month":
                        startDate = now.minusDays(183);
                        break;
                    case "last-year":
                        startDate = now.minusDays(365);
                        break;
                    default:
                        startDate = now;
                        break;
                }
                formattedDate = now.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
        } catch (Exception e) {
        }

        List list = prMasterService.getClosedPrPagination(
                start, length, searchValue, orderColumn, orderDir,
                username, Fromdate, Todate, Filter,
                formattedDate, formattedStartDate, Department);

        int totalRecords = prMasterService.getClosedPrCount();
        int filteredRecords = prMasterService.getFilteredClosedPrCount(
                searchValue, username, Fromdate, Todate, Filter,
                formattedDate, formattedStartDate, Department);

        JSONArray dataArray = new JSONArray();

        // FIXED: isDesc so srNo counts correctly in both sort directions
        boolean isDesc = "desc".equalsIgnoreCase(orderDir);
        int srNo = isDesc ? (start + 1) : (filteredRecords - start);

        for (Object obj : list) {
            Object[] row = (Object[]) obj;

            int id = row[0] != null ? ((Number) row[0]).intValue() : 0;
            String prNo = row[1] != null ? row[1].toString() : "";
            String title = row[2] != null ? row[2].toString() : "";
            String projectId = row[3] != null ? row[3].toString() : "";
            String contactPerson = row[4] != null ? row[4].toString() : "";
            String announceDate = row[5] != null ? row[5].toString() : "";
            int authorizeFlag = row[6] != null ? ((Number) row[6]).intValue() : -1;

            String statusLabel;
            switch (authorizeFlag) {
                case 0:
                    statusLabel = "Pending";
                    break;
                case 1:
                    statusLabel = "Approve";
                    break;
                case 2:
                    statusLabel = "Rework";
                    break;
                case 3:
                    statusLabel = "Reject";
                    break;
                case 6:
                    statusLabel = "Tender Created";
                    break;
                case 7:
                    statusLabel = "Draft";
                    break;
                case 151:
                    statusLabel = "Closed";
                    break;
                default:
                    statusLabel = "";
                    break;
            }

            JSONObject json = new JSONObject();
            json.put("srNo", isDesc ? srNo++ : srNo--);
            json.put("prNo",
                    "<a href='prMaster.htm?act=PRHistory&pr_no=" + prNo
                    + "' class='fw-600 text-break gradient-text'>" + prNo + "</a>");
            json.put("title", title);
            json.put("projectId", projectId);
            json.put("contactPerson", contactPerson);
            json.put("announceDate", announceDate);
            json.put("authorizeFlag", statusLabel);

            String btnStyle = "style='min-width:140px; white-space:nowrap; text-align:center;'";
            String actionButtons = "<a href='prMaster.htm?act=closeprview&id=" + id
                    + "' class='btn theme-btn light-btn mx-1' " + btnStyle + ">View</a>";

            json.put("action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + actionButtons + "</div>");

            dataArray.put(json);
        }

        JSONObject responseJson = new JSONObject();
        responseJson.put("draw", draw);
        responseJson.put("recordsTotal", totalRecords);
        responseJson.put("recordsFiltered", filteredRecords);
        responseJson.put("data", dataArray);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(responseJson.toString());
        return null;

    }

    public ModelAndView monthWisePrDashboadPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        UserRights userRights = userRightsService.readByUser(username);
        int createTender = userRights.getCreateTender();

        if (createTender == 1) {
            username = "";
        }

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));

        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().isEmpty()) {
            orderDir = "desc";
        } else {
            orderDir = "desc".equalsIgnoreCase(orderDir) ? "desc" : "asc";
        }

        if (orderColumnIndex == null || orderColumnIndex.trim().isEmpty()) {
            orderColumnIndex = "0";
        }

        String orderColumn;
        switch (orderColumnIndex) {
            case "1":
                orderColumn = "prNo";
                break;
            case "2":
                orderColumn = "title";
                break;
            case "3":
                orderColumn = "projectId";
                break;
            case "4":
                orderColumn = "contactPerson";
                break;
            case "5":
                orderColumn = "announceDate";
                break;
            case "6":
                orderColumn = "authorizeFlag";
                break;
            default:
                orderColumn = "id";
                break;
        }

        String StartDate = "";
        String EndDate = "";
        String MonthName1 = request.getParameter("label");

        if (MonthName1 != null && !MonthName1.trim().isEmpty()) {
            try {
                DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MMM-yy", Locale.ENGLISH);
                DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MMMM-yyyy", Locale.ENGLISH);
                YearMonth yearMonth = YearMonth.parse(MonthName1, inputFormatter);
                String MonthName = yearMonth.format(outputFormatter);

                SimpleDateFormat sdf = new SimpleDateFormat("MMMM-yyyy");
                Date date = sdf.parse(MonthName);

                Calendar startCal = Calendar.getInstance();
                startCal.setTime(date);
                startCal.set(Calendar.DAY_OF_MONTH, 1);
                StartDate = new SimpleDateFormat("dd-MM-yyyy").format(startCal.getTime());

                Calendar endCal = Calendar.getInstance();
                endCal.setTime(date);
                endCal.set(Calendar.DAY_OF_MONTH, endCal.getActualMaximum(Calendar.DAY_OF_MONTH));
                EndDate = new SimpleDateFormat("dd-MM-yyyy").format(endCal.getTime());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter").trim() : "";
        String Department = request.getParameter("Department") != null ? request.getParameter("Department").trim() : "";

        if (Filter.equalsIgnoreCase("--select--")) {
            Filter = "";
        }
        if (Department.equalsIgnoreCase("--select--")) {
            Department = "";
        }

        String formattedDate = "";
        String formattedStartDate = "";
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        try {
            if (!Filter.isEmpty()) {
                LocalDateTime now = LocalDateTime.now();
                LocalDateTime startDate;
                switch (Filter) {
                    case "last-week":
                        startDate = now.minusDays(7);
                        break;
                    case "last-month":
                        startDate = now.minusDays(30);
                        break;
                    case "last-6-month":
                        startDate = now.minusDays(183);
                        break;
                    case "last-year":
                        startDate = now.minusDays(365);
                        break;
                    default:
                        startDate = now;
                        break;
                }
                formattedDate = now.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
        } catch (Exception e) {
        }

        List list = prMasterService.getmonthWiseListPrGraphUserPagination(start, length, searchValue, orderColumn, orderDir, username, StartDate, EndDate, Filter, formattedDate, formattedStartDate, Department);

        int totalRecords = prMasterService.getmonthWiseListPrGraphUserCount(username, StartDate, EndDate, Filter, formattedDate, formattedStartDate, Department);

        int filteredRecords = prMasterService.getFilteredmonthWiseListPrGraphUserCount(searchValue, username, StartDate, EndDate, Filter, formattedDate, formattedStartDate, Department);

        JSONArray dataArray = new JSONArray();

        boolean isDesc = "desc".equalsIgnoreCase(orderDir);
        int srNo = isDesc ? (start + 1) : (filteredRecords - start);

        for (Object obj : list) {
            Object[] row = (Object[]) obj;

            String prNo = row[1] != null ? row[1].toString() : "";
            String title = row[2] != null ? row[2].toString() : "";
            String projectId = row[3] != null ? row[3].toString() : "";
            String contactPerson = row[4] != null ? row[4].toString() : "";
            String announceDate = row[5] != null ? row[5].toString() : "";
            int authorizeFlag = row[6] != null ? ((Number) row[6]).intValue() : -1;

            String statusLabel;
            switch (authorizeFlag) {
                case 0:
                    statusLabel = "Pending";
                    break;
                case 1:
                    statusLabel = "Approve";
                    break;
                case 2:
                    statusLabel = "Rework";
                    break;
                case 3:
                    statusLabel = "Reject";
                    break;
                case 6:
                    statusLabel = "Tender Created";
                    break;
                case 7:
                    statusLabel = "Draft";
                    break;
                case 151:
                    statusLabel = "Closed";
                    break;
                default:
                    statusLabel = "";
                    break;
            }

            JSONObject json = new JSONObject();
            json.put("srNo", isDesc ? srNo++ : srNo--);
            json.put("prNo",
                    "<a href='prMaster.htm?act=PRHistory&pr_no=" + prNo
                    + "' class='fw-600 text-break gradient-text'>" + prNo + "</a>");
            json.put("title", title);
            json.put("projectId", projectId);
            json.put("contactPerson", contactPerson);
            json.put("announceDate", announceDate);
            json.put("authorizeFlag", statusLabel);

            dataArray.put(json);
        }

        JSONObject responseJson = new JSONObject();
        responseJson.put("draw", draw);
        responseJson.put("recordsTotal", totalRecords);
        responseJson.put("recordsFiltered", filteredRecords);
        responseJson.put("data", dataArray);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(responseJson.toString());
        return null;
    }

    public ModelAndView monthWiseTenderDashboadPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        UserRights userRights = userRightsService.readByUser(username);
        int createTender = userRights.getCreateTender();

        if (createTender == 1) {
            username = "";
        }

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));

        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().isEmpty()) {
            orderDir = "desc";
        } else {
            orderDir = "desc".equalsIgnoreCase(orderDir) ? "desc" : "asc";
        }

        if (orderColumnIndex == null || orderColumnIndex.trim().isEmpty()) {
            orderColumnIndex = "0";
        }

        // ✅ FIX 2: column switch matches JSP thead order
        // thead: srNo(0), refNo(1), title(2), projectId(3), categoryId(4),
        //        type(5), contactPerson(6), announceDate(7)
        String orderColumn;
        switch (orderColumnIndex) {
            case "1":
                orderColumn = "refNo";
                break;
            case "2":
                orderColumn = "title";
                break;
            case "3":
                orderColumn = "projectId";
                break; // ✅ was categoryId
            case "4":
                orderColumn = "categoryId";
                break; // ✅ was type
            case "5":
                orderColumn = "type";
                break; // ✅ was contactPerson
            case "6":
                orderColumn = "contactPerson";
                break; // ✅ was announceDate
            case "7":
                orderColumn = "announceDate";
                break; // ✅ was projectId
            default:
                orderColumn = "id";
                break;
        }

        String StartDate = "";
        String EndDate = "";
        String MonthName1 = request.getParameter("label");

        if (MonthName1 != null && !MonthName1.trim().isEmpty()) {
            try {
                DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MMM-yy", Locale.ENGLISH);
                DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MMMM-yyyy", Locale.ENGLISH);
                YearMonth yearMonth = YearMonth.parse(MonthName1, inputFormatter);
                String MonthName = yearMonth.format(outputFormatter);

                SimpleDateFormat sdf = new SimpleDateFormat("MMMM-yyyy");
                Date date = sdf.parse(MonthName);

                Calendar startCal = Calendar.getInstance();
                startCal.setTime(date);
                startCal.set(Calendar.DAY_OF_MONTH, 1);
                StartDate = new SimpleDateFormat("dd-MM-yyyy").format(startCal.getTime());

                Calendar endCal = Calendar.getInstance();
                endCal.setTime(date);
                endCal.set(Calendar.DAY_OF_MONTH, endCal.getActualMaximum(Calendar.DAY_OF_MONTH));
                EndDate = new SimpleDateFormat("dd-MM-yyyy").format(endCal.getTime());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter").trim() : "";
        String Department = request.getParameter("Department") != null ? request.getParameter("Department").trim() : "";

        if (Filter.equalsIgnoreCase("--select--")) {
            Filter = "";
        }
        if (Department.equalsIgnoreCase("--select--")) {
            Department = "";
        }

        String formattedDate = "";
        String formattedStartDate = "";
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        try {
            if (!Filter.isEmpty()) {
                LocalDateTime now = LocalDateTime.now();
                LocalDateTime startDate;
                switch (Filter) {
                    case "last-week":
                        startDate = now.minusDays(7);
                        break;
                    case "last-month":
                        startDate = now.minusDays(30);
                        break;
                    case "last-6-month":
                        startDate = now.minusDays(183);
                        break;
                    case "last-year":
                        startDate = now.minusDays(365);
                        break;
                    default:
                        startDate = now;
                        break;
                }
                formattedDate = now.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        List list = tenderMasterService.getmonthWiseTenderListPrGraphUserPagination(
                start, length, searchValue, orderColumn, orderDir,
                username, StartDate, EndDate,
                Filter, formattedDate, formattedStartDate, Department);

        int totalRecords = tenderMasterService.getmonthWiseTenderListPrGraphUserCount(
                username, StartDate, EndDate,
                Filter, formattedDate, formattedStartDate, Department);

        int filteredRecords = tenderMasterService.getFilteredmonthWiseTenderListPrGraphUserCount(
                searchValue, username, StartDate, EndDate,
                Filter, formattedDate, formattedStartDate, Department);

        JSONArray dataArray = new JSONArray();

        // ✅ FIX 3: simple srNo = start + 1 always
        int srNo = start + 1;

        for (Object obj : list) {
            Object[] row = (Object[]) obj;

            // HQL SELECT: id(0), refNo(1), title(2), categoryId(3), type(4),
            //             contactPerson(5), announceDate(6), projectId(7)
            String refNo = row[1] != null ? row[1].toString() : "";
            String title = row[2] != null ? row[2].toString() : "";
            String categoryId = row[3] != null ? row[3].toString() : "";
            String type = row[4] != null ? row[4].toString() : "";
            String contactPerson = row[5] != null ? row[5].toString() : "";
            String announceDate = row[6] != null ? row[6].toString() : "";
            String projectId = row[7] != null ? row[7].toString() : "";

            JSONObject json = new JSONObject();
            json.put("srNo", srNo++);
            json.put("refNo",
                    "<a href='prMaster.htm?act=PRHistory&pr_no=" + refNo
                    + "' class='fw-600 text-break gradient-text'>" + refNo + "</a>");
            json.put("title", title);
            json.put("projectId", projectId);   // ✅ matches columns: data:'projectId' at position 3
            json.put("categoryId", categoryId);  // ✅ matches columns: data:'categoryId' at position 4
            json.put("type", type);
            json.put("contactPerson", contactPerson);
            json.put("announceDate", announceDate);

            dataArray.put(json);
        }

        JSONObject responseJson = new JSONObject();
        responseJson.put("draw", draw);
        responseJson.put("recordsTotal", totalRecords);
        responseJson.put("recordsFiltered", filteredRecords);
        responseJson.put("data", dataArray);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(responseJson.toString());
        return null;
    }

    public ModelAndView contactPersonTenderPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        UserRights userRights = userRightsService.readByUser(username);
        int createTender = userRights.getCreateTender();
        mv.getModelMap().put("createTender", createTender);

        if (createTender == 1) {
            username = "";
        }

        List list0 = departmentMasterService.read();
        mv.getModelMap().put("list0", list0);

        String Fromdate = request.getParameter("Fromdate") != null ? request.getParameter("Fromdate") : "";
        String Todate = request.getParameter("Todate") != null ? request.getParameter("Todate") : "";

        SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");

        try {
            if (!Fromdate.isEmpty()) {
                Date fromDateObj = inputFormat.parse(Fromdate);
                Fromdate = outputFormat.format(fromDateObj);
            }
            if (!Todate.isEmpty()) {
                Date toDateObj = inputFormat.parse(Todate);
                Todate = outputFormat.format(toDateObj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String Filter = request.getParameter("Filter") != null ? request.getParameter("Filter") : "";
        String Department = request.getParameter("Department") != null ? request.getParameter("Department") : "";
        String formattedDate = request.getParameter("formattedDate") != null ? request.getParameter("formattedDate") : "";
        String formattedStartDate = request.getParameter("formattedStartDate") != null ? request.getParameter("formattedStartDate") : "";

        if (Filter.equals("--select--")) {
            Filter = "";
        }
        if (Department.equals("--select--")) {
            Department = "";
        }

        try {
            if (Filter.equals("last-month")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(30);
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-week")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(7);
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-year")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(365);
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
            if (Filter.equals("last-6-month")) {
                LocalDateTime myDateObj = LocalDateTime.now();
                LocalDateTime startDate = myDateObj.minusDays(183);
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                formattedDate = myDateObj.format(myFormatObj);
                formattedStartDate = startDate.format(myFormatObj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String Value = request.getParameter("Value");
        String ContactPerson = request.getParameter("contact");

        if (createTender == 1) {
            username = "";
        }

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));

        String searchValue = request.getParameter("search[value]");

        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().isEmpty()) {
            orderDir = "desc";
        } else {
            orderDir = "desc".equalsIgnoreCase(orderDir) ? "desc" : "asc";
        }

        if (orderColumnIndex == null || orderColumnIndex.trim().isEmpty()) {
            orderColumnIndex = "0";
        }

        String orderColumn;
        switch (orderColumnIndex) {
            case "1":
                orderColumn = "refNo";
                break;
            case "2":
                orderColumn = "title";
                break;
            case "3":
                orderColumn = "projectId";
                break;
            case "4":
                orderColumn = "categoryId";
                break;
            case "5":
                orderColumn = "type";
                break;
            case "6":
                orderColumn = "contactPerson";
                break;
            case "7":
                orderColumn = "announceDate";
                break;
            default:
                orderColumn = "id";
                break;
        }

        List list = tenderMasterService.getContactperGraphUserPagination(start, length, searchValue, orderColumn, orderDir, ContactPerson, Value, username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);

        int totalRecords = tenderMasterService.getContactperGraphUserCount(ContactPerson, Value, username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);

        int filteredRecords = tenderMasterService.getFilteredContactperGraphUserCount(searchValue, ContactPerson, Value, username, Fromdate, Todate, Filter, formattedDate, formattedStartDate, Department);

        JSONArray dataArray = new JSONArray();

        boolean isDesc = "desc".equalsIgnoreCase(orderDir);
        int srNo = isDesc ? (start + 1) : (filteredRecords - start);

        for (Object obj : list) {
            Object[] row = (Object[]) obj;

            String refNo = row[0] != null ? row[0].toString() : "";
            String title = row[1] != null ? row[1].toString() : "";
            String categoryId = row[2] != null ? row[2].toString() : "";
            String type = row[3] != null ? row[3].toString() : "";
            String contactPerson = row[4] != null ? row[4].toString() : "";
            String announceDate = row[5] != null ? row[5].toString() : "";
            String projectId = row[6] != null ? row[6].toString() : "";

            JSONObject json = new JSONObject();
            json.put("srNo", isDesc ? srNo++ : srNo--);
            json.put("refNo",
                    "<a href='prMaster.htm?act=PRHistory&pr_no=" + refNo
                    + "' class='fw-600 text-break gradient-text'>" + refNo + "</a>");
            json.put("title", title);
            json.put("categoryId", categoryId);
            json.put("type", type);
            json.put("contactPerson", contactPerson);
            json.put("announceDate", announceDate);
            json.put("projectId", projectId);

            dataArray.put(json);
        }

        JSONObject responseJson = new JSONObject();
        responseJson.put("draw", draw);
        responseJson.put("recordsTotal", totalRecords);
        responseJson.put("recordsFiltered", filteredRecords);
        responseJson.put("data", dataArray);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(responseJson.toString());

        return null;
    }

    public ModelAndView vendorBlockList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String user11 = user.getLoginName();

        UserRights rights = userRightsService.readByUser(user11);
        String userName = "";
        if (rights.getAllVendor() != 1) {
            userName = user11;
        }
        request.setAttribute("userRights", rights);

        int activeVendorCount = vendorInformationService.readActiveVendorCount();
        mv.getModelMap().put("activeVendorCount", activeVendorCount);

        int inprogressVendorCount = vendorInformationService.inprogressVendorCount();
        mv.getModelMap().put("inprogressVendorCount", inprogressVendorCount);

        int recordsTotalInvitedVendor = vendorInformationService.getInvitedVendorCount(userName);
        mv.getModelMap().put("invitedVendorCount", recordsTotalInvitedVendor);

        int rejectedVendorCount = vendorInformationService.rejectedVendorCount();
        mv.getModelMap().put("rejectedVendorCount", rejectedVendorCount);

        int vendorBlockCount = vendorInformationService.vendorBlockCount();
        mv.getModelMap().put("vendorBlockCount", vendorBlockCount);

        VendorInformation vendorInformation = new VendorInformation();
        String vendorEmailId = request.getParameter("vendorEmailId");
        UserRights userRights = userRightsService.readByUser(user11);
        request.setAttribute("userRights", userRights);

        List<GroupMaster> list = (List<GroupMaster>) groupMasterService.read();
        List<GroupCategory> list1 = (List<GroupCategory>) groupCategoryService.read();
        List<GroupSubCategory> list2 = (List<GroupSubCategory>) groupSubCategoryService.read();

        Set<String> groupNaames = new HashSet<>();
        Set<String> groupeCategories = new HashSet<>();
        Set<String> groupeSubCategories = new HashSet<>();

        Map<String, Map<String, List<String>>> groupData = new HashMap<>();

        for (GroupMaster item : list) {
            String groupName = item.getGroupName();
            Map<String, List<String>> categoryMap = groupData.computeIfAbsent(groupName, k -> new HashMap<>());

            for (GroupCategory subItem : list1) {
                if (subItem.getGroupMasterId() == item.getId()) {
                    String categoryName = subItem.getGroupCatogryName();
                    List<String> subCategoryList = categoryMap.computeIfAbsent(categoryName, k -> new ArrayList<>());

                    for (GroupSubCategory subsub : list2) {
                        if (subsub.getGroupCategoryId() == subItem.getId()) {
                            subCategoryList.add(subsub.getSubCategoryName());
                        }
                    }
                }
            }
        }

        Gson gson = new Gson();
        String groupHierarchyJson = gson.toJson(groupData);
        request.setAttribute("groupHierarchyJson", groupHierarchyJson);

        mv.setViewName("Dashboard/vendorBlockListDashboard");
        return mv;
    }

    public ModelAndView vendorBlockListPagination(HttpServletRequest request, HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String user11 = user.getLoginName();
        UserRights userRights = userRightsService.readByUser(user11);

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));

        String searchValue = request.getParameter("search[value]");

        String sapCodeFilter = request.getParameter("sapCodeFilter");
        String companyNameFilter = request.getParameter("companyNameFilter");
        String vendorEmailIdFilter = request.getParameter("vendorEmailIdFilter");
        String contactNoFilter = request.getParameter("contactNoFilter");
        String groupNameFilter = request.getParameter("groupNameFilter");
        String groupCategoryFilter = request.getParameter("groupCategoryFilter");
        String groupSubCategoryFilter = request.getParameter("groupSubCategoryFilter");
        String countryFilter = request.getParameter("countryFilter");
        String stateFilter = request.getParameter("stateFilter");
        String cityFilter = request.getParameter("cityFilter");
        String gstNoFilter = request.getParameter("gstNoFilter");
        String panNoFilter = request.getParameter("panNoFilter");
        String riskCategoryFilter = request.getParameter("riskCategoryFilter");
        String vendorInviteSourceFilter = request.getParameter("vendorInviteSourceFilter");
        String invitedByFilter = request.getParameter("invitedByFilter");
        String activatedDateFilter = request.getParameter("activatedDateFilter");

        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.equals("")) {
            orderDir = "desc";
        }

        if (orderColumnIndex == null || orderColumnIndex.equals("")) {
            orderColumnIndex = "0";
        }

        String orderColumn = "id";

        if (orderColumnIndex != null) {

            switch (Integer.parseInt(orderColumnIndex)) {

                case 0:
                    orderColumn = "a.id";
                    break;
                case 1:
                    orderColumn = "a.sapCode";
                    break;
                case 2:
                    orderColumn = "a.companyName";
                    break;
                case 3:
                    orderColumn = "a.vendorEmailId";
                    break;
                case 4:
                    orderColumn = "a.officeTelephone";
                    break;
                case 5:
                    orderColumn = "a.vendorTypes";
                    break;
                case 6:
                    orderColumn = "a.groupCategory";
                    break;

                case 7:
                    orderColumn = "a.groupSubCategory";
                    break;
                case 8:
                    orderColumn = "b.altCountry";
                    break;
                case 9:
                    orderColumn = "b.altState";
                    break;
                case 10:
                    orderColumn = "b.altCity";
                    break;
                case 11:
                    orderColumn = "a.gstinNo";
                    break;
                case 12:
                    orderColumn = "a.panNo";
                    break;
                case 13:
                    orderColumn = "a.riskCategory";
                    break;
                case 14:
                    orderColumn = "a.vendorInviteSource";
                    break;
                case 15:
                    orderColumn = "a.approvalOne";
                    break;
                case 16:
                    orderColumn = "a.vendorActivatedDate";
                    break;
                default:
                    orderColumn = "a.id";
            }
        }

        List activeVendorList = vendorInformationService.getBlockVendorPagination(start, length, searchValue, sapCodeFilter, companyNameFilter, vendorEmailIdFilter, contactNoFilter, groupNameFilter, groupCategoryFilter, groupSubCategoryFilter, countryFilter, stateFilter, cityFilter, gstNoFilter, panNoFilter, riskCategoryFilter, vendorInviteSourceFilter, invitedByFilter, activatedDateFilter, orderColumn, orderDir);

        int recordsTotalActiveVendor = vendorInformationService.getBlockVendorCount();

        int recordsFilteredActiveVendor = vendorInformationService.getFilteredBlockVendorCount(searchValue, sapCodeFilter, companyNameFilter, vendorEmailIdFilter, contactNoFilter, groupNameFilter, groupCategoryFilter, groupSubCategoryFilter, countryFilter, stateFilter, cityFilter, gstNoFilter, panNoFilter, riskCategoryFilter, vendorInviteSourceFilter, invitedByFilter, activatedDateFilter);

        List data = new ArrayList();

        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo;

        if (isDesc) {
            srNo = recordsFilteredActiveVendor - start;
        } else {
            srNo = start + 1;
        }

        for (Iterator it = activeVendorList.iterator(); it.hasNext();) {

            Object[] row = (Object[]) it.next();

            Map map = new HashMap();

            if (isDesc) {
                map.put("srNo", srNo--);
            } else {
                map.put("srNo", srNo++);
            }

            map.put("sapCode", row[2] != null ? row[2] : "");

            map.put("companyName", row[4] != null ? row[4] : "");

            map.put("vendorEmailId", row[1] != null ? row[1] : "");

            String countryCode = row[5] != null ? row[5].toString() : "";
            String mobileNo = row[6] != null ? row[6].toString() : "";

            map.put("contactNo", !mobileNo.trim().isEmpty() ? "+" + countryCode + " " + mobileNo : "");

//            map.put("groupName", row[7] != null ? row[7] : "");
//
//            map.put("groupCategoryName", row[8] != null ? row[8] : "");
//
//            map.put("groupSubCategoryName", row[9] != null ? row[9] : "");
            String groupNameStr = "";
            String groupCategoryNameStr = "";
            String groupSubCategoryNameStr = "";

            Integer vendorInvtId = (Integer) row[19];

            List list222 = vendorInvitationCategoryService.readIds(vendorInvtId);

            Set<String> groupNames = new LinkedHashSet<>();
            Set<String> groupCategoryNames = new LinkedHashSet<>();
            Set<String> groupSubCategoryNames = new LinkedHashSet<>();

            if (list222 != null) {
                for (Object o : list222) {
                    Object[] catRow = (Object[]) o;

                    String gName = catRow[2] != null ? catRow[2].toString().trim() : "";
                    String gCatName = catRow[3] != null ? catRow[3].toString().trim() : "";
                    String gSubCatName = catRow[4] != null ? catRow[4].toString().trim() : "";

                    if (!gName.isEmpty()) {
                        groupNames.add(gName);
                    }
                    if (!gCatName.isEmpty()) {
                        groupCategoryNames.add(gCatName);
                    }
                    if (!gSubCatName.isEmpty()) {
                        groupSubCategoryNames.add(gSubCatName);
                    }
                }
            }

            groupNameStr = String.join("<br>", groupNames);
            groupCategoryNameStr = String.join("<br>", groupCategoryNames);
            groupSubCategoryNameStr = String.join("<br>", groupSubCategoryNames);

            map.put("groupName", groupNameStr);
            map.put("groupCategoryName", groupCategoryNameStr);
            map.put("groupSubCategoryName", groupSubCategoryNameStr);

            map.put("countryName", row[10] != null ? row[10] : "");

            map.put("stateName", row[11] != null ? row[11] : "");

            map.put("cityName", row[12] != null ? row[12] : "");

            map.put("gstinNo", row[13] != null ? row[13] : "");

            map.put("panNo", row[14] != null ? row[14] : "");

            String riskCategory = row[15] != null ? row[15].toString() : "";

            if (!riskCategory.isEmpty()) {
                riskCategory = riskCategory.substring(0, 1).toUpperCase()
                        + riskCategory.substring(1).toLowerCase();
            }

            map.put("riskCategory", riskCategory);

            map.put("vendorInviteSource", row[16] != null ? row[16] : "");

            map.put("invitedBy", row[17] != null ? row[17] : "");

            map.put("vendorActivatedDate", row[18] != null ? row[18] : "");

            String vendorId = row[0] != null ? row[0].toString() : "";

            String sapCode = row[2] != null ? row[2].toString() : "";
            String assignedUser = row[3] != null ? row[3].toString() : "";
            String companyName = row[4] != null ? row[4].toString().replace("'", "\\'") : "";

            String view = "<div style='display:flex; gap:10px;'>"
                    + "<a href='vendorInformation.htm?act=vendorBlockView&id=" + vendorId + "' class='btn theme-btn light-btn'>View</a>";

            view += "<a href='javascript:void(0);' class='btn theme-btn light-btn' "
                    + "onclick=\"openBlockListModal('" + vendorId + "','" + companyName + "')\">UnBlock/Resume</a>";

            view += "</div>";
            map.put("view", view);

            if (assignedUser.equals(user11) && (sapCode == null || sapCode.trim().isEmpty())) {

                map.put("sapCodeButton",
                        "<button type='button' "
                        + "class='fw-600 text-break gradient-text border-0 bg-transparent' "
                        + "onclick=\"openSapPopup('"
                        + vendorId + "','"
                        + companyName + "','"
                        + sapCode
                        + "')\">Add SAP Code</button>");

            } else {

                map.put("sapCodeButton", sapCode);
            }

            data.add(map);
        }

        JSONObject json = new JSONObject();

        json.put("draw", draw);
        json.put("recordsTotal", recordsTotalActiveVendor);
        json.put("recordsFiltered", recordsFilteredActiveVendor);
        json.put("data", data);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        response.getWriter().write(json.toString());

        return null;

    }

    public void vendorBlockReportExportExcel(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String searchValue = request.getParameter("searchValue");

        String sapCodeFilter = request.getParameter("sapCodeFilter");
        String companyNameFilter = request.getParameter("companyNameFilter");
        String vendorEmailIdFilter = request.getParameter("vendorEmailIdFilter");
        String contactNoFilter = request.getParameter("contactNoFilter");

        String groupNameFilter = request.getParameter("groupNameFilter");
        String groupCategoryFilter = request.getParameter("groupCategoryFilter");
        String groupSubCategoryFilter = request.getParameter("groupSubCategoryFilter");

        String countryFilter = request.getParameter("countryFilter");
        String stateFilter = request.getParameter("stateFilter");
        String cityFilter = request.getParameter("cityFilter");

        String gstNoFilter = request.getParameter("gstNoFilter");
        String panNoFilter = request.getParameter("panNoFilter");

        String riskCategoryFilter = request.getParameter("riskCategoryFilter");
        String vendorInviteSourceFilter = request.getParameter("vendorInviteSourceFilter");
        String invitedByFilter = request.getParameter("invitedByFilter");
        String activatedDateFilter = request.getParameter("activatedDateFilter");

        String orderColumn = "a.id";
        String orderDir = "asc";

        int start = 0;
        int filteredRecords = vendorInformationService.getFilteredBlockVendorCount(searchValue, sapCodeFilter, companyNameFilter, vendorEmailIdFilter, contactNoFilter, groupNameFilter, groupCategoryFilter, groupSubCategoryFilter, countryFilter, stateFilter, cityFilter, gstNoFilter, panNoFilter, riskCategoryFilter, vendorInviteSourceFilter, invitedByFilter, activatedDateFilter);

        List blockVendorReportList = vendorInformationService.getBlockVendorPagination(start, filteredRecords, searchValue, sapCodeFilter, companyNameFilter, vendorEmailIdFilter, contactNoFilter, groupNameFilter, groupCategoryFilter, groupSubCategoryFilter, countryFilter, stateFilter, cityFilter, gstNoFilter, panNoFilter, riskCategoryFilter, vendorInviteSourceFilter, invitedByFilter, activatedDateFilter, orderColumn, orderDir);

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Block Vendor Report");

        CellStyle headerStyle = workbook.createCellStyle();
        Font headerFont = workbook.createFont();
        headerFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
        headerFont.setColor(IndexedColors.WHITE.getIndex());
        headerStyle.setFont(headerFont);
        headerStyle.setFillForegroundColor(IndexedColors.DARK_BLUE.getIndex());
        headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        headerStyle.setAlignment(CellStyle.ALIGN_CENTER);
        headerStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);

        XSSFColor headerColor = new XSSFColor(new java.awt.Color(31, 78, 120));
        ((XSSFCellStyle) headerStyle).setFillForegroundColor(headerColor);
        headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);

        CellStyle wrapStyle = workbook.createCellStyle();
        wrapStyle.setWrapText(true);
        wrapStyle.setVerticalAlignment(CellStyle.VERTICAL_TOP);

        String[] headers = {
            "Sr.No.", "SAP Code", "Company Name", "Email Id", "Contact No",
            "Group Name", "Group Category", "Group Sub Category", "Country",
            "State", "City", "GST No.", "PAN No.", "Risk Category",
            "Vendor Invite Source", "Invited By", "Activated Date"
        };

        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(headerStyle);
        }

        sheet.createFreezePane(0, 1);

        int rowNum = 1;
        int srNo = 1;

        for (Iterator it = blockVendorReportList.iterator(); it.hasNext();) {
            Object[] row = (Object[]) it.next();
            Row excelRow = sheet.createRow(rowNum++);

            excelRow.createCell(0).setCellValue(srNo++);
            excelRow.createCell(1).setCellValue(row[2] != null ? row[2].toString() : "");
            excelRow.createCell(2).setCellValue(row[4] != null ? row[4].toString() : "");
            excelRow.createCell(3).setCellValue(row[1] != null ? row[1].toString() : "");

            String countryCode = row[5] != null ? row[5].toString() : "";
            String mobileNo = row[6] != null ? row[6].toString() : "";
            String contactNo = !mobileNo.trim().isEmpty() ? "+" + countryCode + " " + mobileNo : "";
            excelRow.createCell(4).setCellValue(contactNo);

            String groupNameStr = "";
            String groupCategoryNameStr = "";
            String groupSubCategoryNameStr = "";

            Integer vendorInvtId = (Integer) row[19];

            List list222 = vendorInvitationCategoryService.readIds(vendorInvtId);

            Set<String> groupNames = new LinkedHashSet<>();
            Set<String> groupCategoryNames = new LinkedHashSet<>();
            Set<String> groupSubCategoryNames = new LinkedHashSet<>();

            if (list222 != null) {
                for (Object o : list222) {
                    Object[] catRow = (Object[]) o;

                    String gName = catRow[2] != null ? catRow[2].toString().trim() : "";
                    String gCatName = catRow[3] != null ? catRow[3].toString().trim() : "";
                    String gSubCatName = catRow[4] != null ? catRow[4].toString().trim() : "";

                    if (!gName.isEmpty()) {
                        groupNames.add(gName);
                    }
                    if (!gCatName.isEmpty()) {
                        groupCategoryNames.add(gCatName);
                    }
                    if (!gSubCatName.isEmpty()) {
                        groupSubCategoryNames.add(gSubCatName);
                    }
                }
            }

            groupNameStr = String.join("\n", groupNames);
            groupCategoryNameStr = String.join("\n", groupCategoryNames);
            groupSubCategoryNameStr = String.join("\n", groupSubCategoryNames);

            Cell groupNameCell = excelRow.createCell(5);
            groupNameCell.setCellValue(groupNameStr);
            groupNameCell.setCellStyle(wrapStyle);

            Cell groupCategoryCell = excelRow.createCell(6);
            groupCategoryCell.setCellValue(groupCategoryNameStr);
            groupCategoryCell.setCellStyle(wrapStyle);

            Cell groupSubCategoryCell = excelRow.createCell(7);
            groupSubCategoryCell.setCellValue(groupSubCategoryNameStr);
            groupSubCategoryCell.setCellStyle(wrapStyle);

            excelRow.createCell(8).setCellValue(row[10] != null ? row[10].toString() : "");
            excelRow.createCell(9).setCellValue(row[11] != null ? row[11].toString() : "");
            excelRow.createCell(10).setCellValue(row[12] != null ? row[12].toString() : "");
            excelRow.createCell(11).setCellValue(row[13] != null ? row[13].toString() : "");
            excelRow.createCell(12).setCellValue(row[14] != null ? row[14].toString() : "");

            String riskCategory = row[15] != null ? row[15].toString() : "";
            if (!riskCategory.isEmpty()) {
                riskCategory = riskCategory.substring(0, 1).toUpperCase()
                        + riskCategory.substring(1).toLowerCase();
            }
            excelRow.createCell(13).setCellValue(riskCategory);

            excelRow.createCell(14).setCellValue(row[16] != null ? row[16].toString() : "");
            excelRow.createCell(15).setCellValue(row[17] != null ? row[17].toString() : "");
            excelRow.createCell(16).setCellValue(row[18] != null ? row[18].toString() : "");
        }

        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }

        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
        String currentDate = sdf.format(new Date());
        String fileName = "BlockVendorReport_" + currentDate + ".xlsx";

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

        OutputStream outputStream = response.getOutputStream();
        try {
            workbook.write(outputStream);
        } finally {
            outputStream.flush();
            outputStream.close();
        }
    }

}
