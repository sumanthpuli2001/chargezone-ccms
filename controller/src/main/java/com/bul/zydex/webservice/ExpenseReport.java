/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.webservice;

import com.bul.zydex.model.CurrencyMaster;
import com.bul.zydex.model.DepartmentMaster;
import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.model.EmailTemplate;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.ExpenseMaster;
import com.bul.zydex.model.ExpenseOtherType;
import com.bul.zydex.model.ExpenseReconsilation;
import com.bul.zydex.model.ExpenseTravelType;
import com.bul.zydex.model.LeaveEmployeeDetail;
import com.bul.zydex.model.LevelMaster;
import com.bul.zydex.model.LocationMaster;
import com.bul.zydex.model.RelocationOrOtherExpense;
import com.bul.zydex.model.TravelRequestMaster;
import com.bul.zydex.model.UserMaster;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import javax.json.JsonArray;
import javax.json.JsonValue;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author admin
 */
public class ExpenseReport extends ExpenseReportAbstarct {

    public void expenseList(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, JSONException {
        PrintWriter out = null;
        out = response.getWriter();
        String rcode = "";
        String message = "";
        JSONObject userData = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        try {
            UserMaster user = new UserMaster();
            EmployeeMaster employeeMaster = new EmployeeMaster();
            EmployeeMaster employeeMaster1 = new EmployeeMaster();
            String id = request.getParameter("id");
            int userid = Integer.parseInt(id);
            user.setId(userid);
            employeeMaster.setUserMaster(user);
            List<?> empDetailList = employeeMasterService.readByEmployeeUserId(employeeMaster);
            if (!empDetailList.isEmpty()) {
                employeeMaster1 = (EmployeeMaster) empDetailList.get(0);

            }
            String expenseType = "";
            String dateOfSubmit = "";
            String statusmsg = "";
            String ApproveName = "";
            String ApproveName1 = "";
            int status = 0;
            int expenseid = 0;
            ExpenseMaster expenseMaster = new ExpenseMaster();
            expenseMaster.setEmployeeMasterByEmployeeId(employeeMaster1);
            List<?> travelTypeList = new ArrayList<Object>();
            List<?> travelOtherTypeList = new ArrayList<Object>();
            List<?> relocationTypeList = new ArrayList<Object>();
            List<?> relocationOtherTypeList = new ArrayList<Object>();
            List<?> policyOtherTypeList = new ArrayList<Object>();
            List<?> othersList = new ArrayList<Object>();
            List<ExpenseMaster> list = (List<ExpenseMaster>) expenseMasterService.readByEmpId(expenseMaster);
            if (!list.isEmpty()) {
                for (ExpenseMaster expenselist : list) {

                    expenseType = expenselist.getExpenseType();
                    dateOfSubmit = expenselist.getDateOfSubmit();
                    status = expenselist.getStatus();
                    expenseid = expenselist.getId();

                    String flag3 = "true";
                    if (expenseType.equals("Travel")) {
                        travelTypeList = expenseTravelTypeService.readByExpenseMasterId(expenseid);
                        for (Object o : travelTypeList) {
                            ExpenseTravelType expenseTravelType = (ExpenseTravelType) o;
                            if (expenseTravelType.getStatus() != 1) {
                                flag3 = "false";
                            }

                        }
                        travelOtherTypeList = relocationOrOtherExpenseService.readByExpenseMasterId(expenseid);
                        for (Object o2 : travelOtherTypeList) {
                            RelocationOrOtherExpense relocationOrOtherExpense = (RelocationOrOtherExpense) o2;
                            if (relocationOrOtherExpense.getStatus() != 1) {
                                flag3 = "false";
                            }

                        }
                    }
                    if (expenseType.equals("Relocation")) {
                        relocationTypeList = expenseTravelTypeService.readByExpenseMasterId(expenseid);
                        for (Object o3 : relocationTypeList) {
                            ExpenseTravelType expenseTravelType = (ExpenseTravelType) o3;
                            if (expenseTravelType.getStatus() != 1) {
                                flag3 = "false";
                            }

                        }
                        relocationOtherTypeList = relocationOrOtherExpenseService.readByExpenseMasterId(expenseid);
                        for (Object o4 : relocationOtherTypeList) {
                            RelocationOrOtherExpense relocationOrOtherExpense = (RelocationOrOtherExpense) o4;
                            if (relocationOrOtherExpense.getStatus() != 1) {
                                flag3 = "false";
                            }
                        }
                    }
                    if (expenseType.equals("PolicyReimbursements")) {
                        policyOtherTypeList = relocationOrOtherExpenseService.readByExpenseMasterId(expenseid);
                        for (Object policyReimb : policyOtherTypeList) {
                            RelocationOrOtherExpense relocationOrOtherExpense = (RelocationOrOtherExpense) policyReimb;
                            if (relocationOrOtherExpense.getStatus() != 1) {
                                flag3 = "false";
                            }
                        }
                    }
                    if (expenseType.equals("Others")) {
                        othersList = expenseOtherTypeService.readByExpenseMasterId(expenseid);
                        for (Object o1 : othersList) {
                            ExpenseOtherType expenseOtherType = (ExpenseOtherType) o1;
                            System.out.println("ajay" + expenseOtherType.getStatus());
                            if (expenseOtherType.getStatus() != 1) {
                                flag3 = "false";
                            }
                        }
                    }
                    if (null != expenselist.getEmployeeMasterByApprover1Id()) {
                        int approverid = expenselist.getEmployeeMasterByApprover1Id().getId();
                        EmployeeMaster employeeMasterApprover = employeeMasterService.readById(approverid);

                        if ((employeeMasterApprover.getEmployeeName()).equals("") || (employeeMasterApprover.getEmployeeName()).equals(null)) {
                            ApproveName = "";
                        } else {
                            ApproveName = employeeMasterApprover.getEmployeeName();
                        }
                    }
                    if (status == 0) {
                        statusmsg = "Pending ";
                    }

                    if (status == 1) {
                        statusmsg = "Reworked By " + ApproveName;
                    }
                    if (status == 2) {
                        if (flag3.equals("false")) {
                            statusmsg = "Partially Approved By " + ApproveName;
                        } else {
                            status = 5;
                            statusmsg = "Approved By " + ApproveName;
                        }
                    }
                    if (status == 3) {
                        statusmsg = "Saved As Draft";
                    }
                    if (status == 10) {
                        statusmsg = "Rejected By " + ApproveName;
                    }
                    if (null != expenselist.getEmployeeMasterByApprover2Id()) {
                        int approverid1 = expenselist.getEmployeeMasterByApprover2Id().getId();
                        EmployeeMaster employeeMasterApprover1 = employeeMasterService.readById(approverid1);
                        if ((employeeMasterApprover1.getEmployeeName()).equals("") || (employeeMasterApprover1.getEmployeeName()).equals(null)) {
                            ApproveName1 = "";
                        } else {
                            ApproveName1 = employeeMasterApprover1.getEmployeeName();
                        }
                    }

                    if (status == 4) {
                        statusmsg = "Final Approved By " + ApproveName1;
                    }

                    JSONObject data = new JSONObject();
                    data.put("expenseType", expenseType);
                    data.put("dateOfSubmit", dateOfSubmit);
                    data.put("expenseid", expenseid);
                    data.put("status", status);
                    data.put("statusmessage", statusmsg);
                    jsonArray.put(data);
                }
                message = "Success";
                rcode = "1";
            } else {
                message = "There is NO Record Found";
                rcode = "2";
            }
        } catch (Exception exception) {
            message = "Error";
            rcode = "0";

        }
        userData.put("data", jsonArray);
        userData.put("responseMessage", message);
        userData.put("responseCode", rcode);
        out.println(userData);

    }

    public void ExpenseRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

        PrintWriter out = null;
        out = response.getWriter();
        String rcode = "";
        String message = "";
        UserMaster user = new UserMaster();
        ExpenseMaster expenseMaster = new ExpenseMaster();
        ExpenseMaster expenseMaster1 = new ExpenseMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        JSONObject Data = new JSONObject();
        JSONObject jsonobj = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray1 = new JSONArray();
        List<?> travelTypeList = new ArrayList<Object>();
        List<?> relocationTypeList = new ArrayList<Object>();
        List<?> travelOtherTypeList = new ArrayList<Object>();
        List<?> relocationOtherTypeList = new ArrayList<Object>();
        List<?> policyOtherTypeList = new ArrayList<Object>();
        List<?> othersList = new ArrayList<Object>();
//        try {
        String id = request.getParameter("id");
        int userid = Integer.parseInt(id);
        user.setId(userid);
        employeeMaster.setUserMaster(user);
        UserMaster userMaster = userMasterService.readById(userid);
        List<?> empList = employeeMasterService.readByUserName(employeeMaster);
        if (!empList.isEmpty()) {
            employeeMaster1 = (EmployeeMaster) empList.get(0);
            expenseMaster.setEmployeeMasterByEmployeeId(employeeMaster);
            ExpenseMaster em = expenseMasterService.readById(userid);

            List<?> reportingLevel1List = expenseMasterService.readExpenseRequestByReportingLevel1(expenseMaster1, "" + employeeMaster1.getId());
            if (!reportingLevel1List.isEmpty()) {

                Integer expenseId = 0;
                Integer empMasterId = 0;
                String employeeId = "";
                String employeeName = "";
                String expenseType = "";
                String reportingManager = "";
                String dateOfSubmit = "";
                Integer Status = 0;

                for (int i = 0; i < reportingLevel1List.size(); i++) {
                    Object[] obj = (Object[]) reportingLevel1List.get(i);
                    JSONObject jsono = new JSONObject();
                    expenseId = (int) obj[0];
                    empMasterId = (int) obj[6];
                    reportingManager = (String) obj[7];
                    employeeId = (String) obj[2];
                    employeeName = (String) obj[3];
                    expenseType = (String) obj[4];
                    dateOfSubmit = (String) obj[1];
                    Status = (int) obj[5];

                    String flag3 = "true";
                    if (expenseType.equals("Travel")) {
                        travelTypeList = expenseTravelTypeService.readByExpenseMasterId(expenseId);
                        for (Object o : travelTypeList) {
                            ExpenseTravelType expenseTravelType = (ExpenseTravelType) o;
                            if (expenseTravelType.getStatus() != 1) {
                                flag3 = "false";
                            }

                        }
                        travelOtherTypeList = relocationOrOtherExpenseService.readByExpenseMasterId(expenseId);
                        for (Object o2 : travelOtherTypeList) {
                            RelocationOrOtherExpense relocationOrOtherExpense = (RelocationOrOtherExpense) o2;
                            if (relocationOrOtherExpense.getStatus() != 1) {
                                flag3 = "false";
                            }

                        }
                    }

                    if (expenseType.equals("Relocation")) {
                        relocationTypeList = expenseTravelTypeService.readByExpenseMasterId(expenseId);
                        for (Object o3 : relocationTypeList) {
                            ExpenseTravelType expenseTravelType = (ExpenseTravelType) o3;
                            if (expenseTravelType.getStatus() != 1) {
                                flag3 = "false";
                            }

                        }
                        relocationOtherTypeList = relocationOrOtherExpenseService.readByExpenseMasterId(expenseId);
                        for (Object o4 : relocationOtherTypeList) {
                            RelocationOrOtherExpense relocationOrOtherExpense = (RelocationOrOtherExpense) o4;
                            if (relocationOrOtherExpense.getStatus() != 1) {
                                flag3 = "false";
                            }
                        }
                    }
                    if (expenseType.equals("PolicyReimbursements")) {
                        policyOtherTypeList = relocationOrOtherExpenseService.readByExpenseMasterId(expenseId);
                        for (Object policyReimb : policyOtherTypeList) {
                            RelocationOrOtherExpense relocationOrOtherExpense = (RelocationOrOtherExpense) policyReimb;
                            if (relocationOrOtherExpense.getStatus() != 1) {
                                flag3 = "false";
                            }
                        }
                    }
                    if (expenseType.equals("Others")) {
                        othersList = expenseOtherTypeService.readByExpenseMasterId(expenseId);
                        for (Object o1 : othersList) {
                            ExpenseOtherType expenseOtherType = (ExpenseOtherType) o1;
                            System.out.println("ajay" + expenseOtherType.getStatus());
                            if (expenseOtherType.getStatus() != 1) {
                                flag3 = "false";
                            }
                        }
                    }

                    jsono.put("expenseId", expenseId);
                    jsono.put("empMasterId", empMasterId);
                    jsono.put("employeeId", employeeId);
                    jsono.put("employeeName", employeeName);
                    jsono.put("expenseType", expenseType);
                    jsono.put("dateOfSubmit", dateOfSubmit);
//                    jsono.put("reportingManager", reportingManager);

                    String Statusmessage = "";
                    if (Status.equals(0)) {
                        Statusmessage = "Pending";
                    } else if (Status.equals(1)) {
                        Statusmessage = "Rework By " + reportingManager;

                    } else if (Status.equals(2)) {
                        if (flag3 == "false") {
                            Statusmessage = "Partially Approved By " + reportingManager;
                        } else {
                            Status = 5;
                            Statusmessage = "Approved By " + reportingManager;
                        }

                    } else if (Status.equals(3)) {
                        Statusmessage = "Saved As Draft";

                    } else if (Status.equals(4)) {
                        Statusmessage = "Final Approved By " + reportingManager;

                    } else if (Status.equals(10)) {
                        Statusmessage = "Rejected By " + reportingManager;

                    }
                    jsono.put("status", Status);
                    jsono.put("statusmessage", Statusmessage);
                    jSONArray.put(jsono);
                    message = "Success";
                    rcode = "1";

                }
            }
//            List<?> reportingLevel2List = expenseMasterService.readExpenseRequestByReportingLevel2(expenseMaster1, "" + employeeMaster1.getId());
//
//            if (!reportingLevel2List.isEmpty()) {
//
//                Integer expenseId2 = 0;
//                Integer empMasterId2 = 0;
//                String employeeId2 = "";
//                String employeeName2 = "";
//                String expenseType2 = "";
//                String reportingManager2 = "";
//                String dateOfSubmit2 = "";
//                Integer Status2 = 0;
//
//                for (int i = 0; i < reportingLevel2List.size(); i++) {
//                    Object[] obj = (Object[]) reportingLevel2List.get(i);
//                    JSONObject jsono = new JSONObject();
//                    expenseId2 = (int) obj[0];
//                    empMasterId2 = (int) obj[6];
//                    reportingManager2 = (String) obj[7];
//                    employeeId2 = (String) obj[2];
//                    employeeName2 = (String) obj[3];
//                    expenseType2 = (String) obj[4];
//                    dateOfSubmit2 = (String) obj[1];
//                    Status2 = (int) obj[5];
//
//                    String flag32 = "true";
//                    if (expenseType2.equals("Travel")) {
//                        travelTypeList = expenseTravelTypeService.readByExpenseMasterId(expenseId2);
//                        for (Object o : travelTypeList) {
//                            ExpenseTravelType expenseTravelType = (ExpenseTravelType) o;
//                            if (expenseTravelType.getStatus() != 1) {
//                                flag32 = "false";
//                            }
//
//                        }
//                        travelOtherTypeList = relocationOrOtherExpenseService.readByExpenseMasterId(expenseId2);
//                        for (Object o2 : travelOtherTypeList) {
//                            RelocationOrOtherExpense relocationOrOtherExpense = (RelocationOrOtherExpense) o2;
//                            if (relocationOrOtherExpense.getStatus() != 1) {
//                                flag32 = "false";
//                            }
//
//                        }
//                    }
//
//                    if (expenseType2.equals("Relocation")) {
//                        relocationTypeList = expenseTravelTypeService.readByExpenseMasterId(expenseId2);
//                        for (Object o3 : relocationTypeList) {
//                            ExpenseTravelType expenseTravelType = (ExpenseTravelType) o3;
//                            if (expenseTravelType.getStatus() != 1) {
//                                flag32 = "false";
//                            }
//
//                        }
//                        relocationOtherTypeList = relocationOrOtherExpenseService.readByExpenseMasterId(expenseId2);
//                        for (Object o4 : relocationOtherTypeList) {
//                            RelocationOrOtherExpense relocationOrOtherExpense = (RelocationOrOtherExpense) o4;
//                            if (relocationOrOtherExpense.getStatus() != 1) {
//                                flag32 = "false";
//                            }
//                        }
//                    }
//                    if (expenseType2.equals("PolicyReimbursements")) {
//                        policyOtherTypeList = relocationOrOtherExpenseService.readByExpenseMasterId(expenseId2);
//                        for (Object policyReimb : policyOtherTypeList) {
//                            RelocationOrOtherExpense relocationOrOtherExpense = (RelocationOrOtherExpense) policyReimb;
//                            if (relocationOrOtherExpense.getStatus() != 1) {
//                                flag32 = "false";
//                            }
//                        }
//                    }
//                    if (expenseType2.equals("Others")) {
//                        othersList = expenseOtherTypeService.readByExpenseMasterId(expenseId2);
//                        for (Object o1 : othersList) {
//                            ExpenseOtherType expenseOtherType = (ExpenseOtherType) o1;
//                            System.out.println("ajay" + expenseOtherType.getStatus());
//                            if (expenseOtherType.getStatus() != 1) {
//                                flag32 = "false";
//                            }
//                        }
//                    }
//
//                    jsono.put("expenseId", expenseId2);
//                    jsono.put("empMasterId", empMasterId2);
//                    jsono.put("employeeId", employeeId2);
//                    jsono.put("employeeName", employeeName2);
//                    jsono.put("expenseType", expenseType2);
//                    jsono.put("dateOfSubmit", dateOfSubmit2);
//                    jsono.put("reportingManager", reportingManager2);
//
//                    String Statusmessage = "";
//                    if (Status2.equals(0)) {
//                        Statusmessage = "Pending";
//                    } else if (Status2.equals(1)) {
//                        Statusmessage = "Rework By " + reportingManager2;
//
//                    } else if (Status2.equals(2)) {
//                        if (flag32 == "false") {
//                            Statusmessage = "Partially Approved By " + reportingManager2;
//                        } else {
//                            Status2 = 5;
//                            Statusmessage = "Approved By " + reportingManager2;
//                        }
//
//                    } else if (Status2.equals(3)) {
//                        Statusmessage = "Saved As Draft";
//
//                    } else if (Status2.equals(4)) {
//                        Statusmessage = "Final Approved By " + reportingManager2;
//
//                    } else if (Status2.equals(10)) {
//                        Statusmessage = "Rejected By " + reportingManager2;
//
//                    }
//                    jsono.put("status", Status2);
//                    jsono.put("statusmessage", Statusmessage);
//                    jSONArray.put(jsono);
//                    message = "Success";
//                    rcode = "1";
//
//                }
//
//            }

//            List<?> reportingLevel3List = expenseMasterService.readExpenseRequestByReportingLevel3(expenseMaster1, "" + employeeMaster1.getId());
//            if (!reportingLevel3List.isEmpty()) {
//
//                Integer expenseId3 = 0;
//                Integer empMasterId3 = 0;
//                String employeeId3 = "";
//                String employeeName3 = "";
//                String expenseType3 = "";
//                String reportingManager3 = "";
//                String dateOfSubmit3 = "";
//                Integer Status3 = 0;
//
//                for (int i = 0; i < reportingLevel3List.size(); i++) {
//                    Object[] obj = (Object[]) reportingLevel3List.get(i);
//                    JSONObject jsono = new JSONObject();
//                    expenseId3 = (int) obj[0];
//                    empMasterId3 = (int) obj[6];
//                    reportingManager3 = (String) obj[7];
//                    employeeId3 = (String) obj[2];
//                    employeeName3 = (String) obj[3];
//                    expenseType3 = (String) obj[4];
//                    dateOfSubmit3 = (String) obj[1];
//                    Status3 = (int) obj[5];
//
//                    String flag33 = "true";
//                    if (expenseType3.equals("Travel")) {
//                        travelTypeList = expenseTravelTypeService.readByExpenseMasterId(expenseId3);
//                        for (Object o : travelTypeList) {
//                            ExpenseTravelType expenseTravelType = (ExpenseTravelType) o;
//                            if (expenseTravelType.getStatus() != 1) {
//                                flag33 = "false";
//                            }
//
//                        }
//                        travelOtherTypeList = relocationOrOtherExpenseService.readByExpenseMasterId(expenseId3);
//                        for (Object o2 : travelOtherTypeList) {
//                            RelocationOrOtherExpense relocationOrOtherExpense = (RelocationOrOtherExpense) o2;
//                            if (relocationOrOtherExpense.getStatus() != 1) {
//                                flag33 = "false";
//                            }
//
//                        }
//                    }
//
//                    if (expenseType3.equals("Relocation")) {
//                        relocationTypeList = expenseTravelTypeService.readByExpenseMasterId(expenseId3);
//                        for (Object o3 : relocationTypeList) {
//                            ExpenseTravelType expenseTravelType = (ExpenseTravelType) o3;
//                            if (expenseTravelType.getStatus() != 1) {
//                                flag33 = "false";
//                            }
//
//                        }
//                        relocationOtherTypeList = relocationOrOtherExpenseService.readByExpenseMasterId(expenseId3);
//                        for (Object o4 : relocationOtherTypeList) {
//                            RelocationOrOtherExpense relocationOrOtherExpense = (RelocationOrOtherExpense) o4;
//                            if (relocationOrOtherExpense.getStatus() != 1) {
//                                flag33 = "false";
//                            }
//                        }
//                    }
//                    if (expenseType3.equals("PolicyReimbursements")) {
//                        policyOtherTypeList = relocationOrOtherExpenseService.readByExpenseMasterId(expenseId3);
//                        for (Object policyReimb : policyOtherTypeList) {
//                            RelocationOrOtherExpense relocationOrOtherExpense = (RelocationOrOtherExpense) policyReimb;
//                            if (relocationOrOtherExpense.getStatus() != 1) {
//                                flag33 = "false";
//                            }
//                        }
//                    }
//                    if (expenseType3.equals("Others")) {
//                        othersList = expenseOtherTypeService.readByExpenseMasterId(expenseId3);
//                        for (Object o1 : othersList) {
//                            ExpenseOtherType expenseOtherType = (ExpenseOtherType) o1;
//                            System.out.println("ajay" + expenseOtherType.getStatus());
//                            if (expenseOtherType.getStatus() != 1) {
//                                flag33 = "false";
//                            }
//                        }
//                    }
//                    jsono.put("expenseId", expenseId3);
//                    jsono.put("empMasterId", empMasterId3);
//                    jsono.put("employeeId", employeeId3);
//                    jsono.put("employeeName", employeeName3);
//                    jsono.put("expenseType", expenseType3);
//                    jsono.put("dateOfSubmit", dateOfSubmit3);
//                    jsono.put("reportingManager", reportingManager3);
//
//                    String Statusmessage = "";
//                    if (Status3.equals(0)) {
//                        Statusmessage = "Pending";
//                    } else if (Status3.equals(1)) {
//                        Statusmessage = "Rework By " + reportingManager3;
//
//                    } else if (Status3.equals(2)) {
//                        if (flag33 == "false") {
//                            Statusmessage = "Partially Approved By " + reportingManager3;
//                        } else {
//                            Status3 = 5;
//                            Statusmessage = "Approved By " + reportingManager3;
//                        }
//
//                    } else if (Status3.equals(3)) {
//                        Statusmessage = "Saved As Draft";
//
//                    } else if (Status3.equals(4)) {
//                        Statusmessage = "Final Approved By " + reportingManager3;
//
//                    } else if (Status3.equals(10)) {
//                        Statusmessage = "Rejected By " + reportingManager3;
//
//                    }
//
//                    jsono.put("status", Status3);
//                    jsono.put("statusmessage", Statusmessage);
//                    jSONArray.put(jsono);
//                    message = "Success";
//                    rcode = "1";
//
//                }
//
//            }
            if (reportingLevel1List.isEmpty()) {
                message = "No Record Found";
                rcode = "2";
            }

            jsonobj.put("ExpenseReportList", jSONArray);
            jsonobj.put("responseMessage", message);
            jsonobj.put("responseCode", rcode);
            out.print(jsonobj);
//            Data.put("userData", jSONArray);

//                }catch (Exception exception) {
        }

    }

