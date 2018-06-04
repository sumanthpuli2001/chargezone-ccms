/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.CandidateJobApply;

import com.bul.zydex.dao.CandiateJobApply.CandidateAcademicQualificationDAO;
import com.bul.zydex.model.CandidateAcademicQualification;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author DELL3
 */
public class CandidateAcademicQualificationServiceImpl<T> extends GenericsServiceImpl<T> implements CandidateAcademicQualificationService<T>{
    private CandidateAcademicQualificationDAO<T> candidateAcademicQualificationDAO;

    public CandidateAcademicQualificationDAO<T> getCandidateAcademicQualificationDAO() {
        return candidateAcademicQualificationDAO;
    }

    public void setCandidateAcademicQualificationDAO(CandidateAcademicQualificationDAO<T> candidateAcademicQualificationDAO) {
        this.candidateAcademicQualificationDAO = candidateAcademicQualificationDAO;
        setGenericsDAO(candidateAcademicQualificationDAO);
    }

    @Override
    public CandidateAcademicQualification readByApplyJobId(int id) {
        return candidateAcademicQualificationDAO.readByApplyJobId(id);
    }

    @Override
    public List<?> readListByApplyJobId(Integer id) {
        return candidateAcademicQualificationDAO.readListByApplyJobId(id);
    }
    
    
}
