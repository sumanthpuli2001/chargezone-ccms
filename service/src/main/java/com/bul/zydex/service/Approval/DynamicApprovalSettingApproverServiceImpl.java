/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Approval;

import com.bul.zydex.dao.Approval.DynamicApprovalSettingApproverDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Admin
 */
public class DynamicApprovalSettingApproverServiceImpl<T> extends GenericsServiceImpl<T> implements DynamicApprovalSettingApproverService<T> {

    protected DynamicApprovalSettingApproverDAO<T> dynamicApprovalSettingApproverDAO;

    public DynamicApprovalSettingApproverDAO<T> getDynamicApprovalSettingApproverDAO() {
        return dynamicApprovalSettingApproverDAO;
    }

    public void setDynamicApprovalSettingApproverDAO(DynamicApprovalSettingApproverDAO<T> dynamicApprovalSettingApproverDAO) {
        this.dynamicApprovalSettingApproverDAO = dynamicApprovalSettingApproverDAO;
        setGenericsDAO(dynamicApprovalSettingApproverDAO);
    }

    @Override
    public List<?> readByDnamicApprovalSettingId(int ApproverId) {
        return dynamicApprovalSettingApproverDAO.readByDnamicApprovalSettingId(ApproverId);
    }

    @Override
    public void deleteByApproverSettingId(int ApproverId) {
        dynamicApprovalSettingApproverDAO.deleteByApproverSettingId(ApproverId);
    }

    @Override
    public List<?> getByApproverId(int ApproverId) {
        return dynamicApprovalSettingApproverDAO.getByApproverId(ApproverId);
    }

    @Override
    public List<?> readByzyLocIdCompnameAndDesId(int zlocId, String ComName, int desId, String module) {
        return dynamicApprovalSettingApproverDAO.readByzyLocIdCompnameAndDesId(zlocId, ComName, desId, module);
    }

}
