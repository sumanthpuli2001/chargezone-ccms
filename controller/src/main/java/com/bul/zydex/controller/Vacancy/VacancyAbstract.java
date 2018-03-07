/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Vacancy;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.ApplayJobUserMaster;
import com.bul.zydex.model.CandidateApplyJob;
import com.bul.zydex.model.DepartmentMaster;
import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.model.JobtypeMaster;
import com.bul.zydex.model.LocationMaster;
import com.bul.zydex.model.MprEmployeeCategory;
import com.bul.zydex.model.MprEmployeeTypeMaster;
import com.bul.zydex.model.MprMaster;
import com.bul.zydex.model.VacancyMaster;
import com.bul.zydex.service.ApplayJobUserMaster.ApplayJobUserMasterService;
import com.bul.zydex.service.CandidateJobApply.CandidateJobApplyService;
import com.bul.zydex.service.Recruitment.JobtypeMasterService;
import com.bul.zydex.service.Recruitment.MprEmployeeCategoryService;
import com.bul.zydex.service.Recruitment.MprEmployeeTypeMasterService;
import com.bul.zydex.service.Recruitment.MprMasterService;
import com.bul.zydex.service.Vacancy.VacancyMasterService;
import com.bul.zydex.service.emp.DesignationMasterService;
import com.bul.zydex.service.location.LocationMasterService;
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
