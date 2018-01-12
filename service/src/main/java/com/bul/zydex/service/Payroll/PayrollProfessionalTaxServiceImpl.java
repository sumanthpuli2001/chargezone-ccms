/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Payroll;

import com.bul.zydex.dao.Payroll.PayrollProfessionalTaxDAO;
import com.bul.zydex.model.PayrollProfessionalTax;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author AJAY <ajay@bulwarks.com>
 */
public class PayrollProfessionalTaxServiceImpl<T> extends GenericsServiceImpl<T> implements PayrollProfessionalTaxService<T> {

    private PayrollProfessionalTaxDAO<T> payrollProfessionalTaxDAO;

    public PayrollProfessionalTaxDAO<T> getPayrollProfessionalTaxDAO() {
        return payrollProfessionalTaxDAO;
    }

    public void setPayrollProfessionalTaxDAO(PayrollProfessionalTaxDAO<T> payrollProfessionalTaxDAO) {
        this.payrollProfessionalTaxDAO = payrollProfessionalTaxDAO;
        setGenericsDAO(payrollProfessionalTaxDAO);
    }

    @Override
    public boolean isExist(PayrollProfessionalTax payrollProfessionalTax) {
        PayrollProfessionalTax payrollProfessionalTax2 = (PayrollProfessionalTax) payrollProfessionalTax;

        List<?> list = payrollProfessionalTaxDAO.read();
        Iterator i = list.iterator();
        while (i.hasNext()) {
            payrollProfessionalTax = (PayrollProfessionalTax) i.next();
            if (payrollProfessionalTax.getSalaryFrom().toString().equals(payrollProfessionalTax2) && payrollProfessionalTax.getSalaryTo().toString().equals(payrollProfessionalTax2)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public List<?> readPT(double netSalary) {
        return payrollProfessionalTaxDAO.readPT(netSalary);
    }

    @Override
    public List<?> readAmount(String basicSalary) {
        return payrollProfessionalTaxDAO.readAmount(basicSalary);
    }

}
