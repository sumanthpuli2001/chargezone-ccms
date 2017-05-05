/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.appraisalPerformance;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.AppraisalFillingData;
import com.bul.zydex.model.AppraisalPerformanceActivities;
import com.bul.zydex.model.AppraisalPerformanceBehaviors;
import com.bul.zydex.model.AppraisalPerformanceCompetencyEvaluation;
import com.bul.zydex.model.AppraisalPerformanceIndividualDevelopmentPlan;
import com.bul.zydex.model.AppraisalPerformanceKra;
import com.bul.zydex.model.AppraisalPerformanceMaster;
import com.bul.zydex.model.AppraisalkraActivity;
import com.bul.zydex.model.CompetencyEvaluationMaster;
import com.bul.zydex.model.CompetencyEvaluationTextmaster;
import com.bul.zydex.model.DepartmentMaster;
import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.model.EmailAddMaster;
import com.bul.zydex.model.EmailTemplate;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.KraCategory;
import com.bul.zydex.model.PmpFormStatusMaster;
import com.bul.zydex.model.UpdateAppraisalPerformanceActivities;
import com.bul.zydex.model.UpdateAppraisalPerformanceKra;
import com.bul.zydex.model.UserMaster;
import com.bul.zydex.service.PmpFormStatusMaster.PmpFormStatusMasterService;
import com.bul.zydex.service.appraisalPerformance.AppraisalFillingDataService;
import com.bul.zydex.service.appraisalPerformance.AppraisalPerformanceActivitiesService;
import com.bul.zydex.service.appraisalPerformance.AppraisalPerformanceBehaviorsService;
import com.bul.zydex.service.appraisalPerformance.AppraisalPerformanceCompetencyEvaluationService;
import com.bul.zydex.service.appraisalPerformance.AppraisalPerformanceIndividualDevelopmentPlanService;
import com.bul.zydex.service.appraisalPerformance.AppraisalPerformanceKraService;
import com.bul.zydex.service.appraisalPerformance.AppraisalPerformanceService;
import com.bul.zydex.service.appraisalPerformance.AppraisalkraActivityService;
import com.bul.zydex.service.appraisalPerformance.CompetencyEvaluationMasterService;
import com.bul.zydex.service.appraisalPerformance.CompetencyEvaluationTextmasterService;
import com.bul.zydex.service.appraisalPerformance.KraCategoryService;
import com.bul.zydex.service.appraisalPerformance.UpdateAppraisalPerformanceActivitiesService;
import com.bul.zydex.service.appraisalPerformance.UpdateAppraisalPerformanceKraService;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.Validator;

/**
 *
 * @author admin
 */
public class AppraisalPerformanceAbstract extends CustomAbstract {

    protected Validator appraisalPerformanceValidator;
    protected AppraisalPerformanceService<AppraisalPerformanceMaster> appraisalPerformanceService;
    protected AppraisalFillingDataService<AppraisalFillingData> appraisalFillingDataService;
    protected AppraisalPerformanceKraService<AppraisalPerformanceKra> appraisalPerformanceKraService;
    protected UpdateAppraisalPerformanceKraService<UpdateAppraisalPerformanceKra> updateAppraisalPerformanceKraService;
    protected CompetencyEvaluationMasterService<CompetencyEvaluationMaster> competencyEvaluationMasterService;
    protected CompetencyEvaluationTextmasterService<CompetencyEvaluationTextmaster> competencyEvaluationTextmasterService;
    protected AppraisalPerformanceCompetencyEvaluationService<AppraisalPerformanceCompetencyEvaluation> appraisalPerformanceCompetencyEvaluationService;
    protected AppraisalPerformanceIndividualDevelopmentPlanService<AppraisalPerformanceIndividualDevelopmentPlan> appraisalPerformanceIndividualDevelopmentPlanService;
    protected AppraisalPerformanceBehaviorsService<AppraisalPerformanceBehaviors> appraisalPerformanceBehaviorsService;
    protected KraCategoryService<KraCategory> kraCategoryService;
    protected AppraisalPerformanceActivitiesService<AppraisalPerformanceActivities> appraisalPerformanceActivitiesService;
    protected UpdateAppraisalPerformanceActivitiesService<UpdateAppraisalPerformanceActivities> updateAppraisalPerformanceActivitiesService;
    protected AppraisalkraActivityService<AppraisalkraActivity> appraisalkraActivityService;
    protected PmpFormStatusMasterService<PmpFormStatusMaster> pmpFormStatusMasterService;

