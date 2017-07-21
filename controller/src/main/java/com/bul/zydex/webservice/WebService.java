/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.webservice;

import com.bul.zydex.model.AttendanceRegularization;
import com.bul.zydex.model.COffLeaveMaster;
import com.bul.zydex.model.DepartmentMaster;
import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.model.EmailAddMaster;
import com.bul.zydex.model.EmailTemplate;
import com.bul.zydex.model.EmployeeLeaveBalance;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.EmployeeShiftData;
import com.bul.zydex.model.ExpenseMaster;
import com.bul.zydex.model.ExpenseOtherType;
import com.bul.zydex.model.ExpenseTravelType;
import com.bul.zydex.model.HolidayMaster;
import com.bul.zydex.model.HrServiceRequest;
import com.bul.zydex.model.ItServiceRequest;
import com.bul.zydex.model.LeaveEmployeeDetail;
import com.bul.zydex.model.LeaveTypeMaster;
import com.bul.zydex.model.LevelMaster;
import com.bul.zydex.model.LocationMaster;
import com.bul.zydex.model.RelocationOrOtherExpense;
import com.bul.zydex.model.TravelApproverHistory;
import com.bul.zydex.model.TravelRequestMaster;
import com.bul.zydex.model.UserMaster;
import com.bul.zydex.model.UserRightMaster;
import com.bul.zydex.model.ZydexLocationMaster;
import com.bul.zydex.service.holiday.HolidayMasterService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import static com.lowagie.text.pdf.PdfName.T;
import com.sun.org.apache.bcel.internal.generic.GOTO;
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
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.crypto.ExemptionMechanismException;
import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang3.time.DateUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.servlet.ModelAndView;

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
        String rightOfLeave = "";
        String itManagerFlag = "";
        String hrManagerFlag = "";
        JSONObject logObj = new JSONObject();
        JSONObject data = new JSONObject();
