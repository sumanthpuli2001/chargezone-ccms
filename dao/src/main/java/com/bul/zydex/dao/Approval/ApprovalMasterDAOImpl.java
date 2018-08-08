/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Approval;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.ApprovalMaster;
import java.util.List;

/**
 *
 * @author Vikas
 */
public class ApprovalMasterDAOImpl<T> extends GenericsDAOImpl<T> implements ApprovalMasterDAO<T> {

    @Override
    protected Class getDomainClass() {
        return ApprovalMaster.class;
    }

    @Override
    public ApprovalMaster approvalId(int aprId) {
        ApprovalMaster approvalMaster = new ApprovalMaster();
        String query = "SELECT a"
                + " FROM ApprovalMaster a "
                + " WHERE a.id = " + aprId;

        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            approvalMaster = (ApprovalMaster) list.get(0);
        } else {
            approvalMaster = null;
        }
        return approvalMaster;
    }

    @Override
    public ApprovalMaster readByapprovalname(String name) {
        ApprovalMaster approvalMaster = new ApprovalMaster();
        String query = "SELECT a"
                + " FROM ApprovalMaster a "
                + " WHERE a.name = '" + name +"'";

        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            approvalMaster = (ApprovalMaster) list.get(0);
        } else {
            approvalMaster = null;
        }
        return approvalMaster;
    }

}
