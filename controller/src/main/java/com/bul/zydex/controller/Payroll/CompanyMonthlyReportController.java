/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.model.EmployeeSalaryProcess;
import com.bul.zydex.model.PayrollSalaryType;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author OptiPlex
 */
public class CompanyMonthlyReportController extends CompanyMonthlyReportAbstract {

    public ModelAndView searchCompanyMonthlyReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeSalaryProcess employeeSalaryProcess = new EmployeeSalaryProcess();
        List<?> list = (List<?>) request.getAttribute("accountWiseList");
        request.setAttribute("accountWiseList", list);
        request.setAttribute("search", request.getParameter("search"));
        mv.getModelMap().put("employeeSalaryProcess", employeeSalaryProcess);
        mv.setViewName("Payroll/CompanyMonthlyReport");
        return mv;
    }

    public ModelAndView onSearchClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        DecimalFormat df = new DecimalFormat("####0.00");
        EmployeeSalaryProcess employeeSalaryProcess = new EmployeeSalaryProcess();
        String month = request.getParameter("month");
        String year = request.getParameter("year11");
        Double additonalAmount = 0.0D;
        Double basicSalary = 0.0D;
        Double otAmount = 0.0D;
        List finalList = new ArrayList();
        String payrollType = "";
        Double deductionAmount = 0.0D;
        String deductionType = "";
        Double policyAmount = 0.0D;
        String policyType = "";
        List basicSalaryList = new ArrayList();
        List OTAmountList = new ArrayList();
        List compareList = new ArrayList();               //Just to compare if list contatins the elements 
        List listForMonthAndYear = new ArrayList();
        Double totalCreditedAmount = 0.0D;
        Double totalDebitedAmount = 0.0D;
        List creditDebitList = new ArrayList();
        List netsalaryList = new ArrayList();
        String companyName = "";
        int flag = 0;

        HttpSession session = request.getSession();

        if (!"".equals(month)) {
            employeeSalaryProcess.setMonth(month);
        }
        if (!"".equals(year)) {
            employeeSalaryProcess.setYear(year);
        }
        //Code to fetch list of basic salary of employess
        List<?> listOfBasicSalaryAndOTAmt = employeeSalaryProcessService.readOTAmountAndSalary(employeeSalaryProcess);
        for (Object basicSalaryAndOTAmt : listOfBasicSalaryAndOTAmt) {
            Object[] basicSalaryAndOTAmtObj = (Object[]) basicSalaryAndOTAmt;
            basicSalary = basicSalary + (Double) basicSalaryAndOTAmtObj[0];
            otAmount = otAmount + (Double) basicSalaryAndOTAmtObj[1];
        }
        int basicSalary1 = (int) Math.round(basicSalary);
        Double basicSalary2 = Double.parseDouble(String.valueOf(basicSalary1));

        basicSalaryList.add("Salary");
        basicSalaryList.add(basicSalary2);
        basicSalaryList.add("");
        finalList.add(basicSalaryList);

