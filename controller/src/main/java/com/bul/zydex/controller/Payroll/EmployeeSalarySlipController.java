/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.model.DepartmentMaster;
import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.model.DisplaymorNotes;
import com.bul.zydex.model.EmployeeDeductionAmount;
import com.bul.zydex.model.EmployeeExcelRecord;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.EmployeeSalaryProcess;
import com.bul.zydex.model.EmployeeSubType;
import com.bul.zydex.model.EmployeeType;
import com.bul.zydex.model.EmployeeTypeMaster;
import com.bul.zydex.model.PayrollLoanDetail;
import com.bul.zydex.model.PayrollLoanRemainingAmount;
import com.bul.zydex.model.PayrollLoanType;
import com.bul.zydex.model.PayrollSalaryType;
import com.bul.zydex.model.UserRightMaster;
import com.bul.zydex.model.ZydexLocationMaster;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import static java.util.Collections.list;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Irfan <irfanbhindawala@gmail.com>
 */
public class EmployeeSalarySlipController extends EmployeeSalarySlipAbstract {

    public ModelAndView searchSalarySlipDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeSalaryProcess employeeSalaryProcess = new EmployeeSalaryProcess();
        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeType employeeType = new EmployeeType();
        EmployeeSubType employeeSubType = new EmployeeSubType();
        List<?> list = (List<?>) request.getAttribute("employeelist");
//        zydexLocationList(request);
//        EmployeeTypeList(request);
//        EmployeeSubTypeList(request);
        locationList(request);
        companyList(request);
        request.setAttribute("search", request.getParameter("search"));
        List<?> list1 = (List<?>) request.getAttribute("SalaryList");
        mv.getModelMap().put("employeeSalaryProcess", employeeSalaryProcess);
        request.setAttribute("employeelist", list);
        session.setAttribute("EmployeePfcheck1", list1);
        mv.setViewName("Payroll/EmployeeSalarySlipDetail");
        return mv;
    }

    public ModelAndView searchFormEmployeeSlipDetailSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeSalaryProcess employeeSalaryProcess = new EmployeeSalaryProcess();
        EmployeeMaster employeeMaster2 = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeType employeeType = new EmployeeType();
        EmployeeSubType employeeSubType = new EmployeeSubType();

        String zydex_location_id = request.getParameter("zydexLocationMasterId");
        String type_of_employee = request.getParameter("companyId");
//        String employee_sub_id = request.getParameter("subTypeId");
//        String Payment_Type = request.getParameter("paymentType");
        String month = request.getParameter("month");
        String year = request.getParameter("year11");
        Integer id = employeeMaster2.getId();

        HttpSession session = request.getSession();
