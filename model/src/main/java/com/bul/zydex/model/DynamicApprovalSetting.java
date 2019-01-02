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
public class DynamicApprovalSetting implements java.io.Serializable {

    private Integer id;
//    private Company company;
    private DepartmentMaster departmentMaster;
    private Modules modules;
//    private LocationMaster locationMaster;
    private Integer projectName;
    private Integer createdBy;
    private String createdDate;
    private Integer updatedBy;
    private String updatedDate;

    public DynamicApprovalSetting() {
    }

    public DynamicApprovalSetting(DepartmentMaster departmentMaster, Modules modules) {
//        this.company = company;
        this.departmentMaster = departmentMaster;
        this.modules = modules;
//        this.locationMaster = locationMaster;
    }

    public DynamicApprovalSetting(DepartmentMaster departmentMaster, Modules modules,Integer createdBy, String createdDate, Integer updatedBy, String updatedDate, Integer projectName) {
//        this.company = company;
        this.departmentMaster = departmentMaster;
        this.modules = modules;
//        this.locationMaster = locationMaster;
        this.projectName = projectName;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.updatedBy = updatedBy;
        this.updatedDate = updatedDate;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

   

    public DepartmentMaster getDepartmentMaster() {
        return departmentMaster;
    }

    public void setDepartmentMaster(DepartmentMaster departmentMaster) {
        this.departmentMaster = departmentMaster;
    }

    public Modules getModules() {
        return this.modules;
    }

    public void setModules(Modules modules) {
        this.modules = modules;
    }

    

    public Integer getProjectName() {
        return projectName;
    }

    public void setProjectName(Integer projectName) {
        this.projectName = projectName;
    }

    public Integer getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getUpdatedBy() {
        return this.updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getUpdatedDate() {
        return this.updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

}
