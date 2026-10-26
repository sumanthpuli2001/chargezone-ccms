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
public class ReviseVendorTenderBid {

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
    private String freightFreeDelivery;
    private String freeDeliveryComment;
    private String serviceDiscountType;
    private String serviceDiscountValue;
    private String serviceGst;
    private String serviceTotal;
    private String serviceTaxTotal;

    public ReviseVendorTenderBid() {
    }

    public ReviseVendorTenderBid(int id, String refNo, String vendorCode, int revision, String offerNo, String offerDate, String contactPerson, String contactNo, String conactEmail, String gstNo, String deliveryLocation, String deliveryPeriod, String termsOfPayment, String validityPeriod, String modeOfTransport, String incoTerms, String insurance, String freight, String remarkByVendor, String itemTotal, String selectCommon, String discountType, String discountValue, String packingType, String packingValue, String freightType, String freightValue, String errectionValue, String chargesValue, String igstValue, String cgstValue, String sgstValue, String insuranceValue, String grandTotal, String grandTotalWord, String submitFlag, String bidSubmitDate, String flag, String bidOpenDate, String bidOpenBy, String bidOpenById, String bidOpenFlag, String freightFreeDelivery, String freeDeliveryComment) {
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
        this.freightFreeDelivery = freightFreeDelivery;
        this.freeDeliveryComment = freeDeliveryComment;
    }

    public ReviseVendorTenderBid(String serviceDiscountType, String serviceDiscountValue, String serviceGst, String serviceTotal, String serviceTaxTotal) {
        this.serviceDiscountType = serviceDiscountType;
        this.serviceDiscountValue = serviceDiscountValue;
        this.serviceGst = serviceGst;
        this.serviceTotal = serviceTotal;
        this.serviceTaxTotal = serviceTaxTotal;
    }
    
    

    public int getId() {
        return id;
    }

    public ReviseVendorTenderBid setId(int id) {
        this.id = id;
        return this;
    }

    public String getRefNo() {
        return refNo;
    }

    public ReviseVendorTenderBid setRefNo(String refNo) {
        this.refNo = refNo;
        return this;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public ReviseVendorTenderBid setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
        return this;
    }

    public int getRevision() {
        return revision;
    }

    public ReviseVendorTenderBid setRevision(int revision) {
        this.revision = revision;
        return this;
    }

    public String getOfferNo() {
        return offerNo;
    }

    public ReviseVendorTenderBid setOfferNo(String offerNo) {
        this.offerNo = offerNo;
        return this;
    }

    public String getOfferDate() {
        return offerDate;
    }

    public ReviseVendorTenderBid setOfferDate(String offerDate) {
        this.offerDate = offerDate;
        return this;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public ReviseVendorTenderBid setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
        return this;
    }

    public String getContactNo() {
        return contactNo;
    }

    public ReviseVendorTenderBid setContactNo(String contactNo) {
        this.contactNo = contactNo;
        return this;
    }

    public String getConactEmail() {
        return conactEmail;
    }

    public ReviseVendorTenderBid setConactEmail(String conactEmail) {
        this.conactEmail = conactEmail;
        return this;
    }

    public String getGstNo() {
        return gstNo;
    }

    public ReviseVendorTenderBid setGstNo(String gstNo) {
        this.gstNo = gstNo;
        return this;
    }

    public String getDeliveryLocation() {
        return deliveryLocation;
    }

    public ReviseVendorTenderBid setDeliveryLocation(String deliveryLocation) {
        this.deliveryLocation = deliveryLocation;
        return this;
    }

    public String getDeliveryPeriod() {
        return deliveryPeriod;
    }

    public ReviseVendorTenderBid setDeliveryPeriod(String deliveryPeriod) {
        this.deliveryPeriod = deliveryPeriod;
        return this;
    }

    public String getTermsOfPayment() {
        return termsOfPayment;
    }

    public ReviseVendorTenderBid setTermsOfPayment(String termsOfPayment) {
        this.termsOfPayment = termsOfPayment;
        return this;
    }

    public String getValidityPeriod() {
        return validityPeriod;
    }

    public ReviseVendorTenderBid setValidityPeriod(String validityPeriod) {
        this.validityPeriod = validityPeriod;
        return this;
    }

    public String getModeOfTransport() {
        return modeOfTransport;
    }

    public ReviseVendorTenderBid setModeOfTransport(String modeOfTransport) {
        this.modeOfTransport = modeOfTransport;
        return this;
    }

    public String getIncoTerms() {
        return incoTerms;
    }

    public ReviseVendorTenderBid setIncoTerms(String incoTerms) {
        this.incoTerms = incoTerms;
        return this;
    }

    public String getInsurance() {
        return insurance;
    }

    public ReviseVendorTenderBid setInsurance(String insurance) {
        this.insurance = insurance;
        return this;
    }

    public String getFreight() {
        return freight;
    }

    public ReviseVendorTenderBid setFreight(String freight) {
        this.freight = freight;
        return this;
    }

    public String getRemarkByVendor() {
        return remarkByVendor;
    }

    public ReviseVendorTenderBid setRemarkByVendor(String remarkByVendor) {
        this.remarkByVendor = remarkByVendor;
        return this;
    }

    public String getItemTotal() {
        return itemTotal;
    }

    public ReviseVendorTenderBid setItemTotal(String itemTotal) {
        this.itemTotal = itemTotal;
        return this;
    }

    public String getSelectCommon() {
        return selectCommon;
    }

    public ReviseVendorTenderBid setSelectCommon(String selectCommon) {
        this.selectCommon = selectCommon;
        return this;
    }

    public String getDiscountType() {
        return discountType;
    }

