/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.questionlibrary;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.QuestionDetails;
import java.util.List;

/**
 *
 * @author Admin
 */
public class QuestionDetailsDAOImpl<T> extends GenericsDAOImpl<T> implements QuestionDetailsDAO<T> {

    @Override
    protected Class getDomainClass() {
        return QuestionDetails.class;
    }

    @Override
    public List<?> readByQuePaperId(int qpId) {
        String query = "";
        query += " select qd.id,ql.question,ql.marks "
                + " From QuestionDetails qd "
                + " Left join qd.questionPaper qp "
                + " Left join qd.questionLibrary ql "
                + " where qp.id =" + qpId;
        return getHibernateTemplate().find(query);
    }

    @Override
    public boolean isExistQuestion(int QlId, int QpId) {
        boolean flag = false;
        String query = ""
                + " From QuestionDetails a "
                + " Where a.questionLibrary.id = " + QlId
                + " and a.questionPaper.id = " + QpId;
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            flag = true;
        }
        return flag;
    }

    @Override
    public void deleteByQPaperId(T object) {
        QuestionDetails questionDetails = (QuestionDetails) object;
        boolean flag = false;
        String query = "Delete"
                + " From QuestionDetails a"
                + " Where a.questionPaper =" + questionDetails.getQuestionPaper().getId();

        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            flag = true;
        }

    }

    @Override
    public List<?> getTotalMarksAndNoOfQueByQuePaperId(int qpId) {
        String query = "";
//                           
        query += " select (select count(qd.id) from QuestionDetails qd where qd.questionPaper.id =" + qpId + ") as NumberOfQues, b.totalMarks "
                + " From QuestionDetails a "
                + " left join a.questionPaper b "
                + " where b.id= " + qpId
                + " group BY b.id ";
        return getHibernateTemplate().find(query);
    }

}
