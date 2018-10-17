/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.model.CtcAllowance;
import com.bul.zydex.model.EmployeeAdditionalSalary;
import com.bul.zydex.model.EmployeeAdvanceSearch;
import com.bul.zydex.model.EmployeeCtcDetailSalary;
import com.bul.zydex.model.EmployeeDeductionAmount;
import com.bul.zydex.model.EmployeeExcelRecord;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.EmployeeSalaryProcess;
import com.bul.zydex.model.EmployeeShiftData;
import com.bul.zydex.model.EmployeeSubType;
import com.bul.zydex.model.EmployeeType;
import com.bul.zydex.model.PayrollAdditionalAmount;
import com.bul.zydex.model.PayrollBonus;
import com.bul.zydex.model.PayrollDeduction;
import com.bul.zydex.model.PayrollEsicDeduction;
import com.bul.zydex.model.PayrollLoanDetail;
import com.bul.zydex.model.PayrollLoanRemainingAmount;
import com.bul.zydex.model.PayrollLoanType;
import com.bul.zydex.model.PayrollPfRecord;
import com.bul.zydex.model.PayrollProfessionalTax;
import com.bul.zydex.model.PayrollProvidentFund;
import com.bul.zydex.model.PayrollRecurringAdditionalAmount;
import com.bul.zydex.model.PayrollRecurringDeduction;
import com.bul.zydex.model.PayrollSalaryLock;
import com.bul.zydex.model.PayrollTaxRateMaster;
import com.bul.zydex.model.PolicyMaster;
import com.bul.zydex.model.RetirementAge;
import com.bul.zydex.model.TaxSavingSubmit;
import com.bul.zydex.util.DownloadFile;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Irfan <irfanbhindawala@gmail.com>
 */
public class EmployeeSalaryProcessController extends EmployeeSalaryProcessAbstract {

    public ModelAndView searchEmpSalDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeSalaryProcess employeeSalaryProcess = new EmployeeSalaryProcess();
        List<?> list = (List<?>) request.getAttribute("employeelist");
        zydexLocationList(request);
        EmployeeTypeList(request);
        EmployeeSubTypeList(request);
        request.setAttribute("search", request.getParameter("search"));
        mv.getModelMap().put("employeeSalaryProcess", employeeSalaryProcess);
        request.setAttribute("employeelist", list);
        mv.setViewName("Payroll/EmployeeSalDetailSearch");
        return mv;
    }

    public ModelAndView searchEmpLeaveDetailSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeSalaryProcess employeeSalaryProcess = new EmployeeSalaryProcess();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeType employeeType = new EmployeeType();
        EmployeeSubType employeeSubType = new EmployeeSubType();

        String zydex_location_id = request.getParameter("zydexLocationMasterId");
        String type_of_employee = request.getParameter("employeeTypeMasterId");
        String employee_sub_id = request.getParameter("subTypeId");
        String payment_type = request.getParameter("paymentType");
        String month1 = request.getParameter("month");
        String year11 = request.getParameter("year11");
//       

        if (!zydex_location_id.equals("")) {
            employeeMaster.setAdharCard(zydex_location_id);
        }

        if (!type_of_employee.equals("")) {
            employeeMaster.setEmployeeType(type_of_employee);
        }
        if (null != employee_sub_id && !employee_sub_id.equals("")) {
            employeeMaster.setCompany(employee_sub_id);
        }

        if (!payment_type.equals("")) {
            employeeMaster.setPaymentType(payment_type);

        }

        List<?> list = employeeSalaryProcessService.readEmployeeForSalary(employeeMaster);
//        mv.getModelMap().put("leavelist", list);
        request.setAttribute("employeelist", list);
        request.setAttribute("month", month1);
        request.setAttribute("year", year11);
        mv = searchEmpSalDetail(request, response);
