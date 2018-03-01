/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author Vikas
 */
public class MprMaster implements java.io.Serializable {

    private Integer id;
    private LocationMaster locationMaster;
    private DepartmentMaster departmentMaster;
    private MprEmployeeCategory mprEmployeeCategory;
    private MprEmployeeTypeMaster mprEmployeeTypeMaster;
    private JobtypeMaster jobtypeMaster;
    private String name;
    private Integer numberOfPosition;
    private Integer budget;
    private String experience;
    private String description;
    private DesignationMaster designationMaster;
    private String dateOfLeaving;
    private Integer status;
    private Integer currentLevel;
    private Integer totalLevel;

    public MprMaster() {

    }

    public MprMaster(Integer id, LocationMaster locationMaster, DepartmentMaster departmentMaster, MprEmployeeCategory mprEmployeeCategory, MprEmployeeTypeMaster mprEmployeeTypeMaster, JobtypeMaster jobtypeMaster, String name, Integer numberOfPosition, Integer budget, String experience, String description, DesignationMaster designationMaster, String dateOfLeaving, Integer status, Integer currentLevel, Integer totalLevel) {
        this.id = id;
        this.locationMaster = locationMaster;
        this.departmentMaster = departmentMaster;
        this.mprEmployeeCategory = mprEmployeeCategory;
        this.mprEmployeeTypeMaster = mprEmployeeTypeMaster;
        this.jobtypeMaster = jobtypeMaster;
        this.name = name;
        this.numberOfPosition = numberOfPosition;
        this.budget = budget;
        this.experience = experience;
        this.description = description;
        this.designationMaster = designationMaster;
        this.dateOfLeaving = dateOfLeaving;
        this.status = status;
        this.currentLevel = currentLevel;
        this.totalLevel = totalLevel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocationMaster getLocationMaster() {
        return locationMaster;
    }

    public void setLocationMaster(LocationMaster locationMaster) {
        this.locationMaster = locationMaster;
    }

    public DepartmentMaster getDepartmentMaster() {
        return departmentMaster;
    }

    public void setDepartmentMaster(DepartmentMaster departmentMaster) {
        this.departmentMaster = departmentMaster;
    }

    public MprEmployeeCategory getMprEmployeeCategory() {
        return mprEmployeeCategory;
    }

    public void setMprEmployeeCategory(MprEmployeeCategory mprEmployeeCategory) {
        this.mprEmployeeCategory = mprEmployeeCategory;
    }

    public MprEmployeeTypeMaster getMprEmployeeTypeMaster() {
        return mprEmployeeTypeMaster;
    }

    public void setMprEmployeeTypeMaster(MprEmployeeTypeMaster mprEmployeeTypeMaster) {
        this.mprEmployeeTypeMaster = mprEmployeeTypeMaster;
    }

    public JobtypeMaster getJobtypeMaster() {
        return jobtypeMaster;
    }

    public void setJobtypeMaster(JobtypeMaster jobtypeMaster) {
        this.jobtypeMaster = jobtypeMaster;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberOfPosition() {
        return numberOfPosition;
    }

    public void setNumberOfPosition(Integer numberOfPosition) {
        this.numberOfPosition = numberOfPosition;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DesignationMaster getDesignationMaster() {
        return designationMaster;
    }

    public void setDesignationMaster(DesignationMaster designationMaster) {
        this.designationMaster = designationMaster;
    }

    public String getDateOfLeaving() {
        return dateOfLeaving;
    }

    public void setDateOfLeaving(String dateOfLeaving) {
        this.dateOfLeaving = dateOfLeaving;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(Integer currentLevel) {
        this.currentLevel = currentLevel;
    }

    public Integer getTotalLevel() {
        return totalLevel;
    }

    public void setTotalLevel(Integer totalLevel) {
        this.totalLevel = totalLevel;
    }
    
    
    

}
