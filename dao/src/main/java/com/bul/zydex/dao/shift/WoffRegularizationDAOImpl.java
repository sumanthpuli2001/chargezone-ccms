/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.shift;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.WoffRegularization;
import java.util.List;

/**
 *
 * @author Hussain
 */
public class WoffRegularizationDAOImpl<T> extends GenericsDAOImpl<T> implements WoffRegularizationDAO<T> {

    @Override
    protected Class getDomainClass() {
       return WoffRegularization.class;
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
    public List<?> approvalLeval1WiseShiftRegularizationList(int id) {
        String query = "";
        query += " SELECT a.id,b.employeeName,a.rotationDate,a.rotationDate,a.dateOfSubmit,a.status,a.dateOfSubmit"
                + " FROM WoffRegularization a,"
                + " EmployeeMaster b"
                + " Where a.userMasterId=b.userMaster.id"
                + " and b.reportingManagerLevel1=" + id
                + "Order by a.id Desc";

        return getHibernateTemplate().find(query);
    }
    
}