//        mv.setViewName("Leave/LeaveEmployeeDetailResult");
        return mv;
    }

    public ModelAndView createSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeSalaryProcess employeeSalaryProcess = new EmployeeSalaryProcess();
        EmployeeAdditionalSalary employeeAdditionalSalary = new EmployeeAdditionalSalary();
        EmployeeDeductionAmount employeeDeductionAmount = new EmployeeDeductionAmount();
        EmployeeExcelRecord employeeExcelRecord = new EmployeeExcelRecord();
        int employeeListLength = Integer.parseInt(request.getParameter("employeeListLength"));
        String month = request.getParameter("month");
        String year = request.getParameter("year");
        PayrollSalaryLock payrollSalaryLock = new PayrollSalaryLock();
        List<?> list13 = payrollSalaryLockService.read();
        boolean checkLock = true;
        if (!list13.isEmpty()) {
            payrollSalaryLock = (PayrollSalaryLock) list13.get(0);
            int pMonth = Integer.parseInt(payrollSalaryLock.getPmonth());
            int pYear = Integer.parseInt(payrollSalaryLock.getPyear());
            if (Integer.parseInt(month) <= pMonth && Integer.parseInt(year) <= pYear) {
                checkLock = false;
            }

        }

        //////////////////////////////////SalaryLock/////////////////////////
        if (checkLock) {

            for (int i = 1; i <= employeeListLength; i++) {
                String empId = request.getParameter("empId" + i);
                EmployeeMaster employeeMaster = employeeMasterService.readById(Integer.parseInt(empId));
                double basicSalary = Double.parseDouble(employeeMaster.getBasicSalary());
                String lwpText = request.getParameter("lwpText" + i);
                double lwp = Double.parseDouble(lwpText);

                String leaveText = request.getParameter("leaveText" + i);
                double leaveTxt = Double.parseDouble(leaveText);

                Calendar cal = Calendar.getInstance();
                cal.set(Calendar.MONTH, (Integer.parseInt(month) - 1));
                int days = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
                double basicSalary1 = basicSalary - (basicSalary * lwp / days);

                employeeSalaryProcess.setEmployeeMaster(employeeMaster);
                employeeSalaryProcess.setMonth(month);
                employeeSalaryProcess.setYear(year);

                List<?> list11 = employeeDeductionAmountService.readByDedutionSalaryAmount(employeeSalaryProcess);
                for (Object pdf1 : list11) {
                    employeeDeductionAmount = (EmployeeDeductionAmount) pdf1;
//                 Object[] o1=(Object[]) pdf;

                    employeeDeductionAmountService.delete(employeeDeductionAmount.getId());
                }

                List<?> list1 = employeeAdditionalSalaryService.readByAdditionalSalaryAmount(employeeSalaryProcess);
                for (Object pdf : list1) {
                    employeeAdditionalSalary = (EmployeeAdditionalSalary) pdf;
//                 Object[] o1=(Object[]) pdf;

                    employeeAdditionalSalaryService.delete(employeeAdditionalSalary.getId());
                }

                List<?> list = employeeSalaryProcessService.readByEmployeeSalaryProcess(employeeSalaryProcess);
                for (Object o : list) {
                    employeeSalaryProcess = (EmployeeSalaryProcess) o;
                    employeeSalaryProcessService.delete(employeeSalaryProcess.getId());
                }

                employeeSalaryProcess.setEmployeeLwp(Double.parseDouble(lwpText));
                employeeSalaryProcess.setEmployeeLeaveEncashment(Double.parseDouble(leaveText));
                employeeSalaryProcess.setEmployeeBasicSalary(basicSalary1);
                employeeSalaryProcessService.create(employeeSalaryProcess);
                checkAdditionDaywise(employeeSalaryProcess);

            }

            request.setAttribute("successMessage",
                    "Information: The Assign Salary is Updated successfully");

        } else {

            request.setAttribute("failureMessage",
                    "Information:  Salary is a Already Lock ");

        }

        mv = searchEmpSalDetail(request, response);

        return mv;
    }

    private void checkAdditionDaywise(EmployeeSalaryProcess employeeSalaryProcess) throws Exception {

        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeAdditionalSalary employeeAdditionalSalary = new EmployeeAdditionalSalary();
        employeeMaster = employeeMasterService.readById(employeeSalaryProcess.getEmployeeMaster().getId());

        List<?> list = employeeTypeWiseSalaryService.readForAdditionalAmount(employeeMaster.getEmployeeTypeMaster().getId(),
                employeeMaster.getEmployeeSubType().getId());

        for (Iterator<? extends Object> iterator = list.iterator(); iterator.hasNext();) {
            Object[] next = (Object[]) iterator.next();
            int id = (Integer) next[0];
            String salaryType = next[1].toString();
            String amountType = next[2].toString();
            double amount = (Double) next[3];
            employeeAdditionalSalary.setEmployeeSalaryProcess(employeeSalaryProcess);
            employeeAdditionalSalary.setPayrollSalaryType(salaryType);
            Double lwp = 0.0;
            if (amountType.equals("Amount")) {
                int days = 30;
                lwp = employeeSalaryProcess.getEmployeeLwp();
//                double basicSalary = employeeSalaryProcess.getEmployeeBasicSalary();
                double amount1 = amount - (amount * lwp / days);
                employeeAdditionalSalary.setAdditionalAmount(amount1);
            } else {
                double basicSalary = employeeSalaryProcess.getEmployeeBasicSalary();
                double additionalAmount = (amount / 100) * basicSalary;
                employeeAdditionalSalary.setAdditionalAmount(additionalAmount);
            }
            employeeAdditionalSalaryService.create(employeeAdditionalSalary);
        }
        List daywiseAdditionalAmountList = payrollAdditionalAmountService.readDayWiseAdditionalAmount(employeeSalaryProcess);
        double additionalAmount = 0;
        if (!daywiseAdditionalAmountList.isEmpty()) {
            PayrollAdditionalAmount payrollAdditionalAmount = (PayrollAdditionalAmount) daywiseAdditionalAmountList.get(0);
            additionalAmount += Double.parseDouble(payrollAdditionalAmount.getAmount());
        }

        List recurringAdditionalAmountList = payrollRecurringAdditionalAmountService.readRecurringAdditionalAmount(employeeSalaryProcess);
        if (!recurringAdditionalAmountList.isEmpty()) {
            PayrollRecurringAdditionalAmount payrollRecurringAdditionalAmount = (PayrollRecurringAdditionalAmount) recurringAdditionalAmountList.get(0);
            additionalAmount += Double.parseDouble(payrollRecurringAdditionalAmount.getAmount());
        }

        if (!daywiseAdditionalAmountList.isEmpty() || !recurringAdditionalAmountList.isEmpty()) {
            employeeAdditionalSalary.setEmployeeSalaryProcess(employeeSalaryProcess);
            employeeAdditionalSalary.setPayrollSalaryType("Additional Amount");
            employeeAdditionalSalary.setAdditionalAmount(additionalAmount);
            employeeAdditionalSalaryService.create(employeeAdditionalSalary);
        }
        double bonusAmount = 0;
        List bonusAmountList1 = payrollBonusService.readBonusAmount(employeeSalaryProcess);
        if (!bonusAmountList1.isEmpty()) {
            PayrollBonus payrollBonus = (PayrollBonus) bonusAmountList1.get(0);
            bonusAmount += Double.parseDouble(payrollBonus.getAmount());
        }
        if (!bonusAmountList1.isEmpty()) {
            employeeAdditionalSalary.setEmployeeSalaryProcess(employeeSalaryProcess);
            employeeAdditionalSalary.setPayrollSalaryType("Bonus");
            employeeAdditionalSalary.setAdditionalAmount(bonusAmount);
            employeeAdditionalSalaryService.create(employeeAdditionalSalary);
        }
        /////////////////////policy Start Here///////////////////////
        employeeMaster = employeeMasterService.readById(employeeSalaryProcess.getEmployeeMaster().getId());
        List<?> PolicyAmountList = employeePolicyDetailService.readPolicy(employeeSalaryProcess.getEmployeeMaster().getId());
        if (!PolicyAmountList.isEmpty()) {

            for (Object PolicyAmountList1 : PolicyAmountList) {
                Object[] o = (Object[]) PolicyAmountList1;
                String policyName = (String) o[1];
                Double PolicyAmount = (Double) o[0];
                Double employeeLwp = employeeSalaryProcess.getEmployeeLwp();
                Calendar cal = Calendar.getInstance();
                cal.set(Calendar.MONTH, (Integer.parseInt(employeeSalaryProcess.getMonth()) - 1));
                int days = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
                double PolicyAmount1 = PolicyAmount - (PolicyAmount * employeeLwp / days);
                employeeAdditionalSalary.setEmployeeSalaryProcess(employeeSalaryProcess);
                employeeAdditionalSalary.setPayrollSalaryType(policyName);
                employeeAdditionalSalary.setAdditionalAmount(PolicyAmount1);
                employeeAdditionalSalaryService.create(employeeAdditionalSalary);

            }
        }
        EmployeeCtcDetailSalary employeeCtcDetailSalary1 = new EmployeeCtcDetailSalary();
        //// ctc delete allowance 
        List<?> list32 = employeeCtcDetailSalaryService.readByEmployeCtcReport(employeeSalaryProcess.getEmployeeMaster().getId(), employeeSalaryProcess.getMonth(), employeeSalaryProcess.getYear());
        for (Object o : list32) {
            employeeCtcDetailSalary1 = (EmployeeCtcDetailSalary) o;
            employeeCtcDetailSalaryService.delete(employeeCtcDetailSalary1.getId());
        }

        /////////////ctc ALLOWANCE
        employeeMaster = employeeMasterService.readById(employeeSalaryProcess.getEmployeeMaster().getId());
        List<?> CTCAMOUNTtList = employeeCtcDetailService.readEmployeeCtcDetail(employeeSalaryProcess.getEmployeeMaster().getId());
        if (!CTCAMOUNTtList.isEmpty()) {

            for (Object ctcAmountList1 : CTCAMOUNTtList) {
                Object[] o = (Object[]) ctcAmountList1;
                String ctcName = (String) o[1];
                Double ctcAmount = (Double) o[0];
                Integer ctcid = (Integer) o[2];
                String month = (String) o[3];
                String year = (String) o[4];
                EmployeeCtcDetailSalary employeeCtcDetailSalary = new EmployeeCtcDetailSalary();
                employeeCtcDetailSalary.setAmount(ctcAmount);
                CtcAllowance ctcAllowance = new CtcAllowance();
                ctcAllowance.setId(ctcid);
                employeeCtcDetailSalary.setCtcAllowance(ctcAllowance);
                employeeCtcDetailSalary.setEmployeeMaster(employeeMaster);
                employeeCtcDetailSalary.setMonth(employeeSalaryProcess.getMonth());
                employeeCtcDetailSalary.setYear(employeeSalaryProcess.getYear());
                employeeCtcDetailSalary.setMonthly(month);
                employeeCtcDetailSalary.setYearly(year);
                employeeCtcDetailSalaryService.create(employeeCtcDetailSalary);
                List<?> employeeCtcList = employeeCtcDetailSalaryService.readEmployeeCtcDetailSalary(employeeSalaryProcess.getEmployeeMaster().getId(), employeeSalaryProcess.getMonth(), employeeSalaryProcess.getYear(), ctcid);
                if (!employeeCtcList.isEmpty()) {
                    for (Object employeeCtcList1 : employeeCtcList) {
                        Object[] o1 = (Object[]) employeeCtcList1;
                        if (null != o1[1] && null != o1[0]) {
                            String ctcName1 = (String) o1[1];
                            Double ctcAmount1 = (Double) o1[0];
                            employeeAdditionalSalary.setEmployeeSalaryProcess(employeeSalaryProcess);
                            employeeAdditionalSalary.setPayrollSalaryType(ctcName1);
                            employeeAdditionalSalary.setAdditionalAmount(ctcAmount1);
                            employeeAdditionalSalaryService.create(employeeAdditionalSalary);

                        }

                    }

                }

            }
        }

        ///////////////////////////////leave encashment/////////////////////////////////
//        double basicSalary = Double.parseDouble(employeeMaster.getBasicSalary());
//        double leave = employeeSalaryProcess.getEmployeeLeaveEncashment();
//
//        Calendar cal = Calendar.getInstance();
//        cal.set(Calendar.MONTH, (Integer.parseInt(employeeSalaryProcess.getMonth()) - 1));
//        int days = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
//        double leaveTotal = (basicSalary * leave / days);
//
//        employeeAdditionalSalary.setEmployeeSalaryProcess(employeeSalaryProcess);
//        employeeAdditionalSalary.setPayrollSalaryType("leave Encashment");
//        employeeAdditionalSalary.setAdditionalAmount(leaveTotal);
//        employeeAdditionalSalaryService.create(employeeAdditionalSalary);
    }

    private void checkDeductionwise(EmployeeSalaryProcess employeeSalaryProcess) throws Exception {
        int empId = employeeSalaryProcess.getEmployeeMaster().getId();
        EmployeeMaster employeeMaster1 = employeeMasterService.readById(empId);
        EmployeeDeductionAmount employeeDeductionAmount = new EmployeeDeductionAmount();
        PayrollEsicDeduction payrollEsicDeduction = new PayrollEsicDeduction();
        List daywiseDeductionAmountList = payrollDeductionService.readDayWiseDeductionAmount(employeeSalaryProcess);
        double deductionAmount = 0;
        if (!daywiseDeductionAmountList.isEmpty()) {
            PayrollDeduction payrollDeduction = (PayrollDeduction) daywiseDeductionAmountList.get(0);
            deductionAmount += Double.parseDouble(payrollDeduction.getAmount());
        }

        List recurringDeductionAmountList = payrollRecurringDeductionService.readRecurringDeductionAmount(employeeSalaryProcess);
        if (!recurringDeductionAmountList.isEmpty()) {
            PayrollRecurringDeduction payrollRecurringDeduction = (PayrollRecurringDeduction) recurringDeductionAmountList.get(0);
            deductionAmount += Double.parseDouble(payrollRecurringDeduction.getAmount());
        }

        if (!daywiseDeductionAmountList.isEmpty() || !recurringDeductionAmountList.isEmpty()) {
            employeeDeductionAmount.setEmployeeSalaryProcess(employeeSalaryProcess);
            employeeDeductionAmount.setDeductionType("Deduction Amount");
            employeeDeductionAmount.setDeductionAmount(deductionAmount);
            employeeDeductionAmountService.create(employeeDeductionAmount);
        }
        ///////////////////////PF Start Here///////////////////////

        EmployeeMaster employeeMaster = new EmployeeMaster();
        PayrollPfRecord payrollPfRecord = new PayrollPfRecord();
        employeeMaster = employeeMasterService.readById(employeeSalaryProcess.getEmployeeMaster().getId());
        if (employeeMaster1.getPf() == true) {
            boolean pfFlag = payrollPfCheckService.readForPfCheck(employeeMaster.getEmployeeTypeMaster().getId(),
                    employeeMaster.getEmployeeSubType().getId());

            if (pfFlag) {
                List<?> pfAmountList = payrollProvidentFundService.readPf(employeeMaster.getZydexLocationMaster().getId());
//         for (Object oPf : pfAmountList) {
                double maxiAmount = 0;
                double maxiAmountConbrutionEmployer = 0;
                double basicSalarypf = 0;
//                double edilimaxiAmountConbrutionEmployer = 0;
                if (!pfAmountList.isEmpty()) {
                    PayrollProvidentFund payrollProvidentFund = (PayrollProvidentFund) pfAmountList.get(0);
                    double basicSalary = employeeSalaryProcess.getEmployeeBasicSalary();
                    double pf = Double.parseDouble(payrollProvidentFund.getPfPercentage());
                    double pfEmployeer = Double.parseDouble(payrollProvidentFund.getEpfPercentage());
                    double EDilpfEmployeer = Double.parseDouble(payrollProvidentFund.getApfPercentage());
                    double maxAmountfromPf = Double.parseDouble(payrollProvidentFund.getMaximumBasicAmount());
                    double mimAmountfromPf = Double.parseDouble(payrollProvidentFund.getMiniBasicAmount());
                    basicSalarypf = Double.parseDouble(employeeMaster.getBasicSalary());
                    maxiAmount = Double.parseDouble(employeeMaster.getPfAmount());
                    maxiAmountConbrutionEmployer = Double.parseDouble(employeeMaster.getPfAmountEmployer());
                    String dayofbirth = employeeMaster.getDateOfBirth();
                    String birthyear = dayofbirth.substring(6, 10);
                    Calendar cal = Calendar.getInstance();
                    int year2 = cal.get(cal.YEAR);
                    int diffYear = year2 - Integer.parseInt(birthyear);
                    RetirementAge retirementAge = new RetirementAge();
                    List<?> retirementAgeList = retirementAgeService.read();
                    retirementAge = (RetirementAge) retirementAgeList.get(0);
                    String ages = retirementAge.getRetireAge();
/// pf mannual 9126 calculation 

//                    edilimaxiAmountConbrutionEmployer = Double.parseDouble(employeeMaster.get);
                    double taxpf = 0;
                    double minitaxpf = 0;
                    double taxpfConbrutionEmployer = 0;
                    double taxpfConbrutionEmployerEdili = 0;

                    Calendar cal4 = Calendar.getInstance();
                    cal4.set(Calendar.MONTH, (Integer.parseInt(employeeSalaryProcess.getMonth()) - 1));
                    int days2 = cal4.getActualMaximum(Calendar.DAY_OF_MONTH);
                    if (maxiAmount != 0) {
                        if (maxiAmount <= maxAmountfromPf) {
                            if (maxAmountfromPf <= basicSalary) {

                                double lwp = employeeSalaryProcess.getEmployeeLwp();
                                minitaxpf = maxAmountfromPf * lwp / days2;
                                minitaxpf = maxAmountfromPf - minitaxpf;

                                taxpf = (minitaxpf * pf / 100);//12

                                employeeDeductionAmount.setEmployeeSalaryProcess(employeeSalaryProcess);
                                employeeDeductionAmount.setDeductionType("Provident Fund");
                                employeeDeductionAmount.setDeductionAmount(taxpf);
                                employeeDeductionAmountService.create(employeeDeductionAmount);
                                payrollPfRecord.setEmployeeSalaryProcess(employeeSalaryProcess);
                                payrollPfRecord.setEpfAmount(maxiAmount);
                                payrollPfRecord.setDiifepsEpfAmount(maxiAmountConbrutionEmployer);
                                payrollPfRecord.setEmpContrubtionEpf(taxpf);

                                if (Integer.parseInt(ages) >= diffYear) {
                                    payrollPfRecord.setEpsAmount(maxiAmountConbrutionEmployer);
                                    taxpfConbrutionEmployer = (maxiAmountConbrutionEmployer * pfEmployeer / 100);//8.33
                                    payrollPfRecord.setCompContrubtionEps(taxpfConbrutionEmployer);// epf wages calculate by 8.33 percentage of pf 
                                    taxpfConbrutionEmployerEdili = (maxiAmountConbrutionEmployer * EDilpfEmployeer / 100);//3.67
                                    payrollPfRecord.setDifferentEpsEpf(taxpfConbrutionEmployerEdili);

                                } else {
                                    payrollPfRecord.setCompContrubtionEps(taxpfConbrutionEmployer);
                                    payrollPfRecord.setEpsAmount(0.0);
                                    taxpfConbrutionEmployerEdili = (maxiAmountConbrutionEmployer * pf / 100);//3.67
                                    payrollPfRecord.setDifferentEpsEpf(taxpfConbrutionEmployerEdili);
                                }

                                payrollPfRecordService.create(payrollPfRecord);
                            } else {
                                double lwp = employeeSalaryProcess.getEmployeeLwp();
                                minitaxpf = basicSalary * lwp / days2;
                                minitaxpf = basicSalary - minitaxpf;

                                taxpf = minitaxpf * pf / 100; /// 12%

                                employeeDeductionAmount.setEmployeeSalaryProcess(employeeSalaryProcess);
                                employeeDeductionAmount.setDeductionType("Provident Fund");
                                employeeDeductionAmount.setDeductionAmount(taxpf);
                                employeeDeductionAmountService.create(employeeDeductionAmount);
                                // pf record table 
                                payrollPfRecord.setDiifepsEpfAmount(minitaxpf);
                                payrollPfRecord.setEmployeeSalaryProcess(employeeSalaryProcess);
                                payrollPfRecord.setEpfAmount(minitaxpf);
                                payrollPfRecord.setEmpContrubtionEpf(taxpf);

                                if (Integer.parseInt(ages) >= diffYear) {
                                    payrollPfRecord.setEpsAmount(minitaxpf);
                                    taxpfConbrutionEmployer = (minitaxpf * pfEmployeer / 100);/// eps 8.33%
                                    payrollPfRecord.setCompContrubtionEps(taxpfConbrutionEmployer);// epf wages calculate by 8.33 percentage of pf 
                                    taxpfConbrutionEmployerEdili = (minitaxpf * EDilpfEmployeer / 100);//3.67
                                    payrollPfRecord.setDifferentEpsEpf(taxpfConbrutionEmployerEdili);
                                } else {
                                    payrollPfRecord.setCompContrubtionEps(taxpfConbrutionEmployer);
                                    payrollPfRecord.setEpsAmount(0.0);
                                    taxpfConbrutionEmployerEdili = (minitaxpf * pf / 100);//3.67
                                    payrollPfRecord.setDifferentEpsEpf(taxpfConbrutionEmployerEdili);
                                }

//                            payrollPfRecord.setCompContrubtionEps(taxpfConbrutionEmployer);
                                payrollPfRecordService.create(payrollPfRecord);
                            }
                        } else {
                            if (maxiAmount <= basicSalary) {

                                double lwp = employeeSalaryProcess.getEmployeeLwp();
                                minitaxpf = maxiAmount * lwp / days2;
                                minitaxpf = maxiAmount - minitaxpf;

                                taxpf = (minitaxpf * pf / 100);//12

                                employeeDeductionAmount.setEmployeeSalaryProcess(employeeSalaryProcess);
                                employeeDeductionAmount.setDeductionType("Provident Fund");
                                employeeDeductionAmount.setDeductionAmount(taxpf);
                                employeeDeductionAmountService.create(employeeDeductionAmount);
                                payrollPfRecord.setEmployeeSalaryProcess(employeeSalaryProcess);
                                payrollPfRecord.setEpfAmount(minitaxpf);
                                payrollPfRecord.setDiifepsEpfAmount(maxiAmountConbrutionEmployer);
                                payrollPfRecord.setEmpContrubtionEpf(taxpf);

                                if (Integer.parseInt(ages) >= diffYear) {
                                    payrollPfRecord.setEpsAmount(maxiAmountConbrutionEmployer);
                                    taxpfConbrutionEmployer = (maxiAmountConbrutionEmployer * pfEmployeer / 100);//8.33
                                    payrollPfRecord.setCompContrubtionEps(taxpfConbrutionEmployer);// epf wages calculate by 8.33 percentage of pf 
                                    taxpfConbrutionEmployerEdili = (maxiAmountConbrutionEmployer * EDilpfEmployeer / 100);//3.67
                                    payrollPfRecord.setDifferentEpsEpf(taxpfConbrutionEmployerEdili);

                                } else {
                                    payrollPfRecord.setCompContrubtionEps(taxpfConbrutionEmployer);
                                    payrollPfRecord.setEpsAmount(0.0);
                                    taxpfConbrutionEmployerEdili = (maxiAmountConbrutionEmployer * pf / 100);//3.67
                                    payrollPfRecord.setDifferentEpsEpf(taxpfConbrutionEmployerEdili);
                                }

                                payrollPfRecordService.create(payrollPfRecord);
                            } else {
                                double lwp = employeeSalaryProcess.getEmployeeLwp();
                                minitaxpf = basicSalary * lwp / days2;
                                minitaxpf = basicSalary - minitaxpf;

                                taxpf = minitaxpf * pf / 100; /// 12%

                                employeeDeductionAmount.setEmployeeSalaryProcess(employeeSalaryProcess);
                                employeeDeductionAmount.setDeductionType("Provident Fund");
                                employeeDeductionAmount.setDeductionAmount(taxpf);
                                employeeDeductionAmountService.create(employeeDeductionAmount);
                                // pf record table 
                                payrollPfRecord.setDiifepsEpfAmount(minitaxpf);
                                payrollPfRecord.setEmployeeSalaryProcess(employeeSalaryProcess);
                                payrollPfRecord.setEpfAmount(minitaxpf);
                                payrollPfRecord.setEmpContrubtionEpf(taxpf);

                                if (Integer.parseInt(ages) >= diffYear) {
                                    payrollPfRecord.setEpsAmount(minitaxpf);
                                    taxpfConbrutionEmployer = (minitaxpf * pfEmployeer / 100);/// eps 8.33%
                                    payrollPfRecord.setCompContrubtionEps(taxpfConbrutionEmployer);// epf wages calculate by 8.33 percentage of pf 
                                    taxpfConbrutionEmployerEdili = (minitaxpf * EDilpfEmployeer / 100);//3.67
                                    payrollPfRecord.setDifferentEpsEpf(taxpfConbrutionEmployerEdili);
                                } else {
                                    payrollPfRecord.setCompContrubtionEps(taxpfConbrutionEmployer);
                                    payrollPfRecord.setEpsAmount(0.0);
                                    taxpfConbrutionEmployerEdili = (minitaxpf * pf / 100);//3.67
                                    payrollPfRecord.setDifferentEpsEpf(taxpfConbrutionEmployerEdili);
                                }

//                            payrollPfRecord.setCompContrubtionEps(taxpfConbrutionEmployer);
                                payrollPfRecordService.create(payrollPfRecord);
                            }

                        }

                    } else {

                        if (maxAmountfromPf <= basicSalary) {
                            double lwp = employeeSalaryProcess.getEmployeeLwp();
                            minitaxpf = maxAmountfromPf * lwp / days2;
                            minitaxpf = maxAmountfromPf - minitaxpf;

                            taxpf = (minitaxpf * pf / 100);//12

                            employeeDeductionAmount.setEmployeeSalaryProcess(employeeSalaryProcess);
                            employeeDeductionAmount.setDeductionType("Provident Fund");
                            employeeDeductionAmount.setDeductionAmount(taxpf);
                            employeeDeductionAmountService.create(employeeDeductionAmount);
                            payrollPfRecord.setEmployeeSalaryProcess(employeeSalaryProcess);
                            payrollPfRecord.setEpfAmount(minitaxpf);

                            payrollPfRecord.setDiifepsEpfAmount(minitaxpf);
                            payrollPfRecord.setEmpContrubtionEpf(taxpf);

                            if (Integer.parseInt(ages) >= diffYear) {
                                payrollPfRecord.setEpsAmount(minitaxpf);
                                taxpfConbrutionEmployer = (minitaxpf * pfEmployeer / 100);//8.33
                                payrollPfRecord.setCompContrubtionEps(taxpfConbrutionEmployer);// epf wages calculate by 8.33 percentage of pf  
                                taxpfConbrutionEmployerEdili = (minitaxpf * EDilpfEmployeer / 100);//3.67
                                payrollPfRecord.setDifferentEpsEpf(taxpfConbrutionEmployerEdili);
                            } else {
                                payrollPfRecord.setCompContrubtionEps(taxpfConbrutionEmployer);
                                payrollPfRecord.setEpsAmount(0.0);
                                taxpfConbrutionEmployerEdili = (minitaxpf * pf / 100);//3.67
                                payrollPfRecord.setDifferentEpsEpf(taxpfConbrutionEmployerEdili);
                            }

//                            payrollPfRecord.setCompContrubtionEps(taxpfConbrutionEmployer);
//                            payrollPfRecord.setDifferentEpsEpf(taxpfConbrutionEmployerEdili);
                            payrollPfRecordService.create(payrollPfRecord);
                        } else {

                            if (mimAmountfromPf >= basicSalarypf) {

                                Calendar cal3 = Calendar.getInstance();
                                cal3.set(Calendar.MONTH, (Integer.parseInt(employeeSalaryProcess.getMonth()) - 1));
                                int days1 = cal3.getActualMaximum(Calendar.DAY_OF_MONTH);
                                double lwp = employeeSalaryProcess.getEmployeeLwp();
                                minitaxpf = mimAmountfromPf * lwp / days1;
                                minitaxpf = mimAmountfromPf - minitaxpf;

                                taxpf = minitaxpf * pf / 100; /// 12%

                                employeeDeductionAmount.setEmployeeSalaryProcess(employeeSalaryProcess);
                                employeeDeductionAmount.setDeductionType("Provident Fund");
                                employeeDeductionAmount.setDeductionAmount(taxpf);
                                employeeDeductionAmountService.create(employeeDeductionAmount);
                                // pf record table 
//                            taxpfConbrutionEmployer = (basicSalary * pfEmployeer / 100);/// eps 8.33%

                                payrollPfRecord.setEmployeeSalaryProcess(employeeSalaryProcess);
                                payrollPfRecord.setEpfAmount(minitaxpf);

                                payrollPfRecord.setDiifepsEpfAmount(minitaxpf);
                                payrollPfRecord.setEmpContrubtionEpf(taxpf);
                                if (Integer.parseInt(ages) >= diffYear) {
                                    payrollPfRecord.setEpsAmount(minitaxpf);
                                    taxpfConbrutionEmployer = (minitaxpf * pfEmployeer / 100);/// eps 8.33%
                                    payrollPfRecord.setCompContrubtionEps(taxpfConbrutionEmployer);// epf wages calculate by 8.33 percentage of pf    
                                    taxpfConbrutionEmployerEdili = (minitaxpf * EDilpfEmployeer / 100);//3.67
                                    payrollPfRecord.setDifferentEpsEpf(taxpfConbrutionEmployerEdili);

                                } else {
                                    payrollPfRecord.setCompContrubtionEps(taxpfConbrutionEmployer);
                                    payrollPfRecord.setEpsAmount(0.0);
                                    taxpfConbrutionEmployerEdili = (minitaxpf * pf / 100);//3.67
                                    payrollPfRecord.setDifferentEpsEpf(taxpfConbrutionEmployerEdili);
                                }
//                            payrollPfRecord.setCompContrubtionEps(taxpfConbrutionEmployer);

                                payrollPfRecordService.create(payrollPfRecord);

                            } else {
                                double lwp = employeeSalaryProcess.getEmployeeLwp();
                                minitaxpf = basicSalary * lwp / days2;
                                minitaxpf = basicSalary - minitaxpf;

                                taxpf = minitaxpf * pf / 100; /// 12%

                                employeeDeductionAmount.setEmployeeSalaryProcess(employeeSalaryProcess);
                                employeeDeductionAmount.setDeductionType("Provident Fund");
                                employeeDeductionAmount.setDeductionAmount(taxpf);
                                employeeDeductionAmountService.create(employeeDeductionAmount);
                                // pf record table 
//                            taxpfConbrutionEmployer = (basicSalary * pfEmployeer / 100);/// eps 8.33%

                                payrollPfRecord.setEmployeeSalaryProcess(employeeSalaryProcess);
                                payrollPfRecord.setEpfAmount(minitaxpf);

                                payrollPfRecord.setDiifepsEpfAmount(minitaxpf);
                                payrollPfRecord.setEmpContrubtionEpf(taxpf);
                                if (Integer.parseInt(ages) >= diffYear) {
                                    payrollPfRecord.setEpsAmount(minitaxpf);
                                    taxpfConbrutionEmployer = (minitaxpf * pfEmployeer / 100);/// eps 8.33%
                                    payrollPfRecord.setCompContrubtionEps(taxpfConbrutionEmployer);// epf wages calculate by 8.33 percentage of pf    
                                    taxpfConbrutionEmployerEdili = (minitaxpf * EDilpfEmployeer / 100);//3.67
                                    payrollPfRecord.setDifferentEpsEpf(taxpfConbrutionEmployerEdili);

                                } else {
                                    payrollPfRecord.setCompContrubtionEps(taxpfConbrutionEmployer);
                                    payrollPfRecord.setEpsAmount(0.0);
                                    taxpfConbrutionEmployerEdili = (minitaxpf * pf / 100);//3.67
                                    payrollPfRecord.setDifferentEpsEpf(taxpfConbrutionEmployerEdili);
                                }
//                            payrollPfRecord.setCompContrubtionEps(taxpfConbrutionEmployer);

                                payrollPfRecordService.create(payrollPfRecord);
                            }
                        }

                    }

                }

            }
        }
        /////////////////PT Starts  here///////////
        double additionalAmt = 0;
        List<?> additionalAmount = employeeAdditionalSalaryService.readAdditionalAmount(employeeSalaryProcess.getId());
        if (!additionalAmount.isEmpty()) {
            additionalAmt = (Double) additionalAmount.get(0);
        }
        double additionalAmtwithoutOtAmount = 0;
        List<?> additionalAmtwithoutOtAmount1 = employeeAdditionalSalaryService.readNotOTamountAdditionalAmount(employeeSalaryProcess.getId());
        if (!additionalAmtwithoutOtAmount1.isEmpty()) {
            additionalAmtwithoutOtAmount = (Double) additionalAmtwithoutOtAmount1.get(0);
        }
        double deductionAmt = 0;
        List<?> deductionAmountList = employeeDeductionAmountService.readDeductionAmount(employeeSalaryProcess.getId());
        if (!deductionAmountList.isEmpty()) {
            deductionAmt = (Double) deductionAmountList.get(0);
        }
        double OTAmt = 0;
        List<?> otList = employeeSalaryProcessService.readOTAmounts(employeeSalaryProcess.getId());
        if (!otList.isEmpty()) {
            OTAmt = (Double) otList.get(0);
        }

        double netSalary = (employeeSalaryProcess.getEmployeeBasicSalary() + additionalAmt);
        double netSalarywithOtamount = (employeeSalaryProcess.getEmployeeBasicSalary() + additionalAmtwithoutOtAmount);
        double netSalarywithOtamount1 = (Double.parseDouble(employeeMaster.getBasicSalary()) + additionalAmtwithoutOtAmount);
        if (employeeMaster1.getPt() == true) {
            boolean ptFlag = payrollPtCheckService.readForPTCheck(employeeMaster.getEmployeeTypeMaster().getId(),
                    employeeMaster.getEmployeeSubType().getId());
            if (ptFlag) {
                double ptAmount = 0;
                List<?> ptAmountList = payrollProfessionalTaxService.read();
                PayrollProfessionalTax payrollProfessionalTax = new PayrollProfessionalTax();
                for (Iterator<? extends Object> iterator = ptAmountList.iterator(); iterator.hasNext();) {
                    payrollProfessionalTax = (PayrollProfessionalTax) iterator.next();
                    double salaryForm = Double.parseDouble(payrollProfessionalTax.getSalaryFrom());
                    double salaryTo = Double.parseDouble(payrollProfessionalTax.getSalaryTo());

                    if (netSalary >= salaryForm && netSalary <= salaryTo) {
//                if (salaryForm >= netSalary && salaryTo <= netSalary) {

                        break;

                    } else {
                        iterator.remove();
                    }
                }

//            List<?> ptAmountList = payrollProfessionalTaxService.readPT(netSalary);
                if (!ptAmountList.isEmpty()) {
                    ptAmount = Double.parseDouble(payrollProfessionalTax.getAmount());

                    employeeDeductionAmount.setEmployeeSalaryProcess(employeeSalaryProcess);
                    employeeDeductionAmount.setDeductionType("Professional Tax");
                    employeeDeductionAmount.setDeductionAmount(ptAmount);
                    employeeDeductionAmountService.create(employeeDeductionAmount);
                }
            }
        }
//        TDs start here
//        double tdsAmount = Double.parseDouble(employeeMaster1.getTdsAmount());
//        if (tdsAmount != 0) {
//
//            employeeDeductionAmount.setEmployeeSalaryProcess(employeeSalaryProcess);
//            employeeDeductionAmount.setDeductionType("TDS");
//            employeeDeductionAmount.setDeductionAmount(tdsAmount);
//            employeeDeductionAmountService.create(employeeDeductionAmount);
//        }
        /// tds end here  
        ////////////////////// PT Ends Here ///////////////////////////
        /////////////////////ESIC Start Here///////////////////////
        double grossTotalEsic = 0.0;
        double additionalAmtwithoutOtAmount12 = 0;
        List<?> additionalAmtwithoutOtAmount121 = employeeAdditionalSalaryService.readNotOTamountAdditionalAmountSPC(employeeSalaryProcess.getId());
        if (!additionalAmtwithoutOtAmount121.isEmpty()) {
            additionalAmtwithoutOtAmount12 = (Double) additionalAmtwithoutOtAmount121.get(0);
        }

        double netSalarywithOtamount1125 = (Double.parseDouble(employeeMaster.getBasicSalary()) + additionalAmtwithoutOtAmount12);

        grossTotalEsic = netSalarywithOtamount1125;
        if (employeeMaster1.getEsic() == true) {

            double nettotalEsic = 0;
            double emptotalEsic = 0;
            double comptotalEsic = 0;
            double otEsic = 0;
            double otEsicNet = 0;
            if (grossTotalEsic <= 21000) {

                nettotalEsic = netSalary * 1.75 / 100;
//emp contrubtion of esic
                emptotalEsic = netSalary * 1.75 / 100;
//            comp contribution of netSalary
                comptotalEsic = netSalary * 4.75 / 100;
//            Ot Esic 
                otEsic = OTAmt * 1.75 / 100;
                otEsicNet = OTAmt - otEsic;

                employeeDeductionAmount.setEmployeeSalaryProcess(employeeSalaryProcess);
                employeeDeductionAmount.setDeductionType("E.S.I.C");
                employeeDeductionAmount.setDeductionAmount(nettotalEsic);
                employeeDeductionAmountService.create(employeeDeductionAmount);
                payrollEsicDeduction.setEmployeeSalaryProcess(employeeSalaryProcess);
                payrollEsicDeduction.setEmpContrubtion(emptotalEsic);
                payrollEsicDeduction.setCompContrubtion(comptotalEsic);
                payrollEsicDeduction.setOtEsic(otEsic);
                payrollEsicDeduction.setOtEsicNet(otEsicNet);
                payrollEsicDeductionService.create(payrollEsicDeduction);

            }
        }

        /////////////////////ESIC End Here///////////////////////
//        /////////////////////policy Start Here///////////////////////
//        employeeMaster = employeeMasterService.readById(employeeSalaryProcess.getEmployeeMaster().getId());
//        List<?> PolicyAmountList = employeePolicyDetailService.readPolicy(employeeSalaryProcess.getEmployeeMaster().getId());
//        if (!PolicyAmountList.isEmpty()) {
//            double PolicyAmount = 0;
//            Iterator itr2 = PolicyAmountList.iterator();
//            while (itr2.hasNext()) {
//                Object[] next = (Object[]) itr2.next();
//                PolicyAmount += (Double) next[0];
//            }
////            double basicSalary = employeeSalaryProcess.getEmployeeBasicSalary();
////            for (Object PolicyAmountList1 : PolicyAmountList) {
////                Object[] o = (Object[]) PolicyAmountList1;
////                String policyName = (String) o[1];
////                Double PolicyAmount = (Double) o[0];
//
////                double total = basicSalary - PolicyAmount;
//            employeeDeductionAmount.setEmployeeSalaryProcess(employeeSalaryProcess);
//            employeeDeductionAmount.setDeductionType("L.I.C");
//            employeeDeductionAmount.setDeductionAmount(PolicyAmount);
//            employeeDeductionAmountService.create(employeeDeductionAmount);
//
////            }
//        }
        /////////////////////policy end Here///////////////////////
        /////////////////////Loan Start Here///////////////////////
        PayrollLoanRemainingAmount payrollLoanRemainingAmount1 = new PayrollLoanRemainingAmount();
        List<?> list1 = payrollLoanRemainingAmountService.readByLoanReaminingAmount(employeeSalaryProcess);

        if (null != list1 && !list1.isEmpty()) {

            for (Object pdf : list1) {
                payrollLoanRemainingAmount1 = (PayrollLoanRemainingAmount) pdf;
//                 Object[] o1=(Object[]) pdf;

                payrollLoanRemainingAmountService.delete(payrollLoanRemainingAmount1.getId());
            }

            employeeMaster = employeeMasterService.readById(employeeSalaryProcess.getEmployeeMaster().getId());
            PayrollLoanDetail payrollLoanDetail1 = new PayrollLoanDetail();
            String month = employeeSalaryProcess.getMonth();
            String year = employeeSalaryProcess.getYear();
            List<?> LoanDetailAmountList = payrollLoanDetailService.readLoanDetailsUpdate(empId, month, year);
            for (Object LoanDetailAmountList1 : LoanDetailAmountList) {
                Object[] o = (Object[]) LoanDetailAmountList1;
                double basicSalary = employeeSalaryProcess.getEmployeeBasicSalary();
                Double opbal = 0.0;
                Double loanAmount = (Double) o[0];
                Double monltyEmi = (Double) o[1];
                String instRate = (String) o[2];
                String textloanType = (String) o[3];
                int payrollloantypeid = (int) o[4];
                int payrollloanDetailsid = (int) o[5];
                opbal = (Double) o[6];
                double instRate1 = Double.parseDouble(instRate);
                double monthtyIntRate = 0;
                double TotalMonthly = 0;
                double monthlycutfromSalary = 0;
                double remaningAmount = 0;

                monthtyIntRate = (opbal * instRate1 / 100);
                TotalMonthly = (monthtyIntRate + monltyEmi);
                monthlycutfromSalary = (basicSalary - TotalMonthly);
                remaningAmount = (opbal - monltyEmi);

                employeeDeductionAmount.setEmployeeSalaryProcess(employeeSalaryProcess);
                employeeDeductionAmount.setDeductionType(textloanType);
                employeeDeductionAmount.setDeductionAmount(TotalMonthly);
                employeeDeductionAmountService.create(employeeDeductionAmount);
                PayrollLoanType payrollLoanType = payrollLoanTypeService.readById(payrollloantypeid);
                PayrollLoanDetail payrollloandetails = payrollLoanDetailService.readById(payrollloanDetailsid);

                payrollloandetails.setEmployeeMaster(employeeMaster);

                payrollloandetails.setPayrollLoanType(payrollLoanType);

                payrollloandetails.setLoanAmount(remaningAmount);
                payrollloandetails.setOpRemainingBal(opbal);
                payrollloandetails.setMonthlyRateAmount(monthtyIntRate);
                payrollloandetails.setMonthyInstallment(TotalMonthly);
                payrollLoanDetailService.update(payrollloandetails);
                PayrollLoanRemainingAmount payrollLoanRemainingAmount = new PayrollLoanRemainingAmount();
                payrollLoanRemainingAmount.setEmployeeMaster(employeeMaster);
                payrollLoanRemainingAmount.setPayrollLoanType(payrollLoanType);
                payrollLoanRemainingAmount.setOpRemainingBal(opbal);
                payrollLoanRemainingAmount.setMonthlyRateAmount(monthtyIntRate);
                payrollLoanRemainingAmount.setMonthyInstallment(TotalMonthly);
                payrollLoanRemainingAmount.setClBal(remaningAmount);
                payrollLoanRemainingAmount.setlMonth(month);
                payrollLoanRemainingAmount.setlYear(year);
                payrollLoanRemainingAmount.setMonthEmi(monltyEmi);
                payrollLoanRemainingAmountService.create(payrollLoanRemainingAmount);

            }

        } else {

            employeeMaster = employeeMasterService.readById(employeeSalaryProcess.getEmployeeMaster().getId());
//      List  payrollLoanDetail1list =  payrollLoanDetailService.readByloanDeatils(employeeSalaryProcess.getEmployeeMaster().getId());
//        payrollLoanDetail1 = (PayrollLoanDetail)payrollLoanDetail1list.get(0);
            PayrollLoanDetail payrollLoanDetail1 = new PayrollLoanDetail();
            String month = employeeSalaryProcess.getMonth();
            String year = employeeSalaryProcess.getYear();
            List<?> LoanDetailAmountList = payrollLoanDetailService.readLoanDetails(empId, month, year);
            for (Object LoanDetailAmountList1 : LoanDetailAmountList) {
                Object[] o = (Object[]) LoanDetailAmountList1;
                double basicSalary = employeeSalaryProcess.getEmployeeBasicSalary();
                Double loanAmount = (Double) o[0];
                Double monltyEmi = (Double) o[1];
                String instRate = (String) o[2];
                String textloanType = (String) o[3];
                int payrollloantypeid = (int) o[4];
                int payrollloanDetailsid = (int) o[5];
                double instRate1 = Double.parseDouble(instRate);
                double monthtyIntRate = 0;
                double TotalMonthly = 0;
                double monthlycutfromSalary = 0;
                double remaningAmount = 0;

                if (loanAmount < monltyEmi) {
                    Double monltyEmi1 = 0.0;
                    // if monltyEmi is greater than loan amount
                    monthtyIntRate = (loanAmount * instRate1 / 100);
                    TotalMonthly = (monthtyIntRate + monltyEmi1);
                    monthlycutfromSalary = (basicSalary - TotalMonthly);
                    remaningAmount = (loanAmount - loanAmount);

                    employeeDeductionAmount.setEmployeeSalaryProcess(employeeSalaryProcess);
                    employeeDeductionAmount.setDeductionType(textloanType);
                    employeeDeductionAmount.setDeductionAmount(TotalMonthly);
                    employeeDeductionAmountService.create(employeeDeductionAmount);
                    PayrollLoanType payrollLoanType = payrollLoanTypeService.readById(payrollloantypeid);
                    PayrollLoanDetail payrollloandetails = payrollLoanDetailService.readById(payrollloanDetailsid);

                    payrollloandetails.setEmployeeMaster(employeeMaster);

                    payrollloandetails.setPayrollLoanType(payrollLoanType);

                    payrollloandetails.setLoanAmount(remaningAmount);
                    payrollloandetails.setOpRemainingBal(loanAmount);
                    payrollloandetails.setMonthlyRateAmount(monthtyIntRate);
                    payrollloandetails.setMonthyInstallment(TotalMonthly);
                    payrollloandetails.setMonltyEmi(monltyEmi1);
                    payrollLoanDetailService.update(payrollloandetails);
                    PayrollLoanRemainingAmount payrollLoanRemainingAmount = new PayrollLoanRemainingAmount();
                    payrollLoanRemainingAmount.setEmployeeMaster(employeeMaster);
                    payrollLoanRemainingAmount.setPayrollLoanType(payrollLoanType);
                    payrollLoanRemainingAmount.setOpRemainingBal(remaningAmount);
                    payrollLoanRemainingAmount.setMonthlyRateAmount(monthtyIntRate);
                    payrollLoanRemainingAmount.setMonthyInstallment(TotalMonthly);
                    payrollLoanRemainingAmount.setClBal(remaningAmount);
                    payrollLoanRemainingAmount.setlMonth(month);
                    payrollLoanRemainingAmount.setlYear(year);
                    payrollLoanRemainingAmount.setMonthEmi(monltyEmi1);
                    payrollLoanRemainingAmountService.create(payrollLoanRemainingAmount);

                } else {

                    monthtyIntRate = (loanAmount * instRate1 / 100);
                    TotalMonthly = (monthtyIntRate + monltyEmi);
                    monthlycutfromSalary = (basicSalary - TotalMonthly);
                    remaningAmount = (loanAmount - monltyEmi);

                    employeeDeductionAmount.setEmployeeSalaryProcess(employeeSalaryProcess);
                    employeeDeductionAmount.setDeductionType(textloanType);
                    employeeDeductionAmount.setDeductionAmount(TotalMonthly);
                    employeeDeductionAmountService.create(employeeDeductionAmount);
                    PayrollLoanType payrollLoanType = payrollLoanTypeService.readById(payrollloantypeid);
                    PayrollLoanDetail payrollloandetails = payrollLoanDetailService.readById(payrollloanDetailsid);

                    payrollloandetails.setEmployeeMaster(employeeMaster);

                    payrollloandetails.setPayrollLoanType(payrollLoanType);

                    payrollloandetails.setLoanAmount(remaningAmount);
                    payrollloandetails.setOpRemainingBal(loanAmount);
                    payrollloandetails.setMonthlyRateAmount(monthtyIntRate);
                    payrollloandetails.setMonthyInstallment(TotalMonthly);
                    payrollLoanDetailService.update(payrollloandetails);
                    PayrollLoanRemainingAmount payrollLoanRemainingAmount = new PayrollLoanRemainingAmount();
                    payrollLoanRemainingAmount.setEmployeeMaster(employeeMaster);
                    payrollLoanRemainingAmount.setPayrollLoanType(payrollLoanType);
                    payrollLoanRemainingAmount.setOpRemainingBal(loanAmount);
                    payrollLoanRemainingAmount.setMonthlyRateAmount(monthtyIntRate);
                    payrollLoanRemainingAmount.setMonthyInstallment(TotalMonthly);
                    payrollLoanRemainingAmount.setClBal(remaningAmount);
                    payrollLoanRemainingAmount.setlMonth(month);
                    payrollLoanRemainingAmount.setlYear(year);
                    payrollLoanRemainingAmount.setMonthEmi(monltyEmi);
                    payrollLoanRemainingAmountService.create(payrollLoanRemainingAmount);

                }

            }

        }

        double deductionAmt1 = 0;
        List<?> deductionAmountList1 = employeeDeductionAmountService.readDeductionAmount(employeeSalaryProcess.getId());
        if (!deductionAmountList1.isEmpty()) {
            deductionAmt1 = (Double) deductionAmountList1.get(0);
        }

        double netpayable = netSalary - deductionAmt1;
        employeeSalaryProcess.setId(employeeSalaryProcess.getId());
        employeeSalaryProcess.setEmployeeMaster(employeeMaster);
        employeeSalaryProcess.setNetPayable(netpayable);
        employeeSalaryProcess.setGrossTotal(netSalary);
        employeeSalaryProcessService.update(employeeSalaryProcess);

        ///// tax deduction ///////
        /// curent Salary attional with taaxable 
        Double totalGrosswithTaxable = 0.0;
        Double employeeSalary154 = employeeSalaryProcess.getEmployeeBasicSalary();
        double allowanceWithtaxable = 0;

        List<?> cureentSalaryWithTaxation = employeePolicyDetailService.readBypolicyAmountWithTaxable(employeeSalaryProcess.getEmployeeMaster().getId());
        if (null != cureentSalaryWithTaxation.get(0) && !cureentSalaryWithTaxation.isEmpty()) {
            allowanceWithtaxable = (Double) cureentSalaryWithTaxation.get(0);
        }
        /// payroll taxdeduction amount 
        Double payrollTaxDeductionAamount = 0.0;
        List<?> payrolltaxdeductioonAmountList = payrollTaxDeductionMasterService.readSectionAmount();
        if (!payrolltaxdeductioonAmountList.isEmpty()) {
            for (Object payrolltaxdeductioonAmountList1 : payrolltaxdeductioonAmountList) {
                Object[] o5 = (Object[]) payrolltaxdeductioonAmountList1;
                Integer finicailyearID15 = (Integer) o5[0];
                double d = finicailyearID15.doubleValue();
                payrollTaxDeductionAamount += d;
            }
//            payrollTaxDeductionAamount = (Double) payrolltaxdeductioonAmountList.get(0);
        }

        Integer locationId = employeeMaster.getZydexLocationMaster().getId();
        String month = employeeSalaryProcess.getMonth();
        String year = employeeSalaryProcess.getYear();
        Integer emplID3 = employeeSalaryProcess.getEmployeeMaster().getId();
        Double additionalAmount5 = 0.0;
        Double basicSlaryTotal21 = 0.0;
        Double totalGrossBasicAllowance = 0.0;
        Double grossTotalAssumeSalary = 0.0;
        Double yearSalaryGrossTotal = 0.0;
        List<?> finicailyear = payrollFinancialYearService.readDayFinancialYear(locationId, month, year);
        if (!finicailyear.isEmpty()) {
            for (Object finicialyearList : finicailyear) {
                Object[] o = (Object[]) finicialyearList;

                Integer finicailyearID = (Integer) o[0];
                String startDate = (String) o[1];
                String endateDate = (String) o[2];
                String[] endDateSplited = endateDate.split("/");
                Integer currentMonth = Integer.parseInt(endDateSplited[1]) - Integer.parseInt(month);
                if (currentMonth < 0) {
                    currentMonth = 12 + currentMonth + 1;
                }

                List<?> basicSalaryTotal = employeeSalaryProcessService.readEmployeeGrossTotalTaxable(emplID3, startDate, endateDate);
                if (!basicSalaryTotal.isEmpty()) {
                    for (Object basicSalaryTotalList : basicSalaryTotal) {
                        Object[] o1 = (Object[]) basicSalaryTotalList;
                        Integer empBasicSalaryId = (Integer) o1[0];
                        Double emplSalary = (Double) o1[1];
                        basicSlaryTotal21 += emplSalary;
                        List<?> allowanceGrossWithTaxableTotal = employeeAdditionalSalaryService.readEmployeeAllowanceGrossTotalTaxable(empBasicSalaryId);
                        if (!allowanceGrossWithTaxableTotal.isEmpty()) {
                            for (Object allowanceGrossWithTaxableTotalList : allowanceGrossWithTaxableTotal) {
                                Object[] o2 = (Object[]) allowanceGrossWithTaxableTotalList;
                                String SalaryType = (String) o2[0];
                                Double additionalAmount1 = (Double) o2[1];

                                List<?> aloowancereadByID = policyMasterService.readBySalaryTypeID(SalaryType);
                                if (!aloowancereadByID.isEmpty()) {
//                                    PolicyMaster policyMasterID = (PolicyMaster) aloowancereadByID.get(0);
                                    Integer policyId = (Integer) aloowancereadByID.get(0);
                                    boolean isExist = employeePolicyDetailService.readBypolicyAmountTaxableAmount(employeeSalaryProcess.getEmployeeMaster().getId(), policyId);
                                    if (isExist) {
                                        additionalAmount5 += additionalAmount1;
                                    }
                                }

                            }
                        }
                    }
                    totalGrossBasicAllowance = basicSlaryTotal21 + additionalAmount5;

                    // gap assume salary remaining
                    totalGrosswithTaxable = employeeSalary154 + allowanceWithtaxable;
                    //remaining salary Assume 
                    grossTotalAssumeSalary = totalGrosswithTaxable * currentMonth - 1;

                    // year salary
                    yearSalaryGrossTotal = totalGrossBasicAllowance + grossTotalAssumeSalary;

                    //// TDs Amount 
                    double tdsAmount1 = 0;
                    List<?> tdsAmounttList1 = employeeDeductionAmountService.readEmployeeTdsAmount(employeeSalaryProcess.getEmployeeMaster().getId(), startDate, endateDate);
                    if (!tdsAmounttList1.isEmpty()) {
                        for (Object tdsAmounttList1List : tdsAmounttList1) {
                            Object[] o22 = (Object[]) tdsAmounttList1List;
                            String dedutionType = (String) o22[0];
                            Double dedutionTypeAmount1 = (Double) o22[1];
                            tdsAmount1 += dedutionTypeAmount1;

                        }
                    }
                    String dayofbirth = employeeMaster.getDateOfBirth();
                    String birthyear = dayofbirth.substring(6, 10);
                    Calendar cal = Calendar.getInstance();
                    int year2 = cal.get(cal.YEAR);
                    int diffYear = year2 - Integer.parseInt(birthyear);

                    //// Decaralation Amount between thresholdDate
                    List<?> threadMasterList = payrollTaxDeclarationPeriodMasterService.readPayrollTaxDeclarationPeriodMaster(finicailyearID, month, year);
                    if (!threadMasterList.isEmpty()) {
                        for (Object threadMasterList1 : threadMasterList) {
                            Object[] o15 = (Object[]) threadMasterList1;
                            Integer threadMasterID = (Integer) o15[0];
                            String declarationThresholdDate = (String) o15[1];
                            String proofThresholdDate = (String) o15[2];
                            List<?> taxSavingAmount = taxSavingSubmitService.readTaxSavingSubmitSalaryGenerate(employeeSalaryProcess.getEmployeeMaster().getId(), finicailyearID);
                            if (!taxSavingAmount.isEmpty()) {
                                TaxSavingSubmit taxSavingSubmit = new TaxSavingSubmit();
                                for (Object o13 : taxSavingAmount) {
                                    taxSavingSubmit = (TaxSavingSubmit) o13;
                                    Integer taxSavingsubmitId = taxSavingSubmit.getId();
                                    double taxDeductionDecartionAmount = 0;
                                    double SavingAmountRemain = 0;
                                    List<?> taxDeductionDecarationSubmit = taxDeductionDecarationSubmitService.readTaxDeductionDecarationSubmitSalaryGenerate(taxSavingsubmitId);
                                    if (!taxDeductionDecarationSubmit.isEmpty()) {
                                        taxDeductionDecartionAmount = (Double) taxDeductionDecarationSubmit.get(0);
                                    }
                                    Double TotalRemainingAmount1 = 0.0;
                                    TotalRemainingAmount1 = yearSalaryGrossTotal - taxDeductionDecartionAmount;
                                    List<?> taxDeductionDecarationSubmitSavingLimit = taxDeductionDecarationSubmitService.readTaxDeductionDecarationSubmitSalaryGenerateTaxSavingLimit(taxSavingsubmitId);
                                    if (!taxDeductionDecarationSubmitSavingLimit.isEmpty()) {
                                        for (Object taxDeductionDecarationSubmitSavingLimitList : taxDeductionDecarationSubmitSavingLimit) {
                                            Object[] o2265 = (Object[]) taxDeductionDecarationSubmitSavingLimitList;
                                            Double taxDeclartionAmountTotal = (Double) o2265[0];
                                            Integer taxsavingLimitamountTotal = (Integer) o2265[2];
                                            Integer addittionalAmounttTotal = (Integer) o2265[3];
                                            if (taxDeclartionAmountTotal >= taxsavingLimitamountTotal) {
                                                TotalRemainingAmount1 = TotalRemainingAmount1 - addittionalAmounttTotal;

                                            }

                                        }
                                    }
//                                    int year1Fake = 2000000;
//                                    Double TotalRemainingAmount1 = yearSalaryGrossTotal - taxDeductionDecartionAmount;
//                                    int i = TotalRemainingAmount1.intValue();
//                                    SavingAmountRemain=
                                    Double ftax = 0.0;
                                    List<PayrollTaxRateMaster> list = (List<PayrollTaxRateMaster>) payrollTaxRateMasterService.getAgeValuesFOrSalaryGenerate(diffYear);
                                    if (!list.isEmpty()) {
                                        Double TotalRemainingAmount12 = 0.0;
                                        Double additionalAmount56 = 0.0;
                                        Double tax = 0.0;
                                        Double RemainTdsToPay = 0.0;
                                        Double monthlyTDs = 0.0;
                                        int monthlyTDs12 = 0;
                                        boolean flag = false;
                                        PayrollTaxRateMaster payrollTaxRateMaster = new PayrollTaxRateMaster();
                                        for (int j = 0; j <= list.size(); j++) {
                                            if (!flag) {
                                                payrollTaxRateMaster = (PayrollTaxRateMaster) list.get(j);
                                                String taxRate = payrollTaxRateMaster.getTaxRate();
                                                String incomeFrom = payrollTaxRateMaster.getIncomeFrom();
                                                String incomeTo = payrollTaxRateMaster.getIncomeTo();
//                                            if(j==0){
                                                Double range1 = 0.0;
                                                Double range = 0.0;
                                                if (list.size() != j) {
                                                    range1 = Double.parseDouble(incomeTo) - Double.parseDouble(incomeFrom);
                                                    DecimalFormat df1 = new DecimalFormat("#.##");
                                                    range = Double.parseDouble(df1.format(range1));
                                                } else if (list.size() == j) {
                                                    range1 = Double.parseDouble(incomeFrom);
                                                    DecimalFormat df1 = new DecimalFormat("#.##");
                                                    range = Double.parseDouble(df1.format(range1));
                                                }
//                                                DecimalFormat df1 = new DecimalFormat("#.##");
//                                                System.out.println(df1.format(range));
//                                            }
//                                            if (Integer.parseInt(incomeFrom) == 0) {
//                                                TotalRemainingAmount1 = TotalRemainingAmount1 - Double.parseDouble(incomeTo);
//                                            }
//                                            if (Integer.parseInt(incomeFrom) != 0) {
//                                                TotalRemainingAmount1 = TotalRemainingAmount1 - Double.parseDouble(incomeFrom);
//                                            }

                                                if (TotalRemainingAmount1 != 0.0 && range <= TotalRemainingAmount1) {
                                                    TotalRemainingAmount1 = TotalRemainingAmount1 - range;
                                                } else if (TotalRemainingAmount1 != 0.0 && range >= TotalRemainingAmount1) {
                                                    tax = (TotalRemainingAmount1 * Double.parseDouble(taxRate)) / 100;
                                                    TotalRemainingAmount1 = 0.0;
                                                    flag = true;
                                                } else if ((list.size() == (j + 1)) && TotalRemainingAmount1 != 0.0 && range >= TotalRemainingAmount1) {
                                                    tax = (TotalRemainingAmount1 * Double.parseDouble(taxRate)) / 100;
                                                    TotalRemainingAmount1 = 0.0;
                                                    flag = true;
                                                } else if ((list.size() != (j + 1)) && TotalRemainingAmount1 != 0.0 && range >= TotalRemainingAmount1) {
                                                    tax = (TotalRemainingAmount1 * Double.parseDouble(taxRate)) / 100;
                                                    TotalRemainingAmount1 = 0.0;
                                                    flag = true;
                                                } else if ((list.size() != (j + 1)) && TotalRemainingAmount1 != 0.0 && range <= TotalRemainingAmount1) {
                                                    tax = (TotalRemainingAmount1 * Double.parseDouble(taxRate)) / 100;
                                                    TotalRemainingAmount1 = 0.0;
                                                    flag = true;
                                                } else if ((list.size() == (j + 1)) && TotalRemainingAmount1 != 0.0 && range <= TotalRemainingAmount1) {
                                                    tax = (TotalRemainingAmount1 * Double.parseDouble(taxRate)) / 100;
                                                    TotalRemainingAmount1 = 0.0;
                                                    flag = true;
                                                }

                                                if (range <= TotalRemainingAmount1) {
                                                    tax = (TotalRemainingAmount1 * Double.parseDouble(taxRate)) / 100;
//                                                TotalRemainingAmount1 = 0.0;
                                                }
//                                            if (range >= TotalRemainingAmount1) {
//                                                tax = (TotalRemainingAmount1 * Double.parseDouble(taxRate)) / 100;
//                                                TotalRemainingAmount1 = 0.0;
//                                            }
//                                            if (range >= TotalRemainingAmount1) {
//                                            }

                                                ftax += tax;
                                            }
//                                            TotalRemainingAmount12 = TotalRemainingAmount12 - Double.parseDouble(incomeFrom);

                                        }

                                        RemainTdsToPay = tdsAmount1 - ftax;
                                        monthlyTDs = RemainTdsToPay / currentMonth + 1;
                                        employeeDeductionAmount.setEmployeeSalaryProcess(employeeSalaryProcess);
                                        employeeDeductionAmount.setDeductionType("TDS");
//                                        employeeDeductionAmount.setDeductionAmount(monthlyTDs);

                                        monthlyTDs12 = (int) Math.round(Math.abs(monthlyTDs));
                                        double d = 0.0;
                                        d = monthlyTDs12;
//                                    (int) Math.round(additonalAmount)
                                        employeeDeductionAmount.setDeductionAmount(d);
                                        employeeDeductionAmountService.create(employeeDeductionAmount);
//                                        additionalAmount56 += TotalRemainingAmount12;
                                    }

                                }
                            } else {
                                Double TotalRemainingAmount1 = 0.0;
                                TotalRemainingAmount1 = yearSalaryGrossTotal - 0.0;
//                                List<?> taxDeductionDecarationSubmitSavingLimit = taxDeductionDecarationSubmitService.readTaxDeductionDecarationSubmitSalaryGenerateTaxSavingLimit(taxSavingsubmitId);
//                                if (!taxDeductionDecarationSubmitSavingLimit.isEmpty()) {
//                                    for (Object taxDeductionDecarationSubmitSavingLimitList : taxDeductionDecarationSubmitSavingLimit) {
//                                        Object[] o2265 = (Object[]) taxDeductionDecarationSubmitSavingLimitList;
//                                        Double taxDeclartionAmountTotal = (Double) o2265[0];
//                                        Integer taxsavingLimitamountTotal = (Integer) o2265[2];
//                                        Integer addittionalAmounttTotal = (Integer) o2265[3];
//                                        if (taxDeclartionAmountTotal >= taxsavingLimitamountTotal) {
//                                            TotalRemainingAmount1 = TotalRemainingAmount1 - addittionalAmounttTotal;
//
//                                        }
//
//                                    }
//                                }
//                                    int year1Fake = 2000000;
//                                    Double TotalRemainingAmount1 = yearSalaryGrossTotal - taxDeductionDecartionAmount;
//                                    int i = TotalRemainingAmount1.intValue();
//                                    SavingAmountRemain=
                                Double ftax = 0.0;
                                List<PayrollTaxRateMaster> list = (List<PayrollTaxRateMaster>) payrollTaxRateMasterService.getAgeValuesFOrSalaryGenerate(diffYear);
                                if (!list.isEmpty()) {
                                    Double TotalRemainingAmount12 = 0.0;
                                    Double additionalAmount56 = 0.0;
                                    Double tax = 0.0;
                                    Double RemainTdsToPay = 0.0;
                                    Double monthlyTDs = 0.0;
                                    int monthlyTDs12 = 0;
                                    boolean flag = false;
                                    PayrollTaxRateMaster payrollTaxRateMaster = new PayrollTaxRateMaster();
                                    for (int j = 0; j <= list.size(); j++) {
                                        if (!flag) {
                                            payrollTaxRateMaster = (PayrollTaxRateMaster) list.get(j);
                                            String taxRate = payrollTaxRateMaster.getTaxRate();
                                            String incomeFrom = payrollTaxRateMaster.getIncomeFrom();
                                            String incomeTo = payrollTaxRateMaster.getIncomeTo();
//                                            if(j==0){
                                            Double range1 = 0.0;
                                            Double range = 0.0;
                                            if (list.size() != j) {
                                                range1 = Double.parseDouble(incomeTo) - Double.parseDouble(incomeFrom);
                                                DecimalFormat df1 = new DecimalFormat("#.##");
                                                range = Double.parseDouble(df1.format(range1));
                                            } else if (list.size() == j) {
                                                range1 = Double.parseDouble(incomeFrom);
                                                DecimalFormat df1 = new DecimalFormat("#.##");
                                                range = Double.parseDouble(df1.format(range1));
                                            }
//                                                DecimalFormat df1 = new DecimalFormat("#.##");
//                                                System.out.println(df1.format(range));
//                                            }
//                                            if (Integer.parseInt(incomeFrom) == 0) {
//                                                TotalRemainingAmount1 = TotalRemainingAmount1 - Double.parseDouble(incomeTo);
//                                            }
//                                            if (Integer.parseInt(incomeFrom) != 0) {
//                                                TotalRemainingAmount1 = TotalRemainingAmount1 - Double.parseDouble(incomeFrom);
//                                            }

                                            if (TotalRemainingAmount1 != 0.0 && range <= TotalRemainingAmount1) {
                                                TotalRemainingAmount1 = TotalRemainingAmount1 - range;
                                            } else if (TotalRemainingAmount1 != 0.0 && range >= TotalRemainingAmount1) {
                                                tax = (TotalRemainingAmount1 * Double.parseDouble(taxRate)) / 100;
                                                TotalRemainingAmount1 = 0.0;
                                                flag = true;
                                            } else if ((list.size() == (j + 1)) && TotalRemainingAmount1 != 0.0 && range >= TotalRemainingAmount1) {
                                                tax = (TotalRemainingAmount1 * Double.parseDouble(taxRate)) / 100;
                                                TotalRemainingAmount1 = 0.0;
                                                flag = true;
                                            } else if ((list.size() != (j + 1)) && TotalRemainingAmount1 != 0.0 && range >= TotalRemainingAmount1) {
                                                tax = (TotalRemainingAmount1 * Double.parseDouble(taxRate)) / 100;
                                                TotalRemainingAmount1 = 0.0;
                                                flag = true;
                                            } else if ((list.size() != (j + 1)) && TotalRemainingAmount1 != 0.0 && range <= TotalRemainingAmount1) {
                                                tax = (TotalRemainingAmount1 * Double.parseDouble(taxRate)) / 100;
                                                TotalRemainingAmount1 = 0.0;
                                                flag = true;
                                            } else if ((list.size() == (j + 1)) && TotalRemainingAmount1 != 0.0 && range <= TotalRemainingAmount1) {
                                                tax = (TotalRemainingAmount1 * Double.parseDouble(taxRate)) / 100;
                                                TotalRemainingAmount1 = 0.0;
                                                flag = true;
                                            }

                                            if (range <= TotalRemainingAmount1) {
                                                tax = (TotalRemainingAmount1 * Double.parseDouble(taxRate)) / 100;
//                                                TotalRemainingAmount1 = 0.0;
                                            }
//                                            if (range >= TotalRemainingAmount1) {
//                                                tax = (TotalRemainingAmount1 * Double.parseDouble(taxRate)) / 100;
//                                                TotalRemainingAmount1 = 0.0;
//                                            }
//                                            if (range >= TotalRemainingAmount1) {
//                                            }

                                            ftax += tax;
                                        }
//                                            TotalRemainingAmount12 = TotalRemainingAmount12 - Double.parseDouble(incomeFrom);

                                    }

                                    RemainTdsToPay = tdsAmount1 - ftax;
                                    monthlyTDs = RemainTdsToPay / currentMonth + 1;
                                    employeeDeductionAmount.setEmployeeSalaryProcess(employeeSalaryProcess);
                                    employeeDeductionAmount.setDeductionType("TDS");
                                    monthlyTDs12 = (int) Math.round(Math.abs(monthlyTDs));
                                    double d = 0.0;
                                    d = monthlyTDs12;
//                                    (int) Math.round(additonalAmount)
                                    employeeDeductionAmount.setDeductionAmount(d);
                                    employeeDeductionAmountService.create(employeeDeductionAmount);
//                                        additionalAmount56 += TotalRemainingAmount12;
                                }

                            }
                        }

                    }
                    /// tax declaration before threaHoldDate
                    List<?> threadMasterBeforeList = payrollTaxDeclarationPeriodMasterService.readPayrollTaxDeclarationPeriodMasterBefore(finicailyearID, month, year);
                    if (!threadMasterBeforeList.isEmpty()) {
                        for (Object threadMasterList2 : threadMasterBeforeList) {
                            Object[] o16 = (Object[]) threadMasterList2;
                            Integer threadMasterID = (Integer) o16[0];
                            String declarationThresholdDate = (String) o16[1];
                            String proofThresholdDate = (String) o16[2];
//                            Double TotalRemainingAmount = yearSalaryGrossTotal - payrollTaxDeductionAamount;
//                            Double TotalRemainingAmount1 = yearSalaryGrossTotal - payrollTaxDeductionAamount;
                            List<?> taxSavingAmount = taxSavingSubmitService.readTaxSavingSubmitSalaryGenerate(employeeSalaryProcess.getEmployeeMaster().getId(), finicailyearID);
                            if (!taxSavingAmount.isEmpty()) {

                                TaxSavingSubmit taxSavingSubmit = new TaxSavingSubmit();
                                for (Object o13 : taxSavingAmount) {
                                    taxSavingSubmit = (TaxSavingSubmit) o13;
                                    Integer taxSavingsubmitId = taxSavingSubmit.getId();
                                    Double TotalRemainingAmount1 = 0.0;
                                    TotalRemainingAmount1 = yearSalaryGrossTotal - payrollTaxDeductionAamount;
                                    List<?> taxDeductionDecarationSubmitSavingLimit = taxDeductionDecarationSubmitService.readTaxDeductionDecarationSubmitSalaryGenerateTaxSavingLimit(taxSavingsubmitId);
                                    if (!taxDeductionDecarationSubmitSavingLimit.isEmpty()) {
                                        for (Object taxDeductionDecarationSubmitSavingLimitList : taxDeductionDecarationSubmitSavingLimit) {
                                            Object[] o2265 = (Object[]) taxDeductionDecarationSubmitSavingLimitList;
                                            Double taxDeclartionAmountTotal = (Double) o2265[0];
                                            Integer taxsavingLimitamountTotal = (Integer) o2265[2];
                                            Integer addittionalAmounttTotal = (Integer) o2265[3];
                                            if (taxDeclartionAmountTotal >= taxsavingLimitamountTotal) {
                                                TotalRemainingAmount1 = TotalRemainingAmount1 - addittionalAmounttTotal;

                                            }

                                        }
                                    }

                                    Double ftax = 0.0;
                                    List<PayrollTaxRateMaster> list = (List<PayrollTaxRateMaster>) payrollTaxRateMasterService.getAgeValuesFOrSalaryGenerate(diffYear);
                                    if (!list.isEmpty()) {
                                        Double TotalRemainingAmount12 = 0.0;
                                        Double additionalAmount56 = 0.0;
                                        Double tax = 0.0;
                                        Double RemainTdsToPay = 0.0;
                                        Double monthlyTDs = 0.0;
                                        int monthlyTDs12 = 0;
                                        boolean flag = false;
                                        PayrollTaxRateMaster payrollTaxRateMaster = new PayrollTaxRateMaster();
                                        for (int j = 0; j <= list.size(); j++) {
                                            if (!flag) {
                                                payrollTaxRateMaster = (PayrollTaxRateMaster) list.get(j);
                                                String taxRate = payrollTaxRateMaster.getTaxRate();
                                                String incomeFrom = payrollTaxRateMaster.getIncomeFrom();
                                                String incomeTo = payrollTaxRateMaster.getIncomeTo();
//                                            if(j==0){
                                                Double range1 = 0.0;
                                                Double range = 0.0;
                                                if (list.size() != j) {
                                                    range1 = Double.parseDouble(incomeTo) - Double.parseDouble(incomeFrom);
                                                    DecimalFormat df1 = new DecimalFormat("#.##");
                                                    range = Double.parseDouble(df1.format(range1));
                                                } else if (list.size() == j) {
                                                    range1 = Double.parseDouble(incomeFrom);
                                                    DecimalFormat df1 = new DecimalFormat("#.##");
                                                    range = Double.parseDouble(df1.format(range1));
                                                }
//                                                DecimalFormat df1 = new DecimalFormat("#.##");
//                                                System.out.println(df1.format(range));
//                                            }
//                                            if (Integer.parseInt(incomeFrom) == 0) {
//                                                TotalRemainingAmount1 = TotalRemainingAmount1 - Double.parseDouble(incomeTo);
//                                            }
//                                            if (Integer.parseInt(incomeFrom) != 0) {
//                                                TotalRemainingAmount1 = TotalRemainingAmount1 - Double.parseDouble(incomeFrom);
//                                            }

                                                if (TotalRemainingAmount1 != 0.0 && range <= TotalRemainingAmount1) {
                                                    TotalRemainingAmount1 = TotalRemainingAmount1 - range;
                                                } else if (TotalRemainingAmount1 != 0.0 && range >= TotalRemainingAmount1) {
                                                    tax = (TotalRemainingAmount1 * Double.parseDouble(taxRate)) / 100;
                                                    TotalRemainingAmount1 = 0.0;
                                                    flag = true;
                                                } else if ((list.size() == (j + 1)) && TotalRemainingAmount1 != 0.0 && range >= TotalRemainingAmount1) {
                                                    tax = (TotalRemainingAmount1 * Double.parseDouble(taxRate)) / 100;
                                                    TotalRemainingAmount1 = 0.0;
                                                    flag = true;
                                                } else if ((list.size() != (j + 1)) && TotalRemainingAmount1 != 0.0 && range >= TotalRemainingAmount1) {
                                                    tax = (TotalRemainingAmount1 * Double.parseDouble(taxRate)) / 100;
                                                    TotalRemainingAmount1 = 0.0;
                                                    flag = true;
                                                } else if ((list.size() != (j + 1)) && TotalRemainingAmount1 != 0.0 && range <= TotalRemainingAmount1) {
                                                    tax = (TotalRemainingAmount1 * Double.parseDouble(taxRate)) / 100;
                                                    TotalRemainingAmount1 = 0.0;
                                                    flag = true;
                                                } else if ((list.size() == (j + 1)) && TotalRemainingAmount1 != 0.0 && range <= TotalRemainingAmount1) {
                                                    tax = (TotalRemainingAmount1 * Double.parseDouble(taxRate)) / 100;
                                                    TotalRemainingAmount1 = 0.0;
                                                    flag = true;
                                                }

                                                if (range <= TotalRemainingAmount1) {
                                                    tax = (TotalRemainingAmount1 * Double.parseDouble(taxRate)) / 100;
//                                                TotalRemainingAmount1 = 0.0;
                                                }
//                                            if (range >= TotalRemainingAmount1) {
//                                                tax = (TotalRemainingAmount1 * Double.parseDouble(taxRate)) / 100;
//                                                TotalRemainingAmount1 = 0.0;
//                                            }
//                                            if (range >= TotalRemainingAmount1) {
//                                            }

                                                ftax += tax;
                                            }
//                                            TotalRemainingAmount12 = TotalRemainingAmount12 - Double.parseDouble(incomeFrom);

                                        }

                                        RemainTdsToPay = tdsAmount1 - ftax;
                                        monthlyTDs = RemainTdsToPay / currentMonth + 1;
                                        employeeDeductionAmount.setEmployeeSalaryProcess(employeeSalaryProcess);
                                        employeeDeductionAmount.setDeductionType("TDS");
                                        monthlyTDs12 = (int) Math.round(Math.abs(monthlyTDs));
                                        double d = 0.0;
                                        d = monthlyTDs12;
//                                    (int) Math.round(additonalAmount)
                                        employeeDeductionAmount.setDeductionAmount(d);
                                        employeeDeductionAmountService.create(employeeDeductionAmount);
//                                        additionalAmount56 += TotalRemainingAmount12;
                                    }
                                }
                            }
                        }
                    }

                    /// tax declaration afteer Proff date
                    List<?> threadMasterafterProffList = payrollTaxDeclarationPeriodMasterService.readPayrollTaxDeclarationPeriodMasterAfterProofDate(finicailyearID, month, year);
                    if (!threadMasterafterProffList.isEmpty()) {
                        for (Object threadMasterList3 : threadMasterafterProffList) {
                            Object[] o17 = (Object[]) threadMasterList3;
                            Integer threadMasterID = (Integer) o17[0];
                            String declarationThresholdDate = (String) o17[1];
                            String proofThresholdDate = (String) o17[2];
                            List<?> taxSavingAmountafterDate = taxSavingSubmitService.readTaxSavingSubmitSalaryGenerateAfterDate(employeeSalaryProcess.getEmployeeMaster().getId(), finicailyearID);
                            if (!taxSavingAmountafterDate.isEmpty()) {
                                TaxSavingSubmit taxSavingSubmit = new TaxSavingSubmit();
                                for (Object o19 : taxSavingAmountafterDate) {
                                    taxSavingSubmit = (TaxSavingSubmit) o19;
                                    Integer taxSavingsubmitId = taxSavingSubmit.getId();
                                    double taxDeductionDecartionAmount156 = 0;
                                    double SavingAmountRemain = 0;
                                    List<?> taxDeductionDecarationSubmit15 = taxDeductionDecarationSubmitService.readTaxDeductionDecarationSubmitSalaryGenerateAfterDate(taxSavingsubmitId);
                                    if (!taxDeductionDecarationSubmit15.isEmpty() && null != taxDeductionDecarationSubmit15.get(0)) {
                                        taxDeductionDecartionAmount156 = (Double) taxDeductionDecarationSubmit15.get(0);
                                    }
                                    Double TotalRemainingAmount1 = 0.0;
//                                            = yearSalaryGrossTotal - taxDeductionDecartionAmount156;

                                    TotalRemainingAmount1 = yearSalaryGrossTotal - taxDeductionDecartionAmount156;
                                    List<?> taxDeductionDecarationSubmitSavingLimit = taxDeductionDecarationSubmitService.readTaxDeductionDecarationSubmitSalaryGenerateTaxSavingLimit(taxSavingsubmitId);
                                    if (!taxDeductionDecarationSubmitSavingLimit.isEmpty()) {
                                        for (Object taxDeductionDecarationSubmitSavingLimitList : taxDeductionDecarationSubmitSavingLimit) {
                                            Object[] o2265 = (Object[]) taxDeductionDecarationSubmitSavingLimitList;
                                            Double taxDeclartionAmountTotal = (Double) o2265[0];
                                            Integer taxsavingLimitamountTotal = (Integer) o2265[2];
                                            Integer addittionalAmounttTotal = (Integer) o2265[3];
                                            if (taxDeclartionAmountTotal >= taxsavingLimitamountTotal) {
                                                TotalRemainingAmount1 = TotalRemainingAmount1 - addittionalAmounttTotal;

                                            }

                                        }
                                    }

//                                    SavingAmountRemain=
                                    Double ftax = 0.0;
                                    List<PayrollTaxRateMaster> list = (List<PayrollTaxRateMaster>) payrollTaxRateMasterService.getAgeValuesFOrSalaryGenerate(diffYear);
                                    if (!list.isEmpty()) {
                                        Double TotalRemainingAmount12 = 0.0;
                                        Double additionalAmount56 = 0.0;
                                        Double tax = 0.0;
                                        Double RemainTdsToPay = 0.0;
                                        Double monthlyTDs = 0.0;
                                        int monthlyTDs12 = 0;
                                        boolean flag = false;
                                        PayrollTaxRateMaster payrollTaxRateMaster = new PayrollTaxRateMaster();
                                        for (int j = 0; j <= list.size(); j++) {
                                            if (!flag) {
                                                payrollTaxRateMaster = (PayrollTaxRateMaster) list.get(j);
                                                String taxRate = payrollTaxRateMaster.getTaxRate();
                                                String incomeFrom = payrollTaxRateMaster.getIncomeFrom();
                                                String incomeTo = payrollTaxRateMaster.getIncomeTo();
//                                            if(j==0){
                                                Double range1 = 0.0;
                                                Double range = 0.0;
                                                if (list.size() != j) {
                                                    range1 = Double.parseDouble(incomeTo) - Double.parseDouble(incomeFrom);
                                                    DecimalFormat df1 = new DecimalFormat("#.##");
                                                    range = Double.parseDouble(df1.format(range1));
                                                } else if (list.size() == j) {
                                                    range1 = Double.parseDouble(incomeFrom);
                                                    DecimalFormat df1 = new DecimalFormat("#.##");
                                                    range = Double.parseDouble(df1.format(range1));
                                                }
//                                                DecimalFormat df1 = new DecimalFormat("#.##");
//                                                System.out.println(df1.format(range));
//                                            }
//                                            if (Integer.parseInt(incomeFrom) == 0) {
//                                                TotalRemainingAmount1 = TotalRemainingAmount1 - Double.parseDouble(incomeTo);
//                                            }
//                                            if (Integer.parseInt(incomeFrom) != 0) {
//                                                TotalRemainingAmount1 = TotalRemainingAmount1 - Double.parseDouble(incomeFrom);
//                                            }

                                                if (TotalRemainingAmount1 != 0.0 && range <= TotalRemainingAmount1) {
                                                    TotalRemainingAmount1 = TotalRemainingAmount1 - range;
                                                } else if (TotalRemainingAmount1 != 0.0 && range >= TotalRemainingAmount1) {
                                                    tax = (TotalRemainingAmount1 * Double.parseDouble(taxRate)) / 100;
                                                    TotalRemainingAmount1 = 0.0;
                                                    flag = true;
                                                } else if ((list.size() == (j + 1)) && TotalRemainingAmount1 != 0.0 && range >= TotalRemainingAmount1) {
                                                    tax = (TotalRemainingAmount1 * Double.parseDouble(taxRate)) / 100;
                                                    TotalRemainingAmount1 = 0.0;
                                                    flag = true;
                                                } else if ((list.size() != (j + 1)) && TotalRemainingAmount1 != 0.0 && range >= TotalRemainingAmount1) {
                                                    tax = (TotalRemainingAmount1 * Double.parseDouble(taxRate)) / 100;
                                                    TotalRemainingAmount1 = 0.0;
                                                    flag = true;
                                                } else if ((list.size() != (j + 1)) && TotalRemainingAmount1 != 0.0 && range <= TotalRemainingAmount1) {
                                                    tax = (TotalRemainingAmount1 * Double.parseDouble(taxRate)) / 100;
                                                    TotalRemainingAmount1 = 0.0;
                                                    flag = true;
                                                } else if ((list.size() == (j + 1)) && TotalRemainingAmount1 != 0.0 && range <= TotalRemainingAmount1) {
                                                    tax = (TotalRemainingAmount1 * Double.parseDouble(taxRate)) / 100;
                                                    TotalRemainingAmount1 = 0.0;
                                                    flag = true;
                                                }

                                                if (range <= TotalRemainingAmount1) {
                                                    tax = (TotalRemainingAmount1 * Double.parseDouble(taxRate)) / 100;
//                                                TotalRemainingAmount1 = 0.0;
                                                }
//                                            if (range >= TotalRemainingAmount1) {
//                                                tax = (TotalRemainingAmount1 * Double.parseDouble(taxRate)) / 100;
//                                                TotalRemainingAmount1 = 0.0;
//                                            }
//                                            if (range >= TotalRemainingAmount1) {
//                                            }

                                                ftax += tax;
                                            }
//                                            TotalRemainingAmount12 = TotalRemainingAmount12 - Double.parseDouble(incomeFrom);

                                        }

                                        RemainTdsToPay = tdsAmount1 - ftax;
                                        monthlyTDs = RemainTdsToPay / currentMonth + 1;
                                        employeeDeductionAmount.setEmployeeSalaryProcess(employeeSalaryProcess);
                                        employeeDeductionAmount.setDeductionType("TDS");
                                        monthlyTDs12 = (int) Math.round(Math.abs(monthlyTDs));
                                        double d = 0.0;
                                        d = monthlyTDs12;
//                                    (int) Math.round(additonalAmount)
                                        employeeDeductionAmount.setDeductionAmount(d);
                                        employeeDeductionAmountService.create(employeeDeductionAmount);
//                                        additionalAmount56 += TotalRemainingAmount12;
                                    }

                                }
                            } else {
                                Double TotalRemainingAmount1 = 0.0;
                                TotalRemainingAmount1 = yearSalaryGrossTotal - 0.0;
//                                List<?> taxDeductionDecarationSubmitSavingLimit = taxDeductionDecarationSubmitService.readTaxDeductionDecarationSubmitSalaryGenerateTaxSavingLimit(taxSavingsubmitId);
//                                if (!taxDeductionDecarationSubmitSavingLimit.isEmpty()) {
//                                    for (Object taxDeductionDecarationSubmitSavingLimitList : taxDeductionDecarationSubmitSavingLimit) {
//                                        Object[] o2265 = (Object[]) taxDeductionDecarationSubmitSavingLimitList;
//                                        Double taxDeclartionAmountTotal = (Double) o2265[0];
//                                        Integer taxsavingLimitamountTotal = (Integer) o2265[2];
//                                        Integer addittionalAmounttTotal = (Integer) o2265[3];
//                                        if (taxDeclartionAmountTotal >= taxsavingLimitamountTotal) {
//                                            TotalRemainingAmount1 = TotalRemainingAmount1 - addittionalAmounttTotal;
//
//                                        }
//
//                                    }
//                                }
//                                    int year1Fake = 2000000;
//                                    Double TotalRemainingAmount1 = yearSalaryGrossTotal - taxDeductionDecartionAmount;
//                                    int i = TotalRemainingAmount1.intValue();
//                                    SavingAmountRemain=
                                Double ftax = 0.0;
                                List<PayrollTaxRateMaster> list = (List<PayrollTaxRateMaster>) payrollTaxRateMasterService.getAgeValuesFOrSalaryGenerate(diffYear);
                                if (!list.isEmpty()) {
                                    Double TotalRemainingAmount12 = 0.0;
                                    Double additionalAmount56 = 0.0;
                                    Double tax = 0.0;
                                    Double RemainTdsToPay = 0.0;
                                    Double monthlyTDs = 0.0;
                                    int monthlyTDs12 = 0;
                                    boolean flag = false;
                                    PayrollTaxRateMaster payrollTaxRateMaster = new PayrollTaxRateMaster();
                                    for (int j = 0; j <= list.size(); j++) {
                                        if (!flag) {
                                            payrollTaxRateMaster = (PayrollTaxRateMaster) list.get(j);
                                            String taxRate = payrollTaxRateMaster.getTaxRate();
                                            String incomeFrom = payrollTaxRateMaster.getIncomeFrom();
                                            String incomeTo = payrollTaxRateMaster.getIncomeTo();
//                                            if(j==0){
                                            Double range1 = 0.0;
                                            Double range = 0.0;
                                            if (list.size() != j) {
                                                range1 = Double.parseDouble(incomeTo) - Double.parseDouble(incomeFrom);
                                                DecimalFormat df1 = new DecimalFormat("#.##");
                                                range = Double.parseDouble(df1.format(range1));
                                            } else if (list.size() == j) {
                                                range1 = Double.parseDouble(incomeFrom);
                                                DecimalFormat df1 = new DecimalFormat("#.##");
                                                range = Double.parseDouble(df1.format(range1));
                                            }
//                                                DecimalFormat df1 = new DecimalFormat("#.##");
//                                                System.out.println(df1.format(range));
//                                            }
//                                            if (Integer.parseInt(incomeFrom) == 0) {
//                                                TotalRemainingAmount1 = TotalRemainingAmount1 - Double.parseDouble(incomeTo);
//                                            }
//                                            if (Integer.parseInt(incomeFrom) != 0) {
//                                                TotalRemainingAmount1 = TotalRemainingAmount1 - Double.parseDouble(incomeFrom);
//                                            }

                                            if (TotalRemainingAmount1 != 0.0 && range <= TotalRemainingAmount1) {
                                                TotalRemainingAmount1 = TotalRemainingAmount1 - range;
                                            } else if (TotalRemainingAmount1 != 0.0 && range >= TotalRemainingAmount1) {
                                                tax = (TotalRemainingAmount1 * Double.parseDouble(taxRate)) / 100;
                                                TotalRemainingAmount1 = 0.0;
                                                flag = true;
                                            } else if ((list.size() == (j + 1)) && TotalRemainingAmount1 != 0.0 && range >= TotalRemainingAmount1) {
                                                tax = (TotalRemainingAmount1 * Double.parseDouble(taxRate)) / 100;
                                                TotalRemainingAmount1 = 0.0;
                                                flag = true;
                                            } else if ((list.size() != (j + 1)) && TotalRemainingAmount1 != 0.0 && range >= TotalRemainingAmount1) {
                                                tax = (TotalRemainingAmount1 * Double.parseDouble(taxRate)) / 100;
                                                TotalRemainingAmount1 = 0.0;
                                                flag = true;
                                            } else if ((list.size() != (j + 1)) && TotalRemainingAmount1 != 0.0 && range <= TotalRemainingAmount1) {
                                                tax = (TotalRemainingAmount1 * Double.parseDouble(taxRate)) / 100;
                                                TotalRemainingAmount1 = 0.0;
                                                flag = true;
                                            } else if ((list.size() == (j + 1)) && TotalRemainingAmount1 != 0.0 && range <= TotalRemainingAmount1) {
                                                tax = (TotalRemainingAmount1 * Double.parseDouble(taxRate)) / 100;
                                                TotalRemainingAmount1 = 0.0;
                                                flag = true;
                                            }

                                            if (range <= TotalRemainingAmount1) {
                                                tax = (TotalRemainingAmount1 * Double.parseDouble(taxRate)) / 100;
//                                                TotalRemainingAmount1 = 0.0;
                                            }
//                                            if (range >= TotalRemainingAmount1) {
//                                                tax = (TotalRemainingAmount1 * Double.parseDouble(taxRate)) / 100;
//                                                TotalRemainingAmount1 = 0.0;
//                                            }
//                                            if (range >= TotalRemainingAmount1) {
//                                            }

                                            ftax += tax;
                                        }
//                                            TotalRemainingAmount12 = TotalRemainingAmount12 - Double.parseDouble(incomeFrom);

                                    }

                                    RemainTdsToPay = tdsAmount1 - ftax;
                                    monthlyTDs = RemainTdsToPay / currentMonth + 1;
                                    employeeDeductionAmount.setEmployeeSalaryProcess(employeeSalaryProcess);
                                    employeeDeductionAmount.setDeductionType("TDS");
                                    monthlyTDs12 = (int) Math.round(Math.abs(monthlyTDs));
                                    double d = 0.0;
                                    d = monthlyTDs12;
//                                    (int) Math.round(additonalAmount)
                                    employeeDeductionAmount.setDeductionAmount(d);
                                    employeeDeductionAmountService.create(employeeDeductionAmount);
//                                        additionalAmount56 += TotalRemainingAmount12;
                                }

                            }
                        }

                    }

                }

            }

        }
    }

    public ModelAndView searchSalaryDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeSalaryProcess employeeSalaryProcess = new EmployeeSalaryProcess();
        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeType employeeType = new EmployeeType();
        EmployeeSubType employeeSubType = new EmployeeSubType();
        List<?> list = (List<?>) request.getAttribute("employeelist");
        zydexLocationList(request);
        EmployeeTypeList(request);
        EmployeeSubTypeList(request);
        request.setAttribute("search", request.getParameter("search"));
        List<?> list1 = (List<?>) request.getAttribute("SalaryList");
        mv.getModelMap().put("employeeSalaryProcess", employeeSalaryProcess);
        request.setAttribute("employeelist", list);
        session.setAttribute("sessionMapOfSalBalance", list1);
        mv.setViewName("Payroll/EmployeeSalarySearch");
        return mv;
    }

    @SuppressWarnings("unchecked")
    public ModelAndView searchSalaryDetailSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeSalaryProcess employeeSalaryProcess = new EmployeeSalaryProcess();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeType employeeType = new EmployeeType();
        EmployeeSubType employeeSubType = new EmployeeSubType();

        HttpSession session = request.getSession();
        String zydex_location_id = request.getParameter("zydexLocationMasterId");
        String type_of_employee = request.getParameter("employeeTypeMasterId");
        String employee_sub_id = request.getParameter("subTypeId");
        String payment_type = request.getParameter("paymentType");
        String month1 = request.getParameter("month");
        String year11 = request.getParameter("year11");

        if (!zydex_location_id.equals("")) {
            employeeMaster.setAdharCard(zydex_location_id);
        }

        if (!type_of_employee.equals("")) {
            employeeMaster.setEmployeeType(type_of_employee);
        }
        if (null != employee_sub_id && !employee_sub_id.equals("")) {
            employeeMaster.setCompany(employee_sub_id);
        }

        if (!payment_type.equals("")) {
            employeeMaster.setPaymentType(payment_type);

        }
        if (!month1.equals("")) {
            employeeMaster.setBankName(month1);

        }
        if (!year11.equals("")) {
            employeeMaster.setChild1(year11);

        }

