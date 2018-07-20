/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.ProjectManagement;

import com.bul.zydex.dao.ProjectManagement.TaskEmployeeDepartmentDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Aman
 */
public class TaskEmployeeDepartmentServiceImpl<T> extends GenericsServiceImpl<T> implements TaskEmployeeDepartmentService<T>{
    private TaskEmployeeDepartmentDAO<T> taskEmployeeDepartmentDAO;

    public TaskEmployeeDepartmentDAO<T> getTaskEmployeeDepartmentDAO() {
        return taskEmployeeDepartmentDAO;
    }

    public void setTaskEmployeeDepartmentDAO(TaskEmployeeDepartmentDAO<T> taskEmployeeDepartmentDAO) {
        this.taskEmployeeDepartmentDAO = taskEmployeeDepartmentDAO;
        setGenericsDAO(taskEmployeeDepartmentDAO);
    }

    @Override
    public List<?> readDepartmentAndEmp(String id) {
        return taskEmployeeDepartmentDAO.readDepartmentAndEmp(id);
    }
    
    
}
