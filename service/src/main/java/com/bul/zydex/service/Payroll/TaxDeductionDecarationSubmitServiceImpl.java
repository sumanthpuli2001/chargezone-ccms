/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Payroll;

import com.bul.zydex.dao.Payroll.TaxDeductionDecarationSubmitDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

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

    @Override
    public List<?> readTaxDeductionDecarationSubmit(int taxSavingSubmitID) {
        return taxDeductionDecarationSubmitDAO.readTaxDeductionDecarationSubmit(taxSavingSubmitID);
    }

    @Override
    public List<?> readTaxDeductionDecarationSubmitAmount(int taxSavingSubmitID, int taxDeductionMaster, int taxDeductioncomponent) {
        return taxDeductionDecarationSubmitDAO.readTaxDeductionDecarationSubmitAmount(taxSavingSubmitID, taxDeductionMaster, taxDeductioncomponent);
    }

    @Override
    public List<?> readByTaxDeductionDecarationDelete(int taxSavingSubmit) {
        return taxDeductionDecarationSubmitDAO.readByTaxDeductionDecarationDelete(taxSavingSubmit);
    }

    @Override
    public List<?> readByTaxDeductionDecarationFetchRead(int taxSavingSubmit, int taxDeductionMaster, int taxDeductioncomponent) {
        return taxDeductionDecarationSubmitDAO.readByTaxDeductionDecarationFetchRead(taxSavingSubmit, taxDeductionMaster, taxDeductioncomponent);
    }

    @Override
    public List<?> readTaxDeductionDecarationSubmitSalaryGenerate(int taxSavingSubmitID) {
        return taxDeductionDecarationSubmitDAO.readTaxDeductionDecarationSubmitSalaryGenerate(taxSavingSubmitID);
    }

    @Override
    public List<?> readTaxDeductionDecarationSubmitSalaryGenerateAfterDate(int taxSavingSubmitID) {
        return taxDeductionDecarationSubmitDAO.readTaxDeductionDecarationSubmitSalaryGenerateAfterDate(taxSavingSubmitID);
    }

    @Override
    public List<?> readTaxDeductionDecarationSubmitSalaryGenerateTaxSavingLimit(int taxSavingSubmitID) {
     return taxDeductionDecarationSubmitDAO.readTaxDeductionDecarationSubmitSalaryGenerateTaxSavingLimit(taxSavingSubmitID);
    }

}
