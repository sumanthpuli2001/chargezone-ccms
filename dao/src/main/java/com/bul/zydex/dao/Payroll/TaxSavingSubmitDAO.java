/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Payroll;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.EmployeeMaster;
import java.util.List;

/**
 *
 * @author Hussain
 */
public interface TaxSavingSubmitDAO<T> extends GenericsDAO<T> {

    public List<?> readTaxSavingSubmitForEmployee(EmployeeMaster employeeMaster);

    public List taxSubmitSearchIdCheck(T object);
    public List<?> readDataForSaving(int employeeId, int financialId);

}
