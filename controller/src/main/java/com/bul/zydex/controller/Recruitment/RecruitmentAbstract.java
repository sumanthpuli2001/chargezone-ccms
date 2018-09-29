/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Recruitment;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.ApprovalUser;
import com.bul.zydex.model.CandidateAcademicQualification;
import com.bul.zydex.model.CandidateApplyJob;
import com.bul.zydex.model.CandidateApplyJob2;
import com.bul.zydex.model.CandidateExperienceDetail;
import com.bul.zydex.model.CandidateF2FRequest;
import com.bul.zydex.model.CandidateFamilyBackground;
import com.bul.zydex.model.CandidateJobApplication;
import com.bul.zydex.model.CandidateOtherReferences;
import com.bul.zydex.model.DepartmentMaster;
import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.JobtypeMaster;
import com.bul.zydex.model.LocationMaster;
import com.bul.zydex.model.MprApproval;
import com.bul.zydex.model.MprApprovalHistory;
import com.bul.zydex.model.MprEmployeeCategory;
import com.bul.zydex.model.MprEmployeeTypeMaster;
import com.bul.zydex.model.MprMaster;
import com.bul.zydex.model.QuestionPaper;
import com.bul.zydex.model.QulificationMaster;
import com.bul.zydex.model.RecruitmentApprovalHistory;
//import com.bul.zydex.model.RecruitmentMaster;
import com.bul.zydex.model.RecruitmentMaster;
import com.bul.zydex.model.RecruitmentMppApproval;
import com.bul.zydex.model.VacancyApprovalHistory;
import com.bul.zydex.model.VacancyMaster;
import com.bul.zydex.service.Approval.ApprovalUserService;
import com.bul.zydex.service.CandidateF2FRequest.CandidateF2FRequestService;
import com.bul.zydex.service.CandidateJobApply.CandidateAcademicQualificationService;
import com.bul.zydex.service.CandidateJobApply.CandidateApplyJob2Service;
import com.bul.zydex.service.CandidateJobApply.CandidateExperienceDetailService;
import com.bul.zydex.service.CandidateJobApply.CandidateFamilyBackgroundService;
import com.bul.zydex.service.CandidateJobApply.CandidateJobApplyService;
import com.bul.zydex.service.CandidateJobApply.CandidateOtherReferencesService;
import com.bul.zydex.service.MprApproval.MprApprovalService;
import com.bul.zydex.service.Recruitment.CandidateJobApplicationService;
import com.bul.zydex.service.Recruitment.JobtypeMasterService;
import com.bul.zydex.service.Recruitment.MprEmployeeCategoryService;
import com.bul.zydex.service.Recruitment.MprEmployeeTypeMasterService;
import com.bul.zydex.service.Recruitment.MprMasterService;
import com.bul.zydex.service.Recruitment.QulificationMasterService;
import com.bul.zydex.service.Recruitment.RecruitmentService;
import com.bul.zydex.service.RecruitmentApprovalHistory.MprApprovalHistoryService;
import com.bul.zydex.service.RecruitmentApprovalHistory.RecruitmentApprovalHistoryService;
import com.bul.zydex.service.RecruitmentMppApproval.RecruitmentMppApprovalService;
import com.bul.zydex.service.Vacancy.VacancyApprovalHistoryService;
import com.bul.zydex.service.Vacancy.VacancyMasterService;
import com.bul.zydex.service.emp.DesignationMasterService;
import com.bul.zydex.service.location.LocationMasterService;
import com.bul.zydex.service.questionlibrary.QuestionPaperService;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.Validator;

/**
 *
 * @author Vikas
 */
public class RecruitmentAbstract extends CustomAbstract {

    protected RecruitmentService<RecruitmentMaster> recruitmentService;
    protected LocationMasterService<LocationMaster> locationMasterService;
    protected JobtypeMasterService<JobtypeMaster> jobtypeMasterService;
    protected Validator recruitmentValidator;
    protected Validator mprValidator;
    protected MprMasterService<MprMaster> mprMasterService;
    protected DesignationMasterService<DesignationMaster> designationMasterService;
    protected CandidateJobApplyService<CandidateApplyJob> candidateJobApplyService;
    protected MprApprovalService<MprApproval> mprApprovalService;
    protected ApprovalUserService<ApprovalUser> approvalUserService;
    protected QuestionPaperService<QuestionPaper> questionPaperService;
    protected RecruitmentMppApprovalService<RecruitmentMppApproval> recruitmentMppApprovalService;
    protected CandidateJobApplicationService<CandidateJobApplication> candidateJobApplicationService;
    protected VacancyMasterService<VacancyMaster> vacancyMasterService;
    protected RecruitmentApprovalHistoryService<RecruitmentApprovalHistory> recruitmentApprovalHistoryService;
    protected MprApprovalHistoryService<MprApprovalHistory> mprApprovalHistoryService;
    protected CandidateApplyJob2Service<CandidateApplyJob2> candidateApplyJob2Service;
    protected CandidateAcademicQualificationService<CandidateAcademicQualification> candidateAcademicQualificationService;
    protected CandidateFamilyBackgroundService<CandidateFamilyBackground> candidateFamilyBackgroundService;
    protected CandidateExperienceDetailService<CandidateExperienceDetail> candidateExperienceDetailService;
    protected CandidateOtherReferencesService<CandidateOtherReferences> candidateOtherReferencesService;
    protected VacancyApprovalHistoryService<VacancyApprovalHistory> vacancyApprovalHistoryService;
    protected CandidateF2FRequestService<CandidateF2FRequest> candidateF2FRequestService;

