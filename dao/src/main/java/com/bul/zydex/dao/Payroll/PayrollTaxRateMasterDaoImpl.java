/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Payroll;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.PayrollTaxRateMaster;
import java.util.List;

/**
 *
 * @author DELL3
 */
public class PayrollTaxRateMasterDaoImpl<T> extends GenericsDAOImpl<T> implements PayrollTaxRateMasterDao<T> {

    @Override
    protected Class getDomainClass() {
        return PayrollTaxRateMaster.class;
    }

    @Override
    public List<?> getAgeValues(Integer ageF, Integer ageT, Integer incomeF, Integer incomeT) {
        
        String query = "SELECT a "
                + " FROM PayrollTaxRateMaster a "
                + " WHERE ((a.ageFrom between "+ageF+" and "+ageT+") "
                + " or (a.ageTo between "+ageF+" and "+ageT+")) "
                + " and ((a.incomeFrom between "+incomeF+" and "+incomeT+") "
                + " or (a.incomeTo between "+incomeF+" and "+incomeT+"))";
        
        List<?> list = getHibernateTemplate().find(query);
        return list;        
    }

    @Override
    public PayrollTaxRateMaster readTaxRate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
