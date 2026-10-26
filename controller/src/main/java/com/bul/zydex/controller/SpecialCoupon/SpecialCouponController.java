/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.SpecialCoupon;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.ContractorMaster;
import com.bul.zydex.model.CouponMaster;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.LogsMaster;
import com.bul.zydex.model.PunchedDataMaster;
import com.bul.zydex.model.RechargeInfoMaster;
import com.bul.zydex.model.ReportMaster;
import com.bul.zydex.model.SpecialCouponMaster;
import com.bul.zydex.model.SqlDataConnect;
import com.bul.zydex.model.UserMaster;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Aman Bahukhandi
 */
public class SpecialCouponController extends CustomAbstract {

    public ModelAndView showList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        SpecialCouponMaster specialCouponMaster = new SpecialCouponMaster();
        List list = specialCouponService.read();
        request.setAttribute("list", list);
        mv.getModelMap().put("specialCouponMaster", specialCouponMaster);
        mv.setViewName("Coupon/SpecialCouponList");
        return mv;
    }

    public ModelAndView createSpecialCouponMaster(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        SpecialCouponMaster specialCouponMaster = new SpecialCouponMaster();
        readCoupon(request, response);
        readDesignation(request, response);
        mv.getModelMap().put("specialCouponMaster", specialCouponMaster);
        mv.setViewName("Coupon/SpecialCouponCreate");
        return mv;
    }

    public ModelAndView submitSpecialCouponMaster(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        SpecialCouponMaster specialCouponMaster = new SpecialCouponMaster();
        bind(request, specialCouponMaster);
        specialCouponMaster.setdRow("N").setDepartment(" ");
        if (specialCouponMaster.getSrNo() == 0) {
            specialCouponService.create(specialCouponMaster);
            request.setAttribute("successMessage",
                    "Information: Coupon Created successfully");
        } else {
            request.setAttribute("successMessage",
                    "Information: Coupon Updated successfully");
            specialCouponService.update(specialCouponMaster);
        }
        mv = showList(request, response);
        return mv;

    }

    public ModelAndView viewClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        int couponId = Integer.parseInt(request.getParameter("id"));
        SpecialCouponMaster specialCouponMaster = specialCouponService.readById(couponId);
        readCoupon(request, response);
        readDesignation(request, response);
        mv.getModelMap().put("specialCouponMaster", specialCouponMaster);
        mv.setViewName("Coupon/SpecialCouponCreate");
        return mv;
    }

    public ModelAndView deleteSpecialCouponMaster(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String[] checkId = request.getParameterValues("checkId");
        for (String checkedValues : checkId) {
            specialCouponService.delete(Integer.parseInt(checkedValues));
        }
        request.setAttribute("successMessage",
                "Information: One or more Coupon deleted successfully");
        mv = showList(request, response);
        return mv;
    }

    public ModelAndView searchPunch(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PunchedDataMaster pdm = new PunchedDataMaster();
        List list = couponService.read();
        readCoupon(request, response);
        request.setAttribute("list", list);
        mv.getModelMap().put("pdm", pdm);
        mv.setViewName("Coupon/SearchCoupon");
        return mv;
    }

    public ModelAndView searchPunchData(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String dFrom = request.getParameter("startDate");
        String eFrom = request.getParameter("endDate");
        String cardCode = request.getParameter("cardCode");
        String item = request.getParameter("item");

        List pds = punchedDataService.readBy(dFrom, eFrom, cardCode, item);
        readCoupon(request, response);
        request.setAttribute("pds", pds);
        request.setAttribute("dFrom", dFrom);
        request.setAttribute("eFrom", eFrom);
        request.setAttribute("cardCode", cardCode);
        request.setAttribute("item", item);
        mv = searchPunch(request, response);
        return mv;
    }

    public ModelAndView editPunched(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        int id = Integer.parseInt(request.getParameter("id"));
        PunchedDataMaster punchedDataMaster = new PunchedDataMaster();
        List list = punchedDataService.readBYId(id);
        readCoupon(request, response);
        request.setAttribute("punchedDataMaster", punchedDataMaster);
        request.setAttribute("list", list);
        mv.setViewName("Coupon/EditPunch");
        return mv;
    }

    public ModelAndView editPunchedSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        int id = Integer.parseInt(request.getParameter("srNo"));
        double price = Double.parseDouble(request.getParameter("price"));

