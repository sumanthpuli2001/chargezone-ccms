/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Vacancy;

import com.bul.zydex.model.ApplayJobUserMaster;
import com.bul.zydex.model.ApprovalUser;
import com.bul.zydex.model.CandidateAcademicQualification;
import com.bul.zydex.model.CandidateApplyJob;
import com.bul.zydex.model.CandidateApplyJob2;
import com.bul.zydex.model.CandidateExperienceDetail;
import com.bul.zydex.model.CandidateFamilyBackground;
import com.bul.zydex.model.CandidateJobApplication;
import com.bul.zydex.model.CandidateOtherReferences;
import com.bul.zydex.model.DepartmentMaster;
import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.model.EmailTemplate;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.JobtypeMaster;
import com.bul.zydex.model.LocationMaster;
import com.bul.zydex.model.MprEmployeeCategory;
import com.bul.zydex.model.MprEmployeeTypeMaster;
import com.bul.zydex.model.MprMaster;
import com.bul.zydex.model.OnlineAssessment;
import com.bul.zydex.model.QuestionAns;
import com.bul.zydex.model.QuestionAnswerSubmit;
import com.bul.zydex.model.QuestionLibrary;
import com.bul.zydex.model.RecruitmentApprovalHistory;
import com.bul.zydex.model.RecruitmentMaster;
import com.bul.zydex.model.RecruitmentMppApproval;
import com.bul.zydex.model.VacancyApproval;
import com.bul.zydex.model.VacancyApprovalHistory;
import com.bul.zydex.model.VacancyMaster;
import com.bul.zydex.util.DownloadFile;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.validation.BindException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Vikas
 */
public class VacancyController extends VacancyAbstract {

    public ModelAndView vacancyDetailList(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        VacancyMaster vacancyMaster = new VacancyMaster();
        List<?> vacancylist = vacancyMasterService.fetchCreatedVacancy(employeeMaster.getId());
        mv.getModelMap().put("list", vacancylist);
        mv.getModelMap().put("vacancyMaster", vacancyMaster);
        mv.setViewName("Vacancy/VacancyDetailReportList");
        return mv;
    }

    public ModelAndView applyJobRegistration(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        String vacancyId = request.getParameter("vacancyId");
        int vacId = Integer.parseInt(vacancyId);
        ModelAndView mv = new ModelAndView();
        CombinedCandidateClasses candidateClasses = new CombinedCandidateClasses();

        HttpSession session = request.getSession();
        ApplayJobUserMaster ajuMaster = (ApplayJobUserMaster) session.getAttribute("ApplayJobUserMaster");

        if (ajuMaster.getProfileSubmit() != 0) {

            List<CandidateApplyJob> candidateProfile = (List<CandidateApplyJob>) candidateJobApplyService.readProfileByCandidateUserID(ajuMaster.getId());
//        VacancyMaster master=
            List<?> CandidateJobApplyList = new ArrayList<>();
            if (!candidateProfile.isEmpty()) {
                CandidateApplyJob caj = (CandidateApplyJob) candidateProfile.get(0);
                CandidateJobApplication cja = candidateJobApplicationService.readByCandidateIdAndVacancyId(caj.getId(), vacId);
                cja.setStatus(1);
                candidateJobApplicationService.update(cja);

                CandidateJobApplyList = candidateJobApplicationService.readByCandidateId(caj.getId());

            }
            request.setAttribute("list", CandidateJobApplyList);
            mv.getModelMap().put("applayJobUserMaster", ajuMaster);
            mv.setViewName("Vacancy/MemberVacancyList");
            try {
                EmailTemplate emailTemplate = new EmailTemplate();
                emailTemplate = emailTemplateService.readById(160);
                String To = ajuMaster.getUserName();
                String Subject = emailTemplate.getSubject();
                String msg = emailTemplate.getBodytext();
                msg = msg.replaceAll("\\{to_user\\}", ajuMaster.getUserName());
                sendMail.sendMail("", To, Subject, msg);
            } catch (Exception e) {

            }
        } else {

            int canId = Integer.parseInt(request.getParameter("id"));
            String forward = "forward:vacancy.htm?act=myProfileClick&id=" + canId;
            mv.setViewName(forward);

//            CandidateApplyJob candidateApplyJob = new CandidateApplyJob();
//
////            mv.getModelMap().put("candidateApplyJob", candidateApplyJob);
//            mv.getModelMap().put("candidateApplyJob", candidateClasses.getCandidateApplyJob());
//            mv.setViewName("Vacancy/MyProfile");
        }
        return mv;

    }

    public ModelAndView newVacancyCreate(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        MprMaster mprMaster = new MprMaster();
        VacancyMaster vacancyMaster = new VacancyMaster();
        DepartmentMaster departmentMaster = new DepartmentMaster();
        LocationMaster locationMaster = new LocationMaster();
        JobtypeMaster jobtypeMaster = new JobtypeMaster();
        DesignationMaster designationMaster = new DesignationMaster();
        if (vacancyMaster.getId() != null) {
            vacancyMaster = vacancyMasterService.readById(vacancyMaster.getId());
            vacancyMaster.setLocationMaster(vacancyMaster.getLocationMaster());
            vacancyMaster.setDepartmentMaster(vacancyMaster.getDepartmentMaster());
            vacancyMaster.setJobtypeMaster(vacancyMaster.getJobtypeMaster());
            vacancyMaster.setDesignationMaster(vacancyMaster.getDesignationMaster());
        } else {
            vacancyMaster.setLocationMaster(new LocationMaster());
            vacancyMaster.setDepartmentMaster(new DepartmentMaster());
            vacancyMaster.setJobtypeMaster(new JobtypeMaster());
            vacancyMaster.setDesignationMaster(new DesignationMaster());
        }
        departmentList(request);
        designationList(request);
        Map<Integer, String> locationMap = readLocations();
        Map<Integer, String> jobtype1 = jobtypeList();
        mv.addObject("locationMap", locationMap);
        mv.addObject("jobtype1", jobtype1);
        vacancyMaster.setDepartmentMaster(new DepartmentMaster());
        vacancyMaster.setLocationMaster(new LocationMaster());
        vacancyMaster.setJobtypeMaster(new JobtypeMaster());
        vacancyMaster.setDesignationMaster(new DesignationMaster());
        String id = request.getParameter("id");
        mprMaster = mprMasterService.readById(Integer.parseInt(id));

        int jobtypeId = mprMaster.getJobtypeMaster().getId();
        jobtypeMaster = jobtypeMasterService.readById(jobtypeId);
        String jobtypeNAme = jobtypeMaster.getJobTypeName();

        int department = mprMaster.getDepartmentMaster().getId();
        departmentMaster = departmentMasterService.readById(department);
        String departmentName = departmentMaster.getDepartmentName();

        int localtion = mprMaster.getLocationMaster().getId();
        locationMaster = locationMasterService.readById(localtion);
        String locationName = locationMaster.getLocation();

        int designation = mprMaster.getDesignationMaster().getId();
        designationMaster = designationMasterService.readById(designation);
        String designationName = designationMaster.getDesignationName();

        String experiance = mprMaster.getExperience();
        String description = mprMaster.getDescription();
        String mprName = mprMaster.getName();
        int position = mprMaster.getNumberOfPosition();
        int budget = mprMaster.getBudget();

        mv.getModelMap().put("mprMaster", mprMaster);
        mv.getModelMap().put("departmentMaster", departmentMaster);
        mv.getModelMap().put("locationMaster", locationMaster);
        mv.getModelMap().put("jobtypeMaster", jobtypeMaster);
        mv.getModelMap().put("designationMaster", designationMaster);
        mv.getModelMap().put("vacancyMaster", vacancyMaster);
        request.setAttribute("jobtypeNAme", jobtypeNAme);
        request.setAttribute("departmentName", departmentName);
        request.setAttribute("locationName", locationName);
        request.setAttribute("position", position);
        request.setAttribute("designationName", designationName);
        request.setAttribute("experiance", experiance);
        request.setAttribute("budget", budget);
        request.setAttribute("description", description);
        request.setAttribute("mprName", mprName);
        mv.setViewName("Vacancy/CreateVacancy");
        return mv;
    }

    public ModelAndView vacancySubmitCreate(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        VacancyMaster vacancyMaster = new VacancyMaster();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date cDate = new Date();
        String id = request.getParameter("mprMasterid");
        DepartmentMaster departmentMaster = new DepartmentMaster();
        MprMaster mprMaster = new MprMaster();
        LocationMaster locationMaster = new LocationMaster();
        JobtypeMaster jobtypeMaster = new JobtypeMaster();
        DesignationMaster designationMaster = new DesignationMaster();
        MprEmployeeCategory mprEmployeeCategory = new MprEmployeeCategory();
        MprEmployeeTypeMaster employeeTypeMaster = new MprEmployeeTypeMaster();
        BindException errors = new BindException(vacancyMaster, "vacancyMaster");
        bind(request, vacancyMaster);

        mprMaster = mprMasterService.readById(Integer.parseInt(id));

        vacancyMaster.setMprMaster(mprMaster);

        int jobtype = mprMaster.getJobtypeMaster().getId();
        jobtypeMaster = jobtypeMasterService.readById(jobtype);
        vacancyMaster.setJobtypeMaster(jobtypeMaster);

        int department = mprMaster.getDepartmentMaster().getId();
        departmentMaster = departmentMasterService.readById(department);
        vacancyMaster.setDepartmentMaster(departmentMaster);

        int jobrole = mprMaster.getDesignationMaster().getId();
        designationMaster = designationMasterService.readById(jobrole);
        vacancyMaster.setDesignationMaster(designationMaster);

        String experiance = mprMaster.getExperience();
        vacancyMaster.setExperience(experiance);

        String description = mprMaster.getDescription();
        vacancyMaster.setDescription(description);

        int location = mprMaster.getLocationMaster().getId();
        locationMaster = locationMasterService.readById(location);
        vacancyMaster.setLocationMaster(locationMaster);

        int position = mprMaster.getNumberOfPosition();
        vacancyMaster.setNumberOfPosition(position);

//        selectBudget(request, response);
        departmentList(request);

        vacancyValidator.validate(vacancyMaster, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : All Fields Are Mandatorys");

            String jobtypeNAme = jobtypeMaster.getJobTypeName();

            String departmentName = departmentMaster.getDepartmentName();

            String locationName = locationMaster.getLocation();

            String designationName = designationMaster.getDesignationName();

            int budget = mprMaster.getBudget();

            mv.getModelMap().put("mprMaster", mprMaster);
            mv.getModelMap().put("departmentMaster", departmentMaster);
            mv.getModelMap().put("locationMaster", locationMaster);
            mv.getModelMap().put("jobtypeMaster", jobtypeMaster);
            mv.getModelMap().put("designationMaster", designationMaster);
            mv.getModelMap().put("vacancyMaster", vacancyMaster);
            request.setAttribute("jobtypeNAme", jobtypeNAme);
            request.setAttribute("departmentName", departmentName);
            request.setAttribute("locationName", locationName);
            request.setAttribute("position", position);
            request.setAttribute("designationName", designationName);
            request.setAttribute("experiance", experiance);
            request.setAttribute("budget", budget);
            mv.addAllObjects(errors.getModel());
            mv.setViewName("Vacancy/CreateVacancy");

        } else {
            vacancyMaster.setStatus(0);
            vacancyMaster.setCreatedBy(employeeMaster.getId());
            vacancyMaster.setCreatedDate(sdf.format(cDate));
            vacancyMasterService.create(vacancyMaster);
            request.setAttribute("successMessage",
                    "Information : The Information is Created Successfully.");

            mv = vacancyDetailList(request, response);
        }

        return mv;
    }

    public ModelAndView clickDeleteVacancy(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        String savingList[] = request.getParameterValues("checkId");
        for (String z : savingList) {
            try {

                CandidateJobApplication candidateJobApplication = new CandidateJobApplication();
                List<?> list = candidateJobApplicationService.deleteVacancyId(z);
                for (Object object : list) {
                    candidateJobApplication = (CandidateJobApplication) object;
                    candidateJobApplicationService.delete(candidateJobApplication.getId());
                }
                vacancyMasterService.delete(Integer.parseInt(z));
                request.setAttribute("successMessage",
                        "Info :The Records are deleted successfully.");
            } catch (Exception e) {

            }
        }
        mv = vacancyDetailList(request, response);
        return mv;
    }

    public ModelAndView showVacancyList(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        VacancyMaster vacancyMaster = new VacancyMaster();
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String date = sdf.format(d);
//        List<?> vacancylist = vacancyMasterService.fetchVacancyDetail();
        List<?> vacancylist = vacancyMasterService.fetchVacancyBydate(date);
        mv.getModelMap().put("list", vacancylist);
        mv.getModelMap().put("vacancyMaster", vacancyMaster);
        mv.setViewName("Vacancy/ShowVacancyList");
        return mv;
    }

