/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Payroll;

import com.bul.zydex.dao.Payroll.PayrollStationWiseSavingTaxDAO;
import com.bul.zydex.model.PayrollStationWiseSavingTax;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.Iterator;
import java.util.List;


/**
 *
 * @author Nishant
 */
public class PayrollStationWiseSavingTaxServiceImpl<T>  extends GenericsServiceImpl<T> implements PayrollStationWiseSavingTaxService<T>{
     private PayrollStationWiseSavingTaxDAO<T> payrollStationWiseSavingTaxDAO;

    public PayrollStationWiseSavingTaxDAO<T> getPayrollStationWiseSavingTaxDAO() {
        return payrollStationWiseSavingTaxDAO;
    }

    public void setPayrollStationWiseSavingTaxDAO(PayrollStationWiseSavingTaxDAO<T> payrollStationWiseSavingTaxDAO) {
        this.payrollStationWiseSavingTaxDAO = payrollStationWiseSavingTaxDAO;
        setGenericsDAO(payrollStationWiseSavingTaxDAO);
    }

    @Override
    public boolean isExist(PayrollStationWiseSavingTax payrollStationWiseSavingTax) {
   boolean flag = false;
        List<?> list = payrollStationWiseSavingTaxDAO.read();
        Iterator i = list.iterator();
        while (i.hasNext()) {
            PayrollStationWiseSavingTax payrollStationWiseSavingTax1 = (PayrollStationWiseSavingTax) i.next();
            if (payrollStationWiseSavingTax1.getZydexLocationMaster().getId().intValue()
                    == payrollStationWiseSavingTax.getZydexLocationMaster().getId().intValue()) {

                flag = true;
                break;
            }

        }

        return flag;
    }
     
}
