/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Payroll;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.TaxDeductionDeclarationSavingStatus;
import java.util.List;

/**
 *
 * @author DELL3
 */
public class TaxDeductionDeclarationSavingStatusDAOImpl<T> extends GenericsDAOImpl<T> implements TaxDeductionDeclarationSavingStatusDAO<T> 
{

    @Override
    protected Class getDomainClass() {
        return TaxDeductionDeclarationSavingStatus.class;
    }

    @Override
    public List<?> readByTDDSId(int tddsId) {
        String query = "";
            query += " SELECT a FROM TaxDeductionDeclarationSavingStatus a "
                    + " WHERE a.taxDeductionDecarationSubmit.id = " +tddsId;
            List list = getHibernateTemplate().find(query);
            return list;
    }
    
}
