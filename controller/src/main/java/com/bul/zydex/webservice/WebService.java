/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.webservice;

import com.bul.zydex.model.COffLeaveMaster;
import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.model.EmailTemplate;
import com.bul.zydex.model.EmployeeLeaveBalance;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.HolidayMaster;
import com.bul.zydex.model.LeaveEmployeeDetail;
import com.bul.zydex.model.LeaveTypeMaster;
import com.bul.zydex.model.UserMaster;
import com.bul.zydex.service.holiday.HolidayMasterService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import static com.lowagie.text.pdf.PdfName.T;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Nishant
 */
public class WebService extends WebServiceAbstract {

    public void loginsubmit(HttpServletRequest request,
            HttpServletResponse response) throws JSONException, IOException {
        PrintWriter out = null;
        out = response.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        UserMaster user = new UserMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        String auth = request.getHeader("authorization");
        String Username = "";
        String Password = "";
        if (auth != null && auth.startsWith("Basic")) {
            String base64 = auth.substring("Basic".length()).trim();
            String authDecode = new String(Base64.getDecoder().decode(base64), Charset.forName("UTF-8"));
            String[] values = authDecode.split(":");
            Username = values[0];
            Password = values[1];
        }
        String userid = "";
        String rcode = "";
        String message = "";
        String username = "";
        String userpic = "";
        user.setUserName(Username);
        user.setPassword(Password);
        List<UserMaster> userList = (List<UserMaster>) userMasterService.read(user);

        JSONObject logObj = new JSONObject();
        JSONObject data = new JSONObject();
        if (null == userList || userList.isEmpty()) {
            rcode = "0";
//            resmessage = "Login Fail";";
            message = "Login Fail";

        } else {
            for (UserMaster userDetail : userList) {
                userid = userDetail.getId().toString();
                username = userDetail.getUserName().toString();
            }
            String[] url = request.getRequestURL().toString().split("webService.html");
            String url1 = url[0].toString();
            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "UserProfile"
                    + File.separator + username + File.separator;
            File pictureFile = new File(fileLocationURL);
            if (pictureFile.exists() && pictureFile.listFiles().length > 0) {
                File[] file = pictureFile.listFiles();

                userpic = url1 + "StorageYard/UserProfile/" + username + "/" + file[0].getName();
            } else {
                userpic = url1 + "StorageYard/UserProfile/User/default.png";
            }
            rcode = "1";
            message = "Login Successful";

        }
        data.put("userPic", userpic);
        data.put("userName", username);
        data.put("userId", userid);
        logObj.put("data", data);
        logObj.put("responseMessage", message);
        logObj.put("responseCode", rcode);
        out.print(logObj);
    }

    public void userDetail(HttpServletRequest request,
            HttpServletResponse response) throws JSONException, IOException {
        PrintWriter out = null;
        out = response.getWriter();
        String rcode = "";
        String message = "";
        UserMaster user = new UserMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        JSONObject userData = new JSONObject();
        JSONObject Data = new JSONObject();
        String id = request.getParameter("id");
        int userid = Integer.parseInt(id);
        user.setId(userid);
        employeeMaster.setUserMaster(user);
        List<?> empDetailList = employeeMasterService.readEmployeeDetailUserIdWise(employeeMaster);
        if (!empDetailList.isEmpty()) {

            Object[] arrayOfObject = (Object[]) empDetailList.get(0);
            String empno = (String) arrayOfObject[0];
            String ename = (String) arrayOfObject[1];
            String designation = (String) arrayOfObject[2];
            String level = (String) arrayOfObject[3];
            String department = (String) arrayOfObject[4];
            String worklocation = (String) arrayOfObject[5];
            String reportmanager = (String) arrayOfObject[6];
            String managername = "";
            if (!reportmanager.equals("")) {
                int reportingId = Integer.parseInt(reportmanager);
                employeeMaster1.setId(reportingId);
            }
            List<?> reportmanager1 = employeeMasterService.readByReportManager(employeeMaster1);
            if (!reportmanager1.isEmpty()) {
                employeeMaster1 = (EmployeeMaster) reportmanager1.get(0);
                managername = employeeMaster1.getEmployeeName();
            }

            Data.put("ReportingManager", managername);
            Data.put("WorkLocation", worklocation);
            Data.put("Department", department);
            Data.put("Level", level);
            Data.put("Designation", designation);
            Data.put("EmployeeName", ename);
            Data.put("EmployeeNo", empno);
            rcode = "1";
            message = "Success";
        } else {
            rcode = "0";
            message = "Error";
        }
        userData.put("data", Data);
        userData.put("responseMessage", message);
        userData.put("responseCode", rcode);
        out.print(userData);
    }

