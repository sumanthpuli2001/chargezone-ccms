/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Tender;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.TenderApprovalUser;
import java.util.List;

/**
 *
 * @author Bulwark-4
 */
public class TenderApprovalUserDaoImpl<T> extends GenericsDAOImpl<T> implements TenderApprovalUserDao<T>{

    @Override
    protected Class getDomainClass() {
        return TenderApprovalUser.class;
    }

    @Override
    public List readByIdToList(String id) {
        String query = "";
        query += " FROM TenderApprovalUser a"
                + " WHERE a.tenderApprovalSetting.id = '" + id + "'";
        return getHibernateTemplate().find(query);
    }
    
}
