/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.questionlibrary;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.QuestionLibrary;
import java.util.List;

/**
 *
 * @author Rishi
 */
public class QuestionLibraryDAOImpl<T> extends GenericsDAOImpl<T> implements QuestionLibraryDAO<T> {

    @Override
    protected Class getDomainClass() {
        return QuestionLibrary.class;
    }

    @Override
    public List<?> readAllQuestionLibrary() {
        String query = "";
//                            0   1           2       3       4       5       6       7
        query += " select a.id,a.question,a.type,a.marks,a.ansId,a.satatus,b.id,b.employeeCategory "
                + " From QuestionLibrary a "
                + " Left join a.mprEmployeeCategory b"
                + " ORDER BY a.id desc";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readByQusNameCatyMark(int categoryId, String Question, int marks) {
        String query = "";
        String condition = "";

        if (0 != categoryId) {
            condition += "Where m.id=" + categoryId;
        }
        if (!Question.equals("")) {
            if (condition.equals("")) {
                condition += "Where a.question like '%" + Question + "%'";
            } else {
                condition += "and a.question like '%" + Question + "%'";
            }
        }
        if (0 != marks) {
            if (condition.equals("")) {
                condition += "Where a.marks = " + marks;
            } else {
                condition += "and a.marks = " + marks;
            }
        }

//     
        if (!condition.equals("")) {
            query += " Select a "
                    + " From QuestionLibrary a "
                    + " left join a.mprEmployeeCategory m "
                    +  condition
                    + " order by a.id desc ";
        } else {
            query += " Select a "
                    + " From QuestionLibrary a "
                    + " left join a.mprEmployeeCategory m "
                    + " order by a.id desc ";
        }

        return getHibernateTemplate().find(query);
    }
    

}
