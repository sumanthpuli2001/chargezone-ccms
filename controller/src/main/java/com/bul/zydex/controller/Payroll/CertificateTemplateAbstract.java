/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.CertificateTemplate;
import com.bul.zydex.model.EmployeeSubType;
import com.bul.zydex.model.EmployeeTypeMaster;
import com.bul.zydex.service.Payroll.CertificateTemplateService;
import com.bul.zydex.service.emp.EmployeeSubTypeService;
import com.bul.zydex.service.emp.EmployeeTypeService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.validation.Validator;

/**
 *
 * @author Irfan <irfanbhindawala@gmail.com>
 */
public class CertificateTemplateAbstract extends CustomAbstract {
    protected CertificateTemplateService<CertificateTemplate> certificateTemplateService;
     protected EmployeeTypeService<EmployeeTypeMaster> employeeTypeService;
    protected EmployeeSubTypeService<EmployeeSubType> employeeSubTypeService;
    protected Validator certificateTemplateValidator;

    public EmployeeTypeService<EmployeeTypeMaster> getEmployeeTypeService() {
        return employeeTypeService;
    }

    public void setEmployeeTypeService(EmployeeTypeService<EmployeeTypeMaster> employeeTypeService) {
        this.employeeTypeService = employeeTypeService;
    }

    public EmployeeSubTypeService<EmployeeSubType> getEmployeeSubTypeService() {
        return employeeSubTypeService;
    }

    public void setEmployeeSubTypeService(EmployeeSubTypeService<EmployeeSubType> employeeSubTypeService) {
        this.employeeSubTypeService = employeeSubTypeService;
    }
    

    public CertificateTemplateService<CertificateTemplate> getCertificateTemplateService() {
        return certificateTemplateService;
    }

    public void setCertificateTemplateService(CertificateTemplateService<CertificateTemplate> certificateTemplateService) {
        this.certificateTemplateService = certificateTemplateService;
    }

    public Validator getCertificateTemplateValidator() {
        return certificateTemplateValidator;
    }

    public void setCertificateTemplateValidator(Validator certificateTemplateValidator) {
        this.certificateTemplateValidator = certificateTemplateValidator;
    }

    protected void EmployeeTypeList(HttpServletRequest request) {
        List<?> EmployeeTypeList = employeeTypeService.read();
        Map<Integer, String> map = new HashMap();
        for (Object obj : EmployeeTypeList) {
            EmployeeTypeMaster employeeTypeMaster = (EmployeeTypeMaster) obj;
            map.put(employeeTypeMaster.getId(), employeeTypeMaster.getTypeOfEmployee());
        }
        request.setAttribute("EmployeeTypeList", map);
    }
     
     protected void EmployeeSubTypeList(HttpServletRequest request) {
        List<?> EmployeeSubTypeList = employeeSubTypeService.read();
        Map<Integer, String> map = new HashMap();
        for (Object obj : EmployeeSubTypeList) {
            EmployeeSubType employeeSubType = (EmployeeSubType) obj;
            map.put(employeeSubType.getId(), employeeSubType.getSubType());
        }
        request.setAttribute("EmployeeSubTypeList", map);
    }
     
     protected void CertificateTypeList(HttpServletRequest request) {
        List<?> certificateList = certificateTemplateService.read();
        Map<Integer, String> map = new HashMap();
        for (Object obj : certificateList) {
            CertificateTemplate certificateTemplate = (CertificateTemplate) obj;
            map.put(certificateTemplate.getId(), certificateTemplate.getCertificateName());
        }
        request.setAttribute("certificateList", map);
    }
     
    
    
}
