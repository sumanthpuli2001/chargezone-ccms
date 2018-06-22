/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.ProjectManagement;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.ClientMaster;
import com.bul.zydex.model.ProjectManagementMaster;
import com.bul.zydex.model.StateMaster;
import com.bul.zydex.service.ProjectManagement.ClientMasterService;
import com.bul.zydex.service.ProjectManagement.ProjectManagementService;
import com.bul.zydex.service.ProjectManagement.StateMasterService;

/**
 *
 * @author Aman
 */
public class ProjectManagementAbstract extends CustomAbstract{
    protected ProjectManagementService<ProjectManagementMaster> projectManagementService;
    protected ClientMasterService <ClientMaster> clientMasterService;
    protected StateMasterService <StateMaster> stateMasterService;

    public ProjectManagementService<ProjectManagementMaster> getProjectManagementService() {
        return projectManagementService;
    }

    public void setProjectManagementService(ProjectManagementService<ProjectManagementMaster> projectManagementService) {
        this.projectManagementService = projectManagementService;
    }

    public ClientMasterService<ClientMaster> getClientMasterService() {
        return clientMasterService;
    }

    public void setClientMasterService(ClientMasterService<ClientMaster> clientMasterService) {
        this.clientMasterService = clientMasterService;
    }

    public StateMasterService<StateMaster> getStateMasterService() {
        return stateMasterService;
    }

    public void setStateMasterService(StateMasterService<StateMaster> stateMasterService) {
        this.stateMasterService = stateMasterService;
    }
    
    
    
}
