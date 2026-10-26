/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Vendor;

import com.bul.zydex.dao.Vendor.VendorTenderBidItemDao;
import com.bul.zydex.model.VendorTenderBidItem;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class VendorTenderBidItemServiceImpl<T> extends GenericsServiceImpl<T> implements VendorTenderBidItemService<T> {
    
    private VendorTenderBidItemDao<T> vendorTenderBidItemDao;

    public VendorTenderBidItemDao<T> getVendorTenderBidItemDao() {
        return vendorTenderBidItemDao;
    }

    public void setVendorTenderBidItemDao(VendorTenderBidItemDao<T> vendorTenderBidItemDao) {
        this.vendorTenderBidItemDao = vendorTenderBidItemDao;
        setGenericsDAO(vendorTenderBidItemDao);
    }

    @Override
    public List readByVendorRefNo(String refNo, String username) {
        return vendorTenderBidItemDao.readByVendorRefNo(refNo, username);
    }

    @Override
    public List readItemVendorRefNo(String refNo, String username, String item_code, int item_type) {
        return vendorTenderBidItemDao.readItemVendorRefNo(refNo, username, item_code, item_type);
    }

    @Override
    public void updateItemVendorRefNo(String refNo, String username, String item_code, String item_description, String item_remark, String uom, String qty, String attachment_required, String delivery_schedule_date, String delivery_schedule_qty, String item_location, String pur_no, String item_no, String unit_rate, String net_rate, String hsn_no, String vendor_remark, String item_discount_val, String item_discount, String item_packing_val, String item_packing, String item_freight_val, String item_freight, String item_errection, String item_other_charge, String item_igst, String item_cgst, String item_sgst, String item_insurance_value, String item_total, String item_regret) {
        vendorTenderBidItemDao.updateItemVendorRefNo(refNo, username, item_code, item_description, item_remark, uom, qty, attachment_required, delivery_schedule_date, delivery_schedule_qty, item_location, pur_no, item_no, unit_rate, net_rate, hsn_no, vendor_remark, item_discount_val, item_discount, item_packing_val, item_packing, item_freight_val, item_freight, item_errection, item_other_charge, item_igst, item_cgst, item_sgst, item_insurance_value, item_total, item_regret);
    }

    @Override
    public VendorTenderBidItem readByVendorRefNo(String refNo, String username, String item_code1) {
        return vendorTenderBidItemDao.readByVendorRefNo(refNo,username, item_code1);
    }

    @Override
    public void updateItem(String refNo, String username, String item_code, String discount_val, String discount, String packing_val, String packing, String freight_val, String freight, String errection, String other_charges, String igst, String cgst, String sgst, String insurance_value1, String grand_total1) {
        vendorTenderBidItemDao.updateItem(refNo, username, item_code, discount_val, discount, packing_val, packing, freight_val, freight, errection, other_charges, igst, cgst, sgst, insurance_value1, grand_total1);
    }

    @Override
    public List readByItemSrNoVendorRefNo(String refNo, String vendor_code1, String sr_no) {
        return vendorTenderBidItemDao.readByItemSrNoVendorRefNo(refNo, vendor_code1, sr_no);
    }

    @Override
    public List readByItemCode(String item_code) {
        return vendorTenderBidItemDao.readByItemCode(item_code);
    }

    @Override
    public List readByVendorRefNoAndItemType(String refNo, String username, int item_type) {
        return vendorTenderBidItemDao.readByVendorRefNoAndItemType(refNo, username, item_type);
    }

    @Override
    public void updateItemVendorRefNo1(String refNo, String username, String sr_no, String item_description, String item_remark, String uom, String qty, String attachment_required, String delivery_schedule_date, String delivery_schedule_qty, String item_location, String pur_no, String item_no, String unit_rate, String net_rate, String string, String vendor_remark, String item_discount_val, String item_discount, String item_packing_val, String item_packing, String item_freight_val, String item_freight, String item_errection, String item_other_charge, String item_igst, String item_cgst, String item_sgst, String item_insurance_value, String item_total, String item_regret) {
        vendorTenderBidItemDao.updateItemVendorRefNo1(refNo, username, sr_no, item_description, item_remark, uom, qty, attachment_required, delivery_schedule_date, delivery_schedule_qty, item_location, pur_no, item_no, unit_rate, net_rate, vendor_remark, item_discount_val, item_discount, item_packing_val, item_packing, item_freight_val, item_freight, item_errection, item_other_charge, item_igst, item_cgst, item_sgst, item_insurance_value, item_total, item_regret);
    }

    @Override
    public List readByVendorRefNoAndItemType1(String refNo, String vendor_code, int item_type) {
        return vendorTenderBidItemDao.readByVendorRefNoAndItemType1(refNo, vendor_code, item_type);
    }
}
