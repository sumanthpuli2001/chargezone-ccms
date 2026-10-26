/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.CrcFormApprovalUser;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.CrcFormApprovalUser;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class CrcFormApprovalUserDaoImpl<T> extends GenericsDAOImpl<T> implements CrcFormApprovalUserDao<T> {

    @Override
    protected Class getDomainClass() {
        return CrcFormApprovalUser.class;
    }

    @Override
    public CrcFormApprovalUser appvals(String username,String crcFormid) {
        String query = "";
        CrcFormApprovalUser crcFormApprovalUser = new CrcFormApprovalUser();
        query += "SELECT b FROM  CrcFormApproval a, CrcFormApprovalUser b "
                + "WHERE  a.id = b.crcFormApproval "
                + "and b.userId = '" + username + "'"
                + "and b.crcForm = '" + crcFormid + "'";
//                + " and a.approvalStatus =0 "
//                + "and a.currentApproval = b.level ";
               
        List list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            crcFormApprovalUser = (CrcFormApprovalUser) list.get(0);

        }
        return crcFormApprovalUser;

    }

    @Override
    public List readByDleteCode(int formid) {
        String query = "";
        query += " FROM CrcFormApprovalUser a"
                + " WHERE a.crcFormApproval = '" + formid + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByApprovalStatus(String id) {
        String query = "";
        query += " FROM CrcFormApprovalUser a"
                + " WHERE a.crcForm = '" + id + "'"
                + " AND a.approvalStatus IN (1,0,2,8)";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByApprovalStatuszero(int crcFormid) {

        String query = "";
        query += " FROM CrcFormApprovalUser a"
                + " WHERE a.crcForm = '" + crcFormid + "'"
                + " AND a.approvalStatus IN (0)";
        return getHibernateTemplate().find(query);

    }

    @Override

    public List readyByCrcId(int crcid) {
        String query = "";
        query += " FROM CrcFormApprovalUser a"
                + " WHERE a.crcForm = '" + crcid + "'";
        return getHibernateTemplate().find(query);
    }

}
