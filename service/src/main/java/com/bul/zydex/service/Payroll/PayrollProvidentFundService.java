/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Payroll;

import com.bul.zydex.model.PayrollProvidentFund;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author AJAY <ajay@bulwarks.com>
 */
public interface PayrollProvidentFundService<T> extends GenericsService<T>  {

   public List<?> readPf(int zydexLocationId);
    public boolean isExist(PayrollProvidentFund payrollProvidentFund);

}
