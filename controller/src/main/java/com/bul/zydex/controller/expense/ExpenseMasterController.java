/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.expense;

import com.bul.zydex.model.DepartmentMaster;
import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.model.EmailTemplate;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.ExpenseMaster;
import com.bul.zydex.model.ExpenseOtherType;
import com.bul.zydex.model.ExpenseReconsilation;
import com.bul.zydex.model.ExpenseTravelType;
import com.bul.zydex.model.LevelMaster;
import com.bul.zydex.model.LocationMaster;
import com.bul.zydex.model.RelocationOrOtherExpense;
import com.bul.zydex.model.TravelRequestMaster;
import com.bul.zydex.model.UserMaster;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author dhruv
 */
public class ExpenseMasterController extends ExpenseMasterAbstract {

    public ModelAndView createExpenseResult(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ExpenseMaster expenseMaster = new ExpenseMaster();
        ExpenseMaster expenseMaster1 = new ExpenseMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        EmployeeMaster employeeMaster2 = new EmployeeMaster();
        EmployeeMaster employeeMaster3 = new EmployeeMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        UserMaster user = (UserMaster) request.getSession().getAttribute("user");
        employeeMaster.setUserMaster(user);
        List<?> empList = employeeMasterService.readByUserName(employeeMaster);
        if (!empList.isEmpty()) {
            employeeMaster = (EmployeeMaster) empList.get(0);
        }

        expenseMaster.setEmployeeMasterByEmployeeId(employeeMaster);
        List<?> list = null;
        List<?> travelTypeList = new ArrayList<Object>();
        List<?> relocationTypeList = new ArrayList<Object>();
        List<?> travelOtherTypeList = new ArrayList<Object>();
        List<?> relocationOtherTypeList = new ArrayList<Object>();
        List<?> policyOtherTypeList = new ArrayList<Object>();
        List<?> othersList = new ArrayList<Object>();
        Object flag = request.getAttribute("flag");
        String flag1 = "";
        if (flag != null) {
            flag1 = flag.toString();
        }
        if (flag1.equals("1")) {
            list = (List<?>) request.getAttribute("list");
        } else {
            list = expenseMasterService.readByEmpId(expenseMaster);
        }
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

        mv.getModelMap().put("employeeMaster", employeeMaster);

        request.setAttribute("list", list);
        mv.getModelMap().put("expenseMaster", expenseMaster);
        mv.setViewName("ExpenseReport/ExpenseReportResult");
        return mv;
    }

    public ModelAndView createClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ExpenseMaster expenseMaster = new ExpenseMaster();

        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        DesignationMaster designationMaster;
        LevelMaster levelMaster;
        DepartmentMaster departmentMaster;
        LocationMaster locationMaster;
        UserMaster user = (UserMaster) request.getSession().getAttribute("user");
        employeeMaster.setUserMaster(user);
        List<?> empList = employeeMasterService.readByUserName(employeeMaster);
        if (!empList.isEmpty()) {
            employeeMaster = (EmployeeMaster) empList.get(0);
        }
        int levelId = employeeMaster.getLevelMaster().getId();
        int deptId = employeeMaster.getDepartmentMaster().getId();
        int desigId = employeeMaster.getDesignationMaster().getId();
        if (employeeMaster.getReportingManagerLevel1() == "") {
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

        request.setAttribute("employeeMaster", employeeMaster);
        mv.getModelMap().put("expenseMaster", expenseMaster);
        mv.setViewName("ExpenseReport/ExpenseReportCreate");

        return mv;
    }

    public ModelAndView submitExpenseReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ExpenseMaster expenseMaster = new ExpenseMaster();
        ExpenseTravelType expenseTravelType = new ExpenseTravelType();
        ExpenseOtherType expenseOtherType = new ExpenseOtherType();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        EmployeeMaster employeeMaster2 = new EmployeeMaster();

        DesignationMaster designationMaster;
        LevelMaster levelMaster;
        DepartmentMaster departmentMaster;

        ExpenseReconsilation expenseReconsilation = new ExpenseReconsilation();
        RelocationOrOtherExpense relocationOrOtherExpense = new RelocationOrOtherExpense();
        UserMaster user = (UserMaster) request.getSession().getAttribute("user");
        employeeMaster.setUserMaster(user);
        bind(request, expenseMaster);
        BindException errors = new BindException(expenseMaster, "expenseMaster");
        expenseMasterValidator.validate(expenseMaster, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv.addAllObjects(errors.getModel());
            List<?> empList = employeeMasterService.readByUserName(employeeMaster);
            if (!empList.isEmpty()) {
                employeeMaster = (EmployeeMaster) empList.get(0);
            }
            int levelId = employeeMaster.getLevelMaster().getId();
            int deptId = employeeMaster.getDepartmentMaster().getId();
            int desigId = employeeMaster.getDesignationMaster().getId();
            if (employeeMaster.getReportingManagerLevel1() == "") {
                employeeMaster.setReportingManagerLevel1("1");
            }
            int managerId = Integer.parseInt(employeeMaster.getReportingManagerLevel1());
            employeeMaster1 = employeeMasterService.readById(managerId);
            employeeMaster.setChild1(employeeMaster1.getEmployeeName());
            levelMaster = levelMasterService.readById(levelId);
            designationMaster = designationMasterService.readById(desigId);
            departmentMaster = departmentMasterService.readById(deptId);
            employeeMaster.setLevelMaster(levelMaster);
            employeeMaster.setDepartmentMaster(departmentMaster);
            employeeMaster.setDesignationMaster(designationMaster);
            request.setAttribute("employeeMaster", employeeMaster);
//            request.setAttribute("expenseMaster", expenseMaster);
            mv.setViewName("ExpenseReport/ExpenseReportCreate");
        } else {

            int approver1 = Integer.parseInt(request.getParameter("ApproverId1"));
            int approver2;
            if (request.getParameter("ApproverId2").equals("")) {
                approver2 = 1;
            } else {
                approver2 = Integer.parseInt(request.getParameter("ApproverId2"));
            }
            int empId = Integer.parseInt(request.getParameter("empId"));
            employeeMaster.setId(empId);
//            employeeMaster1.setId(approver1);
//            employeeMaster2.setId(approver2);
//            expenseMaster.setEmployeeMasterByApprover1Id(employeeMaster1);
//            expenseMaster.setEmployeeMasterByApprover2Id(employeeMaster2);
            expenseMaster.setEmployeeMasterByEmployeeId(employeeMaster);

            String btnType = request.getParameter("btnType");
            if (btnType.equals("Save")) {
                expenseMaster.setStatus(3);
            } //email template.....
            expenseMaster.setTravelStartDate(request.getParameter("travelStartDate"));
            expenseMaster.setTravelEndDate(request.getParameter("travelEndDate"));
            expenseMasterService.create(expenseMaster);
          
            if (btnType.equals("Submit")) {

                try { 
                    mailSendExpenseApply(request);
                    EmailTemplate emailTemplate = new EmailTemplate();
                    EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                    DesignationMaster designationMaster1 = new DesignationMaster();
                    designationMaster1 = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                    EmployeeMaster employeeMasterHr = new EmployeeMaster();
                    employeeMasterHr = employeeMasterService.readById(Integer.parseInt(employeeMasterModel.getReportingManagerLevel1()));
                    // id 19 is apply Expense
                    emailTemplate = emailTemplateService.readById(19);
                    String To = employeeMasterHr.getOfficeEmailId();
                    String from = employeeMasterModel.getOfficeEmailId();
                    String Subject = emailTemplate.getSubject();
                    Subject = Subject.replaceAll("\\{user\\}", employeeMasterModel.getEmployeeName());
                    String msg = emailTemplate.getBodytext();
                    msg = msg.replaceAll("\\{to_user\\}", employeeMasterHr.getEmployeeName());
                    msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                    msg = msg.replaceAll("\\{from_designation\\}", designationMaster1.getDesignationName());
                    sendMail.sendMail(from, To, Subject, msg);
                } catch (Exception e) {
                }
            }

//        ExpenseDetail
            if (expenseMaster.getExpenseType().equals("Travel") || expenseMaster.getExpenseType().equals("Relocation")) {

                expenseTravelType.setTravelApplicationNo(request.getParameter("travelNo"));

                int travelDetailCount = Integer.parseInt(request.getParameter("countFirst"));
                int otherDetailCount = Integer.parseInt(request.getParameter("countSecond"));
                for (int i = 1; i <= travelDetailCount; i++) {
                    String fromCity = "";
                    String toCity = "";
                    String date = "";
                    String travelBy = "";
                    String amount = "";
                    String currency = "";

                    fromCity = request.getParameter("fromCity" + i);
                    toCity = request.getParameter("toCity" + i);
                    date = request.getParameter("travelDate" + i);
                    travelBy = request.getParameter("WorkTypeSelect" + i);
                    amount = request.getParameter("amount" + i);
                    currency = request.getParameter("currencyTravelDiv" + i);
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
                for (int i = 1; i <= otherDetailCount; i++) {
                    String otherExpense = "";
                    String currency = "";
                    String otherExpenseDate = request.getParameter("otherExpenseDate" + i);
                    otherExpense = request.getParameter("RentAndFoodDiv" + i);
                    float amount = Float.parseFloat(request.getParameter("otherAmount" + i));
                    currency = request.getParameter("currencyRelocationDiv" + i);
                    String purpose = request.getParameter("purpose" + i);
                    if (!"".equals(otherExpense) && !"".equals(request.getParameter("otherAmount" + i)) && !"".equals(currency)) {
                        relocationOrOtherExpense.setOtherExpenseDate(otherExpenseDate);
                        relocationOrOtherExpense.setOtherExpense(otherExpense);
                        relocationOrOtherExpense.setAmount(amount);
                        relocationOrOtherExpense.setExpenseOtherSpecify(purpose);
                        relocationOrOtherExpense.setCurrency(currency);
                        relocationOrOtherExpense.setExpenseMaster(expenseMaster);
                        relocationOrOtherExpenseService.create(relocationOrOtherExpense);
                    }
                }

            }
            if (expenseMaster.getExpenseType().equals("PolicyReimbursements")) {

                String policyNo = request.getParameter("policyNo");

                int otherDetailCount = Integer.parseInt(request.getParameter("countSecond"));
                for (int i = 1; i <= otherDetailCount; i++) {
                    String otherExpenseDate = request.getParameter("otherExpenseDate" + i);
                    String otherExpense = request.getParameter("RentAndFoodDiv" + i);
                    float amount = Float.parseFloat(request.getParameter("otherAmount" + i));
                    String currency = request.getParameter("currencyRelocationDiv" + i);
                    String purpose = request.getParameter("purpose" + i);
                    relocationOrOtherExpense.setOtherExpenseDate(otherExpenseDate);
                    relocationOrOtherExpense.setOtherExpense(otherExpense);
                    relocationOrOtherExpense.setAmount(amount);
                    relocationOrOtherExpense.setCurrency(currency);
                    relocationOrOtherExpense.setExpenseMaster(expenseMaster);
                    relocationOrOtherExpense.setExpenseOtherSpecify(purpose);
                    relocationOrOtherExpense.setPolicyNo(policyNo);
                    relocationOrOtherExpenseService.create(relocationOrOtherExpense);
                }
            }
            if (expenseMaster.getExpenseType().equals("Others")) {
                int othersCount = Integer.parseInt(request.getParameter("othersCount"));
                String specify = request.getParameter("Specify");
                for (int i = 1; i <= othersCount; i++) {
                    String date = "";
                    String billNo = "";
                    String currency = "";

                    date = request.getParameter("billDate" + i);
                    billNo = request.getParameter("billNo" + i);
                    float amount = Float.parseFloat(request.getParameter("policyAmount" + i));
                    currency = request.getParameter("otherCurrency" + i);
                    if (!"".equals(date) && !"".equals(billNo) && !"".equals(currency) && !"".equals(request.getParameter("policyAmount" + i))) {

                        expenseOtherType.setBillDate(date);
                        expenseOtherType.setBilNo(billNo);
                        expenseOtherType.setAmount(amount);
                        expenseOtherType.setSpecify(specify);
                        expenseOtherType.setCurrency(currency);
                        expenseOtherType.setExpenseMaster(expenseMaster);
                        expenseOtherTypeService.create(expenseOtherType);
                    }

                }

            }
            //By Ajay
            expenseReconsilation.setExpenseMaster(expenseMaster);
            readcurrencyList(request);
            Map<Integer, String> aaaa = (HashMap<Integer, String>) request.getAttribute("currencyMap");
            for (Map.Entry<Integer, String> entrySet : aaaa.entrySet()) {
                Integer key = entrySet.getKey();
                String value = entrySet.getValue();
                if (request.getParameter("totalAmount_" + key) != null && !request.getParameter("totalAmount_" + key).equals("0")) {

                    float amount = Float.parseFloat(request.getParameter("totalAmount_" + key));
                    float paidByCompany = Float.parseFloat(request.getParameter("paidByCompany" + key));
                    float advanceCash = Float.parseFloat(request.getParameter("advanceCash" + key));
                    float cashReturned = Float.parseFloat(request.getParameter("cashReturned" + key));
                    float variance = Float.parseFloat(request.getParameter("variance" + key));
                    expenseReconsilation.setCurrencyType("" + key);
                    expenseReconsilation.setExpenseInReport(amount);
                    expenseReconsilation.setExpensePaid(paidByCompany);
                    expenseReconsilation.setCashReturned(cashReturned);
                    expenseReconsilation.setCashAdvance(advanceCash);
                    expenseReconsilation.setVarianceOwed(variance);
                    expenseReconsilationService.create(expenseReconsilation);

                }

            }
            //By Ajay

            mv.getModelMap().put("expenseMaster", expenseMaster);
            request.setAttribute("successMessage",
                    "Information : The Information is saved Successfully.");

//        mv.setViewName("ExpenseReport/Appraisal360FeedbackFormCreate");
            mv = createExpenseResult(request, response);
        }
        return mv;
    }

