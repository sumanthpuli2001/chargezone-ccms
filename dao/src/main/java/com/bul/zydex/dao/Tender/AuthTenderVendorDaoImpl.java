/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Tender;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.AuthTenderVendor;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author admin
 */
public class AuthTenderVendorDaoImpl<T> extends GenericsDAOImpl<T> implements AuthTenderVendorDao<T> {
    
    @Override
    protected Class getDomainClass() {
        return AuthTenderVendor.class;
    }

    @Override
    public List readByVendor(String refNo, String vendor_code) {
        String query = "";
        query += " FROM AuthTenderVendor a"
                + " WHERE a.refNo = '" + refNo + "' and a.vendorCode = '"+vendor_code+"'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByRefNo(String refNo) {
        String query = "";
        query += " FROM AuthTenderVendor a"
                + " WHERE a.refNo = '" + refNo + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void updateVendor(String refNo, String vendor_code, String email_id, String mobile_no, String checkVendorId) {
        
        String query = "";
            query += " update AuthTenderVendor a"
                + " set a.emailId='"+email_id+"', "
                + " a.mobileNo='"+mobile_no+"', "
                + " a.checked="+Integer.parseInt(checkVendorId)+" "
                + " WHERE a.refNo = '" + refNo + "' and a.vendorCode = '" + vendor_code + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();

    }

    @Override
    public void deleteRefNo(String refNo) {
        String query = "";
            query += " delete from AuthTenderVendor a"
                + " WHERE a.refNo = '" + refNo + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public void updateVendor1(String refNo, String LIFNR, String email, String tele) {
        String query = "";
            query += " update AuthTenderVendor a"
                + " set a.emailId='"+email+"', "
                + " a.mobileNo='"+tele+"' "
                + " WHERE a.refNo = '" + refNo + "' and a.vendorCode = '" + LIFNR + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }
}
