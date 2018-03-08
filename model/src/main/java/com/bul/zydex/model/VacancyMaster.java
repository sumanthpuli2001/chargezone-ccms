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
public class VacancyMaster implements java.io.Serializable {

    private Integer id;
    private LocationMaster locationMaster;
    private DepartmentMaster departmentMaster;
    private JobtypeMaster jobtypeMaster;
    private String name;
    private Integer numberOfPosition;
    private Integer salaryRange;
    private String experience;
    private String responsibility;
    private String skill;
    private String fromDate;
    private String toDate;
    private String description;
    private Integer status;
    private DesignationMaster designationMaster;

    public VacancyMaster() {

    }

    public VacancyMaster(Integer id, LocationMaster locationMaster, DepartmentMaster departmentMaster, JobtypeMaster jobtypeMaster, String name, Integer numberOfPosition, Integer salaryRange, String experience, String responsibility, String skill, String fromDate, String toDate, String description, Integer status, DesignationMaster designationMaster) {
        this.id = id;
        this.locationMaster = locationMaster;
        this.departmentMaster = departmentMaster;
        this.jobtypeMaster = jobtypeMaster;
        this.name = name;
        this.numberOfPosition = numberOfPosition;
        this.salaryRange = salaryRange;
        this.experience = experience;
        this.responsibility = responsibility;
        this.skill = skill;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.description = description;
        this.status = status;
        this.designationMaster = designationMaster;
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

    public Integer getSalaryRange() {
        return salaryRange;
    }

    public void setSalaryRange(Integer salaryRange) {
        this.salaryRange = salaryRange;
    }


    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getResponsibility() {
        return responsibility;
    }

    public void setResponsibility(String responsibility) {
        this.responsibility = responsibility;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public DesignationMaster getDesignationMaster() {
        return designationMaster;
    }

    public void setDesignationMaster(DesignationMaster designationMaster) {
        this.designationMaster = designationMaster;
    }

}
