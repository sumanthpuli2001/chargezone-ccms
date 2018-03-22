/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.CandidateF2FRequest;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.CandidateF2FRequest;
import java.util.List;

/**
 *
 * @author Vikas
 */
public interface CandidateF2FRequestDAO<T> extends GenericsDAO<T> {
    
    
    public List<?> interviewReqDetailread();
    
    
    public CandidateF2FRequest readById(int id);
}
