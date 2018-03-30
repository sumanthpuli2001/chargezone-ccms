/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Recruitment;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.CandidateJobApplication;
import java.util.List;

/**
 *
 * @author Vikas
 */
public interface CandidateJobApplicationDAO<T> extends GenericsDAO<T> {

    public List<?> readByCandidateId(int candidateId);

    public List<?> readCandidateApplyForJob();

    public CandidateJobApplication readByCandidateIdAndVacancyId(int candId, int vacId);

    public List<?> readOnlineAssementCandidate(int userMaster);

    public int GETByCandidateId(int candidateId);

    public int GETByCandidateIdNew(int candidateId, int vacanyId);

    public List<?> deleteVacancyId(String vacancyId);
}
