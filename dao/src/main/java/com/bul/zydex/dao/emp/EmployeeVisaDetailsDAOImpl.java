/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.emp;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.EmployeeVisaDetails;
import java.util.List;

/**
 *
 * @author admin
 */
public class EmployeeVisaDetailsDAOImpl<T> extends GenericsDAOImpl<T> implements EmployeeVisaDetailsDAO<T> {

    @Override
    protected Class getDomainClass() {
        return EmployeeVisaDetails.class;
    }

    @Override
    public List<?> readByemployeeId(Integer id) {
        String query = "";
        query += "select a"
                + " FROM EmployeeVisaDetails a"
                + " where a.employeeMaster.id=" + id;
        return getHibernateTemplate().find(query);
    }

    @Override
    public void deleteByemployeeId(Integer id) {
        String query = "Delete from EmployeeVisaDetails a "
                + " where a.employeeMaster.id=" + id;

        getHibernateTemplate().bulkUpdate(query);
    }

    @Override
    public boolean employeeVisadetailsexist(Integer id) {
        String query = "";
        query += ""
                + " From EmployeeVisaDetails a "
                + " WHERE a.employeeMaster.id =" + id;

        List list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            return true;
        }
        return false;
    }
    
}
