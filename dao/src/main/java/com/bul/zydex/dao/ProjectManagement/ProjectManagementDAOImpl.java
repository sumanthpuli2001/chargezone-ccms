/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.ProjectManagement;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.ProjectManagementMaster;

/**
 *
 * @author Aman
 */
public class ProjectManagementDAOImpl<T> extends GenericsDAOImpl<T> implements ProjectManagementDAO<T>{

    @Override
    protected Class getDomainClass() {
        return ProjectManagementMaster.class;
    }
    
}