    public ReviseVendorTenderBid setDiscountType(String discountType) {
        this.discountType = discountType;
        return this;
    }

    public String getDiscountValue() {
        return discountValue;
    }

    public ReviseVendorTenderBid setDiscountValue(String discountValue) {
        this.discountValue = discountValue;
        return this;
    }

    public String getPackingType() {
        return packingType;
    }

    public ReviseVendorTenderBid setPackingType(String packingType) {
        this.packingType = packingType;
        return this;
    }

    public String getPackingValue() {
        return packingValue;
    }

    public ReviseVendorTenderBid setPackingValue(String packingValue) {
        this.packingValue = packingValue;
        return this;
    }

    public String getFreightType() {
        return freightType;
    }

    public ReviseVendorTenderBid setFreightType(String freightType) {
        this.freightType = freightType;
        return this;
    }

    public String getFreightValue() {
        return freightValue;
    }

    public ReviseVendorTenderBid setFreightValue(String freightValue) {
        this.freightValue = freightValue;
        return this;
    }

    public String getErrectionValue() {
        return errectionValue;
    }

    public ReviseVendorTenderBid setErrectionValue(String errectionValue) {
        this.errectionValue = errectionValue;
        return this;
    }

    public String getChargesValue() {
        return chargesValue;
    }

    public ReviseVendorTenderBid setChargesValue(String chargesValue) {
        this.chargesValue = chargesValue;
        return this;
    }

    public String getIgstValue() {
        return igstValue;
    }

    public ReviseVendorTenderBid setIgstValue(String igstValue) {
        this.igstValue = igstValue;
        return this;
    }

    public String getCgstValue() {
        return cgstValue;
    }

    public ReviseVendorTenderBid setCgstValue(String cgstValue) {
        this.cgstValue = cgstValue;
        return this;
    }

    public String getSgstValue() {
        return sgstValue;
    }

    public ReviseVendorTenderBid setSgstValue(String sgstValue) {
        this.sgstValue = sgstValue;
        return this;
    }

    public String getInsuranceValue() {
        return insuranceValue;
    }

    public ReviseVendorTenderBid setInsuranceValue(String insuranceValue) {
        this.insuranceValue = insuranceValue;
        return this;
    }

    public String getGrandTotal() {
        return grandTotal;
    }

    public ReviseVendorTenderBid setGrandTotal(String grandTotal) {
        this.grandTotal = grandTotal;
        return this;
    }

    public String getGrandTotalWord() {
        return grandTotalWord;
    }

    public ReviseVendorTenderBid setGrandTotalWord(String grandTotalWord) {
        this.grandTotalWord = grandTotalWord;
        return this;
    }

    public String getSubmitFlag() {
        return submitFlag;
    }

    public ReviseVendorTenderBid setSubmitFlag(String submitFlag) {
        this.submitFlag = submitFlag;
        return this;
    }

    public String getBidSubmitDate() {
        return bidSubmitDate;
    }

    public ReviseVendorTenderBid setBidSubmitDate(String bidSubmitDate) {
        this.bidSubmitDate = bidSubmitDate;
        return this;
    }

    public String getFlag() {
        return flag;
    }

    public ReviseVendorTenderBid setFlag(String flag) {
        this.flag = flag;
        return this;
    }

    public String getBidOpenDate() {
        return bidOpenDate;
    }

    public ReviseVendorTenderBid setBidOpenDate(String bidOpenDate) {
        this.bidOpenDate = bidOpenDate;
        return this;
    }

    public String getBidOpenBy() {
        return bidOpenBy;
    }

    public ReviseVendorTenderBid setBidOpenBy(String bidOpenBy) {
        this.bidOpenBy = bidOpenBy;
        return this;
    }

    public String getBidOpenById() {
        return bidOpenById;
    }

    public ReviseVendorTenderBid setBidOpenById(String bidOpenById) {
        this.bidOpenById = bidOpenById;
        return this;
    }

    public String getBidOpenFlag() {
        return bidOpenFlag;
    }

    public ReviseVendorTenderBid setBidOpenFlag(String bidOpenFlag) {
        this.bidOpenFlag = bidOpenFlag;
        return this;
    }

    public String getFreightFreeDelivery() {
        return freightFreeDelivery;
    }

    public ReviseVendorTenderBid setFreightFreeDelivery(String freightFreeDelivery) {
        this.freightFreeDelivery = freightFreeDelivery;
        return this;
    }

    public String getFreeDeliveryComment() {
        return freeDeliveryComment;
    }

    public ReviseVendorTenderBid setFreeDeliveryComment(String freeDeliveryComment) {
        this.freeDeliveryComment = freeDeliveryComment;
        return this;
    }

    public String getServiceDiscountType() {
        return serviceDiscountType;
    }

    public void setServiceDiscountType(String serviceDiscountType) {
        this.serviceDiscountType = serviceDiscountType;
    }

    public String getServiceDiscountValue() {
        return serviceDiscountValue;
    }

    public void setServiceDiscountValue(String serviceDiscountValue) {
        this.serviceDiscountValue = serviceDiscountValue;
    }

    public String getServiceGst() {
        return serviceGst;
    }

    public void setServiceGst(String serviceGst) {
        this.serviceGst = serviceGst;
    }

    public String getServiceTotal() {
        return serviceTotal;
    }

    public void setServiceTotal(String serviceTotal) {
        this.serviceTotal = serviceTotal;
    }

    public String getServiceTaxTotal() {
        return serviceTaxTotal;
    }

    public void setServiceTaxTotal(String serviceTaxTotal) {
        this.serviceTaxTotal = serviceTaxTotal;
    }
    
    

}
