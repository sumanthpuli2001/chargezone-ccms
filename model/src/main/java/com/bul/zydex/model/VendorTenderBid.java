/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author admin
 */
public class VendorTenderBid {
    
    private int id;
    private String refNo;
    private String vendorCode;
    private int revision;
    private String offerNo;    
    private String offerDate;    
    private String contactPerson;    
    private String contactNo;    
    private String conactEmail;    
    private String gstNo;    
    private String deliveryLocation;    
    private String deliveryPeriod;    
    private String termsOfPayment;    
    private String validityPeriod;    
    private String modeOfTransport;    
    private String incoTerms;
    private String insurance;
    private String freight;
    private String remarkByVendor;
    private String itemTotal;
    private String selectCommon;
    private String discountType;
    private String discountValue;
    private String packingType;
    private String packingValue;
    private String freightType;
    private String freightValue;
    private String errectionValue;
    private String chargesValue;
    private String igstValue;
    private String cgstValue;
    private String sgstValue;
    private String insuranceValue;
    private String grandTotal;
    private String grandTotalWord;
    private String submitFlag;
    private String bidSubmitDate;
    private String flag;
    private String bidOpenDate;
    private String bidOpenBy;
    private String bidOpenById;
    private String bidOpenFlag;
    private String reviseDateTime;
    private int reviseStatus;
    private String freightFreeDelivery;
    private String freeDeliveryComment;
    private String finalTotal;
    private String reviseComment;
    private String serviceDiscountType;
    private String serviceDiscountValue;
    private String serviceGst;
    private String serviceTotal;
    private String serviceTaxTotal;
    private int techSubmitFlag;
    private int techOpenFlag;
    private int techApproveFlag;
    private int approveFlag;
        
    public VendorTenderBid() {
    }

    public VendorTenderBid(int id, String refNo, String vendorCode, int revision, String offerNo, String offerDate, String contactPerson, String contactNo, String conactEmail, String gstNo, String deliveryLocation, String deliveryPeriod, String termsOfPayment, String validityPeriod, String modeOfTransport, String incoTerms, String insurance, String freight, String remarkByVendor, String itemTotal, String selectCommon, String discountType, String discountValue, String packingType, String packingValue, String freightType, String freightValue, String errectionValue, String chargesValue, String igstValue, String cgstValue, String sgstValue, String insuranceValue, String grandTotal, String grandTotalWord, String submitFlag, String bidSubmitDate, String flag, String bidOpenDate, String bidOpenBy, String bidOpenById, String bidOpenFlag, String reviseDateTime, int reviseStatus, String freightFreeDelivery, String freeDeliveryComment, String finalTotal, String reviseComment, String serviceDiscountType, String serviceDiscountValue, String serviceGst, String serviceTotal, String serviceTaxTotal, int techSubmitFlag, int techOpenFlag, int techApproveFlag, int approveFlag) {
        this.id = id;
        this.refNo = refNo;
        this.vendorCode = vendorCode;
        this.revision = revision;
        this.offerNo = offerNo;    
        this.offerDate = offerDate;    
        this.contactPerson = contactPerson;    
        this.contactNo = contactNo;    
        this.conactEmail = conactEmail;    
        this.gstNo = gstNo;    
        this.deliveryLocation = deliveryLocation;    
        this.deliveryPeriod = deliveryPeriod;    
        this.termsOfPayment = termsOfPayment;    
        this.validityPeriod = validityPeriod;    
        this.modeOfTransport = modeOfTransport;    
        this.incoTerms = incoTerms;
        this.insurance = insurance;
        this.freight = freight;
        this.remarkByVendor = remarkByVendor;
        this.itemTotal = itemTotal;
        this.selectCommon = selectCommon;
        this.discountType = discountType;
        this.discountValue = discountValue;
        this.packingType = packingType;
        this.packingValue = packingValue;
        this.freightType = freightType;
        this.freightValue = freightValue;
        this.errectionValue = errectionValue;
        this.chargesValue = chargesValue;
        this.igstValue = igstValue;
        this.cgstValue = cgstValue;
        this.sgstValue = sgstValue;
        this.insuranceValue = insuranceValue;
        this.grandTotal = grandTotal;
        this.grandTotalWord = grandTotalWord;
        this.submitFlag = submitFlag;
        this.bidSubmitDate = bidSubmitDate;
        this.flag = flag;
        this.bidOpenDate = bidOpenDate;
        this.bidOpenBy = bidOpenBy;
        this.bidOpenById = bidOpenById;
        this.bidOpenFlag = bidOpenFlag;
        this.reviseDateTime = reviseDateTime;
        this.reviseStatus = reviseStatus;
        this.freightFreeDelivery = freightFreeDelivery;
        this.freeDeliveryComment = freeDeliveryComment;
        this.finalTotal = finalTotal;
        this.reviseComment = reviseComment;
        this.serviceDiscountType = serviceDiscountType;
        this.serviceDiscountValue = serviceDiscountValue;
        this.serviceGst = serviceGst;
        this.serviceTotal = serviceTotal;
        this.serviceTaxTotal = serviceTaxTotal;
        this.techSubmitFlag = techSubmitFlag;
        this.techOpenFlag = techOpenFlag;
        this.techApproveFlag = techApproveFlag;
        this.approveFlag = approveFlag;
    }

