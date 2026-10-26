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
public class VendorBusinessCertificate implements java.io.Serializable {
    
    private int id;
    private int vendorInformationId;
    private String certificateDetails;
    private String certificateFile;
    
    public VendorBusinessCertificate() {
    }
    
    public VendorBusinessCertificate(int id, int vendorInformationId, String certificateDetails, String certificateFile) {
        this.id = id;
        this.vendorInformationId = vendorInformationId;
        this.certificateDetails = certificateDetails;
        this.certificateFile = certificateFile;
    }

    public int getId() {
        return id;
    }

    public VendorBusinessCertificate setId(int id) {
        this.id = id;
        return this;
    }

    public int getVendorInformationId() {
        return vendorInformationId;
    }

    public VendorBusinessCertificate setVendorInformationId(int vendorInformationId) {
        this.vendorInformationId = vendorInformationId;
        return this;
    }

    public String getCertificateDetails() {
        return certificateDetails;
    }

    public VendorBusinessCertificate setCertificateDetails(String certificateDetails) {
        this.certificateDetails = certificateDetails;
        return this;
    }

    public String getCertificateFile() {
        return certificateFile;
    }

    public VendorBusinessCertificate setCertificateFile(String certificateFile) {
        this.certificateFile = certificateFile;
        return this;
    }
    
    
    
}
