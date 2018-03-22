/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.CandiateJobApply;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.CandidateApplyJob;
import java.util.List;

/**
 *
 * @author Aman
 */
public class CandidateJobApplyDAOImpl<T> extends GenericsDAOImpl<T> implements CandidateJobApplyDAO<T> {

    @Override
    protected Class getDomainClass() {
        return CandidateApplyJob.class;
    }

    @Override
    public List<?> fetchcandidatelist() {
        String query = "";
        query += " "
                + " SELECT a.id, a.name, a.highestEducationQualification, a.emailId, a.experianceDateJoiningYear "
                + " FROM CandidateApplyJob a "
                //                + " LEFT JOIN a.VacancyMaster b "
                + " order by a.id desc";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readProfileByCandidateUserID(int userId) {

        String query = " SELECT a "
                + " FROM CandidateApplyJob a "
                + " LEFT JOIN a.applayJobUserMaster b "
                + " Where a.applayJobUserMaster.id = " + userId;

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readOnlineAssementCandidate(int userMaster) {
        String query = "";
        String condition = "";
        query += "Select c.id,b.id"
                + " From CandidateApplyJob a"
                + " LEFT JOIN a.applayJobUserMaster b"
                + " LEFT JOIN a.vacancyId c"
                + " Where b.id=" + userMaster;

        return getHibernateTemplate().find(query);
    }

    @Override
    public CandidateApplyJob readByapplayjobusermasterid(int id) {
        CandidateApplyJob candidateApplyJob = new CandidateApplyJob();
        String query = " SELECT a "
                + " FROM CandidateApplyJob a "
                + " Where a.applayJobUserMaster.id = " + id;

        List<?> list = getHibernateTemplate().find(query);

        if (!list.isEmpty()) {
            candidateApplyJob = (CandidateApplyJob) list.get(0);
        } else {
            candidateApplyJob = null;
        }
        return candidateApplyJob;

    }

    @Override
    public boolean isExist(String name) {
        boolean flag = false;
        List list = getHibernateTemplate().find("from CandidateApplyJob where photograph='" + name + "'");
        if (list.isEmpty()) {
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean isExistCertificateAttach(String name) {
        boolean flag = false;
        List list = getHibernateTemplate().find("from CandidateApplyJob where certificateAttach='" + name + "'");
        if (list.isEmpty()) {
            flag = true;
        }
        return flag;
    }

}
