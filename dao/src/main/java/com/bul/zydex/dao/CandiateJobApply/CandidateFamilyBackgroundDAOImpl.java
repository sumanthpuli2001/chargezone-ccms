/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.CandiateJobApply;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.CandidateFamilyBackground;
import java.util.List;

/**
 *
 * @author DELL3
 */
public class CandidateFamilyBackgroundDAOImpl<T> extends GenericsDAOImpl<T> implements CandidateFamilyBackgroundDAO<T> {

    @Override
    protected Class getDomainClass() {
        return CandidateFamilyBackground.class;
    }

    @Override
    public CandidateFamilyBackground readByApplyJobId(int id) {
        CandidateFamilyBackground candidateFamilyBackground = new CandidateFamilyBackground();
        String query = " SELECT a "
                + " FROM CandidateFamilyBackground a "
                + " Where a.candidateApplyJob.id = " + id;

        List<?> list = getHibernateTemplate().find(query);

        if (!list.isEmpty()) {
            candidateFamilyBackground = (CandidateFamilyBackground) list.get(0);
        } else {
            candidateFamilyBackground = null;
        }
        return candidateFamilyBackground;
    }

    @Override
    public List<?> readListByApplyJobId(Integer id) {
        String query = " SELECT a "
                + " FROM CandidateFamilyBackground a "
                + " Where a.candidateApplyJob.id = " + id;

        List<?> list = getHibernateTemplate().find(query);

        return list;
    }

}
