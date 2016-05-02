/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.appraisalPerformance;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.AppraisalPerformanceBehaviors;
import java.util.List;

/**
 *
 * @author Dhaval Parmar<dhaval@bulwarks.com>
 */
public class AppraisalPerformanceBehaviorsDAOImpl<T> extends GenericsDAOImpl<T> implements AppraisalPerformanceBehaviorsDAO<T> {

    @Override
    protected Class getDomainClass() {
        return AppraisalPerformanceBehaviors.class;
    }

    @Override
    public List<?> readBehaviorsDetail(T object) {
        AppraisalPerformanceBehaviors appraisalPerformanceBehaviors = (AppraisalPerformanceBehaviors) object;
        String query = "";
        query += " "
                ///                + " SELECT a.id, a.appraisalPerformanceMaster"
                + " FROM AppraisalPerformanceBehaviors a "
                + " WHERE a.appraisalPerformanceMaster = " + appraisalPerformanceBehaviors.getAppraisalPerformanceMaster().getId();

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readperformanceRatingList(final int currentYear, int id) {
//        String hqlQuery = "Select sum(apb.endYearScore)/5,"
//                + " apb.appraisalPerformanceMaster.id,"
//                + " apm.employeeMaster.id,"
//                + " dm.departmentName,"
//                + " em.departmentMaster.id,"
//                + " count(em.id)"
//                + " from AppraisalPerformanceBehaviors apb"
//                + " right join apb.appraisalPerformanceMaster apm"
//                + " right join apm.employeeMaster em"
//                + " right join em.departmentMaster dm"
//                + " where apm.behaviorsYear = " + currentYear + " and apb.endYearScore is not null"
//                + " group by apb.appraisalPerformanceMaster.id";
        
//        **********************Dhaval Patel*******************************
        String hqlQuery = "Select apb.behaviorsFinalscore"
                + " from AppraisalPerformanceMaster apb ,"
                + " EmployeeMaster em,"
                + " DepartmentMaster dm"
                + " where apb.employeeMaster.id=em.id "
                + " and em.departmentMaster.id= dm.id"
                + " and apb.behaviorsYear = " + currentYear 
                + " and dm.id=" + id;
//        **********************Dhaval Patel*******************************
        
        return getHibernateTemplate().find(hqlQuery);
    }

}
