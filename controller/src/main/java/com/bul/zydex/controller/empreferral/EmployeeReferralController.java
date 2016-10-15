/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.empreferral;

import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.model.EmailTemplate;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.EmployeeReferral;
import com.bul.zydex.model.UserMaster;
import com.bul.zydex.model.UserRightMaster;
import com.bul.zydex.util.DownloadFile;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.validation.BindException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Irfan
 */
public class EmployeeReferralController extends EmployeeReferralAbstract {

    public ModelAndView showList(HttpServletRequest request, HttpServletResponse response, EmployeeReferral employeeReferral) throws Exception {

        ModelAndView mv = new ModelAndView();
        List<?> employeeRefList = employeeReferralService.readEmpForReferral(employeeReferral);
        mv.addObject("employeeRefList", employeeRefList);
        List reportingManagerOfEmpRefAdminList = employeeReferralService.getReportingManagerOfEmpRefAdmin();
        if (!reportingManagerOfEmpRefAdminList.isEmpty()) {
            request.setAttribute("finalApprover", reportingManagerOfEmpRefAdminList.get(0));

        }
        mv.setViewName("EmployeeReferral/EmployeeReferralListForHR");
        return mv;
    }

    public ModelAndView showListForEmployee(HttpServletRequest request, HttpServletResponse response, EmployeeReferral employeeReferral) throws Exception {

        ModelAndView mv = new ModelAndView();
        List<?> employeeRefList = employeeReferralService.readEmpForReferral(employeeReferral);
        mv.addObject("employeeRefList", employeeRefList);
        List reportingManagerOfEmpRefAdminList = employeeReferralService.getReportingManagerOfEmpRefAdmin();
        if (!reportingManagerOfEmpRefAdminList.isEmpty()) {
            request.setAttribute("finalApprover", reportingManagerOfEmpRefAdminList.get(0));

        }
        mv.setViewName("EmployeeReferral/EmployeeReferralListForHR");
        return mv;
    }

    public ModelAndView createReferral(HttpServletRequest request, HttpServletResponse response, EmployeeReferral employeeReferral) throws Exception {

        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        employeeMaster.setUserMaster(user);
        List employeeDetail = employeeMasterService.readEmployeeDetail(employeeMaster);
        List<?> reportingManagerOfEmpRefAdminList = employeeReferralService.getReportingManagerOfEmpRefAdmin();
        if (!reportingManagerOfEmpRefAdminList.isEmpty()) {
            request.setAttribute("finalApprover", reportingManagerOfEmpRefAdminList.get(0));

        }
//        mv.addObject("employeeDetail", employeeDetail);
//        List lll=(List)employeeDetail.get(0);
//        int idd=(int) lll.get(7);
        if (!employeeDetail.isEmpty()) {
            request.setAttribute("employeeDetail", employeeDetail.get(0));
        }
        employeeReferral.setEmployeeMaster(employeeMaster);
        mv.getModelMap().put("employeeReferral", employeeReferral);
        mv.getModelMap().put("positionReferMap", getPositionReferalMap());
        mv.setViewName("EmployeeReferral/EmployeeReferralCreate");
        return mv;
    }

    public ModelAndView submitReferralByEmpolyee(HttpServletRequest request, HttpServletResponse response, EmployeeReferral employeeReferral) throws Exception {

        ModelAndView mv = new ModelAndView();
        String isFileRemoved = "removed";
        BindException errors = new BindException(employeeReferral, "employeeReferral");
        bind(request, employeeReferral);
        employeeReferralValidator.validate(employeeReferral, errors);
        if (errors.hasFieldErrors()) {
            request.setAttribute("failureMessage", "Error : Information Is Not Valid.");
            mv.addAllObjects(errors.getModel());
            mv.setViewName("EmployeeReferral/EmployeeReferralCreate");
        } else {
            if (employeeReferral != null) {
                employeeReferralService.createOrUpdate(employeeReferral);
                mv.addObject("successMessage", "Information : Information Saved Successfully.");
                //now upload candidates CV.
                uploadCandidateCVFile(request, response, employeeReferral);
                ///////////////////////////this is for download and remove file

                employeeReferral = employeeReferralService.readById(employeeReferral.getId());
                String actualPath = "StorageYard" + File.separator + "Other"
                        + File.separator + "UserDoc" + File.separator + "EmployeeReferral"
                        + File.separator + "CandidateCV" + File.separator + employeeReferral.getCandidateName().replaceAll(" ", "") + File.separator;
                //show uploaded file to approver(hr or reporting Manager or employeeReferalRight User)
                String fileLocationURL = getServletContext().getRealPath("/")
                        + File.separator + actualPath;
                //String basePath = getServletContext().getRealPath("/") + "StorageYard" + File.separator + "DigitalSignature" + File.separator + userName + File.separator;
                File candidateCV = new File(fileLocationURL);//file directory
//                File profilePicture = profilePictureFile.listFiles()[0];//First File Of Directory.
                if (candidateCV.exists() && candidateCV.listFiles().length > 0) {
                    File[] candidateCVArray = candidateCV.listFiles();
                    try {
                        request.setAttribute("candidateCVFile", actualPath + candidateCVArray[0].getName().replaceAll(" ", ""));
                        request.setAttribute("candidateCVFileName", candidateCVArray[0].getName().replaceAll(" ", ""));
                        isFileRemoved = "notRemoved";

                    } catch (Exception e) {
                    }
                }
                try {
                    EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                    DesignationMaster designationMaster = new DesignationMaster();
                    designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                    UserRightMaster rightMaster = new UserRightMaster();
                    EmailTemplate emailTemplate = new EmailTemplate();

                    // id = 82 for Employeee Referral Apply.....
                    emailTemplate = emailTemplateService.readById(82);
                    List list = userRightMasterService.readEmployeeReferralRights();
                    Iterator it = list.iterator();

                    while (it.hasNext()) {
                        Object[] next = (Object[]) it.next();
                        String umId = "" + next[0];
                        String EmailId = "" + next[1];
                        String name = "" + next[2];
                        String To = EmailId;
                        String from = employeeMasterModel.getOfficeEmailId();
                        String Employeename = name;
                        String Subject = emailTemplate.getSubject();
                        Subject = Subject.replaceAll("\\{user\\}", employeeMasterModel.getEmployeeName());
                        String msg = emailTemplate.getBodytext();
                        msg = msg.replaceAll("\\{to_user\\}", Employeename);
                        msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                        msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                        sendMail.sendMail(from, To, Subject, msg);
                    }

                } catch (Exception e) {
                }

            } else {
                mv.addObject("failureMessage", "Data Not Saved. ");

            }
            mv.addObject("Message", "Information : Information Saved Successfully.");
        }
        EmployeeMaster employeeMaster = new EmployeeMaster();
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        employeeMaster.setUserMaster(user);
        List employeeDetail = employeeMasterService.readEmployeeDetail(employeeMaster);
//        mv.addObject("employeeDetail", employeeDetail);
//            employeeReferral.setEmployeeMaster(new EmployeeMaster().setId(employeeDetail.get(0).get(6)));
        if (!employeeDetail.isEmpty()) {
            request.setAttribute("employeeDetail", employeeDetail.get(0));
        }
        List reportingManagerOfEmpRefAdminList = employeeReferralService.getReportingManagerOfEmpRefAdmin();
        if (!reportingManagerOfEmpRefAdminList.isEmpty()) {
            request.setAttribute("finalApprover", reportingManagerOfEmpRefAdminList.get(0));

        }

        employeeReferral.setEmployeeMaster(employeeMaster);
        mv.getModelMap().put("employeeReferral", employeeReferral);
        mv.getModelMap().put("positionReferMap", getPositionReferalMap());
        request.setAttribute("isFileRemoved", isFileRemoved);
        mv.setViewName("EmployeeReferral/EmployeeReferralCreate");
        return mv;
    }