//       
        

        List listForMonthAndYear = new ArrayList();
        boolean emright = false;
        boolean emrightHR = false;
        EmployeeMaster employeeMaster1 = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        String usermId = (String) employeeMaster1.getUserMaster().getId().toString();
        List<UserRightMaster> userRightMasterList = (List<UserRightMaster>) userRightMasterService.readByUserId(usermId);
        for (int i = 0; i < userRightMasterList.size(); i++) {
            UserRightMaster au1 = (UserRightMaster) userRightMasterList.get(i);
            emright = au1.isPayroll();
        }
        for (int i = 0; i < userRightMasterList.size(); i++) {
            UserRightMaster au1 = (UserRightMaster) userRightMasterList.get(i);
            emrightHR = au1.isHr();
        }

        if (emrightHR || emright) {
            
            if (!zydex_location_id.equals("")) {
            employeeMaster.setAdharCard(zydex_location_id);
        }

        if (!type_of_employee.equals("")) {
            employeeMaster.setCompany(type_of_employee);
        }
//        if (null != employee_sub_id && !employee_sub_id.equals("")) {
//            employeeMaster.setCompany(employee_sub_id);
//        }
////
//        if (!Payment_Type.equals("")) {
//            employeeMaster.setPaymentType(Payment_Type);
//
//        }

        if (!"".equals(month)) {
            employeeMaster.setBankAccountNo(month);
        }
        if (!"".equals(year)) {
            employeeMaster.setPanCard(year);
        }
            List<?> list = employeeSalaryProcessService.readEmployeeForSlip(employeeMaster);
            if (!list.isEmpty()) {

                for (Object dedSalaryList1 : list) {
                    List finalList = new ArrayList();
                    DecimalFormat df = new DecimalFormat("####0.00");
                    Object[] o = (Object[]) dedSalaryList1;
                    double basicSalary = 0;
                    int empid = 0;
                    int empid2 = 0;
                    basicSalary += (Double) o[6];
                    empid += (Integer) o[5];
                    String employeeId = (String) o[0];
                    String employeeName = (String) o[1];
                    String month1 = (String) o[2];
                    String year1 = (String) o[3];
                    empid2 += (Integer) o[4];

                    finalList.add(employeeId);
                    finalList.add(employeeName);
                    finalList.add(month1);
                    finalList.add(year1);
                    finalList.add(empid2);
                    finalList.add(empid);

                    double additionalAmt = 0;
                    List<?> additionalAmount = employeeAdditionalSalaryService.readAdditionalAmount(empid);
                    if (!additionalAmount.isEmpty()) {
                        additionalAmt = (Double) additionalAmount.get(0);
                    }
                    double netSalary = (int) Math.round(basicSalary + additionalAmt);

                    double deductionAmt1 = 0;
                    List<?> deductionAmountList1 = employeeDeductionAmountService.readDeductionAmount(empid);
                    if (!deductionAmountList1.isEmpty()) {
                        deductionAmt1 = (Double) deductionAmountList1.get(0);
                    }
                    double netpayable = netSalary - deductionAmt1;
                    int netpayable1 = (int) Math.round(netpayable);
                    finalList.add(netpayable1);
                    listForMonthAndYear.add(finalList);

                    request.setAttribute("employeelist", listForMonthAndYear);
                    session.setAttribute("employeePfcheckList", list);
                }

            }

        } else {
//            String zydex_location_id1 = null;
//            String type_of_employee1 = null;

//            if (!type_of_employee1.equals("")) {
//                employeeMaster.setEmployeeType(type_of_employee1);
//            }
            if (!"".equals(month)) {
                employeeMaster.setBankAccountNo(month);
            }
            if (!"".equals(year)) {
                employeeMaster.setPanCard(year);
            }
            if (!id.equals("")) {
                employeeMaster.setId(id);
            }
            EmployeeMaster employeeMaster12 = new EmployeeMaster();
            employeeMaster12 = employeeMasterService.readById(id);
            if (employeeMaster12.getDateOfLeaving() == null) {

                List<?> list = employeeSalaryProcessService.readEmployeeForSlip1(employeeMaster);
                if (!list.isEmpty()) {

                    for (Object dedSalaryList1 : list) {
                        List finalList = new ArrayList();
                        DecimalFormat df = new DecimalFormat("####0.00");
                        Object[] o = (Object[]) dedSalaryList1;
                        double basicSalary = 0;
                        int empid = 0;
                        int empid2 = 0;
                        basicSalary += (Double) o[6];
                        empid += (Integer) o[5];
                        String employeeId = (String) o[0];
                        String employeeName = (String) o[1];
                        String month1 = (String) o[2];
                        String year1 = (String) o[3];
                        empid2 += (Integer) o[4];

                        finalList.add(employeeId);
                        finalList.add(employeeName);
                        finalList.add(month1);
                        finalList.add(year1);
                        finalList.add(empid2);
                        finalList.add(empid);

                        double additionalAmt = 0;
                        List<?> additionalAmount = employeeAdditionalSalaryService.readAdditionalAmount(empid);
                        if (!additionalAmount.isEmpty()) {
                            additionalAmt = (Double) additionalAmount.get(0);
                        }
                        double netSalary = (int) Math.round(basicSalary + additionalAmt);

                        double deductionAmt1 = 0;
                        List<?> deductionAmountList1 = employeeDeductionAmountService.readDeductionAmount(empid);
                        if (!deductionAmountList1.isEmpty()) {
                            deductionAmt1 = (Double) deductionAmountList1.get(0);
                        }
                        double netpayable = netSalary - deductionAmt1;
                        int netpayable1 = (int) Math.round(netpayable);
                        finalList.add(netpayable1);
                        listForMonthAndYear.add(finalList);

                        request.setAttribute("employeelist", listForMonthAndYear);
                        session.setAttribute("employeePfcheckList", list);
                    }

                }
            }

        }

