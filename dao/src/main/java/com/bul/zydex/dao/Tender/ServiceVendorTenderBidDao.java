/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Tender;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.ServiceVendorTenderBid;
import java.util.List;
/**
 *
 * @author admin
 */
public interface ServiceVendorTenderBidDao<T> extends GenericsDAO<T> {

    public List readVendorRefNo(String file_name, String username, String refNo);

    public void updateVendorTenderBid(String refNo, String username, String file_name, String common_tax, String discount_val, String discount, String packing_val, String packing, String freight_val, String freight, String errection, String other_charges, String igst, String cgst, String sgst, String insurance_value, String total_amount, String grand_total);

    public List readVendorRefNo2(String username, String refNo);
    
}
