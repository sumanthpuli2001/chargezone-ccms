/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Payroll;

import com.bul.zydex.model.PayrollPtCheck;
import com.bul.zydex.service.GenericsService;

/**
 *
 * @author Irfan <irfanbhindawala@gmail.com>
 */
public interface PayrollPtCheckService<T> extends GenericsService<T> {

    public boolean isExist(PayrollPtCheck payrollPtCheck);

    public boolean readForPTCheck(int empTypeId, int empSubTypeId);

    public boolean isExistPT(int empTypeId, int empSubTypeId);

    public int getPTId(int empTypeId, int empSubTypeId);

    public Boolean getPTCheckValue(int empTypeId, int empSubTypeId);

}
