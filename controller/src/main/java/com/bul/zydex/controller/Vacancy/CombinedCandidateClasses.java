/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Vacancy;

import com.bul.zydex.model.CandidateAcademicQualification;
import com.bul.zydex.model.CandidateApplyJob;
import com.bul.zydex.model.CandidateApplyJob2;
import com.bul.zydex.model.CandidateExperienceDetail;
import com.bul.zydex.model.CandidateFamilyBackground;
import com.bul.zydex.model.CandidateOtherReferences;

/**
 *
 * @author DELL3
 */
public class CombinedCandidateClasses {

    private CandidateApplyJob candidateApplyJob;
    private CandidateApplyJob2 candidateApplyJob2;
    private CandidateAcademicQualification candidateAcademicQualification;
    private CandidateExperienceDetail candidateExperienceDetail;
    private CandidateOtherReferences candidateOtherReferences;
    private CandidateFamilyBackground candidateFamilyBackground;

    public CombinedCandidateClasses() {
    }

    public CombinedCandidateClasses(CandidateApplyJob candidateApplyJob, CandidateApplyJob2 candidateApplyJob2, CandidateAcademicQualification candidateAcademicQualification, CandidateExperienceDetail candidateExperienceDetail, CandidateOtherReferences candidateOtherReferences, CandidateFamilyBackground candidateFamilyBackground) {
        this.candidateApplyJob = candidateApplyJob;
        this.candidateApplyJob2 = candidateApplyJob2;
        this.candidateAcademicQualification = candidateAcademicQualification;
        this.candidateExperienceDetail = candidateExperienceDetail;
        this.candidateOtherReferences = candidateOtherReferences;
        this.candidateFamilyBackground = candidateFamilyBackground;
    }

    public CandidateApplyJob getCandidateApplyJob() {
        return candidateApplyJob;
    }

    public void setCandidateApplyJob(CandidateApplyJob candidateApplyJob) {
        this.candidateApplyJob = candidateApplyJob;
    }

    public CandidateApplyJob2 getCandidateApplyJob2() {
        return candidateApplyJob2;
    }

    public void setCandidateApplyJob2(CandidateApplyJob2 candidateApplyJob2) {
        this.candidateApplyJob2 = candidateApplyJob2;
    }

    public CandidateAcademicQualification getCandidateAcademicQualification() {
        return candidateAcademicQualification;
    }

    public void setCandidateAcademicQualification(CandidateAcademicQualification candidateAcademicQualification) {
        this.candidateAcademicQualification = candidateAcademicQualification;
    }

    public CandidateExperienceDetail getCandidateExperienceDetail() {
        return candidateExperienceDetail;
    }

    public void setCandidateExperienceDetail(CandidateExperienceDetail candidateExperienceDetail) {
        this.candidateExperienceDetail = candidateExperienceDetail;
    }

    public CandidateOtherReferences getCandidateOtherReferences() {
        return candidateOtherReferences;
    }

    public void setCandidateOtherReferences(CandidateOtherReferences candidateOtherReferences) {
        this.candidateOtherReferences = candidateOtherReferences;
    }

    public CandidateFamilyBackground getCandidateFamilyBackground() {
        return candidateFamilyBackground;
    }

    public void setCandidateFamilyBackground(CandidateFamilyBackground candidateFamilyBackground) {
        this.candidateFamilyBackground = candidateFamilyBackground;
    }

}
