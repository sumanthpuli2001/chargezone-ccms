/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.CandiateJobApply;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.CandidateApplyJob2;
import java.util.List;

/**
 *
 * @author DELL3
 */
public class CandidateApplyJob2DAOImpl<T> extends GenericsDAOImpl<T> implements CandidateApplyJob2DAO<T> {

    @Override
    protected Class getDomainClass() {
        return CandidateApplyJob2.class;
    }
    
    @Override
    public CandidateApplyJob2 readByApplyJobId(int id) {
        CandidateApplyJob2 candidateApplyJob = new CandidateApplyJob2();
        String query = " SELECT a "
                + " FROM CandidateApplyJob2 a "
                + " Where a.candidateApplyJob.id = " + id;

        List<?> list = getHibernateTemplate().find(query);

        if (!list.isEmpty()) {
            candidateApplyJob = (CandidateApplyJob2) list.get(0);
        } else {
            candidateApplyJob = null;
        }
        return candidateApplyJob;

    }
}