    public ModelAndView viewVacancy(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        VacancyMaster vacancyMaster = new VacancyMaster();
        DepartmentMaster departmentMaster = new DepartmentMaster();
        LocationMaster locationMaster = new LocationMaster();
        JobtypeMaster jobtypeMaster = new JobtypeMaster();
        DesignationMaster designationMaster = new DesignationMaster();
        MprEmployeeCategory mprEmployeeCategory = new MprEmployeeCategory();
        MprEmployeeTypeMaster employeeTypeMaster = new MprEmployeeTypeMaster();

        departmentList(request);
        designationList(request);
        Map<Integer, String> locationMap = readLocations();
        Map<Integer, String> jobtype1 = jobtypeList();
        mv.addObject("locationMap", locationMap);
        mv.addObject("jobtype1", jobtype1);

        String id = request.getParameter("id");
        vacancyMaster = vacancyMasterService.readById(Integer.parseInt(id));
        mv.getModelMap().put("departmentMaster", departmentMaster);
        mv.getModelMap().put("locationMaster", locationMaster);
        mv.getModelMap().put("jobtypeMaster", jobtypeMaster);
        mv.getModelMap().put("designationMaster", designationMaster);
        mv.getModelMap().put("vacancyMaster", vacancyMaster);
        mv.setViewName("Vacancy/OutViewVacancy");

        return mv;
    }

    public ModelAndView viewEditVacancy(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        VacancyMaster vacancyMaster = new VacancyMaster();
        DepartmentMaster departmentMaster = new DepartmentMaster();
        LocationMaster locationMaster = new LocationMaster();
        JobtypeMaster jobtypeMaster = new JobtypeMaster();
        DesignationMaster designationMaster = new DesignationMaster();
        if (vacancyMaster.getId() != null) {
            vacancyMaster = vacancyMasterService.readById(vacancyMaster.getId());
            vacancyMaster.setLocationMaster(vacancyMaster.getLocationMaster());
            vacancyMaster.setDepartmentMaster(vacancyMaster.getDepartmentMaster());
            vacancyMaster.setJobtypeMaster(vacancyMaster.getJobtypeMaster());
            vacancyMaster.setDesignationMaster(vacancyMaster.getDesignationMaster());
        } else {
            vacancyMaster.setLocationMaster(new LocationMaster());
            vacancyMaster.setDepartmentMaster(new DepartmentMaster());
            vacancyMaster.setJobtypeMaster(new JobtypeMaster());
            vacancyMaster.setDesignationMaster(new DesignationMaster());
        }
        departmentList(request);
        designationList(request);
        Map<Integer, String> locationMap = readLocations();
        Map<Integer, String> jobtype1 = jobtypeList();
        mv.addObject("locationMap", locationMap);
        mv.addObject("jobtype1", jobtype1);

        String id = request.getParameter("id");
        List<?> HistoryList = vacancyApprovalHistoryService.readByVacancyId(Integer.parseInt(id));
        vacancyMaster = vacancyMasterService.readById(Integer.parseInt(id));
        mv.getModelMap().put("departmentMaster", departmentMaster);
        mv.getModelMap().put("locationMaster", locationMaster);
        mv.getModelMap().put("jobtypeMaster", jobtypeMaster);
        mv.getModelMap().put("designationMaster", designationMaster);
        mv.getModelMap().put("vacancyMaster", vacancyMaster);
        mv.getModelMap().put("list", HistoryList);
        mv.setViewName("Vacancy/ViewVecancy");
        return mv;
    }

    public ModelAndView editVacancy(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        VacancyMaster vacancyMaster = new VacancyMaster();
        VacancyApprovalHistory approvalHistory = new VacancyApprovalHistory();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        BindException errors = new BindException(vacancyMaster, "vacancyMaster");
        bind(request, vacancyMaster);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String comment = request.getParameter("comment");
        Date cDate = new Date();
        VacancyMaster vacancyMaster1 = vacancyMasterService.readById(vacancyMaster.getId());
        Map<Integer, String> locationMap = readLocations();
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Professional Tax is not valid.");
            mv.addAllObjects(errors.getModel());
        } else {

            vacancyMaster.setCreatedBy(vacancyMaster1.getCreatedBy());
            vacancyMaster.setCreatedDate(vacancyMaster1.getCreatedDate());
            vacancyMaster.setUpdatedBy(employeeMaster.getId());
            vacancyMaster.setUpdatedDate(sdf.format(cDate));
            vacancyMaster.setMprMaster(vacancyMaster1.getMprMaster());
            vacancyMaster.setStatus(0);
            vacancyMaster.setCurrentLevel(1);
            vacancyMaster.setTotalLevel(vacancyMaster1.getTotalLevel());
            vacancyMasterService.update(vacancyMaster);

            approvalHistory.setVacancyMaster(vacancyMaster);
            approvalHistory.setCreatedDate(sdf.format(cDate));
            approvalHistory.setCreatedBy(employeeMaster.getEmployeeName());
            approvalHistory.setComment(comment);
            approvalHistory.setStatus(0);
            vacancyApprovalHistoryService.create(approvalHistory);
            request.setAttribute("successMessage",
                    "Information: The Information is Edited Successfully");
        }

        mv.getModelMap().put("vacancyMaster", vacancyMaster);
        mv = vacancyDetailList(request, response);

        return mv;
    }

    public ModelAndView backButton(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        mv = showVacancyList(request, response);
        return mv;
    }

    public ModelAndView jobApplaClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("Vacancy/JobVacancyLogin");
        return mv;
    }

    public ModelAndView signUp(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
//        String id = request.getParameter("id");
//        int VacId = Integer.parseInt(id);
        ApplayJobUserMaster applayJobUserMaster = new ApplayJobUserMaster();
        mv.getModelMap().put("applayJobUserMaster", applayJobUserMaster);
        if ("" == request.getParameter("id")) {
            if ("" != request.getParameter("id")) {
                String id = request.getParameter("id");
                int VacId = Integer.parseInt(id);
                mv.getModelMap().put("vacid", VacId);
            }
        }
        mv.setViewName("Vacancy/signUpButton");
        return mv;
    }

    public ModelAndView submitRegistration(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        CandidateApplyJob candidateApplyJob = new CandidateApplyJob();
        BindException errors = new BindException(candidateApplyJob, "candidateApplyJob");
        bind(request, candidateApplyJob);

        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile = multipartRequest.getFile("photograph");
        if (candidateJobApplyService.isExist(multipartFile.getOriginalFilename())) {
            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard"
                    + File.separator + "candidateimage" + File.separator;
            String fileLocationURL1 = "StorageYard"
                    + File.separator + "candidateimage" + File.separator;
            File Folder1 = new File(fileLocationURL);
            if (!Folder1.exists()) {
                Folder1.mkdirs();
            }
            if (multipartFile != null && multipartFile.getSize() > 0) {
                try {
                    File file2 = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", "_"));
                    File file = new File(fileLocationURL1 + multipartFile.getOriginalFilename().replaceAll(" ", "_"));
                    multipartFile.transferTo(file2);
                    candidateApplyJob.setPhotograph(multipartFile.getOriginalFilename().replaceAll(" ", "_"));
                } catch (Exception e) {

                }
            }
        }
        MultipartHttpServletRequest multipartRequest1 = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile1 = multipartRequest.getFile("certificateId1");
        if (candidateJobApplyService.isExistCertificateAttach(multipartFile1.getOriginalFilename())) {
            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard"
                    + File.separator + "CertificateAttach" + File.separator;
            String fileLocationURL1 = "StorageYard"
                    + File.separator + "CertificateAttach" + File.separator;
            File Folder1 = new File(fileLocationURL);
            if (!Folder1.exists()) {
                Folder1.mkdirs();
            }
            if (multipartFile1 != null && multipartFile1.getSize() > 0) {
                try {
                    File file2 = new File(fileLocationURL + multipartFile1.getOriginalFilename().replaceAll(" ", "_"));
                    File file = new File(fileLocationURL1 + multipartFile1.getOriginalFilename().replaceAll(" ", "_"));
                    multipartFile1.transferTo(file2);
                    candidateApplyJob.setCertificateAttach(multipartFile1.getOriginalFilename().replaceAll(" ", "_"));
                } catch (Exception e) {

                }
            }
        }
        candidateJobApplyValidator.validate(candidateApplyJob, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : Please fill in all required fields");
            mv.addAllObjects(errors.getModel());
            mv.getModelMap().put("candidateApplyJob", candidateApplyJob);
            mv.setViewName("Vacancy/applyJobCandidateRegistration");
        } else {

            ApplayJobUserMaster ajuMaster = (ApplayJobUserMaster) session.getAttribute("ApplayJobUserMaster");
            if (ajuMaster.getFirstTime() == 1) {
                candidateApplyJob.setApplayJobUserMaster(ajuMaster);
                List<CandidateApplyJob> list = (List<CandidateApplyJob>) candidateJobApplyService.readProfileByCandidateUserID(ajuMaster.getId());
                if (!list.isEmpty()) {
                } else {
                    candidateJobApplyService.create(candidateApplyJob);
                }
            } else {
                List<CandidateApplyJob> list = (List<CandidateApplyJob>) candidateJobApplyService.candidateApplyJobcheackUserId(ajuMaster.getId());
                if (!list.isEmpty()) {
                    CandidateApplyJob cbj = list.get(0);
                    candidateApplyJob.setId(cbj.getId());
                    candidateApplyJob.setApplayJobUserMaster(ajuMaster);
                    candidateJobApplyService.update(candidateApplyJob);
                }
                if (ajuMaster.getProfileSubmit() != 1) {

                    ajuMaster.setProfileSubmit(1);
                    applayJobUserMasterSerivce.update(ajuMaster);

                }
            }

            VacancyMaster vacancyMaster = new VacancyMaster();
//            List<?> vacancylist = vacancyMasterService.fetchVacancyDetail();
            Date d = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String date = sdf.format(d);

            List<?> vacancylist = vacancyMasterService.fetchVacancyBydate(date);
            mv.getModelMap().put("list", vacancylist);
            mv.getModelMap().put("vacancyMaster", vacancyMaster);
            mv.setViewName("Vacancy/ShowVacancyList");
        }

        return mv;
    }

    public ModelAndView signUpCandidate(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        ApplayJobUserMaster applayJobUserMaster = new ApplayJobUserMaster();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        BindException errors = new BindException(applayJobUserMaster, "applayJobUserMaster");
        bind(request, applayJobUserMaster);

//        String id = request.getParameter("id");
//        int VacId = Integer.parseInt(id);
        Random rnd = new Random();
        String otpCode = String.valueOf(100000 + rnd.nextInt(900000));
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdftime = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        Date ctime = new Date();
        applayJobUserMasterValidator.validate(applayJobUserMaster, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : All Fields Are Mandatorys");
            mv = signUp(request, response);

        } else if (applayJobUserMasterSerivce.isExist(applayJobUserMaster)) {
            request.setAttribute("failureMessage",
                    "Error : UserName is already used.");
            mv = signUp(request, response);
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date cDate = new Date();
            applayJobUserMaster.setCreatedDate(sdf.format(cDate));
            applayJobUserMaster.setFirstTime(0);
            applayJobUserMaster.setProfileSubmit(0);
            applayJobUserMaster.setOtp(otpCode);
            applayJobUserMaster.setStatusOtp(0);
            applayJobUserMaster.setTimeValidity(sdftime.format(ctime));
            applayJobUserMasterSerivce.create(applayJobUserMaster);

            CandidateApplyJob caj = new CandidateApplyJob();
            caj.setApplayJobUserMaster(applayJobUserMaster);
            candidateJobApplyService.create(caj);

            CandidateApplyJob2 caj2 = new CandidateApplyJob2();
            caj2.setCreatedDate(sdf.format(cDate));
            caj2.setCandidateApplyJob(caj);
            candidateApplyJob2Service.create(caj2);

            request.setAttribute("successMessage",
                    "Information : signUp Successfully.");
            try {
                EmailTemplate emailTemplate = new EmailTemplate();
                emailTemplate = emailTemplateService.readById(159);
                String To = applayJobUserMaster.getUserName();
//                String from = employeeMaster.getEmailAddress();
                String Subject = emailTemplate.getSubject();
                String msg = emailTemplate.getBodytext();
//                Subject = Subject.replaceAll("\\{user\\}", employeeMaster.getEmployeeName());
                msg = msg.replaceAll("\\{to_user\\}", applayJobUserMaster.getUserName());
                msg = msg.replaceAll("\\{code\\}", otpCode);
                sendMail.sendMail("", To, Subject, msg);
            } catch (Exception e) {
            }
            if ("" != request.getParameter("id")) {
                String id = request.getParameter("id");
                int VacId = Integer.parseInt(id);
                request.setAttribute("vacid", VacId);
            }
            return new ModelAndView("Vacancy/CandidateOTPSubmit", "applayJobUserMaster", applayJobUserMaster);
//            return new ModelAndView("Vacancy/ApplayLoginpage", "applayJobUserMaster", applayJobUserMaster);
        }
        return mv;
    }

    public ModelAndView Login(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        ApplayJobUserMaster applayJobUserMaster = new ApplayJobUserMaster();
        mv.getModelMap().put("applayJobUserMaster", applayJobUserMaster);

        mv.setViewName("Vacancy/ApplayLoginpage");
        return mv;
    }

    public ModelAndView loginCandidate(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        String vacid = request.getParameter("vacid");
        HttpSession session = request.getSession();
        ApplayJobUserMaster ajuMaster = (ApplayJobUserMaster) session.getAttribute("ApplayJobUserMaster");
        ApplayJobUserMaster applayJobUserMaster = new ApplayJobUserMaster();
        VacancyMaster vacancyMaster = new VacancyMaster();
        BindException errors = new BindException(applayJobUserMaster, "applayJobUserMaster");
        bind(request, applayJobUserMaster);
        String userName = applayJobUserMaster.getUserName();
        String PassString = applayJobUserMaster.getPassword();

        if (!"".equals(userName) && !"".equals(PassString)) {
            ApplayJobUserMaster ajum = new ApplayJobUserMaster();
            ajum.setUserName(userName);
            ajum.setPassword(PassString);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date cDate = new Date();

            ApplayJobUserMaster master = applayJobUserMasterSerivce.checkByUserNameandPass(ajum);
            Boolean flage = applayJobUserMasterSerivce.checkByLogInStatus(ajum);
            if (false == flage) {
                if (null != master) {
                    HttpSession session1 = request.getSession(false);
                    session1.setAttribute("ApplayJobUserMaster", master);

                    request.setAttribute("successMessage",
                            "Information : Login Successfully.");

                    List<CandidateApplyJob> candidateProfile = (List<CandidateApplyJob>) candidateJobApplyService.readProfileByCandidateUserID(master.getId());
                    List<?> CandidateJobApplyList = new ArrayList<>();
                    if (!candidateProfile.isEmpty()) {
                        CandidateApplyJob caj = (CandidateApplyJob) candidateProfile.get(0);
                        if ("" != request.getParameter("id")) {
                            String id = request.getParameter("id");
                            int VacId = Integer.parseInt(id);
                            vacancyMaster = vacancyMasterService.readById(VacId);
                            CandidateJobApplication application = candidateJobApplicationService.readByCandidateIdAndVacancyId(caj.getId(), vacancyMaster.getId());
                            if (null == application) {

                                CandidateJobApplication candidateJobApplication = new CandidateJobApplication();
                                candidateJobApplication.setVacancyMaster(vacancyMaster);
                                candidateJobApplication.setApplayJobUserMaster(master);
                                candidateJobApplication.setCreatedBy(master.getId());
                                candidateJobApplication.setCreatedDate(sdf.format(cDate));
                                candidateJobApplication.setStatus(0);

                                candidateJobApplication.setCandidateApplyJob(caj);

                                candidateJobApplicationService.create(candidateJobApplication);
                            } else {
                                request.setAttribute("successMessage",
                                        "You are already apply for this job.");
                                Date d = new Date();
                                String date = sdf.format(d);

                                List<?> vacancylist = vacancyMasterService.fetchVacancyBydate(date);
//                                List<?> vacancylist = vacancyMasterService.fetchVacancyDetail();
                                mv.getModelMap().put("list", vacancylist);
                                mv.getModelMap().put("vacancyMaster", vacancyMaster);
                                mv.setViewName("Vacancy/ShowVacancyList");
                                return mv;

                            }
                        }

                        CandidateJobApplyList = candidateJobApplicationService.readByCandidateId(caj.getId());
                    }

//              ApplayJobUserMaster applayJobUserMaster = new ApplayJobUserMaster();
                    request.setAttribute("successMessage",
                            "Information : Login Successfully.");
                    request.setAttribute("list", CandidateJobApplyList);
                    mv.getModelMap().put("applayJobUserMaster", master);

                    mv.setViewName("Vacancy/MemberVacancyList");
                    return mv;

                } else {
                    request.setAttribute("failureMessage",
                            "Error : Invalid UserName Or Password.");
                    mv = Login(request, response);
                }
            } else {
                request.setAttribute("successMessage",
                        "Information : Your Selected, No need to Login.");
                mv = Login(request, response);
            }
        } else {
            request.setAttribute("failureMessage",
                    "Error : Invalid UserName Or Password.");
            mv = Login(request, response);
        }
        mv.getModelMap().put("applayJobUserMaster", applayJobUserMaster);
        return mv;
    }

    public ModelAndView backToHome(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        ApplayJobUserMaster applayJobUserMaster = new ApplayJobUserMaster();
        String id = request.getParameter("id");
        applayJobUserMaster = applayJobUserMasterSerivce.readById(Integer.parseInt(id));
//          mv.getModelMap().put("recruitmentMaster", recruitmentMaster);
        mv = showVacancyList(request, response);
        return mv;
    }

    public ModelAndView applayForJob(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession();
        ApplayJobUserMaster ajuMaster = (ApplayJobUserMaster) session.getAttribute("ApplayJobUserMaster");

        ModelAndView mv = new ModelAndView();
        ApplayJobUserMaster applayJobUserMaster = new ApplayJobUserMaster();
        VacancyMaster vacancyMaster = new VacancyMaster();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date cDate = new Date();
        String id = request.getParameter("id");
        vacancyMaster = vacancyMasterService.readById(Integer.parseInt(id));

        if (null != ajuMaster) {

            List<CandidateApplyJob> candidateProfile = (List<CandidateApplyJob>) candidateJobApplyService.readProfileByCandidateUserID(ajuMaster.getId());

            if (!candidateProfile.isEmpty()) {

                CandidateApplyJob caj = (CandidateApplyJob) candidateProfile.get(0);

                CandidateJobApplication application = candidateJobApplicationService.readByCandidateIdAndVacancyId(caj.getId(), vacancyMaster.getId());
                if (null == application) {

                    CandidateJobApplication candidateJobApplication = new CandidateJobApplication();
                    candidateJobApplication.setVacancyMaster(vacancyMaster);
                    candidateJobApplication.setApplayJobUserMaster(ajuMaster);
                    candidateJobApplication.setCreatedBy(ajuMaster.getId());
                    candidateJobApplication.setCreatedDate(sdf.format(cDate));
                    candidateJobApplication.setStatus(0);

                    candidateJobApplication.setCandidateApplyJob(caj);

                    candidateJobApplicationService.create(candidateJobApplication);

                    List<?> CandidateJobApplyList = candidateJobApplicationService.readByCandidateId(caj.getId());

                    request.setAttribute("list", CandidateJobApplyList);
                    mv.getModelMap().put("ajuMaster", ajuMaster);
                    mv.setViewName("Vacancy/MemberVacancyList");
                    return mv;

                } else {
                    request.setAttribute("successMessage",
                            "You are already apply for this job.");
                    Date d = new Date();
                    String date = sdf.format(d);
                    List<?> vacancylist = vacancyMasterService.fetchVacancyBydate(date);
                    mv.getModelMap().put("list", vacancylist);
                    mv.getModelMap().put("vacancyMaster", vacancyMaster);
                    mv.setViewName("Vacancy/ShowVacancyList");
                    return mv;

                }
            } else {
//                CandidateApplyJob candidateApplyJob = new CandidateApplyJob();
//
//                mv.getModelMap().put("candidateApplyJob", candidateApplyJob);
//                mv.setViewName("Vacancy/applyJobCandidateRegistration");
                applayJobUserMaster = applayJobUserMasterSerivce.readById(ajuMaster.getId());

                applayJobUserMaster.setProfileSubmit(1);
                applayJobUserMasterSerivce.update(applayJobUserMaster);

                CandidateApplyJob applyJob = new CandidateApplyJob();
                applyJob.setApplayJobUserMaster(ajuMaster);
                applyJob.setVacancyId(vacancyMaster);
                candidateJobApplyService.create(applyJob);

                CandidateJobApplication candidateJobApplication = new CandidateJobApplication();
                candidateJobApplication.setApplayJobUserMaster(ajuMaster);
                candidateJobApplication.setVacancyMaster(vacancyMaster);
                candidateJobApplication.setCreatedBy(ajuMaster.getId());
                candidateJobApplication.setCreatedDate(sdf.format(cDate));
                candidateJobApplication.setStatus(0);
                candidateJobApplication.setCandidateApplyJob(applyJob);
                candidateJobApplicationService.create(candidateJobApplication);

                List<?> CandidateJobApplyList = candidateJobApplicationService.readByCandidateId(candidateJobApplication.getId());

                request.setAttribute("list", CandidateJobApplyList);
                mv.getModelMap().put("ajuMaster", ajuMaster);
                mv.setViewName("Vacancy/MemberVacancyList");
                return mv;

            }

        } else {
            request.setAttribute("vacid", id);
            mv.getModelMap().put("applayJobUserMaster", applayJobUserMaster);
            mv.setViewName("Vacancy/ApplayLoginpage");

        }

        return mv;
    }

    public ModelAndView membershowVacancyList(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        VacancyMaster vacancyMaster = new VacancyMaster();
        String id = request.getParameter("id");
        vacancyMaster = vacancyMasterService.readById(Integer.parseInt(id));
//        List<?> vacancylist = vacancyMasterService.fetchVacancyDetail();
        mv.getModelMap().put("list", vacancyMaster);
//        mv.getModelMap().put("vacancyMaster", vacancyMaster);
        return mv;
    }

