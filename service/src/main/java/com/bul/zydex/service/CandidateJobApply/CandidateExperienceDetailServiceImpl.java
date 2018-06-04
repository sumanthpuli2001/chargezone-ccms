/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.CandidateJobApply;

import com.bul.zydex.dao.CandiateJobApply.CandidateExperienceDetailDAO;
import com.bul.zydex.model.CandidateExperienceDetail;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author DELL3
 */
public class CandidateExperienceDetailServiceImpl<T> extends GenericsServiceImpl<T> implements CandidateExperienceDetailService<T> {
    private CandidateExperienceDetailDAO<T> candidateExperienceDetailDAO;

    public CandidateExperienceDetailDAO<T> getCandidateExperienceDetailDAO() {
        return candidateExperienceDetailDAO;
    }

    public void setCandidateExperienceDetailDAO(CandidateExperienceDetailDAO<T> candidateExperienceDetailDAO) {
        this.candidateExperienceDetailDAO = candidateExperienceDetailDAO;
        setGenericsDAO(candidateExperienceDetailDAO);
    }

    @Override
    public CandidateExperienceDetail readByApplyJobId(int id) {
        return candidateExperienceDetailDAO.readByApplyJobId(id);
    }

    @Override
    public List<?> readListByApplyJobId(Integer id) {
        return candidateExperienceDetailDAO.readListByApplyJobId(id);
    }
    
    
}
