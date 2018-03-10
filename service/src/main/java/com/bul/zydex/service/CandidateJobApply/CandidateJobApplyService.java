/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.CandidateJobApply;

import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Aman
 */
public interface CandidateJobApplyService<T> extends GenericsService<T> {

    public List<?> fetchcandidatelist();

    public List<?> readProfileByCandidateUserID(int userId);

    public List<?> readOnlineAssementCandidate(int userMaster);

}
