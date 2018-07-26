/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.ProjectManagement;

import com.bul.zydex.dao.GenericsDAO;
import java.util.List;

/**
 *
 * @author Aman
 */
public interface ProjectManagementDAO<T> extends GenericsDAO<T>{

    public List<?> readProjectMList();
    
     public List<?> readManagerEmployeeDepart(T object);

    public List<?> deleteProjectManagement(String projectId);

    public List<?> readProjectEmployee(int projectEmpid);
    
}
