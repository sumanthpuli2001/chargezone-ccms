/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Sap;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.SapTenderMaster;
import com.bul.zydex.model.VendorMaster;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author admin
 */
public class SapTenderMasterDaoImpl<T> extends GenericsDAOImpl<T> implements SapTenderMasterDao<T> {
 
    @Override
    protected Class getDomainClass() {
        return SapTenderMasterDao.class;
    }

    @Override
    public List readByRefNo(String refNo) {
        String query = "";
        query += " select a.vendorCode, a.rfqNo, b.vendorName, b.vendorAddressLine1, b.vendorEmailID, b.vendorMobNo FROM SapTenderMaster a, VendorMaster b "
                + " WHERE a.tenderNo = '" + refNo + "' and a.vendorCode=b.vendorRegNo";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void deleteRefNo(String refNo) {
        String query = "";
            query += " delete from SapTenderMaster a"
                + " WHERE a.tenderNo = '" + refNo + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public List readByTenderNo(String refNo) {
        String query = "";
        query += " FROM SapTenderMaster a "
                + " WHERE a.tenderNo = '" + refNo + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public SapTenderMaster readByRefNo1(String refNo, String LIFNR) {
        SapTenderMaster sapTenderMaster = new SapTenderMaster();
        String query = "";
        query += " FROM SapTenderMaster a"
                + " WHERE a.tenderNo = '" + refNo + "' and a.vendorCode = '"+LIFNR+"'";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            sapTenderMaster = (SapTenderMaster) list.get(0);
        }
        return sapTenderMaster;
    }
}
