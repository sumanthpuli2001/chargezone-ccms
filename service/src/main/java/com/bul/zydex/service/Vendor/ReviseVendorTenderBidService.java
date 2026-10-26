/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Vendor;

import com.bul.zydex.model.ReviseVendorTenderBid;
import com.bul.zydex.service.GenericsService;
import java.util.List;
/**
 *
 * @author admin
 */
public interface ReviseVendorTenderBidService<T> extends GenericsService<T> {

    public ReviseVendorTenderBid readByVendorRefNo(String refNo, String username);

    public List readVendorRefNo(String refNo, String username);

    public void updateVendorItem(String refNo, String username, String common_tax, String discount_val, String discount, String packing_val, String packing, String freight_val, String freight, String errection, String other_charges, String igst, String cgst, String sgst, String insurance_value, String total_amount, String grand_total, String venodr_total_words);

    public void updateVendorServiceItem(String refNo, String username, String discount_val, String discount, String igst, String total_amount, String grand_total);

    public List vendorBidPrice(String refNo, String vendor_code);
    
}
