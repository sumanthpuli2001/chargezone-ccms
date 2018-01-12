/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Payroll;

import com.bul.zydex.model.PayrollSavingType;
import com.bul.zydex.service.GenericsService;

/**
 *
 * @author Nishant
 */
public interface PayrollSavingTypeService<T> extends GenericsService<T> {

    public boolean isExist(PayrollSavingType payrollSavingType);

}