    public CandidateApplyJob2Service<CandidateApplyJob2> getCandidateApplyJob2Service() {
        return candidateApplyJob2Service;
    }

    public void setCandidateApplyJob2Service(CandidateApplyJob2Service<CandidateApplyJob2> candidateApplyJob2Service) {
        this.candidateApplyJob2Service = candidateApplyJob2Service;
    }

    public CandidateAcademicQualificationService<CandidateAcademicQualification> getCandidateAcademicQualificationService() {
        return candidateAcademicQualificationService;
    }

    public void setCandidateAcademicQualificationService(CandidateAcademicQualificationService<CandidateAcademicQualification> candidateAcademicQualificationService) {
        this.candidateAcademicQualificationService = candidateAcademicQualificationService;
    }

    public CandidateFamilyBackgroundService<CandidateFamilyBackground> getCandidateFamilyBackgroundService() {
        return candidateFamilyBackgroundService;
    }

    public void setCandidateFamilyBackgroundService(CandidateFamilyBackgroundService<CandidateFamilyBackground> candidateFamilyBackgroundService) {
        this.candidateFamilyBackgroundService = candidateFamilyBackgroundService;
    }

    public CandidateExperienceDetailService<CandidateExperienceDetail> getCandidateExperienceDetailService() {
        return candidateExperienceDetailService;
    }

    public void setCandidateExperienceDetailService(CandidateExperienceDetailService<CandidateExperienceDetail> candidateExperienceDetailService) {
        this.candidateExperienceDetailService = candidateExperienceDetailService;
    }

    public CandidateOtherReferencesService<CandidateOtherReferences> getCandidateOtherReferencesService() {
        return candidateOtherReferencesService;
    }

    public void setCandidateOtherReferencesService(CandidateOtherReferencesService<CandidateOtherReferences> candidateOtherReferencesService) {
        this.candidateOtherReferencesService = candidateOtherReferencesService;
    }

    public MprMasterService<MprMaster> getMprMasterService() {
        return mprMasterService;
    }

    public void setDesignationMasterService(DesignationMasterService<DesignationMaster> designationMasterService) {
        this.designationMasterService = designationMasterService;
    }

    public DesignationMasterService<DesignationMaster> getDesignationMasterService() {
        return designationMasterService;
    }

    public void setMprMasterService(MprMasterService<MprMaster> mprMasterService) {
        this.mprMasterService = mprMasterService;
    }

    public Validator getRecruitmentValidator() {
        return recruitmentValidator;
    }

    public void setRecruitmentValidator(Validator recruitmentValidator) {
        this.recruitmentValidator = recruitmentValidator;
    }

    public Validator getMprValidator() {
        return mprValidator;
    }

    public void setMprValidator(Validator mprValidator) {
        this.mprValidator = mprValidator;
    }

    public RecruitmentService<RecruitmentMaster> getRecruitmentService() {
        return recruitmentService;
    }

    public void setRecruitmentService(RecruitmentService<RecruitmentMaster> recruitmentService) {
        this.recruitmentService = recruitmentService;
    }

    public JobtypeMasterService<JobtypeMaster> getJobtypeMasterService() {
        return jobtypeMasterService;
    }

    public void setJobtypeMasterService(JobtypeMasterService<JobtypeMaster> jobtypeMasterService) {
        this.jobtypeMasterService = jobtypeMasterService;
    }

    public LocationMasterService<LocationMaster> getLocationMasterService() {
        return locationMasterService;
    }

    public void setLocationMasterService(LocationMasterService<LocationMaster> locationMasterService) {
        this.locationMasterService = locationMasterService;
    }

    public CandidateJobApplyService<CandidateApplyJob> getCandidateJobApplyService() {
        return candidateJobApplyService;
    }

    public void setCandidateJobApplyService(CandidateJobApplyService<CandidateApplyJob> candidateJobApplyService) {
        this.candidateJobApplyService = candidateJobApplyService;
    }

    public MprApprovalService<MprApproval> getMprApprovalService() {
        return mprApprovalService;
    }

    public void setMprApprovalService(MprApprovalService<MprApproval> mprApprovalService) {
        this.mprApprovalService = mprApprovalService;
    }

    public ApprovalUserService<ApprovalUser> getApprovalUserService() {
        return approvalUserService;
    }

    public void setApprovalUserService(ApprovalUserService<ApprovalUser> approvalUserService) {
        this.approvalUserService = approvalUserService;
    }

