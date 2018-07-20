/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Approval;

import com.bul.zydex.dao.Approval.DynamicApprovalSettingEmailDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Admin
 */
public class DynamicApprovalSettingEmailServiceImpl<T> extends GenericsServiceImpl<T> implements DynamicApprovalSettingEmailService<T> {

    protected DynamicApprovalSettingEmailDAO<T> dynamicApprovalSettingEmailDAO;

    public DynamicApprovalSettingEmailDAO<T> getDynamicApprovalSettingEmailDAO() {
        return dynamicApprovalSettingEmailDAO;
    }

    public void setDynamicApprovalSettingEmailDAO(DynamicApprovalSettingEmailDAO<T> dynamicApprovalSettingEmailDAO) {
        this.dynamicApprovalSettingEmailDAO = dynamicApprovalSettingEmailDAO;
        setGenericsDAO(dynamicApprovalSettingEmailDAO);
    }

    @Override
    public List<?> readByApproverCycleId(int ApproverCycleId) {
        return dynamicApprovalSettingEmailDAO.readByApproverCycleId(ApproverCycleId);
    }

    @Override
    public List<?> readByDnamicApprovalSettingId(int ApproverId) {
        return dynamicApprovalSettingEmailDAO.readByDnamicApprovalSettingId(ApproverId);
    }

    @Override
    public void deleteByApproverSettingId(int ApproverId) {
        dynamicApprovalSettingEmailDAO.deleteByApproverSettingId(ApproverId);
    }

    @Override
    public List<?> readByModuleName(String moduleName) {
       return dynamicApprovalSettingEmailDAO.readByModuleName(moduleName);
    }

}
