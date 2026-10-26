/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Tender;


import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.CommitteeApprovalUser;
import java.util.List;

/**
 *
 * @author Bulwark-4
 */
public class CommitteeApprovalUserDaoImpl<T> extends GenericsDAOImpl<T> implements CommitteeApprovalUserDao<T> {

    @Override
    protected Class getDomainClass() {
        return CommitteeApprovalUser.class;
    }

    @Override
    public List<?> readByIdToList1(String id) {
        String query = "";
        query += " FROM CommitteeApprovalUser c"
              + " WHERE c.committeeApprovalSetting.id = '" + id + "'";
        return getHibernateTemplate().find(query);
    }
    
}
