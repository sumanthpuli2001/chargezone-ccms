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
public class VendorMaster {

    private int id;
    private String vendorName;
    private String vendorRegNo;
    private String vendorStxNo;
    private String vendorCstxNo;
    private String vendorAddressLine1;
    private String vendorAddressLine2;
    private String vendorAddressLine3;
    private String vendorCity;
    private String vendorPincode;
    private String vendorDistrict;
    private String vendorState;
    private String vendorCountry;
    private String vendorPhNo;
    private String vendorMobNo;
    private String vendorFax;
    private String vendorEmailID;
    private int vendorStatusId;
    private int vendorTypeId;
    private int flag;
    private String stceg;
    private String j1IpanNo;
    private String J1Isern;
    private String vendorRemark;
    private String vendorcc;
    private String vendorStamp;
    private String vendorSign;


    public VendorMaster() {
    }

    public VendorMaster(int id, String vendorName, String vendorRegNo, String vendorStxNo, String vendorCstxNo, String vendorAddressLine1, String vendorAddressLine2, String vendorAddressLine3, String vendorCity, String vendorPincode, String vendorDistrict, String vendorState, String vendorCountry, String vendorPhNo, String vendorMobNo, String vendorFax, String vendorEmailID, int vendorStatusId, int vendorTypeId, int flag, String stceg, String j1IpanNo, String J1Isern ,String vendorRemark, String vendorcc, String vendorStamp, String vendorSign) {
        this.id = id;
        this.vendorName = vendorName;
        this.vendorRegNo = vendorRegNo;
        this.vendorStxNo = vendorStxNo;
        this.vendorCstxNo = vendorCstxNo;
        this.vendorAddressLine1 = vendorAddressLine1;
        this.vendorAddressLine2 = vendorAddressLine2;
        this.vendorAddressLine3 = vendorAddressLine3;
        this.vendorCity = vendorCity;
        this.vendorPincode = vendorPincode;
        this.vendorDistrict = vendorDistrict;
        this.vendorState = vendorState;
        this.vendorCountry = vendorCountry;
        this.vendorPhNo = vendorPhNo;
        this.vendorMobNo = vendorMobNo;
        this.vendorFax = vendorFax;
        this.vendorEmailID = vendorEmailID;
        this.vendorStatusId = vendorStatusId;
        this.vendorTypeId = vendorTypeId;
        this.flag = flag;
        this.stceg = stceg;
        this.j1IpanNo = j1IpanNo;
        this.J1Isern = J1Isern;
        this.vendorRemark = vendorRemark;
        this.vendorcc = vendorcc;
        this.vendorStamp = vendorStamp;
        this.vendorSign = vendorSign;
    }

    public int getId() {
        return id;
    }

    public VendorMaster setId(int id) {
        this.id = id;
        return this;
    }

    public String getVendorName() {
        return vendorName;
    }

    public VendorMaster setVendorName(String vendorName) {
        this.vendorName = vendorName;
        return this;
    }

    public String getVendorRegNo() {
        return vendorRegNo;
    }

    public VendorMaster setVendorRegNo(String vendorRegNo) {
        this.vendorRegNo = vendorRegNo;
        return this;
    }

    public String getVendorStxNo() {
        return vendorStxNo;
    }

    public VendorMaster setVendorStxNo(String vendorStxNo) {
        this.vendorStxNo = vendorStxNo;
        return this;
    }

    public String getVendorCstxNo() {
        return vendorCstxNo;
    }

    public VendorMaster setVendorCstxNo(String vendorCstxNo) {
        this.vendorCstxNo = vendorCstxNo;
        return this;
    }

    public String getVendorAddressLine1() {
        return vendorAddressLine1;
    }

    public VendorMaster setVendorAddressLine1(String vendorAddressLine1) {
        this.vendorAddressLine1 = vendorAddressLine1;
        return this;
    }

    public String getVendorAddressLine2() {
        return vendorAddressLine2;
    }