    public ModelAndView approveReferral(HttpServletRequest request, HttpServletResponse response, EmployeeReferral employeeReferral) throws Exception {

        ModelAndView mv = new ModelAndView();
        BindException errors = new BindException(employeeReferral, "employeeReferral");
        bind(request, employeeReferral);
        employeeReferralValidator.validate(employeeReferral, errors);
        String isFileRemoved = "removed";
        if (errors.hasFieldErrors()) {
            request.setAttribute("failureMessage", "Error : Information Is Not Valid.");
            mv.addAllObjects(errors.getModel());
        } else {
            if (employeeReferral != null) {
                employeeReferral.setStatus(1);//chnge status from o to 1 as pending to approved.
                employeeReferral.setStatusRemark("Accepted By HR");//and this is for approved remark. 
                employeeReferralService.createOrUpdate(employeeReferral);
                mv.addObject("successMessage", "Information : Information Saved Successfully.");
                ///////////////////////////this is for download and remove file

                employeeReferral = employeeReferralService.readById(employeeReferral.getId());
                String actualPath = "StorageYard" + File.separator + "Other"
                        + File.separator + "UserDoc" + File.separator + "EmployeeReferral"
                        + File.separator + "CandidateCV" + File.separator + employeeReferral.getCandidateName().replaceAll(" ", "") + File.separator;
                //show uploaded file to approver(hr or reporting Manager or employeeReferalRight User)
                String fileLocationURL = getServletContext().getRealPath("/")
                        + File.separator + actualPath;
                //String basePath = getServletContext().getRealPath("/") + "StorageYard" + File.separator + "DigitalSignature" + File.separator + userName + File.separator;
                File candidateCV = new File(fileLocationURL);//file directory
//                File profilePicture = profilePictureFile.listFiles()[0];//First File Of Directory.
                if (candidateCV.exists() && candidateCV.listFiles().length > 0) {
                    File[] candidateCVArray = candidateCV.listFiles();
                    try {
                        request.setAttribute("candidateCVFile", actualPath + candidateCVArray[0].getName().replaceAll(" ", ""));
                        request.setAttribute("candidateCVFileName", candidateCVArray[0].getName().replaceAll(" ", ""));
                        isFileRemoved = "notRemoved";

                    } catch (Exception e) {
                    }
                }

                try {
                    ///////////////////////////this is for download and remove file End

                    EmployeeMaster employeemastermodel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                    DesignationMaster designationMaster = new DesignationMaster();
                    designationMaster = designationMasterService.readById(employeemastermodel.getDesignationMaster().getId());
                    EmployeeMaster employeemasterHr = new EmployeeMaster();
                    employeemasterHr = employeeMasterService.readById(Integer.parseInt(employeemastermodel.getReportingManagerLevel1()));
                    EmailTemplate emailTemplate1 = new EmailTemplate();
                    //id=83 for Employee referral approve.....
                    emailTemplate1 = emailTemplateService.readById(83);
                    EmployeeMaster employeeMaster2 = new EmployeeMaster();

//                    String empIdStr = request.getParameter("empid");
//                    if (null != empIdStr && !"".equals(empIdStr)) {
                    EmployeeMaster employeeMaster11 = new EmployeeMaster();

                    employeeMaster11 = employeeMasterService.readById(employeeReferral.getEmployeeMaster().getId());

//                        int empID = Integer.parseInt(empIdStr);
//                        List list = employeeMasterService.readByEmployeeNo(empID);
//                        if (!list.isEmpty()) {
//                            employeeMaster2 = (EmployeeMaster) list.get(0);
                    String To = employeeMaster11.getOfficeEmailId();
                    String from = employeemastermodel.getOfficeEmailId();
                    String subject = emailTemplate1.getSubject();
                    subject = subject.replaceAll("\\{user\\}", employeeMaster11.getEmployeeName());
                    String msg = emailTemplate1.getBodytext();
                    msg = msg.replaceAll("\\{to_user\\}", employeeMaster11.getEmployeeName());
                    msg = msg.replaceAll("\\{from_user\\}", employeemastermodel.getEmployeeName());
                    msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                    sendMail.sendMail(from, To, subject, msg);
//                        }
//                    }

                } catch (Exception e) {
                }
                //Employee referal approve template.....

//                    List list = userRightMasterService.readEmployeeReferralRights();
//                    Iterator it = list.iterator();
//                    
//                    while (it.hasNext()) {
//                        Object[] next = (Object[])it.next();
//                        String umId = ""+next[0];
//                        String EmailId = ""+next[1];
//                        String name = ""+next[2];
//                        String To = EmailId;
//                        String from = employeeMasterModel.getOfficeEmailId();
//                        String Employeename = name;
//                        String Subject = emailTemplate.getSubject();
//                        String msg = emailTemplate.getBodytext();
//                        msg = msg.replaceAll("\\{to_user\\}",Employeename);
//                        msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
//                        msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
//                        sendMail.sendMail(from, To, Subject, msg);
//                    }
            } else {
                mv.addObject("failureMessage", "Data Not Saved.");
            }
        }
        Map<Integer, String> locationMap = readLocations();
        Map<Integer, String> departmentMap = readDepartments();
        Map<Integer, String> designationMap = readDesignations();
        mv.addObject("locationMap", locationMap);//not required to set location master on empReferral because location master not used as foraign key. 
        mv.addObject("departmentMap", departmentMap);//not required to set department master on empReferral because department master not used as foraign key. 
        mv.addObject("designationMap", designationMap);//not required to set designation master on empReferral because designation master not used as foraign key. 
        employeeReferral.setEmployeeMaster(new EmployeeMaster());
        List<?> employeeRefList = employeeReferralService.readEmpForReferral(employeeReferral);
        if (!employeeRefList.isEmpty()) {
            mv.addObject("employeeRefList", employeeRefList.get(0));// list is used because from session we can get logged in user as Hr Not Employee.
        }
        mv.getModelMap().put("employeeReferral", employeeReferral);
        mv.getModelMap().put("positionReferMap", getPositionReferalMap());
        request.setAttribute("isFileRemoved", isFileRemoved);
        List reportingManagerOfEmpRefAdminList = employeeReferralService.getReportingManagerOfEmpRefAdmin();
        if (!reportingManagerOfEmpRefAdminList.isEmpty()) {
            request.setAttribute("finalApprover", reportingManagerOfEmpRefAdminList.get(0));

        }

//        String id = request.getParameter("id");
        mv.setViewName("EmployeeReferral/EmployeeReferralCreate");
        return mv;
    }