//        if (!"".equals(month1)) {
//            employeeSalaryProcess.setMonth(month1);
//        }
//        if (!"".equals(year11)) {
//            employeeSalaryProcess.setYear(year11);
//        }
        DecimalFormat df = new DecimalFormat("####0.00");

        List<String> headerList = new ArrayList<String>();
        headerList.add("Emp Company Code");
        headerList.add("Emp Id");
        headerList.add("Emp Name");
        headerList.add("P.Day");
        headerList.add("Basic Salary");

//        List<?> list1 = employeeSalaryProcessService.readSal(employeeMaster);
        List<?> list1 = employeeSalaryProcessService.readsalSearch(employeeMaster);
        for (Object o1 : list1) {
            Object str[] = (Object[]) o1;
            if (!headerList.contains("" + str[5]) && null != str[5]) {
                headerList.add("" + str[5]);
            }

        }
        headerList.add("Gross Salary");
//        List<?> list2 = employeeSalaryProcessService.readsalDeduction(employeeMaster);
        List<?> list2 = employeeSalaryProcessService.readsalDeductionSearch(employeeMaster);
        for (Object o1 : list2) {
            Object str1[] = (Object[]) o1;
            if (!headerList.contains("" + str1[2]) && null != str1[2]) {
                headerList.add("" + str1[2]);
            }
        }

        headerList.add("Tot.Dedn");
        headerList.add("Net Pay");
        List<?> list6 = ctcAllowanceService.read();
        CtcAllowance ctcAllowance = new CtcAllowance();