    public UpdateAppraisalPerformanceKraService<UpdateAppraisalPerformanceKra> getUpdateAppraisalPerformanceKraService() {
        return updateAppraisalPerformanceKraService;
    }

    public void setUpdateAppraisalPerformanceKraService(UpdateAppraisalPerformanceKraService<UpdateAppraisalPerformanceKra> updateAppraisalPerformanceKraService) {
        this.updateAppraisalPerformanceKraService = updateAppraisalPerformanceKraService;
    }

    public AppraisalPerformanceKraService<AppraisalPerformanceKra> getAppraisalPerformanceKraService() {
        return appraisalPerformanceKraService;
    }

    public void setAppraisalPerformanceKraService(AppraisalPerformanceKraService<AppraisalPerformanceKra> appraisalPerformanceKraService) {
        this.appraisalPerformanceKraService = appraisalPerformanceKraService;
    }

    public Validator getAppraisalPerformanceValidator() {
        return appraisalPerformanceValidator;
    }

    public void setAppraisalPerformanceValidator(Validator appraisalPerformanceValidator) {
        this.appraisalPerformanceValidator = appraisalPerformanceValidator;
    }

    public AppraisalPerformanceService<AppraisalPerformanceMaster> getAppraisalPerformanceService() {
        return appraisalPerformanceService;
    }

    public void setAppraisalPerformanceService(AppraisalPerformanceService<AppraisalPerformanceMaster> appraisalPerformanceService) {
        this.appraisalPerformanceService = appraisalPerformanceService;
    }

    public AppraisalFillingDataService<AppraisalFillingData> getAppraisalFillingDataService() {
        return appraisalFillingDataService;
    }

    public void setAppraisalFillingDataService(AppraisalFillingDataService<AppraisalFillingData> appraisalFillingDataService) {
        this.appraisalFillingDataService = appraisalFillingDataService;
    }

    public CompetencyEvaluationMasterService<CompetencyEvaluationMaster> getCompetencyEvaluationMasterService() {
        return competencyEvaluationMasterService;
    }

    public void setCompetencyEvaluationMasterService(CompetencyEvaluationMasterService<CompetencyEvaluationMaster> competencyEvaluationMasterService) {
        this.competencyEvaluationMasterService = competencyEvaluationMasterService;
    }

    public CompetencyEvaluationTextmasterService<CompetencyEvaluationTextmaster> getCompetencyEvaluationTextmasterService() {
        return competencyEvaluationTextmasterService;
    }

    public void setCompetencyEvaluationTextmasterService(CompetencyEvaluationTextmasterService<CompetencyEvaluationTextmaster> competencyEvaluationTextmasterService) {
        this.competencyEvaluationTextmasterService = competencyEvaluationTextmasterService;
    }

    public AppraisalPerformanceCompetencyEvaluationService<AppraisalPerformanceCompetencyEvaluation> getAppraisalPerformanceCompetencyEvaluationService() {
        return appraisalPerformanceCompetencyEvaluationService;
    }

    public void setAppraisalPerformanceCompetencyEvaluationService(AppraisalPerformanceCompetencyEvaluationService<AppraisalPerformanceCompetencyEvaluation> appraisalPerformanceCompetencyEvaluationService) {
        this.appraisalPerformanceCompetencyEvaluationService = appraisalPerformanceCompetencyEvaluationService;
    }

    public AppraisalPerformanceIndividualDevelopmentPlanService<AppraisalPerformanceIndividualDevelopmentPlan> getAppraisalPerformanceIndividualDevelopmentPlanService() {
        return appraisalPerformanceIndividualDevelopmentPlanService;
    }

    public void setAppraisalPerformanceIndividualDevelopmentPlanService(AppraisalPerformanceIndividualDevelopmentPlanService<AppraisalPerformanceIndividualDevelopmentPlan> appraisalPerformanceIndividualDevelopmentPlanService) {
        this.appraisalPerformanceIndividualDevelopmentPlanService = appraisalPerformanceIndividualDevelopmentPlanService;
    }

    public AppraisalPerformanceBehaviorsService<AppraisalPerformanceBehaviors> getAppraisalPerformanceBehaviorsService() {
        return appraisalPerformanceBehaviorsService;
    }

