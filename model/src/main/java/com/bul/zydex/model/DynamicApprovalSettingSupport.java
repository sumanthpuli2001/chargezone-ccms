/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model.support;

/**
 *
 * @author Admin
 */
public class DynamicApprovalSettingSupport {

    public int id;
    public int companyId;
    public int designationMasterId;
    public int moduleId;
    public int zydexLocationMasterId;
    public int approverId;
    public int emailUserId;
    public int projectId;

    public DynamicApprovalSettingSupport() {
    }

    public DynamicApprovalSettingSupport(int id, int companyId, int designationMasterId, int moduleId, int zydexLocationMasterId, int approverId, int emailUserId,int projectId) {
        this.id = id;
        this.companyId = companyId;
        this.designationMasterId = designationMasterId;
        this.moduleId = moduleId;
        this.zydexLocationMasterId = zydexLocationMasterId;
        this.approverId = approverId;
        this.emailUserId = emailUserId;
        this.projectId = projectId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getDesignationMasterId() {
        return designationMasterId;
    }

    public void setDesignationMasterId(int designationMasterId) {
        this.designationMasterId = designationMasterId;
    }

    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }

    public int getZydexLocationMasterId() {
        return zydexLocationMasterId;
    }

    public void setZydexLocationMasterId(int zydexLocationMasterId) {
        this.zydexLocationMasterId = zydexLocationMasterId;
    }

    public int getApproverId() {
        return approverId;
    }

    public void setApproverId(int approverId) {
        this.approverId = approverId;
    }

    public int getEmailUserId() {
        return emailUserId;
    }

    public void setEmailUserId(int emailUserId) {
        this.emailUserId = emailUserId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

}