//        Map<Integer, String> leaveTypemap = new HashMap();
        for (Object o : list6) {
            ctcAllowance = (CtcAllowance) o;
            headerList.add("" + ctcAllowance.getCtcName());
        }
        headerList.add("Total");
        headerList.add("CTCPerMonth");

        List<EmployeeSalaryProcess> empList = (List<EmployeeSalaryProcess>) employeeSalaryProcessService.readEmpSalaryReport(employeeMaster);
        List<Object> finalList = new LinkedList<Object>();
        for (EmployeeSalaryProcess employeeSalaryProcess1 : empList) {
            Map<String, String> empMap = new HashMap<String, String>();
            double additionalAmount = 0.0;
            double deductionAmount = 0.0;
            double total = 0.0;
            EmployeeExcelRecord employeeExcelRecord1 = new EmployeeExcelRecord();
            EmployeeMaster employeeMaster1 = employeeMasterService.readById(employeeSalaryProcess1.getEmployeeMaster().getId());
            List<?> list = employeeExcelRecordService.readByEmployeExcelReportSearch(employeeSalaryProcess1);
//            List tempList = (List) list.get(0);
            empMap.put("Emp Company Code", "" + employeeMaster1.getEmployeeLocation());
            empMap.put("Emp Id", "" + employeeMaster1.getEmployeeId());
            empMap.put("Emp Name", employeeMaster1.getEmployeeName());
            empMap.put("P.Day", "" + list.get(0));
//            empMap.put("Basic Salary", "" + df.format(employeeSalaryProcess1.getEmployeeBasicSalary()));
            empMap.put("Basic Salary", "" + df.format((int) Math.round(employeeSalaryProcess1.getEmployeeBasicSalary())));

//            List addSalaryList = employeeAdditionalSalaryService.readEmployeeForSalaryAdditionalinfo(employeeSalaryProcess1);
            List addSalaryList = employeeAdditionalSalaryService.readEmployeeForSalaryAdditionalinfoSearch(employeeSalaryProcess1);
            for (Object addSalaryList1 : addSalaryList) {
                Object[] o = (Object[]) addSalaryList1;
//                empMap.put("" + o[0], "" + df.format(o[1]));
                empMap.put("" + o[0], "" + df.format((int) Math.round((double) o[1])));
//                additionalAmount += (Double) o[1];
//                  int netpayable1 = (int) Math.round(additionalAmount);
                additionalAmount += (Double) o[1];
            }
            additionalAmount += employeeSalaryProcess1.getEmployeeBasicSalary();
//            empMap.put("Gross Salary", "" + df.format(additionalAmount));
            empMap.put("Gross Salary", "" + df.format((int) Math.round(additionalAmount)));
//            List dedSalaryList = employeeDeductionAmountService.readEmployeeForSalaryDeductioninfo(employeeSalaryProcess1);
            List dedSalaryList = employeeDeductionAmountService.readEmployeeForSalaryDeductioninfoSearch(employeeSalaryProcess1);
            for (Object dedSalaryList1 : dedSalaryList) {
                Object[] o = (Object[]) dedSalaryList1;
//                empMap.put("" + o[0], "" + df.format(o[1]));
                empMap.put("" + o[0], "" + df.format((int) Math.round((double) o[1])));
                deductionAmount += (Double) o[1];
            }

//            empMap.put("Deduction Amount", "" + df.format(deductionAmount));
            empMap.put("Tot.Dedn", "" + df.format((int) Math.round(deductionAmount)));
            empMap.put("Net Pay", "" + df.format((int) Math.round(additionalAmount - deductionAmount)));
//            empMap.put("Net Amount", "" + df.format(additionalAmount - deductionAmount));
            List ctcList = employeeCtcDetailService.fetchctcData(employeeSalaryProcess1.getEmployeeMaster().getId());
            for (Object dedSalaryList2 : ctcList) {
                Object[] o5 = (Object[]) dedSalaryList2;
//                empMap.put("" + o[0], "" + df.format(o[1]));
                empMap.put("" + o5[1], "" + df.format((int) Math.round((double) o5[2])));
                total += (Double) o5[2];
            }
            empMap.put("Total", "" + df.format((int) Math.round(total)));
            empMap.put("CTCPerMonth", "" + df.format((int) Math.round(total + (additionalAmount - deductionAmount))));
            finalList.add(empMap);
        }

