/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Training;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.TrainingAssessment;
import java.util.List;

/**
 *
 * @author Aman
 */
public class TrainingAssessmentDAOImpl<T> extends GenericsDAOImpl<T> implements TrainingAssessmentDAO<T> {

    @Override
    protected Class getDomainClass() {
        return TrainingAssessment.class;
    }

    @Override
    public List<?> readOnlineAssementCandidateTraningList(int empid) {
        String query = "";
        String condition = "";

        //                  0   1   2       3                       4       5               6           7           8       9               10
        query += "Select a.id,b.id,c.id,a.passingPercentage,a.validityFrom,a.validityTo,a.duration,a.noOfAttampt,a.noOfQue,a.totalMarks,c.paperName"
                + " From TrainingAssessment a"
                + " LEFT JOIN a.employeeMaster b"
                + " LEFT JOIN a.questionPaper c"
                + " Where b.id=" + empid
                + " and a.noOfAttampt >0 "
                + " and str_to_date(Date_format(now(),'%d/%m/%Y'),'%d/%m/%Y') between str_to_date(a.validityFrom,'%d/%m/%Y') "
                + " and str_to_date(a.validityTo,'%d/%m/%Y')"
                + " and a.status =0 order by a.id desc";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readTrainingAssementList(int trainingMasterId, int empId) {
        String query = "";
        //0   1    2      3    4                   5               6           7           8           9           10          11          12
        query += "Select a.id,b.id,c.id,d.id,a.passingPercentage,a.validityFrom,a.validityTo,a.duration,a.noOfAttampt,a.noOfQue,a.totalMarks,c.paperName,a.assessmentResultStatus"
                + " From TrainingAssessment a"
                + " LEFT JOIN a.employeeMaster b"
                + " LEFT JOIN a.questionPaper c"
                + " LEFT JOIN a.trainingMaster d"
                + " Where d.id=" + trainingMasterId
                + " and b.id=" + empId;

        return getHibernateTemplate().find(query);
    }

}
