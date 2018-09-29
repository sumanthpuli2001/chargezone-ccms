/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.CandidateF2FRequest;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.CandidateF2FObservation;
import com.bul.zydex.model.CandidateF2FRequest;
import java.util.List;

/**
 *
 * @author Hussain
 */
public class CandidateF2FObservationDAOImpl<T> extends GenericsDAOImpl<T> implements CandidateF2FObservationDAO<T> {

    @Override
    protected Class getDomainClass() {
        return CandidateF2FObservation.class;
    }

//    @Override
//    public List<?> ReadByIdCandidateF2FOb(int empId, int vancyId, int applycandidate, int applicationID) {
//        CandidateF2FRequest cffr = new CandidateF2FRequest();
//        String query = " SELECT a "
//                + " FROM CandidateF2FObservation a "
//                + " Where a.candidateJobApplication.id =" + applicationID
//                + " and a.vacancyMaster.id =" + vancyId
//                + " and a.candidateApplyJob.id =" + applycandidate
//                + " and a.hrEmpId =" + empId;
//
//        List<?> list = getHibernateTemplate().find(query);
//        return list;
//    }
    @Override
    public CandidateF2FObservation ReadByIdCandidateF2FOb(int empId, int vancyId, int applycandidate, int applicationID) {
        CandidateF2FObservation candidateF2FObservation = new CandidateF2FObservation();
        String query = " SELECT a "
                + " FROM CandidateF2FObservation a "
                + " Where a.candidateJobApplication.id =" + applicationID
                + " and a.vacancyMaster.id =" + vancyId
                + " and a.candidateApplyJob.id =" + applycandidate
                + " and a.hrEmpId =" + empId;

        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            candidateF2FObservation = (CandidateF2FObservation) list.get(0);
        } else {
            candidateF2FObservation = null;
        }
        return candidateF2FObservation;
    }

    @Override
    public List<?> ReadByIdCandidateF2FObHr(int vancyId, int applycandidate, int applicationID) {
        CandidateF2FObservation candidateF2FObservation = new CandidateF2FObservation();
        String query = " SELECT a "
                + " FROM CandidateF2FObservation a "
                + " Where a.candidateJobApplication.id =" + applicationID
                + " and a.vacancyMaster.id =" + vancyId
                + " and a.candidateApplyJob.id =" + applycandidate;

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

}
