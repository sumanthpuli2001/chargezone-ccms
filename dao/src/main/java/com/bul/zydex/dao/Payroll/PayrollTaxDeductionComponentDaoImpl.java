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
        query += "Select a.componentId,a.component,a.ageLimit,a.taxSavingLimit"
                + " From PayrollTaxDeductionComponent a"
                + " Where a.payrollTaxDeductionMaster.id=" + taxdeductionMasterid;
         

        return getHibernateTemplate().find(query);
    }

}
