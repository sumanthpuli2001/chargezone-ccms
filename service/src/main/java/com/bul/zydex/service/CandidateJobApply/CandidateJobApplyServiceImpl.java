/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.CandidateJobApply;

import com.bul.zydex.dao.CandiateJobApply.CandidateJobApplyDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Aman
 */
public class CandidateJobApplyServiceImpl<T> extends GenericsServiceImpl<T> implements CandidateJobApplyService<T> {

    private CandidateJobApplyDAO<T> candidateJobApplyDAO;

    public CandidateJobApplyDAO<T> getCandidateJobApplyDAO() {
        return candidateJobApplyDAO;
    }

    public void setCandidateJobApplyDAO(CandidateJobApplyDAO<T> candidateJobApplyDAO) {
        this.candidateJobApplyDAO = candidateJobApplyDAO;
        setGenericsDAO(candidateJobApplyDAO);
    }

    @Override
    public List<?> fetchcandidatelist() {
        return candidateJobApplyDAO.fetchcandidatelist();
    }

    @Override
    public List<?> readProfileByCandidateUserID(int userId) {
        return candidateJobApplyDAO.readProfileByCandidateUserID(userId);

    }
     @Override
    public List<?> readOnlineAssementCandidate(int userMaster) {
        return candidateJobApplyDAO.readOnlineAssementCandidate(userMaster);

    }

}
