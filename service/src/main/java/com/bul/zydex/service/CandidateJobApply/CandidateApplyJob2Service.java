/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.CandidateJobApply;

import com.bul.zydex.model.CandidateApplyJob2;
import com.bul.zydex.service.GenericsService;

/**
 *
 * @author DELL3
 */
public interface CandidateApplyJob2Service<T> extends GenericsService<T>{
    public CandidateApplyJob2 readByApplyJobId(int id);
}
