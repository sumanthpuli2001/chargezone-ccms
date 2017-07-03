/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.webservice;

import com.bul.zydex.model.AttendanceRegularization;
import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.model.EmailAddMaster;
import com.bul.zydex.model.EmailTemplate;
import com.bul.zydex.model.EmployeeDatetimeData;
import com.bul.zydex.model.EmployeeLeaveBalance;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.EmployeeShiftData;
import com.bul.zydex.model.LeaveTypeMaster;
import com.bul.zydex.model.LevelMaster;
import com.bul.zydex.model.OverTimeMaster;
import com.bul.zydex.model.UserMaster;
import com.bul.zydex.model.UserRightMaster;
import com.bul.zydex.model.support.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Admin
 */
public class AttendanceRegularizationMasterwebServices extends AttendanceRegularizationMasterwebAbstract {

    public void subDisplay(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PrintWriter out = null;
        out = response.getWriter();
        String rcode = "";
        String message = "";

        JSONObject userData = new JSONObject();
        JSONObject data = new JSONObject();
        try {
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
            AttendanceRegularization attendanceRegularization = new AttendanceRegularization();
            List<?> list = attendanceRegularizationMasterService.approvalLeval1WiseAttendanceRegularizationList(employeeMaster.getId());
            List<?> list1 = attendanceRegularizationMasterService.userReportingManager(employeeMaster.getId());
            String managerName = "";
            if (!list1.isEmpty()) {

                JSONArray listsType = new JSONArray();
                employeeMaster = (EmployeeMaster) list1.get(0);
                if (!employeeMaster.getReportingManagerLevel1().equals("")) {
                    List<?> reportingmanagerNameList = employeeMasterService.readByEmployeeLevel1Id(employeeMaster);
                    if (!reportingmanagerNameList.isEmpty()) {
                        Object[] o = (Object[]) reportingmanagerNameList.get(0);
                        managerName = (String) o[2];
                    }
                }

                for (Object o : list) {
                    Object[] ob = (Object[]) o;
                    JSONObject listType = new JSONObject();

                    // listType.put("EMPid",employeeMaster.getEmployeeId()); 
                    AttendanceRegularization ar = attendanceRegularizationMasterService.readById(Integer.parseInt(ob[0].toString()));
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
////////////////////view/////////////

    public void clickView(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PrintWriter out = null;
        out = response.getWriter();
        String rcode = "";
        String message = "";
        JSONArray viewType = new JSONArray();
        JSONObject userData = new JSONObject();
        try {

            AttendanceRegularization attendanceRegularization = new AttendanceRegularization();

            // EmployeeMaster employeeMaster = new EmployeeMaster();
            EmployeeMaster employeeMaster1 = new EmployeeMaster();
            String id = request.getParameter("id");
            JSONObject data = doConvert(request);

            String empMastId = data.getString("EmpId");
            String attid = data.getString("Attendenceregularization_id");

            EmployeeMaster employeeMaster = employeeMasterService.readById(Integer.parseInt(empMastId));

            attendanceRegularization = attendanceRegularizationMasterService.readById(Integer.parseInt(attid));
            employeeMaster.setDepartmentMaster(departmentMasterService.readById(employeeMaster.getDepartmentMaster().getId()));
            employeeMaster.setLevelMaster(levelMasterService.readById(employeeMaster.getLevelMaster().getId()));
            employeeMaster.setLocationMaster(locationMasterService.readById(employeeMaster.getLocationMaster().getId()));

            int status1 = attendanceRegularization.getStatus();
            String status = Integer.toString(status1);
            request.setAttribute("status", status);
            String remarkNmame = attendanceRegularization.getManagerRemark();
            request.setAttribute("remarkNmame", remarkNmame);
            int userId = attendanceRegularization.getUserMasterId();
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
            views.put("StartDateTime", attendanceRegularization.getStartDateTime());
            views.put("End DateTime:", attendanceRegularization.getEndDateTime());
            views.put("Reason:", attendanceRegularization.getReason());
            views.put("Work_location", employeeMaster.getLocationMaster().getLocation());
            views.put("Level", employeeMaster.getLevelMaster().getLevel());
            views.put("DeptName", employeeMaster.getDepartmentMaster().getDepartmentName());
            views.put("Attendenceregularization_id", attendanceRegularization.getId());
            String status_Messsage = "";
            if (attendanceRegularization.getStatus() == 0) {
                status_Messsage = "Pending";
            } else if (attendanceRegularization.getStatus() == 1) {
                status_Messsage = "Approved";

            } else if (attendanceRegularization.getStatus() == 7) {
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
    ////////Approve/////

    public void approvalByAdmin(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String rcode = "";
        String message = "";
        PrintWriter out = null;
        out = response.getWriter();
        JSONObject userData = new JSONObject();

        try {

            AttendanceRegularization attendanceRegularization = new AttendanceRegularization();
            String id = "" + request.getParameter("id");
            JSONObject data = doConvert(request);

            String empId = data.getString("EmpId");
            String attid = data.getString("Attendenceregularization_id");
//        String remark = "" + request.getParameter("remark");
            String remark = "";
            attendanceRegularization = attendanceRegularizationMasterService.readById(Integer.parseInt(attid));
            attendanceRegularization.setStatus(1);
            attendanceRegularization.setManagerRemark(remark);

//        EmployeeMaster approverName = new EmployeeMaster();
            EmployeeMaster approverName = employeeMasterService.readById(Integer.parseInt(empId));
            //EmployeeMaster approverName = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String requestdate = sdf.format(new Date());
            attendanceRegularization.setApprovedDate(requestdate);
            attendanceRegularization.setEmployeeMaster(approverName);
            attendanceRegularizationMasterService.createOrUpdate(attendanceRegularization);

//        Employee Date Time Data
            if (attendanceRegularization.getStatus() == 1) {
                int userId = attendanceRegularization.getUserMasterId();
                UserMaster userMaster = new UserMaster();
                userMaster.setId(userId);
                EmployeeMaster employeeMaster = new EmployeeMaster();
                employeeMaster.setUserMaster(userMaster);
                List<?> l = employeeMasterService.readByEmployeeUserId(employeeMaster);
                employeeMaster = (EmployeeMaster) l.get(0);
                String startDate = attendanceRegularization.getStartDateTime();
                String endDate = attendanceRegularization.getEndDateTime();
                EmployeeDatetimeData employeeDatetimeData = new EmployeeDatetimeData();
                EmployeeDatetimeData employeeDatetimeData1 = new EmployeeDatetimeData();
                employeeDatetimeData.setEmployeeMaster(employeeMaster);
                employeeDatetimeData.setDateTime(startDate);
                employeeDatetimeData1.setEmployeeMaster(employeeMaster);
                employeeDatetimeData1.setDateTime(endDate);
//            employeeDatetimeDataService.createOrUpdate(employeeDatetimeData);
//            employeeDatetimeDataService.createOrUpdate(employeeDatetimeData1);

                EmployeeShiftData employeeShiftData = new EmployeeShiftData();
                EmployeeShiftData employeeShiftData1 = new EmployeeShiftData();
                employeeShiftData.setInDateTime(startDate);
                employeeShiftData.setEmployeeMaster(employeeMaster);
                List<?> shift = employeeShiftDataService.attendanceRegularizationEntry(employeeShiftData);
                if (!shift.isEmpty()) {
                    employeeShiftData1 = (EmployeeShiftData) shift.get(0);
                    employeeShiftData1.setInDateTime(startDate);
                    employeeShiftData1.setOutDateTime(endDate);
                    employeeShiftData1.setEmployeeMaster(employeeMaster);
                    employeeShiftData1.setShiftMaster(employeeShiftData1.getShiftMaster());
//                employeeShiftDataService.update(employeeShiftData1);
                }

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
    }

    //reject//
    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@    
    public void subrejectSubmitByAdmin(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String rcode = "";
        String message = "";
        PrintWriter out = null;
        out = response.getWriter();
        JSONObject userData = new JSONObject();

        try {
            EmployeeMaster employeeMaster = new EmployeeMaster();
            UserMaster user = new UserMaster();
            AttendanceRegularization attendanceRegularization = new AttendanceRegularization();
            String id = request.getParameter("id");
            int userid = Integer.parseInt(id);
            user.setId(userid);
            employeeMaster.setUserMaster(user);
            JSONObject data = doConvert(request);

            String empId = data.getString("EmpId");
            String attid = data.getString("Attendenceregularization_id");
            String remark = "";
            attendanceRegularization = attendanceRegularizationMasterService.readById(Integer.parseInt(attid));
            attendanceRegularization.setStatus(3);
            attendanceRegularization.setManagerRemark(remark);
            EmployeeMaster approverName = employeeMasterService.readById(Integer.parseInt(empId));
//        EmployeeMaster approverName = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String requestdate = sdf.format(new Date());
            attendanceRegularization.setApprovedDate(requestdate);
            attendanceRegularization.setEmployeeMaster(approverName);
            attendanceRegularizationMasterService.createOrUpdate(attendanceRegularization);

            EmailTemplate emailTemplate = new EmailTemplate();
            EmployeeMaster employeeMasterModel = employeeMasterService.readById(Integer.parseInt(empId));
            employeeMaster = employeeMasterService.readById(Integer.parseInt(employeeMasterModel.getReportingManagerLevel1()));
            DesignationMaster designationMaster = designationMasterService.readById(employeeMaster.getDesignationMaster().getId());
            UserMaster userMaster = new UserMaster();
            userMaster.setId(attendanceRegularization.getUserMasterId());
            EmployeeMaster employeeMaster1 = new EmployeeMaster();
            employeeMaster1.setUserMaster(userMaster);
            List list = employeeMasterService.readByUserName(employeeMasterModel);
            emailTemplate = emailTemplateService.readById(17);
            if (!list.isEmpty()) {
                employeeMaster1 = (EmployeeMaster) list.get(0);
                String To = employeeMasterModel.getOfficeEmailId();
                String from = employeeMaster.getOfficeEmailId();
                String Subject = emailTemplate.getSubject();
                Subject = Subject.replaceAll("\\{user\\}", employeeMasterModel.getEmployeeName());
                String msg = emailTemplate.getBodytext();
                msg = msg.replaceAll("\\{to_user\\}", employeeMasterModel.getEmployeeName());
                msg = msg.replaceAll("\\{from_user\\}", employeeMaster.getEmployeeName());
                msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                sendMail.sendMail(from, To, Subject, msg);

//                }
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

    }

    /////////////////////rework///////////////////
    public void subReworkSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String rcode = "";
        String message = "";
        PrintWriter out = null;
        out = response.getWriter();
        JSONObject userData = new JSONObject();

        try {
            EmployeeMaster employeeMaster = new EmployeeMaster();
            UserMaster user = new UserMaster();
            AttendanceRegularization attendanceRegularization = new AttendanceRegularization();
            String id = request.getParameter("id");
            int userid = Integer.parseInt(id);
            user.setId(userid);
            employeeMaster.setUserMaster(user);
            JSONObject data = doConvert(request);

            String empId = data.getString("EmpId");
            String attid = data.getString("Attendenceregularization_id");
            String remark = "";
            attendanceRegularization = attendanceRegularizationMasterService.readById(Integer.parseInt(attid));
            attendanceRegularization.setStatus(7);
            attendanceRegularization.setManagerRemark(remark);
            EmployeeMaster approverName = employeeMasterService.readById(Integer.parseInt(empId));

//        EmployeeMaster approverName = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String requestdate = sdf.format(new Date());
            attendanceRegularization.setApprovedDate(requestdate);
            attendanceRegularization.setEmployeeMaster(approverName);
            attendanceRegularizationMasterService.createOrUpdate(attendanceRegularization);

            EmailTemplate emailTemplate = new EmailTemplate();
            EmployeeMaster employeeMasterModel = employeeMasterService.readById(Integer.parseInt(empId));
            employeeMaster = employeeMasterService.readById(Integer.parseInt(employeeMasterModel.getReportingManagerLevel1()));
//            EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
            DesignationMaster designationMaster = designationMasterService.readById(employeeMaster.getDesignationMaster().getId());
            EmployeeMaster employeeMaster1 = new EmployeeMaster();
            //id=16 is for attandence regularization rework...
            emailTemplate = emailTemplateService.readById(16);
            UserMaster userMaster = new UserMaster();
            userMaster.setId(attendanceRegularization.getUserMasterId());
            employeeMaster1.setUserMaster(userMaster);
            List<?> list = employeeMasterService.readByUserName(employeeMasterModel);
//            String EmpStr = request.getParameter("empid");
//            if (null != EmpStr && !"".equals(EmpStr)) {
//                int Empid = Integer.parseInt(EmpStr);
//                List list = employeeMasterService.readByEmployeeNo(Empid);
            if (!list.isEmpty()) {
                employeeMaster1 = (EmployeeMaster) list.get(0);
                String To = employeeMasterModel.getOfficeEmailId();
                String from = employeeMaster.getOfficeEmailId();
                String Subject = emailTemplate.getSubject();
                Subject = Subject.replaceAll("\\{user\\}", employeeMasterModel.getEmployeeName());
                String msg = emailTemplate.getBodytext();
                msg = msg.replaceAll("\\{to_user\\}", employeeMasterModel.getEmployeeName());
                msg = msg.replaceAll("\\{from_user\\}", employeeMaster.getEmployeeName());
                msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                sendMail.sendMail(from, To, Subject, msg);

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
    }

    public void AttendanceRegularizationResult(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PrintWriter out = null;
        out = response.getWriter();
        String rcode = "";
        String message = "";
        UserMaster user = new UserMaster();

        JSONObject userData = new JSONObject();
        JSONObject data = new JSONObject();
        AttendanceRegularization attendanceRegularization = new AttendanceRegularization();
        try {
            String id = request.getParameter("id");
            int userid = Integer.parseInt(id);
            user.setId(userid);
            EmployeeMaster employeeMaster = new EmployeeMaster();
            employeeMaster.setUserMaster(user);
            List<?> list1 = attendanceRegularizationMasterService.userReportingManager(Integer.parseInt(id));
            List<?> list = attendanceRegularizationMasterService.userWiseAttendanceRegularizationList(Integer.parseInt(id));

            String managerName = "";
            EmployeeMaster employeeMaster1 = new EmployeeMaster();
            if (!list1.isEmpty()) {
                employeeMaster = (EmployeeMaster) list1.get(0);

                employeeMaster1 = employeeMasterService.readById(Integer.parseInt(employeeMaster.getReportingManagerLevel1()));

            }
            if (!list.isEmpty()) {

                JSONArray listsType = new JSONArray();
                employeeMaster = (EmployeeMaster) list1.get(0);
                if (!employeeMaster.getReportingManagerLevel1().equals("")) {

                }

                for (int i = 0; i < list.size(); i++) {
                    AttendanceRegularization atendanceRegularization = (AttendanceRegularization) list.get(i);;
                    JSONObject listType = new JSONObject();
                    listType.put("Attendenceregularization_id", atendanceRegularization.getId());
                    listType.put("StartDate", atendanceRegularization.getStartDateTime());
                    listType.put("Reason", atendanceRegularization.getReason());
                    listType.put("Status", atendanceRegularization.getStatus());
                    listType.put("EndDateTime", atendanceRegularization.getEndDateTime());
                    listType.put("DateOfSubmit", atendanceRegularization.getDateOfSubmit());
                    String dateOfSubmit = "";
                    if (null != atendanceRegularization.getDateOfSubmit()) {
                        dateOfSubmit = atendanceRegularization.getDateOfSubmit();
                    }
                    listType.put("dateOfSubmit", dateOfSubmit);

                    String status_Messsage = "";
                    if (atendanceRegularization.getStatus() == 0) {
                        status_Messsage = "Pending";
                    } else if (atendanceRegularization.getStatus() == 1) {
                        status_Messsage = "Approved";
                    } else if (atendanceRegularization.getStatus() == 7) {
                        status_Messsage = "Rework";
                    } else if (atendanceRegularization.getStatus() == 3) {
                        status_Messsage = "Rejected";
                    } else if (atendanceRegularization.getStatus() == 2) {
                        status_Messsage = "Withdrawn";
                    }
                    listType.put("StatusMsg", status_Messsage);
                    listsType.put(listType);
                    data.put("Attendance Regularization List", listsType);
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

    public void ViewAttendanceRegularization(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
            AttendanceRegularization attendanceRegularization = new AttendanceRegularization();
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

                    attendanceRegularization = attendanceRegularizationMasterService.readById(Integer.parseInt(Attendenceregularizationid));
                    userData.put("StartDateTime", attendanceRegularization.getStartDateTime());
                    userData.put("EndDateTime", attendanceRegularization.getEndDateTime());
                    userData.put("DateOfSubmit", attendanceRegularization.getDateOfSubmit());
                    userData.put("Reason", attendanceRegularization.getReason());
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

    public void ArWithdraw(HttpServletRequest request, HttpServletResponse response) throws Exception {

        PrintWriter out = null;
        out = response.getWriter();
        String rcode = "";
        String message = "";
        JSONObject userData = new JSONObject();
        AttendanceRegularization attendanceRegularization = new AttendanceRegularization();
        AttendanceRegularization attendanceRegularization1 = new AttendanceRegularization();
        UserMaster user = new UserMaster();
        String id = request.getParameter("id");
        int userid = Integer.parseInt(id);
        user.setId(userid);
        try {
            JSONObject data1 = doPost(request);
            String Attendenceregularizationid = data1.getString("Attendenceregularizationid");
            String btnSubmit = data1.getString("btnSubmit");
            attendanceRegularization1 = attendanceRegularizationMasterService.readById(Integer.parseInt(Attendenceregularizationid));
            if (btnSubmit.equals("Submit")) {

                if (attendanceRegularization1.getStatus() == 7) {
                    attendanceRegularization.setStatus(0);
                    attendanceRegularization.setManagerRemark(attendanceRegularization1.getManagerRemark());
                    attendanceRegularization.setUserMasterId(attendanceRegularization1.getUserMasterId());
                } else {
                    attendanceRegularization.setStatus(2);
                    attendanceRegularization.setManagerRemark(attendanceRegularization1.getManagerRemark());
                    attendanceRegularization.setUserMasterId(attendanceRegularization1.getUserMasterId());
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
                attendanceRegularization = attendanceRegularizationMasterService.readById(Integer.parseInt(Attendenceregularizationid));
                attendanceRegularization.setStatus(2);
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
            attendanceRegularization.setDateOfSubmit(currentDate);
            attendanceRegularizationMasterService.createOrUpdate(attendanceRegularization);

        } catch (Exception e) {
            rcode = "1";
            message = "Something went wrong";
            e.printStackTrace();
        }
        userData.put("responseMessage", message);
        userData.put("responseCode", rcode);
        out.print(userData);

    }

    public void createARRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException, ServletException {
        PrintWriter out = null;
        out = response.getWriter();
        String rcode = "";
        String message = "";
        EmployeeMaster employeeMaster = new EmployeeMaster();
        UserMaster userMaster = new UserMaster();
        UserMaster user = new UserMaster();
        String id = request.getParameter("id");
        int userid = Integer.parseInt(id);
        user.setId(userid);
        employeeMaster.setUserMaster(user);
        JSONObject userData = new JSONObject();
        JSONObject data = doPost(request);
        try {

            AttendanceRegularization attendanceRegularization = new AttendanceRegularization();
            SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            String Startdate = data.getString("startdate");
            String enddate = data.getString("enddate");
            String reason = data.getString("reason");
            String userId = data.getString("userId");
            int userMasterId = Integer.parseInt(userId);

            Date sdate = dateFormat1.parse(Startdate);
            Date edate = dateFormat1.parse(enddate);

            attendanceRegularization.setUserMasterId(userMasterId);
            attendanceRegularization.setStartDateTime(sdate.toString());
            attendanceRegularization.setEndDateTime(edate.toString());
            attendanceRegularization.setReason(reason);
            attendanceRegularization.setStatus(0);

            String currentDate = dateFormat1.format(new Date());
            attendanceRegularization.setDateOfSubmit(currentDate);
            attendanceRegularizationMasterService.createOrUpdate(attendanceRegularization);

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

}