//    public ModelAndView myProfileClick(HttpServletRequest request,
//            HttpServletResponse response) throws Exception {
//
//        ModelAndView mv = new ModelAndView();
//        CandidateApplyJob candidateApplyJob = new CandidateApplyJob();
//        String id = request.getParameter("id");
//        if (id != null) {
//
//            CandidateApplyJob candidateApplyJob1 = candidateJobApplyService.readByapplayjobusermasterid(Integer.parseInt(id));
//            if (candidateApplyJob1 != null) {
//                mv.getModelMap().put("candidateApplyJob", candidateApplyJob1);
//                mv.setViewName("Vacancy/MyProfile");
//            } else {
//                mv.getModelMap().put("candidateApplyJob", candidateApplyJob);
//                mv.setViewName("Vacancy/MyProfile");
//            }
//        } else {
//            mv.getModelMap().put("candidateApplyJob", candidateApplyJob);
//            mv.setViewName("Vacancy/MyProfile");
//        }
//        return mv;
//    }
    public ModelAndView myProfileClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        CombinedCandidateClasses combinedCandidateClasses = new CombinedCandidateClasses();
        String id = request.getParameter("id");
        if (id != null) {

            CandidateApplyJob candidateApplyJob1 = candidateJobApplyService.readByapplayjobusermasterid(Integer.parseInt(id));
            combinedCandidateClasses.setCandidateApplyJob(candidateApplyJob1);

            CandidateApplyJob2 candidateApplyJob2 = candidateApplyJob2Service.readByApplyJobId(candidateApplyJob1.getId());
            combinedCandidateClasses.setCandidateApplyJob2(candidateApplyJob2);

            List<?> caqList = candidateAcademicQualificationService.readListByApplyJobId(candidateApplyJob1.getId());
            List<?> cedList = candidateExperienceDetailService.readListByApplyJobId(candidateApplyJob1.getId());
            List<?> cfbList = candidateFamilyBackgroundService.readListByApplyJobId(candidateApplyJob1.getId());
            List<?> corList = candidateOtherReferencesService.readListByApplyJobId(candidateApplyJob1.getId());
//            CandidateAcademicQualification candidateAcademicQualification = candidateAcademicQualificationService.readByApplyJobId(candidateApplyJob1.getId());
//            combinedCandidateClasses.setCandidateAcademicQualification(candidateAcademicQualification);
//
//            CandidateExperienceDetail candidateExperienceDetail = candidateExperienceDetailService.readByApplyJobId(candidateApplyJob1.getId());
//            combinedCandidateClasses.setCandidateExperienceDetail(candidateExperienceDetail);
//
//            CandidateFamilyBackground candidateFamilyBackground = candidateFamilyBackgroundService.readByApplyJobId(candidateApplyJob1.getId());
//            combinedCandidateClasses.setCandidateFamilyBackground(candidateFamilyBackground);
//
//            CandidateOtherReferences candidateOtherReferences = candidateOtherReferencesService.readByApplyJobId(candidateApplyJob1.getId());
//            combinedCandidateClasses.setCandidateOtherReferences(candidateOtherReferences);
            if (candidateApplyJob1 != null) {
                mv.getModelMap().put("combinedCandidateClasses", combinedCandidateClasses);
                request.setAttribute("photographAttachment", combinedCandidateClasses.getCandidateApplyJob().getPhotograph());
                request.setAttribute("salarySlipAttachment", combinedCandidateClasses.getCandidateApplyJob2().getSalarySlipAttachment());
                request.setAttribute("certificateAttachment", combinedCandidateClasses.getCandidateApplyJob().getCertificateAttach());
                mv.getModelMap().put("caqList", caqList);
                mv.getModelMap().put("cedList", cedList);
                mv.getModelMap().put("cfbList", cfbList);
                mv.getModelMap().put("corList", corList);
                mv.setViewName("Vacancy/MyProfile");
            } else {
                mv.getModelMap().put("combinedCandidateClasses", combinedCandidateClasses);
                mv.setViewName("Vacancy/MyProfile");
            }

        } else {
            mv.getModelMap().put("combinedCandidateClasses", combinedCandidateClasses);
            mv.setViewName("Vacancy/MyProfile");
        }
        return mv;
    }

    public ModelAndView tryToAdd(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        CombinedCandidateClasses combinedCandidateClasses = new CombinedCandidateClasses();
        bind(request, combinedCandidateClasses);
        HttpSession session = request.getSession();
        ApplayJobUserMaster ajuMaster = (ApplayJobUserMaster) session.getAttribute("ApplayJobUserMaster");

        CandidateApplyJob candidateApplyJob = combinedCandidateClasses.getCandidateApplyJob();
        CandidateApplyJob2 candidateApplyJob2 = combinedCandidateClasses.getCandidateApplyJob2();
//        CandidateAcademicQualification candidateAcademicQualification = combinedCandidateClasses.getCandidateAcademicQualification();
//        CandidateExperienceDetail candidateExperienceDetail = combinedCandidateClasses.getCandidateExperienceDetail();
//        CandidateFamilyBackground candidateFamilyBackground = combinedCandidateClasses.getCandidateFamilyBackground();
//        CandidateOtherReferences candidateOtherReferences = combinedCandidateClasses.getCandidateOtherReferences();
        String candidateId = ajuMaster.getId().toString();

        Date cdate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");

//        CandidateAcademicQualification candidateAcademicQualification = new CandidateAcademicQualification();
//        CandidateExperienceDetail candidateExperienceDetail = new CandidateExperienceDetail();
//        CandidateFamilyBackground candidateFamilyBackground = new CandidateFamilyBackground();
//        CandidateOtherReferences candidateOtherReferences = new CandidateOtherReferences();
        CandidateApplyJob caj = candidateJobApplyService.readById(candidateApplyJob.getId());
        CandidateApplyJob2 caj2 = candidateApplyJob2Service.readById(candidateApplyJob2.getId());

        if (null != request.getParameter("candidateApplyJob.photograph") || "" != request.getParameter("candidateApplyJob.photograph")) {
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            MultipartFile multipartFile = multipartRequest.getFile("candidateApplyJob.photograph");

            if (multipartFile != null && multipartFile.getSize() > 0) {
                try {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard"
                            + File.separator + "candidate" + File.separator + "candidateimage" + File.separator + candidateId + File.separator + "" + caj.getPhotograph();

                    File getFile = new File(fileLocationURL);
                    getFile.delete();

                    String fileLocationURL2 = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard"
                            + File.separator + "candidate" + File.separator + "candidateimage" + File.separator + candidateId + File.separator;

                    File Folder1 = new File(fileLocationURL2);
                    if (!Folder1.exists()) {
                        Folder1.mkdirs();
                    }

                    File file2 = new File(fileLocationURL2 + multipartFile.getOriginalFilename().replaceAll(" ", "_"));
                    multipartFile.transferTo(file2);
                    candidateApplyJob.setPhotograph(multipartFile.getOriginalFilename().replaceAll(" ", "_"));

                } catch (Exception e) {
                    e.getStackTrace();
                }
            } else {
                candidateApplyJob.setPhotograph(caj.getPhotograph());
            }
        }

        //certificate attach
        if (null != request.getParameter("candidateApplyJob.certificateAttach") || "" != request.getParameter("candidateApplyJob.certificateAttach")) {
            MultipartHttpServletRequest multipartRequest2 = (MultipartHttpServletRequest) request;
            MultipartFile multipartFile2 = multipartRequest2.getFile("candidateApplyJob.certificateAttach");

            if (multipartFile2 != null && multipartFile2.getSize() > 0) {
                try {
                    String fileLocationURL11 = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard"
                            + File.separator + "candidate" + File.separator + "candidatecertificate" + File.separator + candidateId + File.separator + "" + caj.getCertificateAttach();

                    File getFile1 = new File(fileLocationURL11);
                    getFile1.delete();

                    String fileLocationURL4 = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard"
                            + File.separator + "candidate" + File.separator + "candidatecertificate" + File.separator + candidateId + File.separator;

                    File Folder12 = new File(fileLocationURL4);
                    if (!Folder12.exists()) {
                        Folder12.mkdirs();
                    }

                    File file2 = new File(fileLocationURL4 + multipartFile2.getOriginalFilename().replaceAll(" ", "_"));
                    multipartFile2.transferTo(file2);
                    candidateApplyJob.setCertificateAttach(multipartFile2.getOriginalFilename().replaceAll(" ", "_"));

                } catch (Exception e) {
                    e.getStackTrace();
                }
            } else {
                candidateApplyJob.setCertificateAttach(caj.getCertificateAttach());
            }

        }

        candidateApplyJob.setApplayJobUserMaster(caj.getApplayJobUserMaster());
        candidateJobApplyService.update(candidateApplyJob);

        //candidate salary slip
        if (null != request.getParameter("candidateApplyJob2.salarySlipAttachment") || "" != request.getParameter("candidateApplyJob2.salarySlipAttachment")) {
            MultipartHttpServletRequest multipartRequest1 = (MultipartHttpServletRequest) request;
            MultipartFile multipartFile1 = multipartRequest1.getFile("candidateApplyJob2.salarySlipAttachment");

            if (multipartFile1 != null && multipartFile1.getSize() > 0) {
                try {
                    String fileLocationURL1 = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard"
                            + File.separator + "candidate" + File.separator + "candidatesalaryslip" + File.separator + candidateId + File.separator + "" + caj2.getSalarySlipAttachment();

                    File File2 = new File(fileLocationURL1);
                    File2.delete();

                    String fileLocationURL3 = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard"
                            + File.separator + "candidate" + File.separator + "candidatesalaryslip" + File.separator + candidateId + File.separator;

                    File Folder2 = new File(fileLocationURL3);
                    if (!Folder2.exists()) {
                        Folder2.mkdirs();
                    }

                    File file2 = new File(fileLocationURL3 + multipartFile1.getOriginalFilename().replaceAll(" ", "_"));
                    multipartFile1.transferTo(file2);
                    candidateApplyJob2.setSalarySlipAttachment(multipartFile1.getOriginalFilename().replaceAll(" ", "_"));

                } catch (Exception e) {
                    e.getStackTrace();
                }
            } else {
                candidateApplyJob2.setSalarySlipAttachment(caj2.getSalarySlipAttachment());
            }
        }

        candidateApplyJob2.setCandidateApplyJob(caj2.getCandidateApplyJob());
        candidateApplyJob2.setCreatedDate(sdf.format(cdate));
        candidateApplyJob2Service.update(candidateApplyJob2);

        List<?> caqList = candidateAcademicQualificationService.readListByApplyJobId(candidateApplyJob.getId());
        List<?> cedList = candidateExperienceDetailService.readListByApplyJobId(candidateApplyJob.getId());
        List<?> cfbList = candidateFamilyBackgroundService.readListByApplyJobId(candidateApplyJob.getId());
        List<?> corList = candidateOtherReferencesService.readListByApplyJobId(candidateApplyJob.getId());

        //academics of candidate 
        String strCAQ0[] = request.getParameterValues("candidateAcademicQualification.id");
        String strCAQ1[] = request.getParameterValues("candidateAcademicQualification.academicYearFrom");
        String strCAQ2[] = request.getParameterValues("candidateAcademicQualification.academicYearTo");
        String strCAQ3[] = request.getParameterValues("candidateAcademicQualification.academicExamination");
        String strCAQ4[] = request.getParameterValues("candidateAcademicQualification.academicBoard");
        String strCAQ5[] = request.getParameterValues("candidateAcademicQualification.academicNumberOfAttempts");
        String strCAQ6[] = request.getParameterValues("candidateAcademicQualification.academicMarksInPercent");
        String strCAQ7[] = request.getParameterValues("candidateAcademicQualification.academicClass");
        String strCAQ8[] = request.getParameterValues("candidateAcademicQualification.academicRankOrScholarship");

        if (null == caqList || caqList.isEmpty()) {
            for (int i = 0; i < strCAQ1.length; i++) {
                if ((!strCAQ1[i].equals("") && !strCAQ1[i].isEmpty()) && (!strCAQ2[i].equals("") && !strCAQ2[i].isEmpty()) && (!strCAQ3[i].equals("") && !strCAQ3[i].isEmpty())
                        && (!strCAQ4[i].equals("") && !strCAQ4[i].isEmpty()) && (!strCAQ5[i].equals("") && !strCAQ5[i].isEmpty())
                        && (!strCAQ6[i].equals("") && !strCAQ6[i].isEmpty()) && (!strCAQ7[i].equals("") && !strCAQ7[i].isEmpty())) {
                    CandidateAcademicQualification caq = new CandidateAcademicQualification();
                    caq.setAcademicYearFrom(Integer.parseInt(strCAQ1[i]));
                    caq.setAcademicYearTo(Integer.parseInt(strCAQ2[i]));
                    caq.setAcademicExamination(strCAQ3[i]);
                    caq.setAcademicBoard(strCAQ4[i]);
                    caq.setAcademicNumberOfAttempts(Integer.parseInt(strCAQ5[i]));
                    caq.setAcademicMarksInPercent(strCAQ6[i]);
                    caq.setAcademicClass(strCAQ7[i]);
                    caq.setAcademicRankOrScholarship(strCAQ8[i]);
                    caq.setCreatedDate(sdf.format(cdate));
                    caq.setCandidateApplyJob(candidateApplyJob);
                    candidateAcademicQualificationService.create(caq);
                }
            }
        } else if ((caqList != null || !caqList.isEmpty()) && (strCAQ1.length == caqList.size())) {
            for (int i = 0; i < strCAQ1.length; i++) {
                if ((!strCAQ0[i].equals("") && !strCAQ0[i].isEmpty())
                        && (!strCAQ1[i].equals("") && !strCAQ1[i].isEmpty()) && (!strCAQ2[i].equals("") && !strCAQ2[i].isEmpty()) && (!strCAQ3[i].equals("") && !strCAQ3[i].isEmpty())
                        && (!strCAQ4[i].equals("") && !strCAQ4[i].isEmpty()) && (!strCAQ5[i].equals("") && !strCAQ5[i].isEmpty())
                        && (!strCAQ6[i].equals("") && !strCAQ6[i].isEmpty()) && (!strCAQ7[i].equals("") && !strCAQ7[i].isEmpty())) {
                    CandidateAcademicQualification caq = candidateAcademicQualificationService.readById(Integer.parseInt(strCAQ0[i]));
                    caq.setAcademicYearFrom(Integer.parseInt(strCAQ1[i]));
                    caq.setAcademicYearTo(Integer.parseInt(strCAQ2[i]));
                    caq.setAcademicExamination(strCAQ3[i]);
                    caq.setAcademicBoard(strCAQ4[i]);
                    caq.setAcademicNumberOfAttempts(Integer.parseInt(strCAQ5[i]));
                    caq.setAcademicMarksInPercent(strCAQ6[i]);
                    caq.setAcademicClass(strCAQ7[i]);
                    caq.setAcademicRankOrScholarship(strCAQ8[i]);
                    candidateAcademicQualificationService.update(caq);
                }
            }
        } else {
            for (int i = 0; i < caqList.size(); i++) {
                if ((!strCAQ0[i].equals("") && !strCAQ0[i].isEmpty())
                        && (!strCAQ1[i].equals("") && !strCAQ1[i].isEmpty()) && (!strCAQ2[i].equals("") && !strCAQ2[i].isEmpty()) && (!strCAQ3[i].equals("") && !strCAQ3[i].isEmpty())
                        && (!strCAQ4[i].equals("") && !strCAQ4[i].isEmpty()) && (!strCAQ5[i].equals("") && !strCAQ5[i].isEmpty())
                        && (!strCAQ6[i].equals("") && !strCAQ6[i].isEmpty()) && (!strCAQ7[i].equals("") && !strCAQ7[i].isEmpty())) {
                    CandidateAcademicQualification caq = candidateAcademicQualificationService.readById(Integer.parseInt(strCAQ0[i]));
                    caq.setAcademicYearFrom(Integer.parseInt(strCAQ1[i]));
                    caq.setAcademicYearTo(Integer.parseInt(strCAQ2[i]));
                    caq.setAcademicExamination(strCAQ3[i]);
                    caq.setAcademicBoard(strCAQ4[i]);
                    caq.setAcademicNumberOfAttempts(Integer.parseInt(strCAQ5[i]));
                    caq.setAcademicMarksInPercent(strCAQ6[i]);
                    caq.setAcademicClass(strCAQ7[i]);
                    caq.setAcademicRankOrScholarship(strCAQ8[i]);
                    candidateAcademicQualificationService.update(caq);
                }
            }
            for (int i = caqList.size() + 1; i < strCAQ1.length; i++) {
                if ((!strCAQ1[i].equals("") && !strCAQ1[i].isEmpty()) && (!strCAQ2[i].equals("") && !strCAQ2[i].isEmpty()) && (!strCAQ3[i].equals("") && !strCAQ3[i].isEmpty())
                        && (!strCAQ4[i].equals("") && !strCAQ4[i].isEmpty()) && (!strCAQ5[i].equals("") && !strCAQ5[i].isEmpty())
                        && (!strCAQ6[i].equals("") && !strCAQ6[i].isEmpty()) && (!strCAQ7[i].equals("") && !strCAQ7[i].isEmpty())) {
                    CandidateAcademicQualification caq = new CandidateAcademicQualification();
                    caq.setAcademicYearFrom(Integer.parseInt(strCAQ1[i]));
                    caq.setAcademicYearTo(Integer.parseInt(strCAQ2[i]));
                    caq.setAcademicExamination(strCAQ3[i]);
                    caq.setAcademicBoard(strCAQ4[i]);
                    caq.setAcademicNumberOfAttempts(Integer.parseInt(strCAQ5[i]));
                    caq.setAcademicMarksInPercent(strCAQ6[i]);
                    caq.setAcademicClass(strCAQ7[i]);
                    caq.setAcademicRankOrScholarship(strCAQ8[i]);
                    caq.setCandidateApplyJob(candidateApplyJob);
                    caq.setCreatedDate(sdf.format(cdate));
                    candidateAcademicQualificationService.create(caq);
                }
            }
        }

        //experience of candidate 
        String strCED0[] = request.getParameterValues("candidateExperienceDetail.id");
        String strCED1[] = request.getParameterValues("candidateExperienceDetail.experienceYearFrom");
        String strCED2[] = request.getParameterValues("candidateExperienceDetail.experienceYearTo");
        String strCED3[] = request.getParameterValues("candidateExperienceDetail.experienceOrganization");
        String strCED4[] = request.getParameterValues("candidateExperienceDetail.experienceDepartment");
        String strCED5[] = request.getParameterValues("candidateExperienceDetail.experienceDesignation");
        String strCED6[] = request.getParameterValues("candidateExperienceDetail.experienceJobResponsibilities");
        String strCED7[] = request.getParameterValues("candidateExperienceDetail.experienceRemunerationOnJoin");
        String strCED8[] = request.getParameterValues("candidateExperienceDetail.experienceRemunerationOnLeaving");
        String strCED9[] = request.getParameterValues("candidateExperienceDetail.experienceReasonForLeaving");

        if (null == cedList || cedList.isEmpty()) {
            for (int i = 0; i < strCED1.length; i++) {
                if ((!strCED1[i].equals("") && !strCED1[i].isEmpty())
                        && (!strCED2[i].equals("") && !strCED2[i].isEmpty()) && (!strCED3[i].equals("") && !strCED3[i].isEmpty())
                        && (!strCED4[i].equals("") && !strCED4[i].isEmpty()) && (!strCED5[i].equals("") && !strCED5[i].isEmpty())
                        && (!strCED6[i].equals("") && !strCED6[i].isEmpty()) && (!strCED7[i].equals("") && !strCED7[i].isEmpty())
                        && (!strCED8[i].equals("") && !strCED8[i].isEmpty()) && (!strCED9[i].equals("") && !strCED9[i].isEmpty())) {
                    CandidateExperienceDetail ced = new CandidateExperienceDetail();
                    ced.setExperienceYearFrom(Integer.parseInt(strCED1[i]));
                    ced.setExperienceYearTo(Integer.parseInt(strCED2[i]));
                    ced.setExperienceOrganization(strCED3[i]);
                    ced.setExperienceDepartment(strCED4[i]);
                    ced.setExperienceDesignation(strCED5[i]);
                    ced.setExperienceJobResponsibilities(strCED6[i]);
                    ced.setExperienceRemunerationOnJoin(strCED7[i]);
                    ced.setExperienceRemunerationOnLeaving(strCED8[i]);
                    ced.setExperienceReasonForLeaving(strCED9[i]);
                    ced.setCreatedDate(sdf.format(cdate));
                    ced.setCandidateApplyJob(candidateApplyJob);
                    candidateExperienceDetailService.create(ced);
                }
            }
        } else if ((cedList != null || !cedList.isEmpty()) && (strCED1.length == cedList.size())) {
            for (int i = 0; i < strCED1.length; i++) {
                if ((!strCED0[i].equals("") && !strCED0[i].isEmpty()) && (!strCED1[i].equals("") && !strCED1[i].isEmpty())
                        && (!strCED2[i].equals("") && !strCED2[i].isEmpty()) && (!strCED3[i].equals("") && !strCED3[i].isEmpty())
                        && (!strCED4[i].equals("") && !strCED4[i].isEmpty()) && (!strCED5[i].equals("") && !strCED5[i].isEmpty())
                        && (!strCED6[i].equals("") && !strCED6[i].isEmpty()) && (!strCED7[i].equals("") && !strCED7[i].isEmpty())
                        && (!strCED8[i].equals("") && !strCED8[i].isEmpty()) && (!strCED9[i].equals("") && !strCED9[i].isEmpty())) {
                    CandidateExperienceDetail ced = candidateExperienceDetailService.readById(Integer.parseInt(strCED0[i]));
                    ced.setExperienceYearFrom(Integer.parseInt(strCED1[i]));
                    ced.setExperienceYearTo(Integer.parseInt(strCED2[i]));
                    ced.setExperienceOrganization(strCED3[i]);
                    ced.setExperienceDepartment(strCED4[i]);
                    ced.setExperienceDesignation(strCED5[i]);
                    ced.setExperienceJobResponsibilities(strCED6[i]);
                    ced.setExperienceRemunerationOnJoin(strCED7[i]);
                    ced.setExperienceRemunerationOnLeaving(strCED8[i]);
                    ced.setExperienceReasonForLeaving(strCED9[i]);
                    candidateExperienceDetailService.update(ced);
                }
            }
        } else {
            for (int i = 0; i < cedList.size(); i++) {
                if ((!strCED0[i].equals("") && !strCED0[i].isEmpty()) && (!strCED1[i].equals("") && !strCED1[i].isEmpty())
                        && (!strCED2[i].equals("") && !strCED2[i].isEmpty()) && (!strCED3[i].equals("") && !strCED3[i].isEmpty())
                        && (!strCED4[i].equals("") && !strCED4[i].isEmpty()) && (!strCED5[i].equals("") && !strCED5[i].isEmpty())
                        && (!strCED6[i].equals("") && !strCED6[i].isEmpty()) && (!strCED7[i].equals("") && !strCED7[i].isEmpty())
                        && (!strCED8[i].equals("") && !strCED8[i].isEmpty()) && (!strCED9[i].equals("") && !strCED9[i].isEmpty())) {
                    CandidateExperienceDetail ced = candidateExperienceDetailService.readById(Integer.parseInt(strCED0[i]));
                    ced.setExperienceYearFrom(Integer.parseInt(strCED1[i]));
                    ced.setExperienceYearTo(Integer.parseInt(strCED2[i]));
                    ced.setExperienceOrganization(strCED3[i]);
                    ced.setExperienceDepartment(strCED4[i]);
                    ced.setExperienceDesignation(strCED5[i]);
                    ced.setExperienceJobResponsibilities(strCED6[i]);
                    ced.setExperienceRemunerationOnJoin(strCED7[i]);
                    ced.setExperienceRemunerationOnLeaving(strCED8[i]);
                    ced.setExperienceReasonForLeaving(strCED9[i]);
                    candidateExperienceDetailService.update(ced);
                }
            }
            for (int i = cedList.size() + 1; i < strCED1.length; i++) {
                if ((!strCED1[i].equals("") && !strCED1[i].isEmpty())
                        && (!strCED2[i].equals("") && !strCED2[i].isEmpty()) && (!strCED3[i].equals("") && !strCED3[i].isEmpty())
                        && (!strCED4[i].equals("") && !strCED4[i].isEmpty()) && (!strCED5[i].equals("") && !strCED5[i].isEmpty())
                        && (!strCED6[i].equals("") && !strCED6[i].isEmpty()) && (!strCED7[i].equals("") && !strCED7[i].isEmpty())
                        && (!strCED8[i].equals("") && !strCED8[i].isEmpty()) && (!strCED9[i].equals("") && !strCED9[i].isEmpty())) {
                    CandidateExperienceDetail ced = new CandidateExperienceDetail();
                    ced.setExperienceYearFrom(Integer.parseInt(strCED1[i]));
                    ced.setExperienceYearTo(Integer.parseInt(strCED2[i]));
                    ced.setExperienceOrganization(strCED3[i]);
                    ced.setExperienceDepartment(strCED4[i]);
                    ced.setExperienceDesignation(strCED5[i]);
                    ced.setExperienceJobResponsibilities(strCED6[i]);
                    ced.setExperienceRemunerationOnJoin(strCED7[i]);
                    ced.setExperienceRemunerationOnLeaving(strCED8[i]);
                    ced.setExperienceReasonForLeaving(strCED9[i]);
                    ced.setCreatedDate(sdf.format(cdate));
                    ced.setCandidateApplyJob(candidateApplyJob);
                    candidateExperienceDetailService.create(ced);
                }
            }
        }

        //family background of candidate
        String strCFB0[] = request.getParameterValues("candidateFamilyBackground.id");
        String strCFB1[] = request.getParameterValues("candidateFamilyBackground.familyMemberName");
        String strCFB2[] = request.getParameterValues("candidateFamilyBackground.relationWithFamilyMember");
        String strCFB3[] = request.getParameterValues("candidateFamilyBackground.familyMemberAge");
        String strCFB4[] = request.getParameterValues("candidateFamilyBackground.familyMemberQualification");
        String strCFB5[] = request.getParameterValues("candidateFamilyBackground.familyMemberDesignationOccupation");
        String strCFB6[] = request.getParameterValues("candidateFamilyBackground.familyMemberMonthlyIncome");

        if (null == cfbList || cfbList.isEmpty()) {
            for (int i = 0; i < strCFB1.length; i++) {
                if ((!strCFB1[i].equals("") && !strCFB1[i].isEmpty())
                        && (!strCFB2[i].equals("") && !strCFB2[i].isEmpty()) && (!strCFB3[i].equals("") && !strCFB3[i].isEmpty())
                        && (!strCFB4[i].equals("") && !strCFB4[i].isEmpty()) && (!strCFB5[i].equals("") && !strCFB5[i].isEmpty())
                        && (!strCFB6[i].equals("") && !strCFB6[i].isEmpty())) {
                    CandidateFamilyBackground cfb = new CandidateFamilyBackground();
                    cfb.setFamilyMemberName(strCFB1[i]);
                    cfb.setRelationWithFamilyMember(strCFB2[i]);
                    cfb.setFamilyMemberAge(strCFB3[i]);
                    cfb.setFamilyMemberQualification(strCFB4[i]);
                    cfb.setFamilyMemberDesignationOccupation(strCFB5[i]);
                    cfb.setFamilyMemberMonthlyIncome(strCFB6[i]);
                    cfb.setCreatedDate(sdf.format(cdate));
                    cfb.setCandidateApplyJob(candidateApplyJob);
                    candidateFamilyBackgroundService.create(cfb);
                }
            }
        } else if ((cfbList != null || !cfbList.isEmpty()) && (strCFB1.length == cfbList.size())) {
            for (int i = 0; i < strCFB1.length; i++) {
                if ((!strCFB0[i].equals("") && !strCFB0[i].isEmpty()) && (!strCFB1[i].equals("") && !strCFB1[i].isEmpty())
                        && (!strCFB2[i].equals("") && !strCFB2[i].isEmpty()) && (!strCFB3[i].equals("") && !strCFB3[i].isEmpty())
                        && (!strCFB4[i].equals("") && !strCFB4[i].isEmpty()) && (!strCFB5[i].equals("") && !strCFB5[i].isEmpty())
                        && (!strCFB6[i].equals("") && !strCFB6[i].isEmpty())) {
                    CandidateFamilyBackground cfb = candidateFamilyBackgroundService.readById(Integer.parseInt(strCFB0[i]));
                    cfb.setFamilyMemberName(strCFB1[i]);
                    cfb.setRelationWithFamilyMember(strCFB2[i]);
                    cfb.setFamilyMemberAge(strCFB3[i]);
                    cfb.setFamilyMemberQualification(strCFB4[i]);
                    cfb.setFamilyMemberDesignationOccupation(strCFB5[i]);
                    cfb.setFamilyMemberMonthlyIncome(strCFB6[i]);
                    candidateFamilyBackgroundService.update(cfb);
                }
            }
        } else {
            for (int i = 0; i < cfbList.size(); i++) {
                if ((!strCFB0[i].equals("") && !strCFB0[i].isEmpty()) && (!strCFB1[i].equals("") && !strCFB1[i].isEmpty())
                        && (!strCFB2[i].equals("") && !strCFB2[i].isEmpty()) && (!strCFB3[i].equals("") && !strCFB3[i].isEmpty())
                        && (!strCFB4[i].equals("") && !strCFB4[i].isEmpty()) && (!strCFB5[i].equals("") && !strCFB5[i].isEmpty())
                        && (!strCFB6[i].equals("") && !strCFB6[i].isEmpty())) {
                    CandidateFamilyBackground cfb = candidateFamilyBackgroundService.readById(Integer.parseInt(strCFB0[i]));
                    cfb.setFamilyMemberName(strCFB1[i]);
                    cfb.setRelationWithFamilyMember(strCFB2[i]);
                    cfb.setFamilyMemberAge(strCFB3[i]);
                    cfb.setFamilyMemberQualification(strCFB4[i]);
                    cfb.setFamilyMemberDesignationOccupation(strCFB5[i]);
                    cfb.setFamilyMemberMonthlyIncome(strCFB6[i]);
                    candidateFamilyBackgroundService.update(cfb);
                }
            }
            for (int i = cfbList.size() + 1; i < strCFB1.length; i++) {
                if ((!strCFB1[i].equals("") && !strCFB1[i].isEmpty())
                        && (!strCFB2[i].equals("") && !strCFB2[i].isEmpty()) && (!strCFB3[i].equals("") && !strCFB3[i].isEmpty())
                        && (!strCFB4[i].equals("") && !strCFB4[i].isEmpty()) && (!strCFB5[i].equals("") && !strCFB5[i].isEmpty())
                        && (!strCFB6[i].equals("") && !strCFB6[i].isEmpty())) {
                    CandidateFamilyBackground cfb = new CandidateFamilyBackground();
                    cfb.setFamilyMemberName(strCFB1[i]);
                    cfb.setRelationWithFamilyMember(strCFB2[i]);
                    cfb.setFamilyMemberAge(strCFB3[i]);
                    cfb.setFamilyMemberQualification(strCFB4[i]);
                    cfb.setFamilyMemberDesignationOccupation(strCFB5[i]);
                    cfb.setFamilyMemberMonthlyIncome(strCFB6[i]);
                    cfb.setCreatedDate(sdf.format(cdate));
                    cfb.setCandidateApplyJob(candidateApplyJob);
                    candidateFamilyBackgroundService.create(cfb);
                }
            }
        }

        //other references of candidate
        String strCOR0[] = request.getParameterValues("candidateOtherReferences.id");
        String strCOR1[] = request.getParameterValues("candidateOtherReferences.referenceNonRelativesName");
        String strCOR2[] = request.getParameterValues("candidateOtherReferences.referenceNonRelativesOrganization");
        String strCOR3[] = request.getParameterValues("candidateOtherReferences.referenceNonRelativesPosition");
        String strCOR4[] = request.getParameterValues("candidateOtherReferences.referenceNonRelativesContactNmber");

        if (null == corList || corList.isEmpty()) {
            for (int i = 0; i < strCOR1.length; i++) {
                if ((!strCOR1[i].equals("") && !strCOR1[i].isEmpty())
                        && (!strCOR2[i].equals("") && !strCOR2[i].isEmpty()) && (!strCOR3[i].equals("") && !strCOR3[i].isEmpty())
                        && (!strCOR4[i].equals("") && !strCOR4[i].isEmpty())) {
                    CandidateOtherReferences cor = new CandidateOtherReferences();
                    cor.setReferenceNonRelativesName(strCOR1[i]);
                    cor.setReferenceNonRelativesOrganization(strCOR2[i]);
                    cor.setReferenceNonRelativesPosition(strCOR3[i]);
                    cor.setReferenceNonRelativesContactNmber(strCOR4[i]);
                    cor.setCreatedDate(sdf.format(cdate));
                    cor.setCandidateApplyJob(candidateApplyJob);
                    candidateOtherReferencesService.create(cor);
                }
            }
        } else if ((corList != null || !corList.isEmpty()) && (strCOR1.length == corList.size())) {
            for (int i = 0; i < strCOR1.length; i++) {
                if ((!strCOR0[i].equals("") && !strCOR0[i].isEmpty()) && (!strCOR1[i].equals("") && !strCOR1[i].isEmpty())
                        && (!strCOR2[i].equals("") && !strCOR2[i].isEmpty()) && (!strCOR3[i].equals("") && !strCOR3[i].isEmpty())
                        && (!strCOR4[i].equals("") && !strCOR4[i].isEmpty())) {
                    CandidateOtherReferences cor = candidateOtherReferencesService.readById(Integer.parseInt(strCOR0[i]));
                    cor.setReferenceNonRelativesName(strCOR1[i]);
                    cor.setReferenceNonRelativesOrganization(strCOR2[i]);
                    cor.setReferenceNonRelativesPosition(strCOR3[i]);
                    cor.setReferenceNonRelativesContactNmber(strCOR4[i]);
                    candidateOtherReferencesService.update(cor);
                }
            }
        } else {
            for (int i = 0; i < corList.size(); i++) {
                if ((!strCOR0[i].equals("") && !strCOR0[i].isEmpty()) && (!strCOR1[i].equals("") && !strCOR1[i].isEmpty())
                        && (!strCOR2[i].equals("") && !strCOR2[i].isEmpty()) && (!strCOR3[i].equals("") && !strCOR3[i].isEmpty())
                        && (!strCOR4[i].equals("") && !strCOR4[i].isEmpty())) {
                    CandidateOtherReferences cor = candidateOtherReferencesService.readById(Integer.parseInt(strCOR0[i]));
                    cor.setReferenceNonRelativesName(strCOR1[i]);
                    cor.setReferenceNonRelativesOrganization(strCOR2[i]);
                    cor.setReferenceNonRelativesPosition(strCOR3[i]);
                    cor.setReferenceNonRelativesContactNmber(strCOR4[i]);
                    candidateOtherReferencesService.update(cor);
                }
            }
            for (int i = corList.size() + 1; i < strCOR1.length; i++) {
                if ((!strCOR1[i].equals("") && !strCOR1[i].isEmpty())
                        && (!strCOR2[i].equals("") && !strCOR2[i].isEmpty()) && (!strCOR3[i].equals("") && !strCOR3[i].isEmpty())
                        && (!strCOR4[i].equals("") && !strCOR4[i].isEmpty())) {
                    CandidateOtherReferences cor = new CandidateOtherReferences();
                    cor.setReferenceNonRelativesName(strCOR1[i]);
                    cor.setReferenceNonRelativesOrganization(strCOR2[i]);
                    cor.setReferenceNonRelativesPosition(strCOR3[i]);
                    cor.setReferenceNonRelativesContactNmber(strCOR4[i]);
                    cor.setCreatedDate(sdf.format(cdate));
                    cor.setCandidateApplyJob(candidateApplyJob);
                    candidateOtherReferencesService.create(cor);
                }
            }
        }

        if (ajuMaster.getProfileSubmit() != 1) {
            ajuMaster.setProfileSubmit(1);
            applayJobUserMasterSerivce.update(ajuMaster);
        }

        request.setAttribute("successMessage",
                "Information : The Information is Updated Successfully.");

        request.setAttribute("caqList", caqList);
        request.setAttribute("cedList", cedList);
        request.setAttribute("cfbList", cfbList);
        request.setAttribute("corList", corList);
        mv.getModelMap().put("ajuMaster", ajuMaster);
        mv = candidateProfile(request, response);

        return mv;
    }

    public void downloadCandidatePhotograph(HttpServletRequest request, HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession();
        ApplayJobUserMaster ajuMaster = (ApplayJobUserMaster) session.getAttribute("ApplayJobUserMaster");

        String fileName = request.getParameter("fileName");

        String attachmentFileLocationURL = getServletContext().getRealPath("/")
                + File.separator + "StorageYard"
                + File.separator + "candidate" + File.separator + "candidateimage" + File.separator + ajuMaster.getId().toString() + File.separator + fileName;

        request.setAttribute("filePath", attachmentFileLocationURL);

        DownloadFile downloadFile = new DownloadFile();
        downloadFile.doDownload(request, response);
    }

    public void downloadCandidateCertificate(HttpServletRequest request, HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession();
        ApplayJobUserMaster ajuMaster = (ApplayJobUserMaster) session.getAttribute("ApplayJobUserMaster");

        String id = request.getParameter("cajid");
        String fileName = request.getParameter("fileName");
        String attachmentFileLocationURL = null;
        if (id == null || id.equals("") || id.isEmpty()) {
            attachmentFileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard"
                    + File.separator + "candidate" + File.separator + "candidatecertificate" + File.separator + ajuMaster.getId().toString() + File.separator + fileName;
        } else {
            CandidateApplyJob candidateApplyJob = candidateJobApplyService.readById(Integer.parseInt(id));
            attachmentFileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard"
                    + File.separator + "candidate" + File.separator + "candidatecertificate" + File.separator + candidateApplyJob.getApplayJobUserMaster().getId().toString() + File.separator + fileName;
        }
        request.setAttribute("filePath", attachmentFileLocationURL);

        DownloadFile downloadFile = new DownloadFile();
        downloadFile.doDownload(request, response);
    }

    public void downloadCandidateSalaryAttachment(HttpServletRequest request, HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession();
        ApplayJobUserMaster ajuMaster = (ApplayJobUserMaster) session.getAttribute("ApplayJobUserMaster");

        String id = request.getParameter("cajid");
        String fileName = request.getParameter("fileName");
        String attachmentFileLocationURL = null;
        if (id == null || id.equals("") || id.isEmpty()) {
            attachmentFileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard"
                    + File.separator + "candidate" + File.separator + "candidatesalaryslip" + File.separator + ajuMaster.getId().toString() + File.separator + fileName;
        } else {
            CandidateApplyJob candidateApplyJob = candidateJobApplyService.readById(Integer.parseInt(id));
            attachmentFileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard"
                    + File.separator + "candidate" + File.separator + "candidatesalaryslip" + File.separator + candidateApplyJob.getApplayJobUserMaster().getId().toString() + File.separator + fileName;
        }

        request.setAttribute("filePath", attachmentFileLocationURL);

        DownloadFile downloadFile = new DownloadFile();
        downloadFile.doDownload(request, response);
    }

    public ModelAndView clickassessment(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        ApplayJobUserMaster applayJobUserMaster = new ApplayJobUserMaster();
        String id = request.getParameter("id");
        Integer applayJobUserMasterId = 0;
        Integer candidateApplyJobid = 0;
        List listOfFinalList = new ArrayList();
        List<?> list1 = candidateJobApplicationService.readOnlineAssementCandidate(Integer.parseInt(id));
        if (!list1.isEmpty()) {
            for (Object o1 : list1) {
                Object str[] = (Object[]) o1;
                Integer CandidateJobApplicationID = (Integer) str[0];
                applayJobUserMasterId = (Integer) str[1];
                candidateApplyJobid = (Integer) str[2];
                Integer vacancyMasterID = (Integer) str[3];

                List<?> list2 = onlineAssessmentService.readOnlineAssementCandidateList(CandidateJobApplicationID);
                if (!list2.isEmpty()) {
                    for (Object o2 : list2) {
                        Object str1[] = (Object[]) o2;
                        List finalList = new ArrayList();
                        Integer onlineAssessmentID = (Integer) str1[0];
                        finalList.add(onlineAssessmentID);
                        Integer candidateJobApplicationID = (Integer) str1[1];
                        finalList.add(candidateJobApplicationID);
                        Integer questionPaperId = (Integer) str1[2];
                        finalList.add(questionPaperId);
                        Double passingPercentage = (Double) str1[3];
                        finalList.add(passingPercentage);
                        String validityFrom = (String) str1[4];
                        finalList.add(validityFrom);
                        String validityTo = (String) str1[5];
                        finalList.add(validityTo);
                        String duration = (String) str1[6];
                        finalList.add(duration);
                        Integer noOfAttampt = (Integer) str1[7];
                        finalList.add(noOfAttampt);
                        Integer noOfQue = (Integer) str1[8];
                        finalList.add(noOfQue);
                        Double totalMarks = (Double) str1[9];
                        finalList.add(totalMarks);
                        String paperName = (String) str1[10];
                        finalList.add(paperName);
                        finalList.add(candidateApplyJobid);
                        finalList.add(vacancyMasterID);
                        listOfFinalList.add(finalList);

                    }
                }

            }
        }
        mv.getModelMap().put("list2", listOfFinalList);
//        mv.getModelMap().put("candidateApplyJobid", candidateApplyJobid);
        mv.setViewName("Vacancy/AssementOnline");

        return mv;
    }