    public ModelAndView viewClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ExpenseMaster expenseMaster = new ExpenseMaster();
        ExpenseMaster expenseMaster1 = new ExpenseMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        DesignationMaster designationMaster;
        LevelMaster levelMaster;
        DepartmentMaster departmentMaster;
        LocationMaster locationMaster;

        List<?> travelTypeList = new ArrayList<Object>();
        List<?> relocationTypeList = new ArrayList<Object>();
        List<?> travelOtherTypeList = new ArrayList<Object>();
        List<?> relocationOtherTypeList = new ArrayList<Object>();
        List<?> policyOtherTypeList = new ArrayList<Object>();
        List<?> othersList = new ArrayList<Object>();
        UserMaster user = (UserMaster) request.getSession().getAttribute("user");
        employeeMaster.setUserMaster(user);
        List<?> empList = employeeMasterService.readByUserName(employeeMaster);
        if (!empList.isEmpty()) {
            employeeMaster = (EmployeeMaster) empList.get(0);
        }
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
        int expenseId = Integer.parseInt(request.getParameter("id"));
        expenseMaster1 = expenseMasterService.readById(expenseId);
        boolean flag = true;
        boolean flag1 = true;
        boolean flag2 = true;
        boolean flag3 = true;
        boolean flag4 = true;
        boolean flag5 = true;
        if (expenseMaster1.getExpenseType().equals("Travel")) {
            travelTypeList = expenseTravelTypeService.readByExpenseMasterId(expenseId);
            for (Object o : travelTypeList) {
                ExpenseTravelType expenseTravelType = (ExpenseTravelType) o;
                if (expenseTravelType.getStatus() != 1) {
                    flag1 = false;
                }

            }
            travelOtherTypeList = relocationOrOtherExpenseService.readByExpenseMasterId(expenseId);
            for (Object o2 : travelOtherTypeList) {
                RelocationOrOtherExpense relocationOrOtherExpense = (RelocationOrOtherExpense) o2;
                if (relocationOrOtherExpense.getStatus() != 1) {
                    flag2 = false;
                }

            }
            request.setAttribute("flag1", flag1);
            request.setAttribute("flag2", flag2);
        }
        if (expenseMaster1.getExpenseType().equals("Relocation")) {
            relocationTypeList = expenseTravelTypeService.readByExpenseMasterId(expenseId);
            for (Object o3 : relocationTypeList) {
                ExpenseTravelType expenseTravelType = (ExpenseTravelType) o3;
                if (expenseTravelType.getStatus() != 1) {
                    flag3 = false;
                }

            }
            relocationOtherTypeList = relocationOrOtherExpenseService.readByExpenseMasterId(expenseId);
            for (Object o4 : relocationOtherTypeList) {
                RelocationOrOtherExpense relocationOrOtherExpense = (RelocationOrOtherExpense) o4;
                if (relocationOrOtherExpense.getStatus() != 1) {
                    flag4 = false;
                }

            }
            request.setAttribute("flag3", flag3);
            request.setAttribute("flag4", flag4);

        }
        if (expenseMaster1.getExpenseType().equals("PolicyReimbursements")) {
            policyOtherTypeList = relocationOrOtherExpenseService.readByExpenseMasterId(expenseId);
            for (Object policyReimb : policyOtherTypeList) {
                RelocationOrOtherExpense relocationOrOtherExpense = (RelocationOrOtherExpense) policyReimb;
                if (relocationOrOtherExpense.getStatus() != 1) {
                    flag5 = false;
                }
            }
            request.setAttribute("flag5", flag5);
        }
        if (expenseMaster1.getExpenseType().equals("Others")) {
            othersList = expenseOtherTypeService.readByExpenseMasterId(expenseId);
            for (Object o1 : othersList) {
                ExpenseOtherType expenseOtherType = (ExpenseOtherType) o1;
                System.out.println("ajay" + expenseOtherType.getStatus());
                if (expenseOtherType.getStatus() != 1) {
                    flag = false;
                }
            }
            request.setAttribute("flag", flag);
        }
        List<?> expenseReconsilationList = expenseReconsilationService.readExpenseReconsilationByExpenseID(expenseId);
        request.setAttribute("expenseReconsilationList", expenseReconsilationList);
        request.setAttribute("travelTypeList", travelTypeList);
        request.setAttribute("travelOtherTypeList", travelOtherTypeList);
        request.setAttribute("relocationTypeList", relocationTypeList);
        request.setAttribute("relocationOtherTypeList", relocationOtherTypeList);
        request.setAttribute("policyOtherTypeList", policyOtherTypeList);
        request.setAttribute("othersList", othersList);
        request.setAttribute("employeeMaster", employeeMaster);
        request.setAttribute("previousExpense", expenseMaster1.getExpenseType());
        request.setAttribute("expenseId", expenseId);
        mv.getModelMap().put("expenseMaster", expenseMaster1);
        mv.setViewName("ExpenseReport/ExpenseReportApproveView");
        return mv;
    }

    public ModelAndView saveSubmitExpenseReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ExpenseMaster expenseMaster = new ExpenseMaster();
        ExpenseTravelType expenseTravelType = new ExpenseTravelType();
        ExpenseOtherType expenseOtherType = new ExpenseOtherType();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        EmployeeMaster employeeMaster2 = new EmployeeMaster();
        ExpenseReconsilation expenseReconsilation = new ExpenseReconsilation();
        RelocationOrOtherExpense relocationOrOtherExpense = new RelocationOrOtherExpense();
        String previousExpense = request.getParameter("previousExpense");
        bind(request, expenseMaster);
        if (previousExpense.equals("Travel") || previousExpense.equals("Relocation")) {
            List<?> list = expenseTravelTypeService.readByExpenseMasterId(expenseMaster.getId());
            List<?> list1 = relocationOrOtherExpenseService.readByExpenseMasterId(expenseMaster.getId());
            for (Object o : list) {
                expenseTravelType = (ExpenseTravelType) o;
                expenseTravelTypeService.delete(expenseTravelType.getId());
            }
            for (Object o1 : list1) {
                relocationOrOtherExpense = (RelocationOrOtherExpense) o1;
                relocationOrOtherExpenseService.delete(relocationOrOtherExpense.getId());
            }
        }
        if (previousExpense.equals("PolicyReimbursements")) {
            List<?> list1 = relocationOrOtherExpenseService.readByExpenseMasterId(expenseMaster.getId());
            for (Object o1 : list1) {
                relocationOrOtherExpense = (RelocationOrOtherExpense) o1;
                relocationOrOtherExpenseService.delete(relocationOrOtherExpense.getId());
            }
        }
        if (previousExpense.equals("Others")) {
            List<?> list = expenseOtherTypeService.readByExpenseMasterId(expenseMaster.getId());
            for (Object o : list) {
                expenseOtherType = (ExpenseOtherType) o;
                expenseOtherTypeService.delete(expenseOtherType.getId());
            }
        }
        List expenseReconsilationList = expenseReconsilationService.readExpenseReconsilationByExpenseID(expenseMaster.getId());
        for (Object zz : expenseReconsilationList) {
            expenseReconsilation = (ExpenseReconsilation) zz;
            expenseReconsilationService.delete(expenseReconsilation.getId());
        }
        expenseMasterService.delete(expenseMaster.getId());

//        int approver1 = Integer.parseInt(request.getParameter("ApproverId1"));
//        int approver2;
//        if (request.getParameter("ApproverId2").equals("")) {
//            approver2 = 1;
//        } else {
//            approver2 = Integer.parseInt(request.getParameter("ApproverId2"));
//        }
        int empId = Integer.parseInt(request.getParameter("empId"));
        String btnType = request.getParameter("btnType");
        if (btnType.equals("Save")) {
            request.setAttribute("successMessage",
                    "Information : The Information is saved Successfully.");
            expenseMaster.setStatus(3);
        } else {

            request.setAttribute("successMessage",
                    "Information : The Information is saved Successfully.");
            expenseMaster.setStatus(0);

        }
        employeeMaster.setId(empId);
//        employeeMaster1.setId(approver1);
//        employeeMaster2.setId(approver2);
//        expenseMaster.setEmployeeMasterByApprover1Id(employeeMaster1);
//        expenseMaster.setEmployeeMasterByApprover2Id(employeeMaster2);
        expenseMaster.setEmployeeMasterByEmployeeId(employeeMaster);
        expenseMaster.setTravelStartDate(request.getParameter("travelStartDate"));
        expenseMaster.setTravelEndDate(request.getParameter("travelEndDate"));
        expenseMasterService.create(expenseMaster);

        if (expenseMaster.getExpenseType().equals("Travel")) {

            expenseTravelType.setTravelApplicationNo(request.getParameter("travelNo"));
            if (expenseTravelType.getTravelApplicationNo() == null) {
                expenseTravelType.setTravelApplicationNo("");
            }

            int travelDetailCount = Integer.parseInt(request.getParameter("countFirst"));
            int otherDetailCount = Integer.parseInt(request.getParameter("countSecond"));
            for (int i = 1; i <= travelDetailCount; i++) {
                String fromCity = request.getParameter("fromCity" + i);
                String toCity = request.getParameter("toCity" + i);
                String date = request.getParameter("travelDate" + i);
                String travelBy = request.getParameter("WorkTypeSelect" + i);
                String amount = request.getParameter("amount" + i);
                String currency = request.getParameter("currencyTravelDiv" + i);
                expenseTravelType.setFromCity(fromCity);
                expenseTravelType.setToCity(toCity);
                expenseTravelType.setDate(date);
                expenseTravelType.setTravelBy(travelBy);
                expenseTravelType.setAmount(amount);
                expenseTravelType.setCurrency(currency);
                expenseTravelType.setExpenseMaster(expenseMaster);
                expenseTravelTypeService.create(expenseTravelType);
            }
            for (int i = 1; i <= otherDetailCount; i++) {
                String travelotherExpenseDate = request.getParameter("travelotherExpenseDate" + i);
                String otherExpense = request.getParameter("RentAndFoodDiv" + i);
                float amount = Float.parseFloat(request.getParameter("otherAmount" + i));
                String currency = request.getParameter("currencyRelocationDiv" + i);
                String purpose = request.getParameter("purpose" + i);
                relocationOrOtherExpense.setOtherExpenseDate(travelotherExpenseDate);
                relocationOrOtherExpense.setOtherExpense(otherExpense);
                relocationOrOtherExpense.setAmount(amount);
                relocationOrOtherExpense.setExpenseOtherSpecify(purpose);
                relocationOrOtherExpense.setCurrency(currency);
                relocationOrOtherExpense.setExpenseMaster(expenseMaster);
                relocationOrOtherExpenseService.create(relocationOrOtherExpense);
            }

        }
        if (expenseMaster.getExpenseType().equals("Relocation")) {

            expenseTravelType.setTravelApplicationNo("");

            int travelDetailCount = Integer.parseInt(request.getParameter("countFirstRelo"));
            int otherDetailCount = Integer.parseInt(request.getParameter("countSecondRelo"));
            for (int i = 1; i <= travelDetailCount; i++) {
                String fromCity = request.getParameter("fromCityRelo" + i);
                String toCity = request.getParameter("toCityRelo" + i);
                String date = request.getParameter("travelDateRelo" + i);
                String travelBy = request.getParameter("WorkTypeSelectRelo" + i);
                String amount = request.getParameter("amountRelo" + i);
                String currency = request.getParameter("currencyTravelDivRelo" + i);
                expenseTravelType.setFromCity(fromCity);
                expenseTravelType.setToCity(toCity);
                expenseTravelType.setDate(date);
                expenseTravelType.setTravelBy(travelBy);
                expenseTravelType.setAmount(amount);
                expenseTravelType.setCurrency(currency);
                expenseTravelType.setExpenseMaster(expenseMaster);
                expenseTravelTypeService.create(expenseTravelType);
            }
            for (int i = 1; i <= otherDetailCount; i++) {
                String reloOtherExpenseDate = request.getParameter("reloOtherExpenseDate" + i);
                String otherExpense = request.getParameter("RentAndFoodDivRelo" + i);
                String purposeRelo = request.getParameter("purposeRelo" + i);
                float amount = Float.parseFloat(request.getParameter("otherAmountRelo" + i));
                String currency = request.getParameter("currencyRelocationDivRelo" + i);
                relocationOrOtherExpense.setOtherExpenseDate(reloOtherExpenseDate);
                relocationOrOtherExpense.setOtherExpense(otherExpense);
                relocationOrOtherExpense.setExpenseOtherSpecify(purposeRelo);
                relocationOrOtherExpense.setAmount(amount);
                relocationOrOtherExpense.setCurrency(currency);
                relocationOrOtherExpense.setExpenseMaster(expenseMaster);
                relocationOrOtherExpenseService.create(relocationOrOtherExpense);
            }

        }
        if (expenseMaster.getExpenseType().equals("PolicyReimbursements")) {

            String policyNo = request.getParameter("policyNo");

            int otherDetailCount = Integer.parseInt(request.getParameter("countSecondOther"));
            for (int i = 1; i <= otherDetailCount; i++) {
                String otherExpenseDate = request.getParameter("otherExpenseDate" + i);
                String otherExpense = request.getParameter("RentAndFoodDivPolicy" + i);
                float amount = Float.parseFloat(request.getParameter("otherAmountPolicy" + i));
                String currency = request.getParameter("currencyRelocationDivPolicy" + i);
                String purposePolicy = request.getParameter("purposePolicy" + i);
                relocationOrOtherExpense.setOtherExpense(otherExpense);
                relocationOrOtherExpense.setOtherExpenseDate(otherExpenseDate);
                relocationOrOtherExpense.setExpenseOtherSpecify(purposePolicy);
                relocationOrOtherExpense.setAmount(amount);
                relocationOrOtherExpense.setCurrency(currency);
                relocationOrOtherExpense.setExpenseMaster(expenseMaster);
                relocationOrOtherExpense.setPolicyNo(policyNo);
                relocationOrOtherExpenseService.create(relocationOrOtherExpense);
            }
        }
        if (expenseMaster.getExpenseType().equals("Others")) {
            int othersCount = Integer.parseInt(request.getParameter("othersCount"));
            String specify = request.getParameter("Specify");
            for (int i = 1; i <= othersCount; i++) {

                String date = request.getParameter("billDate" + i);
                String billNo = request.getParameter("billNo" + i);
                float amount = Float.parseFloat(request.getParameter("policyAmount" + i));
                String currency = request.getParameter("otherCurrency" + i);
                expenseOtherType.setBillDate(date);
                expenseOtherType.setBilNo(billNo);
                expenseOtherType.setAmount(amount);
                expenseOtherType.setSpecify(specify);
                expenseOtherType.setCurrency(currency);
                expenseOtherType.setExpenseMaster(expenseMaster);
                expenseOtherTypeService.create(expenseOtherType);

            }

        }

        //By Ajay
        expenseReconsilation.setExpenseMaster(expenseMaster);
        readcurrencyList(request);
        Map<Integer, String> aaaa = (HashMap<Integer, String>) request.getAttribute("currencyMap");
        for (Map.Entry<Integer, String> entrySet : aaaa.entrySet()) {
            Integer key = entrySet.getKey();
            String value = entrySet.getValue();
            if (request.getParameter("totalAmount_" + key) != null && !request.getParameter("totalAmount_" + key).equals("0")) {

                float amount = Float.parseFloat(request.getParameter("totalAmount_" + key));
                float paidByCompany = Float.parseFloat(request.getParameter("paidByCompany" + key));
                float advanceCash = Float.parseFloat(request.getParameter("advanceCash" + key));
                float cashReturned = Float.parseFloat(request.getParameter("cashReturned" + key));
                float variance = Float.parseFloat(request.getParameter("variance" + key));
                expenseReconsilation.setCurrencyType("" + key);
                expenseReconsilation.setExpenseInReport(amount);
                expenseReconsilation.setExpensePaid(paidByCompany);
                expenseReconsilation.setCashReturned(cashReturned);
                expenseReconsilation.setCashAdvance(advanceCash);
                expenseReconsilation.setVarianceOwed(variance);
                expenseReconsilationService.create(expenseReconsilation);

            }

        }
        //By Ajay

        mv.getModelMap().put("expenseMaster", expenseMaster);