    public int getId() {
        return id;
    }

    public VendorTenderBid setId(int id) {
        this.id = id;
        return this;
    }

    public String getRefNo() {
        return refNo;
    }

    public VendorTenderBid setRefNo(String refNo) {
        this.refNo = refNo;
        return this;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public VendorTenderBid setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
        return this;
    }

    public int getRevision() {
        return revision;
    }

    public VendorTenderBid setRevision(int revision) {
        this.revision = revision;
        return this;
    }

    public String getOfferNo() {
        return offerNo;
    }

    public VendorTenderBid setOfferNo(String offerNo) {
        this.offerNo = offerNo;
        return this;
    }

    public String getOfferDate() {
        return offerDate;
    }

    public VendorTenderBid setOfferDate(String offerDate) {
        this.offerDate = offerDate;
        return this;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public VendorTenderBid setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
        return this;
    }

    public String getContactNo() {
        return contactNo;
    }

    public VendorTenderBid setContactNo(String contactNo) {
        this.contactNo = contactNo;
        return this;
    }

    public String getConactEmail() {
        return conactEmail;
    }

    public VendorTenderBid setConactEmail(String conactEmail) {
        this.conactEmail = conactEmail;
        return this;
    }

    public String getGstNo() {
        return gstNo;
    }

    public VendorTenderBid setGstNo(String gstNo) {
        this.gstNo = gstNo;
        return this;
    }

    public String getDeliveryLocation() {
        return deliveryLocation;
    }

    public VendorTenderBid setDeliveryLocation(String deliveryLocation) {
        this.deliveryLocation = deliveryLocation;
        return this;
    }

    public String getDeliveryPeriod() {
        return deliveryPeriod;
    }

    public VendorTenderBid setDeliveryPeriod(String deliveryPeriod) {
        this.deliveryPeriod = deliveryPeriod;
        return this;
    }

    public String getTermsOfPayment() {
        return termsOfPayment;
    }

    public VendorTenderBid setTermsOfPayment(String termsOfPayment) {
        this.termsOfPayment = termsOfPayment;
        return this;
    }

    public String getValidityPeriod() {
        return validityPeriod;
    }

    public VendorTenderBid setValidityPeriod(String validityPeriod) {
        this.validityPeriod = validityPeriod;
        return this;
    }

    public String getModeOfTransport() {
        return modeOfTransport;
    }

    public VendorTenderBid setModeOfTransport(String modeOfTransport) {
        this.modeOfTransport = modeOfTransport;
        return this;
    }

    public String getIncoTerms() {
        return incoTerms;
    }

    public VendorTenderBid setIncoTerms(String incoTerms) {
        this.incoTerms = incoTerms;
        return this;
    }

    public String getInsurance() {
        return insurance;
    }