    public void leaveDetail(HttpServletRequest request,
            HttpServletResponse response) throws JSONException, IOException {
        PrintWriter out = null;
        out = response.getWriter();
        UserMaster user = new UserMaster();
        String rcode = "";
        String empid = "";
        String message = "";
        String id = request.getParameter("id");
        int userid = Integer.parseInt(id);
        user.setId(userid);
        EmployeeMaster employeeMaster = new EmployeeMaster();
        employeeMaster.setUserMaster(user);
        JSONObject userData = new JSONObject();
        JSONObject data = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        List<EmployeeMaster> empDetailList = (List<EmployeeMaster>) employeeMasterService.readByEmployeeUserId(employeeMaster);
        if (!empDetailList.isEmpty()) {
            EmployeeMaster employeeMaster1 = (EmployeeMaster) empDetailList.get(0);
            EmployeeLeaveBalance employeeLeaveBalance = new EmployeeLeaveBalance();
            employeeLeaveBalance.setEmployeeMaster(employeeMaster1);
            List<?> leaveBalance = employeeLeaveBalanceService.readByEmpId(employeeLeaveBalance);
            if (!leaveBalance.isEmpty()) {

                for (int i = 0; i < leaveBalance.size(); i++) {
                    Object[] arrayOfObject = (Object[]) leaveBalance.get(i);
                    JSONObject obj = new JSONObject();
                    String leavetype = arrayOfObject[0].toString();
                    String leavetypeid = arrayOfObject[2].toString();
                    String allowedleave = arrayOfObject[1].toString();
                    obj.put("leavetypeid", leavetypeid);
                    obj.put("leavetypename", leavetype);
                    obj.put("allowedleavedays", allowedleave);
                    jSONArray.put(obj);
                }
                rcode = "1";
                message = "Success";
                data.put("leavedetail", jSONArray);

            } else {
                rcode = "0";
                message = "Error";
            }
        } else {
            rcode = "0";
            message = "Error";
        }
        userData.put("data", data);
        userData.put("responseMessage", message);
        userData.put("responseCode", rcode);
        out.print(userData);
    }

    public void holidaysList(HttpServletRequest request,
            HttpServletResponse response) throws JSONException, IOException {
        PrintWriter out = null;
        out = response.getWriter();
        String rcode = "";
        String empid = "";
        String message = "";
        UserMaster user = new UserMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        HolidayMaster holidayMaster = new HolidayMaster();
        JSONObject userData = new JSONObject();
        JSONObject data = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        String id = request.getParameter("id");
        int userid = Integer.parseInt(id);
        user.setId(userid);
        employeeMaster.setUserMaster(user);
        String locationid = "";
        List<?> userList = employeeMasterService.readEmpUserIdWise(employeeMaster);
        if (!userList.isEmpty()) {
            locationid = userList.get(0).toString();
            List<?> HolidayList = (List<HolidayMaster>) holidayMasterService.readHolidaysLocationWise(locationid);
            if (!HolidayList.isEmpty()) {

                for (int i = 0; i < HolidayList.size(); i++) {
                    Object[] arrayOfObject = (Object[]) HolidayList.get(i);
                    JSONObject obj = new JSONObject();
                    String title = arrayOfObject[0].toString();
                    String Startdate = arrayOfObject[1].toString();
                    String Enddate = arrayOfObject[2].toString();
                    obj.put("title", title);
                    obj.put("startdate", Startdate);
                    obj.put("enddate", Enddate);
                    jSONArray.put(obj);
                }
                rcode = "1";
                message = "Success";
                data.put("holidaysList", jSONArray);
            } else {
                rcode = "0";
                message = "Error";
            }
        } else {
            rcode = "0";
            message = "Error";
        }
        userData.put("data", data);
        userData.put("responseMessage", message);
        userData.put("responseCode", rcode);
        out.print(userData);
    }

