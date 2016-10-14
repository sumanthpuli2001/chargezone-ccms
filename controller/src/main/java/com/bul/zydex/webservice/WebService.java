/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.webservice;

import com.bul.zydex.model.COffLeaveMaster;
import com.bul.zydex.model.DepartmentMaster;
import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.model.EmailTemplate;
import com.bul.zydex.model.EmployeeLeaveBalance;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.ExpenseMaster;
import com.bul.zydex.model.HolidayMaster;
import com.bul.zydex.model.HrServiceRequest;
import com.bul.zydex.model.ItServiceRequest;
import com.bul.zydex.model.LeaveEmployeeDetail;
import com.bul.zydex.model.LeaveTypeMaster;
import com.bul.zydex.model.LevelMaster;
import com.bul.zydex.model.LocationMaster;
import com.bul.zydex.model.TravelRequestMaster;
import com.bul.zydex.model.UserMaster;
import com.bul.zydex.model.ZydexLocationMaster;
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
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.crypto.ExemptionMechanismException;
import javax.mail.MessagingException;
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
            HttpServletResponse response) throws JSONException, IOException, ServletException, ServletException, ServletException {
        PrintWriter out = null;
        out = response.getWriter();
        String rcode = "";
        String message = "";
        JSONObject logObj = new JSONObject();
        JSONObject data = new JSONObject();
        try {
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
            String username = "";
            String employeeName = "";
            String userpic = "";
            user.setUserName(Username);
            user.setPassword(Password);
            List<UserMaster> userList = (List<UserMaster>) userMasterService.read(user);

            if (null == userList || userList.isEmpty()) {
                rcode = "0";
//            resmessage = "Login Fail";";
                message = "Login Fail";

            } else {
                for (UserMaster userDetail : userList) {
                    userid = userDetail.getId().toString();
                    username = userDetail.getUserName().toString();

                    employeeMaster.setUserMaster(userDetail);
                    List<?> empDetailList = employeeMasterService.readByEmployeeUserId(employeeMaster);
                    if (!empDetailList.isEmpty()) {
                        EmployeeMaster employeeMaster1 = (EmployeeMaster) empDetailList.get(0);
                        employeeName = employeeMaster1.getEmployeeName();
                    }

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
            data.put("employeeName", employeeName);
            data.put("userId", userid);
            logObj.put("data", data);
            logObj.put("responseMessage", message);
            logObj.put("responseCode", rcode);
            out.print(logObj);
        } catch (Exception exception) {
            rcode = "0";
            message = "Error";
            logObj.put("data", data);
            logObj.put("responseMessage", message);
            logObj.put("responseCode", rcode);
            out.print(logObj);

        }
    }

    public void changePassword(HttpServletRequest request,
            HttpServletResponse response) throws JSONException, IOException, ServletException {
        PrintWriter out = null;
        out = response.getWriter();
        String rcode = "";
        String message = "";
        JSONObject logObj = new JSONObject();
        JSONObject data = doPost(request);
        try {
            UserMaster user = new UserMaster();
            String id = request.getParameter("id");
            int userid = Integer.parseInt(id);
            user.setId(userid);
            UserMaster userMaster = userMasterService.readById(userid);
            String curPas = data.get("curPass").toString();
            String newPas = data.get("newPass").toString();
            List list = employeeMasterService.pswdExist(curPas, id);
            if (!list.isEmpty()) {
                userMaster.setPassword(newPas);
                userMasterService.createOrUpdate(userMaster);
                message = "Password Changed Successfully";
                rcode = "1";

            } else {
                message = " Enter Password Does Not Exist ";
                rcode = "2";

            }
        } catch (Exception exception) {
            message = "Error";
            rcode = "0";
        }
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
        JSONObject userData = new JSONObject();
        JSONObject Data = new JSONObject();
        try {
            UserMaster user = new UserMaster();

            EmployeeMaster employeeMaster = new EmployeeMaster();
            EmployeeMaster employeeMaster1 = new EmployeeMaster();
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
                message = "No detail Found";
            }
            userData.put("data", Data);
            userData.put("responseMessage", message);
            userData.put("responseCode", rcode);
            out.print(userData);
        } catch (Exception exception) {
            rcode = "0";
            message = "Error";
            userData.put("data", Data);
            userData.put("responseMessage", message);
            userData.put("responseCode", rcode);
            out.print(userData);
        }
    }

    public void userProfile(HttpServletRequest request,
            HttpServletResponse response) throws JSONException, IOException {
        PrintWriter out = null;
        out = response.getWriter();
        String rcode = "";
        String message = "";
        JSONObject userData = new JSONObject();
        JSONObject Data = new JSONObject();
        try {
            UserMaster user = new UserMaster();

            EmployeeMaster employeeMaster = new EmployeeMaster();
            EmployeeMaster employeeMaster1 = new EmployeeMaster();
            String id = request.getParameter("id");
            int userid = Integer.parseInt(id);
            user.setId(userid);
            employeeMaster.setUserMaster(user);
            UserMaster userMaster = userMasterService.readById(userid);
            List<?> empDetailList = employeeMasterService.readByEmployeeUserId(employeeMaster);
            if (!empDetailList.isEmpty()) {
                employeeMaster1 = (EmployeeMaster) empDetailList.get(0);

                int desid = employeeMaster1.getDesignationMaster().getId();
                DesignationMaster designationMaster = designationMasterService.readById(desid);
                String designation = designationMaster.getDesignationName();

                String company = employeeMaster1.getCompany();
                String bloodGroups = employeeMaster1.getBloodGroups();
                String dateOfBirth = employeeMaster1.getDateOfBirth();
                String presentAddress = employeeMaster1.getPresentAddress();
                String contactNo1 = employeeMaster1.getContactNo1();
                String emailid = employeeMaster1.getOfficeEmailId();
                String maritalStatus = employeeMaster1.getMaritalStatus();

                Boolean gendervalue = employeeMaster1.getGender();
                String gender = "";
                if (gendervalue == false) {
                    gender = "Male";
                } else {
                    gender = "Female";
                }

                String companyName = employeeMaster.getCompany();
                int zydexlocid = employeeMaster1.getZydexLocationMaster().getId();
                ZydexLocationMaster zydexLocationMaster = zydexLocationMasterService.readById(zydexlocid);

                String zydexLocation = zydexLocationMaster.getZydexLocation();

                int locid = employeeMaster1.getLocationMaster().getId();
                LocationMaster locationMaster = locationMasterService.readById(locid);
                String workLocation = locationMaster.getLocation();

                int employeelevelid = employeeMaster1.getLevelMaster().getId();
                LevelMaster levelMaster = levelMasterService.readById(employeelevelid);
                String employeelevel = levelMaster.getLevel();

                int deptid = employeeMaster1.getDepartmentMaster().getId();
                DepartmentMaster departmentMaster = departmentMasterService.readById(deptid);
                String department = departmentMaster.getDepartmentName();

                String dateOfjoin = employeeMaster1.getDateOfJoining();
                String employeeType = employeeMaster1.getEmployeeType();

                String reportingId = employeeMaster1.getReportingManagerLevel1();
                EmployeeMaster employeeMaster2 = employeeMasterService.readById(Integer.parseInt(reportingId));
                String reportingManager = employeeMaster2.getEmployeeName();
                String reportingManagerId = employeeMaster2.getEmployeeId();

                String username = userMaster.getUserName();
                String userpic = "";

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

                Data.put("employeeName", employeeMaster1.getEmployeeName());
                Data.put("employeeId", employeeMaster1.getEmployeeId());
                Data.put("employeePic", userpic);
                Data.put("designation", designation);
                Data.put("company", company);
                Data.put("bloodGroups", bloodGroups);
                Data.put("dateOfBirth", dateOfBirth);
                Data.put("address", presentAddress);
                Data.put("mobileNum", contactNo1);
                Data.put("emailid", emailid);
                Data.put("maritalStatus", maritalStatus);
                Data.put("gender", gender);
                Data.put("companyName", companyName);
                Data.put("zydexLocation", zydexLocation);
                Data.put("workLocation", workLocation);
                Data.put("level", employeelevel);
                Data.put("department", department);
                Data.put("dateOfjoin", dateOfjoin);
                Data.put("employeeType", employeeType);
                Data.put("reportingManager", reportingManager);
                Data.put("reportingManagerId", reportingManagerId);
                rcode = "1";
                message = "Success";
            } else {
                rcode = "2";
                message = "No Record Found";
            }
        } catch (Exception exception) {
            rcode = "0";
            message = "Something Wrong";
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
        JSONObject userData = new JSONObject();
        JSONObject data = new JSONObject();
        try {
            String id = request.getParameter("id");
            int userid = Integer.parseInt(id);
            user.setId(userid);
            EmployeeMaster employeeMaster = new EmployeeMaster();
            employeeMaster.setUserMaster(user);
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
                }
            } else {
                rcode = "0";
                message = "Error";
            }
            userData.put("data", data);
            userData.put("responseMessage", message);
            userData.put("responseCode", rcode);
            out.print(userData);
        } catch (Exception exception) {
            rcode = "0";
            message = "Error";
            userData.put("data", data);
            userData.put("responseMessage", message);
            userData.put("responseCode", rcode);
            out.print(userData);
        }
    }

    public void holidaysList(HttpServletRequest request,
            HttpServletResponse response) throws JSONException, IOException {
        PrintWriter out = null;
        out = response.getWriter();

        String rcode = "";
        String empid = "";
        String message = "";
        JSONObject userData = new JSONObject();
        JSONObject data = new JSONObject();
        try {
            UserMaster user = new UserMaster();
            EmployeeMaster employeeMaster = new EmployeeMaster();
            EmployeeMaster employeeMaster1 = new EmployeeMaster();
            HolidayMaster holidayMaster = new HolidayMaster();
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
        } catch (Exception exception) {
            rcode = "0";
            message = "Error";
            userData.put("data", data);
            userData.put("responseMessage", message);
            userData.put("responseCode", rcode);
            out.print(userData);
        }
    }

    public void submitLeaveRequest(HttpServletRequest request,
            HttpServletResponse response) throws JSONException, IOException, ServletException, ParseException {
        PrintWriter out = null;
        out = response.getWriter();
        String rcode = "";
        String message = "";
        String empid = "";
        JSONObject userData = new JSONObject();
        try {
            UserMaster user = new UserMaster();
            EmployeeMaster employeeMaster = new EmployeeMaster();
            EmployeeMaster employeeMaster1 = new EmployeeMaster();
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
                    if (leaveEmployeeDetail.getNoOfDays().floatValue() > employeeLeaveBalance1.getNoOfLeaveRemain()) {
                        balance = true;
                    }
                } else {
                    balance = true;

                }
            }
            LeaveEmployeeDetail leaveEmployeeDetail12 = new LeaveEmployeeDetail();
            leaveEmployeeDetail12.setEmployeeMaster(employeeMaster1);
            List<?> l1 = leaveEmployeeDetailService.readByEmployeeId(leaveEmployeeDetail12);
            boolean flag = false;
            for (Object leave1 : l1) {

                leaveEmployeeDetail12 = (LeaveEmployeeDetail) leave1;
                Date strDate1 = sdf.parse(leaveEmployeeDetail12.getStartDate());
                Date endDate1 = sdf.parse(leaveEmployeeDetail12.getEndDate());
                Integer id1 = leaveEmployeeDetail12.getLeaveTypeMaster().getId();

                if (leaveEmployeeDetail12.getStatus() != 5 && (startDate.equals(strDate1) || startDate.after(strDate1) && startDate.before(endDate1) || (endDate.after(strDate1) && endDate.before(endDate1)))) {
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

            boolean leaveCkeck = true;

            try {
                Calendar cal6 = Calendar.getInstance();
                Calendar cal7 = Calendar.getInstance();
                Date satdateOfLeave = sdf.parse(leaveEmployeeDetail.getStartDate());
                cal6.setTime(satdateOfLeave);
                cal7.setTime(satdateOfLeave);

                String dayNameOfLeave = format2.format(satdateOfLeave);
                if (dayNameOfLeave.equals("Monday")) {
                    LeaveEmployeeDetail leaveEmployeeDetail1 = new LeaveEmployeeDetail();
                    leaveEmployeeDetail1.setEmployeeMaster(employeeMaster1);
                    cal6.add(Calendar.DAY_OF_MONTH, -2);
                    Date dateSet = cal6.getTime();
                    String dayName1 = format2.format(dateSet);
                    String finalDateSet = sdf.format(dateSet);
                    leaveEmployeeDetail1.setStartDate(finalDateSet);
                    int dayOfWeek1 = cal6.get(Calendar.WEEK_OF_MONTH);
                    boolean secondSatCheck = false;
                    if (employeeMaster1.getZydexLocationMaster().getId() == 1 || employeeMaster1.getZydexLocationMaster().getId() == 6) {
                        if (dayOfWeek1 == 2) {
                            secondSatCheck = true;
                        }
                    }
                    if (!secondSatCheck) {
                        List<?> satLeaveListCheck = leaveEmployeeDetailService.leaveCheck(leaveEmployeeDetail1);
                        if (!satLeaveListCheck.isEmpty()) {
                            LeaveEmployeeDetail leaveEmployeeDetail2 = (LeaveEmployeeDetail) satLeaveListCheck.get(0);
                            LeaveTypeMaster leaveTypeMaster1 = new LeaveTypeMaster();
                            leaveTypeMaster1.setId(leaveEmployeeDetail2.getLeaveTypeMaster().getId());
                            leaveTypeMaster1 = leaveTypeMasterService.readById(leaveTypeMaster1.getId());
                            if (leaveTypeMaster1.getLeaveType().contains("Casual Leave") && (leaveEmployeeDetail2.getLeaveTypeMaster().getId().equals(leaveEmployeeDetail.getLeaveTypeMaster().getId()))) {
                                LeaveTypeMaster leaveTypeMaster2 = new LeaveTypeMaster();
                                leaveTypeMaster2.setId(7);
                                employeeLeaveBalance1.setEmployeeMaster(employeeMaster1);
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
                                    employeeLeaveBalance2.setEmployeeMaster(employeeMaster1);
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
                                    leaveEmployeeDetail3.setEmployeeMaster(employeeMaster1);
                                    leaveEmployeeDetail3.setStartDate(finalDateSet1);
                                    leaveEmployeeDetail3.setEndDate(finalDateSet1);
                                    LeaveTypeMaster leaveTypeMaster3 = new LeaveTypeMaster();
                                    leaveTypeMaster3.setId(12);
                                    leaveEmployeeDetail3.setLeaveTypeMaster(leaveTypeMaster3);
                                    leaveEmployeeDetail3.setStartDateStatus("Fullday");
                                    leaveEmployeeDetail3.setEndDateStatus("Fullday");
                                    leaveEmployeeDetail3.setNoOfDays(1.0f);
                                    leaveEmployeeDetail3.setStatus(0);
                                    leaveEmployeeDetailService.create(leaveEmployeeDetail3);
                                }

                            } else if (!leaveTypeMaster1.getLeaveType().contains("Casual Leave") && (leaveEmployeeDetail2.getLeaveTypeMaster().getId().equals(leaveEmployeeDetail.getLeaveTypeMaster().getId()))) {
                                employeeLeaveBalance1.setEmployeeMaster(employeeMaster1);
                                employeeLeaveBalance1.setLeaveTypeMaster(leaveEmployeeDetail.getLeaveTypeMaster());
                                List<?> balanceList = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance1);
                                if (!balanceList.isEmpty()) {
                                    employeeLeaveBalance1 = (EmployeeLeaveBalance) balanceList.get(0);
                                }
                                EmployeeLeaveBalance employeeLeaveBalance2 = new EmployeeLeaveBalance();
                                employeeLeaveBalance2.setEmployeeMaster(employeeMaster1);
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
                                    leaveEmployeeDetailService.update(leaveEmployeeDetail2);
                                } else {
                                    leaveCkeck = true;
                                    LeaveEmployeeDetail leaveEmployeeDetail3 = new LeaveEmployeeDetail();
                                    cal7.add(Calendar.DAY_OF_MONTH, -1);
                                    Date dateSet1 = cal7.getTime();
                                    String finalDateSet1 = sdf.format(dateSet1);
                                    leaveEmployeeDetail1.setStartDate(finalDateSet);
                                    leaveEmployeeDetail3.setEmployeeMaster(employeeMaster1);
                                    leaveEmployeeDetail3.setStartDate(finalDateSet1);
                                    leaveEmployeeDetail3.setEndDate(finalDateSet1);
                                    LeaveTypeMaster leaveTypeMaster3 = new LeaveTypeMaster();
                                    leaveTypeMaster3.setId(12);
                                    leaveEmployeeDetail3.setLeaveTypeMaster(leaveTypeMaster3);
                                    leaveEmployeeDetail3.setStartDateStatus("Fullday");
                                    leaveEmployeeDetail3.setEndDateStatus("Fullday");
                                    leaveEmployeeDetail3.setNoOfDays(1.0f);
                                    leaveEmployeeDetail3.setStatus(0);
                                    leaveEmployeeDetailService.create(leaveEmployeeDetail3);
                                }
                            } else if ((!leaveEmployeeDetail2.getLeaveTypeMaster().getId().equals(leaveEmployeeDetail.getLeaveTypeMaster().getId()))) {
                                employeeLeaveBalance1.setEmployeeMaster(employeeMaster1);
                                employeeLeaveBalance1.setLeaveTypeMaster(leaveEmployeeDetail.getLeaveTypeMaster());
                                List<?> balanceList = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance1);
                                if (!balanceList.isEmpty()) {
                                    employeeLeaveBalance1 = (EmployeeLeaveBalance) balanceList.get(0);
                                }
                                EmployeeLeaveBalance employeeLeaveBalance2 = new EmployeeLeaveBalance();
                                employeeLeaveBalance2.setEmployeeMaster(employeeMaster1);
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
                                    leaveEmployeeDetailService.update(leaveEmployeeDetail2);

                                } else {
                                    leaveCkeck = true;
                                    LeaveEmployeeDetail leaveEmployeeDetail3 = new LeaveEmployeeDetail();
                                    cal7.add(Calendar.DAY_OF_MONTH, -1);
                                    Date dateSet1 = cal7.getTime();
                                    String finalDateSet1 = sdf.format(dateSet1);
                                    leaveEmployeeDetail1.setStartDate(finalDateSet);
                                    leaveEmployeeDetail3.setEmployeeMaster(employeeMaster1);
                                    leaveEmployeeDetail3.setStartDate(finalDateSet1);
                                    leaveEmployeeDetail3.setEndDate(finalDateSet1);
                                    LeaveTypeMaster leaveTypeMaster3 = new LeaveTypeMaster();
                                    leaveTypeMaster3.setId(12);
                                    leaveEmployeeDetail3.setLeaveTypeMaster(leaveTypeMaster3);
                                    leaveEmployeeDetail3.setStartDateStatus("Fullday");
                                    leaveEmployeeDetail3.setEndDateStatus("Fullday");
                                    leaveEmployeeDetail3.setNoOfDays(1.0f);
                                    leaveEmployeeDetail3.setStatus(0);
                                    leaveEmployeeDetailService.create(leaveEmployeeDetail3);
                                }
                            }
                        }

                    }
                }
            } catch (Exception exception) {

            }

            if (leaveCkeck) {
                leaveTypeMaster = leaveTypeMasterService.readById(leaveEmployeeDetail.getLeaveTypeMaster().getId());
            } else {
                leaveTypeMaster = leaveTypeMasterService.readById(leaveTypeMaster.getId());
            }

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
            } else if (leaveEmployeeDetail.getNoOfDays() > Float.parseFloat(leaveTypeMaster.getMaxDayAllowedLeave()) && !leaveTypeMaster.getLeaveType().contains("Privilege Leave") && !leaveTypeMaster.getLeaveType().contains("Maternity Leave") && !leaveTypeMaster.getLeaveType().contains("C Off Leave")
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
        } catch (Exception exception) {
            rcode = "0";
            message = "Error";
            userData.put("responseMessage", message);
            userData.put("responseCode", rcode);
            out.print(userData);
        }

    }

    public void userleaveList(HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException {
        PrintWriter out = null;
        out = response.getWriter();
        String rcode = "";
        String message = "";
        String empid = "";
        JSONObject userData = new JSONObject();
        JSONObject data = new JSONObject();
        try {
            UserMaster user = new UserMaster();
            EmployeeMaster employeeMaster = new EmployeeMaster();
            EmployeeMaster employeeMaster1 = new EmployeeMaster();
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
                if (!empLeaveList.isEmpty()) {
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
                } else {
                    rcode = "2";
                    message = "No Record Found";
                }
                data.put("UserLeaveList", jSONArray);
            } else {
                rcode = "0";
                message = "Error";
            }
        } catch (Exception exception) {
            rcode = "0";
            message = "Error";
        }
        userData.put("data", data);
        userData.put("responseMessage", message);
        userData.put("responseCode", rcode);
        out.print(userData);
    }

    public void WithDrawLeaveRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException, MessagingException, ParseException {
        PrintWriter out = null;
        out = response.getWriter();
        String rcode = "";
        String message = "";
        JSONObject userData = new JSONObject();
        JSONObject data = new JSONObject();
        try {
            LeaveTypeMaster leaveTypeMaster = new LeaveTypeMaster();
            EmployeeLeaveBalance employeeLeaveBalance = new EmployeeLeaveBalance();
            Float balanceDay;
            Float noOfDay;
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String leaveid = request.getParameter("leaveid");
            LeaveEmployeeDetail leaveEmployeeDetail = new LeaveEmployeeDetail();
            if (null != leaveid && !leaveid.equals("")) {
                leaveEmployeeDetail = leaveEmployeeDetailService.readById(Integer.parseInt(leaveid));
                int empId = leaveEmployeeDetail.getEmployeeMaster().getId();
                EmployeeMaster employeeMaster = employeeMasterService.readById(empId);
                leaveTypeMaster = leaveTypeMasterService.readById(leaveEmployeeDetail.getLeaveTypeMaster().getId());
                leaveEmployeeDetail.getLeaveTypeMaster().getId();
                int status = leaveEmployeeDetail.getStatus();

                leaveTypeMaster = leaveEmployeeDetail.getLeaveTypeMaster();
                int leavetypeid = leaveTypeMaster.getId();

                if (leavetypeid != 10) {
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
                        leaveTypeMaster = leaveTypeMasterService.readById(leavetypeid);
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
                            if (!balanceMonleave.isEmpty()) {
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
                        leaveTypeMaster = leaveTypeMasterService.readById(leavetypeid);
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
                            if (!balanceMonleave.isEmpty()) {
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
                                leaveEmployeeDetailService.update(leaveEmployeeDetail2);

                            }
                        }
                    }
                }

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
                    String approveDate = sdf.format(date);
                    leaveEmployeeDetail.setApproveDate(approveDate);
                    leaveEmployeeDetailService.update(leaveEmployeeDetail);

                    EmployeeMaster employeeMasterModel = (EmployeeMaster) employeeMaster;
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
                    rcode = "1";
                    message = "Success";

                } else if (status == 3) {
                    leaveEmployeeDetail.setStatus(4);
                    leaveEmployeeDetailService.update(leaveEmployeeDetail);

                    EmployeeMaster employeeMasterModel = (EmployeeMaster) employeeMaster;
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

        } catch (Exception exception) {
            rcode = "0";
            message = "Error";
            userData.put("responseMessage", message);
            userData.put("responseCode", rcode);
            out.print(userData);
        }
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
        leaveEmployeeDetail2.setId(Integer.parseInt(leaveid));
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

                    try {
                        EmployeeMaster employeeMasterModel = (EmployeeMaster) employeeMaster;
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

                    try {
                        EmployeeMaster employeeMasterModel = (EmployeeMaster) employeeMaster;
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

                    try {
                        EmployeeMaster employeeMasterModel = (EmployeeMaster) employeeMaster;
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
                    try {
                        EmployeeMaster employeeMasterModel = (EmployeeMaster) employeeMaster;
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

                }
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

                try {
                    EmployeeMaster employeeMasterModel = (EmployeeMaster) employeeMaster;
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

            }

            userData.put("responseMessage", message);
            userData.put("responseCode", rcode);
            out.print(userData);
        } else {
            rcode = "5";
            message = "You Have Already apply Leave On that Day...";
            userData.put("responseMessage", message);
            userData.put("responseCode", rcode);
            out.print(userData);
        }
    }

    public void userDashboard(HttpServletRequest request,
            HttpServletResponse response) throws
            IOException, JSONException, ServletException, ParseException {
        PrintWriter out = null;
        out = response.getWriter();
        UserMaster user = new UserMaster();
        String rcode = "";
        String empid = "";
        String message = "";
        JSONObject userData = new JSONObject();
        JSONObject data = new JSONObject();
        JSONObject data1 = new JSONObject();
        JSONArray array = new JSONArray();
        try {
            String id = request.getParameter("id");
            int userid = Integer.parseInt(id);
            user.setId(userid);
            EmployeeMaster employeeMaster = new EmployeeMaster();
            EmployeeMaster employeeMaster1 = new EmployeeMaster();
            employeeMaster.setUserMaster(user);
            JSONArray jSONArray = new JSONArray();
            List<EmployeeMaster> empDetailList = (List<EmployeeMaster>) employeeMasterService.readByEmployeeUserId(employeeMaster);
            if (!empDetailList.isEmpty()) {
                employeeMaster1 = (EmployeeMaster) empDetailList.get(0);

            }
            EmployeeLeaveBalance employeeLeaveBalance = new EmployeeLeaveBalance();
            employeeLeaveBalance.setEmployeeMaster(employeeMaster1);
            List totalLeaveList = employeeLeaveBalanceService.readByEmpId(employeeLeaveBalance);
            List<List> finalLeaveList = new ArrayList<List>();
            int count = 0;
            for (Iterator iterator = totalLeaveList.iterator(); iterator.hasNext();) {
                JSONObject data2 = new JSONObject();
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
                    leaveEmployeeDetail.setEmployeeMaster(employeeMaster1);
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
                    data2.put("leavetypename", o[0]);
                    data2.put("allowedleavedays", leaveCount);
                    data2.put("maxleave", totalLeave1);
                    data2.put("leavetypeid", leaveId);
                    jSONArray.put(data2);

                    if (count > 8) {
                        count = 0;
                    }
//                
                } catch (Exception exception) {

                }
                count++;
            }
            data1.put("leavedetail", jSONArray);
            
            
            LeaveEmployeeDetail leaveEmployeeDetail = new LeaveEmployeeDetail();
            leaveEmployeeDetail.setEmployeeMaster(employeeMaster1);
            List<?> leavelist = leaveEmployeeDetailService.readPendingLeaveRequest(leaveEmployeeDetail);

            TravelRequestMaster travelRequestMaster = new TravelRequestMaster();
            travelRequestMaster.setEmployeeMasterByEmployeeMasterId(employeeMaster1);
            List<?> travellist = travelRequestMasterService.readPendingTravelRequest(travelRequestMaster);

            ExpenseMaster expenseMaster = new ExpenseMaster();
            expenseMaster.setEmployeeMasterByEmployeeId(employeeMaster1);
            List<?> expenselist = expenseMasterService.readByExpensePendingRequest(expenseMaster);

            ItServiceRequest itServiceRequest = new ItServiceRequest();
            itServiceRequest.setEmployeeMasterByEmployeeMasterId(employeeMaster1);
            List<?> itrequestlist = itServiceRequestService.readByItServicePendingRequest(itServiceRequest);

            HrServiceRequest hrServiceRequest = new HrServiceRequest();
            hrServiceRequest.setEmployeeMasterByEmployeeMasterId(employeeMaster1);
            List<?> hrlist = hrServiceRequestService.readHrServicePendingRequest(hrServiceRequest);

            data1.put("leaveRequest", leavelist.size());
            data1.put("travelRequest", travellist.size());
            data1.put("expenseRequest", expenselist.size());
            data1.put("itRequest", itrequestlist.size());
            data1.put("hrRequest", hrlist.size());
            data.put("data", data1);
            rcode = "1";
            message = "Success";

        } catch (Exception exception) {
            rcode = "0";
            message = "Error";
        }

        data.put(
                "responseMessage", message);
        data.put(
                "responseCode", rcode);
        out.print(data);

    }

}
