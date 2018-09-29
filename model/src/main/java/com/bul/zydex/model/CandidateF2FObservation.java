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
public class CandidateF2FObservation {

    private Integer id;
    private CandidateJobApplication candidateJobApplication;
    private VacancyMaster vacancyMaster;
    private CandidateApplyJob candidateApplyJob;
    private Integer hrEmpId;
    private int technicalKnowledge;
    private int experience;
    private int commSkill;
    private int interPerSkill;
    private int leaderSkill;
    private String strengths;
    private String weaknesses;
    private String typeOfTraining;
    private String technicalareas;
    private String otherSkills;
    private int excellent;
    private String comment;
    private String hrName;

    public CandidateF2FObservation() {
    }

    public CandidateF2FObservation(Integer id, CandidateJobApplication candidateJobApplication, VacancyMaster vacancyMaster, CandidateApplyJob candidateApplyJob, Integer hrEmpId, int technicalKnowledge, int experience, int commSkill, int interPerSkill, int leaderSkill, String strengths, String weaknesses, String typeOfTraining, String technicalareas, String otherSkills, int excellent, String comment, String hrName) {
        this.id = id;
        this.candidateJobApplication = candidateJobApplication;
        this.vacancyMaster = vacancyMaster;
        this.candidateApplyJob = candidateApplyJob;
        this.hrEmpId = hrEmpId;
        this.technicalKnowledge = technicalKnowledge;
        this.experience = experience;
        this.commSkill = commSkill;
        this.interPerSkill = interPerSkill;
        this.leaderSkill = leaderSkill;
        this.strengths = strengths;
        this.weaknesses = weaknesses;
        this.typeOfTraining = typeOfTraining;
        this.technicalareas = technicalareas;
        this.otherSkills = otherSkills;
        this.excellent = excellent;
        this.comment = comment;
        this.hrName = hrName;
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

    public VacancyMaster getVacancyMaster() {
        return vacancyMaster;
    }

    public void setVacancyMaster(VacancyMaster vacancyMaster) {
        this.vacancyMaster = vacancyMaster;
    }

    public CandidateApplyJob getCandidateApplyJob() {
        return candidateApplyJob;
    }

    public void setCandidateApplyJob(CandidateApplyJob candidateApplyJob) {
        this.candidateApplyJob = candidateApplyJob;
    }

    public Integer getHrEmpId() {
        return hrEmpId;
    }

    public void setHrEmpId(Integer hrEmpId) {
        this.hrEmpId = hrEmpId;
    }

    public int getTechnicalKnowledge() {
        return technicalKnowledge;
    }

    public void setTechnicalKnowledge(int technicalKnowledge) {
        this.technicalKnowledge = technicalKnowledge;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getCommSkill() {
        return commSkill;
    }

    public void setCommSkill(int commSkill) {
        this.commSkill = commSkill;
    }

    public int getInterPerSkill() {
        return interPerSkill;
    }

    public void setInterPerSkill(int interPerSkill) {
        this.interPerSkill = interPerSkill;
    }

    public int getLeaderSkill() {
        return leaderSkill;
    }

    public void setLeaderSkill(int leaderSkill) {
        this.leaderSkill = leaderSkill;
    }

    public String getStrengths() {
        return strengths;
    }

    public void setStrengths(String strengths) {
        this.strengths = strengths;
    }

    public String getWeaknesses() {
        return weaknesses;
    }

    public void setWeaknesses(String weaknesses) {
        this.weaknesses = weaknesses;
    }

    public String getTypeOfTraining() {
        return typeOfTraining;
    }

    public void setTypeOfTraining(String typeOfTraining) {
        this.typeOfTraining = typeOfTraining;
    }

    public String getTechnicalareas() {
        return technicalareas;
    }

    public void setTechnicalareas(String technicalareas) {
        this.technicalareas = technicalareas;
    }

    public String getOtherSkills() {
        return otherSkills;
    }

    public void setOtherSkills(String otherSkills) {
        this.otherSkills = otherSkills;
    }

    public int getExcellent() {
        return excellent;
    }

    public void setExcellent(int excellent) {
        this.excellent = excellent;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getHrName() {
        return hrName;
    }

    public void setHrName(String hrName) {
        this.hrName = hrName;
    }

}
