/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Payroll;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.CertificateTemplate;
import com.bul.zydex.model.EmployeeMaster;
import java.util.List;

/**
 *
 * @author Irfan <irfanbhindawala@gmail.com>
 */
public class CertificateTemplateDAOImpl<T> extends GenericsDAOImpl<T> implements CertificateTemplateDAO<T>{

    @Override
    protected Class getDomainClass() {
      return CertificateTemplate.class;
    }

    @Override
    public List<?> readEmployeeForSalary(EmployeeMaster object) {
         String query = "";
        String condition = "";
         EmployeeMaster employeeMaster = (EmployeeMaster) object;
        
        if (!"".equals(employeeMaster.getAdharCard()) && null != employeeMaster.getAdharCard()) {
            condition += " AND a.zydexLocationMaster.id = " + employeeMaster.getAdharCard();
        }
        if (!"".equals(employeeMaster.getEmployeeType()) && null != employeeMaster.getEmployeeType()) {
            condition += " AND a.employeeTypeMaster.id = " + employeeMaster.getEmployeeType();
        }
        if (!"".equals(employeeMaster.getCompany()) && null != employeeMaster.getCompany()) {
            condition += " AND a.employeeSubType.id = " + employeeMaster.getCompany();
        }
        if (!"".equals(employeeMaster.getPaymentType()) && null != employeeMaster.getPaymentType()) {
            condition += " AND a.paymentType = '" + employeeMaster.getPaymentType() + "'";
        }

        query += "Select a.employeeId, a.employeeName "
                + " From EmployeeMaster a "
                + " Where 1=1 " + condition;

        return getHibernateTemplate().find(query);
    }
    
}