//        PunchedDataMaster punchedDataMaster = punchedDataService.readById(id);
//        punchedDataMaster.setPrice(price);
        punchedDataService.updateQuery(id, price);
        request.setAttribute("successMessage",
                "Information: Updated successfully");
        mv = searchPunch(request, response);
        return mv;
    }

    public ModelAndView deletePunched(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String[] checkId = request.getParameterValues("checkId");
       String emcode = "";
        String ctype = "";
        Double amount = 0.0;
        Double price = 0.0;
        for (String checkedValues : checkId) {
             int id = Integer.parseInt(checkedValues);
             List l = punchedDataService.readByid(id);
            for (Object o12 : l) {
                Object[] os = (Object[]) o12;
                PunchedDataMaster pn = new PunchedDataMaster();
                pn.setItem((String) os[1]);
                pn.setEmpCode((String) os[2]);
                pn.setlDate((String) os[3]);
                pn.setlTime((String) os[4]);
                pn.setPrice((Double) os[5]);

                String item = pn.getItem();
                String empcode = pn.getEmpCode();
                String pdate = pn.getlDate();
                String ptime = pn.getlTime();
                price = pn.getPrice();

                List empList = employeeMasterService.readByRFid(empcode);
//                List contList = contractorService.readByRFid(empcode);
//                List apprenticesList = apprenticesService.readByRFid(empcode);
                List rechargeList = rechargeInfoService.countAmount(empcode);
                List couponlist = couponService.readByname(item);

                for (Object ob : empList) {
                    Object[] osj = (Object[]) ob;
                    EmployeeMaster em = new EmployeeMaster();
                    em.setEmployeeCode((String) osj[0]);
                    emcode = em.getEmployeeCode();
                }
//                if (emcode.isEmpty()) {
//
//                    for (Object ob1 : contList) {
//                        Object[] con = (Object[]) ob1;
//                        ContractorMaster cnn = new ContractorMaster();
//                        cnn.setContractorCode((String) con[0]);
//                        emcode = cnn.getContractorCode();
//                    }
//                }

//                if (emcode.isEmpty()) {
//                    for (Object ob2 : apprenticesList) {
//                        Object[] app = (Object[]) ob2;
//                        ApprenticesMaster apprenticesMaster = new ApprenticesMaster();
//                        apprenticesMaster.setApprenticeCode((String) app[0]);
//                        emcode = apprenticesMaster.getApprenticeCode();
//                    }
//                }
                for (Object obb : couponlist) {
                    Object[] o = (Object[]) obb;
                    CouponMaster cp = new CouponMaster();
                    cp.setCouponType((String) o[1]);
                    ctype = cp.getCouponType();

                }
                for (Object obf : rechargeList) {
                    Object[] rinfo = (Object[]) obf;
                    RechargeInfoMaster rf = new RechargeInfoMaster();
                    rf.setAmount((String) rinfo[1]);
                    rf.setId((Integer) rinfo[0]);
                    rf.setDate((String) rinfo[3]);
                    rf.setRfId((String) rinfo[2]);
                    amount = (Double.parseDouble(rf.getAmount())) + (price);
                    String newamount = String.valueOf(amount);

                    rf.setAmount(newamount);
                    rf.setrAmount((String) rinfo[4]);

                    rechargeInfoService.update(rf);
                    break;
                }
                List reportList = reportService.readReport(emcode, pdate, ptime, ctype);

                for (Object re : reportList) {
                    Object[] rep = (Object[]) re;
                    ReportMaster reportMaster = new ReportMaster();
                    reportMaster.setNumberOfItem((Integer) rep[4]);
                    int numberitem = reportMaster.getNumberOfItem();
                    if (numberitem > 1) {

                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eprocsuite_chargezone", "root", "root");
//here sonoo is database name, root is username and password  
                        Statement stmt = con.createStatement();
                        int nuberitemupdate = numberitem - 1;

                        String sql = "update report_master set number_item='" + nuberitemupdate + "' where code='" + (String) rep[0] + "' and t_time='" + (String) rep[3] + "' and t_date='" + (String) rep[2] + "' and item='" + (String) rep[1] + "'";
                        stmt.executeUpdate(sql);

                        stmt.close();
                        con.close();

//                        int nuberitemupdate = numberitem - 1;
//                        reportMaster.setNumberOfItem(nuberitemupdate);
//                        reportMaster.setCode((String) rep[0]);
//                        reportMaster.setItem((String) rep[1]);
//                        reportMaster.setTdate((String) rep[2]);
//                        reportMaster.settTime((String) rep[3]);
//                        reportMaster.setId((String) rep[5]);
//                        reportMaster.setDepartment((String) rep[6]);
//                        reportMaster.setDesignation((String) rep[7]);
//                        reportMaster.setName((String) rep[8]);
//                        reportService.update(reportMaster);
                    }
                    if (numberitem == 1) {

//                        reportService.delete(emcode, pdate, ptime, item);
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eprocsuite_chargezone", "root", "root");
//here sonoo is database name, root is username and password  
                        Statement stmt = con.createStatement();
                      

                        String sql = "delete from report_master where code='" + (String) rep[0] + "' and t_time='" + (String) rep[3] + "' and t_date='" + (String) rep[2] + "' and item='" + (String) rep[1] + "'";
                        stmt.executeUpdate(sql);

                        stmt.close();
                        con.close();
                    }
                }
            }
            punchedDataService.deleteBySrNo(checkedValues);
            SqlDataConnect sqlDataConnect = new SqlDataConnect();

            String connectString = "";
            List<?> sqlDataConnectlist = sqlDataConnectService.read();
            System.out.println("<--------------- -1. test ------------->");
            Connection conn = null;
            Statement stmt = null;
            for (Object o : sqlDataConnectlist) {

                sqlDataConnect = (SqlDataConnect) o;
                connectString = sqlDataConnect.getConnectString();

                try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

                    conn = DriverManager.getConnection(connectString);
//                    System.out.println("<--------------- -3. test ------------->");
//                    System.out.println("test");
                    stmt = conn.createStatement();

                    //Insert data into [ItemTrans] table using quantity loop
//                    String quantity = request.getParameter("quantity" + i);
//                    int quantity1 = Integer.parseInt(quantity);
//                    for (int j=0;j<quantity1;j++)
//                    {
                    String sql = "delete from ItemTrans where Transid='" + id + "'";
                    System.out.println(" Query 1 print " + sql);
                    stmt.executeUpdate(sql);
//                    }

                } catch (Exception e) {
                    System.out.println("Error in 1st:" + e.getStackTrace());
                } finally {
                    try {
                        stmt.close();
                        conn.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                }
        }
        request.setAttribute("successMessage",
                "Information: One or more Coupon deleted successfully");
        mv = searchPunch(request, response);
        return mv;
    }
    
    
     public ModelAndView deleteCheck(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String[] checkId = request.getParameterValues("checkId");
        String emcode = "";
        String ctype = "";
        Double amount = 0.0;
        Double price = 0.0;
        for (String checkedValues : checkId) {

            int id = Integer.parseInt(checkedValues);
            List l = punchedDataService.readByid(id);
            for (Object o12 : l) {
                Object[] os = (Object[]) o12;
                PunchedDataMaster pn = new PunchedDataMaster();
                pn.setItem((String) os[1]);
                pn.setEmpCode((String) os[2]);
                pn.setlDate((String) os[3]);
                pn.setlTime((String) os[4]);
                pn.setPrice((Double) os[5]);

                String item = pn.getItem();
                String empcode = pn.getEmpCode();
                String pdate = pn.getlDate();
                String ptime = pn.getlTime();
                price = pn.getPrice();

                List empList = employeeMasterService.readByRFid(empcode);
//                List contList = contractorService.readByRFid(empcode);
//                List apprenticesList = apprenticesService.readByRFid(empcode);
                List rechargeList = rechargeInfoService.countAmount(empcode);
                List couponlist = couponService.readByname(item);

                for (Object ob : empList) {
                    Object[] osj = (Object[]) ob;
                    EmployeeMaster em = new EmployeeMaster();
                    em.setEmployeeCode((String) osj[0]);
                    emcode = em.getEmployeeCode();
                }
//                if (emcode.isEmpty()) {
//
//                    for (Object ob1 : contList) {
//                        Object[] con = (Object[]) ob1;
//                        ContractorMaster cnn = new ContractorMaster();
//                        cnn.setContractorCode((String) con[0]);
//                        emcode = cnn.getContractorCode();
//                    }
//                }

//                if (emcode.isEmpty()) {
//                    for (Object ob2 : apprenticesList) {
//                        Object[] app = (Object[]) ob2;
//                        ApprenticesMaster apprenticesMaster = new ApprenticesMaster();
//                        apprenticesMaster.setApprenticeCode((String) app[0]);
//                        emcode = apprenticesMaster.getApprenticeCode();
//                    }
//                }
                for (Object obb : couponlist) {
                    Object[] o = (Object[]) obb;
                    CouponMaster cp = new CouponMaster();
                    cp.setCouponType((String) o[1]);
                    ctype = cp.getCouponType();

                }
                for (Object obf : rechargeList) {
                    Object[] rinfo = (Object[]) obf;
                    RechargeInfoMaster rf = new RechargeInfoMaster();
                    rf.setAmount((String) rinfo[1]);
                    rf.setId((Integer) rinfo[0]);
                    rf.setDate((String) rinfo[3]);
                    rf.setRfId((String) rinfo[2]);
                    amount = (Double.parseDouble(rf.getAmount())) + (price);
                    String newamount = String.valueOf(amount);

                    rf.setAmount(newamount);
                    rf.setrAmount((String) rinfo[4]);

                    rechargeInfoService.update(rf);
                    break;
                }
                List reportList = reportService.readReport(emcode, pdate, ptime, ctype);

                for (Object re : reportList) {
                    Object[] rep = (Object[]) re;
                    ReportMaster reportMaster = new ReportMaster();
                    reportMaster.setNumberOfItem((Integer) rep[4]);
                    int numberitem = reportMaster.getNumberOfItem();
                    if (numberitem > 1) {

                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eprocsuite_chargezone", "root", "root");
//here sonoo is database name, root is username and password  
                        Statement stmt = con.createStatement();
                        int nuberitemupdate = numberitem - 1;

                        String sql = "update report_master set number_item='" + nuberitemupdate + "' where code='" + (String) rep[0] + "' and t_time='" + (String) rep[3] + "' and t_date='" + (String) rep[2] + "' and item='" + (String) rep[1] + "'";
                        stmt.executeUpdate(sql);

                        stmt.close();
                        con.close();

//                        int nuberitemupdate = numberitem - 1;
//                        reportMaster.setNumberOfItem(nuberitemupdate);
//                        reportMaster.setCode((String) rep[0]);
//                        reportMaster.setItem((String) rep[1]);
//                        reportMaster.setTdate((String) rep[2]);
//                        reportMaster.settTime((String) rep[3]);
//                        reportMaster.setId((String) rep[5]);
//                        reportMaster.setDepartment((String) rep[6]);
//                        reportMaster.setDesignation((String) rep[7]);
//                        reportMaster.setName((String) rep[8]);
//                        reportService.update(reportMaster);
                    }
                    if (numberitem == 1) {

//                        reportService.delete(emcode, pdate, ptime, item);
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eprocsuite_chargezone", "root", "root");
//here sonoo is database name, root is username and password  
                        Statement stmt = con.createStatement();
                      

                        String sql = "delete from report_master where code='" + (String) rep[0] + "' and t_time='" + (String) rep[3] + "' and t_date='" + (String) rep[2] + "' and item='" + (String) rep[1] + "'";
                        stmt.executeUpdate(sql);

                        stmt.close();
                        con.close();
                    }
                }
            }

//          List rmList = reportService.readReport();
            //------for Log entry---------
            HttpSession session = request.getSession(false);
            UserMaster user = (UserMaster) session.getAttribute("user");
            LogsMaster lm = new LogsMaster();
            Date date = new Date();
            lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("Delete edit punched ").setDrow("Y");
            logService.create(lm);
            punchedDataService.deleteBySrNo(checkedValues);

//            int couponTypeCount = Integer.parseInt(request.getParameter("couponTypeCount"));
            SqlDataConnect sqlDataConnect = new SqlDataConnect();

            String connectString = "";
            List<?> sqlDataConnectlist = sqlDataConnectService.read();
            System.out.println("<--------------- -1. test ------------->");
            Connection conn = null;
            Statement stmt = null;
            for (Object o : sqlDataConnectlist) {

                sqlDataConnect = (SqlDataConnect) o;
                connectString = sqlDataConnect.getConnectString();

                try {

                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

                    conn = DriverManager.getConnection(connectString);
//                    System.out.println("<--------------- -3. test ------------->");
//                    System.out.println("test");
                    stmt = conn.createStatement();
                    //Insert data into [ItemTrans] table using quantity loop
//                    String quantity = request.getParameter("quantity" + i);
//                    int quantity1 = Integer.parseInt(quantity);
//                    for (int j=0;j<quantity1;j++)
//                    {
                    String sql = "delete from ItemTrans where TransID=" + id + "";
                    System.out.println(" Query 1 print " + sql);
                    stmt.executeUpdate(sql);
//                    }

                } catch (Exception e) {
                    System.out.println("Error in 1st:" + e.getStackTrace());
                } finally {
                    try {
                        stmt.close();
                        conn.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

        }

        request.setAttribute("successMessage",
                "Information: One or more Coupon deleted successfully");
        mv = searchPunch(request, response);
        return mv;
    }
    

    public ModelAndView addCouponPunch(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView();
        readCoupon(request, response);
        mv.setViewName("Coupon/AddCouponPunch");
        return mv;
    }

//    public ModelAndView submitAddCopounPunch(HttpServletRequest request, HttpServletResponse response) {
//        ModelAndView mv = new ModelAndView();
//        String cardCode = request.getParameter("cardCode");
//        String date = request.getParameter("date");
//        Date date1 = new Date();
//        int couponTypeCount = Integer.parseInt(request.getParameter("couponTypeCount"));
//        for (int i = 1; i <= couponTypeCount; i++) {
//            if (null != request.getParameter("item" + i) && null != request.getParameter("quantity" + i) && null != request.getParameter("price" + i)) {
////                if (!request.getParameter("item1" + i).equals("") && !request.getParameter("quantity" + i).equals("") && !request.getParameter("price" + i).equals("")) {
//                String department = "";
//                String designation = "";
//
//                List list = couponService.readByCoupon(request.getParameter("item" + i));
//                CouponMaster cmaster = (CouponMaster) list.get(0);
//
//                EmployeeMaster em = employeeMasterService.readByRfIdValue(cardCode);
//                if (em == null) {
//                    ContractorMaster cm = contractorService.readByRfIdValue(cardCode);
//                    if (cm != null) {
//                        department = cm.getDepartment();
//
//                        PunchedDataMaster pdm = new PunchedDataMaster();
//                        pdm.setItem("" + (cmaster.getSrNo() < 10 ? "0" + cmaster.getSrNo() : cmaster.getSrNo())).setEmpCode(cm.getRfId())
//                                .setlDate(date).setlTime(timeFOrmat.format(date1)).setQuantity(request.getParameter("quantity" + i)).setDisp(14).setRemark("0")
//                                .setPrice(request.getParameter("price" + i).equals("A") ? cmaster.getCouponPrice() : request.getParameter("price" + i).equals("S1") ? cmaster.getAcPrive() : cmaster.getSecondPrice()).setCid("01");
//                        punchedDataService.create(pdm);
//
//                        ReportMaster rm = new ReportMaster();
//                        rm.setCode(cm.getContractorCode()).setName(cm.getName()).setDesignation(designation).setDepartment(department).setTdate(date).settTime(timeFOrmat.format(date1)).setItem(request.getParameter("item" + i)).setNumberOfItem(Integer.parseInt(request.getParameter("quantity" + i))).setId("C");
//                        reportService.create(rm);
//
//                    } else {
//                        request.setAttribute("failureMessage",
//                                "Information: Employee Code not Found");
//                        mv = addCouponPunch(request, response);
//                        return mv;
//                    }
//                } else {
//                    department = em.getDepartment();
//                    designation = em.getDesignation();
//
////                    
//                    PunchedDataMaster pdm = new PunchedDataMaster();
//                    pdm.setItem("" + (cmaster.getSrNo() < 10 ? "0" + cmaster.getSrNo() : cmaster.getSrNo())).setEmpCode(em.getRfId())
//                            .setlDate(date).setlTime(timeFOrmat.format(date1)).setQuantity(request.getParameter("quantity" + i)).setDisp(14).setRemark("0")
//                            .setPrice(request.getParameter("price" + i).equals("A") ? cmaster.getCouponPrice() : request.getParameter("price" + i).equals("S1") ? cmaster.getAcPrive() : cmaster.getSecondPrice()).setCid("01");
//                    punchedDataService.create(pdm);
//
//                    ReportMaster rm = new ReportMaster();
//                    rm.setCode(em.getEmployeeCode()).setName(em.getName()).setDesignation(designation).setDepartment(department).setTdate(date).settTime(timeFOrmat.format(date1)).setItem(request.getParameter("item" + i)).setNumberOfItem(Integer.parseInt(request.getParameter("quantity" + i))).setId("E");
//                    reportService.create(rm);
//
//                }
//
//            }
////            }
//        }
//        //------for Log entry---------
//        HttpSession session = request.getSession(false);
//        UserMaster user = (UserMaster) session.getAttribute("user");
//        LogsMaster lm = new LogsMaster();
//        lm.setlDate(dateFormat.format(date1)).setTime(timeFOrmat.format(date1)).setUserName(user.getUserFullName()).setIp(myIp).setAction("Add Coupon punch").setDrow("Y");
//        logService.create(lm);
//        request.setAttribute("successMessage",
//                "Information: Data inserted successfully");
//        mv = addCouponPunch(request, response);
//        return mv;
//    }
    public ModelAndView submitAddCopounPunch(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView();
        String cardCode = request.getParameter("cardCode");
        String date = request.getParameter("date");
        Date date1 = new Date();
        int couponTypeCount = Integer.parseInt(request.getParameter("couponTypeCount"));
        for (int i = 1; i <= couponTypeCount; i++) {
            if (null != request.getParameter("item" + i) && null != request.getParameter("quantity" + i)) {
//                if (!request.getParameter("item1" + i).equals("") && !request.getParameter("quantity" + i).equals("") && !request.getParameter("price" + i).equals("")) {
                
                SqlDataConnect sqlDataConnect = new SqlDataConnect();
                
                String connectString = "";
            List<?> sqlDataConnectlist = sqlDataConnectService.read();
            System.out.println("<--------------- -1. test ------------->");
            Connection conn = null;
            Statement stmt = null;
            for (Object o : sqlDataConnectlist) {
                
                sqlDataConnect = (SqlDataConnect) o;
                connectString = sqlDataConnect.getConnectString();
                
                try {
                    System.out.println("<--------------- -2. test ------------->");
                            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	


                    conn = DriverManager.getConnection(connectString);
                    System.out.println("<--------------- -3. test ------------->");
                    System.out.println("test");
                    stmt = conn.createStatement();
                    
                    //Retrive Employee Name , and card code from emp table using cardCode
                    String Sql = "select cardid,empname from emp where empid='"+cardCode+"'";
                    
                    String cardid="";
                    String empid="";
                    ResultSet rs = stmt.executeQuery(Sql);
                    while (rs.next()) {
			cardid=rs.getString(1);
                        empid=rs.getString(2);
                    }
                    
                    //Retrive item code from ItemMaster
                    String item1 = request.getParameter("item" + i);
                    String Sql1 = "select ItemID from ItemMaster where ItemName='"+item1+"'";
                    ResultSet rs1 = stmt.executeQuery(Sql1);
                    String itemcode="";
                    while (rs1.next()) {
			itemcode=rs1.getString(1);
                    }
                    
                    //Insert data into [ItemTrans] table using quantity loop
                    String quantity = request.getParameter("quantity" + i);
                    int quantity1 = Integer.parseInt(quantity);
                    for (int j=0;j<quantity1;j++)
                    {
                        String sql = "insert into ItemTrans (ItemID,CmpCode ,EmpID ,TrDate ,Qty ,Price ,DataSource ,location ,Cid ,ItemName ,EmpName ,SubSidy ,VCode ,VDesc ,Cardid ,Flag) values ('"+itemcode+"','Gipcl' ,'"+cardCode+"' ,'"+date+"' ,'1' ,'0' ,'0' ,'BRD' ,'01' ,'"+item1+"' ,'"+empid+"' ,'0' ,'00' ,'Default Vendor' ,'"+cardid+"' ,'E')  ";
                        System.out.println(" Query 1 print " + sql);
                        stmt.executeUpdate(sql);
                    }
                    
                }
                catch (Exception e) {
                    System.out.println("Error in 1st:" + e.getStackTrace());
                } finally {
                    try {
                        stmt.close();
                        conn.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
                String department = "";
                String designation = "";
/*
                EmployeeMaster em = employeeMasterService.readByRfIdValue(cardCode);
                if (em == null) {
                    ContractorMaster cm = contractorService.readByRfIdValue(cardCode);
                    if (cm != null) {
                        List list = couponService.readByShiftType(cm.getShiftType(), request.getParameter("item" + i));
                        CouponMaster cmaster = (CouponMaster) list.get(0);

                        department = cm.getDepartment();

                        PunchedDataMaster pdm = new PunchedDataMaster();
                        pdm.setItem("" + (cmaster.getSrNo() < 10 ? "0" + cmaster.getSrNo() : cmaster.getSrNo())).setEmpCode(cm.getRfId())
                                .setlDate(date).setlTime(timeFOrmat.format(date1)).setQuantity(request.getParameter("quantity" + i)).setDisp(1)
                                .setPrice(request.getParameter("price" + i).equals("A") ? cmaster.getCouponPrice() : cmaster.getAcPrive()).setCid("01");
                        punchedDataService.create(pdm);

                        ReportMaster rm = new ReportMaster();
                        rm.setCode(cm.getContractorCode()).setName(cm.getName()).setDesignation(designation).setDepartment(department).setTdate(date).settTime(timeFOrmat.format(date1)).setItem(request.getParameter("item" + i)).setNumberOfItem(Integer.parseInt(request.getParameter("quantity" + i))).setId("C");
                        reportService.create(rm);

                    } else {
                        ApprenticesMaster am = apprenticesService.readByRfIdValue(cardCode);
                        if (am != null) {
                            List list = couponService.readByShiftType(am.getShiftType(), request.getParameter("item" + i));
                            CouponMaster cmaster = (CouponMaster) list.get(0);

                            PunchedDataMaster pdm = new PunchedDataMaster();
                            pdm.setItem("" + (cmaster.getSrNo() < 10 ? "0" + cmaster.getSrNo() : cmaster.getSrNo())).setEmpCode(am.getRfId())
                                    .setlDate(date).setlTime(timeFOrmat.format(date1)).setQuantity(request.getParameter("quantity" + i)).setDisp(1)
                                    .setPrice(request.getParameter("price" + i).equals("A") ? cmaster.getCouponPrice() : cmaster.getAcPrive()).setCid("01");
                            punchedDataService.create(pdm);

                            ReportMaster rm = new ReportMaster();
                            rm.setCode(am.getApprenticeCode()).setName(am.getName()).setDesignation(designation).setDepartment(department).setTdate(date).settTime(timeFOrmat.format(date1)).setItem(request.getParameter("item" + i)).setNumberOfItem(Integer.parseInt(request.getParameter("quantity" + i))).setId("A");
                            reportService.create(rm);

                        } else {
                            request.setAttribute("failureMessage",
                                    "Information: Employee Code not Found");
                            mv = addCouponPunch(request, response);
                            return mv;

                        }
                    }
                } else {
                    List list = couponService.readByShiftType(em.getShiftType(), request.getParameter("item" + i));
                    CouponMaster cmaster = (CouponMaster) list.get(0);

                    department = em.getDepartment();
                    designation = em.getDesignation();

//                    
                    PunchedDataMaster pdm = new PunchedDataMaster();
                    pdm.setItem("" + (cmaster.getSrNo() < 10 ? "0" + cmaster.getSrNo() : cmaster.getSrNo())).setEmpCode(em.getRfId())
                            .setlDate(date).setlTime(timeFOrmat.format(date1)).setQuantity(request.getParameter("quantity" + i)).setDisp(1)
                            .setPrice(request.getParameter("price" + i).equals("A") ? cmaster.getCouponPrice() : cmaster.getAcPrive()).setCid("01");
                    punchedDataService.create(pdm);

                    ReportMaster rm = new ReportMaster();
                    rm.setCode(em.getEmployeeCode()).setName(em.getName()).setDesignation(designation).setDepartment(department).setTdate(date).settTime(timeFOrmat.format(date1)).setItem(request.getParameter("item" + i)).setNumberOfItem(Integer.parseInt(request.getParameter("quantity" + i))).setId("E");
                    reportService.create(rm);

                }
                */

            }
//            }
        }

        //------for Log entry---------
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        LogsMaster lm = new LogsMaster();
        lm.setlDate(dateFormat.format(date1)).setTime(timeFOrmat.format(date1)).setUserName(user.getUserFullName()).setIp(myIp).setAction("Add Coupon punch").setDrow("Y");
        logService.create(lm);

        request.setAttribute("successMessage",
                "Information: Data inserted successfully");
        mv = addCouponPunch(request, response);
        return mv;
    }

}
