/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.webservice;

import com.bul.zydex.model.AttendanceRegularization;
import com.bul.zydex.model.COffLeaveMaster;
import com.bul.zydex.model.Company;
import com.bul.zydex.model.DepartmentMaster;
import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.model.EmailAddMaster;
import com.bul.zydex.model.EmailTemplate;
import com.bul.zydex.model.EmployeeAdvanceSearch;
import com.bul.zydex.model.EmployeeDatetimeData;
import com.bul.zydex.model.EmployeeLeaveBalance;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.EmployeeShiftData;
import com.bul.zydex.model.ExpenseMaster;
import com.bul.zydex.model.ExpenseOtherType;
import com.bul.zydex.model.ExpenseTravelType;
import com.bul.zydex.model.HolidayMaster;
import com.bul.zydex.model.HoursBasis;
import com.bul.zydex.model.HrServiceRequest;
import com.bul.zydex.model.ItServiceRequest;
import com.bul.zydex.model.LeaveEmployeeDetail;
import com.bul.zydex.model.LeaveTypeMaster;
import com.bul.zydex.model.LevelMaster;
import com.bul.zydex.model.LocationMaster;
import com.bul.zydex.model.OTRegularization;
import com.bul.zydex.model.OverTimeMaster;
import com.bul.zydex.model.RelocationOrOtherExpense;
import com.bul.zydex.model.ShiftMaster;
import com.bul.zydex.model.ShiftRotationInfo;
import com.bul.zydex.model.ShiftRotationMaster;
import com.bul.zydex.model.TimeAttandanceFlaxibleMaster;
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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
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
import org.springframework.validation.BindException;
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
                String reportingManager = "";
                String reportingManagerId = "";
                if(null != reportingId && !reportingId.equals(""))
                {
                    EmployeeMaster employeeMaster2 = employeeMasterService.readById(Integer.parseInt(""+reportingId));
                    reportingManager = employeeMaster2.getEmployeeName();
                    reportingManagerId = employeeMaster2.getEmployeeId();
                }
                
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
                        obj.put("holiday_id", ""+(i+1));
                        obj.put("title", title);
                        obj.put("startdate", Startdate);
                        obj.put("enddate", Enddate);
                        obj.put("location", ""+arrayOfObject[3]);
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

    public void submitLeaveRequestVadera(HttpServletRequest request,
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
    
    public String checkPresentOnSDateWebService(EmployeeMaster employeeMasterTemp, String strDate, String sDateStatus) throws Exception {
//        String strDate = request.getParameter("strDate");
//        String sDateStatus = request.getParameter("sDateStatus");
        //strDate = strDate.replaceAll(",", "/");
        EmployeeShiftData employeeShiftData = new EmployeeShiftData();
        //HttpSession session = request.getSession();
        EmployeeMaster employeeMaster1 = employeeMasterTemp;//(EmployeeMaster) session.getAttribute("employeeInfo");

        String message = "";
        if (sDateStatus.equals("Fullday")) {
            employeeShiftData.setOutDateTime(strDate);
            employeeShiftData.setEmployeeMaster(employeeMaster1);
            List<?> list = employeeShiftDataService.checkTodayPresent(employeeShiftData);
            EmployeeShiftData employeeShiftData1 = new EmployeeShiftData();
            if (!list.isEmpty()) {
                employeeShiftData1 = (EmployeeShiftData) list.get(0);

                String sDate = employeeShiftData1.getInDateTime();
                String eDate = employeeShiftData1.getOutDateTime();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

                Date iDate = sdf.parse(sDate);
                Date oDate = sdf.parse(eDate);
                long diff = oDate.getTime() - iDate.getTime();

                long diffHours = diff / (60 * 60 * 1000) % 24;

//                if (list.size() > 0 && employeeShiftData1.getShiftMaster().getId() != 5) {
                if (diffHours > 4 && employeeShiftData1.getShiftMaster().getId() != 5) {
                    message = "On This Day You Are Present";
                }
            }
        }
        return message;
//        PrintWriter out = response.getWriter();
//        out.print(message);
    }
    
    public String checkWorkingValidationSDateWebService(String strDate, String endDate) throws Exception {
//        String strDate = request.getParameter("strDate");
//        String endDate = request.getParameter("enDate");
        String message = "";
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");

        Date date3;
        Date date4;

        SimpleDateFormat dates1 = new SimpleDateFormat("dd/MM/yyyy");

        //Setting dates
        date3 = dates1.parse(endDate);
        date4 = dates1.parse(strDate);

        //Comparing dates
        long difference1 = Math.abs(date3.getTime() - date4.getTime());
        long differenceDates1 = difference1 / (24 * 60 * 60 * 1000);

        //Convert long to String
        String leaveDiff = Long.toString(differenceDates1);

        EnumSet<DayOfWeek> weekend = EnumSet.of(DayOfWeek.of(7), DayOfWeek.of(6));
        List<LocalDate> list = new ArrayList();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate start = LocalDate.parse(strDate, dateTimeFormatter);
        LocalDate end = LocalDate.parse(endDate, dateTimeFormatter);

        while (start.compareTo(end) <= 0) {
            if (!weekend.contains(start.getDayOfWeek())) {
                list.add(start);
            }
            start = start.plus(1, ChronoUnit.DAYS);
        }
        int listwithout = list.size();

        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        Date cDate1 = new Date();
        String CurrentDate = sdf1.format(cDate1);

        Date date1;
        Date date2;

        SimpleDateFormat dates = new SimpleDateFormat("dd/MM/yyyy");

        //Setting dates
        date1 = dates.parse(CurrentDate);
        date2 = dates.parse(strDate);

        //Comparing dates
        long difference = Math.abs(date1.getTime() - date2.getTime());
        long differenceDates = difference / (24 * 60 * 60 * 1000);

        //Convert long to String
        String dayDifference = Long.toString(differenceDates);

        if (2 != Integer.parseInt(dayDifference) && 2 >= Integer.parseInt(dayDifference)) {
            message = "Leave request should be done in advance as Per Policy";

        } else if (3 <= listwithout && 2 == listwithout) {

            if (5 != Integer.parseInt(dayDifference) && 5 >= Integer.parseInt(dayDifference)) {
                message = "Leave request should be done in advance as Per Policy";

            }

        } else if (4 <= listwithout) {
            if (15 != Integer.parseInt(dayDifference) && 15 >= Integer.parseInt(dayDifference)) {
                message = "Leave request should be done in advance as Per Policy";

            }
        }
//        PrintWriter out = response.getWriter();
//        out.print(message);
        return message;
    }
    
    public void submitLeaveRequest(HttpServletRequest request, HttpServletResponse response) throws JSONException, IOException, ServletException, ParseException 
    {
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
                employeeMaster = (EmployeeMaster) empDetailList.get(0);
            }
            
            LeaveTypeMaster leaveTypeMaster = new LeaveTypeMaster();
            String leavetypeid = data.get("leaveId").toString();
            leaveTypeMaster.setId(Integer.parseInt(leavetypeid));
            LeaveEmployeeDetail leaveEmployeeDetail = new LeaveEmployeeDetail();
            leaveEmployeeDetail.setEmployeeMaster(employeeMaster);
            leaveEmployeeDetail.setLeaveTypeMaster(leaveTypeMaster);
            leaveEmployeeDetail.setStartDate(data.get("startDate").toString());
            leaveEmployeeDetail.setEndDate(data.get("endDate").toString());
            //leaveEmployeeDetail.setNoOfDays(Float.parseFloat(data.get("noOfDay").toString()));
            leaveEmployeeDetail.setEmpRemark(data.get("remark").toString());
            leaveEmployeeDetail.setStartDateStatus(data.get("startDayType").toString());
            leaveEmployeeDetail.setEndDateStatus(data.get("endDayType").toString());

            //Float noOfDay = Float.parseFloat(data.get("noOfDay").toString());

//               #########check present##################
            String strDate = (data.get("startDate").toString()).replaceAll(",", "/");
            String enDate = (data.get("endDate").toString()).replaceAll(",", "/");
            //String strDatestaus = (data.get("startDayType").toString());
            //String enDatestatus = (data.get("endDayType").toString());
            
            //============= get no of actual holiday days in these ======================
            //String strDate = request.getParameter("strDate");
            //String enDate = request.getParameter("enDate");
            String sDateStatus = data.get("startDayType").toString();//request.getParameter("startDayPart");////sDateStatus");
            //String eDateStatus = data.get("endDayType").toString();//request.getParameter("endDayPart");////eDateStatus");
            //-------- Validatataion check --------
            String tempString = ""+checkWorkingValidationSDateWebService(strDate, enDate);
            if(!tempString.equals(""))
            {
                rcode = "0";
                message = tempString;
                userData.put("responseMessage", message);
                userData.put("responseCode", rcode);
                out.print(userData);
                return;
            }
            
            tempString = checkPresentOnSDateWebService(employeeMaster, strDate, data.get("startDayType").toString());
            if(!tempString.equals(""))
            {
                rcode = "0";
                message = tempString;
                userData.put("responseMessage", message);
                userData.put("responseCode", rcode);
                out.print(userData);
                return;
            }
            tempString = checkPresentOnSDateWebService(employeeMaster, enDate, data.get("endDayType").toString());
            if(!tempString.equals(""))
            {
                rcode = "0";
                message = tempString;
                userData.put("responseMessage", message);
                userData.put("responseCode", rcode);
                out.print(userData);
                return;
            }
            //---------------
            
            SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
            Date sDate2 = sdf2.parse(strDate);
            Date eDate2 = sdf2.parse(enDate);
            Date today = new Date();

            String weekOffDay = "";

            weekOffDay = "Saturday,Sunday";

            int coutnter = 0;
            boolean sundayCheck = false;
            Calendar c = Calendar.getInstance();
            c.setTime(sDate2);
            List<String> list1 = new ArrayList<String>();
            float days2 = 0;
            while (c.getTime().before(eDate2) || c.getTime().equals(eDate2)) {

                Calendar calForEnddate = Calendar.getInstance();
                calForEnddate.setTime(eDate2);
                int dayEnd = calForEnddate.get(Calendar.DAY_OF_WEEK);

    //              
    ////                    if (c.get(Calendar.DAY_OF_WEEK) != weekOff) {
                int dayOfWeek = c.get(Calendar.WEEK_OF_MONTH);
                Date nDate = c.getTime();
                String daString = sdf2.format(nDate);
                HolidayMaster holidayMaster = new HolidayMaster();
                holidayMaster.setHolidayFromDate(daString);
                List list = holidayMasterService.checkHoliday(daString, "" + employeeMaster.getLocationMaster().getId());
                if (list.size() == 0) {
                    days2++;
                }
                for (String z : weekOffDay.split(",")) {
                    int weekOff = 0;
                    if (!z.equals("")) {
                        if (z.equals("Sunday")) {
                            weekOff = 1;
    //                        sundayCheck = true;
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
                        } else if (z.equals("Saturday")) {
                            weekOff = 7;
                        }
                    }
                    if (c.get(Calendar.DAY_OF_WEEK) != weekOff) {
                        if (c.get(Calendar.DAY_OF_WEEK) == 7 && coutnter == 0) {
                            if (sDateStatus.contains("SecondHalf")) {
                                if (!strDate.equals(enDate)) {
                                    days2--;
                                }
                            }
                        }
                    }
                    if (!leavetypeid.equals("6") && !leavetypeid.equals("7") && !leavetypeid.equals("16") && !leavetypeid.equals("12") && !leavetypeid.equals("11")) {
                        if (c.get(Calendar.DAY_OF_WEEK) == 7 && !sDateStatus.contains("SecondHalf")) {
                            if (!strDate.equals(enDate)) {
                                days2--;
                            }
                        }
                    }
                    if (c.get(Calendar.DAY_OF_WEEK) == weekOff) {
                        days2--;
                    }
                    coutnter++;
                }
                c.add(Calendar.DATE, 1);
            }

//            PrintWriter out = response.getWriter();

//            userData.put("responseMessage", message);
//            userData.put("responseCode", rcode);
//            
//            data.put("days", days);
//            out.print(days);
            
            if (days2 == 0.0 && leavetypeid.equals("7")) {
                rcode = "0";
                message = "Future Date Must be Selected";
                userData.put("responseMessage", message);
                userData.put("responseCode", rcode);
                out.print(userData);
                return;
            }
            
            
            
            leaveEmployeeDetail.setNoOfDays(days2);
            Float noOfDay = days2;
            //============================================================
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
        //==================
        ModelAndView mv = new ModelAndView();
        //LeaveEmployeeDetail leaveEmployeeDetail = new LeaveEmployeeDetail();
        //LeaveTypeMaster leaveTypeMaster = new LeaveTypeMaster();
        BindException errors = new BindException(leaveEmployeeDetail, "leaveEmployeeDetail");
        //bind(request, leaveEmployeeDetail);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        //UserMaster user = (UserMaster) request.getSession().getAttribute("user");
        //EmployeeMaster employeeMaster = new EmployeeMaster();
        employeeMaster.setUserMaster(user);
        EmployeeLeaveBalance employeeLeaveBalance = new EmployeeLeaveBalance();
        EmployeeLeaveBalance employeeLeaveBalance1 = new EmployeeLeaveBalance();
        Float balanceDay;
        //Float noOfDay;
        List<?> empId = employeeMasterService.readByUserName(employeeMaster);
        if (!empId.isEmpty()) {
            employeeMaster = (EmployeeMaster) empId.get(0);
        }
//        leaveEmployeeDetail.setLeaveTypeMaster(leaveTypeMaster);
        String sDate = (data.get("startDate").toString()).replaceAll(",", "/");//data.get("startDate").toString();//request.getParameter("startDate");
        String eDate = (data.get("endDate").toString()).replaceAll(",", "/");//request.getParameter("endDate");
        String leaveType = leavetypeid;//request.getParameter("leaveTypeMaster.id");
        //String strDateStatus = request.getParameter("leaveStartDate_SelectFullOrHalfId");
        //String endDateStatus = request.getParameter("leaveEndDate_SelectFullOrHalfId");
        //String taskAssignTo = request.getParameter("taskAssignTo");
//        leaveEmployeeDetail.setStartDateStatus(strDateStatus);
//        leaveEmployeeDetail.setEndDateStatus(endDateStatus);
//        leaveEmployeeDetail.setEmployeeMaster(employeeMaster);
//        leaveEmployeeDetail.setTaskAssignTo(taskAssignTo);
        SimpleDateFormat format1 = new SimpleDateFormat("d/M/yyyy");
        Date date11 = format1.parse(sDate);
        String ssDate = format1.format(date11);
        Date date12 = format1.parse(eDate);
        String eeDate = format1.format(date12);
        String sDay = ssDate.split("/")[0];
        String sMonth = ssDate.split("/")[1];
        String sYear = ssDate.split("/")[2];
        String eDay = eeDate.split("/")[0];
        String eMonth = eeDate.split("/")[1];
        String eYear = eeDate.split("/")[2];
        List<?> shiftValueInsDate = new ArrayList<>();
        List<?> shiftValueIneDate = new ArrayList<>();
        String data1 = employeeMaster.getId() + ":" + sDay + ":" + sMonth + ":" + sYear;
        String data2 = employeeMaster.getId() + ":" + eDay + ":" + eMonth + ":" + eYear;
        if (!sDate.isEmpty()) {
            shiftValueInsDate = shiftGenerateMonthlyScheduleService.shiftValueInsDate(data1);
        }
        if (!eDate.isEmpty()) {
            shiftValueIneDate = shiftGenerateMonthlyScheduleService.shiftValueInsDate(data2);
        }
        String shiftValueInsDate1 = "";
        String shiftValueIneDate1 = "";
        if (!shiftValueInsDate.isEmpty()) {
            shiftValueInsDate1 = shiftValueInsDate.get(0).toString();
        }
        if (!shiftValueIneDate.isEmpty()) {
            shiftValueIneDate1 = shiftValueIneDate.get(0).toString();
        }
        Date date;
        Date oneDayBefore;
        String dateBeforeOfsDate = "";
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        if (!sDate.isEmpty()) {
            date = format.parse(sDate);
            oneDayBefore = new Date(date.getTime() - 2);
            dateBeforeOfsDate = format.format(oneDayBefore);
        }
        Date date1;
        Date tomorrow;
        String dateAfterOfeDate = "";
        if (!sDate.isEmpty()) {
            date1 = format.parse(eDate);
            calendar.setTime(date1);
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            tomorrow = calendar.getTime();
            dateAfterOfeDate = format.format(tomorrow);
        }
        String data3 = employeeMaster.getId() + ":" + dateBeforeOfsDate + ":" + dateAfterOfeDate;
        List<?> beforesDateCasualLeave = new ArrayList<>();
        List<?> aftereDateCasualLeave = new ArrayList<>();
        if (!dateBeforeOfsDate.isEmpty() && !dateAfterOfeDate.isEmpty()) {
            beforesDateCasualLeave = shiftGenerateMonthlyScheduleService.beforesDateCasualLeave(data3);
            aftereDateCasualLeave = shiftGenerateMonthlyScheduleService.aftereDateCasualLeave(data3);
        }
        List<?> beforesDate = new ArrayList<>();
        List<?> aftereDate = new ArrayList<>();
        List<?> beforesDate1 = new ArrayList<>();
        List<?> aftereDate1 = new ArrayList<>();
        if (!dateBeforeOfsDate.isEmpty() && !dateAfterOfeDate.isEmpty()) {
            beforesDate = shiftGenerateMonthlyScheduleService.getbeforesDate(data3);
            aftereDate = shiftGenerateMonthlyScheduleService.getaftereDate(data3);
            beforesDate1 = shiftGenerateMonthlyScheduleService.getbeforesDate1(data3);
            aftereDate1 = shiftGenerateMonthlyScheduleService.getaftereDate1(data3);
        }
        leaveEmployeeDetailValidator.validate(mv, errors);
        if (leaveEmployeeDetail.getLeaveTypeMaster().getId() != null) {
            if (leaveEmployeeDetail.getLeaveTypeMaster().getId() == (11)) {
                if (leaveEmployeeDetail.getNoOfDays() == 0.8) {
                    leaveEmployeeDetail.setNoOfDays(Float.parseFloat("" + 1));
                }
            }
        }
        if (errors.hasErrors()) {
            //request.setAttribute("failureMessage",
                //    "Error : The Entered Information is not valid.");
            /// Because for Short Leave
//            leaveEmployeeDetail.setStartDate("");
//            leaveEmployeeDetail.setEndDate("");
            /// Because for Short Leave
//            mv.getModelMap().put("leaveEmployeeDetail", leaveEmployeeDetail);
//            request.setAttribute("leaveEmployeeDetail", leaveEmployeeDetail);
//            mv.addAllObjects(errors.getModel());
//            mv = applyClick(request, response);
            // Failure responce will be there
            rcode = "12";
            message = "The Entered Information is not valid.";
            userData.put("responseMessage", message);
            userData.put("responseCode", rcode);
            out.print(userData);
        } else if (leaveType.equals("6") && (!beforesDate.isEmpty() || !aftereDate.isEmpty())) {
//            request.setAttribute("failureMessage",
//                    "Error : Casual Leave and Privilege Leave cannot combine.");
//            request.setAttribute("leaveEmployeeDetail", leaveEmployeeDetail);
//            mv = applyClick(request, response);
            // Failure responce will be there
            rcode = "12";
            message = "Casual Leave and Privilege Leave cannot combine.";
            userData.put("responseMessage", message);
            userData.put("responseCode", rcode);
            out.print(userData);
        } else if (leaveType.equals("7") && (!beforesDate1.isEmpty() || !aftereDate1.isEmpty())) {
//            request.setAttribute("failureMessage",
//                    "Error : Casual Leave and Privilege Leave cannot combine.");
//            request.setAttribute("leaveEmployeeDetail", leaveEmployeeDetail);
//            mv = applyClick(request, response);
            // Failure responce will be there
            rcode = "12";
            message = "Casual Leave and Privilege Leave cannot combine.";
            userData.put("responseMessage", message);
            userData.put("responseCode", rcode);
            out.print(userData);
        } else if (shiftValueInsDate1.equals("-1") || shiftValueIneDate1.equals("-1")) {
//            request.setAttribute("failureMessage",
//                    "Error : You Cannot Apply Leave on Woff Day.");
//            request.setAttribute("leaveEmployeeDetail", leaveEmployeeDetail);
//            mv = applyClick(request, response);
            // Failure responce will be there
            rcode = "12";
            message = "You Cannot Apply Leave on Woff Day.";
            userData.put("responseMessage", message);
            userData.put("responseCode", rcode);
            out.print(userData);
        } else if (!beforesDateCasualLeave.isEmpty() || !aftereDateCasualLeave.isEmpty()) {
//            request.setAttribute("failureMessage",
//                    "Error : You Cannot Apply Casual Leave consecutively.");
//            request.setAttribute("leaveEmployeeDetail", leaveEmployeeDetail);
//            mv = applyClick(request, response);
            // Failure responce will be there
            rcode = "12";
            message = "You Cannot Apply Casual Leave consecutively.";
            userData.put("responseMessage", message);
            userData.put("responseCode", rcode);
            out.print(userData);
        } else {
            boolean leaveCkeck = true;
            SimpleDateFormat format2 = new SimpleDateFormat("EEEE");
            try {
                Calendar cal6 = Calendar.getInstance();
                Calendar cal7 = Calendar.getInstance();
                Date satdateOfLeave = sdf.parse(leaveEmployeeDetail.getStartDate());
                cal6.setTime(satdateOfLeave);
                cal7.setTime(satdateOfLeave);

                LeaveTypeMaster leaveTypeMaster25 = new LeaveTypeMaster();
                leaveTypeMaster25 = leaveTypeMasterService.readById(leaveEmployeeDetail.getLeaveTypeMaster().getId());
                if (leaveTypeMaster25.isSandwichLeave() == false) {

                    String dayNameOfLeave = format2.format(satdateOfLeave);
                    if (dayNameOfLeave.equals("Monday") && leaveEmployeeDetail.getStartDateStatus().equals("Fullday")) {
                        LeaveEmployeeDetail leaveEmployeeDetail1 = new LeaveEmployeeDetail();
                        leaveEmployeeDetail1.setEmployeeMaster(employeeMaster);
                        cal6.add(Calendar.DAY_OF_MONTH, -2);
                        Date dateSet = cal6.getTime();
                        String dayName = format2.format(dateSet);
                        String finalDateSet = sdf.format(dateSet);
                        leaveEmployeeDetail1.setStartDate(finalDateSet);
                        int dayOfWeek = cal6.get(Calendar.WEEK_OF_MONTH);
                        boolean secondSatCheck = false;
                        if (employeeMaster.getZydexLocationMaster().getId() == 1 || employeeMaster.getZydexLocationMaster().getId() == 6) {
                            if (dayOfWeek == 2) {
                                secondSatCheck = true;
                            }
                        }
                        if (!secondSatCheck) {
                            List<?> satLeaveListCheck = leaveEmployeeDetailService.leaveCheck(leaveEmployeeDetail1);
                            if (!satLeaveListCheck.isEmpty()) {
                                LeaveEmployeeDetail leaveEmployeeDetail2 = (LeaveEmployeeDetail) satLeaveListCheck.get(0);
                                if ((leaveEmployeeDetail2.getStartDate()).equals(leaveEmployeeDetail2.getEndDate())
                                        && !leaveEmployeeDetail2.getStartDateStatus().contains("FirstHalf")
                                        && !leaveEmployeeDetail2.getStartDateStatus().contains("SecondHalf")) {
                                    LeaveTypeMaster leaveTypeMaster1 = new LeaveTypeMaster();
                                    leaveTypeMaster1.setId(leaveEmployeeDetail2.getLeaveTypeMaster().getId());
                                    leaveTypeMaster1 = leaveTypeMasterService.readById(leaveTypeMaster1.getId());
                                    if (leaveTypeMaster1.getLeaveType().contains("Casual Leave") && (leaveEmployeeDetail2.getLeaveTypeMaster().getId().equals(leaveEmployeeDetail.getLeaveTypeMaster().getId()))) {
                                        LeaveTypeMaster leaveTypeMaster2 = new LeaveTypeMaster();
                                        leaveTypeMaster2.setId(7);
                                        employeeLeaveBalance1.setEmployeeMaster(employeeMaster);
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
                                            employeeLeaveBalance2.setEmployeeMaster(employeeMaster);
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
                                            leaveEmployeeDetail3.setEmployeeMaster(employeeMaster);
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
                                        employeeLeaveBalance1.setEmployeeMaster(employeeMaster);
                                        employeeLeaveBalance1.setLeaveTypeMaster(leaveEmployeeDetail.getLeaveTypeMaster());
                                        List<?> balanceList = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance1);
                                        if (!balanceList.isEmpty()) {
                                            employeeLeaveBalance1 = (EmployeeLeaveBalance) balanceList.get(0);
                                        }
                                        EmployeeLeaveBalance employeeLeaveBalance2 = new EmployeeLeaveBalance();
                                        employeeLeaveBalance2.setEmployeeMaster(employeeMaster);
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
                                            leaveEmployeeDetail3.setEmployeeMaster(employeeMaster);
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
                                        employeeLeaveBalance1.setEmployeeMaster(employeeMaster);
                                        employeeLeaveBalance1.setLeaveTypeMaster(leaveEmployeeDetail.getLeaveTypeMaster());
                                        List<?> balanceList = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance1);
                                        if (!balanceList.isEmpty()) {
                                            employeeLeaveBalance1 = (EmployeeLeaveBalance) balanceList.get(0);
                                        }
                                        EmployeeLeaveBalance employeeLeaveBalance2 = new EmployeeLeaveBalance();
                                        employeeLeaveBalance2.setEmployeeMaster(employeeMaster);
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
                                            leaveEmployeeDetail2.setDateOfSubmit(currentDate);
                                            leaveEmployeeDetailService.update(leaveEmployeeDetail2);

                                        } else {
                                            leaveCkeck = true;
                                            LeaveEmployeeDetail leaveEmployeeDetail3 = new LeaveEmployeeDetail();
                                            cal7.add(Calendar.DAY_OF_MONTH, -1);
                                            Date dateSet1 = cal7.getTime();
                                            String finalDateSet1 = sdf.format(dateSet1);
                                            leaveEmployeeDetail1.setStartDate(finalDateSet);
                                            leaveEmployeeDetail3.setEmployeeMaster(employeeMaster);
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
                                } else if (!(leaveEmployeeDetail2.getStartDate()).equals(leaveEmployeeDetail2.getEndDate())
                                        && !leaveEmployeeDetail2.getEndDateStatus().contains("FirstHalf")
                                        && !leaveEmployeeDetail2.getEndDateStatus().contains("SecondHalf")) {
                                    LeaveTypeMaster leaveTypeMaster1 = new LeaveTypeMaster();
                                    leaveTypeMaster1.setId(leaveEmployeeDetail2.getLeaveTypeMaster().getId());
                                    leaveTypeMaster1 = leaveTypeMasterService.readById(leaveTypeMaster1.getId());
                                    if (leaveTypeMaster1.getLeaveType().contains("Casual Leave") && (leaveEmployeeDetail2.getLeaveTypeMaster().getId().equals(leaveEmployeeDetail.getLeaveTypeMaster().getId()))) {
                                        LeaveTypeMaster leaveTypeMaster2 = new LeaveTypeMaster();
                                        leaveTypeMaster2.setId(7);
                                        employeeLeaveBalance1.setEmployeeMaster(employeeMaster);
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
                                            employeeLeaveBalance2.setEmployeeMaster(employeeMaster);
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
                                            leaveEmployeeDetail3.setEmployeeMaster(employeeMaster);
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
                                        employeeLeaveBalance1.setEmployeeMaster(employeeMaster);
                                        employeeLeaveBalance1.setLeaveTypeMaster(leaveEmployeeDetail.getLeaveTypeMaster());
                                        List<?> balanceList = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance1);
                                        if (!balanceList.isEmpty()) {
                                            employeeLeaveBalance1 = (EmployeeLeaveBalance) balanceList.get(0);
                                        }
                                        EmployeeLeaveBalance employeeLeaveBalance2 = new EmployeeLeaveBalance();
                                        employeeLeaveBalance2.setEmployeeMaster(employeeMaster);
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
                                            leaveEmployeeDetail2.setDateOfSubmit(currentDate);
                                            leaveEmployeeDetailService.update(leaveEmployeeDetail2);
                                        } else {
                                            leaveCkeck = true;
                                            LeaveEmployeeDetail leaveEmployeeDetail3 = new LeaveEmployeeDetail();
                                            cal7.add(Calendar.DAY_OF_MONTH, -1);
                                            Date dateSet1 = cal7.getTime();
                                            String finalDateSet1 = sdf.format(dateSet1);
                                            leaveEmployeeDetail1.setStartDate(finalDateSet);
                                            leaveEmployeeDetail3.setEmployeeMaster(employeeMaster);
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
                                        employeeLeaveBalance1.setEmployeeMaster(employeeMaster);
                                        employeeLeaveBalance1.setLeaveTypeMaster(leaveEmployeeDetail.getLeaveTypeMaster());
                                        List<?> balanceList = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance1);
                                        if (!balanceList.isEmpty()) {
                                            employeeLeaveBalance1 = (EmployeeLeaveBalance) balanceList.get(0);
                                        }
                                        EmployeeLeaveBalance employeeLeaveBalance2 = new EmployeeLeaveBalance();
                                        employeeLeaveBalance2.setEmployeeMaster(employeeMaster);
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
                                            leaveEmployeeDetail2.setDateOfSubmit(currentDate);
                                            leaveEmployeeDetailService.update(leaveEmployeeDetail2);

                                        } else {
                                            leaveCkeck = true;
                                            LeaveEmployeeDetail leaveEmployeeDetail3 = new LeaveEmployeeDetail();
                                            cal7.add(Calendar.DAY_OF_MONTH, -1);
                                            Date dateSet1 = cal7.getTime();
                                            String finalDateSet1 = sdf.format(dateSet1);
                                            leaveEmployeeDetail1.setStartDate(finalDateSet);
                                            leaveEmployeeDetail3.setEmployeeMaster(employeeMaster);
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
                }
            } catch (Exception e) {

            }

            String leaveTypeMasterId = leavetypeid;//request.getParameter("leaveTypeMaster.id");
            if (!"".equals(leaveTypeMasterId) && leaveTypeMasterId.equals("12")) {

                SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                String currentDate = dateFormat1.format(new Date());
                leaveEmployeeDetail.setDateOfSubmit(currentDate);
                leaveEmployeeDetailService.create(leaveEmployeeDetail);

//            
//                request.setAttribute("successMessage",
//                        "Information : The Information is saved Successfully.");
                //mv = searchOwnLeaveDetail(request, response);
                //Emailtemplate for submit click .....
                    rcode = "1";
                    message = "Success.";
                    userData.put("responseMessage", message);
                    userData.put("responseCode", rcode);
                    out.print(userData);
                try {
                    Mailsend(request);
                    String startdate = leaveEmployeeDetail.getStartDate();
                    String enddate = leaveEmployeeDetail.getEndDate();
                    EmailTemplate emailTemplate = new EmailTemplate();
                    EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                    DesignationMaster designationMaster = new DesignationMaster();
                    designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                    EmployeeMaster employeeMasterHr = new EmployeeMaster();
                    employeeMasterHr = employeeMasterService.readById(Integer.parseInt(employeeMasterModel.getReportingManagerLevel1()));
                    // id six is apply status
                    emailTemplate = emailTemplateService.readById(6);
                    String To = employeeMasterHr.getOfficeEmailId();
                    String from = employeeMasterModel.getOfficeEmailId();
                    String Subject = emailTemplate.getSubject();
                    Subject = Subject.replaceAll("\\{user\\}", employeeMasterModel.getEmployeeName());
                    String msg = emailTemplate.getBodytext();
                    msg = msg.replaceAll("\\{to_user\\}", employeeMasterHr.getEmployeeName());
                    msg = msg.replaceAll("\\{start_date\\}", startdate);
                    msg = msg.replaceAll("\\{end_date\\}", enddate);
                    msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                    msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                    sendMail.sendMail(from, To, Subject, msg);
                } catch (Exception e) {

                }

            } else {
                if (!"".equals(leaveTypeMasterId)) {
                    leaveTypeMaster.setId(Integer.parseInt(leaveTypeMasterId));
                    if (leaveCkeck) {
                        leaveTypeMaster = leaveTypeMasterService.readById(leaveEmployeeDetail.getLeaveTypeMaster().getId());
                    } else {
                        leaveTypeMaster = leaveTypeMasterService.readById(leaveTypeMaster.getId());
                    }
                    if (leaveTypeMaster.getLeaveType().contains("Short Leave")) {
                        leaveEmployeeDetail.setStartDate(ssDate); //request.getParameter("startDateShort"));
                        leaveEmployeeDetail.setEndDate(eeDate);//request.getParameter("endDateShort"));
                    }
                    employeeLeaveBalance.setLeaveTypeMaster(leaveTypeMaster);
                }
                employeeLeaveBalance1.setEmployeeMaster(employeeMaster);
                employeeLeaveBalance1.setLeaveTypeMaster(leaveTypeMaster);
                List<?> balanceList = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance1);
                if (!balanceList.isEmpty()) {
                    employeeLeaveBalance1 = (EmployeeLeaveBalance) balanceList.get(0);
                }
                boolean balance = false;
                employeeLeaveBalance.setEmployeeMaster(employeeMaster);
                Float shortLeaveCount = 0.0f;
                List<?> empLeaveBalanceList = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance);
                if (!empLeaveBalanceList.isEmpty()) {
                    employeeLeaveBalance = (EmployeeLeaveBalance) empLeaveBalanceList.get(0);
                    shortLeaveCount = employeeLeaveBalance.getNoOfLeaveRemain();
                    if (!leaveTypeMaster.getLeaveType().contains("Short Leave") && !leaveTypeMaster.getLeaveType().contains("C Off Leave")) {
                        if (leaveEmployeeDetail.getNoOfDays().floatValue() > employeeLeaveBalance.getNoOfLeaveRemain()) {
                            balance = true;
                        }
                    } else {
                        balance = true;

                    }
                }
                try {
                    if (leaveCkeck) {
                        leaveTypeMaster = leaveTypeMasterService.readById(leaveEmployeeDetail.getLeaveTypeMaster().getId());
                    } else {
                        leaveTypeMaster = leaveTypeMasterService.readById(Integer.parseInt(leaveTypeMasterId));
                    }
                    leaveTypeMaster.getMaxDayAllowedLeave();
                    Date startDate = sdf.parse(leaveEmployeeDetail.getStartDate());
                    Date endDate = sdf.parse(leaveEmployeeDetail.getEndDate());
                    long diffDays1 = 0;
                    List<?> list = new ArrayList();
//                if (leaveTypeMaster.getLeaveType().equals("Casual Leave")) {
//                    getNoOfDays(leaveEmployeeDetail, startDate, endDate);
//                }
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/YYYY");
                    Calendar cal5 = Calendar.getInstance();
                    Date satdate = sdf.parse(leaveEmployeeDetail.getStartDate());
                    cal5.setTime(satdate);
                    String dayName = format2.format(satdate);
                    int dayOfWeek = cal5.get(Calendar.WEEK_OF_MONTH);
                    int locationId = employeeMaster.getZydexLocationMaster().getId();

                    if (!startDate.after(endDate)) {
                        LeaveEmployeeDetail leaveEmployeeDetail1 = new LeaveEmployeeDetail();
                        leaveEmployeeDetail1.setEmployeeMaster(employeeMaster);
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
                        boolean plBalCheck = false;
                        List<?> plCheck = leaveEmployeeDetailService.plLeaveCheck(employeeMaster.getId());
                        if (plCheck.size() >= 3) {
                            plBalCheck = true;
                        }

                        if (leaveTypeMaster.getLeaveType().contains("Short Leave")) {

                            flag = false;

                            if (dayName.equals("Saturday") && dayOfWeek == 2 && (locationId == 1 || locationId == 6)) {
//                                request.setAttribute("failureMessage",
//                                        "Error :On Second Saturday You can Not Apply Short Leave");
//                                request.setAttribute("leaveEmployeeDetail", leaveEmployeeDetail);
//                                mv = applyClick(request, response);
                                // Failure message
                                rcode = "12";
                                message = "On Second Saturday You can Not Apply Short Leave";
                                userData.put("responseMessage", message);
                                userData.put("responseCode", rcode);
                                out.print(userData);
                            } else if (flag) {
////                                request.setAttribute("failureMessage",
////                                        "Error :You Have Already apply Leave On that Day...");
////                                request.setAttribute("leaveEmployeeDetail", leaveEmployeeDetail);
////                                mv = applyClick(request, response);
                                // Failure message
                                rcode = "12";
                                message = "You Have Already apply Leave On that Day...";
                                userData.put("responseMessage", message);
                                userData.put("responseCode", rcode);
                                out.print(userData);
                            } else if (shortLeaveCount > 0) {
                                String shrLeave = data.get("noOfDay").toString(); //request.getParameter("noOfDayLeave");
                                int srtLeave1 = Integer.parseInt(shrLeave);

                                SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                                String currentDate = dateFormat1.format(new Date());
                                leaveEmployeeDetail.setDateOfSubmit(currentDate);
                                leaveEmployeeDetailService.create(leaveEmployeeDetail);

                                balanceDay = employeeLeaveBalance1.getNoOfLeaveRemain();

                                if (srtLeave1 == 1 && balanceDay >= 1) {

                                    leaveEmployeeDetail.setNoOfDays(Float.parseFloat("1"));
                                    noOfDay = leaveEmployeeDetail.getNoOfDays();
                                    balanceDay = balanceDay - noOfDay;
                                    employeeLeaveBalance1.setNoOfLeaveRemain(balanceDay);
                                    employeeLeaveBalanceService.update(employeeLeaveBalance1);

                                    //request.setAttribute("successMessage",
                                         //   "Information : The Information is saved Successfully.");
                                    //mv = searchOwnLeaveDetail(request, response);
                                    rcode = "1";
                                    message = "Success.";
                                   
                                    //Emailtemplate for submit click .....
                                    try {
                                        Mailsend(request);
                                        String startdate = leaveEmployeeDetail.getStartDate();
                                        String enddate = leaveEmployeeDetail.getEndDate();
                                        EmailTemplate emailTemplate = new EmailTemplate();
                                        EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                                        DesignationMaster designationMaster = new DesignationMaster();
                                        designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                                        EmployeeMaster employeeMasterHr = new EmployeeMaster();
                                        employeeMasterHr = employeeMasterService.readById(Integer.parseInt(employeeMasterModel.getReportingManagerLevel1()));
                                        // id six is apply status
                                        emailTemplate = emailTemplateService.readById(6);
                                        String To = employeeMasterHr.getOfficeEmailId();
                                        String from = employeeMasterModel.getOfficeEmailId();
                                        String Subject = emailTemplate.getSubject();
                                        Subject = Subject.replaceAll("\\{user\\}", employeeMasterModel.getEmployeeName());
                                        String msg = emailTemplate.getBodytext();
                                        msg = msg.replaceAll("\\{to_user\\}", employeeMasterHr.getEmployeeName());
                                        msg = msg.replaceAll("\\{start_date\\}", startdate);
                                        msg = msg.replaceAll("\\{end_date\\}", enddate);
                                        msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                                        msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                                        sendMail.sendMail(from, To, Subject, msg);
                                    } catch (Exception e) {

                                    }
                                } else if (srtLeave1 == 2 && balanceDay >= 2) {

                                    leaveEmployeeDetail.setNoOfDays(Float.parseFloat("2"));
                                    noOfDay = leaveEmployeeDetail.getNoOfDays();
                                    balanceDay = balanceDay - noOfDay;
                                    employeeLeaveBalance1.setNoOfLeaveRemain(balanceDay);
                                    employeeLeaveBalanceService.update(employeeLeaveBalance1);

//                                    request.setAttribute("successMessage",
//                                            "Information : The Information is saved Successfully.");
//                                    mv = searchOwnLeaveDetail(request, response);
                                    rcode = "1";
                                    message = "Success.";
                                    //Emailtemplate for submit click .....
                                    try {
                                        Mailsend(request);
                                        String startdate = leaveEmployeeDetail.getStartDate();
                                        String enddate = leaveEmployeeDetail.getEndDate();
                                        EmailTemplate emailTemplate = new EmailTemplate();
                                        EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                                        DesignationMaster designationMaster = new DesignationMaster();
                                        designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                                        EmployeeMaster employeeMasterHr = new EmployeeMaster();
                                        employeeMasterHr = employeeMasterService.readById(Integer.parseInt(employeeMasterModel.getReportingManagerLevel1()));
                                        // id six is apply status
                                        emailTemplate = emailTemplateService.readById(6);
                                        String To = employeeMasterHr.getOfficeEmailId();
                                        String from = employeeMasterModel.getOfficeEmailId();
                                        String Subject = emailTemplate.getSubject();
                                        Subject = Subject.replaceAll("\\{user\\}", employeeMasterModel.getEmployeeName());
                                        String msg = emailTemplate.getBodytext();
                                        msg = msg.replaceAll("\\{to_user\\}", employeeMasterHr.getEmployeeName());
                                        msg = msg.replaceAll("\\{start_date\\}", startdate);
                                        msg = msg.replaceAll("\\{end_date\\}", enddate);
                                        msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                                        msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                                        sendMail.sendMail(from, To, Subject, msg);
                                    } catch (Exception e) {

                                    }

                                } else if (srtLeave1 == 3 && balanceDay == 3) {
                                    leaveEmployeeDetail.setNoOfDays(Float.parseFloat("3"));
                                    noOfDay = leaveEmployeeDetail.getNoOfDays();
                                    balanceDay = balanceDay - noOfDay;
                                    employeeLeaveBalance1.setNoOfLeaveRemain(balanceDay);
                                    employeeLeaveBalanceService.update(employeeLeaveBalance1);

//                                    request.setAttribute("successMessage",
//                                            "Information : The Information is saved Successfully.");
//                                    mv = searchOwnLeaveDetail(request, response);

                                    //Emailtemplate for submit click .....
                                    rcode = "1";
                                    message = "Success.";
                                    try {
                                        Mailsend(request);
                                        String startdate = leaveEmployeeDetail.getStartDate();
                                        String enddate = leaveEmployeeDetail.getEndDate();
                                        EmailTemplate emailTemplate = new EmailTemplate();
                                        EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                                        DesignationMaster designationMaster = new DesignationMaster();
                                        designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                                        EmployeeMaster employeeMasterHr = new EmployeeMaster();
                                        employeeMasterHr = employeeMasterService.readById(Integer.parseInt(employeeMasterModel.getReportingManagerLevel1()));
                                        // id six is apply status
                                        emailTemplate = emailTemplateService.readById(6);
                                        String To = employeeMasterHr.getOfficeEmailId();
                                        String from = employeeMasterModel.getOfficeEmailId();
                                        String Subject = emailTemplate.getSubject();
                                        Subject = Subject.replaceAll("\\{user\\}", employeeMasterModel.getEmployeeName());
                                        String msg = emailTemplate.getBodytext();
                                        msg = msg.replaceAll("\\{to_user\\}", employeeMasterHr.getEmployeeName());
                                        msg = msg.replaceAll("\\{start_date\\}", startdate);
                                        msg = msg.replaceAll("\\{end_date\\}", enddate);
                                        msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                                        msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                                        sendMail.sendMail(from, To, Subject, msg);
                                    } catch (Exception e) {

                                    }
                                } else {
//                                    request.setAttribute("failureMessage",
//                                            "Error :Your Short Leave limit is over so you can't apply.");
//                                    mv = searchOwnLeaveDetail(request, response);
                                    // Failure message
                                    rcode = "12";
                                    message = "Your Short Leave limit is over so you can't apply.";
                                    
                                }
                                
                                userData.put("responseMessage", message);
                                userData.put("responseCode", rcode);
                                out.print(userData);

                            } else {
//                                request.setAttribute("failureMessage",
//                                        "Error :Your Short Leave limit is over so you can't apply.");
//                                mv = searchOwnLeaveDetail(request, response);
                                // Failure message
                                rcode = "12";
                                message = "Your Short Leave limit is over so you can't apply.";
                                userData.put("responseMessage", message);
                                userData.put("responseCode", rcode);
                                out.print(userData);
                            }
//                        mv.setViewName("redirect:leaveEmployeeDetail.htm?act=searchOwnLeaveDetail");
                        } else if (dayName.equals("Saturday") && dayOfWeek == 2 && (locationId == 1 || locationId == 6) && leaveEmployeeDetail.getStartDateStatus().equals("Fullday")) {
//                            request.setAttribute("failureMessage",
//                                    "Error :On Second Saturday You can Not Apply Full Day Of Leave");
//                            request.setAttribute("leaveEmployeeDetail", leaveEmployeeDetail);
//                            mv = applyClick(request, response);
                            // Failure message
                            rcode = "12";
                            message = "On Second Saturday You can Not Apply Full Day Of Leave";
                            userData.put("responseMessage", message);
                            userData.put("responseCode", rcode);
                            out.print(userData);
//                        } else if (plBalCheck && leaveTypeMaster.getLeaveType().contains("Privilege Leave") && leaveEmployeeDetail.getNoOfDays() < 3) {
//                            request.setAttribute("failureMessage",
//                                    "Error :Your Pl Limit for less dhen 3 is over so you can't apply less than 3 days pl leave.");
//                            request.setAttribute("leaveEmployeeDetail", leaveEmployeeDetail);
//                            mv = applyClick(request, response);
                        } else if (leaveEmployeeDetail.getNoOfDays() > Float.parseFloat(leaveTypeMaster.getMaxDayAllowedLeave()) && !leaveTypeMaster.getLeaveType().contains("Privilege Leave") && !leaveTypeMaster.getLeaveType().contains("Maternity Leave") && !leaveTypeMaster.getLeaveType().contains("C Off Leave")
                                && !leaveTypeMaster.getLeaveType().contains("Sick Leave")) {
//                            request.setAttribute("failureMessage",
//                                    "Error :No Of Days is Greater than maximum allowed Days...");
//                            request.setAttribute("leaveEmployeeDetail", leaveEmployeeDetail);
//                            mv = applyClick(request, response);
                            // Failure message
                            rcode = "12";
                            message = "No Of Days is Greater than maximum allowed Days...";
                            userData.put("responseMessage", message);
                            userData.put("responseCode", rcode);
                            out.print(userData);
                        } else if (flag) {
//                            request.setAttribute("failureMessage",
//                                    "Error :You Have Already apply Leave On that Day...");
//                            request.setAttribute("leaveEmployeeDetail", leaveEmployeeDetail);
//                            mv = applyClick(request, response);
                            // Failure message
                            rcode = "12";
                            message = "You Have Already apply Leave On that Day...";
                            userData.put("responseMessage", message);
                            userData.put("responseCode", rcode);
                            out.print(userData);
                        } else if (!leaveCkeck) {
//                            request.setAttribute("failureMessage",
//                                    "Error :Your Balance Is Less then Your apply Leave Days.");
//                            request.setAttribute("leaveEmployeeDetail", leaveEmployeeDetail);
//                            mv = applyClick(request, response);
                                // Failure message
                            rcode = "12";
                            message = "Your Balance Is Less then Your apply Leave Days.";
                            userData.put("responseMessage", message);
                            userData.put("responseCode", rcode);
                            out.print(userData);
                        } else if (leaveTypeMaster.getLeaveType().equals("Paternity Leave")) {

                            list = leaveEmployeeDetailService.readEmployeeWiseMaternity(leaveEmployeeDetail);
                            if (employeeMaster.getMaritalStatus().equals("UnMarried")) {
//                                request.setAttribute("failureMessage",
//                                        "Error :UnMarried Employee Should Not Apply Paternity Leave...");
//                                request.setAttribute("leaveEmployeeDetail", leaveEmployeeDetail);
//                                mv = applyClick(request, response);
                                // Failure message
                                rcode = "12";
                                message = "UnMarried Employee Should Not Apply Paternity Leave...";
                                userData.put("responseMessage", message);
                                userData.put("responseCode", rcode);
                                out.print(userData);
                            } else if (employeeMaster.getGender()) {
//                                request.setAttribute("failureMessage",
//                                        "Error :Female Employee Should Not Apply Paternity Leave...");
//                                request.setAttribute("leaveEmployeeDetail", leaveEmployeeDetail);
//                                mv = applyClick(request, response);
                                // Failure message
                                rcode = "12";
                                message = "Female Employee Should Not Apply Paternity Leave...";
                                userData.put("responseMessage", message);
                                userData.put("responseCode", rcode);
                                out.print(userData);
                            } else if (list.size() >= 2) {
//                                request.setAttribute("failureMessage",
//                                        "Error :You have Only Apply 2 Time Paternity Leave Days...");
//                                request.setAttribute("leaveEmployeeDetail", leaveEmployeeDetail);
//                                mv = applyClick(request, response);
                                    // Failure message
                                rcode = "12";
                                message = "You have Only Apply 2 Time Paternity Leave Days...";
                                userData.put("responseMessage", message);
                                userData.put("responseCode", rcode);
                                out.print(userData);
                            } else if (balance) {
//                                request.setAttribute("failureMessage",
//                                        "Error :No Of Days is Greater than Leave Balance Days...");
//                                request.setAttribute("leaveEmployeeDetail", leaveEmployeeDetail);
//                                mv = applyClick(request, response);
                                // Failure message
                                rcode = "12";
                                message = "No Of Days is Greater than Leave Balance Days...";
                                userData.put("responseMessage", message);
                                userData.put("responseCode", rcode);
                                out.print(userData);
                            } else {
                                SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                                String currentDate = dateFormat1.format(new Date());
                                leaveEmployeeDetail.setDateOfSubmit(currentDate);
                                leaveEmployeeDetailService.create(leaveEmployeeDetail);
                                try {
                                    Mailsend(request);
                                } catch (Exception e) {
                                }
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
//                                request.setAttribute("successMessage",
//                                        "Information : The Information is saved Successfully.");
                                //mv = searchOwnLeaveDetail(request, response);
                                // Sucess Message
                                rcode = "1";
                                message = "Success";
                                userData.put("responseMessage", message);
                                userData.put("responseCode", rcode);
                                out.print(userData);
                            }
                        } else if (!leaveTypeMaster.getLeaveType().contains("Maternity Leave") && !leaveTypeMaster.getLeaveType().contains("Leave Without Pay") && leaveEmployeeDetail.getNoOfDays() > employeeLeaveBalance.getNoOfLeaveRemain()) {
//                            request.setAttribute("failureMessage",
//                                    "Error :No Of Days is Greater than Leave Balance Days...");
//                            request.setAttribute("leaveEmployeeDetail", leaveEmployeeDetail);
//                            mv = applyClick(request, response);
                                // Failure message
                            rcode = "12";
                            message = "No Of Days is Greater than Leave Balance Days...";
                            userData.put("responseMessage", message);
                            userData.put("responseCode", rcode);
                            out.print(userData);
                        } else if (leaveTypeMaster.getLeaveType().contains("Sick Leave")) {
                            ////////////// code to check continue 3days

                            Calendar calenderSick = Calendar.getInstance();
                            Date dateOfSickLeave = sdf.parse(leaveEmployeeDetail.getStartDate());
                            calenderSick.setTime(dateOfSickLeave);
                            String dayNameOfLeave = format2.format(dateOfSickLeave);

                            ///////////2day         
                            LeaveEmployeeDetail LED = new LeaveEmployeeDetail();
                            LED.setEmployeeMaster(employeeMaster);
                            calenderSick.add(Calendar.DAY_OF_MONTH, -2);
                            Date dateSet = calenderSick.getTime();
                            String finalDateSet = sdf.format(dateSet);
                            LED.setStartDate(finalDateSet);
                            List<?> TwodayBeforeLeaveCheckList = leaveEmployeeDetailService.sickleaveCheck(LED);
                            //////1day
                            LeaveEmployeeDetail led1dayBefore = new LeaveEmployeeDetail();
                            led1dayBefore.setEmployeeMaster(employeeMaster);
                            calenderSick.add(Calendar.DAY_OF_MONTH, +1);
                            Date day1before = calenderSick.getTime();
                            String finalday1before = sdf.format(day1before);
                            led1dayBefore.setStartDate(finalday1before);
                            List<?> OnedayBeforeLeaveCheckList = leaveEmployeeDetailService.sickleaveCheck(led1dayBefore);

                            ///////////////////////////////////////////////////
                            Calendar calenderSickAfter = Calendar.getInstance();
                            calenderSickAfter.setTime(dateOfSickLeave);

                            ///////////2day         
                            LeaveEmployeeDetail TwodayAfter = new LeaveEmployeeDetail();
                            TwodayAfter.setEmployeeMaster(employeeMaster);
                            calenderSickAfter.add(Calendar.DAY_OF_MONTH, +2);
                            Date dateSetSickAfter = calenderSickAfter.getTime();
                            String finalDateSetSickAfter = sdf.format(dateSetSickAfter);
                            TwodayAfter.setStartDate(finalDateSetSickAfter);
                            List<?> TwodayAfterLeaveCheckList = leaveEmployeeDetailService.sickleaveCheck(TwodayAfter);
                            //////1day
                            LeaveEmployeeDetail led1dayAfter = new LeaveEmployeeDetail();
                            led1dayAfter.setEmployeeMaster(employeeMaster);
                            calenderSickAfter.add(Calendar.DAY_OF_MONTH, -1);
                            Date day1After = calenderSickAfter.getTime();
                            String finalday1After = sdf.format(day1After);
                            led1dayAfter.setStartDate(finalday1After);
                            List<?> OnedayAfterLeaveCheckList = leaveEmployeeDetailService.sickleaveCheck(led1dayAfter);

                            if (!TwodayBeforeLeaveCheckList.isEmpty() && !OnedayBeforeLeaveCheckList.isEmpty()) {

//                                request.setAttribute("failureMessage",
//                                        "Error : Sick Leave Can Not Be Apply Continue 3 days");
//                                request.setAttribute("leaveEmployeeDetail", leaveEmployeeDetail);
//                                mv = applyClick(request, response);
                                // Failure message
                                rcode = "12";
                                message = "Sick Leave Can Not Be Apply Continue 3 days";
                                userData.put("responseMessage", message);
                                userData.put("responseCode", rcode);
                                out.print(userData);
                            } else if (!TwodayAfterLeaveCheckList.isEmpty() && !OnedayAfterLeaveCheckList.isEmpty()) {
//                                request.setAttribute("failureMessage",
//                                        "Error : Sick Leave Can Not Be Apply Continue 3 days");
//                                request.setAttribute("leaveEmployeeDetail", leaveEmployeeDetail);
//                                mv = applyClick(request, response);
                                // Failure message
                                rcode = "12";
                                message = "Sick Leave Can Not Be Apply Continue 3 days";
                                userData.put("responseMessage", message);
                                userData.put("responseCode", rcode);
                                out.print(userData);
                            } else {
                                String leaveDate = leaveEmployeeDetail.getStartDate();
                                Date checkLeaveDate = sdf.parse(leaveDate);
                                Date checkLeaveDate2 = new Date();
                                if (checkLeaveDate.after(checkLeaveDate2)) {
//                                    request.setAttribute("failureMessage",
//                                            "Error : Sick Leave Can Not Be Apply In Advance");
//                                    request.setAttribute("leaveEmployeeDetail", leaveEmployeeDetail);
//                                    mv = applyClick(request, response);
                                    // Failure message
                                    rcode = "12";
                                    message = "Sick Leave Can Not Be Apply In Advance";
                                    userData.put("responseMessage", message);
                                    userData.put("responseCode", rcode);
                                    out.print(userData);
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
//                                    request.setAttribute("successMessage",
//                                            "Information : The Information is saved Successfully.");

                                    //Emailtemplate for submit click .....
                                    try {
                                        Mailsend(request);
                                        String startdate = leaveEmployeeDetail.getStartDate();
                                        String enddate = leaveEmployeeDetail.getEndDate();
                                        EmailTemplate emailTemplate = new EmailTemplate();
                                        EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                                        DesignationMaster designationMaster = new DesignationMaster();
                                        designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                                        EmployeeMaster employeeMasterHr = new EmployeeMaster();
                                        employeeMasterHr = employeeMasterService.readById(Integer.parseInt(employeeMasterModel.getReportingManagerLevel1()));
                                        // id six is apply status
                                        emailTemplate = emailTemplateService.readById(6);
                                        String To = employeeMasterHr.getOfficeEmailId();
                                        String from = employeeMasterModel.getOfficeEmailId();
                                        String Subject = emailTemplate.getSubject();
                                        Subject = Subject.replaceAll("\\{user\\}", employeeMasterModel.getEmployeeName());
                                        String msg = emailTemplate.getBodytext();
                                        msg = msg.replaceAll("\\{to_user\\}", employeeMasterHr.getEmployeeName());
                                        msg = msg.replaceAll("\\{start_date\\}", startdate);
                                        msg = msg.replaceAll("\\{end_date\\}", enddate);
                                        msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                                        msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                                        sendMail.sendMail(from, To, Subject, msg);

                                        if (noOfDay > 3) {
                                            List<UserRightMaster> userlist = (List<UserRightMaster>) userRightMasterService.readByleaveRight();
                                            for (UserRightMaster emplist : userlist) {
                                                EmailTemplate emailTemplate1 = new EmailTemplate();
                                                int id2 = emplist.getUserMaster().getId();
                                                EmployeeMaster employeeMail = employeeMasterService.readById(id2);
                                                emailTemplate1 = emailTemplateService.readById(140);

                                                String To1 = employeeMail.getEmailAddress();
                                                String from1 = employeeMasterModel.getOfficeEmailId();
                                                String Subject1 = emailTemplate1.getSubject();
                                                Subject1 = Subject1.replaceAll("\\{user\\}", employeeMasterModel.getEmployeeName());
                                                String msg1 = emailTemplate1.getBodytext();
                                                msg1 = msg1.replaceAll("\\{to_user\\}", employeeMasterHr.getEmployeeName());
                                                msg1 = msg1.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                                                msg1 = msg1.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                                                sendMail.sendMail(from1, To1, Subject1, msg1);

                                            }

                                        }
                                    } catch (Exception e) {

                                    }

//                                    request.setAttribute("successMessage",
//                                            "Information : The Information is saved Successfully.");
//                                    mv = searchOwnLeaveDetail(request, response);
                                    rcode = "1";
                                    message = "Success";
                                    userData.put("responseMessage", message);
                                    userData.put("responseCode", rcode);
                                    out.print(userData);
                                }
                            }
                        } else if (leaveTypeMaster.getLeaveType().contains("Casual Leave")) {
                            ////////////// code to check continue 3days

                            Calendar calenderSick = Calendar.getInstance();
                            Date dateOfSickLeave = sdf.parse(leaveEmployeeDetail.getStartDate());
                            calenderSick.setTime(dateOfSickLeave);
                            String dayNameOfLeave = format2.format(dateOfSickLeave);

                            ///////////2day         
                            LeaveEmployeeDetail LED = new LeaveEmployeeDetail();
                            LED.setEmployeeMaster(employeeMaster);
                            calenderSick.add(Calendar.DAY_OF_MONTH, -2);
                            Date dateSet = calenderSick.getTime();
                            String finalDateSet = sdf.format(dateSet);
                            LED.setStartDate(finalDateSet);
                            List<?> TwodayBeforeLeaveCheckList = leaveEmployeeDetailService.casualleaveCheck(LED);
                            //////1day
                            LeaveEmployeeDetail led1dayBefore = new LeaveEmployeeDetail();
                            led1dayBefore.setEmployeeMaster(employeeMaster);
                            calenderSick.add(Calendar.DAY_OF_MONTH, +1);
                            Date day1before = calenderSick.getTime();
                            String finalday1before = sdf.format(day1before);
                            led1dayBefore.setStartDate(finalday1before);
                            List<?> OnedayBeforeLeaveCheckList = leaveEmployeeDetailService.casualleaveCheck(led1dayBefore);

                            ///////////////////////////////////////////////////
                            Calendar calenderSickAfter = Calendar.getInstance();
                            calenderSickAfter.setTime(dateOfSickLeave);

                            ///////////2day         
                            LeaveEmployeeDetail TwodayAfter = new LeaveEmployeeDetail();
                            TwodayAfter.setEmployeeMaster(employeeMaster);
                            calenderSickAfter.add(Calendar.DAY_OF_MONTH, +2);
                            Date dateSetSickAfter = calenderSickAfter.getTime();
                            String finalDateSetSickAfter = sdf.format(dateSetSickAfter);
                            TwodayAfter.setStartDate(finalDateSetSickAfter);
                            List<?> TwodayAfterLeaveCheckList = leaveEmployeeDetailService.casualleaveCheck(TwodayAfter);
                            //////1day
                            LeaveEmployeeDetail led1dayAfter = new LeaveEmployeeDetail();
                            led1dayAfter.setEmployeeMaster(employeeMaster);
                            calenderSickAfter.add(Calendar.DAY_OF_MONTH, -1);
                            Date day1After = calenderSickAfter.getTime();
                            String finalday1After = sdf.format(day1After);
                            led1dayAfter.setStartDate(finalday1After);
                            List<?> OnedayAfterLeaveCheckList = leaveEmployeeDetailService.casualleaveCheck(led1dayAfter);

                            if (!TwodayBeforeLeaveCheckList.isEmpty() && !OnedayBeforeLeaveCheckList.isEmpty()) {

//                                request.setAttribute("failureMessage",
//                                        "Error : Casual Leave Can Not Be Apply Continue 3 days");
//                                request.setAttribute("leaveEmployeeDetail", leaveEmployeeDetail);
//                                mv = applyClick(request, response);
                                // Failure message
                                rcode = "12";
                                message = "Casual Leave Can Not Be Apply Continue 3 days";
                                userData.put("responseMessage", message);
                                userData.put("responseCode", rcode);
                                out.print(userData);
                            } else if (!TwodayAfterLeaveCheckList.isEmpty() && !OnedayAfterLeaveCheckList.isEmpty()) {
//                                request.setAttribute("failureMessage",
//                                        "Error : Casual Leave Can Not Be Apply Continue 3 days");
//                                request.setAttribute("leaveEmployeeDetail", leaveEmployeeDetail);
//                                mv = applyClick(request, response);
                                // Failure message
                                rcode = "12";
                                message = "Casual Leave Can Not Be Apply Continue 3 days";
                                userData.put("responseMessage", message);
                                userData.put("responseCode", rcode);
                                out.print(userData);
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
//                                request.setAttribute("successMessage",
//                                        "Information : The Information is saved Successfully.");

                                //Emailtemplate for submit click .....
                                
                                try {
                                    Mailsend(request);
                                    String startdate = leaveEmployeeDetail.getStartDate();
                                    String enddate = leaveEmployeeDetail.getEndDate();
                                    EmailTemplate emailTemplate = new EmailTemplate();
                                    EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                                    DesignationMaster designationMaster = new DesignationMaster();
                                    designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                                    EmployeeMaster employeeMasterHr = new EmployeeMaster();
                                    employeeMasterHr = employeeMasterService.readById(Integer.parseInt(employeeMasterModel.getReportingManagerLevel1()));
                                    // id six is apply status
                                    emailTemplate = emailTemplateService.readById(6);
                                    String To = employeeMasterHr.getOfficeEmailId();
                                    String from = employeeMasterModel.getOfficeEmailId();
                                    String Subject = emailTemplate.getSubject();
                                    Subject = Subject.replaceAll("\\{user\\}", employeeMasterModel.getEmployeeName());
                                    String msg = emailTemplate.getBodytext();
                                    msg = msg.replaceAll("\\{to_user\\}", employeeMasterHr.getEmployeeName());
                                    msg = msg.replaceAll("\\{start_date\\}", startdate);
                                    msg = msg.replaceAll("\\{end_date\\}", enddate);
                                    msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                                    msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                                    sendMail.sendMail(from, To, Subject, msg);
                                } catch (Exception e) {

                                }

//                                request.setAttribute("successMessage",
//                                        "Information : The Information is saved Successfully.");
//                                mv = searchOwnLeaveDetail(request, response);
//                        mv.setViewName("redirect:leaveEmployeeDetail.htm?act=searchOwnLeaveDetail");
                                rcode = "1";
                                message = "Success";
                                userData.put("responseMessage", message);
                                userData.put("responseCode", rcode);
                                out.print(userData);
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
//                            request.setAttribute("successMessage",
//                                    "Information : The Information is saved Successfully.");

                            //Emailtemplate for submit click .....
                            try {
                                Mailsend(request);
                                String startdate = leaveEmployeeDetail.getStartDate();
                                String enddate = leaveEmployeeDetail.getEndDate();
                                EmailTemplate emailTemplate = new EmailTemplate();
                                EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                                DesignationMaster designationMaster = new DesignationMaster();
                                designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                                EmployeeMaster employeeMasterHr = new EmployeeMaster();
                                employeeMasterHr = employeeMasterService.readById(Integer.parseInt(employeeMasterModel.getReportingManagerLevel1()));
                                // id six is apply status
                                emailTemplate = emailTemplateService.readById(6);
                                String To = employeeMasterHr.getOfficeEmailId();
                                String from = employeeMasterModel.getOfficeEmailId();
                                String Subject = emailTemplate.getSubject();
                                Subject = Subject.replaceAll("\\{user\\}", employeeMasterModel.getEmployeeName());
                                String msg = emailTemplate.getBodytext();
                                msg = msg.replaceAll("\\{to_user\\}", employeeMasterHr.getEmployeeName());
                                msg = msg.replaceAll("\\{start_date\\}", startdate);
                                msg = msg.replaceAll("\\{end_date\\}", enddate);
                                msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                                msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                                sendMail.sendMail(from, To, Subject, msg);
                            } catch (Exception e) {

                            }

////                            request.setAttribute("successMessage",
////                                    "Information : The Information is saved Successfully.");
////                            mv = searchOwnLeaveDetail(request, response);
//                        mv.setViewName("redirect:leaveEmployeeDetail.htm?act=searchOwnLeaveDetail");
                            rcode = "1";
                            message = "Success";
                            userData.put("responseMessage", message);
                            userData.put("responseCode", rcode);
                            out.print(userData);
                           
                        }
                    } else {
//                        request.setAttribute("failureMessage",
//                                "Error : Please Insert start date before end date.");
//                        request.setAttribute("leaveEmployeeDetail", leaveEmployeeDetail);
//                        mv = applyClick(request, response);
                        // Failure message
                        rcode = "12";
                        message = "Please Insert start date before end date.";
                        userData.put("responseMessage", message);
                        userData.put("responseCode", rcode);
                        out.print(userData);
                    }
                } catch (Exception e) {
//                    request.setAttribute("failureMessage",
//                            "Error : Please Insert Valid Data.");
//                    request.setAttribute("leaveEmployeeDetail", leaveEmployeeDetail);
//                    mv = applyClick(request, response);
                    // Failure message
                    rcode = "12";
                    message = "Please Insert Valid Data.";
                    userData.put("responseMessage", message);
                    userData.put("responseCode", rcode);
                    out.print(userData);
                }
            }
        }
        } catch (Exception exception) {
            rcode = "0";
            message = "Error";
            userData.put("responseMessage", message);
            userData.put("responseCode", rcode);
            out.print(userData);
        }
//        mv.getModelMap().put("leaveEmployeeDetail", leaveEmployeeDetail);
        //return mv;
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

                        if (null == (""+arrayOfObject[6])) {
                            empreason = "";
                        } else {
                            empreason = (""+arrayOfObject[6]);
                        }

                        if (null == (""+arrayOfObject[7])) {
                            dateOfSubmit = "";
                        } else {
                            dateOfSubmit = (""+arrayOfObject[7]);
                        }

                        if (null == (""+arrayOfObject[8])) {
                            ApproveName = "";
                        } else {
                            ApproveName = (""+arrayOfObject[8]);
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
    
    public void otRegularizationList(HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException {
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
            //LeaveEmployeeDetail leaveEmployeeDetail = new LeaveEmployeeDetail();
            OTRegularization oTRegularization = new OTRegularization();
            
            OTRegularization oTRegularization2 = new OTRegularization();
            List<?> empId = employeeMasterService.readByUserName(employeeMaster);
            
            if (!empId.isEmpty()) {
                employeeMaster = (EmployeeMaster) empId.get(0);

                oTRegularization.setEmployeeMaster(employeeMaster);
                //leaveEmployeeDetail.setEmployeeMaster(employeeMaster);
                
                List<?> list = oTRegularizationService.userWiseOTRegularizationList(userid);
                List<?> list1 = oTRegularizationService.userReportingManager(userid);
                //oTRegularizationService.readById(userid)
                //List<?> empLeaveList = leaveEmployeeDetailService.readEmpLeaveListDetail(leaveEmployeeDetail);
                //--
                if (!list1.isEmpty()) {
                    employeeMaster = (EmployeeMaster) list1.get(0);
                    employeeMaster1 = employeeMasterService.readById(Integer.parseInt(employeeMaster.getReportingManagerLevel1()));
                }            
//--
                
                if (!list.isEmpty()) {
                    for (int i = 0; i < list.size(); i++) {
                        oTRegularization2 = (OTRegularization)list.get(i);
                        //Object[] arrayOfObject = (Object[]) list.get(i);
                        JSONObject obj = new JSONObject();
//                        String leavetype = arrayOfObject[0].toString();
//                        String Startdate = arrayOfObject[1].toString();
//                        String Enddate = arrayOfObject[2].toString();
//                        String Noofdays = arrayOfObject[3].toString();
//                        String leaveid = arrayOfObject[4].toString();
//                        String Status = arrayOfObject[5].toString();
                        
                        

//                        if (null == (""+arrayOfObject[6])) {
//                            empreason = "";
//                        } else {
//                            empreason = (""+arrayOfObject[6]);
//                        }
//
//                        if (null == (""+arrayOfObject[7])) {
//                            dateOfSubmit = "";
//                        } else {
//                            dateOfSubmit = (""+arrayOfObject[7]);
//                        }
//
//                        if (null == (""+arrayOfObject[8])) {
//                            ApproveName = "";
//                        } else {
//                            ApproveName = (""+arrayOfObject[8]);
//                        }
                        String Startdate = oTRegularization2.getStartDateTime();
                        String Enddate = oTRegularization2.getEndDateTime();
                        String otid = ""+oTRegularization2.getId();
                        
                        String Status = ""+oTRegularization2.getStatus();
                        String statusmsg = "";
                        String dateOfSubmit = ""+oTRegularization2.getDateOfSubmit();
                        String empreason = ""+oTRegularization2.getReason();
                        String ApproveName = employeeMaster1.getEmployeeName();
                        String TimeDifference = ""+oTRegularization2.getDifferentCompare();
                        String Reason = ""+oTRegularization2.getReason();
                        
                        //===================
                        if (Status.equals("0") || Status.equals("18")) {
                            statusmsg = "Pending";
                        }
                        else if (Status.equals("1")) {
                            statusmsg = "Approved By " + employeeMaster1.getEmployeeName();
                        }
                        else if (Status.equals("11")) {
                            statusmsg = "Partially Approved";
                        }
                        if (Status.equals("2")) {
                            statusmsg = "Withdraw";
                        }
                        if (Status.equals("3")) {
                            statusmsg = "Rejected by " + employeeMaster1.getEmployeeName();
                        }
                        if (Status.equals("7")) {
                            statusmsg = "Reworked by " + employeeMaster1.getEmployeeName();;
                        }
//                        leaveEmployeeDetail = leaveEmployeeDetailService.readById(Integer.parseInt(leaveid));
//                        String startdatestatus = "";
//                        String enddatestatus = "";
//                        if (!leaveEmployeeDetail.equals("")) {
//                            startdatestatus = leaveEmployeeDetail.getStartDateStatus().toString();
//                            enddatestatus = leaveEmployeeDetail.getEndDateStatus().toString();
//                        }

                        obj.put("leavereason", empreason);
                        //obj.put("startdatestatus", startdatestatus);
                        //obj.put("enddatestatus", enddatestatus);
                        //obj.put("leavetype", leavetype);
                        obj.put("startdate", Startdate);
                        obj.put("enddate", Enddate);
                        //obj.put("noofdays", Noofdays);
                        obj.put("leaveid", otid);
                        obj.put("status", Status);
                        obj.put("StatusMsg", statusmsg);
                        obj.put("approveName", ApproveName);
                        obj.put("dateOfSubmit", dateOfSubmit);
                        obj.put("TimeDifference", TimeDifference);
                        obj.put("Reason", Reason);
                        
                        jSONArray.put(obj);
                        rcode = "1";
                        message = "Success";
                    }
                } else {
                    rcode = "2";
                    message = "No Record Found";
                }
                data.put("UserOTList", jSONArray);
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

    public void ViewOTRegularization(HttpServletRequest request, HttpServletResponse response) throws Exception {

        PrintWriter out = null;
        out = response.getWriter();
        JSONArray jSONArray = new JSONArray();
        UserMaster user = new UserMaster();
        JSONObject userdata = new JSONObject();
        String rcode = "";
        String message = "";
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        int reportingId = 0;
        String id = request.getParameter("id");
        int userid = Integer.parseInt(id);
        user.setId(userid);
        try {
            JSONObject data1 = doPost(request);
            String Attendenceregularizationid = data1.getString("Attendenceregularizationid");
            
            OTRegularization oTRegularization = new OTRegularization();
            //AttendanceRegularization attendanceRegularization = new AttendanceRegularization();
            EmployeeMaster employeeMaster = new EmployeeMaster();
            employeeMaster.setUserMaster(user);

//        EmployeeMaster em = (EmployeeMaster) employeeMasterService.readByReportManager(employeeMaster1);
//        List<?> reportmanager1 = employeeMasterService.readByReportManager(employeeMaster1);
//        if (!reportmanager1.isEmpty()) {
//            employeeMaster1 = (EmployeeMaster) reportmanager1.get(0);
//            
//            request.setAttribute("reportingManager", employeeMaster1.getEmployeeName());
            List<?> empDetailList = employeeMasterService.readEmployeeDetailUserIdWise(employeeMaster);
            if (!empDetailList.isEmpty()) {

                String employeeId = "";
                String employeeName = "";
                String designationName = "";
                String level = "";
                String departmentName = "";
                String location = "";
                String reportingManagerLevel1 = "";

                int leaveEmployeeDeatilId = 0;
                int Status = 0;
                int userId = 0;
                float NoOfDays = 0;

                for (int i = 0; i < empDetailList.size(); i++) {
                    Object[] o = (Object[]) empDetailList.get(i);
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
                    userData.put("reportingManagerLevel1", employeeMaster1.getEmployeeName());

                    oTRegularization = oTRegularizationService.readById(Integer.parseInt(Attendenceregularizationid));
                    userData.put("StartDateTime", oTRegularization.getStartDateTime());
                    userData.put("EndDateTime", oTRegularization.getEndDateTime());
                    userData.put("DateOfSubmit", oTRegularization.getDateOfSubmit());
                    userData.put("Reason", oTRegularization.getReason());
                    jSONArray.put(userData);

                }

            }
            rcode = "1";
            message = "Success";

            userdata.put("EmployeeDetail", jSONArray);

            userdata.put("responseMessage", message);
            userdata.put("responseCode", rcode);
            out.print(userdata);
        } catch (Exception e) {
            rcode = "1";
            message = "Something went wrong";
            e.printStackTrace();
        }
    }
    
    
    public void OtWithdraw(HttpServletRequest request, HttpServletResponse response) throws Exception {

        PrintWriter out = null;
        out = response.getWriter();
        String rcode = "";
        String message = "";
        JSONObject userData = new JSONObject();
        
        OTRegularization oTRegularization = new OTRegularization();
        OTRegularization oTRegularization1 = new OTRegularization();
        
        UserMaster user = new UserMaster();
        String id = request.getParameter("id");
        int userid = Integer.parseInt(id);
        user.setId(userid);
        try {
            JSONObject data1 = doPost(request);
            String Attendenceregularizationid = data1.getString("Attendenceregularizationid");
            String btnSubmit = data1.getString("btnSubmit");
            oTRegularization1 = oTRegularizationService.readById(Integer.parseInt(Attendenceregularizationid));
            if (btnSubmit.equals("Submit")) {

                if (oTRegularization1.getStatus() == 7) {
                    oTRegularization.setStatus(0);
                    oTRegularization.setManagerRemark(oTRegularization1.getManagerRemark());
                    oTRegularization.setUserMasterId(oTRegularization1.getUserMasterId());
                } else {
                    oTRegularization.setStatus(2);
                    oTRegularization.setManagerRemark(oTRegularization1.getManagerRemark());
                    oTRegularization.setUserMasterId(oTRegularization1.getUserMasterId());
                }
                request.setAttribute("successMessage",
                        "Information : The Information is saved Successfully.");
                try {

                    EmailTemplate emailTemplate = new EmailTemplate();
                    EmployeeMaster employeeMasterModel = employeeMasterService.readById(userid);

                    DesignationMaster designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                    EmployeeMaster employeeMaster1 = new EmployeeMaster();
                    EmployeeMaster EmployeeHR = new EmployeeMaster();
                    EmployeeHR = employeeMasterService.readById(Integer.parseInt(employeeMasterModel.getReportingManagerLevel1()));
                    //id=14 is for attandence regularization Apply...
                    emailTemplate = emailTemplateService.readById(14);
                    String EmpStr = request.getParameter("empid");
                    if (null != EmpStr && !"".equals(EmpStr)) {
                        int Empid = Integer.parseInt(EmpStr);
                        List list = employeeMasterService.readByEmployeeNo(Empid);
                        if (!list.isEmpty()) {
                            employeeMaster1 = (EmployeeMaster) list.get(0);
                            String To = EmployeeHR.getOfficeEmailId();
                            String from = employeeMasterModel.getOfficeEmailId();
                            String Subject = emailTemplate.getSubject();
                            Subject = Subject.replaceAll("\\{user\\}", employeeMasterModel.getEmployeeName());
                            String msg = emailTemplate.getBodytext();
                            msg = msg.replaceAll("\\{to_user\\}", EmployeeHR.getEmployeeName());
                            msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                            msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                            sendMail.sendMail(from, To, Subject, msg);

                            String name = "Attendance";
                            EmailAddMaster emailAddMaster = new EmailAddMaster();
                            emailAddMaster.setModuleName(name);
                            emailAddMaster.setDepartmentMaster(employeeMasterModel.getDepartmentMaster());
                            List<?> emailSendList = emailAddMasterService.readByName(emailAddMaster);
                            if (!emailSendList.isEmpty()) {
                                EmailAddMaster emailAddMaster1 = (EmailAddMaster) emailSendList.get(0);
                                String emailId = emailAddMaster1.getEmailId();
                                for (String emailId1 : emailId.split(",")) {
                                    if (!emailId1.equals("")) {
                                        String To1 = emailId1;
                                        String from1 = employeeMasterModel.getOfficeEmailId();
                                        String subject1 = emailTemplate.getSubject();
                                        subject1 = subject1.replaceAll("\\{user\\}", employeeMasterModel.getEmployeeName());
                                        String msg1 = emailTemplate.getBodytext();
                                        msg1 = msg1.replaceAll("\\{to_user\\}", EmployeeHR.getEmployeeName());
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
                                        String subject1 = emailTemplate.getSubject();
                                        subject1 = subject1.replaceAll("\\{user\\}", employeeMaster1.getEmployeeName());
                                        String msg1 = emailTemplate.getBodytext();
                                        msg1 = msg1.replaceAll("\\{to_user\\}", employeeMaster1.getEmployeeName());
                                        msg1 = msg1.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                                        msg1 = msg1.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                                        sendMail.sendMail(from1, To1, subject1, msg1);
                                    }
                                }
                            }

                        }

                    }

                } catch (Exception e) {
                }

            } else if (btnSubmit.equals("Withdraw")) {
                oTRegularization = oTRegularizationService.readById(Integer.parseInt(Attendenceregularizationid));
                oTRegularization.setStatus(2);
                try {

                    EmailTemplate emailTemplate = new EmailTemplate();
                    EmployeeMaster employeeMasterModel = employeeMasterService.readById(userid);
                    DesignationMaster designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                    EmployeeMaster employeeMaster1 = new EmployeeMaster();
                    EmployeeMaster EmployeeHR = new EmployeeMaster();
                    EmployeeHR = employeeMasterService.readById(Integer.parseInt(employeeMasterModel.getReportingManagerLevel1()));
                    //id=18 is for attandence regularization withdrow...
                    emailTemplate = emailTemplateService.readById(18);
                    String EmpStr = request.getParameter("empid");
                    if (null != EmpStr && !"".equals(EmpStr)) {
                        int Empid = Integer.parseInt(EmpStr);
                        List list = employeeMasterService.readByEmployeeNo(Empid);
                        if (!list.isEmpty()) {
                            employeeMaster1 = (EmployeeMaster) list.get(0);
                            String To = EmployeeHR.getOfficeEmailId();
                            String from = employeeMasterModel.getOfficeEmailId();
                            String Subject = emailTemplate.getSubject();
                            Subject = Subject.replaceAll("\\{user\\}", employeeMasterModel.getEmployeeName());
                            String msg = emailTemplate.getBodytext();
                            msg = msg.replaceAll("\\{to_user\\}", EmployeeHR.getEmployeeName());
                            msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                            msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                            sendMail.sendMail(from, To, Subject, msg);

                        }
                    }
                } catch (Exception e) {
                }

            }
            rcode = "1";
            message = "Success";

            SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            String currentDate = dateFormat1.format(new Date());
            oTRegularization.setDateOfSubmit(currentDate);
            oTRegularizationService.createOrUpdate(oTRegularization);

        } catch (Exception e) {
            rcode = "1";
            message = "Something went wrong";
            e.printStackTrace();
        }
        userData.put("responseMessage", message);
        userData.put("responseCode", rcode);
        out.print(userData);
    }
    
    public void createOTRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException, ServletException {
        PrintWriter out = null;
        out = response.getWriter();
        String rcode = "";
        String message = "";
        EmployeeMaster employeeMaster = new EmployeeMaster();
//        UserMaster userMaster = new UserMaster();
        UserMaster user = new UserMaster();
////        String id = request.getParameter("id");
////        int userid = Integer.parseInt(id);
////        user.setId(userid);
//        employeeMaster.setUserMaster(user);
        JSONObject userData = new JSONObject();
        JSONObject data = doPost(request);
        try {
            OTRegularization oTRegularization = new OTRegularization();
            //AttendanceRegularization attendanceRegularization = new AttendanceRegularization();
            SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            String Startdate = data.getString("startdate");
            String enddate = data.getString("enddate");
            String reason = data.getString("reason");
            String userId = data.getString("userId");
            //String arType = data.getString("ARType");
            int userMasterId = Integer.parseInt(userId);

            user.setId(userMasterId);
            employeeMaster.setUserMaster(user);

            Date sdate = dateFormat1.parse(Startdate);
            Date edate = dateFormat1.parse(enddate);

            //==================================================================
//            String strDate = request.getParameter("strDate");
//            String enDate = request.getParameter("enDate");

    //        strDate = strDate.replaceAll(",", "/");
    ////        enDate = enDate.replaceAll(",", "/");
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    //        Date sDate = sdf.parse(strDate);
    //        Date eDate = sdf.parse(enDate);
            //String message = "";
            Date loginStartDate = sdf.parse(Startdate);
            Date loginEndDate = sdf.parse(enddate);
            long diff = loginEndDate.getTime() - loginStartDate.getTime();
            long diffMinutes = diff / (60 * 1000);
            int minute = (int) (diffMinutes % 60);
            int hour = (int) (diffMinutes / 60);
            message = hour + ":" + minute;
            //==================================================================
            oTRegularization.setUserMasterId(userMasterId);
            oTRegularization.setStartDateTime(Startdate);//sdate.toString());
            oTRegularization.setEndDateTime(enddate);//edate.toString());
            oTRegularization.setReason(reason);
            oTRegularization.setStatus(0);
            oTRegularization.setDifferentCompare(message);

            String currentDate = dateFormat1.format(new Date());
            oTRegularization.setDateOfSubmit(currentDate);
            oTRegularizationService.createOrUpdate(oTRegularization);

            try {
                EmailTemplate emailTemplate = new EmailTemplate();
                EmployeeMaster employeeMaster1 = new EmployeeMaster();
                List<?> empDetailList = employeeMasterService.readByEmployeeUserId(employeeMaster);
                if (!empDetailList.isEmpty()) {
                    employeeMaster1 = (EmployeeMaster) empDetailList.get(0);
                }
//                EmployeeMaster employeeMasterModel = employeeMasterService.readById(Integer.parseInt(employeeMaster.getReportingManagerLevel1()));
                EmployeeMaster employeeMasterModel = employeeMasterService.readById(Integer.parseInt(employeeMaster1.getReportingManagerLevel1()));
                DesignationMaster designationMaster = new DesignationMaster();
                designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                EmployeeMaster employeeMasterHr = new EmployeeMaster();
                employeeMasterHr = employeeMasterService.readById(Integer.parseInt(employeeMaster1.getReportingManagerLevel1()));
                // id 14 is for Attendence regularization apply....
                emailTemplate = emailTemplateService.readById(14);
                String To = employeeMasterModel.getOfficeEmailId();
                String from = employeeMaster1.getOfficeEmailId();
                String Subject = emailTemplate.getSubject();
                Subject = Subject.replaceAll("\\{user\\}", employeeMaster1.getEmployeeName());
                String msg = emailTemplate.getBodytext();
                msg = msg.replaceAll("\\{to_user\\}", employeeMasterModel.getEmployeeName());
                msg = msg.replaceAll("\\{from_user\\}", employeeMaster1.getEmployeeName());
                msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                sendMail.sendMail(from, To, Subject, msg);
            } catch (Exception e) {
            }

            rcode = "1";
            message = "Sucess";

        } catch (Exception e) {
            rcode = "0";
            message = "ERROR";
        }
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
    
    public void Mailsend(HttpServletRequest request) throws Exception {

        try {
            EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
            EmployeeMaster employeeMasterHr = employeeMasterService.readById(Integer.parseInt(employeeMasterModel.getReportingManagerLevel1()));
            DesignationMaster designationMaster = new DesignationMaster();
            designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
            EmployeeMaster employeeMaster2 = new EmployeeMaster();
            EmailTemplate emailTemplate1 = new EmailTemplate();
            // id =7 for approve leave request...
            emailTemplate1 = emailTemplateService.readById(6);
            int empID = employeeMasterModel.getId();
            String leaveid = request.getParameter("id");
            employeeMaster2 = employeeMasterService.readById(empID);
            LeaveEmployeeDetail leaveEmployeeDetail = new LeaveEmployeeDetail();
            BindException errors = new BindException(leaveEmployeeDetail, "leaveEmployeeDetail");
            bind(request, leaveEmployeeDetail);
            String startdate = leaveEmployeeDetail.getStartDate();
            String enddate = leaveEmployeeDetail.getEndDate();

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
                        subject1 = subject1.replaceAll("\\{user\\}", employeeMasterModel.getEmployeeName());
                        String msg1 = emailTemplate1.getBodytext();
                        msg1 = msg1.replaceAll("\\{to_user\\}", employeeMasterHr.getEmployeeName());
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
                        subject1 = subject1.replaceAll("\\{user\\}", employeeMasterModel.getEmployeeName());
                        String msg1 = emailTemplate1.getBodytext();
                        msg1 = msg1.replaceAll("\\{to_user\\}", employeeMasterHr.getEmployeeName());
                        msg1 = msg1.replaceAll("\\{start_date\\}", startdate);
                        msg1 = msg1.replaceAll("\\{end_date\\}", enddate);
                        msg1 = msg1.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                        msg1 = msg1.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                        sendMail.sendMail(from1, To1, subject1, msg1);
                    }
                }
            }
        } catch (Exception e) {
        }
    }
    
    public void otSubDisplay(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PrintWriter out = null;
        out = response.getWriter();
        String rcode = "";
        String message = "";

        JSONObject userData = new JSONObject();
        JSONObject data = new JSONObject();
        try {
            //-----------
//            ModelAndView mv = new ModelAndView();
//        OTRegularization otRegularization = new OTRegularization();
//        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
//        int id = employeeMaster.getId();
//        List<?> list = oTRegularizationService.approvalLeval1WiseOtRegularizationList(id);
//        List<?> list1 = oTRegularizationService.userReportingManager(id);
//        String managerName = "";
//        if (!list1.isEmpty()) {
//            employeeMaster = (EmployeeMaster) list1.get(0);
//            if (!employeeMaster.getReportingManagerLevel1().equals("")) {
//                List<?> reportingmanagerNameList = employeeMasterService.readByEmployeeLevel1Id(employeeMaster);
//                if (!reportingmanagerNameList.isEmpty()) {
//                    Object[] o = (Object[]) reportingmanagerNameList.get(0);
//                    managerName = (String) o[2];
//                }
//            }
//        }
            //----------
            String id = request.getParameter("id");
            UserMaster usermaster1 = new UserMaster();
            usermaster1.setId(Integer.parseInt(id));
            EmployeeMaster emp = new EmployeeMaster();
            emp.setUserMaster(usermaster1);

//        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
            EmployeeMaster employeeMaster = new EmployeeMaster();
            List<?> emplist = employeeMasterService.readByUserName(emp);
            if (!emplist.isEmpty()) {
                for (Object o : emplist) {
                    employeeMaster = (EmployeeMaster) o;
                }
            }
//
            List<?> list = oTRegularizationService.approvalLeval1WiseOtRegularizationList(employeeMaster.getId());
            List<?> list1 = oTRegularizationService.userReportingManager(employeeMaster.getId());
            String managerName = "";
            if (!list1.isEmpty()) {

                
                employeeMaster = (EmployeeMaster) list1.get(0);
                if (!employeeMaster.getReportingManagerLevel1().equals("")) {
                    List<?> reportingmanagerNameList = employeeMasterService.readByEmployeeLevel1Id(employeeMaster);
                    if (!reportingmanagerNameList.isEmpty()) {
                        Object[] o = (Object[]) reportingmanagerNameList.get(0);
                        managerName = (String) o[2];
                    }
                }
            }
            JSONArray listsType = new JSONArray();
            if (!list.isEmpty()) {
                for (Object o : list) {
                    Object[] ob = (Object[]) o;
                    JSONObject listType = new JSONObject();

                    // listType.put("EMPid",employeeMaster.getEmployeeId()); 
                    OTRegularization ar = oTRegularizationService.readById(Integer.parseInt(ob[0].toString()));
                    int uId = ar.getUserMasterId();
                    EmployeeMaster em = new EmployeeMaster();
                    em.setUserMaster(userMasterService.readById(uId));
                    List<EmployeeMaster> empDetailList = (List<EmployeeMaster>) employeeMasterService.readByEmployeeUserId(em);
                    EmployeeMaster empMast = empDetailList.get(0);
                    int empMastId = empMast.getId();
                    listType.put("Attendenceregularization_id", ob[0].toString());
                    listType.put("EmpName", ob[1].toString());
                    listType.put("Reason", ob[4].toString());
                    listType.put("Status", ob[5].toString());
                    listType.put("EndDateTime", ob[3].toString());
                    listType.put("StartDateTime", ob[2].toString());
                    String dateOfSubmit = "";
                    if (null != ob[6]) {
                        dateOfSubmit = ob[6].toString();
                    }
                    listType.put("dateOfSubmit", dateOfSubmit);

                    listType.put("empMastId", empMastId);
                    listType.put("Usermaster_id", empMast.getUserMaster().getId());
                    String status_Messsage = "";
                    if (ob[5].toString().equals("0")) {
                        status_Messsage = "Pending";
                    } else if (ob[5].toString().equals("1")) {
                        status_Messsage = "Approved";
                    } else if (ob[5].toString().equals("7")) {
                        status_Messsage = "Rework";
                    } else if (ob[5].toString().equals("3")) {
                        status_Messsage = "Rejected";
                    } else if (ob[5].toString().equals("2")) {
                        status_Messsage = "Withdrawn";
                    }
                    listType.put("StatusMsg", status_Messsage);
                    listsType.put(listType);
                    data.put("listsType", listsType);
                    rcode = "1";
                    message = "Sucess";
                }

            } else {
                rcode = "2";
                message = "No request found.";

            }
            userData.put("data", data);
            userData.put("responseMessage", message);
            userData.put("responseCode", rcode);
            out.print(userData);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public void otClickView(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PrintWriter out = null;
        out = response.getWriter();
        String rcode = "";
        String message = "";
        JSONArray viewType = new JSONArray();
        JSONObject userData = new JSONObject();
        try {

            //AttendanceRegularization attendanceRegularization = new AttendanceRegularization();
            OTRegularization otRegularization = new OTRegularization();
            // EmployeeMaster employeeMaster = new EmployeeMaster();
            EmployeeMaster employeeMaster1 = new EmployeeMaster();
            String id = request.getParameter("id");
            JSONObject data = doConvert(request);

            String empMastId = data.getString("EmpId");
            String attid = data.getString("Attendenceregularization_id");

            EmployeeMaster employeeMaster = employeeMasterService.readById(Integer.parseInt(empMastId));

            otRegularization = oTRegularizationService.readById(Integer.parseInt(attid));
            employeeMaster.setDepartmentMaster(departmentMasterService.readById(employeeMaster.getDepartmentMaster().getId()));
            employeeMaster.setLevelMaster(levelMasterService.readById(employeeMaster.getLevelMaster().getId()));
            employeeMaster.setLocationMaster(locationMasterService.readById(employeeMaster.getLocationMaster().getId()));

            int status1 = otRegularization.getStatus();
            String status = Integer.toString(status1);
            request.setAttribute("status", status);
            String remarkNmame = otRegularization.getManagerRemark();
            request.setAttribute("remarkNmame", remarkNmame);
            int userId = otRegularization.getUserMasterId();
            UserMaster user = new UserMaster();
            user.setId(userId);
            employeeMaster.setUserMaster(user);
            List<?> empDetailList = employeeMasterService.readEmployeeDetailUserIdWise(employeeMaster);
            if (!empDetailList.isEmpty()) {
                request.setAttribute("employeeMaster", empDetailList.get(0));
                Object[] arrayOfObject = (Object[]) empDetailList.get(0);
                String reportmanager = (String) arrayOfObject[6];
            }
            JSONObject views = new JSONObject();
            views.put("EmpId", employeeMaster.getEmployeeId());
            views.put("EmpName", employeeMaster.getEmployeeName());
            views.put("StartDateTime", otRegularization.getStartDateTime());
            views.put("End DateTime:", otRegularization.getEndDateTime());
            views.put("Reason:", otRegularization.getReason());
            views.put("Work_location", employeeMaster.getLocationMaster().getLocation());
            views.put("Level", employeeMaster.getLevelMaster().getLevel());
            views.put("DeptName", employeeMaster.getDepartmentMaster().getDepartmentName());
            views.put("Attendenceregularization_id", otRegularization.getId());
            String status_Messsage = "";
            if (otRegularization.getStatus() == 0) {
                status_Messsage = "Pending";
            } else if (otRegularization.getStatus() == 1) {
                status_Messsage = "Approved";
            } else if (otRegularization.getStatus() == 2) {
                status_Messsage = "Withdrawn";
            } else if (otRegularization.getStatus() == 7) {
                status_Messsage = "REWORK";
            } else {
                status_Messsage = "REJECT";
            }

            views.put("StatusMsg", status_Messsage);

            viewType.put(views);

            rcode = "1";
            message = "Sucess";

        } catch (Exception e) {
            rcode = "2";
            message = "Failure";
            e.printStackTrace();

        }
        userData.put("data", viewType);
        userData.put("responseMessage", message);
        userData.put("responseCode", rcode);
        out.print(userData);
    }
    
    public JSONObject doConvert(HttpServletRequest request) throws IOException, JSONException {

        StringBuffer buffer = new StringBuffer();
        String line = null;
        try {
            BufferedReader bufferedReader = request.getReader();
            while ((line = bufferedReader.readLine()) != null) {
                buffer.append(line);
            }
        } catch (Exception e) {
        }
        JSONObject jSONObject = new JSONObject(buffer.toString());

        return jSONObject;
    }
    
    public void otApprovalByAdmin(HttpServletRequest request, HttpServletResponse response) throws Exception {

        //=============================
        String rcode = "";
        String message = "";
        PrintWriter out = null;
        out = response.getWriter();
        JSONObject userData = new JSONObject();
        List<?> allhrlist = new ArrayList<Object>();
        
        EmailTemplate emailTemplate = new EmailTemplate();
        EmployeeMaster employeeMasterModel = new EmployeeMaster();
        DesignationMaster designationMaster = new DesignationMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();

        try {

            //String id = "" + request.getParameter("id");
            JSONObject data = doConvert(request);

            String empId = data.getString("EmpId");
            String id = data.getString("Attendenceregularization_id"); //attid
            
            
          //ModelAndView mv = new ModelAndView();
            OTRegularization otRegularization = new OTRegularization();
            //String id = "" + request.getParameter("id");
    //        String remark = "" + request.getParameter("remark");
            String remark = "";//request.getParameter("remark");
            otRegularization = oTRegularizationService.readById(Integer.parseInt(id));

            otRegularization.setStatus(Integer.parseInt("1"));
            otRegularization.setManagerRemark(remark);

    //        EmployeeMaster approverName = new EmployeeMaster();
            EmployeeMaster approverName = employeeMasterService.readById(Integer.parseInt(empId));//(EmployeeMaster) request.getSession().getAttribute("employeeInfo");
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String requestdate = sdf.format(new Date());
            otRegularization.setApprovedDate(requestdate);
            otRegularization.setEmployeeMaster(approverName);
            oTRegularizationService.createOrUpdate(otRegularization);
            try {
                employeeMasterModel = employeeMasterService.readById(Integer.parseInt(empId));//(EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                
                allhrlist = userRightMasterService.readallHRList();

                
                rcode = "1";
                message = "Sucess";

            } catch (Exception e) {
                rcode = "2";
                message = "Failure";
                System.out.println(e);
            }
            try {
                if (!allhrlist.isEmpty()) {
                    for (Object obj : allhrlist) {
                        UserRightMaster userRightMaster = new UserRightMaster();
                        EmployeeMaster employeeMaster2 = new EmployeeMaster();
                        userRightMaster = (UserRightMaster) obj;
                        List list = employeeMasterService.readByUserId(userRightMaster.getUserMaster().getId());
                        if (!list.isEmpty()) {
                            for (Object obj1 : list) {
                                employeeMaster2 = (EmployeeMaster) obj1;
                                emailTemplate = emailTemplateService.readById(172);

                                String To = employeeMaster2.getOfficeEmailId();
                                String from = employeeMasterModel.getOfficeEmailId();
                                String Subject = emailTemplate.getSubject();
                                Subject = Subject.replaceAll("\\{user\\}", employeeMaster2.getEmployeeName());
                                String msg = emailTemplate.getBodytext();
                                msg = msg.replaceAll("\\{to_user\\}", employeeMaster2.getEmployeeName());
                                msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                                msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                                sendMail.sendMail(from, To, Subject, msg);
                            }
                        }
                    }
                }
                //id=69 is for attandence regularization approve to employee...
                emailTemplate = emailTemplateService.readById(172);
                String EmpStr = request.getParameter("empid");
                if (null != EmpStr && !"".equals(EmpStr)) {
                    int Empid = Integer.parseInt(EmpStr);
                    List list = employeeMasterService.readByEmployeeNo(Empid);
                    if (!list.isEmpty()) {
                        employeeMaster1 = (EmployeeMaster) list.get(0);
                        String To = employeeMaster1.getOfficeEmailId();
                        String from = employeeMasterModel.getOfficeEmailId();
                        String Subject = emailTemplate.getSubject();
                        Subject = Subject.replaceAll("\\{user\\}", employeeMaster1.getEmployeeName());
                        String msg = emailTemplate.getBodytext();
                        msg = msg.replaceAll("\\{to_user\\}", employeeMaster1.getEmployeeName());
                        msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                        msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                        sendMail.sendMail(from, To, Subject, msg);

                    }
                }
            }
            catch (Exception e) {
            
            }
        } catch (Exception e) {
            rcode = "2";
            message = "Failure";

            e.printStackTrace();
        }
        userData.put("responseMessage", message);
        userData.put("responseCode", rcode);
        out.print(userData);
        
//        Employee Date Time Data
//        mv.setViewName("redirect:attendanceRegularizationMaster.htm?act=powerAdminApprovalList");
//        mv.setViewName("redirect:attendanceRegularizationMaster.htm?act=approvalSubmit");
        //mv.setViewName("redirect:shiftRotationMaster.htm?act=approvalSubmitOTregularization");
        //return mv;
        //============================= 
    }
    /*
        String rcode = "";
        String message = "";
        PrintWriter out = null;
        out = response.getWriter();
        JSONObject userData = new JSONObject();

        try {

            //AttendanceRegularization attendanceRegularization = new AttendanceRegularization();
            OTRegularization otRegularization = new OTRegularization();
            
            String id = "" + request.getParameter("id");
            JSONObject data = doConvert(request);

            String empId = data.getString("EmpId");
            String attid = data.getString("Attendenceregularization_id");
//        String remark = "" + request.getParameter("remark");
            String remark = "";
            otRegularization = oTRegularizationService.readById(Integer.parseInt(attid));
            otRegularization.setStatus(1);
            otRegularization.setManagerRemark(remark);

//        EmployeeMaster approverName = new EmployeeMaster();
            EmployeeMaster approverName = employeeMasterService.readById(Integer.parseInt(empId));
            //EmployeeMaster approverName = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String requestdate = sdf.format(new Date());
            otRegularization.setApprovedDate(requestdate);
            otRegularization.setEmployeeMaster(approverName);
            oTRegularizationService.createOrUpdate(otRegularization);

//        Employee Date Time Data
            if (otRegularization.getStatus() == 1) {
                int userId = otRegularization.getUserMasterId();
                UserMaster userMaster = new UserMaster();
                userMaster.setId(userId);
                EmployeeMaster employeeMaster = new EmployeeMaster();
                employeeMaster.setUserMaster(userMaster);
                List<?> l = employeeMasterService.readByEmployeeUserId(employeeMaster);
                employeeMaster = (EmployeeMaster) l.get(0);
                String startDate = otRegularization.getStartDateTime();
                String endDate = otRegularization.getEndDateTime();
                EmployeeDatetimeData employeeDatetimeData = new EmployeeDatetimeData();
                EmployeeDatetimeData employeeDatetimeData1 = new EmployeeDatetimeData();
                employeeDatetimeData.setEmployeeMaster(employeeMaster);
                employeeDatetimeData.setDateTime(startDate);
                employeeDatetimeData1.setEmployeeMaster(employeeMaster);
                employeeDatetimeData1.setDateTime(endDate);
//            employeeDatetimeDataService.createOrUpdate(employeeDatetimeData);
//            employeeDatetimeDataService.createOrUpdate(employeeDatetimeData1);

//                EmployeeShiftData employeeShiftData = new EmployeeShiftData();
//                //EmployeeShiftData employeeShiftData1 = new EmployeeShiftData();
//                employeeShiftData.setInDateTime(startDate);
//                employeeShiftData.setEmployeeMaster(employeeMaster);
//                List<?> shift = employeeShiftDataService.attendanceRegularizationEntry(employeeShiftData);
//                if (!shift.isEmpty()) {
//                    employeeShiftData1 = (EmployeeShiftData) shift.get(0);
//                    employeeShiftData1.setInDateTime(startDate);
//                    employeeShiftData1.setOutDateTime(endDate);
//                    employeeShiftData1.setEmployeeMaster(employeeMaster);
//                    employeeShiftData1.setShiftMaster(employeeShiftData1.getShiftMaster());
////                employeeShiftDataService.update(employeeShiftData1);
//                }

                // add c-off balance in employee leave balance when day is sunday
                SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
                Date startDate1 = sdf1.parse(startDate);
                Date endDate1 = sdf1.parse(endDate);
                long diff = endDate1.getTime() - startDate1.getTime();
                int days = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
                for (int i = 0; i <= days + 1; i++) {
                    String dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(startDate1);
                    if (dayOfWeek.equals("Sunday")) {
                        String time = "0.8";

                        OverTimeMaster overTimeMaster = new OverTimeMaster();
                        String overTimeDate = sdf1.format(startDate1);
                        overTimeMaster.setDate(overTimeDate);
                        overTimeMaster.setTime(time);

                        overTimeMaster.setEmployeeMaster(employeeMaster);

                        EmployeeLeaveBalance employeeLeaveBalance = new EmployeeLeaveBalance();
                        EmployeeLeaveBalance employeeLeaveBalance1 = new EmployeeLeaveBalance();
                        LeaveTypeMaster leaveTypeMaster = new LeaveTypeMaster();
                        leaveTypeMaster.setId(11);
                        employeeLeaveBalance.setLeaveTypeMaster(leaveTypeMaster);
                        employeeLeaveBalance.setEmployeeMaster(employeeMaster);
                        EmployeeMaster employeeMaster2 = new EmployeeMaster();
                        employeeMaster2 = employeeMasterService.readById(employeeMaster.getId());
                        int levelId = employeeMaster.getLevelMaster().getId();
                        LevelMaster levelMaster1 = new LevelMaster();
                        levelMaster1 = levelMasterService.readById(levelId);
                        if (employeeMaster.getZydexLocationMaster().getId().equals(5) && levelMaster1.getLevel().contains("Level 4") || levelMaster1.getLevel().contains("Level 5")) {
                            List<?> empBalList = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance);
                            if (!empBalList.isEmpty()) {
                                employeeLeaveBalance1 = (EmployeeLeaveBalance) empBalList.get(0);
                                float time1 = employeeLeaveBalance1.getNoOfLeaveRemain();
                                time1 = time1 + Float.parseFloat(time);
                                employeeLeaveBalance1.setNoOfLeaveRemain(time1);
                                employeeLeaveBalanceService.update(employeeLeaveBalance1);
                            } else {
                                employeeLeaveBalance1.setLeaveTypeMaster(leaveTypeMaster);
                                employeeLeaveBalance1.setEmployeeMaster(employeeMaster);
                                employeeLeaveBalance1.setNoOfLeaveRemain(Float.parseFloat(time));
                                employeeLeaveBalanceService.create(employeeLeaveBalance1);
                            }
                            overTimeMasterService.create(overTimeMaster);
                        }

                    }
                    Calendar c = Calendar.getInstance();
                    c.setTime(startDate1);
                    c.add(Calendar.DATE, 1);
                    startDate1 = c.getTime();
                }
                // add c-off balance in employee leave balance when day is sunday
                EmailTemplate emailTemplate = new EmailTemplate();
                EmployeeMaster employeeMasterModel = employeeMasterService.readById(Integer.parseInt(employeeMaster.getReportingManagerLevel1()));
//                EmployeeMaster employeeMasterModel = (EmployeeMaster) employeeMasterService.readEmpUserIdWise(employeeMaster);
//                EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                DesignationMaster designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                EmployeeMaster employeeMaster1 = new EmployeeMaster();
                //id=69 is for attandence regularization approve to employee...
                emailTemplate = emailTemplateService.readById(69);
                EmployeeMaster employeeMaster2 = new EmployeeMaster();
                UserMaster userMaster1 = new UserMaster();
                userMaster1.setId(attendanceRegularization.getUserMasterId());
                employeeMaster2.setUserMaster(userMaster1);
                List list1 = employeeMasterService.readByUserName(employeeMaster2);
                if (!list1.isEmpty()) {
                    employeeMaster = (EmployeeMaster) list1.get(0);
                    String To = employeeMaster.getOfficeEmailId();
                    String from = employeeMasterModel.getOfficeEmailId();
                    String Subject = emailTemplate.getSubject();
                    Subject = Subject.replaceAll("\\{user\\}", employeeMaster.getEmployeeName());
                    String msg = emailTemplate.getBodytext();
                    msg = msg.replaceAll("\\{to_user\\}", employeeMaster.getEmployeeName());
                    msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                    msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                    sendMail.sendMail(from, To, Subject, msg);

                    String name = "Attendance";
                    EmailAddMaster emailAddMaster = new EmailAddMaster();
                    emailAddMaster.setModuleName(name);
                    emailAddMaster.setDepartmentMaster(employeeMaster.getDepartmentMaster());
                    List<?> emailSendList = emailAddMasterService.readByName(emailAddMaster);
                    if (!emailSendList.isEmpty()) {
                        EmailAddMaster emailAddMaster1 = (EmailAddMaster) emailSendList.get(0);
                        String emailId = emailAddMaster1.getEmailId();
                        for (String emailId1 : emailId.split(",")) {
                            if (!emailId1.equals("")) {
                                String To1 = employeeMaster.getOfficeEmailId();
                                String from1 = employeeMasterModel.getOfficeEmailId();
                                String subject1 = emailTemplate.getSubject();
                                subject1 = subject1.replaceAll("\\{user\\}", employeeMaster.getEmployeeName());
                                String msg1 = emailTemplate.getBodytext();
                                msg1 = msg1.replaceAll("\\{to_user\\}", employeeMaster.getEmployeeName());
                                msg1 = msg1.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                                msg1 = msg1.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                                sendMail.sendMail(from1, To1, subject1, msg1);

                            }
                        }
                    }
                }
            }
            rcode = "1";
            message = "Sucess";

        } catch (Exception e) {
            rcode = "2";
            message = "Failure";

            e.printStackTrace();
        }
        userData.put("responseMessage", message);
        userData.put("responseCode", rcode);
        out.print(userData);
    }*/
    
    
    public void otReworkSubmitByAdminOt(HttpServletRequest request, HttpServletResponse response) throws Exception {
       // ModelAndView mv = new ModelAndView();
        OTRegularization otRegularization = new OTRegularization();
        
        String rcode = "";
        String message = "";
        PrintWriter out = null;
        out = response.getWriter();
        JSONObject userData = new JSONObject();
        String empId = "";
        
        try {

            //String id = "" + request.getParameter("id");
            JSONObject data = doConvert(request);

            //String id = request.getParameter("id");

            empId = data.getString("EmpId");
            String id = data.getString("Attendenceregularization_id");

            String remark = "";
            otRegularization = oTRegularizationService.readById(Integer.parseInt(id));
            otRegularization.setStatus(7);
            otRegularization.setManagerRemark(remark);
            EmployeeMaster approverName = employeeMasterService.readById(Integer.parseInt(empId));//(EmployeeMaster) request.getSession().getAttribute("employeeInfo");
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String requestdate = sdf.format(new Date());
            otRegularization.setApprovedDate(requestdate);
            otRegularization.setEmployeeMaster(approverName);
            oTRegularizationService.createOrUpdate(otRegularization);
            rcode = "1";
            message = "Sucess";
        } catch (Exception e) {
            rcode = "2";
            message = "Failure";

            e.printStackTrace();
        }
        
        try {
            EmailTemplate emailTemplate = new EmailTemplate();
            EmployeeMaster employeeMasterModel = employeeMasterService.readById(Integer.parseInt(empId));
            DesignationMaster designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
            EmployeeMaster employeeMaster1 = new EmployeeMaster();
            //id=16 is for attandence regularization rework...
            emailTemplate = emailTemplateService.readById(173);
            UserMaster userMaster = new UserMaster();
            userMaster.setId(otRegularization.getUserMasterId());
            employeeMaster1.setUserMaster(userMaster);
            List<?> list = employeeMasterService.readByUserName(employeeMaster1);
//            String EmpStr = request.getParameter("empid");
//            if (null != EmpStr && !"".equals(EmpStr)) {
//                int Empid = Integer.parseInt(EmpStr);
//                List list = employeeMasterService.readByEmployeeNo(Empid);
            if (!list.isEmpty()) {
                employeeMaster1 = (EmployeeMaster) list.get(0);
                String To = employeeMaster1.getOfficeEmailId();
                String from = employeeMasterModel.getOfficeEmailId();
                String Subject = emailTemplate.getSubject();
                Subject = Subject.replaceAll("\\{user\\}", employeeMaster1.getEmployeeName());
                String msg = emailTemplate.getBodytext();
                msg = msg.replaceAll("\\{to_user\\}", employeeMaster1.getEmployeeName());
                msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                sendMail.sendMail(from, To, Subject, msg);

            }
            
        } catch (Exception e) {
            rcode = "2";
            message = "Failure";

            e.printStackTrace();
        }
        
        userData.put("responseMessage", message);
        userData.put("responseCode", rcode);
        out.print(userData);
    }
    
    
    public void otRejectSubmitByAdminOt(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //ModelAndView mv = new ModelAndView();
        OTRegularization otRegularization = new OTRegularization();
        String rcode = "";
        String message = "";
        PrintWriter out = null;
        out = response.getWriter();
        JSONObject userData = new JSONObject();

        //String id = "" + request.getParameter("id");
        JSONObject data = doConvert(request);

        //String id = request.getParameter("id");

        String empId = data.getString("EmpId");
        String id = data.getString("Attendenceregularization_id");
            
        //String id = request.getParameter("id");
        String remark = "";
        otRegularization = oTRegularizationService.readById(Integer.parseInt(id));
        otRegularization.setStatus(3);
        otRegularization.setManagerRemark(remark);
        EmployeeMaster approverName = employeeMasterService.readById(Integer.parseInt(empId));//(EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String requestdate = sdf.format(new Date());
        otRegularization.setApprovedDate(requestdate);
        otRegularization.setEmployeeMaster(approverName);
        oTRegularizationService.createOrUpdate(otRegularization);
        rcode = "1";
        message = "Sucess";
        try {
            EmailTemplate emailTemplate = new EmailTemplate();
            EmployeeMaster employeeMasterModel = employeeMasterService.readById(Integer.parseInt(empId));//(EmployeeMaster) request.getSession().getAttribute("employeeInfo");
            DesignationMaster designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
            UserMaster userMaster = new UserMaster();
            userMaster.setId(otRegularization.getUserMasterId());
            EmployeeMaster employeeMaster1 = new EmployeeMaster();
            employeeMaster1.setUserMaster(userMaster);
            List list = employeeMasterService.readByUserName(employeeMaster1);
            //id=17 is for attandence regularization reject...
            emailTemplate = emailTemplateService.readById(174);
            if (!list.isEmpty()) {
                employeeMaster1 = (EmployeeMaster) list.get(0);
                String To = employeeMaster1.getOfficeEmailId();
                String from = employeeMasterModel.getOfficeEmailId();
                String Subject = emailTemplate.getSubject();
                Subject = Subject.replaceAll("\\{user\\}", employeeMaster1.getEmployeeName());
                String msg = emailTemplate.getBodytext();
                msg = msg.replaceAll("\\{to_user\\}", employeeMaster1.getEmployeeName());
                msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                sendMail.sendMail(from, To, Subject, msg);
            }
            
        } catch (Exception e) {
            //rcode = "2";
            //message = "Failure";
            e.printStackTrace();
        }
        
        userData.put("responseMessage", message);
        userData.put("responseCode", rcode);
        out.print(userData);
    }
    
     public void holidayList(HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException {
        PrintWriter out = null;
        out = response.getWriter();
        String rcode = "";
        String message = "";
        String empid = "";
        JSONObject userData = new JSONObject();
        JSONObject data = new JSONObject();
        
        JSONArray jSONArray = new JSONArray();
        HolidayMaster holidayMaster = new HolidayMaster();
        
        try {
            List<?> holidayList = holidayMasterService.readWithLocation();
            
                if (!holidayList.isEmpty()) {
                    for (int i = 0; i < holidayList.size(); i++) {
                        Object[] holidayObject = (Object[])holidayList.get(i);
                        //Object[] objectHoliday =  ()holidayList.get(i);
                        holidayMaster = (HolidayMaster)holidayObject[0];
                        String holidayLocation = ""+holidayObject[1];
                        
                        //Object[] arrayOfObject = (Object[]) list.get(i);
                        JSONObject obj = new JSONObject();
                        
                        obj.put("holiday_id", ""+holidayMaster.getId());
                       
                        obj.put("startdate", ""+holidayMaster.getHolidayFromDate());
                        obj.put("enddate", ""+holidayMaster.getHolidayToDate());
                        
                        obj.put("title", ""+holidayMaster.getTitle());
                        obj.put("location", ""+holidayLocation);
//                        obj.put("StatusMsg", statusmsg);
//                        obj.put("approveName", ApproveName);
//                        obj.put("dateOfSubmit", dateOfSubmit);
//                        obj.put("TimeDifference", TimeDifference);
//                        obj.put("Reason", Reason);
//                        
                        jSONArray.put(obj);
                        rcode = "1";
                        message = "Success";
                    }
                } 
                data.put("UserOTList", jSONArray);
           
        } catch (Exception exception) {
            rcode = "0";
            message = "Error";
        }
        userData.put("data", data);
        userData.put("responseMessage", message);
        userData.put("responseCode", rcode);
        out.print(userData);
    }
     
     public void showOwnAttandanceOfOwnWebService(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeAdvanceSearch employeeAdvanceSearch = new EmployeeAdvanceSearch();
        EmployeeShiftData employeeShiftData = new EmployeeShiftData();
        String startDate = request.getParameter("inDateTime");
        String endDate = request.getParameter("outDateTime");
        bind(request, employeeAdvanceSearch);
        long totalLateTime = 0;
        int countLateEntry = 0;
        int countForPenalty = 0;
        long TotalOtTime = 0;
        long upOtTime = 0;
        //----------
        PrintWriter out = null;
        out = response.getWriter();
        String rcode = "";
        String message = "";
        String empid = "";
        JSONObject userData = new JSONObject();
        JSONObject data = new JSONObject();
        
        JSONArray jSONArray = new JSONArray();

        String empId = request.getParameter("id");
      
        //---------
        List<?> employeeMasterList = employeeMasterService.readByUserId(Integer.parseInt(empId));
        EmployeeMaster employeeMaster = new EmployeeMaster();
        
        if(!employeeMasterList.isEmpty())
        {
            employeeMaster = (EmployeeMaster)employeeMasterList.get(0);
        }
        String id = employeeMaster.getId().toString();
        employeeAdvanceSearch.setId(id);
        employeeAdvanceSearch.setZydexLocationId(null);
        employeeAdvanceSearch.setLevelID(null);
        employeeAdvanceSearch.setDepartmentId(null);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Map<String, String> woMap = new HashMap<String, String>();
        Map<String, String> satMap = new HashMap<String, String>();
        Map<String, String> halfDayMap = new HashMap<String, String>();
        if (null != id && !id.equals("")) {
            employeeShiftData.setId(Integer.parseInt(id));
        }
        employeeAdvanceSearch.setEmployeeId(Boolean.FALSE);
        employeeAdvanceSearch.setEmployeeName(Boolean.FALSE);
        employeeAdvanceSearch.setFatherName(Boolean.FALSE);
        employeeAdvanceSearch.setMotherName(Boolean.FALSE);
        employeeAdvanceSearch.setGender(Boolean.FALSE);
        employeeAdvanceSearch.setMaritalStatus(Boolean.FALSE);
        employeeAdvanceSearch.setSpouseName(Boolean.FALSE);
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
        List allpunchList = new ArrayList();
        if ((!"".equals(startDate) && null != startDate) && (!"".equals(endDate) && null != endDate)) {
            if (!"".equals(startDate) && null != startDate) {
                Date sDate = sdf.parse(startDate);
//            "2012-01-01"
                employeeShiftData.setInDateTime(new SimpleDateFormat("yyyy-MM-dd").format(sDate));

            }
            if (!"".equals(endDate) && null != endDate) {
                Date eDate = sdf.parse(endDate);
                employeeShiftData.setOutDateTime(new SimpleDateFormat("yyyy-MM-dd").format(eDate));
            }
        } else {
            Calendar c = Calendar.getInstance();
            int year = 2019;//c.get(Calendar.YEAR);
            int day = 15;//c.get(Calendar.DAY_OF_MONTH);
            int month = 11;//c.get(Calendar.MONTH) + 1;

            startDate = year + "-" + (month < 10 ? ("0" + month) : (month)) + "-01";
            Date sDate = sdf1.parse(startDate);
            endDate = year + "-" + (month < 10 ? ("0" + month) : (month)) + "-" + day;
            Date eDate = sdf1.parse(endDate);
            employeeShiftData.setInDateTime(sdf1.format(sDate));
            employeeShiftData.setOutDateTime(sdf1.format(eDate));
        }

        try {
            List<?> empDetail = employeeMasterService.empOrDateWiseSearch(employeeAdvanceSearch);
            //----------
            Map<Integer, List<?>> map = new LinkedHashMap<Integer, List<?>>();
            for (Object o1 : empDetail) {
                Object[] o = (Object[]) o1;
                int id1 = (Integer) o[48];
                employeeShiftData.setId(id1);

                List list = employeeShiftDataService.empOrDateWiseSearch(employeeShiftData);
                int i = 0;
                for (Iterator<? extends Object> iterator = list.iterator(); iterator.hasNext();) {
                    Object[] next = (Object[]) iterator.next();

                    String firstHalf = "" + next[1];
                    if (!firstHalf.contains("fullday") && !firstHalf.equals("WO") && !firstHalf.equals("TR") && !firstHalf.equals("AR") && !firstHalf.equals("AB") && !firstHalf.contains("?")
                            && !firstHalf.equals("Casual Leave") && !firstHalf.equals("Short Leave") && !firstHalf.equals("C Off Leave") && !firstHalf.equals("Privilege Leave") && !firstHalf.equals("Sick Leave")
                            && !firstHalf.equals("Paternity Leave") && !firstHalf.equals("Maternity Leave") && !firstHalf.equals("Leave Without Pay") && !firstHalf.equals("Lieu Day Leave")) {
                        Date date1 = sdf.parse("" + next[0]);
                        Calendar c2 = Calendar.getInstance();
                        c2.setTime(date1);
                        SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");
                        String[] userTimeInStr = firstHalf.split("`");
                        String[] userTimeInStr1 = userTimeInStr[1].split("!");
                        String[] userTimeOutStr = firstHalf.split("!");
                        String[] userTimeOutStr1 = userTimeOutStr[1].split("@");
                        Date userTimeIn = sdf2.parse(userTimeInStr1[0]);
                        Date userTimeOut = sdf2.parse(userTimeOutStr1[0]);
                        if (userTimeOut.before(userTimeIn)) {
                            next[1] = ("" + next[1]).replace("AB", "fullday");
    //                        tempList.add(""+next[0]);
    //                        tempList.add(("" + next[1]).replace("AB", "PR"));
                            //===
//                            JSONObject obj = new JSONObject();
//                            obj.put("date", "" + next[0]);
//                            obj.put("attendance_data", "" + next[1]);
//                            jSONArray.put(obj);
                            //====
                            list.set(i, next);
                        }
                    }
                    
                      //---
                    JSONObject obj = new JSONObject();
                    obj.put("date", "" + next[0]);
                    obj.put("attendance_data", "" + next[1]);
                    obj.put("date_of_joining", ""+employeeMaster.getDateOfJoining());
                    jSONArray.put(obj);
                    //---
                    i++;
                }
                map.put(Integer.parseInt(id), list);
                request.setAttribute("attendanceDateList", list);
            }
            //----------
//            if (!empDetail.isEmpty()) {
//                for (int i = 0; i < empDetail.size(); i++) {
//                    Object[] employeeObject = (Object[])empDetail.get(i);
//                    //Object[] objectHoliday =  ()holidayList.get(i);
//                    String date = ""+employeeObject[0];
//                    String attendance_data = ""+employeeObject[1];
//
//                    //Object[] arrayOfObject = (Object[]) list.get(i);
//                    JSONObject obj = new JSONObject();
//
//                    obj.put("date", ""+date);
//
//                    obj.put("attendance_data", ""+attendance_data);
//
//                    jSONArray.put(obj);
//                }
//                rcode = "1";
//                message = "Success";
//            } 
            rcode = "1";
            message = "Success";
            data.put("employeeAttendanceList", jSONArray);
           
        } catch (Exception exception) {
            rcode = "0";
            message = "Error";
        }
        userData.put("data", data);
        userData.put("responseMessage", message);
        userData.put("responseCode", rcode);
        out.print(userData);

    }
}
