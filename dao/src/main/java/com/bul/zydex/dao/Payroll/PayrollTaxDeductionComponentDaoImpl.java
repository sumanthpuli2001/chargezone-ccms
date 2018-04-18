/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Payroll;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.PayrollTaxDeductionComponent;
import java.util.List;

/**
 *
 * @author DELL3
 */
public class PayrollTaxDeductionComponentDaoImpl<T> extends GenericsDAOImpl<T> implements PayrollTaxDeductionComponentDao<T> {

    @Override
    protected Class getDomainClass() {
        return PayrollTaxDeductionComponent.class;
    }

    @Override
    public List<?> readTaxDeductionComponentforFromSixteen(int taxdeductionMasterid) {
        String query = "";
        query += "Select a.componentId,a.component,a.ageLimit,a.taxSavingLimit,a.payrollTaxDeductionMaster.id"
                + " From PayrollTaxDeductionComponent a"
                + " Where a.payrollTaxDeductionMaster.id=" + taxdeductionMasterid;
         

        return getHibernateTemplate().find(query);
    }
        
    @Override
    public List<?> readByComponentId(int id) {
        String query = "SELECT a "
               + " FROM PayrollTaxDeductionComponent a"
               + " WHERE componentId = " + id;
      
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List readSection(){
        String query = "SELECT a.id,a.section "
               + " FROM PayrollTaxDeductionMaster a";
      
        List list = getHibernateTemplate().find(query);
        return list;
    }   

    @Override
    public List<?> readComponent() {
        String query = "SELECT a.componentId, a.component, a.ageLimit, a.taxSavingLimit, b.section "
                + "FROM PayrollTaxDeductionComponent a "
                + "left join a.payrollTaxDeductionMaster b";
        
        List list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public int getTaxMasterID(int componentID) {
       Integer i = 0;
        String query = " SELECT b.id "
                + " FROM PayrollTaxDeductionComponent a "
                + " LEFT JOIN a.payrollTaxDeductionMaster b "
                + " Where a.componentId = " + componentID;
             

        List list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            i = (Integer) list.get(0);

        }
        return i;
    }

}
