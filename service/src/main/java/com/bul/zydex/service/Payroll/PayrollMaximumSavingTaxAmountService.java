/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Payroll;

import com.bul.zydex.model.PayrollMaximumSavingTaxAmount;
import com.bul.zydex.service.GenericsService;

/**
 *
 * @author AJAY <ajay@bulwarks.com>
 */
public interface PayrollMaximumSavingTaxAmountService<T> extends GenericsService<T> {

    public boolean isExist(PayrollMaximumSavingTaxAmount payrollMaximumSavingTaxAmount);

}