    public ModelAndView submitByEmpRef(HttpServletRequest request, HttpServletResponse response, EmployeeReferral employeeReferral) throws Exception {

        ModelAndView mv = new ModelAndView();
        BindException errors = new BindException(employeeReferral, "employeeReferral");
        bind(request, employeeReferral);
        employeeReferralValidator.validate(employeeReferral, errors);
        String isFileRemoved = "removed";
        if (errors.hasFieldErrors()) {
            request.setAttribute("failureMessage", "Error : Information Is Not Valid.");
            mv.addAllObjects(errors.getModel());
        } else {
            if (employeeReferral != null) {
                employeeReferral.setStatus(2);//Submit For Final  Approver To Hr .
                employeeReferral.setStatusRemark("Submit For Final Approve");//and this is for approved remark. 
                employeeReferralService.createOrUpdate(employeeReferral);
                mv.addObject("successMessage", "Information : Information Saved Successfully.");
                ///////////////////////////this is for download and remove file

                employeeReferral = employeeReferralService.readById(employeeReferral.getId());
                String actualPath = "StorageYard" + File.separator + "Other"
                        + File.separator + "UserDoc" + File.separator + "EmployeeReferral"
                        + File.separator + "CandidateCV" + File.separator + employeeReferral.getCandidateName().replaceAll(" ", "") + File.separator;
                //show uploaded file to approver(hr or reporting Manager or employeeReferalRight User)
                String fileLocationURL = getServletContext().getRealPath("/")
                        + File.separator + actualPath;
                //String basePath = getServletContext().getRealPath("/") + "StorageYard" + File.separator + "DigitalSignature" + File.separator + userName + File.separator;
                File candidateCV = new File(fileLocationURL);//file directory
//                File profilePicture = profilePictureFile.listFiles()[0];//First File Of Directory.
                if (candidateCV.exists() && candidateCV.listFiles().length > 0) {
                    File[] candidateCVArray = candidateCV.listFiles();
                    try {
                        request.setAttribute("candidateCVFile", actualPath + candidateCVArray[0].getName().replaceAll(" ", ""));
                        request.setAttribute("candidateCVFileName", candidateCVArray[0].getName().replaceAll(" ", ""));
                        isFileRemoved = "notRemoved";

                    } catch (Exception e) {
                    }
                }

                try {
                    ///////////////////////////this is for download and remove file End

                    EmployeeMaster employeemastermodel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                    DesignationMaster designationMaster = new DesignationMaster();
                    designationMaster = designationMasterService.readById(employeemastermodel.getDesignationMaster().getId());
                    EmployeeMaster employeemasterHr = new EmployeeMaster();
                    employeemasterHr = employeeMasterService.readById(Integer.parseInt(employeemastermodel.getReportingManagerLevel1()));
                    EmailTemplate emailTemplate1 = new EmailTemplate();
                    //id=83 for Employee referral approve.....
                    emailTemplate1 = emailTemplateService.readById(83);
                    EmployeeMaster employeeMaster2 = new EmployeeMaster();

//                    String empIdStr = request.getParameter("empid");
//                    if (null != empIdStr && !"".equals(empIdStr)) {
                    EmployeeMaster employeeMaster11 = new EmployeeMaster();

                    employeeMaster11 = employeeMasterService.readById(employeeReferral.getEmployeeMaster().getId());

//                        int empID = Integer.parseInt(empIdStr);
//                        List list = employeeMasterService.readByEmployeeNo(empID);
//                        if (!list.isEmpty()) {
//                            employeeMaster2 = (EmployeeMaster) list.get(0);
                    String To = employeeMaster11.getOfficeEmailId();
                    String from = employeemastermodel.getOfficeEmailId();
                    String subject = emailTemplate1.getSubject();
                    subject = subject.replaceAll("\\{user\\}", employeeMaster11.getEmployeeName());
                    String msg = emailTemplate1.getBodytext();
                    msg = msg.replaceAll("\\{to_user\\}", employeeMaster11.getEmployeeName());
                    msg = msg.replaceAll("\\{from_user\\}", employeemastermodel.getEmployeeName());
                    msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                    sendMail.sendMail(from, To, subject, msg);
//                        }
//                    }
                    List finalHrApprovallId = employeeReferralService.finalApproveByHrHead();
                    EmployeeMaster em = new EmployeeMaster();
                    if (!finalHrApprovallId.isEmpty()) {
                        em = (EmployeeMaster) finalHrApprovallId.get(0);
                    }
                    String To1 = em.getOfficeEmailId();
                    String subject1 = emailTemplate1.getSubject();
                    subject1 = subject1.replaceAll("\\{user\\}", em.getEmployeeName());
                    String msg1 = emailTemplate1.getBodytext();
                    msg1 = msg1.replaceAll("\\{to_user\\}", em.getEmployeeName());
                    msg1 = msg1.replaceAll("\\{from_user\\}", employeemastermodel.getEmployeeName());
                    msg1 = msg1.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                    sendMail.sendMail(from, To1, subject1, msg1);

                } catch (Exception e) {
                }
                //Employee referal approve template.....

//                    List list = userRightMasterService.readEmployeeReferralRights();
//                    Iterator it = list.iterator();
//                    
//                    while (it.hasNext()) {
//                        Object[] next = (Object[])it.next();
//                        String umId = ""+next[0];
//                        String EmailId = ""+next[1];
//                        String name = ""+next[2];
//                        String To = EmailId;
//                        String from = employeeMasterModel.getOfficeEmailId();
//                        String Employeename = name;
//                        String Subject = emailTemplate.getSubject();
//                        String msg = emailTemplate.getBodytext();
//                        msg = msg.replaceAll("\\{to_user\\}",Employeename);
//                        msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
//                        msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
//                        sendMail.sendMail(from, To, Subject, msg);
//                    }
            } else {
                mv.addObject("failureMessage", "Data Not Saved. ");
            }
        }
        Map<Integer, String> locationMap = readLocations();
        Map<Integer, String> departmentMap = readDepartments();
        Map<Integer, String> designationMap = readDesignations();
        mv.addObject("locationMap", locationMap);//not required to set location master on empReferral because location master not used as foraign key. 
        mv.addObject("departmentMap", departmentMap);//not required to set department master on empReferral because department master not used as foraign key. 
        mv.addObject("designationMap", designationMap);//not required to set designation master on empReferral because designation master not used as foraign key. 
        employeeReferral.setEmployeeMaster(new EmployeeMaster());
        List<?> employeeRefList = employeeReferralService.readEmpForReferral(employeeReferral);
        if (!employeeRefList.isEmpty()) {
            mv.addObject("employeeRefList", employeeRefList.get(0));// list is used because from session we can get logged in user as Hr Not Employee.
        }
        mv.getModelMap().put("employeeReferral", employeeReferral);
        mv.getModelMap().put("positionReferMap", getPositionReferalMap());
        request.setAttribute("isFileRemoved", isFileRemoved);
        List reportingManagerOfEmpRefAdminList = employeeReferralService.getReportingManagerOfEmpRefAdmin();
        if (!reportingManagerOfEmpRefAdminList.isEmpty()) {
            request.setAttribute("finalApprover", reportingManagerOfEmpRefAdminList.get(0));

        }
//        String id = request.getParameter("id");
        mv.setViewName("EmployeeReferral/EmployeeReferralCreate");
        return mv;
    }

