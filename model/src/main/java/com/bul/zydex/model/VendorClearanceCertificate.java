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
public class VendorClearanceCertificate implements java.io.Serializable{
    
    private int id;
    private int vendorInformationId;
    private String processDetail;
    private String hazardiousMaterial;
    private String certificateNo;
    private String description;
            
    public VendorClearanceCertificate() {
    }
    
    public VendorClearanceCertificate(int id, int vendorInformationId, String processDetail, String hazardiousMaterial, String certificateNo, String description) {
        this.id = id;
        this.vendorInformationId = vendorInformationId;
        this.processDetail = processDetail;
        this.hazardiousMaterial = hazardiousMaterial;
        this.certificateNo = certificateNo;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public VendorClearanceCertificate setId(int id) {
        this.id = id;
        return this;
    }

    public int getVendorInformationId() {
        return vendorInformationId;
    }

    public VendorClearanceCertificate setVendorInformationId(int vendorInformationId) {
        this.vendorInformationId = vendorInformationId;
        return this;
    }

    public String getProcessDetail() {
        return processDetail;
    }

    public VendorClearanceCertificate setProcessDetail(String processDetail) {
        this.processDetail = processDetail;
        return this;
    }

    public String getHazardiousMaterial() {
        return hazardiousMaterial;
    }

    public VendorClearanceCertificate setHazardiousMaterial(String hazardiousMaterial) {
        this.hazardiousMaterial = hazardiousMaterial;
        return this;
    }

    public String getCertificateNo() {
        return certificateNo;
    }

    public VendorClearanceCertificate setCertificateNo(String certificateNo) {
        this.certificateNo = certificateNo;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public VendorClearanceCertificate setDescription(String description) {
        this.description = description;
        return this;
    }
    
    
}