//        OTAmountList.add("OT Amount");
//        OTAmountList.add(otAmount);
//        OTAmountList.add("");
//        finalList.add(OTAmountList);
        //Code to fetch list of additional salaries
        List<?> listOfAdditionalSalary = employeeSalaryProcessService.readAdditionalSalary(employeeSalaryProcess);
        for (int i = 0; i < listOfAdditionalSalary.size(); i++) {
            List additionalSalaryList = new ArrayList();
            Object[] payrollSalaryTypeList = (Object[]) listOfAdditionalSalary.get(i);
            if (null != payrollSalaryTypeList[1] && null != payrollSalaryTypeList[0]) {
                payrollType = (String) payrollSalaryTypeList[0];
                additonalAmount = (Double) payrollSalaryTypeList[1];
                for (int j = i + 1; j < listOfAdditionalSalary.size(); j++) {
                    Object[] payrollSalaryTypeListForComparison = (Object[]) listOfAdditionalSalary.get(j);
                    if (payrollSalaryTypeList[0].equals(payrollSalaryTypeListForComparison[0])) {
                        payrollType = (String) payrollSalaryTypeListForComparison[0];
                        if (!additionalSalaryList.contains(payrollType)) {
                            additonalAmount = additonalAmount + (Double) payrollSalaryTypeListForComparison[1];

                        }
                    }
                }
                if (!compareList.contains(payrollType)) {
                    int additonalAmount1 = (int) Math.round(additonalAmount);
                    Double additonalAmount12 = Double.parseDouble(String.valueOf(additonalAmount1));

                    additionalSalaryList.add(payrollType);
                    additionalSalaryList.add(additonalAmount12);
                    additionalSalaryList.add("");
                    finalList.add(additionalSalaryList);
                    compareList.add(payrollType);
                }
                additonalAmount = 0.0D;

            }
        }

        //Code to fetch list of deduction amounts
        List<?> listOfDeductionAmounts = employeeSalaryProcessService.readDeductionAmounts(employeeSalaryProcess);
        for (int i = 0; i < listOfDeductionAmounts.size(); i++) {
            List listOfdeductionAmount = new ArrayList();
            Object[] deductionAmountList = (Object[]) listOfDeductionAmounts.get(i);
            if (null != deductionAmountList[1] && null != deductionAmountList[0]) {
                deductionAmount = (Double) deductionAmountList[1];
                deductionType = (String) deductionAmountList[0];
                for (int j = i + 1; j < listOfDeductionAmounts.size(); j++) {
                    Object[] deductionAmountListForComparison = (Object[]) listOfDeductionAmounts.get(j);
                    if (deductionAmountList[0].equals(deductionAmountListForComparison[0])) {
                        deductionType = (String) deductionAmountListForComparison[0];
                        if (!listOfdeductionAmount.contains(deductionType)) {
                            deductionAmount = deductionAmount + (Double) deductionAmountListForComparison[1];
                        }
                    }
                }
                if (!compareList.contains(deductionType)) {
                      int deductionAmount1 = (int) Math.round(deductionAmount);
                    Double deductionAmount12 = Double.parseDouble(String.valueOf(deductionAmount1));

                    listOfdeductionAmount.add(deductionType);
                    listOfdeductionAmount.add("");
                    listOfdeductionAmount.add(deductionAmount12);
                    finalList.add(listOfdeductionAmount);
                    compareList.add(deductionType);
                }
                deductionAmount = 0.0D;
            }
        }

        //Code to fetch list of Employee Policy amounts
        List<?> employeePolicyAmounts = employeeSalaryProcessService.readEmployeePolicyAmounts(employeeSalaryProcess);
        for (int i = 0; i < employeePolicyAmounts.size(); i++) {
            List listOfPolicyAmount = new ArrayList();
            Object[] employeeObjectList = (Object[]) employeePolicyAmounts.get(i);
            companyName = (String) employeeObjectList[2];
            if (null != employeeObjectList[1] && null != employeeObjectList[0]) {
                policyAmount = (Double) employeeObjectList[1];
                policyType = (String) employeeObjectList[0];
                for (int j = i + 1; j < employeePolicyAmounts.size(); j++) {
                    Object[] policyAmountListForComparison = (Object[]) employeePolicyAmounts.get(j);
                    if (employeeObjectList[0].equals(policyAmountListForComparison[0])) {
                        policyType = (String) policyAmountListForComparison[0];
                        if (!listOfPolicyAmount.contains(payrollType)) {
                            policyAmount = policyAmount + (Double) policyAmountListForComparison[1];

                        }
                    }
                }
                if (!compareList.contains(policyType)) {
                    listOfPolicyAmount.add(policyType);
                    listOfPolicyAmount.add("");
                    listOfPolicyAmount.add(policyAmount);
                    finalList.add(listOfPolicyAmount);
                    compareList.add(policyType);
                }
                policyAmount = 0.0D;

            }
        }

        for (int i = 0; i < finalList.size(); i++) {
            List tempTotalList = (List) finalList.get(i);
            if (null != tempTotalList.get(2)) {
                if (!tempTotalList.get(1).equals("")) {
                    totalDebitedAmount = totalDebitedAmount + (Double) tempTotalList.get(1);
                }
            }
            if (null != tempTotalList.get(2)) {
                if (!tempTotalList.get(2).equals("")) {
                    totalCreditedAmount = totalCreditedAmount + (Double) tempTotalList.get(2);
                }
            }
        }
        for (int i = 0; i < finalList.size(); i++) {
            List tempFinalList = (List) finalList.get(i);
            if ((tempFinalList.get(1).equals("") && tempFinalList.get(2).equals(0.0)) || (tempFinalList.get(2).equals("") && tempFinalList.get(1).equals(0.0))) {
                flag++;
            }
        }
        creditDebitList.add("-- TOTAL --");
        creditDebitList.add(totalDebitedAmount);
        creditDebitList.add(totalCreditedAmount);

        finalList.add(creditDebitList);
        netsalaryList.add("-- NET SALARY --");
        netsalaryList.add(totalDebitedAmount - totalCreditedAmount);
        finalList.add(netsalaryList);

        listForMonthAndYear.add(finalList);
        listForMonthAndYear.add(month);
        listForMonthAndYear.add(year);
        listForMonthAndYear.add(companyName);

        if (flag == finalList.size() - 1) { //Size-1 bcoz data of "TOTAL"  is not needed to be compared
            listForMonthAndYear.add("empty");
        } else {
            listForMonthAndYear.add("not empty");
        }

        request.setAttribute("accountWiseList", listForMonthAndYear);
        request.setAttribute("month", month);
        request.setAttribute("year", year);
        mv = searchCompanyMonthlyReport(request, response);
        return mv;
    }

}
