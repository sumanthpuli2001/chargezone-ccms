/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.QuestionAnswerSubmit;

import com.bul.zydex.dao.QuestionAnswerSubmit.CandidateResultStatusDAO;
import com.bul.zydex.service.GenericsServiceImpl;

/**
 *
 * @author Admin
 */
public class CandidateResultStatusServiceImpl<T> extends GenericsServiceImpl<T> implements CandidateResultStatusService<T>{
 
    private CandidateResultStatusDAO<T> candidateResultStatusDAO;

    public CandidateResultStatusDAO<T> getCandidateResultStatusDAO() {
        return candidateResultStatusDAO;
    }

    public void setCandidateResultStatusDAO(CandidateResultStatusDAO<T> candidateResultStatusDAO) {
        this.candidateResultStatusDAO = candidateResultStatusDAO;
        setGenericsDAO(candidateResultStatusDAO);
    }
    
    
}