//        mv.setViewName("ExpenseReport/Appraisal360FeedbackFormCreate");
        mv = createExpenseResult(request, response);
//        }
        return mv;
    }

    public ModelAndView createExpenseApproveList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        ExpenseMaster expenseMaster = new ExpenseMaster();
        UserMaster user = (UserMaster) request.getSession().getAttribute("user");
        employeeMaster.setUserMaster(user);

        List<?> travelTypeList = new ArrayList<Object>();
        List<?> relocationTypeList = new ArrayList<Object>();
        List<?> travelOtherTypeList = new ArrayList<Object>();
        List<?> relocationOtherTypeList = new ArrayList<Object>();
        List<?> policyOtherTypeList = new ArrayList<Object>();
        List<?> othersList = new ArrayList<Object>();

        List<?> empList = employeeMasterService.readByUserName(employeeMaster);
        if (!empList.isEmpty()) {
            employeeMaster = (EmployeeMaster) empList.get(0);
        }
        int id = employeeMaster.getId();

        Object object = request.getAttribute("flag");
        String flag = "";
        if (object != null) {
            flag = object.toString();
            List<?> reportingLevel = (List<?>) request.getAttribute("reportingLevel");
            List<List<?>> finalList = new LinkedList<List<?>>();
            if (reportingLevel != null) {

                ListIterator it = reportingLevel.listIterator();
              
                while (it.hasNext()) {
                    Object[] next = (Object[]) it.next();
                    String expenseId = "" + next[0];
                    String dateOfSubmit = "" + next[1];
                    String employeeId = "" + next[2];
                    String employeeName = "" + next[3];
                    String expenseType = "" + next[4];
                    String status = "" + next[5];
                    String empId = "" + next[6];
                    String approverName = "" + next[7];

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

                    List<String> l1 = new LinkedList<String>();

                    l1.add(expenseId);
                    l1.add(dateOfSubmit);
                    l1.add(employeeId);
                    l1.add(employeeName);
                    l1.add(expenseType);
                    l1.add(status);
                    l1.add(empId);
                    l1.add(approverName);
                    l1.add(flag3);
                    finalList.add(l1);
                }
            }
            request.setAttribute("reportingLevel", finalList);
        } else {

            List reportingLevel1List = expenseMasterService.readExpenseRequestByReportingLevel1(expenseMaster, "" + id);
            if (!reportingLevel1List.isEmpty()) {
                List<List<?>> finalList = new LinkedList<List<?>>();
                ListIterator it = reportingLevel1List.listIterator();
                while (it.hasNext()) {
                    Object[] next = (Object[]) it.next();
                    String expenseId = "" + next[0];
                    String dateOfSubmit = "" + next[1];
                    String employeeId = "" + next[2];
                    String employeeName = "" + next[3];
                    String expenseType = "" + next[4];
                    String status = "" + next[5];
                    String empId = "" + next[6];
                    String approverName = "" + next[7];

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

                    List<String> l1 = new LinkedList<String>();

                    l1.add(expenseId);
                    l1.add(dateOfSubmit);
                    l1.add(employeeId);
                    l1.add(employeeName);
                    l1.add(expenseType);
                    l1.add(status);
                    l1.add(empId);
                    l1.add(approverName);
                    l1.add(flag3);
                    finalList.add(l1);
                }
                request.setAttribute("reportingLevel", finalList);

            }
            List<?> reportingLevel2List = expenseMasterService.readExpenseRequestByReportingLevel2(expenseMaster, "" + id);
            if (!reportingLevel2List.isEmpty()) {
                List<List<?>> finalList = new LinkedList<List<?>>();
                ListIterator it = reportingLevel1List.listIterator();
                while (it.hasNext()) {
                    Object[] next = (Object[]) it.next();
                    String expenseId = "" + next[0];
                    String dateOfSubmit = "" + next[1];
                    String employeeId = "" + next[2];
                    String employeeName = "" + next[3];
                    String expenseType = "" + next[4];
                    String status = "" + next[5];
                    String empId = "" + next[6];
                    String approverName = "" + next[7];

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

                    List<String> l1 = new LinkedList<String>();

                    l1.add(expenseId);
                    l1.add(dateOfSubmit);
                    l1.add(employeeId);
                    l1.add(employeeName);
                    l1.add(expenseType);
                    l1.add(status);
                    l1.add(empId);
                    l1.add(approverName);
                    l1.add(flag3);
                    finalList.add(l1);
                }
                request.setAttribute("reportingLevel", finalList);

            }
            List<?> reportingLevel3List = expenseMasterService.readExpenseRequestByReportingLevel3(expenseMaster, "" + id);
            if (!reportingLevel3List.isEmpty()) {
                List<List<?>> finalList = new LinkedList<List<?>>();
                ListIterator it = reportingLevel1List.listIterator();
                while (it.hasNext()) {
                    Object[] next = (Object[]) it.next();
                    String expenseId = "" + next[0];
                    String dateOfSubmit = "" + next[1];
                    String employeeId = "" + next[2];
                    String employeeName = "" + next[3];
                    String expenseType = "" + next[4];
                    String status = "" + next[5];
                    String empId = "" + next[6];
                    String approverName = "" + next[7];

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

                    List<String> l1 = new LinkedList<String>();

                    l1.add(expenseId);
                    l1.add(dateOfSubmit);
                    l1.add(employeeId);
                    l1.add(employeeName);
                    l1.add(expenseType);
                    l1.add(status);
                    l1.add(empId);
                    l1.add(approverName);
                    l1.add(flag3);
                    finalList.add(l1);
                }
                request.setAttribute("reportingLevel", finalList);

            }
//            List<?> reportingLevel4List = expenseMasterService.readExpenseRequestByReportingLevel4(expenseMaster, "" + id);
//            if (!reportingLevel4List.isEmpty()) {
//                request.setAttribute("reportingLevel", reportingLevel4List);

//            }
        }
//        expenseMaster.setEmployeeMasterByEmployeeId(employeeMaster);
//        List<?> exitList = new ArrayList<Object>();
//        List<List<?>> finalList = new ArrayList<>();
//        List<?> list = expenseMasterService.readByApproverId(expenseMaster);
//        if (!list.isEmpty()) {
//            String dateOfSubmit = "";
//            for (Object o : list) {
//                Object[] o1 = (Object[]) o;
//                dateOfSubmit = "" + o1[0];
//                int tabId = Integer.parseInt("" + o1[1]);
//                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//                Date date = sdf.parse(dateOfSubmit);
//                Date today = Calendar.getInstance().getTime();
//                Calendar c = Calendar.getInstance();
//                c.setTime(date); // Now use today date.
//                c.add(Calendar.DATE, 15);
//                Date output = c.getTime();
//
//                if (output.after(today)) {
//                    System.out.println("Date1 is after Date2");
//                    exitList = expenseMasterService.readByApprover1List(id, tabId);
//                }
//
//                if (output.before(today)) {
//                    System.out.println("Date1 is before Date2");
//                    exitList = expenseMasterService.readByApprover2List(id, tabId);
//                }
//
//                if (output.equals(today)) {
//                    System.out.println("Date1 is equal Date2");
//                    exitList = expenseMasterService.readByApprover1List(id, tabId);
//                }
//                if (!exitList.isEmpty()) {
//                    finalList.add(exitList);
//                }
//            }
//        }
//        request.setAttribute("finalList", finalList);
        selectEmployee(request, response);
        mv.getModelMap().put("expenseMaster", expenseMaster);
        mv.getModelMap().put("employeeMaster", employeeMaster1);
        mv.setViewName("ExpenseReport/ExpenseReportApproveList");

        return mv;
    }

    public ModelAndView viewClickApprove(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ExpenseMaster expenseMaster = new ExpenseMaster();
        ExpenseMaster expenseMaster1 = new ExpenseMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        DesignationMaster designationMaster;
        LevelMaster levelMaster;
        DepartmentMaster departmentMaster;
        LocationMaster locationMaster;

        List<?> travelTypeList = new ArrayList<Object>();
        List<?> relocationTypeList = new ArrayList<Object>();
        List<?> travelOtherTypeList = new ArrayList<Object>();
        List<?> relocationOtherTypeList = new ArrayList<Object>();
        List<?> policyOtherTypeList = new ArrayList<Object>();
        List<?> othersList = new ArrayList<Object>();
        int empId = Integer.parseInt(request.getParameter("empId"));
        UserMaster user = (UserMaster) request.getSession().getAttribute("user");
        employeeMaster.setUserMaster(user);
        employeeMaster = employeeMasterService.readById(empId);
        int levelId = employeeMaster.getLevelMaster().getId();
        int deptId = employeeMaster.getDepartmentMaster().getId();
        int desigId = employeeMaster.getDesignationMaster().getId();
        if (!employeeMaster.getReportingManagerLevel1().equals("")) {
//            employeeMaster.setReportingManagerLevel1("1");
            int managerId = Integer.parseInt(employeeMaster.getReportingManagerLevel1());
            employeeMaster1 = employeeMasterService.readById(managerId);
            employeeMaster.setChild1(employeeMaster1.getEmployeeName());
        }
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
        int expenseId = Integer.parseInt(request.getParameter("id"));
        expenseMaster1 = expenseMasterService.readById(expenseId);
        boolean flag1 = true;
        if (expenseMaster1.getExpenseType().equals("Travel")) {
            travelTypeList = expenseTravelTypeService.readByExpenseMasterId(expenseId);
            travelOtherTypeList = relocationOrOtherExpenseService.readByExpenseMasterId(expenseId);
            for (Object obj : travelTypeList) {
                ExpenseTravelType expenseTravelType = (ExpenseTravelType) obj;

                TravelRequestMaster travelRequestMaster = travelRequestMasterService.readById(Integer.parseInt(expenseTravelType.getTravelApplicationNo()));
                request.setAttribute("travelRequestNo", travelRequestMaster.getTravelRequestNo());
            }

            for (Object o : travelTypeList) {
                ExpenseTravelType expenseTravelType = (ExpenseTravelType) o;
                if (expenseTravelType.getStatus() != 1) {
                    flag1 = false;
                }

            }
            for (Object o2 : travelOtherTypeList) {
                RelocationOrOtherExpense relocationOrOtherExpense = (RelocationOrOtherExpense) o2;
                if (relocationOrOtherExpense.getStatus() != 1) {
                    flag1 = false;
                }

            }
        }
        if (expenseMaster1.getExpenseType().equals("Relocation")) {
            relocationTypeList = expenseTravelTypeService.readByExpenseMasterId(expenseId);
            for (Object o3 : relocationTypeList) {
                ExpenseTravelType expenseTravelType = (ExpenseTravelType) o3;
                if (expenseTravelType.getStatus() != 1) {
                    flag1 = false;
                }
            }
            relocationOtherTypeList = relocationOrOtherExpenseService.readByExpenseMasterId(expenseId);
            for (Object o4 : relocationOtherTypeList) {
                RelocationOrOtherExpense relocationOrOtherExpense = (RelocationOrOtherExpense) o4;
                if (relocationOrOtherExpense.getStatus() != 1) {
                    flag1 = false;
                }

            }
        }
        if (expenseMaster1.getExpenseType().equals("PolicyReimbursements")) {
            policyOtherTypeList = relocationOrOtherExpenseService.readByExpenseMasterId(expenseId);
            for (Object policyReimb : policyOtherTypeList) {
                RelocationOrOtherExpense relocationOrOtherExpense = (RelocationOrOtherExpense) policyReimb;
                if (relocationOrOtherExpense.getStatus() != 1) {
                    flag1 = false;
                }
            }
        }
        if (expenseMaster1.getExpenseType().equals("Others")) {
            othersList = expenseOtherTypeService.readByExpenseMasterId(expenseId);
            for (Object o1 : othersList) {
                ExpenseOtherType expenseOtherType = (ExpenseOtherType) o1;
                System.out.println("ajay" + expenseOtherType.getStatus());
                if (expenseOtherType.getStatus() != 1) {
                    flag1 = false;
                }
            }
        }
        List<?> expenseReconsilationList = expenseReconsilationService.readExpenseReconsilationFoApprover(expenseId);
        request.setAttribute("expenseReconsilationList", expenseReconsilationList);

        request.setAttribute("flag1", flag1);
        request.setAttribute("travelTypeList", travelTypeList);
        request.setAttribute("travelOtherTypeList", travelOtherTypeList);
        request.setAttribute("relocationTypeList", relocationTypeList);
        request.setAttribute("relocationOtherTypeList", relocationOtherTypeList);
        request.setAttribute("policyOtherTypeList", policyOtherTypeList);
        request.setAttribute("othersList", othersList);
        request.setAttribute("employeeMaster", employeeMaster);
        request.setAttribute("previousExpense", expenseMaster1.getExpenseType());
        mv.getModelMap().put("expenseMaster", expenseMaster1);
        mv.setViewName("ExpenseReport/ExpenseReportAdminApprove");

        return mv;
    }

    public ModelAndView approveSubmitExpenseReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        ExpenseMaster expenseMaster = new ExpenseMaster();
        ExpenseTravelType expenseTravelType = new ExpenseTravelType();
        ExpenseOtherType expenseOtherType = new ExpenseOtherType();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        EmployeeMaster employeeMaster2 = new EmployeeMaster();
        ExpenseReconsilation expenseReconsilation = new ExpenseReconsilation();
        RelocationOrOtherExpense relocationOrOtherExpense = new RelocationOrOtherExpense();
