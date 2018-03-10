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
    public List<?> readOnlineAssementCandidate(int userMaster) {
        String query = "";
        String condition = "";
        query += "Select c.id,b.id"
                + " From CandidateApplyJob a"
                + " LEFT JOIN a.applayJobUserMasterId b"
                + " LEFT JOIN a.vacancyId c"
                + " Where b.id=" + userMaster;

        return getHibernateTemplate().find(query);
    }

}
