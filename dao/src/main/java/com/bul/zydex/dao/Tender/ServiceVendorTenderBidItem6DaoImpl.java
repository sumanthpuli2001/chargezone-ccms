/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Tender;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.ServiceVendorTenderBidItem6;
import java.util.List;
import org.hibernate.Query;
/**
 *
 * @author admin
 */
public class ServiceVendorTenderBidItem6DaoImpl<T> extends GenericsDAOImpl<T> implements ServiceVendorTenderBidItem6Dao<T> {
    
    @Override
    protected Class getDomainClass() {
        return ServiceVendorTenderBidItem6.class;
    }

    @Override
    public List readVendorRefNo(String file_name, String username, String refNo) {
        String query = "";
        query += " FROM ServiceVendorTenderBidItem6 a"
                + " WHERE a.vendorCode = '" + username + "' and a.tenderNo = '" + refNo + "' and a.fileName = '"+file_name+"'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readItemVendorRefNo(String refNo, String username, String file_name, String sr_no) {
        String query = "";
        query += " FROM ServiceVendorTenderBidItem6 a"
                + " WHERE a.vendorCode = '" + username + "' and a.tenderNo = '" + refNo + "' and a.fileName = '"+file_name+"' and a.srNo = '"+sr_no+"'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void updateItemVendorRefNo(String refNo, String username, String file_name, String sr_no, String pc_type, String item_description, String uom, String qty, String amc_required_day, String rate, String net_rate, String vendor_remark, String item_regret) {
        String query = "";
        query += " update ServiceVendorTenderBidItem6 a"
                + " set a.rate='"+rate+"', "
                + " a.amountTotal='"+net_rate+"', "
                + " a.vendorRemark='"+vendor_remark+"', "
                + " a.itemregret="+item_regret+" "
                + " WHERE a.vendorCode = '" + username + "' and a.tenderNo = '" + refNo + "' and a.fileName = '"+file_name+"' and a.srNo = '"+sr_no+"'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }
}
