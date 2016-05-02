/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author HRINTRA
 */
public class AppraisalkraActivity {
     private Integer id;
     private AppraisalPerformanceMaster appraisalPerformanceMaster;
     private String kraDeletedDate;
     private String deletedKra;
     private String deletedMetric;
     private String deletedWeightage;
     private String deletedBy;
     private String status;
     
     public AppraisalkraActivity() {
    }

	
    public AppraisalkraActivity(AppraisalPerformanceMaster appraisalPerformanceMaster) {
        this.appraisalPerformanceMaster = appraisalPerformanceMaster;
    }

    public AppraisalkraActivity(AppraisalPerformanceMaster appraisalPerformanceMaster, String kraDeletedDate, String deletedKra, String deletedMetric, String deletedWeightage, String deletedBy, String status) {
        this.appraisalPerformanceMaster = appraisalPerformanceMaster;
        this.kraDeletedDate = kraDeletedDate;
        this.deletedKra = deletedKra;
        this.deletedMetric = deletedMetric;
        this.deletedWeightage = deletedWeightage;
        this.deletedBy = deletedBy;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AppraisalPerformanceMaster getAppraisalPerformanceMaster() {
        return appraisalPerformanceMaster;
    }

    public void setAppraisalPerformanceMaster(AppraisalPerformanceMaster appraisalPerformanceMaster) {
        this.appraisalPerformanceMaster = appraisalPerformanceMaster;
    }

    public String getKraDeletedDate() {
        return kraDeletedDate;
    }

    public void setKraDeletedDate(String kraDeletedDate) {
        this.kraDeletedDate = kraDeletedDate;
    }

    public String getDeletedKra() {
        return deletedKra;
    }

    public void setDeletedKra(String deletedKra) {
        this.deletedKra = deletedKra;
    }

    public String getDeletedMetric() {
        return deletedMetric;
    }

    public void setDeletedMetric(String deletedMetric) {
        this.deletedMetric = deletedMetric;
    }

    public String getDeletedWeightage() {
        return deletedWeightage;
    }

    public void setDeletedWeightage(String deletedWeightage) {
        this.deletedWeightage = deletedWeightage;
    }

    public String getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(String deletedBy) {
        this.deletedBy = deletedBy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    

    
}