    public void ViewExpenseRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

        PrintWriter out = null;
        out = response.getWriter();
        String rcode = "";
        String message = "";
        String empid = "";
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();

        UserMaster user = new UserMaster();
        ExpenseMaster expenseMaster = new ExpenseMaster();
        ExpenseMaster expenseMaster1 = new ExpenseMaster();
        JSONObject userData = new JSONObject();
        JSONObject data = new JSONObject();
        try {
            String userId = request.getParameter("id");
            user.setId(Integer.parseInt(userId));
            JSONObject Data = doPost(request);
            String expenseId = Data.get("expenseId").toString();
            String empMasterId = Data.get("empMasterId").toString();

            EmployeeMaster master1 = employeeMasterService.readById(Integer.parseInt(empMasterId));
            if (!master1.equals(null)) {

                LevelMaster levelMaster1 = levelMasterService.readById(master1.getLevelMaster().getId());
                DesignationMaster designationMaster = designationMasterService.readById(master1.getDesignationMaster().getId());
                LocationMaster locationMaster1 = locationMasterService.readById(master1.getLocationMaster().getId());
                DepartmentMaster departmentMaster = departmentMasterService.readById(master1.getDepartmentMaster().getId());

//
                JSONArray emp = new JSONArray();
                JSONObject empObj = new JSONObject();

                empObj.put("EmployeeNo", master1.getEmployeeId());
                empObj.put("EmployeeName", master1.getEmployeeName());
                empObj.put("designation", designationMaster.getDesignationName());
                empObj.put("level", levelMaster1.getLevel());
                empObj.put("ContactNo", master1.getContactNo1());
                empObj.put("department", departmentMaster.getDepartmentName());
                empObj.put("Worklocation", locationMaster1.getLocation());
                empObj.put("reportingManager", master1.getReportingManagerLevel1());
                emp.put(empObj);
                data.put("EmployeeDetail", emp);
            }
//
//            String expenseId = request.getParameter("expenseId");
            expenseMaster = expenseMasterService.readById(Integer.parseInt(expenseId));
            String expensetype = expenseMaster.getExpenseType();
            String dateOfsub = expenseMaster.getDateOfSubmit();
            List<?> travelTypeList = new ArrayList<Object>();
            List<?> relocationTypeList = new ArrayList<Object>();
            List<?> travelOtherTypeList = new ArrayList<Object>();
            List<?> relocationOtherTypeList = new ArrayList<Object>();
            List<?> policyOtherTypeList = new ArrayList<Object>();
            List<?> othersList = new ArrayList<Object>();

            DesignationMaster designationMaster;
            LevelMaster levelMaster;
            DepartmentMaster departmentMaster;
            LocationMaster locationMaster;

            employeeMaster = employeeMasterService.readById(expenseMaster.getEmployeeMasterByEmployeeId().getId());

            int levelId = employeeMaster.getLevelMaster().getId();
            int deptId = employeeMaster.getDepartmentMaster().getId();
            int desigId = employeeMaster.getDesignationMaster().getId();
            if (employeeMaster.getReportingManagerLevel1().equals("")) {
                employeeMaster.setReportingManagerLevel1("1");
            }
            int managerId = Integer.parseInt(employeeMaster.getReportingManagerLevel1());
            employeeMaster1 = employeeMasterService.readById(managerId);
            employeeMaster.setChild1(employeeMaster1.getEmployeeName());
            levelMaster = levelMasterService.readById(levelId);
            designationMaster = designationMasterService.readById(desigId);
            departmentMaster = departmentMasterService.readById(deptId);
            locationMaster = locationMasterService.readById(employeeMaster.getLocationMaster().getId());
            employeeMaster.setLocationMaster(locationMaster);
            employeeMaster.setLevelMaster(levelMaster);
            employeeMaster.setDepartmentMaster(departmentMaster);
            employeeMaster.setDesignationMaster(designationMaster);
            selectTravelNo(request, user);
            policyList(request);
            readcurrencyList(request);
            expenseMaster1.setEmployeeMasterByEmployeeId(employeeMaster);
            expenseMaster1 = expenseMasterService.readById(Integer.parseInt(expenseId));

            String expenseType = expenseMaster1.getExpenseType();
            String dateOfSubmit = expenseMaster1.getDateOfSubmit();
            int expensestatus = expenseMaster1.getStatus();
            data.put("expenseType", expenseType);

            JSONArray TravelArray = new JSONArray();
            String travelReqAppNoId = "";
            String travelReqAppNo = "";
            String travelType = "";

            if (expenseMaster1.getExpenseType().equals("Travel")) {
                String travelStartDate = expenseMaster1.getTravelStartDate();
                String travelEndDate = expenseMaster1.getTravelEndDate();
                data.put("startDate", travelStartDate);
                data.put("endDate", travelEndDate);
                travelTypeList = expenseTravelTypeService.readByExpenseMasterId(Integer.parseInt(expenseId));
                for (Object o : travelTypeList) {
                    ExpenseTravelType expenseTravelType1 = (ExpenseTravelType) o;
                    int travelid = expenseTravelType1.getId();
                    travelReqAppNoId = expenseTravelType1.getTravelApplicationNo();
                    TravelRequestMaster travelRequestMaster = travelRequestMasterService.readById(Integer.parseInt(travelReqAppNoId));
                    travelReqAppNo = travelRequestMaster.getTravelRequestNo();
                    travelType = travelRequestMaster.getTravelType();
                    String fromCity = expenseTravelType1.getFromCity();
                    String toCity = expenseTravelType1.getToCity();
                    String date = expenseTravelType1.getDate();
                    String travelBy = expenseTravelType1.getTravelBy();
                    String amount = expenseTravelType1.getAmount();
                    String currency = expenseTravelType1.getCurrency();
                    int status = 1;

                    if (expensestatus != 0 && expensestatus != 3) {
                        status = expenseTravelType1.getStatus();
                        if (status == 0) {
                            status = 2;
                        } else if (status == 1) {
                            status = 3;
                        }
                    }

                    JSONObject travelObject = new JSONObject();
                    travelObject.put("fromCity", fromCity);
                    travelObject.put("toCity", toCity);
                    travelObject.put("date", date);
                    travelObject.put("status", status);
                    travelObject.put("modeOfTravel", travelBy);
                    travelObject.put("amount", amount);
                    travelObject.put("currency", currency);
                    travelObject.put("expenseTravelTypeId", travelid);
                    TravelArray.put(travelObject);

                }
                data.put("travelReqAppNo", travelReqAppNo);
                data.put("travelReqAppNoId", travelReqAppNoId);
                data.put("travelType", travelType);
                travelOtherTypeList = relocationOrOtherExpenseService.readByExpenseMasterId(Integer.parseInt(expenseId));
                JSONArray otherTypeArray = new JSONArray();
                for (Object o2 : travelOtherTypeList) {
                    RelocationOrOtherExpense relocationOrOtherExpense = (RelocationOrOtherExpense) o2;
                    String otherExpense = relocationOrOtherExpense.getOtherExpense();
                    float amount = relocationOrOtherExpense.getAmount();
                    String currency = relocationOrOtherExpense.getCurrency();
                    int otherExpenseid = relocationOrOtherExpense.getId();
                    String expenseOtherSpecify = relocationOrOtherExpense.getExpenseOtherSpecify();
                    String otherExpenseDate = relocationOrOtherExpense.getOtherExpenseDate();
                    int status = 1;

                    if (expensestatus != 0 && expensestatus != 3) {
                        status = relocationOrOtherExpense.getStatus();
                        if (status == 0) {
                            status = 2;
                        } else if (status == 1) {
                            status = 3;
                        }
                    }

                    JSONObject travelObject = new JSONObject();
                    travelObject.put("otherExpense", otherExpense);
                    if (otherExpense.equals("Other")) {
                        String purpose = relocationOrOtherExpense.getExpenseOtherSpecify();
                        travelObject.put("purpose", purpose);
                    }

                    travelObject.put("amount", amount);
                    travelObject.put("currency", currency);
                    travelObject.put("status", status);
                    travelObject.put("purpose", expenseOtherSpecify);
                    travelObject.put("date", otherExpenseDate);
                    travelObject.put("travelOtherExpenseId", otherExpenseid);
                    otherTypeArray.put(travelObject);

                }
                data.put("travelexpenseDetails", TravelArray);
                data.put("travelotherExpenseDetails", otherTypeArray);

            }
            if (expenseMaster1.getExpenseType().equals("Relocation")) {
                relocationTypeList = expenseTravelTypeService.readByExpenseMasterId(Integer.parseInt(expenseId));
                for (Object o3 : relocationTypeList) {
                    ExpenseTravelType expenseTravelType1 = (ExpenseTravelType) o3;
                    int travelid = expenseTravelType1.getId();
                    String fromCity = expenseTravelType1.getFromCity();
                    String toCity = expenseTravelType1.getToCity();
                    String currency = expenseTravelType1.getCurrency();
                    String date = expenseTravelType1.getDate();
                    String travelBy = expenseTravelType1.getTravelBy();
                    String amount = expenseTravelType1.getAmount();
                    int status = 1;

                    if (expensestatus != 0 && expensestatus != 3) {
                        status = expenseTravelType1.getStatus();
                        if (status == 0) {
                            status = 2;
                        } else if (status == 1) {
                            status = 3;
                        }
                    }

                    JSONObject travelObject = new JSONObject();
                    travelObject.put("fromCity", fromCity);
                    travelObject.put("toCity", toCity);
                    travelObject.put("date", date);
                    travelObject.put("currency", currency);
                    travelObject.put("modeOfTravel", travelBy);
                    travelObject.put("amount", amount);
                    travelObject.put("status", status);
                    travelObject.put("RelocationId", travelid);
                    TravelArray.put(travelObject);
                }
                relocationOtherTypeList = relocationOrOtherExpenseService.readByExpenseMasterId(Integer.parseInt(expenseId));
                JSONArray otherTypeArray = new JSONArray();
                for (Object o4 : relocationOtherTypeList) {
                    RelocationOrOtherExpense relocationOrOtherExpense = (RelocationOrOtherExpense) o4;
                    String otherExpense = relocationOrOtherExpense.getOtherExpense();
                    float amount = relocationOrOtherExpense.getAmount();
                    String currency = relocationOrOtherExpense.getCurrency();
                    int otherExpenseid = relocationOrOtherExpense.getId();
                    String expenseOtherSpecify = relocationOrOtherExpense.getExpenseOtherSpecify();
                    String otherExpenseDate = relocationOrOtherExpense.getOtherExpenseDate();
                    int status = 1;

                    if (expensestatus != 0 && expensestatus != 3) {
                        status = relocationOrOtherExpense.getStatus();
                        if (status == 0) {
                            status = 2;
                        } else if (status == 1) {
                            status = 3;
                        }
                    }

                    JSONObject travelObject = new JSONObject();
                    travelObject.put("otherExpense", otherExpense);
                    if (otherExpense.equals("Other")) {
                        String purpose = relocationOrOtherExpense.getExpenseOtherSpecify();
                        travelObject.put("purpose", purpose);
                    }

                    travelObject.put("amount", amount);
                    travelObject.put("currency", currency);
                    travelObject.put("status", status);
                    travelObject.put("purpose", expenseOtherSpecify);
                    travelObject.put("date", otherExpenseDate);
                    travelObject.put("otherExpenseDetailsId", otherExpenseid);
                    otherTypeArray.put(travelObject);

                }
                data.put("relocationExpenseDetails", TravelArray);
                data.put("otherExpenseDetails", otherTypeArray);

            }
            if (expenseMaster1.getExpenseType().equals("PolicyReimbursements")) {
                policyOtherTypeList = relocationOrOtherExpenseService.readByExpenseMasterId(Integer.parseInt(expenseId));
                JSONArray policyReimbursementsArray = new JSONArray();
                for (Object policyReimb : policyOtherTypeList) {
                    RelocationOrOtherExpense relocationOrOtherExpense = (RelocationOrOtherExpense) policyReimb;
                    String otherExpense = relocationOrOtherExpense.getOtherExpense();
                    float amount = relocationOrOtherExpense.getAmount();
                    String currency = relocationOrOtherExpense.getCurrency();
                    int otherExpenseid = relocationOrOtherExpense.getId();
                    String specify = relocationOrOtherExpense.getPolicyNo();
                    String otherExpenseDate = relocationOrOtherExpense.getOtherExpenseDate();
                    int status = 1;

                    if (expensestatus != 0 && expensestatus != 3) {
                        status = relocationOrOtherExpense.getStatus();
                        if (status == 0) {
                            status = 2;
                        } else if (status == 1) {
                            status = 3;
                        }
                    }
                    JSONObject policyReimbursementsObj = new JSONObject();
                    policyReimbursementsObj.put("otherExpense", otherExpense);
                    if (otherExpense.equals("Other")) {
                        String purpose = relocationOrOtherExpense.getExpenseOtherSpecify();
                        policyReimbursementsObj.put("purpose", purpose);
                    }
                    policyReimbursementsObj.put("amount", amount);
                    policyReimbursementsObj.put("currency", currency);
                    policyReimbursementsObj.put("status", status);
                    data.put("pleaseSpecify", specify);
                    policyReimbursementsObj.put("date", otherExpenseDate);
                    policyReimbursementsObj.put("policyReimbursementsId", otherExpenseid);
                    policyReimbursementsArray.put(policyReimbursementsObj);

                }
                data.put("PolicyReimbursementsDetails", policyReimbursementsArray);
            }
            if (expenseMaster1.getExpenseType().equals("Others")) {
                JSONArray otherTypeArray = new JSONArray();

                othersList = expenseOtherTypeService.readByExpenseMasterId(Integer.parseInt(expenseId));
                for (Object o1 : othersList) {
                    ExpenseOtherType expenseOtherType = (ExpenseOtherType) o1;
                    String specify = expenseOtherType.getSpecify();
                    String billDate = expenseOtherType.getBillDate();
                    String bilNo = expenseOtherType.getBilNo();
                    float amount = expenseOtherType.getAmount();
                    int otherid = expenseOtherType.getId();
                    String currency = expenseOtherType.getCurrency();
                    int status = 1;

                    if (expensestatus != 0 && expensestatus != 3) {
                        status = expenseOtherType.getStatus();
                        if (status == 0) {
                            status = 2;
                        } else if (status == 1) {
                            status = 3;
                        }
                    }
                    JSONObject otherObject = new JSONObject();
                    data.put("pleaseSpecify", specify);
                    otherObject.put("date", billDate);
                    otherObject.put("invoiceNo", bilNo);
                    otherObject.put("amount", amount);
                    otherObject.put("status", status);
                    otherObject.put("currency", currency);
                    otherObject.put("otherDetailsId", otherid);
                    otherTypeArray.put(otherObject);

                }
                data.put("otherExpenseDetails", otherTypeArray);
            }

            List<?> expenseReconsilationList = expenseReconsilationService.readExpenseReconsilationByExpenseID(Integer.parseInt(expenseId));
            JSONArray expenseSummary = new JSONArray();
            for (Object Expobj : expenseReconsilationList) {
                JSONObject expensesummObject = new JSONObject();
                ExpenseReconsilation expenseReconsilation = (ExpenseReconsilation) Expobj;
                String currency = expenseReconsilation.getCurrencyType();
                float amount = expenseReconsilation.getExpenseInReport();
                float paidByCompany = expenseReconsilation.getExpensePaid();
                float advanceCash = expenseReconsilation.getCashAdvance();
                float cashReturned = expenseReconsilation.getCashReturned();
                float variance = expenseReconsilation.getVarianceOwed();

                expensesummObject.put("currency", currency);
                expensesummObject.put("reportExpense", amount);
                expensesummObject.put("paidByCompany", paidByCompany);
                expensesummObject.put("advanceCash", advanceCash);
                expensesummObject.put("cashReturned", cashReturned);
                expensesummObject.put("variance", variance);
                expenseSummary.put(expensesummObject);

            }
            data.put("expenseSummary", expenseSummary);
            List<?> currencyList = currencyMasterService.read();
            JSONArray currencyarray = new JSONArray();
            for (int i = 0; i < currencyList.size(); i++) {
                JSONObject currencyobj = new JSONObject();
                CurrencyMaster currencyMaster = (CurrencyMaster) currencyList.get(i);
                String currencyid = (currencyMaster.getId()).toString();
                String currencyname = currencyMaster.getCurrencyName();
                String currencycode = currencyMaster.getCurrencyCode();
                currencyobj.put("CurrencyId", currencyid);
                currencyobj.put("CurrencyName", currencyname);
                currencyobj.put("CurrencyCode", currencycode);
                currencyarray.put(currencyobj);
            }
            data.put("currencyarray", currencyarray);
            message = "Success";
            rcode = "1";
        } catch (Exception exception) {
            message = "Error";
            rcode = "0";
        }
        data.put("responseMessage", message);
        data.put("responseCode", rcode);

