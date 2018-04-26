/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Payroll;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.PayrollFinancialYear;
import java.util.List;

/**
 *
 * @author Irfan <irfanbhindawala@gmail.com>
 */
public interface PayrollFinancialYearDAO<T> extends GenericsDAO<T> {

    public List<?> readDayFinancialYear(int locationId, String month, String year);

}
