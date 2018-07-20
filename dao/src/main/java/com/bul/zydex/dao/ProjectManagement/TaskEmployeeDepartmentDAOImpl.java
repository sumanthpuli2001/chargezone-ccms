/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.ProjectManagement;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.TaskEmployeeDepartment;
import java.util.List;

/**
 *
 * @author Aman
 */
public class TaskEmployeeDepartmentDAOImpl<T> extends GenericsDAOImpl<T> implements TaskEmployeeDepartmentDAO<T> {

    @Override
    protected Class getDomainClass() {
        return TaskEmployeeDepartment.class;
    }

    @Override
    public List<?> readDepartmentAndEmp(String id) {
        String query = "";
        query = " Select a.id,d.departmentName,e.employeeName,a.authorize,d.id "
                + " From TaskEmployeeDepartment a  "
                + " left join a.departmentMaster d  "
                + " left join a.employeeMaster e"
                + " Where a.createTask =" + id ;

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

}
