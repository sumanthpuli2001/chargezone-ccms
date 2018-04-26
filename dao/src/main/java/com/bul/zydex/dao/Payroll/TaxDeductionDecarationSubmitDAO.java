/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Payroll;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.TaxDeductionDecarationSubmit;
import java.util.List;

/**
 *
 * @author Hussain
 */
public interface TaxDeductionDecarationSubmitDAO<T> extends GenericsDAO<T> {

    public List<?> readForStatusOne();
    
    public List readComponentByTaxSavingSubmitId(Integer taxSavingSubmitId,  Integer tdmId);

    public List<?> readSectionByDeclarationId(Integer tssId, Integer tdmId, Integer tdcId);
    
    public List<?> readSectionBySubmitSectionId(Integer tddsId);

    public List<?> readPendingByEmployeeId(int empid);
    
    public List<?> readApproveByTaxSavingId(int savingid);
    
}
