/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.ProjectManagement;

import com.bul.zydex.dao.ProjectManagement.CreateTaskDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Aman
 */
public class CreateTaskServiceImpl<T>extends GenericsServiceImpl<T> implements CreateTaskService<T>{
    
    private CreateTaskDAO<T>createTaskDAO;

    public CreateTaskDAO<T> getCreateTaskDAO() {
        return createTaskDAO;
    }

    public void setCreateTaskDAO(CreateTaskDAO<T> createTaskDAO) {
        this.createTaskDAO = createTaskDAO;
        setGenericsDAO(createTaskDAO);
    }

    @Override
    public List<?> readTaskList(String id) {
        return createTaskDAO.readTaskList(id);
    }

    @Override
    public List<?> deleteTask(String createTaskId) {
        return createTaskDAO.deleteTask(createTaskId);
    }


    
}
