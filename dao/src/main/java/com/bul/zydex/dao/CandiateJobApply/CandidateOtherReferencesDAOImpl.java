/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.CandiateJobApply;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.CandidateOtherReferences;
import java.util.List;

/**
 *
 * @author DELL3
 */
public class CandidateOtherReferencesDAOImpl<T> extends GenericsDAOImpl<T> implements CandidateOtherReferencesDAO<T> {

    @Override
    protected Class getDomainClass() {
        return CandidateOtherReferences.class;
    }

    @Override
    public CandidateOtherReferences readByApplyJobId(int id) {
        CandidateOtherReferences candidateOtherReferences = new CandidateOtherReferences();
        String query = " SELECT a "
                + " FROM CandidateOtherReferences a "
                + " Where a.candidateApplyJob.id = " + id;

        List<?> list = getHibernateTemplate().find(query);

        if (!list.isEmpty()) {
            candidateOtherReferences = (CandidateOtherReferences) list.get(0);
        } else {
            candidateOtherReferences = null;
        }
        return candidateOtherReferences;
    }

    @Override
    public List<?> readListByApplyJobId(Integer id) {
        String query = " SELECT a "
                + " FROM CandidateOtherReferences a "
                + " Where a.candidateApplyJob.id = " + id;

        List<?> list = getHibernateTemplate().find(query);

        return list;
    }
}