//      
        request.setAttribute("headerList123", headerList);
        request.setAttribute("finalList", finalList);
         session.setAttribute("employeeSalaryHeader", headerList);
         session.setAttribute("sessionMapOfEmployeeSalary", finalList);
        request.setAttribute("month", month1);
        request.setAttribute("year", year11);
        request.setAttribute("zydexlocationid", zydex_location_id);
        request.setAttribute("typeofemployee", type_of_employee);
        request.setAttribute("employeesubid", employee_sub_id);
        request.setAttribute("paymenttype", payment_type);
       

        mv.setViewName("Payroll/EmployeeSalarySearch");

        return mv;
    }
    
    public ModelAndView exportToExcelLeaveBalance(HttpServletRequest request, HttpServletResponse response, EmployeeMaster employeeMaster) throws Exception {
        ModelAndView mv = new ModelAndView();
        Map<Integer, LinkedList<?>> sessionMapOfLeaveBalance = (Map<Integer, LinkedList<?>>) request.getSession().getAttribute("sessionMapOfEmployeeSalary");
        Map<Integer, LinkedList<?>> sessionMapOfLeaveBalance1 = (Map<Integer, LinkedList<?>>) request.getSession().getAttribute("employeeSalaryHeader");
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=EmployeeLeaveBalanceData.xls");
        mv.addObject("sessionMapOfLeaveBalance1", sessionMapOfLeaveBalance1);
        mv.addObject("sessionMapOfLeaveBalance", sessionMapOfLeaveBalance);
        mv.setViewName("Leave/LeaveBalanceEmployeeWiseExportToExcel");
        return mv;
    }

    public ModelAndView exportToExcelForSalRequest(HttpServletRequest request, HttpServletResponse response, EmployeeMaster employeeMaster) throws Exception {
        ModelAndView mv = new ModelAndView();
//   Map<Integer, List<?>> sessionMapOfSalBalance = (Map<Integer, List<?>>) request.getSession().getAttribute("sessionMapOfSalBalance");
        List<?> sessionMapOfSalBalance = (List<?>) request.getSession().getAttribute("sessionlistOfSalBalance");
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=EmployeeSalBalanceData.xls");
        mv.addObject("SalaryList", sessionMapOfSalBalance);
        mv.setViewName("Payroll/EmployeeSalarySearchExcel");
        return mv;
    }

    public ModelAndView viewClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeSalaryProcess employeeSalaryProcess = new EmployeeSalaryProcess();
        String id = request.getParameter("id");
        employeeSalaryProcess = employeeSalaryProcessService.readById(Integer.parseInt(id));
        mv.getModelMap().put("employeeSalaryProcess", employeeSalaryProcess);
        mv.setViewName("Payroll/EmployeeSalarySlip");
        return mv;
    }

    public ModelAndView searchMasterEmpSalDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeSalaryProcess employeeSalaryProcess = new EmployeeSalaryProcess();
        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeType employeeType = new EmployeeType();
        EmployeeSubType employeeSubType = new EmployeeSubType();
        List<?> list = (List<?>) request.getAttribute("employeelist");
        zydexLocationList(request);
        EmployeeTypeList(request);
        EmployeeSubTypeList(request);
        request.setAttribute("search", request.getParameter("search"));
        List<?> list1 = (List<?>) request.getAttribute("SalaryList");
        mv.getModelMap().put("employeeSalaryProcess", employeeSalaryProcess);
        request.setAttribute("employeelist", list);
        session.setAttribute("sessionMapOfSalBalance", list1);
        mv.setViewName("Payroll/EmployeeMasterSalDetailSearch");
        return mv;
    }

    public ModelAndView searchMasterEmpDetailSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeSalaryProcess employeeSalaryProcess = new EmployeeSalaryProcess();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeType employeeType = new EmployeeType();
        EmployeeSubType employeeSubType = new EmployeeSubType();

        HttpSession session = request.getSession();
        String zydex_location_id = request.getParameter("zydexLocationMasterId");
        String type_of_employee = request.getParameter("employeeTypeMasterId");
        String employee_sub_id = request.getParameter("subTypeId");
        String payment_type = request.getParameter("paymentType");

        if (!zydex_location_id.equals("")) {
            employeeMaster.setAdharCard(zydex_location_id);
        }

        if (!type_of_employee.equals("")) {
            employeeMaster.setEmployeeType(type_of_employee);
        }
        if (null != employee_sub_id && !employee_sub_id.equals("")) {
            employeeMaster.setCompany(employee_sub_id);
        }

        if (!payment_type.equals("")) {
            employeeMaster.setPaymentType(payment_type);

        }

        Map<Integer, List<Object>> empMap = new HashMap();
        List<String> headerList = new ArrayList<String>();
        headerList.add("Employee Id");
        headerList.add("Employee Name");
        headerList.add("Basic Salary");

