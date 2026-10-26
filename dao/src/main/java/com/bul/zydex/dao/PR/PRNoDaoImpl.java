/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.PR;

import com.bul.zydex.dao.Tender.*;
import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.PRNo;
import com.bul.zydex.model.TenderNo;
import java.util.List;
import org.hibernate.Query;
/**
 *
 * @author admin
 */
public class PRNoDaoImpl<T> extends GenericsDAOImpl<T> implements PRNoDao<T> {
    
    @Override
    protected Class getDomainClass() {
        return PRNo.class;
    }

    @Override
    public PRNo readByPrNo() {
        PRNo prNo = new PRNo();
        String query = "";
        query += " FROM PRNo a order by a.prNo desc limit 1"
                + " ";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            prNo = (PRNo) list.get(0);
        }
        return prNo;
    }

  
}
