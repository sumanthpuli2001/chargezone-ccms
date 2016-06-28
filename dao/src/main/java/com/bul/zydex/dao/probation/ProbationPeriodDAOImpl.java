/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.probation;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.LeaveEmployeeDetail;
import com.bul.zydex.model.ProbationPeriod;
import java.util.List;

/**
 *
 * @author AJAY
 */
public class ProbationPeriodDAOImpl<T> extends GenericsDAOImpl<T> implements ProbationPeriodDAO<T> {

    @Override
    protected Class getDomainClass() {
        return ProbationPeriod.class;
    }

    @Override
    public List<?> readprobationPeriod() {

        String query = "";
        query += " Select a.id,a.period,b.designationName"
                + " From ProbationPeriod a "
                + " left join a.designationMaster b";
        return getHibernateTemplate().find(query);
    }

    @Override
    public boolean isExist(T object) {
        boolean flag = false;
        ProbationPeriod probationPeriod = (ProbationPeriod) object;
        List list = getHibernateTemplate().find("from ProbationPeriod a where a.designationMaster=" + probationPeriod.getDesignationMaster().getId());
        //To change body of generated methods, choose Tools | Templates.
        if (list.isEmpty()) {
            flag = true;
        }
        return flag;
    }

    @Override
    public List<?> readbyDesignation(int id) {

        String query = "";
        query += " Select a.period"
                + " From ProbationPeriod a "
                + " where a.designationMaster = " + id;
        return getHibernateTemplate().find(query);
    }
}
