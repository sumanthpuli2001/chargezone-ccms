/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.CandiateJobApply;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.CandidateAcademicQualification;
import com.bul.zydex.model.CandidateExperienceDetail;
import java.util.List;

/**
 *
 * @author DELL3
 */
public class CandidateExperienceDetailDAOImpl<T> extends GenericsDAOImpl<T> implements CandidateExperienceDetailDAO<T> {

    @Override
    protected Class getDomainClass() {
        return CandidateExperienceDetail.class;
    }

    @Override
    public CandidateExperienceDetail readByApplyJobId(int id) {
        CandidateExperienceDetail candidateExperienceDetail = new CandidateExperienceDetail();
        String query = " SELECT a "
                + " FROM CandidateExperienceDetail a "
                + " Where a.candidateApplyJob.id = " + id;

        List<?> list = getHibernateTemplate().find(query);

        if (!list.isEmpty()) {
            candidateExperienceDetail = (CandidateExperienceDetail) list.get(0);
        } else {
            candidateExperienceDetail = null;
        }
        return candidateExperienceDetail;
    }

    @Override
    public List<?> readListByApplyJobId(Integer id) {
        String query = " SELECT a "
                + " FROM CandidateExperienceDetail a "
                + " Where a.candidateApplyJob.id = " + id;

        List<?> list = getHibernateTemplate().find(query);

        return list;
    }

}