    public VendorMaster setVendorAddressLine2(String vendorAddressLine2) {
        this.vendorAddressLine2 = vendorAddressLine2;
        return this;
    }

    public String getVendorAddressLine3() {
        return vendorAddressLine3;
    }

    public VendorMaster setVendorAddressLine3(String vendorAddressLine3) {
        this.vendorAddressLine3 = vendorAddressLine3;
        return this;
    }

    public String getVendorCity() {
        return vendorCity;
    }

    public VendorMaster setVendorCity(String vendorCity) {
        this.vendorCity = vendorCity;
        return this;
    }

    public String getVendorPincode() {
        return vendorPincode;
    }

    public VendorMaster setVendorPincode(String vendorPincode) {
        this.vendorPincode = vendorPincode;
        return this;
    }

    public String getVendorDistrict() {
        return vendorDistrict;
    }

    public VendorMaster setVendorDistrict(String vendorDistrict) {
        this.vendorDistrict = vendorDistrict;
        return this;
    }

    public String getVendorState() {
        return vendorState;
    }

    public VendorMaster setVendorState(String vendorState) {
        this.vendorState = vendorState;
        return this;
    }

    public String getVendorCountry() {
        return vendorCountry;
    }

    public VendorMaster setVendorCountry(String vendorCountry) {
        this.vendorCountry = vendorCountry;
        return this;
    }

    public String getVendorPhNo() {
        return vendorPhNo;
    }

    public VendorMaster setVendorPhNo(String vendorPhNo) {
        this.vendorPhNo = vendorPhNo;
        return this;
    }

    public String getVendorMobNo() {
        return vendorMobNo;
    }

    public VendorMaster setVendorMobNo(String vendorMobNo) {
        this.vendorMobNo = vendorMobNo;
        return this;
    }

    public String getVendorFax() {
        return vendorFax;
    }

    public VendorMaster setVendorFax(String vendorFax) {
        this.vendorFax = vendorFax;
        return this;
    }

    public String getVendorEmailID() {
        return vendorEmailID;
    }

    public VendorMaster setVendorEmailID(String vendorEmailID) {
        this.vendorEmailID = vendorEmailID;
        return this;
    }

    public int getVendorStatusId() {
        return vendorStatusId;
    }

    public VendorMaster setVendorStatusId(int vendorStatusId) {
        this.vendorStatusId = vendorStatusId;
        return this;
    }

    public int getVendorTypeId() {
        return vendorTypeId;
    }

    public VendorMaster setVendorTypeId(int vendorTypeId) {
        this.vendorTypeId = vendorTypeId;
        return this;
    }

    public int getFlag() {
        return flag;
    }

    public VendorMaster setFlag(int flag) {
        this.flag = flag;
        return this;
    }

    public String getStceg() {
        return stceg;
    }

    public VendorMaster setStceg(String stceg) {
        this.stceg = stceg;
        return this;
    }

    public String getJ1IpanNo() {
        return j1IpanNo;
    }

    public VendorMaster setJ1IpanNo(String j1IpanNo) {
        this.j1IpanNo = j1IpanNo;
        return this;
    }

    public String getJ1Isern() {
        return J1Isern;
    }

    public VendorMaster setJ1Isern(String J1Isern) {
        this.J1Isern = J1Isern;
        return this;
    }

    public String getVendorRemark() {
        return vendorRemark;
    }

    public void setVendorRemark(String vendorRemark) {
        this.vendorRemark = vendorRemark;
    }

    public String getVendorcc() {
        return vendorcc;
    }

    public void setVendorcc(String vendorcc) {
        this.vendorcc = vendorcc;
    }

    public String getVendorStamp() {
        return vendorStamp;
    }

    public void setVendorStamp(String vendorStamp) {
        this.vendorStamp = vendorStamp;
    }

    public String getVendorSign() {
        return vendorSign;
    }

    public void setVendorSign(String vendorSign) {
        this.vendorSign = vendorSign;
    }
    
    

}
