/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Payroll;

import com.bul.zydex.dao.Payroll.PayrollProvidentFundDAO;
import com.bul.zydex.model.PayrollProvidentFund;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author AJAY <ajay@bulwarks.com>
 */
public class PayrollProvidentFundServiceImpl<T> extends GenericsServiceImpl<T> implements PayrollProvidentFundService<T> {

    private PayrollProvidentFundDAO<T> payrollProvidentFundDAO;

    public PayrollProvidentFundDAO<T> getPayrollProvidentFundDAO() {
        return payrollProvidentFundDAO;
    }

    public void setPayrollProvidentFundDAO(PayrollProvidentFundDAO<T> payrollProvidentFundDAO) {
        this.payrollProvidentFundDAO = payrollProvidentFundDAO;
        setGenericsDAO(payrollProvidentFundDAO);
    }

    @Override
    public List<?> readPf(int zydexLocationId) {
       return payrollProvidentFundDAO.readPf(zydexLocationId);
    }

    @Override
    public boolean isExist(PayrollProvidentFund payrollProvidentFund) {
       
      boolean flag = false;
        List<?> list = payrollProvidentFundDAO.read();
        Iterator i = list.iterator();
        while (i.hasNext()) {
            PayrollProvidentFund payrollProvidentFund1 = (PayrollProvidentFund) i.next();
            if (payrollProvidentFund1.getZydexLocationMaster().getId().intValue()
                    == payrollProvidentFund.getZydexLocationMaster().getId().intValue() ) {

                flag = true;
                break;
            }

        }

        return flag;
    }
 
    
}
