/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Payroll;

import com.bul.zydex.dao.Payroll.TaxDeductionDeclarationSavingStatusDAO;
import com.bul.zydex.model.TaxDeductionDeclarationSavingStatus;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author DELL3
 */
public interface TaxDeductionDeclarationSavingStatusService<T> extends GenericsService<T> 
{

    public List<?> readByTDDSId(int parseInt);
    
}
