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
 * @author DELL3
 */
public interface PayrollTaxDeclarationPeriodMasterService<T> extends GenericsService<T> {

    public List<?> readDeclarationPeriod();

    public List<?> readPayrollTaxDeclarationPeriodMaster(int finicialYearID, String month, String year);

    public List<?> readPayrollTaxDeclarationPeriodMasterBefore(int finicialYearID, String month, String year);

    public List<?> readPayrollTaxDeclarationPeriodMasterAfterProofDate(int finicialYearID, String month, String year);

}