    public void setAppraisalPerformanceBehaviorsService(AppraisalPerformanceBehaviorsService<AppraisalPerformanceBehaviors> appraisalPerformanceBehaviorsService) {
        this.appraisalPerformanceBehaviorsService = appraisalPerformanceBehaviorsService;
    }

    public KraCategoryService<KraCategory> getKraCategoryService() {
        return kraCategoryService;
    }

    public void setKraCategoryService(KraCategoryService<KraCategory> kraCategoryService) {
        this.kraCategoryService = kraCategoryService;
    }

    public AppraisalPerformanceActivitiesService<AppraisalPerformanceActivities> getAppraisalPerformanceActivitiesService() {
        return appraisalPerformanceActivitiesService;
    }

    public void setAppraisalPerformanceActivitiesService(AppraisalPerformanceActivitiesService<AppraisalPerformanceActivities> appraisalPerformanceActivitiesService) {
        this.appraisalPerformanceActivitiesService = appraisalPerformanceActivitiesService;
    }

    public UpdateAppraisalPerformanceActivitiesService<UpdateAppraisalPerformanceActivities> getUpdateAppraisalPerformanceActivitiesService() {
        return updateAppraisalPerformanceActivitiesService;
    }

    public void setUpdateAppraisalPerformanceActivitiesService(UpdateAppraisalPerformanceActivitiesService<UpdateAppraisalPerformanceActivities> updateAppraisalPerformanceActivitiesService) {
        this.updateAppraisalPerformanceActivitiesService = updateAppraisalPerformanceActivitiesService;
    }

    public AppraisalkraActivityService<AppraisalkraActivity> getAppraisalkraActivityService() {
        return appraisalkraActivityService;
    }

    public void setAppraisalkraActivityService(AppraisalkraActivityService<AppraisalkraActivity> appraisalkraActivityService) {
        this.appraisalkraActivityService = appraisalkraActivityService;
    }

    public PmpFormStatusMasterService<PmpFormStatusMaster> getPmpFormStatusMasterService() {
        return pmpFormStatusMasterService;
    }

    public void setPmpFormStatusMasterService(PmpFormStatusMasterService<PmpFormStatusMaster> pmpFormStatusMasterService) {
        this.pmpFormStatusMasterService = pmpFormStatusMasterService;
    }

