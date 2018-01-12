/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Payroll;

import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Irfan <irfanbhindawala@gmail.com>
 */
public interface PayrollSavingAmountService<T> extends GenericsService<T>{
      public List<?> readCheckEmployeeSaving(int empId, int yearid);
}