    public VendorTenderBid setInsurance(String insurance) {
        this.insurance = insurance;
        return this;
    }

    public String getFreight() {
        return freight;
    }

    public VendorTenderBid setFreight(String freight) {
        this.freight = freight;
        return this;
    }

    public String getRemarkByVendor() {
        return remarkByVendor;
    }

    public VendorTenderBid setRemarkByVendor(String remarkByVendor) {
        this.remarkByVendor = remarkByVendor;
        return this;
    }

    public String getItemTotal() {
        return itemTotal;
    }

    public VendorTenderBid setItemTotal(String itemTotal) {
        this.itemTotal = itemTotal;
        return this;
    }

    public String getSelectCommon() {
        return selectCommon;
    }

    public VendorTenderBid setSelectCommon(String selectCommon) {
        this.selectCommon = selectCommon;
        return this;
    }

    public String getDiscountType() {
        return discountType;
    }

    public VendorTenderBid setDiscountType(String discountType) {
        this.discountType = discountType;
        return this;
    }

    public String getDiscountValue() {
        return discountValue;
    }

    public VendorTenderBid setDiscountValue(String discountValue) {
        this.discountValue = discountValue;
        return this;
    }

    public String getPackingType() {
        return packingType;
    }

    public VendorTenderBid setPackingType(String packingType) {
        this.packingType = packingType;
        return this;
    }

    public String getPackingValue() {
        return packingValue;
    }

    public VendorTenderBid setPackingValue(String packingValue) {
        this.packingValue = packingValue;
        return this;
    }

    public String getFreightType() {
        return freightType;
    }

    public VendorTenderBid setFreightType(String freightType) {
        this.freightType = freightType;
        return this;
    }

    public String getFreightValue() {
        return freightValue;
    }

    public VendorTenderBid setFreightValue(String freightValue) {
        this.freightValue = freightValue;
        return this;
    }

    public String getErrectionValue() {
        return errectionValue;
    }

    public VendorTenderBid setErrectionValue(String errectionValue) {
        this.errectionValue = errectionValue;
        return this;
    }

    public String getChargesValue() {
        return chargesValue;
    }

    public VendorTenderBid setChargesValue(String chargesValue) {
        this.chargesValue = chargesValue;
        return this;
    }

    public String getIgstValue() {
        return igstValue;
    }

    public VendorTenderBid setIgstValue(String igstValue) {
        this.igstValue = igstValue;
        return this;
    }

    public String getCgstValue() {
        return cgstValue;
    }

    public VendorTenderBid setCgstValue(String cgstValue) {
        this.cgstValue = cgstValue;
        return this;
    }

    public String getSgstValue() {
        return sgstValue;
    }

    public VendorTenderBid setSgstValue(String sgstValue) {
        this.sgstValue = sgstValue;
        return this;
    }

    public String getInsuranceValue() {
        return insuranceValue;
    }

    public VendorTenderBid setInsuranceValue(String insuranceValue) {
        this.insuranceValue = insuranceValue;
        return this;
    }

    public String getGrandTotal() {
        return grandTotal;
    }

    public VendorTenderBid setGrandTotal(String grandTotal) {
        this.grandTotal = grandTotal;
        return this;
    }

    public String getGrandTotalWord() {
        return grandTotalWord;
    }

    public VendorTenderBid setGrandTotalWord(String grandTotalWord) {
        this.grandTotalWord = grandTotalWord;
        return this;
    }

    public String getSubmitFlag() {
        return submitFlag;
    }

    public VendorTenderBid setSubmitFlag(String submitFlag) {
        this.submitFlag = submitFlag;
        return this;
    }

    public String getBidSubmitDate() {
        return bidSubmitDate;
    }

    public VendorTenderBid setBidSubmitDate(String bidSubmitDate) {
        this.bidSubmitDate = bidSubmitDate;
        return this;
    }

    public String getFlag() {
        return flag;
    }

    public VendorTenderBid setFlag(String flag) {
        this.flag = flag;
        return this;
    }

    public String getBidOpenDate() {
        return bidOpenDate;
    }

