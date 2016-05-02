/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.appraisalPerformance;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.UpdateAppraisalPerformanceKra;
import java.util.List;

/**
 *
 * @author admin
 */
public class UpdateAppraisalPerformanceKraDAOImpl<T> extends GenericsDAOImpl<T> implements UpdateAppraisalPerformanceKraDAO<T> {

    @Override
    protected Class getDomainClass() {
        return UpdateAppraisalPerformanceKra.class;
    }

    @Override
    public List<?> readByUpdateKragoal(T object) {
        //EmployeeMaster employeeMaster = (EmployeeMaster) object;
        UpdateAppraisalPerformanceKra updateAppraisalPerformanceKra = (UpdateAppraisalPerformanceKra) object; 
        String query = "";   
//
//        query += " Select a.employeeId, a.employeeName, b.designationName, d.level, c.departmentName, a.workLocation ,a.reportingManagerLevel1 "
//                + "FROM EmployeeMaster a"
//                + " LEFT JOIN a.designationMaster b"
//                + " LEFT JOIN a.departmentMaster c"
//                + " LEFT JOIN a.levelMaster d"
//                + " WHERE a.userMaster.id = " + employeeMaster.getUserMaster().getId();
        
        query += " Select a.id,a.updateKra, a.updateMetric, a.updateDate,a.name,a.weighted "
                + "FROM UpdateAppraisalPerformanceKra a"
                + " LEFT JOIN a.appraisalPerformanceKra b"   
                + " WHERE a.appraisalPerformanceKra.id = " + updateAppraisalPerformanceKra.getAppraisalPerformanceKra().getId();

        return getHibernateTemplate().find(query);  
    }
    
    @Override
    public List<?> readByUserUpdateKra(T object) {
        UpdateAppraisalPerformanceKra updateAppraisalPerformanceKra = (UpdateAppraisalPerformanceKra) object; 
        String query = "";

        query += " FROM UpdateAppraisalPerformanceKra a"
                + " WHERE a.appraisalPerformanceKra.id = " + updateAppraisalPerformanceKra.getId();

        return getHibernateTemplate().find(query);
    }
    @Override
    public List<?> readByKraIdForDelete(T object) {
        UpdateAppraisalPerformanceKra updateAppraisalPerformanceKra = (UpdateAppraisalPerformanceKra) object; 
        String query = "";

        query += " FROM UpdateAppraisalPerformanceKra a"
                + " WHERE a.appraisalPerformanceKra = " + updateAppraisalPerformanceKra.getAppraisalPerformanceKra().getId();

        return getHibernateTemplate().find(query);
    }
}   
