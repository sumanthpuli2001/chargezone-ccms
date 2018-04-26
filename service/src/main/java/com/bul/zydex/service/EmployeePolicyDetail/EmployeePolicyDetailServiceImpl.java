/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.EmployeePolicyDetail;

import com.bul.zydex.dao.EmployeePolicyDetail.EmployeePolicyDetailDAO;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author OptiPlex
 */
public class EmployeePolicyDetailServiceImpl<T> extends GenericsServiceImpl<T> implements EmployeePolicyDetailService<T> {

    private EmployeePolicyDetailDAO<T> employeePolicyDetailDAO;

    public EmployeePolicyDetailDAO<T> getEmployeePolicyDetailDAO() {
        return employeePolicyDetailDAO;
    }

    public void setEmployeePolicyDetailDAO(EmployeePolicyDetailDAO<T> employeePolicyDetailDAO) {
        this.employeePolicyDetailDAO = employeePolicyDetailDAO;
        setGenericsDAO(employeePolicyDetailDAO);
    }

    @Override
    public List<?> readPolicy(int employeeid) {
        return employeePolicyDetailDAO.readPolicy(employeeid);
    }

    @Override
    public List<?> readEmployeeForPolicy(EmployeeMaster object) {
        return employeePolicyDetailDAO.readEmployeeForPolicy(object);
    }

    @Override
    public List<?> readPolicyAName(int policyid) {
        return employeePolicyDetailDAO.readPolicyAName(policyid);
    }

    @Override
    public List<?> fetchPolicyData(int empId) {
        return employeePolicyDetailDAO.fetchPolicyData(empId);
    }

    @Override
   public List<?> readPolicyId(int empId) {
        return employeePolicyDetailDAO.readPolicyId(empId);
    }

    @Override
    public List<?> readBypolicyAmount(int empId) {
       return employeePolicyDetailDAO.readBypolicyAmount(empId);
    }

    @Override
    public boolean readBypolicyAmountTaxableAmount(Integer empID, Integer salaryType) {
        return employeePolicyDetailDAO.readBypolicyAmountTaxableAmount(empID, salaryType);
    }

    @Override
    public List<?> readBypolicyAmountWithTaxable(int empId) {
         return employeePolicyDetailDAO.readBypolicyAmountWithTaxable(empId);
    }

  
    
}