    public QuestionPaperService<QuestionPaper> getQuestionPaperService() {
        return questionPaperService;
    }

    public void setQuestionPaperService(QuestionPaperService<QuestionPaper> questionPaperService) {
        this.questionPaperService = questionPaperService;
    }

    public RecruitmentMppApprovalService<RecruitmentMppApproval> getRecruitmentMppApprovalService() {
        return recruitmentMppApprovalService;
    }

    public void setRecruitmentMppApprovalService(RecruitmentMppApprovalService<RecruitmentMppApproval> recruitmentMppApprovalService) {
        this.recruitmentMppApprovalService = recruitmentMppApprovalService;
    }

    public CandidateJobApplicationService<CandidateJobApplication> getCandidateJobApplicationService() {
        return candidateJobApplicationService;
    }

    public void setCandidateJobApplicationService(CandidateJobApplicationService<CandidateJobApplication> candidateJobApplicationService) {
        this.candidateJobApplicationService = candidateJobApplicationService;
    }

    public VacancyMasterService<VacancyMaster> getVacancyMasterService() {
        return vacancyMasterService;
    }

    public void setVacancyMasterService(VacancyMasterService<VacancyMaster> vacancyMasterService) {
        this.vacancyMasterService = vacancyMasterService;
    }

    public RecruitmentApprovalHistoryService<RecruitmentApprovalHistory> getRecruitmentApprovalHistoryService() {
        return recruitmentApprovalHistoryService;
    }

    public void setRecruitmentApprovalHistoryService(RecruitmentApprovalHistoryService<RecruitmentApprovalHistory> recruitmentApprovalHistoryService) {
        this.recruitmentApprovalHistoryService = recruitmentApprovalHistoryService;
    }

    public MprApprovalHistoryService<MprApprovalHistory> getMprApprovalHistoryService() {
        return mprApprovalHistoryService;
    }

    public void setMprApprovalHistoryService(MprApprovalHistoryService<MprApprovalHistory> mprApprovalHistoryService) {
        this.mprApprovalHistoryService = mprApprovalHistoryService;
    }

    public VacancyApprovalHistoryService<VacancyApprovalHistory> getVacancyApprovalHistoryService() {
        return vacancyApprovalHistoryService;
    }

    public void setVacancyApprovalHistoryService(VacancyApprovalHistoryService<VacancyApprovalHistory> vacancyApprovalHistoryService) {
        this.vacancyApprovalHistoryService = vacancyApprovalHistoryService;
    }

    public CandidateF2FRequestService<CandidateF2FRequest> getCandidateF2FRequestService() {
        return candidateF2FRequestService;
    }

    public void setCandidateF2FRequestService(CandidateF2FRequestService<CandidateF2FRequest> candidateF2FRequestService) {
        this.candidateF2FRequestService = candidateF2FRequestService;
    }
    
    

    public void selectBudget(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        List<?> list = recruitmentService.readForBudgetDetail();
        String tempStr = "[";
        Object[] arrayOfObject;

        RecruitmentMaster recruitmentMaster;
        boolean flag = false;
        for (Iterator<? extends Object> it = list.iterator(); it.hasNext();) {
            arrayOfObject = (Object[]) it.next();

            if (flag) {
                tempStr += ", ";
            }
            flag = true;
            tempStr += "{id: \"" + arrayOfObject[0]
                    + "\", name: \"" + arrayOfObject[1]
                    + "  /" + arrayOfObject[2]
                    + "  /" + arrayOfObject[3] + "\"}";
//                    + "  /" + arrayOfObject[4]
//                    + "  /" + arrayOfObject[5] 

        }
        tempStr += "]";

        request.setAttribute("list", tempStr);
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

    public void selectMPRBudget(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        List<?> list = mprMasterService.readForMPRDetail();
        String tempStr = "[";
        Object[] arrayOfObject;

        MprMaster mprMaster;
        boolean flag = false;
        for (Iterator<? extends Object> it = list.iterator(); it.hasNext();) {
            arrayOfObject = (Object[]) it.next();

            if (flag) {
                tempStr += ", ";
            }
            flag = true;
            tempStr += "{id: \"" + arrayOfObject[0]
                    + "\", name: \"" + arrayOfObject[1]
                    + "  /" + arrayOfObject[2]
                    + "  /" + arrayOfObject[3] + "\"}";
//                    + "  /" + arrayOfObject[4]
//                    + "  /" + arrayOfObject[5] 

        }
        tempStr += "]";

        request.setAttribute("list", tempStr);
    }

    protected void questionList(HttpServletRequest request) {
        QuestionPaper questionPaper = new QuestionPaper();
        List<?> depttList = questionPaperService.read();
        Map<Integer, String> dm = new HashMap<>();
        for (Object o : depttList) {
            questionPaper = (QuestionPaper) o;
            dm.put(questionPaper.getId(), questionPaper.getPaperName());
        }

        request.setAttribute("questions", dm);
    }

}
