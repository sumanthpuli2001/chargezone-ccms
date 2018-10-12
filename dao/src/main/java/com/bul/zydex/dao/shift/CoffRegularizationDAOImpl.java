/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.shift;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.CoffRegularization;
import java.util.List;

/**
 *
 * @author Hussain
 */
public class CoffRegularizationDAOImpl<T> extends GenericsDAOImpl<T> implements CoffRegularizationDAO<T> {

    @Override
    protected Class getDomainClass() {
        return CoffRegularization.class;
    }

    @Override
    public List<?> userWiseCoffRegularizationList(int id) {
        String query = "";
        query += " FROM CoffRegularization a"
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
    public List<?> approvalLeval1WiseCoffRegularizationList(int id) {
         String query = "";
        query += " SELECT a.id,b.employeeName,a.startDateCoff,a.endDateCoff,a.status,a.dateOfSubmit"
                + " FROM CoffRegularization a,"
                + " EmployeeMaster b"
                + " Where a.userMasterId=b.userMaster.id"
                + " and b.reportingManagerLevel1=" + id
                + "Order by a.id Desc";

        return getHibernateTemplate().find(query);
    }

}
