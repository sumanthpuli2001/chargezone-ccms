/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.CandidateJobApply;

import com.bul.zydex.dao.CandiateJobApply.CandidateApplyJob2DAO;
import com.bul.zydex.model.CandidateApplyJob2;
import com.bul.zydex.service.GenericsServiceImpl;

/**
 *
 * @author DELL3
 */
public class CandidateApplyJob2ServiceImpl<T> extends GenericsServiceImpl<T> implements CandidateApplyJob2Service<T> {
    
    private CandidateApplyJob2DAO<T> candidateApplyJob2DAO;

    public CandidateApplyJob2DAO<T> getCandidateApplyJob2DAO() {
        return candidateApplyJob2DAO;
    }

    public void setCandidateApplyJob2DAO(CandidateApplyJob2DAO<T> candidateApplyJob2DAO) {
        this.candidateApplyJob2DAO = candidateApplyJob2DAO;
        setGenericsDAO(candidateApplyJob2DAO);
    }

    @Override
    public CandidateApplyJob2 readByApplyJobId(int id) {
        return candidateApplyJob2DAO.readByApplyJobId(id);
    }
    
    
}
