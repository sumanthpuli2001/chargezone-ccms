/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.CandidateJobApply;

import com.bul.zydex.dao.CandiateJobApply.CandidateFamilyBackgroundDAO;
import com.bul.zydex.model.CandidateFamilyBackground;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author DELL3
 */
public class CandidateFamilyBackgroundServiceImpl<T> extends GenericsServiceImpl<T> implements CandidateFamilyBackgroundService<T>{
    private CandidateFamilyBackgroundDAO<T> candidateFamilyBackgroundDAO;

    public CandidateFamilyBackgroundDAO<T> getCandidateFamilyBackgroundDAO() {
        return candidateFamilyBackgroundDAO;
    }

    public void setCandidateFamilyBackgroundDAO(CandidateFamilyBackgroundDAO<T> candidateFamilyBackgroundDAO) {
        this.candidateFamilyBackgroundDAO = candidateFamilyBackgroundDAO;
        setGenericsDAO(candidateFamilyBackgroundDAO);
    }

    @Override
    public CandidateFamilyBackground readByApplyJobId(int id) {
        return candidateFamilyBackgroundDAO.readByApplyJobId(id);
    }

    @Override
    public List<?> readListByApplyJobId(Integer id) {
        return candidateFamilyBackgroundDAO.readListByApplyJobId(id);
    }
    
    
}
