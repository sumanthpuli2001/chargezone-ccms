/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.model.EmployeeAdditionalSalary;
import com.bul.zydex.model.EmployeeDeductionAmount;
import com.bul.zydex.model.EmployeeExcelRecord;
import com.bul.zydex.model.EmployeeLeaveBalance;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.EmployeePolicyDetail;
import com.bul.zydex.model.EmployeeSalaryProcess;
import com.bul.zydex.model.EmployeeSubType;
import com.bul.zydex.model.EmployeeType;
import com.bul.zydex.model.LeaveTypeMaster;
import com.bul.zydex.model.PayrollAdditionalAmount;
import com.bul.zydex.model.PayrollBonus;
import com.bul.zydex.model.PayrollDeduction;
import com.bul.zydex.model.PayrollEsicDeduction;
import com.bul.zydex.model.PayrollLoanDetail;
import com.bul.zydex.model.PayrollLoanRemainingAmount;
import com.bul.zydex.model.PayrollLoanType;
import com.bul.zydex.model.PayrollProfessionalTax;
import com.bul.zydex.model.PayrollProvidentFund;
import com.bul.zydex.model.PayrollRecurringAdditionalAmount;
import com.bul.zydex.model.PayrollRecurringDeduction;
import com.bul.zydex.model.PayrollSalaryLock;
import com.bul.zydex.model.PayrollSalaryType;
import com.bul.zydex.util.DownloadFile;
import java.io.File;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
            
            employeeAdditionalSalary.setEmployeeSalaryProcess(employeeSalaryProcess);
            employeeAdditionalSalary.setPayrollSalaryType(policyName);
            employeeAdditionalSalary.setAdditionalAmount(PolicyAmount);
            employeeAdditionalSalaryService.create(employeeAdditionalSalary);

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
        employeeMaster = employeeMasterService.readById(employeeSalaryProcess.getEmployeeMaster().getId());

        boolean pfFlag = payrollPfCheckService.readForPfCheck(employeeMaster.getEmployeeTypeMaster().getId(),
                employeeMaster.getEmployeeSubType().getId());

        if (pfFlag) {
            List<?> pfAmountList = payrollProvidentFundService.readPf(employeeMaster.getZydexLocationMaster().getId());
//         for (Object oPf : pfAmountList) {
            double maxiAmount = 0;
            if (!pfAmountList.isEmpty()) {
                PayrollProvidentFund payrollProvidentFund = (PayrollProvidentFund) pfAmountList.get(0);
                double basicSalary = employeeSalaryProcess.getEmployeeBasicSalary();
                double pf = Double.parseDouble(payrollProvidentFund.getPfPercentage());
                maxiAmount = Double.parseDouble(employeeMaster.getPfAmount());

                double taxpf = 0;
                if (maxiAmount <= basicSalary) {

                    taxpf = (maxiAmount * pf / 100);

                    employeeDeductionAmount.setEmployeeSalaryProcess(employeeSalaryProcess);
                    employeeDeductionAmount.setDeductionType("Provident Fund");
                    employeeDeductionAmount.setDeductionAmount(taxpf);
                    employeeDeductionAmountService.create(employeeDeductionAmount);
                } else {
                    taxpf = basicSalary * pf / 100;

                    employeeDeductionAmount.setEmployeeSalaryProcess(employeeSalaryProcess);
                    employeeDeductionAmount.setDeductionType("Provident Fund");
                    employeeDeductionAmount.setDeductionAmount(taxpf);
                    employeeDeductionAmountService.create(employeeDeductionAmount);
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
        double netSalarywithOtamount1 = (Double.parseDouble(employeeMaster.getBasicSalary()) + Double.parseDouble(employeeMaster.getConveysAmount()) + additionalAmtwithoutOtAmount);

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

//        TDs start here
        double tdsAmount = Double.parseDouble(employeeMaster1.getTdsAmount());

        if (tdsAmount != 0) {

            employeeDeductionAmount.setEmployeeSalaryProcess(employeeSalaryProcess);
            employeeDeductionAmount.setDeductionType("TDS");
            employeeDeductionAmount.setDeductionAmount(tdsAmount);
            employeeDeductionAmountService.create(employeeDeductionAmount);
        }

        /// tds end here  
        ////////////////////// PT Ends Here ///////////////////////////
        /////////////////////ESIC Start Here///////////////////////
        if (employeeMaster1.getEsic() == true) {

            double nettotalEsic = 0;
            double emptotalEsic = 0;
            double comptotalEsic = 0;
            double otEsic = 0;
            double otEsicNet = 0;
            if (netSalarywithOtamount1 <= 21000) {

                nettotalEsic = netSalary * 1.75 / 100;
//emp contrubtion of esic
                emptotalEsic = netSalary * 1.75 / 100;
//            comp contribution of esic
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
//        List<?> list2 = employeeSalaryProcessService.readsalDeduction(employeeMaster);
        List<?> list2 = employeeSalaryProcessService.readsalDeductionSearch(employeeMaster);
        for (Object o1 : list2) {
            Object str1[] = (Object[]) o1;
            if (!headerList.contains("" + str1[2]) && null != str1[2]) {
                headerList.add("" + str1[2]);
            }
        }
        headerList.add("Gross Salary");
        headerList.add("Tot.Dedn");
        headerList.add("Net Pay");
        List<EmployeeSalaryProcess> empList = (List<EmployeeSalaryProcess>) employeeSalaryProcessService.readEmpSalaryReport(employeeMaster);
        List<Object> finalList = new LinkedList<Object>();
        for (EmployeeSalaryProcess employeeSalaryProcess1 : empList) {
            Map<String, String> empMap = new HashMap<String, String>();
            double additionalAmount = 0.0;
            double deductionAmount = 0.0;
            EmployeeExcelRecord employeeExcelRecord1 = new EmployeeExcelRecord();
            EmployeeMaster employeeMaster1 = employeeMasterService.readById(employeeSalaryProcess1.getEmployeeMaster().getId());
            List<?> list = employeeExcelRecordService.readByEmployeExcelReportSearch(employeeSalaryProcess1);
//            List tempList = (List) list.get(0);
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
            empMap.put("Gross Salary", "" + df.format((int) Math.round(additionalAmount)));
//            empMap.put("Deduction Amount", "" + df.format(deductionAmount));
            empMap.put("Tot.Dedn", "" + df.format((int) Math.round(deductionAmount)));
            empMap.put("Net Pay", "" + df.format((int) Math.round(additionalAmount - deductionAmount)));
//            empMap.put("Net Amount", "" + df.format(additionalAmount - deductionAmount));
            finalList.add(empMap);
        }

//      
        request.setAttribute("headerList123", headerList);
        request.setAttribute("finalList", finalList);
        request.setAttribute("month", month1);
        request.setAttribute("year", year11);

        mv.setViewName("Payroll/EmployeeSalarySearch");

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

        List<?> salaryTypeList = payrollSalaryTypeService.read();
        for (Object o1 : salaryTypeList) {
            PayrollSalaryType payrollSalaryType = (PayrollSalaryType) o1;
            headerList.add(payrollSalaryType.getText());
        }

        headerList.add("PF");
        headerList.add("PT");
        headerList.add("Total Gross Salary");
        headerList.add("Deductional Amount");
        headerList.add("NetSalary Amount");
        List<EmployeeMaster> empList = (List<EmployeeMaster>) employeeSalaryProcessService.readEmpMasterSalary(employeeMaster);

        for (EmployeeMaster employeeMaster1 : empList) {
            DecimalFormat df = new DecimalFormat("#.##");
            List<Object> finalList = new ArrayList();
            finalList.add(employeeMaster1.getEmployeeId());
            finalList.add(employeeMaster1.getEmployeeName());
            finalList.add(employeeMaster1.getBasicSalary());

            double basicSalary1 = Double.parseDouble(employeeMaster1.getBasicSalary());
            double grossSalary = 0;
            double deductionAmount = 0;

            List<?> salaryTypeList1 = payrollSalaryTypeService.read();
            for (Object o1 : salaryTypeList1) {
                PayrollSalaryType payrollSalaryType = (PayrollSalaryType) o1;

                List<?> list = employeeTypeWiseSalaryService.readForMasterAdditionalAmount(employeeMaster1.getEmployeeTypeMaster().getId(),
                        employeeMaster1.getEmployeeSubType().getId(), payrollSalaryType.getId());
                if (!list.isEmpty()) {
                    Iterator itr = list.iterator();
                    if (itr.hasNext()) {
                        Object[] next = (Object[]) itr.next();
                        int salaryTypeId = (Integer) next[0];
                        String amountType = next[2].toString();
                        double salaryAmount = (Double) next[3];

                        if (amountType.equals("value")) {

                            finalList.add(df.format(salaryAmount));
                            grossSalary += salaryAmount;
                        } else {
                            double basicSalary = Double.parseDouble(employeeMaster1.getBasicSalary());
                            double additionalAmount = (salaryAmount / 100) * basicSalary;
                            finalList.add(df.format(additionalAmount));
                            grossSalary += additionalAmount;
                        }

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
                List<?> ptAmountList = payrollProfessionalTaxService.read();
                PayrollProfessionalTax payrollProfessionalTax = new PayrollProfessionalTax();
                for (Iterator<? extends Object> iterator = ptAmountList.iterator(); iterator.hasNext();) {
                    payrollProfessionalTax = (PayrollProfessionalTax) iterator.next();
                    double salaryForm = Double.parseDouble(payrollProfessionalTax.getSalaryFrom());
                    double salaryTo = Double.parseDouble(payrollProfessionalTax.getSalaryTo());

                    if (salaryForm >= grossSalary && salaryTo <= grossSalary) {

                        break;

                    } else {
                        iterator.remove();
                    }
                }

//            List<?> ptAmountList = payrollProfessionalTaxService.readPT(grossSalary);
                if (!ptAmountList.isEmpty()) {
                    ptAmount = (Double) ptAmountList.get(0);
                    finalList.add(df.format(ptAmount));

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

    public void readSalaryUploadFile(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        String fileName = request.getParameter("fileName");

        String filePath = File.separator + "StorageYard" + File.separator
                + "Other" + File.separator + "UserDoc" + File.separator
                + "SalaryGenerate" + File.separator + fileName;

        String appPath = request.getServletContext().getRealPath("");

        String fullPath = appPath + filePath;

        request.setAttribute("filePath", fullPath);

        DownloadFile downloadFile = new DownloadFile();
        downloadFile.doDownload(request, response);
    }

    public ModelAndView salaryExcelUploadSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeSalaryProcess employeeSalaryProcess = new EmployeeSalaryProcess();
        EmployeeAdditionalSalary employeeAdditionalSalary = new EmployeeAdditionalSalary();
        EmployeeExcelRecord employeeExcelRecord = new EmployeeExcelRecord();
        PayrollEsicDeduction payrollEsicDeduction = new PayrollEsicDeduction();
        EmployeeDeductionAmount employeeDeductionAmount = new EmployeeDeductionAmount();
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
                                employeeNo = new BigDecimal("" + (null == row.getCell((short) 0) ? "" : row.getCell((short) 0))).toPlainString();
                                employeeNo = employeeNo.split("\\.", 2)[0];
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

                            employeeName = "" + (null == row.getCell((short) 1) ? "" : row.getCell((short) 1));
                            workingdays = "" + (null == row.getCell((short) 2) ? "" : row.getCell((short) 2));
                            woff = "" + (null == row.getCell((short) 3) ? "" : row.getCell((short) 3));
                            presentdays = "" + (null == row.getCell((short) 4) ? "" : row.getCell((short) 4));
                            casualLeave = "" + (null == row.getCell((short) 5) ? "" : row.getCell((short) 5));
//                            sickLeave = "" + (null == row.getCell((short) 5) ? "" : row.getCell((short) 5));
                            privilegeLeave = "" + (null == row.getCell((short) 6) ? "" : row.getCell((short) 6));
                            absent = "" + (null == row.getCell((short) 7) ? "" : row.getCell((short) 7));
                            lwp = "" + (null == row.getCell((short) 8) ? "" : row.getCell((short) 8));
                            OT = "" + (null == row.getCell((short) 9) ? "" : row.getCell((short) 9));
                            otherDeduction = "" + (null == row.getCell((short) 10) ? "" : row.getCell((short) 10));
                            tdsexcel = "" + (null == row.getCell((short) 11) ? "" : row.getCell((short) 11));
                            incentiveExcel = "" + (null == row.getCell((short) 12) ? "" : row.getCell((short) 12));
                            bonusExcel = "" + (null == row.getCell((short) 13) ? "" : row.getCell((short) 13));

                            float cLeave = 0;
                            float sLeave = 0;
                            float pLeave = 0;
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
                            int empNo = Integer.parseInt(employeeNo);
                            List<?> list = employeeMasterService.readByEmployeeNo(empNo);
                            if (!list.isEmpty()) {
                                employeeMaster = (EmployeeMaster) list.get(0);
                                int empId = employeeMaster.getId();
                                EmployeeMaster employeeMaster1 = employeeMasterService.readById(empId);
                                double basicSalary = Double.parseDouble(employeeMaster1.getBasicSalary());
                                double conveyAmount = Double.parseDouble(employeeMaster1.getConveysAmount());
                                double tdsAmount = Double.parseDouble(employeeMaster1.getTdsAmount());

                                double leaveTxt = 0;
//                                Calendar cal = Calendar.getInstance();
//                                cal.set(Calendar.MONTH, (Integer.parseInt(month1) - 1));
//                                int days = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
//add lwp + absent 
                                Double BothLwpABsent = lwp1 + absent1;

                                int days = 30;
                                double basicSalary1 = basicSalary - (basicSalary * lwp1 / days);
//                            conveys start
                                double conveyAmount1 = 0;
                                conveyAmount1 = conveyAmount - (conveyAmount * BothLwpABsent / days);
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
                                List<?> list3 = employeeSalaryProcessService.readByEmployeeSalaryProcess(employeeSalaryProcess);
                                for (Object o : list3) {
                                    employeeSalaryProcess = (EmployeeSalaryProcess) o;
                                    employeeSalaryProcessService.delete(employeeSalaryProcess.getId());
                                }

                                employeeSalaryProcess.setEmployeeLwp(lwp1);
                                employeeSalaryProcess.setEmployeeLeaveEncashment(leaveTxt);
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
                                employeeExcelRecord.setYear(year11);

                                employeeExcelRecordService.create(employeeExcelRecord);
                                checkAdditionDaywise(employeeSalaryProcess);
//                             conveys create in Additional Salary

                                employeeAdditionalSalary.setEmployeeSalaryProcess(employeeSalaryProcess);
                                employeeAdditionalSalary.setPayrollSalaryType("Conveyance");
                                employeeAdditionalSalary.setAdditionalAmount(conveyAmount1);
                                employeeAdditionalSalaryService.create(employeeAdditionalSalary);
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

}
