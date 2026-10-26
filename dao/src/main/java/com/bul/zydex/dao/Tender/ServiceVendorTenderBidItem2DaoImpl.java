/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Tender;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.ServiceVendorTenderBidItem2;
import java.util.List;
import org.hibernate.Query;
/**
 *
 * @author admin
 */
public class ServiceVendorTenderBidItem2DaoImpl<T> extends GenericsDAOImpl<T> implements ServiceVendorTenderBidItem2Dao<T> {

    @Override
    protected Class getDomainClass() {
        return ServiceVendorTenderBidItem2.class;
    }

    @Override
    public List readVendorRefNo(String file_name, String username, String refNo) {
        String query = "";
        query += " FROM ServiceVendorTenderBidItem2 a"
                + " WHERE a.vendorCode = '" + username + "' and a.tenderNo = '" + refNo + "' and a.fileName = '"+file_name+"'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readItemVendorRefNo(String refNo, String username, String file_name, String sr_no) {
        String query = "";
        query += " FROM ServiceVendorTenderBidItem2 a"
                + " WHERE a.vendorCode = '" + username + "' and a.tenderNo = '" + refNo + "' and a.fileName = '"+file_name+"' and a.srNo = '"+sr_no+"'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void updateItemVendorRefNo(String refNo, String username, String file_name, String sr_no, String item_description, String onlyBearing1, String onlyBearing2, String onlyBearing3, String onlyBearing4, String onlyBearing5, String onlyBearing6, String onlyBearing7, String onlyBearing8, String onlyBearing9, String onlyBearing10) {
        String query = "";
        query += " update ServiceVendorTenderBidItem2 a"
                + " set a.onlyBearing1='"+onlyBearing1+"', "
                + " a.onlyBearing2='"+onlyBearing2+"', "
                + " a.onlyBearing3='"+onlyBearing3+"', "
                + " a.onlyBearing4='"+onlyBearing4+"', "
                + " a.onlyBearing5='"+onlyBearing5+"', "
                + " a.onlyBearing6='"+onlyBearing6+"', "
                + " a.onlyBearing7='"+onlyBearing7+"', "
                + " a.onlyBearing8='"+onlyBearing8+"', "
                + " a.onlyBearing9='"+onlyBearing9+"', "
                + " a.onlyBearing10='"+onlyBearing10+"' "
                + " WHERE a.vendorCode = '" + username + "' and a.tenderNo = '" + refNo + "' and a.fileName = '"+file_name+"' and a.srNo = '"+sr_no+"'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }
}