//        String previousExpense = request.getParameter("previousExpense");
        bind(request, expenseMaster);
        String btnType = request.getParameter("btnType");
        String empreqid = request.getParameter("empreqid");
        String previousExpense = request.getParameter("previousExpense");
        UserMaster user = (UserMaster) request.getSession().getAttribute("user");
        employeeMaster1.setUserMaster(user);
        List<?> reportingManagerList = employeeMasterService.readByUserName(employeeMaster1);
        if (!reportingManagerList.isEmpty()) {
            employeeMaster1 = (EmployeeMaster) reportingManagerList.get(0);
        }
//        int approver1 = Integer.parseInt(request.getParameter("ApproverId1"));
//        int approver2;
//        if (request.getParameter("ApproverId2").equals("")) {
//            approver2 = 1;
//        } else {
//            approver2 = Integer.parseInt(request.getParameter("ApproverId2"));
//        }
        int empId = Integer.parseInt(request.getParameter("empId"));
        employeeMaster.setId(empId);
//        employeeMaster1.setId(approver1);
//        employeeMaster2.setId(approver2);
        expenseMaster.setEmployeeMasterByApprover1Id(employeeMaster1);//Reporting Manager
//        expenseMaster.setEmployeeMasterByApprover2Id(employeeMaster2);
        expenseMaster.setEmployeeMasterByEmployeeId(employeeMaster);
        expenseMaster.setExpenseType(previousExpense);
//        expenseMasterService.create(expenseMaster);
        if (btnType.equals("Approve")) {

            if (expenseMaster.getExpenseType().equals("Travel")) {
                String travelTypeId[] = request.getParameterValues("otherListCheck");
                String travelOtherId[] = request.getParameterValues("otherListCheck1");
                try {
                    if (travelTypeId != null) {

                        for (String z : travelTypeId) {
                            expenseTravelType = expenseTravelTypeService.readById(Integer.parseInt(z));
                            expenseTravelType.setStatus(1);
                            expenseTravelTypeService.update(expenseTravelType);
                        }
                    }
                    if (travelOtherId != null) {
                        for (String z1 : travelOtherId) {
                            relocationOrOtherExpense = relocationOrOtherExpenseService.readById(Integer.parseInt(z1));
                            relocationOrOtherExpense.setStatus(1);
                            relocationOrOtherExpenseService.update(relocationOrOtherExpense);
                        }
                    }
                } catch (Exception e) {
                }
            }
        }
        if (expenseMaster.getExpenseType().equals("Relocation")) {

            String reloTypeId[] = request.getParameterValues("otherListCheck");
            String reloOtherId[] = request.getParameterValues("otherListCheck1");
            try {
                if (reloTypeId != null) {
                    for (String z : reloTypeId) {
                        expenseTravelType = expenseTravelTypeService.readById(Integer.parseInt(z));
                        expenseTravelType.setStatus(1);
                        expenseTravelTypeService.update(expenseTravelType);
                    }
                }
                if (reloOtherId != null) {
                    for (String z1 : reloOtherId) {
                        relocationOrOtherExpense = relocationOrOtherExpenseService.readById(Integer.parseInt(z1));
                        relocationOrOtherExpense.setStatus(1);
                        relocationOrOtherExpenseService.update(relocationOrOtherExpense);
                    }
                }
            } catch (Exception e) {
            }
        }

        if (expenseMaster.getExpenseType().equals("PolicyReimbursements")) {

            String policyId[] = request.getParameterValues("otherListCheck");
            try {
                if (policyId != null) {
                    for (String z : policyId) {
                        relocationOrOtherExpense = relocationOrOtherExpenseService.readById(Integer.parseInt(z));
                        relocationOrOtherExpense.setStatus(1);
                        relocationOrOtherExpenseService.update(relocationOrOtherExpense);
                    }
                }
            } catch (Exception e) {
            }
        }

        if (expenseMaster.getExpenseType()
                .equals("Others")) {
            String otherId[] = request.getParameterValues("otherListCheck");
            try {
                if (otherId != null) {
                    for (String z : otherId) {
                        expenseOtherType = expenseOtherTypeService.readById(Integer.parseInt(z));
                        expenseOtherType.setStatus(1);
                        expenseOtherTypeService.update(expenseOtherType);
                    }
                }
            } catch (Exception e) {

            }
        }
