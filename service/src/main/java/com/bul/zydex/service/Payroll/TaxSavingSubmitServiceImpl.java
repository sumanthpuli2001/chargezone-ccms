/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Payroll;

import com.bul.zydex.dao.Payroll.TaxSavingSubmitDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Hussain
 */
public class TaxSavingSubmitServiceImpl<T> extends GenericsServiceImpl<T> implements TaxSavingSubmitService<T> {

    private TaxSavingSubmitDAO<T> taxSavingSubmitDAO;

    public TaxSavingSubmitDAO<T> getTaxSavingSubmitDAO() {
        return taxSavingSubmitDAO;
    }

    public void setTaxSavingSubmitDAO(TaxSavingSubmitDAO<T> taxSavingSubmitDAO) {
        this.taxSavingSubmitDAO = taxSavingSubmitDAO;
        setGenericsDAO(taxSavingSubmitDAO);
    }

    @Override
    public boolean isExist(Integer empID, Integer finicailyear) {
        return taxSavingSubmitDAO.isExist(empID, finicailyear);
    }

    @Override
    public List<?> readTaxSavingSubmit(int EmplID, int finicailyear) {
      return taxSavingSubmitDAO.readTaxSavingSubmit(EmplID, finicailyear);
    }

    @Override
    public List<?> readTaxSavingSubmitSalaryGenerate(int EmplID, int finicailyear) {
       return taxSavingSubmitDAO.readTaxSavingSubmitSalaryGenerate(EmplID, finicailyear);
    }

    @Override
    public List<?> readTaxSavingSubmitSalaryGenerateAfterDate(int EmplID, int finicailyear) {
        return taxSavingSubmitDAO.readTaxSavingSubmitSalaryGenerateAfterDate(EmplID, finicailyear);
    }
    
}
