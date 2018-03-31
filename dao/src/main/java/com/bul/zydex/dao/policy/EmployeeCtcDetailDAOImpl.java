/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.policy;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.EmployeeCtcDetail;
import com.bul.zydex.model.EmployeeMaster;
import java.util.List;

/**
 *
 * @author Hussain
 */
public class EmployeeCtcDetailDAOImpl<T> extends GenericsDAOImpl<T> implements EmployeeCtcDetailDAO<T> {

    @Override
    protected Class getDomainClass() {
        return EmployeeCtcDetail.class;
    }

    @Override
    public List<?> fetchctcData(int empId) {
        String query = "";
        query += " select b.id,b.ctcName,a.amount"
                + " FROM EmployeeCtcDetail a "
                + " left join a.ctcAllowance b"
                + " left join a.employeeMaster c"
                + " where c.id=" + empId;

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readctc(int employeeid) {
        String query = "";
        query += "select a.amount,b.policyName"
                + " FROM EmployeeCtcDetail a "
                + " left join a.ctcAllowance b"
                + " where a.employeeMaster.id=" + employeeid;

        return getHibernateTemplate().find(query);
    }

}
