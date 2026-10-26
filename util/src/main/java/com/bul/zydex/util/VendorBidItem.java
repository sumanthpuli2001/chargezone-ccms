/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.util;

/**
 *
 * @author admin
 */
public class VendorBidItem {
    
    private int id;
    private String itemCode;
    private String itemDesciption;
    private String remark;
    private String uom;
    private String qty;
    private String purNo;
    private String itemNo;
    private String rate;
    private String hsnNo;
    private String vendorRemark;
    private String itemRegret;

    private String individualNetTotal;
    private String individualDiscountType;
    private String individualDiscountValue;
    private String individualPackingType;
    private String individualPackingValue;
    private String individualFreightType;
    private String individualFreightValue;
    private String individualErrectionValue;
    private String individualChargesValue;
    private String individualIgstValue;
    private String individualCgstValue;
    private String individualSgstValue;
    private String individualInsuranceValue;
    private String individualgrandTotal;

    private Double individualItemTotalFinal;
    private Double individualDiscountValueFinal;
    private Double individualPackingValueFinal;
    private Double individualFreightValueFinal;
    private Double individualErrectionValueFinal;
    private Double individualChargesValueFinal;
    private Double individualIgstValueFinal;
    private Double individualCgstValueFinal;
    private Double individualSgstValueFinal;
    private Double individualInsuranceValueFinal;
    private Double individualGrandTotalFinal;

                
    
    public VendorBidItem() {
    }
    
    public VendorBidItem(int id, String itemCode, String itemDesciption, String remark, String uom, String qty, String purNo, String itemNo, String rate, String hsnNo, String vendorRemark, String itemRegret, String individualNetTotal, String individualDiscountType, String individualDiscountValue, String individualPackingType, String individualPackingValue, String individualFreightType, String individualFreightValue, String individualErrectionValue, String individualChargesValue, String individualIgstValue, String individualCgstValue, String individualSgstValue, String individualInsuranceValue, String individualgrandTotal, Double individualItemTotalFinal, Double individualDiscountValueFinal, Double individualPackingValueFinal, Double individualFreightValueFinal, Double individualErrectionValueFinal, Double individualChargesValueFinal, Double individualIgstValueFinal, Double individualCgstValueFinal, Double individualSgstValueFinal, Double individualInsuranceValueFinal, Double individualGrandTotalFinal) {
        this.id = id;
        this.itemCode = itemCode;
        this.itemDesciption = itemDesciption;
        this.remark = remark;
        this.uom = uom;
        this.qty = qty;
        this.purNo = purNo;
        this.itemNo = itemNo;
        this.rate = rate;
        this.hsnNo = hsnNo;
        this.vendorRemark = vendorRemark;
        this.itemRegret = itemRegret;
        this.individualNetTotal = individualNetTotal;
        this.individualDiscountType = individualDiscountType;
        this.individualDiscountValue = individualDiscountValue;
        this.individualPackingType = individualPackingType;
        this.individualPackingValue = individualPackingValue;
        this.individualFreightType = individualFreightType;
        this.individualFreightValue = individualFreightValue;
        this.individualErrectionValue = individualErrectionValue; 
        this.individualChargesValue = individualChargesValue;
        this.individualIgstValue = individualIgstValue;
        this.individualCgstValue = individualCgstValue;
        this.individualSgstValue = individualSgstValue;
        this.individualInsuranceValue = individualInsuranceValue;
        this.individualgrandTotal = individualgrandTotal;
        this.individualItemTotalFinal = individualItemTotalFinal;
        this.individualDiscountValueFinal = individualDiscountValueFinal;
        this.individualPackingValueFinal = individualPackingValueFinal;
        this.individualFreightValueFinal = individualFreightValueFinal;
        this.individualErrectionValueFinal = individualErrectionValueFinal;
        this.individualChargesValueFinal = individualChargesValueFinal;
        this.individualIgstValueFinal = individualIgstValueFinal;
        this.individualCgstValueFinal = individualCgstValueFinal;
        this.individualSgstValueFinal = individualSgstValueFinal;
        this.individualInsuranceValueFinal = individualInsuranceValueFinal;
        this.individualGrandTotalFinal = individualGrandTotalFinal;
    
    }

