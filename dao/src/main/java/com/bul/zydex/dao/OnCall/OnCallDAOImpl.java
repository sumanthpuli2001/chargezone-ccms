/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.OnCall;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.OnCall;
import java.util.List;

/**
 *
 * @author admin
 */
public class OnCallDAOImpl<T> extends GenericsDAOImpl<T> implements OnCallDAO<T>{

    @Override
    protected Class getDomainClass() {
         return OnCall.class;
    }

    @Override
    public List<?> userWiseOnCallList(int id) {
        String query = "";
        query += " FROM OnCall a"
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
    public List<?> approvalmanagerWiseOnCallList(int id) {
        String query = "";
        query += " SELECT a.id,b.employeeName,a.fromDate,a.toDate,a.description,a.status,a.dateOfSubmit"
                + " FROM OnCall a,"
                + " EmployeeMaster b"
                + " Where a.userMasterId=b.userMaster.id"
                + " and b.reportingManagerLevel1=" + id
                + "Order by a.id Desc";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> approvalmanagerWiseOnCallList(String startdate, Integer id) {
        String query = "";
        query += " select a"
                + " From OnCall a "
                + " Where a.userMasterId=" + id
                + " and status = 3"
                + " and DATE_FORMAT(STR_TO_DATE(a.fromDate,'%d/%m/%Y'),'%d/%m/%Y') = DATE_FORMAT(STR_TO_DATE('" + startdate + "','%d/%m/%Y'),'%d/%m/%Y')";
        return getHibernateTemplate().find(query);
    }
    
    
}
