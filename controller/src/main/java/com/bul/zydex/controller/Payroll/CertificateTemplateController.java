/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.model.CertificateTemplate;
import com.bul.zydex.model.DepartmentMaster;
import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.model.EmailMetaTag;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.EmployeeSubType;
import com.bul.zydex.model.EmployeeType;
import com.bul.zydex.model.EmployeeTypeMaster;
import com.bul.zydex.model.LocationMaster;
import com.bul.zydex.model.Modules;
import com.bul.zydex.model.ZydexLocationMaster;
import com.bul.zydex.util.DownloadFile;
import com.google.gson.Gson;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import com.itextpdf.text.PageSize;
import java.io.FileNotFoundException;
import java.util.List;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorker;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.itextpdf.tool.xml.exceptions.CssResolverException;
import com.itextpdf.tool.xml.html.Tags;
import com.itextpdf.tool.xml.parser.XMLParser;
import com.itextpdf.tool.xml.pipeline.css.CSSResolver;
import com.itextpdf.tool.xml.pipeline.css.CssResolverPipeline;
import com.itextpdf.tool.xml.pipeline.end.PdfWriterPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Irfan <irfanbhindawala@gmail.com>
 */
public class CertificateTemplateController extends CertificateTemplateAbstract {

    public ModelAndView searchSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        CertificateTemplate certificateTemplate = new CertificateTemplate();
//        List<?> employeeMasterList = employeeMasterService.read();
        List<?> certificateTemplateList = certificateTemplateService.read();

        mv.getModelMap().put("list", certificateTemplateList);
        mv.getModelMap().put("certificateTemplate", certificateTemplate);
        mv.setViewName("Payroll/CertificateTemplateResult");

        return mv;
    }

    public ModelAndView createClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        CertificateTemplate certificateTemplate = new CertificateTemplate();
        Modules modules = new Modules();
        ModuleList(request);
        certificateTemplate.setModules(modules);
        mv.getModelMap().put("certificateTemplate", certificateTemplate);
        mv.setViewName("Payroll/CertificateTemplateCreate");
        return mv;
    }

    public ModelAndView createSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        CertificateTemplate certificateTemplate = new CertificateTemplate();
        BindException errors = new BindException(certificateTemplate, "certificateTemplate");
        bind(request, certificateTemplate);

        certificateTemplate.setCertificateBody(certificateTemplate.getCertificateBody().replaceAll("&Acirc;", ""));
        certificateTemplateValidator.validate(certificateTemplate, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv.addAllObjects(errors.getModel());
//            mv = createClick(request, response);
            mv.setViewName("Payroll/CertificateTemplateCreate");
        } else {
            certificateTemplateService.create(certificateTemplate);
            request.setAttribute("successMessage",
                    "Information : The Information is saved Successfully.");

            mv.setViewName("redirect:certificateTemplate.htm?act=searchSubmit");
//            mv.setViewName("EmailTemplate/EmailTemplateCreate");
        }
        return mv;
    }

    public ModelAndView deleteSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String certificateTemplateId[] = request.getParameterValues("checkId");
        for (String z : certificateTemplateId) {
            try {
                certificateTemplateService.delete(Integer.parseInt(z));
                request.setAttribute("successMessage",
                        "Info : One or more records are deleted successfully.");
            } catch (Exception e) {

            }
        }
        mv = searchSubmit(request, response);

        return mv;
    }

    public ModelAndView editClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        CertificateTemplate certificateTemplate = new CertificateTemplate();
        Modules modules = new Modules();
        ModuleList(request);
        String id = request.getParameter("id");
        certificateTemplate = certificateTemplateService.readById(Integer.parseInt(id));
        certificateTemplate.setId(Integer.parseInt(id));
        certificateTemplate.setModules(modules);
        mv.getModelMap().put("certificateTemplate", certificateTemplate);
        mv.setViewName("Payroll/CertificateTemplateEdit");
        return mv;
    }

    public ModelAndView editSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        CertificateTemplate certificateTemplate = new CertificateTemplate();
        BindException errors = new BindException(certificateTemplate, "certificateTemplate");
        certificateTemplate.setId(Integer.parseInt(request.getParameter("id")));
        bind(request, certificateTemplate);
        certificateTemplateValidator.validate(certificateTemplate, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv = editClick(request, response);
        } else {
            certificateTemplate.setCertificateBody(certificateTemplate.getCertificateBody().replaceAll("&Acirc;", ""));
            certificateTemplateService.update(certificateTemplate);
            request.setAttribute("successMessage",
                    "Information : The Information is Updated Successfully.");
            mv = searchSubmit(request, response);

        }

        return mv;
    }

    public ModelAndView searchEmployeeDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        CertificateTemplate certificateTemplate = new CertificateTemplate();
        List<?> list = (List<?>) request.getAttribute("employeelist");
        zydexLocationList(request);
        EmployeeTypeList(request);
        EmployeeSubTypeList(request);
        request.setAttribute("search", request.getParameter("search"));
        mv.getModelMap().put("certificateTemplate", certificateTemplate);
        request.setAttribute("employeelist", list);
        mv.setViewName("Payroll/CertificateEmployeeSearch");
        return mv;
    }

    public ModelAndView searchEmpLeaveDetailSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeType employeeType = new EmployeeType();
        EmployeeSubType employeeSubType = new EmployeeSubType();

        String zydex_location_id = request.getParameter("zydexLocationMasterId");
        String type_of_employee = request.getParameter("employeeTypeMasterId");
        String employee_sub_id = request.getParameter("subTypeId");
        String payment_type = request.getParameter("paymentType");

        if (!zydex_location_id.equals("")) {
            employeeMaster.setAdharCard(zydex_location_id);
        }

        if (!type_of_employee.equals("")) {
            employeeMaster.setEmployeeType(type_of_employee);
        }
        if (null != employee_sub_id && !employee_sub_id.equals("")) {
            employeeMaster.setCompany(employee_sub_id);
        }

        if (!payment_type.equals("")) {
            employeeMaster.setPaymentType(payment_type);

        }

        List<?> list = certificateTemplateService.readEmployeeForSalary(employeeMaster);
//        mv.getModelMap().put("leavelist", list);
        request.setAttribute("employeelist", list);

        mv = searchEmployeeDetail(request, response);
