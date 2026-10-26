/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.PR;

import com.bul.zydex.dao.Tender.*;
import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.PRItemMaster;
import com.bul.zydex.model.PRVendor;
import com.bul.zydex.model.TenderVendor;
import java.util.List;
import org.hibernate.Query;


/**
 *
 * @author admin
 */
public class PRVendorDaoImp<T> extends GenericsDAOImpl<T> implements PRVendorDao<T> {
    
    @Override
    protected Class getDomainClass() {
        return PRVendor.class;
    }

    @Override
    public List readByRfqNo(String ref_no) {
        String query = "";
        query += " FROM PRVendor a"
                + " WHERE a.prNo = '" + ref_no + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void delete1(int id) {
        String query = "";
            query += " delete PRVendor a"
                + " WHERE a.id = '" + id + "' and a.checked = '0'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public PRVendor readId(int id) {
         PRVendor pRVendor = new PRVendor();
        String query = "";
        query += " FROM PRVendor a"
                + " WHERE a.id = " + id + "";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            pRVendor = (PRVendor) list.get(0);
        }
        return pRVendor;
    }

    @Override
    public void updatePRNo(String refNo1, String refNo) {
        String query = "";
            query += " update PRVendor a"
                + " set a.prNo = '"+refNo+"'"
                + " WHERE a.prNo = '" + refNo1 + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public List readByRfqVendor(String ref_no, String vendor_code) {
        
         String query = "";
        query += " FROM PRVendor a"
                + " WHERE a.prNo = '" + ref_no + "' and a.vendorCode = '" + vendor_code + "'";
        return getHibernateTemplate().find(query);
        
    }
}
