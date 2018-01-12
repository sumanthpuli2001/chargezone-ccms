/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Payroll;

import com.bul.zydex.model.PayrollPfCheck;
import com.bul.zydex.service.GenericsService;

/**
 *
 * @author Nishant
 */
public interface PayrollPfCheckService<T> extends GenericsService<T> {

    public boolean isExist(PayrollPfCheck payrollPfCheck);

    public boolean readForPfCheck(int empTypeId, int empSubTypeId);

    public boolean isExistPF(int empTypeId, int empSubTypeId);

    public int getPFId(int empTypeId, int empSubTypeId);

    public Boolean getPFCheckValue(int empTypeId, int empSubTypeId);

}
