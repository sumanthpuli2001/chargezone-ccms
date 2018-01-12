/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.model.CertificateTemplate;
import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.EmployeeSubType;
import com.bul.zydex.model.EmployeeType;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
        String id = request.getParameter("id");
        certificateTemplate = certificateTemplateService.readById(Integer.parseInt(id));
        certificateTemplate.setId(Integer.parseInt(id));
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

            employeeMaster = (EmployeeMaster) employeeMasterService.readByEmployeeNo(Integer.parseInt(id)).get(0);
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

            certificateTemplate = certificateTemplateService.readById(Integer.parseInt(certificateId));
            EmployeeMaster employeeMaster = employeeMasterService.readById(Integer.parseInt(empId));
            
        DesignationMaster designationMaster = designationMasterService.readById(employeeMaster.getDesignationMaster().getId());
        employeeMaster.setDesignationMaster(designationMaster);
            String msg = certificateTemplate.getCertificateBody();
            msg = msg.replace("{employee_name}", employeeMaster.getEmployeeName());
             msg = msg.replace("{company}", employeeMaster.getCompany());
             msg = msg.replace("{dateOfJoining}", employeeMaster.getDateOfJoining());
             msg = msg.replace("{dateOfLeaving}", employeeMaster.getDateOfLeaving());
             msg = msg.replace("{designationName}", employeeMaster.getDesignationMaster().getDesignationName());
            msg = msg.replace("{date}", new SimpleDateFormat("MM/dd/yyyy")
                    .format(new Date()));
            request.setAttribute("msg", msg);
        }
        mv.setViewName("Payroll/CertificateAjax");
        return mv;
    }
}
