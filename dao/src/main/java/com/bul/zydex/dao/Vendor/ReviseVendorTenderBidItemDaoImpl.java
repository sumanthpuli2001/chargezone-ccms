/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Vendor;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.ReviseVendorTenderBidItem;
import java.util.List;
import org.hibernate.Query;
/**
 *
 * @author admin
 */
public class ReviseVendorTenderBidItemDaoImpl<T> extends GenericsDAOImpl<T> implements ReviseVendorTenderBidItemDao<T> {
    
    @Override
    protected Class getDomainClass() {
        return ReviseVendorTenderBidItem.class;
    }

    @Override
    public List readByVendorRefNo(String refNo, String username) {
        String query = "";
        query += " FROM ReviseVendorTenderBidItem a"
                + " WHERE a.refNo = '" + refNo + "' and a.vendorCode = '"+username+"' order by a.id";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readItemVendorRefNo(String refNo, String username, String item_code) {
        String query = "";
        query += " FROM ReviseVendorTenderBidItem a"
                + " WHERE a.refNo = '" + refNo + "' and a.vendorCode = '"+username+"' and a.srNo= '"+item_code+"'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void updateItemVendorRefNo(String refNo, String username, String item_code, String item_description, String item_remark, String uom, String qty, String attachment_required, String delivery_schedule_date, String delivery_schedule_qty, String item_location, String pur_no, String item_no, String unit_rate, String net_rate, String hsn_no, String vendor_remark, String item_discount_val, String item_discount, String item_packing_val, String item_packing, String item_freight_val, String item_freight, String item_errection, String item_other_charge, String item_igst, String item_cgst, String item_sgst, String item_insurance_value, String item_total, String item_regret) {
        String query = "";
            query += " update ReviseVendorTenderBidItem a"
                + " set a.rate='"+unit_rate+"', "
                + " a.netRate='"+net_rate+"', "
                + " a.hsnNo='"+hsn_no+"', "
                + " a.vendorRemark='"+vendor_remark+"', "
                + " a.discountType='"+item_discount_val+"', "
                + " a.discountValue='"+item_discount+"', "
                + " a.packingType='"+item_packing_val+"', "
                + " a.packingValue='"+item_packing+"', "
                + " a.freightType='"+item_freight_val+"', "
                + " a.freightValue='"+item_freight+"', "
                + " a.errectionValue='"+item_errection+"', "
                + " a.chargesValue='"+item_other_charge+"', "
                + " a.igstValue='"+item_igst+"', "
                + " a.cgstValue='"+item_cgst+"', "
                + " a.sgstValue='"+item_sgst+"', "
                + " a.insuranceValue='"+item_insurance_value+"', "
                + " a.totalValue='"+item_total+"', "
                + " a.itemRegret='"+item_regret+"' "
                + " WHERE a.refNo = '" + refNo + "' and a.vendorCode = '"+username+"' and a.srNo= '"+item_code+"'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public ReviseVendorTenderBidItem readByVendorRefNo1(String refNo, String username, String item_code1) {
        ReviseVendorTenderBidItem reviseVendorTenderBidItem = new ReviseVendorTenderBidItem();
        String query = "";
        query += " FROM ReviseVendorTenderBidItem a"
                + " WHERE a.refNo = '" + refNo + "' and a.vendorCode = '"+username+"' and a.srNo = '"+item_code1+"'";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            reviseVendorTenderBidItem = (ReviseVendorTenderBidItem) list.get(0);
        }
        return reviseVendorTenderBidItem;
    }

