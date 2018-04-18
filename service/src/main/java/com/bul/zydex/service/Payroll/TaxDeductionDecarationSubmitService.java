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
 * @author Hussain
 */
public interface TaxDeductionDecarationSubmitService<T> extends GenericsService<T> {

    public List<?> readTaxDeductionDecarationSubmit(int taxSavingSubmitID);

    public List<?> readTaxDeductionDecarationSubmitAmount(int taxSavingSubmitID,int taxDeductionMaster,int taxDeductioncomponent);
}
