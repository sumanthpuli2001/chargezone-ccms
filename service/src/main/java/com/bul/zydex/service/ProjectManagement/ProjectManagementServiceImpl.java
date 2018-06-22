/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.ProjectManagement;

import com.bul.zydex.dao.ProjectManagement.ProjectManagementDAO;
import com.bul.zydex.service.GenericsServiceImpl;

/**
 *
 * @author Aman
 */
public class ProjectManagementServiceImpl<T> extends GenericsServiceImpl<T> implements ProjectManagementService<T>{
    private ProjectManagementDAO<T> projectManagementDAO;

    public ProjectManagementDAO<T> getProjectManagementDAO() {
        return projectManagementDAO;
    }

    public void setProjectManagementDAO(ProjectManagementDAO<T> projectManagementDAO) {
        this.projectManagementDAO = projectManagementDAO;
        setGenericsDAO(projectManagementDAO);
    }
    
    
}
