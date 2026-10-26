/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author Admin
 */
public class GroupSubCategory {

    private int id;
    private int groupMasterId;
    private int groupCategoryId;
    private String subCategoryName;
    private String hr;
    private String hsc;
    private String it;
    private String technical;
    private String riskCategory;
    private String attachment;
    private String remark;
    

    public GroupSubCategory() {
    }

    
    
    public GroupSubCategory(int id, int groupMasterId, int groupCategoryId, String subCategoryName, String hr, String hsc, String it, String technical, String riskCategory, String attachment, String remark) {
        this.id = id;
        this.groupMasterId = groupMasterId;
        this.groupCategoryId = groupCategoryId;
        this.subCategoryName = subCategoryName;
        this.hr = hr;
        this.hsc = hsc;
        this.it = it;
        this.technical = technical;
        this.riskCategory = riskCategory;
        this.attachment = attachment;
        this.remark = remark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGroupMasterId() {
        return groupMasterId;
    }

    public void setGroupMasterId(int groupMasterId) {
        this.groupMasterId = groupMasterId;
    }

    public int getGroupCategoryId() {
        return groupCategoryId;
    }

    public void setGroupCategoryId(int groupCategoryId) {
        this.groupCategoryId = groupCategoryId;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public String getHr() {
        return hr;
    }

    public void setHr(String hr) {
        this.hr = hr;
    }

    public String getHsc() {
        return hsc;
    }

    public void setHsc(String hsc) {
        this.hsc = hsc;
    }

    public String getIt() {
        return it;
    }

    public void setIt(String it) {
        this.it = it;
    }

    public String getTechnical() {
        return technical;
    }

    public void setTechnical(String technical) {
        this.technical = technical;
    }

    public String getRiskCategory() {
        return riskCategory;
    }

    public void setRiskCategory(String riskCategory) {
        this.riskCategory = riskCategory;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

   
}
