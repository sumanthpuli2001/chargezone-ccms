/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Training;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.EmployeeFeedback;
import java.util.List;

/**
 *
 * @author Aman
 */
public class EmployeeFeedbackDAOImpl<T> extends GenericsDAOImpl<T> implements EmployeeFeedbackDAO<T>{

    @Override
    protected Class getDomainClass() {
        return EmployeeFeedback.class;
    }
    
    @Override
    public Boolean checkFeedbackforEmp(int empId, int trainingId) {
        String query = "select b.id"
                + " FROM EmployeeFeedback b"
                + " Left Join b.trainingMaster c"
                + " where b.trainingMaster.id=" + trainingId+" and b.employeeMaster.id="+empId
                + " And c.status=1";
        List<?> list = getHibernateTemplate().find(query);
        if (list.isEmpty()) {
            return true;
        }
        return false;
    }
    
}
