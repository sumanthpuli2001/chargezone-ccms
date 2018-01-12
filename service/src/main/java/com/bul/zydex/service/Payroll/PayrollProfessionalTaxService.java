/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Payroll;

import com.bul.zydex.model.PayrollProfessionalTax;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author AJAY <ajay@bulwarks.com>
 */
public interface PayrollProfessionalTaxService<T> extends GenericsService<T> {

    public boolean isExist(PayrollProfessionalTax payrollProfessionalTax);

    public List<?> readPT(double netSalary);

    public List<?> readAmount(String basicSalary);
}
