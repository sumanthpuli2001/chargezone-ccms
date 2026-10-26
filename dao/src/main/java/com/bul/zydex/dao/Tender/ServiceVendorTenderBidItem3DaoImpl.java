/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Tender;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.ServiceVendorTenderBidItem3;
import java.util.List;
import org.hibernate.Query;
/**
 *
 * @author admin
 */
public class ServiceVendorTenderBidItem3DaoImpl<T> extends GenericsDAOImpl<T> implements ServiceVendorTenderBidItem3Dao<T> {

    @Override
    protected Class getDomainClass() {
        return ServiceVendorTenderBidItem3.class;
    }

    @Override
    public List readVendorRefNo(String file_name, String username, String refNo) {
        String query = "";
        query += " FROM ServiceVendorTenderBidItem3 a"
                + " WHERE a.vendorCode = '" + username + "' and a.tenderNo = '" + refNo + "' and a.fileName = '"+file_name+"'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readItemVendorRefNo(String refNo, String username, String file_name, String sr_no) {
        String query = "";
        query += " FROM ServiceVendorTenderBidItem3 a"
                + " WHERE a.vendorCode = '" + username + "' and a.tenderNo = '" + refNo + "' and a.fileName = '"+file_name+"' and a.srNo = '"+sr_no+"'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void updateItemVendorRefNo(String refNo, String username, String file_name, String sr_no, String particular, String scheduled_amount, String percentage, String percentage_amount, String net_rate, String vendor_remark, String item_regret) {
        String query = "";
        query += " update ServiceVendorTenderBidItem3 a"
                + " set a.particular='"+particular+"', "
                + " a.scheduledAmount='"+scheduled_amount+"', "
                + " a.percent='"+percentage+"', "
                + " a.percentRate='"+percentage_amount+"', "
                + " a.amountTotal='"+net_rate+"', "
                + " a.vendorRemark='"+vendor_remark+"', "
                + " a.itemregret="+item_regret+" "
                + " WHERE a.vendorCode = '" + username + "' and a.tenderNo = '" + refNo + "' and a.fileName = '"+file_name+"' and a.srNo = '"+sr_no+"'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }
}