//        List<?> salaryTypeList = payrollSalaryTypeService.read();
//        for (Object o1 : salaryTypeList) {
//            PayrollSalaryType payrollSalaryType = (PayrollSalaryType) o1;
//            headerList.add(payrollSalaryType.getText());
//        }
        List<?> policyMasterList = policyMasterService.read();
        for (Object o1 : policyMasterList) {
            PolicyMaster policyMaster = (PolicyMaster) o1;
            headerList.add(policyMaster.getPolicyName());
        }

        headerList.add("PF");
        headerList.add("PT");
        headerList.add("Total Gross Salary");
        headerList.add("Deductional Amount");
        headerList.add("NetSalary Amount");

        List<?> list6 = ctcAllowanceService.read();
        CtcAllowance ctcAllowance = new CtcAllowance();
//        Map<Integer, String> leaveTypemap = new HashMap();
        for (Object o : list6) {
            ctcAllowance = (CtcAllowance) o;
            headerList.add("" + ctcAllowance.getCtcName());
        }
        headerList.add("Total");
        headerList.add("CTCPerMonth");
        List<EmployeeMaster> empList = (List<EmployeeMaster>) employeeSalaryProcessService.readEmpMasterSalary(employeeMaster);

        for (EmployeeMaster employeeMaster1 : empList) {
            DecimalFormat df = new DecimalFormat("#.##");
            List<Object> finalList = new ArrayList();
            finalList.add(employeeMaster1.getEmployeeId());
            finalList.add(employeeMaster1.getEmployeeName());
            finalList.add(employeeMaster1.getBasicSalary());
//    Map<String, String> empMap = new HashMap<String, String>();
            double basicSalary1 = Double.parseDouble(employeeMaster1.getBasicSalary());
            double grossSalary = 0;
            double deductionAmount = 0;
            double total = 0.0;
            List<?> salaryTypeList1 = policyMasterService.read();
            for (Object o1 : salaryTypeList1) {
                PolicyMaster policyMaster = (PolicyMaster) o1;

                List<?> list = employeePolicyDetailService.readForMasterAdditionalAmount(employeeMaster1.getId(), policyMaster.getId());

                if (!list.isEmpty()) {
                    Iterator itr = list.iterator();
                    if (itr.hasNext()) {
                        Object[] next = (Object[]) itr.next();
                        String amountType = next[0].toString();
                        double salaryAmount = (Double) next[1];
                        grossSalary += salaryAmount;
                        finalList.add(df.format(salaryAmount));

                    }
                } else {
                    finalList.add("-");
                }
            }

            boolean pfFlag = payrollPfCheckService.readForPfCheck(employeeMaster1.getEmployeeTypeMaster().getId(),
                    employeeMaster1.getEmployeeSubType().getId());
            if (pfFlag) {

                List<?> pfAmountList = payrollProvidentFundService.readPf(employeeMaster1.getZydexLocationMaster().getId());
//         for (Object oPf : pfAmountList) {
                if (!pfAmountList.isEmpty()) {
                    PayrollProvidentFund payrollProvidentFund = (PayrollProvidentFund) pfAmountList.get(0);
                    double basicSalary = Double.parseDouble(employeeMaster1.getBasicSalary());
                    double pf = Double.parseDouble(payrollProvidentFund.getPfPercentage());
                    double maxiAmount = Double.parseDouble(payrollProvidentFund.getMaximumBasicAmount());

                    double taxpf = 0;
                    if (maxiAmount <= basicSalary) {
                        taxpf = (maxiAmount * pf / 100);
                        finalList.add(df.format(taxpf));
                        deductionAmount += taxpf;
                    } else {
                        taxpf = basicSalary * pf / 100;
                        finalList.add(df.format(taxpf));
                        deductionAmount += taxpf;
                    }
                } else {

                    finalList.add("-");
                }

            } else {
                finalList.add("-");
            }
//       double additionalAmount=
            boolean ptFlag = payrollPtCheckService.readForPTCheck(employeeMaster1.getEmployeeTypeMaster().getId(),
                    employeeMaster1.getEmployeeSubType().getId());
            if (ptFlag) {

                double ptAmount = 0;
                double grossSalary1 = 0;
                double amountpt = 0;
                List<?> ptAmountList = payrollProfessionalTaxService.read();
                PayrollProfessionalTax payrollProfessionalTax = new PayrollProfessionalTax();
                for (Iterator<? extends Object> iterator = ptAmountList.iterator(); iterator.hasNext();) {
                    payrollProfessionalTax = (PayrollProfessionalTax) iterator.next();
                    double salaryForm = Double.parseDouble(payrollProfessionalTax.getSalaryFrom());
                    double salaryTo = Double.parseDouble(payrollProfessionalTax.getSalaryTo());
                    amountpt = Double.parseDouble(payrollProfessionalTax.getAmount());
                    grossSalary1 = Double.parseDouble(df.format(basicSalary1 + grossSalary));

                    if (grossSalary1 >= salaryForm && grossSalary1 <= salaryTo) {

                        break;

                    } else {
                        iterator.remove();
                    }
                }

//                List<?> ptAmountList = payrollProfessionalTaxService.readPT(grossSalary1);
                if (!ptAmountList.isEmpty()) {
//                    ptAmount = (Double) ptAmountList.get(0);
                    finalList.add(df.format(amountpt));

                } else {

                    finalList.add("-");

                }
            } else {

                finalList.add("-");

            }

            finalList.add(df.format(basicSalary1 + grossSalary));
            finalList.add(df.format(deductionAmount));
            double finalAmount = (basicSalary1 + grossSalary) - deductionAmount;
            finalList.add(df.format(finalAmount));
            List<?> ctcAllowanceList = ctcAllowanceService.read();
            for (Object o165 : ctcAllowanceList) {
                CtcAllowance ctcAllowance2 = (CtcAllowance) o165;

                List<?> list2 = employeeCtcDetailService.CtcDetailempidMasterSalary(employeeMaster1.getId(), ctcAllowance2.getId());

                if (!list2.isEmpty()) {
                    Iterator itr = list2.iterator();
                    if (itr.hasNext()) {
                        Object[] next = (Object[]) itr.next();
                        String amountType = next[0].toString();
                        double salaryAmount = (Double) next[1];
                        total += (Double) next[1];
                        finalList.add(df.format(salaryAmount));

                    }
                } else {
                    finalList.add("-");
                }
            }

            finalList.add("" + df.format((int) Math.round(total)));
            finalList.add("" + df.format((int) Math.round(total + (basicSalary1 + grossSalary - deductionAmount))));

            empMap.put(employeeMaster1.getId(), finalList);

        }

        request.setAttribute("headerList123", headerList);
        request.setAttribute("empMap", empMap);
        mv.setViewName("Payroll/EmployeeMasterSalDetailSearch");
        return mv;
    }

    public ModelAndView salaryExcelUpload(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Payroll/SalaryExcelUpload");
        return mv;
    }

//    public void readSalaryUploadFile(HttpServletRequest request,
//            HttpServletResponse response) throws Exception {
//        String fileName = request.getParameter("fileName");
//
//        String filePath = File.separator + "StorageYard" + File.separator
//                + "Other" + File.separator + "UserDoc" + File.separator
//                + "SalaryGenerate" + File.separator + fileName;
//
//        String appPath = request.getServletContext().getRealPath("");
//
//        String fullPath = appPath + filePath;
//
//        request.setAttribute("filePath", fullPath);
//
//        DownloadFile downloadFile = new DownloadFile();
//        downloadFile.doDownload(request, response);
//    }
    public ModelAndView salaryExcelUploadSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeSalaryProcess employeeSalaryProcess = new EmployeeSalaryProcess();
        EmployeeAdditionalSalary employeeAdditionalSalary = new EmployeeAdditionalSalary();
        EmployeeExcelRecord employeeExcelRecord = new EmployeeExcelRecord();
        PayrollEsicDeduction payrollEsicDeduction = new PayrollEsicDeduction();
        EmployeeDeductionAmount employeeDeductionAmount = new EmployeeDeductionAmount();
        PayrollPfRecord payrollPfRecord = new PayrollPfRecord();
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        String month1 = request.getParameter("month");
        String year11 = request.getParameter("year11");
        MultipartFile multipartFile = multipartRequest.getFile("file1");
        String employeeNo = "";
        String employeeName = "";
        String privilegeLeave = "";
        String casualLeave = "";
        String sickLeave = "";
        String paternityLeave = "";
        String absent = "";
        String lwp = "";
        String workingdays = "";
        String presentdays = "";
        String OT = "";
        String otherDeduction = "";
        String woff = "";
        String tdsexcel = "";
        String incentiveExcel = "";
        String bonusExcel = "";
