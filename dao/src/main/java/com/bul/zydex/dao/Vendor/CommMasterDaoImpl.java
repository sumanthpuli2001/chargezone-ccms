/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Vendor;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.CommMaster;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author admin
 */
public class CommMasterDaoImpl<T> extends GenericsDAOImpl<T> implements CommMasterDao<T> {
    
    @Override
    protected Class getDomainClass() {
        return CommMaster.class;
    }

    @Override
    public List readTenderVendorComm(String tender_no, String username) {
        String query = "";
        query += " FROM CommMaster a"
                + " WHERE a.tenderNo = '" + tender_no + "' and (a.vendorCode = '"+username+"' or a.userId = '"+username+"')";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void updateRead(String id) {
        String query = "";
        query += " update CommMaster a"
                + " set a.isread='1' "
                + " WHERE a.id = '" + id + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public List readTenderComm(String tender_no) {
        String query = "";
        query += " FROM CommMaster a"
                + " WHERE a.tenderNo = '" + tender_no + "'";
        return getHibernateTemplate().find(query);
    }
}
