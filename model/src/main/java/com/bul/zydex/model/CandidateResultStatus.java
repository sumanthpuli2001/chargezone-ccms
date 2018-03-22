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
public class CandidateResultStatus implements java.io.Serializable {

    private Integer id;
    private CandidateJobApplication candidateJobApplication;
    private Double obtainsPercentage;
    private Double obtainTotal;
    private String resultStatus;

    public CandidateResultStatus() {
    }

    public CandidateResultStatus(Integer id, CandidateJobApplication candidateJobApplication, Double obtainsPercentage, Double obtainTotal, String resultStatus) {
        this.id = id;
        this.candidateJobApplication = candidateJobApplication;
        this.obtainsPercentage = obtainsPercentage;
        this.obtainTotal = obtainTotal;
        this.resultStatus = resultStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CandidateJobApplication getCandidateJobApplication() {
        return candidateJobApplication;
    }

    public void setCandidateJobApplication(CandidateJobApplication candidateJobApplication) {
        this.candidateJobApplication = candidateJobApplication;
    }


    public Double getObtainsPercentage() {
        return obtainsPercentage;
    }

    public void setObtainsPercentage(Double obtainsPercentage) {
        this.obtainsPercentage = obtainsPercentage;
    }

    public Double getObtainTotal() {
        return obtainTotal;
    }

    public void setObtainTotal(Double obtainTotal) {
        this.obtainTotal = obtainTotal;
    }

    public String getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(String resultStatus) {
        this.resultStatus = resultStatus;
    }
    
    

}
