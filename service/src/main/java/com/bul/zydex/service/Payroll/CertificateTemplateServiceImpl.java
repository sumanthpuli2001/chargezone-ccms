/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Payroll;

import com.bul.zydex.dao.Payroll.CertificateTemplateDAO;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Irfan <irfanbhindawala@gmail.com>
 */
public class CertificateTemplateServiceImpl<T> extends GenericsServiceImpl<T> implements CertificateTemplateService<T>{
      private CertificateTemplateDAO<T> certificateTemplateDAO;

    public CertificateTemplateDAO<T> getCertificateTemplateDAO() {
        return certificateTemplateDAO;
    }

    public void setCertificateTemplateDAO(CertificateTemplateDAO<T> certificateTemplateDAO) {
        this.certificateTemplateDAO = certificateTemplateDAO;
        setGenericsDAO(certificateTemplateDAO);
    }

    @Override
    public List<?> readEmployeeForSalary(EmployeeMaster object) {
        return certificateTemplateDAO.readEmployeeForSalary(object);
    }
      
}
