/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.PayrollFinancialYear;
import com.bul.zydex.model.PayrollTaxDeductionComponent;
import com.bul.zydex.model.PayrollTaxDeductionMaster;
import com.bul.zydex.model.TaxDeductionDecarationSubmit;
import com.bul.zydex.model.TaxDeductionDeclarationSavingStatus;
import com.bul.zydex.model.TaxSavingSubmit;
import com.bul.zydex.util.DownloadFile;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author DELL3
 */
public class TaxSavingSubmitController extends TaxSavingSubmitAbstract {

    public ModelAndView viewFilledForms(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView();
        TaxSavingSubmit taxSavingSubmit = new TaxSavingSubmit();
        EmployeeMaster employeeMaster = new EmployeeMaster();

        financialYearList(request);

        mv.getModelMap().put("taxSavingSubmit", taxSavingSubmit);
        mv.setViewName("Payroll/PayrollEmployeeSavingFilledView");
        return mv;
    }

    public ModelAndView searchFormEmployeeFilledSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = new EmployeeMaster();

        if ("" != request.getParameter("fnyear")) {
            String Financial_year = request.getParameter("fnyear");

            List<?> list = taxSavingSubmitService.readTaxSavingSubmitForEmployee(employeeMaster, Financial_year);

            request.setAttribute("employeelist", list);

            mv = viewFilledForms(request, response);
            return mv;
        }
        request.setAttribute("failureMessage",
                "Error : Please Select Financial year.");
        mv = viewFilledForms(request, response);
        return mv;
    }

    public ModelAndView viewFilledEmployeeSavingClick(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView();
        TaxSavingSubmit taxSavingSubmit = new TaxSavingSubmit();
        EmployeeMaster employeeMaster = employeeMasterService.readById(Integer.parseInt(request.getParameter("eid")));

        PayrollFinancialYear payrollFinancialYear = payrollFinancialYearService.readById(Integer.parseInt(request.getParameter("fid")));
//        PayrollFinancialYear payrollFinancialYear = payrollFinancialYearService.readById(Integer.parseInt(request.getParameter("finyear")));
        PayrollTaxDeductionMaster payrollTaxDeductionMaster = new PayrollTaxDeductionMaster();
        PayrollTaxDeductionComponent payrollTaxDeductionComponent = new PayrollTaxDeductionComponent();

        List<TaxSavingSubmit> financialYearList = checkTaxSavingSubmit(payrollFinancialYear, employeeMaster);
        if (!financialYearList.isEmpty()) {
            taxSavingSubmit = (TaxSavingSubmit) financialYearList.get(0);

        }
        taxSavingSubmit.setPayrollFinancialYear(payrollFinancialYear);
        List finalData = new ArrayList();

        List<?> taxSavingSubmitList = taxSavingSubmitService.readDataForSaving(Integer.parseInt(request.getParameter("eid")), Integer.parseInt(request.getParameter("fid")));

        Integer status = 0;

        if (!taxSavingSubmitList.isEmpty()) {
            List tssList = new ArrayList();
            List finalDatatemp12 = new ArrayList();
            for (Object obj : taxSavingSubmitList) {
                List finalDatatemp = new ArrayList();
                Object o = obj;
                Integer tssId = (Integer) o;
                status = tssId;

                List<?> taxDeduction = taxDeductionDecarationSubmitService.readSectionBySubmitSectionId(tssId);
                List deductionList = new ArrayList();
                if (!taxDeduction.isEmpty()) {
                    tssList.add(tssId);
                    for (Object obj2 : taxDeduction) {
                        List finalDatatemp1 = new ArrayList();
                        Object[] o1 = (Object[]) obj2;
                        Integer tdmId = (Integer) o1[0];
                        String tdmSection = (String) o1[1];
                        finalDatatemp1.add(tdmSection);

                        List<?> taxComponent = taxDeductionDecarationSubmitService.readComponentByTaxSavingSubmitId(tssId, tdmId);
                        List componentList = new ArrayList();
                        if (!taxComponent.isEmpty()) {
                            tssList.add(tdmSection);
                            for (Object obj3 : taxComponent) {
                                List finalDatatemp2 = new ArrayList();
                                Object[] o2 = (Object[]) obj3;
                                Double taxAmount = (Double) o2[0];
                                Integer tddsId = (Integer) o2[1];
                                Integer tddActionStatus = (Integer) o2[2];
                                String tsAttachment = (String) o2[3];
                                Integer tdcId = (Integer) o2[4];
                                String tdmComponent = (String) o2[5];
                                finalDatatemp2.add(tdmComponent);
                                finalDatatemp2.add(taxAmount);
                                finalDatatemp2.add(tsAttachment);
                                finalDatatemp2.add(tddActionStatus);
                                finalDatatemp2.add(tddsId);
                                finalDatatemp2.add(tdcId);
                                finalDatatemp1.add(finalDatatemp2);

                            }
                            finalDatatemp.add(finalDatatemp1);
                        }

                    }

                }
                finalData.addAll(finalDatatemp);
            }

        }

        TaxSavingSubmit taxSavingSubmit1 = taxSavingSubmitService.readById(status);

        request.setAttribute("employeeMaster", employeeMaster);
        request.setAttribute("taxSavingSubmit1", taxSavingSubmit1);
        request.setAttribute("payrollFinancialYear", payrollFinancialYear);
        mv.getModelMap().put("taxSavingSubmit", taxSavingSubmit);
        mv.getModelMap().put("payrollTaxDeductionMaster", payrollTaxDeductionMaster);
        mv.getModelMap().put("payrollTaxDeductionComponent", payrollTaxDeductionComponent);
        request.setAttribute("finalData", finalData);
        mv.setViewName("Payroll/PayrollEmployeeSavingAction");
        return mv;

    }

    private List<TaxSavingSubmit> checkTaxSavingSubmit(PayrollFinancialYear payrollFinancialYear, EmployeeMaster employeeMaster) {
        TaxSavingSubmit taxSavingSubmit = new TaxSavingSubmit();
        taxSavingSubmit.setPayrollFinancialYear(payrollFinancialYear);
        taxSavingSubmit.setEmployeeMaster(employeeMaster);

        List list = taxSavingSubmitService.taxSubmitSearchIdCheck(taxSavingSubmit);

        return list;
    }

    public void readFile(HttpServletRequest request,
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

    public ModelAndView changeField(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView();
        TaxSavingSubmit taxSavingSubmit = new TaxSavingSubmit();
        TaxDeductionDecarationSubmit taxDeductionDecarationSubmit = taxDeductionDecarationSubmitService.readById(Integer.parseInt(request.getParameter("tddsId")));
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();

        taxDeductionDecarationSubmit.setAmountTaxDecaration(Double.parseDouble(request.getParameter("amount")));
        taxDeductionDecarationSubmit.setActionStatus(Integer.parseInt(request.getParameter("status")));
        taxDeductionDecarationSubmit.setUpdatedBy(employeeMaster.getId());
        taxDeductionDecarationSubmit.setUpdatedDate(sdf.format(date));
        taxDeductionDecarationSubmitService.update(taxDeductionDecarationSubmit);

        List<TaxDeductionDeclarationSavingStatus> list = (List<TaxDeductionDeclarationSavingStatus>) taxDeductionDeclarationSavingStatusService.readByTDDSId(Integer.parseInt(request.getParameter("tddsId")));

        if (list.isEmpty()) {
            TaxDeductionDeclarationSavingStatus taxDeductionDeclarationSavingStatus = new TaxDeductionDeclarationSavingStatus();
            taxDeductionDeclarationSavingStatus.setStatus(Integer.parseInt(request.getParameter("status")));
            taxDeductionDeclarationSavingStatus.setStatusUpdatedDate(sdf.format(date));
            taxDeductionDeclarationSavingStatus.setTaxDeductionDecarationSubmit(taxDeductionDecarationSubmit);
            taxDeductionDeclarationSavingStatus.setStatusUpdatedBy(employeeMaster.getId());
            taxDeductionDeclarationSavingStatusService.create(taxDeductionDeclarationSavingStatus);
        } else {
            TaxDeductionDeclarationSavingStatus taxDeductionDeclarationSavingStatus = taxDeductionDeclarationSavingStatusService.readById(list.get(0).getId());
            taxDeductionDeclarationSavingStatus.setStatus(Integer.parseInt(request.getParameter("status")));
            taxDeductionDeclarationSavingStatus.setStatusUpdatedDate(sdf.format(date));
            taxDeductionDeclarationSavingStatus.setStatusUpdatedBy(employeeMaster.getId());
            taxDeductionDeclarationSavingStatusService.update(taxDeductionDeclarationSavingStatus);
        }

        mv.getModelMap().put("taxDeductionDecarationSubmit", taxDeductionDecarationSubmit);

        mv = viewFilledEmployeeSavingClick(request, response);

        return mv;

    }

    public ModelAndView partiallyChange(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView();
        TaxSavingSubmit taxSavingSubmit = taxSavingSubmitService.readById(Integer.parseInt(request.getParameter("tid")));

        List<TaxDeductionDecarationSubmit> list = (List<TaxDeductionDecarationSubmit>) taxDeductionDecarationSubmitService.readApproveByTaxSavingId(taxSavingSubmit.getId());

        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();

        Integer status = Integer.parseInt(request.getParameter("status"));

        if (4 == status) {
            taxSavingSubmit.setStatus(4);
        } else if (5 == status) {
            taxSavingSubmit.setStatus(5);
        } else if (list.isEmpty()) {
            taxSavingSubmit.setStatus(status);
        } else {
            taxSavingSubmit.setStatus(3);
        }

        taxSavingSubmit.setUpdatedBy(employeeMaster.getId());
        taxSavingSubmit.setUpdatedDate(sdf.format(date));
        taxSavingSubmitService.update(taxSavingSubmit);

        mv = viewFilledEmployeeSavingClick(request, response);

        return mv;
    }
}
