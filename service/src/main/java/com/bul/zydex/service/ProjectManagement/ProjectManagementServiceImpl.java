/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.ProjectManagement;

import com.bul.zydex.dao.ProjectManagement.ProjectManagementDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

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

    @Override
    public List<?> readProjectMList() {
        return projectManagementDAO.readProjectMList();
    }

    @Override
    public List<?> readManagerEmployeeDepart(T object) {
        return projectManagementDAO.readManagerEmployeeDepart(object);
    }

    @Override
    public List<?> deleteProjectManagement(String projectId) {
        return projectManagementDAO.deleteProjectManagement(projectId);
    }

    @Override
    public List<?> readProjectEmployee(int projectEmpid) {
        return  projectManagementDAO.readProjectEmployee(projectEmpid);
    }
    
    
}
