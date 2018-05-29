/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.CandiateJobApply;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.CandidateAcademicQualification;
import java.util.List;

/**
 *
 * @author DELL3
 */
public class CandidateAcademicQualificationDAOImpl<T> extends GenericsDAOImpl<T> implements CandidateAcademicQualificationDAO<T> {

    @Override
    protected Class getDomainClass() {
        return CandidateAcademicQualification.class;
    }

    @Override
    public CandidateAcademicQualification readByApplyJobId(int id) {
        CandidateAcademicQualification candidateAcademicQualification = new CandidateAcademicQualification();
        String query = " SELECT a "
                + " FROM CandidateAcademicQualification a "
                + " Where a.candidateApplyJob.id = " + id;

        List<?> list = getHibernateTemplate().find(query);

        if (!list.isEmpty()) {
            candidateAcademicQualification = (CandidateAcademicQualification) list.get(0);
        } else {
            candidateAcademicQualification = null;
        }
        return candidateAcademicQualification;

    }

    @Override
    public List<?> readListByApplyJobId(Integer id) {
        
        String query = " SELECT a "
                + " FROM CandidateAcademicQualification a "
                + " Where a.candidateApplyJob.id = " + id;

        List<?> list = getHibernateTemplate().find(query);

        return list;
    }

}
