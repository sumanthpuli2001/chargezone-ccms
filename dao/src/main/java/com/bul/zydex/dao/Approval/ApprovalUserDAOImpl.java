/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Approval;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.ApprovalUser;
import java.util.List;

/**
 *
 * @author Vikas
 */
public class ApprovalUserDAOImpl<T> extends GenericsDAOImpl<T> implements ApprovalUserDAO<T> {

    @Override
    protected Class getDomainClass() {
        return ApprovalUser.class;
    }

    @Override
    public List<?> readByApprovalId(int id) {

        String query = "SELECT a"
                + " FROM ApprovalUser a "
                + " left join a.approvalMaster b"
                + " WHERE a.id = " + id;

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readapprovalempId() {
        String query = "SELECT a.id, b.name, c.employeeName, a.level, b.id"
                + " FROM ApprovalUser a "
                + " left join a.approvalMaster b"
                + " left join a.employeeMaster c"
                + " order by a.id";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

}
