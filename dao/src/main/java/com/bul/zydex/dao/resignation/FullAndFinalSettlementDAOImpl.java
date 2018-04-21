/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.resignation;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.FullAndFinalSettlement;
import java.util.List;

/**
 *
 * @author Rishi
 */
public class FullAndFinalSettlementDAOImpl<T> extends GenericsDAOImpl<T> implements FullAndFinalSettlementDAO<T> {

    @Override
    protected Class getDomainClass() {
        return FullAndFinalSettlement.class;
    }

    @Override
    public List<?> readFAndFData() {
        String query = "";
        query += " "
                + " SELECT a.id, b.employeeName, a.noticePeriod, a.givenNotice"
                + " FROM FullAndFinalSettlement a "
                + " LEFT JOIN a.employeeMaster b"
                + " order by a.id desc";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

}
