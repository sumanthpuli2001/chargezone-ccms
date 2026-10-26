/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Tender;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.ServiceVendorTenderBidItem;
import java.util.List;
/**
 *
 * @author admin
 */
public interface ServiceVendorTenderBidItemDao<T> extends GenericsDAO<T> {

    public List readVendorRefNo(String file_name, String username, String refNo);

    public List readItemVendorRefNo(String refNo, String username, String file_name, String sr_no);

    public void updateItemVendorRefNo(String refNo, String username, String file_name, String sr_no, String item_description, String item_remark, String uom, String qty, String unit_rate, String net_rate, String hsn_no, String vendor_remark, String item_discount_val, String item_discount, String item_packing_val, String item_packing, String item_freight_val, String item_freight, String item_errection, String item_other_charge, String item_igst, String item_cgst, String item_sgst, String item_insurance_value, String item_total, String item_regret);

    public ServiceVendorTenderBidItem readByVendorRefNo(String refNo, String username, String file_name, String sr_no1);

    public void updateItemVendorRefNo1(String refNo, String username, String file_name, String sr_no1, String discount_val, String discount, String packing_val, String packing, String freight_val, String freight, String errection, String other_charges, String igst, String cgst, String sgst, String insurance_value1, String grand_total1);
    
}