//        status = 2 for approve
        expenseMaster.setStatus(2);
        expenseMasterService.update(expenseMaster);

        request.setAttribute("successMessage",
                "Information : The Request is Approved successfully.");

        try {
            EmailTemplate emailTemplate = new EmailTemplate();
            EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
            DesignationMaster designationMaster = new DesignationMaster();
            designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
            // id=20 for Send to expense Admin...
            List expenseAdminList = userRightMasterService.readExpenseAdmin();
            Iterator itr = expenseAdminList.iterator();
            while (itr.hasNext()) {
                Object[] next = (Object[]) itr.next();
                String userId = "" + next[0];
                String expenseId = "" + next[1];
                EmployeeMaster employeeMasterHr = new EmployeeMaster();
                employeeMasterHr = employeeMasterService.readById(Integer.parseInt(expenseId));

                employeeMaster = employeeMasterService.readById(empId);
                emailTemplate = emailTemplateService.readById(20);
                String To = employeeMasterHr.getOfficeEmailId();
                String from = employeeMasterModel.getOfficeEmailId();
                String Subject = emailTemplate.getSubject();
                Subject = Subject.replaceAll("\\{user\\}", employeeMaster.getEmployeeName());
                String msg = emailTemplate.getBodytext();
                msg = msg.replaceAll("\\{to_user\\}", employeeMasterHr.getEmployeeName());
                msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                sendMail.sendMail(from, To, Subject, msg);
            }
        } catch (Exception e) {
        }
        try {
            EmailTemplate emailTemplate = new EmailTemplate();
            EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
            DesignationMaster designationMaster = new DesignationMaster();
            designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
            EmployeeMaster employeeMasterHr = new EmployeeMaster();
            employeeMasterHr = employeeMasterService.readById(Integer.parseInt(employeeMasterModel.getReportingManagerLevel1()));
            // id=55 for Expense Approve to employee...
            employeeMaster = employeeMasterService.readById(empId);
            emailTemplate = emailTemplateService.readById(55);
            String To = employeeMaster.getOfficeEmailId();
            String from = employeeMasterModel.getOfficeEmailId();
            String Subject = emailTemplate.getSubject();
            Subject = Subject.replaceAll("\\{user\\}", employeeMaster.getEmployeeName());
            String msg = emailTemplate.getBodytext();
            msg = msg.replaceAll("\\{to_user\\}", employeeMaster.getEmployeeName());
            msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
            msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
            sendMail.sendMail(from, To, Subject, msg);
        } catch (Exception e) {
        }

        if (btnType.equals("Return")) {

            expenseMaster.setStatus(1);
            expenseMasterService.update(expenseMaster);
            request.setAttribute("successMessage",
                    "Information : The Request is Returned successfully.");

            try {
                EmailTemplate emailTemplate = new EmailTemplate();
                EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                DesignationMaster designationMaster = new DesignationMaster();
                designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                EmployeeMaster employeeMasterHr = new EmployeeMaster();
                employeeMasterHr = employeeMasterService.readById(Integer.parseInt(employeeMasterModel.getReportingManagerLevel1()));
                // id=20 for Expense Rework...

                employeeMaster = employeeMasterService.readById(empId);

                emailTemplate = emailTemplateService.readById(21);
                String To = employeeMaster.getOfficeEmailId();
                String from = employeeMasterModel.getOfficeEmailId();
                String Subject = emailTemplate.getSubject();
                Subject = Subject.replaceAll("\\{user\\}", employeeMaster.getEmployeeName());
                String msg = emailTemplate.getBodytext();
                msg = msg.replaceAll("\\{to_user\\}", employeeMaster.getEmployeeName());
                msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
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
                EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                DesignationMaster designationMaster = new DesignationMaster();
                designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                EmployeeMaster employeeMasterHr = new EmployeeMaster();
                employeeMasterHr = employeeMasterService.readById(Integer.parseInt(employeeMasterModel.getReportingManagerLevel1()));

                // id=22 for Expense Reject...
                employeeMaster = employeeMasterService.readById(empId);

                emailTemplate = emailTemplateService.readById(22);
                String To = employeeMaster.getOfficeEmailId();
                String from = employeeMasterModel.getOfficeEmailId();
                String Subject = emailTemplate.getSubject();
                Subject = Subject.replaceAll("\\{user\\}", employeeMaster.getEmployeeName());
                String msg = emailTemplate.getBodytext();
                msg = msg.replaceAll("\\{to_user\\}", employeeMaster.getEmployeeName());
                msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                sendMail.sendMail(from, To, Subject, msg);
            } catch (Exception e) {
            }

        }
        mv = createExpenseApproveList(request, response);
        return mv;
    }

    public ModelAndView returnSubmitExpenseReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ExpenseMaster expenseMaster = new ExpenseMaster();
        ExpenseTravelType expenseTravelType = new ExpenseTravelType();
        ExpenseOtherType expenseOtherType = new ExpenseOtherType();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        EmployeeMaster employeeMaster2 = new EmployeeMaster();
        ExpenseReconsilation expenseReconsilation = new ExpenseReconsilation();
        RelocationOrOtherExpense relocationOrOtherExpense = new RelocationOrOtherExpense();
        String previousExpense = request.getParameter("previousExpense");
        bind(request, expenseMaster);
        int approver1 = Integer.parseInt(request.getParameter("ApproverId1"));
        int approver2;
        if (request.getParameter("ApproverId2").equals("")) {
            approver2 = 1;
        } else {
            approver2 = Integer.parseInt(request.getParameter("ApproverId2"));
        }
        int empId = Integer.parseInt(request.getParameter("empId"));
        employeeMaster.setId(empId);
        employeeMaster1.setId(approver1);
        employeeMaster2.setId(approver2);
        expenseMaster.setEmployeeMasterByApprover1Id(employeeMaster1);
        expenseMaster.setEmployeeMasterByApprover2Id(employeeMaster2);
        expenseMaster.setEmployeeMasterByEmployeeId(employeeMaster);
        expenseMaster.setExpenseType(previousExpense);
        expenseMaster.setTravelStartDate(request.getParameter("travelStartDate"));
        expenseMaster.setTravelEndDate(request.getParameter("travelEndDate"));
        if (expenseMaster.getExpenseType().equals("Travel")) {

            expenseTravelType.setTravelApplicationNo(request.getParameter("travelNo"));
            if (expenseTravelType.getTravelApplicationNo() == null) {
                expenseTravelType.setTravelApplicationNo("");
            }

            int travelDetailCount = Integer.parseInt(request.getParameter("countFirst"));
            int otherDetailCount = Integer.parseInt(request.getParameter("countSecond"));
            for (int i = 1; i <= travelDetailCount; i++) {
                try {

                    String travelTypeStatus = request.getParameter("travelTypeStatus" + i);
                    if (travelTypeStatus == null || !travelTypeStatus.equals("1")) {
                        String fromCity = request.getParameter("fromCity" + i);
                        String toCity = request.getParameter("toCity" + i);
                        String date = request.getParameter("travelDate" + i);
                        String travelBy = request.getParameter("WorkTypeSelect" + i);
                        String amount = request.getParameter("amount" + i);
                        String currency = request.getParameter("currencyTravelDiv" + i);
                        String travelTypeId = request.getParameter("travelTypeId" + i);
                        if (travelTypeId != null) {
                            expenseTravelType.setId(Integer.parseInt(travelTypeId));
                            expenseTravelType.setFromCity(fromCity);
                            expenseTravelType.setToCity(toCity);
                            expenseTravelType.setDate(date);
                            expenseTravelType.setTravelBy(travelBy);
                            expenseTravelType.setAmount(amount);
                            expenseTravelType.setCurrency(currency);
                            expenseTravelType.setExpenseMaster(expenseMaster);
                            expenseTravelTypeService.update(expenseTravelType);
                        } else {
                            ExpenseTravelType expenseTravelType1 = new ExpenseTravelType();
                            expenseTravelType1.setFromCity(fromCity);
                            expenseTravelType1.setToCity(toCity);
                            expenseTravelType1.setDate(date);
                            expenseTravelType1.setTravelBy(travelBy);
                            expenseTravelType1.setAmount(amount);
                            expenseTravelType1.setCurrency(currency);
                            expenseTravelType1.setExpenseMaster(expenseMaster);
                            expenseTravelType1.setTravelApplicationNo(request.getParameter("travelNo"));
                            expenseTravelTypeService.create(expenseTravelType1);
                        }
                    }
                } catch (Exception e) {

                }
            }
            for (int i = 1; i <= otherDetailCount; i++) {
                try {
                    String travelOtherStatus = request.getParameter("travelOtherStatus" + i);
                    if (travelOtherStatus == null || !travelOtherStatus.equals("1")) {
                        String travelotherExpenseDate = request.getParameter("travelotherExpenseDate" + i);
                        String otherExpense = request.getParameter("RentAndFoodDiv" + i);
                        String purpose = request.getParameter("purpose" + i);
                        float amount = Float.parseFloat(request.getParameter("otherAmount" + i));
                        String currency = request.getParameter("currencyRelocationDiv" + i);
                        String travelOtherId = request.getParameter("travelOtherId" + i);
                        if (travelOtherId != null) {
                            relocationOrOtherExpense.setId(Integer.parseInt(travelOtherId));
                            relocationOrOtherExpense.setOtherExpenseDate(travelotherExpenseDate);
                            relocationOrOtherExpense.setOtherExpense(otherExpense);
                            relocationOrOtherExpense.setExpenseOtherSpecify(purpose);
                            relocationOrOtherExpense.setAmount(amount);
                            relocationOrOtherExpense.setCurrency(currency);
                            relocationOrOtherExpense.setExpenseMaster(expenseMaster);
                            relocationOrOtherExpenseService.update(relocationOrOtherExpense);
                        } else {
                            RelocationOrOtherExpense relocationOrOtherExpense1 = new RelocationOrOtherExpense();
                            relocationOrOtherExpense1.setOtherExpenseDate(travelotherExpenseDate);
                            relocationOrOtherExpense1.setOtherExpense(otherExpense);
                            relocationOrOtherExpense1.setExpenseOtherSpecify(purpose);
                            relocationOrOtherExpense1.setAmount(amount);
                            relocationOrOtherExpense1.setCurrency(currency);
                            relocationOrOtherExpense1.setExpenseMaster(expenseMaster);
                            relocationOrOtherExpenseService.create(relocationOrOtherExpense1);
                        }
                    }
                } catch (Exception e) {

                }
            }

        }
        if (expenseMaster.getExpenseType().equals("Relocation")) {

            expenseTravelType.setTravelApplicationNo("");

            int travelDetailCount = Integer.parseInt(request.getParameter("countFirstRelo"));
            int otherDetailCount = Integer.parseInt(request.getParameter("countSecondRelo"));
            for (int i = 1; i <= travelDetailCount; i++) {
                try {

                    String reloTypeStatus = request.getParameter("reloTypeStatus" + i);
                    if (reloTypeStatus == null || !reloTypeStatus.equals("1")) {
                        String fromCity = request.getParameter("fromCityRelo" + i);
                        String toCity = request.getParameter("toCityRelo" + i);
                        String date = request.getParameter("travelDateRelo" + i);
                        String travelBy = request.getParameter("WorkTypeSelectRelo" + i);
                        String amount = request.getParameter("amountRelo" + i);
                        String currency = request.getParameter("currencyTravelDivRelo" + i);
                        String reloTypeId = request.getParameter("reloTypeId" + i);
                        String travelAppNo = request.getParameter("travelNo");
                        if (reloTypeId != null) {
                            expenseTravelType.setId(Integer.parseInt(reloTypeId));
                            expenseTravelType.setFromCity(fromCity);
                            expenseTravelType.setToCity(toCity);
                            expenseTravelType.setDate(date);
                            expenseTravelType.setTravelBy(travelBy);
                            expenseTravelType.setAmount(amount);
                            expenseTravelType.setCurrency(currency);
                            expenseTravelType.setExpenseMaster(expenseMaster);
                            expenseTravelTypeService.update(expenseTravelType);
                        } else {
                            ExpenseTravelType expenseTravelType1 = new ExpenseTravelType();
                            expenseTravelType1.setFromCity(fromCity);
                            expenseTravelType1.setToCity(toCity);
                            expenseTravelType1.setDate(date);
                            expenseTravelType1.setTravelBy(travelBy);
                            expenseTravelType1.setAmount(amount);
                            expenseTravelType1.setCurrency(currency);
                            expenseTravelType1.setExpenseMaster(expenseMaster);
                            if (travelAppNo.equals("")) {
                                expenseTravelType1.setTravelApplicationNo("default");
                            }
                            expenseTravelTypeService.create(expenseTravelType1);
                        }
                    }
                } catch (Exception e) {

                }
            }
            for (int i = 1; i <= otherDetailCount; i++) {
                try {
                    String reloOtherStatus = request.getParameter("reloOtherStatus" + i);
                    if (reloOtherStatus == null || !reloOtherStatus.equals("1")) {
                        String reloOtherExpenseDate = request.getParameter("reloOtherExpenseDate" + i);
                        String otherExpense = request.getParameter("RentAndFoodDivRelo" + i);
                        String purposeRelo = request.getParameter("purposeRelo" + i);
                        float amount = Float.parseFloat(request.getParameter("otherAmountRelo" + i));
                        String currency = request.getParameter("currencyRelocationDivRelo" + i);
                        String reloOtherId = request.getParameter("reloOtherId" + i);
                        if (reloOtherId != null) {
                            relocationOrOtherExpense.setId(Integer.parseInt(reloOtherId));
                            relocationOrOtherExpense.setOtherExpenseDate(reloOtherExpenseDate);
                            relocationOrOtherExpense.setOtherExpense(otherExpense);
                            relocationOrOtherExpense.setExpenseOtherSpecify(purposeRelo);
                            relocationOrOtherExpense.setAmount(amount);
                            relocationOrOtherExpense.setCurrency(currency);
                            relocationOrOtherExpense.setExpenseMaster(expenseMaster);
                            relocationOrOtherExpenseService.update(relocationOrOtherExpense);
                        } else {
                            RelocationOrOtherExpense relocationOrOtherExpense1 = new RelocationOrOtherExpense();
                            relocationOrOtherExpense1.setOtherExpenseDate(reloOtherExpenseDate);
                            relocationOrOtherExpense1.setOtherExpense(otherExpense);
                            relocationOrOtherExpense1.setExpenseOtherSpecify(purposeRelo);
                            relocationOrOtherExpense1.setAmount(amount);
                            relocationOrOtherExpense1.setCurrency(currency);
                            relocationOrOtherExpense1.setExpenseMaster(expenseMaster);
                            relocationOrOtherExpenseService.create(relocationOrOtherExpense1);
                        }
                    }
                } catch (Exception e) {

                }

            }

        }
        if (expenseMaster.getExpenseType().equals("PolicyReimbursements")) {

            String policyNo = request.getParameter("policyNo");

            int otherDetailCount = Integer.parseInt(request.getParameter("countSecondOther"));
            for (int i = 1; i <= otherDetailCount; i++) {
                try {

                    String policyStatus = request.getParameter("policyOtherStatus" + i);
                    if (policyStatus == null || !policyStatus.equals("1")) {
                        String otherExpenseDate = request.getParameter("otherExpenseDate" + i);
                        String otherExpense = request.getParameter("RentAndFoodDivPolicy" + i);
                        String purposePolicy = request.getParameter("purposePolicy" + i);
                        float amount = Float.parseFloat(request.getParameter("otherAmountPolicy" + i));
                        String currency = request.getParameter("currencyRelocationDivPolicy" + i);
                        String policyId = request.getParameter("policyOtherId" + i);
                        if (policyId != null) {
                            relocationOrOtherExpense.setId(Integer.parseInt(policyId));
                            relocationOrOtherExpense.setOtherExpenseDate(otherExpenseDate);
                            relocationOrOtherExpense.setOtherExpense(otherExpense);
                            relocationOrOtherExpense.setExpenseOtherSpecify(purposePolicy);
                            relocationOrOtherExpense.setAmount(amount);
                            relocationOrOtherExpense.setCurrency(currency);
                            relocationOrOtherExpense.setExpenseMaster(expenseMaster);
                            relocationOrOtherExpense.setPolicyNo(policyNo);
                            relocationOrOtherExpenseService.update(relocationOrOtherExpense);
                        } else {
                            RelocationOrOtherExpense relocationOrOtherExpense1 = new RelocationOrOtherExpense();
                            relocationOrOtherExpense1.setOtherExpenseDate(otherExpenseDate);
                            relocationOrOtherExpense1.setOtherExpense(otherExpense);
                            relocationOrOtherExpense1.setExpenseOtherSpecify(purposePolicy);
                            relocationOrOtherExpense1.setAmount(amount);
                            relocationOrOtherExpense1.setCurrency(currency);
                            relocationOrOtherExpense1.setExpenseMaster(expenseMaster);
                            relocationOrOtherExpense1.setPolicyNo(policyNo);
                            relocationOrOtherExpenseService.create(relocationOrOtherExpense1);
                        }
                    }
                } catch (Exception e) {

                }
            }
        }
        if (expenseMaster.getExpenseType().equals("Others")) {
            int othersCount = Integer.parseInt(request.getParameter("othersCount"));
            String specify = request.getParameter("Specify");
            for (int i = 1; i <= othersCount; i++) {
                try {
                    String status = request.getParameter("otherListStatus" + i);
                    if (status == null || !status.equals("1")) {
                        String date = request.getParameter("billDate" + i);
                        String billNo = request.getParameter("billNo" + i);
                        float amount = Float.parseFloat(request.getParameter("policyAmount" + i));
                        String currency = request.getParameter("otherCurrency" + i);
                        String othersId = request.getParameter("otherListId" + i);
                        if (othersId != null) {
                            expenseOtherType.setId(Integer.parseInt(othersId));
                            expenseOtherType.setBillDate(date);
                            expenseOtherType.setBilNo(billNo);
                            expenseOtherType.setAmount(amount);
                            expenseOtherType.setSpecify(specify);
                            expenseOtherType.setCurrency(currency);
                            expenseOtherType.setExpenseMaster(expenseMaster);
                            expenseOtherTypeService.update(expenseOtherType);
                        } else {
                            ExpenseOtherType expenseOtherType1 = new ExpenseOtherType();
                            expenseOtherType1.setBillDate(date);
                            expenseOtherType1.setBilNo(billNo);
                            expenseOtherType1.setAmount(amount);
                            expenseOtherType1.setSpecify(specify);
                            expenseOtherType1.setCurrency(currency);
                            expenseOtherType1.setExpenseMaster(expenseMaster);
                            expenseOtherTypeService.create(expenseOtherType1);
                        }
                    }
                } catch (Exception e) {

                }
            }
        }

        expenseMasterService.update(expenseMaster);
        try {
            EmailTemplate emailTemplate = new EmailTemplate();
            EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
            DesignationMaster designationMaster = new DesignationMaster();
            designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
            EmployeeMaster employeeMasterHr = new EmployeeMaster();
            employeeMasterHr = employeeMasterService.readById(Integer.parseInt(employeeMasterModel.getReportingManagerLevel1()));
            // id=123 for Expense Apply edit click...
            emailTemplate = emailTemplateService.readById(123);
            String To = employeeMasterHr.getOfficeEmailId();
            String from = employeeMasterModel.getOfficeEmailId();
            String Subject = emailTemplate.getSubject();
            Subject = Subject.replaceAll("\\{user\\}", employeeMasterModel.getEmployeeName());
            String msg = emailTemplate.getBodytext();
            msg = msg.replaceAll("\\{to_user\\}", employeeMasterHr.getEmployeeName());
            msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
            msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
            sendMail.sendMail(from, To, Subject, msg);
        } catch (Exception e) {
        }

        //By Ajay
        expenseReconsilation.setExpenseMaster(expenseMaster);
        readcurrencyList(request);
        Map<Integer, String> aaaa = (HashMap<Integer, String>) request.getAttribute("currencyMap");
        for (Map.Entry<Integer, String> entrySet : aaaa.entrySet()) {
            Integer key = entrySet.getKey();
            String value = entrySet.getValue();
            if (request.getParameter("totalAmount_" + key) != null && !request.getParameter("totalAmount_" + key).equals("0")) {

                String reconsilationId = request.getParameter("reconsilationId_" + key);
                float amount = Float.parseFloat(request.getParameter("totalAmount_" + key));
                float paidByCompany = Float.parseFloat(request.getParameter("paidByCompany" + key));
                float advanceCash = Float.parseFloat(request.getParameter("advanceCash" + key));
                float cashReturned = Float.parseFloat(request.getParameter("cashReturned" + key));
                float variance = Float.parseFloat(request.getParameter("variance" + key));
                expenseReconsilation.setCurrencyType("" + key);
                expenseReconsilation.setExpenseInReport(amount);
                expenseReconsilation.setExpensePaid(paidByCompany);
                expenseReconsilation.setCashReturned(cashReturned);
                expenseReconsilation.setCashAdvance(advanceCash);
                expenseReconsilation.setVarianceOwed(variance);
                if (reconsilationId == null) {
                    expenseReconsilationService.create(expenseReconsilation);
                } else {
                    expenseReconsilation.setId(Integer.parseInt(reconsilationId));
                    expenseReconsilationService.update(expenseReconsilation);

                }

            }

        }
        //By Ajay

        mv = createExpenseResult(request, response);
        return mv;
    }

