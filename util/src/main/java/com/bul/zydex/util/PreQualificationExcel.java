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
public class PreQualificationExcel {
    
    private int id;
    private String srNo;
    private String desc;
    private String comp;

    public PreQualificationExcel() {
    }
    
    public PreQualificationExcel(int id, String srNo, String desc, String comp) {
        this.id = id;
        this.srNo = srNo;
        this.desc = desc;
        this.comp = comp;
        
    }

    public int getId() {
        return id;
    }

    public PreQualificationExcel setId(int id) {
        this.id = id;
        return this;
    }
    
    public String getSrNo() {
        return srNo;
    }

    public PreQualificationExcel setSrNo(String srNo) {
        this.srNo = srNo;
        return this;
    }

    public String getDesc() {
        return desc;
    }

    public PreQualificationExcel setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public String getComp() {
        return comp;
    }

    public PreQualificationExcel setComp(String comp) {
        this.comp = comp;
        return this;
    }
    
    
    
}
