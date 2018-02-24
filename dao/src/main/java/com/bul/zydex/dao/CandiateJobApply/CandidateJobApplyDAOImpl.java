/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.CandiateJobApply;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.CandidateApplyJob;

/**
 *
 * @author Aman
 */
public class CandidateJobApplyDAOImpl<T>extends  GenericsDAOImpl<T> implements CandidateJobApplyDAO<T>{
    
  @Override
    protected Class getDomainClass() {
        return CandidateApplyJob.class;
    }
    
}