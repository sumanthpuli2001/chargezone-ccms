/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Tender;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.ServiceVendorTenderBidItem;
import java.util.List;
import org.hibernate.Query;
/**
 *
 * @author admin
 */
public class ServiceVendorTenderBidItemDaoImpl<T> extends GenericsDAOImpl<T> implements ServiceVendorTenderBidItemDao<T> {
    
    @Override
    protected Class getDomainClass() {
        return ServiceVendorTenderBidItem.class;
    }

    @Override
    public List readVendorRefNo(String file_name, String username, String refNo) {
        String query = "";
        query += " FROM ServiceVendorTenderBidItem a"
                + " WHERE a.vendorCode = '" + username + "' and a.tenderNo = '" + refNo + "' and a.fileName = '"+file_name+"'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readItemVendorRefNo(String refNo, String username, String file_name, String sr_no) {
        String query = "";
        query += " FROM ServiceVendorTenderBidItem a"
                + " WHERE a.vendorCode = '" + username + "' and a.tenderNo = '" + refNo + "' and a.fileName = '"+file_name+"' and a.srNo = '"+sr_no+"'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void updateItemVendorRefNo(String refNo, String username, String file_name, String sr_no, String item_description, String item_remark, String uom, String qty, String unit_rate, String net_rate, String hsn_no, String vendor_remark, String item_discount_val, String item_discount, String item_packing_val, String item_packing, String item_freight_val, String item_freight, String item_errection, String item_other_charge, String item_igst, String item_cgst, String item_sgst, String item_insurance_value, String item_total, String item_regret) {
        String query = "";
        query += " update ServiceVendorTenderBidItem a"
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
                + " WHERE a.vendorCode = '" + username + "' and a.tenderNo = '" + refNo + "' and a.fileName = '"+file_name+"' and a.srNo = '"+sr_no+"'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public ServiceVendorTenderBidItem readByVendorRefNo(String refNo, String username, String file_name, String sr_no1) {
        ServiceVendorTenderBidItem serviceVendorTenderBidItem = new ServiceVendorTenderBidItem();
        String query = "";
        query += " FROM ServiceVendorTenderBidItem a"
                + " WHERE a.tenderNo = '" + refNo + "' and a.vendorCode = '"+username+"' and a.fileName = '"+file_name+"' and a.srNo = '"+sr_no1+"'";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            serviceVendorTenderBidItem = (ServiceVendorTenderBidItem) list.get(0);
        }
        return serviceVendorTenderBidItem;
    }

    @Override
    public void updateItemVendorRefNo1(String refNo, String username, String file_name, String sr_no1, String discount_val, String discount, String packing_val, String packing, String freight_val, String freight, String errection, String other_charges, String igst, String cgst, String sgst, String insurance_value1, String grand_total1) {
        String query = "";
        query += " update ServiceVendorTenderBidItem a"
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
                + " WHERE a.vendorCode = '" + username + "' and a.tenderNo = '" + refNo + "' and a.fileName = '"+file_name+"' and a.srNo = '"+sr_no1+"'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }
}
