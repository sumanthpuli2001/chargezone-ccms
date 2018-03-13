/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Recruitment;

import com.bul.zydex.dao.Recruitment.CandidateJobApplicationDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Vikas
 */
public class CandidateJobApplicationServiceImpl<T> extends GenericsServiceImpl<T> implements CandidateJobApplicationService<T> {

    private CandidateJobApplicationDAO<T> candidateJobApplicationDAO;

    public CandidateJobApplicationDAO<T> getCandidateJobApplicationDAO() {
        return candidateJobApplicationDAO;
    }

    public void setCandidateJobApplicationDAO(CandidateJobApplicationDAO<T> candidateJobApplicationDAO) {
        this.candidateJobApplicationDAO = candidateJobApplicationDAO;
        setGenericsDAO(candidateJobApplicationDAO);
    }

    @Override
    public List<?> readByCandidateId(int candidateId) {
        return candidateJobApplicationDAO.readByCandidateId(candidateId);
    }

    @Override
    public List<?> readOnlineAssementCandidate(int userMaster) {
       return candidateJobApplicationDAO.readOnlineAssementCandidate(userMaster);
    }

}
