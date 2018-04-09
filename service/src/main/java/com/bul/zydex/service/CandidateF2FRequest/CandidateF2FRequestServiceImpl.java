/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.CandidateF2FRequest;

import com.bul.zydex.dao.CandidateF2FRequest.CandidateF2FRequestDAO;
import com.bul.zydex.model.CandidateF2FRequest;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Vikas
 */
public class CandidateF2FRequestServiceImpl<T> extends GenericsServiceImpl<T> implements CandidateF2FRequestService<T> {

    private CandidateF2FRequestDAO<T> candidateF2FRequestDAO;

    public CandidateF2FRequestDAO<T> getCandidateF2FRequestDAO() {
        return candidateF2FRequestDAO;
    }

    public void setCandidateF2FRequestDAO(CandidateF2FRequestDAO<T> candidateF2FRequestDAO) {
        this.candidateF2FRequestDAO = candidateF2FRequestDAO;
        setGenericsDAO(candidateF2FRequestDAO);
    }

    @Override
    public List<?> interviewReqDetailread(int empId) {
        return candidateF2FRequestDAO.interviewReqDetailread(empId);
    }

    @Override
    public CandidateF2FRequest readById(int id) {
        return candidateF2FRequestDAO.readById(id);
    }

}
