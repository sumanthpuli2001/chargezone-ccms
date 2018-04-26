/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Payroll;

import com.bul.zydex.dao.Payroll.TaxDeductionDeclarationSavingStatusDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author DELL3
 */
public class TaxDeductionDeclarationSavingStatusServiceImpl<T> extends GenericsServiceImpl<T> implements TaxDeductionDeclarationSavingStatusService<T> 
{
    private TaxDeductionDeclarationSavingStatusDAO<T> taxDeductionDeclarationSavingStatusDAO;

    public TaxDeductionDeclarationSavingStatusDAO<T> getTaxDeductionDeclarationSavingStatusDAO() {
        return taxDeductionDeclarationSavingStatusDAO;
    }

    public void setTaxDeductionDeclarationSavingStatusDAO(TaxDeductionDeclarationSavingStatusDAO<T> taxDeductionDeclarationSavingStatusDAO) {
        this.taxDeductionDeclarationSavingStatusDAO = taxDeductionDeclarationSavingStatusDAO;
        setGenericsDAO(taxDeductionDeclarationSavingStatusDAO);
    }

    @Override
    public List<?> readByTDDSId(int tddsId) {
        return taxDeductionDeclarationSavingStatusDAO.readByTDDSId(tddsId);
    }
    
    
}
