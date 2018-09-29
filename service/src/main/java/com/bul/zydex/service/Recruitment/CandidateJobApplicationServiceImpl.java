/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Recruitment;

import com.bul.zydex.dao.Recruitment.CandidateJobApplicationDAO;
import com.bul.zydex.model.CandidateJobApplication;
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
    public List<?> readCandidateApplyForJob() {
        return candidateJobApplicationDAO.readCandidateApplyForJob();
    }

    @Override
    public CandidateJobApplication readByCandidateIdAndVacancyId(int candId, int vacId) {
        return candidateJobApplicationDAO.readByCandidateIdAndVacancyId(candId, vacId);
    }

    @Override
    public List<?> readOnlineAssementCandidate(int userMaster) {
        return candidateJobApplicationDAO.readOnlineAssementCandidate(userMaster);

    }

    @Override
    public int GETByCandidateId(int candidateId) {
        return candidateJobApplicationDAO.GETByCandidateId(candidateId);
    }

    @Override
    public int GETByCandidateIdNew(int candidateId, int vacanyId) {
       return candidateJobApplicationDAO.GETByCandidateIdNew(candidateId, vacanyId);
    }

    @Override
    public List<?> deleteVacancyId(String vacancyId) {
         return candidateJobApplicationDAO.deleteVacancyId(vacancyId);
    }

    @Override
    public List<?> readListByApplyJobId(Integer id) {
        return candidateJobApplicationDAO.readListByApplyJobId(id);
    }
}