//this method is for display travelExpenseReport on HrDashboard.
    public ModelAndView hrDashboard(HttpServletRequest request, HttpServletResponse response, DepartmentMaster departmentMaster) throws Exception {
        ModelAndView mv = new ModelAndView();
        Object[] expenseReport;
        String pending = "";
        String completed = "";
        TravelRequestMaster travelRequestMaster = new TravelRequestMaster();
        try {
            List<?> travelExpenseReportList = expenseMasterService.readTravelExpenseReportList();
            List<?> list = travelRequestMasterService.readExpensePendingList(travelRequestMaster);
            if (!travelExpenseReportList.isEmpty()) {
                expenseReport = (Object[]) travelExpenseReportList.get(0);
                String expenseReport1 = "" + expenseReport[1];
                String expenseReport2 = "" + expenseReport[0];
                int totalExpenseRequest = Integer.parseInt(expenseReport1) + Integer.parseInt(expenseReport2);
                completed = expenseReport2;
                int travelRequest = list.size() - totalExpenseRequest;
                pending = "" + travelRequest;
            }
            if ("null".equals(pending) || "".equals(pending)) {
                pending = "0";
            }
            if ("null".equals(completed) || "".equals(completed)) {
                completed = "0";
            }
            String expenseReportString = "['Pending', "
                    + pending
                    + "],['Completed', "
                    + completed
                    + "]";
            mv.addObject("expenseReportString", expenseReportString);
        } catch (Exception e) {

        }
        mv.setViewName("forward:probationToConfirmation.htm?act=hrDashboard");
        return mv;
    }

    public ModelAndView userDashboardExpensePendingRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ExpenseMaster expenseMaster = new ExpenseMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        UserMaster user = (UserMaster) request.getSession().getAttribute("user");
        employeeMaster.setUserMaster(user);
        List<?> travelTypeList = new ArrayList<Object>();
        List<?> relocationTypeList = new ArrayList<Object>();
        List<?> travelOtherTypeList = new ArrayList<Object>();
        List<?> relocationOtherTypeList = new ArrayList<Object>();
        List<?> policyOtherTypeList = new ArrayList<Object>();
        List<?> othersList = new ArrayList<Object>();
        List<?> empList = employeeMasterService.readByUserName(employeeMaster);
        if (!empList.isEmpty()) {
            employeeMaster = (EmployeeMaster) empList.get(0);
        }
        int id = employeeMaster.getId();

        List<?> reportingLevel1List = expenseMasterService.readExpenseRequestByReportingLevel1(expenseMaster, "" + id);
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
            request.setAttribute("reportingLevel", reportingLevel1List.size());

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
                request.setAttribute("reportingLevel", reportingLevel2List.size());

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
                request.setAttribute("reportingLevel", reportingLevel3List.size());

            }
        }
//        List<?> reportingLevel4List = expenseMasterService.readExpenseRequestByReportingLevel4(expenseMaster, "" + id);
//        if (!reportingLevel4List.isEmpty()) {
//            request.setAttribute("reportingLevel", reportingLevel4List.size());
//        }

        EmployeeMaster employeeMaster1 = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        ExpenseMaster expenseMaster1 = new ExpenseMaster();
        expenseMaster1.setEmployeeMasterByEmployeeId(employeeMaster1);
        List<?> list = expenseMasterService.readByExpensePendingRequest(expenseMaster1);
        int expensePending = list.size();
        request.setAttribute("expensePending", expensePending);
        mv.setViewName("forward:noDueMaster.htm?act=userDashboard");
        return mv;
    }

    public ModelAndView viewExpense(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ExpenseMaster expenseMaster1 = new ExpenseMaster();
        ExpenseMaster expenseMaster = new ExpenseMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        DesignationMaster designationMaster;
        LevelMaster levelMaster;
        DepartmentMaster departmentMaster;
        LocationMaster locationMaster;
        readcurrencyList(request);

        List<?> travelTypeList = new ArrayList<Object>();
        List<?> relocationTypeList = new ArrayList<Object>();
        List<?> travelOtherTypeList = new ArrayList<Object>();
        List<?> relocationOtherTypeList = new ArrayList<Object>();
        List<?> policyOtherTypeList = new ArrayList<Object>();
        List<?> othersList = new ArrayList<Object>();

        String id = request.getParameter("id");

        UserMaster user = (UserMaster) request.getSession().getAttribute("user");
        employeeMaster.setUserMaster(user);
        List<?> empList = employeeMasterService.readByUserName(employeeMaster);
        if (!empList.isEmpty()) {
            employeeMaster = (EmployeeMaster) empList.get(0);
        }
        int levelId = employeeMaster.getLevelMaster().getId();
        int deptId = employeeMaster.getDepartmentMaster().getId();
        int desigId = employeeMaster.getDesignationMaster().getId();
        if (!employeeMaster.getReportingManagerLevel1().equals("")) {
//            employeeMaster.setReportingManagerLevel1("1");
            int managerId = Integer.parseInt(employeeMaster.getReportingManagerLevel1());
            employeeMaster1 = employeeMasterService.readById(managerId);
        }
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

        expenseMaster1.setEmployeeMasterByEmployeeId(employeeMaster);
//        int expenseId = expenseMaster.getId();
        expenseMaster1 = expenseMasterService.readById(Integer.parseInt(id));
        if (expenseMaster1.getExpenseType().equals("Travel")) {
            travelTypeList = expenseTravelTypeService.readByExpenseMasterId(Integer.parseInt(id));
            travelOtherTypeList = relocationOrOtherExpenseService.readByExpenseMasterId(Integer.parseInt(id));
        }
        if (expenseMaster1.getExpenseType().equals("Relocation")) {
            relocationTypeList = expenseTravelTypeService.readByExpenseMasterId(Integer.parseInt(id));
            relocationOtherTypeList = relocationOrOtherExpenseService.readByExpenseMasterId(Integer.parseInt(id));
        }
        if (expenseMaster1.getExpenseType().equals("PolicyReimbursements")) {
            policyOtherTypeList = relocationOrOtherExpenseService.readByExpenseMasterId(Integer.parseInt(id));
        }
        if (expenseMaster1.getExpenseType().equals("Others")) {
            othersList = expenseOtherTypeService.readByExpenseMasterId(Integer.parseInt(id));
        }

        ExpenseReconsilation expenseReconsilation = new ExpenseReconsilation();
        List<?> expenseReconsilationList = expenseReconsilationService.readExpenseReconsilationByExpenseID(Integer.parseInt(id));

        request.setAttribute("expenseReconsilationList", expenseReconsilationList);
        request.setAttribute("travelTypeList", travelTypeList);
        request.setAttribute("travelOtherTypeList", travelOtherTypeList);
        request.setAttribute("relocationTypeList", relocationTypeList);
        request.setAttribute("relocationOtherTypeList", relocationOtherTypeList);
        request.setAttribute("policyOtherTypeList", policyOtherTypeList);
        request.setAttribute("othersList", othersList);
        request.setAttribute("employeeMaster", employeeMaster);
        request.setAttribute("previousExpense", expenseMaster1.getExpenseType());
        mv.getModelMap().put("expenseMaster", expenseMaster1);
        mv.setViewName("ExpenseReport/ExpenseReportView");
        return mv;
    }
