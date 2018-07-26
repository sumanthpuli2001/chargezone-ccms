/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.ProjectManagement;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.CreateTask;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Aman
 */
public class CreateTaskDAOImpl<T> extends GenericsDAOImpl<T> implements CreateTaskDAO<T> {

    @Override
    protected Class getDomainClass() {
        return CreateTask.class;
    }

    @Override
    public List<?> readTaskList(String id) {
        String query = "";
        query = " Select a.id,a.name,a.taskCompleted,p.name,a.plannedStart,a.plannedFinish "
                + " From CreateTask a "
                + " left join a.priorityMaster p "
                + "Where a.projectManagementMaster= " + id;
//        List<?> list = getHibernateTemplate().find(query);
//        return list;
        List s = getSession().createQuery(query).list();
        return s;
    }

    @Override
    public List<?> deleteTask(String createTaskId) {
        String query = "";
        query += "  "
                + " select a"
                + " FROM CreateTask a "
                + " WHERE a.id = " + createTaskId;
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }


}
