/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author bulwarks-2
 */
public class ProductGroupMaster {
    private Integer id;
    private String productGroup;
    private String description;
    private String Gl;
    private Integer variationClassId;

    public ProductGroupMaster() {
    }

    public ProductGroupMaster(Integer id, String productGroup, String description, String Gl, Integer variationClassId) {
        this.id = id;
        this.productGroup = productGroup;
        this.description = description;
        this.Gl = Gl;
        this.variationClassId = variationClassId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductGroup() {
        return productGroup;
    }

    public void setProductGroup(String productGroup) {
        this.productGroup = productGroup;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGl() {
        return Gl;
    }

    public void setGl(String Gl) {
        this.Gl = Gl;
    }

    public Integer getVariationClassId() {
        return variationClassId;
    }

    public void setVariationClassId(Integer variationClassId) {
        this.variationClassId = variationClassId;
    }

    
}
