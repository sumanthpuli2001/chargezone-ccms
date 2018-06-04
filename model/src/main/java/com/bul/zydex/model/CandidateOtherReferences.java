/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

import java.io.Serializable;

/**
 *
 * @author DELL3
 */
public class CandidateOtherReferences implements Serializable {

    private Integer id;
    private String referenceNonRelativesName;
    private String referenceNonRelativesOrganization;
    private String referenceNonRelativesPosition;
    private String referenceNonRelativesContactNmber;
    private String createdDate;
    private CandidateApplyJob candidateApplyJob;

    public CandidateOtherReferences() {
    }

    public CandidateOtherReferences(String referenceNonRelativesName, String referenceNonRelativesOrganization, String referenceNonRelativesPosition, String referenceNonRelativesContactNmber, String createdDate, CandidateApplyJob candidateApplyJob) {
        this.referenceNonRelativesName = referenceNonRelativesName;
        this.referenceNonRelativesOrganization = referenceNonRelativesOrganization;
        this.referenceNonRelativesPosition = referenceNonRelativesPosition;
        this.referenceNonRelativesContactNmber = referenceNonRelativesContactNmber;
        this.createdDate = createdDate;
        this.candidateApplyJob = candidateApplyJob;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReferenceNonRelativesName() {
        return referenceNonRelativesName;
    }

    public void setReferenceNonRelativesName(String referenceNonRelativesName) {
        this.referenceNonRelativesName = referenceNonRelativesName;
    }

    public String getReferenceNonRelativesOrganization() {
        return referenceNonRelativesOrganization;
    }

    public void setReferenceNonRelativesOrganization(String referenceNonRelativesOrganization) {
        this.referenceNonRelativesOrganization = referenceNonRelativesOrganization;
    }

    public String getReferenceNonRelativesPosition() {
        return referenceNonRelativesPosition;
    }

    public void setReferenceNonRelativesPosition(String referenceNonRelativesPosition) {
        this.referenceNonRelativesPosition = referenceNonRelativesPosition;
    }

    public String getReferenceNonRelativesContactNmber() {
        return referenceNonRelativesContactNmber;
    }

    public void setReferenceNonRelativesContactNmber(String referenceNonRelativesContactNmber) {
        this.referenceNonRelativesContactNmber = referenceNonRelativesContactNmber;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public CandidateApplyJob getCandidateApplyJob() {
        return candidateApplyJob;
    }

    public void setCandidateApplyJob(CandidateApplyJob candidateApplyJob) {
        this.candidateApplyJob = candidateApplyJob;
    }

}
