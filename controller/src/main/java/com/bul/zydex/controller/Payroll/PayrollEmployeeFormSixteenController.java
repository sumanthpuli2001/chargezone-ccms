/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.EmployeeSalaryProcess;
import com.bul.zydex.model.EmployeeSubType;
import com.bul.zydex.model.EmployeeType;
import com.bul.zydex.model.EmployeeTypeMaster;
import com.bul.zydex.model.PayrollFinancialYear;
import com.bul.zydex.model.PayrollFormSixteenMaster;
import com.bul.zydex.model.ZydexLocationMaster;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Irfan <irfanbhindawala@gmail.com>
 */
public class PayrollEmployeeFormSixteenController extends PayrollEmployeeFormSixteenAbstract {

    public ModelAndView redirectToFormSexteen(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeTypeMaster employeeTypeMaster = new EmployeeTypeMaster();
        ZydexLocationMaster zydexLocationMaster = new ZydexLocationMaster();
        EmployeeSubType employeeSubType = new EmployeeSubType();

        EmployeeTypeList(request);
        EmployeeSubTypeList(request);
        zydexLocationList(request);
        financialYearList(request);
        selectEmployee(request, response);
        request.setAttribute("search", request.getParameter("search"));
        mv.getModelMap().put("employeeTypeMaster", employeeTypeMaster);
        mv.setViewName("Payroll/PayrollFormSixteenSearch");
        return mv;
    }

    public ModelAndView searchFormSixteenDetailSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeSalaryProcess employeeSalaryProcess = new EmployeeSalaryProcess();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeType employeeType = new EmployeeType();
        EmployeeSubType employeeSubType = new EmployeeSubType();

        String zydex_location_id = request.getParameter("zydexLocationMasterId");
        String type_of_employee = request.getParameter("employeeTypeMasterId");
        String employee_sub_id = request.getParameter("subTypeId");
        String Financial_year = request.getParameter("fnyear");
        String Employee_Name = request.getParameter("employeeMasterId");

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
//
        if (!Financial_year.equals("")) {
            employeeMaster.setPaymentType(Financial_year);

        }

        if (!Employee_Name.equals("")) {
            employeeMaster.setEmployeeName(Employee_Name);

        }

