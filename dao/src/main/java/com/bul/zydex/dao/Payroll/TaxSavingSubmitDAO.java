/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Payroll;

import com.bul.zydex.dao.GenericsDAO;
import java.util.List;

/**
 *
 * @author Hussain
 */
public interface TaxSavingSubmitDAO<T> extends GenericsDAO<T> {

    public boolean isExist(Integer empID, Integer finicailyear);

    public List<?> readTaxSavingSubmit(int EmplID, int finicailyear);

    public List<?> readTaxSavingSubmitSalaryGenerate(int EmplID, int finicailyear);

    public List<?> readTaxSavingSubmitSalaryGenerateAfterDate(int EmplID, int finicailyear);

}
