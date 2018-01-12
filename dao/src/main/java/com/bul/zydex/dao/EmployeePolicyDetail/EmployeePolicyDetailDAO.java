/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.EmployeePolicyDetail;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.EmployeeMaster;
import java.util.List;

/**
 *
 * @author OptiPlex
 */
public interface EmployeePolicyDetailDAO<T> extends GenericsDAO<T> {

    public List<?> readPolicy(int employeeid);

    public List<?> readEmployeeForPolicy(EmployeeMaster object);

    public List<?> readPolicyAName(int policyid);

    public List<?> fetchPolicyData(int empId);

    public List<?> readPolicyId(int empId);

    public List<?> readBypolicyAmount(int empId);

}