//        float cLeave = 0;
//        float sLeave = 0;
//        float pLeave = 0;
//        float absent1 = 0;
//        double lwp1 = 0;
//        double OT1 = 0;
//        double otherDeduction1 = 0;
//        float workingdays1 = 0;
//        float presentdays1 = 0;
//        int count = 0;
//        double hours = 8;
        String countEmpId = "";

        PayrollSalaryLock payrollSalaryLock = new PayrollSalaryLock();
        List<?> list13 = payrollSalaryLockService.read();
        boolean checkLock = true;
        if (!list13.isEmpty()) {
            payrollSalaryLock = (PayrollSalaryLock) list13.get(0);
            int pMonth = Integer.parseInt(payrollSalaryLock.getPmonth());
            int pYear = Integer.parseInt(payrollSalaryLock.getPyear());
            if (Integer.parseInt(month1) <= pMonth && Integer.parseInt(year11) <= pYear) {
                checkLock = false;
            }

        }

        try {
            if (checkLock) {
                if (multipartFile.getSize() > 0) {
                    InputStream file = multipartFile.getInputStream();
                    Workbook workbook = WorkbookFactory.create(file);
                    Sheet sheet = workbook.getSheetAt(0);
                    for (Row row : sheet) {
                        if (row.getRowNum() != 0) {
                            try {
                                employeeNo = "" + (null == row.getCell((short) 0) ? "" : row.getCell((short) 0));
//                                employeeNo = employeeNo.split("\\.", 2)[0];
                            } catch (Exception e) {
                                employeeNo = "" + (null == row.getCell((short) 0) ? "" : row.getCell((short) 0));
                            }
//                            employeeName = "" + (null == row.getCell((short) 1) ? "" : row.getCell((short) 1));
//                            workingdays = "" + (null == row.getCell((short) 2) ? "" : row.getCell((short) 2));
////                            woff = "" + (null == row.getCell((short) 2) ? "" : row.getCell((short) 2));
//                            presentdays = "" + (null == row.getCell((short) 3) ? "" : row.getCell((short) 3));
//                            casualLeave = "" + (null == row.getCell((short) 4) ? "" : row.getCell((short) 4));
//                            sickLeave = "" + (null == row.getCell((short) 5) ? "" : row.getCell((short) 5));
//                            privilegeLeave = "" + (null == row.getCell((short) 6) ? "" : row.getCell((short) 6));
//                            absent = "" + (null == row.getCell((short) 7) ? "" : row.getCell((short) 7));
//                            lwp = "" + (null == row.getCell((short) 8) ? "" : row.getCell((short) 8));
//                            OT = "" + (null == row.getCell((short) 9) ? "" : row.getCell((short) 9));
//                            otherDeduction = "" + (null == row.getCell((short) 10) ? "" : row.getCell((short) 10));
//                            employeeName = "" + (null == row.getCell((short) 1) ? "" : row.getCell((short) 1));

                            employeeName = "" + (null == row.getCell((short) 1) ? "" : row.getCell((short) 1));
                            workingdays = "" + (null == row.getCell((short) 2) ? "" : row.getCell((short) 2));
                            woff = "" + (null == row.getCell((short) 3) ? "" : row.getCell((short) 3));
                            presentdays = "" + (null == row.getCell((short) 4) ? "" : row.getCell((short) 4));
                            casualLeave = "" + (null == row.getCell((short) 5) ? "" : row.getCell((short) 5));
//                            sickLeave = "" + (null == row.getCell((short) 5) ? "" : row.getCell((short) 5));
                            privilegeLeave = "" + (null == row.getCell((short) 6) ? "" : row.getCell((short) 6));
                            sickLeave = "" + (null == row.getCell((short) 5) ? "" : row.getCell((short) 7));
                            paternityLeave = "" + (null == row.getCell((short) 5) ? "" : row.getCell((short) 8));
                            absent = "" + (null == row.getCell((short) 7) ? "" : row.getCell((short) 9));
                            lwp = "" + (null == row.getCell((short) 8) ? "" : row.getCell((short) 10));
                            OT = "" + (null == row.getCell((short) 9) ? "" : row.getCell((short) 11));
                            otherDeduction = "" + (null == row.getCell((short) 10) ? "" : row.getCell((short) 12));
                            tdsexcel = "" + (null == row.getCell((short) 11) ? "" : row.getCell((short) 13));
                            incentiveExcel = "" + (null == row.getCell((short) 12) ? "" : row.getCell((short) 14));
                            bonusExcel = "" + (null == row.getCell((short) 13) ? "" : row.getCell((short) 15));

                            float cLeave = 0;
                            float sLeave = 0;
                            float pLeave = 0;
                            float plLeave = 0;
                            float absent1 = 0;
                            double lwp1 = 0;
                            double OT1 = 0;
                            double otherDeduction1 = 0;
                            float workingdays1 = 0;
                            float presentdays1 = 0;
                            int count = 0;
                            double hours = 8;
                            float woff1 = 0;
                            double tdsexcel1 = 0;
                            double incentiveExcel1 = 0;
                            double bonusExcel1 = 0;
                            if (!workingdays.equals("")) {
                                workingdays1 = Float.parseFloat(workingdays);
                            }
                            if (!woff.equals("")) {
                                woff1 = Float.parseFloat(woff);
                            }
                            if (!presentdays.equals("")) {
                                presentdays1 = Float.parseFloat(presentdays);
                            }
                            if (!casualLeave.equals("")) {
                                cLeave = Float.parseFloat(casualLeave);
                            }
                            if (!privilegeLeave.equals("")) {
                                pLeave = Float.parseFloat(privilegeLeave);
                            }
                            if (!sickLeave.equals("")) {
                                sLeave = Float.parseFloat(sickLeave);
                            }
                            if (!paternityLeave.equals("")) {
                                plLeave = Float.parseFloat(paternityLeave);
                            }
                            if (!absent.equals("")) {
                                absent1 = Float.parseFloat(absent);
                            }
                            if (!lwp.equals("")) {
                                lwp1 = Double.parseDouble(lwp);
                            }
                            if (!OT.equals("")) {
                                OT1 = Double.parseDouble(OT);
                            }
                            if (!otherDeduction.equals("")) {
                                otherDeduction1 = Double.parseDouble(otherDeduction);
                            }
                            if (!tdsexcel.equals("")) {
                                tdsexcel1 = Double.parseDouble(tdsexcel);
                            }
                            if (!incentiveExcel.equals("")) {
                                incentiveExcel1 = Double.parseDouble(incentiveExcel);
                            }
                            if (!bonusExcel.equals("")) {
                                bonusExcel1 = Double.parseDouble(bonusExcel);
                            }
                            EmployeeMaster employeeMaster = new EmployeeMaster();
//                            int empNo = Integer.parseInt(employeeNo);
//                            int empNo = Integer.parseInt(employeeNo);
                            String s2 = employeeNo.replace(".0", "");
                            List<?> list = employeeMasterService.readByEmployeeNo1(s2);
                            if (!list.isEmpty()) {
                                employeeMaster = (EmployeeMaster) list.get(0);
                                int empId = employeeMaster.getId();
                                EmployeeMaster employeeMaster1 = employeeMasterService.readById(empId);
                                double basicSalary = Double.parseDouble(employeeMaster1.getBasicSalary());
//                                double conveyAmount = Double.parseDouble(employeeMaster1.getConveysAmount());
//                                double tdsAmount = Double.parseDouble(employeeMaster1.getTdsAmount());

                                double leaveTxt = 0;
                                Calendar cal = Calendar.getInstance();
                                cal.set(Calendar.MONTH, (Integer.parseInt(month1) - 1));
                                int days = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
//add lwp + absent 
                                Double BothLwpABsent = lwp1 + absent1;

//                                int days = 30;
                                double basicSalary1 = basicSalary - (basicSalary * lwp1 / days);
//                            conveys start
//                                double conveyAmount1 = 0;
//                                conveyAmount1 = conveyAmount - (conveyAmount * BothLwpABsent / days);
//                            conveys end
//                            OT calculate : 
                                double OT2 = 0;
                                OT2 = OT1 * 2;
                                double perdayrate = basicSalary / days;
                                double perhoursrate = perdayrate / hours;
                                double Overtimepay = perhoursrate * OT2;

//                            OT calculate end
                                employeeSalaryProcess.setEmployeeMaster(employeeMaster1);
                                employeeSalaryProcess.setMonth(month1);
                                employeeSalaryProcess.setYear(year11);
                                List<?> list11 = employeeDeductionAmountService.readByDedutionSalaryAmount(employeeSalaryProcess);
                                for (Object pdf1 : list11) {
                                    employeeDeductionAmount = (EmployeeDeductionAmount) pdf1;
//                 Object[] o1=(Object[]) pdf;

                                    employeeDeductionAmountService.delete(employeeDeductionAmount.getId());
                                }

                                List<?> list1 = employeeAdditionalSalaryService.readByAdditionalSalaryAmount(employeeSalaryProcess);
                                for (Object pdf : list1) {
                                    employeeAdditionalSalary = (EmployeeAdditionalSalary) pdf;
//                 Object[] o1=(Object[]) pdf;

                                    employeeAdditionalSalaryService.delete(employeeAdditionalSalary.getId());
                                }

                                List<?> list32 = employeeExcelRecordService.readByEmployeExcelReport(employeeSalaryProcess);
                                for (Object o : list32) {
                                    employeeExcelRecord = (EmployeeExcelRecord) o;
                                    employeeExcelRecordService.delete(employeeExcelRecord.getId());
                                }
                                List<?> list322 = payrollEsicDeductionService.readByEmployeEsicReport(employeeSalaryProcess);
                                for (Object o : list322) {
                                    payrollEsicDeduction = (PayrollEsicDeduction) o;
                                    payrollEsicDeductionService.delete(payrollEsicDeduction.getId());
                                }
                                List<?> list32213 = payrollPfRecordService.readByEmployePfReport(employeeSalaryProcess);
                                for (Object o : list32213) {
                                    payrollPfRecord = (PayrollPfRecord) o;
                                    payrollPfRecordService.delete(payrollPfRecord.getId());
                                }
                                List<?> list3 = employeeSalaryProcessService.readByEmployeeSalaryProcess(employeeSalaryProcess);
                                for (Object o : list3) {
                                    employeeSalaryProcess = (EmployeeSalaryProcess) o;
                                    employeeSalaryProcessService.delete(employeeSalaryProcess.getId());
                                }

                                employeeSalaryProcess.setEmployeeLwp(lwp1);
                                employeeSalaryProcess.setEmployeeLeaveEncashment((double) presentdays1);
                                employeeSalaryProcess.setEmployeeBasicSalary(basicSalary1);
                                employeeSalaryProcess.setOtAmount(Overtimepay);

                                employeeSalaryProcessService.create(employeeSalaryProcess);
                                int emp = employeeSalaryProcess.getEmployeeMaster().getId();
                                int employeeSalaryprocessid = employeeSalaryProcess.getId();
                                employeeExcelRecord.setEmployeeSalaryProcess(employeeSalaryProcess);
                                employeeExcelRecord.setCasuaLeave(cLeave);
                                employeeExcelRecord.setSickLeave(woff1);// woff set in sick leave
                                employeeExcelRecord.setPleave(pLeave);
                                employeeExcelRecord.setPresentDays(presentdays1);
                                employeeExcelRecord.setWorkingDays(workingdays1);
                                employeeExcelRecord.setOtherLeave(absent1);
                                employeeExcelRecord.setOtHours(OT1);
                                employeeExcelRecord.setLwp(lwp1);
                                employeeExcelRecord.setOtAmount(Overtimepay);
                                employeeExcelRecord.setMonth(month1);
                                employeeExcelRecord.setPllleave(plLeave);
                                employeeExcelRecord.setSlleave(sLeave);
                                employeeExcelRecord.setYear(year11);

                                employeeExcelRecordService.create(employeeExcelRecord);
                                checkAdditionDaywise(employeeSalaryProcess);
//                             conveys create in Additional Salary

//                                employeeAdditionalSalary.setEmployeeSalaryProcess(employeeSalaryProcess);
//                                employeeAdditionalSalary.setPayrollSalaryType("Conveyance");
//                                employeeAdditionalSalary.setAdditionalAmount(conveyAmount1);
//                                employeeAdditionalSalaryService.create(employeeAdditionalSalary);
//                            OT Amount Create in ADDitionalSalary
                                employeeAdditionalSalary.setEmployeeSalaryProcess(employeeSalaryProcess);
                                employeeAdditionalSalary.setPayrollSalaryType("OT Amount");
                                employeeAdditionalSalary.setAdditionalAmount(Overtimepay);
                                employeeAdditionalSalaryService.create(employeeAdditionalSalary);
// incentive create in additional Salary
                                if (incentiveExcel1 != 0) {

//                                    double Incentive = incentiveExcel1 - (incentiveExcel1 * lwp1 / days);
                                    employeeAdditionalSalary.setEmployeeSalaryProcess(employeeSalaryProcess);
                                    employeeAdditionalSalary.setPayrollSalaryType("Incentive");
                                    employeeAdditionalSalary.setAdditionalAmount(incentiveExcel1);
                                    employeeAdditionalSalaryService.create(employeeAdditionalSalary);
                                }
// bonus create in additional salary 

                                if (bonusExcel1 != 0) {
//                                    double Bonus = bonusExcel1 - (bonusExcel1 * lwp1 / days);
                                    employeeAdditionalSalary.setEmployeeSalaryProcess(employeeSalaryProcess);
                                    employeeAdditionalSalary.setPayrollSalaryType("Bonus");
                                    employeeAdditionalSalary.setAdditionalAmount(bonusExcel1);
                                    employeeAdditionalSalaryService.create(employeeAdditionalSalary);
                                }

//                             other Deduction in dedudction 
//                           
                                if (tdsexcel1 != 0) {
                                    employeeDeductionAmount.setEmployeeSalaryProcess(employeeSalaryProcess);
                                    employeeDeductionAmount.setDeductionType("TDS");
                                    employeeDeductionAmount.setDeductionAmount(tdsexcel1);
                                    employeeDeductionAmountService.create(employeeDeductionAmount);
                                }
                                if (otherDeduction1 != 0) {
                                    employeeDeductionAmount.setEmployeeSalaryProcess(employeeSalaryProcess);
                                    employeeDeductionAmount.setDeductionType("Other Deduction");
                                    employeeDeductionAmount.setDeductionAmount(otherDeduction1);
                                    employeeDeductionAmountService.create(employeeDeductionAmount);
                                }

//                                if (tdsAmount != 0) {
//
//                                    employeeDeductionAmount.setEmployeeSalaryProcess(employeeSalaryProcess);
//                                    employeeDeductionAmount.setDeductionType("TDS");
//                                    employeeDeductionAmount.setDeductionAmount(tdsAmount);
//                                    employeeDeductionAmountService.create(employeeDeductionAmount);
//                                }
                                checkDeductionwise(employeeSalaryProcess);

                            }

                        }
                    }
                }
                request.setAttribute("successMessage", "Information : The Excel Uploaded Successfully.");
//               
                mv = salaryExcelUpload(request, response);
//            

            } else {

                request.setAttribute("failureMessage",
                        "Information:  Salary is a Already Lock ");
                mv = salaryExcelUpload(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("failureMessage", "Information : The Excel Not Upload Successfully. Please Check Excel Data.");
            mv = salaryExcelUpload(request, response);
        }

        return mv;

    }

    public ModelAndView downloadAttendanceGeneratedFile(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();

        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeSalaryProcess employeeSalaryProcess = new EmployeeSalaryProcess();

        if ("" != request.getParameter("month")) {
            String month = request.getParameter("month");
            String year = request.getParameter("year11");

            EmployeeAdvanceSearch employeeAdvanceSearch = new EmployeeAdvanceSearch();
            bind(request, employeeAdvanceSearch);

            String startDateCombination = "01/" + month + "/" + year;

            YearMonth yearMonthObject = YearMonth.of(Integer.parseInt(year), Integer.parseInt(month));
            int daysInMonth = yearMonthObject.lengthOfMonth(); //28

            String endDateCombination = daysInMonth + "/" + month + "/" + year;

            int rownum = 0;
            HSSFWorkbook firstFWorkbook = new HSSFWorkbook();
            HSSFSheet firstSheet = firstFWorkbook.createSheet("FIRST SHEET");
            Row headerRow = firstSheet.createRow(rownum);
            headerRow.setHeightInPoints(40);
            HSSFFont redFont = firstFWorkbook.createFont();
            redFont.setColor(HSSFColor.RED.index);
            HSSFCellStyle stylered = firstFWorkbook.createCellStyle();
            stylered.setFont(redFont);

            HSSFFont greenFont = firstFWorkbook.createFont();
            greenFont.setColor(HSSFColor.GREEN.index);
            HSSFCellStyle stylegreen = firstFWorkbook.createCellStyle();
            stylegreen.setFont(greenFont);

            HSSFFont blueFont = firstFWorkbook.createFont();
            blueFont.setColor(HSSFColor.BLUE.index);
            HSSFCellStyle styleblue = firstFWorkbook.createCellStyle();
            styleblue.setFont(blueFont);

            HSSFFont boldFont = firstFWorkbook.createFont();
            boldFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
            HSSFCellStyle styleBold = firstFWorkbook.createCellStyle();
            styleBold.setFont(boldFont);

            EmployeeShiftData employeeShiftData = new EmployeeShiftData();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            try {

                List allEmpId = new ArrayList();

                allEmpId.addAll(employeeMasterService.getAllEmployeeId());

                int earlyMinute = 0;
                int lateMinute = 0;
                for (int j = 0; j < allEmpId.size() + 1; j++) {
                    Map<Integer, List<?>> map = new LinkedHashMap<Integer, List<?>>();
                    Row row = firstSheet.createRow(rownum);
                    int id = 0;
                    if (null != startDateCombination && !startDateCombination.equals("") && null != endDateCombination && !endDateCombination.equals("")) {

                        Date sDate = sdf.parse(startDateCombination);
                        employeeShiftData.setInDateTime(new SimpleDateFormat("yyyy-MM-dd").format(sDate));

                        Date eDate = sdf.parse(endDateCombination);
                        employeeShiftData.setOutDateTime(new SimpleDateFormat("yyyy-MM-dd").format(eDate));

                        if (j == 0) {
                            List<String> headerRow1 = new ArrayList();

                            headerRow1.add("Employee No");
                            headerRow1.add("Employee Name");
                            headerRow1.add("W.Days");
                            headerRow1.add("W.off");
                            headerRow1.add("P.Days");
                            headerRow1.add("C.L");
                            headerRow1.add("P.L");
                            headerRow1.add("S.L");
                            headerRow1.add("PAT");
                            headerRow1.add("Absent");
                            headerRow1.add("L.W.P");
                            headerRow1.add("OT Hrs");
                            headerRow1.add("Other Deduction");
                            headerRow1.add("TDS");
                            headerRow1.add("Incentive");
                            headerRow1.add("Bonus");

                            for (int k1 = 0; k1 < headerRow1.size(); k1++) {
                                Cell cell = row.createCell(k1);

                                cell.setCellValue(headerRow1.get(k1));

                                cell.setCellStyle(styleBold);
                            }
//                            rownum++;
                        }
                        if (j > 1) {
                            id = Integer.parseInt("" + allEmpId.get(j - 1));
                            employeeShiftData.setId(id);
                            List<?> list = employeeShiftDataService.empOrDateWiseSearch(employeeShiftData);
                            map.put(id, list);

                            List<String> firstHalfList = new ArrayList<String>();
                            EmployeeMaster empMaster = employeeMasterService.readById(id);
                            firstHalfList.add("" + empMaster.getEmployeeId());
                            firstHalfList.add("" + empMaster.getEmployeeName());

                            double prcounter = 0;
                            double abcounter = 0;
                            double wo = 0;
                            double cl = 0;
                            double sl = 0;
                            double pl = 0;
                            double ar = 0;
                            double lwp = 0;
                            double otHrs = 0;
                            double otherDeduction = 0;
                            double tds = 0;
                            double incentive = 0;
                            double bonus = 0;
                            double pat = 0;

//                            Integer otMinuteCounter = 0;
                            String otHourFinal = "";

//                            int otHoursMinutes1 = 0;
                            for (Map.Entry<Integer, List<?>> entry : map.entrySet()) {

                                Iterator itr5 = entry.getValue().iterator();
                                int otMinuteCounter = 0;

                                while (itr5.hasNext()) {
                                    Object[] next2 = (Object[]) itr5.next();

                                    String firstHalf = "" + next2[1];
                                    int firstHalfVal = 0;
                                    int counter = 0;

                                    Date date = sdf.parse("" + next2[0]);
                                    Calendar c = Calendar.getInstance();
                                    c.setTime(date);
                                    int dayOfWeek = c.get(Calendar.WEEK_OF_MONTH);
                                    SimpleDateFormat format = new SimpleDateFormat("EEEE");
                                    String dayName = format.format(date);
                                    SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm");
//                                    boolean checkLunchTime = false;
                                    SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                                    int n = 1;
                                    long lunchTime = 0;
                                    long outTime = 0;
                                    long totalDayTime = 0;
                                    long totalDayTime1 = 0;
                                    long totalTime = 0;
                                    long shiftdiffMinutes = 0;
                                    String startTime = "";
                                    String endTime = "";
                                    int d = 1;
                                    int s = 2;
                                    if (!firstHalf.equals("null") && firstHalf != null) {

                                        if (firstHalf.contains("fullday")) {
//                                       firstHalfList.add("PR");
                                            prcounter = prcounter + 1;

                                        } else if (!firstHalf.contains("fullday") && !firstHalf.equals("WO") && !firstHalf.equals("TR") && !firstHalf.equals("AR") && !firstHalf.equals("AB") && !firstHalf.contains("?")
                                                && !firstHalf.equals("Casual Leave") && !firstHalf.equals("Short Leave") && !firstHalf.equals("C Off Leave") && !firstHalf.equals("Privilege Leave") && !firstHalf.equals("Sick Leave")
                                                && !firstHalf.equals("Paternity Leave") && !firstHalf.equals("Maternity Leave") && !firstHalf.equals("Leave Without Pay")) {
                                            String[] userTimeInStr = firstHalf.split("`");
                                            String[] userTimeInStr1 = userTimeInStr[1].split("!");
                                            String[] userTimeOutStr = firstHalf.split("!");
                                            String[] userTimeOutStr1 = userTimeOutStr[1].split("@");
                                            String[] leave = firstHalf.split("@");
                                            String[] leave1 = leave[1].split("#");
                                            String[] LateHoursStr = firstHalf.split("\\$");
                                            String[] LateHoursStr1 = LateHoursStr[1].split("%");
                                            String[] endHoursStr = firstHalf.split("%");
                                            String[] endHoursStr1 = endHoursStr[1].split("\\^");
                                            String[] firstStartHoursStr = endHoursStr[1].split("\\+");
                                            Date userTimeIn = sdf1.parse(userTimeInStr1[0]);
                                            Date userTimeOut = sdf1.parse(userTimeOutStr1[0]);
                                            Date endHours = sdf1.parse(endHoursStr1[0]);
                                            Date firstStartHours = sdf1.parse(firstStartHoursStr[1]);
                                            Calendar cal = Calendar.getInstance();
                                            Calendar cal1 = Calendar.getInstance();
                                            cal.setTime(firstStartHours);
                                            cal1.setTime(firstStartHours);
                                            cal1.add(Calendar.MINUTE, -earlyMinute);
                                            cal.add(Calendar.MINUTE, lateMinute);
                                            String newTime = sdf1.format(cal.getTime());
                                            Date flexibleEndTime = sdf1.parse(newTime);
                                            Date LateHours = sdf1.parse(LateHoursStr1[0]);
                                            String newTime1 = sdf1.format(cal1.getTime());
                                            Date flexibleStartTime = sdf1.parse(newTime1);
                                            long diff = endHours.getTime() - firstStartHours.getTime();
                                            long diffMinutes = diff / (60 * 1000);
                                            long diff1 = 0;

                                            if (userTimeInStr[0].contains("0.5")) {
//                                        firstHalfList.add("Half AB");
                                                abcounter = abcounter + 0.5;
                                                prcounter = prcounter + 0.5;
                                            } else if (userTimeInStr[0].contains("0")) {
//                                        firstHalfList.add("AB");
                                                abcounter = abcounter + 1;
                                            } else if (firstHalf.contains("AR") && userTimeInStr[0].contains("0.5")) {
//                                        firstHalfList.add("Half AR/P");
                                                ar = ar + 0.5;
                                                prcounter = prcounter + 0.5;
                                            }

                                        } else if (firstHalf.equals("WO")) {
//                                    firstHalfList.add("WO");
                                            wo = wo + 1;
                                        } else if (firstHalf.contains("AR")) {
//                                    firstHalfList.add("AR/P");
                                            ar = ar + 1;
                                        } else if (firstHalf.equals("AB")) {
//                                    firstHalfList.add("AB");
                                            abcounter = abcounter + 1;
                                        } else {
                                            if (firstHalf.equals("Casual Leave")) {
                                                cl = cl + 1;
                                            }
                                            if (firstHalf.equals("Privilege Leave")) {
                                                pl = pl + 1;
                                            }
                                            if (firstHalf.equals("Sick Leave")) {
                                                sl = sl + 1;
                                            }
//                                    if (firstHalf.equals("Maternity Leave")) {
//                                        ml = ml + 1;
//                                    }
                                            if (firstHalf.equals("Paternity Leave")) {
                                                pat = pat + 1;
                                            }
//                                    if (firstHalf.equals("C Off Leave")) {
//                                        col = col + 1;
//                                    }
                                            if (firstHalf.equals("Leave Without Pay")) {
                                                lwp = lwp + 1;
                                            }
//                                    firstHalfList.add(" " + firstHalf);
                                        }

                                        List listPunch = employeeDatetimeDataService.readPuchDataDateWise("" + next2[0], id);

                                        if (listPunch.size() > 0 && !firstHalf.contains("WO") && !firstHalf.contains("TR") && !firstHalf.contains("AR") && !firstHalf.contains("AB")) {

                                            if (listPunch.size() > 2) {
                                                while (listPunch.size() > d && listPunch.size() > s) {

                                                    Object[] startLunchTime = (Object[]) listPunch.get(d);
                                                    Object[] endLunchTime = (Object[]) listPunch.get(s);
                                                    startTime = (String) startLunchTime[0];
                                                    endTime = (String) endLunchTime[0];
                                                    Date launchStrTime = sdf3.parse(startTime);
                                                    Date launchEndTime = sdf3.parse(endTime);
                                                    long diff = launchEndTime.getTime() - launchStrTime.getTime();
                                                    lunchTime = diff / (60 * 1000);
                                                    outTime = outTime + lunchTime;
                                                    d = d + 2;
                                                    s = s + 2;
                                                }
                                            }

                                            try {
                                                if (!firstHalf.equals("Casual Leave") && !firstHalf.equals("Short Leave")
                                                        && !firstHalf.equals("C Off Leave") && !firstHalf.equals("Privilege Leave") && !firstHalf.equals("Sick Leave")
                                                        && !firstHalf.equals("Paternity Leave") && !firstHalf.equals("Maternity Leave") && !firstHalf.equals("Leave Without Pay")) {

                                                    String[] userTimeInStr = firstHalf.split("`");
                                                    String[] userTimeInStr1 = userTimeInStr[1].split("!");
                                                    String[] userTimeOutStr = firstHalf.split("!");
                                                    String[] userTimeOutStr1 = userTimeOutStr[1].split("@");
                                                    Date userTimeIn = sdf1.parse(userTimeInStr1[0]);
                                                    Date userTimeOut = sdf1.parse(userTimeOutStr1[0]);
                                                    Date userTimeOut1 = sdf1.parse("23:59");
                                                    String[] startHoursStr = firstHalf.split("%");
                                                    String[] firstStartHoursStr = startHoursStr[1].split("\\+");
                                                    String[] endHoursStr = firstHalf.split("&");
                                                    Date firstStartHours = sdf1.parse(firstStartHoursStr[1]);
                                                    Calendar cal1 = Calendar.getInstance();
                                                    cal1.setTime(firstStartHours);
                                                    cal1.add(Calendar.MINUTE, -earlyMinute);
                                                    String newTime1 = sdf1.format(cal1.getTime());
//                                        Date flexibleInTime = sdf1.parse(newTime1);
                                                    Date endHours = sdf1.parse(endHoursStr[1]);
                                                    long shiftTotalTime = endHours.getTime() - firstStartHours.getTime();
//                                        shiftdiffMinutes = shiftTotalTime / (60 * 1000);

//                                        long sumOfActualHours = firstStartHours.getTime()+endHours.getTime();
                                                    long sumOfHoursForOT = userTimeOut.getTime() - userTimeIn.getTime();

                                                    long diff = Math.abs(sumOfHoursForOT) - Math.abs(shiftTotalTime);

                                                    if (diff < 0 || diff == 0) {
                                                    } else {
                                                        totalDayTime = diff / (60 * 1000);
                                                        double empHour = (double) totalDayTime / 60;
                                                        int hours = (int) empHour;
                                                        int minutes = (int) (empHour * 60) % 60;

                                                        String totalHour1 = "" + hours;
                                                        String totalMinute1 = "" + minutes;

                                                        int otMinuteCounter1 = ((Integer.parseInt(totalHour1) * 60) + Integer.parseInt(totalMinute1));

                                                        int hours3 = (int) otMinuteCounter1 / 60;
                                                        int minutes3 = (int) otMinuteCounter1 % 60;

                                                        if (hours3 >= 1) {
                                                            otMinuteCounter += (hours3 * 60);
                                                        } else {
                                                            otMinuteCounter += 0;
                                                        }

                                                        if (minutes3 >= 0 && minutes3 < 30) {
                                                            otMinuteCounter += 0;
                                                        } else if ((minutes3 > 30 && minutes3 < 60) && hours3 >= 1) {
                                                            otMinuteCounter += 30;
                                                        } else {
                                                            otMinuteCounter += 0;
                                                        }

                                                    }
                                                }
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }

                                        } else {
                                            otMinuteCounter += 0;
                                        }
                                    } else {
                                        otMinuteCounter += 0;
                                    }
                                    n++;
                                }

                                int hours3 = (int) otMinuteCounter / 60;
                                int minutes3 = (int) otMinuteCounter % 60;
//                                String totalHour1 = "";

//                                if (hours3 >= 1) {
//                                    totalHour1 += hours3 + ".";
//                                } else {
//                                    totalHour1 += "0.";
//                                }
//
//                                if (minutes3 >= 0 && minutes3 < 30) {
//                                    totalHour1 += "0";
//                                } else if ((minutes3 > 30 && minutes3 < 60) && hours3 >= 1) {
//                                    totalHour1 += "30";
//                                } else {
//                                    totalHour1 += "0";
//                                }
//                                
                                otHourFinal = hours3 + "." + minutes3;
                            }

                            firstHalfList.add("" + (list.size() - wo));
                            firstHalfList.add("" + wo);
                            firstHalfList.add("" + (list.size() - abcounter));
                            firstHalfList.add("" + cl);
//                        firstHalfList.add("" + sl);
                            firstHalfList.add("" + pl);
                            firstHalfList.add("" + sl);
                            firstHalfList.add("" + pat);
                            firstHalfList.add("" + (abcounter - wo));
                            firstHalfList.add("" + (abcounter - wo));//where lwp = ab

                            firstHalfList.add(otHourFinal);

                            firstHalfList.add("" + otherDeduction);
                            firstHalfList.add("" + tds);
                            firstHalfList.add("" + incentive);
                            firstHalfList.add("" + bonus);

                            Row row1 = firstSheet.createRow(rownum - 1);
                            for (int k1 = 0; k1 < firstHalfList.size(); k1++) {
                                Cell cell = row1.createCell(k1);

                                cell.setCellValue(firstHalfList.get(k1));

                                cell.setCellStyle(styleBold);
                            }

                        }

                        rownum++;
                    }

                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
            }

            String appPath = request.getServletContext().getRealPath("");

            try {
                String filePath = appPath + File.separator + "StorageYard" + File.separator
                        + "Other" + File.separator + "UserDoc" + File.separator
                        + "Attendance" + File.separator + "SalaryExcelDownload1.xls";
                FileOutputStream fos = new FileOutputStream(new File(filePath));
                HSSFCellStyle hsfstyle = firstFWorkbook.createCellStyle();
                hsfstyle.setBorderBottom((short) 1);
                hsfstyle.setFillBackgroundColor((short) 245);
                firstFWorkbook.write(fos);
            } catch (Exception e) {
                e.printStackTrace();
            }

            String filePath = File.separator + "StorageYard" + File.separator
                    + "Other" + File.separator + "UserDoc" + File.separator
                    + "Attendance" + File.separator + "SalaryExcelDownload1.xls";

            appPath = request.getServletContext().getRealPath("");

            String fullPath = appPath + filePath;

            request.setAttribute(
                    "filePath", fullPath);

            DownloadFile downloadFile = new DownloadFile();

            downloadFile.doDownload(request, response);
            mv = salaryExcelUpload(request, response);
            return mv;
        }
        request.setAttribute("failureMessage",
                "Information : Please Select The Month.");
        mv = salaryExcelUpload(request, response);
        return mv;
    }
    @SuppressWarnings("unchecked")
    public ModelAndView searchSalaryDetailSubmitPrint(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeSalaryProcess employeeSalaryProcess = new EmployeeSalaryProcess();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeType employeeType = new EmployeeType();
        EmployeeSubType employeeSubType = new EmployeeSubType();

        HttpSession session = request.getSession();
        String zydex_location_id = request.getParameter("zydexlocationid");
        String type_of_employee = request.getParameter("typeofemployee");
        String employee_sub_id = request.getParameter("employeesubid");
        String payment_type = request.getParameter("paymenttype");
        String month1 = request.getParameter("month");
        String year11 = request.getParameter("year");

        if (!zydex_location_id.equals("")) {
            employeeMaster.setAdharCard(zydex_location_id);
        }

        if (!type_of_employee.equals("")) {
            employeeMaster.setEmployeeType(type_of_employee);
        }
        if (null != employee_sub_id && !employee_sub_id.equals("")) {
            employeeMaster.setCompany(employee_sub_id);
        }

        if (!payment_type.equals("")) {
            employeeMaster.setPaymentType(payment_type);

        }
        if (!month1.equals("")) {
            employeeMaster.setBankName(month1);

        }
        if (!year11.equals("")) {
            employeeMaster.setChild1(year11);

        }

//        if (!"".equals(month1)) {
//            employeeSalaryProcess.setMonth(month1);
//        }
//        if (!"".equals(year11)) {
//            employeeSalaryProcess.setYear(year11);
//        }
        DecimalFormat df = new DecimalFormat("####0.00");

        List<String> headerList = new ArrayList<String>();
        headerList.add("Emp Company Code");
        headerList.add("Emp Id");
        headerList.add("Emp Name");
        headerList.add("P.Day");
        headerList.add("Basic Salary");

//        List<?> list1 = employeeSalaryProcessService.readSal(employeeMaster);
        List<?> list1 = employeeSalaryProcessService.readsalSearch(employeeMaster);
        for (Object o1 : list1) {
            Object str[] = (Object[]) o1;
            if (!headerList.contains("" + str[5]) && null != str[5]) {
                headerList.add("" + str[5]);
            }

        }
        headerList.add("Gross Salary");
//        List<?> list2 = employeeSalaryProcessService.readsalDeduction(employeeMaster);
        List<?> list2 = employeeSalaryProcessService.readsalDeductionSearch(employeeMaster);
        for (Object o1 : list2) {
            Object str1[] = (Object[]) o1;
            if (!headerList.contains("" + str1[2]) && null != str1[2]) {
                headerList.add("" + str1[2]);
            }
        }

        headerList.add("Tot.Dedn");
        headerList.add("Net Pay");
        List<?> list6 = ctcAllowanceService.read();
        CtcAllowance ctcAllowance = new CtcAllowance();
//        Map<Integer, String> leaveTypemap = new HashMap();
        for (Object o : list6) {
            ctcAllowance = (CtcAllowance) o;
            headerList.add("" + ctcAllowance.getCtcName());
        }
        headerList.add("Total");
        headerList.add("CTCPerMonth");

        List<EmployeeSalaryProcess> empList = (List<EmployeeSalaryProcess>) employeeSalaryProcessService.readEmpSalaryReport(employeeMaster);
        List<Object> finalList = new LinkedList<Object>();
        for (EmployeeSalaryProcess employeeSalaryProcess1 : empList) {
            Map<String, String> empMap = new HashMap<String, String>();
            double additionalAmount = 0.0;
            double deductionAmount = 0.0;
            double total = 0.0;
            EmployeeExcelRecord employeeExcelRecord1 = new EmployeeExcelRecord();
            EmployeeMaster employeeMaster1 = employeeMasterService.readById(employeeSalaryProcess1.getEmployeeMaster().getId());
            List<?> list = employeeExcelRecordService.readByEmployeExcelReportSearch(employeeSalaryProcess1);
//            List tempList = (List) list.get(0);
            empMap.put("Emp Company Code", "" + employeeMaster1.getEmployeeLocation());
            empMap.put("Emp Id", "" + employeeMaster1.getEmployeeId());
            empMap.put("Emp Name", employeeMaster1.getEmployeeName());
            empMap.put("P.Day", "" + list.get(0));
//            empMap.put("Basic Salary", "" + df.format(employeeSalaryProcess1.getEmployeeBasicSalary()));
            empMap.put("Basic Salary", "" + df.format((int) Math.round(employeeSalaryProcess1.getEmployeeBasicSalary())));

//            List addSalaryList = employeeAdditionalSalaryService.readEmployeeForSalaryAdditionalinfo(employeeSalaryProcess1);
            List addSalaryList = employeeAdditionalSalaryService.readEmployeeForSalaryAdditionalinfoSearch(employeeSalaryProcess1);
            for (Object addSalaryList1 : addSalaryList) {
                Object[] o = (Object[]) addSalaryList1;
//                empMap.put("" + o[0], "" + df.format(o[1]));
                empMap.put("" + o[0], "" + df.format((int) Math.round((double) o[1])));
//                additionalAmount += (Double) o[1];
//                  int netpayable1 = (int) Math.round(additionalAmount);
                additionalAmount += (Double) o[1];
            }
            additionalAmount += employeeSalaryProcess1.getEmployeeBasicSalary();
//            empMap.put("Gross Salary", "" + df.format(additionalAmount));
            empMap.put("Gross Salary", "" + df.format((int) Math.round(additionalAmount)));
//            List dedSalaryList = employeeDeductionAmountService.readEmployeeForSalaryDeductioninfo(employeeSalaryProcess1);
            List dedSalaryList = employeeDeductionAmountService.readEmployeeForSalaryDeductioninfoSearch(employeeSalaryProcess1);
            for (Object dedSalaryList1 : dedSalaryList) {
                Object[] o = (Object[]) dedSalaryList1;
//                empMap.put("" + o[0], "" + df.format(o[1]));
                empMap.put("" + o[0], "" + df.format((int) Math.round((double) o[1])));
                deductionAmount += (Double) o[1];
            }

//            empMap.put("Deduction Amount", "" + df.format(deductionAmount));
            empMap.put("Tot.Dedn", "" + df.format((int) Math.round(deductionAmount)));
            empMap.put("Net Pay", "" + df.format((int) Math.round(additionalAmount - deductionAmount)));
//            empMap.put("Net Amount", "" + df.format(additionalAmount - deductionAmount));
            List ctcList = employeeCtcDetailService.fetchctcData(employeeSalaryProcess1.getEmployeeMaster().getId());
            for (Object dedSalaryList2 : ctcList) {
                Object[] o5 = (Object[]) dedSalaryList2;
//                empMap.put("" + o[0], "" + df.format(o[1]));
                empMap.put("" + o5[1], "" + df.format((int) Math.round((double) o5[2])));
                total += (Double) o5[2];
            }
            empMap.put("Total", "" + df.format((int) Math.round(total)));
            empMap.put("CTCPerMonth", "" + df.format((int) Math.round(total + (additionalAmount - deductionAmount))));
            finalList.add(empMap);
        }

//      
        request.setAttribute("headerList123", headerList);
        request.setAttribute("finalList", finalList);
        request.setAttribute("month", month1);
        request.setAttribute("year", year11);
        request.setAttribute("zydexlocationid", zydex_location_id);
        request.setAttribute("typeofemployee", type_of_employee);
        request.setAttribute("employeesubid", employee_sub_id);
        request.setAttribute("paymenttype", payment_type);
       

        mv.setViewName("Payroll/EmployeeSalarySearchPrint");

        return mv;
    }
     @SuppressWarnings("unchecked")
    public ModelAndView searchSalaryDetailSubmit1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeSalaryProcess employeeSalaryProcess = new EmployeeSalaryProcess();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeExcelRecord employeeExcelRecord = new EmployeeExcelRecord();
        EmployeeType employeeType = new EmployeeType();
        EmployeeSubType employeeSubType = new EmployeeSubType();
        Map<String, String> empMap1 = new HashMap<String, String>();
        HttpSession session = request.getSession();
        String zydex_location_id = request.getParameter("zydexLocationMasterId");
        String type_of_employee = request.getParameter("employeeTypeMasterId");
        String employee_sub_id = request.getParameter("subTypeId");
        String payment_type = request.getParameter("paymentType");
        String month1 = request.getParameter("month");
        String year11 = request.getParameter("year11");
        Double basicSalarytotal = 0.0;
        Double additionaltotal = 0.0;
        Double deductiontotal = 0.0;
        Double netpaytotal = 0.0;
        float totdayTotal = 0;
        if (!zydex_location_id.equals("")) {
            employeeMaster.setAdharCard(zydex_location_id);
        }

        if (!type_of_employee.equals("")) {
            employeeMaster.setEmployeeType(type_of_employee);
        }
        if (null != employee_sub_id && !employee_sub_id.equals("")) {
            employeeMaster.setCompany(employee_sub_id);
        }

        if (!payment_type.equals("")) {
            employeeMaster.setPaymentType(payment_type);

        }
        if (!month1.equals("")) {
            employeeMaster.setBankName(month1);

        }
        if (!year11.equals("")) {
            employeeMaster.setChild1(year11);

        }

//        if (!"".equals(month1)) {
//            employeeSalaryProcess.setMonth(month1);
//        }
//        if (!"".equals(year11)) {
//            employeeSalaryProcess.setYear(year11);
//        }
        DecimalFormat df = new DecimalFormat("####0.00");

        List<String> headerList = new ArrayList<String>();
        List<String> headerList1 = new ArrayList<String>();
        List<String> headerList2 = new ArrayList<String>();
        List<String> headerList3 = new ArrayList<String>();
        List<String> headerList4 = new ArrayList<String>();
//        headerList.add("Emp Id");
        headerList.add("Emp Name");
        headerList.add("P.Day PH/Woff");
        headerList.add("PL CL/SL");
        headerList.add("TotDay");
        headerList1.add("Basic Amt");
        headerList.add("");

//        List<?> list1 = employeeSalaryProcessService.readSal(employeeMaster);
        List<?> list1 = employeeSalaryProcessService.readsalSearch(employeeMaster);
        for (Object o1 : list1) {
            Object str[] = (Object[]) o1;
            if (!headerList1.contains("" + str[5]) && null != str[5]) {
                headerList1.add("" + str[5]);
            }

        }
//        List<?> list2 = employeeSalaryProcessService.readsalDeduction(employeeMaster);
        List<?> list2 = employeeSalaryProcessService.readsalDeductionSearch(employeeMaster);
        for (Object o1 : list2) {
            Object str1[] = (Object[]) o1;
            if (!headerList2.contains("" + str1[2]) && null != str1[2]) {
                headerList2.add("" + str1[2]);
            }
        }

        headerList3.add("Tot.Earn " + "<br>" + "<br>" + "<br>" + "Tot.Dedu");
//        headerList3.add("Tot.Dedn");
        headerList3.add("Net Pay");
        headerList3.add("Signature");
        List<EmployeeSalaryProcess> empList = (List<EmployeeSalaryProcess>) employeeSalaryProcessService.readEmpSalaryReport(employeeMaster);
        List<Object> finalList = new LinkedList<Object>();
        List<Object> finalList1 = new LinkedList<Object>();
        for (EmployeeSalaryProcess employeeSalaryProcess1 : empList) {
            Map<String, String> empMap = new HashMap<String, String>();

            double additionalAmount = 0.0;
            double deductionAmount = 0.0;

            EmployeeExcelRecord employeeExcelRecord1 = new EmployeeExcelRecord();
            EmployeeMaster employeeMaster1 = employeeMasterService.readById(employeeSalaryProcess1.getEmployeeMaster().getId());
            float presentDays = 0;
            float weekoff = 0;
            float pl = 0;
            float cl = 0;
            float totday = 0;

            List<?> list = employeeExcelRecordService.readByEmployeExcelReportSearch(employeeSalaryProcess1);
            for (Object o : list) {
                employeeExcelRecord = (EmployeeExcelRecord) o;
//                presentDays = employeeExcelRecord.getPresentDays();
//                weekoff = employeeExcelRecord.getSickLeave();
//                pl = employeeExcelRecord.getPleave();
//                cl = employeeExcelRecord.getCasuaLeave();
//                totday = employeeExcelRecord.getWorkingDays();
                totdayTotal += (float) totday;
//                payrollPfRecordService.delete(payrollPfRecord.getId());
            }
            String Pfnum = "";
            String employeeID = employeeMaster1.getEmployeeId();
            Pfnum = employeeMaster1.getPfNo();
            String employeeName = employeeMaster1.getEmployeeName();
            String EmployeePfNAme = new String();
            EmployeePfNAme = "Emp Code: " + employeeID + "<br>" + employeeName + "<br>" + "Pf NO: " + Pfnum;
            String pday = new String();
            pday = presentDays + "<br>" + weekoff;
            String plday = new String();
            plday = pl + "<br>" + cl;
            String earnDec = new String();
            earnDec = "Earn " + "<br>" + "<br>" + "Dedu";

            empMap.put("Emp Name", EmployeePfNAme);
//            empMap.put("Emp Name", employeeMaster1.getEmployeeId());
            empMap.put("P.Day PH/Woff", "" + pday);
            empMap.put("PL CL/SL", "" + plday);
            empMap.put("TotDay", "" + totday);
//            empMap.put("Basic Salary", "" + df.format(employeeSalaryProcess1.getEmployeeBasicSalary()));
            empMap.put("Basic Amt", "" + df.format((int) Math.round(employeeSalaryProcess1.getEmployeeBasicSalary())));
            basicSalarytotal += (Double) employeeSalaryProcess1.getEmployeeBasicSalary();
            empMap.put("", "" + earnDec);

//            List addSalaryList = employeeAdditionalSalaryService.readEmployeeForSalaryAdditionalinfo(employeeSalaryProcess1);
            List addSalaryList = employeeAdditionalSalaryService.readEmployeeForSalaryAdditionalinfoSearch(employeeSalaryProcess1);
            for (Object addSalaryList1 : addSalaryList) {
                Object[] o = (Object[]) addSalaryList1;
//                empMap.put("" + o[0], "" + df.format(o[1]));
                empMap.put("" + o[0], "" + df.format((int) Math.round((double) o[1])));

//                additionalAmount += (Double) o[1];
//                  int netpayable1 = (int) Math.round(additionalAmount);
                additionalAmount += (Double) o[1];

            }
//            List dedSalaryList = employeeDeductionAmountService.readEmployeeForSalaryDeductioninfo(employeeSalaryProcess1);
            List dedSalaryList = employeeDeductionAmountService.readEmployeeForSalaryDeductioninfoSearch(employeeSalaryProcess1);
            for (Object dedSalaryList1 : dedSalaryList) {
                Object[] o = (Object[]) dedSalaryList1;
//                empMap.put("" + o[0], "" + df.format(o[1]));
                empMap.put("" + o[0], "" + df.format((int) Math.round((double) o[1])));
                deductionAmount += (Double) o[1];
            }
            additionalAmount += employeeSalaryProcess1.getEmployeeBasicSalary();
//            empMap.put("Gross Salary", "" + df.format(additionalAmount));

            additionaltotal += additionalAmount;
            deductiontotal += deductionAmount;
            empMap.put("Tot.Earn " + "<br>" + "<br>" + "<br>" + "Tot.Dedu", "" + df.format((int) Math.round(additionalAmount)) + "<br>" + "<br>" + df.format((int) Math.round(deductionAmount)));
//            empMap.put("Deduction Amount", "" + df.format(deductionAmount));
//            empMap.put("Tot.Dedn", "" + df.format((int) Math.round(deductionAmount)));
            empMap.put("Net Pay", "" + df.format((int) Math.round(additionalAmount - deductionAmount)));
            netpaytotal += (additionalAmount - deductionAmount);
            empMap.put("Signature", "" + "<br>" + "<br>" + "<br>");
//            empMap.put("Net Amount", "" + df.format(additionalAmount - deductionAmount));
            finalList.add(empMap);

            /// total 
        }

//        empMap1.put("Emp Name", "Total :");
        empMap1.put("Emp Name", "Total :");
        empMap1.put("P.Day PH/Woff", "");
        empMap1.put("PL CL/SL", "");
        empMap1.put("TotDay", "" + totdayTotal);
        empMap1.put("Basic Amt", "" + df.format((int) Math.round(basicSalarytotal)));
        List<?> list152 = employeeAdditionalSalaryService.readadditionalAllownaceName(month1, year11);
        for (Object o1 : list152) {
            String str = (String) o1;
            List<?> list1521 = employeeAdditionalSalaryService.readadditionalAMountSalaryRegister(str, month1, year11);
            for (Object o11 : list1521) {
                double str1 = (double) o11;
                empMap1.put("" + str, "" + df.format((int) Math.round((double) str1)));
            }
        }
        List<?> list15245 = employeeDeductionAmountService.readadditionalAllownaceName(month1, year11);
        for (Object o1 : list15245) {
            String str = (String) o1;
            List<?> list1521425 = employeeDeductionAmountService.readadditionalAMountSalaryRegister(str, month1, year11);
            for (Object o11 : list1521425) {
                double str1 = (double) o11;
                empMap1.put("" + str, "" + df.format((int) Math.round((double) str1)));
            }
        }
        empMap1.put("Tot.Earn " + "<br>" + "<br>" + "<br>" + "Tot.Dedu", "" + df.format((int) Math.round(additionaltotal)) + "<br>" + "<br>" + df.format((int) Math.round(deductiontotal)));
        empMap1.put("Net Pay", "" + df.format((int) Math.round(netpaytotal)));
        empMap1.put("Signature", "" + "<br>" + "<br>" + "<br>");

        finalList1.add(empMap1);
//      }
        request.setAttribute("headerList123", headerList);
        request.setAttribute("headerList1234", headerList1);
        request.setAttribute("headerList12345", headerList2);
        request.setAttribute("headerList123456", headerList3);
        request.setAttribute("finalList", finalList);
        request.setAttribute("finalList1", finalList1);
        request.setAttribute("month", month1);
        request.setAttribute("year", year11);

        mv.setViewName("Payroll/employeesalarySearchNewResiger");

        return mv;
    }


}
