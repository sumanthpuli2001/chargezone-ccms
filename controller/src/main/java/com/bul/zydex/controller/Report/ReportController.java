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

    public ModelAndView searchDayCoupon(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String dFrom = request.getParameter("startDate");
        String eFrom = request.getParameter("endDate");
        String type = request.getParameter("type");
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
        List rmDistinctList = punchedDataService.readDistinct(dFrom, eFrom, cardCode, item);
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
                        } else if (cm.getSecondPrice().equals(pdm[1])) {
                            finalSubsActual.add(0);
                            finalSubsActual.add(pdm[2]);
                            finalSubsActual.add(0);
                        } else if (cm.getAcPrive().equals(pdm[1])) {
                            finalSubsActual.add(0);
                            finalSubsActual.add(0);
                            finalSubsActual.add(pdm[2]);
                        }
//                        finalSubsActual.add(pdm[2]);
                        tAmount += (Double.parseDouble("" + pdm[1]) * Double.parseDouble("" + pdm[2]));

                    }
                    if (!rmList.isEmpty()) {
                        finalList.add(finalSubsActual);

                        totalAmount.add(tAmount);
                        totalAmountFinal.add(totalAmount);

                        EmployeeMaster emp = employeeMasterService.readByRfIdValue("" + o);

                        personDetails.add(sdf.format(sdate));
                        personDetails.add(o);
                        personDetails.add(emp.getName());

                        personDetailsFinal.add(personDetails);

                    }
                    String nxtDate = sdf.format(sdate.getTime() + MILLIS_IN_DAY);
                    sdate = sdf.parse(nxtDate);
                }
                sdate = sdf.parse(dFrom);

            }
            //------for Log entry---------
            HttpSession session = request.getSession(false);
            UserMaster user = (UserMaster) session.getAttribute("user");
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
                    } else if (cm.getSecondPrice().equals(pdm[1])) {
                        finalSubsActual.add(0);
                        finalSubsActual.add(pdm[2]);
                        finalSubsActual.add(0);
                    } else if (cm.getAcPrive().equals(pdm[1])) {
                        finalSubsActual.add(0);
                        finalSubsActual.add(0);
                        finalSubsActual.add(pdm[2]);
                    }
//                        finalSubsActual.add(pdm[2]);
                    tAmount += (Double.parseDouble("" + pdm[1]) * Double.parseDouble("" + pdm[2]));

                }
                if (!rmList.isEmpty()) {
                    finalList.add(finalSubsActual);

                    totalAmount.add(tAmount);
                    totalAmountFinal.add(totalAmount);

                    EmployeeMaster emp = employeeMasterService.readByRfIdValue("" + o);

                    personDetails.add(sdf.format(sdate).split("-")[0] + "-" + sdf.format(sdate).split("-")[1]);
                    personDetails.add(o);
                    personDetails.add(emp.getName());

                    personDetailsFinal.add(personDetails);

                }

            }
            //------for Log entry---------
            HttpSession session = request.getSession(false);
            UserMaster user = (UserMaster) session.getAttribute("user");
            LogsMaster lm = new LogsMaster();
            Date date = new Date();
            lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("Searched Monthly coupon").setDrow("Y");
            logService.create(lm);
        }

        request.setAttribute("dFrom", dFrom);
        request.setAttribute("eFrom", eFrom);
        request.setAttribute("type", type);
        request.setAttribute("cardCode", cardCode);
        request.setAttribute("item", item);

        request.setAttribute("couponList", couponListAll);
        request.setAttribute("personDetailsFinal", personDetailsFinal);
        request.setAttribute("totalAmountFinal", totalAmountFinal);

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
                    empIdName.add(em.getRfId());
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
            }
            finalList.add(totalAmountFinal);

            dateAmountList.add(sdf.format(sdate));
            dateAmountList.add(totalAmount);
            dateAmountFinalList.add(dateAmountList);
            String nxtDate = sdf.format(sdate.getTime() + MILLIS_IN_DAY);
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
                list = punchedDataService.readSumOfPrice(employeeMaster.getRfId(), dFrom, eFrom);
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
                        employeeList.add(employeeMaster.getRfId());
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
        File backupFile = new File("d:\\ccms_backup.sql");
        File backupFile1 = new File("d:\\");
        if (!backupFile1.exists()) {
            backupFile1.mkdirs();
        }

        FileWriter fw = new FileWriter(backupFile);
        Runtime runtime = Runtime.getRuntime();
        Process child = runtime.exec("C:\\Program Files\\MySQL\\MySQL Server 5.7\\bin\\mysqldump --user=root --password=root --lock-all-tables --opt ccms");

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
        punchedData.forEach(s -> {

            punchedDataService.deleteBySrNo(s.getSrNo());
        });

        List<ReportMaster> reportData = reportService.readByDateDiff(dFrom, eFrom);
        reportData.forEach(s -> {
            reportService.delteDataByCodeDate(s.getCode(), s.getTdate());
        });

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
