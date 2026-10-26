/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Vendor;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.VendorInvitation;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author admin
 */
public class VendorInvitationDaoImpl<T> extends GenericsDAOImpl<T> implements VendorInvitationDao<T> {
    
    @Override
    protected Class getDomainClass() {
        return VendorInvitation.class;
    }
    
    @Override
    public List readByrow() {
        String query = "";
        query = " Select a from VendorInvitation a";
        return getHibernateTemplate().find(query);
    }
    
    @Override
    public List readEmail(String email) {
        String query = "";
        query += " FROM VendorInvitation a"
                + " WHERE a.vendorEmailId = '" + email + "'";
        return getHibernateTemplate().find(query);
    }
    
    @Override
    public VendorInvitation readEmailId(String email) {
        
        VendorInvitation vendorInvitation = new VendorInvitation();
        String query = "";
        query += " FROM VendorInvitation a"
                + " WHERE a.vendorEmailId = '" + email + "'";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            vendorInvitation = (VendorInvitation) list.get(0);
        }
        return vendorInvitation;
        
    }
    
    
    @Override
    public VendorInvitation readCode(String code) {
        
        VendorInvitation vendorInvitation = new VendorInvitation();
        String query = "";
        query += " FROM VendorInvitation a"
                + " WHERE a.encryText = '" + code + "'";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            vendorInvitation = (VendorInvitation) list.get(0);
        }
        return vendorInvitation;
        
    }
}