        List<?> list = employeeSalaryProcessService.readEmployeeForFormSixteen(employeeMaster);
        request.setAttribute("employeelist", list);
        mv = redirectToFormSexteen(request, response);
        return mv;
    }

    public ModelAndView ViewIndiviualFormSixteen(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        EmployeeSalaryProcess employeeSalaryProcess = new EmployeeSalaryProcess();
//        EmployeeMaster employeeMaster = new EmployeeMaster();
        String id = request.getParameter("id");
        String financialYearId = request.getParameter("financialYearId");
        EmployeeMaster employeeMaster = employeeMasterService.readById(Integer.parseInt(id));

        DesignationMaster designationMaster = designationMasterService.readById(employeeMaster.getDesignationMaster().getId());
        employeeMaster.setDesignationMaster(designationMaster);
        PayrollFinancialYear payrollFinancialYear = new PayrollFinancialYear();
        PayrollFormSixteenMaster payrollFormSixteenMaster = new PayrollFormSixteenMaster();
        payrollFinancialYear.setId(Integer.parseInt(financialYearId));

        List<PayrollFormSixteenMaster> financialYearList = checkformSixteenMaster(payrollFinancialYear, employeeMaster);
        if (!financialYearList.isEmpty()) {
            payrollFormSixteenMaster = (PayrollFormSixteenMaster) financialYearList.get(0);
            payrollFormSixteenMaster.setPayrollFinancialYear(
                    payrollFinancialYearService.readById(payrollFormSixteenMaster.getPayrollFinancialYear().getId()));
        }
//          PayrollSavingAmount payrollSavingAmount = new PayrollSavingAmount();
        List<?> payrollSavingAmountList = payrollSavingAmountService.readCheckEmployeeSaving(Integer.parseInt(id), Integer.parseInt(financialYearId));
        double totalSavinglist = 0;
        Iterator itr1 = payrollSavingAmountList.iterator();
        while (itr1.hasNext()) {
            Object[] next = (Object[]) itr1.next();
            totalSavinglist += (Double) next[1];

        }
        payrollFinancialYear = payrollFinancialYearService.readById(payrollFinancialYear.getId());
        List<?> employeeDeductionAmountList = employeeDeductionAmountService.readCheckDeductionAmount(Integer.parseInt(id), payrollFinancialYear);
        List<?> employeeAdditionalAmountList = employeeAdditionalSalaryService.readCheckAdditionalAmount(Integer.parseInt(id), payrollFinancialYear);
        double totalBasicSalary = 0;
        double totalAdditionalAmount = 0;
        Iterator itr = employeeAdditionalAmountList.iterator();
        while (itr.hasNext()) {
            Object[] next = (Object[]) itr.next();
            totalBasicSalary += (Double) next[0];
            totalAdditionalAmount += (Double) next[1];
        }
        double totallist = totalBasicSalary + totalAdditionalAmount;
        List<?> employeeDeductionPtAmountList = employeeDeductionAmountService.readCheckDeductionPtAmount(Integer.parseInt(id), payrollFinancialYear);

        mv.getModelMap().put("employeeSalaryProcess", employeeSalaryProcess);
        request.setAttribute("employeeMaster", employeeMaster);
        request.setAttribute("payrollFormSixteenMaster", payrollFormSixteenMaster);
        request.setAttribute("payrollSavingAmountList", payrollSavingAmountList);
        request.setAttribute("totallist", totallist);
        request.setAttribute("totalSavinglist", totalSavinglist);
        request.setAttribute("employeeDeductionAmountList", employeeDeductionAmountList);
        request.setAttribute("employeeDeductionPtAmountList", employeeDeductionPtAmountList);
        mv.setViewName("Payroll/FormSixteenForm");
        return mv;
    }

    private List<PayrollFormSixteenMaster> checkformSixteenMaster(PayrollFinancialYear payrollFinancialYear, EmployeeMaster employeeMaster) {
        PayrollFormSixteenMaster payrollFormSixteenMaster = new PayrollFormSixteenMaster();
        payrollFormSixteenMaster.setPayrollFinancialYear(payrollFinancialYear);
        payrollFormSixteenMaster.setZydexLocationMaster(employeeMaster.getZydexLocationMaster());

        List list = payrollFormSixteenMasterService.payRollSearchIdCheck(payrollFormSixteenMaster);

        return list;
    }

    public ModelAndView redirectToFormEmployeeSaving(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeTypeMaster employeeTypeMaster = new EmployeeTypeMaster();
        ZydexLocationMaster zydexLocationMaster = new ZydexLocationMaster();
        EmployeeSubType employeeSubType = new EmployeeSubType();

        EmployeeTypeList(request);
        EmployeeSubTypeList(request);
        zydexLocationList(request);
        financialYearList(request);
        selectEmployee(request, response);
        request.setAttribute("search", request.getParameter("search"));
        mv.getModelMap().put("employeeTypeMaster", employeeTypeMaster);
        mv.setViewName("Payroll/PayrollEmployeeSavingForm");
        return mv;
    }

    public ModelAndView searchFormEmployeeSavingDetailSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeSalaryProcess employeeSalaryProcess = new EmployeeSalaryProcess();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeType employeeType = new EmployeeType();
        EmployeeSubType employeeSubType = new EmployeeSubType();

        String zydex_location_id = request.getParameter("zydexLocationMasterId");
        String type_of_employee = request.getParameter("employeeTypeMasterId");
        String employee_sub_id = request.getParameter("subTypeId");
        String Financial_year = request.getParameter("fnyear");
        String Employee_Name = request.getParameter("employeeMasterId");

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
//
        if (!Financial_year.equals("")) {
            employeeMaster.setPaymentType(Financial_year);

        }

        if (!Employee_Name.equals("")) {
            employeeMaster.setEmployeeName(Employee_Name);

        }

        List<?> list = employeeSalaryProcessService.readEmployeeForFormSixteen(employeeMaster);
        request.setAttribute("employeelist", list);
        mv = redirectToFormEmployeeSaving(request, response);
        return mv;
    }

    public ModelAndView viewClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeSalaryProcess employeeSalaryProcess = new EmployeeSalaryProcess();

        String id = request.getParameter("id");
        String financialYearId = request.getParameter("financialYearId");
        EmployeeMaster employeeMaster = employeeMasterService.readById(Integer.parseInt(id));
        PayrollFormSixteenMaster payrollFormSixteenMaster = new PayrollFormSixteenMaster();
        PayrollFinancialYear payrollFinancialYear = new PayrollFinancialYear();
        payrollFinancialYear = payrollFinancialYearService.readById(Integer.parseInt(financialYearId));

        List<PayrollFormSixteenMaster> financialYearList = checkformSixteenMaster(payrollFinancialYear, employeeMaster);
        if (!financialYearList.isEmpty()) {
            payrollFormSixteenMaster = (PayrollFormSixteenMaster) financialYearList.get(0);

        }
        payrollFormSixteenMaster.setPayrollFinancialYear(payrollFinancialYear);
        List totalList = new ArrayList();
        List finalData = new ArrayList();
        List<?> taxDeduction = payrollTaxDeductionMasterService.readTaxDeductionForFormSixteen();
        if (!taxDeduction.isEmpty()) {
            List taxDeductionList = new ArrayList();
            for (Object taxDeductionList1 : taxDeduction) {
                List finalDatatemp = new ArrayList();
                Object[] o = (Object[]) taxDeductionList1;
                Integer taxdeductionid = (Integer) o[0];
                String selection = (String) o[1];
                String description = (String) o[2];
                finalDatatemp.add(selection);
                List<?> taxDeductioncomponent = payrollTaxDeductionComponentService.readTaxDeductionComponentforFromSixteen(taxdeductionid);
                List taxDeductioncomponentList = new ArrayList();
                List taxDeductioncomponentIDList = new ArrayList();
                if (!taxDeductioncomponent.isEmpty()) {
                    taxDeductionList.add(selection);
                    for (Object taxDeductionListcompmet1 : taxDeductioncomponent) {
                        Object[] o1 = (Object[]) taxDeductionListcompmet1;
                        Integer taxdeductionid1 = (Integer) o1[0];
                        taxDeductioncomponentIDList.add(taxdeductionid1);

                        String compoment = (String) o1[1];
                        taxDeductioncomponentList.add(compoment);
                        Integer agelimit = (Integer) o1[2];
                        Integer taxSavingLimit = (Integer) o1[3];
                    }

                    finalDatatemp.add(taxDeductioncomponentList);
                    finalDatatemp.add(taxDeductioncomponentIDList);
                }

                finalData.add(finalDatatemp);
            }

        }

        mv.getModelMap().put("employeeSalaryProcess", employeeSalaryProcess);
        request.setAttribute("employeeMaster", employeeMaster);
//        request.setAttribute("totalList", totalList);
        request.setAttribute("finalData", finalData);
        request.setAttribute("payrollFormSixteenMaster", payrollFormSixteenMaster);
        mv.setViewName("Payroll/PayrollEmployeeSavingView");
        return mv;
    }
}