    public void submitLeaveRequest(HttpServletRequest request,
            HttpServletResponse response) throws JSONException, IOException, ServletException, ParseException {
        PrintWriter out = null;
        out = response.getWriter();
        String rcode = "";
        String message = "";
        String empid = "";
        UserMaster user = new UserMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        JSONObject userData = new JSONObject();
        JSONObject data = doPost(request);
        String id = request.getParameter("id");
        int userid = Integer.parseInt(id);
        user.setId(userid);
        employeeMaster.setUserMaster(user);
        List<?> empDetailList = employeeMasterService.readByEmployeeUserId(employeeMaster);
        if (!empDetailList.isEmpty()) {
            employeeMaster1 = (EmployeeMaster) empDetailList.get(0);
        }
        LeaveTypeMaster leaveTypeMaster = new LeaveTypeMaster();
        String leavetypeid = data.get("leaveId").toString();
        leaveTypeMaster.setId(Integer.parseInt(leavetypeid));
        LeaveEmployeeDetail leaveEmployeeDetail = new LeaveEmployeeDetail();
        leaveEmployeeDetail.setEmployeeMaster(employeeMaster1);
        leaveEmployeeDetail.setLeaveTypeMaster(leaveTypeMaster);
        leaveEmployeeDetail.setStartDate(data.get("startDate").toString());
        leaveEmployeeDetail.setEndDate(data.get("endDate").toString());
        leaveEmployeeDetail.setNoOfDays(Float.parseFloat(data.get("noOfDay").toString()));
        leaveEmployeeDetail.setEmpRemark(data.get("remark").toString());
        leaveEmployeeDetail.setStartDateStatus(data.get("startDayType").toString());
        leaveEmployeeDetail.setEndDateStatus(data.get("endDayType").toString());

        Float noOfDay = Float.parseFloat(data.get("noOfDay").toString());
        EmployeeLeaveBalance employeeLeaveBalance = new EmployeeLeaveBalance();
        employeeLeaveBalance.setEmployeeMaster(employeeMaster1);
        employeeLeaveBalance.setLeaveTypeMaster(leaveTypeMaster);
        List<?> emplEaveBal = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance);
        EmployeeLeaveBalance employeeLeaveBalance1 = new EmployeeLeaveBalance();
        boolean balance = false;
        leaveTypeMaster = leaveTypeMasterService.readById(leaveTypeMaster.getId());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date startDate = sdf.parse(leaveEmployeeDetail.getStartDate());
        Date endDate = sdf.parse(leaveEmployeeDetail.getEndDate());
        if (!emplEaveBal.isEmpty()) {
            employeeLeaveBalance1 = (EmployeeLeaveBalance) emplEaveBal.get(0);
            if (!leaveTypeMaster.getLeaveType().contains("Short Leave") && !leaveTypeMaster.getLeaveType().contains("C Off Leave")) {
                if (leaveEmployeeDetail.getNoOfDays().floatValue() > employeeLeaveBalance.getNoOfLeaveRemain()) {
                    balance = true;
                }
            } else {
                balance = true;

            }
        }
        LeaveEmployeeDetail leaveEmployeeDetail1 = new LeaveEmployeeDetail();
        leaveEmployeeDetail1.setEmployeeMaster(employeeMaster1);
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

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/YYYY");
        Calendar cal5 = Calendar.getInstance();
        Date satdate = sdf.parse(leaveEmployeeDetail.getStartDate());
        cal5.setTime(satdate);
        SimpleDateFormat format2 = new SimpleDateFormat("EEEE");
        String dayName = format2.format(satdate);
        int dayOfWeek = cal5.get(Calendar.WEEK_OF_MONTH);
        int locationId = employeeMaster1.getZydexLocationMaster().getId();
        Float balanceDay;
        if (leaveTypeMaster.getLeaveType().contains("Short Leave")) {
            if (dayName.equals("Saturday") && dayOfWeek == 2 && (locationId == 1 || locationId == 6)) {
                rcode = "2";
                message = "On Second Saturday You can Not Apply Short Leave";

            } else if (flag) {
                rcode = "5";
                message = "You Have Already apply Leave On that Day...";

            } else {

                leaveEmployeeDetail.setNoOfDays(Float.parseFloat("1"));
                leaveEmployeeDetailService.create(leaveEmployeeDetail);
                balanceDay = employeeLeaveBalance1.getNoOfLeaveRemain();
                noOfDay = leaveEmployeeDetail.getNoOfDays();
                balanceDay = balanceDay - noOfDay;
                employeeLeaveBalance1.setNoOfLeaveRemain(balanceDay);
                employeeLeaveBalanceService.update(employeeLeaveBalance1);
                rcode = "1";
                message = "Success";
                try {
                    EmailTemplate emailTemplate = new EmailTemplate();
                    DesignationMaster designationMaster = new DesignationMaster();
                    designationMaster = designationMasterService.readById(employeeMaster1.getDesignationMaster().getId());
                    EmployeeMaster employeeMasterHr = new EmployeeMaster();
                    employeeMasterHr = employeeMasterService.readById(Integer.parseInt(employeeMaster1.getReportingManagerLevel1()));
                    // id six is apply status
                    emailTemplate = emailTemplateService.readById(6);
                    String To = employeeMasterHr.getOfficeEmailId();
                    String from = employeeMaster1.getOfficeEmailId();
                    String Subject = emailTemplate.getSubject();
                    Subject = Subject.replaceAll("\\{user\\}", employeeMaster1.getEmployeeName());
                    String msg = emailTemplate.getBodytext();
                    msg = msg.replaceAll("\\{to_user\\}", employeeMasterHr.getEmployeeName());
                    msg = msg.replaceAll("\\{from_user\\}", employeeMaster1.getEmployeeName());
                    msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                    sendMail.sendMail(from, To, Subject, msg);
                } catch (Exception e) {

                }

            }
        } else if (leaveTypeMaster.getLeaveType().contains("C Off Leave")) {
            String noOfHour = "";
            COffLeaveMaster cOffLeaveMaster = new COffLeaveMaster();
            cOffLeaveMaster.setZydexLocationMaster(employeeMaster1.getZydexLocationMaster());
            List list1 = cOffLeaveMasterService.readByDept(cOffLeaveMaster);
            try {
                cOffLeaveMaster = (COffLeaveMaster) list1.get(0);
                noOfHour = "0." + cOffLeaveMaster.getHoursNo();
            } catch (Exception e) {
            }

            if (flag) {
                rcode = "5";
                message = "You Have Already apply Leave On that Day...";

            } else {
                leaveEmployeeDetail.setNoOfDays(Float.parseFloat("1"));
                leaveEmployeeDetailService.create(leaveEmployeeDetail);
                balanceDay = employeeLeaveBalance1.getNoOfLeaveRemain();
                noOfDay = leaveEmployeeDetail.getNoOfDays();
                balanceDay = balanceDay - Float.parseFloat(noOfHour);
                employeeLeaveBalance1.setNoOfLeaveRemain(balanceDay);
                employeeLeaveBalanceService.update(employeeLeaveBalance1);
                rcode = "1";
                message = "Success";

                try {
                    EmailTemplate emailTemplate = new EmailTemplate();
                    DesignationMaster designationMaster = new DesignationMaster();
                    designationMaster = designationMasterService.readById(employeeMaster1.getDesignationMaster().getId());
                    EmployeeMaster employeeMasterHr = new EmployeeMaster();
                    employeeMasterHr = employeeMasterService.readById(Integer.parseInt(employeeMaster1.getReportingManagerLevel1()));
                    // id six is apply status
                    emailTemplate = emailTemplateService.readById(6);
                    String To = employeeMasterHr.getOfficeEmailId();
                    String from = employeeMaster1.getOfficeEmailId();
                    String Subject = emailTemplate.getSubject();
                    Subject = Subject.replaceAll("\\{user\\}", employeeMaster1.getEmployeeName());
                    String msg = emailTemplate.getBodytext();
                    msg = msg.replaceAll("\\{to_user\\}", employeeMasterHr.getEmployeeName());
                    msg = msg.replaceAll("\\{from_user\\}", employeeMaster1.getEmployeeName());
                    msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                    sendMail.sendMail(from, To, Subject, msg);
                } catch (Exception e) {

                }
            }
        } else if (dayName.equals("Saturday") && dayOfWeek == 2 && (locationId == 1 || locationId == 6) && leaveEmployeeDetail.getStartDateStatus().equals("Fullday")) {
            rcode = "3";
            message = "On Second Saturday You can Not Apply Full Day Of Leave";
        } else if (leaveEmployeeDetail.getNoOfDays() > Float.parseFloat(leaveTypeMaster.getMaxDayAllowedLeave()) && !leaveTypeMaster.getLeaveType().contains("Maternity Leave") && !leaveTypeMaster.getLeaveType().contains("C Off Leave")
                && !leaveTypeMaster.getLeaveType().contains("Sick Leave")) {
            rcode = "4";
            message = "No Of Days is Greater than maximum allowed Days...";

        } else if (flag) {
            rcode = "5";
            message = "You Have Already apply Leave On that Day...";

        } else if (leaveTypeMaster.getLeaveType().equals("Paternity Leave")) {

            List list = leaveEmployeeDetailService.readEmployeeWiseMaternity(leaveEmployeeDetail);
            if (employeeMaster1.getMaritalStatus().equals("UnMarried")) {
                rcode = "6";
                message = "UnMarried Employee Should Not Apply Paternity Leave...";
            } else if (employeeMaster1.getGender()) {
                rcode = "7";
                message = "Female Employee Should Not Apply Paternity Leave...";

            } else if (list.size() >= 2) {
                rcode = "8";
                message = "You have Only Apply 2 Time Paternity Leave Days...";

            } else if (balance) {
                rcode = "9";
                message = "No Of Days is Greater than Leave Balance Days...";

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

                rcode = "1";
                message = "Success";
            }
        } else if (!leaveTypeMaster.getLeaveType().contains("Maternity Leave") && !leaveTypeMaster.getLeaveType().contains("Leave Without Pay") && leaveEmployeeDetail.getNoOfDays() > employeeLeaveBalance1.getNoOfLeaveRemain()) {
            rcode = "9";
            message = "No Of Days is Greater than Leave Balance Days...";
        } else if (leaveTypeMaster.getLeaveType().contains("Sick Leave")) {
            String leaveDate = leaveEmployeeDetail.getStartDate();
            Date checkLeaveDate = sdf.parse(leaveDate);
            Date checkLeaveDate2 = new Date();
            if (checkLeaveDate.after(checkLeaveDate2)) {
                rcode = "10";
                message = "Sick Leave Can Not Be Apply In Advance";
            } else {
                leaveEmployeeDetailService.create(leaveEmployeeDetail);
                balanceDay = employeeLeaveBalance1.getNoOfLeaveRemain();
                noOfDay = leaveEmployeeDetail.getNoOfDays();
                balanceDay = balanceDay - noOfDay;
                employeeLeaveBalance1.setNoOfLeaveRemain(balanceDay);
                employeeLeaveBalanceService.update(employeeLeaveBalance1);
                rcode = "1";
                message = "Success";
                try {
                    EmailTemplate emailTemplate = new EmailTemplate();
                    DesignationMaster designationMaster = new DesignationMaster();
                    designationMaster = designationMasterService.readById(employeeMaster1.getDesignationMaster().getId());
                    EmployeeMaster employeeMasterHr = new EmployeeMaster();
                    employeeMasterHr = employeeMasterService.readById(Integer.parseInt(employeeMaster1.getReportingManagerLevel1()));
                    // id six is apply status
                    emailTemplate = emailTemplateService.readById(6);
                    String To = employeeMasterHr.getOfficeEmailId();
                    String from = employeeMaster1.getOfficeEmailId();
                    String Subject = emailTemplate.getSubject();
                    Subject = Subject.replaceAll("\\{user\\}", employeeMaster1.getEmployeeName());
                    String msg = emailTemplate.getBodytext();
                    msg = msg.replaceAll("\\{to_user\\}", employeeMasterHr.getEmployeeName());
                    msg = msg.replaceAll("\\{from_user\\}", employeeMaster1.getEmployeeName());
                    msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                    sendMail.sendMail(from, To, Subject, msg);
                } catch (Exception e) {

                }

            }
        } else {
            leaveEmployeeDetailService.create(leaveEmployeeDetail);
            balanceDay = employeeLeaveBalance1.getNoOfLeaveRemain();
            noOfDay = leaveEmployeeDetail.getNoOfDays();
            balanceDay = balanceDay - noOfDay;
            employeeLeaveBalance1.setNoOfLeaveRemain(balanceDay);
            employeeLeaveBalanceService.update(employeeLeaveBalance1);
            rcode = "1";
            message = "Success";

            //Emailtemplate for submit click .....
            try {
                EmailTemplate emailTemplate = new EmailTemplate();
                DesignationMaster designationMaster = new DesignationMaster();
                designationMaster = designationMasterService.readById(employeeMaster1.getDesignationMaster().getId());
                EmployeeMaster employeeMasterHr = new EmployeeMaster();
                employeeMasterHr = employeeMasterService.readById(Integer.parseInt(employeeMaster1.getReportingManagerLevel1()));
                // id six is apply status
                emailTemplate = emailTemplateService.readById(6);
                String To = employeeMasterHr.getOfficeEmailId();
                String from = employeeMaster1.getOfficeEmailId();
                String Subject = emailTemplate.getSubject();
                Subject = Subject.replaceAll("\\{user\\}", employeeMaster1.getEmployeeName());
                String msg = emailTemplate.getBodytext();
                msg = msg.replaceAll("\\{to_user\\}", employeeMasterHr.getEmployeeName());
                msg = msg.replaceAll("\\{from_user\\}", employeeMaster1.getEmployeeName());
                msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                sendMail.sendMail(from, To, Subject, msg);
            } catch (Exception e) {

            }

        }
        userData.put("responseMessage", message);
        userData.put("responseCode", rcode);
        out.print(userData);

    }

    public void userleaveList(HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException {
        PrintWriter out = null;
        out = response.getWriter();
        String rcode = "";
        String message = "";
        String empid = "";
        UserMaster user = new UserMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        JSONObject userData = new JSONObject();
        JSONObject data = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        String id = request.getParameter("id");
        int userid = Integer.parseInt(id);
        user.setId(userid);
        employeeMaster.setUserMaster(user);
        LeaveEmployeeDetail leaveEmployeeDetail = new LeaveEmployeeDetail();
        List<?> empId = employeeMasterService.readByUserName(employeeMaster);
        if (!empId.isEmpty()) {
            employeeMaster = (EmployeeMaster) empId.get(0);

            leaveEmployeeDetail.setEmployeeMaster(employeeMaster);
            List<?> empLeaveList = leaveEmployeeDetailService.readEmpLeaveListDetail(leaveEmployeeDetail);
            for (int i = 0; i < empLeaveList.size(); i++) {
                Object[] arrayOfObject = (Object[]) empLeaveList.get(i);
                JSONObject obj = new JSONObject();
                String leavetype = arrayOfObject[0].toString();
                String Startdate = arrayOfObject[1].toString();
                String Enddate = arrayOfObject[2].toString();
                String Noofdays = arrayOfObject[3].toString();
                String leaveid = arrayOfObject[4].toString();
                String Status = arrayOfObject[5].toString();
                String empreason = arrayOfObject[6].toString();
                String ApproveName;
                if (null == arrayOfObject[7]) {
                    ApproveName = "";
                } else {
                    ApproveName = arrayOfObject[7].toString();
                }
                String statusmsg = "";

                if (Status.equals("0")) {
                    statusmsg = "Pending";
                }
                if (Status.equals("1")) {
                    statusmsg = "Reworked By " + ApproveName;
                }
                if (Status.equals("2")) {
                    statusmsg = "Rejected By " + ApproveName;
                }
                if (Status.equals("3")) {
                    statusmsg = "Approve By " + ApproveName;

                }
                if (Status.equals("4")) {
                    statusmsg = "WithDraw Request";
                }
                if (Status.equals("5")) {
                    statusmsg = "WithDrawn By " + ApproveName;
                }
                leaveEmployeeDetail = leaveEmployeeDetailService.readById(Integer.parseInt(leaveid));
                String startdatestatus = "";
                String enddatestatus = "";
                if (!leaveEmployeeDetail.equals("")) {
                    startdatestatus = leaveEmployeeDetail.getStartDateStatus().toString();
                    enddatestatus = leaveEmployeeDetail.getEndDateStatus().toString();
                }

                obj.put("leavereason", empreason);
                obj.put("startdatestatus", startdatestatus);
                obj.put("enddatestatus", enddatestatus);
                obj.put("leavetype", leavetype);
                obj.put("startdate", Startdate);
                obj.put("enddate", Enddate);
                obj.put("noofdays", Noofdays);
                obj.put("leaveid", leaveid);
                obj.put("status", Status);
                obj.put("statusmsg", statusmsg);
                obj.put("approveName", ApproveName);
                jSONArray.put(obj);
                rcode = "1";
                message = "Success";
            }
            data.put("UserLeaveList", jSONArray);
        } else {
            rcode = "0";
            message = "Error";
        }
        userData.put("data", data);
        userData.put("responseMessage", message);
        userData.put("responseCode", rcode);
        out.print(userData);
    }

    public void WithDrawLeaveRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException {
        PrintWriter out = null;
        out = response.getWriter();
        String rcode = "";
        String message = "";
        LeaveTypeMaster leaveTypeMaster = new LeaveTypeMaster();
        EmployeeLeaveBalance employeeLeaveBalance = new EmployeeLeaveBalance();
        JSONObject userData = new JSONObject();
        JSONObject data = new JSONObject();
        Float balanceDay;
        Float noOfDay;
        String leaveid = request.getParameter("leaveid");
        LeaveEmployeeDetail leaveEmployeeDetail = new LeaveEmployeeDetail();
        if (null != leaveid && !leaveid.equals("")) {
            leaveEmployeeDetail = leaveEmployeeDetailService.readById(Integer.parseInt(leaveid));
            int empId = leaveEmployeeDetail.getEmployeeMaster().getId();
            EmployeeMaster employeeMaster = employeeMasterService.readById(empId);
            leaveTypeMaster = leaveTypeMasterService.readById(leaveEmployeeDetail.getLeaveTypeMaster().getId());
            leaveEmployeeDetail.getLeaveTypeMaster().getId();
            int status = leaveEmployeeDetail.getStatus();
            if (status == 0) {
                employeeLeaveBalance.setEmployeeMaster(employeeMaster);
                employeeLeaveBalance.setLeaveTypeMaster(leaveTypeMaster);
                List<?> balanceList = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance);
                if (!balanceList.isEmpty()) {
                    employeeLeaveBalance = (EmployeeLeaveBalance) balanceList.get(0);
                }
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
                rcode = "1";
                message = "Success";
            } else if (status == 3) {
                leaveEmployeeDetail.setStatus(4);
                leaveEmployeeDetailService.update(leaveEmployeeDetail);
                rcode = "1";
                message = "Success";
            }
        } else {
            rcode = "0";
            message = "Error";
        }
        userData.put("data", data);
        userData.put("responseMessage", message);
        userData.put("responseCode", rcode);
        out.print(userData);
    }

    public void EditLeaveDetail(HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException, ServletException, ParseException {
        PrintWriter out = null;
        out = response.getWriter();
        String rcode = "";
        String message = "";
        JSONObject userData = new JSONObject();
        JSONObject data = doPost(request);
        JSONObject obj = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        String leaveid = request.getParameter("leaveid");
        EmployeeMaster employeeMaster = new EmployeeMaster();
        LeaveTypeMaster leaveTypeMaster = new LeaveTypeMaster();
        LeaveTypeMaster leaveTypeMaster2 = new LeaveTypeMaster();
        EmployeeLeaveBalance employeeLeaveBalance = new EmployeeLeaveBalance();
        EmployeeLeaveBalance employeeLeaveBalance3 = new EmployeeLeaveBalance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        LeaveEmployeeDetail leaveEmployeeDetail = new LeaveEmployeeDetail();
        leaveEmployeeDetail = leaveEmployeeDetailService.readById(Integer.parseInt(leaveid));
        employeeMaster = employeeMasterService.readById(leaveEmployeeDetail.getEmployeeMaster().getId());
        leaveTypeMaster2 = leaveTypeMasterService.readById(leaveEmployeeDetail.getLeaveTypeMaster().getId());
        Float balanceDay;
        Float TotalbalanceDay;
        Date startDate = new Date();
        Date endDate = new Date();

        employeeLeaveBalance.setEmployeeMaster(employeeMaster);
        employeeLeaveBalance.setLeaveTypeMaster(leaveTypeMaster2);

        LeaveEmployeeDetail leaveEmployeeDetail2 = new LeaveEmployeeDetail();
        leaveEmployeeDetail2.setStartDate(data.get("startDate").toString());
        leaveEmployeeDetail2.setEndDate(data.get("endDate").toString());
        leaveEmployeeDetail2.setEmployeeMaster(employeeMaster);
        boolean flag = false;
        List<LeaveTypeMaster> leaveList = (List<LeaveTypeMaster>) leaveEmployeeDetailService.readDate(leaveEmployeeDetail2);
        if (null == leaveList || leaveList.isEmpty()) {
            flag = false;
        } else {
            flag = true;
        }
        if (flag != true) {
            String leavetypeid = data.get("leaveId").toString();
            leaveTypeMaster = leaveTypeMasterService.readById(Integer.parseInt(leavetypeid));
            leaveEmployeeDetail.setEmployeeMaster(employeeMaster);
            leaveEmployeeDetail.setLeaveTypeMaster(leaveTypeMaster);
            leaveEmployeeDetail.setStartDate(data.get("startDate").toString());
            leaveEmployeeDetail.setEndDate(data.get("endDate").toString());
            leaveEmployeeDetail.setNoOfDays(Float.parseFloat(data.get("noOfDay").toString()));
            leaveEmployeeDetail.setEmpRemark(data.get("remark").toString());
            leaveEmployeeDetail.setStartDateStatus(data.get("startDayType").toString());
            leaveEmployeeDetail.setEndDateStatus(data.get("endDayType").toString());

            Float noOfDay = Float.parseFloat(data.get("noOfDay").toString());
            startDate = sdf.parse(leaveEmployeeDetail.getStartDate());
            endDate = sdf.parse(leaveEmployeeDetail.getEndDate());

            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/YYYY");
            Calendar cal5 = Calendar.getInstance();
            Date satdate = sdf.parse(leaveEmployeeDetail.getStartDate());
            cal5.setTime(satdate);
            SimpleDateFormat format2 = new SimpleDateFormat("EEEE");
            String dayName = format2.format(satdate);
            int dayOfWeek = cal5.get(Calendar.WEEK_OF_MONTH);
            int locationId = employeeMaster.getZydexLocationMaster().getId();
            boolean balance = false;

            leaveTypeMaster = leaveTypeMasterService.readById(leaveTypeMaster.getId());
            List<?> balanceList = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance);
            if (!balanceList.isEmpty()) {
                employeeLeaveBalance3 = (EmployeeLeaveBalance) balanceList.get(0);

                if (!leaveTypeMaster.getLeaveType().contains("Short Leave") && !leaveTypeMaster.getLeaveType().contains("C Off Leave")) {
                    if (leaveEmployeeDetail.getNoOfDays().floatValue() > employeeLeaveBalance3.getNoOfLeaveRemain()) {
                        balance = true;
                    }
                } else {
                    balance = true;

                }
            }

//        boolean flag = false;
//        for (Object leave1 : l1) {
//            leaveEmployeeDetail1 = (LeaveEmployeeDetail) leave1;
//            Date strDate1 = sdf.parse(leaveEmployeeDetail1.getStartDate());
//            Date endDate1 = sdf.parse(leaveEmployeeDetail1.getEndDate());
//            Integer id1 = leaveEmployeeDetail1.getLeaveTypeMaster().getId();
//
//            if (leaveEmployeeDetail1.getStatus() != 5 && (startDate.equals(strDate1) || startDate.after(strDate1) && startDate.before(endDate1) || (endDate.after(strDate1) && endDate.before(endDate1)))) {
//                flag = true;
//                break;
//            } else {
//                flag = false;
//            }
//        }
            if (leaveTypeMaster.getLeaveType().contains("Short Leave")) {
                if (dayName.equals("Saturday") && dayOfWeek == 2 && (locationId == 1 || locationId == 6)) {
                    rcode = "2";
                    message = "On Second Saturday You can Not Apply Short Leave";

                } else if (flag) {
                    rcode = "5";
                    message = "You Have Already apply Leave On that Day...";

                } else {

                    balanceDay = employeeLeaveBalance3.getNoOfLeaveRemain();
                    Float noOfDays = leaveEmployeeDetail.getNoOfDays();
                    TotalbalanceDay = balanceDay + noOfDays;
                    employeeLeaveBalance3.setNoOfLeaveRemain(TotalbalanceDay);
                    employeeLeaveBalanceService.update(employeeLeaveBalance3);

                    leaveEmployeeDetail.setStatus(0);
                    leaveEmployeeDetailService.update(leaveEmployeeDetail);
                    LeaveTypeMaster leaveTypeMaster1 = leaveTypeMasterService.readById(Integer.parseInt(leavetypeid));
                    if (leaveTypeMaster1.getLeaveType().equals("Paternity Leave")) {
                        noOfDay = (float) 3.0;
                    }
                    EmployeeLeaveBalance employeeLeaveBalance1 = new EmployeeLeaveBalance();
                    EmployeeLeaveBalance employeeLeaveBalance2 = new EmployeeLeaveBalance();
                    employeeLeaveBalance1.setEmployeeMaster(employeeMaster);
                    employeeLeaveBalance1.setLeaveTypeMaster(leaveTypeMaster);
                    List<?> balanceCutList = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance1);
                    if (!balanceCutList.isEmpty()) {
                        employeeLeaveBalance2 = (EmployeeLeaveBalance) balanceCutList.get(0);
                    }
                    balanceDay = employeeLeaveBalance2.getNoOfLeaveRemain();
                    noOfDay = leaveEmployeeDetail.getNoOfDays();
                    balanceDay = balanceDay - noOfDay;
                    employeeLeaveBalance2.setNoOfLeaveRemain(balanceDay);
                    employeeLeaveBalanceService.update(employeeLeaveBalance2);
                    rcode = "1";
                    message = "Success";

                }
            } else if (leaveTypeMaster.getLeaveType().contains("C Off Leave")) {
                String noOfHour = "";
                COffLeaveMaster cOffLeaveMaster = new COffLeaveMaster();
                cOffLeaveMaster.setZydexLocationMaster(employeeMaster.getZydexLocationMaster());
                List list1 = cOffLeaveMasterService.readByDept(cOffLeaveMaster);
                try {
                    cOffLeaveMaster = (COffLeaveMaster) list1.get(0);
                    noOfHour = "0." + cOffLeaveMaster.getHoursNo();
                } catch (Exception e) {
                }

                if (flag) {
                    rcode = "5";
                    message = "You Have Already apply Leave On that Day...";

                } else {
                    balanceDay = employeeLeaveBalance3.getNoOfLeaveRemain();
                    Float noOfDays = leaveEmployeeDetail.getNoOfDays();
                    TotalbalanceDay = balanceDay + noOfDays;
                    employeeLeaveBalance3.setNoOfLeaveRemain(TotalbalanceDay);
                    employeeLeaveBalanceService.update(employeeLeaveBalance3);

                    leaveEmployeeDetail.setStatus(0);
                    leaveEmployeeDetailService.update(leaveEmployeeDetail);
                    LeaveTypeMaster leaveTypeMaster1 = leaveTypeMasterService.readById(Integer.parseInt(leavetypeid));
                    if (leaveTypeMaster1.getLeaveType().equals("Paternity Leave")) {
                        noOfDay = (float) 3.0;
                    }
                    EmployeeLeaveBalance employeeLeaveBalance1 = new EmployeeLeaveBalance();
                    EmployeeLeaveBalance employeeLeaveBalance2 = new EmployeeLeaveBalance();
                    employeeLeaveBalance1.setEmployeeMaster(employeeMaster);
                    employeeLeaveBalance1.setLeaveTypeMaster(leaveTypeMaster);
                    List<?> balanceCutList = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance1);
                    if (!balanceCutList.isEmpty()) {
                        employeeLeaveBalance2 = (EmployeeLeaveBalance) balanceCutList.get(0);
                    }
                    balanceDay = employeeLeaveBalance2.getNoOfLeaveRemain();
                    noOfDay = leaveEmployeeDetail.getNoOfDays();
                    balanceDay = balanceDay - noOfDay;
                    employeeLeaveBalance2.setNoOfLeaveRemain(balanceDay);
                    employeeLeaveBalanceService.update(employeeLeaveBalance2);
                    rcode = "1";
                    message = "Success";
                }
            } else if (dayName.equals("Saturday") && dayOfWeek == 2 && (locationId == 1 || locationId == 6) && leaveEmployeeDetail.getStartDateStatus().equals("Fullday")) {
                rcode = "3";
                message = "On Second Saturday You can Not Apply Full Day Of Leave";
            } else if (leaveEmployeeDetail.getNoOfDays() > Float.parseFloat(leaveTypeMaster.getMaxDayAllowedLeave()) && !leaveTypeMaster.getLeaveType().contains("Maternity Leave") && !leaveTypeMaster.getLeaveType().contains("C Off Leave")
                    && !leaveTypeMaster.getLeaveType().contains("Sick Leave")) {
                rcode = "4";
                message = "No Of Days is Greater than maximum allowed Days...";

            } else if (flag) {
                rcode = "5";
                message = "You Have Already apply Leave On that Day...";

            } else if (leaveTypeMaster.getLeaveType().equals("Paternity Leave")) {

                List list = leaveEmployeeDetailService.readEmployeeWiseMaternity(leaveEmployeeDetail);
                if (employeeMaster.getMaritalStatus().equals("UnMarried")) {
                    rcode = "6";
                    message = "UnMarried Employee Should Not Apply Paternity Leave...";
                } else if (employeeMaster.getGender()) {
                    rcode = "7";
                    message = "Female Employee Should Not Apply Paternity Leave...";

                } else if (list.size() >= 2) {
                    rcode = "8";
                    message = "You have Only Apply 2 Time Paternity Leave Days...";

                } else if (balance) {
                    rcode = "9";
                    message = "No Of Days is Greater than Leave Balance Days...";

                } else {
                    balanceDay = employeeLeaveBalance3.getNoOfLeaveRemain();
                    Float noOfDays = leaveEmployeeDetail.getNoOfDays();
                    TotalbalanceDay = balanceDay + noOfDays;
                    employeeLeaveBalance3.setNoOfLeaveRemain(TotalbalanceDay);
                    employeeLeaveBalanceService.update(employeeLeaveBalance3);

                    leaveEmployeeDetail.setStatus(0);
                    leaveEmployeeDetailService.update(leaveEmployeeDetail);
                    LeaveTypeMaster leaveTypeMaster1 = leaveTypeMasterService.readById(Integer.parseInt(leavetypeid));
                    if (leaveTypeMaster1.getLeaveType().equals("Paternity Leave")) {
                        noOfDay = (float) 3.0;
                    }
                    EmployeeLeaveBalance employeeLeaveBalance1 = new EmployeeLeaveBalance();
                    EmployeeLeaveBalance employeeLeaveBalance2 = new EmployeeLeaveBalance();
                    employeeLeaveBalance1.setEmployeeMaster(employeeMaster);
                    employeeLeaveBalance1.setLeaveTypeMaster(leaveTypeMaster);
                    List<?> balanceCutList = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance1);
                    if (!balanceCutList.isEmpty()) {
                        employeeLeaveBalance2 = (EmployeeLeaveBalance) balanceCutList.get(0);
                    }
                    balanceDay = employeeLeaveBalance2.getNoOfLeaveRemain();
                    noOfDay = leaveEmployeeDetail.getNoOfDays();
                    balanceDay = balanceDay - noOfDay;
                    employeeLeaveBalance2.setNoOfLeaveRemain(balanceDay);
                    employeeLeaveBalanceService.update(employeeLeaveBalance2);
                    rcode = "1";
                    message = "Success";
                }
            } else if (!leaveTypeMaster.getLeaveType().contains("Maternity Leave") && !leaveTypeMaster.getLeaveType().contains("Leave Without Pay") && leaveEmployeeDetail.getNoOfDays() > employeeLeaveBalance3.getNoOfLeaveRemain()) {
                rcode = "9";
                message = "No Of Days is Greater than Leave Balance Days...";
            } else if (leaveTypeMaster.getLeaveType().contains("Sick Leave")) {
                String leaveDate = leaveEmployeeDetail.getStartDate();
                Date checkLeaveDate = sdf.parse(leaveDate);
                Date checkLeaveDate2 = new Date();
                if (checkLeaveDate.after(checkLeaveDate2)) {
                    rcode = "10";
                    message = "Sick Leave Can Not Be Apply In Advance";
                } else {
                    balanceDay = employeeLeaveBalance3.getNoOfLeaveRemain();
                    Float noOfDays = leaveEmployeeDetail.getNoOfDays();
                    TotalbalanceDay = balanceDay + noOfDays;
                    employeeLeaveBalance3.setNoOfLeaveRemain(TotalbalanceDay);
                    employeeLeaveBalanceService.update(employeeLeaveBalance3);

                    leaveEmployeeDetail.setStatus(0);
                    leaveEmployeeDetailService.update(leaveEmployeeDetail);
                    LeaveTypeMaster leaveTypeMaster1 = leaveTypeMasterService.readById(Integer.parseInt(leavetypeid));
                    if (leaveTypeMaster1.getLeaveType().equals("Paternity Leave")) {
                        noOfDay = (float) 3.0;
                    }
                    EmployeeLeaveBalance employeeLeaveBalance1 = new EmployeeLeaveBalance();
                    EmployeeLeaveBalance employeeLeaveBalance2 = new EmployeeLeaveBalance();
                    employeeLeaveBalance1.setEmployeeMaster(employeeMaster);
                    employeeLeaveBalance1.setLeaveTypeMaster(leaveTypeMaster);
                    List<?> balanceCutList = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance1);
                    if (!balanceCutList.isEmpty()) {
                        employeeLeaveBalance2 = (EmployeeLeaveBalance) balanceCutList.get(0);
                    }
                    balanceDay = employeeLeaveBalance2.getNoOfLeaveRemain();
                    noOfDay = leaveEmployeeDetail.getNoOfDays();
                    balanceDay = balanceDay - noOfDay;
                    employeeLeaveBalance2.setNoOfLeaveRemain(balanceDay);
                    employeeLeaveBalanceService.update(employeeLeaveBalance2);
                    rcode = "1";
                    message = "Success";

                }
            }
            userData.put("responseMessage", message);
            userData.put("responseCode", rcode);
            out.print(userData);
        } else {
            message = "Already Leave Apply On That Day";
            rcode = "5";
            userData.put("responseMessage", message);
            userData.put("responseCode", rcode);
            out.print(userData);
        }

//     
    }

}