    public ModelAndView finalApproveByHr(HttpServletRequest request, HttpServletResponse response, EmployeeReferral employeeReferral) throws Exception {

        ModelAndView mv = new ModelAndView();
        BindException errors = new BindException(employeeReferral, "employeeReferral");
        bind(request, employeeReferral);
        employeeReferralValidator.validate(employeeReferral, errors);
        String isFileRemoved = "removed";
        if (errors.hasFieldErrors()) {
            request.setAttribute("failureMessage", "Error : Information Is Not Valid.");
            mv.addAllObjects(errors.getModel());
        } else {
            if (employeeReferral != null) {
                employeeReferral.setStatus(3);//Final Approve By Hr.
                employeeReferral.setStatusRemark("Final Approve By HR");//and this is for approved remark. 
                employeeReferralService.createOrUpdate(employeeReferral);
                mv.addObject("successMessage", "Information : Information Saved Successfully.");
                ///////////////////////////this is for download and remove file

                employeeReferral = employeeReferralService.readById(employeeReferral.getId());
                String actualPath = "StorageYard" + File.separator + "Other"
                        + File.separator + "UserDoc" + File.separator + "EmployeeReferral"
                        + File.separator + "CandidateCV" + File.separator + employeeReferral.getCandidateName().replaceAll(" ", "") + File.separator;
                //show uploaded file to approver(hr or reporting Manager or employeeReferalRight User)
                String fileLocationURL = getServletContext().getRealPath("/")
                        + File.separator + actualPath;
                //String basePath = getServletContext().getRealPath("/") + "StorageYard" + File.separator + "DigitalSignature" + File.separator + userName + File.separator;
                File candidateCV = new File(fileLocationURL);//file directory
//                File profilePicture = profilePictureFile.listFiles()[0];//First File Of Directory.
                if (candidateCV.exists() && candidateCV.listFiles().length > 0) {
                    File[] candidateCVArray = candidateCV.listFiles();
                    try {
                        request.setAttribute("candidateCVFile", actualPath + candidateCVArray[0].getName().replaceAll(" ", ""));
                        request.setAttribute("candidateCVFileName", candidateCVArray[0].getName().replaceAll(" ", ""));
                        isFileRemoved = "notRemoved";

                    } catch (Exception e) {
                    }
                }

                try {
                    ///////////////////////////this is for download and remove file End

                    EmployeeMaster employeemastermodel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                    DesignationMaster designationMaster = new DesignationMaster();
                    designationMaster = designationMasterService.readById(employeemastermodel.getDesignationMaster().getId());
                    EmployeeMaster employeemasterHr = new EmployeeMaster();
                    employeemasterHr = employeeMasterService.readById(Integer.parseInt(employeemastermodel.getReportingManagerLevel1()));
                    EmailTemplate emailTemplate1 = new EmailTemplate();
                    //id=83 for Employee referral approve.....
                    emailTemplate1 = emailTemplateService.readById(83);
                    EmployeeMaster employeeMaster2 = new EmployeeMaster();

//                    String empIdStr = request.getParameter("empid");
//                    if (null != empIdStr && !"".equals(empIdStr)) {
                    EmployeeMaster employeeMaster11 = new EmployeeMaster();

                    employeeMaster11 = employeeMasterService.readById(employeeReferral.getEmployeeMaster().getId());

//                        int empID = Integer.parseInt(empIdStr);
//                        List list = employeeMasterService.readByEmployeeNo(empID);
//                        if (!list.isEmpty()) {
//                            employeeMaster2 = (EmployeeMaster) list.get(0);
                    String To = employeeMaster11.getOfficeEmailId();
                    String from = employeemastermodel.getOfficeEmailId();
                    String subject = emailTemplate1.getSubject();
                    subject = subject.replaceAll("\\{user\\}", employeeMaster11.getEmployeeName());
                    String msg = emailTemplate1.getBodytext();
                    msg = msg.replaceAll("\\{to_user\\}", employeeMaster11.getEmployeeName());
                    msg = msg.replaceAll("\\{from_user\\}", employeemastermodel.getEmployeeName());
                    msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                    sendMail.sendMail(from, To, subject, msg);
//                        }
//                    }

                } catch (Exception e) {
                }
                //Employee referal approve template.....

//                    List list = userRightMasterService.readEmployeeReferralRights();
//                    Iterator it = list.iterator();
//                    
//                    while (it.hasNext()) {
//                        Object[] next = (Object[])it.next();
//                        String umId = ""+next[0];
//                        String EmailId = ""+next[1];
//                        String name = ""+next[2];
//                        String To = EmailId;
//                        String from = employeeMasterModel.getOfficeEmailId();
//                        String Employeename = name;
//                        String Subject = emailTemplate.getSubject();
//                        String msg = emailTemplate.getBodytext();
//                        msg = msg.replaceAll("\\{to_user\\}",Employeename);
//                        msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
//                        msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
//                        sendMail.sendMail(from, To, Subject, msg);
//                    }
            } else {
                mv.addObject("failureMessage", "Data Not Saved. ");
            }
        }
        Map<Integer, String> locationMap = readLocations();
        Map<Integer, String> departmentMap = readDepartments();
        Map<Integer, String> designationMap = readDesignations();
        mv.addObject("locationMap", locationMap);//not required to set location master on empReferral because location master not used as foraign key. 
        mv.addObject("departmentMap", departmentMap);//not required to set department master on empReferral because department master not used as foraign key. 
        mv.addObject("designationMap", designationMap);//not required to set designation master on empReferral because designation master not used as foraign key. 
        employeeReferral.setEmployeeMaster(new EmployeeMaster());
        List<?> employeeRefList = employeeReferralService.readEmpForReferral(employeeReferral);
        if (!employeeRefList.isEmpty()) {
            mv.addObject("employeeRefList", employeeRefList.get(0));// list is used because from session we can get logged in user as Hr Not Employee.
        }
        mv.getModelMap().put("employeeReferral", employeeReferral);
        mv.getModelMap().put("positionReferMap", getPositionReferalMap());
        request.setAttribute("isFileRemoved", isFileRemoved);
        List reportingManagerOfEmpRefAdminList = employeeReferralService.getReportingManagerOfEmpRefAdmin();
        if (!reportingManagerOfEmpRefAdminList.isEmpty()) {
            request.setAttribute("finalApprover", reportingManagerOfEmpRefAdminList.get(0));

        }
//        String id = request.getParameter("id");
        mv.setViewName("EmployeeReferral/EmployeeReferralCreate");
        return mv;
    }

