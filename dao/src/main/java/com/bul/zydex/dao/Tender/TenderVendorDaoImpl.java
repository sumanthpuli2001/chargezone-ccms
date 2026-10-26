/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Tender;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.TenderVendor;
import java.util.List;
import org.hibernate.Query;


/**
 *
 * @author admin
 */
public class TenderVendorDaoImpl<T> extends GenericsDAOImpl<T> implements TenderVendorDao<T> {
    
    @Override
    protected Class getDomainClass() {
        return TenderVendor.class;
    }

    @Override
    public List readByVendor(String refNo, String vendor_code) {
        String query = "";
        query += " FROM TenderVendor a"
                + " WHERE a.refNo = '" + refNo + "' and a.vendorCode = '"+vendor_code+"'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByRefNo(String refNo) {
        String query = "";
        query += " FROM TenderVendor a"
                + " WHERE a.refNo = '" + refNo + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void updateVendor(String refNo, String vendor_code, String email_id, String mobile_no, String checkVendorId) {
        
        String query = "";
            query += " update TenderVendor a"
                + " set a.emailId='"+email_id+"', "
                + " a.mobileNo='"+mobile_no+"', "
                + " a.checked="+Integer.parseInt(checkVendorId)+" "
                + " WHERE a.refNo = '" + refNo + "' and a.vendorCode = '" + vendor_code + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();

    }

    @Override
    public List vendorList(String refNo) {
        String query = "";
        query += " FROM TenderVendor a"
                + " WHERE a.refNo = '" + refNo + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByRfqNo(String ref_no) {
        String query = "";
        query += " FROM TenderVendor a"
                + " WHERE a.rfqNo = '" + ref_no + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void updateRefNo(String refNo1, String refNo, String vendor_code, String email_id, String mobile_no, int checkVendorId1) {
        String query = "";
            query += " update TenderVendor a"
            //    + " set a.emailId='"+email_id+"', "
            //    + " a.mobileNo='"+mobile_no+"', "
                + " set a.refNo='"+refNo+"', "
                + " a.checked="+checkVendorId1+" "
                + " WHERE a.rfqNo = '" + refNo1 + "' and a.vendorCode = '" + vendor_code + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public List readByRfqVendor(String ref_no, String vendor_code) {
        String query = "";
        query += " FROM TenderVendor a"
                + " WHERE a.rfqNo = '" + ref_no + "' and a.vendorCode = '" + vendor_code + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void delete1(int id) {
        String query = "";
            query += " delete TenderVendor a"
                + " WHERE a.id = '" + id + "' and a.checked = '0'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public List readByRefVendor(String ref_no, String vendor_code) {
        String query = "";
        query += " FROM TenderVendor a"
                + " WHERE a.refNo = '" + ref_no + "' and a.vendorCode = '" + vendor_code + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void updateVendor1(String refNo, String vendor_code, String email_id, String mobile_no) {
        String query = "";
            query += " update TenderVendor a"
                + " set a.emailId='"+email_id+"', "
                + " a.mobileNo='"+mobile_no+"' "
                + " WHERE a.refNo = '" + refNo + "' and a.vendorCode = '" + vendor_code + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public TenderVendor readByRefVendor1(String refNo, String checkedValues) {
        TenderVendor tenderVendor = new TenderVendor();
        String query = "";
        query += " FROM TenderVendor a"
                + " WHERE a.refNo = '" + refNo + "' and a.vendorCode = '"+checkedValues+"'";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            tenderVendor = (TenderVendor) list.get(0);
        }
        return tenderVendor;
    }

    @Override
    public List readVendor(String vendor_code) {
        String query = "";
        query += " FROM TenderVendor a"
                + " WHERE a.vendorCode = '"+vendor_code+"'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public TenderVendor readByRefNo1(String refNo) {
          TenderVendor tenderVendor = new TenderVendor();
        String query = "";
        query += " FROM TenderVendor a"
                + " WHERE a.refNo = '" + refNo + "'";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            tenderVendor = (TenderVendor) list.get(0);
        }
        return tenderVendor;
    }
}
