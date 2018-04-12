/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.appraisalPerformance;

import com.bul.zydex.model.AppraisalFillingData;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author admin
 */
public class AppraisalFillingDataController extends AppraisalFillingDataAbstract {

    public ModelAndView createClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AppraisalFillingData appraisalFillingData = new AppraisalFillingData();

        mv.getModelMap().put("appraisalFillingData", appraisalFillingData);
        mv.setViewName("Appraisal/AppraisalFillingDataCreate");
        return mv;
    }

    public ModelAndView createSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AppraisalFillingData appraisalFillingData = new AppraisalFillingData();
        BindException errors = new BindException(appraisalFillingData, "appraisalFillingData");
        bind(request, appraisalFillingData);
        String year = request.getParameter("year");
        appraisalFillingDataValidator.validate(appraisalFillingData, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv.addAllObjects(errors.getModel());

        } else {
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String StartDate = appraisalFillingData.getStartDate();
            String EndDate = appraisalFillingData.getEndDate();
            String MidDate = appraisalFillingData.getMidYearStartDate();
            String MidEndDate = appraisalFillingData.getMidYearEndDate();
            String YearEndStartDate = appraisalFillingData.getYearEndStartDate();
            String YearEndDate = appraisalFillingData.getYearEndEndDate();
            Date strDate = sdf.parse(StartDate);
            Date eDate = sdf.parse(EndDate);
//            Date midDate = sdf.parse(MidDate);
//            Date midEndDate = sdf.parse(MidEndDate);
            Date yearEndStartDate = sdf.parse(YearEndStartDate);
            Date yearEndDate = sdf.parse(YearEndDate);
            //////////////////////Manager Time Line//////////////////////////////////////////
//            String ManagerStartDate = appraisalFillingData.getManagerStartDate();
//            String ManagerEndDate = appraisalFillingData.getManagerEndDate();
//            String ManagerMidDate = appraisalFillingData.getManagerMidYearStartDate();
//            String ManagerMidEndDate = appraisalFillingData.getManagerMidYearEndDate();
//            String ManagerYearEndStartDate = appraisalFillingData.getManagerYearEndStartDate();
//            String ManagerYearEndDate = appraisalFillingData.getManagerMidYearEndDate();

//            Date managerstrDate = sdf.parse(ManagerStartDate);
//            Date managerendDate = sdf.parse(EndDate);
//            Date managermidDate = sdf.parse(MidDate);
//            Date managermidEndDate = sdf.parse(MidEndDate);
//            Date manageryearEndStartDate = sdf.parse(YearEndStartDate);
//            Date manageryearEndDate = sdf.parse(YearEndDate);
            boolean flag = true;
//            boolean flag1 = false;
            boolean flag2 = false;
//            if ((strDate.after(eDate)) && strDate != midDate && strDate != midEndDate && strDate != yearEndStartDate && strDate != yearEndDate && (managerstrDate.after(managerendDate)) && managerstrDate != managermidDate && managerstrDate != managermidEndDate && managerstrDate != manageryearEndStartDate && managerstrDate != manageryearEndDate) {
//                request.setAttribute("failureMessage",
//                        "Error : Enter The Start Date After the End Date.");
//                flag = false;
//            }
//            if ((midDate.after(midEndDate)) && midDate != yearEndStartDate && midDate != yearEndDate && (managermidDate.after(managermidEndDate)) && managermidDate != manageryearEndStartDate && managermidDate != manageryearEndDate) {
//                request.setAttribute("failureMessage",
//                        "Error : Enter The MidStart Date After the MidEnd Date.");
//                flag = false;
//            }
//            if ((yearEndStartDate.after(yearEndDate)) && strDate != yearEndStartDate && strDate != yearEndDate && (manageryearEndStartDate.after(manageryearEndDate)) && managerstrDate != manageryearEndStartDate && managerstrDate != manageryearEndDate) {
//                request.setAttribute("failureMessage",
//                        "Error : Enter The End Start Date After the End Date.");
//                flag = false;
//            }
            if (flag) {

                if (!appraisalFillingDataService.isExist(year) && !year.equals("")) {
                    appraisalFillingDataService.create(appraisalFillingData);
                    request.setAttribute("successMessage",
                            "Information : The Information is saved Successfully.");
                } else {
                    mv.addAllObjects(errors.getModel());
                    request.setAttribute("failureMessage",
                            "Error : Year isExist.");
                }
            }

        }
//        mv.getModelMap().put("appraisalFillingData", appraisalFillingData);
//        mv.setViewName("Appraisal/AppraisalFillingDataCreate");
        mv = searchSubmit(request, response);
        return mv;
    }

    public ModelAndView searchSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AppraisalFillingData appraisalFillingData = new AppraisalFillingData();
