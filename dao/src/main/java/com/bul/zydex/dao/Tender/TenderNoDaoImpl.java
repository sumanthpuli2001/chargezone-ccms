/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Tender;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.TenderNo;
import java.util.List;
import org.hibernate.Query;
/**
 *
 * @author admin
 */
public class TenderNoDaoImpl<T> extends GenericsDAOImpl<T> implements TenderNoDao<T> {
    
    @Override
    protected Class getDomainClass() {
        return TenderNo.class;
    }

    @Override
    public TenderNo readByTenderNo() {
        TenderNo tenderNo = new TenderNo();
        String query = "";
        query += " FROM TenderNo a order by a.tenderNo desc limit 1"
                + " ";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            tenderNo = (TenderNo) list.get(0);
        }
        return tenderNo;
    }
}
