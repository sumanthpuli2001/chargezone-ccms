/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Payroll;

import com.bul.zydex.model.EmployeeTypeWiseSalary;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Irfan <irfanbhindawala@gmail.com>
 */
public interface EmployeeTypeWiseSalaryService<T> extends GenericsService<T>{
    
     public List<?> readForAdditionalAmount(int empTypeId, int empSubTypeId);
     public List<?> readForMasterAdditionalAmount(int empTypeId, int empSubTypeId,int payrollSalaryId);
      public boolean isExist(EmployeeTypeWiseSalary employeeTypeWiseSalary);
}