    public VendorTenderBid setBidOpenDate(String bidOpenDate) {
        this.bidOpenDate = bidOpenDate;
        return this;
    }

    public String getBidOpenBy() {
        return bidOpenBy;
    }

    public VendorTenderBid setBidOpenBy(String bidOpenBy) {
        this.bidOpenBy = bidOpenBy;
        return this;
    }

    public String getBidOpenById() {
        return bidOpenById;
    }

    public VendorTenderBid setBidOpenById(String bidOpenById) {
        this.bidOpenById = bidOpenById;
        return this;
    }

    public String getBidOpenFlag() {
        return bidOpenFlag;
    }

    public VendorTenderBid setBidOpenFlag(String bidOpenFlag) {
        this.bidOpenFlag = bidOpenFlag;
        return this;
    }

    public String getReviseDateTime() {
        return reviseDateTime;
    }

    public VendorTenderBid setReviseDateTime(String reviseDateTime) {
        this.reviseDateTime = reviseDateTime;
        return this;
    }

    public int getReviseStatus() {
        return reviseStatus;
    }

    public VendorTenderBid setReviseStatus(int reviseStatus) {
        this.reviseStatus = reviseStatus;
        return this;
    }

    public String getFreightFreeDelivery() {
        return freightFreeDelivery;
    }

    public VendorTenderBid setFreightFreeDelivery(String freightFreeDelivery) {
        this.freightFreeDelivery = freightFreeDelivery;
        return this;
    }

    public String getFreeDeliveryComment() {
        return freeDeliveryComment;
    }

    public VendorTenderBid setFreeDeliveryComment(String freeDeliveryComment) {
        this.freeDeliveryComment = freeDeliveryComment;
        return this;
    }

    public String getFinalTotal() {
        return finalTotal;
    }

    public VendorTenderBid setFinalTotal(String finalTotal) {
        this.finalTotal = finalTotal;
        return this;
    }

    public String getReviseComment() {
        return reviseComment;
    }

    public VendorTenderBid setReviseComment(String reviseComment) {
        this.reviseComment = reviseComment;
        return this;
    }

    public String getServiceDiscountType() {
        return serviceDiscountType;
    }

    public VendorTenderBid setServiceDiscountType(String serviceDiscountType) {
        this.serviceDiscountType = serviceDiscountType;
        return this;
    }

    public String getServiceDiscountValue() {
        return serviceDiscountValue;
    }

    public VendorTenderBid setServiceDiscountValue(String serviceDiscountValue) {
        this.serviceDiscountValue = serviceDiscountValue;
        return this;
    }

    public String getServiceGst() {
        return serviceGst;
    }

    public VendorTenderBid setServiceGst(String serviceGst) {
        this.serviceGst = serviceGst;
        return this;
    }

    public String getServiceTotal() {
        return serviceTotal;
    }

    public VendorTenderBid setServiceTotal(String serviceTotal) {
        this.serviceTotal = serviceTotal;
        return this;
    }

    public String getServiceTaxTotal() {
        return serviceTaxTotal;
    }

    public VendorTenderBid setServiceTaxTotal(String serviceTaxTotal) {
        this.serviceTaxTotal = serviceTaxTotal;
        return this;
    }

    public int getTechSubmitFlag() {
        return techSubmitFlag;
    }

    public VendorTenderBid setTechSubmitFlag(int techSubmitFlag) {
        this.techSubmitFlag = techSubmitFlag;
        return this;
    }

    public int getTechOpenFlag() {
        return techOpenFlag;
    }

    public VendorTenderBid setTechOpenFlag(int techOpenFlag) {
        this.techOpenFlag = techOpenFlag;
        return this;
    }

    public int getTechApproveFlag() {
        return techApproveFlag;
    }

    public VendorTenderBid setTechApproveFlag(int techApproveFlag) {
        this.techApproveFlag = techApproveFlag;
        return this;
    }

    public int getApproveFlag() {
        return approveFlag;
    }

    public void setApproveFlag(int approveFlag) {
        this.approveFlag = approveFlag;
    }
    
    
    
}
