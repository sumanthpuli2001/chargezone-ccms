/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Payroll;

import com.bul.zydex.dao.Payroll.TaxDeductionDecarationSubmitDAO;
import com.bul.zydex.service.GenericsServiceImpl;

/**
 *
 * @author Hussain
 */
public class TaxDeductionDecarationSubmitServiceImpl<T> extends GenericsServiceImpl<T> implements TaxDeductionDecarationSubmitService<T> {

    private TaxDeductionDecarationSubmitDAO<T> taxDeductionDecarationSubmitDAO;

    public TaxDeductionDecarationSubmitDAO<T> getTaxDeductionDecarationSubmitDAO() {
        return taxDeductionDecarationSubmitDAO;
    }

    public void setTaxDeductionDecarationSubmitDAO(TaxDeductionDecarationSubmitDAO<T> taxDeductionDecarationSubmitDAO) {
        this.taxDeductionDecarationSubmitDAO = taxDeductionDecarationSubmitDAO;
        setGenericsDAO(taxDeductionDecarationSubmitDAO);
    }
    
}
