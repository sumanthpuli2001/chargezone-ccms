/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.CandidateF2FRequest;

import com.bul.zydex.dao.CandidateF2FRequest.CandidateF2FObservationDAO;
import com.bul.zydex.model.CandidateF2FObservation;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Hussain
 */
public class CandidateF2FObservationServiceImpl<T> extends GenericsServiceImpl<T> implements CandidateF2FObservationService<T> {

    private CandidateF2FObservationDAO<T> candidateF2FObservationDAO;

    public CandidateF2FObservationDAO<T> getCandidateF2FObservationDAO() {
        return candidateF2FObservationDAO;
    }

    public void setCandidateF2FObservationDAO(CandidateF2FObservationDAO<T> candidateF2FObservationDAO) {
        this.candidateF2FObservationDAO = candidateF2FObservationDAO;
        setGenericsDAO(candidateF2FObservationDAO);
    }

    @Override
    public CandidateF2FObservation ReadByIdCandidateF2FOb(int empId, int vancyId, int applycandidate, int applicationID) {
        return candidateF2FObservationDAO.ReadByIdCandidateF2FOb(empId, vancyId, applycandidate, applicationID);
    }

    @Override
    public List<?> ReadByIdCandidateF2FObHr(int vancyId, int applycandidate, int applicationID) {
       return candidateF2FObservationDAO.ReadByIdCandidateF2FObHr(vancyId, applycandidate, applicationID);
    }

    

    

}
