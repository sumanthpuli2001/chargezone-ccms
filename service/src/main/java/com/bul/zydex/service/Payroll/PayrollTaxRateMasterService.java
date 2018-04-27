/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Payroll;

import com.bul.zydex.dao.Payroll.PayrollTaxRateMasterDao;
import com.bul.zydex.model.PayrollTaxRateMaster;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author DELL3
 */
public interface PayrollTaxRateMasterService<T> extends GenericsService<T> {

    public List<?> getAgeValues(Integer ageF, Integer ageT, Integer incomeF, Integer incomeT);

  

    public List<?> getAgeValuesFOrSalaryGenerate(Integer ageF);

}