//        request.setAttribute("employeelist", listForMonthAndYear);
//        session.setAttribute("employeePfcheckList", list);
        mv = searchSalarySlipDetail(request, response);
        return mv;
    }

    public ModelAndView ViewIndiviualSalarySlip(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        EmployeeSalaryProcess employeeSalaryProcess = new EmployeeSalaryProcess();
        DesignationMaster designationMaster = new DesignationMaster();
        DepartmentMaster departmentMaster = new DepartmentMaster();
        EmployeeExcelRecord employeeExcelRecord = new EmployeeExcelRecord();
//        EmployeeMaster employeeMaster = new EmployeeMaster();
        String id = request.getParameter("id");
        String month = request.getParameter("month");
        String year = request.getParameter("year");
        Calendar cal3 = Calendar.getInstance();
        cal3.set(Calendar.MONTH, (Integer.parseInt(month) - 1));
        int days1 = cal3.getActualMaximum(Calendar.DAY_OF_MONTH);

        DecimalFormat df = new DecimalFormat("####0.00");
        EmployeeMaster employeeMaster = employeeMasterService.readById(Integer.parseInt(id));
        designationMaster = designationMasterService.readById(employeeMaster.getDesignationMaster().getId());
        departmentMaster = departmentMasterService.readById(employeeMaster.getDepartmentMaster().getId());
        employeeMaster.setDesignationMaster(designationMaster);
        employeeMaster.setDepartmentMaster(departmentMaster);
        employeeSalaryProcess.setEmployeeMaster(employeeMaster);
        employeeSalaryProcess.setMonth(month);
        employeeSalaryProcess.setYear(year);
        List<?> employeeSalaryProcessList = employeeSalaryProcessService.readEmployeeForSalaryinfo(employeeSalaryProcess);
        double basicSalary = 0;

        if (!employeeSalaryProcessList.isEmpty()) {
            basicSalary = (Double) employeeSalaryProcessList.get(0);
        }
        List<?> employeeAdditionalList = employeeAdditionalSalaryService.readEmployeeForSalaryAdditionalinfo(employeeSalaryProcess);
        List<?> employeeDeductionList = employeeDeductionAmountService.readEmployeeForSalaryDeductioninfo(employeeSalaryProcess);
        List<?> employeeAddDeductionList = employeeDeductionAmountService.readEmployeeForSalaryAddDeductioninfo(employeeSalaryProcess);
        List<?> employeeExcelRecordList = employeeExcelRecordService.readByEmployeExcelReport(employeeSalaryProcess);
//        List<?> loanRemainigAmount = payrollLoanDetailService.readByloanRemainingAmount(employeeMaster.getId(), employeeSalaryProcess.getMonth(), employeeSalaryProcess.getYear());
//        List<?> loanRemainigAmount = payrollLoanRemainingAmountService.readByloanRemainingAmountslip(employeeMaster.getId(), employeeSalaryProcess.getMonth(), employeeSalaryProcess.getYear());
        List<?> loanRemainigAmount = payrollLoanDetailService.readByloanRemainingAmountslip(employeeMaster.getId(), employeeSalaryProcess.getMonth(), employeeSalaryProcess.getYear());
//       

        employeeExcelRecord.setEmployeeSalaryProcess(employeeSalaryProcess);
        double totalDeductionAmount = 0;
        int totalDeductionAmount1 = 0;
        Iterator itr = employeeAddDeductionList.iterator();
        while (itr.hasNext()) {

            totalDeductionAmount += (Double) itr.next();
            totalDeductionAmount1 = (int) Math.round(totalDeductionAmount);
        }
        List<?> employeeAddAdditionalList = employeeAdditionalSalaryService.readEmployeeForSalaryAddAdditionalinfo(employeeSalaryProcess);
        double totalAdditionalAmount = 0;
        Iterator itr1 = employeeAddAdditionalList.iterator();
        while (itr1.hasNext()) {
            totalAdditionalAmount += (Double) itr1.next();
        }
        double total = (int) Math.round(basicSalary + totalAdditionalAmount);
//        double nettotalEsic = 0;
//        if (total <= 20000) {
//
//            nettotalEsic = total * 1.75 / 100;
//
//        }
//
//        double totalDeductionAmountESIC = nettotalEsic + totalDeductionAmount;
        DisplaymorNotes displaymorNotes = new DisplaymorNotes();
        double nettotal = total - totalDeductionAmount;
        int nettotal1 = (int) Math.round(nettotal);
        String n1 = df.format(nettotal1);
        List list = displaymorNotesService.read();
        for (Object o : list) {
            displaymorNotes = (DisplaymorNotes) o;

        }
        String notes = displaymorNotes.getPayrollNotes();
        mv.getModelMap().put("employeeSalaryProcessList", employeeSalaryProcessList);
        mv.getModelMap().put("employeeAdditionalList", employeeAdditionalList);
        mv.getModelMap().put("employeeDeductionList", employeeDeductionList);
        mv.getModelMap().put("totalDeductionAmount", totalDeductionAmount1);
        mv.getModelMap().put("total", total);
        mv.getModelMap().put("nettotal", n1);
//        mv.getModelMap().put("loanRemainigAmount1", loanRemainigAmount1);
        request.setAttribute("employeeMaster", employeeMaster);
        request.setAttribute("basicSalary", basicSalary);
        request.setAttribute("employeeExcelRecordList", employeeExcelRecordList);
        request.setAttribute("loanRemainigAmount", loanRemainigAmount);
        request.setAttribute("month", month);
        request.setAttribute("year", year);
        request.setAttribute("notes", notes);
        request.setAttribute("days1", days1);

        mv.setViewName("Payroll/SalarySlipForm");
        return mv;
    }

    public ModelAndView searchSalaryYearDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        EmployeeTypeMaster employeeTypeMaster = new EmployeeTypeMaster();
        ZydexLocationMaster zydexLocationMaster = new ZydexLocationMaster();
        EmployeeSubType employeeSubType = new EmployeeSubType();

//        EmployeeTypeList(request);
//        EmployeeSubTypeList(request);
//        zydexLocationList(request);
         locationList(request);
        companyList(request);
        selectEmployee(request, response);
        request.setAttribute("search", request.getParameter("search"));
        mv.getModelMap().put("employeeTypeMaster", employeeTypeMaster);
        mv.setViewName("Payroll/EmployeeYearlySalary");
        return mv;
    }

    public ModelAndView searchYearlySalaryDetailSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeSalaryProcess employeeSalaryProcess = new EmployeeSalaryProcess();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeType employeeType = new EmployeeType();
        EmployeeSubType employeeSubType = new EmployeeSubType();

        String zydex_location_id = request.getParameter("zydexLocationMasterId");
        String type_of_employee = request.getParameter("companyId");