//    }
    public ModelAndView backToHomeVacancyList(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        VacancyMaster vacancyMaster = new VacancyMaster();
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String date = sdf.format(d);

        List<?> vacancylist = vacancyMasterService.fetchVacancyBydate(date);
        mv.getModelMap().put("list", vacancylist);
        mv.getModelMap().put("vacancyMaster", vacancyMaster);
        mv.setViewName("Vacancy/ShowVacancyList");
        return mv;
    }

    public ModelAndView createVacancyNewButton(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        VacancyMaster vacancyMaster = new VacancyMaster();
        DepartmentMaster departmentMaster = new DepartmentMaster();
        LocationMaster locationMaster = new LocationMaster();
        JobtypeMaster jobtypeMaster = new JobtypeMaster();
        MprEmployeeCategory mprEmployeeCategory = new MprEmployeeCategory();
        MprEmployeeTypeMaster employeeTypeMaster = new MprEmployeeTypeMaster();
        DesignationMaster designationMaster = new DesignationMaster();
        if (vacancyMaster.getId() != null) {
            vacancyMaster = vacancyMasterService.readById(vacancyMaster.getId());
            vacancyMaster.setLocationMaster(vacancyMaster.getLocationMaster());
            vacancyMaster.setDepartmentMaster(vacancyMaster.getDepartmentMaster());
            vacancyMaster.setJobtypeMaster(vacancyMaster.getJobtypeMaster());
            vacancyMaster.setDesignationMaster(vacancyMaster.getDesignationMaster());
        } else {
            vacancyMaster.setLocationMaster(new LocationMaster());
            vacancyMaster.setDepartmentMaster(new DepartmentMaster());
            vacancyMaster.setJobtypeMaster(new JobtypeMaster());
            vacancyMaster.setDesignationMaster(new DesignationMaster());
        }
        departmentList(request);
        designationList(request);
        Map<Integer, String> locationMap = readLocations();
        Map<Integer, String> jobtype1 = jobtypeList();
        mv.addObject("locationMap", locationMap);
        mv.addObject("jobtype1", jobtype1);
        vacancyMaster.setDepartmentMaster(new DepartmentMaster());
        vacancyMaster.setLocationMaster(new LocationMaster());
        vacancyMaster.setJobtypeMaster(new JobtypeMaster());
        vacancyMaster.setDesignationMaster(new DesignationMaster());
        mv.getModelMap().put("departmentMaster", departmentMaster);
        mv.getModelMap().put("locationMaster", locationMaster);
        mv.getModelMap().put("jobtypeMaster", jobtypeMaster);
        mv.getModelMap().put("designationMaster", designationMaster);
        mv.getModelMap().put("vacancyMaster", vacancyMaster);
        mv.setViewName("Vacancy/NewButtonCreateVacancy");
        return mv;
    }

    public ModelAndView logout(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        ApplayJobUserMaster ajuMaster = (ApplayJobUserMaster) session.getAttribute("ApplayJobUserMaster");
        session.invalidate();
        VacancyMaster vacancyMaster = new VacancyMaster();
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String date = sdf.format(d);
//        List<?> vacancylist = vacancyMasterService.fetchVacancyDetail();
        List<?> vacancylist = vacancyMasterService.fetchVacancyBydate(date);
        mv.getModelMap().put("list", vacancylist);
        mv.getModelMap().put("vacancyMaster", vacancyMaster);
        mv.setViewName("Vacancy/ShowVacancyList");
        return mv;

    }

    public ModelAndView candidateProfile(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        ApplayJobUserMaster ajuMaster = (ApplayJobUserMaster) session.getAttribute("ApplayJobUserMaster");
        List<CandidateApplyJob> candidateProfile = (List<CandidateApplyJob>) candidateJobApplyService.readProfileByCandidateUserID(ajuMaster.getId());
        List<?> CandidateJobApplyList = new ArrayList<>();

        if (!candidateProfile.isEmpty()) {
            CandidateApplyJob caj = (CandidateApplyJob) candidateProfile.get(0);
            CandidateJobApplyList = candidateJobApplicationService.readByCandidateId(caj.getId());
        }

        request.setAttribute("list", CandidateJobApplyList);
        mv.getModelMap().put("ajuMaster", ajuMaster);
        mv.setViewName("Vacancy/MemberVacancyList");
        return mv;

    }

    public ModelAndView candidateEditProfile(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession();
        ApplayJobUserMaster ajuMaster = (ApplayJobUserMaster) session.getAttribute("ApplayJobUserMaster");
        CandidateApplyJob candidateApplyJob = new CandidateApplyJob();
        BindException errors = new BindException(candidateApplyJob, "candidateApplyJob");
        bind(request, candidateApplyJob);

        CandidateApplyJob caj = candidateJobApplyService.readById(candidateApplyJob.getId());

        String fileLocationURL = getServletContext().getRealPath("/")
                + File.separator + "StorageYard"
                + File.separator + "candidateimage" + File.separator + "" + caj.getPhotograph();
        File File = new File(fileLocationURL);
        File.delete();

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile = multipartRequest.getFile("photograph");
//        if (candidateJobApplyService.isExist(multipartFile.getOriginalFilename())) {
        String fileLocationURL2 = getServletContext().getRealPath("/")
                + File.separator + "StorageYard"
                + File.separator + "candidateimage" + File.separator;
        String fileLocationURL1 = "StorageYard"
                + File.separator + "candidateimage" + File.separator;
        File Folder1 = new File(fileLocationURL2);
        if (!Folder1.exists()) {
            Folder1.mkdirs();
        }
        if (multipartFile != null && multipartFile.getSize() > 0) {
            try {
                File file2 = new File(fileLocationURL2 + multipartFile.getOriginalFilename().replaceAll(" ", "_"));
                File file = new File(fileLocationURL1 + multipartFile.getOriginalFilename().replaceAll(" ", "_"));
                multipartFile.transferTo(file2);
                candidateApplyJob.setPhotograph(multipartFile.getOriginalFilename().replaceAll(" ", "_"));
            } catch (Exception e) {

            }
        }
//        }

        String fileLocationURL11 = getServletContext().getRealPath("/")
                + File.separator + "StorageYard"
                + File.separator + "CertificateAttach" + File.separator + "" + caj.getCertificateAttach();
        File File1 = new File(fileLocationURL11);
        File1.delete();

        MultipartHttpServletRequest multipartRequest1 = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile1 = multipartRequest.getFile("certificateId1");
//        if (candidateJobApplyService.isExistCertificateAttach(multipartFile1.getOriginalFilename())) {
        String fileLocationURL3 = getServletContext().getRealPath("/")
                + File1.separator + "StorageYard"
                + File1.separator + "CertificateAttach" + File1.separator;
        String fileLocationURL12 = "StorageYard"
                + File1.separator + "CertificateAttach" + File1.separator;
        File Folder12 = new File(fileLocationURL3);
        if (!Folder12.exists()) {
            Folder12.mkdirs();
        }
        if (multipartFile1 != null && multipartFile1.getSize() > 0) {
            try {
                File file2 = new File(fileLocationURL3 + multipartFile1.getOriginalFilename().replaceAll(" ", "_"));
                File file = new File(fileLocationURL12 + multipartFile1.getOriginalFilename().replaceAll(" ", "_"));
                multipartFile1.transferTo(file2);
                candidateApplyJob.setCertificateAttach(multipartFile1.getOriginalFilename().replaceAll(" ", "_"));
            } catch (Exception e) {

            }
        }
//        }

        candidateApplyJob.setApplayJobUserMaster(caj.getApplayJobUserMaster());
        candidateJobApplyService.update(candidateApplyJob);

        if (ajuMaster.getProfileSubmit() != 1) {

            ajuMaster.setProfileSubmit(1);
            applayJobUserMasterSerivce.update(ajuMaster);

        }

        request.setAttribute("successMessage",
                "Information : The Information is Updated Successfully.");

        List<?> CandidateJobApplyList = candidateJobApplicationService.readByCandidateId(caj.getId());

        request.setAttribute("list", CandidateJobApplyList);
        mv.getModelMap().put("ajuMaster", ajuMaster);
        mv.setViewName("Vacancy/MemberVacancyList");

        return mv;
    }

    public ModelAndView clickassessmentOnlineTest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        ApplayJobUserMaster applayJobUserMaster = new ApplayJobUserMaster();
        OnlineAssessment onlineAssessment = new OnlineAssessment();
        String id = request.getParameter("id");
        String candidateID = request.getParameter("candidateID");
        String onlineAssmentID = request.getParameter("onlineAssment");
        String vanacyID = request.getParameter("vanacyID");
        SimpleDateFormat sdfAb = new SimpleDateFormat("hh:mm:ss");
        Date cDate1 = new Date();
        String time = sdfAb.format(cDate1);
        onlineAssessment = onlineAssessmentService.readById(Integer.parseInt(onlineAssmentID));
