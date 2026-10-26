/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Tender;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.TenderRegret;
import com.bul.zydex.model.VendorMaster;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author admin
 */
public class TenderRegretDaoImpl<T> extends GenericsDAOImpl<T> implements TenderRegretDao<T> {
    
    @Override
    protected Class getDomainClass() {
        return TenderRegret.class;
    }

    @Override
    public List regretList(String refNo) {
        String query = "";
        query += " FROM TenderRegret a"
                + " WHERE a.refNo = '" + refNo + "' and a.flag = '1'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByTenderNo(String tender_no, String username) {
        String query = "";
        query += " FROM TenderRegret a"
                + " WHERE a.refNo = '" + tender_no + "' and a.vendorCode = '"+username+"'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void updateTenderRegret(String tender_no, String username, String remark) {
        String query = "";
            query += " update TenderRegret a"
                + " set a.remark = '"+remark+"',"
                + " a.flag='1' "
                + " WHERE a.refNo = '" + tender_no + "' and a.vendorCode = '"+username+"'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public List readByVendor(String username) {
        String query = "";
        query += " FROM TenderRegret a"
                + " WHERE a.vendorCode = '"+username+"'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void updateTenderBid(String tender_no, String username) {
        String query = "";
            query += " update TenderRegret a"
                + " set a.remark = '',"                + " a.flag='0' "

                + " WHERE a.refNo = '" + tender_no + "' and a.vendorCode = '"+username+"'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public List regretList1(String tender_no) {
        String query = "";
        query += "select a.vendorCode, b.vendorName, b.vendorPhNo, b.vendorEmailID FROM TenderRegret a, VendorMaster b"
                + " WHERE a.refNo = '" + tender_no + "' and a.flag = '1' and a.vendorCode = b.vendorRegNo";
        return getHibernateTemplate().find(query);
    }
}
