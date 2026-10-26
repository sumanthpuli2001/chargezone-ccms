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
public class VendorCriteriaMaster {

    private int id;
    private int groupMasterId;
    private int groupCategoryId;
    private int groupSubCategoryId;
    private String departmentCategory;

    public VendorCriteriaMaster() {
    }

    public VendorCriteriaMaster(int id, int groupMasterId, int groupCategoryId, int groupSubCategoryId, String departmentCategory) {
        this.id = id;
        this.groupMasterId = groupMasterId;
        this.groupCategoryId = groupCategoryId;
        this.groupSubCategoryId = groupSubCategoryId;
        this.departmentCategory = departmentCategory;
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

    public int getGroupSubCategoryId() {
        return groupSubCategoryId;
    }

    public void setGroupSubCategoryId(int groupSubCategoryId) {
        this.groupSubCategoryId = groupSubCategoryId;
    }

    public String getDepartmentCategory() {
        return departmentCategory;
    }

    public void setDepartmentCategory(String departmentCategory) {
        this.departmentCategory = departmentCategory;
    }

}