//        onlineAssessment.setId(Integer.parseInt(onlineAssmentID));
        String StartTime1 = onlineAssessment.getStartTimeNow();
        if (null == StartTime1 || "" == StartTime1 || StartTime1.isEmpty()) {
            onlineAssessment.setStartTimeNow(time);
            Integer attempt = onlineAssessment.getNoOfAttampt();
            Integer NoofAttemptleft = attempt - 1;
            onlineAssessment.setNoOfAttampt(NoofAttemptleft);
            onlineAssessmentService.update(onlineAssessment);
        }

        String Duration = onlineAssessment.getDuration();
        String StartTime = onlineAssessment.getStartTimeNow();
//        String Duration = onlineAssessment.getDuration();
        List listOfFinalList = new ArrayList();
        List<?> list1 = questionDetailsService.takeTestOnlineAssementCandidate(Integer.parseInt(id));
        for (Object o1 : list1) {
            Object str[] = (Object[]) o1;
            List finalList = new ArrayList();
            Integer questionDetailsID = (Integer) str[0];
            Integer questionPaperId = (Integer) str[1];
            Integer questionLibraryID = (Integer) str[2];
            QuestionLibrary questionLibrary = new QuestionLibrary();
            questionLibrary = questionLibraryService.readById(questionLibraryID);
            Integer questionLibraryid = questionLibrary.getId();
            String question = questionLibrary.getQuestion();
            finalList.add(question);
            Integer type = questionLibrary.getType();
            finalList.add(type);
            finalList.add(questionLibraryid);

            List<?> list2 = questionAnsService.takeTestOnlineAssementCandidateAnswer(questionLibraryid);
            for (Object o2 : list2) {
                Object str1[] = (Object[]) o2;
                Integer questionAnsID = (Integer) str1[0];
                String answer = (String) str1[2];
                finalList.add(answer);
                finalList.add(questionAnsID);
            }
            listOfFinalList.add(finalList);
        }
