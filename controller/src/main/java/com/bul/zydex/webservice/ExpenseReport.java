/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.webservice;

import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.ExpenseMaster;
import com.bul.zydex.model.ExpenseOtherType;
import com.bul.zydex.model.ExpenseTravelType;
import com.bul.zydex.model.RelocationOrOtherExpense;
import com.bul.zydex.model.TravelRequestMaster;
import com.bul.zydex.model.UserMaster;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author admin
 */
public class ExpenseReport extends ExpenseReportAbstarct {

    public void TravelAppNoRequestList(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, JSONException {
        PrintWriter out = null;
        out = response.getWriter();
        String rcode = "";
        String message = "";
        String empid = "";
        UserMaster user = new UserMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        JSONObject userData = new JSONObject();
        JSONObject data =  new JSONObject();
        String id = request.getParameter("id");
        int userid = Integer.parseInt(id);
        user.setId(userid);
        employeeMaster.setUserMaster(user);
        List<?> empDetailList = employeeMasterService.readByEmployeeUserId(employeeMaster);
        if (!empDetailList.isEmpty()) {
            employeeMaster1 = (EmployeeMaster) empDetailList.get(0);
        }
        ExpenseMaster expenseMaster = new ExpenseMaster();
        ExpenseMaster expenseMaster1 = new ExpenseMaster();
        EmployeeMaster employeeMaster2 = new EmployeeMaster();
        EmployeeMaster employeeMaster3 = new EmployeeMaster();
        expenseMaster.setEmployeeMasterByEmployeeId(employeeMaster);
        List<?> list = null;
        List<?> travelTypeList = new ArrayList<Object>();
        List<?> relocationTypeList = new ArrayList<Object>();
        List<?> travelOtherTypeList = new ArrayList<Object>();
        List<?> relocationOtherTypeList = new ArrayList<Object>();
        List<?> policyOtherTypeList = new ArrayList<Object>();
        List<?> othersList = new ArrayList<Object>();
//        Object flag = request.getAttribute("flag");
//        String flag1 = "";
//        if (flag != null) {
//            flag1 = flag.toString();
//        }
            list = expenseMasterService.readByEmpId(expenseMaster);
        if (!list.isEmpty()) {
            for (Object othersList1 : list) {
                expenseMaster1 = (ExpenseMaster) othersList1;

                String flag3 = "true";
                if (expenseMaster1.getExpenseType().equals("Travel")) {
                    travelTypeList = expenseTravelTypeService.readByExpenseMasterId(expenseMaster1.getId());
                    for (Object o : travelTypeList) {
                        ExpenseTravelType expenseTravelType = (ExpenseTravelType) o;
                        if (expenseTravelType.getStatus() != 1) {
                            flag3 = "false";
                        }

                    }
                    travelOtherTypeList = relocationOrOtherExpenseService.readByExpenseMasterId(expenseMaster1.getId());
                    for (Object o2 : travelOtherTypeList) {
                        RelocationOrOtherExpense relocationOrOtherExpense = (RelocationOrOtherExpense) o2;
                        if (relocationOrOtherExpense.getStatus() != 1) {
                            flag3 = "false";
                        }

                    }
                }
                if (expenseMaster1.getExpenseType().equals("Relocation")) {
                    relocationTypeList = expenseTravelTypeService.readByExpenseMasterId(expenseMaster1.getId());
                    for (Object o3 : relocationTypeList) {
                        ExpenseTravelType expenseTravelType = (ExpenseTravelType) o3;
                        if (expenseTravelType.getStatus() != 1) {
                            flag3 = "false";
                        }

                    }
                    relocationOtherTypeList = relocationOrOtherExpenseService.readByExpenseMasterId(expenseMaster1.getId());
                    for (Object o4 : relocationOtherTypeList) {
                        RelocationOrOtherExpense relocationOrOtherExpense = (RelocationOrOtherExpense) o4;
                        if (relocationOrOtherExpense.getStatus() != 1) {
                            flag3 = "false";
                        }
                    }
                }
                if (expenseMaster1.getExpenseType().equals("PolicyReimbursements")) {
                    policyOtherTypeList = relocationOrOtherExpenseService.readByExpenseMasterId(expenseMaster1.getId());
                    for (Object policyReimb : policyOtherTypeList) {
                        RelocationOrOtherExpense relocationOrOtherExpense = (RelocationOrOtherExpense) policyReimb;
                        if (relocationOrOtherExpense.getStatus() != 1) {
                            flag3 = "false";
                        }
                    }
                }
                if (expenseMaster1.getExpenseType().equals("Others")) {
                    othersList = expenseOtherTypeService.readByExpenseMasterId(expenseMaster1.getId());
                    for (Object o1 : othersList) {
                        ExpenseOtherType expenseOtherType = (ExpenseOtherType) o1;
                        System.out.println("ajay" + expenseOtherType.getStatus());
                        if (expenseOtherType.getStatus() != 1) {
                            flag3 = "false";
                        }
                    }
                }

                employeeMaster1 = employeeMasterService.readById(expenseMaster1.getEmployeeMasterByEmployeeId().getId());
                employeeMaster1.setChild1(flag3);
                expenseMaster1.setEmployeeMasterByEmployeeId(employeeMaster1);
                if (expenseMaster1.getEmployeeMasterByApprover1Id() != null) {
                    employeeMaster2 = employeeMasterService.readById(expenseMaster1.getEmployeeMasterByApprover1Id().getId());
                    expenseMaster1.setEmployeeMasterByApprover1Id(employeeMaster2);
                }
                if (expenseMaster1.getEmployeeMasterByApprover2Id() != null) {
                    employeeMaster3 = employeeMasterService.readById(expenseMaster1.getEmployeeMasterByApprover2Id().getId());
                    expenseMaster1.setEmployeeMasterByApprover2Id(employeeMaster3);
                }
            }
        }

    }
}

