/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author Aman
 */
public class DataTableReportMaster  implements java.io.Serializable {


     private int id;
     private ComponentMaster componentMaster;
     private String reportName;
     private String query;
     private Integer status;
     private Integer createdBy;
     private String createdDate;
     private Integer updatedBy;
     private String updatedDate;

    public DataTableReportMaster() {
    }

	
    public DataTableReportMaster(int id, ComponentMaster componentMaster) {
        this.id = id;
        this.componentMaster = componentMaster;
    }
    public DataTableReportMaster(int id, ComponentMaster componentMaster, String reportName, String query, Integer status, Integer createdBy, String createdDate, Integer updatedBy, String updatedDate) {
       this.id = id;
       this.componentMaster = componentMaster;
       this.reportName = reportName;
       this.query = query;
       this.status = status;
       this.createdBy = createdBy;
       this.createdDate = createdDate;
       this.updatedBy = updatedBy;
       this.updatedDate = updatedDate;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public ComponentMaster getComponentMaster() {
        return this.componentMaster;
    }
    
    public void setComponentMaster(ComponentMaster componentMaster) {
        this.componentMaster = componentMaster;
    }
    public String getReportName() {
        return this.reportName;
    }
    
    public void setReportName(String reportName) {
        this.reportName = reportName;
    }
    public String getQuery() {
        return this.query;
    }
    
    public void setQuery(String query) {
        this.query = query;
    }
    public Integer getStatus() {
        return this.status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
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
