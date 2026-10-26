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
public class TechnicalSpecificationExcel {
    
    private int id;
    private String srNo;
    private String desc;
    private String remark;
    private String comp;
    
    public TechnicalSpecificationExcel() {
    }
    
    public TechnicalSpecificationExcel(int id, String srNo, String desc, String remark, String comp) {
        this.id = id;
        this.srNo = srNo;
        this.desc = desc;
        this.remark = remark;
        this.comp = comp;
        
    }

    public int getId() {
        return id;
    }

    public TechnicalSpecificationExcel setId(int id) {
        this.id = id;
        return this;
    }

    public String getSrNo() {
        return srNo;
    }

    public TechnicalSpecificationExcel setSrNo(String srNo) {
        this.srNo = srNo;
        return this;
    }

    public String getDesc() {
        return desc;
    }

    public TechnicalSpecificationExcel setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public TechnicalSpecificationExcel setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public String getComp() {
        return comp;
    }

    public TechnicalSpecificationExcel setComp(String comp) {
        this.comp = comp;
        return this;
    }
    
    

}
