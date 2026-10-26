/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Vendor;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.VendorPreBid;
import com.bul.zydex.model.VendorTenderBid;
import com.bul.zydex.model.VendorMaster;
import java.util.List;
import org.hibernate.Query;
/**
 *
 * @author admin
 */
public class VendorPreBidDaoImpl<T> extends GenericsDAOImpl<T> implements VendorPreBidDao<T> {

    @Override
    protected Class getDomainClass() {
        return VendorPreBid.class;
    }

    @Override
    public VendorPreBid readByVendorRefNo(String refNo, String username) {
        VendorPreBid vendorPreBid = new VendorPreBid();
        String query = "";
        query += " FROM VendorPreBid a"
                + " WHERE a.refNo = '" + refNo + "' and a.vendorCode = '"+username+"'";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            vendorPreBid = (VendorPreBid) list.get(0);
        }
        return vendorPreBid;
    }

    @Override
    public List readVendorRefNo(String refNo, String username) {
        String query = "";
        query += " FROM VendorPreBid a"
                + " WHERE a.refNo = '" + refNo + "' and a.vendorCode = '"+username+"'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void updateVendorRefNo(String refNo, String username, String preBidDeviation, String preBidRemark) {
        String query = "";
        query += " update VendorPreBid a"
                + " set a.preBidDeviation='"+preBidDeviation+"', "
                + " a.preBidRemark='"+preBidRemark+"' "
                + " WHERE a.refNo = '" + refNo + "' and a.vendorCode = '"+username+"'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public List vendorList(String refNo) {
        String query = "";
        query += " FROM VendorPreBid a"
                + " WHERE a.refNo = '" + refNo + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List preBidList(String refNo) {
        String query = "";
        query += "select a.refNo, a.vendorCode, c.vendorName, c.vendorAddressLine1, c.vendorMobNo, c.vendorEmailID FROM VendorPreBid a, VendorTenderBid b, VendorMaster c "
                + " WHERE a.refNo = '" + refNo + "' and (a.bidOpenFlag!='1' or a.bidOpenFlag is null) and a.refNo = b.refNo and a.vendorCode = b.vendorCode and b.submitFlag = 1 and b.vendorCode=c.vendorRegNo";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List preBidOpenList(String refNo) {
        String query = "";
        query += "select a.refNo, a.vendorCode, b.vendorName, b.vendorAddressLine1, b.vendorMobNo, b.vendorEmailID  FROM VendorPreBid a, VendorMaster b"
                + " WHERE a.refNo = '" + refNo + "' and a.bidOpenFlag='1' and a.vendorCode=b.vendorRegNo";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void openPreBid(String refNo, String vendor_list, String user_by, String user_by_id, String formattedDate) {
        String query = "";
        query += " update VendorPreBid a"
                + " set a.bidOpenDate='"+formattedDate+"', "
                + " a.bidOpenBy='"+user_by+"', "
                + " a.bidOpenById='"+user_by_id+"', "
                + " a.bidOpenFlag='1' "
                + " WHERE a.refNo = '" + refNo + "' and a.vendorCode = '"+vendor_list+"'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public void approvePreBid(String refNo, String checkedValues, String employee_name, String username, String formattedDate) {
        String query = "";
        query += " update VendorPreBid a"
                + " set a.bidApproveDate='"+formattedDate+"', "
                + " a.bidApproveBy='"+employee_name+"', "
                + " a.bidApproveById='"+username+"', "
                + " a.bidApproveFlag='1' "
                + " WHERE a.refNo = '" + refNo + "' and a.vendorCode = '"+checkedValues+"'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }
    
}
