/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Recruitment;

import com.bul.zydex.model.CandidateJobApplication;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Vikas
 */
public interface CandidateJobApplicationService<T> extends GenericsService<T> {

    public List<?> readByCandidateId(int candidateId);

    public List<?> readCandidateApplyForJob();

    public CandidateJobApplication readByCandidateIdAndVacancyId(int candId, int vacId);

    public List<?> readOnlineAssementCandidate(int userMaster);

    public int GETByCandidateId(int candidateId);

}
