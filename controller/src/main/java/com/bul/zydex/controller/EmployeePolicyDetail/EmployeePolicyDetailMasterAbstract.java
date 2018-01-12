/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.EmployeePolicyDetail;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.EmployeePolicyDetail;
import com.bul.zydex.service.EmployeePolicyDetail.EmployeePolicyDetailService;

/**
 *
 * @author OptiPlex
 */
public abstract class EmployeePolicyDetailMasterAbstract extends CustomAbstract{
    
     protected EmployeePolicyDetailService<EmployeePolicyDetail> employeePolicyDetailService;
     
      public EmployeePolicyDetailService<EmployeePolicyDetail> getEmployeePolicyDetailService() {
        return employeePolicyDetailService;
    }

    public void setEmployeePolicyDetailService(EmployeePolicyDetailService<EmployeePolicyDetail> employeePolicyDetailService) {
        this.employeePolicyDetailService = employeePolicyDetailService;
    }
    
}
