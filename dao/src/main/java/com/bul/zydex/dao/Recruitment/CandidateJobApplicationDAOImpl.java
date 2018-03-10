/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Recruitment;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.CandidateJobApplication;
import java.util.List;

/**
 *
 * @author Vikas
 */
public class CandidateJobApplicationDAOImpl<T> extends GenericsDAOImpl<T> implements CandidateJobApplicationDAO<T> {

    @Override
    protected Class getDomainClass() {
        return CandidateJobApplication.class;
    }

    @Override
    public List<?> readByCandidateId(int candidateId) {
           String query = " SELECT c "
                + " FROM CandidateJobApplication a "
                + " LEFT JOIN a.candidateApplyJob b "
                + " LEFT JOIN a.vacancyMaster c "
                + " Where a.candidateApplyJob.id = " + candidateId;

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

}
