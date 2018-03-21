/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.CandidateF2FRequest;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.CandidateF2FRequest;

/**
 *
 * @author Vikas
 */
public class CandidateF2FRequestDAOImpl<T> extends GenericsDAOImpl<T> implements CandidateF2FRequestDAO<T>{

    @Override
    protected Class getDomainClass() {
        return CandidateF2FRequest.class;
    }
    
}
