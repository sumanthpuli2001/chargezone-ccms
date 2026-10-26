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
public class VendorInfo {
    
    private int id;
    private String fname;    
    private String sfirm;    
    private String rdate;    
    private String addr;    
    private String location;    
    private String cperson;    
    private String officeno;    
    private String resino;    
    private String mobno;    
    private String faxno;    
    private String emailid;    
    private String panno;    
    private String tno;    
    private String cinnoFilePath;    
    private String cinno;    
    private String altemailid;    
    private String stno;    
    private String stnoFilePath;    
    private String cstno;    
    private String cstnoFilePath;    
    private String vatno;    
    private String vatnoFilePath;    
    private String vendorFilePath;    
    private String panFilePath;    
    private int flag;
    private String vendorCode;    
    private String pinno;    
    private String servicetaxno;    
    private String servicetaxnoFilePath;    
    private String currentdate;    

    public VendorInfo() {
    }
    
    public VendorInfo(int id, String fname, String sfirm, String rdate, String addr, String location, String cperson, String officeno, String resino, String mobno, String faxno, String emailid, String panno, String tno, String cinnoFilePath, String cinno, String altemailid, String stno, String stnoFilePath, String cstno, String cstnoFilePath, String vatno, String vatnoFilePath, String vendorFilePath, String panFilePath, int flag, String vendorCode, String pinno, String servicetaxno, String servicetaxnoFilePath, String currentdate) {
        this.id = id;
        this.fname = fname;
        this.sfirm = sfirm;
        this.rdate = rdate;
        this.addr = addr;    
        this.location =  location;    
        this.cperson = cperson;    
        this.officeno = officeno;    
        this.resino = resino;    
        this.mobno = mobno;    
        this.faxno = faxno;    
        this.emailid = emailid;    
        this.panno = panno;    
        this.tno = tno;    
        this.cinnoFilePath = cinnoFilePath;    
        this.cinno = cinno;    
        this.altemailid = altemailid;    
        this.stno = stno;    
        this.stnoFilePath = stnoFilePath;    
        this.cstno = cstno;    
        this.cstnoFilePath = cstnoFilePath;    
        this.vatno = vatno;    
        this.vatnoFilePath = vatnoFilePath;    
        this.vendorFilePath = vendorFilePath;    
        this.panFilePath = panFilePath;    
        this.flag = flag;
        this.vendorCode = vendorCode;    
        this.pinno = pinno;    
        this.servicetaxno = servicetaxno;    
        this.servicetaxnoFilePath = servicetaxnoFilePath;    
        this.currentdate = currentdate;    
        
    }

    public int getId() {
        return id;
    }

    public VendorInfo setId(int id) {
        this.id = id;
        return this;
    }

    public String getFname() {
        return fname;
    }

    public VendorInfo setFname(String fname) {
        this.fname = fname;
        return this;
    }

    public String getSfirm() {
        return sfirm;
    }

    public VendorInfo setSfirm(String sfirm) {
        this.sfirm = sfirm;
        return this;
    }

    public String getRdate() {
        return rdate;
    }

    public VendorInfo setRdate(String rdate) {
        this.rdate = rdate;
        return this;
    }

    public String getAddr() {
        return addr;
    }

    public VendorInfo setAddr(String addr) {
        this.addr = addr;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public VendorInfo setLocation(String location) {
        this.location = location;
        return this;
    }

    public String getCperson() {
        return cperson;
    }

    public VendorInfo setCperson(String cperson) {
        this.cperson = cperson;
        return this;
    }

    public String getOfficeno() {
        return officeno;
    }

    public VendorInfo setOfficeno(String officeno) {
        this.officeno = officeno;
        return this;
    }

    public String getResino() {
        return resino;
    }

    public VendorInfo setResino(String resino) {
        this.resino = resino;
        return this;
    }

    public String getMobno() {
        return mobno;
    }

    public VendorInfo setMobno(String mobno) {
        this.mobno = mobno;
        return this;
    }

    public String getFaxno() {
        return faxno;
    }

    public VendorInfo setFaxno(String faxno) {
        this.faxno = faxno;
        return this;
    }

    public String getEmailid() {
        return emailid;
    }

    public VendorInfo setEmailid(String emailid) {
        this.emailid = emailid;
        return this;
    }

    public String getPanno() {
        return panno;
    }

    public VendorInfo setPanno(String panno) {
        this.panno = panno;
        return this;
    }

    public String getTno() {
        return tno;
    }

    public VendorInfo setTno(String tno) {
        this.tno = tno;
        return this;
    }

    public String getCinnoFilePath() {
        return cinnoFilePath;
    }

    public VendorInfo setCinnoFilePath(String cinnoFilePath) {
        this.cinnoFilePath = cinnoFilePath;
        return this;
    }

    public String getCinno() {
        return cinno;
    }

    public VendorInfo setCinno(String cinno) {
        this.cinno = cinno;
        return this;
    }

    public String getAltemailid() {
        return altemailid;
    }

    public VendorInfo setAltemailid(String altemailid) {
        this.altemailid = altemailid;
        return this;
    }

    public String getStno() {
        return stno;
    }

    public VendorInfo setStno(String stno) {
        this.stno = stno;
        return this;
    }

    public String getStnoFilePath() {
        return stnoFilePath;
    }

    public VendorInfo setStnoFilePath(String stnoFilePath) {
        this.stnoFilePath = stnoFilePath;
        return this;
    }

    public String getCstno() {
        return cstno;
    }

    public VendorInfo setCstno(String cstno) {
        this.cstno = cstno;
        return this;
    }

    public String getCstnoFilePath() {
        return cstnoFilePath;
    }

    public VendorInfo setCstnoFilePath(String cstnoFilePath) {
        this.cstnoFilePath = cstnoFilePath;
        return this;
    }

    public String getVatno() {
        return vatno;
    }

    public VendorInfo setVatno(String vatno) {
        this.vatno = vatno;
        return this;
    }

    public String getVatnoFilePath() {
        return vatnoFilePath;
    }

    public VendorInfo setVatnoFilePath(String vatnoFilePath) {
        this.vatnoFilePath = vatnoFilePath;
        return this;
    }

    public String getVendorFilePath() {
        return vendorFilePath;
    }

    public VendorInfo setVendorFilePath(String vendorFilePath) {
        this.vendorFilePath = vendorFilePath;
        return this;
    }

    public String getPanFilePath() {
        return panFilePath;
    }

    public VendorInfo setPanFilePath(String panFilePath) {
        this.panFilePath = panFilePath;
        return this;
    }

    public int getFlag() {
        return flag;
    }

    public VendorInfo setFlag(int flag) {
        this.flag = flag;
        return this;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public VendorInfo setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
        return this;
    }

    public String getPinno() {
        return pinno;
    }

    public VendorInfo setPinno(String pinno) {
        this.pinno = pinno;
        return this;
    }

    public String getServicetaxno() {
        return servicetaxno;
    }

    public VendorInfo setServicetaxno(String servicetaxno) {
        this.servicetaxno = servicetaxno;
        return this;
    }

    public String getServicetaxnoFilePath() {
        return servicetaxnoFilePath;
    }

    public VendorInfo setServicetaxnoFilePath(String servicetaxnoFilePath) {
        this.servicetaxnoFilePath = servicetaxnoFilePath;
        return this;
    }

    public String getCurrentdate() {
        return currentdate;
    }

    public VendorInfo setCurrentdate(String currentdate) {
        this.currentdate = currentdate;
        return this;
    }
    
    
}
