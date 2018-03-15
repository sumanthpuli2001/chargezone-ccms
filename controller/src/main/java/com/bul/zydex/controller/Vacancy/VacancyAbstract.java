/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Vacancy;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.ApplayJobUserMaster;
import com.bul.zydex.model.CandidateApplyJob;
import com.bul.zydex.model.CandidateJobApplication;
import com.bul.zydex.model.DepartmentMaster;
import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.model.JobtypeMaster;
import com.bul.zydex.model.LocationMaster;
import com.bul.zydex.model.MprEmployeeCategory;
import com.bul.zydex.model.MprEmployeeTypeMaster;
import com.bul.zydex.model.MprMaster;
import com.bul.zydex.model.OnlineAssessment;
import com.bul.zydex.model.QuestionAns;
import com.bul.zydex.model.QuestionAnswerSubmit;
import com.bul.zydex.model.QuestionDetails;
import com.bul.zydex.model.QuestionLibrary;
import com.bul.zydex.model.QuestionPaper;
import com.bul.zydex.model.VacancyMaster;
import com.bul.zydex.service.ApplayJobUserMaster.ApplayJobUserMasterService;
import com.bul.zydex.service.CandidateJobApply.CandidateJobApplyService;
import com.bul.zydex.service.QuestionAnswerSubmit.QuestionAnswerSubmitService;
import com.bul.zydex.service.Recruitment.CandidateJobApplicationService;
import com.bul.zydex.service.Recruitment.JobtypeMasterService;
import com.bul.zydex.service.Recruitment.MprEmployeeCategoryService;
import com.bul.zydex.service.Recruitment.MprEmployeeTypeMasterService;
import com.bul.zydex.service.Recruitment.MprMasterService;
import com.bul.zydex.service.Recruitment.OnlineAssessmentService;
import com.bul.zydex.service.Vacancy.VacancyMasterService;
import com.bul.zydex.service.emp.DesignationMasterService;
import com.bul.zydex.service.location.LocationMasterService;
import com.bul.zydex.service.questionlibrary.QuestionAnsService;
import com.bul.zydex.service.questionlibrary.QuestionDetailsService;
import com.bul.zydex.service.questionlibrary.QuestionLibraryService;
import com.bul.zydex.service.questionlibrary.QuestionPaperService;
import com.bul.zydex.validator.Recruitment.ApplayJobUserMasterValidator;
import com.bul.zydex.validator.Vacancy.CandidateJobApplyValidator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.validation.Validator;

/**
 *
 * @author Vikas
 */
public class VacancyAbstract extends CustomAbstract {

    protected VacancyMasterService<VacancyMaster> vacancyMasterService;
    protected LocationMasterService<LocationMaster> locationMasterService;
    protected JobtypeMasterService<JobtypeMaster> jobtypeMasterService;
    protected DesignationMasterService<DesignationMaster> designationMasterService;
    protected CandidateJobApplyService<CandidateApplyJob>candidateJobApplyService;
    protected Validator vacancyValidator;
    protected ApplayJobUserMasterService<ApplayJobUserMaster> applayJobUserMasterSerivce;
    protected ApplayJobUserMasterValidator applayJobUserMasterValidator;
    protected CandidateJobApplyValidator candidateJobApplyValidator;
    protected MprMasterService<MprMaster> mprMasterService;
    protected CandidateJobApplicationService<CandidateJobApplication> candidateJobApplicationService;
    protected OnlineAssessmentService<OnlineAssessment> onlineAssessmentService;
    protected QuestionPaperService<QuestionPaper> questionPaperService;
    protected QuestionDetailsService<QuestionDetails> questionDetailsService;
    protected QuestionLibraryService<QuestionLibrary> questionLibraryService;
    protected QuestionAnsService<QuestionAns> questionAnsService;
    protected QuestionAnswerSubmitService<QuestionAnswerSubmit> questionAnswerSubmitService;

    public CandidateJobApplyService<CandidateApplyJob> getCandidateJobApplyService() {
        return candidateJobApplyService;
    }

    public void setCandidateJobApplyService(CandidateJobApplyService<CandidateApplyJob> candidateJobApplyService) {
        this.candidateJobApplyService = candidateJobApplyService;
    }

    public VacancyMasterService<VacancyMaster> getVacancyMasterService() {
        return vacancyMasterService;
    }

    public void setVacancyMasterService(VacancyMasterService<VacancyMaster> vacancyMasterService) {
        this.vacancyMasterService = vacancyMasterService;
    }

    public LocationMasterService<LocationMaster> getLocationMasterService() {
        return locationMasterService;
    }

    public void setLocationMasterService(LocationMasterService<LocationMaster> locationMasterService) {
        this.locationMasterService = locationMasterService;
    }

    public JobtypeMasterService<JobtypeMaster> getJobtypeMasterService() {
        return jobtypeMasterService;
    }

    public void setJobtypeMasterService(JobtypeMasterService<JobtypeMaster> jobtypeMasterService) {
        this.jobtypeMasterService = jobtypeMasterService;
    }

    public void setDesignationMasterService(DesignationMasterService<DesignationMaster> designationMasterService) {
        this.designationMasterService = designationMasterService;
    }

    public DesignationMasterService<DesignationMaster> getDesignationMasterService() {
        return designationMasterService;
    }


    public Validator getVacancyValidator() {
        return vacancyValidator;
    }