        out.println(data);

    }

    ///////////////////////// @Approve @Rewark @Rejeact ////////////////////////////   
    public void ExpenseReportapprove(HttpServletRequest request, HttpServletResponse response) throws Exception {

        PrintWriter out = null;
        out = response.getWriter();
        String rcode = "";
        String message = "";
        JSONObject userData = new JSONObject();

        ExpenseMaster expenseMaster = new ExpenseMaster();
        ExpenseTravelType expenseTravelType = new ExpenseTravelType();
        ExpenseOtherType expenseOtherType = new ExpenseOtherType();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        UserMaster user = new UserMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        EmployeeMaster employeeMaster2 = new EmployeeMaster();
        ExpenseReconsilation expenseReconsilation = new ExpenseReconsilation();
        RelocationOrOtherExpense relocationOrOtherExpense = new RelocationOrOtherExpense();

        try {
            bind(request, expenseMaster);
            JSONObject Data = doPost(request);
            String expenseId = Data.getString("expenseId");
            String empMasterId = Data.getString("empMasterId");

            String btnType = Data.getString("btnType");

            String expenseType = Data.getString("expenseType");

            EmployeeMaster master = employeeMasterService.readById(Integer.parseInt(empMasterId));

            expenseMaster = expenseMasterService.readById(Integer.parseInt(expenseId));
            UserMaster userMaster = userMasterService.readById(master.getUserMaster().getId());

            employeeMaster1.setUserMaster(userMaster);
            List<?> reportingManagerList = employeeMasterService.readByUserName(employeeMaster1);
            if (!reportingManagerList.isEmpty()) {
                employeeMaster1 = (EmployeeMaster) reportingManagerList.get(0);
            }

            String id = request.getParameter("id");
            int userid = Integer.parseInt(id);
            user.setId(userid);
            employeeMaster.setUserMaster(user);
            EmployeeMaster empApprover = new EmployeeMaster();
            List<?> managerList = employeeMasterService.readByUserName(employeeMaster);
            if (!reportingManagerList.isEmpty()) {
                empApprover = (EmployeeMaster) managerList.get(0);
            }

            expenseMaster.setEmployeeMasterByApprover1Id(empApprover);//Reporting Manager

            expenseMaster.setExpenseType(expenseType);

            if (btnType.equals("Approve")) {

                if (expenseMaster.getExpenseType().equals("Travel")) {
//                    String travelTypeId[] = request.getParameterValues("otherListCheck");
//                    String travelOtherId[] = request.getParameterValues("otherListCheck1");
                    try {
                        JSONArray travelArray = Data.getJSONArray("travelexpenseDetails");
                        for (int y = 0; y < travelArray.length(); y++) {
                            JSONObject Travel = travelArray.getJSONObject(y);
                            String TravelId = Travel.getString("expenseTravelTypeId");
                            if (TravelId != null) {

//                            for (String z : travelTypeId) {
                                expenseTravelType = expenseTravelTypeService.readById(Integer.parseInt(TravelId));
                                expenseTravelType.setStatus(1);
                                expenseTravelTypeService.update(expenseTravelType);
//                            }
                            }
                        }
                        JSONArray travelOtherArray = Data.getJSONArray("travelotherExpenseDetails");
                        for (int y = 0; y < travelOtherArray.length(); y++) {
                            JSONObject TravelOther = travelOtherArray.getJSONObject(y);
                            String TravelOtherId = TravelOther.getString("travelOtherExpenseId");
                            if (TravelOtherId != null) {
//                            for (String z1 : travelOtherId) {
                                relocationOrOtherExpense = relocationOrOtherExpenseService.readById(Integer.parseInt(TravelOtherId));
                                relocationOrOtherExpense.setStatus(1);
                                relocationOrOtherExpenseService.update(relocationOrOtherExpense);
//                            }
                            }
                        }
                    } catch (Exception e) {
                    }
                }

                if (expenseMaster.getExpenseType().equals("Relocation")) {
                    try {
                        JSONArray ja1 = Data.getJSONArray("otherExpenseDetails");
                        for (int j = 0; j < ja1.length(); j++) {
                            JSONObject jsono1 = ja1.getJSONObject(j);
                            String otherExpenseDetailsId = jsono1.getString("otherExpenseDetailsId");

                            if (otherExpenseDetailsId != null) {
//                            for (String z1 : reloOtherId) {
                                relocationOrOtherExpense = relocationOrOtherExpenseService.readById(Integer.parseInt(otherExpenseDetailsId));
                                relocationOrOtherExpense.setStatus(1);
                                relocationOrOtherExpenseService.update(relocationOrOtherExpense);
                            }
                        }

                        JSONArray ja = Data.getJSONArray("relocationExpenseDetails");
                        for (int i = 0; i < ja.length(); i++) {
                            JSONObject jsono = ja.getJSONObject(i);
                            String expenseTravelTypeId = jsono.getString("RelocationId");
                            if (expenseTravelTypeId != null) {
//                            for (String z : reloTypeId) {
                                expenseTravelType = expenseTravelTypeService.readById(Integer.parseInt(expenseTravelTypeId));
                                expenseTravelType.setStatus(1);
                                expenseTravelTypeService.update(expenseTravelType);
//                            }
                            }
                        }

                    } catch (Exception e) {
                    }
                }

                if (expenseMaster.getExpenseType().equals("PolicyReimbursements")) {

//                    String policyId[] = request.getParameterValues("otherListCheck");
                    try {
                        JSONArray policyArray = Data.getJSONArray("policyReimbursementsDetails");
                        for (int x = 0; x < policyArray.length(); x++) {
                            JSONObject policy = policyArray.getJSONObject(x);
                            String PolicyReimbursementsId = policy.getString("policyReimbursementsId");
                            if (PolicyReimbursementsId != null) {
//                            for (String z : policyId) {
                                relocationOrOtherExpense = relocationOrOtherExpenseService.readById(Integer.parseInt(PolicyReimbursementsId));
                                relocationOrOtherExpense.setStatus(1);
                                relocationOrOtherExpenseService.update(relocationOrOtherExpense);
//                            }
                            }
                        }
                    } catch (Exception e) {
                    }
                }

                if (expenseMaster.getExpenseType()
                        .equals("Others")) {
//                    String otherId[] = request.getParameterValues("otherListCheck");
                    try {
                        JSONArray otherArray = Data.getJSONArray("otherExpenseDetails");
                        for (int y = 0; y < otherArray.length(); y++) {
                            JSONObject Others = otherArray.getJSONObject(y);
                            String OthersId = Others.getString("otherDetailsId");
                            if (OthersId != null) {
//                            for (String z : otherId) {
                                expenseOtherType = expenseOtherTypeService.readById(Integer.parseInt(OthersId));
                                expenseOtherType.setStatus(1);
                                expenseOtherTypeService.update(expenseOtherType);
//                            }
                            }
                        }
                    } catch (Exception e) {

                    }
                }
//        status = 2 for approve
                expenseMaster.setStatus(2);
                expenseMasterService.update(expenseMaster);
//            }
//            request.setAttribute("successMessage",
//                    "Information : The Request is Approved successfully.");

                try {
                    EmailTemplate emailTemplate = new EmailTemplate();
//                    EmployeeMaster employeeMasterModel = employeeMasterService.readById(userid);
                    DesignationMaster designationMaster = new DesignationMaster();
                    designationMaster = designationMasterService.readById(empApprover.getDesignationMaster().getId());
//                    // id=20 for Send to expense Admin...
                    List expenseAdminList = userRightMasterService.readExpenseAdmin();
                    Iterator itr = expenseAdminList.iterator();
                    while (itr.hasNext()) {
                        Object[] next = (Object[]) itr.next();
                        String userId = "" + next[0];
                        String ExpenseId = "" + next[1];
                        EmployeeMaster employeeMasterHr = new EmployeeMaster();
                        employeeMasterHr = employeeMasterService.readById(Integer.parseInt(ExpenseId));

                     
                        emailTemplate = emailTemplateService.readById(20);
                        String To = employeeMasterHr.getOfficeEmailId();
                        String from = empApprover.getOfficeEmailId();
                        String Subject = emailTemplate.getSubject();
                        Subject = Subject.replaceAll("\\{user\\}", master.getEmployeeName());
                        String msg = emailTemplate.getBodytext();
                        msg = msg.replaceAll("\\{to_user\\}", employeeMasterHr.getEmployeeName());
                        msg = msg.replaceAll("\\{from_user\\}", empApprover.getEmployeeName());
                        msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                        sendMail.sendMail(from, To, Subject, msg);
                    }
                } catch (Exception e) {
                }
                try {
                    EmailTemplate emailTemplate = new EmailTemplate();
//                    EmployeeMaster employeeMasterModel = employeeMasterService.readById(userid);
                    DesignationMaster designationMaster = new DesignationMaster();
                    designationMaster = designationMasterService.readById(empApprover.getDesignationMaster().getId());
                    EmployeeMaster employeeMasterHr = new EmployeeMaster();
                    employeeMasterHr = employeeMasterService.readById(Integer.parseInt(empApprover.getReportingManagerLevel1()));
                    // id=55 for Expense Approve to employee...
              
                    emailTemplate = emailTemplateService.readById(55);
                    String To = master.getOfficeEmailId();
                    String from = empApprover.getOfficeEmailId();
                    String Subject = emailTemplate.getSubject();
                    Subject = Subject.replaceAll("\\{user\\}", master.getEmployeeName());
                    String msg = emailTemplate.getBodytext();
                    msg = msg.replaceAll("\\{to_user\\}", master.getEmployeeName());
                    msg = msg.replaceAll("\\{from_user\\}", empApprover.getEmployeeName());
                    msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                    sendMail.sendMail(from, To, Subject, msg);
                } catch (Exception e) {
                }
            }
            if (btnType.equals("Rework")) {

                expenseMaster.setStatus(1);
                expenseMasterService.update(expenseMaster);
                request.setAttribute("successMessage",
                        "Information : The Request is Returned successfully.");

                try {
                    EmailTemplate emailTemplate = new EmailTemplate();
//                    EmployeeMaster employeeMasterModel = employeeMasterService.readById(userid);
                    DesignationMaster designationMaster = new DesignationMaster();
                    designationMaster = designationMasterService.readById(empApprover.getDesignationMaster().getId());
                    EmployeeMaster employeeMasterHr = new EmployeeMaster();
                    employeeMasterHr = employeeMasterService.readById(Integer.parseInt(empApprover.getReportingManagerLevel1()));
                    // id=20 for Expense Rework...

//                    employeeMaster = employeeMasterService.readById(userid);
                    emailTemplate = emailTemplateService.readById(21);
                    String To = master.getOfficeEmailId();
                    String from = empApprover.getOfficeEmailId();
                    String Subject = emailTemplate.getSubject();
                    Subject = Subject.replaceAll("\\{user\\}", master.getEmployeeName());
                    String msg = emailTemplate.getBodytext();
                    msg = msg.replaceAll("\\{to_user\\}", master.getEmployeeName());
                    msg = msg.replaceAll("\\{from_user\\}", empApprover.getEmployeeName());
                    msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                    sendMail.sendMail(from, To, Subject, msg);
                } catch (Exception e) {
                }
            }

            if (btnType.equals("Reject")) {

                expenseMaster.setStatus(10);
                expenseMasterService.update(expenseMaster);
                request.setAttribute("successMessage",
                        "Information : The Request is Rejected successfully.");
                try {
                    EmailTemplate emailTemplate = new EmailTemplate();
//                    EmployeeMaster employeeMasterModel = employeeMasterService.readById(userid);
                    DesignationMaster designationMaster = new DesignationMaster();
                    designationMaster = designationMasterService.readById(empApprover.getDesignationMaster().getId());
                    EmployeeMaster employeeMasterHr = new EmployeeMaster();
                    employeeMasterHr = employeeMasterService.readById(Integer.parseInt(empApprover.getReportingManagerLevel1()));

                    // id=22 for Expense Reject...
//                    employeeMaster = employeeMasterService.readById(userid);
                    emailTemplate = emailTemplateService.readById(22);
                    String To = master.getOfficeEmailId();
                    String from = empApprover.getOfficeEmailId();
                    String Subject = emailTemplate.getSubject();
                    Subject = Subject.replaceAll("\\{user\\}", master.getEmployeeName());
                    String msg = emailTemplate.getBodytext();
                    msg = msg.replaceAll("\\{to_user\\}", master.getEmployeeName());
                    msg = msg.replaceAll("\\{from_user\\}", empApprover.getEmployeeName());
                    msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                    sendMail.sendMail(from, To, Subject, msg);

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

    public void newRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, JSONException {
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
            String id = request.getParameter("id");
            int userid = Integer.parseInt(id);
            user.setId(userid);
            employeeMaster.setUserMaster(user);
            List<?> empDetailList = employeeMasterService.readByEmployeeUserId(employeeMaster);
            if (!empDetailList.isEmpty()) {
                employeeMaster1 = (EmployeeMaster) empDetailList.get(0);
            }

            TravelRequestMaster travelRequestMaster = new TravelRequestMaster();
            travelRequestMaster.setEmployeeMasterByEmployeeMasterId(employeeMaster1);
            List<?> travelList = travelRequestMasterService.readTotalRequest(travelRequestMaster);
            JSONArray travelarray = new JSONArray();
            if (!travelList.isEmpty()) {

                for (int i = 0; i < travelList.size(); i++) {
                    JSONObject travelobj = new JSONObject();
                    TravelRequestMaster travelRequestMaster1 = (TravelRequestMaster) travelList.get(i);
                    int status = travelRequestMaster1.getStatus();
                    String traveltype = travelRequestMaster1.getTravelType();
                    if (status == 5 && !traveltype.contains("Local")) {
                        String trn = travelRequestMaster1.getTravelRequestNo();
                        String sdt = travelRequestMaster1.getStartDateTime();
                        String edt = travelRequestMaster1.getEndDateTime();
                        String travelid = (travelRequestMaster1.getId()).toString();
                        travelobj.put("TravelRequestNo", trn);
                        travelobj.put("StartDateTime", sdt);
                        travelobj.put("EndDateTime", edt);
                        travelobj.put("TravelType", traveltype);
                        travelobj.put("Travelid", travelid);
                        travelarray.put(travelobj);
                    }
                }
            } else {
                message = "There is NO Record Found";
                rcode = "2";

            }

            List<?> currencyList = currencyMasterService.read();
            JSONArray currencyarray = new JSONArray();
            for (int i = 0; i < currencyList.size(); i++) {
                JSONObject currencyobj = new JSONObject();
                CurrencyMaster currencyMaster = (CurrencyMaster) currencyList.get(i);
                String currencyid = (currencyMaster.getId()).toString();
                String currencyname = currencyMaster.getCurrencyName();
                String currencycode = currencyMaster.getCurrencyCode();
                currencyobj.put("CurrencyId", currencyid);
                currencyobj.put("CurrencyName", currencyname);
                currencyobj.put("CurrencyCode", currencycode);
                currencyarray.put(currencyobj);

            }
            message = "Sucess";
            rcode = "1";
            data.put("Travel", travelarray);
            data.put("Currency", currencyarray);

//          
        } catch (Exception exception) {
            message = "Error";
            rcode = "0";

        }
        userData.put("data", data);
        userData.put("responseMessage", message);
        userData.put("responseCode", rcode);
        out.println(userData);

    }

    public void expenseCreate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, JSONException {
        PrintWriter out = null;
        out = response.getWriter();
        String rcode = "";
        String message = "";
        JSONObject userData = new JSONObject();
        try {
            JSONObject data = doPost(request);
            UserMaster user = new UserMaster();
            EmployeeMaster employeeMaster = new EmployeeMaster();
            EmployeeMaster employeeMaster1 = new EmployeeMaster();
            String id = request.getParameter("id");
            int userid = Integer.parseInt(id);
            user.setId(userid);
            employeeMaster.setUserMaster(user);

            List<?> empDetailList = employeeMasterService.readByEmployeeUserId(employeeMaster);
            if (!empDetailList.isEmpty()) {
                employeeMaster1 = (EmployeeMaster) empDetailList.get(0);
                ExpenseMaster expenseMaster = new ExpenseMaster();
                ExpenseTravelType expenseTravelType = new ExpenseTravelType();
                RelocationOrOtherExpense relocationOrOtherExpense = new RelocationOrOtherExpense();
                ExpenseOtherType expenseOtherType = new ExpenseOtherType();
                ExpenseReconsilation expenseReconsilation = new ExpenseReconsilation();

                expenseMaster.setEmployeeMasterByEmployeeId(employeeMaster1);
                expenseMaster.setExpenseType(data.get("expenseType").toString());
                Date date1 = Calendar.getInstance().getTime();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

                expenseMaster.setDateOfSubmit(sdf.format(date1));
                if ((data.get("action").toString()).equals("0")) {
                    expenseMaster.setStatus(3);
                }

                if (expenseMaster.getExpenseType().equals("Travel") || expenseMaster.getExpenseType().equals("Relocation")) {
                    if (expenseMaster.getExpenseType().equals("Travel")) {
                        expenseMaster.setTravelStartDate((data.get("startDate")).toString());
                        expenseMaster.setTravelEndDate((data.get("endDate")).toString());
                        expenseTravelType.setTravelApplicationNo((data.get("travelId")).toString());
                    }
                    if (expenseMaster.getExpenseType().equals("Relocation")) {
                        expenseTravelType.setTravelApplicationNo("");
                    }

                    JSONArray TravelDeatails = data.getJSONArray("expenseDetails");
                    expenseMasterService.create(expenseMaster);

                    for (int i = 0; i < TravelDeatails.length(); i++) {
                        JSONObject travelDetailObj = TravelDeatails.getJSONObject(i);
                        String fromCity = (travelDetailObj.get("fromCity")).toString();
                        String toCity = (travelDetailObj.get("toCity")).toString();
                        String date = (travelDetailObj.get("date")).toString();
                        String travelBy = (travelDetailObj.get("modeOfTravel")).toString();
                        String amount = (travelDetailObj.get("amount")).toString();
                        String currency = (travelDetailObj.get("currency")).toString();

                        if (!"".equals(fromCity) && !"".equals(toCity) && !"".equals(date) && !"".equals(travelBy) && !"".equals(amount) && !"".equals(currency)) {
                            expenseTravelType.setFromCity(fromCity);
                            expenseTravelType.setToCity(toCity);
                            expenseTravelType.setDate(date);
                            expenseTravelType.setTravelBy(travelBy);
                            expenseTravelType.setAmount(amount);
                            expenseTravelType.setCurrency(currency);
                            expenseTravelType.setExpenseMaster(expenseMaster);
                            expenseTravelTypeService.create(expenseTravelType);

                        }
                    }
                    JSONArray otherDetailCount = data.getJSONArray("otherExpenseDetails");
                    for (int i = 0; i < otherDetailCount.length(); i++) {
                        JSONObject otherDetailObj = otherDetailCount.getJSONObject(i);
                        String otherExpense = (otherDetailObj.get("otherExpense").toString());
                        String currency = (otherDetailObj.get("currency").toString());
                        String otherExpenseDate = (otherDetailObj.get("date").toString());
                        float amount = Float.parseFloat(otherDetailObj.get("amount").toString());
                        if (otherExpense.contains("Other")) {
                            String purpose = (otherDetailObj.get("purpose").toString());
                            relocationOrOtherExpense.setExpenseOtherSpecify(purpose);
                        }
                        if (!"".equals(otherExpense) && !"".equals((otherDetailObj.get("amount").toString())) && !"".equals(currency)) {
                            relocationOrOtherExpense.setOtherExpenseDate(otherExpenseDate);
                            relocationOrOtherExpense.setOtherExpense(otherExpense);
                            relocationOrOtherExpense.setAmount(amount);
                            relocationOrOtherExpense.setCurrency(currency);
                            relocationOrOtherExpense.setExpenseMaster(expenseMaster);
                            relocationOrOtherExpenseService.create(relocationOrOtherExpense);
                        }
                    }

                }
                if (expenseMaster.getExpenseType().equals("PolicyReimbursements")) {
                    expenseMasterService.create(expenseMaster);
                    JSONArray otherDetailCount = data.getJSONArray("otherExpenseDetails");
                    for (int i = 0; i < otherDetailCount.length(); i++) {

                        String pleaseSpecify = (data.get("pleaseSpecify").toString());
                        JSONObject otherDetailObj = otherDetailCount.getJSONObject(i);
                        String otherExpense = (otherDetailObj.get("otherExpense").toString());
//                        String currency = (otherDetailObj.get("currency").toString());
                        String otherExpenseDate = (otherDetailObj.get("date").toString());
                        float amount = Float.parseFloat(otherDetailObj.get("amount").toString());
                        if (otherExpense.equals("Other")) {
                            String purpose = (otherDetailObj.get("purpose").toString());
                            relocationOrOtherExpense.setExpenseOtherSpecify(purpose);
                        }
                        relocationOrOtherExpense.setPolicyNo(pleaseSpecify);
                        relocationOrOtherExpense.setOtherExpenseDate(otherExpenseDate);
                        relocationOrOtherExpense.setOtherExpense(otherExpense);
                        relocationOrOtherExpense.setAmount(amount);
                        relocationOrOtherExpense.setCurrency("5");
                        relocationOrOtherExpense.setExpenseMaster(expenseMaster);
                        relocationOrOtherExpenseService.create(relocationOrOtherExpense);
                    }
                }
                if (expenseMaster.getExpenseType().equals("Others")) {
                    JSONArray othertype = data.getJSONArray("invoiceDetails");

                    String specify = (data.get("pleaseSpecify")).toString();
                    expenseMasterService.create(expenseMaster);
                    for (int i = 0; i < othertype.length(); i++) {
                        JSONObject otherDetailObj = othertype.getJSONObject(i);
                        String date = (otherDetailObj.get("date").toString());
                        String billNo = (otherDetailObj.get("invoiceNo").toString());
//                        String currency = (otherDetailObj.get("currency").toString());
                        float amount = Float.parseFloat(otherDetailObj.get("amount").toString());
                        if (!"".equals(date) && !"".equals(billNo) && !"".equals(request.getParameter("amount"))) {

                            expenseOtherType.setBillDate(date);
                            expenseOtherType.setBilNo(billNo);
                            expenseOtherType.setAmount(amount);
                            expenseOtherType.setSpecify(specify);
                            expenseOtherType.setCurrency("5");
                            expenseOtherType.setExpenseMaster(expenseMaster);
                            expenseOtherTypeService.create(expenseOtherType);
                        }

                    }

                }

                JSONArray expenseReconsilationArray = data.getJSONArray("expenseSummary");
                for (int i = 0; i < expenseReconsilationArray.length(); i++) {

                    JSONObject expReconsilationObj = expenseReconsilationArray.getJSONObject(i);
                    if (((expReconsilationObj.get("reportExpense")).toString()) != null && !((expReconsilationObj.get("reportExpense")).toString()).equals("0")) {
                        expenseReconsilation.setExpenseMaster(expenseMaster);

                        float amount = Float.parseFloat((expReconsilationObj.get("reportExpense")).toString());
                        float paidByCompany = Float.parseFloat((expReconsilationObj.get("paidByCompany")).toString());
                        float advanceCash = Float.parseFloat((expReconsilationObj.get("advanceCash")).toString());
                        float cashReturned = Float.parseFloat((expReconsilationObj.get("cashReturned")).toString());
                        float variance = Float.parseFloat((expReconsilationObj.get("variance")).toString());
                        String currencyType = "";
                        if (expenseMaster.getExpenseType().equals("Travel")) {
                            currencyType = (expReconsilationObj.get("currencyId")).toString();
                        } else {
                            currencyType = "5";
                        }
                        expenseReconsilation.setCurrencyType(currencyType);
                        expenseReconsilation.setExpenseInReport(amount);
                        expenseReconsilation.setExpensePaid(paidByCompany);
                        expenseReconsilation.setCashReturned(cashReturned);
                        expenseReconsilation.setCashAdvance(advanceCash);
                        expenseReconsilation.setVarianceOwed(variance);
                        expenseReconsilationService.create(expenseReconsilation);

                        message = "Sucess";
                        rcode = "1";
                    }

                }

            }
        } catch (Exception exception) {
            message = "Please insert valid data";
            rcode = "0";

        }
        userData.put("responseMessage", message);
        userData.put("responseCode", rcode);
        out.println(userData);
    }

    public void expenseView(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, JSONException {
        PrintWriter out = null;
        out = response.getWriter();
        String rcode = "";
        String message = "";
        String empid = "";
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        UserMaster user = new UserMaster();
        ExpenseMaster expenseMaster = new ExpenseMaster();
        ExpenseMaster expenseMaster1 = new ExpenseMaster();
        JSONObject userData = new JSONObject();
        JSONObject data = new JSONObject();
        try {
            String userId = request.getParameter("id");
            user.setId(Integer.parseInt(userId));
            String expenseId = request.getParameter("expenseId");
            expenseMaster = expenseMasterService.readById(Integer.parseInt(expenseId));
            String expensetype = expenseMaster.getExpenseType();
            String dateOfsub = expenseMaster.getDateOfSubmit();
            List<?> travelTypeList = new ArrayList<Object>();
            List<?> relocationTypeList = new ArrayList<Object>();
            List<?> travelOtherTypeList = new ArrayList<Object>();
            List<?> relocationOtherTypeList = new ArrayList<Object>();
            List<?> policyOtherTypeList = new ArrayList<Object>();
            List<?> othersList = new ArrayList<Object>();

            DesignationMaster designationMaster;
            LevelMaster levelMaster;
            DepartmentMaster departmentMaster;
            LocationMaster locationMaster;

            employeeMaster = employeeMasterService.readById(expenseMaster.getEmployeeMasterByEmployeeId().getId());

            int levelId = employeeMaster.getLevelMaster().getId();
            int deptId = employeeMaster.getDepartmentMaster().getId();
            int desigId = employeeMaster.getDesignationMaster().getId();
            if (employeeMaster.getReportingManagerLevel1().equals("")) {
                employeeMaster.setReportingManagerLevel1("1");
            }
            int managerId = Integer.parseInt(employeeMaster.getReportingManagerLevel1());
            employeeMaster1 = employeeMasterService.readById(managerId);
            employeeMaster.setChild1(employeeMaster1.getEmployeeName());
            levelMaster = levelMasterService.readById(levelId);
            designationMaster = designationMasterService.readById(desigId);
            departmentMaster = departmentMasterService.readById(deptId);
            locationMaster = locationMasterService.readById(employeeMaster.getLocationMaster().getId());
            employeeMaster.setLocationMaster(locationMaster);
            employeeMaster.setLevelMaster(levelMaster);
            employeeMaster.setDepartmentMaster(departmentMaster);
            employeeMaster.setDesignationMaster(designationMaster);
            selectTravelNo(request, user);
            policyList(request);
            readcurrencyList(request);
            expenseMaster1.setEmployeeMasterByEmployeeId(employeeMaster);
            expenseMaster1 = expenseMasterService.readById(Integer.parseInt(expenseId));

            String expenseType = expenseMaster1.getExpenseType();
            String dateOfSubmit = expenseMaster1.getDateOfSubmit();
            int expensestatus = expenseMaster1.getStatus();
            data.put("expenseType", expenseType);

            JSONArray TravelArray = new JSONArray();
            String travelReqAppNoId = "";
            String travelReqAppNo = "";
            String travelType = "";
            if (expenseMaster1.getExpenseType().equals("Travel")) {
                String travelStartDate = expenseMaster1.getTravelStartDate();
                String travelEndDate = expenseMaster1.getTravelEndDate();
                data.put("startDate", travelStartDate);
                data.put("endDate", travelEndDate);
                travelTypeList = expenseTravelTypeService.readByExpenseMasterId(Integer.parseInt(expenseId));
                for (Object o : travelTypeList) {
                    ExpenseTravelType expenseTravelType1 = (ExpenseTravelType) o;
                    int travelid = expenseTravelType1.getId();
                    travelReqAppNoId = expenseTravelType1.getTravelApplicationNo();
                    TravelRequestMaster travelRequestMaster = travelRequestMasterService.readById(Integer.parseInt(travelReqAppNoId));
                    travelReqAppNo = travelRequestMaster.getTravelRequestNo();
                    travelType = travelRequestMaster.getTravelType();
                    String fromCity = expenseTravelType1.getFromCity();
                    String toCity = expenseTravelType1.getToCity();
                    String date = expenseTravelType1.getDate();
                    String travelBy = expenseTravelType1.getTravelBy();
                    String amount = expenseTravelType1.getAmount();
                    String currency = expenseTravelType1.getCurrency();
                    int status = 1;

                    if (expensestatus != 0 && expensestatus != 3) {
                        status = expenseTravelType1.getStatus();
                        if (status == 0) {
                            status = 2;
                        } else if (status == 1) {
                            status = 3;
                        }
                    }

                    JSONObject travelObject = new JSONObject();
                    travelObject.put("fromCity", fromCity);
                    travelObject.put("toCity", toCity);
                    travelObject.put("date", date);
                    travelObject.put("status", status);
                    travelObject.put("modeOfTravel", travelBy);
                    travelObject.put("amount", amount);
                    travelObject.put("currency", currency);
                    travelObject.put("id", travelid);
                    TravelArray.put(travelObject);

                }
                data.put("travelReqAppNo", travelReqAppNo);
                data.put("travelReqAppNoId", travelReqAppNoId);
                data.put("travelType", travelType);
                travelOtherTypeList = relocationOrOtherExpenseService.readByExpenseMasterId(Integer.parseInt(expenseId));
                JSONArray otherTypeArray = new JSONArray();
                for (Object o2 : travelOtherTypeList) {
                    RelocationOrOtherExpense relocationOrOtherExpense = (RelocationOrOtherExpense) o2;
                    String otherExpense = relocationOrOtherExpense.getOtherExpense();
                    float amount = relocationOrOtherExpense.getAmount();
                    String currency = relocationOrOtherExpense.getCurrency();
                    int otherExpenseid = relocationOrOtherExpense.getId();
                    String expenseOtherSpecify = relocationOrOtherExpense.getExpenseOtherSpecify();
                    String otherExpenseDate = relocationOrOtherExpense.getOtherExpenseDate();
                    int status = 1;

                    if (expensestatus != 0 && expensestatus != 3) {
                        status = relocationOrOtherExpense.getStatus();
                        if (status == 0) {
                            status = 2;
                        } else if (status == 1) {
                            status = 3;
                        }
                    }

                    JSONObject travelObject = new JSONObject();
                    travelObject.put("otherExpense", otherExpense);
                    if (otherExpense.equals("Other")) {
                        String purpose = relocationOrOtherExpense.getExpenseOtherSpecify();
                        travelObject.put("purpose", purpose);
                    }

                    travelObject.put("amount", amount);
                    travelObject.put("currency", currency);
                    travelObject.put("status", status);
                    travelObject.put("purpose", expenseOtherSpecify);
                    travelObject.put("date", otherExpenseDate);
                    travelObject.put("id", otherExpenseid);
                    otherTypeArray.put(travelObject);

                }
                data.put("expenseDetails", TravelArray);
                data.put("otherExpenseDetails", otherTypeArray);

            }
            if (expenseMaster1.getExpenseType().equals("Relocation")) {
                relocationTypeList = expenseTravelTypeService.readByExpenseMasterId(Integer.parseInt(expenseId));
                for (Object o3 : relocationTypeList) {
                    ExpenseTravelType expenseTravelType1 = (ExpenseTravelType) o3;
                    int travelid = expenseTravelType1.getId();
                    String fromCity = expenseTravelType1.getFromCity();
                    String toCity = expenseTravelType1.getToCity();
                    String currency = expenseTravelType1.getCurrency();
                    String date = expenseTravelType1.getDate();
                    String travelBy = expenseTravelType1.getTravelBy();
                    String amount = expenseTravelType1.getAmount();
                    int status = 1;

                    if (expensestatus != 0 && expensestatus != 3) {
                        status = expenseTravelType1.getStatus();
                        if (status == 0) {
                            status = 2;
                        } else if (status == 1) {
                            status = 3;
                        }
                    }

                    JSONObject travelObject = new JSONObject();
                    travelObject.put("fromCity", fromCity);
                    travelObject.put("toCity", toCity);
                    travelObject.put("date", date);
                    travelObject.put("currency", currency);
                    travelObject.put("modeOfTravel", travelBy);
                    travelObject.put("amount", amount);
                    travelObject.put("status", status);
                    travelObject.put("id", travelid);
                    TravelArray.put(travelObject);
                }
                relocationOtherTypeList = relocationOrOtherExpenseService.readByExpenseMasterId(Integer.parseInt(expenseId));
                JSONArray otherTypeArray = new JSONArray();
                for (Object o4 : relocationOtherTypeList) {
                    RelocationOrOtherExpense relocationOrOtherExpense = (RelocationOrOtherExpense) o4;
                    String otherExpense = relocationOrOtherExpense.getOtherExpense();
                    float amount = relocationOrOtherExpense.getAmount();
                    String currency = relocationOrOtherExpense.getCurrency();
                    int otherExpenseid = relocationOrOtherExpense.getId();
                    String expenseOtherSpecify = relocationOrOtherExpense.getExpenseOtherSpecify();
                    String otherExpenseDate = relocationOrOtherExpense.getOtherExpenseDate();
                    int status = 1;

                    if (expensestatus != 0 && expensestatus != 3) {
                        status = relocationOrOtherExpense.getStatus();
                        if (status == 0) {
                            status = 2;
                        } else if (status == 1) {
                            status = 3;
                        }
                    }

                    JSONObject travelObject = new JSONObject();
                    travelObject.put("otherExpense", otherExpense);
                    if (otherExpense.equals("Other")) {
                        String purpose = relocationOrOtherExpense.getExpenseOtherSpecify();
                        travelObject.put("purpose", purpose);
                    }

                    travelObject.put("amount", amount);
                    travelObject.put("currency", currency);
                    travelObject.put("status", status);
                    travelObject.put("purpose", expenseOtherSpecify);
                    travelObject.put("date", otherExpenseDate);
                    travelObject.put("id", otherExpenseid);
                    otherTypeArray.put(travelObject);

                }
                data.put("expenseDetails", TravelArray);
                data.put("otherExpenseDetails", otherTypeArray);

            }
            if (expenseMaster1.getExpenseType().equals("PolicyReimbursements")) {
                policyOtherTypeList = relocationOrOtherExpenseService.readByExpenseMasterId(Integer.parseInt(expenseId));
                JSONArray policyReimbursementsArray = new JSONArray();
                for (Object policyReimb : policyOtherTypeList) {
                    RelocationOrOtherExpense relocationOrOtherExpense = (RelocationOrOtherExpense) policyReimb;
                    String otherExpense = relocationOrOtherExpense.getOtherExpense();
                    float amount = relocationOrOtherExpense.getAmount();
                    String currency = relocationOrOtherExpense.getCurrency();
                    int otherExpenseid = relocationOrOtherExpense.getId();
                    String specify = relocationOrOtherExpense.getPolicyNo();
                    String otherExpenseDate = relocationOrOtherExpense.getOtherExpenseDate();
                    int status = 1;

                    if (expensestatus != 0 && expensestatus != 3) {
                        status = relocationOrOtherExpense.getStatus();
                        if (status == 0) {
                            status = 2;
                        } else if (status == 1) {
                            status = 3;
                        }
                    }
                    JSONObject policyReimbursementsObj = new JSONObject();
                    policyReimbursementsObj.put("otherExpense", otherExpense);
                    if (otherExpense.equals("Other")) {
                        String purpose = relocationOrOtherExpense.getExpenseOtherSpecify();
                        policyReimbursementsObj.put("purpose", purpose);
                    }
                    policyReimbursementsObj.put("amount", amount);
                    policyReimbursementsObj.put("currency", currency);
                    policyReimbursementsObj.put("status", status);
                    data.put("pleaseSpecify", specify);
                    policyReimbursementsObj.put("date", otherExpenseDate);
                    policyReimbursementsObj.put("id", otherExpenseid);
                    policyReimbursementsArray.put(policyReimbursementsObj);

                }
                data.put("otherExpenseDetails", policyReimbursementsArray);
            }
            if (expenseMaster1.getExpenseType().equals("Others")) {
                JSONArray otherTypeArray = new JSONArray();

                othersList = expenseOtherTypeService.readByExpenseMasterId(Integer.parseInt(expenseId));
                for (Object o1 : othersList) {
                    ExpenseOtherType expenseOtherType = (ExpenseOtherType) o1;
                    String specify = expenseOtherType.getSpecify();
                    String billDate = expenseOtherType.getBillDate();
                    String bilNo = expenseOtherType.getBilNo();
                    float amount = expenseOtherType.getAmount();
                    int otherid = expenseOtherType.getId();
                    String currency = expenseOtherType.getCurrency();
                    int status = 1;

                    if (expensestatus != 0 && expensestatus != 3) {
                        status = expenseOtherType.getStatus();
                        if (status == 0) {
                            status = 2;
                        } else if (status == 1) {
                            status = 3;
                        }
                    }
                    JSONObject otherObject = new JSONObject();
                    data.put("pleaseSpecify", specify);
                    otherObject.put("date", billDate);
                    otherObject.put("invoiceNo", bilNo);
                    otherObject.put("amount", amount);
                    otherObject.put("status", status);
                    otherObject.put("currency", currency);
                    otherObject.put("id", otherid);
                    otherTypeArray.put(otherObject);

                }
                data.put("invoiceDetails", otherTypeArray);
            }

            List<?> expenseReconsilationList = expenseReconsilationService.readExpenseReconsilationByExpenseID(Integer.parseInt(expenseId));
            JSONArray expenseSummary = new JSONArray();
            for (Object Expobj : expenseReconsilationList) {
                JSONObject expensesummObject = new JSONObject();
                ExpenseReconsilation expenseReconsilation = (ExpenseReconsilation) Expobj;
                String currency = expenseReconsilation.getCurrencyType();
                float amount = expenseReconsilation.getExpenseInReport();
                float paidByCompany = expenseReconsilation.getExpensePaid();
                float advanceCash = expenseReconsilation.getCashAdvance();
                float cashReturned = expenseReconsilation.getCashReturned();
                float variance = expenseReconsilation.getVarianceOwed();

                expensesummObject.put("currency", currency);
                expensesummObject.put("reportExpense", amount);
                expensesummObject.put("paidByCompany", paidByCompany);
                expensesummObject.put("advanceCash", advanceCash);
                expensesummObject.put("cashReturned", cashReturned);
                expensesummObject.put("variance", variance);
                expenseSummary.put(expensesummObject);

            }
            data.put("expenseSummary", expenseSummary);
            List<?> currencyList = currencyMasterService.read();
            JSONArray currencyarray = new JSONArray();
            for (int i = 0; i < currencyList.size(); i++) {
                JSONObject currencyobj = new JSONObject();
                CurrencyMaster currencyMaster = (CurrencyMaster) currencyList.get(i);
                String currencyid = (currencyMaster.getId()).toString();
                String currencyname = currencyMaster.getCurrencyName();
                String currencycode = currencyMaster.getCurrencyCode();
                currencyobj.put("CurrencyId", currencyid);
                currencyobj.put("CurrencyName", currencyname);
                currencyobj.put("CurrencyCode", currencycode);
                currencyarray.put(currencyobj);
            }
            data.put("currencyarray", currencyarray);
            message = "Success";
            rcode = "1";
        } catch (Exception exception) {
            message = "Error";
            rcode = "0";
        }
        data.put("responseMessage", message);
        data.put("responseCode", rcode);

        out.println(data);

    }

    public void expenseEdit(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, JSONException {

        PrintWriter out = null;
        out = response.getWriter();
        String rcode = "";
        String message = "";
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        UserMaster user = new UserMaster();
        ExpenseMaster expenseMaster = new ExpenseMaster();
        ExpenseMaster expenseMaster1 = new ExpenseMaster();
        JSONObject userData = new JSONObject();
        try {
            JSONObject data = doPost(request);
            String userId = request.getParameter("id");
            user.setId(Integer.parseInt(userId));
            employeeMaster.setUserMaster(user);
            String expenseid = request.getParameter("expenseId");
            int expenseId = Integer.parseInt(expenseid);
            expenseMaster = expenseMasterService.readById(expenseId);
            String expensetype = expenseMaster.getExpenseType();
            String dateOfsub = expenseMaster.getDateOfSubmit();
            List<?> travelTypeList = new ArrayList<Object>();
            List<?> relocationOtherTypeList = new ArrayList<Object>();

            List<?> othersList = new ArrayList<Object>();
            List<?> expreconsilationList = new ArrayList<Object>();

            travelTypeList = expenseTravelTypeService.readByExpenseMasterId(expenseId);
            if (!travelTypeList.isEmpty()) {
                for (Object o : travelTypeList) {
                    ExpenseTravelType expenseTravelType1 = (ExpenseTravelType) o;
                    int expTravelId = expenseTravelType1.getId();
                    int status = expenseTravelType1.getStatus();
                    if (status != 1) {
                        expenseTravelTypeService.delete(expTravelId);
                    }
                }
            }

            relocationOtherTypeList = relocationOrOtherExpenseService.readByExpenseMasterId(expenseId);
            if (!relocationOtherTypeList.isEmpty()) {
                for (Object o : relocationOtherTypeList) {
                    RelocationOrOtherExpense relocationOrOtherExpense1 = (RelocationOrOtherExpense) o;
                    int relocationOtherId = relocationOrOtherExpense1.getId();
                    int status = relocationOrOtherExpense1.getStatus();
                    if (status != 1) {
                        relocationOrOtherExpenseService.delete(relocationOtherId);
                    }
                }
            }

            othersList = expenseOtherTypeService.readByExpenseMasterId(expenseId);
            if (!othersList.isEmpty()) {
                for (Object o : othersList) {
                    ExpenseOtherType expenseOtherType1 = (ExpenseOtherType) o;
                    int expenseOtherTypeId = expenseOtherType1.getId();
                    int status = expenseOtherType1.getStatus();
                    if (status != 1) {
                        expenseOtherTypeService.delete(expenseOtherTypeId);
                    }
                }
            }

            expreconsilationList = expenseReconsilationService.readExpenseReconsilationByExpenseID(expenseId);
            if (!expreconsilationList.isEmpty()) {
                for (Object o : expreconsilationList) {
                    ExpenseReconsilation expenseReconsilation = (ExpenseReconsilation) o;
                    int expenseReconsilationId = expenseReconsilation.getId();
                    int status = expenseReconsilation.getStatus();
                    if (status != 1) {
                        expenseReconsilationService.delete(expenseReconsilationId);
                    }
                }
            }

            List<?> empDetailList = employeeMasterService.readByEmployeeUserId(employeeMaster);
            if (!empDetailList.isEmpty()) {
                employeeMaster1 = (EmployeeMaster) empDetailList.get(0);
                ExpenseTravelType expenseTravelType = new ExpenseTravelType();
                RelocationOrOtherExpense relocationOrOtherExpense = new RelocationOrOtherExpense();
                ExpenseOtherType expenseOtherType = new ExpenseOtherType();
                ExpenseReconsilation expenseReconsilation = new ExpenseReconsilation();

                expenseMaster.setEmployeeMasterByEmployeeId(employeeMaster1);
                expenseMaster.setExpenseType(data.get("expenseType").toString());
                Date date1 = Calendar.getInstance().getTime();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

                expenseMaster.setDateOfSubmit(sdf.format(date1));
                if ((data.get("action").toString()).equals("0")) {
                    expenseMaster.setStatus(3);
                } else {
                    expenseMaster.setStatus(0);
                }

                if (expenseMaster.getExpenseType().equals("Travel") || expenseMaster.getExpenseType().equals("Relocation")) {
                    if (expenseMaster.getExpenseType().equals("Travel")) {
                        expenseMaster.setTravelStartDate((data.get("startDate")).toString());
                        expenseMaster.setTravelEndDate((data.get("endDate")).toString());
                        expenseTravelType.setTravelApplicationNo((data.get("travelId")).toString());
                    }
                    if (expenseMaster.getExpenseType().equals("Relocation")) {
                        expenseTravelType.setTravelApplicationNo("");
                    }

                    JSONArray TravelDeatails = data.getJSONArray("expenseDetails");
                    expenseMasterService.update(expenseMaster);

                    for (int i = 0; i < TravelDeatails.length(); i++) {
                        JSONObject travelDetailObj = TravelDeatails.getJSONObject(i);
                        String fromCity = (travelDetailObj.get("fromCity")).toString();
                        String toCity = (travelDetailObj.get("toCity")).toString();
                        String date = (travelDetailObj.get("date")).toString();
                        String travelBy = (travelDetailObj.get("modeOfTravel")).toString();
                        String amount = (travelDetailObj.get("amount")).toString();
                        String currency = (travelDetailObj.get("currency")).toString();
                        int travelstatus = Integer.parseInt((travelDetailObj.get("status")).toString());

                        if (travelstatus != 3) {
                            if (!"".equals(fromCity) && !"".equals(toCity) && !"".equals(date) && !"".equals(travelBy) && !"".equals(amount) && !"".equals(currency)) {
                                expenseTravelType.setFromCity(fromCity);
                                expenseTravelType.setToCity(toCity);
                                expenseTravelType.setDate(date);
                                expenseTravelType.setTravelBy(travelBy);
                                expenseTravelType.setAmount(amount);
                                expenseTravelType.setCurrency(currency);
                                expenseTravelType.setExpenseMaster(expenseMaster);
                                expenseTravelTypeService.create(expenseTravelType);

                            }
                        }
                    }
                    JSONArray otherDetailCount = data.getJSONArray("otherExpenseDetails");
                    for (int i = 0; i < otherDetailCount.length(); i++) {
                        JSONObject otherDetailObj = otherDetailCount.getJSONObject(i);
                        String otherExpense = (otherDetailObj.get("otherExpense").toString());
                        String currency = (otherDetailObj.get("currency").toString());
                        String otherExpenseDate = (otherDetailObj.get("date").toString());
                        int otherExpensestatus = Integer.parseInt(otherDetailObj.get("status").toString());
                        float amount = Float.parseFloat(otherDetailObj.get("amount").toString());
                        if (otherExpense.contains("Other")) {
                            String purpose = (otherDetailObj.get("purpose").toString());
                            relocationOrOtherExpense.setExpenseOtherSpecify(purpose);
                        }
                        if (otherExpensestatus != 3) {
                            if (!"".equals(otherExpense) && !"".equals((otherDetailObj.get("amount").toString())) && !"".equals(currency)) {
                                relocationOrOtherExpense.setOtherExpenseDate(otherExpenseDate);
                                relocationOrOtherExpense.setOtherExpense(otherExpense);
                                relocationOrOtherExpense.setAmount(amount);
                                relocationOrOtherExpense.setCurrency(currency);
                                relocationOrOtherExpense.setExpenseMaster(expenseMaster);
                                relocationOrOtherExpenseService.create(relocationOrOtherExpense);
                            }
                        }
                    }

                }
                if (expenseMaster.getExpenseType().equals("PolicyReimbursements")) {
                    expenseMasterService.update(expenseMaster);
                    JSONArray otherDetailCount = data.getJSONArray("otherExpenseDetails");
                    for (int i = 0; i < otherDetailCount.length(); i++) {

                        String pleaseSpecify = (data.get("pleaseSpecify").toString());
                        JSONObject otherDetailObj = otherDetailCount.getJSONObject(i);
                        String otherExpense = (otherDetailObj.get("otherExpense").toString());
//                        String currency = (otherDetailObj.get("currency").toString());
                        String otherExpenseDate = (otherDetailObj.get("date").toString());
                        float amount = Float.parseFloat(otherDetailObj.get("amount").toString());
                        int otherExpensestatus = Integer.parseInt(otherDetailObj.get("status").toString());
                        if (otherExpense.equals("Other")) {
                            String purpose = (otherDetailObj.get("purpose").toString());
                            relocationOrOtherExpense.setExpenseOtherSpecify(purpose);
                        }
                        if (otherExpensestatus != 3) {
                            relocationOrOtherExpense.setPolicyNo(pleaseSpecify);
                            relocationOrOtherExpense.setOtherExpenseDate(otherExpenseDate);
                            relocationOrOtherExpense.setOtherExpense(otherExpense);
                            relocationOrOtherExpense.setAmount(amount);
                            relocationOrOtherExpense.setCurrency("5");
                            relocationOrOtherExpense.setExpenseMaster(expenseMaster);
                            relocationOrOtherExpenseService.create(relocationOrOtherExpense);
                        }
                    }
                }
                if (expenseMaster.getExpenseType().equals("Others")) {
                    JSONArray othertype = data.getJSONArray("invoiceDetails");

                    String specify = (data.get("pleaseSpecify")).toString();
                    expenseMasterService.update(expenseMaster);
                    for (int i = 0; i < othertype.length(); i++) {
                        JSONObject otherDetailObj = othertype.getJSONObject(i);
                        String date = (otherDetailObj.get("date").toString());
                        String billNo = (otherDetailObj.get("invoiceNo").toString());
                        int otherstatus = Integer.parseInt(otherDetailObj.get("otherstatus").toString());
//                        String currency = (otherDetailObj.get("currency").toString());
                        float amount = Float.parseFloat(otherDetailObj.get("amount").toString());
                        if (otherstatus != 3) {
                            if (!"".equals(date) && !"".equals(billNo) && !"".equals(request.getParameter("amount"))) {

                                expenseOtherType.setBillDate(date);
                                expenseOtherType.setBilNo(billNo);
                                expenseOtherType.setAmount(amount);
                                expenseOtherType.setSpecify(specify);
                                expenseOtherType.setCurrency("5");
                                expenseOtherType.setExpenseMaster(expenseMaster);
                                expenseOtherTypeService.create(expenseOtherType);
                            }
                        }

                    }

                }

                JSONArray expenseReconsilationArray = data.getJSONArray("expenseSummary");
                for (int i = 0; i < expenseReconsilationArray.length(); i++) {

                    JSONObject expReconsilationObj = expenseReconsilationArray.getJSONObject(i);
                    if (((expReconsilationObj.get("reportExpense")).toString()) != null && !((expReconsilationObj.get("reportExpense")).toString()).equals("0")) {
                        expenseReconsilation.setExpenseMaster(expenseMaster);

                        float amount = Float.parseFloat((expReconsilationObj.get("reportExpense")).toString());
                        float paidByCompany = Float.parseFloat((expReconsilationObj.get("paidByCompany")).toString());
                        float advanceCash = Float.parseFloat((expReconsilationObj.get("advanceCash")).toString());
                        float cashReturned = Float.parseFloat((expReconsilationObj.get("cashReturned")).toString());
                        float variance = Float.parseFloat((expReconsilationObj.get("variance")).toString());
                        String currencyType = "";
                        if (expenseMaster.getExpenseType().equals("Travel")) {
                            currencyType = (expReconsilationObj.get("currencyId")).toString();
                        } else {
                            currencyType = "5";
                        }
                        expenseReconsilation.setCurrencyType(currencyType);
                        expenseReconsilation.setExpenseInReport(amount);
                        expenseReconsilation.setExpensePaid(paidByCompany);
                        expenseReconsilation.setCashReturned(cashReturned);
                        expenseReconsilation.setCashAdvance(advanceCash);
                        expenseReconsilation.setVarianceOwed(variance);
                        expenseReconsilationService.create(expenseReconsilation);

                    }
                }
                message = "Success";
                rcode = "1";

            }

        } catch (Exception exception) {
            message = "Error";
            rcode = "0";

        }
        userData.put("responseMessage", message);
        userData.put("responseCode", rcode);

        out.println(userData);

    }
}
