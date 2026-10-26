/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Vendor;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.VendorTenderBidItem;
import java.util.List;
/**
 *
 * @author admin
 */
public interface VendorTenderBidItemDao<T> extends GenericsDAO<T> {

    public List readByVendorRefNo(String refNo, String username);

    public List readItemVendorRefNo(String refNo, String username, String item_code, int item_type);

    public void updateItemVendorRefNo(String refNo, String username, String item_code, String item_description, String item_remark, String uom, String qty, String attachment_required, String delivery_schedule_date, String delivery_schedule_qty, String item_location, String pur_no, String item_no, String unit_rate, String net_rate, String hsn_no, String vendor_remark, String item_discount_val, String item_discount, String item_packing_val, String item_packing, String item_freight_val, String item_freight, String item_errection, String item_other_charge, String item_igst, String item_cgst, String item_sgst, String item_insurance_value, String item_total, String item_regret);

    public VendorTenderBidItem readByVendorRefNo(String refNo, String username, String item_code1);

    public void updateItem(String refNo, String username, String item_code, String discount_val, String discount, String packing_val, String packing, String freight_val, String freight, String errection, String other_charges, String igst, String cgst, String sgst, String insurance_value1, String grand_total1);

    public List readByItemSrNoVendorRefNo(String refNo, String vendor_code1, String sr_no);

    public List readByItemCode(String item_code);

    public List readByVendorRefNoAndItemType(String refNo, String username, int item_type);

    public void updateItemVendorRefNo1(String refNo, String username, String sr_no, String item_description, String item_remark, String uom, String qty, String attachment_required, String delivery_schedule_date, String delivery_schedule_qty, String item_location, String pur_no, String item_no, String unit_rate, String net_rate, String vendor_remark, String item_discount_val, String item_discount, String item_packing_val, String item_packing, String item_freight_val, String item_freight, String item_errection, String item_other_charge, String item_igst, String item_cgst, String item_sgst, String item_insurance_value, String item_total, String item_regret);

    public List readByVendorRefNoAndItemType1(String refNo, String vendor_code, int item_type);
    
}
