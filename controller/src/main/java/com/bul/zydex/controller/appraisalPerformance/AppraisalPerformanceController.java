/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.appraisalPerformance;

import com.bul.zydex.model.AppraisalFillingData;
import com.bul.zydex.model.AppraisalPerformanceActivities;
import com.bul.zydex.model.AppraisalPerformanceBehaviors;
import com.bul.zydex.model.AppraisalPerformanceCompetencyEvaluation;
import com.bul.zydex.model.AppraisalPerformanceIndividualDevelopmentPlan;
import com.bul.zydex.model.AppraisalPerformanceKra;
import com.bul.zydex.model.AppraisalPerformanceMaster;
import com.bul.zydex.model.AppraisalKraActivity;
import com.bul.zydex.model.CompetencyEvaluationMaster;
import com.bul.zydex.model.CompetencyEvaluationTextmaster;
import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.model.EmailAddMaster;
import com.bul.zydex.model.EmailTemplate;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.KraCategory;
import com.bul.zydex.model.PmpFormStatusMaster;
import com.bul.zydex.model.UpdateAppraisalPerformanceActivities;
import com.bul.zydex.model.UpdateAppraisalPerformanceKra;
import com.bul.zydex.model.UserMaster;
import com.bul.zydex.model.UserRightMaster;
import com.bul.zydex.util.DownloadFile;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.exolab.castor.types.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author admin
 */
public class AppraisalPerformanceController extends AppraisalPerformanceAbstract {

    public ModelAndView createClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        AppraisalPerformanceMaster appraisalPerformanceMaster = new AppraisalPerformanceMaster();
        PmpFormStatusMaster pmpFormStatusMaster = new PmpFormStatusMaster();
        CompetencyEvaluationMaster competencyEvaluationMaster = new CompetencyEvaluationMaster();
        UserMaster user = (UserMaster) request.getSession().getAttribute("user");
        UserRightMaster user1 = (UserRightMaster) request.getSession().getAttribute("userRight");
        String year = request.getParameter("year");
        request.setAttribute("year", year);
        EmployeeMaster employee = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        String employeeId = "" + employee.getId();
        String employeePMPYear = "";
//        List<?> listIsExits = appraisalPerformanceService.readByAppraisalPerformanceId(employeeId, Integer.parseInt(year));
        List<?> listIsExits = appraisalPerformanceService.readByAppraisalPerformanceIdNew(employeeId, year);
        if (!listIsExits.isEmpty()) {
            request.setAttribute("failureMessage", "Information : Your PMP Already Exits");
            mv.getModelMap().put("appraisalPerformanceMaster", appraisalPerformanceMaster);
            mv = searchOwnappraisalPerformanceSubmit(request, response);
            return mv;
        }
        int reportingId = 0;
        user.getId();
        employeeMaster.setUserMaster(user);
        kraCategoryList(request);
        managerDateStartToEnd(request, response);
        List<?> empDetailList = employeeMasterService.readEmployeeDetailUserIdWise(employeeMaster);
        if (!empDetailList.isEmpty()) {
            request.setAttribute("employeeMaster", empDetailList.get(0));
            Object[] arrayOfObject = (Object[]) empDetailList.get(0);
            String reportmanager = (String) arrayOfObject[6];
            if (!reportmanager.equals("")) {
                reportingId = Integer.parseInt(reportmanager);
            }

            employeeMaster1.setId(reportingId);
        }
        List<?> reportmanager1 = employeeMasterService.readByReportManager(employeeMaster1);
        if (!reportmanager1.isEmpty()) {
            employeeMaster1 = (EmployeeMaster) reportmanager1.get(0);
            request.setAttribute("reportingManager", employeeMaster1.getEmployeeName());
        }

        List<?> empId = employeeMasterService.readByUserName(employeeMaster);
        if (!empId.isEmpty()) {
            employeeMaster = (EmployeeMaster) empId.get(0);
        }
        appraisalPerformanceMaster.setEmployeeMaster(employeeMaster);
        AppraisalFillingData appraisalFillingData = new AppraisalFillingData();
        AppraisalFillingData appraisalFillingNewYear = new AppraisalFillingData();

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String today = sdf.format(cal.getTime());

        Date now = sdf.parse(today);
        Calendar gc = new GregorianCalendar();

        //int year = gc.get(Calendar.YEAR);
//        List<?> appraisalFilling = appraisalFillingDataService.readByCurrentYear(cyear);
//        List<AppraisalFillingData> appraisalFilling = (List<AppraisalFillingData>) appraisalFillingDataService.readByCurrentYear(year);
        List<AppraisalFillingData> appraisalFilling = (List<AppraisalFillingData>) appraisalFillingDataService.readByIdNew(Integer.parseInt(year));
//        EmployeeMaster employee = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
//        String employeeId = "" + employee.getId();
        boolean flagYear = true;
        for (AppraisalFillingData appraisalFilling1 : appraisalFilling) {

            List<?> list = appraisalPerformanceService.readByAppraisalPerformanceIdNew(employeeId, year);
            if (list.isEmpty()) {
                String lastDateStr = "31/06/" + year;
                Date lastDate = sdf.parse(lastDateStr);
                if (now.before(lastDate) && flagYear) {
//                    appraisalFilling1.getManagerYearEndEndDate();
                    BeanUtils.copyProperties(appraisalFilling1, appraisalFillingData);
                    flagYear = false;
                } else if (flagYear) {
                    BeanUtils.copyProperties(appraisalFilling1, appraisalFillingNewYear);
                }
            }
        }
        if (flagYear) {
            BeanUtils.copyProperties(appraisalFillingNewYear, appraisalFillingData);
        }

        if (!appraisalFilling.isEmpty()) {

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
            boolean flag = false;
            boolean flag1 = false;
            boolean flag2 = false;
            boolean Tflag = false;
            if (now.after(eDate)) {
                request.setAttribute("failureMessage", "Performance Cycle Timeline expired,Please Contact Admin");
                mv.getModelMap().put("appraisalPerformanceMaster", appraisalPerformanceMaster);
                mv = searchOwnappraisalPerformanceSubmit(request, response);
                return mv;
            }
            if ((now.after(strDate) && now.before(eDate)) || now.equals(strDate) || now.equals(eDate)) {
                flag = true;
                Tflag = true;
            } //            else if ((now.after(midDate) && now.before(midEndDate)) || now.equals(midDate) || now.equals(midEndDate)) {
            //                flag1 = true;
            //            }
            else if ((now.after(yearEndStartDate) && now.before(yearEndDate)) || now.equals(yearEndStartDate) || now.equals(yearEndDate)) {
                flag2 = true;
            }

            request.setAttribute("Tflag", Tflag);
            request.setAttribute("flag", flag);
            request.setAttribute("flag1", flag1);
            request.setAttribute("flag2", flag2);
        }

        String pmpstatusId = "";
        List<?> pmplist = pmpFormStatusMasterService.readByPmpformstatusStatus(employeeId);
        if (!pmplist.isEmpty()) {
            pmpFormStatusMaster = (PmpFormStatusMaster) pmplist.get(0);
            pmpstatusId = "" + pmpFormStatusMaster.getId();
            boolean pmpstartyearstatus = pmpFormStatusMaster.getStartYearStatus();
            boolean pmpmidyearstatus = pmpFormStatusMaster.getMidYearStatus();
            boolean pmpendyearstatus = pmpFormStatusMaster.getEndYearStatus();
            boolean pmpasEmployee = pmpFormStatusMaster.getEmployeeSide();
            request.setAttribute("pmpstartyearstatus", pmpstartyearstatus);
            request.setAttribute("pmpmidyearstatus", pmpmidyearstatus);
            request.setAttribute("pmpendyearstatus", pmpendyearstatus);
            request.setAttribute("pmpasEmployee", pmpasEmployee);

        }

        try {
            if (null != employee.getCompetencyEvaluationId()) {
                competencyEvaluationMaster = competencyEvaluationMasterService.readById(employee.getCompetencyEvaluationId());
                if (null != competencyEvaluationMaster) {
                    String cpmname = competencyEvaluationMaster.getTitle();
                    request.setAttribute("cpmname", cpmname);
                }
            }
        } catch (Exception e) {

        }

        List<?> list = appraisalPerformanceService.readByAppraisalPerformanceIdNew(employeeId, year);
        if (!list.isEmpty()) {
            //AppraisalPerformanceMaster appraisalPerformanceMaster =new AppraisalPerformanceMaster();
            appraisalPerformanceMaster = (AppraisalPerformanceMaster) list.get(0);
            int appraisalId = appraisalPerformanceMaster.getId();
//            appraisalId = appraisalPerformanceMaster.getId();
            AppraisalPerformanceKra appraisalPerformanceKra = new AppraisalPerformanceKra();
            appraisalPerformanceKra.setId(appraisalId);
            //=======Admin insert weightscore==== after set value==//
            if (0 != appraisalPerformanceMaster.getManagerStatus()) {

                if (null != appraisalPerformanceMaster.getWeightageScore()) {
                    String weightageScore = appraisalPerformanceMaster.getWeightageScore();
                    request.setAttribute("weightageScore", weightageScore);
                }
            }
            if (null != appraisalPerformanceMaster.getTotalScore()) {
                String totalScore = appraisalPerformanceMaster.getTotalScore();
                request.setAttribute("totalScore", totalScore);
            }
            //=======Mid Year=============//
            if (null != appraisalPerformanceMaster.getEmpMidyearSelfassOtheractivty()) {
                String empMidyearSelfassOtheractivty = appraisalPerformanceMaster.getEmpMidyearSelfassOtheractivty();
                request.setAttribute("empMidyearSelfassOtheractivty", empMidyearSelfassOtheractivty);
            }
            if (0 != appraisalPerformanceMaster.getManagerStatus()) {
                if (null != appraisalPerformanceMaster.getManagerMidyearReviewevalOtheractivity()) {
                    String managerMidyearReviewevalOtheractivity = appraisalPerformanceMaster.getManagerMidyearReviewevalOtheractivity();
                    request.setAttribute("managerMidyearReviewevalOtheractivity", managerMidyearReviewevalOtheractivity);
                }
            }
            //=======End Year=============//
            if (null != appraisalPerformanceMaster.getEmpEndyearSelfassOtheractivty()) {
                String empEndyearSelfassOtheractivty = appraisalPerformanceMaster.getEmpEndyearSelfassOtheractivty();
                request.setAttribute("empEndyearSelfassOtheractivty", empEndyearSelfassOtheractivty);
            }
            if (0 != appraisalPerformanceMaster.getManagerStatus()) {
                if (null != appraisalPerformanceMaster.getManagerEndyearReviewevalOtheractivity()) {
                    String managerEndyearReviewevalOtheractivity = appraisalPerformanceMaster.getManagerEndyearReviewevalOtheractivity();
                    request.setAttribute("managerEndyearReviewevalOtheractivity", managerEndyearReviewevalOtheractivity);
                }
            }
            /////////////////behaviors/////////////////
//        if (null != appraisalPerformanceMaster.getBehaviorsEndyearOtherremark()) {
//            String behaviorsMidyearTotalscore = appraisalPerformanceMaster.getBehaviorsMidyearTotalscore();
//            request.setAttribute("behaviorsMidyearTotalscore", behaviorsMidyearTotalscore);
//        }
//        if (null != appraisalPerformanceMaster.getBehaviorsMidyearOtherremark()) {
//            String behaviorsMidyearOtherremark = appraisalPerformanceMaster.getBehaviorsMidyearOtherremark();
//            request.setAttribute("behaviorsMidyearOtherremark", behaviorsMidyearOtherremark);
//        }
//        if (null != appraisalPerformanceMaster.getBehaviorsEndyearOtherremark()) {
//            String behaviorsEndyearOtherremark = appraisalPerformanceMaster.getBehaviorsEndyearOtherremark();
//            request.setAttribute("behaviorsEndyearOtherremark", behaviorsEndyearOtherremark);
//        }
//        if (null != appraisalPerformanceMaster.getBehaviorsEndyearOtherremark()) {
//            String behaviorsEndyearTotalscore = appraisalPerformanceMaster.getBehaviorsEndyearTotalscore();
//            request.setAttribute("behaviorsEndyearTotalscore", behaviorsEndyearTotalscore);
//        }
//        if (null != appraisalPerformanceMaster.getBehaviorsEndyearOtherremark()) {
//            String behaviorsEndyearTotalscore = appraisalPerformanceMaster.getBehaviorsEndyearTotalscore();
//            request.setAttribute("behaviorsEndyearTotalscore", behaviorsEndyearTotalscore);
//        } .
            /////////////////behaviors/////////////////
            if (0 != appraisalPerformanceMaster.getManagerStatus()) {
                if (null != appraisalPerformanceMaster.getBehaviorsMidyearTotalscore()) {
                    String behaviorsMidyearTotalscore = appraisalPerformanceMaster.getBehaviorsMidyearTotalscore();
                    request.setAttribute("behaviorsMidyearTotalscore", behaviorsMidyearTotalscore);
                }
                if (null != appraisalPerformanceMaster.getBehaviorsMidyearOtherremark()) {
                    String behaviorsMidyearOtherremark = appraisalPerformanceMaster.getBehaviorsMidyearOtherremark();
                    request.setAttribute("behaviorsMidyearOtherremark", behaviorsMidyearOtherremark);
                }
                if (null != appraisalPerformanceMaster.getBehaviorsEndyearOtherremark()) {
                    String behaviorsEndyearOtherremark = appraisalPerformanceMaster.getBehaviorsEndyearOtherremark();
                    request.setAttribute("behaviorsEndyearOtherremark", behaviorsEndyearOtherremark);
                }
                if (null != appraisalPerformanceMaster.getBehaviorsEndyearTotalscore()) {
                    String behaviorsEndyearTotalscore = appraisalPerformanceMaster.getBehaviorsEndyearTotalscore();
                    request.setAttribute("behaviorsEndyearTotalscore", behaviorsEndyearTotalscore);
                }
            }

//            if (null != appraisalPerformanceMaster.getManagerStatus()) {
            int managerStatus = appraisalPerformanceMaster.getManagerStatus();
            request.setAttribute("managerStatus", managerStatus);
//            }
//            if (null != appraisalPerformanceMaster.getStatus()) {
            int employeeStatus = appraisalPerformanceMaster.getStatus();
            request.setAttribute("employeeStatus", employeeStatus);
//            }
//            if (null != appraisalPerformanceMaster.getBehaviorsEndyearOtherremark()) {
//                String behaviorsEndyearTotalscore = appraisalPerformanceMaster.getBehaviorsEndyearTotalscore();
//                request.setAttribute("behaviorsEndyearTotalscore", behaviorsEndyearTotalscore);
//            }
            if (null != appraisalPerformanceMaster.getBehaviorsFinalscore() && !"NaN".equals(appraisalPerformanceMaster.getBehaviorsFinalscore())) {
                String behaviorsFinalscore = appraisalPerformanceMaster.getBehaviorsFinalscore();
                request.setAttribute("behaviorsFinalscore", behaviorsFinalscore);
            }
            try {
//                if (null != appraisalPerformanceMaster.getStatus() && !"NaN".equals(appraisalPerformanceMaster.getStatus())) {
                int status = appraisalPerformanceMaster.getStatus();
                request.setAttribute("status", status);
//                }

            } catch (Exception e) {

            }

            String kragoal = "";
            String updateList = "";
            //int kragoalId;
            List<?> kraList = appraisalPerformanceKraService.readByAppraisalKraGoal(appraisalPerformanceKra);
            if (!kraList.isEmpty()) {
                appraisalPerformanceKra = (AppraisalPerformanceKra) kraList.get(0);

                //appraisalPerformanceKra.setId(kragoalId);
                kragoal = appraisalPerformanceKra.getKraGoal();

            }
            request.setAttribute("kragoal", kraList);
            request.setAttribute("empMidyearSelfassessmentGoal", kraList);
            request.setAttribute("managerMidyearReviewEvaluation", kraList);
            request.setAttribute("midyearStatus", kraList);
            request.setAttribute("endyearStatus", kraList);
            request.setAttribute("empEndyearSelfassessmentGoal", kraList);
            request.setAttribute("managerEndyearReviewEvaluation", kraList);
            request.setAttribute("startDate", kraList);
            request.setAttribute("editDate", kraList);

            UpdateAppraisalPerformanceKra updateAppraisalPerformanceKra = new UpdateAppraisalPerformanceKra();
            updateAppraisalPerformanceKra.setAppraisalPerformanceKra(appraisalPerformanceKra);
            List<?> updateKraList = updateAppraisalPerformanceKraService.readByUpdateKragoal(updateAppraisalPerformanceKra);
            request.setAttribute("updateKraList", updateKraList);
        } else {
//            String employeeStatus="0";
            request.setAttribute("employeeStatus", "0");
        }

        ////////////////////////////////////KRA OTHER Activity///////////////////////////////////////////////////////////
        if (null != appraisalPerformanceMaster.getId()) {

            AppraisalPerformanceActivities appraisalPerformanceActivities = new AppraisalPerformanceActivities();
            appraisalPerformanceActivities.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
            String kragoal_activity = "";
            List<?> kraOtherList = appraisalPerformanceActivitiesService.readByAppraisalKraGoalActivities(appraisalPerformanceActivities);
            if (!kraOtherList.isEmpty()) {
                appraisalPerformanceActivities = (AppraisalPerformanceActivities) kraOtherList.get(0);

            }
        }
        ////////////////////////////////////KRA OTHER Activity//////////////////////////////////////////////////////////
        //====================CompetencyEvaluation====================================================//

        competencyList(request);
        int competencyId = 0;
        AppraisalPerformanceCompetencyEvaluation appraisalPerformanceCompetencyEvaluation = new AppraisalPerformanceCompetencyEvaluation();
        appraisalPerformanceCompetencyEvaluation.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
        CompetencyEvaluationTextmaster competencyEvaluationTextmaster = new CompetencyEvaluationTextmaster();
        List<?> competencyEvaluationList = appraisalPerformanceCompetencyEvaluationService.readAppraisalPerformanceCompetencyEvaluationDetail(appraisalPerformanceCompetencyEvaluation);
        request.setAttribute("competencyEvaluationList", competencyEvaluationList);

//        if (!competencyEvaluationList.isEmpty()) {
//            appraisalPerformanceCompetencyEvaluation = (AppraisalPerformanceCompetencyEvaluation) competencyEvaluationList.get(0);
//            competencyId = appraisalPerformanceCompetencyEvaluation.getCompetencyEvaluationMaster().getId();
//            CompetencyEvaluationMaster competencyEvaluationMaster = new CompetencyEvaluationMaster();
//            //competencyEvaluationMaster.setId(competencyId);
//
//            competencyEvaluationMaster = competencyEvaluationMasterService.readById(competencyId);
//            if (null != competencyEvaluationMaster.getTitle()) {
//                String title = competencyEvaluationMaster.getTitle();
//                request.setAttribute("title", title);
//            }
//        }
//                request.setAttribute("title", title);
        AppraisalPerformanceIndividualDevelopmentPlan appraisalPerformanceIndividualDevelopmentPlan = new AppraisalPerformanceIndividualDevelopmentPlan();
        appraisalPerformanceIndividualDevelopmentPlan.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
        String text1 = "";
        List<?> individualDevelopmentPlanList = appraisalPerformanceIndividualDevelopmentPlanService.readIndividualDevelopmentPlanDetail(appraisalPerformanceIndividualDevelopmentPlan);
        if (!individualDevelopmentPlanList.isEmpty()) {
            appraisalPerformanceIndividualDevelopmentPlan = (AppraisalPerformanceIndividualDevelopmentPlan) individualDevelopmentPlanList.get(0);
            text1 = appraisalPerformanceIndividualDevelopmentPlan.getText1();
        }
        request.setAttribute("text1", individualDevelopmentPlanList);
        request.setAttribute("text2", individualDevelopmentPlanList);
        request.setAttribute("text3", individualDevelopmentPlanList);
        request.setAttribute("remark", individualDevelopmentPlanList);
        request.setAttribute("midYearRemark", individualDevelopmentPlanList);
        request.setAttribute("endYearRemark", individualDevelopmentPlanList);
        request.setAttribute("individualDevelopmentPlanList", individualDevelopmentPlanList);

        //////////Behaviors///////////////
        AppraisalPerformanceBehaviors appraisalPerformanceBehaviors = new AppraisalPerformanceBehaviors();
        String behaviors = "";
        appraisalPerformanceBehaviors.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
        List<?> behaviorsList = appraisalPerformanceBehaviorsService.readBehaviorsDetail(appraisalPerformanceBehaviors);
        if (!behaviorsList.isEmpty()) {
            appraisalPerformanceBehaviors = (AppraisalPerformanceBehaviors) behaviorsList.get(0);
            behaviors = appraisalPerformanceBehaviors.getBehaviors();
        }
        request.setAttribute("behaviors", behaviorsList);
        request.setAttribute("behaviorsList", behaviorsList);
        mv.getModelMap().put("appraisalPerformanceMaster", appraisalPerformanceMaster);
//        if (Integer.parseInt(year) == 2016) {
//
//            mv.setViewName("Appraisal/PerformanceAppraisalForm");
//        } else {
        mv.setViewName("Appraisal/PerformanceAppraisalForm2017Onwards");
//        }
        return mv;
    }
//////////////////////21-04-2016////////////////////////////////

    public ModelAndView createSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        AppraisalPerformanceMaster appraisalPerformanceMaster = new AppraisalPerformanceMaster();
        AppraisalPerformanceKra appraisalPerformanceKra = new AppraisalPerformanceKra();
        AppraisalPerformanceKra appraisalPerformanceKra1 = new AppraisalPerformanceKra();
        UpdateAppraisalPerformanceKra updateAppraisalPerformanceKra = new UpdateAppraisalPerformanceKra();
        UpdateAppraisalPerformanceActivities updateAppraisalPerformanceActivities = new UpdateAppraisalPerformanceActivities();
        AppraisalPerformanceActivities appraisalPerformanceActivities = new AppraisalPerformanceActivities();
        AppraisalPerformanceActivities appraisalPerformanceActivities1 = new AppraisalPerformanceActivities();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employee = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        PmpFormStatusMaster pmpFormStatusMaster = new PmpFormStatusMaster();
        BindException errors = new BindException(appraisalPerformanceMaster, "appraisalPerformanceMaster");
        kraCategoryList(request);
        KraCategory kraCategory = new KraCategory();
        String appraisalId = "";
        //selectedDateflage(request,response);

        String btn = request.getParameter("submit");
        appraisalPerformanceValidator.validate(appraisalPerformanceMaster, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv.addAllObjects(errors.getModel());
        } else {
            float weightageCount = 0;
            int countId = Integer.parseInt(request.getParameter("countId"));
            try {
                for (int i = 1; i <= countId; i++) {
                    String weightage1 = request.getParameter("weightage" + i);
                    if (!"".equals(weightage1)) {

                        weightageCount += Float.parseFloat(weightage1);
                    }
                }
            } catch (Exception e) {

            }
            /////////////// emp score
            float empFinalTotalCount = 0;
            try {
                for (int i = 1; i <= countId; i++) {
                    String empScore1 = request.getParameter("empfinalScore" + i);
                    if (!"".equals(empScore1)) {

                        empFinalTotalCount += Float.parseFloat(empScore1);
                    }
                }
            } catch (Exception e) {

            }

            if (null != btn && btn.equals("submit")) {
                if (weightageCount == 75) {

                } else {

                    request.setAttribute("failureMessage", "Information : Your Weightege is not equal to 75");
                    mv.getModelMap().put("appraisalPerformanceMaster", appraisalPerformanceMaster);
                    mv = searchOwnappraisalPerformanceSubmit(request, response);
                    return mv;
                }
            }

            String employeeId = "" + employee.getId();
            String employeeName = "" + employee.getEmployeeName();
//            int year = Calendar.getInstance().get(Calendar.YEAR);
            String year = request.getParameter("yearparmStr");

//            List<?> l1 = = (List<AppraisalFillingData>) appraisalFillingDataService.getCurrentAndPreviousYear();
//            List<AppraisalFillingData> appraisalFilling = (List<AppraisalFillingData>) appraisalFillingDataService.getappraisalDate();
//            List<AppraisalFillingData> appraisalFilling = (List<AppraisalFillingData>) appraisalFillingDataService.readByCurrentYear(year);
            List<AppraisalFillingData> appraisalFilling = (List<AppraisalFillingData>) appraisalFillingDataService.readByIdNew(Integer.parseInt(year));
            AppraisalFillingData afd = (AppraisalFillingData) appraisalFilling.get(0);
            String previousYear = "";
//        int currentYear = 0;
//            if (!l1.isEmpty()) {
//                Object[] obj = (Object[]) l1.get(0);
////            previousYear = (Integer) obj[0];
//                previousYear = "" + obj[0];
////            currentYear = (Integer) obj[1];
//            }
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            // Changes

            String today1 = sdf.format(cal.getTime());
            String[] s = today1.split("/");

            Date now1 = sdf.parse(today1);
            Calendar gc = new GregorianCalendar();
            boolean flagYear = true;
            for (AppraisalFillingData appraisalFilling1 : appraisalFilling) {

                List<?> list = appraisalPerformanceService.readByAppraisalPerformanceIdNew(employeeId, year);
                if (list.isEmpty()) {
                    String lastDateStr = "31/06/" + s[2];
                    Date lastDate = sdf.parse(lastDateStr);
                    if (now1.before(lastDate) && flagYear) {
                        appraisalFilling1.getManagerYearEndEndDate();
                        previousYear = appraisalFilling1.getYear();
                        flagYear = false;
                    } else if (flagYear) {
                        previousYear = appraisalFilling1.getYear();
                    }
                } else if ("".equals(previousYear)) {

                    previousYear = "" + request.getParameter("yearparmStr");
                }
            }

            // Changes
            //StartDate To create FirstTime//
            SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date now = new Date();
            String strDate = sdf1.format(now);
            String today = sdf.format(cal.getTime());
            String startdate = "" + today;
            String weightageScore = request.getParameter("weightageScore");
            if (null == weightageScore) {
                weightageScore = "";
            }
//            List<?> list = appraisalPerformanceService.readByAppraisalPerformanceId(employeeId, year);
            List<?> list = appraisalPerformanceService.readByAppraisalPerformanceIdNew(employeeId, year);
            if (!list.isEmpty()) {
                //AppraisalPerformanceMaster appraisalPerformanceMaster =new AppraisalPerformanceMaster();
                appraisalPerformanceMaster = (AppraisalPerformanceMaster) list.get(0);
                appraisalId = "" + appraisalPerformanceMaster.getId();
                appraisalPerformanceMaster.setId(Integer.parseInt(appraisalId));
                appraisalPerformanceKra.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
            }
            if (null == appraisalPerformanceMaster.getId()) {

                int behaviosyear = Calendar.getInstance().get(Calendar.YEAR);
                appraisalPerformanceMaster.setEmployeeMaster(employee);
                appraisalPerformanceMaster.setStatus(0);
                appraisalPerformanceMaster.setManagerStatus(0);
                appraisalPerformanceMaster.setEmployeeStatus(0);
                appraisalPerformanceMaster.setBehaviorsYear("" + afd.getId());
                appraisalPerformanceKra.setStartDate(startdate);
                appraisalPerformanceMaster.setWeightageScore(weightageScore);
                appraisalPerformanceMaster.setEmployeeTotalFinalScore("" + empFinalTotalCount);
                appraisalPerformanceService.create(appraisalPerformanceMaster);
            }

            String flagId = request.getParameter("flagId");
//            String midhalf = request.getParameter("flagMidId");
            String endhalf = request.getParameter("flagEndId");
//            List<?> kraList = appraisalPerformanceKraService.readByAppraisalPerformancekraId(appraisalPerformanceKra);
//            if (!kraList.isEmpty()) {
//                appraisalPerformanceKra = (AppraisalPerformanceKra) kraList;
//                appraisalPerformanceKra.getId();
//            }

            if (null != btn && btn.equals("submit")) {
                if (appraisalPerformanceMaster.getReworkStatus() == 1) {
                    appraisalPerformanceMaster.setMidYearManagerStatus(0);
                }
                if (appraisalPerformanceMaster.getReworkStatus() == 1 && null != endhalf && endhalf.equals("true")) {
                    appraisalPerformanceMaster.setEndYearManagerStatus(0);
                }
                appraisalPerformanceMaster.setStatus(1);
                appraisalPerformanceMaster.setManagerkraStatus(0);
                appraisalPerformanceMaster.setEmployeeStatus(1);
                appraisalPerformanceMaster.setReworkStatus(0);
                appraisalPerformanceMaster.setEmployeeTotalFinalScore("" + empFinalTotalCount);
                appraisalPerformanceMaster.setWeightageScore(weightageScore);
                appraisalPerformanceMaster.setWeightageScoreManager(weightageScore);

//                if (midhalf.equals("true")) {
//                    appraisalPerformanceMaster.setMidYearEmployeeStatus(1);
//                }
                if (endhalf.equals("true")) {
                    appraisalPerformanceMaster.setEndYearEmployeeStatus(1);
                }

                appraisalPerformanceService.update(appraisalPerformanceMaster);
                if (!"".equals(flagId) && null != flagId) {
                    if (flagId.equals("true")) {
//   Email Sent to ReportingManager1 at Start Year
                        try {
                            EmailTemplate emailTemplate = new EmailTemplate();
                            EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                            DesignationMaster designationMaster = new DesignationMaster();
                            designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                            EmployeeMaster employeeMasterHr = new EmployeeMaster();
                            employeeMasterHr = employeeMasterService.readById(Integer.parseInt(employeeMasterModel.getReportingManagerLevel1()));
                            // id 113 is for Appraisal Submitted by employee(Start year)
                            emailTemplate = emailTemplateService.readById(113);
                            String To = employeeMasterHr.getOfficeEmailId();
                            String from = employeeMasterModel.getOfficeEmailId();
                            String Subject = emailTemplate.getSubject();
                            Subject = Subject.replaceAll("\\{user\\}", employeeMasterModel.getEmployeeName());
                            String msg = emailTemplate.getBodytext();
                            msg = msg.replaceAll("\\{to_user\\}", employeeMasterHr.getEmployeeName());
                            msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                            msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                            sendMail.sendMail(from, To, Subject, msg);
                            mailSendPmpStartHalfapply(request);
                        } catch (Exception e) {

                        }
                    }
                }
//                if (!"".equals(midhalf) && null != midhalf) {
//                    if (midhalf.equals("true")) {
////   Email Sent to ReportingManager1 at Mid Year
//                        try {
//                            EmailTemplate emailTemplate = new EmailTemplate();
//                            EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
//                            DesignationMaster designationMaster = new DesignationMaster();
//                            designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
//                            EmployeeMaster employeeMasterHr = new EmployeeMaster();
//                            employeeMasterHr = employeeMasterService.readById(Integer.parseInt(employeeMasterModel.getReportingManagerLevel1()));
//                            // id 114 is for Appraisal Submitted by employee(Mid year)
//                            emailTemplate = emailTemplateService.readById(114);
//                            String To = employeeMasterHr.getOfficeEmailId();
//                            String from = employeeMasterModel.getOfficeEmailId();
//                            String Subject = emailTemplate.getSubject();
//                            Subject = Subject.replaceAll("\\{user\\}", employeeMasterModel.getEmployeeName());
//                            String msg = emailTemplate.getBodytext();
//                            msg = msg.replaceAll("\\{to_user\\}", employeeMasterHr.getEmployeeName());
//                            msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
//                            msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
//                            sendMail.sendMail(from, To, Subject, msg);
//                            mailSendPmpMidHalfapply(request);
//                        } catch (Exception e) {
//
//                        }
//                    }
//                }
                if (!"".equals(endhalf) && null != endhalf) {
                    if (endhalf.equals("true")) {
//   Email Sent to ReportingManager1 at  Year End
                        try {
                            EmailTemplate emailTemplate = new EmailTemplate();
                            EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                            DesignationMaster designationMaster = new DesignationMaster();
                            designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                            EmployeeMaster employeeMasterHr = new EmployeeMaster();
                            employeeMasterHr = employeeMasterService.readById(Integer.parseInt(employeeMasterModel.getReportingManagerLevel1()));
                            // id 115 is for Appraisal Submitted by employee(year End)
                            emailTemplate = emailTemplateService.readById(115);
                            String To = employeeMasterHr.getOfficeEmailId();
                            String from = employeeMasterModel.getOfficeEmailId();
                            String Subject = emailTemplate.getSubject();
                            Subject = Subject.replaceAll("\\{user\\}", employeeMasterModel.getEmployeeName());
                            String msg = emailTemplate.getBodytext();
                            msg = msg.replaceAll("\\{to_user\\}", employeeMasterHr.getEmployeeName());
                            msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                            msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                            sendMail.sendMail(from, To, Subject, msg);
                            mailSendPmpEndHalfapply(request);
                        } catch (Exception e) {

                        }
                    }
                }
            } else {

                appraisalPerformanceMaster.setWeightageScore(weightageScore);
                appraisalPerformanceMaster.setEmployeeTotalFinalScore("" + empFinalTotalCount);
                appraisalPerformanceService.update(appraisalPerformanceMaster);
            }

//            StartDate To create FirstTime//
//            =========if appraisalPerformance is create and after get id=======//
            appraisalPerformanceKra.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
            appraisalPerformanceMaster.getId();//get Appraisal id
            //String employeeName = request.getParameter("employeeName");

            if (null != btn && btn.equals("submit")) {

                String kraremovedIdVal = request.getParameter("kraremovedIdVal");
                if (!kraremovedIdVal.isEmpty()) {
                    for (String id : kraremovedIdVal.split(",")) {
                        if (!id.equals("")) {
                            try {
                                AppraisalPerformanceKra appraisalPerformanceKra2 = new AppraisalPerformanceKra();
                                UpdateAppraisalPerformanceKra updateAppraisalPerformanceKra1 = new UpdateAppraisalPerformanceKra();
                                AppraisalKraActivity appraisalkraActivity = new AppraisalKraActivity();

                                appraisalPerformanceKra2.setId(Integer.parseInt(id));
                                appraisalPerformanceKra2 = appraisalPerformanceKraService.readById(appraisalPerformanceKra2.getId());

                                appraisalkraActivity.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
                                appraisalkraActivity.setDeletedKra(appraisalPerformanceKra2.getKraGoal());
                                appraisalkraActivity.setDeletedMetric(appraisalPerformanceKra2.getMetric());
                                appraisalkraActivity.setDeletedWeightage("" + appraisalPerformanceKra2.getWeightage());
                                appraisalkraActivity.setDeletedBy(employeeName);
                                appraisalkraActivity.setStatus("KRAGOAL");
                                appraisalkraActivity.setKraDeletedDate(today);
                                appraisalkraActivityService.create(appraisalkraActivity);

                                updateAppraisalPerformanceKra1.setAppraisalPerformanceKra(appraisalPerformanceKra2);
                                List updatedKraList = updateAppraisalPerformanceKraService.readByKraIdForDelete(updateAppraisalPerformanceKra1);
                                for (Object obj : updatedKraList) {
                                    updateAppraisalPerformanceKra1 = (UpdateAppraisalPerformanceKra) obj;
                                    updateAppraisalPerformanceKraService.delete(updateAppraisalPerformanceKra1.getId());
                                }
                                appraisalPerformanceKraService.delete1(appraisalPerformanceKra2);

                            } catch (Exception e) {
                            }
                        }
                    }
                }
            }

            //////////////comment by nishant
//            if (Integer.parseInt(year) == 2016) {
//
//                if (null != btn && btn.equals("submit")) {
//
//                    String kraremovedActivitiesIdVal = request.getParameter("kraremovedActivitiesIdVal");
//                    if (!kraremovedActivitiesIdVal.isEmpty()) {
//                        for (String id : kraremovedActivitiesIdVal.split(",")) {
//                            if (!id.equals("")) {
//                                try {
//                                    AppraisalPerformanceActivities appraisalPerformanceActivities2 = new AppraisalPerformanceActivities();
//                                    UpdateAppraisalPerformanceActivities updateAppraisalPerformanceActivities1 = new UpdateAppraisalPerformanceActivities();
//                                    AppraisalKraActivity appraisalkraActivity = new AppraisalKraActivity();
//
//                                    appraisalPerformanceActivities2.setId(Integer.parseInt(id));
//                                    appraisalPerformanceActivities2 = appraisalPerformanceActivitiesService.readById(appraisalPerformanceActivities2.getId());
//
//                                    appraisalkraActivity.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
//                                    appraisalkraActivity.setDeletedKra(appraisalPerformanceActivities2.getKraGoalActivities());
//                                    appraisalkraActivity.setDeletedMetric(appraisalPerformanceActivities2.getMetricActivities());
//                                    appraisalkraActivity.setDeletedWeightage("");
//                                    appraisalkraActivity.setDeletedBy(employeeName);
//                                    appraisalkraActivity.setStatus("ACTIVITIES");
//                                    appraisalkraActivity.setKraDeletedDate(today);
//                                    appraisalkraActivityService.create(appraisalkraActivity);
//
//                                    updateAppraisalPerformanceActivities1.setAppraisalPerformanceActivities(appraisalPerformanceActivities2);
//                                    List updatedActivitiesList = updateAppraisalPerformanceActivitiesService.readByKraIdForDeleteActivity(updateAppraisalPerformanceActivities1);
//                                    for (Object activityObj : updatedActivitiesList) {
//                                        updateAppraisalPerformanceActivities1 = (UpdateAppraisalPerformanceActivities) activityObj;
//                                        updateAppraisalPerformanceActivitiesService.delete(updateAppraisalPerformanceActivities1.getId());
//                                    }
//                                    appraisalPerformanceActivitiesService.delete1(appraisalPerformanceActivities2);
//                                } catch (Exception e) {
//                                }
//                            }
//                        }
//                    }
//                }
//            }
            //String kragoal_id = "";
            for (int i = 1; i <= countId; i++) {
                String kragoal_id = request.getParameter("kragoal_id" + i);
                appraisalPerformanceKra = new AppraisalPerformanceKra();
                if (kragoal_id != null) {
                    appraisalPerformanceKra = appraisalPerformanceKraService.readById(Integer.parseInt(kragoal_id));
                }
                String kraGoal1 = request.getParameter("kraGoal" + i);
                String metric1 = request.getParameter("metric" + i);
                String kraCategoryMap = request.getParameter("kraCategoryMap" + i);
                String weightage1 = request.getParameter("weightage" + i);
                String empfinalScore1 = request.getParameter("empfinalScore" + i);

//                String finalScore = request.getParameter("finalScore" + i);
//                if (!"".equals(finalScore) && null != finalScore) {
//                    appraisalPerformanceKra.setFinalScore(finalScore);
//                } else {
//                    appraisalPerformanceKra.setFinalScore(null);
//                }
//                String midYearDiv1 = request.getParameter("midYearDiv" + i);
                String endYearDiv1 = request.getParameter("endYearDiv" + i);

                //================Mid Year===================//
//                String employeeMidYearSelfAssesssmentGoal = request.getParameter("employeeMidYearSelfAssesssmentGoal" + i);
//                String empMidyearSelfassOtheractivty = request.getParameter("empMidyearSelfassOtheractivty");
//                String managerMidYearSelfAssesssmentGoal = request.getParameter("managerMidYearSelfAssesssmentGoal" + i);
//                String managerMidyearReviewevalOtheractivity = request.getParameter("managerMidyearReviewevalOtheractivity");
                //================End Year===================//
                String employeeEndYearSelfAssesssmentGoal = request.getParameter("employeeEndYearSelfAssesssmentGoal" + i);
                String empEndyearSelfassOtheractivty = request.getParameter("empEndyearSelfassOtheractivty");
                String managerEndYearSelfAssesssmentGoal = request.getParameter("managerEndYearSelfAssesssmentGoal" + i);
                String managerEndyearReviewevalOtheractivity = request.getParameter("managerEndyearReviewevalOtheractivity");
                String startDate1 = request.getParameter("startDate" + i);
                if (!"".equals(startDate1) && null != startDate1) {
                    appraisalPerformanceKra.setStartDate(startDate1);
                } else {
                    appraisalPerformanceKra.setStartDate(null);
                }

                appraisalPerformanceKra.setKraGoal(kraGoal1);
                appraisalPerformanceKra.setMetric(metric1);
                if (null != weightage1 && !weightage1.equals("") && !weightage1.equals("null")) {
                    appraisalPerformanceKra.setWeightage(Float.parseFloat(weightage1));
                } else {
                    appraisalPerformanceKra.setWeightage(null);
                }
                if (null != empfinalScore1 && !empfinalScore1.equals("") && !empfinalScore1.equals("null")) {
                    appraisalPerformanceKra.setEmpFinalScore(Float.parseFloat(empfinalScore1));
                } else {
                    appraisalPerformanceKra.setEmpFinalScore(null);
                }
                if (!"".equals(kraCategoryMap) && null != kraCategoryMap) {
//                        KraCategory kraCategory = new KraCategory();
                    kraCategory.setId(Integer.parseInt(kraCategoryMap));
                    appraisalPerformanceKra.setKraCategoryByKraCategoryByEmployee(kraCategory);
                } else {
                    appraisalPerformanceKra.setKraCategoryByKraCategoryByEmployee(null);
                }

                //=======Mid year========================================//
//                if (!"".equals(midYearDiv1) && null != midYearDiv1) {
//                    appraisalPerformanceKra.setMidyearStatus(midYearDiv1);
//                } else {
//                    appraisalPerformanceKra.setMidyearStatus(null);
//                }
                //=======End year========================================//
                if (!"".equals(endYearDiv1) && null != endYearDiv1) {
                    appraisalPerformanceKra.setEndyearStatus(endYearDiv1);
                } else {
                    appraisalPerformanceKra.setEndyearStatus(null);
                }
                //=======End year========================================//
//                if (!"".equals(employeeMidYearSelfAssesssmentGoal) && null != employeeMidYearSelfAssesssmentGoal && flagId.equals("false")) {
//                    appraisalPerformanceKra.setEmpMidyearSelfassessmentGoal(employeeMidYearSelfAssesssmentGoal);
//                } else {
//                    appraisalPerformanceKra.setEmpMidyearSelfassessmentGoal(null);
//                }

//                if (!"".equals(managerMidYearSelfAssesssmentGoal) && null != managerMidYearSelfAssesssmentGoal && flagId.equals("false")) {
//                    appraisalPerformanceKra.setManagerMidyearReviewEvaluation(managerMidYearSelfAssesssmentGoal);
//                } else {
//                    appraisalPerformanceKra.setManagerMidyearReviewEvaluation(null);
//                }
//                if (!"".equals(empMidyearSelfassOtheractivty) && null != empMidyearSelfassOtheractivty) {
//
//                    appraisalPerformanceMaster.setEmpMidyearSelfassOtheractivty(empMidyearSelfassOtheractivty);
//                    //appraisalPerformanceService.update(appraisalPerformanceMaster);
//                } else {
//                    appraisalPerformanceMaster.setEmpMidyearSelfassOtheractivty(null);
//                }
//                if (!"".equals(managerMidyearReviewevalOtheractivity) && null != managerMidyearReviewevalOtheractivity) {
//
//                    appraisalPerformanceMaster.setManagerMidyearReviewevalOtheractivity(managerMidyearReviewevalOtheractivity);
////                        appraisalPerformanceService.update(appraisalPerformanceMaster);
//                } else {
//                    appraisalPerformanceMaster.setManagerMidyearReviewevalOtheractivity("");
//                }
                //=======End year=======================================//
//                if (!"".equals(managerEndYearSelfAssesssmentGoal) && null != managerEndYearSelfAssesssmentGoal && flagId.equals("false") && midhalf.equals("false")) {
//                    appraisalPerformanceKra.setManagerEndyearReviewEvaluation(managerEndYearSelfAssesssmentGoal);
//                } else {
//                    appraisalPerformanceKra.setManagerEndyearReviewEvaluation(null);
//                }
                if (!"".equals(managerEndyearReviewevalOtheractivity) && null != managerEndyearReviewevalOtheractivity) {
                    appraisalPerformanceMaster.setManagerEndyearReviewevalOtheractivity(managerEndyearReviewevalOtheractivity);
                } else {
                    appraisalPerformanceMaster.setManagerEndyearReviewevalOtheractivity("");
                }
                if (!"".equals(employeeEndYearSelfAssesssmentGoal) && null != employeeEndYearSelfAssesssmentGoal && flagId.equals("false")) {
                    appraisalPerformanceKra.setEmpEndyearSelfassessmentGoal(employeeEndYearSelfAssesssmentGoal);
                } else {
                    appraisalPerformanceKra.setEmpEndyearSelfassessmentGoal(null);
                }
                if (!"".equals(empEndyearSelfassOtheractivty) && null != empEndyearSelfassOtheractivty) {

                    appraisalPerformanceMaster.setEmpEndyearSelfassOtheractivty(empEndyearSelfassOtheractivty);
//                        appraisalPerformanceService.update(appraisalPerformanceMaster);
                } else {
                    appraisalPerformanceMaster.setEmpEndyearSelfassOtheractivty(null);
                }
                String btn1 = request.getParameter("save");
                //=======End year=======================================//
                if (null != btn1 && btn1.equals("save")) {
//                    appraisalPerformanceKra = appraisalPerformanceKraService.readById(Integer.parseInt(kragoal_id));
//                    By Ajay
                    if (kragoal_id != null) {
                        appraisalPerformanceKra.setId(Integer.parseInt(kragoal_id));
                        appraisalPerformanceKraService.update(appraisalPerformanceKra);
                    } else {

//                        if (midhalf.equals("true")) {
//                            appraisalPerformanceKra.setMidyearEmpSelfassStatus(0);
//                            appraisalPerformanceKra.setMidyearManagerSelfassStatus(0);
//                        }
                        if (endhalf.equals("true")) {
                            appraisalPerformanceKra.setEndyearEmpSelfassStatus(0);
                            appraisalPerformanceKra.setEndyearManagerSelfassStatus(0);
                        }
//                        appraisalPerformanceMaster.setId(Integer.parseInt(appraisalId));
                        appraisalPerformanceKra.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
                        appraisalPerformanceMaster.setEmployeeTotalFinalScore("" + empFinalTotalCount);
                        appraisalPerformanceKraService.create(appraisalPerformanceKra);
                    }
                    request.setAttribute("successMessage",
                            "Information : The Information is Saved Successfully.");

                } else {
                    ////////////////Submit code////////////////////////////////

                    appraisalPerformanceKra.setKraGoalByManager(kraGoal1);
                    appraisalPerformanceKra.setMatrixByManager(metric1);
                    if (null != weightage1 && !weightage1.equals("") && !weightage1.equals("null")) {
                        appraisalPerformanceKra.setWeightageManager(Float.parseFloat(weightage1));
                    } else {
                        appraisalPerformanceKra.setWeightageManager(null);
                    }
//
                    if (!"".equals(kraCategoryMap) && null != kraCategoryMap) {
                        kraCategory.setId(Integer.parseInt(kraCategoryMap));
                        appraisalPerformanceKra.setKraCategoryByKraCategoryByManager(kraCategory);
                    }

//                    if (!"".equals(employeeMidYearSelfAssesssmentGoal) && null != employeeMidYearSelfAssesssmentGoal && flagId.equals("false")) {
//                        appraisalPerformanceKra.setEmpMidyearSelfassessmentGoalManager(employeeMidYearSelfAssesssmentGoal);
//                    } else {
//                        appraisalPerformanceKra.setEmpMidyearSelfassessmentGoalManager(null);
//                    }
                    if (!"".equals(employeeEndYearSelfAssesssmentGoal) && null != employeeEndYearSelfAssesssmentGoal && flagId.equals("false")) {
                        appraisalPerformanceKra.setEmpEndyearSelfassessmentGoalManager(employeeEndYearSelfAssesssmentGoal);
                    } else {
                        appraisalPerformanceKra.setEmpEndyearSelfassessmentGoalManager(null);
                    }
//                    if (!"".equals(midYearDiv1) && null != midYearDiv1) {
//                        appraisalPerformanceKra.setMidyearStatusManager(midYearDiv1);
//                    } else {
//                        appraisalPerformanceKra.setMidyearStatusManager(null);
//                    }
                    if (!"".equals(endYearDiv1) && null != endYearDiv1) {
                        appraisalPerformanceKra.setEndyearStatusManager(endYearDiv1);
                    } else {
                        appraisalPerformanceKra.setEndyearStatusManager(null);
                    }

//                    if (!"".equals(finalScore) && null != finalScore) {
//                        appraisalPerformanceKra.setFinalScoreManager(finalScore);
//                    } else {
//                        appraisalPerformanceKra.setFinalScoreManager(null);
//                    }
                    ////////////////For  Manager side/////////////
//                    if (!"".equals(employeeMidYearSelfAssesssmentGoal) && null != employeeMidYearSelfAssesssmentGoal && flagId.equals("false")) {
//                        appraisalPerformanceKra.setEmpMidyearSelfassessmentGoalManager(employeeMidYearSelfAssesssmentGoal);
//                    } else {
//                        appraisalPerformanceKra.setEmpMidyearSelfassessmentGoalManager(null);
//                    }
//                    if (!"".equals(managerMidYearSelfAssesssmentGoal) && null != managerMidYearSelfAssesssmentGoal && flagId.equals("false")) {
//                        appraisalPerformanceKra.setManagerMidyearReviewEvaluationManager(managerMidYearSelfAssesssmentGoal);
//                    } else {
//                        appraisalPerformanceKra.setManagerMidyearReviewEvaluationManager(null);
//                    }
                    if (!"".equals(employeeEndYearSelfAssesssmentGoal) && null != employeeEndYearSelfAssesssmentGoal && flagId.equals("false")) {
                        appraisalPerformanceKra.setEmpEndyearSelfassessmentGoalManager(employeeEndYearSelfAssesssmentGoal);
                    } else {
                        appraisalPerformanceKra.setEmpEndyearSelfassessmentGoalManager(null);
                    }
//                    if (!"".equals(managerEndYearSelfAssesssmentGoal) && null != managerEndYearSelfAssesssmentGoal && flagId.equals("false") && midhalf.equals("false")) {
//                        appraisalPerformanceKra.setManagerEndyearReviewEvaluationManager(managerEndYearSelfAssesssmentGoal);
//                    } else {
//                        appraisalPerformanceKra.setManagerEndyearReviewEvaluationManager(null);
//                    }
                    try {

                        if (kragoal_id != null) {

                            appraisalPerformanceKra1 = appraisalPerformanceKraService.readById(Integer.parseInt(kragoal_id));
                            if (null != appraisalPerformanceKra1.getWeightage() && appraisalPerformanceKra1.getKraGoal().equals(appraisalPerformanceKra.getKraGoal())
                                    && appraisalPerformanceKra1.getMetric().equals(appraisalPerformanceKra.getMetric())
                                    && appraisalPerformanceKra1.getWeightage().equals(appraisalPerformanceKra.getWeightage())) {

                            } else {

                                updateAppraisalPerformanceKra.setAppraisalPerformanceKra(appraisalPerformanceKra1);
                                updateAppraisalPerformanceKra.setUpdateDate(startdate);
                                updateAppraisalPerformanceKra.setUpdateKra(appraisalPerformanceKra1.getKraGoal());
                                updateAppraisalPerformanceKra.setUpdateMetric(appraisalPerformanceKra1.getMetric());
                                updateAppraisalPerformanceKra.setName(employee.getEmployeeName());
                                updateAppraisalPerformanceKra.setWeighted("" + appraisalPerformanceKra1.getWeightage());
                                updateAppraisalPerformanceKraService.create(updateAppraisalPerformanceKra);
                            }
                        }
                    } catch (Exception e) {

                    }

                    ////Match the Kra goal and update it////////
                    /////////////////////////////////////////////////////////
                    if (kragoal_id != null) {
                        appraisalPerformanceKra.setId(Integer.parseInt(kragoal_id));
                        appraisalPerformanceKraService.update(appraisalPerformanceKra);
                    } else {
//                        appraisalPerformanceMaster.setId(Integer.parseInt(appraisalId));
                        appraisalPerformanceKra.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
                        appraisalPerformanceKraService.create(appraisalPerformanceKra);
                    }

//                    //history code
//                    appraisalPerformanceKra1 = appraisalPerformanceKraService.readById(kragoalId);
//                    updateAppraisalPerformanceKra.setAppraisalPerformanceKra(appraisalPerformanceKra);
//                    updateAppraisalPerformanceKra.setUpdateDate(startdate);
//                    updateAppraisalPerformanceKra.setUpdateKra(kraGoal1);
//                    updateAppraisalPerformanceKra.setUpdateMetric(metric1);
//                    ////Match the Kra goal and update it////////
//                    if (appraisalPerformanceKra1.getKraGoal().equals(appraisalPerformanceKra.getKraGoal())) {
//
//                    } else {
//                        updateAppraisalPerformanceKraService.create(updateAppraisalPerformanceKra);
//
//                    }
                    ///////    Upadte history Detail     /////////
                    request.setAttribute("successMessage",
                            "Information : The Information is Submit Successfully.");
                }
            }

            ////////////////////////////////////KRA OTHER Activity///////////////////////////////////////////////////////////
            /////////////////////changes In new PMP 2017////////////////////////////////////////
            //////////////////cpmmented by nishant
//            if (Integer.parseInt(year) == 2016) {
//
//                int countActivityId = Integer.parseInt(request.getParameter("countactivityId"));
//                appraisalPerformanceActivities.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
//                //String kragoal_id = "";
//                for (int i = 1; i <= countActivityId; i++) {
//
//                    appraisalPerformanceActivities = new AppraisalPerformanceActivities();
//                    String kragoal_activity_id = request.getParameter("kragoal_activity_id" + i);
//                    if (null != kragoal_activity_id) {
//                        appraisalPerformanceActivities = appraisalPerformanceActivitiesService.readById(Integer.parseInt(kragoal_activity_id));
//                    }
//                    String kraGoalactivity = request.getParameter("kraGoal_activity" + i);
//                    String metricactivity = request.getParameter("metric_activity" + i);
//                    String kraCategoryMapOther = request.getParameter("kraCategoryMapOther" + i);
//                    String priority = request.getParameter("priority" + i);
//                    String midYearDivOther = request.getParameter("midYearDivOther" + i);
//                    String endYearDivOther = request.getParameter("endYearDivOther" + i);
//                    String activity = request.getParameter("activity" + i);
//                    String empMidyearSelfassessmentGoalActivities = request.getParameter("empMidyearSelfassessmentGoalActivities" + i);
//                    String managerMidYearSelfAssesssmentGoalActivities = request.getParameter("managerMidYearSelfAssesssmentGoalActivities" + i);
//                    String empEndyearSelfassessmentGoalActivities = request.getParameter("empEndyearSelfassessmentGoalActivities" + i);
//                    String managerEndYearSelfAssesssmentGoalActivities = request.getParameter("managerEndYearSelfAssesssmentGoalActivities" + i);
//                    if (null != kraGoalactivity && !kraGoalactivity.equals("")) {
//                        appraisalPerformanceActivities.setKraGoalActivities(kraGoalactivity);
//                    } else {
//                        appraisalPerformanceActivities.setKraGoalActivities(null);
//                    }
//                    if (null != metricactivity && !metricactivity.equals("")) {
//                        appraisalPerformanceActivities.setMetricActivities(metricactivity);
//                    } else {
//                        appraisalPerformanceActivities.setMetricActivities(null);
//                    }
//                    if (null != kraCategoryMapOther && !kraCategoryMapOther.equals("")) {
//                        appraisalPerformanceActivities.setKraCategoryByEmployeeActivities(Integer.parseInt(kraCategoryMapOther));
//                    } else {
//                        appraisalPerformanceActivities.setKraCategoryByEmployeeActivities(null);
//                    }
//
//                    if (null != priority && !priority.equals("")) {
//                        appraisalPerformanceActivities.setPriority(priority);
//                    } else {
//                        appraisalPerformanceActivities.setPriority(priority);
//                    }
//
//                    if (null != midYearDivOther && !midYearDivOther.equals("")) {
//                        appraisalPerformanceActivities.setMidyearStatusActivities(midYearDivOther);
//                    } else {
//                        appraisalPerformanceActivities.setMidyearStatusActivities(null);
//                    }
//                    if (null != endYearDivOther && !endYearDivOther.equals("")) {
//                        appraisalPerformanceActivities.setEndyearStatusActivities(endYearDivOther);
//                    } else {
//                        appraisalPerformanceActivities.setEndyearStatusActivities(null);
//                    }
//                    if (null != activity && !activity.equals("")) {
//                        appraisalPerformanceActivities.setActivity(activity);
//                    } else {
//                        appraisalPerformanceActivities.setActivity(null);
//                    }
//                    if (null != empMidyearSelfassessmentGoalActivities && !empMidyearSelfassessmentGoalActivities.equals("")) {
//                        appraisalPerformanceActivities.setEmpMidyearSelfassessmentGoalActivities(empMidyearSelfassessmentGoalActivities);
//                    } else {
//                        appraisalPerformanceActivities.setEmpMidyearSelfassessmentGoalActivities(null);
//                    }
////                if (null != managerMidYearSelfAssesssmentGoalActivities && !managerMidYearSelfAssesssmentGoalActivities.equals("")) {
////                    appraisalPerformanceActivities.setManagerMidyearSelfassesssmentGoalActivities(managerMidYearSelfAssesssmentGoalActivities);
////                } else {
////                    appraisalPerformanceActivities.setManagerMidyearSelfassesssmentGoalActivities(null);
////                }
//                    if (null != empEndyearSelfassessmentGoalActivities && !empEndyearSelfassessmentGoalActivities.equals("")) {
//                        appraisalPerformanceActivities.setEmpEndyearSelfassessmentGoalActivities(empEndyearSelfassessmentGoalActivities);
//                    } else {
//                        appraisalPerformanceActivities.setEmpEndyearSelfassessmentGoalActivities(null);
//                    }
////                if (null != managerEndYearSelfAssesssmentGoalActivities && !managerEndYearSelfAssesssmentGoalActivities.equals("")) {
////                    appraisalPerformanceActivities.setManagerEndyearSelfassesssmentGoalActivities(managerEndYearSelfAssesssmentGoalActivities);
////                } else {
////                    appraisalPerformanceActivities.setManagerEndyearSelfassesssmentGoalActivities(null);
////                }
//                    String btn2 = request.getParameter("save");
//                    //=======End year=======================================//
//                    if (null != btn2 && btn2.equals("save")) {
//                        if (null != kragoal_activity_id) {
//                            //appraisalPerformanceActivities1 = appraisalPerformanceActivitiesService.readById(Integer.parseInt(kragoal_activity_id));
//                            appraisalPerformanceActivities.setId(Integer.parseInt(kragoal_activity_id));
//                            appraisalPerformanceActivitiesService.update(appraisalPerformanceActivities);
//                        } else {
//                            if (midhalf.equals("true")) {
//                                appraisalPerformanceActivities.setMidyearEmpSelfassActivityStatus(0);
//                                appraisalPerformanceActivities.setMidyearManagerSelfassActivityStatus(0);
//                            }
//                            if (endhalf.equals("true")) {
//                                appraisalPerformanceActivities.setEndyearEmpSelfassActivityStatus(0);
//                                appraisalPerformanceActivities.setEndyearManagerSelfassActivityStatus(0);
//                            }
////                        appraisalPerformanceMaster.setId(Integer.parseInt(appraisalId));
//                            appraisalPerformanceActivities.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
//                            appraisalPerformanceActivitiesService.create(appraisalPerformanceActivities);
//                        }
//                    } else {
//                        if (null != midYearDivOther && !midYearDivOther.equals("")) {
//                            appraisalPerformanceActivities.setMidyearStatusActivitiesManager(midYearDivOther);
//                        } else {
//                            appraisalPerformanceActivities.setMidyearStatusActivitiesManager(null);
//                        }
//                        if (null != kraGoalactivity && !kraGoalactivity.equals("")) {
//                            appraisalPerformanceActivities.setKraGoalActivitiesManager(kraGoalactivity);
//                        } else {
//                            appraisalPerformanceActivities.setKraGoalActivitiesManager(null);
//                        }
//                        if (null != metricactivity && !metricactivity.equals("")) {
//                            appraisalPerformanceActivities.setMetricActivitiesManager(metricactivity);
//                        } else {
//                            appraisalPerformanceActivities.setMetricActivitiesManager(null);
//                        }
//                        if (null != kraCategoryMapOther && !kraCategoryMapOther.equals("")) {
//                            appraisalPerformanceActivities.setKraCategoryByManagerActivities(Integer.parseInt(kraCategoryMapOther));
//                        } else {
//                            appraisalPerformanceActivities.setKraCategoryByManagerActivities(null);
//                        }
//                        if (null != priority && !priority.equals("")) {
//                            appraisalPerformanceActivities.setManagerPriority(priority);
//                        } else {
//                            appraisalPerformanceActivities.setManagerPriority(priority);
//                        }
//
//                        if (null != endYearDivOther && !endYearDivOther.equals("")) {
//                            appraisalPerformanceActivities.setEndyearStatusActivitiesManager(endYearDivOther);
//                        } else {
//                            appraisalPerformanceActivities.setEndyearStatusActivitiesManager(null);
//                        }
//
//                        if (null != activity && !activity.equals("")) {
//                            appraisalPerformanceActivities.setManagerActivity(activity);
//                        } else {
//                            appraisalPerformanceActivities.setManagerActivity(null);
//                        }
//                        if (null != empMidyearSelfassessmentGoalActivities && !empMidyearSelfassessmentGoalActivities.equals("")) {
//                            appraisalPerformanceActivities.setEmpMidyearSelfassessmentGoalActivitiesManager(empMidyearSelfassessmentGoalActivities);
//                        } else {
//                            appraisalPerformanceActivities.setEmpMidyearSelfassessmentGoalActivitiesManager(null);
//                        }
////                    if (null != managerMidYearSelfAssesssmentGoalActivities && !managerMidYearSelfAssesssmentGoalActivities.equals("")) {
////                        appraisalPerformanceActivities.setManagerMidyearSelfassesssmentGoalActivitiesManager(managerMidYearSelfAssesssmentGoalActivities);
////                    } else {
////                        appraisalPerformanceActivities.setManagerMidyearSelfassesssmentGoalActivitiesManager(null);
////                    }
//                        if (null != empEndyearSelfassessmentGoalActivities && !empEndyearSelfassessmentGoalActivities.equals("")) {
//                            appraisalPerformanceActivities.setEmpEndyearSelfassessmentGoalActivitiesManager(empEndyearSelfassessmentGoalActivities);
//                        } else {
//                            appraisalPerformanceActivities.setEmpEndyearSelfassessmentGoalActivitiesManager(null);
//                        }
////                    if (null != managerEndYearSelfAssesssmentGoalActivities && !managerEndYearSelfAssesssmentGoalActivities.equals("")) {
////                        appraisalPerformanceActivities.setManagerEndyearSelfassesssmentGoalActivitiesManager(managerEndYearSelfAssesssmentGoalActivities);
////                    } else {
////                        appraisalPerformanceActivities.setManagerEndyearSelfassesssmentGoalActivitiesManager(null);
////                    }
//                        try {
//
//                            if (null != kragoal_activity_id) {
//
//                                appraisalPerformanceActivities1 = appraisalPerformanceActivitiesService.readById(Integer.parseInt(kragoal_activity_id));
//                                if (null != appraisalPerformanceActivities1.getKraGoalActivities()) {
//
//                                    if (appraisalPerformanceActivities1.getKraGoalActivities().equals(appraisalPerformanceActivities.getKraGoalActivities())
//                                            && appraisalPerformanceActivities1.getMetricActivities().equals(appraisalPerformanceActivities1.getMetricActivities())) {
//
//                                    } else {
//                                        updateAppraisalPerformanceActivities.setAppraisalPerformanceActivities(appraisalPerformanceActivities1);
//                                        updateAppraisalPerformanceActivities.setKraActivity(appraisalPerformanceActivities1.getKraGoalActivities());
//                                        updateAppraisalPerformanceActivities.setMetricActivity(appraisalPerformanceActivities1.getMetricActivities());
//                                        updateAppraisalPerformanceActivities.setUpdateDate(startdate);
//                                        updateAppraisalPerformanceActivities.setChangedBy(employee.getEmployeeName());
//                                        updateAppraisalPerformanceActivitiesService.create(updateAppraisalPerformanceActivities);
//                                    }
//                                }
//                            }
//                        } catch (Exception e) {
//
//                        }
//
//                        if (null != kragoal_activity_id) {
//                            appraisalPerformanceActivities.setId(Integer.parseInt(kragoal_activity_id));
//                            appraisalPerformanceActivitiesService.update(appraisalPerformanceActivities);
//                        } else {
////                        appraisalPerformanceMaster.setId(Integer.parseInt(appraisalId));
//                            appraisalPerformanceActivities.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
//                            appraisalPerformanceActivitiesService.create(appraisalPerformanceActivities);
//                        }
//                    }
//                }
//            }
            ///////////////////////commented upper code by nishant
            /////////////////////changes In new PMP 2017////////////////////////////////////////
//                if (!"".equals(kraGoalactivity) && null != kraGoalactivity) {
//                    if (null != kragoal_activity_id) {
//                        appraisalPerformanceActivities1 = appraisalPerformanceActivitiesService.readById(Integer.parseInt(kragoal_activity_id));
//                        appraisalPerformanceActivities.setId(Integer.parseInt(kragoal_activity_id));
//                        appraisalPerformanceActivitiesService.update(appraisalPerformanceActivities);
//
////                        updateAppraisalPerformanceActivities.setAppraisalPerformanceActivities(appraisalPerformanceActivities);
////                        updateAppraisalPerformanceActivities.setKraActivity(kraGoalactivity);
////                        updateAppraisalPerformanceActivities.setMetricActivity(metricactivity);
////                        updateAppraisalPerformanceActivities.setUpdateDate(startdate);
////                        if (appraisalPerformanceActivities1.getKraGoalActivities().equals(appraisalPerformanceActivities.getKraGoalActivities())) {
////
////                        } else {
//////                            updateAppraisalPerformanceActivitiesService.create(updateAppraisalPerformanceActivities);
////
////                        }
//                    } else {
//                        appraisalPerformanceActivitiesService.create(appraisalPerformanceActivities);
//                        ////////////history code//////////////////
////                        updateAppraisalPerformanceActivities.setAppraisalPerformanceActivities(appraisalPerformanceActivities);
////                        updateAppraisalPerformanceActivities.setKraActivity(activity);
////                        updateAppraisalPerformanceActivities.setMetricActivity(metricactivity);
////                        updateAppraisalPerformanceActivities.setUpdateDate(startdate);
////                        updateAppraisalPerformanceActivitiesService.create(updateAppraisalPerformanceActivities);
//                    }
            //}
            ////////////////////////////////////KRA OTHER Activity//////////////////////////////////////////////////////////
            ///////////////////Competency Evaluation (As Per Zydex Competency Framework)////////////////////////////
            ////////////////////////////////////KRA OTHER Activity  Closed//////////////////////////////////////////////////////////
            ///////////////////Competency Evaluation (As Per Zydex Competency Framework) change by date 11/11/2016////////////////////////////
//            AppraisalPerformanceCompetencyEvaluation appraisalPerformanceCompetencyEvaluation = new AppraisalPerformanceCompetencyEvaluation();
//            CompetencyEvaluationTextmaster competencyEvaluationTextmaster = new CompetencyEvaluationTextmaster();
//            CompetencyEvaluationMaster competencyEvaluationMaster = new CompetencyEvaluationMaster();
//            int subCompentencyCount = Integer.parseInt(request.getParameter("subCompentencyCount"));
//            boolean flag = true;
//            for (int i = 1; i <= subCompentencyCount; i++) {
//                String competencyEveId = request.getParameter("competencyEveId" + i);
//                if (competencyEveId != null) {
//                    appraisalPerformanceCompetencyEvaluation = appraisalPerformanceCompetencyEvaluationService.readById(Integer.parseInt(competencyEveId));
//                }
//                String compentencyStartYear = request.getParameter("compentencyStartYear" + i);
//                String compentencyStartRemark = request.getParameter("compentencyStartRemark" + i);
//                String compentencyMidYear = request.getParameter("compentencyMidYear" + i);
//                String compentencyMidRemark = request.getParameter("compentencyMidRemark" + i);
//                String compentencyEndYear = request.getParameter("compentencyEndYear" + i);
//                String compentencyEndRemark = request.getParameter("compentencyEndRemark" + i);
//                if (!"".equals(compentencyStartYear) && null != compentencyStartYear) {
//                    appraisalPerformanceCompetencyEvaluation.setCompetencyStartYear(compentencyStartYear);
//                } else {
//                    appraisalPerformanceCompetencyEvaluation.setCompetencyStartYear(null);
//                }
//                if (!"".equals(compentencyStartRemark) && null != compentencyStartRemark) {
//                    appraisalPerformanceCompetencyEvaluation.setStartyearRemark(compentencyStartRemark);
//                } else {
//                    appraisalPerformanceCompetencyEvaluation.setStartyearRemark(null);
//                }
//                if (!"".equals(compentencyMidYear) && null != compentencyMidYear) {
//                    appraisalPerformanceCompetencyEvaluation.setCompetencyMidYear(compentencyMidYear);
//                } else {
//                    appraisalPerformanceCompetencyEvaluation.setCompetencyMidYear(null);
//                }
//                if (!"".equals(compentencyMidRemark) && null != compentencyMidRemark) {
//                    appraisalPerformanceCompetencyEvaluation.setMidyearRemark(compentencyMidRemark);
//                } else {
//                    appraisalPerformanceCompetencyEvaluation.setMidyearRemark(null);
//                }
//                if (!"".equals(compentencyEndYear) && null != compentencyEndYear) {
//                    appraisalPerformanceCompetencyEvaluation.setCompetencyEndYear(compentencyEndYear);
//                } else {
//                    appraisalPerformanceCompetencyEvaluation.setCompetencyEndYear(null);
//                }
//                if (!"".equals(compentencyEndRemark) && null != compentencyEndRemark) {
//                    appraisalPerformanceCompetencyEvaluation.setEndyearRemark(compentencyEndRemark);
//                } else {
//                    appraisalPerformanceCompetencyEvaluation.setCompetencyEndYear(null);
//                }
//
////
//                appraisalPerformanceCompetencyEvaluation.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
//                int compentencyTextMasterId = Integer.parseInt(request.getParameter("compentencyTextMasterId" + i));
//                competencyEvaluationTextmaster.setId(compentencyTextMasterId);
////                competencyEvaluationMaster.setId(competencyEvaluationId);
////                appraisalPerformanceCompetencyEvaluation.setCompetencyEvaluationMaster(competencyEvaluationMaster);
//                appraisalPerformanceCompetencyEvaluation.setCompetencyEvaluationTextmaster(competencyEvaluationTextmaster);
////                String competencyEveId = request.getParameter("competencyEveId" + i);
//                String btn2 = request.getParameter("save");
//
//                if (null != btn2 && btn2.equals("save")) {
//                    if (!"".equals(competencyEveId) && null != competencyEveId) {
//                        int competencyEvaluationId = Integer.parseInt(request.getParameter("competencyEvaluationId" + i));
//                        competencyEvaluationMaster.setId(competencyEvaluationId);
//                        appraisalPerformanceCompetencyEvaluation.setCompetencyEvaluationMaster(competencyEvaluationMaster);
//                        appraisalPerformanceCompetencyEvaluation.setId(Integer.parseInt(competencyEveId));
////                        appraisalPerformanceCompetencyEvaluation.setEmployeeStatus(1);
//                        appraisalPerformanceCompetencyEvaluationService.update(appraisalPerformanceCompetencyEvaluation);
//
//                    } else {
////                        if (!appraisalId.isEmpty()) {
////                            if (flag) {
////                                for (String id : appraisalId.split(",")) {
////                                    if (!id.equals("")) {
////                                        AppraisalPerformanceCompetencyEvaluation appraisalPerformanceCompetencyEvaluation2 = new AppraisalPerformanceCompetencyEvaluation();
////                                        AppraisalPerformanceCompetencyEvaluationHistory appraisalPerformanceCompetencyEvaluationHistory = new AppraisalPerformanceCompetencyEvaluationHistory();
////                                        appraisalPerformanceCompetencyEvaluation2.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
////
////                                        try {
////
////                                            List<AppraisalPerformanceCompetencyEvaluation> competencyList = (List<AppraisalPerformanceCompetencyEvaluation>) appraisalPerformanceCompetencyEvaluationService.readByAppraisalPerformanceId(appraisalPerformanceCompetencyEvaluation2);
////
////                                            for (AppraisalPerformanceCompetencyEvaluation appraisalPerformanceCompetencyEvaluation1 : competencyList) {
////
////                                                BeanUtils.copyProperties(appraisalPerformanceCompetencyEvaluation1, appraisalPerformanceCompetencyEvaluationHistory);
////                                                appraisalPerformanceCompetencyEvaluationHistory.setAppraisalPerformanceId(appraisalPerformanceCompetencyEvaluation1.getAppraisalPerformanceMaster().getId());
////                                                appraisalPerformanceCompetencyEvaluationHistory.setCompetencyEvaluationId(appraisalPerformanceCompetencyEvaluation1.getCompetencyEvaluationMaster().getId());
////                                                appraisalPerformanceCompetencyEvaluationHistory.setCompetencyEvaluationTextId(appraisalPerformanceCompetencyEvaluation1.getCompetencyEvaluationTextmaster().getId());
//////                                            appraisalPerformanceCompetencyEvaluationHistory.setDateStr(startdate);
////                                                appraisalPerformanceCompetencyEvaluationHistory.setDateStr(strDate);
////                                                appraisalPerformanceCompetencyEvaluationHistory.setDeletedBy("Employee Side");
////                                                appraisalPerformanceCompetencyEvaluationHistory.setId(0);
////                                                appraisalPerformanceCompetencyEvaluationHistoryService.create(appraisalPerformanceCompetencyEvaluationHistory);
////                                            }
////                                        } catch (Exception e) {
////                                            e.printStackTrace();
////                                        }
////
////                                        appraisalPerformanceCompetencyEvaluationService.delete1(appraisalPerformanceCompetencyEvaluation2);
////                                        flag = false;
////                                    }
////                                }
////                            }
////                        }
//                        String competencyEvaluationId = request.getParameter("competencyEvaluationId");
//                        if (!"".equals(competencyEvaluationId) && null != competencyEvaluationId) {
//                            int competencyEvaluation_Id = Integer.parseInt(competencyEvaluationId);
//                            competencyEvaluationMaster.setId(competencyEvaluation_Id);
//                            appraisalPerformanceCompetencyEvaluation.setCompetencyEvaluationMaster(competencyEvaluationMaster);
////                            appraisalPerformanceCompetencyEvaluation.setEmployeeStatus(1);
//                            appraisalPerformanceCompetencyEvaluationService.create(appraisalPerformanceCompetencyEvaluation);
//                        }
//                    }
//                } else {
//
//                    /////////manager StartYearManager///////////////////////////////
//                    if (!"".equals(compentencyStartYear) && null != compentencyStartYear) {
//                        appraisalPerformanceCompetencyEvaluation.setCompetencyStartYearManager(compentencyStartYear);
//                    } else {
//                        appraisalPerformanceCompetencyEvaluation.setCompetencyStartYearManager(null);
//                    }
//                    if (!"".equals(compentencyStartRemark) && null != compentencyStartRemark) {
//                        appraisalPerformanceCompetencyEvaluation.setStartyearRemarkManager(compentencyStartRemark);
//                    } else {
//                        appraisalPerformanceCompetencyEvaluation.setStartyearRemarkManager(null);
//                    }
//                    if (!"".equals(compentencyMidYear) && null != compentencyMidYear) {
//                        appraisalPerformanceCompetencyEvaluation.setCompetencyMidYearManager(compentencyMidYear);
//                    } else {
//                        appraisalPerformanceCompetencyEvaluation.setCompetencyMidYearManager(null);
//                    }
//                    if (!"".equals(compentencyMidRemark) && null != compentencyMidRemark) {
//                        appraisalPerformanceCompetencyEvaluation.setMidyearRemarkManager(compentencyMidRemark);
//                    } else {
//                        appraisalPerformanceCompetencyEvaluation.setMidyearRemarkManager(null);
//                    }
//                    if (!"".equals(compentencyEndYear) && null != compentencyEndYear) {
//                        appraisalPerformanceCompetencyEvaluation.setCompetencyEndYearManager(compentencyEndYear);
//                    } else {
//                        appraisalPerformanceCompetencyEvaluation.setCompetencyEndYearManager(null);
//                    }
//                    if (!"".equals(compentencyEndRemark) && null != compentencyEndRemark) {
//                        appraisalPerformanceCompetencyEvaluation.setEndyearRemarkManager(compentencyEndRemark);
//                    } else {
//                        appraisalPerformanceCompetencyEvaluation.setCompetencyEndYearManager(null);
//                    }
//                    if (!"".equals(competencyEveId) && null != competencyEveId) {
//                        int competencyEvaluationId = Integer.parseInt(request.getParameter("competencyEvaluationId" + i));
//                        competencyEvaluationMaster.setId(competencyEvaluationId);
//                        appraisalPerformanceCompetencyEvaluation.setCompetencyEvaluationMaster(competencyEvaluationMaster);
//                        appraisalPerformanceCompetencyEvaluation.setId(Integer.parseInt(competencyEveId));
////                        appraisalPerformanceCompetencyEvaluation.setEmployeeStatus(1);
//                        appraisalPerformanceCompetencyEvaluationService.update(appraisalPerformanceCompetencyEvaluation);
//
//                    } else {
////                        if (!appraisalId.isEmpty()) {
////                            if (flag) {
////                                for (String id : appraisalId.split(",")) {
////                                    if (!id.equals("")) {
////                                        AppraisalPerformanceCompetencyEvaluation appraisalPerformanceCompetencyEvaluation2 = new AppraisalPerformanceCompetencyEvaluation();
////                                        appraisalPerformanceCompetencyEvaluation2.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
////                                        appraisalPerformanceCompetencyEvaluationService.delete1(appraisalPerformanceCompetencyEvaluation2);
////                                        flag = false;
////                                    }
////                                }
////                            }
////                        }
//                        String competencyEvaluationId = request.getParameter("competencyEvaluationId");
//                        if (!"".equals(competencyEvaluationId) && null != competencyEvaluationId) {
//                            int competencyEvaluation_Id = Integer.parseInt(competencyEvaluationId);
//                            competencyEvaluationMaster.setId(competencyEvaluation_Id);
//                            appraisalPerformanceCompetencyEvaluation.setCompetencyEvaluationMaster(competencyEvaluationMaster);
////                            appraisalPerformanceCompetencyEvaluation.setEmployeeStatus(1);
//                            appraisalPerformanceCompetencyEvaluationService.create(appraisalPerformanceCompetencyEvaluation);
//                        }
//                    }
//                }
//            }
//
            ///////////////////////////Individual Development Plan//////////////////////////////////
///////////////////////////Individual Development Plan change date 11/11/2016//////////////////////////////////
//            AppraisalPerformanceIndividualDevelopmentPlan appraisalPerformanceIndividualDevelopmentPlan = new AppraisalPerformanceIndividualDevelopmentPlan();
//            int individualcount = Integer.parseInt(request.getParameter("IndividualId"));
//            for (int i = 1; i <= individualcount; i++) {
//                String individualplan = request.getParameter("IndividualDevelopmentPlanId" + i);
//                if (null != individualplan) {
//
//                    appraisalPerformanceIndividualDevelopmentPlan = appraisalPerformanceIndividualDevelopmentPlanService.readById(Integer.parseInt(individualplan));
//                }
//                String text1 = request.getParameter("text" + i);
//                String text2 = request.getParameter("individualtextDiv" + i);
//                String text3 = request.getParameter("trainingSelectId" + i);
//                String remark = request.getParameter("trainingSelectTextinput" + i);
//                String midYearRemark = request.getParameter("midYearRemark" + i);
//                String endYearRemark = request.getParameter("endYearRemark" + i);
//                String managerMidYearRemark = request.getParameter("managerMidYearRemark" + i);
//                String managerEndYearRemark = request.getParameter("managerEndYearRemark" + i);
//                if (!"".equals(text1) && null != text1) {
//                    appraisalPerformanceIndividualDevelopmentPlan.setText1(text1);
//                } else {
//                    appraisalPerformanceIndividualDevelopmentPlan.setText1(null);
//                }
//
//                if (!"".equals(text2) && null != text2) {
//                    appraisalPerformanceIndividualDevelopmentPlan.setText2(text2);
//                } else {
//                    appraisalPerformanceIndividualDevelopmentPlan.setText2(null);
//                }
////                if (!"".equals(text2) && null != text2) {
////                    appraisalPerformanceIndividualDevelopmentPlan.setManagertext2(text2);
////                } else {
////                    appraisalPerformanceIndividualDevelopmentPlan.setManagertext2(null);
////                }
//                if (!"".equals(text3) && null != text3) {
//                    appraisalPerformanceIndividualDevelopmentPlan.setText3(text3);
//                } else {
//                    appraisalPerformanceIndividualDevelopmentPlan.setText3(null);
//                }
////                if (!"".equals(text3) && null != text3) {
////                    appraisalPerformanceIndividualDevelopmentPlan.setManagertext3(text3);
////                } else {
////                    appraisalPerformanceIndividualDevelopmentPlan.setManagertext3(null);
////                }
//                if (!"".equals(remark) && null != remark) {
//                    appraisalPerformanceIndividualDevelopmentPlan.setRemark(remark);
//                } else {
//                    appraisalPerformanceIndividualDevelopmentPlan.setRemark(null);
//                }
//                if (!"".equals(midYearRemark) && null != midYearRemark) {
//                    appraisalPerformanceIndividualDevelopmentPlan.setMidYearRemark(midYearRemark);
//                } else {
//                    appraisalPerformanceIndividualDevelopmentPlan.setMidYearRemark(null);
//                }
//                if (!"".equals(endYearRemark) && null != endYearRemark) {
//                    appraisalPerformanceIndividualDevelopmentPlan.setEndYearRemark(endYearRemark);
//                } else {
//                    appraisalPerformanceIndividualDevelopmentPlan.setEndYearRemark(null);
//                }
//
//                String btn4 = request.getParameter("save");
//                if (null != btn4 && btn4.equals("save")) {
//
//                    if (individualplan != null) {
//                        appraisalPerformanceIndividualDevelopmentPlan.setId(Integer.parseInt(individualplan));
//                        appraisalPerformanceIndividualDevelopmentPlanService.update(appraisalPerformanceIndividualDevelopmentPlan);
//                    } else {
//                        appraisalPerformanceIndividualDevelopmentPlan.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
//                        appraisalPerformanceIndividualDevelopmentPlanService.create(appraisalPerformanceIndividualDevelopmentPlan);
//                    }
//                    request.setAttribute("successMessage",
//                            "Information : The Information is Saved Successfully.");
//                } else {
//
//                    if (null != text1 && !"".equals(text1)) {
//                        appraisalPerformanceIndividualDevelopmentPlan.setManagertext1(text1);
//                    } else {
//                        appraisalPerformanceIndividualDevelopmentPlan.setManagertext1(null);
//                    }
//                    if (null != text2 && !"".equals(text2)) {
//                        appraisalPerformanceIndividualDevelopmentPlan.setManagertext2(text2);
//                    } else {
//                        appraisalPerformanceIndividualDevelopmentPlan.setManagertext2(null);
//                    }
//                    if (null != text3 && !"".equals(text3)) {
//                        appraisalPerformanceIndividualDevelopmentPlan.setManagertext3(text3);
//                    } else {
//                        appraisalPerformanceIndividualDevelopmentPlan.setManagertext3(null);
//                    }
//                    if (null != managerMidYearRemark && !"".equals(managerMidYearRemark)) {
//                        appraisalPerformanceIndividualDevelopmentPlan.setManagerMidYearRemark(managerMidYearRemark);
//                    } else {
//                        appraisalPerformanceIndividualDevelopmentPlan.setManagerMidYearRemark(null);
//                    }
//
//                    if (null != remark && !"".equals(remark)) {
//                        appraisalPerformanceIndividualDevelopmentPlan.setManagerremark(remark);
//                    } else {
//                        appraisalPerformanceIndividualDevelopmentPlan.setManagerremark(null);
//                    }
//                    if (null != endYearRemark && !"".equals(endYearRemark)) {
//                        appraisalPerformanceIndividualDevelopmentPlan.setManagerEndYearRemarkEmployee(endYearRemark);
//                    } else {
//                        appraisalPerformanceIndividualDevelopmentPlan.setManagerEndYearRemarkEmployee(null);
//                    }
//
//                    if (null != managerEndYearRemark && !"".equals(managerEndYearRemark)) {
//                        appraisalPerformanceIndividualDevelopmentPlan.setManagerEndYearRemark(managerEndYearRemark);
//                    } else {
//                        appraisalPerformanceIndividualDevelopmentPlan.setManagerEndYearRemark(null);
//                    }
//                    if (null != managerEndYearRemark && !"".equals(managerEndYearRemark)) {
//                        appraisalPerformanceIndividualDevelopmentPlan.setManagerEndYearRemarkManager(managerEndYearRemark);
//                    } else {
//                        appraisalPerformanceIndividualDevelopmentPlan.setManagerEndYearRemarkManager(null);
//                    }
////                    Mid year for Manager side //
//                    if (null != midYearRemark && !"".equals(midYearRemark)) {
//                        appraisalPerformanceIndividualDevelopmentPlan.setManagerMidYearRemarkManager(midYearRemark);
//                    } else {
//                        appraisalPerformanceIndividualDevelopmentPlan.setManagerMidYearRemarkManager(null);
//                    }
//                    if (null != managerEndYearRemark && !"".equals(managerEndYearRemark)) {
//                        appraisalPerformanceIndividualDevelopmentPlan.setManagerEndYearRemarkManager(managerEndYearRemark);
//                    } else {
//                        appraisalPerformanceIndividualDevelopmentPlan.setManagerEndYearRemarkManager(null);
//                    }
//
//                    if (individualplan != null) {
//                        appraisalPerformanceIndividualDevelopmentPlan.setId(Integer.parseInt(individualplan));
//                        appraisalPerformanceIndividualDevelopmentPlanService.update(appraisalPerformanceIndividualDevelopmentPlan);
//                    } else {
//                        appraisalPerformanceIndividualDevelopmentPlan.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
//                        appraisalPerformanceIndividualDevelopmentPlanService.create(appraisalPerformanceIndividualDevelopmentPlan);
//                    }
//                    request.setAttribute("successMessage",
//                            "Information : The Information is Submit Successfully.");
//                }
//            }
//
            //////////Behaviors///////////////
//            AppraisalPerformanceBehaviors appraisalPerformanceBehaviors = new AppraisalPerformanceBehaviors();
//
//            for (int i = 1; i <= 5; i++) {
//
//                String behaviors = request.getParameter("w" + i);
//                String midYearScore = request.getParameter("midYearScore" + i);
//                String endYearScore = request.getParameter("endYearScore" + i);
//                String managerMidYearReview = request.getParameter("managerMidYearReview" + i);
//                String managerEndYearReview = request.getParameter("managerEndYearReview" + i);
//                if (!"".equals(behaviors) && null != behaviors) {
//                    appraisalPerformanceBehaviors.setBehaviors(behaviors);
//                } else {
//                    appraisalPerformanceBehaviors.setBehaviors(null);
//                }
//                if (!"".equals(midYearScore) && null != midYearScore) {
//                    appraisalPerformanceBehaviors.setMidYearScore(Float.parseFloat(midYearScore));
//                } else {
//                    appraisalPerformanceBehaviors.setMidYearScore(null);
//                }
//                if (!"".equals(endYearScore) && null != endYearScore) {
//                    appraisalPerformanceBehaviors.setEndYearScore(Float.parseFloat(endYearScore));
//                } else {
//                    appraisalPerformanceBehaviors.setEndYearScore(null);
//                }
//                if (!"".equals(managerMidYearReview) && null != managerMidYearReview) {
//                    appraisalPerformanceBehaviors.setManagerMidYearReview(managerMidYearReview);
//                } else {
//                    appraisalPerformanceBehaviors.setManagerMidYearReview(null);
//                }
//                if (!"".equals(managerEndYearReview) && null != managerEndYearReview) {
//                    appraisalPerformanceBehaviors.setManagerEndYearReview(managerEndYearReview);
//                } else {
//                    appraisalPerformanceBehaviors.setManagerEndYearReview(null);
//                }
//                appraisalPerformanceBehaviors.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
//                appraisalPerformanceBehaviorsService.create(appraisalPerformanceBehaviors);
//            }
        }
        String btn1 = request.getParameter("save");
        if (null != btn1 && btn1.equals("save")) {
            String year = request.getParameter("yearparmStr");
//            mv.setViewName("redirect:appraisalPerformance.htm?act=editClick1&id=" + employee.getId() + "&userid=" + employee.getUserMaster().getId() + "&appraisalId=" + appraisalPerformanceMaster.getId() + "&year=" + year);
            mv.getModelMap().put("appraisalPerformanceMaster", appraisalPerformanceMaster);
//        mv.setViewName("forward:userMaster.htm?act=userDashboard");
//        mv = createClick(request, response);
            mv.setViewName("redirect:appraisalPerformance.htm?act=searchOwnappraisalPerformanceSubmit");
        } else {
            mv.getModelMap().put("appraisalPerformanceMaster", appraisalPerformanceMaster);
//        mv.setViewName("forward:userMaster.htm?act=userDashboard");
//        mv = createClick(request, response);
            mv.setViewName("redirect:appraisalPerformance.htm?act=searchOwnappraisalPerformanceSubmit");
//        mv = searchOwnappraisalPerformanceSubmit(request, response);
//        mv.setViewName("Appraisal/PerformanceAppraisalForm");
        }
        return mv;
    }

    public void autosave(HttpServletRequest request, HttpServletResponse response) throws Exception {

//        ModelAndView mv = new ModelAndView();
        AppraisalPerformanceMaster appraisalPerformanceMaster = new AppraisalPerformanceMaster();
        AppraisalPerformanceKra appraisalPerformanceKra = new AppraisalPerformanceKra();
        AppraisalPerformanceKra appraisalPerformanceKra1 = new AppraisalPerformanceKra();
        UpdateAppraisalPerformanceKra updateAppraisalPerformanceKra = new UpdateAppraisalPerformanceKra();
        UpdateAppraisalPerformanceActivities updateAppraisalPerformanceActivities = new UpdateAppraisalPerformanceActivities();
        AppraisalPerformanceActivities appraisalPerformanceActivities = new AppraisalPerformanceActivities();
        AppraisalPerformanceActivities appraisalPerformanceActivities1 = new AppraisalPerformanceActivities();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employee = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        PmpFormStatusMaster pmpFormStatusMaster = new PmpFormStatusMaster();
        BindException errors = new BindException(appraisalPerformanceMaster, "appraisalPerformanceMaster");
        kraCategoryList(request);
        KraCategory kraCategory = new KraCategory();
        String appraisalId = "";
        //selectedDateflage(request,response);
        String btn = request.getParameter("submit");
        appraisalPerformanceValidator.validate(appraisalPerformanceMaster, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
//            mv.addAllObjects(errors.getModel());
        } else {
            float weightageCount = 0;
            int countId = Integer.parseInt(request.getParameter("countId"));
            try {
                for (int i = 1; i <= countId; i++) {
                    String weightage1 = request.getParameter("weightage" + i);
                    if (!"".equals(weightage1)) {

                        weightageCount += Float.parseFloat(weightage1);
                    }
                }
            } catch (Exception e) {

            }

//            if (null != btn && btn.equals("submit")) {
//                if (weightageCount == 75) {
//
//                } else {
//
//                    request.setAttribute("failureMessage", "Information : Your Weightege is not equal to 75");
////                    mv.getModelMap().put("appraisalPerformanceMaster", appraisalPerformanceMaster);
////                    mv = searchOwnappraisalPerformanceSubmit(request, response);
////                    return mv;
//                }
//            }
            String employeeId = "" + employee.getId();
            String employeeName = "" + employee.getEmployeeName();
//            int year = Calendar.getInstance().get(Calendar.YEAR);
            String year = request.getParameter("yearparmStr");

//            List<?> l1 = = (List<AppraisalFillingData>) appraisalFillingDataService.getCurrentAndPreviousYear();
//            List<AppraisalFillingData> appraisalFilling = (List<AppraisalFillingData>) appraisalFillingDataService.getappraisalDate();
            List<AppraisalFillingData> appraisalFilling = (List<AppraisalFillingData>) appraisalFillingDataService.readByCurrentYear(year);
            String previousYear = "";
//        int currentYear = 0;
//            if (!l1.isEmpty()) {
//                Object[] obj = (Object[]) l1.get(0);
////            previousYear = (Integer) obj[0];
//                previousYear = "" + obj[0];
////            currentYear = (Integer) obj[1];
//            }
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            // Changes

            String today1 = sdf.format(cal.getTime());

            Date now1 = sdf.parse(today1);
            Calendar gc = new GregorianCalendar();
            boolean flagYear = true;
            for (AppraisalFillingData appraisalFilling1 : appraisalFilling) {

                List<?> list = appraisalPerformanceService.readByAppraisalPerformanceId(employeeId, Integer.parseInt(appraisalFilling1.getYear()));
                if (list.isEmpty()) {
                    String lastDateStr = "31/06/" + year;
                    Date lastDate = sdf.parse(lastDateStr);
                    if (now1.before(lastDate) && flagYear) {
                        appraisalFilling1.getManagerYearEndEndDate();
                        previousYear = appraisalFilling1.getYear();
                        flagYear = false;
                    } else if (flagYear) {
                        previousYear = appraisalFilling1.getYear();
                    }
                } else if ("".equals(previousYear)) {

                    previousYear = "" + request.getParameter("yearparmStr");
                }
            }

            // Changes
            //StartDate To create FirstTime//
            SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date now = new Date();
            String strDate = sdf1.format(now);
            String today = sdf.format(cal.getTime());
            String startdate = "" + today;
            String weightageScore = request.getParameter("weightageScore");
            if (null == weightageScore) {
                weightageScore = "";
            }
//            List<?> list = appraisalPerformanceService.readByAppraisalPerformanceId(employeeId, year);
            List<?> list = appraisalPerformanceService.readByAppraisalPerformanceId(employeeId, Integer.parseInt(previousYear));
            if (!list.isEmpty()) {
                //AppraisalPerformanceMaster appraisalPerformanceMaster =new AppraisalPerformanceMaster();
                appraisalPerformanceMaster = (AppraisalPerformanceMaster) list.get(0);
                appraisalId = "" + appraisalPerformanceMaster.getId();
                appraisalPerformanceMaster.setId(Integer.parseInt(appraisalId));
                appraisalPerformanceKra.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
            }
            if (null == appraisalPerformanceMaster.getId()) {

                int behaviosyear = Calendar.getInstance().get(Calendar.YEAR);
                appraisalPerformanceMaster.setEmployeeMaster(employee);
                appraisalPerformanceMaster.setStatus(0);
                appraisalPerformanceMaster.setManagerStatus(0);
                appraisalPerformanceMaster.setEmployeeStatus(0);
                appraisalPerformanceMaster.setBehaviorsYear("" + previousYear);
                appraisalPerformanceKra.setStartDate(startdate);
                appraisalPerformanceMaster.setWeightageScore(weightageScore);
                appraisalPerformanceService.create(appraisalPerformanceMaster);
            }

            String flagId = request.getParameter("flagId");
            String midhalf = request.getParameter("flagMidId");
            String endhalf = request.getParameter("flagEndId");
//            List<?> kraList = appraisalPerformanceKraService.readByAppraisalPerformancekraId(appraisalPerformanceKra);
//            if (!kraList.isEmpty()) {
//                appraisalPerformanceKra = (AppraisalPerformanceKra) kraList;
//                appraisalPerformanceKra.getId();
//            }

//            if (null != btn && btn.equals("submit")) {
//                if (appraisalPerformanceMaster.getReworkStatus() == 1 && null != midhalf && midhalf.equals("true")) {
//                    appraisalPerformanceMaster.setMidYearManagerStatus(0);
//                }
//                if (appraisalPerformanceMaster.getReworkStatus() == 1 && null != endhalf && endhalf.equals("true")) {
//                    appraisalPerformanceMaster.setEndYearManagerStatus(0);
//                }
//                appraisalPerformanceMaster.setStatus(1);
//                appraisalPerformanceMaster.setManagerkraStatus(0);
//                appraisalPerformanceMaster.setEmployeeStatus(1);
//                appraisalPerformanceMaster.setReworkStatus(0);
//                appraisalPerformanceMaster.setWeightageScore(weightageScore);
//                appraisalPerformanceMaster.setWeightageScoreManager(weightageScore);
//
//                if (midhalf.equals("true")) {
//                    appraisalPerformanceMaster.setMidYearEmployeeStatus(1);
//                }
//                if (endhalf.equals("true")) {
//                    appraisalPerformanceMaster.setEndYearEmployeeStatus(1);
//                }
//
//                appraisalPerformanceService.update(appraisalPerformanceMaster);
//                if (!"".equals(flagId) && null != flagId) {
//                    if (flagId.equals("true")) {
////   Email Sent to ReportingManager1 at Start Year
//                        try {
//                            EmailTemplate emailTemplate = new EmailTemplate();
//                            EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
//                            DesignationMaster designationMaster = new DesignationMaster();
//                            designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
//                            EmployeeMaster employeeMasterHr = new EmployeeMaster();
//                            employeeMasterHr = employeeMasterService.readById(Integer.parseInt(employeeMasterModel.getReportingManagerLevel1()));
//                            // id 113 is for Appraisal Submitted by employee(Start year)
//                            emailTemplate = emailTemplateService.readById(113);
//                            String To = employeeMasterHr.getOfficeEmailId();
//                            String from = employeeMasterModel.getOfficeEmailId();
//                            String Subject = emailTemplate.getSubject();
//                            Subject = Subject.replaceAll("\\{user\\}", employeeMasterModel.getEmployeeName());
//                            String msg = emailTemplate.getBodytext();
//                            msg = msg.replaceAll("\\{to_user\\}", employeeMasterHr.getEmployeeName());
//                            msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
//                            msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
//                            sendMail.sendMail(from, To, Subject, msg);
//                            mailSendPmpStartHalfapply(request);
//                        } catch (Exception e) {
//
//                        }
//                    }
//                }
//                if (!"".equals(midhalf) && null != midhalf) {
//                    if (midhalf.equals("true")) {
////   Email Sent to ReportingManager1 at Mid Year
//                        try {
//                            EmailTemplate emailTemplate = new EmailTemplate();
//                            EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
//                            DesignationMaster designationMaster = new DesignationMaster();
//                            designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
//                            EmployeeMaster employeeMasterHr = new EmployeeMaster();
//                            employeeMasterHr = employeeMasterService.readById(Integer.parseInt(employeeMasterModel.getReportingManagerLevel1()));
//                            // id 114 is for Appraisal Submitted by employee(Mid year)
//                            emailTemplate = emailTemplateService.readById(114);
//                            String To = employeeMasterHr.getOfficeEmailId();
//                            String from = employeeMasterModel.getOfficeEmailId();
//                            String Subject = emailTemplate.getSubject();
//                            Subject = Subject.replaceAll("\\{user\\}", employeeMasterModel.getEmployeeName());
//                            String msg = emailTemplate.getBodytext();
//                            msg = msg.replaceAll("\\{to_user\\}", employeeMasterHr.getEmployeeName());
//                            msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
//                            msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
//                            sendMail.sendMail(from, To, Subject, msg);
//                            mailSendPmpMidHalfapply(request);
//                        } catch (Exception e) {
//
//                        }
//                    }
//                }
//                if (!"".equals(endhalf) && null != endhalf) {
//                    if (endhalf.equals("true")) {
////   Email Sent to ReportingManager1 at  Year End
//                        try {
//                            EmailTemplate emailTemplate = new EmailTemplate();
//                            EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
//                            DesignationMaster designationMaster = new DesignationMaster();
//                            designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
//                            EmployeeMaster employeeMasterHr = new EmployeeMaster();
//                            employeeMasterHr = employeeMasterService.readById(Integer.parseInt(employeeMasterModel.getReportingManagerLevel1()));
//                            // id 115 is for Appraisal Submitted by employee(year End)
//                            emailTemplate = emailTemplateService.readById(115);
//                            String To = employeeMasterHr.getOfficeEmailId();
//                            String from = employeeMasterModel.getOfficeEmailId();
//                            String Subject = emailTemplate.getSubject();
//                            Subject = Subject.replaceAll("\\{user\\}", employeeMasterModel.getEmployeeName());
//                            String msg = emailTemplate.getBodytext();
//                            msg = msg.replaceAll("\\{to_user\\}", employeeMasterHr.getEmployeeName());
//                            msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
//                            msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
//                            sendMail.sendMail(from, To, Subject, msg);
//                            mailSendPmpEndHalfapply(request);
//                        } catch (Exception e) {
//
//                        }
//                    }
//                }
//            } else {
            appraisalPerformanceMaster.setWeightageScore(weightageScore);
            appraisalPerformanceService.update(appraisalPerformanceMaster);
//            }

//            StartDate To create FirstTime//
//            =========if appraisalPerformance is create and after get id=======//
            appraisalPerformanceKra.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
            appraisalPerformanceMaster.getId();//get Appraisal id
            //String employeeName = request.getParameter("employeeName");

//            if (null != btn && btn.equals("submit")) {
//
//                String kraremovedIdVal = request.getParameter("kraremovedIdVal");
//                if (!kraremovedIdVal.isEmpty()) {
//                    for (String id : kraremovedIdVal.split(",")) {
//                        if (!id.equals("")) {
//                            try {
//                                AppraisalPerformanceKra appraisalPerformanceKra2 = new AppraisalPerformanceKra();
//                                UpdateAppraisalPerformanceKra updateAppraisalPerformanceKra1 = new UpdateAppraisalPerformanceKra();
//                                AppraisalKraActivity appraisalkraActivity = new AppraisalKraActivity();
//
//                                appraisalPerformanceKra2.setId(Integer.parseInt(id));
//                                appraisalPerformanceKra2 = appraisalPerformanceKraService.readById(appraisalPerformanceKra2.getId());
//
//                                appraisalkraActivity.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
//                                appraisalkraActivity.setDeletedKra(appraisalPerformanceKra2.getKraGoal());
//                                appraisalkraActivity.setDeletedMetric(appraisalPerformanceKra2.getMetric());
//                                appraisalkraActivity.setDeletedWeightage("" + appraisalPerformanceKra2.getWeightage());
//                                appraisalkraActivity.setDeletedBy(employeeName);
//                                appraisalkraActivity.setStatus("KRAGOAL");
//                                appraisalkraActivity.setKraDeletedDate(today);
//                                appraisalkraActivityService.create(appraisalkraActivity);
//
//                                updateAppraisalPerformanceKra1.setAppraisalPerformanceKra(appraisalPerformanceKra2);
//                                List updatedKraList = updateAppraisalPerformanceKraService.readByKraIdForDelete(updateAppraisalPerformanceKra1);
//                                for (Object obj : updatedKraList) {
//                                    updateAppraisalPerformanceKra1 = (UpdateAppraisalPerformanceKra) obj;
//                                    updateAppraisalPerformanceKraService.delete(updateAppraisalPerformanceKra1.getId());
//                                }
//                                appraisalPerformanceKraService.delete1(appraisalPerformanceKra2);
//
//                            } catch (Exception e) {
//                            }
//                        }
//                    }
//                }
//            }
            if (Integer.parseInt(year) == 2016) {

//                if (null != btn && btn.equals("submit")) {
//
//                    String kraremovedActivitiesIdVal = request.getParameter("kraremovedActivitiesIdVal");
//                    if (!kraremovedActivitiesIdVal.isEmpty()) {
//                        for (String id : kraremovedActivitiesIdVal.split(",")) {
//                            if (!id.equals("")) {
//                                try {
//                                    AppraisalPerformanceActivities appraisalPerformanceActivities2 = new AppraisalPerformanceActivities();
//                                    UpdateAppraisalPerformanceActivities updateAppraisalPerformanceActivities1 = new UpdateAppraisalPerformanceActivities();
//                                    AppraisalKraActivity appraisalkraActivity = new AppraisalKraActivity();
//
//                                    appraisalPerformanceActivities2.setId(Integer.parseInt(id));
//                                    appraisalPerformanceActivities2 = appraisalPerformanceActivitiesService.readById(appraisalPerformanceActivities2.getId());
//
//                                    appraisalkraActivity.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
//                                    appraisalkraActivity.setDeletedKra(appraisalPerformanceActivities2.getKraGoalActivities());
//                                    appraisalkraActivity.setDeletedMetric(appraisalPerformanceActivities2.getMetricActivities());
//                                    appraisalkraActivity.setDeletedWeightage("");
//                                    appraisalkraActivity.setDeletedBy(employeeName);
//                                    appraisalkraActivity.setStatus("ACTIVITIES");
//                                    appraisalkraActivity.setKraDeletedDate(today);
//                                    appraisalkraActivityService.create(appraisalkraActivity);
//
//                                    updateAppraisalPerformanceActivities1.setAppraisalPerformanceActivities(appraisalPerformanceActivities2);
//                                    List updatedActivitiesList = updateAppraisalPerformanceActivitiesService.readByKraIdForDeleteActivity(updateAppraisalPerformanceActivities1);
//                                    for (Object activityObj : updatedActivitiesList) {
//                                        updateAppraisalPerformanceActivities1 = (UpdateAppraisalPerformanceActivities) activityObj;
//                                        updateAppraisalPerformanceActivitiesService.delete(updateAppraisalPerformanceActivities1.getId());
//                                    }
//                                    appraisalPerformanceActivitiesService.delete1(appraisalPerformanceActivities2);
//                                } catch (Exception e) {
//                                }
//                            }
//                        }
//                    }
//                }
            }
            //String kragoal_id = "";
            for (int i = 1; i <= countId; i++) {
                String kragoal_id = request.getParameter("kragoal_id" + i);
                appraisalPerformanceKra = new AppraisalPerformanceKra();
                if (kragoal_id != null) {
                    appraisalPerformanceKra = appraisalPerformanceKraService.readById(Integer.parseInt(kragoal_id));
                }
                String kraGoal1 = request.getParameter("kraGoal" + i);
                String metric1 = request.getParameter("metric" + i);
                String kraCategoryMap = request.getParameter("kraCategoryMap" + i);
                String weightage1 = request.getParameter("weightage" + i);

//                String finalScore = request.getParameter("finalScore" + i);
//                if (!"".equals(finalScore) && null != finalScore) {
//                    appraisalPerformanceKra.setFinalScore(finalScore);
//                } else {
//                    appraisalPerformanceKra.setFinalScore(null);
//                }
                String midYearDiv1 = request.getParameter("midYearDiv" + i);
                String endYearDiv1 = request.getParameter("endYearDiv" + i);

                //================Mid Year===================//
                String employeeMidYearSelfAssesssmentGoal = request.getParameter("employeeMidYearSelfAssesssmentGoal" + i);
                String empMidyearSelfassOtheractivty = request.getParameter("empMidyearSelfassOtheractivty");
//                String managerMidYearSelfAssesssmentGoal = request.getParameter("managerMidYearSelfAssesssmentGoal" + i);
                String managerMidyearReviewevalOtheractivity = request.getParameter("managerMidyearReviewevalOtheractivity");
                //================End Year===================//
                String employeeEndYearSelfAssesssmentGoal = request.getParameter("employeeEndYearSelfAssesssmentGoal" + i);
                String empEndyearSelfassOtheractivty = request.getParameter("empEndyearSelfassOtheractivty");
                String managerEndYearSelfAssesssmentGoal = request.getParameter("managerEndYearSelfAssesssmentGoal" + i);
                String managerEndyearReviewevalOtheractivity = request.getParameter("managerEndyearReviewevalOtheractivity");
                String startDate1 = request.getParameter("startDate" + i);
                if (!"".equals(startDate1) && null != startDate1) {
                    appraisalPerformanceKra.setStartDate(startDate1);
                } else {
                    appraisalPerformanceKra.setStartDate(null);
                }

                appraisalPerformanceKra.setKraGoal(kraGoal1);
                appraisalPerformanceKra.setMetric(metric1);
                if (null != weightage1 && !weightage1.equals("") && !weightage1.equals("null")) {
                    appraisalPerformanceKra.setWeightage(Float.parseFloat(weightage1));
                } else {
                    appraisalPerformanceKra.setWeightage(null);
                }
                if (!"".equals(kraCategoryMap) && null != kraCategoryMap) {
//                        KraCategory kraCategory = new KraCategory();
                    kraCategory.setId(Integer.parseInt(kraCategoryMap));
                    appraisalPerformanceKra.setKraCategoryByKraCategoryByEmployee(kraCategory);
                } else {
                    appraisalPerformanceKra.setKraCategoryByKraCategoryByEmployee(null);
                }

                //=======Mid year========================================//
                if (!"".equals(midYearDiv1) && null != midYearDiv1) {
                    appraisalPerformanceKra.setMidyearStatus(midYearDiv1);
                } else {
                    appraisalPerformanceKra.setMidyearStatus(null);
                }
                //=======End year========================================//
                if (!"".equals(endYearDiv1) && null != endYearDiv1) {
                    appraisalPerformanceKra.setEndyearStatus(endYearDiv1);
                } else {
                    appraisalPerformanceKra.setEndyearStatus(null);
                }
                //=======End year========================================//
                if (!"".equals(employeeMidYearSelfAssesssmentGoal) && null != employeeMidYearSelfAssesssmentGoal && flagId.equals("false")) {
                    appraisalPerformanceKra.setEmpMidyearSelfassessmentGoal(employeeMidYearSelfAssesssmentGoal);
                } else {
                    appraisalPerformanceKra.setEmpMidyearSelfassessmentGoal(null);
                }

//                if (!"".equals(managerMidYearSelfAssesssmentGoal) && null != managerMidYearSelfAssesssmentGoal && flagId.equals("false")) {
//                    appraisalPerformanceKra.setManagerMidyearReviewEvaluation(managerMidYearSelfAssesssmentGoal);
//                } else {
//                    appraisalPerformanceKra.setManagerMidyearReviewEvaluation(null);
//                }
                if (!"".equals(empMidyearSelfassOtheractivty) && null != empMidyearSelfassOtheractivty) {

                    appraisalPerformanceMaster.setEmpMidyearSelfassOtheractivty(empMidyearSelfassOtheractivty);
                    //appraisalPerformanceService.update(appraisalPerformanceMaster);
                } else {
                    appraisalPerformanceMaster.setEmpMidyearSelfassOtheractivty(null);
                }
                if (!"".equals(managerMidyearReviewevalOtheractivity) && null != managerMidyearReviewevalOtheractivity) {

                    appraisalPerformanceMaster.setManagerMidyearReviewevalOtheractivity(managerMidyearReviewevalOtheractivity);
//                        appraisalPerformanceService.update(appraisalPerformanceMaster);
                } else {
                    appraisalPerformanceMaster.setManagerMidyearReviewevalOtheractivity("");
                }

                //=======End year=======================================//
//                if (!"".equals(managerEndYearSelfAssesssmentGoal) && null != managerEndYearSelfAssesssmentGoal && flagId.equals("false") && midhalf.equals("false")) {
//                    appraisalPerformanceKra.setManagerEndyearReviewEvaluation(managerEndYearSelfAssesssmentGoal);
//                } else {
//                    appraisalPerformanceKra.setManagerEndyearReviewEvaluation(null);
//                }
                if (!"".equals(managerEndyearReviewevalOtheractivity) && null != managerEndyearReviewevalOtheractivity) {
                    appraisalPerformanceMaster.setManagerEndyearReviewevalOtheractivity(managerEndyearReviewevalOtheractivity);
                } else {
                    appraisalPerformanceMaster.setManagerEndyearReviewevalOtheractivity("");
                }
                if (!"".equals(employeeEndYearSelfAssesssmentGoal) && null != employeeEndYearSelfAssesssmentGoal && flagId.equals("false") && midhalf.equals("false")) {
                    appraisalPerformanceKra.setEmpEndyearSelfassessmentGoal(employeeEndYearSelfAssesssmentGoal);
                } else {
                    appraisalPerformanceKra.setEmpEndyearSelfassessmentGoal(null);
                }
                if (!"".equals(empEndyearSelfassOtheractivty) && null != empEndyearSelfassOtheractivty) {

                    appraisalPerformanceMaster.setEmpEndyearSelfassOtheractivty(empEndyearSelfassOtheractivty);
//                        appraisalPerformanceService.update(appraisalPerformanceMaster);
                } else {
                    appraisalPerformanceMaster.setEmpEndyearSelfassOtheractivty(null);
                }
//                String btn1 = request.getParameter("save");
                //=======End year=======================================//
//                if (null != btn1 && btn1.equals("save")) {
//                    appraisalPerformanceKra = appraisalPerformanceKraService.readById(Integer.parseInt(kragoal_id));
//                    By Ajay
                if (kragoal_id != null) {
                    appraisalPerformanceKra.setId(Integer.parseInt(kragoal_id));
                    appraisalPerformanceKraService.update(appraisalPerformanceKra);
                } else {

                    if (midhalf.equals("true")) {
                        appraisalPerformanceKra.setMidyearEmpSelfassStatus(0);
                        appraisalPerformanceKra.setMidyearManagerSelfassStatus(0);
                    }
                    if (endhalf.equals("true")) {
                        appraisalPerformanceKra.setEndyearEmpSelfassStatus(0);
                        appraisalPerformanceKra.setEndyearManagerSelfassStatus(0);
                    }
//                        appraisalPerformanceMaster.setId(Integer.parseInt(appraisalId));
                    appraisalPerformanceKra.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
                    appraisalPerformanceKraService.create(appraisalPerformanceKra);
                }
                request.setAttribute("successMessage",
                        "Information : The Information is Saved Successfully.");

//                } else {
//                    ////////////////Submit code////////////////////////////////
//
//                    appraisalPerformanceKra.setKraGoalByManager(kraGoal1);
//                    appraisalPerformanceKra.setMatrixByManager(metric1);
//                    if (null != weightage1 && !weightage1.equals("") && !weightage1.equals("null")) {
//                        appraisalPerformanceKra.setWeightageManager(Float.parseFloat(weightage1));
//                    } else {
//                        appraisalPerformanceKra.setWeightageManager(null);
//                    }
////
//                    if (!"".equals(kraCategoryMap) && null != kraCategoryMap) {
//                        kraCategory.setId(Integer.parseInt(kraCategoryMap));
//                        appraisalPerformanceKra.setKraCategoryByKraCategoryByManager(kraCategory);
//                    }
//
//                    if (!"".equals(employeeMidYearSelfAssesssmentGoal) && null != employeeMidYearSelfAssesssmentGoal && flagId.equals("false")) {
//                        appraisalPerformanceKra.setEmpMidyearSelfassessmentGoalManager(employeeMidYearSelfAssesssmentGoal);
//                    } else {
//                        appraisalPerformanceKra.setEmpMidyearSelfassessmentGoalManager(null);
//                    }
//                    if (!"".equals(employeeEndYearSelfAssesssmentGoal) && null != employeeEndYearSelfAssesssmentGoal && flagId.equals("false") && midhalf.equals("false")) {
//                        appraisalPerformanceKra.setEmpEndyearSelfassessmentGoalManager(employeeEndYearSelfAssesssmentGoal);
//                    } else {
//                        appraisalPerformanceKra.setEmpEndyearSelfassessmentGoalManager(null);
//                    }
//                    if (!"".equals(midYearDiv1) && null != midYearDiv1) {
//                        appraisalPerformanceKra.setMidyearStatusManager(midYearDiv1);
//                    } else {
//                        appraisalPerformanceKra.setMidyearStatusManager(null);
//                    }
//                    if (!"".equals(endYearDiv1) && null != endYearDiv1) {
//                        appraisalPerformanceKra.setEndyearStatusManager(endYearDiv1);
//                    } else {
//                        appraisalPerformanceKra.setEndyearStatusManager(null);
//                    }
//
////                    if (!"".equals(finalScore) && null != finalScore) {
////                        appraisalPerformanceKra.setFinalScoreManager(finalScore);
////                    } else {
////                        appraisalPerformanceKra.setFinalScoreManager(null);
////                    }
//                    ////////////////For  Manager side/////////////
//                    if (!"".equals(employeeMidYearSelfAssesssmentGoal) && null != employeeMidYearSelfAssesssmentGoal && flagId.equals("false")) {
//                        appraisalPerformanceKra.setEmpMidyearSelfassessmentGoalManager(employeeMidYearSelfAssesssmentGoal);
//                    } else {
//                        appraisalPerformanceKra.setEmpMidyearSelfassessmentGoalManager(null);
//                    }
//
////                    if (!"".equals(managerMidYearSelfAssesssmentGoal) && null != managerMidYearSelfAssesssmentGoal && flagId.equals("false")) {
////                        appraisalPerformanceKra.setManagerMidyearReviewEvaluationManager(managerMidYearSelfAssesssmentGoal);
////                    } else {
////                        appraisalPerformanceKra.setManagerMidyearReviewEvaluationManager(null);
////                    }
//                    if (!"".equals(employeeEndYearSelfAssesssmentGoal) && null != employeeEndYearSelfAssesssmentGoal && flagId.equals("false") && midhalf.equals("false")) {
//                        appraisalPerformanceKra.setEmpEndyearSelfassessmentGoalManager(employeeEndYearSelfAssesssmentGoal);
//                    } else {
//                        appraisalPerformanceKra.setEmpEndyearSelfassessmentGoalManager(null);
//                    }
////                    if (!"".equals(managerEndYearSelfAssesssmentGoal) && null != managerEndYearSelfAssesssmentGoal && flagId.equals("false") && midhalf.equals("false")) {
////                        appraisalPerformanceKra.setManagerEndyearReviewEvaluationManager(managerEndYearSelfAssesssmentGoal);
////                    } else {
////                        appraisalPerformanceKra.setManagerEndyearReviewEvaluationManager(null);
////                    }
//                    try {
//
//                        if (kragoal_id != null) {
//
//                            appraisalPerformanceKra1 = appraisalPerformanceKraService.readById(Integer.parseInt(kragoal_id));
//                            if (null != appraisalPerformanceKra1.getWeightage() && appraisalPerformanceKra1.getKraGoal().equals(appraisalPerformanceKra.getKraGoal())
//                                    && appraisalPerformanceKra1.getMetric().equals(appraisalPerformanceKra.getMetric())
//                                    && appraisalPerformanceKra1.getWeightage().equals(appraisalPerformanceKra.getWeightage())) {
//
//                            } else {
//
//                                updateAppraisalPerformanceKra.setAppraisalPerformanceKra(appraisalPerformanceKra1);
//                                updateAppraisalPerformanceKra.setUpdateDate(startdate);
//                                updateAppraisalPerformanceKra.setUpdateKra(appraisalPerformanceKra1.getKraGoal());
//                                updateAppraisalPerformanceKra.setUpdateMetric(appraisalPerformanceKra1.getMetric());
//                                updateAppraisalPerformanceKra.setName(employee.getEmployeeName());
//                                updateAppraisalPerformanceKra.setWeighted("" + appraisalPerformanceKra1.getWeightage());
//                                updateAppraisalPerformanceKraService.create(updateAppraisalPerformanceKra);
//                            }
//                        }
//                    } catch (Exception e) {
//
//                    }
//
//                    ////Match the Kra goal and update it////////
//                    /////////////////////////////////////////////////////////
//                    if (kragoal_id != null) {
//                        appraisalPerformanceKra.setId(Integer.parseInt(kragoal_id));
//                        appraisalPerformanceKraService.update(appraisalPerformanceKra);
//                    } else {
////                        appraisalPerformanceMaster.setId(Integer.parseInt(appraisalId));
//                        appraisalPerformanceKra.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
//                        appraisalPerformanceKraService.create(appraisalPerformanceKra);
//                    }
//
////                    //history code
////                    appraisalPerformanceKra1 = appraisalPerformanceKraService.readById(kragoalId);
////                    updateAppraisalPerformanceKra.setAppraisalPerformanceKra(appraisalPerformanceKra);
////                    updateAppraisalPerformanceKra.setUpdateDate(startdate);
////                    updateAppraisalPerformanceKra.setUpdateKra(kraGoal1);
////                    updateAppraisalPerformanceKra.setUpdateMetric(metric1);
////                    ////Match the Kra goal and update it////////
////                    if (appraisalPerformanceKra1.getKraGoal().equals(appraisalPerformanceKra.getKraGoal())) {
////
////                    } else {
////                        updateAppraisalPerformanceKraService.create(updateAppraisalPerformanceKra);
////
////                    }
//                    ///////    Upadte history Detail     /////////
//                    request.setAttribute("successMessage",
//                            "Information : The Information is Submit Successfully.");
//                }
            }

            ////////////////////////////////////KRA OTHER Activity///////////////////////////////////////////////////////////
            /////////////////////changes In new PMP 2017////////////////////////////////////////
            if (Integer.parseInt(year) == 2016) {

                int countActivityId = Integer.parseInt(request.getParameter("countactivityId"));
                appraisalPerformanceActivities.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
                //String kragoal_id = "";
                for (int i = 1; i <= countActivityId; i++) {

                    appraisalPerformanceActivities = new AppraisalPerformanceActivities();
                    String kragoal_activity_id = request.getParameter("kragoal_activity_id" + i);
                    if (null != kragoal_activity_id) {
                        appraisalPerformanceActivities = appraisalPerformanceActivitiesService.readById(Integer.parseInt(kragoal_activity_id));
                    }
                    String kraGoalactivity = request.getParameter("kraGoal_activity" + i);
                    String metricactivity = request.getParameter("metric_activity" + i);
                    String kraCategoryMapOther = request.getParameter("kraCategoryMapOther" + i);
                    String priority = request.getParameter("priority" + i);
                    String midYearDivOther = request.getParameter("midYearDivOther" + i);
                    String endYearDivOther = request.getParameter("endYearDivOther" + i);
                    String activity = request.getParameter("activity" + i);
                    String empMidyearSelfassessmentGoalActivities = request.getParameter("empMidyearSelfassessmentGoalActivities" + i);
                    String managerMidYearSelfAssesssmentGoalActivities = request.getParameter("managerMidYearSelfAssesssmentGoalActivities" + i);
                    String empEndyearSelfassessmentGoalActivities = request.getParameter("empEndyearSelfassessmentGoalActivities" + i);
                    String managerEndYearSelfAssesssmentGoalActivities = request.getParameter("managerEndYearSelfAssesssmentGoalActivities" + i);
                    if (null != kraGoalactivity && !kraGoalactivity.equals("")) {
                        appraisalPerformanceActivities.setKraGoalActivities(kraGoalactivity);
                    } else {
                        appraisalPerformanceActivities.setKraGoalActivities(null);
                    }
                    if (null != metricactivity && !metricactivity.equals("")) {
                        appraisalPerformanceActivities.setMetricActivities(metricactivity);
                    } else {
                        appraisalPerformanceActivities.setMetricActivities(null);
                    }
                    if (null != kraCategoryMapOther && !kraCategoryMapOther.equals("")) {
                        appraisalPerformanceActivities.setKraCategoryByEmployeeActivities(Integer.parseInt(kraCategoryMapOther));
                    } else {
                        appraisalPerformanceActivities.setKraCategoryByEmployeeActivities(null);
                    }

                    if (null != priority && !priority.equals("")) {
                        appraisalPerformanceActivities.setPriority(priority);
                    } else {
                        appraisalPerformanceActivities.setPriority(priority);
                    }

                    if (null != midYearDivOther && !midYearDivOther.equals("")) {
                        appraisalPerformanceActivities.setMidyearStatusActivities(midYearDivOther);
                    } else {
                        appraisalPerformanceActivities.setMidyearStatusActivities(null);
                    }
                    if (null != endYearDivOther && !endYearDivOther.equals("")) {
                        appraisalPerformanceActivities.setEndyearStatusActivities(endYearDivOther);
                    } else {
                        appraisalPerformanceActivities.setEndyearStatusActivities(null);
                    }
                    if (null != activity && !activity.equals("")) {
                        appraisalPerformanceActivities.setActivity(activity);
                    } else {
                        appraisalPerformanceActivities.setActivity(null);
                    }
                    if (null != empMidyearSelfassessmentGoalActivities && !empMidyearSelfassessmentGoalActivities.equals("")) {
                        appraisalPerformanceActivities.setEmpMidyearSelfassessmentGoalActivities(empMidyearSelfassessmentGoalActivities);
                    } else {
                        appraisalPerformanceActivities.setEmpMidyearSelfassessmentGoalActivities(null);
                    }
//                if (null != managerMidYearSelfAssesssmentGoalActivities && !managerMidYearSelfAssesssmentGoalActivities.equals("")) {
//                    appraisalPerformanceActivities.setManagerMidyearSelfassesssmentGoalActivities(managerMidYearSelfAssesssmentGoalActivities);
//                } else {
//                    appraisalPerformanceActivities.setManagerMidyearSelfassesssmentGoalActivities(null);
//                }
                    if (null != empEndyearSelfassessmentGoalActivities && !empEndyearSelfassessmentGoalActivities.equals("")) {
                        appraisalPerformanceActivities.setEmpEndyearSelfassessmentGoalActivities(empEndyearSelfassessmentGoalActivities);
                    } else {
                        appraisalPerformanceActivities.setEmpEndyearSelfassessmentGoalActivities(null);
                    }
//                if (null != managerEndYearSelfAssesssmentGoalActivities && !managerEndYearSelfAssesssmentGoalActivities.equals("")) {
//                    appraisalPerformanceActivities.setManagerEndyearSelfassesssmentGoalActivities(managerEndYearSelfAssesssmentGoalActivities);
//                } else {
//                    appraisalPerformanceActivities.setManagerEndyearSelfassesssmentGoalActivities(null);
//                }
//                    String btn2 = request.getParameter("save");
                    //=======End year=======================================//
//                    if (null != btn2 && btn2.equals("save")) {
                    if (null != kragoal_activity_id) {
                        //appraisalPerformanceActivities1 = appraisalPerformanceActivitiesService.readById(Integer.parseInt(kragoal_activity_id));
                        appraisalPerformanceActivities.setId(Integer.parseInt(kragoal_activity_id));
                        appraisalPerformanceActivitiesService.update(appraisalPerformanceActivities);
                    } else {
                        if (midhalf.equals("true")) {
                            appraisalPerformanceActivities.setMidyearEmpSelfassActivityStatus(0);
                            appraisalPerformanceActivities.setMidyearManagerSelfassActivityStatus(0);
                        }
                        if (endhalf.equals("true")) {
                            appraisalPerformanceActivities.setEndyearEmpSelfassActivityStatus(0);
                            appraisalPerformanceActivities.setEndyearManagerSelfassActivityStatus(0);
                        }
//                        appraisalPerformanceMaster.setId(Integer.parseInt(appraisalId));
                        appraisalPerformanceActivities.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
                        appraisalPerformanceActivitiesService.create(appraisalPerformanceActivities);
                    }
//                    } else {
//                        if (null != midYearDivOther && !midYearDivOther.equals("")) {
//                            appraisalPerformanceActivities.setMidyearStatusActivitiesManager(midYearDivOther);
//                        } else {
//                            appraisalPerformanceActivities.setMidyearStatusActivitiesManager(null);
//                        }
//                        if (null != kraGoalactivity && !kraGoalactivity.equals("")) {
//                            appraisalPerformanceActivities.setKraGoalActivitiesManager(kraGoalactivity);
//                        } else {
//                            appraisalPerformanceActivities.setKraGoalActivitiesManager(null);
//                        }
//                        if (null != metricactivity && !metricactivity.equals("")) {
//                            appraisalPerformanceActivities.setMetricActivitiesManager(metricactivity);
//                        } else {
//                            appraisalPerformanceActivities.setMetricActivitiesManager(null);
//                        }
//                        if (null != kraCategoryMapOther && !kraCategoryMapOther.equals("")) {
//                            appraisalPerformanceActivities.setKraCategoryByManagerActivities(Integer.parseInt(kraCategoryMapOther));
//                        } else {
//                            appraisalPerformanceActivities.setKraCategoryByManagerActivities(null);
//                        }
//                        if (null != priority && !priority.equals("")) {
//                            appraisalPerformanceActivities.setManagerPriority(priority);
//                        } else {
//                            appraisalPerformanceActivities.setManagerPriority(priority);
//                        }
//
//                        if (null != endYearDivOther && !endYearDivOther.equals("")) {
//                            appraisalPerformanceActivities.setEndyearStatusActivitiesManager(endYearDivOther);
//                        } else {
//                            appraisalPerformanceActivities.setEndyearStatusActivitiesManager(null);
//                        }
//
//                        if (null != activity && !activity.equals("")) {
//                            appraisalPerformanceActivities.setManagerActivity(activity);
//                        } else {
//                            appraisalPerformanceActivities.setManagerActivity(null);
//                        }
//                        if (null != empMidyearSelfassessmentGoalActivities && !empMidyearSelfassessmentGoalActivities.equals("")) {
//                            appraisalPerformanceActivities.setEmpMidyearSelfassessmentGoalActivitiesManager(empMidyearSelfassessmentGoalActivities);
//                        } else {
//                            appraisalPerformanceActivities.setEmpMidyearSelfassessmentGoalActivitiesManager(null);
//                        }
////                    if (null != managerMidYearSelfAssesssmentGoalActivities && !managerMidYearSelfAssesssmentGoalActivities.equals("")) {
////                        appraisalPerformanceActivities.setManagerMidyearSelfassesssmentGoalActivitiesManager(managerMidYearSelfAssesssmentGoalActivities);
////                    } else {
////                        appraisalPerformanceActivities.setManagerMidyearSelfassesssmentGoalActivitiesManager(null);
////                    }
//                        if (null != empEndyearSelfassessmentGoalActivities && !empEndyearSelfassessmentGoalActivities.equals("")) {
//                            appraisalPerformanceActivities.setEmpEndyearSelfassessmentGoalActivitiesManager(empEndyearSelfassessmentGoalActivities);
//                        } else {
//                            appraisalPerformanceActivities.setEmpEndyearSelfassessmentGoalActivitiesManager(null);
//                        }
////                    if (null != managerEndYearSelfAssesssmentGoalActivities && !managerEndYearSelfAssesssmentGoalActivities.equals("")) {
////                        appraisalPerformanceActivities.setManagerEndyearSelfassesssmentGoalActivitiesManager(managerEndYearSelfAssesssmentGoalActivities);
////                    } else {
////                        appraisalPerformanceActivities.setManagerEndyearSelfassesssmentGoalActivitiesManager(null);
////                    }
//                        try {
//
//                            if (null != kragoal_activity_id) {
//
//                                appraisalPerformanceActivities1 = appraisalPerformanceActivitiesService.readById(Integer.parseInt(kragoal_activity_id));
//                                if (null != appraisalPerformanceActivities1.getKraGoalActivities()) {
//
//                                    if (appraisalPerformanceActivities1.getKraGoalActivities().equals(appraisalPerformanceActivities.getKraGoalActivities())
//                                            && appraisalPerformanceActivities1.getMetricActivities().equals(appraisalPerformanceActivities1.getMetricActivities())) {
//
//                                    } else {
//                                        updateAppraisalPerformanceActivities.setAppraisalPerformanceActivities(appraisalPerformanceActivities1);
//                                        updateAppraisalPerformanceActivities.setKraActivity(appraisalPerformanceActivities1.getKraGoalActivities());
//                                        updateAppraisalPerformanceActivities.setMetricActivity(appraisalPerformanceActivities1.getMetricActivities());
//                                        updateAppraisalPerformanceActivities.setUpdateDate(startdate);
//                                        updateAppraisalPerformanceActivities.setChangedBy(employee.getEmployeeName());
//                                        updateAppraisalPerformanceActivitiesService.create(updateAppraisalPerformanceActivities);
//                                    }
//                                }
//                            }
//                        } catch (Exception e) {
//
//                        }
//
//                        if (null != kragoal_activity_id) {
//                            appraisalPerformanceActivities.setId(Integer.parseInt(kragoal_activity_id));
//                            appraisalPerformanceActivitiesService.update(appraisalPerformanceActivities);
//                        } else {
////                        appraisalPerformanceMaster.setId(Integer.parseInt(appraisalId));
//                            appraisalPerformanceActivities.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
//                            appraisalPerformanceActivitiesService.create(appraisalPerformanceActivities);
//                        }
//                    }
                }
            }
            /////////////////////changes In new PMP 2017////////////////////////////////////////
//                if (!"".equals(kraGoalactivity) && null != kraGoalactivity) {
//                    if (null != kragoal_activity_id) {
//                        appraisalPerformanceActivities1 = appraisalPerformanceActivitiesService.readById(Integer.parseInt(kragoal_activity_id));
//                        appraisalPerformanceActivities.setId(Integer.parseInt(kragoal_activity_id));
//                        appraisalPerformanceActivitiesService.update(appraisalPerformanceActivities);
//
////                        updateAppraisalPerformanceActivities.setAppraisalPerformanceActivities(appraisalPerformanceActivities);
////                        updateAppraisalPerformanceActivities.setKraActivity(kraGoalactivity);
////                        updateAppraisalPerformanceActivities.setMetricActivity(metricactivity);
////                        updateAppraisalPerformanceActivities.setUpdateDate(startdate);
////                        if (appraisalPerformanceActivities1.getKraGoalActivities().equals(appraisalPerformanceActivities.getKraGoalActivities())) {
////
////                        } else {
//////                            updateAppraisalPerformanceActivitiesService.create(updateAppraisalPerformanceActivities);
////
////                        }
//                    } else {
//                        appraisalPerformanceActivitiesService.create(appraisalPerformanceActivities);
//                        ////////////history code//////////////////
////                        updateAppraisalPerformanceActivities.setAppraisalPerformanceActivities(appraisalPerformanceActivities);
////                        updateAppraisalPerformanceActivities.setKraActivity(activity);
////                        updateAppraisalPerformanceActivities.setMetricActivity(metricactivity);
////                        updateAppraisalPerformanceActivities.setUpdateDate(startdate);
////                        updateAppraisalPerformanceActivitiesService.create(updateAppraisalPerformanceActivities);
//                    }
            //}
            ////////////////////////////////////KRA OTHER Activity//////////////////////////////////////////////////////////
            ///////////////////Competency Evaluation (As Per Zydex Competency Framework)////////////////////////////

            ////////////////////////////////////KRA OTHER Activity  Closed//////////////////////////////////////////////////////////
            ///////////////////Competency Evaluation (As Per Zydex Competency Framework) change by date 11/11/2016////////////////////////////
//            AppraisalPerformanceCompetencyEvaluation appraisalPerformanceCompetencyEvaluation = new AppraisalPerformanceCompetencyEvaluation();
//            CompetencyEvaluationTextmaster competencyEvaluationTextmaster = new CompetencyEvaluationTextmaster();
//            CompetencyEvaluationMaster competencyEvaluationMaster = new CompetencyEvaluationMaster();
//            int subCompentencyCount = Integer.parseInt(request.getParameter("subCompentencyCount"));
//            boolean flag = true;
//            for (int i = 1; i <= subCompentencyCount; i++) {
//                String competencyEveId = request.getParameter("competencyEveId" + i);
//                if (competencyEveId != null) {
//                    appraisalPerformanceCompetencyEvaluation = appraisalPerformanceCompetencyEvaluationService.readById(Integer.parseInt(competencyEveId));
//                }
//                String compentencyStartYear = request.getParameter("compentencyStartYear" + i);
//                String compentencyStartRemark = request.getParameter("compentencyStartRemark" + i);
//                String compentencyMidYear = request.getParameter("compentencyMidYear" + i);
//                String compentencyMidRemark = request.getParameter("compentencyMidRemark" + i);
//                String compentencyEndYear = request.getParameter("compentencyEndYear" + i);
//                String compentencyEndRemark = request.getParameter("compentencyEndRemark" + i);
//                if (!"".equals(compentencyStartYear) && null != compentencyStartYear) {
//                    appraisalPerformanceCompetencyEvaluation.setCompetencyStartYear(compentencyStartYear);
//                } else {
//                    appraisalPerformanceCompetencyEvaluation.setCompetencyStartYear(null);
//                }
//                if (!"".equals(compentencyStartRemark) && null != compentencyStartRemark) {
//                    appraisalPerformanceCompetencyEvaluation.setStartyearRemark(compentencyStartRemark);
//                } else {
//                    appraisalPerformanceCompetencyEvaluation.setStartyearRemark(null);
//                }
//                if (!"".equals(compentencyMidYear) && null != compentencyMidYear) {
//                    appraisalPerformanceCompetencyEvaluation.setCompetencyMidYear(compentencyMidYear);
//                } else {
//                    appraisalPerformanceCompetencyEvaluation.setCompetencyMidYear(null);
//                }
//                if (!"".equals(compentencyMidRemark) && null != compentencyMidRemark) {
//                    appraisalPerformanceCompetencyEvaluation.setMidyearRemark(compentencyMidRemark);
//                } else {
//                    appraisalPerformanceCompetencyEvaluation.setMidyearRemark(null);
//                }
//                if (!"".equals(compentencyEndYear) && null != compentencyEndYear) {
//                    appraisalPerformanceCompetencyEvaluation.setCompetencyEndYear(compentencyEndYear);
//                } else {
//                    appraisalPerformanceCompetencyEvaluation.setCompetencyEndYear(null);
//                }
//                if (!"".equals(compentencyEndRemark) && null != compentencyEndRemark) {
//                    appraisalPerformanceCompetencyEvaluation.setEndyearRemark(compentencyEndRemark);
//                } else {
//                    appraisalPerformanceCompetencyEvaluation.setCompetencyEndYear(null);
//                }
//
////
//                appraisalPerformanceCompetencyEvaluation.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
//                int compentencyTextMasterId = Integer.parseInt(request.getParameter("compentencyTextMasterId" + i));
//                competencyEvaluationTextmaster.setId(compentencyTextMasterId);
////                competencyEvaluationMaster.setId(competencyEvaluationId);
////                appraisalPerformanceCompetencyEvaluation.setCompetencyEvaluationMaster(competencyEvaluationMaster);
//                appraisalPerformanceCompetencyEvaluation.setCompetencyEvaluationTextmaster(competencyEvaluationTextmaster);
////                String competencyEveId = request.getParameter("competencyEveId" + i);
//                String btn2 = request.getParameter("save");
//
//                if (null != btn2 && btn2.equals("save")) {
//                    if (!"".equals(competencyEveId) && null != competencyEveId) {
//                        int competencyEvaluationId = Integer.parseInt(request.getParameter("competencyEvaluationId" + i));
//                        competencyEvaluationMaster.setId(competencyEvaluationId);
//                        appraisalPerformanceCompetencyEvaluation.setCompetencyEvaluationMaster(competencyEvaluationMaster);
//                        appraisalPerformanceCompetencyEvaluation.setId(Integer.parseInt(competencyEveId));
////                        appraisalPerformanceCompetencyEvaluation.setEmployeeStatus(1);
//                        appraisalPerformanceCompetencyEvaluationService.update(appraisalPerformanceCompetencyEvaluation);
//
//                    } else {
////                        if (!appraisalId.isEmpty()) {
////                            if (flag) {
////                                for (String id : appraisalId.split(",")) {
////                                    if (!id.equals("")) {
////                                        AppraisalPerformanceCompetencyEvaluation appraisalPerformanceCompetencyEvaluation2 = new AppraisalPerformanceCompetencyEvaluation();
////                                        AppraisalPerformanceCompetencyEvaluationHistory appraisalPerformanceCompetencyEvaluationHistory = new AppraisalPerformanceCompetencyEvaluationHistory();
////                                        appraisalPerformanceCompetencyEvaluation2.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
////
////                                        try {
////
////                                            List<AppraisalPerformanceCompetencyEvaluation> competencyList = (List<AppraisalPerformanceCompetencyEvaluation>) appraisalPerformanceCompetencyEvaluationService.readByAppraisalPerformanceId(appraisalPerformanceCompetencyEvaluation2);
////
////                                            for (AppraisalPerformanceCompetencyEvaluation appraisalPerformanceCompetencyEvaluation1 : competencyList) {
////
////                                                BeanUtils.copyProperties(appraisalPerformanceCompetencyEvaluation1, appraisalPerformanceCompetencyEvaluationHistory);
////                                                appraisalPerformanceCompetencyEvaluationHistory.setAppraisalPerformanceId(appraisalPerformanceCompetencyEvaluation1.getAppraisalPerformanceMaster().getId());
////                                                appraisalPerformanceCompetencyEvaluationHistory.setCompetencyEvaluationId(appraisalPerformanceCompetencyEvaluation1.getCompetencyEvaluationMaster().getId());
////                                                appraisalPerformanceCompetencyEvaluationHistory.setCompetencyEvaluationTextId(appraisalPerformanceCompetencyEvaluation1.getCompetencyEvaluationTextmaster().getId());
//////                                            appraisalPerformanceCompetencyEvaluationHistory.setDateStr(startdate);
////                                                appraisalPerformanceCompetencyEvaluationHistory.setDateStr(strDate);
////                                                appraisalPerformanceCompetencyEvaluationHistory.setDeletedBy("Employee Side");
////                                                appraisalPerformanceCompetencyEvaluationHistory.setId(0);
////                                                appraisalPerformanceCompetencyEvaluationHistoryService.create(appraisalPerformanceCompetencyEvaluationHistory);
////                                            }
////                                        } catch (Exception e) {
////                                            e.printStackTrace();
////                                        }
////
////                                        appraisalPerformanceCompetencyEvaluationService.delete1(appraisalPerformanceCompetencyEvaluation2);
////                                        flag = false;
////                                    }
////                                }
////                            }
////                        }
//                        String competencyEvaluationId = request.getParameter("competencyEvaluationId");
//                        if (!"".equals(competencyEvaluationId) && null != competencyEvaluationId) {
//                            int competencyEvaluation_Id = Integer.parseInt(competencyEvaluationId);
//                            competencyEvaluationMaster.setId(competencyEvaluation_Id);
//                            appraisalPerformanceCompetencyEvaluation.setCompetencyEvaluationMaster(competencyEvaluationMaster);
////                            appraisalPerformanceCompetencyEvaluation.setEmployeeStatus(1);
//                            appraisalPerformanceCompetencyEvaluationService.create(appraisalPerformanceCompetencyEvaluation);
//                        }
//                    }
//                } else {
//
//                    /////////manager StartYearManager///////////////////////////////
//                    if (!"".equals(compentencyStartYear) && null != compentencyStartYear) {
//                        appraisalPerformanceCompetencyEvaluation.setCompetencyStartYearManager(compentencyStartYear);
//                    } else {
//                        appraisalPerformanceCompetencyEvaluation.setCompetencyStartYearManager(null);
//                    }
//                    if (!"".equals(compentencyStartRemark) && null != compentencyStartRemark) {
//                        appraisalPerformanceCompetencyEvaluation.setStartyearRemarkManager(compentencyStartRemark);
//                    } else {
//                        appraisalPerformanceCompetencyEvaluation.setStartyearRemarkManager(null);
//                    }
//                    if (!"".equals(compentencyMidYear) && null != compentencyMidYear) {
//                        appraisalPerformanceCompetencyEvaluation.setCompetencyMidYearManager(compentencyMidYear);
//                    } else {
//                        appraisalPerformanceCompetencyEvaluation.setCompetencyMidYearManager(null);
//                    }
//                    if (!"".equals(compentencyMidRemark) && null != compentencyMidRemark) {
//                        appraisalPerformanceCompetencyEvaluation.setMidyearRemarkManager(compentencyMidRemark);
//                    } else {
//                        appraisalPerformanceCompetencyEvaluation.setMidyearRemarkManager(null);
//                    }
//                    if (!"".equals(compentencyEndYear) && null != compentencyEndYear) {
//                        appraisalPerformanceCompetencyEvaluation.setCompetencyEndYearManager(compentencyEndYear);
//                    } else {
//                        appraisalPerformanceCompetencyEvaluation.setCompetencyEndYearManager(null);
//                    }
//                    if (!"".equals(compentencyEndRemark) && null != compentencyEndRemark) {
//                        appraisalPerformanceCompetencyEvaluation.setEndyearRemarkManager(compentencyEndRemark);
//                    } else {
//                        appraisalPerformanceCompetencyEvaluation.setCompetencyEndYearManager(null);
//                    }
//                    if (!"".equals(competencyEveId) && null != competencyEveId) {
//                        int competencyEvaluationId = Integer.parseInt(request.getParameter("competencyEvaluationId" + i));
//                        competencyEvaluationMaster.setId(competencyEvaluationId);
//                        appraisalPerformanceCompetencyEvaluation.setCompetencyEvaluationMaster(competencyEvaluationMaster);
//                        appraisalPerformanceCompetencyEvaluation.setId(Integer.parseInt(competencyEveId));
////                        appraisalPerformanceCompetencyEvaluation.setEmployeeStatus(1);
//                        appraisalPerformanceCompetencyEvaluationService.update(appraisalPerformanceCompetencyEvaluation);
//
//                    } else {
////                        if (!appraisalId.isEmpty()) {
////                            if (flag) {
////                                for (String id : appraisalId.split(",")) {
////                                    if (!id.equals("")) {
////                                        AppraisalPerformanceCompetencyEvaluation appraisalPerformanceCompetencyEvaluation2 = new AppraisalPerformanceCompetencyEvaluation();
////                                        appraisalPerformanceCompetencyEvaluation2.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
////                                        appraisalPerformanceCompetencyEvaluationService.delete1(appraisalPerformanceCompetencyEvaluation2);
////                                        flag = false;
////                                    }
////                                }
////                            }
////                        }
//                        String competencyEvaluationId = request.getParameter("competencyEvaluationId");
//                        if (!"".equals(competencyEvaluationId) && null != competencyEvaluationId) {
//                            int competencyEvaluation_Id = Integer.parseInt(competencyEvaluationId);
//                            competencyEvaluationMaster.setId(competencyEvaluation_Id);
//                            appraisalPerformanceCompetencyEvaluation.setCompetencyEvaluationMaster(competencyEvaluationMaster);
////                            appraisalPerformanceCompetencyEvaluation.setEmployeeStatus(1);
//                            appraisalPerformanceCompetencyEvaluationService.create(appraisalPerformanceCompetencyEvaluation);
//                        }
//                    }
//                }
//            }
//
            ///////////////////////////Individual Development Plan//////////////////////////////////
///////////////////////////Individual Development Plan change date 11/11/2016//////////////////////////////////
//            AppraisalPerformanceIndividualDevelopmentPlan appraisalPerformanceIndividualDevelopmentPlan = new AppraisalPerformanceIndividualDevelopmentPlan();
//            int individualcount = Integer.parseInt(request.getParameter("IndividualId"));
//            for (int i = 1; i <= individualcount; i++) {
//                String individualplan = request.getParameter("IndividualDevelopmentPlanId" + i);
//                if (null != individualplan) {
//
//                    appraisalPerformanceIndividualDevelopmentPlan = appraisalPerformanceIndividualDevelopmentPlanService.readById(Integer.parseInt(individualplan));
//                }
//                String text1 = request.getParameter("text" + i);
//                String text2 = request.getParameter("individualtextDiv" + i);
//                String text3 = request.getParameter("trainingSelectId" + i);
//                String remark = request.getParameter("trainingSelectTextinput" + i);
//                String midYearRemark = request.getParameter("midYearRemark" + i);
//                String endYearRemark = request.getParameter("endYearRemark" + i);
//                String managerMidYearRemark = request.getParameter("managerMidYearRemark" + i);
//                String managerEndYearRemark = request.getParameter("managerEndYearRemark" + i);
//                if (!"".equals(text1) && null != text1) {
//                    appraisalPerformanceIndividualDevelopmentPlan.setText1(text1);
//                } else {
//                    appraisalPerformanceIndividualDevelopmentPlan.setText1(null);
//                }
//
//                if (!"".equals(text2) && null != text2) {
//                    appraisalPerformanceIndividualDevelopmentPlan.setText2(text2);
//                } else {
//                    appraisalPerformanceIndividualDevelopmentPlan.setText2(null);
//                }
////                if (!"".equals(text2) && null != text2) {
////                    appraisalPerformanceIndividualDevelopmentPlan.setManagertext2(text2);
////                } else {
////                    appraisalPerformanceIndividualDevelopmentPlan.setManagertext2(null);
////                }
//                if (!"".equals(text3) && null != text3) {
//                    appraisalPerformanceIndividualDevelopmentPlan.setText3(text3);
//                } else {
//                    appraisalPerformanceIndividualDevelopmentPlan.setText3(null);
//                }
////                if (!"".equals(text3) && null != text3) {
////                    appraisalPerformanceIndividualDevelopmentPlan.setManagertext3(text3);
////                } else {
////                    appraisalPerformanceIndividualDevelopmentPlan.setManagertext3(null);
////                }
//                if (!"".equals(remark) && null != remark) {
//                    appraisalPerformanceIndividualDevelopmentPlan.setRemark(remark);
//                } else {
//                    appraisalPerformanceIndividualDevelopmentPlan.setRemark(null);
//                }
//                if (!"".equals(midYearRemark) && null != midYearRemark) {
//                    appraisalPerformanceIndividualDevelopmentPlan.setMidYearRemark(midYearRemark);
//                } else {
//                    appraisalPerformanceIndividualDevelopmentPlan.setMidYearRemark(null);
//                }
//                if (!"".equals(endYearRemark) && null != endYearRemark) {
//                    appraisalPerformanceIndividualDevelopmentPlan.setEndYearRemark(endYearRemark);
//                } else {
//                    appraisalPerformanceIndividualDevelopmentPlan.setEndYearRemark(null);
//                }
//
//                String btn4 = request.getParameter("save");
//                if (null != btn4 && btn4.equals("save")) {
//
//                    if (individualplan != null) {
//                        appraisalPerformanceIndividualDevelopmentPlan.setId(Integer.parseInt(individualplan));
//                        appraisalPerformanceIndividualDevelopmentPlanService.update(appraisalPerformanceIndividualDevelopmentPlan);
//                    } else {
//                        appraisalPerformanceIndividualDevelopmentPlan.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
//                        appraisalPerformanceIndividualDevelopmentPlanService.create(appraisalPerformanceIndividualDevelopmentPlan);
//                    }
//                    request.setAttribute("successMessage",
//                            "Information : The Information is Saved Successfully.");
//                } else {
//
//                    if (null != text1 && !"".equals(text1)) {
//                        appraisalPerformanceIndividualDevelopmentPlan.setManagertext1(text1);
//                    } else {
//                        appraisalPerformanceIndividualDevelopmentPlan.setManagertext1(null);
//                    }
//                    if (null != text2 && !"".equals(text2)) {
//                        appraisalPerformanceIndividualDevelopmentPlan.setManagertext2(text2);
//                    } else {
//                        appraisalPerformanceIndividualDevelopmentPlan.setManagertext2(null);
//                    }
//                    if (null != text3 && !"".equals(text3)) {
//                        appraisalPerformanceIndividualDevelopmentPlan.setManagertext3(text3);
//                    } else {
//                        appraisalPerformanceIndividualDevelopmentPlan.setManagertext3(null);
//                    }
//                    if (null != managerMidYearRemark && !"".equals(managerMidYearRemark)) {
//                        appraisalPerformanceIndividualDevelopmentPlan.setManagerMidYearRemark(managerMidYearRemark);
//                    } else {
//                        appraisalPerformanceIndividualDevelopmentPlan.setManagerMidYearRemark(null);
//                    }
//
//                    if (null != remark && !"".equals(remark)) {
//                        appraisalPerformanceIndividualDevelopmentPlan.setManagerremark(remark);
//                    } else {
//                        appraisalPerformanceIndividualDevelopmentPlan.setManagerremark(null);
//                    }
//                    if (null != endYearRemark && !"".equals(endYearRemark)) {
//                        appraisalPerformanceIndividualDevelopmentPlan.setManagerEndYearRemarkEmployee(endYearRemark);
//                    } else {
//                        appraisalPerformanceIndividualDevelopmentPlan.setManagerEndYearRemarkEmployee(null);
//                    }
//
//                    if (null != managerEndYearRemark && !"".equals(managerEndYearRemark)) {
//                        appraisalPerformanceIndividualDevelopmentPlan.setManagerEndYearRemark(managerEndYearRemark);
//                    } else {
//                        appraisalPerformanceIndividualDevelopmentPlan.setManagerEndYearRemark(null);
//                    }
//                    if (null != managerEndYearRemark && !"".equals(managerEndYearRemark)) {
//                        appraisalPerformanceIndividualDevelopmentPlan.setManagerEndYearRemarkManager(managerEndYearRemark);
//                    } else {
//                        appraisalPerformanceIndividualDevelopmentPlan.setManagerEndYearRemarkManager(null);
//                    }
////                    Mid year for Manager side //
//                    if (null != midYearRemark && !"".equals(midYearRemark)) {
//                        appraisalPerformanceIndividualDevelopmentPlan.setManagerMidYearRemarkManager(midYearRemark);
//                    } else {
//                        appraisalPerformanceIndividualDevelopmentPlan.setManagerMidYearRemarkManager(null);
//                    }
//                    if (null != managerEndYearRemark && !"".equals(managerEndYearRemark)) {
//                        appraisalPerformanceIndividualDevelopmentPlan.setManagerEndYearRemarkManager(managerEndYearRemark);
//                    } else {
//                        appraisalPerformanceIndividualDevelopmentPlan.setManagerEndYearRemarkManager(null);
//                    }
//
//                    if (individualplan != null) {
//                        appraisalPerformanceIndividualDevelopmentPlan.setId(Integer.parseInt(individualplan));
//                        appraisalPerformanceIndividualDevelopmentPlanService.update(appraisalPerformanceIndividualDevelopmentPlan);
//                    } else {
//                        appraisalPerformanceIndividualDevelopmentPlan.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
//                        appraisalPerformanceIndividualDevelopmentPlanService.create(appraisalPerformanceIndividualDevelopmentPlan);
//                    }
//                    request.setAttribute("successMessage",
//                            "Information : The Information is Submit Successfully.");
//                }
//            }
//
            //////////Behaviors///////////////
//            AppraisalPerformanceBehaviors appraisalPerformanceBehaviors = new AppraisalPerformanceBehaviors();
//
//            for (int i = 1; i <= 5; i++) {
//
//                String behaviors = request.getParameter("w" + i);
//                String midYearScore = request.getParameter("midYearScore" + i);
//                String endYearScore = request.getParameter("endYearScore" + i);
//                String managerMidYearReview = request.getParameter("managerMidYearReview" + i);
//                String managerEndYearReview = request.getParameter("managerEndYearReview" + i);
//                if (!"".equals(behaviors) && null != behaviors) {
//                    appraisalPerformanceBehaviors.setBehaviors(behaviors);
//                } else {
//                    appraisalPerformanceBehaviors.setBehaviors(null);
//                }
//                if (!"".equals(midYearScore) && null != midYearScore) {
//                    appraisalPerformanceBehaviors.setMidYearScore(Float.parseFloat(midYearScore));
//                } else {
//                    appraisalPerformanceBehaviors.setMidYearScore(null);
//                }
//                if (!"".equals(endYearScore) && null != endYearScore) {
//                    appraisalPerformanceBehaviors.setEndYearScore(Float.parseFloat(endYearScore));
//                } else {
//                    appraisalPerformanceBehaviors.setEndYearScore(null);
//                }
//                if (!"".equals(managerMidYearReview) && null != managerMidYearReview) {
//                    appraisalPerformanceBehaviors.setManagerMidYearReview(managerMidYearReview);
//                } else {
//                    appraisalPerformanceBehaviors.setManagerMidYearReview(null);
//                }
//                if (!"".equals(managerEndYearReview) && null != managerEndYearReview) {
//                    appraisalPerformanceBehaviors.setManagerEndYearReview(managerEndYearReview);
//                } else {
//                    appraisalPerformanceBehaviors.setManagerEndYearReview(null);
//                }
//                appraisalPerformanceBehaviors.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
//                appraisalPerformanceBehaviorsService.create(appraisalPerformanceBehaviors);
//            }
        }
//        String btn1 = request.getParameter("save");
//        if (null != btn1 && btn1.equals("save")) {
//            String year = request.getParameter("yearparmStr");
//            mv.setViewName("redirect:appraisalPerformance.htm?act=editClick1&id=" + employee.getId() + "&userid=" + employee.getUserMaster().getId() + "&appraisalId=" + appraisalId + "&year=" + year);
//        } else {
//            mv.getModelMap().put("appraisalPerformanceMaster", appraisalPerformanceMaster);
////        mv.setViewName("forward:userMaster.htm?act=userDashboard");
////        mv = createClick(request, response);
//            mv.setViewName("redirect:appraisalPerformance.htm?act=searchOwnappraisalPerformanceSubmit");
////        mv = searchOwnappraisalPerformanceSubmit(request, response);
////        mv.setViewName("Appraisal/PerformanceAppraisalForm");
//        }
//        return mv;
    }

    public ModelAndView searchClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AppraisalPerformanceMaster appraisalPerformanceMaster = new AppraisalPerformanceMaster();
//        List<?> employeeMasterList = employeeMasterService.read();
        //EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        //selectEmployee(request, response);
        //department(request, response);
        //competencyList(request);
        //List<?> l1 = appraisalFillingDataService.getCurrentAndPreviousYear();
//        String previousYear = "";
//        int currentYear = 0;
//        if (!l1.isEmpty()) {
//            Object[] obj = (Object[]) l1.get(0);
//            previousYear = "" + obj[0];
//
//        }
        yearList(request);
        pmpyearList(request);
        //mv.getModelMap().put("list", l1);
        mv.getModelMap().put("appraisalPerformanceMaster", appraisalPerformanceMaster);
        mv.setViewName("Appraisal/AppraisalPerformanceSearchClick");
        return mv;
    }

    public ModelAndView searchSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AppraisalPerformanceMaster appraisalPerformanceMaster = new AppraisalPerformanceMaster();
//        List<?> employeeMasterList = employeeMasterService.read();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        String year1 = request.getParameter("pmpyear");
        if (null == year1) {
            Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);
            year1 = "" + year;
        }
        UserMaster user = (UserMaster) request.getSession().getAttribute("user");
        UserRightMaster user1 = (UserRightMaster) request.getSession().getAttribute("userRight");

        List<List<?>> finalAppraisalPerformanceList1 = new LinkedList<List<?>>();
        boolean hr = user1.isHr();
        //request.setAttribute("hr", hr);
//        List<?> appraisalPerformanceList = appraisalPerformanceService.readEmployeesAppraisalPerformance(employeeMaster, hr);
        List appraisalPerformanceList = appraisalPerformanceService.readEmployeesAppraisalPerformance(employeeMaster, hr, Integer.parseInt(year1));
        AppraisalPerformanceKra appraisalPerformanceKra = new AppraisalPerformanceKra();
        int year = Calendar.getInstance().get(Calendar.YEAR);
        String goalSetting = "Pendding";
        String goalApproval = "";
        String midSelfApproval = "";
        String managerMidSelfApproval = "";
        String endSelfApproval = "";
        String managerEndSelfApproval = "";
        int ManagerStatus = 0;
        int i = 0;
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date currentDate = dateFormat.parse(dateFormat.format(new Date()));

        if (null != appraisalPerformanceList && !appraisalPerformanceList.isEmpty()) {
//            List appraisalFillingDataList1 = appraisalFillingDataService.readByCurrentYear("" + year1);
            ////uper line commit by nishant

            ///// Nishant
            List appraisalFillingDataList1 = appraisalFillingDataService.readByIdNew(Integer.parseInt(year1));
//            List appraisalFillingDataList1 = appraisalFillingDataService.getappraisalDate();
//            if (!appraisalFillingDataList1.isEmpty()) {

            AppraisalFillingData appraisalFillingData1 = (AppraisalFillingData) appraisalFillingDataList1.get(0);
//                        Date currentDate = new Date();
//

            // Middel year employee
//            Date ManagerStartDate1 = dateFormat.parse(appraisalFillingData1.getManagerStartDate());
//            Date ManagerEndDate1 = dateFormat.parse(appraisalFillingData1.getManagerEndDate());
            //Mid Year Dates Manager
//            Date ManagerMidStartDate1 = dateFormat.parse(appraisalFillingData1.getManagerMidYearStartDate());
//            Date ManagerMidDate1 = dateFormat.parse(appraisalFillingData1.getManagerMidYearEndDate());
            //End Year Dates Manager
//            Date managerYearEndStartDate1 = dateFormat.parse(appraisalFillingData1.getManagerYearEndStartDate());
//            Date managerYearEndEndDate1 = dateFormat.parse(appraisalFillingData1.getManagerYearEndEndDate());
//            }
            for (Object o1 : appraisalPerformanceList) {

                Object o11[] = (Object[]) o1;

                String aa = o11[0].toString();
                appraisalPerformanceMaster = appraisalPerformanceService.readById(Integer.parseInt(aa));
                if (!appraisalPerformanceMaster.equals("")) {
                    ManagerStatus = appraisalPerformanceMaster.getManagerStatus();
                }
//            }
                appraisalPerformanceKra.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
                List list = appraisalPerformanceKraService.readByAppraisalPerformancekraId(appraisalPerformanceKra);
                for (Object o : list) {
                    goalSetting = "Pendding";

                    AppraisalPerformanceKra appraisalPerformanceKra1 = (AppraisalPerformanceKra) o;

                    if (appraisalPerformanceKra1.getKraGoal() != null && appraisalPerformanceKra1.getMetric() != null) {
                        goalSetting = "Approved";
                        break;
                    }
                }
                for (Object o2 : list) {
                    goalApproval = "";
                    AppraisalPerformanceKra appraisalPerformanceKra1 = (AppraisalPerformanceKra) o2;
//                    if (currentDate.equals(ManagerStartDate1) || currentDate.equals(ManagerEndDate1)
//                            || (currentDate.after(ManagerStartDate1) && currentDate.before(ManagerEndDate1))) {
//                        if (appraisalPerformanceMaster.getReworkStatus() == 1) {
//                            goalApproval = "Rework";
//                            //goalApproval = "pending";
//                            goalSetting = "Pendding";
//                            break;
//                        }
//                    }
                    if (appraisalPerformanceKra1.getWeightage() != null && ManagerStatus == 1) {
                        goalApproval = "Approved";
                        break;
                    } else if (appraisalPerformanceMaster.getReworkStatus() == 1) {
                        goalApproval = "Rework";
                        break;
                    }
                }
                for (Object o3 : list) {

                    midSelfApproval = "";
                    AppraisalPerformanceKra appraisalPerformanceKra1 = (AppraisalPerformanceKra) o3;
                    if (appraisalPerformanceKra1.getEmpMidyearSelfassessmentGoal() != null && !"".equals(appraisalPerformanceKra1.getEmpMidyearSelfassessmentGoal()) && 0 != appraisalPerformanceMaster.getMidYearEmployeeStatus()) {
                        midSelfApproval = "Approved";
                        break;
                    }
                }
                for (Object o4 : list) {
                    managerMidSelfApproval = "";
                    AppraisalPerformanceKra appraisalPerformanceKra1 = (AppraisalPerformanceKra) o4;
//                    if (currentDate.equals(ManagerMidStartDate1) || currentDate.equals(ManagerMidDate1)
//                            || (currentDate.after(ManagerMidStartDate1) && currentDate.before(ManagerMidDate1))) {
////                        if (appraisalPerformanceMaster.getReworkStatus() == 1 && 0 != appraisalPerformanceMaster.getMidYearManagerStatus()) {
//                        if (appraisalPerformanceMaster.getReworkStatus() == 1) {
//                            managerMidSelfApproval = "Rework";
//                            midSelfApproval = "Pendding";
//                            break;
//                        }
//                    }
                    if (appraisalPerformanceKra1.getManagerMidyearReviewEvaluation() != null && 0 != appraisalPerformanceMaster.getMidYearManagerStatus()) {
                        managerMidSelfApproval = "Approved";
                        break;
                    } else if (appraisalPerformanceMaster.getReworkStatus() == 1 && 0 != appraisalPerformanceMaster.getMidYearManagerStatus()) {
                        managerMidSelfApproval = "Rework";
                        break;
                    }
                }
                for (Object o5 : list) {
                    endSelfApproval = "";
                    AppraisalPerformanceKra appraisalPerformanceKra1 = (AppraisalPerformanceKra) o5;
                    if (appraisalPerformanceKra1.getEmpEndyearSelfassessmentGoal() != null && 0 != appraisalPerformanceMaster.getEndYearEmployeeStatus()) {
                        endSelfApproval = "Approved";
                        break;
                    }
                }
                for (Object o6 : list) {
                    managerEndSelfApproval = "";
                    AppraisalPerformanceKra appraisalPerformanceKra1 = (AppraisalPerformanceKra) o6;
//                    if (currentDate.equals(managerYearEndStartDate1) || currentDate.equals(managerYearEndEndDate1)
//                            || (currentDate.after(managerYearEndStartDate1) && currentDate.before(managerYearEndEndDate1))) {
//                        if (appraisalPerformanceMaster.getReworkStatus() == 1 && 0 != appraisalPerformanceMaster.getEndYearManagerStatus()) {
                    if (appraisalPerformanceMaster.getReworkStatus() == 1) {
                        managerEndSelfApproval = "Rework";
                        endSelfApproval = "Pendding";
                        break;
                    }
//                    }
                    if (appraisalPerformanceKra1.getManagerEndyearReviewEvaluation() != null && 0 != appraisalPerformanceMaster.getEndYearManagerStatus()) {
                        managerEndSelfApproval = "Approved";
                        break;
                    } else if (appraisalPerformanceMaster.getReworkStatus() == 1 && 0 != appraisalPerformanceMaster.getEndYearManagerStatus()) {
                        managerEndSelfApproval = "Rework";
                        break;
                    }
                }

                if (!list.isEmpty()) {
                    List appraisalFillingDataList = appraisalFillingDataService.readByCurrentYear("" + year1);
                    //List appraisalFillingDataList = appraisalFillingDataService.getappraisalDate();

                    if (!appraisalFillingDataList.isEmpty()) {
                        AppraisalFillingData appraisalFillingData = (AppraisalFillingData) appraisalFillingDataList.get(0);
//                        Date currentDate = new Date();
//

                        // Middel year employee////comment by nishant
//                        Date MidendDate = dateFormat.parse(appraisalFillingData.getMidYearEndDate());
//                        Date MidYearStartDate = dateFormat.parse(appraisalFillingData.getMidYearStartDate());
//                        if ((currentDate.after(MidYearStartDate) && currentDate.before(MidendDate)) || currentDate.equals(MidendDate) || currentDate.equals(MidYearStartDate)) {
//                            if (!midSelfApproval.equals("Approved")) {
//                                midSelfApproval = "Pendding";
//                            }
//                        } else if (currentDate.after(MidendDate)) {
//                            if (!midSelfApproval.equals("Approved")) {
//                                midSelfApproval = "Expired";
//                            }
//                        } else if (!midSelfApproval.equals("Approved")) {
//                            midSelfApproval = "";
//                        }
                        /// Manager side Weight==>Time Line First////
                        Date ManagerEndDate = dateFormat.parse(appraisalFillingData.getManagerEndDate());
                        Date ManagerStartDate = dateFormat.parse(appraisalFillingData.getManagerStartDate());
                        if ((currentDate.after(ManagerStartDate) && currentDate.before(ManagerEndDate)) || currentDate.equals(ManagerStartDate) || currentDate.equals(ManagerEndDate)) {
                            if (!goalApproval.equals("Approved") && !goalApproval.equals("Rework")) {
                                goalApproval = "Pendding";
                            }
                        } else if (currentDate.after(ManagerEndDate)) {
                            if (!goalApproval.equals("Approved") && !goalApproval.equals("Rework")) {
                                goalApproval = "Expired";
                            }
                        } else if (!goalApproval.equals("Approved") && !goalApproval.equals("Rework")) {
                            goalApproval = "";
                        }

                        /// Manager side self assements==>Time Line Mid-Time//// line 3015 to 3029 comment by me
//                        Date ManagerMidDate = dateFormat.parse(appraisalFillingData.getManagerMidYearEndDate());
//                        Date ManagerMidStartDate = dateFormat.parse(appraisalFillingData.getManagerMidYearStartDate());
////                        if ((currentDate.after(ManagerMidDate) && currentDate.before(ManagerMidStartDate)) || currentDate.equals(ManagerMidStartDate) || currentDate.equals(ManagerMidDate)) {
//                        if ((currentDate.after(ManagerMidStartDate) && currentDate.before(ManagerMidDate)) || currentDate.equals(ManagerMidStartDate) || currentDate.equals(ManagerMidDate)) {
//                            if (!managerMidSelfApproval.equals("Approved") && !managerMidSelfApproval.equals("Rework")) {
//                                managerMidSelfApproval = "Pendding";
//                            }
//                        } else if (currentDate.after(ManagerMidDate)) {
//                            if (!managerMidSelfApproval.equals("Approved") && !managerMidSelfApproval.equals("Rework")) {
//                                managerMidSelfApproval = "Expired";
//                            }
//                        } else if (!managerMidSelfApproval.equals("Approved") && !managerMidSelfApproval.equals("Rework")) {
//                            managerMidSelfApproval = "";
//                        }
                        //////// End year for employee///////
                        Date endEndDate = dateFormat.parse(appraisalFillingData.getYearEndEndDate());
                        Date endStartDate = dateFormat.parse(appraisalFillingData.getYearEndStartDate());
//                        if ((currentDate.after(endEndDate) && (currentDate.before(endStartDate))) || currentDate.equals(endStartDate) || currentDate.equals(endEndDate)) {
                        if ((currentDate.after(endStartDate) && (currentDate.before(endEndDate))) || currentDate.equals(endStartDate) || currentDate.equals(endEndDate)) {
                            if (!endSelfApproval.equals("Approved")) {
                                endSelfApproval = "Pendding";
                            }
                        } else if (currentDate.after(endEndDate)) {
                            if (!endSelfApproval.equals("Approved")) {
                                endSelfApproval = "Expired";
                            }
                        } else if (!endSelfApproval.equals("Approved")) {
                            endSelfApproval = "";
                        }

                        /////////////////////////Manager End year////////////////////////////////////
                        Date managerYearEndEndDate = dateFormat.parse(appraisalFillingData.getManagerYearEndEndDate());
                        Date managerYearEndStartDate = dateFormat.parse(appraisalFillingData.getManagerYearEndStartDate());
                        if ((currentDate.after(managerYearEndStartDate) && currentDate.before(managerYearEndEndDate)) || currentDate.equals(managerYearEndStartDate) || currentDate.equals(managerYearEndEndDate)) {
                            if (!managerEndSelfApproval.equals("Approved") && !managerEndSelfApproval.equals("Rework")) {
                                managerEndSelfApproval = "Pendding";
                            }
                        } else if (currentDate.after(managerYearEndEndDate)) {
                            if (!managerEndSelfApproval.equals("Approved") && !managerEndSelfApproval.equals("Rework")) {
                                managerEndSelfApproval = "Expired";
                            }
                        } else if (!managerEndSelfApproval.equals("Approved") && !managerEndSelfApproval.equals("Rework")) {
                            managerEndSelfApproval = "";
                        }

                    }

                } else {
                    List appraisalFillingDataList = appraisalFillingDataService.readByCurrentYear("" + year1);
                    //List appraisalFillingDataList = appraisalFillingDataService.getappraisalDate();
                    if (!appraisalFillingDataList.isEmpty()) {
                        AppraisalFillingData appraisalFillingData = (AppraisalFillingData) appraisalFillingDataList.get(0);

                        //First Manager
//                        Date endDate = dateFormat.parse(appraisalFillingData.getEndDate());
                        Date endDate = dateFormat.parse(appraisalFillingData.getManagerEndDate());
                        if (currentDate.after(endDate) || currentDate.equals(endDate)) {
                            if (!goalApproval.equals("Approved")) {
                                goalApproval = "Expired";
                            }
                            goalSetting = "Expired";
                        } else {
                            if (!goalApproval.equals("Approved")) {
                                goalApproval = "Pendding";
                            }
                            goalSetting = "Pendding";
                        }

                        // Middel year  ////3087 comment by nishant
//                        Date MidendDate = dateFormat.parse(appraisalFillingData.getMidYearEndDate());
//                        Date MidendDate = dateFormat.parse(appraisalFillingData.getManagerMidYearEndDate());
//                        if (currentDate.after(MidendDate) || currentDate.equals(MidendDate)) {
//                            if (!midSelfApproval.equals("Approved")) {
//                                midSelfApproval = "Expired";
//                            }
//                            if (!managerMidSelfApproval.equals("Approved")) {
//                                managerMidSelfApproval = "Expired";
//                            }
//                        } else {
//                            if (!midSelfApproval.equals("Approved")) {
//                                midSelfApproval = "Pendding";
//                            }
//                            if (!managerMidSelfApproval.equals("Approved")) {
//                                managerMidSelfApproval = "Pendding";
//                            }
//                        }
                        // End year
//                        Date endEndDate = dateFormat.parse(appraisalFillingData.getYearEndEndDate());
                        Date endEndDate = dateFormat.parse(appraisalFillingData.getManagerYearEndEndDate());
                        if (currentDate.after(endEndDate) || currentDate.equals(endEndDate)) {
                            if (!endSelfApproval.equals("Approved")) {
                                endSelfApproval = "Expired";
                            }
                            if (!managerEndSelfApproval.equals("Approved")) {
                                managerEndSelfApproval = "Expired";
                            }
                        } else {
                            if (!endSelfApproval.equals("Approved")) {
                                endSelfApproval = "Pendding";
                            }
                            if (!managerEndSelfApproval.equals("Approved")) {
                                managerEndSelfApproval = "Pendding";
                            }
                        }

                    }
                }

                /////////
                List appraisalPerformanceList1 = new LinkedList();
                List starusList = new LinkedList();
                starusList.add(goalSetting);
                starusList.add(goalApproval);
                starusList.add(midSelfApproval);
                starusList.add(managerMidSelfApproval);
                starusList.add(endSelfApproval);
                starusList.add(managerEndSelfApproval);
                appraisalPerformanceList1.add(appraisalPerformanceList.get(i));
                i++;
                appraisalPerformanceList1.add(starusList);
                finalAppraisalPerformanceList1.add(appraisalPerformanceList1);
//request.setAttribute("goalApproval", goalApproval);
//        request.setAttribute("goalSetting", goalSetting);
//        request.setAttribute("midSelfApproval", midSelfApproval);
//        request.setAttribute("managerMidSelfApproval", managerMidSelfApproval);
//        request.setAttribute("endSelfApproval", endSelfApproval);
//        request.setAttribute("managerEndSelfApproval", managerEndSelfApproval);
            }

        }

        mv.getModelMap().put("list", finalAppraisalPerformanceList1);
//        mv.getModelMap().put("list", appraisalPerformanceList1);
        mv.getModelMap().put("appraisalPerformanceMaster", appraisalPerformanceMaster);
        mv.setViewName("Appraisal/EmployeePerformanceAppraisalResult");
        return mv;
    }
///////////////21-4-2016///////////

    public ModelAndView editClick1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AppraisalPerformanceMaster appraisalPerformanceMaster = new AppraisalPerformanceMaster();
        UpdateAppraisalPerformanceKra updateAppraisalPerformanceKra = new UpdateAppraisalPerformanceKra();
        AppraisalPerformanceKra appraisalPerformanceKra = new AppraisalPerformanceKra();
        EmployeeMaster employee = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        PmpFormStatusMaster pmpFormStatusMaster = new PmpFormStatusMaster();
        CompetencyEvaluationMaster competencyEvaluationMaster = new CompetencyEvaluationMaster();
        String employeeName = "" + employee.getEmployeeName();
        String empId = request.getParameter("id");
        String userid = request.getParameter("userid");
        String appraisalId1 = request.getParameter("appraisalId");
        //////Print/////By dhaval
        request.setAttribute("empId", empId);
        request.setAttribute("userid", userid);
        request.setAttribute("appraisalId1", appraisalId1);
        ///////////
        empDateStartToEnd(request, response);
        selectedEmployeeDate(request, response, userid);
        kraCategoryList(request);
        String employeeId = "" + empId;//set the value in employee id
        appraisalPerformanceMaster = appraisalPerformanceService.readById(Integer.parseInt(appraisalId1));
        if (null != appraisalPerformanceMaster.getWeightageScore()) {
            String weightageScore = appraisalPerformanceMaster.getWeightageScore();
            request.setAttribute("weightageScore", weightageScore);
        }
        if (null != appraisalPerformanceMaster.getEmployeeTotalFinalScore()) {
            String empScore = appraisalPerformanceMaster.getEmployeeTotalFinalScore();
            request.setAttribute("empScore", empScore);
        }
        if (null != appraisalPerformanceMaster.getTotalScore()) {
            String totalScore = appraisalPerformanceMaster.getTotalScore();
            request.setAttribute("totalScore", totalScore);
        }
        if (null != appraisalPerformanceMaster.getTotalScoreForemployee()) {
            String totalScoreForemployee = appraisalPerformanceMaster.getTotalScoreForemployee();
            request.setAttribute("totalScoreForemployee", totalScoreForemployee);
        }
        try {
            if (null != employee.getCompetencyEvaluationId()) {

                competencyEvaluationMaster = competencyEvaluationMasterService.readById(employee.getCompetencyEvaluationId());
                if (null != competencyEvaluationMaster) {
                    String cpmname = competencyEvaluationMaster.getTitle();
                    request.setAttribute("cpmname", cpmname);
                }
            }
        } catch (Exception e) {

        }

        String pmpstatusId = "";
        List<?> pmplist = pmpFormStatusMasterService.readByPmpformstatusStatus(employeeId);
        if (!pmplist.isEmpty()) {
            pmpFormStatusMaster = (PmpFormStatusMaster) pmplist.get(0);
            pmpstatusId = "" + pmpFormStatusMaster.getId();
            boolean pmpstartyearstatus = pmpFormStatusMaster.getStartYearStatus();
            boolean pmpmidyearstatus = pmpFormStatusMaster.getMidYearStatus();
            boolean pmpendyearstatus = pmpFormStatusMaster.getEndYearStatus();
            boolean pmpasEmployee = pmpFormStatusMaster.getEmployeeSide();
            request.setAttribute("pmpstartyearstatus", pmpstartyearstatus);
            request.setAttribute("pmpmidyearstatus", pmpmidyearstatus);
            request.setAttribute("pmpendyearstatus", pmpendyearstatus);
            request.setAttribute("pmpasEmployee", pmpasEmployee);

        }
        // ==========================Mid Year=======================================================//
        if (null != appraisalPerformanceMaster.getEmpMidyearSelfassOtheractivty()) {
            String empMidyearSelfassOtheractivty = appraisalPerformanceMaster.getEmpMidyearSelfassOtheractivty();
            request.setAttribute("empMidyearSelfassOtheractivty", empMidyearSelfassOtheractivty);
        }
        if (null != appraisalPerformanceMaster.getManagerMidyearReviewevalOtheractivity()) {
            String managerMidyearReviewevalOtheractivity = appraisalPerformanceMaster.getManagerMidyearReviewevalOtheractivity();
            request.setAttribute("managerMidyearReviewevalOtheractivity", managerMidyearReviewevalOtheractivity);
        }
        // ==========================Mid Year=======================================================//
        //=======End Year=============//
        if (null != appraisalPerformanceMaster.getEmpEndyearSelfassOtheractivty()) {
            String empEndyearSelfassOtheractivty = appraisalPerformanceMaster.getEmpEndyearSelfassOtheractivty();
            request.setAttribute("empEndyearSelfassOtheractivty", empEndyearSelfassOtheractivty);
        }
        if (null != appraisalPerformanceMaster.getManagerEndyearReviewevalOtheractivity()) {
            String managerEndyearReviewevalOtheractivity = appraisalPerformanceMaster.getManagerEndyearReviewevalOtheractivity();
            request.setAttribute("managerEndyearReviewevalOtheractivity", managerEndyearReviewevalOtheractivity);
        }
        /////////////////behaviors/////////////////
        if (null != appraisalPerformanceMaster.getBehaviorsMidyearTotalscore()) {
            String behaviorsMidyearTotalscore = appraisalPerformanceMaster.getBehaviorsMidyearTotalscore();
            request.setAttribute("behaviorsMidyearTotalscore", behaviorsMidyearTotalscore);
        }
        if (null != appraisalPerformanceMaster.getBehaviorsMidyearTotalscoreForemp()) {
            String behaviorsMidyearTotalscoreForemp = appraisalPerformanceMaster.getBehaviorsMidyearTotalscoreForemp();
            request.setAttribute("behaviorsMidyearTotalscoreForemp", behaviorsMidyearTotalscoreForemp);
        }
        if (null != appraisalPerformanceMaster.getBehaviorsMidyearOtherremark()) {
            String behaviorsMidyearOtherremark = appraisalPerformanceMaster.getBehaviorsMidyearOtherremark();
            request.setAttribute("behaviorsMidyearOtherremark", behaviorsMidyearOtherremark);
        }
        if (null != appraisalPerformanceMaster.getBehaviorsEndyearOtherremark()) {
            String behaviorsEndyearOtherremark = appraisalPerformanceMaster.getBehaviorsEndyearOtherremark();
            request.setAttribute("behaviorsEndyearOtherremark", behaviorsEndyearOtherremark);
        }
        if (null != appraisalPerformanceMaster.getBehaviorsEndyearOtherremark()) {
            String behaviorsEndyearTotalscore = appraisalPerformanceMaster.getBehaviorsEndyearTotalscore();
            request.setAttribute("behaviorsEndyearTotalscore", behaviorsEndyearTotalscore);
        }
        if (null != appraisalPerformanceMaster.getBehaviorsEndyearTotalscore()) {
            String behaviorsEndyearTotalscore = appraisalPerformanceMaster.getBehaviorsEndyearTotalscore();
            request.setAttribute("behaviorsEndyearTotalscore", behaviorsEndyearTotalscore);
        }
        if (null != appraisalPerformanceMaster.getBehaviorsEndyearTotalscoreForemp()) {
            String behaviorsEndyearTotalscoreForemp = appraisalPerformanceMaster.getBehaviorsEndyearTotalscoreForemp();
            request.setAttribute("behaviorsEndyearTotalscoreForemp", behaviorsEndyearTotalscoreForemp);
        }
//        employee side

        if (null != appraisalPerformanceMaster.getBehaviorsMidyearOtherremarkForemployee()) {
            String behaviorsMidyearOtherremarkForemployee = appraisalPerformanceMaster.getBehaviorsMidyearOtherremarkForemployee();
            request.setAttribute("behaviorsMidyearOtherremarkForemployee", behaviorsMidyearOtherremarkForemployee);
        }
        if (null != appraisalPerformanceMaster.getBehaviorsEndyearOtherremarkForemployee()) {
            String behaviorsEndyearOtherremarkForemployee = appraisalPerformanceMaster.getBehaviorsEndyearOtherremarkForemployee();
            request.setAttribute("behaviorsEndyearOtherremarkForemployee", behaviorsEndyearOtherremarkForemployee);
        }
        if (null != appraisalPerformanceMaster.getBehaviorsEndyearOtherremark()) {
            String behaviorsEndyearTotalscore = appraisalPerformanceMaster.getBehaviorsEndyearTotalscore();
            request.setAttribute("behaviorsEndyearTotalscore", behaviorsEndyearTotalscore);
        }
        if (null != appraisalPerformanceMaster.getBehaviorsEndyearTotalscore()) {
            String behaviorsEndyearTotalscore = appraisalPerformanceMaster.getBehaviorsEndyearTotalscore();
            request.setAttribute("behaviorsEndyearTotalscore", behaviorsEndyearTotalscore);
        }

        if (null != appraisalPerformanceMaster.getEmpActivityScore()) {
            String empActivityScore = appraisalPerformanceMaster.getEmpActivityScore();
            request.setAttribute("empActivityScore", empActivityScore);
        }

//        if (null != appraisalPerformanceMaster.getManagerStatus()) {
        int managerStatus = appraisalPerformanceMaster.getManagerStatus();
        request.setAttribute("managerStatus", managerStatus);
        int statusFlag = appraisalPerformanceMaster.getStatus();
        request.setAttribute("statusFlag", statusFlag);
//        }
//        if (null != appraisalPerformanceMaster.getEmployeeStatus()) {
        int employeeStatus = appraisalPerformanceMaster.getEmployeeStatus();
        request.setAttribute("employeeStatus", employeeStatus);
//        }
//        if (null != appraisalPerformanceMaster.getStatus()) {
//            int employeeStatus = appraisalPerformanceMaster.getStatus();
//            request.setAttribute("employeeStatus", employeeStatus);
//        }
//        if (null != appraisalPerformanceMaster.getStatus()) {
//            int employeeStatus = appraisalPerformanceMaster.getStatus();
//            request.setAttribute("employeeStatus", employeeStatus);
//        }
//        if (null != appraisalPerformanceMaster.getBehaviorsFinalscore()) {
//            String behaviorsFinalscore = appraisalPerformanceMaster.getBehaviorsFinalscore();
//            request.setAttribute("behaviorsFinalscore", behaviorsFinalscore);
//        }

        if (null != appraisalPerformanceMaster.getBehaviorsFinalscore() && !"".equals(appraisalPerformanceMaster.getBehaviorsFinalscore())) {
            String behaviorsFinalscore = appraisalPerformanceMaster.getBehaviorsFinalscore();
            request.setAttribute("behaviorsFinalscore", behaviorsFinalscore);
        }
        if (null != appraisalPerformanceMaster.getBehaviorsFinalscoreForemployee() && !"".equals(appraisalPerformanceMaster.getBehaviorsFinalscoreForemployee())) {
            String behaviorsFinalscoreForemployee = appraisalPerformanceMaster.getBehaviorsFinalscoreForemployee();
            request.setAttribute("behaviorsFinalscoreForemployee", behaviorsFinalscoreForemployee);
        }
//        } else {
//            String behaviorsFinalscore = "";
//            request.setAttribute("behaviorsFinalscore", behaviorsFinalscore);
//        }
        int year = Integer.parseInt(request.getParameter("year"));
        // Changes
//        List<AppraisalFillingData> appraisalFilling = (List<AppraisalFillingData>) appraisalFillingDataService.readByCurrentYear("" + year);
        List<AppraisalFillingData> appraisalFilling = (List<AppraisalFillingData>) appraisalFillingDataService.readByIdNew(year);

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String today = sdf.format(cal.getTime());

        Date now = sdf.parse(today);
        if (!appraisalFilling.isEmpty()) {
            AppraisalFillingData appraisalFillingData = (AppraisalFillingData) appraisalFilling.get(0);

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
            boolean flag = false;
//            boolean flag1 = false;
            boolean flag2 = false;
            boolean Tflag = false;
            boolean cycleCompletedflag = false;
            if ((now.after(strDate) && now.before(eDate)) || now.equals(strDate) || now.equals(eDate)) {
                flag = true;
            } //            else if ((now.after(midDate) && now.before(midEndDate)) || now.equals(midDate) || now.equals(midEndDate)) {
            //                flag1 = true;
            //            }
            else if ((now.after(yearEndStartDate) && now.before(yearEndDate)) || now.equals(yearEndStartDate) || now.equals(yearEndDate)) {
                flag2 = true;
            }
            if ((now.after(strDate) && now.before(yearEndDate) || now.equals(strDate) || now.equals(yearEndDate))) {
                Tflag = true;
            }

            if ((now.after(yearEndStartDate) && now.before(yearEndDate)) || now.equals(yearEndStartDate) || now.equals(yearEndDate)) {
                if ((appraisalPerformanceMaster.getEndYearEmployeeStatus() == 1)
                        && (appraisalPerformanceMaster.getEndYearManagerStatus() == 1)) {
                    cycleCompletedflag = true;
                }
            }
            request.setAttribute("flag", flag);
//            request.setAttribute("flag1", flag1);
            request.setAttribute("flag2", flag2);
            request.setAttribute("Tflag", Tflag);
            request.setAttribute("cycleCompletedflag", cycleCompletedflag);
//            boolean Tflag = false;
//            String lastDateStr = "25/04/" + year;
//            Date lastDate = sdf.parse(lastDateStr);
//            if (now.before(lastDate)) {
//                Tflag = true;
//            }
        }
        // Changes

//        List<?> l1 = appraisalFillingDataService.getCurrentAndPreviousYear();
//        String previousYear = "";
//        int currentYear = 0;
//        if (!l1.isEmpty()) {
//            Object[] obj = (Object[]) l1.get(0);
////            previousYear = (Integer) obj[0];
////            previousYear = "" + obj[0];
//            previousYear = "2016";
////            currentYear = (Integer) obj[1];
//        }
        //if (!"".equals(year)) {
//
//        }
//        int year = Calendar.getInstance().get(Calendar.YEAR);
//        List<?> list = appraisalPerformanceService.readByAppraisalPerformanceId(employeeId);
//2017//
//        List<?> list = appraisalPerformanceService.readByAppraisalPerformanceId(employeeId, year);
        List<?> list = appraisalPerformanceService.readByAppraisalPerformanceId(employeeId, year);
        if (!list.isEmpty()) {

            appraisalPerformanceMaster = (AppraisalPerformanceMaster) list.get(0);
            int appraisalId = appraisalPerformanceMaster.getId();
            //AppraisalPerformanceKra appraisalPerformanceKra = new AppraisalPerformanceKra();
            appraisalPerformanceKra.setId(appraisalId);
            String kragoal = "";
            String metric = "";
            boolean updateStatus = false;
            int kragoalId;
            //int weightage = 0;

            List<?> kraList = appraisalPerformanceKraService.readByAppraisalKraGoal(appraisalPerformanceKra);
            if (!kraList.isEmpty()) {
                appraisalPerformanceKra = (AppraisalPerformanceKra) kraList.get(0);
                kragoal = appraisalPerformanceKra.getKraGoal();
                kragoalId = appraisalPerformanceKra.getId();
                metric = appraisalPerformanceKra.getMetric();
//                KraCategory kraCategory1 = new KraCategory();
//                kraCategory1 = kraCategoryService.readById(appraisalPerformanceKra.getKraCategoryByKraCategoryByEmployee().getId());
                if (null != kragoal && !"".equals(kragoal)) {

                    UpdateAppraisalPerformanceKra updateAppraisalPerformanceKra1 = new UpdateAppraisalPerformanceKra();
                    updateAppraisalPerformanceKra.setId(Integer.parseInt("" + kragoalId));
                    List<?> updateAppraisalPerformanceKra1List = updateAppraisalPerformanceKraService.readByUserUpdateKra(updateAppraisalPerformanceKra);
                    if (!updateAppraisalPerformanceKra1List.isEmpty()) {

                        updateAppraisalPerformanceKra1 = (UpdateAppraisalPerformanceKra) updateAppraisalPerformanceKra1List.get(0);
                        if (!kragoal.equals(updateAppraisalPerformanceKra1.getUpdateKra()) || !metric.equals(updateAppraisalPerformanceKra1.getUpdateMetric())) {
                            updateStatus = true;
                        }
                    }
                }
            }
            request.setAttribute("updateStatus", updateStatus);
            request.setAttribute("kragoal", kraList);
            request.setAttribute("weightage", kraList);
            request.setAttribute("appraisalId", appraisalId);
            request.setAttribute("empMidyearSelfassessmentGoal", kraList);
            request.setAttribute("managerMidyearReviewEvaluation", kraList);
            request.setAttribute("midyearStatus", kraList);
            request.setAttribute("endyearStatus", kraList);
            request.setAttribute("empEndyearSelfassessmentGoal", kraList);
            request.setAttribute("editDate", kraList);
            request.setAttribute("startDate", kraList);
            request.setAttribute("year", request.getParameter("year"));

        }

        ////////////////////////////////////KRA OTHER Activity///////////////////////////////////////////////////////////
        String kragoal_activity = "";
        String metric_activity = "";
        boolean kraOtherupdateStatus = false;
        int kragoalactivityId;
        if (null != appraisalPerformanceMaster.getId()) {

            AppraisalPerformanceActivities appraisalPerformanceActivities = new AppraisalPerformanceActivities();
            appraisalPerformanceActivities.setAppraisalPerformanceMaster(appraisalPerformanceMaster);

            List<?> kraOtherList = appraisalPerformanceActivitiesService.readByAppraisalKraGoalActivities(appraisalPerformanceActivities);
            if (!kraOtherList.isEmpty()) {
                appraisalPerformanceActivities = (AppraisalPerformanceActivities) kraOtherList.get(0);
                kragoal_activity = appraisalPerformanceActivities.getKraGoalActivities();
                kragoalactivityId = appraisalPerformanceActivities.getId();
                metric_activity = appraisalPerformanceActivities.getMetricActivities();

                if (null != kragoal_activity && !"".equals(kragoal_activity)) {
                    UpdateAppraisalPerformanceActivities updateAppraisalPerformanceActivities = new UpdateAppraisalPerformanceActivities();
                    updateAppraisalPerformanceActivities.setId(Integer.parseInt("" + kragoalactivityId));
                    List<?> updateKraOtherList = updateAppraisalPerformanceActivitiesService.readByUserUpdateKraOther(updateAppraisalPerformanceActivities);
                    if (!updateKraOtherList.isEmpty()) {

                        updateAppraisalPerformanceActivities = (UpdateAppraisalPerformanceActivities) updateKraOtherList.get(0);
                        if (!kragoal_activity.equals(updateAppraisalPerformanceActivities.getKraActivity()) || !metric_activity.equals(updateAppraisalPerformanceActivities.getMetricActivity())) {
                            kraOtherupdateStatus = true;
                        }
                    }
                }
            }
            request.setAttribute("kraOtherupdateStatus", kraOtherupdateStatus);
            request.setAttribute("kragoalOtherActivity", kraOtherList);
        }
        ////////////////////////////////////KRA OTHER Activity//////////////////////////////////////////////////////////

//        // =======================competency Evaluation==========================================================//
//        // =======================competency Evaluation Chsanage by date 11/11/2016==========================================================//
//        competencyList(request);
//        int competencyId = 0;
//        AppraisalPerformanceCompetencyEvaluation appraisalPerformanceCompetencyEvaluation = new AppraisalPerformanceCompetencyEvaluation();
//        appraisalPerformanceCompetencyEvaluation.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
//        CompetencyEvaluationTextmaster competencyEvaluationTextmaster = new CompetencyEvaluationTextmaster();
////        List<?> competencyEvaluationList = appraisalPerformanceCompetencyEvaluationService.readAppraisalPerformanceCompetencyEvaluationDetail(appraisalPerformanceCompetencyEvaluation);
//        List<?> competencyEvaluationList = appraisalPerformanceCompetencyEvaluationService.readByEmployeeWiseAppraisalPerformanceCompetencyEvaluationDetail(appraisalPerformanceCompetencyEvaluation);
//
//        request.setAttribute("competencyEvaluationList", competencyEvaluationList);
//
//        // =======================competency Evaluation Chsanage by date 11/11/2016==========================================================//
//        //Individual Development Plan//
//        AppraisalPerformanceIndividualDevelopmentPlan appraisalPerformanceIndividualDevelopmentPlan = new AppraisalPerformanceIndividualDevelopmentPlan();
//        appraisalPerformanceIndividualDevelopmentPlan.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
//        String text1 = "";
//        List<?> individualDevelopmentPlanList = appraisalPerformanceIndividualDevelopmentPlanService.readIndividualDevelopmentPlanDetail(appraisalPerformanceIndividualDevelopmentPlan);
//        if (!individualDevelopmentPlanList.isEmpty()) {
//            appraisalPerformanceIndividualDevelopmentPlan = (AppraisalPerformanceIndividualDevelopmentPlan) individualDevelopmentPlanList.get(0);
//            text1 = appraisalPerformanceIndividualDevelopmentPlan.getText1();
//        }
//        request.setAttribute("text1", individualDevelopmentPlanList);
//        request.setAttribute("text2", individualDevelopmentPlanList);
//        request.setAttribute("text3", individualDevelopmentPlanList);
//        request.setAttribute("remark", individualDevelopmentPlanList);
//        request.setAttribute("midYearRemark", individualDevelopmentPlanList);
//        request.setAttribute("endYearRemark", individualDevelopmentPlanList);
//        request.setAttribute("individualDevelopmentPlanList", individualDevelopmentPlanList);
        //////////Behaviors///////////////
        AppraisalPerformanceBehaviors appraisalPerformanceBehaviors = new AppraisalPerformanceBehaviors();
        String behaviors = "";
        appraisalPerformanceBehaviors.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
        ////////////////comment by nishant
//        List<?> behaviorsList = appraisalPerformanceBehaviorsService.readBehaviorsDetail(appraisalPerformanceBehaviors);
//        if (!behaviorsList.isEmpty()) {
//            appraisalPerformanceBehaviors = (AppraisalPerformanceBehaviors) behaviorsList.get(0);
//            behaviors = appraisalPerformanceBehaviors.getBehaviors();
//        }
//        request.setAttribute("behaviors", behaviorsList);
//        request.setAttribute("behaviorsList", behaviorsList);

        mv.getModelMap().put("appraisalPerformanceMaster", appraisalPerformanceMaster);
        if (year == 2016) {

            mv.setViewName("Appraisal/PerformanceAppraisalForm");
        } else {
            mv.setViewName("Appraisal/PerformanceAppraisalForm2017Onwards");
        }
//        mv.setViewName("Appraisal/ManagerPerformanceAppraisalForm");
//        mv.setViewName("forward:userMaster.htm?act=userDashboard");
        return mv;
    }

    public ModelAndView editClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ////////////Manager
        ModelAndView mv = new ModelAndView();
        AppraisalPerformanceMaster appraisalPerformanceMaster = new AppraisalPerformanceMaster();
        UpdateAppraisalPerformanceKra updateAppraisalPerformanceKra = new UpdateAppraisalPerformanceKra();
        AppraisalPerformanceKra appraisalPerformanceKra = new AppraisalPerformanceKra();
        EmployeeMaster employee = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        String employeeName = "" + employee.getEmployeeName();
        String empId = request.getParameter("id");
        String userid = request.getParameter("userid");
        String appraisalId1 = request.getParameter("appraisalId");
        String goalSetting = "Pendding";
        String goalApproval = "";
        String midSelfApproval = "";
        String managerMidSelfApproval = "";
        String endSelfApproval = "";
        String managerEndSelfApproval = "";
        int ManagerStatus = 0;
        int i = 0;
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date currentDate = dateFormat.parse(dateFormat.format(new Date()));
        PmpFormStatusMaster pmpFormStatusMaster = new PmpFormStatusMaster();
        //////Print/////By dhaval
        request.setAttribute("empId", empId);
        request.setAttribute("userid", userid);
        request.setAttribute("appraisalId1", appraisalId1);

        request.setAttribute("empId", empId);
        request.setAttribute("userid", userid);
        request.setAttribute("appraisalId1", appraisalId1);
        ///////////
//        selectedEmployeeDate(request, response, userid);
//        managerDateStartToEnd(request, response);
        managerTimeLineDate(request, response, userid);
        kraCategoryList(request);
        String employeeId = "" + empId;//set the value in employee id
        appraisalPerformanceMaster = appraisalPerformanceService.readById(Integer.parseInt(appraisalId1));
//        List appraisalFillingDataList1 = appraisalFillingDataService.readByCurrentYear(appraisalPerformanceMaster.getBehaviorsYear());
        List appraisalFillingDataList1 = appraisalFillingDataService.readByIdNew(Integer.parseInt(appraisalPerformanceMaster.getBehaviorsYear()));
        AppraisalFillingData appraisalFillingData1 = (AppraisalFillingData) appraisalFillingDataList1.get(0);

        // Middel year employee
//        Date ManagerStartDate1 = dateFormat.parse(appraisalFillingData1.getManagerStartDate());
//        Date ManagerEndDate1 = dateFormat.parse(appraisalFillingData1.getManagerEndDate());
        //Mid Year Dates Manager
//        Date ManagerMidStartDate1 = dateFormat.parse(appraisalFillingData1.getManagerMidYearStartDate());
//        Date ManagerMidDate1 = dateFormat.parse(appraisalFillingData1.getManagerMidYearEndDate());
        //End Year Dates Manager
//        Date managerYearEndStartDate1 = dateFormat.parse(appraisalFillingData1.getManagerYearEndStartDate());
//        Date managerYearEndEndDate1 = dateFormat.parse(appraisalFillingData1.getManagerYearEndEndDate());
        if (!appraisalPerformanceMaster.equals("")) {
            ManagerStatus = appraisalPerformanceMaster.getManagerStatus();
        }
//            }
        appraisalPerformanceKra.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
        List list1 = appraisalPerformanceKraService.readByAppraisalPerformancekraId(appraisalPerformanceKra);
        for (Object o : list1) {
            goalSetting = "Pendding";

            AppraisalPerformanceKra appraisalPerformanceKra1 = (AppraisalPerformanceKra) o;

            if (appraisalPerformanceKra1.getKraGoal() != null && appraisalPerformanceKra1.getMetric() != null) {
                goalSetting = "Approved";
                break;
            }
        }
        for (Object o2 : list1) {
            goalApproval = "";
            AppraisalPerformanceKra appraisalPerformanceKra1 = (AppraisalPerformanceKra) o2;
//            if (currentDate.equals(ManagerStartDate1) || currentDate.equals(ManagerEndDate1)
//                    || (currentDate.after(ManagerStartDate1) && currentDate.before(ManagerEndDate1))) {
//                if (appraisalPerformanceMaster.getReworkStatus() == 1) {
//                    goalApproval = "Rework";
//                    //goalApproval = "pending";
//                    goalSetting = "Pendding";
//                    break;
//                }
//            }
            if (appraisalPerformanceKra1.getWeightage() != null && ManagerStatus == 1) {
                goalApproval = "Approved";
                break;
            } else if (appraisalPerformanceMaster.getReworkStatus() == 1) {
                goalApproval = "Rework";
                break;
            }
        }
        for (Object o3 : list1) {

            midSelfApproval = "";
            AppraisalPerformanceKra appraisalPerformanceKra1 = (AppraisalPerformanceKra) o3;
            if (appraisalPerformanceKra1.getEmpMidyearSelfassessmentGoal() != null && !"".equals(appraisalPerformanceKra1.getEmpMidyearSelfassessmentGoal()) && 0 != appraisalPerformanceMaster.getMidYearEmployeeStatus()) {
                midSelfApproval = "Approved";
                break;
            }
        }
//        for (Object o4 : list1) {
//            managerMidSelfApproval = "";
//            AppraisalPerformanceKra appraisalPerformanceKra1 = (AppraisalPerformanceKra) o4;
//            if (currentDate.equals(ManagerMidStartDate1) || currentDate.equals(ManagerMidDate1)
//                    || (currentDate.after(ManagerMidStartDate1) && currentDate.before(ManagerMidDate1))) {
////                        if (appraisalPerformanceMaster.getReworkStatus() == 1 && 0 != appraisalPerformanceMaster.getMidYearManagerStatus()) {
//                if (appraisalPerformanceMaster.getReworkStatus() == 1) {
//                    managerMidSelfApproval = "Rework";
//                    midSelfApproval = "Pendding";
//                    break;
//                }
//            }
//            if (appraisalPerformanceKra1.getManagerMidyearReviewEvaluation() != null && 0 != appraisalPerformanceMaster.getMidYearManagerStatus()) {
//                managerMidSelfApproval = "Approved";
//                break;
//            } else if (appraisalPerformanceMaster.getReworkStatus() == 1 && 0 != appraisalPerformanceMaster.getMidYearManagerStatus()) {
//                managerMidSelfApproval = "Rework";
//                break;
//            }
//        }
        for (Object o5 : list1) {
            endSelfApproval = "";
            AppraisalPerformanceKra appraisalPerformanceKra1 = (AppraisalPerformanceKra) o5;
            if (appraisalPerformanceKra1.getEmpEndyearSelfassessmentGoal() != null && 0 != appraisalPerformanceMaster.getEndYearEmployeeStatus()) {
                endSelfApproval = "Approved";
                break;
            }
        }
        for (Object o6 : list1) {
            managerEndSelfApproval = "";
            AppraisalPerformanceKra appraisalPerformanceKra1 = (AppraisalPerformanceKra) o6;
//            if (currentDate.equals(managerYearEndStartDate1) || currentDate.equals(managerYearEndEndDate1)
//                    || (currentDate.after(managerYearEndStartDate1) && currentDate.before(managerYearEndEndDate1))) {
////                        if (appraisalPerformanceMaster.getReworkStatus() == 1 && 0 != appraisalPerformanceMaster.getEndYearManagerStatus()) {
//                if (appraisalPerformanceMaster.getReworkStatus() == 1) {
//                    managerEndSelfApproval = "Rework";
//                    endSelfApproval = "Pendding";
//                    break;
//                }
//            }
            if (appraisalPerformanceKra1.getManagerEndyearReviewEvaluation() != null && 0 != appraisalPerformanceMaster.getEndYearManagerStatus()) {
                managerEndSelfApproval = "Approved";
                break;
            } else if (appraisalPerformanceMaster.getReworkStatus() == 1 && 0 != appraisalPerformanceMaster.getEndYearManagerStatus()) {
                managerEndSelfApproval = "Rework";
                break;
            }
        }

        if (!list1.isEmpty()) {
//                    List appraisalFillingDataList = appraisalFillingDataService.readByCurrentYear("" + year1);
            //List appraisalFillingDataList = appraisalFillingDataService.getappraisalDate();

            if (!appraisalFillingDataList1.isEmpty()) {
//                        AppraisalFillingData appraisalFillingData = (AppraisalFillingData) appraisalFillingDataList.get(0);
//                        Date currentDate = new Date();
//

                // Middel year employee
//                Date MidendDate = dateFormat.parse(appraisalFillingData1.getMidYearEndDate());
//                Date MidYearStartDate = dateFormat.parse(appraisalFillingData1.getMidYearStartDate());
//                if ((currentDate.after(MidYearStartDate) && currentDate.before(MidendDate)) || currentDate.equals(MidendDate) || currentDate.equals(MidYearStartDate)) {
//                    if (!midSelfApproval.equals("Approved")) {
//                        midSelfApproval = "Pendding";
//                    }
//                } else if (currentDate.after(MidendDate)) {
//                    if (!midSelfApproval.equals("Approved")) {
//                        midSelfApproval = "Expired";
//                    }
//                } else if (!midSelfApproval.equals("Approved")) {
//                    midSelfApproval = "";
//                }
                /// Manager side Weight==>Time Line First////
//                Date ManagerEndDate = dateFormat.parse(appraisalFillingData1.getManagerEndDate());
//                Date ManagerStartDate = dateFormat.parse(appraisalFillingData1.getManagerStartDate());
//                if ((currentDate.after(ManagerStartDate) && currentDate.before(ManagerEndDate)) || currentDate.equals(ManagerStartDate) || currentDate.equals(ManagerEndDate)) {
                if (!goalApproval.equals("Approved") && !goalApproval.equals("Rework")) {
                    goalApproval = "Pendding";
                }
//                } else if (currentDate.after(ManagerEndDate)) {
//                    if (!goalApproval.equals("Approved") && !goalApproval.equals("Rework")) {
//                        goalApproval = "Expired";
//                    }
//                } else if (!goalApproval.equals("Approved") && !goalApproval.equals("Rework")) {
//                    goalApproval = "";
//                }
                /// Manager side self assements==>Time Line Mid-Time////
//                Date ManagerMidDate = dateFormat.parse(appraisalFillingData1.getManagerMidYearEndDate());
//                Date ManagerMidStartDate = dateFormat.parse(appraisalFillingData1.getManagerMidYearStartDate());
////                        if ((currentDate.after(ManagerMidDate) && currentDate.before(ManagerMidStartDate)) || currentDate.equals(ManagerMidStartDate) || currentDate.equals(ManagerMidDate)) {
//                if ((currentDate.after(ManagerMidStartDate) && currentDate.before(ManagerMidDate)) || currentDate.equals(ManagerMidStartDate) || currentDate.equals(ManagerMidDate)) {
//                    if (!managerMidSelfApproval.equals("Approved") && !managerMidSelfApproval.equals("Rework")) {
//                        managerMidSelfApproval = "Pendding";
//                    }
//                } else if (currentDate.after(ManagerMidDate)) {
//                    if (!managerMidSelfApproval.equals("Approved") && !managerMidSelfApproval.equals("Rework")) {
//                        managerMidSelfApproval = "Expired";
//                    }
//                } else if (!managerMidSelfApproval.equals("Approved") && !managerMidSelfApproval.equals("Rework")) {
//                    managerMidSelfApproval = "";
//                }
                //////// End year for employee///////
                Date endEndDate = dateFormat.parse(appraisalFillingData1.getYearEndEndDate());
                Date endStartDate = dateFormat.parse(appraisalFillingData1.getYearEndStartDate());
//                        if ((currentDate.after(endEndDate) && (currentDate.before(endStartDate))) || currentDate.equals(endStartDate) || currentDate.equals(endEndDate)) {
                if ((currentDate.after(endStartDate) && (currentDate.before(endEndDate))) || currentDate.equals(endStartDate) || currentDate.equals(endEndDate)) {
                    if (!endSelfApproval.equals("Approved")) {
                        endSelfApproval = "Pendding";
                    }
                } else if (currentDate.after(endEndDate)) {
                    if (!endSelfApproval.equals("Approved")) {
                        endSelfApproval = "Expired";
                    }
                } else if (!endSelfApproval.equals("Approved")) {
                    endSelfApproval = "";
                }

                /////////////////////////Manager End year////////////////////////////////////
//                Date managerYearEndEndDate = dateFormat.parse(appraisalFillingData1.getManagerYearEndEndDate());
//                Date managerYearEndStartDate = dateFormat.parse(appraisalFillingData1.getManagerYearEndStartDate());
//                if ((currentDate.after(managerYearEndStartDate) && currentDate.before(managerYearEndEndDate)) || currentDate.equals(managerYearEndStartDate) || currentDate.equals(managerYearEndEndDate)) {
//                    if (!managerEndSelfApproval.equals("Approved") && !managerEndSelfApproval.equals("Rework")) {
//                        managerEndSelfApproval = "Pendding";
//                    }
//                } else if (currentDate.after(managerYearEndEndDate)) {
//                    if (!managerEndSelfApproval.equals("Approved") && !managerEndSelfApproval.equals("Rework")) {
//                        managerEndSelfApproval = "Expired";
//                    }
//                } else if (!managerEndSelfApproval.equals("Approved") && !managerEndSelfApproval.equals("Rework")) {
//                    managerEndSelfApproval = "";
//                }
            }

        } else //                    List appraisalFillingDataList = appraisalFillingDataService.readByCurrentYear("" + year1);
        //List appraisalFillingDataList = appraisalFillingDataService.getappraisalDate();
        //                    if (!appraisalFillingData.isEmpty()) {
        //                        AppraisalFillingData appraisalFillingData = (AppraisalFillingData) appraisalFillingDataList.get(0);
        //First Manager
        //                        Date endDate = dateFormat.parse(appraisalFillingData.getEndDate());
        //            Date endDate = dateFormat.parse(appraisalFillingData1.getManagerEndDate());
        //            if (currentDate.after(endDate) || currentDate.equals(endDate)) {
        //                if (!goalApproval.equals("Approved")) {
        //                    goalApproval = "Expired";
        //                }
        //                goalSetting = "Expired";
        //            } else {
        {
            if (!goalApproval.equals("Approved")) {
                goalApproval = "Pendding";
            } //                goalSetting = "Pendding";        //            }        // Middel year        //                        Date MidendDate = dateFormat.parse(appraisalFillingData.getMidYearEndDate());        //            Date MidendDate = dateFormat.parse(appraisalFillingData1.getManagerMidYearEndDate());        //            if (currentDate.after(MidendDate) || currentDate.equals(MidendDate)) {        //                if (!midSelfApproval.equals("Approved")) {        //                    midSelfApproval = "Expired";        //                }        //                if (!managerMidSelfApproval.equals("Approved")) {        //                    managerMidSelfApproval = "Expired";
        }        //                }
        //            } else {
        //                if (!midSelfApproval.equals("Approved")) {
        //                    midSelfApproval = "Pendding";
        //                }
        //                if (!managerMidSelfApproval.equals("Approved")) {
        //                    managerMidSelfApproval = "Pendding";
        //                }
        //            }
        // End year
        //                        Date endEndDate = dateFormat.parse(appraisalFillingData.getYearEndEndDate());
        //            Date endEndDate = dateFormat.parse(appraisalFillingData1.getManagerYearEndEndDate());
        //            if (currentDate.after(endEndDate) || currentDate.equals(endEndDate)) {
        //                if (!endSelfApproval.equals("Approved")) {
        //                    endSelfApproval = "Expired";
        //                }
        //                if (!managerEndSelfApproval.equals("Approved")) {
        //                    managerEndSelfApproval = "Expired";
        //                }
        //            } else {
        //                if (!endSelfApproval.equals("Approved")) {
        //                    endSelfApproval = "Pendding";
        //                }
        //                if (!managerEndSelfApproval.equals("Approved")) {
        //                    managerEndSelfApproval = "Pendding";
        //                }
        //            }
        //                    }

//        if (null != appraisalPerformanceMaster.getWeightageScore()) {
//            String weightageScore = appraisalPerformanceMaster.getWeightageScore();
//            request.setAttribute("weightageScore", weightageScore);
//        }
        String pmpstatusId = "";
        List<?> pmplist = pmpFormStatusMasterService.readByPmpformstatusStatus(employeeId);
        if (!pmplist.isEmpty()) {
            pmpFormStatusMaster = (PmpFormStatusMaster) pmplist.get(0);
            pmpstatusId = "" + pmpFormStatusMaster.getId();
            boolean pmpmidyearstatus = pmpFormStatusMaster.getMidYearStatus();
            boolean pmpendyearstatus = pmpFormStatusMaster.getEndYearStatus();
            boolean pmpasManager = pmpFormStatusMaster.getManagerSide();
            request.setAttribute("pmpmidyearstatus", pmpmidyearstatus);
            request.setAttribute("pmpendyearstatus", pmpendyearstatus);
            request.setAttribute("pmpasManager", pmpasManager);

        }
        if (null != appraisalPerformanceMaster.getWeightageScore()) {
            String weightageScore = appraisalPerformanceMaster.getWeightageScore();
            request.setAttribute("weightageScore", weightageScore);
        }
        if (null != appraisalPerformanceMaster.getEmployeeTotalFinalScore()) {
            String empScore = appraisalPerformanceMaster.getEmployeeTotalFinalScore();
            request.setAttribute("empScore", empScore);
        }
        if (null != appraisalPerformanceMaster.getTotalScore()) {
            String totalScore = appraisalPerformanceMaster.getTotalScore();
            request.setAttribute("totalScore", totalScore);
        }
        // ==========================Mid Year=======================================================//
//        if (null != appraisalPerformanceMaster.getEmpMidyearSelfassOtheractivty()) {
//            String empMidyearSelfassOtheractivty = appraisalPerformanceMaster.getEmpMidyearSelfassOtheractivty();
//            request.setAttribute("empMidyearSelfassOtheractivty", empMidyearSelfassOtheractivty);
//        }
//        if (null != appraisalPerformanceMaster.getManagerMidyearReviewevalOtheractivity()) {
//            String managerMidyearReviewevalOtheractivity = appraisalPerformanceMaster.getManagerMidyearReviewevalOtheractivity();
//            request.setAttribute("managerMidyearReviewevalOtheractivity", managerMidyearReviewevalOtheractivity);
//        }
        // ==========================Mid Year=======================================================//
        //=======End Year=============//
        if (null != appraisalPerformanceMaster.getEmpEndyearSelfassOtheractivty()) {
            String empEndyearSelfassOtheractivty = appraisalPerformanceMaster.getEmpEndyearSelfassOtheractivty();
            request.setAttribute("empEndyearSelfassOtheractivty", empEndyearSelfassOtheractivty);
        }
        if (null != appraisalPerformanceMaster.getManagerEndyearReviewevalOtheractivity()) {
            String managerEndyearReviewevalOtheractivity = appraisalPerformanceMaster.getManagerEndyearReviewevalOtheractivity();
            request.setAttribute("managerEndyearReviewevalOtheractivity", managerEndyearReviewevalOtheractivity);
        }
        /////////////////behaviors/////////////////
        if (null != appraisalPerformanceMaster.getBehaviorsMidyearTotalscore()) {
            String behaviorsMidyearTotalscore = appraisalPerformanceMaster.getBehaviorsMidyearTotalscore();
            request.setAttribute("behaviorsMidyearTotalscore", behaviorsMidyearTotalscore);
        }
        if (null != appraisalPerformanceMaster.getBehaviorsMidyearOtherremark()) {
            String behaviorsMidyearOtherremark = appraisalPerformanceMaster.getBehaviorsMidyearOtherremark();
            request.setAttribute("behaviorsMidyearOtherremark", behaviorsMidyearOtherremark);
        }
        if (null != appraisalPerformanceMaster.getBehaviorsEndyearOtherremark()) {
            String behaviorsEndyearOtherremark = appraisalPerformanceMaster.getBehaviorsEndyearOtherremark();
            request.setAttribute("behaviorsEndyearOtherremark", behaviorsEndyearOtherremark);
        }
        if (null != appraisalPerformanceMaster.getBehaviorsEndyearOtherremark()) {
            String behaviorsEndyearTotalscore = appraisalPerformanceMaster.getBehaviorsEndyearTotalscore();
            request.setAttribute("behaviorsEndyearTotalscore", behaviorsEndyearTotalscore);
        }
        if (null != appraisalPerformanceMaster.getBehaviorsEndyearTotalscore()) {
            String behaviorsEndyearTotalscore = appraisalPerformanceMaster.getBehaviorsEndyearTotalscore();
            request.setAttribute("behaviorsEndyearTotalscore", behaviorsEndyearTotalscore);
        }
        if (null != appraisalPerformanceMaster.getManagerActivityScore()) {
            String managerActivityScore = appraisalPerformanceMaster.getManagerActivityScore();
            request.setAttribute("managerActivityScore", managerActivityScore);
        }
//        if (null != appraisalPerformanceMaster.getManagerStatus()) {
        int managerStatus = appraisalPerformanceMaster.getManagerStatus();
        request.setAttribute("managerStatus", managerStatus);
//        }
//        if (null != appraisalPerformanceMaster.getManagerKraStatus()) {
        int managerKraStatus = appraisalPerformanceMaster.getManagerkraStatus();
        request.setAttribute("managerKraStatus", managerKraStatus);
        int Finalstatus = appraisalPerformanceMaster.getManagerStatus();
        request.setAttribute("Finalstatus", Finalstatus);
//        }
//        if (null != appraisalPerformanceMaster.getBehaviorsFinalscore()) {
//            String behaviorsFinalscore = appraisalPerformanceMaster.getBehaviorsFinalscore();
//            request.setAttribute("behaviorsFinalscore", behaviorsFinalscore);
//        }

        if (null != appraisalPerformanceMaster.getBehaviorsFinalscore() && !"NaN".equals(appraisalPerformanceMaster.getBehaviorsFinalscore())) {
            String behaviorsFinalscore = appraisalPerformanceMaster.getBehaviorsFinalscore();
            request.setAttribute("behaviorsFinalscore", behaviorsFinalscore);
        } else {
            String behaviorsFinalscore = "";
            request.setAttribute("behaviorsFinalscore", behaviorsFinalscore);

        }
//        } else {
//            String behaviorsFinalscore = "";
//            request.setAttribute("behaviorsFinalscore", behaviorsFinalscore);
//        }
//        int year = Calendar.getInstance().get(Calendar.YEAR);
//        List<?> l1 = appraisalFillingDataService.getCurrentAndPreviousYear();
//        String previousYear = "";
//        int currentYear = 0;
//        if (!l1.isEmpty()) {
//            Object[] obj = (Object[]) l1.get(0);
////            previousYear = (Integer) obj[0];
//            previousYear = "" + obj[0];
////            currentYear = (Integer) obj[1];
//        }
        // Changes
        int year = Integer.parseInt(request.getParameter("year"));
//        List<AppraisalFillingData> appraisalFilling = (List<AppraisalFillingData>) appraisalFillingDataService.readByCurrentY("" + year);
        List<AppraisalFillingData> appraisalFilling = (List<AppraisalFillingData>) appraisalFillingDataService.readByIdNew(year);

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String today = sdf.format(cal.getTime());

        Date now = sdf.parse(today);
        if (!appraisalFilling.isEmpty()) {
            AppraisalFillingData appraisalFillingData = (AppraisalFillingData) appraisalFilling.get(0);

//            String StartDate = appraisalFillingData.getStartDate();
//            String EndDate = appraisalFillingData.getEndDate();
//            String MidDate = appraisalFillingData.getMidYearStartDate();
//            String MidEndDate = appraisalFillingData.getMidYearEndDate();
            String YearEndStartDate = appraisalFillingData.getYearEndStartDate();
            String YearEndDate = appraisalFillingData.getYearEndEndDate();
//            Date strDate = sdf.parse(StartDate);
//            Date eDate = sdf.parse(EndDate);
//            Date midDate = sdf.parse(MidDate);
//            Date midEndDate = sdf.parse(MidEndDate);
            Date yearEndStartDate = sdf.parse(YearEndStartDate);
            Date yearEndDate = sdf.parse(YearEndDate);
//            boolean flag = false;
//            boolean flag1 = false;
//            boolean flag2 = false;
//            if ((now.after(strDate) && now.before(eDate)) || now.equals(strDate) || now.equals(eDate)) {
//                flag = true;
//            } else if ((now.after(midDate) && now.before(midEndDate)) || now.equals(midDate) || now.equals(midEndDate)) {
//                flag1 = true;
//            } else if ((now.after(yearEndStartDate) && now.before(yearEndDate)) || now.equals(yearEndStartDate) || now.equals(yearEndDate)) {
//                flag2 = true;
//            }
//
//            request.setAttribute("flag", flag);
//            request.setAttribute("flag1", flag1);
//            request.setAttribute("flag2", flag2);
            //////////////////////Manager Time Line//////////////////////////////////////////
//            String ManagerStartDate = appraisalFillingData.getManagerStartDate();
//            String ManagerEndDate = appraisalFillingData.getManagerEndDate();
//            String ManagerMidDate = appraisalFillingData.getManagerMidYearStartDate();
//            String ManagerMidEndDate = appraisalFillingData.getManagerMidYearEndDate();
//            String ManagerYearEndStartDate = appraisalFillingData.getManagerYearEndStartDate();
//            String ManagerYearEndDate = appraisalFillingData.getManagerYearEndEndDate();
//            Date managerstrDate = sdf.parse(ManagerStartDate);
//            Date managerendDate = sdf.parse(ManagerEndDate);
//            Date managermidDate = sdf.parse(ManagerMidDate);
//            Date managermidEndDate = sdf.parse(ManagerMidEndDate);
//            Date manageryearEndStartDate = sdf.parse(ManagerYearEndStartDate);
//            Date manageryearEndDate = sdf.parse(ManagerYearEndDate);
            boolean flag = false;
            boolean flag1 = false;
            boolean flag2 = false;
//            if (goalSetting.equals("Approved") && (goalApproval.equals("Pendding") || goalApproval.equals("Expired"))) {
//            if ((now.after(managerstrDate))|| now.equals(managerstrDate)) {
            flag = true;
//            } //              } else if(midSelfApproval.equals("Approved") && ( managerMidSelfApproval.equals("Pendding") ||managerMidSelfApproval.equals("Expired"))){
            //            if ((now.after(managermidDate)) || now.equals(managermidDate)) {
            //                flag1 = true;
            //            }
            //              }
//            else
//            if (endSelfApproval.equals("Approved") && (managerEndSelfApproval.equals("Pendding") || managerEndSelfApproval.equals("Expired"))) {
//            if (((now.after(yearEndStartDate)) && (now.before(yearEndDate))) || now.equals(yearEndStartDate)
            if (((now.after(yearEndStartDate))) || now.equals(yearEndStartDate)
                    || (now.equals(yearEndDate))) {
                flag2 = true;
                flag = false;
            }
//            }
            ////////////////////new code for check flag value
            boolean Tflag = false;

//            if (goalSetting.equals("Approved") && (goalApproval.equals("Pendding") || goalApproval.equals("Expired"))) {
//
//                Tflag = true;
//            }
            Tflag = true;
//
            request.setAttribute("Tflag", Tflag);

//              }
//            if ((now.after(managerstrDate) && now.before(managerendDate)) || now.equals(managerstrDate) || now.equals(managerendDate)) {
//                flag = true;
//            } else if ((now.after(managermidDate) && now.before(managermidEndDate)) || now.equals(managermidDate) || now.equals(managermidEndDate)) {
//                flag1 = true;
//            } else if ((now.after(manageryearEndStartDate) && now.before(manageryearEndDate)) || now.equals(manageryearEndStartDate) || now.equals(manageryearEndDate)) {
//                flag2 = true;
//            }
            request.setAttribute("flag", flag);
            request.setAttribute("flag1", flag1);
            request.setAttribute("flag2", flag2);
        }
        // Changes

//        List<?> list = appraisalPerformanceService.readByAppraisalPerformanceId(employeeId);
//        List<?> list = appraisalPerformanceService.readByAppraisalPerformanceId(employeeId, year);
        List<?> list = appraisalPerformanceService.readByAppraisalPerformanceId(employeeId, Integer.parseInt("" + year));
        if (!list.isEmpty()) {

            appraisalPerformanceMaster = (AppraisalPerformanceMaster) list.get(0);
            int appraisalId = appraisalPerformanceMaster.getId();
            //AppraisalPerformanceKra appraisalPerformanceKra = new AppraisalPerformanceKra();
            appraisalPerformanceKra.setId(appraisalId);
            String kragoal = "";
            String metric = "";
            //int weightage = 0;
            boolean updateStatus = false;
            int kragoalId;
            List<?> kraList = appraisalPerformanceKraService.readByAppraisalKraGoal(appraisalPerformanceKra);
            if (!kraList.isEmpty()) {
                appraisalPerformanceKra = (AppraisalPerformanceKra) kraList.get(0);
                kragoal = appraisalPerformanceKra.getKraGoal();
                kragoalId = appraisalPerformanceKra.getId();
                metric = appraisalPerformanceKra.getMetric();
                if (null != kragoal && !"".equals(kragoal)) {

                    UpdateAppraisalPerformanceKra updateAppraisalPerformanceKra1 = new UpdateAppraisalPerformanceKra();
                    updateAppraisalPerformanceKra.setId(Integer.parseInt("" + kragoalId));
                    List<?> updateAppraisalPerformanceKra1List = updateAppraisalPerformanceKraService.readByUserUpdateKra(updateAppraisalPerformanceKra);
                    if (!updateAppraisalPerformanceKra1List.isEmpty()) {

                        updateAppraisalPerformanceKra1 = (UpdateAppraisalPerformanceKra) updateAppraisalPerformanceKra1List.get(0);
                        if (!kragoal.equals(updateAppraisalPerformanceKra1.getUpdateKra()) || !metric.equals(updateAppraisalPerformanceKra1.getUpdateMetric())) {
                            updateStatus = true;
                        }
                    }
                }
            }
            request.setAttribute("updateStatus", updateStatus);
            request.setAttribute("kragoal", kraList);
//            request.setAttribute("kraGoalByManager", kraList);
            request.setAttribute("weightage", kraList);
            request.setAttribute("appraisalId", appraisalId);
            request.setAttribute("empMidyearSelfassessmentGoal", kraList);
            request.setAttribute("managerMidyearReviewEvaluation", kraList);
            request.setAttribute("midyearStatus", kraList);
            request.setAttribute("endyearStatus", kraList);
            request.setAttribute("empEndyearSelfassessmentGoal", kraList);
            request.setAttribute("editDate", kraList);
            request.setAttribute("startDate", kraList);
            request.setAttribute("year", request.getParameter("year"));

        }

        ////////////////////////////////////KRA OTHER Activity///////////////////////////////////////////////////////////
        String kragoal_activity = "";
        String metric_activity = "";
        boolean kraOtherupdateStatus = false;
        int kragoalactivityId;
        if (null != appraisalPerformanceMaster.getId()) {

            AppraisalPerformanceActivities appraisalPerformanceActivities = new AppraisalPerformanceActivities();
            appraisalPerformanceActivities.setAppraisalPerformanceMaster(appraisalPerformanceMaster);

            List<?> kraOtherList = appraisalPerformanceActivitiesService.readByAppraisalKraGoalActivities(appraisalPerformanceActivities);
            if (!kraOtherList.isEmpty()) {
                appraisalPerformanceActivities = (AppraisalPerformanceActivities) kraOtherList.get(0);
                kragoal_activity = appraisalPerformanceActivities.getKraGoalActivities();
                kragoalactivityId = appraisalPerformanceActivities.getId();
                metric_activity = appraisalPerformanceActivities.getMetricActivities();

                if (null != kragoal_activity && !"".equals(kragoal_activity)) {
                    UpdateAppraisalPerformanceActivities updateAppraisalPerformanceActivities = new UpdateAppraisalPerformanceActivities();
                    updateAppraisalPerformanceActivities.setId(Integer.parseInt("" + kragoalactivityId));
                    List<?> updateKraOtherList = updateAppraisalPerformanceActivitiesService.readByUserUpdateKraOther(updateAppraisalPerformanceActivities);
                    if (!updateKraOtherList.isEmpty()) {

                        updateAppraisalPerformanceActivities = (UpdateAppraisalPerformanceActivities) updateKraOtherList.get(0);
                        if (!kragoal_activity.equals(updateAppraisalPerformanceActivities.getKraActivity()) || !metric_activity.equals(updateAppraisalPerformanceActivities.getMetricActivity())) {
                            kraOtherupdateStatus = true;
                        }
                    }
                }
            }
            request.setAttribute("kraOtherupdateStatus", kraOtherupdateStatus);
            request.setAttribute("kragoalOtherActivity", kraOtherList);
        }
        ////////////////////////////////////KRA OTHER Activity//////////////////////////////////////////////////////////

//        // =======================competency Evaluation=change by date 11/11/2016=========================================================//
//        competencyList(request);
//        int competencyId = 0;
//        AppraisalPerformanceCompetencyEvaluation appraisalPerformanceCompetencyEvaluation = new AppraisalPerformanceCompetencyEvaluation();
//        appraisalPerformanceCompetencyEvaluation.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
//        CompetencyEvaluationTextmaster competencyEvaluationTextmaster = new CompetencyEvaluationTextmaster();
//        List<?> competencyEvaluationList = appraisalPerformanceCompetencyEvaluationService.readAppraisalPerformanceCompetencyEvaluationDetail(appraisalPerformanceCompetencyEvaluation);
//
//        request.setAttribute("competencyEvaluationList", competencyEvaluationList);
//        //Individual Development Plan change by date 11/11/2016//
//        AppraisalPerformanceIndividualDevelopmentPlan appraisalPerformanceIndividualDevelopmentPlan = new AppraisalPerformanceIndividualDevelopmentPlan();
//        appraisalPerformanceIndividualDevelopmentPlan.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
//        String text1 = "";
//        List<?> individualDevelopmentPlanList = appraisalPerformanceIndividualDevelopmentPlanService.readIndividualDevelopmentPlanDetail(appraisalPerformanceIndividualDevelopmentPlan);
//        if (!individualDevelopmentPlanList.isEmpty()) {
//            appraisalPerformanceIndividualDevelopmentPlan = (AppraisalPerformanceIndividualDevelopmentPlan) individualDevelopmentPlanList.get(0);
//            text1 = appraisalPerformanceIndividualDevelopmentPlan.getText1();
//        }
//        request.setAttribute("text1", individualDevelopmentPlanList);
//        request.setAttribute("text2", individualDevelopmentPlanList);
//        request.setAttribute("text3", individualDevelopmentPlanList);
//        request.setAttribute("remark", individualDevelopmentPlanList);
//        request.setAttribute("midYearRemark", individualDevelopmentPlanList);
//        request.setAttribute("endYearRemark", individualDevelopmentPlanList);
//        request.setAttribute("individualDevelopmentPlanList", individualDevelopmentPlanList);
        //////////Behaviors///////////////
        AppraisalPerformanceBehaviors appraisalPerformanceBehaviors = new AppraisalPerformanceBehaviors();
        String behaviors = "";
        appraisalPerformanceBehaviors.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
        List<?> behaviorsList = appraisalPerformanceBehaviorsService.readBehaviorsDetail(appraisalPerformanceBehaviors);
        if (!behaviorsList.isEmpty()) {
            appraisalPerformanceBehaviors = (AppraisalPerformanceBehaviors) behaviorsList.get(0);
            behaviors = appraisalPerformanceBehaviors.getBehaviors();
        }
        request.setAttribute("behaviors", behaviorsList);
        request.setAttribute("behaviorsList", behaviorsList);

        mv.getModelMap().put("appraisalPerformanceMaster", appraisalPerformanceMaster);
//        mv.setViewName("Appraisal/PerformanceAppraisalForm");
//        if (year == 2016) {
//
//            mv.setViewName("Appraisal/ManagerPerformanceAppraisalForm");
//        } else {
        mv.setViewName("Appraisal/ManagerPerformanceAppraisalForm2017Onwards");
//        }
//        mv.setViewName("forward:userMaster.htm?act=userDashboard");
        return mv;
    }

    public ModelAndView deleteSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String empId[] = request.getParameterValues("checkId");
        for (String z : empId) {
            try {
                appraisalPerformanceService.delete(Integer.parseInt(z));
                //userMasterService.delete(Integer.parseInt(z));
                //userRightMasterService.delete(Integer.parseInt(z));
                request.setAttribute("successMessage",
                        "Info : One or more records are deleted successfully.");
            } catch (Exception e) {

            }
        }
        mv = searchSubmit(request, response);
        return mv;
    }

    public ModelAndView createSubmitManager(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AppraisalPerformanceMaster appraisalPerformanceMaster = new AppraisalPerformanceMaster();
        AppraisalPerformanceKra appraisalPerformanceKra = new AppraisalPerformanceKra();
        AppraisalPerformanceKra appraisalPerformanceKra1 = new AppraisalPerformanceKra();
        UpdateAppraisalPerformanceActivities updateAppraisalPerformanceActivities = new UpdateAppraisalPerformanceActivities();
        AppraisalPerformanceActivities appraisalPerformanceActivities = new AppraisalPerformanceActivities();
        AppraisalPerformanceActivities appraisalPerformanceActivities1 = new AppraisalPerformanceActivities();
        UpdateAppraisalPerformanceKra updateAppraisalPerformanceKra = new UpdateAppraisalPerformanceKra();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employee = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");//====edit by Admin=======//
        String appraisalId = request.getParameter("appraisalId");
        String employeeNo = request.getParameter("employeeNo");
        List l = employeeMasterService.readByEmployeeId(employeeNo);
        employeeMaster = (EmployeeMaster) l.get(0);
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        BindException errors = new BindException(appraisalPerformanceMaster, "appraisalPerformanceMaster");
        PmpFormStatusMaster pmpFormStatusMaster = new PmpFormStatusMaster();
        KraCategory kraCategory = new KraCategory();
        String year = request.getParameter("yearparmStr");
//        List appraisalFillingDataList1 = appraisalFillingDataService.readByCurrentYear(year);
        List appraisalFillingDataList1 = appraisalFillingDataService.readByIdNew(Integer.parseInt(year));
        AppraisalFillingData appraisalFillingData1 = (AppraisalFillingData) appraisalFillingDataList1.get(0);
//        selectedDateflage(request,response);
        appraisalPerformanceValidator.validate(appraisalPerformanceMaster, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv.addAllObjects(errors.getModel());
        } else {
            // String employeeId = "" + employee.getId();
            String employeeName = "" + employee.getEmployeeName();//====edit by Admin=======//
            // List<?> list = appraisalPerformanceService.readByAppraisalPerformanceId(employeeId);
            // if (!list.isEmpty()) {

            String firsthalf = request.getParameter("flagId");
//            String midhalf = request.getParameter("flagMidId");
            String endhalf = request.getParameter("flagEndId");
//            Date endEndDate = dateFormat.parse(appraisalFillingData1.getMidYearStartDate());
            Date joindate = dateFormat.parse(employeeMaster.getDateOfJoining());
//            if (endEndDate.before(joindate)) {
//            midhalf = "true";
//            }
//            if()
//            String btn = request.getParameter("submit");
//            if (null != btn && btn.equals("submit")) {
//                appraisalPerformanceMaster.setStatus(1);
//                appraisalPerformanceService.update(appraisalPerformanceMaster);
//            } else {
//                appraisalPerformanceMaster.setStatus(0);
//                appraisalPerformanceService.update(appraisalPerformanceMaster);
//            }
            //appraisalPerformanceMaster = (AppraisalPerformanceMaster) list.get(0);
            //String appraisalId = "" + appraisalPerformanceMaster.getId();
            //appraisalPerformanceMaster.setId(Integer.parseInt(appraisalId));
            //appraisalPerformanceKra.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
            //}
            // if (null == appraisalPerformanceMaster.getId()) {
            //  appraisalPerformanceMaster.setEmployeeMaster(employee);
            //  appraisalPerformanceService.create(appraisalPerformanceMaster);
            //  }
            //StartDate To create FirstTime//
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date now = new Date();
            String strDate = sdf1.format(now);
            String today = sdf.format(cal.getTime());
            String startdate = "" + today;

//            =========if appraisalPerformance is create and after get id=======//
            appraisalPerformanceMaster = appraisalPerformanceService.readById(Integer.parseInt(appraisalId));
            appraisalPerformanceMaster.getEmployeeMaster().getId();
            appraisalPerformanceKra.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
            String btn5 = request.getParameter("submit");
            if (null != btn5 && btn5.equals("submit")) {
                String weightageScore = (request.getParameter("weightageScore"));

                if (weightageScore != null) {
                    appraisalPerformanceMaster.setWeightageScoreManager(weightageScore);
                } else {
                    appraisalPerformanceMaster.setWeightageScoreManager(null);
                }
                if (weightageScore != null) {
                    appraisalPerformanceMaster.setWeightageScore(weightageScore);
                } else {
                    appraisalPerformanceMaster.setWeightageScore(null);
                }

            } else {
                String weightageScore = (request.getParameter("weightageScore"));
                if (weightageScore != null) {
                    appraisalPerformanceMaster.setWeightageScoreManager(weightageScore);
                } else {
                    appraisalPerformanceMaster.setWeightageScoreManager(null);
                }
            }
//            if (request.getParameter("weightageScore") != null && !request.getParameter("weightageScore").equals("")) {
//                float weightageScore = Float.parseFloat(request.getParameter("weightageScore"));
//                if (weightageScore <= 75) {
//                    appraisalPerformanceMaster.setWeightageScore("" + weightageScore);
//                    //appraisalPerformanceService.update(appraisalPerformanceMaster);
//                } else {
//                    request.setAttribute("failureMessage", "Error : weightageScore is above 75.");
//                    mv.addAllObjects(errors.getModel());
//                }
//            }
            String totalScore = (request.getParameter("totalScore"));
            if (totalScore != null) {
                appraisalPerformanceMaster.setTotalScore(totalScore);
            } else {
                appraisalPerformanceMaster.setTotalScore(null);
            }
            int countId = Integer.parseInt(request.getParameter("countId"));
//            String btn5 = request.getParameter("submit");
            if (null != btn5 && btn5.equals("submit")) {

                String kraremovedIdVal = request.getParameter("kraremovedIdVal");
                if (!kraremovedIdVal.isEmpty()) {
                    for (String id : kraremovedIdVal.split(",")) {
                        if (!id.equals("")) {
                            AppraisalPerformanceKra appraisalPerformanceKra2 = new AppraisalPerformanceKra();
                            UpdateAppraisalPerformanceKra updateAppraisalPerformanceKra1 = new UpdateAppraisalPerformanceKra();
                            AppraisalKraActivity appraisalkraActivity = new AppraisalKraActivity();
                            appraisalkraActivity.setAppraisalPerformanceMaster(appraisalPerformanceMaster);

                            appraisalPerformanceKra2.setId(Integer.parseInt(id));
                            appraisalPerformanceKra2 = appraisalPerformanceKraService.readById(appraisalPerformanceKra2.getId());
                            appraisalkraActivity.setDeletedKra(appraisalPerformanceKra2.getKraGoal());
                            appraisalkraActivity.setDeletedMetric(appraisalPerformanceKra2.getMetric());
                            appraisalkraActivity.setDeletedWeightage("" + appraisalPerformanceKra2.getWeightage());
                            appraisalkraActivity.setDeletedBy(employeeName);
                            appraisalkraActivity.setStatus("KRAGOAL");
                            appraisalkraActivity.setKraDeletedDate(today);
                            appraisalkraActivityService.create(appraisalkraActivity);

                            updateAppraisalPerformanceKra1.setAppraisalPerformanceKra(appraisalPerformanceKra2);
                            List updatedKraList = updateAppraisalPerformanceKraService.readByKraIdForDelete(updateAppraisalPerformanceKra1);
                            for (Object obj : updatedKraList) {
                                updateAppraisalPerformanceKra1 = (UpdateAppraisalPerformanceKra) obj;
                                updateAppraisalPerformanceKraService.delete(updateAppraisalPerformanceKra1.getId());
                            }

                            appraisalPerformanceKraService.delete1(appraisalPerformanceKra2);
                        }
                    }
                }
            }

            for (int i = 1; i <= countId; i++) {
                String kragoal_id = request.getParameter("kragoal_id" + i);
                if (null != kragoal_id) {
                    appraisalPerformanceKra = appraisalPerformanceKraService.readById(Integer.parseInt(kragoal_id));
                }
                String kraGoal1 = request.getParameter("kraGoal" + i);
                String metric1 = request.getParameter("metric" + i);
                String kraCategoryMap = request.getParameter("kraCategoryMap" + i);
                String weightage1 = request.getParameter("weightage" + i);
                String finalScore = request.getParameter("finalScore" + i);
//                String midYearDiv1 = request.getParameter("midYearDiv" + i);
                String endYearDiv1 = request.getParameter("endYearDiv" + i);
//                String employeeMidYearSelfAssesssmentGoal = request.getParameter("employeeMidYearSelfAssesssmentGoal" + i);
//                String empMidyearSelfassOtheractivty = request.getParameter("empMidyearSelfassOtheractivty");
                String employeeEndYearSelfAssesssmentGoal = request.getParameter("employeeEndYearSelfAssesssmentGoal" + i);
//                String managerMidYearSelfAssesssmentGoal = request.getParameter("managerMidYearSelfAssesssmentGoal" + i);
                //String managerMidyearReviewevalOtheractivity = request.getParameter("managerMidyearReviewevalOtheractivity");
                String managerEndYearSelfAssesssmentGoal = request.getParameter("managerEndYearSelfAssesssmentGoal" + i);
                //String managerEndyearReviewevalOtheractivity = request.getParameter("managerEndyearReviewevalOtheractivity");
                String startDate1 = request.getParameter("startDate" + i);
//                if (null != kragoal_id) {
//                    appraisalPerformanceKra = appraisalPerformanceKraService.readById(Integer.parseInt(kragoal_id));
//                }
                if (!"".equals(startDate1) && null != startDate1) {
                    appraisalPerformanceKra.setStartDate(startDate1);
                } else {
                    appraisalPerformanceKra.setStartDate(null);
                }
                if (!"".equals(weightage1) && null != weightage1) {
                    appraisalPerformanceKra.setWeightageManager(Float.parseFloat(weightage1));
                } else {
                    appraisalPerformanceKra.setWeightageManager(null);
                }
                if (!"".equals(finalScore) && null != finalScore) {
                    appraisalPerformanceKra.setFinalScoreManager(finalScore);
                } else {
                    appraisalPerformanceKra.setFinalScoreManager(null);
                }
//                if (!"".equals(managerMidYearSelfAssesssmentGoal) && null != managerMidYearSelfAssesssmentGoal) {
//                    appraisalPerformanceKra.setManagerMidyearReviewEvaluationManager(managerMidYearSelfAssesssmentGoal);
//                } else {
//                    appraisalPerformanceKra.setManagerMidyearReviewEvaluationManager(null);
//                }
//                if (!"".equals(managerMidyearReviewevalOtheractivity) && null != managerMidyearReviewevalOtheractivity) {
//                    appraisalPerformanceMaster.setManagerMidyearReviewevalOtheractivity(managerMidyearReviewevalOtheractivity);
//                } else {
//                    appraisalPerformanceMaster.setManagerMidyearReviewevalOtheractivity(null);
//                }

//                if (!"".equals(midYearDiv1) && null != midYearDiv1) {
//                    appraisalPerformanceKra.setMidyearStatusManager(midYearDiv1);
//                } else {
//                    appraisalPerformanceKra.setMidyearStatusManager(null);
//                }
//                if (!"".equals(employeeMidYearSelfAssesssmentGoal) && null != employeeMidYearSelfAssesssmentGoal && firsthalf.equals("false")) {
//                    appraisalPerformanceKra.setEmpMidyearSelfassessmentGoalManager(employeeMidYearSelfAssesssmentGoal);
//                } else {
//                    appraisalPerformanceKra.setEmpMidyearSelfassessmentGoalManager(employeeMidYearSelfAssesssmentGoal);
//                }
//                if (!"".equals(empMidyearSelfassOtheractivty) && null != empMidyearSelfassOtheractivty) {
//
//                    appraisalPerformanceMaster.setEmpMidyearSelfassOtheractivty(empMidyearSelfassOtheractivty);
//                    appraisalPerformanceService.update(appraisalPerformanceMaster);
//                } else {
//                    appraisalPerformanceMaster.setEmpMidyearSelfassOtheractivty(null);
//                }
                //=======Mid year=======================================//
                //=======End  year=======================================//
                if (!"".equals(endYearDiv1) && null != endYearDiv1) {
                    appraisalPerformanceKra.setEndyearStatus(endYearDiv1);
                } else {
                    appraisalPerformanceKra.setEndyearStatus(null);
                }

                if (!"".equals(employeeEndYearSelfAssesssmentGoal) && null != employeeEndYearSelfAssesssmentGoal && firsthalf.equals("false")) {
                    appraisalPerformanceKra.setEmpEndyearSelfassessmentGoalManager(employeeEndYearSelfAssesssmentGoal);
                } else {
                    appraisalPerformanceKra.setEmpEndyearSelfassessmentGoalManager(null);
                }
                if (!"".equals(managerEndYearSelfAssesssmentGoal) && null != managerEndYearSelfAssesssmentGoal && firsthalf.equals("false")) {
                    appraisalPerformanceKra.setManagerEndyearReviewEvaluationManager(managerEndYearSelfAssesssmentGoal);
                } else {
                    appraisalPerformanceKra.setManagerEndyearReviewEvaluationManager(null);
                }
//                if (!"".equals(managerEndyearReviewevalOtheractivity) && null != managerEndyearReviewevalOtheractivity) {
//                    appraisalPerformanceMaster.setManagerEndyearReviewevalOtheractivity(managerEndyearReviewevalOtheractivity);
//                } else {
//                    appraisalPerformanceMaster.setManagerEndyearReviewevalOtheractivity(null);
//                }
                //====edit by Admin=======//

                appraisalPerformanceKra.setEditedBy(employeeName);
                String btn = request.getParameter("save");
                if (null != btn && btn.equals("save")) {

                    ////kra goal and matric set by first time save////
                    //appraisalPerformanceKra = appraisalPerformanceKraService.readById(Integer.parseInt(kragoal_id));
                    appraisalPerformanceKra.setKraGoalByManager(kraGoal1);
                    appraisalPerformanceKra.setMatrixByManager(metric1);
                    appraisalPerformanceKra.setEditDate(startdate);
                    if (!"".equals(kraCategoryMap) && null != kraCategoryMap) {
                        //KraCategory kraCategory = new KraCategory();
                        kraCategory.setId(Integer.parseInt(kraCategoryMap));
                        appraisalPerformanceKra.setKraCategoryByKraCategoryByManager(kraCategory);

                    }
                    if (kragoal_id != null) {
                        appraisalPerformanceKra.setId(Integer.parseInt(kragoal_id));
                        appraisalPerformanceKraService.update(appraisalPerformanceKra);
                    } else {
                        appraisalPerformanceKraService.create(appraisalPerformanceKra);
                    }
                    request.setAttribute("successMessage",
                            "Information : The Information is Saved Successfully.");

                    ////////////////////////////////////////////////
                } else {
                    appraisalPerformanceKra.setKraGoal(kraGoal1);
                    appraisalPerformanceKra.setMetric(metric1);
                    appraisalPerformanceKra.setKraGoalByManager(kraGoal1);
                    appraisalPerformanceKra.setMatrixByManager(metric1);
                    appraisalPerformanceKra.setEditDate(startdate);
//                    if (midhalf.equals("true") || endEndDate.before(joindate)) {
//                        appraisalPerformanceKra.setMidyearEmpSelfassStatus(1);
//                        appraisalPerformanceKra.setMidyearManagerSelfassStatus(1);
//                    }
//                        if (midhalf.equals("true")) {
//                            appraisalPerformanceKra.setMidyearEmpSelfassStatus(1);
//                            appraisalPerformanceKra.setMidyearManagerSelfassStatus(1);
//                        }
                    if (endhalf.equals("true")) {
                        appraisalPerformanceKra.setEndyearEmpSelfassStatus(1);
                        appraisalPerformanceKra.setEndyearManagerSelfassStatus(1);
                    }

                    if (!"".equals(kraCategoryMap) && null != kraCategoryMap) {
                        //KraCategory kraCategory = new KraCategory();
                        kraCategory.setId(Integer.parseInt(kraCategoryMap));
                        appraisalPerformanceKra.setKraCategoryByKraCategoryByEmployee(kraCategory);
                        appraisalPerformanceKra.setKraCategoryByKraCategoryByManager(kraCategory);
                    }
                    //history code
                    int kragoalId = appraisalPerformanceKra.getId();
                    appraisalPerformanceKra1 = appraisalPerformanceKraService.readById(kragoalId);
                    updateAppraisalPerformanceKra.setAppraisalPerformanceKra(appraisalPerformanceKra1);
                    updateAppraisalPerformanceKra.setUpdateDate(startdate);
                    updateAppraisalPerformanceKra.setUpdateKra(appraisalPerformanceKra1.getKraGoal());
                    updateAppraisalPerformanceKra.setUpdateMetric(appraisalPerformanceKra1.getMetric());
                    updateAppraisalPerformanceKra.setName(employee.getEmployeeName());
                    updateAppraisalPerformanceKra.setWeighted("" + appraisalPerformanceKra1.getWeightage());

                    if (!"".equals(startDate1) && null != startDate1) {
                        appraisalPerformanceKra.setStartDate(startDate1);
                    } else {
                        appraisalPerformanceKra.setStartDate(null);
                    }
                    if (!"".equals(weightage1) && null != weightage1) {
                        appraisalPerformanceKra.setWeightage(Float.parseFloat(weightage1));
                    } else {
                        appraisalPerformanceKra.setWeightage(null);
                    }
                    if (!"".equals(finalScore) && null != finalScore) {
                        appraisalPerformanceKra.setFinalScore(finalScore);
                    } else {
                        appraisalPerformanceKra.setFinalScore(null);
                    }

                    ////////////employee side code/////////////////////////
//                    if (!"".equals(managerMidYearSelfAssesssmentGoal) && null != managerMidYearSelfAssesssmentGoal && firsthalf.equals("false")) {
//                        appraisalPerformanceKra.setManagerMidyearReviewEvaluation(managerMidYearSelfAssesssmentGoal);
//                    } else {
//                        appraisalPerformanceKra.setManagerMidyearReviewEvaluation(null);
//                    }
//
//                    if (!"".equals(midYearDiv1) && null != midYearDiv1) {
//                        appraisalPerformanceKra.setMidyearStatus(midYearDiv1);
//                    } else {
//                        appraisalPerformanceKra.setMidyearStatus(null);
//                    }
//                    if (!"".equals(employeeMidYearSelfAssesssmentGoal) && null != employeeMidYearSelfAssesssmentGoal && firsthalf.equals("false")) {
//                        appraisalPerformanceKra.setEmpMidyearSelfassessmentGoal(employeeMidYearSelfAssesssmentGoal);
//                    } else {
//                        appraisalPerformanceKra.setEmpMidyearSelfassessmentGoal(employeeMidYearSelfAssesssmentGoal);
//                    }
//                       //=======Mid year=======================================//
//                        //=======End  year=======================================//
                    if (!"".equals(endYearDiv1) && null != endYearDiv1) {
                        appraisalPerformanceKra.setEndyearStatus(endYearDiv1);
                    } else {
                        appraisalPerformanceKra.setEndyearStatus(null);
                    }

                    if (!"".equals(employeeEndYearSelfAssesssmentGoal) && null != employeeEndYearSelfAssesssmentGoal && firsthalf.equals("false")) {
                        appraisalPerformanceKra.setEmpEndyearSelfassessmentGoal(employeeEndYearSelfAssesssmentGoal);
                    } else {
                        appraisalPerformanceKra.setEmpEndyearSelfassessmentGoal(null);
                    }
                    if (!"".equals(managerEndYearSelfAssesssmentGoal) && null != managerEndYearSelfAssesssmentGoal && firsthalf.equals("false")) {
                        appraisalPerformanceKra.setManagerEndyearReviewEvaluation(managerEndYearSelfAssesssmentGoal);
                    } else {
                        appraisalPerformanceKra.setManagerEndyearReviewEvaluation(null);
                    }
                    ////Match the Kra goal and update it////////
                    if (appraisalPerformanceKra1.getKraGoal().equals(appraisalPerformanceKra.getKraGoal())) {

                    } else {
                        updateAppraisalPerformanceKraService.create(updateAppraisalPerformanceKra);

                    }

                    if (kragoal_id != null) {
                        appraisalPerformanceKra.setId(Integer.parseInt(kragoal_id));
                        appraisalPerformanceKraService.update(appraisalPerformanceKra);
                    } else {
                        appraisalPerformanceKraService.create(appraisalPerformanceKra);
                    }
                    ///////    Upadte history Detail     /////////
                    request.setAttribute("successMessage",
                            "Information : The Information is Approved Successfully.");
//                    }
                }

//                if (!"".equals(kraGoal1) && null != kraGoal1) {
//                    if (null != kragoal_id) {
//                        appraisalPerformanceKra1 = appraisalPerformanceKraService.readById(Integer.parseInt(kragoal_id));
////                        //=======Mid year========================================//
//
//                        //=======End  year=======================================//
//                        appraisalPerformanceKra.setId(Integer.parseInt(kragoal_id));
//                        appraisalPerformanceKra.setEditDate(startdate);
//                        appraisalPerformanceKraService.update(appraisalPerformanceKra);
//                        appraisalPerformanceService.update(appraisalPerformanceMaster);//mid year//
//                        ///////    Upadte history Detail    /////////
//                        updateAppraisalPerformanceKra.setAppraisalPerformanceKra(appraisalPerformanceKra);
//                        updateAppraisalPerformanceKra.setUpdateDate(startdate);
//                        updateAppraisalPerformanceKra.setUpdateKra(kraGoal1);
//                        updateAppraisalPerformanceKra.setUpdateMetric(metric1);
//                        ///////    Upadte history Detail    /////////
//                        ////Match the Kra goal and update it////////
//                        if (appraisalPerformanceKra1.getKraGoal().equals(appraisalPerformanceKra.getKraGoal())) {
//
//                        } else {
//
//                            updateAppraisalPerformanceKraService.create(updateAppraisalPerformanceKra);
//
//                        }
//                        appraisalPerformanceKraService.update(appraisalPerformanceKra);
////
//                        request.setAttribute("successMessage",
//                                "Information : The Information is Updated Successfully.");
////                        updateAppraisalPerformanceKraService.create(updateAppraisalPerformanceKra);
////                        request.setAttribute("successMessage",
////                                "Information : The Information is Updated Successfully.");
//                    } else {
//
//                        appraisalPerformanceKra.setStartDate(startdate);
//                        if (null != btn && btn.equals("save")) {
//                            appraisalPerformanceKra.setKraGoal("");
//                            appraisalPerformanceKra.setMetric("");
//                        }
//                        appraisalPerformanceKraService.create(appraisalPerformanceKra);
//                        int kragoalId = appraisalPerformanceKra.getId();
//                        appraisalPerformanceKra.setId(kragoalId);
////                        ///////    Upadte history Detail    /////////
//                        //appraisalPerformanceKra.setId(Integer.parseInt(kragoalId));
//                        updateAppraisalPerformanceKra.setAppraisalPerformanceKra(appraisalPerformanceKra);
//                        updateAppraisalPerformanceKra.setUpdateDate(startdate);
//                        updateAppraisalPerformanceKra.setUpdateKra(kraGoal1);
//                        updateAppraisalPerformanceKra.setUpdateMetric(metric1);
//                        updateAppraisalPerformanceKraService.create(updateAppraisalPerformanceKra);
//                        ///////    Upadte history Detail     /////////
//                        request.setAttribute("successMessage",
//                                "Information : The Information is saved Successfully.");
//                    }
//                }
            }
//            if (Integer.parseInt(year) == 2016) {
//
//                String btn3 = request.getParameter("submit");
//                if (null != btn3 && btn3.equals("submit")) {
//                    String kraremovedActivitiesIdVal = request.getParameter("kraremovedActivitiesIdVal");
//                    if (!kraremovedActivitiesIdVal.isEmpty()) {
//                        for (String id : kraremovedActivitiesIdVal.split(",")) {
//                            if (!id.equals("")) {
//                                AppraisalPerformanceActivities appraisalPerformanceActivities2 = new AppraisalPerformanceActivities();
//                                UpdateAppraisalPerformanceActivities updateAppraisalPerformanceActivities1 = new UpdateAppraisalPerformanceActivities();
//                                AppraisalKraActivity appraisalkraActivity = new AppraisalKraActivity();
//
//                                appraisalPerformanceActivities2.setId(Integer.parseInt(id));
//                                appraisalPerformanceActivities2 = appraisalPerformanceActivitiesService.readById(appraisalPerformanceActivities2.getId());
//
//                                appraisalkraActivity.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
//                                appraisalkraActivity.setDeletedKra(appraisalPerformanceActivities2.getKraGoalActivities());
//                                appraisalkraActivity.setDeletedMetric(appraisalPerformanceActivities2.getMetricActivities());
//                                appraisalkraActivity.setDeletedWeightage("");
//                                appraisalkraActivity.setDeletedBy(employeeName);
//                                appraisalkraActivity.setStatus("ACTIVITIES");
//                                appraisalkraActivity.setKraDeletedDate(today);
//                                appraisalkraActivityService.create(appraisalkraActivity);
//
//                                updateAppraisalPerformanceActivities1.setAppraisalPerformanceActivities(appraisalPerformanceActivities2);
//                                List updatedActivitiesList = updateAppraisalPerformanceActivitiesService.readByKraIdForDeleteActivity(updateAppraisalPerformanceActivities1);
//                                for (Object activityObj : updatedActivitiesList) {
//                                    updateAppraisalPerformanceActivities1 = (UpdateAppraisalPerformanceActivities) activityObj;
//                                    updateAppraisalPerformanceActivitiesService.delete(updateAppraisalPerformanceActivities1.getId());
//                                }
//
//                                appraisalPerformanceActivitiesService.delete1(appraisalPerformanceActivities2);
//                            }
//                        }
//                    }
//                }
//                ////////////////////////////////////KRA OTHER Activity///////////////////////////////////////////////////////////
//                int countActivityId = Integer.parseInt(request.getParameter("countactivityId"));
//                appraisalPerformanceActivities.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
//                //String kragoal_id = "";
//                for (int i = 1; i <= countActivityId; i++) {
//                    String kragoal_activity_id = request.getParameter("kragoal_activity_id" + i);
//
//                    String kraGoalactivity = request.getParameter("kraGoal_activity" + i);
//                    String metricactivity = request.getParameter("metric_activity" + i);
//                    String kraCategoryMapOther = request.getParameter("kraCategoryMapOther" + i);
//                    String priority = request.getParameter("priority" + i);
//                    String midYearDivOther = request.getParameter("midYearDivOther" + i);
//                    String endYearDivOther = request.getParameter("endYearDivOther" + i);
//                    String activity = request.getParameter("activity" + i);
//                    String empMidyearSelfassessmentGoalActivities = request.getParameter("empMidyearSelfassessmentGoalActivities" + i);
//                    String managerMidYearSelfAssesssmentGoalActivities = request.getParameter("managerMidYearSelfAssesssmentGoalActivities" + i);
//                    String empEndyearSelfassessmentGoalActivities = request.getParameter("empEndyearSelfassessmentGoalActivities" + i);
//                    String managerEndYearSelfAssesssmentGoalActivities = request.getParameter("managerEndYearSelfAssesssmentGoalActivities" + i);
//
//                    if (null != kragoal_activity_id) {
//                        appraisalPerformanceActivities = appraisalPerformanceActivitiesService.readById(Integer.parseInt(kragoal_activity_id));
//                    }
//                    if (null != kraGoalactivity && !kraGoalactivity.equals("") && !kraGoalactivity.equals("null")) {
//                        appraisalPerformanceActivities.setKraGoalActivitiesManager(kraGoalactivity);
//                    } else {
//                        appraisalPerformanceActivities.setKraGoalActivitiesManager(null);
//                    }
//
//                    if (null != metricactivity && !metricactivity.equals("") && !metricactivity.equals("null")) {
//                        appraisalPerformanceActivities.setMetricActivitiesManager(metricactivity);
//                    } else {
//                        appraisalPerformanceActivities.setMetricActivitiesManager(null);
//                    }
//                    if (null != priority && !priority.equals("") && !priority.equals("null")) {
//                        appraisalPerformanceActivities.setManagerPriority(priority);
//                    } else {
//                        appraisalPerformanceActivities.setManagerPriority(priority);
//                    }
//                    if (!"".equals(kraCategoryMapOther) && null != kraCategoryMapOther) {
//                        appraisalPerformanceActivities.setKraCategoryByManagerActivities(Integer.parseInt(kraCategoryMapOther));
//                    }
//                    if (null != midYearDivOther && !midYearDivOther.equals("")) {
//                        appraisalPerformanceActivities.setMidyearStatusActivitiesManager(midYearDivOther);
//                    } else {
//                        appraisalPerformanceActivities.setMidyearStatusActivitiesManager(null);
//                    }
//                    if (null != endYearDivOther && !endYearDivOther.equals("")) {
//                        appraisalPerformanceActivities.setEndyearStatusActivitiesManager(endYearDivOther);
//                    } else {
//                        appraisalPerformanceActivities.setEndyearStatusActivitiesManager(null);
//                    }
//                    if (null != activity && !activity.equals("")) {
//                        appraisalPerformanceActivities.setManagerActivity(activity);
//                    } else {
//                        appraisalPerformanceActivities.setManagerActivity(null);
//                    }
//                    if (null != empMidyearSelfassessmentGoalActivities && !empMidyearSelfassessmentGoalActivities.equals("")) {
//                        appraisalPerformanceActivities.setEmpMidyearSelfassessmentGoalActivitiesManager(empMidyearSelfassessmentGoalActivities);
//                    } else {
//                        appraisalPerformanceActivities.setEmpMidyearSelfassessmentGoalActivitiesManager(null);
//                    }
//                    if (null != managerMidYearSelfAssesssmentGoalActivities && !managerMidYearSelfAssesssmentGoalActivities.equals("")) {
//                        appraisalPerformanceActivities.setManagerMidyearSelfassesssmentGoalActivitiesManager(managerMidYearSelfAssesssmentGoalActivities);
//                    } else {
//                        appraisalPerformanceActivities.setManagerMidyearSelfassesssmentGoalActivitiesManager(null);
//                    }
//                    if (null != empEndyearSelfassessmentGoalActivities && !empEndyearSelfassessmentGoalActivities.equals("")) {
//                        appraisalPerformanceActivities.setEmpEndyearSelfassessmentGoalActivitiesManager(empEndyearSelfassessmentGoalActivities);
//                    } else {
//                        appraisalPerformanceActivities.setEmpEndyearSelfassessmentGoalActivitiesManager(null);
//                    }
//                    if (null != managerEndYearSelfAssesssmentGoalActivities && !managerEndYearSelfAssesssmentGoalActivities.equals("")) {
//                        appraisalPerformanceActivities.setManagerEndyearSelfassesssmentGoalActivitiesManager(managerEndYearSelfAssesssmentGoalActivities);
//                    } else {
//                        appraisalPerformanceActivities.setManagerEndyearSelfassesssmentGoalActivitiesManager(null);
//                    }
//                    String btn = request.getParameter("save");
//                    if (null != btn && btn.equals("save")) {
//
//                        ////kra goal and matric set by first time save////
////                    appraisalPerformanceActivities1 = appraisalPerformanceActivitiesService.readById(Integer.parseInt(kragoal_activity_id));
//                        if (kragoal_activity_id != null) {
//                            appraisalPerformanceActivities.setId(Integer.parseInt(kragoal_activity_id));
//                            appraisalPerformanceActivitiesService.update(appraisalPerformanceActivities);
//                        } else {
//                            appraisalPerformanceActivitiesService.create(appraisalPerformanceActivities);
//                        }
//                        request.setAttribute("successMessage",
//                                "Information : The Information is Saved Successfully.");
//
//                    } else {
//
//                        if (midhalf.equals("true") || endEndDate.before(joindate)) {
//                            appraisalPerformanceActivities.setMidyearEmpSelfassActivityStatus(1);
//                            appraisalPerformanceActivities.setMidyearManagerSelfassActivityStatus(1);
//                        }
////                            if (midhalf.equals("true")) {
////                                appraisalPerformanceActivities.setMidyearEmpSelfassActivityStatus(1);
////                                appraisalPerformanceActivities.setMidyearManagerSelfassActivityStatus(1);
////                            }
//                        if (endhalf.equals("true")) {
//                            appraisalPerformanceActivities.setEndyearEmpSelfassActivityStatus(1);
//                            appraisalPerformanceActivities.setEndyearManagerSelfassActivityStatus(1);
//                        }
//                        if (null != kraGoalactivity && !kraGoalactivity.equals("")) {
//                            appraisalPerformanceActivities.setKraGoalActivities(kraGoalactivity);
//                        } else {
//                            appraisalPerformanceActivities.setKraGoalActivities(null);
//                        }
//
//                        if (null != metricactivity && !metricactivity.equals("")) {
//                            appraisalPerformanceActivities.setMetricActivities(metricactivity);
//                        } else {
//                            appraisalPerformanceActivities.setMetricActivities(null);
//                        }
//
//                        if (null != kraCategoryMapOther && !"".equals(kraCategoryMapOther)) {
//                            appraisalPerformanceActivities.setKraCategoryByEmployeeActivities(Integer.parseInt(kraCategoryMapOther));
//                            appraisalPerformanceActivities.setKraCategoryByManagerActivities(Integer.parseInt(kraCategoryMapOther));
//                        }
//
//                        if (null != priority && !priority.equals("")) {
//                            appraisalPerformanceActivities.setPriority(priority);
//                        } else {
//                            appraisalPerformanceActivities.setPriority(priority);
//                        }
//
//                        if (null != midYearDivOther && !midYearDivOther.equals("")) {
//                            appraisalPerformanceActivities.setMidyearStatusActivities(midYearDivOther);
//                        } else {
//                            appraisalPerformanceActivities.setMidyearStatusActivities(null);
//                        }
//                        if (null != endYearDivOther && !endYearDivOther.equals("")) {
//                            appraisalPerformanceActivities.setEndyearStatusActivities(endYearDivOther);
//                        } else {
//                            appraisalPerformanceActivities.setEndyearStatusActivities(null);
//                        }
//                        if (null != activity && !activity.equals("")) {
//                            appraisalPerformanceActivities.setActivity(activity);
//                        } else {
//                            appraisalPerformanceActivities.setActivity(null);
//                        }
//                        if (null != empMidyearSelfassessmentGoalActivities && !empMidyearSelfassessmentGoalActivities.equals("")) {
//                            appraisalPerformanceActivities.setEmpMidyearSelfassessmentGoalActivities(empMidyearSelfassessmentGoalActivities);
//                        } else {
//                            appraisalPerformanceActivities.setEmpMidyearSelfassessmentGoalActivities(null);
//                        }
//                        if (null != managerMidYearSelfAssesssmentGoalActivities && !managerMidYearSelfAssesssmentGoalActivities.equals("")) {
//                            appraisalPerformanceActivities.setManagerMidyearSelfassesssmentGoalActivities(managerMidYearSelfAssesssmentGoalActivities);
//                        } else {
//                            appraisalPerformanceActivities.setManagerMidyearSelfassesssmentGoalActivities(null);
//                        }
//                        if (null != empEndyearSelfassessmentGoalActivities && !empEndyearSelfassessmentGoalActivities.equals("")) {
//                            appraisalPerformanceActivities.setEmpEndyearSelfassessmentGoalActivities(empEndyearSelfassessmentGoalActivities);
//                        } else {
//                            appraisalPerformanceActivities.setEmpEndyearSelfassessmentGoalActivities(null);
//                        }
//                        if (null != managerEndYearSelfAssesssmentGoalActivities && !managerEndYearSelfAssesssmentGoalActivities.equals("")) {
//                            appraisalPerformanceActivities.setManagerEndyearSelfassesssmentGoalActivities(managerEndYearSelfAssesssmentGoalActivities);
//                        } else {
//                            appraisalPerformanceActivities.setManagerEndyearSelfassesssmentGoalActivities(null);
//                        }
////                    appraisalPerformanceActivities1 = appraisalPerformanceActivitiesService.readById(Integer.parseInt(kragoal_activity_id));
////                    appraisalPerformanceActivities.setId(Integer.parseInt(kragoal_activity_id));
////                    appraisalPerformanceActivitiesService.update(appraisalPerformanceActivities);
//                        if (kragoal_activity_id != null) {
//                            appraisalPerformanceActivities.setId(Integer.parseInt(kragoal_activity_id));
//                            appraisalPerformanceActivitiesService.update(appraisalPerformanceActivities);
//                        } else {
//                            appraisalPerformanceActivitiesService.create(appraisalPerformanceActivities);
//                        }
//                        ////////////history code//////////////////
//                        updateAppraisalPerformanceActivities.setAppraisalPerformanceActivities(appraisalPerformanceActivities);
//                        updateAppraisalPerformanceActivities.setKraActivity(kraGoalactivity);
//                        updateAppraisalPerformanceActivities.setMetricActivity(metricactivity);
//                        updateAppraisalPerformanceActivities.setUpdateDate(startdate);
//
//                        if (null == appraisalPerformanceActivities1.getKraGoalActivities() || appraisalPerformanceActivities1.getKraGoalActivities().equals(appraisalPerformanceActivities.getKraGoalActivities())) {
//
//                        } else {
//                            updateAppraisalPerformanceActivitiesService.create(updateAppraisalPerformanceActivities);
//                        }
//
//                    }
//                }
//                if (!"".equals(kraGoalactivity) && null != kraGoalactivity) {
//                    if (null != kragoal_activity_id) {
//                        appraisalPerformanceActivities1 = appraisalPerformanceActivitiesService.readById(Integer.parseInt(kragoal_activity_id));
//                        appraisalPerformanceActivities.setId(Integer.parseInt(kragoal_activity_id));
//                        appraisalPerformanceActivitiesService.update(appraisalPerformanceActivities);
//                        ////////////history code//////////////////
//                        updateAppraisalPerformanceActivities.setAppraisalPerformanceActivities(appraisalPerformanceActivities);
//                        updateAppraisalPerformanceActivities.setKraActivity(kraGoalactivity);
//                        updateAppraisalPerformanceActivities.setMetricActivity(metricactivity);
//                        updateAppraisalPerformanceActivities.setUpdateDate(startdate);
//
//                        if (appraisalPerformanceActivities1.getKraGoalActivities().equals(appraisalPerformanceActivities.getKraGoalActivities())) {
//
//                        } else {
//                            updateAppraisalPerformanceActivitiesService.create(updateAppraisalPerformanceActivities);
//                        }
//
//                    } else {
//                        if (null != btn && btn.equals("save")) {
//                            appraisalPerformanceActivities.setKraGoalActivities("");
//                            appraisalPerformanceActivities.setMetricActivities("");
//                        }
//                        appraisalPerformanceActivitiesService.create(appraisalPerformanceActivities);
//                        ////////////history code//////////////////
//                        updateAppraisalPerformanceActivities.setAppraisalPerformanceActivities(appraisalPerformanceActivities);
//                        updateAppraisalPerformanceActivities.setKraActivity(activity);
//                        updateAppraisalPerformanceActivities.setMetricActivity(metricactivity);
//                        updateAppraisalPerformanceActivities.setUpdateDate(startdate);
//                        updateAppraisalPerformanceActivitiesService.create(updateAppraisalPerformanceActivities);
//                    }
//                }
//            }
//            String kraremovedIndividualIdVal = request.getParameter("kraremovedIndividualIdVal");
//            if (!kraremovedIndividualIdVal.isEmpty()) {
//                for (String id : kraremovedIndividualIdVal.split(",")) {
//                    if (!id.equals("")) {
//                        AppraisalPerformanceIndividualDevelopmentPlan appraisalPerformanceIndividualDevelopmentPlan2 = new AppraisalPerformanceIndividualDevelopmentPlan();
//                        appraisalPerformanceIndividualDevelopmentPlan2.setId(Integer.parseInt(id));
//                        appraisalPerformanceIndividualDevelopmentPlanService.delete1(appraisalPerformanceIndividualDevelopmentPlan2);
//                    }
//                }
//            }
//            ///////////////////////////Individual Development Plan//////////////////////////////////
//            AppraisalPerformanceIndividualDevelopmentPlan appraisalPerformanceIndividualDevelopmentPlan = new AppraisalPerformanceIndividualDevelopmentPlan();
//            int individualcount = Integer.parseInt(request.getParameter("IndividualId"));
//            for (int i = 1; i <= individualcount; i++) {
//
//                String text1 = request.getParameter("text" + i);
//                String text2 = request.getParameter("individualtextDiv" + i);
//                String text3 = request.getParameter("trainingSelectId" + i);
//                String remark = request.getParameter("trainingSelectTextinput" + i);
//                String midYearRemark = request.getParameter("midYearRemark" + i);
//                String endYearRemark = request.getParameter("endYearRemark" + i);
//                String managerMidYearRemark = request.getParameter("managerMidYearRemark" + i);
//                String managerEndYearRemark = request.getParameter("managerEndYearRemark" + i);
//                String individualplan = request.getParameter("IndividualDevelopmentPlanId" + i);
//                if (null != individualplan) {
//                    appraisalPerformanceIndividualDevelopmentPlan = appraisalPerformanceIndividualDevelopmentPlanService.readById(Integer.parseInt(individualplan));
//                }
//                if (!"".equals(text1) && null != text1) {
//                    appraisalPerformanceIndividualDevelopmentPlan.setManagertext1(text1);
//                } else {
//                    appraisalPerformanceIndividualDevelopmentPlan.setManagertext1(null);
//                }
//                if (!"".equals(text2) && null != text2) {
//                    appraisalPerformanceIndividualDevelopmentPlan.setManagertext2(text2);
//                } else {
//                    appraisalPerformanceIndividualDevelopmentPlan.setManagertext2(null);
//                }
//                if (!"".equals(text3) && null != text3) {
//                    appraisalPerformanceIndividualDevelopmentPlan.setText3(text3);
//                } else {
//                    appraisalPerformanceIndividualDevelopmentPlan.setText3(null);
//                }
//                if (!"".equals(text3) && null != text3) {
//                    appraisalPerformanceIndividualDevelopmentPlan.setManagertext3(text3);
//                } else {
//                    appraisalPerformanceIndividualDevelopmentPlan.setManagertext3(null);
//                }
//                if (!"".equals(managerMidYearRemark) && null != managerMidYearRemark) {
//                    appraisalPerformanceIndividualDevelopmentPlan.setManagerMidYearRemark(managerMidYearRemark);
//                } else {
//                    appraisalPerformanceIndividualDevelopmentPlan.setManagerEndYearRemark(null);
//                }
////                Endyear
//                if (null != endYearRemark && !"".equals(endYearRemark)) {
//                    appraisalPerformanceIndividualDevelopmentPlan.setEndYearRemark(endYearRemark);
//                } else {
//                    appraisalPerformanceIndividualDevelopmentPlan.setEndYearRemark(null);
//                }
//                if (!"".equals(managerEndYearRemark) && null != managerEndYearRemark) {
//                    appraisalPerformanceIndividualDevelopmentPlan.setManagerEndYearRemark(managerEndYearRemark);
//                } else {
//                    appraisalPerformanceIndividualDevelopmentPlan.setManagerEndYearRemark(null);
//                }
//
//                String btn = request.getParameter("save");
//                if (null != btn && btn.equals("save")) {
//
//                    if (individualplan != null) {
//                        appraisalPerformanceIndividualDevelopmentPlan.setId(Integer.parseInt(individualplan));
//                        appraisalPerformanceIndividualDevelopmentPlanService.update(appraisalPerformanceIndividualDevelopmentPlan);
//                    } else {
//                        appraisalPerformanceIndividualDevelopmentPlanService.create(appraisalPerformanceIndividualDevelopmentPlan);
//                    }
//                    request.setAttribute("successMessage",
//                            "Information : The Information is Saved Successfully.");
//                } else {
//
//                    if (null != text1 && !"".equals(text1)) {
//                        appraisalPerformanceIndividualDevelopmentPlan.setText1(text1);
//                    } else {
//                        appraisalPerformanceIndividualDevelopmentPlan.setText1(null);
//                    }
//                    if (null != text2 && !"".equals(text2)) {
//                        appraisalPerformanceIndividualDevelopmentPlan.setText2(text2);
//                    } else {
//                        appraisalPerformanceIndividualDevelopmentPlan.setText2(null);
//                    }
//                    if (null != text3 && !"".equals(text3)) {
//                        appraisalPerformanceIndividualDevelopmentPlan.setText3(text3);
//                    } else {
//                        appraisalPerformanceIndividualDevelopmentPlan.setText3(null);
//                    }
//                    if (null != midYearRemark && !"".equals(midYearRemark)) {
//                        appraisalPerformanceIndividualDevelopmentPlan.setMidYearRemark(midYearRemark);
//                    } else {
//                        appraisalPerformanceIndividualDevelopmentPlan.setMidYearRemark(null);
//                    }
//
//                    if (null != remark && !"".equals(remark)) {
//                        appraisalPerformanceIndividualDevelopmentPlan.setRemark(remark);
//                    } else {
//                        appraisalPerformanceIndividualDevelopmentPlan.setRemark(null);
//                    }
//                    if (null != endYearRemark && !"".equals(endYearRemark)) {
//                        appraisalPerformanceIndividualDevelopmentPlan.setEndYearRemark(endYearRemark);
//                    } else {
//                        appraisalPerformanceIndividualDevelopmentPlan.setEndYearRemark(null);
//                    }
//
//                    if (null != endYearRemark && !"".equals(endYearRemark)) {
//                        appraisalPerformanceIndividualDevelopmentPlan.setManagerEndYearRemarkEmployee(endYearRemark);
//                    } else {
//                        appraisalPerformanceIndividualDevelopmentPlan.setManagerEndYearRemarkEmployee(null);
//                    }
//
//                    if (null != managerMidYearRemark && !"".equals(managerMidYearRemark)) {
//                        appraisalPerformanceIndividualDevelopmentPlan.setManagerMidYearRemark(managerMidYearRemark);
//                    } else {
//                        appraisalPerformanceIndividualDevelopmentPlan.setManagerMidYearRemark(null);
//                    }
//                    if (null != managerMidYearRemark && !"".equals(managerMidYearRemark)) {
//                        appraisalPerformanceIndividualDevelopmentPlan.setManagerMidYearRemarkEmployee(managerMidYearRemark);
//                    } else {
//                        appraisalPerformanceIndividualDevelopmentPlan.setManagerMidYearRemarkEmployee(null);
//                    }
//
//                    if (null != managerEndYearRemark && !"".equals(managerEndYearRemark)) {
//                        appraisalPerformanceIndividualDevelopmentPlan.setManagerEndYearRemark(managerEndYearRemark);
//                    } else {
//                        appraisalPerformanceIndividualDevelopmentPlan.setManagerEndYearRemark(null);
//                    }
//
//                    if (null != managerEndYearRemark && !"".equals(managerEndYearRemark)) {
//                        appraisalPerformanceIndividualDevelopmentPlan.setManagerEndYearRemarkManager(managerEndYearRemark);
//                    } else {
//                        appraisalPerformanceIndividualDevelopmentPlan.setManagerEndYearRemarkManager(null);
//                    }
////                    if (null != managerEndYearRemark && !"".equals(managerEndYearRemark)) {
////                        appraisalPerformanceIndividualDevelopmentPlan.setManagerEndYearRemarkEmployee(managerEndYearRemark);
////                    } else {
////                        appraisalPerformanceIndividualDevelopmentPlan.setManagerEndYearRemarkEmployee(null);
////                    }
//
//                    //////////////////////////////////////
//                    if (individualplan != null) {
//                        appraisalPerformanceIndividualDevelopmentPlan.setId(Integer.parseInt(individualplan));
//                        appraisalPerformanceIndividualDevelopmentPlan.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
//                        appraisalPerformanceIndividualDevelopmentPlanService.update(appraisalPerformanceIndividualDevelopmentPlan);
//                    } else {
//                        appraisalPerformanceIndividualDevelopmentPlanService.create(appraisalPerformanceIndividualDevelopmentPlan);
//                    }
//                    request.setAttribute("successMessage",
//                            "Information : The Information is Approved Successfully.");
//                }
//            }
//
//
//            ////////////////////closed Indivisual plan////////
            ///////////////////Competency Evaluation (As Per Zydex Competency Framework)//change by date 11/11/2016//////////////////////////
            ///////////////////Competency Evaluation (As Per Zydex Competency Framework)////////////////////////////
//            AppraisalPerformanceCompetencyEvaluation appraisalPerformanceCompetencyEvaluation = new AppraisalPerformanceCompetencyEvaluation();
//            CompetencyEvaluationTextmaster competencyEvaluationTextmaster = new CompetencyEvaluationTextmaster();
//            CompetencyEvaluationMaster competencyEvaluationMaster = new CompetencyEvaluationMaster();
//            int subCompentencyCount = Integer.parseInt(request.getParameter("subCompentencyCount"));
//            boolean flag = true;
//            for (int i = 1; i <= subCompentencyCount; i++) {
//                String competencyEveId = request.getParameter("competencyEveId" + i);
//                if (null != competencyEveId) {
//                    appraisalPerformanceCompetencyEvaluation = appraisalPerformanceCompetencyEvaluationService.readById(Integer.parseInt(competencyEveId));
//                }
//                String compentencyStartYear = request.getParameter("compentencyStartYear" + i);
//                String compentencyStartRemark = request.getParameter("compentencyStartRemark" + i);
//                String compentencyMidYear = request.getParameter("compentencyMidYear" + i);
//                String compentencyMidRemark = request.getParameter("compentencyMidRemark" + i);
//                String compentencyEndYear = request.getParameter("compentencyEndYear" + i);
//                String compentencyEndRemark = request.getParameter("compentencyEndRemark" + i);
//
//                ///////////manager StartYearManager
//                if (!"".equals(compentencyStartYear) && null != compentencyStartYear) {
//                    appraisalPerformanceCompetencyEvaluation.setCompetencyStartYearManager(compentencyStartYear);
//                } else {
//                    appraisalPerformanceCompetencyEvaluation.setCompetencyStartYearManager(null);
//                }
//                if (!"".equals(compentencyStartRemark) && null != compentencyStartRemark) {
//                    appraisalPerformanceCompetencyEvaluation.setStartyearRemarkManager(compentencyStartRemark);
//                } else {
//                    appraisalPerformanceCompetencyEvaluation.setStartyearRemarkManager(null);
//                }
//                if (!"".equals(compentencyMidYear) && null != compentencyMidYear) {
//                    appraisalPerformanceCompetencyEvaluation.setCompetencyMidYearManager(compentencyMidYear);
//                } else {
//                    appraisalPerformanceCompetencyEvaluation.setCompetencyMidYearManager(null);
//                }
//                if (!"".equals(compentencyMidRemark) && null != compentencyMidRemark) {
//                    appraisalPerformanceCompetencyEvaluation.setMidyearRemarkManager(compentencyMidRemark);
//                } else {
//                    appraisalPerformanceCompetencyEvaluation.setMidyearRemarkManager(null);
//                }
//                if (!"".equals(compentencyEndYear) && null != compentencyEndYear) {
//                    appraisalPerformanceCompetencyEvaluation.setCompetencyEndYearManager(compentencyEndYear);
//                } else {
//                    appraisalPerformanceCompetencyEvaluation.setCompetencyEndYearManager(null);
//                }
//                if (!"".equals(compentencyEndRemark) && null != compentencyEndRemark) {
//                    appraisalPerformanceCompetencyEvaluation.setEndyearRemarkManager(compentencyEndRemark);
//                } else {
//                    appraisalPerformanceCompetencyEvaluation.setCompetencyEndYearManager(null);
//                }
//                appraisalPerformanceCompetencyEvaluation.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
//                int compentencyTextMasterId = Integer.parseInt(request.getParameter("compentencyTextMasterId" + i));
//                competencyEvaluationTextmaster.setId(compentencyTextMasterId);
////                competencyEvaluationMaster.setId(competencyEvaluationId);
////                appraisalPerformanceCompetencyEvaluation.setCompetencyEvaluationMaster(competencyEvaluationMaster);
//                appraisalPerformanceCompetencyEvaluation.setCompetencyEvaluationTextmaster(competencyEvaluationTextmaster);
//                //String competencyEveId = request.getParameter("competencyEveId" + i);
//                String btn2 = request.getParameter("save");
//
//                if (null != btn2 && btn2.equals("save")) {
//                    if (!"".equals(competencyEveId) && null != competencyEveId) {
//                        int competencyEvaluationId = Integer.parseInt(request.getParameter("competencyEvaluationId" + i));
//                        competencyEvaluationMaster.setId(competencyEvaluationId);
//                        appraisalPerformanceCompetencyEvaluation.setCompetencyEvaluationMaster(competencyEvaluationMaster);
//                        appraisalPerformanceCompetencyEvaluation.setId(Integer.parseInt(competencyEveId));
////                        appraisalPerformanceCompetencyEvaluation.setManagerStatus(1);
//                        appraisalPerformanceCompetencyEvaluationService.update(appraisalPerformanceCompetencyEvaluation);
//
//                    } else {
//
////                        if (!appraisalId.isEmpty()) {
////                            if (flag) {
////                                for (String id : appraisalId.split(",")) {
////                                    if (!id.equals("")) {
////                                        AppraisalPerformanceCompetencyEvaluation appraisalPerformanceCompetencyEvaluation2 = new AppraisalPerformanceCompetencyEvaluation();
////                                        appraisalPerformanceCompetencyEvaluation2.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
////                                        appraisalPerformanceCompetencyEvaluationService.deleteByManager(appraisalPerformanceCompetencyEvaluation2);
////                                        flag = false;
////                                    }
////                                }
////                            }
////                        }
//                        String competencyEvaluationId = request.getParameter("competencyEvaluationId");
//                        if (!"".equals(competencyEvaluationId) && null != competencyEvaluationId) {
//                            int competencyEvaluation_Id = Integer.parseInt(competencyEvaluationId);
//                            competencyEvaluationMaster.setId(competencyEvaluation_Id);
//                            appraisalPerformanceCompetencyEvaluation.setCompetencyEvaluationMaster(competencyEvaluationMaster);
////                            appraisalPerformanceCompetencyEvaluation.setManagerStatus(1);
//                            appraisalPerformanceCompetencyEvaluationService.create(appraisalPerformanceCompetencyEvaluation);
//                        }
//                    }
//                } else {
//                    if (!"".equals(compentencyStartYear) && null != compentencyStartYear) {
//                        appraisalPerformanceCompetencyEvaluation.setCompetencyStartYear(compentencyStartYear);
//                    } else {
//                        appraisalPerformanceCompetencyEvaluation.setCompetencyStartYear(null);
//                    }
//                    if (!"".equals(compentencyStartRemark) && null != compentencyStartRemark) {
//                        appraisalPerformanceCompetencyEvaluation.setStartyearRemark(compentencyStartRemark);
//                    } else {
//                        appraisalPerformanceCompetencyEvaluation.setStartyearRemark(null);
//                    }
//                    if (!"".equals(compentencyMidYear) && null != compentencyMidYear) {
//                        appraisalPerformanceCompetencyEvaluation.setCompetencyMidYear(compentencyMidYear);
//                    } else {
//                        appraisalPerformanceCompetencyEvaluation.setCompetencyMidYear(null);
//                    }
//                    if (!"".equals(compentencyMidRemark) && null != compentencyMidRemark) {
//                        appraisalPerformanceCompetencyEvaluation.setMidyearRemark(compentencyMidRemark);
//                    } else {
//                        appraisalPerformanceCompetencyEvaluation.setMidyearRemark(null);
//                    }
//                    if (!"".equals(compentencyEndYear) && null != compentencyEndYear) {
//                        appraisalPerformanceCompetencyEvaluation.setCompetencyEndYear(compentencyEndYear);
//                    } else {
//                        appraisalPerformanceCompetencyEvaluation.setCompetencyEndYear(null);
//                    }
//                    if (!"".equals(compentencyEndRemark) && null != compentencyEndRemark) {
//                        appraisalPerformanceCompetencyEvaluation.setEndyearRemark(compentencyEndRemark);
//                    } else {
//                        appraisalPerformanceCompetencyEvaluation.setCompetencyEndYear(null);
//                    }
//
//                    if (!"".equals(competencyEveId) && null != competencyEveId) {
//
////                        if (!appraisalId.isEmpty()) {
////                            if (flag) {
////                                for (String id : appraisalId.split(",")) {
////                                    if (!id.equals("")) {
////                                        AppraisalPerformanceCompetencyEvaluation appraisalPerformanceCompetencyEvaluation2 = new AppraisalPerformanceCompetencyEvaluation();
////                                        appraisalPerformanceCompetencyEvaluation2.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
////                                        appraisalPerformanceCompetencyEvaluationService.finaldeletebyManager(appraisalPerformanceCompetencyEvaluation2);
////                                        flag = false;
////                                    }
////                                }
////                            }
////                        }
//                        int competencyEvaluationId = Integer.parseInt(request.getParameter("competencyEvaluationId" + i));
//                        competencyEvaluationMaster.setId(competencyEvaluationId);
//                        appraisalPerformanceCompetencyEvaluation.setCompetencyEvaluationMaster(competencyEvaluationMaster);
//                        appraisalPerformanceCompetencyEvaluation.setId(Integer.parseInt(competencyEveId));
////                        appraisalPerformanceCompetencyEvaluation.setManagerStatus(1);
////                        appraisalPerformanceCompetencyEvaluation.setEmployeeStatus(1);
//                        appraisalPerformanceCompetencyEvaluationService.update(appraisalPerformanceCompetencyEvaluation);
//
//                    } else {
//                        String competencyEvaluationId = request.getParameter("competencyEvaluationId");
//                        if (!"".equals(competencyEvaluationId) && null != competencyEvaluationId) {
//                            int competencyEvaluation_Id = Integer.parseInt(competencyEvaluationId);
//                            competencyEvaluationMaster.setId(competencyEvaluation_Id);
////                            appraisalPerformanceCompetencyEvaluation.setManagerStatus(1);
//                            appraisalPerformanceCompetencyEvaluation.setCompetencyEvaluationMaster(competencyEvaluationMaster);
////                            appraisalPerformanceCompetencyEvaluation.setEmployeeStatus(1);
//                            appraisalPerformanceCompetencyEvaluationService.create(appraisalPerformanceCompetencyEvaluation);
//                        }
//                    }
//                }
//            }

            //////////Behaviors///////////////
//            if (firsthalf.equals("false")) {
//
//                AppraisalPerformanceBehaviors appraisalPerformanceBehaviors = new AppraisalPerformanceBehaviors();
//
//                for (int i = 1; i <= 5; i++) {
//                    String id = request.getParameter("id" + i);
//
//                    if (null != id) {
//                        appraisalPerformanceBehaviors = appraisalPerformanceBehaviorsService.readById(Integer.parseInt(id));
//                    }
//                    String behaviors = request.getParameter("w" + i);
//                    String midYearScore = request.getParameter("midYearScore" + i);
//                    String endYearScore = request.getParameter("endYearScore" + i);
//                    String managerMidYearReview = request.getParameter("managerMidYearReview" + i);
//                    String managerEndYearReview = request.getParameter("managerEndYearReview" + i);
//                    if (!"".equals(behaviors) && null != behaviors) {
//                        appraisalPerformanceBehaviors.setBehaviorsManager(behaviors);
//                    } else {
//                        appraisalPerformanceBehaviors.setBehaviorsManager(null);
//                    }
//                    if (!"".equals(midYearScore) && null != midYearScore) {
//                        appraisalPerformanceBehaviors.setMidYearScoreManager(Float.parseFloat(midYearScore));
//                    } else {
//                        appraisalPerformanceBehaviors.setMidYearScoreManager(null);
//                    }
//                    if (!"".equals(endYearScore) && null != endYearScore) {
//                        appraisalPerformanceBehaviors.setEndYearScoreManager(Float.parseFloat(endYearScore));
//                    } else {
//                        appraisalPerformanceBehaviors.setEndYearScoreManager(null);
//                    }
//                    if (!"".equals(managerMidYearReview) && null != managerMidYearReview) {
//                        appraisalPerformanceBehaviors.setManagerMidYearReviewManager(managerMidYearReview);
//                    } else {
//                        appraisalPerformanceBehaviors.setManagerMidYearReviewManager(null);
//                    }
//                    if (!"".equals(managerEndYearReview) && null != managerEndYearReview) {
//                        appraisalPerformanceBehaviors.setManagerEndYearReviewManager(managerEndYearReview);
//                    } else {
//                        appraisalPerformanceBehaviors.setManagerEndYearReviewManager(null);
//                    }
//
//                    appraisalPerformanceBehaviors.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
//                    String btn2 = request.getParameter("save");
//                    if (null != btn2 && btn2.equals("save")) {
//                        if (!"".equals(id) && null != id) {
//                            appraisalPerformanceBehaviors.setId(Integer.parseInt(id));
//                            appraisalPerformanceBehaviorsService.update(appraisalPerformanceBehaviors);
//                        } else {
//                            appraisalPerformanceBehaviorsService.create(appraisalPerformanceBehaviors);
//                        }
//                    } else {
//                        if (!"".equals(behaviors) && null != behaviors) {
//                            appraisalPerformanceBehaviors.setBehaviors(behaviors);
//                        } else {
//                            appraisalPerformanceBehaviors.setBehaviors(null);
//                        }
//                        if (!"".equals(midYearScore) && null != midYearScore) {
//                            appraisalPerformanceBehaviors.setMidYearScore(Float.parseFloat(midYearScore));
//                        } else {
//                            appraisalPerformanceBehaviors.setMidYearScore(null);
//                        }
//                        if (!"".equals(endYearScore) && null != endYearScore) {
//                            appraisalPerformanceBehaviors.setEndYearScore(Float.parseFloat(endYearScore));
//                        } else {
//                            appraisalPerformanceBehaviors.setEndYearScore(null);
//                        }
//                        if (!"".equals(managerMidYearReview) && null != managerMidYearReview) {
//                            appraisalPerformanceBehaviors.setManagerMidYearReview(managerMidYearReview);
//                        } else {
//                            appraisalPerformanceBehaviors.setManagerMidYearReview(null);
//                        }
//                        if (!"".equals(managerEndYearReview) && null != managerEndYearReview) {
//                            appraisalPerformanceBehaviors.setManagerEndYearReview(managerEndYearReview);
//                        } else {
//                            appraisalPerformanceBehaviors.setManagerEndYearReview(null);
//                        }
//                        if (!"".equals(id) && null != id) {
//                            appraisalPerformanceBehaviors.setId(Integer.parseInt(id));
//                            appraisalPerformanceBehaviorsService.update(appraisalPerformanceBehaviors);
//                        } else {
//                            appraisalPerformanceBehaviorsService.create(appraisalPerformanceBehaviors);
//                        }
//                    }
//                }
//            }
            //                appraisal_performance_master Change by  final score,mid year remake,end Year remark
//            AppraisalPerformanceMaster appraisalPerformanceMaster1 = new AppraisalPerformanceMaster();
            String behaviorsMidyearTotalscore = request.getParameter("behaviorsMidyearTotalscore");
            if (!"".equals(behaviorsMidyearTotalscore) && null != behaviorsMidyearTotalscore) {
                appraisalPerformanceMaster.setBehaviorsMidyearTotalscore(behaviorsMidyearTotalscore);
            } else {
                appraisalPerformanceMaster.setBehaviorsMidyearTotalscore(null);
            }
            String behaviorsEndyearTotalscore = request.getParameter("behaviorsEndyearTotalscore");
            if (!"".equals(behaviorsEndyearTotalscore) && null != behaviorsEndyearTotalscore) {
                appraisalPerformanceMaster.setBehaviorsEndyearTotalscore(behaviorsEndyearTotalscore);
            } else {
                appraisalPerformanceMaster.setBehaviorsEndyearTotalscore(null);
            }
            String behaviorsMidyearOtherremark = request.getParameter("behaviorsMidyearOtherremark");
            if (!"".equals(behaviorsMidyearOtherremark) && null != behaviorsMidyearOtherremark) {
                appraisalPerformanceMaster.setBehaviorsMidyearOtherremark(behaviorsMidyearOtherremark);
            } else {
                appraisalPerformanceMaster.setBehaviorsMidyearOtherremark(null);
            }

            String behaviorsEndyearOtherremark = request.getParameter("behaviorsEndyearOtherremark");
            if (!"".equals(behaviorsEndyearOtherremark) && null != behaviorsEndyearOtherremark) {
                appraisalPerformanceMaster.setBehaviorsEndyearOtherremark(behaviorsEndyearOtherremark);
            } else {
                appraisalPerformanceMaster.setBehaviorsEndyearOtherremark(null);
            }

            if (!"".equals(startdate) && null != startdate) {
                appraisalPerformanceMaster.setBehaviorsDate(startdate);
            } else {
                appraisalPerformanceMaster.setBehaviorsDate(null);
            }

//            String behaviorsYear = "" + Calendar.getInstance().get(Calendar.YEAR);
//            if (!"".equals(behaviorsYear) && null != behaviorsYear) {
//                appraisalPerformanceMaster.setBehaviorsYear(behaviorsYear);
//            } else {
//                appraisalPerformanceMaster.setBehaviorsYear(null);
//            }
            String behaviorsFinalscore = request.getParameter("behaviorsFinalscore");
            if (!"".equals(behaviorsFinalscore) && null != behaviorsFinalscore && !"NaN".equals(behaviorsFinalscore)) {
                appraisalPerformanceMaster.setBehaviorsFinalscore(behaviorsFinalscore);
            } else {
                appraisalPerformanceMaster.setBehaviorsFinalscore(null);
            }

            String managerActivityScore = request.getParameter("managerActivityScore");
            if (!"".equals(managerActivityScore) && null != managerActivityScore) {
                appraisalPerformanceMaster.setManagerActivityScore(managerActivityScore);
            } else {
                appraisalPerformanceMaster.setManagerActivityScore(null);
            }

//            appraisalPerformanceService.update(appraisalPerformanceMaster);
            String pmpstatusId = "";
            String btn1 = request.getParameter("submit");
            if (null != btn1 && btn1.equals("submit")) {
                List<?> pmplist = pmpFormStatusMasterService.readByPmpformstatusStatus("" + appraisalPerformanceMaster.getEmployeeMaster().getId());
                if (!pmplist.isEmpty()) {
                    pmpFormStatusMaster = (PmpFormStatusMaster) pmplist.get(0);
                    pmpstatusId = "" + pmpFormStatusMaster.getId();

                }

                String weightageScore = request.getParameter("weightageScore");
                if (null == weightageScore) {
                    weightageScore = "";
                }

                appraisalPerformanceMaster.setManagerStatus(1);//manager status Kra Approvement
                appraisalPerformanceMaster.setEmployeeStatus(0);
                String YearEndStartDate = appraisalFillingData1.getYearEndStartDate();
                String YearEndDate = appraisalFillingData1.getYearEndEndDate();
//            
                Date yearEndStartDate = sdf.parse(YearEndStartDate);
                Date yearEndDate = sdf.parse(YearEndDate);

                if (((now.after(yearEndStartDate)) && (now.before(yearEndDate))) || now.equals(yearEndStartDate)
                        || (now.equals(yearEndDate))) {
                    if (appraisalPerformanceMaster.getEndYearEmployeeStatus() == 1) {
                        appraisalPerformanceMaster.setManagerStatus(1);//manager status Kra Approvement
                        appraisalPerformanceMaster.setEmployeeStatus(1);
                    }
                }

                appraisalPerformanceMaster.setManagerkraStatus(1);
                appraisalPerformanceMaster.setWeightageScoreManager(weightageScore);

                //behaviorsMidyearTotalscore for employee side
//                String behaviorsMidyearTotalscore = request.getParameter("behaviorsMidyearTotalscore");
                if (!"".equals(behaviorsMidyearTotalscore) && null != behaviorsMidyearTotalscore) {
                    appraisalPerformanceMaster.setBehaviorsMidyearTotalscoreForemp(behaviorsMidyearTotalscore);
                } else {
                    appraisalPerformanceMaster.setBehaviorsMidyearTotalscoreForemp(null);
                }
                //behaviorsEndyearTotalscore for employee side
//                String behaviorsEndyearTotalscore = request.getParameter("behaviorsEndyearTotalscore");
                if (!"".equals(behaviorsEndyearTotalscore) && null != behaviorsEndyearTotalscore) {
                    appraisalPerformanceMaster.setBehaviorsEndyearTotalscoreForemp(behaviorsEndyearTotalscore);
                } else {
                    appraisalPerformanceMaster.setBehaviorsEndyearTotalscore(null);
                }
//                total score for employee
//                String totalScore = (request.getParameter("totalScore"));
                if (totalScore != null) {
                    appraisalPerformanceMaster.setTotalScoreForemployee(totalScore);
                } else {
                    appraisalPerformanceMaster.setTotalScoreForemployee(null);
                }

                //Remark for employee mid//
                if (!"".equals(behaviorsMidyearOtherremark) && null != behaviorsMidyearOtherremark) {
                    appraisalPerformanceMaster.setBehaviorsMidyearOtherremarkForemployee(behaviorsMidyearOtherremark);
                } else {
                    appraisalPerformanceMaster.setBehaviorsMidyearOtherremarkForemployee(null);
                }
                //Remark for employee end//
                if (!"".equals(behaviorsEndyearOtherremark) && null != behaviorsEndyearOtherremark) {
                    appraisalPerformanceMaster.setBehaviorsEndyearOtherremarkForemployee(behaviorsEndyearOtherremark);
                } else {
                    appraisalPerformanceMaster.setBehaviorsEndyearOtherremarkForemployee(null);
                }

                //Final score employee//
                if (!"".equals(behaviorsFinalscore) && null != behaviorsFinalscore && !"NaN".equals(behaviorsFinalscore)) {
                    appraisalPerformanceMaster.setBehaviorsFinalscoreForemployee(behaviorsFinalscore);
                } else {
                    appraisalPerformanceMaster.setBehaviorsFinalscoreForemployee(null);
                }
//                Activity Score
                if (!"".equals(managerActivityScore) && null != managerActivityScore) {
                    appraisalPerformanceMaster.setEmpActivityScore(managerActivityScore);
                } else {
                    appraisalPerformanceMaster.setEmpActivityScore(null);
                }
                if (firsthalf.equals("true")) {
                    pmpFormStatusMaster.setStartYearStatus(Boolean.TRUE);
                }
//                if (midhalf.equals("true") || endEndDate.before(joindate)) {
//                    appraisalPerformanceMaster.setMidYearManagerStatus(1);
//                    pmpFormStatusMaster.setMidYearStatus(Boolean.TRUE);
//                }
//                    if (midhalf.equals("true")) {
//                        appraisalPerformanceMaster.setMidYearManagerStatus(1);
//                        pmpFormStatusMaster.setMidYearStatus(Boolean.TRUE);
//                    }
                if (endhalf.equals("true")) {
                    appraisalPerformanceMaster.setEndYearManagerStatus(1);
//                    appraisalPerformanceMaster.setEmployeeStatus(0);
//                    appraisalPerformanceMaster.setManagerkraStatus(0);
                    pmpFormStatusMaster.setEndYearStatus(Boolean.TRUE);
                }
                pmpFormStatusMaster.setEmployeeSide(Boolean.TRUE);
                pmpFormStatusMaster.setManagerSide(Boolean.TRUE);
                pmpFormStatusMasterService.update(pmpFormStatusMaster);
                appraisalPerformanceService.update(appraisalPerformanceMaster);
                if (!"".equals(appraisalId) && null != appraisalId) {
                    //    Email Sent to Employee(Start Year)
                    if (!"".equals(firsthalf) && null != firsthalf) {
                        if (firsthalf.equals("true")) {
                            try {
                                EmailTemplate emailTemplate = new EmailTemplate();
                                EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                                DesignationMaster designationMaster = new DesignationMaster();
                                designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                                List l1 = appraisalPerformanceService.readEmpIdFromTabId(Integer.parseInt(appraisalId));
                                EmployeeMaster employeeRequestee = (EmployeeMaster) l1.get(0);
                                // id 116 is for status Appraisal Approved (Start Year)
                                emailTemplate = emailTemplateService.readById(116);
                                String To = employeeRequestee.getOfficeEmailId();
                                String from = employeeMasterModel.getOfficeEmailId();
                                String Subject = emailTemplate.getSubject();
                                Subject = Subject.replaceAll("\\{user\\}", employeeRequestee.getEmployeeName());
                                String msg = emailTemplate.getBodytext();
                                msg = msg.replaceAll("\\{to_user\\}", employeeRequestee.getEmployeeName());
                                msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                                msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                                sendMail.sendMail(from, To, Subject, msg);

                                String name = "PMP";
                                EmailAddMaster emailAddMaster = new EmailAddMaster();
                                emailAddMaster.setModuleName(name);
                                emailAddMaster.setDepartmentMaster(employeeRequestee.getDepartmentMaster());
                                List<?> emailSendList = emailAddMasterService.readByName(emailAddMaster);
                                if (!emailSendList.isEmpty()) {
                                    EmailAddMaster emailAddMaster1 = (EmailAddMaster) emailSendList.get(0);
                                    String emailId = emailAddMaster1.getEmailId();
                                    for (String emailId1 : emailId.split(",")) {
                                        if (!emailId1.equals("")) {
                                            String To1 = emailId1;
                                            String from1 = employeeMasterModel.getOfficeEmailId();
                                            String subject1 = emailTemplate.getSubject();
                                            subject1 = subject1.replaceAll("\\{user\\}", employeeRequestee.getEmployeeName());
                                            String msg1 = emailTemplate.getBodytext();
                                            msg1 = msg1.replaceAll("\\{to_user\\}", employeeRequestee.getEmployeeName());
                                            msg1 = msg1.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                                            msg1 = msg1.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                                            sendMail.sendMail(from1, To1, subject1, msg1);

                                        }
                                    }
                                }
                            } catch (Exception e) {

                            }
                        }
                    }
                    //    Email Sent to Employee(Mid Year)
//                    if (!"".equals(midhalf) && null != midhalf) {
//                        if (midhalf.equals("true")) {
//                            try {
//                                EmailTemplate emailTemplate = new EmailTemplate();
//                                EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
//                                DesignationMaster designationMaster = new DesignationMaster();
//                                designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
//                                List l1 = appraisalPerformanceService.readEmpIdFromTabId(Integer.parseInt(appraisalId));
//                                EmployeeMaster employeeRequestee = (EmployeeMaster) l1.get(0);
//                                // id 117 is for status Appraisal Approved (Mid Year)
//                                emailTemplate = emailTemplateService.readById(117);
//                                String To = employeeRequestee.getOfficeEmailId();
//                                String from = employeeMasterModel.getOfficeEmailId();
//                                String Subject = emailTemplate.getSubject();
//                                Subject = Subject.replaceAll("\\{user\\}", employeeRequestee.getEmployeeName());
//                                String msg = emailTemplate.getBodytext();
//                                msg = msg.replaceAll("\\{to_user\\}", employeeRequestee.getEmployeeName());
//                                msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
//                                msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
//                                sendMail.sendMail(from, To, Subject, msg);
//
//                                String name = "PMP";
//                                EmailAddMaster emailAddMaster = new EmailAddMaster();
//                                emailAddMaster.setModuleName(name);
//                                emailAddMaster.setDepartmentMaster(employeeRequestee.getDepartmentMaster());
//                                List<?> emailSendList = emailAddMasterService.readByName(emailAddMaster);
//                                if (!emailSendList.isEmpty()) {
//                                    EmailAddMaster emailAddMaster1 = (EmailAddMaster) emailSendList.get(0);
//                                    String emailId = emailAddMaster1.getEmailId();
//                                    for (String emailId1 : emailId.split(",")) {
//                                        if (!emailId1.equals("")) {
//                                            String To1 = emailId1;
//                                            String from1 = employeeMasterModel.getOfficeEmailId();
//                                            String subject1 = emailTemplate.getSubject();
//                                            subject1 = subject1.replaceAll("\\{user\\}", employeeRequestee.getEmployeeName());
//                                            String msg1 = emailTemplate.getBodytext();
//                                            msg1 = msg1.replaceAll("\\{to_user\\}", employeeRequestee.getEmployeeName());
//                                            msg1 = msg1.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
//                                            msg1 = msg1.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
//                                            sendMail.sendMail(from1, To1, subject1, msg1);
//
//                                        }
//                                    }
//                                }
//                            } catch (Exception e) {
//                            }
//                        }
//                    }
                    //    Email Sent to Employee(Year End)
                    if (!"".equals(endhalf) && null != endhalf) {
                        if (endhalf.equals("true")) {
                            try {
                                EmailTemplate emailTemplate = new EmailTemplate();
                                EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                                DesignationMaster designationMaster = new DesignationMaster();
                                designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                                List l1 = appraisalPerformanceService.readEmpIdFromTabId(Integer.parseInt(appraisalId));
                                EmployeeMaster employeeRequestee = (EmployeeMaster) l1.get(0);
                                // id 118 is for status Appraisal Approved (Year End)
                                emailTemplate = emailTemplateService.readById(118);
                                String To = employeeRequestee.getOfficeEmailId();
                                String from = employeeMasterModel.getOfficeEmailId();
                                String Subject = emailTemplate.getSubject();
                                Subject = Subject.replaceAll("\\{user\\}", employeeRequestee.getEmployeeName());
                                String msg = emailTemplate.getBodytext();
                                msg = msg.replaceAll("\\{to_user\\}", employeeRequestee.getEmployeeName());
                                msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                                msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                                sendMail.sendMail(from, To, Subject, msg);

                                String name = "PMP";
                                EmailAddMaster emailAddMaster = new EmailAddMaster();
                                emailAddMaster.setModuleName(name);
                                emailAddMaster.setDepartmentMaster(employeeRequestee.getDepartmentMaster());
                                List<?> emailSendList = emailAddMasterService.readByName(emailAddMaster);
                                if (!emailSendList.isEmpty()) {
                                    EmailAddMaster emailAddMaster1 = (EmailAddMaster) emailSendList.get(0);
                                    String emailId = emailAddMaster1.getEmailId();
                                    for (String emailId1 : emailId.split(",")) {
                                        if (!emailId1.equals("")) {
                                            String To1 = emailId1;
                                            String from1 = employeeMasterModel.getOfficeEmailId();
                                            String subject1 = emailTemplate.getSubject();
                                            subject1 = subject1.replaceAll("\\{user\\}", employeeRequestee.getEmployeeName());
                                            String msg1 = emailTemplate.getBodytext();
                                            msg1 = msg1.replaceAll("\\{to_user\\}", employeeRequestee.getEmployeeName());
                                            msg1 = msg1.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                                            msg1 = msg1.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                                            sendMail.sendMail(from1, To1, subject1, msg1);

                                        }
                                    }
                                }
                            } catch (Exception e) {
                            }
                        }
                    }
                }
            } else {
                //appraisalPerformanceMaster.setManagerStatus(0);
                appraisalPerformanceService.update(appraisalPerformanceMaster);
            }
        }
        mv.getModelMap().put("appraisalPerformanceMaster", appraisalPerformanceMaster);
//        mv.setViewName("Appraisal/ManagerPerformanceAppraisalForm");
//        mv.setViewName("redirect:appraisalPerformance.htm?act=searchSubmit");
        mv.setViewName("redirect:appraisalPerformance.htm?act=searchClick");
//        mv = searchSubmit(request, response);
//        mv.setViewName("forward:userMaster.htm?act=userDashboard");
        return mv;
    }

    public ModelAndView userDashboard(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        int year = Calendar.getInstance().get(Calendar.YEAR);

        List<?> l1 = appraisalFillingDataService.getCurrentAndPreviousYear();
        String previousYear = "";
        int currentYear = 0;
        if (!l1.isEmpty()) {
            Object[] obj = (Object[]) l1.get(0);
//            previousYear = (Integer) obj[0];
            previousYear = "" + obj[0];
//            currentYear = (Integer) obj[1];
        } else {
            previousYear = "0";
        }

        List appraisalPerformanceList = appraisalPerformanceService.readByAppraisalPerformanceIdAndYearWise("" + employeeMaster.getId(), Integer.parseInt(previousYear));
        AppraisalPerformanceMaster appraisalPerformanceMaster = new AppraisalPerformanceMaster();
        AppraisalPerformanceKra appraisalPerformanceKra = new AppraisalPerformanceKra();
        AppraisalFillingData appraisalFillingData = new AppraisalFillingData();
        AppraisalFillingData appraisalFillingData1 = new AppraisalFillingData();
        String goalSetting = "";
        String goalApproval = "";
        String midSelfApproval = "";
        String managerMidSelfApproval = "";
        String endSelfApproval = "";
        String managerEndSelfApproval = "";
//        timeLineDate(request, response);
//        String flag1 = "" + request.getAttribute("flag1");//first year employee
//        String flag2 = "" + request.getAttribute("flag2");//Mid year employee
//        String flag3 = "" + request.getAttribute("flag3");//End year employee
//        String flag4 = "" + request.getAttribute("flag4");//first year Manager
//        String flag5 = "" + request.getAttribute("flag5");//mid year Manager
//        String flag6 = "" + request.getAttribute("flag6");//end year Manager
//        request.setAttribute("flag2", flag2);
//        request.setAttribute("flag3", flag3);
//        request.setAttribute("flag4", flag4);
//        request.setAttribute("flag5", flag5);
//        request.setAttribute("flag6", flag6);
        if (null != appraisalPerformanceList && !appraisalPerformanceList.isEmpty()) {
            appraisalPerformanceMaster = (AppraisalPerformanceMaster) appraisalPerformanceList.get(0);
            appraisalPerformanceKra.setAppraisalPerformanceMaster(appraisalPerformanceMaster);

            List list = appraisalPerformanceKraService.readByAppraisalPerformancekraId(appraisalPerformanceKra);

//            List appraisalFillingDataList1 = appraisalFillingDataService.readByCurrentYear("2016");
            List appraisalFillingDataList1 = appraisalFillingDataService.getappraisalDate();
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date currentDate = dateFormat.parse(dateFormat.format(new Date()));
            if (!appraisalFillingDataList1.isEmpty()) {
                appraisalFillingData = (AppraisalFillingData) appraisalFillingDataList1.get(0);
//                        Date currentDate = new Date();
//

                // Middel year employee
                Date ManagerStartDate1 = dateFormat.parse(appraisalFillingData.getManagerStartDate());
                Date ManagerEndDate1 = dateFormat.parse(appraisalFillingData.getManagerEndDate());

                //Mid Year Dates Manager
                Date ManagerMidStartDate1 = dateFormat.parse(appraisalFillingData.getManagerMidYearStartDate());
                Date ManagerMidDate1 = dateFormat.parse(appraisalFillingData.getManagerMidYearEndDate());

                //End Year Dates Manager
                Date managerYearEndStartDate1 = dateFormat.parse(appraisalFillingData.getManagerYearEndStartDate());
                Date managerYearEndEndDate1 = dateFormat.parse(appraisalFillingData.getManagerYearEndEndDate());

                for (Object o : list) {
                    AppraisalPerformanceKra appraisalPerformanceKra1 = (AppraisalPerformanceKra) o;
                    if (appraisalPerformanceKra1.getKraGoal() != null && appraisalPerformanceKra1.getMetric() != null && 0 != appraisalPerformanceMaster.getStatus()) {
                        goalSetting = "Approved";
                        break;
                    }
                }

                for (Object o1 : list) {
                    AppraisalPerformanceKra appraisalPerformanceKra1 = (AppraisalPerformanceKra) o1;

                    if (currentDate.equals(ManagerStartDate1) || currentDate.equals(ManagerEndDate1)
                            || (currentDate.after(ManagerStartDate1) && currentDate.before(ManagerEndDate1))) {
                        if (appraisalPerformanceMaster.getReworkStatus() == 1) {
                            goalApproval = "Rework";
                            goalSetting = "pending";
                            break;
                        }

                    }
                    if (appraisalPerformanceKra1.getWeightage() != null && 0 != appraisalPerformanceMaster.getManagerStatus()) {
                        goalApproval = "Approved";
                        break;
                    } else {
                        goalApproval = "Pendding";
                    }
                }
                for (Object o1 : list) {
                    AppraisalPerformanceKra appraisalPerformanceKra1 = (AppraisalPerformanceKra) o1;
                    if (appraisalPerformanceKra1.getEmpMidyearSelfassessmentGoal() != null && !appraisalPerformanceKra1.getEmpMidyearSelfassessmentGoal().equals("") && 0 != appraisalPerformanceMaster.getMidYearEmployeeStatus()) {
                        midSelfApproval = "Approved";
                        break;
                    }
                }
                for (Object o1 : list) {
                    AppraisalPerformanceKra appraisalPerformanceKra1 = (AppraisalPerformanceKra) o1;
                    if (currentDate.equals(ManagerMidStartDate1) || currentDate.equals(ManagerMidDate1)
                            || (currentDate.after(ManagerMidStartDate1) && currentDate.before(ManagerMidDate1))) {
//                        if (appraisalPerformanceMaster.getReworkStatus() == 1 && 0 == appraisalPerformanceMaster.getMidYearManagerStatus()) {
                        if (appraisalPerformanceMaster.getReworkStatus() == 1) {
                            managerMidSelfApproval = "Rework";
                            midSelfApproval = "pending"; //change by10/20/2016
//                            managerMidSelfApproval = "pending";
                            break;
                        }
                    }
                    if (appraisalPerformanceKra1.getManagerMidyearReviewEvaluation() != null && !appraisalPerformanceKra1.getManagerMidyearReviewEvaluation().equals("") && 0 != appraisalPerformanceMaster.getMidYearManagerStatus()) {
                        managerMidSelfApproval = "Approved";
                        break;
                    } else {
                        managerMidSelfApproval = "Pendding";
                    }
                }
                for (Object o1 : list) {
                    AppraisalPerformanceKra appraisalPerformanceKra1 = (AppraisalPerformanceKra) o1;
                    if (appraisalPerformanceKra1.getEmpEndyearSelfassessmentGoal() != null && !appraisalPerformanceKra1.getEmpEndyearSelfassessmentGoal().equals("") && 0 != appraisalPerformanceMaster.getEndYearEmployeeStatus()) {
                        endSelfApproval = "Approved";
                        break;
                    }
                }

                for (Object o1 : list) {
                    AppraisalPerformanceKra appraisalPerformanceKra1 = (AppraisalPerformanceKra) o1;
                    if (currentDate.equals(managerYearEndStartDate1) || currentDate.equals(managerYearEndEndDate1)
                            || (currentDate.after(managerYearEndStartDate1) && currentDate.before(managerYearEndEndDate1))) {
//                        if (appraisalPerformanceMaster.getReworkStatus() == 1 && 0 != appraisalPerformanceMaster.getEndYearManagerStatus()) {
                        if (appraisalPerformanceMaster.getReworkStatus() == 1) {
                            managerEndSelfApproval = "Rework";
                            endSelfApproval = "pending";
                            break;
                        }
                    }
                    if (appraisalPerformanceKra1.getManagerEndyearReviewEvaluation() != null && !appraisalPerformanceKra1.getManagerEndyearReviewEvaluation().equals("") && 0 != appraisalPerformanceMaster.getEndYearManagerStatus()) {
                        managerEndSelfApproval = "Approved";
                        break;
                    } else {
                        managerEndSelfApproval = "Pendding";
                    }
                }
            }

            if (!list.isEmpty()) {

//                List appraisalFillingDataList = appraisalFillingDataService.readByCurrentYear("" + year);
                List appraisalFillingDataList = appraisalFillingDataService.getappraisalDate();

                if (!appraisalFillingDataList.isEmpty()) {
                    appraisalFillingData = (AppraisalFillingData) appraisalFillingDataList.get(0);
//                        Date currentDate = new Date();
//

                    // Middel year employee
                    Date StartDate = dateFormat.parse(appraisalFillingData.getStartDate());
                    Date EndDate = dateFormat.parse(appraisalFillingData.getEndDate());
                    if ((currentDate.after(StartDate) && currentDate.before(EndDate)) || currentDate.equals(EndDate) || currentDate.equals(StartDate)) {
                        if (!goalSetting.equals("Approved")) {
                            goalSetting = "Pendding";
                        }
                    } else if (currentDate.after(EndDate)) {
                        if (!goalSetting.equals("Approved")) {
                            goalSetting = "Expired";
                        }
                    } else if (!goalSetting.equals("Approved")) {
                        goalSetting = "";
                    }

                    // Middel year employee
                    Date MidendDate = dateFormat.parse(appraisalFillingData.getMidYearEndDate());
                    Date MidYearStartDate = dateFormat.parse(appraisalFillingData.getMidYearStartDate());
                    if ((currentDate.after(MidYearStartDate) && currentDate.before(MidendDate)) || currentDate.equals(MidendDate) || currentDate.equals(MidYearStartDate)) {
                        if (!midSelfApproval.equals("Approved")) {
                            midSelfApproval = "Pendding";
                        }
                    } else if (currentDate.after(MidendDate)) {
                        if (!midSelfApproval.equals("Approved")) {
                            midSelfApproval = "Expired";
                        }
                    } else if (!midSelfApproval.equals("Approved")) {
                        midSelfApproval = "";
                    }
                    /// Manager side Weight==>Time Line First////
                    Date ManagerEndDate = dateFormat.parse(appraisalFillingData.getManagerEndDate());
                    Date ManagerStartDate = dateFormat.parse(appraisalFillingData.getManagerStartDate());
//                    if ((currentDate.after(ManagerEndDate) && currentDate.before(ManagerStartDate)) || currentDate.equals(ManagerStartDate) || currentDate.equals(ManagerEndDate)) {
                    if ((currentDate.after(ManagerStartDate) && currentDate.before(ManagerEndDate)) || currentDate.equals(ManagerStartDate) || currentDate.equals(ManagerEndDate)) {
                        if (!goalApproval.equals("Approved") && !goalApproval.equals("Rework")) {
                            goalApproval = "Pendding";
                        }
                    } else if (currentDate.after(ManagerEndDate)) {
                        if (!goalApproval.equals("Approved") && !goalApproval.equals("Rework")) {
                            goalApproval = "Expired";
                        }
                    } else if (!goalApproval.equals("Approved") && !goalApproval.equals("Rework")) {
                        goalApproval = "Pendding";
                    }

                    /// Manager side self assements==>Time Line Mid-Time////
                    Date ManagerMidDate = dateFormat.parse(appraisalFillingData.getManagerMidYearEndDate());
                    Date ManagerMidStartDate = dateFormat.parse(appraisalFillingData.getManagerMidYearStartDate());
//                    if ((currentDate.after(ManagerMidDate) && currentDate.before(ManagerMidStartDate)) || currentDate.equals(ManagerMidStartDate) || currentDate.equals(ManagerMidDate)) {
                    if ((currentDate.after(ManagerMidStartDate) && currentDate.before(ManagerMidDate)) || currentDate.equals(ManagerMidStartDate) || currentDate.equals(ManagerMidDate)) {
                        if (!managerMidSelfApproval.equals("Approved") && !managerMidSelfApproval.equals("Rework")) {
                            managerMidSelfApproval = "Pendding";
                        }
                    } else if (currentDate.after(ManagerMidDate)) {
                        if (!managerMidSelfApproval.equals("Approved") && !managerMidSelfApproval.equals("Rework")) {
                            managerMidSelfApproval = "Expired";
                        }
                    } else if (!managerMidSelfApproval.equals("Approved") && !managerMidSelfApproval.equals("Rework")) {
                        managerMidSelfApproval = "";
                    }

                    //////// End year for employee///////
                    Date endEndDate = dateFormat.parse(appraisalFillingData.getYearEndEndDate());
                    Date endStartDate = dateFormat.parse(appraisalFillingData.getYearEndStartDate());
                    if ((currentDate.after(endStartDate) && (currentDate.before(endEndDate))) || currentDate.equals(endStartDate) || currentDate.equals(endEndDate)) {
                        if (!endSelfApproval.equals("Approved")) {
                            endSelfApproval = "Pendding";
                        }
                    } else if (currentDate.after(endEndDate)) {
                        if (!endSelfApproval.equals("Approved")) {
                            endSelfApproval = "Expired";
                        }
                    } else if (!endSelfApproval.equals("Approved")) {
                        endSelfApproval = "";
                    }

                    /////////////////////////Manager End year////////////////////////////////////
                    Date managerYearEndEndDate = dateFormat.parse(appraisalFillingData.getManagerYearEndEndDate());
                    Date managerYearEndStartDate = dateFormat.parse(appraisalFillingData.getManagerYearEndStartDate());
//                    if ((currentDate.after(managerYearEndEndDate) && currentDate.before(managerYearEndStartDate)) || currentDate.equals(managerYearEndStartDate) || currentDate.equals(managerYearEndEndDate)) {

                    if ((currentDate.after(managerYearEndStartDate) && currentDate.before(managerYearEndEndDate)) || currentDate.equals(managerYearEndStartDate) || currentDate.equals(managerYearEndEndDate)) {
                        if (!managerEndSelfApproval.equals("Approved") && !managerEndSelfApproval.equals("Rework")) {
                            managerEndSelfApproval = "Pendding";
                        }
                    } else if (currentDate.after(managerYearEndEndDate)) {
                        if (!managerEndSelfApproval.equals("Approved") && !managerEndSelfApproval.equals("Rework")) {
                            managerEndSelfApproval = "Expired";
                        }
                    } else if (!managerEndSelfApproval.equals("Approved") && !managerEndSelfApproval.equals("Rework")) {
                        managerEndSelfApproval = "";
                    }
                }
            }
        } else {

//            List appraisalFillingDataList = appraisalFillingDataService.readByCurrentYear("" + year);
            List appraisalFillingDataList = appraisalFillingDataService.getappraisalDate();
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            if (!appraisalFillingDataList.isEmpty()) {
                /////////////////////////Employee start///////////////////////////////////////
                appraisalFillingData = (AppraisalFillingData) appraisalFillingDataList.get(0);
//
                Date currentDate = dateFormat.parse(dateFormat.format(new Date()));

                Date startendDate = dateFormat.parse(appraisalFillingData.getEndDate());
                Date startDate = dateFormat.parse(appraisalFillingData.getStartDate());
                if ((currentDate.after(startDate) && currentDate.before(startendDate)) || currentDate.equals(startendDate) || currentDate.equals(startDate)) {
                    if (!goalSetting.equals("Approved")) {
                        goalSetting = "Pendding";
                    }
                } else if (currentDate.after(startendDate)) {
                    if (!goalSetting.equals("Approved")) {
                        goalSetting = "Expired";
                    }
                } else if (!goalSetting.equals("Approved")) {
                    goalSetting = "";
                }

                /// Manager side Weight==>Time Line First////
                Date ManagerEndDate = dateFormat.parse(appraisalFillingData.getManagerEndDate());
                Date ManagerStartDate = dateFormat.parse(appraisalFillingData.getManagerStartDate());
                if ((currentDate.after(ManagerStartDate) && currentDate.before(ManagerEndDate)) || currentDate.equals(ManagerStartDate) || currentDate.equals(ManagerEndDate)) {
                    if (!goalApproval.equals("Approved")) {
                        goalApproval = "Pendding";
                    }
                } else if (currentDate.after(ManagerEndDate)) {
                    if (!goalApproval.equals("Approved")) {
                        goalApproval = "Expired";
                    }
                } else if (!goalApproval.equals("Approved")) {
                    goalApproval = "";
                }

                /////////////////////mid year Employee//////////////////////
                Date MidendDate = dateFormat.parse(appraisalFillingData.getMidYearEndDate());
                Date MidYearStartDate = dateFormat.parse(appraisalFillingData.getMidYearStartDate());
                if ((currentDate.after(MidYearStartDate) && currentDate.before(MidendDate)) || currentDate.equals(MidendDate) || currentDate.equals(MidYearStartDate)) {
                    if (!midSelfApproval.equals("Approved")) {
                        midSelfApproval = "Pendding";
                    }
                } else if (currentDate.after(MidendDate)) {
                    if (!midSelfApproval.equals("Approved")) {
                        midSelfApproval = "Expired";
                    }
                } else if (!midSelfApproval.equals("Approved")) {
                    midSelfApproval = "";
                }

                /// Manager side self assements==>Time Line Mid-Time////
                Date ManagerMidDate = dateFormat.parse(appraisalFillingData.getManagerMidYearEndDate());
                Date ManagerMidStartDate = dateFormat.parse(appraisalFillingData.getManagerMidYearStartDate());
                if ((currentDate.after(ManagerMidStartDate) && currentDate.before(ManagerMidDate)) || currentDate.equals(ManagerMidStartDate) || currentDate.equals(ManagerMidDate)) {
                    if (!managerMidSelfApproval.equals("Approved")) {
                        managerMidSelfApproval = "Pendding";
                    }
                } else if (currentDate.after(ManagerMidDate)) {
                    if (!managerMidSelfApproval.equals("Approved")) {
                        managerMidSelfApproval = "Expired";
                    }
                } else if (!managerMidSelfApproval.equals("Approved")) {
                    managerMidSelfApproval = "";
                }
                //////// End year for employee///////
                Date endEndDate = dateFormat.parse(appraisalFillingData.getYearEndEndDate());
                Date endStartDate = dateFormat.parse(appraisalFillingData.getYearEndStartDate());
                if ((currentDate.after(endStartDate) && (currentDate.before(endEndDate))) || currentDate.equals(endStartDate) || currentDate.equals(endEndDate)) {
                    if (!endSelfApproval.equals("Approved")) {
                        endSelfApproval = "Pendding";
                    }
                } else if (currentDate.after(endEndDate)) {
                    if (!endSelfApproval.equals("Approved")) {
                        endSelfApproval = "Expired";
                    }
                } else if (!endSelfApproval.equals("Approved")) {
                    endSelfApproval = "";
                }

                /////////////////////////Manager End year////////////////////////////////////
                Date managerYearEndEndDate = dateFormat.parse(appraisalFillingData.getManagerYearEndEndDate());
                Date managerYearEndStartDate = dateFormat.parse(appraisalFillingData.getManagerYearEndStartDate());
                if ((currentDate.after(managerYearEndStartDate) && currentDate.before(managerYearEndEndDate)) || currentDate.equals(managerYearEndStartDate) || currentDate.equals(managerYearEndEndDate)) {
                    if (!managerEndSelfApproval.equals("Approved")) {
                        managerEndSelfApproval = "Pendding";
                    }
                } else if (currentDate.after(managerYearEndEndDate)) {
                    if (!managerEndSelfApproval.equals("Approved")) {
                        managerEndSelfApproval = "Expired";
                    }
                } else if (!managerEndSelfApproval.equals("Approved")) {
                    managerEndSelfApproval = "";
                }

            }
//            goalApproval = "Expired";
//            goalSetting = "Expired";
//            midSelfApproval="Expired";
//            managerMidSelfApproval="Expired";
//            endSelfApproval="Expired";
//            managerEndSelfApproval="Expired";
        }
        request.setAttribute("goalApproval", goalApproval);
        request.setAttribute("goalSetting", goalSetting);
        request.setAttribute("midSelfApproval", midSelfApproval);
        request.setAttribute("managerMidSelfApproval", managerMidSelfApproval);
        request.setAttribute("endSelfApproval", endSelfApproval);
        request.setAttribute("managerEndSelfApproval", managerEndSelfApproval);
//        Employee
//        List timeLineData = appraisalFillingDataService.readByCurrentYear("" + year);
        List timeLineData = appraisalFillingDataService.getappraisalDate();
        if (!timeLineData.isEmpty()) {
            appraisalFillingData1 = (AppraisalFillingData) timeLineData.get(0);
        }
        if (!timeLineData.isEmpty()) {

            request.setAttribute("employeeStartDate", appraisalFillingData1.getStartDate());
            request.setAttribute("employeeEndDate", appraisalFillingData1.getEndDate());
            request.setAttribute("employeeMidStartDate", appraisalFillingData1.getMidYearStartDate());
            request.setAttribute("employeeMidEndDate", appraisalFillingData1.getMidYearEndDate());
            request.setAttribute("employeeEndStartDate", appraisalFillingData1.getYearEndStartDate());
            request.setAttribute("employeeEndEndDate", appraisalFillingData1.getYearEndEndDate());

//        Manager
            request.setAttribute("ManagerStartDate", appraisalFillingData1.getManagerStartDate());
            request.setAttribute("ManagerEndDate", appraisalFillingData1.getManagerEndDate());
            request.setAttribute("ManagerMidStartDate", appraisalFillingData1.getManagerMidYearStartDate());
            request.setAttribute("ManagerMidEndDate", appraisalFillingData1.getManagerMidYearEndDate());
            request.setAttribute("ManagerEndStartDate", appraisalFillingData1.getManagerYearEndStartDate());
            request.setAttribute("ManagerEndEndDate", appraisalFillingData1.getManagerYearEndEndDate());
            readPendingPmpStatus(request, response);
        }

//        appraisalPerformanceKraService.
//        mv.setViewName("forward:userMaster.htm?act=userDashboardShow");
        mv.setViewName("forward:leaveEmployeeDetail.htm?act=userDashboardLeavePendingRequest");
        return mv;
    }

    //this method is for read perfomance management stage wise on hrDashboard.
    public ModelAndView hrDashboard(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        Year year = Year.now();
        int currentYear = Integer.parseInt(year.toString());
        List<?> l1 = appraisalFillingDataService.getCurrentAndPreviousYear();
        String previousYear = "";
//        int currentYear = 0;
        if (!l1.isEmpty()) {
            Object[] obj = (Object[]) l1.get(0);
//            previousYear = (Integer) obj[0];
            previousYear = "" + obj[0];
//            currentYear = (Integer) obj[1];
        }
        try {

//            Object[] performanceManagementArray = appraisalPerformanceService.readperformanceByHr(currentYear);
            List finalArray = new ArrayList();
            List performanceManagementArray = appraisalPerformanceService.readperformanceByHr();
            finalArray.add(performanceManagementArray.get(0));
            try {
//                int performanceManagementArray1 = appraisalPerformanceService.readperformanceByHr1(currentYear);
                int performanceManagementArray1 = appraisalPerformanceService.readperformanceByHr1(Integer.parseInt(previousYear));
                finalArray.add(performanceManagementArray1);
            } catch (Exception ex) {
                finalArray.add(0);

            }
            try {
//                int performanceManagementArray2 = appraisalPerformanceService.readperformanceByHr2(currentYear);
                int performanceManagementArray2 = appraisalPerformanceService.readperformanceByHr2(Integer.parseInt(previousYear));
                finalArray.add(performanceManagementArray2);
            } catch (Exception e) {
                finalArray.add(0);
            }

            try {
//                int performanceManagementArray3 = appraisalPerformanceService.readperformanceByHr3(currentYear);
                int performanceManagementArray3 = appraisalPerformanceService.readperformanceByHr3(Integer.parseInt(previousYear));
                finalArray.add(performanceManagementArray3);
            } catch (Exception e) {
                finalArray.add(0);
            }
            try {
//                int performanceManagementArray4 = appraisalPerformanceService.readperformanceByHr4(currentYear);
                int performanceManagementArray4 = appraisalPerformanceService.readperformanceByHr4(Integer.parseInt(previousYear));
                finalArray.add(performanceManagementArray4);
            } catch (Exception e) {
                finalArray.add(0);
            }
            try {
//                int performanceManagementArray5 = appraisalPerformanceService.readperformanceByHr5(currentYear);
                int performanceManagementArray5 = appraisalPerformanceService.readperformanceByHr5(Integer.parseInt(previousYear));
                finalArray.add(performanceManagementArray5);
            } catch (Exception e) {
                finalArray.add(0);
            }
            try {
//                int performanceManagementArray6 = appraisalPerformanceService.readperformanceByHr6(currentYear);
                int performanceManagementArray6 = appraisalPerformanceService.readperformanceByHr6(Integer.parseInt(previousYear));
                finalArray.add(performanceManagementArray6);
            } catch (Exception e) {
                finalArray.add(0);
            }
            mv.addObject("performanceManagementStage", finalArray);
        } catch (Exception e) {
//            performanceManagementArray.add("0");
//            performanceManagementArray.add("0");
//            performanceManagementArray.add("0");
//            performanceManagementArray.add("0");
//            performanceManagementArray.add("0");
//            performanceManagementArray.add("0");
//            mv.addObject("performanceManagementStage", performanceManagementArray);
        }
        mv.setViewName("forward:appraisalPerformanceBehaviors.htm?act=hrDashboard");
        return mv;
    }

    public ModelAndView appraisalPerformancePrint(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
//        ModelAndView mv = new ModelAndView();
//        AppraisalPerformanceMaster appraisalPerformanceMaster = new AppraisalPerformanceMaster();
//        UpdateAppraisalPerformanceKra updateAppraisalPerformanceKra = new UpdateAppraisalPerformanceKra();
//        AppraisalPerformanceKra appraisalPerformanceKra = new AppraisalPerformanceKra();
//        EmployeeMaster employee = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
//        String employeeName = "" + employee.getEmployeeName();
//        String empId = request.getParameter("id");
//        String userid = request.getParameter("userid");
//        String appraisalId1 = request.getParameter("appraisalId");
//        selectedEmployeeDate(request, response, userid);
//        String employeeId = "" + empId;//set the value in employee id
//        appraisalPerformanceMaster = appraisalPerformanceService.readById(Integer.parseInt(appraisalId1));
//        if (null != appraisalPerformanceMaster.getWeightageScore()) {
//            String weightageScore = appraisalPerformanceMaster.getWeightageScore();
//            request.setAttribute("weightageScore", weightageScore);
//        }
//        if (null != appraisalPerformanceMaster.getTotalScore()) {
//            String totalScore = appraisalPerformanceMaster.getTotalScore();
//            request.setAttribute("totalScore", totalScore);
//        }
//        // ==========================Mid Year=======================================================//
//        if (null != appraisalPerformanceMaster.getEmpMidyearSelfassOtheractivty()) {
//            String empMidyearSelfassOtheractivty = appraisalPerformanceMaster.getEmpMidyearSelfassOtheractivty();
//            request.setAttribute("empMidyearSelfassOtheractivty", empMidyearSelfassOtheractivty);
//        }
//        if (null != appraisalPerformanceMaster.getManagerMidyearReviewevalOtheractivity()) {
//            String managerMidyearReviewevalOtheractivity = appraisalPerformanceMaster.getManagerMidyearReviewevalOtheractivity();
//            request.setAttribute("managerMidyearReviewevalOtheractivity", managerMidyearReviewevalOtheractivity);
//        }
//        // ==========================Mid Year=======================================================//
//        //=======End Year=============//
//        if (null != appraisalPerformanceMaster.getEmpEndyearSelfassOtheractivty()) {
//            String empEndyearSelfassOtheractivty = appraisalPerformanceMaster.getEmpEndyearSelfassOtheractivty();
//            request.setAttribute("empEndyearSelfassOtheractivty", empEndyearSelfassOtheractivty);
//        }
//        if (null != appraisalPerformanceMaster.getManagerEndyearReviewevalOtheractivity()) {
//            String managerEndyearReviewevalOtheractivity = appraisalPerformanceMaster.getManagerEndyearReviewevalOtheractivity();
//            request.setAttribute("managerEndyearReviewevalOtheractivity", managerEndyearReviewevalOtheractivity);
//        }
//        /////////////////behaviors/////////////////
//        if (null != appraisalPerformanceMaster.getBehaviorsMidyearTotalscore()) {
//            String behaviorsMidyearTotalscore = appraisalPerformanceMaster.getBehaviorsMidyearTotalscore();
//            request.setAttribute("behaviorsMidyearTotalscore", behaviorsMidyearTotalscore);
//        }
//        if (null != appraisalPerformanceMaster.getBehaviorsMidyearOtherremark()) {
//            String behaviorsMidyearOtherremark = appraisalPerformanceMaster.getBehaviorsMidyearOtherremark();
//            request.setAttribute("behaviorsMidyearOtherremark", behaviorsMidyearOtherremark);
//        }
//        if (null != appraisalPerformanceMaster.getBehaviorsEndyearOtherremark()) {
//            String behaviorsEndyearOtherremark = appraisalPerformanceMaster.getBehaviorsEndyearOtherremark();
//            request.setAttribute("behaviorsEndyearOtherremark", behaviorsEndyearOtherremark);
//        }
//        if (null != appraisalPerformanceMaster.getBehaviorsEndyearOtherremark()) {
//            String behaviorsEndyearTotalscore = appraisalPerformanceMaster.getBehaviorsEndyearTotalscore();
//            request.setAttribute("behaviorsEndyearTotalscore", behaviorsEndyearTotalscore);
//        }
//        if (null != appraisalPerformanceMaster.getBehaviorsEndyearTotalscore()) {
//            String behaviorsEndyearTotalscore = appraisalPerformanceMaster.getBehaviorsEndyearTotalscore();
//            request.setAttribute("behaviorsEndyearTotalscore", behaviorsEndyearTotalscore);
//        }
//        if (null != appraisalPerformanceMaster.getBehaviorsFinalscore()) {
//            String behaviorsFinalscore = appraisalPerformanceMaster.getBehaviorsFinalscore();
//            request.setAttribute("behaviorsFinalscore", behaviorsFinalscore);
//        }
//        int year = Calendar.getInstance().get(Calendar.YEAR);
//        List<?> list = appraisalPerformanceService.readByAppraisalPerformanceId(employeeId, year);
//        if (!list.isEmpty()) {
//
//            appraisalPerformanceMaster = (AppraisalPerformanceMaster) list.get(0);
//            int appraisalId = appraisalPerformanceMaster.getId();
//            //AppraisalPerformanceKra appraisalPerformanceKra = new AppraisalPerformanceKra();
//            appraisalPerformanceKra.setId(appraisalId);
//            String kragoal = "";
//
//            List<?> kraList = appraisalPerformanceKraService.readByAppraisalKraGoal(appraisalPerformanceKra);
//            if (!kraList.isEmpty()) {
//                appraisalPerformanceKra = (AppraisalPerformanceKra) kraList.get(0);
//                kragoal = appraisalPerformanceKra.getKraGoal();
//            }
//            request.setAttribute("kragoal", kraList);
//            request.setAttribute("weightage", kraList);
//            request.setAttribute("appraisalId", appraisalId);
//            request.setAttribute("empMidyearSelfassessmentGoal", kraList);
//            request.setAttribute("managerMidyearReviewEvaluation", kraList);
//            request.setAttribute("midyearStatus", kraList);
//            request.setAttribute("endyearStatus", kraList);
//            request.setAttribute("empEndyearSelfassessmentGoal", kraList);
//            request.setAttribute("editDate", kraList);
//            request.setAttribute("startDate", kraList);
//
//        }
//        // =======================competency Evaluation==========================================================//
//        competencyList(request);
//        int competencyId = 0;
//        AppraisalPerformanceCompetencyEvaluation appraisalPerformanceCompetencyEvaluation = new AppraisalPerformanceCompetencyEvaluation();
//        appraisalPerformanceCompetencyEvaluation.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
//        CompetencyEvaluationTextmaster competencyEvaluationTextmaster = new CompetencyEvaluationTextmaster();
//        List<?> competencyEvaluationList = appraisalPerformanceCompetencyEvaluationService.readAppraisalPerformanceCompetencyEvaluationDetail(appraisalPerformanceCompetencyEvaluation);
//
//        request.setAttribute("competencyEvaluationList", competencyEvaluationList);
//
//        //Individual Development Plan//
//        AppraisalPerformanceIndividualDevelopmentPlan appraisalPerformanceIndividualDevelopmentPlan = new AppraisalPerformanceIndividualDevelopmentPlan();
//        appraisalPerformanceIndividualDevelopmentPlan.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
//        String text1 = "";
//        List<?> individualDevelopmentPlanList = appraisalPerformanceIndividualDevelopmentPlanService.readIndividualDevelopmentPlanDetail(appraisalPerformanceIndividualDevelopmentPlan);
//        if (!individualDevelopmentPlanList.isEmpty()) {
//            appraisalPerformanceIndividualDevelopmentPlan = (AppraisalPerformanceIndividualDevelopmentPlan) individualDevelopmentPlanList.get(0);
//            text1 = appraisalPerformanceIndividualDevelopmentPlan.getText1();
//        }
//        request.setAttribute("text1", individualDevelopmentPlanList);
//        request.setAttribute("text2", individualDevelopmentPlanList);
//        request.setAttribute("text3", individualDevelopmentPlanList);
//        request.setAttribute("remark", individualDevelopmentPlanList);
//        request.setAttribute("midYearRemark", individualDevelopmentPlanList);
//        request.setAttribute("endYearRemark", individualDevelopmentPlanList);
//        request.setAttribute("individualDevelopmentPlanList", individualDevelopmentPlanList);
//
//        //////////Behaviors///////////////
//        AppraisalPerformanceBehaviors appraisalPerformanceBehaviors = new AppraisalPerformanceBehaviors();
//        String behaviors = "";
//        appraisalPerformanceBehaviors.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
//        List<?> behaviorsList = appraisalPerformanceBehaviorsService.readBehaviorsDetail(appraisalPerformanceBehaviors);
//        if (!behaviorsList.isEmpty()) {
//            appraisalPerformanceBehaviors = (AppraisalPerformanceBehaviors) behaviorsList.get(0);
//            behaviors = appraisalPerformanceBehaviors.getBehaviors();
//        }
//        request.setAttribute("behaviors", behaviorsList);
//        request.setAttribute("behaviorsList", behaviorsList);
        ModelAndView mv = new ModelAndView();
        AppraisalPerformanceMaster appraisalPerformanceMaster = new AppraisalPerformanceMaster();
        UpdateAppraisalPerformanceKra updateAppraisalPerformanceKra = new UpdateAppraisalPerformanceKra();
        AppraisalPerformanceKra appraisalPerformanceKra = new AppraisalPerformanceKra();
        EmployeeMaster employee = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        String employeeName = "" + employee.getEmployeeName();
        String empId = request.getParameter("id");
        String userid = request.getParameter("userid");
        String appraisalId1 = request.getParameter("appraisalId");
        //////Print/////By dhaval
        request.setAttribute("empId", empId);
        request.setAttribute("userid", userid);
        request.setAttribute("appraisalId1", appraisalId1);
        ///////////
//        selectedEmployeeDate(request, response, userid);
//        managerTimeLineDate(request, response, userid);
        kraCategoryList(request);
        String employeeId = "" + empId;//set the value in employee id
        appraisalPerformanceMaster = appraisalPerformanceService.readById(Integer.parseInt(appraisalId1));
        if (null != appraisalPerformanceMaster.getWeightageScore()) {
            String weightageScore = appraisalPerformanceMaster.getWeightageScore();
            request.setAttribute("weightageScore", weightageScore);
        }
        if (null != appraisalPerformanceMaster.getTotalScore()) {
            String totalScore = appraisalPerformanceMaster.getTotalScore();
            request.setAttribute("totalScore", totalScore);
        }
        if (null != appraisalPerformanceMaster.getEmployeeTotalFinalScore()) {
            String empScore = appraisalPerformanceMaster.getEmployeeTotalFinalScore();
            request.setAttribute("empScore", empScore);
        }
        // ==========================Mid Year=======================================================//
//        if (null != appraisalPerformanceMaster.getEmpMidyearSelfassOtheractivty()) {
//            String empMidyearSelfassOtheractivty = appraisalPerformanceMaster.getEmpMidyearSelfassOtheractivty();
//            request.setAttribute("empMidyearSelfassOtheractivty", empMidyearSelfassOtheractivty);
//        }
//        if (null != appraisalPerformanceMaster.getManagerMidyearReviewevalOtheractivity()) {
//            String managerMidyearReviewevalOtheractivity = appraisalPerformanceMaster.getManagerMidyearReviewevalOtheractivity();
//            request.setAttribute("managerMidyearReviewevalOtheractivity", managerMidyearReviewevalOtheractivity);
//        }
        // ==========================Mid Year=======================================================//
        //=======End Year=============//
        if (null != appraisalPerformanceMaster.getEmpEndyearSelfassOtheractivty()) {
            String empEndyearSelfassOtheractivty = appraisalPerformanceMaster.getEmpEndyearSelfassOtheractivty();
            request.setAttribute("empEndyearSelfassOtheractivty", empEndyearSelfassOtheractivty);
        }
        if (null != appraisalPerformanceMaster.getManagerEndyearReviewevalOtheractivity()) {
            String managerEndyearReviewevalOtheractivity = appraisalPerformanceMaster.getManagerEndyearReviewevalOtheractivity();
            request.setAttribute("managerEndyearReviewevalOtheractivity", managerEndyearReviewevalOtheractivity);
        }
        /////////////////behaviors/////////////////
        if (null != appraisalPerformanceMaster.getBehaviorsMidyearTotalscore()) {
            String behaviorsMidyearTotalscore = appraisalPerformanceMaster.getBehaviorsMidyearTotalscore();
            request.setAttribute("behaviorsMidyearTotalscore", behaviorsMidyearTotalscore);
        }
        if (null != appraisalPerformanceMaster.getBehaviorsMidyearOtherremark()) {
            String behaviorsMidyearOtherremark = appraisalPerformanceMaster.getBehaviorsMidyearOtherremark();
            request.setAttribute("behaviorsMidyearOtherremark", behaviorsMidyearOtherremark);
        }
        if (null != appraisalPerformanceMaster.getBehaviorsEndyearOtherremark()) {
            String behaviorsEndyearOtherremark = appraisalPerformanceMaster.getBehaviorsEndyearOtherremark();
            request.setAttribute("behaviorsEndyearOtherremark", behaviorsEndyearOtherremark);
        }
        if (null != appraisalPerformanceMaster.getBehaviorsEndyearOtherremark()) {
            String behaviorsEndyearTotalscore = appraisalPerformanceMaster.getBehaviorsEndyearTotalscore();
            request.setAttribute("behaviorsEndyearTotalscore", behaviorsEndyearTotalscore);
        }
        if (null != appraisalPerformanceMaster.getBehaviorsEndyearTotalscore()) {
            String behaviorsEndyearTotalscore = appraisalPerformanceMaster.getBehaviorsEndyearTotalscore();
            request.setAttribute("behaviorsEndyearTotalscore", behaviorsEndyearTotalscore);
        }
        if (null != appraisalPerformanceMaster.getManagerActivityScore()) {
            String managerActivityScore = appraisalPerformanceMaster.getManagerActivityScore();
            request.setAttribute("managerActivityScore", managerActivityScore);
        }
//        if (null != appraisalPerformanceMaster.getManagerStatus()) {
        int managerStatus = appraisalPerformanceMaster.getManagerStatus();
        request.setAttribute("managerStatus", managerStatus);
//        }
//        if (null != appraisalPerformanceMaster.getBehaviorsFinalscore()) {
//            String behaviorsFinalscore = appraisalPerformanceMaster.getBehaviorsFinalscore();
//            request.setAttribute("behaviorsFinalscore", behaviorsFinalscore);
//        }

        if (null != appraisalPerformanceMaster.getBehaviorsFinalscore() && !"NaN".equals(appraisalPerformanceMaster.getBehaviorsFinalscore())) {
            String behaviorsFinalscore = appraisalPerformanceMaster.getBehaviorsFinalscore();
            request.setAttribute("behaviorsFinalscore", behaviorsFinalscore);
        } else {
            String behaviorsFinalscore = "";
            request.setAttribute("behaviorsFinalscore", behaviorsFinalscore);

        }
//        } else {
//            String behaviorsFinalscore = "";
//            request.setAttribute("behaviorsFinalscore", behaviorsFinalscore);
//        }
        //int year = Calendar.getInstance().get(Calendar.YEAR);
        String year = appraisalPerformanceMaster.getBehaviorsYear();
        request.setAttribute("year", year);
//        List<?> list = appraisalPerformanceService.readByAppraisalPerformanceId(employeeId);
        List<?> list = appraisalPerformanceService.readByAppraisalPerformanceIdNew(employeeId, year);
        if (!list.isEmpty()) {

            appraisalPerformanceMaster = (AppraisalPerformanceMaster) list.get(0);
            int appraisalId = appraisalPerformanceMaster.getId();
            //AppraisalPerformanceKra appraisalPerformanceKra = new AppraisalPerformanceKra();
            appraisalPerformanceKra.setId(appraisalId);
            String kragoal = "";
            String metric = "";
            //int weightage = 0;
            boolean updateStatus = false;
            int kragoalId;
            List<?> kraList = appraisalPerformanceKraService.readByAppraisalKraGoal(appraisalPerformanceKra);
            if (!kraList.isEmpty()) {
                appraisalPerformanceKra = (AppraisalPerformanceKra) kraList.get(0);
                kragoal = appraisalPerformanceKra.getKraGoal();
                kragoalId = appraisalPerformanceKra.getId();
                metric = appraisalPerformanceKra.getMetric();
                if (null != kragoal && !"".equals(kragoal)) {

                    UpdateAppraisalPerformanceKra updateAppraisalPerformanceKra1 = new UpdateAppraisalPerformanceKra();
                    updateAppraisalPerformanceKra.setId(Integer.parseInt("" + kragoalId));
                    List<?> updateAppraisalPerformanceKra1List = updateAppraisalPerformanceKraService.readByUserUpdateKra(updateAppraisalPerformanceKra);
                    if (!updateAppraisalPerformanceKra1List.isEmpty()) {

                        updateAppraisalPerformanceKra1 = (UpdateAppraisalPerformanceKra) updateAppraisalPerformanceKra1List.get(0);
                        if (!kragoal.equals(updateAppraisalPerformanceKra1.getUpdateKra()) || !metric.equals(updateAppraisalPerformanceKra1.getUpdateMetric())) {
                            updateStatus = true;
                        }
                    }
                }
            }
            request.setAttribute("updateStatus", updateStatus);
            request.setAttribute("kragoal", kraList);
//            request.setAttribute("kraGoalByManager", kraList);
            request.setAttribute("weightage", kraList);
            request.setAttribute("appraisalId", appraisalId);
            request.setAttribute("empMidyearSelfassessmentGoal", kraList);
            request.setAttribute("managerMidyearReviewEvaluation", kraList);
            request.setAttribute("midyearStatus", kraList);
            request.setAttribute("endyearStatus", kraList);
            request.setAttribute("empEndyearSelfassessmentGoal", kraList);
            request.setAttribute("editDate", kraList);
            request.setAttribute("startDate", kraList);

        }

        ////////////////////////////////////KRA OTHER Activity///////////////////////////////////////////////////////////
        String kragoal_activity = "";
        String metric_activity = "";
        boolean kraOtherupdateStatus = false;
        int kragoalactivityId;
        if (null != appraisalPerformanceMaster.getId()) {

            AppraisalPerformanceActivities appraisalPerformanceActivities = new AppraisalPerformanceActivities();
            appraisalPerformanceActivities.setAppraisalPerformanceMaster(appraisalPerformanceMaster);

            List<?> kraOtherList = appraisalPerformanceActivitiesService.readByAppraisalKraGoalActivities(appraisalPerformanceActivities);
            if (!kraOtherList.isEmpty()) {
                appraisalPerformanceActivities = (AppraisalPerformanceActivities) kraOtherList.get(0);
                kragoal_activity = appraisalPerformanceActivities.getKraGoalActivities();
                kragoalactivityId = appraisalPerformanceActivities.getId();
                metric_activity = appraisalPerformanceActivities.getMetricActivities();

                if (null != kragoal_activity && !"".equals(kragoal_activity)) {
                    UpdateAppraisalPerformanceActivities updateAppraisalPerformanceActivities = new UpdateAppraisalPerformanceActivities();
                    updateAppraisalPerformanceActivities.setId(Integer.parseInt("" + kragoalactivityId));
                    List<?> updateKraOtherList = updateAppraisalPerformanceActivitiesService.readByUserUpdateKraOther(updateAppraisalPerformanceActivities);
                    if (!updateKraOtherList.isEmpty()) {

                        updateAppraisalPerformanceActivities = (UpdateAppraisalPerformanceActivities) updateKraOtherList.get(0);
                        if (!kragoal_activity.equals(updateAppraisalPerformanceActivities.getKraActivity()) || !metric_activity.equals(updateAppraisalPerformanceActivities.getMetricActivity())) {
                            kraOtherupdateStatus = true;
                        }
                    }
                }
            }
            request.setAttribute("kraOtherupdateStatus", kraOtherupdateStatus);
            request.setAttribute("kragoalOtherActivity", kraOtherList);
        }
        ////////////////////////////////////KRA OTHER Activity//////////////////////////////////////////////////////////

        // =======================competency Evaluation==========================================================//
        competencyList(request);
        int competencyId = 0;
        AppraisalPerformanceCompetencyEvaluation appraisalPerformanceCompetencyEvaluation = new AppraisalPerformanceCompetencyEvaluation();
        appraisalPerformanceCompetencyEvaluation.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
        CompetencyEvaluationTextmaster competencyEvaluationTextmaster = new CompetencyEvaluationTextmaster();
        List<?> competencyEvaluationList = appraisalPerformanceCompetencyEvaluationService.readAppraisalPerformanceCompetencyEvaluationDetail(appraisalPerformanceCompetencyEvaluation);

        request.setAttribute("competencyEvaluationList", competencyEvaluationList);

        //Individual Development Plan//
        AppraisalPerformanceIndividualDevelopmentPlan appraisalPerformanceIndividualDevelopmentPlan = new AppraisalPerformanceIndividualDevelopmentPlan();
        appraisalPerformanceIndividualDevelopmentPlan.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
        String text1 = "";
        List<?> individualDevelopmentPlanList = appraisalPerformanceIndividualDevelopmentPlanService.readIndividualDevelopmentPlanDetail(appraisalPerformanceIndividualDevelopmentPlan);
        if (!individualDevelopmentPlanList.isEmpty()) {
            appraisalPerformanceIndividualDevelopmentPlan = (AppraisalPerformanceIndividualDevelopmentPlan) individualDevelopmentPlanList.get(0);
            text1 = appraisalPerformanceIndividualDevelopmentPlan.getText1();
        }
        request.setAttribute("text1", individualDevelopmentPlanList);
        request.setAttribute("text2", individualDevelopmentPlanList);
        request.setAttribute("text3", individualDevelopmentPlanList);
        request.setAttribute("remark", individualDevelopmentPlanList);
        request.setAttribute("midYearRemark", individualDevelopmentPlanList);
        request.setAttribute("endYearRemark", individualDevelopmentPlanList);
        request.setAttribute("individualDevelopmentPlanList", individualDevelopmentPlanList);

        //////////Behaviors///////////////
        AppraisalPerformanceBehaviors appraisalPerformanceBehaviors = new AppraisalPerformanceBehaviors();
        String behaviors = "";
        appraisalPerformanceBehaviors.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
        List<?> behaviorsList = appraisalPerformanceBehaviorsService.readBehaviorsDetail(appraisalPerformanceBehaviors);
        if (!behaviorsList.isEmpty()) {
            appraisalPerformanceBehaviors = (AppraisalPerformanceBehaviors) behaviorsList.get(0);
            behaviors = appraisalPerformanceBehaviors.getBehaviors();
        }
        request.setAttribute("behaviors", behaviorsList);
        request.setAttribute("behaviorsList", behaviorsList);

        mv.getModelMap().put("appraisalPerformanceMaster", appraisalPerformanceMaster);
        mv.getModelMap().put("appraisalPerformanceMaster", appraisalPerformanceMaster);

        mv.setViewName("Appraisal/PerformanceAppraisalFormPrintReport");
        return mv;
    }

    public ModelAndView searchOwnappraisalPerformanceSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AppraisalPerformanceMaster appraisalPerformanceMaster = new AppraisalPerformanceMaster();
//        List<?> employeeMasterList = employeeMasterService.read();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");

//        UserMaster user = (UserMaster) request.getSession().getAttribute("user");
//        UserRightMaster user1 = (UserRightMaster) request.getSession().getAttribute("userRight");
        int cyear = Calendar.getInstance().get(Calendar.YEAR);
        List<?> l1 = appraisalFillingDataService.getCurrentAndPreviousYear();
        String previousYear = "";
        int currentYear = 0;
        if (!l1.isEmpty()) {
            Object[] obj = (Object[]) l1.get(0);
//            previousYear = (Integer) obj[0];
            previousYear = "" + obj[0];
//            currentYear = (Integer) obj[1];
        } else {
            previousYear = "0";
        }
        AppraisalPerformanceKra appraisalPerformanceKra = new AppraisalPerformanceKra();
        pmpyearList(request);
        yearList(request);
//        List<?> appraisalPerformanceList = appraisalPerformanceService.readOwnAppraisalPerformance(employeeMaster, cyear);
        List<?> appraisalPerformanceList = appraisalPerformanceService.readOwnAppraisalPerformance(employeeMaster, Integer.parseInt(previousYear));
        List<?> appraisalPerformanceListTime = appraisalPerformanceService.readOwnAppraisalPerformanceTimeLine(employeeMaster, Integer.parseInt(previousYear));

        String year1 = request.getParameter("pmpyear");
        if (null == year1) {
            Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);
            year1 = "" + year;
        }
        int year = Calendar.getInstance().get(Calendar.YEAR);
        String goalSetting = "Pendding";
        String goalApproval = "";
        String midSelfApproval = "";
        String managerMidSelfApproval = "";
        String endSelfApproval = "";
        String managerEndSelfApproval = "";
        int ManagerStatus = 0;
        int i = 0;
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date currentDate = dateFormat.parse(dateFormat.format(new Date()));
        List appraisalPerformanceList1 = new LinkedList();
        if (null != appraisalPerformanceList && !appraisalPerformanceList.isEmpty()) {
//       
//            List appraisalFillingDataList1 = appraisalFillingDataService.readByIdNew(appraisalPerformanceList.);
//         

//            AppraisalFillingData appraisalFillingData1 = (AppraisalFillingData) appraisalFillingDataList1.get(0);
//                        Date currentDate = new Date();
//
//            }
            for (Object o1 : appraisalPerformanceList) {

                Object o11[] = (Object[]) o1;

                String aa = o11[0].toString();
                appraisalPerformanceMaster = appraisalPerformanceService.readById(Integer.parseInt(aa));
                if (!appraisalPerformanceMaster.equals("")) {
                    ManagerStatus = appraisalPerformanceMaster.getManagerStatus();
                }
//            }
                appraisalPerformanceKra.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
                List list = appraisalPerformanceKraService.readByAppraisalPerformancekraId(appraisalPerformanceKra);
                for (Object o : list) {
                    goalSetting = "Pendding";

                    AppraisalPerformanceKra appraisalPerformanceKra1 = (AppraisalPerformanceKra) o;

                    if (appraisalPerformanceKra1.getKraGoal() != null && appraisalPerformanceKra1.getMetric() != null) {
                        goalSetting = "Approved";
                        break;
                    }
                }
                for (Object o2 : list) {
                    goalApproval = "";
                    AppraisalPerformanceKra appraisalPerformanceKra1 = (AppraisalPerformanceKra) o2;
//                 
                    if (appraisalPerformanceKra1.getWeightage() != null && ManagerStatus == 1) {
                        goalApproval = "Approved";
                        break;
                    } else if (appraisalPerformanceMaster.getReworkStatus() == 1) {
                        goalApproval = "Rework";
                        break;
                    }
                }
                for (Object o5 : list) {
                    endSelfApproval = "";
                    AppraisalPerformanceKra appraisalPerformanceKra1 = (AppraisalPerformanceKra) o5;
                    if (appraisalPerformanceKra1.getEmpEndyearSelfassessmentGoal() != null && 0 != appraisalPerformanceMaster.getEndYearEmployeeStatus()) {
                        endSelfApproval = "Approved";
                        break;
                    }
                }
                for (Object o6 : list) {
                    managerEndSelfApproval = "";
                    AppraisalPerformanceKra appraisalPerformanceKra1 = (AppraisalPerformanceKra) o6;
//                    if (currentDate.equals(managerYearEndStartDate1) || currentDate.equals(managerYearEndEndDate1)
//                            || (currentDate.after(managerYearEndStartDate1) && currentDate.before(managerYearEndEndDate1))) {
//                        if (appraisalPerformanceMaster.getReworkStatus() == 1 && 0 != appraisalPerformanceMaster.getEndYearManagerStatus()) {
                    if (appraisalPerformanceMaster.getReworkStatus() == 1) {
                        managerEndSelfApproval = "Rework";
                        endSelfApproval = "Pendding";
                        break;
                    }
//                    }
                    if (appraisalPerformanceKra1.getManagerEndyearReviewEvaluation() != null && 0 != appraisalPerformanceMaster.getEndYearManagerStatus()) {
                        managerEndSelfApproval = "Approved";
                        break;
                    } else if (appraisalPerformanceMaster.getReworkStatus() == 1 && 0 != appraisalPerformanceMaster.getEndYearManagerStatus()) {
                        managerEndSelfApproval = "Rework";
                        break;
                    }
                }

                if (!list.isEmpty()) {
                    List appraisalFillingDataList = appraisalFillingDataService.readByCurrentYear("" + year1);
                    //List appraisalFillingDataList = appraisalFillingDataService.getappraisalDate();

                    if (!appraisalFillingDataList.isEmpty()) {
                        AppraisalFillingData appraisalFillingData = (AppraisalFillingData) appraisalFillingDataList.get(0);
//                        Date currentDate = new Date();
//

                        Date ManagerEndDate = dateFormat.parse(appraisalFillingData.getManagerEndDate());
                        Date ManagerStartDate = dateFormat.parse(appraisalFillingData.getManagerStartDate());
                        if ((currentDate.after(ManagerStartDate) && currentDate.before(ManagerEndDate)) || currentDate.equals(ManagerStartDate) || currentDate.equals(ManagerEndDate)) {
                            if (!goalApproval.equals("Approved") && !goalApproval.equals("Rework")) {
                                goalApproval = "Pendding";
                            }
                        } else if (currentDate.after(ManagerEndDate)) {
                            if (!goalApproval.equals("Approved") && !goalApproval.equals("Rework")) {
                                goalApproval = "Expired";
                            }
                        } else if (!goalApproval.equals("Approved") && !goalApproval.equals("Rework")) {
                            goalApproval = "";
                        }

                        Date endEndDate = dateFormat.parse(appraisalFillingData.getYearEndEndDate());
                        Date endStartDate = dateFormat.parse(appraisalFillingData.getYearEndStartDate());
//                        if ((currentDate.after(endEndDate) && (currentDate.before(endStartDate))) || currentDate.equals(endStartDate) || currentDate.equals(endEndDate)) {
                        if ((currentDate.after(endStartDate) && (currentDate.before(endEndDate))) || currentDate.equals(endStartDate) || currentDate.equals(endEndDate)) {
                            if (!endSelfApproval.equals("Approved")) {
                                endSelfApproval = "Pendding";
                            }
                        } else if (currentDate.after(endEndDate)) {
                            if (!endSelfApproval.equals("Approved")) {
                                endSelfApproval = "Expired";
                            }
                        } else if (!endSelfApproval.equals("Approved")) {
                            endSelfApproval = "";
                        }

                        /////////////////////////Manager End year////////////////////////////////////
                        Date managerYearEndEndDate = dateFormat.parse(appraisalFillingData.getManagerYearEndEndDate());
                        Date managerYearEndStartDate = dateFormat.parse(appraisalFillingData.getManagerYearEndStartDate());
                        if ((currentDate.after(managerYearEndStartDate) && currentDate.before(managerYearEndEndDate)) || currentDate.equals(managerYearEndStartDate) || currentDate.equals(managerYearEndEndDate)) {
                            if (!managerEndSelfApproval.equals("Approved") && !managerEndSelfApproval.equals("Rework")) {
                                managerEndSelfApproval = "Pendding";
                            }
                        } else if (currentDate.after(managerYearEndEndDate)) {
                            if (!managerEndSelfApproval.equals("Approved") && !managerEndSelfApproval.equals("Rework")) {
                                managerEndSelfApproval = "Expired";
                            }
                        } else if (!managerEndSelfApproval.equals("Approved") && !managerEndSelfApproval.equals("Rework")) {
                            managerEndSelfApproval = "";
                        }

                    }

                } else {
                    List appraisalFillingDataList = appraisalFillingDataService.readByCurrentYear("" + year1);
                    //List appraisalFillingDataList = appraisalFillingDataService.getappraisalDate();
                    if (!appraisalFillingDataList.isEmpty()) {
                        AppraisalFillingData appraisalFillingData = (AppraisalFillingData) appraisalFillingDataList.get(0);

                        //First Manager
//                        Date endDate = dateFormat.parse(appraisalFillingData.getEndDate());
                        Date endDate = dateFormat.parse(appraisalFillingData.getManagerEndDate());
                        if (currentDate.after(endDate) || currentDate.equals(endDate)) {
                            if (!goalApproval.equals("Approved")) {
                                goalApproval = "Expired";
                            }
                            goalSetting = "Expired";
                        } else {
                            if (!goalApproval.equals("Approved")) {
                                goalApproval = "Pendding";
                            }
                            goalSetting = "Pendding";
                        }

                        Date endEndDate = dateFormat.parse(appraisalFillingData.getManagerYearEndEndDate());
                        if (currentDate.after(endEndDate) || currentDate.equals(endEndDate)) {
                            if (!endSelfApproval.equals("Approved")) {
                                endSelfApproval = "Expired";
                            }
                            if (!managerEndSelfApproval.equals("Approved")) {
                                managerEndSelfApproval = "Expired";
                            }
                        } else {
                            if (!endSelfApproval.equals("Approved")) {
                                endSelfApproval = "Pendding";
                            }
                            if (!managerEndSelfApproval.equals("Approved")) {
                                managerEndSelfApproval = "Pendding";
                            }
                        }

                    }
                }

                /////////
                List starusList = new ArrayList();
                starusList.add(o11[0]);
                starusList.add(o11[1]);
                starusList.add(o11[2]);
                starusList.add(o11[3]);
                starusList.add(o11[4]);
                starusList.add(o11[5]);
                starusList.add(o11[6]);
                starusList.add(o11[7]);
                starusList.add(o11[8]);
                starusList.add(o11[9]);
                starusList.add(o11[10]);
                starusList.add(goalSetting);
                starusList.add(goalApproval);
                starusList.add(endSelfApproval);
                starusList.add(managerEndSelfApproval);
                appraisalPerformanceList1.add(starusList);
                i++;
//                appraisalPerformanceList1.add(starusList);
//                finalAppraisalPerformanceList1.add(appraisalPerformanceList1);
            }

        }

        mv.getModelMap().put("list", appraisalPerformanceList1);
//        mv.getModelMap().put("list", appraisalPerformanceList);
//        mv.getModelMap().put("currentYearRequest", appraisalPerformanceList.size());
        mv.getModelMap().put("currentYearRequest", appraisalPerformanceListTime.size());
        mv.getModelMap().put("previousYear", previousYear);
        mv.getModelMap().put("appraisalPerformanceMaster", appraisalPerformanceMaster);
        mv.setViewName("Appraisal/PastEmployeePerformanceAppraisalResult");
        return mv;
    }

    public ModelAndView searchAppraisalPerformanceReoprtStageWise(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AppraisalPerformanceMaster appraisalPerformanceMaster = new AppraisalPerformanceMaster();
//        List<?> employeeMasterList = employeeMasterService.read();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        selectEmployee(request, response);
        department(request, response);
        competencyList(request);
        pmpyearList(request);
        yearList(request);
//        UserMaster user = (UserMaster) request.getSession().getAttribute("user");
//        UserRightMaster user1 = (UserRightMaster) request.getSession().getAttribute("userRight");
//        int cyear = Calendar.getInstance().get(Calendar.YEAR);
//        List<?> appraisalPerformanceList = appraisalPerformanceService.readOwnAppraisalPerformance(employeeMaster, cyear);

//        mv.getModelMap().put("list", appraisalPerformanceList);
        mv.getModelMap().put("appraisalPerformanceMaster", appraisalPerformanceMaster);
        mv.setViewName("Appraisal/AppraisalPerformanceStageWiseReoprt");
        return mv;
    }

    public ModelAndView searchAppraisalPerformanceReoprtSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AppraisalPerformanceMaster appraisalPerformanceMaster = new AppraisalPerformanceMaster();
        AppraisalPerformanceKra appraisalPerformanceKra = new AppraisalPerformanceKra();

        String employeeMasterId = request.getParameter("employeeMasterId");
        String departmentId = request.getParameter("departmentId");
        String competencyEvaluation_Id = request.getParameter("competencyEvaluation_Id");
        String kragoal = request.getParameter("kragoal");
        String weightage = request.getParameter("weightage");
        String empMidYearSelfAssementGoal = request.getParameter("empMidYearSelfAssementGoal");
        String managerMidYearReviewEvaluation = request.getParameter("managerMidYearReviewEvaluation");
        String empEndYearSelfAssementGoal = request.getParameter("empEndYearSelfAssementGoal");
        String managerEndYearReviewEvaluation = request.getParameter("managerEndYearReviewEvaluation");
//        boolean flag1 = true;
//        boolean flag2 = true;
//        boolean flag3 = true;
//        boolean flag4 = true;
//        boolean flag5 = true;
//        boolean flag6 = true;
//        if (kragoal == null) {
//            flag1 = false;
//        } else {
//            flag1 = true;
//        }
//        if (weightage == null) {
//            flag2 = false;
//        } else {
//            flag2 = true;
//        }
//        if (empMidYearSelfAssementGoal == null) {
//            flag3 = false;
//        } else {
//            flag3 = true;
//        }
//        if (managerMidYearReviewEvaluation == null) {
//            flag4 = false;
//        } else {
//            flag4 = true;
//        }
//        if (empEndYearSelfAssementGoal == null) {
//            flag5 = false;
//        } else {
//            flag5 = true;
//        }
//        if (managerEndYearReviewEvaluation == null) {
//            flag6 = false;
//        } else {
//            flag6 = true;
//        }

        timeLineDate(request, response);
        String searchvalue = request.getParameter("valDetail");
//        String chque[] = request.getParameterValues("checkedRows");
        EmployeeMaster employeeMaster = new EmployeeMaster();

        if (null != employeeMasterId && !"".equals(employeeMasterId)) {
            employeeMaster.setId(Integer.parseInt(employeeMasterId));
        }
        int cyear1 = Calendar.getInstance().get(Calendar.YEAR);
        appraisalPerformanceMaster.setEmployeeMaster(employeeMaster);
        appraisalPerformanceMaster.setBehaviorsMidyearOtherremark(departmentId);
        appraisalPerformanceMaster.setBehaviorsEndyearOtherremark(competencyEvaluation_Id);

        List timeLineList = appraisalFillingDataService.read();
        AppraisalFillingData appraisalFillingData = new AppraisalFillingData();
        if (!timeLineList.isEmpty()) {
            appraisalFillingData = (AppraisalFillingData) timeLineList.get(timeLineList.size() - 1);
        }

        String pyear = request.getParameter("pmpyear");
        if (null != searchvalue) {
            if (searchvalue.equals("rating")) {
                List<?> empDetail = appraisalPerformanceService.readPMPSearchByEmployee(appraisalPerformanceMaster, Integer.parseInt(pyear));
                mv.getModelMap().put("list", empDetail);
                response.setContentType("application/vnd.ms-excel");
                response.setHeader("Content-Disposition", "attachment; filename=EmployeePMPRating.xls");
                mv.getModelMap().put("appraisalPerformanceMaster", appraisalPerformanceMaster);
                mv.setViewName("Appraisal/PMPReport");
            } else if (searchvalue.equals("stageWise")) {
                List<?> stageWise = appraisalPerformanceService.readstageWiseSearchByEmployee(appraisalPerformanceMaster, appraisalFillingData, Integer.parseInt(pyear));
                mv.getModelMap().put("list", stageWise);
//                request.setAttribute("flag1", flag1);
//                request.setAttribute("flag2", flag2);
//                request.setAttribute("flag3", flag3);
//                request.setAttribute("flag4", flag4);
//                request.setAttribute("flag5", flag5);
//                request.setAttribute("flag6", flag6);
                response.setContentType("application/vnd.ms-excel");
                response.setHeader("Content-Disposition", "attachment; filename=EmployeeStageWiseReport.xls");
                mv.getModelMap().put("appraisalPerformanceMaster", appraisalPerformanceMaster);
                mv.setViewName("Appraisal/StageWiseReport");
            } else if (searchvalue.equals("competency")) {
                List<?> competencyDetail = appraisalPerformanceService.readcompetencySearchByEmployee(appraisalPerformanceMaster);
                mv.getModelMap().put("list", competencyDetail);
                response.setContentType("application/vnd.ms-excel");
                response.setHeader("Content-Disposition", "attachment; filename=EmployeeIDPReport.xls");
                mv.getModelMap().put("appraisalPerformanceMaster", appraisalPerformanceMaster);
                mv.setViewName("Appraisal/CompetencyReport");
            } else if (searchvalue.equals("idp")) {
                int rownum = 0;
                int rownum1 = 2;
                HSSFWorkbook firstFWorkbook = new HSSFWorkbook();
                HSSFSheet firstSheet = firstFWorkbook.createSheet("FIRST SHEET");
                Row headerRow = firstSheet.createRow(rownum);
                headerRow.setHeightInPoints(40);
                HSSFFont boldFont = firstFWorkbook.createFont();
                boldFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
                HSSFCellStyle styleBold = firstFWorkbook.createCellStyle();
                styleBold.setFont(boldFont);
                List<List<String>> recordToAdd = new ArrayList();
                List<List<String>> recordToAdd1 = new ArrayList();
                List<String> headerRow1 = new ArrayList();
                List<String> headerRow2 = new ArrayList();
                headerRow1.add("Employee ID");
                headerRow1.add("Employee Name");
                headerRow1.add("Department");
                headerRow1.add("Designation");
                headerRow1.add("Year");
                headerRow1.add("level");
//                headerRow1.add("IDP1");
                headerRow1.add("IDP1 Name & Details");
                headerRow1.add("IDP Type");
                headerRow1.add("How to achieve this IDP");
                headerRow1.add("Other");
                headerRow1.add("Employee Mid-Year Remark");
                headerRow1.add("Employee End-Year Remark");
                headerRow1.add("Manager Mid-Year Remark");
                headerRow1.add("Manager End-Year Remark");
//                headerRow1.add("IDP2");
                headerRow1.add("IDP2 Name & Details");
                headerRow1.add("IDP Type");
                headerRow1.add("How to achieve this IDP");
                headerRow1.add("Other");
                headerRow1.add("Employee Mid-Year Remark");
                headerRow1.add("Employee End-Year Remark");
                headerRow1.add("Manager Mid-Year Remark");
                headerRow1.add("Manager End-Year Remark");
//                headerRow1.add("IDP3");
                headerRow1.add("IDP3 Name & Details");
                headerRow1.add("IDP Type");
                headerRow1.add("How to achieve this IDP");
                headerRow1.add("Other");
                headerRow1.add("Employee Mid-Year Remark");
                headerRow1.add("Employee End-Year Remark");
                headerRow1.add("Manager Mid-Year Remark");
                headerRow1.add("Manager End-Year Remark");
//                headerRow1.add("IDP4");
                headerRow1.add("IDP4 Name & Details");
                headerRow1.add("IDP Type");
                headerRow1.add("How to achieve this IDP");
                headerRow1.add("Other");
                headerRow1.add("Employee Mid-Year Remark");
                headerRow1.add("Employee End-Year Remark");
                headerRow1.add("Manager Mid-Year Remark");
                headerRow1.add("Manager End-Year Remark");
//                headerRow1.add("IDP5");
                headerRow1.add("IDP5 Name & Details");
                headerRow1.add("IDP Type");
                headerRow1.add("How to achieve this IDP");
                headerRow1.add("Other");
                headerRow1.add("Employee Mid-Year Remark");
                headerRow1.add("Employee End-Year Remark");
                headerRow1.add("Manager Mid-Year Remark");
                headerRow1.add("Manager End-Year Remark");

                recordToAdd.add(headerRow1);
                for (int j = 0; j < recordToAdd.size(); j++) {
                    List<String> l2 = recordToAdd.get(j);
                    Row row = firstSheet.createRow((short) rownum);
                    Row row1 = firstSheet.createRow(rownum);
                    for (int k = 0; k < l2.size(); k++) {
                        Cell cell = row.createCell((short) k);

                        if (j == 0) {
                            cell.setCellStyle(styleBold);
                        }

                    }
                    rownum++;
                }

                for (int j = 0; j < recordToAdd.size(); j++) {
                    List<String> l2 = recordToAdd.get(j);
                    Row row = firstSheet.createRow(rownum);
                    for (int k = 0; k < l2.size(); k++) {
                        Cell cel2 = row.createCell(k);
                        cel2.setCellValue(l2.get(k));

                        if (j == 0) {
                            cel2.setCellStyle(styleBold);

                        }
                        rownum++;
                    }

                }

                List<?> empIdpDetail = appraisalPerformanceService.readIDPSearchByEmployee(appraisalPerformanceMaster);
                for (int j = 0; j < empIdpDetail.size(); j++) {
                    Object[] l2 = (Object[]) empIdpDetail.get(j);
                    Row row = firstSheet.createRow(rownum1);
                    int l = 0;
                    for (int k = 2; k < l2.length; k++) {
                        Cell cell = row.createCell(l);
                        cell.setCellValue("" + l2[k]);
                        l++;
                    }
                    int idpID = (Integer) l2[0];
                    appraisalPerformanceMaster.setId(idpID);

                    List idpDetail = appraisalPerformanceService.readIDPSearchByEmployeeWise(appraisalPerformanceMaster);
//                    l = l + 1;
                    for (int z = 0; z < idpDetail.size(); z++) {
                        Object[] idpObj = (Object[]) idpDetail.get(z);
                        for (int k = 1; k < idpObj.length; k++) {
                            Cell cell = row.createCell(l);
                            if (null != idpObj[k]) {

                                cell.setCellValue("" + idpObj[k]);
                            } else {
                                cell.setCellValue("");

                            }

                            l++;
                        }

                    }

                    rownum1++;
                }
//                int colToRemove = 5;
//                Iterator rowIter = firstSheet.iterator();
//                while (rowIter.hasNext()) {
//                    HSSFRow row = (HSSFRow) rowIter.next();
//                    HSSFCell cell = row.getCell(colToRemove);
//                    row.removeCell(cell);
//                }

//                mv.getModelMap().put("list", empIdpDetail);
//                List<?> idpDetail = new ArrayList<Object>();
//                List<Object> idpDetail1 = new ArrayList<Object>();
//                if (!empIdpDetail.isEmpty()) {
////                    for (int i = 0; i < empIdpDetail.size(); i++) {
////                        Object[] ss = (Object[]) empIdpDetail.get(i);
////                        int idpID = (Integer) ss[0];
////                        appraisalPerformanceMaster.setId(idpID);
////
////                        idpDetail = appraisalPerformanceService.readIDPSearchByEmployeeWise(appraisalPerformanceMaster);
//////                        idpDetail1.add(idpDetail);
//////                        for (int j = 0; j < idpDetail1.size(); j++) {
//////                            Object[] l23 = (Object[]) idpDetail1.get(j);
////                        if (!idpDetail.isEmpty()) {
////
////                            Object[] l23 = (Object[]) idpDetail.get(0);
////                            Row row = firstSheet.createRow(rownum1);
////
////                            //int l = 2;
////                            for (int k = 0; k < l23.length; k++) {
////                                Cell cell = row.createCell(k);
////                                cell.setCellValue("" + l23[k]);
////                                //l++;
////                            }
////                            rownum1++;
////                        }
//////                        }
////                    }
//                }
//                mv.getModelMap().put("list1", idpDetail);
//                response.setContentType("application/vnd.ms-excel");
//                response.setHeader("Content-Disposition", "attachment; filename=EmployeeIDPReport.xls");
//                mv.getModelMap().put("appraisalPerformanceMaster", appraisalPerformanceMaster);
//                mv.setViewName("Appraisal/IDPReport");
                String appPath = request.getServletContext().getRealPath("");
                try {
                    String filePath = appPath + File.separator + "StorageYard" + File.separator
                            + "Other" + File.separator + "UserDoc" + File.separator
                            + "EmployeeDailyPunch" + File.separator + "EmployeeDailyPunch.xls";
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
                        + "EmployeeDailyPunch" + File.separator + "EmployeeDailyPunch.xls";

                appPath = request.getServletContext().getRealPath("");

                String fullPath = appPath + filePath;

                request.setAttribute("filePath", fullPath);

                DownloadFile downloadFile = new DownloadFile();
                downloadFile.doDownload(request, response);
                return mv;

            }
        }

//        response.setContentType("application/vnd.ms-excel");
//        response.setHeader("Content-Disposition", "attachment; filename=EmployeePMPRating.xls");
//        mv.getModelMap().put("appraisalPerformanceMaster", appraisalPerformanceMaster);
//        mv.setViewName("Appraisal/AppraisalPerformanceStageWiseReoprt");
        return mv;
    }

    public ModelAndView historyAjaxCallOtherActivity(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
//        String kraId = request.getParameter("kraId");
        String kraId = request.getParameter("kraIdOther");
        AppraisalPerformanceActivities appraisalPerformanceActivities = new AppraisalPerformanceActivities();
        appraisalPerformanceActivities.setId(Integer.parseInt(kraId));
        UpdateAppraisalPerformanceActivities updateAppraisalPerformanceActivities = new UpdateAppraisalPerformanceActivities();
        updateAppraisalPerformanceActivities.setAppraisalPerformanceActivities(appraisalPerformanceActivities);
        List<?> updateKraList = updateAppraisalPerformanceActivitiesService.readByUpdateKragoalActivity(updateAppraisalPerformanceActivities);
        request.setAttribute("updateKraList", updateKraList);

//        request.setAttribute("list", list);
//        mv.getModelMap().put("competencyEvaluationTextmaster", competencyEvaluationTextmaster);
//        mv.setViewName("Appraisal/HistoryUpdateKraPerformanceAppraisalForm");
        mv.setViewName("Appraisal/HistoryUpdateKraPerformanceAppraisalOtherActivity");
        return mv;
    }

    public ModelAndView reworkByManager(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String pmpIdForRework = request.getParameter("pmpIdForRework");
        String reworkComment = request.getParameter("reworkComment");
        AppraisalPerformanceMaster appraisalPerformanceMaster = new AppraisalPerformanceMaster();
//        AppraisalPerformanceCompetencyEvaluation appraisalPerformanceCompetencyEvaluation = new AppraisalPerformanceCompetencyEvaluation();
        appraisalPerformanceMaster = appraisalPerformanceService.readById(Integer.parseInt(pmpIdForRework));

        appraisalPerformanceMaster.setReworkComment(reworkComment);
        appraisalPerformanceMaster.setManagerkraStatus(1);
        appraisalPerformanceMaster.setEmployeeStatus(0);
        appraisalPerformanceMaster.setReworkStatus(1);

//        String flagId = request.getParameter("flagId1");
//        String midhalf = request.getParameter("flagMidId1");
//        String endhalf = request.getParameter("flagEndId1");
//        if (null != midhalf && midhalf.equals("true")) {
////            appraisalPerformanceMaster.setMidYearEmployeeStatus(0);
////            appraisalPerformanceMaster.setMidYearManagerStatus(0);
//        }
//        if (null != endhalf && endhalf.equals("true")) {
////            appraisalPerformanceMaster.setEndYearEmployeeStatus(0);
////            appraisalPerformanceMaster.setEndYearManagerStatus(0);
//        }
        appraisalPerformanceService.update(appraisalPerformanceMaster);
//        appraisalPerformanceCompetencyEvaluation.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
//        appraisalPerformanceCompetencyEvaluationService.deleteByManager(appraisalPerformanceCompetencyEvaluation);
        try {
            EmailTemplate emailTemplate = new EmailTemplate();
            EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
            DesignationMaster designationMaster = new DesignationMaster();
            designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
            List l1 = appraisalPerformanceService.readEmpIdFromTabId(Integer.parseInt(pmpIdForRework));
            EmployeeMaster employeeRequestee = (EmployeeMaster) l1.get(0);
            // id 116 is for status Appraisal Approved (Start Year)
            emailTemplate = emailTemplateService.readById(134);
            String To = employeeRequestee.getOfficeEmailId();
            String from = employeeMasterModel.getOfficeEmailId();
            String Subject = emailTemplate.getSubject();
            Subject = Subject.replaceAll("\\{user\\}", employeeRequestee.getEmployeeName());
            String msg = emailTemplate.getBodytext();
            msg = msg.replaceAll("\\{to_user\\}", employeeRequestee.getEmployeeName());
            msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
            msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
            sendMail.sendMail(from, To, Subject, msg);
        } catch (Exception e) {

        }

//        mv = searchSubmit(request, response);
//        mv.setViewName("redirect:appraisalPerformance.htm?act=searchSubmit");
        mv.setViewName("redirect:appraisalPerformance.htm?act=searchClick");

        return mv;
    }

    public void readPendingPmpStatus(HttpServletRequest request, HttpServletResponse response) throws Exception {

        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        int year = Calendar.getInstance().get(Calendar.YEAR);
        List<?> l1 = appraisalFillingDataService.getCurrentAndPreviousYear();
        String previousYear = "";
//        int currentYear = 0;
        if (!l1.isEmpty()) {
            Object[] obj = (Object[]) l1.get(0);
//            previousYear = (Integer) obj[0];
            previousYear = "" + obj[0];
//            currentYear = (Integer) obj[1];
        }

//        List pendingAtEmployeeList = appraisalPerformanceService.readPendingEmployeePmp(employeeMaster.getId(), year);
        List pendingAtEmployeeList = appraisalPerformanceService.readPendingEmployeePmp(employeeMaster.getId(), Integer.parseInt(previousYear));

//        List pendingAtEmployeeListForManager = appraisalPerformanceService.readPendingEmployeePmpByManager("" + employeeMaster.getId(), year);
        List pendingAtEmployeeListForManager = appraisalPerformanceService.readPendingEmployeePmpByManager("" + employeeMaster.getId(), Integer.parseInt(previousYear));
        request.setAttribute("pendingAtEmployeeList", pendingAtEmployeeList.size());
        List<String> empIdList = new ArrayList();
        for (Object obj : pendingAtEmployeeListForManager) {
            Object[] oo = (Object[]) obj;
            EmployeeMaster employeeMaster1 = (EmployeeMaster) oo[1];
            empIdList.add(employeeMaster1.getEmployeeId());
        }
        request.setAttribute("pendingAtEmployeeListForManager", pendingAtEmployeeListForManager.size());
        request.setAttribute("empIdList", empIdList);
    }

    public ModelAndView kraGoalAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
//        String kraId = request.getParameter("kraId");
        String pmpId = request.getParameter("appraisalId");
        AppraisalPerformanceMaster appraisalPerformanceMaster = new AppraisalPerformanceMaster();
        appraisalPerformanceMaster.setId(Integer.parseInt(pmpId));
        AppraisalKraActivity appraisalkraActivity = new AppraisalKraActivity();
        appraisalkraActivity.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
        List<?> deletedkraGoalList = appraisalkraActivityService.readByKraGoalName(appraisalkraActivity);
        request.setAttribute("deletedkraGoalList", deletedkraGoalList);
        mv.setViewName("Appraisal/AppraisalDeletedKraGoalAjax");
        return mv;
    }

    public ModelAndView activitiesAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String pmpId = request.getParameter("appraisalId");
        AppraisalPerformanceMaster appraisalPerformanceMaster = new AppraisalPerformanceMaster();
        appraisalPerformanceMaster.setId(Integer.parseInt(pmpId));
        AppraisalKraActivity appraisalkraActivity = new AppraisalKraActivity();
        appraisalkraActivity.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
        List<?> deletedActivitiesList = appraisalkraActivityService.readByActivitiesName(appraisalkraActivity);
        request.setAttribute("deletedActivitiesList", deletedActivitiesList);
        mv.setViewName("Appraisal/AppraisalDeletedActivitiesAjax");
        return mv;
    }

    public ModelAndView appraisalPrintToPdfByEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AppraisalPerformanceMaster appraisalPerformanceMaster = new AppraisalPerformanceMaster();
        UpdateAppraisalPerformanceKra updateAppraisalPerformanceKra = new UpdateAppraisalPerformanceKra();
        AppraisalPerformanceKra appraisalPerformanceKra = new AppraisalPerformanceKra();
        EmployeeMaster employee = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        String employeeName = "" + employee.getEmployeeName();
        try {

            String empId = request.getParameter("id");
            String userid = request.getParameter("userid");
            String appraisalId1 = request.getParameter("appraisalId");
            //////Print/////By dhaval
            request.setAttribute("empId", empId);
            request.setAttribute("userid", userid);
            request.setAttribute("appraisalId1", appraisalId1);
            ///////////
            empDateStartToEnd(request, response);
            selectedEmployeeDate(request, response, userid);
            kraCategoryList(request);
            String employeeId = "" + empId;//set the value in employee id
            appraisalPerformanceMaster = appraisalPerformanceService.readById(Integer.parseInt(appraisalId1));
            if (null != appraisalPerformanceMaster.getWeightageScore()) {
                String weightageScore = appraisalPerformanceMaster.getWeightageScore();
                request.setAttribute("weightageScore", weightageScore);
            }
            if (null != appraisalPerformanceMaster.getTotalScore()) {
                String totalScore = appraisalPerformanceMaster.getTotalScore();
                request.setAttribute("totalScore", totalScore);
            }
            if (null != appraisalPerformanceMaster.getEmployeeTotalFinalScore()) {
                String EmployeeTotalFinalScore = appraisalPerformanceMaster.getEmployeeTotalFinalScore();
                request.setAttribute("empScore", EmployeeTotalFinalScore);
            }
            if (null != appraisalPerformanceMaster.getTotalScoreForemployee()) {
                String totalScoreForemployee = appraisalPerformanceMaster.getTotalScoreForemployee();
                request.setAttribute("totalScoreForemployee", totalScoreForemployee);
            }
            // ==========================Mid Year=======================================================//
            if (null != appraisalPerformanceMaster.getEmpMidyearSelfassOtheractivty()) {
                String empMidyearSelfassOtheractivty = appraisalPerformanceMaster.getEmpMidyearSelfassOtheractivty();
                request.setAttribute("empMidyearSelfassOtheractivty", empMidyearSelfassOtheractivty);
            }
            if (null != appraisalPerformanceMaster.getManagerMidyearReviewevalOtheractivity()) {
                String managerMidyearReviewevalOtheractivity = appraisalPerformanceMaster.getManagerMidyearReviewevalOtheractivity();
                request.setAttribute("managerMidyearReviewevalOtheractivity", managerMidyearReviewevalOtheractivity);
            }
            // ==========================Mid Year=======================================================//
            //=======End Year=============//
            if (null != appraisalPerformanceMaster.getEmpEndyearSelfassOtheractivty()) {
                String empEndyearSelfassOtheractivty = appraisalPerformanceMaster.getEmpEndyearSelfassOtheractivty();
                request.setAttribute("empEndyearSelfassOtheractivty", empEndyearSelfassOtheractivty);
            }
            if (null != appraisalPerformanceMaster.getManagerEndyearReviewevalOtheractivity()) {
                String managerEndyearReviewevalOtheractivity = appraisalPerformanceMaster.getManagerEndyearReviewevalOtheractivity();
                request.setAttribute("managerEndyearReviewevalOtheractivity", managerEndyearReviewevalOtheractivity);
            }
            /////////////////behaviors/////////////////
            if (null != appraisalPerformanceMaster.getBehaviorsMidyearTotalscore()) {
                String behaviorsMidyearTotalscore = appraisalPerformanceMaster.getBehaviorsMidyearTotalscore();
                request.setAttribute("behaviorsMidyearTotalscore", behaviorsMidyearTotalscore);
            }
            if (null != appraisalPerformanceMaster.getBehaviorsMidyearOtherremark()) {
                String behaviorsMidyearOtherremark = appraisalPerformanceMaster.getBehaviorsMidyearOtherremark();
                request.setAttribute("behaviorsMidyearOtherremark", behaviorsMidyearOtherremark);
            }
            if (null != appraisalPerformanceMaster.getBehaviorsEndyearOtherremark()) {
                String behaviorsEndyearOtherremark = appraisalPerformanceMaster.getBehaviorsEndyearOtherremark();
                request.setAttribute("behaviorsEndyearOtherremark", behaviorsEndyearOtherremark);
            }
            if (null != appraisalPerformanceMaster.getBehaviorsEndyearOtherremark()) {
                String behaviorsEndyearTotalscore = appraisalPerformanceMaster.getBehaviorsEndyearTotalscore();
                request.setAttribute("behaviorsEndyearTotalscore", behaviorsEndyearTotalscore);
            }
            if (null != appraisalPerformanceMaster.getBehaviorsEndyearTotalscore()) {
                String behaviorsEndyearTotalscore = appraisalPerformanceMaster.getBehaviorsEndyearTotalscore();
                request.setAttribute("behaviorsEndyearTotalscore", behaviorsEndyearTotalscore);
            }
            if (null != appraisalPerformanceMaster.getBehaviorsEndyearTotalscoreForemp()) {
                String behaviorsEndyearTotalscoreForemp = appraisalPerformanceMaster.getBehaviorsEndyearTotalscoreForemp();
                request.setAttribute("behaviorsEndyearTotalscoreForemp", behaviorsEndyearTotalscoreForemp);
            }
//        if (null != appraisalPerformanceMaster.getManagerStatus()) {
            int managerStatus = appraisalPerformanceMaster.getManagerStatus();
            request.setAttribute("managerStatus", managerStatus);
            int statusFlag = appraisalPerformanceMaster.getStatus();
            request.setAttribute("statusFlag", statusFlag);
            int employeeStatus = appraisalPerformanceMaster.getEmployeeStatus();
            request.setAttribute("employeeStatus", employeeStatus);

            if (null != appraisalPerformanceMaster.getBehaviorsFinalscore() && !"".equals(appraisalPerformanceMaster.getBehaviorsFinalscore())) {
                String behaviorsFinalscore = appraisalPerformanceMaster.getBehaviorsFinalscore();
                request.setAttribute("behaviorsFinalscore", behaviorsFinalscore);
            }
            if (null != appraisalPerformanceMaster.getBehaviorsFinalscoreForemployee() && !"".equals(appraisalPerformanceMaster.getBehaviorsFinalscoreForemployee())) {
                String behaviorsFinalscoreForemployee = appraisalPerformanceMaster.getBehaviorsFinalscoreForemployee();
                request.setAttribute("behaviorsFinalscoreForemployee", behaviorsFinalscoreForemployee);
            }

            if (null != appraisalPerformanceMaster.getEmpActivityScore()) {
                String empActivityScore = appraisalPerformanceMaster.getEmpActivityScore();
                request.setAttribute("empActivityScore", empActivityScore);
            }

            int year = Integer.parseInt(request.getParameter("year"));
            request.setAttribute("year", year);
            List<?> list = appraisalPerformanceService.readByAppraisalPerformanceId(employeeId, year);
            if (!list.isEmpty()) {

                appraisalPerformanceMaster = (AppraisalPerformanceMaster) list.get(0);
                int appraisalId = appraisalPerformanceMaster.getId();
                appraisalPerformanceKra.setId(appraisalId);
                String kragoal = "";
                String metric = "";
                int kraCategoryId;
                boolean updateStatus = false;
                int kragoalId;

                List<?> kraList = appraisalPerformanceKraService.readByAppraisalKraGoal(appraisalPerformanceKra);
                if (!kraList.isEmpty()) {
                    appraisalPerformanceKra = (AppraisalPerformanceKra) kraList.get(0);
                    kragoal = appraisalPerformanceKra.getKraGoal();
                    kragoalId = appraisalPerformanceKra.getId();
                    metric = appraisalPerformanceKra.getMetric();

                    if (null != kragoal && !"".equals(kragoal)) {

                        UpdateAppraisalPerformanceKra updateAppraisalPerformanceKra1 = new UpdateAppraisalPerformanceKra();
                        updateAppraisalPerformanceKra.setId(Integer.parseInt("" + kragoalId));
                        List<?> updateAppraisalPerformanceKra1List = updateAppraisalPerformanceKraService.readByUserUpdateKra(updateAppraisalPerformanceKra);
                        if (!updateAppraisalPerformanceKra1List.isEmpty()) {

                            updateAppraisalPerformanceKra1 = (UpdateAppraisalPerformanceKra) updateAppraisalPerformanceKra1List.get(0);
                            if (!kragoal.equals(updateAppraisalPerformanceKra1.getUpdateKra()) || !metric.equals(updateAppraisalPerformanceKra1.getUpdateMetric())) {
                                updateStatus = true;
                            }
                        }
                    }
                }
                request.setAttribute("updateStatus", updateStatus);
                request.setAttribute("kragoal", kraList);
                request.setAttribute("weightage", kraList);
                request.setAttribute("appraisalId", appraisalId);
                request.setAttribute("empMidyearSelfassessmentGoal", kraList);
                request.setAttribute("managerMidyearReviewEvaluation", kraList);
                request.setAttribute("midyearStatus", kraList);
                request.setAttribute("endyearStatus", kraList);
                request.setAttribute("empEndyearSelfassessmentGoal", kraList);
                request.setAttribute("editDate", kraList);
                request.setAttribute("startDate", kraList);

            }

            ////////////////////////////////////KRA OTHER Activity///////////////////////////////////////////////////////////
            String kragoal_activity = "";
            String metric_activity = "";
            boolean kraOtherupdateStatus = false;
            int kragoalactivityId;
            if (null != appraisalPerformanceMaster.getId()) {

                AppraisalPerformanceActivities appraisalPerformanceActivities = new AppraisalPerformanceActivities();
                appraisalPerformanceActivities.setAppraisalPerformanceMaster(appraisalPerformanceMaster);

                List<?> kraOtherList = appraisalPerformanceActivitiesService.readByAppraisalKraGoalActivities(appraisalPerformanceActivities);
                if (!kraOtherList.isEmpty()) {
                    appraisalPerformanceActivities = (AppraisalPerformanceActivities) kraOtherList.get(0);
                    kragoal_activity = appraisalPerformanceActivities.getKraGoalActivities();
                    kragoalactivityId = appraisalPerformanceActivities.getId();
                    metric_activity = appraisalPerformanceActivities.getMetricActivities();

                    if (null != kragoal_activity && !"".equals(kragoal_activity)) {
                        UpdateAppraisalPerformanceActivities updateAppraisalPerformanceActivities = new UpdateAppraisalPerformanceActivities();
                        updateAppraisalPerformanceActivities.setId(Integer.parseInt("" + kragoalactivityId));
                        List<?> updateKraOtherList = updateAppraisalPerformanceActivitiesService.readByUserUpdateKraOther(updateAppraisalPerformanceActivities);
                        if (!updateKraOtherList.isEmpty()) {

                            updateAppraisalPerformanceActivities = (UpdateAppraisalPerformanceActivities) updateKraOtherList.get(0);
                            if (!kragoal_activity.equals(updateAppraisalPerformanceActivities.getKraActivity()) || !metric_activity.equals(updateAppraisalPerformanceActivities.getMetricActivity())) {
                                kraOtherupdateStatus = true;
                            }
                        }
                    }
                }
                request.setAttribute("kraOtherupdateStatus", kraOtherupdateStatus);
                request.setAttribute("kragoalOtherActivity", kraOtherList);
            }
            ////////////////////////////////////KRA OTHER Activity//////////////////////////////////////////////////////////

            // =======================competency Evaluation==========================================================//
            competencyList(request);
            int competencyId = 0;
            AppraisalPerformanceCompetencyEvaluation appraisalPerformanceCompetencyEvaluation = new AppraisalPerformanceCompetencyEvaluation();
            appraisalPerformanceCompetencyEvaluation.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
            CompetencyEvaluationTextmaster competencyEvaluationTextmaster = new CompetencyEvaluationTextmaster();
            List<?> competencyEvaluationList = appraisalPerformanceCompetencyEvaluationService.readAppraisalPerformanceCompetencyEvaluationDetail(appraisalPerformanceCompetencyEvaluation);

            request.setAttribute("competencyEvaluationList", competencyEvaluationList);

            //Individual Development Plan//
            AppraisalPerformanceIndividualDevelopmentPlan appraisalPerformanceIndividualDevelopmentPlan = new AppraisalPerformanceIndividualDevelopmentPlan();
            appraisalPerformanceIndividualDevelopmentPlan.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
            String text1 = "";
            List<?> individualDevelopmentPlanList = appraisalPerformanceIndividualDevelopmentPlanService.readIndividualDevelopmentPlanDetail(appraisalPerformanceIndividualDevelopmentPlan);
            if (!individualDevelopmentPlanList.isEmpty()) {
                appraisalPerformanceIndividualDevelopmentPlan = (AppraisalPerformanceIndividualDevelopmentPlan) individualDevelopmentPlanList.get(0);
                text1 = appraisalPerformanceIndividualDevelopmentPlan.getText1();
            }
            request.setAttribute("text1", individualDevelopmentPlanList);
            request.setAttribute("text2", individualDevelopmentPlanList);
            request.setAttribute("text3", individualDevelopmentPlanList);
            request.setAttribute("remark", individualDevelopmentPlanList);
            request.setAttribute("midYearRemark", individualDevelopmentPlanList);
            request.setAttribute("endYearRemark", individualDevelopmentPlanList);
            request.setAttribute("individualDevelopmentPlanList", individualDevelopmentPlanList);

            //////////Behaviors///////////////
            AppraisalPerformanceBehaviors appraisalPerformanceBehaviors = new AppraisalPerformanceBehaviors();
            String behaviors = "";
            appraisalPerformanceBehaviors.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
            List<?> behaviorsList = appraisalPerformanceBehaviorsService.readBehaviorsDetail(appraisalPerformanceBehaviors);
            if (!behaviorsList.isEmpty()) {
                appraisalPerformanceBehaviors = (AppraisalPerformanceBehaviors) behaviorsList.get(0);
                behaviors = appraisalPerformanceBehaviors.getBehaviors();
            }
            request.setAttribute("behaviors", behaviorsList);
            request.setAttribute("behaviorsList", behaviorsList);
        } catch (Exception e) {

        }

        mv.getModelMap().put("appraisalPerformanceMaster", appraisalPerformanceMaster);
        mv.setViewName("Appraisal/AppraisalFormPrintToPdfByEmployee");
        return mv;
    }

    public ModelAndView trasferCompatencyEvaluationInEmployeeMaster(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<?> list = appraisalPerformanceService.readEmpIdByAppraisalPerformanceId();
        for (Object o : list) {
            Object[] s = (Object[]) o;
            EmployeeMaster employeeMaster = employeeMasterService.readById(Integer.parseInt("" + s[0]));
            employeeMaster.setCompetencyEvaluationId(Integer.parseInt("" + s[1]));
            employeeMasterService.update(employeeMaster);
        }
        mv.setViewName("redirect:logIn.html?act=dashboard");
        return mv;
    }

    private synchronized void mailSendPmp() throws Exception {

        EmployeeMaster employeeMaster = new EmployeeMaster();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        Date date = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String doj = sdf.format(date);
        List<?> empList = employeeMasterService.readByJoinDate(doj);
        if (!empList.isEmpty()) {
            for (Object o : empList) {
                employeeMaster = (EmployeeMaster) o;
                int eid = employeeMaster.getId();
                List<?> pmpList = appraisalPerformanceService.readByEmpID(eid);
                if (pmpList.isEmpty()) {
                    EmailTemplate emailTemplate = emailTemplateService.readById(141);
                    String emailId = employeeMaster.getEmailAddress();
                    for (String emailId1 : emailId.split(",")) {
                        if (!emailId1.equals("")) {
                            String To1 = emailId1;
                            String from1 = employeeMaster.getOfficeEmailId();
                            String subject1 = emailTemplate.getSubject();
                            subject1 = subject1.replaceAll("\\{user\\}", employeeMaster.getEmployeeName());
                            String msg1 = emailTemplate.getBodytext();
                            msg1 = msg1.replaceAll("\\{to_user\\}", employeeMaster.getEmployeeName());
                            sendMail.sendMail(from1, To1, subject1, msg1);
                        }
                    }
                }
            }
        }

        Calendar cal1 = Calendar.getInstance();
        cal1.add(Calendar.MONTH, -1);
        cal1.add(Calendar.DAY_OF_MONTH, -10);
        Date date1 = cal1.getTime();
        String doj1 = sdf.format(date1);
        List<?> empList1 = employeeMasterService.readByJoinDate(doj1);
        if (!empList1.isEmpty()) {
            for (Object o : empList1) {
                employeeMaster = (EmployeeMaster) o;
                int eid = employeeMaster.getId();
                List<?> pmpList = appraisalPerformanceService.readByEmpID(eid);
                if (pmpList.isEmpty()) {
                    EmailTemplate emailTemplate = emailTemplateService.readById(141);
                    String emailId = employeeMaster.getEmailAddress();
                    for (String emailId1 : emailId.split(",")) {
                        if (!emailId1.equals("")) {
                            String To1 = emailId1;
                            String from1 = employeeMaster.getOfficeEmailId();
                            String subject1 = emailTemplate.getSubject();
                            subject1 = subject1.replaceAll("\\{user\\}", employeeMaster.getEmployeeName());
                            String msg1 = emailTemplate.getBodytext();
                            msg1 = msg1.replaceAll("\\{to_user\\}", employeeMaster.getEmployeeName());
                            sendMail.sendMail(from1, To1, subject1, msg1);
                        }
                    }
                }
            }
        }
        Calendar cal2 = Calendar.getInstance();
        cal2.add(Calendar.MONTH, -1);
        cal2.add(Calendar.DAY_OF_MONTH, -20);
        Date date2 = cal2.getTime();
        String doj2 = sdf.format(date2);
        List<?> empList2 = employeeMasterService.readByJoinDate(doj2);
        if (!empList2.isEmpty()) {
            for (Object o : empList2) {
                employeeMaster = (EmployeeMaster) o;
                int eid = employeeMaster.getId();
                List<?> pmpList = appraisalPerformanceService.readByEmpID(eid);
                if (pmpList.isEmpty()) {
                    EmailTemplate emailTemplate = emailTemplateService.readById(141);
                    String emailId = employeeMaster.getEmailAddress();
                    for (String emailId1 : emailId.split(",")) {
                        if (!emailId1.equals("")) {
                            String To1 = emailId1;
                            String from1 = employeeMaster.getOfficeEmailId();
                            String subject1 = emailTemplate.getSubject();
                            subject1 = subject1.replaceAll("\\{user\\}", employeeMaster.getEmployeeName());
                            String msg1 = emailTemplate.getBodytext();
                            msg1 = msg1.replaceAll("\\{to_user\\}", employeeMaster.getEmployeeName());
                            sendMail.sendMail(from1, To1, subject1, msg1);
                        }
                    }
                }
            }
        }
    }

    public ModelAndView editClickCompetencyIdp(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AppraisalPerformanceMaster appraisalPerformanceMaster = new AppraisalPerformanceMaster();
        UpdateAppraisalPerformanceKra updateAppraisalPerformanceKra = new UpdateAppraisalPerformanceKra();
        AppraisalPerformanceKra appraisalPerformanceKra = new AppraisalPerformanceKra();
        EmployeeMaster employee = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        PmpFormStatusMaster pmpFormStatusMaster = new PmpFormStatusMaster();
        CompetencyEvaluationMaster competencyEvaluationMaster = new CompetencyEvaluationMaster();
        String employeeName = "" + employee.getEmployeeName();
        String empId = request.getParameter("id");
        String userid = request.getParameter("userid");
        String appraisalId1 = request.getParameter("appraisalId");
        //////Print/////By dhaval
        request.setAttribute("empId", empId);
        request.setAttribute("userid", userid);
        request.setAttribute("appraisalId1", appraisalId1);
        request.setAttribute("appraisalId1", appraisalId1);
        ///////////
        empDateStartToEnd(request, response);
        selectedEmployeeDate(request, response, userid);
        kraCategoryList(request);
        String employeeId = "" + empId;//set the value in employee id
        appraisalPerformanceMaster = appraisalPerformanceService.readById(Integer.parseInt(appraisalId1));

        try {
            if (null != employee.getCompetencyEvaluationId()) {

                competencyEvaluationMaster = competencyEvaluationMasterService.readById(employee.getCompetencyEvaluationId());
                if (null != competencyEvaluationMaster) {
                    String cpmname = competencyEvaluationMaster.getTitle();
                    request.setAttribute("cpmname", cpmname);
                }
            }
        } catch (Exception e) {

        }

        String pmpstatusId = "";
        List<?> pmplist = pmpFormStatusMasterService.readByPmpformstatusStatus(employeeId);
        if (!pmplist.isEmpty()) {
            pmpFormStatusMaster = (PmpFormStatusMaster) pmplist.get(0);
            pmpstatusId = "" + pmpFormStatusMaster.getId();
            boolean pmpstartyearstatus = pmpFormStatusMaster.getStartYearStatus();
            boolean pmpmidyearstatus = pmpFormStatusMaster.getMidYearStatus();
            boolean pmpendyearstatus = pmpFormStatusMaster.getEndYearStatus();
            boolean pmpasEmployee = pmpFormStatusMaster.getEmployeeSide();

            boolean compentencyStartYearStatus = pmpFormStatusMaster.getCompentencyStartYearStatus();
            boolean compentencyMidYearStatus = pmpFormStatusMaster.getCompentencyMidYearStatus();
            boolean compentencyEndYearStatus = pmpFormStatusMaster.getCompentencyEndYearStatus();

            request.setAttribute("pmpstartyearstatus", pmpstartyearstatus);
            request.setAttribute("pmpmidyearstatus", pmpmidyearstatus);
            request.setAttribute("pmpendyearstatus", pmpendyearstatus);
            request.setAttribute("pmpasEmployee", pmpasEmployee);

            request.setAttribute("compentencyStartYearStatus", compentencyStartYearStatus);
            request.setAttribute("compentencyMidYearStatus", compentencyMidYearStatus);
            request.setAttribute("compentencyEndYearStatus", compentencyEndYearStatus);

        }

        int managerStatus = appraisalPerformanceMaster.getManagerStatus();
        request.setAttribute("managerStatus", managerStatus);
        int statusFlag = appraisalPerformanceMaster.getStatus();
        request.setAttribute("statusFlag", statusFlag);

        int employeeStatus = appraisalPerformanceMaster.getEmployeeStatus();
        request.setAttribute("employeeStatus", employeeStatus);

        int empCompetencyStatus = appraisalPerformanceMaster.getEmployeeCompetencyStatus();
        request.setAttribute("empCompetencyStatus", empCompetencyStatus);

        int managerCompetencyStatus = appraisalPerformanceMaster.getManagerCompetencyStatus();
        request.setAttribute("managerCompetencyStatus", managerCompetencyStatus);

        int year = Integer.parseInt(request.getParameter("year"));
        request.setAttribute("year", year);

        // =======================competency Evaluation==========================================================//
        competencyList(request);
        int competencyId = 0;
        AppraisalPerformanceCompetencyEvaluation appraisalPerformanceCompetencyEvaluation = new AppraisalPerformanceCompetencyEvaluation();
        appraisalPerformanceCompetencyEvaluation.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
        CompetencyEvaluationTextmaster competencyEvaluationTextmaster = new CompetencyEvaluationTextmaster();
//        List<?> competencyEvaluationList = appraisalPerformanceCompetencyEvaluationService.readAppraisalPerformanceCompetencyEvaluationDetail(appraisalPerformanceCompetencyEvaluation);
        List<?> competencyEvaluationList = appraisalPerformanceCompetencyEvaluationService.readByEmployeeWiseAppraisalPerformanceCompetencyEvaluationDetail(appraisalPerformanceCompetencyEvaluation);

        request.setAttribute("competencyEvaluationList", competencyEvaluationList);

        mv.getModelMap().put("appraisalPerformanceMaster", appraisalPerformanceMaster);
        mv.setViewName("Appraisal/PMPCompetencyIdpForm");
//        mv.setViewName("Appraisal/ManagerPerformanceAppraisalForm");
//        mv.setViewName("forward:userMaster.htm?act=userDashboard");
        return mv;
    }

    public ModelAndView editClickIdp(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AppraisalPerformanceMaster appraisalPerformanceMaster = new AppraisalPerformanceMaster();
        UpdateAppraisalPerformanceKra updateAppraisalPerformanceKra = new UpdateAppraisalPerformanceKra();
        AppraisalPerformanceKra appraisalPerformanceKra = new AppraisalPerformanceKra();
        EmployeeMaster employee = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        PmpFormStatusMaster pmpFormStatusMaster = new PmpFormStatusMaster();
        CompetencyEvaluationMaster competencyEvaluationMaster = new CompetencyEvaluationMaster();
        String employeeName = "" + employee.getEmployeeName();
        String empId = request.getParameter("id");
        String userid = request.getParameter("userid");
        String appraisalId1 = request.getParameter("appraisalId");
        //////Print/////By dhaval
        request.setAttribute("empId", empId);
        request.setAttribute("userid", userid);
        request.setAttribute("appraisalId1", appraisalId1);
        ///////////
        empDateStartToEnd(request, response);
        selectedEmployeeDate(request, response, userid);
        kraCategoryList(request);
        String employeeId = "" + empId;//set the value in employee id
        appraisalPerformanceMaster = appraisalPerformanceService.readById(Integer.parseInt(appraisalId1));

//        if (null != appraisalPerformanceMaster.getManagerStatus()) {
        int managerStatus = appraisalPerformanceMaster.getManagerStatus();
        request.setAttribute("managerStatus", managerStatus);
        int statusFlag = appraisalPerformanceMaster.getStatus();
        request.setAttribute("statusFlag", statusFlag);

        int employeeStatus = appraisalPerformanceMaster.getEmployeeStatus();
        request.setAttribute("employeeStatus", employeeStatus);

        int employeeIdpStatus = appraisalPerformanceMaster.getEmployeeIdpStatus();
        request.setAttribute("employeeIdpStatus", employeeIdpStatus);

        int managerIdpStatus = appraisalPerformanceMaster.getManagerIdpStatus();
        request.setAttribute("managerIdpStatus", managerIdpStatus);

        int year = Integer.parseInt(request.getParameter("year"));
        request.setAttribute("year", year);
        // Changes
        List<AppraisalFillingData> appraisalFilling = (List<AppraisalFillingData>) appraisalFillingDataService.readByCurrentYear("" + year);

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String today = sdf.format(cal.getTime());

        Date now = sdf.parse(today);
        if (!appraisalFilling.isEmpty()) {
            AppraisalFillingData appraisalFillingData = (AppraisalFillingData) appraisalFilling.get(0);

            String StartDate = appraisalFillingData.getStartDate();
            String EndDate = appraisalFillingData.getEndDate();
            String MidDate = appraisalFillingData.getMidYearStartDate();
            String MidEndDate = appraisalFillingData.getMidYearEndDate();
            String YearEndStartDate = appraisalFillingData.getYearEndStartDate();
            String YearEndDate = appraisalFillingData.getYearEndEndDate();
            Date strDate = sdf.parse(StartDate);
            Date eDate = sdf.parse(EndDate);
            Date midDate = sdf.parse(MidDate);
            Date midEndDate = sdf.parse(MidEndDate);
            Date yearEndStartDate = sdf.parse(YearEndStartDate);
            Date yearEndDate = sdf.parse(YearEndDate);
            boolean flag = false;
            boolean flag1 = false;
            boolean flag2 = false;
            if ((now.after(strDate) && now.before(eDate)) || now.equals(strDate) || now.equals(eDate)) {
                flag = true;
            } else if ((now.after(midDate) && now.before(midEndDate)) || now.equals(midDate) || now.equals(midEndDate)) {
                flag1 = true;
            } else if ((now.after(yearEndStartDate) && now.before(yearEndDate)) || now.equals(yearEndStartDate) || now.equals(yearEndDate)) {
                flag2 = true;
            }

            request.setAttribute("flag", flag);
            request.setAttribute("flag1", flag1);
            request.setAttribute("flag2", flag2);
        }
        // Changes

        //Individual Development Plan//
        AppraisalPerformanceIndividualDevelopmentPlan appraisalPerformanceIndividualDevelopmentPlan = new AppraisalPerformanceIndividualDevelopmentPlan();
        appraisalPerformanceIndividualDevelopmentPlan.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
        String text1 = "";
        List<?> individualDevelopmentPlanList = appraisalPerformanceIndividualDevelopmentPlanService.readIndividualDevelopmentPlanDetail(appraisalPerformanceIndividualDevelopmentPlan);
        if (!individualDevelopmentPlanList.isEmpty()) {
            appraisalPerformanceIndividualDevelopmentPlan = (AppraisalPerformanceIndividualDevelopmentPlan) individualDevelopmentPlanList.get(0);
            text1 = appraisalPerformanceIndividualDevelopmentPlan.getText1();
        }
        request.setAttribute("text1", individualDevelopmentPlanList);
        request.setAttribute("text2", individualDevelopmentPlanList);
        request.setAttribute("text3", individualDevelopmentPlanList);
        request.setAttribute("remark", individualDevelopmentPlanList);
        request.setAttribute("midYearRemark", individualDevelopmentPlanList);
        request.setAttribute("endYearRemark", individualDevelopmentPlanList);
        request.setAttribute("individualDevelopmentPlanList", individualDevelopmentPlanList);

        mv.getModelMap().put("appraisalPerformanceMaster", appraisalPerformanceMaster);
        mv.setViewName("Appraisal/PMPForIDP");
//        mv.setViewName("Appraisal/ManagerPerformanceAppraisalForm");
//        mv.setViewName("forward:userMaster.htm?act=userDashboard");
        return mv;
    }

    public ModelAndView createSubmitCompetency(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        AppraisalPerformanceMaster appraisalPerformanceMaster = new AppraisalPerformanceMaster();
        AppraisalPerformanceKra appraisalPerformanceKra = new AppraisalPerformanceKra();
        AppraisalPerformanceKra appraisalPerformanceKra1 = new AppraisalPerformanceKra();
        UpdateAppraisalPerformanceKra updateAppraisalPerformanceKra = new UpdateAppraisalPerformanceKra();
        UpdateAppraisalPerformanceActivities updateAppraisalPerformanceActivities = new UpdateAppraisalPerformanceActivities();
        AppraisalPerformanceActivities appraisalPerformanceActivities = new AppraisalPerformanceActivities();
        AppraisalPerformanceActivities appraisalPerformanceActivities1 = new AppraisalPerformanceActivities();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employee = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        PmpFormStatusMaster pmpFormStatusMaster = new PmpFormStatusMaster();
        BindException errors = new BindException(appraisalPerformanceMaster, "appraisalPerformanceMaster");

        String appraisalId = "";
        //selectedDateflage(request,response);
        String btn = request.getParameter("submit");
        appraisalPerformanceValidator.validate(appraisalPerformanceMaster, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv.addAllObjects(errors.getModel());
        } else {

//            float weightageCount = 0;
//            int countId = Integer.parseInt(request.getParameter("countId"));
//            for (int i = 1; i <= countId; i++) {
//                String weightage1 = request.getParameter("weightage" + i);
//                weightageCount += Float.parseFloat(weightage1);
//            }
//            if (null != btn && btn.equals("submit")) {
//                if (weightageCount == 75) {
//
//                } else {
//
//                    request.setAttribute("failureMessage", "Information : Your Weightege is not equal to 75");
//                    mv.getModelMap().put("appraisalPerformanceMaster", appraisalPerformanceMaster);
//                    mv = searchOwnappraisalPerformanceSubmit(request, response);
//                    return mv;
//                }
//            }
            String employeeId = "" + employee.getId();
            String employeeName = "" + employee.getEmployeeName();
//            int year = Calendar.getInstance().get(Calendar.YEAR);
            int year = Integer.parseInt(request.getParameter("year"));
            //StartDate To create FirstTime//
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date now = new Date();
            String strDate = sdf1.format(now);
            String today = sdf.format(cal.getTime());
            String startdate = "" + today;

            List<?> list = appraisalPerformanceService.readByAppraisalPerformanceId(employeeId, year);
            if (!list.isEmpty()) {
                //AppraisalPerformanceMaster appraisalPerformanceMaster =new AppraisalPerformanceMaster();
                appraisalPerformanceMaster = (AppraisalPerformanceMaster) list.get(0);
                appraisalId = "" + appraisalPerformanceMaster.getId();
                appraisalPerformanceMaster.setId(Integer.parseInt(appraisalId));
//                appraisalPerformanceKra.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
            }
//            if (null == appraisalPerformanceMaster.getId()) {
//
//                int behaviosyear = Calendar.getInstance().get(Calendar.YEAR);
//                appraisalPerformanceMaster.setEmployeeMaster(employee);
//                appraisalPerformanceMaster.setStatus(0);
//                appraisalPerformanceMaster.setManagerStatus(0);
//                appraisalPerformanceMaster.setEmployeeStatus(0);
//                appraisalPerformanceMaster.setBehaviorsYear("" + behaviosyear);
//                appraisalPerformanceKra.setStartDate(startdate);
//
//                appraisalPerformanceService.create(appraisalPerformanceMaster);
//            }

            String flagId = request.getParameter("flagId");
            String midhalf = request.getParameter("flagMidId");
            String endhalf = request.getParameter("flagEndId");

            if (null != btn && btn.equals("submit")) {

//                appraisalPerformanceMaster.setStatus(1);
//                appraisalPerformanceMaster.setManagerkraStatus(0);
//                appraisalPerformanceMaster.setEmployeeStatus(1);
//                appraisalPerformanceMaster.setReworkStatus(0);
                appraisalPerformanceMaster.setEmployeeCompetencyStatus(1);
                appraisalPerformanceMaster.setManagerCompetencyStatus(0);
                appraisalPerformanceMaster.setCompetencyReworkStatus(0);

//                if (midhalf.equals("true")) {
//                    appraisalPerformanceMaster.setMidYearEmployeeStatus(1);
//                }
//                if (endhalf.equals("true")) {
//                    appraisalPerformanceMaster.setEndYearEmployeeStatus(1);
//                }
                appraisalPerformanceService.update(appraisalPerformanceMaster);
                if (!"".equals(flagId) && null != flagId) {
                    if (flagId.equals("true")) {
//   Email Sent to ReportingManager1 at Start Year
                        try {
                            EmailTemplate emailTemplate = new EmailTemplate();
                            EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                            DesignationMaster designationMaster = new DesignationMaster();
                            designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                            EmployeeMaster employeeMasterHr = new EmployeeMaster();
                            employeeMasterHr = employeeMasterService.readById(Integer.parseInt(employeeMasterModel.getReportingManagerLevel1()));
                            // id 113 is for Appraisal Submitted by employee(Start year)
                            emailTemplate = emailTemplateService.readById(113);
                            String To = employeeMasterHr.getOfficeEmailId();
                            String from = employeeMasterModel.getOfficeEmailId();
                            String Subject = emailTemplate.getSubject();
                            Subject = Subject.replaceAll("\\{user\\}", employeeMasterModel.getEmployeeName());
                            String msg = emailTemplate.getBodytext();
                            msg = msg.replaceAll("\\{to_user\\}", employeeMasterHr.getEmployeeName());
                            msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                            msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                            sendMail.sendMail(from, To, Subject, msg);
                            mailSendPmpStartHalfapply(request);
                        } catch (Exception e) {

                        }
                    }
                }
                if (!"".equals(midhalf) && null != midhalf) {
                    if (midhalf.equals("true")) {
//   Email Sent to ReportingManager1 at Mid Year
                        try {
                            EmailTemplate emailTemplate = new EmailTemplate();
                            EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                            DesignationMaster designationMaster = new DesignationMaster();
                            designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                            EmployeeMaster employeeMasterHr = new EmployeeMaster();
                            employeeMasterHr = employeeMasterService.readById(Integer.parseInt(employeeMasterModel.getReportingManagerLevel1()));
                            // id 114 is for Appraisal Submitted by employee(Mid year)
                            emailTemplate = emailTemplateService.readById(114);
                            String To = employeeMasterHr.getOfficeEmailId();
                            String from = employeeMasterModel.getOfficeEmailId();
                            String Subject = emailTemplate.getSubject();
                            Subject = Subject.replaceAll("\\{user\\}", employeeMasterModel.getEmployeeName());
                            String msg = emailTemplate.getBodytext();
                            msg = msg.replaceAll("\\{to_user\\}", employeeMasterHr.getEmployeeName());
                            msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                            msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                            sendMail.sendMail(from, To, Subject, msg);
                            mailSendPmpMidHalfapply(request);
                        } catch (Exception e) {

                        }
                    }
                }
                if (!"".equals(endhalf) && null != endhalf) {
                    if (endhalf.equals("true")) {
//   Email Sent to ReportingManager1 at  Year End
                        try {
                            EmailTemplate emailTemplate = new EmailTemplate();
                            EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                            DesignationMaster designationMaster = new DesignationMaster();
                            designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                            EmployeeMaster employeeMasterHr = new EmployeeMaster();
                            employeeMasterHr = employeeMasterService.readById(Integer.parseInt(employeeMasterModel.getReportingManagerLevel1()));
                            // id 115 is for Appraisal Submitted by employee(year End)
                            emailTemplate = emailTemplateService.readById(115);
                            String To = employeeMasterHr.getOfficeEmailId();
                            String from = employeeMasterModel.getOfficeEmailId();
                            String Subject = emailTemplate.getSubject();
                            Subject = Subject.replaceAll("\\{user\\}", employeeMasterModel.getEmployeeName());
                            String msg = emailTemplate.getBodytext();
                            msg = msg.replaceAll("\\{to_user\\}", employeeMasterHr.getEmployeeName());
                            msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                            msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                            sendMail.sendMail(from, To, Subject, msg);
                            mailSendPmpEndHalfapply(request);
                        } catch (Exception e) {

                        }
                    }
                }
            } else {

                appraisalPerformanceService.update(appraisalPerformanceMaster);
            }

//            StartDate To create FirstTime//
//            =========if appraisalPerformance is create and after get id=======//
//            appraisalPerformanceKra.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
            appraisalPerformanceMaster.getId();//get Appraisal id
//            String employeeName = request.getParameter("employeeName");

            ///////////////////Competency Evaluation (As Per Zydex Competency Framework)////////////////////////////
            AppraisalPerformanceCompetencyEvaluation appraisalPerformanceCompetencyEvaluation = new AppraisalPerformanceCompetencyEvaluation();
            CompetencyEvaluationTextmaster competencyEvaluationTextmaster = new CompetencyEvaluationTextmaster();
            CompetencyEvaluationMaster competencyEvaluationMaster = new CompetencyEvaluationMaster();
            int subCompentencyCount = Integer.parseInt(request.getParameter("subCompentencyCount"));
            boolean flag = true;
            for (int i = 1; i <= subCompentencyCount; i++) {
                String competencyEveId = request.getParameter("competencyEveId" + i);
                if (competencyEveId != null) {
                    appraisalPerformanceCompetencyEvaluation = appraisalPerformanceCompetencyEvaluationService.readById(Integer.parseInt(competencyEveId));
                }
                String compentencyStartYear = request.getParameter("compentencyStartYear" + i);
                String compentencyStartRemark = request.getParameter("compentencyStartRemark" + i);
                String compentencyMidYear = request.getParameter("compentencyMidYear" + i);
                String compentencyMidRemark = request.getParameter("compentencyMidRemark" + i);
                String compentencyEndYear = request.getParameter("compentencyEndYear" + i);
                String compentencyEndRemark = request.getParameter("compentencyEndRemark" + i);
                if (!"".equals(compentencyStartYear) && null != compentencyStartYear) {
                    appraisalPerformanceCompetencyEvaluation.setCompetencyStartYear(compentencyStartYear);
                } else {
                    appraisalPerformanceCompetencyEvaluation.setCompetencyStartYear(null);
                }
                if (!"".equals(compentencyStartRemark) && null != compentencyStartRemark) {
                    appraisalPerformanceCompetencyEvaluation.setStartyearRemark(compentencyStartRemark);
                } else {
                    appraisalPerformanceCompetencyEvaluation.setStartyearRemark(null);
                }
                if (!"".equals(compentencyMidYear) && null != compentencyMidYear) {
                    appraisalPerformanceCompetencyEvaluation.setCompetencyMidYear(compentencyMidYear);
                } else {
                    appraisalPerformanceCompetencyEvaluation.setCompetencyMidYear(null);
                }
                if (!"".equals(compentencyMidRemark) && null != compentencyMidRemark) {
                    appraisalPerformanceCompetencyEvaluation.setMidyearRemark(compentencyMidRemark);
                } else {
                    appraisalPerformanceCompetencyEvaluation.setMidyearRemark(null);
                }
                if (!"".equals(compentencyEndYear) && null != compentencyEndYear) {
                    appraisalPerformanceCompetencyEvaluation.setCompetencyEndYear(compentencyEndYear);
                } else {
                    appraisalPerformanceCompetencyEvaluation.setCompetencyEndYear(null);
                }
                if (!"".equals(compentencyEndRemark) && null != compentencyEndRemark) {
                    appraisalPerformanceCompetencyEvaluation.setEndyearRemark(compentencyEndRemark);
                } else {
                    appraisalPerformanceCompetencyEvaluation.setCompetencyEndYear(null);
                }

//
                appraisalPerformanceCompetencyEvaluation.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
                int compentencyTextMasterId = Integer.parseInt(request.getParameter("compentencyTextMasterId" + i));
                competencyEvaluationTextmaster.setId(compentencyTextMasterId);
//                competencyEvaluationMaster.setId(competencyEvaluationId);
//                appraisalPerformanceCompetencyEvaluation.setCompetencyEvaluationMaster(competencyEvaluationMaster);
                appraisalPerformanceCompetencyEvaluation.setCompetencyEvaluationTextmaster(competencyEvaluationTextmaster);
//                String competencyEveId = request.getParameter("competencyEveId" + i);
                String btn2 = request.getParameter("save");

                if (null != btn2 && btn2.equals("save")) {
                    if (!"".equals(competencyEveId) && null != competencyEveId) {
                        int competencyEvaluationId = Integer.parseInt(request.getParameter("competencyEvaluationId" + i));
                        competencyEvaluationMaster.setId(competencyEvaluationId);
                        appraisalPerformanceCompetencyEvaluation.setCompetencyEvaluationMaster(competencyEvaluationMaster);
                        appraisalPerformanceCompetencyEvaluation.setId(Integer.parseInt(competencyEveId));
//                        appraisalPerformanceCompetencyEvaluation.setEmployeeStatus(1);
                        appraisalPerformanceCompetencyEvaluationService.update(appraisalPerformanceCompetencyEvaluation);

                    } else {
//                        if (!appraisalId.isEmpty()) {
//                            if (flag) {
//                                for (String id : appraisalId.split(",")) {
//                                    if (!id.equals("")) {
//                                        AppraisalPerformanceCompetencyEvaluation appraisalPerformanceCompetencyEvaluation2 = new AppraisalPerformanceCompetencyEvaluation();
//                                        AppraisalPerformanceCompetencyEvaluationHistory appraisalPerformanceCompetencyEvaluationHistory = new AppraisalPerformanceCompetencyEvaluationHistory();
//                                        appraisalPerformanceCompetencyEvaluation2.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
//
//                                        try {
//
//                                            List<AppraisalPerformanceCompetencyEvaluation> competencyList = (List<AppraisalPerformanceCompetencyEvaluation>) appraisalPerformanceCompetencyEvaluationService.readByAppraisalPerformanceId(appraisalPerformanceCompetencyEvaluation2);
//
//                                            for (AppraisalPerformanceCompetencyEvaluation appraisalPerformanceCompetencyEvaluation1 : competencyList) {
//
//                                                BeanUtils.copyProperties(appraisalPerformanceCompetencyEvaluation1, appraisalPerformanceCompetencyEvaluationHistory);
//                                                appraisalPerformanceCompetencyEvaluationHistory.setAppraisalPerformanceId(appraisalPerformanceCompetencyEvaluation1.getAppraisalPerformanceMaster().getId());
//                                                appraisalPerformanceCompetencyEvaluationHistory.setCompetencyEvaluationId(appraisalPerformanceCompetencyEvaluation1.getCompetencyEvaluationMaster().getId());
//                                                appraisalPerformanceCompetencyEvaluationHistory.setCompetencyEvaluationTextId(appraisalPerformanceCompetencyEvaluation1.getCompetencyEvaluationTextmaster().getId());
////                                            appraisalPerformanceCompetencyEvaluationHistory.setDateStr(startdate);
//                                                appraisalPerformanceCompetencyEvaluationHistory.setDateStr(strDate);
//                                                appraisalPerformanceCompetencyEvaluationHistory.setDeletedBy("Employee Side");
//                                                appraisalPerformanceCompetencyEvaluationHistory.setId(0);
//                                                appraisalPerformanceCompetencyEvaluationHistoryService.create(appraisalPerformanceCompetencyEvaluationHistory);
//                                            }
//                                        } catch (Exception e) {
//                                            e.printStackTrace();
//                                        }
//
//                                        appraisalPerformanceCompetencyEvaluationService.delete1(appraisalPerformanceCompetencyEvaluation2);
//                                        flag = false;
//                                    }
//                                }
//                            }
//                        }
                        String competencyEvaluationId = request.getParameter("competencyEvaluationId");
                        if (!"".equals(competencyEvaluationId) && null != competencyEvaluationId) {
                            int competencyEvaluation_Id = Integer.parseInt(competencyEvaluationId);
                            competencyEvaluationMaster.setId(competencyEvaluation_Id);
                            appraisalPerformanceCompetencyEvaluation.setCompetencyEvaluationMaster(competencyEvaluationMaster);
//                            appraisalPerformanceCompetencyEvaluation.setEmployeeStatus(1);
                            appraisalPerformanceCompetencyEvaluationService.create(appraisalPerformanceCompetencyEvaluation);
                        }
                    }
                } else {

                    /////////manager StartYearManager///////////////////////////////
                    if (!"".equals(compentencyStartYear) && null != compentencyStartYear) {
                        appraisalPerformanceCompetencyEvaluation.setCompetencyStartYearManager(compentencyStartYear);
                    } else {
                        appraisalPerformanceCompetencyEvaluation.setCompetencyStartYearManager(null);
                    }
                    if (!"".equals(compentencyStartRemark) && null != compentencyStartRemark) {
                        appraisalPerformanceCompetencyEvaluation.setStartyearRemarkManager(compentencyStartRemark);
                    } else {
                        appraisalPerformanceCompetencyEvaluation.setStartyearRemarkManager(null);
                    }
                    if (!"".equals(compentencyMidYear) && null != compentencyMidYear) {
                        appraisalPerformanceCompetencyEvaluation.setCompetencyMidYearManager(compentencyMidYear);
                    } else {
                        appraisalPerformanceCompetencyEvaluation.setCompetencyMidYearManager(null);
                    }
                    if (!"".equals(compentencyMidRemark) && null != compentencyMidRemark) {
                        appraisalPerformanceCompetencyEvaluation.setMidyearRemarkManager(compentencyMidRemark);
                    } else {
                        appraisalPerformanceCompetencyEvaluation.setMidyearRemarkManager(null);
                    }
                    if (!"".equals(compentencyEndYear) && null != compentencyEndYear) {
                        appraisalPerformanceCompetencyEvaluation.setCompetencyEndYearManager(compentencyEndYear);
                    } else {
                        appraisalPerformanceCompetencyEvaluation.setCompetencyEndYearManager(null);
                    }
                    if (!"".equals(compentencyEndRemark) && null != compentencyEndRemark) {
                        appraisalPerformanceCompetencyEvaluation.setEndyearRemarkManager(compentencyEndRemark);
                    } else {
                        appraisalPerformanceCompetencyEvaluation.setCompetencyEndYearManager(null);
                    }
                    if (!"".equals(competencyEveId) && null != competencyEveId) {
                        int competencyEvaluationId = Integer.parseInt(request.getParameter("competencyEvaluationId" + i));
                        competencyEvaluationMaster.setId(competencyEvaluationId);
                        appraisalPerformanceCompetencyEvaluation.setCompetencyEvaluationMaster(competencyEvaluationMaster);
                        appraisalPerformanceCompetencyEvaluation.setId(Integer.parseInt(competencyEveId));
//                        appraisalPerformanceCompetencyEvaluation.setEmployeeStatus(1);
                        appraisalPerformanceCompetencyEvaluationService.update(appraisalPerformanceCompetencyEvaluation);

                    } else {
//                        if (!appraisalId.isEmpty()) {
//                            if (flag) {
//                                for (String id : appraisalId.split(",")) {
//                                    if (!id.equals("")) {
//                                        AppraisalPerformanceCompetencyEvaluation appraisalPerformanceCompetencyEvaluation2 = new AppraisalPerformanceCompetencyEvaluation();
//                                        appraisalPerformanceCompetencyEvaluation2.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
//                                        appraisalPerformanceCompetencyEvaluationService.delete1(appraisalPerformanceCompetencyEvaluation2);
//                                        flag = false;
//                                    }
//                                }
//                            }
//                        }
                        String competencyEvaluationId = request.getParameter("competencyEvaluationId");
                        if (!"".equals(competencyEvaluationId) && null != competencyEvaluationId) {
                            int competencyEvaluation_Id = Integer.parseInt(competencyEvaluationId);
                            competencyEvaluationMaster.setId(competencyEvaluation_Id);
                            appraisalPerformanceCompetencyEvaluation.setCompetencyEvaluationMaster(competencyEvaluationMaster);
//                            appraisalPerformanceCompetencyEvaluation.setEmployeeStatus(1);
                            appraisalPerformanceCompetencyEvaluationService.create(appraisalPerformanceCompetencyEvaluation);
                        }
                    }
                }
            }

        }
        mv.getModelMap().put("appraisalPerformanceMaster", appraisalPerformanceMaster);
//        mv.setViewName("forward:userMaster.htm?act=userDashboard");
//        mv = createClick(request, response);
        mv.setViewName("redirect:appraisalPerformance.htm?act=searchOwnappraisalPerformanceSubmit");
//        mv = searchOwnappraisalPerformanceSubmit(request, response);
//        mv.setViewName("Appraisal/PerformanceAppraisalForm");
        return mv;
    }

    public ModelAndView createSubmitIDP(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        AppraisalPerformanceMaster appraisalPerformanceMaster = new AppraisalPerformanceMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employee = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        PmpFormStatusMaster pmpFormStatusMaster = new PmpFormStatusMaster();
        BindException errors = new BindException(appraisalPerformanceMaster, "appraisalPerformanceMaster");
        String appraisalId = "";
        //selectedDateflage(request,response);
        String btn = request.getParameter("submit");
        appraisalPerformanceValidator.validate(appraisalPerformanceMaster, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv.addAllObjects(errors.getModel());
        } else {

//            float weightageCount = 0;
//            int countId = Integer.parseInt(request.getParameter("countId"));
//            for (int i = 1; i <= countId; i++) {
//                String weightage1 = request.getParameter("weightage" + i);
//                weightageCount += Float.parseFloat(weightage1);
//            }
//            if (null != btn && btn.equals("submit")) {
//                if (weightageCount == 75) {
//
//                } else {
//
//                    request.setAttribute("failureMessage", "Information : Your Weightege is not equal to 75");
//                    mv.getModelMap().put("appraisalPerformanceMaster", appraisalPerformanceMaster);
//                    mv = searchOwnappraisalPerformanceSubmit(request, response);
//                    return mv;
//                }
//            }
            String employeeId = "" + employee.getId();
            String employeeName = "" + employee.getEmployeeName();
            //int year = Calendar.getInstance().get(Calendar.YEAR);
            int year = Integer.parseInt(request.getParameter("year"));
            List<?> l1 = appraisalFillingDataService.getCurrentAndPreviousYear();
            String previousYear = "";
            int currentYear = 0;
            if (!l1.isEmpty()) {
                Object[] obj = (Object[]) l1.get(0);
//            previousYear = (Integer) obj[0];
                previousYear = "" + obj[0];
//            currentYear = (Integer) obj[1];
            }

            //StartDate To create FirstTime//
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date now = new Date();
            String strDate = sdf1.format(now);
            String today = sdf.format(cal.getTime());
            String startdate = "" + today;
//            String weightageScore = request.getParameter("weightageScore");
//            if (null == weightageScore) {
//                weightageScore = "";
//            }
//            List<?> list = appraisalPerformanceService.readByAppraisalPerformanceId(employeeId, Integer.parseInt(previousYear));
            List<?> list = appraisalPerformanceService.readByAppraisalPerformanceId(employeeId, year);
            if (!list.isEmpty()) {
                //AppraisalPerformanceMaster appraisalPerformanceMaster =new AppraisalPerformanceMaster();
                appraisalPerformanceMaster = (AppraisalPerformanceMaster) list.get(0);
                appraisalId = "" + appraisalPerformanceMaster.getId();
                appraisalPerformanceMaster.setId(Integer.parseInt(appraisalId));
//                appraisalPerformanceKra.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
            }
//            if (null == appraisalPerformanceMaster.getId()) {
//
//                int behaviosyear = Calendar.getInstance().get(Calendar.YEAR);
//                appraisalPerformanceMaster.setEmployeeMaster(employee);
//                appraisalPerformanceMaster.setStatus(0);
//                appraisalPerformanceMaster.setManagerStatus(0);
//                appraisalPerformanceMaster.setEmployeeStatus(0);
//                appraisalPerformanceMaster.setBehaviorsYear("" + behaviosyear);
//                appraisalPerformanceKra.setStartDate(startdate);
//                appraisalPerformanceMaster.setWeightageScore(weightageScore);
//                appraisalPerformanceService.create(appraisalPerformanceMaster);
//            }

            String flagId = request.getParameter("flagId");
            String midhalf = request.getParameter("flagMidId");
            String endhalf = request.getParameter("flagEndId");
//            List<?> kraList = appraisalPerformanceKraService.readByAppraisalPerformancekraId(appraisalPerformanceKra);
//            if (!kraList.isEmpty()) {
//                appraisalPerformanceKra = (AppraisalPerformanceKra) kraList;
//                appraisalPerformanceKra.getId();
//            }

            if (null != btn && btn.equals("submit")) {

//                appraisalPerformanceMaster.setStatus(1);
//                appraisalPerformanceMaster.setManagerkraStatus(0);
//                appraisalPerformanceMaster.setEmployeeStatus(1);
//                appraisalPerformanceMaster.setReworkStatus(0);
                appraisalPerformanceMaster.setEmployeeIdpStatus(1);
                appraisalPerformanceMaster.setManagerIdpStatus(0);
                appraisalPerformanceMaster.setIdpReworkStatus(0);

                appraisalPerformanceService.update(appraisalPerformanceMaster);
                if (!"".equals(flagId) && null != flagId) {
                    if (flagId.equals("true")) {
//   Email Sent to ReportingManager1 at Start Year
                        try {
                            EmailTemplate emailTemplate = new EmailTemplate();
                            EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                            DesignationMaster designationMaster = new DesignationMaster();
                            designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                            EmployeeMaster employeeMasterHr = new EmployeeMaster();
                            employeeMasterHr = employeeMasterService.readById(Integer.parseInt(employeeMasterModel.getReportingManagerLevel1()));
                            // id 113 is for Appraisal Submitted by employee(Start year)
                            emailTemplate = emailTemplateService.readById(113);
                            String To = employeeMasterHr.getOfficeEmailId();
                            String from = employeeMasterModel.getOfficeEmailId();
                            String Subject = emailTemplate.getSubject();
                            Subject = Subject.replaceAll("\\{user\\}", employeeMasterModel.getEmployeeName());
                            String msg = emailTemplate.getBodytext();
                            msg = msg.replaceAll("\\{to_user\\}", employeeMasterHr.getEmployeeName());
                            msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                            msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                            sendMail.sendMail(from, To, Subject, msg);
                            mailSendPmpStartHalfapply(request);
                        } catch (Exception e) {

                        }
                    }
                }
                if (!"".equals(midhalf) && null != midhalf) {
                    if (midhalf.equals("true")) {
//   Email Sent to ReportingManager1 at Mid Year
                        try {
                            EmailTemplate emailTemplate = new EmailTemplate();
                            EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                            DesignationMaster designationMaster = new DesignationMaster();
                            designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                            EmployeeMaster employeeMasterHr = new EmployeeMaster();
                            employeeMasterHr = employeeMasterService.readById(Integer.parseInt(employeeMasterModel.getReportingManagerLevel1()));
                            // id 114 is for Appraisal Submitted by employee(Mid year)
                            emailTemplate = emailTemplateService.readById(114);
                            String To = employeeMasterHr.getOfficeEmailId();
                            String from = employeeMasterModel.getOfficeEmailId();
                            String Subject = emailTemplate.getSubject();
                            Subject = Subject.replaceAll("\\{user\\}", employeeMasterModel.getEmployeeName());
                            String msg = emailTemplate.getBodytext();
                            msg = msg.replaceAll("\\{to_user\\}", employeeMasterHr.getEmployeeName());
                            msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                            msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                            sendMail.sendMail(from, To, Subject, msg);
                            mailSendPmpMidHalfapply(request);
                        } catch (Exception e) {

                        }
                    }
                }
                if (!"".equals(endhalf) && null != endhalf) {
                    if (endhalf.equals("true")) {
//   Email Sent to ReportingManager1 at  Year End
                        try {
                            EmailTemplate emailTemplate = new EmailTemplate();
                            EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                            DesignationMaster designationMaster = new DesignationMaster();
                            designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                            EmployeeMaster employeeMasterHr = new EmployeeMaster();
                            employeeMasterHr = employeeMasterService.readById(Integer.parseInt(employeeMasterModel.getReportingManagerLevel1()));
                            // id 115 is for Appraisal Submitted by employee(year End)
                            emailTemplate = emailTemplateService.readById(115);
                            String To = employeeMasterHr.getOfficeEmailId();
                            String from = employeeMasterModel.getOfficeEmailId();
                            String Subject = emailTemplate.getSubject();
                            Subject = Subject.replaceAll("\\{user\\}", employeeMasterModel.getEmployeeName());
                            String msg = emailTemplate.getBodytext();
                            msg = msg.replaceAll("\\{to_user\\}", employeeMasterHr.getEmployeeName());
                            msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                            msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                            sendMail.sendMail(from, To, Subject, msg);
                            mailSendPmpEndHalfapply(request);
                        } catch (Exception e) {

                        }
                    }
                }
            } else {

//                appraisalPerformanceMaster.setWeightageScore(weightageScore);
                appraisalPerformanceService.update(appraisalPerformanceMaster);
            }

//            StartDate To create FirstTime//
//            =========if appraisalPerformance is create and after get id=======//
            appraisalPerformanceMaster.getId();//get Appraisal id
            //String employeeName = request.getParameter("employeeName");

///////////////////////////Individual Development Plan//////////////////////////////////
            AppraisalPerformanceIndividualDevelopmentPlan appraisalPerformanceIndividualDevelopmentPlan = new AppraisalPerformanceIndividualDevelopmentPlan();
            int individualcount = Integer.parseInt(request.getParameter("IndividualId"));
            for (int i = 1; i <= individualcount; i++) {
                String individualplan = request.getParameter("IndividualDevelopmentPlanId" + i);
                if (null != individualplan) {

                    appraisalPerformanceIndividualDevelopmentPlan = appraisalPerformanceIndividualDevelopmentPlanService.readById(Integer.parseInt(individualplan));
                }
                String text1 = request.getParameter("text" + i);
                String text2 = request.getParameter("individualtextDiv" + i);
                String text3 = request.getParameter("trainingSelectId" + i);
                String remark = request.getParameter("trainingSelectTextinput" + i);
                String midYearRemark = request.getParameter("midYearRemark" + i);
                String endYearRemark = request.getParameter("endYearRemark" + i);
                String managerMidYearRemark = request.getParameter("managerMidYearRemark" + i);
                String managerEndYearRemark = request.getParameter("managerEndYearRemark" + i);
                if (!"".equals(text1) && null != text1) {
                    appraisalPerformanceIndividualDevelopmentPlan.setText1(text1);
                } else {
                    appraisalPerformanceIndividualDevelopmentPlan.setText1(null);
                }

                if (!"".equals(text2) && null != text2) {
                    appraisalPerformanceIndividualDevelopmentPlan.setText2(text2);
                } else {
                    appraisalPerformanceIndividualDevelopmentPlan.setText2(null);
                }
//                if (!"".equals(text2) && null != text2) {
//                    appraisalPerformanceIndividualDevelopmentPlan.setManagertext2(text2);
//                } else {
//                    appraisalPerformanceIndividualDevelopmentPlan.setManagertext2(null);
//                }
                if (!"".equals(text3) && null != text3) {
                    appraisalPerformanceIndividualDevelopmentPlan.setText3(text3);
                } else {
                    appraisalPerformanceIndividualDevelopmentPlan.setText3(null);
                }
//                if (!"".equals(text3) && null != text3) {
//                    appraisalPerformanceIndividualDevelopmentPlan.setManagertext3(text3);
//                } else {
//                    appraisalPerformanceIndividualDevelopmentPlan.setManagertext3(null);
//                }
                if (!"".equals(remark) && null != remark) {
                    appraisalPerformanceIndividualDevelopmentPlan.setRemark(remark);
                } else {
                    appraisalPerformanceIndividualDevelopmentPlan.setRemark(null);
                }
                if (!"".equals(midYearRemark) && null != midYearRemark) {
                    appraisalPerformanceIndividualDevelopmentPlan.setMidYearRemark(midYearRemark);
                } else {
                    appraisalPerformanceIndividualDevelopmentPlan.setMidYearRemark(null);
                }
                if (!"".equals(endYearRemark) && null != endYearRemark) {
                    appraisalPerformanceIndividualDevelopmentPlan.setEndYearRemark(endYearRemark);
                } else {
                    appraisalPerformanceIndividualDevelopmentPlan.setEndYearRemark(null);
                }

                String btn4 = request.getParameter("save");
                if (null != btn4 && btn4.equals("save")) {

                    if (individualplan != null) {
                        appraisalPerformanceIndividualDevelopmentPlan.setId(Integer.parseInt(individualplan));
                        appraisalPerformanceIndividualDevelopmentPlanService.update(appraisalPerformanceIndividualDevelopmentPlan);
                    } else {
                        appraisalPerformanceIndividualDevelopmentPlan.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
                        appraisalPerformanceIndividualDevelopmentPlanService.create(appraisalPerformanceIndividualDevelopmentPlan);
                    }
                    request.setAttribute("successMessage",
                            "Information : The Information is Saved Successfully.");
                } else {

                    if (null != text1 && !"".equals(text1)) {
                        appraisalPerformanceIndividualDevelopmentPlan.setManagertext1(text1);
                    } else {
                        appraisalPerformanceIndividualDevelopmentPlan.setManagertext1(null);
                    }
                    if (null != text2 && !"".equals(text2)) {
                        appraisalPerformanceIndividualDevelopmentPlan.setManagertext2(text2);
                    } else {
                        appraisalPerformanceIndividualDevelopmentPlan.setManagertext2(null);
                    }
                    if (null != text3 && !"".equals(text3)) {
                        appraisalPerformanceIndividualDevelopmentPlan.setManagertext3(text3);
                    } else {
                        appraisalPerformanceIndividualDevelopmentPlan.setManagertext3(null);
                    }
                    if (null != managerMidYearRemark && !"".equals(managerMidYearRemark)) {
                        appraisalPerformanceIndividualDevelopmentPlan.setManagerMidYearRemark(managerMidYearRemark);
                    } else {
                        appraisalPerformanceIndividualDevelopmentPlan.setManagerMidYearRemark(null);
                    }

                    if (null != remark && !"".equals(remark)) {
                        appraisalPerformanceIndividualDevelopmentPlan.setManagerremark(remark);
                    } else {
                        appraisalPerformanceIndividualDevelopmentPlan.setManagerremark(null);
                    }
                    if (null != endYearRemark && !"".equals(endYearRemark)) {
                        appraisalPerformanceIndividualDevelopmentPlan.setManagerEndYearRemarkEmployee(endYearRemark);
                    } else {
                        appraisalPerformanceIndividualDevelopmentPlan.setManagerEndYearRemarkEmployee(null);
                    }

                    if (null != managerEndYearRemark && !"".equals(managerEndYearRemark)) {
                        appraisalPerformanceIndividualDevelopmentPlan.setManagerEndYearRemark(managerEndYearRemark);
                    } else {
                        appraisalPerformanceIndividualDevelopmentPlan.setManagerEndYearRemark(null);
                    }
                    if (null != managerEndYearRemark && !"".equals(managerEndYearRemark)) {
                        appraisalPerformanceIndividualDevelopmentPlan.setManagerEndYearRemarkManager(managerEndYearRemark);
                    } else {
                        appraisalPerformanceIndividualDevelopmentPlan.setManagerEndYearRemarkManager(null);
                    }
//                    Mid year for Manager side //
                    if (null != midYearRemark && !"".equals(midYearRemark)) {
                        appraisalPerformanceIndividualDevelopmentPlan.setManagerMidYearRemarkManager(midYearRemark);
                    } else {
                        appraisalPerformanceIndividualDevelopmentPlan.setManagerMidYearRemarkManager(null);
                    }
                    if (null != managerEndYearRemark && !"".equals(managerEndYearRemark)) {
                        appraisalPerformanceIndividualDevelopmentPlan.setManagerEndYearRemarkManager(managerEndYearRemark);
                    } else {
                        appraisalPerformanceIndividualDevelopmentPlan.setManagerEndYearRemarkManager(null);
                    }

                    if (individualplan != null) {
                        appraisalPerformanceIndividualDevelopmentPlan.setId(Integer.parseInt(individualplan));
                        appraisalPerformanceIndividualDevelopmentPlanService.update(appraisalPerformanceIndividualDevelopmentPlan);
                    } else {
                        appraisalPerformanceIndividualDevelopmentPlan.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
                        appraisalPerformanceIndividualDevelopmentPlanService.create(appraisalPerformanceIndividualDevelopmentPlan);
                    }
                    request.setAttribute("successMessage",
                            "Information : The Information is Submit Successfully.");
                }
            }
        }
        mv.getModelMap().put("appraisalPerformanceMaster", appraisalPerformanceMaster);
//        mv.setViewName("forward:userMaster.htm?act=userDashboard");
//        mv = createClick(request, response);
        mv.setViewName("redirect:appraisalPerformance.htm?act=searchOwnappraisalPerformanceSubmit");
//        mv = searchOwnappraisalPerformanceSubmit(request, response);
//        mv.setViewName("Appraisal/PerformanceAppraisalForm");
        return mv;
    }

    public ModelAndView editClickCompetencyForManager(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ////////////Manager
        ModelAndView mv = new ModelAndView();
        AppraisalPerformanceMaster appraisalPerformanceMaster = new AppraisalPerformanceMaster();
        UpdateAppraisalPerformanceKra updateAppraisalPerformanceKra = new UpdateAppraisalPerformanceKra();
        AppraisalPerformanceKra appraisalPerformanceKra = new AppraisalPerformanceKra();
        EmployeeMaster employee = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        String employeeName = "" + employee.getEmployeeName();
        String empId = request.getParameter("id");
        String userid = request.getParameter("userid");
        String appraisalId1 = request.getParameter("appraisalId");
        PmpFormStatusMaster pmpFormStatusMaster = new PmpFormStatusMaster();
        //////Print/////By dhaval
        request.setAttribute("empId", empId);
        request.setAttribute("userid", userid);
        request.setAttribute("appraisalId", appraisalId1);

//        request.setAttribute("empId", empId);
//        request.setAttribute("userid", userid);
//        request.setAttribute("appraisalId1", appraisalId1);
        ///////////
//        selectedEmployeeDate(request, response, userid);
        managerDateStartToEnd(request, response);
        managerTimeLineDate(request, response, userid);
        kraCategoryList(request);
        String employeeId = "" + empId;//set the value in employee id
        appraisalPerformanceMaster = appraisalPerformanceService.readById(Integer.parseInt(appraisalId1));
//        if (null != appraisalPerformanceMaster.getWeightageScore()) {
//            String weightageScore = appraisalPerformanceMaster.getWeightageScore();
//            request.setAttribute("weightageScore", weightageScore);
//        }

        String pmpstatusId = "";
        List<?> pmplist = pmpFormStatusMasterService.readByPmpformstatusStatus(employeeId);
        if (!pmplist.isEmpty()) {
            pmpFormStatusMaster = (PmpFormStatusMaster) pmplist.get(0);
            pmpstatusId = "" + pmpFormStatusMaster.getId();
            boolean pmpstartyearstatus = pmpFormStatusMaster.getStartYearStatus();
            boolean pmpmidyearstatus = pmpFormStatusMaster.getMidYearStatus();
            boolean pmpendyearstatus = pmpFormStatusMaster.getEndYearStatus();
            boolean pmpasManager = pmpFormStatusMaster.getManagerSide();

            boolean compentencyStartYearStatus = pmpFormStatusMaster.getCompentencyStartYearStatus();
            boolean compentencyMidYearStatus = pmpFormStatusMaster.getCompentencyMidYearStatus();
            boolean compentencyEndYearStatus = pmpFormStatusMaster.getCompentencyEndYearStatus();

            request.setAttribute("pmpstartyearstatus", pmpstartyearstatus);
            request.setAttribute("pmpmidyearstatus", pmpmidyearstatus);
            request.setAttribute("pmpendyearstatus", pmpendyearstatus);
            request.setAttribute("pmpasManager", pmpasManager);

            request.setAttribute("compentencyStartYearStatus", compentencyStartYearStatus);
            request.setAttribute("compentencyMidYearStatus", compentencyMidYearStatus);
            request.setAttribute("compentencyEndYearStatus", compentencyEndYearStatus);

        }

        int managerStatus = appraisalPerformanceMaster.getManagerStatus();
        request.setAttribute("managerStatus", managerStatus);

        int managerKraStatus = appraisalPerformanceMaster.getManagerkraStatus();
        request.setAttribute("managerKraStatus", managerKraStatus);
        int Finalstatus = appraisalPerformanceMaster.getManagerStatus();
        request.setAttribute("Finalstatus", Finalstatus);

        int empCompetencyStatus = appraisalPerformanceMaster.getEmployeeCompetencyStatus();
        request.setAttribute("empCompetencyStatus", empCompetencyStatus);

        int managerCompetencyStatus = appraisalPerformanceMaster.getManagerCompetencyStatus();
        request.setAttribute("managerCompetencyStatus", managerCompetencyStatus);

        int year = Calendar.getInstance().get(Calendar.YEAR);

        List<?> list = appraisalPerformanceService.readByAppraisalPerformanceId(employeeId, year);
        if (!list.isEmpty()) {
            appraisalPerformanceMaster = (AppraisalPerformanceMaster) list.get(0);
            int appraisalId = appraisalPerformanceMaster.getId();
        }

        // =======================competency Evaluation==========================================================//
        competencyList(request);
        int competencyId = 0;
        AppraisalPerformanceCompetencyEvaluation appraisalPerformanceCompetencyEvaluation = new AppraisalPerformanceCompetencyEvaluation();
        appraisalPerformanceCompetencyEvaluation.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
        CompetencyEvaluationTextmaster competencyEvaluationTextmaster = new CompetencyEvaluationTextmaster();
        List<?> competencyEvaluationList = appraisalPerformanceCompetencyEvaluationService.readAppraisalPerformanceCompetencyEvaluationDetail(appraisalPerformanceCompetencyEvaluation);

        request.setAttribute("competencyEvaluationList", competencyEvaluationList);

        mv.getModelMap().put("appraisalPerformanceMaster", appraisalPerformanceMaster);
//        mv.setViewName("Appraisal/PerformanceAppraisalForm");
        mv.setViewName("Appraisal/ManagerPMPCompetencyForm");
//        mv.setViewName("forward:userMaster.htm?act=userDashboard");
        return mv;
    }

    public ModelAndView editClickForIdpManager(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ////////////Manager
        ModelAndView mv = new ModelAndView();
        AppraisalPerformanceMaster appraisalPerformanceMaster = new AppraisalPerformanceMaster();
        UpdateAppraisalPerformanceKra updateAppraisalPerformanceKra = new UpdateAppraisalPerformanceKra();
        AppraisalPerformanceKra appraisalPerformanceKra = new AppraisalPerformanceKra();
        EmployeeMaster employee = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        String employeeName = "" + employee.getEmployeeName();
        String empId = request.getParameter("id");
        String userid = request.getParameter("userid");
        String appraisalId1 = request.getParameter("appraisalId");
        PmpFormStatusMaster pmpFormStatusMaster = new PmpFormStatusMaster();
        //////Print/////By dhaval
        request.setAttribute("empId", empId);
        request.setAttribute("userid", userid);
        request.setAttribute("appraisalId1", appraisalId1);

        request.setAttribute("empId", empId);
        request.setAttribute("userid", userid);
        request.setAttribute("appraisalId", appraisalId1);
        ///////////
//        selectedEmployeeDate(request, response, userid);
        int year = Integer.parseInt(request.getParameter("year"));
        managerDateStartToEnd(request, response);
        managerTimeLineDate(request, response, userid);
        kraCategoryList(request);
        String employeeId = "" + empId;//set the value in employee id
        appraisalPerformanceMaster = appraisalPerformanceService.readById(Integer.parseInt(appraisalId1));

        int managerStatus = appraisalPerformanceMaster.getManagerStatus();
        request.setAttribute("managerStatus", managerStatus);

        int managerKraStatus = appraisalPerformanceMaster.getManagerkraStatus();
        request.setAttribute("managerKraStatus", managerKraStatus);
        int Finalstatus = appraisalPerformanceMaster.getManagerStatus();
        request.setAttribute("Finalstatus", Finalstatus);

        int employeeIdpStatus = appraisalPerformanceMaster.getEmployeeIdpStatus();
        request.setAttribute("employeeIdpStatus", employeeIdpStatus);

        int managerIdpStatus = appraisalPerformanceMaster.getManagerIdpStatus();
        request.setAttribute("managerIdpStatus", managerIdpStatus);

        //int year = Calendar.getInstance().get(Calendar.YEAR);
        // Changes
        List<AppraisalFillingData> appraisalFilling = (List<AppraisalFillingData>) appraisalFillingDataService.readByCurrentYear("" + year);

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String today = sdf.format(cal.getTime());

        Date now = sdf.parse(today);
        if (!appraisalFilling.isEmpty()) {
            AppraisalFillingData appraisalFillingData = (AppraisalFillingData) appraisalFilling.get(0);

            //////////////////////Manager Time Line//////////////////////////////////////////
            String ManagerStartDate = appraisalFillingData.getManagerStartDate();
            String ManagerEndDate = appraisalFillingData.getManagerEndDate();
            String ManagerMidDate = appraisalFillingData.getManagerMidYearStartDate();
            String ManagerMidEndDate = appraisalFillingData.getManagerMidYearEndDate();
            String ManagerYearEndStartDate = appraisalFillingData.getManagerYearEndStartDate();
            String ManagerYearEndDate = appraisalFillingData.getManagerYearEndEndDate();

            Date managerstrDate = sdf.parse(ManagerStartDate);
            Date managerendDate = sdf.parse(ManagerEndDate);
            Date managermidDate = sdf.parse(ManagerMidDate);
            Date managermidEndDate = sdf.parse(ManagerMidEndDate);
            Date manageryearEndStartDate = sdf.parse(ManagerYearEndStartDate);
            Date manageryearEndDate = sdf.parse(ManagerYearEndDate);

            boolean flag = false;
            boolean flag1 = false;
            boolean flag2 = false;
            if ((now.after(managerstrDate) && now.before(managerendDate)) || now.equals(managerstrDate) || now.equals(managerendDate)) {
                flag = true;
            } else if ((now.after(managermidDate) && now.before(managermidEndDate)) || now.equals(managermidDate) || now.equals(managermidEndDate)) {
                flag1 = true;
            } else if ((now.after(manageryearEndStartDate) && now.before(manageryearEndDate)) || now.equals(manageryearEndStartDate) || now.equals(manageryearEndDate)) {
                flag2 = true;
            }

            request.setAttribute("flag", flag);
            request.setAttribute("flag1", flag1);
            request.setAttribute("flag2", flag2);
        }
        // Changes

        List<?> list = appraisalPerformanceService.readByAppraisalPerformanceId(employeeId, year);
        if (!list.isEmpty()) {
            appraisalPerformanceMaster = (AppraisalPerformanceMaster) list.get(0);
            int appraisalId = appraisalPerformanceMaster.getId();
        }

        //Individual Development Plan//
        AppraisalPerformanceIndividualDevelopmentPlan appraisalPerformanceIndividualDevelopmentPlan = new AppraisalPerformanceIndividualDevelopmentPlan();
        appraisalPerformanceIndividualDevelopmentPlan.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
        String text1 = "";
        List<?> individualDevelopmentPlanList = appraisalPerformanceIndividualDevelopmentPlanService.readIndividualDevelopmentPlanDetail(appraisalPerformanceIndividualDevelopmentPlan);
        if (!individualDevelopmentPlanList.isEmpty()) {
            appraisalPerformanceIndividualDevelopmentPlan = (AppraisalPerformanceIndividualDevelopmentPlan) individualDevelopmentPlanList.get(0);
            text1 = appraisalPerformanceIndividualDevelopmentPlan.getText1();
        }
        request.setAttribute("text1", individualDevelopmentPlanList);
        request.setAttribute("text2", individualDevelopmentPlanList);
        request.setAttribute("text3", individualDevelopmentPlanList);
        request.setAttribute("remark", individualDevelopmentPlanList);
        request.setAttribute("midYearRemark", individualDevelopmentPlanList);
        request.setAttribute("endYearRemark", individualDevelopmentPlanList);
        request.setAttribute("individualDevelopmentPlanList", individualDevelopmentPlanList);

        mv.getModelMap().put("appraisalPerformanceMaster", appraisalPerformanceMaster);
//        mv.setViewName("Appraisal/PerformanceAppraisalForm");
        mv.setViewName("Appraisal/ManagerPMPIdpFom");
//        mv.setViewName("forward:userMaster.htm?act=userDashboard");
        return mv;
    }

    public ModelAndView createSubmitCompetencyForManager(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AppraisalPerformanceMaster appraisalPerformanceMaster = new AppraisalPerformanceMaster();
        AppraisalPerformanceKra appraisalPerformanceKra = new AppraisalPerformanceKra();
        AppraisalPerformanceKra appraisalPerformanceKra1 = new AppraisalPerformanceKra();
        UpdateAppraisalPerformanceActivities updateAppraisalPerformanceActivities = new UpdateAppraisalPerformanceActivities();
        AppraisalPerformanceActivities appraisalPerformanceActivities = new AppraisalPerformanceActivities();
        AppraisalPerformanceActivities appraisalPerformanceActivities1 = new AppraisalPerformanceActivities();
        UpdateAppraisalPerformanceKra updateAppraisalPerformanceKra = new UpdateAppraisalPerformanceKra();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employee = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");//====edit by Admin=======//
        String appraisalId = request.getParameter("appraisalId");
        String userid = request.getParameter("userid");
        BindException errors = new BindException(appraisalPerformanceMaster, "appraisalPerformanceMaster");
        PmpFormStatusMaster pmpFormStatusMaster = new PmpFormStatusMaster();
        KraCategory kraCategory = new KraCategory();
//        selectedDateflage(request,response);
        appraisalPerformanceValidator.validate(appraisalPerformanceMaster, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv.addAllObjects(errors.getModel());
        } else {
            // String employeeId = "" + employee.getId();
            String employeeName = "" + employee.getEmployeeName();//====edit by Admin=======//

            String firsthalf = request.getParameter("flagId");
            String midhalf = request.getParameter("flagMidId");
            String endhalf = request.getParameter("flagEndId");

            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date now = new Date();
            String strDate = sdf1.format(now);
            String today = sdf.format(cal.getTime());
            String startdate = "" + today;

//            =========if appraisalPerformance is create and after get id=======//
            appraisalPerformanceMaster = appraisalPerformanceService.readById(Integer.parseInt(appraisalId));
            appraisalPerformanceKra.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
            String btn5 = request.getParameter("submit");

            ///////////////////Competency Evaluation (As Per Zydex Competency Framework)////////////////////////////
            AppraisalPerformanceCompetencyEvaluation appraisalPerformanceCompetencyEvaluation = new AppraisalPerformanceCompetencyEvaluation();
            CompetencyEvaluationTextmaster competencyEvaluationTextmaster = new CompetencyEvaluationTextmaster();
            CompetencyEvaluationMaster competencyEvaluationMaster = new CompetencyEvaluationMaster();
            int subCompentencyCount = Integer.parseInt(request.getParameter("subCompentencyCount"));
            boolean flag = true;
            for (int i = 1; i <= subCompentencyCount; i++) {
                String competencyEveId = request.getParameter("competencyEveId" + i);
                if (null != competencyEveId) {
                    appraisalPerformanceCompetencyEvaluation = appraisalPerformanceCompetencyEvaluationService.readById(Integer.parseInt(competencyEveId));
                }
                String compentencyStartYear = request.getParameter("compentencyStartYear" + i);
                String compentencyStartRemark = request.getParameter("compentencyStartRemark" + i);
                String compentencyMidYear = request.getParameter("compentencyMidYear" + i);
                String compentencyMidRemark = request.getParameter("compentencyMidRemark" + i);
                String compentencyEndYear = request.getParameter("compentencyEndYear" + i);
                String compentencyEndRemark = request.getParameter("compentencyEndRemark" + i);

                ///////////manager StartYearManager
                if (!"".equals(compentencyStartYear) && null != compentencyStartYear) {
                    appraisalPerformanceCompetencyEvaluation.setCompetencyStartYearManager(compentencyStartYear);
                } else {
                    appraisalPerformanceCompetencyEvaluation.setCompetencyStartYearManager(null);
                }
                if (!"".equals(compentencyStartRemark) && null != compentencyStartRemark) {
                    appraisalPerformanceCompetencyEvaluation.setStartyearRemarkManager(compentencyStartRemark);
                } else {
                    appraisalPerformanceCompetencyEvaluation.setStartyearRemarkManager(null);
                }
                if (!"".equals(compentencyMidYear) && null != compentencyMidYear) {
                    appraisalPerformanceCompetencyEvaluation.setCompetencyMidYearManager(compentencyMidYear);
                } else {
                    appraisalPerformanceCompetencyEvaluation.setCompetencyMidYearManager(null);
                }
                if (!"".equals(compentencyMidRemark) && null != compentencyMidRemark) {
                    appraisalPerformanceCompetencyEvaluation.setMidyearRemarkManager(compentencyMidRemark);
                } else {
                    appraisalPerformanceCompetencyEvaluation.setMidyearRemarkManager(null);
                }
                if (!"".equals(compentencyEndYear) && null != compentencyEndYear) {
                    appraisalPerformanceCompetencyEvaluation.setCompetencyEndYearManager(compentencyEndYear);
                } else {
                    appraisalPerformanceCompetencyEvaluation.setCompetencyEndYearManager(null);
                }
                if (!"".equals(compentencyEndRemark) && null != compentencyEndRemark) {
                    appraisalPerformanceCompetencyEvaluation.setEndyearRemarkManager(compentencyEndRemark);
                } else {
                    appraisalPerformanceCompetencyEvaluation.setCompetencyEndYearManager(null);
                }
                appraisalPerformanceCompetencyEvaluation.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
                int compentencyTextMasterId = Integer.parseInt(request.getParameter("compentencyTextMasterId" + i));
                competencyEvaluationTextmaster.setId(compentencyTextMasterId);
//                competencyEvaluationMaster.setId(competencyEvaluationId);
//                appraisalPerformanceCompetencyEvaluation.setCompetencyEvaluationMaster(competencyEvaluationMaster);
                appraisalPerformanceCompetencyEvaluation.setCompetencyEvaluationTextmaster(competencyEvaluationTextmaster);
                //String competencyEveId = request.getParameter("competencyEveId" + i);
                String btn2 = request.getParameter("save");

                if (null != btn2 && btn2.equals("save")) {
                    if (!"".equals(competencyEveId) && null != competencyEveId) {
                        int competencyEvaluationId = Integer.parseInt(request.getParameter("competencyEvaluationId" + i));
                        competencyEvaluationMaster.setId(competencyEvaluationId);
                        appraisalPerformanceCompetencyEvaluation.setCompetencyEvaluationMaster(competencyEvaluationMaster);
                        appraisalPerformanceCompetencyEvaluation.setId(Integer.parseInt(competencyEveId));
//                        appraisalPerformanceCompetencyEvaluation.setManagerStatus(1);
                        appraisalPerformanceCompetencyEvaluationService.update(appraisalPerformanceCompetencyEvaluation);

                    } else {

//                        if (!appraisalId.isEmpty()) {
//                            if (flag) {
//                                for (String id : appraisalId.split(",")) {
//                                    if (!id.equals("")) {
//                                        AppraisalPerformanceCompetencyEvaluation appraisalPerformanceCompetencyEvaluation2 = new AppraisalPerformanceCompetencyEvaluation();
//                                        appraisalPerformanceCompetencyEvaluation2.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
//                                        appraisalPerformanceCompetencyEvaluationService.deleteByManager(appraisalPerformanceCompetencyEvaluation2);
//                                        flag = false;
//                                    }
//                                }
//                            }
//                        }
                        String competencyEvaluationId = request.getParameter("competencyEvaluationId");
                        if (!"".equals(competencyEvaluationId) && null != competencyEvaluationId) {
                            int competencyEvaluation_Id = Integer.parseInt(competencyEvaluationId);
                            competencyEvaluationMaster.setId(competencyEvaluation_Id);
                            appraisalPerformanceCompetencyEvaluation.setCompetencyEvaluationMaster(competencyEvaluationMaster);
//                            appraisalPerformanceCompetencyEvaluation.setManagerStatus(1);
                            appraisalPerformanceCompetencyEvaluationService.create(appraisalPerformanceCompetencyEvaluation);
                        }
                    }
                } else {
                    if (!"".equals(compentencyStartYear) && null != compentencyStartYear) {
                        appraisalPerformanceCompetencyEvaluation.setCompetencyStartYear(compentencyStartYear);
                    } else {
                        appraisalPerformanceCompetencyEvaluation.setCompetencyStartYear(null);
                    }
                    if (!"".equals(compentencyStartRemark) && null != compentencyStartRemark) {
                        appraisalPerformanceCompetencyEvaluation.setStartyearRemark(compentencyStartRemark);
                    } else {
                        appraisalPerformanceCompetencyEvaluation.setStartyearRemark(null);
                    }
                    if (!"".equals(compentencyMidYear) && null != compentencyMidYear) {
                        appraisalPerformanceCompetencyEvaluation.setCompetencyMidYear(compentencyMidYear);
                    } else {
                        appraisalPerformanceCompetencyEvaluation.setCompetencyMidYear(null);
                    }
                    if (!"".equals(compentencyMidRemark) && null != compentencyMidRemark) {
                        appraisalPerformanceCompetencyEvaluation.setMidyearRemark(compentencyMidRemark);
                    } else {
                        appraisalPerformanceCompetencyEvaluation.setMidyearRemark(null);
                    }
                    if (!"".equals(compentencyEndYear) && null != compentencyEndYear) {
                        appraisalPerformanceCompetencyEvaluation.setCompetencyEndYear(compentencyEndYear);
                    } else {
                        appraisalPerformanceCompetencyEvaluation.setCompetencyEndYear(null);
                    }
                    if (!"".equals(compentencyEndRemark) && null != compentencyEndRemark) {
                        appraisalPerformanceCompetencyEvaluation.setEndyearRemark(compentencyEndRemark);
                    } else {
                        appraisalPerformanceCompetencyEvaluation.setCompetencyEndYear(null);
                    }

                    if (!"".equals(competencyEveId) && null != competencyEveId) {

//                        if (!appraisalId.isEmpty()) {
//                            if (flag) {
//                                for (String id : appraisalId.split(",")) {
//                                    if (!id.equals("")) {
//                                        AppraisalPerformanceCompetencyEvaluation appraisalPerformanceCompetencyEvaluation2 = new AppraisalPerformanceCompetencyEvaluation();
//                                        appraisalPerformanceCompetencyEvaluation2.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
//                                        appraisalPerformanceCompetencyEvaluationService.finaldeletebyManager(appraisalPerformanceCompetencyEvaluation2);
//                                        flag = false;
//                                    }
//                                }
//                            }
//                        }
                        int competencyEvaluationId = Integer.parseInt(request.getParameter("competencyEvaluationId" + i));
                        competencyEvaluationMaster.setId(competencyEvaluationId);
                        appraisalPerformanceCompetencyEvaluation.setCompetencyEvaluationMaster(competencyEvaluationMaster);
                        appraisalPerformanceCompetencyEvaluation.setId(Integer.parseInt(competencyEveId));
//                        appraisalPerformanceCompetencyEvaluation.setManagerStatus(1);
//                        appraisalPerformanceCompetencyEvaluation.setEmployeeStatus(1);
                        appraisalPerformanceCompetencyEvaluationService.update(appraisalPerformanceCompetencyEvaluation);

                    } else {
                        String competencyEvaluationId = request.getParameter("competencyEvaluationId");
                        if (!"".equals(competencyEvaluationId) && null != competencyEvaluationId) {
                            int competencyEvaluation_Id = Integer.parseInt(competencyEvaluationId);
                            competencyEvaluationMaster.setId(competencyEvaluation_Id);
//                            appraisalPerformanceCompetencyEvaluation.setManagerStatus(1);
                            appraisalPerformanceCompetencyEvaluation.setCompetencyEvaluationMaster(competencyEvaluationMaster);
//                            appraisalPerformanceCompetencyEvaluation.setEmployeeStatus(1);
                            appraisalPerformanceCompetencyEvaluationService.create(appraisalPerformanceCompetencyEvaluation);
                        }
                    }
//                    boolean pmpFormStatusStart = false;
//                    boolean pmpFormStatusMid = false;
//                    boolean pmpFormStatusEnd = false;

                    boolean compentencyStartYearStatus = false;
                    boolean compentencyMidYearStatus = false;
                    boolean compentencyEndYearStatus = false;

                    for (int d = 1; d <= subCompentencyCount; d++) {

                        ///////////////////PMP Status Master Start////////////////////////////
                        if ((!"".equals(compentencyStartYear) && null != compentencyStartYear) || (!"".equals(compentencyStartRemark) && null != compentencyStartRemark)) {

                            compentencyStartYearStatus = true;
                        }
                        if ((!"".equals(compentencyMidYear) && null != compentencyMidYear) || (!"".equals(compentencyMidRemark) && null != compentencyMidRemark)) {

                            compentencyMidYearStatus = true;
                        }
                        if ((!"".equals(compentencyEndYear) && null != compentencyEndYear) || (!"".equals(compentencyEndRemark) && null != compentencyEndRemark)) {

                            compentencyEndYearStatus = true;
                        }

                    }

                    String pmpstatusId = "";
//                    List<?> pmplist = pmpFormStatusMasterService.readByPmpformstatusStatus(userid);
                    List<?> pmplist = pmpFormStatusMasterService.readByPmpformstatusStatus("" + appraisalPerformanceMaster.getEmployeeMaster().getId());
                    if (!pmplist.isEmpty()) {
                        pmpFormStatusMaster = (PmpFormStatusMaster) pmplist.get(0);
                        pmpstatusId = "" + pmpFormStatusMaster.getId();
                    }
                    appraisalPerformanceMaster.setEmployeeCompetencyStatus(0);
                    appraisalPerformanceMaster.setManagerCompetencyStatus(1);
                    if (compentencyStartYearStatus == true) {
                        pmpFormStatusMaster.setCompentencyStartYearStatus(Boolean.TRUE);
                    }
                    if (compentencyMidYearStatus == true) {
                        pmpFormStatusMaster.setCompentencyMidYearStatus(Boolean.TRUE);
                    }
                    if (compentencyEndYearStatus == true) {
                        pmpFormStatusMaster.setCompentencyEndYearStatus(Boolean.TRUE);
                    }

//                    pmpFormStatusMaster.setEmployeeSide(Boolean.TRUE);
//                    pmpFormStatusMaster.setManagerSide(Boolean.TRUE);
                    pmpFormStatusMaster.setCompentencyEmployeeSide(Boolean.TRUE);
                    pmpFormStatusMaster.setCompentencyManagerSide(Boolean.TRUE);
                    pmpFormStatusMasterService.update(pmpFormStatusMaster);

                    ///////////////////PMP Status Master End//////////////////////////////
                }
            }

//            appraisalPerformanceService.update(appraisalPerformanceMaster);
            String pmpstatusId = "";
            String btn1 = request.getParameter("submit");
            if (null != btn1 && btn1.equals("submit")) {
//                List<?> pmplist = pmpFormStatusMasterService.readByPmpformstatusStatus(userid);
//                List<?> pmplist = pmpFormStatusMasterService.readByPmpformstatusStatus("" + appraisalPerformanceMaster.getEmployeeMaster().getId());
//                if (!pmplist.isEmpty()) {
//                    pmpFormStatusMaster = (PmpFormStatusMaster) pmplist.get(0);
//                    pmpstatusId = "" + pmpFormStatusMaster.getId();
//
//                }

//                appraisalPerformanceMaster.setManagerStatus(1);
//                appraisalPerformanceMaster.setEmployeeStatus(0);
//                appraisalPerformanceMaster.setManagerkraStatus(1);
//                appraisalPerformanceMaster.setEmployeeCompetencyStatus(0);
//                appraisalPerformanceMaster.setManagerCompetencyStatus(1);
//                pmpFormStatusMaster.setEmployeeSide(Boolean.TRUE);
//                pmpFormStatusMaster.setManagerSide(Boolean.TRUE);
//                pmpFormStatusMasterService.update(pmpFormStatusMaster);
                appraisalPerformanceService.update(appraisalPerformanceMaster);
                if (!"".equals(appraisalId) && null != appraisalId) {
                    //    Email Sent to Employee(Start Year)
                    if (!"".equals(firsthalf) && null != firsthalf) {
                        if (firsthalf.equals("true")) {
                            try {
                                EmailTemplate emailTemplate = new EmailTemplate();
                                EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                                DesignationMaster designationMaster = new DesignationMaster();
                                designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                                List l1 = appraisalPerformanceService.readEmpIdFromTabId(Integer.parseInt(appraisalId));
                                EmployeeMaster employeeRequestee = (EmployeeMaster) l1.get(0);
                                // id 116 is for status Appraisal Approved (Start Year)
                                emailTemplate = emailTemplateService.readById(116);
                                String To = employeeRequestee.getOfficeEmailId();
                                String from = employeeMasterModel.getOfficeEmailId();
                                String Subject = emailTemplate.getSubject();
                                Subject = Subject.replaceAll("\\{user\\}", employeeRequestee.getEmployeeName());
                                String msg = emailTemplate.getBodytext();
                                msg = msg.replaceAll("\\{to_user\\}", employeeRequestee.getEmployeeName());
                                msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                                msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                                sendMail.sendMail(from, To, Subject, msg);

                                String name = "PMP";
                                EmailAddMaster emailAddMaster = new EmailAddMaster();
                                emailAddMaster.setModuleName(name);
                                emailAddMaster.setDepartmentMaster(employeeRequestee.getDepartmentMaster());
                                List<?> emailSendList = emailAddMasterService.readByName(emailAddMaster);
                                if (!emailSendList.isEmpty()) {
                                    EmailAddMaster emailAddMaster1 = (EmailAddMaster) emailSendList.get(0);
                                    String emailId = emailAddMaster1.getEmailId();
                                    for (String emailId1 : emailId.split(",")) {
                                        if (!emailId1.equals("")) {
                                            String To1 = emailId1;
                                            String from1 = employeeMasterModel.getOfficeEmailId();
                                            String subject1 = emailTemplate.getSubject();
                                            subject1 = subject1.replaceAll("\\{user\\}", employeeRequestee.getEmployeeName());
                                            String msg1 = emailTemplate.getBodytext();
                                            msg1 = msg1.replaceAll("\\{to_user\\}", employeeRequestee.getEmployeeName());
                                            msg1 = msg1.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                                            msg1 = msg1.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                                            sendMail.sendMail(from1, To1, subject1, msg1);

                                        }
                                    }
                                }
                            } catch (Exception e) {

                            }
                        }
                    }
                    //    Email Sent to Employee(Mid Year)
                    if (!"".equals(midhalf) && null != midhalf) {
                        if (midhalf.equals("true")) {
                            try {
                                EmailTemplate emailTemplate = new EmailTemplate();
                                EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                                DesignationMaster designationMaster = new DesignationMaster();
                                designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                                List l1 = appraisalPerformanceService.readEmpIdFromTabId(Integer.parseInt(appraisalId));
                                EmployeeMaster employeeRequestee = (EmployeeMaster) l1.get(0);
                                // id 117 is for status Appraisal Approved (Mid Year)
                                emailTemplate = emailTemplateService.readById(117);
                                String To = employeeRequestee.getOfficeEmailId();
                                String from = employeeMasterModel.getOfficeEmailId();
                                String Subject = emailTemplate.getSubject();
                                Subject = Subject.replaceAll("\\{user\\}", employeeRequestee.getEmployeeName());
                                String msg = emailTemplate.getBodytext();
                                msg = msg.replaceAll("\\{to_user\\}", employeeRequestee.getEmployeeName());
                                msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                                msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                                sendMail.sendMail(from, To, Subject, msg);

                                String name = "PMP";
                                EmailAddMaster emailAddMaster = new EmailAddMaster();
                                emailAddMaster.setModuleName(name);
                                emailAddMaster.setDepartmentMaster(employeeRequestee.getDepartmentMaster());
                                List<?> emailSendList = emailAddMasterService.readByName(emailAddMaster);
                                if (!emailSendList.isEmpty()) {
                                    EmailAddMaster emailAddMaster1 = (EmailAddMaster) emailSendList.get(0);
                                    String emailId = emailAddMaster1.getEmailId();
                                    for (String emailId1 : emailId.split(",")) {
                                        if (!emailId1.equals("")) {
                                            String To1 = emailId1;
                                            String from1 = employeeMasterModel.getOfficeEmailId();
                                            String subject1 = emailTemplate.getSubject();
                                            subject1 = subject1.replaceAll("\\{user\\}", employeeRequestee.getEmployeeName());
                                            String msg1 = emailTemplate.getBodytext();
                                            msg1 = msg1.replaceAll("\\{to_user\\}", employeeRequestee.getEmployeeName());
                                            msg1 = msg1.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                                            msg1 = msg1.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                                            sendMail.sendMail(from1, To1, subject1, msg1);

                                        }
                                    }
                                }
                            } catch (Exception e) {
                            }
                        }
                    }
                    //    Email Sent to Employee(Year End)
                    if (!"".equals(endhalf) && null != endhalf) {
                        if (endhalf.equals("true")) {
                            try {
                                EmailTemplate emailTemplate = new EmailTemplate();
                                EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                                DesignationMaster designationMaster = new DesignationMaster();
                                designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                                List l1 = appraisalPerformanceService.readEmpIdFromTabId(Integer.parseInt(appraisalId));
                                EmployeeMaster employeeRequestee = (EmployeeMaster) l1.get(0);
                                // id 118 is for status Appraisal Approved (Year End)
                                emailTemplate = emailTemplateService.readById(118);
                                String To = employeeRequestee.getOfficeEmailId();
                                String from = employeeMasterModel.getOfficeEmailId();
                                String Subject = emailTemplate.getSubject();
                                Subject = Subject.replaceAll("\\{user\\}", employeeRequestee.getEmployeeName());
                                String msg = emailTemplate.getBodytext();
                                msg = msg.replaceAll("\\{to_user\\}", employeeRequestee.getEmployeeName());
                                msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                                msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                                sendMail.sendMail(from, To, Subject, msg);

                                String name = "PMP";
                                EmailAddMaster emailAddMaster = new EmailAddMaster();
                                emailAddMaster.setModuleName(name);
                                emailAddMaster.setDepartmentMaster(employeeRequestee.getDepartmentMaster());
                                List<?> emailSendList = emailAddMasterService.readByName(emailAddMaster);
                                if (!emailSendList.isEmpty()) {
                                    EmailAddMaster emailAddMaster1 = (EmailAddMaster) emailSendList.get(0);
                                    String emailId = emailAddMaster1.getEmailId();
                                    for (String emailId1 : emailId.split(",")) {
                                        if (!emailId1.equals("")) {
                                            String To1 = emailId1;
                                            String from1 = employeeMasterModel.getOfficeEmailId();
                                            String subject1 = emailTemplate.getSubject();
                                            subject1 = subject1.replaceAll("\\{user\\}", employeeRequestee.getEmployeeName());
                                            String msg1 = emailTemplate.getBodytext();
                                            msg1 = msg1.replaceAll("\\{to_user\\}", employeeRequestee.getEmployeeName());
                                            msg1 = msg1.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                                            msg1 = msg1.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                                            sendMail.sendMail(from1, To1, subject1, msg1);

                                        }
                                    }
                                }
                            } catch (Exception e) {
                            }
                        }
                    }
                }
            } else {

                appraisalPerformanceService.update(appraisalPerformanceMaster);
            }
        }
        mv.getModelMap().put("appraisalPerformanceMaster", appraisalPerformanceMaster);
//        mv.setViewName("Appraisal/ManagerPerformanceAppraisalForm");
        mv.setViewName("redirect:appraisalPerformance.htm?act=searchClick");
//        mv.setViewName("redirect:appraisalPerformance.htm?act=searchSubmit");
//        mv = searchSubmit(request, response);
//        mv.setViewName("forward:userMaster.htm?act=userDashboard");
        return mv;
    }

    public ModelAndView createSubmitIdpManagerForManager(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AppraisalPerformanceMaster appraisalPerformanceMaster = new AppraisalPerformanceMaster();
        AppraisalPerformanceKra appraisalPerformanceKra = new AppraisalPerformanceKra();
        AppraisalPerformanceKra appraisalPerformanceKra1 = new AppraisalPerformanceKra();
        UpdateAppraisalPerformanceActivities updateAppraisalPerformanceActivities = new UpdateAppraisalPerformanceActivities();
        AppraisalPerformanceActivities appraisalPerformanceActivities = new AppraisalPerformanceActivities();
        AppraisalPerformanceActivities appraisalPerformanceActivities1 = new AppraisalPerformanceActivities();
        UpdateAppraisalPerformanceKra updateAppraisalPerformanceKra = new UpdateAppraisalPerformanceKra();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employee = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");//====edit by Admin=======//
        String appraisalId = request.getParameter("appraisalId");
        BindException errors = new BindException(appraisalPerformanceMaster, "appraisalPerformanceMaster");
        PmpFormStatusMaster pmpFormStatusMaster = new PmpFormStatusMaster();
        KraCategory kraCategory = new KraCategory();
//        selectedDateflage(request,response);
        appraisalPerformanceValidator.validate(appraisalPerformanceMaster, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv.addAllObjects(errors.getModel());
        } else {
            // String employeeId = "" + employee.getId();
            String employeeName = "" + employee.getEmployeeName();//====edit by Admin=======//
            // List<?> list = appraisalPerformanceService.readByAppraisalPerformanceId(employeeId);
            // if (!list.isEmpty()) {

            String firsthalf = request.getParameter("flagId");
            String midhalf = request.getParameter("flagMidId");
            String endhalf = request.getParameter("flagEndId");

//            String btn = request.getParameter("submit");
//            if (null != btn && btn.equals("submit")) {
//                appraisalPerformanceMaster.setStatus(1);
//                appraisalPerformanceService.update(appraisalPerformanceMaster);
//            } else {
//                appraisalPerformanceMaster.setStatus(0);
//                appraisalPerformanceService.update(appraisalPerformanceMaster);
//            }
            //appraisalPerformanceMaster = (AppraisalPerformanceMaster) list.get(0);
            //String appraisalId = "" + appraisalPerformanceMaster.getId();
            //appraisalPerformanceMaster.setId(Integer.parseInt(appraisalId));
            //appraisalPerformanceKra.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
            //}
            // if (null == appraisalPerformanceMaster.getId()) {
            //  appraisalPerformanceMaster.setEmployeeMaster(employee);
            //  appraisalPerformanceService.create(appraisalPerformanceMaster);
            //  }
            //StartDate To create FirstTime//
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date now = new Date();
            String strDate = sdf1.format(now);
            String today = sdf.format(cal.getTime());
            String startdate = "" + today;

//            =========if appraisalPerformance is create and after get id=======//
            appraisalPerformanceMaster = appraisalPerformanceService.readById(Integer.parseInt(appraisalId));
//            appraisalPerformanceKra.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
            String btn5 = request.getParameter("submit");
            if (null != btn5 && btn5.equals("submit")) {

            } else {

            }

            String kraremovedIndividualIdVal = request.getParameter("kraremovedIndividualIdVal");
            if (!kraremovedIndividualIdVal.isEmpty()) {
                for (String id : kraremovedIndividualIdVal.split(",")) {
                    if (!id.equals("")) {
                        AppraisalPerformanceIndividualDevelopmentPlan appraisalPerformanceIndividualDevelopmentPlan2 = new AppraisalPerformanceIndividualDevelopmentPlan();
                        appraisalPerformanceIndividualDevelopmentPlan2.setId(Integer.parseInt(id));
                        appraisalPerformanceIndividualDevelopmentPlanService.delete1(appraisalPerformanceIndividualDevelopmentPlan2);
                    }
                }
            }
            ///////////////////////////Individual Development Plan//////////////////////////////////
            AppraisalPerformanceIndividualDevelopmentPlan appraisalPerformanceIndividualDevelopmentPlan = new AppraisalPerformanceIndividualDevelopmentPlan();
            int individualcount = Integer.parseInt(request.getParameter("IndividualId"));
            for (int i = 1; i <= individualcount; i++) {

                String text1 = request.getParameter("text" + i);
                String text2 = request.getParameter("individualtextDiv" + i);
                String text3 = request.getParameter("trainingSelectId" + i);
                String remark = request.getParameter("trainingSelectTextinput" + i);
                String midYearRemark = request.getParameter("midYearRemark" + i);
                String endYearRemark = request.getParameter("endYearRemark" + i);
                String managerMidYearRemark = request.getParameter("managerMidYearRemark" + i);
                String managerEndYearRemark = request.getParameter("managerEndYearRemark" + i);
                String individualplan = request.getParameter("IndividualDevelopmentPlanId" + i);
                if (null != individualplan) {
                    appraisalPerformanceIndividualDevelopmentPlan = appraisalPerformanceIndividualDevelopmentPlanService.readById(Integer.parseInt(individualplan));
                }
//                if (!"".equals(text1) && null != text1) {
//                    appraisalPerformanceIndividualDevelopmentPlan.setText1(text1);
//                } else {
//                    appraisalPerformanceIndividualDevelopmentPlan.setText1(null);
//                }

//                if (!"".equals(text2) && null != text2) {
//                    appraisalPerformanceIndividualDevelopmentPlan.setText2(text2);
//                } else {
//                    appraisalPerformanceIndividualDevelopmentPlan.setText2(null);
//                }
                if (!"".equals(text1) && null != text1) {
                    appraisalPerformanceIndividualDevelopmentPlan.setManagertext1(text1);
                } else {
                    appraisalPerformanceIndividualDevelopmentPlan.setManagertext1(null);
                }
                if (!"".equals(text2) && null != text2) {
                    appraisalPerformanceIndividualDevelopmentPlan.setManagertext2(text2);
                } else {
                    appraisalPerformanceIndividualDevelopmentPlan.setManagertext2(null);
                }
                if (!"".equals(text3) && null != text3) {
                    appraisalPerformanceIndividualDevelopmentPlan.setText3(text3);
                } else {
                    appraisalPerformanceIndividualDevelopmentPlan.setText3(null);
                }
                if (!"".equals(text3) && null != text3) {
                    appraisalPerformanceIndividualDevelopmentPlan.setManagertext3(text3);
                } else {
                    appraisalPerformanceIndividualDevelopmentPlan.setManagertext3(null);
                }
                if (!"".equals(managerMidYearRemark) && null != managerMidYearRemark) {
                    appraisalPerformanceIndividualDevelopmentPlan.setManagerMidYearRemark(managerMidYearRemark);
                } else {
                    appraisalPerformanceIndividualDevelopmentPlan.setManagerEndYearRemark(null);
                }
//                Endyear
                if (null != endYearRemark && !"".equals(endYearRemark)) {
                    appraisalPerformanceIndividualDevelopmentPlan.setEndYearRemark(endYearRemark);
                } else {
                    appraisalPerformanceIndividualDevelopmentPlan.setEndYearRemark(null);
                }
                if (!"".equals(managerEndYearRemark) && null != managerEndYearRemark) {
                    appraisalPerformanceIndividualDevelopmentPlan.setManagerEndYearRemark(managerEndYearRemark);
                } else {
                    appraisalPerformanceIndividualDevelopmentPlan.setManagerEndYearRemark(null);
                }

                String btn = request.getParameter("save");
                if (null != btn && btn.equals("save")) {

                    if (individualplan != null) {
                        appraisalPerformanceIndividualDevelopmentPlan.setId(Integer.parseInt(individualplan));
                        appraisalPerformanceIndividualDevelopmentPlanService.update(appraisalPerformanceIndividualDevelopmentPlan);
                    } else {
                        appraisalPerformanceIndividualDevelopmentPlanService.create(appraisalPerformanceIndividualDevelopmentPlan);
                    }
                    request.setAttribute("successMessage",
                            "Information : The Information is Saved Successfully.");
                } else {

                    if (null != text1 && !"".equals(text1)) {
                        appraisalPerformanceIndividualDevelopmentPlan.setText1(text1);
                    } else {
                        appraisalPerformanceIndividualDevelopmentPlan.setText1(null);
                    }
                    if (null != text2 && !"".equals(text2)) {
                        appraisalPerformanceIndividualDevelopmentPlan.setText2(text2);
                    } else {
                        appraisalPerformanceIndividualDevelopmentPlan.setText2(null);
                    }
                    if (null != text3 && !"".equals(text3)) {
                        appraisalPerformanceIndividualDevelopmentPlan.setText3(text3);
                    } else {
                        appraisalPerformanceIndividualDevelopmentPlan.setText3(null);
                    }
                    if (null != midYearRemark && !"".equals(midYearRemark)) {
                        appraisalPerformanceIndividualDevelopmentPlan.setMidYearRemark(midYearRemark);
                    } else {
                        appraisalPerformanceIndividualDevelopmentPlan.setMidYearRemark(null);
                    }

                    if (null != remark && !"".equals(remark)) {
                        appraisalPerformanceIndividualDevelopmentPlan.setRemark(remark);
                    } else {
                        appraisalPerformanceIndividualDevelopmentPlan.setRemark(null);
                    }
                    if (null != endYearRemark && !"".equals(endYearRemark)) {
                        appraisalPerformanceIndividualDevelopmentPlan.setEndYearRemark(endYearRemark);
                    } else {
                        appraisalPerformanceIndividualDevelopmentPlan.setEndYearRemark(null);
                    }

                    if (null != endYearRemark && !"".equals(endYearRemark)) {
                        appraisalPerformanceIndividualDevelopmentPlan.setManagerEndYearRemarkEmployee(endYearRemark);
                    } else {
                        appraisalPerformanceIndividualDevelopmentPlan.setManagerEndYearRemarkEmployee(null);
                    }

                    if (null != managerMidYearRemark && !"".equals(managerMidYearRemark)) {
                        appraisalPerformanceIndividualDevelopmentPlan.setManagerMidYearRemark(managerMidYearRemark);
                    } else {
                        appraisalPerformanceIndividualDevelopmentPlan.setManagerMidYearRemark(null);
                    }
                    if (null != managerMidYearRemark && !"".equals(managerMidYearRemark)) {
                        appraisalPerformanceIndividualDevelopmentPlan.setManagerMidYearRemarkEmployee(managerMidYearRemark);
                    } else {
                        appraisalPerformanceIndividualDevelopmentPlan.setManagerMidYearRemarkEmployee(null);
                    }

                    if (null != managerEndYearRemark && !"".equals(managerEndYearRemark)) {
                        appraisalPerformanceIndividualDevelopmentPlan.setManagerEndYearRemark(managerEndYearRemark);
                    } else {
                        appraisalPerformanceIndividualDevelopmentPlan.setManagerEndYearRemark(null);
                    }

                    if (null != managerEndYearRemark && !"".equals(managerEndYearRemark)) {
                        appraisalPerformanceIndividualDevelopmentPlan.setManagerEndYearRemarkManager(managerEndYearRemark);
                    } else {
                        appraisalPerformanceIndividualDevelopmentPlan.setManagerEndYearRemarkManager(null);
                    }
//                    if (null != managerEndYearRemark && !"".equals(managerEndYearRemark)) {
//                        appraisalPerformanceIndividualDevelopmentPlan.setManagerEndYearRemarkEmployee(managerEndYearRemark);
//                    } else {
//                        appraisalPerformanceIndividualDevelopmentPlan.setManagerEndYearRemarkEmployee(null);
//                    }

                    //////////////////////////////////////
                    if (individualplan != null) {
                        appraisalPerformanceIndividualDevelopmentPlan.setId(Integer.parseInt(individualplan));
                        appraisalPerformanceIndividualDevelopmentPlan.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
                        appraisalPerformanceIndividualDevelopmentPlanService.update(appraisalPerformanceIndividualDevelopmentPlan);
                    } else {
                        appraisalPerformanceIndividualDevelopmentPlanService.create(appraisalPerformanceIndividualDevelopmentPlan);
                    }
                    request.setAttribute("successMessage",
                            "Information : The Information is Approved Successfully.");
                }
            }

            ////////////////////closed Indivisual plan////////
//            String pmpstatusId = "";
            String btn1 = request.getParameter("submit");
            if (null != btn1 && btn1.equals("submit")) {

//                appraisalPerformanceMaster.setManagerStatus(1);//manager status Kra Approvement
//                appraisalPerformanceMaster.setEmployeeStatus(0);
//                appraisalPerformanceMaster.setManagerkraStatus(1);
                appraisalPerformanceMaster.setEmployeeIdpStatus(0);
                appraisalPerformanceMaster.setManagerIdpStatus(1);

                appraisalPerformanceService.update(appraisalPerformanceMaster);
                if (!"".equals(appraisalId) && null != appraisalId) {
                    //    Email Sent to Employee(Start Year)
                    if (!"".equals(firsthalf) && null != firsthalf) {
                        if (firsthalf.equals("true")) {
                            try {
                                EmailTemplate emailTemplate = new EmailTemplate();
                                EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                                DesignationMaster designationMaster = new DesignationMaster();
                                designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                                List l1 = appraisalPerformanceService.readEmpIdFromTabId(Integer.parseInt(appraisalId));
                                EmployeeMaster employeeRequestee = (EmployeeMaster) l1.get(0);
                                // id 116 is for status Appraisal Approved (Start Year)
                                emailTemplate = emailTemplateService.readById(116);
                                String To = employeeRequestee.getOfficeEmailId();
                                String from = employeeMasterModel.getOfficeEmailId();
                                String Subject = emailTemplate.getSubject();
                                Subject = Subject.replaceAll("\\{user\\}", employeeRequestee.getEmployeeName());
                                String msg = emailTemplate.getBodytext();
                                msg = msg.replaceAll("\\{to_user\\}", employeeRequestee.getEmployeeName());
                                msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                                msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                                sendMail.sendMail(from, To, Subject, msg);

                                String name = "PMP";
                                EmailAddMaster emailAddMaster = new EmailAddMaster();
                                emailAddMaster.setModuleName(name);
                                emailAddMaster.setDepartmentMaster(employeeRequestee.getDepartmentMaster());
                                List<?> emailSendList = emailAddMasterService.readByName(emailAddMaster);
                                if (!emailSendList.isEmpty()) {
                                    EmailAddMaster emailAddMaster1 = (EmailAddMaster) emailSendList.get(0);
                                    String emailId = emailAddMaster1.getEmailId();
                                    for (String emailId1 : emailId.split(",")) {
                                        if (!emailId1.equals("")) {
                                            String To1 = emailId1;
                                            String from1 = employeeMasterModel.getOfficeEmailId();
                                            String subject1 = emailTemplate.getSubject();
                                            subject1 = subject1.replaceAll("\\{user\\}", employeeRequestee.getEmployeeName());
                                            String msg1 = emailTemplate.getBodytext();
                                            msg1 = msg1.replaceAll("\\{to_user\\}", employeeRequestee.getEmployeeName());
                                            msg1 = msg1.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                                            msg1 = msg1.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                                            sendMail.sendMail(from1, To1, subject1, msg1);

                                        }
                                    }
                                }
                            } catch (Exception e) {

                            }
                        }
                    }
                    //    Email Sent to Employee(Mid Year)
                    if (!"".equals(midhalf) && null != midhalf) {
                        if (midhalf.equals("true")) {
                            try {
                                EmailTemplate emailTemplate = new EmailTemplate();
                                EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                                DesignationMaster designationMaster = new DesignationMaster();
                                designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                                List l1 = appraisalPerformanceService.readEmpIdFromTabId(Integer.parseInt(appraisalId));
                                EmployeeMaster employeeRequestee = (EmployeeMaster) l1.get(0);
                                // id 117 is for status Appraisal Approved (Mid Year)
                                emailTemplate = emailTemplateService.readById(117);
                                String To = employeeRequestee.getOfficeEmailId();
                                String from = employeeMasterModel.getOfficeEmailId();
                                String Subject = emailTemplate.getSubject();
                                Subject = Subject.replaceAll("\\{user\\}", employeeRequestee.getEmployeeName());
                                String msg = emailTemplate.getBodytext();
                                msg = msg.replaceAll("\\{to_user\\}", employeeRequestee.getEmployeeName());
                                msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                                msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                                sendMail.sendMail(from, To, Subject, msg);

                                String name = "PMP";
                                EmailAddMaster emailAddMaster = new EmailAddMaster();
                                emailAddMaster.setModuleName(name);
                                emailAddMaster.setDepartmentMaster(employeeRequestee.getDepartmentMaster());
                                List<?> emailSendList = emailAddMasterService.readByName(emailAddMaster);
                                if (!emailSendList.isEmpty()) {
                                    EmailAddMaster emailAddMaster1 = (EmailAddMaster) emailSendList.get(0);
                                    String emailId = emailAddMaster1.getEmailId();
                                    for (String emailId1 : emailId.split(",")) {
                                        if (!emailId1.equals("")) {
                                            String To1 = emailId1;
                                            String from1 = employeeMasterModel.getOfficeEmailId();
                                            String subject1 = emailTemplate.getSubject();
                                            subject1 = subject1.replaceAll("\\{user\\}", employeeRequestee.getEmployeeName());
                                            String msg1 = emailTemplate.getBodytext();
                                            msg1 = msg1.replaceAll("\\{to_user\\}", employeeRequestee.getEmployeeName());
                                            msg1 = msg1.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                                            msg1 = msg1.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                                            sendMail.sendMail(from1, To1, subject1, msg1);

                                        }
                                    }
                                }
                            } catch (Exception e) {
                            }
                        }
                    }
                    //    Email Sent to Employee(Year End)
                    if (!"".equals(endhalf) && null != endhalf) {
                        if (endhalf.equals("true")) {
                            try {
                                EmailTemplate emailTemplate = new EmailTemplate();
                                EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                                DesignationMaster designationMaster = new DesignationMaster();
                                designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                                List l1 = appraisalPerformanceService.readEmpIdFromTabId(Integer.parseInt(appraisalId));
                                EmployeeMaster employeeRequestee = (EmployeeMaster) l1.get(0);
                                // id 118 is for status Appraisal Approved (Year End)
                                emailTemplate = emailTemplateService.readById(118);
                                String To = employeeRequestee.getOfficeEmailId();
                                String from = employeeMasterModel.getOfficeEmailId();
                                String Subject = emailTemplate.getSubject();
                                Subject = Subject.replaceAll("\\{user\\}", employeeRequestee.getEmployeeName());
                                String msg = emailTemplate.getBodytext();
                                msg = msg.replaceAll("\\{to_user\\}", employeeRequestee.getEmployeeName());
                                msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                                msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                                sendMail.sendMail(from, To, Subject, msg);

                                String name = "PMP";
                                EmailAddMaster emailAddMaster = new EmailAddMaster();
                                emailAddMaster.setModuleName(name);
                                emailAddMaster.setDepartmentMaster(employeeRequestee.getDepartmentMaster());
                                List<?> emailSendList = emailAddMasterService.readByName(emailAddMaster);
                                if (!emailSendList.isEmpty()) {
                                    EmailAddMaster emailAddMaster1 = (EmailAddMaster) emailSendList.get(0);
                                    String emailId = emailAddMaster1.getEmailId();
                                    for (String emailId1 : emailId.split(",")) {
                                        if (!emailId1.equals("")) {
                                            String To1 = emailId1;
                                            String from1 = employeeMasterModel.getOfficeEmailId();
                                            String subject1 = emailTemplate.getSubject();
                                            subject1 = subject1.replaceAll("\\{user\\}", employeeRequestee.getEmployeeName());
                                            String msg1 = emailTemplate.getBodytext();
                                            msg1 = msg1.replaceAll("\\{to_user\\}", employeeRequestee.getEmployeeName());
                                            msg1 = msg1.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                                            msg1 = msg1.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                                            sendMail.sendMail(from1, To1, subject1, msg1);

                                        }
                                    }
                                }
                            } catch (Exception e) {
                            }
                        }
                    }
                }
            } else {
                //appraisalPerformanceMaster.setManagerStatus(0);
                appraisalPerformanceService.update(appraisalPerformanceMaster);
            }
        }
        mv.getModelMap().put("appraisalPerformanceMaster", appraisalPerformanceMaster);
//        mv.setViewName("Appraisal/ManagerPerformanceAppraisalForm");
//        mv.setViewName("redirect:appraisalPerformance.htm?act=searchSubmit");
        mv.setViewName("redirect:appraisalPerformance.htm?act=searchClick");
//        mv = searchSubmit(request, response);
//        mv.setViewName("forward:userMaster.htm?act=userDashboard");
        return mv;
    }

    public ModelAndView reworkByManagerForCompetency(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String pmpIdForRework = request.getParameter("pmpIdForRework");
        String reworkComment = request.getParameter("reworkComment");
        AppraisalPerformanceMaster appraisalPerformanceMaster = new AppraisalPerformanceMaster();
//        AppraisalPerformanceCompetencyEvaluation appraisalPerformanceCompetencyEvaluation = new AppraisalPerformanceCompetencyEvaluation();
        appraisalPerformanceMaster = appraisalPerformanceService.readById(Integer.parseInt(pmpIdForRework));

        appraisalPerformanceMaster.setCompetencyReworkComment(reworkComment);
//        appraisalPerformanceMaster.setManagerkraStatus(1);
//        appraisalPerformanceMaster.setEmployeeStatus(0);
//        appraisalPerformanceMaster.setReworkStatus(1);

        appraisalPerformanceMaster.setEmployeeCompetencyStatus(0);
        appraisalPerformanceMaster.setManagerCompetencyStatus(1);
        appraisalPerformanceMaster.setCompetencyReworkStatus(1);
        appraisalPerformanceMaster.setCompetencyReworkComment(reworkComment);

        appraisalPerformanceService.update(appraisalPerformanceMaster);
//
        try {
            EmailTemplate emailTemplate = new EmailTemplate();
            EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
            DesignationMaster designationMaster = new DesignationMaster();
            designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
            List l1 = appraisalPerformanceService.readEmpIdFromTabId(Integer.parseInt(pmpIdForRework));
            EmployeeMaster employeeRequestee = (EmployeeMaster) l1.get(0);
            // id 116 is for status Appraisal Approved (Start Year)
            emailTemplate = emailTemplateService.readById(134);
            String To = employeeRequestee.getOfficeEmailId();
            String from = employeeMasterModel.getOfficeEmailId();
            String Subject = emailTemplate.getSubject();
            Subject = Subject.replaceAll("\\{user\\}", employeeRequestee.getEmployeeName());
            String msg = emailTemplate.getBodytext();
            msg = msg.replaceAll("\\{to_user\\}", employeeRequestee.getEmployeeName());
            msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
            msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
            sendMail.sendMail(from, To, Subject, msg);
        } catch (Exception e) {

        }

//        mv = searchSubmit(request, response);
        mv.setViewName("redirect:appraisalPerformance.htm?act=searchSubmit");

        return mv;
    }

    public ModelAndView reworkByManagerForIdp(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String pmpIdForRework = request.getParameter("pmpIdForRework");
        String reworkComment = request.getParameter("reworkComment");
        AppraisalPerformanceMaster appraisalPerformanceMaster = new AppraisalPerformanceMaster();
//        AppraisalPerformanceCompetencyEvaluation appraisalPerformanceCompetencyEvaluation = new AppraisalPerformanceCompetencyEvaluation();
        appraisalPerformanceMaster = appraisalPerformanceService.readById(Integer.parseInt(pmpIdForRework));

//        appraisalPerformanceMaster.setReworkComment(reworkComment);
//        appraisalPerformanceMaster.setManagerkraStatus(1);
//        appraisalPerformanceMaster.setEmployeeStatus(0);
//        appraisalPerformanceMaster.setReworkStatus(1);
        appraisalPerformanceMaster.setEmployeeIdpStatus(0);
        appraisalPerformanceMaster.setManagerIdpStatus(1);
        appraisalPerformanceMaster.setIdpReworkStatus(1);
        appraisalPerformanceMaster.setIdpReworkComment(reworkComment);

        appraisalPerformanceService.update(appraisalPerformanceMaster);
//        appraisalPerformanceCompetencyEvaluation.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
//        appraisalPerformanceCompetencyEvaluationService.deleteByManager(appraisalPerformanceCompetencyEvaluation);
        try {
            EmailTemplate emailTemplate = new EmailTemplate();
            EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
            DesignationMaster designationMaster = new DesignationMaster();
            designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
            List l1 = appraisalPerformanceService.readEmpIdFromTabId(Integer.parseInt(pmpIdForRework));
            EmployeeMaster employeeRequestee = (EmployeeMaster) l1.get(0);
            // id 116 is for status Appraisal Approved (Start Year)
            emailTemplate = emailTemplateService.readById(134);
            String To = employeeRequestee.getOfficeEmailId();
            String from = employeeMasterModel.getOfficeEmailId();
            String Subject = emailTemplate.getSubject();
            Subject = Subject.replaceAll("\\{user\\}", employeeRequestee.getEmployeeName());
            String msg = emailTemplate.getBodytext();
            msg = msg.replaceAll("\\{to_user\\}", employeeRequestee.getEmployeeName());
            msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
            msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
            sendMail.sendMail(from, To, Subject, msg);
        } catch (Exception e) {

        }

//        mv = searchSubmit(request, response);
        mv.setViewName("redirect:appraisalPerformance.htm?act=searchSubmit");

        return mv;
    }

    public ModelAndView pastAppraisalClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AppraisalPerformanceMaster appraisalPerformanceMaster = new AppraisalPerformanceMaster();
        UpdateAppraisalPerformanceKra updateAppraisalPerformanceKra = new UpdateAppraisalPerformanceKra();
        AppraisalPerformanceKra appraisalPerformanceKra = new AppraisalPerformanceKra();
        EmployeeMaster employee = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        PmpFormStatusMaster pmpFormStatusMaster = new PmpFormStatusMaster();
        CompetencyEvaluationMaster competencyEvaluationMaster = new CompetencyEvaluationMaster();
        String employeeName = "" + employee.getEmployeeName();
        String empId = request.getParameter("id");
        String userid = request.getParameter("userid");
        String appraisalId1 = request.getParameter("appraisalId");
        String pyear = request.getParameter("pyear");
        //////Print/////By dhaval
        request.setAttribute("empId", empId);
        request.setAttribute("userid", userid);
        request.setAttribute("appraisalId1", appraisalId1);
        ///////////
        empDateStartToEnd(request, response);
        selectedEmployeeDate(request, response, userid);
        kraCategoryList(request);
        String employeeId = "" + empId;//set the value in employee id
        appraisalPerformanceMaster = appraisalPerformanceService.readById(Integer.parseInt(appraisalId1));
        if (null != appraisalPerformanceMaster.getWeightageScore()) {
            String weightageScore = appraisalPerformanceMaster.getWeightageScore();
            request.setAttribute("weightageScore", weightageScore);
        }
        if (null != appraisalPerformanceMaster.getTotalScore()) {
            String totalScore = appraisalPerformanceMaster.getTotalScore();
            request.setAttribute("totalScore", totalScore);
        }
        if (null != appraisalPerformanceMaster.getTotalScoreForemployee()) {
            String totalScoreForemployee = appraisalPerformanceMaster.getTotalScoreForemployee();
            request.setAttribute("totalScoreForemployee", totalScoreForemployee);
        }
        try {
            if (null != employee.getCompetencyEvaluationId()) {

                competencyEvaluationMaster = competencyEvaluationMasterService.readById(employee.getCompetencyEvaluationId());
                if (null != competencyEvaluationMaster) {
                    String cpmname = competencyEvaluationMaster.getTitle();
                    request.setAttribute("cpmname", cpmname);
                }
            }
        } catch (Exception e) {

        }

        String pmpstatusId = "";
        List<?> pmplist = pmpFormStatusMasterService.readByPmpformstatusStatus(employeeId);
        if (!pmplist.isEmpty()) {
            pmpFormStatusMaster = (PmpFormStatusMaster) pmplist.get(0);
            pmpstatusId = "" + pmpFormStatusMaster.getId();
            boolean pmpstartyearstatus = pmpFormStatusMaster.getStartYearStatus();
            boolean pmpmidyearstatus = pmpFormStatusMaster.getMidYearStatus();
            boolean pmpendyearstatus = pmpFormStatusMaster.getEndYearStatus();
            boolean pmpasEmployee = pmpFormStatusMaster.getEmployeeSide();
            request.setAttribute("pmpstartyearstatus", pmpstartyearstatus);
            request.setAttribute("pmpmidyearstatus", pmpmidyearstatus);
            request.setAttribute("pmpendyearstatus", pmpendyearstatus);
            request.setAttribute("pmpasEmployee", pmpasEmployee);

        }
        // ==========================Mid Year=======================================================//
        if (null != appraisalPerformanceMaster.getEmpMidyearSelfassOtheractivty()) {
            String empMidyearSelfassOtheractivty = appraisalPerformanceMaster.getEmpMidyearSelfassOtheractivty();
            request.setAttribute("empMidyearSelfassOtheractivty", empMidyearSelfassOtheractivty);
        }
        if (null != appraisalPerformanceMaster.getManagerMidyearReviewevalOtheractivity()) {
            String managerMidyearReviewevalOtheractivity = appraisalPerformanceMaster.getManagerMidyearReviewevalOtheractivity();
            request.setAttribute("managerMidyearReviewevalOtheractivity", managerMidyearReviewevalOtheractivity);
        }
        // ==========================Mid Year=======================================================//
        //=======End Year=============//
        if (null != appraisalPerformanceMaster.getEmpEndyearSelfassOtheractivty()) {
            String empEndyearSelfassOtheractivty = appraisalPerformanceMaster.getEmpEndyearSelfassOtheractivty();
            request.setAttribute("empEndyearSelfassOtheractivty", empEndyearSelfassOtheractivty);
        }
        if (null != appraisalPerformanceMaster.getManagerEndyearReviewevalOtheractivity()) {
            String managerEndyearReviewevalOtheractivity = appraisalPerformanceMaster.getManagerEndyearReviewevalOtheractivity();
            request.setAttribute("managerEndyearReviewevalOtheractivity", managerEndyearReviewevalOtheractivity);
        }
        /////////////////behaviors/////////////////
        if (null != appraisalPerformanceMaster.getBehaviorsMidyearTotalscore()) {
            String behaviorsMidyearTotalscore = appraisalPerformanceMaster.getBehaviorsMidyearTotalscore();
            request.setAttribute("behaviorsMidyearTotalscore", behaviorsMidyearTotalscore);
        }
        if (null != appraisalPerformanceMaster.getBehaviorsMidyearTotalscoreForemp()) {
            String behaviorsMidyearTotalscoreForemp = appraisalPerformanceMaster.getBehaviorsMidyearTotalscoreForemp();
            request.setAttribute("behaviorsMidyearTotalscoreForemp", behaviorsMidyearTotalscoreForemp);
        }
        if (null != appraisalPerformanceMaster.getBehaviorsMidyearOtherremark()) {
            String behaviorsMidyearOtherremark = appraisalPerformanceMaster.getBehaviorsMidyearOtherremark();
            request.setAttribute("behaviorsMidyearOtherremark", behaviorsMidyearOtherremark);
        }
        if (null != appraisalPerformanceMaster.getBehaviorsEndyearOtherremark()) {
            String behaviorsEndyearOtherremark = appraisalPerformanceMaster.getBehaviorsEndyearOtherremark();
            request.setAttribute("behaviorsEndyearOtherremark", behaviorsEndyearOtherremark);
        }
        if (null != appraisalPerformanceMaster.getBehaviorsEndyearOtherremark()) {
            String behaviorsEndyearTotalscore = appraisalPerformanceMaster.getBehaviorsEndyearTotalscore();
            request.setAttribute("behaviorsEndyearTotalscore", behaviorsEndyearTotalscore);
        }
        if (null != appraisalPerformanceMaster.getBehaviorsEndyearTotalscore()) {
            String behaviorsEndyearTotalscore = appraisalPerformanceMaster.getBehaviorsEndyearTotalscore();
            request.setAttribute("behaviorsEndyearTotalscore", behaviorsEndyearTotalscore);
        }
        if (null != appraisalPerformanceMaster.getBehaviorsEndyearTotalscoreForemp()) {
            String behaviorsEndyearTotalscoreForemp = appraisalPerformanceMaster.getBehaviorsEndyearTotalscoreForemp();
            request.setAttribute("behaviorsEndyearTotalscoreForemp", behaviorsEndyearTotalscoreForemp);
        }
//        employee side

        if (null != appraisalPerformanceMaster.getBehaviorsMidyearOtherremarkForemployee()) {
            String behaviorsMidyearOtherremarkForemployee = appraisalPerformanceMaster.getBehaviorsMidyearOtherremarkForemployee();
            request.setAttribute("behaviorsMidyearOtherremarkForemployee", behaviorsMidyearOtherremarkForemployee);
        }
        if (null != appraisalPerformanceMaster.getBehaviorsEndyearOtherremarkForemployee()) {
            String behaviorsEndyearOtherremarkForemployee = appraisalPerformanceMaster.getBehaviorsEndyearOtherremarkForemployee();
            request.setAttribute("behaviorsEndyearOtherremarkForemployee", behaviorsEndyearOtherremarkForemployee);
        }
        if (null != appraisalPerformanceMaster.getBehaviorsEndyearOtherremark()) {
            String behaviorsEndyearTotalscore = appraisalPerformanceMaster.getBehaviorsEndyearTotalscore();
            request.setAttribute("behaviorsEndyearTotalscore", behaviorsEndyearTotalscore);
        }
        if (null != appraisalPerformanceMaster.getBehaviorsEndyearTotalscore()) {
            String behaviorsEndyearTotalscore = appraisalPerformanceMaster.getBehaviorsEndyearTotalscore();
            request.setAttribute("behaviorsEndyearTotalscore", behaviorsEndyearTotalscore);
        }

        if (null != appraisalPerformanceMaster.getEmpActivityScore()) {
            String empActivityScore = appraisalPerformanceMaster.getEmpActivityScore();
            request.setAttribute("empActivityScore", empActivityScore);
        }

//        if (null != appraisalPerformanceMaster.getManagerStatus()) {
        int managerStatus = appraisalPerformanceMaster.getManagerStatus();
        request.setAttribute("managerStatus", managerStatus);
        int statusFlag = appraisalPerformanceMaster.getStatus();
        request.setAttribute("statusFlag", statusFlag);
//        }
//        if (null != appraisalPerformanceMaster.getEmployeeStatus()) {
        int employeeStatus = appraisalPerformanceMaster.getEmployeeStatus();
        request.setAttribute("employeeStatus", employeeStatus);
//        }
//        if (null != appraisalPerformanceMaster.getStatus()) {
//            int employeeStatus = appraisalPerformanceMaster.getStatus();
//            request.setAttribute("employeeStatus", employeeStatus);
//        }
//        if (null != appraisalPerformanceMaster.getStatus()) {
//            int employeeStatus = appraisalPerformanceMaster.getStatus();
//            request.setAttribute("employeeStatus", employeeStatus);
//        }
//        if (null != appraisalPerformanceMaster.getBehaviorsFinalscore()) {
//            String behaviorsFinalscore = appraisalPerformanceMaster.getBehaviorsFinalscore();
//            request.setAttribute("behaviorsFinalscore", behaviorsFinalscore);
//        }

        if (null != appraisalPerformanceMaster.getBehaviorsFinalscore() && !"".equals(appraisalPerformanceMaster.getBehaviorsFinalscore())) {
            String behaviorsFinalscore = appraisalPerformanceMaster.getBehaviorsFinalscore();
            request.setAttribute("behaviorsFinalscore", behaviorsFinalscore);
        }
        if (null != appraisalPerformanceMaster.getBehaviorsFinalscoreForemployee() && !"".equals(appraisalPerformanceMaster.getBehaviorsFinalscoreForemployee())) {
            String behaviorsFinalscoreForemployee = appraisalPerformanceMaster.getBehaviorsFinalscoreForemployee();
            request.setAttribute("behaviorsFinalscoreForemployee", behaviorsFinalscoreForemployee);
        }
//        } else {
//            String behaviorsFinalscore = "";
//            request.setAttribute("behaviorsFinalscore", behaviorsFinalscore);
//        }
        //int year = Integer.parseInt(request.getParameter("year"));
        List<?> l1 = appraisalFillingDataService.getCurrentAndPreviousYear();
        String previousYear = "";
        int currentYear = 0;
        if (!l1.isEmpty()) {
            Object[] obj = (Object[]) l1.get(0);
//            previousYear = (Integer) obj[0];
            previousYear = "" + obj[0];
//            currentYear = (Integer) obj[1];
        }
        //if (!"".equals(year)) {
//
//        }
//        int year = Calendar.getInstance().get(Calendar.YEAR);
//        List<?> list = appraisalPerformanceService.readByAppraisalPerformanceId(employeeId);

//2017//
//        List<?> list = appraisalPerformanceService.readByAppraisalPerformanceId(employeeId, year);
        List<?> list = appraisalPerformanceService.readByAppraisalPerformanceId(employeeId, Integer.parseInt(pyear));
        if (!list.isEmpty()) {

            appraisalPerformanceMaster = (AppraisalPerformanceMaster) list.get(0);
            int appraisalId = appraisalPerformanceMaster.getId();
            //AppraisalPerformanceKra appraisalPerformanceKra = new AppraisalPerformanceKra();
            appraisalPerformanceKra.setId(appraisalId);
            String kragoal = "";
            String metric = "";
            boolean updateStatus = false;
            int kragoalId;
            //int weightage = 0;

            List<?> kraList = appraisalPerformanceKraService.readByAppraisalKraGoal(appraisalPerformanceKra);
            if (!kraList.isEmpty()) {
                appraisalPerformanceKra = (AppraisalPerformanceKra) kraList.get(0);
                kragoal = appraisalPerformanceKra.getKraGoal();
                kragoalId = appraisalPerformanceKra.getId();
                metric = appraisalPerformanceKra.getMetric();
//                KraCategory kraCategory1 = new KraCategory();
//                kraCategory1 = kraCategoryService.readById(appraisalPerformanceKra.getKraCategoryByKraCategoryByEmployee().getId());
                if (null != kragoal && !"".equals(kragoal)) {

                    UpdateAppraisalPerformanceKra updateAppraisalPerformanceKra1 = new UpdateAppraisalPerformanceKra();
                    updateAppraisalPerformanceKra.setId(Integer.parseInt("" + kragoalId));
                    List<?> updateAppraisalPerformanceKra1List = updateAppraisalPerformanceKraService.readByUserUpdateKra(updateAppraisalPerformanceKra);
                    if (!updateAppraisalPerformanceKra1List.isEmpty()) {

                        updateAppraisalPerformanceKra1 = (UpdateAppraisalPerformanceKra) updateAppraisalPerformanceKra1List.get(0);
                        if (!kragoal.equals(updateAppraisalPerformanceKra1.getUpdateKra()) || !metric.equals(updateAppraisalPerformanceKra1.getUpdateMetric())) {
                            updateStatus = true;
                        }
                    }
                }
            }
            request.setAttribute("updateStatus", updateStatus);
            request.setAttribute("kragoal", kraList);
            request.setAttribute("weightage", kraList);
            request.setAttribute("appraisalId", appraisalId);
            request.setAttribute("empMidyearSelfassessmentGoal", kraList);
            request.setAttribute("managerMidyearReviewEvaluation", kraList);
            request.setAttribute("midyearStatus", kraList);
            request.setAttribute("endyearStatus", kraList);
            request.setAttribute("empEndyearSelfassessmentGoal", kraList);
            request.setAttribute("editDate", kraList);
            request.setAttribute("startDate", kraList);
            request.setAttribute("year", request.getParameter("year"));

        }

        ////////////////////////////////////KRA OTHER Activity///////////////////////////////////////////////////////////
        String kragoal_activity = "";
        String metric_activity = "";
        boolean kraOtherupdateStatus = false;
        int kragoalactivityId;
        if (null != appraisalPerformanceMaster.getId()) {

            AppraisalPerformanceActivities appraisalPerformanceActivities = new AppraisalPerformanceActivities();
            appraisalPerformanceActivities.setAppraisalPerformanceMaster(appraisalPerformanceMaster);

            List<?> kraOtherList = appraisalPerformanceActivitiesService.readByAppraisalKraGoalActivities(appraisalPerformanceActivities);
            if (!kraOtherList.isEmpty()) {
                appraisalPerformanceActivities = (AppraisalPerformanceActivities) kraOtherList.get(0);
                kragoal_activity = appraisalPerformanceActivities.getKraGoalActivities();
                kragoalactivityId = appraisalPerformanceActivities.getId();
                metric_activity = appraisalPerformanceActivities.getMetricActivities();

                if (null != kragoal_activity && !"".equals(kragoal_activity)) {
                    UpdateAppraisalPerformanceActivities updateAppraisalPerformanceActivities = new UpdateAppraisalPerformanceActivities();
                    updateAppraisalPerformanceActivities.setId(Integer.parseInt("" + kragoalactivityId));
                    List<?> updateKraOtherList = updateAppraisalPerformanceActivitiesService.readByUserUpdateKraOther(updateAppraisalPerformanceActivities);
                    if (!updateKraOtherList.isEmpty()) {

                        updateAppraisalPerformanceActivities = (UpdateAppraisalPerformanceActivities) updateKraOtherList.get(0);
                        if (!kragoal_activity.equals(updateAppraisalPerformanceActivities.getKraActivity()) || !metric_activity.equals(updateAppraisalPerformanceActivities.getMetricActivity())) {
                            kraOtherupdateStatus = true;
                        }
                    }
                }
            }
            request.setAttribute("kraOtherupdateStatus", kraOtherupdateStatus);
            request.setAttribute("kragoalOtherActivity", kraOtherList);
        }
        ////////////////////////////////////KRA OTHER Activity//////////////////////////////////////////////////////////

//        // =======================competency Evaluation==========================================================//
//        // =======================competency Evaluation Chsanage by date 11/11/2016==========================================================//
//        competencyList(request);
//        int competencyId = 0;
//        AppraisalPerformanceCompetencyEvaluation appraisalPerformanceCompetencyEvaluation = new AppraisalPerformanceCompetencyEvaluation();
//        appraisalPerformanceCompetencyEvaluation.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
//        CompetencyEvaluationTextmaster competencyEvaluationTextmaster = new CompetencyEvaluationTextmaster();
////        List<?> competencyEvaluationList = appraisalPerformanceCompetencyEvaluationService.readAppraisalPerformanceCompetencyEvaluationDetail(appraisalPerformanceCompetencyEvaluation);
//        List<?> competencyEvaluationList = appraisalPerformanceCompetencyEvaluationService.readByEmployeeWiseAppraisalPerformanceCompetencyEvaluationDetail(appraisalPerformanceCompetencyEvaluation);
//
//        request.setAttribute("competencyEvaluationList", competencyEvaluationList);
//
//        // =======================competency Evaluation Chsanage by date 11/11/2016==========================================================//
//        //Individual Development Plan//
//        AppraisalPerformanceIndividualDevelopmentPlan appraisalPerformanceIndividualDevelopmentPlan = new AppraisalPerformanceIndividualDevelopmentPlan();
//        appraisalPerformanceIndividualDevelopmentPlan.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
//        String text1 = "";
//        List<?> individualDevelopmentPlanList = appraisalPerformanceIndividualDevelopmentPlanService.readIndividualDevelopmentPlanDetail(appraisalPerformanceIndividualDevelopmentPlan);
//        if (!individualDevelopmentPlanList.isEmpty()) {
//            appraisalPerformanceIndividualDevelopmentPlan = (AppraisalPerformanceIndividualDevelopmentPlan) individualDevelopmentPlanList.get(0);
//            text1 = appraisalPerformanceIndividualDevelopmentPlan.getText1();
//        }
//        request.setAttribute("text1", individualDevelopmentPlanList);
//        request.setAttribute("text2", individualDevelopmentPlanList);
//        request.setAttribute("text3", individualDevelopmentPlanList);
//        request.setAttribute("remark", individualDevelopmentPlanList);
//        request.setAttribute("midYearRemark", individualDevelopmentPlanList);
//        request.setAttribute("endYearRemark", individualDevelopmentPlanList);
//        request.setAttribute("individualDevelopmentPlanList", individualDevelopmentPlanList);
        //////////Behaviors///////////////
        AppraisalPerformanceBehaviors appraisalPerformanceBehaviors = new AppraisalPerformanceBehaviors();
        String behaviors = "";
        appraisalPerformanceBehaviors.setAppraisalPerformanceMaster(appraisalPerformanceMaster);
        List<?> behaviorsList = appraisalPerformanceBehaviorsService.readBehaviorsDetail(appraisalPerformanceBehaviors);
        if (!behaviorsList.isEmpty()) {
            appraisalPerformanceBehaviors = (AppraisalPerformanceBehaviors) behaviorsList.get(0);
            behaviors = appraisalPerformanceBehaviors.getBehaviors();
        }
        request.setAttribute("behaviors", behaviorsList);
        request.setAttribute("behaviorsList", behaviorsList);

        mv.getModelMap().put("appraisalPerformanceMaster", appraisalPerformanceMaster);
//        mv.setViewName("Appraisal/PerformanceAppraisalForm");
        mv.setViewName("Appraisal/LastYearPerformanceAppraisalForm");
//        mv.setViewName("Appraisal/ManagerPerformanceAppraisalForm");
//        mv.setViewName("forward:userMaster.htm?act=userDashboard");
        return mv;
    }

    public ModelAndView changeRequestPMP(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AppraisalPerformanceMaster appraisalPerformanceMaster = new AppraisalPerformanceMaster();
        EmployeeMaster employee = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        String employeeName = "" + employee.getEmployeeName();
        String empId = request.getParameter("id");
        String userid = request.getParameter("userid");
        String appraisalId1 = request.getParameter("appraisalId");
        String pyear = request.getParameter("pyear");
        //////Print/////By dhaval
        request.setAttribute("empId", empId);
        request.setAttribute("userid", userid);
        request.setAttribute("appraisalId1", appraisalId1);
        selectedEmployeeDate(request, response, userid);
        ///////////
        String employeeId = "" + empId;//set the value in employee id
        appraisalPerformanceMaster = appraisalPerformanceService.readById(Integer.parseInt(appraisalId1));
        mv.getModelMap().put("appraisalPerformanceMaster", appraisalPerformanceMaster);
        mv.setViewName("Appraisal/ChangeRequestPMP");
        return mv;
    }

    public ModelAndView changeRequestSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AppraisalPerformanceMaster appraisalPerformanceMaster = new AppraisalPerformanceMaster();
        AppraisalPerformanceMaster appraisalPerformanceMaster1 = new AppraisalPerformanceMaster();
        String appraisalId1 = request.getParameter("appraisalId");
        bind(request, appraisalPerformanceMaster);

        appraisalPerformanceMaster1 = appraisalPerformanceService.readById(Integer.parseInt(appraisalId1));

        if (appraisalPerformanceMaster.getEmployeeStatus() == 0) {
            appraisalPerformanceMaster1.setEmployeeStatus(appraisalPerformanceMaster.getEmployeeStatus());
        } else if (appraisalPerformanceMaster.getEmployeeStatus() == 1) {
            appraisalPerformanceMaster1.setEmployeeStatus(appraisalPerformanceMaster.getEmployeeStatus());
        }
        if (appraisalPerformanceMaster.getManagerkraStatus() == 1) {
            appraisalPerformanceMaster1.setManagerkraStatus(appraisalPerformanceMaster.getManagerkraStatus());
        } else if (appraisalPerformanceMaster.getManagerkraStatus() == 0) {
            appraisalPerformanceMaster1.setManagerkraStatus(appraisalPerformanceMaster.getManagerkraStatus());
        }

        if (appraisalPerformanceMaster.getEmployeeStatus() == 0 && appraisalPerformanceMaster.getManagerkraStatus() == 0) {
            request.setAttribute("failureMessage",
                    "Error : At a Time Only Manager Or Employee Side Unlock The Form");
            String userid = request.getParameter("userid");
            selectedEmployeeDate(request, response, userid);
            request.setAttribute("userid", userid);
            request.setAttribute("appraisalId1", appraisalId1);
            mv.getModelMap().put("appraisalPerformanceMaster", appraisalPerformanceMaster);
            mv.setViewName("Appraisal/ChangeRequestPMP");

        } else {
            appraisalPerformanceService.update(appraisalPerformanceMaster1);
            mv = searchClick(request, response);
            request.setAttribute("successMessage",
                    "Info : Your Request Are Done");
        }
        return mv;
    }

    private synchronized void mailSendForKraRegistration() throws Exception {

        EmployeeMaster employeeMaster = new EmployeeMaster();
        Calendar c = Calendar.getInstance();
        Date d = new Date();
        c.setTime(d);
        c.add(Calendar.DAY_OF_MONTH, -1);
        Date checkDate = c.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String CheckDate = sdf.format(checkDate);
        AppraisalPerformanceMaster appraisalPerformanceMaster = new AppraisalPerformanceMaster();
        EmployeeMaster fromEmp = employeeMasterService.readById(1544);

        List<?> empList = employeeMasterService.readByJoinDate(CheckDate);
        if (!empList.isEmpty()) {
            for (Object o : empList) {
                employeeMaster = (EmployeeMaster) o;
                int employeeId = employeeMaster.getId();
                String emailId = employeeMaster.getEmailAddress();
                List<?> apmList = appraisalPerformanceService.readByEmpID(employeeId);
                if (!apmList.isEmpty()) {
                    for (Object o1 : apmList) {
                        appraisalPerformanceMaster = (AppraisalPerformanceMaster) o1;
                        int status = appraisalPerformanceMaster.getStatus();
                        if (status == 0) {
                            EmailTemplate emailTemplate = emailTemplateService.readById(142); ///////141 template for probation to confirm
                            for (String emailId1 : emailId.split(",")) {
                                if (!emailId1.equals("")) {
                                    String To1 = emailId1;
                                    String from1 = fromEmp.getOfficeEmailId();
                                    String subject1 = emailTemplate.getSubject();
//                                    subject1 = subject1.replaceAll("\\{new_joinee\\}", employeeMaster.getEmployeeName());
                                    String msg1 = emailTemplate.getBodytext();
                                    msg1 = msg1.replaceAll("\\{new_joinee\\}", employeeMaster.getEmployeeName());
                                    msg1 = msg1.replaceAll("\\{no_days\\}", "30");
                                    sendMail.sendMail(from1, To1, subject1, msg1);
                                }
                            }
                        }
                    }
                }
//                else {
//                    EmailTemplate emailTemplate = emailTemplateService.readById(142); ///////141 template for probation to confirm
//                    for (String emailId1 : emailId.split(",")) {
//                        if (!emailId1.equals("")) {
//                            String To1 = emailId1;
//                            String from1 = fromEmp.getOfficeEmailId();
//                            String subject1 = emailTemplate.getSubject();
////                            subject1 = subject1.replaceAll("\\{user\\}", employeeMaster.getEmployeeName());
//                            String msg1 = emailTemplate.getBodytext();
//                            msg1 = msg1.replaceAll("\\{new_joinee\\}", employeeMaster.getEmployeeName());
//                            msg1 = msg1.replaceAll("\\{no_days\\}", "1");
//                            sendMail.sendMail(from1, To1, subject1, msg1);
//                        }
//                    }
//                }
            }
        }

        Calendar cal1 = Calendar.getInstance();
        cal1.add(Calendar.DAY_OF_MONTH, -15);
        Date checkDate1 = cal1.getTime();
        String CheckDate1 = sdf.format(checkDate1);
        List<?> empList1 = employeeMasterService.readByJoinDate(CheckDate1);
        if (!empList1.isEmpty()) {
            for (Object o : empList1) {
                employeeMaster = (EmployeeMaster) o;
                int employeeId = employeeMaster.getId();
                String emailId = employeeMaster.getEmailAddress();
                List<?> apmList = appraisalPerformanceService.readByEmpID(employeeId);
                if (!apmList.isEmpty()) {
                    for (Object o1 : apmList) {
                        appraisalPerformanceMaster = (AppraisalPerformanceMaster) o1;
                        int status = appraisalPerformanceMaster.getStatus();
                        if (status == 0) {
                            EmailTemplate emailTemplate = emailTemplateService.readById(142); ///////141 template for probation to confirm
                            for (String emailId1 : emailId.split(",")) {
                                if (!emailId1.equals("")) {
                                    String To1 = emailId1;
                                    String from1 = fromEmp.getOfficeEmailId();
                                    String subject1 = emailTemplate.getSubject();
//                                    subject1 = subject1.replaceAll("\\{user\\}", employeeMaster.getEmployeeName());
                                    String msg1 = emailTemplate.getBodytext();
                                    msg1 = msg1.replaceAll("\\{new_joinee\\}", employeeMaster.getEmployeeName());
                                    msg1 = msg1.replaceAll("\\{no_days\\}", "15");
                                    sendMail.sendMail(from1, To1, subject1, msg1);
                                }
                            }
                        }
                    }
                }
//                else {
//                    EmailTemplate emailTemplate = emailTemplateService.readById(142); ///////141 template for probation to confirm
//                    for (String emailId1 : emailId.split(",")) {
//                        if (!emailId1.equals("")) {
//                            String To1 = emailId1;
//                            String from1 = fromEmp.getOfficeEmailId();
//                            String subject1 = emailTemplate.getSubject();
////                            subject1 = subject1.replaceAll("\\{user\\}", employeeMaster.getEmployeeName());
//                            String msg1 = emailTemplate.getBodytext();
//                            msg1 = msg1.replaceAll("\\{no_days\\}", "3");
//                            sendMail.sendMail(from1, To1, subject1, msg1);
//                        }
//                    }
//                }
            }
        }
        Calendar cal2 = Calendar.getInstance();
        cal2.add(Calendar.DAY_OF_MONTH, -23);
        Date checkDate2 = cal2.getTime();
        String CheckDate2 = sdf.format(checkDate2);
        List<?> empList2 = employeeMasterService.readByJoinDate(CheckDate2);
        if (!empList2.isEmpty()) {
            for (Object o : empList2) {
                employeeMaster = (EmployeeMaster) o;
                int employeeId = employeeMaster.getId();
                String emailId = employeeMaster.getEmailAddress();
                List<?> apmList = appraisalPerformanceService.readByEmpID(employeeId);
                if (!apmList.isEmpty()) {
                    for (Object o1 : apmList) {
                        appraisalPerformanceMaster = (AppraisalPerformanceMaster) o1;
                        int status = appraisalPerformanceMaster.getStatus();
                        if (status == 0) {
                            EmailTemplate emailTemplate = emailTemplateService.readById(142); ///////141 template for probation to confirm
                            for (String emailId1 : emailId.split(",")) {
                                if (!emailId1.equals("")) {
                                    String To1 = emailId1;
                                    String from1 = fromEmp.getOfficeEmailId();
                                    String subject1 = emailTemplate.getSubject();
//                                    subject1 = subject1.replaceAll("\\{user\\}", employeeMaster.getEmployeeName());
                                    String msg1 = emailTemplate.getBodytext();
                                    msg1 = msg1.replaceAll("\\{new_joinee\\}", employeeMaster.getEmployeeName());
                                    msg1 = msg1.replaceAll("\\{no_days\\}", "7");
                                    sendMail.sendMail(from1, To1, subject1, msg1);
                                }
                            }
                        }
                    }
                }
//                else {
//                    EmailTemplate emailTemplate = emailTemplateService.readById(142); ///////141 template for probation to confirm
//                    for (String emailId1 : emailId.split(",")) {
//                        if (!emailId1.equals("")) {
//                            String To1 = emailId1;
//                            String from1 = fromEmp.getOfficeEmailId();
//                            String subject1 = emailTemplate.getSubject();
////                            subject1 = subject1.replaceAll("\\{user\\}", employeeMaster.getEmployeeName());
//                            String msg1 = emailTemplate.getBodytext();
//                            msg1 = msg1.replaceAll("\\{no_days\\}", "7");
//                            sendMail.sendMail(from1, To1, subject1, msg1);
//                        }
//                    }
//                }
            }
        }
        Calendar cal3 = Calendar.getInstance();
        cal3.add(Calendar.DAY_OF_MONTH, -27);
        Date checkDate3 = cal3.getTime();
        String CheckDate3 = sdf.format(checkDate3);
        List<?> empList3 = employeeMasterService.readByJoinDate(CheckDate3);
        if (!empList3.isEmpty()) {
            for (Object o : empList3) {
                employeeMaster = (EmployeeMaster) o;
                int employeeId = employeeMaster.getId();
                String emailId = employeeMaster.getEmailAddress();
                List<?> apmList = appraisalPerformanceService.readByEmpID(employeeId);
                if (!apmList.isEmpty()) {
                    for (Object o1 : apmList) {
                        appraisalPerformanceMaster = (AppraisalPerformanceMaster) o1;
                        int status = appraisalPerformanceMaster.getStatus();
                        if (status == 0) {
                            EmailTemplate emailTemplate = emailTemplateService.readById(142); ///////141 template for probation to confirm
                            for (String emailId1 : emailId.split(",")) {
                                if (!emailId1.equals("")) {
                                    String To1 = emailId1;
                                    String from1 = fromEmp.getOfficeEmailId();
                                    String subject1 = emailTemplate.getSubject();
//                                    subject1 = subject1.replaceAll("\\{user\\}", employeeMaster.getEmployeeName());
                                    String msg1 = emailTemplate.getBodytext();
                                    msg1 = msg1.replaceAll("\\{new_joinee\\}", employeeMaster.getEmployeeName());
                                    msg1 = msg1.replaceAll("\\{no_days\\}", "3");
                                    sendMail.sendMail(from1, To1, subject1, msg1);
                                }
                            }
                        }
                    }
                }
//                else {
//                    EmailTemplate emailTemplate = emailTemplateService.readById(142); ///////141 template for probation to confirm
//                    for (String emailId1 : emailId.split(",")) {
//                        if (!emailId1.equals("")) {
//                            String To1 = emailId1;
//                            String from1 = employeeMaster.getOfficeEmailId();
//                            String subject1 = fromEmp.getOfficeEmailId();
////                            subject1 = subject1.replaceAll("\\{user\\}", employeeMaster.getEmployeeName());
//                            String msg1 = emailTemplate.getBodytext();
//                            msg1 = msg1.replaceAll("\\{no_days\\}", "15");
//                            sendMail.sendMail(from1, To1, subject1, msg1);
//                        }
//                    }
//                }
            }
        }
        Calendar cal4 = Calendar.getInstance();
        cal4.add(Calendar.DAY_OF_MONTH, -30);
        Date checkDate4 = cal4.getTime();
        String CheckDate4 = sdf.format(checkDate4);
        List<?> empList4 = employeeMasterService.readByJoinDate(CheckDate4);
        if (!empList4.isEmpty()) {
            for (Object o : empList4) {
                employeeMaster = (EmployeeMaster) o;
                int employeeId = employeeMaster.getId();
                String emailId = employeeMaster.getEmailAddress();
                List<?> apmList = appraisalPerformanceService.readByEmpID(employeeId);
                if (!apmList.isEmpty()) {
                    for (Object o1 : apmList) {
                        appraisalPerformanceMaster = (AppraisalPerformanceMaster) o1;
                        int status = appraisalPerformanceMaster.getStatus();
                        if (status == 0) {
                            EmailTemplate emailTemplate = emailTemplateService.readById(142); ///////141 template for probation to confirm
                            for (String emailId1 : emailId.split(",")) {
                                if (!emailId1.equals("")) {
                                    String To1 = emailId1;
                                    String from1 = fromEmp.getOfficeEmailId();
                                    String subject1 = emailTemplate.getSubject();
//                                    subject1 = subject1.replaceAll("\\{user\\}", employeeMaster.getEmployeeName());
                                    String msg1 = emailTemplate.getBodytext();
                                    msg1 = msg1.replaceAll("\\{new_joinee\\}", employeeMaster.getEmployeeName());
                                    msg1 = msg1.replaceAll("\\{no_days\\}", "1");
                                    sendMail.sendMail(from1, To1, subject1, msg1);
                                }
                            }
                        }
                    }
                }
//                else {
//                    EmailTemplate emailTemplate = emailTemplateService.readById(142); ///////141 template for probation to confirm
//                    for (String emailId1 : emailId.split(",")) {
//                        if (!emailId1.equals("")) {
//                            String To1 = emailId1;
//                            String from1 = fromEmp.getOfficeEmailId();
//                            String subject1 = emailTemplate.getSubject();
////                            subject1 = subject1.replaceAll("\\{user\\}", employeeMaster.getEmployeeName());
//                            String msg1 = emailTemplate.getBodytext();
//                            msg1 = msg1.replaceAll("\\{no_days\\}", "30");
//                            sendMail.sendMail(from1, To1, subject1, msg1);
//                        }
//                    }
//                }
            }
        }

    }

    public ModelAndView searchReoprtByYearWiseSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AppraisalPerformanceMaster appraisalPerformanceMaster = new AppraisalPerformanceMaster();
        AppraisalPerformanceKra appraisalPerformanceKra = new AppraisalPerformanceKra();

        String employeeMasterId = request.getParameter("employeeMasterIdForYear");
        String cycleYear = request.getParameter("cycleYear");

//        timeLineDate(request, response);
//        String searchvalue = request.getParameter("valDetail");
//        String chque[] = request.getParameterValues("checkedRows");
        EmployeeMaster employeeMaster = new EmployeeMaster();

        if (null != employeeMasterId && !"".equals(employeeMasterId)) {
            employeeMaster.setId(Integer.parseInt(employeeMasterId));
        }
        int cyear1 = Calendar.getInstance().get(Calendar.YEAR);
        appraisalPerformanceMaster.setEmployeeMaster(employeeMaster);

//        List timeLineList = appraisalFillingDataService.read();
//        AppraisalFillingData appraisalFillingData = new AppraisalFillingData();
//        if (!timeLineList.isEmpty()) {
//            appraisalFillingData = (AppraisalFillingData) timeLineList.get(timeLineList.size() - 1);
//        }App
        List SefinlList = new ArrayList();

        List<AppraisalFillingData> list = (List<AppraisalFillingData>) appraisalFillingDataService.readByYear(cycleYear);
        for (AppraisalFillingData afd : list) {
            String behYear = afd.getId().toString();
            List<?> apm = appraisalPerformanceService.readByAppraisalPerformanceIdNew(employeeMasterId, behYear);
            AppraisalPerformanceMaster master = new AppraisalPerformanceMaster();

            String StartMonth = "";
            String EndMonth = "";
            String KRAStartDate = afd.getStartDate();
            String StartDate = afd.getYearEndStartDate();
            String KRAEndDate = afd.getEndDate();
            String EndDate = afd.getYearEndEndDate();
            String weitage = "";
            String selfScore = "";
            String managmentScore = "";
            if (!apm.isEmpty()) {
                master = (AppraisalPerformanceMaster) apm.get(0);
                selfScore = master.getEmployeeTotalFinalScore();
                managmentScore = master.getTotalScore();
                weitage = master.getWeightageScore();

            }
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date date = sdf.parse(KRAStartDate);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
            int FromMonth = cal.get(Calendar.MONTH);
//            int FromMonth = calFrom.get(Calendar.MONTH);
            String FromMonthName = monthNames[FromMonth];
            Date date1 = sdf.parse(EndDate);
            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(date1);
            int ToMonth = cal1.get(Calendar.MONTH);
            String ToMonthName = monthNames[ToMonth];
            List finlList = new ArrayList();
            finlList.add(StartDate);  //0
            finlList.add(EndDate);  //1 
            finlList.add(KRAStartDate); //2
            finlList.add(KRAEndDate);   //3
            finlList.add(weitage);  //4
            finlList.add(selfScore);    //5
            finlList.add(managmentScore);   //6
            finlList.add(FromMonthName);    //7
            finlList.add(ToMonthName);  //8
            SefinlList.add(finlList);

        }
//        String pyear = request.getParameter("pmpyear");

        mv.getModelMap().put("list", SefinlList);
        request.setAttribute("list", SefinlList);
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=EmployeePMPYearReport.xls");
//        mv.getModelMap().put("appraisalPerformanceMaster", appraisalPerformanceMaster);
        mv.setViewName("Appraisal/YearWiseReport");
//          
        return mv;
    }
}
