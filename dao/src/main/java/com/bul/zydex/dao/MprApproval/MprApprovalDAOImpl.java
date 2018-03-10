/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.MprApproval;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.MprApproval;
import java.util.List;

/**
 *
 * @author Vikas
 */
public class MprApprovalDAOImpl<T> extends GenericsDAOImpl<T> implements MprApprovalDAO<T> {

    @Override
    protected Class getDomainClass() {
        return MprApproval.class;
    }

    @Override
    public List<?> readApprovalMPRList(int empId) {
        String query = "";
        query += " "
                + " SELECT mm.id, mm.name, mm.numberOfPosition, mm.budget, mm.experience, mm.status, mm.currentLevel, "
                + " ma.level "
                + " FROM MprApproval ma "
                + " Left Join ma.mprMaster mm "
                + " Where  mm.currentLevel >= ma.level "
                + " And ma.employeeMaster.id = " + empId
                + " order by mm.id desc";

        List<?> list = getHibernateTemplate().find(query);
        return list;

    }

    public MprApproval readByMprIdAndEmpId(int mprid, int empid) {
        MprApproval mprApproval = new MprApproval();
        String query = "SELECT a"
                + " FROM MprApproval a "
                + " WHERE a.mprMaster.id = " + mprid
                + " and a.employeeMaster.id = " + empid;

        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            mprApproval = (MprApproval) list.get(0);
        } else {
            mprApproval = null;
        }
        return mprApproval;
    }

    @Override
    public List<?> mPrDelete(String mprId) {
        String query = "";

        query += "  "
                + " select a"
                + " FROM MprApproval a "
                + " WHERE a.mprMaster.id = " + mprId;
//        return getHibernateTemplate().find(query);
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

}
