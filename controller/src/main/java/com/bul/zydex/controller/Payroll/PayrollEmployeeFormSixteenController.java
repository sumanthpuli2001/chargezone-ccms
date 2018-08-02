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
import com.bul.zydex.model.PayrollTaxDeductionComponent;
import com.bul.zydex.model.PayrollTaxDeductionMaster;
import com.bul.zydex.model.TaxDeductionDecarationSubmit;
import com.bul.zydex.model.TaxSavingSubmit;
import com.bul.zydex.model.ZydexLocationMaster;
import com.bul.zydex.util.DownloadFile;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
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

        double totallist = 0.00;
        totallist += totalBasicSalary + totalAdditionalAmount;

        //adding policydetail amount to total gross;
        try {
            List<Double> employeePolicyDetailAmountList = (List<Double>) employeePolicyDetailService.readBypolicyAmountWithTaxable(Integer.parseInt(id));
            if (employeePolicyDetailAmountList != null && employeePolicyDetailAmountList.size() > 0) {
                if (employeePolicyDetailAmountList.get(0) != null && !employeePolicyDetailAmountList.get(0).equals("")) {
                    totallist += employeePolicyDetailAmountList.get(0);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //adding pt amount;
        double deductionPtAmount = 0.00;
        try {
            List<?> employeeDeductionPtAmountList = employeeDeductionAmountService.readCheckDeductionPtAmount(Integer.parseInt(id), payrollFinancialYear);
            if (employeeDeductionPtAmountList != null && employeeDeductionPtAmountList.size() > 0) {
                Object[] o = (Object[]) employeeDeductionPtAmountList.get(0);
                String s = (String) o[1];
                if (s != null && !s.equals("")) {
                    deductionPtAmount += Double.parseDouble(s);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<String> sectionNameList = new ArrayList<String>();
        List<List> component80CList = new ArrayList<List>();
        List<List> tdsList = new ArrayList<List>();
        //adding pf amount;
        double deductionPfAmount = 0.00;
        double tdsTotal = 0.00;
        try {
            List<?> employeeDeductionPfAmountList = employeeDeductionAmountService.readCheckDeductionAmount(Integer.parseInt(id), payrollFinancialYear);
            if (employeeDeductionPfAmountList != null && employeeDeductionPfAmountList.size() > 0) {
                Object[] o = (Object[]) employeeDeductionPfAmountList.get(0);
                String s = (String) o[1];
                if (s != null && !s.equals("")) {
                    deductionPfAmount += Double.parseDouble(s);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            List<?> sectionComponentAmountList = taxDeductionDecarationSubmitService.readComponentAmountByEmployeeId(Integer.parseInt(id), Integer.parseInt(financialYearId));
            if (!sectionComponentAmountList.isEmpty()) {

                Iterator itrSectionComponent = (Iterator) sectionComponentAmountList.iterator();
                while (itrSectionComponent.hasNext()) {
                    Object[] next = (Object[]) itrSectionComponent.next();
                    sectionNameList.add("" + next[0]);
                    if (next[0].equals("80C")) {
                        List list = new ArrayList();
                        list.add("" + next[1]);
                        list.add("" + next[2]);
                        component80CList.add(list);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            List<?> tdsAmountList = employeeDeductionAmountService.readEmployeeTdsAmountWithMonth(Integer.parseInt(id), payrollFinancialYear.getStartDate(), payrollFinancialYear.getEndDate());
//            if (!tdsAmountList.isEmpty()) {

                List dates = new ArrayList<>();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                SimpleDateFormat dateFormat1 = new SimpleDateFormat("MM/yyyy");

                Calendar beginCalendar = Calendar.getInstance();
                Calendar finishCalendar = Calendar.getInstance();

                try {
                    beginCalendar.setTime(dateFormat.parse(payrollFinancialYear.getStartDate()));
                    finishCalendar.setTime(dateFormat.parse(payrollFinancialYear.getEndDate()));
                } catch (Exception e) {
                    e.printStackTrace();
                }

                while (beginCalendar.before(finishCalendar)) {
                    List finalListTemp = new ArrayList();
                    String date = dateFormat1.format(beginCalendar.getTime());
                    dates.add(date);
                    finalListTemp.add(date);
                    finalListTemp.add("" + 0.00);
                    tdsList.add(finalListTemp);
                    beginCalendar.add(Calendar.MONTH, 1);
                }
                List onlyDatesFromDb = new ArrayList();
                for (Object l1 : tdsAmountList) {
                    Object[] next = (Object[]) l1;
                    onlyDatesFromDb.add(next[1]);
                }

                 for (int i = 0; i < onlyDatesFromDb.size(); i++) {
                    if (dates.indexOf("" + onlyDatesFromDb.get(i)) > 0) {
                        int index = dates.indexOf("" + onlyDatesFromDb.get(i));
                        Object[] next = (Object[]) tdsAmountList.get(i);
                        Double a = (Double) next[2];
                        ((List) tdsList.get(index)).set(1,a);
                        tdsTotal += a;
                    }
                }
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        mv.getModelMap()
                .put("employeeSalaryProcess", employeeSalaryProcess);
        request.setAttribute(
                "employeeMaster", employeeMaster);
        request.setAttribute(
                "payrollFormSixteenMaster", payrollFormSixteenMaster);
        request.setAttribute(
                "payrollSavingAmountList", payrollSavingAmountList);
        request.setAttribute(
                "totallist", totallist);
        request.setAttribute(
                "totalSavinglist", totalSavinglist);
        request.setAttribute(
                "employeeDeductionAmountList", employeeDeductionAmountList);
        request.setAttribute(
                "employeeDeductionPtAmountList", deductionPtAmount);
        request.setAttribute(
                "deductionPfAmount", deductionPfAmount);
        request.setAttribute(
                "component80CList", component80CList);
        request.setAttribute(
                "tdsList", tdsList);
        request.setAttribute(
                "tdsTotal", tdsTotal);
        mv.setViewName(
                "Payroll/FormSixteenForm");
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

//        EmployeeTypeList(request);
//        EmployeeSubTypeList(request);
//        zydexLocationList(request);
        financialYearList(request);
//        selectEmployee(request, response);
        request.setAttribute("search", request.getParameter("search"));
//        mv.getModelMap().put("employeeTypeMaster", employeeTypeMaster);
        mv.setViewName("Payroll/PayrollEmployeeSavingForm");
        return mv;
    }

    public ModelAndView searchFormEmployeeSavingDetailSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeSalaryProcess employeeSalaryProcess = new EmployeeSalaryProcess();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeType employeeType = new EmployeeType();
        EmployeeSubType employeeSubType = new EmployeeSubType();

//        String zydex_location_id = request.getParameter("zydexLocationMasterId");
//        String type_of_employee = request.getParameter("employeeTypeMasterId");
//        String employee_sub_id = request.getParameter("subTypeId");
        if ("" != request.getParameter("fnyear")) {
            String Financial_year = request.getParameter("fnyear");

//        String Employee_Name = request.getParameter("employeeMasterId");
            HttpSession session = request.getSession();
            EmployeeMaster employee = (EmployeeMaster) session.getAttribute("employeeInfo");
            int id = employee.getId();
            EmployeeMaster employeeMaster1 = employeeMasterService.readById(id);
            String Employee_Name = employeeMaster1.getEmployeeName();
////       
//        if (!zydex_location_id.equals("")) {
//            employeeMaster.setAdharCard(zydex_location_id);
//        }
//
//        if (!type_of_employee.equals("")) {
//            employeeMaster.setEmployeeType(type_of_employee);
//        }
//        if (null != employee_sub_id && !employee_sub_id.equals("")) {
//            employeeMaster.setCompany(employee_sub_id);
//        }
//
            if (!Financial_year.equals("")) {
                employeeMaster.setPaymentType(Financial_year);

            }

            if (!Employee_Name.equals("")) {
                employeeMaster.setEmployeeName(Employee_Name);

            }

            boolean isExist = taxSavingSubmitService.isExist(id, Integer.parseInt(Financial_year));
            if (isExist) {
                List<?> list = taxSavingSubmitService.readTaxSavingSubmitEmployeeSaving(id, Integer.parseInt(Financial_year));
                request.setAttribute("employeelist", list);
                mv.setViewName("Payroll/payrollEmployeeSavingStatus");
            } else {

                List<?> list = employeeSalaryProcessService.readEmployeeForFormSixteen(employeeMaster);
                request.setAttribute("employeelist", list);
                mv = redirectToFormEmployeeSaving(request, response);
            }
            return mv;
        }
        request.setAttribute("failureMessage",
                "Error : Please Select Financial year.");
        financialYearList(request);
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
        boolean isExist = taxSavingSubmitService.isExist(employeeMaster.getId(), payrollFinancialYear.getId());
        if (isExist) {

            List<?> taxSavingAmount = taxSavingSubmitService.readTaxSavingSubmit(employeeMaster.getId(), payrollFinancialYear.getId());
            if (!taxSavingAmount.isEmpty()) {
                TaxSavingSubmit taxSavingSubmit = new TaxSavingSubmit();
                for (Object o13 : taxSavingAmount) {
                    taxSavingSubmit = (TaxSavingSubmit) o13;
                    Integer taxSavingsubmitId = taxSavingSubmit.getId();
                    List<?> taxDeductionDecarationSubmit = taxDeductionDecarationSubmitService.readTaxDeductionDecarationSubmit(taxSavingsubmitId);
                    if (!taxDeductionDecarationSubmit.isEmpty()) {
                        for (Object taxDeductionDecarationSubmit1 : taxDeductionDecarationSubmit) {
                            Integer taxDeductionMaster1 = (Integer) taxDeductionDecarationSubmit1;
//                            Object[] o12 = (Object[]) taxDeductionDecarationSubmit1;
//                            Integer taxDeductionMasterCompennt = (Integer) o12[1];
//                            Double taxAmount = (Double) o12[3];

                            List totalList = new ArrayList();
                            List finalData = new ArrayList();
                            List<?> taxDeduction = payrollTaxDeductionMasterService.readTaxDeductionForFormSixteen();
                            List taxDeductioncomponentIDList = new ArrayList();
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
                                    if (!taxDeductioncomponent.isEmpty()) {
                                        taxDeductionList.add(selection);
                                        for (Object taxDeductionListcompmet1 : taxDeductioncomponent) {
                                            List taxDeductioncomponentList1 = new ArrayList();
                                            List taxDeductioncomponentList12 = new ArrayList();
                                            Object[] o1 = (Object[]) taxDeductionListcompmet1;
                                            Integer taxdeductionid1 = (Integer) o1[0];
//                        taxDeductioncomponentIDList.add(taxdeductionid1);

                                            String compoment = (String) o1[1];
                                            taxDeductioncomponentList1.add(compoment);
                                            taxDeductioncomponentList1.add(taxdeductionid1);
                                            taxDeductioncomponentList12.add(taxdeductionid1);
                                            Integer agelimit = (Integer) o1[2];
                                            Integer taxSavingLimit = (Integer) o1[3];
                                            Integer taxDeductionMAsterID = (Integer) o1[4];
                                            taxDeductioncomponentList1.add(taxSavingLimit);
                                            Double taxDeductionAmount = 0.0;
                                            List<?> taxDeductionDecarationSubmit52 = taxDeductionDecarationSubmitService.readTaxDeductionDecarationSubmitAmount(taxSavingsubmitId, taxDeductionMAsterID, taxdeductionid1);
                                            if (!taxDeductionDecarationSubmit52.isEmpty()) {
                                                for (Object taxDeductionDecarationSubmit521 : taxDeductionDecarationSubmit52) {
                                                    Object[] o132 = (Object[]) taxDeductionDecarationSubmit521;
                                                    taxDeductionAmount = (Double) o132[0];
                                                    String attachment = (String) o132[1];
                                                    Integer Actionstatus = (Integer) o132[2];

                                                    taxDeductioncomponentList1.add(taxDeductionAmount);
                                                    taxDeductioncomponentList1.add(attachment);
                                                    taxDeductioncomponentList1.add(Actionstatus);
                                                }

                                            }

                                            taxDeductioncomponentList.add(taxDeductioncomponentList1);
                                            taxDeductioncomponentIDList.add(taxdeductionid1.toString());

                                        }

                                        finalDatatemp.add(taxDeductioncomponentList);
//                    finalDatatemp.add(taxDeductioncomponentIDList);
                                    }

                                    finalData.add(finalDatatemp);
                                }

                            }
                            String listString = String.join(", ", taxDeductioncomponentIDList);

                            mv.getModelMap().put("employeeSalaryProcess", employeeSalaryProcess);
                            request.setAttribute("employeeMaster", employeeMaster);
                            request.setAttribute("taxDeductioncomponentIDList", listString);
                            request.setAttribute("finalData", finalData);
                            request.setAttribute("payrollFormSixteenMaster", payrollFormSixteenMaster);
                            mv.setViewName("Payroll/EmployeeSavingEdit");
                            return mv;

                        }
                    }

                }

            }
        } else {

            List totalList = new ArrayList();
            List finalData = new ArrayList();
            List<?> taxDeduction = payrollTaxDeductionMasterService.readTaxDeductionForFormSixteen();
            List taxDeductioncomponentIDList = new ArrayList();
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
                    if (!taxDeductioncomponent.isEmpty()) {
                        taxDeductionList.add(selection);
                        for (Object taxDeductionListcompmet1 : taxDeductioncomponent) {
                            List taxDeductioncomponentList1 = new ArrayList();
                            List taxDeductioncomponentList12 = new ArrayList();
                            Object[] o1 = (Object[]) taxDeductionListcompmet1;
                            Integer taxdeductionid1 = (Integer) o1[0];
//                        taxDeductioncomponentIDList.add(taxdeductionid1);

                            String compoment = (String) o1[1];
                            taxDeductioncomponentList1.add(compoment);
                            taxDeductioncomponentList1.add(taxdeductionid1);
                            taxDeductioncomponentList12.add(taxdeductionid1);
                            Integer agelimit = (Integer) o1[2];
                            Integer taxSavingLimit = (Integer) o1[3];
                            taxDeductioncomponentList1.add(taxSavingLimit);
                            taxDeductioncomponentList.add(taxDeductioncomponentList1);
                            taxDeductioncomponentIDList.add(taxdeductionid1.toString());
                        }

                        finalDatatemp.add(taxDeductioncomponentList);
//                    finalDatatemp.add(taxDeductioncomponentIDList);
                    }

                    finalData.add(finalDatatemp);
                }

            }
            String listString = String.join(", ", taxDeductioncomponentIDList);

            mv.getModelMap().put("employeeSalaryProcess", employeeSalaryProcess);
            request.setAttribute("employeeMaster", employeeMaster);
            request.setAttribute("taxDeductioncomponentIDList", listString);
            request.setAttribute("finalData", finalData);
            request.setAttribute("payrollFormSixteenMaster", payrollFormSixteenMaster);
            mv.setViewName("Payroll/PayrollEmployeeSavingView");
            return mv;
        }
        return mv;
    }

    public ModelAndView clickSubmitSavingAmount(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        String imgFile = "";
        ModelAndView mv = new ModelAndView();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date cDate = new Date();
        EmployeeMaster employeeMaster1 = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        TaxSavingSubmit taxSavingSubmit = new TaxSavingSubmit();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        PayrollFinancialYear payrollFinancialYear = new PayrollFinancialYear();
        String employeeId = request.getParameter("emplId");
        String yearId = request.getParameter("yearID");
//        boolean isExist = taxSavingSubmitService.isExist(Integer.parseInt(employeeId), Integer.parseInt(yearId));
//        if (isExist) {
//
//            List<?> taxSavingAmount = taxSavingSubmitService.readTaxSavingSubmit(Integer.parseInt(employeeId), Integer.parseInt(yearId));
//            if (!taxSavingAmount.isEmpty()) {
//                TaxSavingSubmit taxSavingSubmit1 = new TaxSavingSubmit();
//                for (Object o13 : taxSavingAmount) {
//                    taxSavingSubmit1 = (TaxSavingSubmit) o13;
//                    Integer taxSavingsubmitId = taxSavingSubmit1.getId();
//                    taxSavingSubmit1 = taxSavingSubmitService.readById(taxSavingSubmit1.getId());
//                    taxSavingSubmit1.setUpdatedBy(employeeMaster1.getId());
//                    taxSavingSubmit1.setUpdatedDate(sdf.format(cDate));
//                    taxSavingSubmitService.update(taxSavingSubmit1);
//
//                }
//
//                TaxDeductionDecarationSubmit taxDeductionDecarationSubmit1 = new TaxDeductionDecarationSubmit();
//                List<?> list1 = taxDeductionDecarationSubmitService.readByTaxDeductionDecarationDelete(taxSavingSubmit1.getId());
//                for (Object pdf : list1) {
//                    taxDeductionDecarationSubmit1 = (TaxDeductionDecarationSubmit) pdf;
//                    taxDeductionDecarationSubmitService.delete(taxDeductionDecarationSubmit1.getId());
//                }
//                String[] savingList = request.getParameterValues("list");
//                String[] taxCompenet = request.getParameterValues("finalData1");
//                String as = savingList[0].toString();
//
//                TaxDeductionDecarationSubmit taxDeductionDecarationSubmit = new TaxDeductionDecarationSubmit();
//                String[] var = savingList[0].split("-,");
//                for (int i = 0; i < var.length; i = i + 3) {
//                    String taxcomponentId = var[i];
//                    String taxAMount = var[i + 1];
//                    String attachment = var[i + 2];
//                    PayrollTaxDeductionComponent payrollTaxDeductionComponent = new PayrollTaxDeductionComponent();
//                    payrollTaxDeductionComponent.setComponentId(Integer.parseInt(taxcomponentId));//tax compenont id
//                    taxDeductionDecarationSubmit.setAmountTaxDecaration(Double.parseDouble(taxAMount));// tax amount
//                    int taxMasterID = payrollTaxDeductionComponentService.getTaxMasterID(Integer.parseInt(taxcomponentId));// fetch tax master id from compenont id
//                    PayrollTaxDeductionMaster payrollTaxDeductionMaster = new PayrollTaxDeductionMaster();
//                    payrollTaxDeductionMaster.setId(taxMasterID);
//                    taxDeductionDecarationSubmit.setPayrollTaxDeductionMaster(payrollTaxDeductionMaster);//set taxdeduction master
//                    taxDeductionDecarationSubmit.setTaxSavingSubmit(taxSavingSubmit1);
//                    taxDeductionDecarationSubmit.setUpdatedBy(employeeMaster1.getId());
//                    taxDeductionDecarationSubmit.setUpdatedDate(sdf.format(cDate));
//                    taxDeductionDecarationSubmit.setPayrollTaxDeductionComponent(payrollTaxDeductionComponent);
//
//                    if (!attachment.endsWith("-") && !attachment.equals("")) {
//                        taxDeductionDecarationSubmit.setAttachment(attachment);
//                        taxDeductionDecarationSubmit.setStatus(1);
//
////              
//                    } else {
//                        taxDeductionDecarationSubmit.setAttachment("");
//                        taxDeductionDecarationSubmit.setStatus(0);
//                    }
//                    taxDeductionDecarationSubmitService.create(taxDeductionDecarationSubmit);
//
//                }
//
//            }
//        } else {
        employeeMaster.setId(Integer.parseInt(employeeId));
        payrollFinancialYear.setId(Integer.parseInt(yearId));
        taxSavingSubmit.setEmployeeMaster(employeeMaster);
        taxSavingSubmit.setPayrollFinancialYear(payrollFinancialYear);
        taxSavingSubmit.setCreatedBy(employeeMaster1.getId());
        taxSavingSubmit.setCreatedDate(sdf.format(cDate));
        taxSavingSubmit.setStatus(1);// 1 when user submited form
        taxSavingSubmitService.create(taxSavingSubmit);

        String[] savingList = request.getParameterValues("list");
        String[] taxCompenet = request.getParameterValues("finalData1");
        String as = savingList[0].toString();

        TaxDeductionDecarationSubmit taxDeductionDecarationSubmit = new TaxDeductionDecarationSubmit();
        String[] var = savingList[0].split("-,");
        for (int i = 0; i < var.length; i = i + 3) {
            String taxcomponentId = var[i];
            String taxAMount = var[i + 1];
            String attachment = var[i + 2];
            PayrollTaxDeductionComponent payrollTaxDeductionComponent = new PayrollTaxDeductionComponent();
            payrollTaxDeductionComponent.setComponentId(Integer.parseInt(taxcomponentId));//tax compenont id
            taxDeductionDecarationSubmit.setAmountTaxDecaration(Double.parseDouble(taxAMount));// tax amount
            int taxMasterID = payrollTaxDeductionComponentService.getTaxMasterID(Integer.parseInt(taxcomponentId));// fetch tax master id from compenont id
            PayrollTaxDeductionMaster payrollTaxDeductionMaster = new PayrollTaxDeductionMaster();
            payrollTaxDeductionMaster.setId(taxMasterID);
            taxDeductionDecarationSubmit.setPayrollTaxDeductionMaster(payrollTaxDeductionMaster);//set taxdeduction master
            taxDeductionDecarationSubmit.setTaxSavingSubmit(taxSavingSubmit);
            taxDeductionDecarationSubmit.setCreatedBy(employeeMaster1.getId());
            taxDeductionDecarationSubmit.setCreatedDate(sdf.format(cDate));
            taxDeductionDecarationSubmit.setPayrollTaxDeductionComponent(payrollTaxDeductionComponent);

            if (!attachment.endsWith("-") && !attachment.equals("")) {
                taxDeductionDecarationSubmit.setAttachment(attachment);
                taxDeductionDecarationSubmit.setStatus(1);

//              
            } else {
                taxDeductionDecarationSubmit.setAttachment("");
                taxDeductionDecarationSubmit.setStatus(0);
            }
            taxDeductionDecarationSubmitService.create(taxDeductionDecarationSubmit);

        }

        mv = redirectToFormEmployeeSaving(request, response);
        return mv;
    }

    public String displayPictureTaxDeduction(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String imgFile = "";
        String userName = request.getParameter("userName");
        String finicailyear = request.getParameter("finicailyear");
        String compenomtid = request.getParameter("compenomtid");
//       

        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile = multipartRequest.getFile("photographUpdate");
//        if (candidateJobApplyService.isExist(multipartFile.getOriginalFilename())) {
        String fileLocationURL = getServletContext().getRealPath("/")
                + File.separator + "StorageYard"
                + File.separator + "taxationDeduction" + File.separator + userName + File.separator + finicailyear + File.separator + compenomtid + File.separator;
        String fileLocationURL1 = "StorageYard"
                + File.separator + "taxationDeduction" + File.separator + userName + File.separator + finicailyear + File.separator + compenomtid + File.separator;
        File Folder1 = new File(fileLocationURL);
        if (!Folder1.exists()) {
            Folder1.mkdirs();
        }
        if (multipartFile != null && multipartFile.getSize() > 0) {
            File attchmentfile = new File(fileLocationURL);
            if (attchmentfile.exists() && attchmentfile.listFiles().length > 0) {
                File[] corporateVideoArray = attchmentfile.listFiles();
                corporateVideoArray[0].delete();
            }
            try {
                File file2 = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", "_"));
                File file = new File(fileLocationURL1 + multipartFile.getOriginalFilename().replaceAll(" ", "_"));
                multipartFile.transferTo(file2);
//                    candidateApplyJob.setPhotograph(multipartFile.getOriginalFilename().replaceAll(" ", "_"));
            } catch (Exception e) {

            }
        }
//        }

        return imgFile;
    }

    public void downloadEmployeeattachment(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        String fileName = request.getParameter("fileName");
        String userId = request.getParameter("userId");
        String finicailyear = request.getParameter("finicailyear");
        String componentid = request.getParameter("compoentid");

        String attachmentFileLocationURL = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "taxationDeduction"
                + File.separator + userId + File.separator + finicailyear + File.separator + componentid + File.separator + fileName;

        request.setAttribute("filePath", attachmentFileLocationURL);

        DownloadFile downloadFile = new DownloadFile();
        downloadFile.doDownload(request, response);
    }

    public ModelAndView clickSubmitSavingAmountEdit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        String imgFile = "";
        ModelAndView mv = new ModelAndView();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date cDate = new Date();
        EmployeeMaster employeeMaster1 = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        TaxSavingSubmit taxSavingSubmit = new TaxSavingSubmit();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        PayrollFinancialYear payrollFinancialYear = new PayrollFinancialYear();
        String employeeId = request.getParameter("emplId");
        String yearId = request.getParameter("yearID");
        boolean isExist = taxSavingSubmitService.isExist(Integer.parseInt(employeeId), Integer.parseInt(yearId));
        if (isExist) {

            List<?> taxSavingAmount = taxSavingSubmitService.readTaxSavingSubmit(Integer.parseInt(employeeId), Integer.parseInt(yearId));
            if (!taxSavingAmount.isEmpty()) {
                TaxSavingSubmit taxSavingSubmit1 = new TaxSavingSubmit();
                for (Object o13 : taxSavingAmount) {
                    taxSavingSubmit1 = (TaxSavingSubmit) o13;
                    Integer taxSavingsubmitId = taxSavingSubmit1.getId();
                    taxSavingSubmit1 = taxSavingSubmitService.readById(taxSavingSubmit1.getId());
                    taxSavingSubmit1.setUpdatedBy(employeeMaster1.getId());
                    taxSavingSubmit1.setUpdatedDate(sdf.format(cDate));
                    taxSavingSubmitService.update(taxSavingSubmit1);

                }

//                TaxDeductionDecarationSubmit taxDeductionDecarationSubmit1 = new TaxDeductionDecarationSubmit();
//                List<?> list1 = taxDeductionDecarationSubmitService.readByTaxDeductionDecarationDelete(taxSavingSubmit1.getId());
//                for (Object pdf : list1) {
//                    taxDeductionDecarationSubmit1 = (TaxDeductionDecarationSubmit) pdf;
//                    taxDeductionDecarationSubmitService.delete(taxDeductionDecarationSubmit1.getId());
//                }
                String[] savingList = request.getParameterValues("list");
                String[] taxCompenet = request.getParameterValues("finalData1");
                String as = savingList[0].toString();

                TaxDeductionDecarationSubmit taxDeductionDecarationSubmit = new TaxDeductionDecarationSubmit();
                String[] var = savingList[0].split("-,");
                for (int i = 0; i < var.length; i = i + 3) {
                    String taxcomponentId = var[i];
                    String taxAMount = var[i + 1];
                    String attachment = var[i + 2];

                    int taxMasterID = payrollTaxDeductionComponentService.getTaxMasterID(Integer.parseInt(taxcomponentId));// fetch tax master id from compenont id

                    List<?> fetchtaxDeduction = taxDeductionDecarationSubmitService.readByTaxDeductionDecarationFetchRead(taxSavingSubmit1.getId(), taxMasterID, Integer.parseInt(taxcomponentId));
                    if (!fetchtaxDeduction.isEmpty()) {
                        for (Object o14 : fetchtaxDeduction) {
                            taxDeductionDecarationSubmit = (TaxDeductionDecarationSubmit) o14;
                            Integer taxdeclartionDeductionId = taxSavingSubmit1.getId();

                        }
                    }
                    taxDeductionDecarationSubmit = taxDeductionDecarationSubmitService.readById(taxDeductionDecarationSubmit.getId());
                    PayrollTaxDeductionComponent payrollTaxDeductionComponent = new PayrollTaxDeductionComponent();
                    payrollTaxDeductionComponent.setComponentId(Integer.parseInt(taxcomponentId));//tax compenont id
                    taxDeductionDecarationSubmit.setAmountTaxDecaration(Double.parseDouble(taxAMount));// tax amount
                    PayrollTaxDeductionMaster payrollTaxDeductionMaster = new PayrollTaxDeductionMaster();
                    payrollTaxDeductionMaster.setId(taxMasterID);
                    taxDeductionDecarationSubmit.setPayrollTaxDeductionMaster(payrollTaxDeductionMaster);//set taxdeduction master
                    taxDeductionDecarationSubmit.setTaxSavingSubmit(taxSavingSubmit1);
                    taxDeductionDecarationSubmit.setUpdatedBy(employeeMaster1.getId());
                    taxDeductionDecarationSubmit.setUpdatedDate(sdf.format(cDate));
                    taxDeductionDecarationSubmit.setPayrollTaxDeductionComponent(payrollTaxDeductionComponent);

                    if (!attachment.endsWith("-") && !attachment.equals("")) {
                        taxDeductionDecarationSubmit.setAttachment(attachment);
                        taxDeductionDecarationSubmit.setStatus(1);

//              
                    } else {

                        if (taxDeductionDecarationSubmit.getStatus().equals(1)) {
                            taxDeductionDecarationSubmit.setStatus(1);
                        } else {
                            taxDeductionDecarationSubmit.setAttachment("");
                            taxDeductionDecarationSubmit.setStatus(0);
                        }
                    }
                    taxDeductionDecarationSubmitService.update(taxDeductionDecarationSubmit);

                }

            }
        }

        mv = redirectToFormEmployeeSaving(request, response);
        return mv;
    }

}