//        
        mv.getModelMap().put("list2", listOfFinalList);
        mv.getModelMap().put("candidateID", candidateID);
        mv.getModelMap().put("Duration", Duration);
        mv.getModelMap().put("StartTime", StartTime);
        mv.getModelMap().put("onlineAssmentID", onlineAssmentID);
        mv.getModelMap().put("vanacyID", vanacyID);
        mv.setViewName("Vacancy/OnlineTestQuestionPaper");

        return mv;
    }

    public ModelAndView clickSubmitQuestionAnswer(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();

        CandidateJobApplication candidateJobApplication = new CandidateJobApplication();

        String candidateiD = request.getParameter("candidateId");
        String vanacyID = request.getParameter("vanacyID");
        int candidateJobapplicationid = candidateJobApplicationService.GETByCandidateIdNew(Integer.parseInt(candidateiD), Integer.parseInt(vanacyID));

        String[] question = request.getParameterValues("finalData1");
        String[] email = request.getParameterValues("finalData");
        String[] checkstatus = request.getParameterValues("finalData2");
//       
        String[] doneId1 = email[0].split(",");
        String[] doneId2 = question[0].split(",");
        String[] doneId3 = checkstatus[0].split(",");
        String emailId = "";
        String emailId1 = "";
//     
        for (int i = 0; i < doneId2.length; i++) {
            QuestionAnswerSubmit questionAnswerSubmit = new QuestionAnswerSubmit();
            QuestionAns questionAns = new QuestionAns();

            QuestionLibrary questionLibrary = new QuestionLibrary();
            String ques = doneId2[i];
            String ans = doneId1[i];
            String status = doneId3[i];
            if (Integer.parseInt(status) == (1)) {
                questionAnswerSubmit.setDescription(ans);
            } else {

                questionAns.setId(Integer.parseInt(ans));
            }
//            boolean parsable = true;
//            try {
//                Integer.parseInt(ans);
//                questionAns.setId(Integer.parseInt(ans));
//            } catch (Exception e) {
//                parsable = false;
//                questionAnswerSubmit.setDescription(ans);
//            }
//            return parsable;

            questionAnswerSubmit.setQuestionAnsId(questionAns);// Question Anaswer Id set
            candidateJobApplication.setId(candidateJobapplicationid);
            candidateJobApplication = candidateJobApplicationService.readById(candidateJobapplicationid);
            candidateJobApplication.setStatus(4);// set 4 bz candidate submision
            candidateJobApplicationService.update(candidateJobApplication);
            questionAnswerSubmit.setCandidateJobApplicationid(candidateJobApplication);/// candidate Apply job ID set 
            questionLibrary.setId(Integer.parseInt(ques));
            questionAnswerSubmit.setQuestionLibraryId(questionLibrary);
            questionAnswerSubmitService.create(questionAnswerSubmit);
//             mv.setViewName("Vacancy/AssementOnline");
        }
        return mv;

    }

    public ModelAndView CreateNewVacancy(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        VacancyMaster vacancyMaster = new VacancyMaster();
        DepartmentMaster departmentMaster = new DepartmentMaster();
        LocationMaster locationMaster = new LocationMaster();
        JobtypeMaster jobtypeMaster = new JobtypeMaster();
        BindException errors = new BindException(vacancyMaster, "vacancyMaster");
        bind(request, vacancyMaster);
        List<ApprovalUser> approvalList = (List<ApprovalUser>) approvalUserService.readByApprovalId(5);
        String mprMasterid = request.getParameter("mprMasterid");
        MprMaster mm = mprMasterService.readById(Integer.parseInt(mprMasterid));
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date cDate = new Date();
        vacancyMaster.setDescription(vacancyMaster.getDescription().replaceAll("&Acirc;", ""));

        departmentList(request);
        designationList(request);
        Map<Integer, String> locationMap = readLocations();
        Map<Integer, String> jobtype1 = jobtypeList();
        mv.addObject("locationMap", locationMap);
        mv.addObject("jobtype1", jobtype1);

        vacancyValidator.validate(vacancyMaster, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "All field are Required.Please Enter Valid data");
            mv.addAllObjects(errors.getModel());
            mv.setViewName("Vacancy/NewButtonCreateVacancy");
        } else {
            vacancyMaster.setStatus(0);
            vacancyMaster.setCreatedBy(employeeMaster.getId());
            vacancyMaster.setCreatedDate(sdf.format(cDate));
            vacancyMaster.setMprMaster(mm);
            vacancyMaster.setCurrentLevel(1);
            vacancyMaster.setTotalLevel(approvalList.size());
            vacancyMasterService.create(vacancyMaster);

            for (ApprovalUser au : approvalList) {
                VacancyApproval vacancyApproval = new VacancyApproval();
                vacancyApproval.setEmployeeMaster(au.getEmployeeMaster());
                vacancyApproval.setVacancyMaster(vacancyMaster);
                vacancyApproval.setLevel(au.getLevel());
                vacancyApproval.setCreatedBy(employeeMaster.getId());
                vacancyApproval.setCreatedDate(sdf.format(cDate));
                vacancyApprovalService.create(vacancyApproval);
            }

            VacancyApprovalHistory vah = new VacancyApprovalHistory();
            vah.setVacancyMaster(vacancyMaster);
            vah.setComment("Vacancy Creator");
            vah.setCreatedBy(employeeMaster.getEmployeeName());
            vah.setCreatedDate(sdf.format(cDate));
            vah.setStatus(0);
            vah.setStatusMessage("Vacancy Creted");
            vacancyApprovalHistoryService.create(vah);

            request.setAttribute("successMessage",
                    "Information : The Information is saved Successfully.");

            mv = vacancyDetailList(request, response);
        }

        return mv;
    }

    public ModelAndView vacancyFetch(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        VacancyMaster vacancyMaster = new VacancyMaster();

        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String date = sdf.format(d);
//        List<?> vacancylist = vacancyMasterService.fetchVacancyDetail();
        List<?> vacancylist = vacancyMasterService.fetchVacancyBydate(date);
        mv.getModelMap().put("list", vacancylist);
        mv.getModelMap().put("vacancyMaster", vacancyMaster);
        mv.setViewName("Vacancy/vacancyList");
        return mv;
    }

    public ModelAndView clickSubmitQuestionAnswerExpired(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();

        OnlineAssessment onlineAssessment = new OnlineAssessment();

        String onlineAssmentID = request.getParameter("onlineAssmentID");
        onlineAssessment = onlineAssessmentService.readById(Integer.parseInt(onlineAssmentID));

        onlineAssessment.setStartTimeNow(null);
        onlineAssessmentService.update(onlineAssessment);
        mv = Login(request, response);

        return mv;
    }

    public ModelAndView backToHomeVacancyListCandidate(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();

        OnlineAssessment onlineAssessment = new OnlineAssessment();

        String onlineAssmentID = request.getParameter("onlineAssmentID");
        onlineAssessment = onlineAssessmentService.readById(Integer.parseInt(onlineAssmentID));

        onlineAssessment.setStartTimeNow(null);
        onlineAssessmentService.update(onlineAssessment);
        VacancyMaster vacancyMaster = new VacancyMaster();
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String date = sdf.format(d);
//        List<?> vacancylist = vacancyMasterService.fetchVacancyDetail();
        List<?> vacancylist = vacancyMasterService.fetchVacancyBydate(date);
        mv.getModelMap().put("list", vacancylist);
        mv.getModelMap().put("vacancyMaster", vacancyMaster);
        mv.setViewName("Vacancy/ShowVacancyList");
        return mv;
    }

    public ModelAndView logoutCandidateLogout(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();

        OnlineAssessment onlineAssessment = new OnlineAssessment();

        String onlineAssmentID = request.getParameter("onlineAssmentID");
        onlineAssessment = onlineAssessmentService.readById(Integer.parseInt(onlineAssmentID));

        onlineAssessment.setStartTimeNow(null);
        onlineAssessmentService.update(onlineAssessment);
        HttpSession session = request.getSession(false);
        ApplayJobUserMaster ajuMaster = (ApplayJobUserMaster) session.getAttribute("ApplayJobUserMaster");
        session.invalidate();
        VacancyMaster vacancyMaster = new VacancyMaster();
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String date = sdf.format(d);
//        List<?> vacancylist = vacancyMasterService.fetchVacancyDetail();
        List<?> vacancylist = vacancyMasterService.fetchVacancyBydate(date);
        mv.getModelMap().put("list", vacancylist);
        mv.getModelMap().put("vacancyMaster", vacancyMaster);
        mv.setViewName("Vacancy/ShowVacancyList");
        return mv;

    }

    public ModelAndView otpGenerate(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession();
        String apjid = request.getParameter("apjid");
        String otp = request.getParameter("otp");

        ApplayJobUserMaster applayJobUserMaster = applayJobUserMasterSerivce.readById(Integer.parseInt(apjid));
        String userName = applayJobUserMaster.getUserName();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        Date startDate = sdf.parse(applayJobUserMaster.getTimeValidity());
        Date endDate = new Date();
        long data = endDate.getTime() - startDate.getTime();

        if (applayJobUserMaster != null && !"".equals(applayJobUserMaster)) {
            if (data < 300001) {
                if (otp.equals(applayJobUserMaster.getOtp())) {
                    applayJobUserMaster.setStatusOtp(1);
                    applayJobUserMasterSerivce.update(applayJobUserMaster);
                    return new ModelAndView("Vacancy/ApplayLoginpage", "applayJobUserMaster", applayJobUserMaster);
                } else {
                    request.setAttribute("failureMessage",
                            "Your entered OTP is Wrong..!!");
                    return new ModelAndView("Vacancy/CandidateOTPSubmit", "applayJobUserMaster", applayJobUserMaster);
                }
            } else {
                request.setAttribute("failureMessage",
                        "Your OTP Validity is Expired...");
                return new ModelAndView("Vacancy/CandidateOTPSubmit", "applayJobUserMaster", applayJobUserMaster);
            }
        } else {
            request.setAttribute("failureMessage",
                    "OTP Is not Valid");
            return new ModelAndView("Vacancy/CandidateOTPSubmit", "applayJobUserMaster", applayJobUserMaster);

        }
    }

    public ModelAndView vacancyShowByApprove(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        VacancyMaster vacancyMaster = new VacancyMaster();
        List<?> vacancylist = vacancyMasterService.fetchApprovVacancy(employeeMaster.getId());
        mv.getModelMap().put("list", vacancylist);
        mv.getModelMap().put("vacancyMaster", vacancyMaster);
        mv.setViewName("Vacancy/VacancyApprovalList");
        return mv;
    }

    public ModelAndView viewApproveVacancy(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        VacancyMaster vacancyMaster = new VacancyMaster();
        DepartmentMaster departmentMaster = new DepartmentMaster();
        LocationMaster locationMaster = new LocationMaster();
        JobtypeMaster jobtypeMaster = new JobtypeMaster();
        DesignationMaster designationMaster = new DesignationMaster();
        if (vacancyMaster.getId() != null) {
            vacancyMaster = vacancyMasterService.readById(vacancyMaster.getId());
            vacancyMaster.setLocationMaster(vacancyMaster.getLocationMaster());
            vacancyMaster.setDepartmentMaster(vacancyMaster.getDepartmentMaster());
            vacancyMaster.setJobtypeMaster(vacancyMaster.getJobtypeMaster());
            vacancyMaster.setDesignationMaster(vacancyMaster.getDesignationMaster());
        } else {
            vacancyMaster.setLocationMaster(new LocationMaster());
            vacancyMaster.setDepartmentMaster(new DepartmentMaster());
            vacancyMaster.setJobtypeMaster(new JobtypeMaster());
            vacancyMaster.setDesignationMaster(new DesignationMaster());
        }
        departmentList(request);
        designationList(request);
        Map<Integer, String> locationMap = readLocations();
        Map<Integer, String> jobtype1 = jobtypeList();
        mv.addObject("locationMap", locationMap);
        mv.addObject("jobtype1", jobtype1);

        String id = request.getParameter("id");
        vacancyMaster = vacancyMasterService.readById(Integer.parseInt(id));
        mv.getModelMap().put("departmentMaster", departmentMaster);
        mv.getModelMap().put("locationMaster", locationMaster);
        mv.getModelMap().put("jobtypeMaster", jobtypeMaster);
        mv.getModelMap().put("designationMaster", designationMaster);
        mv.getModelMap().put("vacancyMaster", vacancyMaster);
        mv.setViewName("Vacancy/ViewApproveVacancy");
        return mv;
    }

    public ModelAndView ShowVacancy(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        VacancyMaster vacancyMaster = new VacancyMaster();
        DepartmentMaster departmentMaster = new DepartmentMaster();
        LocationMaster locationMaster = new LocationMaster();
        JobtypeMaster jobtypeMaster = new JobtypeMaster();
        DesignationMaster designationMaster = new DesignationMaster();
        if (vacancyMaster.getId() != null) {
            vacancyMaster = vacancyMasterService.readById(vacancyMaster.getId());
            vacancyMaster.setLocationMaster(vacancyMaster.getLocationMaster());
            vacancyMaster.setDepartmentMaster(vacancyMaster.getDepartmentMaster());
            vacancyMaster.setJobtypeMaster(vacancyMaster.getJobtypeMaster());
            vacancyMaster.setDesignationMaster(vacancyMaster.getDesignationMaster());
        } else {
            vacancyMaster.setLocationMaster(new LocationMaster());
            vacancyMaster.setDepartmentMaster(new DepartmentMaster());
            vacancyMaster.setJobtypeMaster(new JobtypeMaster());
            vacancyMaster.setDesignationMaster(new DesignationMaster());
        }
        departmentList(request);
        designationList(request);
        Map<Integer, String> locationMap = readLocations();
        Map<Integer, String> jobtype1 = jobtypeList();
        mv.addObject("locationMap", locationMap);
        mv.addObject("jobtype1", jobtype1);

        String id = request.getParameter("id");
        List<?> HistoryList = vacancyApprovalHistoryService.readByVacancyId(Integer.parseInt(id));
        vacancyMaster = vacancyMasterService.readById(Integer.parseInt(id));

        int jobtypeId = vacancyMaster.getJobtypeMaster().getId();
        jobtypeMaster = jobtypeMasterService.readById(jobtypeId);
        String jobtypeNAme = jobtypeMaster.getJobTypeName();

        int department = vacancyMaster.getDepartmentMaster().getId();
        departmentMaster = departmentMasterService.readById(department);
        String departmentName = departmentMaster.getDepartmentName();

        int localtion = vacancyMaster.getLocationMaster().getId();
        locationMaster = locationMasterService.readById(localtion);
        String locationName = locationMaster.getLocation();

        int designation = vacancyMaster.getDesignationMaster().getId();
        designationMaster = designationMasterService.readById(designation);
        String designationName = designationMaster.getDesignationName();

        mv.getModelMap().put("departmentName", departmentName);
        mv.getModelMap().put("locationName", locationName);
        mv.getModelMap().put("jobtypeNAme", jobtypeNAme);
        mv.getModelMap().put("designationName", designationName);
        mv.getModelMap().put("vacancyMaster", vacancyMaster);
        mv.getModelMap().put("list", HistoryList);
        mv.setViewName("Vacancy/ShowVacancyOnly");
        return mv;
    }

    public ModelAndView submitVacancyApprove(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        VacancyMaster vacancyMaster1 = new VacancyMaster();
        VacancyApprovalHistory approvalHistory = new VacancyApprovalHistory();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        bind(request, vacancyMaster1);
        String btnType = request.getParameter("btnType");
        String id = request.getParameter("id");
        String comment = request.getParameter("comment");
        VacancyMaster vacancyMaster = vacancyMasterService.readById(Integer.parseInt(id));
        VacancyApproval vacancyApproval = vacancyApprovalService.readEmpIdAndVaId(employeeMaster.getId(), Integer.parseInt(id));
        int userLevel = vacancyApproval.getLevel();
        int CurrentLevel = vacancyMaster.getCurrentLevel();
        int totalLevel = vacancyMaster.getTotalLevel();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date cDate = new Date();

        if (btnType.equals("Approve")) {

            if (userLevel == totalLevel) {
                vacancyMaster.setStatus(5);
                approvalHistory.setStatus(5);
            } else {
                vacancyMaster.setStatus(4);
                approvalHistory.setStatus(5);
                vacancyMaster.setCurrentLevel(CurrentLevel + 1);

            }

            vacancyApproval.setComment(comment);
            vacancyMasterService.update(vacancyMaster);
            vacancyApprovalService.update(vacancyApproval);
            approvalHistory.setVacancyMaster(vacancyMaster);
            approvalHistory.setCreatedDate(sdf.format(cDate));
            approvalHistory.setCreatedBy(employeeMaster.getEmployeeName());
            approvalHistory.setComment(comment);
            approvalHistory.setStatusMessage(btnType);
            vacancyApprovalHistoryService.create(approvalHistory);
            request.setAttribute("successMessage",
                    "Information : The Request is Approved successfully.");

        }
        if (btnType.equals("Recycle")) {

            if (userLevel > 1) {
                vacancyMaster.setStatus(2);
                vacancyMaster.setCurrentLevel(CurrentLevel - 1);
                approvalHistory.setStatus(2);
            } else {
                vacancyMaster.setStatus(1);
                approvalHistory.setStatus(2);
                vacancyMaster.setCurrentLevel(CurrentLevel - 1);

            }

            vacancyApproval.setComment(comment);
            vacancyMasterService.update(vacancyMaster);
            vacancyApprovalService.update(vacancyApproval);
            approvalHistory.setVacancyMaster(vacancyMaster);
            approvalHistory.setCreatedDate(sdf.format(cDate));
            approvalHistory.setCreatedBy(employeeMaster.getEmployeeName());
            approvalHistory.setComment(comment);
            approvalHistory.setStatusMessage(btnType);
            vacancyApprovalHistoryService.create(approvalHistory);

            request.setAttribute("successMessage",
                    "Information : The Request is Returned successfully.");

        }

        if (btnType.equals("Reject")) {

            vacancyMaster.setStatus(3);
            vacancyApproval.setComment(comment);
            vacancyMasterService.update(vacancyMaster);
            vacancyApprovalService.update(vacancyApproval);

            approvalHistory.setVacancyMaster(vacancyMaster);
            approvalHistory.setCreatedDate(sdf.format(cDate));
            approvalHistory.setCreatedBy(employeeMaster.getEmployeeName());
            approvalHistory.setComment(comment);
            approvalHistory.setStatus(3);
            approvalHistory.setStatusMessage(btnType);
            vacancyApprovalHistoryService.create(approvalHistory);
            request.setAttribute("successMessage",
                    "Information : The Request is Rejectd successfully.");

        }
        mv.getModelMap().put("vacancyMaster", vacancyMaster);
        mv = vacancyShowByApprove(request, response);
        return mv;
    }
}
