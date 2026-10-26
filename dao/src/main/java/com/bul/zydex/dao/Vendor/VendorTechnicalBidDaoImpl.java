/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Vendor;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.VendorTechnicalBid;
import com.bul.zydex.model.VendorTenderBid;
import com.bul.zydex.model.VendorMaster;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author admin
 */
public class VendorTechnicalBidDaoImpl<T> extends GenericsDAOImpl<T> implements VendorTechnicalBidDao<T> {

    @Override
    protected Class getDomainClass() {
        return VendorTechnicalBid.class;
    }

    @Override
    public VendorTechnicalBid readByVendorRefNo(String refNo, String username) {
        VendorTechnicalBid vendorTechnicalBid = new VendorTechnicalBid();
        String query = "";
        query += " FROM VendorTechnicalBid a"
                + " WHERE a.refNo = '" + refNo + "' and a.vendorCode = '" + username + "'";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            vendorTechnicalBid = (VendorTechnicalBid) list.get(0);
        }
        return vendorTechnicalBid;
    }

    @Override
    public List readVendorRefNo(String refNo, String username) {
        String query = "";
        query += " FROM VendorTechnicalBid a"
                + " WHERE a.refNo = '" + refNo + "' and a.vendorCode = '" + username + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void updateVendorRefNo(String refNo, String username, String technicalBidDeviation, String technicalBidRemark) {
        String query = "";
        query += " update VendorTechnicalBid a"
                + " set a.technicalDeviation='" + technicalBidDeviation + "', "
                + " a.technicalRemark='" + technicalBidRemark + "' "
                + " WHERE a.refNo = '" + refNo + "' and a.vendorCode = '" + username + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public List vendorList(String refNo) {
        String query = "";
        query += " FROM VendorTechnicalBid a"
                + " WHERE a.refNo = '" + refNo + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List techBidList(String refNo) {
        String query = "";
        query += "select a.refNo, a.vendorCode, c.vendorName, c.vendorAddressLine1, c.vendorMobNo, c.vendorEmailID FROM VendorTechnicalBid a, VendorTenderBid b, VendorMaster c "
                + " WHERE a.refNo = '" + refNo + "' and (a.bidOpenFlag!='1' or a.bidOpenFlag is null) and a.refNo = b.refNo and a.vendorCode = b.vendorCode and b.techSubmitFlag = 1 and b.vendorCode=c.vendorRegNo";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List techBidOpenList(String refNo) {
        String query = "";
        query += "select a.refNo, a.vendorCode, b.vendorName, b.vendorAddressLine1, b.vendorMobNo, b.vendorEmailID, a.techPercentage, a.reviseBidFlag, a.bidApproveFlag  FROM VendorTechnicalBid a, VendorMaster b"
                + " WHERE a.refNo = '" + refNo + "' and a.bidOpenFlag='1' and a.vendorCode=b.vendorRegNo order by CAST(a.techPercentage AS int) desc";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void openTechBid(String refNo, String vendor_list, String user_by, String user_by_id, String formattedDate) {
        String query = "";
        query += " update VendorTechnicalBid a"
                + " set a.bidOpenDate='" + formattedDate + "', "
                + " a.bidOpenBy='" + user_by + "', "
                + " a.bidOpenById='" + user_by_id + "', "
                + " a.bidOpenFlag='1' "
                + " WHERE a.refNo = '" + refNo + "' and a.vendorCode = '" + vendor_list + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public void approveTechBid(String refNo, String checkedValues, String employee_name, String username, String formattedDate) {
        String query = "";
        query += " update VendorTechnicalBid a"
                + " set a.bidApproveDate='" + formattedDate + "', "
                + " a.bidApproveBy='" + employee_name + "', "
                + " a.bidApproveById='" + username + "', "
                + " a.bidApproveFlag='1' "
                + " WHERE a.refNo = '" + refNo + "' and a.vendorCode = '" + checkedValues + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public List techBidOpenList1(String refNo) {
        String query = "";
        query += " FROM VendorTechnicalBid a"
                + " WHERE a.refNo = '" + refNo + "' and a.bidOpenFlag='1'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List checkBidOpen(String refNo) {
        String query = "";
        query += " FROM VendorTechnicalBid a"
                + " WHERE a.refNo = '" + refNo + "' and a.bidApproveFlag='1'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByVendorRefNo1(String refNo) {
        String query = "";

        query += "select a.refNo, a.vendorCode, b.vendorName, b.vendorAddressLine1, b.vendorMobNo, b.vendorEmailID, a.techPercentage, a.reviseBidFlag  FROM VendorTechnicalBid a, VendorMaster b"
                + " WHERE a.refNo = '" + refNo + "' and a.bidOpenFlag='1' and a.vendorCode=b.vendorRegNo order by CAST(a.techPercentage AS int) desc";
        return getHibernateTemplate().find(query);

    }

    @Override
    public void readByDelete(String refNo, String username) {

        String query = "";
        query += "delete FROM VendorTechnicalBid a WHERE a.refNo = '" + refNo + "' and a.vendorCode = '" + username + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public boolean readByRefNO(String refNo) {

        String hql = "select count(v) from VendorTechnicalBid v "
                + "where v.refNo = ? and v.bidOpenFlag = '1'";

        List result = getHibernateTemplate().find(hql, refNo);

        Long count = (Long) result.get(0);

        return count > 0;
    }

    @Override
    public List techBidOpenListPrSummary(String refNo) {

        String query = "SELECT t.refNo, t.vendorCode, b.vendorName, b.vendorAddressLine1, "
                + "b.vendorMobNo, b.vendorEmailID, "
                + "(SELECT a.techPercentage FROM VendorTechnicalBid a "
                + " WHERE a.refNo = t.refNo AND a.vendorCode = t.vendorCode AND a.bidOpenFlag = '1'), "
                + "(SELECT a.reviseBidFlag FROM VendorTechnicalBid a "
                + " WHERE a.refNo = t.refNo AND a.vendorCode = t.vendorCode AND a.bidOpenFlag = '1'), "
                + "(SELECT a.bidApproveFlag FROM VendorTechnicalBid a "
                + " WHERE a.refNo = t.refNo AND a.vendorCode = t.vendorCode AND a.bidOpenFlag = '1') "
                + "FROM TenderVendor t, VendorMaster b "
                + "WHERE t.refNo = ? "
                + "AND t.vendorCode = b.vendorRegNo "
                + "ORDER BY t.vendorCode";

        List result = getHibernateTemplate().find(query, refNo);

        Collections.sort(result, new Comparator() {
            public int compare(Object o1, Object o2) {
                Object[] row1 = (Object[]) o1;
                Object[] row2 = (Object[]) o2;

                boolean participated1 = row1[6] != null;
                boolean participated2 = row2[6] != null;

                if (participated1 == participated2) {
                    return 0;
                }
                return participated1 ? -1 : 1;
            }
        });

        return result;
    }
}
