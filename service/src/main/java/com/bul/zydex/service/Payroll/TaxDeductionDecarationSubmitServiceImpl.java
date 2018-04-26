/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Payroll;

import com.bul.zydex.dao.Payroll.TaxDeductionDecarationSubmitDAO;
import com.bul.zydex.model.TaxDeductionDecarationSubmit;
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
    public List<?> readSectionBySubmitSectionId(Integer tddsId) {
        return taxDeductionDecarationSubmitDAO.readSectionBySubmitSectionId(tddsId);
    }

    @Override
    public List readComponentByTaxSavingSubmitId(Integer taxSavingSubmitId, Integer tdmId) {
        return taxDeductionDecarationSubmitDAO.readComponentByTaxSavingSubmitId(taxSavingSubmitId, tdmId);
    }

    @Override
    public List<?> readSectionByDeclarationId(Integer taxSavingSubmitId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<?> readSectionByDeclarationId(Integer tssId, Integer tdmId, Integer tdcId) {
        return taxDeductionDecarationSubmitDAO.readSectionByDeclarationId(tssId,tdmId,tdcId);
    }


    @Override
    public List<?> readPendingByEmployeeId(int eid) {
       return taxDeductionDecarationSubmitDAO.readPendingByEmployeeId(eid);
    }

    @Override
    public List<?> readApproveByTaxSavingId(int savingid) {
        return taxDeductionDecarationSubmitDAO.readApproveByTaxSavingId(savingid);
    }

    
}
