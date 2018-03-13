/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Recruitment;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.OnlineAssessment;
import java.util.List;

/**
 *
 * @author Admin
 */
public class OnlineAssessmentDAOImpl<T> extends GenericsDAOImpl<T> implements OnlineAssessmentDAO<T> {

    @Override
    protected Class getDomainClass() {
        return OnlineAssessment.class;
    }

    @Override
    public List<?> readOnlineAssementCandidateList(int candidateJobApplicationID) {
        String query = "";
        String condition = "";
        query += "Select a.id,b.id,c.id,a.passingPercentage,a.validityFrom,a.validityTo,a.duration,a.noOfAttampt,a.noOfQue,a.totalMarks,c.paperName"
                + " From OnlineAssessment a"
                + " LEFT JOIN a.candidateJobApplication b"
                + " LEFT JOIN a.questionPaper c"
                + " Where b.id=" + candidateJobApplicationID;

        return getHibernateTemplate().find(query);
    }

}
