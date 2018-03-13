/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author Hussain
 */
public class QuestionAnswerSubmit implements java.io.Serializable {

    private Integer id;
    private CandidateJobApplication candidateJobApplicationid;
    private QuestionLibrary questionLibraryId;
    private QuestionAns questionAnsId;
    private String description;
    private Double obtainMarks;
    private Integer ansStatus;

    public QuestionAnswerSubmit() {

    }

    public QuestionAnswerSubmit(Integer id, CandidateJobApplication candidateJobApplicationid, QuestionLibrary questionLibraryId, QuestionAns questionAnsId, String description, Double obtainMarks, Integer ansStatus) {
        this.id = id;
        this.candidateJobApplicationid = candidateJobApplicationid;
        this.questionLibraryId = questionLibraryId;
        this.questionAnsId = questionAnsId;
        this.description = description;
        this.obtainMarks = obtainMarks;
        this.ansStatus = ansStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CandidateJobApplication getCandidateJobApplicationid() {
        return candidateJobApplicationid;
    }

    public void setCandidateJobApplicationid(CandidateJobApplication candidateJobApplicationid) {
        this.candidateJobApplicationid = candidateJobApplicationid;
    }

    

    public QuestionLibrary getQuestionLibraryId() {
        return questionLibraryId;
    }

    public void setQuestionLibraryId(QuestionLibrary questionLibraryId) {
        this.questionLibraryId = questionLibraryId;
    }

    public QuestionAns getQuestionAnsId() {
        return questionAnsId;
    }

    public void setQuestionAnsId(QuestionAns questionAnsId) {
        this.questionAnsId = questionAnsId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getObtainMarks() {
        return obtainMarks;
    }

    public void setObtainMarks(Double obtainMarks) {
        this.obtainMarks = obtainMarks;
    }

    public Integer getAnsStatus() {
        return ansStatus;
    }

    public void setAnsStatus(Integer ansStatus) {
        this.ansStatus = ansStatus;
    }

}