//                boolean managerFlag = true;
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
                EmployeeMaster employeeMaster1 = new EmployeeMaster();

                for (UserMaster userDetail : userList) {
                    userid = userDetail.getId().toString();
                    username = userDetail.getUserName().toString();

                    employeeMaster.setUserMaster(userDetail);
                    List<?> empDetailList = employeeMasterService.readByEmployeeUserId(employeeMaster);
                    if (!empDetailList.isEmpty()) {

                        employeeMaster1 = (EmployeeMaster) empDetailList.get(0);
                        employeeName = employeeMaster1.getEmployeeName();
                    }

                }
                List<?> reportingManagerList = employeeMasterService.readForAprove(employeeMaster1.getId());

                if (!reportingManagerList.isEmpty()) {
                    rightOfLeave = "Yes";
                } else {
                    rightOfLeave = "No";
                }

                UserRightMaster userRightMaster = new UserRightMaster();
                UserMaster um = new UserMaster();
                um.setId(Integer.parseInt(userid));
                userRightMaster.setUserMaster(um);
                boolean hr = false;
                boolean itAdmin = false;
                List<?> list = userRightMasterService.readByUserRight(userRightMaster);
                if (!list.isEmpty()) {
                    UserRightMaster rightMaster = (UserRightMaster) list.get(0);
                    hr = rightMaster.isHr();
                    itAdmin = rightMaster.isItAdmin();
                }
                if (hr) {
                    if (!employeeMaster1.getReportingManagerLevel1().equals("") && employeeMaster1.getReportingManagerLevel1() != null) {
                        hrManagerFlag = "Yes";
                    } else {
                        hrManagerFlag = "No";
                    }
                } else {
                    hrManagerFlag = "No";
                };
                if (itAdmin) {
                    if (!employeeMaster1.getReportingManagerLevel1().equals("") && employeeMaster1.getReportingManagerLevel1() != null) {
                        itManagerFlag = "Yes";
                    } else {
                        itManagerFlag = "No";
                    }
                } else {
                    itManagerFlag = "No";
                };

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

            data.put("HRreportmanager", hrManagerFlag);
            data.put("SubOrdinateLeave", rightOfLeave);
            data.put("Expensesubordinate", rightOfLeave);
            data.put("Travelsubordinate", rightOfLeave);
            data.put("Attendancesubordinate", rightOfLeave);
            data.put("ITmanager", itManagerFlag);
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

    public void LeaverequestApprovel(HttpServletRequest request, HttpServletResponse response) throws Exception {

        LeaveEmployeeDetail leaveEmployeeDetail = new LeaveEmployeeDetail();
        EmployeeLeaveBalance employeeLeaveBalance = new EmployeeLeaveBalance();
        LeaveTypeMaster leaveTypeMaster = new LeaveTypeMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        Float balanceDay;
        Float noOfDay;
        String id = request.getParameter("id");
        String hrRemark = request.getParameter("hrRemark");
        String btnSubmit = request.getParameter("btnSubmit");
        leaveEmployeeDetail = leaveEmployeeDetailService.readById(Integer.parseInt(id));
        leaveEmployeeDetail.setHrRemark(hrRemark);
        EmployeeMaster employeeMaster1 = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        leaveEmployeeDetail.setApproverId(employeeMaster1.getId());
        leaveTypeMaster.setId(leaveEmployeeDetail.getLeaveTypeMaster().getId());
        employeeMaster.setId(leaveEmployeeDetail.getEmployeeMaster().getId());
        employeeLeaveBalance.setEmployeeMaster(employeeMaster);
        employeeLeaveBalance.setLeaveTypeMaster(leaveTypeMaster);

        List<?> balanceList = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance);
        if (!balanceList.isEmpty()) {
            employeeLeaveBalance = (EmployeeLeaveBalance) balanceList.get(0);
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

//               #########check present##################
            String strDate = (data.get("startDate").toString()).replaceAll(",", "/");
            String enDate = (data.get("endDate").toString()).replaceAll(",", "/");
            String strDatestaus = (data.get("startDayType").toString());
            String enDatestatus = (data.get("endDayType").toString());
            EmployeeShiftData employeeShiftData = new EmployeeShiftData();
            EmployeeShiftData employeeShiftData2 = new EmployeeShiftData();
            employeeShiftData.setOutDateTime(strDate);
            employeeShiftData.setEmployeeMaster(employeeMaster1);
            employeeShiftData2.setOutDateTime(enDate);
            employeeShiftData2.setEmployeeMaster(employeeMaster1);

            List<?> plist = employeeShiftDataService.checkTodayPresent(employeeShiftData);
            List<?> plist2 = employeeShiftDataService.checkTodayPresent(employeeShiftData2);
            EmployeeShiftData employeeShiftData1 = new EmployeeShiftData();
            EmployeeShiftData employeeShiftData3 = new EmployeeShiftData();
            long diffHours = 0;
            long diffHours1 = 0;
            if (!plist.isEmpty() || !plist2.isEmpty()) {
                if (!plist.isEmpty()) {

                    employeeShiftData1 = (EmployeeShiftData) plist.get(0);
                    String sDate = employeeShiftData1.getInDateTime();
                    String eDate = employeeShiftData1.getOutDateTime();
                    SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                    Date iDate = sdf1.parse(sDate);
                    Date oDate = sdf1.parse(eDate);
                    long diff = oDate.getTime() - iDate.getTime();
                    diffHours = diff / (60 * 60 * 1000) % 24;
                }
                if (!plist2.isEmpty()) {

                    employeeShiftData3 = (EmployeeShiftData) plist2.get(0);
                    SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                    String sDate1 = employeeShiftData3.getInDateTime();
                    String eDate1 = employeeShiftData3.getOutDateTime();
                    Date iDate1 = sdf1.parse(sDate1);
                    Date oDate1 = sdf1.parse(eDate1);
                    long diff1 = oDate1.getTime() - iDate1.getTime();
                    diffHours1 = diff1 / (60 * 60 * 1000) % 24;

                }
            }
            if (strDatestaus.equals("Fullday") && !plist.isEmpty() && diffHours >= 4 || enDatestatus.equals("Fullday") && !plist2.isEmpty() && diffHours1 >= 4) {
                if (strDatestaus.equals("Fullday") && !plist.isEmpty()) {

//                if (list.size() > 0 && employeeShiftData1.getShiftMaster().getId() != 5) {
                    if (diffHours >= 4 && employeeShiftData1.getShiftMaster().getId() != 5) {

                        rcode = "12";
                        message = "On This Day You Are Present";
                        userData.put("responseMessage", message);
                        userData.put("responseCode", rcode);
                        out.print(userData);
                    }
                }
                if (enDatestatus.equals("Fullday") && !plist2.isEmpty()) {

//                if (list.size() > 0 && employeeShiftData1.getShiftMaster().getId() != 5) {
                    if (diffHours1 >= 4 && employeeShiftData3.getShiftMaster().getId() != 5) {
                        rcode = "13";
                        message = "On This Day You Are Present";
                        userData.put("responseMessage", message);
                        userData.put("responseCode", rcode);
                        out.print(userData);
                    }

                }
            } else {

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
                                if (!leaveEmployeeDetail2.getStartDateStatus().contains("SecondHalf") && !leaveEmployeeDetail2.getStartDateStatus().contains("FirstHalf")) {
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
                                            SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                                            String currentDate = dateFormat1.format(new Date());
                                            leaveEmployeeDetail.setDateOfSubmit(currentDate);
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
                                            SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                                            String currentDate = dateFormat1.format(new Date());
                                            leaveEmployeeDetail.setDateOfSubmit(currentDate);
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
                                            SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                                            String currentDate = dateFormat1.format(new Date());
                                            leaveEmployeeDetail.setDateOfSubmit(currentDate);
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
                                            SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                                            String currentDate = dateFormat1.format(new Date());
                                            leaveEmployeeDetail.setDateOfSubmit(currentDate);
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
                                            SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                                            String currentDate = dateFormat1.format(new Date());
                                            leaveEmployeeDetail.setDateOfSubmit(currentDate);
                                            leaveEmployeeDetailService.create(leaveEmployeeDetail3);
                                        }
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
                boolean plBalCheck = false;
                List<?> plCheck = leaveEmployeeDetailService.plLeaveCheck(employeeMaster1.getId());
                if (plCheck.size() >= 3) {
                    plBalCheck = true;
                }
                if (dayName.equals("Saturday") && dayOfWeek == 2 && (locationId == 1 || locationId == 6) && (strDatestaus.equals("Fullday") || strDatestaus.equals("SecondHalf"))) {
                    rcode = "16";
                    message = "On Second Saturday You can Not Apply Leave";
                } else if (leaveTypeMaster.getLeaveType().contains("Short Leave")) {
                    if (dayName.equals("Saturday") && dayOfWeek == 2 && (locationId == 1 || locationId == 6)) {
                        rcode = "2";
                        message = "On Second Saturday You can Not Apply Short Leave";

                    } else if (flag) {
                        rcode = "5";
                        message = "You Have Already apply Leave On that Day...";

                    } else {

                        leaveEmployeeDetail.setNoOfDays(Float.parseFloat("1"));
                        SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                        String currentDate = dateFormat1.format(new Date());
                        leaveEmployeeDetail.setDateOfSubmit(currentDate);
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
                        SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                        String currentDate = dateFormat1.format(new Date());
                        leaveEmployeeDetail.setDateOfSubmit(currentDate);
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
                } else if (plBalCheck && leaveTypeMaster.getLeaveType().contains("Privilege Leave") && leaveEmployeeDetail.getNoOfDays() < 3) {
                    rcode = "11";
                    message = "You can't apply less than 3 days Privilege Leave.";
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

                        SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                        String currentDate = dateFormat1.format(new Date());
                        leaveEmployeeDetail.setDateOfSubmit(currentDate);
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
                    noOfDay = leaveEmployeeDetail.getNoOfDays();
                    if (checkLeaveDate.after(checkLeaveDate2)) {
                        rcode = "10";
                        message = "Sick Leave Can Not Be Apply In Advance";
                    } else if (noOfDay > 3) {
                        rcode = "14";
                        message = "No Of Days is Greater than maximum allowed Days...";

                    } else {

                        SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                        String currentDate = dateFormat1.format(new Date());
                        leaveEmployeeDetail.setDateOfSubmit(currentDate);
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

                    SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                    String currentDate = dateFormat1.format(new Date());
                    leaveEmployeeDetail.setDateOfSubmit(currentDate);
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
                        String empreason;
                        String ApproveName;
                        String dateOfSubmit;

                        if (null == arrayOfObject[6].toString()) {
                            empreason = "";
                        } else {
                            empreason = arrayOfObject[6].toString();
                        }

                        if (null == arrayOfObject[7]) {
                            dateOfSubmit = "";
                        } else {
                            dateOfSubmit = arrayOfObject[7].toString();
                        }

                        if (null == arrayOfObject[8]) {
                            ApproveName = "";
                        } else {
                            ApproveName = arrayOfObject[8].toString();
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
                            statusmsg = "Approved By " + ApproveName;

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
                        obj.put("dateOfSubmit", dateOfSubmit);
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
        LeaveEmployeeDetail leaveEmployeeDetail1 = new LeaveEmployeeDetail();
        leaveEmployeeDetail1 = leaveEmployeeDetailService.readById(Integer.parseInt(leaveid));
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
                    Float oldnoOfDays = leaveEmployeeDetail1.getNoOfDays();
                    TotalbalanceDay = balanceDay + oldnoOfDays;
                    employeeLeaveBalance3.setNoOfLeaveRemain(TotalbalanceDay);
                    employeeLeaveBalanceService.update(employeeLeaveBalance3);

                    leaveEmployeeDetail.setStatus(0);
                    SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                    String currentDate = dateFormat1.format(new Date());
                    leaveEmployeeDetail.setDateOfSubmit(currentDate);
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
                    SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                    String currentDate = dateFormat1.format(new Date());
                    leaveEmployeeDetail.setDateOfSubmit(currentDate);
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
                    Float oldnoOfDays = leaveEmployeeDetail1.getNoOfDays();
                    TotalbalanceDay = balanceDay + oldnoOfDays;
                    employeeLeaveBalance3.setNoOfLeaveRemain(TotalbalanceDay);
                    employeeLeaveBalanceService.update(employeeLeaveBalance3);

                    leaveEmployeeDetail.setStatus(0);
                    SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                    String currentDate = dateFormat1.format(new Date());
                    leaveEmployeeDetail.setDateOfSubmit(currentDate);
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
                } else if (noOfDay > 3) {
                    rcode = "14";
                    message = "No Of Days is Greater than maximum allowed Days...";

                } else {
                    balanceDay = employeeLeaveBalance3.getNoOfLeaveRemain();
                    Float noOfDays = leaveEmployeeDetail.getNoOfDays();
                    Float oldnoOfDays = leaveEmployeeDetail1.getNoOfDays();
                    TotalbalanceDay = balanceDay + oldnoOfDays;
                    employeeLeaveBalance3.setNoOfLeaveRemain(TotalbalanceDay);
                    employeeLeaveBalanceService.update(employeeLeaveBalance3);

                    leaveEmployeeDetail.setStatus(0);
                    SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                    String currentDate = dateFormat1.format(new Date());
                    leaveEmployeeDetail.setDateOfSubmit(currentDate);
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
                Float noOfDays = leaveEmployeeDetail1.getNoOfDays();
                Float oldnoOfDays = leaveEmployeeDetail1.getNoOfDays();
                TotalbalanceDay = balanceDay + oldnoOfDays;
                employeeLeaveBalance3.setNoOfLeaveRemain(TotalbalanceDay);
                employeeLeaveBalanceService.update(employeeLeaveBalance3);

                leaveEmployeeDetail.setStatus(0);
                SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                String currentDate = dateFormat1.format(new Date());
                leaveEmployeeDetail.setDateOfSubmit(currentDate);
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

    public void SubordinateLeaverequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        ModelAndView mv = new ModelAndView();
        PrintWriter out = null;
        out = response.getWriter();
        String rcode = "";
        String message = "";
        UserMaster user = new UserMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        JSONObject Data = new JSONObject();
        try {
            String id = request.getParameter("id");
            int userid = Integer.parseInt(id);
            user.setId(userid);
            employeeMaster.setUserMaster(user);

            LeaveEmployeeDetail led = new LeaveEmployeeDetail();
            UserMaster userMaster = userMasterService.readById(userid);
            List<?> empDetailList = employeeMasterService.readByEmployeeUserId(employeeMaster);
            if (!empDetailList.isEmpty()) {
                employeeMaster1 = (EmployeeMaster) empDetailList.get(0);
            }
            led.setEmployeeMaster(employeeMaster1);
            LeaveEmployeeDetail leaveEmployeeDetail1 = new LeaveEmployeeDetail();
            JSONArray jSONArray = new JSONArray();
            JSONObject data1 = new JSONObject();

            List<?> list = leaveEmployeeDetailService.viewEmpLeaveRequest(led);
            if (!list.isEmpty()) {

                String empName = "";
                String leaveType = "";
                String EndDate = "";
                String StartDate = "";
                String dateOfSubmit;

                int leaveEmployeeDeatilId = 0;
                int Status = 0;
                int userId = 0;
                float NoOfDays = 0;

                for (int i = 0; i < list.size(); i++) {
                    Object[] o = (Object[]) list.get(i);
                    JSONObject userData = new JSONObject();
                    empName = (String) o[0];
                    leaveType = (String) o[1];
                    StartDate = (String) o[2];
                    EndDate = (String) o[3];
                    NoOfDays = (float) o[4];
                    leaveEmployeeDeatilId = (Integer) o[5];
                    userId = (Integer) o[7];
                    Status = (Integer) o[6];
                    if (null == o[8]) {
                        dateOfSubmit = "";
                    } else {
                        dateOfSubmit = o[8].toString();
                    }
                    userData.put("empName", empName);
                    userData.put("leaveType", leaveType);
                    userData.put("StartDate", StartDate);
                    userData.put("EndDate", EndDate);
                    userData.put("NoOfDays", NoOfDays);
                    userData.put("leaveEmployeeDeatilId", leaveEmployeeDeatilId);
                    userData.put("userId", userId);
                    userData.put("status", Status);
                    userData.put("dateOfSubmit", dateOfSubmit);
                    String Statusmessage = "";
                    if (o[6].equals(0)) {
                        Statusmessage = "Pending";
                    } else if (o[6].equals(1)) {
                        Statusmessage = "Reworked";

                    } else if (o[6].equals(2)) {
                        Statusmessage = "Rejected";

                    } else if (o[6].equals(3)) {
                        Statusmessage = "Approved";

                    } else if (o[6].equals(4)) {
                        Statusmessage = " WithDraw Request";

                    } else if (o[6].equals(5)) {
                        Statusmessage = " Withdrawn";
                    }

                    userData.put("statusmessage", Statusmessage);
                    jSONArray.put(userData);

                }
                rcode = "1";
                message = "Success";
            } else {
                rcode = "2";
                message = "No Record Found";
            }

            data1.put("LeaveDetail", jSONArray);

            data1.put("responseMessage", message);
            data1.put("responseCode", rcode);

            out.print(data1);

            data1.put("userData", jSONArray);

        } catch (Exception e) {
            rcode = "3";
            message = "Invalid Data";
        }

    }

    public void viewsubordinateAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PrintWriter out = null;
        out = response.getWriter();
        String rcode = "";
        String message = "";
        UserMaster user = new UserMaster();
        UserMaster user1 = new UserMaster();

        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        EmployeeMaster empOfLeave = new EmployeeMaster();
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray1 = new JSONArray();
        JSONObject userdata = new JSONObject();
        JSONObject userdays = new JSONObject();
        try {

            String id = request.getParameter("id");
            int userid = Integer.parseInt(id);
            user.setId(userid);
            employeeMaster.setUserMaster(user);

            UserMaster userMaster = userMasterService.readById(userid);
            List<?> empDetailList = employeeMasterService.readByEmployeeUserId(employeeMaster);
            if (!empDetailList.isEmpty()) {
                employeeMaster1 = (EmployeeMaster) empDetailList.get(0);
            }

            /////////////////////////// for Employee Detail ////////////////////////
            EmployeeMaster EmployeeMaster1 = new EmployeeMaster();
            JSONObject Data = doPost(request);
            String leaveEmpDetailId = Data.get("leaveEmployeeDeatilId").toString();
            String empUserId = Data.get("userId").toString();
            user1.setId(Integer.parseInt(empUserId));
            empOfLeave.setUserMaster(user1);
            LeaveEmployeeDetail leaveEmployeeDetail = new LeaveEmployeeDetail();
            EmployeeMaster empOfLeave1 = new EmployeeMaster();
            UserMaster userMaster1 = userMasterService.readById(Integer.parseInt(empUserId));
            empOfLeave1.setUserMaster(userMaster1);
            List<?> empList = employeeMasterService.readByEmployeeUserId(empOfLeave1);
            if (!empList.isEmpty()) {
                empOfLeave1 = (EmployeeMaster) empList.get(0);
            }

            List<?> list = employeeMasterService.readEmployeeDetailUserIdWise(empOfLeave1);
            if (!list.isEmpty()) {
                Object[] ob = (Object[]) list.get(0);

                String eidd = (String) ob[6];
                EmployeeMaster employeeMaster2 = employeeMasterService.readById(Integer.parseInt(eidd));

                String employeeId = "";
                String employeeName = "";
                String designationName = "";
                String level = "";
                String departmentName = "";
                String location = "";
                String reportingManagerLevel1 = "";

                for (int i = 0; i < list.size(); i++) {
                    Object[] o = (Object[]) list.get(i);
                    JSONObject userData = new JSONObject();
                    employeeId = (String) o[0];
                    employeeName = (String) o[1];
                    designationName = (String) o[2];
                    level = (String) o[3];
                    departmentName = (String) o[4];
                    location = (String) o[5];
                    reportingManagerLevel1 = (String) o[6];
                    userData.put("employeeId", employeeId);
                    userData.put("employeeName", employeeName);
                    userData.put("designationName", designationName);
                    userData.put("level", level);
                    userData.put("departmentName", departmentName);
                    userData.put("location", location);
                    userData.put("reportingManagerLevel1", employeeMaster2.getEmployeeName());

                    jSONArray.put(userData);
                }

                ///////////////////////// for read the subordinate leave detail //////////////////////
                leaveEmployeeDetail.setEmployeeMaster(empOfLeave1);
                leaveEmployeeDetail.setId(Integer.parseInt(leaveEmpDetailId));
                List<?> list1 = leaveEmployeeDetailService.leaveApplicationRequest(leaveEmployeeDetail);
                if (!list1.isEmpty()) {

                    String leaveType = "";
                    String startDate = "";
                    String startDateStatus = "";
                    String endDate = "";
                    String endDateStatus = "";
                    String Reason = "";
                    String hrRemark = "";
                    float noOfDays = 0;
                    int status = 0;

                    for (int l = 0; l < list1.size(); l++) {
                        Object[] d = (Object[]) list1.get(l);
                        JSONObject userDays = new JSONObject();
                        leaveType = (String) d[0];
                        startDate = (String) d[1];
                        startDateStatus = (String) d[2];
                        endDate = (String) d[3];
                        endDateStatus = (String) d[4];
                        noOfDays = (float) d[5];
                        Reason = (String) d[6];
                        status = (Integer) d[7];
                        hrRemark = (String) d[8];
                        userDays.put("leaveType", leaveType);
                        userDays.put("startDate", startDate);
                        userDays.put("startDateStatus", startDateStatus);
                        userDays.put("endDate", endDate);
                        userDays.put("endDateStatus", endDateStatus);
                        userDays.put("noOfDays", noOfDays);
                        userDays.put("Reason", Reason);
                        userDays.put("status", status);
                        userDays.put("hrRemark", hrRemark);

                        String statusmsg = "";

                        if (Integer.toString(status).equals("0")) {
                            statusmsg = "Pending";
                        }
                        if (Integer.toString(status).equals("1")) {
                            statusmsg = "Reworked";
                        }
                        if (Integer.toString(status).equals("2")) {
                            statusmsg = "Rejected";
                        }
                        if (Integer.toString(status).equals("3")) {
                            statusmsg = "Approved";

                        }
                        if (Integer.toString(status).equals("4")) {
                            statusmsg = "WithDraw Request";
                        }
                        if (Integer.toString(status).equals("5")) {
                            statusmsg = "WithDrawn";
                        }
                        userDays.put("statusmsg", statusmsg);
                        jSONArray1.put(userDays);
                    }
                }

                rcode = "1";
                message = "Success";
            } else {
                rcode = "2";
                message = "No Record Found";
            }
        } catch (Exception e) {
            rcode = "0";
            message = "Error";
        }

        userdata.put("EmployeeDetail", jSONArray);
        userdata.put("LeaveDetail", jSONArray1);

        userdata.put("responseMessage", message);
        userdata.put("responseCode", rcode);

        out.print(userdata);

    }

    public void Approveluserclick(HttpServletRequest request, HttpServletResponse response) throws Exception {

        PrintWriter out = null;
        out = response.getWriter();
        String rcode = "";
        String message = "";
        JSONObject userData = new JSONObject();
        try {
            UserMaster userApprover = new UserMaster();
            EmployeeMaster empApprover = new EmployeeMaster();
            EmployeeMaster empApprover1 = new EmployeeMaster();
            String id = request.getParameter("id");
            int userid = Integer.parseInt(id);
            userApprover.setId(userid);
            empApprover.setUserMaster(userApprover);

            List<?> empDetailList = employeeMasterService.readByEmployeeUserId(empApprover);
            if (!empDetailList.isEmpty()) {
                empApprover1 = (EmployeeMaster) empDetailList.get(0);
            }

            LeaveEmployeeDetail leaveEmployeeDetail = new LeaveEmployeeDetail();
            EmployeeLeaveBalance employeeLeaveBalance = new EmployeeLeaveBalance();
            LeaveTypeMaster leaveTypeMaster = new LeaveTypeMaster();
            EmployeeMaster employeeMaster = new EmployeeMaster();
            Float balanceDay;
            Float noOfDay;

            JSONObject data1 = doPost(request);
            String leaveEmpId = data1.getString("leaveEmpId");
            String empMastId = data1.getString("empMastId");
            String btnSubmit = data1.getString("btnSubmit");
            String hrRemark = data1.getString("hrRemark");

            UserMaster userRequester = new UserMaster();
            EmployeeMaster empRequester = new EmployeeMaster();
            EmployeeMaster empRequester1 = new EmployeeMaster();

            int userRequesterId = Integer.parseInt(empMastId);
            userRequester.setId(userRequesterId);
            empRequester.setUserMaster(userRequester);

            List<?> empRequesterList = employeeMasterService.readByEmployeeUserId(empRequester);
            if (!empRequesterList.isEmpty()) {
                empRequester1 = (EmployeeMaster) empRequesterList.get(0);
            }
//            String hrRemark = data1.getString("hrRemark");
            leaveEmployeeDetail = leaveEmployeeDetailService.readById(Integer.parseInt(leaveEmpId));
            leaveEmployeeDetail.setHrRemark(hrRemark);

            leaveEmployeeDetail.setApproverId(empApprover1.getId());
            leaveTypeMaster.setId(leaveEmployeeDetail.getLeaveTypeMaster().getId());
            employeeMaster.setId(leaveEmployeeDetail.getEmployeeMaster().getId());
            employeeLeaveBalance.setEmployeeMaster(employeeMaster);
            employeeLeaveBalance.setLeaveTypeMaster(leaveTypeMaster);

            List<?> balanceList = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance);
            if (!balanceList.isEmpty()) {
                employeeLeaveBalance = (EmployeeLeaveBalance) balanceList.get(0);
            }

            if (btnSubmit.equals("approve")) {

                if (leaveEmployeeDetail.getStatus() == 4) {
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
                    request.setAttribute("successMessage",
                            "Information : The Leave is Withdrawn successfully.");//enter approve witdrw template..
                    try {
                        EmployeeMaster employeeMasterModel = employeeMasterService.readById(userid);
                        DesignationMaster designationMaster = new DesignationMaster();
                        designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                        String EmpIdStr = request.getParameter("empid");
                        EmployeeMaster employeeMaster2 = new EmployeeMaster();
                        EmailTemplate emailTemplate1 = new EmailTemplate();
                        // id =11 for approve leave withdraw request...
                        emailTemplate1 = emailTemplateService.readById(11);
                        if (null != EmpIdStr && !"".equals(EmpIdStr)) {
                            int empID = Integer.parseInt(EmpIdStr);
                            List list = employeeMasterService.readByEmployeeNo(empID);
                            if (!list.isEmpty()) {
                                employeeMaster2 = (EmployeeMaster) list.get(0);
                                String To = employeeMaster2.getOfficeEmailId();
                                String from = employeeMasterModel.getOfficeEmailId();
                                String subject = emailTemplate1.getSubject();

                                subject = subject.replaceAll("\\{user\\}", employeeMaster2.getEmployeeName());
                                String msg = emailTemplate1.getBodytext();
                                msg = msg.replaceAll("\\{to_user\\}", employeeMaster2.getEmployeeName());
                                msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                                msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                                sendMail.sendMail(from, To, subject, msg);

                            }
                        }
                    } catch (Exception e) {
                    }

                } else {

//                balanceDay = employeeLeaveBalance.getNoOfLeaveRemain();
//                noOfDay = leaveEmployeeDetail.getNoOfDays();
//                if (noOfDay <= balanceDay) {
                    int leaveTypeId = leaveEmployeeDetail.getLeaveTypeMaster().getId();
                    leaveEmployeeDetail.setStatus(3);
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    String approveDate = sdf.format(date);
                    leaveEmployeeDetail.setApproveDate(approveDate);
                    leaveEmployeeDetailService.update(leaveEmployeeDetail);
//                    request.setAttribute("successMessage",
//                            "Information : The Leave Approved successfully.");
                    try {
                        String startdate = leaveEmployeeDetail.getStartDate();
                        String enddate = leaveEmployeeDetail.getEndDate();
                        EmployeeMaster employeeMasterModel = employeeMasterService.readById(userid);
                        DesignationMaster designationMaster = new DesignationMaster();
                        designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                        String EmpIdStr = request.getParameter("empid");
                        EmployeeMaster employeeMaster2 = new EmployeeMaster();
                        EmailTemplate emailTemplate1 = new EmailTemplate();
                        // id =7 for approve leave request...
                        emailTemplate1 = emailTemplateService.readById(7);
                        if (null != EmpIdStr && !"".equals(EmpIdStr)) {
                            int empID = Integer.parseInt(EmpIdStr);
                            List list = employeeMasterService.readByEmployeeNo(empID);
                            if (!list.isEmpty()) {
                                employeeMaster2 = (EmployeeMaster) list.get(0);
                                String To = employeeMaster2.getOfficeEmailId();
                                String from = employeeMasterModel.getOfficeEmailId();
                                String subject = emailTemplate1.getSubject();
                                subject = subject.replaceAll("\\{user\\}", employeeMaster2.getEmployeeName());
                                String msg = emailTemplate1.getBodytext();
                                msg = msg.replaceAll("\\{to_user\\}", employeeMaster2.getEmployeeName());
                                msg = msg.replaceAll("\\{start_date\\}", startdate);
                                msg = msg.replaceAll("\\{end_date\\}", enddate);
                                msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                                msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                                sendMail.sendMail(from, To, subject, msg);

                                String name = "Leave";
                                EmailAddMaster emailAddMaster = new EmailAddMaster();
                                emailAddMaster.setModuleName(name);
                                emailAddMaster.setDepartmentMaster(employeeMaster2.getDepartmentMaster());
                                List<?> emailSendList = emailAddMasterService.readByName(emailAddMaster);
                                if (!emailSendList.isEmpty()) {
                                    EmailAddMaster emailAddMaster1 = (EmailAddMaster) emailSendList.get(0);
                                    String emailId = emailAddMaster1.getEmailId();
                                    for (String emailId1 : emailId.split(",")) {
                                        if (!emailId1.equals("")) {
                                            String To1 = emailId1;
                                            String from1 = employeeMasterModel.getOfficeEmailId();
                                            String subject1 = emailTemplate1.getSubject();
                                            subject1 = subject1.replaceAll("\\{user\\}", employeeMaster2.getEmployeeName());
                                            String msg1 = emailTemplate1.getBodytext();
                                            msg1 = msg1.replaceAll("\\{to_user\\}", employeeMaster2.getEmployeeName());
                                            msg1 = msg1.replaceAll("\\{start_date\\}", startdate);
                                            msg1 = msg1.replaceAll("\\{end_date\\}", enddate);
                                            msg1 = msg1.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                                            msg1 = msg1.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                                            sendMail.sendMail(from1, To1, subject1, msg1);
                                        }
                                    }
                                }
                                List<?> allDeptmailList = emailAddMasterService.readAllDept(name);
                                if (!allDeptmailList.isEmpty()) {
                                    EmailAddMaster emailAddMaster1 = (EmailAddMaster) allDeptmailList.get(0);
                                    String emailId = emailAddMaster1.getEmailId();
                                    for (String emailId1 : emailId.split(",")) {
                                        if (!emailId1.equals("")) {
                                            String To1 = emailId1;
                                            String from1 = employeeMasterModel.getOfficeEmailId();
                                            String subject1 = emailTemplate1.getSubject();
                                            subject1 = subject1.replaceAll("\\{user\\}", employeeMaster2.getEmployeeName());
                                            String msg1 = emailTemplate1.getBodytext();
                                            msg1 = msg1.replaceAll("\\{to_user\\}", employeeMaster2.getEmployeeName());
                                            msg1 = msg1.replaceAll("\\{start_date\\}", startdate);
                                            msg1 = msg1.replaceAll("\\{end_date\\}", enddate);
                                            msg1 = msg1.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                                            msg1 = msg1.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                                            sendMail.sendMail(from1, To1, subject1, msg1);
                                        }
                                    }
                                }

                                List<?> gmOrStateHeadMailSend = employeeMasterService.readForSendMailToAll(employeeMaster2);
                                if (!gmOrStateHeadMailSend.isEmpty()) {

                                    Object[] emaillist = (Object[]) gmOrStateHeadMailSend.get(0);
                                    for (int i = 0; i <= emaillist.length; i++) {
                                        if (null != emaillist[i] && "" != emaillist[i]) {
                                            String emailid = emaillist[i].toString();

                                            String To3 = emailid;
                                            String from3 = employeeMasterModel.getOfficeEmailId();
                                            String subject3 = emailTemplate1.getSubject();

                                            subject3 = subject3.replaceAll("\\{user\\}", employeeMaster2.getEmployeeName());
                                            String msg3 = emailTemplate1.getBodytext();
                                            msg3 = msg3.replaceAll("\\{to_user\\}", employeeMaster2.getEmployeeName());
                                            msg3 = msg3.replaceAll("\\{start_date\\}", startdate);
                                            msg3 = msg3.replaceAll("\\{end_date\\}", enddate);
                                            msg3 = msg3.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                                            msg3 = msg3.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                                            sendMail.sendMail(from3, To3, subject3, msg3);
                                        }
                                    }
                                }
                            }
                        }
                    } catch (Exception e) {
                    }

//                } else {
//                    request.setAttribute("failureMessage",
//                            "Error : Employee Leave Balance is Less Than Applied Days. So Please Reject/Rework a Leave Request");
//                }
                }

            }
            if (btnSubmit.equals("reject")) {

                if (leaveEmployeeDetail.getStatus() == 4) {
//                    request.setAttribute("successMessage",
//                            "Information : The Withdraw Request Rejected successfully.");
                    try {
                        EmployeeMaster employeeMasterModel = employeeMasterService.readById(userid);
                        DesignationMaster designationMaster = new DesignationMaster();
                        designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                        String EmpIdStr = request.getParameter("empid");
                        EmployeeMaster employeeMaster2 = new EmployeeMaster();
                        EmailTemplate emailTemplate1 = new EmailTemplate();
                        // id =9 for reject leave request...
                        emailTemplate1 = emailTemplateService.readById(9);
                        if (null != EmpIdStr && !"".equals(EmpIdStr)) {
                            int empID = Integer.parseInt(EmpIdStr);
                            List list = employeeMasterService.readByEmployeeNo(empID);
                            if (!list.isEmpty()) {
                                employeeMaster2 = (EmployeeMaster) list.get(0);
                                String To = employeeMaster2.getOfficeEmailId();
                                String from = employeeMasterModel.getOfficeEmailId();
                                String subject = emailTemplate1.getSubject();
                                subject = subject.replaceAll("\\{user\\}", employeeMaster2.getEmployeeName());
                                String msg = emailTemplate1.getBodytext();
                                msg = msg.replaceAll("\\{to_user\\}", employeeMaster2.getEmployeeName());
                                msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                                msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                                sendMail.sendMail(from, To, subject, msg);

                            }
                        }
                    } catch (Exception e) {
                    }

                } else {
                    balanceDay = employeeLeaveBalance.getNoOfLeaveRemain();
                    noOfDay = leaveEmployeeDetail.getNoOfDays();
                    String noOfHour = "";
                    EmployeeMaster employeeMasterModel1 = new EmployeeMaster();
                    employeeMasterModel1 = employeeMasterService.readById(leaveEmployeeDetail.getEmployeeMaster().getId());
                    COffLeaveMaster cOffLeaveMaster = new COffLeaveMaster();
                    cOffLeaveMaster.setZydexLocationMaster(employeeMasterModel1.getZydexLocationMaster());
                    List list1 = cOffLeaveMasterService.readByDept(cOffLeaveMaster);
                    try {
                        cOffLeaveMaster = (COffLeaveMaster) list1.get(0);
                        noOfHour = "0." + cOffLeaveMaster.getHoursNo();
                    } catch (Exception e) {
                    }
                    // 11 No Id Is C-Off Id*****************
                    if (leaveEmployeeDetail.getLeaveTypeMaster().getId().equals(11)) {
                        noOfDay = Float.parseFloat(noOfHour);
                    }
                    // 11 No Id Is C-Off Id*****************
                    balanceDay = balanceDay + noOfDay;
                    employeeLeaveBalance.setNoOfLeaveRemain(balanceDay);
                    employeeLeaveBalanceService.update(employeeLeaveBalance);
//                    request.setAttribute("successMessage",
//                            "Information : The Leave Rejected successfully.");
                    try {
                        EmployeeMaster employeeMasterModel = employeeMasterService.readById(userid);
                        DesignationMaster designationMaster = new DesignationMaster();
                        designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                        String EmpIdStr = request.getParameter("empid");
                        EmployeeMaster employeeMaster2 = new EmployeeMaster();
                        EmailTemplate emailTemplate1 = new EmailTemplate();
                        // id =9 for reject leave request...
                        emailTemplate1 = emailTemplateService.readById(9);
                        if (null != EmpIdStr && !"".equals(EmpIdStr)) {
                            int empID = Integer.parseInt(EmpIdStr);
                            List list = employeeMasterService.readByEmployeeNo(empID);
                            if (!list.isEmpty()) {
                                employeeMaster2 = (EmployeeMaster) list.get(0);
                                String To = employeeMaster2.getOfficeEmailId();
                                String from = employeeMasterModel.getOfficeEmailId();
                                String subject = emailTemplate1.getSubject();
                                subject = subject.replaceAll("\\{user\\}", employeeMaster2.getEmployeeName());
                                String msg = emailTemplate1.getBodytext();
                                msg = msg.replaceAll("\\{to_user\\}", employeeMaster2.getEmployeeName());
                                msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                                msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                                sendMail.sendMail(from, To, subject, msg);

                            }
                        }
                    } catch (Exception e) {
                    }
                }
                leaveEmployeeDetail.setStatus(2);
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String approveDate = sdf.format(date);
                leaveEmployeeDetail.setApproveDate(approveDate);
                leaveEmployeeDetailService.update(leaveEmployeeDetail);

            }
            if (btnSubmit.equals("rework")) {

                if (leaveEmployeeDetail.getStatus() == 4) {

                } else {
                    balanceDay = employeeLeaveBalance.getNoOfLeaveRemain();
                    noOfDay = leaveEmployeeDetail.getNoOfDays();
                    balanceDay = balanceDay + noOfDay;
                    employeeLeaveBalance.setNoOfLeaveRemain(balanceDay);
                    employeeLeaveBalanceService.update(employeeLeaveBalance);
                }
                leaveEmployeeDetail.setStatus(1);
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String approveDate = sdf.format(date);
                leaveEmployeeDetail.setApproveDate(approveDate);
                leaveEmployeeDetailService.update(leaveEmployeeDetail);

//                request.setAttribute("successMessage",
//                        "Information : The Leave Reworked successfully.");
                try {
                    EmployeeMaster employeeMasterModel = employeeMasterService.readById(userid);
                    DesignationMaster designationMaster = new DesignationMaster();
                    designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                    String EmpIdStr = request.getParameter("empid");
                    EmployeeMaster employeeMaster2 = new EmployeeMaster();
                    EmailTemplate emailTemplate1 = new EmailTemplate();
                    // id =8 for rework leave request...
                    emailTemplate1 = emailTemplateService.readById(8);
                    if (null != EmpIdStr && !"".equals(EmpIdStr)) {
                        int empID = Integer.parseInt(EmpIdStr);
                        List list = employeeMasterService.readByEmployeeNo(empID);
                        if (!list.isEmpty()) {
                            employeeMaster2 = (EmployeeMaster) list.get(0);
                            String To = employeeMaster2.getOfficeEmailId();
                            String from = employeeMasterModel.getOfficeEmailId();
                            String subject = emailTemplate1.getSubject();
                            subject = subject.replaceAll("\\{user\\}", employeeMaster2.getEmployeeName());
                            String msg = emailTemplate1.getBodytext();
                            msg = msg.replaceAll("\\{to_user\\}", employeeMaster2.getEmployeeName());
                            msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                            msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                            sendMail.sendMail(from, To, subject, msg);

                        }
                    }
                } catch (Exception e) {
                }

            }
            rcode = "1";
            message = "Success";
        } catch (Exception e) {
            rcode = "1";
            message = "Something went wrong";
            e.printStackTrace();
        }
        userData.put("responseMessage", message);
        userData.put("responseCode", rcode);
        out.print(userData);

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

    public boolean managercheck(int tabId, String MangerId, int i, int j) throws Exception {
        ModelAndView mv = new ModelAndView();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        boolean flag = false;
        List l1 = travelApproverHistoryService.readpreviousmanagerdata(tabId, MangerId);
        String lastApproveDateString = (String) l1.get(0);
        Date lastApproveDate = sdf.parse(lastApproveDateString);
        Calendar c1 = Calendar.getInstance();
        c1.setTime(lastApproveDate);
        c1.add(Calendar.DATE, i);
        Date managerapprove1 = c1.getTime();

        c1.setTime(managerapprove1);
        c1.add(Calendar.DATE, j);
        Date managerapprove2 = c1.getTime();

        String today = sdf.format(new Date());
        Date tDate = sdf.parse(today);

        if ((DateUtils.isSameDay(managerapprove1, tDate) || tDate.after(managerapprove1)) && (DateUtils.isSameDay(managerapprove2, tDate) || tDate.before(managerapprove2))) {
            flag = true;
        }

        return flag;
    }

    public void hrDashboard(HttpServletRequest request,
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
        int hrPendingList = 0;
        int LeavePendingList = 0;
        int ITPendingList = 0;
        int expensePendingList = 0;
        int travelPendingList = 0;
        int ARPendingList = 0;
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

            //////////////////// Leave 
            LeaveEmployeeDetail leaveEmployeeDetail = new LeaveEmployeeDetail();
            leaveEmployeeDetail.setEmployeeMaster(employeeMaster1);
            LeavePendingList = leaveEmployeeDetailService.readPendingApproverLeaveRequestForDashboard(leaveEmployeeDetail);

            /////////////////////AR 
            AttendanceRegularization attendanceRegularization = new AttendanceRegularization();
            attendanceRegularization.setId(employeeMaster1.getId());
            List<?> list1 = attendanceRegularizationMasterService.readByAttendanceRegularizationApproverPendingList(attendanceRegularization);
            ARPendingList = list1.size();

            //////////////////////expense 
            ExpenseMaster expenseMaster = new ExpenseMaster();
            List<?> travelTypeList = new ArrayList<Object>();
            List<?> relocationTypeList = new ArrayList<Object>();
            List<?> travelOtherTypeList = new ArrayList<Object>();
            List<?> relocationOtherTypeList = new ArrayList<Object>();
            List<?> policyOtherTypeList = new ArrayList<Object>();
            List<?> othersList = new ArrayList<Object>();

            List<?> reportingLevel1List = expenseMasterService.readExpenseRequestByReportingLevel1(expenseMaster, "" + employeeMaster1.getId());
            int level1List = reportingLevel1List.size();
            if (!reportingLevel1List.isEmpty()) {
                Iterator it = reportingLevel1List.iterator();
                while (it.hasNext()) {
                    Object[] next = (Object[]) it.next();
                    String expenseId = "" + next[0];
                    String expenseType = "" + next[4];
                    String pendingStatus = "" + next[5];
                    if (!pendingStatus.equals("0")) {
                        it.remove();
                    }
                    String flag3 = "true";
                    if (expenseType.equals("Travel")) {
                        travelTypeList = expenseTravelTypeService.readByExpenseMasterId(Integer.parseInt(expenseId));
                        for (Object o : travelTypeList) {
                            ExpenseTravelType expenseTravelType = (ExpenseTravelType) o;
                            if (expenseTravelType.getStatus() != 1) {
                                flag3 = "false";
                            }

                        }
                        travelOtherTypeList = relocationOrOtherExpenseService.readByExpenseMasterId(Integer.parseInt(expenseId));
                        for (Object o2 : travelOtherTypeList) {
                            RelocationOrOtherExpense relocationOrOtherExpense = (RelocationOrOtherExpense) o2;
                            if (relocationOrOtherExpense.getStatus() != 1) {
                                flag3 = "false";
                            }

                        }
                    }

                    if (expenseType.equals("Relocation")) {
                        relocationTypeList = expenseTravelTypeService.readByExpenseMasterId(Integer.parseInt(expenseId));
                        for (Object o3 : relocationTypeList) {
                            ExpenseTravelType expenseTravelType = (ExpenseTravelType) o3;
                            if (expenseTravelType.getStatus() != 1) {
                                flag3 = "false";
                            }

                        }
                        relocationOtherTypeList = relocationOrOtherExpenseService.readByExpenseMasterId(Integer.parseInt(expenseId));
                        for (Object o4 : relocationOtherTypeList) {
                            RelocationOrOtherExpense relocationOrOtherExpense = (RelocationOrOtherExpense) o4;
                            if (relocationOrOtherExpense.getStatus() != 1) {
                                flag3 = "false";
                            }
                        }
                    }
                    if (expenseType.equals("PolicyReimbursements")) {
                        policyOtherTypeList = relocationOrOtherExpenseService.readByExpenseMasterId(Integer.parseInt(expenseId));
                        for (Object policyReimb : policyOtherTypeList) {
                            RelocationOrOtherExpense relocationOrOtherExpense = (RelocationOrOtherExpense) policyReimb;
                            if (relocationOrOtherExpense.getStatus() != 1) {
                                flag3 = "false";
                            }
                        }
                    }
                    if (expenseType.equals("Others")) {
                        othersList = expenseOtherTypeService.readByExpenseMasterId(Integer.parseInt(expenseId));
                        for (Object o1 : othersList) {
                            ExpenseOtherType expenseOtherType = (ExpenseOtherType) o1;

                            if (expenseOtherType.getStatus() != 1) {
                                flag3 = "false";
                            }
                        }
                    }
                    try {

                        if (flag3.equals("true")) {
                            it.remove();
                        }
                    } catch (Exception e) {

                    }

                }
                expensePendingList = reportingLevel1List.size();

            }
            List<?> reportingLevel2List = expenseMasterService.readExpenseRequestByReportingLevel2(expenseMaster, "" + id);
            int level2List = reportingLevel2List.size();
            if (level1List == 0) {

                if (!reportingLevel2List.isEmpty()) {
                    Iterator it = reportingLevel2List.iterator();
                    while (it.hasNext()) {
                        Object[] next = (Object[]) it.next();
                        String expenseId = "" + next[0];
                        String expenseType = "" + next[4];
                        String pendingStatus = "" + next[5];
                        if (!pendingStatus.equals("0")) {
                            it.remove();
                        }
                        String flag3 = "true";
                        if (expenseType.equals("Travel")) {
                            travelTypeList = expenseTravelTypeService.readByExpenseMasterId(Integer.parseInt(expenseId));
                            for (Object o : travelTypeList) {
                                ExpenseTravelType expenseTravelType = (ExpenseTravelType) o;
                                if (expenseTravelType.getStatus() != 1) {
                                    flag3 = "false";
                                }

                            }
                            travelOtherTypeList = relocationOrOtherExpenseService.readByExpenseMasterId(Integer.parseInt(expenseId));
                            for (Object o2 : travelOtherTypeList) {
                                RelocationOrOtherExpense relocationOrOtherExpense = (RelocationOrOtherExpense) o2;
                                if (relocationOrOtherExpense.getStatus() != 1) {
                                    flag3 = "false";
                                }

                            }
                        }

                        if (expenseType.equals("Relocation")) {
                            relocationTypeList = expenseTravelTypeService.readByExpenseMasterId(Integer.parseInt(expenseId));
                            for (Object o3 : relocationTypeList) {
                                ExpenseTravelType expenseTravelType = (ExpenseTravelType) o3;
                                if (expenseTravelType.getStatus() != 1) {
                                    flag3 = "false";
                                }

                            }
                            relocationOtherTypeList = relocationOrOtherExpenseService.readByExpenseMasterId(Integer.parseInt(expenseId));
                            for (Object o4 : relocationOtherTypeList) {
                                RelocationOrOtherExpense relocationOrOtherExpense = (RelocationOrOtherExpense) o4;
                                if (relocationOrOtherExpense.getStatus() != 1) {
                                    flag3 = "false";
                                }
                            }
                        }
                        if (expenseType.equals("PolicyReimbursements")) {
                            policyOtherTypeList = relocationOrOtherExpenseService.readByExpenseMasterId(Integer.parseInt(expenseId));
                            for (Object policyReimb : policyOtherTypeList) {
                                RelocationOrOtherExpense relocationOrOtherExpense = (RelocationOrOtherExpense) policyReimb;
                                if (relocationOrOtherExpense.getStatus() != 1) {
                                    flag3 = "false";
                                }
                            }
                        }
                        if (expenseType.equals("Others")) {
                            othersList = expenseOtherTypeService.readByExpenseMasterId(Integer.parseInt(expenseId));
                            for (Object o1 : othersList) {
                                ExpenseOtherType expenseOtherType = (ExpenseOtherType) o1;
                                System.out.println("ajay" + expenseOtherType.getStatus());
                                if (expenseOtherType.getStatus() != 1) {
                                    flag3 = "false";
                                }
                            }
                        }
                        try {

                            if (flag3.equals("true")) {
                                it.remove();
                            }
                        } catch (Exception e) {

                        }
                    }
                    expensePendingList = reportingLevel1List.size();

                }
            }

            List<?> reportingLevel3List = expenseMasterService.readExpenseRequestByReportingLevel3(expenseMaster, "" + id);

            if (level1List == 0 && level2List == 0) {

                if (!reportingLevel3List.isEmpty()) {
                    Iterator it = reportingLevel3List.iterator();
                    while (it.hasNext()) {
                        Object[] next = (Object[]) it.next();
                        String expenseId = "" + next[0];
                        String expenseType = "" + next[4];
                        String pendingStatus = "" + next[5];
                        if (!pendingStatus.equals("0")) {
                            it.remove();
                        }
                        String flag3 = "true";
                        if (expenseType.equals("Travel")) {
                            travelTypeList = expenseTravelTypeService.readByExpenseMasterId(Integer.parseInt(expenseId));
                            for (Object o : travelTypeList) {
                                ExpenseTravelType expenseTravelType = (ExpenseTravelType) o;
                                if (expenseTravelType.getStatus() != 1) {
                                    flag3 = "false";
                                }

                            }
                            travelOtherTypeList = relocationOrOtherExpenseService.readByExpenseMasterId(Integer.parseInt(expenseId));
                            for (Object o2 : travelOtherTypeList) {
                                RelocationOrOtherExpense relocationOrOtherExpense = (RelocationOrOtherExpense) o2;
                                if (relocationOrOtherExpense.getStatus() != 1) {
                                    flag3 = "false";
                                }

                            }
                        }

                        if (expenseType.equals("Relocation")) {
                            relocationTypeList = expenseTravelTypeService.readByExpenseMasterId(Integer.parseInt(expenseId));
                            for (Object o3 : relocationTypeList) {
                                ExpenseTravelType expenseTravelType = (ExpenseTravelType) o3;
                                if (expenseTravelType.getStatus() != 1) {
                                    flag3 = "false";
                                }

                            }
                            relocationOtherTypeList = relocationOrOtherExpenseService.readByExpenseMasterId(Integer.parseInt(expenseId));
                            for (Object o4 : relocationOtherTypeList) {
                                RelocationOrOtherExpense relocationOrOtherExpense = (RelocationOrOtherExpense) o4;
                                if (relocationOrOtherExpense.getStatus() != 1) {
                                    flag3 = "false";
                                }
                            }
                        }
                        if (expenseType.equals("PolicyReimbursements")) {
                            policyOtherTypeList = relocationOrOtherExpenseService.readByExpenseMasterId(Integer.parseInt(expenseId));
                            for (Object policyReimb : policyOtherTypeList) {
                                RelocationOrOtherExpense relocationOrOtherExpense = (RelocationOrOtherExpense) policyReimb;
                                if (relocationOrOtherExpense.getStatus() != 1) {
                                    flag3 = "false";
                                }
                            }
                        }
                        if (expenseType.equals("Others")) {
                            othersList = expenseOtherTypeService.readByExpenseMasterId(Integer.parseInt(expenseId));
                            for (Object o1 : othersList) {
                                ExpenseOtherType expenseOtherType = (ExpenseOtherType) o1;
                                System.out.println("ajay" + expenseOtherType.getStatus());
                                if (expenseOtherType.getStatus() != 1) {
                                    flag3 = "false";
                                }
                            }
                        }
                        try {

                            if (flag3.equals("true")) {
                                it.remove();
                            }
                        } catch (Exception e) {

                        }
                    }
                    expensePendingList = reportingLevel1List.size();

                }
            }

            /////////////////////////////////travel
            int loginempId = employeeMaster1.getId();
            String loginId = employeeMaster1.getId().toString();
            EmployeeMaster employeeMaster2 = new EmployeeMaster();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            TravelRequestMaster travelRequestMaster = new TravelRequestMaster();
            List<Object> finalList = new ArrayList<>();
            List<Object> finalList1 = new ArrayList<>();
            boolean flag = false;
            List<?> list = travelRequestMasterService.readListForApprover(travelRequestMaster, employeeMaster1.getId());
            if (!list.isEmpty()) {
                for (Object obj : list) {
                    Object[] o1 = (Object[]) obj;
                    int employeeId = (int) o1[0];
                    int tabId = (int) o1[1];
                    int status = (int) o1[8];
                    if (status == 0 || status == 1 || status == 3 || status == 4 || status == 6 || status == 10
                            || status == 11) {
                        employeeMaster2 = employeeMasterService.readById(employeeId);
                        String manager1 = employeeMaster2.getReportingManagerLevel1();
                        String manager2 = employeeMaster2.getReportingManagerLevel2();
                        String manager3 = employeeMaster2.getReportingManagerLevel3();
                        String manager4 = employeeMaster2.getReportingManagerLevel4();
                        String manager5 = employeeMaster2.getReportingManagerLevel5();
                        String aprroverid = "";
                        int ReturnFlag = 0;
                        int historyappid = 0;
                        int historyappid1 = 0;
                        if (status != 0) {
                            if (status != 10) {
                                aprroverid = "" + o1[10];
                            }
                        }
                        List<?> approverList = travelApproverHistoryService.readapproverlist(tabId, loginId);
                        for (Object o : approverList) {
                            TravelApproverHistory travelApproverHistory = new TravelApproverHistory();
                            travelApproverHistory = (TravelApproverHistory) o;
                            ReturnFlag = travelApproverHistory.getReturnFlag();
                            if (ReturnFlag == 0) {
                                historyappid = travelApproverHistory.getEmployeeMasterByTravelApproverId().getId();
                            }
                            if (ReturnFlag == 1) {
                                historyappid1 = travelApproverHistory.getEmployeeMasterByTravelApproverId().getId();
                            }
                        }
                        if ((status == 3 && ReturnFlag == 0) || status == 0 || status == 10 || status == 1) {
                            String dos1 = o1[9].toString();
                            Date dos = sdf.parse(dos1);
                            String today = sdf.format(new Date());
                            Date tDate = sdf.parse(today);
                            Calendar c = Calendar.getInstance();
                            c.setTime(dos);
                            c.add(Calendar.DATE, 7);
                            Date Date7 = c.getTime();
                            c.setTime(Date7);
                            c.add(Calendar.DATE, 7);
                            Date Date14 = c.getTime();
                            c.setTime(Date14);
                            c.add(Calendar.DATE, 7);
                            Date Date21 = c.getTime();
                            c.setTime(Date21);
                            c.add(Calendar.DATE, 7);
                            Date Date28 = c.getTime();
                            c.setTime(Date28);
                            c.add(Calendar.DATE, 7);
                            Date Date35 = c.getTime();

                            if (Integer.parseInt(manager1) == Integer.parseInt(loginId)) {
                                if ((DateUtils.isSameDay(dos, tDate) || tDate.after(dos)) && tDate.before(Date7)) {
                                    finalList.add(obj);
                                }
                            }
                            if (!manager2.isEmpty() && !manager1.isEmpty()) {
                                if (Integer.parseInt(manager2) == Integer.parseInt(loginId)) {
                                    if (historyappid != 0) {
                                        if (Integer.parseInt(loginId) == historyappid) {
                                            finalList.add(obj);
                                        }
                                    }
                                    if (aprroverid == null || aprroverid == "") {
                                        if ((DateUtils.isSameDay(Date7, tDate) || tDate.after(Date7)) && tDate.before(Date14)) {
                                            finalList.add(obj);
                                        }
                                    } else if (status != 1) {
                                        if (Integer.parseInt(aprroverid) == Integer.parseInt(manager1)) {
                                            finalList.add(obj);
                                        }
                                    }
                                }
                            }
                            if (!manager3.isEmpty() && !manager2.isEmpty() && !manager1.isEmpty()) {
                                if (Integer.parseInt(manager3) == Integer.parseInt(loginId)) {
                                    if (historyappid != 0) {
                                        if (Integer.parseInt(loginId) == historyappid) {
                                            finalList.add(obj);
                                        }
                                    }
                                    if (aprroverid == null || aprroverid == "") {
                                        if ((DateUtils.isSameDay(Date14, tDate) || tDate.after(Date14)) && tDate.before(Date21)) {
                                            finalList.add(obj);
                                        }
                                    } else if (status != 1) {
                                        if (Integer.parseInt(aprroverid) == Integer.parseInt(manager2)) {
                                            finalList.add(obj);
                                        } else if (Integer.parseInt(aprroverid) == Integer.parseInt(manager1)) {
                                            boolean checklastapprovedateflag = managercheck(tabId, manager1, 7, 7);
                                            if (tDate.before(Date21) && checklastapprovedateflag == true) {
                                                finalList.add(obj);
                                            }
                                        }
                                    }
                                }
                            }
                            if (!manager4.isEmpty() && !manager3.isEmpty() && !manager2.isEmpty() && !manager1.isEmpty()) {
                                if (Integer.parseInt(manager4) == Integer.parseInt(loginId)) {
                                    if (historyappid != 0) {
                                        if (Integer.parseInt(loginId) == historyappid) {
                                            finalList.add(obj);
                                        }
                                    }
                                    if (aprroverid == null || aprroverid == "") {
                                        if ((DateUtils.isSameDay(Date21, tDate) || tDate.after(Date21)) && tDate.before(Date28)) {
                                            finalList.add(obj);
                                        }
                                    } else if (status != 1) {
                                        if (Integer.parseInt(aprroverid) == Integer.parseInt(manager3)) {
                                            finalList.add(obj);
                                        } else if (Integer.parseInt(aprroverid) == Integer.parseInt(manager2)) {
                                            boolean checklastapprovedateflag = managercheck(tabId, manager2, 7, 7);
                                            if (tDate.before(Date28) && checklastapprovedateflag == true) {
                                                finalList.add(obj);
                                            }
                                        } else if (Integer.parseInt(aprroverid) == Integer.parseInt(manager1)) {
                                            boolean checklastapprovedateflag1 = managercheck(tabId, manager1, 14, 7);
                                            if (tDate.before(Date28) && checklastapprovedateflag1 == true) {
                                                finalList.add(obj);
                                            }
                                        }
                                    }
                                }
                            }
                            if (!manager5.isEmpty()) {
                                if (Integer.parseInt(manager5) == Integer.parseInt(loginId)) {
                                    if (historyappid != 0 || status == 8) {
                                        if (Integer.parseInt(loginId) == historyappid) {
                                            finalList.add(obj);
                                        }
                                    }
                                    if (aprroverid == null || aprroverid == "") {
                                        if ((DateUtils.isSameDay(Date28, tDate) || tDate.after(Date28)) && tDate.before(Date35)) {
                                            finalList.add(obj);
                                        }
                                    } else if (!manager4.isEmpty()) {
                                        if (status != 1) {
                                            if (Integer.parseInt(aprroverid) == Integer.parseInt(manager4)) {
                                                finalList.add(obj);
                                            }
                                        }
                                        if (!manager3.isEmpty()) {
                                            if (status != 1) {
                                                if (Integer.parseInt(aprroverid) == Integer.parseInt(manager3)) {
                                                    boolean checklastapprovedateflag = managercheck(tabId, manager3, 7, 7);
                                                    if (tDate.before(Date21) && checklastapprovedateflag == true) {
                                                        finalList.add(obj);
                                                    }
                                                } else if (!manager2.isEmpty()) {
                                                    if (Integer.parseInt(aprroverid) == Integer.parseInt(manager2)) {
                                                        boolean checklastapprovedateflag = managercheck(tabId, manager2, 14, 7);
                                                        if (checklastapprovedateflag == true) {
                                                            finalList.add(obj);
                                                        }
                                                    }
                                                } else if (!manager1.isEmpty()) {
                                                    if (Integer.parseInt(aprroverid) == Integer.parseInt(manager1)) {
                                                        boolean checklastapprovedateflag = managercheck(tabId, manager1, 21, 7);
                                                        if (checklastapprovedateflag == true) {
                                                            finalList.add(obj);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    } else if (manager4 == null || manager4 == "") {
                                        if (!manager3.isEmpty()) {
                                            if (status != 1) {
                                                if (Integer.parseInt(aprroverid) == Integer.parseInt(manager3)) {
                                                    boolean checklastapprovedateflag = managercheck(tabId, manager3, 0, 7);
                                                    if (tDate.before(Date21) && checklastapprovedateflag == true) {
                                                        finalList.add(obj);
                                                    }
                                                } else if (!manager2.isEmpty()) {
                                                    if (Integer.parseInt(aprroverid) == Integer.parseInt(manager2)) {
                                                        boolean checklastapprovedateflag = managercheck(tabId, manager2, 7, 7);
                                                        if (checklastapprovedateflag == true) {
                                                            finalList.add(obj);
                                                        }
                                                    }
                                                } else if (!manager1.isEmpty()) {
                                                    if (Integer.parseInt(aprroverid) == Integer.parseInt(manager1)) {
                                                        boolean checklastapprovedateflag = managercheck(tabId, manager1, 14, 7);
                                                        if (checklastapprovedateflag == true) {
                                                            finalList.add(obj);
                                                        }
                                                    }
                                                }
                                            }
                                        } else if (manager3 == null || manager3 == "") {
                                            if (!manager2.isEmpty()) {
                                                if (status != 1) {
                                                    if (Integer.parseInt(aprroverid) == Integer.parseInt(manager2)) {
                                                        boolean checklastapprovedateflag = managercheck(tabId, manager2, 0, 7);
                                                        if (checklastapprovedateflag == true) {
                                                            finalList.add(obj);
                                                        }
                                                    } else if (!manager1.isEmpty()) {
                                                        if (Integer.parseInt(aprroverid) == Integer.parseInt(manager1)) {
                                                            boolean checklastapprovedateflag = managercheck(tabId, manager1, 7, 7);
                                                            if (checklastapprovedateflag == true) {
                                                                finalList.add(obj);
                                                            }
                                                        }
                                                    }
                                                }
                                            } else if (manager2 == null || manager2 == "") {
                                                if (!manager1.isEmpty()) {
                                                    if (status != 1) {
                                                        if (Integer.parseInt(aprroverid) == Integer.parseInt(manager1)) {
                                                            if (Integer.parseInt(aprroverid) == Integer.parseInt(manager1)) {
                                                                boolean checklastapprovedateflag = managercheck(tabId, manager1, 0, 7);
                                                                finalList.add(obj);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        } else if (status == 6 || status == 5) {
                            try {

                                if (Integer.parseInt(loginId) == Integer.parseInt(manager1)
                                        || Integer.parseInt(loginId) == Integer.parseInt(manager5)) {
                                    finalList.add(obj);
                                } else if (!manager2.isEmpty()) {
                                    if (Integer.parseInt(loginId) == Integer.parseInt(manager2)) {
                                        finalList.add(obj);
                                    }
                                } else if (!manager3.isEmpty()) {
                                    if (Integer.parseInt(loginId) == Integer.parseInt(manager3)) {
                                        finalList.add(obj);
                                    }
                                } else if (!manager4.isEmpty()) {
                                    if (Integer.parseInt(loginId) == Integer.parseInt(manager4)) {
                                        finalList.add(obj);
                                    }
                                }
                            } catch (Exception e) {

                            }
                        }
                    }
                }
                if (!finalList.isEmpty()) {
                    for (Object obj : finalList) {
                        Object[] o1 = (Object[]) obj;
                        int employeeId = (int) o1[0];
                        int tabId = (int) o1[1];
                        int status = (int) o1[8];
                        if (status == 3) {
                            List approverList = travelApproverHistoryService.readapproverlist(tabId, loginId);
                            for (Object o : approverList) {
                                TravelApproverHistory travelApproverHistory = new TravelApproverHistory();
                                travelApproverHistory = (TravelApproverHistory) o;
                                int prevStatus = travelApproverHistory.getTravelApproveStatus();
                                int prevflag = travelApproverHistory.getReturnFlag();
                                int tbId = travelApproverHistory.getTravelRequestMaster().getId();
//                          in both take list[10] as approverid list[11] appname
                                if (prevflag == 0) {
                                    List<?> newfinallist = travelRequestMasterService.readlastapprove(tbId, loginId);
                                    flag = true;
                                    finalList1.add(newfinallist.get(0));
                                    break;
                                }
                            }
                            if (approverList.size() == 0) {
//                                    List<Object> l1 = new ArrayList<>();
//                                    l1.add(obj);
                                finalList1.add(obj);
                            }
                        } else {
//                                    List<Object> l1 = new ArrayList<>();
//                                    l1.add(obj);
                            finalList1.add(obj);
                        }
                    }
                }
            }
            Set<Object> foo = new HashSet<Object>(finalList1);
            List<Object> list111 = new ArrayList<Object>(foo);
            for (Iterator<Object> iterator = list111.iterator(); iterator.hasNext();) {
                try {
                    Object[] next = (Object[]) iterator.next();
                    String status = "" + next[8];
                    String historystatus = "";
                    if (next.length == 14) {

                        historystatus = "" + next[13];
                        if (Integer.parseInt(status) == 0 || (Integer.parseInt(status) == 3 && !historystatus.equals("0"))) {
                        } else {
                            iterator.remove();

                        }
                    } else if (Integer.parseInt(status) == 0 || Integer.parseInt(status) == 3 || Integer.parseInt(status) == 10) {
                    } else {
                        iterator.remove();
                    }
                } catch (Exception e) {

                }
            }
            travelPendingList = list111.size();

            /////////////////////it 
            ItServiceRequest itServiceRequest = new ItServiceRequest();
            itServiceRequest.setEmployeeMasterByEmployeeMasterId(employeeMaster1);
            List<?> listIT = itServiceRequestService.readByItServiceApproverPendingRequest(itServiceRequest);
            ITPendingList = listIT.size();

            //////////////////////hr 
            HrServiceRequest hrServiceRequest = new HrServiceRequest();
            hrServiceRequest.setEmployeeMasterByEmployeeMasterId(employeeMaster1);
            List<?> listHR = hrServiceRequestService.readHrServiceApproverPendingRequest(hrServiceRequest);
            hrPendingList = listHR.size();

        } catch (Exception exception) {
            rcode = "0";
            message = "Error";
        }
        rcode = "1";
        message = "Success";

        data.put("LeaveModule", LeavePendingList);
        data.put("hrModule", hrPendingList);
        data.put("ArModule", ARPendingList);
        data.put("ItModule", ITPendingList);
        data.put("TravelModule", travelPendingList);
        data.put("ExpenseModule", expensePendingList);
        data.put("responseMessage", message);
        data.put("responseCode", rcode);
        out.print(data);

    }
}
