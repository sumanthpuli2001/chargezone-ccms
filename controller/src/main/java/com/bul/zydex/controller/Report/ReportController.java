/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Report;

import static com.bul.zydex.controller.CustomAbstract.dateFormat;
import static com.bul.zydex.controller.CustomAbstract.myIp;
import static com.bul.zydex.controller.CustomAbstract.timeFOrmat;
import com.bul.zydex.model.ApprenticesMaster;
import com.bul.zydex.model.ContractorMaster;
import com.bul.zydex.model.CouponMaster;
import com.bul.zydex.model.DeviceDetails;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.LogsMaster;
import com.bul.zydex.model.PunchedDataMaster;
import com.bul.zydex.model.RechargeInfoMaster;
import com.bul.zydex.model.ReportMaster;
import com.bul.zydex.model.UserMaster;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Aman Bahukhandi
 */
public class ReportController extends ReportAbstract {

    public ModelAndView showList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        readCoupon(request, response);
        mv.setViewName("Report/DayCouponReport");
        return mv;
    }

    public ModelAndView showListEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        readCoupon(request, response);
        mv.setViewName("Report/DayCouponReportEmployee");
        return mv;
    }

    public ModelAndView showMachineList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        deviceNameIpRead(request);
        mv.setViewName("Report/MachineList");
        return mv;
    }

    public ModelAndView searchMachineReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        deviceNameIpRead(request);
        readCoupon(request, response);
        String date1 = request.getParameter("date");
        String item = request.getParameter("item");

        DeviceDetails deviceDetails = deviceService.readById(Integer.parseInt(item));
        List punchedList = punchedDataService.readByMachineDetails(deviceDetails, date1);

        request.setAttribute("dFrom", date1);
        request.setAttribute("item", item);
        request.setAttribute("punchedList", punchedList);
        request.setAttribute("deviceDetails", deviceDetails);
        //------for Log entry---------
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        LogsMaster lm = new LogsMaster();
        Date date = new Date();
        lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("Search Machine Report ").setDrow("Y");
        logService.create(lm);
        mv.setViewName("Report/MachineList");
        return mv;
    }

    public ModelAndView searchDayCoupon(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String dFrom = request.getParameter("startDate");
        String eFrom = request.getParameter("endDate");
        String type = request.getParameter("type");
        String type1 = request.getParameter("type1");
        String empcd = "";
//        String name = request.getParameter("name").trim();
        String cardCode = request.getParameter("cardCode");
        String item = request.getParameter("item");
        String val = request.getParameter("val");
        readCoupon(request, response);
        List couponListAll = new ArrayList();

        List finalList = new ArrayList();

        List totalAmountFinal = new ArrayList();
        List personDetailsFinal = new ArrayList();

        int MILLIS_IN_DAY = 1000 * 60 * 60 * 24;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date sdate = sdf.parse(dFrom);
        Date edate = sdf.parse(eFrom);

        Boolean flag = true;
        int meals = 0;
        int mealActual = 0;
        int mealsSub = 0;
        int tea = 0;
        int teaActual = 0;
        int teaSub = 0;
        int buttermilk = 0;
        int buttermilkActual = 0;
        int buttermilkSub = 0;
        int wet = 0;
        int wetActual = 0;
        int wetSub = 0;
        int dry = 0;
        int dryActual = 0;
        int drySub = 0;
        int ex1p = 0;
        int ex1pSub = 0;
        int ex1pActual = 0;
        int ex2 = 0;
        int ex2Actual = 0;
        int ex2Sub = 0;
        int coffee = 0;
        int coffeeActual = 0;
        int coffeeSub = 0;
        int ex1d = 0;
        int ex1dSub = 0;
        int ex1dActual = 0;
        int ex1v = 0;
        int ex1vSub = 0;
        int ex1vActual = 0;
        int ex2c = 0;
        int ex2cSub = 0;
        int ex2cActual = 0;
        int ex2p = 0;
        int ex2pSub = 0;
        int ex2pActual = 0;
        int milk = 0;
        int milkSub = 0;
        int milkActual = 0;
        int ag = 0;
        int agSub = 0;
        int agActual = 0;
        int sc = 0;
        int scSub = 0;
        int scActual = 0;
        Double newAmount = 0.0;
        int mAvg = 0;
        int mActualAvg = 0;
        int teaAvg = 0;
        int teaActualAvg = 0;
        int wetAvg = 0;
        int wetActualAvg = 0;
        int dryAvg = 0;
        int dryActualAvg = 0;
        int ex1Avg = 0;
        int ex1ActualAvg = 0;
        int ex2Avg = 0;

        int ex2ActualAvg = 0;
        int coffeeAvg = 0;
        int coffeeActualAvg = 0;
        if (user.getLoginName().equals("system")) {

            List rmDistinctList = punchedDataService.readDistinct(dFrom, eFrom, cardCode, item,type1);
            if (type.equals("D")) {
                for (Object o : rmDistinctList) {
                    while (sdate.compareTo(edate) <= 0) {
                        List rmList = punchedDataService.readByValues(sdf.format(sdate), "" + o, item);
                        Double tAmount = 0.0;

                        List personDetails = new ArrayList();
                        List totalAmount = new ArrayList();

                        List finalSubsActual = new ArrayList();

                        if (flag) {
                            couponListAll = couponService.readCoupon(item);
                            flag = false;
                        }
                        for (Object o1 : rmList) {
                            Object[] pdm = (Object[]) o1;
                            CouponMaster cm = couponService.readById(Integer.parseInt("" + pdm[0]));
                            finalSubsActual.add(cm.getCouponType());
                            if (cm.getCouponPrice().equals(pdm[1])) {
                                finalSubsActual.add(pdm[2]);
                                finalSubsActual.add(0);
                                finalSubsActual.add(0);
                                //tea
                                if (pdm[0].equals("01")) {
                                    teaActual += Double.parseDouble("" + pdm[2]);
                                    tea = tea + 0;
                                    teaSub = 0;
                                }
                                //coffee
                                if (pdm[0].equals("02")) {
                                    coffeeActual += Double.parseDouble("" + pdm[2]);
                                    coffee = coffee + 0;
                                    coffeeSub = 0;
                                }
                                //ws
                                if (pdm[0].equals("03")) {
                                    wetActual += Double.parseDouble("" + pdm[2]);
                                    wet = wet + 0;
                                    wetSub = 0;
                                }
                                //ds
                                if (pdm[0].equals("04")) {
                                    dryActual += Double.parseDouble("" + pdm[2]);
                                    dry = dry + 0;
                                    drySub = 0;
                                }
                                //MEALS
                                if (pdm[0].equals("05")) {
                                    mealActual += Double.parseDouble("" + pdm[2]);
                                    meals = meals + 0;
                                    mealsSub = mealsSub + 0;

                                }
                                //ex1p
                                if (pdm[0].equals("06")) {
                                    ex1pActual += Double.parseDouble("" + pdm[2]);
                                    ex1p = ex1p + 0;
                                    ex1pSub = 0;
                                }
//                            //ex1d
                                if (pdm[0].equals("07")) {
                                    ex1dActual += Double.parseDouble("" + pdm[2]);
                                    ex1d = ex1d + 0;
                                    ex1dSub = 0;
                                }
                                //ex1v
                                if (pdm[0].equals("08")) {
                                    ex1vActual += Double.parseDouble("" + pdm[2]);
                                    ex1v = ex1v + 0;
                                    ex1vSub = 0;
                                }
                                //ex2c
                                if (pdm[0].equals("09")) {
                                    ex2cActual += Double.parseDouble("" + pdm[2]);
                                    ex2c = ex2c + 0;

                                    ex2cSub = 0;
                                }
                                //ex2p
                                if (pdm[0].equals("10")) {
                                    ex2pActual += Double.parseDouble("" + pdm[2]);
                                    ex2p = ex2p + 0;
                                    ex2pSub = 0;
                                }
                                //milk
                                if (pdm[0].equals("11")) {
                                    milkActual += Double.parseDouble("" + pdm[2]);
                                    milk = milk + 0;
                                    milkSub = 0;
                                }
                                //Ag
                                if (pdm[0].equals("12")) {
                                    agActual += Double.parseDouble("" + pdm[2]);
                                    ag = ag + 0;
                                    agSub = 0;
                                }
                                //sc
                                if (pdm[0].equals("13")) {
                                    scActual += Double.parseDouble("" + pdm[2]);
                                    sc = sc + 0;
                                    scSub = 0;
                                }
                                //bm
                                if (pdm[0].equals("14")) {
                                    buttermilkActual += Double.parseDouble("" + pdm[2]);
                                    buttermilk = buttermilk + 0;
                                    buttermilkSub = 0;

                                }
                            } else if (cm.getSecondPrice().equals(pdm[1])) {
                                finalSubsActual.add(0);
                                finalSubsActual.add(pdm[2]);
                                finalSubsActual.add(0);

                                //tea
                                if (pdm[0].equals("01")) {
                                    tea = tea + 0;
                                    teaActual += Double.parseDouble("" + pdm[2]);
                                    teaSub = 0;
                                }
                                //coffee
                                if (pdm[0].equals("02")) {
                                    coffee = coffee + 0;
                                    coffeeActual += Double.parseDouble("" + pdm[2]);
                                    coffeeSub = 0;
                                }
                                //ws
                                if (pdm[0].equals("03")) {
                                    wet = wet + 0;
                                    wetActual += Double.parseDouble("" + pdm[2]);
                                    wetSub = 0;
                                }
                                //ds
                                if (pdm[0].equals("04")) {
                                    dry = dry + 0;
                                    dryActual += Double.parseDouble("" + pdm[2]);
                                    drySub = 0;
                                }
                                //MEALS
                                if (pdm[0].equals("05")) {
                                    meals = meals + 0;
                                    mealActual += Double.parseDouble("" + pdm[2]);
                                    mealsSub = mealsSub + 0;
                                }
                                //ex1p
                                if (pdm[0].equals("06")) {
                                    ex1p = ex1p + 0;
                                    ex1pActual += Double.parseDouble("" + pdm[2]);
                                    ex1pSub = 0;
                                }
//                            //ex1d
                                if (pdm[0].equals("07")) {
                                    ex1d = ex1d + 0;
                                    ex1dActual += Double.parseDouble("" + pdm[2]);
                                    ex1dSub = 0;
                                }
                                //ex1v
                                if (pdm[0].equals("08")) {
                                    ex1v = ex1v + 0;
                                    ex1vActual += Double.parseDouble("" + pdm[2]);
                                    ex1vSub = 0;
                                }
                                //ex2c
                                if (pdm[0].equals("09")) {
                                    ex2c = ex2c + 0;
                                    ex2cActual += Double.parseDouble("" + pdm[2]);
                                    ex2cSub = 0;
                                }
                                //ex2p
                                if (pdm[0].equals("10")) {
                                    ex2p = ex2p + 0;
                                    ex2pActual += Double.parseDouble("" + pdm[2]);
                                    ex2pSub = 0;
                                }
                                //milk
                                if (pdm[0].equals("11")) {
                                    milk = milk + 0;
                                    milkActual += Double.parseDouble("" + pdm[2]);
                                    milkSub = 0;
                                }
                                //Ag
                                if (pdm[0].equals("12")) {
                                    ag = ag + 0;
                                    agActual += Double.parseDouble("" + pdm[2]);
                                    agSub = 0;
                                }
                                //sc
                                if (pdm[0].equals("13")) {
                                    sc = sc + 0;
                                    scActual += Double.parseDouble("" + pdm[2]);
                                    scSub = 0;
                                }
                                //bm
                                if (pdm[0].equals("14")) {
                                    buttermilk = buttermilk + 0;
                                    buttermilkActual += Double.parseDouble("" + pdm[2]);
                                    buttermilkSub = 0;

                                }
                            } else if (cm.getAcPrive().equals(pdm[1])) {
                                finalSubsActual.add(0);
                                finalSubsActual.add(0);
                                finalSubsActual.add(pdm[2]);

                                //tea
                                if (pdm[0].equals("01")) {
                                    tea = tea + 0;
                                    teaSub = 0;
                                    teaActual += Double.parseDouble("" + pdm[2]);
                                }
                                //coffee
                                if (pdm[0].equals("02")) {
                                    coffee = coffee + 0;
                                    coffeeSub = 0;
                                    coffeeActual += Double.parseDouble("" + pdm[2]);
                                }
                                //ws
                                if (pdm[0].equals("03")) {
                                    wet = wet + 0;
                                    wetSub = 0;
                                    wetActual += Double.parseDouble("" + pdm[2]);
                                }
                                //ds
                                if (pdm[0].equals("04")) {
                                    dry = dry + 0;
                                    drySub = 0;
                                    dryActual += Double.parseDouble("" + pdm[2]);
                                }
                                //MEALS
                                if (pdm[0].equals("05")) {
                                    meals = meals + 0;
                                    mealsSub = mealsSub + 0;
                                    mealActual += Double.parseDouble("" + pdm[2]);

                                }
                                //ex1p
                                if (pdm[0].equals("06")) {
                                    ex1p = ex1p + 0;
                                    ex1pSub = 0;
                                    ex1pActual += Double.parseDouble("" + pdm[2]);
                                }
//                            //ex1d
                                if (pdm[0].equals("07")) {
                                    ex1d = ex1d + 0;
                                    ex1dSub = 0;
                                    ex1dActual += Double.parseDouble("" + pdm[2]);
                                }
                                //ex1v
                                if (pdm[0].equals("08")) {
                                    ex1v = ex1v + 0;
                                    ex1vSub = 0;
                                    ex1vActual += Double.parseDouble("" + pdm[2]);
                                }
                                //ex2c
                                if (pdm[0].equals("09")) {
                                    ex2c = ex2c + 0;
                                    ex2cSub = 0;
                                    ex2cActual += Double.parseDouble("" + pdm[2]);
                                }
                                //ex2p
                                if (pdm[0].equals("10")) {
                                    ex2p = ex2p + 0;
                                    ex2pSub = 0;
                                    ex2pActual += Double.parseDouble("" + pdm[2]);
                                }
                                //milk
                                if (pdm[0].equals("11")) {
                                    milk = milk + 0;
                                    milkSub = 0;
                                    milkActual += Double.parseDouble("" + pdm[2]);
                                }
                                //Ag
                                if (pdm[0].equals("12")) {
                                    ag = ag + 0;
                                    agSub = 0;
                                    agActual += Double.parseDouble("" + pdm[2]);
                                }
                                //sc
                                if (pdm[0].equals("13")) {
                                    sc = sc + 0;
                                    scSub = 0;
                                    scActual += Double.parseDouble("" + pdm[2]);
                                }
                                //bm
                                if (pdm[0].equals("14")) {
                                    buttermilk = buttermilk + 0;
                                    buttermilkSub = 0;
                                    buttermilkActual += Double.parseDouble("" + pdm[2]);

                                }
                            }
//                        finalSubsActual.add(pdm[2]);
                            tAmount += (Double.parseDouble("" + pdm[1]) * Double.parseDouble("" + pdm[2]));

                        }
                        if (!rmList.isEmpty()) {
                            
                            if (type1.equals("E"))
                            {
                                finalList.add(finalSubsActual);

                                totalAmount.add(tAmount);
                                totalAmountFinal.add(totalAmount);
                                newAmount = tAmount + newAmount;
                                try
                                {
                                    EmployeeMaster emp = employeeMasterService.readByRfIdValue("" + o);

                                    personDetails.add(sdf.format(sdate));
                                    personDetails.add(o);
                                    personDetails.add(emp.getName());

                                    personDetailsFinal.add(personDetails);
                                }
                                catch(Exception e1){
                                    break;
                                }

                            }
                            else if (type1.equals("C"))
                            {
                                finalList.add(finalSubsActual);

                                totalAmount.add(tAmount);
                                totalAmountFinal.add(totalAmount);
                                newAmount = tAmount + newAmount;
                                try
                                {
                                ContractorMaster emp = contractorService.readByRfIdValue("" + o);

                                personDetails.add(sdf.format(sdate));
                                personDetails.add(o);
                                personDetails.add(emp.getName());

                                personDetailsFinal.add(personDetails);
                                }
                                catch(Exception e2){
                                    break;
                                }
                            }


                        }
                        String nxtDate = sdf.format(sdate.getTime() + MILLIS_IN_DAY);
                        sdate = sdf.parse(nxtDate);
                    }
                    sdate = sdf.parse(dFrom);

                }
                //------for Log entry---------

                LogsMaster lm = new LogsMaster();
                Date date = new Date();
                lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("Search Day Coupon").setDrow("Y");
                logService.create(lm);
            } else if (type.equals("M")) {
                
                for (Object o : rmDistinctList) {

                    List rmList = punchedDataService.readBySumValues(sdf.format(sdate), sdf.format(edate), "" + o, item);
                    Double tAmount = 0.0;

                    List personDetails = new ArrayList();
                    List totalAmount = new ArrayList();

                    List finalSubsActual = new ArrayList();

                    if (flag) {
                        couponListAll = couponService.readCoupon(item);
                        flag = false;
                    }
                    for (Object o1 : rmList) {
                        Object[] pdm = (Object[]) o1;
                        CouponMaster cm = couponService.readById(Integer.parseInt("" + pdm[0]));
                        finalSubsActual.add(cm.getCouponType());
                        if (cm.getCouponPrice().equals(pdm[1])) {
                            finalSubsActual.add(pdm[2]);
                            finalSubsActual.add(0);
                            finalSubsActual.add(0);
                            if (pdm[0].equals("01")) {
                                teaActual += Double.parseDouble("" + pdm[2]);
                                tea = tea + 0;
                                teaSub = 0;
                            }
                            //coffee
                            if (pdm[0].equals("02")) {
                                coffeeActual += Double.parseDouble("" + pdm[2]);
                                        coffee = coffee + 0;
                                coffeeSub = 0;
                            }
                            //ws
                            if (pdm[0].equals("03")) {
                                wetActual += Double.parseDouble("" + pdm[2]);
                                wet = wet + 0;
                                wetSub = 0;
                            }
                            //ds
                            if (pdm[0].equals("04")) {
                                dryActual += Double.parseDouble("" + pdm[2]);
                                dry = dry + 0;
                                drySub = 0;
                            }
                            //MEALS
                            if (pdm[0].equals("05")) {
                                mealActual += Double.parseDouble("" + pdm[2]);
                                meals = meals + 0;
                                mealsSub = mealsSub + 0;

                            }
                            //ex1p
                            if (pdm[0].equals("06")) {
                                ex1pActual += Double.parseDouble("" + pdm[2]);
                                ex1p = ex1p + 0;
                                ex1pSub = 0;
                            }
//                            //ex1d
                            if (pdm[0].equals("07")) {
                                ex1dActual += Double.parseDouble("" + pdm[2]);
                                ex1d = ex1d + 0;
                                ex1dSub = 0;
                            }
                            //ex1v
                            if (pdm[0].equals("08")) {
                                ex1vActual += Double.parseDouble("" + pdm[2]);
                                ex1v = ex1v + 0;
                                ex1vSub = 0;
                            }
                            //ex2c
                            if (pdm[0].equals("09")) {
                                ex2cActual += Double.parseDouble("" + pdm[2]);
                                ex2c = ex2c + 0;

                                ex2cSub = 0;
                            }
                            //ex2p
                            if (pdm[0].equals("10")) {
                                ex2pActual += Double.parseDouble("" + pdm[2]);
                                ex2p = ex2p + 0;
                                ex2pSub = 0;
                            }
                            //milk
                            if (pdm[0].equals("11")) {
                                milkActual += Double.parseDouble("" + pdm[2]);
                                milk = milk + 0;
                                milkSub = 0;
                            }
                            //Ag
                            if (pdm[0].equals("12")) {
                                agActual += Double.parseDouble("" + pdm[2]);
                                ag = ag + 0;
                                agSub = 0;
                            }
                            //sc
                            if (pdm[0].equals("13")) {
                                scActual += Double.parseDouble("" + pdm[2]);
                                sc = sc + 0;
                                scSub = 0;
                            }
                            //bm
                            if (pdm[0].equals("14")) {
                                buttermilkActual += Double.parseDouble("" + pdm[2]);
                                buttermilk = buttermilk + 0;
                                buttermilkSub = 0;

                            }
                        } else if (cm.getSecondPrice().equals(pdm[1])) {
                            finalSubsActual.add(0);
                            finalSubsActual.add(pdm[2]);
                            finalSubsActual.add(0);
                            if (pdm[0].equals("01")) {
                                tea = tea + 0;
                                teaActual += Double.parseDouble("" + pdm[2]);
                                teaSub = 0;
                            }
                            //coffee
                            if (pdm[0].equals("02")) {
                                coffee = coffee + 0;
                                coffeeActual += Double.parseDouble("" + pdm[2]);
                                coffeeSub = 0;
                            }
                            //ws
                            if (pdm[0].equals("03")) {
                                wet = wet + 0;
                                wetActual += Double.parseDouble("" + pdm[2]);
                                wetSub = 0;
                            }
                            //ds
                            if (pdm[0].equals("04")) {
                                dry = dry + 0;
                                dryActual += Double.parseDouble("" + pdm[2]);
                                drySub = 0;
                            }
                            //MEALS
                            if (pdm[0].equals("05")) {
                                meals = meals + 0;
                                mealActual += Double.parseDouble("" + pdm[2]);
                                mealsSub = mealsSub + 0;
                            }
                            //ex1p
                            if (pdm[0].equals("06")) {
                                ex1p = ex1p + 0;
                                ex1pActual += Double.parseDouble("" + pdm[2]);
                                ex1pSub = 0;
                            }
//                            //ex1d
                            if (pdm[0].equals("07")) {
                                ex1d = ex1d + 0;
                                ex1dActual += Double.parseDouble("" + pdm[2]);
                                ex1dSub = 0;
                            }
                            //ex1v
                            if (pdm[0].equals("08")) {
                                ex1v = ex1v + 0;
                                ex1vActual += Double.parseDouble("" + pdm[2]);
                                ex1vSub = 0;
                            }
                            //ex2c
                            if (pdm[0].equals("09")) {
                                ex2c = ex2c + 0;
                                ex2cActual += Double.parseDouble("" + pdm[2]);
                                ex2cSub = 0;
                            }
                            //ex2p
                            if (pdm[0].equals("10")) {
                                ex2p = ex2p + 0;
                                ex2pActual += Double.parseDouble("" + pdm[2]);
                                ex2pSub = 0;
                            }
                            //milk
                            if (pdm[0].equals("11")) {
                                milk = milk + 0;
                                milkActual += Double.parseDouble("" + pdm[2]);
                                milkSub = 0;
                            }
                            //Ag
                            if (pdm[0].equals("12")) {
                                ag = ag + 0;
                                agActual += Double.parseDouble("" + pdm[2]);
                                agSub = 0;
                            }
                            //sc
                            if (pdm[0].equals("13")) {
                                sc = sc + 0;
                                scActual += Double.parseDouble("" + pdm[2]);
                                scSub = 0;
                            }
                            //bm
                            if (pdm[0].equals("14")) {
                                buttermilk = buttermilk + 0;
                                buttermilkActual += Double.parseDouble("" + pdm[2]);
                                buttermilkSub = 0;

                            }
                        } else if (cm.getAcPrive().equals(pdm[1])) {
                            finalSubsActual.add(0);
                            finalSubsActual.add(0);
                            finalSubsActual.add(pdm[2]);
                            if (pdm[0].equals("01")) {
                                tea = tea + 0;
                                teaSub = 0;
                                teaActual += Double.parseDouble("" + pdm[2]);
                            }
                            //coffee
                            if (pdm[0].equals("02")) {
                                coffee = coffee + 0;
                                coffeeSub = 0;
                                coffeeActual += Double.parseDouble("" + pdm[2]);
                            }
                            //ws
                            if (pdm[0].equals("03")) {
                                wet = wet + 0;
                                wetSub = 0;
                                wetActual += Double.parseDouble("" + pdm[2]);
                            }
                            //ds
                            if (pdm[0].equals("04")) {
                                dry = dry + 0;
                                drySub = 0;
                                dryActual += Double.parseDouble("" + pdm[2]);
                            }
                            //MEALS
                            if (pdm[0].equals("05")) {
                                meals = meals + 0;
                                mealsSub = mealsSub + 0;
                                mealActual += Double.parseDouble("" + pdm[2]);

                            }
                            //ex1p
                            if (pdm[0].equals("06")) {
                                ex1p = ex1p + 0;
                                ex1pSub = 0;
                                ex1pActual += Double.parseDouble("" + pdm[2]);
                            }
//                            //ex1d
                            if (pdm[0].equals("07")) {
                                ex1d = ex1d + 0;
                                ex1dSub = 0;
                                ex1dActual += Double.parseDouble("" + pdm[2]);
                            }
                            //ex1v
                            if (pdm[0].equals("08")) {
                                ex1v = ex1v + 0;
                                ex1vSub = 0;
                                ex1vActual += Double.parseDouble("" + pdm[2]);
                            }
                            //ex2c
                            if (pdm[0].equals("09")) {
                                ex2c = ex2c + 0;
                                ex2cSub = 0;
                                ex2cActual += Double.parseDouble("" + pdm[2]);
                            }
                            //ex2p
                            if (pdm[0].equals("10")) {
                                ex2p = ex2p + 0;
                                ex2pSub = 0;
                                ex2pActual += Double.parseDouble("" + pdm[2]);
                            }
                            //milk
                            if (pdm[0].equals("11")) {
                                milk = milk + 0;
                                milkSub = 0;
                                milkActual += Double.parseDouble("" + pdm[2]);
                            }
                            //Ag
                            if (pdm[0].equals("12")) {
                                ag = ag + 0;
                                agSub = 0;
                                agActual += Double.parseDouble("" + pdm[2]);
                            }
                            //sc
                            if (pdm[0].equals("13")) {
                                sc = sc + 0;
                                scSub = 0;
                                scActual += Double.parseDouble("" + pdm[2]);
                            }
                            //bm
                            if (pdm[0].equals("14")) {
                                buttermilk = buttermilk + 0;
                                buttermilkSub = 0;
                                buttermilkActual += Double.parseDouble("" + pdm[2]);

                            }

                        }
//                        finalSubsActual.add(pdm[2]);
                        tAmount += (Double.parseDouble("" + pdm[1]) * Double.parseDouble("" + pdm[2]));

                    }
                    if (!rmList.isEmpty()) {
                        
                        if (type1.equals("E"))
                        {
                            finalList.add(finalSubsActual);

                            totalAmount.add(tAmount);
                            totalAmountFinal.add(totalAmount);
                            newAmount = tAmount + newAmount;
                            
                            try
                            {
                                EmployeeMaster emp = employeeMasterService.readByRfIdValue("" + o);

                                personDetails.add(sdf.format(sdate).split("-")[0] + "-" + sdf.format(sdate).split("-")[1]);
                                personDetails.add(o);
                                personDetails.add(emp.getName());

                                personDetailsFinal.add(personDetails);
                            }
                            catch(Exception e1){
                                break;
                            }
                        }
                        else if (type1.equals("C"))
                        {
                            finalList.add(finalSubsActual);

                            totalAmount.add(tAmount);
                            totalAmountFinal.add(totalAmount);
                            newAmount = tAmount + newAmount;
                            
                            try
                            {
                                ContractorMaster emp = contractorService.readByRfIdValue("" + o);

                                personDetails.add(sdf.format(sdate).split("-")[0] + "-" + sdf.format(sdate).split("-")[1]);
                                personDetails.add(o);
                                personDetails.add(emp.getName());

                                personDetailsFinal.add(personDetails);
                            }
                            catch(Exception e1){
                                break;
                            }
                        }
                    }

                }
                //------for Log entry---------

                LogsMaster lm = new LogsMaster();
                Date date = new Date();
                lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("Searched Monthly coupon").setDrow("Y");
                logService.create(lm);
            }
        }
        if (!user.getLoginName().equals("system")) {
            List rmDistinctList1 = punchedDataService.readDistinctforemp(dFrom, eFrom, cardCode, item, user.getLoginName());
            for (Object ob : rmDistinctList1) {
                empcd = "" + ob;
            }
            List rmDistinctList = reportService.readByEmp(dFrom, eFrom, type, cardCode, item, user.getLoginName());
            if (type.equals("D")) {
                for (Object o : rmDistinctList) {
                    Object[] reportName = (Object[]) o;
                    while (sdate.compareTo(edate) <= 0) {
                        List rmList = punchedDataService.readByValues(sdf.format(sdate), "" + "" + empcd, item);
                        Double tAmount = 0.0;

                        List personDetails = new ArrayList();
                        List totalAmount = new ArrayList();

                        List finalSubsActual = new ArrayList();

                        if (flag) {
                            couponListAll = couponService.readCoupon(item);
                            flag = false;
                        }
                        for (Object o1 : rmList) {
                            Object[] pdm = (Object[]) o1;
                            CouponMaster cm = couponService.readById(Integer.parseInt("" + pdm[0]));
                            finalSubsActual.add(cm.getCouponType());
                            if (cm.getCouponPrice().equals(pdm[1])) {
                                finalSubsActual.add(pdm[2]);
                                finalSubsActual.add(0);
                                finalSubsActual.add(0);
                                //tea
                                if (pdm[0].equals("01")) {
                                    teaActual += Double.parseDouble("" + pdm[2]);
                                    tea = tea + 0;
                                    teaSub = 0;
                                }
                                //coffee
                                if (pdm[0].equals("02")) {
                                    coffeeActual += Double.parseDouble("" + pdm[2]);
                                    coffee = coffee + 0;
                                    coffeeSub = 0;
                                }
                                //ws
                                if (pdm[0].equals("03")) {
                                    wetActual += Double.parseDouble("" + pdm[2]);
                                    wet = wet + 0;
                                    wetSub = 0;
                                }
                                //ds
                                if (pdm[0].equals("04")) {
                                    dryActual += Double.parseDouble("" + pdm[2]);
                                    dry = dry + 0;
                                    drySub = 0;
                                }
                                //MEALS
                                if (pdm[0].equals("05")) {
                                    mealActual += Double.parseDouble("" + pdm[2]);
                                    meals = meals + 0;
                                    mealsSub = mealsSub + 0;

                                }
                                //ex1p
                                if (pdm[0].equals("06")) {
                                    ex1pActual += Double.parseDouble("" + pdm[2]);
                                    ex1p = ex1p + 0;
                                    ex1pSub = 0;
                                }
//                            //ex1d
                                if (pdm[0].equals("07")) {
                                    ex1dActual += Double.parseDouble("" + pdm[2]);
                                    ex1d = ex1d + 0;
                                    ex1dSub = 0;
                                }
                                //ex1v
                                if (pdm[0].equals("08")) {
                                    ex1vActual += Double.parseDouble("" + pdm[2]);
                                    ex1v = ex1v + 0;
                                    ex1vSub = 0;
                                }
                                //ex2c
                                if (pdm[0].equals("09")) {
                                    ex2cActual += Double.parseDouble("" + pdm[2]);
                                    ex2c = ex2c + 0;

                                    ex2cSub = 0;
                                }
                                //ex2p
                                if (pdm[0].equals("10")) {
                                    ex2pActual += Double.parseDouble("" + pdm[2]);
                                    ex2p = ex2p + 0;
                                    ex2pSub = 0;
                                }
                                //milk
                                if (pdm[0].equals("11")) {
                                    milkActual += Double.parseDouble("" + pdm[2]);
                                    milk = milk + 0;
                                    milkSub = 0;
                                }
                                //Ag
                                if (pdm[0].equals("12")) {
                                    agActual += Double.parseDouble("" + pdm[2]);
                                    ag = ag + 0;
                                    agSub = 0;
                                }
                                //sc
                                if (pdm[0].equals("13")) {
                                    scActual += Double.parseDouble("" + pdm[2]);
                                    sc = sc + 0;
                                    scSub = 0;
                                }
                                //bm
                                if (pdm[0].equals("14")) {
                                    buttermilkActual += Double.parseDouble("" + pdm[2]);
                                    buttermilk = buttermilk + 0;
                                    buttermilkSub = 0;

                                }
                            } else if (cm.getSecondPrice().equals(pdm[1])) {
                                finalSubsActual.add(0);
                                finalSubsActual.add(pdm[2]);
                                finalSubsActual.add(0);

                                //tea
                                if (pdm[0].equals("01")) {
                                    tea = tea + 0;
                                    teaActual += Double.parseDouble("" + pdm[2]);
                                    teaSub = 0;
                                }
                                //coffee
                                if (pdm[0].equals("02")) {
                                    coffee = coffee + 0;
                                    coffeeActual += Double.parseDouble("" + pdm[2]);
                                    coffeeSub = 0;
                                }
                                //ws
                                if (pdm[0].equals("03")) {
                                    wet = wet + 0;
                                    wetActual += Double.parseDouble("" + pdm[2]);
                                    wetSub = 0;
                                }
                                //ds
                                if (pdm[0].equals("04")) {
                                    dry = dry + 0;
                                    dryActual += Double.parseDouble("" + pdm[2]);
                                    drySub = 0;
                                }
                                //MEALS
                                if (pdm[0].equals("05")) {
                                    meals = meals + 0;
                                    mealActual += Double.parseDouble("" + pdm[2]);
                                    mealsSub = mealsSub + 0;
                                }
                                //ex1p
                                if (pdm[0].equals("06")) {
                                    ex1p = ex1p + 0;
                                    ex1pActual += Double.parseDouble("" + pdm[2]);
                                    ex1pSub = 0;
                                }
//                            //ex1d
                                if (pdm[0].equals("07")) {
                                    ex1d = ex1d + 0;
                                    ex1dActual += Double.parseDouble("" + pdm[2]);
                                    ex1dSub = 0;
                                }
                                //ex1v
                                if (pdm[0].equals("08")) {
                                    ex1v = ex1v + 0;
                                    ex1vActual += Double.parseDouble("" + pdm[2]);
                                    ex1vSub = 0;
                                }
                                //ex2c
                                if (pdm[0].equals("09")) {
                                    ex2c = ex2c + 0;
                                    ex2cActual += Double.parseDouble("" + pdm[2]);
                                    ex2cSub = 0;
                                }
                                //ex2p
                                if (pdm[0].equals("10")) {
                                    ex2p = ex2p + 0;
                                    ex2pActual += Double.parseDouble("" + pdm[2]);
                                    ex2pSub = 0;
                                }
                                //milk
                                if (pdm[0].equals("11")) {
                                    milk = milk + 0;
                                    milkActual += Double.parseDouble("" + pdm[2]);
                                    milkSub = 0;
                                }
                                //Ag
                                if (pdm[0].equals("12")) {
                                    ag = ag + 0;
                                    agActual += Double.parseDouble("" + pdm[2]);
                                    agSub = 0;
                                }
                                //sc
                                if (pdm[0].equals("13")) {
                                    sc = sc + 0;
                                    scActual += Double.parseDouble("" + pdm[2]);
                                    scSub = 0;
                                }
                                //bm
                                if (pdm[0].equals("14")) {
                                    buttermilk = buttermilk + 0;
                                    buttermilkActual += Double.parseDouble("" + pdm[2]);
                                    buttermilkSub = 0;

                                }
                            } else if (cm.getAcPrive().equals(pdm[1])) {
                                finalSubsActual.add(0);
                                finalSubsActual.add(0);
                                finalSubsActual.add(pdm[2]);

                                //tea
                                if (pdm[0].equals("01")) {
                                    tea = tea + 0;
                                    teaSub = 0;
                                    teaActual += Double.parseDouble("" + pdm[2]);
                                }
                                //coffee
                                if (pdm[0].equals("02")) {
                                    coffee = coffee + 0;
                                    coffeeSub = 0;
                                    coffeeActual += Double.parseDouble("" + pdm[2]);
                                }
                                //ws
                                if (pdm[0].equals("03")) {
                                    wet = wet + 0;
                                    wetSub = 0;
                                    wetActual += Double.parseDouble("" + pdm[2]);
                                }
                                //ds
                                if (pdm[0].equals("04")) {
                                    dry = dry + 0;
                                    drySub = 0;
                                    dryActual += Double.parseDouble("" + pdm[2]);
                                }
                                //MEALS
                                if (pdm[0].equals("05")) {
                                    meals = meals + 0;
                                    mealsSub = mealsSub + 0;
                                    mealActual += Double.parseDouble("" + pdm[2]);

                                }
                                //ex1p
                                if (pdm[0].equals("06")) {
                                    ex1p = ex1p + 0;
                                    ex1pSub = 0;
                                    ex1pActual += Double.parseDouble("" + pdm[2]);
                                }
//                            //ex1d
                                if (pdm[0].equals("07")) {
                                    ex1d = ex1d + 0;
                                    ex1dSub = 0;
                                    ex1dActual += Double.parseDouble("" + pdm[2]);
                                }
                                //ex1v
                                if (pdm[0].equals("08")) {
                                    ex1v = ex1v + 0;
                                    ex1vSub = 0;
                                    ex1vActual += Double.parseDouble("" + pdm[2]);
                                }
                                //ex2c
                                if (pdm[0].equals("09")) {
                                    ex2c = ex2c + 0;
                                    ex2cSub = 0;
                                    ex2cActual += Double.parseDouble("" + pdm[2]);
                                }
                                //ex2p
                                if (pdm[0].equals("10")) {
                                    ex2p = ex2p + 0;
                                    ex2pSub = 0;
                                    ex2pActual += Double.parseDouble("" + pdm[2]);
                                }
                                //milk
                                if (pdm[0].equals("11")) {
                                    milk = milk + 0;
                                    milkSub = 0;
                                    milkActual += Double.parseDouble("" + pdm[2]);
                                }
                                //Ag
                                if (pdm[0].equals("12")) {
                                    ag = ag + 0;
                                    agSub = 0;
                                    agActual += Double.parseDouble("" + pdm[2]);
                                }
                                //sc
                                if (pdm[0].equals("13")) {
                                    sc = sc + 0;
                                    scSub = 0;
                                    scActual += Double.parseDouble("" + pdm[2]);
                                }
                                //bm
                                if (pdm[0].equals("14")) {
                                    buttermilk = buttermilk + 0;
                                    buttermilkSub = 0;
                                    buttermilkActual += Double.parseDouble("" + pdm[2]);

                                }
                            }
//                        finalSubsActual.add(pdm[2]);
                            tAmount += (Double.parseDouble("" + pdm[1]) * Double.parseDouble("" + pdm[2]));

                        }
                        if (!rmList.isEmpty()) {
                            
                            if (type1.equals("E"))
                            {
                                finalList.add(finalSubsActual);

                                totalAmount.add(tAmount);
                                totalAmountFinal.add(totalAmount);
                                newAmount = tAmount + newAmount;

                                EmployeeMaster emp = employeeMasterService.readByRfIdValue("" + empcd);

                                personDetails.add(sdf.format(sdate));
                                personDetails.add(empcd);
                                personDetails.add(emp.getName());

                                personDetailsFinal.add(personDetails);
                            }
                            else if (type1.equals("C"))
                            {
                                finalList.add(finalSubsActual);

                                totalAmount.add(tAmount);
                                totalAmountFinal.add(totalAmount);
                                newAmount = tAmount + newAmount;

                                ContractorMaster emp = contractorService.readByRfIdValue("" + empcd);

                                personDetails.add(sdf.format(sdate));
                                personDetails.add(empcd);
                                personDetails.add(emp.getName());

                                personDetailsFinal.add(personDetails);
                            }
                            

                        }
                        String nxtDate = sdf.format(sdate.getTime() + MILLIS_IN_DAY);
                        sdate = sdf.parse(nxtDate);
                    }
                    sdate = sdf.parse(dFrom);

                }
                //------for Log entry---------

                LogsMaster lm = new LogsMaster();
                Date date = new Date();
                lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("Search Day Coupon").setDrow("Y");
                logService.create(lm);
            } else if (type.equals("M")) {

                for (Object o : rmDistinctList1) {
                    
                    empcd = "" + o;
                }
                List rmList = punchedDataService.readBySumValues(sdf.format(sdate), sdf.format(edate), "" + empcd, item);
                Double tAmount = 0.0;

                List personDetails = new ArrayList();
                List totalAmount = new ArrayList();

                List finalSubsActual = new ArrayList();

                if (flag) {
                    couponListAll = couponService.readCoupon(item);
                    flag = false;
                }
                for (Object o1 : rmList) {
                    Object[] pdm = (Object[]) o1;
                    CouponMaster cm = couponService.readById(Integer.parseInt("" + pdm[0]));
                    finalSubsActual.add(cm.getCouponType());
                    if (cm.getCouponPrice().equals(pdm[1])) {
                        finalSubsActual.add(pdm[2]);
                        finalSubsActual.add(0);
                        finalSubsActual.add(0);
                        if (pdm[0].equals("01")) {
                            teaActual += Double.parseDouble("" + pdm[2]);
                            tea = tea + 0;
                            teaSub = 0;
                        }
                        //coffee
                        if (pdm[0].equals("02")) {
                            coffeeActual += Double.parseDouble("" + pdm[2]);
                            coffee = coffee + 0;
                            coffeeSub = 0;
                        }
                        //ws
                        if (pdm[0].equals("03")) {
                            wetActual += Double.parseDouble("" + pdm[2]);
                            wet = wet + 0;
                            wetSub = 0;
                        }
                        //ds
                        if (pdm[0].equals("04")) {
                            dryActual += Double.parseDouble("" + pdm[2]);
                            dry = dry + 0;
                            drySub = 0;
                        }
                        //MEALS
                        if (pdm[0].equals("05")) {
                            mealActual += Double.parseDouble("" + pdm[2]);
                            meals = meals + 0;
                            mealsSub = mealsSub + 0;

                        }
                        //ex1p
                        if (pdm[0].equals("06")) {
                            ex1pActual += Double.parseDouble("" + pdm[2]);
                            ex1p = ex1p + 0;
                            ex1pSub = 0;
                        }
//                            //ex1d
                        if (pdm[0].equals("07")) {
                            ex1dActual += Double.parseDouble("" + pdm[2]);
                            ex1d = ex1d + 0;
                            ex1dSub = 0;
                        }
                        //ex1v
                        if (pdm[0].equals("08")) {
                            ex1vActual += Double.parseDouble("" + pdm[2]);
                            ex1v = ex1v + 0;
                            ex1vSub = 0;
                        }
                        //ex2c
                        if (pdm[0].equals("09")) {
                            ex2cActual += Double.parseDouble("" + pdm[2]);
                            ex2c = ex2c + 0;

                            ex2cSub = 0;
                        }
                        //ex2p
                        if (pdm[0].equals("10")) {
                            ex2pActual += Double.parseDouble("" + pdm[2]);
                            ex2p = ex2p + 0;
                            ex2pSub = 0;
                        }
                        //milk
                        if (pdm[0].equals("11")) {
                            milkActual += Double.parseDouble("" + pdm[2]);
                            milk = milk + 0;
                            milkSub = 0;
                        }
                        //Ag
                        if (pdm[0].equals("12")) {
                            agActual += Double.parseDouble("" + pdm[2]);
                            ag = ag + 0;
                            agSub = 0;
                        }
                        //sc
                        if (pdm[0].equals("13")) {
                            scActual += Double.parseDouble("" + pdm[2]);
                            sc = sc + 0;
                            scSub = 0;
                        }
                        //bm
                        if (pdm[0].equals("14")) {
                            buttermilkActual += Double.parseDouble("" + pdm[2]);
                            buttermilk = buttermilk + 0;
                            buttermilkSub = 0;

                        }
                    } else if (cm.getSecondPrice().equals(pdm[1])) {
                        finalSubsActual.add(0);
                        finalSubsActual.add(pdm[2]);
                        finalSubsActual.add(0);
                        if (pdm[0].equals("01")) {
                            tea = tea + 0;
                            teaActual += Double.parseDouble("" + pdm[2]);
                            teaSub = 0;
                        }
                        //coffee
                        if (pdm[0].equals("02")) {
                            coffee = coffee + 0;
                            coffeeActual += Double.parseDouble("" + pdm[2]);
                            coffeeSub = 0;
                        }
                        //ws
                        if (pdm[0].equals("03")) {
                            wet = wet + 0;
                            wetActual += Double.parseDouble("" + pdm[2]);
                            wetSub = 0;
                        }
                        //ds
                        if (pdm[0].equals("04")) {
                            dry = dry + 0;
                            dryActual += Double.parseDouble("" + pdm[2]);
                            drySub = 0;
                        }
                        //MEALS
                        if (pdm[0].equals("05")) {
                            meals = meals + 0;
                            mealActual += Double.parseDouble("" + pdm[2]);
                            mealsSub = mealsSub + 0;
                        }
                        //ex1p
                        if (pdm[0].equals("06")) {
                            ex1p = ex1p + 0;
                            ex1pActual += Double.parseDouble("" + pdm[2]);
                            ex1pSub = 0;
                        }
//                            //ex1d
                        if (pdm[0].equals("07")) {
                            ex1d = ex1d + 0;
                            ex1dActual += Double.parseDouble("" + pdm[2]);
                            ex1dSub = 0;
                        }
                        //ex1v
                        if (pdm[0].equals("08")) {
                            ex1v = ex1v + 0;
                            ex1vActual += Double.parseDouble("" + pdm[2]);
                            ex1vSub = 0;
                        }
                        //ex2c
                        if (pdm[0].equals("09")) {
                            ex2c = ex2c + 0;
                            ex2cActual += Double.parseDouble("" + pdm[2]);
                            ex2cSub = 0;
                        }
                        //ex2p
                        if (pdm[0].equals("10")) {
                            ex2p = ex2p + 0;
                            ex2pActual += Double.parseDouble("" + pdm[2]);
                            ex2pSub = 0;
                        }
                        //milk
                        if (pdm[0].equals("11")) {
                            milk = milk + 0;
                            milkActual += Double.parseDouble("" + pdm[2]);
                            milkSub = 0;
                        }
                        //Ag
                        if (pdm[0].equals("12")) {
                            ag = ag + 0;
                            agActual += Double.parseDouble("" + pdm[2]);
                            agSub = 0;
                        }
                        //sc
                        if (pdm[0].equals("13")) {
                            sc = sc + 0;
                            scActual += Double.parseDouble("" + pdm[2]);
                            scSub = 0;
                        }
                        //bm
                        if (pdm[0].equals("14")) {
                            buttermilk = buttermilk + 0;
                            buttermilkActual += Double.parseDouble("" + pdm[2]);
                            buttermilkSub = 0;

                        }
                    } else if (cm.getAcPrive().equals(pdm[1])) {
                        finalSubsActual.add(0);
                        finalSubsActual.add(0);
                        finalSubsActual.add(pdm[2]);
                        if (pdm[0].equals("01")) {
                            tea = tea + 0;
                            teaSub = 0;
                            teaActual += Double.parseDouble("" + pdm[2]);
                        }
                        //coffee
                        if (pdm[0].equals("02")) {
                            coffee = coffee + 0;
                            coffeeSub = 0;
                            coffeeActual += Double.parseDouble("" + pdm[2]);
                        }
                        //ws
                        if (pdm[0].equals("03")) {
                            wet = wet + 0;
                            wetSub = 0;
                            wetActual += Double.parseDouble("" + pdm[2]);
                        }
                        //ds
                        if (pdm[0].equals("04")) {
                            dry = dry + 0;
                            drySub = 0;
                            dryActual += Double.parseDouble("" + pdm[2]);
                        }
                        //MEALS
                        if (pdm[0].equals("05")) {
                            meals = meals + 0;
                            mealsSub = mealsSub + 0;
                            mealActual += Double.parseDouble("" + pdm[2]);

                        }
                        //ex1p
                        if (pdm[0].equals("06")) {
                            ex1p = ex1p + 0;
                            ex1pSub = 0;
                            ex1pActual += Double.parseDouble("" + pdm[2]);
                        }
//                            //ex1d
                        if (pdm[0].equals("07")) {
                            ex1d = ex1d + 0;
                            ex1dSub = 0;
                            ex1dActual += Double.parseDouble("" + pdm[2]);
                        }
                        //ex1v
                        if (pdm[0].equals("08")) {
                            ex1v = ex1v + 0;
                            ex1vSub = 0;
                            ex1vActual += Double.parseDouble("" + pdm[2]);
                        }
                        //ex2c
                        if (pdm[0].equals("09")) {
                            ex2c = ex2c + 0;
                            ex2cSub = 0;
                            ex2cActual += Double.parseDouble("" + pdm[2]);
                        }
                        //ex2p
                        if (pdm[0].equals("10")) {
                            ex2p = ex2p + 0;
                            ex2pSub = 0;
                            ex2pActual += Double.parseDouble("" + pdm[2]);
                        }
                        //milk
                        if (pdm[0].equals("11")) {
                            milk = milk + 0;
                            milkSub = 0;
                            milkActual += Double.parseDouble("" + pdm[2]);
                        }
                        //Ag
                        if (pdm[0].equals("12")) {
                            ag = ag + 0;
                            agSub = 0;
                            agActual += Double.parseDouble("" + pdm[2]);
                        }
                        //sc
                        if (pdm[0].equals("13")) {
                            sc = sc + 0;
                            scSub = 0;
                            scActual += Double.parseDouble("" + pdm[2]);
                        }
                        //bm
                        if (pdm[0].equals("14")) {
                            buttermilk = buttermilk + 0;
                            buttermilkSub = 0;
                            buttermilkActual += Double.parseDouble("" + pdm[2]);

                        }

                    }
//                        finalSubsActual.add(pdm[2]);
                    tAmount += (Double.parseDouble("" + pdm[1]) * Double.parseDouble("" + pdm[2]));

                }
                if (!rmList.isEmpty()) {
                    
                    if (type1.equals("E"))
                    {
                        finalList.add(finalSubsActual);

                        totalAmount.add(tAmount);
                        totalAmountFinal.add(totalAmount);
                        newAmount = tAmount + newAmount;
                        EmployeeMaster emp = employeeMasterService.readByRfIdValue("" + empcd);

                        personDetails.add(sdf.format(sdate).split("-")[0] + "-" + sdf.format(sdate).split("-")[1]);
                        personDetails.add(empcd);
                        personDetails.add(emp.getName());

                        personDetailsFinal.add(personDetails);
                    }
                    else if (type1.equals("C"))
                            {
                                finalList.add(finalSubsActual);

                                totalAmount.add(tAmount);
                                totalAmountFinal.add(totalAmount);
                                newAmount = tAmount + newAmount;

                                ContractorMaster emp = contractorService.readByRfIdValue("" + empcd);

                                personDetails.add(sdf.format(sdate));
                                personDetails.add(empcd);
                                personDetails.add(emp.getName());

                                personDetailsFinal.add(personDetails);
                            }
                }

                //------for Log entry---------
                LogsMaster lm = new LogsMaster();
                Date date = new Date();
                lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("Searched Monthly coupon").setDrow("Y");
                logService.create(lm);
            }
        }

        request.setAttribute("dFrom", dFrom);
        request.setAttribute("eFrom", eFrom);
        request.setAttribute("type", type);
        request.setAttribute("cardCode", cardCode);
        request.setAttribute("item", item);
        request.setAttribute("couponList", couponListAll);
        request.setAttribute("personDetailsFinal", personDetailsFinal);
        request.setAttribute("totalAmountFinal", totalAmountFinal);
        request.setAttribute("tea", tea);
        request.setAttribute("teaSub", teaSub);
        request.setAttribute("teaActual", teaActual);
        request.setAttribute("coffee", coffee);
        request.setAttribute("coffeeSub", coffeeSub);
        request.setAttribute("coffeeActual", coffeeActual);
        request.setAttribute("wet", wet);
        request.setAttribute("wetSub", wetSub);
        request.setAttribute("wetActual", wetActual);
        request.setAttribute("dry", dry);
        request.setAttribute("drySub", drySub);
        request.setAttribute("dryActual", dryActual);
        request.setAttribute("meals", meals);
        request.setAttribute("mealsSub", mealsSub);
        request.setAttribute("mealActual", mealActual);
        request.setAttribute("ex1p", ex1p);
        request.setAttribute("ex1pSub", ex1pSub);
        request.setAttribute("ex1pActual", ex1pActual);
        request.setAttribute("ex1d", ex1d);
        request.setAttribute("ex1dSub", ex1dSub);
        request.setAttribute("ex1dActual", ex1dActual);
        request.setAttribute("ex1v", ex1v);
        request.setAttribute("ex1vSub", ex1vSub);
        request.setAttribute("ex1vActual", ex1vActual);
        request.setAttribute("ex2c", ex2c);
        request.setAttribute("ex2cSub", ex2cSub);
        request.setAttribute("ex2cActual", ex2cActual);
        request.setAttribute("ex2p", ex2p);
        request.setAttribute("ex2pSub", ex2pSub);
        request.setAttribute("ex2pActual", ex2pActual);
        request.setAttribute("milk", milk);
        request.setAttribute("milkSub", milkSub);
        request.setAttribute("milkActual", milkActual);
        request.setAttribute("ag", ag);
        request.setAttribute("agSub", agSub);
        request.setAttribute("agActual", agActual);
        request.setAttribute("sc", sc);
        request.setAttribute("scSub", scSub);
        request.setAttribute("scActual", scActual);
        request.setAttribute("buttermilk", buttermilk);
        request.setAttribute("buttermilkSub", buttermilkSub);
        request.setAttribute("buttermilkActual", buttermilkActual);
        request.setAttribute("newAmount", newAmount);
        request.setAttribute("finalList", finalList);
//        request.setAttribute("tAmount", tAmount);
//        if (val.equals("0")) {
        mv.setViewName("Report/DayCouponReport");
//        }
//        else if (val.equals("1")) {
//            mv.setViewName("Report/DayCouponReportEmployee");
//        }
        return mv;

    }

    public ModelAndView showPunchedData(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String date = request.getParameter("date");
        String deviceId = request.getParameter("id");
        String coupounID = request.getParameter("coupounID");
        List list = punchedDataService.readByDateAndDeviceId(date, deviceId, coupounID);
        List empIdNameFinal = new ArrayList();
        for (Object o : list) {
            try {
                List empIdName = new ArrayList();
                PunchedDataMaster pdm = (PunchedDataMaster) o;
                EmployeeMaster em = employeeMasterService.readByRfIdValue(pdm.getEmpCode());
                if (em == null) {
                    ContractorMaster cm = contractorService.readByRfIdValue(pdm.getEmpCode());
                    if (cm != null) {
                        empIdName.add(cm.getRfId());
                        empIdName.add(cm.getName());
                    }
                } else {
                //    empIdName.add(em.getRfId());
                    empIdName.add(em.getName());
                }
                empIdNameFinal.add(empIdName);
            } catch (Exception e) {
                System.err.println("" + e.getMessage());
            }
        }
        //------for Log entry---------
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        LogsMaster lm = new LogsMaster();
        Date date1 = new Date();
        lm.setlDate(dateFormat.format(date1)).setTime(timeFOrmat.format(date1)).setUserName(user.getUserFullName()).setIp(myIp).setAction("Searched Punched Data").setDrow("Y");
        logService.create(lm);
        request.setAttribute("empIdNameFinal", empIdNameFinal);
        mv.setViewName("Report/EmployeePunchedList");
        return mv;
    }

    public ModelAndView showAmountReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        List couponShow = couponService.readAll();
        Map<String, String> map = new HashMap<>();
        for (Object o : couponShow) {
            CouponMaster cm = (CouponMaster) o;
            map.put("" + cm.getSrNo(), cm.getCouponType());
        }
        request.setAttribute("couponMap", map);
        //------for Log entry---------
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        LogsMaster lm = new LogsMaster();
        Date date = new Date();
        lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("Searched Amount report").setDrow("Y");
        logService.create(lm);
        mv.setViewName("Report/ActualAmountReport");
        return mv;
    }

    public ModelAndView searchAmountCoupon(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String dFrom = request.getParameter("startDate");
        String eFrom = request.getParameter("endDate");
        String item = request.getParameter("item");
        Double meals = 0.0;
        Double mealActual = 0.0;
        Double tea = 0.0;
        Double teaActual = 0.0;
        Double wet = 0.0;
        Double wetActual = 0.0;
        Double dry = 0.0;
        Double dryActual = 0.0;
        Double ex1p = 0.0;
        Double ex1pActual = 0.0;
        Double ex1r = 0.0;
        Double ex1rActual = 0.0;
        Double ex1v = 0.0;
        Double ex1vActual = 0.0;
        Double ex2 = 0.0;
        Double ex2Actual = 0.0;
        Double ex2p = 0.0;
        Double ex2pActual = 0.0;
        Double coffee = 0.0;
        Double coffeeActual = 0.0;
        Double newAmount = 0.0;
        Double milk = 0.0;
        Double milkActual = 0.0;
        Double ag = 0.0;
        Double agActual = 0.0;
        Double sc = 0.0;
        Double scActual = 0.0;
        Double Bmilk = 0.0;
        Double BmilkActual = 0.0;

        List couponShow = couponService.readAll();
        Map<String, String> map = new HashMap<>();
        for (Object o : couponShow) {
            CouponMaster cm = (CouponMaster) o;
            map.put("" + cm.getSrNo(), cm.getCouponType());
        }

        List couponListAll = new ArrayList();
        List dateAmountFinalList = new ArrayList();

        List finalList = new ArrayList();

        int MILLIS_IN_DAY = 1000 * 60 * 60 * 24;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date sdate = sdf.parse(dFrom);
        Date edate = sdf.parse(eFrom);

        couponListAll = item.equals("All") ? couponService.readAll() : couponService.readByName(item);

        while (sdate.compareTo(edate) <= 0) {
            List dateAmountList = new ArrayList();
            List pdsList = punchedDataService.readSumOfAmount(sdf.format(sdate), item);
            List totalAmountFinal = new ArrayList();
            Double totalAmount = 0.0;
            for (Object o : pdsList) {
                Object[] o1 = (Object[]) o;
                String cId = (String) o1[0];
                String totalQuantity = (String) o1[1];
                int itemv = Integer.parseInt(cId);
                List list = couponService.readByName("" + itemv);
                CouponMaster cp = (CouponMaster) list.get(0);
                totalAmount += (cp.getAcPrive() * Double.parseDouble(totalQuantity));

                totalAmountFinal.add(itemv);
                totalAmountFinal.add(o1[1]);
                totalAmountFinal.add(o1[2]);
                if (itemv == (1)) {
                    tea = tea + Double.parseDouble(totalQuantity);
                    teaActual = teaActual + (cp.getAcPrive() * Double.parseDouble(totalQuantity));

                }
                if (itemv == (2)) {

                    coffee = coffee + Double.parseDouble(totalQuantity);
                    coffeeActual = coffeeActual + (cp.getAcPrive() * Double.parseDouble(totalQuantity));
                }
                if (itemv == (3)) {
                    wet = wet + Double.parseDouble(totalQuantity);
                    wetActual = wetActual + (cp.getAcPrive() * Double.parseDouble(totalQuantity));
                }
                if (itemv == (4)) {
                    dry = dry + Double.parseDouble(totalQuantity);
                    dryActual = dryActual + (cp.getAcPrive() * Double.parseDouble(totalQuantity));
                }
                if (itemv == (5)) {
                    meals = meals + Double.parseDouble(totalQuantity);
                    mealActual = mealActual + (cp.getAcPrive() * Double.parseDouble(totalQuantity));
                }
                if (itemv == (6)) {
                    ex1p = ex1p + Double.parseDouble(totalQuantity);
                    ex1pActual = ex1pActual + (cp.getAcPrive() * Double.parseDouble(totalQuantity));
                }
                if (itemv == (7)) {
                    ex1r = ex1r + Double.parseDouble(totalQuantity);
                    ex1rActual = ex1rActual + (cp.getAcPrive() * Double.parseDouble(totalQuantity));
                }

                if (itemv == (8)) {
                    ex1v = ex1v + Double.parseDouble(totalQuantity);
                    ex1vActual = ex1vActual + (cp.getAcPrive() * Double.parseDouble(totalQuantity));
                }

                if (itemv == (9)) {
                    ex2 = ex2 + Double.parseDouble(totalQuantity);
                    ex2Actual = ex2Actual + (cp.getAcPrive() * Double.parseDouble(totalQuantity));
                }
                if (itemv == (10)) {
                    ex2p = ex2p + Double.parseDouble(totalQuantity);
                    ex2pActual = ex2pActual + (cp.getAcPrive() * Double.parseDouble(totalQuantity));
                }
                if (itemv == (11)) {
                    milk = milk + Double.parseDouble(totalQuantity);
                    milkActual = milkActual + (cp.getAcPrive() * Double.parseDouble(totalQuantity));
                }
                if (itemv == (12)) {
                    ag = ag + Double.parseDouble(totalQuantity);
                    agActual = agActual + (cp.getAcPrive() * Double.parseDouble(totalQuantity));
                }
                if (itemv == (13)) {
                    sc = sc + Double.parseDouble(totalQuantity);
                    scActual = scActual + (cp.getAcPrive() * Double.parseDouble(totalQuantity));
                }
                if (itemv == (14)) {

                    Bmilk = Bmilk + Double.parseDouble(totalQuantity);
                    BmilkActual = BmilkActual + (cp.getAcPrive() * Double.parseDouble(totalQuantity));
                }
            }
            finalList.add(totalAmountFinal);

            dateAmountList.add(sdf.format(sdate));
            dateAmountList.add(totalAmount);
            dateAmountFinalList.add(dateAmountList);
            String nxtDate = sdf.format(sdate.getTime() + MILLIS_IN_DAY);
            newAmount = newAmount + totalAmount;
            sdate = sdf.parse(nxtDate);
        }

        request.setAttribute(
                "dFrom", dFrom);
        request.setAttribute(
                "eFrom", eFrom);
        request.setAttribute(
                "item", item);

        request.setAttribute("finalList", finalList);
        request.setAttribute("couponListAll", couponListAll);
        request.setAttribute("couponMap", map);
        request.setAttribute("dateAmountFinalList", dateAmountFinalList);
        request.setAttribute("meals", meals);
        request.setAttribute("mealActual", mealActual);
        request.setAttribute("tea", tea);
        request.setAttribute("teaActual", teaActual);
        request.setAttribute("wet", wet);
        request.setAttribute("wetActual", wetActual);
        request.setAttribute("dry", dry);
        request.setAttribute("dryActual", dryActual);
        request.setAttribute("ex1p", ex1p);
        request.setAttribute("ex1pActual", ex1pActual);
        request.setAttribute("ex1r", ex1r);
        request.setAttribute("ex1rActual", ex1rActual);
        request.setAttribute("ex1v", ex1v);
        request.setAttribute("ex1vActual", ex1vActual);
        request.setAttribute("ex2", ex2);
        request.setAttribute("ex2Actual", ex2Actual);
        request.setAttribute("ex2p", ex2p);
        request.setAttribute("ex2pActual", ex2pActual);
        request.setAttribute("coffee", coffee);
        request.setAttribute("coffeeActual", coffeeActual);
        request.setAttribute("newAmount", newAmount);
        request.setAttribute("milk", milk);
        request.setAttribute("milkActual", milkActual);
        request.setAttribute("ag", ag);
        request.setAttribute("agActual", agActual);
        request.setAttribute("sc", sc);
        request.setAttribute("scActual", scActual);
        request.setAttribute("Bmilk", Bmilk);
        request.setAttribute("BmilkActual", BmilkActual);

        //------for Log entry---------
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        LogsMaster lm = new LogsMaster();
        Date date = new Date();
        lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("Search Amount coupon").setDrow("Y");
        logService.create(lm);
        mv.setViewName(
                "Report/ActualAmountReport");
        return mv;

    }

    public ModelAndView showPaymentDeductionReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Report/PaymentDeductionReport");
        return mv;
    }

    public ModelAndView searchPaymentDeductionReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String dFrom = request.getParameter("startDate");
        String eFrom = request.getParameter("endDate");
        String type = request.getParameter("type");
        String name = request.getParameter("name").trim();
        List employeeListFinal = new ArrayList();
        Double totalAmount = 0.0;
        List rmDistinctList = reportService.read(dFrom, eFrom, type, name, "", "");
        for (Object o : rmDistinctList) {
            Object[] reportName = (Object[]) o;
            EmployeeMaster employeeMaster = new EmployeeMaster();
            ContractorMaster contractorMaster = new ContractorMaster();
//            ApprenticesMaster apprenticesMaster = new ApprenticesMaster();
            List list = new ArrayList();
            if (type.equals("E") || type.equals("D") || type.equals("G")) {
                employeeMaster = employeeMasterService.read("" + reportName[1]);
            //    list = punchedDataService.readSumOfPrice(employeeMaster.getRfId(), dFrom, eFrom);
            } else if (type.equals("C")) {
                contractorMaster = contractorService.read("" + reportName[1]);
                list = punchedDataService.readSumOfPrice(contractorMaster.getRfId(), dFrom, eFrom);
            }
//            else if (type.equals("A")) {
//                apprenticesMaster = apprenticesService.read("" + reportName[1]);
//                list = punchedDataService.readSumOfPrice(apprenticesMaster.getRfId(), dFrom, eFrom);
//            }

            if (!list.isEmpty()) {
                List employeeList = new ArrayList();
                for (Object o1 : list) {
                    Object[] os = (Object[]) o1;
                    employeeList.add(reportName[0]);
                    employeeList.add(reportName[1]);
                    employeeList.add(os[1]);
                    if (type.equals("E")) {
                     //   employeeList.add(employeeMaster.getRfId());
                    } else if (type.equals("C")) {
                        employeeList.add(contractorMaster.getRfId());
                    }
//                    else if (type.equals("A")) {
//                        employeeList.add(apprenticesMaster.getRfId());
//                    }
                    totalAmount += Double.parseDouble("" + os[1]);
                    employeeListFinal.add(employeeList);
                }
            }
        }
        //------for Log entry---------
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        LogsMaster lm = new LogsMaster();
        Date date = new Date();
        lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("Searched Payement Deduction report").setDrow("Y");
        logService.create(lm);

        request.setAttribute("dFrom", dFrom);
        request.setAttribute("eFrom", eFrom);
        request.setAttribute("type", type);
        request.setAttribute("name", name);
        request.setAttribute("totalAmount", totalAmount);
        request.setAttribute("employeeListFinal", employeeListFinal);
        mv.setViewName("Report/PaymentDeductionReport");
        return mv;
    }

    public ModelAndView showLastDayReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        List list = contractorService.readContractor();
        request.setAttribute("list", list);
        mv.setViewName("Report/LastDayReport");
        return mv;
    }

    public ModelAndView searchOverTimeReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Report/OverTimeReport");
        return mv;
    }

    public ModelAndView showOverTimeReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String dFrom = request.getParameter("startDate");
        String eFrom = request.getParameter("endDate");
        String type = request.getParameter("type");
        List finalList = new ArrayList();
        List list = punchedDataService.readEmp(dFrom, eFrom, type);
        for (Object o : list) {
            PunchedDataMaster pdm = (PunchedDataMaster) o;
            List list1 = new ArrayList();
            EmployeeMaster employeeMaster = new EmployeeMaster();
            ContractorMaster contractorMaster = new ContractorMaster();
            ApprenticesMaster apprenticesMaster = new ApprenticesMaster();
            List couponList = couponService.readByName(pdm.getItem());
            CouponMaster cm = (CouponMaster) couponList.get(0);
            if (type.equals("E")) {
                employeeMaster = employeeMasterService.readByRfIdValue(pdm.getEmpCode());
                list1.add(employeeMaster.getName());

            } else if (type.equals("C")) {
                contractorMaster = contractorService.readByRfIdValue(pdm.getEmpCode());
                list1.add(contractorMaster.getName());
            } else if (type.equals("A")) {
                apprenticesMaster = apprenticesService.readByRfIdValue(pdm.getEmpCode());
                list1.add(apprenticesMaster.getName());
            }
            list1.add(pdm.getEmpCode());
            list1.add(cm.getCouponType());
            list1.add(pdm.getlDate());
            list1.add(pdm.getlTime());
            finalList.add(list1);

        }

        //------for Log entry---------
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        LogsMaster lm = new LogsMaster();
        Date date = new Date();
        lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("Searched Overtime report").setDrow("Y");
        logService.create(lm);

        request.setAttribute("dFrom", dFrom);
        request.setAttribute("eFrom", eFrom);
        request.setAttribute("type", type);
        request.setAttribute("finalList", finalList);
        mv.setViewName("Report/OverTimeReport");
        return mv;
    }

    public ModelAndView showContracctorBalReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        List empListFinal = new ArrayList();
        List list = contractorService.readContractorLast60Days();
        for (Object o : list) {
            ContractorMaster cm = (ContractorMaster) o;
            List empList = new ArrayList();
            List list1 = rechargeInfoService.readMaxId(cm.getRfId());
            for (Object o1 : list1) {
                Object[] o2 = (Object[]) o1;

                String date = (String) o2[1];
                List list2 = punchedDataService.readPriceSum(cm.getRfId(), date);
                List list3 = rechargeInfoService.readRAmount(cm.getRfId());
                if (!list2.isEmpty() && !list3.isEmpty()) {
                    Object[] o12 = (Object[]) list2.get(0);
                    RechargeInfoMaster rim = (RechargeInfoMaster) list3.get(0);
                    Double value = (Double) o12[1];
                    Double sum = Math.abs(Double.parseDouble(rim.getrAmount()) - value);

                    empList.add(cm.getRfId());
                    empList.add(cm.getName());
                    empList.add(sum);
                    empList.add(cm.getDepartment());

                    empListFinal.add(empList);
                }

            }
        }
        //------for Log entry---------
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        LogsMaster lm = new LogsMaster();
        Date date = new Date();
        lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("Searched Contractor balance report").setDrow("Y");
        logService.create(lm);
        request.setAttribute("list", empListFinal);
        mv.setViewName("Report/ContractorBalanceReport");
        return mv;
    }

    public ModelAndView createBackup(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        File backupFile = new File("d:\\eprocsuite_chargezone_backup.sql");
        File backupFile1 = new File("d:\\");
        if (!backupFile1.exists()) {
            backupFile1.mkdirs();
        }

        FileWriter fw = new FileWriter(backupFile);
        Runtime runtime = Runtime.getRuntime();
//        Process child = runtime.exec("C:\\Program Files\\MySQL\\MySQL Server 5.7\\bin\\mysqldump --user=root --password=root --lock-all-tables --opt eprocsuite_chargezone");
        Process child = runtime.exec("C:\\Program Files (x86)\\MySQL\\MySQL Server 5.5\\bin\\mysqldump.exe --user=root --password=root --lock-all-tables --opt eprocsuite_chargezone");
        InputStreamReader irs = new InputStreamReader(child.getInputStream());
        BufferedReader br = new BufferedReader(irs);

        String line;
        while ((line = br.readLine()) != null) {
            fw.write(line + "\n");
        }
        fw.close();
        irs.close();
        br.close();
        //------for Log entry---------
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        LogsMaster lm = new LogsMaster();
        Date date = new Date();
        lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("Backup created ").setDrow("Y");
        logService.create(lm);
        mv.setViewName("forward:homeController.htm?act=openHomePage");
        return mv;
    }

    public ModelAndView dataDeletionSearch(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("DataDeletion/searchDeletion");
        return mv;
    }

    public ModelAndView dataDeletionsubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String dFrom = request.getParameter("startDate");
        String eFrom = request.getParameter("endDate");

        List<PunchedDataMaster> punchedData = punchedDataService.readByDateDiff(dFrom, eFrom);
//        punchedData.forEach(s -> {

//            punchedDataService.deleteBySrNo(s.getSrNo());
//        });
        punchedDataService.deleteByDate(dFrom, eFrom);
        List<ReportMaster> reportData = reportService.readByDateDiff(dFrom, eFrom);
//        reportData.forEach(s -> {
//            reportService.delteDataByCodeDate(s.getCode(), s.getTdate());
//        });
        reportService.delteDataByDate(dFrom, eFrom);
        //------for Log entry---------
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        LogsMaster lm = new LogsMaster();
        Date date = new Date();
        lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("Delete Punched and Report data ").setDrow("Y");
        logService.create(lm);

        request.setAttribute("successMessage", "Data deleted Sucessfully.");
        mv.setViewName("DataDeletion/searchDeletion");
        return mv;
    }

}