//        String employee_sub_id = request.getParameter("subTypeId");
//        String Financial_year = request.getParameter("fnyear");
        String Employee_Name = request.getParameter("employeeMasterId");

//       
        if (!zydex_location_id.equals("")) {
            employeeMaster.setAdharCard(zydex_location_id);
        }

        if (!type_of_employee.equals("")) {
            employeeMaster.setCompany(type_of_employee);
        }
//        if (null != employee_sub_id && !employee_sub_id.equals("")) {
//            employeeMaster.setCompany(employee_sub_id);
//        }
//

        if (!Employee_Name.equals("")) {
            employeeMaster.setEmployeeName(Employee_Name);

        }

        List<?> list = employeeSalaryProcessService.readEmployeeYearlySalary(employeeMaster);
        request.setAttribute("employeelist", list);
        mv = searchSalaryYearDetail(request, response);
        return mv;
    }

    public ModelAndView ViewIndiviualYearlySalary(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        EmployeeSalaryProcess employeeSalaryProcess = new EmployeeSalaryProcess();
//        EmployeeMaster employeeMaster = new EmployeeMaster();
        String id = request.getParameter("id");
        DecimalFormat df = new DecimalFormat("####0.00");

        EmployeeMaster employeeMaster = employeeMasterService.readById(Integer.parseInt(id));
        List<String> headerList = new ArrayList<String>();
        headerList.add("Emp Id");
        headerList.add("Emp Name");
        headerList.add("LWP");
        headerList.add("Basic Salary");
        headerList.add("Month");
        headerList.add("Year");

        List<?> list1 = employeeSalaryProcessService.readsalyearly(employeeMaster.getId());
        for (Object o1 : list1) {
            Object str[] = (Object[]) o1;
            if (!headerList.contains("" + str[5]) && null != str[5]) {
                headerList.add("" + str[5]);
            }

        }
        List<?> list2 = employeeSalaryProcessService.readsalDeductionYearly(employeeMaster.getId());
        for (Object o1 : list2) {
            Object str1[] = (Object[]) o1;
            if (!headerList.contains("" + str1[2]) && null != str1[2]) {
                headerList.add("" + str1[2]);
            }
        }
        headerList.add("Gross Salary");
        headerList.add("Deduction Amount");
        headerList.add("Net Amount");
        List<EmployeeSalaryProcess> empList = (List<EmployeeSalaryProcess>) employeeSalaryProcessService.readEmpSalaryReportyearly(employeeMaster.getId());
        List<Object> finalList = new LinkedList<Object>();
        if (null != empList && !list1.isEmpty()) {

            for (EmployeeSalaryProcess employeeSalaryProcess1 : empList) {
                Map<String, String> empMap = new HashMap<String, String>();
                double additionalAmount = 0.0;
                double deductionAmount = 0.0;
                EmployeeMaster employeeMaster1 = employeeMasterService.readById(employeeSalaryProcess1.getEmployeeMaster().getId());
                empMap.put("Emp Id", "" + employeeMaster1.getEmployeeId());
                empMap.put("Emp Name", employeeMaster1.getEmployeeName());
                empMap.put("LWP", "" + employeeSalaryProcess1.getEmployeeLwp());
//                empMap.put("Basic Salary", "" + df.format(employeeSalaryProcess1.getEmployeeBasicSalary()));
                empMap.put("Basic Salary", "" + df.format((int) Math.round(employeeSalaryProcess1.getEmployeeBasicSalary())));
                empMap.put("Month", "" + employeeSalaryProcess1.getMonth());
                empMap.put("Year", "" + employeeSalaryProcess1.getYear());
                List addSalaryList = employeeAdditionalSalaryService.readEmployeeForSalaryAdditionalinfo(employeeSalaryProcess1);
                for (Object addSalaryList1 : addSalaryList) {
                    Object[] o = (Object[]) addSalaryList1;
                    empMap.put("" + o[0], "" + df.format((int) Math.round((double) o[1])));
//                    empMap.put("" + o[0], "" + df.format(o[1]));
                    additionalAmount += (Double) o[1];
                }
                List dedSalaryList = employeeDeductionAmountService.readEmployeeForSalaryDeductioninfo(employeeSalaryProcess1);
                for (Object dedSalaryList1 : dedSalaryList) {
                    Object[] o = (Object[]) dedSalaryList1;
                    empMap.put("" + o[0], "" + df.format((int) Math.round((double) o[1])));
//                    empMap.put("" + o[0], "" + df.format(o[1]));
                    deductionAmount += (Double) o[1];
                }
                additionalAmount += employeeSalaryProcess1.getEmployeeBasicSalary();
//                empMap.put("Gross Salary Amount", "" + df.format(additionalAmount));
//                empMap.put("Deductional Amount", "" + df.format(deductionAmount));
//                empMap.put("NetProfit Amount", "" + df.format(additionalAmount - deductionAmount));
                empMap.put("Gross Salary", "" + df.format((int) Math.round(additionalAmount)));
//            empMap.put("Deduction Amount", "" + df.format(deductionAmount));
                empMap.put("Deduction Amount", "" + df.format((int) Math.round(deductionAmount)));
                empMap.put("Net Amount", "" + df.format((int) Math.round(additionalAmount - deductionAmount)));
                finalList.add(empMap);
            }
        }
        request.setAttribute("headerList123", headerList);
        request.setAttribute("finalList", finalList);
        mv.setViewName("Payroll/employeeSalaryYearlyList");
        return mv;
    }

    public ModelAndView editIndiviualSalarySlip(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        EmployeeSalaryProcess employeeSalaryProcess = new EmployeeSalaryProcess();
        DesignationMaster designationMaster = new DesignationMaster();
        DepartmentMaster departmentMaster = new DepartmentMaster();
        EmployeeExcelRecord employeeExcelRecord = new EmployeeExcelRecord();
//        EmployeeMaster employeeMaster = new EmployeeMaster();
        String id = request.getParameter("id");
        String month = request.getParameter("month");
        String year = request.getParameter("year");

        DecimalFormat df = new DecimalFormat("####0.00");
        EmployeeMaster employeeMaster = employeeMasterService.readById(Integer.parseInt(id));
        designationMaster = designationMasterService.readById(employeeMaster.getDesignationMaster().getId());
        departmentMaster = departmentMasterService.readById(employeeMaster.getDepartmentMaster().getId());
        employeeMaster.setDesignationMaster(designationMaster);
        employeeMaster.setDepartmentMaster(departmentMaster);
        employeeSalaryProcess.setEmployeeMaster(employeeMaster);
        employeeSalaryProcess.setMonth(month);
        employeeSalaryProcess.setYear(year);

        List<?> employeeDeductionList = employeeDeductionAmountService.readEmployeeForloanEditinfo(employeeSalaryProcess);

//      
        mv.getModelMap().put("employeeDeductionList", employeeDeductionList);
        request.setAttribute("employeeMaster", employeeMaster);
        request.setAttribute("month", month);
        request.setAttribute("year", year);
        mv.setViewName("Payroll/EditSalarySlipForm");
        return mv;
    }

    public ModelAndView deleteIndiviualSalarySlip(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        EmployeeSalaryProcess employeeSalaryProcess = new EmployeeSalaryProcess();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        DesignationMaster designationMaster = new DesignationMaster();
        DepartmentMaster departmentMaster = new DepartmentMaster();
        EmployeeExcelRecord employeeExcelRecord = new EmployeeExcelRecord();
        PayrollLoanRemainingAmount payrollLoanRemainingAmount = new PayrollLoanRemainingAmount();
        EmployeeDeductionAmount employeeDeductionAmount = new EmployeeDeductionAmount();
        PayrollLoanType payrollLoanType = new PayrollLoanType();
//       
        String id = request.getParameter("id");
        String month = request.getParameter("month");
        String year = request.getParameter("year");
        String payrollid = request.getParameter("payrollid");
        String amount = request.getParameter("amount");
        String amountInt = request.getParameter("amountInt");
        String excelId = request.getParameter("excelid");

        employeeMaster.setId(Integer.parseInt(id));
        payrollLoanType.setId(Integer.parseInt(payrollid));

        List<?> employeeSalaryProcessList = employeeSalaryProcessService.readEmployeebyEmpolyeeSalary(Integer.parseInt(id), month, year);
        if (!employeeSalaryProcessList.isEmpty()) {
            int employeeSalaryProcess1 = (Integer) employeeSalaryProcessList.get(0);

            if (amount.equals("true") && (amountInt.equals("true"))) {

//            Start payrollLoanRemainingAmount deleted
                payrollLoanRemainingAmount.setId(Integer.parseInt(excelId));
                payrollLoanRemainingAmount.setEmployeeMaster(employeeMaster);
                payrollLoanRemainingAmount.setPayrollLoanType(payrollLoanType);
                payrollLoanRemainingAmountService.delete1(payrollLoanRemainingAmount);
//            end payrollLoanRemainingAmount deleted
//            start Employee Deduction amount 
                List<?> payrollLoanTypeName = payrollLoanTypeService.readPayrollLoanName(payrollLoanType);
                for (Object LoanDetailAmountList1 : payrollLoanTypeName) {
                    String textloanType = (String) LoanDetailAmountList1;

                    List<?> list11 = employeeDeductionAmountService.readEmployeeloandelete(employeeSalaryProcess1, textloanType);
                    if (!list11.isEmpty()) {
                        int employeeDeductionAmount1 = (Integer) list11.get(0);
                        employeeDeductionAmountService.delete(employeeDeductionAmount1);
                    }

                }
//                end employee Deduction amount
// Start payroll loan Detail
                List<?> list12 = payrollLoanDetailService.readByLoanEdit(Integer.parseInt(id), Integer.parseInt(payrollid));
                if (!list12.isEmpty()) {

                    for (Object dedSalaryList1 : list12) {
                        Object[] o = (Object[]) dedSalaryList1;
                        double LoanAmount = 0;
                        double opbal = 0;
                        double monthEmi = 0;
                        int payrollloanid = 0;
                        LoanAmount += (Double) o[0];
                        opbal += (Double) o[2];
                        monthEmi += (Double) o[1];
                        payrollloanid += (Integer) o[3];
                        String startdate = (String) o[4];
                        String enddate = (String) o[5];
                        String inrate = (String) o[6];
                        double opbal2 = 0;
                        PayrollLoanDetail payrollLoanDetail2 = new PayrollLoanDetail();
                        payrollLoanDetail2.setId(payrollloanid);
                        payrollLoanDetail2.setEmployeeMaster(employeeMaster);
                        payrollLoanDetail2.setPayrollLoanType(payrollLoanType);
                        payrollLoanDetail2.setLoanAmount(opbal);
                        payrollLoanDetail2.setOpRemainingBal(opbal2);
                        payrollLoanDetail2.setMonthyInstallment(opbal2);
                        payrollLoanDetail2.setMonthlyRateAmount(opbal2);
                        payrollLoanDetail2.setStartDate(startdate);
                        payrollLoanDetail2.setEndDate(enddate);
                        payrollLoanDetail2.setInstRate(inrate);
                        payrollLoanDetail2.setMonltyEmi(monthEmi);
                        payrollLoanDetailService.update(payrollLoanDetail2);
                    }
                }

            }

            if (amount.equals("true") && (amountInt.equals("false"))) {

//                 Start payrollLoanRemainingAmount deleted
                payrollLoanRemainingAmount.setId(Integer.parseInt(excelId));
                payrollLoanRemainingAmount.setEmployeeMaster(employeeMaster);
                payrollLoanRemainingAmount.setPayrollLoanType(payrollLoanType);
                payrollLoanRemainingAmountService.delete1(payrollLoanRemainingAmount);
//            end payrollLoanRemainingAmount deleted 

//                start Employee Deduction amount 
                List<?> payrollLoanTypeName = payrollLoanTypeService.readPayrollLoanName(payrollLoanType);
                for (Object LoanDetailAmountList1 : payrollLoanTypeName) {
                    String textloanType = (String) LoanDetailAmountList1;

                    List<?> list11 = employeeDeductionAmountService.readEmployeeloandelete(employeeSalaryProcess1, textloanType);
                    if (!list11.isEmpty()) {
                        int employeeDeductionAmount1 = (Integer) list11.get(0);
                        employeeDeductionAmountService.delete(employeeDeductionAmount1);
                    }

                }
// payroll Loan Details
                List<?> list12 = payrollLoanDetailService.readByLoanEdit(Integer.parseInt(id), Integer.parseInt(payrollid));
                if (!list12.isEmpty()) {

                    for (Object dedSalaryList1 : list12) {
                        Object[] o = (Object[]) dedSalaryList1;
                        double LoanAmount = 0;
                        double opbal = 0;
                        double monthEmi = 0;
                        double monthlyRateAmount = 0;
                        int payrollloanid = 0;
                        LoanAmount += (Double) o[0];
                        opbal += (Double) o[2];
                        monthEmi += (Double) o[1];
                        payrollloanid += (Integer) o[3];
                        String startdate = (String) o[4];
                        String enddate = (String) o[5];
                        String inrate = (String) o[6];
                        monthlyRateAmount += (Double) o[7];
                        double opbal2 = 0;
//                        employee deduction create insert rate
                        employeeSalaryProcess.setId(employeeSalaryProcess1);
                        employeeSalaryProcess.setEmployeeMaster(employeeMaster);
                        employeeDeductionAmount.setEmployeeSalaryProcess(employeeSalaryProcess);
                        employeeDeductionAmount.setDeductionType("LoanIntRate");
                        employeeDeductionAmount.setDeductionAmount(monthlyRateAmount);
                        employeeDeductionAmountService.create(employeeDeductionAmount);

//                         end deduction create insert rate
//                        pauyroll loan update
                        PayrollLoanDetail payrollLoanDetail2 = new PayrollLoanDetail();
                        payrollLoanDetail2.setId(payrollloanid);
                        payrollLoanDetail2.setEmployeeMaster(employeeMaster);
                        payrollLoanDetail2.setPayrollLoanType(payrollLoanType);
                        payrollLoanDetail2.setLoanAmount(opbal);
                        payrollLoanDetail2.setOpRemainingBal(opbal2);
                        payrollLoanDetail2.setMonthyInstallment(opbal2);
                        payrollLoanDetail2.setMonthlyRateAmount(opbal2);
                        payrollLoanDetail2.setStartDate(startdate);
                        payrollLoanDetail2.setEndDate(enddate);
                        payrollLoanDetail2.setInstRate(inrate);
                        payrollLoanDetail2.setMonltyEmi(monthEmi);
                        payrollLoanDetailService.update(payrollLoanDetail2);

                    }
                }

            }

            if (amount.equals("false") && (amountInt.equals("true"))) {

//                    Start payrollLoanRemainingAmount deleted
                payrollLoanRemainingAmount.setId(Integer.parseInt(excelId));
                payrollLoanRemainingAmount.setEmployeeMaster(employeeMaster);
                payrollLoanRemainingAmount.setPayrollLoanType(payrollLoanType);
                payrollLoanRemainingAmountService.delete1(payrollLoanRemainingAmount);
//            end payrollLoanRemainingAmount deleted 

//                 start Employee Deduction amount 
                List<?> payrollLoanTypeName = payrollLoanTypeService.readPayrollLoanName(payrollLoanType);
                for (Object LoanDetailAmountList1 : payrollLoanTypeName) {
                    String textloanType = (String) LoanDetailAmountList1;

                    List<?> list11 = employeeDeductionAmountService.readEmployeeloandelete(employeeSalaryProcess1, textloanType);
                    if (!list11.isEmpty()) {
                        int employeeDeductionAmount1 = (Integer) list11.get(0);
                        employeeDeductionAmountService.delete(employeeDeductionAmount1);
                    }

                    // payroll Loan Details
                    List<?> list12 = payrollLoanDetailService.readByLoanEdit(Integer.parseInt(id), Integer.parseInt(payrollid));
                    if (!list12.isEmpty()) {

                        for (Object dedSalaryList1 : list12) {
                            Object[] o = (Object[]) dedSalaryList1;
                            double LoanAmount = 0;
                            double opbal = 0;
                            double monthEmi = 0;
                            double monthlyRateAmount = 0;
                            int payrollloanid = 0;
                            LoanAmount += (Double) o[0];
                            opbal += (Double) o[2];
                            monthEmi += (Double) o[1];
                            payrollloanid += (Integer) o[3];
                            String startdate = (String) o[4];
                            String enddate = (String) o[5];
                            String inrate = (String) o[6];
                            monthlyRateAmount += (Double) o[7];
                            double opbal2 = 0;

//                        employee deduction create insert rate
                            employeeSalaryProcess.setId(employeeSalaryProcess1);
                            employeeSalaryProcess.setEmployeeMaster(employeeMaster);
                            employeeDeductionAmount.setEmployeeSalaryProcess(employeeSalaryProcess);
                            employeeDeductionAmount.setDeductionType(textloanType);
                            employeeDeductionAmount.setDeductionAmount(monthEmi);
                            employeeDeductionAmountService.create(employeeDeductionAmount);

//                         end deduction create insert rate
//                        pauyroll loan update
                            PayrollLoanDetail payrollLoanDetail2 = new PayrollLoanDetail();
                            payrollLoanDetail2.setId(payrollloanid);
                            payrollLoanDetail2.setEmployeeMaster(employeeMaster);
                            payrollLoanDetail2.setPayrollLoanType(payrollLoanType);
                            payrollLoanDetail2.setLoanAmount(LoanAmount);
                            payrollLoanDetail2.setOpRemainingBal(opbal);
                            payrollLoanDetail2.setMonthyInstallment(monthEmi);
                            payrollLoanDetail2.setMonthlyRateAmount(monthlyRateAmount);
                            payrollLoanDetail2.setStartDate(startdate);
                            payrollLoanDetail2.setEndDate(enddate);
                            payrollLoanDetail2.setInstRate(inrate);
                            payrollLoanDetail2.setMonltyEmi(monthEmi);
                            payrollLoanDetailService.update(payrollLoanDetail2);

                        }
                    }
                }
            }

        }
        if (amount.equals("false") && (amountInt.equals("false"))) {
            request.setAttribute("failureMessage", "Information : Select One checkBox.");
            mv = searchSalarySlipDetail(request, response);
        } else {
            request.setAttribute("successMessage", "Information : Delete Successfully.");
            mv = searchSalarySlipDetail(request, response);

        }
        return mv;
    }

    public ModelAndView printAllViewIndiviualSalarySlip(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        EmployeeSalaryProcess employeeSalaryProcess = new EmployeeSalaryProcess();
        DesignationMaster designationMaster = new DesignationMaster();
        DepartmentMaster departmentMaster = new DepartmentMaster();
        EmployeeExcelRecord employeeExcelRecord = new EmployeeExcelRecord();
//        EmployeeMaster employeeMaster = new EmployeeMaster();
        String[] checkId = request.getParameterValues("checkId");
        List<?> employeeAdditionalList = null;
        List<?> employeeSalaryProcessList = null;
        List<?> employeeDeductionList = null;
        List<?> employeeAddDeductionList = null;
        List<?> employeeExcelRecordList = null;
        List<?> loanRemainigAmount = null;
        List<?> empSalaryList = null;
        List Addfinallist3 = new ArrayList();
        List Addfinalexcelrecordlist = new ArrayList();
        List Addfinallist2 = new ArrayList();
        EmployeeMaster employeeMaster = new EmployeeMaster();
//        double totalDeductionAmount = 0;
        double totalDeductionAmount2 = 0;
        double total = 0;
        double nettotal = 0;
        double basicSalary = 0;
        String month = null;
        String year = null;
        int days1 = 0;
        for (String empsalryid : checkId) {
            List Addfinallist = new ArrayList();

            DecimalFormat df = new DecimalFormat("####0.00");
            empSalaryList = employeeSalaryProcessService.readEmployeeMasterID(Integer.parseInt(empsalryid));
            if (!empSalaryList.isEmpty()) {
                for (Object dedSalaryList1 : empSalaryList) {
                    Object[] o = (Object[]) dedSalaryList1;
                    double employeeLwp = 0;
                    double employeeBasicSalary = 0;
                    int employeeMasterID = 0;
                    employeeBasicSalary += (Double) o[3];
                    employeeMasterID += (Integer) o[1];
                    month = (String) o[4];
                    year = (String) o[5];

                    Calendar cal3 = Calendar.getInstance();
                    cal3.set(Calendar.MONTH, (Integer.parseInt(month) - 1));
                    days1 = cal3.getActualMaximum(Calendar.DAY_OF_MONTH);

                    employeeMaster = employeeMasterService.readById(employeeMasterID);
                    designationMaster = designationMasterService.readById(employeeMaster.getDesignationMaster().getId());
                    departmentMaster = departmentMasterService.readById(employeeMaster.getDepartmentMaster().getId());
                    employeeMaster.setDesignationMaster(designationMaster);
                    employeeMaster.setDepartmentMaster(departmentMaster);
                    employeeSalaryProcess.setEmployeeMaster(employeeMaster);
                    employeeSalaryProcess.setMonth(month);
                    employeeSalaryProcess.setYear(year);
                    employeeSalaryProcessList = employeeSalaryProcessService.readEmployeeForSalaryinfo(employeeSalaryProcess);

                    if (!employeeSalaryProcessList.isEmpty()) {
                        basicSalary = (Double) employeeSalaryProcessList.get(0);
                    }
                    employeeAdditionalList = employeeAdditionalSalaryService.readEmployeeForSalaryAdditionalinfo(employeeSalaryProcess);
                    employeeDeductionList = employeeDeductionAmountService.readEmployeeForSalaryDeductioninfo(employeeSalaryProcess);
                    employeeAddDeductionList = employeeDeductionAmountService.readEmployeeForSalaryAddDeductioninfo(employeeSalaryProcess);
                    employeeExcelRecordList = employeeExcelRecordService.readByEmployeExcelReport(employeeSalaryProcess);
                    loanRemainigAmount = payrollLoanDetailService.readByloanRemainingAmountslip(employeeMaster.getId(), employeeSalaryProcess.getMonth(), employeeSalaryProcess.getYear());
//       

                    employeeExcelRecord.setEmployeeSalaryProcess(employeeSalaryProcess);
                    double totalDeductionAmount = 0;
                    Iterator itr = employeeAddDeductionList.iterator();
                    while (itr.hasNext()) {
                        totalDeductionAmount += (Double) itr.next();
                    }

                    totalDeductionAmount2 = totalDeductionAmount;
                    List<?> employeeAddAdditionalList = employeeAdditionalSalaryService.readEmployeeForSalaryAddAdditionalinfo(employeeSalaryProcess);
                    double totalAdditionalAmount = 0;
                    Iterator itr1 = employeeAddAdditionalList.iterator();
                    while (itr1.hasNext()) {
                        totalAdditionalAmount += (Double) itr1.next();
                    }
                    total = basicSalary + totalAdditionalAmount;
//      

                    nettotal = total - totalDeductionAmount;

                }
            }
            Addfinallist.add(employeeMaster);//0
            Addfinallist.add(employeeExcelRecordList);//1
            Addfinallist.add(employeeAdditionalList);//2
            Addfinallist.add(basicSalary);//3
            Addfinallist.add(total);//4
            Addfinallist.add(employeeDeductionList);//5
            Addfinallist.add(totalDeductionAmount2);//6
            Addfinallist.add(nettotal);//7
            Addfinallist.add(loanRemainigAmount);//8
            Addfinallist.add(month);//9
            Addfinallist.add(year);//10
            Addfinallist3.add(Addfinallist);

        }
        DisplaymorNotes displaymorNotes = new DisplaymorNotes();
        List list = displaymorNotesService.read();
        for (Object o : list) {
            displaymorNotes = (DisplaymorNotes) o;

        }
        String notes = displaymorNotes.getPayrollNotes();
//                mv.getModelMap().put("employeeSalaryProcessList", employeeSalaryProcessList);
//                mv.getModelMap().put("employeeAdditionalList", employeeAdditionalList);
//                mv.getModelMap().put("employeeDeductionList", employeeDeductionList);
//                mv.getModelMap().put("totalDeductionAmount", totalDeductionAmount);
//                mv.getModelMap().put("total", total);
//                mv.getModelMap().put("nettotal", nettotal);
        mv.getModelMap().put("Addfinallist3", Addfinallist3);

//                request.setAttribute("employeeMaster", employeeMaster);
//                request.setAttribute("basicSalary", basicSalary);
//                request.setAttribute("employeeExcelRecordList", employeeExcelRecordList);
//                request.setAttribute("loanRemainigAmount", loanRemainigAmount);
        request.setAttribute("notes", notes);
        request.setAttribute("nettotal", nettotal);
        request.setAttribute("month", month);
        request.setAttribute("year", year);
        request.setAttribute("days1", days1);
        mv.setViewName("Payroll/PrintSalarySlip");
//            ;
//            ;

        return mv;
    }

}
