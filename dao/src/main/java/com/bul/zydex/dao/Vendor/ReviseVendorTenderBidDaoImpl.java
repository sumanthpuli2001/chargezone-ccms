/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Vendor;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.ReviseVendorTenderBid;
import java.util.List;
import org.hibernate.Query;
/**
 *
 * @author admin
 */
public class ReviseVendorTenderBidDaoImpl<T> extends GenericsDAOImpl<T> implements ReviseVendorTenderBidDao<T> {
    
    @Override
    protected Class getDomainClass() {
        return ReviseVendorTenderBid.class;
    }

    @Override
    public ReviseVendorTenderBid readByVendorRefNo(String refNo, String username) {
        ReviseVendorTenderBid reviseVendorTenderBid = new ReviseVendorTenderBid();
        String query = "";
        query += " FROM ReviseVendorTenderBid a"
                + " WHERE a.refNo = '" + refNo + "' and a.vendorCode = '"+username+"'";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            reviseVendorTenderBid = (ReviseVendorTenderBid) list.get(0);
        }
        return reviseVendorTenderBid;
    }

    @Override
    public List readVendorRefNo(String refNo, String username) {
        String query = "";
        query += " FROM ReviseVendorTenderBid a"
                + " WHERE a.refNo = '" + refNo + "' and a.vendorCode = '"+username+"'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void updateVendorItem(String refNo, String username, String common_tax, String discount_val, String discount, String packing_val, String packing, String freight_val, String freight, String errection, String other_charges, String igst, String cgst, String sgst, String insurance_value, String total_amount, String grand_total, String venodr_total_words) {
        String query = "";
            query += " update ReviseVendorTenderBid a"
                + " set a.discountType='"+discount_val+"', "
                + " a.selectCommon='"+common_tax+"', "
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
                + " a.grandTotal='"+grand_total+"', "
              //  + " a.submitFlag=1, "    
                + " a.grandTotalWord='"+venodr_total_words+"' "
                + " WHERE a.refNo = '" + refNo + "' and a.vendorCode = '"+username+"'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public void updateVendorServiceItem(String refNo, String username, String discount_val, String discount, String igst, String total_amount, String grand_total) {
         String query = "";
            query += " update ReviseVendorTenderBid a"
                + " set a.serviceDiscountType='"+discount_val+"', " 
                + " a.serviceDiscountValue='"+discount+"', "     
                + " a.serviceGst='"+igst+"', "    
                + " a.serviceTotal='"+total_amount+"', "
                + " a.serviceTaxTotal='"+grand_total+"' "
                + " WHERE a.refNo = '" + refNo + "' and a.vendorCode = '"+username+"'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public List vendorBidPrice(String refNo, String vendor_code) {
        String query = "";
        query += "SELECT a.refNo, a.vendorCode,"
                + " SUM(CASE WHEN b.itemType = 0 THEN (c.qty * b.rate) ELSE 0 END) AS total_type0,"
                + " SUM(CASE WHEN b.itemType = 1 THEN (c.qty * b.rate) ELSE 0 END) AS total_type1,"
                + " SUM(CASE WHEN b.itemType = 0 THEN (c.qty * b.rate) ELSE 0 END) + ((SUM(CASE WHEN b.itemType = 0 THEN (c.qty * b.rate) ELSE 0 END))* a.packingValue/100) + ((SUM(CASE WHEN b.itemType = 0 THEN (c.qty * b.rate) ELSE 0 END))* a.chargesValue/100) + ((SUM(CASE WHEN b.itemType = 0 THEN (c.qty * b.rate) ELSE 0 END))* a.insuranceValue/100) + ((SUM(CASE WHEN b.itemType = 0 THEN (c.qty * b.rate) ELSE 0 END))* a.errectionValue/100) + (SUM(CASE WHEN b.itemType = 0 THEN (c.qty * b.rate) ELSE 0 END) + ((SUM(CASE WHEN b.itemType = 0 THEN (c.qty * b.rate) ELSE 0 END))* a.packingValue/100) + ((SUM(CASE WHEN b.itemType = 0 THEN (c.qty * b.rate) ELSE 0 END))* a.chargesValue/100) + ((SUM(CASE WHEN b.itemType = 0 THEN (c.qty * b.rate) ELSE 0 END))* a.insuranceValue/100) + ((SUM(CASE WHEN b.itemType = 0 THEN (c.qty * b.rate) ELSE 0 END))* a.errectionValue/100))* a.igstValue/100 as total_m,"
                + " SUM(CASE WHEN b.itemType = 1 THEN (c.qty * b.rate) ELSE 0 END) + ((SUM(CASE WHEN b.itemType = 1 THEN (c.qty * b.rate) ELSE 0 END))* a.serviceGst/100) AS total_type2, "
                + " ("
                + " SUM(CASE WHEN b.itemType = 0 THEN (c.qty * b.rate) ELSE 0 END) +"
                + " SUM(CASE WHEN b.itemType = 1 THEN (c.qty * b.rate) ELSE 0 END) "
                + " ) AS total_amount, "
                + " ("
                + " SUM(CASE WHEN b.itemType = 0 THEN (c.qty * b.rate) ELSE 0 END) + ((SUM(CASE WHEN b.itemType = 0 THEN (c.qty * b.rate) ELSE 0 END))* a.packingValue/100) + ((SUM(CASE WHEN b.itemType = 0 THEN (c.qty * b.rate) ELSE 0 END))* a.chargesValue/100) + ((SUM(CASE WHEN b.itemType = 0 THEN (c.qty * b.rate) ELSE 0 END))* a.insuranceValue/100) + ((SUM(CASE WHEN b.itemType = 0 THEN (c.qty * b.rate) ELSE 0 END))* a.errectionValue/100) + (SUM(CASE WHEN b.itemType = 0 THEN (c.qty * b.rate) ELSE 0 END) + ((SUM(CASE WHEN b.itemType = 0 THEN (c.qty * b.rate) ELSE 0 END))* a.packingValue/100) + ((SUM(CASE WHEN b.itemType = 0 THEN (c.qty * b.rate) ELSE 0 END))* a.chargesValue/100) + ((SUM(CASE WHEN b.itemType = 0 THEN (c.qty * b.rate) ELSE 0 END))* a.insuranceValue/100) + ((SUM(CASE WHEN b.itemType = 0 THEN (c.qty * b.rate) ELSE 0 END))* a.errectionValue/100))* a.igstValue/100 + "
                + "     SUM(CASE WHEN b.itemType = 1 THEN (c.qty * b.rate) ELSE 0 END) + ((SUM(CASE WHEN b.itemType = 1 THEN (c.qty * b.rate) ELSE 0 END))* a.serviceGst/100) "
                + "   ) AS total_amount_with_tax "
                + "  FROM ReviseVendorTenderBid a, ReviseVendorTenderBidItem b, TenderItemMaster c"
                + " WHERE a.refNo = b.refNo and "
                + " a.vendorCode = b.vendorCode and a.vendorCode = '" + vendor_code + "' and b.vendorCode = '" + vendor_code + "'"
                + " and b.srNo = c.srNo and b.itemType = c.itemType and a.refNo = '" + refNo + "' and c.refNo = '" + refNo + "' "
                + " GROUP BY a.refNo, a.vendorCode";
        return getHibernateTemplate().find(query);
    }
}
