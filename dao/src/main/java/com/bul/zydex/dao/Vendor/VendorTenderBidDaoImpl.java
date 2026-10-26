/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Vendor;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.VendorTenderBid;
import com.bul.zydex.model.VendorMaster;
import com.bul.zydex.model.TenderMaster;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author admin
 */
public class VendorTenderBidDaoImpl<T> extends GenericsDAOImpl<T> implements VendorTenderBidDao<T> {

    @Override
    protected Class getDomainClass() {
        return VendorTenderBid.class;
    }

    @Override
    public VendorTenderBid readByVendorRefNo(String refNo, String username) {
        VendorTenderBid vendorTenderBid = new VendorTenderBid();
        String query = "";
        query += " FROM VendorTenderBid a"
                + " WHERE a.refNo = '" + refNo + "' and a.vendorCode = '" + username + "'";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            vendorTenderBid = (VendorTenderBid) list.get(0);
        }
        return vendorTenderBid;
    }

    @Override
    public List readVendorRefNo(String refNo, String username) {
        String query = "";
        query += " FROM VendorTenderBid a"
                + " WHERE a.refNo = '" + refNo + "' and a.vendorCode = '" + username + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void updateVendorOffer(String refNo, String username, String offer_no, String offer_date, String contact_person, String contact_no, String contact_email, String gst_no) {
        String query = "";
        query += " update VendorTenderBid a"
                + " set a.offerNo='" + offer_no + "', "
                + " a.offerDate='" + offer_date + "', "
                + " a.contactPerson='" + contact_person + "', "
                + " a.contactNo='" + contact_no + "', "
                + " a.conactEmail='" + contact_email + "', "
                + " a.gstNo='" + gst_no + "' "
                + " WHERE a.refNo = '" + refNo + "' and a.vendorCode = '" + username + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();

    }

    @Override
    public void updateVendorItem(String refNo, String username, String common_tax, String discount_val, String discount, String packing_val, String packing, String freight_val, String freight, String errection, String other_charges, String igst, String cgst, String sgst, String insurance_value, String total_amount, String grand_total, String venodr_total_words) {
        String query = "";
        query += " update VendorTenderBid a"
                + " set a.discountType='" + discount_val + "', "
                + " a.selectCommon='" + common_tax + "', "
                + " a.discountValue='" + discount + "', "
                + " a.packingType='" + packing_val + "', "
                + " a.packingValue='" + packing + "', "
                + " a.freightType='" + freight_val + "', "
                + " a.freightValue='" + freight + "', "
                + " a.errectionValue='" + errection + "', "
                + " a.chargesValue='" + other_charges + "', "
                + " a.igstValue='" + igst + "', "
                + " a.cgstValue='" + cgst + "', "
                + " a.sgstValue='" + sgst + "', "
                + " a.insuranceValue='" + insurance_value + "', "
                + " a.itemTotal='" + total_amount + "', "
                + " a.grandTotal='" + grand_total + "', "
                + " a.grandTotalWord='" + venodr_total_words + "' "
                + " WHERE a.refNo = '" + refNo + "' and a.vendorCode = '" + username + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();

    }

    @Override
    public void updateVendorCondition(String refNo, String username, int revision, String delivery_location, String delivery_period, String terms_of_payment, String validity_period, String mode_of_transport, String inco_terms, String insurance, String freight, String vendor_remark) {

        String query = "";
        query += " update VendorTenderBid a"
                + " set a.deliveryLocation='" + delivery_location + "', "
                + " a.deliveryPeriod='" + delivery_period + "', "
                + " a.revision='" + revision + "', "
                + " a.termsOfPayment='" + terms_of_payment + "', "
                + " a.validityPeriod='" + validity_period + "', "
                + " a.modeOfTransport='" + mode_of_transport + "', "
                + " a.incoTerms='" + inco_terms + "', "
                + " a.insurance='" + insurance + "', "
                + " a.freight='" + freight + "', "
                + " a.submitFlag='1', "
                + " a.remarkByVendor='" + vendor_remark.replace("'", "''") + "' "
                + " WHERE a.refNo = '" + refNo + "' and a.vendorCode = '" + username + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public void updateTotal(String refNo, String username, Double total) {
        String query = "";
        query += " update VendorTenderBid a"
                + " set a.grandTotal='" + total + "' "
                + " WHERE a.refNo = '" + refNo + "' and a.vendorCode = '" + username + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public List vendorList(String refNo) {
        String query = "";
        query += " FROM VendorTenderBid a"
                + " WHERE a.refNo = '" + refNo + "' and a.submitFlag = '1'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List priceBidList(String refNo) {
        String query = "";
        query += "select a.refNo, a.vendorCode, b.vendorName, b.vendorAddressLine1, b.vendorMobNo, b.vendorEmailID FROM  VendorTenderBid a, VendorMaster b "
                + " WHERE a.refNo = '" + refNo + "' and (a.bidOpenFlag!='1' or a.bidOpenFlag is null) and a.submitFlag = 1 and a.vendorCode=b.vendorRegNo";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List priceBidOpenList(String refNo) {
        String query = "";
        query += "select a.refNo, a.vendorCode, b.vendorName, b.vendorAddressLine1, b.vendorMobNo, b.vendorEmailID, a.reviseStatus, a.finalTotal  FROM VendorTenderBid a, VendorMaster b"
                + " WHERE a.refNo = '" + refNo + "' and a.bidOpenFlag='1' and a.vendorCode=b.vendorRegNo";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void openPriceBid(String refNo, String vendor_list, String user_by, String user_by_id, String formattedDate) {
        String query = "";
        query += " update VendorTenderBid a"
                + " set a.bidOpenDate='" + formattedDate + "', "
                + " a.bidOpenBy='" + user_by + "', "
                + " a.bidOpenById='" + user_by_id + "', "
                + " a.bidOpenFlag='1' "
                + " WHERE a.refNo = '" + refNo + "' and a.vendorCode = '" + vendor_list + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public List priceBidOpenList1(String refNo) {
        String query = "";
        query += " FROM VendorTenderBid a "
                + " WHERE a.refNo = '" + refNo + "' and a.bidOpenFlag='1' order by CAST(a.finalTotal AS int)";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List vendorList1(String tender_no) {
        String query = "";
        query += "select a.vendorCode, b.vendorName, b.vendorPhNo, b.vendorEmailID FROM VendorTenderBid a, VendorMaster b"
                + " WHERE a.refNo = '" + tender_no + "' and a.submitFlag = '1' and a.vendorCode=b.vendorRegNo";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByVendor(String vendor_code) {
        String query = "";
        query += " FROM VendorTenderBid a"
                + " WHERE a.submitFlag = '1' and a.vendorCode = '" + vendor_code + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List vendorL1List(String refNo) {
        String query = "";
        query += " FROM VendorTenderBid a "
                + " WHERE a.refNo = '" + refNo + "' and a.bidOpenFlag='1' order by CAST(a.finalTotal AS int)";
        return getHibernateTemplate().find(query).subList(1, 1);
    }

    @Override
    public List readByVendorBid(String username) {
        String query = "";
        query += "select a.refNo, b.title, b.announceDate, b.submitLastdate, b.tenderPhase, b.tenderType, a.reviseStatus  FROM VendorTenderBid a , TenderMaster b"
                + " WHERE a.submitFlag = '1' and a.vendorCode = '" + username + "' and a.refNo=b.refNo order by b.id desc";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void updateVendorConditionSave(String refNo, String username, int revision, String delivery_location, String delivery_period, String terms_of_payment, String validity_period, String mode_of_transport, String inco_terms, String insurance, String freight, String vendor_remark) {
        String query = "";
        query += " update VendorTenderBid a"
                + " set a.deliveryLocation='" + delivery_location + "', "
                + " a.deliveryPeriod='" + delivery_period + "', "
                + " a.revision='" + revision + "', "
                + " a.termsOfPayment='" + terms_of_payment + "', "
                + " a.validityPeriod='" + validity_period + "', "
                + " a.modeOfTransport='" + mode_of_transport + "', "
                + " a.incoTerms='" + inco_terms + "', "
                + " a.insurance='" + insurance + "', "
                + " a.freight='" + freight + "', "
                + " a.remarkByVendor='" + vendor_remark + "' "
                + " WHERE a.refNo = '" + refNo + "' and a.vendorCode = '" + username + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public void updateReviseDate(String refNo, String checkedValues, String datetime, String remark) {
        String query = "";
        remark = remark.replace("'", "''");

        query += " update VendorTenderBid a"
                + " set a.reviseDateTime='" + datetime + "', "
                + " a.reviseComment='" + remark + "' "
                //    + " a.reviseStatus='0' "
                + " WHERE a.refNo = '" + refNo + "' and a.vendorCode = '" + checkedValues + "'";

        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();

    }

    @Override
    public List priceBidList1(String refNo) {
        String query = "";
        query += " FROM  VendorTenderBid a "
                + " WHERE a.refNo = '" + refNo + "' and (a.bidOpenFlag!='1' or a.bidOpenFlag is null) and a.submitFlag = 1";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List priceBidOpenList2(String refNo) {
        String query = "";
        query += " FROM VendorTenderBid a "
                + " WHERE a.refNo = '" + refNo + "' and a.bidOpenFlag='1' order by CAST(a.finalTotal AS int)";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void updateVendorServiceItem(String refNo, String username, String discount_val, String discount, String igst, String total_amount, String grand_total) {
        String query = "";
        query += " update VendorTenderBid a"
                + " set a.serviceDiscountType='" + discount_val + "', "
                + " a.serviceDiscountValue='" + discount + "', "
                + " a.serviceGst='" + igst + "', "
                + " a.serviceTotal='" + total_amount + "', "
                + " a.serviceTaxTotal='" + grand_total + "' "
                + " WHERE a.refNo = '" + refNo + "' and a.vendorCode = '" + username + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public List vendorTechBidList(String refNo) {
        String query = "";
        query += " FROM VendorTenderBid a"
                + " WHERE a.refNo = '" + refNo + "' and a.techSubmitFlag = '1'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List vendorTechBidList1(String tender_no) {
        String query = "";
        query += "select a.vendorCode, b.vendorName, b.vendorPhNo, b.vendorEmailID FROM VendorTenderBid a, VendorMaster b"
                + " WHERE a.refNo = '" + tender_no + "' and a.techSubmitFlag = '1' and a.vendorCode=b.vendorRegNo";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByVendorFlag(String refNo) {
        String query = "";
        query += " FROM VendorTenderBid a"
                + " WHERE a.refNo = '" + refNo + "' and a.techOpenFlag = '1'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List reviseBidList(String refNo) {
        String query = "";
        query += " FROM VendorTenderBid a"
                + " WHERE a.refNo = '" + refNo + "' and a.reviseDateTime is not null";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByVendorAward(String username) {
        String query = "";
        query += "select a.refNo, b.title, b.announceDate, b.submitLastdate, b.tenderPhase, b.tenderType  FROM VendorTenderBid a , TenderMaster b"
                + " WHERE a.submitFlag = '1' and a.vendorCode = '" + username + "' and a.approveFlag=1 and a.refNo=b.refNo and b.openBidStatus=0 order by b.id desc";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void readByDelete(String refNo, String username) {

        String query = "";
        query += "delete FROM VendorTenderBid a WHERE a.refNo = '" + refNo + "' and a.vendorCode = '" + username + "'";

        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public List vendorBidPrice(String refNo) {
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
                + "   ) AS total_amount_with_tax , a.reviseStatus"
                + "  FROM VendorTenderBid a, VendorTenderBidItem b, TenderItemMaster c"
                + " WHERE a.refNo = b.refNo and "
                + " a.vendorCode = b.vendorCode"
                + " and b.srNo = c.srNo and b.itemType = c.itemType and a.refNo = '" + refNo + "' and c.refNo = '" + refNo + "' and a.bidOpenFlag='1' "
                + " GROUP BY a.refNo, a.vendorCode";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List priceBidOpenListPrSummary(String refNo) {
        String query = "SELECT t.refNo, t.vendorCode, b.vendorName, b.vendorAddressLine1, "
                + "b.vendorMobNo, b.vendorEmailID, "
                + "(SELECT a.reviseStatus FROM VendorTenderBid a "
                + " WHERE a.refNo = t.refNo AND a.vendorCode = t.vendorCode AND a.bidOpenFlag = '1'), "
                + "(SELECT a.finalTotal FROM VendorTenderBid a "
                + " WHERE a.refNo = t.refNo AND a.vendorCode = t.vendorCode AND a.bidOpenFlag = '1'), "
                + "(SELECT COUNT(a.vendorCode) FROM VendorTenderBid a "
                + " WHERE a.refNo = t.refNo AND a.vendorCode = t.vendorCode AND a.bidOpenFlag = '1') "
                + "FROM TenderVendor t, VendorMaster b "
                + "WHERE t.refNo = ? "
                + "AND t.vendorCode = b.vendorRegNo "
                + "ORDER BY t.vendorCode";

        List result = getHibernateTemplate().find(query, refNo);

        Collections.sort(result, new Comparator() {
            public int compare(Object o1, Object o2) {
                Object[] row1 = (Object[]) o1;
                Object[] row2 = (Object[]) o2;

                boolean participated1 = row1[7] != null;
                boolean participated2 = row2[7] != null;

                if (participated1 == participated2) {
                    return 0;
                }
                return participated1 ? -1 : 1;
            }
        });

        return result;
    }

}
