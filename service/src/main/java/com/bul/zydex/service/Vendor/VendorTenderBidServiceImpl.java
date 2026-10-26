/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Vendor;

import com.bul.zydex.dao.Vendor.VendorTenderBidDao;
import com.bul.zydex.model.VendorTenderBid;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class VendorTenderBidServiceImpl<T> extends GenericsServiceImpl<T> implements VendorTenderBidService<T> {

    private VendorTenderBidDao<T> vendorTenderBidDao;

    public VendorTenderBidDao<T> getVendorTenderBidDao() {
        return vendorTenderBidDao;
    }

    public void setVendorTenderBidDao(VendorTenderBidDao<T> vendorTenderBidDao) {
        this.vendorTenderBidDao = vendorTenderBidDao;
        setGenericsDAO(vendorTenderBidDao);
    }

    @Override
    public VendorTenderBid readByVendorRefNo(String refNo, String username) {
        return vendorTenderBidDao.readByVendorRefNo(refNo, username);
    }

    @Override
    public List readVendorRefNo(String refNo, String username) {
        return vendorTenderBidDao.readVendorRefNo(refNo, username);
    }

    @Override
    public void updateVendorOffer(String refNo, String username, String offer_no, String offer_date, String contact_person, String contact_no, String contact_email, String gst_no) {
        vendorTenderBidDao.updateVendorOffer(refNo, username, offer_no, offer_date, contact_person, contact_no, contact_email, gst_no);
    }

    @Override
    public void updateVendorItem(String refNo, String username, String common_tax, String discount_val, String discount, String packing_val, String packing, String freight_val, String freight, String errection, String other_charges, String igst, String cgst, String sgst, String insurance_value, String total_amount, String grand_total, String venodr_total_words) {
        vendorTenderBidDao.updateVendorItem(refNo, username, common_tax, discount_val, discount, packing_val, packing, freight_val, freight, errection, other_charges, igst, cgst, sgst, insurance_value, total_amount, grand_total, venodr_total_words);
    }

    @Override
    public void updateVendorCondition(String refNo, String username, int revision, String delivery_location, String delivery_period, String terms_of_payment, String validity_period, String mode_of_transport, String inco_terms, String insurance, String freight, String vendor_remark) {
        vendorTenderBidDao.updateVendorCondition(refNo, username, revision, delivery_location, delivery_period, terms_of_payment, validity_period, mode_of_transport, inco_terms, insurance, freight, vendor_remark);
    }

    @Override
    public void updateTotal(String refNo, String username, Double total) {
        vendorTenderBidDao.updateTotal(refNo, username, total);
    }

    @Override
    public List vendorList(String refNo) {
        return vendorTenderBidDao.vendorList(refNo);
    }

    @Override
    public List priceBidList(String refNo) {
        return vendorTenderBidDao.priceBidList(refNo);
    }

    @Override
    public List priceBidOpenList(String refNo) {
        return vendorTenderBidDao.priceBidOpenList(refNo);
    }

    @Override
    public void openPriceBid(String refNo, String vendor_list, String user_by, String user_by_id, String formattedDate) {
        vendorTenderBidDao.openPriceBid(refNo, vendor_list, user_by, user_by_id, formattedDate);
    }

    @Override
    public List priceBidOpenList1(String refNo) {
        return vendorTenderBidDao.priceBidOpenList1(refNo);
    }

    @Override
    public List vendorList1(String tender_no) {
        return vendorTenderBidDao.vendorList1(tender_no);
    }

    @Override
    public List readByVendor(String vendor_code) {
        return vendorTenderBidDao.readByVendor(vendor_code);
    }

    @Override
    public List vendorL1List(String refNo) {
        return vendorTenderBidDao.vendorL1List(refNo);
    }

    @Override
    public List readByVendorBid(String username) {
        return vendorTenderBidDao.readByVendorBid(username);
    }

    @Override
    public void updateVendorConditionSave(String refNo, String username, int revision, String delivery_location, String delivery_period, String terms_of_payment, String validity_period, String mode_of_transport, String inco_terms, String insurance, String freight, String vendor_remark) {
        vendorTenderBidDao.updateVendorConditionSave(refNo, username, revision, delivery_location, delivery_period, terms_of_payment, validity_period, mode_of_transport, inco_terms, insurance, freight, vendor_remark);
    }

    @Override
    public void updateReviseDate(String refNo, String checkedValues, String datetime, String remark) {
        vendorTenderBidDao.updateReviseDate(refNo, checkedValues, datetime, remark);
    }

    @Override
    public List priceBidList1(String refNo) {
        return vendorTenderBidDao.priceBidList1(refNo);
    }

    @Override
    public List priceBidOpenList2(String refNo) {
        return vendorTenderBidDao.priceBidOpenList2(refNo);
    }

    @Override
    public void updateVendorServiceItem(String refNo, String username, String discount_val, String discount, String igst, String total_amount, String grand_total) {
        vendorTenderBidDao.updateVendorServiceItem(refNo, username, discount_val, discount, igst, total_amount, grand_total);
    }

    @Override
    public List vendorTechBidList(String refNo) {
        return vendorTenderBidDao.vendorTechBidList(refNo);
    }

    @Override
    public List vendorTechBidList1(String tender_no) {
        return vendorTenderBidDao.vendorTechBidList1(tender_no);
    }

    @Override
    public List readByVendorFlag(String refNo) {
        return vendorTenderBidDao.readByVendorFlag(refNo);
    }

    @Override
    public List reviseBidList(String refNo) {
        return vendorTenderBidDao.reviseBidList(refNo);
    }

    @Override
    public List readByVendorAward(String username) {
        return vendorTenderBidDao.readByVendorAward(username);
    }

    @Override
    public void readByDelete(String refNo, String username) {
        vendorTenderBidDao.readByDelete(refNo, username);
    }

    @Override
    public List vendorBidPrice(String refNo) {
        return vendorTenderBidDao.vendorBidPrice(refNo);
    }

    @Override
    public List priceBidOpenListPrSummary(String refNo) {
        return vendorTenderBidDao.priceBidOpenListPrSummary(refNo);
    }

}
