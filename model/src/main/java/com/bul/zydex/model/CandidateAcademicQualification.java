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
public class CandidateAcademicQualification implements Serializable {

    private Integer id;
    private Integer academicYearFrom;
    private Integer academicYearTo;
    private String academicExamination;
    private String academicBoard;
    private Integer academicNumberOfAttempts;
    private String academicMarksInPercent;
    private String academicClass;
    private String academicRankOrScholarship;
    private String createdDate;
    private CandidateApplyJob candidateApplyJob;

    public CandidateAcademicQualification() {
    }

    public CandidateAcademicQualification(Integer academicYearFrom, Integer academicYearTo, String academicExamination, String academicBoard, Integer academicNumberOfAttempts, String academicMarksInPercent, String academicClass, String academicRankOrScholarship, String createdDate, CandidateApplyJob candidateApplyJob) {
        this.academicYearFrom = academicYearFrom;
        this.academicYearTo = academicYearTo;
        this.academicExamination = academicExamination;
        this.academicBoard = academicBoard;
        this.academicNumberOfAttempts = academicNumberOfAttempts;
        this.academicMarksInPercent = academicMarksInPercent;
        this.academicClass = academicClass;
        this.academicRankOrScholarship = academicRankOrScholarship;
        this.createdDate = createdDate;
        this.candidateApplyJob = candidateApplyJob;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAcademicYearFrom() {
        return academicYearFrom;
    }

    public void setAcademicYearFrom(Integer academicYearFrom) {
        this.academicYearFrom = academicYearFrom;
    }

    public Integer getAcademicYearTo() {
        return academicYearTo;
    }

    public void setAcademicYearTo(Integer academicYearTo) {
        this.academicYearTo = academicYearTo;
    }

    public String getAcademicExamination() {
        return academicExamination;
    }

    public void setAcademicExamination(String academicExamination) {
        this.academicExamination = academicExamination;
    }

    public String getAcademicBoard() {
        return academicBoard;
    }

    public void setAcademicBoard(String academicBoard) {
        this.academicBoard = academicBoard;
    }

    public Integer getAcademicNumberOfAttempts() {
        return academicNumberOfAttempts;
    }

    public void setAcademicNumberOfAttempts(Integer academicNumberOfAttempts) {
        this.academicNumberOfAttempts = academicNumberOfAttempts;
    }

    public String getAcademicMarksInPercent() {
        return academicMarksInPercent;
    }

    public void setAcademicMarksInPercent(String academicMarksInPercent) {
        this.academicMarksInPercent = academicMarksInPercent;
    }

    public String getAcademicClass() {
        return academicClass;
    }

    public void setAcademicClass(String academicClass) {
        this.academicClass = academicClass;
    }

    public String getAcademicRankOrScholarship() {
        return academicRankOrScholarship;
    }

    public void setAcademicRankOrScholarship(String academicRankOrScholarship) {
        this.academicRankOrScholarship = academicRankOrScholarship;
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