    public ModelAndView createViewReferral(HttpServletRequest request, HttpServletResponse response, EmployeeReferral employeeReferral) throws Exception {

        ModelAndView mv = new ModelAndView();
        String isFileRemoved = "removed";
        if (employeeReferral.getId() != null) {
            employeeReferral = employeeReferralService.readById(employeeReferral.getId());
            String actualPath = "StorageYard" + File.separator + "Other"
                    + File.separator + "UserDoc" + File.separator + "EmployeeReferral"
                    + File.separator + "CandidateCV" + File.separator + employeeReferral.getCandidateName().replaceAll(" ", "") + File.separator;
            //show uploaded file to approver(hr or reporting Manager or employeeReferalRight User)
            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + actualPath;
            //String basePath = getServletContext().getRealPath("/") + "StorageYard" + File.separator + "DigitalSignature" + File.separator + userName + File.separator;
            File candidateCV = new File(fileLocationURL);//file directory
//                File profilePicture = profilePictureFile.listFiles()[0];//First File Of Directory.
            if (candidateCV.exists() && candidateCV.listFiles().length > 0) {
                File[] candidateCVArray = candidateCV.listFiles();
                try {
                    request.setAttribute("candidateCVFile", actualPath + candidateCVArray[0].getName().replaceAll(" ", ""));
                    request.setAttribute("candidateCVFileName", candidateCVArray[0].getName().replaceAll(" ", ""));
                    isFileRemoved = "notRemoved";

                } catch (Exception e) {
                }

            }
        }
        request.setAttribute("isFileRemoved", isFileRemoved);
        Map<Integer, String> locationMap = readLocations();
        Map<Integer, String> departmentMap = readDepartments();
        Map<Integer, String> designationMap = readDesignations();
        mv.addObject("locationMap", locationMap);//not required to set location master on empReferral because location master not used as foraign key. 
        mv.addObject("departmentMap", departmentMap);//not required to set department master on empReferral because department master not used as foraign key. 
        mv.addObject("designationMap", designationMap);//not required to set designation master on empReferral because designation master not used as foraign key. 
        employeeReferral.setEmployeeMaster(new EmployeeMaster());
        List<?> employeeRefList = employeeReferralService.readEmpForReferral(employeeReferral);
        if (!employeeRefList.isEmpty()) {
            mv.addObject("employeeRefList", employeeRefList.get(0));// list is used because from session we can ge logged in user as Hr Not Employee.
        }
        mv.getModelMap().put("employeeReferral", employeeReferral);
        mv.getModelMap().put("positionReferMap", getPosition());
//        String id = request.getParameter("id");
        List reportingManagerOfEmpRefAdminList = employeeReferralService.getReportingManagerOfEmpRefAdmin();
        if (!reportingManagerOfEmpRefAdminList.isEmpty()) {
            request.setAttribute("finalApprover", reportingManagerOfEmpRefAdminList.get(0));

        }
        List finalHrApprovallId = employeeReferralService.finalApproveByHrHead();
        if (!finalHrApprovallId.isEmpty()) {
            if (!finalHrApprovallId.isEmpty()) {
                EmployeeMaster em = new EmployeeMaster();
                em = (EmployeeMaster) finalHrApprovallId.get(0);
                request.setAttribute("finalApproverByHeHead", em.getId());

            }

        }
        mv.setViewName("EmployeeReferral/EmployeeReferralCreate");
        return mv;
    }

    public ModelAndView cancelReferrl(HttpServletRequest request, HttpServletResponse response, EmployeeReferral employeeReferral) throws Exception {

        ModelAndView mv = new ModelAndView();
//        empRefAdminRemark="";
        String empRefAdminRemark = request.getParameter("hrRemark");
        employeeReferral.setId(employeeReferral.getId());
        employeeReferral.setStatus(5);//chnge status from o to 1 as pending to approved.
        employeeReferral.setHrRemark((empRefAdminRemark != null) ? empRefAdminRemark : "");//Set Remark given by empRefAdmin For Rejectin Of Referral.
        employeeReferral.setStatusRemark("Rejected By HR");//and this is for approved remark. 
        int count = employeeReferralService.updateEmployeeReferralById(employeeReferral);
        if (count > 0) {
            mv.addObject("successMessage", "Information : Information Saved Successfully.");
            try {

                EmployeeMaster employeemastermodel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                DesignationMaster designationMaster = new DesignationMaster();
                designationMaster = designationMasterService.readById(employeemastermodel.getDesignationMaster().getId());
//                    EmployeeMaster employeemasterHr = new EmployeeMaster();
//                    employeemasterHr = employeeMasterService.readById(Integer.parseInt(employeemastermodel.getReportingManagerLevel1()));
                EmailTemplate emailTemplate1 = new EmailTemplate();

                //id=85 for Employee referral reject....
                emailTemplate1 = emailTemplateService.readById(85);

//                    String empIdStr = request.getParameter("empid");
//                    if (null != empIdStr && !"".equals(empIdStr)) {
                EmployeeMaster employeeMaster11 = new EmployeeMaster();
                employeeReferral = employeeReferralService.readById(employeeReferral.getId());

                employeeMaster11 = employeeMasterService.readById(employeeReferral.getEmployeeMaster().getId());

//                        int empID = Integer.parseInt(empIdStr);
//                        List list = employeeMasterService.readByEmployeeNo(empID);
//                        if (!list.isEmpty()) {
//                            employeeMaster2 = (EmployeeMaster) list.get(0);
                String To = employeeMaster11.getEmailAddress();
                String from = employeemastermodel.getOfficeEmailId();
                String subject = emailTemplate1.getSubject();
                subject = subject.replaceAll("\\{user\\}", employeeMaster11.getEmployeeName());
                String msg = emailTemplate1.getBodytext();
                msg = msg.replaceAll("\\{to_user\\}", employeeMaster11.getEmployeeName());
                msg = msg.replaceAll("\\{from_user\\}", employeemastermodel.getEmployeeName());
                msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                sendMail.sendMail(from, To, subject, msg);
//                        }
//                    }

            } catch (Exception e) {
            }
        } else {
            mv.addObject("failureMessage", "Data Not Saved. ");
        }
        employeeReferral.setId(null);//here setting id = null so we can use same method of dao.
        List<?> employeeRefList = employeeReferralService.readEmpForReferral(employeeReferral);
        mv.addObject("employeeRefList", employeeRefList);
        List reportingManagerOfEmpRefAdminList = employeeReferralService.getReportingManagerOfEmpRefAdmin();
        if (!reportingManagerOfEmpRefAdminList.isEmpty()) {
            request.setAttribute("finalApprover", reportingManagerOfEmpRefAdminList.get(0));

        }
        mv.setViewName("EmployeeReferral/EmployeeReferralListForHR");
        return mv;
    }

    public ModelAndView returnReferrl(HttpServletRequest request, HttpServletResponse response, EmployeeReferral employeeReferral) throws Exception {

        ModelAndView mv = new ModelAndView();
        employeeReferral.setId(employeeReferral.getId());
        employeeReferral.setStatus(2);//chnge status to 2 as return referral.
        employeeReferral.setStatusRemark("Return By Hr");//and this is for status remark. 
        int count = employeeReferralService.updateEmployeeReferralById(employeeReferral);
        BindException errors = new BindException(employeeReferral, "employeeReferral");
        bind(request, employeeReferral);
//        employeeReferralValidator.validate(employeeReferral, errors);
//        if (count > 0) {
//            mv.addObject("successMessage", "Information : Information Saved Successfully.");
//        } else {
//            mv.addObject("failureMessage", "Data Not Saved. ");
//        }
        if (errors.hasFieldErrors()) {
            request.setAttribute("failureMessage", "Error : Information Is Not Valid.");
            mv.addAllObjects(errors.getModel());
            mv.setViewName("EmployeeReferral/EmployeeReferralCreate");
        } else {
            if (employeeReferral != null) {
                employeeReferralService.createOrUpdate(employeeReferral);
                mv.addObject("successMessage", "Information : Information Saved Successfully.");

                try {

                    EmployeeMaster employeemastermodel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                    DesignationMaster designationMaster = new DesignationMaster();
                    designationMaster = designationMasterService.readById(employeemastermodel.getDesignationMaster().getId());
                    EmployeeMaster employeemasterHr = new EmployeeMaster();
                    employeemasterHr = employeeMasterService.readById(Integer.parseInt(employeemastermodel.getReportingManagerLevel1()));
                    EmailTemplate emailTemplate1 = new EmailTemplate();

                    //id=84 for Employee referral return....
                    emailTemplate1 = emailTemplateService.readById(84);
                    EmployeeMaster employeeMaster2 = new EmployeeMaster();

//                    String empIdStr = request.getParameter("empid");
//                    if (null != empIdStr && !"".equals(empIdStr)) {
                    EmployeeMaster employeeMaster11 = new EmployeeMaster();

                    employeeMaster11 = employeeMasterService.readById(employeeReferral.getEmployeeMaster().getId());

//                        int empID = Integer.parseInt(empIdStr);
//                        List list = employeeMasterService.readByEmployeeNo(empID);
//                        if (!list.isEmpty()) {
//                            employeeMaster2 = (EmployeeMaster) list.get(0);
                    String To = employeeMaster11.getOfficeEmailId();
                    String from = employeemastermodel.getOfficeEmailId();
                    String subject = emailTemplate1.getSubject();
                    subject = subject.replaceAll("\\{user\\}", employeeMaster11.getEmployeeName());
                    String msg = emailTemplate1.getBodytext();
                    msg = msg.replaceAll("\\{to_user\\}", employeeMaster11.getEmployeeName());
                    msg = msg.replaceAll("\\{from_user\\}", employeemastermodel.getEmployeeName());
                    msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                    sendMail.sendMail(from, To, subject, msg);
//                        }
//                    }

                } catch (Exception e) {
                }

            } else {
                mv.addObject("failureMessage", "Data Not Saved. ");
            }
            mv.setViewName("EmployeeReferral/EmployeeReferralListForHR");
        }
        employeeReferral.setId(null);//here setting id = null so we can use same method of dao.
        List<?> employeeRefList = employeeReferralService.readEmpForReferral(employeeReferral);
        mv.addObject("employeeRefList", employeeRefList);
        return mv;
    }