//        mv.setViewName("Leave/LeaveEmployeeDetailResult");
        return mv;
    }

    public ModelAndView ViewIndiviualFormCertificate(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        CertificateTemplate certificateTemplate = new CertificateTemplate();
        String id = request.getParameter("id");
        EmployeeMaster employeeMaster = null;
        try {

            employeeMaster = (EmployeeMaster) employeeMasterService.readByEmployeeNo1(id).get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }

        CertificateTypeList(request);

        mv.getModelMap().put("certificateTemplate", certificateTemplate);
        request.setAttribute("employeeMaster", employeeMaster);
        mv.setViewName("Payroll/CertificateForm");
        return mv;
    }

    public ModelAndView readCertificateTypeAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String certificateId = request.getParameter("certificateId");
        String empId = request.getParameter("empId");

        CertificateTemplate certificateTemplate = new CertificateTemplate();
        if (null != certificateId && !"".equals(certificateId) && null != empId && !"".equals(empId)) {
            EmployeeMaster employeeMaster1 = new EmployeeMaster();
            EmployeeMaster employeeMaster2 = new EmployeeMaster();
            EmployeeMaster employeeMaster3 = new EmployeeMaster();
            EmployeeMaster employeeMaster4 = new EmployeeMaster();
            EmployeeMaster employeeMaster5 = new EmployeeMaster();
            EmployeeMaster employeeMaster6 = new EmployeeMaster();
            certificateTemplate = certificateTemplateService.readById(Integer.parseInt(certificateId));
            EmployeeMaster employeeMaster = employeeMasterService.readById(Integer.parseInt(empId));
            DepartmentMaster departmentMaster = departmentMasterService.readById(employeeMaster.getDepartmentMaster().getId());
            DesignationMaster designationMaster = designationMasterService.readById(employeeMaster.getDesignationMaster().getId());
            LocationMaster locationMaster = locationMasterService.readById(employeeMaster.getLocationMaster().getId());
            ZydexLocationMaster zydexLocationMaster = zydexLocationMasterService.readById(employeeMaster.getZydexLocationMaster().getId());
            EmployeeTypeMaster employeeTypeMaster = employeeTypeService.readById(employeeMaster.getEmployeeTypeMaster().getId());
            EmployeeSubType employeeSubType = employeeSubTypeService.readById(employeeMaster.getEmployeeSubType().getId());
            if (employeeMaster.getReportingManagerLevel1() != null && !employeeMaster.getReportingManagerLevel1().equals("")
                    && !employeeMaster.getReportingManagerLevel1().isEmpty()) {
                employeeMaster1 = employeeMasterService.readById(Integer.parseInt(employeeMaster.getReportingManagerLevel1()));
            }
            if (employeeMaster.getReportingManagerLevel2() != null && !employeeMaster.getReportingManagerLevel2().equals("")
                    && !employeeMaster.getReportingManagerLevel2().isEmpty()) {
                employeeMaster2 = employeeMasterService.readById(Integer.parseInt(employeeMaster.getReportingManagerLevel2()));
            }
            if (employeeMaster.getReportingManagerLevel3() != null && !employeeMaster.getReportingManagerLevel3().equals("")
                    && !employeeMaster.getReportingManagerLevel3().isEmpty()) {
                employeeMaster3 = employeeMasterService.readById(Integer.parseInt(employeeMaster.getReportingManagerLevel3()));

            }
            if (employeeMaster.getReportingManagerLevel4() != null && !employeeMaster.getReportingManagerLevel4().equals("")
                    && !employeeMaster.getReportingManagerLevel4().isEmpty()) {
                employeeMaster4 = employeeMasterService.readById(Integer.parseInt(employeeMaster.getReportingManagerLevel4()));
            }
            if (employeeMaster.getReportingManagerLevel5() != null && !employeeMaster.getReportingManagerLevel5().equals("")
                    && !employeeMaster.getReportingManagerLevel5().isEmpty()) {
                employeeMaster5 = employeeMasterService.readById(Integer.parseInt(employeeMaster.getReportingManagerLevel5()));
            }
            if (employeeMaster.getReportingManagerLevel6() != null && !employeeMaster.getReportingManagerLevel6().equals("")
                    && !employeeMaster.getReportingManagerLevel6().isEmpty()) {
                employeeMaster6 = employeeMasterService.readById(Integer.parseInt(employeeMaster.getReportingManagerLevel6()));
            }
            employeeMaster.setDesignationMaster(designationMaster);
            String msg = certificateTemplate.getCertificateBody();
            try {
                if (employeeMaster.getEmployeeName() != null && !employeeMaster.getEmployeeName().equals("") && !employeeMaster.getEmployeeName().isEmpty()) {
                    msg = msg.replaceAll("\\{employee_name\\}", employeeMaster.getEmployeeName());
                } else {
                    msg = msg.replaceAll("\\{employee_name\\}", "");
                }
                if (employeeMaster.getDateOfJoining() != null && !employeeMaster.getDateOfJoining().equals("") && !employeeMaster.getDateOfJoining().isEmpty()) {
                    msg = msg.replaceAll("\\{date_of_joining\\}", employeeMaster.getDateOfJoining());
                } else {
                    msg = msg.replaceAll("\\{date_of_joining\\}", "");
                }
                if (departmentMaster.getDepartmentName() != null && !departmentMaster.getDepartmentName().equals("") && !departmentMaster.getDepartmentName().isEmpty()) {
                    msg = msg.replaceAll("\\{department_name\\}", departmentMaster.getDepartmentName());
                } else {
                    msg = msg.replaceAll("\\{department_name\\}", "");
                }
                if (designationMaster.getDesignationName() != null && !designationMaster.getDesignationName().equals("") && !designationMaster.getDesignationName().isEmpty()) {
                    msg = msg.replaceAll("\\{designation_name\\}", designationMaster.getDesignationName());
                } else {
                    msg = msg.replaceAll("\\{designation_name\\}", "");
                }
                if (employeeMaster.getRole() != null && !employeeMaster.getRole().equals("") && !employeeMaster.getRole().isEmpty()) {
                    msg = msg.replaceAll("\\{role\\}", employeeMaster.getRole());
                } else {
                    msg = msg.replaceAll("\\{role\\}", "");
                }
                if (locationMaster.getLocation() != null && !locationMaster.getLocation().equals("") && !locationMaster.getLocation().isEmpty()) {
                    msg = msg.replaceAll("\\{location\\}", locationMaster.getLocation());
                } else {
                    msg = msg.replaceAll("\\{location\\}", "");
                }
                if (zydexLocationMaster.getZydexLocation() != null && !zydexLocationMaster.getZydexLocation().equals("") && !zydexLocationMaster.getZydexLocation().isEmpty()) {
                    msg = msg.replaceAll("\\{work_location\\}", zydexLocationMaster.getZydexLocation());
                } else {
                    msg = msg.replaceAll("\\{work_location\\}", "");
                }
                if (employeeMaster.getCompany() != null && !employeeMaster.getCompany().equals("") && !employeeMaster.getCompany().isEmpty()) {
                    msg = msg.replaceAll("\\{company\\}", employeeMaster.getCompany());
                } else {
                    msg = msg.replaceAll("\\{company\\}", "");
                }
                if (employeeMaster.getDateOfBirth() != null && !employeeMaster.getDateOfBirth().equals("") && !employeeMaster.getDateOfBirth().isEmpty()) {
                    msg = msg.replaceAll("\\{date_of_birth\\}", employeeMaster.getDateOfBirth());
                } else {
                    msg = msg.replaceAll("\\{date_of_birth\\}", "");
                }
                if (employeeMaster.getEmailAddress() != null && !employeeMaster.getEmailAddress().equals("") && !employeeMaster.getEmailAddress().isEmpty()) {
                    msg = msg.replaceAll("\\{email_address\\}", employeeMaster.getEmailAddress());
                } else {
                    msg = msg.replaceAll("\\{email_address\\}", "");
                }
                if (employeeMaster.getContactNo1() != null && !employeeMaster.getContactNo1().equals("") && !employeeMaster.getContactNo1().isEmpty()) {
                    msg = msg.replaceAll("\\{contact_no1\\}", employeeMaster.getContactNo1());
                } else {
                    msg = msg.replaceAll("\\{contact_no1\\}", "");
                }
                if (employeeMaster.getContactNo2() != null && !employeeMaster.getContactNo2().equals("") && !employeeMaster.getContactNo2().isEmpty()) {
                    msg = msg.replaceAll("\\{contact_no2\\}", employeeMaster.getContactNo2());
                } else {
                    msg = msg.replaceAll("\\{contact_no2\\}", "");
                }
                if (employeeMaster.getFatherName() != null && !employeeMaster.getFatherName().equals("") && !employeeMaster.getFatherName().isEmpty()) {
                    msg = msg.replaceAll("\\{father_name\\}", employeeMaster.getFatherName());
                } else {
                    msg = msg.replaceAll("\\{father_name\\}", "");
                }
                if (employeeMaster.getMotherName() != null && !employeeMaster.getMotherName().equals("") && !employeeMaster.getMotherName().isEmpty()) {
                    msg = msg.replaceAll("\\{mother_name\\}", employeeMaster.getMotherName());
                } else {
                    msg = msg.replaceAll("\\{mother_name\\}", "");
                }
                if (employeeMaster.getMaritalStatus() != null && !employeeMaster.getMaritalStatus().equals("") && !employeeMaster.getMaritalStatus().isEmpty()) {
                    msg = msg.replaceAll("\\{marital_status\\}", employeeMaster.getMaritalStatus());
                } else {
                    msg = msg.replaceAll("\\{marital_status\\}", "");
                }
                if (employeeMaster.getSpouseName() != null && !employeeMaster.getSpouseName().equals("") && !employeeMaster.getSpouseName().isEmpty()) {
                    msg = msg.replaceAll("\\{spouse_name\\}", employeeMaster.getSpouseName());
                } else {
                    msg = msg.replaceAll("\\{spouse_name\\}", "");
                }
                if (employeeMaster.getEmergencyContactPerson() != null && !employeeMaster.getEmergencyContactPerson().equals("") && !employeeMaster.getEmergencyContactPerson().isEmpty()) {
                    msg = msg.replaceAll("\\{emergency_contact_person\\}", employeeMaster.getEmergencyContactPerson());
                } else {
                    msg = msg.replaceAll("\\{emergency_contact_person\\}", "");
                }
                if (employeeMaster.getEmergencyContactNo() != null && !employeeMaster.getEmergencyContactNo().equals("") && !employeeMaster.getEmergencyContactNo().isEmpty()) {
                    msg = msg.replaceAll("\\{emergency_contact_no\\}", employeeMaster.getEmergencyContactNo());
                } else {
                    msg = msg.replaceAll("\\{emergency_contact_no\\}", "");
                }
                if (employeeMaster.getPanCard() != null && !employeeMaster.getPanCard().equals("") && !employeeMaster.getPanCard().isEmpty()) {
                    msg = msg.replaceAll("\\{pan_card\\}", employeeMaster.getPanCard());
                } else {
                    msg = msg.replaceAll("\\{pan_card\\}", "");
                }
//                if (employeeMaster.getPanCard() != null && !employeeMaster.getPanCard().equals("") && !employeeMaster.getPanCard().isEmpty()) {
//                    msg = msg.replaceAll("\\{passport_no\\}", employeeMaster.getPassportNo());
//                } else {
//                    msg = msg.replaceAll("\\{passport_no\\}", "");
//                }
//                if (employeeMaster.getPassportIssueDate() != null && !employeeMaster.getPassportIssueDate().equals("") && !employeeMaster.getPassportIssueDate().isEmpty()) {
//                    msg = msg.replaceAll("\\{passport_issue_date\\}", employeeMaster.getPassportIssueDate());
//                } else {
//                    msg = msg.replaceAll("\\{passport_issue_date\\}", "");
//                }
//                if (employeeMaster.getPassportExpiryDate() != null && !employeeMaster.getPassportExpiryDate().equals("") && !employeeMaster.getPassportExpiryDate().isEmpty()) {
//                    msg = msg.replaceAll("\\{passport_expiry_date\\}", employeeMaster.getPassportExpiryDate());
//                } else {
//                    msg = msg.replaceAll("\\{passport_expiry_date\\}", "");
//                }
                if (employeeMaster.getDateOfLeaving() != null && !employeeMaster.getDateOfLeaving().equals("") && !employeeMaster.getDateOfLeaving().isEmpty()) {
                    msg = msg.replaceAll("\\{date_of_leaving\\}", employeeMaster.getDateOfLeaving());
                } else {
                    msg = msg.replaceAll("\\{date_of_leaving\\}", "");
                }
                if (employeeMaster.getReasonForLeaving() != null && !employeeMaster.getReasonForLeaving().equals("") && !employeeMaster.getReasonForLeaving().isEmpty()) {
                    msg = msg.replaceAll("\\{reason_for_leaving\\}", employeeMaster.getReasonForLeaving());
                } else {
                    msg = msg.replaceAll("\\{reason_for_leaving\\}", "");
                }
                if (employeeMaster.getEmployeeType() != null && !employeeMaster.getEmployeeType().equals("") && !employeeMaster.getEmployeeType().isEmpty()) {
                    msg = msg.replaceAll("\\{employee_type\\}", employeeMaster.getEmployeeType());
                } else {
                    msg = msg.replaceAll("\\{employee_type\\}", "");
                }
                if (employeeMaster1.getEmployeeName() != null && !employeeMaster1.getEmployeeName().equals("") && !employeeMaster1.getEmployeeName().isEmpty()) {
                    msg = msg.replaceAll("\\{reporting_manager_level1\\}", employeeMaster1.getEmployeeName());
                } else {
                    msg = msg.replaceAll("\\{reporting_manager_level1\\}", "");
                }
                if (employeeMaster2.getEmployeeName() != null && !employeeMaster2.getEmployeeName().equals("") && !employeeMaster2.getEmployeeName().isEmpty()) {
                    msg = msg.replaceAll("\\{reporting_manager_level2\\}", employeeMaster2.getEmployeeName());
                } else {
                    msg = msg.replaceAll("\\{reporting_manager_level2\\}", "");
                }
                if (employeeMaster3.getEmployeeName() != null && !employeeMaster3.getEmployeeName().equals("") && !employeeMaster3.getEmployeeName().isEmpty()) {
                    msg = msg.replaceAll("\\{reporting_manager_level3\\}", employeeMaster3.getEmployeeName());
                } else {
                    msg = msg.replaceAll("\\{reporting_manager_level3\\}", "");
                }
                if (employeeMaster4.getEmployeeName() != null && !employeeMaster4.getEmployeeName().equals("") && !employeeMaster4.getEmployeeName().isEmpty()) {
                    msg = msg.replaceAll("\\{reporting_manager_level4\\}", employeeMaster4.getEmployeeName());
                } else {
                    msg = msg.replaceAll("\\{reporting_manager_level4\\}", "");
                }
                if (employeeMaster5.getEmployeeName() != null && !employeeMaster5.getEmployeeName().equals("") && !employeeMaster5.getEmployeeName().isEmpty()) {
                    msg = msg.replaceAll("\\{reporting_manager_level5\\}", employeeMaster5.getEmployeeName());
                } else {
                    msg = msg.replaceAll("\\{reporting_manager_level5\\}", "");
                }
                if (employeeMaster6.getEmployeeName() != null && !employeeMaster6.getEmployeeName().equals("") && !employeeMaster6.getEmployeeName().isEmpty()) {
                    msg = msg.replaceAll("\\{reporting_manager_level6\\}", employeeMaster6.getEmployeeName());
                } else {
                    msg = msg.replaceAll("\\{reporting_manager_level6\\}", "");
                }
                if (employeeMaster.getShiftType() != null && !employeeMaster.getShiftType().equals("") && !employeeMaster.getShiftType().isEmpty()) {
                    msg = msg.replaceAll("\\{shift_type\\}", employeeMaster.getShiftType());
                } else {
                    msg = msg.replaceAll("\\{shift_type\\}", "");
                }
                if (employeeMaster.getOfficeEmailId() != null && !employeeMaster.getOfficeEmailId().equals("") && !employeeMaster.getOfficeEmailId().isEmpty()) {
                    msg = msg.replaceAll("\\{office_email_id\\}", employeeMaster.getOfficeEmailId());
                } else {
                    msg = msg.replaceAll("\\{office_email_id\\}", "");
                }
                if (employeeMaster.getChild1() != null && !employeeMaster.getChild1().equals("") && !employeeMaster.getChild1().isEmpty()) {
                    msg = msg.replaceAll("\\{child1\\}", employeeMaster.getChild1());
                } else {
                    msg = msg.replaceAll("\\{child1\\}", "");
                }
                if (employeeMaster.getChild2() != null && !employeeMaster.getChild2().equals("") && !employeeMaster.getChild2().isEmpty()) {
                    msg = msg.replaceAll("\\{child2\\}", employeeMaster.getChild2());
                } else {
                    msg = msg.replaceAll("\\{child2\\}", "");
                }
                if (employeeMaster.getHighestEducationDetails() != null && !employeeMaster.getHighestEducationDetails().equals("") && !employeeMaster.getHighestEducationDetails().isEmpty()) {
                    msg = msg.replaceAll("\\{highest_education_details\\}", employeeMaster.getHighestEducationDetails());
                } else {
                    msg = msg.replaceAll("\\{highest_education_details\\}", "");
                }
                if (employeeMaster.getExperienceYearOnDoj() != null && !employeeMaster.getExperienceYearOnDoj().equals("") && !employeeMaster.getExperienceYearOnDoj().isEmpty()) {
                    msg = msg.replaceAll("\\{experience_year_on_doj\\}", employeeMaster.getExperienceYearOnDoj());
                } else {
                    msg = msg.replaceAll("\\{experience_year_on_doj\\}", "");
                }
                if (employeeMaster.getPermanentAddress() != null && !employeeMaster.getPermanentAddress().equals("") && !employeeMaster.getPermanentAddress().isEmpty()) {
                    msg = msg.replaceAll("\\{permanent_address\\}", employeeMaster.getPermanentAddress());
                } else {
                    msg = msg.replaceAll("\\{permanent_address\\}", "");
                }
                if (employeeMaster.getPresentAddress() != null && !employeeMaster.getPresentAddress().equals("") && !employeeMaster.getPresentAddress().isEmpty()) {
                    msg = msg.replaceAll("\\{present_address\\}", employeeMaster.getPresentAddress());
                } else {
                    msg = msg.replaceAll("\\{present_address\\}", "");
                }
                if (employeeMaster.getAdharCard() != null && !employeeMaster.getAdharCard().equals("") && !employeeMaster.getAdharCard().isEmpty()) {
                    msg = msg.replaceAll("\\{adhar_card\\}", employeeMaster.getAdharCard());
                } else {
                    msg = msg.replaceAll("\\{adhar_card\\}", "");
                }
                if (employeeMaster.getDrivingLicence() != null && !employeeMaster.getDrivingLicence().equals("") && !employeeMaster.getDrivingLicence().isEmpty()) {
                    msg = msg.replaceAll("\\{driving_licence\\}", employeeMaster.getDrivingLicence());
                } else {
                    msg = msg.replaceAll("\\{driving_licence\\}", "");
                }
                if (employeeMaster.getBloodGroups() != null && !employeeMaster.getBloodGroups().equals("") && !employeeMaster.getBloodGroups().isEmpty()) {
                    msg = msg.replaceAll("\\{blood_groups\\}", employeeMaster.getBloodGroups());
                } else {
                    msg = msg.replaceAll("\\{blood_groups\\}", "");
                }
                if (employeeMaster.getMaritalStatus() != null && !employeeMaster.getMaritalStatus().equals("") && !employeeMaster.getMaritalStatus().isEmpty()) {
                    msg = msg.replaceAll("\\{marital_status\\}", employeeMaster.getMaritalStatus());
                } else {
                    msg = msg.replaceAll("\\{marital_status\\}", "");
                }
                if (employeeMaster.getExperienceMonthOnDoj() != null && !employeeMaster.getExperienceMonthOnDoj().equals("") && !employeeMaster.getExperienceMonthOnDoj().isEmpty()) {
                    msg = msg.replaceAll("\\{experience_month_on_doj\\}", employeeMaster.getExperienceMonthOnDoj());
                } else {
                    msg = msg.replaceAll("\\{experience_month_on_doj\\}", "");
                }
                if (employeeMaster.getBankName() != null && !employeeMaster.getBankName().equals("") && !employeeMaster.getBankName().isEmpty()) {
                    msg = msg.replaceAll("\\{bank_name\\}", employeeMaster.getBankName());
                } else {
                    msg = msg.replaceAll("\\{bank_name\\}", "");
                }
                if (employeeMaster.getBankAccountNo() != null && !employeeMaster.getBankAccountNo().equals("") && !employeeMaster.getBankAccountNo().isEmpty()) {
                    msg = msg.replaceAll("\\{bank_account_no\\}", employeeMaster.getBankAccountNo());
                } else {
                    msg = msg.replaceAll("\\{bank_account_no\\}", "");
                }
                if (employeeMaster.getBankIfscCode() != null && !employeeMaster.getBankIfscCode().equals("") && !employeeMaster.getBankIfscCode().isEmpty()) {
                    msg = msg.replaceAll("\\{bank_ifsc_code\\}", employeeMaster.getBankIfscCode());
                } else {
                    msg = msg.replaceAll("\\{bank_ifsc_code\\}", "");
                }
                if (employeeMaster.getCityOfEmployee() != null && !employeeMaster.getCityOfEmployee().equals("") && !employeeMaster.getCityOfEmployee().isEmpty()) {
                    msg = msg.replaceAll("\\{city_of_employee\\}", employeeMaster.getCityOfEmployee());
                } else {
                    msg = msg.replaceAll("\\{city_of_employee\\}", "");
                }
                if (employeeMaster.getDateOfBirthOfEmpFather() != null && !employeeMaster.getDateOfBirthOfEmpFather().equals("") && !employeeMaster.getDateOfBirthOfEmpFather().isEmpty()) {
                    msg = msg.replaceAll("\\{date_of_birth_of_emp_father\\}", employeeMaster.getDateOfBirthOfEmpFather());
                } else {
                    msg = msg.replaceAll("\\{date_of_birth_of_emp_father\\}", "");
                }
                if (employeeMaster.getDateOfBirthOfEmpMother() != null && !employeeMaster.getDateOfBirthOfEmpMother().equals("") && !employeeMaster.getDateOfBirthOfEmpMother().isEmpty()) {
                    msg = msg.replaceAll("\\{date_of_birth_of_emp_mother\\}", employeeMaster.getDateOfBirthOfEmpMother());
                } else {
                    msg = msg.replaceAll("\\{date_of_birth_of_emp_mother\\}", "");
                }
                if (employeeMaster.getDateOfBirthOfEmpSpous() != null && !employeeMaster.getDateOfBirthOfEmpSpous().equals("") && !employeeMaster.getDateOfBirthOfEmpSpous().isEmpty()) {
                    msg = msg.replaceAll("\\{date_of_birth_of_emp_spous\\}", employeeMaster.getDateOfBirthOfEmpSpous());
                } else {
                    msg = msg.replaceAll("\\{date_of_birth_of_emp_spous\\}", "");
                }
                if (employeeMaster.getDateOfBirthOfEmpChilld1() != null && !employeeMaster.getDateOfBirthOfEmpChilld1().equals("") && !employeeMaster.getDateOfBirthOfEmpChilld1().isEmpty()) {
                    msg = msg.replaceAll("\\{date_of_birth_of_emp_chilld1\\}", employeeMaster.getDateOfBirthOfEmpChilld1());
                } else {
                    msg = msg.replaceAll("\\{date_of_birth_of_emp_chilld1\\}", "");
                }
                if (employeeMaster.getDateOfBirthOfEmpChild2() != null && !employeeMaster.getDateOfBirthOfEmpChild2().equals("") && !employeeMaster.getDateOfBirthOfEmpChild2().isEmpty()) {
                    msg = msg.replaceAll("\\{date_of_birth_of_emp_child2\\}", employeeMaster.getDateOfBirthOfEmpChild2());
                } else {
                    msg = msg.replaceAll("\\{date_of_birth_of_emp_child2\\}", "");
                }
                if (employeeMaster.getPaymentType() != null && !employeeMaster.getPaymentType().equals("") && !employeeMaster.getPaymentType().isEmpty()) {
                    msg = msg.replaceAll("\\{payment_type\\}", employeeMaster.getPaymentType());
                } else {
                    msg = msg.replaceAll("\\{payment_type\\}", "");
                }
                if (employeeMaster.getPfNo() != null && !employeeMaster.getPfNo().equals("")
                        && !employeeMaster.getPfNo().isEmpty()) {
                    msg = msg.replaceAll("\\{pf_no\\}", employeeMaster.getPfNo());
                } else {
                    msg = msg.replaceAll("\\{pf_no\\}", "");
                }
                if (employeeMaster.getUanNo() != null && !employeeMaster.getUanNo().equals("") && !employeeMaster.getUanNo().isEmpty()) {
                    msg = msg.replaceAll("\\{uan_no\\}", employeeMaster.getUanNo());
                } else {
                    msg = msg.replaceAll("\\{uan_no\\}", "");
                }
                if (employeeMaster.getBasicSalary() != null && !employeeMaster.getBasicSalary().equals("") && !employeeMaster.getBasicSalary().isEmpty()) {
                    msg = msg.replaceAll("\\{basic_salary\\}", employeeMaster.getBasicSalary());
                } else {
                    msg = msg.replaceAll("\\{basic_salary\\}", "");
                }
                if (employeeMaster.getEsicNo() != null && !employeeMaster.getEsicNo().equals("") && !employeeMaster.getEsicNo().isEmpty()) {
                    msg = msg.replaceAll("\\{esic_no\\}", employeeMaster.getEsicNo());
                } else {
                    msg = msg.replaceAll("\\{esic_no\\}", "");
                }
                if (employeeTypeMaster.getTypeOfEmployee() != null && !employeeTypeMaster.getTypeOfEmployee().equals("") && !employeeTypeMaster.getTypeOfEmployee().isEmpty()) {
                    msg = msg.replaceAll("\\{type_of_employee\\}", employeeTypeMaster.getTypeOfEmployee());
                } else {
                    msg = msg.replaceAll("\\{type_of_employee\\}", "");
                }
                if (employeeSubType.getSubType() != null && !employeeSubType.getSubType().equals("") && !employeeSubType.getSubType().isEmpty()) {
                    msg = msg.replaceAll("\\{employee_sub_type\\}", employeeSubType.getSubType());
                } else {
                    msg = msg.replaceAll("\\{employee_sub_type\\}", "");
                }
                if (employeeMaster.getPfAmount() != null && !employeeMaster.getPfAmount().equals("") && !employeeMaster.getPfAmount().isEmpty()) {
                    msg = msg.replaceAll("\\{pf_amount\\}", employeeMaster.getPfAmount());
                } else {
                    msg = msg.replaceAll("\\{pf_amount\\}", "");
                }
                if (employeeMaster.getConfirmationDate() != null && !employeeMaster.getConfirmationDate().equals("") && !employeeMaster.getConfirmationDate().isEmpty()) {
                    msg = msg.replaceAll("\\{confirmation_date\\}", employeeMaster.getConfirmationDate());
                } else {
                    msg = msg.replaceAll("\\{confirmation_date\\}", "");
                }
                if (employeeMaster.getPfAmountEmployer() != null && !employeeMaster.getPfAmountEmployer().equals("") && !employeeMaster.getPfAmountEmployer().isEmpty()) {
                    msg = msg.replaceAll("\\{pf_amount_employer\\}", employeeMaster.getPfAmountEmployer());
                } else {
                    msg = msg.replaceAll("\\{pf_amount_employer\\}", "");
                }
                if (employeeMaster.getEmployeeLocation() != null && !employeeMaster.getEmployeeLocation().equals("") && !employeeMaster.getEmployeeLocation().isEmpty()) {
                    msg = msg.replaceAll("\\{employee_location\\}", employeeMaster.getEmployeeLocation());
                } else {
                    msg = msg.replaceAll("\\{employee_location\\}", "");
                }
                if (employeeMaster.getGrossTotal() != null && !employeeMaster.getGrossTotal().equals("") && !employeeMaster.getGrossTotal().isNaN()) {
                    msg = msg.replaceAll("\\{gross_total\\}", employeeMaster.getGrossTotal().toString());
                } else {
                    msg = msg.replaceAll("\\{gross_total\\}", "");
                }
                if (employeeMaster.getCtcTotal() != null && !employeeMaster.getCtcTotal().equals("") && !employeeMaster.getCtcTotal().isNaN()) {
                    msg = msg.replaceAll("\\{ctc_total\\}", employeeMaster.getCtcTotal().toString());
                } else {
                    msg = msg.replaceAll("\\{ctc_total\\}", "");
                }
                if (employeeMaster.getSalaryBase().TRUE) {
                    msg = msg.replaceAll("\\{salary_detail\\}", employeeMaster.getSalaryBase().toString());
                } else {
                    msg = msg.replaceAll("\\{salary_detail\\}", "");
                }

            } catch (Exception e) {
            }
            String path = getpdf1(msg, employeeMaster.getEmployeeName(), certificateTemplate.getCertificateTitle());
            request.setAttribute("path", path);
            request.setAttribute("msg", msg);
            request.setAttribute("employeeName", employeeMaster.getEmployeeName());
            request.setAttribute("certificateTemplateType", certificateTemplate.getCertificateTitle());
        }
        mv.setViewName("Payroll/CertificateAjax");
        return mv;
    }

    public void getEmailMetaTag(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int moduleId = Integer.valueOf(request.getParameter("moduleId"));
        Map<Integer, String> emailMetaTagMap = new HashMap<Integer, String>();
        List emailMetaTagList = emailMetaTagService.readEmailMetatag(moduleId);
        EmailMetaTag emailMetaTag = new EmailMetaTag();
        for (Object o : emailMetaTagList) {
            emailMetaTag = (EmailMetaTag) o;
            emailMetaTagMap.put(emailMetaTag.getId(), emailMetaTag.getName());
        }
        String jsonOfemailMetaTagMap = new Gson().toJson(emailMetaTagMap);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.write(jsonOfemailMetaTagMap);

        } finally {
            out.close();
        }
    }

    public String getpdf1(String msg, String name, String certiName) throws FileNotFoundException, DocumentException, IOException, CssResolverException {

        Document document = new Document(PageSize.A4, 0, 0, 0, 0);
        String filePath = "StorageYard"
                + File.separator + "Certificate" + File.separator + name;
        String fileLocationURL = getServletContext().getRealPath("/")
                + File.separator + "StorageYard"
                + File.separator + "Certificate" + File.separator + name;
        File Folder1 = new File(fileLocationURL);
        if (!Folder1.exists()) {
            Folder1.mkdirs();
        }
        String path = fileLocationURL + File.separator + certiName + ".pdf";
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path));
        document.setMargins(0, 0, 0, 0);
        document.open();
        CSSResolver cssResolver = XMLWorkerHelper.getInstance().getDefaultCssResolver(false);
        cssResolver.addCss("div{margin:0 pt; padding: 20pt;}", true);
        HtmlPipelineContext htmlContext = new HtmlPipelineContext(null);
        htmlContext.setTagFactory(Tags.getHtmlTagProcessorFactory());
        PdfWriterPipeline pdf = new PdfWriterPipeline(document, writer);
        HtmlPipeline html = new HtmlPipeline(htmlContext, pdf);
        CssResolverPipeline css = new CssResolverPipeline(cssResolver, html);
        StringBuilder sb = new StringBuilder();
        sb.append("<div>");
        sb.append(msg);
        sb.append("</div>");
        XMLWorker worker = new XMLWorker(css, true);
        XMLParser p = new XMLParser(worker);
        p.parse(new ByteArrayInputStream(sb.toString().getBytes()));
        document.close();
        return filePath;
    }

    public ModelAndView readCertificateTypeAjaxNew(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String certificateId = request.getParameter("certificateId");
        String empId = request.getParameter("empId");

        CertificateTemplate certificateTemplate = new CertificateTemplate();
        if (null != certificateId && !"".equals(certificateId) && null != empId && !"".equals(empId)) {
            EmployeeMaster employeeMaster1 = new EmployeeMaster();
            EmployeeMaster employeeMaster2 = new EmployeeMaster();
            EmployeeMaster employeeMaster3 = new EmployeeMaster();
            EmployeeMaster employeeMaster4 = new EmployeeMaster();
            EmployeeMaster employeeMaster5 = new EmployeeMaster();
            EmployeeMaster employeeMaster6 = new EmployeeMaster();
            certificateTemplate = certificateTemplateService.readById(Integer.parseInt(certificateId));
            EmployeeMaster employeeMaster = employeeMasterService.readById(Integer.parseInt(empId));
            DepartmentMaster departmentMaster = departmentMasterService.readById(employeeMaster.getDepartmentMaster().getId());
            DesignationMaster designationMaster = designationMasterService.readById(employeeMaster.getDesignationMaster().getId());
            LocationMaster locationMaster = locationMasterService.readById(employeeMaster.getLocationMaster().getId());
            ZydexLocationMaster zydexLocationMaster = zydexLocationMasterService.readById(employeeMaster.getZydexLocationMaster().getId());
            EmployeeTypeMaster employeeTypeMaster = employeeTypeService.readById(employeeMaster.getEmployeeTypeMaster().getId());
            EmployeeSubType employeeSubType = employeeSubTypeService.readById(employeeMaster.getEmployeeSubType().getId());
            if (employeeMaster.getReportingManagerLevel1() != null && !employeeMaster.getReportingManagerLevel1().equals("")
                    && !employeeMaster.getReportingManagerLevel1().isEmpty()) {
                employeeMaster1 = employeeMasterService.readById(Integer.parseInt(employeeMaster.getReportingManagerLevel1()));
            }
            if (employeeMaster.getReportingManagerLevel2() != null && !employeeMaster.getReportingManagerLevel2().equals("")
                    && !employeeMaster.getReportingManagerLevel2().isEmpty()) {
                employeeMaster2 = employeeMasterService.readById(Integer.parseInt(employeeMaster.getReportingManagerLevel2()));
            }
            if (employeeMaster.getReportingManagerLevel3() != null && !employeeMaster.getReportingManagerLevel3().equals("")
                    && !employeeMaster.getReportingManagerLevel3().isEmpty()) {
                employeeMaster3 = employeeMasterService.readById(Integer.parseInt(employeeMaster.getReportingManagerLevel3()));

            }
            if (employeeMaster.getReportingManagerLevel4() != null && !employeeMaster.getReportingManagerLevel4().equals("")
                    && !employeeMaster.getReportingManagerLevel4().isEmpty()) {
                employeeMaster4 = employeeMasterService.readById(Integer.parseInt(employeeMaster.getReportingManagerLevel4()));
            }
            if (employeeMaster.getReportingManagerLevel5() != null && !employeeMaster.getReportingManagerLevel5().equals("")
                    && !employeeMaster.getReportingManagerLevel5().isEmpty()) {
                employeeMaster5 = employeeMasterService.readById(Integer.parseInt(employeeMaster.getReportingManagerLevel5()));
            }
            if (employeeMaster.getReportingManagerLevel6() != null && !employeeMaster.getReportingManagerLevel6().equals("")
                    && !employeeMaster.getReportingManagerLevel6().isEmpty()) {
                employeeMaster6 = employeeMasterService.readById(Integer.parseInt(employeeMaster.getReportingManagerLevel6()));
            }
            employeeMaster.setDesignationMaster(designationMaster);
            String msg = certificateTemplate.getCertificateBody();
            try {
                if (employeeMaster.getEmployeeName() != null && !employeeMaster.getEmployeeName().equals("") && !employeeMaster.getEmployeeName().isEmpty()) {
                    msg = msg.replaceAll("\\{employee_name\\}", employeeMaster.getEmployeeName());
                } else {
                    msg = msg.replaceAll("\\{employee_name\\}", "");
                }
                if (employeeMaster.getEmployeeName() != null && !employeeMaster.getEmployeeName().equals("") && !employeeMaster.getEmployeeName().isEmpty()) {
                    msg = msg.replaceAll("\\{name\\}", employeeMaster.getEmployeeName());
                } else {
                    msg = msg.replaceAll("\\{name\\}", "");
                }

                if (employeeMaster.getDateOfJoining() != null && !employeeMaster.getDateOfJoining().equals("") && !employeeMaster.getDateOfJoining().isEmpty()) {
                    msg = msg.replaceAll("\\{date_of_joining\\}", employeeMaster.getDateOfJoining());
                } else {
                    msg = msg.replaceAll("\\{date_of_joining\\}", "");
                }
                if (departmentMaster.getDepartmentName() != null && !departmentMaster.getDepartmentName().equals("") && !departmentMaster.getDepartmentName().isEmpty()) {
                    msg = msg.replaceAll("\\{department_name\\}", departmentMaster.getDepartmentName());
                } else {
                    msg = msg.replaceAll("\\{department_name\\}", "");
                }
                if (designationMaster.getDesignationName() != null && !designationMaster.getDesignationName().equals("") && !designationMaster.getDesignationName().isEmpty()) {
                    msg = msg.replaceAll("\\{name_position\\}", designationMaster.getDesignationName());
                } else {
                    msg = msg.replaceAll("\\{name_position\\}", "");
                }
                if (designationMaster.getDesignationName() != null && !designationMaster.getDesignationName().equals("") && !designationMaster.getDesignationName().isEmpty()) {
                    msg = msg.replaceAll("\\{designation_name\\}", designationMaster.getDesignationName());
                } else {
                    msg = msg.replaceAll("\\{designation_name\\}", "");
                }
                if (employeeMaster.getRole() != null && !employeeMaster.getRole().equals("") && !employeeMaster.getRole().isEmpty()) {
                    msg = msg.replaceAll("\\{role\\}", employeeMaster.getRole());
                } else {
                    msg = msg.replaceAll("\\{role\\}", "");
                }
                if (locationMaster.getLocation() != null && !locationMaster.getLocation().equals("") && !locationMaster.getLocation().isEmpty()) {
                    msg = msg.replaceAll("\\{location\\}", locationMaster.getLocation());
                } else {
                    msg = msg.replaceAll("\\{location\\}", "");
                }
                if (zydexLocationMaster.getZydexLocation() != null && !zydexLocationMaster.getZydexLocation().equals("") && !zydexLocationMaster.getZydexLocation().isEmpty()) {
                    msg = msg.replaceAll("\\{work_location\\}", zydexLocationMaster.getZydexLocation());
                } else {
                    msg = msg.replaceAll("\\{work_location\\}", "");
                }
                if (employeeMaster.getCompany() != null && !employeeMaster.getCompany().equals("") && !employeeMaster.getCompany().isEmpty()) {
                    msg = msg.replaceAll("\\{company\\}", employeeMaster.getCompany());
                } else {
                    msg = msg.replaceAll("\\{company\\}", "");
                }
//                if (employeeMaster.getDateOfBirth() != null && !employeeMaster.getDateOfBirth().equals("") && !employeeMaster.getDateOfBirth().isEmpty()) {
//                    msg = msg.replaceAll("\\{date_of_birth\\}", employeeMaster.getDateOfBirth());
//                } else {
//                    msg = msg.replaceAll("\\{date_of_birth\\}", "");
//                }
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String d1 = sdf.format(date);
                msg = msg.replaceAll("\\{date_of_birth\\}", d1);

                if (employeeMaster.getEmailAddress() != null && !employeeMaster.getEmailAddress().equals("") && !employeeMaster.getEmailAddress().isEmpty()) {
                    msg = msg.replaceAll("\\{email_address\\}", employeeMaster.getEmailAddress());
                } else {
                    msg = msg.replaceAll("\\{email_address\\}", "");
                }
                if (employeeMaster.getContactNo1() != null && !employeeMaster.getContactNo1().equals("") && !employeeMaster.getContactNo1().isEmpty()) {
                    msg = msg.replaceAll("\\{contact_no1\\}", employeeMaster.getContactNo1());
                } else {
                    msg = msg.replaceAll("\\{contact_no1\\}", "");
                }
                if (employeeMaster.getContactNo2() != null && !employeeMaster.getContactNo2().equals("") && !employeeMaster.getContactNo2().isEmpty()) {
                    msg = msg.replaceAll("\\{contact_no2\\}", employeeMaster.getContactNo2());
                } else {
                    msg = msg.replaceAll("\\{contact_no2\\}", "");
                }
                if (employeeMaster.getFatherName() != null && !employeeMaster.getFatherName().equals("") && !employeeMaster.getFatherName().isEmpty()) {
                    msg = msg.replaceAll("\\{father_name\\}", employeeMaster.getFatherName());
                } else {
                    msg = msg.replaceAll("\\{father_name\\}", "");
                }
                if (employeeMaster.getMotherName() != null && !employeeMaster.getMotherName().equals("") && !employeeMaster.getMotherName().isEmpty()) {
                    msg = msg.replaceAll("\\{mother_name\\}", employeeMaster.getMotherName());
                } else {
                    msg = msg.replaceAll("\\{mother_name\\}", "");
                }
                if (employeeMaster.getMaritalStatus() != null && !employeeMaster.getMaritalStatus().equals("") && !employeeMaster.getMaritalStatus().isEmpty()) {
                    msg = msg.replaceAll("\\{marital_status\\}", employeeMaster.getMaritalStatus());
                } else {
                    msg = msg.replaceAll("\\{marital_status\\}", "");
                }
                if (employeeMaster.getSpouseName() != null && !employeeMaster.getSpouseName().equals("") && !employeeMaster.getSpouseName().isEmpty()) {
                    msg = msg.replaceAll("\\{spouse_name\\}", employeeMaster.getSpouseName());
                } else {
                    msg = msg.replaceAll("\\{spouse_name\\}", "");
                }
                if (employeeMaster.getEmergencyContactPerson() != null && !employeeMaster.getEmergencyContactPerson().equals("") && !employeeMaster.getEmergencyContactPerson().isEmpty()) {
                    msg = msg.replaceAll("\\{emergency_contact_person\\}", employeeMaster.getEmergencyContactPerson());
                } else {
                    msg = msg.replaceAll("\\{emergency_contact_person\\}", "");
                }
                if (employeeMaster.getEmergencyContactNo() != null && !employeeMaster.getEmergencyContactNo().equals("") && !employeeMaster.getEmergencyContactNo().isEmpty()) {
                    msg = msg.replaceAll("\\{emergency_contact_no\\}", employeeMaster.getEmergencyContactNo());
                } else {
                    msg = msg.replaceAll("\\{emergency_contact_no\\}", "");
                }
                if (employeeMaster.getPanCard() != null && !employeeMaster.getPanCard().equals("") && !employeeMaster.getPanCard().isEmpty()) {
                    msg = msg.replaceAll("\\{pan_card\\}", employeeMaster.getPanCard());
                } else {
                    msg = msg.replaceAll("\\{pan_card\\}", "");
                }
//                if (employeeMaster.getPanCard() != null && !employeeMaster.getPanCard().equals("") && !employeeMaster.getPanCard().isEmpty()) {
//                    msg = msg.replaceAll("\\{passport_no\\}", employeeMaster.getPassportNo());
//                } else {
//                    msg = msg.replaceAll("\\{passport_no\\}", "");
//                }
//                if (employeeMaster.getPassportIssueDate() != null && !employeeMaster.getPassportIssueDate().equals("") && !employeeMaster.getPassportIssueDate().isEmpty()) {
//                    msg = msg.replaceAll("\\{passport_issue_date\\}", employeeMaster.getPassportIssueDate());
//                } else {
//                    msg = msg.replaceAll("\\{passport_issue_date\\}", "");
//                }
//                if (employeeMaster.getPassportExpiryDate() != null && !employeeMaster.getPassportExpiryDate().equals("") && !employeeMaster.getPassportExpiryDate().isEmpty()) {
//                    msg = msg.replaceAll("\\{passport_expiry_date\\}", employeeMaster.getPassportExpiryDate());
//                } else {
//                    msg = msg.replaceAll("\\{passport_expiry_date\\}", "");
//                }
                if (employeeMaster.getDateOfLeaving() != null && !employeeMaster.getDateOfLeaving().equals("") && !employeeMaster.getDateOfLeaving().isEmpty()) {
                    msg = msg.replaceAll("\\{date_of_leaving\\}", employeeMaster.getDateOfLeaving());
                } else {
                    msg = msg.replaceAll("\\{date_of_leaving\\}", "");
                }
                if (employeeMaster.getReasonForLeaving() != null && !employeeMaster.getReasonForLeaving().equals("") && !employeeMaster.getReasonForLeaving().isEmpty()) {
                    msg = msg.replaceAll("\\{reason_for_leaving\\}", employeeMaster.getReasonForLeaving());
                } else {
                    msg = msg.replaceAll("\\{reason_for_leaving\\}", "");
                }
                if (employeeMaster.getEmployeeType() != null && !employeeMaster.getEmployeeType().equals("") && !employeeMaster.getEmployeeType().isEmpty()) {
                    msg = msg.replaceAll("\\{employee_type\\}", employeeMaster.getEmployeeType());
                } else {
                    msg = msg.replaceAll("\\{employee_type\\}", "");
                }
                if (employeeMaster1.getEmployeeName() != null && !employeeMaster1.getEmployeeName().equals("") && !employeeMaster1.getEmployeeName().isEmpty()) {
                    msg = msg.replaceAll("\\{reporting_manager_level1\\}", employeeMaster1.getEmployeeName());
                } else {
                    msg = msg.replaceAll("\\{reporting_manager_level1\\}", "");
                }
                if (employeeMaster2.getEmployeeName() != null && !employeeMaster2.getEmployeeName().equals("") && !employeeMaster2.getEmployeeName().isEmpty()) {
                    msg = msg.replaceAll("\\{reporting_manager_level2\\}", employeeMaster2.getEmployeeName());
                } else {
                    msg = msg.replaceAll("\\{reporting_manager_level2\\}", "");
                }
                if (employeeMaster3.getEmployeeName() != null && !employeeMaster3.getEmployeeName().equals("") && !employeeMaster3.getEmployeeName().isEmpty()) {
                    msg = msg.replaceAll("\\{reporting_manager_level3\\}", employeeMaster3.getEmployeeName());
                } else {
                    msg = msg.replaceAll("\\{reporting_manager_level3\\}", "");
                }
                if (employeeMaster4.getEmployeeName() != null && !employeeMaster4.getEmployeeName().equals("") && !employeeMaster4.getEmployeeName().isEmpty()) {
                    msg = msg.replaceAll("\\{reporting_manager_level4\\}", employeeMaster4.getEmployeeName());
                } else {
                    msg = msg.replaceAll("\\{reporting_manager_level4\\}", "");
                }
                if (employeeMaster5.getEmployeeName() != null && !employeeMaster5.getEmployeeName().equals("") && !employeeMaster5.getEmployeeName().isEmpty()) {
                    msg = msg.replaceAll("\\{reporting_manager_level5\\}", employeeMaster5.getEmployeeName());
                } else {
                    msg = msg.replaceAll("\\{reporting_manager_level5\\}", "");
                }
                if (employeeMaster6.getEmployeeName() != null && !employeeMaster6.getEmployeeName().equals("") && !employeeMaster6.getEmployeeName().isEmpty()) {
                    msg = msg.replaceAll("\\{reporting_manager_level6\\}", employeeMaster6.getEmployeeName());
                } else {
                    msg = msg.replaceAll("\\{reporting_manager_level6\\}", "");
                }
                if (employeeMaster.getShiftType() != null && !employeeMaster.getShiftType().equals("") && !employeeMaster.getShiftType().isEmpty()) {
                    msg = msg.replaceAll("\\{shift_type\\}", employeeMaster.getShiftType());
                } else {
                    msg = msg.replaceAll("\\{shift_type\\}", "");
                }
                if (employeeMaster.getOfficeEmailId() != null && !employeeMaster.getOfficeEmailId().equals("") && !employeeMaster.getOfficeEmailId().isEmpty()) {
                    msg = msg.replaceAll("\\{office_email_id\\}", employeeMaster.getOfficeEmailId());
                } else {
                    msg = msg.replaceAll("\\{office_email_id\\}", "");
                }
                if (employeeMaster.getChild1() != null && !employeeMaster.getChild1().equals("") && !employeeMaster.getChild1().isEmpty()) {
                    msg = msg.replaceAll("\\{child1\\}", employeeMaster.getChild1());
                } else {
                    msg = msg.replaceAll("\\{child1\\}", "");
                }
                if (employeeMaster.getChild2() != null && !employeeMaster.getChild2().equals("") && !employeeMaster.getChild2().isEmpty()) {
                    msg = msg.replaceAll("\\{child2\\}", employeeMaster.getChild2());
                } else {
                    msg = msg.replaceAll("\\{child2\\}", "");
                }
                if (employeeMaster.getHighestEducationDetails() != null && !employeeMaster.getHighestEducationDetails().equals("") && !employeeMaster.getHighestEducationDetails().isEmpty()) {
                    msg = msg.replaceAll("\\{highest_education_details\\}", employeeMaster.getHighestEducationDetails());
                } else {
                    msg = msg.replaceAll("\\{highest_education_details\\}", "");
                }
                if (employeeMaster.getExperienceYearOnDoj() != null && !employeeMaster.getExperienceYearOnDoj().equals("") && !employeeMaster.getExperienceYearOnDoj().isEmpty()) {
                    msg = msg.replaceAll("\\{experience_year_on_doj\\}", employeeMaster.getExperienceYearOnDoj());
                } else {
                    msg = msg.replaceAll("\\{experience_year_on_doj\\}", "");
                }
                if (employeeMaster.getPermanentAddress() != null && !employeeMaster.getPermanentAddress().equals("") && !employeeMaster.getPermanentAddress().isEmpty()) {
                    msg = msg.replaceAll("\\{permanent_address\\}", employeeMaster.getPermanentAddress());
                } else {
                    msg = msg.replaceAll("\\{permanent_address\\}", "");
                }
                if (employeeMaster.getPresentAddress() != null && !employeeMaster.getPresentAddress().equals("") && !employeeMaster.getPresentAddress().isEmpty()) {
                    msg = msg.replaceAll("\\{present_address\\}", employeeMaster.getPresentAddress());
                } else {
                    msg = msg.replaceAll("\\{present_address\\}", "");
                }
                if (employeeMaster.getAdharCard() != null && !employeeMaster.getAdharCard().equals("") && !employeeMaster.getAdharCard().isEmpty()) {
                    msg = msg.replaceAll("\\{adhar_card\\}", employeeMaster.getAdharCard());
                } else {
                    msg = msg.replaceAll("\\{adhar_card\\}", "");
                }
                if (employeeMaster.getDrivingLicence() != null && !employeeMaster.getDrivingLicence().equals("") && !employeeMaster.getDrivingLicence().isEmpty()) {
                    msg = msg.replaceAll("\\{driving_licence\\}", employeeMaster.getDrivingLicence());
                } else {
                    msg = msg.replaceAll("\\{driving_licence\\}", "");
                }
                if (employeeMaster.getBloodGroups() != null && !employeeMaster.getBloodGroups().equals("") && !employeeMaster.getBloodGroups().isEmpty()) {
                    msg = msg.replaceAll("\\{blood_groups\\}", employeeMaster.getBloodGroups());
                } else {
                    msg = msg.replaceAll("\\{blood_groups\\}", "");
                }
                if (employeeMaster.getMaritalStatus() != null && !employeeMaster.getMaritalStatus().equals("") && !employeeMaster.getMaritalStatus().isEmpty()) {
                    msg = msg.replaceAll("\\{marital_status\\}", employeeMaster.getMaritalStatus());
                } else {
                    msg = msg.replaceAll("\\{marital_status\\}", "");
                }
                if (employeeMaster.getExperienceMonthOnDoj() != null && !employeeMaster.getExperienceMonthOnDoj().equals("") && !employeeMaster.getExperienceMonthOnDoj().isEmpty()) {
                    msg = msg.replaceAll("\\{experience_month_on_doj\\}", employeeMaster.getExperienceMonthOnDoj());
                } else {
                    msg = msg.replaceAll("\\{experience_month_on_doj\\}", "");
                }
                if (employeeMaster.getBankName() != null && !employeeMaster.getBankName().equals("") && !employeeMaster.getBankName().isEmpty()) {
                    msg = msg.replaceAll("\\{bank_name\\}", employeeMaster.getBankName());
                } else {
                    msg = msg.replaceAll("\\{bank_name\\}", "");
                }
                if (employeeMaster.getBankAccountNo() != null && !employeeMaster.getBankAccountNo().equals("") && !employeeMaster.getBankAccountNo().isEmpty()) {
                    msg = msg.replaceAll("\\{bank_account_no\\}", employeeMaster.getBankAccountNo());
                } else {
                    msg = msg.replaceAll("\\{bank_account_no\\}", "");
                }
                if (employeeMaster.getBankIfscCode() != null && !employeeMaster.getBankIfscCode().equals("") && !employeeMaster.getBankIfscCode().isEmpty()) {
                    msg = msg.replaceAll("\\{bank_ifsc_code\\}", employeeMaster.getBankIfscCode());
                } else {
                    msg = msg.replaceAll("\\{bank_ifsc_code\\}", "");
                }
                if (employeeMaster.getCityOfEmployee() != null && !employeeMaster.getCityOfEmployee().equals("") && !employeeMaster.getCityOfEmployee().isEmpty()) {
                    msg = msg.replaceAll("\\{city_of_employee\\}", employeeMaster.getCityOfEmployee());
                } else {
                    msg = msg.replaceAll("\\{city_of_employee\\}", "");
                }
                if (employeeMaster.getDateOfBirthOfEmpFather() != null && !employeeMaster.getDateOfBirthOfEmpFather().equals("") && !employeeMaster.getDateOfBirthOfEmpFather().isEmpty()) {
                    msg = msg.replaceAll("\\{date_of_birth_of_emp_father\\}", employeeMaster.getDateOfBirthOfEmpFather());
                } else {
                    msg = msg.replaceAll("\\{date_of_birth_of_emp_father\\}", "");
                }
                if (employeeMaster.getDateOfBirthOfEmpMother() != null && !employeeMaster.getDateOfBirthOfEmpMother().equals("") && !employeeMaster.getDateOfBirthOfEmpMother().isEmpty()) {
                    msg = msg.replaceAll("\\{date_of_birth_of_emp_mother\\}", employeeMaster.getDateOfBirthOfEmpMother());
                } else {
                    msg = msg.replaceAll("\\{date_of_birth_of_emp_mother\\}", "");
                }
                if (employeeMaster.getDateOfBirthOfEmpSpous() != null && !employeeMaster.getDateOfBirthOfEmpSpous().equals("") && !employeeMaster.getDateOfBirthOfEmpSpous().isEmpty()) {
                    msg = msg.replaceAll("\\{date_of_birth_of_emp_spous\\}", employeeMaster.getDateOfBirthOfEmpSpous());
                } else {
                    msg = msg.replaceAll("\\{date_of_birth_of_emp_spous\\}", "");
                }
                if (employeeMaster.getDateOfBirthOfEmpChilld1() != null && !employeeMaster.getDateOfBirthOfEmpChilld1().equals("") && !employeeMaster.getDateOfBirthOfEmpChilld1().isEmpty()) {
                    msg = msg.replaceAll("\\{date_of_birth_of_emp_chilld1\\}", employeeMaster.getDateOfBirthOfEmpChilld1());
                } else {
                    msg = msg.replaceAll("\\{date_of_birth_of_emp_chilld1\\}", "");
                }
                if (employeeMaster.getDateOfBirthOfEmpChild2() != null && !employeeMaster.getDateOfBirthOfEmpChild2().equals("") && !employeeMaster.getDateOfBirthOfEmpChild2().isEmpty()) {
                    msg = msg.replaceAll("\\{date_of_birth_of_emp_child2\\}", employeeMaster.getDateOfBirthOfEmpChild2());
                } else {
                    msg = msg.replaceAll("\\{date_of_birth_of_emp_child2\\}", "");
                }
                if (employeeMaster.getPaymentType() != null && !employeeMaster.getPaymentType().equals("") && !employeeMaster.getPaymentType().isEmpty()) {
                    msg = msg.replaceAll("\\{payment_type\\}", employeeMaster.getPaymentType());
                } else {
                    msg = msg.replaceAll("\\{payment_type\\}", "");
                }
                if (employeeMaster.getPfNo() != null && !employeeMaster.getPfNo().equals("")
                        && !employeeMaster.getPfNo().isEmpty()) {
                    msg = msg.replaceAll("\\{pf_no\\}", employeeMaster.getPfNo());
                } else {
                    msg = msg.replaceAll("\\{pf_no\\}", "");
                }
                if (employeeMaster.getUanNo() != null && !employeeMaster.getUanNo().equals("") && !employeeMaster.getUanNo().isEmpty()) {
                    msg = msg.replaceAll("\\{uan_no\\}", employeeMaster.getUanNo());
                } else {
                    msg = msg.replaceAll("\\{uan_no\\}", "");
                }
                if (employeeMaster.getBasicSalary() != null && !employeeMaster.getBasicSalary().equals("") && !employeeMaster.getBasicSalary().isEmpty()) {
                    msg = msg.replaceAll("\\{basic_salary\\}", employeeMaster.getBasicSalary());
                } else {
                    msg = msg.replaceAll("\\{basic_salary\\}", "");
                }
                if (employeeMaster.getEsicNo() != null && !employeeMaster.getEsicNo().equals("") && !employeeMaster.getEsicNo().isEmpty()) {
                    msg = msg.replaceAll("\\{esic_no\\}", employeeMaster.getEsicNo());
                } else {
                    msg = msg.replaceAll("\\{esic_no\\}", "");
                }
                if (employeeTypeMaster.getTypeOfEmployee() != null && !employeeTypeMaster.getTypeOfEmployee().equals("") && !employeeTypeMaster.getTypeOfEmployee().isEmpty()) {
                    msg = msg.replaceAll("\\{type_of_employee\\}", employeeTypeMaster.getTypeOfEmployee());
                } else {
                    msg = msg.replaceAll("\\{type_of_employee\\}", "");
                }
                if (employeeSubType.getSubType() != null && !employeeSubType.getSubType().equals("") && !employeeSubType.getSubType().isEmpty()) {
                    msg = msg.replaceAll("\\{employee_sub_type\\}", employeeSubType.getSubType());
                } else {
                    msg = msg.replaceAll("\\{employee_sub_type\\}", "");
                }
                if (employeeMaster.getPfAmount() != null && !employeeMaster.getPfAmount().equals("") && !employeeMaster.getPfAmount().isEmpty()) {
                    msg = msg.replaceAll("\\{pf_amount\\}", employeeMaster.getPfAmount());
                } else {
                    msg = msg.replaceAll("\\{pf_amount\\}", "");
                }
                if (employeeMaster.getConfirmationDate() != null && !employeeMaster.getConfirmationDate().equals("") && !employeeMaster.getConfirmationDate().isEmpty()) {
                    msg = msg.replaceAll("\\{confirmation_date\\}", employeeMaster.getConfirmationDate());
                } else {
                    msg = msg.replaceAll("\\{confirmation_date\\}", "");
                }
                if (employeeMaster.getPfAmountEmployer() != null && !employeeMaster.getPfAmountEmployer().equals("") && !employeeMaster.getPfAmountEmployer().isEmpty()) {
                    msg = msg.replaceAll("\\{pf_amount_employer\\}", employeeMaster.getPfAmountEmployer());
                } else {
                    msg = msg.replaceAll("\\{pf_amount_employer\\}", "");
                }
                if (employeeMaster.getEmployeeLocation() != null && !employeeMaster.getEmployeeLocation().equals("") && !employeeMaster.getEmployeeLocation().isEmpty()) {
                    msg = msg.replaceAll("\\{employee_location\\}", employeeMaster.getEmployeeLocation());
                } else {
                    msg = msg.replaceAll("\\{employee_location\\}", "");
                }
                if (employeeMaster.getGrossTotal() != null && !employeeMaster.getGrossTotal().equals("") && !employeeMaster.getGrossTotal().isNaN()) {
                    msg = msg.replaceAll("\\{gross_total\\}", employeeMaster.getGrossTotal().toString());
                } else {
                    msg = msg.replaceAll("\\{gross_total\\}", "");
                }
                if (employeeMaster.getCtcTotal() != null && !employeeMaster.getCtcTotal().equals("") && !employeeMaster.getCtcTotal().isNaN()) {
                    msg = msg.replaceAll("\\{ctc_total\\}", employeeMaster.getCtcTotal().toString());
                } else {
                    msg = msg.replaceAll("\\{ctc_total\\}", "");
                }
                if (employeeMaster.getSalaryBase().TRUE) {
                    msg = msg.replaceAll("\\{salary_detail\\}", employeeMaster.getSalaryBase().toString());
                } else {
                    msg = msg.replaceAll("\\{salary_detail\\}", "");
                }

            } catch (Exception e) {
            }
//            String path = getpdf1(msg, employeeMaster.getEmployeeName(), certificateTemplate.getCertificateTitle());
//            request.setAttribute("path", path);
            request.setAttribute("msg", msg);
            request.setAttribute("employeeName", employeeMaster.getEmployeeName());
            request.setAttribute("certificateTemplateType", certificateTemplate.getCertificateTitle());
        }
        mv.setViewName("Payroll/CertificateAjax");
        return mv;
    }

}
