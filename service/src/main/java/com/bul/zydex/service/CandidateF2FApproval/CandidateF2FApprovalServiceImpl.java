/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.CandidateF2FApproval;

import com.bul.zydex.dao.CandidateF2FApproval.CandidateF2FApprovalDAO;
import com.bul.zydex.model.CandidateF2FRequest;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Vikas
 */
public class CandidateF2FApprovalServiceImpl<T> extends GenericsServiceImpl<T> implements CandidateF2FApprovalService<T>{
    
    private CandidateF2FApprovalDAO<T>  candidateF2FApprovalDAO;

    public CandidateF2FApprovalDAO<T> getCandidateF2FApprovalDAO() {
        return candidateF2FApprovalDAO;
    }

    public void setCandidateF2FApprovalDAO(CandidateF2FApprovalDAO<T> candidateF2FApprovalDAO) {
        this.candidateF2FApprovalDAO = candidateF2FApprovalDAO;
        setGenericsDAO(candidateF2FApprovalDAO);
    }

    @Override
    public List<?> readByReqId(int id) {
        return  candidateF2FApprovalDAO.readByReqId(id);
    }

    @Override
    public List<?> readByEmpId(int empid) {
         return  candidateF2FApprovalDAO.readByEmpId(empid);
    }

    
    
}