    public ModelAndView approveWithdraw(HttpServletRequest request, HttpServletResponse response, EmployeeReferral employeeReferral) throws Exception {

        ModelAndView mv = new ModelAndView();
        employeeReferral.setId(employeeReferral.getId());
        employeeReferral.setStatus(4);//chnge status to 4 as withdraw approved.
        employeeReferral.setStatusRemark("Withdraw Approved");//and this is for approved remark. 
        int count = employeeReferralService.updateEmployeeReferralById(employeeReferral);
        if (count > 0) {
            mv.addObject("successMessage", "Information : Information Saved Successfully.");
            try {

                EmployeeMaster employeemastermodel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                DesignationMaster designationMaster = new DesignationMaster();
                designationMaster = designationMasterService.readById(employeemastermodel.getDesignationMaster().getId());
//                    EmployeeMaster employeemasterHr = new EmployeeMaster();
//                    employeemasterHr = employeeMasterService.readById(Integer.parseInt(employeemastermodel.getReportingManagerLevel1()));
                EmailTemplate emailTemplate1 = new EmailTemplate();

                //id=95 for Employee referral withdraw....
                emailTemplate1 = emailTemplateService.readById(95);

//                    String empIdStr = request.getParameter("empid");
//                    if (null != empIdStr && !"".equals(empIdStr)) {
                EmployeeMaster employeeMaster11 = new EmployeeMaster();
                employeeReferral = employeeReferralService.readById(employeeReferral.getId());

                employeeMaster11 = employeeMasterService.readById(employeeReferral.getEmployeeMaster().getId());

//                        int empID = Integer.parseInt(empIdStr);
//                        List list = employeeMasterService.readByEmployeeNo(empID);
//                        if (!list.isEmpty()) {
//                            employeeMaster2 = (EmployeeMaster) list.get(0);
                String To = employeeMaster11.getEmailAddress();
                String from = employeemastermodel.getOfficeEmailId();
                String subject = emailTemplate1.getSubject();
                subject = subject.replaceAll("\\{user\\}", employeeMaster11.getEmployeeName());
                String msg = emailTemplate1.getBodytext();
                msg = msg.replaceAll("\\{to_user\\}", employeeMaster11.getEmployeeName());
                msg = msg.replaceAll("\\{from_user\\}", employeemastermodel.getEmployeeName());
                msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                sendMail.sendMail(from, To, subject, msg);
//                        }
//                    }

            } catch (Exception e) {
            }

        } else {
            mv.addObject("failureMessage", "Data Not Saved. ");
        }
        employeeReferral.setId(null);//here setting id = null so we can use same method of dao.
        List<?> employeeRefList = employeeReferralService.readEmpForReferral(employeeReferral);
        mv.addObject("employeeRefList", employeeRefList);
        mv.setViewName("EmployeeReferral/EmployeeReferralListForHR");
        return mv;
    }

    public ModelAndView withdrawReferral(HttpServletRequest request, HttpServletResponse response, EmployeeReferral employeeReferral) throws Exception {

        ModelAndView mv = new ModelAndView();
        employeeReferral.setId(employeeReferral.getId());
        employeeReferral.setStatus(3);//chnge status to 3 as withdraw Referral.
        employeeReferral.setStatusRemark("Withdraw By Employee");//and this is for approved remark. 
        int count = employeeReferralService.updateEmployeeReferralById(employeeReferral);
        if (count > 0) {
            mv.addObject("successMessage", "Information : Information Saved Successfully.");
            try {
                EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                DesignationMaster designationMaster = new DesignationMaster();
                designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                UserRightMaster rightMaster = new UserRightMaster();
                EmailTemplate emailTemplate = new EmailTemplate();
                // id = 94 for Employeee Referral withdraw.....
                emailTemplate = emailTemplateService.readById(94);
                List list = userRightMasterService.readEmployeeReferralRights();
                Iterator it = list.iterator();

                while (it.hasNext()) {
                    Object[] next = (Object[]) it.next();
                    String umId = "" + next[0];
                    String EmailId = "" + next[1];
                    String name = "" + next[2];
                    String To = EmailId;
                    String from = employeeMasterModel.getOfficeEmailId();
                    String Employeename = name;
                    String Subject = emailTemplate.getSubject();
                    Subject = Subject.replaceAll("\\{user\\}", employeeMasterModel.getEmployeeName());
                    String msg = emailTemplate.getBodytext();
                    msg = msg.replaceAll("\\{to_user\\}", Employeename);
                    msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                    msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                    sendMail.sendMail(from, To, Subject, msg);
                }

            } catch (Exception e) {
            }

        } else {
            mv.addObject("failureMessage", "Data Not Saved. ");
        }
        employeeReferral.setId(null);//here setting id = null so we can use same method of dao.
        List<?> employeeRefList = employeeReferralService.readEmpForReferral(employeeReferral);
        mv.addObject("employeeRefList", employeeRefList);
        mv.setViewName("EmployeeReferral/EmployeeReferralListForHR");
        return mv;
    }

