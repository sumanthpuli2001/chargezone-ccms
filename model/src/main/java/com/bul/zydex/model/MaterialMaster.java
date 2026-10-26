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
public class MaterialMaster {
    
    private int id;
    private MaterialTypeMaster materialTypeMaster;
    private MaterialGroupMaster materialGroupMaster;
    private String materialCode;
    private String materialDescription;
    private String materialLongDescription;
    private String uom;
    private String hsnNo;
    private String gst;

    public MaterialMaster() {
    }

    public MaterialMaster(int id, MaterialTypeMaster materialTypeMaster, MaterialGroupMaster materialGroupMaster, String materialCode, String materialDescription, String materialLongDescription, String uom, String hsnNo, String gst) {
        this.id = id;
        this.materialTypeMaster = materialTypeMaster;
        this.materialGroupMaster = materialGroupMaster;
        this.materialCode = materialCode;
        this.materialDescription = materialDescription;
        this.materialLongDescription = materialLongDescription;
        this.uom = uom;
        this.hsnNo = hsnNo;
        this.gst = gst;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MaterialTypeMaster getMaterialTypeMaster() {
        return materialTypeMaster;
    }

    public void setMaterialTypeMaster(MaterialTypeMaster materialTypeMaster) {
        this.materialTypeMaster = materialTypeMaster;
    }

    public MaterialGroupMaster getMaterialGroupMaster() {
        return materialGroupMaster;
    }

    public void setMaterialGroupMaster(MaterialGroupMaster materialGroupMaster) {
        this.materialGroupMaster = materialGroupMaster;
    }

    public String getMaterialCode() {
        return materialCode;
    }

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode;
    }

    public String getMaterialDescription() {
        return materialDescription;
    }

    public void setMaterialDescription(String materialDescription) {
        this.materialDescription = materialDescription;
    }

    public String getMaterialLongDescription() {
        return materialLongDescription;
    }

    public void setMaterialLongDescription(String materialLongDescription) {
        this.materialLongDescription = materialLongDescription;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public String getHsnNo() {
        return hsnNo;
    }

    public void setHsnNo(String hsnNo) {
        this.hsnNo = hsnNo;
    }

    public String getGst() {
        return gst;
    }

    public void setGst(String gst) {
        this.gst = gst;
    }
    
    
    
}
