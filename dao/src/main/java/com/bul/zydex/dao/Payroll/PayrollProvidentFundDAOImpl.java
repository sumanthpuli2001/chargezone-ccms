/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Payroll;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.PayrollProvidentFund;
import java.util.List;

/**
 *
 * @author AJAY <ajay@bulwarks.com>
 */
public class PayrollProvidentFundDAOImpl<T> extends GenericsDAOImpl<T> implements PayrollProvidentFundDAO<T> {

    @Override
    protected Class getDomainClass() {
        return PayrollProvidentFund.class;
    }

    @Override
    public List<?> readPf(int zydexLocationId) {
       
         String query = "";
        query += ""
                + " FROM PayrollProvidentFund a "
                + " where a.zydexLocationMaster.id="+zydexLocationId;
           
              
                

        return getHibernateTemplate().find(query);
    }
   

}
