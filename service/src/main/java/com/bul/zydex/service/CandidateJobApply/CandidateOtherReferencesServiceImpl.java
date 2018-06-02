/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.CandidateJobApply;

import com.bul.zydex.dao.CandiateJobApply.CandidateOtherReferencesDAO;
import com.bul.zydex.model.CandidateOtherReferences;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author DELL3
 */
public class CandidateOtherReferencesServiceImpl<T> extends GenericsServiceImpl<T> implements CandidateOtherReferencesService<T> {
    private CandidateOtherReferencesDAO<T> candidateOtherReferencesDAO;

    public CandidateOtherReferencesDAO<T> getCandidateOtherReferencesDAO() {
        return candidateOtherReferencesDAO;
    }

    public void setCandidateOtherReferencesDAO(CandidateOtherReferencesDAO<T> candidateOtherReferencesDAO) {
        this.candidateOtherReferencesDAO = candidateOtherReferencesDAO;
        setGenericsDAO(candidateOtherReferencesDAO);
    }

    @Override
    public CandidateOtherReferences readByApplyJobId(int id) {
        return candidateOtherReferencesDAO.readByApplyJobId(id);
    }

    @Override
    public List<?> readListByApplyJobId(Integer id) {
        return candidateOtherReferencesDAO.readListByApplyJobId(id);
    }
    
    
}