//        List<?> employeeMasterList = employeeMasterService.read();
        List<?> appraisalFillingDataList = appraisalFillingDataService.read();

        mv.getModelMap().put("list", appraisalFillingDataList);
        mv.getModelMap().put("appraisalFillingData", appraisalFillingData);
        mv.setViewName("Appraisal/AppraisalFillingDataResult");

        return mv;
    }

    public ModelAndView editClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AppraisalFillingData appraisalFillingData = new AppraisalFillingData();
        String id = request.getParameter("id");
        appraisalFillingData = appraisalFillingDataService.readById(Integer.parseInt(id));
        appraisalFillingData.setId(Integer.parseInt(id));
        mv.getModelMap().put("appraisalFillingData", appraisalFillingData);
        mv.setViewName("Appraisal/AppraisalFillingDataEdit");
        return mv;
    }

    public ModelAndView editSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AppraisalFillingData appraisalFillingData = new AppraisalFillingData();
        BindException errors = new BindException(appraisalFillingData, "appraisalFillingData");
        appraisalFillingData.setId(Integer.parseInt(request.getParameter("id")));
        bind(request, appraisalFillingData);
        appraisalFillingDataValidator.validate(appraisalFillingData, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv = editClick(request, response);
        } else {

            String year = request.getParameter("year");
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String StartDate = appraisalFillingData.getStartDate();
            String EndDate = appraisalFillingData.getEndDate();
//            String MidDate = appraisalFillingData.getMidYearStartDate();
//            String MidEndDate = appraisalFillingData.getMidYearEndDate();
            String YearEndStartDate = appraisalFillingData.getYearEndStartDate();
            String YearEndDate = appraisalFillingData.getYearEndEndDate();
            Date strDate = sdf.parse(StartDate);
            Date eDate = sdf.parse(EndDate);
//            Date midDate = sdf.parse(MidDate);
//            Date midEndDate = sdf.parse(MidEndDate);
            Date yearEndStartDate = sdf.parse(YearEndStartDate);
            Date yearEndDate = sdf.parse(YearEndDate);
            //////////////////////Manager Time Line//////////////////////////////////////////
//            String ManagerStartDate = appraisalFillingData.getManagerStartDate();
//            String ManagerEndDate = appraisalFillingData.getManagerEndDate();
//            String ManagerMidDate = appraisalFillingData.getManagerMidYearStartDate();
//            String ManagerMidEndDate = appraisalFillingData.getManagerMidYearEndDate();
//            String ManagerYearEndStartDate = appraisalFillingData.getManagerYearEndStartDate();
//            String ManagerYearEndDate = appraisalFillingData.getManagerMidYearEndDate();

//            Date managerstrDate = sdf.parse(ManagerStartDate);
//            Date managerendDate = sdf.parse(EndDate);
////            Date managermidDate = sdf.parse(MidDate);
////            Date managermidEndDate = sdf.parse(MidEndDate);
//            Date manageryearEndStartDate = sdf.parse(YearEndStartDate);
//            Date manageryearEndDate = sdf.parse(YearEndDate);
            boolean flag = true;
//            boolean flag1 = false;
            boolean flag2 = false;
//            if ((strDate.after(eDate)) && strDate != midDate && strDate != midEndDate && strDate != yearEndStartDate && strDate != yearEndDate && (managerstrDate.after(managerendDate)) && managerstrDate != managermidDate && managerstrDate != managermidEndDate && managerstrDate != manageryearEndStartDate && managerstrDate != manageryearEndDate) {
//                request.setAttribute("failureMessage",
//                        "Error : Enter The Start Date After the End Date.");
//                flag = false;
//            }
//            if ((midDate.after(midEndDate)) && midDate != yearEndStartDate && midDate != yearEndDate && (managermidDate.after(managermidEndDate)) && managermidDate != manageryearEndStartDate && managermidDate != manageryearEndDate) {
//                request.setAttribute("failureMessage",
//                        "Error : Enter The MidStart Date After the MidEnd Date.");
//                flag = false;
//            }
//            if ((yearEndStartDate.after(yearEndDate)) && strDate != yearEndStartDate && strDate != yearEndDate && (manageryearEndStartDate.after(manageryearEndDate)) && managerstrDate != manageryearEndStartDate && managerstrDate != manageryearEndDate) {
//                request.setAttribute("failureMessage",
//                        "Error : Enter The End Start Date After the End Date.");
//                flag = false;
//            }

            if (flag) {

                if (appraisalFillingDataService.isExist(year) && !year.equals("")) {
//                    appraisalFillingDataService.create(appraisalFillingData);
                    appraisalFillingDataService.update(appraisalFillingData);
                    request.setAttribute("successMessage",
                            "Information : The Information is Updated Successfully.");
                    mv = searchSubmit(request, response);
                    request.setAttribute("successMessage",
                            "Information : The Information is saved Successfully.");
                } else {
                    mv.addAllObjects(errors.getModel());
                    request.setAttribute("failureMessage",
                            "Error : Year isExist.");

                }
            }

        }
        mv.getModelMap().put("appraisalFillingData", appraisalFillingData);
        mv.setViewName("Appraisal/AppraisalFillingDataResult");
        return mv;
    }

    public ModelAndView deleteSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String appraisalId[] = request.getParameterValues("checkId");
        for (String z : appraisalId) {
            try {
                appraisalFillingDataService.delete(Integer.parseInt(z));
                request.setAttribute("successMessage",
                        "Info : One or more records are deleted successfully.");
            } catch (Exception e) {

            }
        }
        mv = searchSubmit(request, response);

        return mv;
    }

    public ModelAndView readCycleNameAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String year = request.getParameter("typeId");
        String empSubTypeId = request.getParameter("empSubTypeId");
        List<?> cyclenameList = appraisalFillingDataService.readByYear(year);
        request.setAttribute("cyclenameList", cyclenameList);
        mv.setViewName("Appraisal/CyclenameAjax");
        return mv;
    }

}