//By Ajay

    public ModelAndView viewExpenseAdminSide(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ExpenseMaster expenseMaster = new ExpenseMaster();
        ExpenseTravelType expenseTravelType = new ExpenseTravelType();
        RelocationOrOtherExpense relocationOrOtherExpense = new RelocationOrOtherExpense();
        ExpenseOtherType expenseOtherType = new ExpenseOtherType();
        EmployeeMaster employeeMaster = new EmployeeMaster();

        List<?> list = expenseMasterService.readExpenseReportListForAdmin();

        for (Iterator<? extends Object> iterator = list.iterator(); iterator.hasNext();) {
            expenseMaster = (ExpenseMaster) iterator.next();

            employeeMaster = employeeMasterService.readById(expenseMaster.getEmployeeMasterByEmployeeId().getId());
            expenseMaster.setEmployeeMasterByEmployeeId(employeeMaster);
            if (expenseMaster.getExpenseType().equals("Travel")) {
                List<?> travelTypeList = expenseTravelTypeService.readByExpenseMasterId(expenseMaster.getId());
                for (Object o1 : travelTypeList) {
                    expenseTravelType = (ExpenseTravelType) o1;
                    if (expenseTravelType.getStatus() == 0) {
                        if (!list.isEmpty()) {
                            try {
                                iterator.remove();
                            } catch (Exception e) {

                            }
                        }
                        break;
                    }
                }
                List<?> travelOtherTypeList = relocationOrOtherExpenseService.readByExpenseMasterId(expenseMaster.getId());
                for (Object o2 : travelOtherTypeList) {
                    relocationOrOtherExpense = (RelocationOrOtherExpense) o2;
                    if (relocationOrOtherExpense.getStatus() == 0) {
                        try {
                            iterator.remove();
                        } catch (Exception e) {

                        }
                        break;
                    }
                }
            }
            if (expenseMaster.getExpenseType().equals("Relocation")) {
                List<?> relocationTypeList = expenseTravelTypeService.readByExpenseMasterId(expenseMaster.getId());
                for (Object o3 : relocationTypeList) {
                    expenseTravelType = (ExpenseTravelType) o3;
                    if (expenseTravelType.getStatus() == 0) {
                        try {
                            iterator.remove();
                        } catch (Exception e) {

                        }
                        break;
                    }
                }
                List<?> relocationOtherTypeList = relocationOrOtherExpenseService.readByExpenseMasterId(expenseMaster.getId());
                for (Object o4 : relocationOtherTypeList) {
                    relocationOrOtherExpense = (RelocationOrOtherExpense) o4;
                    if (relocationOrOtherExpense.getStatus() == 0) {
                        try {
                            iterator.remove();
                        } catch (Exception e) {

                        }
                        break;
                    }
                }
            }
            if (expenseMaster.getExpenseType().equals("PolicyReimbursements")) {
                List<?> policyOtherTypeList = relocationOrOtherExpenseService.readByExpenseMasterId(expenseMaster.getId());
                for (Object o4 : policyOtherTypeList) {
                    relocationOrOtherExpense = (RelocationOrOtherExpense) o4;
                    if (relocationOrOtherExpense.getStatus() == 0) {
                        try {
                            iterator.remove();
                        } catch (Exception e) {

                        }
                        break;
                    }
                }
            }
            if (expenseMaster.getExpenseType().equals("Others")) {
                List<?> othersList = expenseOtherTypeService.readByExpenseMasterId(expenseMaster.getId());
                for (Object o5 : othersList) {
                    expenseOtherType = (ExpenseOtherType) o5;
                    if (expenseOtherType.getStatus() == 0) {
                        try {
                            iterator.remove();
                        } catch (Exception e) {

                        }
                        break;
                    }
                }
            }
        }
        request.setAttribute("list", list);
        mv.setViewName("ExpenseReport/ExpenseReportViewByAdmin");
        return mv;
    }

    public ModelAndView approveExpenseByAdminSide(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ExpenseMaster expenseMaster = new ExpenseMaster();
        ExpenseMaster expenseMaster1 = new ExpenseMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        DesignationMaster designationMaster;
        LevelMaster levelMaster;
        DepartmentMaster departmentMaster;

        List<?> travelTypeList = new ArrayList<Object>();
        List<?> relocationTypeList = new ArrayList<Object>();
        List<?> travelOtherTypeList = new ArrayList<Object>();
        List<?> relocationOtherTypeList = new ArrayList<Object>();
        List<?> policyOtherTypeList = new ArrayList<Object>();
        List<?> othersList = new ArrayList<Object>();
        int empId = Integer.parseInt(request.getParameter("empId"));
//        UserMaster user = (UserMaster) request.getSession().getAttribute("user");
//        employeeMaster.setUserMaster(user);
        UserMaster userMaster = new UserMaster();
        employeeMaster = employeeMasterService.readById(empId);

        userMaster = userMasterService.readById(employeeMaster.getUserMaster().getId());
        int levelId = employeeMaster.getLevelMaster().getId();
        int deptId = employeeMaster.getDepartmentMaster().getId();
        int desigId = employeeMaster.getDesignationMaster().getId();
        if (!employeeMaster.getReportingManagerLevel1().equals("")) {
//            employeeMaster.setReportingManagerLevel1("1");
            int managerId = Integer.parseInt(employeeMaster.getReportingManagerLevel1());
            employeeMaster1 = employeeMasterService.readById(managerId);
            employeeMaster.setChild1(employeeMaster1.getEmployeeName());
        }
        levelMaster = levelMasterService.readById(levelId);
        designationMaster = designationMasterService.readById(desigId);
        departmentMaster = departmentMasterService.readById(deptId);
        employeeMaster.setLevelMaster(levelMaster);
        employeeMaster.setDepartmentMaster(departmentMaster);
        employeeMaster.setDesignationMaster(designationMaster);

        LocationMaster locationMaster = new LocationMaster();
        locationMaster = locationMasterService.readById(employeeMaster.getLocationMaster().getId());
        employeeMaster.setLocationMaster(locationMaster);
        selectTravelNo(request, userMaster);
        policyList(request);
        readcurrencyList(request);
        expenseMaster1.setEmployeeMasterByEmployeeId(employeeMaster);
        int expenseId = Integer.parseInt(request.getParameter("id"));
        expenseMaster1 = expenseMasterService.readById(expenseId);
        if (expenseMaster1.getExpenseType().equals("Travel")) {
            travelTypeList = expenseTravelTypeService.readByExpenseMasterId(expenseId);
            travelOtherTypeList = relocationOrOtherExpenseService.readByExpenseMasterId(expenseId);
        }
        if (expenseMaster1.getExpenseType().equals("Relocation")) {
            relocationTypeList = expenseTravelTypeService.readByExpenseMasterId(expenseId);
            relocationOtherTypeList = relocationOrOtherExpenseService.readByExpenseMasterId(expenseId);
        }
        if (expenseMaster1.getExpenseType().equals("PolicyReimbursements")) {
            policyOtherTypeList = relocationOrOtherExpenseService.readByExpenseMasterId(expenseId);
        }
        if (expenseMaster1.getExpenseType().equals("Others")) {
            othersList = expenseOtherTypeService.readByExpenseMasterId(expenseId);
        }
        List<?> expenseReconsilationList = expenseReconsilationService.readExpenseReconsilationFoApprover(expenseId);
        request.setAttribute("expenseReconsilationList", expenseReconsilationList);

        request.setAttribute("travelTypeList", travelTypeList);
        request.setAttribute("travelOtherTypeList", travelOtherTypeList);
        request.setAttribute("relocationTypeList", relocationTypeList);
        request.setAttribute("relocationOtherTypeList", relocationOtherTypeList);
        request.setAttribute("policyOtherTypeList", policyOtherTypeList);
        request.setAttribute("othersList", othersList);
        request.setAttribute("employeeMaster", employeeMaster);
        request.setAttribute("previousExpense", expenseMaster1.getExpenseType());
        mv.getModelMap().put("expenseMaster", expenseMaster1);
        mv.setViewName("ExpenseReport/ExpenseViewByAdminForApprove");

        return mv;
    }

    public ModelAndView finalApproveExpenseByAdmin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ExpenseMaster expenseMaster = new ExpenseMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        expenseMaster = expenseMasterService.readById(Integer.parseInt(request.getParameter("id")));
        UserMaster user = (UserMaster) request.getSession().getAttribute("user");
        employeeMaster.setUserMaster(user);
        List<?> empList = employeeMasterService.readByUserName(employeeMaster);
        if (!empList.isEmpty()) {
            employeeMaster = (EmployeeMaster) empList.get(0);
            expenseMaster.setEmployeeMasterByApprover2Id(employeeMaster);//Admin
        }
        String btnType = request.getParameter("btnType");
        if (btnType.equals("Approve")) {
            expenseMaster.setStatus(4);
            expenseMasterService.update(expenseMaster);
            request.setAttribute("successMessage",
                    "Information : The Request is Approved successfully.");
            try {
                EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                DesignationMaster designationMaster = new DesignationMaster();
                designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                EmailTemplate emailTemplate = new EmailTemplate();
                // id=55 for Expense Approve to employee...

                int empId = Integer.parseInt(request.getParameter("empId"));
                employeeMaster.setId(empId);

//            List list = employeeMasterService.readByEmployeeNo(empId);
//            employeeMaster = (EmployeeMaster)list.get(0);
                employeeMaster = employeeMasterService.readById(empId);
                emailTemplate = emailTemplateService.readById(55);
                String To = employeeMaster.getOfficeEmailId();
                String from = employeeMasterModel.getOfficeEmailId();
                String Subject = emailTemplate.getSubject();
                Subject = Subject.replaceAll("\\{user\\}", employeeMasterModel.getEmployeeName());
                String msg = emailTemplate.getBodytext();
                msg = msg.replaceAll("\\{to_user\\}", employeeMaster.getEmployeeName());
                msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                sendMail.sendMail(from, To, Subject, msg);
            } catch (Exception e) {
            }

        }

        mv = viewExpenseAdminSide(request, response);
        return mv;
    }

    public ModelAndView searchExpensePendingSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ExpenseMaster expenseMaster = new ExpenseMaster();
        ExpenseMaster expenseMaster1 = new ExpenseMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        EmployeeMaster employeeMaster2 = new EmployeeMaster();
        EmployeeMaster employeeMaster3 = new EmployeeMaster();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        expenseMaster.setEmployeeMasterByEmployeeId(employeeMaster);
        List<?> travelTypeList = new ArrayList<Object>();
        List<?> relocationTypeList = new ArrayList<Object>();
        List<?> travelOtherTypeList = new ArrayList<Object>();
        List<?> relocationOtherTypeList = new ArrayList<Object>();
        List<?> policyOtherTypeList = new ArrayList<Object>();
        List<?> othersList = new ArrayList<Object>();

        List<?> list = expenseMasterService.readByExpensePendingRequest(expenseMaster);
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
        request.setAttribute("list", list);
        mv.getModelMap().put("expenseMaster", expenseMaster);
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.setViewName("ExpenseReport/ExpenseReportResult");
        return mv;
    }

    public ModelAndView searchExpenseRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        ExpenseMaster expenseMaster = new ExpenseMaster();
        HttpSession session = request.getSession();
        selectEmployee(request, response);
        departmentList(request);
        designationList(request);
        expenseMaster.setStatus(999);
        List<?> expenseList = expenseMasterService.readExpenseRequestListForAdmin(expenseMaster);
        request.setAttribute("expenseList", expenseList);
        session.setAttribute("expenseRequestList", expenseList);
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.setViewName("ExpenseReport/ExpenseReportSearchByAdmin");
        return mv;
    }

    public ModelAndView submitExpenseRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession();
        ExpenseMaster expenseMaster = new ExpenseMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        String empId = request.getParameter("employeeName");
        String departmentId = request.getParameter("departmentMaster");
        String designationId = request.getParameter("designationMaster");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String expenseType = request.getParameter("expenseType");
        String expenseStatus = request.getParameter("expenseStatus");

        if (!empId.equals("")) {
            employeeMaster.setId(Integer.parseInt(empId));
        }
        if (!departmentId.equals("")) {
            employeeMaster.setChild1(departmentId);
        }
        if (!designationId.equals("")) {
            employeeMaster.setChild2(designationId);
        }
        if (!startDate.equals("")) {
            employeeMaster.setCompany(startDate);
        }
        if (!endDate.equals("")) {
            employeeMaster.setContactNo1(endDate);
        }
        if (!expenseType.equals("")) {
            expenseMaster.setExpenseType(expenseType);
        }
        if (!expenseStatus.equals("")) {
            expenseMaster.setStatus(Integer.parseInt(expenseStatus));
        }
        expenseMaster.setEmployeeMasterByEmployeeId(employeeMaster);
        List<?> expenseList = expenseMasterService.readExpenseRequestListForAdmin(expenseMaster);

        request.setAttribute("expenseList", expenseList);
        session.setAttribute("expenseRequestList", expenseList);
        mv = searchExpenseRequest(request, response);
        return mv;
    }

    public ModelAndView viewExpenseRequestByAdmin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ExpenseMaster expenseMaster = new ExpenseMaster();
        ExpenseMaster expenseMaster1 = new ExpenseMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        DesignationMaster designationMaster;
        LevelMaster levelMaster;
        DepartmentMaster departmentMaster;

        List<?> travelTypeList = new ArrayList<Object>();
        List<?> relocationTypeList = new ArrayList<Object>();
        List<?> travelOtherTypeList = new ArrayList<Object>();
        List<?> relocationOtherTypeList = new ArrayList<Object>();
        List<?> policyOtherTypeList = new ArrayList<Object>();
        List<?> othersList = new ArrayList<Object>();
        int empId = Integer.parseInt(request.getParameter("empId"));