    public ModelAndView submitAgain(HttpServletRequest request, HttpServletResponse response, EmployeeReferral employeeReferral) throws Exception {

        ModelAndView mv = new ModelAndView();
//        employeeReferral.setStatus(2);//for validation only
        BindException errors = new BindException(employeeReferral, "employeeReferral");
        bind(request, employeeReferral);
        employeeReferralValidator.validate(employeeReferral, errors);
        if (errors.hasFieldErrors()) {
            request.setAttribute("failureMessage", "Error : Information Is Not Valid.");
            mv.addAllObjects(errors.getModel());
            mv.setViewName("EmployeeReferral/EmployeeReferralCreate");
        } else {
            if (employeeReferral != null) {
                employeeReferral.setStatus(0);//for approve again
//                employeeReferral.setStatusRemark("Pending For Approval");//for temporary base only
                employeeReferralService.createOrUpdate(employeeReferral);
                mv.addObject("successMessage", "Information : Information Saved Successfully.");
                try {

                    EmployeeMaster employeemastermodel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                    DesignationMaster designationMaster = new DesignationMaster();
                    designationMaster = designationMasterService.readById(employeemastermodel.getDesignationMaster().getId());
                    EmployeeMaster employeemasterHr = new EmployeeMaster();
                    employeemasterHr = employeeMasterService.readById(Integer.parseInt(employeemastermodel.getReportingManagerLevel1()));
                    EmailTemplate emailTemplate1 = new EmailTemplate();
                    //id=124 for Employee referral apply after edit.....
                    emailTemplate1 = emailTemplateService.readById(124);
                    EmployeeMaster employeeMaster2 = new EmployeeMaster();

//                    String empIdStr = request.getParameter("empid");
//                    if (null != empIdStr && !"".equals(empIdStr)) {
                    EmployeeMaster employeeMaster11 = new EmployeeMaster();

                    employeeMaster11 = employeeMasterService.readById(employeeReferral.getEmployeeMaster().getId());

//                        int empID = Integer.parseInt(empIdStr);
//                        List list = employeeMasterService.readByEmployeeNo(empID);
//                        if (!list.isEmpty()) {
//                            employeeMaster2 = (EmployeeMaster) list.get(0);
                    String To = employeeMaster11.getOfficeEmailId();
                    String from = employeemastermodel.getOfficeEmailId();
                    String subject = emailTemplate1.getSubject();
                    String msg = emailTemplate1.getBodytext();
                    msg = msg.replaceAll("\\{to_user\\}", employeeMaster11.getEmployeeName());
                    msg = msg.replaceAll("\\{from_user\\}", employeemastermodel.getEmployeeName());
                    msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                    sendMail.sendMail(from, To, subject, msg);
//                        }
//                    }

                } catch (Exception e) {
                }

            } else {
                mv.addObject("failureMessage", "Data Not Saved. ");
            }
            mv.setViewName("EmployeeReferral/EmployeeReferralListForHR");
        }
//        EmployeeMaster employeeMaster = new EmployeeMaster();
//        HttpSession session = request.getSession(false);
//        UserMaster user = (UserMaster) session.getAttribute("user");
//        employeeMaster.setUserMaster(user);
//        List employeeDetail = employeeMasterService.readEmployeeDetail(employeeMaster);
//        mv.addObject("employeeDetail", employeeDetail);
//            employeeReferral.setEmployeeMaster(new EmployeeMaster().setId(employeeDetail.get(0).get(6)));
//        request.setAttribute("employeeDetail", employeeDetail.get(0));
//        employeeReferral.setEmployeeMaster(employeeMaster);
//        mv.getModelMap().put("employeeReferral", employeeReferral);
//        mv.setViewName("EmployeeReferral/EmployeeReferralCreate");

//        employeeReferral.setId(employeeReferral.getId());
//        employeeReferral.setStatus(0);//chnge status from o to 1 as pending to approved.
//        employeeReferral.setStatusRemark("Submited Again");//and this is for approved remark. 
//        int count = employeeReferralService.updateEmployeeReferralById(employeeReferral);
//        if (count > 0) {
//            mv.addObject("successMessage", "Information : Information Saved Successfully.");
//        } else {
//            mv.addObject("failureMessage", "Data Not Saved. ");
//        }
        employeeReferral.setId(null);//here setting id = null so we can use same method of dao.
        List<?> employeeRefList = employeeReferralService.readEmpForReferral(employeeReferral);
        mv.addObject("employeeRefList", employeeRefList);
        return mv;
    }

