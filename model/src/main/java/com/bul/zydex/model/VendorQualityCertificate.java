/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

import java.io.Serializable;
/**
 *
 * @author admin
 */
public class VendorQualityCertificate implements java.io.Serializable{
    
    private int id;
    private int vendorInformationId;
    private String certificateDetails;
    private String certificateFile;
    
    public VendorQualityCertificate() {
    }
    
    public VendorQualityCertificate(int id, int vendorInformationId, String certificateDetails, String certificateFile) {
        this.id = id;
        this.vendorInformationId = vendorInformationId;
        this.certificateDetails = certificateDetails;
        this.certificateFile = certificateFile;
    }

    public int getId() {
        return id;
    }

    public VendorQualityCertificate setId(int id) {
        this.id = id;
        return this;
    }
    
    public int getVendorInformationId() {
        return vendorInformationId;
    }

    public VendorQualityCertificate setVendorInformationId(int vendorInformationId) {
        this.vendorInformationId = vendorInformationId;
        return this;
    }

    public String getCertificateDetails() {
        return certificateDetails;
    }

    public VendorQualityCertificate setCertificateDetails(String certificateDetails) {
        this.certificateDetails = certificateDetails;
        return this;
    }

    public String getCertificateFile() {
        return certificateFile;
    }

    public VendorQualityCertificate setCertificateFile(String certificateFile) {
        this.certificateFile = certificateFile;
        return this;
    }
    
}
