/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.attendanceRegularization;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.OTRegularization;
import java.util.List;

/**
 *
 * @author Success
 */
public class OTRegularizationDAOImpl<T> extends GenericsDAOImpl<T> implements OTRegularizationDAO<T> {

    @Override
    protected Class getDomainClass() {
        return OTRegularization.class;
    }

    @Override
    public List<?> userWiseOTRegularizationList(int id) {
       String query = "";
        query += " FROM OTRegularization a"
                + " Where a.userMasterId=" + id
                + " ORDER BY a.id desc";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> userReportingManager(int id) {
        String query = "";
        query += " FROM EmployeeMaster a"
                + " Where a.userMaster.id=" + id;
        List list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> approvalLeval1WiseOtRegularizationList(int id) {
       String query = "";
        query += " SELECT a.id,b.employeeName,a.startDateTime,a.endDateTime,a.reason,a.status,a.dateOfSubmit"
                + " FROM OTRegularization a,"
                + " EmployeeMaster b"
                + " Where a.userMasterId=b.userMaster.id"
                + " and b.reportingManagerLevel1=" + id
                + "Order by a.id Desc";

        return getHibernateTemplate().find(query);
    }
    
}
