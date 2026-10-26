/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Tender;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.ServiceVendorTenderBid;
import java.util.List;
import org.hibernate.Query;
/**
 *
 * @author admin
 */
public class ServiceVendorTenderBidDaoImpl<T> extends GenericsDAOImpl<T> implements ServiceVendorTenderBidDao<T> {
    
    @Override
    protected Class getDomainClass() {
        return ServiceVendorTenderBid.class;
    }

    @Override
    public List readVendorRefNo(String file_name, String username, String refNo) {
        String query = "";
        query += " FROM ServiceVendorTenderBid a"
                + " WHERE a.vendorCode = '" + username + "' and a.tenderNo = '" + refNo + "' and a.fileName = '"+file_name+"'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void updateVendorTenderBid(String refNo, String username, String file_name, String common_tax, String discount_val, String discount, String packing_val, String packing, String freight_val, String freight, String errection, String other_charges, String igst, String cgst, String sgst, String insurance_value, String total_amount, String grand_total) {
        String query = "";
        query += " update ServiceVendorTenderBid a"
                + " set a.selectCommon='"+common_tax+"', "
                + " a.discountType='"+discount_val+"', "
                + " a.discountValue='"+discount+"', "
                + " a.packingType='"+packing_val+"', "
                + " a.packingValue='"+packing+"', "
                + " a.freightType='"+freight_val+"', "
                + " a.freightValue='"+freight+"', "
                + " a.errectionValue='"+errection+"', "
                + " a.chargesValue='"+other_charges+"', "
                + " a.igstValue='"+igst+"', "
                + " a.cgstValue='"+cgst+"', "
                + " a.sgstValue='"+sgst+"', "
                + " a.insuranceValue='"+insurance_value+"', "
                + " a.itemTotal='"+total_amount+"', "
                + " a.grandTotal="+grand_total+" "
                + " WHERE a.vendorCode = '" + username + "' and a.tenderNo = '" + refNo + "' and a.fileName = '"+file_name+"'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public List readVendorRefNo2(String username, String refNo) {
        String query = "";
        query += " FROM ServiceVendorTenderBid a"
                + " WHERE a.vendorCode = '" + username + "' and a.tenderNo = '" + refNo + "'";
        return getHibernateTemplate().find(query);
    }
}