//        UserMaster user = (UserMaster) request.getSession().getAttribute("user");
//        employeeMaster.setUserMaster(user);
        UserMaster userMaster = new UserMaster();
        employeeMaster = employeeMasterService.readById(empId);

        userMaster = userMasterService.readById(employeeMaster.getUserMaster().getId());
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

        LocationMaster locationMaster = new LocationMaster();
        locationMaster = locationMasterService.readById(employeeMaster.getLocationMaster().getId());
        employeeMaster.setLocationMaster(locationMaster);
        employeeMaster.setLevelMaster(levelMaster);
        employeeMaster.setDepartmentMaster(departmentMaster);
        employeeMaster.setDesignationMaster(designationMaster);
        selectTravelNo(request, userMaster);
        policyList(request);
        readcurrencyList(request);
        expenseMaster1.setEmployeeMasterByEmployeeId(employeeMaster);
        int expenseId = Integer.parseInt(request.getParameter("id"));
        expenseMaster1 = expenseMasterService.readById(expenseId);
        if (expenseMaster1.getExpenseType().equals("Travel")) {
            travelTypeList = expenseTravelTypeService.readByExpenseMasterId(expenseId);
            travelOtherTypeList = relocationOrOtherExpenseService.readByExpenseMasterId(expenseId);
        }
        if (expenseMaster1.getExpenseType().equals("Relocation")) {
            relocationTypeList = expenseTravelTypeService.readByExpenseMasterId(expenseId);
            relocationOtherTypeList = relocationOrOtherExpenseService.readByExpenseMasterId(expenseId);
        }
        if (expenseMaster1.getExpenseType().equals("PolicyReimbursements")) {
            policyOtherTypeList = relocationOrOtherExpenseService.readByExpenseMasterId(expenseId);
        }
        if (expenseMaster1.getExpenseType().equals("Others")) {
            othersList = expenseOtherTypeService.readByExpenseMasterId(expenseId);
        }
        List<?> expenseReconsilationList = expenseReconsilationService.readExpenseReconsilationFoApprover(expenseId);
        request.setAttribute("expenseReconsilationList", expenseReconsilationList);

        request.setAttribute("travelTypeList", travelTypeList);
        request.setAttribute("travelOtherTypeList", travelOtherTypeList);
        request.setAttribute("relocationTypeList", relocationTypeList);
        request.setAttribute("relocationOtherTypeList", relocationOtherTypeList);
        request.setAttribute("policyOtherTypeList", policyOtherTypeList);
        request.setAttribute("othersList", othersList);
        request.setAttribute("employeeMaster", employeeMaster);
        request.setAttribute("previousExpense", expenseMaster1.getExpenseType());
        mv.getModelMap().put("expenseMaster", expenseMaster1);
        mv.setViewName("ExpenseReport/ExpenseReportViewEmpWiseByAdmin");

        return mv;
    }

    public ModelAndView searchOwnExpenseRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ExpenseMaster expenseMaster = new ExpenseMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        UserMaster user = (UserMaster) request.getSession().getAttribute("user");
        employeeMaster.setUserMaster(user);
        List<?> empId = employeeMasterService.readByUserName(employeeMaster);
        if (!empId.isEmpty()) {
            employeeMaster = (EmployeeMaster) empId.get(0);
        }
        mv.getModelMap().put("employeeMaster", employeeMaster);

        mv.setViewName("ExpenseReport/ExpenseRequestSearchByEmployee");
        return mv;
    }

    public ModelAndView searchOwnExpenseRequestResult(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ExpenseMaster expenseMaster = new ExpenseMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        String expenseType = request.getParameter("expenseType");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String id = request.getParameter("id");
        UserMaster user = (UserMaster) request.getSession().getAttribute("user");
        employeeMaster.setUserMaster(user);
        List<?> empId = employeeMasterService.readByUserName(employeeMaster);
        if (!empId.isEmpty()) {
            employeeMaster = (EmployeeMaster) empId.get(0);
        }
        if (!id.equals("")) {
            employeeMaster.setId(Integer.parseInt(id));
        }
        if (!expenseType.equals("")) {
            expenseMaster.setExpenseType(expenseType);
        }
        if (!startDate.equals("")) {
            expenseMaster.setDateOfSubmit(startDate);

        }
        if (!endDate.equals("")) {
            employeeMaster.setAdharCard(endDate);

        }
        if (!endDate.equals(employeeMaster.getAdharCard())) {
            employeeMaster.setAdharCard("");
        }
        expenseMaster.setEmployeeMasterByEmployeeId(employeeMaster);
        List<?> list = expenseMasterService.readByEmpId(expenseMaster);
//        List<?> list = expenseMasterService.searchExpenseReportByEmployee(expenseMaster);
        request.setAttribute("list", list);
        request.setAttribute("flag", 1);
        mv = createExpenseResult(request, response);
//        mv = searchOwnExpenseRequest(request, response);
        return mv;
    }

    public ModelAndView searchSubordinatesExpenseReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        selectEmployee(request, response);
        departmentList(request);
        designationList(request);
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.setViewName("ExpenseReport/ExpenseReportOfSubordinates");
        return mv;
    }

    public ModelAndView subordinatesExpenseReportResult(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();

        UserMaster user = (UserMaster) request.getSession().getAttribute("user");
        employeeMaster1.setUserMaster(user);
        List<?> empIdList = employeeMasterService.readByUserName(employeeMaster1);
        if (!empIdList.isEmpty()) {
            employeeMaster1 = (EmployeeMaster) empIdList.get(0);
        }
        String reportingManager_Id = employeeMaster1.getId().toString();

        ExpenseMaster expenseMaster = new ExpenseMaster();
        String empId = request.getParameter("employeeName");
        String departmentId = "";
        String designationId = "";
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String expenseType = request.getParameter("expenseType");
        String expenseStatus = request.getParameter("expenseStatus");

        if (!empId.equals("")) {
            employeeMaster.setId(Integer.parseInt(empId));
        }
        if (!departmentId.equals("")) {
            employeeMaster.setChild1(departmentId);
        }
        if (!designationId.equals("")) {
            employeeMaster.setChild2(designationId);
        }
        if (!startDate.equals("")) {
            employeeMaster.setCompany(startDate);
        }
        if (!endDate.equals("")) {
            employeeMaster.setContactNo1(endDate);
        }
        if (!expenseType.equals("")) {
            expenseMaster.setExpenseType(expenseType);
        }
        if (!expenseStatus.equals("")) {
            expenseMaster.setStatus(Integer.parseInt(expenseStatus));
        }
        expenseMaster.setEmployeeMasterByEmployeeId(employeeMaster);

        List<?> reportingLevel1List = expenseMasterService.readExpenseRequestByReportingLevel1(expenseMaster, reportingManager_Id);
        if (!reportingLevel1List.isEmpty()) {
            request.setAttribute("reportingLevel", reportingLevel1List);

        }
        List<?> reportingLevel2List = expenseMasterService.readExpenseRequestByReportingLevel2(expenseMaster, reportingManager_Id);
        if (!reportingLevel2List.isEmpty()) {
            request.setAttribute("reportingLevel", reportingLevel2List);

        }
        List<?> reportingLevel3List = expenseMasterService.readExpenseRequestByReportingLevel3(expenseMaster, reportingManager_Id);
        if (!reportingLevel3List.isEmpty()) {
            request.setAttribute("reportingLevel", reportingLevel3List);

        }
        List<?> reportingLevel4List = expenseMasterService.readExpenseRequestByReportingLevel4(expenseMaster, reportingManager_Id);
        if (!reportingLevel4List.isEmpty()) {
            request.setAttribute("reportingLevel", reportingLevel4List);

        }
//        List<?> expenseList = expenseMasterService.readExpenseRequestListOfSubordinates(expenseMaster, reportingManager_Id);
        request.setAttribute("flag", 1);
        mv = createExpenseApproveList(request, response);
//        mv = searchSubordinatesExpenseReport(request, response);
        return mv;
    }

    public ModelAndView pendingExpenseRequestList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession();
        TravelRequestMaster travelRequestMaster = new TravelRequestMaster();
        ExpenseTravelType expenseTravelType = new ExpenseTravelType();
        ExpenseMaster expenseMaster = new ExpenseMaster();

        List<?> list = travelRequestMasterService.readExpensePendingList(travelRequestMaster);
        List<List<?>> finalList = new LinkedList<List<?>>();
        for (Object list1 : list) {
            Object[] ob = (Object[]) list1;
            String id = "" + ob[0];
            String empId = "" + ob[1];
            String empName = "" + ob[2];
            String travelRequestNo = "" + ob[3];
            String travelType = "" + ob[4];
            String startDateTime = "" + ob[5];
            String endDateTime = "" + ob[6];
            String empMasterId = "" + ob[7];

            List<String> l1 = new LinkedList<String>();

            l1.add(id);
            l1.add(empId);
            l1.add(empName);
            l1.add(travelRequestNo);
            l1.add(travelType);
            l1.add(startDateTime);
            l1.add(endDateTime);

            l1.add("Pending");
            l1.add("0");
            l1.add(empMasterId);
            l1.add("Pending");
            List<?> expenseTypeList = expenseTravelTypeService.read();
            boolean flag = true;

            for (Object expenseTypeList1 : expenseTypeList) {

                expenseTravelType = (ExpenseTravelType) expenseTypeList1;
                if (expenseTravelType.getTravelApplicationNo().equals(id)) {
                    expenseMaster = expenseMasterService.readById(expenseTravelType.getExpenseMaster().getId());
                    l1.remove(7);
                    l1.add(7, "Submited");
                    l1.remove(8);
                    l1.add(8, "" + expenseMaster.getStatus());
                    l1.remove(10);
                    l1.add("" + expenseMaster.getId());
                    flag = false;
                    break;
                }

            }
           
            finalList.add(l1);

        }
        request.setAttribute("finalList", finalList);
        session.setAttribute("expensePendingList", finalList);
        mv.setViewName("ExpenseReport/ExpenseRequestPending");
        return mv;
    }

    public void relocationOrOtherExpense(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String reloOtherId = request.getParameter("reloOtherId");
        try {
            relocationOrOtherExpenseService.delete(Integer.parseInt(reloOtherId));
        } catch (Exception e) {

        }

    }

    public void expenseTravelTypeMethod(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String reloTypeId = request.getParameter("reloTypeId");
        try {
            expenseTravelTypeService.delete(Integer.parseInt(reloTypeId));
        } catch (Exception e) {

        }
    }

    public void expenseOtherTypeMethod(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String otherListId = request.getParameter("otherListId");
        try {
            expenseOtherTypeService.delete(Integer.parseInt(otherListId));
        } catch (Exception e) {

        }

    }

    public ModelAndView exportToExcelExpense(HttpServletRequest request, HttpServletResponse response, EmployeeMaster employeeMaster) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<?> expenseRequestList = (List<?>) request.getSession().getAttribute("expenseRequestList");
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=ExpenseRequestData.xls");
        mv.addObject("expenseRequestList", expenseRequestList);
        mv.setViewName("ExpenseReport/ExpenseRequestExcelData");
        return mv;
    }

    public ModelAndView exportToExcelForTravelCompletedAndExpensePending(HttpServletRequest request, HttpServletResponse response, EmployeeMaster employeeMaster) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<?> expensePendingList = (List<?>) request.getSession().getAttribute("expensePendingList");
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=ExpensePendingData.xls");
        mv.addObject("expensePendingList", expensePendingList);
        mv.setViewName("ExpenseReport/ExpensePendingExcelData");
        return mv;
    }

    public ModelAndView exportToPdfExpenseReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

//        response.setContentType("application/pdf");
//        response.setHeader("Content-Disposition", "attachment; filename=ExpenseReport.pdf");
        ExpenseMaster expenseMaster = new ExpenseMaster();
        ExpenseMaster expenseMaster1 = new ExpenseMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        DesignationMaster designationMaster;
        LevelMaster levelMaster;
        DepartmentMaster departmentMaster;
        LocationMaster locationMaster;

        List<?> travelTypeList = new ArrayList<Object>();
        List<?> relocationTypeList = new ArrayList<Object>();
        List<?> travelOtherTypeList = new ArrayList<Object>();
        List<?> relocationOtherTypeList = new ArrayList<Object>();
        List<?> policyOtherTypeList = new ArrayList<Object>();
        List<?> othersList = new ArrayList<Object>();
        UserMaster user = (UserMaster) request.getSession().getAttribute("user");
        employeeMaster.setUserMaster(user);
        List<?> empList = employeeMasterService.readByUserName(employeeMaster);
        if (!empList.isEmpty()) {
            employeeMaster = (EmployeeMaster) empList.get(0);
        }
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
        int expenseId = Integer.parseInt(request.getParameter("id"));
        expenseMaster1 = expenseMasterService.readById(expenseId);
        boolean flag = true;
        boolean flag1 = true;
        boolean flag2 = true;
        boolean flag3 = true;
        boolean flag4 = true;
        boolean flag5 = true;
        if (expenseMaster1.getExpenseType().equals("Travel")) {
            travelTypeList = expenseTravelTypeService.readByExpenseMasterId(expenseId);
            for (Object o : travelTypeList) {
                ExpenseTravelType expenseTravelType = (ExpenseTravelType) o;
                if (expenseTravelType.getStatus() != 1) {
                    flag1 = false;
                }

            }
            travelOtherTypeList = relocationOrOtherExpenseService.readByExpenseMasterId(expenseId);
            for (Object o2 : travelOtherTypeList) {
                RelocationOrOtherExpense relocationOrOtherExpense = (RelocationOrOtherExpense) o2;
                if (relocationOrOtherExpense.getStatus() != 1) {
                    flag2 = false;
                }

            }
            request.setAttribute("flag1", flag1);
            request.setAttribute("flag2", flag2);
        }
        if (expenseMaster1.getExpenseType().equals("Relocation")) {
            relocationTypeList = expenseTravelTypeService.readByExpenseMasterId(expenseId);
            for (Object o3 : relocationTypeList) {
                ExpenseTravelType expenseTravelType = (ExpenseTravelType) o3;
                if (expenseTravelType.getStatus() != 1) {
                    flag3 = false;
                }

            }
            relocationOtherTypeList = relocationOrOtherExpenseService.readByExpenseMasterId(expenseId);
            for (Object o4 : relocationOtherTypeList) {
                RelocationOrOtherExpense relocationOrOtherExpense = (RelocationOrOtherExpense) o4;
                if (relocationOrOtherExpense.getStatus() != 1) {
                    flag4 = false;
                }

            }
            request.setAttribute("flag3", flag3);
            request.setAttribute("flag4", flag4);

        }
        if (expenseMaster1.getExpenseType().equals("PolicyReimbursements")) {
            policyOtherTypeList = relocationOrOtherExpenseService.readByExpenseMasterId(expenseId);
            for (Object policyReimb : policyOtherTypeList) {
                RelocationOrOtherExpense relocationOrOtherExpense = (RelocationOrOtherExpense) policyReimb;
                if (relocationOrOtherExpense.getStatus() != 1) {
                    flag5 = false;
                }
            }
            request.setAttribute("flag5", flag5);
        }
        if (expenseMaster1.getExpenseType().equals("Others")) {
            othersList = expenseOtherTypeService.readByExpenseMasterId(expenseId);
            for (Object o1 : othersList) {
                ExpenseOtherType expenseOtherType = (ExpenseOtherType) o1;
                System.out.println("ajay" + expenseOtherType.getStatus());
                if (expenseOtherType.getStatus() != 1) {
                    flag = false;
                }
            }
            request.setAttribute("flag", flag);
        }
        List<?> expenseReconsilationList = expenseReconsilationService.readExpenseReconsilationByExpenseID(expenseId);
        request.setAttribute("expenseReconsilationList", expenseReconsilationList);
        request.setAttribute("travelTypeList", travelTypeList);
        request.setAttribute("travelOtherTypeList", travelOtherTypeList);
        request.setAttribute("relocationTypeList", relocationTypeList);
        request.setAttribute("relocationOtherTypeList", relocationOtherTypeList);
        request.setAttribute("policyOtherTypeList", policyOtherTypeList);
        request.setAttribute("othersList", othersList);
        request.setAttribute("employeeMaster", employeeMaster);
        request.setAttribute("previousExpense", expenseMaster1.getExpenseType());
        request.setAttribute("expenseId", expenseId);
        mv.getModelMap().put("expenseMaster", expenseMaster1);
//        mv.setViewName("ExpenseReport/ExpenseReportApproveView");
        mv.setViewName("ExpenseReport/ExpenseReportExportToPdf");
//        mv.setViewName("ExpenseReport/ExpensePendingExcelData");
        return mv;
    }

}
