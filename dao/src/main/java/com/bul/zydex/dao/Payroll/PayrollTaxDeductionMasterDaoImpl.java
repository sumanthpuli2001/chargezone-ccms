/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Payroll;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.PayrollTaxDeductionMaster;
import java.util.List;

/**
 *
 * @author DELL3
 */
public class PayrollTaxDeductionMasterDaoImpl<T> extends GenericsDAOImpl<T> implements PayrollTaxDeductionMasterDao<T> {

    @Override
    protected Class getDomainClass() {
        return PayrollTaxDeductionMaster.class;
    }

    @Override
    public List<?> readTaxDeduction() {
       
        String query = "SELECT a "
                + " FROM PayrollTaxDeductionMaster a";
        
        List<?> list = getHibernateTemplate().find(query);
        return list;
        
    }
 
}
