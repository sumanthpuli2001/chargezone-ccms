/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Payroll;

import com.bul.zydex.model.TaxDeductionDecarationSubmit;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Hussain
 */
public interface TaxDeductionDecarationSubmitService<T> extends GenericsService<T> {

    public List readComponentByTaxSavingSubmitId(Integer taxSavingSubmitId, Integer tdmId);

    public List<?> readSectionByDeclarationId(Integer taxSavingSubmitId);
    
    public List<?> readSectionBySubmitSectionId(Integer tddsId);

    public List<?> readSectionByDeclarationId(Integer tssId, Integer tdmId, Integer tdcId);

    public List<?> readPendingByEmployeeId(int empid);
    
    public List<?> readApproveByTaxSavingId(int empid);
    
}