    public ModelAndView currentOpeningUploadClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<String> finalList = new ArrayList<>();
        String fileLocationURL = getServletContext().getRealPath("/")
                + File.separator + "StorageYard"
                + File.separator + "CurrentOpening" + File.separator;
        File folder = new File(fileLocationURL);
        File[] listOfFiles = folder.listFiles();
        if (listOfFiles != null) {
            for (File listOfFile : listOfFiles) {
                File f = (File) listOfFile;
                String f1 = f.getName();
                if (f1 != null) {
                    if (f1.equals("temp")) {

                    } else {
                        finalList.add(f1);

                    }
                }
            }
        }
        mv.addObject("finalList", finalList);
        mv.setViewName("EmployeeReferral/uploadCurrentOpening");
        return mv;
    }

    public ModelAndView currentOpeningFileUpload(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        Boolean flag = false;
        String image = request.getParameter("photograph");
        String fileLocationURL = getServletContext().getRealPath("/")
                + File.separator + "StorageYard"
                + File.separator + "CurrentOpening" + File.separator;
//                    + File.separator + image  ;
        File PictureFile = new File(fileLocationURL);//file directory
        if (!PictureFile.exists()) {
            PictureFile.mkdir();//make directory for first time user creation.
        }
        //File Photo Upload///
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile = multipartRequest.getFile("photograph");
        if (multipartFile != null && multipartFile.getSize() > 0) {
            //null if there is no photograph in form.
            try {

                File file2 = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", ""));
                multipartFile.transferTo(file2);
                flag = true;
                request.setAttribute("successMessage",
                        "Information : Uploaded Successfully.");
            } catch (Exception e) {

            }
        }
        if (flag) {
            //     Email Sent to All Employees for Current Opening
            List<?> employeeMasterList = employeeMasterService.readEmployeesDetail();
            for (Object o : employeeMasterList) {
                Object[] o1 = (Object[]) o;
                int EmpId = (int) o1[0];
                try {
                    EmailTemplate emailTemplate = new EmailTemplate();
                    EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                    DesignationMaster designationMaster = new DesignationMaster();
                    designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                    EmployeeMaster employeeMaster = new EmployeeMaster();
                    employeeMaster = employeeMasterService.readById(EmpId);
                    // id 127 is for Current Openings
                    emailTemplate = emailTemplateService.readById(128);
                    String To = employeeMaster.getOfficeEmailId();
                    String from = employeeMasterModel.getOfficeEmailId();
                    String Subject = emailTemplate.getSubject();
                    String msg = emailTemplate.getBodytext();
                    msg = msg.replaceAll("\\{to_user\\}", employeeMaster.getEmployeeName());
                    msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                    msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                    sendMail.sendMail(from, To, Subject, msg);
                } catch (Exception e) {

                }
            }
        }
        mv = currentOpeningUploadClick(request, response);
        return mv;
    }

    public ModelAndView showCurrentOpening(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<String> finalList = new ArrayList<>();
        String fileLocationURL = getServletContext().getRealPath("/")
                + File.separator + "StorageYard"
                + File.separator + "CurrentOpening";
        File folder = new File(fileLocationURL);
        File[] listOfFiles = folder.listFiles();
        if (listOfFiles != null) {
            for (File listOfFile : listOfFiles) {
                File f = (File) listOfFile;
                String f1 = f.getName();
                String Path = "StorageYard" + File.separator + "CurrentOpening" + File.separator + f1;

                if (f1 != null) {
                    if (f1.equals("temp")) {

                    } else {
                        finalList.add(Path);
                    }
                }
            }
        }
        mv.addObject("finalList", finalList);
        mv.setViewName("EmployeeReferral/CurrentOpening");
        return mv;
    }

    public ModelAndView deleteCurrentOpeningimage(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String image = request.getParameter("imgname");
        String fileLocationURL = getServletContext().getRealPath("/")
                + File.separator + "StorageYard"
                + File.separator + "CurrentOpening"
                + File.separator + image;
        File f = new File(fileLocationURL);
        f.delete();
        request.setAttribute("successMessage",
                "Information : Image Removed Successfully.");
        mv = currentOpeningUploadClick(request, response);
        return mv;
    }

    public ModelAndView exportToExcel(HttpServletRequest request,
            HttpServletResponse response, EmployeeReferral employeeReferral) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<?> employeeRefList = employeeReferralService.readEmpForReferral(employeeReferral);
        mv.addObject("employeeRefList", employeeRefList);
        mv.setViewName("EmployeeReferral/EmployeeReferralListForHR");
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=EmployeeReferral.xls");
        response.setContentType("application/vnd.ms-excel");
        mv.setViewName("EmployeeReferral/EmpRefExporttoExcel");
        return mv;
    }

    public void getCandidateCVFile(HttpServletRequest request,
            HttpServletResponse response, EmployeeReferral employeeReferral) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        try {
            String fileName = request.getParameter("candidateCV");
            String candidateName = request.getParameter("candidateName");

            String filePath = File.separator + "StorageYard" + File.separator + "Other"
                    + File.separator + "UserDoc" + File.separator + "EmployeeReferral"
                    + File.separator + "CandidateCV" + File.separator + candidateName.replaceAll(" ", "") + File.separator + fileName;
//                    + File.separator + "CandidateCV" + File.separator + employeeReferral.getCandidateName() + File.separator;

            String appPath = request.getServletContext().getRealPath("");

            String fullPath = appPath + filePath;

            request.setAttribute("filePath", fullPath);

            DownloadFile downloadFile = new DownloadFile();
            downloadFile.doDownload(request, response);
        } catch (Exception e) {
            mv = createViewReferral(request, response, employeeReferral);
//            mv.setViewName("forward:employeeReferral.htm?act=createViewReferral&id="+id);
        }
    }

    public void removeCandidateCVFile(HttpServletRequest request,
            HttpServletResponse response, EmployeeReferral employeeReferral) throws Exception {
        String fileName = request.getParameter("candidateCV");
        String candidateName = request.getParameter("candidateName");

        try {
            String actualPath = "StorageYard" + File.separator + "Other"
                    + File.separator + "UserDoc" + File.separator + "EmployeeReferral"
                    + File.separator + "CandidateCV" + File.separator + candidateName.replaceAll(" ", "") + File.separator;

            String fileLocationURL = getServletContext().getRealPath("/")
                    + File.separator + actualPath;
            //String basePath = getServletContext().getRealPath("/") + "StorageYard" + File.separator + "DigitalSignature" + File.separator + userName + File.separator;
            File candidateCV = new File(fileLocationURL);

            if (candidateCV.exists()) {
                if (candidateCV.listFiles().length > 0) {
                    File[] candidateCVArray = candidateCV.listFiles();
                    candidateCVArray[0].delete();//if file exist then delete it.
                } else {
//                    request.setAttribute("isFileRemoved", Boolean.TRUE);
                }
            }
        } catch (Exception e) {
        }
    }

    public boolean isExistCandidateCVFile(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        String fileName = request.getParameter("candidateCV");

        String filePath = File.separator + "StorageYard" + File.separator
                + "Other" + File.separator + "UserDoc" + File.separator
                + "EmployeeRegistration" + File.separator + fileName;

        String appPath = request.getServletContext().getRealPath("");

        String fullPath = appPath + filePath;

        request.setAttribute("filePath", fullPath);

        DownloadFile downloadFile = new DownloadFile();
        downloadFile.doDownload(request, response);
        return true;
    }

    private void uploadCandidateCVFile(HttpServletRequest request,
            HttpServletResponse response, EmployeeReferral employeeReferral) throws Exception {
//        String fileName = request.getParameter("fileName");
        String actualPath = "StorageYard" + File.separator + "Other"
                + File.separator + "UserDoc" + File.separator + "EmployeeReferral"
                + File.separator + "CandidateCV" + File.separator + employeeReferral.getCandidateName().replaceAll(" ", "") + File.separator;

        String fileLocationURL = getServletContext().getRealPath("/")
                + File.separator + actualPath;
        //String basePath = getServletContext().getRealPath("/") + "StorageYard" + File.separator + "DigitalSignature" + File.separator + userName + File.separator;
        File candidateCV = new File(fileLocationURL);//file directory
//                File profilePicture = profilePictureFile.listFiles()[0];//First File Of Directory.
        if (candidateCV.exists() && candidateCV.listFiles().length > 0) {
            File[] candidateCVArray = candidateCV.listFiles();
//                try {
//                    request.setAttribute("candidateCV", "StorageYard" + File.separator + "UserProfile" + File.separator + userName + File.separator + profilePictureArray[0].getName().replaceAll(" ", ""));
//                } catch (Exception e) {
//                }
        }
//                String fileLocationURL1 = getServletContext().getRealPath("")
//                        + File.separator + "StorageYard" + File.separator + "DigitalSignature"
//                        + File.separator + userName + File.separator;
        if (candidateCV.exists() && candidateCV.listFiles().length > 0) {
            File[] candidateCVArray = candidateCV.listFiles();
            candidateCVArray[0].delete();//if file exist then delete it.
        }

        if (!candidateCV.exists()) {
            candidateCV.mkdir();//make directory for first time user creation.
        }
        //File Photo Uploard///
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        ////this code is using loop but there is actually only one image so changed for only single file
//                String url = "";
//                List<MultipartFile> multipartFile2 = multipartRequest.getFiles("photograph");
//                for (MultipartFile multipartFile1 : multipartFile2) {
//                    if (multipartFile1.getSize() > 0) {
//                        File file2 = new File(fileLocationURL + File.separator
//                                + multipartFile1.getOriginalFilename());
//                        url = fileLocationURL + File.separator + multipartFile1.getOriginalFilename();
//                        multipartFile1.transferTo(file2);
//                    }
//                }
        ////this is changed code for only one file.
        MultipartFile multipartFile = multipartRequest.getFile("candidateCV");
        if (multipartFile != null && multipartFile.getSize() > 0) {
            //null if there is no photograph in form.
            //this condition checking not required if photograph field is compulsary in form.
            try {
                File file2 = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", ""));
                multipartFile.transferTo(file2);
                request.setAttribute("candidateCVFile", actualPath + multipartFile.getOriginalFilename().replaceAll(" ", ""));
                request.setAttribute("candidateCVFileName", multipartFile.getOriginalFilename().replaceAll(" ", ""));
            } catch (Exception e) {

            }
        }
    }

    public ModelAndView finalApproveList(HttpServletRequest request, HttpServletResponse response, EmployeeReferral employeeReferral) throws Exception {

        ModelAndView mv = new ModelAndView();
        List<?> employeeRefList = employeeReferralService.finalApproveList(employeeReferral);
        mv.addObject("employeeRefList", employeeRefList);
        List finalHrApprovallId = employeeReferralService.finalApproveByHrHead();
        if (!finalHrApprovallId.isEmpty()) {
            EmployeeMaster em = new EmployeeMaster();
            em = (EmployeeMaster) finalHrApprovallId.get(0);
            request.setAttribute("finalApproverByHeHead", em.getId());

        }
        mv.setViewName("EmployeeReferral/EmployeeReferralListForHR");
        return mv;
    }
}