    public void selectedEmployeeDate(HttpServletRequest request,
            HttpServletResponse response, String userid) throws Exception {
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        AppraisalPerformanceMaster appraisalPerformanceMaster = new AppraisalPerformanceMaster();
        //UserMaster user = (UserMaster) request.getSession().getAttribute("user");
        //UserRightMaster user1 = (UserRightMaster) request.getSession().getAttribute("userRight");
        UserMaster user = new UserMaster();
        user.setId(Integer.parseInt(userid));
        int reportingId = 0;

        employeeMaster.setUserMaster(user);
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

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String today = sdf.format(cal.getTime());

        Date now = sdf.parse(today);
        Calendar gc = new GregorianCalendar();

        int year = gc.get(Calendar.YEAR);
        String cyear = "" + year;
//        List<?> appraisalFilling = appraisalFillingDataService.readByCurrentYear(cyear);
        List<?> appraisalFilling = appraisalFillingDataService.getappraisalDate();

        if (!appraisalFilling.isEmpty()) {
            appraisalFillingData = (AppraisalFillingData) appraisalFilling.get(0);

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

//             //////////////////////Manager Time Line//////////////////////////////////////////
//            String ManagerStartDate = appraisalFillingData.getManagerStartDate();
//            String ManagerEndDate = appraisalFillingData.getManagerEndDate();
//            String ManagerMidDate = appraisalFillingData.getManagerMidYearStartDate();
//            String ManagerMidEndDate = appraisalFillingData.getManagerMidYearEndDate();
//            String ManagerYearEndStartDate = appraisalFillingData.getManagerYearEndStartDate();
//            String ManagerYearEndDate = appraisalFillingData.getManagerMidYearEndDate();
//
//            Date managerstrDate = sdf.parse(ManagerStartDate);
//            Date managerendDate = sdf.parse(EndDate);
//            Date managermidDate = sdf.parse(MidDate);
//            Date managermidEndDate = sdf.parse(MidEndDate);
//            Date manageryearEndStartDate = sdf.parse(YearEndStartDate);
//            Date manageryearEndDate = sdf.parse(YearEndDate);
//
////            boolean flag = false;
////            boolean flag1 = false;
////            boolean flag2 = false;
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

    }

    public void managerTimeLineDate(HttpServletRequest request,
            HttpServletResponse response, String userid) throws Exception {
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        AppraisalPerformanceMaster appraisalPerformanceMaster = new AppraisalPerformanceMaster();
        //UserMaster user = (UserMaster) request.getSession().getAttribute("user");
        //UserRightMaster user1 = (UserRightMaster) request.getSession().getAttribute("userRight");
        UserMaster user = new UserMaster();
        user.setId(Integer.parseInt(userid));
        int reportingId = 0;

        employeeMaster.setUserMaster(user);
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

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String today = sdf.format(cal.getTime());

        Date now = sdf.parse(today);
        Calendar gc = new GregorianCalendar();

        int year = gc.get(Calendar.YEAR);
        String cyear = "" + year;
//        List<?> appraisalFilling = appraisalFillingDataService.readByCurrentYear(cyear);
        List<?> appraisalFilling = appraisalFillingDataService.getappraisalDate();

        if (!appraisalFilling.isEmpty()) {
            appraisalFillingData = (AppraisalFillingData) appraisalFilling.get(0);

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
//            if ((now.after(strDate) && now.before(eDate)) || now.equals(strDate) || now.equals(eDate)) {
//                flag = true;
//            } else if ((now.after(midDate) && now.before(midEndDate)) || now.equals(midDate) || now.equals(midEndDate)) {
//                flag1 = true;
//            } else if ((now.after(yearEndStartDate) && now.before(yearEndDate)) || now.equals(yearEndStartDate) || now.equals(yearEndDate)) {
//                flag2 = true;
//            }

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

//            boolean flag = false;
//            boolean flag1 = false;
//            boolean flag2 = false;
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

    }

    protected void competencyList(HttpServletRequest request) {
        CompetencyEvaluationMaster competencyEvaluationMaster = new CompetencyEvaluationMaster();
        List<?> competencyList = competencyEvaluationMasterService.read();
        Map<Integer, String> dm = new HashMap<>();
        for (Object o : competencyList) {
            competencyEvaluationMaster = (CompetencyEvaluationMaster) o;
            dm.put(competencyEvaluationMaster.getId(), competencyEvaluationMaster.getTitle());
        }

        request.setAttribute("competencyMap", dm);
    }

    public void selectedDateflage(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
//        EmployeeMaster employeeMaster = new EmployeeMaster();
//        EmployeeMaster employeeMaster1 = new EmployeeMaster();
//        AppraisalPerformanceMaster appraisalPerformanceMaster = new AppraisalPerformanceMaster();
//        //UserMaster user = (UserMaster) request.getSession().getAttribute("user");
//        //UserRightMaster user1 = (UserRightMaster) request.getSession().getAttribute("userRight");
//        UserMaster user = new UserMaster();
//        user.setId(Integer.parseInt(userid));
//        int reportingId = 0;
//
//        employeeMaster.setUserMaster(user);
//        List<?> empDetailList = employeeMasterService.readEmployeeDetailUserIdWise(employeeMaster);
//        if (!empDetailList.isEmpty()) {
//            request.setAttribute("employeeMaster", empDetailList.get(0));
//            Object[] arrayOfObject = (Object[]) empDetailList.get(0);
//            String reportmanager = (String) arrayOfObject[6];
//            if (!reportmanager.equals("")) {
//                reportingId = Integer.parseInt(reportmanager);
//            }
//
//            employeeMaster1.setId(reportingId);
//        }
//        List<?> reportmanager1 = employeeMasterService.readByReportManager(employeeMaster1);
//        if (!reportmanager1.isEmpty()) {
//            employeeMaster1 = (EmployeeMaster) reportmanager1.get(0);
//            request.setAttribute("reportingManager", employeeMaster1.getEmployeeName());
//        }
//
//        List<?> empId = employeeMasterService.readByUserName(employeeMaster);
//        if (!empId.isEmpty()) {
//            employeeMaster = (EmployeeMaster) empId.get(0);
//        }
//        appraisalPerformanceMaster.setEmployeeMaster(employeeMaster);
        AppraisalFillingData appraisalFillingData = new AppraisalFillingData();

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String today = sdf.format(cal.getTime());

        Date now = sdf.parse(today);
        Calendar gc = new GregorianCalendar();

        int year = gc.get(Calendar.YEAR);
        String cyear = "" + year;
//        List<?> appraisalFilling = appraisalFillingDataService.readByCurrentYear(cyear);
        List<?> appraisalFilling = appraisalFillingDataService.getappraisalDate();

        if (!appraisalFilling.isEmpty()) {
            appraisalFillingData = (AppraisalFillingData) appraisalFilling.get(0);

            String StartDate = appraisalFillingData.getStartDate();
            String EndDate = appraisalFillingData.getEndDate();
            String MidDate = appraisalFillingData.getMidYearStartDate();
            String MidEndDate = appraisalFillingData.getMidYearEndDate();
            String YearEndStartDate = appraisalFillingData.getYearEndStartDate();
            String YearEndDate = appraisalFillingData.getMidYearEndDate();
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

    }

    protected void kraCategoryList(HttpServletRequest request) {
        KraCategory kraCategory = new KraCategory();
        List<?> kraCategoryList = kraCategoryService.read();
        Map<Integer, String> dm = new HashMap<>();
        for (Object o : kraCategoryList) {
            kraCategory = (KraCategory) o;
            dm.put(kraCategory.getId(), kraCategory.getKraCategoryName());
        }

        request.setAttribute("kraCategoryMap", dm);
    }

    public void department(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        List<?> deptList = departmentMasterService.read();
        String tempStr = "[";
        boolean flag = false;
        for (Iterator<? extends Object> it = deptList.iterator(); it.hasNext();) {
            DepartmentMaster departmentMaster = (DepartmentMaster) it.next();

            if (flag) {
                tempStr += ", ";
            }
            flag = true;
            tempStr += "{id: \"" + departmentMaster.getId()
                    + "\", name: \"" + departmentMaster.getDepartmentName()
                    + "\"}";

        }
        tempStr += "]";

        request.setAttribute("departmentList", tempStr);
    }

    public void timeLineDate(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        AppraisalFillingData appraisalFillingData = new AppraisalFillingData();

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String today = sdf.format(cal.getTime());

        Date now = sdf.parse(today);
        Calendar gc = new GregorianCalendar();

        int year = gc.get(Calendar.YEAR);
        String cyear = "" + year;
//        List<?> appraisalFilling = appraisalFillingDataService.readByCurrentYear(cyear);
        List<?> appraisalFilling = appraisalFillingDataService.getappraisalDate();

        if (!appraisalFilling.isEmpty()) {
            appraisalFillingData = (AppraisalFillingData) appraisalFilling.get(0);

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
            boolean flag1 = false;
            boolean flag2 = false;
            boolean flag3 = false;
            boolean flag4 = false;
            boolean flag5 = false;
            boolean flag6 = false;
            if ((now.after(strDate) && now.before(eDate)) || now.equals(strDate) || now.equals(eDate)) {
                flag1 = true;
            } else if ((now.after(midDate) && now.before(midEndDate)) || now.equals(midDate) || now.equals(midEndDate)) {
                flag2 = true;
            } else if ((now.after(yearEndStartDate) && now.before(yearEndDate)) || now.equals(yearEndStartDate) || now.equals(yearEndDate)) {
                flag3 = true;
            }

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

//            boolean flag = false;
//            boolean flag1 = false;
//            boolean flag2 = false;
            if ((now.after(managerstrDate) && now.before(managerendDate)) || now.equals(managerstrDate) || now.equals(managerendDate)) {
                flag4 = true;
            } else if ((now.after(managermidDate) && now.before(managermidEndDate)) || now.equals(managermidDate) || now.equals(managermidEndDate)) {
                flag5 = true;
            } else if ((now.after(manageryearEndStartDate) && now.before(manageryearEndDate)) || now.equals(manageryearEndStartDate) || now.equals(manageryearEndDate)) {
                flag6 = true;
            }

            request.setAttribute("flag1", flag1);
            request.setAttribute("flag2", flag2);
            request.setAttribute("flag3", flag3);
            request.setAttribute("flag4", flag4);
            request.setAttribute("flag5", flag5);
            request.setAttribute("flag6", flag6);

        }
    }

    public void empDateStartToEnd(HttpServletRequest request, HttpServletResponse response) throws Exception {
        AppraisalFillingData appraisalFillingData = new AppraisalFillingData();

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String today = sdf.format(cal.getTime());

        Date now = sdf.parse(today);
        Calendar gc = new GregorianCalendar();

        int year = gc.get(Calendar.YEAR);
        String cyear = "" + year;
//        List<?> appraisalFilling = appraisalFillingDataService.readByCurrentYear(cyear);
        List<?> appraisalFilling = appraisalFillingDataService.getappraisalDate();

        if (!appraisalFilling.isEmpty()) {
            appraisalFillingData = (AppraisalFillingData) appraisalFilling.get(0);

            String StartDate = appraisalFillingData.getStartDate();
            //String EndDate = appraisalFillingData.getEndDate();
            //String MidDate = appraisalFillingData.getMidYearStartDate();
            //String MidEndDate = appraisalFillingData.getMidYearEndDate();
            //String YearEndStartDate = appraisalFillingData.getYearEndStartDate();
            String YearEndDate = appraisalFillingData.getYearEndEndDate();
            Date strDate = sdf.parse(StartDate);
            // Date eDate = sdf.parse(EndDate);
            //Date midDate = sdf.parse(MidDate);
            //Date midEndDate = sdf.parse(MidEndDate);
            // Date yearEndStartDate = sdf.parse(YearEndStartDate);
            Date yearEndDate = sdf.parse(YearEndDate);
            boolean Tflag = false;
            boolean flag1 = false;
            boolean flag2 = false;
            if ((now.after(strDate) && now.before(yearEndDate) || now.equals(strDate) || now.equals(yearEndDate))) {
                Tflag = true;
            }
//            if ((now.after(strDate) && now.before(eDate)) || now.equals(strDate) || now.equals(eDate)) {
//                flag = true;
//            } else if ((now.after(midDate) && now.before(midEndDate)) || now.equals(midDate) || now.equals(midEndDate)) {
//                flag1 = true;
//            } else if ((now.after(yearEndStartDate) && now.before(yearEndDate)) || now.equals(yearEndStartDate) || now.equals(yearEndDate)) {
//                flag2 = true;
//            }

            request.setAttribute("Tflag", Tflag);
//            request.setAttribute("flag1", flag1);
//            request.setAttribute("flag2", flag2);

        }
    }

    public void managerDateStartToEnd(HttpServletRequest request, HttpServletResponse response) throws Exception {
        AppraisalFillingData appraisalFillingData = new AppraisalFillingData();

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String today = sdf.format(cal.getTime());

        Date now = sdf.parse(today);
        Calendar gc = new GregorianCalendar();

        int year = gc.get(Calendar.YEAR);
        String cyear = "" + year;
//        List<?> appraisalFilling = appraisalFillingDataService.readByCurrentYear(cyear);
        List<?> appraisalFilling = appraisalFillingDataService.getappraisalDate();

        if (!appraisalFilling.isEmpty()) {
            appraisalFillingData = (AppraisalFillingData) appraisalFilling.get(0);

            boolean Tflag = false;
            boolean flag1 = false;
            boolean flag2 = false;

            //////////////////////Manager Time Line//////////////////////////////////////////
            String ManagerStartDate = appraisalFillingData.getManagerStartDate();
            String ManagerEndDate = appraisalFillingData.getManagerEndDate();
            String ManagerMidDate = appraisalFillingData.getManagerMidYearStartDate();
            String ManagerMidEndDate = appraisalFillingData.getManagerMidYearEndDate();
            String ManagerYearEndStartDate = appraisalFillingData.getManagerYearEndStartDate();
            String ManagerYearEndDate = appraisalFillingData.getManagerYearEndEndDate();

            Date managerstrDate = sdf.parse(ManagerStartDate);
//            Date managerendDate = sdf.parse(ManagerEndDate);
//            Date managermidDate = sdf.parse(ManagerMidDate);
//            Date managermidEndDate = sdf.parse(ManagerMidEndDate);
//            Date manageryearEndStartDate = sdf.parse(ManagerYearEndStartDate);
            Date manageryearEndDate = sdf.parse(ManagerYearEndDate);

//            boolean flag = false;
//            boolean flag1 = false;
//            boolean flag2 = false;
            if ((now.after(managerstrDate) && now.before(manageryearEndDate)) || now.equals(managerstrDate) || now.equals(manageryearEndDate)) {
                Tflag = true;
            }

            request.setAttribute("Tflag", Tflag);

        }
    }

    public void mailSendPmpStartHalfapply(HttpServletRequest request) throws Exception {

        try {
            EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
            EmployeeMaster employeeMasterHr = employeeMasterService.readById(Integer.parseInt(employeeMasterModel.getReportingManagerLevel1()));
            DesignationMaster designationMaster = new DesignationMaster();
            designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
            EmployeeMaster employeeMaster2 = new EmployeeMaster();
            EmailTemplate emailTemplate1 = new EmailTemplate();
            // id =7 for approve leave request...
            emailTemplate1 = emailTemplateService.readById(113);
            int empID = employeeMasterModel.getId();
            employeeMaster2 = employeeMasterService.readById(empID);

            String name = "PMP";
            EmailAddMaster emailAddMaster = new EmailAddMaster();
            emailAddMaster.setModuleName(name);
            emailAddMaster.setDepartmentMaster(employeeMaster2.getDepartmentMaster());
            List<?> emailSendList = emailAddMasterService.readByName(emailAddMaster);
            if (!emailSendList.isEmpty()) {
                EmailAddMaster emailAddMaster1 = (EmailAddMaster) emailSendList.get(0);
                String emailId = emailAddMaster1.getEmailId();
                for (String emailId1 : emailId.split(",")) {
                    if (!emailId1.equals("")) {
                        String To1 = emailId1;
                        String from1 = employeeMasterModel.getOfficeEmailId();
                        String subject1 = emailTemplate1.getSubject();
                        subject1 = subject1.replaceAll("\\{user\\}", employeeMasterModel.getEmployeeName());
                        String msg1 = emailTemplate1.getBodytext();
                        msg1 = msg1.replaceAll("\\{to_user\\}", employeeMasterHr.getEmployeeName());
                        msg1 = msg1.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                        msg1 = msg1.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                        sendMail.sendMail(from1, To1, subject1, msg1);
                    }
                }
            }
            List<?> allDeptmailList = emailAddMasterService.readAllDept(name);
            if (!allDeptmailList.isEmpty()) {
                EmailAddMaster emailAddMaster1 = (EmailAddMaster) allDeptmailList.get(0);
                String emailId = emailAddMaster1.getEmailId();
                for (String emailId1 : emailId.split(",")) {
                    if (!emailId1.equals("")) {
                        String To1 = emailId1;
                        String from1 = employeeMasterModel.getOfficeEmailId();
                        String subject1 = emailTemplate1.getSubject();
                        subject1 = subject1.replaceAll("\\{user\\}", employeeMasterModel.getEmployeeName());
                        String msg1 = emailTemplate1.getBodytext();
                        msg1 = msg1.replaceAll("\\{to_user\\}", employeeMasterHr.getEmployeeName());
                        msg1 = msg1.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                        msg1 = msg1.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                        sendMail.sendMail(from1, To1, subject1, msg1);
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    public void mailSendPmpMidHalfapply(HttpServletRequest request) throws Exception {

        try {
            EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
            EmployeeMaster employeeMasterHr = employeeMasterService.readById(Integer.parseInt(employeeMasterModel.getReportingManagerLevel1()));
            DesignationMaster designationMaster = new DesignationMaster();
            designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
            EmployeeMaster employeeMaster2 = new EmployeeMaster();
            EmailTemplate emailTemplate1 = new EmailTemplate();
            // id =7 for approve leave request...
            emailTemplate1 = emailTemplateService.readById(114);
            int empID = employeeMasterModel.getId();
            employeeMaster2 = employeeMasterService.readById(empID);

            String name = "PMP";
            EmailAddMaster emailAddMaster = new EmailAddMaster();
            emailAddMaster.setModuleName(name);
            emailAddMaster.setDepartmentMaster(employeeMaster2.getDepartmentMaster());
            List<?> emailSendList = emailAddMasterService.readByName(emailAddMaster);
            if (!emailSendList.isEmpty()) {
                EmailAddMaster emailAddMaster1 = (EmailAddMaster) emailSendList.get(0);
                String emailId = emailAddMaster1.getEmailId();
                for (String emailId1 : emailId.split(",")) {
                    if (!emailId1.equals("")) {
                        String To1 = emailId1;
                        String from1 = employeeMasterModel.getOfficeEmailId();
                        String subject1 = emailTemplate1.getSubject();
                        subject1 = subject1.replaceAll("\\{user\\}", employeeMasterModel.getEmployeeName());
                        String msg1 = emailTemplate1.getBodytext();
                        msg1 = msg1.replaceAll("\\{to_user\\}", employeeMasterHr.getEmployeeName());
                        msg1 = msg1.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                        msg1 = msg1.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                        sendMail.sendMail(from1, To1, subject1, msg1);
                    }
                }
            }
            List<?> allDeptmailList = emailAddMasterService.readAllDept(name);
            if (!allDeptmailList.isEmpty()) {
                EmailAddMaster emailAddMaster1 = (EmailAddMaster) allDeptmailList.get(0);
                String emailId = emailAddMaster1.getEmailId();
                for (String emailId1 : emailId.split(",")) {
                    if (!emailId1.equals("")) {
                        String To1 = emailId1;
                        String from1 = employeeMasterModel.getOfficeEmailId();
                        String subject1 = emailTemplate1.getSubject();
                        subject1 = subject1.replaceAll("\\{user\\}", employeeMasterModel.getEmployeeName());
                        String msg1 = emailTemplate1.getBodytext();
                        msg1 = msg1.replaceAll("\\{to_user\\}", employeeMasterHr.getEmployeeName());
                        msg1 = msg1.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                        msg1 = msg1.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                        sendMail.sendMail(from1, To1, subject1, msg1);
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    public void mailSendPmpEndHalfapply(HttpServletRequest request) throws Exception {

        try {
            EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
            EmployeeMaster employeeMasterHr = employeeMasterService.readById(Integer.parseInt(employeeMasterModel.getReportingManagerLevel1()));
            DesignationMaster designationMaster = new DesignationMaster();
            designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
            EmployeeMaster employeeMaster2 = new EmployeeMaster();
            EmailTemplate emailTemplate1 = new EmailTemplate();
            // id =7 for approve leave request...
            emailTemplate1 = emailTemplateService.readById(115);
            int empID = employeeMasterModel.getId();
            employeeMaster2 = employeeMasterService.readById(empID);

            String name = "PMP";
            EmailAddMaster emailAddMaster = new EmailAddMaster();
            emailAddMaster.setModuleName(name);
            emailAddMaster.setDepartmentMaster(employeeMaster2.getDepartmentMaster());
            List<?> emailSendList = emailAddMasterService.readByName(emailAddMaster);
            if (!emailSendList.isEmpty()) {
                EmailAddMaster emailAddMaster1 = (EmailAddMaster) emailSendList.get(0);
                String emailId = emailAddMaster1.getEmailId();
                for (String emailId1 : emailId.split(",")) {
                    if (!emailId1.equals("")) {
                        String To1 = emailId1;
                        String from1 = employeeMasterModel.getOfficeEmailId();
                        String subject1 = emailTemplate1.getSubject();
                        subject1 = subject1.replaceAll("\\{user\\}", employeeMasterModel.getEmployeeName());
                        String msg1 = emailTemplate1.getBodytext();
                        msg1 = msg1.replaceAll("\\{to_user\\}", employeeMasterHr.getEmployeeName());
                        msg1 = msg1.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                        msg1 = msg1.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                        sendMail.sendMail(from1, To1, subject1, msg1);
                    }
                }
            }
            List<?> allDeptmailList = emailAddMasterService.readAllDept(name);
            if (!allDeptmailList.isEmpty()) {
                EmailAddMaster emailAddMaster1 = (EmailAddMaster) allDeptmailList.get(0);
                String emailId = emailAddMaster1.getEmailId();
                for (String emailId1 : emailId.split(",")) {
                    if (!emailId1.equals("")) {
                        String To1 = emailId1;
                        String from1 = employeeMasterModel.getOfficeEmailId();
                        String subject1 = emailTemplate1.getSubject();
                        subject1 = subject1.replaceAll("\\{user\\}", employeeMasterModel.getEmployeeName());
                        String msg1 = emailTemplate1.getBodytext();
                        msg1 = msg1.replaceAll("\\{to_user\\}", employeeMasterHr.getEmployeeName());
                        msg1 = msg1.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                        msg1 = msg1.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                        sendMail.sendMail(from1, To1, subject1, msg1);
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    protected void pmpyearList(HttpServletRequest request) {
        AppraisalFillingData appraisalFillingData = new AppraisalFillingData();
//        List<?> pmpyearList = appraisalFillingDataService.getCurrentAndPreviousYear();
        List<?> pmpyearList = appraisalFillingDataService.read();
        Map<Integer, String> dm = new HashMap<>();
        for (Object o : pmpyearList) {
            appraisalFillingData = (AppraisalFillingData) o;
            dm.put(appraisalFillingData.getId(), appraisalFillingData.getYear());
        }

        request.setAttribute("pmpyearList", dm);
    }
}
