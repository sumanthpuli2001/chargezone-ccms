/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Payroll;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.PayrollTaxRateMaster;
import java.util.List;

/**
 *
 * @author DELL3
 */
public interface PayrollTaxRateMasterDao<T> extends GenericsDAO<T> {

    public List<?> getAgeValues(Integer ageF, Integer ageT, Integer incomeF, Integer incomeT);

  

    public List<?> getAgeValuesFOrSalaryGenerate(Integer ageF);
}