    @Override
    public void updateItem(String refNo, String username, String item_code, String discount_val, String discount, String packing_val, String packing, String freight_val, String freight, String errection, String other_charges, String igst, String cgst, String sgst, String insurance_value1, String grand_total1) {
        String query = "";
            query += " update ReviseVendorTenderBidItem a"
                + " set a.discountType='"+discount_val+"', "
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
                + " a.insuranceValue='"+insurance_value1+"', "
                + " a.totalValue='"+grand_total1+"' "
                + " WHERE a.refNo = '" + refNo + "' and a.vendorCode = '"+username+"' and a.srNo= '"+ item_code+"'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public List readByItemSrNoVendorRefNo(String refNo, String vendor_code1, String sr_no) {
        String query = "";
        query += " FROM ReviseVendorTenderBidItem a"
                + " WHERE a.refNo = '" + refNo + "' and a.vendorCode = '"+vendor_code1+"' and a.srNo= '"+sr_no+"'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByVendorRefNoAndItemType(String refNo, String username, int item_type) {
        String query = "";
        query += " FROM ReviseVendorTenderBidItem a"
                + " WHERE a.refNo = '" + refNo + "' and a.vendorCode = '"+username+"' and a.itemType="+item_type+" order by a.id";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readItemVendorRefNoByItemType(String refNo, String username, String sr_no, int item_type1) {
         String query = "";
        query += " FROM ReviseVendorTenderBidItem a"
                + " WHERE a.refNo = '" + refNo + "' and a.vendorCode = '"+username+"' and a.srNo= '"+sr_no+"' and a.itemType = '"+item_type1+"'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readItemVendorRefNoByItemWise(String refNo, String username, String sr_no, int item_type) {
        String query = "";
        query += " FROM ReviseVendorTenderBidItem a"
                + " WHERE a.refNo = '" + refNo + "' and a.vendorCode = '"+username+"' and a.srNo= '"+sr_no+"' and a.itemType = '"+item_type+"'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void updateItemVendorRefNoByItemType(String refNo, String username, String sr_no, String item_description, String item_remark, String uom, String qty, String attachment_required, String delivery_schedule_date, String delivery_schedule_qty, String item_location, String pur_no, String item_no, String unit_rate, String net_rate, String hsn_no, String vendor_remark, String item_discount_val, String item_discount, String item_packing_val, String item_packing, String item_freight_val, String item_freight, String item_errection, String item_other_charge, String item_igst, String item_cgst, String item_sgst, String item_insurance_value, String item_total, String item_regret, int item_type) {
        String query = "";
            query += " update ReviseVendorTenderBidItem a"
                + " set a.rate='"+unit_rate+"', "
                + " a.netRate='"+net_rate+"', "
                + " a.hsnNo='"+hsn_no+"', "
                + " a.vendorRemark='"+vendor_remark+"', "
                + " a.discountType='"+item_discount_val+"', "
                + " a.discountValue='"+item_discount+"', "
                + " a.packingType='"+item_packing_val+"', "
                + " a.packingValue='"+item_packing+"', "
                + " a.freightType='"+item_freight_val+"', "
                + " a.freightValue='"+item_freight+"', "
                + " a.errectionValue='"+item_errection+"', "
                + " a.chargesValue='"+item_other_charge+"', "
                + " a.igstValue='"+item_igst+"', "
                + " a.cgstValue='"+item_cgst+"', "
                + " a.sgstValue='"+item_sgst+"', "
                + " a.insuranceValue='"+item_insurance_value+"', "
                + " a.totalValue='"+item_total+"', "
                + " a.itemRegret='"+item_regret+"' "
                + " WHERE a.refNo = '" + refNo + "' and a.vendorCode = '"+username+"' and a.srNo= '"+sr_no+"' and a.itemType = '"+item_type+"'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public List readByVendorRefNoAndItemType1(String refNo, String vendor_code, int item_type) {
        String query = "";
        query += "Select a.srNo, a.itemCode, a.itemDescription, a.uom, b.qty, a.rate, (b.qty * a.rate) as netRate  FROM ReviseVendorTenderBidItem a , TenderItemMaster b"
		+ " WHERE a.refNo = '" + refNo + "' and a.vendorCode = '" + vendor_code + "' and a.itemType=" + item_type + " "
                + " and b.itemType=" + item_type + " and a.srNo = b.srNo and b.refNo = '" + refNo + "' order by a.id";
        return getHibernateTemplate().find(query);
    }
}