    public void setVacancyValidator(Validator vacancyValidator) {
        this.vacancyValidator = vacancyValidator;
    }

    public ApplayJobUserMasterService<ApplayJobUserMaster> getApplayJobUserMasterSerivce() {
        return applayJobUserMasterSerivce;
    }

    public void setApplayJobUserMasterSerivce(ApplayJobUserMasterService<ApplayJobUserMaster> applayJobUserMasterSerivce) {
        this.applayJobUserMasterSerivce = applayJobUserMasterSerivce;
    }

    public ApplayJobUserMasterValidator getApplayJobUserMasterValidator() {
        return applayJobUserMasterValidator;
    }

    public void setApplayJobUserMasterValidator(ApplayJobUserMasterValidator applayJobUserMasterValidator) {
        this.applayJobUserMasterValidator = applayJobUserMasterValidator;
    }

    public CandidateJobApplyValidator getCandidateJobApplyValidator() {
        return candidateJobApplyValidator;
    }

    public void setCandidateJobApplyValidator(CandidateJobApplyValidator candidateJobApplyValidator) {
        this.candidateJobApplyValidator = candidateJobApplyValidator;
    }

    public MprMasterService<MprMaster> getMprMasterService() {
        return mprMasterService;
    }

    public void setMprMasterService(MprMasterService<MprMaster> mprMasterService) {
        this.mprMasterService = mprMasterService;
    }

    public CandidateJobApplicationService<CandidateJobApplication> getCandidateJobApplicationService() {
        return candidateJobApplicationService;
    }

    public void setCandidateJobApplicationService(CandidateJobApplicationService<CandidateJobApplication> candidateJobApplicationService) {
        this.candidateJobApplicationService = candidateJobApplicationService;
    }

    public OnlineAssessmentService<OnlineAssessment> getOnlineAssessmentService() {
        return onlineAssessmentService;
    }

    public void setOnlineAssessmentService(OnlineAssessmentService<OnlineAssessment> onlineAssessmentService) {
        this.onlineAssessmentService = onlineAssessmentService;
    }

    public QuestionPaperService<QuestionPaper> getQuestionPaperService() {
        return questionPaperService;
    }

    public void setQuestionPaperService(QuestionPaperService<QuestionPaper> questionPaperService) {
        this.questionPaperService = questionPaperService;
    }

    public QuestionDetailsService<QuestionDetails> getQuestionDetailsService() {
        return questionDetailsService;
    }

    public void setQuestionDetailsService(QuestionDetailsService<QuestionDetails> questionDetailsService) {
        this.questionDetailsService = questionDetailsService;
    }

    public QuestionLibraryService<QuestionLibrary> getQuestionLibraryService() {
        return questionLibraryService;
    }

    public void setQuestionLibraryService(QuestionLibraryService<QuestionLibrary> questionLibraryService) {
        this.questionLibraryService = questionLibraryService;
    }

    public QuestionAnsService<QuestionAns> getQuestionAnsService() {
        return questionAnsService;
    }

    public void setQuestionAnsService(QuestionAnsService<QuestionAns> questionAnsService) {
        this.questionAnsService = questionAnsService;
    }

    public QuestionAnswerSubmitService<QuestionAnswerSubmit> getQuestionAnswerSubmitService() {
        return questionAnswerSubmitService;
    }

    public void setQuestionAnswerSubmitService(QuestionAnswerSubmitService<QuestionAnswerSubmit> questionAnswerSubmitService) {
        this.questionAnswerSubmitService = questionAnswerSubmitService;
    }
    
    
    
    
    
    
    
    
    protected void departmentList(HttpServletRequest request) {
        DepartmentMaster departmentMaster = new DepartmentMaster();
        List<?> depttList = departmentMasterService.read();
        Map<Integer, String> dm = new HashMap<>();
        for (Object o : depttList) {
            departmentMaster = (DepartmentMaster) o;
            dm.put(departmentMaster.getId(), departmentMaster.getDepartmentName());
        }

        request.setAttribute("deptMap", dm);
    }

    protected Map<Integer, String> readLocations() {
        List locationList = locationMasterService.read();
        LocationMaster locationMaster = new LocationMaster();
        Map<Integer, String> locationMap = new HashMap<Integer, String>();
        for (Object o : locationList) {
            locationMaster = (LocationMaster) o;
            locationMap.put(locationMaster.getId(), locationMaster.getLocation());
        }

        return locationMap;
    }

    protected Map<Integer, String> jobtypeList() {
        List<?> jobtype = jobtypeMasterService.read();
        JobtypeMaster jobtypeMaster = new JobtypeMaster();
        Map<Integer, String> jobtype1 = new HashMap<Integer, String>();
        for (Object o : jobtype) {
            jobtypeMaster = (JobtypeMaster) o;
            jobtype1.put(jobtypeMaster.getId(), jobtypeMaster.getJobTypeName());
        }
        return jobtype1;
    }

    protected void designationList(HttpServletRequest request) {
        DesignationMaster designationMaster = new DesignationMaster();
        List<?> desigList = designationMasterService.read();
        Map<Integer, String> dn = new HashMap<>();
        for (Object o : desigList) {
            designationMaster = (DesignationMaster) o;
            dn.put(designationMaster.getId(), designationMaster.getDesignationName());
        }

        request.setAttribute("desigList", dn);
    }


}
