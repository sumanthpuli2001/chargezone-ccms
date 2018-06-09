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
import com.google.gson.Gson;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

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
                
                msg = msg.replaceAll("\\{designation_name\\}", designationMaster.getDesignationName());
                msg = msg.replaceAll("\\{role\\}", employeeMaster.getRole());
                msg = msg.replaceAll("\\{location\\}", locationMaster.getLocation());
                msg = msg.replaceAll("\\{work_location\\}", zydexLocationMaster.getZydexLocation());
                msg = msg.replaceAll("\\{company\\}", employeeMaster.getCompany());
                msg = msg.replaceAll("\\{date_of_birth\\}", employeeMaster.getDateOfBirth());
                msg = msg.replaceAll("\\{email_address\\}", employeeMaster.getEmailAddress());
                msg = msg.replaceAll("\\{contact_no1\\}", employeeMaster.getContactNo1());
                msg = msg.replaceAll("\\{contact_no2\\}", employeeMaster.getContactNo2());
                msg = msg.replaceAll("\\{father_name\\}", employeeMaster.getFatherName());
                msg = msg.replaceAll("\\{mother_name\\}", employeeMaster.getMotherName());
                msg = msg.replaceAll("\\{marital_status\\}", employeeMaster.getMaritalStatus());
                msg = msg.replaceAll("\\{spouse_name\\}", employeeMaster.getSpouseName());
                msg = msg.replaceAll("\\{emergency_contact_person\\}", employeeMaster.getEmergencyContactPerson());
                msg = msg.replaceAll("\\{emergency_contact_no\\}", employeeMaster.getEmergencyContactNo());
                msg = msg.replaceAll("\\{pan_card\\}", employeeMaster.getPanCard());
                msg = msg.replaceAll("\\{passport_no\\}", employeeMaster.getPassportNo());
                msg = msg.replaceAll("\\{passport_issue_date\\}", employeeMaster.getPassportIssueDate());
                msg = msg.replaceAll("\\{passport_expiry_date\\}", employeeMaster.getPassportExpiryDate());
                msg = msg.replaceAll("\\{date_of_leaving\\}", employeeMaster.getDateOfLeaving());
                msg = msg.replaceAll("\\{reason_for_leaving\\}", employeeMaster.getReasonForLeaving());
                msg = msg.replaceAll("\\{employee_type\\}", employeeMaster.getEmployeeType());
                msg = msg.replaceAll("\\{reporting_manager_level1\\}", employeeMaster1.getEmployeeName());
                msg = msg.replaceAll("\\{reporting_manager_level2\\}", employeeMaster2.getEmployeeName());
                msg = msg.replaceAll("\\{reporting_manager_level3\\}", employeeMaster3.getEmployeeName());
                msg = msg.replaceAll("\\{reporting_manager_level4\\}", employeeMaster4.getEmployeeName());
                msg = msg.replaceAll("\\{reporting_manager_level5\\}", employeeMaster5.getEmployeeName());
                msg = msg.replaceAll("\\{reporting_manager_level6\\}", employeeMaster6.getEmployeeName());
                msg = msg.replaceAll("\\{shift_type\\}", employeeMaster.getShiftType());
                msg = msg.replaceAll("\\{office_email_id\\}", employeeMaster.getOfficeEmailId());
                msg = msg.replaceAll("\\{child1\\}", employeeMaster.getChild1());
                msg = msg.replaceAll("\\{child2\\}", employeeMaster.getChild2());
                msg = msg.replaceAll("\\{highest_education_details\\}", employeeMaster.getHighestEducationDetails());
                msg = msg.replaceAll("\\{experience_year_on_doj\\}", employeeMaster.getExperienceYearOnDoj());
                msg = msg.replaceAll("\\{permanent_address\\}", employeeMaster.getPermanentAddress());
                msg = msg.replaceAll("\\{present_address\\}", employeeMaster.getPresentAddress());
                msg = msg.replaceAll("\\{adhar_card\\}", employeeMaster.getAdharCard());
                msg = msg.replaceAll("\\{driving_licence\\}", employeeMaster.getDrivingLicence());
                msg = msg.replaceAll("\\{blood_groups\\}", employeeMaster.getBloodGroups());
                msg = msg.replaceAll("\\{marital_status\\}", employeeMaster.getMaritalStatus());
                msg = msg.replaceAll("\\{experience_month_on_doj\\}", employeeMaster.getExperienceMonthOnDoj());
                msg = msg.replaceAll("\\{bank_name\\}", employeeMaster.getBankName());
                msg = msg.replaceAll("\\{bank_account_no\\}", employeeMaster.getBankAccountNo());
                msg = msg.replaceAll("\\{bank_ifsc_code\\}", employeeMaster.getBankIfscCode());
                msg = msg.replaceAll("\\{city_of_employee\\}", employeeMaster.getCityOfEmployee());
                msg = msg.replaceAll("\\{date_of_birth_of_emp_father\\}", employeeMaster.getDateOfBirthOfEmpFather());
                msg = msg.replaceAll("\\{date_of_birth_of_emp_mother\\}", employeeMaster.getDateOfBirthOfEmpMother());
                msg = msg.replaceAll("\\{date_of_birth_of_emp_spous\\}", employeeMaster.getDateOfBirthOfEmpSpous());
                msg = msg.replaceAll("\\{date_of_birth_of_emp_chilld1\\}", employeeMaster.getDateOfBirthOfEmpChilld1());
                msg = msg.replaceAll("\\{date_of_birth_of_emp_child2\\}", employeeMaster.getDateOfBirthOfEmpChild2());
                msg = msg.replaceAll("\\{payment_type\\}", employeeMaster.getPaymentType());
                if (employeeMaster.getPfNo() != null && !employeeMaster.getPfNo().equals("")
                        && !employeeMaster.getPfNo().isEmpty()) {
                    msg = msg.replaceAll("\\{pf_no\\}", employeeMaster.getPfNo());
                } else {
                    msg = msg.replaceAll("\\{pf_no\\}", "");
                }
                msg = msg.replaceAll("\\{uan_no\\}", employeeMaster.getUanNo());
                msg = msg.replaceAll("\\{basic_salary\\}", employeeMaster.getBasicSalary());
                msg = msg.replaceAll("\\{esic_no\\}", employeeMaster.getEsicNo());
                msg = msg.replaceAll("\\{type_of_employee\\}", employeeTypeMaster.getTypeOfEmployee());
                msg = msg.replaceAll("\\{employee_sub_type\\}", employeeSubType.getSubType());
                msg = msg.replaceAll("\\{pf_amount\\}", employeeMaster.getPfAmount());
                msg = msg.replaceAll("\\{confirmation_date\\}", employeeMaster.getConfirmationDate());
                msg = msg.replaceAll("\\{pf_amount_employer\\}", employeeMaster.getPfAmountEmployer());
                msg = msg.replaceAll("\\{employee_location\\}", employeeMaster.getEmployeeLocation());
                if (employeeMaster.getGrossTotal() != null && !employeeMaster.getGrossTotal().equals("") && !employeeMaster.getGrossTotal().isNaN()) {
                    msg = msg.replaceAll("\\{gross_total\\}", employeeMaster.getGrossTotal().toString());
                } else {
                    msg = msg.replaceAll("\\{gross_total\\}", "");
                }
                msg = msg.replaceAll("\\{ctc_total\\}", employeeMaster.getCtcTotal().toString());
                msg = msg.replaceAll("\\{salary_detail\\}", employeeMaster.getSalaryBase().toString());

            } catch (Exception e) {
            }
            request.setAttribute("msg", msg);
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
}
