/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Tender;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.AuthTenderItemMaster;
import java.util.List;
import org.hibernate.Query;
/**
 *
 * @author admin
 */
public class AuthTenderItemMasterDaoImpl<T> extends GenericsDAOImpl<T> implements AuthTenderItemMasterDao<T> {
    
    @Override
    protected Class getDomainClass() {
        return AuthTenderItemMaster.class;
    }

    @Override
    public List readByItemNo(String refNo, String pur_no, String item_no) {
        String query = "";
        query += " FROM AuthTenderItemMaster a"
                + " WHERE a.refNo = '" + refNo + "' and a.purNo = '"+pur_no+"' and a.itemNo = '"+item_no+"'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByRefNo(String refNo) {
        String query = "";
        query += " FROM AuthTenderItemMaster a"
                + " WHERE a.refNo = '" + refNo + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void updateByItemNo(String refNo, String pur_no, String item_no, String item_remark, String qty, String checkId) {
        String query = "";
            query += " update AuthTenderItemMaster a"
                + " set a.remark='"+item_remark+"', "
                + " a.qty='"+qty+"', "
                + " a.attachmentRequired='"+checkId+"' "
                + " WHERE a.refNo = '" + refNo + "' and a.purNo = '" + pur_no + "' and a.itemNo = '" + item_no + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();

    }

    @Override
    public void deleteRefNo(String refNo) {
        String query = "";
            query += " delete from AuthTenderItemMaster a"
                + " WHERE a.refNo = '" + refNo + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }
}
