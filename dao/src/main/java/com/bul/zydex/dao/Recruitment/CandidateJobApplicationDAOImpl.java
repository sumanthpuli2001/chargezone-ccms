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
        String query = " SELECT a.id as cjaId,b.id as cajId,c.id as vmId,c.name as vacancyName,c.numberOfPosition,"
                + " c.experience,c.fromDate,c.toDate,a.status "
                + " FROM CandidateJobApplication a "
                + " LEFT JOIN a.candidateApplyJob b "
                + " LEFT JOIN a.vacancyMaster c "
                + " Where a.candidateApplyJob.id = " + candidateId;

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readCandidateApplyForJob() {
        String query = " SELECT a.id as cjaId,b.id as cajId,c.id as vmId,b.name as candidatename, "
                + " b.highestEducationQualification,b.emailId,b.experianceDateJoiningYear,c.name as vacancyName "
                + " FROM CandidateJobApplication a "
                + " LEFT JOIN a.candidateApplyJob b "
                + " LEFT JOIN a.vacancyMaster c "
                + " Where a.status=1 ";

        List<?> list = getHibernateTemplate().find(query);
        return list;

    }

    @Override
    public CandidateJobApplication readByCandidateIdAndVacancyId(int candId, int vacId) {
        CandidateJobApplication application = new CandidateJobApplication();
        String query = " SELECT a "
                + " FROM CandidateJobApplication a "
                + " LEFT JOIN a.candidateApplyJob b "
                + " LEFT JOIN a.vacancyMaster c "
                + " Where a.candidateApplyJob.id = " + candId
                + " And a.vacancyMaster.id = " + vacId;

        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            application = (CandidateJobApplication) list.get(0);
        } else {
            application = null;
        }
        return application;
    }

    @Override
    public List<?> readOnlineAssementCandidate(int userMaster) {
        String query = "";
        String condition = "";
        query += "Select a.id,b.id,c.id,d.id"
                + " From CandidateJobApplication a"
                + " LEFT JOIN a.applayJobUserMaster b"
                + " LEFT JOIN a.candidateApplyJob c"
                + " LEFT JOIN a.vacancyMaster d"
                + " Where b.id=" + userMaster;

        return getHibernateTemplate().find(query);
    }

    @Override
    public int GETByCandidateId(int candidateId) {

        Integer i = 0;
        String query = " SELECT a.id "
                + " FROM CandidateJobApplication a "
                + " LEFT JOIN a.candidateApplyJob b "
                + " Where a.candidateApplyJob.id = " + candidateId;

        List list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            i = (Integer) list.get(0);
            
        }
        return i;
    }

}