    public int getId() {
        return id;
    }

    public VendorBidItem setId(int id) {
        this.id = id;
        return this;
    }

    public String getItemCode() {
        return itemCode;
    }

    public VendorBidItem setItemCode(String itemCode) {
        this.itemCode = itemCode;
        return this;
    }

    public String getItemDesciption() {
        return itemDesciption;
    }

    public VendorBidItem setItemDesciption(String itemDesciption) {
        this.itemDesciption = itemDesciption;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public VendorBidItem setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public String getUom() {
        return uom;
    }

    public VendorBidItem setUom(String uom) {
        this.uom = uom;
        return this;
    }

    public String getQty() {
        return qty;
    }

    public VendorBidItem setQty(String qty) {
        this.qty = qty;
        return this;
    }

    public String getPurNo() {
        return purNo;
    }

    public VendorBidItem setPurNo(String purNo) {
        this.purNo = purNo;
        return this;
    }

    public String getItemNo() {
        return itemNo;
    }

    public VendorBidItem setItemNo(String itemNo) {
        this.itemNo = itemNo;
        return this;
    }

    public String getRate() {
        return rate;
    }

    public VendorBidItem setRate(String rate) {
        this.rate = rate;
        return this;
    }

    public String getHsnNo() {
        return hsnNo;
    }

    public VendorBidItem setHsnNo(String hsnNo) {
        this.hsnNo = hsnNo;
        return this;
    }

    public String getVendorRemark() {
        return vendorRemark;
    }

    public VendorBidItem setVendorRemark(String vendorRemark) {
        this.vendorRemark = vendorRemark;
        return this;
    }

    public String getItemRegret() {
        return itemRegret;
    }

    public VendorBidItem setItemRegret(String itemRegret) {
        this.itemRegret = itemRegret;
        return this;
    }

    public String getIndividualNetTotal() {
        return individualNetTotal;
    }

    public VendorBidItem setIndividualNetTotal(String individualNetTotal) {
        this.individualNetTotal = individualNetTotal;
        return this;
    }

    public String getIndividualDiscountType() {
        return individualDiscountType;
    }

    public VendorBidItem setIndividualDiscountType(String individualDiscountType) {
        this.individualDiscountType = individualDiscountType;
        return this;
    }

    public String getIndividualDiscountValue() {
        return individualDiscountValue;
    }

    public VendorBidItem setIndividualDiscountValue(String individualDiscountValue) {
        this.individualDiscountValue = individualDiscountValue;
        return this;
    }

    public String getIndividualPackingType() {
        return individualPackingType;
    }

    public VendorBidItem setIndividualPackingType(String individualPackingType) {
        this.individualPackingType = individualPackingType;
        return this;
    }

    public String getIndividualPackingValue() {
        return individualPackingValue;
    }

    public VendorBidItem setIndividualPackingValue(String individualPackingValue) {
        this.individualPackingValue = individualPackingValue;
        return this;
    }

    public String getIndividualFreightType() {
        return individualFreightType;
    }

    public VendorBidItem setIndividualFreightType(String individualFreightType) {
        this.individualFreightType = individualFreightType;
        return this;
    }

    public String getIndividualFreightValue() {
        return individualFreightValue;
    }

    public VendorBidItem setIndividualFreightValue(String individualFreightValue) {
        this.individualFreightValue = individualFreightValue;
        return this;
    }

    public String getIndividualErrectionValue() {
        return individualErrectionValue;
    }

    public VendorBidItem setIndividualErrectionValue(String individualErrectionValue) {
        this.individualErrectionValue = individualErrectionValue;
        return this;
    }

    public String getIndividualChargesValue() {
        return individualChargesValue;
    }

    public VendorBidItem setIndividualChargesValue(String individualChargesValue) {
        this.individualChargesValue = individualChargesValue;
        return this;
    }

    public String getIndividualIgstValue() {
        return individualIgstValue;
    }

    public VendorBidItem setIndividualIgstValue(String individualIgstValue) {
        this.individualIgstValue = individualIgstValue;
        return this;
    }

    public String getIndividualCgstValue() {
        return individualCgstValue;
    }

    public VendorBidItem setIndividualCgstValue(String individualCgstValue) {
        this.individualCgstValue = individualCgstValue;
        return this;
    }

    public String getIndividualSgstValue() {
        return individualSgstValue;
    }

    public VendorBidItem setIndividualSgstValue(String individualSgstValue) {
        this.individualSgstValue = individualSgstValue;
        return this;
    }

    public String getIndividualInsuranceValue() {
        return individualInsuranceValue;
    }

    public VendorBidItem setIndividualInsuranceValue(String individualInsuranceValue) {
        this.individualInsuranceValue = individualInsuranceValue;
        return this;
    }

    public String getIndividualgrandTotal() {
        return individualgrandTotal;
    }

    public VendorBidItem setIndividualgrandTotal(String individualgrandTotal) {
        this.individualgrandTotal = individualgrandTotal;
        return this;
    }

    public Double getIndividualItemTotalFinal() {
        return individualItemTotalFinal;
    }

    public VendorBidItem setIndividualItemTotalFinal(Double individualItemTotalFinal) {
        this.individualItemTotalFinal = individualItemTotalFinal;
        return this;
    }

    public Double getIndividualDiscountValueFinal() {
        return individualDiscountValueFinal;
    }

    public VendorBidItem setIndividualDiscountValueFinal(Double individualDiscountValueFinal) {
        this.individualDiscountValueFinal = individualDiscountValueFinal;
        return this;
    }

    public Double getIndividualPackingValueFinal() {
        return individualPackingValueFinal;
    }

    public VendorBidItem setIndividualPackingValueFinal(Double individualPackingValueFinal) {
        this.individualPackingValueFinal = individualPackingValueFinal;
        return this;
    }

    public Double getIndividualFreightValueFinal() {
        return individualFreightValueFinal;
    }

    public VendorBidItem setIndividualFreightValueFinal(Double individualFreightValueFinal) {
        this.individualFreightValueFinal = individualFreightValueFinal;
        return this;
    }

    public Double getIndividualErrectionValueFinal() {
        return individualErrectionValueFinal;
    }

    public VendorBidItem setIndividualErrectionValueFinal(Double individualErrectionValueFinal) {
        this.individualErrectionValueFinal = individualErrectionValueFinal;
        return this;
    }

    public Double getIndividualChargesValueFinal() {
        return individualChargesValueFinal;
    }

    public VendorBidItem setIndividualChargesValueFinal(Double individualChargesValueFinal) {
        this.individualChargesValueFinal = individualChargesValueFinal;
        return this;
    }

    public Double getIndividualIgstValueFinal() {
        return individualIgstValueFinal;
    }

    public VendorBidItem setIndividualIgstValueFinal(Double individualIgstValueFinal) {
        this.individualIgstValueFinal = individualIgstValueFinal;
        return this;
    }

    public Double getIndividualCgstValueFinal() {
        return individualCgstValueFinal;
    }

    public VendorBidItem setIndividualCgstValueFinal(Double individualCgstValueFinal) {
        this.individualCgstValueFinal = individualCgstValueFinal;
        return this;
    }

    public Double getIndividualSgstValueFinal() {
        return individualSgstValueFinal;
    }

    public VendorBidItem setIndividualSgstValueFinal(Double individualSgstValueFinal) {
        this.individualSgstValueFinal = individualSgstValueFinal;
        return this;
    }

    public Double getIndividualInsuranceValueFinal() {
        return individualInsuranceValueFinal;
    }

    public VendorBidItem setIndividualInsuranceValueFinal(Double individualInsuranceValueFinal) {
        this.individualInsuranceValueFinal = individualInsuranceValueFinal;
        return this;
    }

    public Double getIndividualGrandTotalFinal() {
        return individualGrandTotalFinal;
    }

    public VendorBidItem setIndividualGrandTotalFinal(Double individualGrandTotalFinal) {
        this.individualGrandTotalFinal = individualGrandTotalFinal;
        return this;
    }
    
    
}
