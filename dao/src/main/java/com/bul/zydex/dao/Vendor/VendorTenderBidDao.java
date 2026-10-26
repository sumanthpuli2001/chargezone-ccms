/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Vendor;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.VendorTenderBid;
import java.util.List;

/**
 *
 * @author admin
 */
public interface VendorTenderBidDao<T> extends GenericsDAO<T> {

    public VendorTenderBid readByVendorRefNo(String refNo, String username);

    public List readVendorRefNo(String refNo, String username);

    public void updateVendorOffer(String refNo, String username, String offer_no, String offer_date, String contact_person, String contact_no, String contact_email, String gst_no);

    public void updateVendorItem(String refNo, String username, String common_tax, String discount_val, String discount, String packing_val, String packing, String freight_val, String freight, String errection, String other_charges, String igst, String cgst, String sgst, String insurance_value, String total_amount, String grand_total, String venodr_total_words);

    public void updateVendorCondition(String refNo, String username, int revision, String delivery_location, String delivery_period, String terms_of_payment, String validity_period, String mode_of_transport, String inco_terms, String insurance, String freight, String vendor_remark);

    public void updateTotal(String refNo, String username, Double total);

    public List vendorList(String refNo);

    public List priceBidList(String refNo);

    public List priceBidOpenList(String refNo);

    public void openPriceBid(String refNo, String vendor_list, String user_by, String user_by_id, String formattedDate);

    public List priceBidOpenList1(String refNo);

    public List vendorList1(String tender_no);

    public List readByVendor(String vendor_code);

    public List vendorL1List(String refNo);

    public List readByVendorBid(String username);

    public void updateVendorConditionSave(String refNo, String username, int revision, String delivery_location, String delivery_period, String terms_of_payment, String validity_period, String mode_of_transport, String inco_terms, String insurance, String freight, String vendor_remark);

    public void updateReviseDate(String refNo, String checkedValues, String datetime, String remark);

    public List priceBidList1(String refNo);

    public List priceBidOpenList2(String refNo);

    public void updateVendorServiceItem(String refNo, String username, String discount_val, String discount, String igst, String total_amount, String grand_total);

    public List vendorTechBidList(String refNo);

    public List vendorTechBidList1(String tender_no);

    public List readByVendorFlag(String refNo);

    public List reviseBidList(String refNo);

    public List readByVendorAward(String username);

    public void readByDelete(String refNo, String username);

    public List vendorBidPrice(String refNo);

    public List priceBidOpenListPrSummary(String refNo);

  
    
}
